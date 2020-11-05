package com.epegase.forms.tiers;

import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ConsultationEnteteGene;
import com.epegase.systeme.classe.ConsultationInfirmerie;
import com.epegase.systeme.classe.DevisEnteteMedical;
import com.epegase.systeme.classe.DevisLigneMedical;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.HospitalisationEntete;
import com.epegase.systeme.classe.LaboratoireEntete;
import com.epegase.systeme.classe.PatientAnt;
import com.epegase.systeme.classe.PatientContact;
import com.epegase.systeme.classe.PatientLettreGarantie;
import com.epegase.systeme.classe.PatientPec;
import com.epegase.systeme.classe.PatientProt;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.PharmacieEntete;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ConsultationActesDao;
import com.epegase.systeme.dao.ConsultationEnteteGeneDao;
import com.epegase.systeme.dao.ConsultationInfirmerieDao;
import com.epegase.systeme.dao.ConsultationLaboDao;
import com.epegase.systeme.dao.ConsultationOrdoDao;
import com.epegase.systeme.dao.ConsultationReglementDao;
import com.epegase.systeme.dao.DevisEnteteMedicalDao;
import com.epegase.systeme.dao.DevisLigneMedicalDao;
import com.epegase.systeme.dao.ExercicesVentesDao;
import com.epegase.systeme.dao.HospitalisationActesDao;
import com.epegase.systeme.dao.HospitalisationEnteteDao;
import com.epegase.systeme.dao.HospitalisationLaboDao;
import com.epegase.systeme.dao.HospitalisationMediDao;
import com.epegase.systeme.dao.HospitalisationPrestDao;
import com.epegase.systeme.dao.HospitalisationReglementDao;
import com.epegase.systeme.dao.HospitalisationSejourDao;
import com.epegase.systeme.dao.LaboratoireEnteteDao;
import com.epegase.systeme.dao.LaboratoireLigneDao;
import com.epegase.systeme.dao.LaboratoireReglementDao;
import com.epegase.systeme.dao.PatientAntDao;
import com.epegase.systeme.dao.PatientContactDao;
import com.epegase.systeme.dao.PatientLettreGarantieDao;
import com.epegase.systeme.dao.PatientPecDao;
import com.epegase.systeme.dao.PatientProtDao;
import com.epegase.systeme.dao.PatientsDao;
import com.epegase.systeme.dao.PharmacieEnteteDao;
import com.epegase.systeme.dao.PharmacieLigneDao;
import com.epegase.systeme.dao.PharmacieReglementDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.TiersAdherentDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilGoogleMap;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilSms;
import com.epegase.systeme.xml.LectureCategorieTiers;
import com.epegase.systeme.xml.LectureCivilites;
import com.epegase.systeme.xml.LectureFamillesClients;
import com.epegase.systeme.xml.LecturePays;
import com.epegase.systeme.xml.LectureReglementClient;
import com.epegase.systeme.xml.LireLesoptionsMedical;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetLigneMenu;
import com.epegase.systeme.xml.ObjetReglement;
import com.epegase.systeme.xml.OptionMedical;
import com.epegase.systeme.xml.OptionTiers;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
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
import org.richfaces.taglib.GmapTag;

public class FormPatients implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action;
   private int var_memo_action;
   private String pageIndex;
   private ObjetLigneMenu ligneMenu;
   private Patients patients;
   private PatientsDao patientsDao;
   private ExercicesVentes exercicesVentes;
   private OptionMedical optionMedical;
   private OptionTiers optionTiers;
   private String libelleSousMenu;
   private URI uri;
   private boolean showModalGoogleMap = false;
   private int var_nb_max = 100;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private String format = "PDF";
   private String requete;
   private String impEmetteur;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private int var_choix_modele;
   private String nomModeleDocument;
   private String nomModeleListe;
   private boolean visibleOptionMail = false;
   private boolean affListeDoc = false;
   private boolean showModalPanelPrint = false;
   private String nom;
   private String prenom;
   private String categorie;
   private String societe;
   private String assurance;
   private String complementaire;
   private String dossier;
   private String telephone;
   private String carteIdentite;
   private String site;
   private List mesdevisesItem;
   private List mesCategoriesItems;
   private List mesCivilitesItems;
   private List lesPatients;
   private transient DataModel dataModelPatients;
   private UIDataTable extDTable;
   private SimpleSelection simpleSelectionEntete;
   private boolean afficheButtOption = false;
   private boolean afficheButtConsultation = false;
   private boolean afficheButtPharmacie = false;
   private boolean afficheButtLaboratoire = false;
   private boolean afficheButtHospitalisation = false;
   private int tiersPayant;
   private List mesFamilleClientsItems;
   private List lesFamilleClientsListe;
   private boolean modalGoogleMap = false;
   private GmapTag gmapTag;
   private String place;
   private Chrono chrono;
   private ChronoDao chronoDao;
   private CalculChrono calculChrono;
   private boolean showModalPanelCalculDateNaissance = false;
   private int nbAnnee;
   private int nbMois;
   private int nbJours;
   private int nevers;
   private boolean verrouSexe;
   private String memoNom;
   private String memoPrenom;
   private List mesSitesItem;
   private List mesDepartementsItem;
   private List mesServicesItem;
   private List mesUserItems;
   private PatientContact patientContact;
   private PatientContactDao patientContactDao;
   private transient DataModel datamodelContact;
   private List lesContacts;
   private boolean afficheButtContact = false;
   private int var_actionContact;
   private boolean showModalPanelCnt = false;
   private transient DataModel datamodelPersonnelMedical;
   private boolean var_D1;
   private boolean var_C1;
   private boolean var_Cc1;
   private boolean var_E1;
   private boolean var_Ee1;
   private boolean var_Cde1;
   private boolean var_K1;
   private boolean var_D2;
   private boolean var_C2;
   private boolean var_Cc2;
   private boolean var_E2;
   private boolean var_Ee2;
   private boolean var_Cde2;
   private boolean var_K2;
   private transient DataModel dataModelDentition;
   private PatientProt patientProt;
   private PatientProtDao patientProtDao;
   private transient DataModel datamodelProtocole;
   private List lesProtocole;
   private boolean afficheButtProtocole = false;
   private int var_actionProtocole;
   private String var_protocole;
   private boolean showModalPanelPrt = false;
   private PatientAnt patientAnt;
   private PatientAntDao patientAntDao;
   private transient DataModel datamodelAntecedent;
   private List lesAntecedent;
   private boolean afficheButtAntecedent = false;
   private int var_actionAntecedent;
   private String var_antecedent;
   private boolean showModalPanelAnt = false;
   private PatientPec patientPec;
   private PatientPecDao patientPecDao;
   private transient DataModel datamodelPec;
   private transient DataModel datamodelFda;
   private List lesPec;
   private List lesFda;
   private boolean afficheButtPec = false;
   private int var_actionPec;
   private String var_tiers;
   private Tiers tiers;
   private transient DataModel datamodelTiers;
   private List lesTiers;
   private boolean showModalPanelPec = false;
   private boolean showModalPanelTiers = false;
   private List lesEmployeursItems;
   private int var_actionFda;
   private boolean showModalPanelFda = false;
   private boolean afficheButtFda = false;
   private boolean showModalPanelFicheAyantDroit = false;
   private Patients patientsAyantDroit;
   private Patients patientsAssure;
   private List lesPatientsAyantDroit;
   private transient DataModel datamodelAyd;
   private boolean afficheButtAyd = false;
   private boolean testModeCalcul = false;
   private List lesReglementsClient;
   private List mesReglementClientItems;
   private UtilDownload utilDownload;
   private String urlphoto;
   private String fileName;
   private String pdfFileName;
   private UploadedFile uploadedFile;
   private static final int DEFAULT_BUFFER_SIZE = 10240;
   private boolean showModalPanelSms = false;
   private String numeroMobile;
   private String messageSms;
   private boolean showModalPanelActvites = false;
   private DocumentEntete documentEntete;
   private transient DataModel dataModelDocumentsEntete;
   private List lesDocumentsEntete;
   private int choixDocument;
   private Date dateDebut;
   private Date dateFin;
   private String choixProduit;
   private double var_total;
   private double var_reglement;
   private double var_solde;
   private transient DataModel dataModelAntecedent;
   private transient DataModel dataModelConsActesLignes;
   private transient DataModel dataModelConsLaboLignes;
   private transient DataModel dataModelConsOrdoLigne;
   private transient DataModel dataModelConsMediLignes;
   private transient DataModel dataModelConsRegLignes;
   private transient DataModel dataModelConsScan;
   private transient DataModel dataModelPharmaciesLignes;
   private transient DataModel dataModelPhaRegLignes;
   private transient DataModel dataModelLabExamensLignes;
   private transient DataModel dataModelLabRegLignes;
   private transient DataModel dataModelLabScan;
   private transient DataModel dataModelHosSejoursLignes;
   private transient DataModel dataModelHosExmanesLignes;
   private transient DataModel dataModelHosLaboLignes;
   private transient DataModel dataModelHosMediLignes;
   private transient DataModel dataModelHosPrestLignes;
   private transient DataModel dataModelHosRegLignes;
   private transient DataModel dataModelHosScan;
   private ConsultationEnteteGene consultationEnteteGene;
   private ConsultationInfirmerie consultationInfirmerie;
   private ConsultationEnteteGeneDao consultationEnteteGeneDao;
   private ConsultationActesDao consultationActesDao;
   private ConsultationInfirmerieDao consultationInfirmerieDao;
   private ConsultationLaboDao consultationLaboDao;
   private ConsultationOrdoDao consultationOrdoDao;
   private ConsultationReglementDao consultationReglementDao;
   private PharmacieLigneDao pharmacieLigneDao;
   private PharmacieEntete pharmacieEntete;
   private PharmacieEnteteDao pharmacieEnteteDao;
   private PharmacieReglementDao pharmacieReglementDao;
   private LaboratoireEntete laboratoireEntete;
   private LaboratoireEnteteDao laboratoireEnteteDao;
   private LaboratoireLigneDao laboratoireLigneDao;
   private LaboratoireReglementDao laboratoireReglementDao;
   private HospitalisationEntete hospitalisationEntete;
   private HospitalisationEnteteDao hospitalisationEnteteDao;
   private HospitalisationActesDao hospitalisationActesDao;
   private HospitalisationLaboDao hospitalisationLaboDao;
   private HospitalisationMediDao hospitalisationMediDao;
   private HospitalisationPrestDao hospitalisationPrestDao;
   private HospitalisationReglementDao hospitalisationReglementDao;
   private HospitalisationSejourDao hospitalisationSejourDao;
   private DevisEnteteMedical devisEnteteMedical;
   private DevisEnteteMedicalDao devisEnteteMedicalDao;
   private DevisLigneMedical devisLigneMedical;
   private DevisLigneMedicalDao devisLigneMedicalDao;
   private boolean accesAntecedent;
   private boolean accesConsultation;
   private boolean accesInfirmerie;
   private boolean accesConsActesLignes;
   private boolean accesConsLaboLignes;
   private boolean accesConsOrdoLigne;
   private boolean accesConsMediLignes;
   private boolean accesConsRegLignes;
   private boolean accesConsScan;
   private boolean accesPharmaciesLignes;
   private boolean accesPhaRegLignes;
   private boolean accesLabExamensLignes;
   private boolean accesLabRegLignes;
   private boolean accesLabScan;
   private boolean accesHosSejoursLignes;
   private boolean accesHosExmanesLignes;
   private boolean accesHosLaboLignes;
   private boolean accesHosMediLignes;
   private boolean accesHosPrestLignes;
   private boolean accesHosRegLignes;
   private boolean accesHosScan;
   private int var_heures;
   private int var_minutes;
   private String var_lib_poids;
   private Date var_date_accident;
   private PatientLettreGarantie patientLettreGarantie;
   private PatientLettreGarantieDao patientLettreGarantieDao;
   private List mesTiersPEC;
   private transient DataModel dataModelLettreGarantie;
   private List lesLettreGarantie;
   private boolean showModalPanelLettreGarantie = false;
   private ReglementsDao reglementsDao;
   private List lesReglements;
   private transient DataModel dataModelReglements;
   private boolean showModalPanelLesReglements = false;
   private boolean visibiliteBton = false;
   private boolean var_actionLettre;
   private String nomTiers;
   private boolean showModalPanelScan = false;
   private boolean var_valide_lettre = false;
   private long idTiersPec;
   private transient DataModel dataModelPatientDoublon;
   private boolean showModalPanelPatientDublon = false;
   private Patients patientsDouble;
   private boolean selectTiers = false;
   private int nature;
   private String var_nom;
   private String var_prenom;
   private String var_dossier;
   private String var_telephone;
   private String var_carteIdentite;
   private String var_societe;
   private String var_complementaire;
   private String var_assurance;
   private String var_contrat;
   private List mesPaysItems;
   private List mesPecItems;
   private String numeroDocument;
   private Date dateDocument;
   private boolean infirmerie;
   private boolean showModalPanelTrfAyantDroit = false;
   private String numeroAssure;
   private String nomAssure;
   private String qualite;
   private boolean showModalPanelListeAssure = false;
   private transient DataModel dataModelListAssure;
   private UploadedFile uploadedPDFFile;
   private String fichierMine;
   private String urlExplorateur;
   private String nomRepertoire;
   private boolean showModalPanelPjCons = false;
   private boolean showModalPanelPjLab = false;
   private boolean showModalPanelPjHos = false;
   private String nomDocument;
   private URL fichierUrl;
   private int choixRacine;
   private String selecFiscalite;

   public FormPatients() throws IOException {
      this.dataModelPatients = new ListDataModel();
      this.simpleSelectionEntete = new SimpleSelection();
      this.extDTable = new HtmlExtendedDataTable();
      this.lesPatients = new ArrayList();
      this.datamodelContact = new ListDataModel();
      this.lesContacts = new ArrayList();
      this.datamodelProtocole = new ListDataModel();
      this.lesProtocole = new ArrayList();
      this.datamodelAntecedent = new ListDataModel();
      this.lesAntecedent = new ArrayList();
      this.datamodelPec = new ListDataModel();
      this.datamodelFda = new ListDataModel();
      this.lesPec = new ArrayList();
      this.lesFda = new ArrayList();
      this.lesPatientsAyantDroit = new ArrayList();
      this.datamodelAyd = new ListDataModel();
      this.lesLettreGarantie = new ArrayList();
      this.dataModelLettreGarantie = new ListDataModel();
      this.datamodelPersonnelMedical = new ListDataModel();
      this.datamodelTiers = new ListDataModel();
      this.lesTiers = new ArrayList();
      this.utilDownload = new UtilDownload();
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.lesEmployeursItems = new ArrayList();
      this.lesPatientsAyantDroit = new ArrayList();
      this.datamodelAyd = new ListDataModel();
      this.dataModelPatientDoublon = new ListDataModel();
      this.dataModelListAssure = new ListDataModel();
      this.mesServicesItem = new ArrayList();
      this.mesDepartementsItem = new ArrayList();
      this.mesSitesItem = new ArrayList();
      this.dataModelDentition = new ListDataModel();
   }

   public FormPatients(String var1, Structure var2, Users var3, UtilInitHibernate var4) {
      this.utilInitHibernate = var4;
      this.baseLog = var1;
      this.structureLog = var2;
      this.usersLog = var3;
      this.dataModelPatients = new ListDataModel();
      this.lesPatients = new ArrayList();
      this.datamodelContact = new ListDataModel();
      this.lesContacts = new ArrayList();
      this.datamodelProtocole = new ListDataModel();
      this.lesProtocole = new ArrayList();
      this.datamodelAntecedent = new ListDataModel();
      this.lesAntecedent = new ArrayList();
      this.datamodelPec = new ListDataModel();
      this.datamodelFda = new ListDataModel();
      this.lesPec = new ArrayList();
      this.lesFda = new ArrayList();
      this.lesPatientsAyantDroit = new ArrayList();
      this.datamodelAyd = new ListDataModel();
      this.lesLettreGarantie = new ArrayList();
      this.dataModelLettreGarantie = new ListDataModel();
      this.datamodelPersonnelMedical = new ListDataModel();
      this.datamodelTiers = new ListDataModel();
      this.lesTiers = new ArrayList();
      this.utilDownload = new UtilDownload();
      this.calculChrono = new CalculChrono(var1, var4);
      this.lesEmployeursItems = new ArrayList();
      this.lesPatientsAyantDroit = new ArrayList();
      this.datamodelAyd = new ListDataModel();
      this.dataModelPatientDoublon = new ListDataModel();
   }

   public void InstancesDaoUtilses() {
      this.patientsDao = new PatientsDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.patientContactDao = new PatientContactDao(this.baseLog, this.utilInitHibernate);
      this.patientProtDao = new PatientProtDao(this.baseLog, this.utilInitHibernate);
      this.patientAntDao = new PatientAntDao(this.baseLog, this.utilInitHibernate);
      this.patientPecDao = new PatientPecDao(this.baseLog, this.utilInitHibernate);
      this.patientLettreGarantieDao = new PatientLettreGarantieDao(this.baseLog, this.utilInitHibernate);
   }

   public void recupererOptionsMedical(Session var1) throws ParseException {
      LireLesoptionsMedical var2 = new LireLesoptionsMedical();
      var2.setStrId(this.structureLog.getStrid());
      var2.lancer();
      this.optionMedical = var2.getOptionMedical();
      if (this.optionTiers.getNbLigneMaxTi() != null && !this.optionTiers.getNbLigneMaxTi().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionTiers.getNbLigneMaxTi());
      } else {
         this.var_nb_max = 100;
      }

      this.verifInfirmerie();
      this.chargerMesracines();
      if (this.infirmerie) {
         if (this.usersLog.getUsrSite() != null && !this.usersLog.getUsrSite().isEmpty()) {
            this.site = this.usersLog.getUsrSite();
         } else {
            this.site = "";
         }
      }

   }

   public void chargerMesracines() {
      if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty() && (this.choixRacine == 2 || this.choixRacine == 0)) {
         this.choixRacine = 1;
         this.selecFiscalite = this.structureLog.getStrzonefiscale();
      } else if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty() && this.choixRacine == 1) {
         this.choixRacine = 2;
         this.selecFiscalite = this.structureLog.getStrzonefiscale2();
      } else {
         this.choixRacine = 0;
         this.selecFiscalite = this.structureLog.getStrzonefiscale();
      }

   }

   public void verifInfirmerie() {
      this.infirmerie = this.rechercheModule(81500);
   }

   public void recupererExerciceMedical(Session var1) throws HibernateException, NamingException {
      this.exercicesVentes = new ExercicesVentes();
      ExercicesVentesDao var2 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
      this.exercicesVentes = var2.recupererLastExo(var1);
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

   public void chargerLesPatients() throws HibernateException, NamingException {
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      this.dataModelPatients = new ListDataModel();
      this.lesPatients = new ArrayList();
      if (this.infirmerie) {
         this.lesPatients = this.patientsDao.chargerListPatients(this.rechercherPatientsInfirmerie(), (Session)null);
      } else if (this.var_contrat != null && !this.var_contrat.isEmpty()) {
         new ArrayList();
         this.patientPecDao = new PatientPecDao(this.baseLog, this.utilInitHibernate);
         List var1 = this.patientPecDao.chargerListPatients(this.rechercherPatientPec(), (Session)null);
         if (var1.size() != 0) {
            for(int var2 = 0; var2 < var1.size(); ++var2) {
               this.lesPatients.add(((PatientPec)var1.get(var2)).getPatient());
            }
         }
      } else {
         this.lesPatients = this.patientsDao.chargerListPatients(this.rechercherPatients(), (Session)null);
      }

      this.dataModelPatients.setWrappedData(this.lesPatients);
   }

   public String rechercherPatients() {
      String var1 = "from Patients where patId>0 ";
      if (this.nom != null && !this.nom.isEmpty() && !this.nom.contains("*")) {
         var1 = var1 + " and patNom LIKE '" + this.nom + "%'";
      }

      String var2;
      if (this.nom != null && !this.nom.isEmpty() && this.nom.startsWith("*")) {
         var2 = this.nom.substring(1);
         var1 = var1 + " and patNom LIKE '%" + var2 + "%'";
      }

      if (this.prenom != null && !this.prenom.isEmpty() && !this.prenom.contains("*")) {
         var1 = var1 + " and patPrenom LIKE '" + this.prenom + "%'";
      }

      if (this.prenom != null && !this.prenom.isEmpty() && this.prenom.startsWith("*")) {
         var2 = this.prenom.substring(1);
         var1 = var1 + " and patPrenom LIKE '%" + var2 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty()) {
         var1 = var1 + " and patDossier = '" + this.dossier + "'";
      }

      if (this.telephone != null && !this.telephone.isEmpty()) {
         var1 = var1 + " and (patCel1 LIKE '" + this.telephone + "%' or patCel2 LIKE '" + this.telephone + "%' or patCel3 LIKE '" + this.telephone + "%' or patTelDom LIKE '" + this.telephone + "%' or patTelVoiture LIKE '" + this.telephone + "%')";
      }

      if (this.carteIdentite != null && !this.carteIdentite.isEmpty()) {
         var1 = var1 + " and (patCi= '" + this.carteIdentite + "%' or patSecu='" + this.carteIdentite + "')";
      }

      if (this.societe != null && !this.societe.isEmpty()) {
         var1 = var1 + " and patSociete LIKE '" + this.societe + "%'";
      }

      if (this.assurance != null && !this.assurance.isEmpty()) {
         var1 = var1 + " and patAssurance LIKE '" + this.assurance + "%'";
      }

      if (this.complementaire != null && !this.complementaire.isEmpty()) {
         var1 = var1 + " and patComplementaire LIKE '" + this.complementaire + "%'";
      }

      return var1;
   }

   public String rechercherPatientsInfirmerie() {
      String var1 = "from Patients where patId>0 ";
      if (this.site != null && !this.site.isEmpty()) {
         var1 = var1 + " and patCommune = '" + this.site + "'";
      }

      if (this.nom != null && !this.nom.isEmpty() && !this.nom.contains("*")) {
         var1 = var1 + " and patNom LIKE '" + this.nom + "%'";
      }

      String var2;
      if (this.nom != null && !this.nom.isEmpty() && this.nom.startsWith("*")) {
         var2 = this.nom.substring(1);
         var1 = var1 + " and patNom LIKE '%" + var2 + "%'";
      }

      if (this.prenom != null && !this.prenom.isEmpty() && !this.prenom.contains("*")) {
         var1 = var1 + " and patPrenom LIKE '" + this.prenom + "%'";
      }

      if (this.prenom != null && !this.prenom.isEmpty() && this.prenom.startsWith("*")) {
         var2 = this.prenom.substring(1);
         var1 = var1 + " and patPrenom LIKE '%" + var2 + "%'";
      }

      if (this.dossier != null && !this.dossier.isEmpty()) {
         var1 = var1 + " and patDossier = '" + this.dossier + "'";
      }

      if (this.telephone != null && !this.telephone.isEmpty()) {
         var1 = var1 + " and (patCel1 LIKE '" + this.telephone + "%' or patCel2 LIKE '" + this.telephone + "%' or patCel3 LIKE '" + this.telephone + "%' or patTelDom LIKE '" + this.telephone + "%' or patTelVoiture LIKE '" + this.telephone + "%')";
      }

      if (this.carteIdentite != null && !this.carteIdentite.isEmpty()) {
         var1 = var1 + " and (patCi= '" + this.carteIdentite + "%' or patSecu='" + this.carteIdentite + "')";
      }

      if (this.societe != null && !this.societe.isEmpty()) {
         var1 = var1 + " and patSociete LIKE '" + this.societe + "%'";
      }

      if (this.assurance != null && !this.assurance.isEmpty()) {
         var1 = var1 + " and patAssurance LIKE '" + this.assurance + "%'";
      }

      if (this.complementaire != null && !this.complementaire.isEmpty()) {
         var1 = var1 + " and patComplementaire LIKE '" + this.complementaire + "%'";
      }

      return var1;
   }

   public String rechercherPatientPec() {
      String var1 = "from PatientPec where patpecId>0 ";
      var1 = var1 + " and patpecNumContrat LIKE '" + this.var_contrat + "%' or patpecMatricule LIKE '" + this.var_contrat + "%'";
      if (this.var_nom != null && !this.var_nom.isEmpty()) {
         var1 = var1 + " and patient.patNom LIKE '" + this.var_nom + "%'";
      }

      if (this.var_prenom != null && !this.var_prenom.isEmpty()) {
         var1 = var1 + " and patient.patPrenom LIKE '" + this.var_prenom + "%'";
      }

      if (this.var_dossier != null && !this.var_dossier.isEmpty()) {
         var1 = var1 + " and patient.patDossier = '" + this.var_dossier + "'";
      }

      if (this.var_telephone != null && !this.var_telephone.isEmpty()) {
         var1 = var1 + " and (patient.patCel1 LIKE '" + this.var_telephone + "%' or patient.patCel2 LIKE '" + this.var_telephone + "%' or patient.patCel3 LIKE '" + this.var_telephone + "%' or patient.patTelDom LIKE '" + this.var_telephone + "%')";
      }

      if (this.var_carteIdentite != null && !this.var_carteIdentite.isEmpty()) {
         var1 = var1 + " and (patient.patCi='" + this.var_carteIdentite + "%' or patient.patPassport='" + this.var_carteIdentite + "' or patient.patSecu='" + this.var_carteIdentite + "')";
      }

      if (this.var_societe != null && !this.var_societe.isEmpty()) {
         var1 = var1 + " and patient.patSociete LIKE '" + this.var_societe + "%'";
      }

      if (this.var_assurance != null && !this.var_assurance.isEmpty()) {
         var1 = var1 + " and patient.patAssurance LIKE '" + this.var_assurance + "%'";
      }

      if (this.var_complementaire != null && !this.var_complementaire.isEmpty()) {
         var1 = var1 + " and patient.patComplementaire LIKE '" + this.var_complementaire + "%'";
      }

      return var1;
   }

   public void selectionPatient() throws JDOMException, IOException, NamingException, SQLException {
      this.patients = new Patients();
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
            this.patients = (Patients)var1.get(0);
            this.memoNom = this.patients.getPatNom();
            this.memoPrenom = this.patients.getPatPrenom();
            this.calculePatient();
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationPatient() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.patients != null) {
         this.consulterTiers();
      }

   }

   public void calculePatient() throws HibernateException, NamingException, IOException, SQLException {
      Object var1 = null;
      if (!this.optionMedical.getDent().equals("0")) {
         this.utilInitHibernate.getOpenSession(this.baseLog, "PatientsDentiste");
      } else {
         this.utilInitHibernate.getOpenSession(this.baseLog, "Patients");
      }

      this.chargerLesContacts((Session)var1);
      this.chargerLesProtocoles((Session)var1);
      this.chargerLesAntecedents((Session)var1);
      this.chargerLesDentitions((Session)var1);
      this.chargerLesPec((Session)var1);
      this.affichePhoto();
      this.utilInitHibernate.closeSession();
      if (this.patients.getPatD1() == 1) {
         this.var_D1 = true;
      } else {
         this.var_D1 = false;
      }

      if (this.patients.getPatC1() == 1) {
         this.var_C1 = true;
      } else {
         this.var_C1 = false;
      }

      if (this.patients.getPatCc1() == 1) {
         this.var_Cc1 = true;
      } else {
         this.var_Cc1 = false;
      }

      if (this.patients.getPatE1() == 1) {
         this.var_E1 = true;
      } else {
         this.var_E1 = false;
      }

      if (this.patients.getPatEe1() == 1) {
         this.var_Ee1 = true;
      } else {
         this.var_Ee1 = false;
      }

      if (this.patients.getPatCde1() == 1) {
         this.var_Cde1 = true;
      } else {
         this.var_Cde1 = false;
      }

      if (this.patients.getPatK1() == 1) {
         this.var_K1 = true;
      } else {
         this.var_K1 = false;
      }

      if (this.patients.getPatD2() == 1) {
         this.var_D2 = true;
      } else {
         this.var_D2 = false;
      }

      if (this.patients.getPatC2() == 1) {
         this.var_C2 = true;
      } else {
         this.var_C2 = false;
      }

      if (this.patients.getPatCc2() == 1) {
         this.var_Cc2 = true;
      } else {
         this.var_Cc2 = false;
      }

      if (this.patients.getPatE2() == 1) {
         this.var_E2 = true;
      } else {
         this.var_E2 = false;
      }

      if (this.patients.getPatEe2() == 1) {
         this.var_Ee2 = true;
      } else {
         this.var_Ee2 = false;
      }

      if (this.patients.getPatCde2() == 1) {
         this.var_Cde2 = true;
      } else {
         this.var_Cde2 = false;
      }

      if (this.patients.getPatK2() == 1) {
         this.var_K2 = true;
      } else {
         this.var_K2 = false;
      }

      this.afficheButtOption = true;
      this.afficheButtAyd = false;
      this.afficheButtAntecedent = false;
      this.afficheButtContact = false;
      this.afficheButtPec = false;
      this.afficheButtProtocole = false;
      this.calculeGenre();
   }

   public void chargerLesContacts(Session var1) throws HibernateException, NamingException {
      this.lesContacts.clear();
      this.lesContacts = this.patientContactDao.chargerLesPatientsContact(this.patients, var1);
      this.datamodelContact.setWrappedData(this.lesContacts);
   }

   public void chargerLesProtocoles(Session var1) throws HibernateException, NamingException {
      this.lesProtocole.clear();
      this.lesProtocole = this.patientProtDao.chargerLesPatientsProtocles(this.patients, var1);
      this.datamodelProtocole.setWrappedData(this.lesProtocole);
   }

   public void chargerLesAntecedents(Session var1) throws HibernateException, NamingException {
      this.lesAntecedent.clear();
      this.lesAntecedent = this.patientAntDao.chargerLesPatientsAntecedents(this.patients, var1);
      this.datamodelAntecedent.setWrappedData(this.lesAntecedent);
   }

   public void chargerLesDentitions(Session var1) throws HibernateException, NamingException {
      Object var2 = new ArrayList();
      if (!this.optionMedical.getDent().equals("0")) {
         this.consultationActesDao = new ConsultationActesDao(this.baseLog, this.utilInitHibernate);
         var2 = this.consultationActesDao.chargerLesMvtsDents(this.patients, var1);
      }

      this.dataModelDentition.setWrappedData(var2);
   }

   public void chargerLesPec(Session var1) throws HibernateException, NamingException {
      this.lesPec.clear();
      this.lesPec = this.patientPecDao.chargerLesPatientsPec(this.patients, 9, var1);
      this.datamodelPec.setWrappedData(this.lesPec);
      this.lesFda.clear();
      this.lesFda = this.patientLettreGarantieDao.chargerLesLettresByPatients(this.patients, 9, 1, var1);
      this.datamodelFda.setWrappedData(this.lesFda);
      this.lesPatientsAyantDroit.clear();
      if (this.patients.getPatIdCouvertPar() == 0L) {
         this.lesPatientsAyantDroit = this.patientsDao.chargerlesPatients(this.patients.getPatId(), var1);
      }

      this.datamodelAyd.setWrappedData(this.lesPatientsAyantDroit);
      this.patientsAssure = null;
      this.patientPec = null;
      if (this.patients.getPatIdCouvertPar() != 0L) {
         this.patientsAssure = this.patientsDao.selectPatientsD(this.patients.getPatIdCouvertPar(), var1);
         if (this.patientsAssure != null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.patientsAssure, 0L, var1);
         }
      }

   }

   public void ajouterTiers() {
      this.patients = new Patients();
      this.memoNom = "";
      this.memoPrenom = "";
      this.patientsAyantDroit = new Patients();
      this.patientsDouble = new Patients();
      this.patients.setPatDateNaissance((Date)null);
      this.patients.setPatPec("");
      this.patients.setPatNomFamille(0);
      this.patients.setPatTypereg(0);
      this.patients.setPatPaysNaissance(this.structureLog.getStrnompays());
      this.patients.setPatPays(this.structureLog.getStrnompays());
      if (this.infirmerie) {
         if (this.usersLog.getUsrSite() != null && !this.usersLog.getUsrSite().isEmpty()) {
            this.patients.setPatCommune(this.usersLog.getUsrSite());
         } else {
            this.patients.setPatCommune(this.site);
         }
      }

      this.lesContacts.clear();
      this.datamodelContact.setWrappedData(this.lesContacts);
      this.lesAntecedent.clear();
      this.datamodelAntecedent.setWrappedData(this.lesAntecedent);
      this.lesPec.clear();
      this.datamodelPec.setWrappedData(this.lesPec);
      this.lesFda.clear();
      this.datamodelFda.setWrappedData(this.lesFda);
      this.lesPatientsAyantDroit.clear();
      this.datamodelAyd.setWrappedData(this.lesPatientsAyantDroit);
      this.lesLettreGarantie.clear();
      this.dataModelLettreGarantie.setWrappedData(this.lesLettreGarantie);
      this.lesProtocole.clear();
      this.datamodelProtocole.setWrappedData(this.lesProtocole);
      this.urlphoto = null;
      this.var_action = 1;
   }

   public void modifierTiers() {
      if (this.patients != null) {
         if (this.patients.getPatPaysNaissance() == null || this.patients.getPatPaysNaissance().isEmpty()) {
            this.patients.setPatPaysNaissance(this.structureLog.getStrnompays());
         }

         if (this.patients.getPatPays() == null || this.patients.getPatPays().isEmpty()) {
            this.patients.setPatPays(this.structureLog.getStrnompays());
         }

         this.var_action = 2;
      }

   }

   public void consulterTiers() {
      if (this.patients != null) {
         this.var_action = 3;
      }

   }

   public void supprimerTiers() throws HibernateException, NamingException {
      if (this.patients != null) {
         this.supressionTiersPatient(this.patients);
         this.lesPatients.remove(this.patients);
         this.visibiliteBton = false;
         this.afficheButtOption = false;
         this.extDTable = new HtmlExtendedDataTable();
         this.simpleSelectionEntete.clear();
      }

   }

   public void supressionTiersPatient(Patients var1) throws HibernateException, NamingException {
      if (var1 != null) {
         this.consultationEnteteGeneDao = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
         boolean var2 = this.consultationEnteteGeneDao.verifConsultPatients(var1, (Session)null);
         this.laboratoireEnteteDao = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
         boolean var3 = this.laboratoireEnteteDao.verifLaboPatients(var1, (Session)null);
         this.pharmacieEnteteDao = new PharmacieEnteteDao(this.baseLog, this.utilInitHibernate);
         boolean var4 = this.pharmacieEnteteDao.verifPharmPatients(var1, (Session)null);
         this.hospitalisationEnteteDao = new HospitalisationEnteteDao(this.baseLog, this.utilInitHibernate);
         boolean var5 = this.hospitalisationEnteteDao.verifHospitPatients(var1, (Session)null);
         if (!var2 && !var3 && !var4 && !var5) {
            new ArrayList();
            this.patientAntDao = new PatientAntDao(this.baseLog, this.utilInitHibernate);
            List var6 = this.patientAntDao.chargerLesPatientsAntecedents(var1, (Session)null);
            if (var6.size() != 0) {
               this.patientAnt = new PatientAnt();

               for(int var7 = 0; var7 < var6.size(); ++var7) {
                  this.patientAnt = (PatientAnt)var6.get(var7);
                  this.patientAntDao.delete(this.patientAnt);
               }
            }

            new ArrayList();
            this.patientContactDao = new PatientContactDao(this.baseLog, this.utilInitHibernate);
            List var13 = this.patientContactDao.chargerLesPatientsContact(var1, (Session)null);
            if (var13.size() != 0) {
               this.patientContact = new PatientContact();

               for(int var8 = 0; var8 < var13.size(); ++var8) {
                  this.patientContact = (PatientContact)var13.get(var8);
                  this.patientContactDao.delete(this.patientContact);
               }
            }

            new ArrayList();
            this.patientLettreGarantieDao = new PatientLettreGarantieDao(this.baseLog, this.utilInitHibernate);
            List var14 = this.patientLettreGarantieDao.chargerLesLettresByPatients(var1, 9, 0, (Session)null);
            if (var14.size() != 0) {
               this.patientLettreGarantie = new PatientLettreGarantie();

               for(int var9 = 0; var9 < var14.size(); ++var9) {
                  this.patientLettreGarantie = (PatientLettreGarantie)var14.get(var9);
                  this.patientLettreGarantieDao.delete(this.patientLettreGarantie);
               }
            }

            new ArrayList();
            this.patientLettreGarantieDao = new PatientLettreGarantieDao(this.baseLog, this.utilInitHibernate);
            List var15 = this.patientLettreGarantieDao.chargerLesLettresByPatients(var1, 9, 1, (Session)null);
            if (var15.size() != 0) {
               this.patientLettreGarantie = new PatientLettreGarantie();

               for(int var10 = 0; var10 < var15.size(); ++var10) {
                  this.patientLettreGarantie = (PatientLettreGarantie)var15.get(var10);
                  this.patientLettreGarantieDao.delete(this.patientLettreGarantie);
               }
            }

            new ArrayList();
            this.patientPecDao = new PatientPecDao(this.baseLog, this.utilInitHibernate);
            List var16 = this.patientPecDao.chargerLesPatientsPec(var1, 9, (Session)null);
            if (var16.size() != 0) {
               this.patientPec = new PatientPec();

               for(int var11 = 0; var11 < var16.size(); ++var11) {
                  this.patientPec = (PatientPec)var16.get(var11);
                  this.patientPecDao.delete(this.patientPec);
               }
            }

            new ArrayList();
            this.patientProtDao = new PatientProtDao(this.baseLog, this.utilInitHibernate);
            List var17 = this.patientProtDao.chargerLesPatientsProtocles(var1, (Session)null);
            if (var17.size() != 0) {
               this.patientProt = new PatientProt();

               for(int var12 = 0; var12 < var17.size(); ++var12) {
                  this.patientProt = (PatientProt)var17.get(var12);
                  this.patientProtDao.delete(this.patientProt);
               }
            }

            this.patientsDao.delete(var1);
            this.visibiliteBton = false;
            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelectionEntete.clear();
         }
      }

   }

   public void annuleSaisie() {
      this.var_action = 0;
      this.afficheButtOption = false;
      this.var_memo_action = this.var_action;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void majPatient() throws HibernateException, NamingException {
      if (this.patients.getPatNom() != null && !this.patients.getPatNom().isEmpty() && this.patients.getPatDateNaissance() != null) {
         if (this.patients.getPatTelDom() != null && !this.patients.getPatTelDom().isEmpty() || this.patients.getPatCel1() != null && !this.patients.getPatCel1().isEmpty() || this.patients.getPatCel2() != null && !this.patients.getPatCel2().isEmpty() || this.patients.getPatCel3() != null && !this.patients.getPatCel3().isEmpty()) {
            if (this.var_D1) {
               this.patients.setPatD1(1);
            } else {
               this.patients.setPatD1(0);
            }

            if (this.var_C1) {
               this.patients.setPatC1(1);
            } else {
               this.patients.setPatC1(0);
            }

            if (this.var_Cc1) {
               this.patients.setPatCc1(1);
            } else {
               this.patients.setPatCc1(0);
            }

            if (this.var_E1) {
               this.patients.setPatE1(1);
            } else {
               this.patients.setPatE1(0);
            }

            if (this.var_Ee1) {
               this.patients.setPatEe1(1);
            } else {
               this.patients.setPatEe1(0);
            }

            if (this.var_Cde1) {
               this.patients.setPatCde1(1);
            } else {
               this.patients.setPatCde1(0);
            }

            if (this.var_K1) {
               this.patients.setPatK1(1);
            } else {
               this.patients.setPatK1(0);
            }

            if (this.var_D2) {
               this.patients.setPatD2(1);
            } else {
               this.patients.setPatD2(0);
            }

            if (this.var_C2) {
               this.patients.setPatC2(1);
            } else {
               this.patients.setPatC2(0);
            }

            if (this.var_Cc2) {
               this.patients.setPatCc2(1);
            } else {
               this.patients.setPatCc2(0);
            }

            if (this.var_E2) {
               this.patients.setPatE2(1);
            } else {
               this.patients.setPatE2(0);
            }

            if (this.var_Ee2) {
               this.patients.setPatEe2(1);
            } else {
               this.patients.setPatEe2(0);
            }

            if (this.var_Cde2) {
               this.patients.setPatCde2(1);
            } else {
               this.patients.setPatCde2(0);
            }

            if (this.var_K2) {
               this.patients.setPatK2(1);
            } else {
               this.patients.setPatK2(0);
            }

            if (this.patients.getPatSerie() == null || this.patients.getPatSerie().isEmpty()) {
               this.patients.setPatSerie("A");
            }

            if (this.lesPatientsAyantDroit.size() != 0) {
               int var1 = 0;

               for(int var2 = 0; var2 < this.lesPatientsAyantDroit.size(); ++var2) {
                  if (((Patients)this.lesPatientsAyantDroit.get(var2)).getPatQualite() != null && !((Patients)this.lesPatientsAyantDroit.get(var2)).getPatQualite().isEmpty() && ((Patients)this.lesPatientsAyantDroit.get(var2)).getPatQualite().equalsIgnoreCase("Enfant")) {
                     ++var1;
                  }
               }

               this.patients.setPatNbEnfant(var1);
            }

            if (this.patientsAssure != null) {
               this.patients.setPatIdCouvertPar(this.patientsAssure.getPatId());
            } else {
               this.patients.setPatIdCouvertPar(0L);
            }

            if (this.lesPec.size() == 0) {
               if (this.patients.getPatPourcentCasSocial() != 0.0F) {
                  this.patients.setPatNomFamille(-1);
               } else {
                  this.patients.setPatNomFamille(0);
               }

               this.patients.setPatNumContrat("");
               this.patients.setPatImmatriculation("");
               this.patients.setPatAssurance("");
               this.patients.setPatIdAssurance(0L);
               this.patients.setPatComplementaire("");
               this.patients.setPatIdComplementaire(0L);
               this.patients.setPatSociete("");
               this.patients.setPatIdSociete(0L);
            } else {
               this.patients.setPatNomFamille(1);
               this.patients.setPatPec(((PatientPec)this.lesPec.get(0)).getPatpecType());
            }

            Session var10 = this.utilInitHibernate.getOpenSession(this.baseLog, "Patients");
            Transaction var13 = null;

            try {
               var13 = var10.beginTransaction();
               if (this.patients.getPatId() != 0L) {
                  this.patients.setPatDateModif(new Date());
                  this.patients.setPatUserModif(this.usersLog.getUsrid());
                  this.patients = this.patientsDao.modif(this.patients, var10);
                  this.var_action = 0;
               } else {
                  if (this.lesFamilleClientsListe.size() != 0) {
                     new ObjetFamilleTiers();

                     for(int var4 = 0; var4 < this.lesFamilleClientsListe.size(); ++var4) {
                        ObjetFamilleTiers var3 = (ObjetFamilleTiers)this.lesFamilleClientsListe.get(var4);
                        if (this.patients.getLibelleFamille() != null && !this.patients.getLibelleFamille().isEmpty() && this.patients.getLibelleFamille().equalsIgnoreCase(var3.getLibelle())) {
                           break;
                        }
                     }
                  }

                  this.patients.setPatDateCreat(new Date());
                  this.patients.setPatUserCreat(this.usersLog.getUsrid());
                  this.patients.setPatDossier(this.calculChrono.numCompose(this.patients.getPatDateCreat(), 70, this.patients.getPatSerie(), var10));
                  this.patients = this.patientsDao.insert(this.patients, var10);
                  this.lesPatients.add(this.patients);
                  this.dataModelPatients.setWrappedData(this.lesPatients);
                  this.var_action = 2;
                  this.simpleSelectionEntete.clear();
                  this.extDTable = new HtmlExtendedDataTable();
               }

               var13.commit();
            } catch (HibernateException var8) {
               if (var13 != null) {
                  var13.rollback();
               }

               throw var8;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      } else {
         this.var_action = 0;
      }

      if (this.patients.getPatIdUserPaiement() != 0L || this.patients.getPatSalariePaiement() != null && !this.patients.getPatSalariePaiement().isEmpty()) {
         new ArrayList();
         List var11 = this.patientsDao.chargerlesPatients(this.patients.getPatId(), (Session)null);
         if (var11.size() != 0) {
            new Patients();

            for(int var14 = 0; var14 < var11.size(); ++var14) {
               Patients var15 = (Patients)var11.get(var14);
               var15.setPatIdUserPaiement(this.patients.getPatIdUserPaiement());
               var15.setPatSalariePaiement(this.patients.getPatSalariePaiement());
               this.patientsDao.modif(var15);
            }
         }
      }

      boolean var12 = false;
      if (this.memoNom != null && !this.memoNom.isEmpty() && this.patients.getPatNom() != null && !this.patients.getPatNom().isEmpty() && !this.memoNom.equals(this.patients.getPatNom())) {
         var12 = true;
      }

      boolean var16 = false;
      if (this.memoPrenom != null && !this.memoPrenom.isEmpty() && this.patients.getPatPrenom() != null && !this.patients.getPatPrenom().isEmpty() && !this.memoPrenom.equals(this.patients.getPatPrenom())) {
         var16 = true;
      }

      if (var12 || var16) {
         this.changeNomPrenom();
      }

   }

   public void changeNomPrenom() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertMed");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         new ArrayList();
         this.consultationEnteteGeneDao = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
         List var3 = this.consultationEnteteGeneDao.chargerLesMvtsPatients(this.patients, var1);
         if (var3.size() != 0) {
            this.consultationEnteteGene = new ConsultationEnteteGene();

            for(int var4 = 0; var4 < var3.size(); ++var4) {
               this.consultationEnteteGene = (ConsultationEnteteGene)var3.get(var4);
               this.consultationEnteteGene.setCsgNomPatient(this.patients.getPatronyme());
               this.consultationEnteteGene = this.consultationEnteteGeneDao.modif(this.consultationEnteteGene, var1);
            }

            var1.flush();
         }

         new ArrayList();
         this.pharmacieEnteteDao = new PharmacieEnteteDao(this.baseLog, this.utilInitHibernate);
         List var17 = this.pharmacieEnteteDao.chargerLesMvtsPatients(this.patients, var1);
         if (var17.size() != 0) {
            this.pharmacieEntete = new PharmacieEntete();

            for(int var5 = 0; var5 < var17.size(); ++var5) {
               this.pharmacieEntete = (PharmacieEntete)var17.get(var5);
               this.pharmacieEntete.setPhaNomPatient(this.patients.getPatronyme());
               this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
            }

            var1.flush();
         }

         new ArrayList();
         this.laboratoireEnteteDao = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
         List var18 = this.laboratoireEnteteDao.chargerLesMvtsPatients(this.patients, var1);
         if (var18.size() != 0) {
            this.laboratoireEntete = new LaboratoireEntete();

            for(int var6 = 0; var6 < var18.size(); ++var6) {
               this.laboratoireEntete = (LaboratoireEntete)var18.get(var6);
               this.laboratoireEntete.setLabNomPatient(this.patients.getPatronyme());
               this.laboratoireEntete = this.laboratoireEnteteDao.modif(this.laboratoireEntete, var1);
            }

            var1.flush();
         }

         new ArrayList();
         this.hospitalisationEnteteDao = new HospitalisationEnteteDao(this.baseLog, this.utilInitHibernate);
         List var19 = this.hospitalisationEnteteDao.chargerLesMvtsPatients(this.patients, var1);
         if (var19.size() != 0) {
            this.hospitalisationEntete = new HospitalisationEntete();

            for(int var7 = 0; var7 < var19.size(); ++var7) {
               this.hospitalisationEntete = (HospitalisationEntete)var19.get(var7);
               this.hospitalisationEntete.setHosNomPatient(this.patients.getPatronyme());
               this.hospitalisationEntete = this.hospitalisationEnteteDao.modif(this.hospitalisationEntete, var1);
            }

            var1.flush();
         }

         new ArrayList();
         new BonEncaissementVenteDao(this.baseLog, this.utilInitHibernate);
         BonEncaissementVenteDao var8 = new BonEncaissementVenteDao(this.baseLog, this.utilInitHibernate);
         List var20 = var8.rechercheByTiersPatient(this.patients, var1);
         if (var20.size() != 0) {
            new BonEncaissementVente();

            for(int var10 = 0; var10 < var20.size(); ++var10) {
               BonEncaissementVente var9 = (BonEncaissementVente)var20.get(var10);
               var9.setBonNomTiers(this.patients.getPatronyme());
               var8.ModifBon(var9, var1);
            }

            var1.flush();
         }

         new ArrayList();
         this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
         List var21 = this.reglementsDao.chargeReglementPatient(this.patients.getPatId(), var1);
         if (var21.size() != 0) {
            new Reglements();

            for(int var11 = 0; var11 < var21.size(); ++var11) {
               Reglements var22 = (Reglements)var21.get(var11);
               var22.setRglNomTiers(this.patients.getPatronyme());
               this.reglementsDao.modifierReg(var22, var1);
            }

            var1.flush();
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

   public void googleMap() throws IOException, URISyntaxException {
      UtilGoogleMap var1 = new UtilGoogleMap(this.structureLog);
      if (this.showModalPanelFicheAyantDroit) {
         this.uri = var1.calculMap(this.patientsAyantDroit.getPatRue(), this.patientsAyantDroit.getPatAdresse(), this.patientsAyantDroit.getPatVille(), this.patientsAyantDroit.getPatPays());
      } else {
         this.uri = var1.calculMap(this.patients.getPatRue(), this.patients.getPatAdresse(), this.patients.getPatVille(), this.patients.getPatPays());
      }

      this.showModalGoogleMap = true;
   }

   public void annuleGoogleMap() {
      this.showModalGoogleMap = false;
   }

   public void accesPlanning() {
   }

   public void accesMessagerie() {
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
      int var8;
      if (this.nevers != 0) {
         var8 = this.nevers;
      } else {
         var8 = (new Date()).getYear() + 1900 - this.nbAnnee;
         boolean var9 = false;
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

      String var6 = var8 + "-" + var4 + "-" + var5;
      UtilDate var7 = new UtilDate();
      if (this.showModalPanelFicheAyantDroit) {
         this.patientsAyantDroit.setPatDateNaissance(var7.stringToDateSQLLight(var6));
      } else {
         this.patients.setPatDateNaissance(var7.stringToDateSQLLight(var6));
      }

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

   public void testUniciteCI() throws HibernateException, NamingException {
      if (this.patients.getPatCi() != null && !this.patients.getPatCi().isEmpty()) {
         this.rechercheUnicite(this.patients.getPatCi(), this.patients.getPatId());
      }

   }

   public void testUnicitePASSPORT() throws HibernateException, NamingException {
      if (this.patients.getPatPassport() != null && !this.patients.getPatPassport().isEmpty()) {
         this.rechercheUnicite(this.patients.getPatPassport(), this.patients.getPatId());
      }

   }

   public void testUniciteTelDom() throws HibernateException, NamingException {
      if (this.patients.getPatTelDom() != null && !this.patients.getPatTelDom().isEmpty()) {
         this.patients.setPatTelDom(this.patients.getPatTelDom().replace(" ", ""));
         this.patients.setPatTelDom(this.patients.getPatTelDom().replace(".", ""));
         this.patients.setPatTelDom(this.patients.getPatTelDom().replace("-", ""));
         this.patients.setPatTelDom(this.patients.getPatTelDom().replace("/", ""));
         this.rechercheUnicite(this.patients.getPatTelDom(), this.patients.getPatId());
      }

   }

   public void testUniciteCel1() throws HibernateException, NamingException {
      if (this.patients.getPatCel1() != null && !this.patients.getPatCel1().isEmpty()) {
         this.patients.setPatCel1(this.patients.getPatCel1().replace(" ", ""));
         this.patients.setPatCel1(this.patients.getPatCel1().replace(".", ""));
         this.patients.setPatCel1(this.patients.getPatCel1().replace("-", ""));
         this.patients.setPatCel1(this.patients.getPatCel1().replace("/", ""));
         this.rechercheUnicite(this.patients.getPatCel1(), this.patients.getPatId());
      }

   }

   public void testUniciteCel2() throws HibernateException, NamingException {
      if (this.patients.getPatCel2() != null && !this.patients.getPatCel2().isEmpty()) {
         this.patients.setPatCel2(this.patients.getPatCel2().replace(" ", ""));
         this.patients.setPatCel2(this.patients.getPatCel2().replace(".", ""));
         this.patients.setPatCel2(this.patients.getPatCel2().replace("-", ""));
         this.patients.setPatCel2(this.patients.getPatCel2().replace("/", ""));
         this.rechercheUnicite(this.patients.getPatCel2(), this.patients.getPatId());
      }

   }

   public void testUniciteCel3() throws HibernateException, NamingException {
      if (this.patients.getPatCel3() != null && !this.patients.getPatCel3().isEmpty()) {
         this.patients.setPatCel3(this.patients.getPatCel3().replace(" ", ""));
         this.patients.setPatCel3(this.patients.getPatCel3().replace(".", ""));
         this.patients.setPatCel3(this.patients.getPatCel3().replace("-", ""));
         this.patients.setPatCel3(this.patients.getPatCel3().replace("/", ""));
         this.rechercheUnicite(this.patients.getPatCel3(), this.patients.getPatId());
      }

   }

   public void rechercheUnicite(String var1, long var2) throws HibernateException, NamingException {
      new ArrayList();
      String var5 = "from Patients where patId>0 and patId<>" + var2 + " and (patCi = '" + var1 + "' or patPassport = '" + var1 + "' or patCel1 = '" + var1 + "' or patCel2 = '" + var1 + "' or patCel3 = '" + var1 + "' or patTelDom = '" + var1 + "')";
      List var4 = this.patientsDao.chargerListPatients(var5, (Session)null);
      if (var4.size() != 0) {
         this.dataModelPatientDoublon.setWrappedData(var4);
         this.showModalPanelPatientDublon = true;
      }

   }

   public void fermerPatientDoublon() {
      this.showModalPanelPatientDublon = false;
   }

   public void selectionPatientDoublon() {
      if (this.dataModelPatientDoublon.isRowAvailable()) {
         this.patientsDouble = (Patients)this.dataModelPatientDoublon.getRowData();
      }

   }

   public void valideDoublon() throws HibernateException, NamingException, IOException, SQLException {
      if (this.patientsDouble != null) {
         this.patients = this.patientsDouble;
         this.calculePatient();
         this.var_action = 2;
      }

      this.showModalPanelPatientDublon = false;
   }

   public void selectionContact() {
      if (this.datamodelContact.isRowAvailable()) {
         this.patientContact = (PatientContact)this.datamodelContact.getRowData();
         this.afficheButtContact = true;
      }

   }

   public void ajouterContact() {
      this.patientContact = new PatientContact();
      this.var_actionContact = 1;
      this.showModalPanelCnt = true;
   }

   public void modifierContact() {
      if (this.patientContact != null) {
         this.var_actionContact = 2;
         this.showModalPanelCnt = true;
      }

   }

   public void consulterContact() {
      if (this.patientContact != null) {
         this.var_actionContact = 3;
         this.showModalPanelCnt = true;
      }

   }

   public void supprimerContact() throws HibernateException, NamingException {
      if (this.patientContact != null) {
         this.patientContactDao.delete(this.patientContact);
         this.lesContacts.remove(this.patientContact);
         this.datamodelContact.setWrappedData(this.lesContacts);
         this.afficheButtContact = false;
      }

   }

   public void annuleContact() {
      this.showModalPanelCnt = false;
   }

   public void saveContact() throws HibernateException, NamingException {
      if (this.patientContact.getPatconNom() != null && !this.patientContact.getPatconNom().isEmpty()) {
         if (this.patientContact.getPatconId() == 0L) {
            this.patientContact.setPatient(this.patients);
            this.patientContact = this.patientContactDao.insert(this.patientContact);
            this.lesContacts.add(this.patientContact);
            this.datamodelContact.setWrappedData(this.lesContacts);
         } else {
            this.patientContact = this.patientContactDao.modif(this.patientContact);
         }
      }

      this.showModalPanelCnt = false;
   }

   public void selectionProtocole() {
      if (this.datamodelProtocole.isRowAvailable()) {
         this.patientProt = (PatientProt)this.datamodelProtocole.getRowData();
         this.afficheButtProtocole = true;
      }

   }

   public void ajouterProtocole() {
      this.patientProt = new PatientProt();
      this.var_protocole = "";
      this.var_actionProtocole = 1;
      this.showModalPanelPrt = true;
   }

   public void modifierProtocole() {
      if (this.patientProt != null) {
         if (this.patientProt.getPatprtCode() != null && !this.patientProt.getPatprtCode().isEmpty()) {
            this.var_protocole = this.patientProt.getPatprtCode() + ":" + this.patientProt.getPatprtLibelle();
         } else {
            this.var_protocole = "";
         }

         this.var_actionProtocole = 2;
         this.showModalPanelPrt = true;
      }

   }

   public void consulterProtocole() {
      if (this.patientProt != null) {
         if (this.patientProt.getPatprtCode() != null && !this.patientProt.getPatprtCode().isEmpty()) {
            this.var_protocole = this.patientProt.getPatprtCode() + ":" + this.patientProt.getPatprtLibelle();
         } else {
            this.var_protocole = "";
         }

         this.var_actionProtocole = 3;
         this.showModalPanelPrt = true;
      }

   }

   public void supprimerProtocole() throws HibernateException, NamingException {
      if (this.patientProt != null) {
         this.patientProtDao.delete(this.patientProt);
         this.lesProtocole.remove(this.patientProt);
         this.datamodelProtocole.setWrappedData(this.lesProtocole);
         this.afficheButtProtocole = false;
      }

   }

   public void annuleProtocole() {
      this.showModalPanelPrt = false;
   }

   public void saveProtocole() throws HibernateException, NamingException {
      if (this.var_protocole != null && !this.var_protocole.isEmpty() && this.var_protocole.contains(":")) {
         String[] var1 = this.var_protocole.split(":");
         this.patientProt.setPatprtCode(var1[0]);
         this.patientProt.setPatprtLibelle(var1[1]);
         if (this.patientProt.getPatprtId() == 0L) {
            this.patientProt.setPatient(this.patients);
            this.patientProt = this.patientProtDao.insert(this.patientProt);
            this.lesProtocole.add(this.patientProt);
            this.datamodelProtocole.setWrappedData(this.lesProtocole);
         } else {
            this.patientProt = this.patientProtDao.modif(this.patientProt);
         }
      }

      this.afficheButtProtocole = false;
      this.showModalPanelPrt = false;
   }

   public void ajouterAntecedent() throws IOException {
      this.patientAnt = new PatientAnt();
      this.var_antecedent = "";
      this.var_actionAntecedent = 1;
      this.patientAnt.setPatantDate(new Date());
      this.showModalPanelAnt = true;
   }

   public void modifierAntecedent() {
      if (this.patientAnt != null) {
         if (this.patientAnt.getPatantCode() != null && !this.patientAnt.getPatantCode().isEmpty()) {
            this.var_antecedent = this.patientAnt.getPatantCode() + ":" + this.patientAnt.getPatantFamille();
         } else {
            this.var_antecedent = "";
         }

         this.var_actionAntecedent = 2;
         this.showModalPanelAnt = true;
      }

   }

   public void consulterAntecedent() {
      if (this.patientAnt != null) {
         if (this.patientAnt.getPatantCode() != null && !this.patientAnt.getPatantCode().isEmpty()) {
            this.var_antecedent = this.patientAnt.getPatantCode() + ":" + this.patientAnt.getPatantFamille();
         } else {
            this.var_antecedent = "";
         }

         this.var_actionAntecedent = 3;
         this.showModalPanelAnt = true;
      }

   }

   public void supprimerAntecedent() throws HibernateException, NamingException {
      if (this.patientAnt != null) {
         this.patientAntDao.delete(this.patientAnt);
         this.lesAntecedent.remove(this.patientAnt);
         this.datamodelAntecedent.setWrappedData(this.lesAntecedent);
         this.afficheButtAntecedent = false;
      }

   }

   public void selectionAntedent() {
      if (this.datamodelAntecedent.isRowAvailable()) {
         this.patientAnt = (PatientAnt)this.datamodelAntecedent.getRowData();
         this.afficheButtAntecedent = true;
      }

   }

   public void annuleAntecedent() {
      this.showModalPanelAnt = false;
   }

   public void saveAntecedent() throws HibernateException, NamingException {
      if (this.var_antecedent != null && !this.var_antecedent.isEmpty() && this.var_antecedent.contains(":")) {
         String[] var1 = this.var_antecedent.split(":");
         this.patientAnt.setPatantCode(var1[0]);
         this.patientAnt.setPatantFamille(var1[1]);
         if (this.patientAnt.getPatantId() == 0L) {
            this.patientAnt.setPatient(this.patients);
            this.patientAnt.setPatantNumConsultGene("");
            this.patientAnt.setPatantNumConsultSpe("");
            this.patientAnt = this.patientAntDao.insert(this.patientAnt);
            this.lesAntecedent.add(this.patientAnt);
            this.datamodelAntecedent.setWrappedData(this.lesAntecedent);
         } else {
            this.patientAnt = this.patientAntDao.modif(this.patientAnt);
         }
      }

      this.afficheButtAntecedent = false;
      this.showModalPanelAnt = false;
   }

   public void selectionAyantDroit() {
      if (this.datamodelAyd.isRowAvailable()) {
         this.patientsAyantDroit = (Patients)this.datamodelAyd.getRowData();
         this.afficheButtAyd = true;
      }

   }

   public void ajouterAyantDroit() {
      this.patientsAyantDroit = new Patients();
      this.patientsAyantDroit.setPatIdCouvertPar(this.patients.getPatId());
      this.patientsAyantDroit.setPatDossier(this.patients.getPatDossier() + "-" + this.lesPatientsAyantDroit.size());
      this.patientsAyantDroit.setPatAdresse(this.patients.getPatAdresse());
      this.patientsAyantDroit.setPatAdresseBanque(this.patients.getPatAdresseBanque());
      this.patientsAyantDroit.setPatAscensseur(this.patients.getPatAscensseur());
      this.patientsAyantDroit.setPatAssurance(this.patients.getPatAssurance());
      this.patientsAyantDroit.setPatBatiment(this.patients.getPatBatiment());
      this.patientsAyantDroit.setPatBp(this.patients.getPatBp());
      this.patientsAyantDroit.setPatBurFax(this.patients.getPatBurFax());
      this.patientsAyantDroit.setPatBurTel1(this.patients.getPatBurTel1());
      this.patientsAyantDroit.setPatBurTel2(this.patients.getPatBurTel2());
      this.patientsAyantDroit.setPatCedex(this.patients.getPatCedex());
      this.patientsAyantDroit.setPatCleBanque(this.patients.getPatCleBanque());
      this.patientsAyantDroit.setPatCnamgs(this.patients.getPatCnamgs());
      this.patientsAyantDroit.setPatCommune(this.patients.getPatCommune());
      this.patientsAyantDroit.setPatComplementaire(this.patients.getPatComplementaire());
      this.patientsAyantDroit.setPatCompte(this.patients.getPatCompte());
      this.patientsAyantDroit.setPatCompteBanque(this.patients.getPatCompteBanque());
      this.patientsAyantDroit.setPatConditionreg(this.patients.getPatConditionreg());
      this.patientsAyantDroit.setPatDateCreat(new Date());
      this.patientsAyantDroit.setPatEtage(this.patients.getPatEtage());
      this.patientsAyantDroit.setPatGuichetBanque(this.patients.getPatGuichetBanque());
      this.patientsAyantDroit.setPatHabitat(this.patients.getPatHabitat());
      this.patientsAyantDroit.setPatIban(this.patients.getPatIban());
      this.patientsAyantDroit.setPatIdAssurance(this.patients.getPatIdAssurance());
      this.patientsAyantDroit.setPatIdComplementaire(this.patients.getPatIdComplementaire());
      this.patientsAyantDroit.setPatIdSociete(this.patients.getPatIdSociete());
      this.patientsAyantDroit.setPatIlot(this.patients.getPatIlot());
      this.patientsAyantDroit.setPatImmatriculation(this.patients.getPatImmatriculation());
      this.patientsAyantDroit.setPatLot(this.patients.getPatLot());
      this.patientsAyantDroit.setPatModereg(this.patients.getPatModereg());
      this.patientsAyantDroit.setPatNbarrondi(this.patients.getPatNbarrondi());
      this.patientsAyantDroit.setPatNom(this.patients.getPatNom());
      this.patientsAyantDroit.setPatNbecheance(this.patients.getPatNbecheance());
      this.patientsAyantDroit.setPatNomBanque(this.patients.getPatNomBanque());
      this.patientsAyantDroit.setPatNomFamille(this.patients.getPatNomFamille());
      this.patientsAyantDroit.setPatNumBanque(this.patients.getPatNumBanque());
      this.patientsAyantDroit.setPatNumContrat(this.patients.getPatNumContrat());
      this.patientsAyantDroit.setPatObservations(this.patients.getPatObservations());
      this.patientsAyantDroit.setPatPays(this.patients.getPatPays());
      this.patientsAyantDroit.setPatPaysNaissance(this.patients.getPatPaysNaissance());
      this.patientsAyantDroit.setPatPec(this.patients.getPatPec());
      this.patientsAyantDroit.setPatPorte(this.patients.getPatPorte());
      this.patientsAyantDroit.setPatPourcentCasSocial(this.patients.getPatPourcentCasSocial());
      this.patientsAyantDroit.setPatQuartier(this.patients.getPatQuartier());
      this.patientsAyantDroit.setPatRue(this.patients.getPatRue());
      this.patientsAyantDroit.setPatSecu(this.patients.getPatSecu());
      this.patientsAyantDroit.setPatSerie(this.patients.getPatSerie());
      this.patientsAyantDroit.setPatSociete(this.patients.getPatSociete());
      this.patientsAyantDroit.setPatSwift(this.patients.getPatSwift());
      this.patientsAyantDroit.setPatTelDom(this.patients.getPatTelDom());
      this.patientsAyantDroit.setPatTelVoiture(this.patients.getPatTelVoiture());
      this.patientsAyantDroit.setPatTypereg(this.patients.getPatTypereg());
      this.patientsAyantDroit.setPatUserCreat(this.usersLog.getUsrid());
      this.patientsAyantDroit.setPatVille(this.patients.getPatVille());
      this.patientsAyantDroit.setPatZone(this.patients.getPatZone());
      this.showModalPanelFicheAyantDroit = true;
   }

   public void modifierAyantDroit() {
      if (this.patientsAyantDroit != null) {
         this.showModalPanelFicheAyantDroit = true;
      }

   }

   public void consulterAyantDroit() {
      if (this.patientsAyantDroit != null) {
         this.showModalPanelFicheAyantDroit = true;
      }

   }

   public void supprimerAyantDroit() throws HibernateException, NamingException {
      if (this.patientsAyantDroit != null) {
         this.supressionTiersPatient(this.patientsAyantDroit);
         this.lesPatientsAyantDroit.remove(this.patientsAyantDroit);
         this.afficheButtAyd = false;
      }

   }

   public void fermerAyantDroit() {
      this.afficheButtAyd = false;
      this.showModalPanelFicheAyantDroit = false;
   }

   public void valideAyantDroit() throws HibernateException, NamingException {
      if (this.patients.getPatId() == 0L) {
         this.moduleMajPatient();
      }

      if (this.patientsAyantDroit.getPatNom() != null && !this.patientsAyantDroit.getPatNom().isEmpty() && this.patientsAyantDroit.getPatDateNaissance() != null && (this.patientsAyantDroit.getPatTelDom() != null && !this.patientsAyantDroit.getPatTelDom().isEmpty() || this.patientsAyantDroit.getPatCel1() != null && !this.patientsAyantDroit.getPatCel1().isEmpty() || this.patientsAyantDroit.getPatCel2() != null && !this.patientsAyantDroit.getPatCel2().isEmpty() || this.patientsAyantDroit.getPatCel3() != null && !this.patientsAyantDroit.getPatCel3().isEmpty())) {
         if (this.patientsAyantDroit.getPatSerie() == null || this.patientsAyantDroit.getPatSerie().isEmpty()) {
            this.patientsAyantDroit.setPatSerie("A");
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Patients");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.patientsAyantDroit.getPatQualite() != null && !this.patientsAyantDroit.getPatQualite().isEmpty() && this.patientsAyantDroit.getPatQualite().equalsIgnoreCase("Enfant")) {
               String var3 = "";
               if (this.patients.getPatPrenom() != null && !this.patients.getPatPrenom().isEmpty()) {
                  var3 = this.patients.getPatNom() + " " + this.patients.getPatPrenom();
               } else {
                  var3 = this.patients.getPatNom();
               }

               if (this.patients.getPatSexe() == 0) {
                  this.patientsAyantDroit.setPatNomMere(var3);
               } else {
                  this.patientsAyantDroit.setPatNomPere(var3);
               }
            }

            this.patientsAyantDroit.setPatIdAssurance(this.patients.getPatIdAssurance());
            this.patientsAyantDroit.setPatIdSociete(this.patients.getPatIdSociete());
            this.patientsAyantDroit.setPatIdComplementaire(this.patients.getPatIdComplementaire());
            this.patientsAyantDroit.setPatAssurance(this.patients.getPatAssurance());
            this.patientsAyantDroit.setPatSociete(this.patients.getPatSociete());
            this.patientsAyantDroit.setPatComplementaire(this.patients.getPatComplementaire());
            this.patientsAyantDroit.setPatNumContrat(this.patients.getPatNumContrat());
            this.patientsAyantDroit.setPatPec(this.patients.getPatPec());
            this.patientsAyantDroit.setPatPecComplementaire(this.patients.getPatPecComplementaire());
            if (this.patientsAyantDroit.getPatId() == 0L) {
               this.patientsAyantDroit = this.patientsDao.insert(this.patientsAyantDroit, var1);
               this.lesPatientsAyantDroit.add(this.patientsAyantDroit);
               this.datamodelAyd.setWrappedData(this.lesPatientsAyantDroit);
            } else {
               this.patientsAyantDroit = this.patientsDao.modif(this.patientsAyantDroit, var1);
            }

            new ArrayList();
            List var11 = this.patientPecDao.chargerLesPatientsPec(this.patientsAyantDroit, 9, var1);
            PatientPec var4;
            int var5;
            if (var11.size() != 0) {
               new PatientPec();

               for(var5 = 0; var5 < var11.size(); ++var5) {
                  var4 = (PatientPec)var11.get(var5);
                  this.patientPecDao.delete(var4, var1);
               }
            }

            var11.clear();
            if (this.lesPec.size() != 0) {
               new PatientPec();

               for(var5 = 0; var5 < this.lesPec.size(); ++var5) {
                  this.patientPec = (PatientPec)this.lesPec.get(var5);
                  if (this.patientPec.getPatpecInactif() == 0) {
                     var4 = new PatientPec();
                     var4.setPatient(this.patientsAyantDroit);
                     var4.setTiers(this.patientPec.getTiers());
                     var4.setPatpacHotelerie(this.patientPec.getPatpacHotelerie());
                     var4.setPatpecAgentRefact("");
                     var4.setPatpecDateDebut(this.patientPec.getPatpecDateDebut());
                     var4.setPatpecDateFin(this.patientPec.getPatpecDateFin());
                     var4.setPatpecDentaire(this.patientPec.getPatpecDentaire());
                     var4.setPatpecExamenss(this.patientPec.getPatpecExamenss());
                     var4.setPatpecForfait(this.patientPec.getPatpecForfait());
                     var4.setPatpecHebergementPlaf(this.patientPec.getPatpecHebergementPlaf());
                     var4.setPatpecHebergementRep(this.patientPec.getPatpecHebergementRep());
                     var4.setPatpecIdCouvert(this.patients.getPatId());
                     var4.setPatpecIdEmployeur(this.patientPec.getPatpecIdEmployeur());
                     var4.setPatpecMatricule(this.patientsAyantDroit.getPatImmatriculation());
                     var4.setPatpecMatriculeCouvert(this.patients.getPatImmatriculation());
                     var4.setPatpecMedicament(this.patientPec.getPatpecMedicament());
                     if (this.patients.getPatPrenom() != null && !this.patients.getPatPrenom().isEmpty()) {
                        var4.setPatpecNomCouvert(this.patients.getPatNom() + " " + this.patients.getPatPrenom());
                     } else {
                        var4.setPatpecNomCouvert(this.patients.getPatNom());
                     }

                     var4.setPatpecNomEmployeur(this.patientPec.getPatpecNomEmployeur());
                     var4.setPatpecNumCnamgs(this.patientsAyantDroit.getPatCnamgs());
                     var4.setPatpecNumCnss(this.patientsAyantDroit.getPatSecu());
                     var4.setPatpecNumContrat(this.patientPec.getPatpecNumContrat());
                     var4.setPatpecOcculaire(this.patientPec.getPatpecOcculaire());
                     var4.setPatpecPrestations(this.patientPec.getPatpecPrestations());
                     var4.setPatpecSoins(this.patientPec.getPatpecSoins());
                     var4.setPatpecType(this.patientPec.getPatpecType());
                     this.patientPecDao.insert(var4, var1);
                  }
               }
            }

            int var12 = 0;
            if (this.lesPatientsAyantDroit.size() != 0) {
               for(var5 = 0; var5 < this.lesPatientsAyantDroit.size(); ++var5) {
                  if (((Patients)this.lesPatientsAyantDroit.get(var5)).getPatQualite() != null && !((Patients)this.lesPatientsAyantDroit.get(var5)).getPatQualite().isEmpty() && ((Patients)this.lesPatientsAyantDroit.get(var5)).getPatQualite().equalsIgnoreCase("Enfant")) {
                     ++var12;
                  }
               }
            }

            this.patients.setPatNbEnfant(var12);
            this.patients = this.patientsDao.modif(this.patients, var1);
            var2.commit();
         } catch (HibernateException var9) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.showModalPanelFicheAyantDroit = false;
      }

   }

   public void calculeGenreAyantDroit() {
      if (!this.patientsAyantDroit.getPatCivilite().equals("Madame") && !this.patientsAyantDroit.getPatCivilite().equals("Mademoiselle")) {
         this.patientsAyantDroit.setPatSexe(1);
      } else {
         this.patientsAyantDroit.setPatSexe(0);
      }

   }

   public void selectionTypePec() throws HibernateException, NamingException {
      if (this.patients.getPatId() == 0L) {
         this.moduleMajPatient();
      }

      if (this.patients.getPatNomFamille() != 1 && this.patients.getPatNomFamille() != -2) {
         if (this.patients.getPatNomFamille() == 0) {
            this.patients.setPatPourcentCasSocial(0.0F);
         } else if (this.patients.getPatNomFamille() == -1) {
         }
      } else {
         this.patients.setPatPourcentCasSocial(0.0F);
      }

      this.patientsDao.modif(this.patients);
   }

   public void ajouterPec() throws IOException {
      this.patientPec = new PatientPec();
      this.tiers = new Tiers();
      this.patientPec.setPatpecType("Assurance");
      this.var_tiers = "";
      this.urlphoto = null;
      this.var_actionPec = 1;
      this.lesEmployeursItems.clear();
      this.lesEmployeursItems.add(new SelectItem(""));
      this.showModalPanelPec = true;
   }

   public void modifierPec() {
      if (this.patientPec != null) {
         this.var_actionPec = 2;
         this.showModalPanelPec = true;
      }

   }

   public void consulterPec() {
      if (this.patientPec != null) {
         this.var_actionPec = 3;
         this.showModalPanelPec = true;
      }

   }

   public void supprimerPec() throws HibernateException, NamingException {
      if (this.patientPec != null) {
         this.patientPecDao.delete(this.patientPec);
         this.lesPec.remove(this.patientPec);
         this.datamodelPec.setWrappedData(this.lesPec);
         this.afficheButtPec = false;
      }

   }

   public void annulerPec() {
      this.var_actionPec = 0;
      this.var_tiers = "";
      this.showModalPanelPec = false;
      this.afficheButtPec = false;
   }

   public void selectionPec() throws HibernateException, NamingException, IOException, SQLException {
      if (this.datamodelPec.isRowAvailable()) {
         this.patientPec = (PatientPec)this.datamodelPec.getRowData();
         this.tiers = this.patientPec.getTiers();
         this.var_tiers = this.tiers.getTieraisonsocialenom();
         this.lesEmployeursItems.clear();
         if (this.patientPec.getPatpecType() != null && !this.patientPec.getPatpecType().isEmpty() && (this.patientPec.getPatpecType().equals("Assurance") || this.patientPec.getPatpecType().equals("IPM"))) {
            TiersAdherentDao var1 = new TiersAdherentDao(this.baseLog, this.utilInitHibernate);
            this.lesEmployeursItems = var1.listAdherentByTiersItems(this.tiers, (Session)null);
         }

         if (this.lesEmployeursItems.size() == 0) {
            this.lesEmployeursItems.add(new SelectItem(""));
         }

         this.afficheButtPec = true;
         this.affichePhotoPec();
      }

   }

   public void savePec() throws HibernateException, NamingException {
      if (this.patients.getPatId() == 0L) {
         this.moduleMajPatient();
      }

      if (this.tiers != null && this.tiers.getTieid() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Patients");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            long var3 = 0L;
            if (this.lesEmployeursItems.size() != 0) {
               TiersAdherentDao var5 = new TiersAdherentDao(this.baseLog, this.utilInitHibernate);

               for(int var6 = 0; var6 < this.lesEmployeursItems.size(); ++var6) {
                  if (this.patientPec.getPatpecNomEmployeur() != null && !this.patientPec.getPatpecNomEmployeur().isEmpty() && ((SelectItem)this.lesEmployeursItems.get(var6)).getValue().toString() != null && !((SelectItem)this.lesEmployeursItems.get(var6)).getValue().toString().isEmpty() && this.patientPec.getPatpecNomEmployeur().equals(((SelectItem)this.lesEmployeursItems.get(var6)).getValue().toString())) {
                     var3 = var5.listAdherentByTiersEmployeur(this.tiers.getTieid(), this.patientPec.getPatpecNomEmployeur(), var1);
                     break;
                  }
               }
            }

            this.patientPec.setPatpecIdEmployeur(var3);
            if (this.patientPec.getPatpecId() == 0L) {
               this.patientPec.setPatient(this.patients);
               this.patientPec.setTiers(this.tiers);
               this.patientPec = this.patientPecDao.insert(this.patientPec, var1);
               this.lesPec.add(this.patientPec);
               this.datamodelPec.setWrappedData(this.lesPec);
            } else {
               this.patientPec.setTiers(this.tiers);
               this.patientPec = this.patientPecDao.modif(this.patientPec, var1);
            }

            this.patients.setPatPec("");
            this.patients.setPatSociete("");
            this.patients.setPatIdSociete(0L);
            this.patients.setPatAssurance("");
            this.patients.setPatIdAssurance(0L);
            this.patients.setPatComplementaire("");
            this.patients.setPatIdComplementaire(0L);
            int var14;
            if (this.lesPec.size() == 0) {
               this.patients.setPatPec("");
               this.patients.setPatNomFamille(0);
            } else {
               this.patients.setPatNomFamille(1);

               for(var14 = 0; var14 < this.lesPec.size(); ++var14) {
                  if (!this.patients.getPatPec().equals("Assurance") && !this.patients.getPatPec().equals("IPM") && !this.patients.getPatPec().equals("Programme Médical")) {
                     if (!this.patients.getPatPec().equals("Mutuelle") && !this.patients.getPatPec().equals("Complémentaire")) {
                        this.patients.setPatPec(((PatientPec)this.lesPec.get(var14)).getTiers().getTiecategorie());
                        this.patients.setPatSociete(((PatientPec)this.lesPec.get(var14)).getTiers().getTieraisonsocialenom());
                        this.patients.setPatIdSociete(((PatientPec)this.lesPec.get(var14)).getTiers().getTieid());
                        if (((PatientPec)this.lesPec.get(var14)).getPatpecMatricule() != null && !((PatientPec)this.lesPec.get(var14)).getPatpecMatricule().isEmpty()) {
                           this.patients.setPatImmatriculation(((PatientPec)this.lesPec.get(var14)).getPatpecMatricule());
                        }
                     } else {
                        if (this.patients.getPatPec() == null || this.patients.getPatPec().isEmpty()) {
                           this.patients.setPatPec(((PatientPec)this.lesPec.get(var14)).getTiers().getTiecategorie());
                        }

                        this.patients.setPatComplementaire(((PatientPec)this.lesPec.get(var14)).getTiers().getTieraisonsocialenom());
                        this.patients.setPatIdComplementaire(((PatientPec)this.lesPec.get(var14)).getTiers().getTieid());
                     }
                  } else {
                     this.patients.setPatPec(((PatientPec)this.lesPec.get(var14)).getTiers().getTiecategorie());
                     this.patients.setPatAssurance(((PatientPec)this.lesPec.get(var14)).getTiers().getTieraisonsocialenom());
                     this.patients.setPatIdAssurance(((PatientPec)this.lesPec.get(var14)).getTiers().getTieid());
                     if (((PatientPec)this.lesPec.get(var14)).getPatpecNumContrat() != null && !((PatientPec)this.lesPec.get(var14)).getPatpecNumContrat().isEmpty()) {
                        this.patients.setPatNumContrat(((PatientPec)this.lesPec.get(var14)).getPatpecNumContrat());
                     }
                  }
               }
            }

            this.patients.setPatIdCouvertPar(this.patientPec.getPatpecIdCouvert());
            this.patients = this.patientsDao.modif(this.patients, var1);
            if (this.lesPatientsAyantDroit.size() != 0) {
               for(var14 = 0; var14 < this.lesPatientsAyantDroit.size(); ++var14) {
                  this.patientsAyantDroit = (Patients)this.lesPatientsAyantDroit.get(var14);
                  this.patientsAyantDroit.setPatAssurance(this.patients.getPatAssurance());
                  this.patientsAyantDroit.setPatComplementaire(this.patients.getPatComplementaire());
                  this.patientsAyantDroit.setPatIdAssurance(this.patients.getPatIdAssurance());
                  this.patientsAyantDroit.setPatIdComplementaire(this.patients.getPatIdComplementaire());
                  this.patientsAyantDroit.setPatIdSociete(this.patients.getPatIdSociete());
                  this.patientsAyantDroit.setPatNomFamille(this.patients.getPatNomFamille());
                  this.patientsAyantDroit.setPatPec(this.patients.getPatPec());
                  this.patientsAyantDroit.setPatPourcentCasSocial(this.patients.getPatPourcentCasSocial());
                  this.patientsAyantDroit.setPatSociete(this.patients.getPatSociete());
                  this.patientsAyantDroit = this.patientsDao.modif(this.patientsAyantDroit, var1);
                  new ArrayList();
                  List var15 = this.patientPecDao.chargerLesPatientsPec(this.patientsAyantDroit, 9, var1);
                  if (var15.size() != 0) {
                     for(int var7 = 0; var7 < var15.size(); ++var7) {
                        this.patientPec = (PatientPec)var15.get(var7);
                        this.patientPecDao.delete(this.patientPec, var1);
                     }
                  }

                  if (this.lesPec.size() != 0) {
                     new PatientPec();

                     for(int var8 = 0; var8 < this.lesPec.size(); ++var8) {
                        this.patientPec = (PatientPec)this.lesPec.get(var8);
                        if (this.patientPec.getPatpecInactif() == 0) {
                           PatientPec var16 = new PatientPec();
                           var16.setPatient(this.patientsAyantDroit);
                           var16.setTiers(this.patientPec.getTiers());
                           var16.setPatpacHotelerie(this.patientPec.getPatpacHotelerie());
                           var16.setPatpecAgentRefact("");
                           var16.setPatpecDateDebut(this.patientPec.getPatpecDateDebut());
                           var16.setPatpecDateFin(this.patientPec.getPatpecDateFin());
                           var16.setPatpecDentaire(this.patientPec.getPatpecDentaire());
                           var16.setPatpecExamenss(this.patientPec.getPatpecExamenss());
                           var16.setPatpecExamenssHospit(this.patientPec.getPatpecExamenssHospit());
                           var16.setPatpecForfait(this.patientPec.getPatpecForfait());
                           var16.setPatpecHebergementPlaf(this.patientPec.getPatpecHebergementPlaf());
                           var16.setPatpecHebergementRep(this.patientPec.getPatpecHebergementRep());
                           var16.setPatpecIdCouvert(this.patients.getPatId());
                           var16.setPatpecIdEmployeur(this.patientPec.getPatpecIdEmployeur());
                           var16.setPatpecNomEmployeur(this.patientPec.getPatpecNomEmployeur());
                           var16.setPatpecMatricule(this.patientsAyantDroit.getPatImmatriculation());
                           var16.setPatpecMatriculeCouvert(this.patients.getPatImmatriculation());
                           var16.setPatpecMedicament(this.patientPec.getPatpecMedicament());
                           var16.setPatpecMedicamentHospit(this.patientPec.getPatpecMedicamentHospit());
                           if (this.patients.getPatPrenom() != null && !this.patients.getPatPrenom().isEmpty()) {
                              var16.setPatpecNomCouvert(this.patients.getPatNom() + " " + this.patients.getPatPrenom());
                           } else {
                              var16.setPatpecNomCouvert(this.patients.getPatNom());
                           }

                           var16.setPatpecNumCnamgs(this.patientsAyantDroit.getPatCnamgs());
                           var16.setPatpecNumCnss(this.patientsAyantDroit.getPatSecu());
                           var16.setPatpecNumContrat(this.patientPec.getPatpecNumContrat());
                           var16.setPatpecOcculaire(this.patientPec.getPatpecOcculaire());
                           var16.setPatpecPrestations(this.patientPec.getPatpecPrestations());
                           var16.setPatpecSoins(this.patientPec.getPatpecSoins());
                           var16.setPatpecSoinsHospit(this.patientPec.getPatpecSoinsHospit());
                           var16.setPatpecType(this.patientPec.getPatpecType());
                           this.patientPecDao.insert(var16, var1);
                        }
                     }
                  }
               }
            }

            var2.commit();
         } catch (HibernateException var12) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var12;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.afficheButtPec = false;
      this.showModalPanelPec = false;
   }

   public void ajouterPhotoPec() throws HibernateException, NamingException {
      if (this.patientPec.getPatpecId() == 0L) {
         this.savePec();
      }

      if (this.patientPec.getPatpecId() != 0L && this.patientPec.getTiers() != null) {
         FacesContext var1 = FacesContext.getCurrentInstance();

         try {
            if (this.uploadedFile != null) {
               File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanPriseEnCharge");
               if (!var2.exists()) {
                  var2.mkdir();
               }

               String var3;
               if (this.patientPec.getPatpecScan() != null && !this.patientPec.getPatpecScan().isEmpty()) {
                  var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanPriseEnCharge") + File.separator + this.patientPec.getPatpecScan();
                  File var4 = new File(var3);
                  if (var4.exists()) {
                     var4.delete();
                  }
               }

               var3 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
               String var8 = var3.substring(var3.indexOf(".") + 1);
               String var5 = "PEC_" + this.patients.getPatDossier() + "_" + this.patientPec.getPatpecId();
               var3 = var5 + "." + var8;
               File var6 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanPriseEnCharge" + File.separator), var3);
               this.utilDownload.write(var6, this.uploadedFile.getInputStream());
               this.fileName = var3;
               var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
               this.patientPec.setPatpecScan(var3);
               this.patientPec = this.patientPecDao.modif(this.patientPec);
               this.urlphoto = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanPriseEnCharge" + File.separator + this.patientPec.getPatpecScan();
            }
         } catch (IOException var7) {
            this.patientPec.setPatpecScan(this.fileName);
            var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var7.printStackTrace();
         }
      }

   }

   public void supprimerPhotoPec() throws IOException, SQLException, HibernateException, NamingException {
      String var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanPriseEnCharge") + File.separator + this.patientPec.getPatpecScan();
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

      this.affichePhotoPec();
      this.patientPec.setPatpecScan((String)null);
      this.patientPecDao.modif(this.patientPec);
   }

   public void affichePhotoPec() throws IOException, SQLException {
      if (this.patientPec.getPatpecScan() != null && !this.patientPec.getPatpecScan().isEmpty()) {
         this.urlphoto = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanPriseEnCharge" + File.separator + this.patientPec.getPatpecScan();
      } else {
         this.urlphoto = null;
      }

   }

   public void ajouterFda() throws IOException {
      this.patientLettreGarantie = new PatientLettreGarantie();
      this.patientLettreGarantie.setPatlgaDate(new Date());
      this.tiers = new Tiers();
      this.urlphoto = null;
      this.var_actionFda = 1;
      this.showModalPanelFda = true;
   }

   public void modifierFda() {
      if (this.patientLettreGarantie != null) {
         this.var_actionFda = 2;
         this.showModalPanelFda = true;
      }

   }

   public void consulterFda() {
      if (this.patientLettreGarantie != null) {
         this.var_actionFda = 3;
         this.showModalPanelFda = true;
      }

   }

   public void supprimerFda() throws HibernateException, NamingException {
      if (this.patientLettreGarantie != null) {
         this.patientLettreGarantieDao.delete(this.patientLettreGarantie);
         this.lesFda.remove(this.patientLettreGarantie);
         this.datamodelFda.setWrappedData(this.lesFda);
         this.afficheButtFda = false;
      }

   }

   public void annulerFda() {
      this.var_actionFda = 0;
      this.showModalPanelFda = false;
      this.afficheButtFda = false;
   }

   public void selectionFda() throws HibernateException, NamingException, IOException, SQLException {
      if (this.datamodelFda.isRowAvailable()) {
         this.patientLettreGarantie = (PatientLettreGarantie)this.datamodelFda.getRowData();
         this.afficheButtFda = true;
         this.affichePhotoFda();
      }

   }

   public void saveFda() throws HibernateException, NamingException {
      if (this.patients.getPatId() == 0L) {
         this.moduleMajPatient();
      }

      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Patients");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.patientLettreGarantie.getPatlgaId() == 0L) {
            this.patientLettreGarantie.setPatlgaDateCreat(new Date());
            this.patientLettreGarantie.setPatlgaIdCreateur(this.usersLog.getUsrid());
            this.patientLettreGarantie.setPatient(this.patients);
            this.patientLettreGarantie.setTiers((Tiers)null);
            this.patientLettreGarantie.setPatlgaType(1);
            this.patientLettreGarantie.setPatlgaEtat(1);
            this.patientLettreGarantie = this.patientLettreGarantieDao.insert(this.patientLettreGarantie, var1);
            this.lesFda.add(this.patientLettreGarantie);
            this.datamodelFda.setWrappedData(this.lesFda);
         } else {
            this.patientLettreGarantie.setPatlgaDateModif(new Date());
            this.patientLettreGarantie.setPatlgaIdModif(this.usersLog.getUsrid());
            this.patientLettreGarantie.setTiers((Tiers)null);
            this.patientLettreGarantie.setPatlgaType(1);
            this.patientLettreGarantie.setPatlgaEtat(1);
            this.patientLettreGarantie = this.patientLettreGarantieDao.modif(this.patientLettreGarantie, var1);
         }

         this.patients.setPatPourcentCasSocial(this.patientLettreGarantie.getPatlgaTauxReduction());
         this.patients = this.patientsDao.modif(this.patients, var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.afficheButtFda = false;
      this.showModalPanelFda = false;
   }

   public void ajouterPhotoFda() throws HibernateException, NamingException {
      if (this.patientLettreGarantie.getPatlgaId() == 0L) {
         this.saveFda();
      }

      if (this.patientLettreGarantie.getPatlgaId() != 0L) {
         FacesContext var1 = FacesContext.getCurrentInstance();

         try {
            if (this.uploadedFile != null) {
               File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanPriseEnCharge");
               if (!var2.exists()) {
                  var2.mkdir();
               }

               String var3;
               if (this.patientLettreGarantie.getPatlgaPhoto() != null && !this.patientLettreGarantie.getPatlgaPhoto().isEmpty()) {
                  var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanPriseEnCharge") + File.separator + this.patientLettreGarantie.getPatlgaPhoto();
                  File var4 = new File(var3);
                  if (var4.exists()) {
                     var4.delete();
                  }
               }

               var3 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
               String var8 = var3.substring(var3.indexOf(".") + 1);
               String var5 = "FDA_" + this.patients.getPatDossier() + "_" + this.patientLettreGarantie.getPatlgaId();
               var3 = var5 + "." + var8;
               File var6 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanPriseEnCharge" + File.separator), var3);
               this.utilDownload.write(var6, this.uploadedFile.getInputStream());
               this.fileName = var3;
               var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
               this.patientLettreGarantie.setPatlgaPhoto(var3);
               this.patientLettreGarantie = this.patientLettreGarantieDao.modif(this.patientLettreGarantie);
               this.urlphoto = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanPriseEnCharge" + File.separator + this.patientLettreGarantie.getPatlgaPhoto();
            }
         } catch (IOException var7) {
            this.patientLettreGarantie.setPatlgaPhoto(this.fileName);
            var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var7.printStackTrace();
         }
      }

   }

   public void supprimerPhotoFda() throws IOException, SQLException, HibernateException, NamingException {
      String var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanPriseEnCharge") + File.separator + this.patientLettreGarantie.getPatlgaPhoto();
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

      this.affichePhotoFda();
      this.patientLettreGarantie.setPatlgaPhoto((String)null);
      this.patientLettreGarantieDao.modif(this.patientLettreGarantie);
   }

   public void affichePhotoFda() throws IOException, SQLException {
      if (this.patientLettreGarantie.getPatlgaPhoto() != null && !this.patientLettreGarantie.getPatlgaPhoto().isEmpty()) {
         this.urlphoto = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanPriseEnCharge" + File.separator + this.patientLettreGarantie.getPatlgaPhoto();
      } else {
         this.urlphoto = null;
      }

   }

   public void rechercheTiers() throws HibernateException, NamingException {
      this.lesTiers.clear();
      TiersDao var1 = new TiersDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var2 = var1.chargerLesTiersByCatMedical("3", this.patientPec.getPatpecType(), this.var_tiers, (Session)null);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((Tiers)var2.get(var3)).getTieetat() == 0) {
               this.lesTiers.add(var2.get(var3));
            }
         }
      }

      this.datamodelTiers.setWrappedData(this.lesTiers);
      this.showModalPanelTiers = true;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void selectionTiers() {
      this.tiers = new Tiers();
      if (this.datamodelTiers.isRowAvailable()) {
         this.tiers = (Tiers)this.datamodelTiers.getRowData();
      }

   }

   public void annuleTiers() {
      this.nomTiers = "";
      this.tiers = new Tiers();
      this.showModalPanelTiers = false;
   }

   public void calculeTiers() throws HibernateException, NamingException {
      if (this.tiers != null) {
         this.var_tiers = this.tiers.getTieraisonsocialenom();
         this.nomTiers = this.tiers.getTieraisonsocialenom();
      } else {
         this.var_tiers = "";
         this.nomTiers = "";
      }

      this.lesEmployeursItems.clear();
      if (this.tiers.getTiecategorie() != null && !this.tiers.getTiecategorie().isEmpty() && (this.tiers.getTiecategorie().equalsIgnoreCase("Assurance") || this.tiers.getTiecategorie().equalsIgnoreCase("IPM"))) {
         TiersAdherentDao var1 = new TiersAdherentDao(this.baseLog, this.utilInitHibernate);
         this.lesEmployeursItems = var1.listAdherentByTiersItems(this.tiers, (Session)null);
      }

      if (this.lesEmployeursItems.size() == 0) {
         this.lesEmployeursItems.add(new SelectItem(""));
      }

      this.showModalPanelTiers = false;
   }

   public void changeTiersPayant() {
      this.patientPec.setPatpecIdEmployeur(0L);
      this.patientPec.setPatpecNomEmployeur("");
      this.patientPec.setTiers((Tiers)null);
      this.var_tiers = "";
      this.lesEmployeursItems.clear();
      this.lesEmployeursItems.add(new SelectItem(""));
   }

   public void calculReglementTiers() {
      this.patients.setPatNbecheance(0);
      this.patients.setPatNbarrondi(0);
      this.patients.setPatConditionreg("");
      if (this.lesReglementsClient.size() != 0) {
         for(int var1 = 0; var1 < this.lesReglementsClient.size(); ++var1) {
            new ObjetReglement();
            ObjetReglement var2 = (ObjetReglement)this.lesReglementsClient.get(var1);
            if (this.patients.getPatModereg().equalsIgnoreCase(var2.getLibelles())) {
               if (var2.getNbjours().isEmpty()) {
                  this.patients.setPatNbecheance(0);
               } else {
                  this.patients.setPatNbecheance(Integer.parseInt(var2.getNbjours()));
               }

               if (var2.getArrondis().isEmpty()) {
                  this.patients.setPatNbarrondi(0);
               } else {
                  this.patients.setPatNbarrondi(Integer.parseInt(var2.getArrondis()));
               }

               this.patients.setPatConditionreg(var2.getConditions());
               break;
            }
         }
      }

   }

   public void griserModeCalcul() {
      if (this.patients.getPatTypereg() != 1 && this.patients.getPatTypereg() != 2) {
         this.testModeCalcul = false;
      } else {
         this.testModeCalcul = true;
      }

   }

   public void affichePhoto() throws IOException, SQLException {
      if (this.showModalPanelFicheAyantDroit) {
         if (this.patientsAyantDroit.getPatPhoto() != null) {
            this.urlphoto = "structure" + this.structureLog.getStrid() + "/photos/Patients/" + this.patientsAyantDroit.getPatPhoto();
         } else {
            this.urlphoto = null;
         }
      } else if (this.patients.getPatPhoto() != null) {
         this.urlphoto = "structure" + this.structureLog.getStrid() + "/photos/Patients/" + this.patients.getPatPhoto();
      } else {
         this.urlphoto = null;
      }

   }

   public void ajoutPhoto() throws IOException, JDOMException, HibernateException, NamingException {
      FacesContext var1 = FacesContext.getCurrentInstance();

      try {
         if (this.uploadedFile != null) {
            String var2;
            File var3;
            String var4;
            String var5;
            File var6;
            if (this.showModalPanelFicheAyantDroit) {
               var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Patients") + File.separator + "P" + this.patientsAyantDroit.getPatId();
               var3 = new File(var2);
               if (var3.exists()) {
                  var3.delete();
               }

               var4 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
               var5 = var4.substring(var4.indexOf(".") + 1);
               var4 = "P" + this.patientsAyantDroit.getPatId() + "." + var5;
               var6 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Patients" + File.separator), var4);
               this.utilDownload.write(var6, this.uploadedFile.getInputStream());
               this.fileName = var4;
               var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
               this.patientsAyantDroit.setPatPhoto(var4);
               this.patientsAyantDroit = this.patientsDao.modif(this.patientsAyantDroit);
               this.urlphoto = "structure" + this.structureLog.getStrid() + "/photos/Patients/" + this.patientsAyantDroit.getPatPhoto();
            } else {
               var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Patients") + File.separator + "P" + this.patients.getPatId();
               var3 = new File(var2);
               if (var3.exists()) {
                  var3.delete();
               }

               var4 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
               var5 = var4.substring(var4.indexOf(".") + 1);
               var4 = "P" + this.patients.getPatId() + "." + var5;
               var6 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Patients" + File.separator), var4);
               this.utilDownload.write(var6, this.uploadedFile.getInputStream());
               this.fileName = var4;
               var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
               this.patients.setPatPhoto(var4);
               this.patients = this.patientsDao.modif(this.patients);
               this.urlphoto = "structure" + this.structureLog.getStrid() + "/photos/Patients/" + this.patients.getPatPhoto();
            }
         }
      } catch (IOException var7) {
         this.patients.setPatPhoto(this.fileName);
         var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
         var7.printStackTrace();
      }

   }

   public void reInitPhoto() throws HibernateException, NamingException {
      String var1 = "";
      int var2;
      String var3;
      File var4;
      if (this.showModalPanelFicheAyantDroit) {
         var2 = this.patientsAyantDroit.getPatPhoto().lastIndexOf(46);
         if (0 < var2 && var2 <= this.patientsAyantDroit.getPatPhoto().length() - 2) {
            var1 = "." + this.patientsAyantDroit.getPatPhoto().substring(var2 + 1);
         }

         var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Patients") + File.separator + "P" + this.patientsAyantDroit.getPatId() + var1;
         var4 = new File(var3);
         if (var4.exists()) {
            var4.delete();
         }

         this.patientsAyantDroit.setPatPhoto((String)null);
         this.patientsAyantDroit = this.patientsDao.modif(this.patientsAyantDroit);
      } else {
         var2 = this.patients.getPatPhoto().lastIndexOf(46);
         if (0 < var2 && var2 <= this.patients.getPatPhoto().length() - 2) {
            var1 = "." + this.patients.getPatPhoto().substring(var2 + 1);
         }

         var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "Patients") + File.separator + "P" + this.patients.getPatId() + var1;
         var4 = new File(var3);
         if (var4.exists()) {
            var4.delete();
         }

         this.patients.setPatPhoto((String)null);
         this.patients = this.patientsDao.modif(this.patients);
      }

   }

   public void envoiSmsZ1() {
      if (this.patients.getPatCel1() != null && !this.patients.getPatCel1().isEmpty()) {
         if (this.showModalPanelFicheAyantDroit) {
            this.numeroMobile = this.patientsAyantDroit.getPatCel1();
         } else {
            this.numeroMobile = this.patients.getPatCel1();
         }

         this.messageSms = "";
         this.showModalPanelSms = true;
      }

   }

   public void envoiSmsZ2() {
      if (this.patients.getPatCel2() != null && !this.patients.getPatCel2().isEmpty()) {
         if (this.showModalPanelFicheAyantDroit) {
            this.numeroMobile = this.patientsAyantDroit.getPatCel2();
         } else {
            this.numeroMobile = this.patients.getPatCel2();
         }

         this.messageSms = "";
         this.showModalPanelSms = true;
      }

   }

   public void envoiSmsZ3() {
      if (this.patients.getPatCel3() != null && !this.patients.getPatCel3().isEmpty()) {
         if (this.showModalPanelFicheAyantDroit) {
            this.numeroMobile = this.patientsAyantDroit.getPatCel3();
         } else {
            this.numeroMobile = this.patients.getPatCel3();
         }

         this.messageSms = "";
         this.showModalPanelSms = true;
      }

   }

   public void envoiSmsZ4() {
      if (this.patientContact.getPatconCel() != null && !this.patientContact.getPatconCel().isEmpty()) {
         this.numeroMobile = this.patientContact.getPatconCel();
         this.messageSms = "";
         this.showModalPanelSms = true;
      }

   }

   public void fermerSms() {
      this.showModalPanelSms = false;
   }

   public void valideEnvoiSms() throws IOException, HibernateException, NamingException, SQLException {
      UtilSms var1 = new UtilSms(this.utilInitHibernate, this.structureLog, this.usersLog, this.baseLog);
      if (this.patientContact != null) {
         var1.sendSmsOne(this.messageSms, this.numeroMobile, this.patientContact.getPatronyme(), this.patientContact.getPatconCivilite(), this.patientContact.getPatconId(), this.patients.getPatronyme(), this.patients.getPatId(), 4);
      } else if (this.showModalPanelFicheAyantDroit) {
         var1.sendSmsOne(this.messageSms, this.numeroMobile, (String)null, (String)null, 0L, this.patientsAyantDroit.getPatronyme(), this.patientsAyantDroit.getPatId(), 4);
      } else {
         var1.sendSmsOne(this.messageSms, this.numeroMobile, (String)null, (String)null, 0L, this.patients.getPatronyme(), this.patients.getPatId(), 4);
      }

      this.showModalPanelSms = false;
   }

   public void accesDocuments() throws HibernateException, NamingException, ParseException {
      if (this.patients != null) {
         this.exercicesVentes = new ExercicesVentes();
         ExercicesVentesDao var1 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
         this.exercicesVentes = var1.recupererLastExo((Session)null);
         if (this.exercicesVentes != null) {
            this.lesDocumentsEntete = new ArrayList();
            this.dataModelDocumentsEntete = new ListDataModel();
            this.dataModelAntecedent = new ListDataModel();
            this.infirmerie = this.rechercheModule(81500);
            new ArrayList();
            if (this.patientAntDao == null) {
               this.patientAntDao = new PatientAntDao(this.baseLog, this.utilInitHibernate);
            }

            List var2 = this.patientAntDao.chargerLesPatientsAntecedents(this.patients, (Session)null);
            this.dataModelAntecedent.setWrappedData(var2);
            if (var2.size() == 0 || this.usersLog.getUsrVendeur() == 1 && !this.infirmerie) {
               this.accesAntecedent = false;
            } else {
               this.accesAntecedent = true;
            }

            this.choixDocument = 50;
            this.dateDebut = this.exercicesVentes.getExevteDateDebut();
            this.dateFin = new Date();
            this.rechercherLesDocuments();
            this.var_action = 7;
            this.var_memo_action = this.var_action;
         }
      }

   }

   public void retourDocuments() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void razDocumentLignes() {
      this.dataModelConsActesLignes = new ListDataModel();
      this.dataModelConsLaboLignes = new ListDataModel();
      this.dataModelConsOrdoLigne = new ListDataModel();
      this.dataModelConsMediLignes = new ListDataModel();
      this.dataModelConsRegLignes = new ListDataModel();
      this.dataModelConsScan = new ListDataModel();
      this.dataModelPharmaciesLignes = new ListDataModel();
      this.dataModelPhaRegLignes = new ListDataModel();
      this.dataModelLabExamensLignes = new ListDataModel();
      this.dataModelLabRegLignes = new ListDataModel();
      this.dataModelLabScan = new ListDataModel();
      this.dataModelHosSejoursLignes = new ListDataModel();
      this.dataModelHosExmanesLignes = new ListDataModel();
      this.dataModelHosLaboLignes = new ListDataModel();
      this.dataModelHosMediLignes = new ListDataModel();
      this.dataModelHosPrestLignes = new ListDataModel();
      this.dataModelHosRegLignes = new ListDataModel();
      this.dataModelHosScan = new ListDataModel();
      this.accesConsultation = false;
      this.accesInfirmerie = false;
      this.accesConsActesLignes = false;
      this.accesConsLaboLignes = false;
      this.accesConsOrdoLigne = false;
      this.accesConsMediLignes = false;
      this.accesConsRegLignes = false;
      this.accesConsScan = false;
      this.accesPharmaciesLignes = false;
      this.accesPhaRegLignes = false;
      this.accesLabExamensLignes = false;
      this.accesLabRegLignes = false;
      this.accesLabScan = false;
      this.accesHosSejoursLignes = false;
      this.accesHosExmanesLignes = false;
      this.accesHosLaboLignes = false;
      this.accesHosMediLignes = false;
      this.accesHosPrestLignes = false;
      this.accesHosRegLignes = false;
      this.accesHosScan = false;
      this.numeroDocument = "";
      this.dateDocument = null;
   }

   public void rechercherLesDocuments() throws HibernateException, NamingException, ParseException {
      this.lesReglements = new ArrayList();
      this.lesDocumentsEntete = new ArrayList();
      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
      this.razDocumentLignes();
      this.var_total = 0.0D;
      this.var_reglement = 0.0D;
      this.var_solde = 0.0D;
      UtilDate var1 = new UtilDate();
      String var2 = var1.dateToStringSQLLight(this.dateDebut) + " 00:00:00";
      String var3 = var1.dateToStringSQLLight(this.dateFin) + " 23:59:59";
      if (this.choixDocument == 71) {
         this.consultations(var2, var3, (Session)null);
      } else if (this.choixDocument == 73) {
         this.pharmacie(var2, var3, (Session)null);
      } else if (this.choixDocument == 74) {
         this.laboratoire(var2, var3, (Session)null);
      } else if (this.choixDocument == 76) {
         this.hospitalisation(var2, var3, (Session)null);
      } else if (this.choixDocument == 77) {
         this.devis(var2, var3, (Session)null);
      } else if (this.choixDocument == 50) {
         this.consultations(var2, var3, (Session)null);
         this.pharmacie(var2, var3, (Session)null);
         this.laboratoire(var2, var3, (Session)null);
         this.hospitalisation(var2, var3, (Session)null);
      } else if (this.choixDocument == 60) {
         String var4 = var1.dateToStringSQLLight(this.dateDebut);
         String var5 = var1.dateToStringSQLLight(this.dateFin);
         this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
         this.lesReglements = this.reglementsDao.rechercheHistoTiers(this.patients.getPatId(), var4, var5, "", (Session)null);
         new Reglements();
         if (this.lesReglements.size() != 0) {
            for(int var7 = 0; var7 < this.lesReglements.size(); ++var7) {
               Reglements var6 = (Reglements)this.lesReglements.get(var7);
               DocumentEntete var8 = new DocumentEntete();
               var8.setVar_lib_nat("Règlement");
               var8.setDocDate(var6.getRglDateReg());
               var8.setDocNum(var6.getRglDocument());
               var8.setDocNumBon(var6.getRglNum());
               var8.setDocNomTiers(var6.getRglNomTiers());
               var8.setDocObject(var6.getRglObjet());
               var8.setDocNomContact(var6.getVar_lib_nat());
               var8.setDocNomCaissier(var6.getRglDocument());
               String var9 = "";
               if (var6.getRglTypeReg() == 1) {
                  var9 = "Chq N° " + var6.getRglNumChqBdx() + " " + var6.getRglBanqueTireur();
               } else {
                  var9 = var6.getRglLibTypReg();
               }

               var8.setDocNomResponsable(var6.getLibelleOperation() + " " + var9);
               var8.setDocTotHt(0.0D);
               var8.setDocTotTva(0.0D);
               var8.setDocTotTtc(0.0D);
               var8.setDocTotReglement(var6.getRglRecette());
               var8.setDocAPayer(0.0D);
               this.var_total += var8.getDocTotTtc();
               this.var_reglement += var8.getDocTotReglement();
               this.lesDocumentsEntete.add(var8);
            }
         }

         this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
      }

      this.var_solde = this.var_total - this.var_reglement;
   }

   public void consultations(String var1, String var2, Session var3) throws HibernateException, NamingException, ParseException {
      new ArrayList();
      if (this.consultationEnteteGeneDao == null) {
         this.consultationEnteteGeneDao = new ConsultationEnteteGeneDao(this.baseLog, this.utilInitHibernate);
      }

      List var4 = this.consultationEnteteGeneDao.chargerLesMvtsPatients(this.patients, var1, var2, var3);
      if (var4.size() != 0) {
         new ConsultationEnteteGene();

         for(int var6 = 0; var6 < var4.size(); ++var6) {
            ConsultationEnteteGene var5 = (ConsultationEnteteGene)var4.get(var6);
            DocumentEntete var7 = new DocumentEntete();
            var7.setDocMode(71);
            var7.setVar_lib_nat("Consultation");
            var7.setDocId(var5.getCsgId());
            var7.setDocDate(var5.getCsgDate());
            var7.setDocNum(var5.getCsgNum());
            var7.setDocNomTiers(var5.getCsgNomPatient());
            var7.setDocObject(var5.getCsgEntree());
            var7.setDocNomContact(var5.getCsgMedecin());
            var7.setDocNomCaissier(var5.getCsgService());
            var7.setDocNumBon(var5.getCsgNumBc());
            var7.setDocTotHt(var5.getCsgTotAssurance() + var5.getCsgTotComplmentaire() + var5.getCsgTotSociete());
            var7.setDocTotTva(0.0D);
            var7.setDocTotTtc(var5.getCsgTotPatient());
            var7.setDocTotReglement(var5.getCsgRegPatient());
            var7.setDocAPayer(var5.getCsgTotPatient() - var5.getCsgRegPatient());
            this.var_total += var7.getDocTotTtc();
            this.var_reglement += var7.getDocTotReglement();
            this.lesDocumentsEntete.add(var7);
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
   }

   public void pharmacie(String var1, String var2, Session var3) throws HibernateException, NamingException, ParseException {
      new ArrayList();
      if (this.pharmacieEnteteDao == null) {
         this.pharmacieEnteteDao = new PharmacieEnteteDao(this.baseLog, this.utilInitHibernate);
      }

      List var4 = this.pharmacieEnteteDao.chargerLesMvtsPatients(this.patients, var1, var2, var3);
      if (var4.size() != 0) {
         new PharmacieEntete();

         for(int var6 = 0; var6 < var4.size(); ++var6) {
            PharmacieEntete var5 = (PharmacieEntete)var4.get(var6);
            DocumentEntete var7 = new DocumentEntete();
            var7.setDocMode(73);
            var7.setVar_lib_nat("Pharmacie");
            var7.setDocId(var5.getPhaId());
            var7.setDocDate(var5.getPhaDate());
            var7.setDocNum(var5.getPhaNum());
            var7.setDocNomTiers(var5.getPhaNomPatient());
            var7.setDocObject("");
            var7.setDocNomContact(var5.getPhaMedecin());
            var7.setDocNomCaissier(var5.getPhaService());
            var7.setDocNumBon(var5.getPhaNumBc());
            var7.setDocTotHt(var5.getPhaTotAssurance() + var5.getPhaTotComplmentaire() + var5.getPhaTotSociete());
            var7.setDocTotTva(0.0D);
            var7.setDocTotTtc(var5.getPhaTotPatient());
            var7.setDocTotReglement(var5.getPhaRegPatient());
            var7.setDocAPayer(var5.getPhaTotPatient() - var5.getPhaRegPatient());
            this.var_total += var7.getDocTotTtc();
            this.var_reglement += var7.getDocTotReglement();
            this.lesDocumentsEntete.add(var7);
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
   }

   public void laboratoire(String var1, String var2, Session var3) throws HibernateException, NamingException, ParseException {
      new ArrayList();
      if (this.laboratoireEnteteDao == null) {
         this.laboratoireEnteteDao = new LaboratoireEnteteDao(this.baseLog, this.utilInitHibernate);
      }

      List var4 = this.laboratoireEnteteDao.chargerLesMvtsPatients(this.patients, var1, var2, var3);
      if (var4.size() != 0) {
         new LaboratoireEntete();

         for(int var6 = 0; var6 < var4.size(); ++var6) {
            LaboratoireEntete var5 = (LaboratoireEntete)var4.get(var6);
            DocumentEntete var7 = new DocumentEntete();
            var7.setDocMode(74);
            var7.setVar_lib_nat("Laboratoire");
            var7.setDocId(var5.getLabId());
            var7.setDocDate(var5.getLabDate());
            var7.setDocNum(var5.getLabNum());
            var7.setDocNomTiers(var5.getLabNomPatient());
            var7.setDocObject("");
            var7.setDocNomContact(var5.getLabMedecin());
            var7.setDocNomCaissier(var5.getLabService());
            var7.setDocNumBon(var5.getLabNumBc());
            var7.setDocTotHt(var5.getLabTotAssurance() + var5.getLabTotComplmentaire() + var5.getLabTotSociete());
            var7.setDocTotTva(0.0D);
            var7.setDocTotTtc(var5.getLabTotPatient());
            var7.setDocTotReglement(var5.getLabRegPatient());
            var7.setDocAPayer(var5.getLabTotPatient() - var5.getLabRegPatient());
            this.var_total += var7.getDocTotTtc();
            this.var_reglement += var7.getDocTotReglement();
            this.lesDocumentsEntete.add(var7);
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
   }

   public void hospitalisation(String var1, String var2, Session var3) throws HibernateException, NamingException, ParseException {
      new ArrayList();
      if (this.hospitalisationEnteteDao == null) {
         this.hospitalisationEnteteDao = new HospitalisationEnteteDao(this.baseLog, this.utilInitHibernate);
      }

      List var4 = this.hospitalisationEnteteDao.chargerLesMvtsPatients(this.patients, var1, var2, var3);
      if (var4.size() != 0) {
         new HospitalisationEntete();

         for(int var6 = 0; var6 < var4.size(); ++var6) {
            HospitalisationEntete var5 = (HospitalisationEntete)var4.get(var6);
            DocumentEntete var7 = new DocumentEntete();
            var7.setDocMode(76);
            var7.setVar_lib_nat("Hospitalisation");
            var7.setDocId(var5.getHosId());
            var7.setDocDate(var5.getHosDateEntree());
            var7.setDocNum(var5.getHosNum());
            var7.setDocNomTiers(var5.getHosNomPatient());
            var7.setDocObject(var5.getHosMotifEntree());
            var7.setDocNomContact(var5.getHosMedecin());
            var7.setDocNomCaissier(var5.getHosService());
            var7.setDocNumBon(var5.getHosNumBc());
            var7.setDocTotHt(var5.getHosTotAssurance() + var5.getHosTotComplmentaire() + var5.getHosTotSociete());
            var7.setDocTotTva(0.0D);
            var7.setDocTotTtc(var5.getHosTotPatient());
            var7.setDocTotReglement(var5.getHosRegPatient());
            var7.setDocAPayer(var5.getHosTotPatient() - var5.getHosRegPatient());
            this.var_total += var7.getDocTotTtc();
            this.var_reglement += var7.getDocTotReglement();
            this.lesDocumentsEntete.add(var7);
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
   }

   public void devis(String var1, String var2, Session var3) throws HibernateException, NamingException, ParseException {
      new ArrayList();
      if (this.devisEnteteMedicalDao == null) {
         this.devisEnteteMedicalDao = new DevisEnteteMedicalDao(this.baseLog, this.utilInitHibernate);
      }

      List var4 = this.devisEnteteMedicalDao.chargerLesMvtsPatients(this.patients, var1, var2, var3);
      if (var4.size() != 0) {
         new DevisEnteteMedical();

         for(int var6 = 0; var6 < var4.size(); ++var6) {
            DevisEnteteMedical var5 = (DevisEnteteMedical)var4.get(var6);
            DocumentEntete var7 = new DocumentEntete();
            var7.setDocMode(77);
            var7.setVar_lib_nat("Devis");
            var7.setDocId(var5.getDvsId());
            var7.setDocDate(var5.getDvsDate());
            var7.setDocNum(var5.getDvsNum());
            var7.setDocNomTiers(var5.getDvsNomPatient());
            var7.setDocObject("");
            var7.setDocNomContact(var5.getDvsMedecin());
            var7.setDocNomCaissier(var5.getDvsService());
            var7.setDocNumBon(var5.getDvsNumBc());
            var7.setDocTotHt(var5.getDvsTotAssurance() + var5.getDvsTotComplmentaire() + var5.getDvsTotSociete());
            var7.setDocTotTva(0.0D);
            var7.setDocTotTtc(var5.getDvsTotPatient());
            var7.setDocTotReglement(var5.getDvsRegPatient());
            var7.setDocAPayer(var5.getDvsTotPatient() - var5.getDvsRegPatient());
            this.var_total += var7.getDocTotTtc();
            this.var_reglement += var7.getDocTotReglement();
            this.lesDocumentsEntete.add(var7);
         }
      }

      this.dataModelDocumentsEntete.setWrappedData(this.lesDocumentsEntete);
   }

   public void selectionDocument() throws HibernateException, NamingException {
      if (this.dataModelDocumentsEntete.isRowAvailable()) {
         this.documentEntete = (DocumentEntete)this.dataModelDocumentsEntete.getRowData();
         this.razDocumentLignes();
         if (this.documentEntete.getDocMode() == 71) {
            this.consultationsLignes();
         } else if (this.documentEntete.getDocMode() == 73) {
            this.pharmaciesLignes();
         } else if (this.documentEntete.getDocMode() == 74) {
            this.laboratoiresLignes();
         } else if (this.documentEntete.getDocMode() == 76) {
            this.hospitalisationsLignes();
         } else if (this.documentEntete.getDocMode() == 77) {
            this.devisLignes();
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

   public void consultationsLignes() throws HibernateException, NamingException {
      this.var_heures = 0;
      this.var_minutes = 0;
      this.var_lib_poids = "";
      this.var_date_accident = null;
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ConsultationEntete");
      this.consultationEnteteGene = new ConsultationEnteteGene();
      this.consultationEnteteGene = this.consultationEnteteGeneDao.selectById(this.documentEntete.getDocId(), var1);
      if (this.consultationEnteteGene != null) {
         this.numeroDocument = this.consultationEnteteGene.getCsgNum();
         this.dateDocument = this.consultationEnteteGene.getCsgDate();
         if (this.consultationEnteteGene.getCsgCivilite() != null && !this.consultationEnteteGene.getCsgCivilite().isEmpty() && this.consultationEnteteGene.getCsgCivilite().equalsIgnoreCase("Bébé")) {
            this.var_lib_poids = "gr";
         } else {
            this.var_lib_poids = "kg";
         }

         if (this.usersLog.getUsrVendeur() == 1 && !this.infirmerie) {
            this.accesConsultation = false;
         } else {
            this.accesConsultation = true;
         }

         new ArrayList();
         if (this.consultationActesDao == null) {
            this.consultationActesDao = new ConsultationActesDao(this.baseLog, this.utilInitHibernate);
         }

         List var2 = this.consultationActesDao.selectConsActesByConsEnt(this.consultationEnteteGene, var1);
         this.dataModelConsActesLignes.setWrappedData(var2);
         if (var2.size() != 0) {
            this.accesConsActesLignes = true;
         } else {
            this.accesConsActesLignes = false;
         }

         new ArrayList();
         if (this.consultationLaboDao == null) {
            this.consultationLaboDao = new ConsultationLaboDao(this.baseLog, this.utilInitHibernate);
         }

         List var3 = this.consultationLaboDao.selectConsLaboByConsEnt(this.consultationEnteteGene, var1);
         this.dataModelConsLaboLignes.setWrappedData(var3);
         if (var3.size() != 0) {
            this.accesConsLaboLignes = true;
         } else {
            this.accesConsLaboLignes = false;
         }

         new ArrayList();
         if (this.consultationOrdoDao == null) {
            this.consultationOrdoDao = new ConsultationOrdoDao(this.baseLog, this.utilInitHibernate);
         }

         List var4 = this.consultationOrdoDao.selectConsOrdoByConsEnt(this.consultationEnteteGene, var1);
         this.dataModelConsOrdoLigne.setWrappedData(var4);
         if (var4.size() != 0) {
            this.accesConsOrdoLigne = true;
         } else {
            this.accesConsOrdoLigne = false;
         }

         ArrayList var5 = new ArrayList();
         this.nomRepertoire = "";
         if (this.infirmerie) {
            this.nomRepertoire = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "infirmerie" + File.separator;
         } else {
            this.nomRepertoire = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "consultation" + File.separator;
         }

         if (this.nomRepertoire != null && !this.nomRepertoire.isEmpty()) {
            File var6 = new File(this.nomRepertoire);
            String var7 = this.consultationEnteteGene.getCsgNum().replace("/", "_");
            String[] var8 = var6.list();
            if (var8 != null) {
               var8 = this.triAlphabetique(var8, var8.length);

               for(int var9 = 0; var9 < var8.length; ++var9) {
                  if (var8[var9].endsWith(".pdf") && var8[var9].startsWith(var7)) {
                     var5.add(var8[var9]);
                  }
               }
            }
         }

         this.dataModelConsScan.setWrappedData(var5);
         if (var5.size() != 0) {
            this.accesConsScan = true;
         } else {
            this.accesConsScan = false;
         }

         List var10;
         if (this.infirmerie) {
            new ArrayList();
            if (this.pharmacieLigneDao == null) {
               this.pharmacieLigneDao = new PharmacieLigneDao(this.baseLog, this.utilInitHibernate);
            }

            var10 = this.pharmacieLigneDao.selectConsActesByConsEnt(this.consultationEnteteGene, var1);
            this.dataModelConsMediLignes.setWrappedData(var10);
            if (var10.size() != 0) {
               this.accesConsMediLignes = true;
            } else {
               this.accesConsMediLignes = false;
            }

            if (this.consultationInfirmerieDao == null) {
               this.consultationInfirmerieDao = new ConsultationInfirmerieDao(this.baseLog, this.utilInitHibernate);
            }

            this.consultationInfirmerie = this.consultationInfirmerieDao.selectConsInfirmerieByConsEnt(this.consultationEnteteGene, var1);
            if (this.consultationInfirmerie == null || this.usersLog.getUsrVendeur() == 1 && !this.infirmerie) {
               this.accesInfirmerie = false;
            } else {
               this.accesInfirmerie = true;
               if (this.consultationInfirmerie.getCslaccDateAccident() != null) {
                  this.var_date_accident = this.consultationInfirmerie.getCslaccDateAccident();
                  this.var_heures = this.consultationInfirmerie.getCslaccDateAccident().getHours();
                  this.var_minutes = this.consultationInfirmerie.getCslaccDateAccident().getMinutes();
               } else {
                  this.var_date_accident = null;
                  this.var_heures = 0;
                  this.var_minutes = 0;
               }
            }
         } else {
            new ArrayList();
            if (this.consultationReglementDao == null) {
               this.consultationReglementDao = new ConsultationReglementDao(this.baseLog, this.utilInitHibernate);
            }

            var10 = this.consultationReglementDao.selectReglementByEnt(this.consultationEnteteGene, var1);
            this.dataModelConsRegLignes.setWrappedData(var10);
            if (var10.size() != 0 && this.usersLog.getUsrVendeur() != 2) {
               this.accesConsRegLignes = true;
            } else {
               this.accesConsRegLignes = false;
            }
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void pharmaciesLignes() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
      this.pharmacieEntete = new PharmacieEntete();
      this.pharmacieEntete = this.pharmacieEnteteDao.selectById(this.documentEntete.getDocId(), var1);
      if (this.pharmacieEntete != null) {
         this.numeroDocument = this.pharmacieEntete.getPhaNum();
         this.dateDocument = this.pharmacieEntete.getPhaDate();
         new ArrayList();
         if (this.pharmacieLigneDao == null) {
            this.pharmacieLigneDao = new PharmacieLigneDao(this.baseLog, this.utilInitHibernate);
         }

         List var2 = this.pharmacieLigneDao.selectConsActesByConsEnt(this.pharmacieEntete, var1);
         this.dataModelPharmaciesLignes.setWrappedData(var2);
         if (var2.size() != 0) {
            this.accesPharmaciesLignes = true;
         } else {
            this.accesPharmaciesLignes = false;
         }

         new ArrayList();
         if (this.pharmacieReglementDao == null) {
            this.pharmacieReglementDao = new PharmacieReglementDao(this.baseLog, this.utilInitHibernate);
         }

         List var3 = this.pharmacieReglementDao.selectReglementByEnt(this.pharmacieEntete, var1);
         this.dataModelPhaRegLignes.setWrappedData(var3);
         if (var3.size() != 0 && this.usersLog.getUsrVendeur() != 2) {
            this.accesPhaRegLignes = true;
         } else {
            this.accesPhaRegLignes = false;
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void laboratoiresLignes() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
      this.laboratoireEntete = new LaboratoireEntete();
      this.laboratoireEntete = this.laboratoireEnteteDao.selectById(this.documentEntete.getDocId(), var1);
      if (this.laboratoireEntete != null) {
         this.numeroDocument = this.laboratoireEntete.getLabNum();
         this.dateDocument = this.laboratoireEntete.getLabDate();
         new ArrayList();
         if (this.laboratoireLigneDao == null) {
            this.laboratoireLigneDao = new LaboratoireLigneDao(this.baseLog, this.utilInitHibernate);
         }

         List var2 = this.laboratoireLigneDao.selectConsActesByConsEnt(this.laboratoireEntete, var1);
         this.dataModelLabExamensLignes.setWrappedData(var2);
         if (var2.size() != 0) {
            this.accesLabExamensLignes = true;
         } else {
            this.accesLabExamensLignes = false;
         }

         ArrayList var3 = new ArrayList();
         this.nomRepertoire = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "laboratoire" + File.separator;
         if (this.nomRepertoire != null && !this.nomRepertoire.isEmpty()) {
            File var4 = new File(this.nomRepertoire);
            String var5 = this.laboratoireEntete.getLabNum().replace("/", "_");
            String[] var6 = var4.list();
            if (var6 != null) {
               var6 = this.triAlphabetique(var6, var6.length);

               for(int var7 = 0; var7 < var6.length; ++var7) {
                  if (var6[var7].endsWith(".pdf") && var6[var7].startsWith(var5)) {
                     var3.add(var6[var7]);
                  }
               }
            }
         }

         this.dataModelLabScan.setWrappedData(var3);
         if (var3.size() != 0) {
            this.accesLabScan = true;
         } else {
            this.accesLabScan = false;
         }

         new ArrayList();
         if (this.laboratoireReglementDao == null) {
            this.laboratoireReglementDao = new LaboratoireReglementDao(this.baseLog, this.utilInitHibernate);
         }

         List var8 = this.laboratoireReglementDao.selectReglementByEnt(this.laboratoireEntete, var1);
         this.dataModelLabRegLignes.setWrappedData(var8);
         if (var8.size() != 0 && this.usersLog.getUsrVendeur() != 2) {
            this.accesLabRegLignes = true;
         } else {
            this.accesLabRegLignes = false;
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void hospitalisationsLignes() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "HospitalisationEntete");
      this.hospitalisationEntete = new HospitalisationEntete();
      this.hospitalisationEntete = this.hospitalisationEnteteDao.selectById(this.documentEntete.getDocId(), var1);
      if (this.hospitalisationEntete != null) {
         this.numeroDocument = this.hospitalisationEntete.getHosNum();
         this.dateDocument = this.hospitalisationEntete.getHosDateEntree();
         new ArrayList();
         if (this.hospitalisationSejourDao == null) {
            this.hospitalisationSejourDao = new HospitalisationSejourDao(this.baseLog, this.utilInitHibernate);
         }

         List var2 = this.hospitalisationSejourDao.selectSejourByEnt(this.hospitalisationEntete, var1);
         this.dataModelHosSejoursLignes.setWrappedData(var2);
         if (var2.size() != 0) {
            this.accesHosSejoursLignes = true;
         } else {
            this.accesHosSejoursLignes = false;
         }

         new ArrayList();
         if (this.hospitalisationActesDao == null) {
            this.hospitalisationActesDao = new HospitalisationActesDao(this.baseLog, this.utilInitHibernate);
         }

         List var3 = this.hospitalisationActesDao.selectActesByEnt(this.hospitalisationEntete, var1);
         this.dataModelHosExmanesLignes.setWrappedData(var3);
         if (var3.size() != 0) {
            this.accesHosExmanesLignes = true;
         } else {
            this.accesHosExmanesLignes = false;
         }

         new ArrayList();
         if (this.hospitalisationLaboDao == null) {
            this.hospitalisationLaboDao = new HospitalisationLaboDao(this.baseLog, this.utilInitHibernate);
         }

         List var4 = this.hospitalisationLaboDao.selectLaboByEnt(this.hospitalisationEntete, var1);
         this.dataModelHosLaboLignes.setWrappedData(var4);
         if (var4.size() != 0) {
            this.accesHosLaboLignes = true;
         } else {
            this.accesHosLaboLignes = false;
         }

         new ArrayList();
         if (this.hospitalisationMediDao == null) {
            this.hospitalisationMediDao = new HospitalisationMediDao(this.baseLog, this.utilInitHibernate);
         }

         List var5 = this.hospitalisationMediDao.selectMediByEnt(this.hospitalisationEntete, var1);
         this.dataModelHosMediLignes.setWrappedData(var5);
         if (var5.size() != 0) {
            this.accesHosMediLignes = true;
         } else {
            this.accesHosMediLignes = false;
         }

         new ArrayList();
         if (this.hospitalisationPrestDao == null) {
            this.hospitalisationPrestDao = new HospitalisationPrestDao(this.baseLog, this.utilInitHibernate);
         }

         List var6 = this.hospitalisationPrestDao.selectPrestByEnt(this.hospitalisationEntete, var1);
         this.dataModelHosPrestLignes.setWrappedData(var6);
         if (var6.size() != 0) {
            this.accesHosPrestLignes = true;
         } else {
            this.accesHosPrestLignes = false;
         }

         ArrayList var7 = new ArrayList();
         this.nomRepertoire = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "hospitalisation" + File.separator;
         if (this.nomRepertoire != null && !this.nomRepertoire.isEmpty()) {
            File var8 = new File(this.nomRepertoire);
            String var9 = this.hospitalisationEntete.getHosNum().replace("/", "_");
            String[] var10 = var8.list();
            if (var10 != null) {
               var10 = this.triAlphabetique(var10, var10.length);

               for(int var11 = 0; var11 < var10.length; ++var11) {
                  if (var10[var11].endsWith(".pdf") && var10[var11].startsWith(var9)) {
                     var7.add(var10[var11]);
                  }
               }
            }
         }

         this.dataModelHosScan.setWrappedData(var7);
         if (var7.size() != 0) {
            this.accesHosScan = true;
         } else {
            this.accesHosScan = false;
         }

         new ArrayList();
         if (this.hospitalisationReglementDao == null) {
            this.hospitalisationReglementDao = new HospitalisationReglementDao(this.baseLog, this.utilInitHibernate);
         }

         List var12 = this.hospitalisationReglementDao.selectReglementByEnt(this.hospitalisationEntete, var1);
         this.dataModelHosRegLignes.setWrappedData(var12);
         if (var12.size() != 0 && this.usersLog.getUsrVendeur() != 2) {
            this.accesHosRegLignes = true;
         } else {
            this.accesHosRegLignes = false;
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void devisLignes() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteMedical");
      this.devisEnteteMedical = new DevisEnteteMedical();
      this.devisEnteteMedical = this.devisEnteteMedicalDao.selectById(this.documentEntete.getDocId(), var1);
      if (this.devisEnteteMedical != null) {
         this.numeroDocument = this.devisEnteteMedical.getDvsNum();
         this.dateDocument = this.devisEnteteMedical.getDvsDate();
         new ArrayList();
         if (this.devisLigneMedicalDao == null) {
            this.devisLigneMedicalDao = new DevisLigneMedicalDao(this.baseLog, this.utilInitHibernate);
         }

         List var2 = this.devisLigneMedicalDao.selectConsActesByConsEnt(this.devisEnteteMedical, var1);
         this.dataModelLabExamensLignes.setWrappedData(var2);
         if (var2.size() != 0) {
            this.accesLabExamensLignes = true;
         } else {
            this.accesLabExamensLignes = false;
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void lectureDocConsultation() throws MalformedURLException, IOException {
      if (this.dataModelConsScan.isRowAvailable()) {
         String var1 = (String)this.dataModelConsScan.getRowData();
         if (var1.endsWith(".pdf") || var1.endsWith(".PDF")) {
            this.nomDocument = var1;
            String var2 = this.nomRepertoire + var1;
            if (var2 != null && !var2.isEmpty()) {
               this.consulterDocumentScanConsultation(var2);
            }
         }
      }

   }

   public void consulterDocumentScanConsultation(String var1) throws MalformedURLException, IOException {
      if (var1 != null && !var1.isEmpty()) {
         this.utilDownload = new UtilDownload();
         this.fichierUrl = this.utilDownload.convertirFichierUtl(var1, this.urlExplorateur);
         this.fichierMine = this.utilDownload.calculeTypeMine(var1);
         this.showModalPanelPjCons = true;
      }

   }

   public void lectureDocLaboratoire() throws MalformedURLException, IOException {
      if (this.dataModelLabScan.isRowAvailable()) {
         String var1 = (String)this.dataModelLabScan.getRowData();
         if (var1.endsWith(".pdf") || var1.endsWith(".PDF")) {
            this.nomDocument = var1;
            String var2 = this.nomRepertoire + var1;
            if (var2 != null && !var2.isEmpty()) {
               this.consulterDocumentScanLaboratoire(var2);
            }
         }
      }

   }

   public void consulterDocumentScanLaboratoire(String var1) throws MalformedURLException, IOException {
      if (var1 != null && !var1.isEmpty()) {
         this.utilDownload = new UtilDownload();
         this.fichierUrl = this.utilDownload.convertirFichierUtl(var1, this.urlExplorateur);
         this.fichierMine = this.utilDownload.calculeTypeMine(var1);
         this.showModalPanelPjLab = true;
      }

   }

   public void lectureDocHospitalisation() throws MalformedURLException, IOException {
      if (this.dataModelHosScan.isRowAvailable()) {
         String var1 = (String)this.dataModelHosScan.getRowData();
         if (var1.endsWith(".pdf") || var1.endsWith(".PDF")) {
            this.nomDocument = var1;
            String var2 = this.nomRepertoire + var1;
            if (var2 != null && !var2.isEmpty()) {
               this.consulterDocumentScanHospitalisation(var2);
            }
         }
      }

   }

   public void consulterDocumentScanHospitalisation(String var1) throws MalformedURLException, IOException {
      if (var1 != null && !var1.isEmpty()) {
         this.utilDownload = new UtilDownload();
         this.fichierUrl = this.utilDownload.convertirFichierUtl(var1, this.urlExplorateur);
         this.fichierMine = this.utilDownload.calculeTypeMine(var1);
         this.showModalPanelPjHos = true;
      }

   }

   public void fermerVisuDocumentScan() {
      this.showModalPanelPjCons = false;
      this.showModalPanelPjLab = false;
      this.showModalPanelPjHos = false;
   }

   public void lettreGarantie() throws HibernateException, NamingException {
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.lesReglements = new ArrayList();
      this.dataModelReglements = new ListDataModel();
      this.patientLettreGarantieDao = new PatientLettreGarantieDao(this.baseLog, this.utilInitHibernate);
      this.lesLettreGarantie = new ArrayList();
      this.dataModelLettreGarantie = new ListDataModel();
      this.lesLettreGarantie = this.patientLettreGarantieDao.chargerLesLettresByPatients(this.patients, 9, 0, (Session)null);
      this.dataModelLettreGarantie.setWrappedData(this.lesLettreGarantie);
      this.mesTiersPEC = new ArrayList();
      this.mesTiersPEC = this.patientPecDao.chargerLesPatientsPecActive(this.patients, (Session)null);
      this.idTiersPec = 0L;
      this.visibiliteBton = false;
      this.var_valide_lettre = false;
      this.var_action = 8;
      this.var_memo_action = this.var_action;
   }

   public void selectionnerLettreGarantie() throws IOException, SQLException {
      if (this.dataModelLettreGarantie.isRowAvailable()) {
         this.patientLettreGarantie = (PatientLettreGarantie)this.dataModelLettreGarantie.getRowData();
         this.tiers = this.patientLettreGarantie.getTiers();
         this.nomTiers = this.tiers.getTieraisonsocialenom();
         this.idTiersPec = this.tiers.getTieid();
         this.visibiliteBton = true;
         this.affichePhotoLettreGarantie();
      }

   }

   public void ajouterLettreGarantie() {
      if (this.patients != null) {
         this.patientLettreGarantie = new PatientLettreGarantie();
         this.tiers = new Tiers();
         this.nomTiers = "";
         this.idTiersPec = 0L;
         this.urlphoto = null;
         this.patientLettreGarantie.setPatlgaDate(new Date());
         this.var_actionLettre = false;
         this.var_valide_lettre = false;
         this.showModalPanelLettreGarantie = true;
      }

   }

   public void modifierLettreGarantie() {
      if (this.patientLettreGarantie != null) {
         this.var_actionLettre = false;
         this.var_valide_lettre = true;
         this.showModalPanelLettreGarantie = true;
      }

   }

   public void consulterLettreGarantie() {
      if (this.patientLettreGarantie != null) {
         this.var_actionLettre = true;
         this.var_valide_lettre = false;
         this.showModalPanelLettreGarantie = true;
      }

   }

   public void supprimerLettreGarantie() throws HibernateException, NamingException {
      if (this.patientLettreGarantie != null && this.patientLettreGarantie.getPatlgaEtat() == 0) {
         long var1 = this.patientLettreGarantie.getPatlgaId();
         String var3 = this.patientLettreGarantie.getPatlgaPhoto();
         this.patientLettreGarantieDao.delete(this.patientLettreGarantie);
         this.lesLettreGarantie.remove(this.patientLettreGarantie);
         this.dataModelLettreGarantie.setWrappedData(this.lesLettreGarantie);
         String var4 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanPriseEnCharge") + File.separator + var3;
         File var5 = new File(var4);
         if (var5.exists()) {
            var5.delete();
         }

         this.visibiliteBton = false;
      }

   }

   public void retourLettreGarantie() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
   }

   public void saveLettreGarantie() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Patients");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.idTiersPec != 0L) {
            TiersDao var3 = new TiersDao(this.baseLog, this.utilInitHibernate);
            this.tiers = var3.selectTierD(this.idTiersPec, var1);
            if (this.tiers != null) {
               if (this.patientLettreGarantie.getPatlgaId() == 0L) {
                  String var4 = this.calculChrono.numCompose(new Date(), 75, "", var1);
                  this.patientLettreGarantie.setPatient(this.patients);
                  this.patientLettreGarantie.setTiers(this.tiers);
                  this.patientLettreGarantie.setPatlgaDateCreat(new Date());
                  this.patientLettreGarantie.setPatlgaIdCreateur(this.usersLog.getUsrid());
                  this.patientLettreGarantie.setPatlgaNomCreateur(this.usersLog.getUsrPatronyme());
                  this.patientLettreGarantie.setPatlgaNum(var4);
                  this.patientLettreGarantie.setPatlgaSolde(this.patientLettreGarantie.getPatlgaMontant() - this.patientLettreGarantie.getPatlgaConsomme());
                  this.patientLettreGarantie = this.patientLettreGarantieDao.insert(this.patientLettreGarantie, var1);
                  this.lesLettreGarantie.add(this.patientLettreGarantie);
                  this.dataModelLettreGarantie.setWrappedData(this.lesLettreGarantie);
               } else {
                  this.patientLettreGarantie.setTiers(this.tiers);
                  this.patientLettreGarantie.setPatlgaDateModif(new Date());
                  this.patientLettreGarantie.setPatlgaIdModif(this.usersLog.getUsrid());
                  this.patientLettreGarantie.setPatlgaNomModif(this.usersLog.getUsrPatronyme());
                  this.patientLettreGarantie.setPatlgaSolde(this.patientLettreGarantie.getPatlgaMontant() - this.patientLettreGarantie.getPatlgaConsomme());
                  this.patientLettreGarantie = this.patientLettreGarantieDao.modif(this.patientLettreGarantie, var1);
                  this.showModalPanelLettreGarantie = false;
               }

               var2.commit();
            }
         }
      } catch (HibernateException var8) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelLettreGarantie = false;
   }

   public void validerLettreGarantie() throws HibernateException, NamingException {
      if (this.patientLettreGarantie != null && this.patientLettreGarantie.getPatlgaEtat() == 0) {
         this.patientLettreGarantie.setPatlgaEtat(1);
         this.patientLettreGarantie = this.patientLettreGarantieDao.modif(this.patientLettreGarantie);
      }

   }

   public void dvaliderLettreGarantie() throws HibernateException, NamingException {
      if (this.patientLettreGarantie != null && this.patientLettreGarantie.getPatlgaEtat() == 1) {
         this.patientLettreGarantie.setPatlgaEtat(0);
         this.patientLettreGarantie = this.patientLettreGarantieDao.modif(this.patientLettreGarantie);
      }

   }

   public void affichePhotoLettreGarantie() throws IOException, SQLException {
      if (this.patientLettreGarantie.getPatlgaPhoto() != null && !this.patientLettreGarantie.getPatlgaPhoto().isEmpty()) {
         this.urlphoto = "structure" + this.structureLog.getStrid() + "/photos/scanPriseEnCharge/" + this.patientLettreGarantie.getPatlgaPhoto();
      } else {
         this.urlphoto = null;
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

   public void ajouterPhotoLettreGarantie() throws HibernateException, NamingException {
      if (this.patientLettreGarantie.getPatlgaId() == 0L) {
         this.saveLettreGarantie();
      }

      if (this.patientLettreGarantie.getPatlgaId() != 0L) {
         FacesContext var1 = FacesContext.getCurrentInstance();

         try {
            if (this.uploadedFile != null) {
               File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanPriseEnCharge");
               if (!var2.exists()) {
                  var2.mkdir();
               }

               String var3;
               if (this.patientLettreGarantie.getPatlgaPhoto() != null && !this.patientLettreGarantie.getPatlgaPhoto().isEmpty()) {
                  var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanPriseEnCharge") + File.separator + this.patientLettreGarantie.getPatlgaPhoto();
                  File var4 = new File(var3);
                  if (var4.exists()) {
                     var4.delete();
                  }
               }

               var3 = this.utilDownload.trimFilePath(this.uploadedFile.getName().trim());
               String var8 = var3.substring(var3.indexOf(".") + 1);
               String var5 = "LDG_" + this.patients.getPatDossier() + "_";
               if (this.patientLettreGarantie.getPatlgaNum().contains("/")) {
                  var5 = this.patientLettreGarantie.getPatlgaNum().replaceAll("/", "");
               } else if (this.patientLettreGarantie.getPatlgaNum().contains("-")) {
                  var5 = this.patientLettreGarantie.getPatlgaNum().replaceAll("-", "");
               } else {
                  var5 = this.patientLettreGarantie.getPatlgaNum();
               }

               var3 = var5 + "." + var8;
               File var6 = this.utilDownload.uniqueFile(new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanPriseEnCharge" + File.separator), var3);
               this.utilDownload.write(var6, this.uploadedFile.getInputStream());
               this.fileName = var3;
               var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
               this.patientLettreGarantie.setPatlgaPhoto(var3);
               this.urlphoto = "structure" + this.structureLog.getStrid() + "/photos/scanPriseEnCharge/" + this.patientLettreGarantie.getPatlgaPhoto();
            }
         } catch (IOException var7) {
            this.patientLettreGarantie.setPatlgaPhoto(this.fileName);
            var1.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var7.printStackTrace();
         }
      }

   }

   public void supprimerPhotoLettreGarantie() throws IOException, SQLException, HibernateException, NamingException {
      String var1 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanPriseEnCharge") + File.separator + this.patientLettreGarantie.getPatlgaPhoto();
      File var2 = new File(var1);
      if (var2.exists()) {
         var2.delete();
      }

      this.affichePhotoLettreGarantie();
      this.patientLettreGarantie.setPatlgaPhoto((String)null);
      this.patientLettreGarantieDao.modif(this.patientLettreGarantie);
   }

   public void afficherScan() throws IOException, SQLException {
      if (this.dataModelReglements.isRowAvailable()) {
         this.patientLettreGarantie = (PatientLettreGarantie)this.dataModelReglements.getRowData();
         this.affichePhotoLettreGarantie();
      }

      if (this.patientLettreGarantie != null) {
         this.showModalPanelScan = true;
      }

   }

   public void fermerScan() {
      this.showModalPanelScan = false;
   }

   public void chargerReglementGarantie() throws IOException, SQLException, HibernateException, NamingException {
      if (this.patientLettreGarantie != null) {
         this.lesReglements.clear();
         this.lesReglements = this.reglementsDao.chargeRecuByLettreGarantie(this.patientLettreGarantie.getPatlgaNum(), (Session)null);
         if (this.lesReglements.size() != 0) {
            double var1 = 0.0D;

            for(int var3 = 0; var3 < this.lesReglements.size(); ++var3) {
               var1 += ((Reglements)this.lesReglements.get(var3)).getRglRecette();
            }

            this.patientLettreGarantie.setPatlgaConsomme(var1);
            this.patientLettreGarantie.setPatlgaSolde(this.patientLettreGarantie.getPatlgaMontant() - this.patientLettreGarantie.getPatlgaConsomme());
            this.patientLettreGarantie = this.patientLettreGarantieDao.modif(this.patientLettreGarantie);
         }

         this.dataModelReglements.setWrappedData(this.lesReglements);
         this.showModalPanelLesReglements = true;
      }

   }

   public void fermerReglementGarantie() {
      this.showModalPanelLettreGarantie = false;
      this.showModalPanelLesReglements = false;
   }

   public void ouvrirTrfAyantDroit() {
      if (this.patients != null) {
         this.nomAssure = "";
         this.numeroAssure = "";
         this.qualite = "0";
         this.patientsAssure = new Patients();
         this.showModalPanelTrfAyantDroit = true;
      }

   }

   public void fermerTrfAyantDroit() {
      this.showModalPanelTrfAyantDroit = false;
   }

   public void recherchePatient() throws HibernateException, NamingException {
      if (this.numeroAssure != null && !this.numeroAssure.isEmpty()) {
         this.patientsAssure = this.patientsDao.selectPatientsM(this.numeroAssure, (Session)null);
         if (this.patientsAssure != null) {
            this.numeroAssure = this.patientsAssure.getPatDossier();
            this.nomAssure = this.patientsAssure.getPatronyme();
         } else {
            String var1 = "from PatientPec where (patpecNumContrat = '" + this.numeroAssure + "' or patpecMatricule = '" + this.numeroAssure + "')";
            new ArrayList();
            List var2 = this.patientPecDao.chargerListPatients(var1, (Session)null);
            if (var2.size() != 0) {
               this.dataModelListAssure.setWrappedData(var2);
               this.showModalPanelListeAssure = true;
            } else {
               this.numeroAssure = "";
               this.nomAssure = "";
               this.patientsAssure = null;
            }
         }
      }

   }

   public void selectionPatientAssure() {
      if (this.dataModelListAssure.isRowAvailable()) {
         new PatientPec();
         PatientPec var1 = (PatientPec)this.dataModelListAssure.getRowData();
         this.patientsAssure = var1.getPatient();
      }

   }

   public void validePatientAssure() {
      if (this.patientsAssure != null) {
         this.numeroAssure = this.patientsAssure.getPatDossier();
         this.nomAssure = this.patientsAssure.getPatronyme();
      }

      this.showModalPanelListeAssure = false;
   }

   public void fermePatientAssure() {
      this.numeroAssure = "";
      this.nomAssure = "";
      this.patientsAssure = null;
      this.showModalPanelListeAssure = false;
   }

   public void validerTrfAyantDroit() throws HibernateException, NamingException {
      if (this.numeroAssure != null && !this.numeroAssure.isEmpty() && this.patientsAssure != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Patients");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.patientsAssure != null) {
               int var3 = 0;
               new ArrayList();
               List var4 = this.patientsDao.chargerlesPatients(this.patientsAssure.getPatId(), var1);
               if (var4.size() != 0) {
                  var3 = var4.size();
               }

               ++var3;
               this.lesPec = this.patientPecDao.chargerLesPatientsPec(this.patientsAssure, 9, var1);
               this.patients.setPatDossier(this.patientsAssure.getPatDossier() + "-" + var3);
               this.patients.setPatIdCouvertPar(this.patientsAssure.getPatId());
               this.patients.setPatCouvert(this.patientsAssure.getPatronyme());
               if (this.patients.getPatQualite() != null && !this.patients.getPatQualite().isEmpty() && this.patients.getPatQualite().equalsIgnoreCase("Enfant")) {
                  String var5 = "";
                  if (this.patientsAssure.getPatPrenom() != null && !this.patientsAssure.getPatPrenom().isEmpty()) {
                     var5 = this.patientsAssure.getPatNom() + " " + this.patientsAssure.getPatPrenom();
                  } else {
                     var5 = this.patientsAssure.getPatNom();
                  }

                  if (this.patientsAssure.getPatSexe() == 0) {
                     this.patients.setPatNomMere(var5);
                  } else {
                     this.patients.setPatNomPere(var5);
                  }
               }

               this.patients.setPatIdAssurance(this.patientsAssure.getPatIdAssurance());
               this.patients.setPatIdSociete(this.patientsAssure.getPatIdSociete());
               this.patients.setPatIdComplementaire(this.patientsAssure.getPatIdComplementaire());
               this.patients.setPatAssurance(this.patientsAssure.getPatAssurance());
               this.patients.setPatSociete(this.patientsAssure.getPatSociete());
               this.patients.setPatComplementaire(this.patientsAssure.getPatComplementaire());
               this.patients.setPatNumContrat(this.patientsAssure.getPatNumContrat());
               this.patients.setPatPec(this.patientsAssure.getPatPec());
               this.patients.setPatPecComplementaire(this.patientsAssure.getPatPecComplementaire());
               this.patients = this.patientsDao.modif(this.patients, var1);
               new ArrayList();
               List var13 = this.patientPecDao.chargerLesPatientsPec(this.patients, 9, var1);
               PatientPec var6;
               int var7;
               if (var13.size() != 0) {
                  new PatientPec();

                  for(var7 = 0; var7 < var13.size(); ++var7) {
                     var6 = (PatientPec)var13.get(var7);
                     this.patientPecDao.delete(var6, var1);
                  }
               }

               var13.clear();
               if (this.lesPec.size() != 0) {
                  new PatientPec();

                  for(var7 = 0; var7 < this.lesPec.size(); ++var7) {
                     this.patientPec = (PatientPec)this.lesPec.get(var7);
                     if (this.patientPec.getPatpecInactif() == 0) {
                        var6 = new PatientPec();
                        var6.setPatient(this.patients);
                        var6.setTiers(this.patientPec.getTiers());
                        var6.setPatpacHotelerie(this.patientPec.getPatpacHotelerie());
                        var6.setPatpecAgentRefact("");
                        var6.setPatpecDateDebut(this.patientPec.getPatpecDateDebut());
                        var6.setPatpecDateFin(this.patientPec.getPatpecDateFin());
                        var6.setPatpecDentaire(this.patientPec.getPatpecDentaire());
                        var6.setPatpecExamenss(this.patientPec.getPatpecExamenss());
                        var6.setPatpecExamenssHospit(this.patientPec.getPatpecExamenssHospit());
                        var6.setPatpecForfait(this.patientPec.getPatpecForfait());
                        var6.setPatpecHebergementPlaf(this.patientPec.getPatpecHebergementPlaf());
                        var6.setPatpecHebergementRep(this.patientPec.getPatpecHebergementRep());
                        var6.setPatpecIdCouvert(this.patientsAssure.getPatId());
                        var6.setPatpecIdEmployeur(this.patientPec.getPatpecIdEmployeur());
                        var6.setPatpecMatricule(this.patients.getPatImmatriculation());
                        var6.setPatpecMatriculeCouvert(this.patientsAssure.getPatImmatriculation());
                        var6.setPatpecMedicament(this.patientPec.getPatpecMedicament());
                        var6.setPatpecMedicamentHospit(this.patientPec.getPatpecMedicamentHospit());
                        if (this.patientsAssure.getPatPrenom() != null && !this.patientsAssure.getPatPrenom().isEmpty()) {
                           var6.setPatpecNomCouvert(this.patientsAssure.getPatNom() + " " + this.patientsAssure.getPatPrenom());
                        } else {
                           var6.setPatpecNomCouvert(this.patientsAssure.getPatNom());
                        }

                        var6.setPatpecNomEmployeur(this.patientPec.getPatpecNomEmployeur());
                        var6.setPatpecNumCnamgs(this.patients.getPatCnamgs());
                        var6.setPatpecNumCnss(this.patients.getPatSecu());
                        var6.setPatpecNumContrat(this.patientPec.getPatpecNumContrat());
                        var6.setPatpecOcculaire(this.patientPec.getPatpecOcculaire());
                        var6.setPatpecPrestations(this.patientPec.getPatpecPrestations());
                        var6.setPatpecSoins(this.patientPec.getPatpecSoins());
                        var6.setPatpecSoinsHospit(this.patientPec.getPatpecSoinsHospit());
                        var6.setPatpecType(this.patientPec.getPatpecType());
                        this.patientPecDao.insert(var6, var1);
                     }
                  }
               }

               var2.commit();
            }
         } catch (HibernateException var11) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var11;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.showModalPanelTrfAyantDroit = false;
      this.afficheButtOption = false;
   }

   public void initImpression() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.var_choix_modele = 0;
      this.visibleOptionMail = false;
      this.affMail = false;
      this.listeDocImp();
      this.showModalPanelPrint = true;
   }

   public void closeImpression() {
      this.showModalPanelPrint = false;
   }

   public void listeDocImp() {
      if (this.var_choix_modele == 0) {
         this.affListeDoc = false;
      } else {
         this.affListeDoc = true;
      }

   }

   public void OptionMail() {
      if (this.format.equalsIgnoreCase("MAIL")) {
         this.visibleOptionMail = true;
      } else {
         this.visibleOptionMail = false;
      }

   }

   public void imprimerPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PRT";
      this.imprimer();
   }

   public void imprimerJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "JRV";
      this.imprimer();
   }

   public void imprimerPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PDF";
      this.imprimer();
   }

   public void imprimerODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "ODT";
      this.imprimer();
   }

   public void imprimerXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XLS";
      this.imprimer();
   }

   public void imprimerDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "DOC";
      this.imprimer();
   }

   public void imprimerHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "HTML";
      this.imprimer();
   }

   public void imprimerXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XML";
      this.imprimer();
   }

   public void imprimerMAIL() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && (this.impDestinataire != null && !this.impDestinataire.isEmpty() || this.impDestinataireCC != null && !this.impDestinataireCC.isEmpty() || this.impDestinataireCCI != null && !this.impDestinataireCCI.isEmpty())) {
         this.format = "MAIL";
         this.imprimer();
      }

   }

   public void envoieMAIL() throws SQLException, JRException, IOException, HibernateException, NamingException {
      if (!this.affMail) {
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, (Tiers)null, "");
         if (this.utilPrint.getLesbalEmetteursItems().size() != 0 && this.utilPrint.getLesbalDestinatairesItems().size() != 0) {
            this.affMail = true;
         } else {
            this.affMail = false;
         }
      } else {
         this.affMail = false;
      }

   }

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.var_choix_modele == 0) {
         if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
            this.requete = " med_patients.`pat_id`='" + this.patients.getPatId() + "'";
            this.utilPrint.setSource("");
            this.utilPrint.setRecordPath("");
            this.utilPrint.setRapport(this.nomModeleDocument);
            this.utilPrint.setRequete(this.requete);
            this.utilPrint.setFiltre("");
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "patient" + File.separator + "document" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "patient" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Impression patient");
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setDestinataireCC(this.impDestinataireCC);
            this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
            this.utilPrint.setIdResponsable(0L);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            ArrayList var1 = new ArrayList();
            JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var1);
            this.utilPrint.setjRBeanCollectionDataSource(var2);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      } else if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
         this.utilPrint.setSource("");
         this.utilPrint.setRecordPath("");
         this.utilPrint.setRapport(this.nomModeleListe);
         this.utilPrint.setEntete("Impression de la liste des patients");
         this.utilPrint.setRequete("");
         this.utilPrint.setFiltre("");
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "patient" + File.separator + "liste" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "patient" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setIdResponsable(0L);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(this.lesPatients);
         this.utilPrint.setjRBeanCollectionDataSource(var3);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public void moduleRecherchePatients(int var1, OptionMedical var2) {
      this.nature = var1;
      this.optionMedical = var2;
      this.var_nom = "";
      this.var_prenom = "";
      this.var_dossier = "";
      this.var_telephone = "";
      this.var_carteIdentite = "";
      this.var_societe = "";
      this.var_assurance = "";
      this.var_complementaire = "";
      this.var_contrat = "";
      this.selectTiers = false;
      this.lesPatients.clear();
      this.dataModelPatients.setWrappedData(this.lesPatients);
      if (this.extDTable == null) {
         this.extDTable = new HtmlExtendedDataTable();
      }

      this.extDTable = new HtmlExtendedDataTable();
      if (this.simpleSelectionEntete == null) {
         this.simpleSelectionEntete = new SimpleSelection();
      }

      this.simpleSelectionEntete.clear();
   }

   public void moduleChargerLesPatients() throws HibernateException, NamingException {
      this.infirmerie = this.rechercheModule(81500);
      this.lesPatients.clear();
      if (this.var_nom != null && !this.var_nom.isEmpty() || this.var_prenom != null && !this.var_prenom.isEmpty() || this.var_dossier != null && !this.var_dossier.isEmpty() || this.var_telephone != null && !this.var_telephone.isEmpty() || this.var_carteIdentite != null && !this.var_carteIdentite.isEmpty() || this.var_societe != null && !this.var_societe.isEmpty() || this.var_assurance != null && !this.var_assurance.isEmpty() || this.var_complementaire != null && !this.var_complementaire.isEmpty() || this.var_contrat != null && !this.var_contrat.isEmpty()) {
         if (this.infirmerie) {
            this.lesPatients = this.patientsDao.chargerListPatients(this.moduleRechercherPatients(), (Session)null);
         } else if (this.var_contrat != null && !this.var_contrat.isEmpty()) {
            new ArrayList();
            this.patientPecDao = new PatientPecDao(this.baseLog, this.utilInitHibernate);
            List var1 = this.patientPecDao.chargerListPatients(this.moduleRechercherPec(), (Session)null);
            if (var1.size() != 0) {
               for(int var2 = 0; var2 < var1.size(); ++var2) {
                  this.lesPatients.add(((PatientPec)var1.get(var2)).getPatient());
               }
            }
         } else {
            this.patientsDao = new PatientsDao(this.baseLog, this.utilInitHibernate);
            this.lesPatients = this.patientsDao.chargerListPatients(this.moduleRechercherPatients(), (Session)null);
         }
      }

      this.dataModelPatients.setWrappedData(this.lesPatients);
      this.patients = new Patients();
      this.var_nom = "";
      this.var_prenom = "";
      this.var_dossier = "";
      this.var_telephone = "";
      this.var_carteIdentite = "";
      this.var_societe = "";
      this.var_assurance = "";
      this.var_complementaire = "";
      this.var_contrat = "";
      if (this.extDTable == null) {
         this.extDTable = new HtmlExtendedDataTable();
      }

      this.extDTable = new HtmlExtendedDataTable();
      if (this.simpleSelectionEntete == null) {
         this.simpleSelectionEntete = new SimpleSelection();
      }

      this.simpleSelectionEntete.clear();
   }

   public String moduleRechercherPec() {
      String var1 = "from PatientPec where patpecId>0 ";
      var1 = var1 + " and patpecNumContrat LIKE '" + this.var_contrat + "%' or patpecMatricule LIKE '" + this.var_contrat + "%'";
      if (this.var_nom != null && !this.var_nom.isEmpty()) {
         var1 = var1 + " and patient.patNom LIKE '" + this.var_nom + "%'";
      }

      if (this.var_prenom != null && !this.var_prenom.isEmpty()) {
         var1 = var1 + " and patient.patPrenom LIKE '" + this.var_prenom + "%'";
      }

      if (this.var_dossier != null && !this.var_dossier.isEmpty()) {
         var1 = var1 + " and patient.patDossier = '" + this.var_dossier + "'";
      }

      if (this.var_telephone != null && !this.var_telephone.isEmpty()) {
         var1 = var1 + " and (patient.patCel1 LIKE '" + this.var_telephone + "%' or patient.patCel2 LIKE '" + this.var_telephone + "%' or patient.patCel3 LIKE '" + this.var_telephone + "%' or patient.patTelDom LIKE '" + this.var_telephone + "%' or patient.patTelVoiture LIKE '" + this.var_telephone + "%')";
      }

      if (this.var_carteIdentite != null && !this.var_carteIdentite.isEmpty()) {
         var1 = var1 + " and (patient.patCi= '" + this.var_carteIdentite + "%' or patient.patPassport='" + this.var_carteIdentite + "' or patient.patSecu='" + this.var_carteIdentite + "')";
      }

      if (this.var_societe != null && !this.var_societe.isEmpty()) {
         var1 = var1 + " and patient.patSociete LIKE '" + this.var_societe + "%'";
      }

      if (this.var_assurance != null && !this.var_assurance.isEmpty()) {
         var1 = var1 + " and patient.patAssurance LIKE '" + this.var_assurance + "%'";
      }

      if (this.var_complementaire != null && !this.var_complementaire.isEmpty()) {
         var1 = var1 + " and patient.patComplementaire LIKE '" + this.var_complementaire + "%'";
      }

      return var1;
   }

   public String moduleRechercherPatients() {
      String var1 = "from Patients where patId>0 ";
      if (this.var_nom != null && !this.var_nom.isEmpty()) {
         var1 = var1 + " and patNom LIKE '" + this.var_nom + "%'";
      }

      if (this.var_prenom != null && !this.var_prenom.isEmpty()) {
         var1 = var1 + " and patPrenom LIKE '" + this.var_prenom + "%'";
      }

      if (this.var_dossier != null && !this.var_dossier.isEmpty()) {
         var1 = var1 + " and patDossier = '" + this.var_dossier + "'";
      }

      if (this.var_telephone != null && !this.var_telephone.isEmpty()) {
         var1 = var1 + " and (patCel1 LIKE '" + this.var_telephone + "%' or patCel2 LIKE '" + this.var_telephone + "%' or patCel3 LIKE '" + this.var_telephone + "%' or patTelDom LIKE '" + this.var_telephone + "%' or patTelVoiture LIKE '" + this.var_telephone + "%')";
      }

      if (this.var_carteIdentite != null && !this.var_carteIdentite.isEmpty()) {
         var1 = var1 + " and (patCi= '" + this.var_carteIdentite + "%' or patSecu='" + this.var_carteIdentite + "')";
      }

      if (this.var_societe != null && !this.var_societe.isEmpty()) {
         var1 = var1 + " and patSociete LIKE '" + this.var_societe + "%'";
      }

      if (this.var_assurance != null && !this.var_assurance.isEmpty()) {
         var1 = var1 + " and patAssurance LIKE '" + this.var_assurance + "%'";
      }

      if (this.var_complementaire != null && !this.var_complementaire.isEmpty()) {
         var1 = var1 + " and patComplementaire LIKE '" + this.var_complementaire + "%'";
      }

      return var1;
   }

   public Patients moduleSelectionPatient() throws HibernateException, NamingException {
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

         this.patients = (Patients)var1.get(0);
         Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "Patients");
         this.chargerLesPec(var4);
         this.utilInitHibernate.closeSession();
         this.selectTiers = true;
         this.afficheButtPec = false;
         this.afficheButtAyd = false;
      } else {
         this.patients = null;
      }

      return this.patients;
   }

   public Patients moduleRecuererPatient() throws HibernateException, NamingException {
      this.recupererUserItem();
      return this.patients;
   }

   public Patients moduleAnnulePatients() {
      this.patients = null;
      return this.patients;
   }

   public Patients moduleCalculePatients() {
      return this.patients;
   }

   public void visualisationPriseEncharge() throws HibernateException, NamingException {
      if (this.patients != null) {
         ArrayList var1 = new ArrayList();
         this.lesPec = new ArrayList();
         if (this.patientPecDao == null) {
            this.patientPecDao = new PatientPecDao(this.baseLog, this.utilInitHibernate);
         }

         this.lesPec = this.patientPecDao.chargerLesPatientsPec(this.patients, 0, (Session)null);
         int var2;
         if (this.lesPec.size() != 0) {
            for(var2 = 0; var2 < this.lesPec.size(); ++var2) {
               if (((PatientPec)this.lesPec.get(var2)).getPatpecScan() != null && !((PatientPec)this.lesPec.get(var2)).getPatpecScan().isEmpty()) {
                  var1.add(((PatientPec)this.lesPec.get(var2)).getPatpecScan());
               }
            }
         }

         this.lesLettreGarantie = new ArrayList();
         if (this.patientLettreGarantieDao == null) {
            this.patientLettreGarantieDao = new PatientLettreGarantieDao(this.baseLog, this.utilInitHibernate);
         }

         this.lesLettreGarantie = this.patientLettreGarantieDao.chargerLesLettresByPatients(this.patients, 1, 9, (Session)null);
         if (this.lesLettreGarantie.size() != 0) {
            for(var2 = 0; var2 < this.lesLettreGarantie.size(); ++var2) {
               if (((PatientLettreGarantie)this.lesLettreGarantie.get(var2)).getPatlgaPhoto() != null && !((PatientLettreGarantie)this.lesLettreGarantie.get(var2)).getPatlgaPhoto().isEmpty()) {
                  var1.add(((PatientLettreGarantie)this.lesLettreGarantie.get(var2)).getPatlgaPhoto());
               }
            }
         }

         this.datamodelPec.setWrappedData(var1);
         this.showModalPanelScan = true;
      }

   }

   public void fermerVisualisationPriseEnCharge() {
      this.showModalPanelScan = false;
   }

   public void effaceListe() {
      this.lesPatients.clear();
      this.dataModelPatients.setWrappedData(this.lesPatients);
      this.patients = new Patients();
      this.var_nom = "";
      this.var_prenom = "";
      this.var_dossier = "";
      this.var_telephone = "";
      this.var_carteIdentite = "";
      this.var_societe = "";
      this.var_assurance = "";
      this.var_complementaire = "";
      this.var_contrat = "";
   }

   public void recupererCivilitesItem() throws IOException {
      this.mesCivilitesItems = new ArrayList();
      LectureCivilites var1 = new LectureCivilites(0);
      this.mesCivilitesItems = var1.getMesCivilitesItems();
   }

   public void recupererPaysItem() throws IOException {
      this.mesPaysItems = new ArrayList();
      LecturePays var1 = new LecturePays();
      this.mesPaysItems = var1.getMesPaysItems();
   }

   public void recupererPecItem() throws IOException {
      this.mesPecItems = new ArrayList();
      LectureCategorieTiers var1 = new LectureCategorieTiers("034");
      this.mesPecItems = var1.getMesCategoriesTiersItems();
   }

   public void recupererReglementClient() throws IOException {
      this.mesReglementClientItems = new ArrayList();
      LectureReglementClient var1 = new LectureReglementClient();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.recupereReglementClient();
      this.mesReglementClientItems = var1.getMesReglementClientItems();
   }

   public void recupererFamillesClientsItem() throws JDOMException, IOException {
      this.mesFamilleClientsItems = new ArrayList();
      this.lesFamilleClientsListe = new ArrayList();
      LectureFamillesClients var1 = new LectureFamillesClients();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      var1.chargerMesFamillesClientItems();
      this.mesFamilleClientsItems = var1.getMesFamillesClientsItems();
      this.lesFamilleClientsListe = var1.getMesFamillesClients();
   }

   public void moduleAjouterPatient() throws HibernateException, NamingException {
      this.patients = new Patients();
      this.patientsDouble = new Patients();
      this.patientsAssure = new Patients();
      this.patients.setPatDateNaissance((Date)null);
      this.patients.setPatPec("");
      this.patients.setPatNomFamille(0);
      this.patients.setPatTypereg(0);
      this.patients.setPatPaysNaissance(this.structureLog.getStrnompays());
      this.patients.setPatPays(this.structureLog.getStrnompays());
      if (this.infirmerie) {
         this.patients.setPatCommune(this.site);
      }

      this.lesContacts.clear();
      this.datamodelContact.setWrappedData(this.lesContacts);
      this.lesAntecedent.clear();
      this.datamodelAntecedent.setWrappedData(this.lesAntecedent);
      this.lesPec.clear();
      this.datamodelPec.setWrappedData(this.lesPec);
      this.lesPatientsAyantDroit.clear();
      this.datamodelAyd.setWrappedData(this.lesPatientsAyantDroit);
      this.lesLettreGarantie.clear();
      this.dataModelLettreGarantie.setWrappedData(this.lesLettreGarantie);
      this.lesProtocole.clear();
      this.datamodelProtocole.setWrappedData(this.lesProtocole);
      this.recupererUserItem();
      this.urlphoto = null;
      this.afficheButtPec = false;
      this.afficheButtAyd = false;
      this.var_action = 5;
   }

   public void recupererUserItem() throws HibernateException, NamingException {
      UserDao var1 = new UserDao(this.baseLog, this.utilInitHibernate);
      this.mesUserItems = new ArrayList();
      this.mesUserItems = var1.chargerLesUsersItem((Session)null);
   }

   public boolean moduleMajPatient() throws HibernateException, NamingException {
      boolean var1 = false;
      if (this.patients.getPatNom() != null && !this.patients.getPatNom().isEmpty() && this.patients.getPatDateNaissance() != null && (this.patients.getPatTelDom() != null && !this.patients.getPatTelDom().isEmpty() || this.patients.getPatCel1() != null && !this.patients.getPatCel1().isEmpty() || this.patients.getPatCel2() != null && !this.patients.getPatCel2().isEmpty() || this.patients.getPatCel3() != null && !this.patients.getPatCel3().isEmpty())) {
         if (this.patients.getPatSerie() == null || this.patients.getPatSerie().isEmpty()) {
            this.patients.setPatSerie("A");
         }

         if (this.lesPatientsAyantDroit.size() != 0) {
            int var2 = 0;

            for(int var3 = 0; var3 < this.lesPatientsAyantDroit.size(); ++var3) {
               if (((Patients)this.lesPatientsAyantDroit.get(var3)).getPatQualite() != null && !((Patients)this.lesPatientsAyantDroit.get(var3)).getPatQualite().isEmpty() && ((Patients)this.lesPatientsAyantDroit.get(var3)).getPatQualite().equalsIgnoreCase("Enfant")) {
                  ++var2;
               }
            }

            this.patients.setPatNbEnfant(var2);
         }

         if (this.patientsAssure != null) {
            this.patients.setPatIdCouvertPar(this.patientsAssure.getPatId());
            this.patients.setPatIdUserPaiement(this.patientsAssure.getPatIdUserPaiement());
            this.patients.setPatSalariePaiement(this.patientsAssure.getPatSalariePaiement());
         } else {
            this.patients.setPatIdCouvertPar(0L);
            this.patients.setPatIdUserPaiement(0L);
            this.patients.setPatSalariePaiement("");
         }

         if (this.lesPec.size() == 0) {
            this.patients.setPatNomFamille(0);
            this.patients.setPatNumContrat("");
            this.patients.setPatImmatriculation("");
            this.patients.setPatAssurance("");
            this.patients.setPatIdAssurance(0L);
            this.patients.setPatComplementaire("");
            this.patients.setPatIdComplementaire(0L);
            this.patients.setPatSociete("");
            this.patients.setPatIdSociete(0L);
         } else {
            this.patients.setPatNomFamille(1);
            this.patients.setPatPec(((PatientPec)this.lesPec.get(0)).getPatpecType());
         }

         Session var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "Patients");
         Transaction var12 = null;

         try {
            var12 = var11.beginTransaction();
            int var5;
            if (this.patients.getPatId() != 0L) {
               this.patients.setPatDateModif(new Date());
               this.patients.setPatUserModif(this.usersLog.getUsrid());
               this.patients = this.patientsDao.modif(this.patients, var11);
            } else {
               if (this.lesFamilleClientsListe.size() != 0) {
                  new ObjetFamilleTiers();

                  for(var5 = 0; var5 < this.lesFamilleClientsListe.size(); ++var5) {
                     ObjetFamilleTiers var4 = (ObjetFamilleTiers)this.lesFamilleClientsListe.get(var5);
                     if (this.patients.getLibelleFamille() != null && !this.patients.getLibelleFamille().isEmpty() && this.patients.getLibelleFamille().equalsIgnoreCase(var4.getLibelle())) {
                        break;
                     }
                  }
               }

               this.patients.setPatDateCreat(new Date());
               this.patients.setPatUserCreat(this.usersLog.getUsrid());
               this.patients.setPatDossier(this.calculChrono.numCompose(this.patients.getPatDateCreat(), 70, this.patients.getPatSerie(), var11));
               this.patients = this.patientsDao.insert(this.patients, var11);
            }

            this.lesPatients.clear();
            this.lesPatients.add(this.patients);
            if (this.patients.getPatIdCouvertPar() == 0L) {
               new ArrayList();
               List var13 = this.patientsDao.chargerlesPatients(this.patients.getPatId(), var11);
               if (var13.size() != 0) {
                  for(var5 = 0; var5 < var13.size(); ++var5) {
                     this.lesPatients.add(var13.get(var5));
                  }
               }
            }

            this.dataModelPatients.setWrappedData(this.lesPatients);
            if (this.extDTable == null) {
               this.extDTable = new HtmlExtendedDataTable();
            }

            this.extDTable = new HtmlExtendedDataTable();
            if (this.simpleSelectionEntete == null) {
               this.simpleSelectionEntete = new SimpleSelection();
            }

            this.simpleSelectionEntete.clear();
            var12.commit();
         } catch (HibernateException var9) {
            if (var12 != null) {
               var12.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         var1 = true;
      }

      return var1;
   }

   public Patients modulePatientDivers() throws HibernateException, NamingException {
      this.patients = new Patients();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Patients");
      this.patients = this.patientsDao.selectPatientDivers(var1);
      if (this.patients == null) {
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.patients = new Patients();
            this.patients.setPatNom("DIVERS");
            this.patients.setPatPrenom("Divers");
            this.patients.setPatSerie("A");
            this.patients.setPatNomFamille(0);
            this.patients.setPatNumContrat("");
            this.patients.setPatImmatriculation("");
            this.patients.setPatAssurance("");
            this.patients.setPatIdAssurance(0L);
            this.patients.setPatComplementaire("");
            this.patients.setPatIdComplementaire(0L);
            this.patients.setPatSociete("");
            this.patients.setPatIdSociete(0L);
            this.patients.setPatDateCreat(new Date());
            this.patients.setPatUserCreat(this.usersLog.getUsrid());
            this.patients.setPatDossier(this.calculChrono.numCompose(this.patients.getPatDateCreat(), 70, this.patients.getPatSerie(), var1));
            this.patients = this.patientsDao.insert(this.patients, var1);
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.utilInitHibernate.closeSession();
      }

      return this.patients;
   }

   public void moduleOuvrirActivites() throws HibernateException, NamingException, ParseException {
      if (this.patients != null) {
         this.exercicesVentes = new ExercicesVentes();
         ExercicesVentesDao var1 = new ExercicesVentesDao(this.baseLog, this.utilInitHibernate);
         this.exercicesVentes = var1.recupererLastExo((Session)null);
         if (this.exercicesVentes != null) {
            this.lesDocumentsEntete = new ArrayList();
            this.dataModelDocumentsEntete = new ListDataModel();
            this.dataModelAntecedent = new ListDataModel();
            this.infirmerie = this.rechercheModule(81500);
            new ArrayList();
            if (this.patientAntDao == null) {
               this.patientAntDao = new PatientAntDao(this.baseLog, this.utilInitHibernate);
            }

            List var2 = this.patientAntDao.chargerLesPatientsAntecedents(this.patients, (Session)null);
            this.dataModelAntecedent.setWrappedData(var2);
            if (var2.size() == 0 || this.usersLog.getUsrVendeur() == 1 && !this.infirmerie) {
               this.accesAntecedent = false;
            } else {
               this.accesAntecedent = true;
            }

            this.choixDocument = 50;
            this.dateDebut = this.exercicesVentes.getExevteDateDebut();
            this.dateFin = new Date();
            this.rechercherLesDocuments();
            this.showModalPanelActvites = true;
         }
      }

   }

   public void moduleFermerActivites() {
      this.showModalPanelActvites = false;
   }

   public ObjetLigneMenu getLigneMenu() {
      return this.ligneMenu;
   }

   public void setLigneMenu(ObjetLigneMenu var1) {
      this.ligneMenu = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public OptionMedical getOptionMedical() {
      return this.optionMedical;
   }

   public void setOptionMedical(OptionMedical var1) {
      this.optionMedical = var1;
   }

   public PatientAnt getPatientAnt() {
      return this.patientAnt;
   }

   public void setPatientAnt(PatientAnt var1) {
      this.patientAnt = var1;
   }

   public PatientContact getPatientContact() {
      return this.patientContact;
   }

   public void setPatientContact(PatientContact var1) {
      this.patientContact = var1;
   }

   public PatientPec getPatientPec() {
      return this.patientPec;
   }

   public void setPatientPec(PatientPec var1) {
      this.patientPec = var1;
   }

   public PatientProt getPatientProt() {
      return this.patientProt;
   }

   public void setPatientProt(PatientProt var1) {
      this.patientProt = var1;
   }

   public Patients getPatients() {
      return this.patients;
   }

   public void setPatients(Patients var1) {
      this.patients = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public boolean isAfficheButtOption() {
      return this.afficheButtOption;
   }

   public void setAfficheButtOption(boolean var1) {
      this.afficheButtOption = var1;
   }

   public String getCategorie() {
      return this.categorie;
   }

   public void setCategorie(String var1) {
      this.categorie = var1;
   }

   public DataModel getDataModelPatients() {
      return this.dataModelPatients;
   }

   public void setDataModelPatients(DataModel var1) {
      this.dataModelPatients = var1;
   }

   public String getLibelleSousMenu() {
      return this.libelleSousMenu;
   }

   public void setLibelleSousMenu(String var1) {
      this.libelleSousMenu = var1;
   }

   public List getMesCategoriesItems() {
      return this.mesCategoriesItems;
   }

   public void setMesCategoriesItems(List var1) {
      this.mesCategoriesItems = var1;
   }

   public List getMesdevisesItem() {
      return this.mesdevisesItem;
   }

   public void setMesdevisesItem(List var1) {
      this.mesdevisesItem = var1;
   }

   public String getNom() {
      return this.nom;
   }

   public void setNom(String var1) {
      this.nom = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public boolean isVisibleOptionMail() {
      return this.visibleOptionMail;
   }

   public void setVisibleOptionMail(boolean var1) {
      this.visibleOptionMail = var1;
   }

   public String getAssurance() {
      return this.assurance;
   }

   public void setAssurance(String var1) {
      this.assurance = var1;
   }

   public String getCarteIdentite() {
      return this.carteIdentite;
   }

   public void setCarteIdentite(String var1) {
      this.carteIdentite = var1;
   }

   public String getComplementaire() {
      return this.complementaire;
   }

   public void setComplementaire(String var1) {
      this.complementaire = var1;
   }

   public String getDossier() {
      return this.dossier;
   }

   public void setDossier(String var1) {
      this.dossier = var1;
   }

   public String getPrenom() {
      return this.prenom;
   }

   public void setPrenom(String var1) {
      this.prenom = var1;
   }

   public String getSociete() {
      return this.societe;
   }

   public void setSociete(String var1) {
      this.societe = var1;
   }

   public String getTelephone() {
      return this.telephone;
   }

   public void setTelephone(String var1) {
      this.telephone = var1;
   }

   public int getTiersPayant() {
      return this.tiersPayant;
   }

   public void setTiersPayant(int var1) {
      this.tiersPayant = var1;
   }

   public DataModel getDatamodelContact() {
      return this.datamodelContact;
   }

   public void setDatamodelContact(DataModel var1) {
      this.datamodelContact = var1;
   }

   public DataModel getDatamodelPersonnelMedical() {
      return this.datamodelPersonnelMedical;
   }

   public void setDatamodelPersonnelMedical(DataModel var1) {
      this.datamodelPersonnelMedical = var1;
   }

   public GmapTag getGmapTag() {
      return this.gmapTag;
   }

   public void setGmapTag(GmapTag var1) {
      this.gmapTag = var1;
   }

   public boolean isModalGoogleMap() {
      return this.modalGoogleMap;
   }

   public void setModalGoogleMap(boolean var1) {
      this.modalGoogleMap = var1;
   }

   public String getPlace() {
      return this.place;
   }

   public void setPlace(String var1) {
      this.place = var1;
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

   public List getMesFamilleClientsItems() {
      return this.mesFamilleClientsItems;
   }

   public void setMesFamilleClientsItems(List var1) {
      this.mesFamilleClientsItems = var1;
   }

   public List getLesFamilleClientsListe() {
      return this.lesFamilleClientsListe;
   }

   public void setLesFamilleClientsListe(List var1) {
      this.lesFamilleClientsListe = var1;
   }

   public boolean isVar_C1() {
      return this.var_C1;
   }

   public void setVar_C1(boolean var1) {
      this.var_C1 = var1;
   }

   public boolean isVar_C2() {
      return this.var_C2;
   }

   public void setVar_C2(boolean var1) {
      this.var_C2 = var1;
   }

   public boolean isVar_Cc1() {
      return this.var_Cc1;
   }

   public void setVar_Cc1(boolean var1) {
      this.var_Cc1 = var1;
   }

   public boolean isVar_Cc2() {
      return this.var_Cc2;
   }

   public void setVar_Cc2(boolean var1) {
      this.var_Cc2 = var1;
   }

   public boolean isVar_Cde1() {
      return this.var_Cde1;
   }

   public void setVar_Cde1(boolean var1) {
      this.var_Cde1 = var1;
   }

   public boolean isVar_Cde2() {
      return this.var_Cde2;
   }

   public void setVar_Cde2(boolean var1) {
      this.var_Cde2 = var1;
   }

   public boolean isVar_D1() {
      return this.var_D1;
   }

   public void setVar_D1(boolean var1) {
      this.var_D1 = var1;
   }

   public boolean isVar_D2() {
      return this.var_D2;
   }

   public void setVar_D2(boolean var1) {
      this.var_D2 = var1;
   }

   public boolean isVar_E1() {
      return this.var_E1;
   }

   public void setVar_E1(boolean var1) {
      this.var_E1 = var1;
   }

   public boolean isVar_E2() {
      return this.var_E2;
   }

   public void setVar_E2(boolean var1) {
      this.var_E2 = var1;
   }

   public boolean isVar_Ee1() {
      return this.var_Ee1;
   }

   public void setVar_Ee1(boolean var1) {
      this.var_Ee1 = var1;
   }

   public boolean isVar_Ee2() {
      return this.var_Ee2;
   }

   public void setVar_Ee2(boolean var1) {
      this.var_Ee2 = var1;
   }

   public boolean isVar_K1() {
      return this.var_K1;
   }

   public void setVar_K1(boolean var1) {
      this.var_K1 = var1;
   }

   public boolean isVar_K2() {
      return this.var_K2;
   }

   public void setVar_K2(boolean var1) {
      this.var_K2 = var1;
   }

   public boolean isAfficheButtContact() {
      return this.afficheButtContact;
   }

   public void setAfficheButtContact(boolean var1) {
      this.afficheButtContact = var1;
   }

   public int getVar_actionContact() {
      return this.var_actionContact;
   }

   public void setVar_actionContact(int var1) {
      this.var_actionContact = var1;
   }

   public boolean isAfficheButtProtocole() {
      return this.afficheButtProtocole;
   }

   public void setAfficheButtProtocole(boolean var1) {
      this.afficheButtProtocole = var1;
   }

   public DataModel getDatamodelProtocole() {
      return this.datamodelProtocole;
   }

   public void setDatamodelProtocole(DataModel var1) {
      this.datamodelProtocole = var1;
   }

   public List getLesContacts() {
      return this.lesContacts;
   }

   public void setLesContacts(List var1) {
      this.lesContacts = var1;
   }

   public List getLesProtocole() {
      return this.lesProtocole;
   }

   public void setLesProtocole(List var1) {
      this.lesProtocole = var1;
   }

   public int getVar_actionProtocole() {
      return this.var_actionProtocole;
   }

   public void setVar_actionProtocole(int var1) {
      this.var_actionProtocole = var1;
   }

   public String getVar_protocole() {
      return this.var_protocole;
   }

   public void setVar_protocole(String var1) {
      this.var_protocole = var1;
   }

   public boolean isAfficheButtAntecedent() {
      return this.afficheButtAntecedent;
   }

   public void setAfficheButtAntecedent(boolean var1) {
      this.afficheButtAntecedent = var1;
   }

   public DataModel getDatamodelAntecedent() {
      return this.datamodelAntecedent;
   }

   public void setDatamodelAntecedent(DataModel var1) {
      this.datamodelAntecedent = var1;
   }

   public List getLesAntecedent() {
      return this.lesAntecedent;
   }

   public void setLesAntecedent(List var1) {
      this.lesAntecedent = var1;
   }

   public int getVar_actionAntecedent() {
      return this.var_actionAntecedent;
   }

   public void setVar_actionAntecedent(int var1) {
      this.var_actionAntecedent = var1;
   }

   public String getVar_antecedent() {
      return this.var_antecedent;
   }

   public void setVar_antecedent(String var1) {
      this.var_antecedent = var1;
   }

   public boolean isAfficheButtPec() {
      return this.afficheButtPec;
   }

   public void setAfficheButtPec(boolean var1) {
      this.afficheButtPec = var1;
   }

   public DataModel getDatamodelPec() {
      return this.datamodelPec;
   }

   public void setDatamodelPec(DataModel var1) {
      this.datamodelPec = var1;
   }

   public List getLesPec() {
      return this.lesPec;
   }

   public void setLesPec(List var1) {
      this.lesPec = var1;
   }

   public int getVar_actionPec() {
      return this.var_actionPec;
   }

   public void setVar_actionPec(int var1) {
      this.var_actionPec = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public String getVar_tiers() {
      return this.var_tiers;
   }

   public void setVar_tiers(String var1) {
      this.var_tiers = var1;
   }

   public DataModel getDatamodelTiers() {
      return this.datamodelTiers;
   }

   public void setDatamodelTiers(DataModel var1) {
      this.datamodelTiers = var1;
   }

   public List getLesTiers() {
      return this.lesTiers;
   }

   public void setLesTiers(List var1) {
      this.lesTiers = var1;
   }

   public boolean isShowModalPanelPec() {
      return this.showModalPanelPec;
   }

   public void setShowModalPanelPec(boolean var1) {
      this.showModalPanelPec = var1;
   }

   public boolean isShowModalPanelTiers() {
      return this.showModalPanelTiers;
   }

   public void setShowModalPanelTiers(boolean var1) {
      this.showModalPanelTiers = var1;
   }

   public List getLesReglementsClient() {
      return this.lesReglementsClient;
   }

   public void setLesReglementsClient(List var1) {
      this.lesReglementsClient = var1;
   }

   public List getMesReglementClientItems() {
      return this.mesReglementClientItems;
   }

   public void setMesReglementClientItems(List var1) {
      this.mesReglementClientItems = var1;
   }

   public boolean isTestModeCalcul() {
      return this.testModeCalcul;
   }

   public void setTestModeCalcul(boolean var1) {
      this.testModeCalcul = var1;
   }

   public boolean isAffListeDoc() {
      return this.affListeDoc;
   }

   public void setAffListeDoc(boolean var1) {
      this.affListeDoc = var1;
   }

   public String getImpDestinataire() {
      return this.impDestinataire;
   }

   public void setImpDestinataire(String var1) {
      this.impDestinataire = var1;
   }

   public String getImpEmetteur() {
      return this.impEmetteur;
   }

   public void setImpEmetteur(String var1) {
      this.impEmetteur = var1;
   }

   public int getVar_choix_modele() {
      return this.var_choix_modele;
   }

   public void setVar_choix_modele(int var1) {
      this.var_choix_modele = var1;
   }

   public String getNomModeleDocument() {
      return this.nomModeleDocument;
   }

   public void setNomModeleDocument(String var1) {
      this.nomModeleDocument = var1;
   }

   public String getNomModeleListe() {
      return this.nomModeleListe;
   }

   public void setNomModeleListe(String var1) {
      this.nomModeleListe = var1;
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

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
   }

   public OptionTiers getOptionTiers() {
      return this.optionTiers;
   }

   public void setOptionTiers(OptionTiers var1) {
      this.optionTiers = var1;
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

   public List getMesCivilitesItems() {
      return this.mesCivilitesItems;
   }

   public void setMesCivilitesItems(List var1) {
      this.mesCivilitesItems = var1;
   }

   public String getImpDestinataireCC() {
      return this.impDestinataireCC;
   }

   public void setImpDestinataireCC(String var1) {
      this.impDestinataireCC = var1;
   }

   public String getImpDestinataireCCI() {
      return this.impDestinataireCCI;
   }

   public void setImpDestinataireCCI(String var1) {
      this.impDestinataireCCI = var1;
   }

   public boolean isShowModalPanelAnt() {
      return this.showModalPanelAnt;
   }

   public void setShowModalPanelAnt(boolean var1) {
      this.showModalPanelAnt = var1;
   }

   public boolean isShowModalPanelCnt() {
      return this.showModalPanelCnt;
   }

   public void setShowModalPanelCnt(boolean var1) {
      this.showModalPanelCnt = var1;
   }

   public boolean isShowModalPanelPrt() {
      return this.showModalPanelPrt;
   }

   public void setShowModalPanelPrt(boolean var1) {
      this.showModalPanelPrt = var1;
   }

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
   }

   public String getUrlphoto() {
      return this.urlphoto;
   }

   public void setUrlphoto(String var1) {
      this.urlphoto = var1;
   }

   public int getNbAnnee() {
      return this.nbAnnee;
   }

   public void setNbAnnee(int var1) {
      this.nbAnnee = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public String getMessageSms() {
      return this.messageSms;
   }

   public void setMessageSms(String var1) {
      this.messageSms = var1;
   }

   public String getNumeroMobile() {
      return this.numeroMobile;
   }

   public void setNumeroMobile(String var1) {
      this.numeroMobile = var1;
   }

   public boolean isShowModalPanelSms() {
      return this.showModalPanelSms;
   }

   public void setShowModalPanelSms(boolean var1) {
      this.showModalPanelSms = var1;
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

   public DataModel getDatamodelAyd() {
      return this.datamodelAyd;
   }

   public void setDatamodelAyd(DataModel var1) {
      this.datamodelAyd = var1;
   }

   public boolean isShowModalPanelFicheAyantDroit() {
      return this.showModalPanelFicheAyantDroit;
   }

   public void setShowModalPanelFicheAyantDroit(boolean var1) {
      this.showModalPanelFicheAyantDroit = var1;
   }

   public Patients getPatientsAyantDroit() {
      return this.patientsAyantDroit;
   }

   public void setPatientsAyantDroit(Patients var1) {
      this.patientsAyantDroit = var1;
   }

   public boolean isAfficheButtAyd() {
      return this.afficheButtAyd;
   }

   public void setAfficheButtAyd(boolean var1) {
      this.afficheButtAyd = var1;
   }

   public Patients getPatientsAssure() {
      return this.patientsAssure;
   }

   public void setPatientsAssure(Patients var1) {
      this.patientsAssure = var1;
   }

   public boolean isAfficheButtConsultation() {
      return this.afficheButtConsultation;
   }

   public void setAfficheButtConsultation(boolean var1) {
      this.afficheButtConsultation = var1;
   }

   public boolean isAfficheButtHospitalisation() {
      return this.afficheButtHospitalisation;
   }

   public void setAfficheButtHospitalisation(boolean var1) {
      this.afficheButtHospitalisation = var1;
   }

   public boolean isAfficheButtLaboratoire() {
      return this.afficheButtLaboratoire;
   }

   public void setAfficheButtLaboratoire(boolean var1) {
      this.afficheButtLaboratoire = var1;
   }

   public boolean isAfficheButtPharmacie() {
      return this.afficheButtPharmacie;
   }

   public void setAfficheButtPharmacie(boolean var1) {
      this.afficheButtPharmacie = var1;
   }

   public DataModel getDataModelDocumentsEntete() {
      return this.dataModelDocumentsEntete;
   }

   public void setDataModelDocumentsEntete(DataModel var1) {
      this.dataModelDocumentsEntete = var1;
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

   public int getChoixDocument() {
      return this.choixDocument;
   }

   public void setChoixDocument(int var1) {
      this.choixDocument = var1;
   }

   public String getChoixProduit() {
      return this.choixProduit;
   }

   public void setChoixProduit(String var1) {
      this.choixProduit = var1;
   }

   public double getVar_reglement() {
      return this.var_reglement;
   }

   public void setVar_reglement(double var1) {
      this.var_reglement = var1;
   }

   public double getVar_solde() {
      return this.var_solde;
   }

   public void setVar_solde(double var1) {
      this.var_solde = var1;
   }

   public double getVar_total() {
      return this.var_total;
   }

   public void setVar_total(double var1) {
      this.var_total = var1;
   }

   public DataModel getDataModelLettreGarantie() {
      return this.dataModelLettreGarantie;
   }

   public void setDataModelLettreGarantie(DataModel var1) {
      this.dataModelLettreGarantie = var1;
   }

   public DataModel getDataModelReglements() {
      return this.dataModelReglements;
   }

   public void setDataModelReglements(DataModel var1) {
      this.dataModelReglements = var1;
   }

   public PatientLettreGarantie getPatientLettreGarantie() {
      return this.patientLettreGarantie;
   }

   public void setPatientLettreGarantie(PatientLettreGarantie var1) {
      this.patientLettreGarantie = var1;
   }

   public boolean isShowModalPanelLesReglements() {
      return this.showModalPanelLesReglements;
   }

   public void setShowModalPanelLesReglements(boolean var1) {
      this.showModalPanelLesReglements = var1;
   }

   public boolean isShowModalPanelLettreGarantie() {
      return this.showModalPanelLettreGarantie;
   }

   public void setShowModalPanelLettreGarantie(boolean var1) {
      this.showModalPanelLettreGarantie = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public boolean isVar_actionLettre() {
      return this.var_actionLettre;
   }

   public void setVar_actionLettre(boolean var1) {
      this.var_actionLettre = var1;
   }

   public String getNomTiers() {
      return this.nomTiers;
   }

   public void setNomTiers(String var1) {
      this.nomTiers = var1;
   }

   public boolean isShowModalPanelScan() {
      return this.showModalPanelScan;
   }

   public void setShowModalPanelScan(boolean var1) {
      this.showModalPanelScan = var1;
   }

   public boolean isVar_valide_lettre() {
      return this.var_valide_lettre;
   }

   public void setVar_valide_lettre(boolean var1) {
      this.var_valide_lettre = var1;
   }

   public long getIdTiersPec() {
      return this.idTiersPec;
   }

   public void setIdTiersPec(long var1) {
      this.idTiersPec = var1;
   }

   public List getMesTiersPEC() {
      return this.mesTiersPEC;
   }

   public void setMesTiersPEC(List var1) {
      this.mesTiersPEC = var1;
   }

   public DataModel getDataModelPatientDoublon() {
      return this.dataModelPatientDoublon;
   }

   public void setDataModelPatientDoublon(DataModel var1) {
      this.dataModelPatientDoublon = var1;
   }

   public boolean isShowModalPanelPatientDublon() {
      return this.showModalPanelPatientDublon;
   }

   public void setShowModalPanelPatientDublon(boolean var1) {
      this.showModalPanelPatientDublon = var1;
   }

   public Patients getPatientsDouble() {
      return this.patientsDouble;
   }

   public void setPatientsDouble(Patients var1) {
      this.patientsDouble = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public boolean isSelectTiers() {
      return this.selectTiers;
   }

   public void setSelectTiers(boolean var1) {
      this.selectTiers = var1;
   }

   public String getVar_assurance() {
      return this.var_assurance;
   }

   public void setVar_assurance(String var1) {
      this.var_assurance = var1;
   }

   public String getVar_carteIdentite() {
      return this.var_carteIdentite;
   }

   public void setVar_carteIdentite(String var1) {
      this.var_carteIdentite = var1;
   }

   public String getVar_complementaire() {
      return this.var_complementaire;
   }

   public void setVar_complementaire(String var1) {
      this.var_complementaire = var1;
   }

   public String getVar_contrat() {
      return this.var_contrat;
   }

   public void setVar_contrat(String var1) {
      this.var_contrat = var1;
   }

   public String getVar_dossier() {
      return this.var_dossier;
   }

   public void setVar_dossier(String var1) {
      this.var_dossier = var1;
   }

   public String getVar_nom() {
      return this.var_nom;
   }

   public void setVar_nom(String var1) {
      this.var_nom = var1;
   }

   public String getVar_prenom() {
      return this.var_prenom;
   }

   public void setVar_prenom(String var1) {
      this.var_prenom = var1;
   }

   public String getVar_societe() {
      return this.var_societe;
   }

   public void setVar_societe(String var1) {
      this.var_societe = var1;
   }

   public String getVar_telephone() {
      return this.var_telephone;
   }

   public void setVar_telephone(String var1) {
      this.var_telephone = var1;
   }

   public List getMesPaysItems() {
      return this.mesPaysItems;
   }

   public void setMesPaysItems(List var1) {
      this.mesPaysItems = var1;
   }

   public List getMesPecItems() {
      return this.mesPecItems;
   }

   public void setMesPecItems(List var1) {
      this.mesPecItems = var1;
   }

   public boolean isInfirmerie() {
      return this.infirmerie;
   }

   public void setInfirmerie(boolean var1) {
      this.infirmerie = var1;
   }

   public int getNbJours() {
      return this.nbJours;
   }

   public void setNbJours(int var1) {
      this.nbJours = var1;
   }

   public boolean isVerrouSexe() {
      return this.verrouSexe;
   }

   public void setVerrouSexe(boolean var1) {
      this.verrouSexe = var1;
   }

   public boolean isShowModalPanelTrfAyantDroit() {
      return this.showModalPanelTrfAyantDroit;
   }

   public void setShowModalPanelTrfAyantDroit(boolean var1) {
      this.showModalPanelTrfAyantDroit = var1;
   }

   public String getNomAssure() {
      return this.nomAssure;
   }

   public void setNomAssure(String var1) {
      this.nomAssure = var1;
   }

   public String getNumeroAssure() {
      return this.numeroAssure;
   }

   public void setNumeroAssure(String var1) {
      this.numeroAssure = var1;
   }

   public String getQualite() {
      return this.qualite;
   }

   public void setQualite(String var1) {
      this.qualite = var1;
   }

   public DataModel getDataModelListAssure() {
      return this.dataModelListAssure;
   }

   public void setDataModelListAssure(DataModel var1) {
      this.dataModelListAssure = var1;
   }

   public boolean isShowModalPanelListeAssure() {
      return this.showModalPanelListeAssure;
   }

   public void setShowModalPanelListeAssure(boolean var1) {
      this.showModalPanelListeAssure = var1;
   }

   public DataModel getDataModelConsActesLignes() {
      return this.dataModelConsActesLignes;
   }

   public void setDataModelConsActesLignes(DataModel var1) {
      this.dataModelConsActesLignes = var1;
   }

   public DataModel getDataModelConsRegLignes() {
      return this.dataModelConsRegLignes;
   }

   public void setDataModelConsRegLignes(DataModel var1) {
      this.dataModelConsRegLignes = var1;
   }

   public DataModel getDataModelHosExmanesLignes() {
      return this.dataModelHosExmanesLignes;
   }

   public void setDataModelHosExmanesLignes(DataModel var1) {
      this.dataModelHosExmanesLignes = var1;
   }

   public DataModel getDataModelHosLaboLignes() {
      return this.dataModelHosLaboLignes;
   }

   public void setDataModelHosLaboLignes(DataModel var1) {
      this.dataModelHosLaboLignes = var1;
   }

   public DataModel getDataModelHosMediLignes() {
      return this.dataModelHosMediLignes;
   }

   public void setDataModelHosMediLignes(DataModel var1) {
      this.dataModelHosMediLignes = var1;
   }

   public DataModel getDataModelHosPrestLignes() {
      return this.dataModelHosPrestLignes;
   }

   public void setDataModelHosPrestLignes(DataModel var1) {
      this.dataModelHosPrestLignes = var1;
   }

   public DataModel getDataModelHosRegLignes() {
      return this.dataModelHosRegLignes;
   }

   public void setDataModelHosRegLignes(DataModel var1) {
      this.dataModelHosRegLignes = var1;
   }

   public DataModel getDataModelHosSejoursLignes() {
      return this.dataModelHosSejoursLignes;
   }

   public void setDataModelHosSejoursLignes(DataModel var1) {
      this.dataModelHosSejoursLignes = var1;
   }

   public DataModel getDataModelLabExamensLignes() {
      return this.dataModelLabExamensLignes;
   }

   public void setDataModelLabExamensLignes(DataModel var1) {
      this.dataModelLabExamensLignes = var1;
   }

   public DataModel getDataModelLabRegLignes() {
      return this.dataModelLabRegLignes;
   }

   public void setDataModelLabRegLignes(DataModel var1) {
      this.dataModelLabRegLignes = var1;
   }

   public DataModel getDataModelPhaRegLignes() {
      return this.dataModelPhaRegLignes;
   }

   public void setDataModelPhaRegLignes(DataModel var1) {
      this.dataModelPhaRegLignes = var1;
   }

   public DataModel getDataModelPharmaciesLignes() {
      return this.dataModelPharmaciesLignes;
   }

   public void setDataModelPharmaciesLignes(DataModel var1) {
      this.dataModelPharmaciesLignes = var1;
   }

   public DataModel getDataModelAntecedent() {
      return this.dataModelAntecedent;
   }

   public void setDataModelAntecedent(DataModel var1) {
      this.dataModelAntecedent = var1;
   }

   public DataModel getDataModelConsLaboLignes() {
      return this.dataModelConsLaboLignes;
   }

   public void setDataModelConsLaboLignes(DataModel var1) {
      this.dataModelConsLaboLignes = var1;
   }

   public DataModel getDataModelConsMediLignes() {
      return this.dataModelConsMediLignes;
   }

   public void setDataModelConsMediLignes(DataModel var1) {
      this.dataModelConsMediLignes = var1;
   }

   public DataModel getDataModelConsOrdoLigne() {
      return this.dataModelConsOrdoLigne;
   }

   public void setDataModelConsOrdoLigne(DataModel var1) {
      this.dataModelConsOrdoLigne = var1;
   }

   public DataModel getDataModelConsScan() {
      return this.dataModelConsScan;
   }

   public void setDataModelConsScan(DataModel var1) {
      this.dataModelConsScan = var1;
   }

   public DataModel getDataModelHosScan() {
      return this.dataModelHosScan;
   }

   public void setDataModelHosScan(DataModel var1) {
      this.dataModelHosScan = var1;
   }

   public DataModel getDataModelLabScan() {
      return this.dataModelLabScan;
   }

   public void setDataModelLabScan(DataModel var1) {
      this.dataModelLabScan = var1;
   }

   public boolean isAccesAntecedent() {
      return this.accesAntecedent;
   }

   public void setAccesAntecedent(boolean var1) {
      this.accesAntecedent = var1;
   }

   public boolean isAccesConsActesLignes() {
      return this.accesConsActesLignes;
   }

   public void setAccesConsActesLignes(boolean var1) {
      this.accesConsActesLignes = var1;
   }

   public boolean isAccesConsLaboLignes() {
      return this.accesConsLaboLignes;
   }

   public void setAccesConsLaboLignes(boolean var1) {
      this.accesConsLaboLignes = var1;
   }

   public boolean isAccesConsMediLignes() {
      return this.accesConsMediLignes;
   }

   public void setAccesConsMediLignes(boolean var1) {
      this.accesConsMediLignes = var1;
   }

   public boolean isAccesConsOrdoLigne() {
      return this.accesConsOrdoLigne;
   }

   public void setAccesConsOrdoLigne(boolean var1) {
      this.accesConsOrdoLigne = var1;
   }

   public boolean isAccesConsRegLignes() {
      return this.accesConsRegLignes;
   }

   public void setAccesConsRegLignes(boolean var1) {
      this.accesConsRegLignes = var1;
   }

   public boolean isAccesConsScan() {
      return this.accesConsScan;
   }

   public void setAccesConsScan(boolean var1) {
      this.accesConsScan = var1;
   }

   public boolean isAccesHosExmanesLignes() {
      return this.accesHosExmanesLignes;
   }

   public void setAccesHosExmanesLignes(boolean var1) {
      this.accesHosExmanesLignes = var1;
   }

   public boolean isAccesHosLaboLignes() {
      return this.accesHosLaboLignes;
   }

   public void setAccesHosLaboLignes(boolean var1) {
      this.accesHosLaboLignes = var1;
   }

   public boolean isAccesHosMediLignes() {
      return this.accesHosMediLignes;
   }

   public void setAccesHosMediLignes(boolean var1) {
      this.accesHosMediLignes = var1;
   }

   public boolean isAccesHosPrestLignes() {
      return this.accesHosPrestLignes;
   }

   public void setAccesHosPrestLignes(boolean var1) {
      this.accesHosPrestLignes = var1;
   }

   public boolean isAccesHosRegLignes() {
      return this.accesHosRegLignes;
   }

   public void setAccesHosRegLignes(boolean var1) {
      this.accesHosRegLignes = var1;
   }

   public boolean isAccesHosScan() {
      return this.accesHosScan;
   }

   public void setAccesHosScan(boolean var1) {
      this.accesHosScan = var1;
   }

   public boolean isAccesHosSejoursLignes() {
      return this.accesHosSejoursLignes;
   }

   public void setAccesHosSejoursLignes(boolean var1) {
      this.accesHosSejoursLignes = var1;
   }

   public boolean isAccesLabExamensLignes() {
      return this.accesLabExamensLignes;
   }

   public void setAccesLabExamensLignes(boolean var1) {
      this.accesLabExamensLignes = var1;
   }

   public boolean isAccesLabRegLignes() {
      return this.accesLabRegLignes;
   }

   public void setAccesLabRegLignes(boolean var1) {
      this.accesLabRegLignes = var1;
   }

   public boolean isAccesLabScan() {
      return this.accesLabScan;
   }

   public void setAccesLabScan(boolean var1) {
      this.accesLabScan = var1;
   }

   public boolean isAccesPhaRegLignes() {
      return this.accesPhaRegLignes;
   }

   public void setAccesPhaRegLignes(boolean var1) {
      this.accesPhaRegLignes = var1;
   }

   public boolean isAccesPharmaciesLignes() {
      return this.accesPharmaciesLignes;
   }

   public void setAccesPharmaciesLignes(boolean var1) {
      this.accesPharmaciesLignes = var1;
   }

   public boolean isAccesConsultation() {
      return this.accesConsultation;
   }

   public void setAccesConsultation(boolean var1) {
      this.accesConsultation = var1;
   }

   public boolean isAccesInfirmerie() {
      return this.accesInfirmerie;
   }

   public void setAccesInfirmerie(boolean var1) {
      this.accesInfirmerie = var1;
   }

   public ConsultationEnteteGene getConsultationEnteteGene() {
      return this.consultationEnteteGene;
   }

   public void setConsultationEnteteGene(ConsultationEnteteGene var1) {
      this.consultationEnteteGene = var1;
   }

   public ConsultationInfirmerie getConsultationInfirmerie() {
      return this.consultationInfirmerie;
   }

   public void setConsultationInfirmerie(ConsultationInfirmerie var1) {
      this.consultationInfirmerie = var1;
   }

   public String getVar_lib_poids() {
      return this.var_lib_poids;
   }

   public void setVar_lib_poids(String var1) {
      this.var_lib_poids = var1;
   }

   public String getNomDocument() {
      return this.nomDocument;
   }

   public void setNomDocument(String var1) {
      this.nomDocument = var1;
   }

   public String getNomRepertoire() {
      return this.nomRepertoire;
   }

   public void setNomRepertoire(String var1) {
      this.nomRepertoire = var1;
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

   public boolean isShowModalPanelPjCons() {
      return this.showModalPanelPjCons;
   }

   public void setShowModalPanelPjCons(boolean var1) {
      this.showModalPanelPjCons = var1;
   }

   public boolean isShowModalPanelPjHos() {
      return this.showModalPanelPjHos;
   }

   public void setShowModalPanelPjHos(boolean var1) {
      this.showModalPanelPjHos = var1;
   }

   public boolean isShowModalPanelPjLab() {
      return this.showModalPanelPjLab;
   }

   public void setShowModalPanelPjLab(boolean var1) {
      this.showModalPanelPjLab = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public Date getVar_date_accident() {
      return this.var_date_accident;
   }

   public void setVar_date_accident(Date var1) {
      this.var_date_accident = var1;
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

   public Date getDateDocument() {
      return this.dateDocument;
   }

   public void setDateDocument(Date var1) {
      this.dateDocument = var1;
   }

   public String getNumeroDocument() {
      return this.numeroDocument;
   }

   public void setNumeroDocument(String var1) {
      this.numeroDocument = var1;
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

   public boolean isShowModalPanelActvites() {
      return this.showModalPanelActvites;
   }

   public void setShowModalPanelActvites(boolean var1) {
      this.showModalPanelActvites = var1;
   }

   public DataModel getDatamodelFda() {
      return this.datamodelFda;
   }

   public void setDatamodelFda(DataModel var1) {
      this.datamodelFda = var1;
   }

   public boolean isShowModalPanelFda() {
      return this.showModalPanelFda;
   }

   public void setShowModalPanelFda(boolean var1) {
      this.showModalPanelFda = var1;
   }

   public int getVar_actionFda() {
      return this.var_actionFda;
   }

   public void setVar_actionFda(int var1) {
      this.var_actionFda = var1;
   }

   public boolean isAfficheButtFda() {
      return this.afficheButtFda;
   }

   public void setAfficheButtFda(boolean var1) {
      this.afficheButtFda = var1;
   }

   public int getChoixRacine() {
      return this.choixRacine;
   }

   public void setChoixRacine(int var1) {
      this.choixRacine = var1;
   }

   public String getSelecFiscalite() {
      return this.selecFiscalite;
   }

   public void setSelecFiscalite(String var1) {
      this.selecFiscalite = var1;
   }

   public List getMesServicesItem() {
      return this.mesServicesItem;
   }

   public void setMesServicesItem(List var1) {
      this.mesServicesItem = var1;
   }

   public List getMesDepartementsItem() {
      return this.mesDepartementsItem;
   }

   public void setMesDepartementsItem(List var1) {
      this.mesDepartementsItem = var1;
   }

   public List getMesSitesItem() {
      return this.mesSitesItem;
   }

   public void setMesSitesItem(List var1) {
      this.mesSitesItem = var1;
   }

   public String getSite() {
      return this.site;
   }

   public void setSite(String var1) {
      this.site = var1;
   }

   public List getMesUserItems() {
      return this.mesUserItems;
   }

   public void setMesUserItems(List var1) {
      this.mesUserItems = var1;
   }

   public DataModel getDataModelDentition() {
      return this.dataModelDentition;
   }

   public void setDataModelDentition(DataModel var1) {
      this.dataModelDentition = var1;
   }
}
