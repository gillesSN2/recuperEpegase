package com.epegase.forms.medical;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.tiers.FormPatients;
import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.ConventionMedical;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureLigneMedical;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.LaboratoireEntete;
import com.epegase.systeme.classe.LaboratoireLigne;
import com.epegase.systeme.classe.LaboratoireReglement;
import com.epegase.systeme.classe.LaboratoireResultat;
import com.epegase.systeme.classe.LettreMedical;
import com.epegase.systeme.classe.MotifEntreeMedical;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PatientAnt;
import com.epegase.systeme.classe.PatientLettreGarantie;
import com.epegase.systeme.classe.PatientPec;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDetail;
import com.epegase.systeme.classe.ProduitsFourchette;
import com.epegase.systeme.classe.ProduitsLaboratoire;
import com.epegase.systeme.classe.ProduitsReponse;
import com.epegase.systeme.classe.ProduitsServices;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.Rdv;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ConventionMedicalDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.FactureLigneMedicalDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.LaboratoireEnteteDao;
import com.epegase.systeme.dao.LaboratoireLigneDao;
import com.epegase.systeme.dao.LaboratoireReglementDao;
import com.epegase.systeme.dao.LaboratoireResultatDao;
import com.epegase.systeme.dao.LettreMedicalDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PatientAntDao;
import com.epegase.systeme.dao.PatientLettreGarantieDao;
import com.epegase.systeme.dao.PatientPecDao;
import com.epegase.systeme.dao.PatientProtDao;
import com.epegase.systeme.dao.ProduitsDetailDao;
import com.epegase.systeme.dao.ProduitsFourchetteDao;
import com.epegase.systeme.dao.ProduitsLaboratoireDao;
import com.epegase.systeme.dao.ProduitsMclesDao;
import com.epegase.systeme.dao.ProduitsReponseDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.RdvDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.LireLesoptionsCaisses;
import com.epegase.systeme.xml.ObjetCategories;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionCaisses;
import com.epegase.systeme.xml.OptionMedical;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
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

public class FormLaboratoire implements Serializable {
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
   private long var_nom_medecin;
   private List lesMedecins = new ArrayList();
   private List mesMedecinsItem = new ArrayList();
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
   private int inpEtat = 11;
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
   private LaboratoireEntete laboratoireEntete;
   private LaboratoireEnteteDao laboratoireEnteteDao;
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
   private boolean valideLaboratoire;
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
   private transient DataModel dataModelLaboratoire = new ListDataModel();
   private List lesLaboratoire = new ArrayList();
   private LaboratoireLigne laboratoireLigne;
   private LaboratoireLigneDao laboratoireLigneDao;
   private boolean griserchamps = false;
   private List mesLettresItems;
   private String var_lettre;
   private float var_pecCnamgs;
   private boolean var_pecAssurance;
   private boolean afficheButtActes;
   private String lettreActe;
   private List lesTarifs = new ArrayList();
   private String inpCodeFamille;
   private PatientPecDao patientPecDao;
   private TaxesVentesDao taxesMedicalDao;
   private ProduitsTarifDao produitsTarifDao;
   private ConventionMedicalDao conventionMedicalDao;
   private LettreMedicalDao lettreMedicalDao;
   private boolean showModalPanelProduits = false;
   private boolean showModalPanelDetailProduits = false;
   private List lesProduits = new ArrayList();
   private transient DataModel datamodelProduits = new ListDataModel();
   private UIDataTable extDTableProduits = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionProduits = new SimpleSelection();
   private Service service;
   private ProduitsVtesDao produitsMedicDao;
   private ProduitsMclesDao produitsMclesDao;
   private ProduitsServicesDao produitsServicesDao;
   private ProduitsServices produitsServices;
   private TaxesVentes taxesMedical = new TaxesVentes();
   private ProduitsTarif produitsTarif = new ProduitsTarif();
   private ProduitsDetailDao produitsDetailDao;
   private List mesImputationLabo = new ArrayList();
   private boolean choixImputationLabo;
   private transient DataModel datamodelDocumentTrace;
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
   private ProduitsReponseDao produitsReponseDao;
   private LaboratoireResultat laboratoireResultat;
   private LaboratoireResultat examenDetailResultat;
   private LaboratoireResultatDao laboratoireResultatDao;
   private ProduitsLaboratoire produitsLaboratoire;
   private ProduitsLaboratoireDao produitsLaboratoireDao;
   private UploadedFile uploadedFile;
   private String urlphotoProd;
   private String urlphotoResultat;
   private boolean existPdfFile;
   private boolean var_affFicPdf;
   private List lesAppareilsItems;
   private List lesResulatsHistoriques;
   private List lesReponsesItems;
   private List lesActionsItems;
   private List lesReponses;
   private transient DataModel dataModelLesReponses;
   private List lesDetailsExamens = new ArrayList();
   private transient DataModel dataModelDetailExamens;
   private transient DataModel dataModelListeExamens;
   private boolean showModalPanelDetail = false;
   private List lesReponsesDetail;
   private transient DataModel dataModelLesReponsesDetail;
   private List lesReponsesItemsDetail;
   private List lesActionsItemsDetail;
   private boolean showModalPanelCloture = false;
   private boolean showModalPanelDeCloture = false;
   private ProduitsReponse produitsReponse;
   private boolean listeAction = false;
   private String factureEnCours;
   private ProduitsFourchette produitsFourchette;
   private ProduitsFourchetteDao produitsFourchetteDao;
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
   private boolean showModalPanelChangerServiceLaboratoire = false;
   private String nouveauService;
   private long nouveauMedecin;
   private String ancienMedecin;

   public FormLaboratoire() {
      this.mesCaissesSeriesItems = new ArrayList();
      this.datamodelDocumentTrace = new ListDataModel();
   }

   public void instanceDaoUtilises() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.laboratoireEnteteDao = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
      this.laboratoireLigneDao = new LaboratoireLigneDao(this.baseLog, this.utilInitHibernate);
      this.laboratoireResultatDao = new LaboratoireResultatDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.patientAntDao = new PatientAntDao(this.baseLog, this.utilInitHibernate);
      this.produitsMedicDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      this.produitsMclesDao = new ProduitsMclesDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.produitsDetailDao = new ProduitsDetailDao(this.baseLog, this.utilInitHibernate);
      this.produitsServicesDao = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
      this.produitsReponseDao = new ProduitsReponseDao(this.baseLog, this.utilInitHibernate);
      this.produitsFourchetteDao = new ProduitsFourchetteDao(this.baseLog, this.utilInitHibernate);
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
      this.inpEtat = 11;
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

      this.nomRepertoire = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator;
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

   public void calculMedecinActe() throws HibernateException, NamingException {
      this.calculMedecinActe((Session)null);
   }

   public void calculMedecinActe(Session var1) throws HibernateException, NamingException {
      this.lesMedecins.clear();
      this.lesMedecins = this.usersDao.chargerLesUsersByServices(this.laboratoireEntete.getLabLaboratoire(), var1);
      this.mesMedecinsItem.clear();

      for(int var2 = 0; var2 < this.lesMedecins.size(); ++var2) {
         Users var3 = (Users)this.lesMedecins.get(var2);
         if ((var3.getUsrFonction().contains("Professeur") || var3.getUsrFonction().contains("Médecin")) && var3.getUsrPatronyme() != null && !var3.getUsrPatronyme().isEmpty()) {
            this.mesMedecinsItem.add(new SelectItem(var3.getUsrid(), var3.getUsrPatronyme() + ":" + var3.getUsrMetier()));
         }
      }

      this.verifValideLaboratoire();
   }

   public void chargerMedecinService() throws HibernateException, NamingException {
      this.mesMedecinsItem.clear();
      String var1 = "";
      if (this.nouveauService != null && !this.nouveauService.isEmpty()) {
         var1 = this.nouveauService;
      } else if (this.laboratoireEntete.getLabLaboratoire() != null && !this.laboratoireEntete.getLabLaboratoire().isEmpty()) {
         var1 = this.laboratoireEntete.getLabLaboratoire();
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
      this.verifValideLaboratoire();
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
      this.laboratoireEntete.setPatients(this.patients);
      this.laboratoireEntete.setLabIdPatient(this.patients.getPatId());
      if (this.patients.getPatPrenom() != null && !this.patients.getPatPrenom().isEmpty()) {
         this.laboratoireEntete.setLabNomPatient(this.patients.getPatNom() + " " + this.patients.getPatPrenom());
      } else {
         this.laboratoireEntete.setLabNomPatient(this.patients.getPatNom());
      }

      this.laboratoireEntete.setLabCivilite(this.patients.getPatCivilite());
      this.laboratoireEntete.setLabPecCnamgs(0.0F);
      this.nomFamille = (long)this.patients.getPatNomFamille();
      this.laboratoireEntete.setLabFam(this.nomFamille);
      this.nomComplementaire = this.patients.getPatPecComplementaire();
      this.laboratoireEntete.setLabComplementaire(this.nomComplementaire);
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
            if ((((PatientPec)var3.get(var4)).getPatpecInactif() == 0 || ((PatientPec)var3.get(var4)).getTiers().getTieid() == this.laboratoireEntete.getLabIdAssurance() || ((PatientPec)var3.get(var4)).getTiers().getTieid() == this.laboratoireEntete.getLabIdSociete() || ((PatientPec)var3.get(var4)).getTiers().getTieid() == this.laboratoireEntete.getLabIdComplementaire()) && ((PatientPec)var3.get(var4)).getPatpecType() != null && !((PatientPec)var3.get(var4)).getPatpecType().isEmpty()) {
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
         var16 = this.laboratoireEnteteDao.rechercheLaboratoire(var1, this.exercicesVentes.getExevteId(), this.getInpNum(), this.getInpNomPatient(), this.getInpPrenomPatient(), this.getInpTel(), this.getInpCi(), this.getInpDossier(), this.getInpSociete(), this.getInpAssurance(), this.getInpComplementaire(), this.getInpContrat(), this.getInpEtat(), this.getInpSerie(), this.getInpFam(), this.getPeriode(), this.getInpService(), this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.getInpProtocole(), this.getInpMedecin(), this.getInpActivite(), var14, var15);
      }

      int var17;
      if (this.inpEtat == 13) {
         if (((List)var16).size() != 0) {
            for(var17 = 0; var17 < ((List)var16).size(); ++var17) {
               if (((LaboratoireEntete)((List)var16).get(var17)).getLabEtat() == 1 || ((LaboratoireEntete)((List)var16).get(var17)).getLabEtat() == 4 || ((LaboratoireEntete)((List)var16).get(var17)).getLabEtat() == 5 || ((LaboratoireEntete)((List)var16).get(var17)).getLabEtat() == 6) {
                  this.lesConsultationEntete.add(((List)var16).get(var17));
               }
            }
         }
      } else if (this.inpEtat == 15) {
         for(var17 = 0; var17 < ((List)var16).size(); ++var17) {
            if (((LaboratoireEntete)((List)var16).get(var17)).getLabEtat() == 6) {
               this.lesConsultationEntete.add(((List)var16).get(var17));
            }
         }
      } else if (this.inpEtat != 17 && this.inpEtat != 18) {
         this.lesConsultationEntete = (List)var16;
      } else {
         for(var17 = 0; var17 < ((List)var16).size(); ++var17) {
            if (((LaboratoireEntete)((List)var16).get(var17)).getLabEtat() == 5 || ((LaboratoireEntete)((List)var16).get(var17)).getLabEtat() == 6) {
               this.lesConsultationEntete.add(((List)var16).get(var17));
            }
         }
      }

      if (this.lesConsultationEntete.size() > 0) {
         this.datamodelDocument = new ListDataModel();
         this.datamodelDocument.setWrappedData(this.lesConsultationEntete);
         new LaboratoireEntete();

         for(int var18 = 0; var18 < this.lesConsultationEntete.size(); ++var18) {
            LaboratoireEntete var19 = (LaboratoireEntete)this.lesConsultationEntete.get(var18);
            var2 += var19.getLabTotPatient();
            var4 += var19.getLabTotTaxePatient();
            var6 = var6 + var19.getLabTotAssurance() + var19.getLabTotSociete() + var19.getLabTotComplmentaire();
            var8 = var8 + var19.getLabTotTaxeAssurance() + var19.getLabTotTaxeSociete() + var19.getLabTotTaxeComplementaire();
            var10 += var19.getLabRegPatient();
            var12 += var19.getLabRegTiers();
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
      this.laboratoireEntete = new LaboratoireEntete();
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
            this.laboratoireEntete = (LaboratoireEntete)var1.get(0);
            this.var_pecCnamgs = this.laboratoireEntete.getLabPecCnamgs();
            this.nomFamille = this.laboratoireEntete.getLabFam();
            this.nomComplementaire = this.laboratoireEntete.getLabComplementaire();
            if (this.laboratoireEntete.getLabIdAssurance() != 0L) {
               this.var_pecAssurance = true;
            } else {
               this.var_pecAssurance = false;
            }

            this.var_nom_medecin = this.laboratoireEntete.getLabIdMedecin();
            this.memoDateRdv = this.laboratoireEntete.getLabDateResultat();
            this.var_date = this.laboratoireEntete.getLabDate();
            if (this.laboratoireEntete.getLabDate().getHours() <= 9) {
               this.var_heure = "0" + this.laboratoireEntete.getLabDate().getHours();
            } else {
               this.var_heure = "" + this.laboratoireEntete.getLabDate().getHours();
            }

            if (this.laboratoireEntete.getLabDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.laboratoireEntete.getLabDate().getMinutes();
            } else {
               this.var_minute = "" + this.laboratoireEntete.getLabDate().getMinutes();
            }

            if (this.laboratoireEntete.getLabDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.laboratoireEntete.getLabDate().getSeconds();
            } else {
               this.var_seconde = "" + this.laboratoireEntete.getLabDate().getSeconds();
            }

            this.patients = this.laboratoireEntete.getPatients();
            Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
            this.chargerPriseEnCharges(var6);
            this.elementPatient(var6);
            this.chargerActes(var6);
            this.var_aff_detail_prod = false;
            this.afficheButtActes = false;
            this.afficheButtAntecedent = false;
            double var4 = this.chargerBonEncaissement(var6);
            this.calculMedecinActe(var6);
            this.chargerUserChrono(var6);
            this.chargerDocumentScan();
            this.utilInitHibernate.closeSession();
            if (this.laboratoireEntete.getLabRegPatient() != var4) {
               this.laboratoireEntete.setLabRegPatient(var4);
               if (var4 >= this.laboratoireEntete.getLabTotPatient()) {
                  this.laboratoireEntete.setLabSoldePatient(1);
               } else {
                  this.laboratoireEntete.setLabSoldePatient(0);
               }

               this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete);
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
      if (this.laboratoireEntete != null) {
         if (this.laboratoireEntete.getLabEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void chargerPriseEnCharges(Session var1) throws HibernateException, NamingException {
      this.patientPec = null;
      this.patientPecComplementaire = null;
      if (this.laboratoireEntete.getLabFam() != 0L) {
         this.patientPec = this.patientPecDao.trouverPatientsPec(this.laboratoireEntete.getLabFam(), 0, var1);
      }

      if (this.laboratoireEntete.getLabComplementaire() != 0L) {
         this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.laboratoireEntete.getLabComplementaire(), 0, var1);
      }

   }

   public void chargerActes(Session var1) throws HibernateException, NamingException {
      this.lesLaboratoire.clear();
      this.laboratoireLigne = new LaboratoireLigne();
      this.lesLaboratoire = this.laboratoireLigneDao.selectConsActesByConsEnt(this.laboratoireEntete, var1);
      this.dataModelLaboratoire.setWrappedData(this.lesLaboratoire);
      this.ajouterSurAvoir = false;
      this.totalDocFacture = 0.0D;
      this.totalDocPatient = 0.0D;
      this.totalDocReglement = 0.0D;
      this.totalDocTiers = 0.0D;
      if (this.lesLaboratoire.size() != 0) {
         for(int var2 = 0; var2 < this.lesLaboratoire.size(); ++var2) {
            this.totalDocFacture += ((LaboratoireLigne)this.lesLaboratoire.get(var2)).getLabligTotal() + ((LaboratoireLigne)this.lesLaboratoire.get(var2)).getLabligTaxe();
            this.totalDocPatient += ((LaboratoireLigne)this.lesLaboratoire.get(var2)).getTotlalPatient();
            this.totalDocReglement += ((LaboratoireLigne)this.lesLaboratoire.get(var2)).getLabligRegPatient();
            this.totalDocTiers += ((LaboratoireLigne)this.lesLaboratoire.get(var2)).getTotalTiers();
            if (((LaboratoireLigne)this.lesLaboratoire.get(var2)).getLabligQte() < 0.0F && (((LaboratoireLigne)this.lesLaboratoire.get(var2)).getLaboratoireEntete().getLabDateTransfert() == null || ((LaboratoireLigne)this.lesLaboratoire.get(var2)).getLaboratoireEntete().getLabEtat() <= 9)) {
               this.ajouterSurAvoir = true;
            }
         }
      }

   }

   public double chargerBonEncaissement(Session var1) throws HibernateException, NamingException {
      this.var_tot_bon_encaissement = 0.0D;
      new ArrayList();
      List var2 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.laboratoireEntete.getLabId(), this.nature, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((BonEncaissementVente)var2.get(var3)).getBonEtat() == 0) {
               this.var_tot_bon_encaissement = this.var_tot_bon_encaissement + ((BonEncaissementVente)var2.get(var3)).getBonAPayer() + ((BonEncaissementVente)var2.get(var3)).getBonAPayerReliquat();
            }
         }
      }

      new ArrayList();
      List var8 = this.reglementsDao.reglementDocument(this.laboratoireEntete.getLabId(), this.nature, var1);
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
      if (this.var_tot_bon_encaissement < this.laboratoireEntete.getTotalPatient()) {
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
      if (this.laboratoireEntete != null && this.laboratoireEntete.getLabSerie() != null && !this.laboratoireEntete.getLabSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.laboratoireEntete.getLabSerie(), 74, this.usersLog, var1);
      }

   }

   public void chargerDocumentScan() throws IOException {
      this.lesDocuments.clear();
      if (this.nomRepertoire != null && !this.nomRepertoire.isEmpty()) {
         File var1 = new File(this.nomRepertoire);
         if (!var1.exists()) {
            var1.mkdir();
         }

         String var2 = this.laboratoireEntete.getLabNum().replace("/", "_");
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
         if (this.laboratoireEntete.getLabId() > 0L) {
            FactureLigneMedicalDao var4 = new FactureLigneMedicalDao(this.baseLog, this.utilInitHibernate);
            var1 = var4.chargerLesLignesFacturesByNature(this.laboratoireEntete.getLabId(), "", 74, var2);
            if (((List)var1).size() != 0) {
               if (this.laboratoireEntete.getLabEtat() <= 5) {
                  this.laboratoireEntete.setLabEtat(6);
                  this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var2);
               }
            } else if (this.laboratoireEntete.getLabEtat() >= 6) {
               this.laboratoireEntete.setLabEtat(5);
               this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var2);
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
      if (this.laboratoireEntete.getLabPathologie() == null || this.laboratoireEntete.getLabPathologie().isEmpty() || !this.laboratoireEntete.getLabPathologie().contains(":") || this.laboratoireEntete.getLabPathologie().equals("100")) {
         this.laboratoireEntete.setLabPathologie("");
      }

      if (this.laboratoireEntete.getLabProtocole() == null || this.laboratoireEntete.getLabProtocole().isEmpty() || !this.laboratoireEntete.getLabProtocole().contains(":") || this.laboratoireEntete.getLabProtocole().equals("100")) {
         this.laboratoireEntete.setLabProtocole("");
      }

      if (this.laboratoireEntete.getLabService() == null || this.laboratoireEntete.getLabService().isEmpty() || !this.laboratoireEntete.getLabService().contains(":") || this.laboratoireEntete.getLabService().equals("100")) {
         this.laboratoireEntete.setLabService("");
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
      if (this.lesLaboratoire.size() != 0) {
         new LaboratoireLigne();

         for(int var24 = 0; var24 < this.lesLaboratoire.size(); ++var24) {
            LaboratoireLigne var23 = (LaboratoireLigne)this.lesLaboratoire.get(var24);
            var5 += var23.getLabligPatientHt();
            var7 += var23.getLabligPatientTaxe();
            var9 += var23.getLabligSocieteHt();
            var11 += var23.getLabligSocieteTaxe();
            var13 += var23.getLabligAssuranceHt();
            var15 += var23.getLabligAssuranceTaxe();
            var17 += var23.getLabligComplementaireHt();
            var19 += var23.getLabligComplementaireTaxe();
            var21 += var23.getLabligRabais();
         }

         var1 = var5 + var9 + var13 + var17;
         var3 = var7 + var11 + var15 + var19;
      }

      this.laboratoireEntete.setLabTotPatient(var5);
      this.laboratoireEntete.setLabTotTaxePatient(var7);
      this.laboratoireEntete.setLabTotSociete(var9);
      this.laboratoireEntete.setLabTotTaxeSociete(var11);
      this.laboratoireEntete.setLabTotAssurance(var13);
      this.laboratoireEntete.setLabTotTaxeAssurance(var15);
      this.laboratoireEntete.setLabTotComplmentaire(var17);
      this.laboratoireEntete.setLabTotTaxeComplementaire(var19);
      this.laboratoireEntete.setLabTotGeneral(var1);
      this.laboratoireEntete.setLabTotTaxeGeneral(var3);
      this.laboratoireEntete.setLabTotRabais(var21);
      this.var_tot_tiers = var9 + var13 + var17;
      this.var_tot_reg = this.laboratoireEntete.getLabRegPatient() + this.laboratoireEntete.getLabRegTiers();
      this.var_solde = this.laboratoireEntete.getLabTotGeneral() - this.var_tot_reg;
      this.totalDocFacture = var1 + var3;
      this.totalDocPatient = var5 + var7;
      this.totalDocReglement = this.var_tot_reg;
      this.totalDocTiers = var9 + var11 + var13 + var15 + var17 + var19;
   }

   public void calculeEtat() throws HibernateException, NamingException {
      if (this.laboratoireEntete != null) {
         this.dateRefacturation = null;
         this.numRefacturation = "";
         this.etatRefacuration = "";
         this.autoriseRefacturation = false;
         new FactureLigneMedical();
         FactureLigneMedicalDao var2 = new FactureLigneMedicalDao(this.baseLog, this.utilInitHibernate);
         FactureLigneMedical var1 = var2.rechercheFactureByLaboratoire(this.laboratoireEntete.getLabId(), (Session)null);
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
      if (this.laboratoireEntete != null) {
         this.laboratoireEntete.setLabBloqueRefacturation(true);
         this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete);
      }

   }

   public void deBloqueFacturation() throws HibernateException, NamingException {
      if (this.laboratoireEntete != null) {
         this.laboratoireEntete.setLabBloqueRefacturation(false);
         this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete);
      }

   }

   public void ajoutDocument() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      this.lesMedecins.clear();
      this.mesMedecinsItem.clear();
      this.lesPatientAntecedent.clear();
      this.dataModelAntecedent.setWrappedData(this.lesPatientAntecedent);
      this.lesLaboratoire.clear();
      this.dataModelLaboratoire.setWrappedData(this.lesLaboratoire);
      this.lesLaboratoire.clear();
      this.dataModelLaboratoire.setWrappedData(this.lesLaboratoire);
      this.laboratoireEntete = new LaboratoireEntete();
      this.laboratoireLigne = new LaboratoireLigne();
      this.memoDateRdv = null;
      this.mesCategoriesItems.clear();
      this.calculMedecinActe();
      this.nomFamille = 0L;
      this.nomComplementaire = 0L;
      this.patientPec = null;
      this.patientPecComplementaire = null;
      this.valideLaboratoire = false;
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

      this.laboratoireEntete.setLabIdCreateur(this.usersLog.getUsrid());
      this.laboratoireEntete.setLabNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.laboratoireEntete.setLabIdMedecin(this.usersLog.getUsrid());
      this.laboratoireEntete.setLabMedecin(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.laboratoireEntete.setLabDate(new Date());
      this.laboratoireEntete.setLabDateCreat(new Date());
      this.laboratoireEntete.setLabDateModif((Date)null);
      this.laboratoireEntete.setLabIdModif(0L);
      this.laboratoireEntete.setLabNomModif("");
      this.laboratoireEntete.setLabNum("");
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
      this.showModalpanelPec = false;
      this.ajouterSurAvoir = false;
      this.totalDocFacture = 0.0D;
      this.totalDocPatient = 0.0D;
      this.totalDocReglement = 0.0D;
      this.totalDocTiers = 0.0D;
      this.var_memo_action = this.var_action;
   }

   public void duppliquerDocument() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      if (this.laboratoireEntete != null && this.patients != null) {
         this.var_consultation_directe = true;
         this.lesMedecins.clear();
         this.mesMedecinsItem.clear();
         this.lesPatientAntecedent.clear();
         this.dataModelAntecedent.setWrappedData(this.lesPatientAntecedent);
         this.lesLaboratoire.clear();
         this.dataModelLaboratoire.setWrappedData(this.lesLaboratoire);
         this.lesLaboratoire.clear();
         this.dataModelLaboratoire.setWrappedData(this.lesLaboratoire);
         this.laboratoireEntete = new LaboratoireEntete();
         this.laboratoireLigne = new LaboratoireLigne();
         this.memoDateRdv = null;
         this.mesCategoriesItems.clear();
         this.calculMedecinActe();
         this.nomFamille = 0L;
         this.nomComplementaire = 0L;
         this.patientPec = null;
         this.patientPecComplementaire = null;
         this.valideLaboratoire = false;
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
         this.laboratoireEntete.setLabIdCreateur(this.usersLog.getUsrid());
         this.laboratoireEntete.setLabNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         this.laboratoireEntete.setLabIdMedecin(this.usersLog.getUsrid());
         this.laboratoireEntete.setLabMedecin(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         this.laboratoireEntete.setLabDate(new Date());
         this.laboratoireEntete.setLabDateCreat(new Date());
         this.laboratoireEntete.setLabDateModif((Date)null);
         this.laboratoireEntete.setLabIdModif(0L);
         this.laboratoireEntete.setLabNomModif("");
         this.laboratoireEntete.setLabNum("");
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
         this.var_memo_action = this.var_action;
      }

   }

   public void modifDocument() throws JDOMException, IOException, ParseException {
      if (this.laboratoireEntete != null) {
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
         this.verifValideLaboratoire();
         this.choixImputationLabo = false;
         this.mesImputationLabo.clear();
         this.var_memo_action = this.var_action;
      }

   }

   public void consultDocument() throws ParseException {
      if (this.laboratoireEntete != null) {
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
         this.valideLaboratoire = false;
         this.choixImputationLabo = false;
         this.mesImputationLabo.clear();
         this.var_memo_action = this.var_action;
      }

   }

   public void chargerModeEcheance() throws ParseException {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      if (this.laboratoireEntete.getLabTypeReg() != 0 && this.laboratoireEntete.getLabTypeReg() != 3) {
         if (this.laboratoireEntete.getLabTypeReg() != 1 && this.laboratoireEntete.getLabTypeReg() != 2) {
            this.visibiliteterme = false;
         } else {
            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
            this.visibiliteencaissemt = false;
         }
      } else {
         this.laboratoireEntete.setLabNbJourReg(0);
         this.laboratoireEntete.setLabArrondiReg(0);
      }

      if (this.laboratoireEntete.getLabTypeReg() == 4) {
         this.visibiliteencaissemt = true;
         this.visibilitenbrjr = true;
      } else {
         this.visibiliteencaissemt = false;
      }

      this.CalculDateEcheance();
   }

   public void CalculDateEcheance() throws ParseException {
      Date var1 = this.utilDate.CalculDateEcheance(this.laboratoireEntete.getLabDate(), this.laboratoireEntete.getLabTypeReg(), this.laboratoireEntete.getLabNbJourReg(), this.laboratoireEntete.getLabArrondiReg());
      this.laboratoireEntete.setLabDateEcheReg(var1);
   }

   public void selectionPec() throws HibernateException, NamingException {
      this.changerTarif();
   }

   public void supprimerDocument() throws HibernateException, NamingException {
      if (this.laboratoireEntete != null) {
         String var1 = this.laboratoireEntete.getLabNum();
         new ArrayList();
         List var2 = this.reglementsDao.reglementDocument(this.laboratoireEntete.getLabId(), this.nature, (Session)null);
         if (var2.size() == 0) {
            Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
            Transaction var4 = null;

            try {
               var4 = var3.beginTransaction();
               int var5;
               if (this.lesLaboratoire.size() != 0) {
                  for(var5 = 0; var5 < this.lesLaboratoire.size(); ++var5) {
                     this.laboratoireLigne = (LaboratoireLigne)this.lesLaboratoire.get(var5);
                     this.laboratoireLigneDao.delete(this.laboratoireLigne, var3);
                  }
               }

               this.lesDetailsExamens = this.laboratoireResultatDao.selectResultatListe(this.laboratoireLigne, var3);
               if (this.lesDetailsExamens.size() != 0) {
                  for(var5 = 0; var5 < this.lesDetailsExamens.size(); ++var5) {
                     this.laboratoireResultat = (LaboratoireResultat)this.lesDetailsExamens.get(var5);
                     this.laboratoireResultatDao.delete(this.laboratoireResultat, var3);
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
               List var14 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.laboratoireEntete.getLabId(), this.nature, var3);
               if (var14.size() != 0) {
                  for(int var13 = 0; var13 < var14.size(); ++var13) {
                     this.bonEncaissementVente = (BonEncaissementVente)var14.get(var13);
                     this.bonEncaissementVenteDao.delete(this.bonEncaissementVente, var3);
                  }
               }

               new LaboratoireEntete();
               LaboratoireEntete var15 = this.laboratoireEnteteDao.selectById(this.laboratoireEntete.getLabId(), var3);
               if (var15 != null) {
                  this.laboratoireEnteteDao.delete(var15, var3);
               }

               this.lesConsultationEntete.remove(this.laboratoireEntete);
               Espion var16 = new Espion();
               var16.setUsers(this.usersLog);
               var16.setEsptype(0);
               var16.setEspdtecreat(new Date());
               var16.setEspaction("Suppression laboratoire N° " + var1);
               this.espionDao.mAJEspion(var16, var3);
               var4.commit();
            } catch (HibernateException var11) {
               if (var4 != null) {
                  var4.rollback();
               }

               throw var11;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      this.visibleOnglet = false;
      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void save() throws HibernateException, NamingException, ParseException {
      boolean var1 = false;
      this.calculTotaux();
      this.verifieExistenceHabilitation((Session)null);
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
      Transaction var3 = null;

      Users var4;
      try {
         var3 = var2.beginTransaction();
         this.laboratoireEntete.setLabDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         new Users();
         if (this.var_nom_medecin == 0L && this.mesMedecinsItem.size() == 1) {
            this.var_nom_medecin = Long.parseLong(((SelectItem)this.mesMedecinsItem.get(0)).getValue().toString());
         }

         var4 = this.usersDao.selectUserD(this.var_nom_medecin, var2);
         if (var4 != null) {
            this.laboratoireEntete.setLabIdMedecin(var4.getUsrid());
            this.laboratoireEntete.setLabMedecin(var4.getUsrPatronyme());
         } else {
            this.laboratoireEntete.setLabIdMedecin(0L);
            this.laboratoireEntete.setLabMedecin("");
         }

         this.laboratoireEntete.setLabPecCnamgs(this.var_pecCnamgs);
         this.laboratoireEntete.setLabAyantDroit(false);
         this.laboratoireEntete.setLabNomAssurePrincipal("");
         if (this.laboratoireEntete.getLabFam() <= 0L && this.nomComplementaire == 0L) {
            this.laboratoireEntete.setLabIdAssurance(0L);
            this.laboratoireEntete.setLabNomAssurance("");
            this.laboratoireEntete.setLabContratAssurance("");
            this.laboratoireEntete.setLabIdComplementaire(0L);
            this.laboratoireEntete.setLabNomComplemtaire("");
            this.laboratoireEntete.setLabIdEmployeur(0L);
            this.laboratoireEntete.setLabNomEmployeur("");
            this.laboratoireEntete.setLabContratComplementaire("");
            this.laboratoireEntete.setLabIdSociete(0L);
            this.laboratoireEntete.setLabNomSociete("");
            this.laboratoireEntete.setLabMatricule("");
         } else {
            if (this.patientPec == null) {
               this.patientPec = this.patientPecDao.trouverPatientsPec(this.laboratoireEntete.getLabFam(), 0, var2);
            }

            if (this.patientPec != null) {
               if (this.patientPec.getPatpecType() != null && !this.patientPec.getPatpecType().isEmpty()) {
                  if (!this.patientPec.getPatpecType().equals("Assurance") && !this.patientPec.getPatpecType().equals("IPM")) {
                     if (!this.patientPec.getPatpecType().equals("Mutuelle") && !this.patientPec.getPatpecType().equals("Complémentaire")) {
                        this.laboratoireEntete.setLabIdSociete(this.patientPec.getTiers().getTieid());
                        this.laboratoireEntete.setLabNomSociete(this.patientPec.getTiers().getTieraisonsocialenom());
                        this.laboratoireEntete.setLabMatricule(this.patientPec.getPatpecMatricule());
                     } else {
                        this.laboratoireEntete.setLabIdComplementaire(this.patientPec.getTiers().getTieid());
                        this.laboratoireEntete.setLabNomComplemtaire(this.patientPec.getTiers().getTieraisonsocialenom());
                        this.laboratoireEntete.setLabMatricule(this.patientPec.getPatpecMatricule());
                        this.laboratoireEntete.setLabContratComplementaire(this.patientPec.getPatpecNumContrat());
                     }
                  } else {
                     this.var_pecAssurance = true;
                     this.laboratoireEntete.setLabIdAssurance(this.patientPec.getTiers().getTieid());
                     this.laboratoireEntete.setLabNomAssurance(this.patientPec.getTiers().getTieraisonsocialenom());
                     this.laboratoireEntete.setLabIdEmployeur(this.patientPec.getPatpecIdEmployeur());
                     this.laboratoireEntete.setLabNomEmployeur(this.patientPec.getPatpecNomEmployeur());
                     this.laboratoireEntete.setLabMatricule(this.patientPec.getPatpecMatricule());
                     this.laboratoireEntete.setLabContratAssurance(this.patientPec.getPatpecNumContrat());
                  }

                  if (this.patientPec.getPatpecIdCouvert() != 0L) {
                     this.laboratoireEntete.setLabAyantDroit(true);
                     this.laboratoireEntete.setLabNomAssurePrincipal(this.patientPec.getPatpecNomCouvert());
                  }
               }
            } else {
               this.laboratoireEntete.setLabFam(0L);
            }
         }

         if (this.laboratoireEntete.getLabId() != 0L) {
            if (this.lesLaboratoire.size() == 0) {
               this.formRecherche.setMessageTexte("Vous n'avez pas spécifié de produits. Veuillez cliquez sur l'onglet Examens et saisir au moins un examen.");
               this.formRecherche.setShowModalPanelMessage(true);
            } else {
               this.laboratoireEntete.setLabDateModif(new Date());
               this.laboratoireEntete.setLabIdModif(this.usersLog.getUsrid());
               this.laboratoireEntete.setLabNomModif(this.usersLog.getUsrPatronyme());
               this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var2);
               this.var_action = 0;
               this.var_memo_action = this.var_action;
            }
         } else {
            if (!this.laboratoireEntete.getLabSerie().equalsIgnoreCase("X") && !this.laboratoireEntete.getLabSerie().isEmpty()) {
               this.laboratoireEntete.setLabNum(this.calculChrono.numCompose(this.laboratoireEntete.getLabDate(), this.nature, this.laboratoireEntete.getLabSerie(), var2));
               boolean var26 = false;

               label664:
               while(true) {
                  while(true) {
                     if (var26) {
                        break label664;
                     }

                     new LaboratoireEntete();
                     LaboratoireEntete var6 = this.laboratoireEnteteDao.selectByNum(this.laboratoireEntete.getLabNum(), this.laboratoireEntete.getLabSerie(), var2);
                     if (var6 != null) {
                        long var7 = 100000000L * this.usersLog.getUsrid();

                        for(long var9 = 0L; var9 < var7; ++var9) {
                        }

                        this.laboratoireEntete.setLabNum(this.calculChrono.numCompose(this.laboratoireEntete.getLabDate(), this.nature, this.laboratoireEntete.getLabSerie(), var2));
                        var26 = false;
                     } else {
                        var26 = true;
                     }
                  }
               }
            } else {
               long var5 = this.laboratoireEnteteDao.selectLastNum(var2);
               this.laboratoireEntete.setLabNum("" + var5);
            }

            this.laboratoireEntete.setExerciceventes(this.exercicesVentes);
            this.laboratoireEntete.setPatients(this.patients);
            this.laboratoireEntete.setLabDateCreat(new Date());
            this.laboratoireEntete.setLabIdCreateur(this.usersLog.getUsrid());
            this.laboratoireEntete.setLabNomCreateur(this.usersLog.getUsrPatronyme());
            this.laboratoireEntete.setLabEtat(0);
            this.laboratoireEntete.setLabEtatVal(0);
            this.laboratoireEntete = this.laboratoireEnteteDao.insert(this.laboratoireEntete, var2);
            this.lesConsultationEntete.add(this.laboratoireEntete);
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
            RdvDao var29 = new RdvDao(this.baseLog, this.utilInitHibernate);
            String var8 = "";
            var8 = "rdvPatIdDe=" + this.patients.getPatId() + " and rdvDteDe='" + this.utilDate.dateToStringSQLLight(this.laboratoireEntete.getLabDate()) + "'";
            List var27 = var29.rechercheRdvRequete(var8, var2);
            Rdv var28;
            if (var27.size() != 0) {
               var28 = (Rdv)var27.get(0);
               var28.setRdvEtat(1);
               var28.setRdvDteExec(new Date());
               var28.setRdvCr("Effectué");
               var29.modif(var28, var2);
            }

            if (this.laboratoireEntete.getLabDateResultat() != null) {
               if (this.memoDateRdv != null) {
                  var8 = "rdvPatIdDe=" + this.patients.getPatId() + " and rdvDteDe='" + this.utilDate.dateToStringSQLLight(this.memoDateRdv) + "'";
               } else {
                  var8 = "rdvPatIdDe=" + this.patients.getPatId() + " and rdvDteDe='" + this.utilDate.dateToStringSQLLight(this.laboratoireEntete.getLabDateResultat()) + "'";
               }

               var27 = var29.rechercheRdvRequete(var8, var2);
               String var10;
               String var30;
               if (var27.size() != 0) {
                  if (!this.memoDateRdv.equals(this.laboratoireEntete.getLabDateResultat())) {
                     var28 = (Rdv)var27.get(0);
                     var30 = "";
                     if (this.laboratoireEntete.getLabDateResultat().getHours() <= 9) {
                        var30 = "0" + this.laboratoireEntete.getLabDateResultat().getHours();
                     } else {
                        var30 = "" + this.laboratoireEntete.getLabDateResultat().getHours();
                     }

                     var28.setRdvHrDe(var30);
                     var10 = "";
                     if (this.laboratoireEntete.getLabDateResultat().getMinutes() <= 9) {
                        var10 = "0" + this.laboratoireEntete.getLabDateResultat().getMinutes();
                     } else {
                        var10 = "" + this.laboratoireEntete.getLabDateResultat().getMinutes();
                     }

                     var28.setRdvMnDe(var10);
                     var28.setRdvDteDe(this.laboratoireEntete.getLabDateResultat());
                     var29.modif(var28, var2);
                  }
               } else {
                  var28 = new Rdv();
                  var28.setRdvCollaborateur((String)null);
                  var28.setRdvDateCreation(new Date());
                  var28.setRdvDescript((String)null);
                  var28.setRdvDteDe(this.laboratoireEntete.getLabDateResultat());
                  var28.setRdvEtat(0);
                  var30 = "";
                  if (this.laboratoireEntete.getLabDateResultat().getHours() <= 9) {
                     var30 = "0" + this.laboratoireEntete.getLabDateResultat().getHours();
                  } else {
                     var30 = "" + this.laboratoireEntete.getLabDateResultat().getHours();
                  }

                  var28.setRdvHrDe(var30);
                  var28.setRdvHrFi("00");
                  var28.setRdvLieu((String)null);
                  var28.setRdvMailContact((String)null);
                  var10 = "";
                  if (this.laboratoireEntete.getLabDateResultat().getMinutes() <= 9) {
                     var10 = "0" + this.laboratoireEntete.getLabDateResultat().getMinutes();
                  } else {
                     var10 = "" + this.laboratoireEntete.getLabDateResultat().getMinutes();
                  }

                  var28.setRdvMnDe(var10);
                  var28.setRdvMnFi("00");
                  var28.setRdvMode("Non renseigné");
                  var28.setRdvNature(1);
                  String var11 = "";
                  if (this.patients.getPatPrenom() != null && !this.patients.getPatPrenom().isEmpty()) {
                     var11 = this.patients.getPatNom() + " " + this.patients.getPatPrenom();
                  } else {
                     var11 = this.patients.getPatNom();
                  }

                  var28.setRdvNomPat(var11);
                  var28.setRdvNomUsers(this.usersLog.getUsrPatronyme());
                  var28.setRdvPatIdDe(this.patients.getPatId());
                  var28.setRdvService(this.usersLog.getUsrService());
                  var28.setRdvSujet("RDV Résultat Labo.");
                  var28.setRdvTache((String)null);
                  var28.setUsers(this.usersLog);
                  var29.insert(var28, var2);
               }

               this.memoDateRdv = this.laboratoireEntete.getLabDateResultat();
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

         if (this.usersChrono.getUsrchrValidation() == 4 && this.laboratoireEntete.getLabEtat() == 1 && this.laboratoireEntete.getLabTotPatient() != 0.0D) {
            if (this.usersLog.getUsrFactureCaisse() == 1 && this.var_tot_bon_encaissement == 0.0D) {
               this.payeDocumentBonEncaissement();
            } else if (this.usersLog.getUsrFactureCaisse() == 2 && this.laboratoireEntete.getLabRegPatient() != this.laboratoireEntete.getLabTotPatient()) {
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
         this.laboratoireEntete.setLabEtatVal(1);
         this.laboratoireEntete.setLabEtat(0);
         return true;
      } else {
         this.laboratoireEntete.setLabEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.laboratoireEntete.setLabEtat(1);
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2) {
               if (this.usersChrono.getUsrchrValidation() == 3) {
                  this.laboratoireEntete.setLabEtat(0);
               } else if (this.usersChrono.getUsrchrValidation() == 4) {
                  this.laboratoireEntete.setLabEtat(1);
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
      if (this.lesLaboratoire.size() == 0 && this.laboratoireEntete.getLabId() != 0L) {
         this.laboratoireEntete.setLabDateAnnule(new Date());
         this.laboratoireEntete.setLabEtat(3);
         this.laboratoireEntete.setLabMotifAnnule("ANNULATION SAISIE SUR AJOUT");
         this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete);
         this.lesConsultationEntete.remove(this.laboratoireEntete);
         this.datamodelDocument.setWrappedData(this.lesConsultationEntete);
      }

   }

   public void verifValideLaboratoire() {
      this.valideLaboratoire = false;
      if (this.laboratoireEntete.getLabIdPatient() != 0L) {
         if (this.optionMedical.getServiceLB().equals("0")) {
            if (this.optionMedical.getMedecinLB().equals("0")) {
               if (this.var_nom_medecin != 0L) {
                  this.valideLaboratoire = true;
               }
            } else {
               this.valideLaboratoire = true;
            }
         } else if (this.optionMedical.getMedecinLB().equals("0")) {
            if (this.var_nom_medecin != 0L) {
               this.valideLaboratoire = true;
            }
         } else {
            this.valideLaboratoire = true;
         }
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.laboratoireEntete.getLabEtat() == 0 && this.usersChrono.getUsrchrValidation() == 2) {
            this.laboratoireEntete.setLabEtat(1);
            this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
            Espion var3 = new Espion();
            var3.setUsers(this.usersLog);
            var3.setEsptype(0);
            var3.setEspdtecreat(new Date());
            var3.setEspaction("Validation manuelle laboratoire (M.) N° " + this.laboratoireEntete.getLabNum() + " du " + this.utilDate.dateToStringSQLLight(this.laboratoireEntete.getLabDate()));
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.laboratoireEntete.getLabEtat() == 1 && this.usersChrono.getUsrchrDeValidation() == 1) {
            this.laboratoireEntete.setLabEtat(0);
            this.laboratoireEntete.setLabDateImp((Date)null);
            this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
            new ArrayList();
            List var3 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.laboratoireEntete.getLabId(), this.nature, var1);
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
            var10.setEspaction("Dévalidation manuelle laboratoire (M.) N° " + this.laboratoireEntete.getLabNum() + " du " + this.utilDate.dateToStringSQLLight(this.laboratoireEntete.getLabDate()));
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
      if (this.laboratoireEntete != null) {
         this.laboratoireEntete.setLabDateAnnule(new Date());
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

               if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 61 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.laboratoireEntete.getLabSerie())) {
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
      if (this.laboratoireEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.laboratoireEntete.getLabDateAnnule() == null) {
               this.laboratoireEntete.setLabDateAnnule(new Date());
            }

            this.laboratoireEntete.setLabEtat(3);
            this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
            new ArrayList();
            List var3 = this.reglementsDao.reglementDocument(this.laboratoireEntete.getLabId(), this.nature, var1);
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
                        var12 = this.majBonencaissementAnnulation(var4, this.laboratoireEntete.getLabDateAnnule(), var1);
                     } else if (this.usersLog.getUsrFactureCaisse() == 2) {
                        var12 = this.majReglementAnnulation(var4, this.laboratoireEntete.getLabDateAnnule(), var1);
                     } else if (this.usersLog.getUsrFactureCaisse() == 3) {
                        var12 = this.majBonencaissementAnnulation(var4, this.laboratoireEntete.getLabDateAnnule(), var1);
                     }
                  }

                  if (var12) {
                     this.lesConsultationEntete.remove(this.laboratoireEntete);
                     this.datamodelDocument.setWrappedData(this.lesConsultationEntete);
                  } else {
                     this.laboratoireEntete = this.laboratoireEnteteDao.selectById(this.laboratoireEntete.getLabId(), var1);
                     if (this.laboratoireEntete != null) {
                        this.laboratoireEntete.setLabDateAnnule((Date)null);
                        this.laboratoireEntete.setLabEtat(1);
                        this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
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

      String var9 = this.calculChrono.numCompose(new Date(), 79, this.laboratoireEntete.getLabSerie(), var4);
      if (var9 != null && !var9.isEmpty()) {
         this.bonEncaissementVente = new BonEncaissementVente();
         if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
            String[] var7 = this.var_inputCaisse.split(":");
            this.bonEncaissementVente.setBonCodeCaisse(var7[0]);
            this.bonEncaissementVente.setBonLibCaisse(var7[1]);
         } else {
            this.bonEncaissementVente.setBonCodeCaisse((String)null);
            this.bonEncaissementVente.setBonLibCaisse((String)null);
         }

         String var10 = "";
         this.bonEncaissementVente.setBonTypeReg(0);
         this.bonEncaissementVente.setBonCodeBanq((String)null);
         this.bonEncaissementVente.setBonLibBanq((String)null);
         this.bonEncaissementVente.setBonBanqueTireur("");
         this.bonEncaissementVente.setBonNumChqBdx("");
         this.bonEncaissementVente.setBonDateCreat(new Date());
         this.bonEncaissementVente.setBonUserCreat(this.usersLog.getUsrid());
         this.bonEncaissementVente.setBonActivite(this.laboratoireEntete.getLabActivite());
         this.bonEncaissementVente.setBonSite("");
         this.bonEncaissementVente.setBonDepartement("");
         this.bonEncaissementVente.setBonService(this.laboratoireEntete.getLabService());
         this.bonEncaissementVente.setBonRegion("");
         this.bonEncaissementVente.setBonSecteur("");
         this.bonEncaissementVente.setBonPdv(var10);
         this.bonEncaissementVente.setBonDateEcheReg(this.laboratoireEntete.getLabDateEcheReg());
         this.bonEncaissementVente.setBonEtat(0);
         this.bonEncaissementVente.setBonNatRef(this.nature);
         this.bonEncaissementVente.setBonNomTiers(this.laboratoireEntete.getLabNomPatient());
         this.bonEncaissementVente.setBonIdTiers(this.laboratoireEntete.getPatients().getPatId());
         this.bonEncaissementVente.setBonNomContact("");
         this.bonEncaissementVente.setBonIdContact(0L);
         this.bonEncaissementVente.setBonTypeTiers(4);
         this.bonEncaissementVente.setBonLibelle("Annulation Règlement Laboratoire N° " + this.laboratoireEntete.getLabNum());
         this.bonEncaissementVente.setBonRef(this.laboratoireEntete.getLabNum());
         this.bonEncaissementVente.setBonIdRef(this.laboratoireEntete.getLabId());
         this.bonEncaissementVente.setBonObject(var10);
         this.bonEncaissementVente.setBonObservation(this.laboratoireEntete.getLabMedecin());
         this.bonEncaissementVente.setBonSerie(this.laboratoireEntete.getLabSerie());
         this.bonEncaissementVente.setBonDevise(this.structureLog.getStrdevise());
         this.bonEncaissementVente.setBonTotTtc(this.laboratoireEntete.getLabTotTaxePatient() + this.laboratoireEntete.getLabTotPatient());
         this.bonEncaissementVente.setBonAPayer(var1 * -1.0D);
         this.bonEncaissementVente.setBonActif(0);
         this.bonEncaissementVente.setBonNum(var9);
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
         this.bonEncaissementVente.setBonLettreGarantie(this.numLettreGarantie);
         this.bonEncaissementVenteDao.insert(this.bonEncaissementVente, var4);
         Espion var8 = new Espion();
         var8.setUsers(this.usersLog);
         var8.setEsptype(0);
         var8.setEspdtecreat(new Date());
         var8.setEspaction("Annulation laboratoire N° " + this.laboratoireEntete.getLabNum() + " pour " + this.laboratoireEntete.getLabMotifAnnule());
         this.espionDao.mAJEspion(var8, var4);
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
      if ((this.var_inputCaisse == null || this.var_inputCaisse.isEmpty()) && this.listCaisses.size() != 0) {
         for(int var6 = 0; var6 < this.listCaisses.size(); ++var6) {
            if (((UsersChrono)this.listCaisses.get(var6)).getUsrchrModeCaisse() <= 1) {
               this.var_inputCaisse = ((UsersChrono)this.listCaisses.get(var6)).getUsrchrCodeCaisse() + ":" + ((UsersChrono)this.listCaisses.get(var6)).getUsrchrLib();
               break;
            }
         }
      }

      String var13 = this.calculChrono.numComposeCaisse(new Date(), 61, "0", this.laboratoireEntete.getLabSerie(), this.var_inputCaisse, var4);
      if (var13 != null && !var13.isEmpty()) {
         this.reglements = new Reglements();
         this.reglements.setRglOperation("03");
         this.reglements.setRglActivite(this.laboratoireEntete.getLabActivite());
         this.reglements.setRglBudget("");
         this.reglements.setRglBanqueTireur("");
         this.reglements.setRglBon("");
         this.reglements.setRglCategorie(30);
         if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
            String[] var7 = this.var_inputCaisse.split(":");
            this.reglements.setRglCodeCaiss(var7[0]);
            this.reglements.setRglLibCaiss(var7[1]);
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
         this.reglements.setRglDocument(this.laboratoireEntete.getLabNum());
         this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
         this.reglements.setRglIdBon(0L);
         this.reglements.setRglIdDocument(this.laboratoireEntete.getLabId());
         this.reglements.setRglIdTiers(this.laboratoireEntete.getPatients().getPatId());
         this.reglements.setRglDepotTiers(0);
         this.reglements.setRglLibelle("");
         this.reglements.setRglMode("0");
         this.reglements.setRglModele("");
         this.reglements.setRglNatureDoc(74);
         this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
         this.reglements.setRglNomTiers(this.laboratoireEntete.getLabNomPatient());
         this.reglements.setRglIdContact(0L);
         this.reglements.setRglNomContact("");
         this.reglements.setRglNum(var13);
         this.reglements.setRglNumChqBdx("");
         this.reglements.setRglObjet("Annulation Règlement Laboratoire N° " + this.laboratoireEntete.getLabNum());
         this.reglements.setRglParc("");
         this.reglements.setRglPdv("");
         this.reglements.setRglRecette(var1 * -1.0D);
         this.reglements.setRglTimbre(0.0D);
         this.reglements.setRglRegion("");
         this.reglements.setRglSecteur("");
         this.reglements.setRglSerie(this.laboratoireEntete.getLabSerie());
         this.reglements.setRglService(this.laboratoireEntete.getLabService());
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
         String var14 = "";
         if (this.reglements.getRglDateReg().getMonth() + 1 <= 9) {
            var14 = "0" + (this.reglements.getRglDateReg().getMonth() + 1);
         } else {
            var14 = "" + (this.reglements.getRglDateReg().getMonth() + 1);
         }

         String var8 = "" + (this.reglements.getRglDateReg().getYear() + 1900);
         this.reglements.setRglPeriode(var14 + ":" + var8);
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
         var12.setEspaction("Annulation laboratoire N° " + this.laboratoireEntete.getLabNum() + " pour " + this.laboratoireEntete.getLabMotifAnnule());
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
      if (this.laboratoireEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.laboratoireEntete.setLabEtat(0);
            this.laboratoireEntete.setLabDateAnnule((Date)null);
            this.laboratoireEntete.setLabMotifAnnule("");
            this.laboratoireEntete.setLabRegPatient(this.laboratoireEntete.getLabTotPatient());
            this.laboratoireEntete.setLabRegTiers(this.laboratoireEntete.getTotalTiers());
            this.laboratoireEntete.setLabSoldePatient(1);
            this.laboratoireEntete.setLabSoldeTiers(1);
            this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
            new ArrayList();
            List var3 = this.reglementsDao.reglementDocument(this.laboratoireEntete.getLabId(), this.nature, var1);
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
            var13.setEspaction("Réactivation laboratoire N° " + this.laboratoireEntete.getLabNum());
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
      if (this.laboratoireEntete != null) {
         this.nouveauService = "";
         this.nouveauMedecin = 0L;
         this.ancienMedecin = "";
         if (this.laboratoireEntete.getLabIdMedecin() != 0L) {
            new Users();
            Users var1 = this.usersDao.selectLeUserId(this.laboratoireEntete.getLabIdMedecin(), (Session)null);
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
      if (this.laboratoireEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            boolean var3 = false;
            boolean var4 = false;
            String var5 = this.laboratoireEntete.getLabLaboratoire();
            if (this.nouveauService != null && !this.nouveauService.isEmpty() && (this.laboratoireEntete.getLabLaboratoire() == null || this.laboratoireEntete.getLabLaboratoire().isEmpty() || !this.nouveauService.equals(this.laboratoireEntete.getLabLaboratoire()))) {
               var3 = true;
            }

            if (this.nouveauMedecin != 0L && this.nouveauMedecin != this.laboratoireEntete.getLabIdMedecin()) {
               var4 = true;
            }

            if (var3 || var4) {
               if (var3) {
                  this.laboratoireEntete.setLabLaboratoire(this.nouveauService);
               }

               if (var4) {
                  this.laboratoireEntete.setLabIdMedecin(this.nouveauMedecin);
               }

               this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
               if (var3) {
                  new ArrayList();
                  List var6 = this.reglementsDao.reglementDocument(this.laboratoireEntete.getLabId(), this.nature, var1);
                  if (var6.size() != 0) {
                     for(int var7 = 0; var7 < var6.size(); ++var7) {
                        this.reglements = (Reglements)var6.get(var7);
                        this.reglements.setRglService(this.nouveauService);
                        this.reglements = this.reglementsDao.modifierReg(this.reglements, var1);
                     }
                  }

                  LaboratoireReglementDao var17 = new LaboratoireReglementDao(this.baseLog, this.utilInitHibernate);
                  new ArrayList();
                  List var8 = var17.selectReglementByEnt(this.laboratoireEntete, var1);
                  if (var8.size() != 0) {
                     new LaboratoireReglement();

                     for(int var10 = 0; var10 < var8.size(); ++var10) {
                        LaboratoireReglement var9 = (LaboratoireReglement)var8.get(var10);
                        var9.setLabregService(this.nouveauService);
                        var17.modif(var9, var1);
                     }
                  }

                  Espion var20 = new Espion();
                  var20.setUsers(this.usersLog);
                  var20.setEsptype(0);
                  var20.setEspdtecreat(new Date());
                  var20.setEspaction("Chg service laboratoire (M.) N° " + this.laboratoireEntete.getLabNum() + " du " + this.utilDate.dateToStringSQLLight(this.laboratoireEntete.getLabDate()) + " du service " + var5 + " au service " + this.nouveauService);
                  this.espionDao.mAJEspion(var20, var1);
               }

               if (var4) {
                  String var16 = "";
                  new Users();
                  Users var18 = this.usersDao.selectLeUserId(this.nouveauMedecin, var1);
                  if (var18 != null) {
                     var16 = var18.getUsrPatronyme();
                  }

                  Espion var19 = new Espion();
                  var19.setUsers(this.usersLog);
                  var19.setEsptype(0);
                  var19.setEspdtecreat(new Date());
                  var19.setEspaction("Chg médecin laboratoire (M.) N° " + this.laboratoireEntete.getLabNum() + " du " + this.utilDate.dateToStringSQLLight(this.laboratoireEntete.getLabDate()) + " du médecin " + this.ancienMedecin + " au médecin " + var16);
                  this.espionDao.mAJEspion(var19, var1);
               }
            }

            var2.commit();
         } catch (HibernateException var14) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var14;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.showModalPanelChangerService = false;
   }

   public void changerServiceLaboratoire() {
      if (this.laboratoireLigne != null) {
         this.nouveauService = "";
         this.showModalPanelChangerServiceLaboratoire = true;
      }

   }

   public void annulerChangerServiceLaboratoire() {
      this.showModalPanelChangerServiceLaboratoire = false;
   }

   public void validerChangerServiceLaboratoire() throws HibernateException, NamingException {
      if (this.laboratoireLigne != null && this.nouveauService != null && !this.nouveauService.isEmpty() && !this.nouveauService.equals(this.laboratoireLigne.getLabligLaboratoire())) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.laboratoireLigne.getLabligLaboratoire();
            String var4 = this.laboratoireLigne.getLabligProduit();
            this.laboratoireLigne.setLabligLaboratoire(this.nouveauService);
            this.laboratoireLigne = this.laboratoireLigneDao.modif(this.laboratoireLigne, var1);
            LaboratoireReglementDao var5 = new LaboratoireReglementDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();
            List var6 = var5.selectReglementByEnt(this.laboratoireEntete, var1);
            long var7 = 0L;
            if (var6.size() != 0) {
               new LaboratoireReglement();

               for(int var10 = 0; var10 < var6.size(); ++var10) {
                  LaboratoireReglement var9 = (LaboratoireReglement)var6.get(var10);
                  if (var9.getLabregProduit() != null && !var9.getLabregProduit().isEmpty() && var9.getLabregProduit().equals(var4) && var9.getLabregLaboratoire() != null && !var9.getLabregLaboratoire().isEmpty() && var9.getLabregLaboratoire().equals(var3)) {
                     var9.setLabregLaboratoire(this.nouveauService);
                     var9 = var5.modif(var9, var1);
                     var7 = var9.getLabregIdRecu();
                  }
               }
            }

            if (var7 != 0L) {
               this.reglements = this.reglementsDao.selectById(var7, var1);
               if (this.reglements != null) {
                  this.reglements.setRglLibelle(this.nouveauService);
                  this.reglements.setRglObjet(this.nouveauService);
                  this.reglements.setRglPdv(this.nouveauService);
                  this.reglements = this.reglementsDao.modifierReg(this.reglements, var1);
               }
            }

            Espion var16 = new Espion();
            var16.setUsers(this.usersLog);
            var16.setEsptype(0);
            var16.setEspdtecreat(new Date());
            var16.setEspaction("Chg service laboratoire ligne (M.) N° " + this.laboratoireEntete.getLabNum() + " du " + this.utilDate.dateToStringSQLLight(this.laboratoireEntete.getLabDate()) + " du service " + var3 + " au service " + this.nouveauService);
            this.espionDao.mAJEspion(var16, var1);
            var2.commit();
         } catch (HibernateException var14) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var14;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.showModalPanelChangerServiceLaboratoire = false;
   }

   public void ajouterAntecedent() throws IOException {
      this.patientAnt = new PatientAnt();
      this.var_antecedent = "";
      this.var_actionAntecedent = 1;
      this.patientAnt.setPatantDate(this.laboratoireEntete.getLabDate());
      this.patientAnt.setPatantMedecin(this.laboratoireEntete.getLabMedecin());
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
            this.patientAnt.setPatantNumConsultGene(this.laboratoireEntete.getLabNum());
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

   public void ajouterActes() {
      this.produits = new Produits();
      this.laboratoireLigne = new LaboratoireLigne();
      this.var_lettre = "";
      this.var_aff_detail_prod = false;
      this.afficheButtActes = false;
      this.choixImputationLabo = false;
      this.mesImputationLabo.clear();
      this.ajouterSurAvoir = false;
      if (this.lesLaboratoire.size() != 0) {
         for(int var1 = 0; var1 < this.lesLaboratoire.size(); ++var1) {
            if (((LaboratoireLigne)this.lesLaboratoire.get(var1)).getLabligTotal() < 0.0D) {
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
      if (this.laboratoireLigne.getLabligProduit() != null && !this.laboratoireLigne.getLabligProduit().isEmpty()) {
         this.lesProduits.clear();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         if (this.laboratoireEntete.getLabLaboratoire() != null && !this.laboratoireEntete.getLabLaboratoire().isEmpty()) {
            new Service();
            String[] var3 = this.laboratoireEntete.getLabLaboratoire().split(":");
            Service var2 = this.serviceDao.chargerLeServiceCode(var3[0], var1);
            if (var2 == null) {
               this.lesProduits = this.produitsMedicDao.verifProduitsMedicaux(this.laboratoireLigne.getLabligProduit(), "1106", var1);
            } else {
               new ArrayList();
               List var4 = this.produitsServicesDao.verifProduitsMedicaux(this.laboratoireLigne.getLabligProduit(), "1106", var2, var1);
               if (var4.size() <= 0) {
                  this.lesProduits = this.produitsMedicDao.verifProduitsMedicaux(this.laboratoireLigne.getLabligProduit(), "1106", var1);
               } else {
                  String var5 = "0000";

                  for(int var6 = 0; var6 < var4.size(); ++var6) {
                     ProduitsServices var7 = (ProduitsServices)var4.get(var6);
                     var5 = var5 + "," + var7.getProduits().getProId();
                  }

                  var5 = "(" + var5 + ")";
                  this.lesProduits = this.produitsMedicDao.selectFindProduitSerMedical(this.laboratoireLigne.getLabligProduit(), (String)null, "1106", (String)null, (String)null, var5, 0, var1);
               }
            }
         } else {
            this.lesProduits = this.produitsMedicDao.verifProduitsMedicaux(this.laboratoireLigne.getLabligProduit(), "1106", var1);
         }

         this.utilInitHibernate.closeSession();
         if (this.lesProduits.size() == 1) {
            this.produits = (Produits)this.lesProduits.get(0);
            this.valideActes();
         } else if (this.lesProduits.size() > 1) {
            this.produits = new Produits();
            this.datamodelProduits.setWrappedData(this.lesProduits);
            this.showModalPanelProduits = true;
         } else {
            this.annuleActes();
         }
      }

   }

   public void selectionActes() throws HibernateException, NamingException {
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
         }

         this.var_lettre = "";
      }

   }

   public void valideActes() throws HibernateException, NamingException {
      if (this.produits == null) {
         this.selectionActes();
      }

      if (this.produits != null) {
         this.laboratoireLigne.setLabligProduit(this.produits.getProCode());
         this.laboratoireLigne.setLabligLibelle(this.produits.getProLibClient());
         this.laboratoireLigne.setLabligFamille(this.produits.getProVteCode() + ":" + this.produits.getProVteLib());
         this.mesImputationLabo.clear();
         this.choixImputationLabo = false;
         if (!this.optionMedical.getChoixLabo().equals("1")) {
            this.laboratoireLigne.setLabligLaboratoire(this.laboratoireEntete.getLabLaboratoire());
         } else {
            String var1 = "";
            if (this.produits.getProActivite() != null && !this.produits.getProActivite().isEmpty()) {
               this.choixImputationLabo = true;
               if (!this.produits.getProActivite().contains("#")) {
                  this.mesImputationLabo.add(new SelectItem(this.produits.getProActivite()));
               } else {
                  String[] var5 = this.produits.getProActivite().split("#");
                  int var3 = var5.length;

                  for(int var4 = 0; var4 < var3; ++var4) {
                     this.mesImputationLabo.add(new SelectItem(var5[var4]));
                  }
               }

               var1 = ((SelectItem)this.mesImputationLabo.get(0)).getValue().toString();
            } else {
               new ArrayList();
               List var2 = this.produitsServicesDao.verifProduitsMedicaux(this.laboratoireLigne.getLabligProduit(), "1106", (Service)null, (Session)null);
               if (var2.size() != 0) {
                  var1 = ((ProduitsServices)var2.get(0)).getProserCode() + ":" + ((ProduitsServices)var2.get(0)).getProserNomFr();
               }
            }

            this.laboratoireLigne.setLabligLaboratoire(var1);
         }

         this.validesActesSuite((Session)null);
      }

   }

   public void validesActesSuite(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         var2 = true;
      }

      this.calculPrix(var1);
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      this.var_aff_detail_prod = true;
      this.showModalPanelProduits = false;
   }

   public void calculPrix() throws HibernateException, NamingException {
      this.calculPrix((Session)null);
   }

   public void calculPrix(Session var1) throws HibernateException, NamingException {
      float var2 = 1.0F;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = this.laboratoireLigne.getLabligPu();
      double var11 = this.laboratoireLigne.getLabligPuCnamgs();
      double var13 = this.laboratoireLigne.getLabligPuAssurance();
      boolean var15 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         var15 = true;
      }

      this.produits = this.produitsMedicDao.chargeProduit(this.laboratoireLigne.getLabligProduit(), var1);
      if (this.produits != null) {
         this.laboratoireLigne.setLabligProduit(this.produits.getProCode());
         this.laboratoireLigne.setLabligLibelle(this.produits.getProLibClient());
         this.laboratoireLigne.setLabligLettre(this.produits.getProLettre());
         if (this.produits.getProLettre() != null && !this.produits.getProLettre().isEmpty()) {
            this.laboratoireLigne.setLabligLettre(this.produits.getProLettre());
         } else {
            this.laboratoireLigne.setLabligLettre("");
            this.laboratoireLigne.setLabligNb(0.0F);
            this.laboratoireLigne.setLabligNbCnamgs(0.0F);
         }

         if (this.laboratoireLigne.getLabligQte() == 0.0F) {
            this.laboratoireLigne.setLabligQte(1.0F);
         }

         this.laboratoireLigne.setLabligCodeTva(this.produits.getProVteTva());
         this.laboratoireLigne.setLabligTauxTva(0.0F);
         if (this.laboratoireLigne.getLabligCodeTva() != null && !this.laboratoireLigne.getLabligCodeTva().isEmpty()) {
            this.taxesMedical = this.taxesMedicalDao.selectTva(this.exercicesVentes.getExevteId(), this.laboratoireLigne.getLabligCodeTva(), var1);
            if (this.taxesMedical != null) {
               this.laboratoireLigne.setLabligTauxTva(this.taxesMedical.getTaxvteTaux());
            }
         }

         String var16 = this.laboratoireEntete.getLibelleFamille();
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
            this.laboratoireLigne.setLabligNb(this.produitsTarif.getProtarNb());
            this.laboratoireLigne.setLabligNbCnamgs(this.produitsTarif.getProtarNbCnamgs());
            this.laboratoireLigne.setLabligValeur(this.produitsTarif.getProtarValeur());
            this.laboratoireLigne.setLabligValeurCnamgs(this.produitsTarif.getProtarValeurCnamgs());
            if (var2 == 0.0F) {
               var2 = 1.0F;
               if (this.lesCategoriesList.size() != 0) {
                  for(var17 = 0; var17 < this.lesCategoriesList.size(); ++var17) {
                     if (((ObjetCategories)this.lesCategoriesList.get(var17)).getLibelle_FR().equals(this.laboratoireEntete.getLibelleEta())) {
                        var2 = ((ObjetCategories)this.lesCategoriesList.get(var17)).getCoef();
                        break;
                     }
                  }
               }
            }

            this.laboratoireLigne.setLabligCoef(var2);
            if (var9 != 0.0D) {
               var3 = var9;
            }

            this.laboratoireLigne.setLabligPu(var3);
            if (var11 != 0.0D) {
               var5 = var11;
            }

            this.laboratoireLigne.setLabligPuCnamgs(var5);
            if (var13 != 0.0D) {
               var7 = var13;
            }

            this.laboratoireLigne.setLabligPuAssurance(var7);
            if (var7 == 0.0D) {
               boolean var21 = false;

               for(int var18 = 0; var18 < this.lesMotifEntree.size(); ++var18) {
                  if (this.laboratoireEntete.getLabEntree() != null && !this.laboratoireEntete.getLabEntree().isEmpty()) {
                     String var19 = "";
                     if (this.laboratoireEntete.getLabEntree().contains(":")) {
                        String[] var20 = this.laboratoireEntete.getLabEntree().split(":");
                        var19 = var20[0];
                     } else {
                        var19 = this.laboratoireEntete.getLabEntree();
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

               if (this.laboratoireEntete.getLabFam() >= 1L && var21) {
                  this.patientPec = this.patientPecDao.trouverPatientsPec(this.laboratoireEntete.getLabFam(), 0, var1);
                  if (this.patientPec != null) {
                     this.conventionMedical = this.conventionMedicalDao.trouveConvention(this.patientPec.getTiers().getTieid(), this.laboratoireLigne.getLabligProduit(), var1);
                     if (this.conventionMedical != null) {
                        if (var16.equals("Société")) {
                           this.laboratoireLigne.setLabligPu(this.conventionMedical.getCvnValeur());
                           this.laboratoireLigne.setLabligPuAssurance(0.0D);
                        } else if (var16.equals("Assuré")) {
                           this.laboratoireLigne.setLabligPuAssurance(this.conventionMedical.getCvnValeur());
                           if (this.conventionMedical.getCvnValeurOrigine() != 0.0D) {
                              this.laboratoireLigne.setLabligPu(this.conventionMedical.getCvnValeurOrigine());
                           }
                        }
                     }
                  }
               } else if (this.laboratoireEntete.getLabFam() >= 1L && !var21) {
                  this.laboratoireLigne.setLabligPuAssurance(var7);
                  this.laboratoireLigne.setLabligPu(var3);
               }
            }
         } else {
            this.laboratoireLigne.setLabligLettre("");
            this.laboratoireLigne.setLabligNb(0.0F);
            this.laboratoireLigne.setLabligNbCnamgs(0.0F);
            this.laboratoireLigne.setLabligCoef(0.0F);
            this.laboratoireLigne.setLabligValeur(0.0D);
            this.laboratoireLigne.setLabligValeurCnamgs(0.0D);
            this.laboratoireLigne.setLabligPu(var9);
            this.laboratoireLigne.setLabligPuCnamgs(var11);
            this.laboratoireLigne.setLabligPuAssurance(var13);
            if (this.laboratoireLigne.getLabligQte() == 0.0F) {
               this.laboratoireLigne.setLabligQte(1.0F);
            }
         }
      } else {
         this.laboratoireLigne.setLabligLettre("");
         this.laboratoireLigne.setLabligNb(0.0F);
         this.laboratoireLigne.setLabligNbCnamgs(0.0F);
         this.laboratoireLigne.setLabligCoef(0.0F);
         this.laboratoireLigne.setLabligValeur(0.0D);
         this.laboratoireLigne.setLabligValeurCnamgs(0.0D);
         this.laboratoireLigne.setLabligPu(var9);
         this.laboratoireLigne.setLabligPuCnamgs(var11);
         this.laboratoireLigne.setLabligPuAssurance(var13);
         if (this.laboratoireLigne.getLabligQte() == 0.0F) {
            this.laboratoireLigne.setLabligQte(1.0F);
         }
      }

      if (this.var_pecCnamgs != 0.0F) {
         if (this.nomComplementaire != 0L) {
            this.avecCnamgsPriveComplementaire(var1);
         } else {
            this.avecCnamgsPrive(var1);
         }
      } else if (this.laboratoireEntete.getLabFam() != 0L && this.laboratoireEntete.getLabFam() != -1L) {
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
      if (this.laboratoireLigne.getLabligRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.laboratoireLigne.getLabligPu() * (double)this.laboratoireLigne.getLabligRemise() / 100.0D, this.structureLog.getStrdevise());
         this.laboratoireLigne.setLabligPuRem(this.laboratoireLigne.getLabligPu() - var2);
         this.laboratoireLigne.setLabligRabais(0.0D);
      } else {
         this.laboratoireLigne.setLabligPuRem(this.laboratoireLigne.getLabligPu());
      }

      this.laboratoireLigne.setLabligTotal(this.laboratoireLigne.getLabligPuRem() * (double)this.laboratoireLigne.getLabligQte());
      if (this.laboratoireLigne.getLabligTauxTva() != 0.0F) {
         var2 = this.laboratoireLigne.getLabligTotal() * (double)this.laboratoireLigne.getLabligTauxTva() / 100.0D;
         this.laboratoireLigne.setLabligTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.laboratoireLigne.setLabligTaxe(0.0D);
      }

      this.laboratoireLigne.setLabligNbCnamgs(0.0F);
      this.laboratoireLigne.setLabligValeurCnamgs(0.0D);
      this.laboratoireLigne.setLabligPuCnamgs(0.0D);
      this.laboratoireLigne.setLabligSocieteHt(0.0D);
      this.laboratoireLigne.setLabligSocieteTaxe(0.0D);
      this.laboratoireLigne.setLabligAssuranceHt(0.0D);
      this.laboratoireLigne.setLabligAssuranceTaxe(0.0D);
      this.laboratoireLigne.setLabligComplementaireHt(0.0D);
      this.laboratoireLigne.setLabligComplementaireTaxe(0.0D);
      this.laboratoireLigne.setLabligPatientHt(0.0D);
      this.laboratoireLigne.setLabligPatientTaxe(0.0D);
      this.laboratoireEntete.setLabIdEmployeur(0L);
      var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      float var8 = 0.0F;
      double var9;
      if (this.laboratoireEntete.getLabIdSociete() != 0L && this.laboratoireEntete.getLabFam() != 0L) {
         if (this.patientPec == null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.laboratoireEntete.getLabFam(), 0, var1);
         }

         if (this.patientPec != null) {
            var2 = this.laboratoireLigne.getLabligTotal() * (double)this.patientPec.getPatpecExamenss() / 100.0D;
            if (this.patientPec.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.laboratoireLigne.setLabligSocieteHt(var2);
            } else {
               this.laboratoireLigne.setLabligSocieteHt(var2 * (double)this.patientPec.getTiers().getTiecoefpvmedical());
               var8 = this.patientPec.getTiers().getTiecoefpvmedical();
            }

            if (this.laboratoireLigne.getLabligTauxTva() != 0.0F) {
               var9 = this.laboratoireLigne.getLabligSocieteHt() * (double)this.laboratoireLigne.getLabligTauxTva() / 100.0D;
               this.laboratoireLigne.setLabligSocieteTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      } else if (this.laboratoireEntete.getLabIdAssurance() != 0L && this.laboratoireEntete.getLabFam() != 0L) {
         if (this.patientPec == null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.laboratoireEntete.getLabFam(), 0, var1);
         }

         if (this.patientPec != null) {
            this.var_pecAssurance = true;
            this.laboratoireEntete.setLabIdEmployeur(this.patientPec.getPatpecIdEmployeur());
            if (this.laboratoireLigne.getLabligPuAssurance() == 0.0D) {
               this.laboratoireLigne.setLabligPuAssurance(this.laboratoireLigne.getLabligPu());
            }

            var4 = this.laboratoireLigne.getLabligPuAssurance() * (double)this.laboratoireLigne.getLabligQte() * (double)this.patientPec.getPatpecExamenss() / 100.0D;
            if (this.laboratoireLigne.getLabligRemise() != 0.0F) {
               var9 = this.utilNombre.myRoundDevise(var4 * (double)this.laboratoireLigne.getLabligRemise() / 100.0D, this.structureLog.getStrdevise());
               var4 -= var9;
            }

            if (this.patientPec.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.laboratoireLigne.setLabligAssuranceHt(var4);
            } else {
               this.laboratoireLigne.setLabligAssuranceHt(var4 * (double)this.patientPec.getTiers().getTiecoefpvmedical());
               var8 = this.patientPec.getTiers().getTiecoefpvmedical();
            }

            if (this.laboratoireLigne.getLabligTauxTva() != 0.0F) {
               var9 = this.laboratoireLigne.getLabligAssuranceHt() * (double)this.laboratoireLigne.getLabligTauxTva() / 100.0D;
               this.laboratoireLigne.setLabligAssuranceTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      }

      if (this.laboratoireEntete.getLabIdComplementaire() != 0L) {
         if (this.patientPecComplementaire == null) {
            this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.laboratoireEntete.getLabComplementaire(), 0, var1);
         }

         if (this.patientPecComplementaire != null) {
            var6 = this.laboratoireLigne.getLabligPu() * (double)this.laboratoireLigne.getLabligQte() * (double)this.patientPecComplementaire.getPatpecExamenss() / 100.0D;
            if (this.laboratoireLigne.getLabligRemise() != 0.0F) {
               var9 = this.utilNombre.myRoundDevise(var6 * (double)this.laboratoireLigne.getLabligRemise() / 100.0D, this.structureLog.getStrdevise());
               var6 -= var9;
            }

            if (this.patientPecComplementaire.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.laboratoireLigne.setLabligComplementaireHt(var6);
            } else {
               this.laboratoireLigne.setLabligComplementaireHt(var6 * (double)this.patientPecComplementaire.getTiers().getTiecoefpvmedical());
            }

            if (this.laboratoireLigne.getLabligTauxTva() != 0.0F) {
               var9 = this.laboratoireLigne.getLabligComplementaireHt() * (double)this.laboratoireLigne.getLabligTauxTva() / 100.0D;
               this.laboratoireLigne.setLabligComplementaireTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      }

      var9 = 0.0D;
      double var11;
      if (var8 != 0.0F && this.produits.getProMajoration() == 0 && this.optionMedical.getCoefMajoration().equals("2")) {
         if (this.laboratoireLigne.getLabligRemise() != 0.0F) {
            var11 = this.utilNombre.myRoundDevise(this.laboratoireLigne.getLabligPu() * (double)this.laboratoireLigne.getLabligRemise() / 100.0D, this.structureLog.getStrdevise());
            this.laboratoireLigne.setLabligPuRem((this.laboratoireLigne.getLabligPu() - var11) * (double)var8);
         } else {
            this.laboratoireLigne.setLabligPuRem(this.laboratoireLigne.getLabligPu() * (double)var8);
         }

         this.laboratoireLigne.setLabligTotal(this.laboratoireLigne.getLabligPuRem() * (double)this.laboratoireLigne.getLabligQte());
         if (this.laboratoireLigne.getLabligTauxTva() != 0.0F) {
            var11 = this.laboratoireLigne.getLabligTotal() * (double)this.laboratoireLigne.getLabligTauxTva() / 100.0D;
            this.laboratoireLigne.setLabligTaxe(this.utilNombre.myRoundDevise(var11, this.structureLog.getStrdevise()));
         } else {
            this.laboratoireLigne.setLabligTaxe(0.0D);
         }
      } else {
         var9 = this.laboratoireLigne.getLabligTotal() - (var2 + var4 + var6);
         this.laboratoireLigne.setLabligTotal(this.laboratoireLigne.getLabligSocieteHt() + this.laboratoireLigne.getLabligAssuranceHt() + this.laboratoireLigne.getLabligComplementaireHt() + var9);
      }

      var11 = this.laboratoireLigne.getLabligTotal() - (this.laboratoireLigne.getLabligSocieteHt() + this.laboratoireLigne.getLabligAssuranceHt() + this.laboratoireLigne.getLabligComplementaireHt());
      if (this.laboratoireLigne.getLabligRabais() != 0.0D) {
         this.laboratoireLigne.setLabligPatientHt(var11 - this.laboratoireLigne.getLabligRabais());
         this.laboratoireLigne.setLabligRemise(0.0F);
         if (this.laboratoireLigne.getLabligPatientHt() < 0.0D) {
            this.laboratoireLigne.setLabligPatientHt(var11);
            this.laboratoireLigne.setLabligRabais(0.0D);
         }
      } else {
         this.laboratoireLigne.setLabligPatientHt(var11);
      }

      double var13;
      if (this.laboratoireLigne.getLabligTauxTva() != 0.0F) {
         var13 = this.laboratoireLigne.getLabligPatientHt() * (double)this.laboratoireLigne.getLabligTauxTva() / 100.0D;
         this.laboratoireLigne.setLabligPatientTaxe(this.utilNombre.myRoundDevise(var13, this.structureLog.getStrdevise()));
      }

      if (var8 != 0.0F && this.produits.getProMajoration() == 0 && this.optionMedical.getCoefMajoration().equals("3")) {
         if (this.laboratoireLigne.getLabligRemise() != 0.0F) {
            var13 = this.utilNombre.myRoundDevise(this.laboratoireLigne.getLabligPu() * (double)this.laboratoireLigne.getLabligRemise() / 100.0D, this.structureLog.getStrdevise());
            this.laboratoireLigne.setLabligPuRem((this.laboratoireLigne.getLabligPu() - var13) * (double)var8);
         } else {
            this.laboratoireLigne.setLabligPuRem(this.laboratoireLigne.getLabligPu() * (double)var8);
         }

         this.laboratoireLigne.setLabligTotal(this.laboratoireLigne.getLabligPuRem() * (double)this.laboratoireLigne.getLabligQte());
         var13 = this.laboratoireLigne.getLabligAssuranceHt() + this.laboratoireLigne.getLabligComplementaireHt() + this.laboratoireLigne.getLabligSocieteHt() + this.laboratoireLigne.getLabligPatientHt();
         double var15 = this.laboratoireLigne.getLabligTotal() - var13;
         if (var15 != 0.0D) {
            if (var4 != 0.0D) {
               this.laboratoireLigne.setLabligAssuranceHt(this.laboratoireLigne.getLabligAssuranceHt() + var15);
            } else if (var2 != 0.0D) {
               this.laboratoireLigne.setLabligSocieteHt(this.laboratoireLigne.getLabligSocieteHt() + var15);
            }

            if (var6 != 0.0D) {
               this.laboratoireLigne.setLabligComplementaireHt(this.laboratoireLigne.getLabligComplementaireHt() + var15);
            }
         }
      }

   }

   public void sansCnamgsPrive(Session var1) {
      if (this.tauxCasSocial != 0.0F) {
         this.laboratoireLigne.setLabligRemise(this.tauxCasSocial);
      }

      double var2;
      if (this.laboratoireLigne.getLabligRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.laboratoireLigne.getLabligPu() * (double)this.laboratoireLigne.getLabligRemise() / 100.0D, this.structureLog.getStrdevise());
         this.laboratoireLigne.setLabligPuRem(this.laboratoireLigne.getLabligPu() - var2);
         this.laboratoireLigne.setLabligRabais(0.0D);
      } else {
         this.laboratoireLigne.setLabligPuRem(this.laboratoireLigne.getLabligPu());
      }

      this.laboratoireLigne.setLabligTotal(this.laboratoireLigne.getLabligPuRem() * (double)this.laboratoireLigne.getLabligQte());
      if (this.laboratoireLigne.getLabligTauxTva() != 0.0F) {
         var2 = this.laboratoireLigne.getLabligTotal() * (double)this.laboratoireLigne.getLabligTauxTva() / 100.0D;
         this.laboratoireLigne.setLabligTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.laboratoireLigne.setLabligTaxe(0.0D);
      }

      this.laboratoireLigne.setLabligNbCnamgs(0.0F);
      this.laboratoireLigne.setLabligValeurCnamgs(0.0D);
      this.laboratoireLigne.setLabligPuCnamgs(0.0D);
      this.laboratoireLigne.setLabligSocieteHt(0.0D);
      this.laboratoireLigne.setLabligSocieteTaxe(0.0D);
      this.laboratoireLigne.setLabligAssuranceHt(0.0D);
      this.laboratoireLigne.setLabligAssuranceTaxe(0.0D);
      this.laboratoireLigne.setLabligComplementaireHt(0.0D);
      this.laboratoireLigne.setLabligComplementaireTaxe(0.0D);
      this.laboratoireLigne.setLabligPatientHt(0.0D);
      this.laboratoireLigne.setLabligPatientTaxe(0.0D);
      this.laboratoireEntete.setLabIdEmployeur(0L);
      var2 = this.laboratoireLigne.getLabligTotal();
      if (this.laboratoireLigne.getLabligRabais() != 0.0D) {
         this.laboratoireLigne.setLabligPatientHt(var2 - this.laboratoireLigne.getLabligRabais());
         this.laboratoireLigne.setLabligRemise(0.0F);
         if (this.laboratoireLigne.getLabligPatientHt() < 0.0D) {
            this.laboratoireLigne.setLabligPatientHt(var2);
            this.laboratoireLigne.setLabligRabais(0.0D);
         }
      } else {
         this.laboratoireLigne.setLabligPatientHt(var2);
      }

      if (this.laboratoireLigne.getLabligTaxe() != 0.0D) {
         double var4 = this.laboratoireLigne.getLabligPatientHt() * (double)this.laboratoireLigne.getLabligTauxTva() / 100.0D;
         this.laboratoireLigne.setLabligPatientTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
      } else {
         this.laboratoireLigne.setLabligPatientTaxe(0.0D);
      }

   }

   public void avecCnamgsPrive(Session var1) throws HibernateException, NamingException {
      if (this.laboratoireLigne.getLabligPuCnamgs() > this.laboratoireLigne.getLabligPu()) {
         this.laboratoireLigne.setLabligPu(this.laboratoireLigne.getLabligPuCnamgs());
      }

      double var2;
      double var4;
      if (this.laboratoireLigne.getLabligRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.laboratoireLigne.getLabligPu() * (double)this.laboratoireLigne.getLabligRemise() / 100.0D, this.structureLog.getStrdevise());
         this.laboratoireLigne.setLabligPuRem(this.laboratoireLigne.getLabligPu() - var2);
         var4 = this.utilNombre.myRoundDevise(this.laboratoireLigne.getLabligPuCnamgs() * (double)this.laboratoireLigne.getLabligRemise() / 100.0D, this.structureLog.getStrdevise());
         this.laboratoireLigne.setLabligPuCnamgs(this.laboratoireLigne.getLabligPuCnamgs() - var4);
         this.laboratoireLigne.setLabligRabais(0.0D);
      } else {
         this.laboratoireLigne.setLabligPuRem(this.laboratoireLigne.getLabligPu());
      }

      this.laboratoireLigne.setLabligTotal(this.laboratoireLigne.getLabligPuRem() * (double)this.laboratoireLigne.getLabligQte());
      if (this.laboratoireLigne.getLabligTauxTva() != 0.0F) {
         var2 = this.laboratoireLigne.getLabligTotal() * (double)this.laboratoireLigne.getLabligTauxTva() / 100.0D;
         this.laboratoireLigne.setLabligTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.laboratoireLigne.setLabligTaxe(0.0D);
      }

      this.laboratoireLigne.setLabligPuAssurance(0.0D);
      this.laboratoireLigne.setLabligSocieteHt(0.0D);
      this.laboratoireLigne.setLabligSocieteTaxe(0.0D);
      this.laboratoireLigne.setLabligAssuranceHt(0.0D);
      this.laboratoireLigne.setLabligAssuranceTaxe(0.0D);
      this.laboratoireLigne.setLabligComplementaireHt(0.0D);
      this.laboratoireLigne.setLabligComplementaireTaxe(0.0D);
      this.laboratoireLigne.setLabligPatientHt(0.0D);
      this.laboratoireLigne.setLabligPatientTaxe(0.0D);
      this.laboratoireEntete.setLabIdEmployeur(0L);
      this.laboratoireLigne.setLabligAssuranceHt(this.laboratoireLigne.getLabligPuCnamgs() * (double)this.laboratoireLigne.getLabligQte() * (double)this.var_pecCnamgs / 100.0D);
      if (this.laboratoireLigne.getLabligTauxTva() != 0.0F) {
         var2 = this.laboratoireLigne.getLabligAssuranceHt() * (double)this.laboratoireLigne.getLabligTauxTva() / 100.0D;
         this.laboratoireLigne.setLabligAssuranceTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      }

      var2 = this.laboratoireLigne.getLabligTotal() - this.laboratoireLigne.getLabligAssuranceHt();
      if (this.laboratoireLigne.getLabligRabais() != 0.0D) {
         this.laboratoireLigne.setLabligPatientHt(var2 - this.laboratoireLigne.getLabligRabais());
         this.laboratoireLigne.setLabligRemise(0.0F);
         if (this.laboratoireLigne.getLabligPatientHt() < 0.0D) {
            this.laboratoireLigne.setLabligPatientHt(var2);
            this.laboratoireLigne.setLabligRabais(0.0D);
         }
      } else {
         this.laboratoireLigne.setLabligPatientHt(var2);
      }

      if (this.laboratoireLigne.getLabligTauxTva() != 0.0F) {
         var4 = this.laboratoireLigne.getLabligPatientHt() * (double)this.laboratoireLigne.getLabligTauxTva() / 100.0D;
         this.laboratoireLigne.setLabligPatientTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
      }

   }

   public void avecCnamgsPriveComplementaire(Session var1) throws HibernateException, NamingException {
      if (this.laboratoireLigne.getLabligPuCnamgs() > this.laboratoireLigne.getLabligPu()) {
         this.laboratoireLigne.setLabligPu(this.laboratoireLigne.getLabligPuCnamgs());
      }

      double var2;
      double var4;
      if (this.laboratoireLigne.getLabligRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.laboratoireLigne.getLabligPu() * (double)this.laboratoireLigne.getLabligRemise() / 100.0D, this.structureLog.getStrdevise());
         this.laboratoireLigne.setLabligPuRem(this.laboratoireLigne.getLabligPu() - var2);
         var4 = this.utilNombre.myRoundDevise(this.laboratoireLigne.getLabligPuCnamgs() * (double)this.laboratoireLigne.getLabligRemise() / 100.0D, this.structureLog.getStrdevise());
         this.laboratoireLigne.setLabligPuCnamgs(this.laboratoireLigne.getLabligPuCnamgs() - var4);
         this.laboratoireLigne.setLabligRabais(0.0D);
      } else {
         this.laboratoireLigne.setLabligPuRem(this.laboratoireLigne.getLabligPu());
      }

      this.laboratoireLigne.setLabligTotal(this.laboratoireLigne.getLabligPuRem() * (double)this.laboratoireLigne.getLabligQte());
      if (this.laboratoireLigne.getLabligTauxTva() != 0.0F) {
         var2 = this.laboratoireLigne.getLabligTotal() * (double)this.laboratoireLigne.getLabligTauxTva() / 100.0D;
         this.laboratoireLigne.setLabligTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.laboratoireLigne.setLabligTaxe(0.0D);
      }

      this.laboratoireLigne.setLabligPuAssurance(0.0D);
      this.laboratoireLigne.setLabligSocieteHt(0.0D);
      this.laboratoireLigne.setLabligSocieteTaxe(0.0D);
      this.laboratoireLigne.setLabligAssuranceHt(0.0D);
      this.laboratoireLigne.setLabligAssuranceTaxe(0.0D);
      this.laboratoireLigne.setLabligComplementaireHt(0.0D);
      this.laboratoireLigne.setLabligComplementaireTaxe(0.0D);
      this.laboratoireLigne.setLabligPatientHt(0.0D);
      this.laboratoireLigne.setLabligPatientTaxe(0.0D);
      this.laboratoireEntete.setLabIdEmployeur(0L);
      var2 = 0.0D;
      this.laboratoireLigne.setLabligAssuranceHt(this.laboratoireLigne.getLabligPuCnamgs() * (double)this.laboratoireLigne.getLabligQte() * (double)this.var_pecCnamgs / 100.0D);
      if (this.laboratoireLigne.getLabligTauxTva() != 0.0F) {
         var4 = this.laboratoireLigne.getLabligAssuranceHt() * (double)this.laboratoireLigne.getLabligTauxTva() / 100.0D;
         this.laboratoireLigne.setLabligAssuranceTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
      }

      this.laboratoireEntete.setLabComplementaire(this.nomComplementaire);
      if (this.laboratoireEntete.getLabComplementaire() != 0L) {
         if (this.patientPecComplementaire == null) {
            this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.laboratoireEntete.getLabComplementaire(), 0, var1);
         }

         if (this.patientPecComplementaire != null) {
            this.laboratoireEntete.setLabIdComplementaire(this.patientPecComplementaire.getTiers().getTieid());
            var2 = this.laboratoireLigne.getLabligTotal() - this.laboratoireLigne.getLabligAssuranceHt();
            this.laboratoireLigne.setLabligComplementaireHt(var2);
            if (this.laboratoireLigne.getLabligTauxTva() != 0.0F) {
               var4 = this.laboratoireLigne.getLabligComplementaireHt() * (double)this.laboratoireLigne.getLabligTauxTva() / 100.0D;
               this.laboratoireLigne.setLabligComplementaireTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
            }
         }
      }

      var4 = this.laboratoireLigne.getLabligTotal() - this.laboratoireLigne.getLabligAssuranceHt() - this.laboratoireLigne.getLabligComplementaireHt();
      if (this.laboratoireLigne.getLabligRabais() != 0.0D) {
         this.laboratoireLigne.setLabligPatientHt(var4 - this.laboratoireLigne.getLabligRabais());
         this.laboratoireLigne.setLabligRemise(0.0F);
         if (this.laboratoireLigne.getLabligPatientHt() < 0.0D) {
            this.laboratoireLigne.setLabligPatientHt(var4);
            this.laboratoireLigne.setLabligRabais(0.0D);
         }
      } else {
         this.laboratoireLigne.setLabligPatientHt(var4);
      }

      if (this.laboratoireLigne.getLabligTauxTva() != 0.0F) {
         double var6 = this.laboratoireLigne.getLabligPatientHt() * (double)this.laboratoireLigne.getLabligTauxTva() / 100.0D;
         this.laboratoireLigne.setLabligPatientTaxe(this.utilNombre.myRoundDevise(var6, this.structureLog.getStrdevise()));
      }

   }

   public void selectionActeListe() throws HibernateException, NamingException {
      this.var_aff_detail_prod = false;
      this.var_lettre = "";
      if (this.dataModelLaboratoire.isRowAvailable()) {
         this.laboratoireLigne = (LaboratoireLigne)this.dataModelLaboratoire.getRowData();
         if (this.laboratoireLigne.getLabligLettre() != null && !this.laboratoireLigne.getLabligLettre().isEmpty()) {
            this.lettreMedical = this.lettreMedicalDao.selectLettre(this.exercicesVentes.getExevteId(), this.laboratoireLigne.getLabligLettre(), (Session)null);
            if (this.lettreMedical != null) {
               this.var_lettre = this.laboratoireLigne.getLabligLettre() + ":" + this.lettreMedical.getLetLibelleFr();
            }
         }

         this.mesImputationLabo.clear();
         this.choixImputationLabo = false;
         this.produits = this.produitsMedicDao.chargeProduit(this.laboratoireLigne.getLabligProduit(), (Session)null);
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

         this.var_aff_detail_prod = true;
         this.afficheButtActes = true;
      }

   }

   public void annuleActes() {
      this.produits = new Produits();
      this.laboratoireLigne = new LaboratoireLigne();
      this.var_lettre = "";
      this.var_aff_detail_prod = false;
      this.afficheButtActes = false;
      this.showModalPanelProduits = false;
   }

   public void supprimerActe() throws HibernateException, NamingException {
      if (this.laboratoireLigne != null) {
         this.laboratoireLigneDao.delete(this.laboratoireLigne);
         this.lesLaboratoire.remove(this.laboratoireLigne);
         this.dataModelLaboratoire.setWrappedData(this.lesLaboratoire);
         this.calculTotaux();
         this.laboratoireEnteteDao.modif(this.laboratoireEntete);
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
      this.calculeTarif();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
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

      this.laboratoireLigne.setLabligProduit(this.produits.getProCode());
      this.laboratoireLigne.setLabligLibelle(this.produits.getProLibClient());
      this.laboratoireLigne.setLabligFamille(this.produits.getProVteCode() + ":" + this.produits.getProVteLib());
      this.validesActesSuite((Session)null);
   }

   public void detailActe() {
      this.showModalPanelDetailProduits = true;
   }

   public void fermerDetailActe() {
      this.showModalPanelDetailProduits = false;
   }

   public void fermerDetailProduit() {
      this.showModalPanelDetailProduits = false;
   }

   public void saveActe() throws HibernateException, NamingException, ParseException {
      if (this.laboratoireLigne.getLabligQte() != 0.0F) {
         if (this.laboratoireEntete.getLabId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.tarifPatient(var1);
            this.calculPrix(var1);
            if (this.laboratoireLigne.getLabligId() == 0L) {
               this.laboratoireLigne.setLaboratoireEntete(this.laboratoireEntete);
               this.laboratoireLigne = this.laboratoireLigneDao.insert(this.laboratoireLigne, var1);
               this.lesLaboratoire.add(this.laboratoireLigne);
               this.dataModelLaboratoire.setWrappedData(this.lesLaboratoire);
            } else {
               this.laboratoireLigne = this.laboratoireLigneDao.modif(this.laboratoireLigne, var1);
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.tarifPatient(var1);
         if (this.laboratoireEntete.getLabId() != 0L) {
            this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
            if (this.lesLaboratoire.size() != 0) {
               for(int var3 = 0; var3 < this.lesLaboratoire.size(); ++var3) {
                  this.laboratoireLigne = (LaboratoireLigne)this.lesLaboratoire.get(var3);
                  this.calculPrix(var1);
                  this.laboratoireLigne = this.laboratoireLigneDao.modif(this.laboratoireLigne, var1);
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
      this.laboratoireEntete.setLabFam(this.nomFamille);
      this.laboratoireEntete.setLabComplementaire(this.nomComplementaire);
      if (this.nomFamille >= 1L) {
         this.var_pecCnamgs = 0.0F;
         this.laboratoireEntete.setLabIdSociete(0L);
         this.laboratoireEntete.setLabIdAssurance(0L);
         this.laboratoireEntete.setLabIdComplementaire(0L);
         this.laboratoireEntete.setLabNomSociete("");
         this.laboratoireEntete.setLabNomAssurance("");
         this.laboratoireEntete.setLabNomComplemtaire("");
         this.laboratoireEntete.setLabIdEmployeur(0L);
         this.laboratoireEntete.setLabMatricule("");
         this.laboratoireEntete.setLabContratAssurance("");
         this.laboratoireEntete.setLabContratComplementaire("");
         if (this.patientPec == null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.laboratoireEntete.getLabFam(), 0, var1);
         }

         if (this.patientPec != null) {
            if (this.patientPec.getPatpecType() != null && !this.patientPec.getPatpecType().isEmpty()) {
               if (!this.patientPec.getPatpecType().equals("Assurance") && !this.patientPec.getPatpecType().equals("IPM") && !this.patientPec.getPatpecType().equals("Programme Médical")) {
                  this.laboratoireEntete.setLabIdSociete(this.patientPec.getTiers().getTieid());
                  this.laboratoireEntete.setLabNomSociete(this.patientPec.getTiers().getTieraisonsocialenom());
                  this.laboratoireEntete.setLabMatricule(this.patientPec.getPatpecMatricule());
               } else {
                  this.var_pecAssurance = true;
                  this.laboratoireEntete.setLabIdAssurance(this.patientPec.getTiers().getTieid());
                  this.laboratoireEntete.setLabNomAssurance(this.patientPec.getTiers().getTieraisonsocialenom());
                  this.laboratoireEntete.setLabIdEmployeur(this.patientPec.getPatpecIdEmployeur());
                  this.laboratoireEntete.setLabContratAssurance(this.patientPec.getPatpecNumContrat());
               }
            }
         } else {
            this.laboratoireEntete.setLabFam(0L);
         }

         if (this.nomComplementaire >= 1L) {
            if (this.patientPecComplementaire == null) {
               this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.nomComplementaire, 0, var1);
            }

            if (this.patientPecComplementaire != null) {
               if (this.patientPecComplementaire.getPatpecType() != null && !this.patientPecComplementaire.getPatpecType().isEmpty() && (this.patientPecComplementaire.getPatpecType().equals("Mutuelle") || this.patientPecComplementaire.getPatpecType().equals("Complémentaire"))) {
                  this.laboratoireEntete.setLabIdComplementaire(this.patientPecComplementaire.getTiers().getTieid());
                  this.laboratoireEntete.setLabNomComplemtaire(this.patientPecComplementaire.getTiers().getTieraisonsocialenom());
                  this.laboratoireEntete.setLabContratComplementaire(this.patientPecComplementaire.getPatpecNumContrat());
               }
            } else {
               this.laboratoireEntete.setLabComplementaire(0L);
            }
         }
      } else if (this.nomFamille <= 0L) {
         this.laboratoireEntete.setLabComplementaire(0L);
         this.laboratoireEntete.setLabIdSociete(0L);
         this.laboratoireEntete.setLabIdAssurance(0L);
         this.laboratoireEntete.setLabIdComplementaire(0L);
         this.laboratoireEntete.setLabNomSociete("");
         this.laboratoireEntete.setLabNomAssurance("");
         this.laboratoireEntete.setLabNomComplemtaire("");
         this.laboratoireEntete.setLabIdEmployeur(0L);
         this.laboratoireEntete.setLabMatricule("");
         this.laboratoireEntete.setLabContratAssurance("");
         this.laboratoireEntete.setLabContratComplementaire("");
      }

   }

   public void avoirLigne() throws HibernateException, NamingException, ParseException {
      if (this.laboratoireLigne != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            LaboratoireLigne var3 = new LaboratoireLigne();
            var3.setLaboratoireEntete(this.laboratoireEntete);
            var3.setLabligAppareil(this.laboratoireLigne.getLabligAppareil());
            var3.setLabligAssuranceHt(this.laboratoireLigne.getLabligAssuranceHt() * -1.0D);
            var3.setLabligAssuranceTaxe(this.laboratoireLigne.getLabligAssuranceTaxe() * -1.0D);
            var3.setLabligCodeTva(this.laboratoireLigne.getLabligCodeTva());
            var3.setLabligCoef(this.laboratoireLigne.getLabligCoef());
            var3.setLabligCommentaire(this.laboratoireLigne.getLabligCommentaire());
            var3.setLabligComplementaireHt(this.laboratoireLigne.getLabligComplementaireHt() * -1.0D);
            var3.setLabligComplementaireTaxe(this.laboratoireLigne.getLabligComplementaireTaxe() * -1.0D);
            var3.setLabligDateRealisee(this.laboratoireLigne.getLabligDateRealisee());
            var3.setLabligEtat(this.laboratoireLigne.getLabligEtat());
            var3.setLabligFamille(this.laboratoireLigne.getLabligFamille());
            var3.setLabligLaboratoire(this.laboratoireLigne.getLabligLaboratoire());
            var3.setLabligLettre(this.laboratoireLigne.getLabligLettre());
            var3.setLabligLibelle(this.laboratoireLigne.getLabligLibelle());
            var3.setLabligNb(this.laboratoireLigne.getLabligNb());
            var3.setLabligNbCnamgs(this.laboratoireLigne.getLabligNbCnamgs());
            var3.setLabligPatientHt(this.laboratoireLigne.getLabligPatientHt() * -1.0D);
            var3.setLabligPatientTaxe(this.laboratoireLigne.getLabligPatientTaxe() * -1.0D);
            var3.setLabligProduit(this.laboratoireLigne.getLabligProduit());
            var3.setLabligPu(this.laboratoireLigne.getLabligPu());
            var3.setLabligPuAssurance(this.laboratoireLigne.getLabligPuAssurance());
            var3.setLabligPuCnamgs(this.laboratoireLigne.getLabligPuCnamgs());
            var3.setLabligPuRem(this.laboratoireLigne.getLabligPuRem());
            var3.setLabligQte(this.laboratoireLigne.getLabligQte() * -1.0F);
            var3.setLabligRegPatient(0.0D);
            var3.setLabligRegTiers(0.0D);
            var3.setLabligRemise(this.laboratoireLigne.getLabligRemise());
            var3.setLabligSocieteHt(this.laboratoireLigne.getLabligSocieteHt() * -1.0D);
            var3.setLabligSocieteTaxe(this.laboratoireLigne.getLabligSocieteTaxe() * -1.0D);
            var3.setLabligTauxTva(this.laboratoireLigne.getLabligTauxTva());
            var3.setLabligTaxe(this.laboratoireLigne.getLabligTaxe() * -1.0D);
            var3.setLabligTotal(this.laboratoireLigne.getLabligTotal() * -1.0D);
            var3.setLabligValeur(this.laboratoireLigne.getLabligValeur());
            var3.setLabligValeurCnamgs(this.laboratoireLigne.getLabligValeurCnamgs());
            this.laboratoireLigne = new LaboratoireLigne();
            this.laboratoireLigne = var3;
            this.laboratoireLigne = this.laboratoireLigneDao.insert(this.laboratoireLigne, var1);
            this.lesLaboratoire.add(this.laboratoireLigne);
            this.dataModelLaboratoire.setWrappedData(this.lesLaboratoire);
            this.calculTotaux();
            this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
            double var4 = this.laboratoireLigne.getLabligPatientHt() + this.laboratoireLigne.getLabligPatientTaxe();
            if (var4 != 0.0D) {
               boolean var6 = false;
               if (this.usersChrono.getUsrchrValidation() == 4) {
                  if (this.usersLog.getUsrFactureCaisse() == 1) {
                     var6 = this.majBonencaissementAnnulation(Math.abs(var4), this.laboratoireEntete.getLabDate(), var1);
                  } else if (this.usersLog.getUsrFactureCaisse() == 2) {
                     var6 = this.majReglementAnnulation(Math.abs(var4), this.laboratoireEntete.getLabDate(), var1);
                  } else if (this.usersLog.getUsrFactureCaisse() == 3) {
                     var6 = this.majBonencaissementAnnulation(Math.abs(var4), this.laboratoireEntete.getLabDate(), var1);
                  }
               }

               if (!var6) {
                  this.laboratoireLigneDao.delete(this.laboratoireLigne, var1);
                  this.lesLaboratoire.remove(this.laboratoireLigne);
                  this.dataModelLaboratoire.setWrappedData(this.lesLaboratoire);
                  this.calculTotaux();
                  this.laboratoireEntete = this.laboratoireEnteteDao.selectById(this.laboratoireEntete.getLabId(), var1);
                  if (this.laboratoireEntete != null) {
                     this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
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
      if (this.laboratoireEntete != null) {
         this.tarifPatient((Session)null);
         if (this.laboratoireEntete.getLabIdSociete() != 0L) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.patients, this.laboratoireEntete.getLabIdSociete(), (Session)null);
            if (this.patientPec != null) {
               this.showModalpanelPec = true;
            }
         } else if (this.laboratoireEntete.getLabIdAssurance() != 0L) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.patients, this.laboratoireEntete.getLabIdAssurance(), (Session)null);
            if (this.patientPec != null) {
               if (this.laboratoireEntete.getLabIdComplementaire() != 0L) {
                  this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.patients, this.laboratoireEntete.getLabIdComplementaire(), (Session)null);
               }

               this.showModalpanelPec = true;
            }
         }
      }

   }

   public void fermerConsulterTarif() {
      this.showModalpanelPec = false;
   }

   public void payeDocumentBonEncaissement() throws HibernateException, NamingException {
      if (this.laboratoireEntete != null) {
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
         if (this.var_tot_bon_encaissement > this.laboratoireEntete.getLabTotTaxePatient() + this.laboratoireEntete.getLabTotPatient()) {
            this.laboratoireEntete.setLabTypeReg(4);
            this.var_verouxModReg = true;
            this.var_affichMontant = false;
            this.var_netAPayer = this.laboratoireEntete.getLabTotTaxePatient() + this.laboratoireEntete.getLabTotPatient() - this.var_tot_bon_encaissement;
            this.montantElmTotBonEnc = this.var_netAPayer;
            this.verifBonEncaissement();
         } else {
            if (this.laboratoireEntete.getLabTypeReg() == 5) {
               this.montantElmTotBonEnc = this.var_tot_bon_encaissement;
               if (this.laboratoireEntete.getLabEtat() == 1) {
                  this.var_verouxModReg = true;
               } else {
                  this.var_verouxModReg = false;
               }

               this.var_netAPayer = this.laboratoireEntete.getLabTotTaxePatient() + this.laboratoireEntete.getLabTotPatient() - this.var_tot_bon_encaissement;
               this.montantElmTotBonEnc = this.var_netAPayer;
               this.var_affiche_valide = true;
            } else {
               this.laboratoireEntete.setLabTypeReg(0);
               this.var_verouxModReg = false;
               this.var_netAPayer = this.laboratoireEntete.getLabTotTaxePatient() + this.laboratoireEntete.getLabTotPatient() - this.var_tot_bon_encaissement;
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
      if (this.montantElmTotBonEnc <= this.laboratoireEntete.getLabTotTaxePatient() + this.laboratoireEntete.getLabTotPatient() - this.var_tot_bon_encaissement) {
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
      }

   }

   public void calculeCaisseDisponibleBencaissement() throws HibernateException, NamingException {
      this.mesCaissesSeriesItems.clear();
      if (this.listCaisses.size() != 0) {
         for(int var1 = 0; var1 < this.listCaisses.size(); ++var1) {
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 60 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.laboratoireEntete.getLabSerie())) {
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
      if (this.laboratoireEntete.getLabTypeReg() != 4 && this.laboratoireEntete.getLabTypeReg() != 5) {
         this.montantElmTotBonEnc = this.var_netAPayer;
         this.var_affichMontant = true;
      } else {
         this.var_affichMontant = false;
      }

   }

   public void miseajourPaye() throws HibernateException, NamingException {
      if (this.var_tot_bon_encaissement <= this.laboratoireEntete.getLabTotTaxePatient() + this.laboratoireEntete.getLabTotPatient()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.laboratoireEntete.getLabTypeReg() == 4) {
               if (this.laboratoireEntete.getLabNumPieceTiers() == null || this.laboratoireEntete.getLabNumPieceTiers().isEmpty()) {
                  this.laboratoireEntete.setLabNumPieceTiers("Non renseignée");
               }

               this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
            }

            String var3 = this.calculChrono.numCompose(new Date(), 79, this.laboratoireEntete.getLabSerie(), var1);
            if (var3 != null && !var3.isEmpty()) {
               ArrayList var4 = new ArrayList();
               int var7;
               if (this.lesLaboratoire.size() != 0) {
                  for(int var5 = 0; var5 < this.lesLaboratoire.size(); ++var5) {
                     if (((LaboratoireLigne)this.lesLaboratoire.get(var5)).getLabligLaboratoire() != null && !((LaboratoireLigne)this.lesLaboratoire.get(var5)).getLabligLaboratoire().isEmpty()) {
                        boolean var6 = false;

                        for(var7 = 0; var7 < var4.size(); ++var7) {
                           if (((String)var4.get(var7)).toString() != null && !((String)var4.get(var7)).toString().isEmpty() && ((LaboratoireLigne)this.lesLaboratoire.get(var5)).getLabligLaboratoire().equals(((String)var4.get(var7)).toString())) {
                              var6 = true;
                              break;
                           }
                        }

                        if (!var6) {
                           var4.add(((LaboratoireLigne)this.lesLaboratoire.get(var5)).getLabligLaboratoire());
                        }
                     }
                  }
               }

               var4.add("");
               double var20 = this.montantElmTotBonEnc;

               for(var7 = 0; var7 < var4.size(); ++var7) {
                  String var8 = ((String)var4.get(var7)).toString();
                  double var9 = 0.0D;
                  double var11 = 0.0D;

                  for(int var13 = 0; var13 < this.lesLaboratoire.size(); ++var13) {
                     if (((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligLaboratoire() != null && !((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligLaboratoire().isEmpty() && ((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligLaboratoire().equals(var8)) {
                        if (((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligPatientHt() + ((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligPatientTaxe() - ((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligRegPatient() <= var20) {
                           var9 += ((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligPatientHt() + ((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligPatientTaxe() - ((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligRegPatient();
                           var11 = ((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligPatientHt() + ((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligPatientTaxe() - ((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligRegPatient();
                        } else {
                           var9 += var20;
                           var11 = var20;
                        }

                        var20 -= var11;
                        if (var20 < 0.0D) {
                           var20 = 0.0D;
                        }
                     } else if ((((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligLaboratoire() == null || ((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligLaboratoire().isEmpty()) && (var8 == null || var8.isEmpty())) {
                        if (((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligPatientHt() + ((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligPatientTaxe() - ((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligRegPatient() <= var20) {
                           var9 += ((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligPatientHt() + ((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligPatientTaxe() - ((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligRegPatient();
                           var11 = ((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligPatientHt() + ((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligPatientTaxe() - ((LaboratoireLigne)this.lesLaboratoire.get(var13)).getLabligRegPatient();
                        } else {
                           var9 += var20;
                           var11 = var20;
                        }

                        var20 -= var11;
                        if (var20 < 0.0D) {
                           var20 = 0.0D;
                        }
                     }
                  }

                  if (var9 != 0.0D) {
                     this.bonEncaissementVente = new BonEncaissementVente();
                     String[] var21;
                     if (this.var_inputCaisse != null && !this.var_inputCaisse.isEmpty() && this.var_inputCaisse.contains(":")) {
                        var21 = this.var_inputCaisse.split(":");
                        this.bonEncaissementVente.setBonCodeCaisse(var21[0]);
                        this.bonEncaissementVente.setBonLibCaisse(var21[1]);
                        if (this.var_type_reg != null && !this.var_type_reg.isEmpty() && this.var_type_reg.contains(":")) {
                           String[] var14 = this.var_type_reg.split(":");
                           this.bonEncaissementVente.setBonTypeReg(Integer.parseInt(var14[0]));
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
                        var21 = this.var_banque_destination.split(":");
                        this.bonEncaissementVente.setBonCodeBanq(var21[0]);
                        this.bonEncaissementVente.setBonLibBanq(var21[1]);
                     }

                     this.bonEncaissementVente.setBonBanqueTireur(this.var_banque_tireur);
                     this.bonEncaissementVente.setBonNumChqBdx(this.var_num_cheque);
                     this.bonEncaissementVente.setBonDateCreat(new Date());
                     this.bonEncaissementVente.setBonUserCreat(this.usersLog.getUsrid());
                     this.bonEncaissementVente.setBonActivite(this.laboratoireEntete.getLabActivite());
                     this.bonEncaissementVente.setBonSite("");
                     this.bonEncaissementVente.setBonDepartement("");
                     this.bonEncaissementVente.setBonService(this.laboratoireEntete.getLabService());
                     this.bonEncaissementVente.setBonRegion("");
                     this.bonEncaissementVente.setBonSecteur("");
                     this.bonEncaissementVente.setBonPdv(var8);
                     this.bonEncaissementVente.setBonDateEcheReg(this.laboratoireEntete.getLabDateEcheReg());
                     this.bonEncaissementVente.setBonEtat(0);
                     this.bonEncaissementVente.setBonNatRef(this.nature);
                     this.bonEncaissementVente.setBonNomTiers(this.laboratoireEntete.getLabNomPatient());
                     this.bonEncaissementVente.setBonIdTiers(this.laboratoireEntete.getPatients().getPatId());
                     this.bonEncaissementVente.setBonNomContact("");
                     this.bonEncaissementVente.setBonIdContact(0L);
                     this.bonEncaissementVente.setBonTypeTiers(4);
                     this.bonEncaissementVente.setBonLibelle("Règlement Laboratoire N° " + this.laboratoireEntete.getLabNum());
                     this.bonEncaissementVente.setBonRef(this.laboratoireEntete.getLabNum());
                     this.bonEncaissementVente.setBonIdRef(this.laboratoireEntete.getLabId());
                     this.bonEncaissementVente.setBonObject(var8);
                     this.bonEncaissementVente.setBonObservation(this.laboratoireEntete.getLabMedecin());
                     this.bonEncaissementVente.setBonSerie(this.laboratoireEntete.getLabSerie());
                     this.bonEncaissementVente.setBonDevise(this.structureLog.getStrdevise());
                     this.bonEncaissementVente.setBonTotTtc(this.laboratoireEntete.getLabTotTaxePatient() + this.laboratoireEntete.getLabTotPatient());
                     this.bonEncaissementVente.setBonAPayer(var9 + this.reliquatPatient);
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
                           var21 = this.var_inputCaisse.split(":");
                           this.bonEncaissementVente.setBonCodeCaisse(var21[0]);
                           this.bonEncaissementVente.setBonLibCaisse(var21[1]);
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
                        this.bonEncaissementVente.setBonActivite(this.laboratoireEntete.getLabActivite());
                        this.bonEncaissementVente.setBonSite("");
                        this.bonEncaissementVente.setBonDepartement("");
                        this.bonEncaissementVente.setBonService(this.laboratoireEntete.getLabService());
                        this.bonEncaissementVente.setBonRegion("");
                        this.bonEncaissementVente.setBonSecteur("");
                        this.bonEncaissementVente.setBonPdv(var8);
                        this.bonEncaissementVente.setBonDateEcheReg(this.laboratoireEntete.getLabDateEcheReg());
                        this.bonEncaissementVente.setBonEtat(0);
                        this.bonEncaissementVente.setBonNatRef(this.nature);
                        this.bonEncaissementVente.setBonNomTiers(this.laboratoireEntete.getLabNomPatient());
                        this.bonEncaissementVente.setBonIdTiers(this.laboratoireEntete.getPatients().getPatId());
                        this.bonEncaissementVente.setBonNomContact("");
                        this.bonEncaissementVente.setBonIdContact(0L);
                        this.bonEncaissementVente.setBonTypeTiers(4);
                        this.bonEncaissementVente.setBonLibelle("Règlement Laboratoire N° " + this.laboratoireEntete.getLabNum());
                        this.bonEncaissementVente.setBonRef(this.laboratoireEntete.getLabNum());
                        this.bonEncaissementVente.setBonIdRef(this.laboratoireEntete.getLabId());
                        this.bonEncaissementVente.setBonObject(var8);
                        this.bonEncaissementVente.setBonObservation(this.laboratoireEntete.getLabMedecin());
                        this.bonEncaissementVente.setBonSerie(this.laboratoireEntete.getLabSerie());
                        this.bonEncaissementVente.setBonDevise(this.structureLog.getStrdevise());
                        this.bonEncaissementVente.setBonTotTtc(this.laboratoireEntete.getLabTotTaxePatient() + this.laboratoireEntete.getLabTotPatient());
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
                  }
               }
            } else {
               this.formRecherche.setMessageTexte("Le chrono du bon d`encaissement n`a pas été calculé. Peut être est-ce une question d'autorisation. Contactez votre administrateur pour plus d`informations.");
               this.formRecherche.setShowModalPanelMessage(true);
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

      if (this.laboratoireEntete != null) {
         this.lesConsultationEntete.remove(this.laboratoireEntete);
         this.laboratoireEntete.setVar_select_ligne(false);
         this.lesConsultationEntete.add(this.laboratoireEntete);
      }

      this.datamodelDocument.setWrappedData(this.lesConsultationEntete);
      this.showModalPanelPaye = false;
      this.visibiliteBton = false;
   }

   public void payeXDocumentRecu() throws HibernateException, NamingException {
      if (this.laboratoireEntete != null) {
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
         this.var_netAPayer = this.laboratoireEntete.getLabTotTaxePatient() + this.laboratoireEntete.getLabTotPatient() - this.laboratoireEntete.getLabRegPatient();
         this.montantElmTotBonEnc = this.var_tot_bon_encaissement;
         this.varTypeReg = 0;
         this.choixTypeReglement();
         this.choixCaisseXReglement();
         this.laboratoireEntete.setLabTypeReg(0);
         this.chargerModReg();
         this.verifValide();
         this.showModalPanelReglement = true;
      }

   }

   public void calculeCaisseDisponibleBrecu() throws HibernateException, NamingException {
      this.mesCaissesSeriesItems.clear();
      if (this.listCaisses.size() != 0) {
         for(int var1 = 0; var1 < this.listCaisses.size(); ++var1) {
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 61 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.laboratoireEntete.getLabSerie())) {
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
      if (this.montantElmTotBonEnc <= this.laboratoireEntete.getLabTotTaxePatient() + this.laboratoireEntete.getLabTotPatient() - this.var_tot_bon_encaissement) {
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

                        if (this.laboratoireEntete.getLabTotPatient() > var4.getPatlgaMontant() - var1) {
                           this.reliquatPatient = var4.getPatlgaMontant() - var1 - this.laboratoireEntete.getLabTotPatient();
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
         if (this.montantElmTotBonEnc != 0.0D && var4 < this.laboratoireEntete.getLabTotTaxePatient() + this.laboratoireEntete.getLabTotPatient() - this.laboratoireEntete.getLabRegPatient()) {
            this.utilNombre.calculTimbre(this.structureLog, this.laboratoireEntete.getLabTotTaxePatient() + this.laboratoireEntete.getLabTotPatient() - this.laboratoireEntete.getLabRegPatient(), var1, this.structureLog.getStrdevise(), this.laboratoireEntete.getLabDate());
         } else {
            this.utilNombre.calculTimbre(this.structureLog, this.laboratoireEntete.getLabTotTaxePatient() + this.laboratoireEntete.getLabTotPatient() - this.laboratoireEntete.getLabRegPatient(), var1, this.structureLog.getStrdevise(), this.laboratoireEntete.getLabDate());
            var4 = var4 - this.laboratoireEntete.getLabTotTaxePatient() + this.laboratoireEntete.getLabTotPatient() - this.laboratoireEntete.getLabRegPatient();
         }

         this.var_netAPayer += this.laboratoireEntete.getVar_reliquat();
      } else if (this.varTypeReg != 0) {
         this.var_netAPayer += this.laboratoireEntete.getVar_reliquat();
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
               String var7 = this.laboratoireEntete.getLabSerie();
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
               var12 = this.laboratoireEntete.getLabTotTaxePatient() + this.laboratoireEntete.getLabTotPatient() + var16 - this.laboratoireEntete.getLabRegPatient();
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
         Session var24 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         long var25 = this.laboratoireEntete.getLabId();
         this.laboratoireEntete = new LaboratoireEntete();
         this.laboratoireEntete = this.laboratoireEnteteDao.selectById(var25, var24);
         if (this.laboratoireEntete != null) {
            this.lesConsultationEntete.remove(var23);
            this.lesConsultationEntete.add(this.laboratoireEntete);
         }

         this.datamodelDocument.setWrappedData(this.lesConsultationEntete);
         this.chargerBonEncaissement(var24);
         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelReglement = false;
   }

   public void generationReglement(String var1, double var2, double var4, ExercicesCaisse var6, Session var7) throws HibernateException, NamingException {
      this.reglements = new Reglements();
      if (var2 >= this.laboratoireEntete.getLabTotTaxePatient() + this.laboratoireEntete.getLabTotPatient() + var4) {
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

      this.reglements.setRglActivite(this.laboratoireEntete.getLabActivite());
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
      this.reglements.setRglDocument(this.laboratoireEntete.getLabNum());
      this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
      this.reglements.setRglIdBon(0L);
      this.reglements.setRglIdDocument(this.laboratoireEntete.getLabId());
      this.reglements.setRglIdTiers(this.laboratoireEntete.getPatients().getPatId());
      this.reglements.setRglDepotTiers(0);
      this.reglements.setRglLibelle(this.laboratoireEntete.getLabLaboratoire());
      this.reglements.setRglMode("" + this.varTypeReg);
      this.reglements.setRglModele(this.var_modele_trf);
      this.reglements.setRglNatureDoc(74);
      this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
      this.reglements.setRglNomTiers(this.laboratoireEntete.getLabNomPatient());
      this.reglements.setRglIdContact(0L);
      this.reglements.setRglNomContact("");
      this.reglements.setRglNum(var1);
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
         int var10 = this.laboratoireEntete.getLabDate().getYear() + 1900;
         var20 = this.utilNombre.calculTimbre(this.structureLog, var2, var10, this.structureLog.getStrdevise(), this.reglements.getRglDateReg());
         this.reglements.setRglTimbre(var20);
      } else {
         this.reglements.setRglTimbre(0.0D);
      }

      this.reglements.setRglRegion("");
      this.reglements.setRglSecteur("");
      this.reglements.setRglSerie(this.laboratoireEntete.getLabSerie());
      this.reglements.setRglService(this.laboratoireEntete.getLabService());
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
      this.reglements.setRglNomEquipe("");
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
      if (this.laboratoireEntete != null) {
         this.laboratoireEntete.setLabRegPatient(this.laboratoireEntete.getLabRegPatient() + var2);
         if (this.laboratoireEntete.getLabRegPatient() >= this.laboratoireEntete.getLabTotTaxePatient() + this.laboratoireEntete.getLabTotPatient()) {
            this.laboratoireEntete.setLabSoldePatient(1);
         } else {
            this.laboratoireEntete.setLabSoldePatient(0);
         }

         this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var7);
         ArrayList var13 = new ArrayList();
         if (this.lesLaboratoire.size() != 0) {
            new LaboratoireLigne();
            double var15 = this.reglements.getRglRecette();
            double var17 = 0.0D;

            for(int var19 = 0; var19 < this.lesLaboratoire.size(); ++var19) {
               LaboratoireLigne var14 = (LaboratoireLigne)this.lesLaboratoire.get(var19);
               if ((var14.getLabligLaboratoire() != null && !var14.getLabligLaboratoire().isEmpty() && this.reglements.getRglPdv() != null && !this.reglements.getRglPdv().isEmpty() && var14.getLabligLaboratoire().equals(this.reglements.getRglPdv()) || (var14.getLabligLaboratoire() == null || var14.getLabligLaboratoire().isEmpty()) && (this.reglements.getRglPdv() == null || this.reglements.getRglPdv().isEmpty())) && var14.getLabligPatientHt() + var14.getLabligPatientTaxe() - var14.getLabligRegPatient() != 0.0D) {
                  if (var14.getLabligPatientHt() + var14.getLabligPatientTaxe() <= var15) {
                     var14.setLabligRegPatient(var14.getLabligPatientHt() + var14.getLabligPatientTaxe());
                     var17 = var14.getLabligRegPatient();
                  } else {
                     var14.setLabligRegPatient(var15);
                     var17 = var15;
                  }

                  var15 -= var14.getLabligRegPatient();
                  if (var15 < 0.0D) {
                     var15 = 0.0D;
                  }

                  var14 = this.laboratoireLigneDao.modif(var14, var7);
                  var14.setNouveauPaiement(var17);
                  var13.add(var14);
               }
            }
         }

         if (var13.size() != 0) {
            LaboratoireReglementDao var22 = new LaboratoireReglementDao(this.baseLog, this.utilInitHibernate);
            new LaboratoireReglement();
            new LaboratoireLigne();

            for(int var24 = 0; var24 < var13.size(); ++var24) {
               LaboratoireLigne var16 = (LaboratoireLigne)var13.get(var24);
               LaboratoireReglement var23 = new LaboratoireReglement();
               if (this.reglements.getRglCodeCaiss() != null && !this.reglements.getRglCodeCaiss().isEmpty()) {
                  var23.setLabregCaisse(this.reglements.getRglCodeCaiss());
               } else {
                  var23.setLabregCaisse("");
               }

               var23.setLabregEtat(1);
               var23.setLabregDate(this.reglements.getRglDateReg());
               var23.setLabregNumRecu(this.reglements.getRglNum());
               var23.setLabregIdRecu(this.reglements.getRglId());
               var23.setLaboratoireEntete(this.laboratoireEntete);
               var23.setLabregIdBonEncaissement(0L);
               var23.setLabregIdLaboratoire(0L);
               if (var16.getLaboratoireEntete().getLabLaboratoire() != null && !var16.getLaboratoireEntete().getLabLaboratoire().isEmpty()) {
                  var23.setLabregLaboratoire(var16.getLaboratoireEntete().getLabLaboratoire());
               } else {
                  var23.setLabregLaboratoire(var16.getLabligLaboratoire());
               }

               var23.setLabregLibelle(var16.getLabligLibelle());
               var23.setLabregPatient(var16.getNouveauPaiement());
               var23.setLabregProduit(var16.getLabligProduit());
               var23.setLabregService(var16.getLaboratoireEntete().getLabService());
               var23.setLabregNumPieceTiers(var16.getLaboratoireEntete().getLabNumPieceTiers());
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.reglements = (Reglements)this.datamodelRecu.getRowData();
            this.reglementsDao.delete(this.reglements, var1);
            new ArrayList();
            List var3 = this.reglementsDao.reglementDocument(this.laboratoireEntete.getLabId(), this.nature, var1);
            double var4 = 0.0D;
            if (var3.size() != 0) {
               for(int var6 = 0; var6 < var3.size(); ++var6) {
                  var4 += ((Reglements)var3.get(var6)).getRglRecette();
               }
            }

            this.laboratoireEntete.setLabRegPatient(var4);
            if (this.laboratoireEntete.getLabRegPatient() >= this.laboratoireEntete.getLabTotTaxePatient() + this.laboratoireEntete.getLabTotPatient()) {
               this.laboratoireEntete.setLabSoldePatient(1);
            } else {
               this.laboratoireEntete.setLabSoldePatient(0);
            }

            this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
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
      if (this.laboratoireEntete != null) {
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

   public void initPaillasse(Session var1) throws HibernateException, NamingException {
      this.utilDownload = new UtilDownload();
      this.laboratoireResultatDao = new LaboratoireResultatDao(this.baseLog, this.utilInitHibernate);
      this.produitsLaboratoireDao = new ProduitsLaboratoireDao(this.baseLog, this.utilInitHibernate);
      this.produitsReponseDao = new ProduitsReponseDao(this.baseLog, this.utilInitHibernate);
      this.laboratoireLigneDao = new LaboratoireLigneDao(this.baseLog, this.utilInitHibernate);
      this.lesAppareilsItems = new ArrayList();
      ParcDao var2 = new ParcDao(this.baseLog, this.utilInitHibernate);
      this.lesAppareilsItems.clear();
      new ArrayList();
      List var3 = var2.chargerLesParcsLaboratoire(var1);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            if (((Parc)var3.get(var4)).getPrcImmatriculation() != null && !((Parc)var3.get(var4)).getPrcImmatriculation().isEmpty() && ((Parc)var3.get(var4)).getPrcMarque() != null && !((Parc)var3.get(var4)).getPrcMarque().isEmpty()) {
               this.lesAppareilsItems.add(new SelectItem(((Parc)var3.get(var4)).getPrcImmatriculation() + ":" + ((Parc)var3.get(var4)).getPrcMarque()));
            }
         }
      }

      this.factureEnCours = "";
      this.inpEtat = 11;
      this.lesLaboratoire = new ArrayList();
      this.dataModelLaboratoire = new ListDataModel();
      this.lesResulatsHistoriques = new ArrayList();
      this.lesReponsesItems = new ArrayList();
      this.lesActionsItems = new ArrayList();
      this.lesReponses = new ArrayList();
      this.dataModelLesReponses = new ListDataModel();
      this.lesDetailsExamens = new ArrayList();
      this.dataModelDetailExamens = new ListDataModel();
      this.dataModelListeExamens = new ListDataModel();
      this.lesReponsesDetail = new ArrayList();
      this.dataModelLesReponsesDetail = new ListDataModel();
      this.lesReponsesItemsDetail = new ArrayList();
      this.lesActionsItemsDetail = new ArrayList();
      this.visibiliteBton = false;
   }

   public void moreSearchPaillasse() throws ParseException {
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

   public void executerRequetePaillasse() throws IOException, HibernateException, NamingException, ParseException {
      this.factureEnCours = "";
      this.chargeListePaillasse((Session)null);
   }

   public void chargeListePaillasse(Session var1) throws HibernateException, NamingException, ParseException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
      }

      this.lesConsultationEntete.clear();
      this.lesLaboratoire.clear();
      this.var_nb_ligne = 0;
      String var3 = "";
      String var4 = "";
      if (this.var_more_search) {
         if (this.inpDu != null) {
            var3 = this.utilDate.dateToStringSQLLight(this.inpDu);
         }

         if (this.inpAu != null) {
            var4 = this.utilDate.dateToStringSQLLight(this.inpAu);
         }
      } else {
         var3 = null;
         var4 = null;
      }

      byte var5 = 0;
      if (this.inpEtat == 11) {
         var5 = 1;
      } else if (this.inpEtat == 4) {
         var5 = 4;
      }

      this.lesConsultationEntete = this.laboratoireEnteteDao.recherchePaillasse(var1, this.exercicesVentes.getExevteId(), this.getInpNum(), this.getInpNomPatient(), this.getInpPrenomPatient(), this.getInpTel(), this.getInpCi(), this.getInpDossier(), this.getInpSociete(), this.getInpAssurance(), this.getInpComplementaire(), this.getInpContrat(), var5, this.getInpSerie(), this.getInpCat(), this.getPeriode(), this.getInpService(), this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.getInpProtocole(), this.getInpMedecin(), this.getInpActivite(), var3, var4);
      if (this.lesConsultationEntete.size() > 0) {
         String var6 = "";

         for(int var7 = 0; var7 < this.lesConsultationEntete.size(); ++var7) {
            if (var6 != null && !var6.isEmpty()) {
               var6 = var6 + "," + ((LaboratoireEntete)this.lesConsultationEntete.get(var7)).getLabId();
            } else {
               var6 = "" + ((LaboratoireEntete)this.lesConsultationEntete.get(var7)).getLabId();
            }
         }

         Object var18 = new ArrayList();
         if (var6 != null && !var6.isEmpty()) {
            var18 = this.laboratoireResultatDao.selectResultatListe(var6, var1);
         }

         new ArrayList();
         List var8 = this.produitsMedicDao.verifProduitsByNature("1106", var1);
         new ArrayList();
         List var9 = this.produitsLaboratoireDao.listProdLaboratoire(var1);
         Object var10 = new ArrayList();
         new LaboratoireEntete();

         for(int var12 = 0; var12 < this.lesConsultationEntete.size(); ++var12) {
            LaboratoireEntete var11 = (LaboratoireEntete)this.lesConsultationEntete.get(var12);
            ((List)var10).clear();
            var10 = this.laboratoireLigneDao.selectDetailPaillasse(var11, this.inpEtat, var1);
            if (((List)var10).size() != 0) {
               for(int var13 = 0; var13 < ((List)var10).size(); ++var13) {
                  if (((LaboratoireLigne)((List)var10).get(var13)).getLabligProduit() != null && !((LaboratoireLigne)((List)var10).get(var13)).getLabligProduit().isEmpty()) {
                     this.produits = null;

                     int var14;
                     for(var14 = 0; var14 < var8.size(); ++var14) {
                        if (((Produits)var8.get(var14)).getProCode().equals(((LaboratoireLigne)((List)var10).get(var13)).getLabligProduit())) {
                           this.produits = (Produits)var8.get(var14);
                           break;
                        }
                     }

                     if (this.produits != null) {
                        for(var14 = 0; var14 < var9.size(); ++var14) {
                           if (((ProduitsLaboratoire)var9.get(var14)).getProduits().getProId() == this.produits.getProId()) {
                              if (((ProduitsLaboratoire)var9.get(var14)).getProlabType() == 0) {
                                 break;
                              }

                              if (((LaboratoireLigne)((List)var10).get(var13)).getLabligId() == 81842L) {
                                 boolean var15 = false;
                              }

                              ((LaboratoireLigne)((List)var10).get(var13)).setTypeExamen(((ProduitsLaboratoire)var9.get(var14)).getProlabType());
                              double var19 = 0.0D;

                              for(int var17 = 0; var17 < ((List)var18).size(); ++var17) {
                                 if (((LaboratoireResultat)((List)var18).get(var17)).getLaboratoireLigne().getLabligId() == ((LaboratoireLigne)((List)var10).get(var13)).getLabligId()) {
                                    var19 = ((LaboratoireResultat)((List)var18).get(var17)).getLabresNumerique();
                                    break;
                                 }
                              }

                              ((LaboratoireLigne)((List)var10).get(var13)).setResultatExamenNumerique(var19);
                              ((LaboratoireLigne)((List)var10).get(var13)).setOuvertureZone(false);
                              this.lesLaboratoire.add(((List)var10).get(var13));
                              break;
                           }
                        }
                     }
                  }
               }
            }
         }

         if (this.lesLaboratoire.size() != 0) {
            this.var_nb_ligne = this.lesLaboratoire.size();
         }
      }

      this.dataModelLaboratoire.setWrappedData(this.lesLaboratoire);
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.visibiliteBton = false;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void selectionExamen() throws HibernateException, NamingException, IOException, SQLException, ParseException {
      this.laboratoireEntete = new LaboratoireEntete();
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

         this.laboratoireLigne = (LaboratoireLigne)var1.get(0);
         this.affichePhotoResultat();
         this.laboratoireEntete = this.laboratoireLigne.getLaboratoireEntete();
         this.patients = this.laboratoireEntete.getPatients();
         this.laboratoireResultat = new LaboratoireResultat();
         this.examenDetailResultat = new LaboratoireResultat();
         this.produitsReponse = new ProduitsReponse();
         this.produitsFourchette = new ProduitsFourchette();
         this.listeAction = false;
         Session var10 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         this.elementPatient(var10);
         this.chargerUserChrono(var10);
         this.lesDetailsExamens.clear();
         this.lesReponsesItems.clear();
         this.lesResulatsHistoriques.clear();
         this.lesActionsItems.clear();
         if (this.laboratoireLigne.getLabligProduit() != null && !this.laboratoireLigne.getLabligProduit().isEmpty()) {
            this.produits = this.produitsMedicDao.chargeProduit(this.laboratoireLigne.getLabligProduit(), var10);
            if (this.produits != null) {
               this.produitsLaboratoire = this.produitsLaboratoireDao.chargeProdLaboratoireByProd(this.produits.getProId(), var10);
               if (this.produitsLaboratoire == null) {
                  this.produitsLaboratoire = new ProduitsLaboratoire();
               }
            } else {
               this.produitsLaboratoire = new ProduitsLaboratoire();
            }
         } else {
            this.produits = new Produits();
            this.produitsLaboratoire = new ProduitsLaboratoire();
         }

         if (this.produitsLaboratoire.getProlabType() == 1) {
            this.produitsFourchette = this.calculeFourchette(this.produits.getProCode(), 0L, var10);
            this.produitsLaboratoire.setProlabFourchette(this.produitsFourchette.getProfchNorme());
            this.produitsLaboratoire.setProlabFourchetteMin((double)this.produitsFourchette.getProfchFmini());
            this.produitsLaboratoire.setProlabFourchetteMax((double)this.produitsFourchette.getProfchFmaxi());
         }

         int var5;
         int var6;
         if (this.produitsLaboratoire.getProlabType() <= 7 || this.produitsLaboratoire.getProlabType() == 9 || this.produitsLaboratoire.getProlabType() == 10) {
            this.laboratoireResultat = this.laboratoireResultatDao.selectResultat(this.laboratoireLigne, var10);
            if (this.laboratoireResultat == null) {
               this.laboratoireResultat = new LaboratoireResultat();
            }

            this.laboratoireResultat.setLabresCode(this.produits.getProCode());
            this.laboratoireResultat.setLabresLibelle(this.produits.getProLibClient());
            this.laboratoireResultat.setLabresIdProdDet(0L);
            this.laboratoireResultat.setLabresType(this.produitsLaboratoire.getProlabType());
            this.laboratoireResultat.setLabresCategorie(this.produitsLaboratoire.getProlabCategorie());
            if (this.produitsLaboratoire.getProlabType() != 6) {
               this.laboratoireResultat.setLabresReponseAction(0L);
               this.laboratoireResultat.setLabresUnite(this.produitsLaboratoire.getProlabUnite());
               this.laboratoireResultat.setLabresNorme(this.produitsLaboratoire.getProlabNorme());
               this.laboratoireResultat.setLabresTechnique(this.produitsLaboratoire.getProlabTechnique());
               this.laboratoireResultat.setLabresCoef(this.produitsLaboratoire.getProlabCoef());
               this.laboratoireResultat.setLabresUniteConvertie(this.produitsLaboratoire.getProlabUniteConv());
               this.laboratoireResultat.setLabresFourchetteMin(this.produitsLaboratoire.getProlabFourchetteMin());
               this.laboratoireResultat.setLabresFourchetteMax(this.produitsLaboratoire.getProlabFourchetteMax());
               this.laboratoireResultat.setLabresFourchette(this.produitsLaboratoire.getProlabFourchette());
            } else {
               this.laboratoireResultat.setLabresNorme("");
               this.laboratoireResultat.setLabresTechnique("");
               this.laboratoireResultat.setLabresCoef(0.0F);
               this.laboratoireResultat.setLabresUniteConvertie("");
               this.laboratoireResultat.setLabresFourchetteMin(0.0D);
               this.laboratoireResultat.setLabresFourchetteMax(0.0D);
               this.laboratoireResultat.setLabresFourchette("");
            }

            if (this.produitsLaboratoire.getProlabConclusion() == 1 && (this.laboratoireResultat.getLabresCommentaire() == null || this.laboratoireResultat.getLabresCommentaire().isEmpty())) {
               this.laboratoireResultat.setLabresCommentaire(this.produitsLaboratoire.getProlabConclusionDef());
            }

            int var4 = 0;
            if (this.lesLaboratoire.size() != 0) {
               for(var5 = 0; var5 < this.lesLaboratoire.size(); ++var5) {
                  if (this.laboratoireLigne.getLabligId() == ((LaboratoireLigne)this.lesLaboratoire.get(var5)).getLabligId()) {
                     var4 = var5;
                     break;
                  }
               }
            }

            this.laboratoireResultat.setLabresOrdre(var4);
            if (this.laboratoireResultat.getLabresType() == 1 || this.laboratoireResultat.getLabresType() == 2 || this.laboratoireResultat.getLabresType() == 4 || this.laboratoireResultat.getLabresType() == 9 || this.laboratoireResultat.getLabresType() == 10) {
               new LaboratoireLigne();

               for(var6 = 0; var6 < this.lesLaboratoire.size(); ++var6) {
                  LaboratoireLigne var13 = (LaboratoireLigne)this.lesLaboratoire.get(var6);
                  var13.setOuvertureZone(false);
               }

               if (this.laboratoireEntete.getLabEtat() <= 1 || this.laboratoireEntete.getLabCloture() == 0) {
                  this.laboratoireLigne.setOuvertureZone(true);
               }
            }
         }

         if (this.produitsLaboratoire.getProlabType() == 5) {
            this.lesReponsesItems = this.produitsReponseDao.chargeProdReponseByProdItems(this.produits.getProCode(), var10);
         } else if (this.produitsLaboratoire.getProlabType() == 6) {
            this.lesReponsesItems = this.produitsReponseDao.chargeProdReponseByProdItems(this.produits.getProCode(), var10);
            this.lesActionsItems.add(new SelectItem("Sans action"));
            this.listeAction = false;
            if (this.laboratoireResultat.getLabresReponseAction() != 0L) {
               this.produitsReponse = this.produitsReponseDao.chargeProdReponseById(this.laboratoireResultat.getLabresReponseAction(), var10);
               if (this.produitsReponse != null) {
                  if (this.produitsReponse.getProrepTexteModifiable() == null || this.produitsReponse.getProrepTexteModifiable().isEmpty()) {
                     this.produitsReponse.setProrepTexteModifiable((String)null);
                  }
               } else {
                  this.produitsReponse = new ProduitsReponse();
                  this.laboratoireResultat.setLabresReponseUnique("");
                  this.laboratoireResultat.setLabresReponseMultiple("");
                  this.produitsReponse.setProrepTexteModifiable((String)null);
               }
            } else {
               this.produitsReponse = new ProduitsReponse();
               this.laboratoireResultat.setLabresReponseUnique("");
               this.laboratoireResultat.setLabresReponseMultiple("");
               this.produitsReponse.setProrepTexteModifiable((String)null);
            }
         } else {
            int var7;
            if (this.produitsLaboratoire.getProlabType() == 7) {
               this.lesReponses = this.produitsReponseDao.chargeProdReponseByProd(this.produits.getProCode(), var10);
               this.dataModelLesReponses.setWrappedData(this.lesReponses);
               if (this.laboratoireResultat.getLabresReponseMultiple() != null && !this.laboratoireResultat.getLabresReponseMultiple().isEmpty()) {
                  new ProduitsReponse();
                  ProduitsReponse var12;
                  if (!this.laboratoireResultat.getLabresReponseMultiple().contains("#")) {
                     for(var5 = 0; var5 < this.lesReponses.size(); ++var5) {
                        var12 = (ProduitsReponse)this.lesReponses.get(var5);
                        if (var12.getProrepReponse().equals(this.laboratoireResultat.getLabresReponseMultiple())) {
                           var12.setRep_select(true);
                        }
                     }
                  } else {
                     String[] var15 = this.laboratoireResultat.getLabresReponseMultiple().split("#");

                     for(var6 = 0; var6 < var15.length; ++var6) {
                        for(var7 = 0; var7 < this.lesReponses.size(); ++var7) {
                           var12 = (ProduitsReponse)this.lesReponses.get(var7);
                           if (var12.getProrepReponse().equals(var15[var6])) {
                              var12.setRep_select(true);
                           }
                        }
                     }
                  }
               }
            } else if (this.produitsLaboratoire.getProlabType() == 8) {
               this.lesDetailsExamens = this.laboratoireResultatDao.selectResultatListe(this.laboratoireLigne, var10);
               new ArrayList();
               List var11 = this.produitsDetailDao.chargeProdDetailByProd(this.produits.getProCode(), var10);
               if (var11.size() != 0) {
                  new ProduitsDetail();
                  new LaboratoireResultat();

                  for(var7 = 0; var7 < var11.size(); ++var7) {
                     ProduitsDetail var14 = (ProduitsDetail)var11.get(var7);
                     boolean var8 = false;
                     if (this.lesDetailsExamens.size() != 0) {
                        for(int var9 = 0; var9 < this.lesDetailsExamens.size(); ++var9) {
                           if (((LaboratoireResultat)this.lesDetailsExamens.get(var9)).getLabresLibelle().equals(var14.getProdetLibelle())) {
                              var8 = true;
                              break;
                           }
                        }
                     }

                     if (!var8) {
                        LaboratoireResultat var16 = new LaboratoireResultat();
                        var16.setLabresCode(var14.getProdetCode());
                        var16.setLabresCoef(var14.getProdetCoef());
                        var16.setLabresLibelle(var14.getProdetLibelle());
                        var16.setLabresIdProdDet(var14.getProdetId());
                        var16.setLabresNorme(var14.getProdetNorme());
                        var16.setLabresUnite(var14.getProdetUnite());
                        var16.setLabresUniteConvertie(var14.getProdetUniteConv());
                        var16.setLabresOrdre(var14.getProdetOrdre());
                        var16.setLabresType(var14.getProdetType());
                        var16.setLabresCategorie(var14.getProdetCategorie());
                        var16.setLabresFourchetteMin(var14.getProdetFourchetteMin());
                        var16.setLabresFourchetteMax(var14.getProdetFourchetteMax());
                        var16.setLabresFourchette(var14.getProdetFourchette());
                        this.lesDetailsExamens.add(var16);
                     }
                  }
               }

               this.dataModelDetailExamens.setWrappedData(this.lesDetailsExamens);
            }
         }

         this.lesResulatsHistoriques = this.laboratoireResultatDao.selectHistorique(this.patients.getPatId(), this.laboratoireResultat.getLabresId(), this.produits.getProCode(), var10);
         this.utilInitHibernate.closeSession();
         this.visibiliteBton = true;
      }

   }

   public void visualisationExamen() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      if (this.laboratoireLigne != null) {
         if (this.laboratoireLigne.getLabligEtat() == 0) {
            this.modifResultat();
         } else {
            this.consultResultat();
         }
      }

   }

   public void detailFacture() {
      if (this.laboratoireEntete != null) {
         new LaboratoireLigne();
         this.factureEnCours = this.laboratoireEntete.getLabNum();

         for(int var2 = 0; var2 < this.lesLaboratoire.size(); ++var2) {
            LaboratoireLigne var1 = (LaboratoireLigne)this.lesLaboratoire.get(var2);
            if (!var1.getLaboratoireEntete().getLabNum().equals(this.factureEnCours)) {
               this.lesLaboratoire.remove(var1);
               --var2;
            }
         }

         this.dataModelLaboratoire.setWrappedData(this.lesLaboratoire);
         this.simpleSelectionEntete.clear();
         this.extDTable = new HtmlExtendedDataTable();
      } else {
         this.factureEnCours = "";
      }

   }

   public void calculAction() throws HibernateException, NamingException {
      if (this.laboratoireResultat.getLabresReponseAction() != 0L) {
         this.produitsReponse = this.produitsReponseDao.chargeProdReponseById(this.laboratoireResultat.getLabresReponseAction(), (Session)null);
         if (this.produitsReponse != null) {
            this.laboratoireResultat.setLabresReponseUnique(this.produitsReponse.getProrepReponse());
            this.laboratoireResultat.setLabresReponseMultiple(this.produitsReponse.getProrepTexteModifiable());
            if (this.produitsReponse.getProrepTexteModifiable() == null || this.produitsReponse.getProrepTexteModifiable().isEmpty()) {
               this.produitsReponse.setProrepTexteModifiable((String)null);
            }
         } else {
            this.laboratoireResultat.setLabresReponseUnique("");
            this.laboratoireResultat.setLabresReponseMultiple("");
            this.produitsReponse.setProrepTexteModifiable((String)null);
         }
      } else {
         this.produitsReponse = new ProduitsReponse();
         this.laboratoireResultat.setLabresReponseUnique("");
         this.laboratoireResultat.setLabresReponseMultiple("");
         this.produitsReponse.setProrepTexteModifiable((String)null);
      }

   }

   public void calculActionDetail() throws HibernateException, NamingException {
      if (this.examenDetailResultat.getLabresReponseAction() != 0L) {
         this.produitsReponse = this.produitsReponseDao.chargeProdReponseById(this.examenDetailResultat.getLabresReponseAction(), (Session)null);
         if (this.produitsReponse != null) {
            this.examenDetailResultat.setLabresReponseUnique(this.produitsReponse.getProrepReponse());
            this.examenDetailResultat.setLabresReponseMultiple(this.produitsReponse.getProrepTexteModifiable());
            if (this.produitsReponse.getProrepTexteModifiable() == null || this.produitsReponse.getProrepTexteModifiable().isEmpty()) {
               this.produitsReponse.setProrepTexteModifiable((String)null);
            }
         } else {
            this.examenDetailResultat.setLabresReponseUnique("");
            this.examenDetailResultat.setLabresReponseMultiple("");
            this.produitsReponse.setProrepTexteModifiable((String)null);
         }
      } else {
         this.produitsReponse = new ProduitsReponse();
         this.examenDetailResultat.setLabresReponseUnique("");
         this.examenDetailResultat.setLabresReponseMultiple("");
         this.produitsReponse.setProrepTexteModifiable((String)null);
      }

   }

   public void modifResultat() {
      if (this.laboratoireLigne != null) {
         this.var_action = 2;
      }

   }

   public void consultResultat() {
      if (this.laboratoireLigne != null) {
         this.var_action = 3;
      }

   }

   public void valideResultat() throws HibernateException, NamingException {
      if (this.laboratoireLigne != null) {
         this.laboratoireLigne.setLabligEtat(1);
         this.laboratoireLigne.setLabligDateRealisee(new Date());
         this.laboratoireLigne = this.laboratoireLigneDao.modif(this.laboratoireLigne);
      }

   }

   public void deValideResultat() throws HibernateException, NamingException {
      if (this.laboratoireLigne != null) {
         this.laboratoireLigne.setLabligEtat(0);
         this.laboratoireLigne.setLabligDateRealisee((Date)null);
         this.laboratoireLigne = this.laboratoireLigneDao.modif(this.laboratoireLigne);
      }

   }

   public void annuleResultat() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void saveResultat() throws HibernateException, NamingException {
      if (this.laboratoireEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.lesDetailsExamens.size() == 0) {
               this.lesDetailsExamens.add(this.laboratoireResultat);
            }

            for(int var3 = 0; var3 < this.lesDetailsExamens.size(); ++var3) {
               this.laboratoireResultat = (LaboratoireResultat)this.lesDetailsExamens.get(var3);
               this.laboratoireResultat.setLabresDate(new Date());
               if (this.laboratoireResultat.getLabresType() == 1) {
                  this.laboratoireResultat.setLabresReponseAction(0L);
                  this.laboratoireResultat.setLabresDate((Date)null);
                  this.laboratoireResultat.setLabresImage((String)null);
                  this.laboratoireResultat.setLabresPdf((String)null);
                  this.laboratoireResultat.setLabresTexte("");
                  this.laboratoireResultat.setLabresReponseUnique("");
                  this.laboratoireResultat.setLabresAction("");
                  this.laboratoireResultat.setLabresReponseMultiple("");
               } else if (this.laboratoireResultat.getLabresType() == 2) {
                  this.laboratoireResultat.setLabresReponseAction(0L);
                  this.laboratoireResultat.setLabresNumerique(0.0D);
                  this.laboratoireResultat.setLabresImage((String)null);
                  this.laboratoireResultat.setLabresPdf((String)null);
                  this.laboratoireResultat.setLabresTexte("");
                  this.laboratoireResultat.setLabresReponseUnique("");
                  this.laboratoireResultat.setLabresAction("");
                  this.laboratoireResultat.setLabresReponseMultiple("");
               } else if (this.laboratoireResultat.getLabresType() == 3) {
                  this.laboratoireResultat.setLabresReponseAction(0L);
                  this.laboratoireResultat.setLabresNumerique(0.0D);
                  this.laboratoireResultat.setLabresDate((Date)null);
                  this.laboratoireResultat.setLabresTexte("");
                  this.laboratoireResultat.setLabresReponseUnique("");
                  this.laboratoireResultat.setLabresAction("");
                  this.laboratoireResultat.setLabresReponseMultiple("");
               } else if (this.laboratoireResultat.getLabresType() == 4) {
                  this.laboratoireResultat.setLabresReponseAction(0L);
                  this.laboratoireResultat.setLabresNumerique(0.0D);
                  this.laboratoireResultat.setLabresDate((Date)null);
                  this.laboratoireResultat.setLabresImage((String)null);
                  this.laboratoireResultat.setLabresPdf((String)null);
                  this.laboratoireResultat.setLabresReponseUnique("");
                  this.laboratoireResultat.setLabresAction("");
                  this.laboratoireResultat.setLabresReponseMultiple("");
               } else if (this.laboratoireResultat.getLabresType() == 5) {
                  this.laboratoireResultat.setLabresReponseAction(0L);
                  this.laboratoireResultat.setLabresNumerique(0.0D);
                  this.laboratoireResultat.setLabresDate((Date)null);
                  this.laboratoireResultat.setLabresImage((String)null);
                  this.laboratoireResultat.setLabresPdf((String)null);
                  this.laboratoireResultat.setLabresTexte("");
                  this.laboratoireResultat.setLabresAction("");
                  this.laboratoireResultat.setLabresReponseMultiple("");
               } else if (this.laboratoireResultat.getLabresType() == 6) {
                  if (!this.produitsReponse.isProrepActionNumerique()) {
                     this.laboratoireResultat.setLabresNumerique(0.0D);
                     this.laboratoireResultat.setLabresUnite("");
                     this.laboratoireResultat.setLabresUniteConvertie("");
                  }

                  this.laboratoireResultat.setLabresDate((Date)null);
                  this.laboratoireResultat.setLabresImage((String)null);
                  this.laboratoireResultat.setLabresPdf((String)null);
                  this.laboratoireResultat.setLabresTexte("");
                  if (this.produitsReponse.getProrepTexteModifiable() == null || this.produitsReponse.getProrepTexteModifiable().isEmpty()) {
                     this.laboratoireResultat.setLabresReponseMultiple("");
                  }
               } else if (this.laboratoireResultat.getLabresType() != 7) {
                  if (this.laboratoireResultat.getLabresType() == 8) {
                     this.laboratoireResultat.setLabresReponseAction(0L);
                     this.laboratoireResultat.setLabresNumerique(0.0D);
                     this.laboratoireResultat.setLabresDate((Date)null);
                     this.laboratoireResultat.setLabresImage((String)null);
                     this.laboratoireResultat.setLabresPdf((String)null);
                     this.laboratoireResultat.setLabresTexte("");
                     this.laboratoireResultat.setLabresReponseUnique("");
                     this.laboratoireResultat.setLabresAction("");
                     this.laboratoireResultat.setLabresReponseMultiple("");
                  }
               } else {
                  this.laboratoireResultat.setLabresReponseAction(0L);
                  this.laboratoireResultat.setLabresNumerique(0.0D);
                  this.laboratoireResultat.setLabresDate((Date)null);
                  this.laboratoireResultat.setLabresImage((String)null);
                  this.laboratoireResultat.setLabresPdf((String)null);
                  this.laboratoireResultat.setLabresTexte("");
                  this.laboratoireResultat.setLabresReponseUnique("");
                  this.laboratoireResultat.setLabresAction("");
                  String var4 = "";
                  int var5 = 0;

                  while(true) {
                     if (var5 >= this.lesReponses.size()) {
                        this.laboratoireResultat.setLabresReponseMultiple(var4);
                        break;
                     }

                     if (((ProduitsReponse)this.lesReponses.get(var5)).isRep_select()) {
                        if (var4 != null && !var4.isEmpty()) {
                           var4 = var4 + "#" + ((ProduitsReponse)this.lesReponses.get(var5)).getProrepReponse();
                        } else {
                           var4 = ((ProduitsReponse)this.lesReponses.get(var5)).getProrepReponse();
                        }
                     }

                     ++var5;
                  }
               }

               if (this.laboratoireResultat.getLabresId() == 0L) {
                  this.laboratoireResultat.setLabresIdLab(this.laboratoireEntete.getLabId());
                  this.laboratoireResultat.setLabresIdPatient(this.patients.getPatId());
                  this.laboratoireResultat.setLabresNum(this.laboratoireEntete.getLabNum());
                  this.laboratoireResultat.setLaboratoireLigne(this.laboratoireLigne);
                  this.laboratoireResultat = this.laboratoireResultatDao.insert(this.laboratoireResultat, var1);
               } else {
                  this.laboratoireResultat = this.laboratoireResultatDao.modif(this.laboratoireResultat, var1);
               }
            }

            this.laboratoireLigne.setLabligEtat(1);
            this.laboratoireLigne.setLabligDateRealisee(new Date());
            this.laboratoireLigne = this.laboratoireLigneDao.modif(this.laboratoireLigne, var1);
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

      this.var_action = 0;
   }

   public void ourvertureZone() {
      if (this.laboratoireEntete != null && this.laboratoireLigne != null) {
         this.laboratoireLigne.setOuvertureZone(true);
      }

   }

   public void saveResultatDirect() throws HibernateException, NamingException {
      if (this.laboratoireLigne != null && this.laboratoireResultat != null) {
         boolean var1 = false;
         if (this.laboratoireResultat.getLabresType() == 1) {
            var1 = true;
            this.laboratoireResultat.setLabresReponseAction(0L);
            this.laboratoireResultat.setLabresDate((Date)null);
            this.laboratoireResultat.setLabresImage((String)null);
            this.laboratoireResultat.setLabresPdf((String)null);
            this.laboratoireResultat.setLabresTexte("");
            this.laboratoireResultat.setLabresReponseUnique("");
            this.laboratoireResultat.setLabresAction("");
            this.laboratoireResultat.setLabresReponseMultiple("");
            this.laboratoireResultat.setLabresNumerique(this.laboratoireLigne.getResultatExamenNumerique());
         } else if (this.laboratoireResultat.getLabresType() == 2) {
            var1 = true;
            this.laboratoireResultat.setLabresReponseAction(0L);
            this.laboratoireResultat.setLabresDate(this.laboratoireLigne.getResultatExamenDate());
            this.laboratoireResultat.setLabresImage((String)null);
            this.laboratoireResultat.setLabresPdf((String)null);
            this.laboratoireResultat.setLabresTexte("");
            this.laboratoireResultat.setLabresReponseUnique("");
            this.laboratoireResultat.setLabresAction("");
            this.laboratoireResultat.setLabresReponseMultiple("");
            this.laboratoireResultat.setLabresNumerique(0.0D);
         } else if (this.laboratoireResultat.getLabresType() == 4 || this.laboratoireResultat.getLabresType() == 9 || this.laboratoireResultat.getLabresType() == 10) {
            var1 = true;
            this.laboratoireResultat.setLabresReponseAction(0L);
            this.laboratoireResultat.setLabresDate((Date)null);
            this.laboratoireResultat.setLabresImage((String)null);
            this.laboratoireResultat.setLabresPdf((String)null);
            this.laboratoireResultat.setLabresTexte(this.laboratoireLigne.getResultatExamenTexte());
            this.laboratoireResultat.setLabresReponseUnique("");
            this.laboratoireResultat.setLabresAction("");
            this.laboratoireResultat.setLabresReponseMultiple("");
            this.laboratoireResultat.setLabresNumerique(0.0D);
         }

         if (var1) {
            if (this.laboratoireResultat.getLabresId() == 0L) {
               this.laboratoireResultat.setLabresIdLab(this.laboratoireEntete.getLabId());
               this.laboratoireResultat.setLabresIdPatient(this.patients.getPatId());
               this.laboratoireResultat.setLabresNum(this.laboratoireEntete.getLabNum());
               this.laboratoireResultat.setLaboratoireLigne(this.laboratoireLigne);
               this.laboratoireResultat = this.laboratoireResultatDao.insert(this.laboratoireResultat);
            } else {
               this.laboratoireResultat = this.laboratoireResultatDao.modif(this.laboratoireResultat);
            }

            this.laboratoireLigne.setResultatExamenNumerique(this.laboratoireResultat.getLabresNumerique());
            this.laboratoireLigne.setOuvertureZone(false);
         }
      }

   }

   public void selectLigneDetail() throws HibernateException, NamingException {
      if (this.dataModelDetailExamens.isRowAvailable()) {
         this.examenDetailResultat = (LaboratoireResultat)this.dataModelDetailExamens.getRowData();
      }

   }

   public void modifResultatDetail() throws HibernateException, NamingException, ParseException {
      this.selectLigneDetail();
      if (this.examenDetailResultat != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         if (this.examenDetailResultat.getLabresCode() != null && !this.examenDetailResultat.getLabresCode().isEmpty()) {
            this.produits = this.produitsMedicDao.chargeProduit(this.examenDetailResultat.getLabresCode(), var1);
            if (this.produits != null) {
               this.produitsLaboratoire = this.produitsLaboratoireDao.chargeProdLaboratoireByProd(this.produits.getProId(), var1);
               if (this.produitsLaboratoire == null) {
                  this.produitsLaboratoire = new ProduitsLaboratoire();
               }
            } else {
               this.produitsLaboratoire = new ProduitsLaboratoire();
            }
         } else {
            this.produits = new Produits();
            this.produitsLaboratoire = new ProduitsLaboratoire();
         }

         if (this.examenDetailResultat.getLabresType() == 1) {
            this.produitsFourchette = this.calculeFourchette(this.examenDetailResultat.getLabresCode(), this.examenDetailResultat.getLabresIdProdDet(), var1);
            this.produitsLaboratoire.setProlabFourchette(this.produitsFourchette.getProfchNorme());
            this.produitsLaboratoire.setProlabFourchetteMin((double)this.produitsFourchette.getProfchFmini());
            this.produitsLaboratoire.setProlabFourchetteMax((double)this.produitsFourchette.getProfchFmaxi());
         } else {
            this.produitsLaboratoire.setProlabFourchette("");
            this.produitsLaboratoire.setProlabFourchetteMin(0.0D);
            this.produitsLaboratoire.setProlabFourchetteMax(0.0D);
         }

         if (this.produitsLaboratoire.getProlabType() != 6) {
            this.examenDetailResultat.setLabresReponseAction(0L);
            this.examenDetailResultat.setLabresUnite(this.produitsLaboratoire.getProlabUnite());
            this.examenDetailResultat.setLabresNorme(this.produitsLaboratoire.getProlabNorme());
            this.examenDetailResultat.setLabresTechnique(this.produitsLaboratoire.getProlabTechnique());
            this.examenDetailResultat.setLabresCoef(this.produitsLaboratoire.getProlabCoef());
            this.examenDetailResultat.setLabresUniteConvertie(this.produitsLaboratoire.getProlabUniteConv());
            this.examenDetailResultat.setLabresFourchetteMin(this.produitsLaboratoire.getProlabFourchetteMin());
            this.examenDetailResultat.setLabresFourchetteMax(this.produitsLaboratoire.getProlabFourchetteMax());
            this.examenDetailResultat.setLabresFourchette(this.produitsLaboratoire.getProlabFourchette());
         } else {
            this.examenDetailResultat.setLabresNorme("");
            this.examenDetailResultat.setLabresTechnique("");
            this.examenDetailResultat.setLabresCoef(0.0F);
            this.examenDetailResultat.setLabresUniteConvertie("");
            this.examenDetailResultat.setLabresFourchetteMin(0.0D);
            this.examenDetailResultat.setLabresFourchetteMax(0.0D);
            this.examenDetailResultat.setLabresFourchette("");
         }

         if (this.produitsLaboratoire.getProlabConclusion() == 1 && (this.examenDetailResultat.getLabresCommentaire() == null || this.examenDetailResultat.getLabresCommentaire().isEmpty())) {
            this.examenDetailResultat.setLabresCommentaire(this.produitsLaboratoire.getProlabConclusionDef());
         }

         if (this.examenDetailResultat.getLabresType() == 5) {
            this.lesReponsesItemsDetail.clear();
            this.lesReponsesItemsDetail = this.produitsReponseDao.chargeProdReponseByProdItems(this.examenDetailResultat.getLabresCode(), var1);
         } else if (this.examenDetailResultat.getLabresType() == 6) {
            this.lesReponsesItemsDetail = this.produitsReponseDao.chargeProdReponseByProdItems(this.examenDetailResultat.getLabresCode(), var1);
            this.lesActionsItemsDetail.add(new SelectItem("Sans action"));
            this.listeAction = false;
            if (this.examenDetailResultat.getLabresReponseAction() != 0L) {
               this.produitsReponse = this.produitsReponseDao.chargeProdReponseById(this.examenDetailResultat.getLabresReponseAction(), var1);
               if (this.produitsReponse != null) {
                  if (this.produitsReponse.getProrepTexteModifiable() == null || this.produitsReponse.getProrepTexteModifiable().isEmpty()) {
                     this.produitsReponse.setProrepTexteModifiable((String)null);
                  }
               } else {
                  this.produitsReponse = new ProduitsReponse();
                  this.examenDetailResultat.setLabresReponseUnique("");
                  this.examenDetailResultat.setLabresReponseMultiple("");
                  this.produitsReponse.setProrepTexteModifiable((String)null);
               }
            } else {
               this.produitsReponse = new ProduitsReponse();
               this.examenDetailResultat.setLabresReponseUnique("");
               this.examenDetailResultat.setLabresReponseMultiple("");
               this.produitsReponse.setProrepTexteModifiable((String)null);
            }
         } else if (this.examenDetailResultat.getLabresType() == 7) {
            this.lesReponsesItemsDetail.clear();
            this.lesReponsesDetail = this.produitsReponseDao.chargeProdReponseByProd(this.examenDetailResultat.getLabresCode(), var1);
            this.dataModelLesReponsesDetail.setWrappedData(this.lesReponses);
            if (this.examenDetailResultat.getLabresReponseMultiple() != null && !this.examenDetailResultat.getLabresReponseMultiple().isEmpty()) {
               new ProduitsReponse();
               ProduitsReponse var2;
               if (!this.examenDetailResultat.getLabresReponseMultiple().contains("#")) {
                  for(int var6 = 0; var6 < this.lesReponsesDetail.size(); ++var6) {
                     var2 = (ProduitsReponse)this.lesReponsesDetail.get(var6);
                     if (var2.getProrepReponse().equals(this.examenDetailResultat.getLabresReponseMultiple())) {
                        var2.setRep_select(true);
                     }
                  }
               } else {
                  String[] var3 = this.examenDetailResultat.getLabresReponseMultiple().split("#");

                  for(int var4 = 0; var4 < var3.length; ++var4) {
                     for(int var5 = 0; var5 < this.lesReponsesDetail.size(); ++var5) {
                        var2 = (ProduitsReponse)this.lesReponsesDetail.get(var5);
                        if (var2.getProrepReponse().equals(var3[var4])) {
                           var2.setRep_select(true);
                        }
                     }
                  }
               }
            }
         }

         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelDetail = true;
   }

   public void fermerResultatDetail() {
      this.showModalPanelDetail = false;
   }

   public void saveResultatDetail() {
      if (this.examenDetailResultat.getLabresType() == 1) {
         this.examenDetailResultat.setResultat("" + this.examenDetailResultat.getLabresNumerique());
      } else if (this.examenDetailResultat.getLabresType() == 2) {
         this.examenDetailResultat.setResultat("" + this.examenDetailResultat.getLabresDate());
      } else if (this.examenDetailResultat.getLabresType() == 3) {
         this.examenDetailResultat.setResultat("" + this.examenDetailResultat.getLabresImage());
      } else if (this.examenDetailResultat.getLabresType() == 4) {
         this.examenDetailResultat.setResultat("" + this.examenDetailResultat.getLabresTexte());
      } else if (this.examenDetailResultat.getLabresType() == 5) {
         this.examenDetailResultat.setResultat("" + this.examenDetailResultat.getLabresReponseUnique());
      } else if (this.examenDetailResultat.getLabresType() == 6) {
         this.examenDetailResultat.setResultat("" + this.examenDetailResultat.getLabresReponseUnique());
      } else if (this.examenDetailResultat.getLabresType() == 7) {
         this.examenDetailResultat.setResultat("" + this.examenDetailResultat.getLabresReponseMultiple());
      }

      this.showModalPanelDetail = false;
   }

   public void detailPrelevement() throws HibernateException, NamingException {
      if (this.laboratoireEntete != null) {
         this.lesLaboratoire = this.laboratoireLigneDao.selectConsActesByConsEnt(this.laboratoireEntete, (Session)null);
         this.dataModelListeExamens.setWrappedData(this.lesLaboratoire);
         this.var_nom_medecin = this.laboratoireEntete.getLabIdMedecin();
         this.calculMedecinActe();
         if (this.laboratoireEntete.getLabEtat() <= 1) {
            this.var_aff_action = false;
         } else {
            this.var_aff_action = true;
         }

         this.var_memo_action = this.var_action;
         this.var_action = 6;
      }

   }

   public void fermerPrelevement() {
      this.var_action = this.var_memo_action;
   }

   public void savePrelevement() throws HibernateException, NamingException {
      if (this.laboratoireEntete.getLabId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new Users();
            if (this.var_nom_medecin == 0L && this.mesMedecinsItem.size() == 1) {
               this.var_nom_medecin = Long.parseLong(((SelectItem)this.mesMedecinsItem.get(0)).getValue().toString());
            }

            Users var3 = this.usersDao.selectUserD(this.var_nom_medecin, var1);
            if (var3 != null) {
               this.laboratoireEntete.setLabIdMedecin(var3.getUsrid());
               this.laboratoireEntete.setLabMedecin(var3.getUsrPatronyme());
            } else {
               this.laboratoireEntete.setLabIdMedecin(0L);
               this.laboratoireEntete.setLabMedecin("");
            }

            this.laboratoireEntete.setLabDateModif(new Date());
            this.laboratoireEntete.setLabIdModif(this.usersLog.getUsrid());
            this.laboratoireEntete.setLabNomModif(this.usersLog.getUsrPatronyme());
            this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
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

      this.var_action = this.var_memo_action;
   }

   public void clotureResultat() {
      if (this.laboratoireEntete != null) {
         if (this.laboratoireEntete.getLabNomResultat() == null || this.laboratoireEntete.getLabNomResultat().isEmpty()) {
            this.laboratoireEntete.setLabNomResultat(this.laboratoireEntete.getLabMedecin());
         }

         if (this.laboratoireEntete.getLabNomResultat() == null || this.laboratoireEntete.getLabNomResultat().isEmpty()) {
            this.laboratoireEntete.setLabNomResultat(this.usersLog.getUsrPatronyme());
         }

         this.showModalPanelCloture = true;
      }

   }

   public void fermerCloture() {
      this.showModalPanelCloture = false;
   }

   public void valideCloture() throws HibernateException, NamingException, ParseException, IOException {
      if (this.laboratoireEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new ArrayList();
            List var3 = this.laboratoireLigneDao.selectConsActesByConsEnt(this.laboratoireEntete, var1);
            if (var3.size() != 0) {
               new LaboratoireLigne();

               for(int var5 = 0; var5 < var3.size(); ++var5) {
                  LaboratoireLigne var4 = (LaboratoireLigne)var3.get(var5);
                  var4.setLabligEtat(4);
                  this.laboratoireLigneDao.modif(var4, var1);
               }
            }

            String var11 = this.laboratoireEntete.getLabCommentaire();
            String var12 = this.laboratoireEntete.getLabNomResultat();
            this.laboratoireEntete = this.laboratoireEnteteDao.selectById(this.laboratoireEntete.getLabId(), var1);
            if (this.laboratoireEntete != null) {
               this.laboratoireEntete.setLabCloture(1);
               this.laboratoireEntete.setLabCommentaire(var11);
               this.laboratoireEntete.setLabNomResultat(var12);
               this.laboratoireEntete.setLabDateResultat(new Date());
               this.laboratoireEntete.setLabMotifDecloture("");
               this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
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

         this.executerRequetePaillasse();
      }

      this.showModalPanelCloture = false;
   }

   public void deClotureResultat() {
      if (this.laboratoireEntete != null) {
         this.showModalPanelDeCloture = true;
      }

   }

   public void fermerDeCloture() {
      this.showModalPanelDeCloture = false;
   }

   public void valideDeCloture() throws HibernateException, NamingException, ParseException, IOException {
      if (this.laboratoireEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new ArrayList();
            List var3 = this.laboratoireLigneDao.selectConsActesByConsEnt(this.laboratoireEntete, var1);
            if (var3.size() != 0) {
               new LaboratoireLigne();

               for(int var5 = 0; var5 < var3.size(); ++var5) {
                  LaboratoireLigne var4 = (LaboratoireLigne)var3.get(var5);
                  var4.setLabligEtat(1);
                  this.laboratoireLigneDao.modif(var4, var1);
               }
            }

            String var11 = this.laboratoireEntete.getLabMotifDecloture();
            this.laboratoireEntete = this.laboratoireEnteteDao.selectById(this.laboratoireEntete.getLabId(), var1);
            if (this.laboratoireEntete != null) {
               this.laboratoireEntete.setLabCloture(0);
               this.laboratoireEntete.setLabMotifDecloture(var11);
               this.laboratoireEntete.setLabCommentaire("");
               this.laboratoireEntete.setLabNomResultat("");
               this.laboratoireEntete.setLabDateResultat((Date)null);
               this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
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

         this.executerRequetePaillasse();
      }

      this.showModalPanelDeCloture = false;
   }

   public void affichePhotoProduit() throws IOException, SQLException {
      if (this.produits.getProPhoto() != null) {
         this.urlphotoProd = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator + "photo" + File.separator + this.produits.getProPhoto();
      } else {
         this.urlphotoProd = "";
      }

   }

   public void affichePhotoResultat() throws IOException, SQLException {
      if (this.laboratoireLigne.getLabligScan() != null) {
         this.urlphotoResultat = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "paillasse" + File.separator + this.laboratoireLigne.getLabligScan();
      } else {
         this.urlphotoResultat = "";
      }

   }

   public void verifierPdf() {
      this.existPdfFile = this.isExistPdfFile();
   }

   public boolean isExistPdfFile() {
      String var1 = this.laboratoireEntete.getLabNum() + ":" + this.laboratoireLigne.getLabligProduit();
      String var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator + "pdf") + File.separator + var1 + ".pdf";
      File var3 = new File(var2);
      if (var3.exists()) {
         this.existPdfFile = true;
      } else {
         this.existPdfFile = false;
      }

      return this.existPdfFile;
   }

   public void setExistPdfFile(boolean var1) {
      this.existPdfFile = var1;
   }

   public void readPdfFile() throws IOException {
      String var1 = this.laboratoireEntete.getLabNum() + ":" + this.laboratoireLigne.getLabligProduit();
      BufferedInputStream var2 = null;
      BufferedOutputStream var3 = null;
      FacesContext var4 = FacesContext.getCurrentInstance();
      HttpServletResponse var5 = (HttpServletResponse)var4.getExternalContext().getResponse();
      String var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator + "pdf") + File.separator + var1 + ".pdf";
      File var7 = new File(var6);
      if (var7.exists()) {
         try {
            var2 = new BufferedInputStream(new FileInputStream(var7), 10240);
            var5.reset();
            var5.setContentType("application/pdf");
            var5.addHeader("Content-disposition", "attachment; filename=" + var7.getName());
            var5.setContentLength((int)var7.length());
            var3 = new BufferedOutputStream(var5.getOutputStream(), 10240);
            byte[] var8 = new byte[10240];

            while(true) {
               int var9;
               if ((var9 = var2.read(var8)) <= 0) {
                  var3.flush();
                  break;
               }

               var3.write(var8, 0, var9);
            }
         } finally {
            close(var3);
            close(var2);
         }

         var4.responseComplete();
      }

   }

   private static void close(Closeable var0) {
      if (var0 != null) {
         try {
            var0.close();
         } catch (IOException var2) {
            var2.printStackTrace();
         }
      }

   }

   public void ajoutPhoto() throws IOException, JDOMException, HibernateException, NamingException {
      String var1 = this.laboratoireEntete.getLabNum() + ":" + this.laboratoireLigne.getLabligProduit();
      FacesContext var2 = FacesContext.getCurrentInstance();

      try {
         if (this.uploadedFile != null) {
            String var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator + "photo") + File.separator + var1;
            File var4 = new File(var3);
            if (var4.exists()) {
               var4.delete();
            }

            String var5 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
            String var6 = var5.substring(var5.indexOf(".") + 1);
            var5 = var1 + "." + var6;
            File var7 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator + "photo" + File.separator), var5);
            this.utilDownload.write(var7, this.uploadedFile.getInputStream());
            this.fileName = var5;
            var2.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
            this.laboratoireResultat.setLabresImage(var5);
            this.urlphotoProd = "structure" + this.structureLog.getStrid() + "/photos/laboratoire/photo/" + var1;
         }
      } catch (IOException var8) {
         this.produits.setProPhoto(this.fileName);
         var2.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
         var8.printStackTrace();
      }

   }

   public void reInitPhoto() throws HibernateException, NamingException {
      String var1 = this.laboratoireEntete.getLabNum() + ":" + this.laboratoireLigne.getLabligProduit();
      String var2 = "";
      int var3 = var1.lastIndexOf(46);
      if (0 < var3 && var3 <= var1.length() - 2) {
         var2 = "." + var1.substring(var3 + 1);
      }

      String var4 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator + "photo") + File.separator + var1 + var2;
      File var5 = new File(var4);
      if (var5.exists()) {
         var5.delete();
      }

      this.laboratoireResultat.setLabresImage((String)null);
   }

   public void submitPDF() throws IOException, JDOMException, HibernateException, NamingException {
      String var1 = this.laboratoireEntete.getLabNum() + ":" + this.laboratoireLigne.getLabligProduit();
      if (this.uploadedPDFFile != null) {
         FacesContext var2 = FacesContext.getCurrentInstance();
         String var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator + "pdf") + File.separator + var1 + ".pdf";
         File var4 = new File(var3);
         if (var4.exists()) {
            var4.delete();
         }

         try {
            String var5 = this.utilDownload.trimFilePath(this.uploadedPDFFile.getName().trim());
            String var6 = var5.substring(var5.indexOf(".") + 1);
            var5 = var1 + "." + var6;
            File var7 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator + "pdf" + File.separator), var5);
            this.utilDownload.write(var7, this.uploadedPDFFile.getInputStream());
            this.pdfFileName = var5;
            var2.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
            this.laboratoireResultat.setLabresPdf(var5);
         } catch (IOException var8) {
            var2.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var8.printStackTrace();
         }
      }

   }

   public void reInitPDF() throws HibernateException, NamingException {
      String var1 = this.laboratoireEntete.getLabNum() + ":" + this.laboratoireLigne.getLabligProduit();
      this.laboratoireResultat.setLabresPdf((String)null);
      String var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator + "pdf") + File.separator + var1 + ".pdf";
      File var3 = new File(var2);
      if (var3.exists()) {
         var3.delete();
      }

   }

   public void ajoutScanResultat() throws IOException, JDOMException, HibernateException, NamingException {
      String var1 = this.laboratoireEntete.getLabNum().replace("/", "-") + ":" + this.laboratoireLigne.getLabligProduit();
      FacesContext var2 = FacesContext.getCurrentInstance();

      try {
         if (this.uploadedFile != null) {
            String var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "paillasse") + File.separator;
            File var4 = new File(var3);
            if (!var4.exists()) {
               var4.mkdir();
            }

            String var5 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "paillasse") + File.separator + var1;
            File var6 = new File(var5);
            if (var6.exists()) {
               var6.delete();
            }

            String var7 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
            String var8 = var7.substring(var7.indexOf(".") + 1);
            var7 = var1 + "." + var8;
            File var9 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "paillasse" + File.separator), var7);
            this.utilDownload.write(var9, this.uploadedFile.getInputStream());
            this.fileName = var7;
            var2.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
            this.urlphotoResultat = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "paillasse" + File.separator + "photo" + File.separator + var1;
            this.laboratoireLigne.setLabligScan(var7);
            this.laboratoireLigne = this.laboratoireLigneDao.modif(this.laboratoireLigne);
         }
      } catch (IOException var10) {
         var2.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
         var10.printStackTrace();
      }

   }

   public void reInitScanResultat() throws HibernateException, NamingException {
      if (this.laboratoireLigne.getLabligScan() != null && !this.laboratoireLigne.getLabligScan().isEmpty()) {
         String var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "paillasse") + File.separator + this.laboratoireLigne.getLabligScan();
         File var2 = new File(var1);
         if (var2.exists()) {
            var2.delete();
         }

         this.laboratoireLigne.setLabligScan((String)null);
         this.laboratoireLigne = this.laboratoireLigneDao.modif(this.laboratoireLigne);
      }

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
      if (this.laboratoireEntete != null && this.uploadedPDFFile != null) {
         File var1 = new File(this.nomRepertoire + this.laboratoireEntete.getLabNum());
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
               var3 = this.laboratoireEntete.getLabNum().replace("/", "_") + "_" + this.filtreCaracteres(this.nomDocument) + "." + var4;
            } else {
               var3 = this.laboratoireEntete.getLabNum().replace("/", "_") + "." + var4;
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
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "laboratoire" + File.separator;
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatLaboratoire.jpg");
            if (var4.exists()) {
               var3 = "formatLaboratoire.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatLaboratoire.jpg");
         if (var4.exists()) {
            var3 = "formatLaboratoire.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      if (this.lesLaboratoire.size() != 0) {
         for(int var2 = 0; var2 < this.lesLaboratoire.size(); ++var2) {
            this.laboratoireLigne = (LaboratoireLigne)this.lesLaboratoire.get(var2);
            this.laboratoireLigne.setLaboratoireEntete(this.laboratoireEntete);
            var1.add(this.laboratoireLigne);
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.laboratoireEntete.getTotalPatient(), this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(var1);
      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionRemboursementCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      double var2 = 0.0D;
      if (this.lesLaboratoire.size() != 0) {
         for(int var4 = 0; var4 < this.lesLaboratoire.size(); ++var4) {
            this.laboratoireLigne = (LaboratoireLigne)this.lesLaboratoire.get(var4);
            if (this.laboratoireLigne.getLabligQte() < 0.0F) {
               var2 += this.laboratoireLigne.getLabligPatientHt() + this.laboratoireLigne.getLabligPatientTaxe();
               var1.add(this.laboratoireLigne);
            }
         }
      }

      this.montant_lettre = this.utilNombre.begin(var2, this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var5 = new JRBeanCollectionDataSource(var1);
      return var5;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      return var2;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.laboratoireEntete.getLabDateImp() != null && this.laboratoireEntete.getLabEtat() != 0) {
            var2 = true;
         }

         this.laboratoireEntete.setLabDateImp(new Date());
         if (this.laboratoireEntete.getLabEtat() == 0 && this.laboratoireEntete.getLabEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 0) {
            this.laboratoireEntete.setLabEtat(1);
         }

         this.laboratoireEntete.setLabModeleImp(var1);
         this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var3);
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
               var1.setjRBeanCollectionDataSource(this.calculeImpressionRemboursementCommun());
            } else {
               var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            }

            var1.setRapport(var3);
            var1.setEntete("Impression laboratoire");
            var1.setMontant_lettre(this.montant_lettre);
            var1.setPageGarde(this.conversionGarde());
            var1.setAnnexe1(this.conversionAnnexe1());
            var1.setAnnexe2(this.conversionAnnexe2());
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.laboratoireEntete.getLabEtat()));
            var1.setDuplicata("" + var11);
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.laboratoireEntete.getLabIdMedecin());
            var1.setIdCommercial(this.laboratoireEntete.getLabIdCreateur());
            var1.setTiersSelectionne((Tiers)null);
            var1.setNumDoc(this.laboratoireEntete.getLabNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.laboratoireEntete.getLabId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des examens de laboratoire");
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "laboratoire" + File.separator);
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

   public String calculeCheminRapportPaillasse(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "paillasse" + File.separator;
      return var2;
   }

   public boolean majDateImpressionPaillasse(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.laboratoireEntete.getLabDateImp() != null && this.laboratoireEntete.getLabEtat() != 0) {
            var2 = true;
         }

         this.laboratoireEntete.setLabDateImp(new Date());
         if (this.laboratoireEntete.getLabEtat() == 0 && this.laboratoireEntete.getLabEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 0) {
            this.laboratoireEntete.setLabEtat(1);
         }

         this.laboratoireEntete.setLabModeleImpResultat(var1);
         this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var3);
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

   public String calculeImageFondPaillasse(String var1, int var2) throws HibernateException, NamingException {
      String var3 = "";
      if (var2 == 0) {
         File var4 = new File(this.calculeCheminSousRapport(var1) + "formatNonCloture.jpg");
         if (var4.exists()) {
            var3 = "formatNonCloture.jpg";
         }
      }

      return var3;
   }

   public double calculeAge(Date var1, Date var2) throws ParseException {
      double var3 = 0.0D;
      if (var1 != null && var2 != null) {
         byte var5 = 1;
         byte var6 = 12;
         boolean var7 = false;
         boolean var8 = false;
         long var9 = 0L;
         Calendar var11 = Calendar.getInstance();
         Calendar var12 = Calendar.getInstance();
         Calendar var13 = Calendar.getInstance();
         var11.setTime(var1);
         var12.setTime(this.utilDate.dateDernierJourMois(var2));
         int var15 = 0;

         while(true) {
            do {
               if (!var11.before(var12)) {
                  int var14 = var15 / var6;
                  var15 -= var14 * var6;
                  var13 = Calendar.getInstance();
                  var13.setTime(var1);
                  var13.add(1, var14);
                  var13.add(2, var15);
                  var9 = (var12.getTimeInMillis() - var13.getTimeInMillis()) / 86400000L;
                  var3 = (double)this.utilNombre.myRound((float)var14, 2);
                  return var3;
               }

               var11.add(2, var5);
            } while(!var11.before(var12) && !var11.equals(var12));

            ++var15;
         }
      } else {
         var3 = 0.0D;
         return var3;
      }
   }

   public ProduitsFourchette calculeFourchette(String var1, long var2, Session var4) throws HibernateException, NamingException, ParseException {
      ProduitsFourchette var5 = new ProduitsFourchette();
      new ArrayList();
      List var6;
      if (var2 != 0L) {
         var6 = this.produitsFourchetteDao.chargeProdFourchetteByDet(var2, var4);
      } else {
         var6 = this.produitsFourchetteDao.chargeProdFourchetteByProd(var1, var4);
      }

      if (var6.size() != 0) {
         for(int var7 = 0; var7 < var6.size(); ++var7) {
            this.produitsFourchette = (ProduitsFourchette)var6.get(var7);
            double var8;
            if (this.produitsFourchette.getProfchSexe() == 2) {
               if (this.produitsFourchette.getProfchAge() == 0 || this.patients.getPatDateNaissance() == null) {
                  var5 = this.produitsFourchette;
                  break;
               }

               var8 = this.calculeAge(this.patients.getPatDateNaissance(), this.laboratoireEntete.getLabDate());
               if (var8 >= (double)this.produitsFourchette.getProfchAgeDebut() && var8 <= (double)this.produitsFourchette.getProfchAgeFin()) {
                  var5 = this.produitsFourchette;
                  break;
               }
            } else if (this.produitsFourchette.getProfchSexe() == 0 && this.patients.getPatSexe() == 0) {
               if (this.produitsFourchette.getProfchAge() == 0 || this.patients.getPatDateNaissance() == null) {
                  var5 = this.produitsFourchette;
                  break;
               }

               var8 = this.calculeAge(this.patients.getPatDateNaissance(), this.laboratoireEntete.getLabDate());
               if (var8 >= (double)this.produitsFourchette.getProfchAgeDebut() && var8 <= (double)this.produitsFourchette.getProfchAgeFin()) {
                  var5 = this.produitsFourchette;
                  break;
               }
            } else if (this.produitsFourchette.getProfchSexe() == 1 && this.patients.getPatSexe() == 1) {
               if (this.produitsFourchette.getProfchAge() == 0 || this.patients.getPatDateNaissance() == null) {
                  var5 = this.produitsFourchette;
                  break;
               }

               var8 = this.calculeAge(this.patients.getPatDateNaissance(), this.laboratoireEntete.getLabDate());
               if (var8 >= (double)this.produitsFourchette.getProfchAgeDebut() && var8 <= (double)this.produitsFourchette.getProfchAgeFin()) {
                  var5 = this.produitsFourchette;
                  break;
               }
            }
         }
      }

      return var5;
   }

   public JRBeanCollectionDataSource calculeImpressionPaillasse() throws IOException, HibernateException, NamingException, ParseException {
      ArrayList var1 = new ArrayList();
      new ArrayList();
      if (this.laboratoireEntete != null) {
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         this.lesLaboratoire = this.laboratoireLigneDao.selectConsActesByConsEnt(this.laboratoireEntete, var3);
         this.patients = this.laboratoireEntete.getPatients();
         String var4 = "";
         if (this.lesLaboratoire.size() != 0) {
            new LaboratoireResultat();
            int var6 = 0;

            while(true) {
               LaboratoireResultat var5;
               int var7;
               if (var6 >= this.lesLaboratoire.size()) {
                  String var22 = "";

                  for(var7 = var1.size() - 1; var7 >= 0; --var7) {
                     var5 = (LaboratoireResultat)var1.get(var7);
                     if (var22 != null && !var22.isEmpty() && var5.getLabresCode() != null && !var5.getLabresCode().isEmpty() && var22.equals(var5.getLabresCode())) {
                        var5.setLabInterpretation("");
                        var5.setLabInterpretationTexte("");
                        var5.setConclusionAuto("");
                        var5.setLabScan("");
                     }

                     var22 = var5.getLabresCode();
                  }

                  LaboratoireLigne var23 = new LaboratoireLigne();
                  var23.setLaboratoireEntete(this.laboratoireEntete);
                  var5 = new LaboratoireResultat();
                  var5.setLaboratoireLigne(var23);
                  var5.setLabAnomyme(this.laboratoireEntete.isLabAnonyme());
                  var5.setLabCivilite(this.laboratoireEntete.getLabCivilite());
                  var5.setCiviliteLaboratoire(var4);
                  var5.setLabDate(this.laboratoireEntete.getLabDate());
                  var5.setLabDatePrelevement(this.laboratoireEntete.getLabDatePrelevement());
                  var5.setLabDateRegles(this.laboratoireEntete.getLabDateRegles());
                  var5.setLabDateResultat(this.laboratoireEntete.getLabDateResultat());
                  var5.setLabDossier(this.laboratoireEntete.getPatients().getPatDossier());
                  var5.setLabLaboratoire(this.laboratoireEntete.getLabLaboratoire());
                  var5.setLabLieuPrelevement(this.laboratoireEntete.getLabLieuPrelevement());
                  var5.setLabMedecin(this.laboratoireEntete.getLabMedecin());
                  var5.setLabNomPatient(this.laboratoireEntete.getLabNomPatient());
                  var5.setLabNum(this.laboratoireEntete.getLabNum());
                  var5.setLabNumBc(this.laboratoireEntete.getLabNumBc());
                  var5.setLabNumHospit(this.laboratoireEntete.getLabNumHospit());
                  var5.setLabPartenaire("" + this.laboratoireEntete.getLabPartenaire());
                  var5.setLabPathologie(this.laboratoireEntete.getLabPathologie());
                  var5.setLabPrescripteur(this.laboratoireEntete.getLabPrescripteur());
                  var5.setLabProtocole(this.laboratoireEntete.getLabProtocole());
                  var5.setLabService(this.laboratoireEntete.getLabService());
                  var5.setLabCommentaire(this.laboratoireEntete.getLabCommentaire());
                  var5.setLabNomResultat(this.laboratoireEntete.getLabNomResultat());
                  var5.setLabDateNaissance(this.laboratoireEntete.getPatients().getPatDateNaissance());
                  var5.setLabGenre(this.laboratoireEntete.getPatients().getGenre());
                  var5.setLabresFourchette("");
                  var5.setLabresFourchetteMin(0.0D);
                  var5.setLabresFourchetteMax(0.0D);
                  var5.setLabresUnite("");
                  var5.setLabInterpretation("");
                  var5.setConclusionAuto("");
                  var5.setLabresCategorie("ZZZZZZZZ");
                  var5.setLabresOrdre(9999999);
                  var5.setHistorique("");
                  if (this.laboratoireEntete.getLabCommentaire() != null && !this.laboratoireEntete.getLabCommentaire().isEmpty()) {
                     var5.setLabresType(160);
                  } else {
                     var5.setLabresType(150);
                  }

                  var1.add(var5);
                  break;
               }

               this.laboratoireLigne = (LaboratoireLigne)this.lesLaboratoire.get(var6);
               List var2 = this.laboratoireResultatDao.selectResultatListe(this.laboratoireLigne, var3);
               if (var2.size() != 0) {
                  for(var7 = 0; var7 < var2.size(); ++var7) {
                     var5 = (LaboratoireResultat)var2.get(var7);
                     var5.setLabAnomyme(this.laboratoireEntete.isLabAnonyme());
                     var5.setLabCivilite(this.laboratoireEntete.getLabCivilite());
                     double var8 = this.calculeAge(this.patients.getPatDateNaissance(), this.laboratoireEntete.getLabDate());
                     this.patients.setAge((float)var8);
                     if (this.patients.getAge() <= Float.parseFloat(this.optionMedical.getAnneeFinBebe())) {
                        if (this.patients.getPatSexe() == 0) {
                           var4 = "Bébée";
                        } else {
                           var4 = "Bébé";
                        }
                     } else if (this.patients.getAge() > Float.parseFloat(this.optionMedical.getAnneeFinBebe()) && this.patients.getAge() <= Float.parseFloat(this.optionMedical.getAnneeFinEnfant())) {
                        if (this.patients.getPatSexe() == 0) {
                           var4 = "Fille";
                        } else {
                           var4 = "Garçon";
                        }
                     } else if (this.patients.getAge() > Float.parseFloat(this.optionMedical.getAnneeFinEnfant()) && this.patients.getAge() <= Float.parseFloat(this.optionMedical.getAnneeFinAdo())) {
                        if (this.patients.getPatSexe() == 0) {
                           var4 = "Adolescente";
                        } else {
                           var4 = "Adolescent";
                        }
                     } else {
                        var4 = this.laboratoireEntete.getLabCivilite();
                     }

                     var5.setCiviliteLaboratoire(var4);
                     var5.setLabDate(this.laboratoireEntete.getLabDate());
                     var5.setLabDatePrelevement(this.laboratoireEntete.getLabDatePrelevement());
                     var5.setLabDateRegles(this.laboratoireEntete.getLabDateRegles());
                     var5.setLabDateResultat(this.laboratoireEntete.getLabDateResultat());
                     var5.setLabDossier(this.laboratoireEntete.getPatients().getPatDossier());
                     var5.setLabLaboratoire(this.laboratoireEntete.getLabLaboratoire());
                     var5.setLabLieuPrelevement(this.laboratoireEntete.getLabLieuPrelevement());
                     var5.setLabMedecin(this.laboratoireEntete.getLabMedecin());
                     var5.setLabNomPatient(this.laboratoireEntete.getLabNomPatient());
                     var5.setLabNum(this.laboratoireEntete.getLabNum());
                     var5.setLabNumBc(this.laboratoireEntete.getLabNumBc());
                     var5.setLabNumHospit(this.laboratoireEntete.getLabNumHospit());
                     var5.setLabPartenaire("" + this.laboratoireEntete.getLabPartenaire());
                     var5.setLabPathologie(this.laboratoireEntete.getLabPathologie());
                     var5.setLabPrescripteur(this.laboratoireEntete.getLabPrescripteur());
                     var5.setLabProtocole(this.laboratoireEntete.getLabProtocole());
                     var5.setLabService(this.laboratoireEntete.getLabService());
                     var5.setLabCommentaire(this.laboratoireEntete.getLabCommentaire());
                     var5.setLabNomResultat(this.laboratoireEntete.getLabNomResultat());
                     var5.setLabDateNaissance(this.laboratoireEntete.getPatients().getPatDateNaissance());
                     var5.setLabGenre(this.laboratoireEntete.getPatients().getGenre());
                     double var10 = var5.getLabresFourchetteMin();
                     double var12 = var5.getLabresFourchetteMax();
                     String var14 = var5.getLabresFourchette();
                     String var15 = var5.getLabresUnite();
                     var5.setLabresFourchette("");
                     var5.setLabresFourchetteMin(0.0D);
                     var5.setLabresFourchetteMax(0.0D);
                     var5.setLabresUnite("");
                     var5.setLabInterpretation("");
                     var5.setLabInterpretationTexte("");
                     var5.setConclusionAuto("");
                     var5.setHistorique("");
                     this.produits = this.produitsMedicDao.chargeProduit(((LaboratoireResultat)var2.get(var7)).getLabresCode(), var3);
                     if (this.produits != null) {
                        this.produitsLaboratoire = this.produitsLaboratoireDao.chargeProdLaboratoireByProd(this.produits.getProId(), var3);
                        if (this.produitsLaboratoire != null) {
                           var5.setConclusionAuto(this.produitsLaboratoire.getProlabConclusionDef());
                           String var16 = "";
                           File var17;
                           if (this.produitsLaboratoire.getProlabInterpretation() != null && !this.produitsLaboratoire.getProlabInterpretation().isEmpty()) {
                              var16 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator + "interpretation" + File.separator;
                              var17 = new File(var16 + this.produitsLaboratoire.getProlabInterpretation());
                              if (var17.exists()) {
                                 var5.setLabInterpretation(var16 + this.produitsLaboratoire.getProlabInterpretation());
                              } else {
                                 var5.setLabInterpretation("");
                              }
                           } else {
                              var5.setLabInterpretation("");
                           }

                           if (this.produitsLaboratoire.getProlabInterpretaionTexte() != null && !this.produitsLaboratoire.getProlabInterpretaionTexte().isEmpty()) {
                              var5.setLabInterpretationTexte(this.produitsLaboratoire.getProlabInterpretaionTexte());
                           } else {
                              var5.setLabInterpretationTexte("");
                           }

                           var16 = "";
                           if (this.laboratoireLigne.getLabligScan() != null && !this.laboratoireLigne.getLabligScan().isEmpty()) {
                              var16 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "paillasse" + File.separator;
                              var17 = new File(var16 + this.laboratoireLigne.getLabligScan());
                              if (var17.exists()) {
                                 var5.setLabScan(var16 + this.laboratoireLigne.getLabligScan());
                              } else {
                                 var5.setLabScan("");
                              }
                           } else {
                              var5.setLabScan("");
                           }

                           int var19;
                           List var24;
                           if (this.produitsLaboratoire.getProlabType() == 1) {
                              if (var14 != null && var14.isEmpty()) {
                                 var5.setLabresFourchette(var14);
                                 var5.setLabresFourchetteMin(var10);
                                 var5.setLabresFourchetteMax(var12);
                                 var5.setLabresUnite(var15);
                              } else {
                                 this.produitsFourchette = this.calculeFourchette(this.produits.getProCode(), 0L, var3);
                                 var5.setLabresFourchette(this.produitsFourchette.getProfchNorme());
                                 var5.setLabresFourchetteMin((double)this.produitsFourchette.getProfchFmini());
                                 var5.setLabresFourchetteMax((double)this.produitsFourchette.getProfchFmaxi());
                                 var5.setLabresUnite(this.produitsLaboratoire.getProlabUnite());
                              }

                              new ArrayList();
                              var24 = this.laboratoireResultatDao.selectHistorique(this.patients.getPatId(), var5.getLabresId(), this.produits.getProCode(), var3);
                              if (var24.size() != 0) {
                                 new LaboratoireResultat();

                                 for(var19 = 0; var19 < var24.size(); ++var19) {
                                    LaboratoireResultat var25 = (LaboratoireResultat)var24.get(var19);
                                    if (var25.getLaboratoireLigne().getLabligDateRealisee() != null) {
                                       var5.setHistorique(this.utilDate.dateToStringFrComplet(var25.getLaboratoireLigne().getLabligDateRealisee()) + " = " + var25.getLabresNumerique());
                                    } else {
                                       var5.setHistorique("Antérieur  " + var25.getLabresNumerique());
                                    }

                                    if (var19 >= 5) {
                                       break;
                                    }
                                 }
                              }
                           } else if (this.produitsLaboratoire.getProlabType() == 8) {
                              new ArrayList();
                              var24 = this.produitsDetailDao.chargeProdDetailByProd(this.produits.getProCode(), var3);
                              if (var24.size() != 0) {
                                 new ProduitsDetail();

                                 for(var19 = 0; var19 < var24.size(); ++var19) {
                                    ProduitsDetail var18 = (ProduitsDetail)var24.get(var19);
                                    if (var5.getLabresIdProdDet() == var18.getProdetId()) {
                                       var16 = "";
                                       if (var18.getProdetInterpretation() != null && !var18.getProdetInterpretation().isEmpty()) {
                                          var16 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator + "interpretation" + File.separator;
                                          File var20 = new File(var16 + var18.getProdetInterpretation());
                                          if (var20.exists()) {
                                             var5.setLabInterpretation(var16 + var18.getProdetInterpretation());
                                          } else {
                                             var5.setLabInterpretation("");
                                          }
                                       } else {
                                          var5.setLabInterpretation("");
                                       }

                                       if (var18.getProdetInterpretationTexte() != null && !var18.getProdetInterpretationTexte().isEmpty()) {
                                          var5.setLabInterpretationTexte(var18.getProdetInterpretationTexte());
                                       } else {
                                          var5.setLabInterpretationTexte("");
                                       }

                                       if (var18.getProdetType() == 1) {
                                          if (var14 != null && var14.isEmpty()) {
                                             var5.setLabresFourchette(var14);
                                             var5.setLabresFourchetteMin(var10);
                                             var5.setLabresFourchetteMax(var12);
                                             var5.setLabresUnite(var15);
                                          } else {
                                             this.produitsFourchette = this.calculeFourchette(this.produits.getProCode(), var18.getProdetId(), var3);
                                             var5.setLabresFourchette(this.produitsFourchette.getProfchNorme());
                                             var5.setLabresFourchetteMin((double)this.produitsFourchette.getProfchFmini());
                                             var5.setLabresFourchetteMax((double)this.produitsFourchette.getProfchFmaxi());
                                             var5.setLabresUnite(var18.getProdetUnite());
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }

                     var1.add(var5);
                  }
               }

               ++var6;
            }
         }

         this.utilInitHibernate.closeSession();
      }

      JRBeanCollectionDataSource var21 = new JRBeanCollectionDataSource(var1);
      return var21;
   }

   public void initImpressionResultat(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10) throws SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var2 == 0) {
         if (var3 != null && !var3.isEmpty()) {
            boolean var11 = this.majDateImpressionPaillasse(var3);
            var1.setjRBeanCollectionDataSource(this.calculeImpressionPaillasse());
            var1.setRapport(var3);
            var1.setEntete("Impression paillasse");
            var1.setMontant_lettre(this.montant_lettre);
            var1.setPageGarde(this.conversionGarde());
            var1.setAnnexe1(this.conversionAnnexe1());
            var1.setAnnexe2(this.conversionAnnexe2());
            var1.setCheminRapport(this.calculeCheminRapportPaillasse("structure" + this.structureLog.getStrid()));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFondPaillasse("structure" + this.structureLog.getStrid(), this.laboratoireEntete.getLabCloture()));
            var1.setDuplicata("" + var11);
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.laboratoireEntete.getLabIdMedecin());
            var1.setIdCommercial(this.laboratoireEntete.getLabIdCreateur());
            var1.setTiersSelectionne((Tiers)null);
            var1.setNature(this.nature);
            var1.setId_doc(this.laboratoireEntete.getLabId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la paillasse");
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "paillasse" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "sous_rapport" + File.separator);
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
         JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(this.lesConsultationEntete);
         var1.setjRBeanCollectionDataSource(var12);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

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
            this.uniteGraph = "LABORATOIRE : Chiffre d'Affaire en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else {
            this.uniteGraph = "LABORATOIRE  : Quantites";
            this.deviseGraph = "";
            this.nbDecGraph = 0;
         }

         this.titreGraph = "Analyse du laboratoire : ";
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
         }

         new LaboratoireEntete();
         new LaboratoireLigne();
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         String var6 = "";

         LaboratoireEntete var14;
         for(int var7 = 0; var7 < this.lesConsultationEntete.size(); ++var7) {
            var14 = (LaboratoireEntete)this.lesConsultationEntete.get(var7);
            if (var6.isEmpty()) {
               var6 = "'" + var14.getLabNum() + "'";
            } else {
               var6 = var6 + ",'" + var14.getLabNum() + "'";
            }
         }

         int var11;
         if (this.modeGraph == 20) {
            new ArrayList();
            List var20 = this.laboratoireLigneDao.chargerLesLignesActes(var6, var5);
            if (var20.size() != 0) {
               String var18 = "";
               long var9 = 0L;
               boolean var17 = false;
               new LaboratoireLigne();
               int var13 = 0;

               while(true) {
                  if (var13 >= var20.size()) {
                     var1 = this.calculePourcentage((List)var1);
                     break;
                  }

                  LaboratoireLigne var19 = (LaboratoireLigne)var20.get(var13);
                  var18 = "";
                  var9 = 0L;
                  var11 = 0;
                  if (var19.getLabligLibelle() == null || var19.getLabligLibelle().isEmpty()) {
                     var19.setLabligLibelle("ERREUR LIBELLE");
                  }

                  var18 = var19.getLabligLibelle();
                  if (this.valQteGraph == 0) {
                     var9 = (long)var19.getLabligTotal();
                  } else {
                     var9 = (long)this.utilNombre.myRound(var19.getLabligQte(), 1);
                  }

                  if (this.timeDecoupage == 0) {
                     var11 = var19.getLaboratoireEntete().getLabDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var11 = var19.getLaboratoireEntete().getLabDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var19.getLaboratoireEntete().getLabDate().getMonth() + 1 >= 1 && var19.getLaboratoireEntete().getLabDate().getMonth() + 1 <= 3) {
                        var11 = 1;
                     } else if (var19.getLaboratoireEntete().getLabDate().getMonth() + 1 >= 4 && var19.getLaboratoireEntete().getLabDate().getMonth() + 1 <= 6) {
                        var11 = 2;
                     } else if (var19.getLaboratoireEntete().getLabDate().getMonth() + 1 >= 7 && var19.getLaboratoireEntete().getLabDate().getMonth() + 1 <= 9) {
                        var11 = 3;
                     } else if (var19.getLaboratoireEntete().getLabDate().getMonth() + 1 >= 10 && var19.getLaboratoireEntete().getLabDate().getMonth() + 1 <= 12) {
                        var11 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var19.getLaboratoireEntete().getLabDate().getMonth() + 1 >= 1 && var19.getLaboratoireEntete().getLabDate().getMonth() + 1 <= 6) {
                        var11 = 1;
                     } else if (var19.getLaboratoireEntete().getLabDate().getMonth() + 1 >= 7 && var19.getLaboratoireEntete().getLabDate().getMonth() + 1 <= 12) {
                        var11 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var11 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var11 = var19.getLaboratoireEntete().getLabDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var18, var11, var9);
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

               var14 = (LaboratoireEntete)this.lesConsultationEntete.get(var11);
               var15 = "";
               var8 = 0L;
               int var16 = 0;
               if (this.modeGraph == 0) {
                  int var12 = var14.getLabDate().getYear() + 1900;
                  var15 = "" + var12;
                  var8 = (long)var14.getLabTotGeneral();
               } else if (this.modeGraph == 1) {
                  if (var14.getLabMedecin() != null && !var14.getLabMedecin().isEmpty()) {
                     var15 = var14.getLabMedecin();
                  } else {
                     var15 = "Sans médecin";
                  }

                  var8 = (long)var14.getLabTotGeneral();
               } else if (this.modeGraph == 2) {
                  if (var14.getLabPrescripteur() != null && !var14.getLabPrescripteur().isEmpty()) {
                     var15 = var14.getLabPrescripteur();
                  } else {
                     var15 = "Sans prescripteur";
                  }

                  var8 = (long)var14.getLabTotGeneral();
               } else if (this.modeGraph == 3) {
                  if (var14.getLabNomPatient() != null && !var14.getLabNomPatient().isEmpty()) {
                     var15 = var14.getLabNomPatient();
                  } else {
                     var15 = "Sans patient";
                  }

                  var8 = (long)var14.getLabTotPatient();
               } else if (this.modeGraph == 4) {
                  if (var14.getLabNomAssurance() != null && !var14.getLabNomAssurance().isEmpty()) {
                     var15 = var14.getLabNomAssurance();
                  } else {
                     var15 = "Sans assurance";
                  }

                  var8 = (long)var14.getLabTotAssurance();
               } else if (this.modeGraph == 5) {
                  if (var14.getLabNomComplemtaire() != null && !var14.getLabNomComplemtaire().isEmpty()) {
                     var15 = var14.getLabNomComplemtaire();
                  } else {
                     var15 = "Sans complémentaire";
                  }

                  var8 = (long)var14.getLabTotComplmentaire();
               } else if (this.modeGraph == 6) {
                  if (var14.getLabNomSociete() != null && !var14.getLabNomSociete().isEmpty()) {
                     var15 = var14.getLabNomSociete();
                  } else {
                     var15 = "Sans société";
                  }

                  var8 = (long)var14.getLabTotSociete();
               } else if (this.modeGraph == 8) {
                  if (var14.getLabProtocole() != null && !var14.getLabProtocole().isEmpty()) {
                     var15 = var14.getLabProtocole();
                  } else {
                     var15 = "Sans protocole";
                  }

                  var8 = (long)var14.getLabTotGeneral();
               } else if (this.modeGraph == 9) {
                  if (var14.getLabPathologie() != null && !var14.getLabPathologie().isEmpty()) {
                     var15 = var14.getLabPathologie();
                  } else {
                     var15 = "Sans pathologie";
                  }

                  var8 = (long)var14.getLabTotGeneral();
               } else if (this.modeGraph == 10) {
                  if (var14.getLabService() != null && !var14.getLabService().isEmpty()) {
                     var15 = var14.getLabService();
                  } else {
                     var15 = "Sans service";
                  }

                  var8 = (long)var14.getLabTotGeneral();
               }

               if (this.timeDecoupage == 0) {
                  var16 = var14.getLabDate().getDate();
               } else if (this.timeDecoupage == 1) {
                  var16 = var14.getLabDate().getMonth() + 1;
               } else if (this.timeDecoupage == 2) {
                  if (var14.getLabDate().getMonth() + 1 >= 1 && var14.getLabDate().getMonth() + 1 <= 3) {
                     var16 = 1;
                  } else if (var14.getLabDate().getMonth() + 1 >= 4 && var14.getLabDate().getMonth() + 1 <= 6) {
                     var16 = 2;
                  } else if (var14.getLabDate().getMonth() + 1 >= 7 && var14.getLabDate().getMonth() + 1 <= 9) {
                     var16 = 3;
                  } else if (var14.getLabDate().getMonth() + 1 >= 10 && var14.getLabDate().getMonth() + 1 <= 12) {
                     var16 = 4;
                  }
               } else if (this.timeDecoupage == 3) {
                  if (var14.getLabDate().getMonth() + 1 >= 1 && var14.getLabDate().getMonth() + 1 <= 6) {
                     var16 = 1;
                  } else if (var14.getLabDate().getMonth() + 1 >= 7 && var14.getLabDate().getMonth() + 1 <= 12) {
                     var16 = 2;
                  }
               } else if (this.timeDecoupage == 4) {
                  var16 = 1;
               } else if (this.timeDecoupage == 5) {
                  var16 = var14.getLabDate().getHours();
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

   public LaboratoireEntete getLaboratoireEntete() {
      return this.laboratoireEntete;
   }

   public void setLaboratoireEntete(LaboratoireEntete var1) {
      this.laboratoireEntete = var1;
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

   public LaboratoireLigne getLaboratoireLigne() {
      return this.laboratoireLigne;
   }

   public void setLaboratoireLigne(LaboratoireLigne var1) {
      this.laboratoireLigne = var1;
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

   public DataModel getDataModelLaboratoire() {
      return this.dataModelLaboratoire;
   }

   public void setDataModelLaboratoire(DataModel var1) {
      this.dataModelLaboratoire = var1;
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

   public LaboratoireResultat getLaboratoireResultat() {
      return this.laboratoireResultat;
   }

   public void setLaboratoireResultat(LaboratoireResultat var1) {
      this.laboratoireResultat = var1;
   }

   public ProduitsLaboratoire getProduitsLaboratoire() {
      return this.produitsLaboratoire;
   }

   public void setProduitsLaboratoire(ProduitsLaboratoire var1) {
      this.produitsLaboratoire = var1;
   }

   public String getUrlphotoProd() {
      return this.urlphotoProd;
   }

   public void setUrlphotoProd(String var1) {
      this.urlphotoProd = var1;
   }

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
   }

   public UploadedFile getUploadedPDFFile() {
      return this.uploadedPDFFile;
   }

   public void setUploadedPDFFile(UploadedFile var1) {
      this.uploadedPDFFile = var1;
   }

   public boolean isVar_affFicPdf() {
      if (this.laboratoireResultat.getLabresPdf() != null && !this.laboratoireResultat.getLabresPdf().isEmpty()) {
         this.var_affFicPdf = true;
      } else {
         this.var_affFicPdf = false;
      }

      return this.var_affFicPdf;
   }

   public void setVar_affFicPdf(boolean var1) {
      this.var_affFicPdf = var1;
   }

   public List getLesAppareilsItems() {
      return this.lesAppareilsItems;
   }

   public void setLesAppareilsItems(List var1) {
      this.lesAppareilsItems = var1;
   }

   public List getLesResulatsHistoriques() {
      return this.lesResulatsHistoriques;
   }

   public void setLesResulatsHistoriques(List var1) {
      this.lesResulatsHistoriques = var1;
   }

   public List getLesReponsesItems() {
      return this.lesReponsesItems;
   }

   public void setLesReponsesItems(List var1) {
      this.lesReponsesItems = var1;
   }

   public List getLesActionsItems() {
      return this.lesActionsItems;
   }

   public void setLesActionsItems(List var1) {
      this.lesActionsItems = var1;
   }

   public DataModel getDataModelLesReponses() {
      return this.dataModelLesReponses;
   }

   public void setDataModelLesReponses(DataModel var1) {
      this.dataModelLesReponses = var1;
   }

   public DataModel getDataModelDetailExamens() {
      return this.dataModelDetailExamens;
   }

   public void setDataModelDetailExamens(DataModel var1) {
      this.dataModelDetailExamens = var1;
   }

   public boolean isShowModalPanelDetail() {
      return this.showModalPanelDetail;
   }

   public void setShowModalPanelDetail(boolean var1) {
      this.showModalPanelDetail = var1;
   }

   public LaboratoireResultat getExamenDetailResultat() {
      return this.examenDetailResultat;
   }

   public void setExamenDetailResultat(LaboratoireResultat var1) {
      this.examenDetailResultat = var1;
   }

   public DataModel getDataModelLesReponsesDetail() {
      return this.dataModelLesReponsesDetail;
   }

   public void setDataModelLesReponsesDetail(DataModel var1) {
      this.dataModelLesReponsesDetail = var1;
   }

   public List getLesReponsesItemsDetail() {
      return this.lesReponsesItemsDetail;
   }

   public void setLesReponsesItemsDetail(List var1) {
      this.lesReponsesItemsDetail = var1;
   }

   public List getLesActionsItemsDetail() {
      return this.lesActionsItemsDetail;
   }

   public void setLesActionsItemsDetail(List var1) {
      this.lesActionsItemsDetail = var1;
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

   public boolean isValideLaboratoire() {
      return this.valideLaboratoire;
   }

   public void setValideLaboratoire(boolean var1) {
      this.valideLaboratoire = var1;
   }

   public FormPatients getFormPatients() {
      return this.formPatients;
   }

   public void setFormPatients(FormPatients var1) {
      this.formPatients = var1;
   }

   public boolean isShowModalPanelCloture() {
      return this.showModalPanelCloture;
   }

   public void setShowModalPanelCloture(boolean var1) {
      this.showModalPanelCloture = var1;
   }

   public DataModel getDataModelDocumnts() {
      return this.dataModelDocumnts;
   }

   public void setDataModelDocumnts(DataModel var1) {
      this.dataModelDocumnts = var1;
   }

   public String getFichierMine() {
      return this.fichierMine;
   }

   public void setFichierMine(String var1) {
      this.fichierMine = var1;
   }

   public URL getFichierUrl() {
      return this.fichierUrl;
   }

   public void setFichierUrl(URL var1) {
      this.fichierUrl = var1;
   }

   public String getFileName() {
      return this.fileName;
   }

   public void setFileName(String var1) {
      this.fileName = var1;
   }

   public String getPdfFileName() {
      return this.pdfFileName;
   }

   public void setPdfFileName(String var1) {
      this.pdfFileName = var1;
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

   public Habilitation getHabilitation() {
      return this.habilitation;
   }

   public void setHabilitation(Habilitation var1) {
      this.habilitation = var1;
   }

   public String getNomDocument() {
      return this.nomDocument;
   }

   public void setNomDocument(String var1) {
      this.nomDocument = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public List getMesCaissesSeriesItems() {
      return this.mesCaissesSeriesItems;
   }

   public void setMesCaissesSeriesItems(List var1) {
      this.mesCaissesSeriesItems = var1;
   }

   public List getListCaisses() {
      return this.listCaisses;
   }

   public void setListCaisses(List var1) {
      this.listCaisses = var1;
   }

   public List getMesLettresGarantiesItems() {
      return this.mesLettresGarantiesItems;
   }

   public void setMesLettresGarantiesItems(List var1) {
      this.mesLettresGarantiesItems = var1;
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

   public boolean isVar_affiche_lettre() {
      return this.var_affiche_lettre;
   }

   public void setVar_affiche_lettre(boolean var1) {
      this.var_affiche_lettre = var1;
   }

   public String getVar_banque_destination() {
      return this.var_banque_destination;
   }

   public void setVar_banque_destination(String var1) {
      this.var_banque_destination = var1;
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

   public int getVarTypeReg() {
      return this.varTypeReg;
   }

   public void setVarTypeReg(int var1) {
      this.varTypeReg = var1;
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

   public UIDataTable getExtDTableProduits() {
      return this.extDTableProduits;
   }

   public void setExtDTableProduits(UIDataTable var1) {
      this.extDTableProduits = var1;
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

   public boolean isShowModalPanelChangerServiceLaboratoire() {
      return this.showModalPanelChangerServiceLaboratoire;
   }

   public void setShowModalPanelChangerServiceLaboratoire(boolean var1) {
      this.showModalPanelChangerServiceLaboratoire = var1;
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

   public String getAncienMedecin() {
      return this.ancienMedecin;
   }

   public void setAncienMedecin(String var1) {
      this.ancienMedecin = var1;
   }

   public long getNouveauMedecin() {
      return this.nouveauMedecin;
   }

   public void setNouveauMedecin(long var1) {
      this.nouveauMedecin = var1;
   }

   public String getUrlphotoResultat() {
      return this.urlphotoResultat;
   }

   public void setUrlphotoResultat(String var1) {
      this.urlphotoResultat = var1;
   }

   public boolean isVerrouPrventeCnamgs() {
      return this.verrouPrventeCnamgs;
   }

   public void setVerrouPrventeCnamgs(boolean var1) {
      this.verrouPrventeCnamgs = var1;
   }

   public double getTotalPayerTimbre() {
      return this.totalPayerTimbre;
   }

   public void setTotalPayerTimbre(double var1) {
      this.totalPayerTimbre = var1;
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

   public boolean isShowModalPanelDeCloture() {
      return this.showModalPanelDeCloture;
   }

   public void setShowModalPanelDeCloture(boolean var1) {
      this.showModalPanelDeCloture = var1;
   }

   public ProduitsReponse getProduitsReponse() {
      return this.produitsReponse;
   }

   public void setProduitsReponse(ProduitsReponse var1) {
      this.produitsReponse = var1;
   }

   public boolean isListeAction() {
      return this.listeAction;
   }

   public void setListeAction(boolean var1) {
      this.listeAction = var1;
   }

   public ProduitsFourchette getProduitsFourchette() {
      return this.produitsFourchette;
   }

   public void setProduitsFourchette(ProduitsFourchette var1) {
      this.produitsFourchette = var1;
   }

   public DataModel getDataModelListeExamens() {
      return this.dataModelListeExamens;
   }

   public void setDataModelListeExamens(DataModel var1) {
      this.dataModelListeExamens = var1;
   }

   public List getLesMotifEntree() {
      return this.lesMotifEntree;
   }

   public void setLesMotifEntree(List var1) {
      this.lesMotifEntree = var1;
   }
}
