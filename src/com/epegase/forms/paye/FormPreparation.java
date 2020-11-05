package com.epegase.forms.paye;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.BulletinLigne;
import com.epegase.systeme.classe.BulletinMois;
import com.epegase.systeme.classe.BulletinSalaire;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.FeuilleCalcul;
import com.epegase.systeme.classe.FeuilleCalculFormule;
import com.epegase.systeme.classe.FeuilleCalculRubrique;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.PlanPaye;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesCapitalisation;
import com.epegase.systeme.classe.SalariesConges;
import com.epegase.systeme.classe.SalariesContrats;
import com.epegase.systeme.classe.SalariesElements;
import com.epegase.systeme.classe.SalariesHistorique;
import com.epegase.systeme.classe.SalariesPrets;
import com.epegase.systeme.classe.SalariesPretsLignes;
import com.epegase.systeme.classe.SalariesVariables;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.ObjetBaseReference;
import com.epegase.systeme.dao.BulletinLigneDao;
import com.epegase.systeme.dao.BulletinMoisDao;
import com.epegase.systeme.dao.BulletinSalaireDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FeuilleCalculDao;
import com.epegase.systeme.dao.FeuilleCalculFormuleDao;
import com.epegase.systeme.dao.FeuilleCalculRubriqueDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.ModelesCourriersDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.PlanPayeDao;
import com.epegase.systeme.dao.SalariesCapitalisationDao;
import com.epegase.systeme.dao.SalariesCongesDao;
import com.epegase.systeme.dao.SalariesContratsDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.SalariesElementsDao;
import com.epegase.systeme.dao.SalariesGrhDao;
import com.epegase.systeme.dao.SalariesHistoriqueDao;
import com.epegase.systeme.dao.SalariesPretsDao;
import com.epegase.systeme.dao.SalariesPretsLignesDao;
import com.epegase.systeme.dao.SalariesVariablesDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.formbakingbeans.FormBakingBeanPaye;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilSms;
import com.epegase.systeme.util.UtilTrie;
import com.epegase.systeme.xml.LectureGrilleSalaire;
import com.epegase.systeme.xml.ObjetGrilleSalaire;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionPaye;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;

public class FormPreparation implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
   private List mesOnglets;
   private OptionPaye optionPaye;
   private ExercicesPaye exercicesPaye;
   private ExercicesPaye lastExoPaye;
   private EspionDao espionDao;
   private Habilitation habilitation;
   private CalculChrono calculChrono;
   private int var_nb_max = 100;
   private UtilDate utilDate = new UtilDate();
   private UtilNombre utilNombre = new UtilNombre();
   private boolean var_acc_identification = false;
   private boolean var_acc_complement = false;
   private boolean var_acc_familial = false;
   private boolean var_acc_contrat = false;
   private boolean var_acc_grh = false;
   private boolean var_acc_conges = false;
   private boolean var_acc_absences = false;
   private boolean var_acc_prets = false;
   private boolean var_acc_historiques = false;
   private boolean var_acc_bulletins = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private boolean accesInterim;
   private boolean accesPrets;
   private boolean accesContrats;
   private boolean accesAbsences;
   private List lesFeuilles = new ArrayList();
   private transient DataModel dataModelFeuilles = new ListDataModel();
   private UIDataTable extDTableFeuille = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionFeuille = new SimpleSelection();
   private List lesBulletinsMois = new ArrayList();
   private List lesPeriodes = new ArrayList();
   private transient DataModel dataModelPeriodes = new ListDataModel();
   private UIDataTable extDTablePeriode = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionPeriode = new SimpleSelection();
   private boolean afficheTJM = false;
   private int nbPeriode = 0;
   private boolean afficheService;
   private boolean afficheDepartement;
   private boolean afficheActivite;
   private boolean afficheCodesEmplois;
   private String var_nature_agent;
   private boolean var_affiche_nomJf = true;
   private Salaries salaries;
   private SalariesDao salariesDao;
   private List lesSalaries = new ArrayList();
   private transient DataModel datamodelSalaries = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean var_affiche_bouton = false;
   private boolean showModalVisuEtat = false;
   private boolean accesOrange;
   private List mesServiceItems;
   private String var_service_rec = "";
   private List mesDepartementItems = new ArrayList();
   private String var_departement_rec = "";
   private List mesProjetItems;
   private String var_projet_rec = "";
   private String var_feuille_rec = "";
   private String var_localisation_rec = "";
   private String var_agent_rec = "";
   private String var_activite_rec = "";
   private List mesClientsItems = new ArrayList();
   private long var_idclient_rec = 0L;
   private int selectionMode;
   private SalariesContrats salariesContrats;
   private SalariesContratsDao salariesContratsDao;
   private List mesModelesItems;
   private String var_code_modele;
   private List mesClesItems;
   private List mesActivitesItems;
   private List mesLocalisationItems;
   private SalariesConges salariesConges;
   private SalariesCongesDao salariesCongesDao;
   private SalariesConges salariesAbsences;
   private transient DataModel dataModelAbsences;
   private List lesSalariesAbsences;
   private boolean showModalPanelAbsences = false;
   private boolean var_affiche_absences = false;
   private int var_action_absences;
   private SalariesPrets salariesPrets;
   private SalariesPretsDao salariesPretsDao;
   private SalariesPretsLignes salariesPretsLignes;
   private SalariesPretsLignesDao salariesPretsLignesDao;
   private SalariesCapitalisation salariesCapitalisation;
   private SalariesCapitalisationDao salariesCapitalisationDao;
   private boolean capitalisationActive = false;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private boolean affListeDoc = false;
   private String format;
   private String impEmetteur;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private int var_choix_modele;
   private String nomModeleDocument;
   private String nomModeleListe;
   private List documentImpressionItems = new ArrayList();
   private List listeImpressionItems = new ArrayList();
   private boolean showModalPanelPrint = false;
   private boolean showModalPanelPrintPrep = false;
   private boolean showModalPanelPrintRub = false;
   private boolean showModalPanelPrintGene = false;
   private int cptMaxFlush = 100;
   private String libelleRepartition;
   private int modeRepartition;
   private FeuilleCalculRubriqueDao feuilleCalculRubriqueDao;
   private SalariesElements salariesElements = new SalariesElements();
   private SalariesElementsDao salariesElementsDao;
   private SalariesVariables salariesVariables;
   private SalariesVariablesDao salariesVariablesDao;
   private FeuilleCalcul feuilleCalcul;
   private FeuilleCalculDao feuilleCalculDao;
   private List lesContrats;
   private transient DataModel dataModelContrats;
   private List lesVariables;
   private transient DataModel dataModelVariables;
   private boolean showModalPanelVariable = false;
   private BulletinMoisDao bulletinMoisDao;
   private BulletinMois bulletinMois = new BulletinMois();
   private List lesVariablesItems;
   private List lesSalariesRubriques;
   private transient DataModel datamodelRubriques;
   private String variableSaisie;
   private List lesEcheances;
   private transient DataModel dataModelEcheances;
   private double totalPret;
   private float nbJourAbs;
   private float nbHeureRet;
   private boolean showModalPanelSalaries = false;
   private String var_niveau;
   private String var_classement;
   private String var_centre;
   private String var_securite;
   private String var_convention;
   private String var_grille;
   private String var_activite;
   private String var_service;
   private String var_cle1;
   private String var_cle2;
   private List mesNiveauxEmploisItems;
   private List mesCodesEmploisItems;
   private List mesClassementsItems;
   private List mesCentresImpotsItems;
   private List mesCentresSecuritesItems;
   private List mesConventionsItems;
   private List mesGrillesItems = new ArrayList();
   private List lesGrilles;
   private List lesSalariesGrh;
   private SalariesGrhDao salariesGrhDao;
   private int modeSelection;
   private String libelleSelection;
   private List lesSasiesHistoriques;
   private transient DataModel dataModelSasiesHistoriques = new ListDataModel();
   private boolean premierMois;
   private List lesCompteVrt = new ArrayList();
   private transient DataModel dataModelComptesVrt = new ListDataModel();
   private List lesImmatriculations = new ArrayList();
   private transient DataModel dataModelImmatriculation = new ListDataModel();
   private String libelle_securite;
   private String libelle_retraite;
   private boolean decoupageActivite;
   private boolean var_option_parc;
   private transient DataModel dataModelNb = new ListDataModel();
   private List lesNb = new ArrayList();
   private boolean showModalPanelEnfant = false;
   private boolean showModalPanelFemme = false;
   private List lesJours = new ArrayList();
   private int nbJours = 0;
   private List lesElements = new ArrayList();
   private transient DataModel dataModelLesElements = new ListDataModel();
   private boolean showModalPanelJournalier = false;
   private BulletinSalaire bulletinSalaire;
   private BulletinSalaireDao bulletinSalaireDao;
   private List lesBulletins;
   private transient DataModel dataModelLesBulletins;
   private BulletinLigne bulletinLigne;
   private BulletinLigneDao bulletinLigneDao;
   private List lesBulletinsLigne;
   private transient DataModel dataModelBulletinsLigne;
   private List lesRubriques;
   private FeuilleCalculRubrique feuilleCalculRubrique;
   private FeuilleCalculFormule feuilleCalculFormule;
   private FeuilleCalculFormuleDao feuilleCalculFormuleDao;
   private List lesformules;
   private List lesConges;
   private List lesAbsences;
   private List lesHistoriques = new ArrayList();
   private SalariesHistoriqueDao salariesHistoriqueDao;
   private Date d1;
   private Date d2;
   private String operateur;
   private double valeur;
   private double memoValeur;
   private boolean etatTest;
   private int ligneEnCours;
   private Date dateGeneration;
   private double base_imposable_fiscale;
   private double base_imposable_sociale;
   private List lesPretsLignes;
   private String modePlafond;
   private int var_si;
   private int type_conges;
   private boolean majLigne;
   private float nombreJourPresence;
   private ObjetBaseReference objetBaseReference;
   private List lesBasesReferences = new ArrayList();
   private boolean gestionBasesReference;
   private boolean preCalcul = false;
   private FeuilleCalculRubrique calculRubrique;
   private String var_info;
   private int var_currentValue;
   private boolean var_showBarProg = false;
   private boolean showModalPanelListeBulletin = false;
   private List listeBulletins;
   private transient DataModel dataModelListeBulletins;
   private String nomSalarie;
   private int choixCalcul;
   private double montantAtteindre;
   private double montantSursalaire;
   private int choixResultat;
   private List mesNatureAgentsItems;
   private int var_action_contrat;
   private List mesFeuillesItems;
   private List mesParcItems;
   private FormRecherche formRecherche;
   private double netAAtteindre;
   private String rubriqueEcart;
   private FormBakingBeanPaye formBakingBeanPaye;
   private boolean var_sursalaire;
   private boolean var_forfaitHeureSup;
   private boolean var_forfaitPrestataire;
   private boolean var_outillage;
   private boolean var_astreinte;
   private boolean var_redement;
   private boolean var_responsbilite;
   private boolean var_fonction;
   private boolean var_prm_transport;
   private boolean var_prm_logement;
   private boolean var_sujetion;
   private boolean var_exceptionnel;
   private boolean var_caisse;
   private boolean var_deplacement;
   private boolean var_logement;
   private boolean var_transport;
   private boolean var_kilometre;
   private boolean var_salissure;
   private boolean var_representation;
   private boolean var_diverse;
   private boolean var_indemResons;
   private boolean var_nourriture;
   private boolean var_avn_logement;
   private boolean var_avn_domesticite;
   private boolean var_avn_eau;
   private boolean var_avn_electricite;
   private boolean var_avn_nourriture;
   private boolean var_avn_vehicule;
   private boolean var_avn_telephone;
   private boolean showModalPanelSms = false;
   private String numeroMobile;
   private String messageSms;
   private List mesLotsItems = new ArrayList();
   private String var_lot_rec = "";
   private boolean showModalPanelRecopierVariables = false;
   private String moisChoisi;
   private List mesMoisNonclotures = new ArrayList();
   private boolean showModalPanelInformation = false;
   private String nomCreation;
   private String nomModification;

   public FormPreparation() throws IOException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
      this.salariesContratsDao = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
      this.salariesVariablesDao = new SalariesVariablesDao(this.baseLog, this.utilInitHibernate);
      this.feuilleCalculDao = new FeuilleCalculDao(this.baseLog, this.utilInitHibernate);
      this.feuilleCalculRubriqueDao = new FeuilleCalculRubriqueDao(this.baseLog, this.utilInitHibernate);
      this.feuilleCalculFormuleDao = new FeuilleCalculFormuleDao(this.baseLog, this.utilInitHibernate);
      this.salariesElementsDao = new SalariesElementsDao(this.baseLog, this.utilInitHibernate);
      this.bulletinMoisDao = new BulletinMoisDao(this.baseLog, this.utilInitHibernate);
      this.salariesPretsDao = new SalariesPretsDao(this.baseLog, this.utilInitHibernate);
      this.salariesPretsLignesDao = new SalariesPretsLignesDao(this.baseLog, this.utilInitHibernate);
      this.salariesCongesDao = new SalariesCongesDao(this.baseLog, this.utilInitHibernate);
      this.salariesGrhDao = new SalariesGrhDao(this.baseLog, this.utilInitHibernate);
      this.salariesHistoriqueDao = new SalariesHistoriqueDao(this.baseLog, this.utilInitHibernate);
      this.salariesCapitalisationDao = new SalariesCapitalisationDao(this.baseLog, this.utilInitHibernate);
   }

   public void initialisation(Session var1) throws HibernateException, NamingException {
      if (this.optionPaye.getNbLigneMax() != null && !this.optionPaye.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionPaye.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.optionPaye.getRubVersement() != null && !this.optionPaye.getRubVersement().isEmpty() && !this.optionPaye.getRubVersement().equals("null")) {
         this.capitalisationActive = true;
      } else {
         this.capitalisationActive = false;
      }

      this.modePlafond = this.optionPaye.getPlafond();
      if (this.modePlafond == null || this.modePlafond.isEmpty()) {
         this.modePlafond = "0";
      }

      this.dataModelFeuilles.setWrappedData(this.lesFeuilles);
      if (this.optionPaye.getModeTravail().equals("0")) {
         this.libelleRepartition = "Feuille";
         this.modeRepartition = 0;
      } else if (this.optionPaye.getModeTravail().equals("1")) {
         this.libelleRepartition = "Activité";
         this.modeRepartition = 1;
      } else if (this.optionPaye.getModeTravail().equals("2")) {
         this.libelleRepartition = "Service";
         this.modeRepartition = 2;
      } else if (this.optionPaye.getModeTravail().equals("3")) {
         this.libelleRepartition = "Projet";
         this.modeRepartition = 3;
      } else if (this.optionPaye.getModeTravail().equals("4")) {
         this.libelleRepartition = "Client";
         this.modeRepartition = 4;
      }

      this.mesDepartementItems.clear();
      DepartementDao var2 = new DepartementDao(this.baseLog, this.utilInitHibernate);
      this.mesDepartementItems = var2.chargerLesDepartementsItems(0, var1);
      this.afficheActivite = this.mesActivitesItems != null && this.mesActivitesItems.size() != 0;
      this.afficheService = this.mesServiceItems != null && this.mesServiceItems.size() != 0;
      this.afficheDepartement = this.mesDepartementItems != null && this.mesDepartementItems.size() != 0;
      this.accesPaiement();
      this.selectionMode();
      if (this.accesInterim) {
         this.mesServiceItems.clear();
      }

      if (this.mesCodesEmploisItems != null && this.mesCodesEmploisItems.size() != 0) {
         this.afficheCodesEmplois = true;
      } else {
         this.afficheCodesEmplois = false;
      }

   }

   public void accesResteintUser() {
   }

   public void accesResteintGroupe() {
      this.var_acc_identification = false;
      this.var_acc_complement = false;
      this.var_acc_familial = false;
      this.var_acc_contrat = false;
      this.var_acc_grh = false;
      this.var_acc_conges = false;
      this.var_acc_absences = false;
      this.var_acc_prets = false;
      this.var_acc_historiques = false;
      this.var_acc_bulletins = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("1")) {
               this.var_acc_identification = true;
            } else if (var1.getCode().equals("2")) {
               this.var_acc_complement = true;
            } else if (var1.getCode().equals("3")) {
               this.var_acc_familial = true;
            } else if (var1.getCode().equals("4")) {
               this.var_acc_contrat = true;
            } else if (var1.getCode().equals("5")) {
               this.var_acc_grh = true;
            } else if (var1.getCode().equals("6")) {
               this.var_acc_conges = true;
            } else if (var1.getCode().equals("7")) {
               this.var_acc_absences = true;
            } else if (var1.getCode().equals("8")) {
               this.var_acc_prets = true;
            } else if (var1.getCode().equals("9")) {
               this.var_acc_historiques = true;
            } else if (var1.getCode().equals("10")) {
               this.var_acc_bulletins = true;
            }
         }
      }

   }

   public void autorisationIdentification() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("1")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
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
            if (var1.getCode().equals("2")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationFamilial() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("3")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationContrat() throws HibernateException, NamingException {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("4")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

      if (this.calculChrono.verificationChrono(82, (Session)null)) {
         this.var_ajt = false;
         this.var_mod = false;
         this.var_sup = false;
         this.var_imp = false;
      }

   }

   public void autorisationGrh() throws HibernateException, NamingException {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("5")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationConges() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("6")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationAbsences() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("7")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationPrets() throws HibernateException, NamingException {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("8")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

      if (!this.calculChrono.verificationChrono(87, (Session)null)) {
         this.var_ajt = false;
         this.var_mod = false;
         this.var_sup = false;
         this.var_imp = false;
      }

      this.salariesPrets = null;
      this.salariesPretsLignes = null;
   }

   public void autorisationHistoriques() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("9")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationBulletins() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("10")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void afficheNomJf() {
      if (this.salaries.getSalGenre() == 0) {
         this.var_affiche_nomJf = true;
      } else {
         this.var_affiche_nomJf = false;
      }

   }

   public void calculeGenreCivil() {
      if (this.salaries.getSalCivilite() == null || this.salaries.getSalCivilite().isEmpty()) {
         this.salaries.setSalCivilite("Madame");
      }

      if (this.salaries.getSalCivilite().contains("Monsieur")) {
         this.salaries.setSalGenre(1);
      } else {
         this.salaries.setSalGenre(0);
      }

      this.afficheNomJf();
   }

   public String getUrlIp() {
      return StaticModePegase.getUrlIp();
   }

   public void recupererModelesItem() throws HibernateException, NamingException {
      this.mesModelesItems = new ArrayList();
      ModelesCourriersDao var1 = new ModelesCourriersDao(this.baseLog, this.utilInitHibernate);
      this.mesModelesItems = var1.chargerLesModeles(82, this.salariesContrats.getSalconType(), (Session)null);
   }

   public void verifHabilitation(int var1, Session var2) throws HibernateException, NamingException {
      this.habilitation = new Habilitation();
      HabilitationDao var3 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      this.habilitation = var3.existenceHabilitation(var1, var2);
   }

   public void calculPeriodes(Session var1) throws HibernateException, NamingException {
      this.nbPeriode = 0;
      Date var2 = this.exercicesPaye.getExepayDateDebut();
      GregorianCalendar var3 = new GregorianCalendar();
      var3.setTime(var2);
      Date var4 = this.exercicesPaye.getExepayDateFin();
      GregorianCalendar var5 = new GregorianCalendar();
      var5.setTime(var4);
      var3.add(2, -1);
      var5.add(2, -1);
      String var6 = null;

      while(var3.compareTo(var5) < 0) {
         var3.add(2, 1);
         Date var7 = var3.getTime();
         var6 = this.formatPeriode(var7);
         ++this.nbPeriode;
         this.lesPeriodes.add(var6);
      }

   }

   public void calculJours(Session var1) throws HibernateException, NamingException {
      this.nbJours = 0;
      Date var2 = this.exercicesPaye.getExepayDateDebut();
      GregorianCalendar var3 = new GregorianCalendar();
      var3.setTime(var2);
      Date var4 = this.exercicesPaye.getExepayDateFin();
      GregorianCalendar var5 = new GregorianCalendar();
      var5.setTime(var4);
      var3.add(5, -1);
      var5.add(5, -1);

      while(var3.compareTo(var5) < 0) {
         var3.add(5, 1);
         Date var6 = var3.getTime();
         ++this.nbJours;
         this.lesJours.add(var6);
      }

   }

   public String formatPeriode(Date var1) {
      SimpleDateFormat var2 = new SimpleDateFormat("dd-MM-yyyy");
      var2.format(var1);
      String var3 = "" + var2.format(var1);
      String[] var4 = var3.split("-");
      String var5 = var4[0];
      String var6 = var4[1];
      String var7 = var4[2];
      String var8 = var6 + ":" + var7;
      return var8;
   }

   public void accesPaiement() {
      if (this.structureLog.getStrcpteorange() != null && !this.structureLog.getStrcpteorange().isEmpty()) {
         this.accesOrange = true;
      } else {
         this.accesOrange = false;
      }

   }

   public void selectionMode() {
      this.selectionMode = 0;
      if (this.modeRepartition != 0 && this.modeRepartition == 4 && this.lesFeuilles.size() != 0) {
         for(int var1 = 0; var1 < this.lesFeuilles.size(); ++var1) {
            this.mesClientsItems.add(new SelectItem(((FeuilleCalcul)this.lesFeuilles.get(var1)).getFeuCode(), ((FeuilleCalcul)this.lesFeuilles.get(var1)).getFeuLibelleFr()));
         }
      }

      if (this.rechercheModule(80400)) {
         this.selectionMode = 4;
      } else if (this.rechercheModule(40300)) {
         this.selectionMode = 3;
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

   public void selectionFeuille() throws HibernateException, NamingException {
      this.lesVariablesItems = new ArrayList();
      this.lesSalariesRubriques = new ArrayList();
      this.datamodelRubriques = new ListDataModel();
      this.lesVariables = new ArrayList();
      this.dataModelVariables = new ListDataModel();
      this.lesRubriques = new ArrayList();
      this.lesEcheances = new ArrayList();
      this.dataModelEcheances = new ListDataModel();
      this.variableSaisie = "0";
      this.lesSalariesAbsences = new ArrayList();
      this.dataModelAbsences = new ListDataModel();
      this.lesSalariesGrh = new ArrayList();
      this.lesContrats = new ArrayList();
      this.dataModelContrats = new ListDataModel();
      this.lesSasiesHistoriques = new ArrayList();
      this.dataModelSasiesHistoriques = new ListDataModel();
      this.lesCompteVrt = new ArrayList();
      this.dataModelComptesVrt = new ListDataModel();
      this.lesImmatriculations = new ArrayList();
      this.dataModelImmatriculation = new ListDataModel();
      this.lesNb = new ArrayList();
      this.dataModelNb = new ListDataModel();
      this.simpleSelectionPeriode.clear();
      if (this.structureLog.getStrcodepays().equals("0077")) {
         this.libelle_securite = "N° C.N.S.S.";
      } else if (this.structureLog.getStrcodepays().equals("0138")) {
         this.libelle_securite = "N° I.N.P.S.";
      } else {
         this.libelle_securite = "N° Sécurité sociale";
      }

      if (this.structureLog.getStrcodepays().equals("0138")) {
         this.libelle_retraite = "N° Retraite";
      } else {
         this.libelle_retraite = "N° Retraite";
      }

      if (this.extDTableFeuille != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionFeuille.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTableFeuille.setRowKey(var3);
            if (this.extDTableFeuille.isRowAvailable()) {
               var1.add(this.extDTableFeuille.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.feuilleCalcul = (FeuilleCalcul)var1.get(0);
            this.afficheTJM = true;
            this.lesBulletinsMois.clear();
            Session var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "SelectionFeuille");
            Transaction var4 = null;

            try {
               var4 = var11.beginTransaction();
               if (this.feuilleCalcul.getFeuNature() != null && !this.feuilleCalcul.getFeuNature().isEmpty() && this.feuilleCalcul.getFeuNature().startsWith("04")) {
                  this.lesBulletinsMois = this.bulletinMoisDao.mesFeuillesJours(this.feuilleCalcul.getFeuCode(), this.modeRepartition, this.exercicesPaye, var11);
                  if (this.nbJours > this.lesBulletinsMois.size()) {
                     this.bulletinMoisDao.ajoutPeriodeJour(this.feuilleCalcul, this.modeRepartition, this.exercicesPaye, this.lesJours, var11);
                     this.lesBulletinsMois.clear();
                     this.lesBulletinsMois = this.bulletinMoisDao.mesFeuillesJours(this.feuilleCalcul.getFeuCode(), this.modeRepartition, this.exercicesPaye, var11);
                  }
               } else {
                  this.lesBulletinsMois = this.bulletinMoisDao.mesFeuillesmois(this.feuilleCalcul.getFeuCode(), this.modeRepartition, this.exercicesPaye, var11);
                  if (this.nbPeriode > this.lesBulletinsMois.size()) {
                     this.bulletinMoisDao.ajoutPeriode(this.feuilleCalcul, this.modeRepartition, this.exercicesPaye, this.lesPeriodes, var11);
                     this.lesBulletinsMois.clear();
                     this.lesBulletinsMois = this.bulletinMoisDao.mesFeuillesmois(this.feuilleCalcul.getFeuCode(), this.modeRepartition, this.exercicesPaye, var11);
                  }
               }

               this.dataModelPeriodes.setWrappedData(this.lesBulletinsMois);
               this.bulletinMois = null;
               if (this.modeRepartition == 0) {
                  this.calculeRubriqueContrat(var11);
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
         }
      }

   }

   public void calculeRubriqueContrat(Session var1) throws HibernateException, NamingException {
      this.var_sursalaire = false;
      this.var_forfaitHeureSup = false;
      this.var_forfaitPrestataire = false;
      this.var_outillage = false;
      this.var_astreinte = false;
      this.var_redement = false;
      this.var_responsbilite = false;
      this.var_fonction = false;
      this.var_prm_transport = false;
      this.var_prm_logement = false;
      this.var_sujetion = false;
      this.var_exceptionnel = false;
      this.var_caisse = false;
      this.var_deplacement = false;
      this.var_logement = false;
      this.var_transport = false;
      this.var_kilometre = false;
      this.var_salissure = false;
      this.var_representation = false;
      this.var_diverse = false;
      this.var_indemResons = false;
      this.var_nourriture = false;
      this.var_avn_logement = false;
      this.var_avn_domesticite = false;
      this.var_avn_eau = false;
      this.var_avn_electricite = false;
      this.var_avn_nourriture = false;
      this.var_avn_vehicule = false;
      this.var_avn_telephone = false;
      new ArrayList();
      List var2;
      if (this.modeRepartition == 0) {
         var2 = this.feuilleCalculFormuleDao.chargerFeuille(this.feuilleCalcul, var1);
      } else {
         if (this.salaries == null) {
            this.salaries = new Salaries();
            this.salaries.setSalFeuille(this.feuilleCalcul.getFeuCode());
         }

         var2 = this.feuilleCalculFormuleDao.chargerFeuille(this.salaries.getSalFeuille(), var1);
      }

      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.feuilleCalculFormule = (FeuilleCalculFormule)var2.get(var3);
            if (this.feuilleCalculFormule.getFeuilleCalculRubrique().isFeurubActif()) {
               if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000052")) {
                  this.var_sursalaire = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000084")) {
                  this.var_forfaitPrestataire = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000088")) {
                  this.var_forfaitHeureSup = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000089")) {
                  this.var_outillage = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000093")) {
                  this.var_astreinte = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000053")) {
                  this.var_redement = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000054")) {
                  this.var_responsbilite = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000055")) {
                  this.var_fonction = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000225")) {
                  this.var_prm_transport = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000226")) {
                  this.var_prm_logement = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000082")) {
                  this.var_sujetion = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000056")) {
                  this.var_caisse = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000059")) {
                  this.var_deplacement = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000058")) {
                  this.var_logement = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000057")) {
                  this.var_transport = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000060")) {
                  this.var_kilometre = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000061")) {
                  this.var_salissure = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000083")) {
                  this.var_representation = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000154")) {
                  this.var_diverse = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000156")) {
                  this.var_indemResons = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000157")) {
                  this.var_nourriture = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000062")) {
                  this.var_avn_logement = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000063")) {
                  this.var_avn_domesticite = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000065")) {
                  this.var_avn_eau = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000066")) {
                  this.var_avn_electricite = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000067")) {
                  this.var_avn_nourriture = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000068")) {
                  this.var_avn_vehicule = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000064")) {
                  this.var_avn_telephone = true;
               } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("M000147")) {
                  this.var_exceptionnel = true;
               }
            }
         }
      }

   }

   public void selectionPeriodeLight() throws HibernateException, NamingException, ParseException {
      if (this.feuilleCalcul != null && this.extDTablePeriode != null) {
         int var1 = 0;
         ArrayList var2 = new ArrayList();
         Iterator var3 = this.simpleSelectionPeriode.getKeys();

         while(var3.hasNext()) {
            Object var4 = var3.next();
            var1 = Integer.parseInt(var4.toString());
            this.extDTablePeriode.setRowKey(var4);
            if (this.extDTablePeriode.isRowAvailable()) {
               var2.add(this.extDTablePeriode.getRowData());
            }
         }

         for(int var5 = 0; var5 < this.lesBulletinsMois.size(); ++var5) {
            this.bulletinMois = (BulletinMois)this.lesBulletinsMois.get(var5);
            if (var5 == var1) {
               this.bulletinMois.setSelect(true);
            } else {
               this.bulletinMois.setSelect(false);
            }
         }

         if (var2.size() != 0) {
            this.bulletinMois = (BulletinMois)var2.get(0);
         }
      }

   }

   public void selectionPeriode() throws HibernateException, NamingException, ParseException {
      if (this.feuilleCalcul != null && this.extDTablePeriode != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionPeriode.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTablePeriode.setRowKey(var3);
            if (this.extDTablePeriode.isRowAvailable()) {
               var1.add(this.extDTablePeriode.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.bulletinMois = (BulletinMois)var1.get(0);
            int var12 = 0;
            if (this.lesBulletinsMois.size() != 0) {
               for(int var4 = 0; var4 < this.lesBulletinsMois.size(); ++var4) {
                  if (this.bulletinMois.getBulmenId() == ((BulletinMois)this.lesBulletinsMois.get(var4)).getBulmenId()) {
                     var12 = var4;
                     break;
                  }
               }
            }

            this.extDTable = new HtmlExtendedDataTable();
            this.simpleSelectionEntete = new SimpleSelection();
            if (var12 == 0) {
               this.premierMois = true;
            } else {
               this.premierMois = false;
            }

            Session var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            Transaction var5 = null;

            try {
               var5 = var13.beginTransaction();
               var13.setFlushMode(FlushMode.MANUAL);
               if (this.bulletinMois.getBulmenEtat() <= 2) {
                  this.bulletinMois.setBulmenUserIdJournal(this.usersLog.getUsrid());
                  this.bulletinMois.setBulmenOpenUserJournal(this.usersLog.getUsrPatronyme());
                  this.bulletinMois.setBulmenOpenJournal(1);
                  this.bulletinMois = this.bulletinMoisDao.majJournal(this.bulletinMois, var13);
                  var13.flush();
               }

               this.var_feuille_rec = "";
               this.var_activite_rec = "";
               this.var_localisation_rec = "";
               this.var_service_rec = "";
               this.var_projet_rec = "";
               this.var_idclient_rec = 0L;
               if (this.modeRepartition == 0) {
                  this.var_feuille_rec = this.bulletinMois.getBulmenFeuille();
               } else if (this.modeRepartition == 1) {
                  this.var_activite_rec = this.bulletinMois.getBulmenFeuille();
               } else if (this.modeRepartition == 2) {
                  this.var_service_rec = this.bulletinMois.getBulmenFeuille();
               } else if (this.modeRepartition == 3) {
                  this.var_projet_rec = this.bulletinMois.getBulmenFeuille();
               } else if (this.modeRepartition == 4) {
                  this.var_idclient_rec = Long.parseLong(this.bulletinMois.getBulmenFeuille());
               }

               this.chagerSalariePreparatoire(var13);
               var5.commit();
            } catch (HibernateException var10) {
               if (var5 != null) {
                  var5.rollback();
               }

               throw var10;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            this.var_affiche_bouton = false;
            if (this.feuilleCalcul.getFeuNature() != null && !this.feuilleCalcul.getFeuNature().isEmpty() && this.feuilleCalcul.getFeuNature().startsWith("04")) {
               this.var_action = 3;
            } else {
               this.var_action = 2;
            }
         }
      }

   }

   public void chagerSalariePreparatoire() throws ParseException, HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         var1.setFlushMode(FlushMode.MANUAL);
         this.chagerSalariePreparatoire(var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_affiche_bouton = false;
      if (this.feuilleCalcul.getFeuNature() != null && !this.feuilleCalcul.getFeuNature().isEmpty() && this.feuilleCalcul.getFeuNature().startsWith("04")) {
         this.var_action = 3;
      } else {
         this.var_action = 2;
      }

   }

   public void chagerSalariePreparatoire(Session var1) throws ParseException, HibernateException, NamingException {
      if (this.feuilleCalcul.getFeuNature() != null && !this.feuilleCalcul.getFeuNature().isEmpty() && this.feuilleCalcul.getFeuNature().startsWith("04")) {
         this.dateGeneration = this.bulletinMois.getBulmenJour();
         this.d1 = this.utilDate.datePremierJourMois(this.dateGeneration);
         this.d2 = this.utilDate.dateDernierJourMois(this.dateGeneration);
         this.lesSalaries.clear();
         this.extDTable = new HtmlExtendedDataTable();
         this.simpleSelectionEntete.clear();
         this.lesElements.clear();
         int var9 = Integer.parseInt(this.optionPaye.getTriAgents());
         new ArrayList();
         List var10 = this.salariesElementsDao.chargerlesElementsByJournaliers(this.dateGeneration, var9, this.bulletinMois.getBulmenFeuille(), var1);
         if (var10.size() != 0) {
            for(int var12 = 0; var12 < var10.size(); ++var12) {
               this.salariesElements = (SalariesElements)var10.get(var12);
               this.salaries = this.salariesElements.getSalaries();
               if (this.usersLog.getUsrPaye() == 0 || this.usersLog.getUsrPaye() != 0 && this.salaries.getSalProtege() == 0 || this.usersLog.getUsrPaye() == 5 && this.salaries.getSalProtege() == 1) {
                  this.salariesElements.setEffectue(true);
                  boolean var15 = false;

                  for(int var17 = 0; var17 < this.mesNatureAgentsItems.size(); ++var17) {
                     if (((SelectItem)this.mesNatureAgentsItems.get(var17)).getValue().equals(this.salaries.getSalNature())) {
                        var15 = true;
                        break;
                     }
                  }

                  if (var15) {
                     this.lesElements.add(this.salariesElements);
                  }
               }
            }
         }

         this.listeVariableSalaries(var1);
         this.dataModelLesElements.setWrappedData(this.lesElements);
      } else {
         String[] var2 = this.bulletinMois.getBulmenPeriode().split(":");
         this.dateGeneration = this.utilDate.stringToDateSQLLight(var2[1] + "-" + var2[0] + "-01");
         int var3;
         if (this.feuilleCalcul.getFeuDecale() != 0) {
            var3 = this.feuilleCalcul.getFeuDecale() * -1;
            Date var4 = this.utilDate.datePremierJourMois(this.dateGeneration);
            this.d1 = this.utilDate.datedevaleurTheo(var4, var3);
            Date var5 = this.utilDate.dateDernierJourMois(this.dateGeneration);
            this.d2 = this.utilDate.datedevaleurTheo(var5, var3);
         } else {
            this.d1 = this.utilDate.datePremierJourMois(this.dateGeneration);
            this.d2 = this.utilDate.dateDernierJourMois(this.dateGeneration);
         }

         this.lesSalaries.clear();
         this.lesContrats.clear();
         var3 = Integer.parseInt(this.optionPaye.getTriAgents());
         new ArrayList();
         List var11 = this.salariesContratsDao.listelesContratsActif(this.modeRepartition, var3, this.d1, this.d2, this.bulletinMois.getBulmenFeuille(), this.var_agent_rec, this.var_activite_rec, this.var_service_rec, this.var_departement_rec, this.var_localisation_rec, this.var_projet_rec, this.var_feuille_rec, this.var_idclient_rec, var1);
         if (var11.size() != 0) {
            for(int var13 = 0; var13 < var11.size(); ++var13) {
               this.salariesContrats = (SalariesContrats)var11.get(var13);
               this.salaries = this.salariesContrats.getSalaries();
               if ((this.usersLog.getUsrPaye() == 0 || this.usersLog.getUsrPaye() != 0 && this.salaries.getSalProtege() == 0 || this.usersLog.getUsrPaye() == 5 && this.salaries.getSalProtege() == 1) && this.salariesContrats.getSalconEtatH() == 1) {
                  boolean var6 = false;
                  if (this.salariesContrats != null) {
                     var6 = this.salariesElementsDao.testelesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), this.salariesContrats.getSalconNum(), var1);
                  } else {
                     var6 = this.salariesElementsDao.testelesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), "", var1);
                  }

                  boolean var7;
                  int var8;
                  if (var6) {
                     this.salariesContrats.setEffectue(true);
                     var7 = false;

                     for(var8 = 0; var8 < this.mesNatureAgentsItems.size(); ++var8) {
                        if (this.salariesContrats != null && ((SelectItem)this.mesNatureAgentsItems.get(var8)).getValue().equals(this.salariesContrats.getSalconType())) {
                           var7 = true;
                           break;
                        }
                     }

                     if (var7) {
                        this.lesContrats.add(this.salariesContrats);
                     }
                  } else if (this.salaries.getSalEtat() <= 1 || this.salaries.getSalEtat() == 9) {
                     this.salariesContrats.setEffectue(false);
                     var7 = false;

                     for(var8 = 0; var8 < this.mesNatureAgentsItems.size(); ++var8) {
                        if (this.salariesContrats != null && ((SelectItem)this.mesNatureAgentsItems.get(var8)).getValue().equals(this.salariesContrats.getSalconType())) {
                           var7 = true;
                           break;
                        }
                     }

                     if (var7) {
                        this.lesContrats.add(this.salariesContrats);
                     }
                  }
               }
            }
         }

         if (this.accesInterim) {
            this.mesServiceItems.clear();
            if (this.var_idclient_rec != 0L) {
               new ArrayList();
               SiteDao var16 = new SiteDao(this.baseLog, this.utilInitHibernate);
               List var14 = var16.chargerLesSitesListByClient(this.var_idclient_rec, var1);
               if (var14.size() != 0) {
                  for(int var18 = 0; var18 < var14.size(); ++var18) {
                     this.mesServiceItems.add(new SelectItem(((Site)var14.get(var18)).getSitCode() + ":" + ((Site)var14.get(var18)).getSitNomFr()));
                  }
               }
            }
         }

         this.listeVariableSalaries(var1);
         this.dataModelContrats.setWrappedData(this.lesContrats);
      }

      if (this.lesSalariesRubriques.size() != 0) {
         this.rechercheVariablesServices(var1);
      }

      if (this.feuilleCalcul.getFeuNature() == null || this.feuilleCalcul.getFeuNature().isEmpty() || !this.feuilleCalcul.getFeuNature().startsWith("04")) {
         if (this.lesSasiesHistoriques.size() != 0) {
            this.rechercheHistoriquesServices(var1);
         }

         if (this.lesCompteVrt.size() != 0) {
            this.rechercheCompteVrt(var1);
         }

         if (this.lesImmatriculations.size() != 0) {
            this.rechercheImmatriculation();
         }
      }

   }

   public void listeVariableSalaries(Session var1) throws HibernateException, NamingException {
      this.lesVariablesItems.clear();
      int var4;
      if (this.modeRepartition == 0) {
         if (this.feuilleCalcul != null) {
            new ArrayList();
            List var2 = this.feuilleCalculRubriqueDao.chargerRubriqueFeuilleActive(this.feuilleCalcul, this.exercicesPaye.getExepayId(), var1);
            if (var2.size() != 0) {
               new FeuilleCalculRubrique();

               for(var4 = 0; var4 < var2.size(); ++var4) {
                  FeuilleCalculRubrique var3 = (FeuilleCalculRubrique)var2.get(var4);
                  if (var3.isFeurubActif() && (var3.isFeurubColA() && var3.isFeurubVariableA() || var3.isFeurubColB() && var3.isFeurubVariableB() || var3.isFeurubColC() && var3.isFeurubVariableC() || var3.isFeurubColD() && var3.isFeurubVariableD() || var3.isFeurubColE() && var3.isFeurubVariableE()) && (this.optionPaye.getRubQuinzaine() == null || this.optionPaye.getRubQuinzaine().isEmpty() || this.optionPaye.getRubQuinzaine() != null && !this.optionPaye.getRubQuinzaine().isEmpty() && !this.optionPaye.getRubQuinzaine().equals(var3.getFeurubCode()))) {
                     this.lesVariablesItems.add(new SelectItem(var3.getFeurubCode(), var3.getFeurubCode() + ":" + var3.getPlanPaye().getPlpLibelleFR()));
                  }
               }
            }
         }
      } else {
         ArrayList var10 = new ArrayList();
         if (this.lesContrats.size() != 0) {
            boolean var11 = false;

            int var5;
            for(var4 = 0; var4 < this.lesContrats.size(); ++var4) {
               if (var10.size() == 0) {
                  var10.add(((SalariesContrats)this.lesContrats.get(var4)).getSalconFeuille());
               } else {
                  var11 = false;

                  for(var5 = 0; var5 < var10.size(); ++var5) {
                     if (((String)var10.get(var5)).toString().equals(((SalariesContrats)this.lesContrats.get(var4)).getSalconFeuille())) {
                        var11 = true;
                        break;
                     }
                  }
               }

               if (!var11) {
                  var10.add(((SalariesContrats)this.lesContrats.get(var4)).getSalconFeuille());
               }
            }

            if (var10.size() != 0) {
               new FeuilleCalcul();

               for(var5 = 0; var5 < var10.size(); ++var5) {
                  FeuilleCalcul var12 = this.feuilleCalculDao.chercherCode(((String)var10.get(var5)).toString(), this.exercicesPaye.getExepayId(), var1);
                  if (var12 != null) {
                     new ArrayList();
                     List var6 = this.feuilleCalculRubriqueDao.chargerRubriqueFeuilleActive(var12, this.exercicesPaye.getExepayId(), var1);
                     if (var6.size() != 0) {
                        new FeuilleCalculRubrique();

                        for(int var8 = 0; var8 < var6.size(); ++var8) {
                           FeuilleCalculRubrique var7 = (FeuilleCalculRubrique)var6.get(var8);
                           if (var7.isFeurubActif() && (var7.isFeurubColA() && var7.isFeurubVariableA() || var7.isFeurubColB() && var7.isFeurubVariableB() || var7.isFeurubColC() && var7.isFeurubVariableC() || var7.isFeurubColD() && var7.isFeurubVariableD() || var7.isFeurubColE() && var7.isFeurubVariableE())) {
                              if (this.lesVariablesItems.size() == 0) {
                                 if (this.optionPaye.getRubQuinzaine() == null || this.optionPaye.getRubQuinzaine().isEmpty() || this.optionPaye.getRubQuinzaine() != null && !this.optionPaye.getRubQuinzaine().isEmpty() && !this.optionPaye.getRubQuinzaine().equals(var7.getFeurubCode())) {
                                    this.lesVariablesItems.add(new SelectItem(var7.getFeurubCode(), var7.getFeurubCode() + ":" + var7.getPlanPaye().getPlpLibelleFR()));
                                 }
                              } else {
                                 var11 = false;

                                 for(int var9 = 0; var9 < this.lesVariablesItems.size(); ++var9) {
                                    if (((SelectItem)this.lesVariablesItems.get(var9)).getValue().toString().equals(var7.getFeurubCode())) {
                                       var11 = true;
                                       break;
                                    }
                                 }
                              }

                              if (!var11 && (this.optionPaye.getRubQuinzaine() == null || this.optionPaye.getRubQuinzaine().isEmpty() || this.optionPaye.getRubQuinzaine() != null && !this.optionPaye.getRubQuinzaine().isEmpty() && !this.optionPaye.getRubQuinzaine().equals(var7.getFeurubCode()))) {
                                 this.lesVariablesItems.add(new SelectItem(var7.getFeurubCode(), var7.getFeurubCode() + ":" + var7.getPlanPaye().getPlpLibelleFR()));
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public void rechercheVariables() throws HibernateException, NamingException {
      this.lesSalariesRubriques.clear();
      if (this.variableSaisie != null && !this.variableSaisie.isEmpty() && !this.variableSaisie.equals("0")) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            if (this.modeRepartition == 0) {
               this.rechercheVariablesServices(var1);
            } else if (this.modeRepartition == 1) {
               this.rechercheVariablesServices(var1);
            } else if (this.modeRepartition == 2) {
               this.rechercheVariablesServices(var1);
            } else if (this.modeRepartition == 3) {
               this.rechercheVariablesProjets(var1);
            } else if (this.modeRepartition == 4) {
               this.rechercheVariablesServices(var1);
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

      this.datamodelRubriques.setWrappedData(this.lesSalariesRubriques);
   }

   public void rechercheVariablesServices(Session var1) throws HibernateException, NamingException {
      this.lesSalariesRubriques.clear();
      if (this.variableSaisie != null && !this.variableSaisie.isEmpty() && !this.variableSaisie.equals("0")) {
         new PlanPaye();
         PlanPayeDao var3 = new PlanPayeDao(this.baseLog, this.utilInitHibernate);
         PlanPaye var2 = var3.chercherCode(this.variableSaisie, this.exercicesPaye.getExepayId(), var1);
         if (var2 != null) {
            ArrayList var4 = new ArrayList();
            int var6;
            String var7;
            if (this.lesContrats.size() != 0) {
               boolean var5 = false;

               for(var6 = 0; var6 < this.lesContrats.size(); ++var6) {
                  var7 = ((SalariesContrats)this.lesContrats.get(var6)).getSalconFeuille();
                  if (var7 != null && !var7.isEmpty()) {
                     if (var4.size() == 0) {
                        var4.add(var7);
                     } else {
                        var5 = false;

                        for(int var8 = 0; var8 < var4.size(); ++var8) {
                           if (((String)var4.get(var8)).toString().equals(var7)) {
                              var5 = true;
                              break;
                           }
                        }

                        if (!var5) {
                           var4.add(var7);
                        }
                     }
                  }
               }
            }

            if (var4.size() != 0) {
               this.lesSalariesRubriques.clear();
               Object var17 = new ArrayList();

               for(var6 = 0; var6 < var4.size(); ++var6) {
                  var7 = ((String)var4.get(var6)).toString();
                  this.feuilleCalculRubrique = this.feuilleCalculRubriqueDao.chargerRubriqueFeuille((String)var7, this.variableSaisie, 1, var1);
                  if (this.feuilleCalculRubrique != null) {
                     if (!this.feuilleCalculRubrique.isFeurubVariableA()) {
                        this.feuilleCalculRubrique.setFeurubVariableA(false);
                     }

                     if (!this.feuilleCalculRubrique.isFeurubVariableB()) {
                        this.feuilleCalculRubrique.setFeurubVariableB(false);
                     }

                     if (!this.feuilleCalculRubrique.isFeurubVariableC()) {
                        this.feuilleCalculRubrique.setFeurubVariableC(false);
                     }

                     if (!this.feuilleCalculRubrique.isFeurubVariableD()) {
                        this.feuilleCalculRubrique.setFeurubVariableD(false);
                     }

                     if (!this.feuilleCalculRubrique.isFeurubVariableE()) {
                        this.feuilleCalculRubrique.setFeurubVariableE(false);
                     }

                     long var18 = 0L;
                     if (this.modeRepartition == 0) {
                        var17 = this.salariesVariablesDao.chargerlesVariablesFeuille(this.bulletinMois.getBulmenPeriode(), var7, this.variableSaisie, "", "", "", 0L, this.modeRepartition, var1);
                     } else if (this.modeRepartition == 1) {
                        var17 = this.salariesVariablesDao.chargerlesVariablesFeuille(this.bulletinMois.getBulmenPeriode(), var7, this.variableSaisie, this.var_activite_rec, "", "", 0L, this.modeRepartition, var1);
                     } else if (this.modeRepartition == 2) {
                        var17 = this.salariesVariablesDao.chargerlesVariablesFeuille(this.bulletinMois.getBulmenPeriode(), var7, this.variableSaisie, "", this.var_service_rec, "", 0L, this.modeRepartition, var1);
                     } else if (this.modeRepartition == 3) {
                        var17 = this.salariesVariablesDao.chargerlesVariablesFeuille(this.bulletinMois.getBulmenPeriode(), var7, this.variableSaisie, "", "", this.var_projet_rec, 0L, this.modeRepartition, var1);
                     } else if (this.modeRepartition == 4) {
                        this.salariesContrats = this.salariesContratsDao.chargerlesContratsActifByFeuille(var7, var1);
                        if (this.salariesContrats != null) {
                           var18 = this.salariesContrats.getSalconIdTiers();
                           var17 = this.salariesVariablesDao.chargerlesVariablesFeuille(this.bulletinMois.getBulmenPeriode(), var7, this.variableSaisie, "", "", "", var18, this.modeRepartition, var1);
                        }
                     }

                     new Salaries();

                     for(int var11 = 0; var11 < this.lesContrats.size(); ++var11) {
                        Salaries var10 = ((SalariesContrats)this.lesContrats.get(var11)).getSalaries();
                        if (this.modeRepartition != 4 && ((SalariesContrats)this.lesContrats.get(var11)).getSalconFeuille() != null && !((SalariesContrats)this.lesContrats.get(var11)).getSalconFeuille().isEmpty() && ((SalariesContrats)this.lesContrats.get(var11)).getSalconFeuille().equals(var7) || this.modeRepartition == 4 && ((SalariesContrats)this.lesContrats.get(var11)).getSalconIdTiers() == var18 && ((SalariesContrats)this.lesContrats.get(var11)).getSalconFeuille() != null && !((SalariesContrats)this.lesContrats.get(var11)).getSalconFeuille().isEmpty() && ((SalariesContrats)this.lesContrats.get(var11)).getSalconFeuille().equals(var7)) {
                           SalariesVariables var12 = new SalariesVariables();
                           boolean var13 = false;

                           for(int var14 = 0; var14 < ((List)var17).size(); ++var14) {
                              var12 = (SalariesVariables)((List)var17).get(var14);
                              if (var10.getSalId() == var12.getSalaries().getSalId()) {
                                 var12.setSalvarContrat(((SalariesContrats)this.lesContrats.get(var11)).getSalconNum());
                                 var12.setSalvarVariableA(this.feuilleCalculRubrique.isFeurubVariableA());
                                 var12.setSalvarVariableB(this.feuilleCalculRubrique.isFeurubVariableB());
                                 var12.setSalvarVariableC(this.feuilleCalculRubrique.isFeurubVariableC());
                                 var12.setSalvarVariableD(this.feuilleCalculRubrique.isFeurubVariableD());
                                 var12.setSalvarVariableE(this.feuilleCalculRubrique.isFeurubVariableE());
                                 var13 = true;
                                 break;
                              }
                           }

                           if (!var13) {
                              this.salariesVariables = new SalariesVariables();
                              this.salariesVariables.setPlanPaye(var2);
                              this.salariesVariables.setSalaries(var10);
                              this.salariesVariables.setSalvarContrat(((SalariesContrats)this.lesContrats.get(var11)).getSalconNum());
                              this.salariesVariables.setSalvarCode(this.variableSaisie);
                              this.salariesVariables.setSalvarPeriode(this.bulletinMois.getBulmenPeriode());
                              this.salariesVariables.setSalvarFeuille(this.bulletinMois.getBulmenFeuille());
                              this.salariesVariables.setSalvarValeurColA(0.0D);
                              this.salariesVariables.setSalvarValeurColB(0.0D);
                              this.salariesVariables.setSalvarValeurColC(0.0D);
                              this.salariesVariables.setSalvarValeurColD(0.0D);
                              this.salariesVariables.setSalvarValeurColE(0.0D);
                              this.salariesVariables.setSalvarVariableA(this.feuilleCalculRubrique.isFeurubVariableA());
                              this.salariesVariables.setSalvarVariableB(this.feuilleCalculRubrique.isFeurubVariableB());
                              this.salariesVariables.setSalvarVariableC(this.feuilleCalculRubrique.isFeurubVariableC());
                              this.salariesVariables.setSalvarVariableD(this.feuilleCalculRubrique.isFeurubVariableD());
                              this.salariesVariables.setSalvarVariableE(this.feuilleCalculRubrique.isFeurubVariableE());
                              this.salariesVariables = this.salariesVariablesDao.insert(this.salariesVariables, var1);
                              var1.flush();
                              this.lesSalariesRubriques.add(this.salariesVariables);
                           } else if (var12.isSalvarVariableA() == this.feuilleCalculRubrique.isFeurubVariableA() && var12.isSalvarVariableB() == this.feuilleCalculRubrique.isFeurubVariableB() && var12.isSalvarVariableC() == this.feuilleCalculRubrique.isFeurubVariableC() && var12.isSalvarVariableD() == this.feuilleCalculRubrique.isFeurubVariableD() && var12.isSalvarVariableE() == this.feuilleCalculRubrique.isFeurubVariableE()) {
                              this.lesSalariesRubriques.add(var12);
                           } else {
                              this.salariesVariables = var12;
                              this.salariesVariables.setPlanPaye(var2);
                              this.salariesVariables.setSalaries(var10);
                              this.salariesVariables.setSalvarCode(this.variableSaisie);
                              this.salariesVariables.setSalvarPeriode(this.bulletinMois.getBulmenPeriode());
                              this.salariesVariables.setSalvarFeuille(this.bulletinMois.getBulmenFeuille());
                              this.salariesVariables.setSalvarValeurColA(0.0D);
                              this.salariesVariables.setSalvarValeurColB(0.0D);
                              this.salariesVariables.setSalvarValeurColC(0.0D);
                              this.salariesVariables.setSalvarValeurColD(0.0D);
                              this.salariesVariables.setSalvarValeurColE(0.0D);
                              this.salariesVariables.setSalvarVariableA(this.feuilleCalculRubrique.isFeurubVariableA());
                              this.salariesVariables.setSalvarVariableB(this.feuilleCalculRubrique.isFeurubVariableB());
                              this.salariesVariables.setSalvarVariableC(this.feuilleCalculRubrique.isFeurubVariableC());
                              this.salariesVariables.setSalvarVariableD(this.feuilleCalculRubrique.isFeurubVariableD());
                              this.salariesVariables.setSalvarVariableE(this.feuilleCalculRubrique.isFeurubVariableE());
                              this.salariesVariables = this.salariesVariablesDao.modif(this.salariesVariables, var1);
                              var1.flush();
                              this.lesSalariesRubriques.add(this.salariesVariables);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      if (this.lesSalariesRubriques.size() != 0) {
         for(int var15 = 0; var15 < this.lesSalariesRubriques.size(); ++var15) {
            this.salariesVariables = (SalariesVariables)this.lesSalariesRubriques.get(var15);
            if (this.salariesVariables.getSalaries().getSalEtat() == 9) {
               this.salariesVariables.setSalvarVariableA(false);
               this.salariesVariables.setSalvarVariableB(false);
               this.salariesVariables.setSalvarVariableC(false);
               this.salariesVariables.setSalvarVariableD(false);
               this.salariesVariables.setSalvarVariableE(false);
            }
         }
      }

      UtilTrie var16 = new UtilTrie();
      if (this.optionPaye.getTriAgents().equals("0")) {
         this.lesSalariesRubriques = var16.triListeTransfertMatricule(this.lesSalariesRubriques);
      } else {
         this.lesSalariesRubriques = var16.triListeTransfertPatronyme(this.lesSalariesRubriques);
      }

      this.datamodelRubriques.setWrappedData(this.lesSalariesRubriques);
   }

   public void rechercheVariablesProjets(Session var1) throws HibernateException, NamingException {
      this.lesSalariesRubriques.clear();
      if (this.variableSaisie != null && !this.variableSaisie.isEmpty() && !this.variableSaisie.equals("0")) {
         new PlanPaye();
         PlanPayeDao var3 = new PlanPayeDao(this.baseLog, this.utilInitHibernate);
         PlanPaye var2 = var3.chercherCode(this.variableSaisie, this.exercicesPaye.getExepayId(), var1);
         if (var2 != null) {
            this.feuilleCalculRubrique = this.feuilleCalculRubriqueDao.chargerRubriqueFeuille((FeuilleCalcul)this.feuilleCalcul, this.variableSaisie, 1, var1);
            if (this.feuilleCalculRubrique != null) {
               if (!this.feuilleCalculRubrique.isFeurubVariableA()) {
                  this.feuilleCalculRubrique.setFeurubVariableA(false);
               }

               if (!this.feuilleCalculRubrique.isFeurubVariableB()) {
                  this.feuilleCalculRubrique.setFeurubVariableB(false);
               }

               if (!this.feuilleCalculRubrique.isFeurubVariableC()) {
                  this.feuilleCalculRubrique.setFeurubVariableC(false);
               }

               if (!this.feuilleCalculRubrique.isFeurubVariableD()) {
                  this.feuilleCalculRubrique.setFeurubVariableD(false);
               }

               if (!this.feuilleCalculRubrique.isFeurubVariableE()) {
                  this.feuilleCalculRubrique.setFeurubVariableE(false);
               }

               this.lesSalariesRubriques.clear();
               String var4 = "";

               for(int var5 = 0; var5 < this.lesContrats.size(); ++var5) {
                  if (var4 != null && !var4.isEmpty()) {
                     var4 = var4 + "," + "'" + ((SalariesContrats)this.lesContrats.get(var5)).getSalconNum() + "'";
                  } else {
                     var4 = "'" + ((SalariesContrats)this.lesContrats.get(var5)).getSalconNum() + "'";
                  }
               }

               var4 = "(" + var4 + ")";
               this.lesSalariesRubriques = this.salariesVariablesDao.chargerlesVariablesFeuilleProjets(this.bulletinMois.getBulmenPeriode(), this.bulletinMois.getBulmenFeuille(), this.variableSaisie, var4, var1);
               new Salaries();

               for(int var6 = 0; var6 < this.lesContrats.size(); ++var6) {
                  Salaries var12 = ((SalariesContrats)this.lesContrats.get(var6)).getSalaries();
                  SalariesVariables var7 = new SalariesVariables();
                  boolean var8 = false;

                  for(int var9 = 0; var9 < this.lesSalariesRubriques.size(); ++var9) {
                     var7 = (SalariesVariables)this.lesSalariesRubriques.get(var9);
                     if (var12.getSalId() == var7.getSalaries().getSalId()) {
                        var8 = true;
                        break;
                     }
                  }

                  if (!var8) {
                     this.salariesVariables = new SalariesVariables();
                     this.salariesVariables.setPlanPaye(var2);
                     this.salariesVariables.setSalaries(var12);
                     this.salariesVariables.setSalvarContrat(((SalariesContrats)this.lesContrats.get(var6)).getSalconNum());
                     this.salariesVariables.setSalvarCode(this.variableSaisie);
                     this.salariesVariables.setSalvarPeriode(this.bulletinMois.getBulmenPeriode());
                     this.salariesVariables.setSalvarFeuille(this.bulletinMois.getBulmenFeuille());
                     this.salariesVariables.setSalvarValeurColA(0.0D);
                     this.salariesVariables.setSalvarValeurColB(0.0D);
                     this.salariesVariables.setSalvarValeurColC(0.0D);
                     this.salariesVariables.setSalvarValeurColD(0.0D);
                     this.salariesVariables.setSalvarValeurColE(0.0D);
                     this.salariesVariables.setSalvarVariableA(this.feuilleCalculRubrique.isFeurubVariableA());
                     this.salariesVariables.setSalvarVariableB(this.feuilleCalculRubrique.isFeurubVariableB());
                     this.salariesVariables.setSalvarVariableC(this.feuilleCalculRubrique.isFeurubVariableC());
                     this.salariesVariables.setSalvarVariableD(this.feuilleCalculRubrique.isFeurubVariableD());
                     this.salariesVariables.setSalvarVariableE(this.feuilleCalculRubrique.isFeurubVariableE());
                     this.salariesVariables = this.salariesVariablesDao.insert(this.salariesVariables, var1);
                     var1.flush();
                     this.lesSalariesRubriques.add(this.salariesVariables);
                  } else if (var7.isSalvarVariableA() != this.feuilleCalculRubrique.isFeurubVariableA() || var7.isSalvarVariableB() != this.feuilleCalculRubrique.isFeurubVariableB() || var7.isSalvarVariableC() != this.feuilleCalculRubrique.isFeurubVariableC() || var7.isSalvarVariableD() != this.feuilleCalculRubrique.isFeurubVariableD() || var7.isSalvarVariableE() != this.feuilleCalculRubrique.isFeurubVariableE()) {
                     this.salariesVariables = var7;
                     this.salariesVariables.setPlanPaye(var2);
                     this.salariesVariables.setSalaries(var12);
                     this.salariesVariables.setSalvarContrat(((SalariesContrats)this.lesContrats.get(var6)).getSalconNum());
                     this.salariesVariables.setSalvarCode(this.variableSaisie);
                     this.salariesVariables.setSalvarPeriode(this.bulletinMois.getBulmenPeriode());
                     this.salariesVariables.setSalvarFeuille(this.bulletinMois.getBulmenFeuille());
                     this.salariesVariables.setSalvarValeurColA(0.0D);
                     this.salariesVariables.setSalvarValeurColB(0.0D);
                     this.salariesVariables.setSalvarValeurColC(0.0D);
                     this.salariesVariables.setSalvarValeurColD(0.0D);
                     this.salariesVariables.setSalvarValeurColE(0.0D);
                     this.salariesVariables.setSalvarVariableA(this.feuilleCalculRubrique.isFeurubVariableA());
                     this.salariesVariables.setSalvarVariableB(this.feuilleCalculRubrique.isFeurubVariableB());
                     this.salariesVariables.setSalvarVariableC(this.feuilleCalculRubrique.isFeurubVariableC());
                     this.salariesVariables.setSalvarVariableD(this.feuilleCalculRubrique.isFeurubVariableD());
                     this.salariesVariables.setSalvarVariableE(this.feuilleCalculRubrique.isFeurubVariableE());
                     this.salariesVariables = this.salariesVariablesDao.modif(this.salariesVariables, var1);
                     var1.flush();
                  }
               }
            }
         }
      }

      if (this.lesSalariesRubriques.size() != 0) {
         for(int var10 = 0; var10 < this.lesSalariesRubriques.size(); ++var10) {
            this.salariesVariables = (SalariesVariables)this.lesSalariesRubriques.get(var10);
            if (this.salariesVariables.getSalaries().getSalEtat() == 9) {
               this.salariesVariables.setSalvarVariableA(false);
               this.salariesVariables.setSalvarVariableB(false);
               this.salariesVariables.setSalvarVariableC(false);
               this.salariesVariables.setSalvarVariableD(false);
               this.salariesVariables.setSalvarVariableE(false);
            }
         }
      }

      UtilTrie var11 = new UtilTrie();
      if (this.optionPaye.getTriAgents().equals("0")) {
         this.lesSalariesRubriques = var11.triListeTransfertMatricule(this.lesSalariesRubriques);
      } else {
         this.lesSalariesRubriques = var11.triListeTransfertPatronyme(this.lesSalariesRubriques);
      }

      this.datamodelRubriques.setWrappedData(this.lesSalariesRubriques);
   }

   public void rechercheHistoriques() throws HibernateException, NamingException {
      this.lesSasiesHistoriques.clear();
      if (this.lesContrats.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.rechercheHistoriquesServices(var1);
         this.utilInitHibernate.closeSession();
      }

      this.dataModelSasiesHistoriques.setWrappedData(this.lesSasiesHistoriques);
   }

   public void rechercheHistoriquesServices(Session var1) throws HibernateException, NamingException {
      this.lesSasiesHistoriques.clear();
      if (this.lesContrats.size() != 0) {
         new ArrayList();

         for(int var3 = 0; var3 < this.lesContrats.size(); ++var3) {
            this.salariesContrats = (SalariesContrats)this.lesContrats.get(var3);
            this.salaries = this.salariesContrats.getSalaries();
            List var2;
            if (this.salariesContrats != null) {
               var2 = this.salariesHistoriqueDao.chargerlesHistoriquesBySalaries(this.salaries, this.salariesContrats.getSalconNum(), this.exercicesPaye, var1);
            } else {
               var2 = this.salariesHistoriqueDao.chargerlesHistoriquesBySalaries(this.salaries, "", this.exercicesPaye, var1);
            }

            if (var2.size() != 0) {
               this.salariesContrats.setHistoAdm(0.0D);
               this.salariesContrats.setHistoBrut(0.0D);
               this.salariesContrats.setHistoNbjs(0.0D);
               this.salariesContrats.setHistoCp(0.0D);

               for(int var4 = 0; var4 < var2.size(); ++var4) {
                  if (((SalariesHistorique)var2.get(var4)).getSalhisCode() != null && !((SalariesHistorique)var2.get(var4)).getSalhisCode().isEmpty()) {
                     if (((SalariesHistorique)var2.get(var4)).getSalhisCode().equals("ADM")) {
                        this.salariesContrats.setHistoAdm(((SalariesHistorique)var2.get(var4)).getSalhisValeurColE());
                     } else if (((SalariesHistorique)var2.get(var4)).getSalhisCode().equals("BRUT")) {
                        this.salariesContrats.setHistoBrut(((SalariesHistorique)var2.get(var4)).getSalhisValeurColE());
                     } else if (((SalariesHistorique)var2.get(var4)).getSalhisCode().equals("NBJS")) {
                        this.salariesContrats.setHistoNbjs(((SalariesHistorique)var2.get(var4)).getSalhisValeurColE());
                     } else if (((SalariesHistorique)var2.get(var4)).getSalhisCode().equals("CP")) {
                        this.salariesContrats.setHistoCp(((SalariesHistorique)var2.get(var4)).getSalhisValeurColE());
                     }
                  }
               }
            }

            this.lesSasiesHistoriques.add(this.salariesContrats);
         }
      }

      this.dataModelSasiesHistoriques.setWrappedData(this.lesSasiesHistoriques);
   }

   public void rechercheCompteVrt() throws HibernateException, NamingException {
      this.lesCompteVrt.clear();
      if (this.lesContrats.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         this.rechercheCompteVrt(var1);
         this.utilInitHibernate.closeSession();
      }

      this.dataModelComptesVrt.setWrappedData(this.lesCompteVrt);
   }

   public void rechercheCompteVrt(Session var1) throws HibernateException, NamingException {
      this.lesCompteVrt.clear();
      if (this.lesContrats.size() != 0) {
         for(int var2 = 0; var2 < this.lesContrats.size(); ++var2) {
            this.salariesContrats = (SalariesContrats)this.lesContrats.get(var2);
            this.salaries = this.salariesContrats.getSalaries();
            if (this.salariesContrats != null) {
               this.salariesElements = this.salariesElementsDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), this.salariesContrats.getSalconNum(), var1);
            } else {
               this.salariesElements = this.salariesElementsDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), "", var1);
            }

            if (this.salariesElements != null) {
               this.lesCompteVrt.add(this.salariesElements);
            }
         }
      }

      this.dataModelComptesVrt.setWrappedData(this.lesCompteVrt);
   }

   public void rechercheImmatriculation() throws HibernateException, NamingException {
      this.lesImmatriculations.clear();
      if (this.lesContrats.size() != 0) {
         for(int var1 = 0; var1 < this.lesContrats.size(); ++var1) {
            this.salariesContrats = (SalariesContrats)this.lesContrats.get(var1);
            this.salaries = this.salariesContrats.getSalaries();
            this.lesImmatriculations.add(this.salaries);
         }
      }

      this.dataModelImmatriculation.setWrappedData(this.lesImmatriculations);
   }

   public void rechercheNb() throws HibernateException, NamingException {
      this.lesNb.clear();
      if (this.lesContrats.size() != 0) {
         for(int var1 = 0; var1 < this.lesContrats.size(); ++var1) {
            this.salariesContrats = (SalariesContrats)this.lesContrats.get(var1);
            this.salaries = this.salariesContrats.getSalaries();
            this.salaries.setNumContrat(this.salariesContrats.getSalconNum());
            this.lesNb.add(this.salaries);
         }
      }

      this.dataModelNb.setWrappedData(this.lesNb);
   }

   public void fermerPeriode() throws HibernateException, NamingException {
      if (this.bulletinMois != null && this.bulletinMois.getBulmenEtat() <= 2) {
         this.bulletinMois.setBulmenUserIdJournal(0L);
         this.bulletinMois.setBulmenOpenUserJournal("");
         this.bulletinMois.setBulmenOpenJournal(0);
         if (this.bulletinMois.getBulmenEtat() == 0) {
            this.bulletinMois.setBulmenEtat(1);
         }

         this.bulletinMois = this.bulletinMoisDao.majJournal(this.bulletinMois);
      }

      this.afficheTJM = false;
      this.var_action = 0;
   }

   public void selectionSalaries() throws IOException, SQLException, HibernateException, NamingException {
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

         this.salariesContrats = (SalariesContrats)var1.get(0);
         this.salaries = this.salariesContrats.getSalaries();
         this.afficheNomJf();
         this.var_affiche_bouton = true;
         this.var_nature_agent = this.salaries.getLib_nature();
         if (this.modeRepartition != 0) {
            this.calculeRubriqueContrat((Session)null);
         }
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      if (this.salariesContrats != null) {
         if (this.salariesContrats.getSalconType().equals("04")) {
            this.saisieVariablesJournaliers();
         } else {
            this.saisieVariables();
         }
      }

   }

   public void saisieVariables() throws HibernateException, NamingException, ParseException {
      if (this.salaries != null && this.salaries.getSalFeuille() != null && !this.salaries.getSalFeuille().isEmpty()) {
         if (this.salaries.getSalEtat() == 9) {
            this.gestionNettoyageMensuel();
         } else {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            if (this.capitalisationActive) {
               if (this.salariesContrats != null) {
                  this.salariesCapitalisation = this.salariesCapitalisationDao.chargerleCapital(this.salaries, this.salariesContrats.getSalconNum(), var1);
               } else {
                  this.salariesCapitalisation = this.salariesCapitalisationDao.chargerleCapital(this.salaries, "", var1);
               }
            } else {
               this.salariesCapitalisation = null;
            }

            if (this.bulletinMois.getBulmenPeriode().equals("00:0000")) {
               this.gestionRubriques(var1);
               this.gestionElements(var1);
               this.gestionRH(var1);
            } else {
               this.gestionRubriques(var1);
               this.gestionElements(var1);
               this.gestionRH(var1);
               this.gestionEcheances(var1);
               this.gestionAbsences(var1);
            }

            if (this.optionPaye.getNbEnfantsFiscaux().equals("0")) {
               this.calculNbParts();
            }

            this.utilInitHibernate.closeSession();
            this.showModalPanelVariable = true;
         }
      }

   }

   public void gestionNettoyageMensuel() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.salariesContrats != null) {
            this.lesVariables = this.salariesVariablesDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), this.salariesContrats.getSalconNum(), var1);
         } else {
            this.lesVariables = this.salariesVariablesDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), "", var1);
         }

         if (this.lesVariables.size() != 0) {
            for(int var3 = 0; var3 < this.lesVariables.size(); ++var3) {
               this.salariesVariables = (SalariesVariables)this.lesVariables.get(var3);
               this.salariesVariablesDao.delete(this.salariesVariables, var1);
            }
         }

         if (this.salariesContrats != null) {
            this.salariesElements = this.salariesElementsDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), this.salariesContrats.getSalconNum(), var1);
         } else {
            this.salariesElements = this.salariesElementsDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), "", var1);
         }

         if (this.salariesElements != null) {
            this.salariesElementsDao.delete(this.salariesElements, var1);
         }

         this.salariesContrats.setEffectue(false);
         this.dataModelContrats.setWrappedData(this.lesContrats);
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

   public void generationVariables() throws HibernateException, NamingException, ParseException {
      if (this.lesContrats.size() != 0) {
         this.var_info = "Initialisation en cours...";
         this.var_currentValue = 0;
         this.var_showBarProg = true;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);

            for(int var3 = 0; var3 < this.lesContrats.size(); ++var3) {
               this.salariesContrats = (SalariesContrats)this.lesContrats.get(var3);
               this.salaries = this.salariesContrats.getSalaries();
               if (this.salaries.getSalFeuille() != null && !this.salaries.getSalFeuille().isEmpty()) {
                  this.var_info = "Calcul du salarie : " + this.salaries.getSalNom();
                  if (var3 != 0) {
                     double var4 = (double)this.lesContrats.size();
                     double var6 = this.utilNombre.myRound(var4 / (double)var3, 4);
                     double var8 = this.utilNombre.myRound(100.0D / var6, 2);
                     this.var_currentValue = (int)var8;
                  }

                  if (this.capitalisationActive) {
                     if (this.salariesContrats != null) {
                        this.salariesCapitalisation = this.salariesCapitalisationDao.chargerleCapital(this.salaries, this.salariesContrats.getSalconNum(), var1);
                     } else {
                        this.salariesCapitalisation = this.salariesCapitalisationDao.chargerleCapital(this.salaries, "", var1);
                     }
                  } else {
                     this.salariesCapitalisation = null;
                  }

                  this.gestionRubriques(var1);
                  this.gestionElements(var1);
                  this.gestionRH(var1);
                  this.gestionEcheances(var1);
                  this.gestionAbsences(var1);
                  this.majVariables(var1);
               }
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

      this.var_showBarProg = false;
   }

   public void recopierVariables() {
      this.moisChoisi = "";
      this.mesMoisNonclotures.clear();
      if (this.lesBulletinsMois.size() != 0) {
         for(int var1 = 0; var1 < this.lesBulletinsMois.size(); ++var1) {
            if (((BulletinMois)this.lesBulletinsMois.get(var1)).getBulmenEtat() <= 2) {
               this.mesMoisNonclotures.add(new SelectItem(((BulletinMois)this.lesBulletinsMois.get(var1)).getBulmenPeriode()));
            }
         }
      }

      this.showModalPanelRecopierVariables = true;
   }

   public void fermerRecopierVariables() {
      this.showModalPanelRecopierVariables = false;
   }

   public void validerRecopierVariables() throws HibernateException, NamingException {
      if (this.moisChoisi != null && !this.moisChoisi.isEmpty() && this.moisChoisi.contains(":")) {
         String var1 = "";
         if (this.lesContrats.size() != 0) {
            for(int var2 = 0; var2 < this.lesContrats.size(); ++var2) {
               if (var1 != null && !var1.isEmpty()) {
                  var1 = var1 + "," + ((SalariesContrats)this.lesContrats.get(var2)).getSalaries().getSalId();
               } else {
                  var1 = "" + ((SalariesContrats)this.lesContrats.get(var2)).getSalaries().getSalId();
               }
            }

            Session var13 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            Transaction var3 = null;

            try {
               var3 = var13.beginTransaction();
               var1 = "(" + var1 + ")";
               new ArrayList();
               List var4 = this.salariesVariablesDao.chargerlesVariablesARecopier(this.bulletinMois.getBulmenPeriode(), var1, var13);
               if (var4.size() != 0) {
                  new SalariesVariables();
                  new PlanPaye();

                  for(int var7 = 0; var7 < var4.size(); ++var7) {
                     this.salariesVariables = (SalariesVariables)var4.get(var7);
                     this.salaries = this.salariesVariables.getSalaries();
                     PlanPaye var6 = this.salariesVariables.getPlanPaye();
                     SalariesVariables var5 = this.salariesVariablesDao.chargerlesVariablesPeriodeRubrique(this.salaries, this.moisChoisi, this.salariesVariables.getSalvarContrat(), this.salariesVariables.getSalvarCode(), var13);
                     if (var5 == null) {
                        var5 = new SalariesVariables();
                     }

                     var5.setSalaries(this.salaries);
                     var5.setPlanPaye(var6);
                     var5.setSalvarCode(this.salariesVariables.getSalvarCode());
                     var5.setSalvarContrat(this.salariesVariables.getSalvarContrat());
                     var5.setSalvarFeuille(this.salariesVariables.getSalvarFeuille());
                     var5.setSalvarJour(this.salariesVariables.getSalvarJour());
                     var5.setSalvarPeriode(this.moisChoisi);
                     var5.setSalvarValeurColA(this.salariesVariables.getSalvarValeurColA());
                     var5.setSalvarValeurColB(this.salariesVariables.getSalvarValeurColB());
                     var5.setSalvarValeurColC(this.salariesVariables.getSalvarValeurColC());
                     var5.setSalvarValeurColD(this.salariesVariables.getSalvarValeurColD());
                     var5.setSalvarValeurColE(this.salariesVariables.getSalvarValeurColE());
                     var5.setSalvarVariableA(this.salariesVariables.isSalvarVariableA());
                     var5.setSalvarVariableB(this.salariesVariables.isSalvarVariableB());
                     var5.setSalvarVariableC(this.salariesVariables.isSalvarVariableC());
                     var5.setSalvarVariableD(this.salariesVariables.isSalvarVariableD());
                     var5.setSalvarVariableE(this.salariesVariables.isSalvarVariableE());
                     if (var5.getSalvarId() == 0L) {
                        this.salariesVariablesDao.insert(var5, var13);
                     } else {
                        this.salariesVariablesDao.modif(var5, var13);
                     }
                  }
               }

               var3.commit();
            } catch (HibernateException var11) {
               if (var3 != null) {
                  var3.rollback();
               }

               throw var11;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      this.showModalPanelRecopierVariables = false;
   }

   public void razRubriques() throws HibernateException, NamingException {
      if (this.lesSalariesRubriques.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);

            for(int var3 = 0; var3 < this.lesSalariesRubriques.size(); ++var3) {
               this.salariesVariables = (SalariesVariables)this.lesSalariesRubriques.get(var3);
               this.salariesVariables.setSalvarValeurColA(0.0D);
               this.salariesVariables.setSalvarValeurColB(0.0D);
               this.salariesVariables.setSalvarValeurColC(0.0D);
               this.salariesVariables.setSalvarValeurColD(0.0D);
               this.salariesVariables.setSalvarValeurColE(0.0D);
               this.salariesVariables = this.salariesVariablesDao.modif(this.salariesVariables, var1);
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

   public void gestionRubriques(Session var1) throws HibernateException, NamingException {
      this.lesVariables.clear();
      this.lesRubriques.clear();
      String var2 = "" + this.salaries.getSalFeuille();
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();
      this.feuilleCalcul = this.feuilleCalculDao.chercherCode(var2, this.exercicesPaye.getExepayId(), var1);
      if (this.feuilleCalcul != null) {
         this.lesRubriques = this.feuilleCalculRubriqueDao.chargerRubriqueFeuilleActive(this.feuilleCalcul, this.exercicesPaye.getExepayId(), var1);
         if (this.salariesContrats != null) {
            this.lesVariables = this.salariesVariablesDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), this.salariesContrats.getSalconNum(), var1);
         } else {
            this.lesVariables = this.salariesVariablesDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), "", var1);
         }

         if (this.lesVariables.size() == 0) {
            this.chercherVariableAnterieure(var1);
         }

         int var9;
         if (this.lesRubriques.size() != 0) {
            boolean var5 = false;
            new FeuilleCalculRubrique();

            for(int var7 = 0; var7 < this.lesRubriques.size(); ++var7) {
               FeuilleCalculRubrique var6 = (FeuilleCalculRubrique)this.lesRubriques.get(var7);
               if (this.capitalisationActive) {
                  if (this.optionPaye.getRubVersement() != null && !this.optionPaye.getRubVersement().isEmpty() && this.optionPaye.getRubVersement().equals(var6.getFeurubCode())) {
                     if (this.salariesCapitalisation != null) {
                        var5 = true;
                     } else {
                        var5 = false;
                     }
                  } else if (this.optionPaye.getRubSpontanee() != null && !this.optionPaye.getRubSpontanee().isEmpty() && this.optionPaye.getRubSpontanee().equals(var6.getFeurubCode())) {
                     if (this.salariesCapitalisation != null) {
                        var5 = true;
                     } else {
                        var5 = false;
                     }
                  } else if (this.optionPaye.getRubRetrait() != null && !this.optionPaye.getRubRetrait().isEmpty() && this.optionPaye.getRubRetrait().equals(var6.getFeurubCode())) {
                     if (this.salariesCapitalisation != null) {
                        var5 = true;
                     } else {
                        var5 = false;
                     }
                  } else {
                     var5 = true;
                  }
               } else {
                  var5 = true;
               }

               if (var5 && (var6.isFeurubVariableA() || var6.isFeurubVariableB() || var6.isFeurubVariableC() || var6.isFeurubVariableD() || var6.isFeurubVariableE())) {
                  if (this.lesVariables.size() == 0) {
                     this.salariesVariables = new SalariesVariables();
                     this.salariesVariables.setSalaries(this.salaries);
                     this.salariesVariables.setPlanPaye(var6.getPlanPaye());
                     this.salariesVariables.setSalvarContrat(this.salariesContrats.getSalconNum());
                     this.salariesVariables.setSalvarCode(var6.getFeurubCode());
                     this.salariesVariables.setSalvarPeriode(this.bulletinMois.getBulmenPeriode());
                     this.salariesVariables.setSalvarFeuille(this.bulletinMois.getBulmenFeuille());
                     this.salariesVariables.setSalvarVariableA(var6.isFeurubVariableA());
                     this.salariesVariables.setSalvarVariableB(var6.isFeurubVariableB());
                     this.salariesVariables.setSalvarVariableC(var6.isFeurubVariableC());
                     this.salariesVariables.setSalvarVariableD(var6.isFeurubVariableD());
                     this.salariesVariables.setSalvarVariableE(var6.isFeurubVariableE());
                     this.lesVariables.add(this.salariesVariables);
                  } else {
                     boolean var8 = false;

                     for(var9 = 0; var9 < this.lesVariables.size(); ++var9) {
                        this.salariesVariables = (SalariesVariables)this.lesVariables.get(var9);
                        if (this.salariesVariables.getSalvarCode().equals(var6.getFeurubCode())) {
                           this.salariesVariables.setSalvarVariableA(var6.isFeurubVariableA());
                           this.salariesVariables.setSalvarVariableB(var6.isFeurubVariableB());
                           this.salariesVariables.setSalvarVariableC(var6.isFeurubVariableC());
                           this.salariesVariables.setSalvarVariableD(var6.isFeurubVariableD());
                           this.salariesVariables.setSalvarVariableE(var6.isFeurubVariableE());
                           var8 = true;
                           break;
                        }
                     }

                     if (!var8) {
                        this.salariesVariables = new SalariesVariables();
                        this.salariesVariables.setSalaries(this.salaries);
                        this.salariesVariables.setPlanPaye(var6.getPlanPaye());
                        this.salariesVariables.setSalvarContrat(this.salariesContrats.getSalconNum());
                        this.salariesVariables.setSalvarCode(var6.getFeurubCode());
                        this.salariesVariables.setSalvarPeriode(this.bulletinMois.getBulmenPeriode());
                        this.salariesVariables.setSalvarFeuille(this.bulletinMois.getBulmenFeuille());
                        this.salariesVariables.setSalvarVariableA(var6.isFeurubVariableA());
                        this.salariesVariables.setSalvarVariableB(var6.isFeurubVariableB());
                        this.salariesVariables.setSalvarVariableC(var6.isFeurubVariableC());
                        this.salariesVariables.setSalvarVariableD(var6.isFeurubVariableD());
                        this.salariesVariables.setSalvarVariableE(var6.isFeurubVariableE());
                        this.lesVariables.add(this.salariesVariables);
                     }
                  }
               }
            }
         }

         if (this.lesVariables.size() != 0) {
            new SalariesVariables();
            int var14 = 0;

            label204:
            while(true) {
               SalariesVariables var17;
               int var18;
               if (var14 >= this.lesVariables.size()) {
                  if (this.lesVariables.size() != 0) {
                     String var15 = "";
                     new SalariesVariables();

                     for(var18 = 0; var18 < this.lesVariables.size(); ++var18) {
                        this.salariesVariables = (SalariesVariables)this.lesVariables.get(var18);
                        var15 = this.salariesVariables.getSalvarCode();

                        for(var9 = var18 + 1; var9 < this.lesVariables.size(); ++var9) {
                           SalariesVariables var19 = (SalariesVariables)this.lesVariables.get(var9);
                           if (var19.getSalvarCode().equals(var15)) {
                              var3.add(var19);
                           }
                        }
                     }
                  }

                  if (var3.size() != 0) {
                     for(var14 = 0; var14 < var3.size(); ++var14) {
                        var17 = (SalariesVariables)var3.get(var14);
                        var17 = this.salariesVariablesDao.pourParapheur(((SalariesVariables)var3.get(var14)).getSalvarId(), var1);
                        if (var17 != null) {
                           this.salariesVariablesDao.delete(var17, var1);
                           var1.flush();
                        }
                     }
                  }

                  if (this.optionPaye.getRubQuinzaine() == null || this.optionPaye.getRubQuinzaine().isEmpty() || this.lesVariables.size() == 0) {
                     break;
                  }

                  var14 = 0;

                  while(true) {
                     if (var14 >= this.lesVariables.size()) {
                        break label204;
                     }

                     var17 = (SalariesVariables)this.lesVariables.get(var14);
                     if (var17.getSalvarCode().equals(this.optionPaye.getRubQuinzaine())) {
                        var17.setGriseVariableA(true);
                        var17.setGriseVariableB(true);
                        var17.setGriseVariableC(true);
                        var17.setGriseVariableD(true);
                        var17.setGriseVariableE(true);
                     } else {
                        var17.setGriseVariableA(false);
                        var17.setGriseVariableB(false);
                        var17.setGriseVariableC(false);
                        var17.setGriseVariableD(false);
                        var17.setGriseVariableE(false);
                     }

                     ++var14;
                  }
               }

               var17 = (SalariesVariables)this.lesVariables.get(var14);
               if (var17.getSalvarCode() != null && !var17.getSalvarCode().isEmpty()) {
                  if (this.lesRubriques.size() == 0) {
                     var4.add(var17);
                  } else {
                     boolean var16 = false;

                     for(var18 = 0; var18 < this.lesRubriques.size(); ++var18) {
                        if (((FeuilleCalculRubrique)this.lesRubriques.get(var18)).getFeurubCode() != null && !((FeuilleCalculRubrique)this.lesRubriques.get(var18)).getFeurubCode().isEmpty() && ((FeuilleCalculRubrique)this.lesRubriques.get(var18)).getFeurubCode().equals(var17.getSalvarCode())) {
                           boolean var20 = false;
                           if (((FeuilleCalculRubrique)this.lesRubriques.get(var18)).isFeurubColA() && ((FeuilleCalculRubrique)this.lesRubriques.get(var18)).isFeurubVariableA()) {
                              var20 = true;
                           }

                           boolean var10 = false;
                           if (((FeuilleCalculRubrique)this.lesRubriques.get(var18)).isFeurubColB() && ((FeuilleCalculRubrique)this.lesRubriques.get(var18)).isFeurubVariableB()) {
                              var10 = true;
                           }

                           boolean var11 = false;
                           if (((FeuilleCalculRubrique)this.lesRubriques.get(var18)).isFeurubColC() && ((FeuilleCalculRubrique)this.lesRubriques.get(var18)).isFeurubVariableC()) {
                              var11 = true;
                           }

                           boolean var12 = false;
                           if (((FeuilleCalculRubrique)this.lesRubriques.get(var18)).isFeurubColD() && ((FeuilleCalculRubrique)this.lesRubriques.get(var18)).isFeurubVariableD()) {
                              var12 = true;
                           }

                           boolean var13 = false;
                           if (((FeuilleCalculRubrique)this.lesRubriques.get(var18)).isFeurubColE() && ((FeuilleCalculRubrique)this.lesRubriques.get(var18)).isFeurubVariableE()) {
                              var13 = true;
                           }

                           if (!var20 && !var10 && !var11 && !var12 && !var13) {
                              var16 = false;
                           } else {
                              var16 = true;
                           }
                           break;
                        }
                     }

                     if (!var16) {
                        var3.add(var17);
                     } else {
                        var17.setGriseVariableA(false);
                        var17.setGriseVariableB(false);
                        var17.setGriseVariableC(false);
                        var17.setGriseVariableD(false);
                        var17.setGriseVariableE(false);
                        var4.add(var17);
                     }
                  }
               }

               ++var14;
            }
         }

         this.dataModelVariables.setWrappedData(var4);
      }

   }

   public void chercherVariableAnterieure(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      boolean var3 = false;
      boolean var4 = false;
      String[] var5 = this.bulletinMois.getBulmenPeriode().split(":");
      int var10 = Integer.parseInt(var5[0]);
      int var11 = Integer.parseInt(var5[1]);

      for(int var6 = 12; var6 > 0; --var6) {
         --var10;
         if (var10 <= 0) {
            var10 = 12;
            --var11;
         }

         if (var10 <= 9) {
            var2 = "0" + var10 + ":" + var11;
         } else {
            var2 = var10 + ":" + var11;
         }

         new ArrayList();
         List var7;
         if (this.salariesContrats != null) {
            var7 = this.salariesVariablesDao.chargerlesVariablesPeriode(this.salaries, var2, this.salariesContrats.getSalconNum(), var1);
         } else {
            var7 = this.salariesVariablesDao.chargerlesVariablesPeriode(this.salaries, var2, "", var1);
         }

         if (var7.size() != 0) {
            new SalariesVariables();

            for(int var9 = 0; var9 < var7.size(); ++var9) {
               this.salariesVariables = (SalariesVariables)var7.get(var9);
               SalariesVariables var8 = new SalariesVariables();
               var8.setPlanPaye(this.salariesVariables.getPlanPaye());
               var8.setSalaries(this.salariesVariables.getSalaries());
               var8.setSalvarCode(this.salariesVariables.getSalvarCode());
               var8.setSalvarContrat(this.salariesVariables.getSalvarContrat());
               var8.setSalvarFeuille(this.salariesVariables.getSalvarFeuille());
               var8.setSalvarJour(this.salariesVariables.getSalvarJour());
               var8.setSalvarPeriode(this.bulletinMois.getBulmenPeriode());
               var8.setSalvarValeurColA(this.salariesVariables.getSalvarValeurColA());
               var8.setSalvarValeurColB(this.salariesVariables.getSalvarValeurColB());
               var8.setSalvarValeurColC(this.salariesVariables.getSalvarValeurColC());
               var8.setSalvarValeurColD(this.salariesVariables.getSalvarValeurColD());
               var8.setSalvarValeurColE(this.salariesVariables.getSalvarValeurColE());
               var8.setSalvarVariableA(this.salariesVariables.isSalvarVariableA());
               var8.setSalvarVariableB(this.salariesVariables.isSalvarVariableB());
               var8.setSalvarVariableC(this.salariesVariables.isSalvarVariableC());
               var8.setSalvarVariableD(this.salariesVariables.isSalvarVariableD());
               var8.setSalvarVariableE(this.salariesVariables.isSalvarVariableE());
               this.lesVariables.add(var8);
            }

            return;
         }
      }

   }

   public void gestionElements(Session var1) throws HibernateException, NamingException {
      if (this.salariesContrats != null) {
         if (this.salariesContrats != null) {
            this.salariesElements = this.salariesElementsDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), this.salariesContrats.getSalconNum(), var1);
         } else {
            this.salariesElements = this.salariesElementsDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), "", var1);
         }

         if (this.salariesElements == null) {
            this.salariesElements = new SalariesElements();
            this.salariesElements.setSalaries(this.salaries);
            this.salariesElements.setSalelePeriode(this.bulletinMois.getBulmenPeriode());
            this.salariesElements.setSaleleActivite(this.salariesContrats.getSalconActivite());
            this.salariesElements.setSaleleBudget(this.salariesContrats.getSalconBudget());
            this.salariesElements.setSaleleCivilite(this.salaries.getSalCivilite());
            this.salariesElements.setSaleleCle1Anal(this.salariesContrats.getSalconCle1Anal());
            this.salariesElements.setSaleleCle2Anal(this.salariesContrats.getSalconCle2Anal());
            this.salariesElements.setSaleleDateConcubinage(this.salaries.getSalDateConcubinage());
            this.salariesElements.setSaleleDateDivorce(this.salaries.getSalDateDivorce());
            this.salariesElements.setSaleleDateMarie(this.salaries.getSalDateMarie());
            this.salariesElements.setSaleleDatePacs(this.salaries.getSalDatePacs());
            this.salariesElements.setSaleleDateVeuf(this.salaries.getSalDateVeuf());
            this.salariesElements.setSaleleDepartement(this.salaries.getSalDepartement());
            this.salariesElements.setSaleleEtat(this.salaries.getSalEtat());
            this.salariesElements.setSaleleFeuille(this.salaries.getSalFeuille());
            this.salariesElements.setSaleleFonction(this.salariesContrats.getSalconFonction());
            this.salariesElements.setSaleleGenre(this.salaries.getSalGenre());
            this.salariesElements.setSaleleLibCle1Anal(this.salariesContrats.getSalconLibCle1Anal());
            this.salariesElements.setSaleleLibCle2Anal(this.salariesContrats.getSalconLibCle2Anal());
            this.salariesElements.setSaleleLocalisation(this.salariesContrats.getSalconLocalisation());
            this.salariesElements.setSaleleMatricule(this.salaries.getSalMatricule());
            this.salariesElements.setSaleleNature(this.salaries.getSalNature());
            this.salariesElements.setSaleleNbEnfant(this.salaries.getSalNbEnfant());
            this.salariesElements.setSaleleNbFemme(this.salaries.getSalNbFemme());
            this.salariesElements.setSaleleNbJourCp(this.salariesContrats.getSalconNbJourCp());
            this.salariesElements.setSaleleNbJourTr(this.salariesContrats.getSalconNbJourTr());
            this.salariesElements.setSaleleNbPartFiscal(this.salaries.getSalNbPartFiscal());
            this.salariesElements.setSaleleNbPartTrimf(this.salaries.getSalNbPartTrimf());
            this.salariesElements.setSaleleParc(this.salariesContrats.getSalconParc());
            this.salariesElements.setSaleleService(this.salariesContrats.getSalconService());
            this.salariesElements.setSaleleLibService(this.salariesContrats.getSalconLibService());
            this.salariesElements.setSaleleSitFamille(this.salaries.getSalSitFamille());
            this.salariesElements.setSaleleSite(this.salariesContrats.getSalconSite());
            this.salariesElements.setSaleleDateSortie(this.salaries.getSalDateSortie());
            this.salariesElements.setSaleleMotifSortie(this.salaries.getSalMotifSortie());
            this.salariesElements.setSaleleModeReglement(this.salaries.getSalModeReglement());
            this.salariesElements.setSaleleNumBanque(this.salaries.getSalNumBanque());
            this.salariesElements.setSaleleGuichetBanque(this.salaries.getSalGuichetBanque());
            this.salariesElements.setSaleleCompteBanque(this.salaries.getSalCompteBanque());
            this.salariesElements.setSaleleCleBanque(this.salaries.getSalCleBanque());
            this.salariesElements.setSaleleIban(this.salaries.getSalIban());
            this.salariesElements.setSaleleSwift(this.salaries.getSalSwift());
            this.salariesElements.setSaleleCompteMembre(this.salaries.getSalCompteMembre());
            this.salariesElements.setSaleleContrat(this.salariesContrats.getSalconNum());
            this.salariesElements.setSaleleConvention(this.salariesContrats.getSalconConvention());
            this.salariesElements.setSaleleGrille(this.salariesContrats.getSalconGrille());
            this.salariesElements.setSaleleClassement(this.salariesContrats.getSalconClassement());
            this.salariesElements.setSaleleCentresImpots(this.salariesContrats.getSalconCentresImpots());
            this.salariesElements.setSaleleCentresSecurite(this.salariesContrats.getSalconCentresSecurite());
            this.salariesElements.setSaleleNivEmploi(this.salariesContrats.getSalconNivEmploi());
            this.salariesElements.setSaleleLibCentresImpots(this.salariesContrats.getSalconLibCentresImpots());
            this.salariesElements.setSaleleLibCentresSecurite(this.salariesContrats.getSalconLibCentresSecurite());
            this.salariesElements.setSaleleLibClassement(this.salariesContrats.getSalconLibClassement());
            this.salariesElements.setSaleleLibNivEmploi(this.salariesContrats.getSalconLibNivEmploi());
            this.salariesElements.setSaleleLibConvention(this.salariesContrats.getSalconLibConvention());
            this.salariesElements.setSaleleLibGrille(this.salariesContrats.getSalconLibGrille());
            this.salariesElements.setSaleleDateEntree(this.salariesContrats.getSalconDateDebut());
            this.salariesElements.setSaleleDateSortie(this.salariesContrats.getSalconDateFin());
         } else {
            this.salariesElements.setSaleleActivite(this.salariesContrats.getSalconActivite());
            this.salariesElements.setSaleleBudget(this.salariesContrats.getSalconBudget());
            this.salariesElements.setSaleleCle1Anal(this.salariesContrats.getSalconCle1Anal());
            this.salariesElements.setSaleleCle2Anal(this.salariesContrats.getSalconCle2Anal());
            this.salariesElements.setSaleleFonction(this.salariesContrats.getSalconFonction());
            this.salariesElements.setSaleleLibCle1Anal(this.salariesContrats.getSalconLibCle1Anal());
            this.salariesElements.setSaleleLibCle2Anal(this.salariesContrats.getSalconLibCle2Anal());
            this.salariesElements.setSaleleParc(this.salariesContrats.getSalconParc());
            this.salariesElements.setSaleleService(this.salariesContrats.getSalconService());
            this.salariesElements.setSaleleLibService(this.salariesContrats.getSalconLibService());
            this.salariesElements.setSaleleSite(this.salariesContrats.getSalconSite());
            this.salariesElements.setSaleleContrat(this.salariesContrats.getSalconNum());
            this.salariesElements.setSaleleConvention(this.salariesContrats.getSalconConvention());
            this.salariesElements.setSaleleGrille(this.salariesContrats.getSalconGrille());
            this.salariesElements.setSaleleClassement(this.salariesContrats.getSalconClassement());
            this.salariesElements.setSaleleCentresImpots(this.salariesContrats.getSalconCentresImpots());
            this.salariesElements.setSaleleCentresSecurite(this.salariesContrats.getSalconCentresSecurite());
            this.salariesElements.setSaleleNivEmploi(this.salariesContrats.getSalconNivEmploi());
            this.salariesElements.setSaleleLibCentresImpots(this.salariesContrats.getSalconLibCentresImpots());
            this.salariesElements.setSaleleLibCentresSecurite(this.salariesContrats.getSalconLibCentresSecurite());
            this.salariesElements.setSaleleLibClassement(this.salariesContrats.getSalconLibClassement());
            this.salariesElements.setSaleleLibNivEmploi(this.salariesContrats.getSalconLibNivEmploi());
            this.salariesElements.setSaleleLibConvention(this.salariesContrats.getSalconLibConvention());
            this.salariesElements.setSaleleLibGrille(this.salariesContrats.getSalconLibGrille());
            this.salariesElements.setSaleleLocalisation(this.salariesContrats.getSalconLocalisation());
            this.salariesElements.setSaleleEtat(this.salariesContrats.getSalconEtat());
            this.salariesElements.setSaleleDateEntree(this.salariesContrats.getSalconDateDebut());
            this.salariesElements.setSaleleDateSortie(this.salariesContrats.getSalconDateFin());
         }

         if (this.salariesContrats.getSalconService() != null && !this.salariesContrats.getSalconService().isEmpty()) {
            this.var_service = this.salariesContrats.getSalconService() + ":" + this.salariesContrats.getSalconLibService();
         } else {
            this.var_service = "";
         }

         if (this.salariesContrats.getSalconActivite() != null && !this.salariesContrats.getSalconActivite().isEmpty()) {
            this.var_activite = this.salariesContrats.getSalconActivite() + ":" + this.salariesContrats.getSalconLibActivite().toUpperCase();
         } else {
            this.var_activite = "";
         }

         if (this.salariesContrats.getSalconCle1Anal() != null && !this.salariesContrats.getSalconCle1Anal().isEmpty()) {
            this.var_cle1 = this.salariesContrats.getSalconCle1Anal() + ":" + this.salariesContrats.getSalconLibCle1Anal();
         } else {
            this.var_cle1 = "";
         }

         if (this.salariesContrats.getSalconCle2Anal() != null && !this.salariesContrats.getSalconCle2Anal().isEmpty()) {
            this.var_cle2 = this.salariesContrats.getSalconCle2Anal() + ":" + this.salariesContrats.getSalconLibCle2Anal();
         } else {
            this.var_cle2 = "";
         }

         if (this.salaries.getSalNature() != null && !this.salaries.getSalNature().isEmpty()) {
            if (!this.salaries.getSalNature().equals("13") && !this.salaries.getSalNature().equals("14")) {
               if (this.salariesElements.getSaleleNivEmploi() != null && !this.salariesElements.getSaleleNivEmploi().isEmpty()) {
                  this.var_niveau = this.salariesElements.getSaleleNivEmploi() + ":" + this.salariesElements.getSaleleLibNivEmploi();
               } else {
                  this.var_niveau = "";
               }

               if (this.salariesElements.getSaleleClassement() != null && !this.salariesElements.getSaleleClassement().isEmpty()) {
                  this.var_classement = this.salariesElements.getSaleleClassement() + ":" + this.salariesElements.getSaleleLibClassement();
               } else {
                  this.var_classement = "";
               }

               if (this.salariesElements.getSaleleCentresImpots() != null && !this.salariesElements.getSaleleCentresImpots().isEmpty()) {
                  this.var_centre = this.salariesElements.getSaleleCentresImpots() + ":" + this.salariesElements.getSaleleLibCentresImpots();
               } else {
                  this.var_centre = "";
               }

               if (this.salariesElements.getSaleleCentresSecurite() != null && !this.salariesElements.getSaleleCentresSecurite().isEmpty()) {
                  this.var_securite = this.salariesElements.getSaleleCentresSecurite();
               } else {
                  this.var_securite = "";
               }

               if (this.salariesElements.getSaleleConvention() != null && !this.salariesElements.getSaleleConvention().isEmpty()) {
                  this.var_convention = this.salariesElements.getSaleleConvention() + ":" + this.salariesElements.getSaleleLibConvention();
               } else {
                  this.var_convention = "";
               }

               if (this.salariesElements.getSaleleGrille() != null && !this.salariesElements.getSaleleGrille().isEmpty()) {
                  this.var_grille = this.salariesElements.getSaleleGrille() + ":" + this.salariesElements.getSaleleLibGrille();
               } else {
                  this.var_grille = "";
               }

               this.chargerGrille();
            } else {
               this.var_niveau = "";
               this.var_classement = "";
               this.var_centre = "";
               this.var_convention = "";
               this.var_grille = "";
            }
         } else {
            this.var_niveau = "";
            this.var_classement = "";
            this.var_centre = "";
            this.var_convention = "";
            this.var_grille = "";
         }
      }

   }

   public void gestionRH(Session var1) throws HibernateException, NamingException {
      this.lesSalariesGrh.clear();
      this.lesSalariesGrh = this.salariesGrhDao.chargerlesElementRh(this.salaries, var1);
   }

   public void chargerGrille() {
      this.mesGrillesItems = new ArrayList();
      this.lesGrilles = new ArrayList();
      if (this.var_convention != null && !this.var_convention.isEmpty() && !this.var_convention.equals("0") && this.var_convention.contains(":")) {
         String[] var1 = this.var_convention.split(":");
         LectureGrilleSalaire var2 = new LectureGrilleSalaire();
         var2.setStrId(this.structureLog.getStrid());
         var2.setStructureLog(this.structureLog);
         var2.recuperePaye(var1[0]);
         this.mesGrillesItems = var2.getMesGrillesSalairesItems();
         if (this.mesGrillesItems == null) {
            this.mesGrillesItems = new ArrayList();
         }

         this.lesGrilles = var2.getMesGrillesSalaires();
         if (this.lesGrilles == null) {
            this.lesGrilles = new ArrayList();
         }
      }

   }

   public void calculGrilleSimulation() {
      double var1 = 0.0D;
      if (this.lesGrilles.size() != 0 && this.var_grille != null && !this.var_grille.isEmpty() && this.var_grille.contains(":")) {
         String[] var3 = this.var_grille.split(":");
         String var4 = var3[0];
         int var5;
         if (!this.salariesContrats.getSalconType().equals("03D") && !this.salariesContrats.getSalconType().equals("03I")) {
            if (!this.salariesContrats.getSalconType().equals("13") && !this.salariesContrats.getSalconType().equals("14")) {
               if (this.salariesContrats.getSalconType().equals("04")) {
                  for(var5 = 0; var5 < this.lesGrilles.size(); ++var5) {
                     if (((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getCode().equals(var4)) {
                        var1 = (double)(((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getVal_mois() / 30.0F);
                        break;
                     }
                  }
               } else {
                  for(var5 = 0; var5 < this.lesGrilles.size(); ++var5) {
                     if (((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getCode().equals(var4)) {
                        var1 = (double)((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getVal_mois();
                        break;
                     }
                  }
               }
            } else {
               var1 = 0.0D;
            }
         } else {
            for(var5 = 0; var5 < this.lesGrilles.size(); ++var5) {
               if (((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getCode().equals(var4)) {
                  var1 = (double)((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getVal_heure();
                  break;
               }
            }
         }
      }

      this.salariesContrats.setSalconBase(var1);
   }

   public void calculGrillePreparation() {
      double var1 = 0.0D;
      if (this.lesGrilles.size() != 0 && this.var_grille != null && !this.var_grille.isEmpty() && this.var_grille.contains(":")) {
         String[] var3 = this.var_grille.split(":");
         String var4 = var3[0];
         int var5;
         if (this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && (this.salariesElements.getSaleleNature().equals("03D") || this.salariesElements.getSaleleNature().equals("03I"))) {
            for(var5 = 0; var5 < this.lesGrilles.size(); ++var5) {
               if (((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getCode().equals(var4)) {
                  var1 = (double)((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getVal_heure();
                  break;
               }
            }
         } else if ((this.salariesElements.getSaleleNature() == null || this.salariesElements.getSaleleNature().isEmpty() || !this.salariesElements.getSaleleNature().equals("13")) && !this.salariesElements.getSaleleNature().equals("14")) {
            if (this.salariesElements.getSaleleNature() == null || this.salariesElements.getSaleleNature().isEmpty() || !this.salariesElements.getSaleleNature().equals("04")) {
               for(var5 = 0; var5 < this.lesGrilles.size(); ++var5) {
                  if (((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getCode().equals(var4)) {
                     var1 = (double)((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getVal_mois();
                     break;
                  }
               }
            } else {
               for(var5 = 0; var5 < this.lesGrilles.size(); ++var5) {
                  if (((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getCode().equals(var4)) {
                     var1 = (double)(((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getVal_mois() / 30.0F);
                     break;
                  }
               }
            }
         } else {
            var1 = 0.0D;
         }
      }

      this.salariesContrats.setSalconBase(var1);
   }

   public void gestionEcheances(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesEcheances.clear();
      this.totalPret = 0.0D;
      if (this.salaries != null) {
         this.lesEcheances = this.salariesPretsLignesDao.chargerlesPretsLignesBySalariesValidePeriode(this.salaries, this.d1, this.d2, 9, var1);
         if (this.lesEcheances.size() != 0) {
            for(int var2 = 0; var2 < this.lesEcheances.size(); ++var2) {
               this.totalPret += ((SalariesPretsLignes)this.lesEcheances.get(var2)).getSalpreligMontantTheo();
            }
         }
      }

      this.dataModelEcheances.setWrappedData(this.lesEcheances);
   }

   public void calculNbParts() {
      this.salaries.setSalSitFamille(this.salariesElements.getSaleleSitFamille());
      this.salaries.setSalGenre(this.salariesElements.getSaleleGenre());
      if (this.salaries.getSalNature() != null && !this.salaries.getSalNature().isEmpty() && !this.salaries.getSalNature().equals("04") && this.optionPaye.getNbEnfantsFiscaux().equals("0")) {
         this.salariesElements.setSaleleNbEnfant(this.formBakingBeanPaye.calculNbEnfants(this.salaries, this.lesSalariesGrh));
      }

      this.salariesElements.setSaleleNbFemme(this.formBakingBeanPaye.calculNbFemme(this.salaries, this.lesSalariesGrh));
      this.salariesElements.setSaleleNbPartFiscal(this.formBakingBeanPaye.calculNbPartsFiscales(this.salariesElements, this.lesSalariesGrh));
      this.salariesElements.setSaleleNbPartTrimf(this.formBakingBeanPaye.calculNbtrimf(this.salaries, this.lesSalariesGrh));
   }

   public void calculNbPartsPreparation() throws HibernateException, NamingException {
      this.calculNbPartsPreparation((Session)null);
   }

   public void calculNbPartsPreparation(Session var1) throws HibernateException, NamingException {
      if (this.salaries != null) {
         this.lesSalariesGrh = this.salariesGrhDao.chargerlesElementRh(this.salaries, var1);
         if (this.salaries.getSalNature() != null && !this.salaries.getSalNature().isEmpty() && !this.salaries.getSalNature().equals("04") && this.optionPaye.getNbEnfantsFiscaux().equals("0")) {
            this.salaries.setSalNbEnfant(this.formBakingBeanPaye.calculNbEnfants(this.salaries, this.lesSalariesGrh));
         }

         this.salaries.setSalNbFemme(this.formBakingBeanPaye.calculNbFemme(this.salaries, this.lesSalariesGrh));
         this.salaries.setSalNbPartFiscal(this.formBakingBeanPaye.calculNbPartsFiscales(this.salaries, this.lesSalariesGrh));
         this.salaries.setSalNbPartTrimf(this.formBakingBeanPaye.calculNbtrimf(this.salaries, this.lesSalariesGrh));
      }

   }

   public void gestionAbsences(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesSalariesAbsences.clear();
      this.nbJourAbs = 0.0F;
      this.nbHeureRet = 0.0F;
      if (this.salaries != null) {
         if (this.salariesContrats != null) {
            this.lesSalariesAbsences = this.salariesCongesDao.chargerlesAbsencesValidePeriode(this.salaries, this.salariesContrats.getSalconNum(), this.d1, this.d2, var1);
         } else {
            this.lesSalariesAbsences = this.salariesCongesDao.chargerlesAbsencesValidePeriode(this.salaries, "", this.d1, this.d2, var1);
         }

         if (this.lesSalariesAbsences.size() != 0) {
            for(int var2 = 0; var2 < this.lesSalariesAbsences.size(); ++var2) {
               if (((SalariesConges)this.lesSalariesAbsences.get(var2)).getSalcngNature() != 11 && ((SalariesConges)this.lesSalariesAbsences.get(var2)).getSalcngNature() != 12 && ((SalariesConges)this.lesSalariesAbsences.get(var2)).getSalcngNature() != 13) {
                  if (((SalariesConges)this.lesSalariesAbsences.get(var2)).getSalcngNature() == 14) {
                     this.nbHeureRet += ((SalariesConges)this.lesSalariesAbsences.get(var2)).getSalcngNbHeure();
                  }
               } else {
                  this.nbJourAbs += ((SalariesConges)this.lesSalariesAbsences.get(var2)).getSalcngDuree();
               }
            }
         }
      }

      this.dataModelAbsences.setWrappedData(this.lesSalariesAbsences);
   }

   public void fermerVariables() {
      this.showModalPanelVariable = false;
   }

   public void selectionVariable() {
      if (this.dataModelVariables.isRowAvailable()) {
         this.salariesVariables = (SalariesVariables)this.dataModelVariables.getRowData();
      }

   }

   public void rechargeVariable() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.gestionRubriques(var1);
         if (this.lesVariables.size() != 0) {
            String var3 = "";
            String var4 = "";
            SalariesVariables var5 = new SalariesVariables();

            for(int var6 = 0; var6 < this.lesVariables.size(); ++var6) {
               this.salariesVariables = (SalariesVariables)this.lesVariables.get(var6);
               if (this.modeRepartition == 0) {
                  var4 = this.bulletinMois.getBulmenFeuille();
               } else if (this.modeRepartition == 1) {
                  var4 = this.bulletinMois.getBulmenFeuille();
               } else if (this.modeRepartition == 2) {
                  var4 = this.bulletinMois.getBulmenFeuille();
               } else if (this.modeRepartition == 3) {
                  var4 = this.bulletinMois.getBulmenFeuille();
               } else if (this.modeRepartition == 4) {
                  var4 = "" + Long.parseLong(this.bulletinMois.getBulmenFeuille());
               }

               if (this.salariesVariables.getSalvarFeuille() == null || this.salariesVariables.getSalvarFeuille().isEmpty() || this.salariesVariables.getSalvarFeuille() != null && !this.salariesVariables.getSalvarFeuille().isEmpty() && !this.salariesVariables.getSalvarFeuille().equals(var4)) {
                  var5 = this.salariesVariablesDao.pourParapheur(var5.getSalvarId(), var1);
                  if (var5 != null) {
                     var5.setSalvarFeuille(var4);
                     var5 = this.salariesVariablesDao.modif(var5, var1);
                  }
               }

               var3 = this.salariesVariables.getSalvarCode();

               for(int var7 = var6 + 1; var7 < this.lesVariables.size(); ++var7) {
                  var5 = (SalariesVariables)this.lesVariables.get(var7);
                  if (var5.getSalvarCode().equals(var3)) {
                     var5 = this.salariesVariablesDao.pourParapheur(var5.getSalvarId(), var1);
                     if (var5 != null) {
                        this.salariesVariablesDao.delete(this.salariesVariables, var1);
                     }
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

      this.gestionRubriques((Session)null);
   }

   public void modeCalculPaiement() {
      if (this.salaries != null) {
         if (this.salariesElements.getSaleleModeReglement() == 2) {
            this.salariesElements.setSaleleNumBanque(this.salaries.getSalNumBanque());
            this.salariesElements.setSaleleGuichetBanque(this.salaries.getSalGuichetBanque());
            this.salariesElements.setSaleleCompteBanque(this.salaries.getSalCompteBanque());
            this.salariesElements.setSaleleCleBanque(this.salaries.getSalCleBanque());
            this.salariesElements.setSaleleIban(this.salaries.getSalIban());
            this.salariesElements.setSaleleSwift(this.salaries.getSalSwift());
            this.salariesElements.setSaleleCompteMembre(this.salaries.getSalCompteMembre());
         } else {
            this.salariesElements.setSaleleNumBanque((String)null);
            this.salariesElements.setSaleleGuichetBanque((String)null);
            this.salariesElements.setSaleleCompteBanque((String)null);
            this.salariesElements.setSaleleCleBanque((String)null);
            this.salariesElements.setSaleleIban((String)null);
            this.salariesElements.setSaleleSwift((String)null);
            this.salariesElements.setSaleleCompteMembre((String)null);
         }
      }

   }

   public void saveVariables() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         var1.setFlushMode(FlushMode.MANUAL);
         this.majVariables(var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelVariable = false;
   }

   public void majVariables(Session var1) throws HibernateException, NamingException {
      if (this.lesVariables.size() != 0) {
         String var2 = "";
         String var3 = "";
         String var4 = "";
         String var5 = "";
         Date var6 = null;
         double var7 = 0.0D;
         double var9 = 0.0D;
         double var11 = 0.0D;
         double var13 = 0.0D;
         double var15 = 0.0D;
         boolean var17 = false;
         boolean var18 = false;
         boolean var19 = false;
         boolean var20 = false;
         boolean var21 = false;
         new PlanPaye();
         new SalariesVariables();

         for(int var24 = 0; var24 < this.lesVariables.size(); ++var24) {
            SalariesVariables var23 = (SalariesVariables)this.lesVariables.get(var24);
            if (this.optionPaye.getRubQuinzaine() == null || this.optionPaye.getRubQuinzaine().isEmpty() || this.optionPaye.getRubQuinzaine() != null && !this.optionPaye.getRubQuinzaine().isEmpty() && !this.optionPaye.getRubQuinzaine().equals(var23.getSalvarCode())) {
               if (this.salariesContrats != null) {
                  var2 = this.salariesContrats.getSalconNum();
               } else {
                  var2 = var23.getSalvarContrat();
               }

               var3 = var23.getSalvarCode();
               var4 = this.bulletinMois.getBulmenFeuille();
               var5 = var23.getSalvarPeriode();
               var6 = var23.getSalvarJour();
               var7 = var23.getSalvarValeurColA();
               var9 = var23.getSalvarValeurColB();
               var11 = var23.getSalvarValeurColC();
               var13 = var23.getSalvarValeurColD();
               var15 = var23.getSalvarValeurColE();
               var17 = var23.isSalvarVariableA();
               var18 = var23.isSalvarVariableB();
               var19 = var23.isSalvarVariableC();
               var20 = var23.isSalvarVariableD();
               var21 = var23.isSalvarVariableE();
               PlanPaye var22 = var23.getPlanPaye();
               var23 = this.salariesVariablesDao.pourParapheur(((SalariesVariables)this.lesVariables.get(var24)).getSalvarId(), var1);
               if (var23 == null) {
                  var23 = new SalariesVariables();
                  var23.setSalaries(this.salaries);
                  var23.setPlanPaye(var22);
                  var23.setSalvarCode(var3);
                  var23.setSalvarContrat(var2);
                  var23.setSalvarFeuille(var4);
                  var23.setSalvarJour(var6);
                  var23.setSalvarPeriode(var5);
                  var23.setSalvarValeurColA(var7);
                  var23.setSalvarValeurColB(var9);
                  var23.setSalvarValeurColC(var11);
                  var23.setSalvarValeurColD(var13);
                  var23.setSalvarValeurColE(var15);
                  var23.setSalvarVariableA(var17);
                  var23.setSalvarVariableB(var18);
                  var23.setSalvarVariableC(var19);
                  var23.setSalvarVariableD(var20);
                  var23.setSalvarVariableE(var21);
                  this.salariesVariablesDao.insert(var23, var1);
                  var1.flush();
               } else {
                  var23.setSalvarCode(var3);
                  var23.setSalvarContrat(var2);
                  var23.setSalvarFeuille(var4);
                  var23.setSalvarJour(var6);
                  var23.setSalvarPeriode(var5);
                  var23.setSalvarValeurColA(var7);
                  var23.setSalvarValeurColB(var9);
                  var23.setSalvarValeurColC(var11);
                  var23.setSalvarValeurColD(var13);
                  var23.setSalvarValeurColE(var15);
                  var23.setSalvarVariableA(var17);
                  var23.setSalvarVariableB(var18);
                  var23.setSalvarVariableC(var19);
                  var23.setSalvarVariableD(var20);
                  var23.setSalvarVariableE(var21);
                  this.salariesVariablesDao.modif(var23, var1);
                  var1.flush();
               }
            }
         }
      }

      if (this.salariesElements != null) {
         String[] var25;
         if (this.var_niveau != null && !this.var_niveau.isEmpty() && this.var_niveau.contains(":")) {
            var25 = this.var_niveau.split(":");
            this.salariesElements.setSaleleNivEmploi(var25[0]);
            if (!this.var_niveau.endsWith(":")) {
               this.salariesElements.setSaleleLibNivEmploi(var25[1]);
            } else {
               this.salariesElements.setSaleleLibNivEmploi("");
            }
         } else {
            this.salariesElements.setSaleleNivEmploi("");
            this.salariesElements.setSaleleLibNivEmploi("");
         }

         if (this.var_classement != null && !this.var_classement.isEmpty() && this.var_classement.contains(":")) {
            var25 = this.var_classement.split(":");
            this.salariesElements.setSaleleClassement(var25[0]);
            if (!this.var_classement.endsWith(":")) {
               this.salariesElements.setSaleleLibClassement(var25[1]);
            } else {
               this.salariesElements.setSaleleLibClassement("");
            }
         } else {
            this.salariesElements.setSaleleClassement("");
            this.salariesElements.setSaleleLibClassement("");
         }

         if (this.var_centre != null && !this.var_centre.isEmpty() && this.var_centre.contains(":")) {
            var25 = this.var_centre.split(":");
            this.salariesElements.setSaleleCentresImpots(var25[0]);
            if (!this.var_centre.endsWith(":")) {
               this.salariesElements.setSaleleLibCentresImpots(var25[1]);
            } else {
               this.salariesElements.setSaleleLibCentresImpots("");
            }
         } else {
            this.salariesElements.setSaleleCentresImpots("");
            this.salariesElements.setSaleleLibCentresImpots("");
         }

         int var27;
         if (this.var_securite != null && !this.var_securite.isEmpty()) {
            this.salariesElements.setSaleleCentresSecurite(this.var_securite);
            if (this.mesCentresSecuritesItems.size() != 0) {
               for(var27 = 0; var27 < this.mesCentresSecuritesItems.size(); ++var27) {
                  if (((SelectItem)this.mesCentresSecuritesItems.get(var27)).getValue().toString().equals(this.var_securite)) {
                     String[] var26 = ((SelectItem)this.mesCentresSecuritesItems.get(var27)).getLabel().toString().split(":");
                     this.salariesElements.setSaleleLibCentresSecurite(var26[0]);
                     break;
                  }
               }
            }
         } else {
            this.salariesElements.setSaleleCentresSecurite("");
            this.salariesElements.setSaleleLibCentresSecurite("");
         }

         if (this.var_convention != null && !this.var_convention.isEmpty() && this.var_convention.contains(":")) {
            var25 = this.var_convention.split(":");
            this.salariesElements.setSaleleConvention(var25[0]);
            if (!this.var_convention.endsWith(":")) {
               this.salariesElements.setSaleleLibConvention(var25[1]);
            } else {
               this.salariesElements.setSaleleLibConvention("");
            }
         } else {
            this.salariesElements.setSaleleConvention("");
            this.salariesElements.setSaleleLibConvention("");
         }

         if (this.var_grille != null && !this.var_grille.isEmpty() && this.var_grille.contains(":")) {
            var25 = this.var_grille.split(":");
            this.salariesElements.setSaleleGrille(var25[0]);
            if (!this.var_grille.endsWith(":")) {
               this.salariesElements.setSaleleLibGrille(var25[1]);
            } else {
               this.salariesElements.setSaleleLibGrille("");
            }
         } else {
            this.salariesElements.setSaleleGrille("");
            this.salariesElements.setSaleleLibGrille("");
         }

         if (this.var_service != null && !this.var_service.isEmpty() && this.var_service.contains(":")) {
            var25 = this.var_service.split(":");
            this.salariesElements.setSaleleService(var25[0]);
            if (!this.var_service.endsWith(":")) {
               this.salariesElements.setSaleleLibService(var25[1]);
            } else {
               this.salariesElements.setSaleleLibService("");
            }
         } else {
            this.salariesElements.setSaleleService("");
            this.salariesElements.setSaleleLibService("");
         }

         if (this.var_cle1 != null && !this.var_cle1.isEmpty() && this.var_cle1.contains(":")) {
            var25 = this.var_cle1.split(":");
            this.salariesElements.setSaleleCle1Anal(var25[0]);
            if (!this.var_cle1.endsWith(":")) {
               this.salariesElements.setSaleleLibCle1Anal(var25[1]);
            } else {
               this.salariesElements.setSaleleLibCle1Anal("");
            }
         } else {
            this.salariesElements.setSaleleCle1Anal("");
            this.salariesElements.setSaleleLibCle1Anal("");
         }

         if (this.var_cle2 != null && !this.var_cle2.isEmpty() && this.var_cle2.contains(":")) {
            var25 = this.var_cle2.split(":");
            this.salariesElements.setSaleleCle2Anal(var25[0]);
            if (!this.var_cle2.endsWith(":")) {
               this.salariesElements.setSaleleLibCle2Anal(var25[1]);
            } else {
               this.salariesElements.setSaleleLibCle2Anal("");
            }
         } else {
            this.salariesElements.setSaleleCle2Anal("");
            this.salariesElements.setSaleleLibCle2Anal("");
         }

         if (!this.decoupageActivite) {
            if (this.var_activite != null && !this.var_activite.isEmpty() && this.var_activite.contains(":")) {
               var25 = this.var_activite.split(":");
               this.salariesElements.setSaleleActivite(var25[0]);
            } else {
               this.salariesElements.setSaleleActivite("");
            }
         }

         if (this.salariesContrats != null) {
            this.salariesElements.setSaleleContrat(this.salariesContrats.getSalconNum());
            this.salariesElements.setSaleleActivite(this.salariesContrats.getSalconActivite());
            this.salariesElements.setSaleleBudget(this.salariesContrats.getSalconBudget());
            this.salariesElements.setSaleleCle1Anal(this.salariesContrats.getSalconCle1Anal());
            this.salariesElements.setSaleleCle2Anal(this.salariesContrats.getSalconCle2Anal());
            this.salariesElements.setSaleleDepartement(this.salariesContrats.getSalconDepartement());
            this.salariesElements.setSaleleFeuille(this.salariesContrats.getSalconFeuille());
            this.salariesElements.setSaleleFonction(this.salariesContrats.getSalconFonction());
            this.salariesElements.setSaleleLibCle1Anal(this.salariesContrats.getSalconLibCle1Anal());
            this.salariesElements.setSaleleLibCle2Anal(this.salariesContrats.getSalconLibCle2Anal());
            this.salariesElements.setSaleleLibService(this.salariesContrats.getSalconLibService());
            this.salariesElements.setSaleleParc(this.salariesContrats.getSalconParc());
            this.salariesElements.setSaleleService(this.salariesContrats.getSalconService());
            this.salariesElements.setSaleleSite(this.salariesContrats.getSalconSite());
            this.salariesElements.setSaleleNbJourCp(this.salariesContrats.getSalconNbJourCp());
            this.salariesElements.setSaleleNbJourTr(this.salariesContrats.getSalconNbJourTr());
         }

         if (this.salariesElements.getSaleleId() == 0L) {
            this.salariesElements.setSalaries(this.salaries);
            this.salariesElements.setSaleleDateCreat(new Date());
            this.salariesElements.setSaleleUserCreat(this.usersLog.getUsrid());
            this.salariesElements = this.salariesElementsDao.insert(this.salariesElements, var1);
         } else {
            this.salariesElements.setSaleleDateModif(new Date());
            this.salariesElements.setSaleleUserModif(this.usersLog.getUsrid());
            this.salariesElements = this.salariesElementsDao.modif(this.salariesElements, var1);
         }

         var1.flush();
         if (this.salariesContrats != null) {
            if (this.salariesContrats.getSalconBase() == 0.0D && this.salariesContrats.getSalconConvention() != null && !this.salariesContrats.getSalconConvention().isEmpty() && this.salariesContrats.getSalconGrille() != null && !this.salariesContrats.getSalconGrille().isEmpty()) {
               this.var_convention = this.salariesContrats.getSalconConvention() + ":" + this.salariesContrats.getSalconLibConvention();
               this.chargerGrille();
               if (this.lesGrilles.size() != 0) {
                  for(var27 = 0; var27 < this.lesGrilles.size(); ++var27) {
                     if (((ObjetGrilleSalaire)this.lesGrilles.get(var27)).getCode().equals(this.salariesContrats.getSalconGrille())) {
                        if (this.salariesContrats.getSalconType() != null && !this.salariesContrats.getSalconType().isEmpty() && (this.salariesContrats.getSalconType().equals("03D") || this.salariesContrats.getSalconType().equals("03I"))) {
                           this.salariesContrats.setSalconBase((double)((ObjetGrilleSalaire)this.lesGrilles.get(var27)).getVal_heure());
                        } else if (this.salariesContrats.getSalconType() == null || this.salariesContrats.getSalconType().isEmpty() || !this.salariesContrats.getSalconType().equals("13") && !this.salariesContrats.getSalconType().equals("14")) {
                           if (this.salariesContrats.getSalconType() != null && !this.salariesContrats.getSalconType().isEmpty() && this.salariesContrats.getSalconType().equals("04")) {
                              this.salariesContrats.setSalconBase((double)((ObjetGrilleSalaire)this.lesGrilles.get(var27)).getVal_heure());
                           } else {
                              this.salariesContrats.setSalconBase((double)((ObjetGrilleSalaire)this.lesGrilles.get(var27)).getVal_mois());
                           }
                        } else {
                           this.salariesContrats.setSalconBase(0.0D);
                        }
                        break;
                     }
                  }
               }
            }

            this.salariesContrats.setSalconConvention(this.salariesElements.getSaleleConvention());
            this.salariesContrats.setSalconGrille(this.salariesElements.getSaleleGrille());
            this.salariesContrats.setSalconClassement(this.salariesElements.getSaleleClassement());
            this.salariesContrats.setSalconCentresImpots(this.salariesElements.getSaleleCentresImpots());
            this.salariesContrats.setSalconCentresSecurite(this.salariesElements.getSaleleCentresSecurite());
            this.salariesContrats.setSalconNivEmploi(this.salariesElements.getSaleleNivEmploi());
            this.salariesContrats.setSalconLibCentresImpots(this.salariesElements.getSaleleLibCentresImpots());
            this.salariesContrats.setSalconLibCentresSecurite(this.salariesElements.getSaleleLibCentresSecurite());
            this.salariesContrats.setSalconLibClassement(this.salariesElements.getSaleleLibClassement());
            this.salariesContrats.setSalconLibNivEmploi(this.salariesElements.getSaleleLibNivEmploi());
            this.salariesContrats.setSalconLibConvention(this.salariesElements.getSaleleLibConvention());
            this.salariesContrats.setSalconLibGrille(this.salariesElements.getSaleleLibGrille());
            this.salariesContrats.setSalconFonction(this.salariesElements.getSaleleFonction());
            this.salariesContrats.setSalconEtat(this.salariesElements.getSaleleEtat());
            if (this.salariesElements.getSaleleEtat() != 9) {
               this.salariesContrats.setSalconDateFin(this.salariesElements.getSaleleDateSortie());
            }

            this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats, var1);
            var1.flush();
         }

         if (this.salaries != null) {
            this.salaries = this.salariesDao.chercherIdSalaries(this.salaries.getSalId(), var1);
            if (this.salaries != null) {
               this.salaries.setSalActivite(this.salariesElements.getSaleleActivite());
               this.salaries.setSalBudget(this.salariesElements.getSaleleBudget());
               this.salaries.setSalCentresImpots(this.salariesElements.getSaleleCentresImpots());
               this.salaries.setSalCentresSecurite(this.salariesElements.getSaleleCentresSecurite());
               this.salaries.setSalClassement(this.salariesElements.getSaleleClassement());
               this.salaries.setSalCleAnal1(this.salariesElements.getSaleleCle1Anal());
               this.salaries.setSalCleAnal2(this.salariesElements.getSaleleCle2Anal());
               this.salaries.setSalConvention(this.salariesElements.getSaleleConvention());
               this.salaries.setSalDateConcubinage(this.salariesElements.getSaleleDateConcubinage());
               this.salaries.setSalDateDivorce(this.salariesElements.getSaleleDateDivorce());
               this.salaries.setSalDateMarie(this.salariesElements.getSaleleDateMarie());
               this.salaries.setSalDatePacs(this.salariesElements.getSaleleDatePacs());
               this.salaries.setSalDateVeuf(this.salariesElements.getSaleleDateVeuf());
               this.salaries.setSalDepartement(this.salariesElements.getSaleleDepartement());
               this.salaries.setSalEtat(this.salariesElements.getSaleleEtat());
               this.salaries.setSalFonction(this.salariesElements.getSaleleFonction());
               this.salaries.setSalGrille(this.salariesElements.getSaleleGrille());
               this.salaries.setSalLibCentresImpots(this.salariesElements.getSaleleLibCentresImpots());
               this.salaries.setSalLibCentresSecurite(this.salariesElements.getSaleleLibCentresSecurite());
               this.salaries.setSalLibClassement(this.salariesElements.getSaleleLibClassement());
               this.salaries.setSalLibCleAnal1(this.salariesElements.getSaleleLibCle1Anal());
               this.salaries.setSalLibCleAnal2(this.salariesElements.getSaleleLibCle2Anal());
               this.salaries.setSalLibConvention(this.salariesElements.getSaleleLibConvention());
               this.salaries.setSalLibGrille(this.salariesElements.getSaleleLibGrille());
               this.salaries.setSalLibNivEmploi(this.salariesElements.getSaleleLibNivEmploi());
               this.salaries.setSalNbEnfant(this.salariesElements.getSaleleNbEnfant());
               this.salaries.setSalNbFemme(this.salariesElements.getSaleleNbFemme());
               this.salaries.setSalNbJourCp(this.salariesElements.getSaleleNbJourCp());
               this.salaries.setSalNbJourTr(this.salariesElements.getSaleleNbJourTr());
               this.salaries.setSalNbPartFiscal(this.salariesElements.getSaleleNbPartFiscal());
               this.salaries.setSalNbPartTrimf(this.salariesElements.getSaleleNbPartTrimf());
               this.salaries.setSalNivEmploi(this.salariesElements.getSaleleNivEmploi());
               this.salaries.setSalParc(this.salariesElements.getSaleleParc());
               this.salaries.setSalService(this.salariesElements.getSaleleService());
               this.salaries.setSalLibService(this.salariesElements.getSaleleLibService());
               this.salaries.setSalSitFamille(this.salariesElements.getSaleleSitFamille());
               this.salaries.setSalSite(this.salariesElements.getSaleleSite());
               this.salaries.setSalDateEntree(this.salariesElements.getSaleleDateEntree());
               this.salaries.setSalDateSortie(this.salariesElements.getSaleleDateSortie());
               this.salaries.setSalMotifSortie(this.salariesElements.getSaleleMotifSortie());
               this.salaries.setSalModeReglement(this.salariesElements.getSaleleModeReglement());
               if (this.salariesElements.getSaleleCompteBanque() != null && !this.salariesElements.getSaleleCompteBanque().isEmpty()) {
                  this.salaries.setSalNumBanque(this.salariesElements.getSaleleNumBanque());
                  this.salaries.setSalGuichetBanque(this.salariesElements.getSaleleGuichetBanque());
                  this.salaries.setSalCompteBanque(this.salariesElements.getSaleleCompteBanque());
                  this.salaries.setSalCleBanque(this.salariesElements.getSaleleCleBanque());
                  this.salaries.setSalIban(this.salariesElements.getSaleleIban());
                  this.salaries.setSalSwift(this.salariesElements.getSaleleSwift());
                  this.salaries.setSalCompteMembre(this.salariesElements.getSaleleCompteMembre());
               }

               this.salaries = this.salariesDao.modif(this.salaries, var1);
               var1.flush();
            }
         }

         if (this.salariesElements != null) {
            this.salariesContrats.setEffectue(true);
         } else {
            this.salariesContrats.setEffectue(false);
         }
      }

   }

   public void saveRubriques() throws HibernateException, NamingException {
      if (this.lesSalariesRubriques.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            new PlanPaye();

            for(int var4 = 0; var4 < this.lesSalariesRubriques.size(); ++var4) {
               this.salariesVariables = (SalariesVariables)this.lesSalariesRubriques.get(var4);
               String var5 = this.salariesVariables.getSalvarFeuille();
               String var6 = this.salariesVariables.getSalvarContrat();
               String var7 = this.salariesVariables.getSalvarCode();
               String var8 = this.salariesVariables.getSalvarPeriode();
               Date var9 = this.salariesVariables.getSalvarJour();
               double var10 = this.salariesVariables.getSalvarValeurColA();
               double var12 = this.salariesVariables.getSalvarValeurColB();
               double var14 = this.salariesVariables.getSalvarValeurColC();
               double var16 = this.salariesVariables.getSalvarValeurColD();
               double var18 = this.salariesVariables.getSalvarValeurColE();
               PlanPaye var3 = this.salariesVariables.getPlanPaye();
               this.salaries = this.salariesVariables.getSalaries();
               this.salariesVariables = this.salariesVariablesDao.chargerlesVariablesPeriodeRubrique(this.salaries, var8, var6, var7, var1);
               if (this.salariesVariables != null) {
                  this.salariesVariables.setSalvarValeurColA(var10);
                  this.salariesVariables.setSalvarValeurColB(var12);
                  this.salariesVariables.setSalvarValeurColC(var14);
                  this.salariesVariables.setSalvarValeurColD(var16);
                  this.salariesVariables.setSalvarValeurColE(var18);
                  this.salariesVariables = this.salariesVariablesDao.modif(this.salariesVariables, var1);
               } else {
                  this.salariesVariables = new SalariesVariables();
                  this.salariesVariables.setSalvarJour(var9);
                  this.salariesVariables.setSalvarValeurColA(var10);
                  this.salariesVariables.setSalvarValeurColB(var12);
                  this.salariesVariables.setSalvarValeurColC(var14);
                  this.salariesVariables.setSalvarValeurColD(var16);
                  this.salariesVariables.setSalvarValeurColE(var18);
                  this.salariesVariables.setSalvarFeuille(this.bulletinMois.getBulmenFeuille());
                  this.salariesVariables.setSalvarContrat(var6);
                  this.salariesVariables.setSalvarCode(var7);
                  this.salariesVariables.setSalvarPeriode(var8);
                  this.salariesVariables.setPlanPaye(var3);
                  this.salariesVariables.setSalaries(this.salaries);
                  this.salariesVariables = this.salariesVariablesDao.insert(this.salariesVariables, var1);
               }

               var1.flush();
            }

            var2.commit();
         } catch (HibernateException var23) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var23;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void saveHistoriques() throws HibernateException, NamingException {
      if (this.lesSasiesHistoriques.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            new ArrayList();
            new SalariesHistorique();

            for(int var5 = 0; var5 < this.lesSasiesHistoriques.size(); ++var5) {
               this.salariesContrats = (SalariesContrats)this.lesContrats.get(var5);
               this.salaries = this.salariesContrats.getSalaries();
               List var3;
               SalariesHistorique var4;
               if (this.salariesContrats.getHistoAdm() != 0.0D) {
                  if (this.salariesContrats != null) {
                     var3 = this.salariesHistoriqueDao.chargerlesHistoriquesByCode(this.salaries, this.salariesContrats.getSalconNum(), this.exercicesPaye, "ADM", var1);
                  } else {
                     var3 = this.salariesHistoriqueDao.chargerlesHistoriquesByCode(this.salaries, "", this.exercicesPaye, "ADM", var1);
                  }

                  if (var3.size() != 0) {
                     var4 = (SalariesHistorique)var3.get(0);
                  } else {
                     var4 = new SalariesHistorique();
                  }

                  var4.setExercicesPaye(this.exercicesPaye);
                  var4.setSalaries(this.salaries);
                  var4.setSalhisCode("ADM");
                  var4.setSalhisContrat(this.salariesContrats.getSalconNum());
                  var4.setSalhisDate(this.exercicesPaye.getExepayDateDebut());
                  var4.setSalhisLibelle("Appoint dernier mois");
                  var4.setSalhisValeurColE(this.salariesContrats.getHistoAdm());
                  if (var4.getSalhisId() == 0L) {
                     this.salariesHistoriqueDao.insert(var4, var1);
                  } else {
                     this.salariesHistoriqueDao.modif(var4, var1);
                  }

                  var1.flush();
               }

               if (this.salariesContrats.getHistoBrut() != 0.0D) {
                  if (this.salariesContrats != null) {
                     var3 = this.salariesHistoriqueDao.chargerlesHistoriquesByCode(this.salaries, this.salariesContrats.getSalconNum(), this.exercicesPaye, "BRUT", var1);
                  } else {
                     var3 = this.salariesHistoriqueDao.chargerlesHistoriquesByCode(this.salaries, "", this.exercicesPaye, "BRUT", var1);
                  }

                  if (var3.size() != 0) {
                     var4 = (SalariesHistorique)var3.get(0);
                  } else {
                     var4 = new SalariesHistorique();
                  }

                  var4.setExercicesPaye(this.exercicesPaye);
                  var4.setSalaries(this.salaries);
                  var4.setSalhisCode("BRUT");
                  var4.setSalhisContrat(this.salariesContrats.getSalconNum());
                  var4.setSalhisDate(this.exercicesPaye.getExepayDateDebut());
                  var4.setSalhisLibelle("Salaire Brut");
                  var4.setSalhisValeurColE(this.salariesContrats.getHistoBrut());
                  if (var4.getSalhisId() == 0L) {
                     this.salariesHistoriqueDao.insert(var4, var1);
                  } else {
                     this.salariesHistoriqueDao.modif(var4, var1);
                  }

                  var1.flush();
               }

               if (this.salariesContrats.getHistoNbjs() != 0.0D) {
                  if (this.salariesContrats != null) {
                     var3 = this.salariesHistoriqueDao.chargerlesHistoriquesByCode(this.salaries, this.salariesContrats.getSalconNum(), this.exercicesPaye, "NBJS", var1);
                  } else {
                     var3 = this.salariesHistoriqueDao.chargerlesHistoriquesByCode(this.salaries, "", this.exercicesPaye, "NBJS", var1);
                  }

                  if (var3.size() != 0) {
                     var4 = (SalariesHistorique)var3.get(0);
                  } else {
                     var4 = new SalariesHistorique();
                  }

                  var4.setExercicesPaye(this.exercicesPaye);
                  var4.setSalaries(this.salaries);
                  var4.setSalhisCode("NBJS");
                  var4.setSalhisContrat(this.salariesContrats.getSalconNum());
                  var4.setSalhisDate(this.exercicesPaye.getExepayDateDebut());
                  var4.setSalhisLibelle("Nombre de jours de congés acquis");
                  var4.setSalhisValeurColE(this.salariesContrats.getHistoNbjs());
                  if (var4.getSalhisId() == 0L) {
                     this.salariesHistoriqueDao.insert(var4, var1);
                  } else {
                     this.salariesHistoriqueDao.modif(var4, var1);
                  }

                  var1.flush();
               }

               if (this.salariesContrats.getHistoCp() != 0.0D) {
                  if (this.salariesContrats != null) {
                     var3 = this.salariesHistoriqueDao.chargerlesHistoriquesByCode(this.salaries, this.salariesContrats.getSalconNum(), this.exercicesPaye, "CP", var1);
                  } else {
                     var3 = this.salariesHistoriqueDao.chargerlesHistoriquesByCode(this.salaries, "", this.exercicesPaye, "CP", var1);
                  }

                  if (var3.size() != 0) {
                     var4 = (SalariesHistorique)var3.get(0);
                  } else {
                     var4 = new SalariesHistorique();
                  }

                  var4.setExercicesPaye(this.exercicesPaye);
                  var4.setSalaries(this.salaries);
                  var4.setSalhisCode("CP");
                  var4.setSalhisContrat(this.salariesContrats.getSalconNum());
                  var4.setSalhisDate(this.exercicesPaye.getExepayDateDebut());
                  var4.setSalhisLibelle("Congés Payés");
                  var4.setSalhisValeurColE(this.salariesContrats.getHistoCp());
                  if (var4.getSalhisId() == 0L) {
                     this.salariesHistoriqueDao.insert(var4, var1);
                  } else {
                     this.salariesHistoriqueDao.modif(var4, var1);
                  }

                  var1.flush();
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

   }

   public void saveCompteVrt() throws HibernateException, NamingException {
      if (this.lesCompteVrt.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);

            for(int var3 = 0; var3 < this.lesCompteVrt.size(); ++var3) {
               this.salariesElements = (SalariesElements)this.lesCompteVrt.get(var3);
               this.salaries = this.salariesElements.getSalaries();
               this.salaries.setSalNumBanque(this.salariesElements.getSaleleNumBanque());
               this.salaries.setSalGuichetBanque(this.salariesElements.getSaleleGuichetBanque());
               this.salaries.setSalCompteBanque(this.salariesElements.getSaleleCompteBanque());
               this.salaries.setSalCleBanque(this.salariesElements.getSaleleCleBanque());
               this.salaries.setSalCompteMembre(this.salariesElements.getSaleleCompteMembre());
               this.salaries = this.salariesDao.modif(this.salaries, var1);
               var1.flush();
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

   public void saveImmatriculation() throws HibernateException, NamingException {
      if (this.lesImmatriculations.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);

            for(int var3 = 0; var3 < this.lesImmatriculations.size(); ++var3) {
               this.salaries = (Salaries)this.lesImmatriculations.get(var3);
               this.salaries = this.salariesDao.modif(this.salaries, var1);
               var1.flush();
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

   public void gelerImputationContrat() throws HibernateException, NamingException {
      if (this.salariesContrats != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.salariesContrats.setSalconEtat(9);
            this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats, var1);
            this.salaries.setSalEtat(9);
            this.salariesDao.modif(this.salaries, var1);
            this.salariesElements = this.salariesElementsDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), this.salariesContrats.getSalconNum(), var1);
            if (this.salariesElements != null) {
               this.salariesElements.setSaleleEtat(9);
               this.salariesElements = this.salariesElementsDao.modif(this.salariesElements, var1);
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

   public void degelerImputationContrat() throws HibernateException, NamingException {
      if (this.salariesContrats != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.salariesContrats.setSalconEtat(0);
            this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats, var1);
            this.salaries.setSalEtat(0);
            this.salariesDao.modif(this.salaries, var1);
            this.salariesElements = this.salariesElementsDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), this.salariesContrats.getSalconNum(), var1);
            if (this.salariesElements != null) {
               this.salariesElements.setSaleleEtat(0);
               this.salariesElements = this.salariesElementsDao.modif(this.salariesElements, var1);
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

   public void razSaisieRubrique() {
      this.variableSaisie = "";
      this.lesRubriques.clear();
      this.datamodelRubriques.setWrappedData(this.lesRubriques);
   }

   public void razSaisieHistorique() {
      this.lesHistoriques.clear();
      this.dataModelSasiesHistoriques.setWrappedData(this.lesHistoriques);
   }

   public void razSaisieCompteVrt() {
      this.lesCompteVrt.clear();
      this.dataModelComptesVrt.setWrappedData(this.lesRubriques);
   }

   public void razSaisieImmatriculation() {
      this.lesImmatriculations.clear();
      this.dataModelImmatriculation.setWrappedData(this.lesImmatriculations);
   }

   public void razSaisieNb() {
      this.lesNb.clear();
      this.dataModelNb.setWrappedData(this.lesNb);
   }

   public void selectionAgentNb() throws HibernateException, NamingException {
      if (this.dataModelNb.isRowAvailable()) {
         this.salaries = (Salaries)this.dataModelNb.getRowData();
         this.lesSalariesGrh = this.salariesGrhDao.chargerlesElementRh(this.salaries, (Session)null);
      }

   }

   public void saveNb() throws HibernateException, NamingException {
      if (this.lesNb.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);

            for(int var3 = 0; var3 < this.lesNb.size(); ++var3) {
               this.salaries = (Salaries)this.lesNb.get(var3);
               this.salaries = this.salariesDao.chercherIdSalaries(this.salaries.getSalId(), var1);
               if (this.salaries != null) {
                  this.calculNbPartsPreparation(var1);
                  this.salaries = this.salariesDao.modif(this.salaries, var1);
                  this.salariesElements = this.salariesElementsDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), this.salaries.getNumContrat(), var1);
                  if (this.salariesElements != null) {
                     this.salariesElements.setSaleleSitFamille(this.salaries.getSalSitFamille());
                     this.salariesElements.setSaleleNbEnfant(this.salaries.getSalNbEnfant());
                     this.salariesElements.setSaleleNbFemme(this.salaries.getSalNbFemme());
                     this.salariesElements.setSaleleNbPartTrimf(this.salaries.getSalNbPartTrimf());
                     this.salariesElements.setSaleleNbPartFiscal(this.salaries.getSalNbPartFiscal());
                     this.salariesElements = this.salariesElementsDao.modif(this.salariesElements, var1);
                  } else {
                     this.salariesElements = new SalariesElements();
                     this.salariesElements.setSaleleSitFamille(this.salaries.getSalSitFamille());
                     this.salariesElements.setSaleleNbEnfant(this.salaries.getSalNbEnfant());
                     this.salariesElements.setSaleleNbFemme(this.salaries.getSalNbFemme());
                     this.salariesElements.setSaleleNbPartTrimf(this.salaries.getSalNbPartTrimf());
                     this.salariesElements.setSaleleNbPartFiscal(this.salaries.getSalNbPartFiscal());
                     this.salariesElements.setSaleleNivEmploi(this.salaries.getSalNivEmploi());
                     this.salariesElements.setSaleleLibNivEmploi(this.salaries.getSalLibNivEmploi());
                     this.salariesElements.setSaleleClassement(this.salaries.getSalClassement());
                     this.salariesElements.setSaleleLibClassement(this.salaries.getSalLibClassement());
                     this.salariesElements.setSaleleCentresImpots(this.salaries.getSalCentresImpots());
                     this.salariesElements.setSaleleLibCentresImpots(this.salaries.getSalLibCentresImpots());
                     this.salariesElements.setSaleleCentresSecurite(this.salaries.getSalCentresSecurite());
                     this.salariesElements.setSaleleLibCentresSecurite(this.salaries.getSalLibCentresSecurite());
                     this.salariesElements.setSaleleConvention(this.salaries.getSalConvention());
                     this.salariesElements.setSaleleLibConvention(this.salaries.getSalLibConvention());
                     this.salariesElements.setSaleleGrille(this.salaries.getSalGrille());
                     this.salariesElements.setSaleleLibGrille(this.salaries.getSalLibGrille());
                     this.salariesElements.setSaleleCle1Anal(this.salaries.getSalCleAnal1());
                     this.salariesElements.setSaleleCle2Anal(this.salaries.getSalCleAnal2());
                     this.salariesElements.setSaleleActivite(this.salaries.getSalActivite());
                     this.salariesElements.setSaleleService(this.salaries.getSalService());
                     this.salariesElements.setSalelePeriode(this.bulletinMois.getBulmenPeriode());
                     this.salariesElements.setSaleleJour((Date)null);
                     this.salariesElements.setSalaries(this.salaries);
                     this.salariesElements.setSaleleDateCreat(new Date());
                     this.salariesElements.setSaleleUserCreat(this.usersLog.getUsrid());
                     this.salariesElements = this.salariesElementsDao.insert(this.salariesElements, var1);
                  }

                  var1.flush();
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

   public void ouvrePanelEnfant() {
   }

   public void ouvrePanelFemme() {
   }

   public void informationPiecePRE() throws HibernateException, NamingException {
      if (this.salariesElements != null) {
         this.nomCreation = "";
         this.nomModification = "";
         new Users();
         UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Users var1;
         if (this.salariesElements.getSaleleUserCreat() != 0L) {
            var1 = var2.selectUserD(this.salariesElements.getSaleleUserCreat(), var3);
            if (var1 != null) {
               this.nomCreation = var1.getUsrPatronyme();
            }
         }

         if (this.salariesElements.getSaleleUserModif() != 0L) {
            var1 = var2.selectUserD(this.salariesElements.getSaleleUserModif(), var3);
            if (var1 != null) {
               this.nomModification = var1.getUsrPatronyme();
            }
         }

         this.utilInitHibernate.closeSession();
         this.showModalPanelInformation = true;
      }

   }

   public void fermerInformationPiece() {
      this.showModalPanelInformation = false;
   }

   public void selectionPeriodeQuinzaine() throws ParseException, ParseException, HibernateException, NamingException {
      if (this.feuilleCalcul != null && this.dataModelPeriodes.isRowAvailable()) {
         this.bulletinMois = (BulletinMois)this.dataModelPeriodes.getRowData();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            if (this.bulletinMois.getBulmenEtat() <= 2) {
               this.bulletinMois.setBulmenUserIdJournal(this.usersLog.getUsrid());
               this.bulletinMois.setBulmenOpenUserJournal(this.usersLog.getUsrPatronyme());
               this.bulletinMois.setBulmenOpenJournal(1);
               this.bulletinMois = this.bulletinMoisDao.majJournal(this.bulletinMois, var1);
               var1.flush();
            }

            this.var_feuille_rec = "";
            this.var_activite_rec = "";
            this.var_localisation_rec = "";
            this.var_service_rec = "";
            this.var_projet_rec = "";
            this.var_idclient_rec = 0L;
            if (this.modeRepartition == 0) {
               this.var_feuille_rec = this.bulletinMois.getBulmenFeuille();
            } else if (this.modeRepartition == 1) {
               this.var_activite_rec = this.bulletinMois.getBulmenFeuille();
            } else if (this.modeRepartition == 2) {
               this.var_service_rec = this.bulletinMois.getBulmenFeuille();
            } else if (this.modeRepartition == 3) {
               this.var_projet_rec = this.bulletinMois.getBulmenFeuille();
            } else if (this.modeRepartition == 4) {
               this.var_idclient_rec = Long.parseLong(this.bulletinMois.getBulmenFeuille());
            }

            this.chagerSalarieQuinzaine(var1);
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.var_affiche_bouton = false;
         if (this.feuilleCalcul.getFeuNature() != null && !this.feuilleCalcul.getFeuNature().isEmpty() && this.feuilleCalcul.getFeuNature().startsWith("04")) {
            this.var_action = 3;
         } else {
            this.var_action = 2;
         }
      }

   }

   public void chagerSalarieQuinzaine() throws ParseException, HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         var1.setFlushMode(FlushMode.MANUAL);
         this.chagerSalarieQuinzaine(var1);
         var2.commit();
      } catch (HibernateException var7) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var7;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_affiche_bouton = false;
      if (this.feuilleCalcul.getFeuNature() != null && !this.feuilleCalcul.getFeuNature().isEmpty() && this.feuilleCalcul.getFeuNature().startsWith("04")) {
         this.var_action = 3;
      } else {
         this.var_action = 2;
      }

   }

   public void chagerSalarieQuinzaine(Session var1) throws ParseException, HibernateException, NamingException {
      if (this.feuilleCalcul.getFeuNature() != null && !this.feuilleCalcul.getFeuNature().isEmpty() && this.feuilleCalcul.getFeuNature().startsWith("04")) {
         this.dateGeneration = this.bulletinMois.getBulmenJour();
         this.d1 = this.utilDate.datePremierJourMois(this.dateGeneration);
         this.d2 = this.utilDate.dateDernierJourMois(this.dateGeneration);
         this.lesSalaries.clear();
         this.lesElements.clear();
         int var7 = Integer.parseInt(this.optionPaye.getTriAgents());
         new ArrayList();
         List var8 = this.salariesElementsDao.chargerlesElementsByJournaliers(this.dateGeneration, var7, this.bulletinMois.getBulmenFeuille(), var1);
         if (var8.size() != 0) {
            for(int var10 = 0; var10 < var8.size(); ++var10) {
               this.salariesElements = (SalariesElements)var8.get(var10);
               this.salaries = this.salariesElements.getSalaries();
               if (this.usersLog.getUsrPaye() == 0 || this.usersLog.getUsrPaye() != 0 && this.salaries.getSalProtege() == 0 || this.usersLog.getUsrPaye() == 5 && this.salaries.getSalProtege() == 1) {
                  this.salariesElements.setEffectue(true);
                  this.lesElements.add(this.salariesElements);
               }
            }
         }

         this.listeVariableQuinzaine(var1);
         this.dataModelLesElements.setWrappedData(this.lesElements);
      } else {
         String[] var2 = this.bulletinMois.getBulmenPeriode().split(":");
         this.dateGeneration = this.utilDate.stringToDateSQLLight(var2[1] + "-" + var2[0] + "-01");
         int var3;
         if (this.feuilleCalcul.getFeuDecale() != 0) {
            var3 = this.feuilleCalcul.getFeuDecale() * -1;
            Date var4 = this.utilDate.datePremierJourMois(this.dateGeneration);
            this.d1 = this.utilDate.datedevaleurTheo(var4, var3);
            Date var5 = this.utilDate.dateDernierJourMois(this.dateGeneration);
            this.d2 = this.utilDate.datedevaleurTheo(var5, var3);
         } else {
            this.d1 = this.utilDate.datePremierJourMois(this.dateGeneration);
            this.d2 = this.utilDate.dateDernierJourMois(this.dateGeneration);
         }

         this.lesSalaries.clear();
         this.lesContrats.clear();
         var3 = Integer.parseInt(this.optionPaye.getTriAgents());
         new ArrayList();
         List var9 = this.salariesContratsDao.listelesContratsActif(this.modeRepartition, var3, this.d1, this.d2, this.bulletinMois.getBulmenFeuille(), this.var_agent_rec, this.var_activite_rec, this.var_service_rec, this.var_departement_rec, this.var_localisation_rec, this.var_projet_rec, this.var_feuille_rec, this.var_idclient_rec, var1);
         if (var9.size() != 0) {
            for(int var11 = 0; var11 < var9.size(); ++var11) {
               this.salariesContrats = (SalariesContrats)var9.get(var11);
               this.salaries = this.salariesContrats.getSalaries();
               this.salaries.setSalFeuille(this.salariesContrats.getSalconFeuille());
               if (this.usersLog.getUsrPaye() == 0 || this.usersLog.getUsrPaye() != 0 && this.salaries.getSalProtege() == 0 || this.usersLog.getUsrPaye() == 5 && this.salaries.getSalProtege() == 1) {
                  boolean var6 = false;
                  if (this.salariesContrats != null) {
                     var6 = this.salariesElementsDao.testelesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), this.salariesContrats.getSalconNum(), var1);
                  } else {
                     var6 = this.salariesElementsDao.testelesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), "", var1);
                  }

                  if (var6) {
                     this.salariesContrats.setEffectue(true);
                     this.lesContrats.add(this.salariesContrats);
                  } else if (this.salaries.getSalEtat() <= 1) {
                     this.salariesContrats.setEffectue(false);
                     this.lesContrats.add(this.salariesContrats);
                  }
               }
            }
         }

         this.listeVariableQuinzaine(var1);
         this.dataModelContrats.setWrappedData(this.lesContrats);
      }

      this.rechercheCompteVrtQuinzaine(var1);
   }

   public void listeVariableQuinzaine(Session var1) throws HibernateException, NamingException {
      this.lesSalariesRubriques.clear();
      this.variableSaisie = this.optionPaye.getRubQuinzaine();
      if (this.variableSaisie != null && !this.variableSaisie.isEmpty() && !this.variableSaisie.equals("0")) {
         if (this.modeRepartition == 0) {
            this.rechercheVariablesServices(var1);
         } else if (this.modeRepartition == 1) {
            this.rechercheVariablesServices(var1);
         } else if (this.modeRepartition == 2) {
            this.rechercheVariablesServices(var1);
         } else if (this.modeRepartition == 3) {
            this.rechercheVariablesProjets(var1);
         } else if (this.modeRepartition == 4) {
            this.rechercheVariablesServices(var1);
         }
      }

      this.datamodelRubriques.setWrappedData(this.lesSalariesRubriques);
      if (this.lesSalariesRubriques.size() != 0) {
         this.salariesVariables = (SalariesVariables)this.lesSalariesRubriques.get(0);
      } else {
         this.salariesVariables = new SalariesVariables();
      }

   }

   public void rechercheCompteVrtQuinzaine(Session var1) throws HibernateException, NamingException {
      this.lesSalaries.clear();
      if (this.lesContrats.size() != 0) {
         for(int var2 = 0; var2 < this.lesContrats.size(); ++var2) {
            this.salariesContrats = (SalariesContrats)this.lesContrats.get(var2);
            this.salaries = this.salariesContrats.getSalaries();
            this.lesSalaries.add(this.salaries);
         }
      }

      this.dataModelComptesVrt.setWrappedData(this.lesSalaries);
   }

   public void recopieCompteVrtQuinzaine() throws HibernateException, NamingException {
      if (this.lesSalaries.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviPaye");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);

            for(int var3 = 0; var3 < this.lesSalaries.size(); ++var3) {
               this.salaries = (Salaries)this.lesSalaries.get(var3);
               this.salaries.setSalModeReglement15(this.salaries.getSalModeReglement());
               this.salaries.setSalNumBanque15(this.salaries.getSalNumBanque());
               this.salaries.setSalGuichetBanque15(this.salaries.getSalGuichetBanque());
               this.salaries.setSalCompteBanque15(this.salaries.getSalCompteBanque());
               this.salaries.setSalCleBanque15(this.salaries.getSalCleBanque());
               this.salaries.setSalIban15(this.salaries.getSalIban());
               this.salaries.setSalSwift15(this.salaries.getSalSwift());
               this.salaries.setSalCompteMembre15(this.salaries.getSalCompteMembre());
               this.salaries = this.salariesDao.modif(this.salaries, var1);
               var1.flush();
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

   public void saveCompteVrtQuinzaine() throws HibernateException, NamingException {
      if (this.lesSalaries.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviPaye");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);

            for(int var3 = 0; var3 < this.lesSalaries.size(); ++var3) {
               this.salaries = (Salaries)this.lesSalaries.get(var3);
               this.salaries = this.salariesDao.modif(this.salaries, var1);
               var1.flush();
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

   public void recopieCompteVrtPreparation() throws HibernateException, NamingException {
      if (this.lesCompteVrt.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);

            for(int var3 = 0; var3 < this.lesCompteVrt.size(); ++var3) {
               this.salariesElements = (SalariesElements)this.lesCompteVrt.get(var3);
               this.salaries = this.salariesElements.getSalaries();
               this.salariesElements.setSaleleModeReglement(this.salaries.getSalModeReglement());
               this.salariesElements.setSaleleNumBanque(this.salaries.getSalNumBanque());
               this.salariesElements.setSaleleGuichetBanque(this.salaries.getSalGuichetBanque());
               this.salariesElements.setSaleleCompteBanque(this.salaries.getSalCompteBanque());
               this.salariesElements.setSaleleCleBanque(this.salaries.getSalCleBanque());
               this.salariesElements.setSaleleIban(this.salaries.getSalIban());
               this.salariesElements.setSaleleSwift(this.salaries.getSalSwift());
               this.salariesElements.setSaleleCompteMembre(this.salaries.getSalCompteMembre());
               this.salariesElements.setSaleleDateModif(new Date());
               this.salariesElements.setSaleleUserModif(this.usersLog.getUsrid());
               this.salariesElements = this.salariesElementsDao.modif(this.salariesElements, var1);
               var1.flush();
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

   public void selectionJournalier() throws IOException, SQLException, HibernateException, NamingException {
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

         this.salariesElements = (SalariesElements)var1.get(0);
         this.salaries = this.salariesElements.getSalaries();
         this.afficheNomJf();
         this.var_affiche_bouton = true;
         this.var_nature_agent = this.salaries.getLib_nature();
         this.var_agent_rec = "";
      }

   }

   public void visualisationJournalier() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      if (this.salariesElements != null) {
         this.saisieVariablesJournaliers();
      }

   }

   public void rechercheJournaliers() throws HibernateException, NamingException {
      this.var_service_rec = "";
      this.lesSalaries.clear();
      this.lesSalaries = this.salariesDao.chargerlesSalariesbyFeuille(this.bulletinMois.getBulmenFeuille(), this.var_service_rec, (Session)null);
      this.datamodelSalaries.setWrappedData(this.lesSalaries);
      this.showModalPanelSalaries = true;
   }

   public void fermerRechercheJournalier() {
      this.showModalPanelSalaries = false;
   }

   public void validerRechercheJournalier() {
      if (this.lesSalaries.size() != 0) {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.lesSalaries.size(); ++var2) {
            this.salaries = (Salaries)this.lesSalaries.get(var2);
            if (this.salaries.isSelect_agent()) {
               if (this.lesElements.size() == 0) {
                  this.salariesElements = new SalariesElements();
                  this.salariesElements.setSalaries(this.salaries);
                  this.lesElements.add(this.salariesElements);
               } else {
                  var1 = true;

                  for(int var3 = 0; var3 < this.lesElements.size(); ++var3) {
                     if (((SalariesElements)this.lesElements.get(var3)).getSalaries().getSalId() == this.salaries.getSalId()) {
                        var1 = false;
                        break;
                     }
                  }
               }

               if (var1) {
                  this.salariesElements = new SalariesElements();
                  this.salariesElements.setSalaries(this.salaries);
                  this.lesElements.add(this.salariesElements);
               }
            }
         }
      }

      this.dataModelLesElements.setWrappedData(this.lesElements);
      this.showModalPanelSalaries = false;
   }

   public void ajouterJournaliers() {
      if (this.calculChrono != null) {
         this.salaries = new Salaries();
         String[] var1 = this.feuilleCalcul.getFeuNature().split(":");
         this.var_nature_agent = this.feuilleCalcul.getFeuNature();
         this.salaries.setSalNature(var1[0]);
         this.salaries.setSalFeuille(this.bulletinMois.getBulmenFeuille());
         this.var_convention = "";
         this.var_grille = "";
         this.showModalPanelJournalier = true;
      }

   }

   public void fermerJournaliers() {
      this.showModalPanelJournalier = false;
   }

   public void validerJournaliers() throws HibernateException, NamingException {
      this.var_classement = "40:PERSONNELS TEMPORAIRES";
      String[] var1;
      if (this.var_classement != null && this.var_classement.contains(":")) {
         var1 = this.var_classement.split(":");
         this.salaries.setSalClassement(var1[0]);
         this.salaries.setSalLibClassement(var1[1]);
      } else {
         this.salaries.setSalClassement("");
         this.salaries.setSalLibClassement("");
      }

      if (this.var_centre != null && this.var_centre.contains(":")) {
         var1 = this.var_centre.split(":");
         this.salaries.setSalCentresImpots(var1[0]);
         this.salaries.setSalLibCentresImpots(var1[1]);
      } else {
         this.salaries.setSalCentresImpots("");
         this.salaries.setSalLibCentresImpots("");
      }

      if (this.var_convention != null && !this.var_convention.isEmpty() && this.var_convention.contains(":")) {
         var1 = this.var_convention.split(":");
         this.salaries.setSalConvention(var1[0]);
         this.salaries.setSalLibConvention(var1[1]);
      }

      if (this.var_grille != null && !this.var_grille.isEmpty() && this.var_grille.contains(":")) {
         var1 = this.var_grille.split(":");
         this.salaries.setSalGrille(var1[0]);
         this.salaries.setSalLibGrille(var1[1]);
      }

      if (this.salaries.getSalId() == 0L) {
         this.salaries.setExercicesPaye(this.exercicesPaye);
         this.salaries.setSalDateCreat(new Date());
         this.salaries.setSalUserCreat(this.usersLog.getUsrid());
         String var2 = this.calculChrono.matriculeCompose(this.salaries.getSalDateCreat(), 81, this.salaries.getSalNature(), (Session)null);
         this.salaries.setSalMatricule(var2);
         this.salaries = this.salariesDao.insert(this.salaries);
         this.salariesElements = new SalariesElements();
         this.salariesElements.setEffectue(false);
         this.salariesElements.setSaleleClassement(this.salaries.getSalClassement());
         this.salariesElements.setSaleleCentresImpots(this.salaries.getSalCentresImpots());
         this.salariesElements.setSaleleConvention(this.salaries.getSalConvention());
         this.salariesElements.setSaleleGrille(this.salaries.getSalGrille());
         this.salariesElements.setSalaries(this.salaries);
         this.lesElements.add(this.salariesElements);
         this.dataModelLesElements.setWrappedData(this.lesElements);
      } else {
         this.salaries.setSalDateModif(new Date());
         this.salaries.setSalUserModif(this.usersLog.getUsrid());
         this.salaries = this.salariesDao.modif(this.salaries);
         this.salariesElements.setSalaries(this.salaries);
      }

      this.showModalPanelJournalier = false;
   }

   public void saisieVariablesJournaliers() throws HibernateException, NamingException, ParseException {
      if (this.salaries != null && this.salaries.getSalFeuille() != null && !this.salaries.getSalFeuille().isEmpty()) {
         if (this.salaries.getSalEtat() == 9) {
            this.gestionNettoyageJournalier();
         } else {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            this.salariesCapitalisation = null;
            this.salariesContrats = null;
            this.gestionElementsJournaliers(var1);
            this.gestionRubriquesJournaliers(var1);
            this.utilInitHibernate.closeSession();
            this.showModalPanelVariable = true;
         }
      }

   }

   public void gestionNettoyageJournalier() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.lesVariables = this.salariesVariablesDao.chargerlesVariablesDate(this.salaries, this.bulletinMois.getBulmenJour(), var1);
         if (this.lesVariables.size() != 0) {
            for(int var3 = 0; var3 < this.lesVariables.size(); ++var3) {
               this.salariesVariables = (SalariesVariables)this.lesVariables.get(var3);
               this.salariesVariablesDao.delete(this.salariesVariables, var1);
            }
         }

         this.salariesElements = this.salariesElementsDao.chargerlesVariablesDate(this.salaries, this.bulletinMois.getBulmenJour(), var1);
         if (this.salariesElements != null) {
            this.salariesElementsDao.delete(this.salariesElements, var1);
         }

         this.salariesContrats.setEffectue(false);
         this.dataModelContrats.setWrappedData(this.lesContrats);
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

   public void gestionElementsJournaliers(Session var1) throws HibernateException, NamingException {
      if (this.salariesContrats == null) {
         this.salariesElements = this.salariesElementsDao.chargerlesVariablesDate(this.salaries, this.bulletinMois.getBulmenJour(), var1);
         if (this.salariesElements == null) {
            this.salariesElements = new SalariesElements();
            this.salariesElements.setSalaries(this.salaries);
            this.salariesElements.setSaleleJour(this.bulletinMois.getBulmenJour());
            this.salariesElements.setSaleleActivite(this.salaries.getSalActivite());
            this.salariesElements.setSaleleBudget(this.salaries.getSalBudget());
            this.salariesElements.setSaleleCivilite(this.salaries.getSalCivilite());
            this.salariesElements.setSaleleCle1Anal(this.salaries.getSalCleAnal1());
            this.salariesElements.setSaleleCle2Anal(this.salaries.getSalCleAnal2());
            this.salariesElements.setSaleleDateConcubinage(this.salaries.getSalDateConcubinage());
            this.salariesElements.setSaleleDateDivorce(this.salaries.getSalDateDivorce());
            this.salariesElements.setSaleleDateMarie(this.salaries.getSalDateMarie());
            this.salariesElements.setSaleleDatePacs(this.salaries.getSalDatePacs());
            this.salariesElements.setSaleleDateVeuf(this.salaries.getSalDateVeuf());
            this.salariesElements.setSaleleDepartement(this.salaries.getSalDepartement());
            this.salariesElements.setSaleleEtat(this.salaries.getSalEtat());
            this.salariesElements.setSaleleFeuille(this.salaries.getSalFeuille());
            this.salariesElements.setSaleleFonction(this.salaries.getSalFonction());
            this.salariesElements.setSaleleDureeJour(this.salaries.getSalDureeJour());
            this.salariesElements.setSaleleGenre(this.salaries.getSalGenre());
            this.salariesElements.setSaleleLibCle1Anal(this.salaries.getSalLibCleAnal1());
            this.salariesElements.setSaleleLibCle2Anal(this.salaries.getSalLibCleAnal2());
            this.salariesElements.setSaleleMatricule(this.salaries.getSalMatricule());
            this.salariesElements.setSaleleNature(this.salaries.getSalNature());
            this.salariesElements.setSaleleNbEnfant(this.salaries.getSalNbEnfant());
            this.salariesElements.setSaleleNbFemme(this.salaries.getSalNbFemme());
            this.salariesElements.setSaleleNbJourCp(this.salaries.getSalNbJourCp());
            this.salariesElements.setSaleleNbJourTr(this.salaries.getSalNbJourTr());
            this.salariesElements.setSaleleNbPartFiscal(this.salaries.getSalNbPartFiscal());
            this.salariesElements.setSaleleNbPartTrimf(this.salaries.getSalNbPartTrimf());
            this.salariesElements.setSaleleParc(this.salaries.getSalParc());
            this.salariesElements.setSaleleService(this.salaries.getSalService());
            this.salariesElements.setSaleleLibService(this.salaries.getSalLibService());
            this.salariesElements.setSaleleSitFamille(this.salaries.getSalSitFamille());
            this.salariesElements.setSaleleSite(this.salaries.getSalSite());
            this.salariesElements.setSaleleDateSortie(this.salaries.getSalDateSortie());
            this.salariesElements.setSaleleMotifSortie(this.salaries.getSalMotifSortie());
            this.salariesElements.setSaleleModeReglement(this.salaries.getSalModeReglement());
            this.salariesElements.setSaleleNumBanque(this.salaries.getSalNumBanque());
            this.salariesElements.setSaleleGuichetBanque(this.salaries.getSalGuichetBanque());
            this.salariesElements.setSaleleCompteBanque(this.salaries.getSalCompteBanque());
            this.salariesElements.setSaleleCleBanque(this.salaries.getSalCleBanque());
            this.salariesElements.setSaleleIban(this.salaries.getSalIban());
            this.salariesElements.setSaleleSwift(this.salaries.getSalSwift());
            this.salariesElements.setSaleleCompteMembre(this.salaries.getSalCompteMembre());
            this.salariesElements.setSaleleContrat("");
            this.salariesElements.setSaleleConvention(this.salaries.getSalConvention());
            this.salariesElements.setSaleleGrille(this.salaries.getSalGrille());
            this.salariesElements.setSaleleClassement(this.salaries.getSalClassement());
            this.salariesElements.setSaleleCentresImpots(this.salaries.getSalCentresImpots());
            this.salariesElements.setSaleleCentresSecurite(this.salaries.getSalCentresSecurite());
            this.salariesElements.setSaleleNivEmploi(this.salaries.getSalNivEmploi());
            this.salariesElements.setSaleleLibCentresImpots(this.salaries.getSalLibCentresImpots());
            this.salariesElements.setSaleleLibCentresSecurite(this.salaries.getSalLibCentresSecurite());
            this.salariesElements.setSaleleLibClassement(this.salaries.getSalLibClassement());
            this.salariesElements.setSaleleLibNivEmploi(this.salaries.getSalLibNivEmploi());
            this.salariesElements.setSaleleLibConvention(this.salaries.getSalLibConvention());
            this.salariesElements.setSaleleLibGrille(this.salaries.getSalLibGrille());
            this.salariesElements.setSaleleDateEntree(this.bulletinMois.getBulmenJour());
            this.salariesElements.setSaleleDateSortie(this.bulletinMois.getBulmenJour());
         }

         if (this.salaries.getSalNature() != null && !this.salaries.getSalNature().isEmpty()) {
            if (!this.salaries.getSalNature().equals("13") && !this.salaries.getSalNature().equals("14")) {
               if (this.salariesElements.getSaleleNivEmploi() != null && !this.salariesElements.getSaleleNivEmploi().isEmpty()) {
                  this.var_niveau = this.salariesElements.getSaleleNivEmploi() + ":" + this.salariesElements.getSaleleLibNivEmploi();
               } else {
                  this.var_niveau = "";
               }

               if (this.salariesElements.getSaleleClassement() != null && !this.salariesElements.getSaleleClassement().isEmpty()) {
                  this.var_classement = this.salariesElements.getSaleleClassement() + ":" + this.salariesElements.getSaleleLibClassement();
               } else {
                  this.var_classement = "";
               }

               if (this.salariesElements.getSaleleCentresImpots() != null && !this.salariesElements.getSaleleCentresImpots().isEmpty()) {
                  this.var_centre = this.salariesElements.getSaleleCentresImpots() + ":" + this.salariesElements.getSaleleLibCentresImpots();
               } else {
                  this.var_centre = "";
               }

               if (this.salariesElements.getSaleleCentresSecurite() != null && !this.salariesElements.getSaleleCentresSecurite().isEmpty()) {
                  this.var_securite = this.salariesElements.getSaleleCentresSecurite();
               } else {
                  this.var_securite = "";
               }

               if (this.salariesElements.getSaleleConvention() != null && !this.salariesElements.getSaleleConvention().isEmpty()) {
                  this.var_convention = this.salariesElements.getSaleleConvention() + ":" + this.salariesElements.getSaleleLibConvention();
               } else {
                  this.var_convention = "";
               }

               if (this.salariesElements.getSaleleGrille() != null && !this.salariesElements.getSaleleGrille().isEmpty()) {
                  this.var_grille = this.salariesElements.getSaleleGrille() + ":" + this.salariesElements.getSaleleLibGrille();
               } else {
                  this.var_grille = "";
               }

               this.chargerGrille();
            } else {
               this.var_niveau = "";
               this.var_classement = "";
               this.var_centre = "";
               this.var_convention = "";
               this.var_grille = "";
               this.var_securite = "";
            }
         } else {
            this.var_niveau = "";
            this.var_classement = "";
            this.var_centre = "";
            this.var_convention = "";
            this.var_grille = "";
            this.var_securite = "";
         }

         this.var_cle1 = this.salariesElements.getSaleleCle1Anal();
         this.var_cle2 = this.salariesElements.getSaleleCle2Anal();
         this.var_activite = this.salariesElements.getSaleleActivite();
         this.var_service = this.salariesElements.getSaleleService();
      }

   }

   public void gestionRubriquesJournaliers(Session var1) throws HibernateException, NamingException {
      this.lesVariables.clear();
      this.lesRubriques.clear();
      String var2 = "" + this.salaries.getSalFeuille();
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();
      this.feuilleCalcul = this.feuilleCalculDao.chercherCode(var2, this.exercicesPaye.getExepayId(), var1);
      if (this.feuilleCalcul != null) {
         this.lesRubriques = this.feuilleCalculRubriqueDao.chargerRubriqueFeuille(this.feuilleCalcul, var1);
         this.lesVariables = this.salariesVariablesDao.chargerlesVariablesDate(this.salaries, this.bulletinMois.getBulmenJour(), var1);
         int var6;
         boolean var7;
         int var8;
         if (this.lesRubriques.size() != 0) {
            new FeuilleCalculRubrique();

            for(var6 = 0; var6 < this.lesRubriques.size(); ++var6) {
               FeuilleCalculRubrique var5 = (FeuilleCalculRubrique)this.lesRubriques.get(var6);
               if (var5.isFeurubVariableA() || var5.isFeurubVariableB() || var5.isFeurubVariableC() || var5.isFeurubVariableD() || var5.isFeurubVariableE()) {
                  if (this.lesVariables.size() == 0) {
                     this.salariesVariables = new SalariesVariables();
                     this.salariesVariables.setSalaries(this.salaries);
                     this.salariesVariables.setPlanPaye(var5.getPlanPaye());
                     this.salariesVariables.setSalvarContrat("");
                     this.salariesVariables.setSalvarCode(var5.getFeurubCode());
                     this.salariesVariables.setSalvarPeriode(this.bulletinMois.getBulmenPeriode());
                     this.salariesVariables.setSalvarFeuille(this.bulletinMois.getBulmenFeuille());
                     this.salariesVariables.setSalvarVariableA(var5.isFeurubVariableA());
                     this.salariesVariables.setSalvarVariableB(var5.isFeurubVariableB());
                     this.salariesVariables.setSalvarVariableC(var5.isFeurubVariableC());
                     this.salariesVariables.setSalvarVariableD(var5.isFeurubVariableD());
                     this.nbHeuredefaut();
                     this.salariesVariables.setSalvarVariableE(var5.isFeurubVariableE());
                     this.lesVariables.add(this.salariesVariables);
                  } else {
                     var7 = false;

                     for(var8 = 0; var8 < this.lesVariables.size(); ++var8) {
                        this.salariesVariables = (SalariesVariables)this.lesVariables.get(var8);
                        if (this.salariesVariables.getSalvarCode().equals(var5.getFeurubCode())) {
                           this.salariesVariables.setSalvarVariableA(var5.isFeurubVariableA());
                           this.salariesVariables.setSalvarVariableB(var5.isFeurubVariableB());
                           this.salariesVariables.setSalvarVariableC(var5.isFeurubVariableC());
                           this.salariesVariables.setSalvarVariableD(var5.isFeurubVariableD());
                           this.salariesVariables.setSalvarVariableE(var5.isFeurubVariableE());
                           var7 = true;
                           break;
                        }
                     }

                     if (!var7) {
                        this.salariesVariables = new SalariesVariables();
                        this.salariesVariables.setSalaries(this.salaries);
                        this.salariesVariables.setPlanPaye(var5.getPlanPaye());
                        this.salariesVariables.setSalvarContrat("");
                        this.salariesVariables.setSalvarCode(var5.getFeurubCode());
                        this.salariesVariables.setSalvarPeriode(this.bulletinMois.getBulmenPeriode());
                        this.salariesVariables.setSalvarFeuille(this.bulletinMois.getBulmenFeuille());
                        this.salariesVariables.setSalvarVariableA(var5.isFeurubVariableA());
                        this.salariesVariables.setSalvarVariableB(var5.isFeurubVariableB());
                        this.salariesVariables.setSalvarVariableC(var5.isFeurubVariableC());
                        this.salariesVariables.setSalvarVariableD(var5.isFeurubVariableD());
                        this.nbHeuredefaut();
                        this.salariesVariables.setSalvarVariableE(var5.isFeurubVariableE());
                        this.lesVariables.add(this.salariesVariables);
                     }
                  }
               }
            }
         }

         if (this.lesVariables.size() != 0) {
            new SalariesVariables();
            var6 = 0;

            label115:
            while(true) {
               SalariesVariables var14;
               if (var6 >= this.lesVariables.size()) {
                  if (var3.size() == 0) {
                     break;
                  }

                  var6 = 0;

                  while(true) {
                     if (var6 >= var3.size()) {
                        break label115;
                     }

                     var14 = (SalariesVariables)var3.get(var6);
                     var14 = this.salariesVariablesDao.pourParapheur(((SalariesVariables)var3.get(var6)).getSalvarId(), var1);
                     if (var14 != null) {
                        this.salariesVariablesDao.delete(var14, var1);
                     }

                     ++var6;
                  }
               }

               var14 = (SalariesVariables)this.lesVariables.get(var6);
               if (this.lesRubriques.size() == 0) {
                  var4.add(var14);
               } else {
                  var7 = false;

                  for(var8 = 0; var8 < this.lesRubriques.size(); ++var8) {
                     if (((FeuilleCalculRubrique)this.lesRubriques.get(var8)).getFeurubCode().equals(var14.getSalvarCode())) {
                        boolean var9 = false;
                        if (((FeuilleCalculRubrique)this.lesRubriques.get(var8)).isFeurubColA() && ((FeuilleCalculRubrique)this.lesRubriques.get(var8)).isFeurubVariableA()) {
                           var9 = true;
                        }

                        boolean var10 = false;
                        if (((FeuilleCalculRubrique)this.lesRubriques.get(var8)).isFeurubColB() && ((FeuilleCalculRubrique)this.lesRubriques.get(var8)).isFeurubVariableB()) {
                           var10 = true;
                        }

                        boolean var11 = false;
                        if (((FeuilleCalculRubrique)this.lesRubriques.get(var8)).isFeurubColC() && ((FeuilleCalculRubrique)this.lesRubriques.get(var8)).isFeurubVariableC()) {
                           var11 = true;
                        }

                        boolean var12 = false;
                        if (((FeuilleCalculRubrique)this.lesRubriques.get(var8)).isFeurubColD() && ((FeuilleCalculRubrique)this.lesRubriques.get(var8)).isFeurubVariableD()) {
                           var12 = true;
                        }

                        boolean var13 = false;
                        if (((FeuilleCalculRubrique)this.lesRubriques.get(var8)).isFeurubColE() && ((FeuilleCalculRubrique)this.lesRubriques.get(var8)).isFeurubVariableE()) {
                           var13 = true;
                        }

                        if (!var9 && !var10 && !var11 && !var12 && !var13) {
                           var7 = false;
                        } else {
                           var7 = true;
                        }
                        break;
                     }
                  }

                  if (!var7) {
                     var3.add(var14);
                  } else {
                     var4.add(var14);
                  }
               }

               ++var6;
            }
         }

         this.dataModelVariables.setWrappedData(var4);
      }

   }

   public void nbHeuredefaut() {
      if (this.salariesVariables.isSalvarVariableD() && this.salariesVariables.getSalvarCode() != null && !this.salariesVariables.getSalvarCode().isEmpty() && this.salariesVariables.getSalvarCode().equals("100010")) {
         if (this.salariesElements.getSaleleDureeJour() == 0) {
            this.salariesVariables.setSalvarValeurColD(this.optionPaye.getHeurejournee());
         } else if (this.salariesElements.getSaleleDureeJour() == 1) {
            this.salariesVariables.setSalvarValeurColD(this.optionPaye.getHeuredemijournee());
         } else if (this.salariesElements.getSaleleDureeJour() == 2) {
         }
      }

   }

   public void saveVariablesJournaliers() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         var1.setFlushMode(FlushMode.MANUAL);
         int var3;
         if (this.lesVariables.size() != 0) {
            for(var3 = 0; var3 < this.lesVariables.size(); ++var3) {
               this.salariesVariables = (SalariesVariables)this.lesVariables.get(var3);
               this.salariesVariables.setSalaries(this.salaries);
               this.salariesVariables.setSalvarFeuille(this.bulletinMois.getBulmenFeuille());
               this.salariesVariables.setSalvarPeriode((String)null);
               this.salariesVariables.setSalvarJour(this.bulletinMois.getBulmenJour());
               if (this.salariesVariables.getSalvarId() == 0L) {
                  this.salariesVariables = this.salariesVariablesDao.insert(this.salariesVariables, var1);
               } else {
                  this.salariesVariables = this.salariesVariablesDao.modif(this.salariesVariables, var1);
               }

               var1.flush();
            }
         }

         if (this.salariesElements != null) {
            String[] var10;
            if (this.var_niveau != null && !this.var_niveau.isEmpty() && this.var_niveau.contains(":")) {
               var10 = this.var_niveau.split(":");
               this.salariesElements.setSaleleNivEmploi(var10[0]);
               this.salariesElements.setSaleleLibNivEmploi(var10[1]);
            } else {
               this.salariesElements.setSaleleNivEmploi("");
               this.salariesElements.setSaleleLibNivEmploi("");
            }

            if (this.var_classement != null && !this.var_classement.isEmpty() && this.var_classement.contains(":")) {
               var10 = this.var_classement.split(":");
               this.salariesElements.setSaleleClassement(var10[0]);
               this.salariesElements.setSaleleLibClassement(var10[1]);
            } else {
               this.salariesElements.setSaleleClassement("");
               this.salariesElements.setSaleleLibClassement("");
            }

            if (this.var_centre != null && !this.var_centre.isEmpty() && this.var_centre.contains(":")) {
               var10 = this.var_centre.split(":");
               this.salariesElements.setSaleleCentresImpots(var10[0]);
               this.salariesElements.setSaleleLibCentresImpots(var10[1]);
            } else {
               this.salariesElements.setSaleleCentresImpots("");
               this.salariesElements.setSaleleLibCentresImpots("");
            }

            if (this.var_securite != null && !this.var_securite.isEmpty()) {
               this.salariesElements.setSaleleCentresSecurite(this.var_securite);
               if (this.mesCentresSecuritesItems.size() != 0) {
                  for(var3 = 0; var3 < this.mesCentresSecuritesItems.size(); ++var3) {
                     if (((SelectItem)this.mesCentresSecuritesItems.get(var3)).getValue().toString().equals(this.var_securite)) {
                        String[] var4 = ((SelectItem)this.mesCentresSecuritesItems.get(var3)).getLabel().toString().split(":");
                        this.salariesElements.setSaleleLibCentresSecurite(var4[0]);
                        break;
                     }
                  }
               }
            } else {
               this.salariesElements.setSaleleCentresSecurite("");
               this.salariesElements.setSaleleLibCentresSecurite("");
            }

            if (this.var_convention != null && !this.var_convention.isEmpty() && this.var_convention.contains(":")) {
               var10 = this.var_convention.split(":");
               this.salariesElements.setSaleleConvention(var10[0]);
               this.salariesElements.setSaleleLibConvention(var10[1]);
            } else {
               this.salariesElements.setSaleleConvention("");
               this.salariesElements.setSaleleLibConvention("");
            }

            if (this.var_grille != null && !this.var_grille.isEmpty() && this.var_grille.contains(":")) {
               var10 = this.var_grille.split(":");
               this.salariesElements.setSaleleGrille(var10[0]);
               this.salariesElements.setSaleleLibGrille(var10[1]);
            } else {
               this.salariesElements.setSaleleGrille("");
               this.salariesElements.setSaleleLibGrille("");
            }

            this.salariesElements.setSaleleCle1Anal(this.var_cle1);
            this.salariesElements.setSaleleCle2Anal(this.var_cle2);
            this.salariesElements.setSaleleActivite(this.var_activite);
            this.salariesElements.setSaleleService(this.var_service);
            this.salariesElements.setSalelePeriode((String)null);
            this.salariesElements.setSaleleJour(this.bulletinMois.getBulmenJour());
            if (this.salariesElements.getSaleleId() == 0L) {
               this.salariesElements.setSalaries(this.salaries);
               this.salariesElements.setSaleleDateCreat(new Date());
               this.salariesElements.setSaleleUserCreat(this.usersLog.getUsrid());
               this.salariesElements = this.salariesElementsDao.insert(this.salariesElements, var1);
            } else {
               this.salariesElements.setSaleleDateModif(new Date());
               this.salariesElements.setSaleleUserModif(this.usersLog.getUsrid());
               this.salariesElements = this.salariesElementsDao.modif(this.salariesElements, var1);
            }

            var1.flush();
            if (this.salaries != null) {
               this.salaries.setSalActivite(this.salariesElements.getSaleleActivite());
               this.salaries.setSalBudget(this.salariesElements.getSaleleBudget());
               this.salaries.setSalCentresImpots(this.salariesElements.getSaleleCentresImpots());
               this.salaries.setSalCentresSecurite(this.salariesElements.getSaleleCentresSecurite());
               this.salaries.setSalCivilite(this.salariesElements.getSaleleCivilite());
               this.salaries.setSalClassement(this.salariesElements.getSaleleClassement());
               this.salaries.setSalCleAnal1(this.salariesElements.getSaleleCle1Anal());
               this.salaries.setSalCleAnal2(this.salariesElements.getSaleleCle2Anal());
               this.salaries.setSalConvention(this.salariesElements.getSaleleConvention());
               this.salaries.setSalDateConcubinage(this.salariesElements.getSaleleDateConcubinage());
               this.salaries.setSalDateDivorce(this.salariesElements.getSaleleDateDivorce());
               this.salaries.setSalDateMarie(this.salariesElements.getSaleleDateMarie());
               this.salaries.setSalDatePacs(this.salariesElements.getSaleleDatePacs());
               this.salaries.setSalDateVeuf(this.salariesElements.getSaleleDateVeuf());
               this.salaries.setSalDepartement(this.salariesElements.getSaleleDepartement());
               if (this.salariesElements.getSaleleEtat() != 9) {
                  this.salaries.setSalEtat(this.salariesElements.getSaleleEtat());
               }

               this.salaries.setSalFeuille(this.salariesElements.getSaleleFeuille());
               this.salaries.setSalFonction(this.salariesElements.getSaleleFonction());
               this.salaries.setSalDureeJour(this.salariesElements.getSaleleDureeJour());
               this.salaries.setSalGenre(this.salariesElements.getSaleleGenre());
               this.salaries.setSalGrille(this.salariesElements.getSaleleGrille());
               this.salaries.setSalLibCentresImpots(this.salariesElements.getSaleleLibCentresImpots());
               this.salaries.setSalLibCentresSecurite(this.salariesElements.getSaleleLibCentresSecurite());
               this.salaries.setSalLibClassement(this.salariesElements.getSaleleLibClassement());
               this.salaries.setSalLibCleAnal1(this.salariesElements.getSaleleLibCle1Anal());
               this.salaries.setSalLibCleAnal2(this.salariesElements.getSaleleLibCle2Anal());
               this.salaries.setSalLibConvention(this.salariesElements.getSaleleLibConvention());
               this.salaries.setSalLibGrille(this.salariesElements.getSaleleLibGrille());
               this.salaries.setSalLibNivEmploi(this.salariesElements.getSaleleLibNivEmploi());
               this.salaries.setSalMatricule(this.salariesElements.getSaleleMatricule());
               this.salaries.setSalNature(this.salariesElements.getSaleleNature());
               this.salaries.setSalNbEnfant(this.salariesElements.getSaleleNbEnfant());
               this.salaries.setSalNbFemme(this.salariesElements.getSaleleNbFemme());
               this.salaries.setSalNbJourCp(this.salariesElements.getSaleleNbJourCp());
               this.salaries.setSalNbJourTr(this.salariesElements.getSaleleNbJourTr());
               this.salaries.setSalNbPartFiscal(this.salariesElements.getSaleleNbPartFiscal());
               this.salaries.setSalNbPartTrimf(this.salariesElements.getSaleleNbPartTrimf());
               this.salaries.setSalNivEmploi(this.salariesElements.getSaleleNivEmploi());
               this.salaries.setSalParc(this.salariesElements.getSaleleParc());
               this.salaries.setSalService(this.salariesElements.getSaleleService());
               this.salaries.setSalLibService(this.salariesElements.getSaleleLibService());
               this.salaries.setSalSitFamille(this.salariesElements.getSaleleSitFamille());
               this.salaries.setSalSite(this.salariesElements.getSaleleSite());
               this.salaries.setSalDateEntree(this.salariesElements.getSaleleDateEntree());
               this.salaries.setSalDateSortie(this.salariesElements.getSaleleDateSortie());
               this.salaries.setSalMotifSortie(this.salariesElements.getSaleleMotifSortie());
               this.salaries.setSalModeReglement(this.salariesElements.getSaleleModeReglement());
               if (this.salariesElements.getSaleleCompteBanque() != null && !this.salariesElements.getSaleleCompteBanque().isEmpty()) {
                  this.salaries.setSalNumBanque(this.salariesElements.getSaleleNumBanque());
                  this.salaries.setSalGuichetBanque(this.salariesElements.getSaleleGuichetBanque());
                  this.salaries.setSalCompteBanque(this.salariesElements.getSaleleCompteBanque());
                  this.salaries.setSalCleBanque(this.salariesElements.getSaleleCleBanque());
                  this.salaries.setSalIban(this.salariesElements.getSaleleIban());
                  this.salaries.setSalSwift(this.salariesElements.getSaleleSwift());
                  this.salaries.setSalCompteMembre(this.salariesElements.getSaleleCompteMembre());
               }

               this.salaries = this.salariesDao.modif(this.salaries, var1);
               var1.flush();
            }

            if (this.salariesElements != null) {
               this.salariesElements.setEffectue(true);
            } else {
               this.salariesElements.setEffectue(false);
            }
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

      this.showModalPanelVariable = false;
   }

   public void gelerImputationJournalier() throws HibernateException, NamingException {
      if (this.salariesElements != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.salaries.setSalEtat(9);
            this.salariesDao.modif(this.salaries, var1);
            this.salariesElements.setSaleleEtat(9);
            this.salariesElements = this.salariesElementsDao.modif(this.salariesElements, var1);
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

   public void degelerImputationJournalier() throws HibernateException, NamingException {
      if (this.salariesElements != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.salaries.setSalEtat(0);
            this.salariesDao.modif(this.salaries, var1);
            this.salariesElements.setSaleleEtat(0);
            this.salariesElements = this.salariesElementsDao.modif(this.salariesElements, var1);
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

   public void envoiSmsZ1() {
      if (this.salaries.getSalCel1() != null && !this.salaries.getSalCel1().isEmpty()) {
         this.numeroMobile = this.salaries.getSalCel1();
         this.messageSms = "";
         this.showModalPanelSms = true;
      }

   }

   public void envoiSmsZ2() {
      if (this.salaries.getSalCel2() != null && !this.salaries.getSalCel2().isEmpty()) {
         this.numeroMobile = this.salaries.getSalCel2();
         this.messageSms = "";
         this.showModalPanelSms = true;
      }

   }

   public void envoiSmsZ3() {
      if (this.salaries.getSalCel3() != null && !this.salaries.getSalCel3().isEmpty()) {
         this.numeroMobile = this.salaries.getSalCel3();
         this.messageSms = "";
         this.showModalPanelSms = true;
      }

   }

   public void fermerSms() {
      this.showModalPanelSms = false;
   }

   public void valideEnvoiSms() throws IOException, HibernateException, NamingException, SQLException {
      UtilSms var1 = new UtilSms(this.utilInitHibernate, this.structureLog, this.usersLog, this.baseLog);
      var1.sendSmsOne(this.messageSms, this.numeroMobile, this.salaries.getPatronyme(), this.salaries.getSalCivilite(), this.salaries.getSalId(), (String)null, 0L, 2);
      this.showModalPanelSms = false;
   }

   public void historiqueSalarie() throws HibernateException, NamingException {
      if (this.salaries != null) {
         this.bulletinSalaire = new BulletinSalaire();
         this.bulletinSalaireDao = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
         this.bulletinSalaire = this.bulletinSalaireDao.rechercheBulletinSalarieDernier(this.salaries.getSalMatricule(), (Session)null);
         if (this.bulletinSalaire != null) {
            this.formBakingBeanPaye.historiqueRubrique(this.bulletinSalaire);
         }
      }

   }

   public void historiqueSalarieBulletin() throws HibernateException, NamingException {
      if (this.salaries != null) {
         this.bulletinSalaire = new BulletinSalaire();
         this.bulletinSalaireDao = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
         this.bulletinSalaire = this.bulletinSalaireDao.rechercheBulletinSalarieDernier(this.salaries.getSalMatricule(), (Session)null);
         if (this.bulletinSalaire != null) {
            this.historiqueBulletin();
         }
      }

   }

   public void historiqueBulletin() throws HibernateException, NamingException {
      if (this.bulletinSalaire != null) {
         this.listeBulletins = new ArrayList();
         this.dataModelListeBulletins = new ListDataModel();
         this.listeBulletins = this.bulletinSalaireDao.chargerlesBulletinsbySalarieExercice(this.bulletinSalaire.getSalaries(), this.exercicesPaye, (Session)null);
         this.dataModelListeBulletins.setWrappedData(this.listeBulletins);
         this.showModalPanelListeBulletin = true;
      }

   }

   public void selectionBulletin() {
      if (this.dataModelListeBulletins.isRowAvailable()) {
         this.bulletinSalaire = (BulletinSalaire)this.dataModelListeBulletins.getRowData();
      } else {
         this.bulletinSalaire = null;
      }

   }

   public void consulterBulletin() throws HibernateException, NamingException {
      if (this.bulletinSalaire != null) {
         this.formBakingBeanPaye.consulterBulletin(this.bulletinSalaire);
      }

   }

   public void fermerListeBulletin() {
      this.showModalPanelListeBulletin = false;
   }

   public void selectionAbsences() {
      if (this.dataModelAbsences.isRowAvailable()) {
         this.salariesAbsences = (SalariesConges)this.dataModelAbsences.getRowData();
         this.var_affiche_absences = true;
      }

   }

   public void ajouterAbsences() {
      this.salariesAbsences = new SalariesConges();
      this.salariesAbsences.setSalcngNature(12);
      this.var_action_absences = 1;
      this.showModalPanelAbsences = true;
   }

   public void modifierAbsences() {
      if (this.salariesAbsences != null) {
         this.var_action_absences = 2;
         this.showModalPanelAbsences = true;
      }

   }

   public void consulterAbsences() {
      if (this.salariesAbsences != null) {
         this.var_action_absences = 3;
         this.showModalPanelAbsences = true;
      }

   }

   public void supprimerAbsences() throws HibernateException, NamingException {
      if (this.salariesAbsences != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            this.verifHabilitation(89, var1);
            if (this.habilitation != null) {
               new Parapheur();
               ParapheurDao var4 = new ParapheurDao(this.baseLog, this.utilInitHibernate);
               Parapheur var3 = var4.existenceParapheur(this.salariesAbsences.getSalcngId(), 89, var1);
               if (var3 != null) {
                  var4.delete(var3, var1);
                  var1.flush();
               }
            }

            this.salariesCongesDao.delete(this.salariesAbsences, var1);
            var1.flush();
            this.lesSalariesAbsences.remove(this.salariesAbsences);
            this.dataModelAbsences.setWrappedData(this.lesSalariesAbsences);
            var2.commit();
         } catch (HibernateException var8) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var8;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.var_affiche_absences = false;
         this.nbJourAbs = 0.0F;
         this.nbHeureRet = 0.0F;
         if (this.lesSalariesAbsences.size() != 0) {
            for(int var10 = 0; var10 < this.lesSalariesAbsences.size(); ++var10) {
               if (((SalariesConges)this.lesSalariesAbsences.get(var10)).getSalcngNature() != 11 && ((SalariesConges)this.lesSalariesAbsences.get(var10)).getSalcngNature() != 12 && ((SalariesConges)this.lesSalariesAbsences.get(var10)).getSalcngNature() != 13) {
                  if (((SalariesConges)this.lesSalariesAbsences.get(var10)).getSalcngNature() == 14) {
                     this.nbHeureRet += ((SalariesConges)this.lesSalariesAbsences.get(var10)).getSalcngNbHeure();
                  }
               } else {
                  this.nbJourAbs += ((SalariesConges)this.lesSalariesAbsences.get(var10)).getSalcngDuree();
               }
            }
         }
      }

   }

   public void annulerAbsences() {
      this.var_affiche_absences = false;
      this.showModalPanelAbsences = false;
   }

   public void saveAbsences() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         var1.setFlushMode(FlushMode.MANUAL);
         this.salariesAbsences.setSalcngEtatVal(0);
         this.salariesAbsences.setSalcngEtat(1);
         this.salariesAbsences.setSalcngDateValide(new Date());
         this.salariesAbsences.setSalcngType(1);
         if (this.salariesAbsences.getSalcngDateDebut() != null && this.salariesAbsences.getSalcngDateFin() != null) {
            float var3 = 0.0F;
            var3 = (float)((this.salariesAbsences.getSalcngDateFin().getTime() - this.salariesAbsences.getSalcngDateDebut().getTime()) / 86400000L);
            float var4;
            if (this.salariesAbsences.isSalcngAm()) {
               var4 = 0.5F;
               var3 += var4;
            }

            if (this.salariesAbsences.isSalcngPm()) {
               var4 = 0.5F;
               var3 += var4;
            }

            this.salariesAbsences.setSalcngDuree(var3);
         } else {
            this.salariesAbsences.setSalcngDuree(0.0F);
         }

         if (this.salariesAbsences.getSalcngId() == 0L) {
            this.salariesAbsences.setSalaries(this.salaries);
            this.salariesAbsences.setSalcngDateCreat(new Date());
            this.salariesAbsences.setSalcngUserCreat(this.usersLog.getUsrid());
            this.salariesAbsences = this.salariesCongesDao.insert(this.salariesAbsences, var1);
            var1.flush();
            this.lesSalariesAbsences.add(this.salariesAbsences);
            this.dataModelAbsences.setWrappedData(this.lesSalariesAbsences);
         } else {
            this.salariesAbsences.setSalcngDateModif(new Date());
            this.salariesAbsences.setSalcngUserModif(this.usersLog.getUsrid());
            this.salariesAbsences = this.salariesCongesDao.modif(this.salariesAbsences, var1);
            var1.flush();
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

      this.nbJourAbs = 0.0F;
      this.nbHeureRet = 0.0F;
      if (this.lesSalariesAbsences.size() != 0) {
         for(int var10 = 0; var10 < this.lesSalariesAbsences.size(); ++var10) {
            if (((SalariesConges)this.lesSalariesAbsences.get(var10)).getSalcngNature() != 11 && ((SalariesConges)this.lesSalariesAbsences.get(var10)).getSalcngNature() != 12 && ((SalariesConges)this.lesSalariesAbsences.get(var10)).getSalcngNature() != 13) {
               if (((SalariesConges)this.lesSalariesAbsences.get(var10)).getSalcngNature() == 14) {
                  this.nbHeureRet += ((SalariesConges)this.lesSalariesAbsences.get(var10)).getSalcngNbHeure();
               }
            } else {
               this.nbJourAbs += ((SalariesConges)this.lesSalariesAbsences.get(var10)).getSalcngDuree();
            }
         }
      }

      this.showModalPanelAbsences = false;
   }

   public void rechercheSalarie() throws JDOMException, IOException, HibernateException, NamingException {
      this.salaries = this.formRecherche.rechercheSalarie(this.nomSalarie, 810, this.exercicesPaye.getExepayId());
      if (this.salaries != null) {
         if (this.salaries.getSalId() != 0L) {
            this.calculeSalarie();
         } else {
            this.var_action = 9;
         }
      } else if (this.salaries == null) {
         this.calculeSalarie();
      }

   }

   public void recuperationSalarie() throws JDOMException, IOException, HibernateException, NamingException {
      this.salaries = this.formRecherche.calculeSalarie();
      this.calculeSalarie();
   }

   public void calculeSalarie() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.salaries != null) {
         this.nomSalarie = this.salaries.getSalMatricule() + ":" + this.salaries.getSalNom();
         new ArrayList();
         List var1 = this.salariesContratsDao.chargerlesContrats((Salaries)this.salaries, (Session)null);
         if (var1.size() != 0) {
            this.salariesContrats = (SalariesContrats)var1.get(0);
            if (this.salariesContrats.getSalconNivEmploi() != null && !this.salariesContrats.getSalconNivEmploi().isEmpty()) {
               this.var_niveau = this.salariesContrats.getSalconNivEmploi() + ":" + this.salariesContrats.getSalconLibNivEmploi();
            } else {
               this.var_niveau = "";
            }

            if (this.salariesContrats.getSalconClassement() != null && !this.salariesContrats.getSalconClassement().isEmpty()) {
               this.var_classement = this.salariesContrats.getSalconClassement() + ":" + this.salariesContrats.getSalconLibClassement();
            } else {
               this.var_classement = "";
            }

            if (this.salariesContrats.getSalconCentresImpots() != null && !this.salariesContrats.getSalconCentresImpots().isEmpty()) {
               this.var_centre = this.salariesContrats.getSalconCentresImpots() + ":" + this.salariesContrats.getSalconLibCentresImpots();
            } else {
               this.var_centre = "";
            }

            if (this.salariesContrats.getSalconCentresSecurite() != null && !this.salariesContrats.getSalconCentresSecurite().isEmpty()) {
               this.var_securite = this.salariesContrats.getSalconCentresSecurite();
            } else {
               this.var_securite = "";
            }

            if (this.salariesContrats.getSalconConvention() != null && !this.salariesContrats.getSalconConvention().isEmpty()) {
               this.var_convention = this.salariesContrats.getSalconConvention() + ":" + this.salariesContrats.getSalconLibConvention();
            } else {
               this.var_convention = "";
            }

            if (this.salariesContrats.getSalconGrille() != null && !this.salariesContrats.getSalconGrille().isEmpty()) {
               this.var_grille = this.salariesContrats.getSalconGrille() + ":" + this.salariesContrats.getSalconLibGrille();
               this.chargerGrille();
            } else {
               this.var_grille = "";
            }

            this.feuilleCalcul = this.feuilleCalculDao.chercherCode(this.salariesContrats.getSalconFeuille(), this.exercicesPaye.getExepayId(), (Session)null);
         } else {
            this.salariesContrats = null;
            this.feuilleCalcul = null;
         }
      } else {
         this.annuleSalarie();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleSalarie() {
      this.salaries = null;
      this.nomSalarie = "";
      this.var_action = this.var_memo_action;
   }

   public void toutSelectionnerBulletin() {
      if (this.lesSalaries.size() != 0) {
         for(int var1 = 0; var1 < this.lesSalaries.size(); ++var1) {
            ((Salaries)this.lesSalaries.get(var1)).setSelect_agent(true);
         }

         this.datamodelSalaries.setWrappedData(this.lesSalaries);
      }

   }

   public void toutDeselectionnerBulletin() {
      if (this.lesSalaries.size() != 0) {
         for(int var1 = 0; var1 < this.lesSalaries.size(); ++var1) {
            ((Salaries)this.lesSalaries.get(var1)).setSelect_agent(false);
         }

         this.datamodelSalaries.setWrappedData(this.lesSalaries);
      }

   }

   public void rechercheSalarieContrat() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.salariesContrats = this.formRecherche.rechercheSalarieContrat(this.nomSalarie, 820, this.exercicesPaye.getExepayId());
      if (this.salariesContrats != null) {
         if (this.salariesContrats.getSalconId() != 0L) {
            this.calculeSalarieContrat();
         } else {
            this.salariesContrats = new SalariesContrats();
            this.var_action = 10;
         }
      } else if (this.salariesContrats == null) {
         this.calculeSalarieContrat();
      }

   }

   public void recuperationSalarieContrat() throws JDOMException, IOException, HibernateException, NamingException {
      this.salariesContrats = this.formRecherche.calculeSalarieContrat();
      this.calculeSalarieContrat();
   }

   public void calculeSalarieContrat() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.salariesContrats != null) {
         this.salaries = this.salariesContrats.getSalaries();
         this.nomSalarie = this.salariesContrats.getSalaries().getSalMatricule() + ":" + this.salariesContrats.getSalaries().getSalNom();
         if (this.salariesContrats.getSalconNivEmploi() != null && !this.salariesContrats.getSalconNivEmploi().isEmpty()) {
            this.var_niveau = this.salariesContrats.getSalconNivEmploi() + ":" + this.salariesContrats.getSalconLibNivEmploi();
         } else {
            this.var_niveau = "";
         }

         if (this.salariesContrats.getSalconClassement() != null && !this.salariesContrats.getSalconClassement().isEmpty()) {
            this.var_classement = this.salariesContrats.getSalconClassement() + ":" + this.salariesContrats.getSalconLibClassement();
         } else {
            this.var_classement = "";
         }

         if (this.salariesContrats.getSalconCentresImpots() != null && !this.salariesContrats.getSalconCentresImpots().isEmpty()) {
            this.var_centre = this.salariesContrats.getSalconCentresImpots() + ":" + this.salariesContrats.getSalconLibCentresImpots();
         } else {
            this.var_centre = "";
         }

         if (this.salariesContrats.getSalconCentresSecurite() != null && !this.salariesContrats.getSalconCentresSecurite().isEmpty()) {
            this.var_securite = this.salariesContrats.getSalconCentresSecurite();
         } else {
            this.var_securite = "";
         }

         if (this.salariesContrats.getSalconConvention() != null && !this.salariesContrats.getSalconConvention().isEmpty()) {
            this.var_convention = this.salariesContrats.getSalconConvention() + ":" + this.salariesContrats.getSalconLibConvention();
         } else {
            this.var_convention = "";
         }

         if (this.salariesContrats.getSalconGrille() != null && !this.salariesContrats.getSalconGrille().isEmpty()) {
            this.var_grille = this.salariesContrats.getSalconGrille() + ":" + this.salariesContrats.getSalconLibGrille();
            this.chargerGrille();
         } else {
            this.var_grille = "";
         }

         this.feuilleCalcul = this.feuilleCalculDao.chercherCode(this.salariesContrats.getSalconFeuille(), this.exercicesPaye.getExepayId(), (Session)null);
         this.calculeRubriqueContrat((Session)null);
      } else {
         this.annuleSalarieContrat();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleSalarieContrat() {
      this.salaries = null;
      this.salariesContrats = null;
      this.nomSalarie = "";
      this.var_action = this.var_memo_action;
   }

   public void initImpression() {
      this.var_choix_modele = 0;
      this.chargerLesModelesImpresion();
      this.affMail = false;
      this.format = "PRT";
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.showModalPanelPrint = true;
   }

   public void closeImpression() {
      this.showModalPanelPrint = false;
   }

   public void initImpressionPrep() {
      if (this.lesContrats.size() != 0) {
         this.var_choix_modele = 2;
         this.chargerLesModelesImpresion();
         this.affMail = false;
         this.format = "PRT";
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
         this.showModalPanelPrintPrep = true;
      }

   }

   public void initImpressionPrepJournalier() {
      if (this.lesElements.size() != 0) {
         this.var_choix_modele = 4;
         this.chargerLesModelesImpresion();
         this.affMail = false;
         this.format = "PRT";
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
         this.showModalPanelPrintPrep = true;
      }

   }

   public void initImpressionRub() {
      if (this.lesSalariesRubriques.size() != 0) {
         this.var_choix_modele = 3;
         this.chargerLesModelesImpresion();
         this.affMail = false;
         this.format = "PRT";
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
         this.showModalPanelPrintRub = true;
      }

   }

   public void closeImpressionPrep() {
      this.showModalPanelPrintPrep = false;
   }

   public void closeImpressionRub() {
      this.showModalPanelPrintRub = false;
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

   public void chargerLesModelesImpresion() {
      String var1;
      File var2;
      String[] var3;
      int var4;
      String var5;
      int var6;
      if (this.var_choix_modele == 0) {
         this.documentImpressionItems.clear();
         if (this.feuilleCalcul.getFeuModele() != null && !this.feuilleCalcul.getFeuModele().isEmpty()) {
            this.documentImpressionItems.add(new SelectItem(this.feuilleCalcul.getFeuModele()));
         } else {
            var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "bulletin";
            var2 = new File(var1);
            if (!var2.exists()) {
               var2.mkdir();
            }

            var3 = var2.list();
            if (var3 != null) {
               var3 = this.triAlphabetique(var3, var3.length);

               for(var4 = 0; var4 < var3.length; ++var4) {
                  var5 = var3[var4];
                  if (var5.endsWith("jasper")) {
                     var6 = var5.indexOf(".");
                     var5 = var5.substring(0, var6);
                     this.documentImpressionItems.add(new SelectItem(var5));
                  }
               }
            }
         }
      } else if (this.var_choix_modele == 1) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "salarie" + File.separator + "01-mensuel";
         var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         this.listeImpressionItems.clear();
         var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(var4 = 0; var4 < var3.length; ++var4) {
               var5 = var3[var4];
               if (var5.endsWith("jasper")) {
                  var6 = var5.indexOf(".");
                  var5 = var5.substring(0, var6);
                  this.listeImpressionItems.add(new SelectItem(var5));
               }
            }
         }
      } else if (this.var_choix_modele == 2) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "preparation";
         var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         this.listeImpressionItems.clear();
         var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(var4 = 0; var4 < var3.length; ++var4) {
               var5 = var3[var4];
               if (var5.endsWith("jasper")) {
                  var6 = var5.indexOf(".");
                  var5 = var5.substring(0, var6);
                  this.listeImpressionItems.add(new SelectItem(var5));
               }
            }
         }
      } else if (this.var_choix_modele == 3) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "rubrique";
         var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         this.listeImpressionItems.clear();
         var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(var4 = 0; var4 < var3.length; ++var4) {
               var5 = var3[var4];
               if (var5.endsWith("jasper")) {
                  var6 = var5.indexOf(".");
                  var5 = var5.substring(0, var6);
                  this.listeImpressionItems.add(new SelectItem(var5));
               }
            }
         }
      } else if (this.var_choix_modele == 4) {
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "preparationJournalier";
         var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         this.listeImpressionItems.clear();
         var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(var4 = 0; var4 < var3.length; ++var4) {
               var5 = var3[var4];
               if (var5.endsWith("jasper")) {
                  var6 = var5.indexOf(".");
                  var5 = var5.substring(0, var6);
                  this.listeImpressionItems.add(new SelectItem(var5));
               }
            }
         }
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
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && this.impDestinataire != null && !this.impDestinataire.isEmpty()) {
         this.format = "MAIL";
         this.imprimer();
      }

   }

   public void envoieMAIL() throws SQLException, JRException, IOException, HibernateException, NamingException {
      if (!this.affMail) {
         this.utilPrint = new UtilPrint(this.utilInitHibernate);
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

   public void majDateImpression() throws HibernateException, NamingException {
      if (this.bulletinSalaire != null && this.bulletinSalaire.getBulsalDateImpression() == null) {
         this.bulletinSalaire.setBulsalDateImpression(new Date());
         this.bulletinSalaire.setBulsalEtatBulletin(true);
         this.bulletinSalaire = this.bulletinSalaireDao.modif(this.bulletinSalaire);
      }

   }

   public void majDateImpressionMultiple(String var1) throws HibernateException, NamingException {
      if (var1 != null && !var1.isEmpty()) {
         this.bulletinSalaireDao.modifMultiple(var1, this.utilDate);
      }

   }

   public void majDateImpressionLot(String var1) throws HibernateException, NamingException {
      if (var1 != null && !var1.isEmpty()) {
         this.bulletinMois.setBulmenLot(this.bulletinMois.getBulmenLot() + 1);
         this.bulletinMois = this.bulletinMoisDao.majJournal(this.bulletinMois);
         this.bulletinSalaireDao.modifLot(var1, this.bulletinMois.getBulmenLot(), this.utilDate);
      }

   }

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      String var1;
      String var2;
      String var3;
      int var4;
      JRBeanCollectionDataSource var5;
      ArrayList var9;
      if (this.var_choix_modele == 2) {
         if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty() && this.lesContrats.size() != 0) {
            this.utilPrint.setRapport(this.nomModeleListe);
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "preparation" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Impression préparation");
            this.utilPrint.setNomMapping("Salarie");
            this.utilPrint.setTri(this.optionPaye.getTriAgents());
            if (this.optionPaye.getTriAgents().equals("0")) {
               var1 = "order by pay_salaries.sal_matricule";
            } else {
               var1 = "order by pay_salaries.sal_nom, pay_salaries.sal_prenom, pay_salaries.sal_matricule";
            }

            var2 = "";
            if (this.lesContrats.size() != 0) {
               var3 = "";
               var4 = 0;

               while(true) {
                  if (var4 >= this.lesContrats.size()) {
                     var2 = "salvar_periode = '" + this.bulletinMois.getBulmenPeriode() + "' and pay_salaries.sal_id in (" + var3 + ") " + var1;
                     break;
                  }

                  if (var3 != null && !var3.isEmpty()) {
                     var3 = var3 + "," + ((SalariesContrats)this.lesContrats.get(var4)).getSalaries().getSalId();
                  } else {
                     var3 = "" + ((SalariesContrats)this.lesContrats.get(var4)).getSalaries().getSalId();
                  }

                  ++var4;
               }
            }

            this.utilPrint.setRequete(var2);
            this.utilPrint.setFormat(this.format);
            var3 = "";
            if (this.var_feuille_rec != null && !this.var_feuille_rec.isEmpty()) {
               var3 = var3 + " F N° " + this.var_feuille_rec;
            }

            if (this.var_activite_rec != null && !this.var_activite_rec.isEmpty()) {
               var3 = var3 + " ACT: " + this.var_activite_rec;
            }

            if (this.var_service_rec != null && !this.var_service_rec.isEmpty()) {
               var3 = var3 + " SRV: " + this.var_service_rec;
            }

            if (this.var_projet_rec != null && !this.var_projet_rec.isEmpty()) {
               (new StringBuilder()).append(var3).append(" PRJ: ").append(this.var_projet_rec).toString();
            }

            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setDestinataireCC(this.impDestinataireCC);
            this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            var9 = new ArrayList();
            var5 = new JRBeanCollectionDataSource(var9);
            this.utilPrint.setjRBeanCollectionDataSource(var5);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      } else if (this.var_choix_modele == 3) {
         if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty() && this.lesSalariesRubriques.size() != 0) {
            this.utilPrint.setRapport(this.nomModeleListe);
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "rubrique" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Impression préparation");
            this.utilPrint.setNomMapping("Salarie");
            this.utilPrint.setTri(this.optionPaye.getTriAgents());
            if (this.optionPaye.getTriAgents().equals("0")) {
               var1 = "order by pay_salaries.sal_matricule";
            } else {
               var1 = "order by pay_salaries.sal_nom, pay_salaries.sal_prenom, pay_salaries.sal_matricule";
            }

            var2 = "";
            if (this.lesSalariesRubriques.size() != 0) {
               var3 = "";
               var4 = 0;

               while(true) {
                  if (var4 >= this.lesSalariesRubriques.size()) {
                     var2 = "salvar_id in (" + var3 + ") " + var1;
                     break;
                  }

                  if (var3 != null && !var3.isEmpty()) {
                     var3 = var3 + "," + ((SalariesVariables)this.lesSalariesRubriques.get(var4)).getSalvarId();
                  } else {
                     var3 = "" + ((SalariesVariables)this.lesSalariesRubriques.get(var4)).getSalvarId();
                  }

                  ++var4;
               }
            }

            this.utilPrint.setRequete(var2);
            this.utilPrint.setFormat(this.format);
            var3 = "";

            for(var4 = 0; var4 < this.lesVariablesItems.size(); ++var4) {
               if (((SelectItem)this.lesVariablesItems.get(var4)).getValue().toString().equals(this.variableSaisie)) {
                  var3 = ((SelectItem)this.lesVariablesItems.get(var4)).getLabel().toString();
                  break;
               }
            }

            if (var3 == null || var3.isEmpty()) {
               var3 = "Acompte de Quinzaine";
            }

            if (this.var_feuille_rec != null && !this.var_feuille_rec.isEmpty()) {
               var3 = var3 + " F N° " + this.var_feuille_rec;
            }

            if (this.var_activite_rec != null && !this.var_activite_rec.isEmpty()) {
               var3 = var3 + " ACT: " + this.var_activite_rec;
            }

            if (this.var_service_rec != null && !this.var_service_rec.isEmpty()) {
               var3 = var3 + " SRV: " + this.var_service_rec;
            }

            if (this.var_projet_rec != null && !this.var_projet_rec.isEmpty()) {
               var3 = var3 + " PRJ: " + this.var_projet_rec;
            }

            this.utilPrint.setFiltre(var3);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setDestinataireCC(this.impDestinataireCC);
            this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            var9 = new ArrayList();
            var5 = new JRBeanCollectionDataSource(var9);
            this.utilPrint.setjRBeanCollectionDataSource(var5);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
         }
      } else if (this.var_choix_modele == 4 && this.nomModeleListe != null && !this.nomModeleListe.isEmpty() && this.lesElements.size() != 0) {
         this.utilPrint.setRapport(this.nomModeleListe);
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "preparationJournalier" + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
         this.utilPrint.setEntete("Impression préparation");
         this.utilPrint.setNomMapping("");
         this.utilPrint.setRequete("");
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         ArrayList var6 = new ArrayList();
         if (this.lesElements.size() != 0) {
            new Salaries();

            for(int var10 = 0; var10 < this.lesElements.size(); ++var10) {
               new Salaries();
               Salaries var7 = ((SalariesElements)this.lesElements.get(var10)).getSalaries();
               var7.setDateContratJournalier(this.bulletinMois.getBulmenJour());
               var6.add(var7);
            }
         }

         JRBeanCollectionDataSource var8 = new JRBeanCollectionDataSource(var6);
         this.utilPrint.setjRBeanCollectionDataSource(var8);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
      }

   }

   public boolean isAffListeDoc() {
      return this.affListeDoc;
   }

   public void setAffListeDoc(boolean var1) {
      this.affListeDoc = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public String getFormat() {
      return this.format;
   }

   public void setFormat(String var1) {
      this.format = var1;
   }

   public List getDocumentImpressionItems() {
      return this.documentImpressionItems;
   }

   public void setDocumentImpressionItems(List var1) {
      this.documentImpressionItems = var1;
   }

   public List getListeImpressionItems() {
      return this.listeImpressionItems;
   }

   public void setListeImpressionItems(List var1) {
      this.listeImpressionItems = var1;
   }

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
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

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
   }

   public boolean isVar_acc_contrat() {
      return this.var_acc_contrat;
   }

   public void setVar_acc_contrat(boolean var1) {
      this.var_acc_contrat = var1;
   }

   public boolean isVar_acc_grh() {
      return this.var_acc_grh;
   }

   public void setVar_acc_grh(boolean var1) {
      this.var_acc_grh = var1;
   }

   public boolean isVar_acc_absences() {
      return this.var_acc_absences;
   }

   public void setVar_acc_absences(boolean var1) {
      this.var_acc_absences = var1;
   }

   public boolean isVar_acc_bulletins() {
      return this.var_acc_bulletins;
   }

   public void setVar_acc_bulletins(boolean var1) {
      this.var_acc_bulletins = var1;
   }

   public boolean isVar_acc_complement() {
      return this.var_acc_complement;
   }

   public void setVar_acc_complement(boolean var1) {
      this.var_acc_complement = var1;
   }

   public boolean isVar_acc_conges() {
      return this.var_acc_conges;
   }

   public void setVar_acc_conges(boolean var1) {
      this.var_acc_conges = var1;
   }

   public boolean isVar_acc_familial() {
      return this.var_acc_familial;
   }

   public void setVar_acc_familial(boolean var1) {
      this.var_acc_familial = var1;
   }

   public boolean isVar_acc_historiques() {
      return this.var_acc_historiques;
   }

   public void setVar_acc_historiques(boolean var1) {
      this.var_acc_historiques = var1;
   }

   public boolean isVar_acc_identification() {
      return this.var_acc_identification;
   }

   public void setVar_acc_identification(boolean var1) {
      this.var_acc_identification = var1;
   }

   public boolean isVar_acc_prets() {
      return this.var_acc_prets;
   }

   public void setVar_acc_prets(boolean var1) {
      this.var_acc_prets = var1;
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

   public DataModel getDatamodelSalaries() {
      return this.datamodelSalaries;
   }

   public void setDatamodelSalaries(DataModel var1) {
      this.datamodelSalaries = var1;
   }

   public List getLesSalaries() {
      return this.lesSalaries;
   }

   public void setLesSalaries(List var1) {
      this.lesSalaries = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public CalculChrono getCalculChrono() {
      return this.calculChrono;
   }

   public void setCalculChrono(CalculChrono var1) {
      this.calculChrono = var1;
   }

   public ExercicesPaye getExercicesPaye() {
      return this.exercicesPaye;
   }

   public void setExercicesPaye(ExercicesPaye var1) {
      this.exercicesPaye = var1;
   }

   public ExercicesPaye getLastExoPaye() {
      return this.lastExoPaye;
   }

   public void setLastExoPaye(ExercicesPaye var1) {
      this.lastExoPaye = var1;
   }

   public OptionPaye getOptionPaye() {
      return this.optionPaye;
   }

   public void setOptionPaye(OptionPaye var1) {
      this.optionPaye = var1;
   }

   public Habilitation getHabilitation() {
      return this.habilitation;
   }

   public void setHabilitation(Habilitation var1) {
      this.habilitation = var1;
   }

   public String getVar_nature_agent() {
      return this.var_nature_agent;
   }

   public void setVar_nature_agent(String var1) {
      this.var_nature_agent = var1;
   }

   public boolean isVar_affiche_nomJf() {
      return this.var_affiche_nomJf;
   }

   public void setVar_affiche_nomJf(boolean var1) {
      this.var_affiche_nomJf = var1;
   }

   public SalariesContrats getSalariesContrats() {
      return this.salariesContrats;
   }

   public void setSalariesContrats(SalariesContrats var1) {
      this.salariesContrats = var1;
   }

   public List getMesModelesItems() {
      return this.mesModelesItems;
   }

   public void setMesModelesItems(List var1) {
      this.mesModelesItems = var1;
   }

   public String getVar_code_modele() {
      return this.var_code_modele;
   }

   public void setVar_code_modele(String var1) {
      this.var_code_modele = var1;
   }

   public SalariesConges getSalariesConges() {
      return this.salariesConges;
   }

   public void setSalariesConges(SalariesConges var1) {
      this.salariesConges = var1;
   }

   public SalariesPrets getSalariesPrets() {
      return this.salariesPrets;
   }

   public void setSalariesPrets(SalariesPrets var1) {
      this.salariesPrets = var1;
   }

   public SalariesPretsLignes getSalariesPretsLignes() {
      return this.salariesPretsLignes;
   }

   public void setSalariesPretsLignes(SalariesPretsLignes var1) {
      this.salariesPretsLignes = var1;
   }

   public DataModel getDataModelAbsences() {
      return this.dataModelAbsences;
   }

   public void setDataModelAbsences(DataModel var1) {
      this.dataModelAbsences = var1;
   }

   public List getLesSalariesAbsences() {
      return this.lesSalariesAbsences;
   }

   public void setLesSalariesAbsences(List var1) {
      this.lesSalariesAbsences = var1;
   }

   public SalariesConges getSalariesAbsences() {
      return this.salariesAbsences;
   }

   public void setSalariesAbsences(SalariesConges var1) {
      this.salariesAbsences = var1;
   }

   public boolean isShowModalPanelAbsences() {
      return this.showModalPanelAbsences;
   }

   public void setShowModalPanelAbsences(boolean var1) {
      this.showModalPanelAbsences = var1;
   }

   public int getVar_action_absences() {
      return this.var_action_absences;
   }

   public void setVar_action_absences(int var1) {
      this.var_action_absences = var1;
   }

   public boolean isVar_affiche_absences() {
      return this.var_affiche_absences;
   }

   public void setVar_affiche_absences(boolean var1) {
      this.var_affiche_absences = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
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

   public boolean isShowModalPanelPrint() {
      return this.showModalPanelPrint;
   }

   public void setShowModalPanelPrint(boolean var1) {
      this.showModalPanelPrint = var1;
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

   public boolean isShowModalVisuEtat() {
      return this.showModalVisuEtat;
   }

   public void setShowModalVisuEtat(boolean var1) {
      this.showModalVisuEtat = var1;
   }

   public boolean isShowModalPanelVariable() {
      return this.showModalPanelVariable;
   }

   public void setShowModalPanelVariable(boolean var1) {
      this.showModalPanelVariable = var1;
   }

   public DataModel getDataModelVariables() {
      return this.dataModelVariables;
   }

   public void setDataModelVariables(DataModel var1) {
      this.dataModelVariables = var1;
   }

   public SalariesElements getSalariesElements() {
      return this.salariesElements;
   }

   public void setSalariesElements(SalariesElements var1) {
      this.salariesElements = var1;
   }

   public SalariesVariables getSalariesVariables() {
      return this.salariesVariables;
   }

   public void setSalariesVariables(SalariesVariables var1) {
      this.salariesVariables = var1;
   }

   public DataModel getDataModelFeuilles() {
      return this.dataModelFeuilles;
   }

   public void setDataModelFeuilles(DataModel var1) {
      this.dataModelFeuilles = var1;
   }

   public DataModel getDataModelPeriodes() {
      return this.dataModelPeriodes;
   }

   public void setDataModelPeriodes(DataModel var1) {
      this.dataModelPeriodes = var1;
   }

   public List getLesFeuilles() {
      return this.lesFeuilles;
   }

   public void setLesFeuilles(List var1) {
      this.lesFeuilles = var1;
   }

   public boolean isAfficheTJM() {
      return this.afficheTJM;
   }

   public void setAfficheTJM(boolean var1) {
      this.afficheTJM = var1;
   }

   public BulletinMois getBulletinMois() {
      return this.bulletinMois;
   }

   public void setBulletinMois(BulletinMois var1) {
      this.bulletinMois = var1;
   }

   public FeuilleCalcul getFeuilleCalcul() {
      return this.feuilleCalcul;
   }

   public void setFeuilleCalcul(FeuilleCalcul var1) {
      this.feuilleCalcul = var1;
   }

   public DataModel getDataModelBulletinsLigne() {
      return this.dataModelBulletinsLigne;
   }

   public void setDataModelBulletinsLigne(DataModel var1) {
      this.dataModelBulletinsLigne = var1;
   }

   public DataModel getDataModelLesBulletins() {
      return this.dataModelLesBulletins;
   }

   public void setDataModelLesBulletins(DataModel var1) {
      this.dataModelLesBulletins = var1;
   }

   public BulletinSalaire getBulletinSalaire() {
      return this.bulletinSalaire;
   }

   public void setBulletinSalaire(BulletinSalaire var1) {
      this.bulletinSalaire = var1;
   }

   public int getVar_currentValue() {
      return this.var_currentValue;
   }

   public void setVar_currentValue(int var1) {
      this.var_currentValue = var1;
   }

   public String getVar_info() {
      return this.var_info;
   }

   public void setVar_info(String var1) {
      this.var_info = var1;
   }

   public boolean isVar_showBarProg() {
      return this.var_showBarProg;
   }

   public void setVar_showBarProg(boolean var1) {
      this.var_showBarProg = var1;
   }

   public FormBakingBeanPaye getFormBakingBeanPaye() {
      return this.formBakingBeanPaye;
   }

   public void setFormBakingBeanPaye(FormBakingBeanPaye var1) {
      this.formBakingBeanPaye = var1;
   }

   public DataModel getDataModelListeBulletins() {
      return this.dataModelListeBulletins;
   }

   public void setDataModelListeBulletins(DataModel var1) {
      this.dataModelListeBulletins = var1;
   }

   public boolean isShowModalPanelListeBulletin() {
      return this.showModalPanelListeBulletin;
   }

   public void setShowModalPanelListeBulletin(boolean var1) {
      this.showModalPanelListeBulletin = var1;
   }

   public int getVar_choix_modele() {
      return this.var_choix_modele;
   }

   public void setVar_choix_modele(int var1) {
      this.var_choix_modele = var1;
   }

   public DataModel getDatamodelRubriques() {
      return this.datamodelRubriques;
   }

   public void setDatamodelRubriques(DataModel var1) {
      this.datamodelRubriques = var1;
   }

   public List getLesVariablesItems() {
      return this.lesVariablesItems;
   }

   public void setLesVariablesItems(List var1) {
      this.lesVariablesItems = var1;
   }

   public String getVariableSaisie() {
      return this.variableSaisie;
   }

   public void setVariableSaisie(String var1) {
      this.variableSaisie = var1;
   }

   public DataModel getDataModelEcheances() {
      return this.dataModelEcheances;
   }

   public void setDataModelEcheances(DataModel var1) {
      this.dataModelEcheances = var1;
   }

   public double getTotalPret() {
      return this.totalPret;
   }

   public void setTotalPret(double var1) {
      this.totalPret = var1;
   }

   public List getMesClesItems() {
      return this.mesClesItems;
   }

   public void setMesClesItems(List var1) {
      this.mesClesItems = var1;
   }

   public List getMesActivitesItems() {
      return this.mesActivitesItems;
   }

   public void setMesActivitesItems(List var1) {
      this.mesActivitesItems = var1;
   }

   public float getNbJourAbs() {
      return this.nbJourAbs;
   }

   public void setNbJourAbs(float var1) {
      this.nbJourAbs = var1;
   }

   public float getNbHeureRet() {
      return this.nbHeureRet;
   }

   public void setNbHeureRet(float var1) {
      this.nbHeureRet = var1;
   }

   public boolean isShowModalPanelSalaries() {
      return this.showModalPanelSalaries;
   }

   public void setShowModalPanelSalaries(boolean var1) {
      this.showModalPanelSalaries = var1;
   }

   public List getMesCentresImpotsItems() {
      return this.mesCentresImpotsItems;
   }

   public void setMesCentresImpotsItems(List var1) {
      this.mesCentresImpotsItems = var1;
   }

   public List getMesClassementsItems() {
      return this.mesClassementsItems;
   }

   public void setMesClassementsItems(List var1) {
      this.mesClassementsItems = var1;
   }

   public List getMesConventionsItems() {
      return this.mesConventionsItems;
   }

   public void setMesConventionsItems(List var1) {
      this.mesConventionsItems = var1;
   }

   public List getMesGrillesItems() {
      return this.mesGrillesItems;
   }

   public void setMesGrillesItems(List var1) {
      this.mesGrillesItems = var1;
   }

   public List getMesNiveauxEmploisItems() {
      return this.mesNiveauxEmploisItems;
   }

   public void setMesNiveauxEmploisItems(List var1) {
      this.mesNiveauxEmploisItems = var1;
   }

   public String getVar_centre() {
      return this.var_centre;
   }

   public void setVar_centre(String var1) {
      this.var_centre = var1;
   }

   public String getVar_classement() {
      return this.var_classement;
   }

   public void setVar_classement(String var1) {
      this.var_classement = var1;
   }

   public String getVar_convention() {
      return this.var_convention;
   }

   public void setVar_convention(String var1) {
      this.var_convention = var1;
   }

   public String getVar_grille() {
      return this.var_grille;
   }

   public void setVar_grille(String var1) {
      this.var_grille = var1;
   }

   public String getVar_niveau() {
      return this.var_niveau;
   }

   public void setVar_niveau(String var1) {
      this.var_niveau = var1;
   }

   public boolean isShowModalPanelPrintGene() {
      return this.showModalPanelPrintGene;
   }

   public void setShowModalPanelPrintGene(boolean var1) {
      this.showModalPanelPrintGene = var1;
   }

   public boolean isShowModalPanelPrintPrep() {
      return this.showModalPanelPrintPrep;
   }

   public void setShowModalPanelPrintPrep(boolean var1) {
      this.showModalPanelPrintPrep = var1;
   }

   public int getChoixCalcul() {
      return this.choixCalcul;
   }

   public void setChoixCalcul(int var1) {
      this.choixCalcul = var1;
   }

   public String getNomSalarie() {
      return this.nomSalarie;
   }

   public void setNomSalarie(String var1) {
      this.nomSalarie = var1;
   }

   public double getMontantAtteindre() {
      return this.montantAtteindre;
   }

   public void setMontantAtteindre(double var1) {
      this.montantAtteindre = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public int getChoixResultat() {
      return this.choixResultat;
   }

   public void setChoixResultat(int var1) {
      this.choixResultat = var1;
   }

   public List getMesNatureAgentsItems() {
      return this.mesNatureAgentsItems;
   }

   public void setMesNatureAgentsItems(List var1) {
      this.mesNatureAgentsItems = var1;
   }

   public int getVar_action_contrat() {
      return this.var_action_contrat;
   }

   public void setVar_action_contrat(int var1) {
      this.var_action_contrat = var1;
   }

   public List getMesFeuillesItems() {
      return this.mesFeuillesItems;
   }

   public void setMesFeuillesItems(List var1) {
      this.mesFeuillesItems = var1;
   }

   public List getMesParcItems() {
      return this.mesParcItems;
   }

   public void setMesParcItems(List var1) {
      this.mesParcItems = var1;
   }

   public List getLesBulletinsLigne() {
      return this.lesBulletinsLigne;
   }

   public void setLesBulletinsLigne(List var1) {
      this.lesBulletinsLigne = var1;
   }

   public boolean isShowModalPanelPrintRub() {
      return this.showModalPanelPrintRub;
   }

   public void setShowModalPanelPrintRub(boolean var1) {
      this.showModalPanelPrintRub = var1;
   }

   public boolean isVar_avn_domesticite() {
      return this.var_avn_domesticite;
   }

   public void setVar_avn_domesticite(boolean var1) {
      this.var_avn_domesticite = var1;
   }

   public boolean isVar_avn_eau() {
      return this.var_avn_eau;
   }

   public void setVar_avn_eau(boolean var1) {
      this.var_avn_eau = var1;
   }

   public boolean isVar_avn_electricite() {
      return this.var_avn_electricite;
   }

   public void setVar_avn_electricite(boolean var1) {
      this.var_avn_electricite = var1;
   }

   public boolean isVar_avn_logement() {
      return this.var_avn_logement;
   }

   public void setVar_avn_logement(boolean var1) {
      this.var_avn_logement = var1;
   }

   public boolean isVar_avn_nourriture() {
      return this.var_avn_nourriture;
   }

   public void setVar_avn_nourriture(boolean var1) {
      this.var_avn_nourriture = var1;
   }

   public boolean isVar_avn_telephone() {
      return this.var_avn_telephone;
   }

   public void setVar_avn_telephone(boolean var1) {
      this.var_avn_telephone = var1;
   }

   public boolean isVar_avn_vehicule() {
      return this.var_avn_vehicule;
   }

   public void setVar_avn_vehicule(boolean var1) {
      this.var_avn_vehicule = var1;
   }

   public boolean isVar_caisse() {
      return this.var_caisse;
   }

   public void setVar_caisse(boolean var1) {
      this.var_caisse = var1;
   }

   public boolean isVar_deplacement() {
      return this.var_deplacement;
   }

   public void setVar_deplacement(boolean var1) {
      this.var_deplacement = var1;
   }

   public boolean isVar_fonction() {
      return this.var_fonction;
   }

   public void setVar_fonction(boolean var1) {
      this.var_fonction = var1;
   }

   public boolean isVar_forfaitHeureSup() {
      return this.var_forfaitHeureSup;
   }

   public void setVar_forfaitHeureSup(boolean var1) {
      this.var_forfaitHeureSup = var1;
   }

   public boolean isVar_kilometre() {
      return this.var_kilometre;
   }

   public void setVar_kilometre(boolean var1) {
      this.var_kilometre = var1;
   }

   public boolean isVar_logement() {
      return this.var_logement;
   }

   public void setVar_logement(boolean var1) {
      this.var_logement = var1;
   }

   public boolean isVar_outillage() {
      return this.var_outillage;
   }

   public void setVar_outillage(boolean var1) {
      this.var_outillage = var1;
   }

   public boolean isVar_redement() {
      return this.var_redement;
   }

   public void setVar_redement(boolean var1) {
      this.var_redement = var1;
   }

   public boolean isVar_representation() {
      return this.var_representation;
   }

   public void setVar_representation(boolean var1) {
      this.var_representation = var1;
   }

   public boolean isVar_responsbilite() {
      return this.var_responsbilite;
   }

   public void setVar_responsbilite(boolean var1) {
      this.var_responsbilite = var1;
   }

   public boolean isVar_salissure() {
      return this.var_salissure;
   }

   public void setVar_salissure(boolean var1) {
      this.var_salissure = var1;
   }

   public boolean isVar_sujetion() {
      return this.var_sujetion;
   }

   public void setVar_sujetion(boolean var1) {
      this.var_sujetion = var1;
   }

   public boolean isVar_sursalaire() {
      return this.var_sursalaire;
   }

   public void setVar_sursalaire(boolean var1) {
      this.var_sursalaire = var1;
   }

   public boolean isVar_transport() {
      return this.var_transport;
   }

   public void setVar_transport(boolean var1) {
      this.var_transport = var1;
   }

   public boolean isVar_forfaitPrestataire() {
      return this.var_forfaitPrestataire;
   }

   public void setVar_forfaitPrestataire(boolean var1) {
      this.var_forfaitPrestataire = var1;
   }

   public DataModel getDataModelContrats() {
      return this.dataModelContrats;
   }

   public void setDataModelContrats(DataModel var1) {
      this.dataModelContrats = var1;
   }

   public boolean isCapitalisationActive() {
      return this.capitalisationActive;
   }

   public void setCapitalisationActive(boolean var1) {
      this.capitalisationActive = var1;
   }

   public boolean isVar_astreinte() {
      return this.var_astreinte;
   }

   public void setVar_astreinte(boolean var1) {
      this.var_astreinte = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public String getLibelleSelection() {
      return this.libelleSelection;
   }

   public void setLibelleSelection(String var1) {
      this.libelleSelection = var1;
   }

   public int getModeSelection() {
      return this.modeSelection;
   }

   public void setModeSelection(int var1) {
      this.modeSelection = var1;
   }

   public boolean isAccesOrange() {
      return this.accesOrange;
   }

   public void setAccesOrange(boolean var1) {
      this.accesOrange = var1;
   }

   public DataModel getDataModelLesElements() {
      return this.dataModelLesElements;
   }

   public void setDataModelLesElements(DataModel var1) {
      this.dataModelLesElements = var1;
   }

   public boolean isShowModalPanelJournalier() {
      return this.showModalPanelJournalier;
   }

   public void setShowModalPanelJournalier(boolean var1) {
      this.showModalPanelJournalier = var1;
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

   public DataModel getDataModelSasiesHistoriques() {
      return this.dataModelSasiesHistoriques;
   }

   public void setDataModelSasiesHistoriques(DataModel var1) {
      this.dataModelSasiesHistoriques = var1;
   }

   public boolean isPremierMois() {
      return this.premierMois;
   }

   public void setPremierMois(boolean var1) {
      this.premierMois = var1;
   }

   public DataModel getDataModelComptesVrt() {
      return this.dataModelComptesVrt;
   }

   public void setDataModelComptesVrt(DataModel var1) {
      this.dataModelComptesVrt = var1;
   }

   public DataModel getDataModelImmatriculation() {
      return this.dataModelImmatriculation;
   }

   public void setDataModelImmatriculation(DataModel var1) {
      this.dataModelImmatriculation = var1;
   }

   public String getLibelle_retraite() {
      return this.libelle_retraite;
   }

   public void setLibelle_retraite(String var1) {
      this.libelle_retraite = var1;
   }

   public String getLibelle_securite() {
      return this.libelle_securite;
   }

   public void setLibelle_securite(String var1) {
      this.libelle_securite = var1;
   }

   public List getMesServiceItems() {
      return this.mesServiceItems;
   }

   public void setMesServiceItems(List var1) {
      this.mesServiceItems = var1;
   }

   public String getVar_service_rec() {
      return this.var_service_rec;
   }

   public void setVar_service_rec(String var1) {
      this.var_service_rec = var1;
   }

   public List getMesProjetItems() {
      return this.mesProjetItems;
   }

   public void setMesProjetItems(List var1) {
      this.mesProjetItems = var1;
   }

   public String getVar_projet_rec() {
      return this.var_projet_rec;
   }

   public void setVar_projet_rec(String var1) {
      this.var_projet_rec = var1;
   }

   public int getSelectionMode() {
      return this.selectionMode;
   }

   public void setSelectionMode(int var1) {
      this.selectionMode = var1;
   }

   public String getLibelleRepartition() {
      return this.libelleRepartition;
   }

   public void setLibelleRepartition(String var1) {
      this.libelleRepartition = var1;
   }

   public String getVar_agent_rec() {
      return this.var_agent_rec;
   }

   public void setVar_agent_rec(String var1) {
      this.var_agent_rec = var1;
   }

   public int getModeRepartition() {
      return this.modeRepartition;
   }

   public void setModeRepartition(int var1) {
      this.modeRepartition = var1;
   }

   public String getVar_activite_rec() {
      return this.var_activite_rec;
   }

   public void setVar_activite_rec(String var1) {
      this.var_activite_rec = var1;
   }

   public String getVar_feuille_rec() {
      return this.var_feuille_rec;
   }

   public void setVar_feuille_rec(String var1) {
      this.var_feuille_rec = var1;
   }

   public long getVar_idclient_rec() {
      return this.var_idclient_rec;
   }

   public void setVar_idclient_rec(long var1) {
      this.var_idclient_rec = var1;
   }

   public List getMesClientsItems() {
      return this.mesClientsItems;
   }

   public void setMesClientsItems(List var1) {
      this.mesClientsItems = var1;
   }

   public List getMesLocalisationItems() {
      return this.mesLocalisationItems;
   }

   public void setMesLocalisationItems(List var1) {
      this.mesLocalisationItems = var1;
   }

   public String getVar_localisation_rec() {
      return this.var_localisation_rec;
   }

   public void setVar_localisation_rec(String var1) {
      this.var_localisation_rec = var1;
   }

   public List getMesLotsItems() {
      return this.mesLotsItems;
   }

   public void setMesLotsItems(List var1) {
      this.mesLotsItems = var1;
   }

   public String getVar_lot_rec() {
      return this.var_lot_rec;
   }

   public void setVar_lot_rec(String var1) {
      this.var_lot_rec = var1;
   }

   public boolean isShowModalPanelRecopierVariables() {
      return this.showModalPanelRecopierVariables;
   }

   public void setShowModalPanelRecopierVariables(boolean var1) {
      this.showModalPanelRecopierVariables = var1;
   }

   public List getMesMoisNonclotures() {
      return this.mesMoisNonclotures;
   }

   public void setMesMoisNonclotures(List var1) {
      this.mesMoisNonclotures = var1;
   }

   public String getMoisChoisi() {
      return this.moisChoisi;
   }

   public void setMoisChoisi(String var1) {
      this.moisChoisi = var1;
   }

   public String getVar_activite() {
      return this.var_activite;
   }

   public void setVar_activite(String var1) {
      this.var_activite = var1;
   }

   public String getVar_cle1() {
      return this.var_cle1;
   }

   public void setVar_cle1(String var1) {
      this.var_cle1 = var1;
   }

   public String getVar_cle2() {
      return this.var_cle2;
   }

   public void setVar_cle2(String var1) {
      this.var_cle2 = var1;
   }

   public String getVar_service() {
      return this.var_service;
   }

   public void setVar_service(String var1) {
      this.var_service = var1;
   }

   public boolean isDecoupageActivite() {
      return this.decoupageActivite;
   }

   public void setDecoupageActivite(boolean var1) {
      this.decoupageActivite = var1;
   }

   public boolean isAccesInterim() {
      return this.accesInterim;
   }

   public void setAccesInterim(boolean var1) {
      this.accesInterim = var1;
   }

   public boolean isVar_exceptionnel() {
      return this.var_exceptionnel;
   }

   public void setVar_exceptionnel(boolean var1) {
      this.var_exceptionnel = var1;
   }

   public boolean isAccesContrats() {
      return this.accesContrats;
   }

   public void setAccesContrats(boolean var1) {
      this.accesContrats = var1;
   }

   public boolean isAccesPrets() {
      return this.accesPrets;
   }

   public void setAccesPrets(boolean var1) {
      this.accesPrets = var1;
   }

   public boolean isAccesAbsences() {
      return this.accesAbsences;
   }

   public void setAccesAbsences(boolean var1) {
      this.accesAbsences = var1;
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

   public UIDataTable getExtDTableFeuille() {
      return this.extDTableFeuille;
   }

   public void setExtDTableFeuille(UIDataTable var1) {
      this.extDTableFeuille = var1;
   }

   public UIDataTable getExtDTablePeriode() {
      return this.extDTablePeriode;
   }

   public void setExtDTablePeriode(UIDataTable var1) {
      this.extDTablePeriode = var1;
   }

   public SimpleSelection getSimpleSelectionFeuille() {
      return this.simpleSelectionFeuille;
   }

   public void setSimpleSelectionFeuille(SimpleSelection var1) {
      this.simpleSelectionFeuille = var1;
   }

   public SimpleSelection getSimpleSelectionPeriode() {
      return this.simpleSelectionPeriode;
   }

   public void setSimpleSelectionPeriode(SimpleSelection var1) {
      this.simpleSelectionPeriode = var1;
   }

   public boolean isVar_diverse() {
      return this.var_diverse;
   }

   public void setVar_diverse(boolean var1) {
      this.var_diverse = var1;
   }

   public boolean isVar_indemResons() {
      return this.var_indemResons;
   }

   public void setVar_indemResons(boolean var1) {
      this.var_indemResons = var1;
   }

   public boolean isVar_nourriture() {
      return this.var_nourriture;
   }

   public void setVar_nourriture(boolean var1) {
      this.var_nourriture = var1;
   }

   public List getMesCentresSecuritesItems() {
      return this.mesCentresSecuritesItems;
   }

   public void setMesCentresSecuritesItems(List var1) {
      this.mesCentresSecuritesItems = var1;
   }

   public String getVar_securite() {
      return this.var_securite;
   }

   public void setVar_securite(String var1) {
      this.var_securite = var1;
   }

   public String getNomCreation() {
      return this.nomCreation;
   }

   public void setNomCreation(String var1) {
      this.nomCreation = var1;
   }

   public String getNomModification() {
      return this.nomModification;
   }

   public void setNomModification(String var1) {
      this.nomModification = var1;
   }

   public boolean isShowModalPanelInformation() {
      return this.showModalPanelInformation;
   }

   public void setShowModalPanelInformation(boolean var1) {
      this.showModalPanelInformation = var1;
   }

   public boolean isAfficheActivite() {
      return this.afficheActivite;
   }

   public void setAfficheActivite(boolean var1) {
      this.afficheActivite = var1;
   }

   public boolean isAfficheDepartement() {
      return this.afficheDepartement;
   }

   public void setAfficheDepartement(boolean var1) {
      this.afficheDepartement = var1;
   }

   public boolean isAfficheService() {
      return this.afficheService;
   }

   public void setAfficheService(boolean var1) {
      this.afficheService = var1;
   }

   public List getMesDepartementItems() {
      return this.mesDepartementItems;
   }

   public void setMesDepartementItems(List var1) {
      this.mesDepartementItems = var1;
   }

   public String getVar_departement_rec() {
      return this.var_departement_rec;
   }

   public void setVar_departement_rec(String var1) {
      this.var_departement_rec = var1;
   }

   public boolean isVar_prm_logement() {
      return this.var_prm_logement;
   }

   public void setVar_prm_logement(boolean var1) {
      this.var_prm_logement = var1;
   }

   public boolean isVar_prm_transport() {
      return this.var_prm_transport;
   }

   public void setVar_prm_transport(boolean var1) {
      this.var_prm_transport = var1;
   }

   public List getMesCodesEmploisItems() {
      return this.mesCodesEmploisItems;
   }

   public void setMesCodesEmploisItems(List var1) {
      this.mesCodesEmploisItems = var1;
   }

   public boolean isAfficheCodesEmplois() {
      return this.afficheCodesEmplois;
   }

   public void setAfficheCodesEmplois(boolean var1) {
      this.afficheCodesEmplois = var1;
   }

   public boolean isVar_option_parc() {
      return this.var_option_parc;
   }

   public void setVar_option_parc(boolean var1) {
      this.var_option_parc = var1;
   }

   public DataModel getDataModelNb() {
      return this.dataModelNb;
   }

   public void setDataModelNb(DataModel var1) {
      this.dataModelNb = var1;
   }

   public boolean isShowModalPanelEnfant() {
      return this.showModalPanelEnfant;
   }

   public void setShowModalPanelEnfant(boolean var1) {
      this.showModalPanelEnfant = var1;
   }

   public boolean isShowModalPanelFemme() {
      return this.showModalPanelFemme;
   }

   public void setShowModalPanelFemme(boolean var1) {
      this.showModalPanelFemme = var1;
   }
}
