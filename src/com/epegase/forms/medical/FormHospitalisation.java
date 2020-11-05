package com.epegase.forms.medical;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.tiers.FormPatients;
import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.CcamMedical;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.CimMedical;
import com.epegase.systeme.classe.ConsultationEnteteGene;
import com.epegase.systeme.classe.ConventionMedical;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureLigneMedical;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.HospitalisationActes;
import com.epegase.systeme.classe.HospitalisationCaution;
import com.epegase.systeme.classe.HospitalisationEntete;
import com.epegase.systeme.classe.HospitalisationLabo;
import com.epegase.systeme.classe.HospitalisationMedi;
import com.epegase.systeme.classe.HospitalisationPrest;
import com.epegase.systeme.classe.HospitalisationReglement;
import com.epegase.systeme.classe.HospitalisationSejour;
import com.epegase.systeme.classe.LettreMedical;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PatientAnt;
import com.epegase.systeme.classe.PatientLettreGarantie;
import com.epegase.systeme.classe.PatientPec;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsServices;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Service;
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
import com.epegase.systeme.dao.CcamMedicalDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.CimMedicalDao;
import com.epegase.systeme.dao.ConsultationEnteteGeneDao;
import com.epegase.systeme.dao.ConventionMedicalDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FactureLigneMedicalDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.HospitalisationActesDao;
import com.epegase.systeme.dao.HospitalisationCautionDao;
import com.epegase.systeme.dao.HospitalisationEnteteDao;
import com.epegase.systeme.dao.HospitalisationLaboDao;
import com.epegase.systeme.dao.HospitalisationMediDao;
import com.epegase.systeme.dao.HospitalisationPrestDao;
import com.epegase.systeme.dao.HospitalisationReglementDao;
import com.epegase.systeme.dao.HospitalisationSejourDao;
import com.epegase.systeme.dao.LettreMedicalDao;
import com.epegase.systeme.dao.PatientAntDao;
import com.epegase.systeme.dao.PatientLettreGarantieDao;
import com.epegase.systeme.dao.PatientPecDao;
import com.epegase.systeme.dao.PatientProtDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsMclesDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.TaxesVentesDao;
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
import com.epegase.systeme.xml.LectureDestination;
import com.epegase.systeme.xml.LectureMotifEntree;
import com.epegase.systeme.xml.LectureMotifSortie;
import com.epegase.systeme.xml.LectureProvenance;
import com.epegase.systeme.xml.ObjetCategories;
import com.epegase.systeme.xml.ObjetLigneOnglet;
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

public class FormHospitalisation implements Serializable {
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
   private OptionMedical optionMedical = new OptionMedical();
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
   private String var_heureDeces;
   private String var_minuteDeces;
   private boolean visibleOnglet = false;
   private boolean var_sansstock = false;
   private boolean var_pr_pv = false;
   private boolean var_aff_detail_tiers = false;
   private boolean var_typeTiers = true;
   private boolean var_affiche_protocole;
   private boolean var_affiche_service;
   private boolean var_affiche_pathologie;
   private boolean var_affiche_prescipteur;
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
   private List mesMedecinsItem = new ArrayList();
   private long var_nom_medecin;
   private List lesMedecins = new ArrayList();
   private UsersChrono usersChrono;
   private UsersChronoDao usersChronoDao;
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
   private String inpEntree = "";
   private String inpProtocole = "";
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
   private List mesBanquesItems;
   private List mesTaxesMedicalItems;
   private boolean tBudget = false;
   private boolean tActivite = false;
   private boolean tParc = false;
   private String var_imput_serie;
   private String var_imput_cat;
   private boolean showModalPanelImput = false;
   private transient DataModel datamodelHospitalisation = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private List lesHospitalisationEntete = new ArrayList();
   private HospitalisationEntete hospitalisationEntete;
   private HospitalisationEnteteDao hospitalisationEnteteDao;
   private List lesProvenancesItems = new ArrayList();
   private List lesDestinationsItems = new ArrayList();
   private List lesMotifsEntreeItems = new ArrayList();
   private List lesMotifsSortieItems = new ArrayList();
   private UtilDate utilDate = new UtilDate();
   private UtilNombre utilNombre = new UtilNombre();
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
   private List mesPecItem = new ArrayList();
   private boolean var_aff_action;
   private List mesProtocoleItems = new ArrayList();
   private boolean var_acc_entree;
   private boolean var_acc_antecedent;
   private boolean var_acc_anamese;
   private boolean var_acc_prestation;
   private boolean var_acc_acte;
   private boolean var_acc_medicament;
   private boolean var_acc_examComplementaire;
   private boolean var_acc_historique;
   private boolean var_acc_sejour;
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
   private boolean showModalpanelPec = false;
   private double totalDocFacture;
   private double totalDocPatient;
   private double totalDocTiers;
   private double totalDocReglement;
   private boolean showModalPanelSejour = false;
   private List lesLitsItems = new ArrayList();
   private List lesSejours = new ArrayList();
   private transient DataModel dataModelSejours = new ListDataModel();
   private HospitalisationSejourDao hospitalisationSejourDao;
   private HospitalisationSejour hospitalisationSejour;
   private boolean afficheButtSejour = false;
   private List mesSejoursItems = new ArrayList();
   private boolean valideSejour;
   private boolean afficheButtLit = false;
   private boolean quitterSejour = false;
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
   private transient DataModel dataModelConsultation = new ListDataModel();
   private List lesConsultations = new ArrayList();
   private ConsultationEnteteGeneDao consultationEnteteGeneDao;
   private boolean afficheButtConsultation = false;
   private boolean showModalPanelConsultation = false;
   private ConsultationEnteteGene consultationEnteteGene;
   private boolean valideConsultation = false;
   private transient DataModel dataModelActes = new ListDataModel();
   private List lesActes = new ArrayList();
   private HospitalisationActes hospitalisationActes;
   private HospitalisationActesDao hospitalisationActesDao;
   private boolean showModalPanelActes = false;
   private boolean griserchamps = false;
   private List mesLettresItems;
   private String var_lettre;
   private float var_pecCnamgs;
   private boolean var_pecAssurance;
   private boolean afficheButtActes;
   private boolean showModalPanelListeActes = false;
   private transient DataModel dataModelActesListe = new ListDataModel();
   private List lesActesCCAM = new ArrayList();
   private CcamMedical ccamMedical = new CcamMedical();
   private CcamMedicalDao ccamMedicalDao;
   private boolean showModalPanelDetailActe = false;
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
   private boolean afficheActeCP = false;
   private boolean valideActe;
   private boolean presenceActeLie;
   private String nomActeLie;
   private float qteActeLie;
   private transient DataModel dataModelMedi = new ListDataModel();
   private List lesMedis = new ArrayList();
   private HospitalisationMedi hospitalisationMedi;
   private HospitalisationMediDao hospitalisationMediDao;
   private boolean afficheButtOrdo;
   private boolean showModalPanelMedi = false;
   private boolean valideMedi;
   private String medicDepot;
   private int var_code_unite;
   private Unite unite = new Unite();
   private UniteDao uniteDao;
   private ProduitsDepotDao produitsDepotDao;
   private ProduitsDepot produitsDepot = new ProduitsDepot();
   private CalculStock calculStock = new CalculStock();
   private float var_memo_qte;
   private transient DataModel dataModelLabo = new ListDataModel();
   private List lesLabos = new ArrayList();
   private HospitalisationLabo hospitalisationLabo;
   private HospitalisationLaboDao hospitalisationLaboDao;
   private boolean afficheButtLabo;
   private boolean showModalPanelLabo = false;
   private boolean valideLabo;
   private List mesImputationLabo = new ArrayList();
   private boolean choixImputationLabo;
   private transient DataModel dataModelPrest = new ListDataModel();
   private List lesPrests = new ArrayList();
   private HospitalisationPrest hospitalisationPrest;
   private HospitalisationPrestDao hospitalisationPrestDao;
   private boolean afficheButtPrest;
   private boolean showModalPanelPrest = false;
   private boolean validePrest;
   private boolean showModalPanelProduits = false;
   private boolean showModalPanelDetailProduits = false;
   private List lesProduits = new ArrayList();
   private transient DataModel datamodelProduits = new ListDataModel();
   private UIDataTable extDTableProduits = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionProduits = new SimpleSelection();
   private transient DataModel datamodelProduitsCCAM = new ListDataModel();
   private UIDataTable extDTableCCAM = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionCCAM = new SimpleSelection();
   private Service service;
   private ProduitsVtesDao produitsMedicDao;
   private ProduitsMclesDao produitsMclesDao;
   private ProduitsServicesDao produitsServicesDao;
   private ProduitsServices produitsServices;
   private int choixPanenProd;
   private TaxesVentes taxesMedical = new TaxesVentes();
   private ProduitsTarif produitsTarif = new ProduitsTarif();
   private List mesDepotsItems = new ArrayList();
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
   private List listCaisses;
   private List mesCaissesSeriesItems = new ArrayList();
   private boolean showModalPanelHistoReglement = false;
   private BonEncaissementVente bonEncaissementVente;
   private BonEncaissementVenteDao bonEncaissementVenteDao;
   private double var_tot_bon_encaissement;
   private boolean var_affiche_be = false;
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
   private double totalPaye;
   private boolean showModalPanelBonEncaissement = false;
   private String var_nom_client;
   private String var_num_facture;
   private String var_montant;
   private double var_totalSejour;
   private double var_totalActes;
   private double var_totalPharmacie;
   private double var_totalLaboratoire;
   private double var_totalPrestation;
   private List lesReglServices = new ArrayList();
   private transient DataModel dataModelRegService = new ListDataModel();
   private ObjetTarif objetTarif;
   private double totalReglement;
   private double totalSolde;
   private HospitalisationReglement hospitalisationReglement;
   private HospitalisationReglementDao hospitalisationReglementDao;
   private List lesReglements = new ArrayList();
   private boolean balanceFinale;
   private boolean paiementPartiel;
   private boolean showModalPanelErreurPaye = false;
   private String var_modereg;
   private List lstReg = new ArrayList();
   private String numLettreGarantie;
   private double montantElmTotReliquat;
   private double reliquatPatient;
   private boolean showModalPanelAnnuler = false;
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
   private List mesServicesFacturesActes = new ArrayList();
   private List mesServicesFacturesLabo = new ArrayList();
   private List mesServicesFacturesMedi = new ArrayList();
   private List mesServicesFacturesPrest = new ArrayList();
   private String servicesFacturesActes;
   private String servicesFacturesLabo;
   private String servicesFacturesMedi;
   private String servicesFacturesPrest;
   private Date dateRefacturation;
   private String numRefacturation;
   private String etatRefacuration;
   private boolean autoriseRefacturation;
   private transient DataModel dataModelCaution = new ListDataModel();
   private List lesCaution = new ArrayList();
   private HospitalisationCaution hospitalisationCaution;
   private HospitalisationCautionDao hospitalisationCautionDao;
   private boolean showModalPanelCaution = false;
   private boolean afficheButtCaution;
   private boolean showModalPanelChangerService = false;
   private String nouveauService;

   public void instanceDaoUtilises() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.hospitalisationEnteteDao = new HospitalisationEnteteDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationSejourDao = new HospitalisationSejourDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationActesDao = new HospitalisationActesDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationMediDao = new HospitalisationMediDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationLaboDao = new HospitalisationLaboDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationPrestDao = new HospitalisationPrestDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationCautionDao = new HospitalisationCautionDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.patientAntDao = new PatientAntDao(this.baseLog, this.utilInitHibernate);
      this.produitsMedicDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      this.produitsMclesDao = new ProduitsMclesDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.cimMedicalDao = new CimMedicalDao(this.baseLog, this.utilInitHibernate);
      this.ccamMedicalDao = new CcamMedicalDao(this.baseLog, this.utilInitHibernate);
      this.patientPecDao = new PatientPecDao(this.baseLog, this.utilInitHibernate);
      this.taxesMedicalDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      this.produitsTarifDao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
      this.conventionMedicalDao = new ConventionMedicalDao(this.baseLog, this.utilInitHibernate);
      this.lettreMedicalDao = new LettreMedicalDao(this.baseLog, this.utilInitHibernate);
      this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      this.produitsServicesDao = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationSejourDao = new HospitalisationSejourDao(this.baseLog, this.utilInitHibernate);
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.bonEncaissementVenteDao = new BonEncaissementVenteDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationReglementDao = new HospitalisationReglementDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.consultationEnteteGeneDao = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
   }

   public void configMedical() {
      this.periode = this.getOptionMedical().getAffichInGlobViewCH();
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

      this.nomRepertoire = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "hospitalisation" + File.separator;
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
      this.var_acc_entree = false;
      this.var_acc_antecedent = false;
      this.var_acc_anamese = false;
      this.var_acc_prestation = false;
      this.var_acc_acte = false;
      this.var_acc_medicament = false;
      this.var_acc_examComplementaire = false;
      this.var_acc_historique = false;
      this.var_acc_sejour = false;
      this.var_acc_reglement = false;
      this.var_acc_etat = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("21")) {
               this.var_acc_entree = true;
            } else if (var1.getCode().equals("22")) {
               this.var_acc_antecedent = true;
            } else if (var1.getCode().equals("23")) {
               this.var_acc_anamese = true;
            } else if (var1.getCode().equals("24")) {
               this.var_acc_prestation = true;
            } else if (var1.getCode().equals("25")) {
               this.var_acc_acte = true;
            } else if (var1.getCode().equals("26")) {
               this.var_acc_medicament = true;
            } else if (var1.getCode().equals("27")) {
               this.var_acc_examComplementaire = true;
            } else if (var1.getCode().equals("28")) {
               this.var_acc_historique = true;
            } else if (var1.getCode().equals("29")) {
               this.var_acc_sejour = true;
            } else if (var1.getCode().equals("30")) {
               this.var_acc_reglement = true;
            } else if (var1.getCode().equals("31")) {
               this.var_acc_etat = true;
            }
         }
      }

   }

   public void autorisationEntree() {
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

   public void autorisationPrestation() {
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

   public void calculMedecinSejour() throws HibernateException, NamingException {
      this.calculMedecinSejour((Session)null);
   }

   public void calculMedecinSejour(Session var1) throws HibernateException, NamingException {
      this.lesMedecins.clear();
      this.lesMedecins = this.usersDao.chargerLesUsersByServices(this.hospitalisationSejour.getHossejService(), var1);
      this.mesMedecinsItem.clear();

      for(int var2 = 0; var2 < this.lesMedecins.size(); ++var2) {
         Users var3 = (Users)this.lesMedecins.get(var2);
         if ((var3.getUsrFonction().contains("Professeur") || var3.getUsrFonction().contains("Médecin")) && var3.getUsrPatronyme() != null && !var3.getUsrPatronyme().isEmpty()) {
            this.mesMedecinsItem.add(new SelectItem(var3.getUsrid(), var3.getUsrPatronyme() + ":" + var3.getUsrMetier()));
         }
      }

      this.verifValideSejour();
   }

   public void calculMedecinPrest() throws HibernateException, NamingException {
      if (this.hospitalisationPrest.getHosprtIdSejour() != 0L) {
         String var1 = "";

         int var2;
         for(var2 = 0; var2 < this.lesSejours.size(); ++var2) {
            if (((HospitalisationSejour)this.lesSejours.get(var2)).getHossejId() == this.hospitalisationPrest.getHosprtIdSejour()) {
               var1 = ((HospitalisationSejour)this.lesSejours.get(var2)).getHossejService();
               break;
            }
         }

         if (var1 != null && !var1.isEmpty()) {
            this.hospitalisationPrest.setHosprtService(var1);
            this.lesMedecins.clear();
            this.lesMedecins = this.usersDao.chargerLesUsersByServices(var1, (Session)null);
            this.mesMedecinsItem.clear();

            for(var2 = 0; var2 < this.lesMedecins.size(); ++var2) {
               Users var3 = (Users)this.lesMedecins.get(var2);
               if ((var3.getUsrFonction().contains("Professeur") || var3.getUsrFonction().contains("Médecin")) && var3.getUsrPatronyme() != null && !var3.getUsrPatronyme().isEmpty()) {
                  this.mesMedecinsItem.add(new SelectItem(var3.getUsrid(), var3.getUsrPatronyme() + ":" + var3.getUsrMetier()));
               }
            }
         }
      }

      this.verifValidePrestation();
   }

   public void calculMedecinActe() throws HibernateException, NamingException {
      String var1 = "";
      if (this.hospitalisationActes != null && this.hospitalisationActes.getHosactIdSejour() != 0L) {
         int var2;
         for(var2 = 0; var2 < this.lesSejours.size(); ++var2) {
            if (((HospitalisationSejour)this.lesSejours.get(var2)).getHossejId() == this.hospitalisationActes.getHosactIdSejour()) {
               var1 = ((HospitalisationSejour)this.lesSejours.get(var2)).getHossejService();
               break;
            }
         }

         if (var1 != null && !var1.isEmpty()) {
            this.hospitalisationActes.setHosactService(var1);
            this.lesMedecins.clear();
            this.lesMedecins = this.usersDao.chargerLesUsersByServices(var1, (Session)null);
            this.mesMedecinsItem.clear();

            for(var2 = 0; var2 < this.lesMedecins.size(); ++var2) {
               Users var3 = (Users)this.lesMedecins.get(var2);
               if ((var3.getUsrFonction().contains("Professeur") || var3.getUsrFonction().contains("Médecin")) && var3.getUsrPatronyme() != null && !var3.getUsrPatronyme().isEmpty()) {
                  this.mesMedecinsItem.add(new SelectItem(var3.getUsrid(), var3.getUsrPatronyme() + ":" + var3.getUsrMetier()));
               }
            }
         }
      }

      this.verifValideActe();
   }

   public void calculMedecinMedi() throws HibernateException, NamingException {
      if (this.hospitalisationMedi.getHosmedIdSejour() != 0L) {
         String var1 = "";

         int var2;
         for(var2 = 0; var2 < this.lesSejours.size(); ++var2) {
            if (((HospitalisationSejour)this.lesSejours.get(var2)).getHossejId() == this.hospitalisationMedi.getHosmedIdSejour()) {
               var1 = ((HospitalisationSejour)this.lesSejours.get(var2)).getHossejService();
               break;
            }
         }

         if (var1 != null && !var1.isEmpty()) {
            this.hospitalisationMedi.setHosmedService(var1);
            this.lesMedecins.clear();
            this.lesMedecins = this.usersDao.chargerLesUsersByServices(var1, (Session)null);
            this.mesMedecinsItem.clear();

            for(var2 = 0; var2 < this.lesMedecins.size(); ++var2) {
               Users var3 = (Users)this.lesMedecins.get(var2);
               if ((var3.getUsrFonction().contains("Professeur") || var3.getUsrFonction().contains("Médecin")) && var3.getUsrPatronyme() != null && !var3.getUsrPatronyme().isEmpty()) {
                  this.mesMedecinsItem.add(new SelectItem(var3.getUsrid(), var3.getUsrPatronyme() + ":" + var3.getUsrMetier()));
               }
            }
         }
      }

      this.verifValideMedicamment();
   }

   public void calculMedecinLabo() throws HibernateException, NamingException {
      if (this.hospitalisationLabo.getHoslabIdSejour() != 0L) {
         String var1 = "";

         int var2;
         for(var2 = 0; var2 < this.lesSejours.size(); ++var2) {
            if (((HospitalisationSejour)this.lesSejours.get(var2)).getHossejId() == this.hospitalisationLabo.getHoslabIdSejour()) {
               var1 = ((HospitalisationSejour)this.lesSejours.get(var2)).getHossejService();
               break;
            }
         }

         if (var1 != null && !var1.isEmpty()) {
            this.hospitalisationLabo.setHoslabService(var1);
            this.lesMedecins.clear();
            this.lesMedecins = this.usersDao.chargerLesUsersByServices(var1, (Session)null);
            this.mesMedecinsItem.clear();

            for(var2 = 0; var2 < this.lesMedecins.size(); ++var2) {
               Users var3 = (Users)this.lesMedecins.get(var2);
               if ((var3.getUsrFonction().contains("Professeur") || var3.getUsrFonction().contains("Médecin")) && var3.getUsrPatronyme() != null && !var3.getUsrPatronyme().isEmpty()) {
                  this.mesMedecinsItem.add(new SelectItem(var3.getUsrid(), var3.getUsrPatronyme() + ":" + var3.getUsrMetier()));
               }
            }
         }
      }

      this.verifValideLaboratoire();
   }

   public void calculMedecinConsultation() throws HibernateException, NamingException {
      if (this.consultationEnteteGene.getCsgIdSejour() != 0L) {
         String var1 = "";

         int var2;
         for(var2 = 0; var2 < this.lesSejours.size(); ++var2) {
            if (((HospitalisationSejour)this.lesSejours.get(var2)).getHossejId() == this.consultationEnteteGene.getCsgIdSejour()) {
               var1 = ((HospitalisationSejour)this.lesSejours.get(var2)).getHossejService();
               break;
            }
         }

         if (var1 != null && !var1.isEmpty()) {
            this.consultationEnteteGene.setCsgService(var1);
            this.lesMedecins.clear();
            this.lesMedecins = this.usersDao.chargerLesUsersByServices(var1, (Session)null);
            this.mesMedecinsItem.clear();

            for(var2 = 0; var2 < this.lesMedecins.size(); ++var2) {
               Users var3 = (Users)this.lesMedecins.get(var2);
               if ((var3.getUsrFonction().contains("Professeur") || var3.getUsrFonction().contains("Médecin")) && var3.getUsrPatronyme() != null && !var3.getUsrPatronyme().isEmpty()) {
                  this.mesMedecinsItem.add(new SelectItem(var3.getUsrid(), var3.getUsrPatronyme() + ":" + var3.getUsrMetier()));
               }
            }
         }
      }

      this.verifValideConsultation();
   }

   public void recupererHospitItem(Session var1) throws IOException, HibernateException, NamingException {
      this.lesProvenancesItems.clear();
      LectureProvenance var2 = new LectureProvenance();
      this.lesProvenancesItems = var2.getMesProvenanceItems();
      this.lesDestinationsItems.clear();
      LectureDestination var3 = new LectureDestination();
      this.lesDestinationsItems = var3.getMesDestinationItems();
      this.lesMotifsEntreeItems.clear();
      LectureMotifEntree var4 = new LectureMotifEntree();
      this.lesMotifsEntreeItems = var4.getMesMotifEntreeItems();
      this.lesMotifsSortieItems.clear();
      LectureMotifSortie var5 = new LectureMotifSortie();
      this.lesMotifsSortieItems = var5.getMesMotifSortieItems();
      this.lesLitsItems.clear();
      new ArrayList();
      List var6 = this.produitsMedicDao.verifProduitsByNature("1101", var1);
      this.lesLitsItems.add(new SelectItem("0", "Sélectionnez un lit"));
      if (var6.size() != 0) {
         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.lesLitsItems.add(new SelectItem(((Produits)var6.get(var7)).getProCode(), ((Produits)var6.get(var7)).getProLibClient()));
         }
      }

   }

   public void chargerMedecinService() throws HibernateException, NamingException {
      this.mesMedecinsItem.clear();
      String var1 = "";
      if (this.nouveauService != null && !this.nouveauService.isEmpty()) {
         var1 = this.nouveauService;
      } else if (this.hospitalisationSejour.getHossejService() != null && !this.hospitalisationSejour.getHossejService().isEmpty()) {
         var1 = this.hospitalisationSejour.getHossejService();
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
      this.formPatients.moduleRecherchePatients(this.nature, this.optionMedical);
   }

   public void validerTiers() throws HibernateException, NamingException {
      this.patients = this.formPatients.moduleCalculePatients();
      boolean var1 = false;
      if (this.patients != null) {
         new ArrayList();
         List var2 = this.hospitalisationEnteteDao.chargerLesMvtsPatients(this.patients, (Session)null);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               if (((HospitalisationEntete)var2.get(var3)).getHosEtat() != 2 && ((HospitalisationEntete)var2.get(var3)).getHosEtat() != 3 && ((HospitalisationEntete)var2.get(var3)).getHosDateSortie() == null) {
                  var1 = true;
                  break;
               }
            }
         }
      }

      if (!var1) {
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
      } else {
         this.formRecherche.setMessageTexte("La dernière hospitalisation n'est pas cloturée. Une nouvelle hospitalisation sur ce patient est impossible. Veuillez vous rapprocher du bureau des entrées pour statuer sur la dernière hospitalisation.");
         this.formRecherche.setShowModalPanelMessage(true);
      }

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
      if (this.formPatients.moduleMajPatient()) {
         this.var_action = this.var_memo_action;
      }

   }

   public void ajouterPatient() throws HibernateException, NamingException {
      this.formPatients.moduleAjouterPatient();
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
      this.hospitalisationEntete.setPatients(this.patients);
      this.hospitalisationEntete.setHosIdPatient(this.patients.getPatId());
      if (this.patients.getPatPrenom() != null && !this.patients.getPatPrenom().isEmpty()) {
         this.hospitalisationEntete.setHosNomPatient(this.patients.getPatNom() + " " + this.patients.getPatPrenom());
      } else {
         this.hospitalisationEntete.setHosNomPatient(this.patients.getPatNom());
      }

      this.hospitalisationEntete.setHosCivilite(this.patients.getPatCivilite());
      this.hospitalisationEntete.setHosPecCnamgs(0.0F);
      this.nomFamille = (long)this.patients.getPatNomFamille();
      this.hospitalisationEntete.setHosFam(this.nomFamille);
      this.nomComplementaire = this.patients.getPatPecComplementaire();
      this.hospitalisationEntete.setHosComplementaire(this.nomComplementaire);
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
      }

      this.dataModelAntecedent.setWrappedData(this.lesPatientAntecedent);
      this.mesCategoriesItems.clear();
      this.mesComplementaireItems.clear();
      this.var_pecAssurance = false;
      new ArrayList();
      List var3 = this.patientPecDao.chargerLesPatientsPec(this.patients, 0, var1);
      int var4;
      if (var3.size() != 0) {
         for(var4 = 0; var4 < var3.size(); ++var4) {
            if ((((PatientPec)var3.get(var4)).getPatpecInactif() == 0 || ((PatientPec)var3.get(var4)).getTiers().getTieid() == this.hospitalisationEntete.getHosIdAssurance() || ((PatientPec)var3.get(var4)).getTiers().getTieid() == this.hospitalisationEntete.getHosIdSociete() || ((PatientPec)var3.get(var4)).getTiers().getTieid() == this.hospitalisationEntete.getHosIdComplementaire()) && ((PatientPec)var3.get(var4)).getPatpecType() != null && !((PatientPec)var3.get(var4)).getPatpecType().isEmpty()) {
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

   public void executerRequete() throws IOException, HibernateException, NamingException, ParseException, groovyjarjarcommonscli.ParseException {
      this.chargeListeDetail((Session)null);
   }

   public void chargeListeDetail(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesHospitalisationEntete.clear();
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
      int var18;
      if (this.inpEtat != 50) {
         this.inpSerie = "100";
         if (this.inpService != null && !this.inpService.isEmpty() && this.inpService.contains(":")) {
            new ArrayList();
            List var17 = this.hospitalisationSejourDao.rechercheHospitalisation(var1, this.getInpNum(), this.getInpNomPatient(), this.getInpPrenomPatient(), this.getInpTel(), this.getInpCi(), this.getInpDossier(), this.getInpSociete(), this.getInpAssurance(), this.getInpComplementaire(), this.getInpContrat(), this.getInpEtat(), this.getInpSerie(), this.getInpCat(), this.getPeriode(), this.getInpService(), this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.getInpProtocole(), this.getInpMedecin(), this.getInpActivite(), var14, var15);
            if (var17.size() != 0) {
               for(var18 = 0; var18 < var17.size(); ++var18) {
                  this.hospitalisationEntete = ((HospitalisationSejour)var17.get(var18)).getHospitalisationEntete();
                  this.patients = this.hospitalisationEntete.getPatients();
                  ((List)var16).add(this.hospitalisationEntete);
               }
            }
         } else {
            var16 = this.hospitalisationEnteteDao.rechercheHospitalisation(var1, this.exercicesVentes.getExevteId(), this.getInpNum(), this.getInpNomPatient(), this.getInpPrenomPatient(), this.getInpTel(), this.getInpCi(), this.getInpDossier(), this.getInpSociete(), this.getInpAssurance(), this.getInpComplementaire(), this.getInpContrat(), this.getInpEtat(), this.getInpSerie(), this.getInpCat(), this.getPeriode(), (String)null, this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.getInpProtocole(), this.getInpMedecin(), this.getInpActivite(), var14, var15);
         }
      }

      int var19;
      if (this.inpEtat == 13) {
         if (((List)var16).size() != 0) {
            for(var19 = 0; var19 < ((List)var16).size(); ++var19) {
               if (((HospitalisationEntete)((List)var16).get(var19)).getHosEtat() == 1 || ((HospitalisationEntete)((List)var16).get(var19)).getHosEtat() == 4 || ((HospitalisationEntete)((List)var16).get(var19)).getHosEtat() == 5 || ((HospitalisationEntete)((List)var16).get(var19)).getHosEtat() == 6) {
                  this.lesHospitalisationEntete.add(((List)var16).get(var19));
               }
            }
         }
      } else if (this.inpEtat == 15) {
         for(var19 = 0; var19 < ((List)var16).size(); ++var19) {
            if (((HospitalisationEntete)((List)var16).get(var19)).getHosEtat() == 6) {
               this.lesHospitalisationEntete.add(((List)var16).get(var19));
            }
         }
      } else if (this.inpEtat != 17 && this.inpEtat != 18) {
         this.lesHospitalisationEntete = (List)var16;
      } else {
         for(var19 = 0; var19 < ((List)var16).size(); ++var19) {
            if (((HospitalisationEntete)((List)var16).get(var19)).getHosEtat() == 5 || ((HospitalisationEntete)((List)var16).get(var19)).getHosEtat() == 6) {
               this.lesHospitalisationEntete.add(((List)var16).get(var19));
            }
         }
      }

      this.datamodelHospitalisation.setWrappedData(this.lesHospitalisationEntete);
      if (this.lesHospitalisationEntete.size() != 0) {
         new HospitalisationEntete();

         for(var18 = 0; var18 < this.lesHospitalisationEntete.size(); ++var18) {
            HospitalisationEntete var20 = (HospitalisationEntete)this.lesHospitalisationEntete.get(var18);
            var2 += var20.getHosTotPatient();
            var4 += var20.getHosTotTaxePatient();
            var6 = var6 + var20.getHosTotAssurance() + var20.getHosTotSociete() + var20.getHosTotComplmentaire();
            var8 = var8 + var20.getHosTotTaxeAssurance() + var20.getHosTotTaxeSociete() + var20.getHosTotTaxeComplementaire();
            var10 += var20.getHosRegPatient();
            var12 += var20.getHosRegTiers();
         }

         this.var_nb_ligne = this.lesHospitalisationEntete.size();
      }

      this.totalPatient = var2 + var4;
      this.totalTiers = var6 + var8;
      this.regPatient = var10;
      this.regTiers = var12;
      this.soldePatient = var2 + var4 - var10;
      this.soldeTiers = var6 + var8 - var12;
      this.visibiliteBton = false;
   }

   public void selectionHospitalisation() throws HibernateException, NamingException, JDOMException, IOException {
      this.hospitalisationEntete = new HospitalisationEntete();
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
            this.hospitalisationEntete = (HospitalisationEntete)var1.get(0);
            this.var_pecCnamgs = this.hospitalisationEntete.getHosPecCnamgs();
            this.nomFamille = this.hospitalisationEntete.getHosFam();
            this.nomComplementaire = this.hospitalisationEntete.getHosComplementaire();
            if (this.hospitalisationEntete.getHosIdAssurance() != 0L) {
               this.var_pecAssurance = true;
            } else {
               this.var_pecAssurance = false;
            }

            this.var_nom_medecin = this.hospitalisationEntete.getHosIdMedecin();
            if (this.hospitalisationEntete.getHosDateEntree() == null) {
               this.var_date = new Date();
               this.hospitalisationEntete.setHosDateEntree(new Date());
            }

            this.var_date = this.hospitalisationEntete.getHosDateEntree();
            if (this.hospitalisationEntete.getHosDateEntree().getHours() <= 9) {
               this.var_heure = "0" + this.hospitalisationEntete.getHosDateEntree().getHours();
            } else {
               this.var_heure = "" + this.hospitalisationEntete.getHosDateEntree().getHours();
            }

            if (this.hospitalisationEntete.getHosDateEntree().getMinutes() <= 9) {
               this.var_minute = "0" + this.hospitalisationEntete.getHosDateEntree().getMinutes();
            } else {
               this.var_minute = "" + this.hospitalisationEntete.getHosDateEntree().getMinutes();
            }

            if (this.hospitalisationEntete.getHosDateEntree().getSeconds() <= 9) {
               this.var_seconde = "0" + this.hospitalisationEntete.getHosDateEntree().getSeconds();
            } else {
               this.var_seconde = "" + this.hospitalisationEntete.getHosDateEntree().getSeconds();
            }

            this.patients = this.hospitalisationEntete.getPatients();
            Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
            this.afficheButtActes = false;
            this.afficheButtAntecedent = false;
            this.afficheButtCaution = false;
            this.afficheButtOrdo = false;
            this.afficheButtLabo = false;
            this.afficheButtConsultation = false;
            this.afficheButtLit = false;
            this.afficheButtPrest = false;
            this.afficheButtSejour = false;
            this.chargerPriseEnCharges(var6);
            this.elementPatient(var6);
            this.chargerSejour(var6);
            this.chargerConsultation(var6);
            this.chargerActes(var6);
            this.chargerMedi(var6);
            this.chargerLabo(var6);
            this.chargerPrest(var6);
            double var4 = this.chargerBonEncaissement(var6);
            this.chargerUserChrono(var6);
            this.chargerDocumentScan();
            this.calculTotaux();
            this.utilInitHibernate.closeSession();
            if (this.hospitalisationEntete.getHosRegPatient() != var4) {
               this.hospitalisationEntete.setHosRegPatient(var4);
               if (var4 >= this.hospitalisationEntete.getHosTotPatient()) {
                  this.hospitalisationEntete.setHosSoldePatient(1);
               } else {
                  this.hospitalisationEntete.setHosSoldePatient(0);
               }

               this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete);
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
      if (this.hospitalisationEntete != null) {
         if (this.hospitalisationEntete.getHosEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void chargerPriseEnCharges(Session var1) throws HibernateException, NamingException {
      this.patientPec = null;
      this.patientPecComplementaire = null;
      if (this.hospitalisationEntete.getHosFam() != 0L) {
         this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 0, var1);
      }

      if (this.hospitalisationEntete.getHosComplementaire() != 0L) {
         this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosComplementaire(), 0, var1);
      }

   }

   public void chargerSejour(Session var1) throws HibernateException, NamingException {
      this.lesSejours.clear();
      this.lesSejours = this.hospitalisationSejourDao.selectSejourByEnt(this.hospitalisationEntete, var1);
      this.dataModelSejours.setWrappedData(this.lesSejours);
      if (this.lesSejours.size() != 0) {
         this.afficheButtSejour = true;
         int var2 = this.lesSejours.size() - 1;
         this.hospitalisationSejour = (HospitalisationSejour)this.lesSejours.get(var2);
         this.verifValideSejour();
      } else {
         this.afficheButtSejour = false;
         this.valideSejour = false;
      }

   }

   public void chargerConsultation(Session var1) throws HibernateException, NamingException {
      this.lesConsultations.clear();
      this.lesConsultations = this.consultationEnteteGeneDao.selectConsultationByHospit(this.hospitalisationEntete.getHosNum(), this.hospitalisationEntete.getHosIdPatient(), var1);
      this.dataModelConsultation.setWrappedData(this.lesConsultations);
      this.afficheButtConsultation = false;
   }

   public void chargerActes(Session var1) throws HibernateException, NamingException {
      this.lesActes.clear();
      this.lesActes = this.hospitalisationActesDao.selectActesByEnt(this.hospitalisationEntete, var1);
      this.dataModelActes.setWrappedData(this.lesActes);
      this.afficheButtActes = false;
   }

   public void chargerMedi(Session var1) throws HibernateException, NamingException {
      this.lesMedis.clear();
      this.lesMedis = this.hospitalisationMediDao.selectMediByEnt(this.hospitalisationEntete, var1);
      this.dataModelMedi.setWrappedData(this.lesMedis);
      this.afficheButtOrdo = false;
   }

   public void chargerLabo(Session var1) throws HibernateException, NamingException {
      this.lesLabos.clear();
      this.lesLabos = this.hospitalisationLaboDao.selectLaboByEnt(this.hospitalisationEntete, var1);
      this.dataModelLabo.setWrappedData(this.lesLabos);
      this.afficheButtLabo = false;
   }

   public void chargerPrest(Session var1) throws HibernateException, NamingException {
      this.lesPrests.clear();
      this.lesPrests = this.hospitalisationPrestDao.selectPrestByEnt(this.hospitalisationEntete, var1);
      this.dataModelPrest.setWrappedData(this.lesPrests);
      this.afficheButtPrest = false;
   }

   public double chargerBonEncaissement(Session var1) throws HibernateException, NamingException {
      this.lesCaution.clear();
      this.lesCaution = this.hospitalisationCautionDao.selectReglementByEnt(this.hospitalisationEntete, var1);
      this.dataModelCaution.setWrappedData(this.lesCaution);
      this.var_tot_bon_encaissement = 0.0D;
      new ArrayList();
      List var2 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.hospitalisationEntete.getHosId(), this.nature, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((BonEncaissementVente)var2.get(var3)).getBonEtat() == 0) {
               this.var_tot_bon_encaissement = this.var_tot_bon_encaissement + ((BonEncaissementVente)var2.get(var3)).getBonAPayer() + ((BonEncaissementVente)var2.get(var3)).getBonAPayerReliquat();
            }
         }
      }

      this.lstReg.clear();
      this.lstReg = this.reglementsDao.reglementDocument(this.hospitalisationEntete.getHosId(), this.nature, var1);
      double var7 = 0.0D;
      this.afficheRecu = false;
      if (this.lstReg.size() != 0) {
         this.afficheRecu = true;
         new Reglements();

         for(int var6 = 0; var6 < this.lstReg.size(); ++var6) {
            Reglements var5 = (Reglements)this.lstReg.get(var6);
            this.var_tot_bon_encaissement = this.var_tot_bon_encaissement + var5.getRglRecette() - var5.getRglDepense();
            var7 += ((Reglements)this.lstReg.get(var6)).getRglRecette();
         }
      }

      this.datamodelRecu.setWrappedData(this.lstReg);
      if (this.hospitalisationEntete.getHosEtat() <= 1) {
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

      return var7;
   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.hospitalisationEntete != null && this.hospitalisationEntete.getHosSerie() != null && !this.hospitalisationEntete.getHosSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.hospitalisationEntete.getHosSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerDocumentScan() throws IOException {
      this.lesDocuments.clear();
      if (this.nomRepertoire != null && !this.nomRepertoire.isEmpty()) {
         File var1 = new File(this.nomRepertoire);
         if (!var1.exists()) {
            var1.mkdir();
         }

         String var2 = "H_" + this.hospitalisationEntete.getHosNum().replace("/", "_");
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
         if (this.hospitalisationEntete.getHosId() > 0L) {
            FactureLigneMedicalDao var4 = new FactureLigneMedicalDao(this.baseLog, this.utilInitHibernate);
            var1 = var4.chargerLesLignesFacturesByDocument(this.hospitalisationEntete.getHosNum(), 76, var2);
            if (((List)var1).size() != 0) {
               if (this.hospitalisationEntete.getHosEtat() <= 5) {
                  this.hospitalisationEntete.setHosEtat(6);
                  this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var2);
               }
            } else if (this.hospitalisationEntete.getHosEtat() >= 6) {
               this.hospitalisationEntete.setHosEtat(5);
               this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var2);
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

   public void calculTotaux() throws HibernateException, NamingException {
      if (this.hospitalisationEntete.getHosPathologie() == null || this.hospitalisationEntete.getHosPathologie().isEmpty() || !this.hospitalisationEntete.getHosPathologie().contains(":") || this.hospitalisationEntete.getHosPathologie().equals("100")) {
         this.hospitalisationEntete.setHosPathologie("");
      }

      if (this.hospitalisationEntete.getHosProtocole() == null || this.hospitalisationEntete.getHosProtocole().isEmpty() || !this.hospitalisationEntete.getHosProtocole().contains(":") || this.hospitalisationEntete.getHosProtocole().equals("100")) {
         this.hospitalisationEntete.setHosProtocole("");
      }

      if (this.hospitalisationEntete.getHosService() == null || this.hospitalisationEntete.getHosService().isEmpty() || !this.hospitalisationEntete.getHosService().contains(":") || this.hospitalisationEntete.getHosService().equals("100")) {
         this.hospitalisationEntete.setHosService("");
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
      double var23 = 0.0D;
      this.var_totalSejour = 0.0D;
      this.var_totalActes = 0.0D;
      this.var_totalPharmacie = 0.0D;
      this.var_totalLaboratoire = 0.0D;
      this.var_totalPrestation = 0.0D;
      int var26;
      if (this.lesSejours.size() != 0) {
         new HospitalisationSejour();

         for(var26 = 0; var26 < this.lesSejours.size(); ++var26) {
            HospitalisationSejour var25 = (HospitalisationSejour)this.lesSejours.get(var26);
            this.var_totalSejour = this.var_totalSejour + var25.getHossejPatientHt() + var25.getHossejPatientTaxe();
            var7 += var25.getHossejPatientHt();
            var9 += var25.getHossejPatientTaxe();
            var11 += var25.getHossejSocieteHt();
            var13 += var25.getHossejSocieteTaxe();
            var15 += var25.getHossejAssuranceHt();
            var17 += var25.getHossejAssuranceTaxe();
            var19 += var25.getHossejComplementaireHt();
            var21 += var25.getHossejComplementaireTaxe();
            var23 += var25.getHossejRabais();
         }
      }

      if (this.lesCaution.size() != 0) {
         new HospitalisationCaution();

         for(var26 = 0; var26 < this.lesCaution.size(); ++var26) {
            HospitalisationCaution var27 = (HospitalisationCaution)this.lesCaution.get(var26);
            if (var27.getHoscauIdRecu() != 0L) {
               var1 += var27.getHoscauMontant();
            }
         }
      }

      if (this.lesActes.size() != 0) {
         new HospitalisationActes();

         for(var26 = 0; var26 < this.lesActes.size(); ++var26) {
            HospitalisationActes var28 = (HospitalisationActes)this.lesActes.get(var26);
            this.var_totalActes = this.var_totalActes + var28.getHosactPatientHt() + var28.getHosactPatientTaxe();
            var7 += var28.getHosactPatientHt();
            var9 += var28.getHosactPatientTaxe();
            var11 += var28.getHosactSocieteHt();
            var13 += var28.getHosactSocieteTaxe();
            var15 += var28.getHosactAssuranceHt();
            var17 += var28.getHosactAssuranceTaxe();
            var19 += var28.getHosactComplementaireHt();
            var21 += var28.getHosactComplementaireTaxe();
            var23 += var28.getHosactRabais();
         }
      }

      if (this.lesMedis.size() != 0) {
         new HospitalisationMedi();

         for(var26 = 0; var26 < this.lesMedis.size(); ++var26) {
            HospitalisationMedi var29 = (HospitalisationMedi)this.lesMedis.get(var26);
            this.var_totalPharmacie = this.var_totalPharmacie + var29.getHosmedPatientHt() + var29.getHosmedPatientTaxe();
            var7 += var29.getHosmedPatientHt();
            var9 += var29.getHosmedPatientTaxe();
            var11 += var29.getHosmedSocieteHt();
            var13 += var29.getHosmedSocieteTaxe();
            var15 += var29.getHosmedAssuranceHt();
            var17 += var29.getHosmedAssuranceTaxe();
            var19 += var29.getHosmedComplementaireHt();
            var21 += var29.getHosmedComplementaireTaxe();
            var23 += var29.getHosmedRabais();
         }
      }

      if (this.lesLabos.size() != 0) {
         new HospitalisationLabo();

         for(var26 = 0; var26 < this.lesLabos.size(); ++var26) {
            HospitalisationLabo var30 = (HospitalisationLabo)this.lesLabos.get(var26);
            this.var_totalLaboratoire = this.var_totalLaboratoire + var30.getHoslabPatientHt() + var30.getHoslabPatientTaxe();
            var7 += var30.getHoslabPatientHt();
            var9 += var30.getHoslabPatientTaxe();
            var11 += var30.getHoslabSocieteHt();
            var13 += var30.getHoslabSocieteTaxe();
            var15 += var30.getHoslabAssuranceHt();
            var17 += var30.getHoslabAssuranceTaxe();
            var19 += var30.getHoslabComplementaireHt();
            var21 += var30.getHoslabComplementaireTaxe();
            var23 += var30.getHoslabRabais();
         }
      }

      if (this.lesPrests.size() != 0) {
         new HospitalisationPrest();

         for(var26 = 0; var26 < this.lesPrests.size(); ++var26) {
            HospitalisationPrest var31 = (HospitalisationPrest)this.lesPrests.get(var26);
            this.var_totalPrestation = this.var_totalPrestation + var31.getHosprtPatientHt() + var31.getHosprtPatientTaxe();
            var7 += var31.getHosprtPatientHt();
            var9 += var31.getHosprtPatientTaxe();
            var11 += var31.getHosprtSocieteHt();
            var13 += var31.getHosprtSocieteTaxe();
            var15 += var31.getHosprtAssuranceHt();
            var17 += var31.getHosprtAssuranceTaxe();
            var19 += var31.getHosprtComplementaireHt();
            var21 += var31.getHosprtComplementaireTaxe();
            var23 += var31.getHosprtRabais();
         }
      }

      var3 = var7 + var11 + var15 + var19;
      var5 = var9 + var13 + var17 + var21;
      this.hospitalisationEntete.setHosTotPatient(var7);
      this.hospitalisationEntete.setHosTotTaxePatient(var9);
      this.hospitalisationEntete.setHosTotSociete(var11);
      this.hospitalisationEntete.setHosTotTaxeSociete(var13);
      this.hospitalisationEntete.setHosTotAssurance(var15);
      this.hospitalisationEntete.setHosTotTaxeAssurance(var17);
      this.hospitalisationEntete.setHosTotComplmentaire(var19);
      this.hospitalisationEntete.setHosTotTaxeComplementaire(var21);
      this.hospitalisationEntete.setHosTotGeneral(var3);
      this.hospitalisationEntete.setHosTotTaxeGeneral(var5);
      this.hospitalisationEntete.setHosTotCaution(var1);
      this.hospitalisationEntete.setHosTotRabais(var23);
      this.var_tot_tiers = var11 + var15 + var19;
      this.var_tot_reg = this.hospitalisationEntete.getHosRegPatient() + this.hospitalisationEntete.getHosRegTiers();
      this.var_solde = this.hospitalisationEntete.getHosTotGeneral() - this.var_tot_reg;
      this.totalDocFacture = var3 + var5;
      this.totalDocPatient = var7 + var9;
      this.totalDocReglement = this.var_tot_reg;
      this.totalDocTiers = var11 + var13 + var15 + var17 + var19 + var21;
   }

   public void calculeEtat() throws HibernateException, NamingException {
      if (this.hospitalisationEntete != null) {
         this.dateRefacturation = null;
         this.numRefacturation = "";
         this.etatRefacuration = "";
         this.autoriseRefacturation = false;
         new FactureLigneMedical();
         FactureLigneMedicalDao var2 = new FactureLigneMedicalDao(this.baseLog, this.utilInitHibernate);
         FactureLigneMedical var1 = var2.rechercheFactureByHospitalisation(this.hospitalisationEntete.getHosNum(), (Session)null);
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
      if (this.hospitalisationEntete != null) {
         this.hospitalisationEntete.setHosBloqueRefacturation(true);
         this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete);
      }

   }

   public void deBloqueFacturation() throws HibernateException, NamingException {
      if (this.hospitalisationEntete != null) {
         this.hospitalisationEntete.setHosBloqueRefacturation(false);
         this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete);
      }

   }

   public void ajoutDocument() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      this.lesMedecins.clear();
      this.mesMedecinsItem.clear();
      this.lesPatientAntecedent.clear();
      this.dataModelAntecedent.setWrappedData(this.lesPatientAntecedent);
      this.lesPatientAntecedent.clear();
      this.dataModelAntecedent.setWrappedData(this.lesPatientAntecedent);
      this.afficheButtSejour = false;
      this.lesSejours.clear();
      this.dataModelSejours.setWrappedData(this.lesSejours);
      this.afficheButtActes = false;
      this.lesActes.clear();
      this.dataModelActes.setWrappedData(this.lesActes);
      this.afficheButtOrdo = false;
      this.lesMedis.clear();
      this.dataModelMedi.setWrappedData(this.lesMedis);
      this.afficheButtLabo = false;
      this.lesLabos.clear();
      this.dataModelLabo.setWrappedData(this.lesLabos);
      this.afficheButtPrest = false;
      this.lesPrests.clear();
      this.dataModelPrest.setWrappedData(this.lesPrests);
      this.lesCaution.clear();
      this.dataModelCaution.setWrappedData(this.lesCaution);
      this.lesReglements.clear();
      this.datamodelRecu.setWrappedData(this.lesReglements);
      this.lesDocuments.clear();
      this.dataModelDocumnts.setWrappedData(this.lesDocuments);
      this.hospitalisationEntete = new HospitalisationEntete();
      this.mesCategoriesItems.clear();
      this.afficheButtLit = false;
      this.nomFamille = 0L;
      this.nomComplementaire = 0L;
      this.patientPec = null;
      this.patientPecComplementaire = null;
      this.choixImputationLabo = false;
      this.mesImputationLabo.clear();
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

      this.hospitalisationEntete.setHosIdCreateur(this.usersLog.getUsrid());
      this.hospitalisationEntete.setHosNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.hospitalisationEntete.setHosIdMedecin(this.usersLog.getUsrid());
      this.hospitalisationEntete.setHosMedecin(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.hospitalisationEntete.setHosDateEntree(new Date());
      this.hospitalisationEntete.setHosDateCreat(new Date());
      this.hospitalisationEntete.setHosDateModif((Date)null);
      this.hospitalisationEntete.setHosIdModif(0L);
      this.hospitalisationEntete.setHosNomModif("");
      this.hospitalisationEntete.setHosNum("");
      this.var_nom_medecin = 0L;
      this.var_date = new Date();
      this.chargerModeEcheance();
      this.var_tot_bon_encaissement = 0.0D;
      this.var_aff_action = false;
      this.visibleOnglet = false;
      this.afficheButtActes = false;
      this.afficheButtAntecedent = false;
      this.afficheButtCaution = false;
      this.afficheButtOrdo = false;
      this.afficheButtLabo = false;
      this.afficheButtConsultation = false;
      this.afficheButtLit = false;
      this.afficheButtPrest = false;
      this.afficheButtSejour = false;
      this.showModalpanelPec = false;
      this.totalDocFacture = 0.0D;
      this.totalDocPatient = 0.0D;
      this.totalDocReglement = 0.0D;
      this.totalDocTiers = 0.0D;
      this.var_memo_action = this.var_action;
   }

   public void modifDocument() throws JDOMException, IOException, ParseException {
      if (this.hospitalisationEntete != null) {
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
         this.choixImputationLabo = false;
         this.mesImputationLabo.clear();
         this.var_memo_action = this.var_action;
      }

   }

   public void consultDocument() throws ParseException {
      if (this.hospitalisationEntete != null) {
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
         this.choixImputationLabo = false;
         this.mesImputationLabo.clear();
         this.var_memo_action = this.var_action;
      }

   }

   public void chargerModeEcheance() throws ParseException {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      if (this.hospitalisationEntete.getHosTypeReg() != 0 && this.hospitalisationEntete.getHosTypeReg() != 3) {
         if (this.hospitalisationEntete.getHosTypeReg() != 1 && this.hospitalisationEntete.getHosTypeReg() != 2) {
            this.visibiliteterme = false;
         } else {
            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
            this.visibiliteencaissemt = false;
         }
      } else {
         this.hospitalisationEntete.setHosNbJourReg(0);
         this.hospitalisationEntete.setHosArrondiReg(0);
      }

      if (this.hospitalisationEntete.getHosTypeReg() == 4) {
         this.visibiliteencaissemt = true;
         this.visibilitenbrjr = true;
      } else {
         this.visibiliteencaissemt = false;
      }

      this.CalculDateEcheance();
   }

   public void CalculDateEcheance() throws ParseException {
      Date var1 = this.utilDate.CalculDateEcheance(this.hospitalisationEntete.getHosDateEntree(), this.hospitalisationEntete.getHosTypeReg(), this.hospitalisationEntete.getHosNbJourReg(), this.hospitalisationEntete.getHosArrondiReg());
      this.hospitalisationEntete.setHosDateEcheReg(var1);
   }

   public void selectionPec() throws HibernateException, NamingException {
      this.changerTarif();
   }

   public void supprimerDocument() throws HibernateException, NamingException {
      if (this.hospitalisationEntete != null && this.lstReg.size() == 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            int var3;
            if (this.lesSejours.size() != 0) {
               for(var3 = 0; var3 < this.lesSejours.size(); ++var3) {
                  this.hospitalisationSejour = (HospitalisationSejour)this.lesSejours.get(var3);
                  this.hospitalisationSejourDao.delete(this.hospitalisationSejour, var1);
               }
            }

            if (this.lesActes.size() != 0) {
               for(var3 = 0; var3 < this.lesActes.size(); ++var3) {
                  this.hospitalisationActes = (HospitalisationActes)this.lesActes.get(var3);
                  this.hospitalisationActesDao.delete(this.hospitalisationActes, var1);
               }
            }

            if (this.lesMedis.size() != 0) {
               for(var3 = 0; var3 < this.lesMedis.size(); ++var3) {
                  this.hospitalisationMedi = (HospitalisationMedi)this.lesMedis.get(var3);
                  this.hospitalisationMediDao.delete(this.hospitalisationMedi, var1);
               }
            }

            if (this.lesLabos.size() != 0) {
               for(var3 = 0; var3 < this.lesLabos.size(); ++var3) {
                  this.hospitalisationLabo = (HospitalisationLabo)this.lesLabos.get(var3);
                  this.hospitalisationLaboDao.delete(this.hospitalisationLabo, var1);
               }
            }

            if (this.lesPrests.size() != 0) {
               for(var3 = 0; var3 < this.lesPrests.size(); ++var3) {
                  this.hospitalisationPrest = (HospitalisationPrest)this.lesPrests.get(var3);
                  this.hospitalisationPrestDao.delete(this.hospitalisationPrest, var1);
               }
            }

            if (this.lesDocuments.size() != 0 && this.nomRepertoire != null && !this.nomRepertoire.isEmpty()) {
               for(var3 = 0; var3 < this.lesDocuments.size(); ++var3) {
                  String var4 = ((String)this.lesDocuments.get(var3)).toString();
                  File var5 = new File(this.nomRepertoire + var4);
                  if (var5.exists()) {
                     var5.delete();
                  }
               }
            }

            new ArrayList();
            List var13 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.hospitalisationEntete.getHosId(), this.nature, var1);
            if (var13.size() != 0) {
               for(int var11 = 0; var11 < var13.size(); ++var11) {
                  this.bonEncaissementVente = (BonEncaissementVente)var13.get(var11);
                  this.bonEncaissementVenteDao.delete(this.bonEncaissementVente, var1);
               }
            }

            new HospitalisationEntete();
            HospitalisationEntete var12 = this.hospitalisationEnteteDao.selectById(this.hospitalisationEntete.getHosId(), var1);
            if (var12 != null) {
               this.hospitalisationEnteteDao.delete(var12, var1);
            }

            this.lesHospitalisationEntete.remove(this.hospitalisationEntete);
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

      this.visibleOnglet = false;
      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void save() throws HibernateException, NamingException, ParseException {
      this.calculTotaux();
      boolean var1 = false;
      this.verifieExistenceHabilitation((Session)null);
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
      Transaction var3 = null;

      long var6;
      try {
         var3 = var2.beginTransaction();
         this.hospitalisationEntete.setHosIdMedecin(0L);
         this.hospitalisationEntete.setHosMedecin("");
         this.hospitalisationEntete.setHosPecCnamgs(this.var_pecCnamgs);
         this.hospitalisationEntete.setHosAyantDroit(false);
         this.hospitalisationEntete.setHosNomAssurePrincipal("");
         if (this.hospitalisationEntete.getHosFam() <= 0L && this.nomComplementaire == 0L) {
            this.hospitalisationEntete.setHosIdAssurance(0L);
            this.hospitalisationEntete.setHosNomAssurance("");
            this.hospitalisationEntete.setHosContratAssurance("");
            this.hospitalisationEntete.setHosIdComplementaire(0L);
            this.hospitalisationEntete.setHosNomComplemtaire("");
            this.hospitalisationEntete.setHosIdEmployeur(0L);
            this.hospitalisationEntete.setHosNomEmployeur("");
            this.hospitalisationEntete.setHosContratComplementaire("");
            this.hospitalisationEntete.setHosIdSociete(0L);
            this.hospitalisationEntete.setHosNomSociete("");
            this.hospitalisationEntete.setHosMatricule("");
         } else {
            if (this.patientPec == null) {
               this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 0, var2);
            }

            if (this.patientPec != null) {
               if (this.patientPec.getPatpecType() != null && !this.patientPec.getPatpecType().isEmpty()) {
                  if (!this.patientPec.getPatpecType().equals("Assurance") && !this.patientPec.getPatpecType().equals("IPM")) {
                     if (!this.patientPec.getPatpecType().equals("Mutuelle") && !this.patientPec.getPatpecType().equals("Complémentaire")) {
                        this.hospitalisationEntete.setHosIdSociete(this.patientPec.getTiers().getTieid());
                        this.hospitalisationEntete.setHosNomSociete(this.patientPec.getTiers().getTieraisonsocialenom());
                        this.hospitalisationEntete.setHosMatricule(this.patientPec.getPatpecMatricule());
                     } else {
                        this.hospitalisationEntete.setHosIdComplementaire(this.patientPec.getTiers().getTieid());
                        this.hospitalisationEntete.setHosNomComplemtaire(this.patientPec.getTiers().getTieraisonsocialenom());
                        this.hospitalisationEntete.setHosMatricule(this.patientPec.getPatpecMatricule());
                        this.hospitalisationEntete.setHosContratComplementaire(this.patientPec.getPatpecNumContrat());
                     }
                  } else {
                     this.var_pecAssurance = true;
                     this.hospitalisationEntete.setHosIdAssurance(this.patientPec.getTiers().getTieid());
                     this.hospitalisationEntete.setHosNomAssurance(this.patientPec.getTiers().getTieraisonsocialenom());
                     this.hospitalisationEntete.setHosIdEmployeur(this.patientPec.getPatpecIdEmployeur());
                     this.hospitalisationEntete.setHosNomEmployeur(this.patientPec.getPatpecNomEmployeur());
                     this.hospitalisationEntete.setHosMatricule(this.patientPec.getPatpecMatricule());
                     this.hospitalisationEntete.setHosContratAssurance(this.patientPec.getPatpecNumContrat());
                  }

                  if (this.patientPec.getPatpecIdCouvert() != 0L) {
                     this.hospitalisationEntete.setHosAyantDroit(true);
                     this.hospitalisationEntete.setHosNomAssurePrincipal(this.patientPec.getPatpecNomCouvert());
                  }
               }
            } else {
               this.hospitalisationEntete.setHosFam(0L);
            }
         }

         if (this.lesCaution.size() != 0) {
            this.hospitalisationEntete.setHosCaution(true);
         } else {
            this.hospitalisationEntete.setHosCaution(false);
         }

         if (this.hospitalisationEntete.getHosId() != 0L) {
            if (this.lesSejours.size() == 0) {
               this.formRecherche.setMessageTexte("Vous n'avez pas spécifié de séjours. Veuillez cliquez sur l'onglet Séjour et saisir au moins un séjour.");
               this.formRecherche.setShowModalPanelMessage(true);
            } else {
               this.hospitalisationEntete.setHosDateModif(new Date());
               this.hospitalisationEntete.setHosIdModif(this.usersLog.getUsrid());
               this.hospitalisationEntete.setHosNomModif(this.usersLog.getUsrPatronyme());
               this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var2);
               this.var_action = 0;
               this.var_memo_action = this.var_action;
            }
         } else {
            if (!this.hospitalisationEntete.getHosSerie().equalsIgnoreCase("X") && !this.hospitalisationEntete.getHosSerie().isEmpty()) {
               this.hospitalisationEntete.setHosNum(this.calculChrono.numCompose(this.hospitalisationEntete.getHosDateEntree(), this.nature, this.hospitalisationEntete.getHosSerie(), var2));
               boolean var15 = false;

               label308:
               while(true) {
                  while(true) {
                     if (var15) {
                        break label308;
                     }

                     new HospitalisationEntete();
                     HospitalisationEntete var5 = this.hospitalisationEnteteDao.selectByNum(this.hospitalisationEntete.getHosNum(), this.hospitalisationEntete.getHosSerie(), var2);
                     if (var5 != null) {
                        var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.hospitalisationEntete.setHosNum(this.calculChrono.numCompose(this.hospitalisationEntete.getHosDateEntree(), this.nature, this.hospitalisationEntete.getHosSerie(), var2));
                        var15 = false;
                     } else {
                        var15 = true;
                     }
                  }
               }
            } else {
               long var4 = this.hospitalisationEnteteDao.selectLastNum(var2);
               this.hospitalisationEntete.setHosNum("" + var4);
            }

            this.hospitalisationEntete.setExerciceventes(this.exercicesVentes);
            this.hospitalisationEntete.setPatients(this.patients);
            this.hospitalisationEntete.setHosDateCreat(new Date());
            this.hospitalisationEntete.setHosIdCreateur(this.usersLog.getUsrid());
            this.hospitalisationEntete.setHosNomCreateur(this.usersLog.getUsrPatronyme());
            this.hospitalisationEntete.setHosEtat(0);
            this.hospitalisationEntete.setHosEtatVal(0);
            this.hospitalisationEntete = this.hospitalisationEnteteDao.insert(this.hospitalisationEntete, var2);
            this.lesHospitalisationEntete.add(this.hospitalisationEntete);
            this.datamodelHospitalisation.setWrappedData(this.lesHospitalisationEntete);
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

         var3.commit();
         var1 = true;
      } catch (HibernateException var13) {
         var1 = false;
         if (var3 != null) {
            var3.rollback();
         }

         throw var13;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      if (var1 && this.usersChrono.getUsrchrValidation() == 4 && this.hospitalisationEntete.getHosEtat() == 1 && this.hospitalisationEntete.getHosTotPatient() != 0.0D) {
         if (this.usersLog.getUsrFactureCaisse() == 1) {
            if (this.lesCaution.size() != 0) {
               double var16 = 0.0D;
               var6 = 0L;

               for(int var17 = 0; var17 < this.lesCaution.size(); ++var17) {
                  if (((HospitalisationCaution)this.lesCaution.get(var17)).getHoscauIdRecu() == 0L) {
                     var6 = ((HospitalisationCaution)this.lesCaution.get(var17)).getHoscauId();
                     var16 = ((HospitalisationCaution)this.lesCaution.get(var17)).getHoscauMontant();
                     break;
                  }
               }

               this.payeDocument(var6, var16);
            } else {
               this.payeDocument(0L, 0.0D);
            }
         } else if ((this.usersLog.getUsrFactureCaisse() != 2 || this.hospitalisationEntete.getHosRegPatient() != 0.0D) && this.usersLog.getUsrFactureCaisse() == 3) {
         }
      }

      this.var_consultation_directe = false;
      this.visibleOnglet = true;
   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.hospitalisationEntete.setHosEtatVal(1);
         this.hospitalisationEntete.setHosEtat(0);
         return true;
      } else {
         this.hospitalisationEntete.setHosEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.hospitalisationEntete.setHosEtat(1);
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2) {
               if (this.usersChrono.getUsrchrValidation() == 3) {
                  this.hospitalisationEntete.setHosEtat(0);
               } else if (this.usersChrono.getUsrchrValidation() == 4) {
                  this.hospitalisationEntete.setHosEtat(1);
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
      if (this.lesSejours.size() == 0 && this.hospitalisationEntete.getHosId() != 0L) {
         this.hospitalisationEntete.setHosDateAnnule(new Date());
         this.hospitalisationEntete.setHosEtat(3);
         this.hospitalisationEntete.setHosMotifAnnule("ANNULATION SAISIE SUR AJOUT");
         this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete);
         this.lesHospitalisationEntete.remove(this.hospitalisationEntete);
         this.datamodelHospitalisation.setWrappedData(this.lesHospitalisationEntete);
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.hospitalisationEntete.getHosEtat() == 0 && this.usersChrono.getUsrchrValidation() == 2) {
            this.hospitalisationEntete.setHosEtat(1);
            this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
            Espion var3 = new Espion();
            var3.setUsers(this.usersLog);
            var3.setEsptype(0);
            var3.setEspdtecreat(new Date());
            var3.setEspaction("Validation manuelle hospitalisation (M.) N° " + this.hospitalisationEntete.getHosNum() + " du " + this.utilDate.dateToStringSQLLight(this.hospitalisationEntete.getHosDateEntree()));
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

   public void deValideDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.hospitalisationEntete.getHosEtat() == 1 && this.usersChrono.getUsrchrDeValidation() == 1) {
            this.hospitalisationEntete.setHosEtat(0);
            this.hospitalisationEntete.setHosDateImp((Date)null);
            this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
            new ArrayList();
            List var3 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.hospitalisationEntete.getHosId(), this.nature, var1);
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
            var10.setEspaction("Dévalidation manuelle hospitalisation (M.) N° " + this.hospitalisationEntete.getHosNum() + " du " + this.utilDate.dateToStringSQLLight(this.hospitalisationEntete.getHosDateEntree()));
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

   public void annulerDocument() {
      if (this.hospitalisationEntete != null) {
         this.hospitalisationEntete.setHosDateAnnule(new Date());
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

               if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 61 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.hospitalisationEntete.getHosSerie())) {
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
      if (this.hospitalisationEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.hospitalisationEntete.getHosDateAnnule() == null) {
               this.hospitalisationEntete.setHosDateAnnule(new Date());
            }

            this.hospitalisationEntete.setHosEtat(3);
            this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
            new ArrayList();
            List var3 = this.reglementsDao.reglementDocument(this.hospitalisationEntete.getHosId(), this.nature, var1);
            if (var3.size() != 0) {
               double var4 = 0.0D;
               new Reglements();

               for(int var7 = 0; var7 < var3.size(); ++var7) {
                  Reglements var6 = (Reglements)var3.get(var7);
                  var4 = var4 + var6.getRglRecette() - var6.getRglDepense();
               }

               if (var4 != 0.0D) {
                  boolean var13 = false;
                  var13 = this.majBonencaissementAnnulation(var4, this.hospitalisationEntete.getHosDateAnnule(), var1);
                  if (var13) {
                     this.lesHospitalisationEntete.remove(this.hospitalisationEntete);
                     this.datamodelHospitalisation.setWrappedData(this.lesHospitalisationEntete);
                  } else {
                     this.hospitalisationEntete = this.hospitalisationEnteteDao.selectById(this.hospitalisationEntete.getHosId(), var1);
                     if (this.hospitalisationEntete != null) {
                        this.hospitalisationEntete.setHosDateAnnule((Date)null);
                        this.hospitalisationEntete.setHosEtat(1);
                        this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
                     }
                  }
               }
            }

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

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void reactiverDocument() throws HibernateException, NamingException {
      if (this.hospitalisationEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.hospitalisationEntete.setHosEtat(0);
            this.hospitalisationEntete.setHosDateAnnule((Date)null);
            this.hospitalisationEntete.setHosMotifAnnule("");
            this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
            if (this.lstReg.size() != 0) {
               new Reglements();

               for(int var4 = 0; var4 < this.lstReg.size(); ++var4) {
                  Reglements var3 = (Reglements)this.lstReg.get(var4);
                  if (var3.getRglRecette() < 0.0D) {
                     var3.setRglDateReg(new Date());
                     String var5 = "";
                     if (var3.getRglDateReg().getMonth() + 1 <= 9) {
                        var5 = "0" + (var3.getRglDateReg().getMonth() + 1);
                     } else {
                        var5 = "" + (var3.getRglDateReg().getMonth() + 1);
                     }

                     String var6 = "" + (var3.getRglDateReg().getYear() + 1900);
                     var3.setRglPeriode(var5 + ":" + var6);
                     var3.setRglCle1(var3.getRglCodeCaiss() + ":" + var3.getRglPeriode());
                     String var7 = this.utilDate.dateToStringSQLLight(var3.getRglDateReg());
                     var3.setRglCle2(var3.getRglCodeCaiss() + ":" + var7);
                     var3.setRglCle3(var3.getRglCodeReceptrice() + ":" + var3.getRglPeriode());
                     var3.setRglCle4(var3.getRglCodeReceptrice() + ":" + var7);
                     this.reglementsDao.avoirReg(var3, var1);
                  }
               }
            }

            Espion var13 = new Espion();
            var13.setUsers(this.usersLog);
            var13.setEsptype(0);
            var13.setEspdtecreat(new Date());
            var13.setEspaction("Réactivation hospitalisation N° " + this.hospitalisationEntete.getHosNum());
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

      String var8 = this.calculChrono.numCompose(new Date(), 79, this.hospitalisationEntete.getHosSerie(), var4);
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
         this.bonEncaissementVente.setBonActivite(this.hospitalisationEntete.getHosActivite());
         this.bonEncaissementVente.setBonSite("");
         this.bonEncaissementVente.setBonDepartement("");
         this.bonEncaissementVente.setBonService(this.hospitalisationEntete.getHosService());
         this.bonEncaissementVente.setBonRegion("");
         this.bonEncaissementVente.setBonSecteur("");
         this.bonEncaissementVente.setBonPdv("");
         this.bonEncaissementVente.setBonDateEcheReg((Date)null);
         this.bonEncaissementVente.setBonEtat(0);
         this.bonEncaissementVente.setBonNatRef(this.nature);
         this.bonEncaissementVente.setBonNomTiers(this.hospitalisationEntete.getHosNomPatient());
         this.bonEncaissementVente.setBonIdTiers(this.hospitalisationEntete.getPatients().getPatId());
         this.bonEncaissementVente.setBonNomContact("");
         this.bonEncaissementVente.setBonIdContact(0L);
         this.bonEncaissementVente.setBonTypeTiers(4);
         this.bonEncaissementVente.setBonLibelle("Annulation Règlement Hospitalisation N° " + this.hospitalisationEntete.getHosNum());
         this.bonEncaissementVente.setBonRef(this.hospitalisationEntete.getHosNum());
         this.bonEncaissementVente.setBonIdRef(this.hospitalisationEntete.getHosId());
         this.bonEncaissementVente.setBonObject(this.hospitalisationEntete.getHosMotifAnnule());
         this.bonEncaissementVente.setBonObservation(this.hospitalisationEntete.getHosMedecin());
         this.bonEncaissementVente.setBonSerie(this.hospitalisationEntete.getHosSerie());
         this.bonEncaissementVente.setBonDevise(this.structureLog.getStrdevise());
         this.bonEncaissementVente.setBonTotTtc(this.hospitalisationEntete.getHosTotTaxePatient() + this.hospitalisationEntete.getHosTotPatient());
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
         var9.setEspaction("Annulation hospitalisation N° " + this.hospitalisationEntete.getHosNum() + " pour " + this.hospitalisationEntete.getHosMotifAnnule());
         this.espionDao.mAJEspion(var9, var4);
         var5 = true;
      } else {
         this.formRecherche.setMessageTexte("Le chrono du bon d`encaissement n`a pas été calculé. Peut être est-ce une question d'autorisation. Contactez votre administrateur pour plus d`informations.");
         this.formRecherche.setShowModalPanelMessage(true);
         var5 = false;
      }

      return var5;
   }

   public void ajouterAntecedent() throws IOException {
      this.patientAnt = new PatientAnt();
      this.var_antecedent = "";
      this.var_actionAntecedent = 1;
      this.patientAnt.setPatantDate(this.hospitalisationEntete.getHosDateEntree());
      this.patientAnt.setPatantMedecin(this.hospitalisationEntete.getHosMedecin());
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
            this.patientAnt.setPatantNumConsultGene(this.hospitalisationEntete.getHosNum());
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

   public void selectionSejour() throws HibernateException, NamingException {
      if (this.dataModelSejours.isRowAvailable()) {
         this.hospitalisationSejour = (HospitalisationSejour)this.dataModelSejours.getRowData();
         this.afficheButtLit = true;
         this.var_heureDeces = "";
         this.var_minuteDeces = "";
         if (this.hospitalisationSejour.getHossejDateSortie() != null) {
            int var1 = this.hospitalisationSejour.getHossejDateSortie().getHours();
            if (var1 <= 9) {
               this.var_heureDeces = "0" + var1;
            } else {
               this.var_heureDeces = "" + var1;
            }

            int var2 = this.hospitalisationSejour.getHossejDateSortie().getMinutes();
            if (var2 <= 9) {
               this.var_minuteDeces = "0" + var2;
            } else {
               this.var_minuteDeces = "" + var2;
            }
         }

         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "CimMedical");
         this.calculeLibelleDiagnostic(var3);
         this.utilInitHibernate.closeSession();
         this.valideSejour = true;
      }

   }

   public void calculeLibelleDiagnostic(Session var1) throws HibernateException, NamingException {
      this.hospitalisationSejour.setLib_diag1("");
      this.hospitalisationSejour.setLib_diag2("");
      this.hospitalisationSejour.setLib_diag11("");
      this.hospitalisationSejour.setLib_diag12("");
      this.hospitalisationSejour.setLib_diag13("");
      this.hospitalisationSejour.setLib_diag14("");
      this.hospitalisationSejour.setLib_diag15("");
      if (this.hospitalisationSejour.getHossejCodeDiag1() != null && !this.hospitalisationSejour.getHossejCodeDiag1().isEmpty()) {
         this.cimMedical = this.cimMedicalDao.selectOneCim(this.hospitalisationSejour.getHossejCodeDiag1(), var1);
         if (this.cimMedical != null) {
            this.hospitalisationSejour.setLib_diag1(this.cimMedical.getCimLibelleFR());
         }
      }

      if (this.hospitalisationSejour.getHossejCodeDiag2() != null && !this.hospitalisationSejour.getHossejCodeDiag2().isEmpty()) {
         this.cimMedical = this.cimMedicalDao.selectOneCim(this.hospitalisationSejour.getHossejCodeDiag2(), var1);
         if (this.cimMedical != null) {
            this.hospitalisationSejour.setLib_diag2(this.cimMedical.getCimLibelleFR());
         }
      }

      if (this.hospitalisationSejour.getHossejCodeDiag11() != null && !this.hospitalisationSejour.getHossejCodeDiag11().isEmpty()) {
         this.cimMedical = this.cimMedicalDao.selectOneCim(this.hospitalisationSejour.getHossejCodeDiag11(), var1);
         if (this.cimMedical != null) {
            this.hospitalisationSejour.setLib_diag11(this.cimMedical.getCimLibelleFR());
         }
      }

      if (this.hospitalisationSejour.getHossejCodeDiag12() != null && !this.hospitalisationSejour.getHossejCodeDiag12().isEmpty()) {
         this.cimMedical = this.cimMedicalDao.selectOneCim(this.hospitalisationSejour.getHossejCodeDiag12(), var1);
         if (this.cimMedical != null) {
            this.hospitalisationSejour.setLib_diag12(this.cimMedical.getCimLibelleFR());
         }
      }

      if (this.hospitalisationSejour.getHossejCodeDiag13() != null && !this.hospitalisationSejour.getHossejCodeDiag13().isEmpty()) {
         this.cimMedical = this.cimMedicalDao.selectOneCim(this.hospitalisationSejour.getHossejCodeDiag13(), var1);
         if (this.cimMedical != null) {
            this.hospitalisationSejour.setLib_diag13(this.cimMedical.getCimLibelleFR());
         }
      }

      if (this.hospitalisationSejour.getHossejCodeDiag14() != null && !this.hospitalisationSejour.getHossejCodeDiag14().isEmpty()) {
         this.cimMedical = this.cimMedicalDao.selectOneCim(this.hospitalisationSejour.getHossejCodeDiag14(), var1);
         if (this.cimMedical != null) {
            this.hospitalisationSejour.setLib_diag14(this.cimMedical.getCimLibelleFR());
         }
      }

      if (this.hospitalisationSejour.getHossejCodeDiag15() != null && !this.hospitalisationSejour.getHossejCodeDiag15().isEmpty()) {
         this.cimMedical = this.cimMedicalDao.selectOneCim(this.hospitalisationSejour.getHossejCodeDiag15(), var1);
         if (this.cimMedical != null) {
            this.hospitalisationSejour.setLib_diag15(this.cimMedical.getCimLibelleFR());
         }
      }

   }

   public void ajouterSejour() throws HibernateException, NamingException {
      this.hospitalisationSejour = new HospitalisationSejour();
      if (this.lesSejours.size() == 0) {
         this.hospitalisationSejour.setHossejDateEntree(this.hospitalisationEntete.getHosDateEntree());
      } else {
         int var1 = this.lesSejours.size() - 1;
         this.hospitalisationSejour.setHossejDateEntree(((HospitalisationSejour)this.lesSejours.get(var1)).getHossejDateSortie());
      }

      this.lesMedecins.clear();
      this.mesMedecinsItem.clear();
      this.valideSejour = false;
      this.afficheButtLit = false;
      this.quitterSejour = false;
      this.showModalPanelSejour = true;
   }

   public void modifierSejour() throws HibernateException, NamingException {
      if (this.hospitalisationSejour != null) {
         this.lesMedecins.clear();
         this.mesMedecinsItem.clear();
         if (this.hospitalisationSejour.getHossejService() != null && !this.hospitalisationSejour.getHossejService().isEmpty()) {
            this.calculMedecinSejour();
         }

         this.verifValideSejour();
         if (this.hospitalisationSejour.getHossejDateSortie() != null) {
            this.quitterSejour = true;
         } else {
            this.quitterSejour = false;
         }

         this.showModalPanelSejour = true;
      }

   }

   public void quitterSejour() throws HibernateException, NamingException {
      if (this.hospitalisationSejour != null) {
         this.lesMedecins.clear();
         this.mesMedecinsItem.clear();
         if (this.hospitalisationSejour.getHossejService() != null && !this.hospitalisationSejour.getHossejService().isEmpty()) {
            this.calculMedecinSejour();
         }

         this.verifValideSejour();
         this.quitterSejour = true;
         this.showModalPanelSejour = true;
      }

   }

   public void supprimerSejour() throws HibernateException, NamingException {
      if (this.hospitalisationSejour != null) {
         boolean var1 = true;
         int var2;
         if (this.lesActes.size() != 0) {
            for(var2 = 0; var2 < this.lesActes.size(); ++var2) {
               if (((HospitalisationActes)this.lesActes.get(var2)).getHosactIdSejour() == this.hospitalisationSejour.getHossejId()) {
                  var1 = false;
                  break;
               }
            }
         }

         if (this.lesLabos.size() != 0) {
            for(var2 = 0; var2 < this.lesLabos.size(); ++var2) {
               if (((HospitalisationLabo)this.lesLabos.get(var2)).getHoslabIdSejour() == this.hospitalisationSejour.getHossejId()) {
                  var1 = false;
                  break;
               }
            }
         }

         if (this.lesMedis.size() != 0) {
            for(var2 = 0; var2 < this.lesMedis.size(); ++var2) {
               if (((HospitalisationMedi)this.lesMedis.get(var2)).getHosmedIdSejour() == this.hospitalisationSejour.getHossejId()) {
                  var1 = false;
                  break;
               }
            }
         }

         if (this.lesPrests.size() != 0) {
            for(var2 = 0; var2 < this.lesPrests.size(); ++var2) {
               if (((HospitalisationPrest)this.lesPrests.get(var2)).getHosprtIdSejour() == this.hospitalisationSejour.getHossejId()) {
                  var1 = false;
                  break;
               }
            }
         }

         if (var1) {
            this.hospitalisationSejourDao.delete(this.hospitalisationSejour);
            this.lesSejours.remove(this.hospitalisationSejour);
            this.dataModelSejours.setWrappedData(this.lesSejours);
         }

         this.quitterSejour = false;
         this.afficheButtLit = false;
      }

   }

   public void avoirSejour() {
   }

   public void annulerSejour() {
      if (this.lesSejours.size() != 0) {
         this.afficheButtSejour = true;
      } else {
         this.afficheButtSejour = false;
      }

      this.quitterSejour = false;
      this.showModalPanelSejour = false;
   }

   public void verifValideSejour() {
      this.valideSejour = false;
      if (this.hospitalisationSejour.getHossejLit() != null && !this.hospitalisationSejour.getHossejLit().isEmpty()) {
         if (this.optionMedical.getMedecinHP().equals("0")) {
            if (this.hospitalisationSejour.getHossejIdMedecin() != 0L) {
               this.valideSejour = true;
            }
         } else {
            this.valideSejour = true;
         }
      }

   }

   public void calculPrixSejour() throws HibernateException, NamingException {
      this.calculPrixSejour(1, (Session)null);
   }

   public void calculPrixNouveauSejour() throws HibernateException, NamingException {
      this.calculPrixSejour(0, (Session)null);
   }

   public void calculPrixSejour(int var1, Session var2) throws HibernateException, NamingException {
      float var3 = 1.0F;
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      double var10 = this.hospitalisationSejour.getHossejPu();
      double var12 = this.hospitalisationSejour.getHossejPuCnamgs();
      double var14 = this.hospitalisationSejour.getHossejPuAssurance();
      if (var1 == 0) {
         var10 = 0.0D;
         var12 = 0.0D;
         var14 = 0.0D;
      }

      boolean var16 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         var16 = true;
      }

      boolean var17 = false;
      int var20;
      if (this.hospitalisationSejour.getHossejDateEntree() != null && this.hospitalisationSejour.getHossejDateSortie() != null) {
         int var18 = (int)((this.hospitalisationSejour.getHossejDateSortie().getTime() - this.hospitalisationSejour.getHossejDateEntree().getTime()) / 86400000L);
         this.hospitalisationSejour.setHossejNbJour(var18);
         var20 = this.hospitalisationSejour.getHossejNbJour();
      } else {
         if (this.hospitalisationSejour.getHossejNbJourTheo() == 0) {
            this.hospitalisationSejour.setHossejNbJourTheo(1);
         }

         var20 = this.hospitalisationSejour.getHossejNbJourTheo();
      }

      this.produits = this.produitsMedicDao.chargeProduit(this.hospitalisationSejour.getHossejLit(), var2);
      if (this.produits != null) {
         this.hospitalisationSejour.setHossejLit(this.produits.getProCode());
         this.hospitalisationSejour.setHossejLibelle(this.produits.getProLibClient());
         this.hospitalisationSejour.setHossejCodeTva(this.produits.getProVteTva());
         this.hospitalisationSejour.setHossejTauxTva(0.0F);
         if (this.hospitalisationSejour.getHossejCodeTva() != null && !this.hospitalisationSejour.getHossejCodeTva().isEmpty()) {
            this.taxesMedical = this.taxesMedicalDao.selectTva(this.exercicesVentes.getExevteId(), this.hospitalisationSejour.getHossejCodeTva(), var2);
            if (this.taxesMedical != null) {
               this.hospitalisationSejour.setHossejTauxTva(this.taxesMedical.getTaxvteTaux());
            }
         }

         String var21 = this.hospitalisationEntete.getLibelleFamille();
         int var19;
         if (var21.startsWith("Assuré") && this.optionMedical.getTarifSociete().equals("1")) {
            var21 = "Non Assuré";
         } else if (var21.startsWith("Assuré") && this.optionMedical.getTarifSociete().equals("2")) {
            var21 = "Assuré";

            for(var19 = 0; var19 < this.mesCategoriesItems.size(); ++var19) {
               if (Long.parseLong(((SelectItem)this.mesCategoriesItems.get(var19)).getValue().toString()) == this.nomFamille) {
                  if (((SelectItem)this.mesCategoriesItems.get(var19)).getLabel().toString().startsWith("Société")) {
                     var21 = "Société";
                  } else {
                     var21 = "Assuré";
                  }
                  break;
               }
            }
         } else if (var21.equals("Cas Social")) {
            var21 = "Non Assuré";
         } else if (var21.startsWith("Non Assuré") && this.var_pecCnamgs != 0.0F) {
            var21 = "CNAMGS";
         } else {
            var21 = "Non Assuré";
         }

         this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, var21, var2);
         if (this.produitsTarif != null) {
            var3 = this.produitsTarif.getProtarCoef();
            var4 = this.produitsTarif.getProtarPv();
            var6 = this.produitsTarif.getProtarPvCnamgs();
            if (var3 == 0.0F) {
               var3 = 1.0F;
               if (this.lesCategoriesList.size() != 0) {
                  for(var19 = 0; var19 < this.lesCategoriesList.size(); ++var19) {
                     if (((ObjetCategories)this.lesCategoriesList.get(var19)).getLibelle_FR().equals(this.hospitalisationEntete.getLibelleFamille())) {
                        var3 = ((ObjetCategories)this.lesCategoriesList.get(var19)).getCoef();
                        break;
                     }
                  }
               }
            }

            this.hospitalisationSejour.setHossejCoef(var3);
            if (var10 != 0.0D) {
               var4 = var10;
            }

            this.hospitalisationSejour.setHossejPu(var4);
            if (var12 != 0.0D) {
               var6 = var12;
            }

            this.hospitalisationSejour.setHossejPuCnamgs(var6);
            if (var14 != 0.0D) {
               var8 = var14;
            }

            this.hospitalisationSejour.setHossejPuAssurance(var8);
            if (this.hospitalisationEntete.getHosFam() >= 1L) {
               this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 0, var2);
               if (this.patientPec != null) {
                  this.conventionMedical = this.conventionMedicalDao.trouveConvention(this.patientPec.getTiers().getTieid(), this.hospitalisationSejour.getHossejLit(), var2);
                  if (this.conventionMedical != null) {
                     this.hospitalisationSejour.setHossejPuAssurance(this.conventionMedical.getCvnValeur());
                     if (this.conventionMedical.getCvnValeurOrigine() != 0.0D) {
                        this.hospitalisationSejour.setHossejPu(this.conventionMedical.getCvnValeurOrigine());
                     }
                  }
               }
            }
         } else {
            this.hospitalisationSejour.setHossejCoef(0.0F);
            this.hospitalisationSejour.setHossejPu(var10);
            this.hospitalisationSejour.setHossejPuCnamgs(var12);
            this.hospitalisationSejour.setHossejPuAssurance(var14);
         }
      } else {
         this.hospitalisationSejour.setHossejCoef(0.0F);
         this.hospitalisationSejour.setHossejPu(var10);
         this.hospitalisationSejour.setHossejPuCnamgs(var12);
         this.hospitalisationSejour.setHossejPuAssurance(var14);
      }

      if (this.var_pecCnamgs != 0.0F) {
         this.sejourAvecCnamgsPrive(var20, var2);
      } else if (this.hospitalisationEntete.getHosFam() != 0L && this.hospitalisationEntete.getHosFam() != -1L) {
         this.sejourSansCnamgsAssure(var20, var2);
      } else {
         this.sejourSansCnamgsPrive(var20, var2);
      }

      if (var16) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void sejourSansCnamgsAssure(int var1, Session var2) throws HibernateException, NamingException {
      double var3;
      if (this.hospitalisationSejour.getHossejRemise() != 0.0F) {
         var3 = this.utilNombre.myRoundDevise(this.hospitalisationSejour.getHossejPu() * (double)this.hospitalisationSejour.getHossejRemise() / 100.0D, this.structureLog.getStrdevise());
         this.hospitalisationSejour.setHossejPuRem(this.hospitalisationSejour.getHossejPu() - var3);
         this.hospitalisationSejour.setHossejRabais(0.0D);
      } else {
         this.hospitalisationSejour.setHossejPuRem(this.hospitalisationSejour.getHossejPu());
      }

      this.hospitalisationSejour.setHossejTotal(this.hospitalisationSejour.getHossejPuRem() * (double)var1);
      if (this.hospitalisationSejour.getHossejTauxTva() != 0.0F) {
         var3 = this.hospitalisationSejour.getHossejTotal() * (double)this.hospitalisationSejour.getHossejTauxTva() / 100.0D;
         this.hospitalisationSejour.setHossejTaxe(this.utilNombre.myRoundDevise(var3, this.structureLog.getStrdevise()));
      } else {
         this.hospitalisationSejour.setHossejTaxe(0.0D);
      }

      this.hospitalisationSejour.setHossejPuCnamgs(0.0D);
      this.hospitalisationSejour.setHossejSocieteHt(0.0D);
      this.hospitalisationSejour.setHossejSocieteTaxe(0.0D);
      this.hospitalisationSejour.setHossejAssuranceHt(0.0D);
      this.hospitalisationSejour.setHossejAssuranceTaxe(0.0D);
      this.hospitalisationSejour.setHossejComplementaireHt(0.0D);
      this.hospitalisationSejour.setHossejComplementaireTaxe(0.0D);
      this.hospitalisationSejour.setHossejPatientHt(0.0D);
      this.hospitalisationSejour.setHossejPatientTaxe(0.0D);
      this.hospitalisationEntete.setHosIdEmployeur(0L);
      var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      float var9 = 0.0F;
      double var10;
      if (this.hospitalisationEntete.getHosIdSociete() != 0L && this.hospitalisationEntete.getHosFam() != 0L) {
         if (this.patientPec == null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 0, var2);
         }

         if (this.patientPec != null) {
            var3 = this.hospitalisationSejour.getHossejTotal() * (double)this.patientPec.getPatpecHebergementRep() / 100.0D;
            if (this.patientPec.getTiers().getTiecoefpvmedical() == 0.0F || this.produits == null || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.hospitalisationSejour.setHossejSocieteHt(var3);
            } else {
               this.hospitalisationSejour.setHossejSocieteHt(var3 * (double)this.patientPec.getTiers().getTiecoefpvmedical());
               var9 = this.patientPec.getTiers().getTiecoefpvmedical();
            }

            if (this.hospitalisationSejour.getHossejTauxTva() != 0.0F) {
               var10 = this.hospitalisationSejour.getHossejSocieteHt() * (double)this.hospitalisationSejour.getHossejTauxTva() / 100.0D;
               this.hospitalisationSejour.setHossejSocieteTaxe(this.utilNombre.myRoundDevise(var10, this.structureLog.getStrdevise()));
            }
         }
      } else if (this.hospitalisationEntete.getHosIdAssurance() != 0L && this.hospitalisationEntete.getHosFam() != 0L) {
         if (this.patientPec == null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 0, var2);
         }

         if (this.patientPec != null) {
            this.var_pecAssurance = true;
            this.hospitalisationEntete.setHosIdEmployeur(this.patientPec.getPatpecIdEmployeur());
            if (this.hospitalisationSejour.getHossejPuAssurance() == 0.0D) {
               this.hospitalisationSejour.setHossejPuAssurance(this.hospitalisationSejour.getHossejPu());
            }

            var5 = this.hospitalisationSejour.getHossejPuAssurance() * (double)var1 * (double)this.patientPec.getPatpecHebergementRep() / 100.0D;
            if (this.hospitalisationSejour.getHossejRemise() != 0.0F) {
               var10 = this.utilNombre.myRoundDevise(var5 * (double)this.hospitalisationSejour.getHossejRemise() / 100.0D, this.structureLog.getStrdevise());
               var5 -= var10;
            }

            if (this.patientPec.getTiers().getTiecoefpvmedical() == 0.0F || this.produits == null || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.hospitalisationSejour.setHossejAssuranceHt(var5);
            } else {
               this.hospitalisationSejour.setHossejAssuranceHt(var5 * (double)this.patientPec.getTiers().getTiecoefpvmedical());
               var9 = this.patientPec.getTiers().getTiecoefpvmedical();
            }

            if (this.hospitalisationSejour.getHossejTauxTva() != 0.0F) {
               var10 = this.hospitalisationSejour.getHossejAssuranceHt() * (double)this.hospitalisationSejour.getHossejTauxTva() / 100.0D;
               this.hospitalisationSejour.setHossejAssuranceTaxe(this.utilNombre.myRoundDevise(var10, this.structureLog.getStrdevise()));
            }
         }
      }

      if (this.hospitalisationEntete.getHosIdComplementaire() != 0L) {
         if (this.patientPecComplementaire == null) {
            this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosComplementaire(), 0, var2);
         }

         if (this.patientPecComplementaire != null) {
            var7 = this.hospitalisationSejour.getHossejPu() * (double)var1 * (double)this.patientPec.getPatpecHebergementRep() / 100.0D;
            if (this.hospitalisationSejour.getHossejRemise() != 0.0F) {
               var10 = this.utilNombre.myRoundDevise(var7 * (double)this.hospitalisationSejour.getHossejRemise() / 100.0D, this.structureLog.getStrdevise());
               var7 -= var10;
            }

            if (this.patientPecComplementaire.getTiers().getTiecoefpvmedical() == 0.0F || this.produits == null || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.hospitalisationSejour.setHossejComplementaireHt(var7);
            } else {
               this.hospitalisationSejour.setHossejComplementaireHt(var7 * (double)this.patientPecComplementaire.getTiers().getTiecoefpvmedical());
            }

            if (this.hospitalisationSejour.getHossejTauxTva() != 0.0F) {
               var10 = this.hospitalisationSejour.getHossejComplementaireHt() * (double)this.hospitalisationSejour.getHossejTauxTva() / 100.0D;
               this.hospitalisationSejour.setHossejComplementaireTaxe(this.utilNombre.myRoundDevise(var10, this.structureLog.getStrdevise()));
            }
         }
      }

      var10 = 0.0D;
      double var12;
      if (var9 != 0.0F && this.produits != null && this.produits.getProMajoration() == 0 && this.optionMedical.getCoefMajoration().equals("2")) {
         if (this.hospitalisationSejour.getHossejRemise() != 0.0F) {
            var12 = this.utilNombre.myRoundDevise(this.hospitalisationSejour.getHossejPu() * (double)this.hospitalisationSejour.getHossejRemise() / 100.0D, this.structureLog.getStrdevise());
            this.hospitalisationSejour.setHossejPuRem((this.hospitalisationSejour.getHossejPu() - var12) * (double)var9);
         } else {
            this.hospitalisationSejour.setHossejPuRem(this.hospitalisationSejour.getHossejPu() * (double)var9);
         }

         this.hospitalisationSejour.setHossejTotal(this.hospitalisationSejour.getHossejPuRem() * (double)var1);
         if (this.hospitalisationSejour.getHossejTauxTva() != 0.0F) {
            var12 = this.hospitalisationSejour.getHossejTotal() * (double)this.hospitalisationSejour.getHossejTauxTva() / 100.0D;
            this.hospitalisationSejour.setHossejTaxe(this.utilNombre.myRoundDevise(var12, this.structureLog.getStrdevise()));
         } else {
            this.hospitalisationSejour.setHossejTaxe(0.0D);
         }
      } else {
         var10 = this.hospitalisationSejour.getHossejTotal() - (var3 + var5 + var7);
         this.hospitalisationSejour.setHossejTotal(this.hospitalisationSejour.getHossejSocieteHt() + this.hospitalisationSejour.getHossejAssuranceHt() + this.hospitalisationSejour.getHossejComplementaireHt() + var10);
      }

      var12 = this.hospitalisationSejour.getHossejTotal() - (this.hospitalisationSejour.getHossejSocieteHt() + this.hospitalisationSejour.getHossejAssuranceHt() + this.hospitalisationSejour.getHossejComplementaireHt());
      if (this.hospitalisationSejour.getHossejRabais() != 0.0D) {
         this.hospitalisationSejour.setHossejPatientHt(var12 - this.hospitalisationSejour.getHossejRabais());
         this.hospitalisationSejour.setHossejRemise(0.0F);
         if (this.hospitalisationSejour.getHossejPatientHt() < 0.0D) {
            this.hospitalisationSejour.setHossejPatientHt(var12);
            this.hospitalisationSejour.setHossejRabais(0.0D);
         }
      } else {
         this.hospitalisationSejour.setHossejPatientHt(var12);
      }

      double var14;
      if (this.hospitalisationSejour.getHossejTauxTva() != 0.0F) {
         var14 = this.hospitalisationSejour.getHossejPatientHt() * (double)this.hospitalisationSejour.getHossejTauxTva() / 100.0D;
         this.hospitalisationSejour.setHossejPatientTaxe(this.utilNombre.myRoundDevise(var14, this.structureLog.getStrdevise()));
      }

      if (var9 != 0.0F && this.produits != null && this.produits.getProMajoration() == 0 && this.optionMedical.getCoefMajoration().equals("3")) {
         if (this.hospitalisationSejour.getHossejRemise() != 0.0F) {
            var14 = this.utilNombre.myRoundDevise(this.hospitalisationSejour.getHossejPu() * (double)this.hospitalisationSejour.getHossejRemise() / 100.0D, this.structureLog.getStrdevise());
            this.hospitalisationSejour.setHossejPuRem((this.hospitalisationSejour.getHossejPu() - var14) * (double)var9);
         } else {
            this.hospitalisationSejour.setHossejPuRem(this.hospitalisationSejour.getHossejPu() * (double)var9);
         }

         this.hospitalisationSejour.setHossejTotal(this.hospitalisationSejour.getHossejPuRem() * (double)var1);
         var14 = this.hospitalisationSejour.getHossejAssuranceHt() + this.hospitalisationSejour.getHossejComplementaireHt() + this.hospitalisationSejour.getHossejSocieteHt() + this.hospitalisationSejour.getHossejPatientHt();
         double var16 = this.hospitalisationSejour.getHossejTotal() - var14;
         if (var16 != 0.0D) {
            if (var5 != 0.0D) {
               this.hospitalisationSejour.setHossejAssuranceHt(this.hospitalisationSejour.getHossejAssuranceHt() + var16);
            } else if (var3 != 0.0D) {
               this.hospitalisationSejour.setHossejSocieteHt(this.hospitalisationSejour.getHossejSocieteHt() + var16);
            }

            if (var7 != 0.0D) {
               this.hospitalisationSejour.setHossejComplementaireHt(this.hospitalisationSejour.getHossejComplementaireHt() + var16);
            }
         }
      }

   }

   public void sejourSansCnamgsPrive(int var1, Session var2) {
      if (this.tauxCasSocial != 0.0F) {
         this.hospitalisationSejour.setHossejRemise(this.tauxCasSocial);
      }

      double var3;
      if (this.hospitalisationSejour.getHossejRemise() != 0.0F) {
         var3 = this.utilNombre.myRoundDevise(this.hospitalisationSejour.getHossejPu() * (double)this.hospitalisationSejour.getHossejRemise() / 100.0D, this.structureLog.getStrdevise());
         this.hospitalisationSejour.setHossejPuRem(this.hospitalisationSejour.getHossejPu() - var3);
         this.hospitalisationSejour.setHossejRabais(0.0D);
      } else {
         this.hospitalisationSejour.setHossejPuRem(this.hospitalisationSejour.getHossejPu());
      }

      this.hospitalisationSejour.setHossejTotal(this.hospitalisationSejour.getHossejPuRem() * (double)var1);
      if (this.hospitalisationSejour.getHossejTauxTva() != 0.0F) {
         var3 = this.hospitalisationSejour.getHossejTotal() * (double)this.hospitalisationSejour.getHossejTauxTva() / 100.0D;
         this.hospitalisationSejour.setHossejTaxe(this.utilNombre.myRoundDevise(var3, this.structureLog.getStrdevise()));
      } else {
         this.hospitalisationSejour.setHossejTaxe(0.0D);
      }

      this.hospitalisationSejour.setHossejPuCnamgs(0.0D);
      this.hospitalisationSejour.setHossejSocieteHt(0.0D);
      this.hospitalisationSejour.setHossejSocieteTaxe(0.0D);
      this.hospitalisationSejour.setHossejAssuranceHt(0.0D);
      this.hospitalisationSejour.setHossejAssuranceTaxe(0.0D);
      this.hospitalisationSejour.setHossejComplementaireHt(0.0D);
      this.hospitalisationSejour.setHossejComplementaireTaxe(0.0D);
      this.hospitalisationSejour.setHossejPatientHt(0.0D);
      this.hospitalisationSejour.setHossejPatientTaxe(0.0D);
      this.hospitalisationEntete.setHosIdEmployeur(0L);
      var3 = this.hospitalisationSejour.getHossejTotal();
      if (this.hospitalisationSejour.getHossejRabais() != 0.0D) {
         this.hospitalisationSejour.setHossejPatientHt(var3 - this.hospitalisationSejour.getHossejRabais());
         this.hospitalisationSejour.setHossejRemise(0.0F);
         if (this.hospitalisationSejour.getHossejPatientHt() < 0.0D) {
            this.hospitalisationSejour.setHossejPatientHt(var3);
            this.hospitalisationSejour.setHossejRabais(0.0D);
         }
      } else {
         this.hospitalisationSejour.setHossejPatientHt(var3);
      }

      if (this.hospitalisationSejour.getHossejTaxe() != 0.0D) {
         double var5 = this.hospitalisationSejour.getHossejPatientHt() * (double)this.hospitalisationSejour.getHossejTauxTva() / 100.0D;
         this.hospitalisationSejour.setHossejPatientTaxe(this.utilNombre.myRoundDevise(var5, this.structureLog.getStrdevise()));
      } else {
         this.hospitalisationSejour.setHossejPatientTaxe(0.0D);
      }

   }

   public void sejourAvecCnamgsPrive(int var1, Session var2) throws HibernateException, NamingException {
      if (this.hospitalisationSejour.getHossejPuCnamgs() > this.hospitalisationSejour.getHossejPu()) {
         this.hospitalisationSejour.setHossejPu(this.hospitalisationSejour.getHossejPuCnamgs());
      }

      double var3;
      double var5;
      if (this.hospitalisationSejour.getHossejRemise() != 0.0F) {
         var3 = this.utilNombre.myRoundDevise(this.hospitalisationSejour.getHossejPu() * (double)this.hospitalisationSejour.getHossejRemise() / 100.0D, this.structureLog.getStrdevise());
         this.hospitalisationSejour.setHossejPuRem(this.hospitalisationSejour.getHossejPu() - var3);
         var5 = this.utilNombre.myRoundDevise(this.hospitalisationSejour.getHossejPuCnamgs() * (double)this.hospitalisationSejour.getHossejRemise() / 100.0D, this.structureLog.getStrdevise());
         this.hospitalisationSejour.setHossejPuCnamgs(this.hospitalisationSejour.getHossejPuCnamgs() - var5);
         this.hospitalisationSejour.setHossejRabais(0.0D);
      } else {
         this.hospitalisationSejour.setHossejPuRem(this.hospitalisationSejour.getHossejPu());
      }

      this.hospitalisationSejour.setHossejTotal(this.hospitalisationSejour.getHossejPuRem() * (double)var1);
      if (this.hospitalisationSejour.getHossejTauxTva() != 0.0F) {
         var3 = this.hospitalisationSejour.getHossejTotal() * (double)this.hospitalisationSejour.getHossejTauxTva() / 100.0D;
         this.hospitalisationSejour.setHossejTaxe(this.utilNombre.myRoundDevise(var3, this.structureLog.getStrdevise()));
      } else {
         this.hospitalisationSejour.setHossejTaxe(0.0D);
      }

      this.hospitalisationSejour.setHossejSocieteHt(0.0D);
      this.hospitalisationSejour.setHossejSocieteTaxe(0.0D);
      this.hospitalisationSejour.setHossejAssuranceHt(0.0D);
      this.hospitalisationSejour.setHossejAssuranceTaxe(0.0D);
      this.hospitalisationSejour.setHossejComplementaireHt(0.0D);
      this.hospitalisationSejour.setHossejComplementaireTaxe(0.0D);
      this.hospitalisationSejour.setHossejPatientHt(0.0D);
      this.hospitalisationSejour.setHossejPatientTaxe(0.0D);
      this.hospitalisationEntete.setHosIdEmployeur(0L);
      this.hospitalisationSejour.setHossejAssuranceHt(this.hospitalisationSejour.getHossejPuCnamgs() * (double)var1 * (double)this.var_pecCnamgs / 100.0D);
      if (this.hospitalisationSejour.getHossejTauxTva() != 0.0F) {
         var3 = this.hospitalisationSejour.getHossejAssuranceHt() * (double)this.hospitalisationSejour.getHossejTauxTva() / 100.0D;
         this.hospitalisationSejour.setHossejAssuranceTaxe(this.utilNombre.myRoundDevise(var3, this.structureLog.getStrdevise()));
      }

      var3 = this.hospitalisationSejour.getHossejTotal() - this.hospitalisationSejour.getHossejAssuranceHt();
      if (this.hospitalisationSejour.getHossejRabais() != 0.0D) {
         this.hospitalisationSejour.setHossejPatientHt(var3 - this.hospitalisationSejour.getHossejRabais());
         this.hospitalisationSejour.setHossejRemise(0.0F);
         if (this.hospitalisationSejour.getHossejPatientHt() < 0.0D) {
            this.hospitalisationSejour.setHossejPatientHt(var3);
            this.hospitalisationSejour.setHossejRabais(0.0D);
         }
      } else {
         this.hospitalisationSejour.setHossejPatientHt(var3);
      }

      this.hospitalisationSejour.setHossejPatientHt(this.hospitalisationSejour.getHossejTotal() - this.hospitalisationSejour.getHossejAssuranceHt());
      if (this.hospitalisationSejour.getHossejTauxTva() != 0.0F) {
         var5 = this.hospitalisationSejour.getHossejPatientHt() * (double)this.hospitalisationSejour.getHossejTauxTva() / 100.0D;
         this.hospitalisationSejour.setHossejPatientTaxe(this.utilNombre.myRoundDevise(var5, this.structureLog.getStrdevise()));
      }

   }

   public void calculenbJourSejour() {
      boolean var1 = false;
      if (this.hospitalisationSejour.getHossejDateEntree() != null && this.hospitalisationSejour.getHossejDateSortie() != null) {
         int var2 = (int)((this.hospitalisationSejour.getHossejDateSortie().getTime() - this.hospitalisationSejour.getHossejDateEntree().getTime()) / 86400000L + 1L);
         this.hospitalisationSejour.setHossejNbJour(var2);
      } else {
         this.hospitalisationSejour.setHossejNbJour(0);
      }

   }

   public void validerSejour() throws HibernateException, NamingException, ParseException {
      this.tarifPatient((Session)null);
      if (this.hospitalisationSejour.getHossejIdMedecin() != 0L) {
         for(int var1 = 0; var1 < this.mesMedecinsItem.size(); ++var1) {
            if (((SelectItem)this.mesMedecinsItem.get(var1)).getValue().toString().equals("" + this.hospitalisationSejour.getHossejIdMedecin())) {
               this.hospitalisationSejour.setHossejMedecin(((SelectItem)this.mesMedecinsItem.get(var1)).getLabel().toString());
            }
         }
      }

      if (this.hospitalisationSejour.getHossejDateSortie() != null) {
         this.hospitalisationSejour.setHossejDateSortie(this.utilDate.dateToSQL(this.hospitalisationSejour.getHossejDateSortie(), this.var_heureDeces, this.var_minuteDeces, "00"));
      }

      Session var10 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
      if (this.hospitalisationSejour.getHossejDateSortie() == null) {
         this.hospitalisationSejour.setHossejNbJour(1);
      }

      boolean var2 = false;
      int var11;
      if (this.hospitalisationSejour.getHossejDateSortie() == null) {
         if (this.hospitalisationSejour.getHossejNbJourTheo() == 0) {
            this.hospitalisationSejour.setHossejNbJourTheo(1);
         }

         var11 = this.hospitalisationSejour.getHossejNbJourTheo();
      } else {
         var11 = this.hospitalisationSejour.getHossejNbJour();
      }

      if (this.hospitalisationSejour.getHossejLit() != null && !this.hospitalisationSejour.getHossejLit().isEmpty()) {
         this.produits = this.produitsMedicDao.chargeProduit(this.hospitalisationSejour.getHossejLit(), var10);
      }

      if (this.var_pecCnamgs != 0.0F) {
         this.sejourAvecCnamgsPrive(var11, var10);
      } else if (this.hospitalisationEntete.getHosFam() == 0L) {
         this.sejourSansCnamgsPrive(var11, var10);
      } else {
         this.sejourSansCnamgsAssure(var11, var10);
      }

      this.utilInitHibernate.closeSession();
      this.hospitalisationSejour.setPatients(this.hospitalisationEntete.getPatients());
      if (this.hospitalisationSejour.getHossejId() == 0L) {
         this.hospitalisationSejour.setHossejDateCreat(new Date());
         this.hospitalisationSejour.setHossejUserCreat(this.usersLog.getUsrid());
         this.hospitalisationSejour.setHospitalisationEntete(this.hospitalisationEntete);
         this.hospitalisationSejour = this.hospitalisationSejourDao.insert(this.hospitalisationSejour);
         this.lesSejours.add(this.hospitalisationSejour);
         this.dataModelSejours.setWrappedData(this.lesSejours);
      } else {
         this.hospitalisationSejour.setHossejDateModif(new Date());
         this.hospitalisationSejour.setHossejUserModif(this.usersLog.getUsrid());
         this.hospitalisationSejour = this.hospitalisationSejourDao.modif(this.hospitalisationSejour);
      }

      this.chargerSejour((Session)null);
      if (this.lesSejours.size() != 0) {
         String var3 = ((HospitalisationSejour)this.lesSejours.get(0)).getHossejMotifEntree();
         String var4 = ((HospitalisationSejour)this.lesSejours.get(0)).getHossejProvenance();
         String var5 = "";
         String var6 = "";
         Date var7 = null;
         int var8 = 0;

         for(int var9 = 0; var9 < this.lesSejours.size(); ++var9) {
            if (((HospitalisationSejour)this.lesSejours.get(var9)).getHossejDateSortie() == null) {
               var8 += ((HospitalisationSejour)this.lesSejours.get(var9)).getHossejNbJourTheo();
            } else {
               var8 += ((HospitalisationSejour)this.lesSejours.get(var9)).getHossejNbJour();
            }

            var5 = ((HospitalisationSejour)this.lesSejours.get(var9)).getHossejMotifSortie();
            var6 = ((HospitalisationSejour)this.lesSejours.get(var9)).getHossejDestination();
            var7 = ((HospitalisationSejour)this.lesSejours.get(var9)).getHossejDateSortie();
         }

         this.hospitalisationEntete.setHosMotifEntree(var3);
         this.hospitalisationEntete.setHosProvenance(var4);
         this.hospitalisationEntete.setHosMotifSortie(var5);
         this.hospitalisationEntete.setHosDestination(var6);
         this.hospitalisationEntete.setHosDateSortie(var7);
         this.hospitalisationEntete.setHosNbJour(var8);
         this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete);
      }

      this.afficheButtSejour = true;
      this.showModalPanelSejour = false;
   }

   public void changerService() {
      if (this.hospitalisationSejour != null) {
         this.nouveauService = "";
         this.showModalPanelChangerService = true;
      }

   }

   public void annulerChangerService() {
      this.showModalPanelChangerService = false;
   }

   public void validerChangerService() throws HibernateException, NamingException {
      if (this.hospitalisationSejour != null && this.nouveauService != null && !this.nouveauService.isEmpty() && !this.nouveauService.equals(this.hospitalisationSejour.getHossejService())) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.hospitalisationSejour.getHossejService();
            this.hospitalisationSejour.setHossejService(this.nouveauService);
            this.hospitalisationSejour = this.hospitalisationSejourDao.modif(this.hospitalisationSejour, var1);
            int var4;
            if (this.lesActes.size() != 0) {
               for(var4 = 0; var4 < this.lesActes.size(); ++var4) {
                  this.hospitalisationActes = (HospitalisationActes)this.lesActes.get(var4);
                  if (this.hospitalisationActes.getHosactIdSejour() == this.hospitalisationSejour.getHossejId()) {
                     this.hospitalisationActes.setHosactService(this.nouveauService);
                     this.hospitalisationActes = this.hospitalisationActesDao.modif(this.hospitalisationActes, var1);
                  }
               }
            }

            if (this.lesLabos.size() != 0) {
               for(var4 = 0; var4 < this.lesLabos.size(); ++var4) {
                  this.hospitalisationLabo = (HospitalisationLabo)this.lesLabos.get(var4);
                  if (this.hospitalisationLabo.getHoslabIdSejour() == this.hospitalisationSejour.getHossejId()) {
                     this.hospitalisationLabo.setHoslabService(this.nouveauService);
                     this.hospitalisationLabo = this.hospitalisationLaboDao.modif(this.hospitalisationLabo, var1);
                  }
               }
            }

            if (this.lesMedis.size() != 0) {
               for(var4 = 0; var4 < this.lesMedis.size(); ++var4) {
                  this.hospitalisationMedi = (HospitalisationMedi)this.lesMedis.get(var4);
                  if (this.hospitalisationMedi.getHosmedIdSejour() == this.hospitalisationSejour.getHossejId()) {
                     this.hospitalisationMedi.setHosmedService(this.nouveauService);
                     this.hospitalisationMedi = this.hospitalisationMediDao.modif(this.hospitalisationMedi, var1);
                  }
               }
            }

            if (this.lesPrests.size() != 0) {
               for(var4 = 0; var4 < this.lesPrests.size(); ++var4) {
                  this.hospitalisationPrest = (HospitalisationPrest)this.lesPrests.get(var4);
                  if (this.hospitalisationPrest.getHosprtIdSejour() == this.hospitalisationSejour.getHossejId()) {
                     this.hospitalisationPrest.setHosprtService(this.nouveauService);
                     this.hospitalisationPrest = this.hospitalisationPrestDao.modif(this.hospitalisationPrest, var1);
                  }
               }
            }

            new ArrayList();
            List var13 = this.reglementsDao.reglementDocument(this.hospitalisationSejour.getHossejId(), this.nature, var1);
            int var6;
            if (var13.size() != 0) {
               new Reglements();

               for(var6 = 0; var6 < var13.size(); ++var6) {
                  Reglements var5 = (Reglements)var13.get(var6);
                  if (var5.getRglService() != null && var5.getRglService().isEmpty() && var5.getRglService().equals(var3)) {
                     var5.setRglService(this.nouveauService);
                     this.reglementsDao.modifierReg(var5, var1);
                  }
               }
            }

            new ArrayList();
            List var12 = this.hospitalisationReglementDao.selectReglementByEnt(this.hospitalisationEntete, var1);
            if (var12.size() != 0) {
               for(var6 = 0; var6 < var12.size(); ++var6) {
                  this.hospitalisationReglement = (HospitalisationReglement)var12.get(var6);
                  if (this.hospitalisationReglement.getHosregIdRecu() == this.hospitalisationSejour.getHossejId()) {
                     this.hospitalisationReglement.setHosregService(this.nouveauService);
                     this.hospitalisationReglement = this.hospitalisationReglementDao.modif(this.hospitalisationReglement, var1);
                  }
               }
            }

            Espion var14 = new Espion();
            var14.setUsers(this.usersLog);
            var14.setEsptype(0);
            var14.setEspdtecreat(new Date());
            var14.setEspaction("Chg service hospit. (M.) N° " + this.hospitalisationEntete.getHosNum() + " du " + this.utilDate.dateToStringSQLLight(this.hospitalisationSejour.getHossejDateEntree()) + " du service " + var3 + " au service " + this.nouveauService);
            this.espionDao.mAJEspion(var14, var1);
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

      this.showModalPanelChangerService = false;
   }

   public void selectionCaution() {
      if (this.dataModelCaution.isRowAvailable()) {
         this.hospitalisationCaution = (HospitalisationCaution)this.dataModelCaution.getRowData();
         this.afficheButtCaution = true;
      }

   }

   public void ajouterCaution() {
      this.mesSejoursItems.clear();
      if (this.lesSejours.size() != 0) {
         int var1;
         for(var1 = 0; var1 < this.lesSejours.size(); ++var1) {
            if (((HospitalisationSejour)this.lesSejours.get(var1)).getHossejDateSortie() == null) {
               this.mesSejoursItems.add(new SelectItem(((HospitalisationSejour)this.lesSejours.get(var1)).getHossejId(), ((HospitalisationSejour)this.lesSejours.get(var1)).getHossejService()));
            }
         }

         this.hospitalisationCaution = new HospitalisationCaution();
         this.hospitalisationCaution.setHoscauDate(new Date());
         if (this.lesSejours.size() != 0) {
            var1 = this.lesSejours.size() - 1;
            this.hospitalisationCaution.setHoscauIdSejour(((HospitalisationSejour)this.lesSejours.get(var1)).getHossejId());
         }

         this.afficheButtCaution = false;
         this.showModalPanelCaution = true;
      }

   }

   public void modifierCaution() throws HibernateException, NamingException {
      if (this.hospitalisationCaution != null) {
         this.mesSejoursItems.clear();
         if (this.lesSejours.size() != 0) {
            for(int var1 = 0; var1 < this.lesSejours.size(); ++var1) {
               if (((HospitalisationSejour)this.lesSejours.get(var1)).getHossejDateSortie() == null) {
                  this.mesSejoursItems.add(new SelectItem(((HospitalisationSejour)this.lesSejours.get(var1)).getHossejId(), ((HospitalisationSejour)this.lesSejours.get(var1)).getHossejService()));
               }
            }

            this.showModalPanelCaution = true;
         }
      }

   }

   public void supprimerCaution() throws HibernateException, NamingException {
      if (this.hospitalisationCaution != null) {
         if (this.hospitalisationCaution.getHoscauId() != 0L) {
            new HospitalisationReglement();
            HospitalisationReglement var1 = this.hospitalisationReglementDao.selectReglement(this.hospitalisationCaution.getHoscauId(), (Session)null);
            if (var1 != null) {
               this.hospitalisationReglementDao.delete(var1);
            }

            this.bonEncaissementVente = this.bonEncaissementVenteDao.selectByCaution(this.hospitalisationCaution.getHoscauId(), (Session)null);
            if (this.bonEncaissementVente != null) {
               this.bonEncaissementVenteDao.delete(this.bonEncaissementVente);
            }
         }

         this.hospitalisationCautionDao.delete(this.hospitalisationCaution);
         this.lesCaution.remove(this.hospitalisationCaution);
         this.dataModelCaution.setWrappedData(this.lesCaution);
         this.hospitalisationEntete = this.hospitalisationEnteteDao.selectById(this.hospitalisationEntete.getHosId(), (Session)null);
         if (this.hospitalisationEntete != null) {
            this.calculTotaux();
            this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete);
         }

         this.afficheButtCaution = false;
      }

   }

   public void avoirCaution() throws HibernateException, NamingException {
      if (this.hospitalisationCaution != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            HospitalisationCaution var3 = new HospitalisationCaution();
            var3.setHospitalisationEntete(this.hospitalisationEntete);
            var3.setHoscauIdSejour(this.hospitalisationCaution.getHoscauIdSejour());
            var3.setHoscauMontant(this.hospitalisationCaution.getHoscauMontant());
            this.hospitalisationCaution = new HospitalisationCaution();
            this.hospitalisationCaution.setHospitalisationEntete(var3.getHospitalisationEntete());
            this.hospitalisationCaution.setHoscauCaisse("");
            this.hospitalisationCaution.setHoscauDate(new Date());
            this.hospitalisationCaution.setHoscauEtat(0);
            this.hospitalisationCaution.setHoscauIdBonEncaissement(0L);
            this.hospitalisationCaution.setHoscauIdRecu(0L);
            this.hospitalisationCaution.setHoscauIdSejour(var3.getHoscauIdSejour());
            this.hospitalisationCaution.setHoscauMontant(var3.getHoscauMontant() * -1.0D);
            this.hospitalisationCaution.setHoscauNumRecu("");
            this.hospitalisationCaution = this.hospitalisationCautionDao.insert(this.hospitalisationCaution, var1);
            this.lesCaution.add(this.hospitalisationCaution);
            this.dataModelCaution.setWrappedData(this.lesCaution);
            this.calculTotaux();
            this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
            double var4 = this.hospitalisationCaution.getHoscauMontant();
            if (var4 != 0.0D) {
               this.majBonencaissementAnnulation(Math.abs(var4), this.hospitalisationCaution.getHoscauDate(), var1);
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

   public void fermerCaution() {
      this.showModalPanelCaution = false;
   }

   public void saveCaution() throws HibernateException, NamingException {
      if (this.hospitalisationCaution.getHoscauMontant() != 0.0D) {
         boolean var1 = false;
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            if (this.hospitalisationCaution.getHoscauId() != 0L) {
               this.hospitalisationReglementDao = new HospitalisationReglementDao(this.baseLog, this.utilInitHibernate);
               new HospitalisationReglement();
               HospitalisationReglement var4 = this.hospitalisationReglementDao.selectReglement(this.hospitalisationCaution.getHoscauId(), var2);
               if (var4 != null) {
                  this.hospitalisationReglementDao.delete(var4, var2);
               }
            }

            if (this.hospitalisationCaution.getHoscauDate() == null) {
               this.hospitalisationCaution.setHoscauDate(new Date());
            }

            new HospitalisationSejour();
            HospitalisationSejour var11 = this.hospitalisationSejourDao.selectSejour(this.hospitalisationCaution.getHoscauIdSejour(), var2);
            if (this.hospitalisationSejour != null) {
               this.hospitalisationCaution.setHoscauService(var11.getHossejService());
            } else {
               this.hospitalisationCaution.setHoscauService((String)null);
            }

            boolean var5 = false;
            if (this.hospitalisationCaution.getHoscauId() == 0L) {
               var5 = true;
               this.hospitalisationCaution.setHospitalisationEntete(this.hospitalisationEntete);
               this.hospitalisationCaution = this.hospitalisationCautionDao.insert(this.hospitalisationCaution, var2);
               this.lesCaution.add(this.hospitalisationCaution);
               this.dataModelCaution.setWrappedData(this.lesCaution);
            } else {
               var5 = false;
               this.hospitalisationCaution = this.hospitalisationCautionDao.modif(this.hospitalisationCaution, var2);
            }

            this.hospitalisationEntete = this.hospitalisationEnteteDao.selectById(this.hospitalisationEntete.getHosId(), var2);
            if (this.hospitalisationEntete != null) {
               this.calculTotaux();
               this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var2);
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

         this.showModalPanelCaution = false;
      }

   }

   public void rechercheDiagnostic1() throws HibernateException, NamingException {
      if (this.hospitalisationSejour.getHossejCodeDiag1() != null && !this.hospitalisationSejour.getHossejCodeDiag1().isEmpty()) {
         this.diagSelect = 1;
         this.recherche_cmd = "";
         this.recherche_diag = "";
         this.cimMedical = new CimMedical();
         this.lesDiagnostic.clear();
         this.lesDiagnostic = this.cimMedicalDao.selectallCimMedicalDetail(this.hospitalisationSejour.getHossejCodeDiag1(), (Session)null);
         this.dataModelDiagnostic.setWrappedData(this.lesDiagnostic);
         this.showModalPaneldiagnostic = true;
      } else {
         this.hospitalisationSejour.setLib_diag1("");
      }

   }

   public void rechercheDiagnostic2() throws HibernateException, NamingException {
      if (this.hospitalisationSejour.getHossejCodeDiag2() != null && !this.hospitalisationSejour.getHossejCodeDiag2().isEmpty()) {
         this.diagSelect = 2;
         this.recherche_cmd = "";
         this.recherche_diag = "";
         this.lesDiagnostic.clear();
         this.lesDiagnostic = this.cimMedicalDao.selectallCimMedicalDetail(this.hospitalisationSejour.getHossejCodeDiag2(), (Session)null);
         this.dataModelDiagnostic.setWrappedData(this.lesDiagnostic);
         this.cimMedical = new CimMedical();
         this.showModalPaneldiagnostic = true;
      } else {
         this.hospitalisationSejour.setLib_diag2("");
      }

   }

   public void rechercheDiagnostic11() throws HibernateException, NamingException {
      if (this.hospitalisationSejour.getHossejCodeDiag11() != null && !this.hospitalisationSejour.getHossejCodeDiag11().isEmpty()) {
         this.diagSelect = 3;
         this.recherche_cmd = "";
         this.recherche_diag = "";
         this.lesDiagnostic.clear();
         this.lesDiagnostic = this.cimMedicalDao.selectallCimMedicalDetail(this.hospitalisationSejour.getHossejCodeDiag11(), (Session)null);
         this.dataModelDiagnostic.setWrappedData(this.lesDiagnostic);
         this.cimMedical = new CimMedical();
         this.showModalPaneldiagnostic = true;
      } else {
         this.hospitalisationSejour.setLib_diag11("");
      }

   }

   public void rechercheDiagnostic12() throws HibernateException, NamingException {
      if (this.hospitalisationSejour.getHossejCodeDiag12() != null && !this.hospitalisationSejour.getHossejCodeDiag12().isEmpty()) {
         this.diagSelect = 4;
         this.recherche_cmd = "";
         this.recherche_diag = "";
         this.lesDiagnostic.clear();
         this.lesDiagnostic = this.cimMedicalDao.selectallCimMedicalDetail(this.hospitalisationSejour.getHossejCodeDiag12(), (Session)null);
         this.dataModelDiagnostic.setWrappedData(this.lesDiagnostic);
         this.cimMedical = new CimMedical();
         this.showModalPaneldiagnostic = true;
      } else {
         this.hospitalisationSejour.setLib_diag12("");
      }

   }

   public void rechercheDiagnostic13() throws HibernateException, NamingException {
      if (this.hospitalisationSejour.getHossejCodeDiag13() != null && !this.hospitalisationSejour.getHossejCodeDiag13().isEmpty()) {
         this.diagSelect = 5;
         this.recherche_cmd = "";
         this.recherche_diag = "";
         this.lesDiagnostic.clear();
         this.lesDiagnostic = this.cimMedicalDao.selectallCimMedicalDetail(this.hospitalisationSejour.getHossejCodeDiag13(), (Session)null);
         this.dataModelDiagnostic.setWrappedData(this.lesDiagnostic);
         this.cimMedical = new CimMedical();
         this.showModalPaneldiagnostic = true;
      } else {
         this.hospitalisationSejour.setLib_diag13("");
      }

   }

   public void rechercheDiagnostic14() throws HibernateException, NamingException {
      if (this.hospitalisationSejour.getHossejCodeDiag14() != null && !this.hospitalisationSejour.getHossejCodeDiag14().isEmpty()) {
         this.diagSelect = 11;
         this.recherche_cmd = "";
         this.recherche_diag = "";
         this.lesDiagnostic.clear();
         this.lesDiagnostic = this.cimMedicalDao.selectallCimMedicalDetail(this.hospitalisationSejour.getHossejCodeDiag14(), (Session)null);
         this.dataModelDiagnostic.setWrappedData(this.lesDiagnostic);
         this.cimMedical = new CimMedical();
         this.showModalPaneldiagnostic = true;
      } else {
         this.hospitalisationSejour.setLib_diag14("");
      }

   }

   public void rechercheDiagnostic15() throws HibernateException, NamingException {
      if (this.hospitalisationSejour.getHossejCodeDiag15() != null && !this.hospitalisationSejour.getHossejCodeDiag15().isEmpty()) {
         this.diagSelect = 12;
         this.recherche_cmd = "";
         this.recherche_diag = "";
         this.lesDiagnostic.clear();
         this.lesDiagnostic = this.cimMedicalDao.selectallCimMedicalDetail(this.hospitalisationSejour.getHossejCodeDiag15(), (Session)null);
         this.dataModelDiagnostic.setWrappedData(this.lesDiagnostic);
         this.cimMedical = new CimMedical();
         this.showModalPaneldiagnostic = true;
      } else {
         this.hospitalisationSejour.setLib_diag15("");
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
            this.hospitalisationSejour.setHossejCodeDiag1(this.cimMedical.getCimCode());
            this.hospitalisationSejour.setLib_diag1(this.cimMedical.getCimLibelleFR());
         } else if (this.diagSelect == 2) {
            this.hospitalisationSejour.setHossejCodeDiag2(this.cimMedical.getCimCode());
            this.hospitalisationSejour.setLib_diag2(this.cimMedical.getCimLibelleFR());
         } else if (this.diagSelect == 3) {
            this.hospitalisationSejour.setHossejCodeDiag11(this.cimMedical.getCimCode());
            this.hospitalisationSejour.setLib_diag11(this.cimMedical.getCimLibelleFR());
         } else if (this.diagSelect == 4) {
            this.hospitalisationSejour.setHossejCodeDiag12(this.cimMedical.getCimCode());
            this.hospitalisationSejour.setLib_diag12(this.cimMedical.getCimLibelleFR());
         } else if (this.diagSelect == 5) {
            this.hospitalisationSejour.setHossejCodeDiag13(this.cimMedical.getCimCode());
            this.hospitalisationSejour.setLib_diag13(this.cimMedical.getCimLibelleFR());
         } else if (this.diagSelect == 11) {
            this.hospitalisationSejour.setHossejCodeDiag14(this.cimMedical.getCimCode());
            this.hospitalisationSejour.setLib_diag14(this.cimMedical.getCimLibelleFR());
         } else if (this.diagSelect == 12) {
            this.hospitalisationSejour.setHossejCodeDiag15(this.cimMedical.getCimCode());
            this.hospitalisationSejour.setLib_diag15(this.cimMedical.getCimLibelleFR());
         }
      } else {
         this.annuleDiagostic();
      }

      this.showModalPaneldiagnostic = false;
   }

   public void annuleDiagostic() {
      if (this.diagSelect == 1) {
         this.hospitalisationSejour.setHossejCodeDiag1("");
         this.hospitalisationSejour.setLib_diag1("");
      } else if (this.diagSelect == 2) {
         this.hospitalisationSejour.setHossejCodeDiag2("");
         this.hospitalisationSejour.setLib_diag2("");
      } else if (this.diagSelect == 3) {
         this.hospitalisationSejour.setHossejCodeDiag11("");
         this.hospitalisationSejour.setLib_diag11("");
      } else if (this.diagSelect == 4) {
         this.hospitalisationSejour.setHossejCodeDiag12("");
         this.hospitalisationSejour.setLib_diag12("");
      } else if (this.diagSelect == 5) {
         this.hospitalisationSejour.setHossejCodeDiag13("");
         this.hospitalisationSejour.setLib_diag13("");
      } else if (this.diagSelect == 11) {
         this.hospitalisationSejour.setHossejCodeDiag14("");
         this.hospitalisationSejour.setLib_diag14("");
      } else if (this.diagSelect == 12) {
         this.hospitalisationSejour.setHossejCodeDiag15("");
         this.hospitalisationSejour.setLib_diag15("");
      }

      this.showModalPaneldiagnostic = false;
   }

   public void majRaccourciPersonnel() throws HibernateException, NamingException {
      if (this.cimMedical != null) {
         this.cimMedical = this.cimMedicalDao.modif(this.cimMedical);
      }

   }

   public void selectionConsultation() {
      if (this.dataModelConsultation.isRowAvailable()) {
         this.consultationEnteteGene = (ConsultationEnteteGene)this.dataModelConsultation.getRowData();
         this.afficheButtConsultation = true;
      }

   }

   public void ajouterConsultation() {
      this.mesSejoursItems.clear();
      if (this.lesSejours.size() != 0) {
         for(int var1 = 0; var1 < this.lesSejours.size(); ++var1) {
            if (((HospitalisationSejour)this.lesSejours.get(var1)).getHossejDateSortie() == null) {
               this.mesSejoursItems.add(new SelectItem(((HospitalisationSejour)this.lesSejours.get(var1)).getHossejId(), ((HospitalisationSejour)this.lesSejours.get(var1)).getHossejService()));
            }
         }

         this.consultationEnteteGene = new ConsultationEnteteGene();
         this.afficheButtConsultation = false;
         this.showModalPanelConsultation = true;
      }

   }

   public void modifierConsultation() {
      if (this.consultationEnteteGene != null) {
         this.showModalPanelConsultation = true;
      }

   }

   public void supprimerConsultation() throws HibernateException, NamingException {
      if (this.consultationEnteteGene != null) {
         this.consultationEnteteGeneDao.delete(this.consultationEnteteGene);
         this.lesConsultations.remove(this.consultationEnteteGene);
         this.dataModelConsultation.setWrappedData(this.lesConsultations);
         this.afficheButtConsultation = false;
      }

   }

   public void fermerConsultation() {
      this.afficheButtConsultation = false;
      this.showModalPanelConsultation = false;
   }

   public void validerConsultation() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.consultationEnteteGene.getCsgIdMedecin() != 0L) {
            new Users();
            Users var3 = this.usersDao.selectUserD(this.consultationEnteteGene.getCsgIdMedecin(), var1);
            if (var3 != null) {
               this.consultationEnteteGene.setCsgIdMedecin(var3.getUsrid());
               this.consultationEnteteGene.setCsgMedecin(var3.getUsrPatronyme());
            } else {
               this.consultationEnteteGene.setCsgIdMedecin(0L);
               this.consultationEnteteGene.setCsgMedecin("");
            }
         } else {
            this.consultationEnteteGene.setCsgIdMedecin(0L);
            this.consultationEnteteGene.setCsgMedecin("");
         }

         if (this.consultationEnteteGene.getCsgId() == 0L) {
            this.consultationEnteteGene.setCsgDate(new Date());
            this.consultationEnteteGene.setCsgDateCreat(new Date());
            this.consultationEnteteGene.setCsgNomCreateur(this.usersLog.getUsrPatronyme());
            this.consultationEnteteGene.setCsgIdCreateur(this.usersLog.getUsrid());
            this.consultationEnteteGene.setCsgNumHospit(this.hospitalisationEntete.getHosNum());
            this.consultationEnteteGene.setCsgNumRum(this.hospitalisationEntete.getHosNumRum());
            this.consultationEnteteGene.setCsgIdPatient(this.hospitalisationEntete.getHosIdPatient());
            this.consultationEnteteGene.setCsgNomPatient(this.hospitalisationEntete.getHosNomPatient());
            this.consultationEnteteGene.setPatients(this.patients);
            this.consultationEnteteGene.setExerciceventes(this.exercicesVentes);
            this.consultationEnteteGene = this.consultationEnteteGeneDao.insert(this.consultationEnteteGene, var1);
            this.lesConsultations.add(this.consultationEnteteGene);
            this.dataModelConsultation.setWrappedData(this.lesConsultations);
         } else {
            this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
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

      this.showModalPanelConsultation = false;
   }

   public void calculIcm() {
      if (this.consultationEnteteGene.getCsgPoids() != 0.0F && this.consultationEnteteGene.getCsgTaille() != 0.0F) {
         float var1 = this.consultationEnteteGene.getCsgPoids() / (this.consultationEnteteGene.getCsgTaille() * this.consultationEnteteGene.getCsgTaille()) * 10000.0F;
         this.consultationEnteteGene.setCsgImc(var1);
      }

   }

   public void verifValideConsultation() {
      this.valideConsultation = false;
      if (this.consultationEnteteGene.getCsgIdSejour() != 0L) {
         if (this.optionMedical.getMedecinCG().equals("0")) {
            if (this.consultationEnteteGene.getCsgIdMedecin() != 0L) {
               this.valideConsultation = true;
            }
         } else {
            this.valideConsultation = true;
         }
      }

   }

   public void selectionActes() {
      if (this.dataModelActes.isRowAvailable()) {
         this.hospitalisationActes = (HospitalisationActes)this.dataModelActes.getRowData();
         this.afficheButtActes = true;
         this.valideActe = true;
      }

   }

   public void ajouterActes() {
      this.presenceActeLie = false;
      this.nomActeLie = "";
      this.qteActeLie = 0.0F;
      this.mesSejoursItems.clear();
      if (this.lesSejours.size() != 0) {
         int var1;
         for(var1 = 0; var1 < this.lesSejours.size(); ++var1) {
            if (((HospitalisationSejour)this.lesSejours.get(var1)).getHossejDateSortie() == null) {
               this.mesSejoursItems.add(new SelectItem(((HospitalisationSejour)this.lesSejours.get(var1)).getHossejId(), ((HospitalisationSejour)this.lesSejours.get(var1)).getHossejService()));
            }
         }

         this.ccamMedical = new CcamMedical();
         this.hospitalisationActes = new HospitalisationActes();
         if (this.lesActes.size() != 0) {
            var1 = this.lesActes.size() - 1;
            this.hospitalisationActes.setHosactIdSejour(((HospitalisationActes)this.lesActes.get(var1)).getHosactIdSejour());
            this.hospitalisationActes.setHosactIdMedecin(((HospitalisationActes)this.lesActes.get(var1)).getHosactIdMedecin());
            this.hospitalisationActes.setHosactMedecin(((HospitalisationActes)this.lesActes.get(var1)).getHosactMedecin());
            this.hospitalisationActes.setHosactService(((HospitalisationActes)this.lesActes.get(var1)).getHosactService());
         } else if (this.lesSejours.size() != 0) {
            var1 = this.lesSejours.size() - 1;
            this.hospitalisationActes.setHosactIdSejour(((HospitalisationSejour)this.lesSejours.get(var1)).getHossejId());
            this.hospitalisationActes.setHosactService(((HospitalisationSejour)this.lesSejours.get(var1)).getHossejService());
         }

         this.var_lettre = "";
         this.valideActe = false;
         this.afficheButtActes = false;
         this.showModalPanelActes = true;
      }

   }

   public void modifierActes() throws HibernateException, NamingException {
      this.presenceActeLie = false;
      this.nomActeLie = "";
      this.qteActeLie = 0.0F;
      if (this.hospitalisationActes != null) {
         this.mesSejoursItems.clear();
         if (this.lesSejours.size() != 0) {
            for(int var1 = 0; var1 < this.lesSejours.size(); ++var1) {
               if (((HospitalisationSejour)this.lesSejours.get(var1)).getHossejDateSortie() == null) {
                  this.mesSejoursItems.add(new SelectItem(((HospitalisationSejour)this.lesSejours.get(var1)).getHossejId(), ((HospitalisationSejour)this.lesSejours.get(var1)).getHossejService()));
               }
            }

            this.calculMedecinActe();
            this.verifValideActe();
            this.showModalPanelActes = true;
         }
      }

   }

   public void supprimerActe() throws HibernateException, NamingException {
      this.presenceActeLie = false;
      this.nomActeLie = "";
      this.qteActeLie = 0.0F;
      if (this.hospitalisationActes != null) {
         this.hospitalisationActesDao.delete(this.hospitalisationActes);
         this.lesActes.remove(this.hospitalisationActes);
         this.dataModelActes.setWrappedData(this.lesActes);
         this.calculTotaux();
         this.hospitalisationEnteteDao.modif(this.hospitalisationEntete);
         this.afficheButtActes = false;
      }

   }

   public void avoirActe() throws HibernateException, NamingException {
      if (this.hospitalisationActes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            HospitalisationActes var3 = new HospitalisationActes();
            var3.setHospitalisationEntete(this.hospitalisationEntete);
            var3.setHosactAssuranceHt(this.hospitalisationActes.getHosactAssuranceHt() * -1.0D);
            var3.setHosactAssuranceTaxe(this.hospitalisationActes.getHosactAssuranceTaxe() * -1.0D);
            var3.setHosactCodeTva(this.hospitalisationActes.getHosactCodeTva());
            var3.setHosactCoef(this.hospitalisationActes.getHosactCoef());
            var3.setHosactComplementaireHt(this.hospitalisationActes.getHosactComplementaireHt() * -1.0D);
            var3.setHosactComplementaireTaxe(this.hospitalisationActes.getHosactComplementaireTaxe() * -1.0D);
            var3.setHosactIdMedecin(this.hospitalisationActes.getHosactIdMedecin());
            var3.setHosactIdSejour(this.hospitalisationActes.getHosactIdSejour());
            var3.setHosactLettre(this.hospitalisationActes.getHosactLettre());
            var3.setHosactLibelle(this.hospitalisationActes.getHosactLibelle());
            var3.setHosactMedecin(this.hospitalisationActes.getHosactMedecin());
            var3.setHosactNb(this.hospitalisationActes.getHosactNb());
            var3.setHosactNbCnamgs(this.hospitalisationActes.getHosactNbCnamgs());
            var3.setHosactPatientHt(this.hospitalisationActes.getHosactPatientHt() * -1.0D);
            var3.setHosactPatientTaxe(this.hospitalisationActes.getHosactPatientTaxe() * -1.0D);
            var3.setHosactProduit(this.hospitalisationActes.getHosactProduit());
            var3.setHosactProduitLie(this.hospitalisationActes.getHosactProduitLie());
            var3.setHosactPu(this.hospitalisationActes.getHosactPu());
            var3.setHosactPuAssurance(this.hospitalisationActes.getHosactPuAssurance());
            var3.setHosactPuCnamgs(this.hospitalisationActes.getHosactPuCnamgs());
            var3.setHosactPuRem(this.hospitalisationActes.getHosactPuRem());
            var3.setHosactQte(this.hospitalisationActes.getHosactQte() * -1.0F);
            var3.setHosactRegPatient(0.0D);
            var3.setHosactRegTiers(0.0D);
            var3.setHosactRemise(this.hospitalisationActes.getHosactRemise());
            var3.setHosactService(this.hospitalisationActes.getHosactService());
            var3.setHosactSocieteHt(this.hospitalisationActes.getHosactSocieteHt() * -1.0D);
            var3.setHosactSocieteTaxe(this.hospitalisationActes.getHosactSocieteTaxe() * -1.0D);
            var3.setHosactTauxTva(this.hospitalisationActes.getHosactTauxTva());
            var3.setHosactTaxe(this.hospitalisationActes.getHosactTaxe() * -1.0D);
            var3.setHosactTotal(this.hospitalisationActes.getHosactTotal() * -1.0D);
            var3.setHosactValeur(this.hospitalisationActes.getHosactValeur());
            var3.setHosactValeurCnamgs(this.hospitalisationActes.getHosactValeurCnamgs());
            this.hospitalisationActes = new HospitalisationActes();
            this.hospitalisationActes = var3;
            this.hospitalisationActes = this.hospitalisationActesDao.insert(this.hospitalisationActes, var1);
            this.lesActes.add(this.hospitalisationActes);
            this.dataModelActes.setWrappedData(this.lesActes);
            this.calculTotaux();
            this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
            double var4 = this.hospitalisationActes.getHosactPatientHt() + this.hospitalisationActes.getHosactPatientTaxe();
            if (var4 != 0.0D) {
               this.majBonencaissementAnnulation(Math.abs(var4), new Date(), var1);
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

         this.ajouterActes();
      }

   }

   public void annulationActe() throws NamingException {
      if (this.hospitalisationActes != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            HospitalisationActes var3 = new HospitalisationActes();
            var3.setHospitalisationEntete(this.hospitalisationEntete);
            var3.setHosactAssuranceHt(this.hospitalisationActes.getHosactAssuranceHt() * -1.0D);
            var3.setHosactAssuranceTaxe(this.hospitalisationActes.getHosactAssuranceTaxe() * -1.0D);
            var3.setHosactCodeTva(this.hospitalisationActes.getHosactCodeTva());
            var3.setHosactCoef(this.hospitalisationActes.getHosactCoef());
            var3.setHosactComplementaireHt(this.hospitalisationActes.getHosactComplementaireHt() * -1.0D);
            var3.setHosactComplementaireTaxe(this.hospitalisationActes.getHosactComplementaireTaxe() * -1.0D);
            var3.setHosactIdMedecin(this.hospitalisationActes.getHosactIdMedecin());
            var3.setHosactIdSejour(this.hospitalisationActes.getHosactIdSejour());
            var3.setHosactLettre(this.hospitalisationActes.getHosactLettre());
            var3.setHosactLibelle(this.hospitalisationActes.getHosactLibelle());
            var3.setHosactMedecin(this.hospitalisationActes.getHosactMedecin());
            var3.setHosactNb(this.hospitalisationActes.getHosactNb());
            var3.setHosactNbCnamgs(this.hospitalisationActes.getHosactNbCnamgs());
            var3.setHosactPatientHt(this.hospitalisationActes.getHosactPatientHt() * -1.0D);
            var3.setHosactPatientTaxe(this.hospitalisationActes.getHosactPatientTaxe() * -1.0D);
            var3.setHosactProduit(this.hospitalisationActes.getHosactProduit());
            var3.setHosactProduitLie(this.hospitalisationActes.getHosactProduitLie());
            var3.setHosactPu(this.hospitalisationActes.getHosactPu());
            var3.setHosactPuAssurance(this.hospitalisationActes.getHosactPuAssurance());
            var3.setHosactPuCnamgs(this.hospitalisationActes.getHosactPuCnamgs());
            var3.setHosactPuRem(this.hospitalisationActes.getHosactPuRem());
            var3.setHosactQte(this.hospitalisationActes.getHosactQte() * -1.0F);
            var3.setHosactRegPatient(0.0D);
            var3.setHosactRegTiers(0.0D);
            var3.setHosactRemise(this.hospitalisationActes.getHosactRemise());
            var3.setHosactService(this.hospitalisationActes.getHosactService());
            var3.setHosactSocieteHt(this.hospitalisationActes.getHosactSocieteHt() * -1.0D);
            var3.setHosactSocieteTaxe(this.hospitalisationActes.getHosactSocieteTaxe() * -1.0D);
            var3.setHosactTauxTva(this.hospitalisationActes.getHosactTauxTva());
            var3.setHosactTaxe(this.hospitalisationActes.getHosactTaxe() * -1.0D);
            var3.setHosactTotal(this.hospitalisationActes.getHosactTotal() * -1.0D);
            var3.setHosactValeur(this.hospitalisationActes.getHosactValeur());
            var3.setHosactValeurCnamgs(this.hospitalisationActes.getHosactValeurCnamgs());
            this.hospitalisationActes = new HospitalisationActes();
            this.hospitalisationActes = var3;
            this.hospitalisationActes = this.hospitalisationActesDao.insert(this.hospitalisationActes, var1);
            this.lesActes.add(this.hospitalisationActes);
            this.dataModelActes.setWrappedData(this.lesActes);
            this.calculTotaux();
            this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.ajouterActes();
      }

   }

   public void fermerActes() {
      this.hospitalisationActes.setHosactProduit("");
      this.hospitalisationActes.setHosactLibelle("");
      this.verifValideActe();
      this.showModalPanelActes = false;
   }

   public void saveActe() throws HibernateException, NamingException {
      if (this.hospitalisationActes.getHosactQte() != 0.0F) {
         if (this.hospitalisationActes != null) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
            Transaction var2 = null;

            try {
               var2 = var1.beginTransaction();
               this.tarifPatient(var1);
               this.calculPrixActe(0.0D, 0.0D, this.hospitalisationActes.getHosactQte(), var1);
               if (this.hospitalisationActes.getHosactIdMedecin() != 0L) {
                  new Users();
                  Users var3 = this.usersDao.selectUserD(this.hospitalisationActes.getHosactIdMedecin(), var1);
                  if (var3 != null) {
                     this.hospitalisationActes.setHosactIdMedecin(var3.getUsrid());
                     this.hospitalisationActes.setHosactMedecin(var3.getUsrPatronyme());
                  } else {
                     this.hospitalisationActes.setHosactIdMedecin(0L);
                     this.hospitalisationActes.setHosactMedecin("");
                  }
               } else {
                  this.hospitalisationActes.setHosactIdMedecin(0L);
                  this.hospitalisationActes.setHosactMedecin("");
               }

               boolean var13 = false;
               if (this.hospitalisationActes.getHosactId() == 0L) {
                  var13 = true;
                  this.hospitalisationActes.setHosactDateCreat(new Date());
                  this.hospitalisationActes.setHosactUserCreat(this.usersLog.getUsrid());
                  this.hospitalisationActes.setHospitalisationEntete(this.hospitalisationEntete);
                  this.hospitalisationActes = this.hospitalisationActesDao.insert(this.hospitalisationActes, var1);
                  this.lesActes.add(this.hospitalisationActes);
                  this.dataModelActes.setWrappedData(this.lesActes);
               } else {
                  var13 = false;
                  this.hospitalisationActes.setHosactDateModif(new Date());
                  this.hospitalisationActes.setHosactUserModif(this.usersLog.getUsrid());
                  this.hospitalisationActes = this.hospitalisationActesDao.modif(this.hospitalisationActes, var1);
               }

               HospitalisationActes var4;
               if (!var13 && this.produits != null && this.presenceActeLie) {
                  new HospitalisationActes();

                  for(int var5 = 0; var5 < this.lesActes.size(); ++var5) {
                     var4 = (HospitalisationActes)this.lesActes.get(var5);
                     if (var4.getHosactIdSejour() == this.hospitalisationActes.getHosactIdSejour() && this.hospitalisationActes.getHosactProduitLie() != null && !this.hospitalisationActes.getHosactProduitLie().isEmpty() && var4.getHosactProduit().equals(this.hospitalisationActes.getHosactProduitLie())) {
                        this.hospitalisationActesDao.delete(var4, var1);
                        this.lesActes.remove(var4);
                     }
                  }
               }

               if (this.produits != null && this.presenceActeLie && this.qteActeLie != 0.0F) {
                  new HospitalisationActes();
                  var4 = this.hospitalisationActes;
                  float var14 = this.qteActeLie * this.hospitalisationActes.getHosactQte();
                  this.produits = this.produitsMedicDao.chargeProduit(this.nomActeLie, var1);
                  if (this.produits != null) {
                     float var6 = 0.0F;
                     this.hospitalisationActes = new HospitalisationActes();
                     this.hospitalisationActes.setHosactCodeTva(var4.getHosactCodeTva());
                     this.hospitalisationActes.setHosactCoef(var4.getHosactCoef());
                     this.hospitalisationActes.setHosactIdMedecin(var4.getHosactIdMedecin());
                     this.hospitalisationActes.setHosactIdSejour(var4.getHosactIdSejour());
                     this.hospitalisationActes.setHosactLettre(var4.getHosactLettre());
                     this.hospitalisationActes.setHosactLibelle(var4.getHosactLibelle());
                     this.hospitalisationActes.setHosactMedecin(var4.getHosactMedecin());
                     this.hospitalisationActes.setHosactNb(var4.getHosactNb());
                     this.hospitalisationActes.setHosactNbCnamgs(var4.getHosactNbCnamgs());
                     this.hospitalisationActes.setHosactProduit(this.produits.getProCode());
                     if (var6 == 0.0F) {
                        var6 = var14;
                     }

                     this.hospitalisationActes.setHosactRemise(var4.getHosactRemise());
                     if (this.produits.getProCode() != null && !this.produits.getProCode().isEmpty() && this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty()) {
                        if (!this.produits.getProActivite().contains("#")) {
                           this.hospitalisationActes.setHosactService(this.produits.getProActivite());
                        } else {
                           String[] var7 = this.produits.getProActivite().split("#");
                           this.hospitalisationActes.setHosactService(var7[0]);
                        }
                     } else {
                        this.hospitalisationActes.setHosactService(var4.getHosactService());
                     }

                     this.hospitalisationActes.setHosactTauxTva(var4.getHosactTauxTva());
                     this.hospitalisationActes.setHosactPu(var4.getHosactPu());
                     this.hospitalisationActes.setHosactPuCnamgs(var4.getHosactPuCnamgs());
                     this.hospitalisationActes.setHosactPuRem(var4.getHosactPuRem());
                     this.calculPrixActe(var4.getHosactPu(), var4.getHosactPuCnamgs(), var6, var1);
                     this.hospitalisationActes.setHospitalisationEntete(this.hospitalisationEntete);
                     this.hospitalisationActes = this.hospitalisationActesDao.insert(this.hospitalisationActes, var1);
                     this.lesActes.add(this.hospitalisationActes);
                     this.dataModelActes.setWrappedData(this.lesActes);
                  }
               }

               this.calculTotaux();
               this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
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

         this.verifValideActe();
         this.showModalPanelActes = false;
      }

   }

   public void verifValideActe() {
      this.valideActe = false;
      if (this.hospitalisationActes.getHosactIdSejour() != 0L) {
         if (this.optionMedical.getMedecinHP().equals("0")) {
            if (this.hospitalisationActes.getHosactIdMedecin() != 0L && this.hospitalisationActes.getHosactProduit() != null && !this.hospitalisationActes.getHosactProduit().isEmpty()) {
               this.valideActe = true;
            }
         } else if (this.hospitalisationActes.getHosactProduit() != null && !this.hospitalisationActes.getHosactProduit().isEmpty()) {
            this.valideActe = true;
         }
      }

   }

   public void rechercheActes() throws HibernateException, NamingException {
      this.extDTableProduits = new HtmlExtendedDataTable();
      if (this.simpleSelectionProduits == null) {
         this.simpleSelectionProduits = new SimpleSelection();
      }

      this.simpleSelectionProduits.clear();
      this.extDTableCCAM = new HtmlExtendedDataTable();
      if (this.simpleSelectionCCAM == null) {
         this.simpleSelectionCCAM.clear();
      }

      this.choixPanenProd = 1;
      if (this.hospitalisationActes.getHosactProduit() != null && !this.hospitalisationActes.getHosactProduit().isEmpty()) {
         this.lesActesCCAM.clear();
         this.lesProduits.clear();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "CcamMedical");
         if (this.optionMedical.getActeCcam().equals("true")) {
            this.lesActesCCAM = this.ccamMedicalDao.selectallCcamMedicalActe(this.hospitalisationActes.getHosactProduit(), var1);
         }

         if (this.optionMedical.getActeNgap().equals("true")) {
         }

         if (this.optionMedical.getActePerso().equals("true")) {
            this.lesProduits = this.produitsMedicDao.verifProduitsMedicaux(this.hospitalisationActes.getHosactProduit(), "1104", var1);
         }

         this.utilInitHibernate.closeSession();
         if (this.lesActesCCAM.size() == 1 && this.lesProduits.size() == 0) {
            this.ccamMedical = (CcamMedical)this.lesActesCCAM.get(0);
            this.produits = new Produits();
            this.acteCCAM();
            this.valideActes();
         } else if (this.lesActesCCAM.size() == 0 && this.lesProduits.size() == 1) {
            this.produits = (Produits)this.lesProduits.get(0);
            this.ccamMedical = new CcamMedical();
            this.actePerso();
            this.valideActes();
         } else if (this.lesActesCCAM.size() <= 1 && this.lesProduits.size() <= 1) {
            this.annuleActes();
         } else {
            this.ccamMedical = new CcamMedical();
            this.produits = new Produits();
            this.acteCCAM();
            this.datamodelProduits.setWrappedData(this.lesProduits);
            this.datamodelProduitsCCAM.setWrappedData(this.lesActesCCAM);
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

            this.showModalPanelListeActes = true;
         }
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
            this.presenceActeLie = false;
            this.nomActeLie = "";
            this.qteActeLie = 0.0F;
            this.acteCCAM();
            this.var_lettre = "";
            this.produits = new Produits();
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
            if (this.produits.getProCodeLie() != null && !this.produits.getProCodeLie().isEmpty()) {
               this.presenceActeLie = true;
               this.nomActeLie = this.produits.getProCodeLie();
               this.qteActeLie = this.produits.getProQteLie();
            } else {
               this.presenceActeLie = false;
               this.nomActeLie = "";
               this.qteActeLie = 0.0F;
            }

            this.actePerso();
            this.var_lettre = "";
            this.ccamMedical = new CcamMedical();
         }
      }

   }

   public void acteCCAM() {
      this.typeActe = 0;
   }

   public void actePerso() {
      this.typeActe = 1;
   }

   public void valideActes() throws HibernateException, NamingException {
      if (this.typeActe == 0 && this.ccamMedical != null) {
         this.lesTarifs.clear();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         this.produits = this.produitsMedicDao.chargeProduit(this.ccamMedical.getCcamDetCode(), var1);
         if (this.produits != null) {
            this.hospitalisationActes.setHosactProduit(this.produits.getProCode());
            this.validesActesSuite(var1);
         } else {
            this.utilInitHibernate.closeSession();
            this.produits = new Produits();
            this.produits.setProCode(this.ccamMedical.getCcamDetCode());
            this.produits.setProLibClient(this.ccamMedical.getCcamDetLibFr().substring(0, this.ccamMedical.getCcamDetLibFr().length()).toUpperCase());
            this.produits.setProVteCode((String)null);
            this.produits.setProVteNat((String)null);
            this.produits.setProVteTva((String)null);
            this.produits.setProLettre((String)null);
            new ObjetCategories();

            for(int var3 = 0; var3 < this.lesCategoriesList.size(); ++var3) {
               ObjetCategories var2 = (ObjetCategories)this.lesCategoriesList.get(var3);
               this.produitsTarif = new ProduitsTarif();
               this.produitsTarif.setProtarClient(var2.getLibelle_FR());
               this.produitsTarif.setProtarLettre("");
               this.produitsTarif.setProtarOrdre(Integer.parseInt(var2.getCode()));
               this.produitsTarif.setProtarCoef(var2.getCoef());
               this.lesTarifs.add(this.produitsTarif);
            }

            this.lettreActe = null;
            this.showModalPanelCreationActe = true;
         }

         this.utilInitHibernate.closeSession();
      } else if (this.typeActe == 1 && this.produits != null) {
         this.hospitalisationActes.setHosactProduit(this.produits.getProCode());
         this.validesActesSuite((Session)null);
      }

   }

   public void validesActesSuite(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         var2 = true;
      }

      this.mesServicesFacturesActes.clear();
      if (this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty()) {
         if (!this.produits.getProActivite().contains("#")) {
            this.mesServicesFacturesActes.add(new SelectItem(this.produits.getProActivite()));
         } else {
            String[] var3 = this.produits.getProActivite().split("#");
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
               this.mesServicesFacturesActes.add(new SelectItem(var3[var5]));
            }
         }
      } else {
         this.mesServicesFacturesActes.add(new SelectItem(((HospitalisationSejour)this.lesSejours.get(this.lesSejours.size() - 1)).getHossejService()));
      }

      this.calculPrixActe(0.0D, 0.0D, 0.0F, var1);
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelListeActes = false;
   }

   public void calculPrixActe() throws HibernateException, NamingException {
      this.calculPrixActe(0.0D, 0.0D, 0.0F, (Session)null);
   }

   public void calculPrixActe(double var1, double var3, float var5, Session var6) throws HibernateException, NamingException {
      float var7 = 1.0F;
      double var8 = 0.0D;
      double var10 = 0.0D;
      double var12 = 0.0D;
      double var14 = this.hospitalisationActes.getHosactPu();
      double var16 = this.hospitalisationActes.getHosactPuCnamgs();
      double var18 = this.hospitalisationActes.getHosactPuAssurance();
      boolean var20 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         var20 = true;
      }

      this.produits = this.produitsMedicDao.chargeProduit(this.hospitalisationActes.getHosactProduit(), var6);
      if (this.produits != null) {
         this.hospitalisationActes.setHosactProduit(this.produits.getProCode());
         this.hospitalisationActes.setHosactLibelle(this.produits.getProLibClient());
         this.hospitalisationActes.setHosactProduitLie(this.produits.getProCodeLie());
         this.hospitalisationActes.setHosactLettre(this.produits.getProLettre());
         if (this.produits.getProLettre() != null && !this.produits.getProLettre().isEmpty()) {
            this.hospitalisationActes.setHosactLettre(this.produits.getProLettre());
         } else {
            this.hospitalisationActes.setHosactLettre("");
            this.hospitalisationActes.setHosactNb(0.0F);
            this.hospitalisationActes.setHosactNbCnamgs(0.0F);
         }

         if (var5 == 0.0F) {
            var5 = 1.0F;
         }

         this.hospitalisationActes.setHosactQte(var5);
         this.hospitalisationActes.setHosactCodeTva(this.produits.getProVteTva());
         this.hospitalisationActes.setHosactTauxTva(0.0F);
         if (this.hospitalisationActes.getHosactCodeTva() != null && !this.hospitalisationActes.getHosactCodeTva().isEmpty()) {
            this.taxesMedical = this.taxesMedicalDao.selectTva(this.exercicesVentes.getExevteId(), this.hospitalisationActes.getHosactCodeTva(), var6);
            if (this.taxesMedical != null) {
               this.hospitalisationActes.setHosactTauxTva(this.taxesMedical.getTaxvteTaux());
            }
         }

         String var21 = this.hospitalisationEntete.getLibelleFamille();
         int var22;
         if (var21.startsWith("Assuré") && this.optionMedical.getTarifSociete().equals("1")) {
            var21 = "Non Assuré";
         } else if (var21.startsWith("Assuré") && this.optionMedical.getTarifSociete().equals("2")) {
            var21 = "Assuré";

            for(var22 = 0; var22 < this.mesCategoriesItems.size(); ++var22) {
               if (Long.parseLong(((SelectItem)this.mesCategoriesItems.get(var22)).getValue().toString()) == this.nomFamille) {
                  if (((SelectItem)this.mesCategoriesItems.get(var22)).getLabel().toString().startsWith("Société")) {
                     var21 = "Société";
                  } else {
                     var21 = "Assuré";
                  }
                  break;
               }
            }
         } else if (var21.equals("Cas Social")) {
            var21 = "Non Assuré";
         } else if (var21.startsWith("Non Assuré") && this.var_pecCnamgs != 0.0F) {
            var21 = "CNAMGS";
         } else {
            var21 = "Non Assuré";
         }

         this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, var21, var6);
         if (this.produitsTarif != null) {
            if (var1 == 0.0D && var3 == 0.0D) {
               var7 = this.produitsTarif.getProtarCoef();
               var8 = this.produitsTarif.getProtarPv();
               var10 = this.produitsTarif.getProtarPvCnamgs();
               this.hospitalisationActes.setHosactNb(this.produitsTarif.getProtarNb());
               this.hospitalisationActes.setHosactNbCnamgs(this.produitsTarif.getProtarNbCnamgs());
               this.hospitalisationActes.setHosactValeur(this.produitsTarif.getProtarValeur());
               this.hospitalisationActes.setHosactValeurCnamgs(this.produitsTarif.getProtarValeurCnamgs());
            } else {
               if (var5 == 0.0F) {
                  var5 = 1.0F;
               }

               var7 = var5;
               var8 = var1;
               var10 = var3;
               this.hospitalisationActes.setHosactNb(0.0F);
               this.hospitalisationActes.setHosactNbCnamgs(0.0F);
               this.hospitalisationActes.setHosactValeur(var1);
               this.hospitalisationActes.setHosactValeurCnamgs(var3);
            }

            if (var7 == 0.0F) {
               var7 = 1.0F;
               if (this.lesCategoriesList.size() != 0) {
                  for(var22 = 0; var22 < this.lesCategoriesList.size(); ++var22) {
                     if (((ObjetCategories)this.lesCategoriesList.get(var22)).getLibelle_FR().equals(this.hospitalisationEntete.getLibelleFamille())) {
                        var7 = ((ObjetCategories)this.lesCategoriesList.get(var22)).getCoef();
                        break;
                     }
                  }
               }
            }

            this.hospitalisationActes.setHosactCoef(var7);
            if (var14 != 0.0D) {
               var8 = var14;
            }

            this.hospitalisationActes.setHosactPu(var8);
            if (var16 != 0.0D) {
               var10 = var16;
            }

            this.hospitalisationActes.setHosactPuCnamgs(var10);
            if (var18 != 0.0D) {
               var12 = var18;
            }

            this.hospitalisationActes.setHosactPuAssurance(var12);
            if (this.hospitalisationEntete.getHosFam() >= 1L) {
               this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 0, var6);
               if (this.patientPec != null) {
                  this.conventionMedical = this.conventionMedicalDao.trouveConvention(this.patientPec.getTiers().getTieid(), this.hospitalisationActes.getHosactProduit(), var6);
                  if (this.conventionMedical != null) {
                     this.hospitalisationActes.setHosactPuAssurance(this.conventionMedical.getCvnValeur());
                     if (this.conventionMedical.getCvnValeurOrigine() != 0.0D) {
                        this.hospitalisationActes.setHosactPu(this.conventionMedical.getCvnValeurOrigine());
                     }
                  }
               }
            }

            if (this.hospitalisationActes.getHosactQte() == 0.0F) {
               this.hospitalisationActes.setHosactQte(1.0F);
            }
         } else {
            this.hospitalisationActes.setHosactLettre("");
            this.hospitalisationActes.setHosactNb(0.0F);
            this.hospitalisationActes.setHosactNbCnamgs(0.0F);
            this.hospitalisationActes.setHosactCoef(0.0F);
            this.hospitalisationActes.setHosactValeur(0.0D);
            this.hospitalisationActes.setHosactValeurCnamgs(0.0D);
            this.hospitalisationActes.setHosactPu(var14);
            this.hospitalisationActes.setHosactPuCnamgs(var16);
            this.hospitalisationActes.setHosactPuAssurance(var18);
            if (this.hospitalisationActes.getHosactQte() == 0.0F) {
               this.hospitalisationActes.setHosactQte(1.0F);
            }
         }
      } else {
         this.hospitalisationActes.setHosactProduitLie("");
         this.hospitalisationActes.setHosactLettre("");
         this.hospitalisationActes.setHosactNb(0.0F);
         this.hospitalisationActes.setHosactNbCnamgs(0.0F);
         this.hospitalisationActes.setHosactCoef(0.0F);
         this.hospitalisationActes.setHosactValeur(0.0D);
         this.hospitalisationActes.setHosactValeurCnamgs(0.0D);
         this.hospitalisationActes.setHosactPu(var14);
         this.hospitalisationActes.setHosactPuCnamgs(var16);
         this.hospitalisationActes.setHosactPuAssurance(var18);
         if (this.hospitalisationActes.getHosactQte() == 0.0F) {
            this.hospitalisationActes.setHosactQte(1.0F);
         }
      }

      if (this.var_pecCnamgs != 0.0F) {
         this.acteAvecCnamgsPrive(var6);
      } else if (this.hospitalisationEntete.getHosFam() != 0L && this.hospitalisationEntete.getHosFam() != -1L) {
         this.acteSansCnamgsAssure(var6);
      } else {
         this.acteSansCnamgsPrive(var6);
      }

      if (var20) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void acteSansCnamgsAssure(Session var1) throws HibernateException, NamingException {
      double var2;
      if (this.hospitalisationActes.getHosactRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.hospitalisationActes.getHosactPu() * (double)this.hospitalisationActes.getHosactRemise() / 100.0D, this.structureLog.getStrdevise());
         this.hospitalisationActes.setHosactPuRem(this.hospitalisationActes.getHosactPu() - var2);
         this.hospitalisationActes.setHosactRabais(0.0D);
      } else {
         this.hospitalisationActes.setHosactPuRem(this.hospitalisationActes.getHosactPu());
      }

      this.hospitalisationActes.setHosactTotal(this.hospitalisationActes.getHosactPuRem() * (double)this.hospitalisationActes.getHosactQte());
      if (this.hospitalisationActes.getHosactTauxTva() != 0.0F) {
         var2 = this.hospitalisationActes.getHosactTotal() * (double)this.hospitalisationActes.getHosactTauxTva() / 100.0D;
         this.hospitalisationActes.setHosactTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.hospitalisationActes.setHosactTaxe(0.0D);
      }

      this.hospitalisationActes.setHosactNbCnamgs(0.0F);
      this.hospitalisationActes.setHosactValeurCnamgs(0.0D);
      this.hospitalisationActes.setHosactPuCnamgs(0.0D);
      this.hospitalisationActes.setHosactSocieteHt(0.0D);
      this.hospitalisationActes.setHosactSocieteTaxe(0.0D);
      this.hospitalisationActes.setHosactAssuranceHt(0.0D);
      this.hospitalisationActes.setHosactAssuranceTaxe(0.0D);
      this.hospitalisationActes.setHosactComplementaireHt(0.0D);
      this.hospitalisationActes.setHosactComplementaireTaxe(0.0D);
      this.hospitalisationActes.setHosactPatientHt(0.0D);
      this.hospitalisationActes.setHosactPatientTaxe(0.0D);
      this.hospitalisationEntete.setHosIdEmployeur(0L);
      var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      float var8 = 0.0F;
      double var9;
      if (this.hospitalisationEntete.getHosIdSociete() != 0L && this.hospitalisationEntete.getHosFam() != 0L) {
         if (this.patientPec == null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 0, var1);
         }

         if (this.patientPec != null) {
            var2 = this.hospitalisationActes.getHosactTotal() * (double)this.patientPec.getPatpecSoinsHospit() / 100.0D;
            if (this.patientPec.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.hospitalisationActes.setHosactSocieteHt(var2);
            } else {
               this.hospitalisationActes.setHosactSocieteHt(var2 * (double)this.patientPec.getTiers().getTiecoefpvmedical());
               var8 = this.patientPec.getTiers().getTiecoefpvmedical();
            }

            if (this.hospitalisationActes.getHosactTauxTva() != 0.0F) {
               var9 = this.hospitalisationActes.getHosactSocieteHt() * (double)this.hospitalisationActes.getHosactTauxTva() / 100.0D;
               this.hospitalisationActes.setHosactSocieteTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      } else if (this.hospitalisationEntete.getHosIdAssurance() != 0L && this.hospitalisationEntete.getHosFam() != 0L) {
         if (this.patientPec == null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 0, var1);
         }

         if (this.patientPec != null) {
            this.var_pecAssurance = true;
            this.hospitalisationEntete.setHosIdEmployeur(this.patientPec.getPatpecIdEmployeur());
            if (this.hospitalisationActes.getHosactPuAssurance() == 0.0D) {
               this.hospitalisationActes.setHosactPuAssurance(this.hospitalisationActes.getHosactPu());
            }

            var4 = this.hospitalisationActes.getHosactPuAssurance() * (double)this.hospitalisationActes.getHosactQte() * (double)this.patientPec.getPatpecSoinsHospit() / 100.0D;
            if (this.hospitalisationActes.getHosactRemise() != 0.0F) {
               var9 = this.utilNombre.myRoundDevise(var4 * (double)this.hospitalisationActes.getHosactRemise() / 100.0D, this.structureLog.getStrdevise());
               var4 -= var9;
            }

            if (this.patientPec.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.hospitalisationActes.setHosactAssuranceHt(var4);
            } else {
               this.hospitalisationActes.setHosactAssuranceHt(var4 * (double)this.patientPec.getTiers().getTiecoefpvmedical());
               var8 = this.patientPec.getTiers().getTiecoefpvmedical();
            }

            if (this.hospitalisationActes.getHosactTauxTva() != 0.0F) {
               var9 = this.hospitalisationActes.getHosactAssuranceHt() * (double)this.hospitalisationActes.getHosactTauxTva() / 100.0D;
               this.hospitalisationActes.setHosactAssuranceTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      }

      if (this.hospitalisationEntete.getHosIdComplementaire() != 0L) {
         if (this.patientPecComplementaire == null) {
            this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosComplementaire(), 0, var1);
         }

         if (this.patientPecComplementaire != null) {
            var6 = this.hospitalisationActes.getHosactPu() * (double)this.hospitalisationActes.getHosactQte() * (double)this.patientPec.getPatpecSoinsHospit() / 100.0D;
            if (this.hospitalisationActes.getHosactRemise() != 0.0F) {
               var9 = this.utilNombre.myRoundDevise(var6 * (double)this.hospitalisationActes.getHosactRemise() / 100.0D, this.structureLog.getStrdevise());
               var6 -= var9;
            }

            if (this.patientPecComplementaire.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.hospitalisationActes.setHosactComplementaireHt(var6);
            } else {
               this.hospitalisationActes.setHosactComplementaireHt(var6 * (double)this.patientPecComplementaire.getTiers().getTiecoefpvmedical());
            }

            if (this.hospitalisationActes.getHosactTauxTva() != 0.0F) {
               var9 = this.hospitalisationActes.getHosactComplementaireHt() * (double)this.hospitalisationActes.getHosactTauxTva() / 100.0D;
               this.hospitalisationActes.setHosactComplementaireTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      }

      var9 = 0.0D;
      double var11;
      if (var8 != 0.0F && this.produits.getProMajoration() == 0 && this.optionMedical.getCoefMajoration().equals("2")) {
         if (this.hospitalisationActes.getHosactRemise() != 0.0F) {
            var11 = this.utilNombre.myRoundDevise(this.hospitalisationActes.getHosactPu() * (double)this.hospitalisationActes.getHosactRemise() / 100.0D, this.structureLog.getStrdevise());
            this.hospitalisationActes.setHosactPuRem((this.hospitalisationActes.getHosactPu() - var11) * (double)var8);
         } else {
            this.hospitalisationActes.setHosactPuRem(this.hospitalisationActes.getHosactPu() * (double)var8);
         }

         this.hospitalisationActes.setHosactTotal(this.hospitalisationActes.getHosactPuRem() * (double)this.hospitalisationActes.getHosactQte());
         if (this.hospitalisationActes.getHosactTauxTva() != 0.0F) {
            var11 = this.hospitalisationActes.getHosactTotal() * (double)this.hospitalisationActes.getHosactTauxTva() / 100.0D;
            this.hospitalisationActes.setHosactTaxe(this.utilNombre.myRoundDevise(var11, this.structureLog.getStrdevise()));
         } else {
            this.hospitalisationActes.setHosactTaxe(0.0D);
         }
      } else {
         var9 = this.hospitalisationActes.getHosactTotal() - (var2 + var4 + var6);
         this.hospitalisationActes.setHosactTotal(this.hospitalisationActes.getHosactSocieteHt() + this.hospitalisationActes.getHosactAssuranceHt() + this.hospitalisationActes.getHosactComplementaireHt() + var9);
      }

      var11 = this.hospitalisationActes.getHosactTotal() - (this.hospitalisationActes.getHosactSocieteHt() + this.hospitalisationActes.getHosactAssuranceHt() + this.hospitalisationActes.getHosactComplementaireHt());
      if (this.hospitalisationActes.getHosactRabais() != 0.0D) {
         this.hospitalisationActes.setHosactPatientHt(var11 - this.hospitalisationActes.getHosactRabais());
         this.hospitalisationActes.setHosactRemise(0.0F);
         if (this.hospitalisationActes.getHosactPatientHt() < 0.0D) {
            this.hospitalisationActes.setHosactPatientHt(var11);
            this.hospitalisationActes.setHosactRabais(0.0D);
         }
      } else {
         this.hospitalisationActes.setHosactPatientHt(var11);
      }

      double var13;
      if (this.hospitalisationActes.getHosactTauxTva() != 0.0F) {
         var13 = this.hospitalisationActes.getHosactPatientHt() * (double)this.hospitalisationActes.getHosactTauxTva() / 100.0D;
         this.hospitalisationActes.setHosactPatientTaxe(this.utilNombre.myRoundDevise(var13, this.structureLog.getStrdevise()));
      }

      if (var8 != 0.0F && this.produits.getProMajoration() == 0 && this.optionMedical.getCoefMajoration().equals("3")) {
         if (this.hospitalisationActes.getHosactRemise() != 0.0F) {
            var13 = this.utilNombre.myRoundDevise(this.hospitalisationActes.getHosactPu() * (double)this.hospitalisationActes.getHosactRemise() / 100.0D, this.structureLog.getStrdevise());
            this.hospitalisationActes.setHosactPuRem((this.hospitalisationActes.getHosactPu() - var13) * (double)var8);
         } else {
            this.hospitalisationActes.setHosactPuRem(this.hospitalisationActes.getHosactPu() * (double)var8);
         }

         this.hospitalisationActes.setHosactTotal(this.hospitalisationActes.getHosactPuRem() * (double)this.hospitalisationActes.getHosactQte());
         var13 = this.hospitalisationActes.getHosactAssuranceHt() + this.hospitalisationActes.getHosactComplementaireHt() + this.hospitalisationActes.getHosactSocieteHt() + this.hospitalisationActes.getHosactPatientHt();
         double var15 = this.hospitalisationActes.getHosactTotal() - var13;
         if (var15 != 0.0D) {
            if (var4 != 0.0D) {
               this.hospitalisationActes.setHosactAssuranceHt(this.hospitalisationActes.getHosactAssuranceHt() + var15);
            } else if (var2 != 0.0D) {
               this.hospitalisationActes.setHosactSocieteHt(this.hospitalisationActes.getHosactSocieteHt() + var15);
            }

            if (var6 != 0.0D) {
               this.hospitalisationActes.setHosactComplementaireHt(this.hospitalisationActes.getHosactComplementaireHt() + var15);
            }
         }
      }

   }

   public void acteSansCnamgsPrive(Session var1) {
      if (this.tauxCasSocial != 0.0F) {
         this.hospitalisationActes.setHosactRemise(this.tauxCasSocial);
      }

      double var2;
      if (this.hospitalisationActes.getHosactRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.hospitalisationActes.getHosactPu() * (double)this.hospitalisationActes.getHosactRemise() / 100.0D, this.structureLog.getStrdevise());
         this.hospitalisationActes.setHosactPuRem(this.hospitalisationActes.getHosactPu() - var2);
         this.hospitalisationActes.setHosactRabais(0.0D);
      } else {
         this.hospitalisationActes.setHosactPuRem(this.hospitalisationActes.getHosactPu());
      }

      this.hospitalisationActes.setHosactTotal(this.hospitalisationActes.getHosactPuRem() * (double)this.hospitalisationActes.getHosactQte());
      if (this.hospitalisationActes.getHosactTauxTva() != 0.0F) {
         var2 = this.hospitalisationActes.getHosactTotal() * (double)this.hospitalisationActes.getHosactTauxTva() / 100.0D;
         this.hospitalisationActes.setHosactTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.hospitalisationActes.setHosactTaxe(0.0D);
      }

      this.hospitalisationActes.setHosactNbCnamgs(0.0F);
      this.hospitalisationActes.setHosactValeurCnamgs(0.0D);
      this.hospitalisationActes.setHosactPuCnamgs(0.0D);
      this.hospitalisationActes.setHosactSocieteHt(0.0D);
      this.hospitalisationActes.setHosactSocieteTaxe(0.0D);
      this.hospitalisationActes.setHosactAssuranceHt(0.0D);
      this.hospitalisationActes.setHosactAssuranceTaxe(0.0D);
      this.hospitalisationActes.setHosactComplementaireHt(0.0D);
      this.hospitalisationActes.setHosactComplementaireTaxe(0.0D);
      this.hospitalisationActes.setHosactPatientHt(0.0D);
      this.hospitalisationActes.setHosactPatientTaxe(0.0D);
      this.hospitalisationEntete.setHosIdEmployeur(0L);
      var2 = this.hospitalisationActes.getHosactTotal();
      if (this.hospitalisationActes.getHosactRabais() != 0.0D) {
         this.hospitalisationActes.setHosactPatientHt(var2 - this.hospitalisationActes.getHosactRabais());
         this.hospitalisationActes.setHosactRemise(0.0F);
         if (this.hospitalisationActes.getHosactPatientHt() < 0.0D) {
            this.hospitalisationActes.setHosactPatientHt(var2);
            this.hospitalisationActes.setHosactRabais(0.0D);
         }
      } else {
         this.hospitalisationActes.setHosactPatientHt(var2);
      }

      if (this.hospitalisationActes.getHosactTaxe() != 0.0D) {
         double var4 = this.hospitalisationActes.getHosactPatientHt() * (double)this.hospitalisationActes.getHosactTauxTva() / 100.0D;
         this.hospitalisationActes.setHosactPatientTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
      } else {
         this.hospitalisationActes.setHosactPatientTaxe(0.0D);
      }

   }

   public void acteAvecCnamgsPrive(Session var1) throws HibernateException, NamingException {
      if (this.hospitalisationActes.getHosactPuCnamgs() > this.hospitalisationActes.getHosactPu()) {
         this.hospitalisationActes.setHosactPu(this.hospitalisationActes.getHosactPuCnamgs());
      }

      double var2;
      double var4;
      if (this.hospitalisationActes.getHosactRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.hospitalisationActes.getHosactPu() * (double)this.hospitalisationActes.getHosactRemise() / 100.0D, this.structureLog.getStrdevise());
         this.hospitalisationActes.setHosactPuRem(this.hospitalisationActes.getHosactPu() - var2);
         var4 = this.utilNombre.myRoundDevise(this.hospitalisationActes.getHosactPuCnamgs() * (double)this.hospitalisationActes.getHosactRemise() / 100.0D, this.structureLog.getStrdevise());
         this.hospitalisationActes.setHosactPuCnamgs(this.hospitalisationActes.getHosactPuCnamgs() - var4);
         this.hospitalisationActes.setHosactRabais(0.0D);
      } else {
         this.hospitalisationActes.setHosactPuRem(this.hospitalisationActes.getHosactPu());
      }

      this.hospitalisationActes.setHosactTotal(this.hospitalisationActes.getHosactPuRem() * (double)this.hospitalisationActes.getHosactQte());
      if (this.hospitalisationActes.getHosactTauxTva() != 0.0F) {
         var2 = this.hospitalisationActes.getHosactTotal() * (double)this.hospitalisationActes.getHosactTauxTva() / 100.0D;
         this.hospitalisationActes.setHosactTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.hospitalisationActes.setHosactTaxe(0.0D);
      }

      this.hospitalisationActes.setHosactSocieteHt(0.0D);
      this.hospitalisationActes.setHosactSocieteTaxe(0.0D);
      this.hospitalisationActes.setHosactAssuranceHt(0.0D);
      this.hospitalisationActes.setHosactAssuranceTaxe(0.0D);
      this.hospitalisationActes.setHosactComplementaireHt(0.0D);
      this.hospitalisationActes.setHosactComplementaireTaxe(0.0D);
      this.hospitalisationActes.setHosactPatientHt(0.0D);
      this.hospitalisationActes.setHosactPatientTaxe(0.0D);
      this.hospitalisationEntete.setHosIdEmployeur(0L);
      this.hospitalisationActes.setHosactAssuranceHt(this.hospitalisationActes.getHosactPuCnamgs() * (double)this.hospitalisationActes.getHosactQte() * (double)this.var_pecCnamgs / 100.0D);
      if (this.hospitalisationActes.getHosactTauxTva() != 0.0F) {
         var2 = this.hospitalisationActes.getHosactAssuranceHt() * (double)this.hospitalisationActes.getHosactTauxTva() / 100.0D;
         this.hospitalisationActes.setHosactAssuranceTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      }

      var2 = this.hospitalisationActes.getHosactTotal() - this.hospitalisationActes.getHosactAssuranceHt();
      if (this.hospitalisationActes.getHosactRabais() != 0.0D) {
         this.hospitalisationActes.setHosactPatientHt(var2 - this.hospitalisationActes.getHosactRabais());
         this.hospitalisationActes.setHosactRemise(0.0F);
         if (this.hospitalisationActes.getHosactPatientHt() < 0.0D) {
            this.hospitalisationActes.setHosactPatientHt(var2);
            this.hospitalisationActes.setHosactRabais(0.0D);
         }
      } else {
         this.hospitalisationActes.setHosactPatientHt(var2);
      }

      if (this.hospitalisationActes.getHosactTauxTva() != 0.0F) {
         var4 = this.hospitalisationActes.getHosactPatientHt() * (double)this.hospitalisationActes.getHosactTauxTva() / 100.0D;
         this.hospitalisationActes.setHosactPatientTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
      }

   }

   public void selectionActeListe() throws HibernateException, NamingException {
      this.var_lettre = "";
      if (this.dataModelActesListe.isRowAvailable()) {
         this.hospitalisationActes = (HospitalisationActes)this.dataModelActesListe.getRowData();
         if (this.hospitalisationActes.getHosactLettre() != null && !this.hospitalisationActes.getHosactLettre().isEmpty()) {
            this.lettreMedical = this.lettreMedicalDao.selectLettre(this.exercicesVentes.getExevteId(), this.hospitalisationActes.getHosactLettre(), (Session)null);
            if (this.lettreMedical != null) {
               this.var_lettre = this.hospitalisationActes.getHosactLettre() + ":" + this.lettreMedical.getLetLibelleFr();
            }
         }

         this.afficheButtActes = true;
      }

   }

   public void annuleActes() {
      this.ccamMedical = null;
      this.produits = null;
      this.var_lettre = "";
      this.afficheButtActes = false;
      this.showModalPanelListeActes = false;
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
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

      this.hospitalisationActes.setHosactProduit(this.produits.getProCode());
      this.validesActesSuite((Session)null);
   }

   public void fermerValidesProduit() {
      this.showModalPanelCreationActe = false;
   }

   public void detailActe() {
      if (this.typeActe == 0 && this.ccamMedical != null) {
         this.showModalPanelDetailActe = true;
      } else if (this.typeActe == 1 && this.produits != null) {
         this.showModalPanelDetailProduits = true;
      }

   }

   public void fermerDetailActe() {
      this.showModalPanelDetailActe = false;
   }

   public void fermerDetailProduit() {
      this.showModalPanelDetailProduits = false;
   }

   public void changerTarif() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.tarifPatient(var1);
         if (this.hospitalisationEntete.getHosId() != 0L) {
            this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);

            int var3;
            for(var3 = 0; var3 < this.lesSejours.size(); ++var3) {
               this.hospitalisationSejour = (HospitalisationSejour)this.lesSejours.get(var3);
               this.calculPrixSejour(1, var1);
               this.hospitalisationSejour = this.hospitalisationSejourDao.modif(this.hospitalisationSejour, var1);
            }

            for(var3 = 0; var3 < this.lesActes.size(); ++var3) {
               this.hospitalisationActes = (HospitalisationActes)this.lesActes.get(var3);
               this.calculPrixActe(0.0D, 0.0D, 0.0F, var1);
               this.hospitalisationActes = this.hospitalisationActesDao.modif(this.hospitalisationActes, var1);
            }

            for(var3 = 0; var3 < this.lesMedis.size(); ++var3) {
               this.hospitalisationMedi = (HospitalisationMedi)this.lesMedis.get(var3);
               this.calculPrixMedicamment(var1);
               this.hospitalisationMedi = this.hospitalisationMediDao.modif(this.hospitalisationMedi, var1);
            }

            for(var3 = 0; var3 < this.lesLabos.size(); ++var3) {
               this.hospitalisationLabo = (HospitalisationLabo)this.lesLabos.get(var3);
               this.calculPrixLaboratoire(var1);
               this.hospitalisationLabo = this.hospitalisationLaboDao.modif(this.hospitalisationLabo, var1);
            }

            for(var3 = 0; var3 < this.lesPrests.size(); ++var3) {
               this.hospitalisationPrest = (HospitalisationPrest)this.lesPrests.get(var3);
               this.calculPrixPrestation(var1);
               this.hospitalisationPrest = this.hospitalisationPrestDao.modif(this.hospitalisationPrest, var1);
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
   }

   public void tarifPatient(Session var1) throws HibernateException, NamingException {
      this.var_pecAssurance = false;
      this.hospitalisationEntete.setHosFam(this.nomFamille);
      this.hospitalisationEntete.setHosComplementaire(this.nomComplementaire);
      if (this.nomFamille >= 1L) {
         this.var_pecCnamgs = 0.0F;
         this.hospitalisationEntete.setHosIdSociete(0L);
         this.hospitalisationEntete.setHosIdAssurance(0L);
         this.hospitalisationEntete.setHosIdComplementaire(0L);
         this.hospitalisationEntete.setHosNomSociete("");
         this.hospitalisationEntete.setHosNomAssurance("");
         this.hospitalisationEntete.setHosNomComplemtaire("");
         this.hospitalisationEntete.setHosIdEmployeur(0L);
         this.hospitalisationEntete.setHosMatricule("");
         this.hospitalisationEntete.setHosContratAssurance("");
         this.hospitalisationEntete.setHosContratComplementaire("");
         this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 0, var1);
         if (this.patientPec != null) {
            if (this.patientPec.getPatpecType() != null && !this.patientPec.getPatpecType().isEmpty()) {
               if (!this.patientPec.getPatpecType().equals("Assurance") && !this.patientPec.getPatpecType().equals("IPM") && !this.patientPec.getPatpecType().equals("Programme Médical")) {
                  this.hospitalisationEntete.setHosIdSociete(this.patientPec.getTiers().getTieid());
                  this.hospitalisationEntete.setHosNomSociete(this.patientPec.getTiers().getTieraisonsocialenom());
                  this.hospitalisationEntete.setHosMatricule(this.patientPec.getPatpecMatricule());
               } else {
                  this.var_pecAssurance = true;
                  this.hospitalisationEntete.setHosIdAssurance(this.patientPec.getTiers().getTieid());
                  this.hospitalisationEntete.setHosNomAssurance(this.patientPec.getTiers().getTieraisonsocialenom());
                  this.hospitalisationEntete.setHosIdEmployeur(this.patientPec.getPatpecIdEmployeur());
                  this.hospitalisationEntete.setHosContratAssurance(this.patientPec.getPatpecNumContrat());
               }
            }
         } else {
            this.hospitalisationEntete.setHosFam(0L);
         }

         if (this.nomComplementaire >= 1L) {
            this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.nomComplementaire, 0, var1);
            if (this.patientPecComplementaire != null) {
               if (this.patientPecComplementaire.getPatpecType() != null && !this.patientPecComplementaire.getPatpecType().isEmpty() && (this.patientPecComplementaire.getPatpecType().equals("Mutuelle") || this.patientPecComplementaire.getPatpecType().equals("Complémentaire"))) {
                  this.hospitalisationEntete.setHosIdComplementaire(this.patientPecComplementaire.getTiers().getTieid());
                  this.hospitalisationEntete.setHosNomComplemtaire(this.patientPecComplementaire.getTiers().getTieraisonsocialenom());
                  this.hospitalisationEntete.setHosContratComplementaire(this.patientPecComplementaire.getPatpecNumContrat());
               }
            } else {
               this.hospitalisationEntete.setHosComplementaire(0L);
            }
         }
      } else if (this.nomFamille <= 0L) {
         this.hospitalisationEntete.setHosComplementaire(0L);
         this.hospitalisationEntete.setHosIdSociete(0L);
         this.hospitalisationEntete.setHosIdAssurance(0L);
         this.hospitalisationEntete.setHosIdComplementaire(0L);
         this.hospitalisationEntete.setHosNomSociete("");
         this.hospitalisationEntete.setHosNomAssurance("");
         this.hospitalisationEntete.setHosNomComplemtaire("");
         this.hospitalisationEntete.setHosIdEmployeur(0L);
         this.hospitalisationEntete.setHosMatricule("");
         this.hospitalisationEntete.setHosContratAssurance("");
         this.hospitalisationEntete.setHosContratComplementaire("");
      }

   }

   public void consulterTarif() throws HibernateException, NamingException {
      if (this.hospitalisationEntete != null) {
         this.tarifPatient((Session)null);
         if (this.hospitalisationEntete.getHosIdSociete() != 0L) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.patients, this.hospitalisationEntete.getHosIdSociete(), (Session)null);
            if (this.patientPec != null) {
               this.showModalpanelPec = true;
            }
         } else if (this.hospitalisationEntete.getHosIdAssurance() != 0L) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.patients, this.hospitalisationEntete.getHosIdAssurance(), (Session)null);
            if (this.patientPec != null) {
               if (this.hospitalisationEntete.getHosIdComplementaire() != 0L) {
                  this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.patients, this.hospitalisationEntete.getHosIdComplementaire(), (Session)null);
               }

               this.showModalpanelPec = true;
            }
         }
      }

   }

   public void fermerConsulterTarif() {
      this.showModalpanelPec = false;
   }

   public void selectionMedicamment() throws HibernateException, NamingException {
      if (this.dataModelMedi.isRowAvailable()) {
         this.hospitalisationMedi = (HospitalisationMedi)this.dataModelMedi.getRowData();
         this.var_memo_qte = this.hospitalisationMedi.getHosmedQte();
         if (this.hospitalisationMedi.getHosmedProduit() != null && !this.hospitalisationMedi.getHosmedProduit().isEmpty()) {
            this.produits = this.produitsMedicDao.chargeProduit(this.hospitalisationMedi.getHosmedProduit(), (Session)null);
         } else {
            this.produits = null;
         }

         this.medicDepot = this.hospitalisationMedi.getHosmedDepot();
         this.afficheButtOrdo = true;
         this.valideMedi = true;
      }

   }

   public void ajouterMedicamment() {
      this.mesSejoursItems.clear();
      if (this.lesSejours.size() != 0) {
         int var1;
         for(var1 = 0; var1 < this.lesSejours.size(); ++var1) {
            if (((HospitalisationSejour)this.lesSejours.get(var1)).getHossejDateSortie() == null) {
               this.mesSejoursItems.add(new SelectItem(((HospitalisationSejour)this.lesSejours.get(var1)).getHossejId(), ((HospitalisationSejour)this.lesSejours.get(var1)).getHossejService()));
            }
         }

         this.produits = new Produits();
         this.hospitalisationMedi = new HospitalisationMedi();
         this.hospitalisationMedi.setHosmedQte(1.0F);
         if (this.lesMedis.size() != 0) {
            var1 = this.lesMedis.size() - 1;
            this.hospitalisationMedi.setHosmedIdSejour(((HospitalisationMedi)this.lesMedis.get(var1)).getHosmedIdSejour());
            this.hospitalisationMedi.setHosmedIdMedecin(((HospitalisationMedi)this.lesMedis.get(var1)).getHosmedIdMedecin());
            this.hospitalisationMedi.setHosmedMedecin(((HospitalisationMedi)this.lesMedis.get(var1)).getHosmedMedecin());
            this.hospitalisationMedi.setHosmedService(((HospitalisationMedi)this.lesMedis.get(var1)).getHosmedService());
         } else if (this.lesSejours.size() != 0) {
            var1 = this.lesSejours.size() - 1;
            this.hospitalisationMedi.setHosmedIdSejour(((HospitalisationSejour)this.lesSejours.get(var1)).getHossejId());
            this.hospitalisationMedi.setHosmedService(((HospitalisationSejour)this.lesSejours.get(var1)).getHossejService());
         }

         this.mesDepotsItems.clear();
         this.medicDepot = "";
         this.valideMedi = false;
         this.afficheButtOrdo = false;
         this.showModalPanelMedi = true;
      }

   }

   public void modifierMedicamment() throws HibernateException, NamingException {
      if (this.hospitalisationMedi != null) {
         this.mesSejoursItems.clear();
         if (this.lesSejours.size() != 0) {
            for(int var1 = 0; var1 < this.lesSejours.size(); ++var1) {
               if (((HospitalisationSejour)this.lesSejours.get(var1)).getHossejDateSortie() == null) {
                  this.mesSejoursItems.add(new SelectItem(((HospitalisationSejour)this.lesSejours.get(var1)).getHossejId(), ((HospitalisationSejour)this.lesSejours.get(var1)).getHossejService()));
               }
            }

            this.calculMedecinMedi();
            this.calculDepotMedicamment((Session)null);
            this.verifValideMedicamment();
            this.showModalPanelMedi = true;
         }
      }

   }

   public void supprimerMedicamment() throws HibernateException, NamingException {
      if (this.hospitalisationMedi != null) {
         this.hospitalisationMediDao.delete(this.hospitalisationMedi);
         this.lesMedis.remove(this.hospitalisationMedi);
         this.dataModelMedi.setWrappedData(this.lesMedis);
         this.afficheButtOrdo = false;
      }

   }

   public void avoirMedicamment() throws HibernateException, NamingException {
      if (this.hospitalisationMedi != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            HospitalisationMedi var3 = new HospitalisationMedi();
            var3.setHospitalisationEntete(this.hospitalisationEntete);
            var3.setHosmedAssuranceHt(this.hospitalisationMedi.getHosmedAssuranceHt() * -1.0D);
            var3.setHosmedAssuranceTaxe(this.hospitalisationMedi.getHosmedAssuranceTaxe() * -1.0D);
            var3.setHosmedCodeTva(this.hospitalisationMedi.getHosmedCodeTva());
            var3.setHosmedCoef(this.hospitalisationMedi.getHosmedCoef());
            var3.setHosmedComplementaireHt(this.hospitalisationMedi.getHosmedComplementaireHt() * -1.0D);
            var3.setHosmedComplementaireTaxe(this.hospitalisationMedi.getHosmedComplementaireTaxe() * -1.0D);
            var3.setHosmedDepot(this.hospitalisationMedi.getHosmedDepot());
            var3.setHosmedFamille(this.hospitalisationMedi.getHosmedFamille());
            var3.setHosmedIdMedecin(this.hospitalisationMedi.getHosmedIdMedecin());
            var3.setHosmedIdSejour(this.hospitalisationMedi.getHosmedIdSejour());
            var3.setHosmedLibelle(this.hospitalisationMedi.getHosmedLibelle());
            var3.setHosmedMedecin(this.hospitalisationMedi.getHosmedMedecin());
            var3.setHosmedPatientHt(this.hospitalisationMedi.getHosmedPatientHt() * -1.0D);
            var3.setHosmedPatientTaxe(this.hospitalisationMedi.getHosmedPatientTaxe() * -1.0D);
            var3.setHosmedProduit(this.hospitalisationMedi.getHosmedProduit());
            var3.setHosmedPu(this.hospitalisationMedi.getHosmedPu());
            var3.setHosmedPuAssurance(this.hospitalisationMedi.getHosmedPuAssurance());
            var3.setHosmedPuCnamgs(this.hospitalisationMedi.getHosmedPuCnamgs());
            var3.setHosmedPuRem(this.hospitalisationMedi.getHosmedPuRem());
            var3.setHosmedPump(this.hospitalisationMedi.getHosmedPump());
            var3.setHosmedQte(this.hospitalisationMedi.getHosmedQte() * -1.0F);
            var3.setHosmedRegPatient(0.0D);
            var3.setHosmedRegTiers(0.0D);
            var3.setHosmedRemise(this.hospitalisationMedi.getHosmedRemise());
            var3.setHosmedService(this.hospitalisationMedi.getHosmedService());
            var3.setHosmedSocieteHt(this.hospitalisationMedi.getHosmedSocieteHt() * -1.0D);
            var3.setHosmedSocieteTaxe(this.hospitalisationMedi.getHosmedSocieteTaxe() * -1.0D);
            var3.setHosmedStock(this.hospitalisationMedi.getHosmedStock());
            var3.setHosmedTauxTva(this.hospitalisationMedi.getHosmedTauxTva());
            var3.setHosmedTaxe(this.hospitalisationMedi.getHosmedTaxe() * -1.0D);
            var3.setHosmedTotal(this.hospitalisationMedi.getHosmedTotal() * -1.0D);
            this.hospitalisationMedi = new HospitalisationMedi();
            this.hospitalisationMedi = var3;
            this.hospitalisationMedi = this.hospitalisationMediDao.insert(this.hospitalisationMedi, var1);
            this.lesMedis.add(this.hospitalisationMedi);
            this.dataModelMedi.setWrappedData(this.lesMedis);
            this.calculTotaux();
            this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
            double var4 = this.hospitalisationMedi.getHosmedPatientHt() + this.hospitalisationMedi.getHosmedPatientTaxe();
            if (var4 != 0.0D) {
               this.majBonencaissementAnnulation(Math.abs(var4), new Date(), var1);
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

         this.ajouterLaboratoire();
      }

   }

   public void annulationMedicamment() throws NamingException {
      if (this.hospitalisationMedi != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            HospitalisationMedi var3 = new HospitalisationMedi();
            var3.setHospitalisationEntete(this.hospitalisationEntete);
            var3.setHosmedAssuranceHt(this.hospitalisationMedi.getHosmedAssuranceHt() * -1.0D);
            var3.setHosmedAssuranceTaxe(this.hospitalisationMedi.getHosmedAssuranceTaxe() * -1.0D);
            var3.setHosmedCodeTva(this.hospitalisationMedi.getHosmedCodeTva());
            var3.setHosmedCoef(this.hospitalisationMedi.getHosmedCoef());
            var3.setHosmedComplementaireHt(this.hospitalisationMedi.getHosmedComplementaireHt() * -1.0D);
            var3.setHosmedComplementaireTaxe(this.hospitalisationMedi.getHosmedComplementaireTaxe() * -1.0D);
            var3.setHosmedDepot(this.hospitalisationMedi.getHosmedDepot());
            var3.setHosmedFamille(this.hospitalisationMedi.getHosmedFamille());
            var3.setHosmedIdMedecin(this.hospitalisationMedi.getHosmedIdMedecin());
            var3.setHosmedIdSejour(this.hospitalisationMedi.getHosmedIdSejour());
            var3.setHosmedLibelle(this.hospitalisationMedi.getHosmedLibelle());
            var3.setHosmedMedecin(this.hospitalisationMedi.getHosmedMedecin());
            var3.setHosmedPatientHt(this.hospitalisationMedi.getHosmedPatientHt() * -1.0D);
            var3.setHosmedPatientTaxe(this.hospitalisationMedi.getHosmedPatientTaxe() * -1.0D);
            var3.setHosmedProduit(this.hospitalisationMedi.getHosmedProduit());
            var3.setHosmedPu(this.hospitalisationMedi.getHosmedPu());
            var3.setHosmedPuAssurance(this.hospitalisationMedi.getHosmedPuAssurance());
            var3.setHosmedPuCnamgs(this.hospitalisationMedi.getHosmedPuCnamgs());
            var3.setHosmedPuRem(this.hospitalisationMedi.getHosmedPuRem());
            var3.setHosmedPump(this.hospitalisationMedi.getHosmedPump());
            var3.setHosmedQte(this.hospitalisationMedi.getHosmedQte() * -1.0F);
            var3.setHosmedRegPatient(0.0D);
            var3.setHosmedRegTiers(0.0D);
            var3.setHosmedRemise(this.hospitalisationMedi.getHosmedRemise());
            var3.setHosmedService(this.hospitalisationMedi.getHosmedService());
            var3.setHosmedSocieteHt(this.hospitalisationMedi.getHosmedSocieteHt() * -1.0D);
            var3.setHosmedSocieteTaxe(this.hospitalisationMedi.getHosmedSocieteTaxe() * -1.0D);
            var3.setHosmedStock(this.hospitalisationMedi.getHosmedStock());
            var3.setHosmedTauxTva(this.hospitalisationMedi.getHosmedTauxTva());
            var3.setHosmedTaxe(this.hospitalisationMedi.getHosmedTaxe() * -1.0D);
            var3.setHosmedTotal(this.hospitalisationMedi.getHosmedTotal() * -1.0D);
            this.hospitalisationMedi = new HospitalisationMedi();
            this.hospitalisationMedi = var3;
            this.hospitalisationMedi = this.hospitalisationMediDao.insert(this.hospitalisationMedi, var1);
            this.lesMedis.add(this.hospitalisationMedi);
            this.dataModelMedi.setWrappedData(this.lesMedis);
            this.calculTotaux();
            this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.ajouterLaboratoire();
      }

   }

   public void fermerMedicamment() {
      this.hospitalisationMedi.setHosmedProduit("");
      this.hospitalisationMedi.setHosmedLibelle("");
      this.showModalPanelMedi = false;
   }

   public void saveMedicamment() throws HibernateException, NamingException {
      if (this.hospitalisationMedi.getHosmedQte() != 0.0F) {
         if (this.hospitalisationMedi != null) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
            Transaction var2 = null;

            try {
               var2 = var1.beginTransaction();
               this.calculPrixMedicamment(var1);
               if (this.hospitalisationMedi.getHosmedIdMedecin() != 0L) {
                  new Users();
                  Users var3 = this.usersDao.selectUserD(this.hospitalisationMedi.getHosmedIdMedecin(), var1);
                  if (var3 != null) {
                     this.hospitalisationMedi.setHosmedIdMedecin(var3.getUsrid());
                     this.hospitalisationMedi.setHosmedMedecin(var3.getUsrPatronyme());
                  } else {
                     this.hospitalisationMedi.setHosmedIdMedecin(0L);
                     this.hospitalisationMedi.setHosmedMedecin("");
                  }
               } else {
                  this.hospitalisationMedi.setHosmedIdMedecin(0L);
                  this.hospitalisationMedi.setHosmedMedecin("");
               }

               if (this.medicDepot != null && !this.medicDepot.isEmpty()) {
                  if (this.medicDepot.contains(":")) {
                     String[] var9 = this.medicDepot.split(":");
                     this.hospitalisationMedi.setHosmedDepot(var9[0]);
                  } else {
                     this.hospitalisationMedi.setHosmedDepot(this.medicDepot);
                  }

                  this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.hospitalisationMedi.getHosmedProduit(), this.hospitalisationMedi.getHosmedDepot(), var1);
                  if (this.produitsDepot != null) {
                     this.hospitalisationMedi.setHosmedPump(this.produitsDepot.getProdepPump());
                  } else {
                     this.hospitalisationMedi.setHosmedPump(0.0D);
                  }
               } else {
                  this.hospitalisationMedi.setHosmedDepot("");
                  this.hospitalisationMedi.setHosmedPump(0.0D);
               }

               if (this.hospitalisationMedi.getHosmedId() == 0L) {
                  this.hospitalisationMedi.setHospitalisationEntete(this.hospitalisationEntete);
                  this.hospitalisationMedi.setHosmedDateCreat(new Date());
                  this.hospitalisationMedi.setHosmedUserCreat(this.usersLog.getUsrid());
                  this.hospitalisationMedi = this.hospitalisationMediDao.insert(this.hospitalisationMedi, var1);
                  this.lesMedis.add(this.hospitalisationMedi);
                  this.dataModelMedi.setWrappedData(this.lesMedis);
               } else {
                  this.hospitalisationMedi.setHosmedDateModif(new Date());
                  this.hospitalisationMedi.setHosmedUserModif(this.usersLog.getUsrid());
                  this.hospitalisationMedi = this.hospitalisationMediDao.modif(this.hospitalisationMedi, var1);
               }

               if (this.produits != null && this.produits.getProStock() >= 1) {
                  this.calculStock.majHospitalisation(this.hospitalisationMedi, this.produits, this.var_memo_qte, 0, this.baseLog, var1);
               }

               this.calculTotaux();
               this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
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
            this.hospitalisationEnteteDao.modif(this.hospitalisationEntete);
         }

         this.showModalPanelMedi = false;
      }

   }

   public void verifValideMedicamment() {
      this.valideMedi = false;
      if (this.hospitalisationMedi.getHosmedIdSejour() != 0L) {
         if (this.optionMedical.getMedecinHP().equals("0")) {
            if (this.hospitalisationMedi.getHosmedIdMedecin() != 0L && this.hospitalisationMedi.getHosmedProduit() != null && !this.hospitalisationMedi.getHosmedProduit().isEmpty()) {
               this.valideMedi = true;
            }
         } else if (this.hospitalisationMedi.getHosmedProduit() != null && !this.hospitalisationMedi.getHosmedProduit().isEmpty()) {
            this.valideMedi = true;
         }
      }

   }

   public void rechercheMedicamment() throws HibernateException, NamingException {
      this.extDTableProduits = new HtmlExtendedDataTable();
      if (this.simpleSelectionProduits == null) {
         this.simpleSelectionProduits.clear();
      }

      this.choixPanenProd = 2;
      if (this.hospitalisationMedi.getHosmedProduit() != null && !this.hospitalisationMedi.getHosmedProduit().isEmpty()) {
         this.lesProduits.clear();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsMed");
         this.lesProduits = this.produitsMedicDao.verifProduitsMedicaux(this.hospitalisationMedi.getHosmedProduit(), "1105", var1);
         this.utilInitHibernate.closeSession();
         if (this.lesProduits.size() == 1) {
            this.produits = (Produits)this.lesProduits.get(0);
            this.validerMedicamment();
         } else if (this.lesProduits.size() > 1) {
            this.produits = new Produits();
            this.showModalPanelProduits = true;
            this.datamodelProduits.setWrappedData(this.lesProduits);
         } else {
            this.annulerMedicamment();
         }
      }

   }

   public void selectionProduit() {
      if (this.datamodelProduits.isRowAvailable()) {
         this.produits = (Produits)this.datamodelProduits.getRowData();
      }

   }

   public void annulerMedicamment() {
      this.produits = null;
      this.showModalPanelProduits = false;
   }

   public void validerMedicamment() throws HibernateException, NamingException {
      if (this.produits != null) {
         this.mesServicesFacturesMedi.clear();
         if (this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty()) {
            if (!this.produits.getProActivite().contains("#")) {
               this.mesServicesFacturesMedi.add(new SelectItem(this.produits.getProActivite()));
            } else {
               String[] var1 = this.produits.getProActivite().split("#");
               int var2 = var1.length;

               for(int var3 = 0; var3 < var2; ++var3) {
                  this.mesServicesFacturesMedi.add(new SelectItem(var1[var3]));
               }
            }
         } else {
            this.mesServicesFacturesMedi.add(new SelectItem(((HospitalisationSejour)this.lesSejours.get(this.lesSejours.size() - 1)).getHossejService()));
         }

         this.hospitalisationMedi.setHosmedProduit(this.produits.getProCode());
         this.hospitalisationMedi.setHosmedLibelle(this.produits.getProLibClient());
         Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsMed");
         this.calculDepotMedicamment(var4);
         this.tarifPatient(var4);
         this.calculPrixMedicamment(var4);
         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelProduits = false;
   }

   public void calculDepotMedicamment(Session var1) throws HibernateException, NamingException {
      this.mesDepotsItems.clear();
      this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      Object var2 = new ArrayList();
      if (this.produits != null) {
         var2 = this.produitsDepotDao.selectProdDepByprod(this.produits, 73, var1);
      } else if (this.hospitalisationMedi.getHosmedProduit() != null && !this.hospitalisationMedi.getHosmedProduit().isEmpty()) {
         var2 = this.produitsDepotDao.selectProdDepByprod((String)this.hospitalisationMedi.getHosmedProduit(), (Session)null);
      }

      if (((List)var2).size() != 0) {
         for(int var3 = 0; var3 < ((List)var2).size(); ++var3) {
            this.mesDepotsItems.add(new SelectItem(((ProduitsDepot)((List)var2).get(var3)).getDepot().getDpoCode() + ":" + ((ProduitsDepot)((List)var2).get(var3)).getDepot().getDpoLibelle() + "=" + ((ProduitsDepot)((List)var2).get(var3)).getProdepQteStk()));
         }
      }

   }

   public void calculPrixMedicamment(Session var1) throws HibernateException, NamingException {
      float var2 = 1.0F;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = this.hospitalisationMedi.getHosmedPu();
      double var11 = this.hospitalisationMedi.getHosmedPuCnamgs();
      double var13 = this.hospitalisationMedi.getHosmedPuAssurance();
      boolean var15 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         var15 = true;
      }

      this.produits = this.produitsMedicDao.chargeProduit(this.hospitalisationMedi.getHosmedProduit(), var1);
      if (this.produits != null) {
         this.hospitalisationMedi.setHosmedProduit(this.produits.getProCode());
         this.hospitalisationMedi.setHosmedLibelle(this.produits.getProLibClient());
         this.hospitalisationMedi.setHosmedCodeTva(this.produits.getProVteTva());
         this.hospitalisationMedi.setHosmedTauxTva(0.0F);
         if (this.hospitalisationMedi.getHosmedCodeTva() != null && !this.hospitalisationMedi.getHosmedCodeTva().isEmpty()) {
            this.taxesMedical = this.taxesMedicalDao.selectTva(this.exercicesVentes.getExevteId(), this.hospitalisationMedi.getHosmedCodeTva(), var1);
            if (this.taxesMedical != null) {
               this.hospitalisationMedi.setHosmedTauxTva(this.taxesMedical.getTaxvteTaux());
            }
         }

         String var16 = this.hospitalisationEntete.getLibelleFamille();
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
            if (var2 == 0.0F) {
               var2 = 1.0F;
               if (this.lesCategoriesList.size() != 0) {
                  for(var17 = 0; var17 < this.lesCategoriesList.size(); ++var17) {
                     if (((ObjetCategories)this.lesCategoriesList.get(var17)).getLibelle_FR().equals(this.hospitalisationEntete.getLibelleFamille())) {
                        var2 = ((ObjetCategories)this.lesCategoriesList.get(var17)).getCoef();
                        break;
                     }
                  }
               }
            }

            this.hospitalisationMedi.setHosmedCoef(var2);
            if (var9 != 0.0D) {
               var3 = var9;
            }

            this.hospitalisationMedi.setHosmedPu(var3);
            if (var11 != 0.0D) {
               var5 = var11;
            }

            this.hospitalisationMedi.setHosmedPuCnamgs(var5);
            if (var13 != 0.0D) {
               var7 = var13;
            }

            this.hospitalisationMedi.setHosmedPuAssurance(var7);
            if (this.hospitalisationEntete.getHosFam() >= 1L) {
               this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 0, var1);
               if (this.patientPec != null) {
                  this.conventionMedical = this.conventionMedicalDao.trouveConvention(this.patientPec.getTiers().getTieid(), this.hospitalisationMedi.getHosmedProduit(), var1);
                  if (this.conventionMedical != null) {
                     this.hospitalisationMedi.setHosmedPuAssurance(this.conventionMedical.getCvnValeur());
                     if (this.conventionMedical.getCvnValeurOrigine() != 0.0D) {
                        this.hospitalisationMedi.setHosmedPu(this.conventionMedical.getCvnValeurOrigine());
                     }
                  }
               }
            }
         } else {
            this.hospitalisationMedi.setHosmedCoef(0.0F);
            this.hospitalisationMedi.setHosmedPu(var9);
            this.hospitalisationMedi.setHosmedPuCnamgs(var11);
            this.hospitalisationMedi.setHosmedPuAssurance(var13);
         }
      } else {
         this.hospitalisationMedi.setHosmedCoef(0.0F);
         this.hospitalisationMedi.setHosmedPu(var9);
         this.hospitalisationMedi.setHosmedPuCnamgs(var11);
         this.hospitalisationMedi.setHosmedPuAssurance(var13);
      }

      if (this.var_pecCnamgs != 0.0F) {
         this.medicammentAvecCnamgsPrive(var1);
      } else if (this.hospitalisationEntete.getHosFam() != 0L && this.hospitalisationEntete.getHosFam() != -1L) {
         this.medicammentSansCnamgsAssure(var1);
      } else {
         this.medicammentSansCnamgsPrive(var1);
      }

      if (var15) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void medicammentSansCnamgsAssure(Session var1) throws HibernateException, NamingException {
      double var2;
      if (this.hospitalisationMedi.getHosmedRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.hospitalisationMedi.getHosmedPu() * (double)this.hospitalisationMedi.getHosmedRemise() / 100.0D, this.structureLog.getStrdevise());
         this.hospitalisationMedi.setHosmedPuRem(this.hospitalisationMedi.getHosmedPu() - var2);
         this.hospitalisationActes.setHosactRabais(0.0D);
      } else {
         this.hospitalisationMedi.setHosmedPuRem(this.hospitalisationMedi.getHosmedPu());
      }

      this.hospitalisationMedi.setHosmedTotal(this.hospitalisationMedi.getHosmedPuRem() * (double)this.hospitalisationMedi.getHosmedQte());
      if (this.hospitalisationMedi.getHosmedTauxTva() != 0.0F) {
         var2 = this.hospitalisationMedi.getHosmedTotal() * (double)this.hospitalisationMedi.getHosmedTauxTva() / 100.0D;
         this.hospitalisationMedi.setHosmedTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.hospitalisationMedi.setHosmedTaxe(0.0D);
      }

      this.hospitalisationMedi.setHosmedPuCnamgs(0.0D);
      this.hospitalisationMedi.setHosmedSocieteHt(0.0D);
      this.hospitalisationMedi.setHosmedSocieteTaxe(0.0D);
      this.hospitalisationMedi.setHosmedAssuranceHt(0.0D);
      this.hospitalisationMedi.setHosmedAssuranceTaxe(0.0D);
      this.hospitalisationMedi.setHosmedComplementaireHt(0.0D);
      this.hospitalisationMedi.setHosmedComplementaireTaxe(0.0D);
      this.hospitalisationMedi.setHosmedPatientHt(0.0D);
      this.hospitalisationMedi.setHosmedPatientTaxe(0.0D);
      this.hospitalisationEntete.setHosIdEmployeur(0L);
      var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      float var8 = 0.0F;
      double var9;
      if (this.hospitalisationEntete.getHosIdSociete() != 0L && this.hospitalisationEntete.getHosFam() != 0L) {
         if (this.patientPec == null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 0, var1);
         }

         if (this.patientPec != null) {
            var2 = this.hospitalisationMedi.getHosmedTotal() * (double)this.patientPec.getPatpecMedicamentHospit() / 100.0D;
            if (this.patientPec.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.hospitalisationMedi.setHosmedSocieteHt(var2);
            } else {
               this.hospitalisationMedi.setHosmedSocieteHt(var2 * (double)this.patientPec.getTiers().getTiecoefpvmedical());
               var8 = this.patientPec.getTiers().getTiecoefpvmedical();
            }

            if (this.hospitalisationMedi.getHosmedTauxTva() != 0.0F) {
               var9 = this.hospitalisationMedi.getHosmedSocieteHt() * (double)this.hospitalisationMedi.getHosmedTauxTva() / 100.0D;
               this.hospitalisationMedi.setHosmedSocieteTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      } else if (this.hospitalisationEntete.getHosIdAssurance() != 0L && this.hospitalisationEntete.getHosFam() != 0L) {
         if (this.patientPec == null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 0, var1);
         }

         if (this.patientPec != null) {
            this.var_pecAssurance = true;
            this.hospitalisationEntete.setHosIdEmployeur(this.patientPec.getPatpecIdEmployeur());
            if (this.hospitalisationMedi.getHosmedPuAssurance() == 0.0D) {
               this.hospitalisationMedi.setHosmedPuAssurance(this.hospitalisationMedi.getHosmedPu());
            }

            var4 = this.hospitalisationMedi.getHosmedPuAssurance() * (double)this.hospitalisationMedi.getHosmedQte() * (double)this.patientPec.getPatpecMedicamentHospit() / 100.0D;
            if (this.hospitalisationMedi.getHosmedRemise() != 0.0F) {
               var9 = this.utilNombre.myRoundDevise(var4 * (double)this.hospitalisationMedi.getHosmedRemise() / 100.0D, this.structureLog.getStrdevise());
               var4 -= var9;
            }

            if (this.patientPec.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.hospitalisationMedi.setHosmedAssuranceHt(var4);
            } else {
               this.hospitalisationMedi.setHosmedAssuranceHt(var4 * (double)this.patientPec.getTiers().getTiecoefpvmedical());
               var8 = this.patientPec.getTiers().getTiecoefpvmedical();
            }

            if (this.hospitalisationMedi.getHosmedTauxTva() != 0.0F) {
               var9 = this.hospitalisationMedi.getHosmedAssuranceHt() * (double)this.hospitalisationMedi.getHosmedTauxTva() / 100.0D;
               this.hospitalisationMedi.setHosmedAssuranceTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      }

      if (this.hospitalisationEntete.getHosIdComplementaire() != 0L) {
         if (this.patientPecComplementaire == null) {
            this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosComplementaire(), 0, var1);
         }

         if (this.patientPecComplementaire != null) {
            var6 = this.hospitalisationMedi.getHosmedPuAssurance() * (double)this.hospitalisationMedi.getHosmedQte() * (double)this.patientPec.getPatpecMedicamentHospit() / 100.0D;
            if (this.hospitalisationMedi.getHosmedRemise() != 0.0F) {
               var9 = this.utilNombre.myRoundDevise(var6 * (double)this.hospitalisationMedi.getHosmedRemise() / 100.0D, this.structureLog.getStrdevise());
               var6 -= var9;
            }

            if (this.patientPecComplementaire.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.hospitalisationMedi.setHosmedComplementaireHt(var6);
            } else {
               this.hospitalisationMedi.setHosmedComplementaireHt(var6 * (double)this.patientPecComplementaire.getTiers().getTiecoefpvmedical());
            }

            if (this.hospitalisationMedi.getHosmedTauxTva() != 0.0F) {
               var9 = this.hospitalisationMedi.getHosmedComplementaireHt() * (double)this.hospitalisationMedi.getHosmedTauxTva() / 100.0D;
               this.hospitalisationMedi.setHosmedComplementaireTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      }

      var9 = 0.0D;
      var8 = 0.0F;
      double var11;
      if (var8 != 0.0F && this.produits.getProMajoration() == 0 && this.optionMedical.getCoefMajoration().equals("2")) {
         if (this.hospitalisationMedi.getHosmedRemise() != 0.0F) {
            var11 = this.utilNombre.myRoundDevise(this.hospitalisationMedi.getHosmedPu() * (double)this.hospitalisationMedi.getHosmedRemise() / 100.0D, this.structureLog.getStrdevise());
            this.hospitalisationMedi.setHosmedPuRem((this.hospitalisationMedi.getHosmedPu() - var11) * (double)var8);
         } else {
            this.hospitalisationMedi.setHosmedPuRem(this.hospitalisationMedi.getHosmedPu() * (double)var8);
         }

         this.hospitalisationMedi.setHosmedTotal(this.hospitalisationMedi.getHosmedPuRem() * (double)this.hospitalisationMedi.getHosmedQte());
         if (this.hospitalisationMedi.getHosmedTauxTva() != 0.0F) {
            var11 = this.hospitalisationMedi.getHosmedTotal() * (double)this.hospitalisationMedi.getHosmedTauxTva() / 100.0D;
            this.hospitalisationMedi.setHosmedTaxe(this.utilNombre.myRoundDevise(var11, this.structureLog.getStrdevise()));
         } else {
            this.hospitalisationMedi.setHosmedTaxe(0.0D);
         }
      } else {
         var9 = this.hospitalisationMedi.getHosmedTotal() - (var2 + var4 + var6);
         this.hospitalisationMedi.setHosmedTotal(this.hospitalisationMedi.getHosmedSocieteHt() + this.hospitalisationMedi.getHosmedAssuranceHt() + this.hospitalisationMedi.getHosmedComplementaireHt() + var9);
      }

      var11 = this.hospitalisationMedi.getHosmedTotal() - (this.hospitalisationMedi.getHosmedSocieteHt() + this.hospitalisationMedi.getHosmedAssuranceHt() + this.hospitalisationMedi.getHosmedComplementaireHt());
      if (this.hospitalisationMedi.getHosmedRabais() != 0.0D) {
         this.hospitalisationMedi.setHosmedPatientHt(var11 - this.hospitalisationMedi.getHosmedRabais());
         this.hospitalisationMedi.setHosmedRemise(0.0F);
         if (this.hospitalisationMedi.getHosmedPatientHt() < 0.0D) {
            this.hospitalisationMedi.setHosmedPatientHt(var11);
            this.hospitalisationMedi.setHosmedRabais(0.0D);
         }
      } else {
         this.hospitalisationMedi.setHosmedPatientHt(var11);
      }

      double var13;
      if (this.hospitalisationMedi.getHosmedTauxTva() != 0.0F) {
         var13 = this.hospitalisationMedi.getHosmedPatientHt() * (double)this.hospitalisationMedi.getHosmedTauxTva() / 100.0D;
         this.hospitalisationMedi.setHosmedPatientTaxe(this.utilNombre.myRoundDevise(var13, this.structureLog.getStrdevise()));
      }

      if (var8 != 0.0F && this.produits.getProMajoration() == 0 && this.optionMedical.getCoefMajoration().equals("3")) {
         if (this.hospitalisationMedi.getHosmedRemise() != 0.0F) {
            var13 = this.utilNombre.myRoundDevise(this.hospitalisationMedi.getHosmedPu() * (double)this.hospitalisationMedi.getHosmedRemise() / 100.0D, this.structureLog.getStrdevise());
            this.hospitalisationMedi.setHosmedPuRem((this.hospitalisationMedi.getHosmedPu() - var13) * (double)var8);
         } else {
            this.hospitalisationMedi.setHosmedPuRem(this.hospitalisationMedi.getHosmedPu() * (double)var8);
         }

         this.hospitalisationMedi.setHosmedTotal(this.hospitalisationMedi.getHosmedPuRem() * (double)this.hospitalisationMedi.getHosmedQte());
         var13 = this.hospitalisationMedi.getHosmedAssuranceHt() + this.hospitalisationMedi.getHosmedComplementaireHt() + this.hospitalisationMedi.getHosmedSocieteHt() + this.hospitalisationMedi.getHosmedPatientHt();
         double var15 = this.hospitalisationMedi.getHosmedTotal() - var13;
         if (var15 != 0.0D) {
            if (var4 != 0.0D) {
               this.hospitalisationMedi.setHosmedAssuranceHt(this.hospitalisationMedi.getHosmedAssuranceHt() + var15);
            } else if (var2 != 0.0D) {
               this.hospitalisationMedi.setHosmedSocieteHt(this.hospitalisationMedi.getHosmedSocieteHt() + var15);
            }

            if (var6 != 0.0D) {
               this.hospitalisationMedi.setHosmedComplementaireHt(this.hospitalisationMedi.getHosmedComplementaireHt() + var15);
            }
         }
      }

   }

   public void medicammentSansCnamgsPrive(Session var1) {
      if (this.tauxCasSocial != 0.0F) {
         this.hospitalisationMedi.setHosmedRemise(this.tauxCasSocial);
      }

      double var2;
      if (this.hospitalisationMedi.getHosmedRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.hospitalisationMedi.getHosmedPu() * (double)this.hospitalisationMedi.getHosmedRemise() / 100.0D, this.structureLog.getStrdevise());
         this.hospitalisationMedi.setHosmedPuRem(this.hospitalisationMedi.getHosmedPu() - var2);
         this.hospitalisationMedi.setHosmedRabais(0.0D);
      } else {
         this.hospitalisationMedi.setHosmedPuRem(this.hospitalisationMedi.getHosmedPu());
      }

      this.hospitalisationMedi.setHosmedTotal(this.hospitalisationMedi.getHosmedPuRem() * (double)this.hospitalisationMedi.getHosmedQte());
      if (this.hospitalisationMedi.getHosmedTauxTva() != 0.0F) {
         var2 = this.hospitalisationMedi.getHosmedTotal() * (double)this.hospitalisationMedi.getHosmedTauxTva() / 100.0D;
         this.hospitalisationMedi.setHosmedTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.hospitalisationMedi.setHosmedTaxe(0.0D);
      }

      this.hospitalisationMedi.setHosmedPuCnamgs(0.0D);
      this.hospitalisationMedi.setHosmedSocieteHt(0.0D);
      this.hospitalisationMedi.setHosmedSocieteTaxe(0.0D);
      this.hospitalisationMedi.setHosmedAssuranceHt(0.0D);
      this.hospitalisationMedi.setHosmedAssuranceTaxe(0.0D);
      this.hospitalisationMedi.setHosmedComplementaireHt(0.0D);
      this.hospitalisationMedi.setHosmedComplementaireTaxe(0.0D);
      this.hospitalisationMedi.setHosmedPatientHt(0.0D);
      this.hospitalisationMedi.setHosmedPatientTaxe(0.0D);
      this.hospitalisationEntete.setHosIdEmployeur(0L);
      var2 = this.hospitalisationMedi.getHosmedTotal();
      if (this.hospitalisationMedi.getHosmedRabais() != 0.0D) {
         this.hospitalisationMedi.setHosmedPatientHt(var2 - this.hospitalisationMedi.getHosmedRabais());
         this.hospitalisationMedi.setHosmedRemise(0.0F);
         if (this.hospitalisationMedi.getHosmedPatientHt() < 0.0D) {
            this.hospitalisationMedi.setHosmedPatientHt(var2);
            this.hospitalisationMedi.setHosmedRabais(0.0D);
         }
      } else {
         this.hospitalisationMedi.setHosmedPatientHt(var2);
      }

      if (this.hospitalisationMedi.getHosmedTaxe() != 0.0D) {
         double var4 = this.hospitalisationMedi.getHosmedPatientHt() * (double)this.hospitalisationMedi.getHosmedTauxTva() / 100.0D;
         this.hospitalisationMedi.setHosmedPatientTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
      } else {
         this.hospitalisationMedi.setHosmedPatientTaxe(0.0D);
      }

   }

   public void medicammentAvecCnamgsPrive(Session var1) throws HibernateException, NamingException {
      if (this.hospitalisationMedi.getHosmedPuCnamgs() > this.hospitalisationMedi.getHosmedPu()) {
         this.hospitalisationMedi.setHosmedPu(this.hospitalisationMedi.getHosmedPuCnamgs());
      }

      double var2;
      double var4;
      if (this.hospitalisationMedi.getHosmedRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.hospitalisationMedi.getHosmedPu() * (double)this.hospitalisationMedi.getHosmedRemise() / 100.0D, this.structureLog.getStrdevise());
         this.hospitalisationMedi.setHosmedPuRem(this.hospitalisationMedi.getHosmedPu() - var2);
         var4 = this.utilNombre.myRoundDevise(this.hospitalisationMedi.getHosmedPuCnamgs() * (double)this.hospitalisationMedi.getHosmedRemise() / 100.0D, this.structureLog.getStrdevise());
         this.hospitalisationMedi.setHosmedPuCnamgs(this.hospitalisationMedi.getHosmedPuCnamgs() - var4);
         this.hospitalisationMedi.setHosmedRabais(0.0D);
      } else {
         this.hospitalisationMedi.setHosmedPuRem(this.hospitalisationMedi.getHosmedPu());
      }

      this.hospitalisationMedi.setHosmedTotal(this.hospitalisationMedi.getHosmedPuRem() * (double)this.hospitalisationMedi.getHosmedQte());
      if (this.hospitalisationMedi.getHosmedTauxTva() != 0.0F) {
         var2 = this.hospitalisationMedi.getHosmedTotal() * (double)this.hospitalisationMedi.getHosmedTauxTva() / 100.0D;
         this.hospitalisationMedi.setHosmedTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.hospitalisationMedi.setHosmedTaxe(0.0D);
      }

      this.hospitalisationMedi.setHosmedSocieteHt(0.0D);
      this.hospitalisationMedi.setHosmedSocieteTaxe(0.0D);
      this.hospitalisationMedi.setHosmedAssuranceHt(0.0D);
      this.hospitalisationMedi.setHosmedAssuranceTaxe(0.0D);
      this.hospitalisationMedi.setHosmedComplementaireHt(0.0D);
      this.hospitalisationMedi.setHosmedComplementaireTaxe(0.0D);
      this.hospitalisationMedi.setHosmedPatientHt(0.0D);
      this.hospitalisationMedi.setHosmedPatientTaxe(0.0D);
      this.hospitalisationEntete.setHosIdEmployeur(0L);
      this.hospitalisationMedi.setHosmedAssuranceHt(this.hospitalisationMedi.getHosmedPuCnamgs() * (double)this.hospitalisationMedi.getHosmedQte() * (double)this.var_pecCnamgs / 100.0D);
      if (this.hospitalisationMedi.getHosmedTauxTva() != 0.0F) {
         var2 = this.hospitalisationMedi.getHosmedAssuranceHt() * (double)this.hospitalisationMedi.getHosmedTauxTva() / 100.0D;
         this.hospitalisationMedi.setHosmedAssuranceTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      }

      var2 = this.hospitalisationMedi.getHosmedTotal() - this.hospitalisationMedi.getHosmedAssuranceHt();
      if (this.hospitalisationMedi.getHosmedRabais() != 0.0D) {
         this.hospitalisationMedi.setHosmedPatientHt(var2 - this.hospitalisationMedi.getHosmedRabais());
         this.hospitalisationMedi.setHosmedRemise(0.0F);
         if (this.hospitalisationMedi.getHosmedPatientHt() < 0.0D) {
            this.hospitalisationMedi.setHosmedPatientHt(var2);
            this.hospitalisationMedi.setHosmedRabais(0.0D);
         }
      } else {
         this.hospitalisationMedi.setHosmedPatientHt(var2);
      }

      if (this.hospitalisationMedi.getHosmedTauxTva() != 0.0F) {
         var4 = this.hospitalisationMedi.getHosmedPatientHt() * (double)this.hospitalisationMedi.getHosmedTauxTva() / 100.0D;
         this.hospitalisationMedi.setHosmedPatientTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
      }

   }

   public void selectionLaboratoire() throws HibernateException, NamingException {
      if (this.dataModelLabo.isRowAvailable()) {
         this.hospitalisationLabo = (HospitalisationLabo)this.dataModelLabo.getRowData();
         if (this.hospitalisationLabo.getHoslabProduit() != null && !this.hospitalisationLabo.getHoslabProduit().isEmpty()) {
            this.mesImputationLabo.clear();
            this.choixImputationLabo = false;
            this.produits = this.produitsMedicDao.chargeProduit(this.hospitalisationLabo.getHoslabProduit(), (Session)null);
            if (this.produits != null && this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty()) {
               this.choixImputationLabo = true;
               if (!this.produits.getProActivite().contains("#")) {
                  this.mesImputationLabo.add(new SelectItem(this.produits.getProActivite()));
               } else {
                  String[] var1 = this.produits.getProActivite().split("#");
                  int var2 = var1.length;

                  for(int var3 = 0; var3 < var2; ++var3) {
                     this.mesImputationLabo.add(new SelectItem(var1[var3]));
                  }
               }
            }
         } else {
            this.produits = null;
         }

         this.afficheButtLabo = true;
         this.valideLabo = true;
      }

   }

   public void ajouterLaboratoire() {
      this.mesSejoursItems.clear();
      if (this.lesSejours.size() != 0) {
         int var1;
         for(var1 = 0; var1 < this.lesSejours.size(); ++var1) {
            if (((HospitalisationSejour)this.lesSejours.get(var1)).getHossejDateSortie() == null) {
               this.mesSejoursItems.add(new SelectItem(((HospitalisationSejour)this.lesSejours.get(var1)).getHossejId(), ((HospitalisationSejour)this.lesSejours.get(var1)).getHossejService()));
            }
         }

         this.produits = new Produits();
         this.hospitalisationLabo = new HospitalisationLabo();
         if (this.lesLabos.size() != 0) {
            var1 = this.lesLabos.size() - 1;
            this.hospitalisationLabo.setHoslabIdSejour(((HospitalisationLabo)this.lesLabos.get(var1)).getHoslabIdSejour());
            this.hospitalisationLabo.setHoslabIdMedecin(((HospitalisationLabo)this.lesLabos.get(var1)).getHoslabIdMedecin());
            this.hospitalisationLabo.setHoslabMedecin(((HospitalisationLabo)this.lesLabos.get(var1)).getHoslabMedecin());
            this.hospitalisationLabo.setHoslabService(((HospitalisationLabo)this.lesLabos.get(var1)).getHoslabService());
            this.hospitalisationLabo.setHoslabAnonyme(((HospitalisationLabo)this.lesLabos.get(var1)).isHoslabAnonyme());
            this.hospitalisationLabo.setHoslabDatePrelevement(((HospitalisationLabo)this.lesLabos.get(var1)).getHoslabDatePrelevement());
            this.hospitalisationLabo.setHoslabDateRegles(((HospitalisationLabo)this.lesLabos.get(var1)).getHoslabDateRegles());
            this.hospitalisationLabo.setHoslabDiabete(((HospitalisationLabo)this.lesLabos.get(var1)).isHoslabDiabete());
            this.hospitalisationLabo.setHoslabGrossesse(((HospitalisationLabo)this.lesLabos.get(var1)).isHoslabGrossesse());
            this.hospitalisationLabo.setHoslabImmunodepressif(((HospitalisationLabo)this.lesLabos.get(var1)).isHoslabImmunodepressif());
            this.hospitalisationLabo.setHoslabLequel(((HospitalisationLabo)this.lesLabos.get(var1)).getHoslabLequel());
            this.hospitalisationLabo.setHoslabPartenaire(((HospitalisationLabo)this.lesLabos.get(var1)).getHoslabPartenaire());
            this.hospitalisationLabo.setHoslabTraitement(((HospitalisationLabo)this.lesLabos.get(var1)).isHoslabTraitement());
            this.hospitalisationLabo.setHoslabUrgent(((HospitalisationLabo)this.lesLabos.get(var1)).getHoslabUrgent());
         } else if (this.lesSejours.size() != 0) {
            var1 = this.lesSejours.size() - 1;
            this.hospitalisationLabo.setHoslabIdSejour(((HospitalisationSejour)this.lesSejours.get(var1)).getHossejId());
            this.hospitalisationLabo.setHoslabService(((HospitalisationSejour)this.lesSejours.get(var1)).getHossejService());
         }

         this.hospitalisationLabo.setHoslabLaboratoire("");
         this.hospitalisationLabo.setHoslabLieuPrelevement(3);
         this.valideLabo = false;
         this.afficheButtLabo = false;
         this.showModalPanelLabo = true;
      }

   }

   public void modifierLaboratoire() throws HibernateException, NamingException {
      if (this.hospitalisationLabo != null) {
         this.mesSejoursItems.clear();
         if (this.lesSejours.size() != 0) {
            for(int var1 = 0; var1 < this.lesSejours.size(); ++var1) {
               if (((HospitalisationSejour)this.lesSejours.get(var1)).getHossejDateSortie() == null) {
                  this.mesSejoursItems.add(new SelectItem(((HospitalisationSejour)this.lesSejours.get(var1)).getHossejId(), ((HospitalisationSejour)this.lesSejours.get(var1)).getHossejService()));
               }
            }

            this.calculMedecinLabo();
            this.showModalPanelLabo = true;
         }
      }

   }

   public void supprimerLaboratoire() throws HibernateException, NamingException {
      if (this.hospitalisationLabo != null) {
         this.hospitalisationLaboDao.delete(this.hospitalisationLabo);
         this.lesLabos.remove(this.hospitalisationLabo);
         this.dataModelLabo.setWrappedData(this.lesLabos);
         this.afficheButtLabo = false;
      }

   }

   public void avoirLaboratoire() throws HibernateException, NamingException {
      if (this.hospitalisationLabo != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            HospitalisationLabo var3 = new HospitalisationLabo();
            var3.setHospitalisationEntete(this.hospitalisationEntete);
            var3.setHoslabAnonyme(this.hospitalisationLabo.isHoslabAnonyme());
            var3.setHoslabAssuranceHt(this.hospitalisationLabo.getHoslabAssuranceHt() * -1.0D);
            var3.setHoslabAssuranceTaxe(this.hospitalisationLabo.getHoslabAssuranceTaxe() * -1.0D);
            var3.setHoslabCodeTva(this.hospitalisationLabo.getHoslabCodeTva());
            var3.setHoslabCoef(this.hospitalisationLabo.getHoslabCoef());
            var3.setHoslabComplementaireHt(this.hospitalisationLabo.getHoslabComplementaireHt() * -1.0D);
            var3.setHoslabComplementaireTaxe(this.hospitalisationLabo.getHoslabComplementaireTaxe() * -1.0D);
            var3.setHoslabDatePrelevement(this.hospitalisationLabo.getHoslabDatePrelevement());
            var3.setHoslabDateRegles(this.hospitalisationLabo.getHoslabDateRegles());
            var3.setHoslabDateResultat(this.hospitalisationLabo.getHoslabDateResultat());
            var3.setHoslabDiabete(this.hospitalisationLabo.isHoslabDiabete());
            var3.setHoslabGrossesse(this.hospitalisationLabo.isHoslabGrossesse());
            var3.setHoslabIdLaboratoire(this.hospitalisationLabo.getHoslabIdLaboratoire());
            var3.setHoslabIdMedecin(this.hospitalisationLabo.getHoslabIdMedecin());
            var3.setHoslabIdSejour(this.hospitalisationLabo.getHoslabIdSejour());
            var3.setHoslabImmunodepressif(this.hospitalisationLabo.isHoslabImmunodepressif());
            var3.setHoslabLaboratoire(this.hospitalisationLabo.getHoslabLaboratoire());
            var3.setHoslabLequel(this.hospitalisationLabo.getHoslabLequel());
            var3.setHoslabLettre(this.hospitalisationLabo.getHoslabLettre());
            var3.setHoslabLibelle(this.hospitalisationLabo.getHoslabLibelle());
            var3.setHoslabLieuPrelevement(this.hospitalisationLabo.getHoslabLieuPrelevement());
            var3.setHoslabMedecin(this.hospitalisationLabo.getHoslabMedecin());
            var3.setHoslabNb(this.hospitalisationLabo.getHoslabNb());
            var3.setHoslabNbCnamgs(this.hospitalisationLabo.getHoslabNbCnamgs());
            var3.setHoslabPartenaire(this.hospitalisationLabo.getHoslabPartenaire());
            var3.setHoslabPatientHt(this.hospitalisationLabo.getHoslabPatientHt() * -1.0D);
            var3.setHoslabPatientTaxe(this.hospitalisationLabo.getHoslabPatientTaxe() * -1.0D);
            var3.setHoslabProduit(this.hospitalisationLabo.getHoslabProduit());
            var3.setHoslabPu(this.hospitalisationLabo.getHoslabPu());
            var3.setHoslabPuAssurance(this.hospitalisationLabo.getHoslabPuAssurance());
            var3.setHoslabPuCnamgs(this.hospitalisationLabo.getHoslabPuCnamgs());
            var3.setHoslabPuRem(this.hospitalisationLabo.getHoslabPuRem());
            var3.setHoslabQte(this.hospitalisationLabo.getHoslabQte() * -1.0F);
            var3.setHoslabRegPatient(0.0D);
            var3.setHoslabRegTiers(0.0D);
            var3.setHoslabRemise(this.hospitalisationLabo.getHoslabRemise());
            var3.setHoslabService(this.hospitalisationLabo.getHoslabService());
            var3.setHoslabSocieteHt(this.hospitalisationLabo.getHoslabSocieteHt() * -1.0D);
            var3.setHoslabSocieteTaxe(this.hospitalisationLabo.getHoslabSocieteTaxe() * -1.0D);
            var3.setHoslabTauxTva(this.hospitalisationLabo.getHoslabTauxTva());
            var3.setHoslabTaxe(this.hospitalisationLabo.getHoslabTaxe() * -1.0D);
            var3.setHoslabTotal(this.hospitalisationLabo.getHoslabTotal() * -1.0D);
            var3.setHoslabTraitement(this.hospitalisationLabo.isHoslabTraitement());
            var3.setHoslabUrgent(this.hospitalisationLabo.getHoslabUrgent());
            var3.setHoslabValeur(this.hospitalisationLabo.getHoslabValeur());
            var3.setHoslabValeurCnamgs(this.hospitalisationLabo.getHoslabValeurCnamgs());
            this.hospitalisationLabo = new HospitalisationLabo();
            this.hospitalisationLabo = var3;
            this.hospitalisationLabo = this.hospitalisationLaboDao.insert(this.hospitalisationLabo, var1);
            this.lesLabos.add(this.hospitalisationLabo);
            this.dataModelLabo.setWrappedData(this.lesLabos);
            this.calculTotaux();
            this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
            double var4 = this.hospitalisationLabo.getHoslabPatientHt() + this.hospitalisationLabo.getHoslabPatientTaxe();
            if (var4 != 0.0D) {
               this.majBonencaissementAnnulation(Math.abs(var4), new Date(), var1);
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

         this.ajouterLaboratoire();
      }

   }

   public void annulationLaboratoire() throws NamingException {
      if (this.hospitalisationLabo != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            HospitalisationLabo var3 = new HospitalisationLabo();
            var3.setHospitalisationEntete(this.hospitalisationEntete);
            var3.setHoslabAnonyme(this.hospitalisationLabo.isHoslabAnonyme());
            var3.setHoslabAssuranceHt(this.hospitalisationLabo.getHoslabAssuranceHt() * -1.0D);
            var3.setHoslabAssuranceTaxe(this.hospitalisationLabo.getHoslabAssuranceTaxe() * -1.0D);
            var3.setHoslabCodeTva(this.hospitalisationLabo.getHoslabCodeTva());
            var3.setHoslabCoef(this.hospitalisationLabo.getHoslabCoef());
            var3.setHoslabComplementaireHt(this.hospitalisationLabo.getHoslabComplementaireHt() * -1.0D);
            var3.setHoslabComplementaireTaxe(this.hospitalisationLabo.getHoslabComplementaireTaxe() * -1.0D);
            var3.setHoslabDatePrelevement(this.hospitalisationLabo.getHoslabDatePrelevement());
            var3.setHoslabDateRegles(this.hospitalisationLabo.getHoslabDateRegles());
            var3.setHoslabDateResultat(this.hospitalisationLabo.getHoslabDateResultat());
            var3.setHoslabDiabete(this.hospitalisationLabo.isHoslabDiabete());
            var3.setHoslabGrossesse(this.hospitalisationLabo.isHoslabGrossesse());
            var3.setHoslabIdLaboratoire(this.hospitalisationLabo.getHoslabIdLaboratoire());
            var3.setHoslabIdMedecin(this.hospitalisationLabo.getHoslabIdMedecin());
            var3.setHoslabIdSejour(this.hospitalisationLabo.getHoslabIdSejour());
            var3.setHoslabImmunodepressif(this.hospitalisationLabo.isHoslabImmunodepressif());
            var3.setHoslabLaboratoire(this.hospitalisationLabo.getHoslabLaboratoire());
            var3.setHoslabLequel(this.hospitalisationLabo.getHoslabLequel());
            var3.setHoslabLettre(this.hospitalisationLabo.getHoslabLettre());
            var3.setHoslabLibelle(this.hospitalisationLabo.getHoslabLibelle());
            var3.setHoslabLieuPrelevement(this.hospitalisationLabo.getHoslabLieuPrelevement());
            var3.setHoslabMedecin(this.hospitalisationLabo.getHoslabMedecin());
            var3.setHoslabNb(this.hospitalisationLabo.getHoslabNb());
            var3.setHoslabNbCnamgs(this.hospitalisationLabo.getHoslabNbCnamgs());
            var3.setHoslabPartenaire(this.hospitalisationLabo.getHoslabPartenaire());
            var3.setHoslabPatientHt(this.hospitalisationLabo.getHoslabPatientHt() * -1.0D);
            var3.setHoslabPatientTaxe(this.hospitalisationLabo.getHoslabPatientTaxe() * -1.0D);
            var3.setHoslabProduit(this.hospitalisationLabo.getHoslabProduit());
            var3.setHoslabPu(this.hospitalisationLabo.getHoslabPu());
            var3.setHoslabPuAssurance(this.hospitalisationLabo.getHoslabPuAssurance());
            var3.setHoslabPuCnamgs(this.hospitalisationLabo.getHoslabPuCnamgs());
            var3.setHoslabPuRem(this.hospitalisationLabo.getHoslabPuRem());
            var3.setHoslabQte(this.hospitalisationLabo.getHoslabQte() * -1.0F);
            var3.setHoslabRegPatient(0.0D);
            var3.setHoslabRegTiers(0.0D);
            var3.setHoslabRemise(this.hospitalisationLabo.getHoslabRemise());
            var3.setHoslabService(this.hospitalisationLabo.getHoslabService());
            var3.setHoslabSocieteHt(this.hospitalisationLabo.getHoslabSocieteHt() * -1.0D);
            var3.setHoslabSocieteTaxe(this.hospitalisationLabo.getHoslabSocieteTaxe() * -1.0D);
            var3.setHoslabTauxTva(this.hospitalisationLabo.getHoslabTauxTva());
            var3.setHoslabTaxe(this.hospitalisationLabo.getHoslabTaxe() * -1.0D);
            var3.setHoslabTotal(this.hospitalisationLabo.getHoslabTotal() * -1.0D);
            var3.setHoslabTraitement(this.hospitalisationLabo.isHoslabTraitement());
            var3.setHoslabUrgent(this.hospitalisationLabo.getHoslabUrgent());
            var3.setHoslabValeur(this.hospitalisationLabo.getHoslabValeur());
            var3.setHoslabValeurCnamgs(this.hospitalisationLabo.getHoslabValeurCnamgs());
            this.hospitalisationLabo = new HospitalisationLabo();
            this.hospitalisationLabo = var3;
            this.hospitalisationLabo = this.hospitalisationLaboDao.insert(this.hospitalisationLabo, var1);
            this.lesLabos.add(this.hospitalisationLabo);
            this.dataModelLabo.setWrappedData(this.lesLabos);
            this.calculTotaux();
            this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.ajouterLaboratoire();
      }

   }

   public void fermerLaboratoire() {
      this.hospitalisationLabo.setHoslabProduit("");
      this.hospitalisationLabo.setHoslabLibelle("");
      this.showModalPanelLabo = false;
   }

   public void saveLaboratoire() throws HibernateException, NamingException {
      if (this.hospitalisationLabo.getHoslabQte() != 0.0F) {
         if (this.hospitalisationLabo != null) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
            Transaction var2 = null;

            try {
               var2 = var1.beginTransaction();
               this.tarifPatient(var1);
               this.calculPrixLaboratoire(var1);
               if (this.hospitalisationLabo.getHoslabIdMedecin() != 0L) {
                  new Users();
                  Users var3 = this.usersDao.selectUserD(this.hospitalisationLabo.getHoslabIdMedecin(), var1);
                  if (var3 != null) {
                     this.hospitalisationLabo.setHoslabIdMedecin(var3.getUsrid());
                     this.hospitalisationLabo.setHoslabMedecin(var3.getUsrPatronyme());
                  } else {
                     this.hospitalisationLabo.setHoslabIdMedecin(0L);
                     this.hospitalisationLabo.setHoslabMedecin("");
                  }
               } else {
                  this.hospitalisationLabo.setHoslabIdMedecin(0L);
                  this.hospitalisationLabo.setHoslabMedecin("");
               }

               if (this.hospitalisationLabo.getHoslabLaboratoire() != null && !this.hospitalisationLabo.getHoslabLaboratoire().isEmpty() && this.hospitalisationLabo.getHoslabLaboratoire().contains(":")) {
                  new Service();
                  String[] var4 = this.hospitalisationLabo.getHoslabLaboratoire().split(":");
                  Service var10 = this.serviceDao.chargerLeServiceCode(var4[0], var1);
                  if (var10 != null) {
                     this.hospitalisationLabo.setHoslabIdLaboratoire(var10.getSerId());
                     this.hospitalisationLabo.setHoslabLaboratoire(var10.getSerCode() + ":" + var10.getSerNomFr());
                  } else {
                     this.hospitalisationLabo.setHoslabIdLaboratoire(0L);
                     this.hospitalisationLabo.setHoslabLaboratoire("");
                  }
               } else {
                  this.hospitalisationLabo.setHoslabIdLaboratoire(0L);
                  this.hospitalisationLabo.setHoslabLaboratoire("");
               }

               String var11 = "";
               if (this.lesSejours.size() != 0) {
                  int var12 = this.lesSejours.size() - 1;
                  var11 = ((HospitalisationSejour)this.lesSejours.get(var12)).getHossejService();
               }

               this.hospitalisationLabo.setHoslabService(var11);
               if (this.hospitalisationLabo.getHoslabId() == 0L) {
                  this.hospitalisationLabo.setHospitalisationEntete(this.hospitalisationEntete);
                  this.hospitalisationLabo.setHoslabDateCreat(new Date());
                  this.hospitalisationLabo.setHoslabUserCreat(this.usersLog.getUsrid());
                  this.hospitalisationLabo = this.hospitalisationLaboDao.insert(this.hospitalisationLabo, var1);
                  this.lesLabos.add(this.hospitalisationLabo);
                  this.dataModelLabo.setWrappedData(this.lesLabos);
               } else {
                  this.hospitalisationLabo.setHoslabDateModif(new Date());
                  this.hospitalisationLabo.setHoslabUserModif(this.usersLog.getUsrid());
                  this.hospitalisationLabo = this.hospitalisationLaboDao.modif(this.hospitalisationLabo, var1);
               }

               this.calculTotaux();
               this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
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

         this.showModalPanelLabo = false;
      }

   }

   public void verifValideLaboratoire() {
      this.valideLabo = false;
      if (this.hospitalisationLabo.getHoslabIdSejour() != 0L && this.hospitalisationLabo.getHoslabLaboratoire() != null && !this.hospitalisationLabo.getHoslabLaboratoire().isEmpty()) {
         if (this.optionMedical.getMedecinLB().equals("0")) {
            if (this.hospitalisationLabo.getHoslabIdMedecin() != 0L && this.hospitalisationLabo.getHoslabProduit() != null && !this.hospitalisationLabo.getHoslabProduit().isEmpty()) {
               this.valideLabo = true;
            }
         } else if (this.hospitalisationLabo.getHoslabProduit() != null && !this.hospitalisationLabo.getHoslabProduit().isEmpty()) {
            this.valideLabo = true;
         }
      }

   }

   public void rechercheLaboratoire() throws HibernateException, NamingException {
      this.extDTableProduits = new HtmlExtendedDataTable();
      if (this.simpleSelectionProduits == null) {
         this.simpleSelectionProduits.clear();
      }

      this.choixPanenProd = 3;
      if (this.hospitalisationLabo.getHoslabProduit() != null && !this.hospitalisationLabo.getHoslabProduit().isEmpty()) {
         this.lesProduits.clear();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsMed");
         this.lesProduits = this.produitsMedicDao.verifProduitsMedicaux(this.hospitalisationLabo.getHoslabProduit(), "1106", var1);
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

   public void selectionProduitLab() {
      if (this.datamodelProduits.isRowAvailable()) {
         this.produits = (Produits)this.datamodelProduits.getRowData();
      }

   }

   public void annulerLaboratoire() {
      this.produits = null;
      this.showModalPanelProduits = false;
   }

   public void validerLaboratoire() throws HibernateException, NamingException {
      if (this.produits != null) {
         this.hospitalisationLabo.setHoslabProduit(this.produits.getProCode());
         this.hospitalisationLabo.setHoslabLibelle(this.produits.getProLibClient());
         this.mesImputationLabo.clear();
         this.choixImputationLabo = false;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsMed");
         String var2 = "";
         int var4;
         int var5;
         String[] var6;
         if (this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty()) {
            this.choixImputationLabo = true;
            if (!this.produits.getProActivite().contains("#")) {
               this.mesImputationLabo.add(new SelectItem(this.produits.getProActivite()));
            } else {
               var6 = this.produits.getProActivite().split("#");
               var4 = var6.length;

               for(var5 = 0; var5 < var4; ++var5) {
                  this.mesImputationLabo.add(new SelectItem(var6[var5]));
               }
            }

            var2 = ((SelectItem)this.mesImputationLabo.get(0)).getValue().toString();
         } else {
            new ArrayList();
            List var3 = this.produitsServicesDao.verifProduitsMedicaux(this.hospitalisationLabo.getHoslabProduit(), "1106", (Service)null, var1);
            if (var3.size() != 0) {
               var2 = ((ProduitsServices)var3.get(0)).getProserCode() + ":" + ((ProduitsServices)var3.get(0)).getProserNomFr();
            }
         }

         this.hospitalisationLabo.setHoslabLaboratoire(var2);
         this.mesServicesFacturesLabo.clear();
         if (this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty()) {
            if (!this.produits.getProActivite().contains("#")) {
               this.mesServicesFacturesLabo.add(new SelectItem(this.produits.getProActivite()));
            } else {
               var6 = this.produits.getProActivite().split("#");
               var4 = var6.length;

               for(var5 = 0; var5 < var4; ++var5) {
                  this.mesServicesFacturesLabo.add(new SelectItem(var6[var5]));
               }
            }
         } else {
            this.mesServicesFacturesLabo.add(new SelectItem(var2));
            this.mesServicesFacturesMedi.add(new SelectItem(((HospitalisationSejour)this.lesSejours.get(this.lesSejours.size() - 1)).getHossejService()));
         }

         this.calculPrixLaboratoire(var1);
         this.utilInitHibernate.closeSession();
         this.verifValideLaboratoire();
      }

      this.showModalPanelProduits = false;
   }

   public void calculPrixLaboratoire(Session var1) throws HibernateException, NamingException {
      float var2 = 1.0F;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = this.hospitalisationLabo.getHoslabPu();
      double var11 = this.hospitalisationLabo.getHoslabPuCnamgs();
      double var13 = this.hospitalisationLabo.getHoslabPuAssurance();
      boolean var15 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         var15 = true;
      }

      this.produits = this.produitsMedicDao.chargeProduit(this.hospitalisationLabo.getHoslabProduit(), var1);
      if (this.produits != null) {
         this.hospitalisationLabo.setHoslabProduit(this.produits.getProCode());
         this.hospitalisationLabo.setHoslabLibelle(this.produits.getProLibClient());
         this.hospitalisationLabo.setHoslabLettre(this.produits.getProLettre());
         if (this.produits.getProLettre() != null && !this.produits.getProLettre().isEmpty()) {
            this.hospitalisationLabo.setHoslabLettre(this.produits.getProLettre());
         } else {
            this.hospitalisationLabo.setHoslabLettre("");
            this.hospitalisationLabo.setHoslabNb(0.0F);
            this.hospitalisationLabo.setHoslabNbCnamgs(0.0F);
         }

         this.hospitalisationLabo.setHoslabQte(1.0F);
         this.hospitalisationLabo.setHoslabCodeTva(this.produits.getProVteTva());
         this.hospitalisationLabo.setHoslabTauxTva(0.0F);
         if (this.hospitalisationLabo.getHoslabCodeTva() != null && !this.hospitalisationLabo.getHoslabCodeTva().isEmpty()) {
            this.taxesMedical = this.taxesMedicalDao.selectTva(this.exercicesVentes.getExevteId(), this.hospitalisationLabo.getHoslabCodeTva(), var1);
            if (this.taxesMedical != null) {
               this.hospitalisationLabo.setHoslabTauxTva(this.taxesMedical.getTaxvteTaux());
            }
         }

         String var16 = this.hospitalisationEntete.getLibelleFamille();
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
            this.hospitalisationLabo.setHoslabNb(this.produitsTarif.getProtarNb());
            this.hospitalisationLabo.setHoslabNbCnamgs(this.produitsTarif.getProtarNbCnamgs());
            this.hospitalisationLabo.setHoslabValeur(this.produitsTarif.getProtarValeur());
            this.hospitalisationLabo.setHoslabValeurCnamgs(this.produitsTarif.getProtarValeurCnamgs());
            if (var2 == 0.0F) {
               var2 = 1.0F;
               if (this.lesCategoriesList.size() != 0) {
                  for(var17 = 0; var17 < this.lesCategoriesList.size(); ++var17) {
                     if (((ObjetCategories)this.lesCategoriesList.get(var17)).getLibelle_FR().equals(this.hospitalisationEntete.getLibelleFamille())) {
                        var2 = ((ObjetCategories)this.lesCategoriesList.get(var17)).getCoef();
                        break;
                     }
                  }
               }
            }

            this.hospitalisationLabo.setHoslabCoef(var2);
            if (var9 != 0.0D) {
               var3 = var9;
            }

            this.hospitalisationLabo.setHoslabPu(var3);
            if (var11 != 0.0D) {
               var5 = var11;
            }

            this.hospitalisationLabo.setHoslabPuCnamgs(var5);
            if (var13 != 0.0D) {
               var7 = var13;
            }

            this.hospitalisationLabo.setHoslabPuAssurance(var7);
            if (this.hospitalisationEntete.getHosFam() >= 1L) {
               this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 0, var1);
               if (this.patientPec != null) {
                  this.conventionMedical = this.conventionMedicalDao.trouveConvention(this.patientPec.getTiers().getTieid(), this.hospitalisationLabo.getHoslabProduit(), var1);
                  if (this.conventionMedical != null) {
                     this.hospitalisationLabo.setHoslabPuAssurance(this.conventionMedical.getCvnValeur());
                     if (this.conventionMedical.getCvnValeurOrigine() != 0.0D) {
                        this.hospitalisationLabo.setHoslabPu(this.conventionMedical.getCvnValeurOrigine());
                     }
                  }
               }
            }

            if (this.hospitalisationLabo.getHoslabQte() == 0.0F) {
               this.hospitalisationLabo.setHoslabQte(1.0F);
            }
         } else {
            this.hospitalisationLabo.setHoslabLettre("");
            this.hospitalisationLabo.setHoslabNb(0.0F);
            this.hospitalisationLabo.setHoslabNbCnamgs(0.0F);
            this.hospitalisationLabo.setHoslabCoef(0.0F);
            this.hospitalisationLabo.setHoslabValeur(0.0D);
            this.hospitalisationLabo.setHoslabValeurCnamgs(0.0D);
            this.hospitalisationLabo.setHoslabPu(var9);
            this.hospitalisationLabo.setHoslabPuCnamgs(var11);
            this.hospitalisationLabo.setHoslabPuAssurance(var13);
            if (this.hospitalisationLabo.getHoslabQte() == 0.0F) {
               this.hospitalisationLabo.setHoslabQte(1.0F);
            }
         }
      } else {
         this.hospitalisationLabo.setHoslabLettre("");
         this.hospitalisationLabo.setHoslabNb(0.0F);
         this.hospitalisationLabo.setHoslabNbCnamgs(0.0F);
         this.hospitalisationLabo.setHoslabCoef(0.0F);
         this.hospitalisationLabo.setHoslabValeur(0.0D);
         this.hospitalisationLabo.setHoslabValeurCnamgs(0.0D);
         this.hospitalisationLabo.setHoslabPu(var9);
         this.hospitalisationLabo.setHoslabPuCnamgs(var11);
         this.hospitalisationLabo.setHoslabPuAssurance(var13);
         if (this.hospitalisationLabo.getHoslabQte() == 0.0F) {
            this.hospitalisationLabo.setHoslabQte(1.0F);
         }
      }

      if (this.var_pecCnamgs != 0.0F) {
         this.laboratoireAvecCnamgsPrive(var1);
      } else if (this.hospitalisationEntete.getHosFam() != 0L && this.hospitalisationEntete.getHosFam() != -1L) {
         this.laboratoireSansCnamgsAssure(var1);
      } else {
         this.laboratoireSansCnamgsPrive(var1);
      }

      if (var15) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void laboratoireSansCnamgsAssure(Session var1) throws HibernateException, NamingException {
      double var2;
      if (this.hospitalisationLabo.getHoslabRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.hospitalisationLabo.getHoslabPu() * (double)this.hospitalisationLabo.getHoslabRemise() / 100.0D, this.structureLog.getStrdevise());
         this.hospitalisationLabo.setHoslabPuRem(this.hospitalisationLabo.getHoslabPu() - var2);
         this.hospitalisationLabo.setHoslabRabais(0.0D);
      } else {
         this.hospitalisationLabo.setHoslabPuRem(this.hospitalisationLabo.getHoslabPu());
      }

      this.hospitalisationLabo.setHoslabTotal(this.hospitalisationLabo.getHoslabPuRem() * (double)this.hospitalisationLabo.getHoslabQte());
      if (this.hospitalisationLabo.getHoslabTauxTva() != 0.0F) {
         var2 = this.hospitalisationLabo.getHoslabTotal() * (double)this.hospitalisationLabo.getHoslabTauxTva() / 100.0D;
         this.hospitalisationLabo.setHoslabTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.hospitalisationLabo.setHoslabTaxe(0.0D);
      }

      this.hospitalisationLabo.setHoslabNbCnamgs(0.0F);
      this.hospitalisationLabo.setHoslabValeurCnamgs(0.0D);
      this.hospitalisationLabo.setHoslabPuCnamgs(0.0D);
      this.hospitalisationLabo.setHoslabSocieteHt(0.0D);
      this.hospitalisationLabo.setHoslabSocieteTaxe(0.0D);
      this.hospitalisationLabo.setHoslabAssuranceHt(0.0D);
      this.hospitalisationLabo.setHoslabAssuranceTaxe(0.0D);
      this.hospitalisationLabo.setHoslabComplementaireHt(0.0D);
      this.hospitalisationLabo.setHoslabComplementaireTaxe(0.0D);
      this.hospitalisationLabo.setHoslabPatientHt(0.0D);
      this.hospitalisationLabo.setHoslabPatientTaxe(0.0D);
      this.hospitalisationEntete.setHosIdEmployeur(0L);
      var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      float var8 = 0.0F;
      double var9;
      if (this.hospitalisationEntete.getHosIdSociete() != 0L && this.hospitalisationEntete.getHosFam() != 0L) {
         if (this.patientPec == null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 0, var1);
         }

         if (this.patientPec != null) {
            var2 = this.hospitalisationLabo.getHoslabTotal() * (double)this.patientPec.getPatpecExamenssHospit() / 100.0D;
            if (this.patientPec.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.hospitalisationLabo.setHoslabSocieteHt(var2);
            } else {
               this.hospitalisationLabo.setHoslabSocieteHt(var2 * (double)this.patientPec.getTiers().getTiecoefpvmedical());
               var8 = this.patientPec.getTiers().getTiecoefpvmedical();
            }

            if (this.hospitalisationLabo.getHoslabTauxTva() != 0.0F) {
               var9 = this.hospitalisationLabo.getHoslabSocieteHt() * (double)this.hospitalisationLabo.getHoslabTauxTva() / 100.0D;
               this.hospitalisationLabo.setHoslabSocieteTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      } else if (this.hospitalisationEntete.getHosIdAssurance() != 0L && this.hospitalisationEntete.getHosFam() != 0L) {
         if (this.patientPec == null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 0, var1);
         }

         if (this.patientPec != null) {
            this.var_pecAssurance = true;
            this.hospitalisationEntete.setHosIdEmployeur(this.patientPec.getPatpecIdEmployeur());
            if (this.hospitalisationLabo.getHoslabPuAssurance() == 0.0D) {
               this.hospitalisationLabo.setHoslabPuAssurance(this.hospitalisationLabo.getHoslabPu());
            }

            var4 = this.hospitalisationLabo.getHoslabPuAssurance() * (double)this.hospitalisationLabo.getHoslabQte() * (double)this.patientPec.getPatpecExamenssHospit() / 100.0D;
            if (this.hospitalisationLabo.getHoslabRemise() != 0.0F) {
               var9 = this.utilNombre.myRoundDevise(var4 * (double)this.hospitalisationLabo.getHoslabRemise() / 100.0D, this.structureLog.getStrdevise());
               var4 -= var9;
            }

            if (this.patientPec.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.hospitalisationLabo.setHoslabAssuranceHt(var4);
            } else {
               this.hospitalisationLabo.setHoslabAssuranceHt(var4 * (double)this.patientPec.getTiers().getTiecoefpvmedical());
               var8 = this.patientPec.getTiers().getTiecoefpvmedical();
            }

            if (this.hospitalisationLabo.getHoslabTauxTva() != 0.0F) {
               var9 = this.hospitalisationLabo.getHoslabAssuranceHt() * (double)this.hospitalisationLabo.getHoslabTauxTva() / 100.0D;
               this.hospitalisationLabo.setHoslabAssuranceTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      }

      if (this.hospitalisationEntete.getHosIdComplementaire() != 0L) {
         if (this.patientPecComplementaire == null) {
            this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosComplementaire(), 0, var1);
         }

         if (this.patientPecComplementaire != null) {
            var6 = this.hospitalisationLabo.getHoslabPu() * (double)this.hospitalisationLabo.getHoslabQte() * (double)this.patientPec.getPatpecExamenssHospit() / 100.0D;
            if (this.hospitalisationLabo.getHoslabRemise() != 0.0F) {
               var9 = this.utilNombre.myRoundDevise(var6 * (double)this.hospitalisationLabo.getHoslabRemise() / 100.0D, this.structureLog.getStrdevise());
               var6 -= var9;
            }

            if (this.patientPecComplementaire.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.hospitalisationLabo.setHoslabComplementaireHt(var6);
            } else {
               this.hospitalisationLabo.setHoslabComplementaireHt(var6 * (double)this.patientPecComplementaire.getTiers().getTiecoefpvmedical());
            }

            if (this.hospitalisationLabo.getHoslabTauxTva() != 0.0F) {
               var9 = this.hospitalisationLabo.getHoslabComplementaireHt() * (double)this.hospitalisationLabo.getHoslabTauxTva() / 100.0D;
               this.hospitalisationLabo.setHoslabComplementaireTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      }

      var9 = 0.0D;
      double var11;
      if (var8 != 0.0F && this.produits.getProMajoration() == 0 && this.optionMedical.getCoefMajoration().equals("2")) {
         if (this.hospitalisationLabo.getHoslabRemise() != 0.0F) {
            var11 = this.utilNombre.myRoundDevise(this.hospitalisationLabo.getHoslabPu() * (double)this.hospitalisationLabo.getHoslabRemise() / 100.0D, this.structureLog.getStrdevise());
            this.hospitalisationLabo.setHoslabPuRem((this.hospitalisationLabo.getHoslabPu() - var11) * (double)var8);
         } else {
            this.hospitalisationLabo.setHoslabPuRem(this.hospitalisationLabo.getHoslabPu() * (double)var8);
         }

         this.hospitalisationLabo.setHoslabTotal(this.hospitalisationLabo.getHoslabPuRem() * (double)this.hospitalisationLabo.getHoslabQte());
         if (this.hospitalisationLabo.getHoslabTauxTva() != 0.0F) {
            var11 = this.hospitalisationLabo.getHoslabTotal() * (double)this.hospitalisationLabo.getHoslabTauxTva() / 100.0D;
            this.hospitalisationLabo.setHoslabTaxe(this.utilNombre.myRoundDevise(var11, this.structureLog.getStrdevise()));
         } else {
            this.hospitalisationLabo.setHoslabTaxe(0.0D);
         }
      } else {
         var9 = this.hospitalisationLabo.getHoslabTotal() - (var2 + var4 + var6);
         this.hospitalisationLabo.setHoslabTotal(this.hospitalisationLabo.getHoslabSocieteHt() + this.hospitalisationLabo.getHoslabAssuranceHt() + this.hospitalisationLabo.getHoslabComplementaireHt() + var9);
      }

      var11 = this.hospitalisationLabo.getHoslabTotal() - (this.hospitalisationLabo.getHoslabSocieteHt() + this.hospitalisationLabo.getHoslabAssuranceHt() + this.hospitalisationLabo.getHoslabComplementaireHt());
      if (this.hospitalisationLabo.getHoslabRabais() != 0.0D) {
         this.hospitalisationLabo.setHoslabPatientHt(var11 - this.hospitalisationLabo.getHoslabRabais());
         this.hospitalisationLabo.setHoslabRemise(0.0F);
         if (this.hospitalisationLabo.getHoslabPatientHt() < 0.0D) {
            this.hospitalisationLabo.setHoslabPatientHt(var11);
            this.hospitalisationLabo.setHoslabRabais(0.0D);
         }
      } else {
         this.hospitalisationLabo.setHoslabPatientHt(var11);
      }

      double var13;
      if (this.hospitalisationLabo.getHoslabTauxTva() != 0.0F) {
         var13 = this.hospitalisationLabo.getHoslabPatientHt() * (double)this.hospitalisationLabo.getHoslabTauxTva() / 100.0D;
         this.hospitalisationLabo.setHoslabPatientTaxe(this.utilNombre.myRoundDevise(var13, this.structureLog.getStrdevise()));
      }

      if (var8 != 0.0F && this.produits.getProMajoration() == 0 && this.optionMedical.getCoefMajoration().equals("3")) {
         if (this.hospitalisationLabo.getHoslabRemise() != 0.0F) {
            var13 = this.utilNombre.myRoundDevise(this.hospitalisationLabo.getHoslabPu() * (double)this.hospitalisationLabo.getHoslabRemise() / 100.0D, this.structureLog.getStrdevise());
            this.hospitalisationLabo.setHoslabPuRem((this.hospitalisationLabo.getHoslabPu() - var13) * (double)var8);
         } else {
            this.hospitalisationLabo.setHoslabPuRem(this.hospitalisationLabo.getHoslabPu() * (double)var8);
         }

         this.hospitalisationLabo.setHoslabTotal(this.hospitalisationLabo.getHoslabPuRem() * (double)this.hospitalisationLabo.getHoslabQte());
         var13 = this.hospitalisationLabo.getHoslabAssuranceHt() + this.hospitalisationLabo.getHoslabComplementaireHt() + this.hospitalisationLabo.getHoslabSocieteHt() + this.hospitalisationLabo.getHoslabPatientHt();
         double var15 = this.hospitalisationLabo.getHoslabTotal() - var13;
         if (var15 != 0.0D) {
            if (var4 == 0.0D && var2 != 0.0D) {
               this.hospitalisationLabo.setHoslabSocieteHt(this.hospitalisationLabo.getHoslabSocieteHt() + var15);
            }

            if (var6 != 0.0D) {
               this.hospitalisationLabo.setHoslabComplementaireHt(this.hospitalisationLabo.getHoslabComplementaireHt() + var15);
            }
         }
      }

   }

   public void laboratoireSansCnamgsPrive(Session var1) {
      if (this.tauxCasSocial != 0.0F) {
         this.hospitalisationLabo.setHoslabRemise(this.tauxCasSocial);
      }

      double var2;
      if (this.hospitalisationLabo.getHoslabRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.hospitalisationLabo.getHoslabPu() * (double)this.hospitalisationLabo.getHoslabRemise() / 100.0D, this.structureLog.getStrdevise());
         this.hospitalisationLabo.setHoslabPuRem(this.hospitalisationLabo.getHoslabPu() - var2);
         this.hospitalisationLabo.setHoslabRabais(0.0D);
      } else {
         this.hospitalisationLabo.setHoslabPuRem(this.hospitalisationLabo.getHoslabPu());
      }

      this.hospitalisationLabo.setHoslabTotal(this.hospitalisationLabo.getHoslabPuRem() * (double)this.hospitalisationLabo.getHoslabQte());
      if (this.hospitalisationLabo.getHoslabTauxTva() != 0.0F) {
         var2 = this.hospitalisationLabo.getHoslabTotal() * (double)this.hospitalisationLabo.getHoslabTauxTva() / 100.0D;
         this.hospitalisationLabo.setHoslabTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.hospitalisationLabo.setHoslabTaxe(0.0D);
      }

      this.hospitalisationLabo.setHoslabNbCnamgs(0.0F);
      this.hospitalisationLabo.setHoslabValeurCnamgs(0.0D);
      this.hospitalisationLabo.setHoslabPuCnamgs(0.0D);
      this.hospitalisationLabo.setHoslabSocieteHt(0.0D);
      this.hospitalisationLabo.setHoslabSocieteTaxe(0.0D);
      this.hospitalisationLabo.setHoslabAssuranceHt(0.0D);
      this.hospitalisationLabo.setHoslabAssuranceTaxe(0.0D);
      this.hospitalisationLabo.setHoslabComplementaireHt(0.0D);
      this.hospitalisationLabo.setHoslabComplementaireTaxe(0.0D);
      this.hospitalisationLabo.setHoslabPatientHt(0.0D);
      this.hospitalisationLabo.setHoslabPatientTaxe(0.0D);
      this.hospitalisationEntete.setHosIdEmployeur(0L);
      var2 = this.hospitalisationLabo.getHoslabTotal();
      if (this.hospitalisationLabo.getHoslabRabais() != 0.0D) {
         this.hospitalisationLabo.setHoslabPatientHt(var2 - this.hospitalisationLabo.getHoslabRabais());
         this.hospitalisationLabo.setHoslabRemise(0.0F);
         if (this.hospitalisationLabo.getHoslabPatientHt() < 0.0D) {
            this.hospitalisationLabo.setHoslabPatientHt(var2);
            this.hospitalisationLabo.setHoslabRabais(0.0D);
         }
      } else {
         this.hospitalisationLabo.setHoslabPatientHt(var2);
      }

      if (this.hospitalisationLabo.getHoslabTaxe() != 0.0D) {
         double var4 = this.hospitalisationLabo.getHoslabPatientHt() * (double)this.hospitalisationLabo.getHoslabTauxTva() / 100.0D;
         this.hospitalisationLabo.setHoslabPatientTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
      } else {
         this.hospitalisationLabo.setHoslabPatientTaxe(0.0D);
      }

   }

   public void laboratoireAvecCnamgsPrive(Session var1) throws HibernateException, NamingException {
      if (this.hospitalisationLabo.getHoslabPuCnamgs() > this.hospitalisationLabo.getHoslabPu()) {
         this.hospitalisationLabo.setHoslabPu(this.hospitalisationLabo.getHoslabPuCnamgs());
      }

      double var2;
      double var4;
      if (this.hospitalisationLabo.getHoslabRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.hospitalisationLabo.getHoslabPu() * (double)this.hospitalisationLabo.getHoslabRemise() / 100.0D, this.structureLog.getStrdevise());
         this.hospitalisationLabo.setHoslabPuRem(this.hospitalisationLabo.getHoslabPu() - var2);
         var4 = this.utilNombre.myRoundDevise(this.hospitalisationLabo.getHoslabPuCnamgs() * (double)this.hospitalisationLabo.getHoslabRemise() / 100.0D, this.structureLog.getStrdevise());
         this.hospitalisationLabo.setHoslabPuCnamgs(this.hospitalisationLabo.getHoslabPuCnamgs() - var4);
         this.hospitalisationLabo.setHoslabRabais(0.0D);
      } else {
         this.hospitalisationLabo.setHoslabPuRem(this.hospitalisationLabo.getHoslabPu());
      }

      this.hospitalisationLabo.setHoslabTotal(this.hospitalisationLabo.getHoslabPuRem() * (double)this.hospitalisationLabo.getHoslabQte());
      if (this.hospitalisationLabo.getHoslabTauxTva() != 0.0F) {
         var2 = this.hospitalisationLabo.getHoslabTotal() * (double)this.hospitalisationLabo.getHoslabTauxTva() / 100.0D;
         this.hospitalisationLabo.setHoslabTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.hospitalisationLabo.setHoslabTaxe(0.0D);
      }

      this.hospitalisationLabo.setHoslabSocieteHt(0.0D);
      this.hospitalisationLabo.setHoslabSocieteTaxe(0.0D);
      this.hospitalisationLabo.setHoslabAssuranceHt(0.0D);
      this.hospitalisationLabo.setHoslabAssuranceTaxe(0.0D);
      this.hospitalisationLabo.setHoslabComplementaireHt(0.0D);
      this.hospitalisationLabo.setHoslabComplementaireTaxe(0.0D);
      this.hospitalisationLabo.setHoslabPatientHt(0.0D);
      this.hospitalisationLabo.setHoslabPatientTaxe(0.0D);
      this.hospitalisationEntete.setHosIdEmployeur(0L);
      this.hospitalisationLabo.setHoslabAssuranceHt(this.hospitalisationLabo.getHoslabPuCnamgs() * (double)this.hospitalisationLabo.getHoslabQte() * (double)this.var_pecCnamgs / 100.0D);
      if (this.hospitalisationLabo.getHoslabTauxTva() != 0.0F) {
         var2 = this.hospitalisationLabo.getHoslabAssuranceHt() * (double)this.hospitalisationLabo.getHoslabTauxTva() / 100.0D;
         this.hospitalisationLabo.setHoslabAssuranceTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      }

      var2 = this.hospitalisationLabo.getHoslabTotal() - this.hospitalisationLabo.getHoslabAssuranceHt();
      if (this.hospitalisationLabo.getHoslabRabais() != 0.0D) {
         this.hospitalisationLabo.setHoslabPatientHt(var2 - this.hospitalisationLabo.getHoslabRabais());
         this.hospitalisationLabo.setHoslabRemise(0.0F);
         if (this.hospitalisationLabo.getHoslabPatientHt() < 0.0D) {
            this.hospitalisationLabo.setHoslabPatientHt(var2);
            this.hospitalisationLabo.setHoslabRabais(0.0D);
         }
      } else {
         this.hospitalisationLabo.setHoslabPatientHt(var2);
      }

      if (this.hospitalisationLabo.getHoslabTauxTva() != 0.0F) {
         var4 = this.hospitalisationLabo.getHoslabPatientHt() * (double)this.hospitalisationLabo.getHoslabTauxTva() / 100.0D;
         this.hospitalisationLabo.setHoslabPatientTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
      }

   }

   public void selectionPrestation() throws HibernateException, NamingException {
      if (this.dataModelPrest.isRowAvailable()) {
         this.hospitalisationPrest = (HospitalisationPrest)this.dataModelPrest.getRowData();
         if (this.hospitalisationPrest.getHosprtProduit() != null && !this.hospitalisationPrest.getHosprtProduit().isEmpty()) {
            this.produits = this.produitsMedicDao.chargeProduit(this.hospitalisationPrest.getHosprtProduit(), (Session)null);
         } else {
            this.produits = null;
         }

         this.afficheButtPrest = true;
         this.validePrest = true;
      }

   }

   public void ajouterPrestation() {
      this.mesSejoursItems.clear();
      if (this.lesSejours.size() != 0) {
         int var1;
         for(var1 = 0; var1 < this.lesSejours.size(); ++var1) {
            if (((HospitalisationSejour)this.lesSejours.get(var1)).getHossejDateSortie() == null) {
               this.mesSejoursItems.add(new SelectItem(((HospitalisationSejour)this.lesSejours.get(var1)).getHossejId(), ((HospitalisationSejour)this.lesSejours.get(var1)).getHossejService()));
            }
         }

         this.produits = new Produits();
         this.hospitalisationPrest = new HospitalisationPrest();
         if (this.lesPrests.size() != 0) {
            var1 = this.lesPrests.size() - 1;
            this.hospitalisationPrest.setHosprtIdSejour(((HospitalisationPrest)this.lesPrests.get(var1)).getHosprtIdSejour());
            this.hospitalisationPrest.setHosprtIdMedecin(((HospitalisationPrest)this.lesPrests.get(var1)).getHosprtIdMedecin());
            this.hospitalisationPrest.setHosprtMedecin(((HospitalisationPrest)this.lesPrests.get(var1)).getHosprtMedecin());
            this.hospitalisationPrest.setHosprtService(((HospitalisationPrest)this.lesPrests.get(var1)).getHosprtService());
         } else if (this.lesSejours.size() != 0) {
            var1 = this.lesSejours.size() - 1;
            this.hospitalisationPrest.setHosprtIdSejour(((HospitalisationSejour)this.lesSejours.get(var1)).getHossejId());
            this.hospitalisationPrest.setHosprtService(((HospitalisationSejour)this.lesSejours.get(var1)).getHossejService());
         }

         this.validePrest = false;
         this.afficheButtPrest = false;
         this.showModalPanelPrest = true;
      }

   }

   public void modifierPrestation() throws HibernateException, NamingException {
      if (this.hospitalisationPrest != null) {
         this.mesSejoursItems.clear();
         if (this.lesSejours.size() != 0) {
            for(int var1 = 0; var1 < this.lesSejours.size(); ++var1) {
               if (((HospitalisationSejour)this.lesSejours.get(var1)).getHossejDateSortie() == null) {
                  this.mesSejoursItems.add(new SelectItem(((HospitalisationSejour)this.lesSejours.get(var1)).getHossejId(), ((HospitalisationSejour)this.lesSejours.get(var1)).getHossejService()));
               }
            }

            this.calculMedecinPrest();
            this.verifValidePrestation();
            this.showModalPanelPrest = true;
         }
      }

   }

   public void supprimerPrestation() throws HibernateException, NamingException {
      if (this.hospitalisationPrest != null) {
         this.hospitalisationPrestDao.delete(this.hospitalisationPrest);
         this.lesPrests.remove(this.hospitalisationPrest);
         this.dataModelPrest.setWrappedData(this.lesPrests);
         this.afficheButtPrest = false;
      }

   }

   public void avoirPrestation() throws HibernateException, NamingException {
      if (this.hospitalisationPrest != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            HospitalisationPrest var3 = new HospitalisationPrest();
            var3.setHospitalisationEntete(this.hospitalisationEntete);
            var3.setHosprtAssuranceHt(this.hospitalisationPrest.getHosprtAssuranceHt() * -1.0D);
            var3.setHosprtAssuranceTaxe(this.hospitalisationPrest.getHosprtAssuranceTaxe() * -1.0D);
            var3.setHosprtCodeTva(this.hospitalisationPrest.getHosprtCodeTva());
            var3.setHosprtCoef(this.hospitalisationPrest.getHosprtCoef());
            var3.setHosprtComplementaireHt(this.hospitalisationPrest.getHosprtComplementaireHt() * -1.0D);
            var3.setHosprtComplementaireTaxe(this.hospitalisationPrest.getHosprtComplementaireTaxe() * -1.0D);
            var3.setHosprtIdMedecin(this.hospitalisationPrest.getHosprtIdMedecin());
            var3.setHosprtIdSejour(this.hospitalisationPrest.getHosprtIdSejour());
            var3.setHosprtLettre(this.hospitalisationPrest.getHosprtLettre());
            var3.setHosprtLibelle(this.hospitalisationPrest.getHosprtLibelle());
            var3.setHosprtMedecin(this.hospitalisationPrest.getHosprtMedecin());
            var3.setHosprtNb(this.hospitalisationPrest.getHosprtNb());
            var3.setHosprtNbCnamgs(this.hospitalisationPrest.getHosprtNbCnamgs());
            var3.setHosprtPatientHt(this.hospitalisationPrest.getHosprtPatientHt() * -1.0D);
            var3.setHosprtPatientTaxe(this.hospitalisationPrest.getHosprtPatientTaxe() * -1.0D);
            var3.setHosprtProduit(this.hospitalisationPrest.getHosprtProduit());
            var3.setHosprtPu(this.hospitalisationPrest.getHosprtPu());
            var3.setHosprtPuAssurance(this.hospitalisationPrest.getHosprtPuAssurance());
            var3.setHosprtPuCnamgs(this.hospitalisationPrest.getHosprtPuCnamgs());
            var3.setHosprtPuRem(this.hospitalisationPrest.getHosprtPuRem());
            var3.setHosprtQte(this.hospitalisationPrest.getHosprtQte() * -1.0F);
            var3.setHosprtRegPatient(0.0D);
            var3.setHosprtRegTiers(0.0D);
            var3.setHosprtRemise(this.hospitalisationPrest.getHosprtRemise());
            var3.setHosprtService(this.hospitalisationPrest.getHosprtService());
            var3.setHosprtSocieteHt(this.hospitalisationPrest.getHosprtSocieteHt() * -1.0D);
            var3.setHosprtSocieteTaxe(this.hospitalisationPrest.getHosprtSocieteTaxe() * -1.0D);
            var3.setHosprtTauxTva(this.hospitalisationPrest.getHosprtTauxTva());
            var3.setHosprtTaxe(this.hospitalisationPrest.getHosprtTaxe() * -1.0D);
            var3.setHosprtTotal(this.hospitalisationPrest.getHosprtTotal() * -1.0D);
            var3.setHosprtValeur(this.hospitalisationPrest.getHosprtValeur());
            var3.setHosprtValeurCnamgs(this.hospitalisationPrest.getHosprtValeurCnamgs());
            this.hospitalisationPrest = new HospitalisationPrest();
            this.hospitalisationPrest = var3;
            this.hospitalisationPrest = this.hospitalisationPrestDao.insert(this.hospitalisationPrest, var1);
            this.lesPrests.add(this.hospitalisationPrest);
            this.dataModelPrest.setWrappedData(this.lesPrests);
            this.calculTotaux();
            this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
            double var4 = this.hospitalisationPrest.getHosprtPatientHt() + this.hospitalisationPrest.getHosprtPatientTaxe();
            if (var4 != 0.0D) {
               this.majBonencaissementAnnulation(Math.abs(var4), new Date(), var1);
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

         this.ajouterPrestation();
      }

   }

   public void annulationPrestation() throws NamingException {
      if (this.hospitalisationPrest != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            HospitalisationPrest var3 = new HospitalisationPrest();
            var3.setHospitalisationEntete(this.hospitalisationEntete);
            var3.setHosprtAssuranceHt(this.hospitalisationPrest.getHosprtAssuranceHt() * -1.0D);
            var3.setHosprtAssuranceTaxe(this.hospitalisationPrest.getHosprtAssuranceTaxe() * -1.0D);
            var3.setHosprtCodeTva(this.hospitalisationPrest.getHosprtCodeTva());
            var3.setHosprtCoef(this.hospitalisationPrest.getHosprtCoef());
            var3.setHosprtComplementaireHt(this.hospitalisationPrest.getHosprtComplementaireHt() * -1.0D);
            var3.setHosprtComplementaireTaxe(this.hospitalisationPrest.getHosprtComplementaireTaxe() * -1.0D);
            var3.setHosprtIdMedecin(this.hospitalisationPrest.getHosprtIdMedecin());
            var3.setHosprtIdSejour(this.hospitalisationPrest.getHosprtIdSejour());
            var3.setHosprtLettre(this.hospitalisationPrest.getHosprtLettre());
            var3.setHosprtLibelle(this.hospitalisationPrest.getHosprtLibelle());
            var3.setHosprtMedecin(this.hospitalisationPrest.getHosprtMedecin());
            var3.setHosprtNb(this.hospitalisationPrest.getHosprtNb());
            var3.setHosprtNbCnamgs(this.hospitalisationPrest.getHosprtNbCnamgs());
            var3.setHosprtPatientHt(this.hospitalisationPrest.getHosprtPatientHt() * -1.0D);
            var3.setHosprtPatientTaxe(this.hospitalisationPrest.getHosprtPatientTaxe() * -1.0D);
            var3.setHosprtProduit(this.hospitalisationPrest.getHosprtProduit());
            var3.setHosprtPu(this.hospitalisationPrest.getHosprtPu());
            var3.setHosprtPuAssurance(this.hospitalisationPrest.getHosprtPuAssurance());
            var3.setHosprtPuCnamgs(this.hospitalisationPrest.getHosprtPuCnamgs());
            var3.setHosprtPuRem(this.hospitalisationPrest.getHosprtPuRem());
            var3.setHosprtQte(this.hospitalisationPrest.getHosprtQte() * -1.0F);
            var3.setHosprtRegPatient(0.0D);
            var3.setHosprtRegTiers(0.0D);
            var3.setHosprtRemise(this.hospitalisationPrest.getHosprtRemise());
            var3.setHosprtService(this.hospitalisationPrest.getHosprtService());
            var3.setHosprtSocieteHt(this.hospitalisationPrest.getHosprtSocieteHt() * -1.0D);
            var3.setHosprtSocieteTaxe(this.hospitalisationPrest.getHosprtSocieteTaxe() * -1.0D);
            var3.setHosprtTauxTva(this.hospitalisationPrest.getHosprtTauxTva());
            var3.setHosprtTaxe(this.hospitalisationPrest.getHosprtTaxe() * -1.0D);
            var3.setHosprtTotal(this.hospitalisationPrest.getHosprtTotal() * -1.0D);
            var3.setHosprtValeur(this.hospitalisationPrest.getHosprtValeur());
            var3.setHosprtValeurCnamgs(this.hospitalisationPrest.getHosprtValeurCnamgs());
            this.hospitalisationPrest = new HospitalisationPrest();
            this.hospitalisationPrest = var3;
            this.hospitalisationPrest = this.hospitalisationPrestDao.insert(this.hospitalisationPrest, var1);
            this.lesPrests.add(this.hospitalisationPrest);
            this.dataModelPrest.setWrappedData(this.lesPrests);
            this.calculTotaux();
            this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.ajouterPrestation();
      }

   }

   public void fermerPrestation() {
      this.hospitalisationPrest.setHosprtProduit("");
      this.hospitalisationPrest.setHosprtLibelle("");
      this.showModalPanelPrest = false;
   }

   public void savePrestation() throws HibernateException, NamingException {
      if (this.hospitalisationPrest.getHosprtQte() != 0.0F) {
         if (this.hospitalisationPrest != null) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
            Transaction var2 = null;

            try {
               var2 = var1.beginTransaction();
               this.tarifPatient(var1);
               this.calculPrixPrestation(var1);
               if (this.hospitalisationPrest.getHosprtIdMedecin() != 0L) {
                  new Users();
                  Users var3 = this.usersDao.selectUserD(this.hospitalisationPrest.getHosprtIdMedecin(), var1);
                  if (var3 != null) {
                     this.hospitalisationPrest.setHosprtIdMedecin(var3.getUsrid());
                     this.hospitalisationPrest.setHosprtMedecin(var3.getUsrPatronyme());
                  } else {
                     this.hospitalisationPrest.setHosprtIdMedecin(0L);
                     this.hospitalisationPrest.setHosprtMedecin("");
                  }
               } else {
                  this.hospitalisationPrest.setHosprtIdMedecin(0L);
                  this.hospitalisationPrest.setHosprtMedecin("");
               }

               if (this.hospitalisationPrest.getHosprtId() == 0L) {
                  this.hospitalisationPrest.setHospitalisationEntete(this.hospitalisationEntete);
                  this.hospitalisationPrest.setHosprtDateCreat(new Date());
                  this.hospitalisationPrest.setHosprtUserCreat(this.usersLog.getUsrid());
                  this.hospitalisationPrest = this.hospitalisationPrestDao.insert(this.hospitalisationPrest, var1);
                  this.lesPrests.add(this.hospitalisationPrest);
                  this.dataModelPrest.setWrappedData(this.lesPrests);
               } else {
                  this.hospitalisationPrest.setHosprtDateModif(new Date());
                  this.hospitalisationPrest.setHosprtUserModif(this.usersLog.getUsrid());
                  this.hospitalisationPrest = this.hospitalisationPrestDao.modif(this.hospitalisationPrest, var1);
               }

               this.calculTotaux();
               this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
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

         this.showModalPanelPrest = false;
      }

   }

   public void verifValidePrestation() {
      this.validePrest = false;
      if (this.hospitalisationPrest.getHosprtIdSejour() != 0L) {
         if (this.optionMedical.getMedecinHP().equals("0")) {
            if (this.hospitalisationPrest.getHosprtIdMedecin() != 0L && this.hospitalisationPrest.getHosprtProduit() != null && !this.hospitalisationPrest.getHosprtProduit().isEmpty()) {
               this.validePrest = true;
            }
         } else if (this.hospitalisationPrest.getHosprtProduit() != null && !this.hospitalisationPrest.getHosprtProduit().isEmpty()) {
            this.validePrest = true;
         }
      }

   }

   public void recherchePrestation() throws HibernateException, NamingException {
      this.extDTableProduits = new HtmlExtendedDataTable();
      if (this.simpleSelectionProduits == null) {
         this.simpleSelectionProduits.clear();
      }

      this.choixPanenProd = 4;
      if (this.hospitalisationPrest.getHosprtProduit() != null && !this.hospitalisationPrest.getHosprtProduit().isEmpty()) {
         this.lesProduits.clear();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsVtes");
         this.lesProduits = this.produitsMedicDao.verifProduitsMedicaux(this.hospitalisationPrest.getHosprtProduit(), "1107", var1);
         this.utilInitHibernate.closeSession();
         if (this.lesProduits.size() == 1) {
            this.produits = (Produits)this.lesProduits.get(0);
            this.validerPrestation();
         } else if (this.lesProduits.size() > 1) {
            this.produits = new Produits();
            this.showModalPanelProduits = true;
            this.datamodelProduits.setWrappedData(this.lesProduits);
         } else {
            this.annulerPrestation();
         }
      }

   }

   public void selectionProduitPrt() {
      if (this.datamodelProduits.isRowAvailable()) {
         this.produits = (Produits)this.datamodelProduits.getRowData();
      }

   }

   public void annulerPrestation() {
      this.produits = null;
      this.showModalPanelProduits = false;
   }

   public void validerPrestation() throws HibernateException, NamingException {
      if (this.produits != null) {
         this.mesServicesFacturesPrest.clear();
         if (this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty()) {
            if (!this.produits.getProActivite().contains("#")) {
               this.mesServicesFacturesPrest.add(new SelectItem(this.produits.getProActivite()));
            } else {
               String[] var1 = this.produits.getProActivite().split("#");
               int var2 = var1.length;

               for(int var3 = 0; var3 < var2; ++var3) {
                  this.mesServicesFacturesPrest.add(new SelectItem(var1[var3]));
               }
            }
         } else {
            this.mesServicesFacturesPrest.add(new SelectItem(((HospitalisationSejour)this.lesSejours.get(this.lesSejours.size() - 1)).getHossejService()));
         }

         this.hospitalisationPrest.setHosprtProduit(this.produits.getProCode());
         this.hospitalisationPrest.setHosprtLibelle(this.produits.getProLibClient());
         Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsMed");
         this.calculPrixPrestation(var4);
         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelProduits = false;
   }

   public void calculPrixPrestation(Session var1) throws HibernateException, NamingException {
      float var2 = 1.0F;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = this.hospitalisationPrest.getHosprtPu();
      double var11 = this.hospitalisationPrest.getHosprtPuCnamgs();
      double var13 = this.hospitalisationPrest.getHosprtPuAssurance();
      boolean var15 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         var15 = true;
      }

      this.produits = this.produitsMedicDao.chargeProduit(this.hospitalisationPrest.getHosprtProduit(), var1);
      if (this.produits != null) {
         this.hospitalisationPrest.setHosprtProduit(this.produits.getProCode());
         this.hospitalisationPrest.setHosprtLibelle(this.produits.getProLibClient());
         this.hospitalisationPrest.setHosprtLettre(this.produits.getProLettre());
         if (this.produits.getProLettre() != null && !this.produits.getProLettre().isEmpty()) {
            this.hospitalisationPrest.setHosprtLettre(this.produits.getProLettre());
         } else {
            this.hospitalisationPrest.setHosprtLettre("");
            this.hospitalisationPrest.setHosprtNb(0.0F);
            this.hospitalisationPrest.setHosprtNbCnamgs(0.0F);
         }

         this.hospitalisationPrest.setHosprtQte(1.0F);
         this.hospitalisationPrest.setHosprtCodeTva(this.produits.getProVteTva());
         this.hospitalisationPrest.setHosprtTauxTva(0.0F);
         if (this.hospitalisationPrest.getHosprtCodeTva() != null && !this.hospitalisationPrest.getHosprtCodeTva().isEmpty()) {
            this.taxesMedical = this.taxesMedicalDao.selectTva(this.exercicesVentes.getExevteId(), this.hospitalisationPrest.getHosprtCodeTva(), var1);
            if (this.taxesMedical != null) {
               this.hospitalisationPrest.setHosprtTauxTva(this.taxesMedical.getTaxvteTaux());
            }
         }

         String var16 = this.hospitalisationEntete.getLibelleFamille();
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
            this.hospitalisationPrest.setHosprtNb(this.produitsTarif.getProtarNb());
            this.hospitalisationPrest.setHosprtNbCnamgs(this.produitsTarif.getProtarNbCnamgs());
            this.hospitalisationPrest.setHosprtValeur(this.produitsTarif.getProtarValeur());
            this.hospitalisationPrest.setHosprtValeurCnamgs(this.produitsTarif.getProtarValeurCnamgs());
            if (var2 == 0.0F) {
               var2 = 1.0F;
               if (this.lesCategoriesList.size() != 0) {
                  for(var17 = 0; var17 < this.lesCategoriesList.size(); ++var17) {
                     if (((ObjetCategories)this.lesCategoriesList.get(var17)).getLibelle_FR().equals(this.hospitalisationEntete.getLibelleFamille())) {
                        var2 = ((ObjetCategories)this.lesCategoriesList.get(var17)).getCoef();
                        break;
                     }
                  }
               }
            }

            this.hospitalisationPrest.setHosprtCoef(var2);
            if (var9 != 0.0D) {
               var3 = var9;
            }

            this.hospitalisationPrest.setHosprtPu(var3);
            if (var11 != 0.0D) {
               var5 = var11;
            }

            this.hospitalisationPrest.setHosprtPuCnamgs(var5);
            if (var13 != 0.0D) {
               var7 = var13;
            }

            this.hospitalisationPrest.setHosprtPuAssurance(var7);
            if (this.hospitalisationEntete.getHosFam() >= 1L) {
               this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 0, var1);
               if (this.patientPec != null) {
                  this.conventionMedical = this.conventionMedicalDao.trouveConvention(this.patientPec.getTiers().getTieid(), this.hospitalisationPrest.getHosprtProduit(), var1);
                  if (this.conventionMedical != null) {
                     this.hospitalisationPrest.setHosprtPuAssurance(this.conventionMedical.getCvnValeur());
                     if (this.conventionMedical.getCvnValeurOrigine() != 0.0D) {
                        this.hospitalisationPrest.setHosprtPu(this.conventionMedical.getCvnValeurOrigine());
                     }
                  }
               }
            }

            if (this.hospitalisationPrest.getHosprtQte() == 0.0F) {
               this.hospitalisationPrest.setHosprtQte(1.0F);
            }
         } else {
            this.hospitalisationPrest.setHosprtLettre("");
            this.hospitalisationPrest.setHosprtNb(0.0F);
            this.hospitalisationPrest.setHosprtNbCnamgs(0.0F);
            this.hospitalisationPrest.setHosprtCoef(0.0F);
            this.hospitalisationPrest.setHosprtValeur(0.0D);
            this.hospitalisationPrest.setHosprtValeurCnamgs(0.0D);
            this.hospitalisationPrest.setHosprtPu(var9);
            this.hospitalisationPrest.setHosprtPuCnamgs(var11);
            this.hospitalisationPrest.setHosprtPuAssurance(var13);
            if (this.hospitalisationPrest.getHosprtQte() == 0.0F) {
               this.hospitalisationPrest.setHosprtQte(1.0F);
            }
         }
      } else {
         this.hospitalisationPrest.setHosprtLettre("");
         this.hospitalisationPrest.setHosprtNb(0.0F);
         this.hospitalisationPrest.setHosprtNbCnamgs(0.0F);
         this.hospitalisationPrest.setHosprtCoef(0.0F);
         this.hospitalisationPrest.setHosprtValeur(0.0D);
         this.hospitalisationPrest.setHosprtValeurCnamgs(0.0D);
         this.hospitalisationPrest.setHosprtPu(var9);
         this.hospitalisationPrest.setHosprtPuCnamgs(var11);
         this.hospitalisationPrest.setHosprtPuAssurance(var13);
         if (this.hospitalisationPrest.getHosprtQte() == 0.0F) {
            this.hospitalisationPrest.setHosprtQte(1.0F);
         }
      }

      if (this.var_pecCnamgs != 0.0F) {
         this.prestationAvecCnamgsPrive(var1);
      } else if (this.hospitalisationEntete.getHosFam() != 0L && this.hospitalisationEntete.getHosFam() != -1L) {
         this.prestationSansCnamgsAssure(var1);
      } else {
         this.prestationSansCnamgsPrive(var1);
      }

      if (var15) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void prestationSansCnamgsAssure(Session var1) throws HibernateException, NamingException {
      double var2;
      if (this.hospitalisationPrest.getHosprtRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.hospitalisationPrest.getHosprtPu() * (double)this.hospitalisationPrest.getHosprtRemise() / 100.0D, this.structureLog.getStrdevise());
         this.hospitalisationPrest.setHosprtPuRem(this.hospitalisationPrest.getHosprtPu() - var2);
         this.hospitalisationPrest.setHosprtRabais(0.0D);
      } else {
         this.hospitalisationPrest.setHosprtPuRem(this.hospitalisationPrest.getHosprtPu());
      }

      this.hospitalisationPrest.setHosprtTotal(this.hospitalisationPrest.getHosprtPuRem() * (double)this.hospitalisationPrest.getHosprtQte());
      if (this.hospitalisationPrest.getHosprtTauxTva() != 0.0F) {
         var2 = this.hospitalisationPrest.getHosprtTotal() * (double)this.hospitalisationPrest.getHosprtTauxTva() / 100.0D;
         this.hospitalisationPrest.setHosprtTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.hospitalisationPrest.setHosprtTaxe(0.0D);
      }

      this.hospitalisationPrest.setHosprtNbCnamgs(0.0F);
      this.hospitalisationPrest.setHosprtValeurCnamgs(0.0D);
      this.hospitalisationPrest.setHosprtPuCnamgs(0.0D);
      this.hospitalisationPrest.setHosprtSocieteHt(0.0D);
      this.hospitalisationPrest.setHosprtSocieteTaxe(0.0D);
      this.hospitalisationPrest.setHosprtAssuranceHt(0.0D);
      this.hospitalisationPrest.setHosprtAssuranceTaxe(0.0D);
      this.hospitalisationPrest.setHosprtComplementaireHt(0.0D);
      this.hospitalisationPrest.setHosprtComplementaireTaxe(0.0D);
      this.hospitalisationPrest.setHosprtPatientHt(0.0D);
      this.hospitalisationPrest.setHosprtPatientTaxe(0.0D);
      this.hospitalisationEntete.setHosIdEmployeur(0L);
      var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      float var8 = 0.0F;
      double var9;
      if (this.hospitalisationEntete.getHosIdSociete() != 0L && this.hospitalisationEntete.getHosFam() != 0L) {
         if (this.patientPec == null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 0, var1);
         }

         if (this.patientPec != null) {
            var2 = this.hospitalisationPrest.getHosprtTotal() * (double)this.patientPec.getPatpecPrestations() / 100.0D;
            if (this.patientPec.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.hospitalisationPrest.setHosprtSocieteHt(var2);
            } else {
               this.hospitalisationPrest.setHosprtSocieteHt(var2 * (double)this.patientPec.getTiers().getTiecoefpvmedical());
               var8 = this.patientPec.getTiers().getTiecoefpvmedical();
            }

            if (this.hospitalisationPrest.getHosprtTauxTva() != 0.0F) {
               var9 = this.hospitalisationPrest.getHosprtSocieteHt() * (double)this.hospitalisationPrest.getHosprtTauxTva() / 100.0D;
               this.hospitalisationPrest.setHosprtSocieteTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      } else if (this.hospitalisationEntete.getHosIdAssurance() != 0L && this.hospitalisationEntete.getHosFam() != 0L) {
         if (this.patientPec == null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 0, var1);
         }

         if (this.patientPec != null) {
            this.var_pecAssurance = true;
            this.hospitalisationEntete.setHosIdEmployeur(this.patientPec.getPatpecIdEmployeur());
            if (this.hospitalisationPrest.getHosprtPuAssurance() == 0.0D) {
               this.hospitalisationPrest.setHosprtPuAssurance(this.hospitalisationPrest.getHosprtPu());
            }

            var4 = this.hospitalisationPrest.getHosprtPuAssurance() * (double)this.hospitalisationPrest.getHosprtQte() * (double)this.patientPec.getPatpecPrestations() / 100.0D;
            if (this.hospitalisationPrest.getHosprtRemise() != 0.0F) {
               var9 = this.utilNombre.myRoundDevise(var4 * (double)this.hospitalisationPrest.getHosprtRemise() / 100.0D, this.structureLog.getStrdevise());
               var4 -= var9;
            }

            if (this.patientPec.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.hospitalisationPrest.setHosprtAssuranceHt(var4);
            } else {
               this.hospitalisationPrest.setHosprtAssuranceHt(var4 * (double)this.patientPec.getTiers().getTiecoefpvmedical());
               var8 = this.patientPec.getTiers().getTiecoefpvmedical();
            }

            if (this.hospitalisationPrest.getHosprtTauxTva() != 0.0F) {
               var9 = this.hospitalisationPrest.getHosprtAssuranceHt() * (double)this.hospitalisationPrest.getHosprtTauxTva() / 100.0D;
               this.hospitalisationPrest.setHosprtAssuranceTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      }

      if (this.hospitalisationEntete.getHosIdComplementaire() != 0L) {
         if (this.patientPecComplementaire == null) {
            this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosComplementaire(), 0, var1);
         }

         if (this.patientPecComplementaire != null) {
            var6 = this.hospitalisationPrest.getHosprtPu() * (double)this.hospitalisationPrest.getHosprtQte() * (double)this.patientPec.getPatpecPrestations() / 100.0D;
            if (this.hospitalisationPrest.getHosprtRemise() != 0.0F) {
               var9 = this.utilNombre.myRoundDevise(var6 * (double)this.hospitalisationPrest.getHosprtRemise() / 100.0D, this.structureLog.getStrdevise());
               var6 -= var9;
            }

            if (this.patientPecComplementaire.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.hospitalisationPrest.setHosprtComplementaireHt(var6);
            } else {
               this.hospitalisationPrest.setHosprtComplementaireHt(var6 * (double)this.patientPecComplementaire.getTiers().getTiecoefpvmedical());
            }

            if (this.hospitalisationPrest.getHosprtTauxTva() != 0.0F) {
               var9 = this.hospitalisationPrest.getHosprtComplementaireHt() * (double)this.hospitalisationPrest.getHosprtTauxTva() / 100.0D;
               this.hospitalisationPrest.setHosprtComplementaireTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      }

      var9 = 0.0D;
      double var11;
      if (var8 != 0.0F && this.produits.getProMajoration() == 0 && this.optionMedical.getCoefMajoration().equals("2")) {
         if (this.hospitalisationPrest.getHosprtRemise() != 0.0F) {
            var11 = this.utilNombre.myRoundDevise(this.hospitalisationPrest.getHosprtPu() * (double)this.hospitalisationPrest.getHosprtRemise() / 100.0D, this.structureLog.getStrdevise());
            this.hospitalisationPrest.setHosprtPuRem((this.hospitalisationPrest.getHosprtPu() - var11) * (double)var8);
         } else {
            this.hospitalisationPrest.setHosprtPuRem(this.hospitalisationPrest.getHosprtPu() * (double)var8);
         }

         this.hospitalisationPrest.setHosprtTotal(this.hospitalisationPrest.getHosprtPuRem() * (double)this.hospitalisationPrest.getHosprtQte());
         if (this.hospitalisationPrest.getHosprtTauxTva() != 0.0F) {
            var11 = this.hospitalisationPrest.getHosprtTotal() * (double)this.hospitalisationPrest.getHosprtTauxTva() / 100.0D;
            this.hospitalisationPrest.setHosprtTaxe(this.utilNombre.myRoundDevise(var11, this.structureLog.getStrdevise()));
         } else {
            this.hospitalisationPrest.setHosprtTaxe(0.0D);
         }
      } else {
         var9 = this.hospitalisationPrest.getHosprtTotal() - (var2 + var4 + var6);
         this.hospitalisationPrest.setHosprtTotal(this.hospitalisationPrest.getHosprtSocieteHt() + this.hospitalisationPrest.getHosprtAssuranceHt() + this.hospitalisationPrest.getHosprtComplementaireHt() + var9);
      }

      var11 = this.hospitalisationPrest.getHosprtTotal() - (this.hospitalisationPrest.getHosprtSocieteHt() + this.hospitalisationPrest.getHosprtAssuranceHt() + this.hospitalisationPrest.getHosprtComplementaireHt());
      if (this.hospitalisationPrest.getHosprtRabais() != 0.0D) {
         this.hospitalisationPrest.setHosprtPatientHt(var11 - this.hospitalisationPrest.getHosprtRabais());
         this.hospitalisationPrest.setHosprtRemise(0.0F);
         if (this.hospitalisationPrest.getHosprtPatientHt() < 0.0D) {
            this.hospitalisationPrest.setHosprtPatientHt(var11);
            this.hospitalisationPrest.setHosprtRabais(0.0D);
         }
      } else {
         this.hospitalisationPrest.setHosprtPatientHt(var11);
      }

      double var13;
      if (this.hospitalisationPrest.getHosprtTauxTva() != 0.0F) {
         var13 = this.hospitalisationPrest.getHosprtPatientHt() * (double)this.hospitalisationPrest.getHosprtTauxTva() / 100.0D;
         this.hospitalisationPrest.setHosprtPatientTaxe(this.utilNombre.myRoundDevise(var13, this.structureLog.getStrdevise()));
      }

      if (var8 != 0.0F && this.produits.getProMajoration() == 0 && this.optionMedical.getCoefMajoration().equals("3")) {
         if (this.hospitalisationPrest.getHosprtRemise() != 0.0F) {
            var13 = this.utilNombre.myRoundDevise(this.hospitalisationPrest.getHosprtPu() * (double)this.hospitalisationPrest.getHosprtRemise() / 100.0D, this.structureLog.getStrdevise());
            this.hospitalisationPrest.setHosprtPuRem((this.hospitalisationPrest.getHosprtPu() - var13) * (double)var8);
         } else {
            this.hospitalisationPrest.setHosprtPuRem(this.hospitalisationPrest.getHosprtPu() * (double)var8);
         }

         this.hospitalisationPrest.setHosprtTotal(this.hospitalisationPrest.getHosprtPuRem() * (double)this.hospitalisationPrest.getHosprtQte());
         var13 = this.hospitalisationPrest.getHosprtAssuranceHt() + this.hospitalisationPrest.getHosprtComplementaireHt() + this.hospitalisationPrest.getHosprtSocieteHt() + this.hospitalisationPrest.getHosprtPatientHt();
         double var15 = this.hospitalisationPrest.getHosprtTotal() - var13;
         if (var15 != 0.0D) {
            if (var4 == 0.0D && var2 != 0.0D) {
               this.hospitalisationPrest.setHosprtSocieteHt(this.hospitalisationPrest.getHosprtSocieteHt() + var15);
            }

            if (var6 != 0.0D) {
               this.hospitalisationPrest.setHosprtComplementaireHt(this.hospitalisationPrest.getHosprtComplementaireHt() + var15);
            }
         }
      }

   }

   public void prestationSansCnamgsPrive(Session var1) {
      if (this.tauxCasSocial != 0.0F) {
         this.hospitalisationPrest.setHosprtRemise(this.tauxCasSocial);
      }

      double var2;
      if (this.hospitalisationPrest.getHosprtRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.hospitalisationPrest.getHosprtPu() * (double)this.hospitalisationPrest.getHosprtRemise() / 100.0D, this.structureLog.getStrdevise());
         this.hospitalisationPrest.setHosprtPuRem(this.hospitalisationPrest.getHosprtPu() - var2);
         this.hospitalisationPrest.setHosprtRabais(0.0D);
      } else {
         this.hospitalisationPrest.setHosprtPuRem(this.hospitalisationPrest.getHosprtPu());
      }

      this.hospitalisationPrest.setHosprtTotal(this.hospitalisationPrest.getHosprtPuRem() * (double)this.hospitalisationPrest.getHosprtQte());
      if (this.hospitalisationPrest.getHosprtTauxTva() != 0.0F) {
         var2 = this.hospitalisationPrest.getHosprtTotal() * (double)this.hospitalisationPrest.getHosprtTauxTva() / 100.0D;
         this.hospitalisationPrest.setHosprtTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.hospitalisationPrest.setHosprtTaxe(0.0D);
      }

      this.hospitalisationPrest.setHosprtNbCnamgs(0.0F);
      this.hospitalisationPrest.setHosprtValeurCnamgs(0.0D);
      this.hospitalisationPrest.setHosprtPuCnamgs(0.0D);
      this.hospitalisationPrest.setHosprtSocieteHt(0.0D);
      this.hospitalisationPrest.setHosprtSocieteTaxe(0.0D);
      this.hospitalisationPrest.setHosprtAssuranceHt(0.0D);
      this.hospitalisationPrest.setHosprtAssuranceTaxe(0.0D);
      this.hospitalisationPrest.setHosprtComplementaireHt(0.0D);
      this.hospitalisationPrest.setHosprtComplementaireTaxe(0.0D);
      this.hospitalisationPrest.setHosprtPatientHt(0.0D);
      this.hospitalisationPrest.setHosprtPatientTaxe(0.0D);
      this.hospitalisationEntete.setHosIdEmployeur(0L);
      var2 = this.hospitalisationPrest.getHosprtTotal();
      if (this.hospitalisationPrest.getHosprtRabais() != 0.0D) {
         this.hospitalisationPrest.setHosprtPatientHt(var2 - this.hospitalisationPrest.getHosprtRabais());
         this.hospitalisationPrest.setHosprtRemise(0.0F);
         if (this.hospitalisationPrest.getHosprtPatientHt() < 0.0D) {
            this.hospitalisationPrest.setHosprtPatientHt(var2);
            this.hospitalisationPrest.setHosprtRabais(0.0D);
         }
      } else {
         this.hospitalisationPrest.setHosprtPatientHt(var2);
      }

      if (this.hospitalisationPrest.getHosprtTaxe() != 0.0D) {
         double var4 = this.hospitalisationPrest.getHosprtPatientHt() * (double)this.hospitalisationPrest.getHosprtTauxTva() / 100.0D;
         this.hospitalisationPrest.setHosprtPatientTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
      } else {
         this.hospitalisationPrest.setHosprtPatientTaxe(0.0D);
      }

   }

   public void prestationAvecCnamgsPrive(Session var1) throws HibernateException, NamingException {
      if (this.hospitalisationPrest.getHosprtPuCnamgs() > this.hospitalisationPrest.getHosprtPu()) {
         this.hospitalisationPrest.setHosprtPu(this.hospitalisationPrest.getHosprtPuCnamgs());
      }

      double var2;
      double var4;
      if (this.hospitalisationPrest.getHosprtRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.hospitalisationPrest.getHosprtPu() * (double)this.hospitalisationPrest.getHosprtRemise() / 100.0D, this.structureLog.getStrdevise());
         this.hospitalisationPrest.setHosprtPuRem(this.hospitalisationPrest.getHosprtPu() - var2);
         var4 = this.utilNombre.myRoundDevise(this.hospitalisationPrest.getHosprtPuCnamgs() * (double)this.hospitalisationPrest.getHosprtRemise() / 100.0D, this.structureLog.getStrdevise());
         this.hospitalisationPrest.setHosprtPuCnamgs(this.hospitalisationPrest.getHosprtPuCnamgs() - var4);
         this.hospitalisationPrest.setHosprtRabais(0.0D);
      } else {
         this.hospitalisationPrest.setHosprtPuRem(this.hospitalisationPrest.getHosprtPu());
      }

      this.hospitalisationPrest.setHosprtTotal(this.hospitalisationPrest.getHosprtPuRem() * (double)this.hospitalisationPrest.getHosprtQte());
      if (this.hospitalisationPrest.getHosprtTauxTva() != 0.0F) {
         var2 = this.hospitalisationPrest.getHosprtTotal() * (double)this.hospitalisationPrest.getHosprtTauxTva() / 100.0D;
         this.hospitalisationPrest.setHosprtTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.hospitalisationPrest.setHosprtTaxe(0.0D);
      }

      this.hospitalisationPrest.setHosprtSocieteHt(0.0D);
      this.hospitalisationPrest.setHosprtSocieteTaxe(0.0D);
      this.hospitalisationPrest.setHosprtAssuranceHt(0.0D);
      this.hospitalisationPrest.setHosprtAssuranceTaxe(0.0D);
      this.hospitalisationPrest.setHosprtComplementaireHt(0.0D);
      this.hospitalisationPrest.setHosprtComplementaireTaxe(0.0D);
      this.hospitalisationPrest.setHosprtPatientHt(0.0D);
      this.hospitalisationPrest.setHosprtPatientTaxe(0.0D);
      this.hospitalisationEntete.setHosIdEmployeur(0L);
      this.hospitalisationPrest.setHosprtAssuranceHt(this.hospitalisationPrest.getHosprtPuCnamgs() * (double)this.hospitalisationPrest.getHosprtQte() * (double)this.var_pecCnamgs / 100.0D);
      if (this.hospitalisationPrest.getHosprtTauxTva() != 0.0F) {
         var2 = this.hospitalisationPrest.getHosprtAssuranceHt() * (double)this.hospitalisationPrest.getHosprtTauxTva() / 100.0D;
         this.hospitalisationPrest.setHosprtAssuranceTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      }

      var2 = this.hospitalisationPrest.getHosprtTotal() - this.hospitalisationPrest.getHosprtAssuranceHt();
      if (this.hospitalisationPrest.getHosprtRabais() != 0.0D) {
         this.hospitalisationPrest.setHosprtPatientHt(var2 - this.hospitalisationPrest.getHosprtRabais());
         this.hospitalisationPrest.setHosprtRemise(0.0F);
         if (this.hospitalisationPrest.getHosprtPatientHt() < 0.0D) {
            this.hospitalisationPrest.setHosprtPatientHt(var2);
            this.hospitalisationPrest.setHosprtRabais(0.0D);
         }
      } else {
         this.hospitalisationPrest.setHosprtPatientHt(var2);
      }

      if (this.hospitalisationPrest.getHosprtTauxTva() != 0.0F) {
         var4 = this.hospitalisationPrest.getHosprtPatientHt() * (double)this.hospitalisationPrest.getHosprtTauxTva() / 100.0D;
         this.hospitalisationPrest.setHosprtPatientTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
      }

   }

   public void verifBonEncaissement() {
      if (this.totalSolde < 0.0D) {
         this.var_affiche_valide = false;
      } else {
         this.var_affiche_valide = true;
      }

   }

   public void payeDocument() throws HibernateException, NamingException {
      double var1 = 0.0D;
      long var3 = 0L;

      for(int var5 = 0; var5 < this.lesCaution.size(); ++var5) {
         if (((HospitalisationCaution)this.lesCaution.get(var5)).getHoscauIdRecu() == 0L) {
            var3 = ((HospitalisationCaution)this.lesCaution.get(var5)).getHoscauId();
            var1 = ((HospitalisationCaution)this.lesCaution.get(var5)).getHoscauMontant();
            break;
         }
      }

      this.payeDocument(var3, var1);
   }

   public void payeDocument(long var1, double var3) throws HibernateException, NamingException {
      if (this.hospitalisationEntete != null) {
         this.calculeCaisseDisponibleBencaissement();
         String var5 = null;
         String var6 = null;
         if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
            String[] var7 = this.var_inputCaisse.split(":");
            var5 = var7[0];
            var6 = var7[1];
         }

         double var15 = 0.0D;
         long var9 = 0L;
         String var11 = "";
         String var12 = "";
         String var13 = "";
         this.paiementPartiel = false;
         if (var1 != 0L && var3 != 0.0D) {
            if (this.lesMedis.size() != 0) {
               for(int var14 = 0; var14 < this.lesMedis.size(); ++var14) {
                  this.hospitalisationMedi = (HospitalisationMedi)this.lesMedis.get(var14);
                  if (this.hospitalisationMedi.getHosmedLibelle().contains("KIT") && this.hospitalisationMedi.getHosmedPatientHt() != 0.0D && this.hospitalisationMedi.getHosmedRegTiers() == 0.0D) {
                     var9 = this.hospitalisationMedi.getHosmedId();
                     var15 = this.hospitalisationMedi.getHosmedPatientHt();
                     var11 = this.hospitalisationMedi.getHosmedProduit();
                     var12 = this.hospitalisationMedi.getHosmedLibelle();
                     var13 = this.hospitalisationMedi.getHosmedService();
                     break;
                  }
               }
            }

            this.chargerElementsServices(var1, var3, var9, var15, var11, var12, var13);
         } else {
            this.chargerElementsServices();
         }

         this.calculSoldeTotal();
         this.numLettreGarantie = "";
         this.bonEncaissementVente = new BonEncaissementVente();
         this.bonEncaissementVente.setBonCodeCaisse(var5);
         this.bonEncaissementVente.setBonLibCaisse(var6);
         this.bonEncaissementVente.setBonDate(new Date());
         this.var_nom_client = "";
         this.var_num_facture = "";
         this.var_montant = "";
         this.var_date = new Date();
         if (this.var_tot_bon_encaissement <= this.hospitalisationEntete.getTotalPatient() && var3 == 0.0D) {
            if (this.hospitalisationEntete.getHosTypeReg() == 5) {
               this.montantElmTotBonEnc = this.var_tot_bon_encaissement;
               if (this.hospitalisationEntete.getHosEtat() == 1) {
                  this.var_verouxModReg = true;
               } else {
                  this.var_verouxModReg = false;
               }

               this.montantElmTotBonEnc = this.var_netAPayer;
               this.var_affiche_valide = true;
            } else {
               this.hospitalisationEntete.setHosTypeReg(0);
               this.var_verouxModReg = false;
               this.montantElmTotBonEnc = this.var_netAPayer;
               this.verifBonEncaissement();
            }

            this.var_affichMontant = true;
         } else {
            this.hospitalisationEntete.setHosTypeReg(4);
            this.var_verouxModReg = true;
            this.var_affichMontant = false;
            this.montantElmTotBonEnc = this.var_netAPayer;
            this.verifBonEncaissement();
         }

         this.showModalPanelBonEncaissement = true;
      }

   }

   public void calculeCaisseDisponibleBencaissement() throws HibernateException, NamingException {
      this.mesCaissesSeriesItems.clear();
      if (this.listCaisses.size() != 0) {
         for(int var1 = 0; var1 < this.listCaisses.size(); ++var1) {
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 60 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.hospitalisationEntete.getHosSerie())) {
               String var2 = ((UsersChrono)this.listCaisses.get(var1)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)this.listCaisses.get(var1)).getUsrchrLib();
               this.mesCaissesSeriesItems.add(new SelectItem(var2));
            }
         }

         this.var_inputCaisse = ((SelectItem)this.mesCaissesSeriesItems.get(0)).getValue().toString();
      }

   }

   public void chargerElementsServices() throws HibernateException, NamingException {
      this.lesReglServices.clear();
      this.objetTarif = new ObjetTarif();
      double var1;
      int var3;
      boolean var4;
      int var5;
      if (this.lesSejours.size() != 0) {
         var1 = 0.0D;

         for(var3 = 0; var3 < this.lesSejours.size(); ++var3) {
            this.hospitalisationSejour = (HospitalisationSejour)this.lesSejours.get(var3);
            if (this.hospitalisationSejour.getHossejPatientHt() != 0.0D) {
               if (this.lesReglServices.size() == 0) {
                  this.objetTarif = new ObjetTarif();
                  this.objetTarif.setType(0);
                  this.objetTarif.setNomService(this.hospitalisationSejour.getHossejService());
                  this.objetTarif.setNomLaboratoire("");
                  this.objetTarif.setIdLaboratoire(0L);
                  this.objetTarif.setNomProduit(this.hospitalisationSejour.getHossejLit());
                  this.objetTarif.setNomLibelle(this.hospitalisationSejour.getHossejLibelle());
                  this.objetTarif.setTotalService(this.hospitalisationSejour.getHossejPatientHt() + this.hospitalisationSejour.getHossejPatientTaxe());
                  this.objetTarif.setDejaPaye(0.0D);
                  this.objetTarif.setPrix(0.0D);
                  this.objetTarif.setSolde(0.0D);
                  this.objetTarif.setIdCaution(0L);
                  this.objetTarif.setIdSejour(this.hospitalisationSejour.getHossejId());
                  this.lesReglServices.add(this.objetTarif);
               } else {
                  var4 = false;

                  for(var5 = 0; var5 < this.lesReglServices.size(); ++var5) {
                     this.objetTarif = (ObjetTarif)this.lesReglServices.get(var5);
                     if (this.hospitalisationSejour.getHossejId() == this.objetTarif.getIdSejour() && this.hospitalisationSejour.getHossejService().equals(this.objetTarif.getNomService())) {
                        var1 = ((ObjetTarif)this.lesReglServices.get(var5)).getPrix();
                        var4 = true;
                        break;
                     }
                  }

                  if (!var4) {
                     this.objetTarif = new ObjetTarif();
                     this.objetTarif.setType(0);
                     this.objetTarif.setNomService(this.hospitalisationSejour.getHossejService());
                     this.objetTarif.setNomLaboratoire("");
                     this.objetTarif.setIdLaboratoire(0L);
                     this.objetTarif.setNomProduit(this.hospitalisationSejour.getHossejLit());
                     this.objetTarif.setNomLibelle(this.hospitalisationSejour.getHossejLibelle());
                     this.objetTarif.setTotalService(this.hospitalisationSejour.getHossejPatientHt() + this.hospitalisationSejour.getHossejPatientTaxe());
                     this.objetTarif.setDejaPaye(0.0D);
                     this.objetTarif.setPrix(0.0D);
                     this.objetTarif.setSolde(0.0D);
                     this.objetTarif.setIdCaution(0L);
                     this.objetTarif.setIdSejour(this.hospitalisationSejour.getHossejId());
                     this.lesReglServices.add(this.objetTarif);
                  } else {
                     this.lesReglServices.remove(this.objetTarif);
                     this.objetTarif.setTotalService(this.hospitalisationSejour.getHossejPatientHt() + this.hospitalisationSejour.getHossejPatientTaxe() + var1);
                     this.objetTarif.setDejaPaye(0.0D);
                     this.objetTarif.setPrix(0.0D);
                     this.objetTarif.setSolde(0.0D);
                     this.objetTarif.setIdCaution(0L);
                     this.lesReglServices.add(this.objetTarif);
                  }
               }
            }
         }
      }

      if (this.lesActes.size() != 0) {
         var1 = 0.0D;

         for(var3 = 0; var3 < this.lesActes.size(); ++var3) {
            this.hospitalisationActes = (HospitalisationActes)this.lesActes.get(var3);
            if (this.hospitalisationActes.getHosactPatientHt() != 0.0D) {
               if (this.lesReglServices.size() == 0) {
                  this.objetTarif = new ObjetTarif();
                  this.objetTarif.setType(1);
                  this.objetTarif.setNomService(this.hospitalisationActes.getHosactService());
                  this.objetTarif.setNomLaboratoire("");
                  this.objetTarif.setIdLaboratoire(0L);
                  this.objetTarif.setNomProduit(this.hospitalisationActes.getHosactProduit());
                  this.objetTarif.setNomLibelle(this.hospitalisationActes.getHosactLibelle());
                  this.objetTarif.setTotalService(this.hospitalisationActes.getHosactPatientHt() + this.hospitalisationActes.getHosactPatientTaxe());
                  this.objetTarif.setDejaPaye(0.0D);
                  this.objetTarif.setPrix(0.0D);
                  this.objetTarif.setSolde(0.0D);
                  this.objetTarif.setIdCaution(0L);
                  this.objetTarif.setIdSejour(this.hospitalisationActes.getHosactIdSejour());
                  this.lesReglServices.add(this.objetTarif);
               } else {
                  var4 = false;

                  for(var5 = 0; var5 < this.lesReglServices.size(); ++var5) {
                     this.objetTarif = (ObjetTarif)this.lesReglServices.get(var5);
                     if (this.hospitalisationActes.getHosactIdSejour() == this.objetTarif.getIdSejour() && this.hospitalisationActes.getHosactService().equals(this.objetTarif.getNomService())) {
                        var1 = ((ObjetTarif)this.lesReglServices.get(var5)).getTotalService();
                        var4 = true;
                        break;
                     }
                  }

                  if (!var4) {
                     this.objetTarif = new ObjetTarif();
                     this.objetTarif.setType(1);
                     this.objetTarif.setNomService(this.hospitalisationActes.getHosactService());
                     this.objetTarif.setNomLaboratoire("");
                     this.objetTarif.setIdLaboratoire(0L);
                     this.objetTarif.setNomProduit(this.hospitalisationActes.getHosactProduit());
                     this.objetTarif.setNomLibelle(this.hospitalisationActes.getHosactLibelle());
                     this.objetTarif.setTotalService(this.hospitalisationActes.getHosactPatientHt() + this.hospitalisationActes.getHosactPatientTaxe());
                     this.objetTarif.setDejaPaye(0.0D);
                     this.objetTarif.setPrix(0.0D);
                     this.objetTarif.setSolde(0.0D);
                     this.objetTarif.setIdCaution(0L);
                     this.objetTarif.setIdSejour(this.hospitalisationActes.getHosactIdSejour());
                     this.lesReglServices.add(this.objetTarif);
                  } else {
                     this.lesReglServices.remove(this.objetTarif);
                     this.objetTarif.setTotalService(this.hospitalisationActes.getHosactPatientHt() + this.hospitalisationActes.getHosactPatientTaxe() + var1);
                     this.objetTarif.setDejaPaye(0.0D);
                     this.objetTarif.setPrix(0.0D);
                     this.objetTarif.setSolde(0.0D);
                     this.objetTarif.setIdCaution(0L);
                     this.lesReglServices.add(this.objetTarif);
                  }
               }
            }
         }
      }

      if (this.lesLabos.size() != 0) {
         var1 = 0.0D;

         for(var3 = 0; var3 < this.lesLabos.size(); ++var3) {
            this.hospitalisationLabo = (HospitalisationLabo)this.lesLabos.get(var3);
            if (this.hospitalisationLabo.getHoslabPatientHt() != 0.0D) {
               if (this.lesReglServices.size() == 0) {
                  this.objetTarif = new ObjetTarif();
                  this.objetTarif.setType(2);
                  this.objetTarif.setNomService(this.hospitalisationLabo.getHoslabService());
                  this.objetTarif.setNomLaboratoire(this.hospitalisationLabo.getHoslabLaboratoire());
                  this.objetTarif.setIdLaboratoire(this.hospitalisationLabo.getHoslabIdLaboratoire());
                  this.objetTarif.setNomProduit(this.hospitalisationLabo.getHoslabProduit());
                  this.objetTarif.setNomLibelle(this.hospitalisationLabo.getHoslabLibelle());
                  this.objetTarif.setTotalService(this.hospitalisationLabo.getHoslabPatientHt() + this.hospitalisationLabo.getHoslabPatientTaxe());
                  this.objetTarif.setDejaPaye(0.0D);
                  this.objetTarif.setPrix(0.0D);
                  this.objetTarif.setSolde(0.0D);
                  this.objetTarif.setIdCaution(0L);
                  this.objetTarif.setIdSejour(this.hospitalisationLabo.getHoslabIdSejour());
                  this.lesReglServices.add(this.objetTarif);
               } else {
                  var4 = false;

                  for(var5 = 0; var5 < this.lesReglServices.size(); ++var5) {
                     this.objetTarif = (ObjetTarif)this.lesReglServices.get(var5);
                     if (this.hospitalisationLabo.getHoslabIdSejour() == this.objetTarif.getIdSejour() && this.hospitalisationLabo.getHoslabLaboratoire().equals(this.objetTarif.getNomLaboratoire())) {
                        var1 = ((ObjetTarif)this.lesReglServices.get(var5)).getTotalService();
                        var4 = true;
                        break;
                     }
                  }

                  if (!var4) {
                     this.objetTarif = new ObjetTarif();
                     this.objetTarif.setType(2);
                     this.objetTarif.setNomService(this.hospitalisationLabo.getHoslabService());
                     this.objetTarif.setNomLaboratoire(this.hospitalisationLabo.getHoslabLaboratoire());
                     this.objetTarif.setIdLaboratoire(this.hospitalisationLabo.getHoslabIdLaboratoire());
                     this.objetTarif.setNomProduit(this.hospitalisationLabo.getHoslabProduit());
                     this.objetTarif.setNomLibelle(this.hospitalisationLabo.getHoslabLibelle());
                     this.objetTarif.setTotalService(this.hospitalisationLabo.getHoslabPatientHt() + this.hospitalisationLabo.getHoslabPatientTaxe());
                     this.objetTarif.setDejaPaye(0.0D);
                     this.objetTarif.setPrix(0.0D);
                     this.objetTarif.setSolde(0.0D);
                     this.objetTarif.setIdCaution(0L);
                     this.objetTarif.setIdSejour(this.hospitalisationLabo.getHoslabIdSejour());
                     this.lesReglServices.add(this.objetTarif);
                  } else {
                     this.lesReglServices.remove(this.objetTarif);
                     this.objetTarif.setTotalService(this.hospitalisationLabo.getHoslabPatientHt() + this.hospitalisationLabo.getHoslabPatientTaxe() + var1);
                     this.objetTarif.setDejaPaye(0.0D);
                     this.objetTarif.setPrix(0.0D);
                     this.objetTarif.setSolde(0.0D);
                     this.objetTarif.setIdCaution(0L);
                     this.lesReglServices.add(this.objetTarif);
                  }
               }
            }
         }
      }

      if (this.lesMedis.size() != 0) {
         var1 = 0.0D;

         for(var3 = 0; var3 < this.lesMedis.size(); ++var3) {
            this.hospitalisationMedi = (HospitalisationMedi)this.lesMedis.get(var3);
            if (this.hospitalisationMedi.getHosmedPatientHt() != 0.0D) {
               if (this.lesReglServices.size() == 0) {
                  this.objetTarif = new ObjetTarif();
                  this.objetTarif.setType(3);
                  this.objetTarif.setNomService(this.hospitalisationMedi.getHosmedService());
                  this.objetTarif.setNomLaboratoire("");
                  this.objetTarif.setIdLaboratoire(0L);
                  this.objetTarif.setNomProduit(this.hospitalisationMedi.getHosmedProduit());
                  this.objetTarif.setNomLibelle(this.hospitalisationMedi.getHosmedLibelle());
                  this.objetTarif.setTotalService(this.hospitalisationMedi.getHosmedPatientHt() + this.hospitalisationMedi.getHosmedPatientTaxe());
                  this.objetTarif.setDejaPaye(0.0D);
                  this.objetTarif.setPrix(0.0D);
                  this.objetTarif.setSolde(0.0D);
                  this.objetTarif.setIdCaution(0L);
                  this.objetTarif.setIdSejour(this.hospitalisationMedi.getHosmedIdSejour());
                  this.lesReglServices.add(this.objetTarif);
               } else {
                  var4 = false;

                  for(var5 = 0; var5 < this.lesReglServices.size(); ++var5) {
                     this.objetTarif = (ObjetTarif)this.lesReglServices.get(var5);
                     if (this.hospitalisationMedi.getHosmedIdSejour() == this.objetTarif.getIdSejour() && this.hospitalisationMedi.getHosmedService().equals(this.objetTarif.getNomService()) && this.hospitalisationMedi.getHosmedLibelle().equals(this.objetTarif.getNomLibelle())) {
                        var1 = ((ObjetTarif)this.lesReglServices.get(var5)).getTotalService();
                        var4 = true;
                        break;
                     }
                  }

                  if (!var4) {
                     this.objetTarif = new ObjetTarif();
                     this.objetTarif.setType(3);
                     this.objetTarif.setNomService(this.hospitalisationMedi.getHosmedService());
                     this.objetTarif.setNomLaboratoire("");
                     this.objetTarif.setIdLaboratoire(0L);
                     this.objetTarif.setNomProduit(this.hospitalisationMedi.getHosmedProduit());
                     this.objetTarif.setNomLibelle(this.hospitalisationMedi.getHosmedLibelle());
                     this.objetTarif.setTotalService(this.hospitalisationMedi.getHosmedPatientHt() + this.hospitalisationMedi.getHosmedPatientTaxe());
                     this.objetTarif.setDejaPaye(0.0D);
                     this.objetTarif.setPrix(0.0D);
                     this.objetTarif.setSolde(0.0D);
                     this.objetTarif.setIdCaution(0L);
                     this.objetTarif.setIdSejour(this.hospitalisationMedi.getHosmedIdSejour());
                     this.lesReglServices.add(this.objetTarif);
                  } else {
                     this.lesReglServices.remove(this.objetTarif);
                     this.objetTarif.setTotalService(this.hospitalisationMedi.getHosmedPatientHt() + this.hospitalisationMedi.getHosmedPatientTaxe() + var1);
                     this.objetTarif.setDejaPaye(0.0D);
                     this.objetTarif.setPrix(0.0D);
                     this.objetTarif.setSolde(0.0D);
                     this.objetTarif.setIdCaution(0L);
                     this.lesReglServices.add(this.objetTarif);
                  }
               }
            }
         }
      }

      if (this.lesPrests.size() != 0) {
         var1 = 0.0D;

         for(var3 = 0; var3 < this.lesPrests.size(); ++var3) {
            this.hospitalisationPrest = (HospitalisationPrest)this.lesPrests.get(var3);
            if (this.hospitalisationPrest.getHosprtPatientHt() != 0.0D) {
               if (this.lesReglServices.size() == 0) {
                  this.objetTarif = new ObjetTarif();
                  this.objetTarif.setType(4);
                  this.objetTarif.setNomService(this.hospitalisationPrest.getHosprtService());
                  this.objetTarif.setNomLaboratoire("");
                  this.objetTarif.setIdLaboratoire(0L);
                  this.objetTarif.setNomProduit(this.hospitalisationPrest.getHosprtProduit());
                  this.objetTarif.setNomLibelle(this.hospitalisationPrest.getHosprtLibelle());
                  this.objetTarif.setTotalService(this.hospitalisationPrest.getHosprtPatientHt() + this.hospitalisationPrest.getHosprtPatientTaxe());
                  this.objetTarif.setDejaPaye(0.0D);
                  this.objetTarif.setPrix(0.0D);
                  this.objetTarif.setSolde(0.0D);
                  this.objetTarif.setIdCaution(0L);
                  this.objetTarif.setIdSejour(this.hospitalisationPrest.getHosprtIdSejour());
                  this.lesReglServices.add(this.objetTarif);
               } else {
                  var4 = false;

                  for(var5 = 0; var5 < this.lesReglServices.size(); ++var5) {
                     this.objetTarif = (ObjetTarif)this.lesReglServices.get(var5);
                     if (this.hospitalisationPrest.getHosprtIdSejour() == this.objetTarif.getIdSejour() && this.hospitalisationPrest.getHosprtService().equals(this.objetTarif.getNomService())) {
                        var1 = ((ObjetTarif)this.lesReglServices.get(var5)).getTotalService();
                        var4 = true;
                        break;
                     }
                  }

                  if (!var4) {
                     this.objetTarif = new ObjetTarif();
                     this.objetTarif.setType(4);
                     this.objetTarif.setNomService(this.hospitalisationPrest.getHosprtService());
                     this.objetTarif.setNomLaboratoire("");
                     this.objetTarif.setIdLaboratoire(0L);
                     this.objetTarif.setNomProduit(this.hospitalisationPrest.getHosprtProduit());
                     this.objetTarif.setNomLibelle(this.hospitalisationPrest.getHosprtLibelle());
                     this.objetTarif.setTotalService(this.hospitalisationPrest.getHosprtPatientHt() + this.hospitalisationPrest.getHosprtPatientTaxe());
                     this.objetTarif.setDejaPaye(0.0D);
                     this.objetTarif.setPrix(0.0D);
                     this.objetTarif.setSolde(0.0D);
                     this.objetTarif.setIdCaution(0L);
                     this.objetTarif.setIdSejour(this.hospitalisationPrest.getHosprtIdSejour());
                     this.lesReglServices.add(this.objetTarif);
                  } else {
                     this.lesReglServices.remove(this.objetTarif);
                     this.objetTarif.setTotalService(this.hospitalisationPrest.getHosprtPatientHt() + this.hospitalisationPrest.getHosprtPatientTaxe() + var1);
                     this.objetTarif.setDejaPaye(0.0D);
                     this.objetTarif.setPrix(0.0D);
                     this.objetTarif.setSolde(0.0D);
                     this.objetTarif.setIdCaution(0L);
                     this.lesReglServices.add(this.objetTarif);
                  }
               }
            }
         }
      }

      this.lesReglements.clear();
      this.lesReglements = this.hospitalisationReglementDao.selectReglementByEnt(this.hospitalisationEntete, (Session)null);
      if (this.lesReglements.size() != 0) {
         for(int var6 = 0; var6 < this.lesReglements.size(); ++var6) {
            this.hospitalisationReglement = (HospitalisationReglement)this.lesReglements.get(var6);
            boolean var2 = false;
            if (this.lesReglServices.size() != 0) {
               for(var3 = 0; var3 < this.lesReglServices.size(); ++var3) {
                  this.objetTarif = (ObjetTarif)this.lesReglServices.get(var3);
                  if (this.objetTarif.getIdSejour() == this.hospitalisationReglement.getHosregIdSejour() && !this.objetTarif.getNomService().equals("41:PHARMACIE CENTRALE") && this.objetTarif.getNomService().equals(this.hospitalisationReglement.getHosregService()) && this.objetTarif.getIdLaboratoire() == this.hospitalisationReglement.getHosregIdLaboratoire()) {
                     var2 = true;
                     break;
                  }

                  if (this.objetTarif.getIdSejour() == this.hospitalisationReglement.getHosregIdSejour() && this.objetTarif.getNomService().equals("41:PHARMACIE CENTRALE") && this.objetTarif.getNomService().equals(this.hospitalisationReglement.getHosregService()) && this.objetTarif.getNomProduit().equals(this.hospitalisationReglement.getHosregProduit())) {
                     var2 = true;
                     break;
                  }
               }
            }

            if (var2) {
               if (this.objetTarif != null) {
                  this.objetTarif.setNomService(this.hospitalisationReglement.getHosregService());
                  this.objetTarif.setNomLaboratoire(this.hospitalisationReglement.getHosregLaboratoire());
                  this.objetTarif.setIdLaboratoire(this.hospitalisationReglement.getHosregIdLaboratoire());
                  this.objetTarif.setNomProduit(this.hospitalisationReglement.getHosregProduit());
                  if (this.hospitalisationReglement.getHosregEtat() == 0) {
                     this.objetTarif.setPrix(this.objetTarif.getPrix() + this.hospitalisationReglement.getHosregPatient());
                  } else {
                     this.objetTarif.setDejaPaye(this.objetTarif.getDejaPaye() + this.hospitalisationReglement.getHosregPatient());
                  }

                  this.objetTarif.setSaisieInterdit(true);
               }
            } else {
               this.objetTarif = new ObjetTarif();
               if (this.hospitalisationReglement.getHosregService() != null && !this.hospitalisationReglement.getHosregService().isEmpty() && this.hospitalisationReglement.getHosregService().equals("CAUTION")) {
                  this.objetTarif.setType(10);
               } else {
                  this.objetTarif.setType(9);
               }

               this.objetTarif.setNomService(this.hospitalisationReglement.getHosregService());
               this.objetTarif.setNomLaboratoire(this.hospitalisationReglement.getHosregLaboratoire());
               this.objetTarif.setIdLaboratoire(this.hospitalisationReglement.getHosregIdLaboratoire());
               this.objetTarif.setTotalService(0.0D);
               if (this.hospitalisationReglement.getHosregEtat() == 0) {
                  this.objetTarif.setPrix(this.hospitalisationReglement.getHosregPatient());
                  this.objetTarif.setDejaPaye(0.0D);
               } else {
                  this.objetTarif.setDejaPaye(this.hospitalisationReglement.getHosregPatient());
                  this.objetTarif.setPrix(0.0D);
               }

               this.objetTarif.setNomProduit(this.hospitalisationReglement.getHosregProduit());
               this.objetTarif.setSolde(0.0D);
               this.objetTarif.setIdCaution(0L);
               this.objetTarif.setIdSejour(this.hospitalisationReglement.getHosregIdSejour());
               this.objetTarif.setSaisieInterdit(true);
               this.lesReglServices.add(this.objetTarif);
            }
         }
      }

      this.finalisationReglement();
      this.dataModelRegService.setWrappedData(this.lesReglServices);
   }

   public void finalisationReglement() {
      int var1;
      for(var1 = 0; var1 < this.lesReglServices.size(); ++var1) {
         this.objetTarif = (ObjetTarif)this.lesReglServices.get(var1);
         this.objetTarif.setSolde(this.objetTarif.getTotalService() - this.objetTarif.getDejaPaye() - this.objetTarif.getPrix());
         if (this.objetTarif.getType() != 9 && this.objetTarif.getType() != 10) {
            if (this.objetTarif.getSolde() == 0.0D) {
               this.objetTarif.setSaisieInterdit(true);
            } else {
               this.objetTarif.setSaisieInterdit(false);
            }
         } else {
            this.objetTarif.setSolde(0.0D);
            this.objetTarif.setSaisieInterdit(true);
         }

         if (this.objetTarif.getSolde() == 0.0D) {
            this.objetTarif.setSolde(0.0D);
         }

         if (this.hospitalisationEntete.isHosCaution()) {
            this.objetTarif.setSaisieInterdit(true);
         }
      }

      this.balanceFinale = false;

      for(var1 = 0; var1 < this.lesSejours.size(); ++var1) {
         if (((HospitalisationSejour)this.lesSejours.get(var1)).getHossejDateSortie() != null) {
            this.balanceFinale = true;
         } else {
            this.balanceFinale = false;
         }
      }

      if (this.balanceFinale) {
         double var4 = 0.0D;

         int var3;
         for(var3 = 0; var3 < this.lesCaution.size(); ++var3) {
            if (((HospitalisationCaution)this.lesCaution.get(var3)).getHoscauIdRecu() != 0L) {
               var4 += ((HospitalisationCaution)this.lesCaution.get(var3)).getHoscauMontant();
            }
         }

         for(var3 = 0; var3 < this.lesReglServices.size(); ++var3) {
            this.objetTarif = (ObjetTarif)this.lesReglServices.get(var3);
            if (this.objetTarif.getType() != 10 && this.objetTarif.getSolde() != 0.0D) {
               if (this.objetTarif.getSolde() <= var4) {
                  this.objetTarif.setPrix(this.objetTarif.getSolde());
                  this.objetTarif.setSolde(0.0D);
                  var4 -= this.objetTarif.getPrix();
                  this.objetTarif.setSaisieInterdit(true);
               } else {
                  this.objetTarif.setPrix(var4);
                  this.objetTarif.setSolde(this.objetTarif.getSolde() - var4);
                  var4 = 0.0D;
                  this.objetTarif.setSaisieInterdit(false);
               }
            }
         }

         this.calculSoldeTotal();
      }

   }

   public void chargerElementsServices(long var1, double var3, long var5, double var7, String var9, String var10, String var11) throws HibernateException, NamingException {
      new BonEncaissementVente();
      BonEncaissementVente var12 = this.bonEncaissementVenteDao.selectById(var1, (Session)null);
      if (var12 != null) {
         this.bonEncaissementVenteDao.delete(var12);
      }

      this.balanceFinale = false;
      this.lesReglServices.clear();
      this.objetTarif = new ObjetTarif();
      this.objetTarif.setType(10);
      this.objetTarif.setNomService(this.hospitalisationSejour.getHossejService());
      this.objetTarif.setNomLaboratoire("Versement Caution");
      this.objetTarif.setIdLaboratoire(0L);
      this.objetTarif.setNomProduit("");
      this.objetTarif.setNomLibelle("");
      this.objetTarif.setTotalService(var3);
      this.objetTarif.setDejaPaye(0.0D);
      this.objetTarif.setPrix(var3);
      this.objetTarif.setSolde(0.0D);
      this.objetTarif.setIdCaution(var1);
      this.objetTarif.setSaisieInterdit(true);
      this.objetTarif.setIdSejour(this.hospitalisationSejour.getHossejId());
      this.lesReglServices.add(this.objetTarif);
      if (var5 != 0L && var7 != 0.0D) {
         this.objetTarif = new ObjetTarif();
         this.objetTarif.setType(3);
         this.objetTarif.setNomService(var11);
         this.objetTarif.setNomLaboratoire("");
         this.objetTarif.setIdLaboratoire(0L);
         this.objetTarif.setNomProduit(var9);
         this.objetTarif.setNomLibelle(var10);
         this.objetTarif.setTotalService(var7);
         this.objetTarif.setDejaPaye(0.0D);
         this.objetTarif.setPrix(var7);
         this.objetTarif.setSolde(0.0D);
         this.objetTarif.setIdCaution(0L);
         this.objetTarif.setSaisieInterdit(true);
         this.objetTarif.setIdSejour(this.hospitalisationMedi.getHosmedIdSejour());
         this.lesReglServices.add(this.objetTarif);
      }

      this.dataModelRegService.setWrappedData(this.lesReglServices);
   }

   public void selectionPaye() {
      if (this.dataModelRegService.isRowAvailable()) {
         this.objetTarif = (ObjetTarif)this.dataModelRegService.getRowData();
      }

   }

   public void calculSodeLigne() {
      if (this.objetTarif != null) {
         this.objetTarif.setSolde(this.objetTarif.getTotalService() - this.objetTarif.getDejaPaye() - this.objetTarif.getPrix());
         this.calculSoldeTotal();
      }

   }

   public void calculSoldeTotal() {
      this.var_netAPayer = 0.0D;
      this.totalReglement = 0.0D;
      this.totalPaye = 0.0D;
      this.totalSolde = 0.0D;
      long var1 = 0L;
      double var3 = 0.0D;
      double var5 = 0.0D;

      int var7;
      for(var7 = 0; var7 < this.lesCaution.size(); ++var7) {
         if (((HospitalisationCaution)this.lesCaution.get(var7)).getHoscauIdRecu() == 0L) {
            var3 += ((HospitalisationCaution)this.lesCaution.get(var7)).getHoscauMontant();
            var1 = ((HospitalisationCaution)this.lesCaution.get(var7)).getHoscauIdSejour();
         } else if (((HospitalisationCaution)this.lesCaution.get(var7)).getHoscauIdRecu() != 0L) {
            var5 += ((HospitalisationCaution)this.lesCaution.get(var7)).getHoscauMontant();
         }
      }

      if (var3 != 0.0D) {
         for(var7 = 0; var7 < this.lesReglServices.size(); ++var7) {
            if (((ObjetTarif)this.lesReglServices.get(var7)).getType() == 3 && ((ObjetTarif)this.lesReglServices.get(var7)).getPrix() != 0.0D && ((ObjetTarif)this.lesReglServices.get(var7)).getIdSejour() == var1) {
               var3 += ((ObjetTarif)this.lesReglServices.get(var7)).getPrix();
            }
         }

         this.totalPaye = var3;
         this.var_affiche_valide = true;
      } else {
         boolean var9 = true;

         int var8;
         for(var8 = 0; var8 < this.lesReglServices.size(); ++var8) {
            if (((ObjetTarif)this.lesReglServices.get(var8)).getType() != 9 && ((ObjetTarif)this.lesReglServices.get(var8)).getType() != 10 && ((ObjetTarif)this.lesReglServices.get(var8)).getDejaPaye() != 0.0D) {
               var9 = false;
               break;
            }
         }

         if (this.lesReglServices.size() != 0) {
            for(var8 = 0; var8 < this.lesReglServices.size(); ++var8) {
               if (((ObjetTarif)this.lesReglServices.get(var8)).getType() != 9 && ((ObjetTarif)this.lesReglServices.get(var8)).getType() != 10) {
                  this.var_netAPayer = this.var_netAPayer + ((ObjetTarif)this.lesReglServices.get(var8)).getDejaPaye() + ((ObjetTarif)this.lesReglServices.get(var8)).getPrix() + ((ObjetTarif)this.lesReglServices.get(var8)).getSolde();
                  if (this.balanceFinale) {
                     this.totalReglement += ((ObjetTarif)this.lesReglServices.get(var8)).getDejaPaye();
                  } else {
                     this.totalPaye += ((ObjetTarif)this.lesReglServices.get(var8)).getPrix();
                     this.totalReglement += ((ObjetTarif)this.lesReglServices.get(var8)).getDejaPaye();
                  }
               } else if (this.balanceFinale) {
                  if (var9) {
                     this.totalReglement += ((ObjetTarif)this.lesReglServices.get(var8)).getDejaPaye();
                  }
               } else {
                  this.totalReglement += ((ObjetTarif)this.lesReglServices.get(var8)).getDejaPaye();
               }
            }
         }

         if (!this.balanceFinale) {
            this.totalSolde = this.var_netAPayer - this.totalReglement - this.totalPaye;
         } else {
            if (this.var_netAPayer < this.totalReglement) {
               this.totalPaye = this.var_netAPayer - this.totalReglement;
            } else if (this.var_netAPayer > this.totalReglement) {
               this.totalPaye = 0.0D;

               for(var8 = 0; var8 < this.lesReglServices.size(); ++var8) {
                  this.objetTarif = (ObjetTarif)this.lesReglServices.get(var8);
                  if (this.objetTarif.getType() != 9 && this.objetTarif.getType() != 10 && this.objetTarif.getSolde() != 0.0D) {
                     this.objetTarif.setPrix(this.objetTarif.getPrix() + this.objetTarif.getSolde());
                     this.objetTarif.setSolde(0.0D);
                     this.objetTarif.setSaisieInterdit(true);
                  }
               }

               this.totalPaye = this.var_netAPayer - this.totalReglement;
            } else {
               this.totalPaye = 0.0D;
            }

            this.totalSolde = 0.0D;
         }

         this.verifBonEncaissement();
      }

   }

   public void calculeSoldeFinal() {
      double var1 = this.totalPaye;
      this.calculSoldeTotal();
      this.totalPaye = var1;
      this.totalSolde = this.var_netAPayer - this.totalReglement - this.totalPaye;
      this.verifBonEncaissement();
      double var3 = this.totalReglement + this.totalPaye;
      double var5 = this.totalPaye;
      boolean var7 = false;

      int var8;
      for(var8 = 0; var8 < this.lesReglServices.size(); ++var8) {
         if (((ObjetTarif)this.lesReglServices.get(var8)).getType() != 9 && ((ObjetTarif)this.lesReglServices.get(var8)).getType() != 10 && ((ObjetTarif)this.lesReglServices.get(var8)).getDejaPaye() != 0.0D) {
            var7 = true;
            break;
         }
      }

      for(var8 = 0; var8 < this.lesReglServices.size(); ++var8) {
         this.objetTarif = (ObjetTarif)this.lesReglServices.get(var8);
         if (this.objetTarif.getType() != 9 && this.objetTarif.getType() != 10) {
            double var9 = this.objetTarif.getTotalService() - this.objetTarif.getDejaPaye();
            if (var9 != 0.0D) {
               if (this.objetTarif.getDejaPaye() == 0.0D && !var7) {
                  if (var9 < var3) {
                     this.objetTarif.setPrix(var9);
                     var3 -= var9;
                     if (var3 < 0.0D) {
                        var3 = 0.0D;
                     }
                  } else {
                     this.objetTarif.setPrix(var3);
                     var3 = 0.0D;
                  }
               } else {
                  var7 = true;
                  if (this.objetTarif.getPrix() > var5) {
                     this.objetTarif.setPrix(var5);
                     var5 = 0.0D;
                  } else {
                     var5 -= this.objetTarif.getPrix();
                     if (var5 < 0.0D) {
                        var5 = 0.0D;
                     }
                  }
               }

               this.objetTarif.setSolde(this.objetTarif.getTotalService() - this.objetTarif.getDejaPaye() - this.objetTarif.getPrix());
            }

            this.objetTarif.setSaisieInterdit(true);
         }
      }

   }

   public void annulePaye() {
      this.showModalPanelBonEncaissement = false;
   }

   public void chargerModReg() throws HibernateException, NamingException {
      if (this.hospitalisationEntete.getHosTypeReg() != 12 && (this.var_modereg == null || this.var_modereg.isEmpty() || !this.var_modereg.startsWith("12:"))) {
         this.montantElmTotBonEnc = this.var_netAPayer;
         this.montantElmTotReliquat = 0.0D;
      } else {
         new PatientLettreGarantie();
         PatientLettreGarantieDao var2 = new PatientLettreGarantieDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var3 = var2.chargerLesLettresByPatients(this.patients, 1, 0, (Session)null);
         if (var3.size() != 0) {
            this.numLettreGarantie = "";
            PatientLettreGarantie var1 = (PatientLettreGarantie)var3.get(0);
            this.numLettreGarantie = var1.getPatlgaNum();
            if (this.montantElmTotBonEnc <= var1.getPatlgaSolde()) {
               this.montantElmTotReliquat = 0.0D;
            } else {
               this.montantElmTotReliquat = this.montantElmTotBonEnc - var1.getPatlgaSolde();
               this.montantElmTotBonEnc = var1.getPatlgaSolde();
            }
         }
      }

      this.var_affichMontant = true;
   }

   public void miseajourPaye() throws HibernateException, NamingException {
      if (this.totalPaye != 0.0D) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            long var3 = 0L;
            double var5 = 0.0D;

            for(int var7 = 0; var7 < this.lesCaution.size(); ++var7) {
               if (((HospitalisationCaution)this.lesCaution.get(var7)).getHoscauIdRecu() == 0L && ((HospitalisationCaution)this.lesCaution.get(var7)).getHoscauMontant() != 0.0D) {
                  var3 = ((HospitalisationCaution)this.lesCaution.get(var7)).getHoscauId();
                  var5 = ((HospitalisationCaution)this.lesCaution.get(var7)).getHoscauMontant();
                  break;
               }
            }

            this.generationBonEncaissement(var3, var5, var1);
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

      if (this.lesHospitalisationEntete.size() != 0) {
         this.lesHospitalisationEntete.remove(this.hospitalisationEntete);
         this.datamodelHospitalisation.setWrappedData(this.lesHospitalisationEntete);
      }

      this.showModalPanelBonEncaissement = false;
      this.visibiliteBton = false;
   }

   public void generationBonEncaissement(long var1, double var3, Session var5) throws HibernateException, NamingException {
      String var6 = this.calculChrono.numCompose(new Date(), 79, this.hospitalisationEntete.getHosSerie(), var5);
      if (var6 != null && !var6.isEmpty()) {
         if (this.totalPaye != 0.0D) {
            this.bonEncaissementVente = this.bonEncaissementVenteDao.selectBeByDoc(this.hospitalisationEntete.getHosId(), 76, var5);
            if (this.bonEncaissementVente != null) {
               this.bonEncaissementVenteDao.delete(this.bonEncaissementVente, var5);
            }

            String var7 = null;
            String var8 = null;
            if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
               String[] var9 = this.var_inputCaisse.split(":");
               var7 = var9[0];
               var8 = var9[1];
            }

            this.bonEncaissementVente = new BonEncaissementVente();
            this.bonEncaissementVente.setBonDateCreat(new Date());
            this.bonEncaissementVente.setBonCodeCaisse(var7);
            this.bonEncaissementVente.setBonLibCaisse(var8);
            this.bonEncaissementVente.setBonUserCreat(this.usersLog.getUsrid());
            this.bonEncaissementVente.setBonGrp(this.usersLog.getUsrCollaboration());
            this.bonEncaissementVente.setBonActivite("");
            this.bonEncaissementVente.setBonSite("");
            this.bonEncaissementVente.setBonDepartement("");
            this.bonEncaissementVente.setBonService("");
            this.bonEncaissementVente.setBonRegion("");
            this.bonEncaissementVente.setBonSecteur("");
            this.bonEncaissementVente.setBonPdv("");
            this.bonEncaissementVente.setBonDateEcheReg((Date)null);
            this.bonEncaissementVente.setBonEtat(0);
            this.bonEncaissementVente.setBonNatRef(this.nature);
            this.bonEncaissementVente.setBonNomTiers(this.hospitalisationEntete.getHosNomPatient());
            this.bonEncaissementVente.setBonIdTiers(this.hospitalisationEntete.getPatients().getPatId());
            this.bonEncaissementVente.setBonNomContact("");
            this.bonEncaissementVente.setBonLettreGarantie(this.numLettreGarantie);
            this.bonEncaissementVente.setBonIdContact(0L);
            this.bonEncaissementVente.setBonTypeTiers(4);
            if (var1 != 0L) {
               this.bonEncaissementVente.setBonLibelle("Règlement caution Hospitalisation N° " + this.hospitalisationEntete.getHosNum());
            } else {
               this.bonEncaissementVente.setBonLibelle("Règlement Hospitalisation N° " + this.hospitalisationEntete.getHosNum());
            }

            if (this.totalPaye < 0.0D) {
               this.bonEncaissementVente.setBonLibelle("Remboursement caution Hospitalisation N° " + this.hospitalisationEntete.getHosNum());
            }

            this.bonEncaissementVente.setBonRef(this.hospitalisationEntete.getHosNum());
            this.bonEncaissementVente.setBonIdRef(this.hospitalisationEntete.getHosId());
            this.bonEncaissementVente.setBonObject("");
            this.bonEncaissementVente.setBonObservation("");
            this.bonEncaissementVente.setBonSerie(this.hospitalisationEntete.getHosSerie());
            this.bonEncaissementVente.setBonDevise(this.structureLog.getStrdevise());
            this.bonEncaissementVente.setBonTotTtc(this.hospitalisationEntete.getTotalPatient());
            this.bonEncaissementVente.setBonAPayer(this.totalPaye);
            this.bonEncaissementVente.setBonTypeReg(this.hospitalisationEntete.getHosTypeReg());
            this.bonEncaissementVente.setBonActif(0);
            this.bonEncaissementVente.setBonNum(var6);
            this.bonEncaissementVente.setBonDate(this.var_date);
            this.bonEncaissementVente.setBonIdResponsable(this.hospitalisationEntete.getHosIdMedecin());
            this.bonEncaissementVente.setBonNomResponsable(this.hospitalisationEntete.getHosMedecin());
            this.bonEncaissementVente.setBonIdCommercial(this.hospitalisationEntete.getHosIdCreateur());
            this.bonEncaissementVente.setBonNomCommercial(this.hospitalisationEntete.getHosNomCreateur());
            this.bonEncaissementVente.setBonIdEquipe(var1);
            this.bonEncaissementVente.setBonNomEquipe("");
            this.bonEncaissementVente.setBonClient("");
            this.bonEncaissementVente.setBonFacture("");
            this.bonEncaissementVente.setBonMontant("");
            this.bonEncaissementVenteDao.insert(this.bonEncaissementVente, var5);
         }

         if (this.lesReglServices.size() != 0) {
            for(int var12 = 0; var12 < this.lesReglServices.size(); ++var12) {
               this.objetTarif = (ObjetTarif)this.lesReglServices.get(var12);
               boolean var13;
               int var14;
               if (this.objetTarif.getPrix() != 0.0D) {
                  var13 = false;
                  if (this.lesReglements.size() != 0) {
                     for(var14 = 0; var14 < this.lesReglements.size(); ++var14) {
                        this.hospitalisationReglement = (HospitalisationReglement)this.lesReglements.get(var14);
                        if (this.hospitalisationReglement.getHosregEtat() == 0 && this.objetTarif.getIdSejour() == this.hospitalisationReglement.getHosregIdSejour() && this.objetTarif.getNomService().equals(this.hospitalisationReglement.getHosregService()) && this.objetTarif.getIdLaboratoire() == this.hospitalisationReglement.getHosregIdLaboratoire()) {
                           var13 = true;
                           break;
                        }
                     }
                  }

                  if (!var13) {
                     this.hospitalisationReglement = new HospitalisationReglement();
                     this.hospitalisationReglement.setHospitalisationEntete(this.hospitalisationEntete);
                     this.hospitalisationReglement.setHosregAssurance(0.0D);
                     this.hospitalisationReglement.setHosregCaisse("");
                     this.hospitalisationReglement.setHosregComplementaire(0.0D);
                     this.hospitalisationReglement.setHosregDate(this.var_date);
                     this.hospitalisationReglement.setHosregEtat(0);
                     this.hospitalisationReglement.setHosregIdLaboratoire(this.objetTarif.getIdLaboratoire());
                     this.hospitalisationReglement.setHosregIdRecu(0L);
                     this.hospitalisationReglement.setHosregIdCaution(var1);
                     this.hospitalisationReglement.setHosregIdSejour(this.objetTarif.getIdSejour());
                     this.hospitalisationReglement.setHosregLaboratoire(this.objetTarif.getNomLaboratoire());
                     this.hospitalisationReglement.setHosregPatient(this.objetTarif.getPrix());
                     this.hospitalisationReglement.setHosregService(this.objetTarif.getNomService());
                     this.hospitalisationReglement.setHosregProduit(this.objetTarif.getNomProduit());
                     this.hospitalisationReglement.setHosregSociete(0.0D);
                     this.hospitalisationReglement.setHosregIdBonEncaissement(this.bonEncaissementVente.getBonId());
                     this.hospitalisationReglement = this.hospitalisationReglementDao.insert(this.hospitalisationReglement, var5);
                  } else {
                     this.hospitalisationReglement.setHosregPatient(this.objetTarif.getPrix());
                     this.hospitalisationReglement.setHosregIdBonEncaissement(this.bonEncaissementVente.getBonId());
                     this.hospitalisationReglement = this.hospitalisationReglementDao.modif(this.hospitalisationReglement, var5);
                  }

                  int var11;
                  double var15;
                  if (var1 == 0L) {
                     if (this.objetTarif.getType() == 0) {
                        if (this.lesSejours.size() != 0) {
                           var15 = this.objetTarif.getPrix();

                           for(var11 = 0; var11 < this.lesSejours.size(); ++var11) {
                              this.hospitalisationSejour = (HospitalisationSejour)this.lesSejours.get(var11);
                              if (this.hospitalisationSejour.getHossejId() == this.objetTarif.getIdSejour() && this.hospitalisationSejour.getHossejPatientHt() + this.hospitalisationSejour.getHossejPatientTaxe() < this.hospitalisationSejour.getHossejRegPatient()) {
                                 if (this.hospitalisationSejour.getHossejPatientHt() + this.hospitalisationSejour.getHossejPatientTaxe() - this.hospitalisationSejour.getHossejRegPatient() <= var15) {
                                    this.hospitalisationSejour.setHossejRegPatient(this.hospitalisationSejour.getHossejPatientHt() + this.hospitalisationSejour.getHossejPatientTaxe() - this.hospitalisationSejour.getHossejRegPatient());
                                 } else {
                                    if (var15 < 0.0D) {
                                       var15 = 0.0D;
                                    }

                                    this.hospitalisationSejour.setHossejRegPatient(var15);
                                 }

                                 this.hospitalisationSejour = this.hospitalisationSejourDao.modif(this.hospitalisationSejour, var5);
                                 var15 -= this.hospitalisationMedi.getHosmedRegPatient();
                              }
                           }
                        }
                     } else if (this.objetTarif.getType() == 1) {
                        if (this.lesActes.size() != 0) {
                           var15 = this.objetTarif.getPrix();

                           for(var11 = 0; var11 < this.lesActes.size(); ++var11) {
                              this.hospitalisationActes = (HospitalisationActes)this.lesActes.get(var11);
                              if (this.hospitalisationActes.getHosactIdSejour() == this.objetTarif.getIdSejour() && this.hospitalisationActes.getHosactPatientHt() + this.hospitalisationActes.getHosactPatientTaxe() < this.hospitalisationActes.getHosactRegPatient()) {
                                 if (this.hospitalisationActes.getHosactPatientHt() + this.hospitalisationActes.getHosactPatientTaxe() - this.hospitalisationActes.getHosactRegPatient() <= var15) {
                                    this.hospitalisationActes.setHosactRegPatient(this.hospitalisationActes.getHosactPatientHt() + this.hospitalisationActes.getHosactPatientTaxe() - this.hospitalisationActes.getHosactRegPatient());
                                 } else {
                                    if (var15 < 0.0D) {
                                       var15 = 0.0D;
                                    }

                                    this.hospitalisationActes.setHosactRegPatient(var15);
                                 }

                                 this.hospitalisationActes = this.hospitalisationActesDao.modif(this.hospitalisationActes, var5);
                                 var15 -= this.hospitalisationMedi.getHosmedRegPatient();
                              }
                           }
                        }
                     } else if (this.objetTarif.getType() == 2) {
                        if (this.lesLabos.size() != 0) {
                           var15 = this.objetTarif.getPrix();

                           for(var11 = 0; var11 < this.lesLabos.size(); ++var11) {
                              this.hospitalisationLabo = (HospitalisationLabo)this.lesLabos.get(var11);
                              if (this.hospitalisationLabo.getHoslabIdSejour() == this.objetTarif.getIdSejour() && this.hospitalisationLabo.getHoslabPatientHt() + this.hospitalisationLabo.getHoslabPatientTaxe() < this.hospitalisationLabo.getHoslabRegPatient()) {
                                 if (this.hospitalisationLabo.getHoslabPatientHt() + this.hospitalisationLabo.getHoslabPatientTaxe() - this.hospitalisationLabo.getHoslabRegPatient() <= var15) {
                                    this.hospitalisationLabo.setHoslabRegPatient(this.hospitalisationLabo.getHoslabPatientHt() + this.hospitalisationLabo.getHoslabPatientTaxe() - this.hospitalisationLabo.getHoslabRegPatient());
                                 } else {
                                    if (var15 < 0.0D) {
                                       var15 = 0.0D;
                                    }

                                    this.hospitalisationLabo.setHoslabRegPatient(var15);
                                 }

                                 this.hospitalisationLabo = this.hospitalisationLaboDao.modif(this.hospitalisationLabo, var5);
                                 var15 -= this.hospitalisationMedi.getHosmedRegPatient();
                              }
                           }
                        }
                     } else if (this.objetTarif.getType() == 3) {
                        if (this.lesMedis.size() != 0) {
                           var15 = this.objetTarif.getPrix();

                           for(var11 = 0; var11 < this.lesMedis.size(); ++var11) {
                              this.hospitalisationMedi = (HospitalisationMedi)this.lesMedis.get(var11);
                              if (this.hospitalisationMedi.getHosmedIdSejour() == this.objetTarif.getIdSejour() && this.hospitalisationMedi.getHosmedPatientHt() + this.hospitalisationMedi.getHosmedPatientTaxe() < this.hospitalisationMedi.getHosmedRegPatient()) {
                                 if (this.hospitalisationMedi.getHosmedPatientHt() + this.hospitalisationMedi.getHosmedPatientTaxe() - this.hospitalisationMedi.getHosmedRegPatient() <= var15) {
                                    this.hospitalisationMedi.setHosmedRegPatient(this.hospitalisationMedi.getHosmedPatientHt() + this.hospitalisationMedi.getHosmedPatientTaxe() - this.hospitalisationMedi.getHosmedRegPatient());
                                 } else {
                                    if (var15 < 0.0D) {
                                       var15 = 0.0D;
                                    }

                                    this.hospitalisationMedi.setHosmedRegPatient(var15);
                                 }

                                 this.hospitalisationMedi = this.hospitalisationMediDao.modif(this.hospitalisationMedi, var5);
                                 var15 -= this.hospitalisationMedi.getHosmedRegPatient();
                              }
                           }
                        }
                     } else if (this.objetTarif.getType() == 4 && this.lesPrests.size() != 0) {
                        var15 = this.objetTarif.getPrix();

                        for(var11 = 0; var11 < this.lesPrests.size(); ++var11) {
                           this.hospitalisationPrest = (HospitalisationPrest)this.lesPrests.get(var11);
                           if (this.hospitalisationPrest.getHosprtIdSejour() == this.objetTarif.getIdSejour() && this.hospitalisationPrest.getHosprtPatientHt() + this.hospitalisationPrest.getHosprtPatientTaxe() < this.hospitalisationPrest.getHosprtRegPatient()) {
                              if (this.hospitalisationPrest.getHosprtPatientHt() + this.hospitalisationPrest.getHosprtPatientTaxe() - this.hospitalisationPrest.getHosprtRegPatient() <= var15) {
                                 this.hospitalisationPrest.setHosprtRegPatient(this.hospitalisationPrest.getHosprtPatientHt() + this.hospitalisationPrest.getHosprtPatientTaxe() - this.hospitalisationPrest.getHosprtRegPatient());
                              } else {
                                 if (var15 < 0.0D) {
                                    var15 = 0.0D;
                                 }

                                 this.hospitalisationPrest.setHosprtRegPatient(var15);
                              }

                              this.hospitalisationPrest = this.hospitalisationPrestDao.modif(this.hospitalisationPrest, var5);
                              var15 -= this.hospitalisationMedi.getHosmedRegPatient();
                           }
                        }
                     }
                  } else if (this.objetTarif.getType() == 3 && this.lesMedis.size() != 0) {
                     var15 = this.objetTarif.getPrix();

                     for(var11 = 0; var11 < this.lesMedis.size(); ++var11) {
                        this.hospitalisationMedi = (HospitalisationMedi)this.lesMedis.get(var11);
                        if (this.hospitalisationMedi.getHosmedIdSejour() == this.objetTarif.getIdSejour() && this.hospitalisationMedi.getHosmedPatientHt() + this.hospitalisationMedi.getHosmedPatientTaxe() < this.hospitalisationMedi.getHosmedRegPatient()) {
                           if (this.hospitalisationMedi.getHosmedPatientHt() + this.hospitalisationMedi.getHosmedPatientTaxe() - this.hospitalisationMedi.getHosmedRegPatient() <= var15) {
                              this.hospitalisationMedi.setHosmedRegPatient(this.hospitalisationMedi.getHosmedPatientHt() + this.hospitalisationMedi.getHosmedPatientTaxe() - this.hospitalisationMedi.getHosmedRegPatient());
                           } else {
                              if (var15 < 0.0D) {
                                 var15 = 0.0D;
                              }

                              this.hospitalisationMedi.setHosmedRegPatient(var15);
                           }

                           this.hospitalisationMedi = this.hospitalisationMediDao.modif(this.hospitalisationMedi, var5);
                           var15 -= this.hospitalisationMedi.getHosmedRegPatient();
                        }
                     }
                  }
               } else {
                  var13 = false;
                  if (this.lesReglements.size() != 0) {
                     for(var14 = 0; var14 < this.lesReglements.size(); ++var14) {
                        this.hospitalisationReglement = (HospitalisationReglement)this.lesReglements.get(var14);
                        if (this.hospitalisationReglement.getHosregEtat() == 0 && this.objetTarif.getNomService().equals(this.hospitalisationReglement.getHosregService()) && this.objetTarif.getIdLaboratoire() == this.hospitalisationReglement.getHosregIdLaboratoire()) {
                           var13 = true;
                           break;
                        }
                     }
                  }

                  if (var13 && this.hospitalisationReglement != null) {
                     this.hospitalisationReglementDao.delete(this.hospitalisationReglement, var5);
                  }

                  if (this.objetTarif.getType() != 0 && this.objetTarif.getType() != 1 && this.objetTarif.getType() != 2 && this.objetTarif.getType() != 3 && this.objetTarif.getType() == 4) {
                  }
               }
            }
         }
      } else {
         this.formRecherche.setMessageTexte("Le chrono du bon d`encaissement n`a pas été calculé. Peut être est-ce une question d'autorisation. Contactez votre administrateur pour plus d`informations.");
         this.formRecherche.setShowModalPanelMessage(true);
      }

   }

   public void histoReglement() {
      if (this.hospitalisationEntete != null) {
         this.showModalPanelHistoReglement = true;
      }

   }

   public void fermerHistoReglement() {
      this.showModalPanelHistoReglement = false;
   }

   public void ajouterDocumentScan() {
      this.uploadedPDFFile = null;
      this.nomDocument = "";
      this.showModalPanelAjoutFile = true;
   }

   public void annulerDocumentScan() {
      this.showModalPanelAjoutFile = false;
   }

   public void validerDocumentScan() {
      if (this.hospitalisationEntete != null && this.uploadedPDFFile != null) {
         File var1 = new File(this.nomRepertoire + this.hospitalisationEntete.getHosNum());
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
               var3 = "H_" + this.hospitalisationEntete.getHosNum().replace("/", "_") + "_" + this.filtreCaracteres(this.nomDocument) + "." + var4;
            } else {
               var3 = "H_" + this.hospitalisationEntete.getHosNum().replace("/", "_") + "." + var4;
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
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "hospitalisation" + File.separator;
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatHospitalisation.jpg");
            if (var4.exists()) {
               var3 = "formatHospitalisation.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatHospitalisation.jpg");
         if (var4.exists()) {
            var3 = "formatHospitalisation.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun(String var1) throws IOException, HibernateException, NamingException {
      ArrayList var2 = new ArrayList();
      int var3;
      if (this.lesSejours.size() != 0) {
         for(var3 = 0; var3 < this.lesSejours.size(); ++var3) {
            this.hospitalisationSejour = (HospitalisationSejour)this.lesSejours.get(var3);
            this.calculeLibelleDiagnostic((Session)null);
            String var4 = "";
            String var5 = "";
            String var6 = "";
            String var7 = "";
            String var8 = "";
            if (var1.equals("RSS_RUM")) {
               int var9;
               String var10;
               if (this.lesPatientAntecedent.size() != 0) {
                  for(var9 = 0; var9 < this.lesPatientAntecedent.size(); ++var9) {
                     var10 = ((PatientAnt)this.lesPatientAntecedent.get(var9)).getPatantCode() + " " + ((PatientAnt)this.lesPatientAntecedent.get(var9)).getPatantFamille() + " " + this.utilDate.dateToStringFr(((PatientAnt)this.lesPatientAntecedent.get(var9)).getPatantDate()) + "  " + ((PatientAnt)this.lesPatientAntecedent.get(var9)).getPatantObservation();
                     if (var4 != null && !var4.isEmpty()) {
                        var4 = var4 + "\n" + var10;
                     } else {
                        var4 = var10;
                     }
                  }
               }

               this.hospitalisationSejour.setAntecedent(var4);
               if (this.lesActes.size() != 0) {
                  for(var9 = 0; var9 < this.lesActes.size(); ++var9) {
                     var10 = ((HospitalisationActes)this.lesActes.get(var9)).getHosactProduit() + " " + ((HospitalisationActes)this.lesActes.get(var9)).getHosactLibelle();
                     if (var5 != null && !var5.isEmpty()) {
                        var5 = var5 + "\n" + var10;
                     } else {
                        var5 = var10;
                     }
                  }
               }

               if (this.lesLabos.size() != 0) {
                  for(var9 = 0; var9 < this.lesLabos.size(); ++var9) {
                     var10 = ((HospitalisationLabo)this.lesLabos.get(var9)).getHoslabProduit() + " " + ((HospitalisationLabo)this.lesLabos.get(var9)).getHoslabLibelle();
                     if (var5 != null && !var5.isEmpty()) {
                        var5 = var5 + "\n" + var10;
                     } else {
                        var5 = var10;
                     }
                  }
               }

               this.hospitalisationSejour.setExamensComplementaires(var5);
               if (this.lesMedis.size() != 0) {
                  for(var9 = 0; var9 < this.lesMedis.size(); ++var9) {
                     var10 = ((HospitalisationMedi)this.lesMedis.get(var9)).getHosmedProduit() + " " + ((HospitalisationMedi)this.lesMedis.get(var9)).getHosmedLibelle();
                     if (var6 != null && !var6.isEmpty()) {
                        var6 = var6 + "\n" + var10;
                     } else {
                        var6 = var10;
                     }
                  }
               }

               this.hospitalisationSejour.setMedicaments(var6);
               this.hospitalisationSejour.setEvolution(var7);
               this.hospitalisationSejour.setObservationsComplementaires(var8);
            }

            this.hospitalisationSejour.setType(1);
            var2.add(this.hospitalisationSejour);
         }
      }

      HospitalisationSejour var11;
      String[] var12;
      if (var1.equals("FactureHospitalisation") || var1.equals("FactureBalanceFinale")) {
         var2.clear();
         if (this.lesSejours.size() != 0) {
            for(var3 = 0; var3 < this.lesSejours.size(); ++var3) {
               this.hospitalisationSejour = (HospitalisationSejour)this.lesSejours.get(var3);
               var11 = new HospitalisationSejour();
               var11.setHospitalisationEntete(this.hospitalisationEntete);
               var11.setType(1);
               var11.setDate(this.hospitalisationSejour.getHossejDateCreat());
               var11.setCode(this.hospitalisationSejour.getHossejLit());
               var11.setLibelle(this.hospitalisationSejour.getHossejLibelle());
               var11.setLettre("");
               var11.setValeur(0.0D);
               if (this.hospitalisationSejour.getHossejDateSortie() != null) {
                  var11.setQte((float)this.hospitalisationSejour.getHossejNbJour());
               } else {
                  var11.setQte((float)this.hospitalisationSejour.getHossejNbJourTheo());
               }

               if (this.hospitalisationSejour.getHossejService() != null && !this.hospitalisationSejour.getHossejService().isEmpty() && this.hospitalisationSejour.getHossejService().contains(":")) {
                  var12 = this.hospitalisationSejour.getHossejService().split(":");
                  var11.setService(var12[1]);
               } else {
                  var11.setService(this.hospitalisationSejour.getHossejService());
               }

               var11.setMedecin(this.hospitalisationSejour.getHossejMedecin());
               var11.setPu(this.hospitalisationSejour.getHossejPu());
               var11.setPt(this.hospitalisationSejour.getHossejPatientHt() + this.hospitalisationSejour.getHossejPatientTaxe());
               var11.setPt_tiers(this.hospitalisationSejour.getHossejAssuranceHt() + this.hospitalisationSejour.getHossejAssuranceTaxe() + this.hospitalisationSejour.getHossejComplementaireHt() + this.hospitalisationSejour.getHossejComplementaireTaxe() + this.hospitalisationSejour.getHossejSocieteHt() + this.hospitalisationSejour.getHossejSocieteTaxe());
               var11.setReg_pat(0.0D);
               var2.add(var11);
            }
         }

         if (this.lesActes.size() != 0) {
            for(var3 = 0; var3 < this.lesActes.size(); ++var3) {
               this.hospitalisationActes = (HospitalisationActes)this.lesActes.get(var3);
               var11 = new HospitalisationSejour();
               var11.setHospitalisationEntete(this.hospitalisationEntete);
               var11.setType(2);
               var11.setDate(this.hospitalisationActes.getHosactDateCreat());
               var11.setCode(this.hospitalisationActes.getHosactProduit());
               var11.setLibelle(this.hospitalisationActes.getHosactLibelle());
               var11.setLettre(this.hospitalisationActes.getHosactLettre());
               var11.setValeur(this.hospitalisationActes.getHosactValeur());
               if (this.hospitalisationActes.getHosactService() != null && !this.hospitalisationActes.getHosactService().isEmpty() && this.hospitalisationActes.getHosactService().contains(":")) {
                  var12 = this.hospitalisationActes.getHosactService().split(":");
                  var11.setService(var12[1]);
               } else {
                  var11.setService(this.hospitalisationActes.getHosactService());
               }

               var11.setMedecin(this.hospitalisationActes.getHosactMedecin());
               var11.setQte(this.hospitalisationActes.getHosactQte());
               var11.setPu(this.hospitalisationActes.getHosactPu());
               var11.setPt(this.hospitalisationActes.getHosactPatientHt() + this.hospitalisationActes.getHosactPatientTaxe());
               var11.setPt_tiers(this.hospitalisationActes.getHosactAssuranceHt() + this.hospitalisationActes.getHosactAssuranceTaxe() + this.hospitalisationActes.getHosactComplementaireHt() + this.hospitalisationActes.getHosactComplementaireTaxe() + this.hospitalisationActes.getHosactSocieteHt() + this.hospitalisationActes.getHosactSocieteTaxe());
               var11.setReg_pat(0.0D);
               var2.add(var11);
            }
         }

         if (this.lesLabos.size() != 0) {
            for(var3 = 0; var3 < this.lesLabos.size(); ++var3) {
               this.hospitalisationLabo = (HospitalisationLabo)this.lesLabos.get(var3);
               var11 = new HospitalisationSejour();
               var11.setHospitalisationEntete(this.hospitalisationEntete);
               var11.setType(3);
               var11.setDate(this.hospitalisationLabo.getHoslabDateCreat());
               var11.setCode(this.hospitalisationLabo.getHoslabProduit());
               if (this.hospitalisationLabo.getHoslabLaboratoire() != null && !this.hospitalisationLabo.getHoslabLaboratoire().isEmpty() && this.hospitalisationLabo.getHoslabLaboratoire().contains(":")) {
                  var12 = this.hospitalisationLabo.getHoslabLaboratoire().split(":");
                  var11.setLibelle("(" + var12[1] + ") " + this.hospitalisationLabo.getHoslabLibelle());
               } else {
                  var11.setLibelle("(" + this.hospitalisationLabo.getHoslabLaboratoire() + ") " + this.hospitalisationLabo.getHoslabLibelle());
               }

               var11.setLettre(this.hospitalisationLabo.getHoslabLettre());
               var11.setValeur(this.hospitalisationLabo.getHoslabValeur());
               if (this.hospitalisationLabo.getHoslabService() != null && !this.hospitalisationLabo.getHoslabService().isEmpty() && this.hospitalisationLabo.getHoslabService().contains(":")) {
                  var12 = this.hospitalisationLabo.getHoslabService().split(":");
                  var11.setService(var12[1]);
               } else {
                  var11.setService(this.hospitalisationLabo.getHoslabService());
               }

               var11.setMedecin(this.hospitalisationLabo.getHoslabMedecin());
               var11.setQte(this.hospitalisationLabo.getHoslabQte());
               var11.setPu(this.hospitalisationLabo.getHoslabPu());
               var11.setPt(this.hospitalisationLabo.getHoslabPatientHt() + this.hospitalisationLabo.getHoslabPatientTaxe());
               var11.setPt_tiers(this.hospitalisationLabo.getHoslabAssuranceHt() + this.hospitalisationLabo.getHoslabAssuranceTaxe() + this.hospitalisationLabo.getHoslabComplementaireHt() + this.hospitalisationLabo.getHoslabComplementaireTaxe() + this.hospitalisationLabo.getHoslabSocieteHt() + this.hospitalisationLabo.getHoslabSocieteTaxe());
               var11.setReg_pat(0.0D);
               var2.add(var11);
            }
         }

         if (this.lesMedis.size() != 0) {
            for(var3 = 0; var3 < this.lesMedis.size(); ++var3) {
               this.hospitalisationMedi = (HospitalisationMedi)this.lesMedis.get(var3);
               var11 = new HospitalisationSejour();
               var11.setHospitalisationEntete(this.hospitalisationEntete);
               var11.setType(4);
               var11.setDate(this.hospitalisationMedi.getHosmedDateCreat());
               var11.setCode(this.hospitalisationMedi.getHosmedProduit());
               var11.setLibelle(this.hospitalisationMedi.getHosmedLibelle());
               var11.setLettre("");
               var11.setValeur(0.0D);
               if (this.hospitalisationMedi.getHosmedService() != null && !this.hospitalisationMedi.getHosmedService().isEmpty() && this.hospitalisationMedi.getHosmedService().contains(":")) {
                  var12 = this.hospitalisationMedi.getHosmedService().split(":");
                  var11.setService(var12[1]);
               } else {
                  var11.setService(this.hospitalisationMedi.getHosmedService());
               }

               var11.setMedecin(this.hospitalisationMedi.getHosmedMedecin());
               var11.setQte(this.hospitalisationMedi.getHosmedQte());
               var11.setPu(this.hospitalisationMedi.getHosmedPu());
               var11.setPt(this.hospitalisationMedi.getHosmedPatientHt() + this.hospitalisationMedi.getHosmedPatientTaxe());
               var11.setPt_tiers(this.hospitalisationMedi.getHosmedAssuranceHt() + this.hospitalisationMedi.getHosmedAssuranceTaxe() + this.hospitalisationMedi.getHosmedComplementaireHt() + this.hospitalisationMedi.getHosmedComplementaireTaxe() + this.hospitalisationMedi.getHosmedSocieteHt() + this.hospitalisationMedi.getHosmedSocieteTaxe());
               var11.setReg_pat(0.0D);
               var2.add(var11);
            }
         }

         if (this.lesPrests.size() != 0) {
            for(var3 = 0; var3 < this.lesPrests.size(); ++var3) {
               this.hospitalisationPrest = (HospitalisationPrest)this.lesPrests.get(var3);
               var11 = new HospitalisationSejour();
               var11.setHospitalisationEntete(this.hospitalisationEntete);
               var11.setType(5);
               var11.setDate(this.hospitalisationPrest.getHosprtDateCreat());
               var11.setCode(this.hospitalisationPrest.getHosprtProduit());
               var11.setLibelle(this.hospitalisationPrest.getHosprtLibelle());
               var11.setLettre(this.hospitalisationPrest.getHosprtLettre());
               var11.setValeur(this.hospitalisationPrest.getHosprtValeur());
               if (this.hospitalisationPrest.getHosprtService() != null && !this.hospitalisationPrest.getHosprtService().isEmpty() && this.hospitalisationPrest.getHosprtService().contains(":")) {
                  var12 = this.hospitalisationPrest.getHosprtService().split(":");
                  var11.setService(var12[1]);
               } else {
                  var11.setService(this.hospitalisationPrest.getHosprtService());
               }

               var11.setMedecin(this.hospitalisationPrest.getHosprtMedecin());
               var11.setQte(this.hospitalisationPrest.getHosprtQte());
               var11.setPu(this.hospitalisationPrest.getHosprtPu());
               var11.setPt(this.hospitalisationPrest.getHosprtPatientHt() + this.hospitalisationPrest.getHosprtPatientTaxe());
               var11.setPt_tiers(this.hospitalisationPrest.getHosprtAssuranceHt() + this.hospitalisationPrest.getHosprtAssuranceTaxe() + this.hospitalisationPrest.getHosprtComplementaireHt() + this.hospitalisationPrest.getHosprtComplementaireTaxe() + this.hospitalisationPrest.getHosprtSocieteHt() + this.hospitalisationPrest.getHosprtSocieteTaxe());
               var11.setReg_pat(0.0D);
               var2.add(var11);
            }
         }
      }

      if (var1.equals("FactureBalanceFinale")) {
         this.lesCaution = this.hospitalisationCautionDao.selectReglementByEnt(this.hospitalisationEntete, (Session)null);
         if (this.lesCaution.size() != 0) {
            for(var3 = 0; var3 < this.lesCaution.size(); ++var3) {
               this.hospitalisationCaution = (HospitalisationCaution)this.lesCaution.get(var3);
               var11 = new HospitalisationSejour();
               var11.setHospitalisationEntete(this.hospitalisationEntete);
               var11.setType(6);
               var11.setDate(this.hospitalisationCaution.getHoscauDate());
               var11.setCode("Caution");
               var11.setLibelle("");
               var11.setLettre(this.hospitalisationCaution.getHoscauCaisse());
               var11.setValeur(0.0D);
               if (this.hospitalisationCaution.getHoscauService() != null && !this.hospitalisationCaution.getHoscauService().isEmpty() && this.hospitalisationCaution.getHoscauService().contains(":")) {
                  var12 = this.hospitalisationCaution.getHoscauService().split(":");
                  var11.setService(var12[1]);
               } else {
                  var11.setService(this.hospitalisationCaution.getHoscauService());
               }

               var11.setMedecin(this.hospitalisationCaution.getHoscauNumRecu());
               var11.setQte(0.0F);
               var11.setPu(0.0D);
               var11.setPt(0.0D);
               var11.setPt_tiers(0.0D);
               var11.setReg_pat(this.hospitalisationCaution.getHoscauMontant());
               var2.add(var11);
            }
         }

         this.lesReglements = this.hospitalisationReglementDao.selectReglementByEnt(this.hospitalisationEntete, (Session)null);
         if (this.lesReglements.size() != 0) {
            for(var3 = 0; var3 < this.lesReglements.size(); ++var3) {
               this.hospitalisationReglement = (HospitalisationReglement)this.lesReglements.get(var3);
               var11 = new HospitalisationSejour();
               var11.setHospitalisationEntete(this.hospitalisationEntete);
               var11.setType(7);
               var11.setDate(this.hospitalisationReglement.getHosregDate());
               var11.setCode(this.hospitalisationReglement.getHosregProduit());
               var11.setLibelle(this.hospitalisationReglement.getHosregLaboratoire());
               var11.setLettre(this.hospitalisationReglement.getHosregCaisse());
               var11.setValeur(0.0D);
               if (this.hospitalisationReglement.getHosregService() != null && !this.hospitalisationReglement.getHosregService().isEmpty() && this.hospitalisationReglement.getHosregService().contains(":")) {
                  var12 = this.hospitalisationReglement.getHosregService().split(":");
                  var11.setService(var12[1]);
               } else {
                  var11.setService(this.hospitalisationReglement.getHosregService());
               }

               var11.setMedecin(this.hospitalisationReglement.getHosregNumRecu());
               var11.setQte(0.0F);
               var11.setPu(0.0D);
               var11.setPt(0.0D);
               var11.setPt_tiers(0.0D);
               var11.setReg_pat(this.hospitalisationReglement.getHosregPatient());
               var2.add(var11);
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.hospitalisationEntete.getTotalPatient(), this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var13 = new JRBeanCollectionDataSource(var2);
      return var13;
   }

   public JRBeanCollectionDataSource calculeImpressionRemboursementCommun(String var1) throws IOException, HibernateException, NamingException {
      ArrayList var2 = new ArrayList();
      double var3 = 0.0D;
      if (var1.startsWith("Remboursement")) {
         var2.clear();
         int var5;
         HospitalisationSejour var6;
         if (this.lesSejours.size() != 0) {
            for(var5 = 0; var5 < this.lesSejours.size(); ++var5) {
               this.hospitalisationSejour = (HospitalisationSejour)this.lesSejours.get(var5);
               if (this.hospitalisationSejour.getHossejNbJour() < 0) {
                  var6 = new HospitalisationSejour();
                  var6.setHospitalisationEntete(this.hospitalisationEntete);
                  var6.setType(1);
                  var6.setCode(this.hospitalisationSejour.getHossejLit());
                  var6.setLibelle(this.hospitalisationSejour.getHossejLibelle());
                  var6.setLettre("");
                  var6.setValeur(0.0D);
                  var6.setService(this.hospitalisationSejour.getHossejService());
                  var6.setMedecin(this.hospitalisationSejour.getHossejMedecin());
                  var6.setPu(this.hospitalisationSejour.getHossejPu());
                  var6.setPt(this.hospitalisationSejour.getHossejTotal());
                  var3 += this.hospitalisationSejour.getHossejPatientHt() + this.hospitalisationSejour.getHossejPatientTaxe();
                  var2.add(var6);
               }
            }
         }

         if (this.lesActes.size() != 0) {
            for(var5 = 0; var5 < this.lesActes.size(); ++var5) {
               this.hospitalisationActes = (HospitalisationActes)this.lesActes.get(var5);
               if (this.hospitalisationActes.getHosactQte() < 0.0F) {
                  var6 = new HospitalisationSejour();
                  var6.setHospitalisationEntete(this.hospitalisationEntete);
                  var6.setType(2);
                  var6.setCode(this.hospitalisationActes.getHosactProduit());
                  var6.setLibelle(this.hospitalisationActes.getHosactLibelle());
                  var6.setLettre(this.hospitalisationActes.getHosactLettre());
                  var6.setValeur(this.hospitalisationActes.getHosactValeur());
                  var6.setService(this.hospitalisationActes.getHosactService());
                  var6.setMedecin(this.hospitalisationActes.getHosactMedecin());
                  var6.setPu(this.hospitalisationActes.getHosactPu());
                  var6.setPt(this.hospitalisationActes.getHosactPuAssurance());
                  var3 += this.hospitalisationActes.getHosactPatientHt() + this.hospitalisationActes.getHosactPatientTaxe();
                  var2.add(var6);
               }
            }
         }

         if (this.lesLabos.size() != 0) {
            for(var5 = 0; var5 < this.lesLabos.size(); ++var5) {
               this.hospitalisationLabo = (HospitalisationLabo)this.lesLabos.get(var5);
               if (this.hospitalisationLabo.getHoslabQte() < 0.0F) {
                  var6 = new HospitalisationSejour();
                  var6.setHospitalisationEntete(this.hospitalisationEntete);
                  var6.setType(3);
                  var6.setCode(this.hospitalisationLabo.getHoslabProduit());
                  var6.setLibelle(this.hospitalisationLabo.getHoslabLibelle());
                  var6.setLettre(this.hospitalisationLabo.getHoslabLettre());
                  var6.setValeur(this.hospitalisationLabo.getHoslabValeur());
                  var6.setService(this.hospitalisationLabo.getHoslabService());
                  var6.setMedecin(this.hospitalisationLabo.getHoslabMedecin());
                  var6.setPu(this.hospitalisationLabo.getHoslabPu());
                  var6.setPt(this.hospitalisationLabo.getHoslabPuAssurance());
                  var3 += this.hospitalisationLabo.getHoslabPatientHt() + this.hospitalisationLabo.getHoslabPatientTaxe();
                  var2.add(var6);
               }
            }
         }

         if (this.lesMedis.size() != 0) {
            for(var5 = 0; var5 < this.lesMedis.size(); ++var5) {
               this.hospitalisationMedi = (HospitalisationMedi)this.lesMedis.get(var5);
               if (this.hospitalisationMedi.getHosmedQte() < 0.0F) {
                  var6 = new HospitalisationSejour();
                  var6.setHospitalisationEntete(this.hospitalisationEntete);
                  var6.setType(4);
                  var6.setCode(this.hospitalisationMedi.getHosmedProduit());
                  var6.setLibelle(this.hospitalisationMedi.getHosmedLibelle());
                  var6.setLettre("");
                  var6.setValeur(0.0D);
                  var6.setService(this.hospitalisationMedi.getHosmedService());
                  var6.setMedecin(this.hospitalisationMedi.getHosmedMedecin());
                  var6.setPu(this.hospitalisationMedi.getHosmedPu());
                  var6.setPt(this.hospitalisationMedi.getHosmedPuAssurance());
                  var3 += this.hospitalisationMedi.getHosmedPatientHt() + this.hospitalisationMedi.getHosmedPatientTaxe();
                  var2.add(var6);
               }
            }
         }

         if (this.lesPrests.size() != 0) {
            for(var5 = 0; var5 < this.lesPrests.size(); ++var5) {
               this.hospitalisationPrest = (HospitalisationPrest)this.lesPrests.get(var5);
               if (this.hospitalisationPrest.getHosprtQte() < 0.0F) {
                  var6 = new HospitalisationSejour();
                  var6.setHospitalisationEntete(this.hospitalisationEntete);
                  var6.setType(5);
                  var6.setCode(this.hospitalisationPrest.getHosprtProduit());
                  var6.setLibelle(this.hospitalisationPrest.getHosprtLibelle());
                  var6.setLettre(this.hospitalisationPrest.getHosprtLettre());
                  var6.setValeur(this.hospitalisationPrest.getHosprtValeur());
                  var6.setService(this.hospitalisationPrest.getHosprtService());
                  var6.setMedecin(this.hospitalisationPrest.getHosprtMedecin());
                  var6.setPu(this.hospitalisationPrest.getHosprtPu());
                  var6.setPt(this.hospitalisationPrest.getHosprtPuAssurance());
                  var3 += this.hospitalisationPrest.getHosprtPatientHt() + this.hospitalisationPrest.getHosprtPatientTaxe();
                  var2.add(var6);
               }
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(var3, this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var7 = new JRBeanCollectionDataSource(var2);
      return var7;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      return var2;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.hospitalisationEntete.getHosDateImp() != null && this.hospitalisationEntete.getHosEtat() != 0) {
            var2 = true;
         }

         this.hospitalisationEntete.setHosDateImp(new Date());
         if (this.hospitalisationEntete.getHosEtat() == 0 && this.hospitalisationEntete.getHosEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 0) {
            this.hospitalisationEntete.setHosEtat(1);
         }

         this.hospitalisationEntete.setHosModeleImp(var1);
         this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var3);
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
            if (var3.startsWith("Remboursement")) {
               var1.setjRBeanCollectionDataSource(this.calculeImpressionRemboursementCommun(var3));
            } else {
               var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun(var3));
            }

            var1.setRapport(var3);
            var1.setEntete("Impression hospitalisation");
            var1.setMontant_lettre(this.montant_lettre);
            var1.setPageGarde(this.conversionGarde());
            var1.setAnnexe1(this.conversionAnnexe1());
            var1.setAnnexe2(this.conversionAnnexe2());
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.hospitalisationEntete.getHosEtat()));
            var1.setDuplicata("" + var11);
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.hospitalisationEntete.getHosIdMedecin());
            var1.setIdCommercial(this.hospitalisationEntete.getHosIdCreateur());
            var1.setTiersSelectionne((Tiers)null);
            var1.setNumDoc(this.hospitalisationEntete.getHosNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.hospitalisationEntete.getHosId());
            var1.setParc((Parc)null);
            var1.setTotauxHt("" + this.hospitalisationEntete.getHosTotPatient());
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des hospitalisations");
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "hospitalisation" + File.separator);
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

         JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(this.lesHospitalisationEntete);
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
      if (this.lesHospitalisationEntete.size() != 0) {
         if (this.valQteGraph == 0) {
            this.uniteGraph = "HOSPITALISATIONS : Chiffre d'Affaire en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else {
            this.uniteGraph = "HOSPITALISATIONS  : Quantites";
            this.deviseGraph = "";
            this.nbDecGraph = 0;
         }

         this.titreGraph = "Analyse des hospitalisations : ";
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
            this.sousTitreGraph = this.sousTitreGraph + " - Par catégories d'entrée (" + this.uniteGraph + ")";
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
         } else if (this.modeGraph == 20) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par actes (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 21) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par services (séjour) (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 22) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par lits (séjour) (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 23) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par produits pharmacie (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 24) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par examens laboratoires (" + this.uniteGraph + ")";
         }

         new HospitalisationEntete();
         new HospitalisationSejour();
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
         String var6 = "";

         HospitalisationEntete var14;
         for(int var7 = 0; var7 < this.lesHospitalisationEntete.size(); ++var7) {
            var14 = (HospitalisationEntete)this.lesHospitalisationEntete.get(var7);
            if (var6.isEmpty()) {
               var6 = "'" + var14.getHosNum() + "'";
            } else {
               var6 = var6 + ",'" + var14.getHosNum() + "'";
            }
         }

         long var9;
         int var11;
         int var13;
         boolean var17;
         List var18;
         String var19;
         if (this.modeGraph == 20) {
            new ArrayList();
            var18 = this.hospitalisationActesDao.chargerLesLignesActes(var6, var5);
            if (var18.size() != 0) {
               var19 = "";
               var9 = 0L;
               var17 = false;
               new HospitalisationActes();
               var13 = 0;

               while(true) {
                  if (var13 >= var18.size()) {
                     var1 = this.calculePourcentage((List)var1);
                     break;
                  }

                  HospitalisationActes var23 = (HospitalisationActes)var18.get(var13);
                  var19 = "";
                  var9 = 0L;
                  var11 = 0;
                  if (var23.getHosactLibelle() == null || var23.getHosactLibelle().isEmpty()) {
                     var23.setHosactLibelle("ERREUR SERVICES");
                  }

                  var19 = var23.getHosactLibelle();
                  if (this.valQteGraph == 0) {
                     var9 = (long)(var23.getTotalPatient() + var23.getTotalTiers());
                  } else {
                     var9 = (long)this.utilNombre.myRound(var23.getHosactQte(), 1);
                  }

                  if (this.timeDecoupage == 0) {
                     var11 = var23.getHospitalisationEntete().getHosDateEntree().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var11 = var23.getHospitalisationEntete().getHosDateEntree().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var23.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 1 && var23.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 3) {
                        var11 = 1;
                     } else if (var23.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 4 && var23.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 6) {
                        var11 = 2;
                     } else if (var23.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 7 && var23.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 9) {
                        var11 = 3;
                     } else if (var23.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 10 && var23.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 12) {
                        var11 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var23.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 1 && var23.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 6) {
                        var11 = 1;
                     } else if (var23.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 7 && var23.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 12) {
                        var11 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var11 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var11 = var23.getHospitalisationEntete().getHosDateEntree().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var19, var11, var9);
                  ++var13;
               }
            }
         } else {
            HospitalisationSejour var22;
            if (this.modeGraph == 21) {
               new ArrayList();
               var18 = this.hospitalisationSejourDao.chargerLesLignesSejour(var6, var5);
               if (var18.size() != 0) {
                  var19 = "";
                  var9 = 0L;
                  var17 = false;
                  new HospitalisationSejour();
                  var13 = 0;

                  while(true) {
                     if (var13 >= var18.size()) {
                        var1 = this.calculePourcentage((List)var1);
                        break;
                     }

                     var22 = (HospitalisationSejour)var18.get(var13);
                     var19 = "";
                     var9 = 0L;
                     var11 = 0;
                     if (var22.getHossejService() == null || var22.getHossejService().isEmpty()) {
                        var22.setHossejService("ERREUR SERVICE");
                     }

                     var19 = var22.getHossejService();
                     if (this.valQteGraph == 0) {
                        var9 = (long)(var22.getTotalPatient() + var22.getTotalTiers());
                     } else {
                        var9 = (long)this.utilNombre.myRound((float)var22.getHossejNbJour(), 1);
                     }

                     if (this.timeDecoupage == 0) {
                        var11 = var22.getHospitalisationEntete().getHosDateEntree().getDate();
                     } else if (this.timeDecoupage == 1) {
                        var11 = var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1;
                     } else if (this.timeDecoupage == 2) {
                        if (var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 1 && var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 3) {
                           var11 = 1;
                        } else if (var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 4 && var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 6) {
                           var11 = 2;
                        } else if (var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 7 && var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 9) {
                           var11 = 3;
                        } else if (var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 10 && var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 12) {
                           var11 = 4;
                        }
                     } else if (this.timeDecoupage == 3) {
                        if (var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 1 && var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 6) {
                           var11 = 1;
                        } else if (var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 7 && var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 12) {
                           var11 = 2;
                        }
                     } else if (this.timeDecoupage == 4) {
                        var11 = 1;
                     } else if (this.timeDecoupage == 5) {
                        var11 = var22.getHospitalisationEntete().getHosDateEntree().getHours();
                     }

                     var1 = this.calculeListe((List)var1, var19, var11, var9);
                     ++var13;
                  }
               }
            } else if (this.modeGraph == 22) {
               new ArrayList();
               var18 = this.hospitalisationSejourDao.chargerLesLignesSejour(var6, var5);
               if (var18.size() != 0) {
                  var19 = "";
                  var9 = 0L;
                  var17 = false;
                  new HospitalisationSejour();
                  var13 = 0;

                  while(true) {
                     if (var13 >= var18.size()) {
                        var1 = this.calculePourcentage((List)var1);
                        break;
                     }

                     var22 = (HospitalisationSejour)var18.get(var13);
                     var19 = "";
                     var9 = 0L;
                     var11 = 0;
                     if (var22.getHossejLibelle() == null || var22.getHossejLibelle().isEmpty()) {
                        var22.setHossejLibelle("ERREUR LIT");
                     }

                     var19 = var22.getHossejLibelle();
                     if (this.valQteGraph == 0) {
                        var9 = (long)(var22.getTotalPatient() + var22.getTotalTiers());
                     } else {
                        var9 = (long)this.utilNombre.myRound((float)var22.getHossejNbJour(), 1);
                     }

                     if (this.timeDecoupage == 0) {
                        var11 = var22.getHospitalisationEntete().getHosDateEntree().getDate();
                     } else if (this.timeDecoupage == 1) {
                        var11 = var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1;
                     } else if (this.timeDecoupage == 2) {
                        if (var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 1 && var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 3) {
                           var11 = 1;
                        } else if (var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 4 && var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 6) {
                           var11 = 2;
                        } else if (var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 7 && var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 9) {
                           var11 = 3;
                        } else if (var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 10 && var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 12) {
                           var11 = 4;
                        }
                     } else if (this.timeDecoupage == 3) {
                        if (var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 1 && var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 6) {
                           var11 = 1;
                        } else if (var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 7 && var22.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 12) {
                           var11 = 2;
                        }
                     } else if (this.timeDecoupage == 4) {
                        var11 = 1;
                     } else if (this.timeDecoupage == 5) {
                        var11 = var22.getHospitalisationEntete().getHosDateEntree().getHours();
                     }

                     var1 = this.calculeListe((List)var1, var19, var11, var9);
                     ++var13;
                  }
               }
            } else if (this.modeGraph == 23) {
               new ArrayList();
               var18 = this.hospitalisationMediDao.chargerLesLignesProduits(var6, var5);
               if (var18.size() != 0) {
                  var19 = "";
                  var9 = 0L;
                  var17 = false;
                  new HospitalisationMedi();
                  var13 = 0;

                  while(true) {
                     if (var13 >= var18.size()) {
                        var1 = this.calculePourcentage((List)var1);
                        break;
                     }

                     HospitalisationMedi var21 = (HospitalisationMedi)var18.get(var13);
                     var19 = "";
                     var9 = 0L;
                     var11 = 0;
                     if (var21.getHosmedLibelle() == null || var21.getHosmedLibelle().isEmpty()) {
                        var21.setHosmedLibelle("ERREUR PRODUIT");
                     }

                     var19 = var21.getHosmedLibelle();
                     if (this.valQteGraph == 0) {
                        var9 = (long)(var21.getTotalPatient() + var21.getTotalTiers());
                     } else {
                        var9 = (long)this.utilNombre.myRound(var21.getHosmedQte(), 1);
                     }

                     if (this.timeDecoupage == 0) {
                        var11 = var21.getHospitalisationEntete().getHosDateEntree().getDate();
                     } else if (this.timeDecoupage == 1) {
                        var11 = var21.getHospitalisationEntete().getHosDateEntree().getMonth() + 1;
                     } else if (this.timeDecoupage == 2) {
                        if (var21.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 1 && var21.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 3) {
                           var11 = 1;
                        } else if (var21.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 4 && var21.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 6) {
                           var11 = 2;
                        } else if (var21.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 7 && var21.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 9) {
                           var11 = 3;
                        } else if (var21.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 10 && var21.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 12) {
                           var11 = 4;
                        }
                     } else if (this.timeDecoupage == 3) {
                        if (var21.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 1 && var21.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 6) {
                           var11 = 1;
                        } else if (var21.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 7 && var21.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 12) {
                           var11 = 2;
                        }
                     } else if (this.timeDecoupage == 4) {
                        var11 = 1;
                     } else if (this.timeDecoupage == 5) {
                        var11 = var21.getHospitalisationEntete().getHosDateEntree().getHours();
                     }

                     var1 = this.calculeListe((List)var1, var19, var11, var9);
                     ++var13;
                  }
               }
            } else if (this.modeGraph == 24) {
               new ArrayList();
               var18 = this.hospitalisationLaboDao.chargerLesLignesExamens(var6, var5);
               if (var18.size() != 0) {
                  var19 = "";
                  var9 = 0L;
                  var17 = false;
                  new HospitalisationLabo();
                  var13 = 0;

                  while(true) {
                     if (var13 >= var18.size()) {
                        var1 = this.calculePourcentage((List)var1);
                        break;
                     }

                     HospitalisationLabo var20 = (HospitalisationLabo)var18.get(var13);
                     var19 = "";
                     var9 = 0L;
                     var11 = 0;
                     if (var20.getHoslabLibelle() == null || var20.getHoslabLibelle().isEmpty()) {
                        var20.setHoslabLibelle("ERREUR EXAMEN");
                     }

                     var19 = var20.getHoslabLibelle();
                     if (this.valQteGraph == 0) {
                        var9 = (long)(var20.getTotalPatient() + var20.getTotalTiers());
                     } else {
                        var9 = (long)this.utilNombre.myRound(var20.getHoslabQte(), 1);
                     }

                     if (this.timeDecoupage == 0) {
                        var11 = var20.getHospitalisationEntete().getHosDateEntree().getDate();
                     } else if (this.timeDecoupage == 1) {
                        var11 = var20.getHospitalisationEntete().getHosDateEntree().getMonth() + 1;
                     } else if (this.timeDecoupage == 2) {
                        if (var20.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 1 && var20.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 3) {
                           var11 = 1;
                        } else if (var20.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 4 && var20.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 6) {
                           var11 = 2;
                        } else if (var20.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 7 && var20.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 9) {
                           var11 = 3;
                        } else if (var20.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 10 && var20.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 12) {
                           var11 = 4;
                        }
                     } else if (this.timeDecoupage == 3) {
                        if (var20.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 1 && var20.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 6) {
                           var11 = 1;
                        } else if (var20.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 >= 7 && var20.getHospitalisationEntete().getHosDateEntree().getMonth() + 1 <= 12) {
                           var11 = 2;
                        }
                     } else if (this.timeDecoupage == 4) {
                        var11 = 1;
                     } else if (this.timeDecoupage == 5) {
                        var11 = var20.getHospitalisationEntete().getHosDateEntree().getHours();
                     }

                     var1 = this.calculeListe((List)var1, var19, var11, var9);
                     ++var13;
                  }
               }
            } else if (this.lesHospitalisationEntete.size() != 0) {
               String var15 = "";
               long var8 = 0L;
               boolean var10 = false;

               for(var11 = 0; var11 < this.lesHospitalisationEntete.size(); ++var11) {
                  var14 = (HospitalisationEntete)this.lesHospitalisationEntete.get(var11);
                  var15 = "";
                  var8 = 0L;
                  int var16 = 0;
                  if (this.modeGraph == 0) {
                     int var12 = var14.getHosDateEntree().getYear() + 1900;
                     var15 = "" + var12;
                     var8 = (long)var14.getHosTotGeneral();
                  } else if (this.modeGraph == 1) {
                     var15 = "" + var14.getHosCategorie();
                     var8 = (long)var14.getHosTotGeneral();
                  } else if (this.modeGraph == 2) {
                     var15 = var14.getHosPrescripteur();
                     var8 = (long)var14.getHosTotGeneral();
                  } else if (this.modeGraph == 3) {
                     var15 = var14.getHosNomPatient();
                     var8 = (long)var14.getHosTotPatient();
                  } else if (this.modeGraph == 4) {
                     var15 = var14.getHosNomAssurance();
                     var8 = (long)var14.getHosTotAssurance();
                  } else if (this.modeGraph == 5) {
                     var15 = var14.getHosNomComplemtaire();
                     var8 = (long)var14.getHosTotComplmentaire();
                  } else if (this.modeGraph == 6) {
                     var15 = var14.getHosNomSociete();
                     var8 = (long)var14.getHosTotSociete();
                  } else if (this.modeGraph == 7) {
                     var15 = var14.getHosMotifEntree();
                     var8 = (long)var14.getHosTotGeneral();
                  } else if (this.modeGraph == 8) {
                     var15 = var14.getHosProtocole();
                     var8 = (long)var14.getHosTotGeneral();
                  } else if (this.modeGraph == 9) {
                     var15 = var14.getHosPathologie();
                     var8 = (long)var14.getHosTotGeneral();
                  }

                  if (this.timeDecoupage == 0) {
                     var16 = var14.getHosDateEntree().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var16 = var14.getHosDateEntree().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var14.getHosDateEntree().getMonth() + 1 >= 1 && var14.getHosDateEntree().getMonth() + 1 <= 3) {
                        var16 = 1;
                     } else if (var14.getHosDateEntree().getMonth() + 1 >= 4 && var14.getHosDateEntree().getMonth() + 1 <= 6) {
                        var16 = 2;
                     } else if (var14.getHosDateEntree().getMonth() + 1 >= 7 && var14.getHosDateEntree().getMonth() + 1 <= 9) {
                        var16 = 3;
                     } else if (var14.getHosDateEntree().getMonth() + 1 >= 10 && var14.getHosDateEntree().getMonth() + 1 <= 12) {
                        var16 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var14.getHosDateEntree().getMonth() + 1 >= 1 && var14.getHosDateEntree().getMonth() + 1 <= 6) {
                        var16 = 1;
                     } else if (var14.getHosDateEntree().getMonth() + 1 >= 7 && var14.getHosDateEntree().getMonth() + 1 <= 12) {
                        var16 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var16 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var16 = var14.getHosDateEntree().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var15, var16, var8);
               }

               var1 = this.calculePourcentage((List)var1);
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

   public List getMesMedecinsItem() {
      return this.mesMedecinsItem;
   }

   public void setMesMedecinsItem(List var1) {
      this.mesMedecinsItem = var1;
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

   public String getInpEntree() {
      return this.inpEntree;
   }

   public void setInpEntree(String var1) {
      this.inpEntree = var1;
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

   public List getMesPecItem() {
      return this.mesPecItem;
   }

   public void setMesPecItem(List var1) {
      this.mesPecItem = var1;
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

   public boolean isVar_acc_entree() {
      return this.var_acc_entree;
   }

   public void setVar_acc_entree(boolean var1) {
      this.var_acc_entree = var1;
   }

   public boolean isVar_acc_sejour() {
      return this.var_acc_sejour;
   }

   public void setVar_acc_sejour(boolean var1) {
      this.var_acc_sejour = var1;
   }

   public boolean isVar_acc_etat() {
      return this.var_acc_etat;
   }

   public void setVar_acc_etat(boolean var1) {
      this.var_acc_etat = var1;
   }

   public boolean isVar_acc_prestation() {
      return this.var_acc_prestation;
   }

   public void setVar_acc_prestation(boolean var1) {
      this.var_acc_prestation = var1;
   }

   public boolean isVar_acc_examComplementaire() {
      return this.var_acc_examComplementaire;
   }

   public void setVar_acc_examComplementaire(boolean var1) {
      this.var_acc_examComplementaire = var1;
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

   public DataModel getDataModelActes() {
      return this.dataModelActes;
   }

   public void setDataModelActes(DataModel var1) {
      this.dataModelActes = var1;
   }

   public CimMedical getCimMedical() {
      return this.cimMedical;
   }

   public void setCimMedical(CimMedical var1) {
      this.cimMedical = var1;
   }

   public boolean isGriserchamps() {
      return this.griserchamps;
   }

   public void setGriserchamps(boolean var1) {
      this.griserchamps = var1;
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

   public boolean isShowModalPanelDetailProduits() {
      return this.showModalPanelDetailProduits;
   }

   public void setShowModalPanelDetailProduits(boolean var1) {
      this.showModalPanelDetailProduits = var1;
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

   public boolean isShowModalPanelDetailActe() {
      return this.showModalPanelDetailActe;
   }

   public void setShowModalPanelDetailActe(boolean var1) {
      this.showModalPanelDetailActe = var1;
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

   public boolean isShowModalPanelBonEncaissement() {
      return this.showModalPanelBonEncaissement;
   }

   public void setShowModalPanelBonEncaissement(boolean var1) {
      this.showModalPanelBonEncaissement = var1;
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

   public DataModel getDatamodelHospitalisation() {
      return this.datamodelHospitalisation;
   }

   public void setDatamodelHospitalisation(DataModel var1) {
      this.datamodelHospitalisation = var1;
   }

   public HospitalisationEntete getHospitalisationEntete() {
      return this.hospitalisationEntete;
   }

   public void setHospitalisationEntete(HospitalisationEntete var1) {
      this.hospitalisationEntete = var1;
   }

   public List getLesDestinationsItems() {
      return this.lesDestinationsItems;
   }

   public void setLesDestinationsItems(List var1) {
      this.lesDestinationsItems = var1;
   }

   public List getLesMotifsEntreeItems() {
      return this.lesMotifsEntreeItems;
   }

   public void setLesMotifsEntreeItems(List var1) {
      this.lesMotifsEntreeItems = var1;
   }

   public List getLesMotifsSortieItems() {
      return this.lesMotifsSortieItems;
   }

   public void setLesMotifsSortieItems(List var1) {
      this.lesMotifsSortieItems = var1;
   }

   public List getLesProvenancesItems() {
      return this.lesProvenancesItems;
   }

   public void setLesProvenancesItems(List var1) {
      this.lesProvenancesItems = var1;
   }

   public boolean isVar_acc_antecedent() {
      return this.var_acc_antecedent;
   }

   public void setVar_acc_antecedent(boolean var1) {
      this.var_acc_antecedent = var1;
   }

   public DataModel getDataModelSejours() {
      return this.dataModelSejours;
   }

   public void setDataModelSejours(DataModel var1) {
      this.dataModelSejours = var1;
   }

   public HospitalisationSejour getHospitalisationSejour() {
      return this.hospitalisationSejour;
   }

   public void setHospitalisationSejour(HospitalisationSejour var1) {
      this.hospitalisationSejour = var1;
   }

   public boolean isShowModalPanelSejour() {
      return this.showModalPanelSejour;
   }

   public void setShowModalPanelSejour(boolean var1) {
      this.showModalPanelSejour = var1;
   }

   public List getLesLitsItems() {
      return this.lesLitsItems;
   }

   public void setLesLitsItems(List var1) {
      this.lesLitsItems = var1;
   }

   public boolean isAfficheButtSejour() {
      return this.afficheButtSejour;
   }

   public void setAfficheButtSejour(boolean var1) {
      this.afficheButtSejour = var1;
   }

   public boolean isAfficheRecu() {
      return this.afficheRecu;
   }

   public void setAfficheRecu(boolean var1) {
      this.afficheRecu = var1;
   }

   public HospitalisationActes getHospitalisationActes() {
      return this.hospitalisationActes;
   }

   public void setHospitalisationActes(HospitalisationActes var1) {
      this.hospitalisationActes = var1;
   }

   public DataModel getDataModelLabo() {
      return this.dataModelLabo;
   }

   public void setDataModelLabo(DataModel var1) {
      this.dataModelLabo = var1;
   }

   public DataModel getDataModelMedi() {
      return this.dataModelMedi;
   }

   public void setDataModelMedi(DataModel var1) {
      this.dataModelMedi = var1;
   }

   public DataModel getDataModelPrest() {
      return this.dataModelPrest;
   }

   public void setDataModelPrest(DataModel var1) {
      this.dataModelPrest = var1;
   }

   public HospitalisationLabo getHospitalisationLabo() {
      return this.hospitalisationLabo;
   }

   public void setHospitalisationLabo(HospitalisationLabo var1) {
      this.hospitalisationLabo = var1;
   }

   public HospitalisationMedi getHospitalisationMedi() {
      return this.hospitalisationMedi;
   }

   public void setHospitalisationMedi(HospitalisationMedi var1) {
      this.hospitalisationMedi = var1;
   }

   public HospitalisationPrest getHospitalisationPrest() {
      return this.hospitalisationPrest;
   }

   public void setHospitalisationPrest(HospitalisationPrest var1) {
      this.hospitalisationPrest = var1;
   }

   public boolean isShowModalPanelMedi() {
      return this.showModalPanelMedi;
   }

   public void setShowModalPanelMedi(boolean var1) {
      this.showModalPanelMedi = var1;
   }

   public boolean isAfficheButtPrest() {
      return this.afficheButtPrest;
   }

   public void setAfficheButtPrest(boolean var1) {
      this.afficheButtPrest = var1;
   }

   public boolean isShowModalPanelActes() {
      return this.showModalPanelActes;
   }

   public void setShowModalPanelActes(boolean var1) {
      this.showModalPanelActes = var1;
   }

   public List getMesSejoursItems() {
      return this.mesSejoursItems;
   }

   public void setMesSejoursItems(List var1) {
      this.mesSejoursItems = var1;
   }

   public boolean isValideActe() {
      return this.valideActe;
   }

   public void setValideActe(boolean var1) {
      this.valideActe = var1;
   }

   public boolean isValideMedi() {
      return this.valideMedi;
   }

   public void setValideMedi(boolean var1) {
      this.valideMedi = var1;
   }

   public List getMesDepotsItems() {
      return this.mesDepotsItems;
   }

   public void setMesDepotsItems(List var1) {
      this.mesDepotsItems = var1;
   }

   public boolean isValideLabo() {
      return this.valideLabo;
   }

   public void setValideLabo(boolean var1) {
      this.valideLabo = var1;
   }

   public boolean isValidePrest() {
      return this.validePrest;
   }

   public void setValidePrest(boolean var1) {
      this.validePrest = var1;
   }

   public boolean isShowModalPanelLabo() {
      return this.showModalPanelLabo;
   }

   public void setShowModalPanelLabo(boolean var1) {
      this.showModalPanelLabo = var1;
   }

   public boolean isShowModalPanelPrest() {
      return this.showModalPanelPrest;
   }

   public void setShowModalPanelPrest(boolean var1) {
      this.showModalPanelPrest = var1;
   }

   public double getVar_totalActes() {
      return this.var_totalActes;
   }

   public void setVar_totalActes(double var1) {
      this.var_totalActes = var1;
   }

   public double getVar_totalLaboratoire() {
      return this.var_totalLaboratoire;
   }

   public void setVar_totalLaboratoire(double var1) {
      this.var_totalLaboratoire = var1;
   }

   public double getVar_totalPharmacie() {
      return this.var_totalPharmacie;
   }

   public void setVar_totalPharmacie(double var1) {
      this.var_totalPharmacie = var1;
   }

   public double getVar_totalPrestation() {
      return this.var_totalPrestation;
   }

   public void setVar_totalPrestation(double var1) {
      this.var_totalPrestation = var1;
   }

   public double getVar_totalSejour() {
      return this.var_totalSejour;
   }

   public void setVar_totalSejour(double var1) {
      this.var_totalSejour = var1;
   }

   public String getMedicDepot() {
      return this.medicDepot;
   }

   public void setMedicDepot(String var1) {
      this.medicDepot = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
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

   public long getNomFamille() {
      return this.nomFamille;
   }

   public void setNomFamille(long var1) {
      this.nomFamille = var1;
   }

   public boolean isVar_pecAssurance() {
      return this.var_pecAssurance;
   }

   public void setVar_pecAssurance(boolean var1) {
      this.var_pecAssurance = var1;
   }

   public float getVar_pecCnamgs() {
      return this.var_pecCnamgs;
   }

   public void setVar_pecCnamgs(float var1) {
      this.var_pecCnamgs = var1;
   }

   public boolean isVar_consultation_directe() {
      return this.var_consultation_directe;
   }

   public void setVar_consultation_directe(boolean var1) {
      this.var_consultation_directe = var1;
   }

   public String getVar_modereg() {
      return this.var_modereg;
   }

   public void setVar_modereg(String var1) {
      this.var_modereg = var1;
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

   public boolean isVar_affiche_protocole() {
      return this.var_affiche_protocole;
   }

   public void setVar_affiche_protocole(boolean var1) {
      this.var_affiche_protocole = var1;
   }

   public boolean isVar_affiche_service() {
      return this.var_affiche_service;
   }

   public void setVar_affiche_service(boolean var1) {
      this.var_affiche_service = var1;
   }

   public boolean isVar_affiche_be() {
      return this.var_affiche_be;
   }

   public void setVar_affiche_be(boolean var1) {
      this.var_affiche_be = var1;
   }

   public boolean isValideSejour() {
      return this.valideSejour;
   }

   public void setValideSejour(boolean var1) {
      this.valideSejour = var1;
   }

   public FormPatients getFormPatients() {
      return this.formPatients;
   }

   public void setFormPatients(FormPatients var1) {
      this.formPatients = var1;
   }

   public boolean isAfficheButtLit() {
      return this.afficheButtLit;
   }

   public void setAfficheButtLit(boolean var1) {
      this.afficheButtLit = var1;
   }

   public String getVar_heureDeces() {
      return this.var_heureDeces;
   }

   public void setVar_heureDeces(String var1) {
      this.var_heureDeces = var1;
   }

   public String getVar_minuteDeces() {
      return this.var_minuteDeces;
   }

   public void setVar_minuteDeces(String var1) {
      this.var_minuteDeces = var1;
   }

   public boolean isShowModalPanelErreurPaye() {
      return this.showModalPanelErreurPaye;
   }

   public void setShowModalPanelErreurPaye(boolean var1) {
      this.showModalPanelErreurPaye = var1;
   }

   public DataModel getDataModelRegService() {
      return this.dataModelRegService;
   }

   public void setDataModelRegService(DataModel var1) {
      this.dataModelRegService = var1;
   }

   public double getTotalReglement() {
      return this.totalReglement;
   }

   public void setTotalReglement(double var1) {
      this.totalReglement = var1;
   }

   public double getTotalSolde() {
      return this.totalSolde;
   }

   public void setTotalSolde(double var1) {
      this.totalSolde = var1;
   }

   public Habilitation getHabilitation() {
      return this.habilitation;
   }

   public void setHabilitation(Habilitation var1) {
      this.habilitation = var1;
   }

   public String getFichierMine() {
      return this.fichierMine;
   }

   public void setFichierMine(String var1) {
      this.fichierMine = var1;
   }

   public String getFileName() {
      return this.fileName;
   }

   public void setFileName(String var1) {
      this.fileName = var1;
   }

   public boolean isShowModalPanelAjoutFile() {
      return this.showModalPanelAjoutFile;
   }

   public void setShowModalPanelAjoutFile(boolean var1) {
      this.showModalPanelAjoutFile = var1;
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

   public String getNomDocument() {
      return this.nomDocument;
   }

   public void setNomDocument(String var1) {
      this.nomDocument = var1;
   }

   public UploadedFile getUploadedPDFFile() {
      return this.uploadedPDFFile;
   }

   public void setUploadedPDFFile(UploadedFile var1) {
      this.uploadedPDFFile = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public URL getFichierUrl() {
      return this.fichierUrl;
   }

   public void setFichierUrl(URL var1) {
      this.fichierUrl = var1;
   }

   public double getTotalPaye() {
      return this.totalPaye;
   }

   public void setTotalPaye(double var1) {
      this.totalPaye = var1;
   }

   public String getInpCi() {
      return this.inpCi;
   }

   public void setInpCi(String var1) {
      this.inpCi = var1;
   }

   public String getInpTel() {
      return this.inpTel;
   }

   public void setInpTel(String var1) {
      this.inpTel = var1;
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

   public List getMesServicesFacturesActes() {
      return this.mesServicesFacturesActes;
   }

   public void setMesServicesFacturesActes(List var1) {
      this.mesServicesFacturesActes = var1;
   }

   public List getMesServicesFacturesLabo() {
      return this.mesServicesFacturesLabo;
   }

   public void setMesServicesFacturesLabo(List var1) {
      this.mesServicesFacturesLabo = var1;
   }

   public List getMesServicesFacturesMedi() {
      return this.mesServicesFacturesMedi;
   }

   public void setMesServicesFacturesMedi(List var1) {
      this.mesServicesFacturesMedi = var1;
   }

   public List getMesServicesFacturesPrest() {
      return this.mesServicesFacturesPrest;
   }

   public void setMesServicesFacturesPrest(List var1) {
      this.mesServicesFacturesPrest = var1;
   }

   public String getServicesFacturesActes() {
      return this.servicesFacturesActes;
   }

   public void setServicesFacturesActes(String var1) {
      this.servicesFacturesActes = var1;
   }

   public String getServicesFacturesLabo() {
      return this.servicesFacturesLabo;
   }

   public void setServicesFacturesLabo(String var1) {
      this.servicesFacturesLabo = var1;
   }

   public String getServicesFacturesMedi() {
      return this.servicesFacturesMedi;
   }

   public void setServicesFacturesMedi(String var1) {
      this.servicesFacturesMedi = var1;
   }

   public String getServicesFacturesPrest() {
      return this.servicesFacturesPrest;
   }

   public void setServicesFacturesPrest(String var1) {
      this.servicesFacturesPrest = var1;
   }

   public List getLesActes() {
      return this.lesActes;
   }

   public void setLesActes(List var1) {
      this.lesActes = var1;
   }

   public List getLesLabos() {
      return this.lesLabos;
   }

   public void setLesLabos(List var1) {
      this.lesLabos = var1;
   }

   public List getLesMedis() {
      return this.lesMedis;
   }

   public void setLesMedis(List var1) {
      this.lesMedis = var1;
   }

   public List getLesPrests() {
      return this.lesPrests;
   }

   public void setLesPrests(List var1) {
      this.lesPrests = var1;
   }

   public List getLesSejours() {
      return this.lesSejours;
   }

   public void setLesSejours(List var1) {
      this.lesSejours = var1;
   }

   public boolean isChoixImputationLabo() {
      return this.choixImputationLabo;
   }

   public void setChoixImputationLabo(boolean var1) {
      this.choixImputationLabo = var1;
   }

   public List getMesImputationLabo() {
      return this.mesImputationLabo;
   }

   public void setMesImputationLabo(List var1) {
      this.mesImputationLabo = var1;
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

   public DataModel getDataModelConsultation() {
      return this.dataModelConsultation;
   }

   public void setDataModelConsultation(DataModel var1) {
      this.dataModelConsultation = var1;
   }

   public boolean isAfficheButtConsultation() {
      return this.afficheButtConsultation;
   }

   public void setAfficheButtConsultation(boolean var1) {
      this.afficheButtConsultation = var1;
   }

   public boolean isShowModalPanelConsultation() {
      return this.showModalPanelConsultation;
   }

   public void setShowModalPanelConsultation(boolean var1) {
      this.showModalPanelConsultation = var1;
   }

   public ConsultationEnteteGene getConsultationEnteteGene() {
      return this.consultationEnteteGene;
   }

   public void setConsultationEnteteGene(ConsultationEnteteGene var1) {
      this.consultationEnteteGene = var1;
   }

   public boolean isValideConsultation() {
      return this.valideConsultation;
   }

   public void setValideConsultation(boolean var1) {
      this.valideConsultation = var1;
   }

   public boolean isShowModalpanelPec() {
      return this.showModalpanelPec;
   }

   public void setShowModalpanelPec(boolean var1) {
      this.showModalpanelPec = var1;
   }

   public PatientPec getPatientPec() {
      return this.patientPec;
   }

   public void setPatientPec(PatientPec var1) {
      this.patientPec = var1;
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

   public String getNomActeLie() {
      return this.nomActeLie;
   }

   public void setNomActeLie(String var1) {
      this.nomActeLie = var1;
   }

   public boolean isPresenceActeLie() {
      return this.presenceActeLie;
   }

   public void setPresenceActeLie(boolean var1) {
      this.presenceActeLie = var1;
   }

   public float getQteActeLie() {
      return this.qteActeLie;
   }

   public void setQteActeLie(float var1) {
      this.qteActeLie = var1;
   }

   public boolean isQuitterSejour() {
      return this.quitterSejour;
   }

   public void setQuitterSejour(boolean var1) {
      this.quitterSejour = var1;
   }

   public boolean isAfficheButtCaution() {
      return this.afficheButtCaution;
   }

   public void setAfficheButtCaution(boolean var1) {
      this.afficheButtCaution = var1;
   }

   public DataModel getDataModelCaution() {
      return this.dataModelCaution;
   }

   public void setDataModelCaution(DataModel var1) {
      this.dataModelCaution = var1;
   }

   public HospitalisationCaution getHospitalisationCaution() {
      return this.hospitalisationCaution;
   }

   public void setHospitalisationCaution(HospitalisationCaution var1) {
      this.hospitalisationCaution = var1;
   }

   public boolean isShowModalPanelCaution() {
      return this.showModalPanelCaution;
   }

   public void setShowModalPanelCaution(boolean var1) {
      this.showModalPanelCaution = var1;
   }

   public boolean isBalanceFinale() {
      return this.balanceFinale;
   }

   public void setBalanceFinale(boolean var1) {
      this.balanceFinale = var1;
   }

   public String getNouveauService() {
      return this.nouveauService;
   }

   public void setNouveauService(String var1) {
      this.nouveauService = var1;
   }

   public boolean isShowModalPanelChangerService() {
      return this.showModalPanelChangerService;
   }

   public void setShowModalPanelChangerService(boolean var1) {
      this.showModalPanelChangerService = var1;
   }

   public boolean isPaiementPartiel() {
      return this.paiementPartiel;
   }

   public void setPaiementPartiel(boolean var1) {
      this.paiementPartiel = var1;
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
}
