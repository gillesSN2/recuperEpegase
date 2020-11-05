package com.epegase.forms.medical;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.AvoirLigneVentes;
import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.ConsultationActes;
import com.epegase.systeme.classe.ConsultationEnteteGene;
import com.epegase.systeme.classe.ConsultationReglement;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.DocumentTraceVentes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureEnteteMedical;
import com.epegase.systeme.classe.FactureLigneMedical;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.HospitalisationActes;
import com.epegase.systeme.classe.HospitalisationEntete;
import com.epegase.systeme.classe.HospitalisationLabo;
import com.epegase.systeme.classe.HospitalisationMedi;
import com.epegase.systeme.classe.HospitalisationPrest;
import com.epegase.systeme.classe.HospitalisationSejour;
import com.epegase.systeme.classe.LaboratoireEntete;
import com.epegase.systeme.classe.LaboratoireLigne;
import com.epegase.systeme.classe.LaboratoireReglement;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PatientPec;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.PharmacieEntete;
import com.epegase.systeme.classe.PharmacieLigne;
import com.epegase.systeme.classe.PharmacieReglement;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.RecapitulatifMedical;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.control.DocumentMedical;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.LigneMedical;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.dao.AvoirEnteteVentesDao;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.ConsultationActesDao;
import com.epegase.systeme.dao.ConsultationEnteteGeneDao;
import com.epegase.systeme.dao.ConsultationReglementDao;
import com.epegase.systeme.dao.DocumentTraceVentesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.FactureEnteteMedicalDao;
import com.epegase.systeme.dao.FactureLigneMedicalDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.HospitalisationActesDao;
import com.epegase.systeme.dao.HospitalisationEnteteDao;
import com.epegase.systeme.dao.HospitalisationLaboDao;
import com.epegase.systeme.dao.HospitalisationMediDao;
import com.epegase.systeme.dao.HospitalisationPrestDao;
import com.epegase.systeme.dao.HospitalisationSejourDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.LaboratoireEnteteDao;
import com.epegase.systeme.dao.LaboratoireLigneDao;
import com.epegase.systeme.dao.LaboratoireReglementDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PatientPecDao;
import com.epegase.systeme.dao.PatientsDao;
import com.epegase.systeme.dao.PharmacieEnteteDao;
import com.epegase.systeme.dao.PharmacieLigneDao;
import com.epegase.systeme.dao.PharmacieReglementDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.RecapitulatifMedicalDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.TiersAdherentDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilGoogleMap;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilParapheur;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.LectureCivilites;
import com.epegase.systeme.xml.LireLesoptionsCaisses;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.ObjetReglement;
import com.epegase.systeme.xml.OptionCaisses;
import com.epegase.systeme.xml.OptionMedical;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
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

public class FormRefacturation implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_memo_action;
   private String pageIndex;
   private int nature;
   private int typeVente;
   private List mesOnglets;
   private OptionMedical optionMedical;
   private ExercicesVentes exercicesVentes;
   private ExercicesVentes lastExoVentes;
   private EspionDao espionDao;
   private CalculChrono calculChrono;
   private int var_timbre;
   private int var_nb_max = 100;
   private List mesSerieUserItem;
   private URI uri;
   private boolean showModalGoogleMap = false;
   private Date var_date;
   private String var_heure;
   private String var_minute;
   private String var_seconde;
   private boolean visibleOnglet = false;
   private boolean var_aff_detail_tiers = false;
   private boolean var_typeTiers = true;
   private boolean existParapheur = false;
   private Tiers tiers;
   private TiersDao tiersDao;
   private List lesFamilleClientsListe;
   private List lesModeReglementClientsListe;
   private String informationsTiers;
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private UserDao usersDao;
   private FactureEnteteMedical factureEnteteMedical = new FactureEnteteMedical();
   private FactureEnteteMedicalDao factureEnteteMedicalDao;
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
   private boolean visibiliteterme = false;
   private boolean visibilitenbrjr = false;
   private boolean visibiliteencaissemt = false;
   private UtilDate utilDate = new UtilDate();
   private String conditRegtier;
   private boolean showModalPanelImput = false;
   private String var_imput_serie;
   private String var_imput_cat;
   private transient DataModel datamodelDocumentTrace = new ListDataModel();
   private boolean showModalPanelValidationDocument = false;
   private long var_nom_contact;
   private double var_total_marge;
   private boolean showModalPanelAnnuler = false;
   private boolean showModalPanelFactureTiers = false;
   private boolean showModalPanelNoteIncident = false;
   private boolean showModalPanelAjouter = false;
   private List lesTiersConcernes = new ArrayList();
   private List lesFacturesConcernes = new ArrayList();
   private transient DataModel dataModelTiersConcernes = new ListDataModel();
   private List lesTiersRejetes = new ArrayList();
   private boolean showModalPanelPatientRejetes = false;
   private transient DataModel dataModelTiersRejetes = new ListDataModel();
   private ConsultationEnteteGeneDao consultationEnteteGeneDao;
   private PharmacieEnteteDao pharmacieEnteteDao;
   private LaboratoireEnteteDao laboratoireEnteteDao;
   private HospitalisationEnteteDao hospitalisationEnteteDao;
   private ConsultationActesDao consultationActesDao;
   private PharmacieLigneDao pharmacieLigneDao;
   private LaboratoireLigneDao laboratoireLigneDao;
   private HospitalisationActesDao hospitalisationActesDao;
   private HospitalisationLaboDao hospitalisationLaboDao;
   private HospitalisationMediDao hospitalisationMediDao;
   private HospitalisationPrestDao hospitalisationPrestDao;
   private HospitalisationSejourDao hospitalisationSejourDao;
   private Date dateDebut;
   private Date dateFin;
   private Date dateFacture;
   private Date dateRecapitulatif;
   private int nbLigneTotal;
   private int nbLigneSelect;
   private ConsultationActes consultationActes = new ConsultationActes();
   private LaboratoireLigne laboratoireLigne = new LaboratoireLigne();
   private PharmacieLigne pharmacieLigne = new PharmacieLigne();
   private HospitalisationSejour hospitalisationSejour = new HospitalisationSejour();
   private HospitalisationActes hospitalisationActes = new HospitalisationActes();
   private HospitalisationMedi hospitalisationMedi = new HospitalisationMedi();
   private HospitalisationPrest hospitalisationPrest = new HospitalisationPrest();
   private HospitalisationLabo hospitalisationLabo = new HospitalisationLabo();
   private DocumentEntete documentEntete;
   private List lesConsultations = new ArrayList();
   private List lesPharamcies = new ArrayList();
   private List lesLaboratoires = new ArrayList();
   private List lesHospits = new ArrayList();
   private List lesFacturesGenerees = new ArrayList();
   private int ordre;
   private PatientPec patientPec;
   private PatientPecDao patientPecDao;
   private int typeTiers;
   private FactureLigneMedical factureLigneMedical = new FactureLigneMedical();
   private FactureLigneMedicalDao factureLigneMedicalDao;
   private transient DataModel datamodelLigne = new ListDataModel();
   private List lesLignesList = new ArrayList();
   private double totauxTtc = 0.0D;
   private double totauxHt = 0.0D;
   private double totauxTaxe = 0.0D;
   private boolean griserchamps = false;
   private boolean griserValider = false;
   private int numLigne;
   private String inpNomTiers = "";
   private long idTiers;
   private long idPatient;
   private String inpSerie = "100";
   private String inpService = "100";
   private int inpEtat = 0;
   private String periode;
   private String inpNum = "";
   private int inpNumRecap = 0;
   private String inpPatient = "";
   private String inpClient = "";
   private int inpRegroupement = 0;
   private String inpNomTiersPayeurs = "";
   private int inpTiersPayeurs = 0;
   private String inpFeuille = "";
   private String inpCommercial = "";
   private long inpFacturier = 0L;
   private int inpCat = 0;
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean var_more_search = false;
   private boolean showModalPanelListeTiers = false;
   private transient DataModel datamodelListeTiers = new ListDataModel();
   private List lesTiersPayeurs = new ArrayList();
   private String montant_lettre;
   private UtilNombre utilNombre = new UtilNombre();
   private int var_format_devise;
   private float var_coef_devise;
   private Produits produits;
   private ProduitsVtesDao produitsVtesDao;
   private boolean verrouRemise = false;
   private boolean verrouRabais = false;
   private boolean verrouPrvente = false;
   private boolean affichagePump = false;
   private boolean affichagePlancher = false;
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
   private UtilTdt utilTdt = new UtilTdt();
   private boolean showModalPanelPrint = false;
   private String infoOrigineDoc;
   private String devisePrint;
   private float tauxPrint;
   private List lesModelsimpression = new ArrayList();
   private List lesModelesAutorises = new ArrayList();
   private double totalPayerTimbre;
   private List listCaisses;
   private List mesCaissesSeriesItems = new ArrayList();
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
   private boolean showModalPanelPaye = false;
   private boolean showModalPanelPayeMultiple = false;
   private String var_nom_client;
   private String var_num_facture;
   private String var_montant;
   private List mesTypeReglementsCaisse = new ArrayList();
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
   private boolean valideLissage;
   private double var_montant_trf;
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
   private long idCnamgs;
   private boolean showModalPanelConsultation = false;
   private boolean showModalPanelLaboratoire = false;
   private boolean showModalPanelPharmacie = false;
   private boolean showModalPanelHospitalisation = false;
   private ConsultationEnteteGene consultationEnteteGene;
   private LaboratoireEntete laboratoireEntete;
   private PharmacieEntete pharmacieEntete;
   private HospitalisationEntete hospitalisationEntete;
   private String numCnamgsAssure;
   private String nomCnamgsAssure;
   private boolean assurePrincipal;
   private String numFeuille;
   private String numBc;
   private Date dateDocument;
   private String numDocument;
   private String nomAgentFacturation;
   private Patients patientDocument;
   private String nomPatientDocument;
   private double totalFacture;
   private double partPatient;
   private double partTiers;
   private double partTiersAssurance;
   private double partTiersSociete;
   private double partTiersComplementaire;
   private double prixCnamgs;
   private float pecCnamgs;
   private int fondsCnamgs;
   private transient DataModel dataModelPatients = new ListDataModel();
   private List lespatients = new ArrayList();
   private boolean showModalPanelPatients = false;
   private boolean selectPatient = false;
   private List lesReglementsCtrl = new ArrayList();
   private boolean showModalPanelReglementCtrl = false;
   private List lesEntetesCtrl = new ArrayList();
   private transient DataModel dataModelEntetesCtrl = new ListDataModel();
   private DocumentMedical documentMedical;
   private UIDataTable extDTableCtrl = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEnteteCtrl = new SimpleSelection();
   private boolean visibiliteBtonCtrl = false;
   private boolean showModalPanelChangerService = false;
   private String actuelService;
   private String actuelMotif;
   private String actuelMedecin;
   private String nouveauService;
   private String nouveauMotif;
   private long nouveauMedecin;
   private List mesMedecinsItem = new ArrayList();
   private boolean showModalPanelChangerNomPatient = false;
   private Patients patients;
   private Patients patientsAssure;
   private PatientsDao patientsDao;
   private Date dateAnnulation;
   private String motifAnnulation;
   private boolean showModalPanelDocument = false;
   private List lesLignesMedical = new ArrayList();
   private boolean verrouSexe;
   private boolean showModalPanelCalculDateNaissance = false;
   private int nbAnnee;
   private int nbMois;
   private int nbJours;
   private int nevers;
   private List mesCivilitesItems = new ArrayList();
   private List lesEmployeursItems = new ArrayList();
   private TiersAdherentDao tiersAdherentDao;
   private boolean showModalPanelPrintSimulation = false;
   private RecapitulatifMedical recapitulatifMedical;
   private RecapitulatifMedicalDao recapitulatifMedicalDao;
   private boolean facturesChargee = false;
   private boolean tiersChargee = false;
   private List listeFacturesRecap = new ArrayList();
   private transient DataModel dataModelFactureRecap = new ListDataModel();
   private List listeFacturesLibre = new ArrayList();
   private transient DataModel dataModelFactureLibre = new ListDataModel();
   private boolean afficheBoutonFacture = false;
   private boolean showModalPanelAjoutFacture = false;
   private List lesNouvellesFactures = new ArrayList();
   private transient DataModel dataModelNouvelleFactures = new ListDataModel();

   public FormRefacturation() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.factureEnteteMedicalDao = new FactureEnteteMedicalDao(this.baseLog, this.utilInitHibernate);
      this.factureLigneMedicalDao = new FactureLigneMedicalDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.patientPecDao = new PatientPecDao(this.baseLog, this.utilInitHibernate);
      this.patientsDao = new PatientsDao(this.baseLog, this.utilInitHibernate);
      this.tiersAdherentDao = new TiersAdherentDao(this.baseLog, this.utilInitHibernate);
      this.documentTraceVentesDao = new DocumentTraceVentesDao(this.baseLog, this.utilInitHibernate);
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.consultationEnteteGeneDao = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
      this.pharmacieEnteteDao = new PharmacieEnteteDao(this.baseLog, this.utilInitHibernate);
      this.laboratoireEnteteDao = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationEnteteDao = new HospitalisationEnteteDao(this.baseLog, this.utilInitHibernate);
      this.consultationActesDao = new ConsultationActesDao(this.baseLog, this.utilInitHibernate);
      this.pharmacieLigneDao = new PharmacieLigneDao(this.baseLog, this.utilInitHibernate);
      this.laboratoireLigneDao = new LaboratoireLigneDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationActesDao = new HospitalisationActesDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationLaboDao = new HospitalisationLaboDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationMediDao = new HospitalisationMediDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationPrestDao = new HospitalisationPrestDao(this.baseLog, this.utilInitHibernate);
      this.hospitalisationSejourDao = new HospitalisationSejourDao(this.baseLog, this.utilInitHibernate);
      this.produitsVtesDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      this.recapitulatifMedicalDao = new RecapitulatifMedicalDao(this.baseLog, this.utilInitHibernate);
   }

   public void configVentes() {
      if (this.structureLog.getStrtypeentreprise() == null || this.structureLog.getStrtypeentreprise().isEmpty()) {
         this.structureLog.setStrtypeentreprise("0");
      }

      if ((this.optionMedical.getLib1ENTETE() == null || this.optionMedical.getLib1ENTETE().isEmpty()) && (this.optionMedical.getLib2ENTETE() == null || this.optionMedical.getLib2ENTETE().isEmpty()) && (this.optionMedical.getLib3ENTETE() == null || this.optionMedical.getLib3ENTETE().isEmpty()) && (this.optionMedical.getLib4ENTETE() == null || this.optionMedical.getLib4ENTETE().isEmpty()) && (this.optionMedical.getLib5ENTETE() == null || this.optionMedical.getLib5ENTETE().isEmpty()) && (this.optionMedical.getLib6ENTETE() == null || this.optionMedical.getLib6ENTETE().isEmpty()) && (this.optionMedical.getLib7ENTETE() == null || this.optionMedical.getLib7ENTETE().isEmpty()) && (this.optionMedical.getLib8ENTETE() == null || this.optionMedical.getLib8ENTETE().isEmpty()) && (this.optionMedical.getLib9ENTETE() == null || this.optionMedical.getLib9ENTETE().isEmpty()) && (this.optionMedical.getLib10ENTETE() == null || this.optionMedical.getLib10ENTETE().isEmpty())) {
         this.visibleOngleEntete = false;
      } else {
         this.visibleOngleEntete = true;
      }

      if (this.optionMedical.getNbLigneMax() != null && !this.optionMedical.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionMedical.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      this.periode = this.optionMedical.getAffichInGlobViewFAC();
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
      this.var_action = 0;
      this.montantTtc = 0.0D;
      this.montantSolde = 0.0D;
      this.montantReglement = 0.0D;
      this.montantTtcElmt = 0.0D;
      this.montantSoldeElmt = 0.0D;
      this.montantReglementElmt = 0.0D;
      this.inpSerie = "100";
      this.inpCat = 0;
      this.inpService = "100";
      this.inpEtat = 0;
      this.lesEntetesList.clear();
      this.lesLignesList.clear();
   }

   public void moreSearch() throws ParseException {
      if (!this.var_more_search) {
         this.var_more_search = true;
         this.periode = "100";
         String var1 = (new Date()).getYear() + 1900 + "-01-01";
         this.inpDu = this.utilDate.stringToDateSQLLight(var1);
         String var2 = (new Date()).getYear() + 1900 + "-12-31";
         this.inpAu = this.utilDate.stringToDateSQLLight(var2);
         this.fondsCnamgs = 99;
      } else {
         this.var_more_search = false;
         this.inpDu = null;
         this.inpAu = null;
         this.inpCommercial = "";
         this.fondsCnamgs = 99;
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

      int var13;
      if (this.inpEtat != 50) {
         new ArrayList();
         List var12 = this.factureEnteteMedicalDao.recherche(var1, this.exercicesVentes.getExevteId(), this.getInpNum(), this.getInpNumRecap(), this.getInpClient(), this.getInpEtat(), this.getInpSerie(), this.getPeriode(), this.getInpService(), this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.getInpCommercial(), var10, var11);

         for(var13 = 0; var13 < var12.size(); ++var13) {
            if (this.fondsCnamgs == 99 || this.fondsCnamgs != 99 && ((FactureEnteteMedical)var12.get(var13)).getFacFondCnamgs() == this.fondsCnamgs) {
               this.lesEntetesList.add(var12.get(var13));
            }
         }
      }

      if (this.lesEntetesList.size() > 0) {
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         new FactureEnteteMedical();

         for(var13 = 0; var13 < this.lesEntetesList.size(); ++var13) {
            FactureEnteteMedical var14 = (FactureEnteteMedical)this.lesEntetesList.get(var13);
            var2 += var14.getFacTotTtc();
            var4 += var14.getFacTotReglement();
            var6 += var14.getFacTotHt();
            var8 += var14.getFacTotTva();
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
            this.factureEnteteMedical = (FactureEnteteMedical)var1.get(0);
            this.var_date = this.factureEnteteMedical.getFacDate();
            if (this.factureEnteteMedical.getFacDate().getHours() <= 9) {
               this.var_heure = "0" + this.factureEnteteMedical.getFacDate().getHours();
            } else {
               this.var_heure = "" + this.factureEnteteMedical.getFacDate().getHours();
            }

            if (this.factureEnteteMedical.getFacDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.factureEnteteMedical.getFacDate().getMinutes();
            } else {
               this.var_minute = "" + this.factureEnteteMedical.getFacDate().getMinutes();
            }

            if (this.factureEnteteMedical.getFacDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.factureEnteteMedical.getFacDate().getSeconds();
            } else {
               this.var_seconde = "" + this.factureEnteteMedical.getFacDate().getSeconds();
            }

            this.tiers = this.factureEnteteMedical.getTiers();
            this.formRecherche.setTiers(this.tiers);
            if (!this.factureEnteteMedical.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.factureEnteteMedical.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.factureEnteteMedical.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.factureEnteteMedical.getTiers().getTiegenre().equalsIgnoreCase("037")) {
               this.var_typeTiers = true;
            } else {
               this.var_typeTiers = false;
            }

            if (this.tiers.getTiecategorie() != null && !this.tiers.getTiecategorie().isEmpty() && (this.tiers.getTiecategorie().equals("Assurance") || this.tiers.getTiecategorie().equals("Mutuelle/Assurance") || this.tiers.getTiecategorie().equals("IPM") || this.tiers.getTiecategorie().equals("Programme Médical"))) {
               this.typeTiers = 1;
            } else if (this.tiers.getTiecategorie() == null || this.tiers.getTiecategorie().isEmpty() || !this.tiers.getTiecategorie().equalsIgnoreCase("Client société") && !this.tiers.getTiecategorie().equalsIgnoreCase("Ministère") && !this.tiers.getTiecategorie().equalsIgnoreCase("Hôpital") && !this.tiers.getTiecategorie().equalsIgnoreCase("Direction") && !this.tiers.getTiecategorie().equalsIgnoreCase("Mairie")) {
               this.typeTiers = 0;
            } else {
               this.typeTiers = 2;
            }

            this.calculMessageLitige();
            this.var_nom_contact = this.factureEnteteMedical.getFacIdContact();
            this.calculDevise();
            Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "Refacturation");
            this.lesEmployeursItems.clear();
            if (this.typeTiers == 1) {
               this.lesEmployeursItems = this.tiersAdherentDao.listAdherentByTiersItems(this.tiers, var6);
            }

            this.chargerDocumentLigne(var6);
            double var4 = this.chargerBonEncaissement(var6);
            this.chargerDocumentTrace(var6);
            this.chargerUserChrono(var6);
            this.numLigne = 0;
            this.verrouNum = true;
            this.visibiliteBton = true;
            this.utilInitHibernate.closeSession();
            if (var4 >= this.factureEnteteMedical.getFacTotTtc() + this.factureEnteteMedical.getFacTotTimbre()) {
               this.factureEnteteMedical.setFacTotReglement(var4);
               if (var4 >= this.factureEnteteMedical.getFacTotTtc() + this.factureEnteteMedical.getFacTotTimbre()) {
                  this.factureEnteteMedical.setFacSolde(1);
               } else {
                  this.factureEnteteMedical.setFacSolde(0);
               }

               this.factureEnteteMedical = this.factureEnteteMedicalDao.modif(this.factureEnteteMedical);
            }

            this.setMontantTtcElmt(this.factureEnteteMedical.getFacTotTtc());
            this.setMontantReglementElmt(this.factureEnteteMedical.getFacTotReglement());
            this.setMontantElmTotBonEnc(this.factureEnteteMedical.getFacTotTtc() - this.var_tot_bon_encaissement);
            this.setMontantSoldeElmt(this.factureEnteteMedical.getFacTotTtc() - this.factureEnteteMedical.getFacTotReglement());
            this.cumulPrix();
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.factureEnteteMedical != null) {
         if (this.factureEnteteMedical.getFacEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

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

   public void calculDevise() {
      if (this.factureEnteteMedical.getFacDevise() != null) {
         this.var_format_devise = this.utilNombre.formatDevise(this.factureEnteteMedical.getFacDevise());
      }

   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.lesLignesList.clear();
      if (this.factureEnteteMedical.getFacId() > 0L) {
         this.lesLignesList = this.factureLigneMedicalDao.chargerLesLignes(this.factureEnteteMedical, var1);
      }

      this.datamodelLigne.setWrappedData(this.lesLignesList);
   }

   public double chargerBonEncaissement(Session var1) throws HibernateException, NamingException {
      this.var_tot_bon_encaissement = 0.0D;
      new ArrayList();
      List var2 = this.reglementsDao.reglementDocument(this.factureEnteteMedical.getFacId(), this.nature, var1);
      double var3 = 0.0D;
      this.afficheRecu = false;
      if (var2.size() != 0) {
         this.afficheRecu = true;
         new Reglements();

         for(int var6 = 0; var6 < var2.size(); ++var6) {
            Reglements var5 = (Reglements)var2.get(var6);
            this.var_tot_bon_encaissement = this.var_tot_bon_encaissement + var5.getRglRecette() - var5.getRglDepense();
            var3 += ((Reglements)var2.get(var6)).getRglRecette();
         }
      }

      this.datamodelRecu.setWrappedData(var2);
      if (this.var_tot_bon_encaissement < this.factureEnteteMedical.getFacTotTtc() + this.factureEnteteMedical.getFacTotTc()) {
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

      return var3;
   }

   public void chargerDocumentTrace(Session var1) throws HibernateException, NamingException {
      this.datamodelDocumentTrace = new ListDataModel();
      Object var2 = new ArrayList();
      if (this.factureEnteteMedical.getFacId() > 0L) {
         var2 = this.documentTraceVentesDao.chargerLesDocumentsTrace(this.factureEnteteMedical.getFacId(), this.nature, var1);
      }

      this.datamodelDocumentTrace.setWrappedData(var2);
   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.factureEnteteMedical != null && this.factureEnteteMedical.getFacSerie() != null && !this.factureEnteteMedical.getFacSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.factureEnteteMedical.getFacSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerEcritures() throws HibernateException, NamingException {
      if (this.factureEnteteMedical != null) {
         new ArrayList();
         EcrituresDao var2 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
         String var3 = "ecrTypeOrigine='" + this.nature + "' and ecrIdOrigine=" + this.factureEnteteMedical.getFacId();
         List var1 = var2.ChargerLesEcrituresRecherche(var3, (Session)null);
         this.dataModelEcriture.setWrappedData(var1);
         if (var1.size() == 0 && this.factureEnteteMedical.getFacDateTransfert() != null) {
            this.factureEnteteMedical.setFacDateTransfert((Date)null);
            this.factureEnteteMedical = this.factureEnteteMedicalDao.modif(this.factureEnteteMedical);
         }
      }

   }

   public void controleDocument() throws ParseException {
      this.dateDebut = this.utilDate.datePremierJourMois(new Date());
      this.dateFin = this.utilDate.dateDernierJourMois(new Date());
      this.inpNomTiers = "";
      this.idTiers = 0L;
      this.lesTiersConcernes.clear();
      this.dataModelTiersConcernes.setWrappedData(this.lesTiersConcernes);
      this.lesTiersRejetes.clear();
      this.dataModelTiersRejetes.setWrappedData(this.lesTiersRejetes);
      this.showModalPanelAjouter = true;
      this.showModalPanelPatientRejetes = false;
   }

   public void razListeRecherche() throws HibernateException, NamingException {
      this.lesTiersConcernes.clear();
      this.dataModelTiersConcernes.setWrappedData(this.lesTiersConcernes);
      this.lesTiersRejetes.clear();
      this.dataModelTiersRejetes.setWrappedData(this.lesTiersRejetes);
      this.idCnamgs = 0L;
      this.inpNomTiers = "";
      this.inpClient = "";
      this.inpFeuille = "";
      this.nomPatientDocument = "";
      this.idPatient = 0L;
      if (this.inpTiersPayeurs >= 100) {
         this.tiers = this.tiersDao.selectTierSigle("CNAMGS", (Session)null);
         if (this.tiers != null) {
            this.idCnamgs = this.tiers.getTieid();
            this.inpNomTiers = this.tiers.getTieraisonsocialenom();
            this.idTiers = this.tiers.getTieid();
            this.inpClient = this.inpNomTiers;
            this.inpRegroupement = 2;
         }
      }

      this.nbLigneSelect = 0;
      this.nbLigneTotal = 0;
      this.dateFacture = this.dateFin;
   }

   public void ajoutDocument() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      this.dateDebut = this.utilDate.datePremierJourMois(new Date());
      this.dateFin = this.utilDate.dateDernierJourMois(new Date());
      this.dateFacture = null;
      this.dateRecapitulatif = null;
      this.inpNomTiers = "";
      this.inpClient = "";
      this.inpFeuille = "";
      this.nomPatientDocument = "";
      this.idPatient = 0L;
      this.idTiers = 0L;
      this.listeTiersPayeur();
      this.inpTiersPayeurs = 0;
      this.inpRegroupement = 0;
      this.showModalPanelAjouter = true;
      this.showModalPanelPatientRejetes = false;
      this.razListeRecherche();
   }

   public void listeTiersPayeur() {
      this.lesTiersPayeurs.clear();
      if (this.structureLog.getStrcodepays().equals("0077")) {
         this.lesTiersPayeurs.add(new SelectItem(0, "Tous"));
         this.lesTiersPayeurs.add(new SelectItem(1, "Les Assurances"));
         this.lesTiersPayeurs.add(new SelectItem(2, "Les Sociétés"));
         this.lesTiersPayeurs.add(new SelectItem(3, "Les Complémentaires"));
         if (this.rechercheModuleComplet(81500) || this.rechercheModuleComplet(81510) || this.rechercheModuleComplet(81540) || this.rechercheModuleComplet(81550)) {
            this.lesTiersPayeurs.add(new SelectItem(101, "CNAMGS-Fonds 1 + Consultations (SP)"));
            this.lesTiersPayeurs.add(new SelectItem(102, "CNAMGS-Fonds 2 + Consultations (AP)"));
            this.lesTiersPayeurs.add(new SelectItem(103, "CNAMGS-Fonds 3 + Consultations (GEF))"));
         }

         if (this.rechercheModuleComplet(81520) || this.rechercheModuleComplet(81540) || this.rechercheModuleComplet(81550)) {
            this.lesTiersPayeurs.add(new SelectItem(111, "CNAMGS-Fonds 1 + Examens (SP)"));
            this.lesTiersPayeurs.add(new SelectItem(112, "CNAMGS-Fonds 2 + Examens (AP)"));
            this.lesTiersPayeurs.add(new SelectItem(113, "CNAMGS-Fonds 3 + Examens (GEF))"));
         }

         if (this.rechercheModuleComplet(81530) || this.rechercheModuleComplet(81550)) {
            this.lesTiersPayeurs.add(new SelectItem(121, "CNAMGS-Fonds 1 + Pharmacies (SP)"));
            this.lesTiersPayeurs.add(new SelectItem(122, "CNAMGS-Fonds 2 + Pharmacies (AP)"));
            this.lesTiersPayeurs.add(new SelectItem(123, "CNAMGS-Fonds 3 + Pharmacies (GEF))"));
         }

         if (this.rechercheModuleComplet(81550)) {
            this.lesTiersPayeurs.add(new SelectItem(131, "CNAMGS-Fonds 1 + Hsopitalisations (SP)"));
            this.lesTiersPayeurs.add(new SelectItem(132, "CNAMGS-Fonds 2 + Hsopitalisations (AP)"));
            this.lesTiersPayeurs.add(new SelectItem(133, "CNAMGS-Fonds 3 + Hsopitalisations (GEF))"));
         }
      } else {
         this.lesTiersPayeurs.add(new SelectItem(0, "Tous"));
         if (this.rechercheModuleComplet(81550)) {
            this.lesTiersPayeurs.add(new SelectItem(51, "Les Assurances EXTERNES"));
            this.lesTiersPayeurs.add(new SelectItem(52, "Les Sociétés EXTERNES"));
            this.lesTiersPayeurs.add(new SelectItem(53, "Les Complémentaires EXTERNES"));
            this.lesTiersPayeurs.add(new SelectItem(61, "Les Assurances HOSPIT"));
            this.lesTiersPayeurs.add(new SelectItem(62, "Les Sociétés HOSPIT"));
            this.lesTiersPayeurs.add(new SelectItem(63, "Les Complémentaires HOSPIT"));
         } else {
            this.lesTiersPayeurs.add(new SelectItem(1, "Les Assurances"));
            this.lesTiersPayeurs.add(new SelectItem(2, "Les Sociétés"));
            this.lesTiersPayeurs.add(new SelectItem(3, "Les Complémentaires"));
         }
      }

   }

   public boolean rechercheModuleComplet(int var1) {
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
         if (((String)var3.get(var4)).startsWith(var5)) {
            var2 = true;
            break;
         }
      }

      return var2;
   }

   public void rechercheTiersConcernes() throws HibernateException, NamingException {
      String var1 = this.utilDate.dateToStringSQLLight(this.dateDebut) + " 00:00:00";
      String var2 = this.utilDate.dateToStringSQLLight(this.dateFin) + " 23:59:59";
      if (this.dateFacture == null) {
         this.dateFacture = this.dateFin;
      }

      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "RefacturationMed");
      this.lesTiersConcernes.clear();
      this.lesFacturesConcernes.clear();
      this.lesTiersRejetes.clear();
      this.idCnamgs = 0L;
      if (this.optionMedical.getCnamgs().equals("1")) {
         this.tiers = this.tiersDao.selectTierSigle(this.inpNomTiers, var3);
         if (this.tiers != null && this.tiers.getTiesigle().equals("CNAMGS")) {
            this.idCnamgs = this.tiers.getTieid();
         }
      }

      if (this.inpRegroupement == 0) {
         this.rechercheTiersConsultation_0(var1, var2, var3);
         this.rechercheTiersPharmacie_0(var1, var2, var3);
         this.rechercheTiersLaboratoire_0(var1, var2, var3);
         this.rechercheTiersHospitalisation_0(var1, var2, var3);
      } else if (this.inpRegroupement == 1) {
         this.rechercheTiersConsultation_1(var1, var2, var3);
         this.rechercheTiersPharmacie_1(var1, var2, var3);
         this.rechercheTiersLaboratoire_1(var1, var2, var3);
         this.rechercheTiersHospitalisation_1(var1, var2, var3);
      } else if (this.inpRegroupement == 2) {
         this.rechercheTiersConsultation_2(var1, var2, var3);
         this.rechercheTiersPharmacie_2(var1, var2, var3);
         this.rechercheTiersLaboratoire_2(var1, var2, var3);
         this.rechercheTiersHospitalisation_2(var1, var2, var3);
      }

      this.nbLigneSelect = 0;
      this.nbLigneTotal = 0;
      if (this.lesTiersConcernes.size() != 0) {
         this.nbLigneTotal = this.lesTiersConcernes.size();
      }

      this.calculeNatureTiers(var3);
      this.utilInitHibernate.closeSession();
      this.dataModelTiersConcernes.setWrappedData(this.lesTiersConcernes);
      this.dataModelTiersRejetes.setWrappedData(this.lesTiersRejetes);
      if (this.lesTiersRejetes.size() != 0) {
         this.showModalPanelPatientRejetes = true;
      } else {
         this.showModalPanelPatientRejetes = false;
      }

   }

   public void rechercheTiersConsultation_0(String var1, String var2, Session var3) throws HibernateException, NamingException {
      this.lesConsultations.clear();
      if (this.idCnamgs != 0L) {
         this.lesConsultations = this.consultationEnteteGeneDao.rechercheConsultationCnamgsPeriode(var1, var2, this.numBc, var3);
      } else {
         this.lesConsultations = this.consultationEnteteGeneDao.rechercheConsultationPeriode(var1, var2, this.idTiers, this.numBc, var3);
      }

      if (this.lesConsultations.size() != 0) {
         new ConsultationEnteteGene();
         boolean var5 = false;
         boolean var6 = false;
         boolean var7 = false;
         boolean var8 = false;

         for(int var9 = 0; var9 < this.lesConsultations.size(); ++var9) {
            ConsultationEnteteGene var4 = (ConsultationEnteteGene)this.lesConsultations.get(var9);
            if (var4.getCsgDateTransfert() == null && (this.inpTiersPayeurs == 3 && (var4.getCsgEtat() == 5 || var4.getCsgEtat() == 6) || this.inpTiersPayeurs != 3 && var4.getCsgEtat() == 5) && (this.inpTiersPayeurs == 0 || (this.inpTiersPayeurs == 1 || this.inpTiersPayeurs == 51) && var4.getCsgIdAssurance() != 0L || (this.inpTiersPayeurs == 2 || this.inpTiersPayeurs == 52) && var4.getCsgIdSociete() != 0L || (this.inpTiersPayeurs == 3 || this.inpTiersPayeurs == 53) && var4.getCsgIdComplementaire() != 0L || this.inpTiersPayeurs == 100 && var4.getCsgPecCnamgs() != 0.0F && var4.getCsgFondCnamgs() != 0 || this.inpTiersPayeurs >= 101 && var4.getCsgPecCnamgs() != 0.0F && var4.getCsgFondCnamgs() == this.inpTiersPayeurs - 100)) {
               if (var4.isCsgBloqueRefacturation()) {
                  this.documentEntete = new DocumentEntete();
                  this.documentEntete.setDocSelect(false);
                  this.documentEntete.setDocIdCreateur(var4.getCsgId());
                  this.documentEntete.setDocNomTiers(var4.getCsgNomPatient());
                  this.documentEntete.setDocLibelle("Patient" + var4.getPatients().getPatDossier());
                  this.documentEntete.setDocTypeTiers(0);
                  this.documentEntete.setDocId(var4.getCsgId());
                  this.documentEntete.setDocIdEquipe(0L);
                  this.documentEntete.setDocNomEquipe("");
                  this.documentEntete.setDocSource("");
                  this.documentEntete.setDocObject("BLOQUE : CONSULTATON N° " + var4.getCsgNum());
                  this.lesTiersRejetes.add(this.documentEntete);
               } else {
                  DocumentEntete var10 = new DocumentEntete();
                  var10.setDocSelect(false);
                  var10.setDocIdCreateur(var4.getCsgId());
                  var10.setDocNum(var4.getCsgNum());
                  var10.setDocDate(var4.getCsgDate());
                  var10.setDocNomTiers(var4.getCsgNomPatient());
                  var10.setDocIdEquipe((long)var4.getCsgFondCnamgs());
                  var10.setDocQte(var4.getCsgPecCnamgs());
                  if (var4.getCsgIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                     var10.setDocLibelle("Assurance");
                     var10.setDocTypeTiers(0);
                     var10.setDocIdResponsable(var4.getCsgIdAssurance());
                     var10.setDocIdCommercial(var4.getCsgIdEmployeur());
                     var10.setDocNomContact(var4.getCsgNomAssurance());
                     var10.setDocNomCommercial(var4.getCsgNomEmployeur());
                     var10.setDocEntree("");
                  } else if (var4.getCsgIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                     var10.setDocLibelle("Société");
                     var10.setDocTypeTiers(1);
                     var10.setDocIdResponsable(var4.getCsgIdSociete());
                     var10.setDocIdCommercial(0L);
                     var10.setDocNomContact(var4.getCsgNomSociete());
                     var10.setDocNomCommercial("");
                     var10.setDocEntree(var4.getMotifEntree());
                  } else if (var4.getCsgIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                     var10.setDocLibelle("Complémentaire");
                     var10.setDocTypeTiers(2);
                     var10.setDocIdResponsable(var4.getCsgIdComplementaire());
                     var10.setDocIdCommercial(0L);
                     var10.setDocNomContact(var4.getCsgNomComplemtaire());
                     var10.setDocNomCommercial("");
                     var10.setDocEntree("");
                  }

                  var10.setDocNumBon(var4.getCsgNumBc());
                  var10.setDocNumDocument(var4.getCsgFeuille());
                  var10.setDocCodeBanq(var4.getCsgMatricule());
                  var10.setDocService(var4.getCsgService());
                  var10.setDocActivite("Consultation");
                  var10.setDocNumDocument(var4.getCsgFeuille());
                  var10.setDocTotTtc(var4.getCsgTotGeneral());
                  var10.setDocTotTva(var4.getTotalPatient());
                  var10.setDocTotHt(var4.getTotalTiers());
                  var10.setDocObject("EXTERNE");
                  this.lesFacturesConcernes.add(var10);
                  var5 = false;
                  var6 = false;
                  var7 = false;
                  var8 = false;
                  if (this.lesTiersConcernes.size() == 0) {
                     if (var4.getCsgIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getCsgId());
                        this.documentEntete.setDocNomTiers(var4.getCsgNomAssurance());
                        this.documentEntete.setDocLibelle("Assurance");
                        this.documentEntete.setDocTypeTiers(0);
                        this.documentEntete.setDocId(var4.getCsgIdAssurance());
                        this.documentEntete.setDocIdEquipe(0L);
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("");
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getCsgIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getCsgId());
                        this.documentEntete.setDocNomTiers(var4.getCsgNomSociete());
                        this.documentEntete.setDocLibelle("Société");
                        this.documentEntete.setDocTypeTiers(1);
                        this.documentEntete.setDocId(var4.getCsgIdSociete());
                        this.documentEntete.setDocIdEquipe(0L);
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("");
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getCsgPecCnamgs() != 0.0F && this.idCnamgs != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getCsgId());
                        this.documentEntete.setDocNomTiers("CNAMGS");
                        this.documentEntete.setDocLibelle("Assurance");
                        this.documentEntete.setDocTypeTiers(0);
                        this.documentEntete.setDocId(this.idCnamgs);
                        this.documentEntete.setDocIdEquipe((long)var4.getCsgFondCnamgs());
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("Fonds N." + var4.getCsgFondCnamgs());
                        this.documentEntete.setDocQte(var4.getCsgPecCnamgs());
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getCsgIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getCsgId());
                        this.documentEntete.setDocNomTiers(var4.getCsgNomComplemtaire());
                        this.documentEntete.setDocLibelle("Complémentaire");
                        this.documentEntete.setDocTypeTiers(2);
                        this.documentEntete.setDocId(var4.getCsgIdComplementaire());
                        this.documentEntete.setDocIdEquipe(0L);
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("");
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     }
                  } else {
                     int var11;
                     if (var4.getCsgIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == var4.getCsgIdAssurance() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("EXTERNE")) {
                              var5 = true;
                              break;
                           }
                        }

                        if (!var5) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getCsgId());
                           this.documentEntete.setDocNomTiers(var4.getCsgNomAssurance());
                           this.documentEntete.setDocLibelle("Assurance");
                           this.documentEntete.setDocTypeTiers(0);
                           this.documentEntete.setDocId(var4.getCsgIdAssurance());
                           this.documentEntete.setDocIdEquipe(0L);
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("");
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getCsgIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == var4.getCsgIdSociete() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("EXTERNE")) {
                              var7 = true;
                              break;
                           }
                        }

                        if (!var7) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getCsgId());
                           this.documentEntete.setDocNomTiers(var4.getCsgNomSociete());
                           this.documentEntete.setDocLibelle("Société");
                           this.documentEntete.setDocTypeTiers(1);
                           this.documentEntete.setDocId(var4.getCsgIdSociete());
                           this.documentEntete.setDocIdEquipe(0L);
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("");
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getCsgPecCnamgs() != 0.0F && this.idCnamgs != 0L && this.inpTiersPayeurs != 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == this.idCnamgs && var4.getCsgFondCnamgs() != 0 && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocIdEquipe() == (long)var4.getCsgFondCnamgs() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("EXTERNE")) {
                              var6 = true;
                              break;
                           }
                        }

                        if (!var6) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getCsgId());
                           this.documentEntete.setDocNomTiers("CNAMGS");
                           this.documentEntete.setDocLibelle("Assurance");
                           this.documentEntete.setDocTypeTiers(0);
                           this.documentEntete.setDocId(this.idCnamgs);
                           this.documentEntete.setDocIdEquipe((long)var4.getCsgFondCnamgs());
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("Fonds N." + var4.getCsgFondCnamgs());
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getCsgIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == var4.getCsgIdComplementaire() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("EXTERNE")) {
                              var8 = true;
                              break;
                           }
                        }

                        if (!var8) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getCsgId());
                           this.documentEntete.setDocNomTiers(var4.getCsgNomComplemtaire());
                           this.documentEntete.setDocLibelle("Complementaire");
                           this.documentEntete.setDocTypeTiers(2);
                           this.documentEntete.setDocId(var4.getCsgIdComplementaire());
                           this.documentEntete.setDocIdEquipe(0L);
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("");
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public void rechercheTiersPharmacie_0(String var1, String var2, Session var3) throws HibernateException, NamingException {
      this.lesPharamcies.clear();
      if (this.idCnamgs != 0L) {
         this.lesPharamcies = this.pharmacieEnteteDao.recherchePharmacieCnamgsPeriode(var1, var2, this.numBc, var3);
      } else {
         this.lesPharamcies = this.pharmacieEnteteDao.recherchePharmaciePeriode(var1, var2, this.idTiers, this.numBc, var3);
      }

      if (this.lesPharamcies.size() != 0) {
         new PharmacieEntete();
         boolean var5 = false;
         boolean var6 = false;
         boolean var7 = false;
         boolean var8 = false;

         for(int var9 = 0; var9 < this.lesPharamcies.size(); ++var9) {
            PharmacieEntete var4 = (PharmacieEntete)this.lesPharamcies.get(var9);
            if (var4.getPhaDateTransfert() == null && (this.inpTiersPayeurs == 3 && (var4.getPhaEtat() == 5 || var4.getPhaEtat() == 6) || this.inpTiersPayeurs != 3 && var4.getPhaEtat() == 5) && (this.inpTiersPayeurs == 0 || (this.inpTiersPayeurs == 1 || this.inpTiersPayeurs == 51) && var4.getPhaIdAssurance() != 0L || (this.inpTiersPayeurs == 2 || this.inpTiersPayeurs == 52) && var4.getPhaIdSociete() != 0L || (this.inpTiersPayeurs == 3 || this.inpTiersPayeurs == 53) && var4.getPhaIdComplementaire() != 0L || this.inpTiersPayeurs == 100 && var4.getPhaPecCnamgs() != 0.0F && var4.getPhaFondCnamgs() != 0 || this.inpTiersPayeurs >= 101 && var4.getPhaPecCnamgs() != 0.0F && var4.getPhaFondCnamgs() == this.inpTiersPayeurs - 100)) {
               if (var4.isPhaBloqueRefacturation()) {
                  this.documentEntete = new DocumentEntete();
                  this.documentEntete.setDocSelect(false);
                  this.documentEntete.setDocIdCreateur(var4.getPhaId());
                  this.documentEntete.setDocNomTiers(var4.getPhaNomPatient());
                  this.documentEntete.setDocLibelle("Patient" + var4.getPatients().getPatDossier());
                  this.documentEntete.setDocTypeTiers(0);
                  this.documentEntete.setDocId(var4.getPhaId());
                  this.documentEntete.setDocIdEquipe(0L);
                  this.documentEntete.setDocNomEquipe("");
                  this.documentEntete.setDocSource("");
                  this.documentEntete.setDocObject("BLQUE : PHARMACIE N° " + var4.getPhaNum());
                  this.lesTiersRejetes.add(this.documentEntete);
               } else {
                  DocumentEntete var10 = new DocumentEntete();
                  var10.setDocSelect(false);
                  var10.setDocIdCreateur(var4.getPhaId());
                  var10.setDocNum(var4.getPhaNum());
                  var10.setDocDate(var4.getPhaDate());
                  var10.setDocNomTiers(var4.getPhaNomPatient());
                  var10.setDocIdEquipe((long)var4.getPhaFondCnamgs());
                  var10.setDocQte(var4.getPhaPecCnamgs());
                  if (var4.getPhaIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                     var10.setDocLibelle("Assurance");
                     var10.setDocTypeTiers(0);
                     var10.setDocIdResponsable(var4.getPhaIdAssurance());
                     var10.setDocIdCommercial(var4.getPhaIdEmployeur());
                     var10.setDocNomContact(var4.getPhaNomAssurance());
                     var10.setDocNomCommercial(var4.getPhaNomEmployeur());
                     var10.setDocEntree("");
                  } else if (var4.getPhaIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                     var10.setDocLibelle("Société");
                     var10.setDocTypeTiers(1);
                     var10.setDocIdResponsable(var4.getPhaIdSociete());
                     var10.setDocIdCommercial(0L);
                     var10.setDocNomContact(var4.getPhaNomSociete());
                     var10.setDocNomCommercial("");
                     var10.setDocEntree("");
                  } else if (var4.getPhaIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                     var10.setDocLibelle("Complémentaire");
                     var10.setDocTypeTiers(2);
                     var10.setDocIdResponsable(var4.getPhaIdComplementaire());
                     var10.setDocIdCommercial(0L);
                     var10.setDocNomContact(var4.getPhaNomComplemtaire());
                     var10.setDocNomCommercial("");
                     var10.setDocEntree("");
                  }

                  var10.setDocNumBon(var4.getPhaNumBc());
                  var10.setDocNumDocument(var4.getPhaFeuille());
                  var10.setDocCodeBanq(var4.getPhaMatricule());
                  var10.setDocService(var4.getPhaService());
                  var10.setDocActivite("Pharmacie");
                  var10.setDocNumDocument(var4.getPhaFeuille());
                  var10.setDocTotTtc(var4.getPhaTotGeneral());
                  var10.setDocTotTva(var4.getTotalPatient());
                  var10.setDocTotHt(var4.getTotalTiers());
                  var10.setDocObject("EXTERNE");
                  this.lesFacturesConcernes.add(var10);
                  var5 = false;
                  var6 = false;
                  var7 = false;
                  var8 = false;
                  if (this.lesTiersConcernes.size() == 0) {
                     if (var4.getPhaIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getPhaId());
                        this.documentEntete.setDocNomTiers(var4.getPhaNomAssurance());
                        this.documentEntete.setDocLibelle("Assurance");
                        this.documentEntete.setDocTypeTiers(0);
                        this.documentEntete.setDocId(var4.getPhaIdAssurance());
                        this.documentEntete.setDocIdEquipe(0L);
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("");
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getPhaIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getPhaId());
                        this.documentEntete.setDocNomTiers(var4.getPhaNomSociete());
                        this.documentEntete.setDocLibelle("Société");
                        this.documentEntete.setDocTypeTiers(1);
                        this.documentEntete.setDocId(var4.getPhaIdSociete());
                        this.documentEntete.setDocIdEquipe(0L);
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("");
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getPhaPecCnamgs() != 0.0F && this.idCnamgs != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getPhaId());
                        this.documentEntete.setDocNomTiers("CNAMGS");
                        this.documentEntete.setDocLibelle("Assurance");
                        this.documentEntete.setDocTypeTiers(0);
                        this.documentEntete.setDocId(this.idCnamgs);
                        this.documentEntete.setDocIdEquipe((long)var4.getPhaFondCnamgs());
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("Fonds N." + var4.getPhaFondCnamgs());
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getPhaIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getPhaId());
                        this.documentEntete.setDocNomTiers(var4.getPhaNomComplemtaire());
                        this.documentEntete.setDocLibelle("Complémentaire");
                        this.documentEntete.setDocTypeTiers(2);
                        this.documentEntete.setDocId(var4.getPhaIdComplementaire());
                        this.documentEntete.setDocIdEquipe(0L);
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("");
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     }
                  } else {
                     int var11;
                     if (var4.getPhaIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == var4.getPhaIdAssurance() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("EXTERNE")) {
                              var5 = true;
                              break;
                           }
                        }

                        if (!var5) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getPhaId());
                           this.documentEntete.setDocNomTiers(var4.getPhaNomAssurance());
                           this.documentEntete.setDocLibelle("Assurance");
                           this.documentEntete.setDocTypeTiers(0);
                           this.documentEntete.setDocId(var4.getPhaIdAssurance());
                           this.documentEntete.setDocIdEquipe(0L);
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("");
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getPhaIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == var4.getPhaIdSociete() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("EXTERNE")) {
                              var7 = true;
                              break;
                           }
                        }

                        if (!var7) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getPhaId());
                           this.documentEntete.setDocNomTiers(var4.getPhaNomSociete());
                           this.documentEntete.setDocLibelle("Société");
                           this.documentEntete.setDocTypeTiers(1);
                           this.documentEntete.setDocId(var4.getPhaIdSociete());
                           this.documentEntete.setDocIdEquipe(0L);
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("");
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getPhaPecCnamgs() != 0.0F && this.idCnamgs != 0L && this.inpTiersPayeurs != 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == this.idCnamgs && var4.getPhaFondCnamgs() != 0 && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocIdEquipe() == (long)var4.getPhaFondCnamgs() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("EXTERNE")) {
                              var6 = true;
                              break;
                           }
                        }

                        if (!var6) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getPhaId());
                           this.documentEntete.setDocNomTiers("CNAMGS");
                           this.documentEntete.setDocLibelle("Assurance");
                           this.documentEntete.setDocTypeTiers(0);
                           this.documentEntete.setDocId(this.idCnamgs);
                           this.documentEntete.setDocIdEquipe((long)var4.getPhaFondCnamgs());
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("Fonds N." + var4.getPhaFondCnamgs());
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getPhaIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == var4.getPhaIdComplementaire() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("EXTERNE")) {
                              var8 = true;
                              break;
                           }
                        }

                        if (!var8) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getPhaId());
                           this.documentEntete.setDocNomTiers(var4.getPhaNomComplemtaire());
                           this.documentEntete.setDocLibelle("Complementaire");
                           this.documentEntete.setDocTypeTiers(2);
                           this.documentEntete.setDocId(var4.getPhaIdComplementaire());
                           this.documentEntete.setDocIdEquipe(0L);
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("");
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public void rechercheTiersLaboratoire_0(String var1, String var2, Session var3) throws HibernateException, NamingException {
      this.lesLaboratoires.clear();
      if (this.idCnamgs != 0L) {
         this.lesLaboratoires = this.laboratoireEnteteDao.rechercheLaboratoireCnamgsPeriode(var1, var2, this.numBc, var3);
      } else {
         this.lesLaboratoires = this.laboratoireEnteteDao.rechercheLaboratoirePeriode(var1, var2, this.idTiers, this.numBc, var3);
      }

      if (this.lesLaboratoires.size() != 0) {
         new LaboratoireEntete();
         boolean var5 = false;
         boolean var6 = false;
         boolean var7 = false;
         boolean var8 = false;

         for(int var9 = 0; var9 < this.lesLaboratoires.size(); ++var9) {
            LaboratoireEntete var4 = (LaboratoireEntete)this.lesLaboratoires.get(var9);
            if (var4.getLabDateTransfert() == null && (this.inpTiersPayeurs == 3 && (var4.getLabEtat() == 5 || var4.getLabEtat() == 6) || this.inpTiersPayeurs != 3 && var4.getLabEtat() == 5) && (this.inpTiersPayeurs == 0 || (this.inpTiersPayeurs == 1 || this.inpTiersPayeurs == 51) && var4.getLabIdAssurance() != 0L || (this.inpTiersPayeurs == 2 || this.inpTiersPayeurs == 52) && var4.getLabIdSociete() != 0L || (this.inpTiersPayeurs == 3 || this.inpTiersPayeurs == 53) && var4.getLabIdComplementaire() != 0L || this.inpTiersPayeurs == 100 && var4.getLabPecCnamgs() != 0.0F && var4.getLabFondCnamgs() != 0 || this.inpTiersPayeurs >= 101 && var4.getLabPecCnamgs() != 0.0F && var4.getLabFondCnamgs() == this.inpTiersPayeurs - 100)) {
               if (var4.isLabBloqueRefacturation()) {
                  this.documentEntete = new DocumentEntete();
                  this.documentEntete.setDocSelect(false);
                  this.documentEntete.setDocIdCreateur(var4.getLabId());
                  this.documentEntete.setDocNomTiers(var4.getLabNomPatient());
                  this.documentEntete.setDocLibelle("Patient" + var4.getPatients().getPatDossier());
                  this.documentEntete.setDocTypeTiers(0);
                  this.documentEntete.setDocId(var4.getLabId());
                  this.documentEntete.setDocIdEquipe(0L);
                  this.documentEntete.setDocNomEquipe("");
                  this.documentEntete.setDocSource("");
                  this.documentEntete.setDocObject("BLOQUE : LABORATOIRE N° " + var4.getLabNum());
                  this.lesTiersRejetes.add(this.documentEntete);
               } else {
                  DocumentEntete var10 = new DocumentEntete();
                  var10.setDocSelect(false);
                  var10.setDocIdCreateur(var4.getLabId());
                  var10.setDocNum(var4.getLabNum());
                  var10.setDocDate(var4.getLabDate());
                  var10.setDocNomTiers(var4.getLabNomPatient());
                  var10.setDocIdEquipe((long)var4.getLabFondCnamgs());
                  var10.setDocQte(var4.getLabPecCnamgs());
                  if (var4.getLabIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                     var10.setDocLibelle("Assurance");
                     var10.setDocTypeTiers(0);
                     var10.setDocIdResponsable(var4.getLabIdAssurance());
                     var10.setDocIdCommercial(var4.getLabIdEmployeur());
                     var10.setDocNomContact(var4.getLabNomAssurance());
                     var10.setDocNomCommercial(var4.getLabNomEmployeur());
                     var10.setDocEntree("");
                  } else if (var4.getLabIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                     var10.setDocLibelle("Société");
                     var10.setDocTypeTiers(1);
                     var10.setDocIdResponsable(var4.getLabIdSociete());
                     var10.setDocIdCommercial(0L);
                     var10.setDocNomContact(var4.getLabNomSociete());
                     var10.setDocNomCommercial("");
                     var10.setDocEntree(var4.getMotifEntree());
                  } else if (var4.getLabIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                     var10.setDocLibelle("Complémentaire");
                     var10.setDocTypeTiers(2);
                     var10.setDocIdResponsable(var4.getLabIdComplementaire());
                     var10.setDocIdCommercial(0L);
                     var10.setDocNomContact(var4.getLabNomComplemtaire());
                     var10.setDocNomCommercial("");
                     var10.setDocEntree("");
                  }

                  var10.setDocNumBon(var4.getLabNumBc());
                  var10.setDocNumDocument(var4.getLabFeuille());
                  var10.setDocCodeBanq(var4.getLabMatricule());
                  var10.setDocService(var4.getLabService());
                  if (var4.getLabService() != null && !var4.getLabService().isEmpty()) {
                     if (var4.getLabService().contains(":")) {
                        String[] var11 = var4.getLabService().split(":");
                        var10.setDocActivite(var11[1]);
                     } else {
                        var10.setDocActivite(var4.getLabService());
                     }
                  } else {
                     var10.setDocActivite("Laboratoire");
                  }

                  var10.setDocNumDocument(var4.getLabFeuille());
                  var10.setDocTotTtc(var4.getLabTotGeneral());
                  var10.setDocTotTva(var4.getTotalPatient());
                  var10.setDocTotHt(var4.getTotalTiers());
                  var10.setDocObject("EXTERNE");
                  this.lesFacturesConcernes.add(var10);
                  var5 = false;
                  var6 = false;
                  var7 = false;
                  var8 = false;
                  if (this.lesTiersConcernes.size() == 0) {
                     if (var4.getLabIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getLabId());
                        this.documentEntete.setDocNomTiers(var4.getLabNomAssurance());
                        this.documentEntete.setDocLibelle("Assurance");
                        this.documentEntete.setDocTypeTiers(0);
                        this.documentEntete.setDocId(var4.getLabIdAssurance());
                        this.documentEntete.setDocIdEquipe(0L);
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("");
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getLabIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getLabId());
                        this.documentEntete.setDocNomTiers(var4.getLabNomSociete());
                        this.documentEntete.setDocLibelle("Société");
                        this.documentEntete.setDocTypeTiers(1);
                        this.documentEntete.setDocId(var4.getLabIdSociete());
                        this.documentEntete.setDocIdEquipe(0L);
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("");
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getLabPecCnamgs() != 0.0F && this.idCnamgs != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getLabId());
                        this.documentEntete.setDocNomTiers("CNAMGS");
                        this.documentEntete.setDocLibelle("Assurance");
                        this.documentEntete.setDocTypeTiers(0);
                        this.documentEntete.setDocId(this.idCnamgs);
                        this.documentEntete.setDocIdEquipe((long)var4.getLabFondCnamgs());
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("Fonds N." + var4.getLabFondCnamgs());
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getLabIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getLabId());
                        this.documentEntete.setDocNomTiers(var4.getLabNomComplemtaire());
                        this.documentEntete.setDocLibelle("Complémentaire");
                        this.documentEntete.setDocTypeTiers(2);
                        this.documentEntete.setDocId(var4.getLabIdComplementaire());
                        this.documentEntete.setDocIdEquipe(0L);
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("");
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     }
                  } else {
                     int var12;
                     if (var4.getLabIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                        for(var12 = 0; var12 < this.lesTiersConcernes.size(); ++var12) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocId() == var4.getLabIdAssurance() && ((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocObject().equals("EXTERNE")) {
                              var5 = true;
                              break;
                           }
                        }

                        if (!var5) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getLabId());
                           this.documentEntete.setDocNomTiers(var4.getLabNomAssurance());
                           this.documentEntete.setDocLibelle("Assurance");
                           this.documentEntete.setDocTypeTiers(0);
                           this.documentEntete.setDocId(var4.getLabIdAssurance());
                           this.documentEntete.setDocIdEquipe(0L);
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("");
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getLabIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                        for(var12 = 0; var12 < this.lesTiersConcernes.size(); ++var12) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocId() == var4.getLabIdSociete() && ((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocObject().equals("EXTERNE")) {
                              var7 = true;
                              break;
                           }
                        }

                        if (!var7) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getLabId());
                           this.documentEntete.setDocNomTiers(var4.getLabNomSociete());
                           this.documentEntete.setDocLibelle("Société");
                           this.documentEntete.setDocTypeTiers(1);
                           this.documentEntete.setDocId(var4.getLabIdSociete());
                           this.documentEntete.setDocIdEquipe(0L);
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("");
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getLabPecCnamgs() != 0.0F && this.idCnamgs != 0L && this.inpTiersPayeurs != 3) {
                        for(var12 = 0; var12 < this.lesTiersConcernes.size(); ++var12) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocId() == this.idCnamgs && var4.getLabFondCnamgs() != 0 && ((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocIdEquipe() == (long)var4.getLabFondCnamgs() && ((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocObject().equals("EXTERNE")) {
                              var6 = true;
                              break;
                           }
                        }

                        if (!var6) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getLabId());
                           this.documentEntete.setDocNomTiers("CNAMGS");
                           this.documentEntete.setDocLibelle("Assurance");
                           this.documentEntete.setDocTypeTiers(0);
                           this.documentEntete.setDocId(this.idCnamgs);
                           this.documentEntete.setDocIdEquipe((long)var4.getLabFondCnamgs());
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("Fonds N." + var4.getLabFondCnamgs());
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getLabIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                        for(var12 = 0; var12 < this.lesTiersConcernes.size(); ++var12) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocId() == var4.getLabIdComplementaire() && ((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocObject().equals("EXTERNE")) {
                              var8 = true;
                              break;
                           }
                        }

                        if (!var8) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getLabId());
                           this.documentEntete.setDocNomTiers(var4.getLabNomComplemtaire());
                           this.documentEntete.setDocLibelle("Complementaire");
                           this.documentEntete.setDocTypeTiers(2);
                           this.documentEntete.setDocId(var4.getLabIdComplementaire());
                           this.documentEntete.setDocIdEquipe(0L);
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("");
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public void rechercheTiersHospitalisation_0(String var1, String var2, Session var3) throws HibernateException, NamingException {
      this.lesHospits.clear();
      if (this.idCnamgs != 0L) {
         this.lesHospits = this.hospitalisationEnteteDao.rechercheHospitalisationCnamgsPeriode(var1, var2, this.numBc, var3);
      } else {
         this.lesHospits = this.hospitalisationEnteteDao.rechercheHospitalisationPeriode(var1, var2, this.idTiers, this.numBc, var3);
      }

      if (this.lesHospits.size() != 0) {
         new HospitalisationEntete();
         boolean var5 = false;
         boolean var6 = false;
         boolean var7 = false;
         boolean var8 = false;

         for(int var9 = 0; var9 < this.lesHospits.size(); ++var9) {
            HospitalisationEntete var4 = (HospitalisationEntete)this.lesHospits.get(var9);
            if (var4.getHosDateTransfert() == null && (this.inpTiersPayeurs == 3 && (var4.getHosEtat() == 5 || var4.getHosEtat() == 6) || this.inpTiersPayeurs != 3 && var4.getHosEtat() == 5) && (this.inpTiersPayeurs == 0 || (this.inpTiersPayeurs == 1 || this.inpTiersPayeurs == 61) && var4.getHosIdAssurance() != 0L || (this.inpTiersPayeurs == 2 || this.inpTiersPayeurs == 62) && var4.getHosIdSociete() != 0L || (this.inpTiersPayeurs == 3 || this.inpTiersPayeurs == 63) && var4.getHosIdComplementaire() != 0L || this.inpTiersPayeurs == 100 && var4.getHosPecCnamgs() != 0.0F && var4.getHosFondCnamgs() != 0 || this.inpTiersPayeurs >= 101 && var4.getHosPecCnamgs() != 0.0F && var4.getHosFondCnamgs() == this.inpTiersPayeurs - 100)) {
               if (var4.isHosBloqueRefacturation()) {
                  this.documentEntete = new DocumentEntete();
                  this.documentEntete.setDocSelect(false);
                  this.documentEntete.setDocIdCreateur(var4.getHosId());
                  this.documentEntete.setDocNomTiers(var4.getHosNomPatient());
                  this.documentEntete.setDocLibelle("Patient" + var4.getPatients().getPatDossier());
                  this.documentEntete.setDocTypeTiers(0);
                  this.documentEntete.setDocId(var4.getHosId());
                  this.documentEntete.setDocIdEquipe(0L);
                  this.documentEntete.setDocNomEquipe("");
                  this.documentEntete.setDocSource("");
                  this.documentEntete.setDocObject("BLOQUE : HOSPITALISATION N° " + var4.getHosNum());
                  this.lesTiersRejetes.add(this.documentEntete);
               } else {
                  DocumentEntete var10 = new DocumentEntete();
                  var10.setDocSelect(false);
                  var10.setDocIdCreateur(var4.getHosId());
                  var10.setDocNum(var4.getHosNum());
                  var10.setDocDate(var4.getHosDateSortie());
                  var10.setDocNomTiers(var4.getHosNomPatient());
                  var10.setDocIdEquipe((long)var4.getHosFondCnamgs());
                  var10.setDocQte(var4.getHosPecCnamgs());
                  if (var4.getHosIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                     var10.setDocLibelle("Assurance");
                     var10.setDocTypeTiers(0);
                     var10.setDocIdResponsable(var4.getHosIdAssurance());
                     var10.setDocIdCommercial(var4.getHosIdEmployeur());
                     var10.setDocNomContact(var4.getHosNomAssurance());
                     var10.setDocNomCommercial(var4.getHosNomEmployeur());
                     var10.setDocEntree("");
                  } else if (var4.getHosIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                     var10.setDocLibelle("Société");
                     var10.setDocTypeTiers(1);
                     var10.setDocIdResponsable(var4.getHosIdSociete());
                     var10.setDocIdCommercial(0L);
                     var10.setDocNomContact(var4.getHosNomSociete());
                     var10.setDocNomCommercial("");
                     var10.setDocEntree(var4.getHosMotifEntree());
                  } else if (var4.getHosIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                     var10.setDocLibelle("Complémentaire");
                     var10.setDocTypeTiers(2);
                     var10.setDocIdResponsable(var4.getHosIdComplementaire());
                     var10.setDocIdCommercial(0L);
                     var10.setDocNomContact(var4.getHosNomComplemtaire());
                     var10.setDocNomCommercial("");
                     var10.setDocEntree("");
                  }

                  var10.setDocNumBon(var4.getHosNumBc());
                  var10.setDocNumDocument(var4.getHosFeuille());
                  var10.setDocCodeBanq(var4.getHosMatricule());
                  var10.setDocService(var4.getHosService());
                  var10.setDocActivite("Hospitalisation");
                  var10.setDocNumDocument(var4.getHosFeuille());
                  var10.setDocTotTtc(var4.getHosTotGeneral());
                  var10.setDocTotTva(var4.getTotalPatient());
                  var10.setDocTotHt(var4.getTotalTiers());
                  var10.setDocObject("HOSPIT");
                  this.lesFacturesConcernes.add(var10);
                  var5 = false;
                  var6 = false;
                  var7 = false;
                  var8 = false;
                  if (this.lesTiersConcernes.size() == 0) {
                     if (var4.getHosIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getHosId());
                        this.documentEntete.setDocNomTiers(var4.getHosNomAssurance());
                        this.documentEntete.setDocLibelle("Assurance");
                        this.documentEntete.setDocTypeTiers(0);
                        this.documentEntete.setDocId(var4.getHosIdAssurance());
                        this.documentEntete.setDocIdEquipe(0L);
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("");
                        this.documentEntete.setDocObject("HOSPIT");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getHosIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getHosId());
                        this.documentEntete.setDocNomTiers(var4.getHosNomSociete());
                        this.documentEntete.setDocLibelle("Société");
                        this.documentEntete.setDocTypeTiers(1);
                        this.documentEntete.setDocId(var4.getHosIdSociete());
                        this.documentEntete.setDocIdEquipe(0L);
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("");
                        this.documentEntete.setDocObject("HOSPIT");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getHosPecCnamgs() != 0.0F && this.idCnamgs != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getHosId());
                        this.documentEntete.setDocNomTiers("CNAMGS");
                        this.documentEntete.setDocLibelle("Assurance");
                        this.documentEntete.setDocTypeTiers(0);
                        this.documentEntete.setDocId(this.idCnamgs);
                        this.documentEntete.setDocIdEquipe((long)var4.getHosFondCnamgs());
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("Fonds N." + var4.getHosFondCnamgs());
                        this.documentEntete.setDocObject("HOSPIT");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getHosIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getHosId());
                        this.documentEntete.setDocNomTiers(var4.getHosNomComplemtaire());
                        this.documentEntete.setDocLibelle("Complémentaire");
                        this.documentEntete.setDocTypeTiers(2);
                        this.documentEntete.setDocId(var4.getHosIdComplementaire());
                        this.documentEntete.setDocIdEquipe(0L);
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("");
                        this.documentEntete.setDocObject("HOSPIT");
                        this.lesTiersConcernes.add(this.documentEntete);
                     }
                  } else {
                     int var11;
                     if (var4.getHosIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == var4.getHosIdAssurance() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("HOSPIT")) {
                              var5 = true;
                              break;
                           }
                        }

                        if (!var5) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getHosId());
                           this.documentEntete.setDocNomTiers(var4.getHosNomAssurance());
                           this.documentEntete.setDocLibelle("Assurance");
                           this.documentEntete.setDocTypeTiers(0);
                           this.documentEntete.setDocId(var4.getHosIdAssurance());
                           this.documentEntete.setDocIdEquipe(0L);
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("");
                           this.documentEntete.setDocObject("HOSPIT");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getHosIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == var4.getHosIdSociete() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("HOSPIT")) {
                              var7 = true;
                              break;
                           }
                        }

                        if (!var7) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getHosId());
                           this.documentEntete.setDocNomTiers(var4.getHosNomSociete());
                           this.documentEntete.setDocLibelle("Société");
                           this.documentEntete.setDocTypeTiers(1);
                           this.documentEntete.setDocId(var4.getHosIdSociete());
                           this.documentEntete.setDocIdEquipe(0L);
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("");
                           this.documentEntete.setDocObject("HOSPIT");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getHosPecCnamgs() != 0.0F && this.idCnamgs != 0L && this.inpTiersPayeurs != 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == this.idCnamgs && var4.getHosFondCnamgs() != 0 && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocIdEquipe() == (long)var4.getHosFondCnamgs() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("HOSPIT")) {
                              var6 = true;
                              break;
                           }
                        }

                        if (!var6) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getHosId());
                           this.documentEntete.setDocNomTiers("CNAMGS");
                           this.documentEntete.setDocLibelle("Assurance");
                           this.documentEntete.setDocTypeTiers(0);
                           this.documentEntete.setDocId(this.idCnamgs);
                           this.documentEntete.setDocIdEquipe((long)var4.getHosFondCnamgs());
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("Fonds N." + var4.getHosFondCnamgs());
                           this.documentEntete.setDocObject("HOSPIT");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getHosIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == var4.getHosIdComplementaire() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("HOSPIT")) {
                              var8 = true;
                              break;
                           }
                        }

                        if (!var8) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getHosId());
                           this.documentEntete.setDocNomTiers(var4.getHosNomComplemtaire());
                           this.documentEntete.setDocLibelle("Complementaire");
                           this.documentEntete.setDocTypeTiers(2);
                           this.documentEntete.setDocId(var4.getHosIdComplementaire());
                           this.documentEntete.setDocIdEquipe(0L);
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("");
                           this.documentEntete.setDocObject("HOSPIT");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public void rechercheTiersConsultation_1(String var1, String var2, Session var3) throws HibernateException, NamingException {
      this.lesConsultations.clear();
      if (this.idCnamgs != 0L) {
         this.lesConsultations = this.consultationEnteteGeneDao.rechercheConsultationCnamgsPeriode(var1, var2, this.numBc, var3);
      } else {
         this.lesConsultations = this.consultationEnteteGeneDao.rechercheConsultationPeriode(var1, var2, this.idTiers, this.numBc, var3);
      }

      if (this.lesConsultations.size() != 0) {
         new ConsultationEnteteGene();
         boolean var5 = false;
         boolean var6 = false;
         boolean var7 = false;
         boolean var8 = false;

         for(int var9 = 0; var9 < this.lesConsultations.size(); ++var9) {
            ConsultationEnteteGene var4 = (ConsultationEnteteGene)this.lesConsultations.get(var9);
            if (var4.getCsgDateTransfert() == null && (this.inpTiersPayeurs == 3 && (var4.getCsgEtat() == 5 || var4.getCsgEtat() == 6) || this.inpTiersPayeurs != 3 && var4.getCsgEtat() == 5) && (this.inpTiersPayeurs == 0 || (this.inpTiersPayeurs == 1 || this.inpTiersPayeurs == 51) && var4.getCsgIdAssurance() != 0L || (this.inpTiersPayeurs == 2 || this.inpTiersPayeurs == 52) && var4.getCsgIdSociete() != 0L || (this.inpTiersPayeurs == 3 || this.inpTiersPayeurs == 53) && var4.getCsgIdComplementaire() != 0L || this.inpTiersPayeurs == 100 && var4.getCsgPecCnamgs() != 0.0F && var4.getCsgFondCnamgs() != 0 || this.inpTiersPayeurs >= 101 && var4.getCsgPecCnamgs() != 0.0F && var4.getCsgFondCnamgs() == this.inpTiersPayeurs - 100)) {
               if (var4.isCsgBloqueRefacturation()) {
                  this.documentEntete = new DocumentEntete();
                  this.documentEntete.setDocSelect(false);
                  this.documentEntete.setDocIdCreateur(var4.getCsgId());
                  this.documentEntete.setDocNomTiers(var4.getCsgNomPatient());
                  this.documentEntete.setDocLibelle("Patient" + var4.getPatients().getPatDossier());
                  this.documentEntete.setDocTypeTiers(0);
                  this.documentEntete.setDocId(var4.getCsgId());
                  this.documentEntete.setDocIdEquipe(0L);
                  this.documentEntete.setDocNomEquipe("");
                  this.documentEntete.setDocSource("");
                  this.documentEntete.setDocObject("BLOQUE : CONSULTATON N° " + var4.getCsgNum());
                  this.lesTiersRejetes.add(this.documentEntete);
               } else {
                  DocumentEntete var10 = new DocumentEntete();
                  var10.setDocSelect(false);
                  var10.setDocIdCreateur(var4.getCsgId());
                  var10.setDocNum(var4.getCsgNum());
                  var10.setDocDate(var4.getCsgDate());
                  var10.setDocNomTiers(var4.getCsgNomPatient());
                  var10.setDocIdEquipe((long)var4.getCsgFondCnamgs());
                  var10.setDocQte(var4.getCsgPecCnamgs());
                  if (var4.getCsgIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                     var10.setDocLibelle("Assurance");
                     var10.setDocTypeTiers(0);
                     var10.setDocIdResponsable(var4.getCsgIdAssurance());
                     var10.setDocIdCommercial(var4.getCsgIdEmployeur());
                     var10.setDocNomContact(var4.getCsgNomAssurance());
                     var10.setDocNomCommercial(var4.getCsgNomEmployeur());
                  } else if (var4.getCsgIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                     var10.setDocLibelle("Société");
                     var10.setDocTypeTiers(1);
                     var10.setDocIdResponsable(var4.getCsgIdSociete());
                     var10.setDocIdCommercial(0L);
                     var10.setDocNomContact(var4.getCsgNomSociete());
                     var10.setDocNomCommercial("");
                  } else if (var4.getCsgIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                     var10.setDocLibelle("Complémentaire");
                     var10.setDocTypeTiers(2);
                     var10.setDocIdResponsable(var4.getCsgIdComplementaire());
                     var10.setDocIdCommercial(0L);
                     var10.setDocNomContact(var4.getCsgNomComplemtaire());
                     var10.setDocNomCommercial("");
                  }

                  var10.setDocNumBon(var4.getCsgNumBc());
                  var10.setDocNumDocument(var4.getCsgFeuille());
                  var10.setDocCodeBanq(var4.getCsgMatricule());
                  var10.setDocService(var4.getCsgService());
                  var10.setDocEntree(var4.getMotifEntree());
                  var10.setDocActivite("Consultation");
                  var10.setDocNumDocument(var4.getCsgFeuille());
                  var10.setDocTotTtc(var4.getCsgTotGeneral());
                  var10.setDocTotTva(var4.getTotalPatient());
                  var10.setDocTotHt(var4.getTotalTiers());
                  var10.setDocObject("EXTERNE");
                  this.lesFacturesConcernes.add(var10);
                  var5 = false;
                  var6 = false;
                  var7 = false;
                  var8 = false;
                  if (this.lesTiersConcernes.size() == 0) {
                     if (var4.getCsgIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getCsgId());
                        this.documentEntete.setDocNomTiers(var4.getCsgNomAssurance());
                        this.documentEntete.setDocLibelle("Assurance");
                        this.documentEntete.setDocTypeTiers(0);
                        this.documentEntete.setDocId(var4.getCsgIdAssurance());
                        this.documentEntete.setDocIdEquipe(var4.getCsgIdEmployeur());
                        this.documentEntete.setDocNomEquipe(var4.getCsgNomEmployeur());
                        this.documentEntete.setDocSource("");
                        this.documentEntete.setDocNumBon(var4.getCsgNumBc());
                        this.documentEntete.setDocEntree("");
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getCsgIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getCsgId());
                        this.documentEntete.setDocNomTiers(var4.getCsgNomSociete());
                        this.documentEntete.setDocLibelle("Société");
                        this.documentEntete.setDocTypeTiers(1);
                        this.documentEntete.setDocId(var4.getCsgIdSociete());
                        this.documentEntete.setDocIdEquipe(0L);
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource(var4.getCsgNumSecteur());
                        this.documentEntete.setDocNumBon("");
                        this.documentEntete.setDocEntree(var4.getMotifEntree());
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getCsgPecCnamgs() != 0.0F && this.idCnamgs != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getCsgId());
                        this.documentEntete.setDocNomTiers("CNAMGS");
                        this.documentEntete.setDocLibelle("Assurance");
                        this.documentEntete.setDocTypeTiers(0);
                        this.documentEntete.setDocId(this.idCnamgs);
                        this.documentEntete.setDocIdEquipe((long)var4.getCsgFondCnamgs());
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("Fonds N." + var4.getCsgFondCnamgs());
                        this.documentEntete.setDocNumBon("");
                        this.documentEntete.setDocEntree("");
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getCsgIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getCsgId());
                        this.documentEntete.setDocNomTiers(var4.getCsgNomComplemtaire());
                        this.documentEntete.setDocLibelle("Complémentaire");
                        this.documentEntete.setDocTypeTiers(2);
                        this.documentEntete.setDocId(var4.getCsgIdComplementaire());
                        this.documentEntete.setDocIdEquipe(0L);
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("");
                        this.documentEntete.setDocNumBon("");
                        this.documentEntete.setDocEntree("");
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     }
                  } else {
                     int var11;
                     if (var4.getCsgIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == var4.getCsgIdAssurance() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocIdEquipe() == var4.getCsgIdEmployeur()) {
                              if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocNumBon() != null && !((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocNumBon().isEmpty() && !var4.getCsgNumBc().isEmpty() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocNumBon().equals(var4.getCsgNumBc())) {
                                 if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("EXTERNE")) {
                                    var5 = true;
                                    break;
                                 }
                              } else if ((((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocNumBon() == null || ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocNumBon().isEmpty()) && (var4.getCsgNumBc() == null || var4.getCsgNumBc().isEmpty()) && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("EXTERNE")) {
                                 var5 = true;
                                 break;
                              }
                           }
                        }

                        if (!var5) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getCsgId());
                           this.documentEntete.setDocNomTiers(var4.getCsgNomAssurance());
                           this.documentEntete.setDocLibelle("Assurance");
                           this.documentEntete.setDocTypeTiers(0);
                           this.documentEntete.setDocId(var4.getCsgIdAssurance());
                           this.documentEntete.setDocIdEquipe(var4.getCsgIdEmployeur());
                           this.documentEntete.setDocNomEquipe(var4.getCsgNomEmployeur());
                           this.documentEntete.setDocSource("");
                           this.documentEntete.setDocNumBon(var4.getCsgNumBc());
                           this.documentEntete.setDocEntree("");
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getCsgIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == var4.getCsgIdSociete()) {
                              if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocEntree() != null && !((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocEntree().isEmpty() && var4.getMotifEntree() != null && !var4.getMotifEntree().isEmpty() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocEntree().equals(var4.getMotifEntree())) {
                                 if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("EXTERNE")) {
                                    var7 = true;
                                    break;
                                 }
                              } else if ((((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocEntree() == null || ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocEntree().isEmpty()) && (var4.getMotifEntree() == null || var4.getMotifEntree().isEmpty())) {
                                 var7 = true;
                                 break;
                              }
                           }
                        }

                        if (!var7) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getCsgId());
                           this.documentEntete.setDocNomTiers(var4.getCsgNomSociete());
                           this.documentEntete.setDocLibelle("Société");
                           this.documentEntete.setDocTypeTiers(1);
                           this.documentEntete.setDocId(var4.getCsgIdSociete());
                           this.documentEntete.setDocIdEquipe(0L);
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource(var4.getCsgNumSecteur());
                           this.documentEntete.setDocNumBon("");
                           this.documentEntete.setDocEntree(var4.getMotifEntree());
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getCsgPecCnamgs() != 0.0F && this.idCnamgs != 0L && this.inpTiersPayeurs != 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == this.idCnamgs && var4.getCsgFondCnamgs() != 0 && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocIdEquipe() == (long)var4.getCsgFondCnamgs() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("EXTERNE")) {
                              var6 = true;
                              break;
                           }
                        }

                        if (!var6) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getCsgId());
                           this.documentEntete.setDocNomTiers("CNAMGS");
                           this.documentEntete.setDocLibelle("Assurance");
                           this.documentEntete.setDocTypeTiers(0);
                           this.documentEntete.setDocId(this.idCnamgs);
                           this.documentEntete.setDocIdEquipe((long)var4.getCsgFondCnamgs());
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("Fonds N." + var4.getCsgFondCnamgs());
                           this.documentEntete.setDocNumBon("");
                           this.documentEntete.setDocEntree("");
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getCsgIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == var4.getCsgIdComplementaire() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("EXTERNE")) {
                              var8 = true;
                              break;
                           }
                        }

                        if (!var8) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getCsgId());
                           this.documentEntete.setDocNomTiers(var4.getCsgNomComplemtaire());
                           this.documentEntete.setDocLibelle("Complementaire");
                           this.documentEntete.setDocTypeTiers(2);
                           this.documentEntete.setDocId(var4.getCsgIdComplementaire());
                           this.documentEntete.setDocIdEquipe(0L);
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("");
                           this.documentEntete.setDocNumBon("");
                           this.documentEntete.setDocEntree(var4.getCsgEntree());
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public void rechercheTiersPharmacie_1(String var1, String var2, Session var3) throws HibernateException, NamingException {
      this.lesPharamcies.clear();
      if (this.idCnamgs != 0L) {
         this.lesPharamcies = this.pharmacieEnteteDao.recherchePharmacieCnamgsPeriode(var1, var2, this.numBc, var3);
      } else {
         this.lesPharamcies = this.pharmacieEnteteDao.recherchePharmaciePeriode(var1, var2, this.idTiers, this.numBc, var3);
      }

      if (this.lesPharamcies.size() != 0) {
         new PharmacieEntete();
         boolean var5 = false;
         boolean var6 = false;
         boolean var7 = false;
         boolean var8 = false;

         for(int var9 = 0; var9 < this.lesPharamcies.size(); ++var9) {
            PharmacieEntete var4 = (PharmacieEntete)this.lesPharamcies.get(var9);
            if (var4.getPhaDateTransfert() == null && (this.inpTiersPayeurs == 3 && (var4.getPhaEtat() == 5 || var4.getPhaEtat() == 6) || this.inpTiersPayeurs != 3 && var4.getPhaEtat() == 5) && (this.inpTiersPayeurs == 0 || (this.inpTiersPayeurs == 1 || this.inpTiersPayeurs == 51) && var4.getPhaIdAssurance() != 0L || (this.inpTiersPayeurs == 2 || this.inpTiersPayeurs == 52) && var4.getPhaIdSociete() != 0L || (this.inpTiersPayeurs == 3 || this.inpTiersPayeurs == 53) && var4.getPhaIdComplementaire() != 0L || this.inpTiersPayeurs == 100 && var4.getPhaPecCnamgs() != 0.0F && var4.getPhaFondCnamgs() != 0 || this.inpTiersPayeurs >= 101 && var4.getPhaPecCnamgs() != 0.0F && var4.getPhaFondCnamgs() == this.inpTiersPayeurs - 100)) {
               if (var4.isPhaBloqueRefacturation()) {
                  this.documentEntete = new DocumentEntete();
                  this.documentEntete.setDocSelect(false);
                  this.documentEntete.setDocIdCreateur(var4.getPhaId());
                  this.documentEntete.setDocNomTiers(var4.getPhaNomPatient());
                  this.documentEntete.setDocLibelle("Patient" + var4.getPatients().getPatDossier());
                  this.documentEntete.setDocTypeTiers(0);
                  this.documentEntete.setDocId(var4.getPhaId());
                  this.documentEntete.setDocIdEquipe(0L);
                  this.documentEntete.setDocNomEquipe("");
                  this.documentEntete.setDocSource("");
                  this.documentEntete.setDocObject("BLQUE : PHARMACIE N° " + var4.getPhaNum());
                  this.lesTiersRejetes.add(this.documentEntete);
               } else {
                  DocumentEntete var10 = new DocumentEntete();
                  var10.setDocSelect(false);
                  var10.setDocIdCreateur(var4.getPhaId());
                  var10.setDocNum(var4.getPhaNum());
                  var10.setDocDate(var4.getPhaDate());
                  var10.setDocNomTiers(var4.getPhaNomPatient());
                  var10.setDocIdEquipe((long)var4.getPhaFondCnamgs());
                  var10.setDocQte(var4.getPhaPecCnamgs());
                  if (var4.getPhaIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                     var10.setDocLibelle("Assurance");
                     var10.setDocTypeTiers(0);
                     var10.setDocIdResponsable(var4.getPhaIdAssurance());
                     var10.setDocIdCommercial(var4.getPhaIdEmployeur());
                     var10.setDocNomContact(var4.getPhaNomAssurance());
                     var10.setDocNomCommercial(var4.getPhaNomEmployeur());
                  } else if (var4.getPhaIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                     var10.setDocLibelle("Société");
                     var10.setDocTypeTiers(1);
                     var10.setDocIdResponsable(var4.getPhaIdSociete());
                     var10.setDocIdCommercial(0L);
                     var10.setDocNomContact(var4.getPhaNomSociete());
                     var10.setDocNomCommercial("");
                  } else if (var4.getPhaIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                     var10.setDocLibelle("Complémentaire");
                     var10.setDocTypeTiers(2);
                     var10.setDocIdResponsable(var4.getPhaIdComplementaire());
                     var10.setDocIdCommercial(0L);
                     var10.setDocNomContact(var4.getPhaNomComplemtaire());
                     var10.setDocNomCommercial("");
                  }

                  var10.setDocNumBon(var4.getPhaNumBc());
                  var10.setDocNumDocument(var4.getPhaFeuille());
                  var10.setDocCodeBanq(var4.getPhaMatricule());
                  var10.setDocService(var4.getPhaService());
                  var10.setDocEntree("");
                  var10.setDocActivite("Pharmacie");
                  var10.setDocNumDocument(var4.getPhaFeuille());
                  var10.setDocTotTtc(var4.getPhaTotGeneral());
                  var10.setDocTotTva(var4.getTotalPatient());
                  var10.setDocTotHt(var4.getTotalTiers());
                  var10.setDocObject("EXTERNE");
                  this.lesFacturesConcernes.add(var10);
                  var5 = false;
                  var6 = false;
                  var7 = false;
                  var8 = false;
                  if (this.lesTiersConcernes.size() == 0) {
                     if (var4.getPhaIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getPhaId());
                        this.documentEntete.setDocNomTiers(var4.getPhaNomAssurance());
                        this.documentEntete.setDocLibelle("Assurance");
                        this.documentEntete.setDocTypeTiers(0);
                        this.documentEntete.setDocId(var4.getPhaIdAssurance());
                        this.documentEntete.setDocIdEquipe(var4.getPhaIdEmployeur());
                        this.documentEntete.setDocNomEquipe(var4.getPhaNomEmployeur());
                        this.documentEntete.setDocSource("");
                        this.documentEntete.setDocNumBon(var4.getPhaNumBc());
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getPhaIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getPhaId());
                        this.documentEntete.setDocNomTiers(var4.getPhaNomSociete());
                        this.documentEntete.setDocLibelle("Société");
                        this.documentEntete.setDocTypeTiers(1);
                        this.documentEntete.setDocId(var4.getPhaIdSociete());
                        this.documentEntete.setDocIdEquipe(0L);
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource(var4.getPhaNumSecteur());
                        this.documentEntete.setDocNumBon("");
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getPhaPecCnamgs() != 0.0F && this.idCnamgs != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getPhaId());
                        this.documentEntete.setDocNomTiers("CNAMGS");
                        this.documentEntete.setDocLibelle("Assurance");
                        this.documentEntete.setDocTypeTiers(0);
                        this.documentEntete.setDocId(this.idCnamgs);
                        this.documentEntete.setDocIdEquipe((long)var4.getPhaFondCnamgs());
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("Fonds N." + var4.getPhaFondCnamgs());
                        this.documentEntete.setDocNumBon("");
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getPhaIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getPhaId());
                        this.documentEntete.setDocNomTiers(var4.getPhaNomComplemtaire());
                        this.documentEntete.setDocLibelle("Complémentaire");
                        this.documentEntete.setDocTypeTiers(2);
                        this.documentEntete.setDocId(var4.getPhaIdComplementaire());
                        this.documentEntete.setDocIdEquipe(0L);
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("");
                        this.documentEntete.setDocNumBon("");
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     }
                  } else {
                     int var11;
                     if (var4.getPhaIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == var4.getPhaIdAssurance() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocIdEquipe() == var4.getPhaIdEmployeur()) {
                              if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocNumBon() != null && !((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocNumBon().isEmpty() && !var4.getPhaNumBc().isEmpty() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocNumBon().equals(var4.getPhaNumBc())) {
                                 if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("EXTERNE")) {
                                    var5 = true;
                                    break;
                                 }
                              } else if ((((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocNumBon() == null || ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocNumBon().isEmpty()) && (var4.getPhaNumBc() == null || var4.getPhaNumBc().isEmpty()) && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("EXTERNE")) {
                                 var5 = true;
                                 break;
                              }
                           }
                        }

                        if (!var5) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getPhaId());
                           this.documentEntete.setDocNomTiers(var4.getPhaNomAssurance());
                           this.documentEntete.setDocLibelle("Assurance");
                           this.documentEntete.setDocTypeTiers(0);
                           this.documentEntete.setDocId(var4.getPhaIdAssurance());
                           this.documentEntete.setDocIdEquipe(var4.getPhaIdEmployeur());
                           this.documentEntete.setDocNomEquipe(var4.getPhaNomEmployeur());
                           this.documentEntete.setDocSource("");
                           this.documentEntete.setDocNumBon(var4.getPhaNumBc());
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getPhaIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == var4.getPhaIdSociete()) {
                              if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocSource() != null && !((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocSource().isEmpty() && var4.getPhaNumSecteur() != null && !var4.getPhaNumSecteur().isEmpty() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocSource().equals(var4.getPhaNumSecteur())) {
                                 if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("EXTERNE")) {
                                    var7 = true;
                                    break;
                                 }
                              } else if ((((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocSource() == null || ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocSource().isEmpty()) && (var4.getPhaNumSecteur() == null || var4.getPhaNumSecteur().isEmpty())) {
                                 var7 = true;
                                 break;
                              }
                           }
                        }

                        if (!var7) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getPhaId());
                           this.documentEntete.setDocNomTiers(var4.getPhaNomSociete());
                           this.documentEntete.setDocLibelle("Société");
                           this.documentEntete.setDocTypeTiers(1);
                           this.documentEntete.setDocId(var4.getPhaIdSociete());
                           this.documentEntete.setDocIdEquipe(0L);
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource(var4.getPhaNumSecteur());
                           this.documentEntete.setDocNumBon("");
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getPhaPecCnamgs() != 0.0F && this.idCnamgs != 0L && this.inpTiersPayeurs != 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == this.idCnamgs && var4.getPhaFondCnamgs() != 0 && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocIdEquipe() == (long)var4.getPhaFondCnamgs() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("EXTERNE")) {
                              var6 = true;
                              break;
                           }
                        }

                        if (!var6) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getPhaId());
                           this.documentEntete.setDocNomTiers("CNAMGS");
                           this.documentEntete.setDocLibelle("Assurance");
                           this.documentEntete.setDocTypeTiers(0);
                           this.documentEntete.setDocId(this.idCnamgs);
                           this.documentEntete.setDocIdEquipe((long)var4.getPhaFondCnamgs());
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("Fonds N." + var4.getPhaFondCnamgs());
                           this.documentEntete.setDocNumBon("");
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getPhaIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == var4.getPhaIdComplementaire() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("EXTERNE")) {
                              var8 = true;
                              break;
                           }
                        }

                        if (!var8) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getPhaId());
                           this.documentEntete.setDocNomTiers(var4.getPhaNomComplemtaire());
                           this.documentEntete.setDocLibelle("Complementaire");
                           this.documentEntete.setDocTypeTiers(2);
                           this.documentEntete.setDocId(var4.getPhaIdComplementaire());
                           this.documentEntete.setDocIdEquipe(0L);
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("");
                           this.documentEntete.setDocNumBon("");
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public void rechercheTiersLaboratoire_1(String var1, String var2, Session var3) throws HibernateException, NamingException {
      this.lesLaboratoires.clear();
      if (this.idCnamgs != 0L) {
         this.lesLaboratoires = this.laboratoireEnteteDao.rechercheLaboratoireCnamgsPeriode(var1, var2, this.numBc, var3);
      } else {
         this.lesLaboratoires = this.laboratoireEnteteDao.rechercheLaboratoirePeriode(var1, var2, this.idTiers, this.numBc, var3);
      }

      if (this.lesLaboratoires.size() != 0) {
         new LaboratoireEntete();
         boolean var5 = false;
         boolean var6 = false;
         boolean var7 = false;
         boolean var8 = false;

         for(int var9 = 0; var9 < this.lesLaboratoires.size(); ++var9) {
            LaboratoireEntete var4 = (LaboratoireEntete)this.lesLaboratoires.get(var9);
            if (var4.getLabDateTransfert() == null && (this.inpTiersPayeurs == 3 && (var4.getLabEtat() == 5 || var4.getLabEtat() == 6) || this.inpTiersPayeurs != 3 && var4.getLabEtat() == 5) && (this.inpTiersPayeurs == 0 || (this.inpTiersPayeurs == 1 || this.inpTiersPayeurs == 51) && var4.getLabIdAssurance() != 0L || (this.inpTiersPayeurs == 2 || this.inpTiersPayeurs == 52) && var4.getLabIdSociete() != 0L || (this.inpTiersPayeurs == 3 || this.inpTiersPayeurs == 53) && var4.getLabIdComplementaire() != 0L || this.inpTiersPayeurs == 100 && var4.getLabPecCnamgs() != 0.0F && var4.getLabFondCnamgs() != 0 || this.inpTiersPayeurs >= 101 && var4.getLabPecCnamgs() != 0.0F && var4.getLabFondCnamgs() == this.inpTiersPayeurs - 100)) {
               if (var4.isLabBloqueRefacturation()) {
                  this.documentEntete = new DocumentEntete();
                  this.documentEntete.setDocSelect(false);
                  this.documentEntete.setDocIdCreateur(var4.getLabId());
                  this.documentEntete.setDocNomTiers(var4.getLabNomPatient());
                  this.documentEntete.setDocLibelle("Patient" + var4.getPatients().getPatDossier());
                  this.documentEntete.setDocTypeTiers(0);
                  this.documentEntete.setDocId(var4.getLabId());
                  this.documentEntete.setDocIdEquipe(0L);
                  this.documentEntete.setDocNomEquipe("");
                  this.documentEntete.setDocSource("");
                  this.documentEntete.setDocObject("BLOQUE : LABORATOIRE N° " + var4.getLabNum());
                  this.lesTiersRejetes.add(this.documentEntete);
               } else {
                  DocumentEntete var10 = new DocumentEntete();
                  var10.setDocSelect(false);
                  var10.setDocIdCreateur(var4.getLabId());
                  var10.setDocNum(var4.getLabNum());
                  var10.setDocDate(var4.getLabDate());
                  var10.setDocNomTiers(var4.getLabNomPatient());
                  var10.setDocIdEquipe((long)var4.getLabFondCnamgs());
                  var10.setDocQte(var4.getLabPecCnamgs());
                  if (var4.getLabIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                     var10.setDocLibelle("Assurance");
                     var10.setDocTypeTiers(0);
                     var10.setDocIdResponsable(var4.getLabIdAssurance());
                     var10.setDocIdCommercial(var4.getLabIdEmployeur());
                     var10.setDocNomContact(var4.getLabNomAssurance());
                     var10.setDocNomCommercial(var4.getLabNomEmployeur());
                  } else if (var4.getLabIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                     var10.setDocLibelle("Société");
                     var10.setDocTypeTiers(1);
                     var10.setDocIdResponsable(var4.getLabIdSociete());
                     var10.setDocIdCommercial(0L);
                     var10.setDocNomContact(var4.getLabNomSociete());
                     var10.setDocNomCommercial("");
                  } else if (var4.getLabIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                     var10.setDocLibelle("Complémentaire");
                     var10.setDocTypeTiers(2);
                     var10.setDocIdResponsable(var4.getLabIdComplementaire());
                     var10.setDocIdCommercial(0L);
                     var10.setDocNomContact(var4.getLabNomComplemtaire());
                     var10.setDocNomCommercial("");
                  }

                  var10.setDocNumBon(var4.getLabNumBc());
                  var10.setDocNumDocument(var4.getLabFeuille());
                  var10.setDocCodeBanq(var4.getLabMatricule());
                  var10.setDocService(var4.getLabService());
                  if (var4.getLabService() != null && !var4.getLabService().isEmpty()) {
                     if (var4.getLabService().contains(":")) {
                        String[] var11 = var4.getLabService().split(":");
                        var10.setDocActivite(var11[1]);
                     } else {
                        var10.setDocActivite(var4.getLabService());
                     }
                  } else {
                     var10.setDocActivite("Laboratoire");
                  }

                  var10.setDocEntree(var4.getMotifEntree());
                  var10.setDocNumDocument(var4.getLabFeuille());
                  var10.setDocTotTtc(var4.getLabTotGeneral());
                  var10.setDocTotTva(var4.getTotalPatient());
                  var10.setDocTotHt(var4.getTotalTiers());
                  var10.setDocObject("EXTERNE");
                  this.lesFacturesConcernes.add(var10);
                  var5 = false;
                  var6 = false;
                  var7 = false;
                  var8 = false;
                  if (this.lesTiersConcernes.size() == 0) {
                     if (var4.getLabIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getLabId());
                        this.documentEntete.setDocNomTiers(var4.getLabNomAssurance());
                        this.documentEntete.setDocLibelle("Assurance");
                        this.documentEntete.setDocTypeTiers(0);
                        this.documentEntete.setDocId(var4.getLabIdAssurance());
                        this.documentEntete.setDocIdEquipe(var4.getLabIdEmployeur());
                        this.documentEntete.setDocNomEquipe(var4.getLabNomEmployeur());
                        this.documentEntete.setDocSource("");
                        this.documentEntete.setDocNumBon(var4.getLabNumBc());
                        this.documentEntete.setDocEntree("");
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getLabIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getLabId());
                        this.documentEntete.setDocNomTiers(var4.getLabNomSociete());
                        this.documentEntete.setDocLibelle("Société");
                        this.documentEntete.setDocTypeTiers(1);
                        this.documentEntete.setDocId(var4.getLabIdSociete());
                        this.documentEntete.setDocIdEquipe(0L);
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource(var4.getLabNumSecteur());
                        this.documentEntete.setDocNumBon("");
                        this.documentEntete.setDocEntree(var4.getMotifEntree());
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getLabPecCnamgs() != 0.0F && this.idCnamgs != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getLabId());
                        this.documentEntete.setDocNomTiers("CNAMGS");
                        this.documentEntete.setDocLibelle("Assurance");
                        this.documentEntete.setDocTypeTiers(0);
                        this.documentEntete.setDocId(this.idCnamgs);
                        this.documentEntete.setDocIdEquipe((long)var4.getLabFondCnamgs());
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("Fonds N." + var4.getLabFondCnamgs());
                        this.documentEntete.setDocNumBon("");
                        this.documentEntete.setDocEntree("");
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getLabIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getLabId());
                        this.documentEntete.setDocNomTiers(var4.getLabNomComplemtaire());
                        this.documentEntete.setDocLibelle("Complémentaire");
                        this.documentEntete.setDocTypeTiers(2);
                        this.documentEntete.setDocId(var4.getLabIdComplementaire());
                        this.documentEntete.setDocIdEquipe(0L);
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("");
                        this.documentEntete.setDocNumBon("");
                        this.documentEntete.setDocEntree("");
                        this.documentEntete.setDocObject("EXTERNE");
                        this.lesTiersConcernes.add(this.documentEntete);
                     }
                  } else {
                     int var12;
                     if (var4.getLabIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                        for(var12 = 0; var12 < this.lesTiersConcernes.size(); ++var12) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocId() == var4.getLabIdAssurance()) {
                              if (((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocNumBon() != null && !((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocNumBon().isEmpty() && !var4.getLabNumBc().isEmpty() && ((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocNumBon().equals(var4.getLabNumBc())) {
                                 if (((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocObject().equals("EXTERNE")) {
                                    var5 = true;
                                    break;
                                 }
                              } else if ((((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocNumBon() == null || ((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocNumBon().isEmpty()) && (var4.getLabNumBc() == null || var4.getLabNumBc().isEmpty()) && ((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocObject().equals("EXTERNE")) {
                                 var5 = true;
                                 break;
                              }
                           }
                        }

                        if (!var5) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getLabId());
                           this.documentEntete.setDocNomTiers(var4.getLabNomAssurance());
                           this.documentEntete.setDocLibelle("Assurance");
                           this.documentEntete.setDocTypeTiers(0);
                           this.documentEntete.setDocId(var4.getLabIdAssurance());
                           this.documentEntete.setDocIdEquipe(var4.getLabIdEmployeur());
                           this.documentEntete.setDocNomEquipe(var4.getLabNomEmployeur());
                           this.documentEntete.setDocSource("");
                           this.documentEntete.setDocNumBon("");
                           this.documentEntete.setDocEntree("");
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getLabIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                        for(var12 = 0; var12 < this.lesTiersConcernes.size(); ++var12) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocId() == var4.getLabIdSociete()) {
                              if (((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocEntree() != null && !((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocEntree().isEmpty() && var4.getMotifEntree() != null && !var4.getMotifEntree().isEmpty() && ((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocEntree().equals(var4.getMotifEntree())) {
                                 if (((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocObject().equals("EXTERNE")) {
                                    var7 = true;
                                    break;
                                 }
                              } else if ((((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocEntree() == null || ((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocEntree().isEmpty()) && (var4.getMotifEntree() == null || var4.getMotifEntree().isEmpty())) {
                                 var7 = true;
                                 break;
                              }
                           }
                        }

                        if (!var7) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getLabId());
                           this.documentEntete.setDocNomTiers(var4.getLabNomSociete());
                           this.documentEntete.setDocLibelle("Société");
                           this.documentEntete.setDocTypeTiers(1);
                           this.documentEntete.setDocId(var4.getLabIdSociete());
                           this.documentEntete.setDocIdEquipe(0L);
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource(var4.getLabNumSecteur());
                           this.documentEntete.setDocNumBon("");
                           this.documentEntete.setDocEntree(var4.getMotifEntree());
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getLabPecCnamgs() != 0.0F && this.idCnamgs != 0L && this.inpTiersPayeurs != 3) {
                        for(var12 = 0; var12 < this.lesTiersConcernes.size(); ++var12) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocId() == this.idCnamgs && var4.getLabFondCnamgs() != 0 && ((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocIdEquipe() == (long)var4.getLabFondCnamgs() && ((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocObject().equals("EXTERNE")) {
                              var6 = true;
                              break;
                           }
                        }

                        if (!var6) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getLabId());
                           this.documentEntete.setDocNomTiers("CNAMGS");
                           this.documentEntete.setDocLibelle("Assurance");
                           this.documentEntete.setDocTypeTiers(0);
                           this.documentEntete.setDocId(this.idCnamgs);
                           this.documentEntete.setDocIdEquipe((long)var4.getLabFondCnamgs());
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("Fonds N." + var4.getLabFondCnamgs());
                           this.documentEntete.setDocNumBon("");
                           this.documentEntete.setDocEntree("");
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getLabIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                        for(var12 = 0; var12 < this.lesTiersConcernes.size(); ++var12) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocId() == var4.getLabIdComplementaire() && ((DocumentEntete)this.lesTiersConcernes.get(var12)).getDocObject().equals("EXTERNE")) {
                              var8 = true;
                              break;
                           }
                        }

                        if (!var8) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getLabId());
                           this.documentEntete.setDocNomTiers(var4.getLabNomComplemtaire());
                           this.documentEntete.setDocLibelle("Complementaire");
                           this.documentEntete.setDocTypeTiers(2);
                           this.documentEntete.setDocId(var4.getLabIdComplementaire());
                           this.documentEntete.setDocIdEquipe(0L);
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("");
                           this.documentEntete.setDocNumBon("");
                           this.documentEntete.setDocEntree("");
                           this.documentEntete.setDocObject("EXTERNE");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public void rechercheTiersHospitalisation_1(String var1, String var2, Session var3) throws HibernateException, NamingException {
      this.lesHospits.clear();
      if (this.idCnamgs != 0L) {
         this.lesHospits = this.hospitalisationEnteteDao.rechercheHospitalisationCnamgsPeriode(var1, var2, this.numBc, var3);
      } else {
         this.lesHospits = this.hospitalisationEnteteDao.rechercheHospitalisationPeriode(var1, var2, this.idTiers, this.numBc, var3);
      }

      if (this.lesHospits.size() != 0) {
         new HospitalisationEntete();
         boolean var5 = false;
         boolean var6 = false;
         boolean var7 = false;
         boolean var8 = false;

         for(int var9 = 0; var9 < this.lesHospits.size(); ++var9) {
            HospitalisationEntete var4 = (HospitalisationEntete)this.lesHospits.get(var9);
            if (var4.getHosDateTransfert() == null && (this.inpTiersPayeurs == 3 && (var4.getHosEtat() == 5 || var4.getHosEtat() == 6) || this.inpTiersPayeurs != 3 && var4.getHosEtat() == 5) && (this.inpTiersPayeurs == 0 || (this.inpTiersPayeurs == 1 || this.inpTiersPayeurs == 61) && var4.getHosIdAssurance() != 0L || (this.inpTiersPayeurs == 2 || this.inpTiersPayeurs == 62) && var4.getHosIdSociete() != 0L || (this.inpTiersPayeurs == 3 || this.inpTiersPayeurs == 63) && var4.getHosIdComplementaire() != 0L || this.inpTiersPayeurs == 100 && var4.getHosPecCnamgs() != 0.0F && var4.getHosFondCnamgs() != 0 || this.inpTiersPayeurs >= 101 && var4.getHosPecCnamgs() != 0.0F && var4.getHosFondCnamgs() == this.inpTiersPayeurs - 100)) {
               if (var4.isHosBloqueRefacturation()) {
                  this.documentEntete = new DocumentEntete();
                  this.documentEntete.setDocSelect(false);
                  this.documentEntete.setDocIdCreateur(var4.getHosId());
                  this.documentEntete.setDocNomTiers(var4.getHosNomPatient());
                  this.documentEntete.setDocLibelle("Patient" + var4.getPatients().getPatDossier());
                  this.documentEntete.setDocTypeTiers(0);
                  this.documentEntete.setDocId(var4.getHosId());
                  this.documentEntete.setDocIdEquipe(0L);
                  this.documentEntete.setDocNomEquipe("");
                  this.documentEntete.setDocSource("");
                  this.documentEntete.setDocObject("BLOQUE : HOSPITALISATION N° " + var4.getHosNum());
                  this.lesTiersRejetes.add(this.documentEntete);
               } else {
                  DocumentEntete var10 = new DocumentEntete();
                  var10.setDocSelect(false);
                  var10.setDocIdCreateur(var4.getHosId());
                  var10.setDocNum(var4.getHosNum());
                  var10.setDocDate(var4.getHosDateSortie());
                  var10.setDocNomTiers(var4.getHosNomPatient());
                  if (var4.getHosIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                     var10.setDocLibelle("Assurance");
                     var10.setDocTypeTiers(0);
                     var10.setDocIdResponsable(var4.getHosIdAssurance());
                     var10.setDocIdCommercial(var4.getHosIdEmployeur());
                     var10.setDocNomContact(var4.getHosNomAssurance());
                     var10.setDocNomCommercial(var4.getHosNomEmployeur());
                     var10.setDocEntree("");
                  } else if (var4.getHosIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                     var10.setDocLibelle("Société");
                     var10.setDocTypeTiers(1);
                     var10.setDocIdResponsable(var4.getHosIdSociete());
                     var10.setDocIdCommercial(0L);
                     var10.setDocNomContact(var4.getHosNomSociete());
                     var10.setDocNomCommercial("");
                     var10.setDocEntree(var4.getHosMotifEntree());
                  } else if (var4.getHosIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                     var10.setDocLibelle("Complémentaire");
                     var10.setDocTypeTiers(2);
                     var10.setDocIdResponsable(var4.getHosIdComplementaire());
                     var10.setDocIdCommercial(0L);
                     var10.setDocNomContact(var4.getHosNomComplemtaire());
                     var10.setDocNomCommercial("");
                     var10.setDocEntree("");
                  }

                  var10.setDocNumBon(var4.getHosNumBc());
                  var10.setDocNumDocument(var4.getHosFeuille());
                  var10.setDocCodeBanq(var4.getHosMatricule());
                  var10.setDocService(var4.getHosService());
                  var10.setDocActivite("Hospitalisation");
                  var10.setDocNumDocument(var4.getHosFeuille());
                  var10.setDocTotTtc(var4.getHosTotGeneral());
                  var10.setDocTotTva(var4.getTotalPatient());
                  var10.setDocTotHt(var4.getTotalTiers());
                  var10.setDocObject("HOSPIT");
                  this.lesFacturesConcernes.add(var10);
                  var5 = false;
                  var6 = false;
                  var7 = false;
                  var8 = false;
                  if (this.lesTiersConcernes.size() == 0) {
                     if (var4.getHosIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getHosId());
                        this.documentEntete.setDocNomTiers(var4.getHosNomAssurance());
                        this.documentEntete.setDocLibelle("Assurance");
                        this.documentEntete.setDocTypeTiers(0);
                        this.documentEntete.setDocId(var4.getHosIdAssurance());
                        this.documentEntete.setDocIdEquipe(var4.getHosIdEmployeur());
                        this.documentEntete.setDocNomEquipe(var4.getHosNomEmployeur());
                        this.documentEntete.setDocSource("");
                        this.documentEntete.setDocNumBon(var4.getHosNumBc());
                        this.documentEntete.setDocEntree("");
                        this.documentEntete.setDocObject("HOSPIT");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getHosIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getHosId());
                        this.documentEntete.setDocNomTiers(var4.getHosNomSociete());
                        this.documentEntete.setDocLibelle("Société");
                        this.documentEntete.setDocTypeTiers(1);
                        this.documentEntete.setDocId(var4.getHosIdSociete());
                        this.documentEntete.setDocIdEquipe(0L);
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("");
                        this.documentEntete.setDocNumBon("");
                        this.documentEntete.setDocEntree(var4.getHosMotifEntree());
                        this.documentEntete.setDocObject("HOSPIT");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getHosPecCnamgs() != 0.0F && this.idCnamgs != 0L && this.inpTiersPayeurs != 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getHosId());
                        this.documentEntete.setDocNomTiers("CNAMGS");
                        this.documentEntete.setDocLibelle("Assurance");
                        this.documentEntete.setDocTypeTiers(0);
                        this.documentEntete.setDocId(this.idCnamgs);
                        this.documentEntete.setDocIdEquipe((long)var4.getHosFondCnamgs());
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("Fonds N." + var4.getHosFondCnamgs());
                        this.documentEntete.setDocNumBon("");
                        this.documentEntete.setDocEntree("");
                        this.documentEntete.setDocObject("HOSPIT");
                        this.lesTiersConcernes.add(this.documentEntete);
                     } else if (var4.getHosIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                        this.documentEntete = new DocumentEntete();
                        this.documentEntete.setDocSelect(false);
                        this.documentEntete.setDocIdCreateur(var4.getHosId());
                        this.documentEntete.setDocNomTiers(var4.getHosNomComplemtaire());
                        this.documentEntete.setDocLibelle("Complémentaire");
                        this.documentEntete.setDocTypeTiers(2);
                        this.documentEntete.setDocId(var4.getHosIdComplementaire());
                        this.documentEntete.setDocIdEquipe(0L);
                        this.documentEntete.setDocNomEquipe("");
                        this.documentEntete.setDocSource("");
                        this.documentEntete.setDocNumBon("");
                        this.documentEntete.setDocEntree("");
                        this.documentEntete.setDocObject("HOSPIT");
                        this.lesTiersConcernes.add(this.documentEntete);
                     }
                  } else {
                     int var11;
                     if (var4.getHosIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == var4.getHosIdAssurance()) {
                              if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocNumBon() != null && !((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocNumBon().isEmpty() && !var4.getHosNumBc().isEmpty() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocNumBon().equals(var4.getHosNumBc())) {
                                 if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("EXTERNE")) {
                                    var5 = true;
                                    break;
                                 }
                              } else if ((((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocNumBon() == null || ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocNumBon().isEmpty()) && (var4.getHosNumBc() == null || var4.getHosNumBc().isEmpty()) && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("EXTERNE")) {
                                 var5 = true;
                                 break;
                              }
                           }
                        }

                        if (!var5) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getHosId());
                           this.documentEntete.setDocNomTiers(var4.getHosNomAssurance());
                           this.documentEntete.setDocLibelle("Assurance");
                           this.documentEntete.setDocTypeTiers(0);
                           this.documentEntete.setDocId(var4.getHosIdAssurance());
                           this.documentEntete.setDocIdEquipe(var4.getHosIdEmployeur());
                           this.documentEntete.setDocNomEquipe(var4.getHosNomEmployeur());
                           this.documentEntete.setDocSource("");
                           this.documentEntete.setDocNumBon(var4.getHosNumBc());
                           this.documentEntete.setDocEntree("");
                           this.documentEntete.setDocObject("HOSPIT");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getHosIdSociete() != 0L && this.inpTiersPayeurs != 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == var4.getHosIdSociete()) {
                              if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocEntree() != null && !((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocEntree().isEmpty() && var4.getHosMotifEntree() != null && !var4.getHosMotifEntree().isEmpty() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocEntree().equals(var4.getHosMotifEntree())) {
                                 if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("EXTERNE")) {
                                    var7 = true;
                                    break;
                                 }
                              } else if ((((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocEntree() == null || ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocEntree().isEmpty()) && (var4.getHosMotifEntree() == null || var4.getHosMotifEntree().isEmpty())) {
                                 var7 = true;
                                 break;
                              }
                           }
                        }

                        if (!var7) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getHosId());
                           this.documentEntete.setDocNomTiers(var4.getHosNomSociete());
                           this.documentEntete.setDocLibelle("Société");
                           this.documentEntete.setDocTypeTiers(1);
                           this.documentEntete.setDocId(var4.getHosIdSociete());
                           this.documentEntete.setDocIdEquipe(0L);
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("");
                           this.documentEntete.setDocNumBon("");
                           this.documentEntete.setDocEntree(var4.getHosMotifEntree());
                           this.documentEntete.setDocObject("HOSPIT");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getHosPecCnamgs() != 0.0F && this.idCnamgs != 0L && this.inpTiersPayeurs != 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == this.idCnamgs && var4.getHosFondCnamgs() != 0 && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocIdEquipe() == (long)var4.getHosFondCnamgs() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("HOSPIT")) {
                              var6 = true;
                              break;
                           }
                        }

                        if (!var6) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getHosId());
                           this.documentEntete.setDocNomTiers("CNAMGS");
                           this.documentEntete.setDocLibelle("Assurance");
                           this.documentEntete.setDocTypeTiers(0);
                           this.documentEntete.setDocId(this.idCnamgs);
                           this.documentEntete.setDocIdEquipe((long)var4.getHosFondCnamgs());
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("Fonds N." + var4.getHosFondCnamgs());
                           this.documentEntete.setDocNumBon("");
                           this.documentEntete.setDocEntree("");
                           this.documentEntete.setDocObject("HOSPIT");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     } else if (var4.getHosIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
                        for(var11 = 0; var11 < this.lesTiersConcernes.size(); ++var11) {
                           if (((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocId() == var4.getHosIdComplementaire() && ((DocumentEntete)this.lesTiersConcernes.get(var11)).getDocObject().equals("HOSPIT")) {
                              var8 = true;
                              break;
                           }
                        }

                        if (!var8) {
                           this.documentEntete = new DocumentEntete();
                           this.documentEntete.setDocSelect(false);
                           this.documentEntete.setDocIdCreateur(var4.getHosId());
                           this.documentEntete.setDocNomTiers(var4.getHosNomComplemtaire());
                           this.documentEntete.setDocLibelle("Complementaire");
                           this.documentEntete.setDocTypeTiers(2);
                           this.documentEntete.setDocId(var4.getHosIdComplementaire());
                           this.documentEntete.setDocIdEquipe(0L);
                           this.documentEntete.setDocNomEquipe("");
                           this.documentEntete.setDocSource("");
                           this.documentEntete.setDocNumBon("");
                           this.documentEntete.setDocEntree("");
                           this.documentEntete.setDocObject("HOSPIT");
                           this.lesTiersConcernes.add(this.documentEntete);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public void rechercheTiersConsultation_2(String var1, String var2, Session var3) throws HibernateException, NamingException {
      this.lesConsultations.clear();
      this.lesFacturesConcernes.clear();
      if (this.idCnamgs != 0L) {
         this.lesConsultations = this.consultationEnteteGeneDao.rechercheConsultationCnamgsPeriode(var1, var2, this.numBc, var3);
      } else {
         this.lesConsultations = this.consultationEnteteGeneDao.rechercheConsultationPeriode(var1, var2, this.idTiers, this.numBc, var3);
      }

      if (this.lesConsultations.size() != 0) {
         new ConsultationEnteteGene();

         for(int var5 = 0; var5 < this.lesConsultations.size(); ++var5) {
            ConsultationEnteteGene var4 = (ConsultationEnteteGene)this.lesConsultations.get(var5);
            this.calculeConsultation_2(var4);
         }
      }

   }

   public void calculeConsultation_2(ConsultationEnteteGene var1) {
      if (var1.getCsgDateTransfert() == null && (this.inpTiersPayeurs == 3 && (var1.getCsgEtat() == 5 || var1.getCsgEtat() == 6) || this.inpTiersPayeurs != 3 && var1.getCsgEtat() == 5) && (this.inpTiersPayeurs == 0 || (this.inpTiersPayeurs == 1 || this.inpTiersPayeurs == 51) && var1.getCsgIdAssurance() != 0L || (this.inpTiersPayeurs == 2 || this.inpTiersPayeurs == 52) && var1.getCsgIdSociete() != 0L || (this.inpTiersPayeurs == 3 || this.inpTiersPayeurs == 53) && var1.getCsgIdComplementaire() != 0L || this.inpTiersPayeurs == 100 && var1.getCsgPecCnamgs() != 0.0F && var1.getCsgFondCnamgs() != 0 || this.inpTiersPayeurs >= 101 && var1.getCsgPecCnamgs() != 0.0F && var1.getCsgFondCnamgs() == this.inpTiersPayeurs - 100)) {
         if (!var1.isCsgBloqueRefacturation()) {
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setDocSelect(false);
            this.documentEntete.setDocIdCreateur(var1.getCsgId());
            this.documentEntete.setDocNum(var1.getCsgNum());
            this.documentEntete.setDocDate(var1.getCsgDate());
            this.documentEntete.setDocNomTiers(var1.getCsgNomPatient());
            this.documentEntete.setDocIdEquipe((long)var1.getCsgFondCnamgs());
            this.documentEntete.setDocQte(var1.getCsgPecCnamgs());
            if (var1.getCsgIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
               this.documentEntete.setDocLibelle("Assurance");
               this.documentEntete.setDocTypeTiers(0);
               this.documentEntete.setDocIdResponsable(var1.getCsgIdAssurance());
               this.documentEntete.setDocIdCommercial(var1.getCsgIdEmployeur());
               this.documentEntete.setDocNomContact(var1.getCsgNomAssurance());
               this.documentEntete.setDocNomCommercial(var1.getCsgNomEmployeur());
               this.documentEntete.setDocEntree(var1.getCsgEntree());
            } else if (var1.getCsgIdSociete() != 0L && this.inpTiersPayeurs != 3) {
               this.documentEntete.setDocLibelle("Société");
               this.documentEntete.setDocTypeTiers(1);
               this.documentEntete.setDocIdResponsable(var1.getCsgIdSociete());
               this.documentEntete.setDocIdCommercial(0L);
               this.documentEntete.setDocNomContact(var1.getCsgNomSociete());
               this.documentEntete.setDocNomCommercial("");
               this.documentEntete.setDocEntree(var1.getMotifEntree());
            } else if (var1.getCsgIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
               this.documentEntete.setDocLibelle("Complémentaire");
               this.documentEntete.setDocTypeTiers(2);
               this.documentEntete.setDocIdResponsable(var1.getCsgIdComplementaire());
               this.documentEntete.setDocIdCommercial(0L);
               this.documentEntete.setDocNomContact(var1.getCsgNomComplemtaire());
               this.documentEntete.setDocNomCommercial("");
               this.documentEntete.setDocEntree(var1.getCsgEntree());
            }

            this.documentEntete.setDocNumBon(var1.getCsgNumBc());
            this.documentEntete.setDocNumDocument(var1.getCsgFeuille());
            if (this.inpTiersPayeurs >= 100) {
               this.documentEntete.setDocCodeBanq(var1.getPatients().getPatCnamgs());
               if (var1.getCsgFondCnamgs() == 1) {
                  this.documentEntete.setDocEntree("CS SP :" + var1.getCsgPecCnamgs() + "%");
               } else if (var1.getCsgFondCnamgs() == 2) {
                  this.documentEntete.setDocEntree("CS AP :" + var1.getCsgPecCnamgs() + "%");
               } else if (var1.getCsgFondCnamgs() == 3) {
                  this.documentEntete.setDocEntree("CS GEF :" + var1.getCsgPecCnamgs() + "%");
               }

               this.documentEntete.setDocNomContact("CNAMGS");
            } else {
               this.documentEntete.setDocCodeBanq(var1.getCsgMatricule());
            }

            this.documentEntete.setDocService(var1.getCsgService());
            this.documentEntete.setDocActivite("Consultation");
            this.documentEntete.setDocNumDocument(var1.getCsgFeuille());
            this.documentEntete.setDocTotTtc(var1.getCsgTotGeneral());
            this.documentEntete.setDocTotTva(var1.getTotalPatient());
            this.documentEntete.setDocTotHt(var1.getTotalTiers());
            this.documentEntete.setDocObject("EXTERNE");
            this.lesTiersConcernes.add(this.documentEntete);
         } else {
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setDocSelect(false);
            this.documentEntete.setDocIdCreateur(var1.getCsgId());
            this.documentEntete.setDocNomTiers(var1.getCsgNomPatient());
            this.documentEntete.setDocLibelle("Patient" + var1.getPatients().getPatDossier());
            this.documentEntete.setDocTypeTiers(0);
            this.documentEntete.setDocId(var1.getCsgId());
            this.documentEntete.setDocIdEquipe(0L);
            this.documentEntete.setDocNomEquipe("");
            this.documentEntete.setDocSource("");
            this.documentEntete.setDocObject("BLOQUE : CONSULTATON N° " + var1.getCsgNum());
            this.lesTiersRejetes.add(this.documentEntete);
         }
      }

   }

   public void rechercheTiersPharmacie_2(String var1, String var2, Session var3) throws HibernateException, NamingException {
      this.lesPharamcies.clear();
      if (this.idCnamgs != 0L) {
         this.lesPharamcies = this.pharmacieEnteteDao.recherchePharmacieCnamgsPeriode(var1, var2, this.numBc, var3);
      } else {
         this.lesPharamcies = this.pharmacieEnteteDao.recherchePharmaciePeriode(var1, var2, this.idTiers, this.numBc, var3);
      }

      if (this.lesPharamcies.size() != 0) {
         new PharmacieEntete();

         for(int var5 = 0; var5 < this.lesPharamcies.size(); ++var5) {
            PharmacieEntete var4 = (PharmacieEntete)this.lesPharamcies.get(var5);
            this.calculePharmacie_2(var4);
         }
      }

   }

   public void calculePharmacie_2(PharmacieEntete var1) {
      if (var1.getPhaDateTransfert() == null && (this.inpTiersPayeurs == 3 && (var1.getPhaEtat() == 5 || var1.getPhaEtat() == 6) || this.inpTiersPayeurs != 3 && var1.getPhaEtat() == 5) && (this.inpTiersPayeurs == 0 || (this.inpTiersPayeurs == 1 || this.inpTiersPayeurs == 51) && var1.getPhaIdAssurance() != 0L || (this.inpTiersPayeurs == 2 || this.inpTiersPayeurs == 52) && var1.getPhaIdSociete() != 0L || (this.inpTiersPayeurs == 3 || this.inpTiersPayeurs == 53) && var1.getPhaIdComplementaire() != 0L || this.inpTiersPayeurs == 100 && var1.getPhaPecCnamgs() != 0.0F && var1.getPhaFondCnamgs() != 0 || this.inpTiersPayeurs >= 101 && var1.getPhaPecCnamgs() != 0.0F && var1.getPhaFondCnamgs() == this.inpTiersPayeurs - 100)) {
         if (!var1.isPhaBloqueRefacturation()) {
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setDocSelect(false);
            this.documentEntete.setDocIdCreateur(var1.getPhaId());
            this.documentEntete.setDocNum(var1.getPhaNum());
            this.documentEntete.setDocDate(var1.getPhaDate());
            this.documentEntete.setDocNomTiers(var1.getPhaNomPatient());
            this.documentEntete.setDocIdEquipe((long)var1.getPhaFondCnamgs());
            this.documentEntete.setDocQte(var1.getPhaPecCnamgs());
            if (var1.getPhaIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
               this.documentEntete.setDocLibelle("Assurance");
               this.documentEntete.setDocTypeTiers(0);
               this.documentEntete.setDocIdResponsable(var1.getPhaIdAssurance());
               this.documentEntete.setDocIdCommercial(var1.getPhaIdEmployeur());
               this.documentEntete.setDocNomContact(var1.getPhaNomAssurance());
               this.documentEntete.setDocNomCommercial(var1.getPhaNomEmployeur());
               this.documentEntete.setDocEntree("");
            } else if (var1.getPhaIdSociete() != 0L && this.inpTiersPayeurs != 3) {
               this.documentEntete.setDocLibelle("Société");
               this.documentEntete.setDocTypeTiers(1);
               this.documentEntete.setDocIdResponsable(var1.getPhaIdSociete());
               this.documentEntete.setDocIdCommercial(0L);
               this.documentEntete.setDocNomContact(var1.getPhaNomSociete());
               this.documentEntete.setDocNomCommercial("");
               this.documentEntete.setDocEntree("");
            } else if (var1.getPhaIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
               this.documentEntete.setDocLibelle("Complémentaire");
               this.documentEntete.setDocTypeTiers(2);
               this.documentEntete.setDocIdResponsable(var1.getPhaIdComplementaire());
               this.documentEntete.setDocIdCommercial(0L);
               this.documentEntete.setDocNomContact(var1.getPhaNomComplemtaire());
               this.documentEntete.setDocNomCommercial("");
               this.documentEntete.setDocEntree("");
            }

            this.documentEntete.setDocNumBon(var1.getPhaNumBc());
            this.documentEntete.setDocNumDocument(var1.getPhaFeuille());
            if (this.inpTiersPayeurs >= 100) {
               this.documentEntete.setDocCodeBanq(var1.getPatients().getPatCnamgs());
               if (var1.getPhaFondCnamgs() == 21) {
                  this.documentEntete.setDocEntree("PH SP :" + var1.getPhaPecCnamgs() + "%");
               } else if (var1.getPhaFondCnamgs() == 22) {
                  this.documentEntete.setDocEntree("PH AP :" + var1.getPhaPecCnamgs() + "%");
               } else if (var1.getPhaFondCnamgs() == 23) {
                  this.documentEntete.setDocEntree("PH GEF :" + var1.getPhaPecCnamgs() + "%");
               }

               this.documentEntete.setDocNomContact("CNAMGS");
            } else {
               this.documentEntete.setDocCodeBanq(var1.getPhaMatricule());
            }

            this.documentEntete.setDocService(var1.getPhaService());
            this.documentEntete.setDocActivite("Pharmacie");
            this.documentEntete.setDocNumDocument(var1.getPhaFeuille());
            this.documentEntete.setDocTotTtc(var1.getPhaTotGeneral());
            this.documentEntete.setDocTotTva(var1.getTotalPatient());
            this.documentEntete.setDocTotHt(var1.getTotalTiers());
            this.documentEntete.setDocObject("EXTERNE");
            this.lesTiersConcernes.add(this.documentEntete);
         } else {
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setDocSelect(false);
            this.documentEntete.setDocIdCreateur(var1.getPhaId());
            this.documentEntete.setDocNomTiers(var1.getPhaNomPatient());
            this.documentEntete.setDocLibelle("Patient" + var1.getPatients().getPatDossier());
            this.documentEntete.setDocTypeTiers(0);
            this.documentEntete.setDocId(var1.getPhaId());
            this.documentEntete.setDocIdEquipe(0L);
            this.documentEntete.setDocNomEquipe("");
            this.documentEntete.setDocSource("");
            this.documentEntete.setDocObject("BLQUE : PHARMACIE N° " + var1.getPhaNum());
            this.lesTiersRejetes.add(this.documentEntete);
         }
      }

   }

   public void rechercheTiersLaboratoire_2(String var1, String var2, Session var3) throws HibernateException, NamingException {
      this.lesLaboratoires.clear();
      if (this.idCnamgs != 0L) {
         this.lesLaboratoires = this.laboratoireEnteteDao.rechercheLaboratoireCnamgsPeriode(var1, var2, this.numBc, var3);
      } else {
         this.lesLaboratoires = this.laboratoireEnteteDao.rechercheLaboratoirePeriode(var1, var2, this.idTiers, this.numBc, var3);
      }

      if (this.lesLaboratoires.size() != 0) {
         new LaboratoireEntete();

         for(int var5 = 0; var5 < this.lesLaboratoires.size(); ++var5) {
            LaboratoireEntete var4 = (LaboratoireEntete)this.lesLaboratoires.get(var5);
            this.calculeLaboratoire_2(var4, var3);
         }
      }

   }

   public void calculeLaboratoire_2(LaboratoireEntete var1, Session var2) throws HibernateException, NamingException {
      if (var1.getLabDateTransfert() == null && (this.inpTiersPayeurs == 3 && (var1.getLabEtat() == 5 || var1.getLabEtat() == 6) || this.inpTiersPayeurs != 3 && var1.getLabEtat() == 5) && (this.inpTiersPayeurs == 0 || (this.inpTiersPayeurs == 1 || this.inpTiersPayeurs == 51) && var1.getLabIdAssurance() != 0L || (this.inpTiersPayeurs == 2 || this.inpTiersPayeurs == 52) && var1.getLabIdSociete() != 0L || (this.inpTiersPayeurs == 3 || this.inpTiersPayeurs == 53) && var1.getLabIdComplementaire() != 0L || this.inpTiersPayeurs == 100 && var1.getLabPecCnamgs() != 0.0F && var1.getLabFondCnamgs() != 0 || this.inpTiersPayeurs >= 101 && var1.getLabPecCnamgs() != 0.0F && var1.getLabFondCnamgs() == this.inpTiersPayeurs - 100)) {
         if (!var1.isLabBloqueRefacturation()) {
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setDocSelect(false);
            this.documentEntete.setDocIdCreateur(var1.getLabId());
            this.documentEntete.setDocNum(var1.getLabNum());
            this.documentEntete.setDocDate(var1.getLabDate());
            this.documentEntete.setDocNomTiers(var1.getLabNomPatient());
            this.documentEntete.setDocIdEquipe((long)var1.getLabFondCnamgs());
            this.documentEntete.setDocQte(var1.getLabPecCnamgs());
            if (var1.getLabIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
               this.documentEntete.setDocLibelle("Assurance");
               this.documentEntete.setDocTypeTiers(0);
               this.documentEntete.setDocIdResponsable(var1.getLabIdAssurance());
               this.documentEntete.setDocIdCommercial(var1.getLabIdEmployeur());
               this.documentEntete.setDocNomContact(var1.getLabNomAssurance());
               this.documentEntete.setDocNomCommercial(var1.getLabNomEmployeur());
               this.documentEntete.setDocEntree(var1.getLabEntree());
            } else if (var1.getLabIdSociete() != 0L && this.inpTiersPayeurs != 3) {
               this.documentEntete.setDocLibelle("Société");
               this.documentEntete.setDocTypeTiers(1);
               this.documentEntete.setDocIdResponsable(var1.getLabIdSociete());
               this.documentEntete.setDocIdCommercial(0L);
               this.documentEntete.setDocNomContact(var1.getLabNomSociete());
               this.documentEntete.setDocNomCommercial("");
               this.documentEntete.setDocEntree(var1.getLabEntree());
            } else if (var1.getLabIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
               this.documentEntete.setDocLibelle("Complémentaire");
               this.documentEntete.setDocTypeTiers(2);
               this.documentEntete.setDocIdResponsable(var1.getLabIdComplementaire());
               this.documentEntete.setDocIdCommercial(0L);
               this.documentEntete.setDocNomContact(var1.getLabNomComplemtaire());
               this.documentEntete.setDocNomCommercial("");
               this.documentEntete.setDocEntree(var1.getLabEntree());
            }

            this.documentEntete.setDocNumBon(var1.getLabNumBc());
            this.documentEntete.setDocNumDocument(var1.getLabFeuille());
            if (this.inpTiersPayeurs >= 100) {
               this.documentEntete.setDocCodeBanq(var1.getPatients().getPatCnamgs());
               if (var1.getLabFondCnamgs() == 11) {
                  this.documentEntete.setDocEntree("EX SP :" + var1.getLabPecCnamgs() + "%");
               } else if (var1.getLabFondCnamgs() == 12) {
                  this.documentEntete.setDocEntree("EX AP :" + var1.getLabPecCnamgs() + "%");
               } else if (var1.getLabFondCnamgs() == 13) {
                  this.documentEntete.setDocEntree("EX GEF :" + var1.getLabPecCnamgs() + "%");
               }

               this.documentEntete.setDocNomContact("CNAMGS");
            } else {
               this.documentEntete.setDocCodeBanq(var1.getLabMatricule());
            }

            this.documentEntete.setDocService(var1.getLabService());
            if (var1.getLabService() != null && !var1.getLabService().isEmpty()) {
               if (var1.getLabService().contains(":")) {
                  String[] var3 = var1.getLabService().split(":");
                  this.documentEntete.setDocActivite(var3[1]);
               } else {
                  this.documentEntete.setDocActivite(var1.getLabService());
               }
            } else {
               this.documentEntete.setDocActivite("Laboratoire");
            }

            this.documentEntete.setDocNumDocument(var1.getLabFeuille());
            if (this.inpTiersPayeurs < 100) {
               this.documentEntete.setDocTotTtc(var1.getLabTotGeneral());
            } else {
               new ArrayList();
               List var7 = this.laboratoireLigneDao.selectConsActesByConsEnt(var1.getLabId(), var2);
               if (var7.size() == 0) {
                  this.documentEntete.setDocTotTtc(0.0D);
               } else {
                  double var4 = 0.0D;

                  for(int var6 = 0; var6 < var7.size(); ++var6) {
                     if (((LaboratoireLigne)var7.get(var6)).getLabligPuCnamgs() != 0.0D) {
                        var4 += ((LaboratoireLigne)var7.get(var6)).getLabligPu();
                     }
                  }

                  this.documentEntete.setDocTotTtc(var4);
               }
            }

            this.documentEntete.setDocTotTva(var1.getTotalPatient());
            this.documentEntete.setDocTotHt(var1.getTotalTiers());
            this.documentEntete.setDocObject("EXTERNE");
            this.lesTiersConcernes.add(this.documentEntete);
         } else {
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setDocSelect(false);
            this.documentEntete.setDocIdCreateur(var1.getLabId());
            this.documentEntete.setDocNomTiers(var1.getLabNomPatient());
            this.documentEntete.setDocLibelle("Patient" + var1.getPatients().getPatDossier());
            this.documentEntete.setDocTypeTiers(0);
            this.documentEntete.setDocId(var1.getLabId());
            this.documentEntete.setDocIdEquipe(0L);
            this.documentEntete.setDocNomEquipe("");
            this.documentEntete.setDocSource("");
            this.documentEntete.setDocObject("BLOQUE : LABORATOIRE N° " + var1.getLabNum());
            this.lesTiersRejetes.add(this.documentEntete);
         }
      }

   }

   public void rechercheTiersHospitalisation_2(String var1, String var2, Session var3) throws HibernateException, NamingException {
      this.lesHospits.clear();
      if (this.idCnamgs != 0L) {
         this.lesHospits = this.hospitalisationEnteteDao.rechercheHospitalisationCnamgsPeriode(var1, var2, this.numBc, var3);
      } else {
         this.lesHospits = this.hospitalisationEnteteDao.rechercheHospitalisationPeriode(var1, var2, this.idTiers, this.numBc, var3);
      }

      if (this.lesHospits.size() != 0) {
         new HospitalisationEntete();

         for(int var5 = 0; var5 < this.lesHospits.size(); ++var5) {
            HospitalisationEntete var4 = (HospitalisationEntete)this.lesHospits.get(var5);
            this.calculeHospitalisation_2(var4);
         }
      }

   }

   public void calculeHospitalisation_2(HospitalisationEntete var1) {
      if (var1.getHosDateTransfert() == null && (this.inpTiersPayeurs == 3 && (var1.getHosEtat() == 5 || var1.getHosEtat() == 6) || this.inpTiersPayeurs != 3 && var1.getHosEtat() == 5) && (this.inpTiersPayeurs == 0 || (this.inpTiersPayeurs == 1 || this.inpTiersPayeurs == 61) && var1.getHosIdAssurance() != 0L || (this.inpTiersPayeurs == 2 || this.inpTiersPayeurs == 62) && var1.getHosIdSociete() != 0L || (this.inpTiersPayeurs == 3 || this.inpTiersPayeurs == 63) && var1.getHosIdComplementaire() != 0L || this.inpTiersPayeurs == 100 && var1.getHosPecCnamgs() != 0.0F && var1.getHosFondCnamgs() != 0 || this.inpTiersPayeurs >= 101 && var1.getHosPecCnamgs() != 0.0F && var1.getHosFondCnamgs() == this.inpTiersPayeurs - 100)) {
         if (!var1.isHosBloqueRefacturation()) {
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setDocSelect(false);
            this.documentEntete.setDocIdCreateur(var1.getHosId());
            this.documentEntete.setDocNum(var1.getHosNum());
            this.documentEntete.setDocDate(var1.getHosDateSortie());
            this.documentEntete.setDocNomTiers(var1.getHosNomPatient());
            this.documentEntete.setDocIdEquipe((long)var1.getHosFondCnamgs());
            this.documentEntete.setDocQte(var1.getHosPecCnamgs());
            if (var1.getHosIdAssurance() != 0L && this.inpTiersPayeurs != 3) {
               this.documentEntete.setDocLibelle("Assurance");
               this.documentEntete.setDocTypeTiers(0);
               this.documentEntete.setDocIdResponsable(var1.getHosIdAssurance());
               this.documentEntete.setDocIdCommercial(var1.getHosIdEmployeur());
               this.documentEntete.setDocNomContact(var1.getHosNomAssurance());
               this.documentEntete.setDocNomCommercial(var1.getHosNomEmployeur());
               this.documentEntete.setDocEntree(var1.getHosMotifEntree());
            } else if (var1.getHosIdSociete() != 0L && this.inpTiersPayeurs != 3) {
               this.documentEntete.setDocLibelle("Société");
               this.documentEntete.setDocTypeTiers(1);
               this.documentEntete.setDocIdResponsable(var1.getHosIdSociete());
               this.documentEntete.setDocIdCommercial(0L);
               this.documentEntete.setDocNomContact(var1.getHosNomSociete());
               this.documentEntete.setDocNomCommercial("");
               this.documentEntete.setDocEntree(var1.getHosMotifEntree());
            } else if (var1.getHosIdComplementaire() != 0L && this.inpTiersPayeurs == 3) {
               this.documentEntete.setDocLibelle("Complémentaire");
               this.documentEntete.setDocTypeTiers(2);
               this.documentEntete.setDocIdResponsable(var1.getHosIdComplementaire());
               this.documentEntete.setDocIdCommercial(0L);
               this.documentEntete.setDocNomContact(var1.getHosNomComplemtaire());
               this.documentEntete.setDocNomCommercial("");
               this.documentEntete.setDocEntree(var1.getHosMotifEntree());
            }

            this.documentEntete.setDocNumBon(var1.getHosNumBc());
            this.documentEntete.setDocNumDocument(var1.getHosFeuille());
            if (this.inpTiersPayeurs >= 100) {
               this.documentEntete.setDocCodeBanq(var1.getPatients().getPatCnamgs());
               if (var1.getHosFondCnamgs() == 31) {
                  this.documentEntete.setDocEntree("HSP SP :" + var1.getHosPecCnamgs() + "%");
               } else if (var1.getHosFondCnamgs() == 32) {
                  this.documentEntete.setDocEntree("HSP AP :" + var1.getHosPecCnamgs() + "%");
               } else if (var1.getHosFondCnamgs() == 33) {
                  this.documentEntete.setDocEntree("HSP GEF :" + var1.getHosPecCnamgs() + "%");
               }

               this.documentEntete.setDocNomContact("CNAMGS");
            } else {
               this.documentEntete.setDocCodeBanq(var1.getHosMatricule());
            }

            this.documentEntete.setDocService(var1.getHosService());
            this.documentEntete.setDocActivite("Hospitalisation");
            this.documentEntete.setDocNumDocument(var1.getHosFeuille());
            this.documentEntete.setDocTotTtc(var1.getHosTotGeneral());
            this.documentEntete.setDocTotTva(var1.getTotalPatient());
            this.documentEntete.setDocTotHt(var1.getTotalTiers());
            this.documentEntete.setDocObject("HOSPIT");
            this.lesTiersConcernes.add(this.documentEntete);
         } else {
            this.documentEntete = new DocumentEntete();
            this.documentEntete.setDocSelect(false);
            this.documentEntete.setDocIdCreateur(var1.getHosId());
            this.documentEntete.setDocNomTiers(var1.getHosNomPatient());
            this.documentEntete.setDocLibelle("Patient" + var1.getPatients().getPatDossier());
            this.documentEntete.setDocTypeTiers(0);
            this.documentEntete.setDocId(var1.getHosId());
            this.documentEntete.setDocIdEquipe(0L);
            this.documentEntete.setDocNomEquipe("");
            this.documentEntete.setDocSource("");
            this.documentEntete.setDocObject("BLOQUE : HOSPITALISATION N° " + var1.getHosNum());
            this.lesTiersRejetes.add(this.documentEntete);
         }
      }

   }

   public void fermerPatientsRejetes() {
      this.showModalPanelPatientRejetes = false;
   }

   public void calculeNatureTiers(Session var1) throws HibernateException, NamingException {
      if (this.lesTiersConcernes.size() != 0) {
         new ArrayList();
         List var2 = this.tiersDao.chargerLesTiers("3", var1);
         if (var2.size() != 0) {
            boolean var3 = false;

            for(int var4 = 0; var4 < this.lesTiersConcernes.size(); ++var4) {
               this.documentEntete = (DocumentEntete)this.lesTiersConcernes.get(var4);
               int var5;
               if (this.documentEntete.getDocId() != 0L) {
                  var3 = false;

                  for(var5 = 0; var5 < var2.size(); ++var5) {
                     if (((Tiers)var2.get(var5)).getTieid() == this.documentEntete.getDocId()) {
                        this.documentEntete.setDocLibelle(((Tiers)var2.get(var5)).getTiecategorie());
                        var3 = true;
                        break;
                     }
                  }
               } else {
                  var3 = false;

                  for(var5 = 0; var5 < var2.size(); ++var5) {
                     if (((Tiers)var2.get(var5)).getTieraisonsocialenom().equals("CNAMGS")) {
                        this.documentEntete.setDocLibelle(((Tiers)var2.get(var5)).getTiecategorie());
                        this.documentEntete.setDocId(((Tiers)var2.get(var5)).getTieid());
                        var3 = true;
                        break;
                     }
                  }
               }

               var3 = false;
               if (false) {
                  this.documentEntete.setDocLibelle("???" + this.documentEntete.getDocLibelle());
               }

               if (this.documentEntete.getDocIdEquipe() != 0L) {
                  var3 = false;

                  for(var5 = 0; var5 < var2.size(); ++var5) {
                     if (((Tiers)var2.get(var5)).getTieid() == this.documentEntete.getDocIdEquipe()) {
                        this.documentEntete.setDocNomEquipe(((Tiers)var2.get(var5)).getTieraisonsocialenom());
                        var3 = true;
                        break;
                     }
                  }

                  var3 = false;
                  if (false) {
                     this.documentEntete.setDocNomEquipe("???");
                  }
               }
            }
         }
      }

   }

   public void fermerAjout() {
      this.showModalPanelAjouter = false;
   }

   public void selectionTiers() {
      if (this.dataModelTiersConcernes.isRowAvailable()) {
         this.nbLigneSelect = 0;

         for(int var1 = 0; var1 < this.lesTiersConcernes.size(); ++var1) {
            if (((DocumentEntete)this.lesTiersConcernes.get(var1)).isDocSelect()) {
               ++this.nbLigneSelect;
            }
         }
      }

   }

   public void toutSelectionnerAssurances() {
      if (this.lesTiersConcernes.size() != 0) {
         for(int var1 = 0; var1 < this.lesTiersConcernes.size(); ++var1) {
            this.documentEntete = (DocumentEntete)this.lesTiersConcernes.get(var1);
            if (this.documentEntete.getDocLibelle() != null && !this.documentEntete.getDocLibelle().isEmpty() && (this.documentEntete.getDocLibelle().equals("Assurance") || this.documentEntete.getDocLibelle().equals("Complémentaire"))) {
               this.documentEntete.setDocSelect(true);
            }
         }
      }

   }

   public void toutSelectionnerSocietes() {
      if (this.lesTiersConcernes.size() != 0) {
         for(int var1 = 0; var1 < this.lesTiersConcernes.size(); ++var1) {
            this.documentEntete = (DocumentEntete)this.lesTiersConcernes.get(var1);
            if (this.documentEntete.getDocLibelle() != null && !this.documentEntete.getDocLibelle().isEmpty() && this.documentEntete.getDocLibelle().equals("Société")) {
               this.documentEntete.setDocSelect(true);
            }
         }
      }

   }

   public void toutDeselectionner() {
      if (this.lesTiersConcernes.size() != 0) {
         for(int var1 = 0; var1 < this.lesTiersConcernes.size(); ++var1) {
            this.documentEntete = (DocumentEntete)this.lesTiersConcernes.get(var1);
            this.documentEntete.setDocSelect(false);
         }
      }

   }

   public void generationPeriode() throws ParseException, HibernateException, NamingException {
      Session var1;
      Transaction var2;
      if (this.lesTiersConcernes.size() != 0) {
         this.var_action = 1;
         this.verifieExistenceHabilitation((Session)null);
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = "";
            String var4 = "";
            if (this.inpRegroupement == 2) {
               if (this.inpNomTiers != null && !this.inpNomTiers.isEmpty()) {
                  this.tiers = this.tiersDao.selectTierD(this.idTiers, var1);
                  if (this.tiers != null) {
                     if (this.dateFacture.getMonth() + 1 <= 9) {
                        var3 = "0" + (this.dateFacture.getMonth() + 1) + ":" + (this.dateFacture.getYear() + 1900);
                     } else {
                        var3 = "" + (this.dateFacture.getMonth() + 1) + ":" + (this.dateFacture.getYear() + 1900);
                     }

                     if (this.tiers.getTiecategorie() != null && !this.tiers.getTiecategorie().isEmpty() && (this.tiers.getTiecategorie().equals("Assurance") || this.tiers.getTiecategorie().equals("IPM") || this.tiers.getTiecategorie().equals("Mutuelle/Assurance") || this.tiers.getTiecategorie().equals("Mutuelle") || this.tiers.getTiecategorie().equals("Complémentaire") || this.tiers.getTiecategorie().equals("Programme Médical"))) {
                        if (this.documentEntete.getDocNomTiers().equals("CNAMGS")) {
                           var4 = var3 + ":" + this.documentEntete.getDocId() + ":0:" + this.documentEntete.getDocIdEquipe() * -1L;
                        } else {
                           var4 = var3 + ":" + this.documentEntete.getDocId() + ":0:" + this.documentEntete.getDocIdEquipe();
                        }
                     } else if (this.documentEntete.getDocTypeTiers() == 1) {
                        var4 = var3 + ":" + this.documentEntete.getDocId() + ":1";
                     } else {
                        var4 = var3 + ":" + this.documentEntete.getDocId() + ":2";
                     }

                     this.generationSuite(var4, var1);
                  }
               }
            } else {
               for(int var5 = 0; var5 < this.lesTiersConcernes.size(); ++var5) {
                  this.documentEntete = (DocumentEntete)this.lesTiersConcernes.get(var5);
                  if (this.documentEntete.isDocSelect()) {
                     this.tiers = this.tiersDao.selectTierD(this.documentEntete.getDocId(), var1);
                     if (this.tiers != null) {
                        this.ordre = 0;
                        var3 = "";
                        if (this.dateFacture.getMonth() + 1 <= 9) {
                           var3 = "0" + (this.dateFacture.getMonth() + 1) + ":" + (this.dateFacture.getYear() + 1900);
                        } else {
                           var3 = "" + (this.dateFacture.getMonth() + 1) + ":" + (this.dateFacture.getYear() + 1900);
                        }

                        var4 = "";
                        if (this.inpRegroupement == 0) {
                           if (this.documentEntete.getDocTypeTiers() == 0) {
                              if (this.documentEntete.getDocNomTiers().equals("CNAMGS")) {
                                 var4 = var3 + ":" + this.documentEntete.getDocId() + ":0:" + this.documentEntete.getDocIdEquipe() * -1L;
                              } else {
                                 var4 = var3 + ":" + this.documentEntete.getDocId() + ":0:" + this.documentEntete.getDocIdEquipe();
                              }
                           } else if (this.documentEntete.getDocTypeTiers() == 1) {
                              var4 = var3 + ":" + this.documentEntete.getDocId() + ":1";
                           } else {
                              var4 = var3 + ":" + this.documentEntete.getDocId() + ":2";
                           }
                        } else if (this.inpRegroupement == 1) {
                           if (this.documentEntete.getDocTypeTiers() == 0) {
                              if (this.documentEntete.getDocNomTiers().equals("CNAMGS")) {
                                 var4 = var3 + ":" + this.documentEntete.getDocId() + ":0:" + this.documentEntete.getDocIdEquipe() * -1L;
                              } else {
                                 var4 = var3 + ":" + this.documentEntete.getDocId() + ":0:" + this.documentEntete.getDocIdEquipe();
                              }
                           } else if (this.documentEntete.getDocTypeTiers() == 1) {
                              if (this.documentEntete.getDocSource() != null && !this.documentEntete.getDocSource().isEmpty()) {
                                 var4 = var3 + ":" + this.documentEntete.getDocId() + ":1:" + this.documentEntete.getDocSource();
                              } else {
                                 var4 = var3 + ":" + this.documentEntete.getDocId() + ":1";
                              }
                           } else {
                              var4 = var3 + ":" + this.documentEntete.getDocId() + ":2";
                           }
                        }

                        this.generationSuite(var4, var1);
                     }
                  }
               }
            }

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

      if (this.lesFacturesGenerees.size() != 0) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            new FactureEnteteMedical();

            for(int var21 = 0; var21 < this.lesFacturesGenerees.size(); ++var21) {
               FactureEnteteMedical var20 = (FactureEnteteMedical)this.lesFacturesGenerees.get(var21);
               this.validationDocumentsuite(var20, this.inpTiersPayeurs, var1);
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

      this.lesEntetesList.clear();
      this.datamodelEntete.setWrappedData(this.lesEntetesList);
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.visibiliteBton = false;
      this.var_action = 0;
      this.inpNomTiers = "";
      this.inpClient = "";
      this.idTiers = 0L;
      this.showModalPanelAjouter = false;
      this.showModalPanelListeTiers = false;
      this.showModalPanelPrintSimulation = false;
   }

   public void generationSuite(String var1, Session var2) throws HibernateException, NamingException, ParseException {
      boolean var3 = true;
      String var4 = "";
      var3 = true;
      if (var3) {
         long var5 = this.creationEnteteFacture(var1, var4, var2);
         if (this.documentEntete.getDocObject() != null && !this.documentEntete.getDocObject().isEmpty() && this.documentEntete.getDocObject().equals("EXTERNE")) {
            this.creationLigneFacture(var2);
            var2.flush();
         } else if (this.documentEntete.getDocObject() != null && !this.documentEntete.getDocObject().isEmpty() && this.documentEntete.getDocObject().equals("HOSPIT")) {
            this.creationLigneHospit(var2);
            var2.flush();
         } else {
            var5 = 0L;
         }

         if (var5 != 0L) {
            this.factureEnteteMedical = this.factureEnteteMedicalDao.pourParapheur(var5, var2);
            if (this.factureEnteteMedical != null) {
               double var7 = 0.0D;
               double var9 = 0.0D;
               double var11 = 0.0D;
               new ArrayList();
               List var13 = this.factureLigneMedicalDao.chargerLesLignes(this.factureEnteteMedical, var2);
               if (var13.size() != 0) {
                  for(int var14 = 0; var14 < var13.size(); ++var14) {
                     var7 += ((FactureLigneMedical)var13.get(var14)).getFacligPt();
                     var9 += ((FactureLigneMedical)var13.get(var14)).getFacligTva();
                     var11 += ((FactureLigneMedical)var13.get(var14)).getFacligTtc();
                  }
               }

               this.factureEnteteMedical.setFacTotHt(var7);
               this.factureEnteteMedical.setFacTotTva(var9);
               this.factureEnteteMedical.setFacTotTtc(var11);
               this.factureEnteteMedical = this.factureEnteteMedicalDao.modif(this.factureEnteteMedical, var2);
               this.lesFacturesGenerees.add(this.factureEnteteMedical);
            }

            var2.flush();
         }
      }

   }

   public long creationEnteteFacture(String var1, String var2, Session var3) throws ParseException, HibernateException, NamingException {
      this.factureEnteteMedical = new FactureEnteteMedical();
      this.factureLigneMedical = new FactureLigneMedical();
      this.factureEnteteMedical.setTiers(this.tiers);
      this.factureEnteteMedical.setFacNomTiers(this.tiers.getTieraisonsocialenom());
      if ((this.factureEnteteMedical.getFacCat() == null || this.factureEnteteMedical.getFacCat().isEmpty()) && this.factureEnteteMedical.getTiers().getTienomfamille() != null && !this.factureEnteteMedical.getTiers().getTienomfamille().isEmpty()) {
         this.factureEnteteMedical.setFacCat(this.factureEnteteMedical.getTiers().getTienomfamille());
      }

      if (!this.factureEnteteMedical.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.factureEnteteMedical.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.factureEnteteMedical.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.factureEnteteMedical.getTiers().getTiegenre().equalsIgnoreCase("037")) {
         this.factureEnteteMedical.setFacCivilTiers("");
      } else {
         this.factureEnteteMedical.setFacCivilTiers(this.factureEnteteMedical.getTiers().getTiecivilite());
      }

      this.factureEnteteMedical.setFacExoTva(this.tiers.getTieexotva());
      this.factureEnteteMedical.setFacCat(this.tiers.getTiecategorie());
      this.factureEnteteMedical.setFacTiersRegroupe(this.tiers.getTiesigle());
      this.factureEnteteMedical.setFacDevise(this.tiers.getTiedevise());
      if (this.factureEnteteMedical.getFacDevise() == null || this.factureEnteteMedical.getFacDevise().isEmpty()) {
         this.factureEnteteMedical.setFacDevise(this.structureLog.getStrdevise());
      }

      this.var_date = this.dateFacture;
      String var4 = "";
      if (this.var_date.getMonth() + 1 <= 9) {
         var4 = "0" + (this.var_date.getMonth() + 1) + ":" + (this.var_date.getYear() + 1900);
      } else {
         var4 = "" + (this.var_date.getMonth() + 1) + ":" + (this.var_date.getYear() + 1900);
      }

      this.factureEnteteMedical.setFacPeriode(var4);
      this.factureEnteteMedical.setFacIdAdherent(0L);
      this.factureEnteteMedical.setFacNomAdherent((String)null);
      this.factureEnteteMedical.setFacSecteurAgent((String)null);
      if (this.documentEntete.getDocTypeTiers() == 0) {
         if (this.factureEnteteMedical.getFacNomTiers().equals("CNAMGS")) {
            this.factureEnteteMedical.setFacIdAdherent(0L);
            this.factureEnteteMedical.setFacNomAdherent("");
            this.factureEnteteMedical.setFacFondCnamgs(this.inpTiersPayeurs - 100);
            this.factureEnteteMedical.setFacPecCnamgs(this.documentEntete.getDocQte());
         } else {
            if (this.inpRegroupement == 2) {
               this.factureEnteteMedical.setFacIdAdherent(this.documentEntete.getDocIdCommercial());
               this.factureEnteteMedical.setFacNomAdherent(this.documentEntete.getDocNomCommercial());
            } else if (this.inpRegroupement == 1) {
               this.factureEnteteMedical.setFacIdAdherent(this.documentEntete.getDocIdEquipe());
               this.factureEnteteMedical.setFacNomAdherent(this.documentEntete.getDocNomEquipe());
            } else {
               this.factureEnteteMedical.setFacIdAdherent(0L);
               this.factureEnteteMedical.setFacNomAdherent("");
            }

            this.factureEnteteMedical.setFacFondCnamgs(0);
            this.factureEnteteMedical.setFacPecCnamgs(0.0F);
         }
      } else if (this.documentEntete.getDocTypeTiers() == 1) {
         this.factureEnteteMedical.setFacSecteurAgent(this.documentEntete.getDocSource());
         this.factureEnteteMedical.setFacMotifEntree(this.documentEntete.getDocEntree());
      }

      this.factureEnteteMedical.setFacContrat(var1);
      this.factureEnteteMedical.setFacObject("Facturation du " + this.utilDate.dateToStringFr(this.dateDebut) + " au " + this.utilDate.dateToStringFr(this.dateFin));
      this.factureEnteteMedical.setFacOrigine(this.documentEntete.getDocObject());
      this.factureEnteteMedical.setUsers(this.usersLog);
      this.factureEnteteMedical.setFacIdCreateur(this.usersLog.getUsrid());
      this.factureEnteteMedical.setFacNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
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

      this.factureEnteteMedical.setFacDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
      this.factureEnteteMedical.setFacDateDebut(this.dateDebut);
      this.factureEnteteMedical.setFacDateFin(this.dateFin);
      boolean var5 = false;
      int var13;
      if (this.optionMedical.getNbrJrRelanceFAC() != null && !this.optionMedical.getNbrJrRelanceFAC().isEmpty()) {
         var13 = Integer.parseInt(this.optionMedical.getNbrJrRelanceFAC());
      } else {
         var13 = 0;
      }

      boolean var6 = false;
      int var14;
      if (this.optionMedical.getNbrJrValidFAC() != null && !this.optionMedical.getNbrJrValidFAC().isEmpty()) {
         var14 = Integer.parseInt(this.optionMedical.getNbrJrValidFAC());
      } else {
         var14 = 0;
      }

      this.factureEnteteMedical.setFacDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var13));
      this.factureEnteteMedical.setFacDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var14));
      this.CalculDateEcheance();
      this.factureEnteteMedical.setFacBanque(this.structureLog.getStrBanqueDefaut());
      this.factureEnteteMedical.setFacSite(this.usersLog.getUsrSite());
      this.factureEnteteMedical.setFacDepartement(this.usersLog.getUsrDepartement());
      this.factureEnteteMedical.setFacService(this.usersLog.getUsrService());
      this.factureEnteteMedical.setFacAnal4("");
      this.factureEnteteMedical.setFacAnal2("");
      this.factureEnteteMedical.setFacIdContact(0L);
      this.factureEnteteMedical.setFacNomContact("");
      this.factureEnteteMedical.setFacCivilContact("");
      this.factureEnteteMedical.setFacIdCommercial(this.usersLog.getUsrid());
      this.factureEnteteMedical.setFacNomCommercial(this.usersLog.getUsrPatronyme());
      if (this.var_timbre != 0) {
         int var7 = this.var_date.getYear() + 1900;
         double var8 = this.utilNombre.calculTimbre(this.structureLog, this.factureEnteteMedical.getFacTotTtc() + this.factureEnteteMedical.getFacTotTc(), var7, this.factureEnteteMedical.getFacDevise(), this.factureEnteteMedical.getFacDate());
         this.val_timbre = this.utilNombre.myRoundDevise(var8, this.factureEnteteMedical.getFacDevise());
         if (this.val_timbre != 0.0D) {
            String var10 = this.utilNombre.beginSimple(this.val_timbre, this.factureEnteteMedical.getFacDevise());
            this.factureEnteteMedical.setFacFormule2(this.utilNombre.texteTimbre(this.structureLog, var10, var7, this.factureEnteteMedical.getFacDevise(), this.factureEnteteMedical.getFacDate()));
         }
      }

      this.factureEnteteMedical.setExerciceventes(this.exercicesVentes);
      this.factureEnteteMedical.setFacDateCreat(new Date());
      this.factureEnteteMedical.setFacIdCreateur(this.usersLog.getUsrid());
      this.factureEnteteMedical.setFacNomCreateur(this.usersLog.getUsrPatronyme());
      this.factureEnteteMedical.setFacSerie(this.inpSerie);
      if (var2 != null && !var2.isEmpty()) {
         this.factureEnteteMedical.setFacNum(var2);
      } else if (this.factureEnteteMedical.getFacSerie() != null && !this.factureEnteteMedical.getFacSerie().equalsIgnoreCase("X") && !this.factureEnteteMedical.getFacSerie().isEmpty()) {
         this.factureEnteteMedical.setFacNum(this.calculChrono.numCompose(this.factureEnteteMedical.getFacDate(), this.nature, this.factureEnteteMedical.getFacSerie(), var3));
         boolean var16 = false;

         label101:
         while(true) {
            while(true) {
               if (var16) {
                  break label101;
               }

               new FactureEnteteMedical();
               FactureEnteteMedical var17 = this.factureEnteteMedicalDao.pourParapheur(this.factureEnteteMedical.getFacNum(), this.factureEnteteMedical.getFacSerie(), var3);
               if (var17 != null) {
                  long var9 = 100000000L * this.usersLog.getUsrid();

                  for(long var11 = 0L; var11 < var9; ++var11) {
                  }

                  this.factureEnteteMedical.setFacNum(this.calculChrono.numCompose(this.factureEnteteMedical.getFacDate(), this.nature, this.factureEnteteMedical.getFacSerie(), var3));
                  var16 = false;
               } else {
                  var16 = true;
               }
            }
         }
      } else {
         long var15 = this.factureEnteteMedicalDao.selectLastNum(var3);
         this.factureEnteteMedical.setFacNum("" + var15);
      }

      this.factureEnteteMedical.setFacEtat(0);
      this.factureEnteteMedical.setFacEtatVal(0);
      this.factureEnteteMedical.setFacDateValide((Date)null);
      this.factureEnteteMedical = this.factureEnteteMedicalDao.insert(this.factureEnteteMedical, var3);
      return this.factureEnteteMedical.getFacId();
   }

   public void creationLigneFacture(Session var1) throws HibernateException, NamingException {
      int var2;
      if (this.inpRegroupement == 0) {
         if (this.lesFacturesConcernes.size() != 0) {
            for(var2 = 0; var2 < this.lesFacturesConcernes.size(); ++var2) {
               if (this.documentEntete.getDocId() == ((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdResponsable()) {
                  if (((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocActivite().equals("Consultation")) {
                     this.creationligneConsultationFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), var1);
                  } else if (((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocActivite().equals("Pharmacie")) {
                     this.creationlignePharmacieFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), var1);
                  } else {
                     this.creationligneLaboratoireFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), ((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocTotTtc(), var1);
                  }
               }
            }
         }
      } else if (this.inpRegroupement == 1) {
         if (this.lesFacturesConcernes.size() != 0) {
            for(var2 = 0; var2 < this.lesFacturesConcernes.size(); ++var2) {
               if (this.documentEntete.getDocId() == ((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdResponsable()) {
                  if ((((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocTypeTiers() == 0 || ((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocTypeTiers() == 2) && this.documentEntete.getDocIdEquipe() == ((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCommercial()) {
                     if (((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocActivite().equals("Consultation")) {
                        this.creationligneConsultationFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), var1);
                     } else if (((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocActivite().equals("Pharmacie")) {
                        this.creationlignePharmacieFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), var1);
                     } else {
                        this.creationligneLaboratoireFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), ((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocTotTtc(), var1);
                     }
                  } else if (((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocTypeTiers() == 1 && this.documentEntete.getDocEntree() != null && !this.documentEntete.getDocEntree().isEmpty() && ((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocEntree() != null && !((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocEntree().isEmpty() && this.documentEntete.getDocEntree().equals(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocEntree())) {
                     if (((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocActivite().equals("Consultation")) {
                        this.creationligneConsultationFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), var1);
                     } else if (((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocActivite().equals("Pharmacie")) {
                        this.creationlignePharmacieFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), var1);
                     } else {
                        this.creationligneLaboratoireFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), ((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocTotTtc(), var1);
                     }
                  }
               }
            }
         }
      } else if (this.inpRegroupement == 2 && this.lesTiersConcernes.size() != 0) {
         for(var2 = 0; var2 < this.lesTiersConcernes.size(); ++var2) {
            if (((DocumentEntete)this.lesTiersConcernes.get(var2)).isDocSelect()) {
               if (((DocumentEntete)this.lesTiersConcernes.get(var2)).getDocActivite().equals("Consultation")) {
                  this.creationligneConsultationFacture(((DocumentEntete)this.lesTiersConcernes.get(var2)).getDocIdCreateur(), var1);
               } else if (((DocumentEntete)this.lesTiersConcernes.get(var2)).getDocActivite().equals("Pharmacie")) {
                  this.creationlignePharmacieFacture(((DocumentEntete)this.lesTiersConcernes.get(var2)).getDocIdCreateur(), var1);
               } else {
                  this.creationligneLaboratoireFacture(((DocumentEntete)this.lesTiersConcernes.get(var2)).getDocIdCreateur(), ((DocumentEntete)this.lesTiersConcernes.get(var2)).getDocTotTtc(), var1);
               }
            }
         }
      }

   }

   public void creationligneConsultationFacture(long var1, Session var3) throws HibernateException, NamingException {
      if (this.optionMedical.getModeRefacturation().equals("0")) {
         new ArrayList();
         List var4 = this.consultationActesDao.selectConsActesByConsEnt(var1, var3);
         if (var4.size() != 0) {
            for(int var5 = 0; var5 < var4.size(); ++var5) {
               ++this.ordre;
               this.consultationActes = (ConsultationActes)var4.get(var5);
               this.consultationEnteteGene = this.consultationActes.getConsultationEnteteGene();
               this.factureLigneMedical = new FactureLigneMedical();
               this.factureLigneMedical.setFacligCivilite(this.consultationEnteteGene.getCsgCivilite());
               this.factureLigneMedical.setFacligDateVisite(this.consultationEnteteGene.getCsgDate());
               this.factureLigneMedical.setFacligDateSortie((Date)null);
               this.factureLigneMedical.setFacligDevise(this.structureLog.getStrdevise());
               this.factureLigneMedical.setFacligDossier(this.consultationEnteteGene.getPatients().getPatDossier());
               this.factureLigneMedical.setFacligFamille("" + this.consultationEnteteGene.getCsgFam());
               this.factureLigneMedical.setFacligNom(this.consultationEnteteGene.getPatients().getPatNom());
               this.factureLigneMedical.setFacligPrenom(this.consultationEnteteGene.getPatients().getPatPrenom());
               this.factureLigneMedical.setFacligNumConsultation(this.consultationEnteteGene.getCsgNum());
               this.factureLigneMedical.setFacligService(this.consultationEnteteGene.getCsgService());
               this.factureLigneMedical.setFacligNomAssure(this.consultationEnteteGene.getCsgNomAssurePrincipal());
               this.factureLigneMedical.setFacligMatricule(this.consultationEnteteGene.getCsgMatricule());
               this.factureLigneMedical.setFacligNumBc(this.consultationEnteteGene.getCsgNumBc());
               this.factureLigneMedical.setFacligNumFeuille(this.consultationEnteteGene.getCsgFeuille());
               this.factureLigneMedical.setFacligOrigine(0);
               this.factureLigneMedical.setFacligDossierAssure("");
               this.factureLigneMedical.setFacligMatriculeAssure("");
               if (this.factureLigneMedical.getFacligDossier().contains("-") && this.consultationEnteteGene.getCsgFam() > 0L) {
                  this.patientPec = new PatientPec();
                  this.patientPec = this.patientPecDao.trouverPatientsPec(this.consultationEnteteGene.getCsgFam(), 9, var3);
                  if (this.patientPec != null) {
                     String[] var6 = this.factureLigneMedical.getFacligDossier().split("-");
                     this.factureLigneMedical.setFacligDossierAssure(var6[0]);
                     this.factureLigneMedical.setFacligMatriculeAssure(this.patientPec.getPatpecMatriculeCouvert());
                  }
               }

               this.factureLigneMedical.setFacligIdConsultation(this.consultationActes.getCslactId());
               this.factureLigneMedical.setFacligCode(this.consultationActes.getCslactProduit());
               this.factureLigneMedical.setFacligLibelle(this.consultationActes.getCslactLibelle());
               this.produits = this.produitsVtesDao.chargeProduit(this.factureLigneMedical.getFacligCode(), var3);
               if (this.produits != null) {
                  this.factureLigneMedical.setFacligLibelleFamille(this.produits.getProVteLib());
               } else {
                  this.factureLigneMedical.setFacligLibelleFamille("");
               }

               if (this.inpTiersPayeurs != 3 && this.inpTiersPayeurs != 53 && this.inpTiersPayeurs != 63) {
                  if (this.consultationEnteteGene.getCsgPecCnamgs() != 0.0F) {
                     this.factureLigneMedical.setFacligReference(this.consultationActes.getCslactNbCnamgs() + " " + this.consultationActes.getCslactLettre() + " " + this.consultationActes.getCslactValeurCnamgs());
                     this.factureLigneMedical.setFacligPu(this.consultationActes.getCslactPuCnamgs());
                     this.factureLigneMedical.setFacligPecCnamgs(this.consultationEnteteGene.getCsgPecCnamgs());
                  } else if (this.consultationActes.getCslactLettre() != null && !this.consultationActes.getCslactLettre().isEmpty()) {
                     this.factureLigneMedical.setFacligReference(this.consultationActes.getCslactNb() + " " + this.consultationActes.getCslactLettre() + " " + this.consultationActes.getCslactValeur());
                     this.factureLigneMedical.setFacligPu(this.utilNombre.myRoundDevise(this.consultationActes.getCslactAssuranceHt() / (double)this.consultationActes.getCslactQte(), this.structureLog.getStrdevise()));
                     this.factureLigneMedical.setFacligPecCnamgs(0.0F);
                  } else {
                     this.factureLigneMedical.setFacligPu(this.utilNombre.myRoundDevise(this.consultationActes.getCslactAssuranceHt() / (double)this.consultationActes.getCslactQte(), this.structureLog.getStrdevise()));
                     this.factureLigneMedical.setFacligPecCnamgs(0.0F);
                  }
               } else {
                  this.factureLigneMedical.setFacligReference("");
                  this.factureLigneMedical.setFacligPu(this.utilNombre.myRoundDevise(this.consultationActes.getCslactComplementaireHt() / (double)this.consultationActes.getCslactQte(), this.structureLog.getStrdevise()));
                  this.factureLigneMedical.setFacligPecCnamgs(0.0F);
               }

               this.factureLigneMedical.setFacligTauxRemise(this.consultationActes.getCslactRemise());
               this.factureLigneMedical.setFacligPuRem(this.consultationActes.getCslactPuRem());
               this.factureLigneMedical.setFacligPt(this.consultationActes.getCslactAssuranceHt() + this.consultationActes.getCslactSocieteHt() + this.consultationActes.getCslactComplementaireHt());
               this.factureLigneMedical.setFacligTauxTaxe(this.consultationActes.getCslactTauxTva());
               this.factureLigneMedical.setFacligTaxe(this.consultationActes.getCslactCodeTva());
               this.factureLigneMedical.setFacligTva(this.consultationActes.getCslactAssuranceTaxe() + this.consultationActes.getCslactSocieteTaxe() + this.consultationActes.getCslactComplementaireTaxe());
               this.factureLigneMedical.setFacligTtc(this.factureLigneMedical.getFacligPt() + this.factureLigneMedical.getFacligTva());
               this.factureLigneMedical.setFacligTtcActe(this.consultationActes.getCslactTotal());
               if (this.inpTiersPayeurs != 3 && this.inpTiersPayeurs != 53 && this.inpTiersPayeurs != 63) {
                  if (this.consultationEnteteGene.getCsgPecCnamgs() != 0.0F) {
                     this.factureLigneMedical.setFacligTotPatient(this.consultationActes.getCslactTotal() + this.consultationActes.getCslactTaxe() - (this.consultationActes.getCslactAssuranceHt() + this.consultationActes.getCslactAssuranceTaxe()));
                  } else {
                     this.factureLigneMedical.setFacligTotPatient(this.consultationActes.getCslactPatientHt() + this.consultationActes.getCslactPatientTaxe());
                  }
               } else {
                  this.factureLigneMedical.setFacligTotPatient(this.consultationActes.getCslactPatientHt() + this.consultationActes.getCslactPatientTaxe());
               }

               this.factureLigneMedical.setFacligPuTtc(0.0D);
               this.factureLigneMedical.setFacligPuRemTtc(0.0D);
               this.factureLigneMedical.setFacligTc(0.0D);
               this.factureLigneMedical.setFacligRabais(0.0D);
               this.factureLigneMedical.setFacligQte(this.consultationActes.getCslactQte());
               this.factureLigneMedical.setFacligOrdre(this.ordre);
               this.factureLigneMedical.setFactureEnteteMedical(this.factureEnteteMedical);
               if (this.factureLigneMedical.getFacligPt() != 0.0D) {
                  this.factureLigneMedical = this.factureLigneMedicalDao.insertLigne(this.factureLigneMedical, var3);
               }
            }
         }
      } else {
         this.consultationEnteteGene = this.consultationEnteteGeneDao.selectById(var1, var3);
         this.factureLigneMedical = new FactureLigneMedical();
         this.factureLigneMedical.setFacligCivilite(this.consultationEnteteGene.getCsgCivilite());
         this.factureLigneMedical.setFacligDateVisite(this.consultationEnteteGene.getCsgDate());
         this.factureLigneMedical.setFacligDateSortie((Date)null);
         this.factureLigneMedical.setFacligDevise(this.structureLog.getStrdevise());
         this.factureLigneMedical.setFacligDossier(this.consultationEnteteGene.getPatients().getPatDossier());
         this.factureLigneMedical.setFacligFamille("" + this.consultationEnteteGene.getCsgFam());
         this.factureLigneMedical.setFacligNom(this.consultationEnteteGene.getPatients().getPatNom());
         this.factureLigneMedical.setFacligPrenom(this.consultationEnteteGene.getPatients().getPatPrenom());
         this.factureLigneMedical.setFacligNumConsultation(this.consultationEnteteGene.getCsgNum());
         this.factureLigneMedical.setFacligService(this.consultationEnteteGene.getCsgService());
         this.factureLigneMedical.setFacligNomAssure(this.consultationEnteteGene.getCsgNomAssurePrincipal());
         this.factureLigneMedical.setFacligMatricule(this.consultationEnteteGene.getCsgMatricule());
         this.factureLigneMedical.setFacligNumBc(this.consultationEnteteGene.getCsgNumBc());
         this.factureLigneMedical.setFacligNumFeuille(this.consultationEnteteGene.getCsgFeuille());
         this.factureLigneMedical.setFacligOrigine(0);
         this.factureLigneMedical.setFacligDossierAssure("");
         this.factureLigneMedical.setFacligMatriculeAssure("");
         if (this.factureLigneMedical.getFacligDossier().contains("-") && this.consultationEnteteGene.getCsgFam() > 0L) {
            this.patientPec = new PatientPec();
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.consultationEnteteGene.getCsgFam(), 9, var3);
            if (this.patientPec != null) {
               String[] var7 = this.factureLigneMedical.getFacligDossier().split("-");
               this.factureLigneMedical.setFacligDossierAssure(var7[0]);
               this.factureLigneMedical.setFacligMatriculeAssure(this.patientPec.getPatpecMatriculeCouvert());
            }
         }

         this.factureLigneMedical.setFacligIdConsultation(this.consultationEnteteGene.getCsgId());
         this.factureLigneMedical.setFacligCode("");
         this.factureLigneMedical.setFacligLibelle("Consultation");
         this.factureLigneMedical.setFacligLibelleFamille("");
         this.factureLigneMedical.setFacligPu(this.consultationEnteteGene.getTotalTiers());
         if (this.inpTiersPayeurs != 3 && this.inpTiersPayeurs != 53 && this.inpTiersPayeurs != 63) {
            if (this.consultationEnteteGene.getCsgPecCnamgs() != 0.0F) {
               this.factureLigneMedical.setFacligPecCnamgs(this.consultationEnteteGene.getCsgPecCnamgs());
               this.factureLigneMedical.setFacligPt(this.consultationEnteteGene.getCsgTotAssurance());
            } else {
               this.factureLigneMedical.setFacligPecCnamgs(0.0F);
               this.factureLigneMedical.setFacligPt(this.consultationEnteteGene.getTotalTiers());
            }
         } else {
            this.factureLigneMedical.setFacligReference("");
            this.factureLigneMedical.setFacligPt(this.consultationEnteteGene.getCsgTotComplmentaire());
            this.factureLigneMedical.setFacligPecCnamgs(0.0F);
         }

         this.factureLigneMedical.setFacligTtcActe(this.consultationEnteteGene.getCsgTotGeneral() + this.consultationEnteteGene.getCsgTotRabais());
         if (this.inpTiersPayeurs != 3 && this.inpTiersPayeurs != 53 && this.inpTiersPayeurs != 63) {
            this.factureLigneMedical.setFacligTotPatient(this.factureLigneMedical.getFacligTtcActe() - this.factureLigneMedical.getFacligPt());
         } else {
            this.factureLigneMedical.setFacligTotPatient(0.0D);
         }

         this.factureLigneMedical.setFacligTauxRemise(0.0F);
         this.factureLigneMedical.setFacligPuRem(0.0D);
         this.factureLigneMedical.setFacligTauxTaxe(0.0F);
         this.factureLigneMedical.setFacligTaxe("");
         this.factureLigneMedical.setFacligTva(0.0D);
         this.factureLigneMedical.setFacligTtc(this.factureLigneMedical.getFacligPt() + this.factureLigneMedical.getFacligTva());
         this.factureLigneMedical.setFacligTtcActe(0.0D);
         this.factureLigneMedical.setFacligPuTtc(0.0D);
         this.factureLigneMedical.setFacligPuRemTtc(0.0D);
         this.factureLigneMedical.setFacligTc(0.0D);
         this.factureLigneMedical.setFacligRabais(0.0D);
         this.factureLigneMedical.setFacligQte(1.0F);
         this.factureLigneMedical.setFacligOrdre(this.ordre);
         this.factureLigneMedical.setFactureEnteteMedical(this.factureEnteteMedical);
         if (this.factureLigneMedical.getFacligPt() != 0.0D) {
            this.factureLigneMedical = this.factureLigneMedicalDao.insertLigne(this.factureLigneMedical, var3);
         }
      }

   }

   public void creationlignePharmacieFacture(long var1, Session var3) throws HibernateException, NamingException {
      if (this.optionMedical.getModeRefacturation().equals("0")) {
         new ArrayList();
         List var4 = this.pharmacieLigneDao.selectConsActesByConsEnt(var1, var3);
         if (var4.size() != 0) {
            for(int var5 = 0; var5 < var4.size(); ++var5) {
               ++this.ordre;
               this.pharmacieLigne = (PharmacieLigne)var4.get(var5);
               this.pharmacieEntete = this.pharmacieLigne.getPharmacieEntete();
               this.factureLigneMedical = new FactureLigneMedical();
               this.factureLigneMedical.setFacligCivilite(this.pharmacieEntete.getPhaCivilite());
               this.factureLigneMedical.setFacligDateVisite(this.pharmacieEntete.getPhaDate());
               this.factureLigneMedical.setFacligDateSortie((Date)null);
               this.factureLigneMedical.setFacligDevise(this.structureLog.getStrdevise());
               this.factureLigneMedical.setFacligDossier(this.pharmacieEntete.getPatients().getPatDossier());
               this.factureLigneMedical.setFacligFamille("" + this.pharmacieEntete.getPhaFam());
               this.factureLigneMedical.setFacligNom(this.pharmacieEntete.getPatients().getPatNom());
               this.factureLigneMedical.setFacligPrenom(this.pharmacieEntete.getPatients().getPatPrenom());
               this.factureLigneMedical.setFacligNumPharmacie(this.pharmacieEntete.getPhaNum());
               this.factureLigneMedical.setFacligService(this.pharmacieEntete.getPhaService());
               this.factureLigneMedical.setFacligNomAssure(this.pharmacieEntete.getPhaNomAssurePrincipal());
               this.factureLigneMedical.setFacligMatricule(this.pharmacieEntete.getPhaMatricule());
               this.factureLigneMedical.setFacligNumBc(this.pharmacieEntete.getPhaNumBc());
               this.factureLigneMedical.setFacligNumFeuille(this.pharmacieEntete.getPhaFeuille());
               this.factureLigneMedical.setFacligOrigine(1);
               this.factureLigneMedical.setFacligDossierAssure("");
               this.factureLigneMedical.setFacligMatriculeAssure("");
               if (this.factureLigneMedical.getFacligDossier().contains("-") && this.pharmacieEntete.getPhaFam() > 0L) {
                  this.patientPec = new PatientPec();
                  this.patientPec = this.patientPecDao.trouverPatientsPec(this.pharmacieEntete.getPhaFam(), 9, var3);
                  if (this.patientPec != null) {
                     String[] var6 = this.factureLigneMedical.getFacligDossier().split("-");
                     this.factureLigneMedical.setFacligDossierAssure(var6[0]);
                     this.factureLigneMedical.setFacligMatriculeAssure(this.patientPec.getPatpecMatriculeCouvert());
                  }
               }

               this.factureLigneMedical.setFacligIdPharmacie(this.pharmacieLigne.getPhaligId());
               this.factureLigneMedical.setFacligCode(this.pharmacieLigne.getPhaligProduit());
               this.factureLigneMedical.setFacligLibelle(this.pharmacieLigne.getPhaligLibelle());
               this.produits = this.produitsVtesDao.chargeProduit(this.factureLigneMedical.getFacligCode(), var3);
               if (this.produits != null) {
                  this.factureLigneMedical.setFacligLibelleFamille(this.produits.getProVteLib());
               } else {
                  this.factureLigneMedical.setFacligLibelleFamille("");
               }

               if (this.inpTiersPayeurs != 3 && this.inpTiersPayeurs != 53 && this.inpTiersPayeurs != 63) {
                  if (this.pharmacieEntete.getPhaPecCnamgs() != 0.0F) {
                     this.factureLigneMedical.setFacligPu(this.pharmacieLigne.getPhaligPuCnamgs());
                  } else {
                     this.factureLigneMedical.setFacligPu(this.utilNombre.myRoundDevise(this.pharmacieLigne.getPhaligAssuranceHt() / (double)this.pharmacieLigne.getPhaligQte(), this.structureLog.getStrdevise()));
                  }
               } else {
                  this.factureLigneMedical.setFacligPu(this.utilNombre.myRoundDevise(this.pharmacieLigne.getPhaligComplementaireHt() / (double)this.pharmacieLigne.getPhaligQte(), this.structureLog.getStrdevise()));
               }

               this.factureLigneMedical.setFacligTauxRemise(this.pharmacieLigne.getPhaligRemise());
               this.factureLigneMedical.setFacligPuRem(this.pharmacieLigne.getPhaligPuRem());
               this.factureLigneMedical.setFacligPt(this.pharmacieLigne.getPhaligAssuranceHt() + this.pharmacieLigne.getPhaligSocieteHt() + this.pharmacieLigne.getPhaligComplementaireHt());
               this.factureLigneMedical.setFacligTauxTaxe(this.pharmacieLigne.getPhaligTauxTva());
               this.factureLigneMedical.setFacligTaxe(this.pharmacieLigne.getPhaligCodeTva());
               this.factureLigneMedical.setFacligTva(this.pharmacieLigne.getPhaligAssuranceTaxe() + this.pharmacieLigne.getPhaligSocieteTaxe() + this.pharmacieLigne.getPhaligComplementaireTaxe());
               this.factureLigneMedical.setFacligTtc(this.factureLigneMedical.getFacligPt() + this.factureLigneMedical.getFacligTva());
               this.factureLigneMedical.setFacligTtcActe(this.pharmacieLigne.getPhaligTotal());
               if (this.inpTiersPayeurs != 3 && this.inpTiersPayeurs != 53 && this.inpTiersPayeurs != 63) {
                  if (this.pharmacieEntete.getPhaPecCnamgs() != 0.0F) {
                     this.factureLigneMedical.setFacligTotPatient(this.pharmacieLigne.getPhaligTotal() + this.pharmacieLigne.getPhaligTaxe() - (this.pharmacieLigne.getPhaligAssuranceHt() + this.pharmacieLigne.getPhaligAssuranceTaxe()));
                  } else {
                     this.factureLigneMedical.setFacligTotPatient(this.pharmacieLigne.getPhaligPatientHt() + this.pharmacieLigne.getPhaligPatientTaxe());
                  }
               } else {
                  this.factureLigneMedical.setFacligTotPatient(this.pharmacieLigne.getPhaligPatientHt() + this.pharmacieLigne.getPhaligPatientTaxe());
               }

               this.factureLigneMedical.setFacligPuTtc(0.0D);
               this.factureLigneMedical.setFacligPuRemTtc(0.0D);
               this.factureLigneMedical.setFacligTc(0.0D);
               this.factureLigneMedical.setFacligRabais(0.0D);
               this.factureLigneMedical.setFacligQte(this.pharmacieLigne.getPhaligQte());
               this.factureLigneMedical.setFacligOrdre(this.ordre);
               this.factureLigneMedical.setFactureEnteteMedical(this.factureEnteteMedical);
               if (this.factureLigneMedical.getFacligPt() != 0.0D) {
                  this.factureLigneMedical = this.factureLigneMedicalDao.insertLigne(this.factureLigneMedical, var3);
               }
            }
         }
      } else {
         this.pharmacieEntete = this.pharmacieEnteteDao.selectById(var1, var3);
         this.factureLigneMedical = new FactureLigneMedical();
         this.factureLigneMedical.setFacligCivilite(this.pharmacieEntete.getPhaCivilite());
         this.factureLigneMedical.setFacligDateVisite(this.pharmacieEntete.getPhaDate());
         this.factureLigneMedical.setFacligDateSortie((Date)null);
         this.factureLigneMedical.setFacligDevise(this.structureLog.getStrdevise());
         this.factureLigneMedical.setFacligDossier(this.pharmacieEntete.getPatients().getPatDossier());
         this.factureLigneMedical.setFacligFamille("" + this.pharmacieEntete.getPhaFam());
         this.factureLigneMedical.setFacligNom(this.pharmacieEntete.getPatients().getPatNom());
         this.factureLigneMedical.setFacligPrenom(this.pharmacieEntete.getPatients().getPatPrenom());
         this.factureLigneMedical.setFacligNumPharmacie(this.pharmacieEntete.getPhaNum());
         this.factureLigneMedical.setFacligService(this.pharmacieEntete.getPhaService());
         this.factureLigneMedical.setFacligNomAssure(this.pharmacieEntete.getPhaNomAssurePrincipal());
         this.factureLigneMedical.setFacligMatricule(this.pharmacieEntete.getPhaMatricule());
         this.factureLigneMedical.setFacligNumBc(this.pharmacieEntete.getPhaNumBc());
         this.factureLigneMedical.setFacligNumFeuille(this.pharmacieEntete.getPhaFeuille());
         this.factureLigneMedical.setFacligOrigine(1);
         this.factureLigneMedical.setFacligDossierAssure("");
         this.factureLigneMedical.setFacligMatriculeAssure("");
         if (this.factureLigneMedical.getFacligDossier().contains("-") && this.pharmacieEntete.getPhaFam() > 0L) {
            this.patientPec = new PatientPec();
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.pharmacieEntete.getPhaFam(), 9, var3);
            if (this.patientPec != null) {
               String[] var7 = this.factureLigneMedical.getFacligDossier().split("-");
               this.factureLigneMedical.setFacligDossierAssure(var7[0]);
               this.factureLigneMedical.setFacligMatriculeAssure(this.patientPec.getPatpecMatriculeCouvert());
            }
         }

         this.factureLigneMedical.setFacligIdPharmacie(this.pharmacieEntete.getPhaId());
         this.factureLigneMedical.setFacligCode("");
         this.factureLigneMedical.setFacligLibelle("Pharmacie");
         this.factureLigneMedical.setFacligLibelleFamille("");
         this.factureLigneMedical.setFacligPu(this.pharmacieEntete.getTotalTiers());
         if (this.inpTiersPayeurs != 3 && this.inpTiersPayeurs != 53 && this.inpTiersPayeurs != 63) {
            if (this.pharmacieEntete.getPhaPecCnamgs() != 0.0F) {
               this.factureLigneMedical.setFacligPecCnamgs(this.pharmacieEntete.getPhaPecCnamgs());
               this.factureLigneMedical.setFacligPt(this.pharmacieEntete.getPhaTotAssurance());
            } else {
               this.factureLigneMedical.setFacligPecCnamgs(0.0F);
               this.factureLigneMedical.setFacligPt(this.pharmacieEntete.getTotalTiers());
            }
         } else {
            this.factureLigneMedical.setFacligPecCnamgs(0.0F);
            this.factureLigneMedical.setFacligPt(this.pharmacieEntete.getPhaTotComplmentaire());
         }

         this.factureLigneMedical.setFacligTtcActe(this.pharmacieEntete.getPhaTotGeneral() + this.pharmacieEntete.getPhaTotRabais());
         if (this.inpTiersPayeurs != 3 && this.inpTiersPayeurs != 53 && this.inpTiersPayeurs != 63) {
            this.factureLigneMedical.setFacligTotPatient(this.factureLigneMedical.getFacligTtcActe() - this.factureLigneMedical.getFacligPt());
         } else {
            this.factureLigneMedical.setFacligTotPatient(0.0D);
         }

         this.factureLigneMedical.setFacligTauxRemise(0.0F);
         this.factureLigneMedical.setFacligPuRem(0.0D);
         this.factureLigneMedical.setFacligTauxTaxe(0.0F);
         this.factureLigneMedical.setFacligTaxe("");
         this.factureLigneMedical.setFacligTva(0.0D);
         this.factureLigneMedical.setFacligTtc(this.factureLigneMedical.getFacligPt() + this.factureLigneMedical.getFacligTva());
         this.factureLigneMedical.setFacligTtcActe(0.0D);
         this.factureLigneMedical.setFacligPuTtc(0.0D);
         this.factureLigneMedical.setFacligPuRemTtc(0.0D);
         this.factureLigneMedical.setFacligTc(0.0D);
         this.factureLigneMedical.setFacligRabais(0.0D);
         this.factureLigneMedical.setFacligQte(1.0F);
         this.factureLigneMedical.setFacligOrdre(this.ordre);
         this.factureLigneMedical.setFactureEnteteMedical(this.factureEnteteMedical);
         if (this.factureLigneMedical.getFacligPt() != 0.0D) {
            this.factureLigneMedical = this.factureLigneMedicalDao.insertLigne(this.factureLigneMedical, var3);
         }
      }

   }

   public void creationligneLaboratoireFacture(long var1, double var3, Session var5) throws HibernateException, NamingException {
      if (this.optionMedical.getModeRefacturation().equals("0")) {
         new ArrayList();
         List var6 = this.laboratoireLigneDao.selectConsActesByConsEnt(var1, var5);
         if (var6.size() != 0) {
            for(int var7 = 0; var7 < var6.size(); ++var7) {
               ++this.ordre;
               this.laboratoireLigne = (LaboratoireLigne)var6.get(var7);
               this.laboratoireEntete = this.laboratoireLigne.getLaboratoireEntete();
               this.factureLigneMedical = new FactureLigneMedical();
               this.factureLigneMedical.setFacligCivilite(this.laboratoireEntete.getLabCivilite());
               this.factureLigneMedical.setFacligDateVisite(this.laboratoireEntete.getLabDate());
               this.factureLigneMedical.setFacligDateSortie((Date)null);
               this.factureLigneMedical.setFacligDevise(this.structureLog.getStrdevise());
               this.factureLigneMedical.setFacligDossier(this.laboratoireEntete.getPatients().getPatDossier());
               this.factureLigneMedical.setFacligFamille("" + this.laboratoireEntete.getLabFam());
               this.factureLigneMedical.setFacligNom(this.laboratoireEntete.getPatients().getPatNom());
               this.factureLigneMedical.setFacligPrenom(this.laboratoireEntete.getPatients().getPatPrenom());
               this.factureLigneMedical.setFacligNumLaboratoire(this.laboratoireEntete.getLabNum());
               if (this.laboratoireLigne.getLabligLaboratoire() != null && !this.laboratoireLigne.getLabligLaboratoire().isEmpty()) {
                  this.factureLigneMedical.setFacligService(this.laboratoireLigne.getLabligLaboratoire());
               } else {
                  this.factureLigneMedical.setFacligService(this.laboratoireEntete.getLabLaboratoire());
               }

               this.factureLigneMedical.setFacligNomAssure(this.laboratoireEntete.getLabNomAssurePrincipal());
               this.factureLigneMedical.setFacligMatricule(this.laboratoireEntete.getLabMatricule());
               this.factureLigneMedical.setFacligNumBc(this.laboratoireEntete.getLabNumBc());
               this.factureLigneMedical.setFacligNumFeuille(this.laboratoireEntete.getLabFeuille());
               this.factureLigneMedical.setFacligOrigine(2);
               this.factureLigneMedical.setFacligDossierAssure("");
               this.factureLigneMedical.setFacligMatriculeAssure("");
               if (this.factureLigneMedical.getFacligDossier().contains("-") && this.laboratoireEntete.getLabFam() > 0L) {
                  this.patientPec = new PatientPec();
                  this.patientPec = this.patientPecDao.trouverPatientsPec(this.laboratoireEntete.getLabFam(), 9, var5);
                  if (this.patientPec != null) {
                     String[] var8 = this.factureLigneMedical.getFacligDossier().split("-");
                     this.factureLigneMedical.setFacligDossierAssure(var8[0]);
                     this.factureLigneMedical.setFacligMatriculeAssure(this.patientPec.getPatpecMatriculeCouvert());
                  }
               }

               this.factureLigneMedical.setFacligIdLaboratoire(this.laboratoireLigne.getLabligId());
               this.factureLigneMedical.setFacligCode(this.laboratoireLigne.getLabligProduit());
               this.factureLigneMedical.setFacligLibelle(this.laboratoireLigne.getLabligLibelle());
               this.produits = this.produitsVtesDao.chargeProduit(this.factureLigneMedical.getFacligCode(), var5);
               if (this.produits != null) {
                  this.factureLigneMedical.setFacligLibelleFamille(this.produits.getProVteLib());
               } else {
                  this.factureLigneMedical.setFacligLibelleFamille("");
               }

               if (this.inpTiersPayeurs != 3 && this.inpTiersPayeurs != 53 && this.inpTiersPayeurs != 63) {
                  if (this.laboratoireEntete.getLabPecCnamgs() != 0.0F) {
                     this.factureLigneMedical.setFacligReference(this.laboratoireLigne.getLabligNbCnamgs() + " " + this.laboratoireLigne.getLabligLettre() + " " + this.laboratoireLigne.getLabligValeurCnamgs());
                     this.factureLigneMedical.setFacligPu(this.laboratoireLigne.getLabligPuCnamgs());
                     this.factureLigneMedical.setFacligPecCnamgs(this.laboratoireEntete.getLabPecCnamgs());
                  } else if (this.consultationActes.getCslactLettre() != null && !this.laboratoireLigne.getLabligLettre().isEmpty()) {
                     this.factureLigneMedical.setFacligReference(this.laboratoireLigne.getLabligNb() + " " + this.laboratoireLigne.getLabligLettre() + " " + this.laboratoireLigne.getLabligValeur());
                     this.factureLigneMedical.setFacligPu(this.utilNombre.myRoundDevise(this.laboratoireLigne.getLabligAssuranceHt() / (double)this.laboratoireLigne.getLabligQte(), this.structureLog.getStrdevise()));
                     this.factureLigneMedical.setFacligPecCnamgs(0.0F);
                  } else {
                     this.factureLigneMedical.setFacligPu(this.utilNombre.myRoundDevise(this.laboratoireLigne.getLabligAssuranceHt() / (double)this.laboratoireLigne.getLabligQte(), this.structureLog.getStrdevise()));
                     this.factureLigneMedical.setFacligPecCnamgs(0.0F);
                  }
               } else {
                  this.factureLigneMedical.setFacligPu(this.utilNombre.myRoundDevise(this.laboratoireLigne.getLabligComplementaireHt() / (double)this.laboratoireLigne.getLabligQte(), this.structureLog.getStrdevise()));
                  this.factureLigneMedical.setFacligPecCnamgs(0.0F);
               }

               this.factureLigneMedical.setFacligTauxRemise(this.laboratoireLigne.getLabligRemise());
               this.factureLigneMedical.setFacligPuRem(this.laboratoireLigne.getLabligPuRem());
               this.factureLigneMedical.setFacligPt(this.laboratoireLigne.getLabligAssuranceHt() + this.laboratoireLigne.getLabligSocieteHt() + this.laboratoireLigne.getLabligComplementaireHt());
               this.factureLigneMedical.setFacligTauxTaxe(this.laboratoireLigne.getLabligTauxTva());
               this.factureLigneMedical.setFacligTaxe(this.laboratoireLigne.getLabligCodeTva());
               this.factureLigneMedical.setFacligTva(this.laboratoireLigne.getLabligAssuranceTaxe() + this.laboratoireLigne.getLabligSocieteTaxe() + this.laboratoireLigne.getLabligComplementaireTaxe());
               this.factureLigneMedical.setFacligTtc(this.factureLigneMedical.getFacligPt() + this.factureLigneMedical.getFacligTva());
               this.factureLigneMedical.setFacligTtcActe(this.laboratoireLigne.getLabligTotal());
               if (this.inpTiersPayeurs != 3 && this.inpTiersPayeurs != 53 && this.inpTiersPayeurs != 63) {
                  if (this.laboratoireEntete.getLabPecCnamgs() != 0.0F) {
                     this.factureLigneMedical.setFacligTotPatient(this.laboratoireLigne.getLabligTotal() + this.laboratoireLigne.getLabligTaxe() - (this.laboratoireLigne.getLabligAssuranceHt() + this.laboratoireLigne.getLabligAssuranceTaxe()));
                  } else {
                     this.factureLigneMedical.setFacligTotPatient(this.laboratoireLigne.getLabligPatientHt() + this.laboratoireLigne.getLabligPatientTaxe());
                  }
               } else {
                  this.factureLigneMedical.setFacligTotPatient(this.laboratoireLigne.getLabligPatientHt() + this.laboratoireLigne.getLabligPatientTaxe());
               }

               this.factureLigneMedical.setFacligPuTtc(0.0D);
               this.factureLigneMedical.setFacligPuRemTtc(0.0D);
               this.factureLigneMedical.setFacligTc(0.0D);
               this.factureLigneMedical.setFacligRabais(0.0D);
               this.factureLigneMedical.setFacligQte(this.laboratoireLigne.getLabligQte());
               this.factureLigneMedical.setFacligOrdre(this.ordre);
               this.factureLigneMedical.setFactureEnteteMedical(this.factureEnteteMedical);
               if (this.factureLigneMedical.getFacligPt() != 0.0D) {
                  this.factureLigneMedical = this.factureLigneMedicalDao.insertLigne(this.factureLigneMedical, var5);
               }
            }
         }
      } else {
         this.laboratoireEntete = this.laboratoireEnteteDao.selectById(var1, var5);
         this.factureLigneMedical = new FactureLigneMedical();
         this.factureLigneMedical.setFacligCivilite(this.laboratoireEntete.getLabCivilite());
         this.factureLigneMedical.setFacligDateVisite(this.laboratoireEntete.getLabDate());
         this.factureLigneMedical.setFacligDateSortie((Date)null);
         this.factureLigneMedical.setFacligDevise(this.structureLog.getStrdevise());
         this.factureLigneMedical.setFacligDossier(this.laboratoireEntete.getPatients().getPatDossier());
         this.factureLigneMedical.setFacligFamille("" + this.laboratoireEntete.getLabFam());
         this.factureLigneMedical.setFacligNom(this.laboratoireEntete.getPatients().getPatNom());
         this.factureLigneMedical.setFacligPrenom(this.laboratoireEntete.getPatients().getPatPrenom());
         this.factureLigneMedical.setFacligNumLaboratoire(this.laboratoireEntete.getLabNum());
         this.factureLigneMedical.setFacligService(this.laboratoireEntete.getLabLaboratoire());
         this.factureLigneMedical.setFacligNomAssure(this.laboratoireEntete.getLabNomAssurePrincipal());
         this.factureLigneMedical.setFacligMatricule(this.laboratoireEntete.getLabMatricule());
         this.factureLigneMedical.setFacligNumBc(this.laboratoireEntete.getLabNumBc());
         this.factureLigneMedical.setFacligNumFeuille(this.laboratoireEntete.getLabFeuille());
         this.factureLigneMedical.setFacligOrigine(2);
         this.factureLigneMedical.setFacligDossierAssure("");
         this.factureLigneMedical.setFacligMatriculeAssure("");
         String[] var9;
         if (this.factureLigneMedical.getFacligDossier().contains("-") && this.laboratoireEntete.getLabFam() > 0L) {
            this.patientPec = new PatientPec();
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.laboratoireEntete.getLabFam(), 9, var5);
            if (this.patientPec != null) {
               var9 = this.factureLigneMedical.getFacligDossier().split("-");
               this.factureLigneMedical.setFacligDossierAssure(var9[0]);
               this.factureLigneMedical.setFacligMatriculeAssure(this.patientPec.getPatpecMatriculeCouvert());
            }
         }

         this.factureLigneMedical.setFacligIdLaboratoire(this.laboratoireEntete.getLabId());
         this.factureLigneMedical.setFacligCode("");
         if (this.laboratoireEntete.getLabService() != null && !this.laboratoireEntete.getLabService().isEmpty()) {
            if (this.laboratoireEntete.getLabService().contains(":")) {
               var9 = this.laboratoireEntete.getLabService().split(":");
               this.factureLigneMedical.setFacligLibelle(var9[1]);
            } else {
               this.factureLigneMedical.setFacligLibelle(this.laboratoireEntete.getLabService());
            }
         } else {
            this.factureLigneMedical.setFacligLibelle("Laboratoire");
         }

         this.factureLigneMedical.setFacligLibelleFamille("");
         this.factureLigneMedical.setFacligPu(this.laboratoireEntete.getTotalTiers());
         if (this.inpTiersPayeurs != 3 && this.inpTiersPayeurs != 53 && this.inpTiersPayeurs != 63) {
            if (this.laboratoireEntete.getLabPecCnamgs() != 0.0F) {
               this.factureLigneMedical.setFacligPecCnamgs(this.laboratoireEntete.getLabPecCnamgs());
               this.factureLigneMedical.setFacligPt(this.laboratoireEntete.getLabTotAssurance());
               this.factureLigneMedical.setFacligTtcActe(this.laboratoireEntete.getLabTotGeneral());
               this.factureLigneMedical.setFacligTotPatient(this.laboratoireEntete.getTotalPatient() + this.laboratoireEntete.getLabTotComplmentaire());
               this.factureLigneMedical.setFacligTtcActe(this.laboratoireEntete.getLabTotGeneral() + this.laboratoireEntete.getLabTotRabais());
               this.factureLigneMedical.setFacligTotPatient(this.factureLigneMedical.getFacligTtcActe() - this.factureLigneMedical.getFacligPt());
            } else {
               this.factureLigneMedical.setFacligPecCnamgs(0.0F);
               this.factureLigneMedical.setFacligPt(this.laboratoireEntete.getTotalTiers());
               this.factureLigneMedical.setFacligTtcActe(var3);
               this.factureLigneMedical.setFacligTotPatient(this.laboratoireEntete.getTotalPatient());
            }
         } else {
            this.factureLigneMedical.setFacligPecCnamgs(0.0F);
            this.factureLigneMedical.setFacligPt(this.laboratoireEntete.getLabTotComplmentaire());
            this.factureLigneMedical.setFacligTtcActe(var3);
            this.factureLigneMedical.setFacligTotPatient(this.laboratoireEntete.getTotalPatient());
         }

         this.factureLigneMedical.setFacligTauxRemise(0.0F);
         this.factureLigneMedical.setFacligPuRem(0.0D);
         this.factureLigneMedical.setFacligTauxTaxe(0.0F);
         this.factureLigneMedical.setFacligTaxe("");
         this.factureLigneMedical.setFacligTva(0.0D);
         this.factureLigneMedical.setFacligTtc(this.factureLigneMedical.getFacligPt() + this.factureLigneMedical.getFacligTva());
         this.factureLigneMedical.setFacligPuTtc(0.0D);
         this.factureLigneMedical.setFacligPuRemTtc(0.0D);
         this.factureLigneMedical.setFacligTc(0.0D);
         this.factureLigneMedical.setFacligRabais(0.0D);
         this.factureLigneMedical.setFacligQte(1.0F);
         this.factureLigneMedical.setFacligOrdre(this.ordre);
         this.factureLigneMedical.setFactureEnteteMedical(this.factureEnteteMedical);
         if (this.factureLigneMedical.getFacligPt() != 0.0D) {
            this.factureLigneMedical = this.factureLigneMedicalDao.insertLigne(this.factureLigneMedical, var5);
         }
      }

   }

   public void creationLigneHospit(Session var1) throws HibernateException, NamingException {
      int var2;
      if (this.inpRegroupement == 0) {
         if (this.lesFacturesConcernes.size() != 0) {
            for(var2 = 0; var2 < this.lesFacturesConcernes.size(); ++var2) {
               if (this.documentEntete.getDocId() == ((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdResponsable()) {
                  this.creationLigneHospitSejourFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), var1);
                  this.creationLigneHospitActeFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), var1);
                  this.creationLigneHospitLaboFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), var1);
                  this.creationLigneHospitMedicFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), var1);
                  this.creationLigneHospitPrestFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), var1);
               }
            }
         }
      } else if (this.inpRegroupement == 1) {
         if (this.lesFacturesConcernes.size() != 0) {
            for(var2 = 0; var2 < this.lesFacturesConcernes.size(); ++var2) {
               if (this.documentEntete.getDocId() == ((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdResponsable()) {
                  if ((((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocTypeTiers() == 0 || ((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocTypeTiers() == 2) && this.documentEntete.getDocIdEquipe() == ((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCommercial()) {
                     this.creationLigneHospitSejourFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), var1);
                     this.creationLigneHospitActeFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), var1);
                     this.creationLigneHospitLaboFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), var1);
                     this.creationLigneHospitMedicFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), var1);
                     this.creationLigneHospitPrestFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), var1);
                  } else if (((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocTypeTiers() == 1 && this.documentEntete.getDocEntree() != null && !this.documentEntete.getDocEntree().isEmpty() && ((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocEntree() != null && !((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocEntree().isEmpty() && this.documentEntete.getDocEntree().equals(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocEntree())) {
                     this.creationLigneHospitSejourFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), var1);
                     this.creationLigneHospitActeFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), var1);
                     this.creationLigneHospitLaboFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), var1);
                     this.creationLigneHospitMedicFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), var1);
                     this.creationLigneHospitPrestFacture(((DocumentEntete)this.lesFacturesConcernes.get(var2)).getDocIdCreateur(), var1);
                  }
               }
            }
         }
      } else if (this.inpRegroupement == 2 && this.lesTiersConcernes.size() != 0) {
         for(var2 = 0; var2 < this.lesTiersConcernes.size(); ++var2) {
            if (((DocumentEntete)this.lesTiersConcernes.get(var2)).isDocSelect()) {
               this.creationLigneHospitSejourFacture(((DocumentEntete)this.lesTiersConcernes.get(var2)).getDocIdCreateur(), var1);
               this.creationLigneHospitActeFacture(((DocumentEntete)this.lesTiersConcernes.get(var2)).getDocIdCreateur(), var1);
               this.creationLigneHospitLaboFacture(((DocumentEntete)this.lesTiersConcernes.get(var2)).getDocIdCreateur(), var1);
               this.creationLigneHospitMedicFacture(((DocumentEntete)this.lesTiersConcernes.get(var2)).getDocIdCreateur(), var1);
               this.creationLigneHospitPrestFacture(((DocumentEntete)this.lesTiersConcernes.get(var2)).getDocIdCreateur(), var1);
            }
         }
      }

   }

   public void creationLigneHospitSejourFacture(long var1, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      List var4 = this.hospitalisationSejourDao.selectSejourByEnt(var1, var3);
      if (var4.size() != 0) {
         for(int var5 = 0; var5 < var4.size(); ++var5) {
            ++this.ordre;
            this.hospitalisationSejour = (HospitalisationSejour)var4.get(var5);
            this.hospitalisationEntete = this.hospitalisationSejour.getHospitalisationEntete();
            this.factureLigneMedical = new FactureLigneMedical();
            this.factureLigneMedical.setFacligCivilite(this.hospitalisationEntete.getHosCivilite());
            this.factureLigneMedical.setFacligDateVisite(this.hospitalisationSejour.getHossejDateEntree());
            this.factureLigneMedical.setFacligDateSortie(this.hospitalisationSejour.getHossejDateSortie());
            this.factureLigneMedical.setFacligDevise(this.structureLog.getStrdevise());
            this.factureLigneMedical.setFacligDossier(this.hospitalisationEntete.getPatients().getPatDossier());
            this.factureLigneMedical.setFacligFamille("" + this.hospitalisationEntete.getHosFam());
            this.factureLigneMedical.setFacligNom(this.hospitalisationEntete.getPatients().getPatNom());
            this.factureLigneMedical.setFacligPrenom(this.hospitalisationEntete.getPatients().getPatPrenom());
            this.factureLigneMedical.setFacligNumHospitalisation(this.hospitalisationEntete.getHosNum());
            this.factureLigneMedical.setFacligService(this.hospitalisationSejour.getHossejService());
            this.factureLigneMedical.setFacligNomAssure(this.hospitalisationEntete.getHosNomAssurePrincipal());
            this.factureLigneMedical.setFacligMatricule(this.hospitalisationEntete.getHosMatricule());
            this.factureLigneMedical.setFacligNumBc(this.hospitalisationEntete.getHosNumBc());
            this.factureLigneMedical.setFacligNumFeuille(this.hospitalisationEntete.getHosFeuille());
            this.factureLigneMedical.setFacligOrigine(3);
            this.factureLigneMedical.setFacligDossierAssure("");
            this.factureLigneMedical.setFacligMatriculeAssure("");
            if (this.factureLigneMedical.getFacligDossier() != null && !this.factureLigneMedical.getFacligDossier().isEmpty() && this.factureLigneMedical.getFacligDossier().contains("-") && this.hospitalisationEntete.getHosFam() > 0L) {
               this.patientPec = new PatientPec();
               this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 9, var3);
               if (this.patientPec != null) {
                  String[] var6 = this.factureLigneMedical.getFacligDossier().split("-");
                  this.factureLigneMedical.setFacligDossierAssure(var6[0]);
                  this.factureLigneMedical.setFacligMatriculeAssure(this.patientPec.getPatpecMatriculeCouvert());
               }
            }

            this.factureLigneMedical.setFacligIdHospitalisationSejour(this.hospitalisationSejour.getHossejId());
            this.factureLigneMedical.setFacligCode(this.hospitalisationSejour.getHossejLit());
            this.factureLigneMedical.setFacligLibelle(this.hospitalisationSejour.getHossejLibelle());
            this.produits = this.produitsVtesDao.chargeProduit(this.factureLigneMedical.getFacligCode(), var3);
            if (this.produits != null) {
               this.factureLigneMedical.setFacligLibelleFamille(this.produits.getProVteLib());
            } else {
               this.factureLigneMedical.setFacligLibelleFamille("");
            }

            if (this.inpTiersPayeurs != 3 && this.inpTiersPayeurs != 53 && this.inpTiersPayeurs != 63) {
               if (this.hospitalisationEntete.getHosPecCnamgs() != 0.0F) {
                  this.factureLigneMedical.setFacligReference("");
                  this.factureLigneMedical.setFacligPu(this.hospitalisationSejour.getHossejPuCnamgs());
                  this.factureLigneMedical.setFacligPecCnamgs(0.0F);
               } else {
                  this.factureLigneMedical.setFacligPu(this.utilNombre.myRoundDevise(this.hospitalisationSejour.getHossejAssuranceHt() / (double)this.hospitalisationSejour.getHossejNbJour(), this.structureLog.getStrdevise()));
                  this.factureLigneMedical.setFacligPecCnamgs(0.0F);
               }
            } else {
               this.factureLigneMedical.setFacligPu(this.utilNombre.myRoundDevise(this.hospitalisationSejour.getHossejComplementaireHt() / (double)this.hospitalisationSejour.getHossejNbJour(), this.structureLog.getStrdevise()));
               this.factureLigneMedical.setFacligPecCnamgs(0.0F);
            }

            this.factureLigneMedical.setFacligTauxRemise(this.hospitalisationSejour.getHossejRemise());
            this.factureLigneMedical.setFacligPuRem(this.hospitalisationSejour.getHossejPuRem());
            this.factureLigneMedical.setFacligPt(this.hospitalisationSejour.getHossejAssuranceHt() + this.hospitalisationSejour.getHossejSocieteHt() + this.hospitalisationSejour.getHossejComplementaireHt());
            this.factureLigneMedical.setFacligTauxTaxe(this.hospitalisationSejour.getHossejTauxTva());
            this.factureLigneMedical.setFacligTaxe(this.hospitalisationSejour.getHossejCodeTva());
            this.factureLigneMedical.setFacligTva(this.hospitalisationSejour.getHossejAssuranceTaxe() + this.hospitalisationSejour.getHossejSocieteTaxe() + this.hospitalisationSejour.getHossejComplementaireTaxe());
            this.factureLigneMedical.setFacligTtc(this.factureLigneMedical.getFacligPt() + this.factureLigneMedical.getFacligTva());
            this.factureLigneMedical.setFacligTtcActe(this.hospitalisationSejour.getHossejTotal());
            if (this.inpTiersPayeurs != 3 && this.inpTiersPayeurs != 53 && this.inpTiersPayeurs != 63) {
               if (this.hospitalisationEntete.getHosPecCnamgs() != 0.0F) {
                  this.factureLigneMedical.setFacligTotPatient(this.hospitalisationSejour.getHossejTotal() + this.hospitalisationSejour.getHossejTaxe() - (this.hospitalisationSejour.getHossejAssuranceHt() + this.hospitalisationSejour.getHossejAssuranceTaxe()));
               } else {
                  this.factureLigneMedical.setFacligTotPatient(this.hospitalisationSejour.getHossejPatientHt() + this.hospitalisationSejour.getHossejPatientTaxe());
               }
            } else {
               this.factureLigneMedical.setFacligTotPatient(this.hospitalisationSejour.getHossejPatientHt() + this.hospitalisationSejour.getHossejPatientTaxe());
            }

            this.factureLigneMedical.setFacligPuTtc(0.0D);
            this.factureLigneMedical.setFacligPuRemTtc(0.0D);
            this.factureLigneMedical.setFacligTc(0.0D);
            this.factureLigneMedical.setFacligRabais(0.0D);
            this.factureLigneMedical.setFacligQte((float)this.hospitalisationSejour.getHossejNbJour());
            this.factureLigneMedical.setFacligOrdre(this.ordre);
            this.factureLigneMedical.setFactureEnteteMedical(this.factureEnteteMedical);
            if (this.factureLigneMedical.getFacligPt() != 0.0D) {
               this.factureLigneMedical = this.factureLigneMedicalDao.insertLigne(this.factureLigneMedical, var3);
            }
         }
      }

   }

   public void creationLigneHospitActeFacture(long var1, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      List var4 = this.hospitalisationActesDao.selectActesByEnt(var1, var3);
      if (var4.size() != 0) {
         for(int var5 = 0; var5 < var4.size(); ++var5) {
            ++this.ordre;
            this.hospitalisationActes = (HospitalisationActes)var4.get(var5);
            this.hospitalisationEntete = this.hospitalisationActes.getHospitalisationEntete();
            this.factureLigneMedical = new FactureLigneMedical();
            this.hospitalisationSejour = this.hospitalisationSejourDao.selectSejour(this.hospitalisationActes.getHosactIdSejour(), var3);
            if (this.hospitalisationSejour == null) {
               this.hospitalisationSejour = new HospitalisationSejour();
               this.hospitalisationSejour.setHossejDateEntree(this.hospitalisationEntete.getHosDateEntree());
               this.hospitalisationSejour.setHossejDateSortie(this.hospitalisationEntete.getHosDateSortie());
            }

            this.factureLigneMedical.setFacligCivilite(this.hospitalisationEntete.getHosCivilite());
            this.factureLigneMedical.setFacligDateVisite(this.hospitalisationSejour.getHossejDateEntree());
            this.factureLigneMedical.setFacligDateSortie(this.hospitalisationSejour.getHossejDateSortie());
            this.factureLigneMedical.setFacligDevise(this.structureLog.getStrdevise());
            this.factureLigneMedical.setFacligDossier(this.hospitalisationEntete.getPatients().getPatDossier());
            this.factureLigneMedical.setFacligFamille("" + this.hospitalisationEntete.getHosFam());
            this.factureLigneMedical.setFacligNom(this.hospitalisationEntete.getPatients().getPatNom());
            this.factureLigneMedical.setFacligPrenom(this.hospitalisationEntete.getPatients().getPatPrenom());
            this.factureLigneMedical.setFacligNumHospitalisation(this.hospitalisationEntete.getHosNum());
            this.factureLigneMedical.setFacligService(this.hospitalisationActes.getHosactService());
            this.factureLigneMedical.setFacligNomAssure(this.hospitalisationEntete.getHosNomAssurePrincipal());
            this.factureLigneMedical.setFacligMatricule(this.hospitalisationEntete.getHosMatricule());
            this.factureLigneMedical.setFacligNumBc(this.hospitalisationEntete.getHosNumBc());
            this.factureLigneMedical.setFacligNumFeuille(this.hospitalisationEntete.getHosFeuille());
            this.factureLigneMedical.setFacligOrigine(4);
            this.factureLigneMedical.setFacligDossierAssure("");
            this.factureLigneMedical.setFacligMatriculeAssure("");
            if (this.factureLigneMedical.getFacligDossier() != null && !this.factureLigneMedical.getFacligDossier().isEmpty() && this.factureLigneMedical.getFacligDossier().contains("-") && this.hospitalisationEntete.getHosFam() > 0L) {
               this.patientPec = new PatientPec();
               this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 9, var3);
               if (this.patientPec != null) {
                  String[] var6 = this.factureLigneMedical.getFacligDossier().split("-");
                  this.factureLigneMedical.setFacligDossierAssure(var6[0]);
                  this.factureLigneMedical.setFacligMatriculeAssure(this.patientPec.getPatpecMatriculeCouvert());
               }
            }

            this.factureLigneMedical.setFacligIdHospitalisationActe(this.hospitalisationActes.getHosactId());
            this.factureLigneMedical.setFacligCode(this.hospitalisationActes.getHosactProduit());
            this.factureLigneMedical.setFacligLibelle(this.hospitalisationActes.getHosactLibelle());
            this.produits = this.produitsVtesDao.chargeProduit(this.factureLigneMedical.getFacligCode(), var3);
            if (this.produits != null) {
               this.factureLigneMedical.setFacligLibelleFamille(this.produits.getProVteLib());
            } else {
               this.factureLigneMedical.setFacligLibelleFamille("");
            }

            if (this.inpTiersPayeurs != 3 && this.inpTiersPayeurs != 53 && this.inpTiersPayeurs != 63) {
               if (this.hospitalisationEntete.getHosPecCnamgs() != 0.0F) {
                  this.factureLigneMedical.setFacligReference(this.hospitalisationActes.getHosactNbCnamgs() + " " + this.hospitalisationActes.getHosactLettre() + " " + this.hospitalisationActes.getHosactValeurCnamgs());
                  this.factureLigneMedical.setFacligPu(this.hospitalisationActes.getHosactPuCnamgs());
                  this.factureLigneMedical.setFacligPecCnamgs(this.hospitalisationEntete.getHosPecCnamgs());
               } else if (this.hospitalisationActes.getHosactLettre() != null && !this.hospitalisationActes.getHosactLettre().isEmpty()) {
                  this.factureLigneMedical.setFacligReference(this.hospitalisationActes.getHosactNb() + " " + this.hospitalisationActes.getHosactLettre() + " " + this.hospitalisationActes.getHosactValeur());
                  this.factureLigneMedical.setFacligPu(this.utilNombre.myRoundDevise(this.hospitalisationActes.getHosactAssuranceHt() / (double)this.hospitalisationActes.getHosactQte(), this.structureLog.getStrdevise()));
                  this.factureLigneMedical.setFacligPecCnamgs(0.0F);
               } else {
                  this.factureLigneMedical.setFacligPu(this.utilNombre.myRoundDevise(this.hospitalisationActes.getHosactAssuranceHt() / (double)this.hospitalisationActes.getHosactQte(), this.structureLog.getStrdevise()));
                  this.factureLigneMedical.setFacligPecCnamgs(0.0F);
               }
            } else {
               this.factureLigneMedical.setFacligPu(this.utilNombre.myRoundDevise(this.hospitalisationActes.getHosactComplementaireHt() / (double)this.hospitalisationActes.getHosactQte(), this.structureLog.getStrdevise()));
               this.factureLigneMedical.setFacligPecCnamgs(0.0F);
            }

            this.factureLigneMedical.setFacligTauxRemise(this.hospitalisationActes.getHosactRemise());
            this.factureLigneMedical.setFacligPuRem(this.hospitalisationActes.getHosactPuRem());
            this.factureLigneMedical.setFacligPt(this.hospitalisationActes.getHosactAssuranceHt() + this.hospitalisationActes.getHosactSocieteHt() + this.hospitalisationActes.getHosactComplementaireHt());
            this.factureLigneMedical.setFacligTauxTaxe(this.hospitalisationActes.getHosactTauxTva());
            this.factureLigneMedical.setFacligTaxe(this.hospitalisationActes.getHosactCodeTva());
            this.factureLigneMedical.setFacligTva(this.hospitalisationActes.getHosactAssuranceTaxe() + this.hospitalisationActes.getHosactSocieteTaxe() + this.hospitalisationActes.getHosactComplementaireTaxe());
            this.factureLigneMedical.setFacligTtc(this.factureLigneMedical.getFacligPt() + this.factureLigneMedical.getFacligTva());
            this.factureLigneMedical.setFacligTtcActe(this.hospitalisationActes.getHosactTotal());
            if (this.inpTiersPayeurs != 3 && this.inpTiersPayeurs != 53 && this.inpTiersPayeurs != 63) {
               if (this.hospitalisationEntete.getHosPecCnamgs() != 0.0F) {
                  this.factureLigneMedical.setFacligTotPatient(this.hospitalisationActes.getHosactTotal() + this.hospitalisationActes.getHosactTaxe() - (this.hospitalisationActes.getHosactAssuranceHt() + this.hospitalisationActes.getHosactAssuranceTaxe()));
               } else {
                  this.factureLigneMedical.setFacligTotPatient(this.hospitalisationActes.getHosactPatientHt() + this.hospitalisationActes.getHosactPatientTaxe());
               }
            } else {
               this.factureLigneMedical.setFacligTotPatient(this.hospitalisationActes.getHosactPatientHt() + this.hospitalisationActes.getHosactPatientTaxe());
            }

            this.factureLigneMedical.setFacligPuTtc(0.0D);
            this.factureLigneMedical.setFacligPuRemTtc(0.0D);
            this.factureLigneMedical.setFacligTc(0.0D);
            this.factureLigneMedical.setFacligRabais(0.0D);
            this.factureLigneMedical.setFacligQte(this.hospitalisationActes.getHosactQte());
            this.factureLigneMedical.setFacligOrdre(this.ordre);
            this.factureLigneMedical.setFactureEnteteMedical(this.factureEnteteMedical);
            if (this.factureLigneMedical.getFacligPt() != 0.0D) {
               this.factureLigneMedical = this.factureLigneMedicalDao.insertLigne(this.factureLigneMedical, var3);
            }
         }
      }

   }

   public void creationLigneHospitLaboFacture(long var1, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      List var4 = this.hospitalisationLaboDao.selectLaboByEnt(var1, var3);
      if (var4.size() != 0) {
         for(int var5 = 0; var5 < var4.size(); ++var5) {
            ++this.ordre;
            this.hospitalisationLabo = (HospitalisationLabo)var4.get(var5);
            this.hospitalisationEntete = this.hospitalisationLabo.getHospitalisationEntete();
            this.factureLigneMedical = new FactureLigneMedical();
            this.hospitalisationSejour = this.hospitalisationSejourDao.selectSejour(this.hospitalisationLabo.getHoslabIdSejour(), var3);
            if (this.hospitalisationSejour == null) {
               this.hospitalisationSejour = new HospitalisationSejour();
               this.hospitalisationSejour.setHossejDateEntree(this.hospitalisationEntete.getHosDateEntree());
               this.hospitalisationSejour.setHossejDateSortie(this.hospitalisationEntete.getHosDateSortie());
            }

            this.factureLigneMedical.setFacligCivilite(this.hospitalisationEntete.getHosCivilite());
            this.factureLigneMedical.setFacligDateVisite(this.hospitalisationSejour.getHossejDateEntree());
            this.factureLigneMedical.setFacligDateSortie(this.hospitalisationSejour.getHossejDateSortie());
            this.factureLigneMedical.setFacligDevise(this.structureLog.getStrdevise());
            this.factureLigneMedical.setFacligDossier(this.hospitalisationEntete.getPatients().getPatDossier());
            this.factureLigneMedical.setFacligFamille("" + this.hospitalisationEntete.getHosFam());
            this.factureLigneMedical.setFacligNom(this.hospitalisationEntete.getPatients().getPatNom());
            this.factureLigneMedical.setFacligPrenom(this.hospitalisationEntete.getPatients().getPatPrenom());
            this.factureLigneMedical.setFacligNumHospitalisation(this.hospitalisationEntete.getHosNum());
            this.factureLigneMedical.setFacligService(this.hospitalisationLabo.getHoslabLaboratoire());
            this.factureLigneMedical.setFacligNomAssure(this.hospitalisationEntete.getHosNomAssurePrincipal());
            this.factureLigneMedical.setFacligMatricule(this.hospitalisationEntete.getHosMatricule());
            this.factureLigneMedical.setFacligNumBc(this.hospitalisationEntete.getHosNumBc());
            this.factureLigneMedical.setFacligNumFeuille(this.hospitalisationEntete.getHosFeuille());
            this.factureLigneMedical.setFacligOrigine(5);
            this.factureLigneMedical.setFacligDossierAssure("");
            this.factureLigneMedical.setFacligMatriculeAssure("");
            if (this.factureLigneMedical.getFacligDossier() != null && !this.factureLigneMedical.getFacligDossier().isEmpty() && this.factureLigneMedical.getFacligDossier().contains("-") && this.hospitalisationEntete.getHosFam() > 0L) {
               this.patientPec = new PatientPec();
               this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 9, var3);
               if (this.patientPec != null) {
                  String[] var6 = this.factureLigneMedical.getFacligDossier().split("-");
                  this.factureLigneMedical.setFacligDossierAssure(var6[0]);
                  this.factureLigneMedical.setFacligMatriculeAssure(this.patientPec.getPatpecMatriculeCouvert());
               }
            }

            this.factureLigneMedical.setFacligIdHospitalisationLabo(this.hospitalisationLabo.getHoslabId());
            this.factureLigneMedical.setFacligCode(this.hospitalisationLabo.getHoslabProduit());
            this.factureLigneMedical.setFacligLibelle(this.hospitalisationLabo.getHoslabLibelle());
            this.produits = this.produitsVtesDao.chargeProduit(this.factureLigneMedical.getFacligCode(), var3);
            if (this.produits != null) {
               this.factureLigneMedical.setFacligLibelleFamille(this.produits.getProVteLib());
            } else {
               this.factureLigneMedical.setFacligLibelleFamille("");
            }

            if (this.inpTiersPayeurs != 3 && this.inpTiersPayeurs != 53 && this.inpTiersPayeurs != 63) {
               if (this.hospitalisationEntete.getHosPecCnamgs() != 0.0F) {
                  this.factureLigneMedical.setFacligReference(this.hospitalisationLabo.getHoslabNbCnamgs() + " " + this.hospitalisationLabo.getHoslabLettre() + " " + this.hospitalisationLabo.getHoslabValeurCnamgs());
                  this.factureLigneMedical.setFacligPu(this.hospitalisationLabo.getHoslabPuCnamgs());
                  this.factureLigneMedical.setFacligPecCnamgs(this.hospitalisationEntete.getHosPecCnamgs());
               } else if (this.hospitalisationLabo.getHoslabLettre() != null && !this.hospitalisationLabo.getHoslabLettre().isEmpty()) {
                  this.factureLigneMedical.setFacligReference(this.hospitalisationLabo.getHoslabNb() + " " + this.hospitalisationLabo.getHoslabLettre() + " " + this.hospitalisationLabo.getHoslabValeur());
                  this.factureLigneMedical.setFacligPu(this.utilNombre.myRoundDevise(this.hospitalisationLabo.getHoslabAssuranceHt() / (double)this.hospitalisationLabo.getHoslabQte(), this.structureLog.getStrdevise()));
                  this.factureLigneMedical.setFacligPecCnamgs(0.0F);
               } else {
                  this.factureLigneMedical.setFacligPu(this.utilNombre.myRoundDevise(this.hospitalisationLabo.getHoslabAssuranceHt() / (double)this.hospitalisationLabo.getHoslabQte(), this.structureLog.getStrdevise()));
                  this.factureLigneMedical.setFacligPecCnamgs(0.0F);
               }
            } else {
               this.factureLigneMedical.setFacligPu(this.utilNombre.myRoundDevise(this.hospitalisationLabo.getHoslabComplementaireHt() / (double)this.hospitalisationLabo.getHoslabQte(), this.structureLog.getStrdevise()));
               this.factureLigneMedical.setFacligPecCnamgs(0.0F);
            }

            this.factureLigneMedical.setFacligTauxRemise(this.hospitalisationLabo.getHoslabRemise());
            this.factureLigneMedical.setFacligPuRem(this.hospitalisationLabo.getHoslabPuRem());
            this.factureLigneMedical.setFacligPt(this.hospitalisationLabo.getHoslabAssuranceHt() + this.hospitalisationLabo.getHoslabSocieteHt() + this.hospitalisationLabo.getHoslabComplementaireHt());
            this.factureLigneMedical.setFacligTauxTaxe(this.hospitalisationLabo.getHoslabTauxTva());
            this.factureLigneMedical.setFacligTaxe(this.hospitalisationLabo.getHoslabCodeTva());
            this.factureLigneMedical.setFacligTva(this.hospitalisationLabo.getHoslabAssuranceTaxe() + this.hospitalisationLabo.getHoslabSocieteTaxe() + this.hospitalisationLabo.getHoslabComplementaireTaxe());
            this.factureLigneMedical.setFacligTtc(this.factureLigneMedical.getFacligPt() + this.factureLigneMedical.getFacligTva());
            this.factureLigneMedical.setFacligTtcActe(this.hospitalisationLabo.getHoslabTotal());
            if (this.inpTiersPayeurs != 3 && this.inpTiersPayeurs != 53 && this.inpTiersPayeurs != 63) {
               if (this.hospitalisationEntete.getHosPecCnamgs() != 0.0F) {
                  this.factureLigneMedical.setFacligTotPatient(this.hospitalisationLabo.getHoslabTotal() + this.hospitalisationLabo.getHoslabTaxe() - (this.hospitalisationLabo.getHoslabAssuranceHt() + this.hospitalisationLabo.getHoslabAssuranceTaxe()));
               } else {
                  this.factureLigneMedical.setFacligTotPatient(this.hospitalisationLabo.getHoslabPatientHt() + this.hospitalisationLabo.getHoslabPatientTaxe());
               }
            } else {
               this.factureLigneMedical.setFacligTotPatient(this.hospitalisationLabo.getHoslabPatientHt() + this.hospitalisationLabo.getHoslabPatientTaxe());
            }

            this.factureLigneMedical.setFacligPuTtc(0.0D);
            this.factureLigneMedical.setFacligPuRemTtc(0.0D);
            this.factureLigneMedical.setFacligTc(0.0D);
            this.factureLigneMedical.setFacligRabais(0.0D);
            this.factureLigneMedical.setFacligQte(this.hospitalisationLabo.getHoslabQte());
            this.factureLigneMedical.setFacligOrdre(this.ordre);
            this.factureLigneMedical.setFactureEnteteMedical(this.factureEnteteMedical);
            if (this.factureLigneMedical.getFacligPt() != 0.0D) {
               this.factureLigneMedical = this.factureLigneMedicalDao.insertLigne(this.factureLigneMedical, var3);
            }
         }
      }

   }

   public void creationLigneHospitMedicFacture(long var1, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      List var4 = this.hospitalisationMediDao.selectMediByEnt(var1, var3);
      if (var4.size() != 0) {
         for(int var5 = 0; var5 < var4.size(); ++var5) {
            ++this.ordre;
            this.hospitalisationMedi = (HospitalisationMedi)var4.get(var5);
            this.hospitalisationEntete = this.hospitalisationMedi.getHospitalisationEntete();
            this.factureLigneMedical = new FactureLigneMedical();
            this.hospitalisationSejour = this.hospitalisationSejourDao.selectSejour(this.hospitalisationMedi.getHosmedIdSejour(), var3);
            if (this.hospitalisationSejour == null) {
               this.hospitalisationSejour = new HospitalisationSejour();
               this.hospitalisationSejour.setHossejDateEntree(this.hospitalisationEntete.getHosDateEntree());
               this.hospitalisationSejour.setHossejDateSortie(this.hospitalisationEntete.getHosDateSortie());
            }

            this.factureLigneMedical.setFacligCivilite(this.hospitalisationEntete.getHosCivilite());
            this.factureLigneMedical.setFacligDateVisite(this.hospitalisationSejour.getHossejDateEntree());
            this.factureLigneMedical.setFacligDateSortie(this.hospitalisationSejour.getHossejDateSortie());
            this.factureLigneMedical.setFacligDevise(this.structureLog.getStrdevise());
            this.factureLigneMedical.setFacligDossier(this.hospitalisationEntete.getPatients().getPatDossier());
            this.factureLigneMedical.setFacligFamille("" + this.hospitalisationEntete.getHosFam());
            this.factureLigneMedical.setFacligNom(this.hospitalisationEntete.getPatients().getPatNom());
            this.factureLigneMedical.setFacligPrenom(this.hospitalisationEntete.getPatients().getPatPrenom());
            this.factureLigneMedical.setFacligNumHospitalisation(this.hospitalisationEntete.getHosNum());
            this.factureLigneMedical.setFacligService(this.hospitalisationMedi.getHosmedService());
            this.factureLigneMedical.setFacligNomAssure(this.hospitalisationEntete.getHosNomAssurePrincipal());
            this.factureLigneMedical.setFacligMatricule(this.hospitalisationEntete.getHosMatricule());
            this.factureLigneMedical.setFacligNumBc(this.hospitalisationEntete.getHosNumBc());
            this.factureLigneMedical.setFacligNumFeuille(this.hospitalisationEntete.getHosFeuille());
            this.factureLigneMedical.setFacligOrigine(6);
            this.factureLigneMedical.setFacligDossierAssure("");
            this.factureLigneMedical.setFacligMatriculeAssure("");
            if (this.factureLigneMedical.getFacligDossier() != null && !this.factureLigneMedical.getFacligDossier().isEmpty() && this.factureLigneMedical.getFacligDossier().contains("-") && this.hospitalisationEntete.getHosFam() > 0L) {
               this.patientPec = new PatientPec();
               this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 9, var3);
               if (this.patientPec != null) {
                  String[] var6 = this.factureLigneMedical.getFacligDossier().split("-");
                  this.factureLigneMedical.setFacligDossierAssure(var6[0]);
                  this.factureLigneMedical.setFacligMatriculeAssure(this.patientPec.getPatpecMatriculeCouvert());
               }
            }

            this.factureLigneMedical.setFacligIdHospitalisationMedic(this.hospitalisationMedi.getHosmedId());
            this.factureLigneMedical.setFacligCode(this.hospitalisationMedi.getHosmedProduit());
            this.factureLigneMedical.setFacligLibelle(this.hospitalisationMedi.getHosmedLibelle());
            this.produits = this.produitsVtesDao.chargeProduit(this.factureLigneMedical.getFacligCode(), var3);
            if (this.produits != null) {
               this.factureLigneMedical.setFacligLibelleFamille(this.produits.getProVteLib());
            } else {
               this.factureLigneMedical.setFacligLibelleFamille("");
            }

            if (this.inpTiersPayeurs != 3 && this.inpTiersPayeurs != 53 && this.inpTiersPayeurs != 63) {
               if (this.hospitalisationEntete.getHosPecCnamgs() != 0.0F) {
                  this.factureLigneMedical.setFacligReference("");
                  this.factureLigneMedical.setFacligPu(this.hospitalisationMedi.getHosmedPuCnamgs());
                  this.factureLigneMedical.setFacligPecCnamgs(this.hospitalisationEntete.getHosPecCnamgs());
               } else {
                  this.factureLigneMedical.setFacligPu(this.utilNombre.myRoundDevise(this.hospitalisationMedi.getHosmedAssuranceHt() / (double)this.hospitalisationMedi.getHosmedQte(), this.structureLog.getStrdevise()));
                  this.factureLigneMedical.setFacligPecCnamgs(0.0F);
               }
            } else {
               this.factureLigneMedical.setFacligPu(this.utilNombre.myRoundDevise(this.hospitalisationMedi.getHosmedComplementaireHt() / (double)this.hospitalisationMedi.getHosmedQte(), this.structureLog.getStrdevise()));
               this.factureLigneMedical.setFacligPecCnamgs(0.0F);
            }

            this.factureLigneMedical.setFacligTauxRemise(this.hospitalisationMedi.getHosmedRemise());
            this.factureLigneMedical.setFacligPuRem(this.hospitalisationMedi.getHosmedPuRem());
            this.factureLigneMedical.setFacligPt(this.hospitalisationMedi.getHosmedAssuranceHt() + this.hospitalisationMedi.getHosmedSocieteHt() + this.hospitalisationMedi.getHosmedComplementaireHt());
            this.factureLigneMedical.setFacligTauxTaxe(this.hospitalisationMedi.getHosmedTauxTva());
            this.factureLigneMedical.setFacligTaxe(this.hospitalisationMedi.getHosmedCodeTva());
            this.factureLigneMedical.setFacligTva(this.hospitalisationMedi.getHosmedAssuranceTaxe() + this.hospitalisationMedi.getHosmedSocieteTaxe() + this.hospitalisationMedi.getHosmedComplementaireTaxe());
            this.factureLigneMedical.setFacligTtc(this.factureLigneMedical.getFacligPt() + this.factureLigneMedical.getFacligTva());
            this.factureLigneMedical.setFacligTtcActe(this.hospitalisationMedi.getHosmedTotal());
            if (this.inpTiersPayeurs != 3 && this.inpTiersPayeurs != 53 && this.inpTiersPayeurs != 63) {
               if (this.hospitalisationEntete.getHosPecCnamgs() != 0.0F) {
                  this.factureLigneMedical.setFacligTotPatient(this.hospitalisationMedi.getHosmedTotal() + this.hospitalisationMedi.getHosmedTaxe() - (this.hospitalisationMedi.getHosmedAssuranceHt() + this.hospitalisationMedi.getHosmedAssuranceTaxe()));
               } else {
                  this.factureLigneMedical.setFacligTotPatient(this.hospitalisationMedi.getHosmedPatientHt() + this.hospitalisationMedi.getHosmedPatientTaxe());
               }
            } else {
               this.factureLigneMedical.setFacligTotPatient(this.hospitalisationMedi.getHosmedPatientHt() + this.hospitalisationMedi.getHosmedPatientTaxe());
            }

            this.factureLigneMedical.setFacligPuTtc(0.0D);
            this.factureLigneMedical.setFacligPuRemTtc(0.0D);
            this.factureLigneMedical.setFacligTc(0.0D);
            this.factureLigneMedical.setFacligRabais(0.0D);
            this.factureLigneMedical.setFacligQte(this.hospitalisationMedi.getHosmedQte());
            this.factureLigneMedical.setFacligOrdre(this.ordre);
            this.factureLigneMedical.setFactureEnteteMedical(this.factureEnteteMedical);
            if (this.factureLigneMedical.getFacligPt() != 0.0D) {
               this.factureLigneMedical = this.factureLigneMedicalDao.insertLigne(this.factureLigneMedical, var3);
            }
         }
      }

   }

   public void creationLigneHospitPrestFacture(long var1, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      List var4 = this.hospitalisationPrestDao.selectPrestByEnt(var1, var3);
      if (var4.size() != 0) {
         for(int var5 = 0; var5 < var4.size(); ++var5) {
            ++this.ordre;
            this.hospitalisationPrest = (HospitalisationPrest)var4.get(var5);
            this.hospitalisationEntete = this.hospitalisationPrest.getHospitalisationEntete();
            this.factureLigneMedical = new FactureLigneMedical();
            this.hospitalisationSejour = this.hospitalisationSejourDao.selectSejour(this.hospitalisationPrest.getHosprtIdSejour(), var3);
            if (this.hospitalisationSejour == null) {
               this.hospitalisationSejour = new HospitalisationSejour();
               this.hospitalisationSejour.setHossejDateEntree(this.hospitalisationEntete.getHosDateEntree());
               this.hospitalisationSejour.setHossejDateSortie(this.hospitalisationEntete.getHosDateSortie());
            }

            this.factureLigneMedical.setFacligCivilite(this.hospitalisationEntete.getHosCivilite());
            this.factureLigneMedical.setFacligDateVisite(this.hospitalisationSejour.getHossejDateEntree());
            this.factureLigneMedical.setFacligDateSortie(this.hospitalisationSejour.getHossejDateSortie());
            this.factureLigneMedical.setFacligDevise(this.structureLog.getStrdevise());
            this.factureLigneMedical.setFacligDossier(this.hospitalisationEntete.getPatients().getPatDossier());
            this.factureLigneMedical.setFacligFamille("" + this.hospitalisationEntete.getHosFam());
            this.factureLigneMedical.setFacligNom(this.hospitalisationEntete.getPatients().getPatNom());
            this.factureLigneMedical.setFacligPrenom(this.hospitalisationEntete.getPatients().getPatPrenom());
            this.factureLigneMedical.setFacligNumHospitalisation(this.hospitalisationEntete.getHosNum());
            this.factureLigneMedical.setFacligService(this.hospitalisationPrest.getHosprtService());
            this.factureLigneMedical.setFacligNomAssure(this.hospitalisationEntete.getHosNomAssurePrincipal());
            this.factureLigneMedical.setFacligMatricule(this.hospitalisationEntete.getHosMatricule());
            this.factureLigneMedical.setFacligNumBc(this.hospitalisationEntete.getHosNumBc());
            this.factureLigneMedical.setFacligNumFeuille(this.hospitalisationEntete.getHosFeuille());
            this.factureLigneMedical.setFacligOrigine(7);
            this.factureLigneMedical.setFacligDossierAssure("");
            this.factureLigneMedical.setFacligMatriculeAssure("");
            if (this.factureLigneMedical.getFacligDossier() != null && !this.factureLigneMedical.getFacligDossier().isEmpty() && this.factureLigneMedical.getFacligDossier().contains("-") && this.hospitalisationEntete.getHosFam() > 0L) {
               this.patientPec = new PatientPec();
               this.patientPec = this.patientPecDao.trouverPatientsPec(this.hospitalisationEntete.getHosFam(), 9, var3);
               if (this.patientPec != null) {
                  String[] var6 = this.factureLigneMedical.getFacligDossier().split("-");
                  this.factureLigneMedical.setFacligDossierAssure(var6[0]);
                  this.factureLigneMedical.setFacligMatriculeAssure(this.patientPec.getPatpecMatriculeCouvert());
               }
            }

            this.factureLigneMedical.setFacligIdHospitalisationPrest(this.hospitalisationPrest.getHosprtId());
            this.factureLigneMedical.setFacligCode(this.hospitalisationPrest.getHosprtProduit());
            this.factureLigneMedical.setFacligLibelle(this.hospitalisationPrest.getHosprtLibelle());
            this.produits = this.produitsVtesDao.chargeProduit(this.factureLigneMedical.getFacligCode(), var3);
            if (this.produits != null) {
               this.factureLigneMedical.setFacligLibelleFamille(this.produits.getProVteLib());
            } else {
               this.factureLigneMedical.setFacligLibelleFamille("");
            }

            if (this.inpTiersPayeurs != 3 && this.inpTiersPayeurs != 53 && this.inpTiersPayeurs != 63) {
               if (this.hospitalisationEntete.getHosPecCnamgs() != 0.0F) {
                  this.factureLigneMedical.setFacligReference("");
                  this.factureLigneMedical.setFacligPu(this.hospitalisationPrest.getHosprtPuCnamgs());
                  this.factureLigneMedical.setFacligPecCnamgs(this.hospitalisationEntete.getHosPecCnamgs());
               } else {
                  this.factureLigneMedical.setFacligPu(this.utilNombre.myRoundDevise(this.hospitalisationPrest.getHosprtAssuranceHt() / (double)this.hospitalisationPrest.getHosprtQte(), this.structureLog.getStrdevise()));
                  this.factureLigneMedical.setFacligPecCnamgs(0.0F);
               }
            } else {
               this.factureLigneMedical.setFacligPu(this.utilNombre.myRoundDevise(this.hospitalisationPrest.getHosprtComplementaireHt() / (double)this.hospitalisationPrest.getHosprtQte(), this.structureLog.getStrdevise()));
               this.factureLigneMedical.setFacligPecCnamgs(0.0F);
            }

            this.factureLigneMedical.setFacligTauxRemise(this.hospitalisationPrest.getHosprtRemise());
            this.factureLigneMedical.setFacligPuRem(this.hospitalisationPrest.getHosprtPuRem());
            this.factureLigneMedical.setFacligPt(this.hospitalisationPrest.getHosprtAssuranceHt() + this.hospitalisationPrest.getHosprtSocieteHt() + this.hospitalisationPrest.getHosprtComplementaireHt());
            this.factureLigneMedical.setFacligTauxTaxe(this.hospitalisationPrest.getHosprtTauxTva());
            this.factureLigneMedical.setFacligTaxe(this.hospitalisationPrest.getHosprtCodeTva());
            this.factureLigneMedical.setFacligTva(this.hospitalisationPrest.getHosprtAssuranceTaxe() + this.hospitalisationPrest.getHosprtSocieteTaxe() + this.hospitalisationPrest.getHosprtComplementaireTaxe());
            this.factureLigneMedical.setFacligTtc(this.factureLigneMedical.getFacligPt() + this.factureLigneMedical.getFacligTva());
            this.factureLigneMedical.setFacligTtcActe(this.hospitalisationPrest.getHosprtTotal());
            if (this.inpTiersPayeurs != 3 && this.inpTiersPayeurs != 53 && this.inpTiersPayeurs != 63) {
               if (this.hospitalisationEntete.getHosPecCnamgs() != 0.0F) {
                  this.factureLigneMedical.setFacligTotPatient(this.hospitalisationPrest.getHosprtTotal() + this.hospitalisationPrest.getHosprtTaxe() - (this.hospitalisationPrest.getHosprtAssuranceHt() + this.hospitalisationPrest.getHosprtAssuranceTaxe()));
               } else {
                  this.factureLigneMedical.setFacligTotPatient(this.hospitalisationPrest.getHosprtPatientHt() + this.hospitalisationPrest.getHosprtPatientTaxe());
               }
            } else {
               this.factureLigneMedical.setFacligTotPatient(this.hospitalisationPrest.getHosprtPatientHt() + this.hospitalisationPrest.getHosprtPatientTaxe());
            }

            this.factureLigneMedical.setFacligPuTtc(0.0D);
            this.factureLigneMedical.setFacligPuRemTtc(0.0D);
            this.factureLigneMedical.setFacligTc(0.0D);
            this.factureLigneMedical.setFacligRabais(0.0D);
            this.factureLigneMedical.setFacligQte(this.hospitalisationPrest.getHosprtQte());
            this.factureLigneMedical.setFacligOrdre(this.ordre);
            this.factureLigneMedical.setFactureEnteteMedical(this.factureEnteteMedical);
            if (this.factureLigneMedical.getFacligPt() != 0.0D) {
               this.factureLigneMedical = this.factureLigneMedicalDao.insertLigne(this.factureLigneMedical, var3);
            }
         }
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.factureEnteteMedical != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.validationDocumentsuite(this.factureEnteteMedical, 1, var1);
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

   public void validationDocumentsuite(FactureEnteteMedical var1, int var2, Session var3) throws HibernateException, NamingException {
      if (var1.getFacEtat() == 0 && this.habilitation == null) {
         var1.setFacEtat(1);
         var1 = this.factureEnteteMedicalDao.modif(var1, var3);
         this.lesLignesList = this.factureLigneMedicalDao.chargerLesLignes(var1, var3);
         Espion var4 = new Espion();
         var4.setUsers(this.usersLog);
         var4.setEsptype(0);
         var4.setEspdtecreat(new Date());
         var4.setEspaction("Validation manuelle facture (M.) N° " + var1.getFacNum() + " du " + this.utilDate.dateToStringSQLLight(var1.getFacDate()));
         this.espionDao.mAJEspion(var4, var3);
         if (this.tiers.getTieDteDocument5() == null || var1.getFacDate().after(this.tiers.getTieDteDocument5())) {
            this.tiers.setTieDteDocument5(var1.getFacDate());
            this.tiers = this.tiersDao.modif(this.tiers, var3);
         }

         this.flagElements(var2, var3);
      }

   }

   public void deValideDocument() throws HibernateException, NamingException {
      if (this.factureEnteteMedical != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.factureEnteteMedical.getFacEtat() == 1) {
               this.factureEnteteMedical.setFacEtat(0);
               this.factureEnteteMedical.setFacDateImp((Date)null);
               this.factureEnteteMedical = this.factureEnteteMedicalDao.modif(this.factureEnteteMedical, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dévalidation manuelle facture (M.) N° " + this.factureEnteteMedical.getFacNum() + " du " + this.utilDate.dateToStringSQLLight(this.factureEnteteMedical.getFacDate()));
               this.espionDao.mAJEspion(var3, var1);
               this.tiers = this.factureEnteteMedical.getTiers();
               this.deFlagElements(var1);
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

   public void flagElements(int var1, Session var2) throws HibernateException, NamingException {
      if (this.lesLignesList.size() != 0) {
         this.consultationEnteteGene = new ConsultationEnteteGene();
         this.pharmacieEntete = new PharmacieEntete();
         this.laboratoireEntete = new LaboratoireEntete();
         this.hospitalisationEntete = new HospitalisationEntete();

         for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
            this.factureLigneMedical = (FactureLigneMedical)this.lesLignesList.get(var3);
            if (this.factureLigneMedical.getFacligNumConsultation() != null && !this.factureLigneMedical.getFacligNumConsultation().isEmpty()) {
               this.consultationEnteteGene = this.consultationEnteteGeneDao.selectByNum(this.factureLigneMedical.getFacligNumConsultation(), (String)null, var2);
               if (this.consultationEnteteGene != null) {
                  if (var1 != 3 && this.consultationEnteteGene.getCsgEtat() != 6) {
                     this.consultationEnteteGene.setCsgEtat(6);
                  } else {
                     this.consultationEnteteGene.setCsgEtat(7);
                  }

                  this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var2);
               }
            } else if (this.factureLigneMedical.getFacligNumPharmacie() != null && !this.factureLigneMedical.getFacligNumPharmacie().isEmpty()) {
               this.pharmacieEntete = this.pharmacieEnteteDao.selectByNum(this.factureLigneMedical.getFacligNumPharmacie(), (String)null, var2);
               if (this.pharmacieEntete != null) {
                  if (var1 != 3 && this.pharmacieEntete.getPhaEtat() != 6) {
                     this.pharmacieEntete.setPhaEtat(6);
                  } else {
                     this.pharmacieEntete.setPhaEtat(7);
                  }

                  this.pharmacieEnteteDao.modif(this.pharmacieEntete, var2);
               }
            } else if (this.factureLigneMedical.getFacligNumLaboratoire() != null && !this.factureLigneMedical.getFacligNumLaboratoire().isEmpty()) {
               this.laboratoireEntete = this.laboratoireEnteteDao.selectByNum(this.factureLigneMedical.getFacligNumLaboratoire(), (String)null, var2);
               if (this.laboratoireEntete != null) {
                  if (var1 != 3 && this.laboratoireEntete.getLabEtat() != 6) {
                     this.laboratoireEntete.setLabEtat(6);
                  } else {
                     this.laboratoireEntete.setLabEtat(7);
                  }

                  this.laboratoireEnteteDao.modif(this.laboratoireEntete, var2);
               }
            } else if (this.factureLigneMedical.getFacligNumHospitalisation() != null && !this.factureLigneMedical.getFacligNumHospitalisation().isEmpty()) {
               this.hospitalisationEntete = this.hospitalisationEnteteDao.selectByNum(this.factureLigneMedical.getFacligNumHospitalisation(), (String)null, var2);
               if (this.hospitalisationEntete != null) {
                  if (var1 != 3 && this.hospitalisationEntete.getHosEtat() != 6) {
                     this.hospitalisationEntete.setHosEtat(6);
                  } else {
                     this.hospitalisationEntete.setHosEtat(7);
                  }

                  this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var2);
               }
            }
         }
      }

   }

   public void deFlagElements(Session var1) throws HibernateException, NamingException {
      if (this.lesLignesList.size() != 0) {
         this.consultationEnteteGene = new ConsultationEnteteGene();
         this.pharmacieEntete = new PharmacieEntete();
         this.laboratoireEntete = new LaboratoireEntete();
         this.hospitalisationEntete = new HospitalisationEntete();

         for(int var2 = 0; var2 < this.lesLignesList.size(); ++var2) {
            this.factureLigneMedical = (FactureLigneMedical)this.lesLignesList.get(var2);
            if (this.factureLigneMedical.getFacligNumConsultation() != null && !this.factureLigneMedical.getFacligNumConsultation().isEmpty()) {
               this.consultationEnteteGene = this.consultationEnteteGeneDao.selectByNum(this.factureLigneMedical.getFacligNumConsultation(), (String)null, var1);
               if (this.consultationEnteteGene != null) {
                  if (this.consultationEnteteGene.getCsgEtat() == 7) {
                     this.consultationEnteteGene.setCsgEtat(6);
                  } else {
                     this.consultationEnteteGene.setCsgEtat(5);
                  }

                  this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
               }
            } else if (this.factureLigneMedical.getFacligNumPharmacie() != null && !this.factureLigneMedical.getFacligNumPharmacie().isEmpty()) {
               this.pharmacieEntete = this.pharmacieEnteteDao.selectByNum(this.factureLigneMedical.getFacligNumPharmacie(), (String)null, var1);
               if (this.pharmacieEntete != null) {
                  if (this.pharmacieEntete.getPhaEtat() == 7) {
                     this.pharmacieEntete.setPhaEtat(6);
                  } else {
                     this.pharmacieEntete.setPhaEtat(5);
                  }

                  this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
               }
            } else if (this.factureLigneMedical.getFacligNumLaboratoire() != null && !this.factureLigneMedical.getFacligNumLaboratoire().isEmpty()) {
               this.laboratoireEntete = this.laboratoireEnteteDao.selectByNum(this.factureLigneMedical.getFacligNumLaboratoire(), (String)null, var1);
               if (this.laboratoireEntete != null) {
                  if (this.laboratoireEntete.getLabEtat() == 7) {
                     this.laboratoireEntete.setLabEtat(6);
                  } else {
                     this.laboratoireEntete.setLabEtat(5);
                  }

                  this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
               }
            } else if (this.factureLigneMedical.getFacligNumHospitalisation() != null && !this.factureLigneMedical.getFacligNumHospitalisation().isEmpty()) {
               this.hospitalisationEntete = this.hospitalisationEnteteDao.selectByNum(this.factureLigneMedical.getFacligNumHospitalisation(), (String)null, var1);
               if (this.hospitalisationEntete != null) {
                  if (this.hospitalisationEntete.getHosEtat() == 7) {
                     this.hospitalisationEntete.setHosEtat(6);
                  } else {
                     this.hospitalisationEntete.setHosEtat(5);
                  }

                  this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
               }
            }
         }
      }

   }

   public void modifDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.factureEnteteMedical != null) {
         this.var_action = 2;
         this.var_aff_action = false;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
      }

   }

   public void consultDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.factureEnteteMedical != null) {
         this.var_action = 2;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
      }

   }

   public void reactiverDocument() throws HibernateException, NamingException {
      if (this.factureEnteteMedical != null) {
         this.factureEnteteMedical.setFacEtat(0);
         this.factureEnteteMedical.setFacDateAnnule((Date)null);
         this.factureEnteteMedical.setFacMotifAnnule("");
         this.factureEnteteMedical = this.factureEnteteMedicalDao.modif(this.factureEnteteMedical);
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException {
      if (this.factureEnteteMedical != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.lesEntetesList.remove(this.factureEnteteMedical);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.supprimerDocument(var1);
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

      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void supprimerDocument(Session var1) throws HibernateException, NamingException {
      String var2 = this.factureEnteteMedical.getFacNum();
      Date var3 = this.factureEnteteMedical.getFacDate();
      this.deFlagElements(var1);
      this.factureLigneMedicalDao.deleteAllLigne(this.factureEnteteMedical, var1);
      this.utilParapheur.supprimerParapheur(this.factureEnteteMedical.getFacId(), this.nature, var1);
      this.factureEnteteMedicalDao.delete(this.factureEnteteMedical.getFacId(), var1);
      Espion var4 = new Espion();
      var4.setUsers(this.usersLog);
      var4.setEsptype(0);
      var4.setEspdtecreat(new Date());
      var4.setEspaction("Suppression reFacture N° " + var2 + " du " + var3);
      this.espionDao.mAJEspion(var4, var1);
      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Refacturation");
         this.documentTrfItems.clear();
         boolean var2 = false;
         boolean var3 = false;
         var2 = this.usersChronoDao.existByUserNat(this.usersLog, 26, var1);
         if (var2) {
            this.documentTrfItems.add(new SelectItem(26, "Avoir"));
         }

         new FactureEnteteMedical();

         for(int var5 = 0; var5 < this.lesEntetesList.size(); ++var5) {
            FactureEnteteMedical var4 = (FactureEnteteMedical)this.lesEntetesList.get(var5);
            if (var4.getFacId() > 0L && var4.isVar_select_ligne()) {
               this.showModalPanelTrf = true;
               this.lesLignesList = this.factureLigneMedicalDao.chargerLesLignes(var4, var1);
               if (this.lesLignesList.size() != 0) {
                  for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                     new FactureLigneMedical();
                     FactureLigneMedical var7 = (FactureLigneMedical)this.lesLignesList.get(var6);
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

   public void imputationReglement() throws HibernateException, NamingException {
      if (this.lesEntetesList.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesEntetesList.size(); ++var3) {
               this.factureEnteteMedical = (FactureEnteteMedical)this.lesEntetesList.get(var3);
               if (this.factureEnteteMedical.getFacTotReglement() != 0.0D) {
                  double var4 = this.factureEnteteMedical.getFacTotReglement();
                  this.lesLignesList = this.factureLigneMedicalDao.chargerLesLignes(this.factureEnteteMedical, var1);
                  if (this.lesLignesList.size() != 0) {
                     for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                        this.factureLigneMedical = (FactureLigneMedical)this.lesLignesList.get(var6);
                        if (this.factureLigneMedical.getFacligIdConsultation() != 0L) {
                           if (this.optionMedical.getModeRefacturation().equals("0")) {
                              this.consultationActes = this.consultationActesDao.selectConsActes(this.factureLigneMedical.getFacligIdConsultation(), var1);
                              if (this.consultationActes != null) {
                                 this.consultationEnteteGene = this.consultationEnteteGeneDao.selectById(this.consultationActes.getConsultationEnteteGene().getCsgId(), var1);
                              }
                           } else {
                              this.consultationEnteteGene = this.consultationEnteteGeneDao.selectById(this.factureLigneMedical.getFacligIdConsultation(), var1);
                           }

                           if (this.consultationEnteteGene != null && var4 > 0.0D) {
                              if (var4 >= this.consultationEnteteGene.getTotalTiers()) {
                                 this.consultationEnteteGene.setCsgRegTiers(this.consultationEnteteGene.getTotalTiers());
                                 this.consultationEnteteGene.setCsgSoldeTiers(1);
                              } else {
                                 this.consultationEnteteGene.setCsgRegTiers(var4);
                                 this.consultationEnteteGene.setCsgSoldeTiers(0);
                              }

                              this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
                              var4 -= this.consultationEnteteGene.getCsgRegTiers();
                           }
                        } else if (this.factureLigneMedical.getFacligIdPharmacie() != 0L) {
                           if (this.optionMedical.getModeRefacturation().equals("0")) {
                              this.pharmacieLigne = this.pharmacieLigneDao.selectConsActes(this.factureLigneMedical.getFacligIdPharmacie(), var1);
                              if (this.pharmacieLigne != null) {
                                 this.pharmacieEntete = this.pharmacieEnteteDao.selectById(this.pharmacieLigne.getPharmacieEntete().getPhaId(), var1);
                              }
                           } else {
                              this.pharmacieEntete = this.pharmacieEnteteDao.selectById(this.factureLigneMedical.getFacligIdPharmacie(), var1);
                           }

                           if (this.pharmacieEntete != null && var4 > 0.0D) {
                              if (var4 >= this.pharmacieEntete.getTotalTiers()) {
                                 this.pharmacieEntete.setPhaRegTiers(this.pharmacieEntete.getTotalTiers());
                                 this.pharmacieEntete.setPhaSoldeTiers(1);
                              } else {
                                 this.pharmacieEntete.setPhaRegTiers(var4);
                                 this.pharmacieEntete.setPhaSoldeTiers(0);
                              }

                              this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
                              var4 -= this.pharmacieEntete.getPhaRegTiers();
                           }
                        } else if (this.factureLigneMedical.getFacligIdLaboratoire() != 0L) {
                           if (this.optionMedical.getModeRefacturation().equals("0")) {
                              this.laboratoireLigne = this.laboratoireLigneDao.selectConsActes(this.factureLigneMedical.getFacligIdLaboratoire(), var1);
                              if (this.laboratoireLigne != null) {
                                 this.laboratoireEntete = this.laboratoireEnteteDao.selectById(this.laboratoireLigne.getLaboratoireEntete().getLabId(), var1);
                              }
                           } else {
                              this.laboratoireEntete = this.laboratoireEnteteDao.selectById(this.factureLigneMedical.getFacligIdLaboratoire(), var1);
                           }

                           if (this.laboratoireEntete != null && var4 > 0.0D) {
                              if (var4 >= this.laboratoireEntete.getTotalTiers()) {
                                 this.laboratoireEntete.setLabRegTiers(this.laboratoireEntete.getTotalTiers());
                                 this.laboratoireEntete.setLabSoldeTiers(1);
                              } else {
                                 this.laboratoireEntete.setLabRegTiers(var4);
                                 this.laboratoireEntete.setLabSoldeTiers(0);
                              }

                              this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
                              var4 -= this.laboratoireEntete.getLabRegTiers();
                           }
                        } else if (this.factureLigneMedical.getFacligIdHospitalisationSejour() != 0L) {
                           if (this.optionMedical.getModeRefacturation().equals("0")) {
                              this.hospitalisationSejour = this.hospitalisationSejourDao.selectSejour(this.factureLigneMedical.getFacligIdHospitalisationSejour(), var1);
                              if (this.hospitalisationSejour != null) {
                                 this.hospitalisationEntete = this.hospitalisationEnteteDao.selectById(this.hospitalisationSejour.getHospitalisationEntete().getHosId(), var1);
                              }
                           } else {
                              this.hospitalisationEntete = this.hospitalisationEnteteDao.selectById(this.factureLigneMedical.getFacligIdHospitalisationSejour(), var1);
                           }

                           if (this.hospitalisationEntete != null && var4 > 0.0D) {
                              if (var4 >= this.hospitalisationEntete.getTotalTiers()) {
                                 this.hospitalisationEntete.setHosRegTiers(this.hospitalisationEntete.getTotalTiers());
                                 this.hospitalisationEntete.setHosSoldeTiers(1);
                              } else {
                                 this.hospitalisationEntete.setHosRegTiers(var4);
                                 this.hospitalisationEntete.setHosSoldeTiers(0);
                              }

                              this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
                              var4 -= this.hospitalisationEntete.getHosRegTiers();
                           }
                        } else if (this.factureLigneMedical.getFacligIdHospitalisationActe() != 0L) {
                           this.hospitalisationActes = this.hospitalisationActesDao.selectHospitActes(this.factureLigneMedical.getFacligIdHospitalisationActe(), var1);
                           if (this.hospitalisationActes != null) {
                              this.hospitalisationEntete = this.hospitalisationEnteteDao.selectById(this.hospitalisationActes.getHospitalisationEntete().getHosId(), var1);
                              if (this.hospitalisationEntete != null && var4 > 0.0D) {
                                 if (var4 >= this.hospitalisationEntete.getTotalTiers()) {
                                    this.hospitalisationEntete.setHosRegTiers(this.hospitalisationEntete.getTotalTiers());
                                    this.hospitalisationEntete.setHosSoldeTiers(1);
                                 } else {
                                    this.hospitalisationEntete.setHosRegTiers(var4);
                                    this.hospitalisationEntete.setHosSoldeTiers(0);
                                 }

                                 this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
                                 var4 -= this.hospitalisationEntete.getHosRegTiers();
                              }
                           }
                        } else if (this.factureLigneMedical.getFacligIdHospitalisationLabo() != 0L) {
                           this.hospitalisationLabo = this.hospitalisationLaboDao.selectLabo(this.factureLigneMedical.getFacligIdHospitalisationLabo(), var1);
                           if (this.hospitalisationLabo != null) {
                              this.hospitalisationEntete = this.hospitalisationEnteteDao.selectById(this.hospitalisationLabo.getHospitalisationEntete().getHosId(), var1);
                              if (this.hospitalisationEntete != null && var4 > 0.0D) {
                                 if (var4 >= this.hospitalisationEntete.getTotalTiers()) {
                                    this.hospitalisationEntete.setHosRegTiers(this.hospitalisationEntete.getTotalTiers());
                                    this.hospitalisationEntete.setHosSoldeTiers(1);
                                 } else {
                                    this.hospitalisationEntete.setHosRegTiers(var4);
                                    this.hospitalisationEntete.setHosSoldeTiers(0);
                                 }

                                 this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
                                 var4 -= this.hospitalisationEntete.getHosRegTiers();
                              }
                           }
                        } else if (this.factureLigneMedical.getFacligIdHospitalisationMedic() != 0L) {
                           this.hospitalisationMedi = this.hospitalisationMediDao.selectMedi(this.factureLigneMedical.getFacligIdHospitalisationMedic(), var1);
                           if (this.hospitalisationMedi != null) {
                              this.hospitalisationEntete = this.hospitalisationEnteteDao.selectById(this.hospitalisationMedi.getHospitalisationEntete().getHosId(), var1);
                              if (this.hospitalisationEntete != null && var4 > 0.0D) {
                                 if (var4 >= this.hospitalisationEntete.getTotalTiers()) {
                                    this.hospitalisationEntete.setHosRegTiers(this.hospitalisationEntete.getTotalTiers());
                                    this.hospitalisationEntete.setHosSoldeTiers(1);
                                 } else {
                                    this.hospitalisationEntete.setHosRegTiers(var4);
                                    this.hospitalisationEntete.setHosSoldeTiers(0);
                                 }

                                 this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
                                 var4 -= this.hospitalisationEntete.getHosRegTiers();
                              }
                           }
                        } else if (this.factureLigneMedical.getFacligIdHospitalisationPrest() != 0L) {
                           this.hospitalisationPrest = this.hospitalisationPrestDao.selectPrest(this.factureLigneMedical.getFacligIdHospitalisationPrest(), var1);
                           if (this.hospitalisationPrest != null) {
                              this.hospitalisationEntete = this.hospitalisationEnteteDao.selectById(this.hospitalisationPrest.getHospitalisationEntete().getHosId(), var1);
                              if (this.hospitalisationEntete != null && var4 > 0.0D) {
                                 if (var4 >= this.hospitalisationEntete.getTotalTiers()) {
                                    this.hospitalisationEntete.setHosRegTiers(this.hospitalisationEntete.getTotalTiers());
                                    this.hospitalisationEntete.setHosSoldeTiers(1);
                                 } else {
                                    this.hospitalisationEntete.setHosRegTiers(var4);
                                    this.hospitalisationEntete.setHosSoldeTiers(0);
                                 }

                                 this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
                                 var4 -= this.hospitalisationEntete.getHosRegTiers();
                              }
                           }
                        }
                     }

                     var1.flush();
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

   }

   public void annule() throws IOException, JDOMException {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibleOnglet = false;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void save() throws HibernateException, NamingException {
      if (this.factureEnteteMedical != null) {
         this.factureEnteteMedical = this.factureEnteteMedicalDao.modif(this.factureEnteteMedical);
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
      if (this.factureEnteteMedical.getFacTypeReg() != 0 && this.factureEnteteMedical.getFacTypeReg() != 3) {
         if (this.factureEnteteMedical.getFacTypeReg() != 1 && this.factureEnteteMedical.getFacTypeReg() != 2 && this.factureEnteteMedical.getFacTypeReg() != 10) {
            if (this.factureEnteteMedical.getFacTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

   }

   public void chargerModeEcheance() throws ParseException {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      String var1 = "0";
      if (this.factureEnteteMedical.getFacModeReg() != null && !this.factureEnteteMedical.getFacModeReg().isEmpty() && this.factureEnteteMedical.getFacModeReg().contains(":")) {
         String[] var2 = this.factureEnteteMedical.getFacModeReg().split(":");
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

            this.factureEnteteMedical.setFacTypeReg(Integer.parseInt(var3.getEcheances()));
            this.factureEnteteMedical.setFacModeReg(var3.getCategories() + ":" + var3.getLibelles());
            this.factureEnteteMedical.setFacNbJourReg(0);
            this.factureEnteteMedical.setFacArrondiReg(0);
            break;
         }
      }

      if (this.factureEnteteMedical.getFacTypeReg() != 0 && this.factureEnteteMedical.getFacTypeReg() != 3) {
         if (this.factureEnteteMedical.getFacTypeReg() != 1 && this.factureEnteteMedical.getFacTypeReg() != 2 && this.factureEnteteMedical.getFacTypeReg() != 10) {
            if (this.factureEnteteMedical.getFacTypeReg() == 4) {
               this.visibiliteencaissemt = true;
               this.visibilitenbrjr = true;
            }
         } else {
            for(var6 = 0; var6 < this.lesModeReglementClientsListe.size(); ++var6) {
               new ObjetReglement();
               var3 = (ObjetReglement)this.lesModeReglementClientsListe.get(var6);
               if (var3.getCategories().equals(var1)) {
                  this.factureEnteteMedical.setFacTypeReg(Integer.parseInt(var3.getEcheances()));
                  this.factureEnteteMedical.setFacModeReg(var3.getCategories() + ":" + var3.getLibelles());
                  int var4 = 0;
                  if (var3.getNbjours() != null && !var3.getNbjours().isEmpty()) {
                     var4 = Integer.parseInt(var3.getNbjours());
                  }

                  this.factureEnteteMedical.setFacNbJourReg(var4);
                  int var5 = 0;
                  if (var3.getArrondis() != null && !var3.getArrondis().isEmpty()) {
                     var5 = Integer.parseInt(var3.getArrondis());
                  }

                  this.factureEnteteMedical.setFacArrondiReg(var5);
                  break;
               }
            }

            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
         }
      }

      this.CalculDateEcheance();
   }

   public void CalculDateEcheance() throws ParseException {
      Date var1 = this.utilDate.CalculDateEcheance(this.factureEnteteMedical.getFacDate(), this.factureEnteteMedical.getFacTypeReg(), this.factureEnteteMedical.getFacNbJourReg(), this.factureEnteteMedical.getFacArrondiReg());
      this.factureEnteteMedical.setFacDateEcheReg(var1);
   }

   public void majVisa() throws HibernateException, NamingException {
      if (this.factureEnteteMedical != null && this.factureEnteteMedical.getFacId() != 0L) {
         this.factureEnteteMedical = this.factureEnteteMedicalDao.modif(this.factureEnteteMedical);
      }

   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.factureEnteteMedical.setFacEtatVal(1);
         this.factureEnteteMedical.setFacEtat(0);
         this.factureEnteteMedical.setFacDateValide((Date)null);
         return true;
      } else {
         this.factureEnteteMedical.setFacEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.factureEnteteMedical.setFacEtat(1);
               this.factureEnteteMedical.setFacDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2) {
               if (this.usersChrono.getUsrchrValidation() == 3) {
                  this.factureEnteteMedical.setFacEtat(0);
                  this.factureEnteteMedical.setFacDateValide((Date)null);
               } else if (this.usersChrono.getUsrchrValidation() == 4) {
                  this.factureEnteteMedical.setFacEtat(1);
               }
            }
         }

         return false;
      }
   }

   public void annulerDocument() {
      if (this.factureEnteteMedical != null) {
         this.factureEnteteMedical.setFacDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.factureEnteteMedical != null) {
         if (this.factureEnteteMedical.getFacDateAnnule() == null) {
            this.factureEnteteMedical.setFacDateAnnule(new Date());
         }

         this.factureEnteteMedical.setFacEtat(3);
         this.factureEnteteMedical = this.factureEnteteMedicalDao.modif(this.factureEnteteMedical);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation refacture N° " + this.factureEnteteMedical.getFacNum() + " le " + this.factureEnteteMedical.getFacDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.lesEntetesList.remove(this.factureEnteteMedical);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void imprimerSimulationPeriode() {
      this.showModalPanelPrintSimulation = true;
   }

   public void fermerSimulationPeriode() {
      this.showModalPanelPrintSimulation = false;
   }

   public void imprimerJRVSimu() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.imprimerSimalutation("JRV");
   }

   public void imprimerPDFSimu() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.imprimerSimalutation("PDF");
   }

   public void imprimerODTSimu() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.imprimerSimalutation("ODT");
   }

   public void imprimerXLSSimu() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.imprimerSimalutation("XLS");
   }

   public void imprimerDOCSimu() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.imprimerSimalutation("DOC");
   }

   public void imprimerHTMLSimu() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.imprimerSimalutation("HTML");
   }

   public void imprimerXMLSimu() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.imprimerSimalutation("XML");
   }

   public void imprimerSimalutation(String var1) throws SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "refacturation" + File.separator + "simulation" + File.separator;
      File var3 = new File(var2);
      if (!var3.exists()) {
         var3.mkdir();
      }

      String var4 = "";
      if (this.inpRegroupement == 0) {
         var4 = var2 + "simulation_0.jasper";
      } else if (this.inpRegroupement == 1) {
         var4 = var2 + "simulation_1.jasper";
      } else if (this.inpRegroupement == 2) {
         var4 = var2 + "simulation_2.jasper";
      }

      var3 = new File(var4);
      if (var3.exists()) {
         UtilPrint var5 = new UtilPrint(this.utilInitHibernate);
         var5.setEntete("Impression de la liste des factures en simulation");
         var5.setCheminRapport(var2);
         var5.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator);
         var5.setFormat(var1);
         ArrayList var6 = new ArrayList();
         String var7 = "";
         int var8;
         int var9;
         if (this.inpRegroupement == 0) {
            var5.setRapport("simulation_0");
            var7 = "Regoupement: Tiers";
            if (this.lesTiersConcernes.size() != 0) {
               for(var8 = 0; var8 < this.lesTiersConcernes.size(); ++var8) {
                  if (((DocumentEntete)this.lesTiersConcernes.get(var8)).isDocSelect() && this.lesFacturesConcernes.size() != 0) {
                     for(var9 = 0; var9 < this.lesFacturesConcernes.size(); ++var9) {
                        if (((DocumentEntete)this.lesTiersConcernes.get(var8)).getDocId() == ((DocumentEntete)this.lesFacturesConcernes.get(var9)).getDocIdResponsable()) {
                           var6.add(this.lesFacturesConcernes.get(var9));
                        }
                     }
                  }
               }
            }
         } else if (this.inpRegroupement != 1) {
            if (this.inpRegroupement == 2) {
               var5.setRapport("simulation_2");
               var7 = "Regoupement: Factures";
               if (this.lesTiersConcernes.size() != 0) {
                  for(var8 = 0; var8 < this.lesTiersConcernes.size(); ++var8) {
                     if (((DocumentEntete)this.lesTiersConcernes.get(var8)).isDocSelect()) {
                        var6.add(this.lesTiersConcernes.get(var8));
                     }
                  }
               }
            }
         } else {
            var5.setRapport("simulation_1");
            var7 = "Regoupement: Tiers/adhérents";
            if (this.lesTiersConcernes.size() != 0) {
               for(var8 = 0; var8 < this.lesTiersConcernes.size(); ++var8) {
                  if (((DocumentEntete)this.lesTiersConcernes.get(var8)).isDocSelect() && this.lesFacturesConcernes.size() != 0) {
                     for(var9 = 0; var9 < this.lesFacturesConcernes.size(); ++var9) {
                        if (((DocumentEntete)this.lesTiersConcernes.get(var8)).getDocId() == ((DocumentEntete)this.lesFacturesConcernes.get(var9)).getDocIdResponsable()) {
                           if ((((DocumentEntete)this.lesFacturesConcernes.get(var9)).getDocTypeTiers() == 0 || ((DocumentEntete)this.lesFacturesConcernes.get(var9)).getDocTypeTiers() == 2) && ((DocumentEntete)this.lesTiersConcernes.get(var8)).getDocIdEquipe() == ((DocumentEntete)this.lesFacturesConcernes.get(var9)).getDocIdCommercial()) {
                              var6.add(this.lesFacturesConcernes.get(var9));
                           } else if (((DocumentEntete)this.lesFacturesConcernes.get(var9)).getDocTypeTiers() == 1 && ((DocumentEntete)this.lesTiersConcernes.get(var8)).getDocEntree() != null && !((DocumentEntete)this.lesTiersConcernes.get(var8)).getDocEntree().isEmpty() && ((DocumentEntete)this.lesFacturesConcernes.get(var9)).getDocEntree() != null && !((DocumentEntete)this.lesFacturesConcernes.get(var9)).getDocEntree().isEmpty() && ((DocumentEntete)this.lesTiersConcernes.get(var8)).getDocEntree().equals(((DocumentEntete)this.lesFacturesConcernes.get(var9)).getDocEntree())) {
                              var6.add(this.lesFacturesConcernes.get(var9));
                           }
                        }
                     }
                  }
               }
            }
         }

         JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(var6);
         var5.setjRBeanCollectionDataSource(var12);
         String var13 = "";
         if (this.inpClient != null && !this.inpClient.isEmpty()) {
            var13 = "Période du " + this.utilDate.dateToStringFrLg(this.dateDebut) + " au " + this.utilDate.dateToStringFrLg(this.dateFin) + " " + var7 + " Tier: " + this.inpClient;
         } else {
            var13 = "Période du " + this.utilDate.dateToStringFrLg(this.dateDebut) + " au " + this.utilDate.dateToStringFrLg(this.dateFin) + " " + var7 + " Tiers: TOUS";
         }

         var5.setEntete(var13);
         if (this.inpClient != null && !this.inpClient.isEmpty() && this.inpClient.equals("CNAMGS")) {
            String var10 = "";

            for(int var11 = 0; var11 < this.lesTiersPayeurs.size(); ++var11) {
               if (Integer.parseInt(((SelectItem)this.lesTiersPayeurs.get(var11)).getValue().toString()) == this.inpTiersPayeurs) {
                  var10 = ((SelectItem)this.lesTiersPayeurs.get(var11)).getLabel().toString();
               }
            }

            var5.setFiltre("Date de facture:" + this.utilDate.dateToStringFrLg(this.dateFacture) + " Fonds: " + var10);
         } else {
            var5.setFiltre("Date de facture:" + this.utilDate.dateToStringFrLg(this.dateFacture));
         }

         var5.setNature(this.inpRegroupement);
         var5.setBaseLog(this.baseLog);
         var5.setStructureLog(this.structureLog);
         var5.setUsersLog(this.usersLog);
         var5.imprimeRapport();
      }

   }

   public void controlePeriode() throws ParseException, HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
      this.lesEntetesCtrl.clear();
      if (this.inpCat >= 0 && this.inpCat <= 4) {
         this.controleConsulationFacture(var1);
         this.controlePharmacieFacture(var1);
         this.controleLaboratoireFacture(var1);
      }

      if (this.inpCat >= 0 && this.inpCat <= 3 || this.inpCat == 5) {
         this.controleHospitalisationFacture(var1);
      }

      this.dataModelEntetesCtrl.setWrappedData(this.lesEntetesCtrl);
      this.cumulPrixCtrl();
      this.utilInitHibernate.closeSession();
      this.extDTableCtrl = new HtmlExtendedDataTable();
      this.simpleSelectionEnteteCtrl.clear();
      this.visibiliteBtonCtrl = false;
      this.showModalPanelAjouter = false;
   }

   public void cumulPrixCtrl() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      if (this.lesEntetesCtrl.size() != 0) {
         for(int var9 = 0; var9 < this.lesEntetesCtrl.size(); ++var9) {
            var1 += ((DocumentMedical)this.lesEntetesCtrl.get(var9)).getDocTotTiers();
            var3 += ((DocumentMedical)this.lesEntetesCtrl.get(var9)).getDocTotPatient();
            var5 = var5 + ((DocumentMedical)this.lesEntetesCtrl.get(var9)).getDocTotPatient() + ((DocumentMedical)this.lesEntetesCtrl.get(var9)).getDocTotTiers();
            var7 = var7 + ((DocumentMedical)this.lesEntetesCtrl.get(var9)).getDocRegPatient() + ((DocumentMedical)this.lesEntetesCtrl.get(var9)).getDocRegTiers();
         }
      }

      this.montantReglement = var1;
      this.montantSolde = var3;
      this.montantTtc = var5;
      this.var_nb_ligne = this.lesEntetesCtrl.size();
   }

   public void controleConsulationFacture(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesConsultations.clear();
      String var2 = "";
      String var3 = "";
      String var4 = "";
      if (this.inpEtat == 2) {
         var4 = "(csgEtat=" + this.inpEtat + " or csgBloqueRefacturation=true)";
      } else if (this.inpEtat == 6) {
         var4 = "(csgEtat=6 or csgEtat=7)";
      } else {
         var4 = "csgEtat=" + this.inpEtat;
      }

      if (this.var_more_search) {
         if (this.inpDu != null) {
            var2 = this.utilDate.dateToStringSQLLight(this.inpDu) + " 00:00:00";
         }

         if (this.inpAu != null) {
            var3 = this.utilDate.dateToStringSQLLight(this.inpAu) + " 23:59:59";
         }

         var4 = var4 + " and (csgDate>='" + var2 + "' and csgDate<='" + var3 + "')";
      } else {
         if (this.periode.equals("0")) {
            var2 = this.utilDate.dateToStringSQLLight(new Date()) + " 00:00:00";
            var3 = this.utilDate.dateToStringSQLLight(new Date()) + " 23:59:59";
         } else if (this.periode.equals("2")) {
            var2 = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(new Date())) + " 00:00:00";
            var3 = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(new Date())) + " 23:59:59";
         }

         var4 = var4 + " and (csgDate>='" + var2 + "' and csgDate<='" + var3 + "')";
      }

      if (this.inpCat != 0) {
         if (this.inpCat == 1) {
            var4 = var4 + " and (csgIdSociete=0 and csgIdAssurance=0 and csgIdComplementaire=0 and csgPecCnamgs=0)";
         } else if (this.inpCat == 2) {
            var4 = var4 + " and ((csgIdSociete<>0 or csgIdAssurance<>0 or csgIdComplementaire<>0) and csgPecCnamgs=0)";
         } else if (this.inpCat == 3) {
            var4 = var4 + " and (csgIdSociete=0 and csgIdAssurance=0 and csgIdComplementaire=0 and csgPecCnamgs<>0)";
         }
      }

      if (this.inpService != null && !this.inpService.isEmpty()) {
         var4 = var4 + " and csgService='" + this.inpService + "'";
      }

      if (this.inpSerie != null && !this.inpSerie.isEmpty() && !this.inpSerie.equals("100")) {
         var4 = var4 + " and csgSerie='" + this.inpSerie + "'";
      }

      if (this.inpFacturier != 0L) {
         var4 = var4 + " and csgIdCreateur=" + this.inpFacturier;
      }

      if (this.inpPatient != null && !this.inpPatient.isEmpty()) {
         var4 = var4 + " and csgNomPatient like '" + this.inpPatient + "%'";
      }

      if (this.idTiers != 0L) {
         var4 = var4 + " and (csgIdSociete =" + this.idTiers + " or csgIdAssurance =" + this.idTiers + " or csgIdComplementaire =" + this.idTiers + ")";
      }

      this.lesConsultations = this.consultationEnteteGeneDao.chargerConsultationByRequete(var4, var1);
      if (this.lesConsultations.size() != 0) {
         this.consultationEnteteGene = new ConsultationEnteteGene();

         for(int var5 = 0; var5 < this.lesConsultations.size(); ++var5) {
            this.consultationEnteteGene = (ConsultationEnteteGene)this.lesConsultations.get(var5);
            this.documentMedical = new DocumentMedical();
            this.documentMedical.setDocNature(71);
            this.documentMedical.setDocDossier(this.consultationEnteteGene.getPatients().getPatDossier());
            this.documentMedical.setDocDossierAssure("");
            if (this.consultationEnteteGene.getPatients().getPatIdCouvertPar() != 0L) {
               new Patients();
               Patients var6 = this.patientsDao.selectPatientsD(this.consultationEnteteGene.getPatients().getPatIdCouvertPar(), var1);
               if (var6 != null) {
                  this.documentMedical.setDocDossierAssure(var6.getPatDossier());
               }
            }

            this.documentMedical.setDocDate(this.consultationEnteteGene.getCsgDate());
            this.documentMedical.setDocEtat(this.consultationEnteteGene.getCsgEtat());
            this.documentMedical.setDocBloqueRefacturation(this.consultationEnteteGene.isCsgBloqueRefacturation());
            this.documentMedical.setDocNum(this.consultationEnteteGene.getCsgNum());
            this.documentMedical.setDocFeuille(this.consultationEnteteGene.getCsgFeuille());
            this.documentMedical.setDocNumBc(this.consultationEnteteGene.getCsgNumBc());
            this.documentMedical.setDocId(this.consultationEnteteGene.getCsgId());
            this.documentMedical.setDocIdCreateur(this.consultationEnteteGene.getCsgIdCreateur());
            this.documentMedical.setDocNomCreateur(this.consultationEnteteGene.getCsgNomCreateur());
            this.documentMedical.setDocIdAssurance(this.consultationEnteteGene.getCsgIdAssurance());
            this.documentMedical.setDocContratAssurance(this.consultationEnteteGene.getCsgContratAssurance());
            this.documentMedical.setDocNomTiersAssurance(this.consultationEnteteGene.getCsgNomAssurance());
            this.documentMedical.setDocIdComplementaire(this.consultationEnteteGene.getCsgIdComplementaire());
            this.documentMedical.setDocNomTiersComplementaire(this.consultationEnteteGene.getCsgNomComplemtaire());
            this.documentMedical.setDocContratComplementaire(this.consultationEnteteGene.getCsgContratComplementaire());
            this.documentMedical.setDocIdEmployeur(this.consultationEnteteGene.getCsgIdEmployeur());
            this.documentMedical.setDocNomEmployeur(this.consultationEnteteGene.getCsgNomEmployeur());
            this.documentMedical.setDocIdMedecin(this.consultationEnteteGene.getCsgIdMedecin());
            this.documentMedical.setDocNomMedecin(this.consultationEnteteGene.getCsgMedecin());
            this.documentMedical.setDocIdMotif(this.consultationEnteteGene.getCsgIdModif());
            this.documentMedical.setDocIdPatient(this.consultationEnteteGene.getCsgIdPatient());
            this.documentMedical.setDocNomPatient(this.consultationEnteteGene.getCsgNomPatient());
            this.documentMedical.setDocCivilite(this.consultationEnteteGene.getCsgCivilite());
            this.documentMedical.setDocIdSejour(this.consultationEnteteGene.getCsgIdSejour());
            this.documentMedical.setDocIdSociete(this.consultationEnteteGene.getCsgIdSociete());
            this.documentMedical.setDocNomTiersSociete(this.consultationEnteteGene.getCsgNomSociete());
            this.documentMedical.setDocMatriculeSociete(this.consultationEnteteGene.getCsgMatricule());
            this.documentMedical.setDocPathologie(this.consultationEnteteGene.getCsgPathologie());
            this.documentMedical.setDocPrescripteur(this.consultationEnteteGene.getCsgPrescripteur());
            this.documentMedical.setDocProtocole(this.consultationEnteteGene.getCsgProtocole());
            this.documentMedical.setDocNomAssurePrincipal(this.consultationEnteteGene.getCsgNomAssurePrincipal());
            this.documentMedical.setDocService(this.consultationEnteteGene.getCsgService());
            this.documentMedical.setDocComplementaire(this.consultationEnteteGene.getCsgComplementaire());
            this.documentMedical.setDocFam(this.consultationEnteteGene.getCsgFam());
            this.documentMedical.setDocFondCnamgs(this.consultationEnteteGene.getCsgFondCnamgs());
            this.documentMedical.setDocRegPatient(this.consultationEnteteGene.getCsgRegPatient());
            this.documentMedical.setDocPecCnamgs(this.consultationEnteteGene.getCsgPecCnamgs());
            this.documentMedical.setDocEntree(this.consultationEnteteGene.getEntree());
            this.documentMedical.setDocObs(this.consultationEnteteGene.getCsgObjet());
            this.documentMedical.setDocTotFacture(this.consultationEnteteGene.getTotalTiers() + this.consultationEnteteGene.getTotalPatient());
            this.documentMedical.setDocTotPatient(this.consultationEnteteGene.getCsgTotPatient() + this.consultationEnteteGene.getCsgTotTaxePatient());
            this.documentMedical.setDocTotTiers(this.consultationEnteteGene.getCsgTotAssurance() + this.consultationEnteteGene.getCsgTotSociete() + this.consultationEnteteGene.getCsgTotComplmentaire() + this.consultationEnteteGene.getCsgTotTaxeAssurance() + this.consultationEnteteGene.getCsgTotTaxeSociete() + this.consultationEnteteGene.getCsgTotTaxeComplementaire());
            this.documentMedical.setDocDateTransfert(this.consultationEnteteGene.getCsgDateTransfert());
            this.lesEntetesCtrl.add(this.documentMedical);
         }
      }

   }

   public void controlePharmacieFacture(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesPharamcies.clear();
      String var2 = "";
      String var3 = "";
      String var4 = "";
      if (this.inpEtat == 2) {
         var4 = "(phaEtat=" + this.inpEtat + " or phaBloqueRefacturation=true)";
      } else if (this.inpEtat == 6) {
         var4 = "(phaEtat=6 or phaEtat=7)";
      } else {
         var4 = "phaEtat=" + this.inpEtat;
      }

      if (this.var_more_search) {
         if (this.inpDu != null) {
            var2 = this.utilDate.dateToStringSQLLight(this.inpDu) + " 00:00:00";
         }

         if (this.inpAu != null) {
            var3 = this.utilDate.dateToStringSQLLight(this.inpAu) + " 23:59:59";
         }

         var4 = var4 + " and (phaDate>='" + var2 + "' and phaDate<='" + var3 + "')";
      } else {
         if (this.periode.equals("0")) {
            var2 = this.utilDate.dateToStringSQLLight(new Date()) + " 00:00:00";
            var3 = this.utilDate.dateToStringSQLLight(new Date()) + " 23:59:59";
         } else if (this.periode.equals("2")) {
            var2 = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(new Date())) + " 00:00:00";
            var3 = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(new Date())) + " 23:59:59";
         }

         var4 = var4 + " and (phaDate>='" + var2 + "' and phaDate<='" + var3 + "')";
      }

      if (this.inpCat != 0) {
         if (this.inpCat == 1) {
            var4 = var4 + " and (phaIdSociete=0 and phaIdAssurance=0 and phaIdComplementaire=0 and phaPecCnamgs=0)";
         } else if (this.inpCat == 2) {
            var4 = var4 + " and ((phaIdSociete<>0 or phaIdAssurance<>0 or phaIdComplementaire<>0) and phaPecCnamgs=0)";
         } else if (this.inpCat == 3) {
            var4 = var4 + " and (phaIdSociete=0 and phaIdAssurance=0 and phaIdComplementaire=0 and phaPecCnamgs<>0)";
         }
      }

      if (this.inpService != null && !this.inpService.isEmpty()) {
         var4 = var4 + " and phaService='" + this.inpService + "'";
      }

      if (this.inpSerie != null && !this.inpSerie.isEmpty() && !this.inpSerie.equals("100")) {
         var4 = var4 + " and phaSerie='" + this.inpSerie + "'";
      }

      if (this.inpFacturier != 0L) {
         var4 = var4 + " and phaIdCreateur=" + this.inpFacturier;
      }

      if (this.inpPatient != null && !this.inpPatient.isEmpty()) {
         var4 = var4 + " and phaNomPatient like '" + this.inpPatient + "%'";
      }

      if (this.idTiers != 0L) {
         var4 = var4 + " and (phaIdSociete =" + this.idTiers + " or phaIdAssurance =" + this.idTiers + " or phaIdComplementaire =" + this.idTiers + ")";
      }

      this.lesPharamcies = this.pharmacieEnteteDao.chargerPharmacieByRequete(var4, var1);
      if (this.lesPharamcies.size() != 0) {
         this.pharmacieEntete = new PharmacieEntete();

         for(int var5 = 0; var5 < this.lesPharamcies.size(); ++var5) {
            this.pharmacieEntete = (PharmacieEntete)this.lesPharamcies.get(var5);
            this.documentMedical = new DocumentMedical();
            this.documentMedical.setDocNature(73);
            this.documentMedical.setDocDossier(this.pharmacieEntete.getPatients().getPatDossier());
            this.documentMedical.setDocDossierAssure("");
            if (this.pharmacieEntete.getPatients().getPatIdCouvertPar() != 0L) {
               new Patients();
               Patients var6 = this.patientsDao.selectPatientsD(this.pharmacieEntete.getPatients().getPatIdCouvertPar(), var1);
               if (var6 != null) {
                  this.documentMedical.setDocDossierAssure(var6.getPatDossier());
               }
            }

            this.documentMedical.setDocDate(this.pharmacieEntete.getPhaDate());
            this.documentMedical.setDocBloqueRefacturation(this.pharmacieEntete.isPhaBloqueRefacturation());
            this.documentMedical.setDocEtat(this.pharmacieEntete.getPhaEtat());
            this.documentMedical.setDocNum(this.pharmacieEntete.getPhaNum());
            this.documentMedical.setDocFeuille(this.pharmacieEntete.getPhaFeuille());
            this.documentMedical.setDocNumBc(this.pharmacieEntete.getPhaNumBc());
            this.documentMedical.setDocId(this.pharmacieEntete.getPhaId());
            this.documentMedical.setDocIdCreateur(this.pharmacieEntete.getPhaIdCreateur());
            this.documentMedical.setDocNomCreateur(this.pharmacieEntete.getPhaNomCreateur());
            this.documentMedical.setDocIdAssurance(this.pharmacieEntete.getPhaIdAssurance());
            this.documentMedical.setDocNomTiersAssurance(this.pharmacieEntete.getPhaNomAssurance());
            this.documentMedical.setDocContratAssurance(this.pharmacieEntete.getPhaContratAssurance());
            this.documentMedical.setDocIdComplementaire(this.pharmacieEntete.getPhaIdComplementaire());
            this.documentMedical.setDocNomTiersComplementaire(this.pharmacieEntete.getPhaNomComplemtaire());
            this.documentMedical.setDocContratComplementaire(this.pharmacieEntete.getPhaContratComplementaire());
            this.documentMedical.setDocIdEmployeur(this.pharmacieEntete.getPhaIdEmployeur());
            this.documentMedical.setDocNomEmployeur(this.pharmacieEntete.getPhaNomEmployeur());
            this.documentMedical.setDocIdMedecin(this.pharmacieEntete.getPhaIdMedecin());
            this.documentMedical.setDocNomMedecin(this.pharmacieEntete.getPhaMedecin());
            this.documentMedical.setDocIdMotif(this.pharmacieEntete.getPhaIdModif());
            this.documentMedical.setDocIdPatient(this.pharmacieEntete.getPhaIdPatient());
            this.documentMedical.setDocNomPatient(this.pharmacieEntete.getPhaNomPatient());
            this.documentMedical.setDocCivilite(this.pharmacieEntete.getPhaCivilite());
            this.documentMedical.setDocIdSejour(0L);
            this.documentMedical.setDocIdSociete(this.pharmacieEntete.getPhaIdSociete());
            this.documentMedical.setDocNomTiersSociete(this.pharmacieEntete.getPhaNomSociete());
            this.documentMedical.setDocMatriculeSociete(this.pharmacieEntete.getPhaMatricule());
            this.documentMedical.setDocPathologie(this.pharmacieEntete.getPhaPathologie());
            this.documentMedical.setDocPrescripteur(this.pharmacieEntete.getPhaPrescripteur());
            this.documentMedical.setDocProtocole(this.pharmacieEntete.getPhaProtocole());
            this.documentMedical.setDocNomAssurePrincipal(this.pharmacieEntete.getPhaNomAssurePrincipal());
            this.documentMedical.setDocService(this.pharmacieEntete.getPhaService());
            this.documentMedical.setDocComplementaire(this.pharmacieEntete.getPhaComplementaire());
            this.documentMedical.setDocFam(this.pharmacieEntete.getPhaFam());
            this.documentMedical.setDocFondCnamgs(this.pharmacieEntete.getPhaFondCnamgs());
            this.documentMedical.setDocRegPatient(this.pharmacieEntete.getPhaRegPatient());
            this.documentMedical.setDocPecCnamgs(this.pharmacieEntete.getPhaPecCnamgs());
            this.documentMedical.setDocEntree("");
            this.documentMedical.setDocObs(this.pharmacieEntete.getPhaInfo10());
            this.documentMedical.setDocTotFacture(this.pharmacieEntete.getTotalTiers() + this.pharmacieEntete.getTotalPatient());
            this.documentMedical.setDocTotPatient(this.pharmacieEntete.getPhaTotPatient() + this.pharmacieEntete.getPhaTotTaxePatient());
            this.documentMedical.setDocTotTiers(this.pharmacieEntete.getPhaTotAssurance() + this.pharmacieEntete.getPhaTotSociete() + this.pharmacieEntete.getPhaTotComplmentaire() + this.pharmacieEntete.getPhaTotTaxeAssurance() + this.pharmacieEntete.getPhaTotTaxeSociete() + this.pharmacieEntete.getPhaTotTaxeComplementaire());
            this.documentMedical.setDocDateTransfert(this.pharmacieEntete.getPhaDateTransfert());
            this.lesEntetesCtrl.add(this.documentMedical);
         }
      }

   }

   public void controleLaboratoireFacture(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesLaboratoires.clear();
      String var2 = "";
      String var3 = "";
      String var4 = "";
      if (this.inpEtat == 2) {
         var4 = "(labEtat=" + this.inpEtat + " or labBloqueRefacturation=true)";
      } else if (this.inpEtat == 6) {
         var4 = "(labEtat=6 or labEtat=7)";
      } else {
         var4 = "labEtat=" + this.inpEtat;
      }

      if (this.var_more_search) {
         if (this.inpDu != null) {
            var2 = this.utilDate.dateToStringSQLLight(this.inpDu) + " 00:00:00";
         }

         if (this.inpAu != null) {
            var3 = this.utilDate.dateToStringSQLLight(this.inpAu) + " 23:59:59";
         }

         var4 = var4 + " and (labDate>='" + var2 + "' and labDate<='" + var3 + "')";
      } else {
         if (this.periode.equals("0")) {
            var2 = this.utilDate.dateToStringSQLLight(new Date()) + " 00:00:00";
            var3 = this.utilDate.dateToStringSQLLight(new Date()) + " 23:59:59";
         } else if (this.periode.equals("2")) {
            var2 = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(new Date())) + " 00:00:00";
            var3 = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(new Date())) + " 23:59:59";
         }

         var4 = var4 + " and (labDate>='" + var2 + "' and labDate<='" + var3 + "')";
      }

      if (this.inpCat != 0) {
         if (this.inpCat == 1) {
            var4 = var4 + " and (labIdSociete=0 and labIdAssurance=0 and labIdComplementaire=0 and labPecCnamgs=0)";
         } else if (this.inpCat == 2) {
            var4 = var4 + " and ((labIdSociete<>0 or labIdAssurance<>0 or labIdComplementaire<>0) and labPecCnamgs=0)";
         } else if (this.inpCat == 3) {
            var4 = var4 + " and (labIdSociete=0 and labIdAssurance=0 and labIdComplementaire=0 and labPecCnamgs<>0)";
         }
      }

      if (this.inpService != null && !this.inpService.isEmpty()) {
         var4 = var4 + " and labLaboratoire='" + this.inpService + "'";
      }

      if (this.inpSerie != null && !this.inpSerie.isEmpty() && !this.inpSerie.equals("100")) {
         var4 = var4 + " and labSerie='" + this.inpSerie + "'";
      }

      if (this.inpFacturier != 0L) {
         var4 = var4 + " and labIdCreateur=" + this.inpFacturier;
      }

      if (this.inpPatient != null && !this.inpPatient.isEmpty()) {
         var4 = var4 + " and labNomPatient like '" + this.inpPatient + "%'";
      }

      if (this.idTiers != 0L) {
         var4 = var4 + " and (labIdSociete =" + this.idTiers + " or labIdAssurance =" + this.idTiers + " or labIdComplementaire =" + this.idTiers + ")";
      }

      this.lesLaboratoires = this.laboratoireEnteteDao.chargerLaboratoireByRequete(var4, var1);
      if (this.lesLaboratoires.size() != 0) {
         this.laboratoireEntete = new LaboratoireEntete();

         for(int var5 = 0; var5 < this.lesLaboratoires.size(); ++var5) {
            this.laboratoireEntete = (LaboratoireEntete)this.lesLaboratoires.get(var5);
            this.documentMedical = new DocumentMedical();
            this.documentMedical.setDocNature(74);
            this.documentMedical.setDocDossier(this.laboratoireEntete.getPatients().getPatDossier());
            this.documentMedical.setDocDossierAssure("");
            if (this.laboratoireEntete.getPatients().getPatIdCouvertPar() != 0L) {
               new Patients();
               Patients var6 = this.patientsDao.selectPatientsD(this.laboratoireEntete.getPatients().getPatIdCouvertPar(), var1);
               if (var6 != null) {
                  this.documentMedical.setDocDossierAssure(var6.getPatDossier());
               }
            }

            this.documentMedical.setDocDate(this.laboratoireEntete.getLabDate());
            this.documentMedical.setDocEtat(this.laboratoireEntete.getLabEtat());
            this.documentMedical.setDocBloqueRefacturation(this.laboratoireEntete.isLabBloqueRefacturation());
            this.documentMedical.setDocNum(this.laboratoireEntete.getLabNum());
            this.documentMedical.setDocFeuille(this.laboratoireEntete.getLabFeuille());
            this.documentMedical.setDocNumBc(this.laboratoireEntete.getLabNumBc());
            this.documentMedical.setDocId(this.laboratoireEntete.getLabId());
            this.documentMedical.setDocIdCreateur(this.laboratoireEntete.getLabIdCreateur());
            this.documentMedical.setDocNomCreateur(this.laboratoireEntete.getLabNomCreateur());
            this.documentMedical.setDocIdAssurance(this.laboratoireEntete.getLabIdAssurance());
            this.documentMedical.setDocNomTiersAssurance(this.laboratoireEntete.getLabNomAssurance());
            this.documentMedical.setDocContratAssurance(this.laboratoireEntete.getLabContratAssurance());
            this.documentMedical.setDocIdComplementaire(this.laboratoireEntete.getLabIdComplementaire());
            this.documentMedical.setDocNomTiersComplementaire(this.laboratoireEntete.getLabNomComplemtaire());
            this.documentMedical.setDocContratComplementaire(this.laboratoireEntete.getLabContratComplementaire());
            this.documentMedical.setDocIdEmployeur(this.laboratoireEntete.getLabIdEmployeur());
            this.documentMedical.setDocNomEmployeur(this.laboratoireEntete.getLabNomEmployeur());
            this.documentMedical.setDocIdMedecin(this.laboratoireEntete.getLabIdMedecin());
            this.documentMedical.setDocNomMedecin(this.laboratoireEntete.getLabMedecin());
            this.documentMedical.setDocIdMotif(this.laboratoireEntete.getLabIdModif());
            this.documentMedical.setDocIdPatient(this.laboratoireEntete.getLabIdPatient());
            this.documentMedical.setDocNomPatient(this.laboratoireEntete.getLabNomPatient());
            this.documentMedical.setDocCivilite(this.laboratoireEntete.getLabCivilite());
            this.documentMedical.setDocIdSejour(0L);
            this.documentMedical.setDocIdSociete(this.laboratoireEntete.getLabIdSociete());
            this.documentMedical.setDocNomTiersSociete(this.laboratoireEntete.getLabNomSociete());
            this.documentMedical.setDocMatriculeSociete(this.laboratoireEntete.getLabMatricule());
            this.documentMedical.setDocPathologie(this.laboratoireEntete.getLabPathologie());
            this.documentMedical.setDocPrescripteur(this.laboratoireEntete.getLabPrescripteur());
            this.documentMedical.setDocProtocole(this.laboratoireEntete.getLabProtocole());
            this.documentMedical.setDocNomAssurePrincipal(this.laboratoireEntete.getLabNomAssurePrincipal());
            this.documentMedical.setDocService(this.laboratoireEntete.getLabLaboratoire());
            this.documentMedical.setDocComplementaire(this.laboratoireEntete.getLabComplementaire());
            this.documentMedical.setDocFam(this.laboratoireEntete.getLabFam());
            this.documentMedical.setDocFondCnamgs(this.laboratoireEntete.getLabFondCnamgs());
            this.documentMedical.setDocRegPatient(this.laboratoireEntete.getLabRegPatient());
            this.documentMedical.setDocPecCnamgs(this.laboratoireEntete.getLabPecCnamgs());
            this.documentMedical.setDocEntree(this.laboratoireEntete.getEntree());
            this.documentMedical.setDocObs(this.laboratoireEntete.getLabInfo10());
            this.documentMedical.setDocTotFacture(this.laboratoireEntete.getTotalTiers() + this.laboratoireEntete.getTotalPatient());
            this.documentMedical.setDocTotPatient(this.laboratoireEntete.getLabTotPatient() + this.laboratoireEntete.getLabTotTaxePatient());
            this.documentMedical.setDocTotTiers(this.laboratoireEntete.getLabTotAssurance() + this.laboratoireEntete.getLabTotSociete() + this.laboratoireEntete.getLabTotComplmentaire() + this.laboratoireEntete.getLabTotTaxeAssurance() + this.laboratoireEntete.getLabTotTaxeSociete() + this.laboratoireEntete.getLabTotTaxeComplementaire());
            this.documentMedical.setDocDateTransfert(this.laboratoireEntete.getLabDateTransfert());
            this.lesEntetesCtrl.add(this.documentMedical);
         }
      }

   }

   public void controleHospitalisationFacture(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesHospits.clear();
      String var2 = "";
      String var3 = "";
      String var4 = "";
      (new StringBuilder()).append("hosEtat=").append(this.inpEtat).toString();
      if (this.inpEtat == 2) {
         var4 = "(hosEtat=" + this.inpEtat + " or hosBloqueRefacturation=true)";
      } else if (this.inpEtat == 6) {
         var4 = "(hosEtat=6 or hosEtat=7)";
      } else {
         var4 = "hosEtat=" + this.inpEtat;
      }

      if (this.var_more_search) {
         if (this.inpDu != null) {
            var2 = this.utilDate.dateToStringSQLLight(this.inpDu) + " 00:00:00";
         }

         if (this.inpAu != null) {
            var3 = this.utilDate.dateToStringSQLLight(this.inpAu) + " 23:59:59";
         }

         var4 = var4 + " and (hosDateSortie>='" + var2 + "' and hosDateSortie<='" + var3 + "')";
      } else {
         if (this.periode.equals("0")) {
            var2 = this.utilDate.dateToStringSQLLight(new Date()) + " 00:00:00";
            var3 = this.utilDate.dateToStringSQLLight(new Date()) + " 23:59:59";
         } else if (this.periode.equals("2")) {
            var2 = this.utilDate.dateToStringSQLLight(this.utilDate.datePremierJourMois(new Date())) + " 00:00:00";
            var3 = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(new Date())) + " 23:59:59";
         }

         var4 = var4 + " and (hosDateSortie>='" + var2 + "' and hosDateSortie<='" + var3 + "')";
      }

      if (this.inpCat != 0) {
         if (this.inpCat == 1) {
            var4 = var4 + " and (hosIdSociete=0 and hosIdAssurance=0 and hosIdComplementaire=0 and hosPecCnamgs=0)";
         } else if (this.inpCat == 2) {
            var4 = var4 + " and ((hosIdSociete<>0 or hosIdAssurance<>0 or hosIdComplementaire<>0) and hosPecCnamgs=0)";
         } else if (this.inpCat == 3) {
            var4 = var4 + " and (hosIdSociete=0 and hosIdAssurance=0 and hosIdComplementaire=0 and hosPecCnamgs<>0)";
         }
      }

      if (this.inpService != null && !this.inpService.isEmpty()) {
      }

      if (this.inpSerie != null && !this.inpSerie.isEmpty() && !this.inpSerie.equals("100")) {
         var4 = var4 + " and hosSerie='" + this.inpSerie + "'";
      }

      if (this.inpFacturier != 0L) {
         var4 = var4 + " and hosIdCreateur=" + this.inpFacturier;
      }

      if (this.inpPatient != null && !this.inpPatient.isEmpty()) {
         var4 = var4 + " and hosNomPatient like '" + this.inpPatient + "%'";
      }

      if (this.idTiers != 0L) {
         var4 = var4 + " and (hosIdSociete =" + this.idTiers + " or hosIdAssurance =" + this.idTiers + " or hosIdComplementaire =" + this.idTiers + ")";
      }

      this.lesHospits = this.hospitalisationEnteteDao.chargerHospitalisationByRequete(var4, var1);
      if (this.lesHospits.size() != 0) {
         this.hospitalisationEntete = new HospitalisationEntete();

         for(int var5 = 0; var5 < this.lesHospits.size(); ++var5) {
            this.hospitalisationEntete = (HospitalisationEntete)this.lesHospits.get(var5);
            this.documentMedical = new DocumentMedical();
            this.documentMedical.setDocNature(76);
            this.documentMedical.setDocDossier(this.hospitalisationEntete.getPatients().getPatDossier());
            this.documentMedical.setDocDossierAssure("");
            if (this.hospitalisationEntete.getPatients().getPatIdCouvertPar() != 0L) {
               new Patients();
               Patients var6 = this.patientsDao.selectPatientsD(this.hospitalisationEntete.getPatients().getPatIdCouvertPar(), var1);
               if (var6 != null) {
                  this.documentMedical.setDocDossierAssure(var6.getPatDossier());
               }
            }

            this.documentMedical.setDocDate(this.hospitalisationEntete.getHosDateEntree());
            this.documentMedical.setDocEtat(this.hospitalisationEntete.getHosEtat());
            this.documentMedical.setDocBloqueRefacturation(this.hospitalisationEntete.isHosBloqueRefacturation());
            this.documentMedical.setDocNum(this.hospitalisationEntete.getHosNum());
            this.documentMedical.setDocFeuille(this.hospitalisationEntete.getHosFeuille());
            this.documentMedical.setDocNumBc(this.hospitalisationEntete.getHosNumBc());
            this.documentMedical.setDocId(this.hospitalisationEntete.getHosId());
            this.documentMedical.setDocIdCreateur(this.hospitalisationEntete.getHosIdCreateur());
            this.documentMedical.setDocNomCreateur(this.hospitalisationEntete.getHosNomCreateur());
            this.documentMedical.setDocIdAssurance(this.hospitalisationEntete.getHosIdAssurance());
            this.documentMedical.setDocNomTiersAssurance(this.hospitalisationEntete.getHosNomAssurance());
            this.documentMedical.setDocContratAssurance(this.hospitalisationEntete.getHosContratAssurance());
            this.documentMedical.setDocIdComplementaire(this.hospitalisationEntete.getHosIdComplementaire());
            this.documentMedical.setDocNomTiersComplementaire(this.hospitalisationEntete.getHosNomComplemtaire());
            this.documentMedical.setDocContratComplementaire(this.hospitalisationEntete.getHosContratComplementaire());
            this.documentMedical.setDocIdEmployeur(this.hospitalisationEntete.getHosIdEmployeur());
            this.documentMedical.setDocNomEmployeur(this.hospitalisationEntete.getHosNomEmployeur());
            this.documentMedical.setDocIdMedecin(this.hospitalisationEntete.getHosIdMedecin());
            this.documentMedical.setDocNomMedecin(this.hospitalisationEntete.getHosMedecin());
            this.documentMedical.setDocIdMotif(this.hospitalisationEntete.getHosIdModif());
            this.documentMedical.setDocIdPatient(this.hospitalisationEntete.getHosIdPatient());
            this.documentMedical.setDocNomPatient(this.hospitalisationEntete.getHosNomPatient());
            this.documentMedical.setDocCivilite(this.hospitalisationEntete.getHosCivilite());
            this.documentMedical.setDocIdSejour(0L);
            this.documentMedical.setDocIdSociete(this.hospitalisationEntete.getHosIdSociete());
            this.documentMedical.setDocNomTiersSociete(this.hospitalisationEntete.getHosNomSociete());
            this.documentMedical.setDocMatriculeSociete(this.hospitalisationEntete.getHosMatricule());
            this.documentMedical.setDocPathologie(this.hospitalisationEntete.getHosPathologie());
            this.documentMedical.setDocPrescripteur(this.hospitalisationEntete.getHosPrescripteur());
            this.documentMedical.setDocProtocole(this.hospitalisationEntete.getHosProtocole());
            this.documentMedical.setDocNomAssurePrincipal(this.hospitalisationEntete.getHosNomAssurePrincipal());
            this.documentMedical.setDocService(this.hospitalisationEntete.getHosService());
            this.documentMedical.setDocComplementaire(this.hospitalisationEntete.getHosComplementaire());
            this.documentMedical.setDocFam(this.hospitalisationEntete.getHosFam());
            this.documentMedical.setDocFondCnamgs(this.hospitalisationEntete.getHosFondCnamgs());
            this.documentMedical.setDocRegPatient(this.hospitalisationEntete.getHosRegPatient());
            this.documentMedical.setDocPecCnamgs(this.hospitalisationEntete.getHosPecCnamgs());
            this.documentMedical.setDocEntree(this.hospitalisationEntete.getHosMotifEntree());
            this.documentMedical.setDocObs(this.hospitalisationEntete.getHosInfo10());
            this.documentMedical.setDocTotFacture(this.hospitalisationEntete.getTotalTiers() + this.hospitalisationEntete.getTotalPatient());
            this.documentMedical.setDocTotPatient(this.hospitalisationEntete.getHosTotPatient() + this.hospitalisationEntete.getHosTotTaxePatient());
            this.documentMedical.setDocTotTiers(this.hospitalisationEntete.getHosTotAssurance() + this.hospitalisationEntete.getHosTotSociete() + this.hospitalisationEntete.getHosTotComplmentaire() + this.hospitalisationEntete.getHosTotTaxeAssurance() + this.hospitalisationEntete.getHosTotTaxeSociete() + this.hospitalisationEntete.getHosTotTaxeComplementaire());
            this.documentMedical.setDocDateTransfert(this.hospitalisationEntete.getHosDateTransfert());
            this.lesEntetesCtrl.add(this.documentMedical);
         }
      }

   }

   public void selectionCrtl() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.extDTableCtrl != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionEnteteCtrl.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTableCtrl.setRowKey(var3);
            if (this.extDTableCtrl.isRowAvailable()) {
               var1.add(this.extDTableCtrl.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.documentMedical = (DocumentMedical)var1.get(0);
            this.visibiliteBtonCtrl = false;
            this.consultationEnteteGene = null;
            this.pharmacieEntete = null;
            this.laboratoireEntete = null;
            this.hospitalisationEntete = null;
            this.fondsCnamgs = 0;
            this.pecCnamgs = 0.0F;
            String var4 = "";
            if (this.documentMedical.getDocNature() == 71) {
               this.consultationEnteteGene = this.consultationEnteteGeneDao.selectById(this.documentMedical.getDocId(), (Session)null);
               if (this.consultationEnteteGene != null) {
                  var4 = this.consultationEnteteGene.getCsgSerie();
                  this.fondsCnamgs = this.consultationEnteteGene.getCsgFondCnamgs();
                  this.pecCnamgs = this.consultationEnteteGene.getCsgPecCnamgs();
                  this.numFeuille = this.consultationEnteteGene.getCsgFeuille();
                  this.numBc = this.consultationEnteteGene.getCsgNumBc();
                  this.visibiliteBtonCtrl = true;
               }
            } else if (this.documentMedical.getDocNature() == 73) {
               this.pharmacieEntete = this.pharmacieEnteteDao.selectById(this.documentMedical.getDocId(), (Session)null);
               if (this.pharmacieEntete != null) {
                  var4 = this.pharmacieEntete.getPhaSerie();
                  this.fondsCnamgs = this.pharmacieEntete.getPhaFondCnamgs();
                  this.pecCnamgs = this.pharmacieEntete.getPhaPecCnamgs();
                  this.numFeuille = this.pharmacieEntete.getPhaFeuille();
                  this.numBc = this.pharmacieEntete.getPhaNumBc();
                  this.visibiliteBtonCtrl = true;
               }
            } else if (this.documentMedical.getDocNature() == 74) {
               this.laboratoireEntete = this.laboratoireEnteteDao.selectById(this.documentMedical.getDocId(), (Session)null);
               if (this.laboratoireEntete != null) {
                  var4 = this.laboratoireEntete.getLabSerie();
                  this.fondsCnamgs = this.laboratoireEntete.getLabFondCnamgs();
                  this.pecCnamgs = this.laboratoireEntete.getLabPecCnamgs();
                  this.numFeuille = this.laboratoireEntete.getLabFeuille();
                  this.numBc = this.laboratoireEntete.getLabNumBc();
                  this.visibiliteBtonCtrl = true;
               }
            } else if (this.documentMedical.getDocNature() == 76) {
               this.hospitalisationEntete = this.hospitalisationEnteteDao.selectById(this.documentMedical.getDocId(), (Session)null);
               if (this.hospitalisationEntete != null) {
                  var4 = this.hospitalisationEntete.getHosSerie();
                  this.fondsCnamgs = this.hospitalisationEntete.getHosFondCnamgs();
                  this.pecCnamgs = this.hospitalisationEntete.getHosPecCnamgs();
                  this.numFeuille = this.hospitalisationEntete.getHosFeuille();
                  this.numBc = this.hospitalisationEntete.getHosNumBc();
                  this.visibiliteBtonCtrl = true;
               }
            }

            if (this.documentMedical != null && var4 != null && !var4.isEmpty()) {
               this.usersChrono = this.usersChronoDao.selectUnique(var4, 78, this.usersLog, (Session)null);
            } else {
               this.usersChrono = new UsersChrono();
            }
         } else {
            this.visibiliteBtonCtrl = false;
         }
      } else {
         this.visibiliteBtonCtrl = false;
      }

   }

   public void visualisationCtrl() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.documentMedical != null && this.consultationEnteteGene == null && this.pharmacieEntete == null && this.laboratoireEntete == null && this.hospitalisationEntete != null) {
      }

   }

   public void historiquePaiementCtrl() throws HibernateException, NamingException {
      if (this.documentMedical != null) {
         this.lesReglementsCtrl.clear();
         if (this.consultationEnteteGene != null) {
            this.lesReglementsCtrl = this.reglementsDao.findRegByNatNum(71, this.consultationEnteteGene.getCsgNum(), (Session)null);
         } else if (this.pharmacieEntete != null) {
            this.lesReglementsCtrl = this.reglementsDao.findRegByNatNum(73, this.pharmacieEntete.getPhaNum(), (Session)null);
         } else if (this.laboratoireEntete != null) {
            this.lesReglementsCtrl = this.reglementsDao.findRegByNatNum(74, this.laboratoireEntete.getLabNum(), (Session)null);
         } else if (this.hospitalisationEntete != null) {
            this.lesReglementsCtrl = this.reglementsDao.findRegByNatNum(76, this.hospitalisationEntete.getHosNum(), (Session)null);
         }

         this.datamodelRecu.setWrappedData(this.lesReglementsCtrl);
         this.selectPatient = false;
         this.showModalPanelHistoReglement = true;
      }

   }

   public void visuFactureTiers() throws HibernateException, NamingException {
      if (this.documentMedical != null) {
         this.factureEnteteMedical = null;
         if (this.documentMedical.getDocEtat() == 6) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "RefacturationMed");
            this.datamodelDocumentTrace = new ListDataModel();
            Object var2 = new ArrayList();
            if (this.documentMedical.getDocNature() == 71) {
               this.consultationEnteteGene = this.consultationEnteteGeneDao.selectById(this.documentMedical.getDocId(), var1);
               if (this.consultationEnteteGene != null) {
                  this.factureLigneMedicalDao = new FactureLigneMedicalDao(this.baseLog, this.utilInitHibernate);
                  var2 = this.factureLigneMedicalDao.chargerLesLignesFacturesByDocument(this.consultationEnteteGene.getCsgNum(), 71, var1);
               }
            } else if (this.documentMedical.getDocNature() == 73) {
               this.pharmacieEntete = this.pharmacieEnteteDao.selectById(this.documentMedical.getDocId(), var1);
               if (this.pharmacieEntete != null) {
                  this.factureLigneMedicalDao = new FactureLigneMedicalDao(this.baseLog, this.utilInitHibernate);
                  var2 = this.factureLigneMedicalDao.chargerLesLignesFacturesByDocument(this.pharmacieEntete.getPhaNum(), 73, var1);
               }
            } else if (this.documentMedical.getDocNature() == 74) {
               this.laboratoireEntete = this.laboratoireEnteteDao.selectById(this.documentMedical.getDocId(), var1);
               if (this.laboratoireEntete != null) {
                  this.factureLigneMedicalDao = new FactureLigneMedicalDao(this.baseLog, this.utilInitHibernate);
                  var2 = this.factureLigneMedicalDao.chargerLesLignesFacturesByDocument(this.laboratoireEntete.getLabNum(), 74, var1);
               }
            } else if (this.documentMedical.getDocNature() == 76) {
               this.hospitalisationEntete = this.hospitalisationEnteteDao.selectById(this.documentMedical.getDocId(), var1);
               if (this.hospitalisationEntete != null) {
                  this.factureLigneMedicalDao = new FactureLigneMedicalDao(this.baseLog, this.utilInitHibernate);
                  var2 = this.factureLigneMedicalDao.chargerLesLignesFacturesByDocument(this.hospitalisationEntete.getHosNum(), 76, var1);
               }
            }

            if (((List)var2).size() != 0) {
               this.factureEnteteMedical = ((FactureLigneMedical)((List)var2).get(0)).getFactureEnteteMedical();
               this.datamodelDocumentTrace.setWrappedData(var2);
            } else {
               Transaction var3 = null;
               var3 = var1.beginTransaction();
               if (this.documentMedical.getDocNature() == 71 && this.consultationEnteteGene != null) {
                  this.consultationEnteteGene.setCsgEtat(5);
                  this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
               } else if (this.documentMedical.getDocNature() == 73 && this.pharmacieEntete != null) {
                  this.pharmacieEntete.setPhaEtat(5);
                  this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
               } else if (this.documentMedical.getDocNature() == 74 && this.laboratoireEntete != null) {
                  this.laboratoireEntete.setLabEtat(5);
                  this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
               } else if (this.documentMedical.getDocNature() == 76 && this.hospitalisationEntete != null) {
                  this.hospitalisationEntete.setHosEtat(5);
                  this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
               }

               this.documentMedical.setDocEtat(5);
               var3.commit();
            }

            this.utilInitHibernate.closeSession();
            this.showModalPanelFactureTiers = true;
         }
      }

   }

   public void fermerFactureTiers() {
      this.showModalPanelFactureTiers = false;
   }

   public void valideDocumentAgt() throws HibernateException, NamingException {
      if (this.documentMedical != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            Espion var3;
            if (this.consultationEnteteGene != null) {
               this.consultationEnteteGene.setCsgEtat(1);
               this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation consultation N° " + this.consultationEnteteGene.getCsgNum() + " du " + this.utilDate.dateToStringSQLLight(this.consultationEnteteGene.getCsgDate()));
               this.espionDao.mAJEspion(var3, var1);
            } else if (this.pharmacieEntete != null) {
               this.pharmacieEntete.setPhaEtat(1);
               this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation pharmacie N° " + this.pharmacieEntete.getPhaNum() + " du " + this.utilDate.dateToStringSQLLight(this.pharmacieEntete.getPhaDate()));
               this.espionDao.mAJEspion(var3, var1);
            } else if (this.laboratoireEntete != null) {
               this.laboratoireEntete.setLabEtat(1);
               this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation laboratoire N° " + this.laboratoireEntete.getLabNum() + " du " + this.utilDate.dateToStringSQLLight(this.laboratoireEntete.getLabDate()));
               this.espionDao.mAJEspion(var3, var1);
            } else if (this.hospitalisationEntete != null) {
               this.hospitalisationEntete.setHosEtat(1);
               this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation hospitalisation N° " + this.hospitalisationEntete.getHosNum() + " du " + this.utilDate.dateToStringSQLLight(this.hospitalisationEntete.getHosDateSortie()));
               this.espionDao.mAJEspion(var3, var1);
            }

            this.documentMedical.setDocEtat(1);
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

   public void deValideDocumentAgt() throws HibernateException, NamingException {
      if (this.documentMedical != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            Espion var3;
            if (this.consultationEnteteGene != null) {
               this.consultationEnteteGene.setCsgEtat(0);
               this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dé-Validation consultation N° " + this.consultationEnteteGene.getCsgNum() + " du " + this.utilDate.dateToStringSQLLight(this.consultationEnteteGene.getCsgDate()));
               this.espionDao.mAJEspion(var3, var1);
            } else if (this.pharmacieEntete != null) {
               this.pharmacieEntete.setPhaEtat(0);
               this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dé-Validation pharmacie N° " + this.pharmacieEntete.getPhaNum() + " du " + this.utilDate.dateToStringSQLLight(this.pharmacieEntete.getPhaDate()));
               this.espionDao.mAJEspion(var3, var1);
            } else if (this.laboratoireEntete != null) {
               this.laboratoireEntete.setLabEtat(0);
               this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dé-Validation laboratoire N° " + this.laboratoireEntete.getLabNum() + " du " + this.utilDate.dateToStringSQLLight(this.laboratoireEntete.getLabDate()));
               this.espionDao.mAJEspion(var3, var1);
            } else if (this.hospitalisationEntete != null) {
               this.hospitalisationEntete.setHosEtat(0);
               this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dé-Validation hospitalisation N° " + this.hospitalisationEntete.getHosNum() + " du " + this.utilDate.dateToStringSQLLight(this.hospitalisationEntete.getHosDateSortie()));
               this.espionDao.mAJEspion(var3, var1);
            }

            this.documentMedical.setDocEtat(0);
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

   public void valideDocumentCtrl() throws HibernateException, NamingException {
      if (this.documentMedical != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            Espion var3;
            if (this.consultationEnteteGene != null) {
               this.consultationEnteteGene.setCsgEtat(5);
               this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation CTRL consultation N° " + this.consultationEnteteGene.getCsgNum() + " du " + this.utilDate.dateToStringSQLLight(this.consultationEnteteGene.getCsgDate()));
               this.espionDao.mAJEspion(var3, var1);
            } else if (this.pharmacieEntete != null) {
               this.pharmacieEntete.setPhaEtat(5);
               this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation CTRL pharmacie N° " + this.pharmacieEntete.getPhaNum() + " du " + this.utilDate.dateToStringSQLLight(this.pharmacieEntete.getPhaDate()));
               this.espionDao.mAJEspion(var3, var1);
            } else if (this.laboratoireEntete != null) {
               this.laboratoireEntete.setLabEtat(5);
               this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation CTRL laboratoire N° " + this.laboratoireEntete.getLabNum() + " du " + this.utilDate.dateToStringSQLLight(this.laboratoireEntete.getLabDate()));
               this.espionDao.mAJEspion(var3, var1);
            } else if (this.hospitalisationEntete != null) {
               this.hospitalisationEntete.setHosEtat(5);
               this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation CTRL hospitalisation N° " + this.hospitalisationEntete.getHosNum() + " du " + this.utilDate.dateToStringSQLLight(this.hospitalisationEntete.getHosDateSortie()));
               this.espionDao.mAJEspion(var3, var1);
            }

            this.documentMedical.setDocEtat(5);
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

   public void deValideDocumentCtrl() throws HibernateException, NamingException {
      if (this.documentMedical != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            Espion var3;
            if (this.consultationEnteteGene != null) {
               this.consultationEnteteGene.setCsgEtat(1);
               this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dé-Validation CTRL consultation N° " + this.consultationEnteteGene.getCsgNum() + " du " + this.utilDate.dateToStringSQLLight(this.consultationEnteteGene.getCsgDate()));
               this.espionDao.mAJEspion(var3, var1);
            } else if (this.pharmacieEntete != null) {
               this.pharmacieEntete.setPhaEtat(1);
               this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dé-Validation CTRL pharmacie N° " + this.pharmacieEntete.getPhaNum() + " du " + this.utilDate.dateToStringSQLLight(this.pharmacieEntete.getPhaDate()));
               this.espionDao.mAJEspion(var3, var1);
            } else if (this.laboratoireEntete != null) {
               this.laboratoireEntete.setLabEtat(1);
               this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dé-Validation CTRL laboratoire N° " + this.laboratoireEntete.getLabNum() + " du " + this.utilDate.dateToStringSQLLight(this.laboratoireEntete.getLabDate()));
               this.espionDao.mAJEspion(var3, var1);
            } else if (this.hospitalisationEntete != null) {
               this.hospitalisationEntete.setHosEtat(1);
               this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dé-Validation CTRL hospitalisation N° " + this.hospitalisationEntete.getHosNum() + " du " + this.utilDate.dateToStringSQLLight(this.hospitalisationEntete.getHosDateSortie()));
               this.espionDao.mAJEspion(var3, var1);
            }

            this.documentMedical.setDocEtat(1);
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

   public void geleDocumentCtrl() throws HibernateException, NamingException {
      if (this.documentMedical != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            Espion var3;
            if (this.consultationEnteteGene != null) {
               this.consultationEnteteGene.setCsgBloqueRefacturation(true);
               this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Gele CTRL consultation N° " + this.consultationEnteteGene.getCsgNum() + " du " + this.utilDate.dateToStringSQLLight(this.consultationEnteteGene.getCsgDate()));
               this.espionDao.mAJEspion(var3, var1);
            } else if (this.pharmacieEntete != null) {
               this.pharmacieEntete.setPhaBloqueRefacturation(true);
               this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Gele CTRL pharmacie N° " + this.pharmacieEntete.getPhaNum() + " du " + this.utilDate.dateToStringSQLLight(this.pharmacieEntete.getPhaDate()));
               this.espionDao.mAJEspion(var3, var1);
            } else if (this.laboratoireEntete != null) {
               this.laboratoireEntete.setLabBloqueRefacturation(true);
               this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Gele CTRL laboratoire N° " + this.laboratoireEntete.getLabNum() + " du " + this.utilDate.dateToStringSQLLight(this.laboratoireEntete.getLabDate()));
               this.espionDao.mAJEspion(var3, var1);
            } else if (this.hospitalisationEntete != null) {
               this.hospitalisationEntete.setHosBloqueRefacturation(true);
               this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Gele CTRL hospitalisation N° " + this.hospitalisationEntete.getHosNum() + " du " + this.utilDate.dateToStringSQLLight(this.hospitalisationEntete.getHosDateSortie()));
               this.espionDao.mAJEspion(var3, var1);
            }

            this.documentMedical.setDocBloqueRefacturation(true);
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

   public void degeleDocumentCtrl() throws HibernateException, NamingException {
      if (this.documentMedical != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            Espion var3;
            if (this.consultationEnteteGene != null) {
               this.consultationEnteteGene.setCsgBloqueRefacturation(false);
               this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dé-Gele CTRL consultation N° " + this.consultationEnteteGene.getCsgNum() + " du " + this.utilDate.dateToStringSQLLight(this.consultationEnteteGene.getCsgDate()));
               this.espionDao.mAJEspion(var3, var1);
            } else if (this.pharmacieEntete != null) {
               this.pharmacieEntete.setPhaBloqueRefacturation(false);
               this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dé-Gele CTRL pharmacie N° " + this.pharmacieEntete.getPhaNum() + " du " + this.utilDate.dateToStringSQLLight(this.pharmacieEntete.getPhaDate()));
               this.espionDao.mAJEspion(var3, var1);
            } else if (this.laboratoireEntete != null) {
               this.laboratoireEntete.setLabBloqueRefacturation(false);
               this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dé-Gele CTRL laboratoire N° " + this.laboratoireEntete.getLabNum() + " du " + this.utilDate.dateToStringSQLLight(this.laboratoireEntete.getLabDate()));
               this.espionDao.mAJEspion(var3, var1);
            } else if (this.hospitalisationEntete != null) {
               this.hospitalisationEntete.setHosBloqueRefacturation(false);
               this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
               var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dé-Gele CTRL hospitalisation N° " + this.hospitalisationEntete.getHosNum() + " du " + this.utilDate.dateToStringSQLLight(this.hospitalisationEntete.getHosDateSortie()));
               this.espionDao.mAJEspion(var3, var1);
            }

            this.documentMedical.setDocBloqueRefacturation(false);
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

   public void changerServiceCtrl() throws HibernateException, NamingException {
      if (this.documentMedical != null) {
         this.nouveauMotif = "";
         this.nouveauService = "";
         this.nouveauMedecin = 0L;
         this.actuelMedecin = "";
         this.mesMedecinsItem.clear();
         new Users();
         Users var1;
         if (this.consultationEnteteGene != null) {
            this.actuelService = this.consultationEnteteGene.getCsgService();
            this.actuelMotif = this.consultationEnteteGene.getCsgEntree();
            if (this.consultationEnteteGene.getCsgIdMedecin() != 0L) {
               var1 = this.usersDao.selectLeUserId(this.consultationEnteteGene.getCsgIdMedecin(), (Session)null);
               if (var1 != null) {
                  this.actuelMedecin = var1.getUsrPatronyme();
               }
            }

            this.chargerMedecinService();
            this.showModalPanelChangerService = true;
         } else if (this.pharmacieEntete != null) {
            this.actuelService = this.pharmacieEntete.getPhaService();
            this.actuelMotif = null;
            if (this.pharmacieEntete.getPhaIdMedecin() != 0L) {
               var1 = this.usersDao.selectLeUserId(this.pharmacieEntete.getPhaIdMedecin(), (Session)null);
               if (var1 != null) {
                  this.actuelMedecin = var1.getUsrPatronyme();
               }
            }

            this.chargerMedecinService();
            this.showModalPanelChangerService = true;
         } else if (this.laboratoireEntete != null) {
            this.actuelService = this.laboratoireEntete.getLabLaboratoire();
            this.actuelMotif = this.laboratoireEntete.getLabEntree();
            if (this.laboratoireEntete.getLabIdMedecin() != 0L) {
               var1 = this.usersDao.selectLeUserId(this.laboratoireEntete.getLabIdMedecin(), (Session)null);
               if (var1 != null) {
                  this.actuelMedecin = var1.getUsrPatronyme();
               }
            }

            this.chargerMedecinService();
            this.showModalPanelChangerService = true;
         } else if (this.hospitalisationEntete != null) {
         }
      }

   }

   public void chargerMedecinService() throws HibernateException, NamingException {
      this.mesMedecinsItem.clear();
      String var1 = "";
      if (this.nouveauService != null && !this.nouveauService.isEmpty()) {
         var1 = this.nouveauService;
      } else if (this.actuelService != null && !this.actuelService.isEmpty()) {
         var1 = this.actuelService;
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

   public void annulerChangerServiceCtrl() {
      this.showModalPanelChangerService = false;
   }

   public void validerChangerServiceCtrl() throws HibernateException, NamingException {
      if (this.documentMedical != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.documentMedical.getDocNature() == 71 && this.consultationEnteteGene != null) {
               this.modifServiceConsultation(var1);
               this.documentMedical.setDocEntree(this.consultationEnteteGene.getEntree());
               this.documentMedical.setDocService(this.consultationEnteteGene.getCsgService());
               this.documentMedical.setDocNomMedecin(this.consultationEnteteGene.getCsgMedecin());
            } else if (this.documentMedical.getDocNature() == 73 && this.pharmacieEntete != null) {
               this.modifServicePharmacie(var1);
               this.documentMedical.setDocEntree("");
               this.documentMedical.setDocService(this.pharmacieEntete.getPhaService());
               this.documentMedical.setDocNomMedecin(this.pharmacieEntete.getPhaMedecin());
            } else if (this.documentMedical.getDocNature() == 74 && this.laboratoireEntete != null) {
               this.modifServiceLaboratoire(var1);
               this.documentMedical.setDocEntree(this.laboratoireEntete.getEntree());
               this.documentMedical.setDocService(this.laboratoireEntete.getLabLaboratoire());
               this.documentMedical.setDocNomMedecin(this.laboratoireEntete.getLabMedecin());
            } else if (this.documentMedical.getDocNature() == 76 && this.hospitalisationEntete != null) {
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

      this.showModalPanelChangerService = false;
   }

   public void modifServiceConsultation(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      boolean var3 = false;
      boolean var4 = false;
      String var5 = "";
      String var6 = this.consultationEnteteGene.getCsgService();
      String var7 = this.consultationEnteteGene.getCsgEntree();
      if (this.nouveauService != null && !this.nouveauService.isEmpty() && (this.consultationEnteteGene.getCsgService() == null || this.consultationEnteteGene.getCsgService().isEmpty() || !this.nouveauService.equals(this.consultationEnteteGene.getCsgService()))) {
         var2 = true;
      }

      if (this.nouveauMotif != null && !this.nouveauMotif.isEmpty() && (this.consultationEnteteGene.getCsgEntree() == null || this.consultationEnteteGene.getCsgEntree().isEmpty() || !this.nouveauMotif.equals(this.consultationEnteteGene.getCsgEntree()))) {
         var3 = true;
      }

      if (this.nouveauMedecin != 0L && this.nouveauMedecin != this.consultationEnteteGene.getCsgIdMedecin()) {
         var4 = true;
      }

      if (var2 || var3 || var4) {
         if (var2) {
            this.consultationEnteteGene.setCsgService(this.nouveauService);
         }

         if (var3) {
            this.consultationEnteteGene.setCsgEntree(this.nouveauMotif);
         }

         if (var4) {
            this.consultationEnteteGene.setCsgIdMedecin(this.nouveauMedecin);
            new Users();
            Users var8 = this.usersDao.selectLeUserId(this.nouveauMedecin, var1);
            if (var8 != null) {
               var5 = var8.getUsrPatronyme();
            }

            this.consultationEnteteGene.setCsgMedecin(var5);
         }

         this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
         if (var2) {
            new ArrayList();
            List var13 = this.reglementsDao.reglementDocument(this.consultationEnteteGene.getCsgId(), 71, var1);
            if (var13.size() != 0) {
               for(int var9 = 0; var9 < var13.size(); ++var9) {
                  this.reglements = (Reglements)var13.get(var9);
                  this.reglements.setRglService(this.nouveauService);
                  this.reglements = this.reglementsDao.modifierReg(this.reglements, var1);
               }
            }

            ConsultationReglementDao var14 = new ConsultationReglementDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var10 = var14.selectReglementByEnt(this.consultationEnteteGene, var1);
            if (var10.size() != 0) {
               new ConsultationReglement();

               for(int var12 = 0; var12 < var10.size(); ++var12) {
                  ConsultationReglement var11 = (ConsultationReglement)var10.get(var12);
                  var11.setCsgregService(this.nouveauService);
                  var14.modif(var11, var1);
               }
            }
         }

         if (var3) {
         }

         if (var4) {
         }
      }

   }

   public void modifServicePharmacie(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      boolean var3 = false;
      String var4 = "";
      String var5 = this.pharmacieEntete.getPhaService();
      if (this.nouveauService != null && !this.nouveauService.isEmpty() && (this.pharmacieEntete.getPhaService() == null || this.pharmacieEntete.getPhaService().isEmpty() || !this.nouveauService.equals(this.pharmacieEntete.getPhaService()))) {
         var2 = true;
      }

      if (this.nouveauMedecin != 0L && this.nouveauMedecin != this.pharmacieEntete.getPhaIdMedecin()) {
         var3 = true;
      }

      if (var2 || var3) {
         if (var2) {
            this.pharmacieEntete.setPhaService(this.nouveauService);
         }

         if (var3) {
            this.pharmacieEntete.setPhaIdMedecin(this.nouveauMedecin);
            new Users();
            Users var6 = this.usersDao.selectLeUserId(this.nouveauMedecin, var1);
            if (var6 != null) {
               var4 = var6.getUsrPatronyme();
            }

            this.pharmacieEntete.setPhaMedecin(var4);
         }

         this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
         if (var2) {
            new ArrayList();
            List var11 = this.reglementsDao.reglementDocument(this.pharmacieEntete.getPhaId(), 73, var1);
            if (var11.size() != 0) {
               for(int var7 = 0; var7 < var11.size(); ++var7) {
                  this.reglements = (Reglements)var11.get(var7);
                  this.reglements.setRglService(this.nouveauService);
                  this.reglements = this.reglementsDao.modifierReg(this.reglements, var1);
               }
            }

            PharmacieReglementDao var12 = new PharmacieReglementDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var8 = var12.selectReglementByEnt(this.pharmacieEntete, var1);
            if (var8.size() != 0) {
               new PharmacieReglement();

               for(int var10 = 0; var10 < var8.size(); ++var10) {
                  PharmacieReglement var9 = (PharmacieReglement)var8.get(var10);
                  var9.setPharegService(this.nouveauService);
                  var12.modif(var9, var1);
               }
            }
         }

         if (var3) {
         }
      }

   }

   public void modifServiceLaboratoire(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      boolean var3 = false;
      boolean var4 = false;
      String var5 = "";
      String var6 = this.laboratoireEntete.getLabLaboratoire();
      String var7 = this.laboratoireEntete.getLabEntree();
      if (this.nouveauService != null && !this.nouveauService.isEmpty() && (this.laboratoireEntete.getLabLaboratoire() == null || this.laboratoireEntete.getLabLaboratoire().isEmpty() || !this.nouveauService.equals(this.laboratoireEntete.getLabLaboratoire()))) {
         var2 = true;
      }

      if (this.nouveauMotif != null && !this.nouveauMotif.isEmpty() && (this.laboratoireEntete.getLabEntree() == null || this.laboratoireEntete.getLabEntree().isEmpty() || !this.nouveauMotif.equals(this.laboratoireEntete.getLabEntree()))) {
         var3 = true;
      }

      if (this.nouveauMedecin != 0L && this.nouveauMedecin != this.laboratoireEntete.getLabIdMedecin()) {
         var4 = true;
      }

      if (var2 || var3 || var4) {
         if (var2) {
            this.laboratoireEntete.setLabLaboratoire(this.nouveauService);
         }

         if (var3) {
            this.laboratoireEntete.setLabEntree(this.nouveauMotif);
         }

         if (var4) {
            this.laboratoireEntete.setLabIdMedecin(this.nouveauMedecin);
            new Users();
            Users var8 = this.usersDao.selectLeUserId(this.nouveauMedecin, var1);
            if (var8 != null) {
               var5 = var8.getUsrPatronyme();
            }

            this.laboratoireEntete.setLabMedecin(var5);
         }

         this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
         if (var2) {
            new ArrayList();
            List var13 = this.reglementsDao.reglementDocument(this.laboratoireEntete.getLabId(), 74, var1);
            if (var13.size() != 0) {
               for(int var9 = 0; var9 < var13.size(); ++var9) {
                  this.reglements = (Reglements)var13.get(var9);
                  this.reglements.setRglService(this.nouveauService);
                  this.reglements = this.reglementsDao.modifierReg(this.reglements, var1);
               }
            }

            LaboratoireReglementDao var14 = new LaboratoireReglementDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var10 = var14.selectReglementByEnt(this.laboratoireEntete, var1);
            if (var10.size() != 0) {
               new LaboratoireReglement();

               for(int var12 = 0; var12 < var10.size(); ++var12) {
                  LaboratoireReglement var11 = (LaboratoireReglement)var10.get(var12);
                  var11.setLabregService(this.nouveauService);
                  var14.modif(var11, var1);
               }
            }
         }

         if (var3) {
         }

         if (var4) {
         }
      }

   }

   public void modifServiceHospitalisation(Session var1) {
   }

   public void changerPatientCtrl() throws HibernateException, NamingException, IOException {
      if (this.documentMedical != null) {
         this.patients = this.patientsDao.selectPatientsD(this.documentMedical.getDocIdPatient());
         if (this.patients != null) {
            this.calculeGenre();
            this.recupererCivilitesItem();
            this.assurePrincipal = false;
            this.numCnamgsAssure = "";
            this.nomCnamgsAssure = "";
            if (this.patients.getPatIdCouvertPar() != 0L) {
               this.patientsAssure = this.patientsDao.selectPatientsD(this.patients.getPatIdCouvertPar());
               if (this.patientsAssure != null) {
                  this.numCnamgsAssure = this.patients.getPatCnamgs();
                  this.nomCnamgsAssure = this.patients.getPatronyme();
                  this.assurePrincipal = true;
               }
            } else {
               this.patientsAssure = null;
            }

            this.lesEmployeursItems.clear();
            if (this.documentMedical.getDocIdAssurance() != 0L && this.documentMedical.getDocIdEmployeur() != 0L) {
               this.lesEmployeursItems.clear();
               Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "TiersAdherent");
               this.tiers = this.tiersDao.selectTierD(this.documentMedical.getDocIdAssurance(), var1);
               if (this.tiers != null) {
                  this.lesEmployeursItems = this.tiersAdherentDao.listAdherentByTiersItems(this.tiers, var1);
               }

               this.utilInitHibernate.closeSession();
               if (this.lesEmployeursItems.size() == 0) {
                  this.lesEmployeursItems.add(new SelectItem(""));
               }
            }

            this.showModalPanelChangerNomPatient = true;
         }
      }

   }

   public void fermerChangerPatientCtrl() {
      this.showModalPanelChangerNomPatient = false;
   }

   public void validerChangerPatientCtrl() throws HibernateException, NamingException {
      if (this.patients != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.patients = this.patientsDao.modif(this.patients, var1);
            if (this.documentMedical.getDocFam() != 0L) {
               this.patientPec = this.patientPecDao.trouverPatientsPec(this.documentMedical.getDocFam(), 9, var1);
               if (this.patientPec != null) {
                  if (this.patientPec.getPatpecType() != null && !this.patientPec.getPatpecType().isEmpty()) {
                     if (!this.patientPec.getPatpecType().equals("Assurance") && !this.patientPec.getPatpecType().equals("IPM") && !this.patientPec.getPatpecType().equals("Programme Médical")) {
                        if (!this.patientPec.getPatpecType().equals("Mutuelle/Assurance") && !this.patientPec.getPatpecType().equals("Mutuelle") && !this.patientPec.getPatpecType().equals("Complémentaire")) {
                           if (this.patientPec.getPatpecType().equals("Client Société") || this.patientPec.getPatpecType().equals("Ministère") || this.patientPec.getPatpecType().equals("Direction") || this.patientPec.getPatpecType().equals("Mairie") || this.patientPec.getPatpecType().equals("Hôpital")) {
                              this.patientPec.setPatpecNumContrat(this.documentMedical.getDocMatriculeSociete());
                              this.patientPec.setPatpecIdEmployeur(0L);
                              this.patientPec.setPatpecNomEmployeur((String)null);
                           }
                        } else {
                           this.patientPec.setPatpecNumContrat(this.documentMedical.getDocContratComplementaire());
                        }
                     } else {
                        this.patientPec.setPatpecNumContrat(this.documentMedical.getDocContratAssurance());
                        if (this.documentMedical.getDocNomEmployeur() != null && !this.documentMedical.getDocNomEmployeur().isEmpty()) {
                           long var3 = this.tiersAdherentDao.listAdherentByTiersEmployeur(this.patientPec.getTiers().getTieid(), this.documentMedical.getDocNomEmployeur(), var1);
                           this.patientPec.setPatpecIdEmployeur(var3);
                           this.patientPec.setPatpecNomEmployeur(this.documentMedical.getDocNomEmployeur());
                        } else {
                           this.patientPec.setPatpecIdEmployeur(0L);
                           this.patientPec.setPatpecNomEmployeur((String)null);
                        }

                        this.documentMedical.setDocIdEmployeur(this.patientPec.getPatpecIdEmployeur());
                     }
                  }

                  this.patientPec = this.patientPecDao.modif(this.patientPec, var1);
               }
            }

            this.lesConsultations = this.consultationEnteteGeneDao.chargerLesMvtsPatients(this.patients, var1);
            int var10;
            if (this.lesConsultations.size() != 0) {
               for(var10 = 0; var10 < this.lesConsultations.size(); ++var10) {
                  this.consultationEnteteGene = (ConsultationEnteteGene)this.lesConsultations.get(var10);
                  this.consultationEnteteGene.setCsgNomPatient(this.patients.getPatronyme());
                  this.consultationEnteteGene.setCsgCivilite(this.patients.getPatCivilite());
                  if (this.documentMedical.getDocNature() == 71 && this.documentMedical.getDocId() == this.consultationEnteteGene.getCsgId()) {
                     this.consultationEnteteGene.setCsgContratAssurance(this.documentMedical.getDocContratAssurance());
                     this.consultationEnteteGene.setCsgContratComplementaire(this.documentMedical.getDocContratComplementaire());
                     this.consultationEnteteGene.setCsgMatricule(this.documentMedical.getDocMatriculeSociete());
                     this.consultationEnteteGene.setCsgNomEmployeur(this.documentMedical.getDocNomEmployeur());
                     this.consultationEnteteGene.setCsgIdEmployeur(this.documentMedical.getDocIdEmployeur());
                  }

                  this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
               }
            }

            this.lesPharamcies = this.pharmacieEnteteDao.chargerLesMvtsPatients(this.patients, var1);
            if (this.lesPharamcies.size() != 0) {
               for(var10 = 0; var10 < this.lesPharamcies.size(); ++var10) {
                  this.pharmacieEntete = (PharmacieEntete)this.lesPharamcies.get(var10);
                  this.pharmacieEntete.setPhaNomPatient(this.patients.getPatronyme());
                  this.pharmacieEntete.setPhaCivilite(this.patients.getPatCivilite());
                  if (this.documentMedical.getDocNature() == 73 && this.documentMedical.getDocId() == this.pharmacieEntete.getPhaId()) {
                     this.pharmacieEntete.setPhaContratAssurance(this.documentMedical.getDocContratAssurance());
                     this.pharmacieEntete.setPhaContratComplementaire(this.documentMedical.getDocContratComplementaire());
                     this.pharmacieEntete.setPhaMatricule(this.documentMedical.getDocMatriculeSociete());
                     this.pharmacieEntete.setPhaNomEmployeur(this.documentMedical.getDocNomEmployeur());
                     this.pharmacieEntete.setPhaIdEmployeur(this.documentMedical.getDocIdEmployeur());
                  }

                  this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
               }
            }

            this.lesLaboratoires = this.laboratoireEnteteDao.chargerLesMvtsPatients(this.patients, var1);
            if (this.lesLaboratoires.size() != 0) {
               for(var10 = 0; var10 < this.lesLaboratoires.size(); ++var10) {
                  this.laboratoireEntete = (LaboratoireEntete)this.lesLaboratoires.get(var10);
                  this.laboratoireEntete.setLabNomPatient(this.patients.getPatronyme());
                  this.laboratoireEntete.setLabCivilite(this.patients.getPatCivilite());
                  if (this.documentMedical.getDocNature() == 74 && this.documentMedical.getDocId() == this.laboratoireEntete.getLabId()) {
                     this.laboratoireEntete.setLabContratAssurance(this.documentMedical.getDocContratAssurance());
                     this.laboratoireEntete.setLabContratComplementaire(this.documentMedical.getDocContratComplementaire());
                     this.laboratoireEntete.setLabMatricule(this.documentMedical.getDocMatriculeSociete());
                     this.laboratoireEntete.setLabNomEmployeur(this.documentMedical.getDocNomEmployeur());
                     this.laboratoireEntete.setLabIdEmployeur(this.documentMedical.getDocIdEmployeur());
                  }

                  this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
               }
            }

            this.lesHospits = this.hospitalisationEnteteDao.chargerLesMvtsPatients(this.patients, var1);
            if (this.lesHospits.size() != 0) {
               for(var10 = 0; var10 < this.lesHospits.size(); ++var10) {
                  this.hospitalisationEntete = (HospitalisationEntete)this.lesHospits.get(var10);
                  this.hospitalisationEntete.setHosNomPatient(this.patients.getPatronyme());
                  this.hospitalisationEntete.setHosCivilite(this.patients.getPatCivilite());
                  if (this.documentMedical.getDocNature() == 76 && this.documentMedical.getDocId() == this.hospitalisationEntete.getHosId()) {
                     this.hospitalisationEntete.setHosContratAssurance(this.documentMedical.getDocContratAssurance());
                     this.hospitalisationEntete.setHosContratComplementaire(this.documentMedical.getDocContratComplementaire());
                     this.hospitalisationEntete.setHosMatricule(this.documentMedical.getDocMatriculeSociete());
                     this.hospitalisationEntete.setHosNomEmployeur(this.documentMedical.getDocNomEmployeur());
                     this.hospitalisationEntete.setHosIdEmployeur(this.documentMedical.getDocIdEmployeur());
                  }

                  this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
               }
            }

            new ArrayList();
            List var11 = this.reglementsDao.chargeReglementPatient(this.patients.getPatId(), var1);
            if (var11.size() != 0) {
               for(int var4 = 0; var4 < var11.size(); ++var4) {
                  this.reglements = (Reglements)var11.get(var4);
                  this.reglements.setRglNomTiers(this.patients.getPatronyme());
                  this.reglements = this.reglementsDao.modifierReg(this.reglements, var1);
               }
            }

            this.documentMedical.setDocNomPatient(this.patients.getPatronyme());
            this.documentMedical.setDocCivilite(this.patients.getPatCivilite());
            if (this.patients.getPatIdCouvertPar() != 0L && this.patientsAssure != null) {
               this.patientsAssure.setPatCnamgs(this.numCnamgsAssure);
               this.patientsAssure = this.patientsDao.modif(this.patientsAssure, var1);
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

      this.showModalPanelChangerNomPatient = false;
   }

   public void chargerMotifAnnulation() {
      if (this.documentMedical != null) {
         if (this.consultationEnteteGene != null) {
            this.dateAnnulation = this.consultationEnteteGene.getCsgDateAnnule();
            this.motifAnnulation = this.consultationEnteteGene.getCsgMotifAnnule();
            this.showModalPanelAnnuler = true;
         } else if (this.pharmacieEntete != null) {
            this.dateAnnulation = this.pharmacieEntete.getPhaDateAnnule();
            this.motifAnnulation = this.pharmacieEntete.getPhaMotifAnnule();
            this.showModalPanelAnnuler = true;
         } else if (this.laboratoireEntete != null) {
            this.dateAnnulation = this.laboratoireEntete.getLabDateAnnule();
            this.motifAnnulation = this.laboratoireEntete.getLabMotifAnnule();
            this.showModalPanelAnnuler = true;
         } else if (this.hospitalisationEntete != null) {
            this.dateAnnulation = this.hospitalisationEntete.getHosDateAnnule();
            this.motifAnnulation = this.hospitalisationEntete.getHosMotifAnnule();
            this.showModalPanelAnnuler = true;
         }
      }

   }

   public void validerAnnulerCtrl() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.consultationEnteteGene != null) {
            this.consultationEnteteGene.setCsgDateAnnule(this.dateAnnulation);
            this.consultationEnteteGene.setCsgMotifAnnule(this.motifAnnulation);
            this.consultationEnteteGene.setCsgEtat(3);
            this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
         } else if (this.pharmacieEntete != null) {
            this.pharmacieEntete.setPhaDateAnnule(this.dateAnnulation);
            this.pharmacieEntete.setPhaMotifAnnule(this.motifAnnulation);
            this.pharmacieEntete.setPhaEtat(3);
            this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
         } else if (this.laboratoireEntete != null) {
            this.laboratoireEntete.setLabDateAnnule(this.dateAnnulation);
            this.laboratoireEntete.setLabMotifAnnule(this.motifAnnulation);
            this.laboratoireEntete.setLabEtat(3);
            this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
         } else if (this.hospitalisationEntete != null) {
            this.hospitalisationEntete.setHosDateAnnule(this.dateAnnulation);
            this.hospitalisationEntete.setHosMotifAnnule(this.motifAnnulation);
            this.hospitalisationEntete.setHosEtat(3);
            this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
         }

         this.documentMedical.setDocEtat(3);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelAnnuler = false;
   }

   public void changerDocumentCtrl() throws HibernateException, NamingException {
      if (this.documentMedical != null) {
         this.lesLignesMedical.clear();
         this.prixCnamgs = 0.0D;
         new LigneMedical();
         LigneMedical var1;
         List var2;
         int var3;
         if (this.consultationEnteteGene != null) {
            this.patientDocument = this.consultationEnteteGene.getPatients();
            this.nomPatientDocument = this.consultationEnteteGene.getCsgNomPatient();
            this.numDocument = this.consultationEnteteGene.getCsgNum();
            this.dateDocument = this.consultationEnteteGene.getCsgDate();
            this.var_heure = "" + this.dateDocument.getHours();
            this.var_minute = "" + this.dateDocument.getMinutes();
            this.numFeuille = this.consultationEnteteGene.getCsgFeuille();
            this.numBc = this.consultationEnteteGene.getCsgNumBc();
            this.nomAgentFacturation = this.consultationEnteteGene.getCsgNomCreateur();
            this.totalFacture = this.consultationEnteteGene.getCsgTotGeneral();
            this.partPatient = this.consultationEnteteGene.getTotalPatient();
            this.partTiers = this.consultationEnteteGene.getTotalTiers();
            this.partTiersAssurance = this.consultationEnteteGene.getCsgTotAssurance() + this.consultationEnteteGene.getCsgTotTaxeAssurance();
            this.partTiersSociete = this.consultationEnteteGene.getCsgTotSociete() + this.consultationEnteteGene.getCsgTotTaxeSociete();
            this.partTiersComplementaire = this.consultationEnteteGene.getCsgTotComplmentaire() + this.consultationEnteteGene.getCsgTotTaxeComplementaire();
            new ArrayList();
            this.consultationActesDao = new ConsultationActesDao(this.baseLog, this.utilInitHibernate);
            var2 = this.consultationActesDao.selectConsActesByConsEnt(this.consultationEnteteGene, (Session)null);
            if (var2.size() != 0) {
               for(var3 = 0; var3 < var2.size(); ++var3) {
                  var1 = new LigneMedical();
                  var1.setLigAssuranceHt(((ConsultationActes)var2.get(var3)).getCslactAssuranceHt());
                  var1.setLigAssuranceTaxe(((ConsultationActes)var2.get(var3)).getCslactAssuranceTaxe());
                  var1.setLigCodeTva(((ConsultationActes)var2.get(var3)).getCslactCodeTva());
                  var1.setLigCoef(((ConsultationActes)var2.get(var3)).getCslactCoef());
                  var1.setLigComplementaireHt(((ConsultationActes)var2.get(var3)).getCslactComplementaireHt());
                  var1.setLigComplementaireTaxe(((ConsultationActes)var2.get(var3)).getCslactComplementaireTaxe());
                  var1.setLigId(((ConsultationActes)var2.get(var3)).getCslactId());
                  var1.setLigLettre(((ConsultationActes)var2.get(var3)).getCslactLettre());
                  var1.setLigLibelle(((ConsultationActes)var2.get(var3)).getCslactLibelle());
                  var1.setLigNb(((ConsultationActes)var2.get(var3)).getCslactNb());
                  var1.setLigNbCnamgs(((ConsultationActes)var2.get(var3)).getCslactNbCnamgs());
                  var1.setLigPatientHt(((ConsultationActes)var2.get(var3)).getCslactPatientHt());
                  var1.setLigPatientTaxe(((ConsultationActes)var2.get(var3)).getCslactPatientTaxe());
                  var1.setLigProduit(((ConsultationActes)var2.get(var3)).getCslactProduit());
                  var1.setLigPu(((ConsultationActes)var2.get(var3)).getCslactPu());
                  var1.setLigPuAssurance(((ConsultationActes)var2.get(var3)).getCslactPuAssurance());
                  var1.setLigPuCnamgs(((ConsultationActes)var2.get(var3)).getCslactPuCnamgs());
                  var1.setLigPuRem(((ConsultationActes)var2.get(var3)).getCslactPuRem());
                  var1.setLigQte(((ConsultationActes)var2.get(var3)).getCslactQte());
                  var1.setLigRabais(((ConsultationActes)var2.get(var3)).getCslactRabais());
                  var1.setLigRegPatient(((ConsultationActes)var2.get(var3)).getCslactRegPatient());
                  var1.setLigRegTiers(((ConsultationActes)var2.get(var3)).getCslactRegTiers());
                  var1.setLigRemise(((ConsultationActes)var2.get(var3)).getCslactRemise());
                  var1.setLigSocieteHt(((ConsultationActes)var2.get(var3)).getCslactSocieteHt());
                  var1.setLigSocieteTaxe(((ConsultationActes)var2.get(var3)).getCslactSocieteTaxe());
                  var1.setLigTauxTva(((ConsultationActes)var2.get(var3)).getCslactTauxTva());
                  var1.setLigTaxe(((ConsultationActes)var2.get(var3)).getCslactTaxe());
                  var1.setLigTotal(((ConsultationActes)var2.get(var3)).getCslactTotal());
                  var1.setLigValeur(((ConsultationActes)var2.get(var3)).getCslactValeur());
                  var1.setLigValeurCnamgs(((ConsultationActes)var2.get(var3)).getCslactValeurCnamgs());
                  this.prixCnamgs += ((ConsultationActes)var2.get(var3)).getCslactPuCnamgs();
                  this.lesLignesMedical.add(var1);
               }
            }

            this.datamodelLigne.setWrappedData(this.lesLignesMedical);
            this.showModalPanelDocument = true;
         } else if (this.pharmacieEntete != null) {
            this.patientDocument = this.pharmacieEntete.getPatients();
            this.nomPatientDocument = this.pharmacieEntete.getPhaNomPatient();
            this.numDocument = this.pharmacieEntete.getPhaNum();
            this.dateDocument = this.pharmacieEntete.getPhaDate();
            this.var_heure = "" + this.dateDocument.getHours();
            this.var_minute = "" + this.dateDocument.getMinutes();
            this.numFeuille = this.pharmacieEntete.getPhaFeuille();
            this.numBc = this.pharmacieEntete.getPhaNumBc();
            this.nomAgentFacturation = this.pharmacieEntete.getPhaNomCreateur();
            this.totalFacture = this.pharmacieEntete.getPhaTotGeneral();
            this.partPatient = this.pharmacieEntete.getTotalPatient();
            this.partTiers = this.pharmacieEntete.getTotalTiers();
            this.partTiersAssurance = this.pharmacieEntete.getPhaTotAssurance() + this.pharmacieEntete.getPhaTotTaxeAssurance();
            this.partTiersSociete = this.pharmacieEntete.getPhaTotSociete() + this.pharmacieEntete.getPhaTotTaxeSociete();
            this.partTiersComplementaire = this.pharmacieEntete.getPhaTotComplmentaire() + this.pharmacieEntete.getPhaTotTaxeComplementaire();
            new ArrayList();
            this.pharmacieLigneDao = new PharmacieLigneDao(this.baseLog, this.utilInitHibernate);
            var2 = this.pharmacieLigneDao.selectConsActesByConsEnt((PharmacieEntete)this.pharmacieEntete, (Session)null);
            if (var2.size() != 0) {
               for(var3 = 0; var3 < var2.size(); ++var3) {
                  var1 = new LigneMedical();
                  var1.setLigAssuranceHt(((PharmacieLigne)var2.get(var3)).getPhaligAssuranceHt());
                  var1.setLigAssuranceTaxe(((PharmacieLigne)var2.get(var3)).getPhaligAssuranceTaxe());
                  var1.setLigCodeTva(((PharmacieLigne)var2.get(var3)).getPhaligCodeTva());
                  var1.setLigCoef(((PharmacieLigne)var2.get(var3)).getPhaligCoef());
                  var1.setLigComplementaireHt(((PharmacieLigne)var2.get(var3)).getPhaligComplementaireHt());
                  var1.setLigComplementaireTaxe(((PharmacieLigne)var2.get(var3)).getPhaligComplementaireTaxe());
                  var1.setLigId(((PharmacieLigne)var2.get(var3)).getPhaligId());
                  var1.setLigLettre("");
                  var1.setLigLibelle(((PharmacieLigne)var2.get(var3)).getPhaligLibelle());
                  var1.setLigNb(0.0F);
                  var1.setLigNbCnamgs(0.0F);
                  var1.setLigPatientHt(((PharmacieLigne)var2.get(var3)).getPhaligPatientHt());
                  var1.setLigPatientTaxe(((PharmacieLigne)var2.get(var3)).getPhaligPatientTaxe());
                  var1.setLigProduit(((PharmacieLigne)var2.get(var3)).getPhaligProduit());
                  var1.setLigPu(((PharmacieLigne)var2.get(var3)).getPhaligPu());
                  var1.setLigPuAssurance(((PharmacieLigne)var2.get(var3)).getPhaligPuAssurance());
                  var1.setLigPuCnamgs(((PharmacieLigne)var2.get(var3)).getPhaligPuCnamgs());
                  var1.setLigPuRem(((PharmacieLigne)var2.get(var3)).getPhaligPuRem());
                  var1.setLigQte(((PharmacieLigne)var2.get(var3)).getPhaligQte());
                  var1.setLigRabais(((PharmacieLigne)var2.get(var3)).getPhaligRabais());
                  var1.setLigRegPatient(((PharmacieLigne)var2.get(var3)).getPhaligRegPatient());
                  var1.setLigRegTiers(((PharmacieLigne)var2.get(var3)).getPhaligRegTiers());
                  var1.setLigRemise(((PharmacieLigne)var2.get(var3)).getPhaligRemise());
                  var1.setLigSocieteHt(((PharmacieLigne)var2.get(var3)).getPhaligSocieteHt());
                  var1.setLigSocieteTaxe(((PharmacieLigne)var2.get(var3)).getPhaligSocieteTaxe());
                  var1.setLigTauxTva(((PharmacieLigne)var2.get(var3)).getPhaligTauxTva());
                  var1.setLigTaxe(((PharmacieLigne)var2.get(var3)).getPhaligTaxe());
                  var1.setLigTotal(((PharmacieLigne)var2.get(var3)).getPhaligTotal());
                  var1.setLigValeur(0.0D);
                  var1.setLigValeurCnamgs(0.0D);
                  this.prixCnamgs += ((PharmacieLigne)var2.get(var3)).getPhaligPuCnamgs();
                  this.lesLignesMedical.add(var1);
               }
            }

            this.datamodelLigne.setWrappedData(this.lesLignesMedical);
            this.showModalPanelDocument = true;
         } else if (this.laboratoireEntete != null) {
            this.patientDocument = this.laboratoireEntete.getPatients();
            this.nomPatientDocument = this.laboratoireEntete.getLabNomPatient();
            this.numDocument = this.laboratoireEntete.getLabNum();
            this.dateDocument = this.laboratoireEntete.getLabDate();
            this.var_heure = "" + this.dateDocument.getHours();
            this.var_minute = "" + this.dateDocument.getMinutes();
            this.numFeuille = this.laboratoireEntete.getLabFeuille();
            this.numBc = this.laboratoireEntete.getLabNumBc();
            this.nomAgentFacturation = this.laboratoireEntete.getLabNomCreateur();
            this.totalFacture = this.laboratoireEntete.getLabTotGeneral();
            this.partPatient = this.laboratoireEntete.getTotalPatient();
            this.partTiers = this.laboratoireEntete.getTotalTiers();
            this.partTiersAssurance = this.laboratoireEntete.getLabTotAssurance() + this.laboratoireEntete.getLabTotTaxeAssurance();
            this.partTiersSociete = this.laboratoireEntete.getLabTotSociete() + this.laboratoireEntete.getLabTotTaxeSociete();
            this.partTiersComplementaire = this.laboratoireEntete.getLabTotComplmentaire() + this.laboratoireEntete.getLabTotTaxeComplementaire();
            new ArrayList();
            this.laboratoireLigneDao = new LaboratoireLigneDao(this.baseLog, this.utilInitHibernate);
            var2 = this.laboratoireLigneDao.selectConsActesByConsEnt(this.laboratoireEntete, (Session)null);
            if (var2.size() != 0) {
               for(var3 = 0; var3 < var2.size(); ++var3) {
                  var1 = new LigneMedical();
                  var1.setLigAssuranceHt(((LaboratoireLigne)var2.get(var3)).getLabligAssuranceHt());
                  var1.setLigAssuranceTaxe(((LaboratoireLigne)var2.get(var3)).getLabligAssuranceTaxe());
                  var1.setLigCodeTva(((LaboratoireLigne)var2.get(var3)).getLabligCodeTva());
                  var1.setLigCoef(((LaboratoireLigne)var2.get(var3)).getLabligCoef());
                  var1.setLigComplementaireHt(((LaboratoireLigne)var2.get(var3)).getLabligComplementaireHt());
                  var1.setLigComplementaireTaxe(((LaboratoireLigne)var2.get(var3)).getLabligComplementaireTaxe());
                  var1.setLigId(((LaboratoireLigne)var2.get(var3)).getLabligId());
                  var1.setLigLettre(((LaboratoireLigne)var2.get(var3)).getLabligLettre());
                  var1.setLigLibelle(((LaboratoireLigne)var2.get(var3)).getLabligLibelle());
                  var1.setLigNb(((LaboratoireLigne)var2.get(var3)).getLabligNb());
                  var1.setLigNbCnamgs(((LaboratoireLigne)var2.get(var3)).getLabligNbCnamgs());
                  var1.setLigPatientHt(((LaboratoireLigne)var2.get(var3)).getLabligPatientHt());
                  var1.setLigPatientTaxe(((LaboratoireLigne)var2.get(var3)).getLabligPatientTaxe());
                  var1.setLigProduit(((LaboratoireLigne)var2.get(var3)).getLabligProduit());
                  var1.setLigPu(((LaboratoireLigne)var2.get(var3)).getLabligPu());
                  var1.setLigPuAssurance(((LaboratoireLigne)var2.get(var3)).getLabligPuAssurance());
                  var1.setLigPuCnamgs(((LaboratoireLigne)var2.get(var3)).getLabligPuCnamgs());
                  var1.setLigPuRem(((LaboratoireLigne)var2.get(var3)).getLabligPuRem());
                  var1.setLigQte(((LaboratoireLigne)var2.get(var3)).getLabligQte());
                  var1.setLigRabais(((LaboratoireLigne)var2.get(var3)).getLabligRabais());
                  var1.setLigRegPatient(((LaboratoireLigne)var2.get(var3)).getLabligRegPatient());
                  var1.setLigRegTiers(((LaboratoireLigne)var2.get(var3)).getLabligRegTiers());
                  var1.setLigRemise(((LaboratoireLigne)var2.get(var3)).getLabligRemise());
                  var1.setLigSocieteHt(((LaboratoireLigne)var2.get(var3)).getLabligSocieteHt());
                  var1.setLigSocieteTaxe(((LaboratoireLigne)var2.get(var3)).getLabligSocieteTaxe());
                  var1.setLigTauxTva(((LaboratoireLigne)var2.get(var3)).getLabligTauxTva());
                  var1.setLigTaxe(((LaboratoireLigne)var2.get(var3)).getLabligTaxe());
                  var1.setLigTotal(((LaboratoireLigne)var2.get(var3)).getLabligTotal());
                  var1.setLigValeur(((LaboratoireLigne)var2.get(var3)).getLabligValeur());
                  var1.setLigValeurCnamgs(((LaboratoireLigne)var2.get(var3)).getLabligValeurCnamgs());
                  this.prixCnamgs += ((LaboratoireLigne)var2.get(var3)).getLabligPuCnamgs();
                  this.lesLignesMedical.add(var1);
               }
            }

            this.datamodelLigne.setWrappedData(this.lesLignesMedical);
            this.showModalPanelDocument = true;
         } else if (this.hospitalisationEntete != null) {
            this.patientDocument = this.hospitalisationEntete.getPatients();
            this.nomPatientDocument = this.hospitalisationEntete.getHosNomPatient();
            this.numDocument = this.hospitalisationEntete.getHosNum();
            this.dateDocument = this.hospitalisationEntete.getHosDateEntree();
            this.var_heure = "" + this.dateDocument.getHours();
            this.var_minute = "" + this.dateDocument.getMinutes();
            this.numFeuille = this.hospitalisationEntete.getHosFeuille();
            this.numBc = this.hospitalisationEntete.getHosNumBc();
            this.nomAgentFacturation = this.hospitalisationEntete.getHosNomCreateur();
            this.totalFacture = this.hospitalisationEntete.getHosTotGeneral();
            this.partPatient = this.hospitalisationEntete.getTotalPatient();
            this.partTiers = this.hospitalisationEntete.getTotalTiers();
            this.partTiersAssurance = this.hospitalisationEntete.getHosTotAssurance() + this.hospitalisationEntete.getHosTotTaxeAssurance();
            this.partTiersSociete = this.hospitalisationEntete.getHosTotSociete() + this.hospitalisationEntete.getHosTotTaxeSociete();
            this.partTiersComplementaire = this.hospitalisationEntete.getHosTotComplmentaire() + this.hospitalisationEntete.getHosTotTaxeComplementaire();
            new ArrayList();
            this.hospitalisationSejourDao = new HospitalisationSejourDao(this.baseLog, this.utilInitHibernate);
            var2 = this.hospitalisationSejourDao.selectSejourByEnt(this.hospitalisationEntete, (Session)null);
            if (var2.size() != 0) {
               for(var3 = 0; var3 < var2.size(); ++var3) {
                  var1 = new LigneMedical();
                  var1.setLigAssuranceHt(((HospitalisationSejour)var2.get(var3)).getHossejAssuranceHt());
                  var1.setLigAssuranceTaxe(((HospitalisationSejour)var2.get(var3)).getHossejAssuranceTaxe());
                  var1.setLigCodeTva(((HospitalisationSejour)var2.get(var3)).getHossejCodeTva());
                  var1.setLigCoef(0.0F);
                  var1.setLigComplementaireHt(((HospitalisationSejour)var2.get(var3)).getHossejComplementaireHt());
                  var1.setLigComplementaireTaxe(((HospitalisationSejour)var2.get(var3)).getHossejComplementaireTaxe());
                  var1.setLigId(((HospitalisationSejour)var2.get(var3)).getHossejId());
                  var1.setLigLettre("");
                  var1.setLigLibelle(((HospitalisationSejour)var2.get(var3)).getHossejLibelle());
                  var1.setLigNb(0.0F);
                  var1.setLigNbCnamgs(0.0F);
                  var1.setLigPatientHt(((HospitalisationSejour)var2.get(var3)).getHossejPatientHt());
                  var1.setLigPatientTaxe(((HospitalisationSejour)var2.get(var3)).getHossejPatientTaxe());
                  var1.setLigProduit(((HospitalisationSejour)var2.get(var3)).getHossejLit());
                  var1.setLigPu(((HospitalisationSejour)var2.get(var3)).getHossejPu());
                  var1.setLigPuAssurance(((HospitalisationSejour)var2.get(var3)).getHossejPuAssurance());
                  var1.setLigPuCnamgs(((HospitalisationSejour)var2.get(var3)).getHossejPuCnamgs());
                  var1.setLigPuRem(((HospitalisationSejour)var2.get(var3)).getHossejPuRem());
                  var1.setLigQte((float)((HospitalisationSejour)var2.get(var3)).getHossejNbJour());
                  var1.setLigRabais(((HospitalisationSejour)var2.get(var3)).getHossejRabais());
                  var1.setLigRegPatient(((HospitalisationSejour)var2.get(var3)).getHossejRegPatient());
                  var1.setLigRegTiers(((HospitalisationSejour)var2.get(var3)).getHossejRegTiers());
                  var1.setLigRemise(((HospitalisationSejour)var2.get(var3)).getHossejRemise());
                  var1.setLigSocieteHt(((HospitalisationSejour)var2.get(var3)).getHossejSocieteHt());
                  var1.setLigSocieteTaxe(((HospitalisationSejour)var2.get(var3)).getHossejSocieteTaxe());
                  var1.setLigTauxTva(((HospitalisationSejour)var2.get(var3)).getHossejTauxTva());
                  var1.setLigTaxe(((HospitalisationSejour)var2.get(var3)).getHossejTaxe());
                  var1.setLigTotal(((HospitalisationSejour)var2.get(var3)).getHossejTotal());
                  var1.setLigValeur(0.0D);
                  var1.setLigValeurCnamgs(0.0D);
                  this.prixCnamgs += ((HospitalisationSejour)var2.get(var3)).getHossejPuCnamgs();
                  this.lesLignesMedical.add(var1);
               }
            }

            new ArrayList();
            this.hospitalisationActesDao = new HospitalisationActesDao(this.baseLog, this.utilInitHibernate);
            List var9 = this.hospitalisationActesDao.selectActesByEnt(this.hospitalisationEntete, (Session)null);
            if (var9.size() != 0) {
               for(int var4 = 0; var4 < var9.size(); ++var4) {
                  var1 = new LigneMedical();
                  var1.setLigAssuranceHt(((HospitalisationActes)var9.get(var4)).getHosactAssuranceHt());
                  var1.setLigAssuranceTaxe(((HospitalisationActes)var9.get(var4)).getHosactAssuranceTaxe());
                  var1.setLigCodeTva(((HospitalisationActes)var9.get(var4)).getHosactCodeTva());
                  var1.setLigCoef(((HospitalisationActes)var9.get(var4)).getHosactCoef());
                  var1.setLigComplementaireHt(((HospitalisationActes)var9.get(var4)).getHosactComplementaireHt());
                  var1.setLigComplementaireTaxe(((HospitalisationActes)var9.get(var4)).getHosactComplementaireTaxe());
                  var1.setLigId(((HospitalisationActes)var9.get(var4)).getHosactId());
                  var1.setLigLettre(((HospitalisationActes)var9.get(var4)).getHosactLettre());
                  var1.setLigLibelle(((HospitalisationActes)var9.get(var4)).getHosactLibelle());
                  var1.setLigNb(((HospitalisationActes)var9.get(var4)).getHosactNb());
                  var1.setLigNbCnamgs(((HospitalisationActes)var9.get(var4)).getHosactNbCnamgs());
                  var1.setLigPatientHt(((HospitalisationActes)var9.get(var4)).getHosactPatientHt());
                  var1.setLigPatientTaxe(((HospitalisationActes)var9.get(var4)).getHosactPatientTaxe());
                  var1.setLigProduit(((HospitalisationActes)var9.get(var4)).getHosactProduit());
                  var1.setLigPu(((HospitalisationActes)var9.get(var4)).getHosactPu());
                  var1.setLigPuAssurance(((HospitalisationActes)var9.get(var4)).getHosactPuAssurance());
                  var1.setLigPuCnamgs(((HospitalisationActes)var9.get(var4)).getHosactPuCnamgs());
                  var1.setLigPuRem(((HospitalisationActes)var9.get(var4)).getHosactPuRem());
                  var1.setLigQte(((HospitalisationActes)var9.get(var4)).getHosactQte());
                  var1.setLigRabais(((HospitalisationActes)var9.get(var4)).getHosactRabais());
                  var1.setLigRegPatient(((HospitalisationActes)var9.get(var4)).getHosactRegPatient());
                  var1.setLigRegTiers(((HospitalisationActes)var9.get(var4)).getHosactRegTiers());
                  var1.setLigRemise(((HospitalisationActes)var9.get(var4)).getHosactRemise());
                  var1.setLigSocieteHt(((HospitalisationActes)var9.get(var4)).getHosactSocieteHt());
                  var1.setLigSocieteTaxe(((HospitalisationActes)var9.get(var4)).getHosactSocieteTaxe());
                  var1.setLigTauxTva(((HospitalisationActes)var9.get(var4)).getHosactTauxTva());
                  var1.setLigTaxe(((HospitalisationActes)var9.get(var4)).getHosactTaxe());
                  var1.setLigTotal(((HospitalisationActes)var9.get(var4)).getHosactTotal());
                  var1.setLigValeur(((HospitalisationActes)var9.get(var4)).getHosactValeur());
                  var1.setLigValeurCnamgs(((HospitalisationActes)var9.get(var4)).getHosactValeurCnamgs());
                  this.prixCnamgs += ((HospitalisationActes)var9.get(var4)).getHosactPuCnamgs();
                  this.lesLignesMedical.add(var1);
               }
            }

            new ArrayList();
            this.hospitalisationLaboDao = new HospitalisationLaboDao(this.baseLog, this.utilInitHibernate);
            List var8 = this.hospitalisationLaboDao.selectLaboByEnt(this.hospitalisationEntete, (Session)null);
            if (var8.size() != 0) {
               for(int var5 = 0; var5 < var8.size(); ++var5) {
                  var1 = new LigneMedical();
                  var1.setLigAssuranceHt(((HospitalisationLabo)var8.get(var5)).getHoslabAssuranceHt());
                  var1.setLigAssuranceTaxe(((HospitalisationLabo)var8.get(var5)).getHoslabAssuranceTaxe());
                  var1.setLigCodeTva(((HospitalisationLabo)var8.get(var5)).getHoslabCodeTva());
                  var1.setLigCoef(((HospitalisationLabo)var8.get(var5)).getHoslabCoef());
                  var1.setLigComplementaireHt(((HospitalisationLabo)var8.get(var5)).getHoslabComplementaireHt());
                  var1.setLigComplementaireTaxe(((HospitalisationLabo)var8.get(var5)).getHoslabComplementaireTaxe());
                  var1.setLigId(((HospitalisationLabo)var8.get(var5)).getHoslabId());
                  var1.setLigLettre(((HospitalisationLabo)var8.get(var5)).getHoslabLettre());
                  var1.setLigLibelle(((HospitalisationLabo)var8.get(var5)).getHoslabLibelle());
                  var1.setLigNb(((HospitalisationLabo)var8.get(var5)).getHoslabNb());
                  var1.setLigNbCnamgs(((HospitalisationLabo)var8.get(var5)).getHoslabNbCnamgs());
                  var1.setLigPatientHt(((HospitalisationLabo)var8.get(var5)).getHoslabPatientHt());
                  var1.setLigPatientTaxe(((HospitalisationLabo)var8.get(var5)).getHoslabPatientTaxe());
                  var1.setLigProduit(((HospitalisationLabo)var8.get(var5)).getHoslabProduit());
                  var1.setLigPu(((HospitalisationLabo)var8.get(var5)).getHoslabPu());
                  var1.setLigPuAssurance(((HospitalisationLabo)var8.get(var5)).getHoslabPuAssurance());
                  var1.setLigPuCnamgs(((HospitalisationLabo)var8.get(var5)).getHoslabPuCnamgs());
                  var1.setLigPuRem(((HospitalisationLabo)var8.get(var5)).getHoslabPuRem());
                  var1.setLigQte(((HospitalisationLabo)var8.get(var5)).getHoslabQte());
                  var1.setLigRabais(((HospitalisationLabo)var8.get(var5)).getHoslabRabais());
                  var1.setLigRegPatient(((HospitalisationLabo)var8.get(var5)).getHoslabRegPatient());
                  var1.setLigRegTiers(((HospitalisationLabo)var8.get(var5)).getHoslabRegTiers());
                  var1.setLigRemise(((HospitalisationLabo)var8.get(var5)).getHoslabRemise());
                  var1.setLigSocieteHt(((HospitalisationLabo)var8.get(var5)).getHoslabSocieteHt());
                  var1.setLigSocieteTaxe(((HospitalisationLabo)var8.get(var5)).getHoslabSocieteTaxe());
                  var1.setLigTauxTva(((HospitalisationLabo)var8.get(var5)).getHoslabTauxTva());
                  var1.setLigTaxe(((HospitalisationLabo)var8.get(var5)).getHoslabTaxe());
                  var1.setLigTotal(((HospitalisationLabo)var8.get(var5)).getHoslabTotal());
                  var1.setLigValeur(((HospitalisationLabo)var8.get(var5)).getHoslabValeur());
                  var1.setLigValeurCnamgs(((HospitalisationLabo)var8.get(var5)).getHoslabValeurCnamgs());
                  this.prixCnamgs += ((HospitalisationLabo)var8.get(var5)).getHoslabPuCnamgs();
                  this.lesLignesMedical.add(var1);
               }
            }

            new ArrayList();
            this.hospitalisationMediDao = new HospitalisationMediDao(this.baseLog, this.utilInitHibernate);
            List var10 = this.hospitalisationMediDao.selectMediByEnt(this.hospitalisationEntete, (Session)null);
            if (var10.size() != 0) {
               for(int var6 = 0; var6 < var10.size(); ++var6) {
                  var1 = new LigneMedical();
                  var1.setLigAssuranceHt(((HospitalisationMedi)var10.get(var6)).getHosmedAssuranceHt());
                  var1.setLigAssuranceTaxe(((HospitalisationMedi)var10.get(var6)).getHosmedAssuranceTaxe());
                  var1.setLigCodeTva(((HospitalisationMedi)var10.get(var6)).getHosmedCodeTva());
                  var1.setLigCoef(((HospitalisationMedi)var10.get(var6)).getHosmedCoef());
                  var1.setLigComplementaireHt(((HospitalisationMedi)var10.get(var6)).getHosmedComplementaireHt());
                  var1.setLigComplementaireTaxe(((HospitalisationMedi)var10.get(var6)).getHosmedComplementaireTaxe());
                  var1.setLigId(((HospitalisationMedi)var10.get(var6)).getHosmedId());
                  var1.setLigLettre("");
                  var1.setLigLibelle(((HospitalisationMedi)var10.get(var6)).getHosmedLibelle());
                  var1.setLigNb(0.0F);
                  var1.setLigNbCnamgs(0.0F);
                  var1.setLigPatientHt(((HospitalisationMedi)var10.get(var6)).getHosmedPatientHt());
                  var1.setLigPatientTaxe(((HospitalisationMedi)var10.get(var6)).getHosmedPatientTaxe());
                  var1.setLigProduit(((HospitalisationMedi)var10.get(var6)).getHosmedProduit());
                  var1.setLigPu(((HospitalisationMedi)var10.get(var6)).getHosmedPu());
                  var1.setLigPuAssurance(((HospitalisationMedi)var10.get(var6)).getHosmedPuAssurance());
                  var1.setLigPuCnamgs(((HospitalisationMedi)var10.get(var6)).getHosmedPuCnamgs());
                  var1.setLigPuRem(((HospitalisationMedi)var10.get(var6)).getHosmedPuRem());
                  var1.setLigQte(((HospitalisationMedi)var10.get(var6)).getHosmedQte());
                  var1.setLigRabais(((HospitalisationMedi)var10.get(var6)).getHosmedRabais());
                  var1.setLigRegPatient(((HospitalisationMedi)var10.get(var6)).getHosmedRegPatient());
                  var1.setLigRegTiers(((HospitalisationMedi)var10.get(var6)).getHosmedRegTiers());
                  var1.setLigRemise(((HospitalisationMedi)var10.get(var6)).getHosmedRemise());
                  var1.setLigSocieteHt(((HospitalisationMedi)var10.get(var6)).getHosmedSocieteHt());
                  var1.setLigSocieteTaxe(((HospitalisationMedi)var10.get(var6)).getHosmedSocieteTaxe());
                  var1.setLigTauxTva(((HospitalisationMedi)var10.get(var6)).getHosmedTauxTva());
                  var1.setLigTaxe(((HospitalisationMedi)var10.get(var6)).getHosmedTaxe());
                  var1.setLigTotal(((HospitalisationMedi)var10.get(var6)).getHosmedTotal());
                  var1.setLigValeur(0.0D);
                  var1.setLigValeurCnamgs(0.0D);
                  this.prixCnamgs += ((HospitalisationMedi)var10.get(var6)).getHosmedPuCnamgs();
                  this.lesLignesMedical.add(var1);
               }
            }

            new ArrayList();
            this.hospitalisationPrestDao = new HospitalisationPrestDao(this.baseLog, this.utilInitHibernate);
            List var11 = this.hospitalisationPrestDao.selectPrestByEnt(this.hospitalisationEntete, (Session)null);
            if (var11.size() != 0) {
               for(int var7 = 0; var7 < var11.size(); ++var7) {
                  var1 = new LigneMedical();
                  var1.setLigAssuranceHt(((HospitalisationPrest)var11.get(var7)).getHosprtAssuranceHt());
                  var1.setLigAssuranceTaxe(((HospitalisationPrest)var11.get(var7)).getHosprtAssuranceTaxe());
                  var1.setLigCodeTva(((HospitalisationPrest)var11.get(var7)).getHosprtCodeTva());
                  var1.setLigCoef(((HospitalisationPrest)var11.get(var7)).getHosprtCoef());
                  var1.setLigComplementaireHt(((HospitalisationPrest)var11.get(var7)).getHosprtComplementaireHt());
                  var1.setLigComplementaireTaxe(((HospitalisationPrest)var11.get(var7)).getHosprtComplementaireTaxe());
                  var1.setLigId(((HospitalisationPrest)var11.get(var7)).getHosprtId());
                  var1.setLigLettre(((HospitalisationPrest)var11.get(var7)).getHosprtLettre());
                  var1.setLigLibelle(((HospitalisationPrest)var11.get(var7)).getHosprtLibelle());
                  var1.setLigNb(((HospitalisationPrest)var11.get(var7)).getHosprtNb());
                  var1.setLigNbCnamgs(((HospitalisationPrest)var11.get(var7)).getHosprtNbCnamgs());
                  var1.setLigPatientHt(((HospitalisationPrest)var11.get(var7)).getHosprtPatientHt());
                  var1.setLigPatientTaxe(((HospitalisationPrest)var11.get(var7)).getHosprtPatientTaxe());
                  var1.setLigProduit(((HospitalisationPrest)var11.get(var7)).getHosprtProduit());
                  var1.setLigPu(((HospitalisationPrest)var11.get(var7)).getHosprtPu());
                  var1.setLigPuAssurance(((HospitalisationPrest)var11.get(var7)).getHosprtPuAssurance());
                  var1.setLigPuCnamgs(((HospitalisationPrest)var11.get(var7)).getHosprtPuCnamgs());
                  var1.setLigPuRem(((HospitalisationPrest)var11.get(var7)).getHosprtPuRem());
                  var1.setLigQte(((HospitalisationPrest)var11.get(var7)).getHosprtQte());
                  var1.setLigRabais(((HospitalisationPrest)var11.get(var7)).getHosprtRabais());
                  var1.setLigRegPatient(((HospitalisationPrest)var11.get(var7)).getHosprtRegPatient());
                  var1.setLigRegTiers(((HospitalisationPrest)var11.get(var7)).getHosprtRegTiers());
                  var1.setLigRemise(((HospitalisationPrest)var11.get(var7)).getHosprtRemise());
                  var1.setLigSocieteHt(((HospitalisationPrest)var11.get(var7)).getHosprtSocieteHt());
                  var1.setLigSocieteTaxe(((HospitalisationPrest)var11.get(var7)).getHosprtSocieteTaxe());
                  var1.setLigTauxTva(((HospitalisationPrest)var11.get(var7)).getHosprtTauxTva());
                  var1.setLigTaxe(((HospitalisationPrest)var11.get(var7)).getHosprtTaxe());
                  var1.setLigTotal(((HospitalisationPrest)var11.get(var7)).getHosprtTotal());
                  var1.setLigValeur(((HospitalisationPrest)var11.get(var7)).getHosprtValeur());
                  var1.setLigValeurCnamgs(((HospitalisationPrest)var11.get(var7)).getHosprtValeurCnamgs());
                  this.prixCnamgs += ((HospitalisationPrest)var11.get(var7)).getHosprtPuCnamgs();
                  this.lesLignesMedical.add(var1);
               }
            }

            this.datamodelLigne.setWrappedData(this.lesLignesMedical);
            this.showModalPanelDocument = true;
         }
      }

   }

   public void fermerChangerdocumentCtrl() {
      this.showModalPanelDocument = false;
   }

   public void validerChangerDocumentCtrl() throws HibernateException, NamingException, ParseException {
      if (this.documentMedical != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            boolean var3 = false;
            if (this.documentMedical.getDocNature() == 71 && this.consultationEnteteGene != null) {
               if (this.patientDocument.getPatId() != this.consultationEnteteGene.getPatients().getPatId()) {
                  var3 = true;
               }

               this.consultationEnteteGene.setPatients(this.patientDocument);
               this.consultationEnteteGene.setCsgIdPatient(this.patientDocument.getPatId());
               this.consultationEnteteGene.setCsgCivilite(this.patientDocument.getPatCivilite());
               this.consultationEnteteGene.setCsgNomPatient(this.patientDocument.getPatronyme());
               this.consultationEnteteGene.setCsgDate(this.utilDate.dateToSQL(this.dateDocument, this.var_heure, this.var_minute, "00"));
               this.consultationEnteteGene.setCsgFeuille(this.numFeuille);
               this.consultationEnteteGene.setCsgNumBc(this.numBc);
               this.consultationEnteteGene.setCsgFondCnamgs(this.fondsCnamgs);
               this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
               this.documentMedical.setDocFeuille(this.numFeuille);
               this.documentMedical.setDocFondCnamgs(this.fondsCnamgs);
               this.documentMedical.setDocDate(this.dateDocument);
               this.documentMedical.setDocNomPatient(this.patientDocument.getPatronyme());
               this.documentMedical.setDocCivilite(this.patientDocument.getPatCivilite());
               if (var3) {
                  this.changePatientReglementConsultation(var1);
               }
            } else if (this.documentMedical.getDocNature() == 73 && this.pharmacieEntete != null) {
               if (this.patientDocument.getPatId() != this.pharmacieEntete.getPatients().getPatId()) {
                  var3 = true;
               }

               this.pharmacieEntete.setPatients(this.patientDocument);
               this.pharmacieEntete.setPhaIdPatient(this.patientDocument.getPatId());
               this.pharmacieEntete.setPhaCivilite(this.patientDocument.getPatCivilite());
               this.pharmacieEntete.setPhaNomPatient(this.patientDocument.getPatronyme());
               this.pharmacieEntete.setPhaDate(this.utilDate.dateToSQL(this.dateDocument, this.var_heure, this.var_minute, "00"));
               this.pharmacieEntete.setPhaFeuille(this.numFeuille);
               this.pharmacieEntete.setPhaNumBc(this.numBc);
               this.pharmacieEntete.setPhaFondCnamgs(this.fondsCnamgs);
               this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
               this.documentMedical.setDocFeuille(this.numFeuille);
               this.documentMedical.setDocFondCnamgs(this.fondsCnamgs);
               this.documentMedical.setDocDate(this.dateDocument);
               this.documentMedical.setDocNomPatient(this.patientDocument.getPatronyme());
               this.documentMedical.setDocCivilite(this.patientDocument.getPatCivilite());
               if (var3) {
                  this.changePatientReglementPharmacie(var1);
               }
            } else if (this.documentMedical.getDocNature() == 74 && this.laboratoireEntete != null) {
               if (this.patientDocument.getPatId() != this.laboratoireEntete.getPatients().getPatId()) {
                  var3 = true;
               }

               this.laboratoireEntete.setPatients(this.patientDocument);
               this.laboratoireEntete.setLabIdPatient(this.patientDocument.getPatId());
               this.laboratoireEntete.setLabCivilite(this.patientDocument.getPatCivilite());
               this.laboratoireEntete.setLabNomPatient(this.patientDocument.getPatronyme());
               this.laboratoireEntete.setLabDate(this.utilDate.dateToSQL(this.dateDocument, this.var_heure, this.var_minute, "00"));
               this.laboratoireEntete.setLabFeuille(this.numFeuille);
               this.laboratoireEntete.setLabNumBc(this.numBc);
               this.laboratoireEntete.setLabFondCnamgs(this.fondsCnamgs);
               this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
               this.documentMedical.setDocFeuille(this.numFeuille);
               this.documentMedical.setDocFondCnamgs(this.fondsCnamgs);
               this.documentMedical.setDocDate(this.dateDocument);
               this.documentMedical.setDocNomPatient(this.patientDocument.getPatronyme());
               this.documentMedical.setDocCivilite(this.patientDocument.getPatCivilite());
               if (var3) {
                  this.changePatientReglementLaboratoire(var1);
               }
            } else if (this.documentMedical.getDocNature() == 76 && this.hospitalisationEntete != null) {
               if (this.patientDocument.getPatId() != this.hospitalisationEntete.getPatients().getPatId()) {
                  var3 = true;
               }

               this.hospitalisationEntete.setPatients(this.patientDocument);
               this.hospitalisationEntete.setHosIdPatient(this.patientDocument.getPatId());
               this.hospitalisationEntete.setHosCivilite(this.patientDocument.getPatCivilite());
               this.hospitalisationEntete.setHosNomPatient(this.patientDocument.getPatronyme());
               this.hospitalisationEntete.setHosDateEntree(this.utilDate.dateToSQL(this.dateDocument, this.var_heure, this.var_minute, "00"));
               this.hospitalisationEntete.setHosFeuille(this.numFeuille);
               this.hospitalisationEntete.setHosNumBc(this.numBc);
               this.hospitalisationEntete.setHosFondCnamgs(this.fondsCnamgs);
               this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
               this.documentMedical.setDocFeuille(this.numFeuille);
               this.documentMedical.setDocFondCnamgs(this.fondsCnamgs);
               this.documentMedical.setDocDate(this.dateDocument);
               this.documentMedical.setDocNomPatient(this.patientDocument.getPatronyme());
               this.documentMedical.setDocCivilite(this.patientDocument.getPatCivilite());
               if (var3) {
                  this.changePatientReglementHospitalisation(var1);
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
      }

      this.showModalPanelDocument = false;
   }

   public void changePatientReglementConsultation(Session var1) throws HibernateException, NamingException {
      if (this.consultationEnteteGene != null) {
         new ArrayList();
         List var2 = this.reglementsDao.findRegByNatNum(71, this.consultationEnteteGene.getCsgNum(), var1);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               this.reglements = (Reglements)var2.get(var3);
               this.reglements.setRglIdTiers(this.patientDocument.getPatId());
               this.reglements.setRglNomTiers(this.patientDocument.getPatronyme());
               this.reglements = this.reglementsDao.modifierReg(this.reglements, var1);
            }
         }
      }

   }

   public void changePatientReglementPharmacie(Session var1) throws HibernateException, NamingException {
      if (this.pharmacieEntete != null) {
         new ArrayList();
         List var2 = this.reglementsDao.findRegByNatNum(73, this.pharmacieEntete.getPhaNum(), var1);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               this.reglements = (Reglements)var2.get(var3);
               this.reglements.setRglIdTiers(this.patientDocument.getPatId());
               this.reglements.setRglNomTiers(this.patientDocument.getPatronyme());
               this.reglements = this.reglementsDao.modifierReg(this.reglements, var1);
            }
         }
      }

   }

   public void changePatientReglementLaboratoire(Session var1) throws HibernateException, NamingException {
      if (this.laboratoireEntete != null) {
         new ArrayList();
         List var2 = this.reglementsDao.findRegByNatNum(74, this.laboratoireEntete.getLabNum(), var1);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               this.reglements = (Reglements)var2.get(var3);
               this.reglements.setRglIdTiers(this.patientDocument.getPatId());
               this.reglements.setRglNomTiers(this.patientDocument.getPatronyme());
               this.reglements = this.reglementsDao.modifierReg(this.reglements, var1);
            }
         }
      }

   }

   public void changePatientReglementHospitalisation(Session var1) throws HibernateException, NamingException {
      if (this.hospitalisationEntete != null) {
         new ArrayList();
         List var2 = this.reglementsDao.findRegByNatNum(76, this.hospitalisationEntete.getHosNum(), var1);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               this.reglements = (Reglements)var2.get(var3);
               this.reglements.setRglIdTiers(this.patientDocument.getPatId());
               this.reglements.setRglNomTiers(this.patientDocument.getPatronyme());
               this.reglements = this.reglementsDao.modifierReg(this.reglements, var1);
            }
         }
      }

   }

   public void calculeDateNaissance() {
      this.nbAnnee = 0;
      this.nbMois = 0;
      this.nbJours = 0;
      this.nevers = 0;
      this.showModalPanelCalculDateNaissance = true;
   }

   public void fermerCalculDateNaissance() {
      this.showModalPanelCalculDateNaissance = false;
   }

   public void valideCalculDateNaissance() throws ParseException {
      boolean var1 = false;
      int var2 = 0;
      int var3 = 0;
      int var7;
      if (this.nevers != 0) {
         var7 = this.nevers;
      } else {
         var7 = (new Date()).getYear() + 1900 - this.nbAnnee;
         boolean var8 = false;
         if (this.nbMois == 0) {
            var2 = (new Date()).getMonth() + 1;
         } else {
            var2 = this.nbMois;
         }

         if (var2 <= 0) {
            var2 = 1;
         }

         if (this.nbJours == 0) {
            var3 = (new Date()).getDay() + 1;
         } else {
            var3 = this.nbJours;
         }

         if (var3 <= 0) {
            var3 = 1;
         }
      }

      String var4 = "";
      if (var2 <= 9) {
         var4 = "0" + var2;
      } else {
         var4 = "" + var2;
      }

      String var5 = "";
      if (var3 <= 9) {
         var5 = "0" + var3;
      } else {
         var5 = "" + var3;
      }

      String var6 = var7 + "-" + var4 + "-" + var5;
      this.patients.setPatDateNaissance(this.utilDate.stringToDateSQLLight(var6));
      this.showModalPanelCalculDateNaissance = false;
   }

   public void calculeGenre() {
      if (this.patients.getPatCivilite() != null && !this.patients.getPatCivilite().isEmpty()) {
         if (!this.patients.getPatCivilite().equals("Madame") && !this.patients.getPatCivilite().equals("Mademoiselle")) {
            this.patients.setPatSexe(1);
         } else {
            this.patients.setPatSexe(0);
         }
      } else {
         this.patients.setPatSexe(1);
      }

      if (this.patients.getPatCivilite() == null || this.patients.getPatCivilite().isEmpty() || !this.patients.getPatCivilite().contains("Monsieur") && !this.patients.getPatCivilite().contains("Madame") && !this.patients.getPatCivilite().contains("Mademoiselle")) {
         this.verrouSexe = false;
      } else {
         this.verrouSexe = true;
      }

   }

   public void recupererCivilitesItem() throws IOException {
      this.mesCivilitesItems = new ArrayList();
      LectureCivilites var1 = new LectureCivilites(0);
      this.mesCivilitesItems = var1.getMesCivilitesItems();
   }

   public void googleMap() throws IOException, URISyntaxException {
      UtilGoogleMap var1 = new UtilGoogleMap(this.structureLog);
      this.uri = var1.calculMap(this.patients.getPatRue(), this.patients.getPatAdresse(), this.patients.getPatVille(), this.patients.getPatPays());
      this.showModalGoogleMap = true;
   }

   public void annuleGoogleMap() {
      this.showModalGoogleMap = false;
   }

   public void selectionLigneReglement() {
      if (this.datamodelRecu.isRowAvailable()) {
         this.reglements = (Reglements)this.datamodelRecu.getRowData();
         this.selectPatient = true;
      }

   }

   public void modifReglement() {
      if (this.reglements != null) {
         this.mesCaissesSeriesItems.clear();
         if (this.listCaisses.size() != 0) {
            for(int var1 = 0; var1 < this.listCaisses.size(); ++var1) {
               if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 61 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2)) {
                  this.mesCaissesSeriesItems.add(new SelectItem(((UsersChrono)this.listCaisses.get(var1)).getUsrchrCodeCaisse(), ((UsersChrono)this.listCaisses.get(var1)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)this.listCaisses.get(var1)).getUsrchrLib()));
               }
            }
         }

         this.dateDocument = this.reglements.getRglDateReg();
         this.var_inputCaisse = this.reglements.getRglCodeCaiss();
         this.showModalPanelReglementCtrl = true;
      }

   }

   public void fermerModifReglement() {
      this.selectPatient = false;
      this.showModalPanelReglementCtrl = false;
   }

   public void validerModifReglement() throws HibernateException, NamingException {
      if (this.reglements != null) {
         if (this.dateDocument != null) {
            this.reglements.setRglDateReg(this.dateDocument);
         }

         if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty()) {
            this.reglements.setRglCodeCaiss((String)null);
            this.reglements.setRglLibCaiss((String)null);

            for(int var1 = 0; var1 < this.mesCaissesSeriesItems.size(); ++var1) {
               if (((SelectItem)this.mesCaissesSeriesItems.get(var1)).getValue().toString().equals(this.var_inputCaisse)) {
                  String[] var2 = ((SelectItem)this.mesCaissesSeriesItems.get(var1)).getLabel().toString().split(":");
                  this.reglements.setRglCodeCaiss(var2[0]);
                  this.reglements.setRglLibCaiss(var2[1]);
                  break;
               }
            }
         } else {
            this.reglements.setRglCodeCaiss((String)null);
            this.reglements.setRglLibCaiss((String)null);
         }

         String var4 = "";
         if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
            var4 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
         } else {
            var4 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
         }

         String var5 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
         this.reglements.setRglPeriode(var4 + ":" + var5);
         this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
         String var3 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
         this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var3);
         this.reglements = this.reglementsDao.modifier(this.reglements);
      }

      this.selectPatient = false;
      this.showModalPanelReglementCtrl = false;
   }

   public void noteIncidentCtrl() {
      if (this.documentMedical != null) {
         this.showModalPanelNoteIncident = true;
      }

   }

   public void annuleNoteIncident() {
      this.documentMedical.setDocObs("");
      this.showModalPanelNoteIncident = false;
   }

   public void validerNoteIncident() throws HibernateException, NamingException {
      if (this.documentMedical.getDocNature() == 71) {
         this.consultationEnteteGene = this.consultationEnteteGeneDao.selectById(this.documentMedical.getDocId(), (Session)null);
         if (this.consultationEnteteGene != null) {
            this.consultationEnteteGene.setCsgObjet(this.documentMedical.getDocObs());
            this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene);
         }
      } else if (this.documentMedical.getDocNature() == 73) {
         this.pharmacieEntete = this.pharmacieEnteteDao.selectById(this.documentMedical.getDocId(), (Session)null);
         if (this.pharmacieEntete != null) {
            this.pharmacieEntete.setPhaInfo10(this.documentMedical.getDocObs());
            this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete);
         }
      } else if (this.documentMedical.getDocNature() == 74) {
         this.laboratoireEntete = this.laboratoireEnteteDao.selectById(this.documentMedical.getDocId(), (Session)null);
         if (this.laboratoireEntete != null) {
            this.laboratoireEntete.setLabInfo10(this.documentMedical.getDocObs());
            this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete);
         }
      } else if (this.documentMedical.getDocNature() == 76) {
         this.hospitalisationEntete = this.hospitalisationEnteteDao.selectById(this.documentMedical.getDocId(), (Session)null);
         if (this.hospitalisationEntete != null) {
            this.hospitalisationEntete.setHosInfo10(this.documentMedical.getDocObs());
            this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete);
         }
      }

      this.showModalPanelNoteIncident = false;
   }

   public void cumulPrix() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = 0.0D;
      double var11 = 0.0D;
      if (this.lesLignesList.size() != 0) {
         new FactureLigneMedical();

         for(int var14 = 0; var14 < this.lesLignesList.size(); ++var14) {
            FactureLigneMedical var13 = (FactureLigneMedical)this.lesLignesList.get(var14);
            var3 += var13.getFacligPt();
            var5 += var13.getFacligTva();
            var7 += var13.getFacligTtc();
            var9 += var13.getFacligTc();
            if (var13.getFacligRabais() != 0.0D || var13.getFacligTauxRemise() != 0.0F) {
               var11 += var13.getFacligPu() * (double)var13.getFacligQte() - var13.getFacligPt();
            }
         }
      }

      this.var_total_marge = var1;
      this.factureEnteteMedical.setFacTotHt(var3);
      this.factureEnteteMedical.setFacTotTva(var5);
      this.factureEnteteMedical.setFacTotTtc(var7);
      this.factureEnteteMedical.setFacTotRemise(var11);
      this.factureEnteteMedical.setFacTotTc(var9);
   }

   public void selectionLigneDetail() throws HibernateException, NamingException {
      if (this.datamodelLigne.isRowAvailable()) {
         this.factureLigneMedical = (FactureLigneMedical)this.datamodelLigne.getRowData();
         this.griserchamps = false;
         this.griserValider = false;
      } else {
         this.griserchamps = false;
         this.griserValider = false;
      }

   }

   public void detailDocument() {
      if (this.factureLigneMedical != null) {
         this.showModalPanelConsultation = true;
         this.showModalPanelLaboratoire = true;
         this.showModalPanelPharmacie = true;
         this.showModalPanelHospitalisation = true;
         if (this.factureLigneMedical.getFacligIdConsultation() != 0L) {
            if (this.consultationEnteteGene != null) {
               this.chargementConsultation();
               this.showModalPanelConsultation = true;
            }
         } else if (this.factureLigneMedical.getFacligIdLaboratoire() != 0L) {
            if (this.laboratoireEntete != null) {
               this.chargementLaboratoire();
               this.showModalPanelLaboratoire = true;
            }
         } else if (this.factureLigneMedical.getFacligIdPharmacie() != 0L) {
            if (this.pharmacieEntete != null) {
               this.chargementPharmacie();
               this.showModalPanelPharmacie = true;
            }
         } else if ((this.factureLigneMedical.getFacligIdHospitalisationActe() != 0L || this.factureLigneMedical.getFacligIdHospitalisationLabo() != 0L || this.factureLigneMedical.getFacligIdHospitalisationMedic() != 0L || this.factureLigneMedical.getFacligIdHospitalisationPrest() != 0L || this.factureLigneMedical.getFacligIdHospitalisationSejour() != 0L) && this.hospitalisationEntete != null) {
            this.chargementHospitalisation();
            this.showModalPanelHospitalisation = true;
         }
      }

   }

   public void chargementConsultation() {
   }

   public void chargementLaboratoire() {
   }

   public void chargementPharmacie() {
   }

   public void chargementHospitalisation() {
   }

   public void ordonnnerDescendant() throws HibernateException, NamingException {
      this.selectionLigneDetail();
      if (this.factureLigneMedical != null) {
         this.numLigne = this.clauleNumlLigne() + 1;
         if (this.numLigne < this.lesLignesList.size()) {
            this.lesLignesList.remove(this.factureLigneMedical);
            this.lesLignesList.add(this.numLigne, this.factureLigneMedical);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "RefacturationMed");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.factureLigneMedical = (FactureLigneMedical)this.lesLignesList.get(var3);
               this.factureLigneMedical.setFacligOrdre(var3);
               this.factureLigneMedical = this.factureLigneMedicalDao.modifLigne(this.factureLigneMedical, var1);
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

   public void ordonnnerAscendant() throws HibernateException, NamingException {
      this.selectionLigneDetail();
      if (this.factureLigneMedical != null) {
         this.numLigne = this.clauleNumlLigne() - 1;
         if (this.numLigne != 0) {
            this.lesLignesList.remove(this.factureLigneMedical);
            this.lesLignesList.add(this.numLigne, this.factureLigneMedical);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "RefacturationMed");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.factureLigneMedical = (FactureLigneMedical)this.lesLignesList.get(var3);
               this.factureLigneMedical.setFacligOrdre(var3);
               this.factureLigneMedical = this.factureLigneMedicalDao.modifLigne(this.factureLigneMedical, var1);
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

   public int clauleNumlLigne() {
      int var1 = 0;
      if (this.lesLignesList.size() != 0) {
         for(int var2 = 0; var2 < this.lesLignesList.size(); ++var2) {
            if (this.factureLigneMedical.getFacligId() == ((FactureLigneMedical)this.lesLignesList.get(var2)).getFacligId()) {
               var1 = var2;
               break;
            }
         }
      }

      return var1;
   }

   public void verifBonEncaissement() {
      if (this.montantElmTotBonEnc <= this.factureEnteteMedical.getFacTotTtc() - this.var_tot_bon_encaissement) {
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
      }

   }

   public void verifBonEncaissementMultiple() {
      if (this.montantElmTotBonEnc != 0.0D) {
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
      }

      this.var_ecart_reglement = this.var_netAPayer - this.montantElmTotBonEnc;
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
      this.modeleSelectTrf();
      this.utilInitHibernate.closeSession();
   }

   public void modeleSelectTrf() throws ParseException {
      this.modeleTrfItems.clear();
      String var1 = "";
      if (this.var_type_trf == 26) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "avoir" + File.separator;
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
      this.var_imput_serie = this.factureEnteteMedical.getFacSerie();
      this.var_imput_cat = this.factureEnteteMedical.getFacCat();
      this.showModalPanelImput = true;
   }

   public void miseajourImput() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      if (!this.var_imput_serie.equalsIgnoreCase("X")) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Refacturation");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.factureEnteteMedical.getFacNum();
            this.factureEnteteMedical.setFacSerie(this.var_imput_serie);
            this.factureEnteteMedical.setFacCat(this.var_imput_cat);
            this.factureEnteteMedical.setFacNum(this.calculChrono.numCompose(this.factureEnteteMedical.getFacDate(), this.nature, this.factureEnteteMedical.getFacSerie(), var1));
            this.factureEnteteMedicalDao.modif(this.factureEnteteMedical, var1);
            ArrayList var4;
            int var6;
            if (this.factureEnteteMedical.getFacTotReglement() != 0.0D) {
               new ArrayList();
               ReglementsDao var5 = new ReglementsDao(this.baseLog, this.utilInitHibernate);
               var4 = (ArrayList)var5.reglementDocument(this.factureEnteteMedical.getFacId(), this.nature, var1);
               if (var4 != null) {
                  for(var6 = 0; var6 < var4.size(); ++var6) {
                     new Reglements();
                     Reglements var7 = (Reglements)var4.get(var6);
                     var7.setRglDocument(this.factureEnteteMedical.getFacNum());
                     var5.modifierReg(var7, var1);
                  }
               }
            }

            new ArrayList();
            ParapheurDao var13 = new ParapheurDao(this.baseLog, this.utilInitHibernate);
            var4 = (ArrayList)var13.parapheurDocument(this.factureEnteteMedical.getFacId(), this.nature, var1);
            if (var4 != null) {
               for(var6 = 0; var6 < var4.size(); ++var6) {
                  new Parapheur();
                  Parapheur var15 = (Parapheur)var4.get(var6);
                  var15.setPhrNum(this.factureEnteteMedical.getFacNum());
                  var13.modif(var15, var1);
               }
            }

            Espion var14 = new Espion();
            var14.setUsers(this.usersLog);
            var14.setEsptype(0);
            var14.setEspdtecreat(new Date());
            var14.setEspaction("Imputation reFacture X N° " + var3 + " en reFacture " + this.factureEnteteMedical.getFacSerie() + " N° " + this.factureEnteteMedical.getFacNum());
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
         new FactureLigneMedical();

         for(int var3 = 0; var3 < this.documentDetailTrf.size(); ++var3) {
            FactureLigneMedical var2 = (FactureLigneMedical)this.documentDetailTrf.get(var3);
            long var4 = var2.getFacligId();
            float var6 = var2.getFacligQte();
            float var7 = 0.0F;
            if (this.var_type_trf == 26) {
               AvoirLigneVentesDao var8 = new AvoirLigneVentesDao(this.baseLog, this.utilInitHibernate);
               var7 = var8.chargerLesReliquatsFactureVtes(var4, var1);
            }

            float var11 = var6 - var7;
            if (var11 < 0.0F) {
               var11 = 0.0F;
            }

            var2.setVar_qteDejaTrf(var7);
            var2.setVar_qteReliquat(var11);
            double var9 = var2.getFacligPuRem() * (double)var2.getVar_qteReliquat();
            var2.setVar_totalTrf(var9);
            var2 = (FactureLigneMedical)this.documentDetailTrf.set(var3, var2);
         }

         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
         this.calculMontantTrf();
      }

   }

   public void razQteTrf() throws ParseException {
      if (this.documentDetailTrf.size() != 0) {
         new FactureLigneMedical();

         for(int var2 = 0; var2 < this.documentDetailTrf.size(); ++var2) {
            FactureLigneMedical var1 = (FactureLigneMedical)this.documentDetailTrf.get(var2);
            var1.setVar_qteReliquat(0.0F);
            var1.setVar_totalTrf(0.0D);
            var1 = (FactureLigneMedical)this.documentDetailTrf.set(var2, var1);
         }

         this.calculMontantTrf();
         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
      }

   }

   public void transformerMaj() throws HibernateException, NamingException, Exception {
      if (this.documentDetailTrf.size() != 0 && this.lesEntetesList.size() != 0) {
         ArrayList var1 = new ArrayList();
         int var2;
         FactureEnteteMedical var3;
         boolean var4;
         int var5;
         if (this.var_mode_trf.equals("0")) {
            for(var2 = 0; var2 < this.lesEntetesList.size(); ++var2) {
               new FactureEnteteMedical();
               var3 = (FactureEnteteMedical)this.lesEntetesList.get(var2);
               if (var3.isVar_select_ligne()) {
                  var4 = false;

                  for(var5 = 0; var5 < var1.size(); ++var5) {
                     if (var3.getFacNum().equalsIgnoreCase(((FactureEnteteMedical)var1.get(var5)).getFacNum())) {
                        var4 = true;
                        break;
                     }
                  }

                  if (!var4) {
                     var1.add(var3);
                  }
               }
            }
         } else {
            for(var2 = 0; var2 < this.documentDetailTrf.size(); ++var2) {
               new FactureEnteteMedical();
               var3 = (FactureEnteteMedical)this.lesEntetesList.get(var2);
               if (var3.isVar_select_ligne()) {
                  var4 = false;

                  for(var5 = 0; var5 < var1.size(); ++var5) {
                     if (var3.getTiers().getTieid() == ((FactureEnteteMedical)var1.get(var5)).getTiers().getTieid()) {
                        if (var3.getFacSerie().equalsIgnoreCase(((FactureEnteteMedical)var1.get(var5)).getFacSerie())) {
                           var4 = true;
                        }
                        break;
                     }
                  }

                  if (!var4) {
                     var1.add(var3);
                  }
               }
            }
         }

         if (var1.size() != 0) {
            for(var2 = 0; var2 < var1.size(); ++var2) {
               this.factureEnteteMedical = (FactureEnteteMedical)var1.get(var2);
               this.lesLignesList.clear();
               int var6;
               if (this.var_mode_trf.equals("0")) {
                  for(var6 = 0; var6 < this.documentDetailTrf.size(); ++var6) {
                     if (((FactureEnteteMedical)var1.get(var2)).getFacNum().equalsIgnoreCase(((FactureLigneMedical)this.documentDetailTrf.get(var6)).getFactureEnteteMedical().getFacNum())) {
                        this.lesLignesList.add(this.documentDetailTrf.get(var6));
                     }
                  }
               } else {
                  for(var6 = 0; var6 < this.documentDetailTrf.size(); ++var6) {
                     if (((FactureEnteteMedical)var1.get(var2)).getTiers().getTieid() == ((FactureLigneMedical)this.documentDetailTrf.get(var6)).getFactureEnteteMedical().getTiers().getTieid()) {
                        this.lesLignesList.add(this.documentDetailTrf.get(var6));
                     }
                  }
               }

               if (this.lesLignesList.size() != 0) {
                  this.utilParapheur.supprimerParapheur(this.factureEnteteMedical.getFacId(), this.nature, (Session)null);
                  if (this.var_type_trf == 26) {
                     this.trfAvoir();
                  }
               }
            }
         }

         this.documentDetailTrf.clear();
         this.lesEntetesList.remove(this.factureEnteteMedical);
      }

      this.showModalPanelTrf = false;
   }

   public void trfAvoir() throws HibernateException, NamingException, Exception {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
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
            var4.setAvrSerie(this.factureEnteteMedical.getFacSerie());
         }

         var4.setUsers(this.usersLog);
         var4.setAvrIdCreateur(this.usersLog.getUsrid());
         var4.setAvrNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var4.setAvrDate(this.utilDate.dateToSQLLight(this.factureEnteteMedical.getFacDate()));
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
         int var34;
         if (this.optionMedical.getNbrJrRelanceAVOIR() != null && !this.optionMedical.getNbrJrRelanceAVOIR().isEmpty()) {
            var34 = Integer.parseInt(this.optionMedical.getNbrJrRelanceAVOIR());
         } else {
            var34 = 0;
         }

         boolean var9 = false;
         int var35;
         if (this.optionMedical.getNbrJrValidAVOIR() != null && !this.optionMedical.getNbrJrValidAVOIR().isEmpty()) {
            var35 = Integer.parseInt(this.optionMedical.getNbrJrValidAVOIR());
         } else {
            var35 = 0;
         }

         var4.setAvrDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var34));
         var4.setAvrDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var35));
         var4.setAvrService(this.factureEnteteMedical.getFacService());
         if (!var4.getAvrSerie().equalsIgnoreCase("X") && !var4.getAvrSerie().isEmpty()) {
            var4.setAvrNum(this.calculChrono.numCompose(this.factureEnteteMedical.getFacDate(), this.var_type_trf, var4.getAvrSerie(), var1));
         } else {
            long var10 = var5.selectLastNum(var1);
            var4.setAvrNum("" + var10);
         }

         this.verifieExistenceHabilitationAvoir(var4, var1);
         var4.setAvrIdEquipe(this.factureEnteteMedical.getFacIdAdherent());
         var4.setAvrNomEquipe(this.factureEnteteMedical.getFacNomAdherent());
         var4.setAvrSource(this.factureEnteteMedical.getFacSecteurAgent());
         var4.setAvrNomCommercial(this.factureEnteteMedical.getFacNomCommercial());
         var4.setAvrIdCommercial(this.factureEnteteMedical.getFacIdCommercial());
         var4.setAvrNomTiers(this.factureEnteteMedical.getFacNomTiers());
         var4.setAvrCivilTiers(this.factureEnteteMedical.getFacCivilTiers());
         var4.setAvrTiersRegroupe(this.factureEnteteMedical.getFacTiersRegroupe());
         var4.setAvrIdContact(this.factureEnteteMedical.getFacIdContact());
         var4.setAvrNomContact(this.factureEnteteMedical.getFacNomContact());
         var4.setAvrCivilContact(this.factureEnteteMedical.getFacCivilContact());
         var4.setAvrExoTva(this.factureEnteteMedical.getFacExoTva());
         var4.setAvrJournalReg(this.factureEnteteMedical.getFacJournalReg());
         var4.setAvrCat(this.factureEnteteMedical.getFacCat());
         var4.setAvrDevise(this.factureEnteteMedical.getFacDevise());
         var4.setAvrObject(this.factureEnteteMedical.getFacObject());
         var4.setAvrObservation(this.factureEnteteMedical.getFacObservation());
         var4.setAvrTauxRemise(this.factureEnteteMedical.getFacTauxRemise());
         var4.setAvrTotHt(0.0D);
         var4.setAvrTotRemise(0.0D);
         var4.setAvrTotRabais(0.0D);
         var4.setAvrTotTva(0.0D);
         var4.setAvrTotTc(0.0D);
         var4.setAvrTotTtc(0.0D);
         var4.setAvrTotReglement(0.0D);
         var4.setAvrSolde(0);
         var4.setAvrBanque(this.factureEnteteMedical.getFacBanque());
         var4.setAvrTypeReg(this.factureEnteteMedical.getFacTypeReg());
         var4.setAvrModeReg(this.factureEnteteMedical.getFacModeReg());
         var4.setAvrNbJourReg(this.factureEnteteMedical.getFacNbJourReg());
         var4.setAvrArrondiReg(this.factureEnteteMedical.getFacArrondiReg());
         var4.setAvrConditionReg(this.factureEnteteMedical.getFacConditionReg());
         var4.setAvrDateEcheReg(this.factureEnteteMedical.getFacDateEcheReg());
         var4.setAvrSite(this.factureEnteteMedical.getFacSite());
         var4.setAvrDepartement(this.factureEnteteMedical.getFacDepartement());
         var4.setAvrAnal2(this.factureEnteteMedical.getFacAnal2());
         var4.setAvrAnal4(this.factureEnteteMedical.getFacAnal4());
         var4.setAvrInfo1(this.factureEnteteMedical.getFacInfo1());
         var4.setAvrInfo2(this.factureEnteteMedical.getFacInfo2());
         var4.setAvrInfo3(this.factureEnteteMedical.getFacInfo3());
         var4.setAvrInfo4(this.factureEnteteMedical.getFacInfo4());
         var4.setAvrInfo5(this.factureEnteteMedical.getFacInfo5());
         var4.setAvrInfo6(this.factureEnteteMedical.getFacInfo6());
         var4.setAvrInfo7(this.factureEnteteMedical.getFacInfo7());
         var4.setAvrInfo8(this.factureEnteteMedical.getFacInfo8());
         var4.setAvrInfo9(this.factureEnteteMedical.getFacInfo9());
         var4.setAvrInfo10(this.factureEnteteMedical.getFacInfo10());
         var4.setAvrFormule1(this.factureEnteteMedical.getFacFormule1());
         var4.setAvrFormule2(this.factureEnteteMedical.getFacFormule2());
         var4.setAvrDateImp((Date)null);
         var4.setAvrModeleImp(this.var_modele_trf);
         var4.setAvrGele(0);
         var4.setAvrEtat(0);
         var4.setAvrDateTransforme((Date)null);
         var4.setAvrTypeTransforme(0);
         var4.setAvrDateAnnule((Date)null);
         var4.setAvrMotifAnnule("");
         var4.setAvrNumFacture(this.factureEnteteMedical.getFacNum());
         var4.setExerciceventes(this.factureEnteteMedical.getExerciceventes());
         var4.setTiers(this.factureEnteteMedical.getTiers());
         var4.setUsers(this.usersLog);
         var4 = var5.insert(var4, var1);
         float var36 = 0.0F;
         float var11 = 0.0F;
         float var12 = 0.0F;
         double var13 = 0.0D;
         double var15 = 0.0D;
         double var17 = 0.0D;
         double var19 = 0.0D;
         double var21 = 0.0D;
         double var23 = 0.0D;
         if (this.lesLignesList.size() != 0) {
            for(int var25 = 0; var25 < this.lesLignesList.size(); ++var25) {
               this.factureLigneMedical = (FactureLigneMedical)this.lesLignesList.get(var25);
               if (this.factureLigneMedical.getFacligLibelle() != null && !this.factureLigneMedical.getFacligLibelle().isEmpty() && this.factureLigneMedical.getVar_qteReliquat() != 0.0F) {
                  float var26 = this.factureLigneMedical.getFacligQte();
                  float var27 = this.factureLigneMedical.getFacligQte();
                  AvoirLigneVentes var28 = new AvoirLigneVentes();
                  var36 += this.factureLigneMedical.getFacligQte();
                  var11 += this.factureLigneMedical.getVar_qteDejaTrf();
                  if (((FactureLigneMedical)this.lesLignesList.get(var25)).getVar_qteReliquat() != 0.0F) {
                     var28.setAvrligOrdre(this.factureLigneMedical.getFacligOrdre());
                     var28.setAvrligCode(this.factureLigneMedical.getFacligCode());
                     var28.setAvrligDevise(this.factureLigneMedical.getFacligDevise());
                     var28.setAvrligFamille(this.factureLigneMedical.getFacligFamille());
                     var28.setAvrligIdFac(this.factureLigneMedical.getFacligId());
                     var28.setAvrligLibelle(this.factureLigneMedical.getFacligLibelle());
                     var28.setAvrligReference(this.factureLigneMedical.getFacligReference());
                     var28.setAvrligPu(this.factureLigneMedical.getFacligPu());
                     var28.setAvrligPuTtc(this.factureLigneMedical.getFacligPuTtc());
                     var28.setAvrligTauxRemise(this.factureLigneMedical.getFacligTauxRemise());
                     var28.setAvrligPuRem(this.factureLigneMedical.getFacligPuRem());
                     var28.setAvrligPuRemTtc(this.factureLigneMedical.getFacligPuRemTtc());
                     this.factureLigneMedical.setFacligQte(((FactureLigneMedical)this.lesLignesList.get(var25)).getVar_qteReliquat());
                     var28.setAvrligQte(((FactureLigneMedical)this.lesLignesList.get(var25)).getVar_qteReliquat());
                     var28.setAvrligQteStock(0.0F);
                     var28.setAvrligRabais(this.factureLigneMedical.getFacligRabais());
                     var28.setAvrligTauxTaxe(this.factureLigneMedical.getFacligTauxTaxe());
                     var28.setAvrligTaxe(this.factureLigneMedical.getFacligTaxe());
                     var28.setAvrligPt(this.factureLigneMedical.getFacligPt());
                     var28.setAvrligTva(this.factureLigneMedical.getFacligTva());
                     var28.setAvrligTtc(this.factureLigneMedical.getFacligTtc());
                     var28.setAvrligTc(this.factureLigneMedical.getFacligTc());
                     var28.setAvoirEnteteVentes(var4);
                     var12 += ((FactureLigneMedical)this.lesLignesList.get(var25)).getVar_qteReliquat();
                     var7.add(var28);
                     var13 += var28.getAvrligPt();
                     var15 += (var28.getAvrligPu() - var28.getAvrligPuRem()) * (double)var28.getAvrligQte();
                     var17 += var28.getAvrligRabais();
                     var19 += var28.getAvrligTva();
                     var21 += var28.getAvrligTtc();
                     var23 += var28.getAvrligTc();
                     this.factureLigneMedical.setFacligQte(var26);
                  }
               }
            }

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
         }

         this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationAvoir(var4, var1), var4.getAvrId(), var4.getAvrNum(), var4.getAvrNomTiers(), var4.getAvrDate(), var4.getAvrDevise(), var4.getAvrTotTtc() + var4.getAvrTotTc(), var4.getAvrModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 26, this.factureEnteteMedical.getFacOrigine()), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFAVR(var7, var4), this.calculeParc(var1), var4.getVar_format_devise(), 0, var1);
         var3.setDoctraDateCreat(new Date());
         var3.setDoctraUserId(this.usersLog.getUsrid());
         var3.setDoctraUserNom(this.usersLog.getUsrNom());
         var3.setExerciceventes(this.factureEnteteMedical.getExerciceventes());
         var3.setDoctraOrgType(this.nature);
         var3.setDoctraOrgSerie(this.factureEnteteMedical.getFacSerie());
         var3.setDoctraOrgId(this.factureEnteteMedical.getFacId());
         var3.setDoctraOrgNum(this.factureEnteteMedical.getFacNum());
         var3.setDoctraOrgDate(this.factureEnteteMedical.getFacDate());
         var3.setDoctraDstType(this.var_type_trf);
         var3.setDoctraDstSerie(var4.getAvrSerie());
         var3.setDoctraDstId(var4.getAvrId());
         var3.setDoctraDstNum(var4.getAvrNum());
         var3.setDoctraDstDate(var4.getAvrDate());
         this.documentTraceVentesDao.insert(var3, var1);
         var4.setAvrEtat(0);
         var4.setAvrDateTransforme(new Date());
         var4.setAvrTypeTransforme(this.var_type_trf);
         var4.setAvrTotReglement(var4.getAvrTotTtc());
         var4.setAvrSolde(1);
         var4 = var5.modif(var4, var1);
         var5.modif(var4, var1);
         this.miseajourPayeAvoir(var4, var1);
         this.factureEnteteMedical.setFacNumAvoir(var4.getAvrNum());
         this.factureEnteteMedical.setFacTotReglement(this.factureEnteteMedical.getFacTotReglement() + var4.getAvrTotHt());
         this.factureEnteteMedical = this.factureEnteteMedicalDao.modif(this.factureEnteteMedical, var1);
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

   public void miseajourPayeAvoir(AvoirEnteteVentes var1, Session var2) throws HibernateException, NamingException, ParseException {
      double var3 = var1.getAvrTotTtc() - var1.getAvrTotReglement();
      double var5 = 0.0D;
      double var7 = 0.0D;
      if (this.var_date == null) {
         this.var_date = new Date();
      }

      if (this.factureEnteteMedical != null) {
         new ExercicesCaisse();
         ExercicesCaisseDao var10 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
         ExercicesCaisse var9 = var10.recupererLastExo(var2);
         if (var9 != null) {
            String var11 = this.calculChrono.numCompose(this.var_date, 29, this.factureEnteteMedical.getFacSerie(), var2);
            this.reglements = new Reglements();
            this.reglements.setRglActivite("");
            this.reglements.setRglBanqueTireur("");
            this.reglements.setRglBudget(this.factureEnteteMedical.getFacBudget());
            this.reglements.setRglBon("");
            this.reglements.setRglCategorie(20);
            this.reglements.setRglCodeCaiss("");
            this.reglements.setRglLibCaiss("");
            this.reglements.setRglCodeEmetrice("");
            this.reglements.setRglLibEmetrice("");
            this.reglements.setRglCodeReceptrice("");
            this.reglements.setRglLibReceptrice("");
            this.reglements.setRglDateCreation(new Date());
            this.reglements.setRglDateImp((Date)null);
            this.reglements.setRglDateReg(this.var_date);
            this.reglements.setRglDateTransfert((Date)null);
            this.reglements.setRglDateValeur((Date)null);
            this.reglements.setRglDepartement(this.factureEnteteMedical.getFacDepartement());
            this.reglements.setRglDepense(0.0D);
            this.reglements.setRglDevise(this.factureEnteteMedical.getFacDevise());
            this.reglements.setRglDossier("");
            this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
            this.reglements.setRglDocument(this.factureEnteteMedical.getFacNum());
            this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
            this.reglements.setRglIdBon(0L);
            this.reglements.setRglIdDocument(this.factureEnteteMedical.getFacId());
            this.reglements.setRglIdTiers(this.factureEnteteMedical.getTiers().getTieid());
            this.reglements.setRglDepotTiers(0);
            this.reglements.setRglLibelle("Compense Avoir N° " + var1.getAvrNum());
            this.reglements.setRglLibTypReg("Compense");
            this.reglements.setRglMode("Compense");
            this.reglements.setRglModele("");
            this.reglements.setRglNumChqBdx("");
            this.reglements.setRglNatureDoc(25);
            this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
            this.reglements.setRglNomTiers(this.factureEnteteMedical.getFacNomTiers());
            this.reglements.setRglNum(var11);
            this.reglements.setRglObjet(this.factureEnteteMedical.getFacObject());
            this.reglements.setRglParc("");
            this.reglements.setRglPdv("");
            double var10000;
            if (this.factureEnteteMedical.getFacTotTtc() - this.factureEnteteMedical.getFacTotReglement() <= var3) {
               this.reglements.setRglRecette(this.factureEnteteMedical.getFacTotTtc() - this.factureEnteteMedical.getFacTotReglement());
               var10000 = var3 - (this.factureEnteteMedical.getFacTotTtc() - this.factureEnteteMedical.getFacTotReglement());
            } else {
               this.reglements.setRglRecette(var3);
               var3 = 0.0D;
            }

            var5 = this.reglements.getRglRecette();
            this.reglements.setRglTimbre(0.0D);
            this.reglements.setRglRegion("");
            this.reglements.setRglSecteur("");
            this.reglements.setRglSerie(this.factureEnteteMedical.getFacSerie());
            this.reglements.setRglService(this.factureEnteteMedical.getFacService());
            this.reglements.setRglSite(this.factureEnteteMedical.getFacSite());
            this.reglements.setRglTrf(1);
            this.reglements.setRglTypeReg(0);
            this.reglements.setRglTypeTiers(0);
            this.reglements.setRglUserCreat(this.usersLog.getUsrid());
            this.reglements.setRglUserModif(0L);
            this.reglements.setRglIdResponsable(0L);
            this.reglements.setRglNomResponsable("");
            this.reglements.setRglIdCommercial(this.factureEnteteMedical.getFacIdCommercial());
            this.reglements.setRglNomCommercial(this.factureEnteteMedical.getFacNomCommercial());
            this.reglements.setRglIdEquipe(0L);
            this.reglements.setRglNomEquipe("");
            String var12 = "";
            if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
               var12 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
            } else {
               var12 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
            }

            String var13 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
            this.reglements.setRglPeriode(var12 + ":" + var13);
            this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
            String var14 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
            this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var14);
            this.reglements.setExercicesCaisse(var9);
            this.reglements = this.reglementsDao.insert(this.reglements, var2);
            this.factureEnteteMedical.setFacTotReglement(this.factureEnteteMedical.getFacTotReglement() + var5);
            if (this.factureEnteteMedical.getFacTotReglement() >= this.factureEnteteMedical.getFacTotTtc()) {
               this.factureEnteteMedical.setFacSolde(1);
            } else {
               this.factureEnteteMedical.setFacSolde(0);
            }

            this.factureEnteteMedical = this.factureEnteteMedicalDao.modif(this.factureEnteteMedical, var2);
            this.reglements = new Reglements();
            this.reglements.setRglActivite("");
            this.reglements.setRglBanqueTireur("");
            this.reglements.setRglBudget(this.factureEnteteMedical.getFacBudget());
            this.reglements.setRglBon("");
            this.reglements.setRglCategorie(20);
            this.reglements.setRglCodeCaiss("");
            this.reglements.setRglLibCaiss("");
            this.reglements.setRglCodeEmetrice("");
            this.reglements.setRglLibEmetrice("");
            this.reglements.setRglCodeReceptrice("");
            this.reglements.setRglLibReceptrice("");
            this.reglements.setRglDateCreation(new Date());
            this.reglements.setRglDateImp((Date)null);
            this.reglements.setRglDateReg(this.var_date);
            this.reglements.setRglDateTransfert((Date)null);
            this.reglements.setRglDateValeur((Date)null);
            this.reglements.setRglDepartement(var1.getAvrDepartement());
            this.reglements.setRglDepense(0.0D);
            this.reglements.setRglDevise(var1.getAvrDevise());
            this.reglements.setRglDossier("");
            this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
            this.reglements.setRglDocument(var1.getAvrNum());
            this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
            this.reglements.setRglIdBon(0L);
            this.reglements.setRglIdDocument(var1.getAvrId());
            this.reglements.setRglIdTiers(var1.getTiers().getTieid());
            this.reglements.setRglDepotTiers(0);
            this.reglements.setRglLibelle("Compense reFacture N° " + this.factureEnteteMedical.getFacNum());
            this.reglements.setRglLibTypReg("Compense");
            this.reglements.setRglMode("Compense");
            this.reglements.setRglModele("");
            this.reglements.setRglNumChqBdx("");
            this.reglements.setRglNatureDoc(26);
            this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
            this.reglements.setRglNomTiers(var1.getAvrNomTiers());
            this.reglements.setRglNum(var11);
            this.reglements.setRglObjet(var1.getAvrObject());
            this.reglements.setRglParc("");
            this.reglements.setRglPdv(var1.getAvrPdv());
            this.reglements.setRglRecette(var5);
            var10000 = var7 + var5;
            this.reglements.setRglTimbre(0.0D);
            this.reglements.setRglRegion(var1.getAvrRegion());
            this.reglements.setRglSecteur(var1.getAvrSecteur());
            this.reglements.setRglSerie(var1.getAvrSerie());
            this.reglements.setRglService(var1.getAvrService());
            this.reglements.setRglSite(var1.getAvrSite());
            this.reglements.setRglTrf(1);
            this.reglements.setRglTypeReg(0);
            this.reglements.setRglTypeTiers(0);
            this.reglements.setRglUserCreat(this.usersLog.getUsrid());
            this.reglements.setRglUserModif(0L);
            this.reglements.setRglIdResponsable(var1.getAvrIdResponsable());
            this.reglements.setRglNomResponsable(var1.getAvrNomResponsable());
            this.reglements.setRglIdCommercial(var1.getAvrIdCommercial());
            this.reglements.setRglNomCommercial(var1.getAvrNomCommercial());
            this.reglements.setRglIdEquipe(var1.getAvrIdEquipe());
            this.reglements.setRglNomEquipe(var1.getAvrNomEquipe());
            var12 = "";
            if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
               var12 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
            } else {
               var12 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
            }

            var13 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
            this.reglements.setRglPeriode(var12 + ":" + var13);
            this.reglements.setRglCle1(this.reglements.getRglCodeCaiss() + ":" + this.reglements.getRglPeriode());
            var14 = this.utilDate.dateToStringSQLLight(this.reglements.getRglDateReg());
            this.reglements.setRglCle2(this.reglements.getRglCodeCaiss() + ":" + var14);
            this.reglements.setExercicesCaisse(var9);
            this.reglements = this.reglementsDao.insert(this.reglements, var2);
         }
      }

   }

   public void selectionLigneDetailTrf() throws HibernateException, NamingException {
      if (this.datamodelTransfert.isRowAvailable()) {
         this.factureLigneMedical = (FactureLigneMedical)this.datamodelTransfert.getRowData();
      }

   }

   public double calculTotalTrf() {
      double var1 = this.factureLigneMedical.getFacligPuRem() * (double)this.factureLigneMedical.getVar_qteReliquat();
      this.factureLigneMedical.setVar_totalTrf(var1);
      this.calculMontantTrf();
      return var1;
   }

   public void calculMontantTrf() {
      this.var_montant_trf = 0.0D;
      if (this.documentDetailTrf.size() != 0) {
         for(int var1 = 0; var1 < this.documentDetailTrf.size(); ++var1) {
            this.var_montant_trf += ((FactureLigneMedical)this.documentDetailTrf.get(var1)).getVar_totalTrf();
         }
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
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               var1.setAvrEtat(0);
               var1.setAvrDateValide((Date)null);
            }
         }
      }

      return var4;
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
            new FactureEnteteMedical();
            FactureEnteteMedical var11 = (FactureEnteteMedical)this.lesEntetesList.get(var10);
            if (var11.isVar_select_ligne() && (var7 == 0L || var7 != 0L && var7 == var11.getTiers().getTieid() && var9.equals(var11.getFacNomTiers())) && var11.getFacSolde() == 0) {
               var7 = var11.getTiers().getTieid();
               var9 = var11.getFacNomTiers();
               var1 += var11.getFacTotTtc() + var11.getFacTotTc();
               var3 += var11.getFacTotReglement();
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
            this.factureEnteteMedical.setFacTypeReg(0);
            this.chargerModReg();
            this.verifValide();
            this.showModalPanelReglement = true;
         }
      }

   }

   public void chargerModReg() {
      if (this.factureEnteteMedical.getFacTypeReg() != 4 && this.factureEnteteMedical.getFacTypeReg() != 5) {
         this.montantElmTotBonEnc = this.var_netAPayer;
         this.var_affichMontant = true;
      } else {
         this.var_affichMontant = false;
      }

   }

   public void calculeCaisseDisponibleBrecu() throws HibernateException, NamingException {
      this.mesCaissesSeriesItems.clear();
      if (this.listCaisses.size() != 0) {
         for(int var1 = 0; var1 < this.listCaisses.size(); ++var1) {
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 61 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.factureEnteteMedical.getFacSerie())) {
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
         new FactureEnteteMedical();
         FactureEnteteMedical var6 = (FactureEnteteMedical)this.listFactureSelectionne.get(var5);
         if (var6.isVar_select_ligne()) {
            var1 += var6.getFacTotTtc();
            var3 += var6.getFacTotReglement();
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
               new FactureEnteteMedical();
               FactureEnteteMedical var7 = (FactureEnteteMedical)this.listFactureSelectionne.get(var6);
               if (this.montantElmTotBonEnc != 0.0D && var4 < var7.getFacTotTtc() + var7.getFacTotTc() - var7.getFacTotReglement()) {
                  var2 = this.utilNombre.calculTimbre(this.structureLog, var7.getFacTotTtc() + var7.getFacTotTc() - var7.getFacTotReglement(), var1, this.structureLog.getStrdevise(), var7.getFacDate());
               } else {
                  var2 = this.utilNombre.calculTimbre(this.structureLog, var7.getFacTotTtc() + var7.getFacTotTc() - var7.getFacTotReglement(), var1, this.structureLog.getStrdevise(), var7.getFacDate());
                  var4 = var4 - var7.getFacTotTtc() + var7.getFacTotTc() - var7.getFacTotReglement();
               }

               var7.setVar_fac_timbre(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
               this.var_netAPayer += var7.getVar_reliquat();
            }

            this.datamodelTransfert.setWrappedData(this.listFactureSelectionne);
         }
      } else if (this.varTypeReg != 0 && this.listFactureSelectionne.size() != 0) {
         for(var1 = 0; var1 < this.listFactureSelectionne.size(); ++var1) {
            new FactureEnteteMedical();
            FactureEnteteMedical var8 = (FactureEnteteMedical)this.listFactureSelectionne.get(var1);
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
      Session var3;
      if (this.montantElmTotBonEnc != 0.0D && this.var_netAPayer != 0.0D) {
         new OptionCaisses();
         LireLesoptionsCaisses var2 = new LireLesoptionsCaisses();
         var2.setStrId(this.structureLog.getStrid());
         OptionCaisses var1 = var2.lancer();
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "BonEncaissementMedical");
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();
            new ExercicesCaisse();
            ExercicesCaisseDao var6 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
            ExercicesCaisse var5 = var6.recupererLastExo(var3);
            if (var5 != null) {
               String var7 = this.factureEnteteMedical.getFacSerie();
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

               double var50 = this.montantElmTotBonEnc;
               double var12 = 0.0D;
               double var14 = 0.0D;
               double var16 = 0.0D;
               double var18 = 0.0D;
               new FactureEnteteMedical();

               for(int var21 = 0; var21 < this.listFactureSelectionne.size(); ++var21) {
                  FactureEnteteMedical var20 = (FactureEnteteMedical)this.listFactureSelectionne.get(var21);
                  var16 = var20.getVar_fac_timbre();
                  var18 = var20.getMontantReglementManuel();
                  var12 = 0.0D;
                  if (var20.isVar_select_ligne()) {
                     long var22 = var20.getFacId();
                     var20 = this.factureEnteteMedicalDao.pourParapheur(var22, var3);
                     if (var20 != null) {
                        if (this.repartitionManuelle) {
                           if (var18 != 0.0D) {
                              this.calculPaiementParLigne(var20, var18, var3);
                              this.generationReglement(var8, var18, var16, var20, var5, var3);
                              var50 -= var18;
                              if (var50 < 0.0D) {
                                 var50 = 0.0D;
                                 break;
                              }
                           }
                        } else {
                           var12 = var20.getFacTotTtc() + var20.getFacTotTc() + var16 - var20.getFacTotReglement();
                           if (var50 <= 0.0D) {
                              break;
                           }

                           if (var12 <= var50) {
                              var14 = var12;
                           } else {
                              var14 = var50;
                           }

                           this.calculPaiementParLigne(var20, var14, var3);
                           this.generationReglement(var8, var14, var16, var20, var5, var3);
                           var50 -= var14;
                           if (var50 < 0.0D) {
                              var50 = 0.0D;
                              break;
                           }
                        }
                     }
                  }
               }

               if (var50 > 0.0D) {
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
                  this.reglements.setRglRecette(var50);
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
                     double var53 = this.tiers.getTiedepotavance() + var50;
                     this.tiers.setTiedepotavance(var53);
                     this.tiersDao.modif(this.tiers, var3);
                  }
               }

               var4.commit();
            }
         } catch (HibernateException var36) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var36;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      ArrayList var38 = new ArrayList();
      if (this.lesEntetesList.size() != 0) {
         Session var39 = this.utilInitHibernate.getOpenSession(this.baseLog, "Refacturation");
         var3 = null;

         try {
            Transaction var40 = var39.beginTransaction();
            int var41 = 0;

            while(true) {
               if (var41 >= this.lesEntetesList.size()) {
                  if (var38.size() != 0) {
                     ArrayList var42 = new ArrayList();
                     new ArrayList();
                     new FactureEnteteMedical();

                     for(int var46 = 0; var46 < var38.size(); ++var46) {
                        FactureEnteteMedical var45 = (FactureEnteteMedical)var38.get(var46);
                        List var44 = this.factureLigneMedicalDao.chargerLesLignes(var45, var39);
                        if (var44.size() != 0) {
                           boolean var48 = false;
                           long var47 = 0L;

                           int var51;
                           for(var51 = 0; var51 < var44.size(); ++var51) {
                              byte var49;
                              if (((FactureLigneMedical)var44.get(var51)).getFacligIdConsultation() != 0L) {
                                 var49 = 71;
                                 this.consultationActes = this.consultationActesDao.selectConsActes(((FactureLigneMedical)var44.get(var51)).getFacligIdConsultation(), var39);
                                 if (this.consultationActes != null) {
                                    var47 = this.consultationActes.getConsultationEnteteGene().getCsgId();
                                 }
                              } else if (((FactureLigneMedical)var44.get(var51)).getFacligIdPharmacie() != 0L) {
                                 var49 = 73;
                                 this.pharmacieLigne = this.pharmacieLigneDao.selectConsActes(((FactureLigneMedical)var44.get(var51)).getFacligIdPharmacie(), var39);
                                 if (this.pharmacieLigne != null) {
                                    var47 = this.pharmacieLigne.getPharmacieEntete().getPhaId();
                                 }
                              } else if (((FactureLigneMedical)var44.get(var51)).getFacligIdLaboratoire() != 0L) {
                                 var49 = 74;
                                 this.laboratoireLigne = this.laboratoireLigneDao.selectConsActes(((FactureLigneMedical)var44.get(var51)).getFacligIdLaboratoire(), var39);
                                 if (this.laboratoireLigne != null) {
                                    var47 = this.laboratoireLigne.getLaboratoireEntete().getLabId();
                                 }
                              } else {
                                 var49 = 76;
                                 if (((FactureLigneMedical)var44.get(var51)).getFacligIdHospitalisationActe() != 0L) {
                                    this.hospitalisationActes = this.hospitalisationActesDao.selectHospitActes(((FactureLigneMedical)var44.get(var51)).getFacligIdHospitalisationActe(), var39);
                                    if (this.hospitalisationActes != null) {
                                       var47 = this.hospitalisationActes.getHospitalisationEntete().getHosId();
                                    }
                                 } else if (((FactureLigneMedical)var44.get(var51)).getFacligIdHospitalisationLabo() != 0L) {
                                    this.hospitalisationLabo = this.hospitalisationLaboDao.selectLabo(((FactureLigneMedical)var44.get(var51)).getFacligIdHospitalisationLabo(), var39);
                                    if (this.hospitalisationLabo != null) {
                                       var47 = this.hospitalisationLabo.getHospitalisationEntete().getHosId();
                                    }
                                 } else if (((FactureLigneMedical)var44.get(var51)).getFacligIdHospitalisationMedic() != 0L) {
                                    this.hospitalisationMedi = this.hospitalisationMediDao.selectMedi(((FactureLigneMedical)var44.get(var51)).getFacligIdHospitalisationMedic(), var39);
                                    if (this.hospitalisationMedi != null) {
                                       var47 = this.hospitalisationMedi.getHospitalisationEntete().getHosId();
                                    }
                                 } else if (((FactureLigneMedical)var44.get(var51)).getFacligIdHospitalisationPrest() != 0L) {
                                    this.hospitalisationPrest = this.hospitalisationPrestDao.selectPrest(((FactureLigneMedical)var44.get(var51)).getFacligIdHospitalisationPrest(), var39);
                                    if (this.hospitalisationPrest != null) {
                                       var47 = this.hospitalisationPrest.getHospitalisationEntete().getHosId();
                                    }
                                 } else if (((FactureLigneMedical)var44.get(var51)).getFacligIdHospitalisationSejour() != 0L) {
                                    this.hospitalisationSejour = this.hospitalisationSejourDao.selectSejour(((FactureLigneMedical)var44.get(var51)).getFacligIdHospitalisationSejour(), var39);
                                    if (this.hospitalisationSejour != null) {
                                       var47 = this.hospitalisationSejour.getHospitalisationEntete().getHosId();
                                    }
                                 }
                              }

                              boolean var52 = false;
                              if (var42.size() != 0) {
                                 for(int var13 = 0; var13 < var42.size(); ++var13) {
                                    if (((DocumentEntete)var42.get(var13)).getDocNature() == var49 && ((DocumentEntete)var42.get(var13)).getDocId() == var47) {
                                       var52 = true;
                                       break;
                                    }
                                 }
                              }

                              if (!var52 && var47 != 0L) {
                                 this.documentEntete = new DocumentEntete();
                                 this.documentEntete.setDocNature(var49);
                                 this.documentEntete.setDocId(var47);
                                 var42.add(this.documentEntete);
                              }
                           }

                           if (var42.size() != 0) {
                              for(var51 = 0; var51 < var42.size(); ++var51) {
                                 if (((DocumentEntete)var42.get(var51)).getDocNature() == 71) {
                                    this.payeConsultation(((DocumentEntete)var42.get(var51)).getDocId(), var39);
                                 } else if (((DocumentEntete)var42.get(var51)).getDocNature() == 73) {
                                    this.payePharmacie(((DocumentEntete)var42.get(var51)).getDocId(), var39);
                                 } else if (((DocumentEntete)var42.get(var51)).getDocNature() == 74) {
                                    this.payeLaboratire(((DocumentEntete)var42.get(var51)).getDocId(), var39);
                                 } else if (((DocumentEntete)var42.get(var51)).getDocNature() == 77) {
                                    this.payeHospitalisation(((DocumentEntete)var42.get(var51)).getDocId(), var39);
                                 }
                              }
                           }
                        }
                     }
                  }

                  var40.commit();
                  break;
               }

               this.factureEnteteMedical = (FactureEnteteMedical)this.lesEntetesList.get(var41);
               if (this.factureEnteteMedical.isVar_select_ligne()) {
                  long var43 = this.factureEnteteMedical.getFacId();
                  this.factureEnteteMedical = new FactureEnteteMedical();
                  this.factureEnteteMedical = this.factureEnteteMedicalDao.pourParapheur(var43, var39);
                  var38.add(this.factureEnteteMedical);
                  if (this.factureEnteteMedical != null) {
                     if (this.factureEnteteMedical.getFacSolde() == 1 && this.inpEtat == 13) {
                        this.lesEntetesList.remove(var41);
                     } else {
                        this.lesEntetesList.remove(var41);
                        this.factureEnteteMedical.setVar_select_ligne(false);
                        this.lesEntetesList.add(var41, this.factureEnteteMedical);
                     }
                  }
               }

               ++var41;
            }
         } catch (HibernateException var34) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var34;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelReglement = false;
      this.ouvrirImpressionRecu();
   }

   public void calculPaiementParLigne(FactureEnteteMedical var1, double var2, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      List var5 = this.factureLigneMedicalDao.chargerLesLignes(var1, var4);
      if (var5.size() != 0) {
         new FactureLigneMedical();

         for(int var7 = 0; var7 < var5.size(); ++var7) {
            FactureLigneMedical var6 = (FactureLigneMedical)var5.get(var7);
            if (var2 > 0.0D) {
               if (var6.getFacligTtc() > var2) {
                  var6.setFacligMontantPaye(var2);
                  var2 = 0.0D;
               } else {
                  var6.setFacligMontantPaye(var6.getFacligTtc());
                  var2 -= var6.getFacligTtc();
                  if (var2 < 0.0D) {
                     var2 = 0.0D;
                  }
               }

               this.factureLigneMedicalDao.modifLigne(var6, var4);
            }
         }
      }

   }

   public void payeConsultation(long var1, Session var3) throws HibernateException, NamingException {
      this.consultationEnteteGene = this.consultationEnteteGeneDao.selectById(var1, var3);
      if (this.consultationEnteteGene != null) {
         double var4 = 0.0D;
         new ArrayList();
         List var6 = this.factureLigneMedicalDao.chargerLesLignesFacturesByNature(var1, (String)null, 71, var3);
         if (var6.size() != 0) {
            for(int var7 = 0; var7 < var6.size(); ++var7) {
               var4 += ((FactureLigneMedical)var6.get(var7)).getFacligMontantPaye();
            }
         }

         this.consultationEnteteGene.setCsgRegTiers(var4);
         if (this.consultationEnteteGene.getCsgRegTiers() >= this.consultationEnteteGene.getCsgTotAssurance() + this.consultationEnteteGene.getCsgTotComplmentaire() + this.consultationEnteteGene.getCsgTotSociete() + this.consultationEnteteGene.getCsgTotTaxeAssurance() + this.consultationEnteteGene.getCsgTotTaxeComplementaire() + this.consultationEnteteGene.getCsgTotTaxeSociete()) {
            this.consultationEnteteGene.setCsgSoldeTiers(1);
         } else {
            this.consultationEnteteGene.setCsgSoldeTiers(0);
         }

         this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var3);
      }

   }

   public void payePharmacie(long var1, Session var3) throws HibernateException, NamingException {
      this.pharmacieEntete = this.pharmacieEnteteDao.selectById(var1, var3);
      if (this.pharmacieEntete != null) {
         double var4 = 0.0D;
         new ArrayList();
         List var6 = this.factureLigneMedicalDao.chargerLesLignesFacturesByNature(var1, (String)null, 73, var3);
         if (var6.size() != 0) {
            for(int var7 = 0; var7 < var6.size(); ++var7) {
               var4 += ((FactureLigneMedical)var6.get(var7)).getFacligMontantPaye();
            }
         }

         this.pharmacieEntete.setPhaRegTiers(var4);
         if (this.pharmacieEntete.getPhaRegTiers() >= this.pharmacieEntete.getPhaTotAssurance() + this.pharmacieEntete.getPhaTotComplmentaire() + this.pharmacieEntete.getPhaTotSociete() + this.pharmacieEntete.getPhaTotTaxeAssurance() + this.pharmacieEntete.getPhaTotTaxeComplementaire() + this.pharmacieEntete.getPhaTotTaxeSociete()) {
            this.pharmacieEntete.setPhaSoldeTiers(1);
         } else {
            this.pharmacieEntete.setPhaSoldeTiers(0);
         }

         this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var3);
      }

   }

   public void payeLaboratire(long var1, Session var3) throws HibernateException, NamingException {
      this.laboratoireEntete = this.laboratoireEnteteDao.selectById(var1, var3);
      if (this.laboratoireEntete != null) {
         double var4 = 0.0D;
         new ArrayList();
         List var6 = this.factureLigneMedicalDao.chargerLesLignesFacturesByNature(var1, (String)null, 74, var3);
         if (var6.size() != 0) {
            for(int var7 = 0; var7 < var6.size(); ++var7) {
               var4 += ((FactureLigneMedical)var6.get(var7)).getFacligMontantPaye();
            }
         }

         this.laboratoireEntete.setLabRegTiers(var4);
         if (this.laboratoireEntete.getLabRegTiers() >= this.laboratoireEntete.getLabTotAssurance() + this.laboratoireEntete.getLabTotComplmentaire() + this.laboratoireEntete.getLabTotSociete() + this.laboratoireEntete.getLabTotTaxeAssurance() + this.laboratoireEntete.getLabTotTaxeComplementaire() + this.laboratoireEntete.getLabTotTaxeSociete()) {
            this.laboratoireEntete.setLabSoldeTiers(1);
         } else {
            this.laboratoireEntete.setLabSoldeTiers(0);
         }

         this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var3);
      }

   }

   public void payeHospitalisation(long var1, Session var3) throws HibernateException, NamingException {
      this.hospitalisationEntete = this.hospitalisationEnteteDao.selectById(var1, var3);
      if (this.hospitalisationEntete != null) {
         double var4 = 0.0D;
         new ArrayList();
         List var6 = this.factureLigneMedicalDao.chargerLesLignesFacturesByNature(0L, this.hospitalisationEntete.getHosNum(), 77, var3);
         if (var6.size() != 0) {
            for(int var7 = 0; var7 < var6.size(); ++var7) {
               var4 += ((FactureLigneMedical)var6.get(var7)).getFacligMontantPaye();
            }
         }

         this.hospitalisationEntete.setHosRegTiers(var4);
         if (this.hospitalisationEntete.getHosRegTiers() >= this.hospitalisationEntete.getHosTotAssurance() + this.hospitalisationEntete.getHosTotComplmentaire() + this.hospitalisationEntete.getHosTotSociete() + this.hospitalisationEntete.getHosTotTaxeAssurance() + this.hospitalisationEntete.getHosTotTaxeComplementaire() + this.hospitalisationEntete.getHosTotTaxeSociete()) {
            this.hospitalisationEntete.setHosSoldeTiers(1);
         } else {
            this.hospitalisationEntete.setHosSoldeTiers(0);
         }

         this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var3);
      }

   }

   public void controleEcartRepartitionManuelle() {
      if (this.montantElmTotBonEnc != 0.0D) {
         this.var_affiche_valide = false;
         if (this.listFactureSelectionne.size() != 0) {
            this.totManuel = 0.0D;

            for(int var1 = 0; var1 < this.listFactureSelectionne.size(); ++var1) {
               this.totManuel += ((FactureEnteteMedical)this.listFactureSelectionne.get(var1)).getMontantReglementManuel();
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

   public void generationReglement(String var1, double var2, double var4, FactureEnteteMedical var6, ExercicesCaisse var7, Session var8) throws HibernateException, NamingException {
      this.reglements = new Reglements();
      if (var2 >= var6.getFacTotTtc() + var6.getFacTotTc() + var4) {
         this.reglements.setRglOperation("01");
      } else {
         this.reglements.setRglOperation("02");
      }

      this.reglements.setRglActivite("");
      this.reglements.setRglBudget(var6.getFacBudget());
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
      this.reglements.setRglDepartement(var6.getFacDepartement());
      this.reglements.setRglDepense(0.0D);
      this.reglements.setRglDevise(var6.getFacDevise());
      this.reglements.setRglDossier("");
      this.reglements.setRglFormatDevise(this.calculformatDevise(this.reglements.getRglDevise()));
      this.reglements.setRglDocument(var6.getFacNum());
      this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
      this.reglements.setRglIdBon(0L);
      this.reglements.setRglIdDocument(var6.getFacId());
      this.reglements.setRglIdTiers(var6.getTiers().getTieid());
      this.reglements.setRglDepotTiers(0);
      this.reglements.setRglLibelle(var6.getFacObject());
      this.reglements.setRglMode("" + this.varTypeReg);
      this.reglements.setRglModele(this.var_modele_trf);
      this.reglements.setRglNatureDoc(78);
      this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
      this.reglements.setRglNomTiers(var6.getVar_nom_tiers());
      this.reglements.setRglIdContact(var6.getFacIdContact());
      this.reglements.setRglNomContact(var6.getVar_nomContact());
      this.reglements.setRglNum(var1);
      this.reglements.setRglNumChqBdx(this.var_num_cheque);
      this.reglements.setRglObjet(this.var_objet);
      this.reglements.setRglParc("");
      this.reglements.setRglPdv("");
      this.reglements.setRglRecette(var2);
      double var14 = 0.0D;
      if (var4 != 0.0D) {
         int var11 = var6.getFacDate().getYear() + 1900;
         var14 = this.utilNombre.calculTimbre(this.structureLog, var2, var11, this.structureLog.getStrdevise(), this.reglements.getRglDateReg());
         this.reglements.setRglTimbre(var14);
      } else {
         this.reglements.setRglTimbre(0.0D);
      }

      this.reglements.setRglRegion("");
      this.reglements.setRglSecteur("");
      this.reglements.setRglSerie(var6.getFacSerie());
      this.reglements.setRglService(var6.getFacService());
      this.reglements.setRglSite(var6.getFacSite());
      this.reglements.setRglTrf(0);
      this.reglements.setRglTypeTiers(0);
      this.reglements.setRglTypeReg(this.varTypeReg);
      this.reglements.setRglUserCreat(this.usersLog.getUsrid());
      this.reglements.setRglGrp(this.usersLog.getUsrCollaboration());
      this.reglements.setRglUserModif(0L);
      this.reglements.setRglIdResponsable(0L);
      this.reglements.setRglNomResponsable("");
      this.reglements.setRglIdCommercial(var6.getFacIdCommercial());
      this.reglements.setRglNomCommercial(var6.getFacNomCommercial());
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
         var6.setFacTotReglement(var6.getFacTotReglement() + var2);
         var6.setFacTotTimbre(var6.getFacTotTimbre() + var14);
         if (var6.getFacTotReglement() >= var6.getFacTotTtc() + var6.getFacTotTc()) {
            var6.setFacSolde(1);
         } else {
            var6.setFacSolde(0);
         }

         var6.setFacDateLastReg(this.reglements.getRglDateReg());
         this.factureEnteteMedicalDao.modif(var6, var8);
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Refacturation");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.reglements = (Reglements)this.datamodelRecu.getRowData();
            this.reglementsDao.delete(this.reglements, var1);
            new ArrayList();
            List var3 = this.reglementsDao.reglementDocument(this.factureEnteteMedical.getFacId(), this.nature, var1);
            double var4 = 0.0D;
            if (var3.size() != 0) {
               for(int var6 = 0; var6 < var3.size(); ++var6) {
                  var4 += ((Reglements)var3.get(var6)).getRglRecette();
               }
            }

            this.factureEnteteMedical.setFacTotReglement(var4);
            if (this.factureEnteteMedical.getFacTotReglement() >= this.factureEnteteMedical.getFacTotTtc()) {
               this.factureEnteteMedical.setFacSolde(1);
            } else {
               this.factureEnteteMedical.setFacSolde(0);
            }

            this.factureEnteteMedical = this.factureEnteteMedicalDao.modif(this.factureEnteteMedical, var1);
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
      if (this.factureEnteteMedical != null) {
         this.selectPatient = false;
         this.reglements = new Reglements();
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

   public List getMesTiersItems() {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();

      for(int var3 = 0; var3 < var1.size(); ++var3) {
         var2.add(new SelectItem(((Tiers)var1.get(var3)).getTieid(), ((Tiers)var1.get(var3)).getTieprenom()));
      }

      return var2;
   }

   public void rechercheTiersCtrl() throws HibernateException, NamingException {
      Object var1 = new ArrayList();
      if (this.inpClient != null && !this.inpClient.isEmpty()) {
         String var2 = "(3)";
         var1 = this.tiersDao.verifTiers(this.usersLog, var2, this.inpClient, (Session)null);
         this.showModalPanelListeTiers = true;
      } else {
         ((List)var1).clear();
         this.showModalPanelListeTiers = false;
      }

      this.datamodelListeTiers.setWrappedData(var1);
   }

   public void rechercheTiers() throws HibernateException, NamingException {
      this.fondsCnamgs = 99;
      Object var1 = new ArrayList();
      if (this.inpNomTiers != null && !this.inpNomTiers.isEmpty()) {
         String var2 = "(3)";
         var1 = this.tiersDao.verifTiers(this.usersLog, var2, this.inpNomTiers, (Session)null);
         this.showModalPanelListeTiers = true;
      } else {
         this.tiers = null;
         ((List)var1).clear();
         this.showModalPanelListeTiers = false;
      }

      this.datamodelListeTiers.setWrappedData(var1);
   }

   public void selectionligneTiers() throws JDOMException, IOException {
      if (this.datamodelListeTiers.isRowAvailable()) {
         this.tiers = (Tiers)this.datamodelListeTiers.getRowData();
      }

   }

   public void calculeTiers() throws JDOMException, IOException {
      if (this.tiers == null) {
         this.selectionligneTiers();
      }

      if (this.tiers != null) {
         this.inpNomTiers = this.tiers.getTieraisonsocialenom();
         this.idTiers = this.tiers.getTieid();
         this.inpClient = this.inpNomTiers;
      } else {
         this.tiers = null;
         this.inpNomTiers = "";
         this.idTiers = 0L;
         this.inpClient = "";
      }

      this.showModalPanelListeTiers = false;
   }

   public void annuleTiers() {
      this.tiers = null;
      this.inpNomTiers = "";
      this.idTiers = 0L;
      this.inpClient = "";
      this.showModalPanelListeTiers = false;
   }

   public void rechercheFeuille() throws HibernateException, NamingException {
      if (this.inpFeuille != null && !this.inpFeuille.isEmpty()) {
         this.consultationEnteteGene = this.consultationEnteteGeneDao.selectByFeuille(this.inpFeuille, (Session)null);
         boolean var1;
         int var2;
         if (this.consultationEnteteGene != null) {
            var1 = false;

            for(var2 = 0; var2 < this.lesTiersConcernes.size(); ++var2) {
               if (((DocumentEntete)this.lesTiersConcernes.get(var2)).getDocIdCreateur() == this.consultationEnteteGene.getCsgId()) {
                  var1 = true;
                  break;
               }
            }

            if (!var1) {
               this.calculeConsultation_2(this.consultationEnteteGene);
               this.dataModelTiersConcernes.setWrappedData(this.lesTiersConcernes);
            }
         } else {
            this.pharmacieEntete = this.pharmacieEnteteDao.selectByFeuille(this.inpFeuille, (Session)null);
            if (this.pharmacieEntete != null) {
               var1 = false;

               for(var2 = 0; var2 < this.lesTiersConcernes.size(); ++var2) {
                  if (((DocumentEntete)this.lesTiersConcernes.get(var2)).getDocIdCreateur() == this.pharmacieEntete.getPhaId()) {
                     var1 = true;
                     break;
                  }
               }

               if (!var1) {
                  this.calculePharmacie_2(this.pharmacieEntete);
                  this.dataModelTiersConcernes.setWrappedData(this.lesTiersConcernes);
               }
            } else {
               this.laboratoireEntete = this.laboratoireEnteteDao.selectByFeuille(this.inpFeuille, (Session)null);
               if (this.laboratoireEntete != null) {
                  var1 = false;

                  for(var2 = 0; var2 < this.lesTiersConcernes.size(); ++var2) {
                     if (((DocumentEntete)this.lesTiersConcernes.get(var2)).getDocIdCreateur() == this.laboratoireEntete.getLabId()) {
                        var1 = true;
                        break;
                     }
                  }

                  if (!var1) {
                     this.calculeLaboratoire_2(this.laboratoireEntete, (Session)null);
                     this.dataModelTiersConcernes.setWrappedData(this.lesTiersConcernes);
                  }
               } else {
                  this.hospitalisationEntete = this.hospitalisationEnteteDao.selectByFeuille(this.inpFeuille, (Session)null);
                  if (this.hospitalisationEntete != null) {
                     var1 = false;

                     for(var2 = 0; var2 < this.lesTiersConcernes.size(); ++var2) {
                        if (((DocumentEntete)this.lesTiersConcernes.get(var2)).getDocIdCreateur() == this.hospitalisationEntete.getHosId()) {
                           var1 = true;
                           break;
                        }
                     }

                     if (!var1) {
                        this.calculeHospitalisation_2(this.hospitalisationEntete);
                        this.dataModelTiersConcernes.setWrappedData(this.lesTiersConcernes);
                     }
                  }
               }
            }
         }
      }

      this.inpFeuille = "";
      this.nbLigneTotal = this.lesTiersConcernes.size();
   }

   public void rechercheByPatient() throws HibernateException, NamingException {
      if (this.patientDocument != null) {
         this.nomPatientDocument = this.patientDocument.getPatronyme();
         this.idPatient = this.patientDocument.getPatId();
      } else {
         this.patientDocument = null;
         this.nomPatientDocument = "";
         this.idPatient = 0L;
      }

      this.showModalPanelPatients = false;
      if (this.idPatient != 0L) {
         this.consultationEnteteGene = this.consultationEnteteGeneDao.selectByPatient(this.idPatient, (Session)null);
         if (this.consultationEnteteGene != null) {
            this.calculeConsultation_2(this.consultationEnteteGene);
            this.dataModelTiersConcernes.setWrappedData(this.lesTiersConcernes);
         } else {
            this.pharmacieEntete = this.pharmacieEnteteDao.selectByPatient(this.idPatient, (Session)null);
            if (this.pharmacieEntete != null) {
               this.calculePharmacie_2(this.pharmacieEntete);
               this.dataModelTiersConcernes.setWrappedData(this.lesTiersConcernes);
            } else {
               this.laboratoireEntete = this.laboratoireEnteteDao.selectByPatient(this.idPatient, (Session)null);
               if (this.laboratoireEntete != null) {
                  this.calculeLaboratoire_2(this.laboratoireEntete, (Session)null);
                  this.dataModelTiersConcernes.setWrappedData(this.lesTiersConcernes);
               } else {
                  this.hospitalisationEntete = this.hospitalisationEnteteDao.selectByPatient(this.idPatient, (Session)null);
                  if (this.hospitalisationEntete != null) {
                     this.calculeHospitalisation_2(this.hospitalisationEntete);
                     this.dataModelTiersConcernes.setWrappedData(this.lesTiersConcernes);
                  }
               }
            }
         }
      }

      this.patientDocument = null;
      this.nomPatientDocument = "";
      this.idPatient = 0L;
      this.nbLigneTotal = this.lesTiersConcernes.size();
   }

   public void recherchePatients() throws HibernateException, NamingException {
      this.lespatients.clear();
      this.showModalPanelPatients = false;
      if (this.nomPatientDocument != null && !this.nomPatientDocument.isEmpty()) {
         this.lespatients = this.patientsDao.chargerlesPatients(this.nomPatientDocument, (Session)null);
         this.dataModelPatients.setWrappedData(this.lespatients);
         this.showModalPanelPatients = true;
      }

   }

   public void selectionlignePatients() throws JDOMException, IOException {
      if (this.dataModelPatients.isRowAvailable()) {
         this.patientDocument = (Patients)this.dataModelPatients.getRowData();
      }

   }

   public void calculePatients() throws JDOMException, IOException {
      if (this.patientDocument == null) {
         this.selectionlignePatients();
      }

      if (this.patientDocument != null) {
         this.nomPatientDocument = this.patientDocument.getPatronyme();
      } else {
         this.patientDocument = null;
         this.nomPatientDocument = "";
      }

      this.showModalPanelPatients = false;
   }

   public void annulePatients() {
      this.showModalPanelPatients = false;
   }

   public void ouvrirImpressionCtrl() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "refacturation" + File.separator + "ctrl" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.modeleTrfItems = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4];
               if (this.verificationAutorisation(var5)) {
                  String var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                  this.modeleTrfItems.add(new SelectItem(var6));
               }
            }
         }
      }

      this.showModalPanelPrintRecu = true;
   }

   public void fermerImpressionCtrl() {
      this.showModalPanelPrintRecu = false;
   }

   public void imprimerCtrlPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionCtrl("PRT");
   }

   public void imprimerCtrlJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionCtrl("JRV");
   }

   public void imprimerCtrlPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionCtrl("PDF");
   }

   public void imprimerCtrlODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionCtrl("ODT");
   }

   public void imprimerCtrlXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionCtrl("XLS");
   }

   public void imprimerCtrlDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionCtrl("DOC");
   }

   public void imprimerCtrlHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionCtrl("HTML");
   }

   public void imprimerCtrlXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.impressionCtrl("XML");
   }

   public void impressionCtrl(String var1) throws IOException, HibernateException, NamingException, SQLException, JRException, ClassNotFoundException, MalformedURLException, Exception {
      if (this.var_modele_trf != null && !this.var_modele_trf.isEmpty()) {
         UtilPrint var2 = new UtilPrint(this.utilInitHibernate);
         JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(this.lesEntetesCtrl);
         var2.setjRBeanCollectionDataSource(var3);
         var2.setRapport(this.var_modele_trf);
         var2.setEntete("Impression CTRL");
         String var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "refacturation" + File.separator + "ctrl" + File.separator;
         var2.setCheminRapport(var4);
         String var5 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport";
         var2.setCheminSousrapport(var5);
         var2.setImageFondPage((String)null);
         var2.setFormat(var1);
         var2.setIdResponsable(this.usersLog.getUsrid());
         var2.setIdCommercial(0L);
         var2.setTiersSelectionne((Tiers)null);
         var2.setContact((Contacts)null);
         var2.setNumDoc("");
         var2.setNature(this.nature);
         var2.setId_doc(0L);
         var2.setParc((Parc)null);
         var2.setBaseLog(this.baseLog);
         var2.setStructureLog(this.structureLog);
         var2.setUsersLog(this.usersLog);
         var2.imprimeRapport();
      }

   }

   public void chargeListeRecapitulatif() throws HibernateException, NamingException, ParseException {
      this.chargeListeRecapitulatif((Session)null);
   }

   public void chargeListeRecapitulatif(Session var1) throws HibernateException, NamingException, ParseException {
      if (this.inpNomTiers == null || this.inpNomTiers.isEmpty()) {
         this.fondsCnamgs = 99;
      }

      this.listeFacturesRecap.clear();
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

      int var13;
      if (this.inpEtat != 50) {
         new ArrayList();
         List var12 = this.recapitulatifMedicalDao.recherche(var1, this.exercicesVentes.getExevteId(), this.getInpNum(), this.getInpClient(), this.getFondsCnamgs(), this.getInpEtat(), this.getInpSerie(), this.getPeriode(), this.getInpService(), this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.getInpCommercial(), var10, var11);

         for(var13 = 0; var13 < var12.size(); ++var13) {
            if (this.fondsCnamgs == 99 || this.fondsCnamgs != 99 && ((RecapitulatifMedical)var12.get(var13)).getFacrecFondCnamgs() == this.fondsCnamgs) {
               this.listeFacturesRecap.add(var12.get(var13));
            }
         }
      }

      this.dataModelFactureRecap.setWrappedData(this.listeFacturesRecap);
      if (this.listeFacturesRecap.size() > 0) {
         new RecapitulatifMedical();

         for(var13 = 0; var13 < this.listeFacturesRecap.size(); ++var13) {
            RecapitulatifMedical var14 = (RecapitulatifMedical)this.listeFacturesRecap.get(var13);
            var2 += var14.getFacrecTotTtc();
            var4 += var14.getFacrecTotReglement();
            var6 += var14.getFacrecTotHt();
            var8 += var14.getFacrecTotTva();
         }

         this.var_nb_ligne = this.listeFacturesRecap.size();
      }

      this.totauxHt = var2;
      this.totauxHt = var6;
      this.totauxTaxe = var8;
      this.montantTtc = var2;
      this.montantReglement = var4;
      this.montantSolde = var2 - var4;
      this.visibiliteBton = false;
   }

   public void selectionRecap() throws HibernateException, NamingException {
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
            this.recapitulatifMedical = (RecapitulatifMedical)var1.get(0);
            this.tiers = this.recapitulatifMedical.getTiers();
            this.formRecherche.setTiers(this.tiers);
            if (!this.recapitulatifMedical.getTiers().getTiegenre().equalsIgnoreCase("010") && !this.recapitulatifMedical.getTiers().getTiegenre().equalsIgnoreCase("020") && !this.recapitulatifMedical.getTiers().getTiegenre().equalsIgnoreCase("030") && !this.recapitulatifMedical.getTiers().getTiegenre().equalsIgnoreCase("037")) {
               this.var_typeTiers = true;
            } else {
               this.var_typeTiers = false;
            }

            if (this.tiers.getTiecategorie() == null || this.tiers.getTiecategorie().isEmpty() || !this.tiers.getTiecategorie().equals("Assurance") && !this.tiers.getTiecategorie().equals("Mutuelle/Assurance") && !this.tiers.getTiecategorie().equals("IPM") && !this.tiers.getTiecategorie().equals("Programme Médical")) {
               if (this.tiers.getTiecategorie() == null || this.tiers.getTiecategorie().isEmpty() || !this.tiers.getTiecategorie().equalsIgnoreCase("Client société") && !this.tiers.getTiecategorie().equalsIgnoreCase("Ministère") && !this.tiers.getTiecategorie().equalsIgnoreCase("Hôpital") && !this.tiers.getTiecategorie().equalsIgnoreCase("Direction") && !this.tiers.getTiecategorie().equalsIgnoreCase("Mairie")) {
                  this.typeTiers = 0;
               } else {
                  this.typeTiers = 2;
               }
            } else {
               this.typeTiers = 1;
            }

            this.calculMessageLitige();
            this.var_nom_contact = this.recapitulatifMedical.getFacrecIdContact();
            this.calculDevise();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "Refacturation");
            this.lesEmployeursItems.clear();
            if (this.typeTiers == 1) {
               this.lesEmployeursItems = this.tiersAdherentDao.listAdherentByTiersItems(this.tiers, var4);
            }

            this.chargerDocumentRecap(var4);
            this.chargerUserChronoRecap(var4);
            this.numLigne = 0;
            this.verrouNum = true;
            this.visibiliteBton = true;
            this.utilInitHibernate.closeSession();
            this.setMontantTtcElmt(this.recapitulatifMedical.getFacrecTotTtc());
            this.setMontantReglementElmt(this.recapitulatifMedical.getFacrecTotReglement());
            this.setMontantElmTotBonEnc(this.recapitulatifMedical.getFacrecTotTtc() - this.var_tot_bon_encaissement);
            this.setMontantSoldeElmt(this.recapitulatifMedical.getFacrecTotTtc() - this.recapitulatifMedical.getFacrecTotReglement());
            this.calculeTotalRecap();
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationRecap() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.recapitulatifMedical != null) {
         this.consultRecap();
      }

   }

   public void chargerDocumentRecap(Session var1) throws HibernateException, NamingException {
      this.listFactureSelectionne.clear();
      if (this.recapitulatifMedical.getFacrecId() > 0L) {
         this.listFactureSelectionne = this.factureEnteteMedicalDao.rechercheByRecap(this.recapitulatifMedical.getFacrecNum(), var1);
      }

      this.dataModelEntetesCtrl.setWrappedData(this.listFactureSelectionne);
   }

   public void chargerUserChronoRecap(Session var1) throws HibernateException, NamingException {
      if (this.recapitulatifMedical != null && this.recapitulatifMedical.getFacrecSerie() != null && !this.recapitulatifMedical.getFacrecSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.recapitulatifMedical.getFacrecSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void ajoutRecap() throws ParseException {
      this.recapitulatifMedical = new RecapitulatifMedical();
      this.dateDebut = this.utilDate.datePremierJourMois(new Date());
      this.dateFin = this.utilDate.dateDernierJourMois(new Date());
      this.dateFacture = new Date();
      this.facturesChargee = false;
      this.tiersChargee = false;
      this.afficheBoutonFacture = false;
      this.var_action = 1;
   }

   public void rechercheFactureRecap() throws HibernateException, NamingException {
      this.inpNomTiersPayeurs = "";
      String var1 = "";
      this.listeFacturesLibre.clear();
      this.lesTiersPayeurs.clear();
      new ArrayList();
      List var2 = this.factureEnteteMedicalDao.rechercheFactureByDateOrder(this.dateDebut, this.dateFin, (Session)null);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.factureEnteteMedical = (FactureEnteteMedical)var2.get(var3);
            if (this.factureEnteteMedical.getFacEtat() == 1 && (this.factureEnteteMedical.getFacNumRecap() == null || this.factureEnteteMedical.getFacNumRecap().isEmpty()) && this.factureEnteteMedical.getFacNomTiers() != null && !this.factureEnteteMedical.getFacNomTiers().isEmpty()) {
               this.listeFacturesLibre.add(this.factureEnteteMedical);
               String var4 = this.factureEnteteMedical.getFacNomTiers();
               if (this.factureEnteteMedical.getFacFondCnamgs() == 1) {
                  var1 = "Fonds 1 + Consultations (SP)";
               } else if (this.factureEnteteMedical.getFacFondCnamgs() == 2) {
                  var1 = "Fonds 2 + Consultations (AP)";
               } else if (this.factureEnteteMedical.getFacFondCnamgs() == 3) {
                  var1 = "Fonds 3 + Consultations (GEF)";
               } else if (this.factureEnteteMedical.getFacFondCnamgs() == 11) {
                  var1 = "Fonds 1 + Examens (SP)";
               } else if (this.factureEnteteMedical.getFacFondCnamgs() == 12) {
                  var1 = "Fonds 2 + Examens (AP)";
               } else if (this.factureEnteteMedical.getFacFondCnamgs() == 13) {
                  var1 = "Fonds 3 + Examens (GEF)";
               } else if (this.factureEnteteMedical.getFacFondCnamgs() == 21) {
                  var1 = "Fonds 1 + Pharmacie (SP)";
               } else if (this.factureEnteteMedical.getFacFondCnamgs() == 22) {
                  var1 = "Fonds 2 + Pharmacie (AP)";
               } else if (this.factureEnteteMedical.getFacFondCnamgs() == 23) {
                  var1 = "Fonds 3 + Pharmacie (GEF)";
               } else if (this.factureEnteteMedical.getFacFondCnamgs() == 31) {
                  var1 = "Fonds 1 + Hospitalisation (SP)";
               } else if (this.factureEnteteMedical.getFacFondCnamgs() == 32) {
                  var1 = "Fonds 2 + Hospitalisation (AP)";
               } else if (this.factureEnteteMedical.getFacFondCnamgs() == 33) {
                  var1 = "Fonds 3 + Hospitalisation (GEF)";
               } else {
                  var1 = "";
               }

               if (var1 != null && !var1.isEmpty()) {
                  var4 = var4 + ":" + var1;
               }

               boolean var5 = false;
               if (this.lesTiersPayeurs.size() != 0) {
                  for(int var6 = 0; var6 < this.lesTiersPayeurs.size(); ++var6) {
                     String var7 = ((SelectItem)this.lesTiersPayeurs.get(var6)).getValue().toString();
                     if (var7 != null && !var7.isEmpty() && var7.equals(var4)) {
                        var5 = true;
                        break;
                     }
                  }
               }

               if (!var5) {
                  if (var1 != null && !var1.isEmpty()) {
                     this.lesTiersPayeurs.add(new SelectItem(this.factureEnteteMedical.getFacNomTiers() + ":" + var1));
                  } else {
                     this.lesTiersPayeurs.add(new SelectItem(this.factureEnteteMedical.getFacNomTiers()));
                  }
               }
            }
         }
      }

      this.dataModelFactureLibre.setWrappedData(this.listeFacturesLibre);
      if (this.listeFacturesLibre.size() != 0) {
         this.facturesChargee = true;
         this.tiersChargee = false;
      }

   }

   public void rechercheFactureTiers() throws HibernateException, NamingException {
      this.listFactureSelectionne.clear();
      this.tiersChargee = false;
      if (this.inpNomTiersPayeurs != null && !this.inpNomTiersPayeurs.isEmpty()) {
         String var1 = "";
         this.fondsCnamgs = 0;

         int var2;
         for(var2 = 0; var2 < this.lesTiersPayeurs.size(); ++var2) {
            if (this.inpNomTiersPayeurs.contains("Fonds")) {
               if (((SelectItem)this.lesTiersPayeurs.get(var2)).getValue().toString().contains(":")) {
                  String[] var3 = ((SelectItem)this.lesTiersPayeurs.get(var2)).getValue().toString().split(":");
                  String var4 = var3[1];
                  if (var4.equalsIgnoreCase("Fonds 1 + Consultations (SP)") && this.inpNomTiersPayeurs.contains(var4)) {
                     var1 = var3[0];
                     this.fondsCnamgs = 1;
                     break;
                  }

                  if (var4.equalsIgnoreCase("Fonds 2 + Consultations (AP)") && this.inpNomTiersPayeurs.contains(var4)) {
                     var1 = var3[0];
                     this.fondsCnamgs = 2;
                     break;
                  }

                  if (var4.equalsIgnoreCase("Fonds 3 + Consultations (GEF)") && this.inpNomTiersPayeurs.contains(var4)) {
                     var1 = var3[0];
                     this.fondsCnamgs = 3;
                     break;
                  }

                  if (var4.equalsIgnoreCase("Fonds 1 + Examens (SP)") && this.inpNomTiersPayeurs.contains(var4)) {
                     var1 = var3[0];
                     this.fondsCnamgs = 11;
                     break;
                  }

                  if (var4.equalsIgnoreCase("Fonds 2 + Examens (AP)") && this.inpNomTiersPayeurs.contains(var4)) {
                     var1 = var3[0];
                     this.fondsCnamgs = 12;
                     break;
                  }

                  if (var4.equalsIgnoreCase("Fonds 3 + Examens (GEF)") && this.inpNomTiersPayeurs.contains(var4)) {
                     var1 = var3[0];
                     this.fondsCnamgs = 13;
                     break;
                  }

                  if (var4.equalsIgnoreCase("Fonds 1 + Pharmacie (SP)") && this.inpNomTiersPayeurs.contains(var4)) {
                     var1 = var3[0];
                     this.fondsCnamgs = 21;
                     break;
                  }

                  if (var4.equalsIgnoreCase("Fonds 2 + Pharmacie (AP)") && this.inpNomTiersPayeurs.contains(var4)) {
                     var1 = var3[0];
                     this.fondsCnamgs = 22;
                     break;
                  }

                  if (var4.equalsIgnoreCase("Fonds 3 + Pharmacie (GEF)") && this.inpNomTiersPayeurs.contains(var4)) {
                     var1 = var3[0];
                     this.fondsCnamgs = 23;
                     break;
                  }

                  if (var4.equalsIgnoreCase("Fonds 1 + Hospitalisation (SP)") && this.inpNomTiersPayeurs.contains(var4)) {
                     var1 = var3[0];
                     this.fondsCnamgs = 31;
                     break;
                  }

                  if (var4.equalsIgnoreCase("Fonds 1 + Hospitalisation (AP)") && this.inpNomTiersPayeurs.contains(var4)) {
                     var1 = var3[0];
                     this.fondsCnamgs = 32;
                     break;
                  }

                  if (var4.equalsIgnoreCase("Fonds 1 + Hospitalisation (GEF)") && this.inpNomTiersPayeurs.contains(var4)) {
                     var1 = var3[0];
                     this.fondsCnamgs = 33;
                     break;
                  }

                  var1 = "";
                  this.fondsCnamgs = 0;
               } else {
                  var1 = "";
                  this.fondsCnamgs = 0;
               }
            } else if (((SelectItem)this.lesTiersPayeurs.get(var2)).getValue().toString().equals(this.inpNomTiersPayeurs)) {
               var1 = ((SelectItem)this.lesTiersPayeurs.get(var2)).getValue().toString();
               this.fondsCnamgs = 0;
               break;
            }
         }

         if (var1 != null && !var1.isEmpty()) {
            for(var2 = 0; var2 < this.listeFacturesLibre.size(); ++var2) {
               this.factureEnteteMedical = (FactureEnteteMedical)this.listeFacturesLibre.get(var2);
               if (this.factureEnteteMedical.getFacNomTiers().equalsIgnoreCase(var1)) {
                  if (this.fondsCnamgs != 0) {
                     if (this.factureEnteteMedical.getFacFondCnamgs() == this.fondsCnamgs) {
                        this.listFactureSelectionne.add(this.factureEnteteMedical);
                     }
                  } else {
                     this.listFactureSelectionne.add(this.factureEnteteMedical);
                  }
               }
            }

            this.tiersChargee = true;
         }
      }

      this.dataModelFactureLibre.setWrappedData(this.listFactureSelectionne);
   }

   public void annulerRecap() throws HibernateException, NamingException {
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = 0.0D;
      double var11 = 0.0D;
      double var13 = 0.0D;
      double var15 = 0.0D;

      for(int var17 = 0; var17 < this.listeFacturesLibre.size(); ++var17) {
         if (((FactureEnteteMedical)this.listeFacturesLibre.get(var17)).isVar_select_ligne()) {
            var1 += ((FactureEnteteMedical)this.listeFacturesLibre.get(var17)).getFacTotHt();
            var9 += ((FactureEnteteMedical)this.listeFacturesLibre.get(var17)).getFacTotTc();
            var15 += ((FactureEnteteMedical)this.listeFacturesLibre.get(var17)).getFacTotTva();
            var13 += ((FactureEnteteMedical)this.listeFacturesLibre.get(var17)).getFacTotTtc();
         }
      }

      this.recapitulatifMedical.setFacrecTotHt(var1);
      this.recapitulatifMedical.setFacrecTotRabais(var3);
      this.recapitulatifMedical.setFacrecTotReglement(var5);
      this.recapitulatifMedical.setFacrecTotRemise(var7);
      this.recapitulatifMedical.setFacrecTotTc(var9);
      this.recapitulatifMedical.setFacrecTotTimbre(var11);
      this.recapitulatifMedical.setFacrecTotTtc(var13);
      this.recapitulatifMedical.setFacrecTotTva(var15);
      this.recapitulatifMedical = this.recapitulatifMedicalDao.modif(this.recapitulatifMedical);
      this.var_action = 0;
   }

   public void calculeTotalRecap() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      int var7 = 0;
      int var8;
      if (this.listFactureSelectionne.size() != 0) {
         for(var8 = 0; var8 < this.listFactureSelectionne.size(); ++var8) {
            var1 += ((FactureEnteteMedical)this.listFactureSelectionne.get(var8)).getFacTotHt();
            var3 += ((FactureEnteteMedical)this.listFactureSelectionne.get(var8)).getFacTotTva();
            var5 += ((FactureEnteteMedical)this.listFactureSelectionne.get(var8)).getFacTotTtc();
            ++var7;
         }
      } else {
         for(var8 = 0; var8 < this.listeFacturesLibre.size(); ++var8) {
            if (((FactureEnteteMedical)this.listeFacturesLibre.get(var8)).isVar_select_ligne()) {
               var1 += ((FactureEnteteMedical)this.listeFacturesLibre.get(var8)).getFacTotHt();
               var3 += ((FactureEnteteMedical)this.listeFacturesLibre.get(var8)).getFacTotTva();
               var5 += ((FactureEnteteMedical)this.listeFacturesLibre.get(var8)).getFacTotTtc();
               ++var7;
            }
         }
      }

      this.montantTtc = var1;
      this.montantReglement = var3;
      this.montantSolde = var5;
      this.var_nb_ligne = var7;
   }

   public void saveRecap() throws HibernateException, NamingException {
      if (this.inpNomTiersPayeurs != null && !this.inpNomTiersPayeurs.isEmpty()) {
         String var1 = "";
         if (this.inpNomTiersPayeurs.contains(":")) {
            String[] var2 = this.inpNomTiersPayeurs.split(":");
            var1 = var2[0];
         } else {
            var1 = this.inpNomTiersPayeurs;
         }

         this.tiers = this.tiersDao.chargerLesTiers("3", var1, (Session)null);
         if (this.tiers != null) {
            Session var32 = this.utilInitHibernate.getOpenSession(this.baseLog, "Refacturation");
            Transaction var3 = null;

            try {
               var3 = var32.beginTransaction();
               String var4 = "";
               String var5 = "";
               String var6 = "";
               if (this.recapitulatifMedical.getFacrecId() == 0L) {
                  var5 = ((FactureEnteteMedical)this.listeFacturesLibre.get(0)).getFacSerie();
                  var6 = ((FactureEnteteMedical)this.listeFacturesLibre.get(0)).getFacOrigine();
                  if (this.dateFacture == null) {
                     this.dateFacture = new Date();
                  }

                  var4 = this.calculChrono.numCompose(this.dateFacture, 182, var5, var32);
               } else {
                  var4 = this.recapitulatifMedical.getFacrecNum();
                  var5 = this.recapitulatifMedical.getFacrecSerie();
                  var6 = this.recapitulatifMedical.getFacrecOrigine();
                  this.dateFacture = this.recapitulatifMedical.getFacrecDate();
                  this.dateDebut = this.recapitulatifMedical.getFacrecDateDebut();
                  this.dateFin = this.recapitulatifMedical.getFacrecDateFin();
                  this.fondsCnamgs = this.recapitulatifMedical.getFacrecFondCnamgs();
               }

               this.recapitulatifMedical.setExerciceventes(this.exercicesVentes);
               this.recapitulatifMedical.setTiers(this.tiers);
               this.recapitulatifMedical.setUsers(this.usersLog);
               this.recapitulatifMedical.setFacrecCivilTiers(this.tiers.getTiecivilite());
               this.recapitulatifMedical.setFacrecCat(this.tiers.getTiecategorie());
               this.recapitulatifMedical.setFacrecDate(this.dateFacture);
               this.recapitulatifMedical.setFacrecDateDebut(this.dateDebut);
               this.recapitulatifMedical.setFacrecDateFin(this.dateFin);
               this.recapitulatifMedical.setFacrecDateCreat(new Date());
               this.recapitulatifMedical.setFacrecDevise(this.structureLog.getStrdevise());
               this.recapitulatifMedical.setFacrecEtat(1);
               this.recapitulatifMedical.setFacrecEtatVal(0);
               this.recapitulatifMedical.setFacrecFondCnamgs(this.fondsCnamgs);
               this.recapitulatifMedical.setFacrecExoTva(this.tiers.getTieexotva());
               this.recapitulatifMedical.setFacrecIdCreateur(this.usersLog.getUsrid());
               this.recapitulatifMedical.setFacrecIdAdherent(0L);
               this.recapitulatifMedical.setFacrecNomAdherent("");
               this.recapitulatifMedical.setFacrecNomCreateur(this.usersLog.getUsrPatronyme());
               this.recapitulatifMedical.setFacrecNomTiers(this.tiers.getTieraisonsocialenom());
               this.recapitulatifMedical.setFacrecNum(var4);
               String var7 = "";
               String var8 = "";
               if (this.dateFacture.getMonth() + 1 <= 9) {
                  var8 = "0" + (this.dateFacture.getMonth() + 1);
               } else {
                  var8 = "" + (this.dateFacture.getMonth() + 1);
               }

               String var9 = "" + (this.dateFacture.getYear() + 1900);
               var7 = var8 + ":" + var9;
               this.recapitulatifMedical.setFacrecPeriode(var7);
               this.recapitulatifMedical.setFacrecSerie(var5);
               if (this.listFactureSelectionne.size() != 0) {
                  this.calculeTotalRecap();
                  this.recapitulatifMedical.setFacrecTotHt(this.montantTtc);
                  this.recapitulatifMedical.setFacrecTotTva(this.montantReglement);
                  this.recapitulatifMedical.setFacrecTotTtc(this.montantSolde);
               } else {
                  double var10 = 0.0D;
                  double var12 = 0.0D;
                  double var14 = 0.0D;
                  double var16 = 0.0D;
                  double var18 = 0.0D;
                  double var20 = 0.0D;
                  double var22 = 0.0D;
                  double var24 = 0.0D;

                  for(int var26 = 0; var26 < this.listeFacturesLibre.size(); ++var26) {
                     if (((FactureEnteteMedical)this.listeFacturesLibre.get(var26)).isVar_select_ligne()) {
                        var10 += ((FactureEnteteMedical)this.listeFacturesLibre.get(var26)).getFacTotHt();
                        var18 += ((FactureEnteteMedical)this.listeFacturesLibre.get(var26)).getFacTotTc();
                        var24 += ((FactureEnteteMedical)this.listeFacturesLibre.get(var26)).getFacTotTva();
                        var22 += ((FactureEnteteMedical)this.listeFacturesLibre.get(var26)).getFacTotTtc();
                     }
                  }

                  this.recapitulatifMedical.setFacrecTotHt(var10);
                  this.recapitulatifMedical.setFacrecTotRabais(var12);
                  this.recapitulatifMedical.setFacrecTotReglement(var14);
                  this.recapitulatifMedical.setFacrecTotRemise(var16);
                  this.recapitulatifMedical.setFacrecTotTc(var18);
                  this.recapitulatifMedical.setFacrecTotTimbre(var20);
                  this.recapitulatifMedical.setFacrecTotTtc(var22);
                  this.recapitulatifMedical.setFacrecTotTva(var24);
               }

               this.recapitulatifMedical.setFacrecOrigine(var6);
               if (this.recapitulatifMedical.getFacrecId() == 0L) {
                  this.recapitulatifMedical = this.recapitulatifMedicalDao.insert(this.recapitulatifMedical, var32);
               } else {
                  this.recapitulatifMedical = this.recapitulatifMedicalDao.modif(this.recapitulatifMedical, var32);
               }

               for(int var33 = 0; var33 < this.listeFacturesLibre.size(); ++var33) {
                  this.factureEnteteMedical = (FactureEnteteMedical)this.listeFacturesLibre.get(var33);
                  if (this.factureEnteteMedical.isVar_select_ligne()) {
                     this.factureEnteteMedical.setFacNumRecap(var4);
                     this.factureEnteteMedical.setFacDateRecap(this.dateFacture);
                     this.factureEnteteMedical = this.factureEnteteMedicalDao.modif(this.factureEnteteMedical, var32);
                  }
               }

               var3.commit();
            } catch (HibernateException var30) {
               if (var3 != null) {
                  var3.rollback();
               }

               throw var30;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      this.var_action = 0;
   }

   public void supprimerRecap() throws HibernateException, NamingException {
      if (this.recapitulatifMedical != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Refacturation");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.listFactureSelectionne.size() != 0) {
               for(int var3 = 0; var3 < this.listFactureSelectionne.size(); ++var3) {
                  this.factureEnteteMedical = (FactureEnteteMedical)this.listFactureSelectionne.get(var3);
                  this.factureEnteteMedical.setFacDateRecap((Date)null);
                  this.factureEnteteMedical.setFacNumRecap((String)null);
                  this.factureEnteteMedical = this.factureEnteteMedicalDao.modif(this.factureEnteteMedical, var1);
               }
            }

            this.listFactureSelectionne.clear();
            this.dataModelFactureLibre.setWrappedData(this.listFactureSelectionne);
            this.recapitulatifMedicalDao.delete(this.recapitulatifMedical.getFacrecId(), var1);
            this.listeFacturesRecap.remove(this.recapitulatifMedical);
            this.dataModelFactureRecap.setWrappedData(this.listeFacturesRecap);
            Espion var9 = new Espion();
            var9.setUsers(this.usersLog);
            var9.setEsptype(0);
            var9.setEspdtecreat(new Date());
            var9.setEspaction("Suppression récapitulatif (M.) N° " + this.recapitulatifMedical.getFacrecNum() + " du " + this.utilDate.dateToStringSQLLight(this.recapitulatifMedical.getFacrecDate()));
            this.espionDao.mAJEspion(var9, var1);
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

   public void valideRecap() throws HibernateException, NamingException {
      if (this.recapitulatifMedical != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Refacturation");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.recapitulatifMedical.getFacrecEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.recapitulatifMedical.setFacrecEtat(1);
               this.recapitulatifMedical = this.recapitulatifMedicalDao.modif(this.recapitulatifMedical, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle récapitulatif (M.) N° " + this.recapitulatifMedical.getFacrecNum() + " du " + this.utilDate.dateToStringSQLLight(this.recapitulatifMedical.getFacrecDate()));
               this.espionDao.mAJEspion(var3, var1);
               if (this.tiers.getTieDteDocument5() == null || this.recapitulatifMedical.getFacrecDate().after(this.tiers.getTieDteDocument5())) {
                  this.tiers.setTieDteDocument5(this.recapitulatifMedical.getFacrecDate());
                  this.tiers = this.tiersDao.modif(this.tiers, var1);
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
      }

   }

   public void deValideRecap() throws HibernateException, NamingException {
      if (this.recapitulatifMedical != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Refacturation");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.recapitulatifMedical.getFacrecEtat() == 1) {
               this.recapitulatifMedical.setFacrecEtat(0);
               this.recapitulatifMedical = this.recapitulatifMedicalDao.modif(this.recapitulatifMedical, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dé-validation manuelle récapitulatif (M.) N° " + this.recapitulatifMedical.getFacrecNum() + " du " + this.utilDate.dateToStringSQLLight(this.recapitulatifMedical.getFacrecDate()));
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

   public void selectionFacture() {
      if (this.dataModelEntetesCtrl.isRowAvailable()) {
         this.factureEnteteMedical = (FactureEnteteMedical)this.dataModelEntetesCtrl.getRowData();
         this.afficheBoutonFacture = true;
      }

   }

   public void modifRecap() {
      if (this.recapitulatifMedical != null) {
         this.inpNomTiersPayeurs = this.recapitulatifMedical.getFacrecNomTiers();
         this.afficheBoutonFacture = false;
         this.var_action = 2;
      }

   }

   public void consultRecap() {
      if (this.recapitulatifMedical != null) {
         this.inpNomTiersPayeurs = this.recapitulatifMedical.getFacrecNomTiers();
         this.afficheBoutonFacture = false;
         this.var_action = 3;
      }

   }

   public void ajouterFacture() throws HibernateException, NamingException {
      if (this.recapitulatifMedical != null) {
         this.lesNouvellesFactures.clear();
         String var1 = "";
         String var2 = this.utilDate.dateToStringSQLLight(this.recapitulatifMedical.getFacrecDateDebut()) + " 00:00:00";
         String var3 = this.utilDate.dateToStringSQLLight(this.recapitulatifMedical.getFacrecDateFin()) + " 23:59:59";
         var1 = "facDate>='" + var2 + "' and facDate<='" + var3 + "' and (facNumRecap is null or facNumRecap = '') ";
         if (this.recapitulatifMedical.getFacrecFondCnamgs() != 0) {
            var1 = var1 + " and facFondCnamgs=" + this.recapitulatifMedical.getFacrecFondCnamgs();
         } else {
            var1 = var1 + "and tiers.tieid=" + this.recapitulatifMedical.getTiers().getTieid();
         }

         this.lesNouvellesFactures = this.factureEnteteMedicalDao.rechercheFactureRequete(var1, (Session)null);
         this.dataModelNouvelleFactures.setWrappedData(this.lesNouvellesFactures);
         this.factureEnteteMedical = null;
         if (this.lesNouvellesFactures.size() != 0) {
            this.showModalPanelAjoutFacture = true;
         }
      }

   }

   public void annulerAjoutFacture() {
      this.showModalPanelAjoutFacture = false;
   }

   public void validerAjoutFacture() throws HibernateException, NamingException {
      if (this.factureEnteteMedical != null) {
         this.factureEnteteMedical.setFacDateRecap(this.recapitulatifMedical.getFacrecDate());
         this.factureEnteteMedical.setFacNumRecap(this.recapitulatifMedical.getFacrecNum());
         this.factureEnteteMedical = this.factureEnteteMedicalDao.modif(this.factureEnteteMedical);
         this.listFactureSelectionne.add(this.factureEnteteMedical);
         this.dataModelEntetesCtrl.setWrappedData(this.listFactureSelectionne);
         this.calculeTotalRecap();
         this.recapitulatifMedical.setFacrecTotHt(this.montantTtc);
         this.recapitulatifMedical.setFacrecTotTva(this.montantReglement);
         this.recapitulatifMedical.setFacrecTotTtc(this.montantSolde);
         this.recapitulatifMedical = this.recapitulatifMedicalDao.modif(this.recapitulatifMedical);
      }

      this.showModalPanelAjoutFacture = false;
   }

   public void supprimerFacture() throws HibernateException, NamingException {
      if (this.factureEnteteMedical != null) {
         this.factureEnteteMedical.setFacDateRecap((Date)null);
         this.factureEnteteMedical.setFacNumRecap((String)null);
         this.factureEnteteMedical = this.factureEnteteMedicalDao.modif(this.factureEnteteMedical);
         this.listFactureSelectionne.remove(this.factureEnteteMedical);
         this.dataModelEntetesCtrl.setWrappedData(this.listFactureSelectionne);
         this.calculeTotalRecap();
         this.recapitulatifMedical.setFacrecTotHt(this.montantTtc);
         this.recapitulatifMedical.setFacrecTotTva(this.montantReglement);
         this.recapitulatifMedical.setFacrecTotTtc(this.montantSolde);
         this.recapitulatifMedical = this.recapitulatifMedicalDao.modif(this.recapitulatifMedical);
         this.afficheBoutonFacture = false;
      }

   }

   public void selectionNouvelleFacture() {
      if (this.dataModelNouvelleFactures.isRowAvailable()) {
         this.factureEnteteMedical = (FactureEnteteMedical)this.dataModelNouvelleFactures.getRowData();
      }

   }

   public List chargerLesModelesImpresion() {
      String var1 = this.calculeCheminRapport(this.baseLog, this.nature, this.factureEnteteMedical.getFacOrigine());
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.lesModelsimpression = new ArrayList();
      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            String var5 = var3[var4];
            if (var5.endsWith("jasper")) {
               int var6 = var5.indexOf(".");
               var5 = var5.substring(0, var6);
               this.lesModelsimpression.add(new SelectItem(var5));
            }
         }
      }

      return this.lesModelsimpression;
   }

   public boolean verificationAutorisation(String var1) {
      boolean var2 = false;
      if (this.lesModelesAutorises != null && this.lesModelesAutorises.size() != 0) {
         for(int var3 = 0; var3 < this.lesModelesAutorises.size(); ++var3) {
            if (((String)this.lesModelesAutorises.get(var3)).toString().toLowerCase().contains(var1.toLowerCase())) {
               var2 = true;
               break;
            }
         }
      } else {
         var2 = true;
      }

      return var2;
   }

   public String calculeCheminRapport(String var1, int var2, String var3) {
      String var4 = "";
      if (var3 != null && !var3.isEmpty() && var3.equalsIgnoreCase("hospit")) {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "refacturation" + File.separator + "hospit" + File.separator;
      } else {
         var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "refacturation" + File.separator + "externe" + File.separator;
      }

      return var4;
   }

   public String calculeCheminRapportRecap(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "recapitulatif" + File.separator;
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatFacture.jpg");
            if (var4.exists()) {
               var3 = "formatFacture.jpg";
            }
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
      this.montant_lettre = this.utilNombre.begin(this.factureEnteteMedical.getFacTotTtc() + this.factureEnteteMedical.getFacTotTc(), this.factureEnteteMedical.getFacDevise());
      JRBeanCollectionDataSource var1 = new JRBeanCollectionDataSource(this.calculeImpressionListe());
      return var1;
   }

   public List calculeImpressionListe() throws IOException, HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      if (this.lesLignesList.size() != 0) {
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "RefacturationMed");

         for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
            this.factureLigneMedical = (FactureLigneMedical)this.lesLignesList.get(var3);
            this.factureLigneMedical.setNumCnamgs("");
            if (this.factureLigneMedical.getFacligDossier() != null && !this.factureLigneMedical.getFacligDossier().isEmpty()) {
               this.patients = this.patientsDao.selectPatientsM(this.factureLigneMedical.getFacligDossier(), var2);
               if (this.patients != null) {
                  this.factureLigneMedical.setNumCnamgs(this.patients.getPatCnamgs());
                  if (this.patients.getPatTelDom() != null && !this.patients.getPatTelDom().isEmpty()) {
                     this.factureLigneMedical.setPatientTel(this.patients.getPatTelDom());
                  } else if (this.patients.getPatCel1() != null && !this.patients.getPatCel1().isEmpty()) {
                     this.factureLigneMedical.setPatientTel(this.patients.getPatCel1());
                  } else if (this.patients.getPatCel2() != null && !this.patients.getPatCel2().isEmpty()) {
                     this.factureLigneMedical.setPatientTel(this.patients.getPatCel2());
                  } else if (this.patients.getPatCel3() != null && !this.patients.getPatCel3().isEmpty()) {
                     this.factureLigneMedical.setPatientTel(this.patients.getPatCel3());
                  }

                  this.factureLigneMedical.setPatientAdresse(this.patients.getPatAdresse());
               }
            }

            this.factureLigneMedical.setEmployeur((String)null);
            if (this.factureLigneMedical.getFacligIdConsultation() != 0L) {
               new ConsultationEnteteGene();
               ConsultationEnteteGene var4 = this.consultationEnteteGeneDao.selectById(this.factureLigneMedical.getFacligIdConsultation(), var2);
               if (var4 != null) {
                  this.factureLigneMedical.setEmployeur(var4.getCsgNomEmployeur());
               }
            } else if (this.factureLigneMedical.getFacligIdLaboratoire() != 0L) {
               new LaboratoireEntete();
               LaboratoireEntete var5 = this.laboratoireEnteteDao.selectById(this.factureLigneMedical.getFacligIdLaboratoire(), var2);
               if (var5 != null) {
                  this.factureLigneMedical.setEmployeur(var5.getLabNomEmployeur());
               }
            } else if (this.factureLigneMedical.getFacligIdPharmacie() != 0L) {
               new PharmacieEntete();
               PharmacieEntete var6 = this.pharmacieEnteteDao.selectById(this.factureLigneMedical.getFacligIdPharmacie(), var2);
               if (var6 != null) {
                  this.factureLigneMedical.setEmployeur(var6.getPhaNomEmployeur());
               }
            }

            var1.add(this.factureLigneMedical);
         }

         this.utilInitHibernate.closeSession();
      }

      return var1;
   }

   public JRBeanCollectionDataSource calculeImpressionCommunRecap() throws IOException, HibernateException, NamingException {
      this.montant_lettre = this.utilNombre.begin(this.recapitulatifMedical.getFacrecTotTtc() + this.recapitulatifMedical.getFacrecTotTc(), this.recapitulatifMedical.getFacrecDevise());
      JRBeanCollectionDataSource var1 = new JRBeanCollectionDataSource(this.calculeImpressionListeRecap());
      return var1;
   }

   public List calculeImpressionListeRecap() throws IOException, HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      if (this.listFactureSelectionne.size() != 0) {
         for(int var2 = 0; var2 < this.listFactureSelectionne.size(); ++var2) {
            this.factureEnteteMedical = (FactureEnteteMedical)this.listFactureSelectionne.get(var2);
            var1.add(this.factureEnteteMedical);
         }
      }

      return var1;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      return "";
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      boolean var3 = false;
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "Refacturation");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         if (this.factureEnteteMedical.getFacDateImp() != null && this.factureEnteteMedical.getFacEtat() != 0) {
            var3 = true;
         }

         this.factureEnteteMedical.setFacDateImp(new Date());
         if (this.factureEnteteMedical.getFacEtat() == 0 && this.factureEnteteMedical.getFacEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.factureEnteteMedical.setFacEtat(1);
            if (this.tiers.getTieDteDocument5() == null || this.factureEnteteMedical.getFacDate().after(this.tiers.getTieDteDocument5())) {
               this.tiers.setTieDteDocument5(this.factureEnteteMedical.getFacDate());
               this.tiers = this.tiersDao.modif(this.tiers, var4);
            }
         }

         this.factureEnteteMedical.setFacModeleImp(var1);
         this.factureEnteteMedical = this.factureEnteteMedicalDao.modif(this.factureEnteteMedical, var4);
         var5.commit();
      } catch (HibernateException var10) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      if (var2) {
         this.chargerDocumentLigne((Session)null);
      }

      return var3;
   }

   public boolean majDateImpressionRecap(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Refacturation");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.recapitulatifMedical.getFacrecDateImp() != null && this.recapitulatifMedical.getFacrecEtat() != 0) {
            var2 = true;
         }

         this.recapitulatifMedical.setFacrecDateImp(new Date());
         if (this.recapitulatifMedical.getFacrecEtat() == 0 && this.recapitulatifMedical.getFacrecEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 1) {
            this.factureEnteteMedical.setFacEtat(1);
         }

         this.recapitulatifMedical.setFacrecModeleImp(var1);
         this.recapitulatifMedical = this.recapitulatifMedicalDao.modif(this.recapitulatifMedical, var3);
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

   public void calculeDateImpressionRecap() {
      if (this.factureEnteteMedical != null) {
         this.dateRecapitulatif = this.factureEnteteMedical.getFacDateRecap();
      }

      if (this.dateRecapitulatif == null) {
         this.dateRecapitulatif = new Date();
      }

   }

   public void impression(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var2 == 0) {
         if (var3 != null && !var3.isEmpty()) {
            boolean var11;
            double var12;
            if (this.nature == 182) {
               var11 = this.majDateImpressionRecap(var3);
               var1.setjRBeanCollectionDataSource(this.calculeImpressionCommunRecap());
               var1.setRapport(var3);
               var1.setEntete("Impression récapitulatif");
               var1.setCheminRapport(this.calculeCheminRapportRecap("structure" + this.structureLog.getStrid()));
               var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.recapitulatifMedical.getFacrecEtat()));
               var1.setDuplicata("" + var11);
               var1.setInfoOrigineDoc(this.infoOrigineDoc);
               var1.setNbDecQte(this.optionMedical.getNbDecQte());
               var1.setNbDecPu(this.optionMedical.getNbDecPu());
               this.recapitulatifMedical.setFacrecDevise(this.devisePrint);
               if (this.recapitulatifMedical.getFacrecDevise() == null || this.recapitulatifMedical.getFacrecDevise().isEmpty()) {
                  this.recapitulatifMedical.setFacrecDevise(this.structureLog.getStrdevise());
               }

               if (!this.recapitulatifMedical.getFacrecDevise().equals("XOF") && !this.recapitulatifMedical.getFacrecDevise().equals("XAF")) {
                  if (this.recapitulatifMedical.getFacrecDevise().equals("EUR")) {
                     var1.setNbCar(1);
                  } else {
                     var1.setNbCar(0);
                  }
               } else {
                  var1.setNbCar(2);
               }

               this.devisePrint = this.structureLog.getStrdevise();
               if (this.devisePrint.equals(this.structureLog.getStrdevise())) {
                  var1.setTaux(1.0F);
               } else {
                  var1.setTaux(this.tauxPrint);
                  var12 = this.utilNombre.myRound((this.recapitulatifMedical.getFacrecTotTtc() + this.recapitulatifMedical.getFacrecTotTc()) / (double)this.tauxPrint, 2);
                  this.montant_lettre = this.utilNombre.begin(var12, this.devisePrint);
               }

               var1.setRequete("");
               var1.setMontant_lettre(this.montant_lettre);
               var1.setFormat(var5);
               var1.setEmetteur(var6);
               var1.setDestinataire(var7);
               var1.setDestinataireCC(var8);
               var1.setDestinataireCCI(var9);
               var1.setCorpsMail(var10);
               var1.setIdCommercial(this.recapitulatifMedical.getFacrecIdCreateur());
               var1.setTiersSelectionne(this.recapitulatifMedical.getTiers());
               var1.setContact((Contacts)null);
               var1.setNumDoc(this.recapitulatifMedical.getFacrecNum());
               var1.setNature(this.nature);
               var1.setId_doc(this.recapitulatifMedical.getFacrecId());
               var1.setParc((Parc)null);
               var1.setDateFin(this.recapitulatifMedical.getFacrecDate());
               var1.setAnnexe2(this.recapitulatifMedical.getFacrecNum());
               var1.setAnnexe1(this.recapitulatifMedical.getFacrecPeriode());
               if (this.recapitulatifMedical.getFacrecFondCnamgs() != 0) {
                  if (this.recapitulatifMedical.getFacrecFondCnamgs() == 1) {
                     var1.setAdresseFacturation("Fonds 1 Consultation SP");
                  } else if (this.recapitulatifMedical.getFacrecFondCnamgs() == 2) {
                     var1.setAdresseFacturation("Fonds 2 Consultation AP");
                  } else if (this.recapitulatifMedical.getFacrecFondCnamgs() == 3) {
                     var1.setAdresseFacturation("Fonds 3 Consultation GEF");
                  } else if (this.recapitulatifMedical.getFacrecFondCnamgs() == 11) {
                     var1.setAdresseFacturation("Fonds 1 Examen SP");
                  } else if (this.recapitulatifMedical.getFacrecFondCnamgs() == 12) {
                     var1.setAdresseFacturation("Fonds 2 Examen AP");
                  } else if (this.recapitulatifMedical.getFacrecFondCnamgs() == 13) {
                     var1.setAdresseFacturation("Fonds 3 Examen GEF");
                  } else if (this.recapitulatifMedical.getFacrecFondCnamgs() == 21) {
                     var1.setAdresseFacturation("Fonds 1 Pharmacie SP");
                  } else if (this.recapitulatifMedical.getFacrecFondCnamgs() == 22) {
                     var1.setAdresseFacturation("Fonds 2 Pharmacie AP");
                  } else if (this.recapitulatifMedical.getFacrecFondCnamgs() == 23) {
                     var1.setAdresseFacturation("Fonds 3 Pharmacie GEF");
                  } else if (this.recapitulatifMedical.getFacrecFondCnamgs() == 31) {
                     var1.setAdresseFacturation("Fonds 1 Hospitalisation SP");
                  } else if (this.recapitulatifMedical.getFacrecFondCnamgs() == 32) {
                     var1.setAdresseFacturation("Fonds 2 Hospitalisation AP");
                  } else if (this.recapitulatifMedical.getFacrecFondCnamgs() == 33) {
                     var1.setAdresseFacturation("Fonds 3 Hospitalisation GEF");
                  }
               } else {
                  var1.setAdresseFacturation("");
               }

               var1.setBaseLog(this.baseLog);
               var1.setStructureLog(this.structureLog);
               var1.setUsersLog(this.usersLog);
               var1.imprimeRapport();
               this.chargerDocumentLigne((Session)null);
            } else {
               var11 = this.majDateImpression(var3);
               var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
               var1.setRapport(var3);
               var1.setEntete("Impression facture");
               var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nature, this.factureEnteteMedical.getFacOrigine()));
               var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
               var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.factureEnteteMedical.getFacEtat()));
               var1.setDuplicata("" + var11);
               var1.setInfoOrigineDoc(this.infoOrigineDoc);
               var1.setNbDecQte(this.optionMedical.getNbDecQte());
               var1.setNbDecPu(this.optionMedical.getNbDecPu());
               this.factureEnteteMedical.setFacDevise(this.devisePrint);
               if (this.factureEnteteMedical.getFacDevise() == null || this.factureEnteteMedical.getFacDevise().isEmpty()) {
                  this.factureEnteteMedical.setFacDevise(this.structureLog.getStrdevise());
               }

               if (!this.factureEnteteMedical.getFacDevise().equals("XOF") && !this.factureEnteteMedical.getFacDevise().equals("XAF")) {
                  if (this.factureEnteteMedical.getFacDevise().equals("EUR")) {
                     var1.setNbCar(1);
                  } else {
                     var1.setNbCar(0);
                  }
               } else {
                  var1.setNbCar(2);
               }

               this.devisePrint = this.structureLog.getStrdevise();
               if (this.devisePrint.equals(this.structureLog.getStrdevise())) {
                  var1.setTaux(1.0F);
               } else {
                  var1.setTaux(this.tauxPrint);
                  var12 = this.utilNombre.myRound((this.factureEnteteMedical.getFacTotTtc() + this.factureEnteteMedical.getFacTotTc()) / (double)this.tauxPrint, 2);
                  this.montant_lettre = this.utilNombre.begin(var12, this.devisePrint);
               }

               var1.setRequete("");
               var1.setMontant_lettre(this.montant_lettre);
               var1.setFormat(var5);
               var1.setEmetteur(var6);
               var1.setDestinataire(var7);
               var1.setDestinataireCC(var8);
               var1.setDestinataireCCI(var9);
               var1.setCorpsMail(var10);
               var1.setIdCommercial(this.factureEnteteMedical.getFacIdCommercial());
               var1.setTiersSelectionne(this.factureEnteteMedical.getTiers());
               var1.setContact((Contacts)null);
               var1.setNumDoc(this.factureEnteteMedical.getFacNum());
               var1.setNature(this.nature);
               var1.setId_doc(this.factureEnteteMedical.getFacId());
               if (this.factureEnteteMedical.getFacAnal2() != null && !this.factureEnteteMedical.getFacAnal2().isEmpty()) {
                  String var15 = "";
                  if (this.factureEnteteMedical.getFacAnal2().contains(":")) {
                     String[] var13 = this.factureEnteteMedical.getFacAnal2().split(":");
                     var15 = var13[0];
                  } else {
                     var15 = this.factureEnteteMedical.getFacAnal2();
                  }

                  new Parc();
                  ParcDao var14 = new ParcDao(this.baseLog, this.utilInitHibernate);
                  Parc var16 = var14.rechercheParc(var15, (Session)null);
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
               this.chargerDocumentLigne((Session)null);
            }
         }
      } else if (var2 == 1) {
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
            this.uniteGraph = "FACTURES : Chiffre d'Affaire en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else if (this.valQteGraph == 1) {
            this.uniteGraph = "FACTURES : Nombre de documents";
            this.deviseGraph = "";
            this.nbDecGraph = 0;
         } else if (this.valQteGraph == 2) {
            this.uniteGraph = "FACTURES : Quantites";
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
         if (this.inpCat == 0) {
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
         }

         new FactureEnteteMedical();
         new FactureLigneMedical();
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Refacturation");
         String var6 = "";

         FactureEnteteMedical var14;
         for(int var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
            var14 = (FactureEnteteMedical)this.lesEntetesList.get(var7);
            if (var6.isEmpty()) {
               var6 = "'" + var14.getFacNum() + "'";
            } else {
               var6 = var6 + ",'" + var14.getFacNum() + "'";
            }
         }

         int var12;
         int var19;
         if (this.valQteGraph != 2 && this.modeGraph != 5 && this.modeGraph != 6) {
            if (this.lesEntetesList.size() != 0) {
               String var17 = "";
               long var20 = 0L;
               boolean var10 = false;

               for(var19 = 0; var19 < this.lesEntetesList.size(); ++var19) {
                  var14 = (FactureEnteteMedical)this.lesEntetesList.get(var19);
                  var17 = "";
                  var20 = 0L;
                  int var18 = 0;
                  if (this.modeGraph == 0) {
                     var12 = var14.getFacDate().getYear() + 1900;
                     var17 = "" + var12;
                  } else if (this.modeGraph == 2) {
                     if (var14.getFacNomCommercial() != null && !var14.getFacNomCommercial().isEmpty()) {
                        var17 = var14.getFacNomCommercial();
                     } else {
                        var17 = "Sans Commercial";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var14.getFacNomTiers() != null && !var14.getFacNomTiers().isEmpty()) {
                        var17 = var14.getFacNomTiers();
                     } else {
                        var17 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 8) {
                     if (var14.getFacAnal4() != null && !var14.getFacAnal4().isEmpty()) {
                        var17 = var14.getFacAnal4();
                     } else {
                        var17 = "Sans Affaire";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var20 = (long)var14.getFacTotHt();
                  } else if (this.valQteGraph == 1) {
                     ++var20;
                  }

                  if (this.timeDecoupage == 0) {
                     var18 = var14.getFacDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var18 = var14.getFacDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var14.getFacDate().getMonth() + 1 >= 1 && var14.getFacDate().getMonth() + 1 <= 3) {
                        var18 = 1;
                     } else if (var14.getFacDate().getMonth() + 1 >= 4 && var14.getFacDate().getMonth() + 1 <= 6) {
                        var18 = 2;
                     } else if (var14.getFacDate().getMonth() + 1 >= 7 && var14.getFacDate().getMonth() + 1 <= 9) {
                        var18 = 3;
                     } else if (var14.getFacDate().getMonth() + 1 >= 10 && var14.getFacDate().getMonth() + 1 <= 12) {
                        var18 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var14.getFacDate().getMonth() + 1 >= 1 && var14.getFacDate().getMonth() + 1 <= 6) {
                        var18 = 1;
                     } else if (var14.getFacDate().getMonth() + 1 >= 7 && var14.getFacDate().getMonth() + 1 <= 12) {
                        var18 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var18 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var18 = var14.getFacDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var17, var18, var20);
               }
            }
         } else {
            new ArrayList();
            List var16 = this.factureLigneMedicalDao.chargerLesLignesFactures(var6, var5);
            if (var16.size() != 0) {
               String var8 = "";
               long var9 = 0L;
               boolean var11 = false;

               for(var12 = 0; var12 < var16.size(); ++var12) {
                  FactureLigneMedical var15 = (FactureLigneMedical)var16.get(var12);
                  var8 = "";
                  var9 = 0L;
                  var19 = 0;
                  if (this.modeGraph == 0) {
                     int var13 = var15.getFactureEnteteMedical().getFacDate().getYear() + 1900;
                     var8 = "" + var13;
                  } else if (this.modeGraph == 2) {
                     if (var15.getFactureEnteteMedical().getFacNomCommercial() != null && !var15.getFactureEnteteMedical().getFacNomCommercial().isEmpty()) {
                        var8 = var15.getFactureEnteteMedical().getFacNomCommercial();
                     } else {
                        var8 = "Sans Commercial";
                     }
                  } else if (this.modeGraph == 4) {
                     if (var15.getFactureEnteteMedical().getFacNomTiers() != null && !var15.getFactureEnteteMedical().getFacNomTiers().isEmpty()) {
                        var8 = var15.getFactureEnteteMedical().getFacNomTiers();
                     } else {
                        var8 = "Sans Tiers";
                     }
                  } else if (this.modeGraph == 5) {
                     if (var15.getFacligFamille() != null && !var15.getFacligFamille().isEmpty()) {
                        var8 = var15.getFacligFamille();
                     } else {
                        var8 = "Sans Famille Produit";
                     }
                  } else if (this.modeGraph == 6) {
                     if (var15.getFacligLibelle() != null && !var15.getFacligLibelle().isEmpty()) {
                        var8 = var15.getFacligLibelle();
                     } else {
                        var8 = "Sans Libelle Produit";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var9 = (long)var15.getFacligPt();
                  } else if (this.valQteGraph == 1) {
                     ++var9;
                  } else if (this.valQteGraph == 2) {
                     var9 = (long)this.utilNombre.myRound(var15.getFacligQte(), 1);
                  }

                  if (this.timeDecoupage == 0) {
                     var19 = var15.getFactureEnteteMedical().getFacDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var19 = var15.getFactureEnteteMedical().getFacDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var15.getFactureEnteteMedical().getFacDate().getMonth() + 1 >= 1 && var15.getFactureEnteteMedical().getFacDate().getMonth() + 1 <= 3) {
                        var19 = 1;
                     } else if (var15.getFactureEnteteMedical().getFacDate().getMonth() + 1 >= 4 && var15.getFactureEnteteMedical().getFacDate().getMonth() + 1 <= 6) {
                        var19 = 2;
                     } else if (var15.getFactureEnteteMedical().getFacDate().getMonth() + 1 >= 7 && var15.getFactureEnteteMedical().getFacDate().getMonth() + 1 <= 9) {
                        var19 = 3;
                     } else if (var15.getFactureEnteteMedical().getFacDate().getMonth() + 1 >= 10 && var15.getFactureEnteteMedical().getFacDate().getMonth() + 1 <= 12) {
                        var19 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var15.getFactureEnteteMedical().getFacDate().getMonth() + 1 >= 1 && var15.getFactureEnteteMedical().getFacDate().getMonth() + 1 <= 6) {
                        var19 = 1;
                     } else if (var15.getFactureEnteteMedical().getFacDate().getMonth() + 1 >= 7 && var15.getFactureEnteteMedical().getFacDate().getMonth() + 1 <= 12) {
                        var19 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var19 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var19 = var15.getFactureEnteteMedical().getFacDate().getHours();
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

   public FactureEnteteMedical getFactureEnteteMedical() {
      return this.factureEnteteMedical;
   }

   public void setFactureEnteteMedical(FactureEnteteMedical var1) {
      this.factureEnteteMedical = var1;
   }

   public FactureLigneMedical getFactureLigneMedical() {
      return this.factureLigneMedical;
   }

   public void setFactureLigneMedical(FactureLigneMedical var1) {
      this.factureLigneMedical = var1;
   }

   public boolean isGriserchamps() {
      return this.griserchamps;
   }

   public void setGriserchamps(boolean var1) {
      this.griserchamps = var1;
   }

   public Date getInpAu() {
      return this.inpAu;
   }

   public void setInpAu(Date var1) {
      this.inpAu = var1;
   }

   public int getInpCat() {
      return this.inpCat;
   }

   public void setInpCat(int var1) {
      this.inpCat = var1;
   }

   public String getInpClient() {
      return this.inpClient;
   }

   public void setInpClient(String var1) {
      this.inpClient = var1;
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

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
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

   public Date getVar_date_trf() {
      return this.var_date_trf;
   }

   public void setVar_date_trf(Date var1) {
      this.var_date_trf = var1;
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

   public int getVar_timbre() {
      return this.var_timbre;
   }

   public void setVar_timbre(int var1) {
      this.var_timbre = var1;
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

   public Reglements getReglements() {
      return this.reglements;
   }

   public void setReglements(Reglements var1) {
      this.reglements = var1;
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

   public String getVar_type_reg() {
      return this.var_type_reg;
   }

   public void setVar_type_reg(String var1) {
      this.var_type_reg = var1;
   }

   public String getVar_objet() {
      return this.var_objet;
   }

   public void setVar_objet(String var1) {
      this.var_objet = var1;
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

   public List getMesModesleRecus() {
      return this.mesModesleRecus;
   }

   public void setMesModesleRecus(List var1) {
      this.mesModesleRecus = var1;
   }

   public String getNomRepMod() {
      return this.nomRepMod;
   }

   public void setNomRepMod(String var1) {
      this.nomRepMod = var1;
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

   public double getVar_ecart_reglement() {
      return this.var_ecart_reglement;
   }

   public void setVar_ecart_reglement(double var1) {
      this.var_ecart_reglement = var1;
   }

   public boolean isShowModalPanelPayeMultiple() {
      return this.showModalPanelPayeMultiple;
   }

   public void setShowModalPanelPayeMultiple(boolean var1) {
      this.showModalPanelPayeMultiple = var1;
   }

   public String getVar_banque_destination() {
      return this.var_banque_destination;
   }

   public void setVar_banque_destination(String var1) {
      this.var_banque_destination = var1;
   }

   public boolean isVar_affiche_banque_destination() {
      return this.var_affiche_banque_destination;
   }

   public void setVar_affiche_banque_destination(boolean var1) {
      this.var_affiche_banque_destination = var1;
   }

   public List getMesBanquesItems() {
      return this.mesBanquesItems;
   }

   public void setMesBanquesItems(List var1) {
      this.mesBanquesItems = var1;
   }

   public boolean isValideLissage() {
      return this.valideLissage;
   }

   public void setValideLissage(boolean var1) {
      this.valideLissage = var1;
   }

   public boolean isShowModalPanelGraph() {
      return this.showModalPanelGraph;
   }

   public void setShowModalPanelGraph(boolean var1) {
      this.showModalPanelGraph = var1;
   }

   public int getModeGraph() {
      return this.modeGraph;
   }

   public void setModeGraph(int var1) {
      this.modeGraph = var1;
   }

   public int getValQteGraph() {
      return this.valQteGraph;
   }

   public void setValQteGraph(int var1) {
      this.valQteGraph = var1;
   }

   public String getSousTitreGraph() {
      return this.sousTitreGraph;
   }

   public void setSousTitreGraph(String var1) {
      this.sousTitreGraph = var1;
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

   public String getDeviseGraph() {
      return this.deviseGraph;
   }

   public void setDeviseGraph(String var1) {
      this.deviseGraph = var1;
   }

   public int getNbDecGraph() {
      return this.nbDecGraph;
   }

   public void setNbDecGraph(int var1) {
      this.nbDecGraph = var1;
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

   public boolean isShowModele() {
      return this.showModele;
   }

   public void setShowModele(boolean var1) {
      this.showModele = var1;
   }

   public int getTimeDecoupage() {
      return this.timeDecoupage;
   }

   public void setTimeDecoupage(int var1) {
      this.timeDecoupage = var1;
   }

   public List getMesSerieUserItem() {
      return this.mesSerieUserItem;
   }

   public void setMesSerieUserItem(List var1) {
      this.mesSerieUserItem = var1;
   }

   public boolean isRepartitionManuelle() {
      return this.repartitionManuelle;
   }

   public void setRepartitionManuelle(boolean var1) {
      this.repartitionManuelle = var1;
   }

   public double getTotManuel() {
      return this.totManuel;
   }

   public void setTotManuel(double var1) {
      this.totManuel = var1;
   }

   public double getEcartManuel() {
      return this.ecartManuel;
   }

   public void setEcartManuel(double var1) {
      this.ecartManuel = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public boolean isShowModalPanelAnnuler() {
      return this.showModalPanelAnnuler;
   }

   public void setShowModalPanelAnnuler(boolean var1) {
      this.showModalPanelAnnuler = var1;
   }

   public double getVar_montant_trf() {
      return this.var_montant_trf;
   }

   public void setVar_montant_trf(double var1) {
      this.var_montant_trf = var1;
   }

   public String getInformationsTiers() {
      return this.informationsTiers;
   }

   public void setInformationsTiers(String var1) {
      this.informationsTiers = var1;
   }

   public OptionMedical getOptionMedical() {
      return this.optionMedical;
   }

   public void setOptionMedical(OptionMedical var1) {
      this.optionMedical = var1;
   }

   public boolean isShowModalPanelAjouter() {
      return this.showModalPanelAjouter;
   }

   public void setShowModalPanelAjouter(boolean var1) {
      this.showModalPanelAjouter = var1;
   }

   public DataModel getDataModelTiersConcernes() {
      return this.dataModelTiersConcernes;
   }

   public void setDataModelTiersConcernes(DataModel var1) {
      this.dataModelTiersConcernes = var1;
   }

   public Date getDateDebut() {
      return this.dateDebut;
   }

   public void setDateDebut(Date var1) {
      this.dateDebut = var1;
   }

   public Date getDateFin() {
      return this.dateFin;
   }

   public void setDateFin(Date var1) {
      this.dateFin = var1;
   }

   public boolean isVar_affiche_be() {
      return this.var_affiche_be;
   }

   public void setVar_affiche_be(boolean var1) {
      this.var_affiche_be = var1;
   }

   public double getTotalPayerTimbre() {
      return this.totalPayerTimbre;
   }

   public void setTotalPayerTimbre(double var1) {
      this.totalPayerTimbre = var1;
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

   public boolean isShowModalPanelConsultation() {
      return this.showModalPanelConsultation;
   }

   public void setShowModalPanelConsultation(boolean var1) {
      this.showModalPanelConsultation = var1;
   }

   public boolean isShowModalPanelHospitalisation() {
      return this.showModalPanelHospitalisation;
   }

   public void setShowModalPanelHospitalisation(boolean var1) {
      this.showModalPanelHospitalisation = var1;
   }

   public boolean isShowModalPanelLaboratoire() {
      return this.showModalPanelLaboratoire;
   }

   public void setShowModalPanelLaboratoire(boolean var1) {
      this.showModalPanelLaboratoire = var1;
   }

   public boolean isShowModalPanelPharmacie() {
      return this.showModalPanelPharmacie;
   }

   public void setShowModalPanelPharmacie(boolean var1) {
      this.showModalPanelPharmacie = var1;
   }

   public boolean isShowModalPanelListeTiers() {
      return this.showModalPanelListeTiers;
   }

   public void setShowModalPanelListeTiers(boolean var1) {
      this.showModalPanelListeTiers = var1;
   }

   public String getInpNomTiers() {
      return this.inpNomTiers;
   }

   public void setInpNomTiers(String var1) {
      this.inpNomTiers = var1;
   }

   public DataModel getDatamodelListeTiers() {
      return this.datamodelListeTiers;
   }

   public void setDatamodelListeTiers(DataModel var1) {
      this.datamodelListeTiers = var1;
   }

   public List getLesModelsimpression() {
      return this.lesModelsimpression;
   }

   public void setLesModelsimpression(List var1) {
      this.lesModelsimpression = var1;
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

   public DataModel getDataModelTiersRejetes() {
      return this.dataModelTiersRejetes;
   }

   public void setDataModelTiersRejetes(DataModel var1) {
      this.dataModelTiersRejetes = var1;
   }

   public boolean isShowModalPanelPatientRejetes() {
      return this.showModalPanelPatientRejetes;
   }

   public void setShowModalPanelPatientRejetes(boolean var1) {
      this.showModalPanelPatientRejetes = var1;
   }

   public DataModel getDataModelEntetesCtrl() {
      return this.dataModelEntetesCtrl;
   }

   public void setDataModelEntetesCtrl(DataModel var1) {
      this.dataModelEntetesCtrl = var1;
   }

   public UIDataTable getExtDTableCtrl() {
      return this.extDTableCtrl;
   }

   public void setExtDTableCtrl(UIDataTable var1) {
      this.extDTableCtrl = var1;
   }

   public SimpleSelection getSimpleSelectionEnteteCtrl() {
      return this.simpleSelectionEnteteCtrl;
   }

   public void setSimpleSelectionEnteteCtrl(SimpleSelection var1) {
      this.simpleSelectionEnteteCtrl = var1;
   }

   public boolean isVisibiliteBtonCtrl() {
      return this.visibiliteBtonCtrl;
   }

   public void setVisibiliteBtonCtrl(boolean var1) {
      this.visibiliteBtonCtrl = var1;
   }

   public boolean isShowModalPanelChangerService() {
      return this.showModalPanelChangerService;
   }

   public void setShowModalPanelChangerService(boolean var1) {
      this.showModalPanelChangerService = var1;
   }

   public String getActuelMedecin() {
      return this.actuelMedecin;
   }

   public void setActuelMedecin(String var1) {
      this.actuelMedecin = var1;
   }

   public String getActuelMotif() {
      return this.actuelMotif;
   }

   public void setActuelMotif(String var1) {
      this.actuelMotif = var1;
   }

   public String getActuelService() {
      return this.actuelService;
   }

   public void setActuelService(String var1) {
      this.actuelService = var1;
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

   public String getNouveauService() {
      return this.nouveauService;
   }

   public void setNouveauService(String var1) {
      this.nouveauService = var1;
   }

   public DocumentMedical getDocumentMedical() {
      return this.documentMedical;
   }

   public void setDocumentMedical(DocumentMedical var1) {
      this.documentMedical = var1;
   }

   public long getInpFacturier() {
      return this.inpFacturier;
   }

   public void setInpFacturier(long var1) {
      this.inpFacturier = var1;
   }

   public List getMesMedecinsItem() {
      return this.mesMedecinsItem;
   }

   public void setMesMedecinsItem(List var1) {
      this.mesMedecinsItem = var1;
   }

   public boolean isShowModalPanelChangerNomPatient() {
      return this.showModalPanelChangerNomPatient;
   }

   public void setShowModalPanelChangerNomPatient(boolean var1) {
      this.showModalPanelChangerNomPatient = var1;
   }

   public Patients getPatients() {
      return this.patients;
   }

   public void setPatients(Patients var1) {
      this.patients = var1;
   }

   public Date getDateAnnulation() {
      return this.dateAnnulation;
   }

   public void setDateAnnulation(Date var1) {
      this.dateAnnulation = var1;
   }

   public String getMotifAnnulation() {
      return this.motifAnnulation;
   }

   public void setMotifAnnulation(String var1) {
      this.motifAnnulation = var1;
   }

   public boolean isShowModalPanelDocument() {
      return this.showModalPanelDocument;
   }

   public void setShowModalPanelDocument(boolean var1) {
      this.showModalPanelDocument = var1;
   }

   public int getNbAnnee() {
      return this.nbAnnee;
   }

   public void setNbAnnee(int var1) {
      this.nbAnnee = var1;
   }

   public int getNbJours() {
      return this.nbJours;
   }

   public void setNbJours(int var1) {
      this.nbJours = var1;
   }

   public int getNbMois() {
      return this.nbMois;
   }

   public void setNbMois(int var1) {
      this.nbMois = var1;
   }

   public boolean isShowModalPanelCalculDateNaissance() {
      return this.showModalPanelCalculDateNaissance;
   }

   public void setShowModalPanelCalculDateNaissance(boolean var1) {
      this.showModalPanelCalculDateNaissance = var1;
   }

   public boolean isVerrouSexe() {
      return this.verrouSexe;
   }

   public void setVerrouSexe(boolean var1) {
      this.verrouSexe = var1;
   }

   public boolean isShowModalGoogleMap() {
      return this.showModalGoogleMap;
   }

   public void setShowModalGoogleMap(boolean var1) {
      this.showModalGoogleMap = var1;
   }

   public URI getUri() {
      return this.uri;
   }

   public void setUri(URI var1) {
      this.uri = var1;
   }

   public List getMesCivilitesItems() {
      return this.mesCivilitesItems;
   }

   public void setMesCivilitesItems(List var1) {
      this.mesCivilitesItems = var1;
   }

   public int getNevers() {
      return this.nevers;
   }

   public void setNevers(int var1) {
      this.nevers = var1;
   }

   public List getLesEmployeursItems() {
      return this.lesEmployeursItems;
   }

   public void setLesEmployeursItems(List var1) {
      this.lesEmployeursItems = var1;
   }

   public String getNomAgentFacturation() {
      return this.nomAgentFacturation;
   }

   public void setNomAgentFacturation(String var1) {
      this.nomAgentFacturation = var1;
   }

   public String getNumFeuille() {
      return this.numFeuille;
   }

   public void setNumFeuille(String var1) {
      this.numFeuille = var1;
   }

   public double getPartPatient() {
      return this.partPatient;
   }

   public void setPartPatient(double var1) {
      this.partPatient = var1;
   }

   public double getPartTiers() {
      return this.partTiers;
   }

   public void setPartTiers(double var1) {
      this.partTiers = var1;
   }

   public double getTotalFacture() {
      return this.totalFacture;
   }

   public void setTotalFacture(double var1) {
      this.totalFacture = var1;
   }

   public String getNumDocument() {
      return this.numDocument;
   }

   public void setNumDocument(String var1) {
      this.numDocument = var1;
   }

   public float getPecCnamgs() {
      return this.pecCnamgs;
   }

   public void setPecCnamgs(float var1) {
      this.pecCnamgs = var1;
   }

   public int getFondsCnamgs() {
      return this.fondsCnamgs;
   }

   public void setFondsCnamgs(int var1) {
      this.fondsCnamgs = var1;
   }

   public String getInpPatient() {
      return this.inpPatient;
   }

   public void setInpPatient(String var1) {
      this.inpPatient = var1;
   }

   public int getInpRegroupement() {
      return this.inpRegroupement;
   }

   public void setInpRegroupement(int var1) {
      this.inpRegroupement = var1;
   }

   public boolean isShowModalPanelPrintSimulation() {
      return this.showModalPanelPrintSimulation;
   }

   public void setShowModalPanelPrintSimulation(boolean var1) {
      this.showModalPanelPrintSimulation = var1;
   }

   public int getNumLigne() {
      return this.numLigne;
   }

   public void setNumLigne(int var1) {
      this.numLigne = var1;
   }

   public double getPrixCnamgs() {
      return this.prixCnamgs;
   }

   public void setPrixCnamgs(double var1) {
      this.prixCnamgs = var1;
   }

   public String getNumBc() {
      return this.numBc;
   }

   public void setNumBc(String var1) {
      this.numBc = var1;
   }

   public String getNumCnamgsAssure() {
      return this.numCnamgsAssure;
   }

   public void setNumCnamgsAssure(String var1) {
      this.numCnamgsAssure = var1;
   }

   public String getNomCnamgsAssure() {
      return this.nomCnamgsAssure;
   }

   public void setNomCnamgsAssure(String var1) {
      this.nomCnamgsAssure = var1;
   }

   public boolean isAssurePrincipal() {
      return this.assurePrincipal;
   }

   public void setAssurePrincipal(boolean var1) {
      this.assurePrincipal = var1;
   }

   public int getInpTiersPayeurs() {
      return this.inpTiersPayeurs;
   }

   public void setInpTiersPayeurs(int var1) {
      this.inpTiersPayeurs = var1;
   }

   public String getInpFeuille() {
      return this.inpFeuille;
   }

   public void setInpFeuille(String var1) {
      this.inpFeuille = var1;
   }

   public Date getDateDocument() {
      return this.dateDocument;
   }

   public void setDateDocument(Date var1) {
      this.dateDocument = var1;
   }

   public String getNomPatientDocument() {
      return this.nomPatientDocument;
   }

   public void setNomPatientDocument(String var1) {
      this.nomPatientDocument = var1;
   }

   public DataModel getDataModelPatients() {
      return this.dataModelPatients;
   }

   public void setDataModelPatients(DataModel var1) {
      this.dataModelPatients = var1;
   }

   public boolean isSelectPatient() {
      return this.selectPatient;
   }

   public void setSelectPatient(boolean var1) {
      this.selectPatient = var1;
   }

   public boolean isShowModalPanelPatients() {
      return this.showModalPanelPatients;
   }

   public void setShowModalPanelPatients(boolean var1) {
      this.showModalPanelPatients = var1;
   }

   public boolean isShowModalPanelReglementCtrl() {
      return this.showModalPanelReglementCtrl;
   }

   public void setShowModalPanelReglementCtrl(boolean var1) {
      this.showModalPanelReglementCtrl = var1;
   }

   public List getLesTiersPayeurs() {
      return this.lesTiersPayeurs;
   }

   public void setLesTiersPayeurs(List var1) {
      this.lesTiersPayeurs = var1;
   }

   public Date getDateFacture() {
      return this.dateFacture;
   }

   public void setDateFacture(Date var1) {
      this.dateFacture = var1;
   }

   public Date getDateRecapitulatif() {
      return this.dateRecapitulatif;
   }

   public void setDateRecapitulatif(Date var1) {
      this.dateRecapitulatif = var1;
   }

   public int getNbLigneSelect() {
      return this.nbLigneSelect;
   }

   public void setNbLigneSelect(int var1) {
      this.nbLigneSelect = var1;
   }

   public int getNbLigneTotal() {
      return this.nbLigneTotal;
   }

   public void setNbLigneTotal(int var1) {
      this.nbLigneTotal = var1;
   }

   public boolean isShowModalPanelFactureTiers() {
      return this.showModalPanelFactureTiers;
   }

   public void setShowModalPanelFactureTiers(boolean var1) {
      this.showModalPanelFactureTiers = var1;
   }

   public int getTypeTiers() {
      return this.typeTiers;
   }

   public void setTypeTiers(int var1) {
      this.typeTiers = var1;
   }

   public boolean isShowModalPanelNoteIncident() {
      return this.showModalPanelNoteIncident;
   }

   public void setShowModalPanelNoteIncident(boolean var1) {
      this.showModalPanelNoteIncident = var1;
   }

   public double getPartTiersAssurance() {
      return this.partTiersAssurance;
   }

   public void setPartTiersAssurance(double var1) {
      this.partTiersAssurance = var1;
   }

   public double getPartTiersComplementaire() {
      return this.partTiersComplementaire;
   }

   public void setPartTiersComplementaire(double var1) {
      this.partTiersComplementaire = var1;
   }

   public double getPartTiersSociete() {
      return this.partTiersSociete;
   }

   public void setPartTiersSociete(double var1) {
      this.partTiersSociete = var1;
   }

   public boolean isShowModalPanelPrintRecu() {
      return this.showModalPanelPrintRecu;
   }

   public void setShowModalPanelPrintRecu(boolean var1) {
      this.showModalPanelPrintRecu = var1;
   }

   public int getInpNumRecap() {
      return this.inpNumRecap;
   }

   public void setInpNumRecap(int var1) {
      this.inpNumRecap = var1;
   }

   public boolean isFacturesChargee() {
      return this.facturesChargee;
   }

   public void setFacturesChargee(boolean var1) {
      this.facturesChargee = var1;
   }

   public DataModel getDataModelFactureLibre() {
      return this.dataModelFactureLibre;
   }

   public void setDataModelFactureLibre(DataModel var1) {
      this.dataModelFactureLibre = var1;
   }

   public DataModel getDataModelFactureRecap() {
      return this.dataModelFactureRecap;
   }

   public void setDataModelFactureRecap(DataModel var1) {
      this.dataModelFactureRecap = var1;
   }

   public RecapitulatifMedical getRecapitulatifMedical() {
      return this.recapitulatifMedical;
   }

   public void setRecapitulatifMedical(RecapitulatifMedical var1) {
      this.recapitulatifMedical = var1;
   }

   public boolean isTiersChargee() {
      return this.tiersChargee;
   }

   public void setTiersChargee(boolean var1) {
      this.tiersChargee = var1;
   }

   public String getInpNomTiersPayeurs() {
      return this.inpNomTiersPayeurs;
   }

   public void setInpNomTiersPayeurs(String var1) {
      this.inpNomTiersPayeurs = var1;
   }

   public boolean isAfficheBoutonFacture() {
      return this.afficheBoutonFacture;
   }

   public void setAfficheBoutonFacture(boolean var1) {
      this.afficheBoutonFacture = var1;
   }

   public boolean isShowModalPanelAjoutFacture() {
      return this.showModalPanelAjoutFacture;
   }

   public void setShowModalPanelAjoutFacture(boolean var1) {
      this.showModalPanelAjoutFacture = var1;
   }

   public DataModel getDataModelNouvelleFactures() {
      return this.dataModelNouvelleFactures;
   }

   public void setDataModelNouvelleFactures(DataModel var1) {
      this.dataModelNouvelleFactures = var1;
   }
}
