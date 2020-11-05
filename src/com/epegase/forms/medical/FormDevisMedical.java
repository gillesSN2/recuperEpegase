package com.epegase.forms.medical;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.forms.tiers.FormPatients;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ConventionMedical;
import com.epegase.systeme.classe.DevisEnteteMedical;
import com.epegase.systeme.classe.DevisLigneMedical;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.LettreMedical;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PatientPec;
import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsServices;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ConventionMedicalDao;
import com.epegase.systeme.dao.DevisEnteteMedicalDao;
import com.epegase.systeme.dao.DevisLigneMedicalDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.LettreMedicalDao;
import com.epegase.systeme.dao.PatientPecDao;
import com.epegase.systeme.dao.ProduitsDetailDao;
import com.epegase.systeme.dao.ProduitsMclesDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.ProtocoleMedicalDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.ObjetCategories;
import com.epegase.systeme.xml.ObjetLigneOnglet;
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

public class FormDevisMedical implements Serializable {
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
   private UtilDate utilDate = new UtilDate();
   private UtilNombre utilNombre = new UtilNombre();
   private transient DataModel datamodelDocument = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private List lesConsultationEntete = new ArrayList();
   private DevisEnteteMedical devisEnteteMedical;
   private DevisEnteteMedicalDao devisEnteteMedicalDao;
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
   private boolean valideLaboratoire;
   private boolean showModalpanelPec = false;
   private double totalDocFacture;
   private double totalDocPatient;
   private double totalDocTiers;
   private double totalDocReglement;
   private transient DataModel dataModelLaboratoire = new ListDataModel();
   private List lesLaboratoire = new ArrayList();
   private DevisLigneMedical devisLigneMedical;
   private DevisLigneMedicalDao devisLigneMedicalDao;
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
   private boolean showModalPanelChangerService = false;
   private boolean showModalPanelChangerServiceLaboratoire = false;
   private String nouveauService;
   private long nouveauMedecin;
   private String ancienMedecin;

   public void instanceDaoUtilises() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.devisEnteteMedicalDao = new DevisEnteteMedicalDao(this.baseLog, this.utilInitHibernate);
      this.devisLigneMedicalDao = new DevisLigneMedicalDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.produitsMedicDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      this.produitsMclesDao = new ProduitsMclesDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.produitsDetailDao = new ProduitsDetailDao(this.baseLog, this.utilInitHibernate);
      this.produitsServicesDao = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
      this.patientPecDao = new PatientPecDao(this.baseLog, this.utilInitHibernate);
      this.taxesMedicalDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      this.produitsTarifDao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
      this.conventionMedicalDao = new ConventionMedicalDao(this.baseLog, this.utilInitHibernate);
      this.lettreMedicalDao = new LettreMedicalDao(this.baseLog, this.utilInitHibernate);
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
      this.lesMedecins = this.usersDao.chargerLesUsersByServices(this.devisEnteteMedical.getDvsService(), var1);
      this.mesMedecinsItem.clear();

      for(int var2 = 0; var2 < this.lesMedecins.size(); ++var2) {
         Users var3 = (Users)this.lesMedecins.get(var2);
         if ((var3.getUsrFonction().contains("Professeur") || var3.getUsrFonction().contains("Médecin")) && var3.getUsrPatronyme() != null && !var3.getUsrPatronyme().isEmpty()) {
            this.mesMedecinsItem.add(new SelectItem(var3.getUsrid(), var3.getUsrPatronyme() + ":" + var3.getUsrMetier()));
         }
      }

      this.valideLaboratoire = true;
   }

   public void chargerMedecinService() throws HibernateException, NamingException {
      this.mesMedecinsItem.clear();
      String var1 = "";
      if (this.nouveauService != null && !this.nouveauService.isEmpty()) {
         var1 = this.nouveauService;
      } else if (this.devisEnteteMedical.getDvsService() != null && !this.devisEnteteMedical.getDvsService().isEmpty()) {
         var1 = this.devisEnteteMedical.getDvsService();
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
      this.valideLaboratoire = true;
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
      this.devisEnteteMedical.setPatients(this.patients);
      this.devisEnteteMedical.setDvsIdPatient(this.patients.getPatId());
      if (this.patients.getPatPrenom() != null && !this.patients.getPatPrenom().isEmpty()) {
         this.devisEnteteMedical.setDvsNomPatient(this.patients.getPatNom() + " " + this.patients.getPatPrenom());
      } else {
         this.devisEnteteMedical.setDvsNomPatient(this.patients.getPatNom());
      }

      this.devisEnteteMedical.setDvsCivilite(this.patients.getPatCivilite());
      this.devisEnteteMedical.setDvsPecCnamgs(0.0F);
      this.nomFamille = (long)this.patients.getPatNomFamille();
      this.devisEnteteMedical.setDvsFam(this.nomFamille);
      this.nomComplementaire = this.patients.getPatPecComplementaire();
      this.devisEnteteMedical.setDvsComplementaire(this.nomComplementaire);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Patients");
      this.elementPatient(var1);
      this.utilInitHibernate.closeSession();
      this.var_aff_action = false;
   }

   public void elementPatient(Session var1) throws HibernateException, NamingException {
      this.mesProtocoleItems.clear();
      ProtocoleMedicalDao var2 = new ProtocoleMedicalDao(this.baseLog, this.utilInitHibernate);
      this.mesProtocoleItems = var2.selectActifProtocoleItems(this.patients.getPatId(), var1);
      if (this.mesProtocoleItems.size() != 0) {
         this.var_affiche_protocole = true;
      } else {
         this.var_affiche_protocole = false;
      }

      this.mesCategoriesItems.clear();
      this.mesComplementaireItems.clear();
      this.var_pecAssurance = false;
      new ArrayList();
      List var3 = this.patientPecDao.chargerLesPatientsPec(this.patients, 0, var1);
      int var4;
      if (var3.size() != 0) {
         for(var4 = 0; var4 < var3.size(); ++var4) {
            if ((((PatientPec)var3.get(var4)).getPatpecInactif() == 0 || ((PatientPec)var3.get(var4)).getTiers().getTieid() == this.devisEnteteMedical.getDvsIdAssurance() || ((PatientPec)var3.get(var4)).getTiers().getTieid() == this.devisEnteteMedical.getDvsIdSociete() || ((PatientPec)var3.get(var4)).getTiers().getTieid() == this.devisEnteteMedical.getDvsIdComplementaire()) && ((PatientPec)var3.get(var4)).getPatpecType() != null && !((PatientPec)var3.get(var4)).getPatpecType().isEmpty()) {
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
         var16 = this.devisEnteteMedicalDao.rechercheDevis(var1, this.exercicesVentes.getExevteId(), this.getInpNum(), this.getInpNomPatient(), this.getInpPrenomPatient(), this.getInpTel(), this.getInpCi(), this.getInpDossier(), this.getInpSociete(), this.getInpAssurance(), this.getInpComplementaire(), this.getInpContrat(), this.getInpEtat(), this.getInpSerie(), this.getInpFam(), this.getPeriode(), this.getInpService(), this.usersLog.getUsrid(), this.usersLog.getUsrVentes(), this.getInpProtocole(), this.getInpMedecin(), this.getInpActivite(), var14, var15);
      }

      int var17;
      if (this.inpEtat == 13) {
         if (((List)var16).size() != 0) {
            for(var17 = 0; var17 < ((List)var16).size(); ++var17) {
               if (((DevisEnteteMedical)((List)var16).get(var17)).getDvsEtat() == 1 || ((DevisEnteteMedical)((List)var16).get(var17)).getDvsEtat() == 4 || ((DevisEnteteMedical)((List)var16).get(var17)).getDvsEtat() == 5 || ((DevisEnteteMedical)((List)var16).get(var17)).getDvsEtat() == 6) {
                  this.lesConsultationEntete.add(((List)var16).get(var17));
               }
            }
         }
      } else if (this.inpEtat == 15) {
         for(var17 = 0; var17 < ((List)var16).size(); ++var17) {
            if (((DevisEnteteMedical)((List)var16).get(var17)).getDvsEtat() == 6) {
               this.lesConsultationEntete.add(((List)var16).get(var17));
            }
         }
      } else if (this.inpEtat != 17 && this.inpEtat != 18) {
         this.lesConsultationEntete = (List)var16;
      } else {
         for(var17 = 0; var17 < ((List)var16).size(); ++var17) {
            if (((DevisEnteteMedical)((List)var16).get(var17)).getDvsEtat() == 5 || ((DevisEnteteMedical)((List)var16).get(var17)).getDvsEtat() == 6) {
               this.lesConsultationEntete.add(((List)var16).get(var17));
            }
         }
      }

      if (this.lesConsultationEntete.size() > 0) {
         this.datamodelDocument = new ListDataModel();
         this.datamodelDocument.setWrappedData(this.lesConsultationEntete);
         new DevisEnteteMedical();

         for(int var18 = 0; var18 < this.lesConsultationEntete.size(); ++var18) {
            DevisEnteteMedical var19 = (DevisEnteteMedical)this.lesConsultationEntete.get(var18);
            var2 += var19.getDvsTotPatient();
            var4 += var19.getDvsTotTaxePatient();
            var6 = var6 + var19.getDvsTotAssurance() + var19.getDvsTotSociete() + var19.getDvsTotComplmentaire();
            var8 = var8 + var19.getDvsTotTaxeAssurance() + var19.getDvsTotTaxeSociete() + var19.getDvsTotTaxeComplementaire();
            var10 += var19.getDvsRegPatient();
            var12 += var19.getDvsRegTiers();
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
      this.devisEnteteMedical = new DevisEnteteMedical();
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
            this.devisEnteteMedical = (DevisEnteteMedical)var1.get(0);
            this.var_pecCnamgs = this.devisEnteteMedical.getDvsPecCnamgs();
            this.nomFamille = this.devisEnteteMedical.getDvsFam();
            this.nomComplementaire = this.devisEnteteMedical.getDvsComplementaire();
            if (this.devisEnteteMedical.getDvsIdAssurance() != 0L) {
               this.var_pecAssurance = true;
            } else {
               this.var_pecAssurance = false;
            }

            this.var_nom_medecin = this.devisEnteteMedical.getDvsIdMedecin();
            this.var_date = this.devisEnteteMedical.getDvsDate();
            if (this.devisEnteteMedical.getDvsDate().getHours() <= 9) {
               this.var_heure = "0" + this.devisEnteteMedical.getDvsDate().getHours();
            } else {
               this.var_heure = "" + this.devisEnteteMedical.getDvsDate().getHours();
            }

            if (this.devisEnteteMedical.getDvsDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.devisEnteteMedical.getDvsDate().getMinutes();
            } else {
               this.var_minute = "" + this.devisEnteteMedical.getDvsDate().getMinutes();
            }

            if (this.devisEnteteMedical.getDvsDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.devisEnteteMedical.getDvsDate().getSeconds();
            } else {
               this.var_seconde = "" + this.devisEnteteMedical.getDvsDate().getSeconds();
            }

            this.patients = this.devisEnteteMedical.getPatients();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteMedical");
            this.chargerPriseEnCharges(var4);
            this.elementPatient(var4);
            this.chargerActes(var4);
            this.var_aff_detail_prod = false;
            this.afficheButtActes = false;
            this.calculMedecinActe(var4);
            this.chargerUserChrono(var4);
            this.utilInitHibernate.closeSession();
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      if (this.devisEnteteMedical != null) {
         if (this.devisEnteteMedical.getDvsEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void chargerPriseEnCharges(Session var1) throws HibernateException, NamingException {
      this.patientPec = null;
      this.patientPecComplementaire = null;
      if (this.devisEnteteMedical.getDvsFam() != 0L) {
         this.patientPec = this.patientPecDao.trouverPatientsPec(this.devisEnteteMedical.getDvsFam(), 0, var1);
      }

      if (this.devisEnteteMedical.getDvsComplementaire() != 0L) {
         this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.devisEnteteMedical.getDvsComplementaire(), 0, var1);
      }

   }

   public void chargerActes(Session var1) throws HibernateException, NamingException {
      this.lesLaboratoire.clear();
      this.devisLigneMedical = new DevisLigneMedical();
      this.lesLaboratoire = this.devisLigneMedicalDao.selectConsActesByConsEnt(this.devisEnteteMedical, var1);
      this.dataModelLaboratoire.setWrappedData(this.lesLaboratoire);
      this.totalDocFacture = 0.0D;
      this.totalDocPatient = 0.0D;
      this.totalDocReglement = 0.0D;
      this.totalDocTiers = 0.0D;
      if (this.lesLaboratoire.size() != 0) {
         for(int var2 = 0; var2 < this.lesLaboratoire.size(); ++var2) {
            this.totalDocFacture += ((DevisLigneMedical)this.lesLaboratoire.get(var2)).getDvsligTotal() + ((DevisLigneMedical)this.lesLaboratoire.get(var2)).getDvsligTaxe();
            this.totalDocPatient += ((DevisLigneMedical)this.lesLaboratoire.get(var2)).getTotlalPatient();
            this.totalDocReglement += ((DevisLigneMedical)this.lesLaboratoire.get(var2)).getDvsligRegPatient();
            this.totalDocTiers += ((DevisLigneMedical)this.lesLaboratoire.get(var2)).getTotalTiers();
         }
      }

   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.devisEnteteMedical != null && this.devisEnteteMedical.getDvsSerie() != null && !this.devisEnteteMedical.getDvsSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.devisEnteteMedical.getDvsSerie(), 74, this.usersLog, var1);
      }

   }

   public void calculTotaux() {
      if (this.devisEnteteMedical.getDvsPathologie() == null || this.devisEnteteMedical.getDvsPathologie().isEmpty() || !this.devisEnteteMedical.getDvsPathologie().contains(":") || this.devisEnteteMedical.getDvsPathologie().equals("100")) {
         this.devisEnteteMedical.setDvsPathologie("");
      }

      if (this.devisEnteteMedical.getDvsProtocole() == null || this.devisEnteteMedical.getDvsProtocole().isEmpty() || !this.devisEnteteMedical.getDvsProtocole().contains(":") || this.devisEnteteMedical.getDvsProtocole().equals("100")) {
         this.devisEnteteMedical.setDvsProtocole("");
      }

      if (this.devisEnteteMedical.getDvsService() == null || this.devisEnteteMedical.getDvsService().isEmpty() || !this.devisEnteteMedical.getDvsService().contains(":") || this.devisEnteteMedical.getDvsService().equals("100")) {
         this.devisEnteteMedical.setDvsService("");
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
         new DevisLigneMedical();

         for(int var24 = 0; var24 < this.lesLaboratoire.size(); ++var24) {
            DevisLigneMedical var23 = (DevisLigneMedical)this.lesLaboratoire.get(var24);
            var5 += var23.getDvsligPatientHt();
            var7 += var23.getDvsligPatientTaxe();
            var9 += var23.getDvsligSocieteHt();
            var11 += var23.getDvsligSocieteTaxe();
            var13 += var23.getDvsligAssuranceHt();
            var15 += var23.getDvsligAssuranceTaxe();
            var17 += var23.getDvsligComplementaireHt();
            var19 += var23.getDvsligComplementaireTaxe();
            var21 += var23.getDvsligRabais();
         }

         var1 = var5 + var9 + var13 + var17;
         var3 = var7 + var11 + var15 + var19;
      }

      this.devisEnteteMedical.setDvsTotPatient(var5);
      this.devisEnteteMedical.setDvsTotTaxePatient(var7);
      this.devisEnteteMedical.setDvsTotSociete(var9);
      this.devisEnteteMedical.setDvsTotTaxeSociete(var11);
      this.devisEnteteMedical.setDvsTotAssurance(var13);
      this.devisEnteteMedical.setDvsTotTaxeAssurance(var15);
      this.devisEnteteMedical.setDvsTotComplmentaire(var17);
      this.devisEnteteMedical.setDvsTotTaxeComplementaire(var19);
      this.devisEnteteMedical.setDvsTotGeneral(var1);
      this.devisEnteteMedical.setDvsTotTaxeGeneral(var3);
      this.devisEnteteMedical.setDvsTotRabais(var21);
      this.var_tot_tiers = var9 + var13 + var17;
      this.var_tot_reg = this.devisEnteteMedical.getDvsRegPatient() + this.devisEnteteMedical.getDvsRegTiers();
      this.var_solde = this.devisEnteteMedical.getDvsTotGeneral() - this.var_tot_reg;
      this.totalDocFacture = var1 + var3;
      this.totalDocPatient = var5 + var7;
      this.totalDocReglement = this.var_tot_reg;
      this.totalDocTiers = var9 + var11 + var13 + var15 + var17 + var19;
   }

   public void bloqueFacturation() throws HibernateException, NamingException {
      if (this.devisEnteteMedical != null) {
         this.devisEnteteMedical.setDvsBloqueRefacturation(true);
         this.devisEnteteMedical = this.devisEnteteMedicalDao.modif(this.devisEnteteMedical);
      }

   }

   public void deBloqueFacturation() throws HibernateException, NamingException {
      if (this.devisEnteteMedical != null) {
         this.devisEnteteMedical.setDvsBloqueRefacturation(false);
         this.devisEnteteMedical = this.devisEnteteMedicalDao.modif(this.devisEnteteMedical);
      }

   }

   public void ajoutDocument() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      this.lesMedecins.clear();
      this.mesMedecinsItem.clear();
      this.lesLaboratoire.clear();
      this.dataModelLaboratoire.setWrappedData(this.lesLaboratoire);
      this.lesLaboratoire.clear();
      this.dataModelLaboratoire.setWrappedData(this.lesLaboratoire);
      this.devisEnteteMedical = new DevisEnteteMedical();
      this.devisLigneMedical = new DevisLigneMedical();
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

      this.devisEnteteMedical.setDvsIdCreateur(this.usersLog.getUsrid());
      this.devisEnteteMedical.setDvsNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.devisEnteteMedical.setDvsIdMedecin(this.usersLog.getUsrid());
      this.devisEnteteMedical.setDvsMedecin(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.devisEnteteMedical.setDvsDate(new Date());
      this.devisEnteteMedical.setDvsDateCreat(new Date());
      this.devisEnteteMedical.setDvsDateModif((Date)null);
      this.devisEnteteMedical.setDvsIdModif(0L);
      this.devisEnteteMedical.setDvsNomModif("");
      this.devisEnteteMedical.setDvsNum("");
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
      this.var_aff_action = false;
      this.visibleOnglet = false;
      this.var_aff_detail_prod = false;
      this.afficheButtActes = false;
      this.showModalpanelPec = false;
      this.totalDocFacture = 0.0D;
      this.totalDocPatient = 0.0D;
      this.totalDocReglement = 0.0D;
      this.totalDocTiers = 0.0D;
      this.var_memo_action = this.var_action;
   }

   public void duppliquerDocument() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      if (this.devisEnteteMedical != null && this.patients != null) {
         this.var_consultation_directe = true;
         this.lesMedecins.clear();
         this.mesMedecinsItem.clear();
         this.lesLaboratoire.clear();
         this.dataModelLaboratoire.setWrappedData(this.lesLaboratoire);
         this.lesLaboratoire.clear();
         this.dataModelLaboratoire.setWrappedData(this.lesLaboratoire);
         this.devisEnteteMedical = new DevisEnteteMedical();
         this.devisLigneMedical = new DevisLigneMedical();
         this.memoDateRdv = null;
         this.mesCategoriesItems.clear();
         this.calculMedecinActe();
         this.nomFamille = 0L;
         this.nomComplementaire = 0L;
         this.patientPec = null;
         this.patientPecComplementaire = null;
         this.valideLaboratoire = false;
         this.calculePatient();
         this.var_action = 1;
         this.var_aff_detail_tiers = true;
         this.var_pecCnamgs = 0.0F;
         this.nomFamille = 0L;
         this.devisEnteteMedical.setDvsIdCreateur(this.usersLog.getUsrid());
         this.devisEnteteMedical.setDvsNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         this.devisEnteteMedical.setDvsIdMedecin(this.usersLog.getUsrid());
         this.devisEnteteMedical.setDvsMedecin(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         this.devisEnteteMedical.setDvsDate(new Date());
         this.devisEnteteMedical.setDvsDateCreat(new Date());
         this.devisEnteteMedical.setDvsDateModif((Date)null);
         this.devisEnteteMedical.setDvsIdModif(0L);
         this.devisEnteteMedical.setDvsNomModif("");
         this.devisEnteteMedical.setDvsNum("");
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
         this.var_aff_action = false;
         this.visibleOnglet = false;
         this.var_aff_detail_prod = false;
         this.afficheButtActes = false;
         this.var_memo_action = this.var_action;
      }

   }

   public void modifDocument() throws JDOMException, IOException, ParseException {
      if (this.devisEnteteMedical != null) {
         this.chargerModeEcheance();
         this.var_action = 11;
         this.var_aff_action = false;
         this.var_aff_detail_tiers = true;
         this.visibleOnglet = true;
         this.valideLaboratoire = true;
         this.choixImputationLabo = false;
         this.mesImputationLabo.clear();
         this.var_memo_action = this.var_action;
      }

   }

   public void consultDocument() throws ParseException {
      if (this.devisEnteteMedical != null) {
         this.chargerModeEcheance();
         this.var_action = 21;
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
      if (this.devisEnteteMedical.getDvsTypeReg() != 0 && this.devisEnteteMedical.getDvsTypeReg() != 3) {
         if (this.devisEnteteMedical.getDvsTypeReg() != 1 && this.devisEnteteMedical.getDvsTypeReg() != 2) {
            this.visibiliteterme = false;
         } else {
            this.visibiliteterme = true;
            this.visibilitenbrjr = true;
            this.visibiliteencaissemt = false;
         }
      } else {
         this.devisEnteteMedical.setDvsNbJourReg(0);
         this.devisEnteteMedical.setDvsArrondiReg(0);
      }

      if (this.devisEnteteMedical.getDvsTypeReg() == 4) {
         this.visibiliteencaissemt = true;
         this.visibilitenbrjr = true;
      } else {
         this.visibiliteencaissemt = false;
      }

      this.CalculDateEcheance();
   }

   public void CalculDateEcheance() throws ParseException {
      Date var1 = this.utilDate.CalculDateEcheance(this.devisEnteteMedical.getDvsDate(), this.devisEnteteMedical.getDvsTypeReg(), this.devisEnteteMedical.getDvsNbJourReg(), this.devisEnteteMedical.getDvsArrondiReg());
      this.devisEnteteMedical.setDvsDateEcheReg(var1);
   }

   public void selectionPec() throws HibernateException, NamingException {
      this.changerTarif();
   }

   public void supprimerDocument() throws HibernateException, NamingException {
      if (this.devisEnteteMedical != null) {
         String var1 = this.devisEnteteMedical.getDvsNum();
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteMedical");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            if (this.lesLaboratoire.size() != 0) {
               for(int var4 = 0; var4 < this.lesLaboratoire.size(); ++var4) {
                  this.devisLigneMedical = (DevisLigneMedical)this.lesLaboratoire.get(var4);
                  this.devisLigneMedicalDao.delete(this.devisLigneMedical, var2);
               }
            }

            new DevisEnteteMedical();
            DevisEnteteMedical var11 = this.devisEnteteMedicalDao.selectById(this.devisEnteteMedical.getDvsId(), var2);
            if (var11 != null) {
               this.devisEnteteMedicalDao.delete(var11, var2);
            }

            this.lesConsultationEntete.remove(this.devisEnteteMedical);
            Espion var5 = new Espion();
            var5.setUsers(this.usersLog);
            var5.setEsptype(0);
            var5.setEspdtecreat(new Date());
            var5.setEspaction("Suppression devis N° " + var1);
            this.espionDao.mAJEspion(var5, var2);
            var3.commit();
         } catch (HibernateException var9) {
            if (var3 != null) {
               var3.rollback();
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
      boolean var1 = false;
      this.calculTotaux();
      this.verifieExistenceHabilitation((Session)null);
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteMedical");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         this.devisEnteteMedical.setDvsDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         new Users();
         if (this.var_nom_medecin == 0L && this.mesMedecinsItem.size() == 1) {
            this.var_nom_medecin = Long.parseLong(((SelectItem)this.mesMedecinsItem.get(0)).getValue().toString());
         }

         Users var4 = this.usersDao.selectUserD(this.var_nom_medecin, var2);
         if (var4 != null) {
            this.devisEnteteMedical.setDvsIdMedecin(var4.getUsrid());
            this.devisEnteteMedical.setDvsMedecin(var4.getUsrPatronyme());
         } else {
            this.devisEnteteMedical.setDvsIdMedecin(0L);
            this.devisEnteteMedical.setDvsMedecin("");
         }

         this.devisEnteteMedical.setDvsPecCnamgs(this.var_pecCnamgs);
         this.devisEnteteMedical.setDvsAyantDroit(false);
         this.devisEnteteMedical.setDvsNomAssurePrincipal("");
         if (this.devisEnteteMedical.getDvsFam() <= 0L) {
            this.devisEnteteMedical.setDvsIdAssurance(0L);
            this.devisEnteteMedical.setDvsNomAssurance("");
            this.devisEnteteMedical.setDvsContratAssurance("");
            this.devisEnteteMedical.setDvsIdComplementaire(0L);
            this.devisEnteteMedical.setDvsNomComplemtaire("");
            this.devisEnteteMedical.setDvsIdEmployeur(0L);
            this.devisEnteteMedical.setDvsNomEmployeur("");
            this.devisEnteteMedical.setDvsContratComplementaire("");
            this.devisEnteteMedical.setDvsIdSociete(0L);
            this.devisEnteteMedical.setDvsNomSociete("");
            this.devisEnteteMedical.setDvsMatricule("");
         } else {
            if (this.patientPec == null) {
               this.patientPec = this.patientPecDao.trouverPatientsPec(this.devisEnteteMedical.getDvsFam(), 0, var2);
            }

            if (this.patientPec != null) {
               if (this.patientPec.getPatpecType() != null && !this.patientPec.getPatpecType().isEmpty()) {
                  if (!this.patientPec.getPatpecType().equals("Assurance") && !this.patientPec.getPatpecType().equals("IPM")) {
                     if (!this.patientPec.getPatpecType().equals("Mutuelle") && !this.patientPec.getPatpecType().equals("Complémentaire")) {
                        this.devisEnteteMedical.setDvsIdSociete(this.patientPec.getTiers().getTieid());
                        this.devisEnteteMedical.setDvsNomSociete(this.patientPec.getTiers().getTieraisonsocialenom());
                        this.devisEnteteMedical.setDvsMatricule(this.patientPec.getPatpecMatricule());
                     } else {
                        this.devisEnteteMedical.setDvsIdComplementaire(this.patientPec.getTiers().getTieid());
                        this.devisEnteteMedical.setDvsNomComplemtaire(this.patientPec.getTiers().getTieraisonsocialenom());
                        this.devisEnteteMedical.setDvsMatricule(this.patientPec.getPatpecMatricule());
                        this.devisEnteteMedical.setDvsContratComplementaire(this.patientPec.getPatpecNumContrat());
                     }
                  } else {
                     this.var_pecAssurance = true;
                     this.devisEnteteMedical.setDvsIdAssurance(this.patientPec.getTiers().getTieid());
                     this.devisEnteteMedical.setDvsNomAssurance(this.patientPec.getTiers().getTieraisonsocialenom());
                     this.devisEnteteMedical.setDvsIdEmployeur(this.patientPec.getPatpecIdEmployeur());
                     this.devisEnteteMedical.setDvsNomEmployeur(this.patientPec.getPatpecNomEmployeur());
                     this.devisEnteteMedical.setDvsMatricule(this.patientPec.getPatpecMatricule());
                     this.devisEnteteMedical.setDvsContratAssurance(this.patientPec.getPatpecNumContrat());
                  }

                  if (this.patientPec.getPatpecIdCouvert() != 0L) {
                     this.devisEnteteMedical.setDvsAyantDroit(true);
                     this.devisEnteteMedical.setDvsNomAssurePrincipal(this.patientPec.getPatpecNomCouvert());
                  }
               }
            } else {
               this.devisEnteteMedical.setDvsFam(0L);
            }
         }

         if (this.devisEnteteMedical.getDvsId() != 0L) {
            if (this.lesLaboratoire.size() == 0) {
               this.formRecherche.setMessageTexte("Vous n'avez pas spécifié de produits. Veuillez cliquez sur l'onglet Examens et saisir au moins un examen.");
               this.formRecherche.setShowModalPanelMessage(true);
            } else {
               this.devisEnteteMedical.setDvsDateModif(new Date());
               this.devisEnteteMedical.setDvsIdModif(this.usersLog.getUsrid());
               this.devisEnteteMedical.setDvsNomModif(this.usersLog.getUsrPatronyme());
               this.devisEnteteMedical = this.devisEnteteMedicalDao.modif(this.devisEnteteMedical, var2);
               this.var_action = 0;
               this.var_memo_action = this.var_action;
            }
         } else {
            if (!this.devisEnteteMedical.getDvsSerie().equalsIgnoreCase("X") && !this.devisEnteteMedical.getDvsSerie().isEmpty()) {
               this.devisEnteteMedical.setDvsNum(this.calculChrono.numCompose(this.devisEnteteMedical.getDvsDate(), this.nature, this.devisEnteteMedical.getDvsSerie(), var2));
               boolean var16 = false;

               label225:
               while(true) {
                  while(true) {
                     if (var16) {
                        break label225;
                     }

                     new DevisEnteteMedical();
                     DevisEnteteMedical var6 = this.devisEnteteMedicalDao.selectByNum(this.devisEnteteMedical.getDvsNum(), this.devisEnteteMedical.getDvsSerie(), var2);
                     if (var6 != null) {
                        long var7 = 100000000L * this.usersLog.getUsrid();

                        for(long var9 = 0L; var9 < var7; ++var9) {
                        }

                        this.devisEnteteMedical.setDvsNum(this.calculChrono.numCompose(this.devisEnteteMedical.getDvsDate(), this.nature, this.devisEnteteMedical.getDvsSerie(), var2));
                        var16 = false;
                     } else {
                        var16 = true;
                     }
                  }
               }
            } else {
               long var5 = this.devisEnteteMedicalDao.selectLastNum(var2);
               this.devisEnteteMedical.setDvsNum("" + var5);
            }

            this.devisEnteteMedical.setExerciceventes(this.exercicesVentes);
            this.devisEnteteMedical.setPatients(this.patients);
            this.devisEnteteMedical.setDvsDateCreat(new Date());
            this.devisEnteteMedical.setDvsIdCreateur(this.usersLog.getUsrid());
            this.devisEnteteMedical.setDvsNomCreateur(this.usersLog.getUsrPatronyme());
            this.devisEnteteMedical.setDvsEtat(0);
            this.devisEnteteMedical.setDvsEtatVal(0);
            this.devisEnteteMedical = this.devisEnteteMedicalDao.insert(this.devisEnteteMedical, var2);
            this.lesConsultationEntete.add(this.devisEnteteMedical);
            this.datamodelDocument.setWrappedData(this.lesConsultationEntete);
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         }

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

      this.var_consultation_directe = false;
      this.visibleOnglet = true;
   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.devisEnteteMedical.setDvsEtatVal(1);
         this.devisEnteteMedical.setDvsEtat(0);
         return true;
      } else {
         this.devisEnteteMedical.setDvsEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.devisEnteteMedical.setDvsEtat(1);
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2) {
               if (this.usersChrono.getUsrchrValidation() == 3) {
                  this.devisEnteteMedical.setDvsEtat(0);
               } else if (this.usersChrono.getUsrchrValidation() == 4) {
                  this.devisEnteteMedical.setDvsEtat(1);
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
      if (this.lesLaboratoire.size() == 0 && this.devisEnteteMedical.getDvsId() != 0L) {
         this.devisEnteteMedical.setDvsDateAnnule(new Date());
         this.devisEnteteMedical.setDvsEtat(3);
         this.devisEnteteMedical.setDvsMotifAnnule("ANNULATION SAISIE SUR AJOUT");
         this.devisEnteteMedical = this.devisEnteteMedicalDao.modif(this.devisEnteteMedical);
         this.lesConsultationEntete.remove(this.devisEnteteMedical);
         this.datamodelDocument.setWrappedData(this.lesConsultationEntete);
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteMedical");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.devisEnteteMedical.getDvsEtat() == 0 && this.usersChrono.getUsrchrValidation() == 2) {
            this.devisEnteteMedical.setDvsEtat(1);
            this.devisEnteteMedical = this.devisEnteteMedicalDao.modif(this.devisEnteteMedical, var1);
            Espion var3 = new Espion();
            var3.setUsers(this.usersLog);
            var3.setEsptype(0);
            var3.setEspdtecreat(new Date());
            var3.setEspaction("Validation manuelle devis (M.) N° " + this.devisEnteteMedical.getDvsNum() + " du " + this.utilDate.dateToStringSQLLight(this.devisEnteteMedical.getDvsDate()));
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteMedical");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.devisEnteteMedical.getDvsEtat() == 1 && this.usersChrono.getUsrchrDeValidation() == 1) {
            this.devisEnteteMedical.setDvsEtat(0);
            this.devisEnteteMedical.setDvsDateImp((Date)null);
            this.devisEnteteMedical = this.devisEnteteMedicalDao.modif(this.devisEnteteMedical, var1);
            Espion var3 = new Espion();
            var3.setUsers(this.usersLog);
            var3.setEsptype(0);
            var3.setEspdtecreat(new Date());
            var3.setEspaction("Dévalidation manuelle devis (M.) N° " + this.devisEnteteMedical.getDvsNum() + " du " + this.utilDate.dateToStringSQLLight(this.devisEnteteMedical.getDvsDate()));
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

   public void changerService() throws HibernateException, NamingException {
      if (this.devisEnteteMedical != null) {
         this.nouveauService = "";
         this.nouveauMedecin = 0L;
         this.ancienMedecin = "";
         if (this.devisEnteteMedical.getDvsIdMedecin() != 0L) {
            new Users();
            Users var1 = this.usersDao.selectLeUserId(this.devisEnteteMedical.getDvsIdMedecin(), (Session)null);
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
      if (this.devisEnteteMedical != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteMedical");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            boolean var3 = false;
            boolean var4 = false;
            String var5 = this.devisEnteteMedical.getDvsService();
            if (this.nouveauService != null && !this.nouveauService.isEmpty() && (this.devisEnteteMedical.getDvsService() == null || this.devisEnteteMedical.getDvsService().isEmpty() || !this.nouveauService.equals(this.devisEnteteMedical.getDvsService()))) {
               var3 = true;
            }

            if (this.nouveauMedecin != 0L && this.nouveauMedecin != this.devisEnteteMedical.getDvsIdMedecin()) {
               var4 = true;
            }

            if (var3 || var4) {
               if (var3) {
                  this.devisEnteteMedical.setDvsService(this.nouveauService);
               }

               if (var4) {
                  this.devisEnteteMedical.setDvsIdMedecin(this.nouveauMedecin);
               }

               this.devisEnteteMedical = this.devisEnteteMedicalDao.modif(this.devisEnteteMedical, var1);
               if (var3) {
                  Espion var6 = new Espion();
                  var6.setUsers(this.usersLog);
                  var6.setEsptype(0);
                  var6.setEspdtecreat(new Date());
                  var6.setEspaction("Chg service devis (M.) N° " + this.devisEnteteMedical.getDvsNum() + " du " + this.utilDate.dateToStringSQLLight(this.devisEnteteMedical.getDvsDate()) + " du service " + var5 + " au service " + this.nouveauService);
                  this.espionDao.mAJEspion(var6, var1);
               }

               if (var4) {
                  String var14 = "";
                  new Users();
                  Users var7 = this.usersDao.selectLeUserId(this.nouveauMedecin, var1);
                  if (var7 != null) {
                     var14 = var7.getUsrPatronyme();
                  }

                  Espion var8 = new Espion();
                  var8.setUsers(this.usersLog);
                  var8.setEsptype(0);
                  var8.setEspdtecreat(new Date());
                  var8.setEspaction("Chg médecin devis (M.) N° " + this.devisEnteteMedical.getDvsNum() + " du " + this.utilDate.dateToStringSQLLight(this.devisEnteteMedical.getDvsDate()) + " du médecin " + this.ancienMedecin + " au médecin " + var14);
                  this.espionDao.mAJEspion(var8, var1);
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

      this.showModalPanelChangerService = false;
   }

   public void changerServiceLaboratoire() {
      if (this.devisLigneMedical != null) {
         this.nouveauService = "";
         this.showModalPanelChangerServiceLaboratoire = true;
      }

   }

   public void annulerChangerServiceLaboratoire() {
      this.showModalPanelChangerServiceLaboratoire = false;
   }

   public void validerChangerServiceLaboratoire() throws HibernateException, NamingException {
      if (this.devisLigneMedical != null && this.nouveauService != null && !this.nouveauService.isEmpty() && !this.nouveauService.equals(this.devisLigneMedical.getDvsligLaboratoire())) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteMedical");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.devisLigneMedical.getDvsligLaboratoire();
            String var4 = this.devisLigneMedical.getDvsligProduit();
            this.devisLigneMedical.setDvsligLaboratoire(this.nouveauService);
            this.devisLigneMedical = this.devisLigneMedicalDao.modif(this.devisLigneMedical, var1);
            Espion var5 = new Espion();
            var5.setUsers(this.usersLog);
            var5.setEsptype(0);
            var5.setEspdtecreat(new Date());
            var5.setEspaction("Chg service devis ligne (M.) N° " + this.devisEnteteMedical.getDvsNum() + " du " + this.utilDate.dateToStringSQLLight(this.devisEnteteMedical.getDvsDate()) + " du service " + var3 + " au service " + this.nouveauService);
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

      this.showModalPanelChangerServiceLaboratoire = false;
   }

   public void ajouterActes() {
      this.produits = new Produits();
      this.devisLigneMedical = new DevisLigneMedical();
      this.var_lettre = "";
      this.var_aff_detail_prod = false;
      this.afficheButtActes = false;
      this.choixImputationLabo = false;
      this.mesImputationLabo.clear();
   }

   public void rechercheActes() throws HibernateException, NamingException {
      this.extDTableProduits = new HtmlExtendedDataTable();
      if (this.simpleSelectionProduits == null) {
         this.simpleSelectionProduits = new SimpleSelection();
      }

      this.simpleSelectionProduits.clear();
      if (this.devisLigneMedical.getDvsligProduit() != null && !this.devisLigneMedical.getDvsligProduit().isEmpty()) {
         this.lesProduits.clear();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteMedical");
         if (this.devisEnteteMedical.getDvsService() != null && !this.devisEnteteMedical.getDvsService().isEmpty()) {
            new Service();
            String[] var3 = this.devisEnteteMedical.getDvsService().split(":");
            Service var2 = this.serviceDao.chargerLeServiceCode(var3[0], var1);
            if (var2 == null) {
               this.lesProduits = this.produitsMedicDao.verifProduitsMedicaux(this.devisLigneMedical.getDvsligProduit(), "", var1);
            } else {
               new ArrayList();
               List var4 = this.produitsServicesDao.verifProduitsMedicaux(this.devisLigneMedical.getDvsligProduit(), "", var2, var1);
               if (var4.size() <= 0) {
                  this.lesProduits = this.produitsMedicDao.verifProduitsMedicaux(this.devisLigneMedical.getDvsligProduit(), "", var1);
               } else {
                  String var5 = "0000";

                  for(int var6 = 0; var6 < var4.size(); ++var6) {
                     ProduitsServices var7 = (ProduitsServices)var4.get(var6);
                     var5 = var5 + "," + var7.getProduits().getProId();
                  }

                  var5 = "(" + var5 + ")";
                  this.lesProduits = this.produitsMedicDao.selectFindProduitSerMedical(this.devisLigneMedical.getDvsligProduit(), (String)null, "", (String)null, (String)null, var5, 0, var1);
               }
            }
         } else {
            this.lesProduits = this.produitsMedicDao.verifProduitsMedicaux(this.devisLigneMedical.getDvsligProduit(), "", var1);
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
         this.devisLigneMedical.setDvsligProduit(this.produits.getProCode());
         this.devisLigneMedical.setDvsligLibelle(this.produits.getProLibClient());
         this.devisLigneMedical.setDvsligFamille(this.produits.getProVteCode() + ":" + this.produits.getProVteLib());
         this.mesImputationLabo.clear();
         this.choixImputationLabo = false;
         if (!this.optionMedical.getChoixLabo().equals("1")) {
            this.devisLigneMedical.setDvsligLaboratoire(this.devisEnteteMedical.getDvsService());
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
               List var2 = this.produitsServicesDao.verifProduitsMedicaux(this.devisLigneMedical.getDvsligProduit(), "", (Service)null, (Session)null);
               if (var2.size() != 0) {
                  var1 = ((ProduitsServices)var2.get(0)).getProserCode() + ":" + ((ProduitsServices)var2.get(0)).getProserNomFr();
               }
            }

            this.devisLigneMedical.setDvsligLaboratoire(var1);
         }

         this.validesActesSuite((Session)null);
      }

   }

   public void validesActesSuite(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteMedical");
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
      double var9 = this.devisLigneMedical.getDvsligPu();
      double var11 = this.devisLigneMedical.getDvsligPuCnamgs();
      double var13 = this.devisLigneMedical.getDvsligPuAssurance();
      boolean var15 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteMedical");
         var15 = true;
      }

      this.produits = this.produitsMedicDao.chargeProduit(this.devisLigneMedical.getDvsligProduit(), var1);
      if (this.produits != null) {
         this.devisLigneMedical.setDvsligProduit(this.produits.getProCode());
         this.devisLigneMedical.setDvsligLibelle(this.produits.getProLibClient());
         this.devisLigneMedical.setDvsligLettre(this.produits.getProLettre());
         if (this.produits.getProLettre() != null && !this.produits.getProLettre().isEmpty()) {
            this.devisLigneMedical.setDvsligLettre(this.produits.getProLettre());
         } else {
            this.devisLigneMedical.setDvsligLettre("");
            this.devisLigneMedical.setDvsligNb(0.0F);
            this.devisLigneMedical.setDvsligNbCnamgs(0.0F);
         }

         if (this.devisLigneMedical.getDvsligQte() == 0.0F) {
            this.devisLigneMedical.setDvsligQte(1.0F);
         }

         this.devisLigneMedical.setDvsligCodeTva(this.produits.getProVteTva());
         this.devisLigneMedical.setDvsligTauxTva(0.0F);
         if (this.devisLigneMedical.getDvsligCodeTva() != null && !this.devisLigneMedical.getDvsligCodeTva().isEmpty()) {
            this.taxesMedical = this.taxesMedicalDao.selectTva(this.exercicesVentes.getExevteId(), this.devisLigneMedical.getDvsligCodeTva(), var1);
            if (this.taxesMedical != null) {
               this.devisLigneMedical.setDvsligTauxTva(this.taxesMedical.getTaxvteTaux());
            }
         }

         String var16 = this.devisEnteteMedical.getLibelleFamille();
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
         }

         this.produitsTarif = this.produitsTarifDao.selectProdTarifByprodCat(this.produits, var16, var1);
         if (this.produitsTarif != null) {
            var2 = this.produitsTarif.getProtarCoef();
            var3 = this.produitsTarif.getProtarPv();
            var5 = this.produitsTarif.getProtarPvCnamgs();
            this.devisLigneMedical.setDvsligNb(this.produitsTarif.getProtarNb());
            this.devisLigneMedical.setDvsligNbCnamgs(this.produitsTarif.getProtarNbCnamgs());
            this.devisLigneMedical.setDvsligValeur(this.produitsTarif.getProtarValeur());
            this.devisLigneMedical.setDvsligValeurCnamgs(this.produitsTarif.getProtarValeurCnamgs());
            if (var2 == 0.0F) {
               var2 = 1.0F;
               if (this.lesCategoriesList.size() != 0) {
                  for(var17 = 0; var17 < this.lesCategoriesList.size(); ++var17) {
                     if (((ObjetCategories)this.lesCategoriesList.get(var17)).getLibelle_FR().equals(this.devisEnteteMedical.getLibelleEta())) {
                        var2 = ((ObjetCategories)this.lesCategoriesList.get(var17)).getCoef();
                        break;
                     }
                  }
               }
            }

            this.devisLigneMedical.setDvsligCoef(var2);
            if (var9 != 0.0D) {
               var3 = var9;
            }

            this.devisLigneMedical.setDvsligPu(var3);
            if (var11 != 0.0D) {
               var5 = var11;
            }

            this.devisLigneMedical.setDvsligPuCnamgs(var5);
            if (var13 != 0.0D) {
               var7 = var13;
            }

            this.devisLigneMedical.setDvsligPuAssurance(var7);
            if (this.devisEnteteMedical.getDvsFam() >= 1L) {
               this.patientPec = this.patientPecDao.trouverPatientsPec(this.devisEnteteMedical.getDvsFam(), 0, var1);
               if (this.patientPec != null) {
                  this.conventionMedical = this.conventionMedicalDao.trouveConvention(this.patientPec.getTiers().getTieid(), this.devisLigneMedical.getDvsligProduit(), var1);
                  if (this.conventionMedical != null) {
                     this.devisLigneMedical.setDvsligPuAssurance(this.conventionMedical.getCvnValeur());
                     if (this.conventionMedical.getCvnValeurOrigine() != 0.0D) {
                        this.devisLigneMedical.setDvsligPu(this.conventionMedical.getCvnValeurOrigine());
                     }
                  }
               }
            }
         } else {
            this.devisLigneMedical.setDvsligLettre("");
            this.devisLigneMedical.setDvsligNb(0.0F);
            this.devisLigneMedical.setDvsligNbCnamgs(0.0F);
            this.devisLigneMedical.setDvsligCoef(0.0F);
            this.devisLigneMedical.setDvsligValeur(0.0D);
            this.devisLigneMedical.setDvsligValeurCnamgs(0.0D);
            this.devisLigneMedical.setDvsligPu(var9);
            this.devisLigneMedical.setDvsligPuCnamgs(var11);
            this.devisLigneMedical.setDvsligPuAssurance(var13);
            if (this.devisLigneMedical.getDvsligQte() == 0.0F) {
               this.devisLigneMedical.setDvsligQte(1.0F);
            }
         }
      } else {
         this.devisLigneMedical.setDvsligLettre("");
         this.devisLigneMedical.setDvsligNb(0.0F);
         this.devisLigneMedical.setDvsligNbCnamgs(0.0F);
         this.devisLigneMedical.setDvsligCoef(0.0F);
         this.devisLigneMedical.setDvsligValeur(0.0D);
         this.devisLigneMedical.setDvsligValeurCnamgs(0.0D);
         this.devisLigneMedical.setDvsligPu(var9);
         this.devisLigneMedical.setDvsligPuCnamgs(var11);
         this.devisLigneMedical.setDvsligPuAssurance(var13);
         if (this.devisLigneMedical.getDvsligQte() == 0.0F) {
            this.devisLigneMedical.setDvsligQte(1.0F);
         }
      }

      if (this.var_pecCnamgs != 0.0F) {
         if (this.nomComplementaire != 0L) {
            this.avecCnamgsPriveComplementaire(var1);
         } else {
            this.avecCnamgsPrive(var1);
         }
      } else if (this.devisEnteteMedical.getDvsFam() != 0L && this.devisEnteteMedical.getDvsFam() != -1L) {
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
      if (this.devisLigneMedical.getDvsligRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.devisLigneMedical.getDvsligPu() * (double)this.devisLigneMedical.getDvsligRemise() / 100.0D, this.structureLog.getStrdevise());
         this.devisLigneMedical.setDvsligPuRem(this.devisLigneMedical.getDvsligPu() - var2);
         this.devisLigneMedical.setDvsligRabais(0.0D);
      } else {
         this.devisLigneMedical.setDvsligPuRem(this.devisLigneMedical.getDvsligPu());
      }

      this.devisLigneMedical.setDvsligTotal(this.devisLigneMedical.getDvsligPuRem() * (double)this.devisLigneMedical.getDvsligQte());
      if (this.devisLigneMedical.getDvsligTauxTva() != 0.0F) {
         var2 = this.devisLigneMedical.getDvsligTotal() * (double)this.devisLigneMedical.getDvsligTauxTva() / 100.0D;
         this.devisLigneMedical.setDvsligTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.devisLigneMedical.setDvsligTaxe(0.0D);
      }

      this.devisLigneMedical.setDvsligNbCnamgs(0.0F);
      this.devisLigneMedical.setDvsligValeurCnamgs(0.0D);
      this.devisLigneMedical.setDvsligPuCnamgs(0.0D);
      this.devisLigneMedical.setDvsligSocieteHt(0.0D);
      this.devisLigneMedical.setDvsligSocieteTaxe(0.0D);
      this.devisLigneMedical.setDvsligAssuranceHt(0.0D);
      this.devisLigneMedical.setDvsligAssuranceTaxe(0.0D);
      this.devisLigneMedical.setDvsligComplementaireHt(0.0D);
      this.devisLigneMedical.setDvsligComplementaireTaxe(0.0D);
      this.devisLigneMedical.setDvsligPatientHt(0.0D);
      this.devisLigneMedical.setDvsligPatientTaxe(0.0D);
      this.devisEnteteMedical.setDvsIdEmployeur(0L);
      var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      float var8 = 0.0F;
      double var9;
      if (this.devisEnteteMedical.getDvsIdSociete() != 0L && this.devisEnteteMedical.getDvsFam() != 0L) {
         if (this.patientPec == null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.devisEnteteMedical.getDvsFam(), 0, var1);
         }

         if (this.patientPec != null) {
            var2 = this.devisLigneMedical.getDvsligTotal() * (double)this.patientPec.getPatpecExamenss() / 100.0D;
            if (this.patientPec.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.devisLigneMedical.setDvsligSocieteHt(var2);
            } else {
               this.devisLigneMedical.setDvsligSocieteHt(var2 * (double)this.patientPec.getTiers().getTiecoefpvmedical());
               var8 = this.patientPec.getTiers().getTiecoefpvmedical();
            }

            if (this.devisLigneMedical.getDvsligTauxTva() != 0.0F) {
               var9 = this.devisLigneMedical.getDvsligSocieteHt() * (double)this.devisLigneMedical.getDvsligTauxTva() / 100.0D;
               this.devisLigneMedical.setDvsligSocieteTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      } else if (this.devisEnteteMedical.getDvsIdAssurance() != 0L && this.devisEnteteMedical.getDvsFam() != 0L) {
         if (this.patientPec == null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.devisEnteteMedical.getDvsFam(), 0, var1);
         }

         if (this.patientPec != null) {
            this.var_pecAssurance = true;
            this.devisEnteteMedical.setDvsIdEmployeur(this.patientPec.getPatpecIdEmployeur());
            if (this.devisLigneMedical.getDvsligPuAssurance() == 0.0D) {
               this.devisLigneMedical.setDvsligPuAssurance(this.devisLigneMedical.getDvsligPu());
            }

            var4 = this.devisLigneMedical.getDvsligPuAssurance() * (double)this.devisLigneMedical.getDvsligQte() * (double)this.patientPec.getPatpecExamenss() / 100.0D;
            if (this.devisLigneMedical.getDvsligRemise() != 0.0F) {
               var9 = this.utilNombre.myRoundDevise(var4 * (double)this.devisLigneMedical.getDvsligRemise() / 100.0D, this.structureLog.getStrdevise());
               var4 -= var9;
            }

            if (this.patientPec.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.devisLigneMedical.setDvsligAssuranceHt(var4);
            } else {
               this.devisLigneMedical.setDvsligAssuranceHt(var4 * (double)this.patientPec.getTiers().getTiecoefpvmedical());
               var8 = this.patientPec.getTiers().getTiecoefpvmedical();
            }

            if (this.devisLigneMedical.getDvsligTauxTva() != 0.0F) {
               var9 = this.devisLigneMedical.getDvsligAssuranceHt() * (double)this.devisLigneMedical.getDvsligTauxTva() / 100.0D;
               this.devisLigneMedical.setDvsligAssuranceTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      }

      if (this.devisEnteteMedical.getDvsIdComplementaire() != 0L) {
         if (this.patientPecComplementaire == null) {
            this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.devisEnteteMedical.getDvsComplementaire(), 0, var1);
         }

         if (this.patientPecComplementaire != null) {
            var6 = this.devisLigneMedical.getDvsligPu() * (double)this.devisLigneMedical.getDvsligQte() * (double)this.patientPecComplementaire.getPatpecExamenss() / 100.0D;
            if (this.devisLigneMedical.getDvsligRemise() != 0.0F) {
               var9 = this.utilNombre.myRoundDevise(var6 * (double)this.devisLigneMedical.getDvsligRemise() / 100.0D, this.structureLog.getStrdevise());
               var6 -= var9;
            }

            if (this.patientPecComplementaire.getTiers().getTiecoefpvmedical() == 0.0F || this.produits.getProMajoration() != 0 || !this.optionMedical.getCoefMajoration().equals("1") && !this.optionMedical.getCoefMajoration().equals("2") && !this.optionMedical.getCoefMajoration().equals("3")) {
               this.devisLigneMedical.setDvsligComplementaireHt(var6);
            } else {
               this.devisLigneMedical.setDvsligComplementaireHt(var6 * (double)this.patientPecComplementaire.getTiers().getTiecoefpvmedical());
            }

            if (this.devisLigneMedical.getDvsligTauxTva() != 0.0F) {
               var9 = this.devisLigneMedical.getDvsligComplementaireHt() * (double)this.devisLigneMedical.getDvsligTauxTva() / 100.0D;
               this.devisLigneMedical.setDvsligComplementaireTaxe(this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise()));
            }
         }
      }

      var9 = 0.0D;
      double var11;
      if (var8 != 0.0F && this.produits.getProMajoration() == 0 && this.optionMedical.getCoefMajoration().equals("2")) {
         if (this.devisLigneMedical.getDvsligRemise() != 0.0F) {
            var11 = this.utilNombre.myRoundDevise(this.devisLigneMedical.getDvsligPu() * (double)this.devisLigneMedical.getDvsligRemise() / 100.0D, this.structureLog.getStrdevise());
            this.devisLigneMedical.setDvsligPuRem((this.devisLigneMedical.getDvsligPu() - var11) * (double)var8);
         } else {
            this.devisLigneMedical.setDvsligPuRem(this.devisLigneMedical.getDvsligPu() * (double)var8);
         }

         this.devisLigneMedical.setDvsligTotal(this.devisLigneMedical.getDvsligPuRem() * (double)this.devisLigneMedical.getDvsligQte());
         if (this.devisLigneMedical.getDvsligTauxTva() != 0.0F) {
            var11 = this.devisLigneMedical.getDvsligTotal() * (double)this.devisLigneMedical.getDvsligTauxTva() / 100.0D;
            this.devisLigneMedical.setDvsligTaxe(this.utilNombre.myRoundDevise(var11, this.structureLog.getStrdevise()));
         } else {
            this.devisLigneMedical.setDvsligTaxe(0.0D);
         }
      } else {
         var9 = this.devisLigneMedical.getDvsligTotal() - (var2 + var4 + var6);
         this.devisLigneMedical.setDvsligTotal(this.devisLigneMedical.getDvsligSocieteHt() + this.devisLigneMedical.getDvsligAssuranceHt() + this.devisLigneMedical.getDvsligComplementaireHt() + var9);
      }

      var11 = this.devisLigneMedical.getDvsligTotal() - (this.devisLigneMedical.getDvsligSocieteHt() + this.devisLigneMedical.getDvsligAssuranceHt() + this.devisLigneMedical.getDvsligComplementaireHt());
      if (this.devisLigneMedical.getDvsligRabais() != 0.0D) {
         this.devisLigneMedical.setDvsligPatientHt(var11 - this.devisLigneMedical.getDvsligRabais());
         this.devisLigneMedical.setDvsligRemise(0.0F);
         if (this.devisLigneMedical.getDvsligPatientHt() < 0.0D) {
            this.devisLigneMedical.setDvsligPatientHt(var11);
            this.devisLigneMedical.setDvsligRabais(0.0D);
         }
      } else {
         this.devisLigneMedical.setDvsligPatientHt(var11);
      }

      double var13;
      if (this.devisLigneMedical.getDvsligTauxTva() != 0.0F) {
         var13 = this.devisLigneMedical.getDvsligPatientHt() * (double)this.devisLigneMedical.getDvsligTauxTva() / 100.0D;
         this.devisLigneMedical.setDvsligPatientTaxe(this.utilNombre.myRoundDevise(var13, this.structureLog.getStrdevise()));
      }

      if (var8 != 0.0F && this.produits.getProMajoration() == 0 && this.optionMedical.getCoefMajoration().equals("3")) {
         if (this.devisLigneMedical.getDvsligRemise() != 0.0F) {
            var13 = this.utilNombre.myRoundDevise(this.devisLigneMedical.getDvsligPu() * (double)this.devisLigneMedical.getDvsligRemise() / 100.0D, this.structureLog.getStrdevise());
            this.devisLigneMedical.setDvsligPuRem((this.devisLigneMedical.getDvsligPu() - var13) * (double)var8);
         } else {
            this.devisLigneMedical.setDvsligPuRem(this.devisLigneMedical.getDvsligPu() * (double)var8);
         }

         this.devisLigneMedical.setDvsligTotal(this.devisLigneMedical.getDvsligPuRem() * (double)this.devisLigneMedical.getDvsligQte());
         var13 = this.devisLigneMedical.getDvsligAssuranceHt() + this.devisLigneMedical.getDvsligComplementaireHt() + this.devisLigneMedical.getDvsligSocieteHt() + this.devisLigneMedical.getDvsligPatientHt();
         double var15 = this.devisLigneMedical.getDvsligTotal() - var13;
         if (var15 != 0.0D) {
            if (var4 != 0.0D) {
               this.devisLigneMedical.setDvsligAssuranceHt(this.devisLigneMedical.getDvsligAssuranceHt() + var15);
            } else if (var2 != 0.0D) {
               this.devisLigneMedical.setDvsligSocieteHt(this.devisLigneMedical.getDvsligSocieteHt() + var15);
            }

            if (var6 != 0.0D) {
               this.devisLigneMedical.setDvsligComplementaireHt(this.devisLigneMedical.getDvsligComplementaireHt() + var15);
            }
         }
      }

   }

   public void sansCnamgsPrive(Session var1) {
      if (this.tauxCasSocial != 0.0F) {
         this.devisLigneMedical.setDvsligRemise(this.tauxCasSocial);
      }

      double var2;
      if (this.devisLigneMedical.getDvsligRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.devisLigneMedical.getDvsligPu() * (double)this.devisLigneMedical.getDvsligRemise() / 100.0D, this.structureLog.getStrdevise());
         this.devisLigneMedical.setDvsligPuRem(this.devisLigneMedical.getDvsligPu() - var2);
         this.devisLigneMedical.setDvsligRabais(0.0D);
      } else {
         this.devisLigneMedical.setDvsligPuRem(this.devisLigneMedical.getDvsligPu());
      }

      this.devisLigneMedical.setDvsligTotal(this.devisLigneMedical.getDvsligPuRem() * (double)this.devisLigneMedical.getDvsligQte());
      if (this.devisLigneMedical.getDvsligTauxTva() != 0.0F) {
         var2 = this.devisLigneMedical.getDvsligTotal() * (double)this.devisLigneMedical.getDvsligTauxTva() / 100.0D;
         this.devisLigneMedical.setDvsligTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.devisLigneMedical.setDvsligTaxe(0.0D);
      }

      this.devisLigneMedical.setDvsligNbCnamgs(0.0F);
      this.devisLigneMedical.setDvsligValeurCnamgs(0.0D);
      this.devisLigneMedical.setDvsligPuCnamgs(0.0D);
      this.devisLigneMedical.setDvsligSocieteHt(0.0D);
      this.devisLigneMedical.setDvsligSocieteTaxe(0.0D);
      this.devisLigneMedical.setDvsligAssuranceHt(0.0D);
      this.devisLigneMedical.setDvsligAssuranceTaxe(0.0D);
      this.devisLigneMedical.setDvsligComplementaireHt(0.0D);
      this.devisLigneMedical.setDvsligComplementaireTaxe(0.0D);
      this.devisLigneMedical.setDvsligPatientHt(0.0D);
      this.devisLigneMedical.setDvsligPatientTaxe(0.0D);
      this.devisEnteteMedical.setDvsIdEmployeur(0L);
      var2 = this.devisLigneMedical.getDvsligTotal();
      if (this.devisLigneMedical.getDvsligRabais() != 0.0D) {
         this.devisLigneMedical.setDvsligPatientHt(var2 - this.devisLigneMedical.getDvsligRabais());
         this.devisLigneMedical.setDvsligRemise(0.0F);
         if (this.devisLigneMedical.getDvsligPatientHt() < 0.0D) {
            this.devisLigneMedical.setDvsligPatientHt(var2);
            this.devisLigneMedical.setDvsligRabais(0.0D);
         }
      } else {
         this.devisLigneMedical.setDvsligPatientHt(var2);
      }

      if (this.devisLigneMedical.getDvsligTaxe() != 0.0D) {
         double var4 = this.devisLigneMedical.getDvsligPatientHt() * (double)this.devisLigneMedical.getDvsligTauxTva() / 100.0D;
         this.devisLigneMedical.setDvsligPatientTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
      } else {
         this.devisLigneMedical.setDvsligPatientTaxe(0.0D);
      }

   }

   public void avecCnamgsPrive(Session var1) throws HibernateException, NamingException {
      if (this.devisLigneMedical.getDvsligPuCnamgs() > this.devisLigneMedical.getDvsligPu()) {
         this.devisLigneMedical.setDvsligPu(this.devisLigneMedical.getDvsligPuCnamgs());
      }

      double var2;
      double var4;
      if (this.devisLigneMedical.getDvsligRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.devisLigneMedical.getDvsligPu() * (double)this.devisLigneMedical.getDvsligRemise() / 100.0D, this.structureLog.getStrdevise());
         this.devisLigneMedical.setDvsligPuRem(this.devisLigneMedical.getDvsligPu() - var2);
         var4 = this.utilNombre.myRoundDevise(this.devisLigneMedical.getDvsligPuCnamgs() * (double)this.devisLigneMedical.getDvsligRemise() / 100.0D, this.structureLog.getStrdevise());
         this.devisLigneMedical.setDvsligPuCnamgs(this.devisLigneMedical.getDvsligPuCnamgs() - var4);
         this.devisLigneMedical.setDvsligRabais(0.0D);
      } else {
         this.devisLigneMedical.setDvsligPuRem(this.devisLigneMedical.getDvsligPu());
      }

      this.devisLigneMedical.setDvsligTotal(this.devisLigneMedical.getDvsligPuRem() * (double)this.devisLigneMedical.getDvsligQte());
      if (this.devisLigneMedical.getDvsligTauxTva() != 0.0F) {
         var2 = this.devisLigneMedical.getDvsligTotal() * (double)this.devisLigneMedical.getDvsligTauxTva() / 100.0D;
         this.devisLigneMedical.setDvsligTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.devisLigneMedical.setDvsligTaxe(0.0D);
      }

      this.devisLigneMedical.setDvsligPuAssurance(0.0D);
      this.devisLigneMedical.setDvsligSocieteHt(0.0D);
      this.devisLigneMedical.setDvsligSocieteTaxe(0.0D);
      this.devisLigneMedical.setDvsligAssuranceHt(0.0D);
      this.devisLigneMedical.setDvsligAssuranceTaxe(0.0D);
      this.devisLigneMedical.setDvsligComplementaireHt(0.0D);
      this.devisLigneMedical.setDvsligComplementaireTaxe(0.0D);
      this.devisLigneMedical.setDvsligPatientHt(0.0D);
      this.devisLigneMedical.setDvsligPatientTaxe(0.0D);
      this.devisEnteteMedical.setDvsIdEmployeur(0L);
      this.devisLigneMedical.setDvsligAssuranceHt(this.devisLigneMedical.getDvsligPuCnamgs() * (double)this.devisLigneMedical.getDvsligQte() * (double)this.var_pecCnamgs / 100.0D);
      if (this.devisLigneMedical.getDvsligTauxTva() != 0.0F) {
         var2 = this.devisLigneMedical.getDvsligAssuranceHt() * (double)this.devisLigneMedical.getDvsligTauxTva() / 100.0D;
         this.devisLigneMedical.setDvsligAssuranceTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      }

      var2 = this.devisLigneMedical.getDvsligTotal() - this.devisLigneMedical.getDvsligAssuranceHt();
      if (this.devisLigneMedical.getDvsligRabais() != 0.0D) {
         this.devisLigneMedical.setDvsligPatientHt(var2 - this.devisLigneMedical.getDvsligRabais());
         this.devisLigneMedical.setDvsligRemise(0.0F);
         if (this.devisLigneMedical.getDvsligPatientHt() < 0.0D) {
            this.devisLigneMedical.setDvsligPatientHt(var2);
            this.devisLigneMedical.setDvsligRabais(0.0D);
         }
      } else {
         this.devisLigneMedical.setDvsligPatientHt(var2);
      }

      if (this.devisLigneMedical.getDvsligTauxTva() != 0.0F) {
         var4 = this.devisLigneMedical.getDvsligPatientHt() * (double)this.devisLigneMedical.getDvsligTauxTva() / 100.0D;
         this.devisLigneMedical.setDvsligPatientTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
      }

   }

   public void avecCnamgsPriveComplementaire(Session var1) throws HibernateException, NamingException {
      if (this.devisLigneMedical.getDvsligPuCnamgs() > this.devisLigneMedical.getDvsligPu()) {
         this.devisLigneMedical.setDvsligPu(this.devisLigneMedical.getDvsligPuCnamgs());
      }

      double var2;
      double var4;
      if (this.devisLigneMedical.getDvsligRemise() != 0.0F) {
         var2 = this.utilNombre.myRoundDevise(this.devisLigneMedical.getDvsligPu() * (double)this.devisLigneMedical.getDvsligRemise() / 100.0D, this.structureLog.getStrdevise());
         this.devisLigneMedical.setDvsligPuRem(this.devisLigneMedical.getDvsligPu() - var2);
         var4 = this.utilNombre.myRoundDevise(this.devisLigneMedical.getDvsligPuCnamgs() * (double)this.devisLigneMedical.getDvsligRemise() / 100.0D, this.structureLog.getStrdevise());
         this.devisLigneMedical.setDvsligPuCnamgs(this.devisLigneMedical.getDvsligPuCnamgs() - var4);
         this.devisLigneMedical.setDvsligRabais(0.0D);
      } else {
         this.devisLigneMedical.setDvsligPuRem(this.devisLigneMedical.getDvsligPu());
      }

      this.devisLigneMedical.setDvsligTotal(this.devisLigneMedical.getDvsligPuRem() * (double)this.devisLigneMedical.getDvsligQte());
      if (this.devisLigneMedical.getDvsligTauxTva() != 0.0F) {
         var2 = this.devisLigneMedical.getDvsligTotal() * (double)this.devisLigneMedical.getDvsligTauxTva() / 100.0D;
         this.devisLigneMedical.setDvsligTaxe(this.utilNombre.myRoundDevise(var2, this.structureLog.getStrdevise()));
      } else {
         this.devisLigneMedical.setDvsligTaxe(0.0D);
      }

      this.devisLigneMedical.setDvsligPuAssurance(0.0D);
      this.devisLigneMedical.setDvsligSocieteHt(0.0D);
      this.devisLigneMedical.setDvsligSocieteTaxe(0.0D);
      this.devisLigneMedical.setDvsligAssuranceHt(0.0D);
      this.devisLigneMedical.setDvsligAssuranceTaxe(0.0D);
      this.devisLigneMedical.setDvsligComplementaireHt(0.0D);
      this.devisLigneMedical.setDvsligComplementaireTaxe(0.0D);
      this.devisLigneMedical.setDvsligPatientHt(0.0D);
      this.devisLigneMedical.setDvsligPatientTaxe(0.0D);
      this.devisEnteteMedical.setDvsIdEmployeur(0L);
      var2 = 0.0D;
      this.devisLigneMedical.setDvsligAssuranceHt(this.devisLigneMedical.getDvsligPuCnamgs() * (double)this.devisLigneMedical.getDvsligQte() * (double)this.var_pecCnamgs / 100.0D);
      if (this.devisLigneMedical.getDvsligTauxTva() != 0.0F) {
         var4 = this.devisLigneMedical.getDvsligAssuranceHt() * (double)this.devisLigneMedical.getDvsligTauxTva() / 100.0D;
         this.devisLigneMedical.setDvsligAssuranceTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
      }

      this.devisEnteteMedical.setDvsComplementaire(this.nomComplementaire);
      if (this.devisEnteteMedical.getDvsComplementaire() != 0L) {
         if (this.patientPecComplementaire == null) {
            this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.devisEnteteMedical.getDvsComplementaire(), 0, var1);
         }

         if (this.patientPecComplementaire != null) {
            this.devisEnteteMedical.setDvsIdComplementaire(this.patientPecComplementaire.getTiers().getTieid());
            var2 = this.devisLigneMedical.getDvsligTotal() - this.devisLigneMedical.getDvsligAssuranceHt();
            this.devisLigneMedical.setDvsligComplementaireHt(var2);
            if (this.devisLigneMedical.getDvsligTauxTva() != 0.0F) {
               var4 = this.devisLigneMedical.getDvsligComplementaireHt() * (double)this.devisLigneMedical.getDvsligTauxTva() / 100.0D;
               this.devisLigneMedical.setDvsligComplementaireTaxe(this.utilNombre.myRoundDevise(var4, this.structureLog.getStrdevise()));
            }
         }
      }

      var4 = this.devisLigneMedical.getDvsligTotal() - this.devisLigneMedical.getDvsligAssuranceHt() - this.devisLigneMedical.getDvsligComplementaireHt();
      if (this.devisLigneMedical.getDvsligRabais() != 0.0D) {
         this.devisLigneMedical.setDvsligPatientHt(var4 - this.devisLigneMedical.getDvsligRabais());
         this.devisLigneMedical.setDvsligRemise(0.0F);
         if (this.devisLigneMedical.getDvsligPatientHt() < 0.0D) {
            this.devisLigneMedical.setDvsligPatientHt(var4);
            this.devisLigneMedical.setDvsligRabais(0.0D);
         }
      } else {
         this.devisLigneMedical.setDvsligPatientHt(var4);
      }

      if (this.devisLigneMedical.getDvsligTauxTva() != 0.0F) {
         double var6 = this.devisLigneMedical.getDvsligPatientHt() * (double)this.devisLigneMedical.getDvsligTauxTva() / 100.0D;
         this.devisLigneMedical.setDvsligPatientTaxe(this.utilNombre.myRoundDevise(var6, this.structureLog.getStrdevise()));
      }

   }

   public void selectionActeListe() throws HibernateException, NamingException {
      this.var_aff_detail_prod = false;
      this.var_lettre = "";
      if (this.dataModelLaboratoire.isRowAvailable()) {
         this.devisLigneMedical = (DevisLigneMedical)this.dataModelLaboratoire.getRowData();
         if (this.devisLigneMedical.getDvsligLettre() != null && !this.devisLigneMedical.getDvsligLettre().isEmpty()) {
            this.lettreMedical = this.lettreMedicalDao.selectLettre(this.exercicesVentes.getExevteId(), this.devisLigneMedical.getDvsligLettre(), (Session)null);
            if (this.lettreMedical != null) {
               this.var_lettre = this.devisLigneMedical.getDvsligLettre() + ":" + this.lettreMedical.getLetLibelleFr();
            }
         }

         this.mesImputationLabo.clear();
         this.choixImputationLabo = false;
         this.produits = this.produitsMedicDao.chargeProduit(this.devisLigneMedical.getDvsligProduit(), (Session)null);
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
      this.devisLigneMedical = new DevisLigneMedical();
      this.var_lettre = "";
      this.var_aff_detail_prod = false;
      this.afficheButtActes = false;
      this.showModalPanelProduits = false;
   }

   public void supprimerActe() throws HibernateException, NamingException {
      if (this.devisLigneMedical != null) {
         this.devisLigneMedicalDao.delete(this.devisLigneMedical);
         this.lesLaboratoire.remove(this.devisLigneMedical);
         this.dataModelLaboratoire.setWrappedData(this.lesLaboratoire);
         this.calculTotaux();
         this.devisEnteteMedicalDao.modif(this.devisEnteteMedical);
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteMedical");
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

      this.devisLigneMedical.setDvsligProduit(this.produits.getProCode());
      this.devisLigneMedical.setDvsligLibelle(this.produits.getProLibClient());
      this.devisLigneMedical.setDvsligFamille(this.produits.getProVteCode() + ":" + this.produits.getProVteLib());
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
      if (this.devisLigneMedical.getDvsligQte() != 0.0F) {
         if (this.devisEnteteMedical.getDvsId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteMedical");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.tarifPatient(var1);
            this.calculPrix(var1);
            if (this.devisLigneMedical.getDvsligId() == 0L) {
               this.devisLigneMedical.setDevisEnteteMedical(this.devisEnteteMedical);
               this.devisLigneMedical = this.devisLigneMedicalDao.insert(this.devisLigneMedical, var1);
               this.lesLaboratoire.add(this.devisLigneMedical);
               this.dataModelLaboratoire.setWrappedData(this.lesLaboratoire);
            } else {
               this.devisLigneMedical = this.devisLigneMedicalDao.modif(this.devisLigneMedical, var1);
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
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteMedical");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.tarifPatient(var1);
         if (this.devisEnteteMedical.getDvsId() != 0L) {
            this.devisEnteteMedical = this.devisEnteteMedicalDao.modif(this.devisEnteteMedical, var1);
            if (this.lesLaboratoire.size() != 0) {
               for(int var3 = 0; var3 < this.lesLaboratoire.size(); ++var3) {
                  this.devisLigneMedical = (DevisLigneMedical)this.lesLaboratoire.get(var3);
                  this.calculPrix(var1);
                  this.devisLigneMedical = this.devisLigneMedicalDao.modif(this.devisLigneMedical, var1);
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
      this.devisEnteteMedical.setDvsFam(this.nomFamille);
      this.devisEnteteMedical.setDvsComplementaire(this.nomComplementaire);
      if (this.nomFamille >= 1L) {
         this.var_pecCnamgs = 0.0F;
         this.devisEnteteMedical.setDvsIdSociete(0L);
         this.devisEnteteMedical.setDvsIdAssurance(0L);
         this.devisEnteteMedical.setDvsIdComplementaire(0L);
         this.devisEnteteMedical.setDvsNomSociete("");
         this.devisEnteteMedical.setDvsNomAssurance("");
         this.devisEnteteMedical.setDvsNomComplemtaire("");
         this.devisEnteteMedical.setDvsIdEmployeur(0L);
         this.devisEnteteMedical.setDvsMatricule("");
         this.devisEnteteMedical.setDvsContratAssurance("");
         this.devisEnteteMedical.setDvsContratComplementaire("");
         if (this.patientPec == null) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.devisEnteteMedical.getDvsFam(), 0, var1);
         }

         if (this.patientPec != null) {
            if (this.patientPec.getPatpecType() != null && !this.patientPec.getPatpecType().isEmpty()) {
               if (!this.patientPec.getPatpecType().equals("Assurance") && !this.patientPec.getPatpecType().equals("IPM") && !this.patientPec.getPatpecType().equals("Programme Médical")) {
                  this.devisEnteteMedical.setDvsIdSociete(this.patientPec.getTiers().getTieid());
                  this.devisEnteteMedical.setDvsNomSociete(this.patientPec.getTiers().getTieraisonsocialenom());
                  this.devisEnteteMedical.setDvsMatricule(this.patientPec.getPatpecMatricule());
               } else {
                  this.var_pecAssurance = true;
                  this.devisEnteteMedical.setDvsIdAssurance(this.patientPec.getTiers().getTieid());
                  this.devisEnteteMedical.setDvsNomAssurance(this.patientPec.getTiers().getTieraisonsocialenom());
                  this.devisEnteteMedical.setDvsIdEmployeur(this.patientPec.getPatpecIdEmployeur());
                  this.devisEnteteMedical.setDvsContratAssurance(this.patientPec.getPatpecNumContrat());
               }
            }
         } else {
            this.devisEnteteMedical.setDvsFam(0L);
         }

         if (this.nomComplementaire >= 1L) {
            if (this.patientPecComplementaire == null) {
               this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.nomComplementaire, 0, var1);
            }

            if (this.patientPecComplementaire != null) {
               if (this.patientPecComplementaire.getPatpecType() != null && !this.patientPecComplementaire.getPatpecType().isEmpty() && (this.patientPecComplementaire.getPatpecType().equals("Mutuelle") || this.patientPecComplementaire.getPatpecType().equals("Complémentaire"))) {
                  this.devisEnteteMedical.setDvsIdComplementaire(this.patientPecComplementaire.getTiers().getTieid());
                  this.devisEnteteMedical.setDvsNomComplemtaire(this.patientPecComplementaire.getTiers().getTieraisonsocialenom());
                  this.devisEnteteMedical.setDvsContratComplementaire(this.patientPecComplementaire.getPatpecNumContrat());
               }
            } else {
               this.devisEnteteMedical.setDvsComplementaire(0L);
            }
         }
      } else if (this.nomFamille <= 0L) {
         this.devisEnteteMedical.setDvsComplementaire(0L);
         this.devisEnteteMedical.setDvsIdSociete(0L);
         this.devisEnteteMedical.setDvsIdAssurance(0L);
         this.devisEnteteMedical.setDvsIdComplementaire(0L);
         this.devisEnteteMedical.setDvsNomSociete("");
         this.devisEnteteMedical.setDvsNomAssurance("");
         this.devisEnteteMedical.setDvsNomComplemtaire("");
         this.devisEnteteMedical.setDvsIdEmployeur(0L);
         this.devisEnteteMedical.setDvsMatricule("");
         this.devisEnteteMedical.setDvsContratAssurance("");
         this.devisEnteteMedical.setDvsContratComplementaire("");
      }

   }

   public void consulterTarif() throws HibernateException, NamingException {
      if (this.devisEnteteMedical != null) {
         this.tarifPatient((Session)null);
         if (this.devisEnteteMedical.getDvsIdSociete() != 0L) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.patients, this.devisEnteteMedical.getDvsIdSociete(), (Session)null);
            if (this.patientPec != null) {
               this.showModalpanelPec = true;
            }
         } else if (this.devisEnteteMedical.getDvsIdAssurance() != 0L) {
            this.patientPec = this.patientPecDao.trouverPatientsPec(this.patients, this.devisEnteteMedical.getDvsIdAssurance(), (Session)null);
            if (this.patientPec != null) {
               if (this.devisEnteteMedical.getDvsIdComplementaire() != 0L) {
                  this.patientPecComplementaire = this.patientPecDao.trouverPatientsPec(this.patients, this.devisEnteteMedical.getDvsIdComplementaire(), (Session)null);
               }

               this.showModalpanelPec = true;
            }
         }
      }

   }

   public void fermerConsulterTarif() {
      this.showModalpanelPec = false;
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
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "document" + File.separator + "devis" + File.separator;
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatDevis.jpg");
            if (var4.exists()) {
               var3 = "formatDevis.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatDevis.jpg");
         if (var4.exists()) {
            var3 = "formatDevis.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      if (this.lesLaboratoire.size() != 0) {
         for(int var2 = 0; var2 < this.lesLaboratoire.size(); ++var2) {
            this.devisLigneMedical = (DevisLigneMedical)this.lesLaboratoire.get(var2);
            this.devisLigneMedical.setDevisEnteteMedical(this.devisEnteteMedical);
            var1.add(this.devisLigneMedical);
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.devisEnteteMedical.getTotalPatient(), this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(var1);
      return var3;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      return var2;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteMedical");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.devisEnteteMedical.getDvsDateImp() != null && this.devisEnteteMedical.getDvsEtat() != 0) {
            var2 = true;
         }

         this.devisEnteteMedical.setDvsDateImp(new Date());
         if (this.devisEnteteMedical.getDvsEtat() == 0 && this.devisEnteteMedical.getDvsEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 0) {
            this.devisEnteteMedical.setDvsEtat(1);
         }

         this.devisEnteteMedical.setDvsModeleImp(var1);
         this.devisEnteteMedical = this.devisEnteteMedicalDao.modif(this.devisEnteteMedical, var3);
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
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setRapport(var3);
            var1.setEntete("Impression devis");
            var1.setMontant_lettre(this.montant_lettre);
            var1.setPageGarde(this.conversionGarde());
            var1.setAnnexe1(this.conversionAnnexe1());
            var1.setAnnexe2(this.conversionAnnexe2());
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.devisEnteteMedical.getDvsEtat()));
            var1.setDuplicata("" + var11);
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.devisEnteteMedical.getDvsIdMedecin());
            var1.setIdCommercial(this.devisEnteteMedical.getDvsIdCreateur());
            var1.setTiersSelectionne((Tiers)null);
            var1.setNumDoc(this.devisEnteteMedical.getDvsNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.devisEnteteMedical.getDvsId());
            var1.setParc((Parc)null);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des devis");
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "medical" + File.separator + "liste" + File.separator + "devis" + File.separator);
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

         new DevisEnteteMedical();
         new DevisLigneMedical();
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEnteteMedical");
         String var6 = "";

         DevisEnteteMedical var14;
         for(int var7 = 0; var7 < this.lesConsultationEntete.size(); ++var7) {
            var14 = (DevisEnteteMedical)this.lesConsultationEntete.get(var7);
            if (var6.isEmpty()) {
               var6 = "'" + var14.getDvsNum() + "'";
            } else {
               var6 = var6 + ",'" + var14.getDvsNum() + "'";
            }
         }

         int var11;
         if (this.modeGraph == 20) {
            new ArrayList();
            List var18 = this.devisLigneMedicalDao.chargerLesLignesActes(var6, var5);
            if (var18.size() != 0) {
               String var19 = "";
               long var9 = 0L;
               boolean var17 = false;
               new DevisLigneMedical();
               int var13 = 0;

               while(true) {
                  if (var13 >= var18.size()) {
                     var1 = this.calculePourcentage((List)var1);
                     break;
                  }

                  DevisLigneMedical var20 = (DevisLigneMedical)var18.get(var13);
                  var19 = "";
                  var9 = 0L;
                  var11 = 0;
                  if (var20.getDvsligLibelle() == null || var20.getDvsligLibelle().isEmpty()) {
                     var20.setDvsligLibelle("ERREUR LIBELLE");
                  }

                  var19 = var20.getDvsligLibelle();
                  if (this.valQteGraph == 0) {
                     var9 = (long)var20.getDvsligTotal();
                  } else {
                     var9 = (long)this.utilNombre.myRound(var20.getDvsligQte(), 1);
                  }

                  if (this.timeDecoupage == 0) {
                     var11 = var20.getDevisEnteteMedical().getDvsDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var11 = var20.getDevisEnteteMedical().getDvsDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var20.getDevisEnteteMedical().getDvsDate().getMonth() + 1 >= 1 && var20.getDevisEnteteMedical().getDvsDate().getMonth() + 1 <= 3) {
                        var11 = 1;
                     } else if (var20.getDevisEnteteMedical().getDvsDate().getMonth() + 1 >= 4 && var20.getDevisEnteteMedical().getDvsDate().getMonth() + 1 <= 6) {
                        var11 = 2;
                     } else if (var20.getDevisEnteteMedical().getDvsDate().getMonth() + 1 >= 7 && var20.getDevisEnteteMedical().getDvsDate().getMonth() + 1 <= 9) {
                        var11 = 3;
                     } else if (var20.getDevisEnteteMedical().getDvsDate().getMonth() + 1 >= 10 && var20.getDevisEnteteMedical().getDvsDate().getMonth() + 1 <= 12) {
                        var11 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var20.getDevisEnteteMedical().getDvsDate().getMonth() + 1 >= 1 && var20.getDevisEnteteMedical().getDvsDate().getMonth() + 1 <= 6) {
                        var11 = 1;
                     } else if (var20.getDevisEnteteMedical().getDvsDate().getMonth() + 1 >= 7 && var20.getDevisEnteteMedical().getDvsDate().getMonth() + 1 <= 12) {
                        var11 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var11 = 1;
                  } else if (this.timeDecoupage == 5) {
                     var11 = var20.getDevisEnteteMedical().getDvsDate().getHours();
                  }

                  var1 = this.calculeListe((List)var1, var19, var11, var9);
                  ++var13;
               }
            }
         } else if (this.lesConsultationEntete.size() != 0) {
            String var15 = "";
            long var8 = 0L;
            boolean var10 = false;

            for(var11 = 0; var11 < this.lesConsultationEntete.size(); ++var11) {
               var14 = (DevisEnteteMedical)this.lesConsultationEntete.get(var11);
               var15 = "";
               var8 = 0L;
               int var16 = 0;
               if (this.modeGraph == 0) {
                  int var12 = var14.getDvsDate().getYear() + 1900;
                  var15 = "" + var12;
                  var8 = (long)var14.getDvsTotGeneral();
               } else if (this.modeGraph == 1) {
                  var15 = var14.getDvsMedecin();
                  var8 = (long)var14.getDvsTotGeneral();
               } else if (this.modeGraph == 2) {
                  var15 = var14.getDvsPrescripteur();
                  var8 = (long)var14.getDvsTotGeneral();
               } else if (this.modeGraph == 3) {
                  var15 = var14.getDvsNomPatient();
                  var8 = (long)var14.getDvsTotPatient();
               } else if (this.modeGraph == 4) {
                  var15 = var14.getDvsNomAssurance();
                  var8 = (long)var14.getDvsTotAssurance();
               } else if (this.modeGraph == 5) {
                  var15 = var14.getDvsNomComplemtaire();
                  var8 = (long)var14.getDvsTotComplmentaire();
               } else if (this.modeGraph == 6) {
                  var15 = var14.getDvsNomSociete();
                  var8 = (long)var14.getDvsTotSociete();
               } else if (this.modeGraph == 8) {
                  var15 = var14.getDvsProtocole();
                  var8 = (long)var14.getDvsTotGeneral();
               } else if (this.modeGraph == 9) {
                  var15 = var14.getDvsPathologie();
                  var8 = (long)var14.getDvsTotGeneral();
               } else if (this.modeGraph == 10) {
                  var15 = var14.getDvsService();
                  var8 = (long)var14.getDvsTotGeneral();
               }

               if (this.timeDecoupage == 0) {
                  var16 = var14.getDvsDate().getDate();
               } else if (this.timeDecoupage == 1) {
                  var16 = var14.getDvsDate().getMonth() + 1;
               } else if (this.timeDecoupage == 2) {
                  if (var14.getDvsDate().getMonth() + 1 >= 1 && var14.getDvsDate().getMonth() + 1 <= 3) {
                     var16 = 1;
                  } else if (var14.getDvsDate().getMonth() + 1 >= 4 && var14.getDvsDate().getMonth() + 1 <= 6) {
                     var16 = 2;
                  } else if (var14.getDvsDate().getMonth() + 1 >= 7 && var14.getDvsDate().getMonth() + 1 <= 9) {
                     var16 = 3;
                  } else if (var14.getDvsDate().getMonth() + 1 >= 10 && var14.getDvsDate().getMonth() + 1 <= 12) {
                     var16 = 4;
                  }
               } else if (this.timeDecoupage == 3) {
                  if (var14.getDvsDate().getMonth() + 1 >= 1 && var14.getDvsDate().getMonth() + 1 <= 6) {
                     var16 = 1;
                  } else if (var14.getDvsDate().getMonth() + 1 >= 7 && var14.getDvsDate().getMonth() + 1 <= 12) {
                     var16 = 2;
                  }
               } else if (this.timeDecoupage == 4) {
                  var16 = 1;
               } else if (this.timeDecoupage == 5) {
                  var16 = var14.getDvsDate().getHours();
               }

               var1 = this.calculeListe((List)var1, var15, var16, var8);
            }

            var1 = this.calculePourcentage((List)var1);
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

   public DevisEnteteMedical getDevisEnteteMedical() {
      return this.devisEnteteMedical;
   }

   public void setDevisEnteteMedical(DevisEnteteMedical var1) {
      this.devisEnteteMedical = var1;
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

   public boolean isVar_ajt() {
      return this.var_ajt;
   }

   public void setVar_ajt(boolean var1) {
      this.var_ajt = var1;
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

   public DevisLigneMedical getDevisLigneMedical() {
      return this.devisLigneMedical;
   }

   public void setDevisLigneMedical(DevisLigneMedical var1) {
      this.devisLigneMedical = var1;
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

   public Habilitation getHabilitation() {
      return this.habilitation;
   }

   public void setHabilitation(Habilitation var1) {
      this.habilitation = var1;
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
}
