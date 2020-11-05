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
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PatientAnt;
import com.epegase.systeme.classe.PatientLettreGarantie;
import com.epegase.systeme.classe.PatientPec;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.PharmacieEntete;
import com.epegase.systeme.classe.PharmacieLigne;
import com.epegase.systeme.classe.PharmacieReglement;
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
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.ConventionMedicalDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.FactureLigneMedicalDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.PatientAntDao;
import com.epegase.systeme.dao.PatientLettreGarantieDao;
import com.epegase.systeme.dao.PatientPecDao;
import com.epegase.systeme.dao.PatientProtDao;
import com.epegase.systeme.dao.PatientsDao;
import com.epegase.systeme.dao.PharmacieEnteteDao;
import com.epegase.systeme.dao.PharmacieLigneDao;
import com.epegase.systeme.dao.PharmacieReglementDao;
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
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.LireLesoptionsCaisses;
import com.epegase.systeme.xml.ObjetCategories;
import com.epegase.systeme.xml.ObjetLigneOnglet;
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

public class FormPharmacie implements Serializable {
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
   private List mesCategoriesItems;
   private List lesCategoriesList;
   private List mesComplementaireItems;
   private List lesComplementairesList;
   private ConventionMedical conventionMedical = new ConventionMedical();
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
   private boolean patientDivers = false;
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
   private List mesTaxesMedicalItems;
   private boolean tBudget = false;
   private boolean tActivite = false;
   private boolean tParc = false;
   private String var_imput_serie;
   private String var_imput_cat;
   private boolean showModalPanelImput = false;
   private UtilDate utilDate;
   private UtilNombre utilNombre;
   private transient DataModel datamodelDocument = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private List lesPharmacieEntete = new ArrayList();
   private PharmacieEntete pharmacieEntete;
   private PharmacieEnteteDao pharmacieEnteteDao;
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
   private boolean validePharmacie;
   private List mesPharmaciesItems;
   private boolean verrouPharmacie;
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
   private transient DataModel dataModelPharmacie = new ListDataModel();
   private List lesMedicamments = new ArrayList();
   private PharmacieLigne pharmacieLigne;
   private PharmacieLigneDao pharmacieLigneDao;
   private boolean griserchamps = false;
   private float var_pecCnamgs;
   private boolean var_pecAssurance;
   private boolean afficheButtActes;
   private List lesTarifs = new ArrayList();
   private String inpCodeFamille;
   private PatientPecDao patientPecDao;
   private TaxesVentesDao taxesMedicalDao;
   private ProduitsTarifDao produitsTarifDao;
   private ConventionMedicalDao conventionMedicalDao;
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
   private String var_depotProd;
   private List mesProduitsDepotsItems = new ArrayList();
   private List listeProduitDepot = new ArrayList();
   private List mesConditionnementsItems = new ArrayList();
   private List mesConditionnementsProduits;
   private List mesUnitesItems;
   private List mesUnitesProduits;
   private boolean var_aff_condit = false;
   private boolean var_aff_unite = false;
   private int var_code_unite;
   private Unite unite;
   private UniteDao uniteDao;
   private ProduitsDepotDao produitsDepotDao;
   private ProduitsDepot produitsDepot = new ProduitsDepot();
   private CalculStock calculStock = new CalculStock();
   private float var_memo_qte;
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
   private List mesTypeReglementsCaisse;
   private List listCaisses;
   private List mesCaissesSeriesItems;
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
   private transient DataModel datamodelRecu;
   private boolean var_verouxModReg;
   private boolean var_affichMontant;
   private String var_inputCaisse;
   private double var_netAPayer;
   private boolean showModalPanelPaye = false;
   private String var_nom_client;
   private String var_num_facture;
   private String var_montant;
   private boolean showModalPanelReglement = false;
   private List listFactureSelectionne;
   private Reglements reglements;
   private Reglements memoReglements;
   private boolean var_affiche_banque = false;
   private String var_type_reg;
   private int varTypeReg;
   private String var_objet;
   private String var_banque_tireur;
   private String var_num_cheque;
   private List mesModesleRecus;
   private String nomRepMod;
   private double val_timbre;
   private double var_ecart_reglement;
   private String var_banque_destination;
   private boolean var_affiche_banque_destination = false;
   private List mesBanquesItems;
   private CaissesCommerciales caissesCommerciales;
   private CaissesCommercialesDao caissesCommercialesDao;
   private boolean showModalPanelPrintRecu = false;
   private boolean showModalPanelHistoReglement = false;
   private String numLettreGarantie;
   private double montantElmTotReliquat;
   private boolean var_affiche_lettre = false;
   private List mesLettresGarantiesItems;
   private double reliquatPatient;
   private boolean showModalPanelAnnuler = false;
   private boolean ajouterSurAvoir = false;
   private Date dateRefacturation;
   private String numRefacturation;
   private String etatRefacuration;
   private boolean autoriseRefacturation;
   private boolean showModalPanelChangerService = false;
   private String nouveauService;
   private long nouveauMedecin;
   private String ancienMedecin;

   public FormPharmacie() {
      this.listeProduitDepot = new ArrayList();
      this.mesProduitsDepotsItems = new ArrayList();
      this.mesConditionnementsProduits = new ArrayList();
      this.mesUnitesProduits = new ArrayList();
      this.unite = new Unite();
      this.utilNombre = new UtilNombre();
      this.utilDate = new UtilDate();
      this.datamodelRecu = new ListDataModel();
      this.listFactureSelectionne = new ArrayList();
      this.mesModesleRecus = new ArrayList();
      this.mesBanquesItems = new ArrayList();
      this.mesCaissesSeriesItems = new ArrayList();
      this.mesTypeReglementsCaisse = new ArrayList();
      this.mesLettresGarantiesItems = new ArrayList();
      this.mesCategoriesItems = new ArrayList();
      this.lesCategoriesList = new ArrayList();
      this.mesComplementaireItems = new ArrayList();
      this.lesComplementairesList = new ArrayList();
      this.mesCaissesSeriesItems = new ArrayList();
      this.datamodelDocumentTrace = new ListDataModel();
   }

   public void instanceDaoUtilises() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.pharmacieEnteteDao = new PharmacieEnteteDao(this.baseLog, this.utilInitHibernate);
      this.pharmacieLigneDao = new PharmacieLigneDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.patientAntDao = new PatientAntDao(this.baseLog, this.utilInitHibernate);
      this.produitsMedicDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      this.produitsMclesDao = new ProduitsMclesDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      this.patientPecDao = new PatientPecDao(this.baseLog, this.utilInitHibernate);
      this.taxesMedicalDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      this.produitsTarifDao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
      this.conventionMedicalDao = new ConventionMedicalDao(this.baseLog, this.utilInitHibernate);
      this.reglementsDao = new ReglementsDao(this.baseLog, this.utilInitHibernate);
      this.bonEncaissementVenteDao = new BonEncaissementVenteDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
   }

   public void configMedical(Session var1) throws HibernateException, NamingException {
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

      this.patients = new Patients();
      PatientsDao var2 = new PatientsDao(this.baseLog, this.utilInitHibernate);
      this.patients = var2.selectPatientDivers(var1);
      if (this.patients != null) {
         this.patientDivers = true;
      } else {
         this.patientDivers = false;
      }

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
      if (!this.var_affiche_service) {
         this.pharmacieEntete.setPhaService("");
      }

      this.lesMedecins = this.usersDao.chargerLesUsersByServices(this.pharmacieEntete.getPhaService(), var1);
      this.mesMedecinsItem.clear();

      for(int var2 = 0; var2 < this.lesMedecins.size(); ++var2) {
         Users var3 = (Users)this.lesMedecins.get(var2);
         if ((var3.getUsrFonction().contains("Professeur") || var3.getUsrFonction().contains("Médecin")) && var3.getUsrPatronyme() != null && !var3.getUsrPatronyme().isEmpty()) {
            this.mesMedecinsItem.add(new SelectItem(var3.getUsrid(), var3.getUsrPatronyme() + ":" + var3.getUsrMetier()));
         }
      }

      this.verifValidePharmacie();
   }

   public void chargerMedecinService() throws HibernateException, NamingException {
      this.mesMedecinsItem.clear();
      String var1 = "";
      if (this.nouveauService != null && !this.nouveauService.isEmpty()) {
         var1 = this.nouveauService;
      } else if (this.pharmacieEntete.getPhaService() != null && !this.pharmacieEntete.getPhaService().isEmpty()) {
         var1 = this.pharmacieEntete.getPhaService();
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
      this.var_action = 1;
      this.nomFamille = 0L;
      this.nomComplementaire = 0L;
      this.var_pecCnamgs = 0.0F;
      this.verifValidePharmacie();
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
      this.pharmacieEntete.setPatients(this.patients);
      this.pharmacieEntete.setPhaIdPatient(this.patients.getPatId());
      if (this.patients.getPatPrenom() != null && !this.patients.getPatPrenom().isEmpty()) {
         this.pharmacieEntete.setPhaNomPatient(this.patients.getPatNom() + " " + this.patients.getPatPrenom());
      } else {
         this.pharmacieEntete.setPhaNomPatient(this.patients.getPatNom());
      }

      this.pharmacieEntete.setPhaCivilite(this.patients.getPatCivilite());
      this.pharmacieEntete.setPhaPecCnamgs(0.0F);
      this.nomFamille = (long)this.patients.getPatNomFamille();
      this.pharmacieEntete.setPhaFam(this.nomFamille);
      this.nomComplementaire = this.patients.getPatPecComplementaire();
      this.pharmacieEntete.setPhaComplementaire(this.nomComplementaire);
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
            if ((((PatientPec)var3.get(var4)).getPatpecInactif() == 0 || ((PatientPec)var3.get(var4)).getTiers().getTieid() == this.pharmacieEntete.getPhaIdAssurance() || ((PatientPec)var3.get(var4)).getTiers().getTieid() == this.pharmacieEntete.getPhaIdSociete() || ((PatientPec)var3.get(var4)).getTiers().getTieid() == this.pharmacieEntete.getPhaIdComplementaire()) && ((PatientPec)var3.get(var4)).getPatpecType() != null && !((PatientPec)var3.get(var4)).getPatpecType().isEmpty()) {
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

   public void validerTiersDivers() throws HibernateException, NamingException {
      this.patients = this.formPatients.modulePatientDivers();
      if (this.patients != null) {
         this.pharmacieEntete.setPatients(this.patients);
         this.pharmacieEntete.setPhaIdPatient(this.patients.getPatId());
         this.pharmacieEntete.setPhaNomPatient(this.patients.getPatNom() + " " + this.patients.getPatPrenom());
         this.pharmacieEntete.setPhaCivilite(this.patients.getPatCivilite());
         this.pharmacieEntete.setPhaPecCnamgs(0.0F);
         this.pharmacieEntete.setPhaFam((long)this.patients.getPatNomFamille());
         this.mesProtocoleItems.clear();
         this.lesPatientAntecedent.clear();
         this.mesPecItem.clear();
         this.mesPecItem.add(new SelectItem("Sans"));
         this.mesCategoriesItems.clear();
         this.mesCategoriesItems.add(new SelectItem("0", "Non Assuré"));
         this.mesComplementaireItems.clear();
         this.var_pecAssurance = false;
         this.var_aff_action = false;
         this.var_action = 1;
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
      this.lesPharmacieEntete.clear();
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
         var16 = this.pharmacieEnteteDao.recherchePharmacie(var1, this.exercicesVentes.getExevteId(), this.getInpNum(), this.getInpNomPatient(), this.getInpPrenomPatient(), this.getInpTel(), this.getInpCi(), this.getInpDossier(), this.getInpSociete(), this.getInpAssurance(), this.getInpComplementaire(), this.getInpContrat(), this.getInpEtat(), this.getInpSerie(), this.getInpFam(), this.getPeriode(), this.getInpService(), this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.getInpProtocole(), this.getInpMedecin(), this.getInpActivite(), var14, var15);
      }

      int var17;
      if (this.inpEtat == 13) {
         if (((List)var16).size() != 0) {
            for(var17 = 0; var17 < ((List)var16).size(); ++var17) {
               if (((PharmacieEntete)((List)var16).get(var17)).getPhaEtat() == 1 || ((PharmacieEntete)((List)var16).get(var17)).getPhaEtat() == 4 || ((PharmacieEntete)((List)var16).get(var17)).getPhaEtat() == 5 || ((PharmacieEntete)((List)var16).get(var17)).getPhaEtat() == 6) {
                  this.lesPharmacieEntete.add(((List)var16).get(var17));
               }
            }
         }
      } else if (this.inpEtat == 15) {
         for(var17 = 0; var17 < ((List)var16).size(); ++var17) {
            if (((PharmacieEntete)((List)var16).get(var17)).getPhaEtat() == 6) {
               this.lesPharmacieEntete.add(((List)var16).get(var17));
            }
         }
      } else if (this.inpEtat != 17 && this.inpEtat != 18) {
         this.lesPharmacieEntete = (List)var16;
      } else {
         for(var17 = 0; var17 < ((List)var16).size(); ++var17) {
            if (((PharmacieEntete)((List)var16).get(var17)).getPhaEtat() == 5 || ((PharmacieEntete)((List)var16).get(var17)).getPhaEtat() == 6) {
               this.lesPharmacieEntete.add(((List)var16).get(var17));
            }
         }
      }

      if (this.lesPharmacieEntete.size() > 0) {
         this.datamodelDocument = new ListDataModel();
         this.datamodelDocument.setWrappedData(this.lesPharmacieEntete);
         new PharmacieEntete();

         for(int var18 = 0; var18 < this.lesPharmacieEntete.size(); ++var18) {
            PharmacieEntete var19 = (PharmacieEntete)this.lesPharmacieEntete.get(var18);
            var2 += var19.getPhaTotPatient();
            var4 += var19.getPhaTotTaxePatient();
            var6 = var6 + var19.getPhaTotAssurance() + var19.getPhaTotSociete() + var19.getPhaTotComplmentaire();
            var8 = var8 + var19.getPhaTotTaxeAssurance() + var19.getPhaTotTaxeSociete() + var19.getPhaTotTaxeComplementaire();
            var10 += var19.getPhaRegPatient();
            var12 += var19.getPhaRegTiers();
         }

         this.var_nb_ligne = this.lesPharmacieEntete.size();
      }

      this.totalPatient = var2 + var4;
      this.totalTiers = var6 + var8;
      this.regPatient = var10;
      this.regTiers = var12;
      this.soldePatient = var2 + var4 - var10;
      this.soldeTiers = var6 + var8 - var12;
      this.visibiliteBton = false;
   }

   public void selectionOrdonnance() throws HibernateException, NamingException, JDOMException, IOException {
      this.pharmacieEntete = new PharmacieEntete();
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
            this.pharmacieEntete = (PharmacieEntete)var1.get(0);
            this.var_pecCnamgs = this.pharmacieEntete.getPhaPecCnamgs();
            this.nomFamille = this.pharmacieEntete.getPhaFam();
            this.nomComplementaire = this.pharmacieEntete.getPhaComplementaire();
            if (this.pharmacieEntete.getPhaIdAssurance() != 0L) {
               this.var_pecAssurance = true;
            } else {
               this.var_pecAssurance = false;
            }

            this.var_nom_medecin = this.pharmacieEntete.getPhaIdMedecin();
            this.var_date = this.pharmacieEntete.getPhaDate();
            if (this.pharmacieEntete.getPhaDate().getHours() <= 9) {
               this.var_heure = "0" + this.pharmacieEntete.getPhaDate().getHours();
            } else {
               this.var_heure = "" + this.pharmacieEntete.getPhaDate().getHours();
            }

            if (this.pharmacieEntete.getPhaDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.pharmacieEntete.getPhaDate().getMinutes();
            } else {
               this.var_minute = "" + this.pharmacieEntete.getPhaDate().getMinutes();
            }

            if (this.pharmacieEntete.getPhaDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.pharmacieEntete.getPhaDate().getSeconds();
            } else {
               this.var_seconde = "" + this.pharmacieEntete.getPhaDate().getSeconds();
            }

            this.patients = this.pharmacieEntete.getPatients();
            Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
            this.chargerPriseEnCharges(var6);
            this.elementPatient(var6);
            this.chargerActes(var6);
            this.var_aff_detail_prod = false;
            this.afficheButtActes = false;
            this.afficheButtAntecedent = false;
            double var4 = this.chargerBonEncaissement(var6);
            this.calculMedecinActe(var6);
            this.chargerUserChrono(var6);
            this.utilInitHibernate.closeSession();
            if (var4 != 0.0D && this.pharmacieEntete.getPhaRegPatient() != var4) {
               this.pharmacieEntete.setPhaRegPatient(var4);
               if (var4 >= this.pharmacieEntete.getPhaTotPatient()) {
                  this.pharmacieEntete.setPhaSoldePatient(1);
               } else {
                  this.pharmacieEntete.setPhaSoldePatient(0);
               }

               this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var6);
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
      if (this.pharmacieEntete != null) {
         if (this.pharmacieEntete.getPhaEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void chargerPriseEnCharges(Session var1) throws HibernateException, NamingException {
      this.patientPec = null;
      this.patientPecComplementaire = null;
      if (this.pharmacieEntete.getPhaFam() != 0L) {
         this.patientPec = this.patientPecDao.trouverPatientsPec(this.pharmacieEntete.getPhaFam(), 0, var1);
      }

      if (this.pharmacieEntete.getPhaComplementaire() != 0L) {
         this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.pharmacieEntete.getPhaComplementaire(), 0, var1);
      }

   }

   public void chargerActes(Session var1) throws HibernateException, NamingException {
      this.lesMedicamments.clear();
      this.lesMedicamments = this.pharmacieLigneDao.selectConsActesByConsEnt(this.pharmacieEntete, var1);
      this.dataModelPharmacie.setWrappedData(this.lesMedicamments);
      this.pharmacieLigne = new PharmacieLigne();
      this.ajouterSurAvoir = false;
      this.totalDocFacture = 0.0D;
      this.totalDocPatient = 0.0D;
      this.totalDocReglement = 0.0D;
      this.totalDocTiers = 0.0D;
      if (this.lesMedicamments.size() != 0) {
         for(int var2 = 0; var2 < this.lesMedicamments.size(); ++var2) {
            this.totalDocFacture += ((PharmacieLigne)this.lesMedicamments.get(var2)).getPhaligTotal() + ((PharmacieLigne)this.lesMedicamments.get(var2)).getPhaligTaxe();
            this.totalDocPatient += ((PharmacieLigne)this.lesMedicamments.get(var2)).getTotlalPatient();
            this.totalDocReglement += ((PharmacieLigne)this.lesMedicamments.get(var2)).getPhaligRegPatient();
            this.totalDocTiers += ((PharmacieLigne)this.lesMedicamments.get(var2)).getTotalTiers();
            if (((PharmacieLigne)this.lesMedicamments.get(var2)).getPhaligQte() < 0.0F && (((PharmacieLigne)this.lesMedicamments.get(var2)).getPharmacieEntete().getPhaDateTransfert() == null || ((PharmacieLigne)this.lesMedicamments.get(var2)).getPharmacieEntete().getPhaEtat() <= 9)) {
               this.ajouterSurAvoir = true;
            }
         }
      }

   }

   public void chargerDocumentTrace() throws HibernateException, NamingException {
      this.datamodelDocumentTrace = new ListDataModel();
      Object var1 = new ArrayList();
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "RefacturationMed");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         if (this.pharmacieEntete.getPhaId() > 0L) {
            FactureLigneMedicalDao var4 = new FactureLigneMedicalDao(this.baseLog, this.utilInitHibernate);
            var1 = var4.chargerLesLignesFacturesByNature(this.pharmacieEntete.getPhaId(), "", 73, var2);
            if (((List)var1).size() != 0) {
               if (this.pharmacieEntete.getPhaEtat() <= 5) {
                  this.pharmacieEntete.setPhaEtat(6);
                  this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var2);
               }
            } else if (this.pharmacieEntete.getPhaEtat() >= 6) {
               this.pharmacieEntete.setPhaEtat(5);
               this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var2);
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

   public double chargerBonEncaissement(Session var1) throws HibernateException, NamingException {
      this.var_tot_bon_encaissement = 0.0D;
      new ArrayList();
      List var2 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.pharmacieEntete.getPhaId(), this.nature, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (((BonEncaissementVente)var2.get(var3)).getBonEtat() == 0) {
               this.var_tot_bon_encaissement = this.var_tot_bon_encaissement + ((BonEncaissementVente)var2.get(var3)).getBonAPayer() + ((BonEncaissementVente)var2.get(var3)).getBonAPayerReliquat();
            }
         }
      }

      new ArrayList();
      List var8 = this.reglementsDao.reglementDocument(this.pharmacieEntete.getPhaId(), this.nature, var1);
      double var4 = 0.0D;
      this.afficheRecu = false;
      if (var8.size() != 0) {
         this.afficheRecu = true;
         new Reglements();

         for(int var7 = 0; var7 < var8.size(); ++var7) {
            Reglements var6 = (Reglements)var8.get(var7);
            this.var_tot_bon_encaissement = this.var_tot_bon_encaissement + var6.getRglRecette() - var6.getRglDepense();
         }
      }

      this.datamodelRecu.setWrappedData(var8);
      if (this.var_tot_bon_encaissement < this.pharmacieEntete.getTotalPatient()) {
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
      if (this.pharmacieEntete != null && this.pharmacieEntete.getPhaSerie() != null && !this.pharmacieEntete.getPhaSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.pharmacieEntete.getPhaSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void calculTotaux() {
      if (this.pharmacieEntete.getPhaPathologie() == null || this.pharmacieEntete.getPhaPathologie().isEmpty() || !this.pharmacieEntete.getPhaPathologie().contains(":") || this.pharmacieEntete.getPhaPathologie().equals("100")) {
         this.pharmacieEntete.setPhaPathologie("");
      }

      if (this.pharmacieEntete.getPhaProtocole() == null || this.pharmacieEntete.getPhaProtocole().isEmpty() || !this.pharmacieEntete.getPhaProtocole().contains(":") || this.pharmacieEntete.getPhaProtocole().equals("100")) {
         this.pharmacieEntete.setPhaProtocole("");
      }

      if (this.pharmacieEntete.getPhaService() == null || this.pharmacieEntete.getPhaService().isEmpty() || !this.pharmacieEntete.getPhaService().contains(":") || this.pharmacieEntete.getPhaService().equals("100")) {
         this.pharmacieEntete.setPhaService("");
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
      if (this.lesMedicamments.size() != 0) {
         new PharmacieLigne();

         for(int var24 = 0; var24 < this.lesMedicamments.size(); ++var24) {
            PharmacieLigne var23 = (PharmacieLigne)this.lesMedicamments.get(var24);
            var5 += var23.getPhaligPatientHt();
            var7 += var23.getPhaligPatientTaxe();
            var9 += var23.getPhaligSocieteHt();
            var11 += var23.getPhaligSocieteTaxe();
            var13 += var23.getPhaligAssuranceHt();
            var15 += var23.getPhaligAssuranceTaxe();
            var17 += var23.getPhaligComplementaireHt();
            var19 += var23.getPhaligComplementaireTaxe();
            var21 += var23.getPhaligRabais();
         }

         var1 = var5 + var9 + var13 + var17;
         var3 = var7 + var11 + var15 + var19;
      }

      this.pharmacieEntete.setPhaTotPatient(var5);
      this.pharmacieEntete.setPhaTotTaxePatient(var7);
      this.pharmacieEntete.setPhaTotSociete(var9);
      this.pharmacieEntete.setPhaTotTaxeSociete(var11);
      this.pharmacieEntete.setPhaTotAssurance(var13);
      this.pharmacieEntete.setPhaTotTaxeAssurance(var15);
      this.pharmacieEntete.setPhaTotComplmentaire(var17);
      this.pharmacieEntete.setPhaTotTaxeComplementaire(var19);
      this.pharmacieEntete.setPhaTotGeneral(var1);
      this.pharmacieEntete.setPhaTotTaxeGeneral(var3);
      this.pharmacieEntete.setPhaTotRabais(var21);
      this.var_tot_tiers = var9 + var13 + var17;
      this.var_tot_reg = this.pharmacieEntete.getPhaRegPatient() + this.pharmacieEntete.getPhaRegTiers();
      this.var_solde = this.pharmacieEntete.getPhaTotGeneral() - this.var_tot_reg;
      this.totalDocFacture = var1 + var3;
      this.totalDocPatient = var5 + var7;
      this.totalDocReglement = this.var_tot_reg;
      this.totalDocTiers = var9 + var11 + var13 + var15 + var17 + var19;
   }

   public void calculeEtat() throws HibernateException, NamingException {
      if (this.pharmacieEntete != null) {
         this.dateRefacturation = null;
         this.numRefacturation = "";
         this.etatRefacuration = "";
         this.autoriseRefacturation = false;
         new FactureLigneMedical();
         FactureLigneMedicalDao var2 = new FactureLigneMedicalDao(this.baseLog, this.utilInitHibernate);
         FactureLigneMedical var1 = var2.rechercheFactureByPharmacie(this.pharmacieEntete.getPhaId(), (Session)null);
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
      if (this.pharmacieEntete != null) {
         this.pharmacieEntete.setPhaBloqueRefacturation(true);
         this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete);
      }

   }

   public void deBloqueFacturation() throws HibernateException, NamingException {
      if (this.pharmacieEntete != null) {
         this.pharmacieEntete.setPhaBloqueRefacturation(false);
         this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete);
      }

   }

   public void ajoutDocument() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      this.lesMedecins.clear();
      this.mesMedecinsItem.clear();
      this.lesPatientAntecedent.clear();
      this.dataModelAntecedent.setWrappedData(this.lesPatientAntecedent);
      this.lesMedicamments.clear();
      this.dataModelPharmacie.setWrappedData(this.lesMedicamments);
      this.pharmacieEntete = new PharmacieEntete();
      this.pharmacieLigne = new PharmacieLigne();
      this.mesCategoriesItems.clear();
      this.calculMedecinActe();
      this.nomFamille = 0L;
      this.nomComplementaire = 0L;
      this.patientPec = null;
      this.patientPecComplementaire = null;
      this.validePharmacie = false;
      if (this.patients != null && this.var_consultation_directe) {
         this.calculePatient();
         this.var_action = 1;
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

      this.pharmacieEntete.setPhaIdCreateur(this.usersLog.getUsrid());
      this.pharmacieEntete.setPhaNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.pharmacieEntete.setPhaIdMedecin(this.usersLog.getUsrid());
      this.pharmacieEntete.setPhaMedecin(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.pharmacieEntete.setPhaDate(new Date());
      this.pharmacieEntete.setPhaDateCreat(new Date());
      this.pharmacieEntete.setPhaDateModif((Date)null);
      this.pharmacieEntete.setPhaIdModif(0L);
      this.pharmacieEntete.setPhaNomModif("");
      this.pharmacieEntete.setPhaNum("");
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
      this.verrouPharmacie = false;
      this.pharmacieEntete.setPhaPharmacie("");
      if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty() && this.mesPharmaciesItems.size() != 0) {
         for(int var1 = 0; var1 < this.mesPharmaciesItems.size(); ++var1) {
            if (((SelectItem)this.mesPharmaciesItems.get(var1)).getValue().toString().equals(this.usersLog.getUsrService())) {
               this.pharmacieEntete.setPhaPharmacie(this.usersLog.getUsrService());
               this.verrouPharmacie = true;
               break;
            }
         }
      }

      this.totalDocFacture = 0.0D;
      this.totalDocPatient = 0.0D;
      this.totalDocReglement = 0.0D;
      this.totalDocTiers = 0.0D;
      this.var_memo_action = this.var_action;
   }

   public void modifDocument() throws JDOMException, IOException, ParseException {
      if (this.pharmacieEntete != null) {
         this.chargerModeEcheance();
         this.var_action = 2;
         this.var_aff_action = false;
         this.var_aff_detail_tiers = true;
         this.visibleOnglet = true;
         this.verifValidePharmacie();
         this.var_memo_action = this.var_action;
      }

   }

   public void consultDocument() throws ParseException {
      if (this.pharmacieEntete != null) {
         this.chargerModeEcheance();
         this.var_action = 3;
         this.var_aff_action = true;
         this.var_aff_detail_tiers = true;
         this.visibleOnglet = true;
         this.validePharmacie = false;
         this.var_memo_action = this.var_action;
      }

   }

   public void chargerModeEcheance() throws ParseException {
      this.visibilitenbrjr = false;
      this.visibiliteterme = false;
      this.visibiliteencaissemt = false;
      if (this.pharmacieEntete.getPhaTypeReg() != 0 && this.pharmacieEntete.getPhaTypeReg() != 3) {
         if (this.pharmacieEntete.getPhaTypeReg() != 1 && this.pharmacieEntete.getPhaTypeReg() != 2) {
            this.visibiliteterme = false;
         } else {
            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
            this.visibiliteencaissemt = false;
         }
      } else {
         this.pharmacieEntete.setPhaNbJourReg(0);
         this.pharmacieEntete.setPhaArrondiReg(0);
      }

      if (this.pharmacieEntete.getPhaTypeReg() == 4) {
         this.visibiliteencaissemt = true;
         this.visibilitenbrjr = true;
      } else {
         this.visibiliteencaissemt = false;
      }

      this.CalculDateEcheance();
   }

   public void CalculDateEcheance() throws ParseException {
      Date var1 = this.utilDate.CalculDateEcheance(this.pharmacieEntete.getPhaDate(), this.pharmacieEntete.getPhaTypeReg(), this.pharmacieEntete.getPhaNbJourReg(), this.pharmacieEntete.getPhaArrondiReg());
      this.pharmacieEntete.setPhaDateEcheReg(var1);
   }

   public void selectionPec() throws HibernateException, NamingException {
      this.changerTarif();
   }

   public void supprimerDocument() throws HibernateException, NamingException {
      if (this.pharmacieEntete != null) {
         String var1 = this.pharmacieEntete.getPhaNum();
         new ArrayList();
         List var2 = this.reglementsDao.reglementDocument(this.pharmacieEntete.getPhaId(), this.nature, (Session)null);
         if (var2.size() == 0) {
            Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
            Transaction var4 = null;

            try {
               var4 = var3.beginTransaction();
               if (this.lesMedicamments.size() != 0) {
                  for(int var5 = 0; var5 < this.lesMedicamments.size(); ++var5) {
                     this.pharmacieLigne = (PharmacieLigne)this.lesMedicamments.get(var5);
                     this.pharmacieLigneDao.delete(this.pharmacieLigne, var3);
                  }
               }

               new ArrayList();
               List var13 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.pharmacieEntete.getPhaId(), this.nature, var3);
               if (var13.size() != 0) {
                  for(int var6 = 0; var6 < var13.size(); ++var6) {
                     this.bonEncaissementVente = (BonEncaissementVente)var13.get(var6);
                     this.bonEncaissementVenteDao.delete(this.bonEncaissementVente, var3);
                  }
               }

               new PharmacieEntete();
               PharmacieEntete var14 = this.pharmacieEnteteDao.selectById(this.pharmacieEntete.getPhaId(), var3);
               if (var14 != null) {
                  this.pharmacieEnteteDao.delete(var14, var3);
               }

               this.lesPharmacieEntete.remove(this.pharmacieEntete);
               Espion var7 = new Espion();
               var7.setUsers(this.usersLog);
               var7.setEsptype(0);
               var7.setEspdtecreat(new Date());
               var7.setEspaction("Suppression pharmacie N° " + var1);
               this.espionDao.mAJEspion(var7, var3);
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
      this.calculTotaux();
      boolean var1 = false;
      this.verifieExistenceHabilitation((Session)null);
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         this.pharmacieEntete.setPhaDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         new Users();
         if (this.var_nom_medecin == 0L && this.mesMedecinsItem.size() == 1) {
            this.var_nom_medecin = Long.parseLong(((SelectItem)this.mesMedecinsItem.get(0)).getValue().toString());
         }

         Users var4 = this.usersDao.selectUserD(this.var_nom_medecin, var2);
         if (var4 != null) {
            this.pharmacieEntete.setPhaIdMedecin(var4.getUsrid());
            this.pharmacieEntete.setPhaMedecin(var4.getUsrPatronyme());
         } else {
            this.pharmacieEntete.setPhaIdMedecin(0L);
            this.pharmacieEntete.setPhaMedecin("");
         }

         this.pharmacieEntete.setPhaPecCnamgs(this.var_pecCnamgs);
         this.pharmacieEntete.setPhaAyantDroit(false);
         this.pharmacieEntete.setPhaNomAssurePrincipal("");
         if (this.pharmacieEntete.getPhaFam() == 0L && this.nomComplementaire == 0L) {
            this.pharmacieEntete.setPhaIdAssurance(0L);
            this.pharmacieEntete.setPhaNomAssurance("");
            this.pharmacieEntete.setPhaContratAssurance("");
            this.pharmacieEntete.setPhaIdComplementaire(0L);
            this.pharmacieEntete.setPhaNomComplemtaire("");
            this.pharmacieEntete.setPhaIdEmployeur(0L);
            this.pharmacieEntete.setPhaNomEmployeur("");
            this.pharmacieEntete.setPhaContratComplementaire("");
            this.pharmacieEntete.setPhaIdSociete(0L);
            this.pharmacieEntete.setPhaNomSociete("");
            this.pharmacieEntete.setPhaMatricule("");
         } else {
            if (this.patientPec == null) {
               this.patientPec = this.patientPecDao.trouverPatientsPec(this.pharmacieEntete.getPhaFam(), 0, var2);
            }

            if (this.patientPec != null) {
               if (this.patientPec.getPatpecType() != null && !this.patientPec.getPatpecType().isEmpty()) {
                  if (!this.patientPec.getPatpecType().equals("Assurance") && !this.patientPec.getPatpecType().equals("IPM")) {
                     if (!this.patientPec.getPatpecType().equals("Mutuelle") && !this.patientPec.getPatpecType().equals("Complémentaire")) {
                        this.pharmacieEntete.setPhaIdSociete(this.patientPec.getTiers().getTieid());
                        this.pharmacieEntete.setPhaNomSociete(this.patientPec.getTiers().getTieraisonsocialenom());
                        this.pharmacieEntete.setPhaMatricule(this.patientPec.getPatpecMatricule());
                     } else {
                        this.pharmacieEntete.setPhaIdComplementaire(this.patientPec.getTiers().getTieid());
                        this.pharmacieEntete.setPhaNomComplemtaire(this.patientPec.getTiers().getTieraisonsocialenom());
                        this.pharmacieEntete.setPhaMatricule(this.patientPec.getPatpecMatricule());
                        this.pharmacieEntete.setPhaContratComplementaire(this.patientPec.getPatpecNumContrat());
                     }
                  } else {
                     this.var_pecAssurance = true;
                     this.pharmacieEntete.setPhaIdAssurance(this.patientPec.getTiers().getTieid());
                     this.pharmacieEntete.setPhaNomAssurance(this.patientPec.getTiers().getTieraisonsocialenom());
                     this.pharmacieEntete.setPhaIdEmployeur(this.patientPec.getPatpecIdEmployeur());
                     this.pharmacieEntete.setPhaNomEmployeur(this.patientPec.getPatpecNomEmployeur());
                     this.pharmacieEntete.setPhaMatricule(this.patientPec.getPatpecMatricule());
                     this.pharmacieEntete.setPhaContratAssurance(this.patientPec.getPatpecNumContrat());
                  }

                  if (this.patientPec.getPatpecIdCouvert() != 0L) {
                     this.pharmacieEntete.setPhaAyantDroit(true);
                     this.pharmacieEntete.setPhaNomAssurePrincipal(this.patientPec.getPatpecNomCouvert());
                  }
               }
            } else {
               this.pharmacieEntete.setPhaFam(0L);
            }
         }

         this.pharmacieEntete.setPhaService(this.pharmacieEntete.getPhaPharmacie());
         if (this.pharmacieEntete.getPhaId() != 0L) {
            if (this.lesMedicamments.size() == 0) {
               this.formRecherche.setMessageTexte("Vous n'avez pas spécifié de produits. Veuillez cliquez sur l'onglet Produits et saisir au moins un produit.");
               this.formRecherche.setShowModalPanelMessage(true);
            } else {
               this.pharmacieEntete.setPhaDateModif(new Date());
               this.pharmacieEntete.setPhaIdModif(this.usersLog.getUsrid());
               this.pharmacieEntete.setPhaNomModif(this.usersLog.getUsrPatronyme());
               this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var2);
               this.var_action = 0;
               this.var_memo_action = this.var_action;
            }
         } else {
            if (!this.pharmacieEntete.getPhaSerie().equalsIgnoreCase("X") && !this.pharmacieEntete.getPhaSerie().isEmpty()) {
               this.pharmacieEntete.setPhaNum(this.calculChrono.numCompose(this.pharmacieEntete.getPhaDate(), this.nature, this.pharmacieEntete.getPhaSerie(), var2));
               boolean var16 = false;

               label280:
               while(true) {
                  while(true) {
                     if (var16) {
                        break label280;
                     }

                     new PharmacieEntete();
                     PharmacieEntete var6 = this.pharmacieEnteteDao.selectByNum(this.pharmacieEntete.getPhaNum(), this.pharmacieEntete.getPhaSerie(), var2);
                     if (var6 != null) {
                        long var7 = 100000000L * this.usersLog.getUsrid();

                        for(long var9 = 0L; var9 < var7; ++var9) {
                        }

                        this.pharmacieEntete.setPhaNum(this.calculChrono.numCompose(this.pharmacieEntete.getPhaDate(), this.nature, this.pharmacieEntete.getPhaSerie(), var2));
                        var16 = false;
                     } else {
                        var16 = true;
                     }
                  }
               }
            } else {
               long var5 = this.pharmacieEnteteDao.selectLastNum(var2);
               this.pharmacieEntete.setPhaNum("" + var5);
            }

            this.pharmacieEntete.setExerciceventes(this.exercicesVentes);
            this.pharmacieEntete.setPatients(this.patients);
            this.pharmacieEntete.setPhaDateCreat(new Date());
            this.pharmacieEntete.setPhaIdCreateur(this.usersLog.getUsrid());
            this.pharmacieEntete.setPhaNomCreateur(this.usersLog.getUsrPatronyme());
            this.pharmacieEntete.setPhaEtat(0);
            this.pharmacieEntete.setPhaEtatVal(0);
            this.pharmacieEntete = this.pharmacieEnteteDao.insert(this.pharmacieEntete, var2);
            this.lesPharmacieEntete.add(this.pharmacieEntete);
            this.datamodelDocument.setWrappedData(this.lesPharmacieEntete);
            this.var_action = 2;
            this.var_memo_action = this.var_action;
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         }

         this.verifValidePharmacie();
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

      if (var1 && this.usersChrono.getUsrchrValidation() == 4 && this.pharmacieEntete.getPhaEtat() == 1 && this.pharmacieEntete.getPhaTotPatient() != 0.0D) {
         if (this.usersLog.getUsrFactureCaisse() == 1 && this.var_tot_bon_encaissement == 0.0D) {
            this.payeDocumentBonEncaissement();
         } else if (this.usersLog.getUsrFactureCaisse() == 2 && this.pharmacieEntete.getPhaRegPatient() != this.pharmacieEntete.getPhaTotPatient()) {
            this.payeXDocumentRecu();
         } else if (this.usersLog.getUsrFactureCaisse() == 3) {
         }
      }

      this.var_consultation_directe = false;
      this.visibleOnglet = true;
   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.pharmacieEntete.setPhaEtatVal(1);
         this.pharmacieEntete.setPhaEtat(0);
         return true;
      } else {
         this.pharmacieEntete.setPhaEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.pharmacieEntete.setPhaEtat(1);
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2) {
               if (this.usersChrono.getUsrchrValidation() == 3) {
                  this.pharmacieEntete.setPhaEtat(0);
               } else if (this.usersChrono.getUsrchrValidation() == 4) {
                  this.pharmacieEntete.setPhaEtat(1);
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
      if (this.lesMedicamments.size() == 0 && this.pharmacieEntete.getPhaId() != 0L) {
         this.pharmacieEntete.setPhaDateAnnule(new Date());
         this.pharmacieEntete.setPhaEtat(3);
         this.pharmacieEntete.setPhaMotifAnnule("ANNULATION SAISIE SUR AJOUT");
         this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete);
         this.lesPharmacieEntete.remove(this.pharmacieEntete);
         this.datamodelDocument.setWrappedData(this.lesPharmacieEntete);
      }

   }

   public void verifValidePharmacie() {
      this.validePharmacie = false;
      if (this.pharmacieEntete.getPhaIdPatient() != 0L) {
         if (this.optionMedical.getServicePH().equals("0")) {
            if (this.pharmacieEntete.getPhaPharmacie() != null && !this.pharmacieEntete.getPhaPharmacie().isEmpty()) {
               if (this.optionMedical.getMedecinPH().equals("0")) {
                  if (this.var_nom_medecin != 0L) {
                     this.validePharmacie = true;
                  }
               } else {
                  this.validePharmacie = true;
               }
            }
         } else if (this.optionMedical.getMedecinPH().equals("0")) {
            if (this.var_nom_medecin != 0L) {
               this.validePharmacie = true;
            }
         } else {
            this.validePharmacie = true;
         }
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.pharmacieEntete.getPhaEtat() == 0 && this.usersChrono.getUsrchrValidation() == 2) {
            this.pharmacieEntete.setPhaEtat(1);
            this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
            if (this.lesMedicamments.size() != 0) {
               for(int var3 = 0; var3 < this.lesMedicamments.size(); ++var3) {
                  this.pharmacieLigne = (PharmacieLigne)this.lesMedicamments.get(var3);
                  if (this.pharmacieLigne.getPhaligProduit() != null && !this.pharmacieLigne.getPhaligProduit().isEmpty()) {
                     this.produits = this.produitsMedicDao.chargeProduit(this.pharmacieLigne.getPhaligProduit(), var1);
                     if (this.produits != null && this.produits.getProStock() >= 1) {
                        this.calculStock.majPharmacie(this.pharmacieLigne, this.produits, 0.0F, 0, this.baseLog, var1);
                     }
                  }
               }
            }

            Espion var9 = new Espion();
            var9.setUsers(this.usersLog);
            var9.setEsptype(0);
            var9.setEspdtecreat(new Date());
            var9.setEspaction("Validation manuelle pharmacie (M.) N° " + this.pharmacieEntete.getPhaNum() + " du " + this.utilDate.dateToStringSQLLight(this.pharmacieEntete.getPhaDate()));
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
         if (this.pharmacieEntete.getPhaEtat() == 1 && this.usersChrono.getUsrchrDeValidation() == 1) {
            this.pharmacieEntete.setPhaEtat(0);
            this.pharmacieEntete.setPhaDateImp((Date)null);
            this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
            new ArrayList();
            List var3 = this.bonEncaissementVenteDao.rechercheBeByDoc(this.pharmacieEntete.getPhaId(), this.nature, var1);
            int var4;
            if (var3.size() != 0) {
               for(var4 = 0; var4 < var3.size(); ++var4) {
                  this.bonEncaissementVente = (BonEncaissementVente)var3.get(var4);
                  this.bonEncaissementVenteDao.delete(this.bonEncaissementVente, var1);
               }
            }

            this.var_tot_bon_encaissement = 0.0D;
            if (this.lesMedicamments.size() != 0) {
               for(var4 = 0; var4 < this.lesMedicamments.size(); ++var4) {
                  this.pharmacieLigne = (PharmacieLigne)this.lesMedicamments.get(var4);
                  if (this.pharmacieLigne.getPhaligProduit() != null && !this.pharmacieLigne.getPhaligProduit().isEmpty()) {
                     this.produits = this.produitsMedicDao.chargeProduit(this.pharmacieLigne.getPhaligProduit(), var1);
                     if (this.produits != null && this.produits.getProStock() >= 1) {
                        this.calculStock.majPharmacie(this.pharmacieLigne, this.produits, 0.0F, 1, this.baseLog, var1);
                     }
                  }
               }
            }

            Espion var10 = new Espion();
            var10.setUsers(this.usersLog);
            var10.setEsptype(0);
            var10.setEspdtecreat(new Date());
            var10.setEspaction("Dévalidation manuelle pharmacie (M.) N° " + this.pharmacieEntete.getPhaNum() + " du " + this.utilDate.dateToStringSQLLight(this.pharmacieEntete.getPhaDate()));
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
      if (this.pharmacieEntete != null) {
         this.pharmacieEntete.setPhaDateAnnule(new Date());
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

               if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 61 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.pharmacieEntete.getPhaSerie())) {
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
      if (this.pharmacieEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.pharmacieEntete.getPhaDateAnnule() == null) {
               this.pharmacieEntete.setPhaDateAnnule(new Date());
            }

            this.pharmacieEntete.setPhaEtat(3);
            this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
            new ArrayList();
            List var3 = this.reglementsDao.reglementDocument(this.pharmacieEntete.getPhaId(), this.nature, var1);
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
                        var12 = this.majBonencaissementAnnulation(var4, this.pharmacieEntete.getPhaDateAnnule(), var1);
                     } else if (this.usersLog.getUsrFactureCaisse() == 2) {
                        var12 = this.majReglementAnnulation(var4, this.pharmacieEntete.getPhaDateAnnule(), var1);
                     } else if (this.usersLog.getUsrFactureCaisse() == 3) {
                        var12 = this.majBonencaissementAnnulation(var4, this.pharmacieEntete.getPhaDateAnnule(), var1);
                     }
                  }

                  if (var12) {
                     this.lesPharmacieEntete.remove(this.pharmacieEntete);
                     this.datamodelDocument.setWrappedData(this.lesPharmacieEntete);
                  } else {
                     this.pharmacieEntete = this.pharmacieEnteteDao.selectById(this.pharmacieEntete.getPhaId(), var1);
                     if (this.pharmacieEntete != null) {
                        this.pharmacieEntete.setPhaDateAnnule((Date)null);
                        this.pharmacieEntete.setPhaEtat(1);
                        this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
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

      String var8 = this.calculChrono.numCompose(new Date(), 79, this.pharmacieEntete.getPhaSerie(), var4);
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
         this.bonEncaissementVente.setBonActivite(this.pharmacieEntete.getPhaActivite());
         this.bonEncaissementVente.setBonSite("");
         this.bonEncaissementVente.setBonDepartement("");
         this.bonEncaissementVente.setBonService(this.pharmacieEntete.getPhaService());
         this.bonEncaissementVente.setBonRegion("");
         this.bonEncaissementVente.setBonSecteur("");
         this.bonEncaissementVente.setBonPdv("");
         this.bonEncaissementVente.setBonDateEcheReg((Date)null);
         this.bonEncaissementVente.setBonEtat(0);
         this.bonEncaissementVente.setBonNatRef(this.nature);
         this.bonEncaissementVente.setBonNomTiers(this.pharmacieEntete.getPhaNomPatient());
         this.bonEncaissementVente.setBonIdTiers(this.pharmacieEntete.getPatients().getPatId());
         this.bonEncaissementVente.setBonNomContact("");
         this.bonEncaissementVente.setBonIdContact(0L);
         this.bonEncaissementVente.setBonTypeTiers(4);
         this.bonEncaissementVente.setBonLibelle("Annulation Règlement Pharmacie N° " + this.pharmacieEntete.getPhaNum());
         this.bonEncaissementVente.setBonRef(this.pharmacieEntete.getPhaNum());
         this.bonEncaissementVente.setBonIdRef(this.pharmacieEntete.getPhaId());
         this.bonEncaissementVente.setBonObject(this.pharmacieEntete.getPhaMotifAnnule());
         this.bonEncaissementVente.setBonObservation(this.pharmacieEntete.getPhaMedecin());
         this.bonEncaissementVente.setBonSerie(this.pharmacieEntete.getPhaSerie());
         this.bonEncaissementVente.setBonDevise(this.structureLog.getStrdevise());
         this.bonEncaissementVente.setBonTotTtc(this.pharmacieEntete.getPhaTotTaxePatient() + this.pharmacieEntete.getPhaTotPatient());
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
         var9.setEspaction("Annulation pharmacie N° " + this.pharmacieEntete.getPhaNum() + " pour " + this.pharmacieEntete.getPhaMotifAnnule());
         this.espionDao.mAJEspion(var9, var4);
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

      String var13 = this.calculChrono.numComposeCaisse(new Date(), 61, "0", this.pharmacieEntete.getPhaSerie(), this.var_inputCaisse, var4);
      if (var13 != null && !var13.isEmpty()) {
         this.reglements = new Reglements();
         this.reglements.setRglOperation("03");
         this.reglements.setRglActivite(this.pharmacieEntete.getPhaActivite());
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
         this.reglements.setRglDocument(this.pharmacieEntete.getPhaNum());
         this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
         this.reglements.setRglIdBon(0L);
         this.reglements.setRglIdDocument(this.pharmacieEntete.getPhaId());
         this.reglements.setRglIdTiers(this.pharmacieEntete.getPatients().getPatId());
         this.reglements.setRglDepotTiers(0);
         this.reglements.setRglLibelle("");
         this.reglements.setRglMode("0");
         this.reglements.setRglModele("");
         this.reglements.setRglNatureDoc(73);
         this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
         this.reglements.setRglNomTiers(this.pharmacieEntete.getPhaNomPatient());
         this.reglements.setRglIdContact(0L);
         this.reglements.setRglNomContact("");
         this.reglements.setRglNum(var13);
         this.reglements.setRglNumChqBdx("");
         this.reglements.setRglObjet("Annulation Règlement Pharmacie N° " + this.pharmacieEntete.getPhaNum());
         this.reglements.setRglParc("");
         this.reglements.setRglPdv("");
         this.reglements.setRglRecette(var1 * -1.0D);
         this.reglements.setRglTimbre(0.0D);
         this.reglements.setRglRegion("");
         this.reglements.setRglSecteur("");
         this.reglements.setRglSerie(this.pharmacieEntete.getPhaSerie());
         this.reglements.setRglService(this.pharmacieEntete.getPhaService());
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
         var12.setEspaction("Annulation pharmacie N° " + this.pharmacieEntete.getPhaNum() + " pour " + this.pharmacieEntete.getPhaMotifAnnule());
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
      if (this.pharmacieEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.pharmacieEntete.setPhaEtat(0);
            this.pharmacieEntete.setPhaDateAnnule((Date)null);
            this.pharmacieEntete.setPhaMotifAnnule("");
            this.pharmacieEntete.setPhaRegPatient(this.pharmacieEntete.getPhaTotPatient());
            this.pharmacieEntete.setPhaRegTiers(this.pharmacieEntete.getTotalTiers());
            this.pharmacieEntete.setPhaSoldePatient(1);
            this.pharmacieEntete.setPhaSoldeTiers(1);
            this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
            new ArrayList();
            List var3 = this.reglementsDao.reglementDocument(this.pharmacieEntete.getPhaId(), this.nature, var1);
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
            var13.setEspaction("Réactivation pharmacie N° " + this.pharmacieEntete.getPhaNum());
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
      if (this.pharmacieEntete != null) {
         this.nouveauService = "";
         this.nouveauMedecin = 0L;
         this.ancienMedecin = "";
         if (this.pharmacieEntete.getPhaIdMedecin() != 0L) {
            new Users();
            Users var1 = this.usersDao.selectLeUserId(this.pharmacieEntete.getPhaIdMedecin(), (Session)null);
            if (var1 != null) {
               this.ancienMedecin = var1.getUsrPatronyme();
            }
         }
      }

   }

   public void annulerChangerService() {
      this.showModalPanelChangerService = false;
   }

   public void validerChangerService() throws HibernateException, NamingException {
      if (this.pharmacieEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            boolean var3 = false;
            boolean var4 = false;
            String var5 = this.pharmacieEntete.getPhaService();
            if (this.nouveauService != null && !this.nouveauService.isEmpty() && (this.pharmacieEntete.getPhaService() == null || this.pharmacieEntete.getPhaService().isEmpty() || !this.nouveauService.equals(this.pharmacieEntete.getPhaService()))) {
               var3 = true;
            }

            if (this.nouveauMedecin != 0L && this.nouveauMedecin != this.pharmacieEntete.getPhaIdMedecin()) {
               var4 = true;
            }

            if (var3 || var4) {
               if (var3) {
                  this.pharmacieEntete.setPhaService(this.nouveauService);
               }

               if (var4) {
                  this.pharmacieEntete.setPhaIdMedecin(this.nouveauMedecin);
               }

               this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
               if (var3) {
                  new ArrayList();
                  List var6 = this.reglementsDao.reglementDocument(this.pharmacieEntete.getPhaId(), this.nature, var1);
                  if (var6.size() != 0) {
                     for(int var7 = 0; var7 < var6.size(); ++var7) {
                        this.reglements = (Reglements)var6.get(var7);
                        this.reglements.setRglService(this.nouveauService);
                        this.reglements = this.reglementsDao.modifierReg(this.reglements, var1);
                     }
                  }

                  PharmacieReglementDao var17 = new PharmacieReglementDao(this.baseLog, this.utilInitHibernate);
                  new ArrayList();
                  List var8 = var17.selectReglementByEnt(this.pharmacieEntete, var1);
                  if (var8.size() != 0) {
                     new PharmacieReglement();

                     for(int var10 = 0; var10 < var8.size(); ++var10) {
                        PharmacieReglement var9 = (PharmacieReglement)var8.get(var10);
                        var9.setPharegService(this.nouveauService);
                        var17.modif(var9, var1);
                     }
                  }

                  Espion var20 = new Espion();
                  var20.setUsers(this.usersLog);
                  var20.setEsptype(0);
                  var20.setEspdtecreat(new Date());
                  var20.setEspaction("Chg service pharmacie (M.) N° " + this.pharmacieEntete.getPhaNum() + " du " + this.utilDate.dateToStringSQLLight(this.pharmacieEntete.getPhaDate()) + " du service " + var5 + " au service " + this.nouveauService);
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
                  var19.setEspaction("Chg médecin pharmacie (M.) N° " + this.pharmacieEntete.getPhaNum() + " du " + this.utilDate.dateToStringSQLLight(this.pharmacieEntete.getPhaDate()) + " du médecin " + var5 + " au médecin " + var16);
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

   public void ajouterAntecedent() throws IOException {
      this.patientAnt = new PatientAnt();
      this.var_antecedent = "";
      this.var_actionAntecedent = 1;
      this.patientAnt.setPatantDate(this.pharmacieEntete.getPhaDate());
      this.patientAnt.setPatantMedecin(this.pharmacieEntete.getPhaMedecin());
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
            this.patientAnt.setPatantNumConsultGene(this.pharmacieEntete.getPhaNum());
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
      this.pharmacieLigne = new PharmacieLigne();
      this.mesProduitsDepotsItems.clear();
      this.var_depotProd = "";
      this.var_aff_detail_prod = false;
      this.afficheButtActes = false;
      this.validePharmacie = false;
      this.ajouterSurAvoir = false;
      if (this.lesMedicamments.size() != 0) {
         for(int var1 = 0; var1 < this.lesMedicamments.size(); ++var1) {
            if (((PharmacieLigne)this.lesMedicamments.get(var1)).getPhaligTotal() < 0.0D) {
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
      if (this.pharmacieLigne.getPhaligProduit() != null && !this.pharmacieLigne.getPhaligProduit().isEmpty()) {
         this.lesProduits.clear();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProduitsMed");
         this.lesProduits = this.produitsMedicDao.verifProduitsMedicaux(this.pharmacieLigne.getPhaligProduit(), "1105", var1);
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
      }

   }

   public void valideActes() throws HibernateException, NamingException {
      if (this.produits == null) {
         this.selectionActes();
      }

      if (this.produits != null) {
         this.pharmacieLigne.setPhaligProduit(this.produits.getProCode());
         this.pharmacieLigne.setPhaligLibelle(this.produits.getProLibClient());
         this.pharmacieLigne.setPhaligDci(this.produits.getProLibTech());
         this.pharmacieLigne.setPhaligFamille(this.produits.getProVteCode() + ":" + this.produits.getProVteLib());
         this.validesActesSuite((Session)null);
      }

   }

   public void validesActesSuite(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
         var2 = true;
      }

      this.calculPrix(var1);
      this.calculDepot(var1);
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
      double var9 = this.pharmacieLigne.getPhaligPu();
      double var11 = this.pharmacieLigne.getPhaligPuCnamgs();
      double var13 = this.pharmacieLigne.getPhaligPuAssurance();
      boolean var15 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
         var15 = true;
      }

      this.produits = this.produitsMedicDao.chargeProduit(this.pharmacieLigne.getPhaligProduit(), var1);
      if (this.produits != null) {
         this.pharmacieLigne.setPhaligProduit(this.produits.getProCode());
         this.pharmacieLigne.setPhaligLibelle(this.produits.getProLibClient());
         this.pharmacieLigne.setPhaligCodeTva(this.produits.getProVteTva());
         this.pharmacieLigne.setPhaligTauxTva(0.0F);
         if (this.pharmacieLigne.getPhaligCodeTva() != null && !this.pharmacieLigne.getPhaligCodeTva().isEmpty()) {
            this.taxesMedical = this.taxesMedicalDao.selectTva(this.exercicesVentes.getExevteId(), this.pharmacieLigne.getPhaligCodeTva(), var1);
            if (this.taxesMedical != null) {
               this.pharmacieLigne.setPhaligTauxTva(this.taxesMedical.getTaxvteTaux());
            }
         }

         String var16 = this.pharmacieEntete.getLibelleFamille();
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
                     if (((ObjetCategories)this.lesCategoriesList.get(var17)).getLibelle_FR().equals(this.pharmacieEntete.getLibelleFamille())) {
                        var2 = ((ObjetCategories)this.lesCategoriesList.get(var17)).getCoef();
                        break;
                     }
                  }
               }
            }

            this.pharmacieLigne.setPhaligCoef(var2);
            if (var9 != 0.0D) {
               var3 = var9;
            }

            this.pharmacieLigne.setPhaligPu(var3);
            if (var11 != 0.0D) {
               var5 = var11;
            }

            this.pharmacieLigne.setPhaligPuCnamgs(var5);
            if (var13 != 0.0D) {
               var7 = var13;
            }

            this.pharmacieLigne.setPhaligPuAssurance(var7);
            if (this.pharmacieEntete.getPhaFam() >= 1L) {
               this.patientPec = this.patientPecDao.trouverPatientsPec(this.pharmacieEntete.getPhaFam(), 0, var1);
               if (this.patientPec != null) {
                  this.conventionMedical = this.conventionMedicalDao.trouveConvention(this.patientPec.getTiers().getTieid(), this.pharmacieLigne.getPhaligProduit(), var1);
                  if (this.conventionMedical != null) {
                     this.pharmacieLigne.setPhaligPuAssurance(this.conventionMedical.getCvnValeur());
                     if (this.conventionMedical.getCvnValeurOrigine() != 0.0D) {
                        this.pharmacieLigne.setPhaligPu(this.conventionMedical.getCvnValeurOrigine());
                     }
                  }
               }
            }
         } else {
            this.pharmacieLigne.setPhaligCoef(0.0F);
            this.pharmacieLigne.setPhaligPu(var9);
            this.pharmacieLigne.setPhaligPuCnamgs(var11);
            this.pharmacieLigne.setPhaligPuAssurance(var13);
         }
      } else {
         this.pharmacieLigne.setPhaligCoef(0.0F);
         this.pharmacieLigne.setPhaligPu(var9);
         this.pharmacieLigne.setPhaligPuCnamgs(var11);
         this.pharmacieLigne.setPhaligPuAssurance(var13);
      }

      if (this.var_pecCnamgs != 0.0F) {
         if (this.nomComplementaire != 0L) {
            this.medicammentAvecCnamgsPriveComplementaire(var1);
         } else {
            this.medicammentAvecCnamgsPrive(var1);
         }
      } else if (this.pharmacieEntete.getPhaFam() != 0L && this.pharmacieEntete.getPhaFam() != -1L) {
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
      if (this.pharmacieLigne.getPhaligRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.pharmacieLigne.getPhaligPu() * (double)this.pharmacieLigne.getPhaligRemise() / 100.0D, this.structureLog.getStrdevise());
         this.pharmacieLigne.setPhaligPuRem(this.pharmacieLigne.getPhaligPu() - var2);
         this.pharmacieLigne.setPhaligRabais(0.0D);
      } else {
         this.pharmacieLigne.setPhaligPuRem(this.pharmacieLigne.getPhaligPu());
      }

      this.pharmacieLigne.setPhaligTotal(this.pharmacieLigne.getPhaligPuRem() * (double)this.pharmacieLigne.getPhaligQte());
      if (this.pharmacieLigne.getPhaligTauxTva() != 0.0F) {
         var2 = this.pharmacieLigne.getPhaligTotal() * (double)this.pharmacieLigne.getPhaligTauxTva() / 100.0D;
         this.pharmacieLigne.setPhaligTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.pharmacieLigne.setPhaligTaxe(0.0D);
      }

      this.pharmacieLigne.setPhaligPuCnamgs(0.0D);
      this.pharmacieLigne.setPhaligSocieteHt(0.0D);
      this.pharmacieLigne.setPhaligSocieteTaxe(0.0D);
      this.pharmacieLigne.setPhaligAssuranceHt(0.0D);
      this.pharmacieLigne.setPhaligAssuranceTaxe(0.0D);
      this.pharmacieLigne.setPhaligComplementaireHt(0.0D);
      this.pharmacieLigne.setPhaligComplementaireTaxe(0.0D);
      this.pharmacieLigne.setPhaligPatientHt(0.0D);
      this.pharmacieLigne.setPhaligPatientTaxe(0.0D);
      this.pharmacieEntete.setPhaIdEmployeur(0L);
      var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      float var8 = 0.0F;
      double var9;
      if (this.pharmacieEntete.getPhaIdSociete() != 0L && this.pharmacieEntete.getPhaFam() != 0L) {
         if (this.patientPec == null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.pharmacieEntete.getPhaFam(), 0, var1);
         }

         if (this.patientPec != null) {
            var2 = this.pharmacieLigne.getPhaligTotal() * (double)this.patientPec.getPatpecMedicament() / 100.0D;
            if (this.patientPec.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.pharmacieLigne.setPhaligSocieteHt(var2);
            } else {
               this.pharmacieLigne.setPhaligSocieteHt(var2 * (double)this.patientPec.getTiers().getTiecoefpvmedical());
               var8 = this.patientPec.getTiers().getTiecoefpvmedical();
            }

            if (this.pharmacieLigne.getPhaligTauxTva() != 0.0F) {
               var9 = this.pharmacieLigne.getPhaligSocieteHt() * (double)this.pharmacieLigne.getPhaligTauxTva() / 100.0D;
               this.pharmacieLigne.setPhaligSocieteTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      } else if (this.pharmacieEntete.getPhaIdAssurance() != 0L && this.pharmacieEntete.getPhaFam() != 0L) {
         if (this.patientPec == null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.pharmacieEntete.getPhaFam(), 0, var1);
         }

         if (this.patientPec != null) {
            this.var_pecAssurance = true;
            this.pharmacieEntete.setPhaIdEmployeur(this.patientPec.getPatpecIdEmployeur());
            if (this.pharmacieLigne.getPhaligPuAssurance() == 0.0D) {
               this.pharmacieLigne.setPhaligPuAssurance(this.pharmacieLigne.getPhaligPu());
            }

            var4 = this.pharmacieLigne.getPhaligPuAssurance() * (double)this.pharmacieLigne.getPhaligQte() * (double)this.patientPec.getPatpecMedicament() / 100.0D;
            if (this.pharmacieLigne.getPhaligRemise() != 0.0F) {
               var9 = this.utilNombre.myRoundDevise(var4 * (double)this.pharmacieLigne.getPhaligRemise() / 100.0D, this.structureLog.getStrdevise());
               var4 -= var9;
            }

            if (this.patientPec.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.pharmacieLigne.setPhaligAssuranceHt(var4);
            } else {
               this.pharmacieLigne.setPhaligAssuranceHt(var4 * (double)this.patientPec.getTiers().getTiecoefpvmedical());
               var8 = this.patientPec.getTiers().getTiecoefpvmedical();
            }

            if (this.pharmacieLigne.getPhaligTauxTva() != 0.0F) {
               var9 = this.pharmacieLigne.getPhaligAssuranceHt() * (double)this.pharmacieLigne.getPhaligTauxTva() / 100.0D;
               this.pharmacieLigne.setPhaligAssuranceTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      }

      if (this.pharmacieEntete.getPhaIdComplementaire() != 0L) {
         if (this.patientPecComplementaire == null) {
            this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.pharmacieEntete.getPhaComplementaire(), 0, var1);
         }

         if (this.patientPecComplementaire != null) {
            var6 = this.pharmacieLigne.getPhaligPu() * (double)this.pharmacieLigne.getPhaligQte() * (double)this.patientPecComplementaire.getPatpecMedicament() / 100.0D;
            if (this.pharmacieLigne.getPhaligRemise() != 0.0F) {
               var9 = this.utilNombre.myRoundDevise(var6 * (double)this.pharmacieLigne.getPhaligRemise() / 100.0D, this.structureLog.getStrdevise());
               var6 -= var9;
            }

            if (this.patientPecComplementaire.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.pharmacieLigne.setPhaligComplementaireHt(var6);
            } else {
               this.pharmacieLigne.setPhaligComplementaireHt(var6 * (double)this.patientPecComplementaire.getTiers().getTiecoefpvmedical());
            }

            if (this.pharmacieLigne.getPhaligTauxTva() != 0.0F) {
               var9 = this.pharmacieLigne.getPhaligComplementaireHt() * (double)this.pharmacieLigne.getPhaligTauxTva() / 100.0D;
               this.pharmacieLigne.setPhaligComplementaireTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      }

      var9 = 0.0D;
      var8 = 0.0F;
      double var11;
      if (var8 != 0.0F && this.produits.getProMajoration() == 0 && this.optionMedical.getCoefMajoration().equals("2")) {
         if (this.pharmacieLigne.getPhaligRemise() != 0.0F) {
            var11 = this.utilNombre.myRoundDevise(this.pharmacieLigne.getPhaligPu() * (double)this.pharmacieLigne.getPhaligRemise() / 100.0D, this.structureLog.getStrdevise());
            this.pharmacieLigne.setPhaligPuRem((this.pharmacieLigne.getPhaligPu() - var11) * (double)var8);
         } else {
            this.pharmacieLigne.setPhaligPuRem(this.pharmacieLigne.getPhaligPu() * (double)var8);
         }

         this.pharmacieLigne.setPhaligTotal(this.pharmacieLigne.getPhaligPuRem() * (double)this.pharmacieLigne.getPhaligQte());
         if (this.pharmacieLigne.getPhaligTauxTva() != 0.0F) {
            var11 = this.pharmacieLigne.getPhaligTotal() * (double)this.pharmacieLigne.getPhaligTauxTva() / 100.0D;
            this.pharmacieLigne.setPhaligTaxe(this.utilNombre.myRoundDevise(var11, this.structureLog.getStrdevise()));
         } else {
            this.pharmacieLigne.setPhaligTaxe(0.0D);
         }
      } else {
         var9 = this.pharmacieLigne.getPhaligTotal() - (var2 + var4 + var6);
         this.pharmacieLigne.setPhaligTotal(this.pharmacieLigne.getPhaligSocieteHt() + this.pharmacieLigne.getPhaligAssuranceHt() + this.pharmacieLigne.getPhaligComplementaireHt() + var9);
      }

      var11 = this.pharmacieLigne.getPhaligTotal() - (this.pharmacieLigne.getPhaligSocieteHt() + this.pharmacieLigne.getPhaligAssuranceHt() + this.pharmacieLigne.getPhaligComplementaireHt());
      if (this.pharmacieLigne.getPhaligRabais() != 0.0D) {
         this.pharmacieLigne.setPhaligPatientHt(var11 - this.pharmacieLigne.getPhaligRabais());
         this.pharmacieLigne.setPhaligRemise(0.0F);
         if (this.pharmacieLigne.getPhaligPatientHt() < 0.0D) {
            this.pharmacieLigne.setPhaligPatientHt(var11);
            this.pharmacieLigne.setPhaligRabais(0.0D);
         }
      } else {
         this.pharmacieLigne.setPhaligPatientHt(var11);
      }

      double var13;
      if (this.pharmacieLigne.getPhaligTauxTva() != 0.0F) {
         var13 = this.pharmacieLigne.getPhaligPatientHt() * (double)this.pharmacieLigne.getPhaligTauxTva() / 100.0D;
         this.pharmacieLigne.setPhaligPatientTaxe(this.utilNombre.myRoundDevise(var13, this.structureLog.getStrdevise()));
      }

      if (var8 != 0.0F && this.produits.getProMajoration() == 0 && this.optionMedical.getCoefMajoration().equals("3")) {
         if (this.pharmacieLigne.getPhaligRemise() != 0.0F) {
            var13 = this.utilNombre.myRoundDevise(this.pharmacieLigne.getPhaligPu() * (double)this.pharmacieLigne.getPhaligRemise() / 100.0D, this.structureLog.getStrdevise());
            this.pharmacieLigne.setPhaligPuRem((this.pharmacieLigne.getPhaligPu() - var13) * (double)var8);
         } else {
            this.pharmacieLigne.setPhaligPuRem(this.pharmacieLigne.getPhaligPu() * (double)var8);
         }

         this.pharmacieLigne.setPhaligTotal(this.pharmacieLigne.getPhaligPuRem() * (double)this.pharmacieLigne.getPhaligQte());
         var13 = this.pharmacieLigne.getPhaligAssuranceHt() + this.pharmacieLigne.getPhaligComplementaireHt() + this.pharmacieLigne.getPhaligSocieteHt() + this.pharmacieLigne.getPhaligPatientHt();
         double var15 = this.pharmacieLigne.getPhaligTotal() - var13;
         if (var15 != 0.0D) {
            if (var4 != 0.0D) {
               this.pharmacieLigne.setPhaligAssuranceHt(this.pharmacieLigne.getPhaligAssuranceHt() + var15);
            } else if (var2 != 0.0D) {
               this.pharmacieLigne.setPhaligSocieteHt(this.pharmacieLigne.getPhaligSocieteHt() + var15);
            }

            if (var6 != 0.0D) {
               this.pharmacieLigne.setPhaligComplementaireHt(this.pharmacieLigne.getPhaligComplementaireHt() + var15);
            }
         }
      }

   }

   public void medicammentSansCnamgsPrive(Session var1) {
      if (this.tauxCasSocial != 0.0F) {
         this.pharmacieLigne.setPhaligRemise(this.tauxCasSocial);
      }

      double var2;
      if (this.pharmacieLigne.getPhaligRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.pharmacieLigne.getPhaligPu() * (double)this.pharmacieLigne.getPhaligRemise() / 100.0D, this.structureLog.getStrdevise());
         this.pharmacieLigne.setPhaligPuRem(this.pharmacieLigne.getPhaligPu() - var2);
         this.pharmacieLigne.setPhaligRabais(0.0D);
      } else {
         this.pharmacieLigne.setPhaligPuRem(this.pharmacieLigne.getPhaligPu());
      }

      this.pharmacieLigne.setPhaligTotal(this.pharmacieLigne.getPhaligPuRem() * (double)this.pharmacieLigne.getPhaligQte());
      if (this.pharmacieLigne.getPhaligTauxTva() != 0.0F) {
         var2 = this.pharmacieLigne.getPhaligTotal() * (double)this.pharmacieLigne.getPhaligTauxTva() / 100.0D;
         this.pharmacieLigne.setPhaligTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.pharmacieLigne.setPhaligTaxe(0.0D);
      }

      this.pharmacieLigne.setPhaligPuCnamgs(0.0D);
      this.pharmacieLigne.setPhaligSocieteHt(0.0D);
      this.pharmacieLigne.setPhaligSocieteTaxe(0.0D);
      this.pharmacieLigne.setPhaligAssuranceHt(0.0D);
      this.pharmacieLigne.setPhaligAssuranceTaxe(0.0D);
      this.pharmacieLigne.setPhaligComplementaireHt(0.0D);
      this.pharmacieLigne.setPhaligComplementaireTaxe(0.0D);
      this.pharmacieLigne.setPhaligPatientHt(0.0D);
      this.pharmacieLigne.setPhaligPatientTaxe(0.0D);
      this.pharmacieEntete.setPhaIdEmployeur(0L);
      var2 = this.pharmacieLigne.getPhaligTotal();
      if (this.pharmacieLigne.getPhaligRabais() != 0.0D) {
         this.pharmacieLigne.setPhaligPatientHt(var2 - this.pharmacieLigne.getPhaligRabais());
         this.pharmacieLigne.setPhaligRemise(0.0F);
         if (this.pharmacieLigne.getPhaligPatientHt() < 0.0D) {
            this.pharmacieLigne.setPhaligPatientHt(var2);
            this.pharmacieLigne.setPhaligRabais(0.0D);
         }
      } else {
         this.pharmacieLigne.setPhaligPatientHt(var2);
      }

      if (this.pharmacieLigne.getPhaligTaxe() != 0.0D) {
         double var4 = this.pharmacieLigne.getPhaligPatientHt() * (double)this.pharmacieLigne.getPhaligTauxTva() / 100.0D;
         this.pharmacieLigne.setPhaligPatientTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
      } else {
         this.pharmacieLigne.setPhaligPatientTaxe(0.0D);
      }

   }

   public void medicammentAvecCnamgsPrive(Session var1) throws HibernateException, NamingException {
      if (this.pharmacieLigne.getPhaligPuCnamgs() > this.pharmacieLigne.getPhaligPu()) {
         this.pharmacieLigne.setPhaligPu(this.pharmacieLigne.getPhaligPuCnamgs());
      }

      double var2;
      double var4;
      if (this.pharmacieLigne.getPhaligRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.pharmacieLigne.getPhaligPu() * (double)this.pharmacieLigne.getPhaligRemise() / 100.0D, this.structureLog.getStrdevise());
         this.pharmacieLigne.setPhaligPuRem(this.pharmacieLigne.getPhaligPu() - var2);
         var4 = this.utilNombre.myRoundDevise(this.pharmacieLigne.getPhaligPuCnamgs() * (double)this.pharmacieLigne.getPhaligRemise() / 100.0D, this.structureLog.getStrdevise());
         this.pharmacieLigne.setPhaligPuCnamgs(this.pharmacieLigne.getPhaligPuCnamgs() - var4);
         this.pharmacieLigne.setPhaligRabais(0.0D);
      } else {
         this.pharmacieLigne.setPhaligPuRem(this.pharmacieLigne.getPhaligPu());
      }

      this.pharmacieLigne.setPhaligTotal(this.pharmacieLigne.getPhaligPuRem() * (double)this.pharmacieLigne.getPhaligQte());
      if (this.pharmacieLigne.getPhaligTauxTva() != 0.0F) {
         var2 = this.pharmacieLigne.getPhaligTotal() * (double)this.pharmacieLigne.getPhaligTauxTva() / 100.0D;
         this.pharmacieLigne.setPhaligTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.pharmacieLigne.setPhaligTaxe(0.0D);
      }

      this.pharmacieLigne.setPhaligPuAssurance(0.0D);
      this.pharmacieLigne.setPhaligSocieteHt(0.0D);
      this.pharmacieLigne.setPhaligSocieteTaxe(0.0D);
      this.pharmacieLigne.setPhaligAssuranceHt(0.0D);
      this.pharmacieLigne.setPhaligAssuranceTaxe(0.0D);
      this.pharmacieLigne.setPhaligComplementaireHt(0.0D);
      this.pharmacieLigne.setPhaligComplementaireTaxe(0.0D);
      this.pharmacieLigne.setPhaligPatientHt(0.0D);
      this.pharmacieLigne.setPhaligPatientTaxe(0.0D);
      this.pharmacieEntete.setPhaIdEmployeur(0L);
      this.pharmacieLigne.setPhaligAssuranceHt(this.pharmacieLigne.getPhaligPuCnamgs() * (double)this.pharmacieLigne.getPhaligQte() * (double)this.var_pecCnamgs / 100.0D);
      if (this.pharmacieLigne.getPhaligTauxTva() != 0.0F) {
         var2 = this.pharmacieLigne.getPhaligAssuranceHt() * (double)this.pharmacieLigne.getPhaligTauxTva() / 100.0D;
         this.pharmacieLigne.setPhaligAssuranceTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      }

      var2 = this.pharmacieLigne.getPhaligTotal() - this.pharmacieLigne.getPhaligAssuranceHt();
      if (this.pharmacieLigne.getPhaligRabais() != 0.0D) {
         this.pharmacieLigne.setPhaligPatientHt(var2 - this.pharmacieLigne.getPhaligRabais());
         this.pharmacieLigne.setPhaligRemise(0.0F);
         if (this.pharmacieLigne.getPhaligPatientHt() < 0.0D) {
            this.pharmacieLigne.setPhaligPatientHt(var2);
            this.pharmacieLigne.setPhaligRabais(0.0D);
         }
      } else {
         this.pharmacieLigne.setPhaligPatientHt(var2);
      }

      if (this.pharmacieLigne.getPhaligTauxTva() != 0.0F) {
         var4 = this.pharmacieLigne.getPhaligPatientHt() * (double)this.pharmacieLigne.getPhaligTauxTva() / 100.0D;
         this.pharmacieLigne.setPhaligPatientTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
      }

   }

   public void medicammentAvecCnamgsPriveComplementaire(Session var1) throws HibernateException, NamingException {
      if (this.pharmacieLigne.getPhaligPuCnamgs() > this.pharmacieLigne.getPhaligPu()) {
         this.pharmacieLigne.setPhaligPu(this.pharmacieLigne.getPhaligPuCnamgs());
      }

      double var2;
      double var4;
      if (this.pharmacieLigne.getPhaligRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.pharmacieLigne.getPhaligPu() * (double)this.pharmacieLigne.getPhaligRemise() / 100.0D, this.structureLog.getStrdevise());
         this.pharmacieLigne.setPhaligPuRem(this.pharmacieLigne.getPhaligPu() - var2);
         var4 = this.utilNombre.myRoundDevise(this.pharmacieLigne.getPhaligPuCnamgs() * (double)this.pharmacieLigne.getPhaligRemise() / 100.0D, this.structureLog.getStrdevise());
         this.pharmacieLigne.setPhaligPuCnamgs(this.pharmacieLigne.getPhaligPuCnamgs() - var4);
         this.pharmacieLigne.setPhaligRabais(0.0D);
      } else {
         this.pharmacieLigne.setPhaligPuRem(this.pharmacieLigne.getPhaligPu());
      }

      this.pharmacieLigne.setPhaligTotal(this.pharmacieLigne.getPhaligPuRem() * (double)this.pharmacieLigne.getPhaligQte());
      if (this.pharmacieLigne.getPhaligTauxTva() != 0.0F) {
         var2 = this.pharmacieLigne.getPhaligTotal() * (double)this.pharmacieLigne.getPhaligTauxTva() / 100.0D;
         this.pharmacieLigne.setPhaligTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.pharmacieLigne.setPhaligTaxe(0.0D);
      }

      this.pharmacieLigne.setPhaligPuAssurance(0.0D);
      this.pharmacieLigne.setPhaligSocieteHt(0.0D);
      this.pharmacieLigne.setPhaligSocieteTaxe(0.0D);
      this.pharmacieLigne.setPhaligAssuranceHt(0.0D);
      this.pharmacieLigne.setPhaligAssuranceTaxe(0.0D);
      this.pharmacieLigne.setPhaligComplementaireHt(0.0D);
      this.pharmacieLigne.setPhaligComplementaireTaxe(0.0D);
      this.pharmacieLigne.setPhaligPatientHt(0.0D);
      this.pharmacieLigne.setPhaligPatientTaxe(0.0D);
      this.pharmacieEntete.setPhaIdEmployeur(0L);
      var2 = 0.0D;
      this.pharmacieLigne.setPhaligAssuranceHt(this.pharmacieLigne.getPhaligPuCnamgs() * (double)this.pharmacieLigne.getPhaligQte() * (double)this.var_pecCnamgs / 100.0D);
      if (this.pharmacieLigne.getPhaligTauxTva() != 0.0F) {
         var4 = this.pharmacieLigne.getPhaligAssuranceHt() * (double)this.pharmacieLigne.getPhaligTauxTva() / 100.0D;
         this.pharmacieLigne.setPhaligAssuranceTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
      }

      this.pharmacieEntete.setPhaComplementaire(this.nomComplementaire);
      if (this.pharmacieEntete.getPhaComplementaire() != 0L) {
         if (this.patientPecComplementaire == null) {
            this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.pharmacieEntete.getPhaComplementaire(), 0, var1);
         }

         if (this.patientPecComplementaire != null) {
            this.pharmacieEntete.setPhaIdComplementaire(this.patientPecComplementaire.getTiers().getTieid());
            var2 = this.pharmacieLigne.getPhaligTotal() - this.pharmacieLigne.getPhaligAssuranceHt();
            this.pharmacieLigne.setPhaligComplementaireHt(var2);
            if (this.pharmacieLigne.getPhaligTauxTva() != 0.0F) {
               var4 = this.pharmacieLigne.getPhaligComplementaireHt() * (double)this.pharmacieLigne.getPhaligTauxTva() / 100.0D;
               this.pharmacieLigne.setPhaligComplementaireTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
            }
         }
      }

      var4 = this.pharmacieLigne.getPhaligTotal() - this.pharmacieLigne.getPhaligAssuranceHt() - this.pharmacieLigne.getPhaligComplementaireHt();
      if (this.pharmacieLigne.getPhaligRabais() != 0.0D) {
         this.pharmacieLigne.setPhaligPatientHt(var4 - this.pharmacieLigne.getPhaligRabais());
         this.pharmacieLigne.setPhaligRemise(0.0F);
         if (this.pharmacieLigne.getPhaligPatientHt() < 0.0D) {
            this.pharmacieLigne.setPhaligPatientHt(var4);
            this.pharmacieLigne.setPhaligRabais(0.0D);
         }
      } else {
         this.pharmacieLigne.setPhaligPatientHt(var4);
      }

      if (this.pharmacieLigne.getPhaligTauxTva() != 0.0F) {
         double var6 = this.pharmacieLigne.getPhaligPatientHt() * (double)this.pharmacieLigne.getPhaligTauxTva() / 100.0D;
         this.pharmacieLigne.setPhaligPatientTaxe(this.utilNombre.myRoundDevise(var6, this.structureLog.getStrdevise()));
      }

   }

   public void selectionActeListe() throws HibernateException, NamingException {
      this.var_aff_detail_prod = false;
      if (this.dataModelPharmacie.isRowAvailable()) {
         this.pharmacieLigne = (PharmacieLigne)this.dataModelPharmacie.getRowData();
         this.var_memo_qte = this.pharmacieLigne.getPhaligQte();
         this.var_aff_detail_prod = true;
         this.afficheButtActes = true;
      }

   }

   public void annuleActes() {
      this.produits = null;
      this.pharmacieLigne = new PharmacieLigne();
      this.var_aff_detail_prod = false;
      this.afficheButtActes = false;
      this.showModalPanelProduits = false;
   }

   public void supprimerActe() throws HibernateException, NamingException {
      if (this.pharmacieLigne != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.pharmacieLigneDao.delete(this.pharmacieLigne, var1);
            this.lesMedicamments.remove(this.pharmacieLigne);
            this.dataModelPharmacie.setWrappedData(this.lesMedicamments);
            this.calculTotaux();
            this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
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

   public void validesProduit() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
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

      this.pharmacieLigne.setPhaligProduit(this.produits.getProCode());
      this.pharmacieLigne.setPhaligLibelle(this.produits.getProLibClient());
      this.pharmacieLigne.setPhaligDci(this.produits.getProLibTech());
      this.pharmacieLigne.setPhaligFamille(this.produits.getProVteCode() + ":" + this.produits.getProVteLib());
      this.validesActesSuite((Session)null);
   }

   public void detailActe() {
      this.showModalPanelDetailProduits = true;
   }

   public void fermerDetailActe() {
      this.showModalPanelDetailProduits = false;
   }

   public void saveActe() throws HibernateException, NamingException, ParseException {
      if (this.pharmacieLigne.getPhaligQte() != 0.0F) {
         if (this.pharmacieEntete.getPhaId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.pharmacieLigne != null) {
               this.tarifPatient(var1);
               this.calculPrix(var1);
               if (this.var_depotProd != null && this.var_depotProd.contains("=")) {
                  String[] var3;
                  if (this.var_depotProd.contains(":")) {
                     var3 = this.var_depotProd.split(":");
                     this.pharmacieLigne.setPhaligDepot(var3[0]);
                  } else {
                     var3 = this.var_depotProd.split("=");
                     this.pharmacieLigne.setPhaligDepot(var3[0]);
                  }

                  this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.pharmacieLigne.getPhaligProduit(), this.pharmacieLigne.getPhaligDepot(), var1);
                  if (this.produitsDepot != null) {
                     this.pharmacieLigne.setPhaligPump(this.produitsDepot.getProdepPump());
                  } else {
                     this.pharmacieLigne.setPhaligPump(0.0D);
                  }
               } else {
                  this.pharmacieLigne.setPhaligDepot("");
                  this.pharmacieLigne.setPhaligPump(0.0D);
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
               } else {
                  this.pharmacieLigne.setPhaligDescription("");
               }

               if (this.pharmacieLigne.getPhaligId() == 0L) {
                  this.pharmacieLigne.setPharmacieEntete(this.pharmacieEntete);
                  this.pharmacieLigne = this.pharmacieLigneDao.insert(this.pharmacieLigne, var1);
                  this.lesMedicamments.add(this.pharmacieLigne);
                  this.dataModelPharmacie.setWrappedData(this.lesMedicamments);
               } else {
                  this.pharmacieLigne = this.pharmacieLigneDao.modif(this.pharmacieLigne, var1);
               }

               this.calculTotaux();
               this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
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

      this.ajouterActes();
      this.calculTotaux();
   }

   public void changerTarif() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.tarifPatient(var1);
         if (this.pharmacieEntete.getPhaId() != 0L) {
            this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
            if (this.lesMedicamments.size() != 0) {
               for(int var3 = 0; var3 < this.lesMedicamments.size(); ++var3) {
                  this.pharmacieLigne = (PharmacieLigne)this.lesMedicamments.get(var3);
                  this.calculPrix(var1);
                  this.pharmacieLigne = this.pharmacieLigneDao.modif(this.pharmacieLigne, var1);
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
      this.pharmacieEntete.setPhaFam(this.nomFamille);
      this.pharmacieEntete.setPhaComplementaire(this.nomComplementaire);
      if (this.nomFamille >= 1L) {
         this.var_pecCnamgs = 0.0F;
         this.pharmacieEntete.setPhaIdSociete(0L);
         this.pharmacieEntete.setPhaIdAssurance(0L);
         this.pharmacieEntete.setPhaIdComplementaire(0L);
         this.pharmacieEntete.setPhaNomSociete("");
         this.pharmacieEntete.setPhaNomAssurance("");
         this.pharmacieEntete.setPhaNomComplemtaire("");
         this.pharmacieEntete.setPhaIdEmployeur(0L);
         this.pharmacieEntete.setPhaMatricule("");
         this.pharmacieEntete.setPhaContratAssurance("");
         this.pharmacieEntete.setPhaContratComplementaire("");
         if (this.patientPec == null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.pharmacieEntete.getPhaFam(), 0, var1);
         }

         if (this.patientPec != null) {
            if (this.patientPec.getPatpecType() != null && !this.patientPec.getPatpecType().isEmpty()) {
               if (!this.patientPec.getPatpecType().equals("Assurance") && !this.patientPec.getPatpecType().equals("IPM") && !this.patientPec.getPatpecType().equals("Programme Médical")) {
                  this.pharmacieEntete.setPhaIdSociete(this.patientPec.getTiers().getTieid());
                  this.pharmacieEntete.setPhaNomSociete(this.patientPec.getTiers().getTieraisonsocialenom());
                  this.pharmacieEntete.setPhaMatricule(this.patientPec.getPatpecMatricule());
               } else {
                  this.var_pecAssurance = true;
                  this.pharmacieEntete.setPhaIdAssurance(this.patientPec.getTiers().getTieid());
                  this.pharmacieEntete.setPhaNomAssurance(this.patientPec.getTiers().getTieraisonsocialenom());
                  this.pharmacieEntete.setPhaIdEmployeur(this.patientPec.getPatpecIdEmployeur());
                  this.pharmacieEntete.setPhaContratAssurance(this.patientPec.getPatpecNumContrat());
               }
            }
         } else {
            this.pharmacieEntete.setPhaFam(0L);
         }

         if (this.nomComplementaire >= 1L) {
            if (this.patientPecComplementaire == null) {
               this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.nomComplementaire, 0, var1);
            }

            if (this.patientPecComplementaire != null) {
               if (this.patientPecComplementaire.getPatpecType() != null && !this.patientPecComplementaire.getPatpecType().isEmpty() && (this.patientPecComplementaire.getPatpecType().equals("Mutuelle") || this.patientPecComplementaire.getPatpecType().equals("Complémentaire"))) {
                  this.pharmacieEntete.setPhaIdComplementaire(this.patientPecComplementaire.getTiers().getTieid());
                  this.pharmacieEntete.setPhaNomComplemtaire(this.patientPecComplementaire.getTiers().getTieraisonsocialenom());
                  this.pharmacieEntete.setPhaContratComplementaire(this.patientPecComplementaire.getPatpecNumContrat());
               }
            } else {
               this.pharmacieEntete.setPhaComplementaire(0L);
            }
         }
      } else if (this.nomFamille <= 0L) {
         this.pharmacieEntete.setPhaComplementaire(0L);
         this.pharmacieEntete.setPhaIdSociete(0L);
         this.pharmacieEntete.setPhaIdAssurance(0L);
         this.pharmacieEntete.setPhaIdComplementaire(0L);
         this.pharmacieEntete.setPhaNomSociete("");
         this.pharmacieEntete.setPhaNomAssurance("");
         this.pharmacieEntete.setPhaNomComplemtaire("");
         this.pharmacieEntete.setPhaIdEmployeur(0L);
         this.pharmacieEntete.setPhaMatricule("");
         this.pharmacieEntete.setPhaContratAssurance("");
         this.pharmacieEntete.setPhaContratComplementaire("");
      }

   }

   public void calculDepot(Session var1) throws HibernateException, NamingException {
      this.mesProduitsDepotsItems.clear();
      this.listeProduitDepot.clear();
      if (this.var_sansstock && this.produits.getProStock() != 0) {
         String var2 = this.pharmacieLigne.getPhaligCondition();
         if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
            if (var2.contains("/")) {
               String[] var3 = var2.split("/");
               String var4 = var3[1];
               String[] var5 = var4.split(":");
               this.unite = this.uniteDao.selectUnite(var5[1], var1);
               if (this.unite != null) {
                  this.pharmacieLigne.setPhaligEchelle(this.unite.getUniEchelle());
               } else {
                  this.pharmacieLigne.setPhaligEchelle(this.produitsDepot.getProdepEchelle());
               }
            } else {
               this.pharmacieLigne.setPhaligEchelle(this.produitsDepot.getProdepEchelle());
            }
         } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
            this.pharmacieLigne.setPhaligEchelle(Integer.parseInt(var2));
         } else {
            this.pharmacieLigne.setPhaligEchelle(0);
         }

         new ArrayList();
         List var9 = this.produitsDepotDao.selectProdDepByprod(this.produits, this.nature, var1);
         int var10;
         if (var9.size() != 0) {
            if (this.pharmacieEntete.getPhaPharmacie() != null && !this.pharmacieEntete.getPhaPharmacie().isEmpty()) {
               for(var10 = 0; var10 < var9.size(); ++var10) {
                  if (((ProduitsDepot)var9.get(var10)).getDepot().getDpoService() != null && !((ProduitsDepot)var9.get(var10)).getDepot().getDpoService().isEmpty()) {
                     if (this.controlePresenceDepot(((ProduitsDepot)var9.get(var10)).getDepot().getDpoService())) {
                        this.listeProduitDepot.add(var9.get(var10));
                     }
                  } else if (((ProduitsDepot)var9.get(var10)).getDepot().getDpoService() == null || ((ProduitsDepot)var9.get(var10)).getDepot().getDpoService().isEmpty()) {
                     this.listeProduitDepot.add(var9.get(var10));
                  }
               }
            } else {
               this.listeProduitDepot = var9;
            }
         }

         if (this.listeProduitDepot.size() != 0) {
            for(var10 = 0; var10 < this.listeProduitDepot.size(); ++var10) {
               ProduitsDepot var11 = (ProduitsDepot)this.listeProduitDepot.get(var10);
               float var6 = var11.getProdepQteStk() - var11.getProdepQteAttVte();
               String var7 = "";
               int var8;
               if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
                  var6 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, this.baseLog, var1);
                  var8 = (int)var6;
                  var7 = "" + var8;
               } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
                  var6 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, this.baseLog, var1);
                  var8 = (int)var6;
                  var7 = "" + var8;
               } else {
                  var7 = "" + var6;
               }

               if (var11.getProdepCasier() != null && !var11.getProdepCasier().isEmpty()) {
                  this.mesProduitsDepotsItems.add(new SelectItem(var11.getDepot().getDpoCode() + ":" + var11.getProdepCasier() + "=" + var7));
               } else {
                  this.mesProduitsDepotsItems.add(new SelectItem(var11.getDepot().getDpoCode() + "=" + var7));
               }
            }
         }
      }

   }

   public boolean controlePresenceDepot(String var1) {
      boolean var2 = false;
      if (var1 != null && !var1.isEmpty() && this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty()) {
         String[] var3 = this.usersLog.getUsrService().split(":");
         if (var1.contains(",")) {
            String[] var4 = var1.split(",");
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               String var7 = var4[var6];
               if (var7.equals(var3[0])) {
                  var2 = true;
                  break;
               }
            }
         } else if (var1.equals(var3[0])) {
            var2 = true;
         }
      }

      return var2;
   }

   public void avoirLigne() throws HibernateException, NamingException, ParseException {
      if (this.pharmacieLigne != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            PharmacieLigne var3 = new PharmacieLigne();
            var3.setPharmacieEntete(this.pharmacieEntete);
            var3.setPhaligAssuranceHt(this.pharmacieLigne.getPhaligAssuranceHt() * -1.0D);
            var3.setPhaligAssuranceTaxe(this.pharmacieLigne.getPhaligAssuranceTaxe() * -1.0D);
            var3.setPhaligCodeTva(this.pharmacieLigne.getPhaligCodeTva());
            var3.setPhaligCoef(this.pharmacieLigne.getPhaligCoef());
            var3.setPhaligComplementaireHt(this.pharmacieLigne.getPhaligComplementaireHt() * -1.0D);
            var3.setPhaligComplementaireTaxe(this.pharmacieLigne.getPhaligComplementaireTaxe() * -1.0D);
            var3.setPhaligCondition(this.pharmacieLigne.getPhaligCondition());
            var3.setPhaligDci(this.pharmacieLigne.getPhaligDci());
            var3.setPhaligDepot(this.pharmacieLigne.getPhaligDepot());
            var3.setPhaligDescription(this.pharmacieLigne.getPhaligDescription());
            var3.setPhaligEchelle(this.pharmacieLigne.getPhaligEchelle());
            var3.setPhaligFamille(this.pharmacieLigne.getPhaligFamille());
            var3.setPhaligLibelle(this.pharmacieLigne.getPhaligLibelle());
            var3.setPhaligPatientHt(this.pharmacieLigne.getPhaligPatientHt() * -1.0D);
            var3.setPhaligPatientTaxe(this.pharmacieLigne.getPhaligPatientTaxe() * -1.0D);
            var3.setPhaligProduit(this.pharmacieLigne.getPhaligProduit());
            var3.setPhaligPu(this.pharmacieLigne.getPhaligPu());
            var3.setPhaligPuAssurance(this.pharmacieLigne.getPhaligPuAssurance());
            var3.setPhaligPuCnamgs(this.pharmacieLigne.getPhaligPuCnamgs());
            var3.setPhaligPuRem(this.pharmacieLigne.getPhaligPuRem());
            var3.setPhaligPump(this.pharmacieLigne.getPhaligPump());
            var3.setPhaligQte(this.pharmacieLigne.getPhaligQte() * -1.0F);
            var3.setPhaligQteUtil(this.pharmacieLigne.getPhaligQteUtil() * -1.0F);
            var3.setPhaligRegPatient(0.0D);
            var3.setPhaligRegTiers(0.0D);
            var3.setPhaligRemise(this.pharmacieLigne.getPhaligRemise());
            var3.setPhaligSocieteHt(this.pharmacieLigne.getPhaligSocieteHt() * -1.0D);
            var3.setPhaligSocieteTaxe(this.pharmacieLigne.getPhaligSocieteTaxe() * -1.0D);
            var3.setPhaligStock(this.pharmacieLigne.getPhaligStock());
            var3.setPhaligTauxTva(this.pharmacieLigne.getPhaligTauxTva());
            var3.setPhaligTaxe(this.pharmacieLigne.getPhaligTaxe() * -1.0D);
            var3.setPhaligTotal(this.pharmacieLigne.getPhaligTotal() * -1.0D);
            var3.setPhaligUnite(this.pharmacieLigne.getPhaligUnite());
            this.pharmacieLigne = new PharmacieLigne();
            this.pharmacieLigne = var3;
            this.pharmacieLigne = this.pharmacieLigneDao.insert(this.pharmacieLigne, var1);
            this.lesMedicamments.add(this.pharmacieLigne);
            this.dataModelPharmacie.setWrappedData(this.lesMedicamments);
            this.calculTotaux();
            this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
            double var4 = this.pharmacieLigne.getPhaligPatientHt() + this.pharmacieLigne.getPhaligPatientTaxe();
            if (var4 != 0.0D) {
               boolean var6 = false;
               if (this.usersChrono.getUsrchrValidation() == 4) {
                  if (this.usersLog.getUsrFactureCaisse() == 1) {
                     var6 = this.majBonencaissementAnnulation(Math.abs(var4), this.pharmacieEntete.getPhaDate(), var1);
                  } else if (this.usersLog.getUsrFactureCaisse() == 2) {
                     var6 = this.majReglementAnnulation(Math.abs(var4), this.pharmacieEntete.getPhaDate(), var1);
                  } else if (this.usersLog.getUsrFactureCaisse() == 3) {
                     var6 = this.majBonencaissementAnnulation(Math.abs(var4), this.pharmacieEntete.getPhaDate(), var1);
                  }
               }

               if (!var6) {
                  this.pharmacieLigneDao.delete(this.pharmacieLigne, var1);
                  this.lesMedicamments.add(this.pharmacieLigne);
                  this.dataModelPharmacie.setWrappedData(this.lesMedicamments);
                  this.calculTotaux();
                  this.pharmacieEntete = this.pharmacieEnteteDao.selectById(this.pharmacieEntete.getPhaId(), var1);
                  if (this.pharmacieEntete != null) {
                     this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
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
      if (this.pharmacieEntete != null) {
         this.tarifPatient((Session)null);
         if (this.pharmacieEntete.getPhaIdSociete() != 0L) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.patients, this.pharmacieEntete.getPhaIdSociete(), (Session)null);
            if (this.patientPec != null) {
               this.showModalpanelPec = true;
            }
         } else if (this.pharmacieEntete.getPhaIdAssurance() != 0L) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.patients, this.pharmacieEntete.getPhaIdAssurance(), (Session)null);
            if (this.patientPec != null) {
               if (this.pharmacieEntete.getPhaIdComplementaire() != 0L) {
                  this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.patients, this.pharmacieEntete.getPhaIdComplementaire(), (Session)null);
               }

               this.showModalpanelPec = true;
            }
         }
      }

   }

   public void fermerConsulterTarif() {
      this.showModalpanelPec = false;
   }

   public void selectionTracabilite() {
      if (this.datamodelDocumentTrace.isRowAvailable()) {
      }

   }

   public void payeDocumentBonEncaissement() throws HibernateException, NamingException {
      if (this.pharmacieEntete != null) {
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
         if (this.var_tot_bon_encaissement > this.pharmacieEntete.getPhaTotTaxePatient() + this.pharmacieEntete.getPhaTotPatient()) {
            this.pharmacieEntete.setPhaTypeReg(4);
            this.var_verouxModReg = true;
            this.var_affichMontant = false;
            this.var_netAPayer = this.pharmacieEntete.getPhaTotTaxePatient() + this.pharmacieEntete.getPhaTotPatient() - this.var_tot_bon_encaissement;
            this.montantElmTotBonEnc = this.var_netAPayer;
            this.verifBonEncaissement();
         } else {
            if (this.pharmacieEntete.getPhaTypeReg() == 5) {
               this.montantElmTotBonEnc = this.var_tot_bon_encaissement;
               if (this.pharmacieEntete.getPhaEtat() == 1) {
                  this.var_verouxModReg = true;
               } else {
                  this.var_verouxModReg = false;
               }

               this.var_netAPayer = this.pharmacieEntete.getPhaTotTaxePatient() + this.pharmacieEntete.getPhaTotPatient() - this.var_tot_bon_encaissement;
               this.montantElmTotBonEnc = this.var_netAPayer;
               this.var_affiche_valide = true;
            } else {
               this.pharmacieEntete.setPhaTypeReg(0);
               this.var_verouxModReg = false;
               this.var_netAPayer = this.pharmacieEntete.getPhaTotTaxePatient() + this.pharmacieEntete.getPhaTotPatient() - this.var_tot_bon_encaissement;
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
      if (this.montantElmTotBonEnc <= this.pharmacieEntete.getPhaTotTaxePatient() + this.pharmacieEntete.getPhaTotPatient() - this.var_tot_bon_encaissement) {
         this.var_affiche_valide = true;
      } else {
         this.var_affiche_valide = false;
      }

   }

   public void calculeCaisseDisponibleBencaissement() throws HibernateException, NamingException {
      this.mesCaissesSeriesItems.clear();
      if (this.listCaisses.size() != 0) {
         for(int var1 = 0; var1 < this.listCaisses.size(); ++var1) {
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 60 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.pharmacieEntete.getPhaSerie())) {
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

      if (this.varTypeReg == 0 || this.varTypeReg == 11) {
         this.var_affiche_lettre = false;
         this.var_affiche_banque = false;
      }

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
      if (this.pharmacieEntete.getPhaTypeReg() != 4 && this.pharmacieEntete.getPhaTypeReg() != 5) {
         this.montantElmTotBonEnc = this.var_netAPayer;
         this.var_affichMontant = true;
      } else {
         this.var_affichMontant = false;
      }

   }

   public void miseajourPaye() throws HibernateException, NamingException {
      if (this.var_tot_bon_encaissement <= this.pharmacieEntete.getPhaTotTaxePatient() + this.pharmacieEntete.getPhaTotPatient()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.pharmacieEntete.getPhaTypeReg() == 4) {
               if (this.pharmacieEntete.getPhaNumPieceTiers() == null || this.pharmacieEntete.getPhaNumPieceTiers().isEmpty()) {
                  this.pharmacieEntete.setPhaNumPieceTiers("Non renseignée");
               }

               this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
            }

            String var3 = this.calculChrono.numCompose(new Date(), 79, this.pharmacieEntete.getPhaSerie(), var1);
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
               this.bonEncaissementVente.setBonActivite(this.pharmacieEntete.getPhaActivite());
               this.bonEncaissementVente.setBonSite("");
               this.bonEncaissementVente.setBonDepartement("");
               this.bonEncaissementVente.setBonService(this.pharmacieEntete.getPhaService());
               this.bonEncaissementVente.setBonRegion("");
               this.bonEncaissementVente.setBonSecteur("");
               this.bonEncaissementVente.setBonPdv("");
               this.bonEncaissementVente.setBonDateEcheReg(this.pharmacieEntete.getPhaDateEcheReg());
               this.bonEncaissementVente.setBonEtat(0);
               this.bonEncaissementVente.setBonNatRef(this.nature);
               this.bonEncaissementVente.setBonNomTiers(this.pharmacieEntete.getPhaNomPatient());
               this.bonEncaissementVente.setBonIdTiers(this.pharmacieEntete.getPatients().getPatId());
               this.bonEncaissementVente.setBonNomContact("");
               this.bonEncaissementVente.setBonIdContact(0L);
               this.bonEncaissementVente.setBonTypeTiers(4);
               this.bonEncaissementVente.setBonLibelle("Règlement Pharmacie N° " + this.pharmacieEntete.getPhaNum());
               this.bonEncaissementVente.setBonRef(this.pharmacieEntete.getPhaNum());
               this.bonEncaissementVente.setBonIdRef(this.pharmacieEntete.getPhaId());
               this.bonEncaissementVente.setBonObject(this.pharmacieEntete.getPhaPharmacie());
               this.bonEncaissementVente.setBonObservation(this.pharmacieEntete.getPhaMedecin());
               this.bonEncaissementVente.setBonSerie(this.pharmacieEntete.getPhaSerie());
               this.bonEncaissementVente.setBonDevise(this.structureLog.getStrdevise());
               this.bonEncaissementVente.setBonTotTtc(this.pharmacieEntete.getPhaTotTaxePatient() + this.pharmacieEntete.getPhaTotPatient());
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
                  this.bonEncaissementVente.setBonActivite(this.pharmacieEntete.getPhaActivite());
                  this.bonEncaissementVente.setBonSite("");
                  this.bonEncaissementVente.setBonDepartement("");
                  this.bonEncaissementVente.setBonService(this.pharmacieEntete.getPhaService());
                  this.bonEncaissementVente.setBonRegion("");
                  this.bonEncaissementVente.setBonSecteur("");
                  this.bonEncaissementVente.setBonPdv("");
                  this.bonEncaissementVente.setBonDateEcheReg(this.pharmacieEntete.getPhaDateEcheReg());
                  this.bonEncaissementVente.setBonEtat(0);
                  this.bonEncaissementVente.setBonNatRef(this.nature);
                  this.bonEncaissementVente.setBonNomTiers(this.pharmacieEntete.getPhaNomPatient());
                  this.bonEncaissementVente.setBonIdTiers(this.pharmacieEntete.getPatients().getPatId());
                  this.bonEncaissementVente.setBonNomContact("");
                  this.bonEncaissementVente.setBonIdContact(0L);
                  this.bonEncaissementVente.setBonTypeTiers(4);
                  this.bonEncaissementVente.setBonLibelle("Règlement Pharmacie N° " + this.pharmacieEntete.getPhaNum());
                  this.bonEncaissementVente.setBonRef(this.pharmacieEntete.getPhaNum());
                  this.bonEncaissementVente.setBonIdRef(this.pharmacieEntete.getPhaId());
                  this.bonEncaissementVente.setBonObject(this.pharmacieEntete.getPhaPharmacie());
                  this.bonEncaissementVente.setBonObservation(this.pharmacieEntete.getPhaMedecin());
                  this.bonEncaissementVente.setBonSerie(this.pharmacieEntete.getPhaSerie());
                  this.bonEncaissementVente.setBonDevise(this.structureLog.getStrdevise());
                  this.bonEncaissementVente.setBonTotTtc(this.pharmacieEntete.getPhaTotTaxePatient() + this.pharmacieEntete.getPhaTotPatient());
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

      if (this.pharmacieEntete != null) {
         this.lesPharmacieEntete.remove(this.pharmacieEntete);
         this.pharmacieEntete.setVar_select_ligne(false);
         this.lesPharmacieEntete.add(this.pharmacieEntete);
      }

      this.datamodelDocument.setWrappedData(this.lesPharmacieEntete);
      this.showModalPanelPaye = false;
      this.visibiliteBton = false;
   }

   public void payeXDocumentRecu() throws HibernateException, NamingException {
      if (this.pharmacieEntete != null) {
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
         this.var_netAPayer = this.pharmacieEntete.getPhaTotTaxePatient() + this.pharmacieEntete.getPhaTotPatient() - this.pharmacieEntete.getPhaRegPatient();
         this.montantElmTotBonEnc = this.var_tot_bon_encaissement;
         this.varTypeReg = 0;
         this.choixTypeReglement();
         this.choixCaisseXReglement();
         this.pharmacieEntete.setPhaTypeReg(0);
         this.chargerModReg();
         this.verifValide();
         this.showModalPanelReglement = true;
      }

   }

   public void calculeCaisseDisponibleBrecu() throws HibernateException, NamingException {
      this.mesCaissesSeriesItems.clear();
      if (this.listCaisses.size() != 0) {
         for(int var1 = 0; var1 < this.listCaisses.size(); ++var1) {
            if (((UsersChrono)this.listCaisses.get(var1)).getUsrchrNature() == 61 && (((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 0 || ((UsersChrono)this.listCaisses.get(var1)).getUsrchrModeCaisse() == 2) && ((UsersChrono)this.listCaisses.get(var1)).getUsrchrSerie().equals(this.pharmacieEntete.getPhaSerie())) {
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
      if (this.montantElmTotBonEnc <= this.pharmacieEntete.getPhaTotTaxePatient() + this.pharmacieEntete.getPhaTotPatient() - this.var_tot_bon_encaissement) {
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

                        if (this.pharmacieEntete.getPhaTotPatient() > var4.getPatlgaMontant() - var1) {
                           this.reliquatPatient = var4.getPatlgaMontant() - var1 - this.pharmacieEntete.getPhaTotPatient();
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
         if (this.montantElmTotBonEnc != 0.0D && var4 < this.pharmacieEntete.getPhaTotTaxePatient() + this.pharmacieEntete.getPhaTotPatient() - this.pharmacieEntete.getPhaRegPatient()) {
            this.utilNombre.calculTimbre(this.structureLog, this.pharmacieEntete.getPhaTotTaxePatient() + this.pharmacieEntete.getPhaTotPatient() - this.pharmacieEntete.getPhaRegPatient(), var1, this.structureLog.getStrdevise(), this.pharmacieEntete.getPhaDate());
         } else {
            this.utilNombre.calculTimbre(this.structureLog, this.pharmacieEntete.getPhaTotTaxePatient() + this.pharmacieEntete.getPhaTotPatient() - this.pharmacieEntete.getPhaRegPatient(), var1, this.structureLog.getStrdevise(), this.pharmacieEntete.getPhaDate());
            var4 = var4 - this.pharmacieEntete.getPhaTotTaxePatient() + this.pharmacieEntete.getPhaTotPatient() - this.pharmacieEntete.getPhaRegPatient();
         }

         this.var_netAPayer += this.pharmacieEntete.getVar_reliquat();
      } else if (this.varTypeReg != 0) {
         this.var_netAPayer += this.pharmacieEntete.getVar_reliquat();
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
               String var7 = this.pharmacieEntete.getPhaSerie();
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
               var12 = this.pharmacieEntete.getPhaTotTaxePatient() + this.pharmacieEntete.getPhaTotPatient() + var16 - this.pharmacieEntete.getPhaRegPatient();
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

      if (this.lesPharmacieEntete.size() != 0) {
         int var23 = this.datamodelDocument.getRowIndex() + 1;
         Session var24 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         long var25 = this.pharmacieEntete.getPhaId();
         this.pharmacieEntete = new PharmacieEntete();
         this.pharmacieEntete = this.pharmacieEnteteDao.selectById(var25, var24);
         if (this.pharmacieEntete != null) {
            this.lesPharmacieEntete.remove(var23);
            this.lesPharmacieEntete.add(this.pharmacieEntete);
         }

         this.datamodelDocument.setWrappedData(this.lesPharmacieEntete);
         this.chargerBonEncaissement(var24);
         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelReglement = false;
   }

   public void generationReglement(String var1, double var2, double var4, ExercicesCaisse var6, Session var7) throws HibernateException, NamingException {
      this.reglements = new Reglements();
      if (var2 >= this.pharmacieEntete.getPhaTotTaxePatient() + this.pharmacieEntete.getPhaTotPatient() + var4) {
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

      this.reglements.setRglActivite(this.pharmacieEntete.getPhaActivite());
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
      this.reglements.setRglDocument(this.pharmacieEntete.getPhaNum());
      this.reglements.setRglIdCaissier(this.usersLog.getUsrid());
      this.reglements.setRglIdBon(0L);
      this.reglements.setRglIdDocument(this.pharmacieEntete.getPhaId());
      this.reglements.setRglIdTiers(this.pharmacieEntete.getPatients().getPatId());
      this.reglements.setRglDepotTiers(0);
      this.reglements.setRglLibelle(this.pharmacieEntete.getPhaPharmacie());
      this.reglements.setRglMode("" + this.varTypeReg);
      this.reglements.setRglModele(this.var_modele_trf);
      this.reglements.setRglNatureDoc(73);
      this.reglements.setRglNomCaissier(this.usersLog.getUsrPatronyme());
      this.reglements.setRglNomTiers(this.pharmacieEntete.getPhaNomPatient());
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
         int var10 = this.pharmacieEntete.getPhaDate().getYear() + 1900;
         var20 = this.utilNombre.calculTimbre(this.structureLog, var2, var10, this.structureLog.getStrdevise(), this.reglements.getRglDateReg());
         this.reglements.setRglTimbre(var20);
      } else {
         this.reglements.setRglTimbre(0.0D);
      }

      this.reglements.setRglRegion("");
      this.reglements.setRglSecteur("");
      this.reglements.setRglSerie(this.pharmacieEntete.getPhaSerie());
      this.reglements.setRglService(this.pharmacieEntete.getPhaService());
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
      if (this.pharmacieEntete != null) {
         this.pharmacieEntete.setPhaRegPatient(this.pharmacieEntete.getPhaRegPatient() + var2);
         if (this.pharmacieEntete.getPhaRegPatient() >= this.pharmacieEntete.getPhaTotTaxePatient() + this.pharmacieEntete.getPhaTotPatient()) {
            this.pharmacieEntete.setPhaSoldePatient(1);
         } else {
            this.pharmacieEntete.setPhaSoldePatient(0);
         }

         this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var7);
         ArrayList var13 = new ArrayList();
         if (this.lesMedicamments.size() != 0) {
            new PharmacieLigne();
            double var15 = this.reglements.getRglRecette();
            double var17 = 0.0D;

            for(int var19 = 0; var19 < this.lesMedicamments.size(); ++var19) {
               PharmacieLigne var14 = (PharmacieLigne)this.lesMedicamments.get(var19);
               if (var14.getPhaligPatientHt() + var14.getPhaligPatientTaxe() - var14.getPhaligRegPatient() != 0.0D) {
                  if (var14.getPhaligPatientHt() + var14.getPhaligPatientTaxe() <= var15) {
                     var14.setPhaligRegPatient(var14.getPhaligPatientHt() + var14.getPhaligPatientTaxe());
                     var17 = var14.getPhaligRegPatient();
                  } else {
                     var14.setPhaligRegPatient(var15);
                     var17 = var15;
                  }

                  var15 -= var14.getPhaligRegPatient();
                  if (var15 < 0.0D) {
                     var15 = 0.0D;
                  }

                  var14 = this.pharmacieLigneDao.modif(var14, var7);
                  var14.setNouveauPaiement(var17);
                  var13.add(var14);
               }
            }
         }

         if (var13.size() != 0) {
            PharmacieReglementDao var22 = new PharmacieReglementDao(this.baseLog, this.utilInitHibernate);
            new PharmacieReglement();
            new PharmacieLigne();

            for(int var24 = 0; var24 < var13.size(); ++var24) {
               PharmacieLigne var16 = (PharmacieLigne)var13.get(var24);
               PharmacieReglement var23 = new PharmacieReglement();
               if (this.reglements.getRglCodeCaiss() != null && !this.reglements.getRglCodeCaiss().isEmpty()) {
                  var23.setPharegCaisse(this.reglements.getRglCodeCaiss());
               } else {
                  var23.setPharegCaisse("");
               }

               var23.setPharegEtat(1);
               var23.setPharegDate(this.reglements.getRglDateReg());
               var23.setPharegNumRecu(this.reglements.getRglNum());
               var23.setPharegIdRecu(this.reglements.getRglId());
               var23.setPharmacieEntete(this.pharmacieEntete);
               var23.setPharegIdBonEncaissement(0L);
               var23.setPharegLibelle(var16.getPhaligLibelle());
               var23.setPharegPatient(var16.getNouveauPaiement());
               var23.setPharegProduit(var16.getPhaligProduit());
               var23.setPharegService(var16.getPharmacieEntete().getPhaService());
               var23.setPharegNumPieceTiers(var16.getPharmacieEntete().getPhaNumPieceTiers());
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "LaboratoireEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.reglements = (Reglements)this.datamodelRecu.getRowData();
            this.reglementsDao.delete(this.reglements, var1);
            new ArrayList();
            List var3 = this.reglementsDao.reglementDocument(this.pharmacieEntete.getPhaId(), this.nature, var1);
            double var4 = 0.0D;
            if (var3.size() != 0) {
               for(int var6 = 0; var6 < var3.size(); ++var6) {
                  var4 += ((Reglements)var3.get(var6)).getRglRecette();
               }
            }

            this.pharmacieEntete.setPhaRegPatient(var4);
            if (this.pharmacieEntete.getPhaRegPatient() >= this.pharmacieEntete.getPhaTotTaxePatient() + this.pharmacieEntete.getPhaTotPatient()) {
               this.pharmacieEntete.setPhaSoldePatient(1);
            } else {
               this.pharmacieEntete.setPhaSoldePatient(0);
            }

            this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var1);
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
      if (this.pharmacieEntete != null) {
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
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "pharmacie" + File.separator;
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatPharmacie.jpg");
            if (var4.exists()) {
               var3 = "formatPharmacie.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatPharmacie.jpg");
         if (var4.exists()) {
            var3 = "formatPharmacie.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      if (this.lesMedicamments.size() != 0) {
         for(int var2 = 0; var2 < this.lesMedicamments.size(); ++var2) {
            this.pharmacieLigne = (PharmacieLigne)this.lesMedicamments.get(var2);
            var1.add(this.pharmacieLigne);
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.pharmacieEntete.getTotalPatient(), this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(var1);
      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionRemboursementCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      double var2 = 0.0D;
      if (this.lesMedicamments.size() != 0) {
         for(int var4 = 0; var4 < this.lesMedicamments.size(); ++var4) {
            this.pharmacieLigne = (PharmacieLigne)this.lesMedicamments.get(var4);
            if (this.pharmacieLigne.getPhaligQte() < 0.0F) {
               var2 += this.pharmacieLigne.getPhaligPatientHt() + this.pharmacieLigne.getPhaligPatientTaxe();
               var1.add(this.pharmacieLigne);
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
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.pharmacieEntete.getPhaDateImp() != null && this.pharmacieEntete.getPhaEtat() != 0) {
            var2 = true;
         }

         this.pharmacieEntete.setPhaDateImp(new Date());
         if (this.pharmacieEntete.getPhaEtat() == 0 && this.pharmacieEntete.getPhaEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 0) {
            this.pharmacieEntete.setPhaEtat(1);
            if (this.lesMedicamments.size() != 0) {
               for(int var5 = 0; var5 < this.lesMedicamments.size(); ++var5) {
                  this.pharmacieLigne = (PharmacieLigne)this.lesMedicamments.get(var5);
                  if (this.pharmacieLigne.getPhaligDci() != null && !this.pharmacieLigne.getPhaligDci().isEmpty()) {
                     this.produits = this.produitsMedicDao.chargeProduit(this.pharmacieLigne.getPhaligDci(), var3);
                     if (this.produits != null && this.produits.getProStock() >= 1) {
                        this.calculStock.majPharmacie(this.pharmacieLigne, this.produits, 0.0F, 0, this.baseLog, var3);
                     }
                  }
               }
            }
         }

         this.pharmacieEntete.setPhaModeleImp(var1);
         this.pharmacieEntete = this.pharmacieEnteteDao.modif(this.pharmacieEntete, var3);
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
            var1.setEntete("Impression facture pharmacie");
            var1.setMontant_lettre(this.montant_lettre);
            var1.setPageGarde(this.conversionGarde());
            var1.setAnnexe1(this.conversionAnnexe1());
            var1.setAnnexe2(this.conversionAnnexe2());
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.pharmacieEntete.getPhaEtat()));
            var1.setDuplicata("" + var11);
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.pharmacieEntete.getPhaIdMedecin());
            var1.setIdCommercial(this.pharmacieEntete.getPhaIdCreateur());
            var1.setTiersSelectionne((Tiers)null);
            var1.setNumDoc(this.pharmacieEntete.getPhaNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.pharmacieEntete.getPhaId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des fatures paharmacie");
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "pharmacie" + File.separator);
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

         JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(this.lesPharmacieEntete);
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

   public void initImpressionResultat() {
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
      if (this.lesPharmacieEntete.size() != 0) {
         if (this.valQteGraph == 0) {
            this.uniteGraph = "PHARMACIE : Chiffre d'Affaire en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else {
            this.uniteGraph = "PHARMACIE  : Quantites";
            this.deviseGraph = "";
            this.nbDecGraph = 0;
         }

         this.titreGraph = "Analyse de la phamacie : ";
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
            this.sousTitreGraph = this.sousTitreGraph + " - Par produits (" + this.uniteGraph + ")";
         }

         new PharmacieEntete();
         new PharmacieLigne();
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "PharmacieEntete");
         String var6 = "";

         PharmacieEntete var14;
         for(int var7 = 0; var7 < this.lesPharmacieEntete.size(); ++var7) {
            var14 = (PharmacieEntete)this.lesPharmacieEntete.get(var7);
            if (var6.isEmpty()) {
               var6 = "'" + var14.getPhaNum() + "'";
            } else {
               var6 = var6 + ",'" + var14.getPhaNum() + "'";
            }
         }

         int var11;
         if (this.modeGraph == 20) {
            new ArrayList();
            List var20 = this.pharmacieLigneDao.chargerLesLignesActes(var6, var5);
            if (var20.size() != 0) {
               String var18 = "";
               long var9 = 0L;
               boolean var17 = false;
               new PharmacieLigne();
               int var13 = 0;

               while(true) {
                  if (var13 >= var20.size()) {
                     var1 = this.calculePourcentage((List)var1);
                     break;
                  }

                  PharmacieLigne var19 = (PharmacieLigne)var20.get(var13);
                  var18 = "";
                  var9 = 0L;
                  var11 = 0;
                  if (var19.getPhaligLibelle() == null || var19.getPhaligLibelle().isEmpty()) {
                     var19.setPhaligLibelle("ERREUR LIBELLE");
                  }

                  var18 = var19.getPhaligLibelle();
                  if (this.valQteGraph == 0) {
                     var9 = (long)var19.getPhaligTotal();
                  } else {
                     var9 = (long)this.utilNombre.myRound(var19.getPhaligQte(), 1);
                  }

                  if (this.timeDecoupage == 0) {
                     var11 = var19.getPharmacieEntete().getPhaDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var11 = var19.getPharmacieEntete().getPhaDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var19.getPharmacieEntete().getPhaDate().getMonth() + 1 >= 1 && var19.getPharmacieEntete().getPhaDate().getMonth() + 1 <= 3) {
                        var11 = 1;
                     } else if (var19.getPharmacieEntete().getPhaDate().getMonth() + 1 >= 4 && var19.getPharmacieEntete().getPhaDate().getMonth() + 1 <= 6) {
                        var11 = 2;
                     } else if (var19.getPharmacieEntete().getPhaDate().getMonth() + 1 >= 7 && var19.getPharmacieEntete().getPhaDate().getMonth() + 1 <= 9) {
                        var11 = 3;
                     } else if (var19.getPharmacieEntete().getPhaDate().getMonth() + 1 >= 10 && var19.getPharmacieEntete().getPhaDate().getMonth() + 1 <= 12) {
                        var11 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var19.getPharmacieEntete().getPhaDate().getMonth() + 1 >= 1 && var19.getPharmacieEntete().getPhaDate().getMonth() + 1 <= 6) {
                        var11 = 1;
                     } else if (var19.getPharmacieEntete().getPhaDate().getMonth() + 1 >= 7 && var19.getPharmacieEntete().getPhaDate().getMonth() + 1 <= 12) {
                        var11 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var11 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var11 = var19.getPharmacieEntete().getPhaDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var18, var11, var9);
                  ++var13;
               }
            }
         } else if (this.lesPharmacieEntete.size() != 0) {
            String var15 = "";
            long var8 = 0L;
            boolean var10 = false;
            var11 = 0;

            while(true) {
               if (var11 >= this.lesPharmacieEntete.size()) {
                  var1 = this.calculePourcentage((List)var1);
                  break;
               }

               var14 = (PharmacieEntete)this.lesPharmacieEntete.get(var11);
               var15 = "";
               var8 = 0L;
               int var16 = 0;
               if (this.modeGraph == 0) {
                  int var12 = var14.getPhaDate().getYear() + 1900;
                  var15 = "" + var12;
                  var8 = (long)var14.getPhaTotGeneral();
               } else if (this.modeGraph == 1) {
                  if (var14.getPhaMedecin() != null && !var14.getPhaMedecin().isEmpty()) {
                     var15 = var14.getPhaMedecin();
                  } else {
                     var15 = "Sans médecin";
                  }

                  var8 = (long)var14.getPhaTotGeneral();
               } else if (this.modeGraph == 2) {
                  if (var14.getPhaPrescripteur() != null && !var14.getPhaPrescripteur().isEmpty()) {
                     var15 = var14.getPhaPrescripteur();
                  } else {
                     var15 = "Sans prescripteur";
                  }

                  var8 = (long)var14.getPhaTotGeneral();
               } else if (this.modeGraph == 3) {
                  if (var14.getPhaNomPatient() != null && !var14.getPhaNomPatient().isEmpty()) {
                     var15 = var14.getPhaNomPatient();
                  } else {
                     var15 = "Sans patient";
                  }

                  var8 = (long)var14.getPhaTotPatient();
               } else if (this.modeGraph == 4) {
                  if (var14.getPhaNomAssurance() != null && !var14.getPhaNomAssurance().isEmpty()) {
                     var15 = var14.getPhaNomAssurance();
                  } else {
                     var15 = "Sans assurance";
                  }

                  var8 = (long)var14.getPhaTotAssurance();
               } else if (this.modeGraph == 5) {
                  if (var14.getPhaNomComplemtaire() != null && !var14.getPhaNomComplemtaire().isEmpty()) {
                     var15 = var14.getPhaNomComplemtaire();
                  } else {
                     var15 = "Sans complementaire";
                  }

                  var8 = (long)var14.getPhaTotComplmentaire();
               } else if (this.modeGraph == 6) {
                  if (var14.getPhaNomSociete() != null && !var14.getPhaNomSociete().isEmpty()) {
                     var15 = var14.getPhaNomSociete();
                  } else {
                     var15 = "Sans société";
                  }

                  var8 = (long)var14.getPhaTotSociete();
               } else if (this.modeGraph == 8) {
                  if (var14.getPhaProtocole() != null && !var14.getPhaProtocole().isEmpty()) {
                     var15 = var14.getPhaProtocole();
                  } else {
                     var15 = "Sans protocole";
                  }

                  var8 = (long)var14.getPhaTotGeneral();
               } else if (this.modeGraph == 9) {
                  if (var14.getPhaPathologie() != null && !var14.getPhaPathologie().isEmpty()) {
                     var15 = var14.getPhaPathologie();
                  } else {
                     var15 = "Sans pathologie";
                  }

                  var8 = (long)var14.getPhaTotGeneral();
               } else if (this.modeGraph == 10) {
                  if (var14.getPhaService() != null && !var14.getPhaService().isEmpty()) {
                     var15 = var14.getPhaService();
                  } else {
                     var15 = "Sans service";
                  }

                  var8 = (long)var14.getPhaTotGeneral();
               }

               if (this.timeDecoupage == 0) {
                  var16 = var14.getPhaDate().getDate();
               } else if (this.timeDecoupage == 1) {
                  var16 = var14.getPhaDate().getMonth() + 1;
               } else if (this.timeDecoupage == 2) {
                  if (var14.getPhaDate().getMonth() + 1 >= 1 && var14.getPhaDate().getMonth() + 1 <= 3) {
                     var16 = 1;
                  } else if (var14.getPhaDate().getMonth() + 1 >= 4 && var14.getPhaDate().getMonth() + 1 <= 6) {
                     var16 = 2;
                  } else if (var14.getPhaDate().getMonth() + 1 >= 7 && var14.getPhaDate().getMonth() + 1 <= 9) {
                     var16 = 3;
                  } else if (var14.getPhaDate().getMonth() + 1 >= 10 && var14.getPhaDate().getMonth() + 1 <= 12) {
                     var16 = 4;
                  }
               } else if (this.timeDecoupage == 3) {
                  if (var14.getPhaDate().getMonth() + 1 >= 1 && var14.getPhaDate().getMonth() + 1 <= 6) {
                     var16 = 1;
                  } else if (var14.getPhaDate().getMonth() + 1 >= 7 && var14.getPhaDate().getMonth() + 1 <= 12) {
                     var16 = 2;
                  }
               } else if (this.timeDecoupage == 4) {
                  var16 = 1;
               } else if (this.timeDecoupage == 5) {
                  var16 = var14.getPhaDate().getHours();
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

   public PharmacieEntete getPharmacieEntete() {
      return this.pharmacieEntete;
   }

   public void setPharmacieEntete(PharmacieEntete var1) {
      this.pharmacieEntete = var1;
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

   public PharmacieLigne getPharmacieLigne() {
      return this.pharmacieLigne;
   }

   public void setPharmacieLigne(PharmacieLigne var1) {
      this.pharmacieLigne = var1;
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

   public DataModel getDataModelPharmacie() {
      return this.dataModelPharmacie;
   }

   public void setDataModelPharmacie(DataModel var1) {
      this.dataModelPharmacie = var1;
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

   public List getMesConditionnementsItems() {
      return this.mesConditionnementsItems;
   }

   public void setMesConditionnementsItems(List var1) {
      this.mesConditionnementsItems = var1;
   }

   public List getMesConditionnementsProduits() {
      return this.mesConditionnementsProduits;
   }

   public void setMesConditionnementsProduits(List var1) {
      this.mesConditionnementsProduits = var1;
   }

   public List getMesUnitesItems() {
      return this.mesUnitesItems;
   }

   public void setMesUnitesItems(List var1) {
      this.mesUnitesItems = var1;
   }

   public List getMesUnitesProduits() {
      return this.mesUnitesProduits;
   }

   public void setMesUnitesProduits(List var1) {
      this.mesUnitesProduits = var1;
   }

   public boolean isVar_aff_condit() {
      return this.var_aff_condit;
   }

   public void setVar_aff_condit(boolean var1) {
      this.var_aff_condit = var1;
   }

   public boolean isVar_aff_unite() {
      return this.var_aff_unite;
   }

   public void setVar_aff_unite(boolean var1) {
      this.var_aff_unite = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
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

   public boolean isVar_consultation_directe() {
      return this.var_consultation_directe;
   }

   public void setVar_consultation_directe(boolean var1) {
      this.var_consultation_directe = var1;
   }

   public boolean isVerrouPrventeAssurance() {
      return this.verrouPrventeAssurance;
   }

   public void setVerrouPrventeAssurance(boolean var1) {
      this.verrouPrventeAssurance = var1;
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

   public boolean isShowModalPanelAnnuler() {
      return this.showModalPanelAnnuler;
   }

   public void setShowModalPanelAnnuler(boolean var1) {
      this.showModalPanelAnnuler = var1;
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

   public boolean isValidePharmacie() {
      return this.validePharmacie;
   }

   public void setValidePharmacie(boolean var1) {
      this.validePharmacie = var1;
   }

   public FormPatients getFormPatients() {
      return this.formPatients;
   }

   public void setFormPatients(FormPatients var1) {
      this.formPatients = var1;
   }

   public boolean isVerrouPharmacie() {
      return this.verrouPharmacie;
   }

   public void setVerrouPharmacie(boolean var1) {
      this.verrouPharmacie = var1;
   }

   public List getMesPharmaciesItems() {
      return this.mesPharmaciesItems;
   }

   public void setMesPharmaciesItems(List var1) {
      this.mesPharmaciesItems = var1;
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

   public String getVar_type_reg() {
      return this.var_type_reg;
   }

   public void setVar_type_reg(String var1) {
      this.var_type_reg = var1;
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

   public boolean isPatientDivers() {
      return this.patientDivers;
   }

   public void setPatientDivers(boolean var1) {
      this.patientDivers = var1;
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
