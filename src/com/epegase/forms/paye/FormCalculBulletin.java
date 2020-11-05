package com.epegase.forms.paye;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.BonDecaissementAchat;
import com.epegase.systeme.classe.BulletinLigne;
import com.epegase.systeme.classe.BulletinMois;
import com.epegase.systeme.classe.BulletinSalaire;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.FeuilleCalcul;
import com.epegase.systeme.classe.FeuilleCalculFormule;
import com.epegase.systeme.classe.FeuilleCalculRubrique;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.PlanPaye;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesCapitalisation;
import com.epegase.systeme.classe.SalariesConges;
import com.epegase.systeme.classe.SalariesContrats;
import com.epegase.systeme.classe.SalariesElements;
import com.epegase.systeme.classe.SalariesGrh;
import com.epegase.systeme.classe.SalariesHistorique;
import com.epegase.systeme.classe.SalariesPrets;
import com.epegase.systeme.classe.SalariesPretsLignes;
import com.epegase.systeme.classe.SalariesVariables;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Sms;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.ObjetBaseReference;
import com.epegase.systeme.control.ObjetCtrlAgent;
import com.epegase.systeme.dao.BonDecaissementAchatDao;
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
import com.epegase.systeme.dao.SmsDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.formbakingbeans.FormBakingBeanPaye;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilSms;
import com.epegase.systeme.xml.LectureConventions;
import com.epegase.systeme.xml.LectureGrilleSalaire;
import com.epegase.systeme.xml.LectureNaturePrets;
import com.epegase.systeme.xml.ObjetConvention;
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
import java.util.Calendar;
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

public class FormCalculBulletin implements Serializable {
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
   private List documentImpressionItems;
   private List listeImpressionItems = new ArrayList();
   private boolean showModalPanelPrint = false;
   private boolean showModalPanelPrintPrep = false;
   private boolean showModalPanelPrintRub = false;
   private boolean showModalPanelPrintGene = false;
   private int cptMaxFlush = 100;
   private String libelleRepartition;
   private int modeRepartition;
   private String banqueSociete;
   private int modeBulletin;
   private List mesBanqueItems;
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
   private List mesNiveauxEmploisItems;
   private List mesCodesEmploisItems;
   private List mesClassementsItems;
   private List mesCentresImpotsItems;
   private List mesCentresSecuritesItems;
   private List mesConventionsItems;
   private List mesGrillesItems = new ArrayList();
   private List lesGrilles;
   private List lesSalariesGrh = new ArrayList();
   private SalariesGrhDao salariesGrhDao;
   private int modeSelection;
   private String libelleSelection;
   private List lesSasiesHistoriques;
   private transient DataModel dataModelSasiesHistoriques;
   private boolean premierMois;
   private List lesCompteVrt;
   private transient DataModel dataModelComptesVrt;
   private List lesImmatriculations;
   private transient DataModel dataModelImmatriculation;
   private String libelle_securite;
   private String libelle_retraite;
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
   private List lesBulletinsLigne = new ArrayList();
   private transient DataModel dataModelBulletinsLigne;
   private List lesRubriques;
   private FeuilleCalculRubrique feuilleCalculRubrique;
   private FeuilleCalculFormule feuilleCalculFormule;
   private FeuilleCalculFormuleDao feuilleCalculFormuleDao;
   private List lesformules;
   private List lesConges;
   private List lesAbsences;
   private List lesHistoriques;
   private SalariesHistoriqueDao salariesHistoriqueDao;
   private Date d1;
   private Date d2;
   private Date d1Reel;
   private Date d2Reel;
   private String operateur;
   private double valeur;
   private double memoValeur;
   private boolean etatTest;
   private int ligneEnCours;
   private Date dateGeneration;
   private double base_imposable_fiscale;
   private double base_imposable_sociale;
   private double base_conges;
   private int nbJourRef;
   private List lesPretsLignes;
   private int modeRegularisation;
   private String modePlafond;
   private int var_si;
   private int type_conges;
   private boolean majLigne;
   private float nombreJourPresence;
   private float absenceSurConges;
   private float absenceSurReposMaladie;
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
   private boolean var_sujetion;
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
   private boolean lotActif;
   private List mesNaturesPretsItems = new ArrayList();
   private boolean showModalPanelInformation = false;
   private String nomCreation;
   private String nomModification;
   private String nomCaissier;
   private boolean showModalPanelPaiement = false;
   private boolean var_affiche_bd = false;
   private boolean var_affiche_dollar = false;
   private boolean imputAll;

   public FormCalculBulletin() throws IOException {
   }

   public void InstancesDaoUtilses() {
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
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

   public void initialisation(Session var1) throws JDOMException, IOException, HibernateException, NamingException {
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
      this.var_choix_modele = 1;
      this.chargerLesModelesImpresion();
      if (this.accesInterim) {
         this.mesServiceItems.clear();
      }

      if (this.mesCodesEmploisItems != null && this.mesCodesEmploisItems.size() != 0) {
         this.afficheCodesEmplois = true;
      } else {
         this.afficheCodesEmplois = false;
      }

      if (this.structureLog.getStrcodepays().equals("0050")) {
         this.nbJourRef = 26;
      } else {
         this.nbJourRef = 30;
      }

   }

   public void accesResteintUser() {
      this.var_affiche_bd = false;
      this.var_affiche_dollar = false;
      if (this.usersLog.getUsrPayeCaisse() == 1) {
         this.var_affiche_dollar = true;
      } else if (this.usersLog.getUsrPayeCaisse() == 2) {
         if (this.rechercheModule(90000)) {
            this.var_affiche_bd = true;
         }
      } else if (this.usersLog.getUsrPayeCaisse() == 3) {
         this.var_affiche_dollar = true;
      } else if (this.usersLog.getUsrPayeCaisse() == 4) {
         if (this.rechercheModule(90000)) {
            this.var_affiche_bd = true;
         }

         this.var_affiche_dollar = true;
      }

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

   public void accesPaiement() throws JDOMException, IOException {
      if (this.structureLog.getStrcpteorange() != null && !this.structureLog.getStrcpteorange().isEmpty()) {
         this.accesOrange = true;
      } else {
         this.accesOrange = false;
      }

      LectureNaturePrets var1 = new LectureNaturePrets();
      var1.setStrId(this.structureLog.getStrid());
      var1.setStructureLog(this.structureLog);
      this.mesNaturesPretsItems = var1.chargerMesNaturesPretsItems();
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

   public void informationPiece() throws HibernateException, NamingException {
      if (this.bulletinSalaire != null) {
         this.nomCreation = "";
         this.nomModification = "";
         this.nomCaissier = "";
         new Users();
         UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Users var1;
         if (this.bulletinSalaire.getBulsalUserCreat() != 0L) {
            var1 = var2.selectUserD(this.bulletinSalaire.getBulsalUserCreat(), var3);
            if (var1 != null) {
               this.nomCreation = var1.getUsrPatronyme();
            }
         }

         if (this.bulletinSalaire.getBulsalUserModif() != 0L) {
            var1 = var2.selectUserD(this.bulletinSalaire.getBulsalUserModif(), var3);
            if (var1 != null) {
               this.nomModification = var1.getUsrPatronyme();
            }
         }

         if (this.bulletinSalaire.getBulsalPayeIdCaissier() != 0L) {
            var1 = var2.selectUserD(this.bulletinSalaire.getBulsalPayeIdCaissier(), var3);
            if (var1 != null) {
               this.nomCaissier = var1.getUsrPatronyme();
            }
         }

         this.utilInitHibernate.closeSession();
         this.showModalPanelInformation = true;
      }

   }

   public void fermerInformationPiece() {
      this.showModalPanelInformation = false;
   }

   public void paiementBulletin() throws HibernateException, NamingException {
      if (this.bulletinSalaire != null) {
         if (this.bulletinSalaire.getBulsalPayeIdCaissier() > 0L) {
            this.bulletinSalaire.setBulsalPayeBnq("");
            this.bulletinSalaire.setBulsalPayeChq("");
            this.bulletinSalaire.setBulsalPayeIdCaissier(0L);
            this.bulletinSalaire.setBulsalPayeDate((Date)null);
            this.bulletinSalaire = this.bulletinSalaireDao.modif(this.bulletinSalaire);
            Espion var1 = new Espion();
            var1.setUsers(this.usersLog);
            var1.setEsptype(0);
            var1.setEspdtecreat(new Date());
            var1.setEspaction("Annulation paiement du salarié N° " + this.bulletinSalaire.getSalaries().getSalMatricule() + "- Contrat N°: " + this.bulletinSalaire.getBulsalContrat() + " - Période:" + this.bulletinSalaire.getBulsalPeriode());
            this.espionDao.mAJEspion(var1);
         } else if (this.usersLog.getUsrPayeCaisse() == 1) {
            this.imputAll = false;
            this.showModalPanelPaiement = true;
         } else if (this.usersLog.getUsrPayeCaisse() != 2 && this.usersLog.getUsrPayeCaisse() == 3) {
         }
      }

   }

   public void fermerPaiement() {
      this.showModalPanelPaiement = false;
   }

   public void validerPaiement() throws HibernateException, NamingException {
      if (this.bulletinSalaire != null) {
         if (this.imputAll) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            Transaction var2 = null;

            try {
               var2 = var1.beginTransaction();

               for(int var3 = 0; var3 < this.lesBulletins.size(); ++var3) {
                  this.bulletinSalaire = (BulletinSalaire)this.lesBulletins.get(var3);
                  if (this.bulletinSalaire.getBulsalModeReglement() != 1 && this.bulletinSalaire.getBulsalModeReglement() != 2) {
                     if (this.bulletinSalaire.getBulsalModeReglement() == 0) {
                        this.bulletinSalaire.setBulsalPayeBnq("ESPECES");
                        this.bulletinSalaire.setBulsalPayeChq("");
                     } else if (this.bulletinSalaire.getBulsalModeReglement() == 3) {
                        this.bulletinSalaire.setBulsalPayeBnq("CARTE");
                        this.bulletinSalaire.setBulsalPayeChq("");
                     } else if (this.bulletinSalaire.getBulsalModeReglement() == 4) {
                        this.bulletinSalaire.setBulsalPayeBnq("MICRO-FINANCE");
                        this.bulletinSalaire.setBulsalPayeChq("");
                     } else if (this.bulletinSalaire.getBulsalModeReglement() == 5) {
                        this.bulletinSalaire.setBulsalPayeBnq("MOBILE");
                        this.bulletinSalaire.setBulsalPayeChq("");
                     } else if (this.bulletinSalaire.getBulsalModeReglement() == 9) {
                        this.bulletinSalaire.setBulsalPayeBnq("AUTRE");
                        this.bulletinSalaire.setBulsalPayeChq("");
                     }

                     this.bulletinSalaire.setBulsalPayeIdCaissier(this.usersLog.getUsrid());
                     this.bulletinSalaire.setBulsalPayeDate(new Date());
                     this.bulletinSalaire = this.bulletinSalaireDao.modif(this.bulletinSalaire, var1);
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
         } else {
            if (this.bulletinSalaire.getBulsalModeReglement() == 0) {
               this.bulletinSalaire.setBulsalPayeBnq("ESPECES");
               this.bulletinSalaire.setBulsalPayeChq("");
            } else if (this.bulletinSalaire.getBulsalModeReglement() == 3) {
               this.bulletinSalaire.setBulsalPayeBnq("CARTE");
               this.bulletinSalaire.setBulsalPayeChq("");
            } else if (this.bulletinSalaire.getBulsalModeReglement() == 4) {
               this.bulletinSalaire.setBulsalPayeBnq("MICRO-FINANCE");
               this.bulletinSalaire.setBulsalPayeChq("");
            } else if (this.bulletinSalaire.getBulsalModeReglement() == 5) {
               this.bulletinSalaire.setBulsalPayeBnq("MOBILE");
               this.bulletinSalaire.setBulsalPayeChq("");
            } else if (this.bulletinSalaire.getBulsalModeReglement() == 9) {
               this.bulletinSalaire.setBulsalPayeBnq("AUTRE");
               this.bulletinSalaire.setBulsalPayeChq("");
            }

            this.bulletinSalaire.setBulsalPayeIdCaissier(this.usersLog.getUsrid());
            this.bulletinSalaire.setBulsalPayeDate(new Date());
            this.bulletinSalaire = this.bulletinSalaireDao.modif(this.bulletinSalaire);
         }
      }

      this.showModalPanelPaiement = false;
   }

   public void decaissementBulletin() throws HibernateException, NamingException {
      if (this.lesBulletins.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            BonDecaissementAchatDao var3 = new BonDecaissementAchatDao(this.baseLog, this.utilInitHibernate);
            new BonDecaissementAchat();
            new BulletinSalaire();

            for(int var6 = 0; var6 < this.lesBulletins.size(); ++var6) {
               BulletinSalaire var5 = (BulletinSalaire)this.lesBulletins.get(var6);
               if (var5.getBulsalPayeIdCaissier() == 0L) {
                  String var7 = "";
                  BonDecaissementAchat var4 = new BonDecaissementAchat();
                  var4.setBonAPayer(this.bulletinSalaire.getBulsalNetPayer());
                  var4.setBonActif(0);
                  var4.setBonActivite(this.bulletinSalaire.getBulsalActivite());
                  var4.setBonBanqueTireur("");
                  var4.setBonBudget(this.bulletinSalaire.getBulsalBudget());
                  var4.setBonCodeBanq("");
                  var4.setBonCodeBudgetTreso("");
                  var4.setBonCodeCaisse("");
                  var4.setBonCodePosteTreso("");
                  var4.setBonDate(new Date());
                  var4.setBonDateAnnule((Date)null);
                  var4.setBonDateCreat(new Date());
                  var4.setBonDateEcheReg((Date)null);
                  var4.setBonDateModif((Date)null);
                  var4.setBonDateRelance((Date)null);
                  var4.setBonDateRemise((Date)null);
                  var4.setBonDateValeur((Date)null);
                  var4.setBonDepartement(this.bulletinSalaire.getBulsalDepartement());
                  var4.setBonDevise(this.structureLog.getStrdevise());
                  var4.setBonEtat(1);
                  var4.setBonGrp("");
                  var4.setBonIdContact(0L);
                  var4.setBonIdRef(this.bulletinSalaire.getBulsalId());
                  var4.setBonIdResponsable(this.usersLog.getUsrid());
                  var4.setBonIdTiers(this.bulletinSalaire.getSalaries().getSalId());
                  var4.setBonLibBanq("");
                  var4.setBonLibCaisse("");
                  var4.setBonLibelle("Période:" + this.bulletinSalaire.getBulsalPeriode() + " - Matricule:" + this.bulletinSalaire.getBulsalMatricule());
                  var4.setBonModeleImp("");
                  var4.setBonMotifAnnule("");
                  var4.setBonNatRef(90);
                  var4.setBonNomContact("");
                  var4.setBonNomResponsable(this.usersLog.getUsrPatronyme());
                  var4.setBonNomTiers(this.bulletinSalaire.getSalaries().getPatronyme());
                  var4.setBonNum(var7);
                  var4.setBonNumChqBdx("");
                  var4.setBonObject("Paiement Salaire");
                  var4.setBonObservation("");
                  var4.setBonPdv("");
                  var4.setBonRef(this.bulletinSalaire.getBulsalMatricule() + ":" + this.bulletinSalaire.getBulsalPeriode() + ":" + this.bulletinSalaire.getBulsalContrat());
                  var4.setBonRegion("");
                  var4.setBonSecteur("");
                  var4.setBonSerie("");
                  var4.setBonService(this.bulletinSalaire.getBulsalService());
                  var4.setBonSite(this.bulletinSalaire.getBulsalSite());
                  var4.setBonTotTtc(this.bulletinSalaire.getBulsalNetPayer());
                  var4.setBonTypeReg(this.bulletinSalaire.getBulsalModeReglement());
                  var4.setBonTypeTiers(6);
                  var4.setBonUserAnnule(0L);
                  var4.setBonUserCreat(this.usersLog.getUsrid());
                  var4.setBonUserModif(0L);
                  var3.insert(var4, var1);
                  var5.setBulsalPayeIdCaissier(-1L);
                  this.bulletinSalaireDao.modif(var5, var1);
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

   }

   public void selectionFeuilleGeneration() throws HibernateException, NamingException {
      this.lesBulletins = new ArrayList();
      this.dataModelLesBulletins = new ListDataModel();
      this.lesBulletinsLigne = new ArrayList();
      this.dataModelBulletinsLigne = new ListDataModel();
      this.lesformules = new ArrayList();
      this.lesRubriques = new ArrayList();
      this.lesVariables = new ArrayList();
      this.lesPretsLignes = new ArrayList();
      this.lesConges = new ArrayList();
      this.lesAbsences = new ArrayList();
      this.lesHistoriques = new ArrayList();
      this.salariesCapitalisation = new SalariesCapitalisation();
      this.simpleSelectionPeriode.clear();
      this.var_agent_rec = "";
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

   public void selectionPeriodeGenerationLight() throws HibernateException, NamingException, ParseException {
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

   public void selectionPeriodeGeneration() throws HibernateException, NamingException, ParseException {
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
            this.bulletinSalaireDao = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
            this.bulletinLigneDao = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
            Session var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            Transaction var4 = null;

            try {
               var4 = var11.beginTransaction();
               var11.setFlushMode(FlushMode.MANUAL);
               if (this.bulletinMois.getBulmenEtat() <= 2) {
                  this.bulletinMois.setBulmenUserIdGeneration(this.usersLog.getUsrid());
                  this.bulletinMois.setBulmenOpenUserGeneration(this.usersLog.getUsrPatronyme());
                  this.bulletinMois.setBulmenOpenGeneration(1);
                  this.bulletinMois = this.bulletinMoisDao.majJournal(this.bulletinMois, var11);
                  var11.flush();
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

               this.chagerSalarieGeneration(var11);
               var4.commit();
            } catch (HibernateException var9) {
               if (var4 != null) {
                  var4.rollback();
               }

               throw var9;
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

   public void chagerSalarieGeneration() throws HibernateException, NamingException, ParseException {
      this.chagerSalarieGeneration((Session)null);
   }

   public void chagerSalarieGeneration(Session var1) throws HibernateException, NamingException, ParseException {
      this.bulletinSalaire = new BulletinSalaire();
      this.bulletinLigne = new BulletinLigne();
      this.lesBulletins.clear();
      new ArrayList();
      List var2 = this.charerBulletinSuite(var1);
      int var5;
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.bulletinSalaire = (BulletinSalaire)var2.get(var3);
            if (this.usersLog.getUsrPaye() == 0 || this.usersLog.getUsrPaye() != 0 && this.bulletinSalaire.getSalaries().getSalProtege() == 0) {
               boolean var4 = false;

               for(var5 = 0; var5 < this.mesNatureAgentsItems.size(); ++var5) {
                  if (((SelectItem)this.mesNatureAgentsItems.get(var5)).getValue().equals(this.bulletinSalaire.getBulsalNature())) {
                     var4 = true;
                     break;
                  }
               }

               if (var4) {
                  this.lesBulletins.add(this.bulletinSalaire);
               }
            }
         }
      }

      this.dataModelLesBulletins.setWrappedData(this.lesBulletins);
      if (this.accesInterim) {
         this.mesServiceItems.clear();
         if (this.var_idclient_rec != 0L) {
            new ArrayList();
            SiteDao var7 = new SiteDao(this.baseLog, this.utilInitHibernate);
            List var6 = var7.chargerLesSitesListByClient(this.var_idclient_rec, var1);
            if (var6.size() != 0) {
               for(var5 = 0; var5 < var6.size(); ++var5) {
                  this.mesServiceItems.add(new SelectItem(((Site)var6.get(var5)).getSitCode() + ":" + ((Site)var6.get(var5)).getSitNomFr()));
               }
            }
         }
      }

      this.calculLotBulletin();
   }

   public List charerBulletinSuite(Session var1) throws ParseException, HibernateException, NamingException {
      new ArrayList();
      int var3 = Integer.parseInt(this.optionPaye.getTriAgents());
      List var2;
      if (this.feuilleCalcul.getFeuNature() != null && !this.feuilleCalcul.getFeuNature().isEmpty() && this.feuilleCalcul.getFeuNature().startsWith("04")) {
         this.dateGeneration = this.bulletinMois.getBulmenJour();
         this.d1 = this.utilDate.datePremierJourMois(this.dateGeneration);
         this.d2 = this.utilDate.dateDernierJourMois(this.dateGeneration);
         this.d1Reel = this.utilDate.datePremierJourMois(this.dateGeneration);
         this.d2Reel = this.utilDate.dateDernierJourMois(this.dateGeneration);
         var2 = this.bulletinSalaireDao.chargerlesBulletinsbyFeuilleJour(this.bulletinMois.getBulmenFeuille(), var3, this.bulletinMois.getBulmenJour(), this.var_service_rec, var1);
      } else {
         String[] var4 = this.bulletinMois.getBulmenPeriode().split(":");
         this.dateGeneration = this.utilDate.stringToDateSQLLight(var4[1] + "-" + var4[0] + "-01");
         this.d1 = this.utilDate.datePremierJourMois(this.dateGeneration);
         this.d2 = this.utilDate.dateDernierJourMois(this.dateGeneration);
         if (this.feuilleCalcul.getFeuDecale() != 0) {
            int var5 = this.feuilleCalcul.getFeuDecale() * -1;
            Date var6 = this.utilDate.datePremierJourMois(this.dateGeneration);
            this.d1Reel = this.utilDate.datedevaleurTheo(var6, var5);
            Date var7 = this.utilDate.dateDernierJourMois(this.dateGeneration);
            this.d2Reel = this.utilDate.datedevaleurTheo(var7, var5);
         } else {
            this.d1Reel = this.utilDate.datePremierJourMois(this.dateGeneration);
            this.d2Reel = this.utilDate.dateDernierJourMois(this.dateGeneration);
         }

         var2 = this.bulletinSalaireDao.listelesBulletin(this.modeRepartition, var3, this.d1, this.d2, this.bulletinMois.getBulmenFeuille(), this.bulletinMois.getBulmenPeriode(), this.var_agent_rec, this.var_activite_rec, this.var_service_rec, this.var_departement_rec, this.var_localisation_rec, this.var_projet_rec, this.var_feuille_rec, this.var_idclient_rec, this.var_lot_rec, var1);
      }

      return var2;
   }

   public void fermerPeriodeGeneration() throws HibernateException, NamingException {
      if (this.bulletinMois != null && this.bulletinMois.getBulmenEtat() <= 2) {
         this.bulletinMois.setBulmenUserIdGeneration(0L);
         this.bulletinMois.setBulmenOpenUserGeneration("");
         this.bulletinMois.setBulmenOpenGeneration(0);
         if (this.bulletinMois.getBulmenEtat() == 1) {
            this.bulletinMois.setBulmenEtat(2);
         }

         this.bulletinMois = this.bulletinMoisDao.majJournal(this.bulletinMois);
      }

      this.afficheTJM = false;
      this.var_action = 0;
   }

   public void calculLotBulletin() {
      this.mesLotsItems.clear();
      if (this.bulletinMois.getBulmenLot() != 0) {
         for(int var1 = 0; var1 < this.bulletinMois.getBulmenLot(); ++var1) {
            this.mesLotsItems.add(new SelectItem("" + (var1 + 1)));
         }
      }

   }

   public void selectionLigneGeneree() {
      if (this.dataModelLesBulletins.isRowAvailable()) {
         this.bulletinSalaire = (BulletinSalaire)this.dataModelLesBulletins.getRowData();
         this.var_affiche_bouton = true;
      } else {
         this.var_affiche_bouton = false;
      }

   }

   public void visualisationBulletin() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.bulletinSalaire != null) {
         this.consulterBulletin();
      }

   }

   public void consulterBulletin() throws HibernateException, NamingException {
      this.formBakingBeanPaye.consulterBulletin(this.bulletinSalaire);
   }

   public void verrouilleBulletin() throws HibernateException, NamingException {
      this.selectionLigneGeneree();
      if (this.bulletinSalaire != null && this.formBakingBeanPaye.getMenupaye().isClo()) {
         this.bulletinSalaire.setBulsalEtatBulletin(true);
         this.bulletinSalaire.setBulsalUserModif(this.usersLog.getUsrid());
         this.bulletinSalaire = this.bulletinSalaireDao.modif(this.bulletinSalaire);
      }

   }

   public void deVerrouilleBulletin() throws HibernateException, NamingException {
      this.selectionLigneGeneree();
      if (this.bulletinSalaire != null && this.formBakingBeanPaye.getMenupaye().isClo()) {
         this.bulletinSalaire.setBulsalEtatBulletin(false);
         this.bulletinSalaire.setBulsalUserModif(this.usersLog.getUsrid());
         this.bulletinSalaire = this.bulletinSalaireDao.modif(this.bulletinSalaire);
      }

   }

   public void selectionSuppressionBulletin() {
      this.modeSelection = 1;
      this.libelleSelection = "SELECTION DU/DES BULLETINS DE SALAIRE";
      this.lesSalaries.clear();
      this.datamodelSalaries.setWrappedData(this.lesSalaries);
      if (this.lesBulletins.size() != 0) {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.lesBulletins.size(); ++var2) {
            if (this.lesBulletins.size() != 0) {
               for(int var3 = 0; var3 < this.lesBulletins.size(); ++var3) {
                  if (((BulletinSalaire)this.lesBulletins.get(var3)).getSalaries().getSalId() == ((BulletinSalaire)this.lesBulletins.get(var2)).getSalaries().getSalId()) {
                     var1 = ((BulletinSalaire)this.lesBulletins.get(var3)).isBulsalEtatBulletin();
                     if (var1) {
                        break;
                     }
                  }
               }
            }

            if (!var1) {
               this.lesSalaries.add(((BulletinSalaire)this.lesBulletins.get(var2)).getSalaries());
            }
         }

         if (this.lesSalaries.size() != 0) {
            this.datamodelSalaries.setWrappedData(this.lesSalaries);
            this.salaries = null;
            this.showModalPanelSalaries = true;
         }
      }

   }

   public void fermerSuppressionBulletin() {
      this.showModalPanelSalaries = false;
   }

   public void validerSuppressionBulletin() throws HibernateException, NamingException {
      if (this.lesSalaries.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         int var3;
         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            var3 = 0;

            while(true) {
               if (var3 >= this.lesSalaries.size()) {
                  var2.commit();
                  break;
               }

               this.salaries = (Salaries)this.lesSalaries.get(var3);
               if (this.salaries.isSelect_agent()) {
                  long var4 = 0L;

                  for(int var6 = 0; var6 < this.lesBulletins.size(); ++var6) {
                     this.bulletinSalaire = (BulletinSalaire)this.lesBulletins.get(var6);
                     if (!this.bulletinSalaire.isBulsalEtatBulletin() && this.bulletinSalaire.getBulsalMatricule().equals(this.salaries.getSalMatricule())) {
                        var4 = this.bulletinSalaire.getBulsalId();
                        break;
                     }
                  }

                  if (var4 != 0L) {
                     this.libereEcheancePret(var1);
                  }
               }

               ++var3;
            }
         } catch (HibernateException var10) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.lesBulletins.clear();
         var3 = Integer.parseInt(this.optionPaye.getTriAgents());
         this.lesBulletins = this.bulletinSalaireDao.listelesBulletin(this.modeRepartition, var3, this.d1, this.d2, this.bulletinMois.getBulmenFeuille(), this.bulletinMois.getBulmenPeriode(), this.var_agent_rec, this.var_activite_rec, this.var_service_rec, this.var_departement_rec, this.var_localisation_rec, this.var_projet_rec, this.var_feuille_rec, this.var_idclient_rec, this.var_lot_rec, (Session)null);
         this.dataModelLesBulletins.setWrappedData(this.lesBulletins);
         this.bulletinSalaire = null;
      }

      this.showModalPanelSalaries = false;
   }

   public void libereEcheancePret(Session var1) throws HibernateException, NamingException {
      if (this.bulletinSalaire != null && !this.bulletinSalaire.isBulsalEtatBulletin()) {
         long var2 = this.bulletinSalaire.getBulsalId();
         new ArrayList();
         List var4 = this.bulletinLigneDao.chargerleslignesBulletin(this.bulletinSalaire, var1);
         if (var4.size() != 0) {
            for(int var5 = 0; var5 < var4.size(); ++var5) {
               this.bulletinLigne = (BulletinLigne)var4.get(var5);
               if (this.bulletinLigne.getBulligIdPretligne() != 0L) {
                  this.salariesPretsLignes = this.salariesPretsLignesDao.pourParapheur(this.bulletinLigne.getBulligIdPretligne(), var1);
                  if (this.salariesPretsLignes != null) {
                     double var6 = this.salariesPretsLignes.getSalpreligMontantReel();
                     this.salariesPretsLignes.setSalpreligDateReel((Date)null);
                     this.salariesPretsLignes.setSalpreligMontantReel(0.0D);
                     this.salariesPretsLignes = this.salariesPretsLignesDao.modif(this.salariesPretsLignes, var1);
                     var1.flush();
                     if (var6 != 0.0D) {
                        this.salariesPrets = this.salariesPretsLignes.getSalariesPrets();
                        this.salariesPrets.setSalpreRmb(this.salariesPrets.getSalpreRmb() - var6);
                        this.salariesPrets = this.salariesPretsDao.modif(this.salariesPrets, var1);
                        var1.flush();
                     }
                  }
               }

               this.bulletinLigneDao.delete(this.bulletinLigne, var1);
               var1.flush();
            }
         }

         this.bulletinSalaire = this.bulletinSalaireDao.pourParapheur(var2, var1);
         if (this.bulletinSalaire != null) {
            this.bulletinSalaireDao.delete(this.bulletinSalaire, var1);
            var1.flush();
         }
      }

   }

   public void envoyerSms() throws HibernateException, NamingException, IOException, SQLException {
      if (this.lesBulletins.size() != 0) {
         UtilSms var1 = new UtilSms(this.utilInitHibernate, this.structureLog, this.usersLog, this.baseLog);
         SmsDao var2 = new SmsDao(this.baseLog, this.utilInitHibernate);
         Sms var3 = new Sms();
         ArrayList var4 = new ArrayList();
         String var5 = "Paiement salaire periode du " + this.bulletinMois.getBulmenPeriode();
         String var6 = "";
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "Sms");
         Transaction var8 = null;

         try {
            var8 = var7.beginTransaction();
            var7.setFlushMode(FlushMode.MANUAL);

            for(int var9 = 0; var9 < this.lesBulletins.size(); ++var9) {
               this.bulletinSalaire = (BulletinSalaire)this.lesBulletins.get(var9);
               if (this.bulletinSalaire.getSalaries().getSalCel1() != null && !this.bulletinSalaire.getSalaries().getSalCel1().isEmpty()) {
                  if (var6 == null && var6.isEmpty()) {
                     var6 = this.bulletinSalaire.getSalaries().getSalCel1();
                  } else {
                     var6 = var6 + "," + this.bulletinSalaire.getSalaries().getSalCel1();
                  }

                  var3 = new Sms();
                  var3 = var1.enregistrementSms(var3, var2, var5, this.bulletinSalaire.getSalaries().getSalCel1(), this.bulletinSalaire.getSalaries().getPatronyme(), this.bulletinSalaire.getSalaries().getSalCivilite(), this.bulletinSalaire.getSalaries().getSalId(), (String)null, 0L, 2, var7);
                  var4.add(var3);
               }
            }

            String var15 = var1.sendSmsListe(var5, var6);
            var1.majStatut(var4, var15, var3, var2, var7);
            var8.commit();
         } catch (HibernateException var13) {
            if (var8 != null) {
               var8.rollback();
            }

            throw var13;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

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

   public void historiqueRubrique() throws HibernateException, NamingException {
      this.formBakingBeanPaye.historiqueRubrique(this.bulletinSalaire);
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

   public void historiqueBulletin(long var1, Session var3) throws HibernateException, NamingException {
      if (var1 != 0L) {
         this.salaries = this.salariesDao.chercherIdSalaries(var1, var3);
         if (this.salaries != null) {
            this.bulletinSalaireDao = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
            this.bulletinSalaire = this.bulletinSalaireDao.rechercheBulletinSalarieDernier(this.salaries.getSalMatricule(), var3);
            if (this.bulletinSalaire != null) {
               this.formBakingBeanPaye.historiqueRubrique(this.bulletinSalaire);
            }
         }
      }

   }

   public void fermerListeBulletin() {
      this.showModalPanelListeBulletin = false;
   }

   public void nouvelleGeneration() throws HibernateException, NamingException, ParseException {
      if (this.feuilleCalcul != null) {
         this.var_info = "Initialisation en cours...";
         this.var_currentValue = 0;
         this.lesBulletins.clear();
         this.lesBulletinsLigne.clear();
         String[] var1 = this.bulletinMois.getBulmenPeriode().split(":");
         this.dateGeneration = this.utilDate.stringToDateSQLLight(var1[1] + "-" + var1[0] + "-01");
         this.d1 = this.utilDate.datePremierJourMois(this.dateGeneration);
         this.d2 = this.utilDate.dateDernierJourMois(this.dateGeneration);
         Date var3;
         Date var4;
         if (this.feuilleCalcul.getFeuDecale() != 0) {
            int var2 = this.feuilleCalcul.getFeuDecale() * -1;
            var3 = this.utilDate.datePremierJourMois(this.dateGeneration);
            this.d1Reel = this.utilDate.datedevaleurTheo(var3, var2);
            var4 = this.utilDate.dateDernierJourMois(this.dateGeneration);
            this.d2Reel = this.utilDate.datedevaleurTheo(var4, var2);
         } else {
            this.d1Reel = this.utilDate.datePremierJourMois(this.dateGeneration);
            this.d2Reel = this.utilDate.dateDernierJourMois(this.dateGeneration);
         }

         this.var_lot_rec = "";
         Session var35 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         var3 = null;

         int var6;
         int var8;
         double var12;
         try {
            Transaction var36 = var35.beginTransaction();
            var35.setFlushMode(FlushMode.MANUAL);
            this.var_info = "Suppression ancienne generation...";
            new ArrayList();
            int var5 = Integer.parseInt(this.optionPaye.getTriAgents());
            List var37 = this.bulletinSalaireDao.listelesBulletin(this.modeRepartition, var5, this.d1, this.d2, this.bulletinMois.getBulmenFeuille(), this.bulletinMois.getBulmenPeriode(), this.var_agent_rec, this.var_activite_rec, this.var_service_rec, this.var_departement_rec, this.var_localisation_rec, this.var_projet_rec, this.var_feuille_rec, this.var_idclient_rec, this.var_lot_rec, var35);
            if (var37.size() != 0) {
               for(var6 = 0; var6 < var37.size(); ++var6) {
                  this.bulletinSalaire = (BulletinSalaire)var37.get(var6);
                  if (!this.bulletinSalaire.isBulsalEtatBulletin() && (this.usersLog.getUsrPaye() == 0 || this.usersLog.getUsrPaye() != 0 && this.bulletinSalaire.getSalaries().getSalProtege() == 0 || this.usersLog.getUsrPaye() == 5 && this.bulletinSalaire.getSalaries().getSalProtege() == 1)) {
                     boolean var7 = false;

                     for(var8 = 0; var8 < this.mesNatureAgentsItems.size(); ++var8) {
                        if (((SelectItem)this.mesNatureAgentsItems.get(var8)).getValue().equals(this.bulletinSalaire.getBulsalNature())) {
                           var7 = true;
                           break;
                        }
                     }

                     if (var7) {
                        this.var_info = "Suppression du salarie : " + this.bulletinSalaire.getSalaries().getSalNom();
                        if (var6 != 0) {
                           double var41 = (double)var37.size();
                           double var10 = this.utilNombre.myRound(var41 / (double)var6, 4);
                           var12 = this.utilNombre.myRound(100.0D / var10, 2);
                           this.var_currentValue = (int)var12;
                        }

                        if (this.bulletinSalaire != null) {
                           this.libereEcheancePret(var35);
                        }
                     }
                  }
               }
            }

            var36.commit();
         } catch (HibernateException var33) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var33;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         var35 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         var4 = null;

         try {
            Transaction var38 = var35.beginTransaction();
            var35.setFlushMode(FlushMode.MANUAL);
            String var39 = "";
            this.var_currentValue = 0;
            if (this.modeRepartition == 0) {
               this.lesRubriques.clear();
               this.lesRubriques = this.feuilleCalculRubriqueDao.chargerRubriqueFeuilleActive(this.feuilleCalcul, this.exercicesPaye.getExepayId(), var35);
            }

            if (this.lesRubriques.size() != 0 || this.modeRepartition != 0) {
               this.verificationPrecalcul(var35);
               this.lesSalaries.clear();
               var6 = Integer.parseInt(this.optionPaye.getTriAgents());
               new ArrayList();
               List var40 = this.salariesContratsDao.listelesContratsActif(this.modeRepartition, var6, this.d1, this.d2, this.bulletinMois.getBulmenFeuille(), this.var_agent_rec, this.var_activite_rec, this.var_service_rec, this.var_departement_rec, this.var_localisation_rec, this.var_projet_rec, this.var_feuille_rec, this.var_idclient_rec, var35);
               if (var40.size() != 0) {
                  for(var8 = 0; var8 < var40.size(); ++var8) {
                     this.salariesContrats = (SalariesContrats)var40.get(var8);
                     this.salaries = this.salariesContrats.getSalaries();
                     if (this.usersLog.getUsrPaye() == 0 || this.usersLog.getUsrPaye() != 0 && this.salaries.getSalProtege() == 0 || this.usersLog.getUsrPaye() == 5 && this.salaries.getSalProtege() == 1) {
                        if (this.salariesContrats.getSalconEtatH() != 1) {
                           this.bulletinSalaire.setObservations("CONTRAT NON VALIDE");
                           this.bulletinSalaire.setBulsalMatricule(this.salaries.getSalMatricule());
                           this.bulletinSalaire.setSalaries(this.salaries);
                           this.lesBulletins.add(this.bulletinSalaire);
                        } else {
                           boolean var9 = false;
                           if (this.modeRepartition == 0) {
                              if (this.salariesContrats.getSalconFeuille().equals(this.bulletinMois.getBulmenFeuille())) {
                                 var9 = true;
                              }
                           } else if (this.modeRepartition == 1) {
                              if (this.salariesContrats.getSalconActivite().equals(this.bulletinMois.getBulmenFeuille())) {
                                 var9 = true;
                              }
                           } else if (this.modeRepartition == 2) {
                              if (this.salariesContrats.getSalconService().equals(this.bulletinMois.getBulmenFeuille())) {
                                 var9 = true;
                              }
                           } else if (this.modeRepartition == 3) {
                              if (this.salariesContrats.getSalconProjet().equals(this.bulletinMois.getBulmenFeuille())) {
                                 var9 = true;
                              }
                           } else if (this.modeRepartition == 4 && this.salariesContrats.getSalconIdTiers() == Long.parseLong(this.bulletinMois.getBulmenFeuille())) {
                              var9 = true;
                           }

                           if (var9) {
                              if (this.verifBulletin(var35)) {
                                 this.bulletinSalaire.setObservations("BULLETIN VERROUILLE");
                                 this.bulletinSalaire.setBulsalMatricule(this.salaries.getSalMatricule());
                                 this.bulletinSalaire.setSalaries(this.salaries);
                                 this.lesBulletins.add(this.bulletinSalaire);
                              } else {
                                 boolean var42 = false;

                                 int var11;
                                 for(var11 = 0; var11 < this.mesNatureAgentsItems.size(); ++var11) {
                                    if (((SelectItem)this.mesNatureAgentsItems.get(var11)).getValue().equals(this.salariesContrats.getSalconType())) {
                                       var42 = true;
                                       break;
                                    }
                                 }

                                 if (var42) {
                                    this.var_info = "Calcul du salarie : " + this.salaries.getSalNom();
                                    if (var8 != 0) {
                                       double var43 = (double)var40.size();
                                       double var13 = this.utilNombre.myRound(var43 / (double)var8, 4);
                                       double var15 = this.utilNombre.myRound(100.0D / var13, 2);
                                       this.var_currentValue = (int)var15;
                                    }

                                    if (this.modeRepartition != 0 && (var39 == null || var39.isEmpty() || !var39.equals(this.salariesContrats.getSalconFeuille()))) {
                                       this.lesRubriques.clear();
                                       this.lesRubriques = this.feuilleCalculRubriqueDao.chargerRubriqueFeuilleActive(this.salariesContrats.getSalconFeuille(), this.exercicesPaye.getExepayId(), var35);
                                    }

                                    var39 = this.salariesContrats.getSalconFeuille();
                                    this.lesVariables.clear();
                                    this.lesAbsences.clear();
                                    this.lesConges.clear();
                                    this.lesPretsLignes.clear();
                                    this.lesHistoriques.clear();
                                    this.montantSursalaire = 0.0D;
                                    this.nombreJourPresence = 0.0F;
                                    this.absenceSurConges = 0.0F;
                                    this.absenceSurReposMaladie = 0.0F;
                                    if (this.salariesContrats != null) {
                                       this.lesVariables = this.salariesVariablesDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), this.salariesContrats.getSalconNum(), var35);
                                    } else {
                                       this.lesVariables = this.salariesVariablesDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), "", var35);
                                    }

                                    if (this.lesVariables.size() != 0) {
                                       if (this.salariesContrats != null) {
                                          this.salariesElements = this.salariesElementsDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), this.salariesContrats.getSalconNum(), var35);
                                       } else {
                                          this.salariesElements = this.salariesElementsDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), "", var35);
                                       }

                                       if (this.salariesElements == null) {
                                          this.bulletinSalaire = new BulletinSalaire();
                                          this.bulletinSalaire.setObservations("PAS D`ELEMENTS SALARIES");
                                          this.bulletinSalaire.setBulsalMatricule(this.salaries.getSalMatricule());
                                          this.bulletinSalaire.setSalaries(this.salaries);
                                          this.lesBulletins.add(this.bulletinSalaire);
                                       } else if (this.salariesElements.getSaleleEtat() != 9 && (this.salariesContrats == null || this.salariesContrats != null && this.salariesContrats.getSalconEtat() != 9)) {
                                          this.verificationNBenfants(var35);
                                          if (this.capitalisationActive) {
                                             if (this.salariesContrats != null) {
                                                this.salariesCapitalisation = this.salariesCapitalisationDao.chargerleCapital(this.salaries, this.salariesContrats.getSalconNum(), var35);
                                             } else {
                                                this.salariesCapitalisation = this.salariesCapitalisationDao.chargerleCapital(this.salaries, "", var35);
                                             }
                                          } else {
                                             this.salariesCapitalisation = null;
                                          }

                                          if (this.salariesContrats != null) {
                                             this.lesHistoriques = this.salariesHistoriqueDao.chargerlesHistoriquesBySalaries(this.salaries, this.salariesContrats.getSalconNum(), this.exercicesPaye, var35);
                                             if (this.lesHistoriques.size() == 0) {
                                                this.lesHistoriques = this.salariesHistoriqueDao.chargerlesHistoriquesBySalaries(this.salaries, "", this.exercicesPaye, var35);
                                             }
                                          } else {
                                             this.lesHistoriques = this.salariesHistoriqueDao.chargerlesHistoriquesBySalaries(this.salaries, "", this.exercicesPaye, var35);
                                          }

                                          if (this.salariesContrats != null) {
                                             this.lesConges = this.salariesCongesDao.chargerlesCongesValide(this.salaries, this.salariesContrats.getSalconNum(), var35);
                                          } else {
                                             this.lesConges = this.salariesCongesDao.chargerlesCongesValide(this.salaries, "", var35);
                                          }

                                          if (!this.verifConges()) {
                                             this.lesBulletinsLigne.clear();
                                             this.bulletinSalaire = new BulletinSalaire();
                                             this.bulletinSalaire.setBulsalActivite(this.salariesElements.getSaleleActivite());
                                             this.bulletinSalaire.setBulsalBudget(this.salariesElements.getSaleleBudget());
                                             this.bulletinSalaire.setBulsalCentresImpots(this.salariesElements.getSaleleCentresImpots());
                                             this.bulletinSalaire.setBulsalCentresSecurite(this.salariesElements.getSaleleCentresSecurite());
                                             this.bulletinSalaire.setBulsalCivilite(this.salariesElements.getSaleleCivilite());
                                             this.bulletinSalaire.setBulsalClassement(this.salariesElements.getSaleleClassement());
                                             this.bulletinSalaire.setBulsalConvention(this.salariesElements.getSaleleConvention());
                                             this.bulletinSalaire.setBulsalContrat(this.salariesContrats.getSalconNum());
                                             this.bulletinSalaire.setBulsalEssai(this.salariesContrats.getSalconEssai());
                                             this.bulletinSalaire.setBulsalProjet(this.salariesContrats.getSalconProjet());
                                             this.d1 = this.utilDate.datePremierJourMois(this.dateGeneration);
                                             this.d2 = this.utilDate.dateDernierJourMois(this.dateGeneration);
                                             if (this.feuilleCalcul.getFeuDecale() != 0) {
                                                var11 = this.feuilleCalcul.getFeuDecale() * -1;
                                                Date var44 = this.utilDate.datePremierJourMois(this.dateGeneration);
                                                this.d1Reel = this.utilDate.datedevaleurTheo(var44, var11);
                                                this.bulletinSalaire.setBulsalDateDebutReel(this.d1Reel);
                                                Date var46 = this.utilDate.dateDernierJourMois(this.dateGeneration);
                                                this.d2Reel = this.utilDate.datedevaleurTheo(var46, var11);
                                                this.bulletinSalaire.setBulsalDateFinReel(this.d2Reel);
                                             } else {
                                                this.bulletinSalaire.setBulsalDateDebutReel(this.d1);
                                                this.bulletinSalaire.setBulsalDateFinReel(this.d2);
                                             }

                                             this.bulletinSalaire.setBulsalDateDebut(this.d1);
                                             this.bulletinSalaire.setBulsalDateFin(this.d2);
                                             this.bulletinSalaire.setBulsalDateentree(this.salariesContrats.getSalconDateDebut());
                                             this.bulletinSalaire.setBulsalDateSortie(this.salariesContrats.getSalconDateFin());
                                             this.bulletinSalaire.setBulsalDepartement(this.salariesElements.getSaleleDepartement());
                                             this.bulletinSalaire.setBulsalEtat(this.salariesElements.getSaleleEtat());
                                             this.bulletinSalaire.setBulsalFeuille(this.salariesElements.getSaleleFeuille());
                                             this.bulletinSalaire.setBulsalFonction(this.salariesElements.getSaleleFonction());
                                             this.bulletinSalaire.setBulsalSecu1(this.salaries.getSalNumSecu());
                                             if (!this.structureLog.getStrcodepays().equals("0029") && !this.structureLog.getStrcodepays().equals("0041") && !this.structureLog.getStrcodepays().equals("0050") && !this.structureLog.getStrcodepays().equals("0056")) {
                                                if (this.structureLog.getStrcodepays().equals("0077")) {
                                                   this.bulletinSalaire.setBulsalSecu2(this.salaries.getSalNumCnamgs());
                                                } else if (!this.structureLog.getStrcodepays().equals("0078") && !this.structureLog.getStrcodepays().equals("0088") && !this.structureLog.getStrcodepays().equals("0089") && !this.structureLog.getStrcodepays().equals("0090")) {
                                                   if (this.structureLog.getStrcodepays().equals("0138")) {
                                                      this.bulletinSalaire.setBulsalSecu2(this.salaries.getSalNumAmo());
                                                   } else if (!this.structureLog.getStrcodepays().equals("0142") && !this.structureLog.getStrcodepays().equals("0202") && !this.structureLog.getStrcodepays().equals("0222")) {
                                                      this.bulletinSalaire.setBulsalSecu2("");
                                                   }
                                                }
                                             }

                                             this.bulletinSalaire.setBulsalGenre(this.salariesElements.getSaleleGenre());
                                             this.bulletinSalaire.setBulsalGrille(this.salariesElements.getSaleleGrille());
                                             this.bulletinSalaire.setBulsalLibCentresImpots(this.salariesElements.getSaleleLibCentresImpots());
                                             this.bulletinSalaire.setBulsalLibCentresSecurite(this.salariesElements.getSaleleLibCentresSecurite());
                                             this.bulletinSalaire.setBulsalLibClassement(this.salariesElements.getSaleleLibClassement());
                                             this.bulletinSalaire.setBulsalLibConvention(this.salariesElements.getSaleleLibConvention());
                                             this.bulletinSalaire.setBulsalLibGrille(this.salariesElements.getSaleleLibGrille());
                                             this.bulletinSalaire.setBulsalLibNivEmploi(this.salariesElements.getSaleleLibNivEmploi());
                                             this.bulletinSalaire.setBulsalLocalisation(this.salariesElements.getSaleleLocalisation());
                                             this.bulletinSalaire.setBulsalMatricule(this.salariesElements.getSaleleMatricule());
                                             this.bulletinSalaire.setBulsalMotifSortie(this.salariesElements.getSaleleMotifSortie());
                                             this.bulletinSalaire.setBulsalNature(this.salariesElements.getSaleleNature());
                                             this.bulletinSalaire.setBulsalNbEnfant(this.salariesElements.getSaleleNbEnfant());
                                             this.bulletinSalaire.setBulsalNbFemme(this.salariesElements.getSaleleNbFemme());
                                             this.bulletinSalaire.setBulsalNbJourCp(this.salariesElements.getSaleleNbJourCp());
                                             this.bulletinSalaire.setBulsalNbJourTr(this.salariesElements.getSaleleNbJourTr());
                                             this.bulletinSalaire.setBulsalNbPartFiscal(this.salariesElements.getSaleleNbPartFiscal());
                                             this.bulletinSalaire.setBulsalNbPartTrimf(this.salariesElements.getSaleleNbPartTrimf());
                                             this.bulletinSalaire.setBulsalNivEmploi(this.salariesElements.getSaleleNivEmploi());
                                             this.bulletinSalaire.setBulsalParc(this.salariesElements.getSaleleParc());
                                             this.bulletinSalaire.setBulsalPeriode(this.bulletinMois.getBulmenPeriode());
                                             this.bulletinSalaire.setBulsalService(this.salariesElements.getSaleleService());
                                             this.bulletinSalaire.setBulsalLibService(this.salariesElements.getSaleleLibService());
                                             this.bulletinSalaire.setBulsalSitFamille(this.salariesElements.getSaleleSitFamille());
                                             this.bulletinSalaire.setBulsalSite(this.salariesElements.getSaleleSite());
                                             this.bulletinSalaire.setBulsalCle1Anal(this.salariesElements.getSaleleCle1Anal());
                                             this.bulletinSalaire.setBulsalCle2Anal(this.salariesElements.getSaleleCle2Anal());
                                             this.bulletinSalaire.setBulsalModeReglement(this.salariesElements.getSaleleModeReglement());
                                             this.bulletinSalaire.setBulsalNumBanque(this.salariesElements.getSaleleNumBanque());
                                             this.bulletinSalaire.setBulsalGuichetBanque(this.salariesElements.getSaleleGuichetBanque());
                                             this.bulletinSalaire.setBulsalCompteBanque(this.salariesElements.getSaleleCompteBanque());
                                             this.bulletinSalaire.setBulsalCleBanque(this.salariesElements.getSaleleCleBanque());
                                             this.bulletinSalaire.setBulsalIban(this.salariesElements.getSaleleIban());
                                             this.bulletinSalaire.setBulsalSwift(this.salariesElements.getSaleleSwift());
                                             this.bulletinSalaire.setBulsalCompteMembre(this.salariesElements.getSaleleCompteMembre());
                                             this.bulletinSalaire.setExercicesPaye(this.exercicesPaye);
                                             this.bulletinSalaire.setSalaries(this.salaries);
                                             this.bulletinSalaire.setBulsalUserCreat(this.usersLog.getUsrid());
                                             this.bulletinSalaire = this.bulletinSalaireDao.insert(this.bulletinSalaire, var35);
                                             if (this.salariesContrats != null) {
                                                this.lesAbsences = this.salariesCongesDao.chargerlesAbsencesValidePeriode(this.salaries, this.salariesContrats.getSalconNum(), this.d1, this.d2, var35);
                                             } else {
                                                this.lesAbsences = this.salariesCongesDao.chargerlesAbsencesValidePeriode(this.salaries, "", this.d1, this.d2, var35);
                                             }

                                             this.verificationNetAAtteindre();
                                             if (this.netAAtteindre != 0.0D) {
                                                boolean var45 = true;
                                                var12 = 0.0D;
                                                double var14 = 0.0D;
                                                double var16 = 0.0D;

                                                for(int var18 = 0; var18 < 100; ++var18) {
                                                   this.generationBulletin(var35);
                                                   var16 = 0.0D;

                                                   int var19;
                                                   for(var19 = 0; var19 < this.lesBulletinsLigne.size(); ++var19) {
                                                      if (((BulletinLigne)this.lesBulletinsLigne.get(var19)).getBulligRubrique().equals("100030")) {
                                                         var14 = ((BulletinLigne)this.lesBulletinsLigne.get(var19)).getBulligValColE();
                                                      }

                                                      if (((BulletinLigne)this.lesBulletinsLigne.get(var19)).getBulligNature() == 80) {
                                                         var16 += ((BulletinLigne)this.lesBulletinsLigne.get(var19)).getBulligValColE() * -1.0D;
                                                      }

                                                      if (((BulletinLigne)this.lesBulletinsLigne.get(var19)).getBulligRubrique().equals("699999")) {
                                                         double var20 = ((BulletinLigne)this.lesBulletinsLigne.get(var19)).getBulligValColE() + var16;
                                                         if (var20 != this.netAAtteindre && var18 != 99) {
                                                            this.montantSursalaire += this.netAAtteindre - var20;
                                                            var45 = true;
                                                            break;
                                                         }

                                                         var45 = false;
                                                         break;
                                                      }
                                                   }

                                                   if (!var45) {
                                                      if (this.lesBulletinsLigne.size() != 0) {
                                                         for(var19 = 0; var19 < this.lesBulletinsLigne.size(); ++var19) {
                                                            this.bulletinLigne = (BulletinLigne)this.lesBulletinsLigne.get(var19);
                                                            if (this.bulletinLigne.getBulligValColE() != 0.0D) {
                                                               this.bulletinLigne.setBulletinSalaire(this.bulletinSalaire);
                                                               this.bulletinLigne.setExercicesPaye(this.exercicesPaye);
                                                               this.bulletinLigne.setSalaries(this.salaries);
                                                               this.bulletinLigne = this.bulletinLigneDao.insert(this.bulletinLigne, var35);
                                                            }
                                                         }

                                                         this.calculEnteteBulletin(var35);
                                                         this.bulletinSalaire = this.bulletinSalaireDao.pourParapheur(this.bulletinSalaire.getBulsalId(), var35);
                                                         if (this.bulletinSalaire != null) {
                                                            this.bulletinSalaire.setBulsalUserModif(this.usersLog.getUsrid());
                                                            this.bulletinSalaire = this.bulletinSalaireDao.modif(this.bulletinSalaire, var35);
                                                         }
                                                      }
                                                      break;
                                                   }

                                                   this.lesBulletinsLigne.clear();
                                                }
                                             } else {
                                                this.generationBulletin(var35);
                                             }

                                             var35.flush();
                                             this.lesBulletins.add(this.bulletinSalaire);
                                          } else {
                                             this.bulletinSalaire = new BulletinSalaire();
                                             this.bulletinSalaire.setObservations("LE SALARIE EST EN CONGES");
                                             this.bulletinSalaire.setBulsalMatricule(this.salaries.getSalMatricule());
                                             this.bulletinSalaire.setSalaries(this.salaries);
                                             this.lesBulletins.add(this.bulletinSalaire);
                                          }
                                       } else {
                                          this.bulletinSalaire = new BulletinSalaire();
                                          this.bulletinSalaire.setObservations("LE SALARIE EST GELE");
                                          this.bulletinSalaire.setBulsalMatricule(this.salaries.getSalMatricule());
                                          this.bulletinSalaire.setSalaries(this.salaries);
                                          this.bulletinSalaire.setBulsalEtat(9);
                                          this.lesBulletins.add(this.bulletinSalaire);
                                       }
                                    } else {
                                       this.bulletinSalaire = new BulletinSalaire();
                                       this.bulletinSalaire.setObservations("PAS DE VARIABLES SALARIES");
                                       this.bulletinSalaire.setBulsalMatricule(this.salaries.getSalMatricule());
                                       this.bulletinSalaire.setSalaries(this.salaries);
                                       this.lesBulletins.add(this.bulletinSalaire);
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               } else {
                  this.bulletinSalaire = new BulletinSalaire();
                  this.bulletinSalaire.setObservations("PAS DE CONTRAT POUR CETTE PERIODE");
                  this.bulletinSalaire.setBulsalMatricule(this.salaries.getSalMatricule());
                  this.bulletinSalaire.setSalaries(this.salaries);
                  this.lesBulletins.add(this.bulletinSalaire);
               }

               this.dataModelLesBulletins.setWrappedData(this.lesBulletins);
            }

            var38.commit();
         } catch (HibernateException var31) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var31;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      if (this.bulletinMois.getBulmenEtat() <= 2) {
         if (this.bulletinMois.getBulmenEtat() == 1) {
            this.bulletinMois.setBulmenEtat(2);
         }

         this.bulletinMois = this.bulletinMoisDao.majJournal(this.bulletinMois);
      }

      this.var_affiche_bouton = false;
   }

   public void selectionRegeneration() throws HibernateException, NamingException, ParseException, ParseException {
      this.modeSelection = 0;
      this.libelleSelection = "SELECTION DU/DES SALARIE(S)";
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ImpressionPaye");
      int var2 = Integer.parseInt(this.optionPaye.getTriAgents());
      String[] var3 = this.bulletinMois.getBulmenPeriode().split(":");
      this.dateGeneration = this.utilDate.stringToDateSQLLight(var3[1] + "-" + var3[0] + "-01");
      this.d1 = this.utilDate.datePremierJourMois(this.dateGeneration);
      this.d2 = this.utilDate.dateDernierJourMois(this.dateGeneration);
      this.d1Reel = this.utilDate.datePremierJourMois(this.dateGeneration);
      this.d2Reel = this.utilDate.dateDernierJourMois(this.dateGeneration);
      this.lesSalaries.clear();
      new ArrayList();
      List var4 = this.salariesContratsDao.listelesContratsActif(this.modeRepartition, var2, this.d1, this.d2, this.bulletinMois.getBulmenFeuille(), this.var_agent_rec, this.var_activite_rec, this.var_service_rec, this.var_departement_rec, this.var_localisation_rec, this.var_projet_rec, this.var_feuille_rec, this.var_idclient_rec, var1);
      if (var4.size() != 0) {
         new ArrayList();
         List var5;
         if (this.lesBulletins.size() != 0 && !this.lotActif) {
            var5 = this.lesBulletins;
         } else {
            this.var_lot_rec = "";
            var5 = this.charerBulletinSuite(var1);
         }

         boolean var6 = false;

         for(int var7 = 0; var7 < var4.size(); ++var7) {
            if (((SalariesContrats)var4.get(var7)).getSalconEtatH() == 1 && (this.usersLog.getUsrPaye() == 0 || this.usersLog.getUsrPaye() != 0 && ((SalariesContrats)var4.get(var7)).getSalaries().getSalProtege() == 0)) {
               var6 = false;
               if (var5.size() != 0) {
                  for(int var8 = 0; var8 < var5.size(); ++var8) {
                     if (((BulletinSalaire)var5.get(var8)).getSalaries().getSalId() == ((SalariesContrats)var4.get(var7)).getSalaries().getSalId()) {
                        var6 = ((BulletinSalaire)var5.get(var8)).isBulsalEtatBulletin();
                        if (var6) {
                           break;
                        }
                     }
                  }
               }

               if (!var6) {
                  boolean var10 = false;

                  for(int var9 = 0; var9 < this.mesNatureAgentsItems.size(); ++var9) {
                     if (((SelectItem)this.mesNatureAgentsItems.get(var9)).getValue().equals(((SalariesContrats)var4.get(var7)).getSalconType())) {
                        var10 = true;
                        break;
                     }
                  }

                  if (var10) {
                     ((SalariesContrats)var4.get(var7)).getSalaries().setSalFeuille(((SalariesContrats)var4.get(var7)).getSalconFeuille());
                     this.lesSalaries.add(((SalariesContrats)var4.get(var7)).getSalaries());
                  }
               }
            }
         }

         if (this.lesSalaries.size() != 0) {
            this.datamodelSalaries.setWrappedData(this.lesSalaries);
            this.salaries = null;
            this.showModalPanelSalaries = true;
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void fermerRegeneration() {
      this.showModalPanelSalaries = false;
   }

   public void selectionSalarie() {
      if (this.datamodelSalaries.isRowAvailable()) {
         this.salaries = (Salaries)this.datamodelSalaries.getRowData();
      }

   }

   public void regenerationSurListe() throws HibernateException, NamingException, ParseException {
      this.showModalPanelSalaries = false;
      if (this.lesSalaries.size() != 0) {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.lesSalaries.size(); ++var2) {
            this.salaries = (Salaries)this.lesSalaries.get(var2);
            if ((this.usersLog.getUsrPaye() == 0 || this.usersLog.getUsrPaye() != 0 && this.salaries.getSalProtege() == 0 || this.usersLog.getUsrPaye() == 5 && this.salaries.getSalProtege() == 1) && this.salaries.isSelect_agent()) {
               var1 = true;
               if (this.salaries != null) {
                  this.bulletinSalaire = null;
                  long var3 = 0L;
                  String var5 = this.salaries.getSalMatricule();
                  int var6 = 0;

                  for(int var7 = 0; var7 < this.lesBulletins.size(); ++var7) {
                     this.bulletinSalaire = (BulletinSalaire)this.lesBulletins.get(var7);
                     if (this.bulletinSalaire.getBulsalMatricule().equals(var5)) {
                        var3 = this.bulletinSalaire.getBulsalId();
                        var6 = var7;
                        break;
                     }
                  }

                  this.var_info = "Initialisation en cours...";
                  this.var_currentValue = 0;
                  this.lesBulletinsLigne.clear();
                  String[] var18 = this.bulletinMois.getBulmenPeriode().split(":");
                  this.dateGeneration = this.utilDate.stringToDateSQLLight(var18[1] + "-" + var18[0] + "-01");
                  this.d1 = this.utilDate.datePremierJourMois(this.dateGeneration);
                  this.d2 = this.utilDate.dateDernierJourMois(this.dateGeneration);
                  if (this.feuilleCalcul.getFeuDecale() != 0) {
                     int var8 = this.feuilleCalcul.getFeuDecale() * -1;
                     Date var9 = this.utilDate.datePremierJourMois(this.dateGeneration);
                     this.d1Reel = this.utilDate.datedevaleurTheo(var9, var8);
                     Date var10 = this.utilDate.dateDernierJourMois(this.dateGeneration);
                     this.d2Reel = this.utilDate.datedevaleurTheo(var10, var8);
                  } else {
                     this.d1Reel = this.utilDate.datePremierJourMois(this.dateGeneration);
                     this.d2Reel = this.utilDate.dateDernierJourMois(this.dateGeneration);
                  }

                  boolean var19 = true;
                  boolean var20 = false;
                  if (var3 != 0L) {
                     Session var21 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
                     Transaction var11 = null;

                     try {
                        var11 = var21.beginTransaction();
                        var21.setFlushMode(FlushMode.MANUAL);
                        this.var_info = "Suppression ancienne generation...";

                        for(int var12 = 0; var12 < this.lesBulletins.size(); ++var12) {
                           this.bulletinSalaire = (BulletinSalaire)this.lesBulletins.get(var12);
                           if (!this.bulletinSalaire.isBulsalEtatBulletin() && this.bulletinSalaire.getBulsalMatricule().equals(this.salaries.getSalMatricule())) {
                              this.libereEcheancePret(var21);
                           }
                        }

                        this.bulletinSalaire = null;
                        var11.commit();
                     } catch (HibernateException var16) {
                        var19 = false;
                        if (var11 != null) {
                           var11.rollback();
                        }

                        throw var16;
                     } finally {
                        this.utilInitHibernate.closeSession();
                     }
                  } else {
                     var19 = true;
                  }

                  if (var19) {
                     this.reGenerationBulletin(var6);
                  }
               }
            }
         }

         if (var1 && this.bulletinMois.getBulmenEtat() <= 2) {
            if (this.bulletinMois.getBulmenEtat() == 1) {
               this.bulletinMois.setBulmenEtat(2);
            }

            this.bulletinMois = this.bulletinMoisDao.majJournal(this.bulletinMois);
         }
      }

      this.var_affiche_bouton = false;
   }

   public void reGenerationBulletin(int var1) throws HibernateException, NamingException, ParseException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.setFlushMode(FlushMode.MANUAL);
         String var4 = "";
         if (this.modeRepartition == 0) {
            this.lesRubriques.clear();
            this.lesRubriques = this.feuilleCalculRubriqueDao.chargerRubriqueFeuilleActive(this.feuilleCalcul, this.exercicesPaye.getExepayId(), var2);
            this.verificationPrecalcul(var2);
         }

         if (this.lesRubriques.size() != 0 || this.modeRepartition != 0) {
            this.var_info = "Calcul du salarie : " + this.salaries.getSalNom();
            this.var_currentValue = 1;
            new ArrayList();
            List var5 = this.salariesContratsDao.listelesContratsActif(this.salaries, this.d1, this.d2, var2);
            if (var5.size() == 0) {
               this.bulletinSalaire = new BulletinSalaire();
               this.bulletinSalaire.setObservations("PAS DE CONTRAT POIR CETTE PERIODE");
               this.bulletinSalaire.setBulsalMatricule(this.salaries.getSalMatricule());
               this.bulletinSalaire.setSalaries(this.salaries);
               this.gestionListe();
            } else {
               for(int var6 = 0; var6 < var5.size(); ++var6) {
                  this.salariesContrats = (SalariesContrats)var5.get(var6);
                  if (this.usersLog.getUsrPaye() == 0 || this.usersLog.getUsrPaye() != 0 && this.salariesContrats.getSalaries().getSalProtege() == 0) {
                     if (this.salariesContrats.getSalconEtatH() != 1) {
                        this.bulletinSalaire.setObservations("CONTRAT NON VALIDE");
                        this.bulletinSalaire.setBulsalMatricule(this.salaries.getSalMatricule());
                        this.bulletinSalaire.setSalaries(this.salaries);
                        this.gestionListe();
                     } else {
                        boolean var7 = false;
                        if (this.modeRepartition == 0) {
                           if (this.salariesContrats.getSalconFeuille().equals(this.bulletinMois.getBulmenFeuille())) {
                              var7 = true;
                           }
                        } else if (this.modeRepartition == 1) {
                           if (this.salariesContrats.getSalconActivite().equals(this.bulletinMois.getBulmenFeuille())) {
                              var7 = true;
                           }
                        } else if (this.modeRepartition == 2) {
                           if (this.salariesContrats.getSalconService().equals(this.bulletinMois.getBulmenFeuille())) {
                              var7 = true;
                           }
                        } else if (this.modeRepartition == 3) {
                           if (this.salariesContrats.getSalconProjet().equals(this.bulletinMois.getBulmenFeuille())) {
                              var7 = true;
                           }
                        } else if (this.modeRepartition == 4 && this.salariesContrats.getSalconIdTiers() == Long.parseLong(this.bulletinMois.getBulmenFeuille())) {
                           var7 = true;
                        }

                        if (var7) {
                           if (this.verifBulletin(var2)) {
                              this.bulletinSalaire.setObservations("BULLETIN VERROUILLE");
                              this.bulletinSalaire.setBulsalMatricule(this.salaries.getSalMatricule());
                              this.bulletinSalaire.setSalaries(this.salaries);
                              this.gestionListe();
                           } else {
                              boolean var8 = false;

                              int var9;
                              for(var9 = 0; var9 < this.mesNatureAgentsItems.size(); ++var9) {
                                 if (((SelectItem)this.mesNatureAgentsItems.get(var9)).getValue().equals(this.salariesContrats.getSalconType())) {
                                    var8 = true;
                                    break;
                                 }
                              }

                              if (var8) {
                                 if (this.modeRepartition != 0 && (var4 == null || var4.isEmpty() || !var4.equals(this.salariesContrats.getSalconFeuille()))) {
                                    this.lesRubriques.clear();
                                    this.lesRubriques = this.feuilleCalculRubriqueDao.chargerRubriqueFeuilleActive(this.salariesContrats.getSalconFeuille(), this.exercicesPaye.getExepayId(), var2);
                                    this.verificationPrecalcul(var2);
                                 }

                                 var4 = this.salariesContrats.getSalconFeuille();
                                 this.lesVariables.clear();
                                 this.lesAbsences.clear();
                                 this.lesConges.clear();
                                 this.lesPretsLignes.clear();
                                 this.lesHistoriques.clear();
                                 this.montantSursalaire = 0.0D;
                                 this.nombreJourPresence = 0.0F;
                                 this.absenceSurConges = 0.0F;
                                 this.absenceSurReposMaladie = 0.0F;
                                 if (this.salariesContrats != null) {
                                    this.lesVariables = this.salariesVariablesDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), this.salariesContrats.getSalconNum(), var2);
                                 } else {
                                    this.lesVariables = this.salariesVariablesDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), "", var2);
                                 }

                                 if (this.lesVariables.size() != 0) {
                                    if (this.salariesContrats != null) {
                                       this.salariesElements = this.salariesElementsDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), this.salariesContrats.getSalconNum(), var2);
                                    } else {
                                       this.salariesElements = this.salariesElementsDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), "", var2);
                                    }

                                    if (this.salariesElements == null) {
                                       this.bulletinSalaire = new BulletinSalaire();
                                       this.bulletinSalaire.setObservations("PAS D`ELEMENTS SALARIES");
                                       this.bulletinSalaire.setBulsalMatricule(this.salaries.getSalMatricule());
                                       this.bulletinSalaire.setSalaries(this.salaries);
                                       this.gestionListe();
                                    } else if (this.salariesElements.getSaleleEtat() != 9 && (this.salariesContrats == null || this.salariesContrats != null && this.salariesContrats.getSalconEtat() != 9)) {
                                       this.verificationNBenfants(var2);
                                       if (this.capitalisationActive) {
                                          if (this.salariesContrats != null) {
                                             this.salariesCapitalisation = this.salariesCapitalisationDao.chargerleCapital(this.salaries, this.salariesContrats.getSalconNum(), var2);
                                          } else {
                                             this.salariesCapitalisation = this.salariesCapitalisationDao.chargerleCapital(this.salaries, "", var2);
                                          }
                                       } else {
                                          this.salariesCapitalisation = null;
                                       }

                                       if (this.salariesContrats != null) {
                                          this.lesHistoriques = this.salariesHistoriqueDao.chargerlesHistoriquesBySalaries(this.salaries, this.salariesContrats.getSalconNum(), this.exercicesPaye, var2);
                                          if (this.lesHistoriques.size() == 0) {
                                             this.lesHistoriques = this.salariesHistoriqueDao.chargerlesHistoriquesBySalaries(this.salaries, "", this.exercicesPaye, var2);
                                          }
                                       } else {
                                          this.lesHistoriques = this.salariesHistoriqueDao.chargerlesHistoriquesBySalaries(this.salaries, "", this.exercicesPaye, var2);
                                       }

                                       if (this.salariesContrats != null) {
                                          this.lesConges = this.salariesCongesDao.chargerlesCongesValide(this.salaries, this.salariesContrats.getSalconNum(), var2);
                                       } else {
                                          this.lesConges = this.salariesCongesDao.chargerlesCongesValide(this.salaries, "", var2);
                                       }

                                       if (!this.verifConges()) {
                                          this.lesBulletinsLigne.clear();
                                          this.bulletinSalaire = new BulletinSalaire();
                                          this.bulletinSalaire.setBulsalActivite(this.salariesElements.getSaleleActivite());
                                          this.bulletinSalaire.setBulsalBudget(this.salariesElements.getSaleleBudget());
                                          this.bulletinSalaire.setBulsalCentresImpots(this.salariesElements.getSaleleCentresImpots());
                                          this.bulletinSalaire.setBulsalCentresSecurite(this.salariesElements.getSaleleCentresSecurite());
                                          this.bulletinSalaire.setBulsalCivilite(this.salariesElements.getSaleleCivilite());
                                          this.bulletinSalaire.setBulsalClassement(this.salariesElements.getSaleleClassement());
                                          this.bulletinSalaire.setBulsalConvention(this.salariesElements.getSaleleConvention());
                                          this.bulletinSalaire.setBulsalContrat(this.salariesContrats.getSalconNum());
                                          this.bulletinSalaire.setBulsalEssai(this.salariesContrats.getSalconEssai());
                                          this.bulletinSalaire.setBulsalProjet(this.salariesContrats.getSalconProjet());
                                          this.d1 = this.utilDate.datePremierJourMois(this.dateGeneration);
                                          this.d2 = this.utilDate.dateDernierJourMois(this.dateGeneration);
                                          if (this.feuilleCalcul.getFeuDecale() != 0) {
                                             var9 = this.feuilleCalcul.getFeuDecale() * -1;
                                             Date var10 = this.utilDate.datePremierJourMois(this.dateGeneration);
                                             this.d1Reel = this.utilDate.datedevaleurTheo(var10, var9);
                                             this.bulletinSalaire.setBulsalDateDebutReel(this.d1Reel);
                                             Date var11 = this.utilDate.dateDernierJourMois(this.dateGeneration);
                                             this.d2Reel = this.utilDate.datedevaleurTheo(var11, var9);
                                             this.bulletinSalaire.setBulsalDateFinReel(this.d2Reel);
                                          } else {
                                             this.bulletinSalaire.setBulsalDateDebutReel(this.d1);
                                             this.bulletinSalaire.setBulsalDateFinReel(this.d2);
                                          }

                                          this.bulletinSalaire.setBulsalDateDebut(this.d1);
                                          this.bulletinSalaire.setBulsalDateFin(this.d2);
                                          this.bulletinSalaire.setBulsalDateentree(this.salariesContrats.getSalconDateDebut());
                                          this.bulletinSalaire.setBulsalDateSortie(this.salariesContrats.getSalconDateFin());
                                          this.bulletinSalaire.setBulsalDepartement(this.salariesElements.getSaleleDepartement());
                                          this.bulletinSalaire.setBulsalEtat(this.salariesElements.getSaleleEtat());
                                          this.bulletinSalaire.setBulsalFeuille(this.salariesElements.getSaleleFeuille());
                                          this.bulletinSalaire.setBulsalFonction(this.salariesElements.getSaleleFonction());
                                          this.bulletinSalaire.setBulsalSecu1(this.salaries.getSalNumSecu());
                                          if (!this.structureLog.getStrcodepays().equals("0029") && !this.structureLog.getStrcodepays().equals("0041") && !this.structureLog.getStrcodepays().equals("0050") && !this.structureLog.getStrcodepays().equals("0056")) {
                                             if (this.structureLog.getStrcodepays().equals("0077")) {
                                                this.bulletinSalaire.setBulsalSecu2(this.salaries.getSalNumCnamgs());
                                             } else if (!this.structureLog.getStrcodepays().equals("0078") && !this.structureLog.getStrcodepays().equals("0088") && !this.structureLog.getStrcodepays().equals("0089") && !this.structureLog.getStrcodepays().equals("0090")) {
                                                if (this.structureLog.getStrcodepays().equals("0138")) {
                                                   this.bulletinSalaire.setBulsalSecu2(this.salaries.getSalNumAmo());
                                                } else {
                                                   this.bulletinSalaire.setBulsalSecu2("");
                                                }
                                             }
                                          }

                                          this.bulletinSalaire.setBulsalGenre(this.salariesElements.getSaleleGenre());
                                          this.bulletinSalaire.setBulsalGrille(this.salariesElements.getSaleleGrille());
                                          this.bulletinSalaire.setBulsalLibCentresImpots(this.salariesElements.getSaleleLibCentresImpots());
                                          this.bulletinSalaire.setBulsalLibCentresSecurite(this.salariesElements.getSaleleLibCentresSecurite());
                                          this.bulletinSalaire.setBulsalLibClassement(this.salariesElements.getSaleleLibClassement());
                                          this.bulletinSalaire.setBulsalLibConvention(this.salariesElements.getSaleleLibConvention());
                                          this.bulletinSalaire.setBulsalLibGrille(this.salariesElements.getSaleleLibGrille());
                                          this.bulletinSalaire.setBulsalLibNivEmploi(this.salariesElements.getSaleleLibNivEmploi());
                                          this.bulletinSalaire.setBulsalLocalisation(this.salariesElements.getSaleleLocalisation());
                                          this.bulletinSalaire.setBulsalMatricule(this.salariesElements.getSaleleMatricule());
                                          this.bulletinSalaire.setBulsalMotifSortie(this.salariesElements.getSaleleMotifSortie());
                                          this.bulletinSalaire.setBulsalNature(this.salariesElements.getSaleleNature());
                                          this.bulletinSalaire.setBulsalNbEnfant(this.salariesElements.getSaleleNbEnfant());
                                          this.bulletinSalaire.setBulsalNbFemme(this.salariesElements.getSaleleNbFemme());
                                          this.bulletinSalaire.setBulsalNbJourCp(this.salariesElements.getSaleleNbJourCp());
                                          this.bulletinSalaire.setBulsalNbJourTr(this.salariesElements.getSaleleNbJourTr());
                                          this.bulletinSalaire.setBulsalNbPartFiscal(this.salariesElements.getSaleleNbPartFiscal());
                                          this.bulletinSalaire.setBulsalNbPartTrimf(this.salariesElements.getSaleleNbPartTrimf());
                                          this.bulletinSalaire.setBulsalNivEmploi(this.salariesElements.getSaleleNivEmploi());
                                          this.bulletinSalaire.setBulsalParc(this.salariesElements.getSaleleParc());
                                          this.bulletinSalaire.setBulsalPeriode(this.bulletinMois.getBulmenPeriode());
                                          this.bulletinSalaire.setBulsalService(this.salariesElements.getSaleleService());
                                          this.bulletinSalaire.setBulsalLibService(this.salariesElements.getSaleleLibService());
                                          this.bulletinSalaire.setBulsalSitFamille(this.salariesElements.getSaleleSitFamille());
                                          this.bulletinSalaire.setBulsalSite(this.salariesElements.getSaleleSite());
                                          this.bulletinSalaire.setBulsalCle1Anal(this.salariesElements.getSaleleCle1Anal());
                                          this.bulletinSalaire.setBulsalCle2Anal(this.salariesElements.getSaleleCle2Anal());
                                          this.bulletinSalaire.setBulsalModeReglement(this.salariesElements.getSaleleModeReglement());
                                          this.bulletinSalaire.setBulsalNumBanque(this.salariesElements.getSaleleNumBanque());
                                          this.bulletinSalaire.setBulsalGuichetBanque(this.salariesElements.getSaleleGuichetBanque());
                                          this.bulletinSalaire.setBulsalCompteBanque(this.salariesElements.getSaleleCompteBanque());
                                          this.bulletinSalaire.setBulsalCleBanque(this.salariesElements.getSaleleCleBanque());
                                          this.bulletinSalaire.setBulsalIban(this.salariesElements.getSaleleIban());
                                          this.bulletinSalaire.setBulsalSwift(this.salariesElements.getSaleleSwift());
                                          this.bulletinSalaire.setBulsalCompteMembre(this.salariesElements.getSaleleCompteMembre());
                                          this.bulletinSalaire.setExercicesPaye(this.exercicesPaye);
                                          this.bulletinSalaire.setSalaries(this.salaries);
                                          this.bulletinSalaire.setBulsalUserCreat(this.usersLog.getUsrid());
                                          this.bulletinSalaire = this.bulletinSalaireDao.insert(this.bulletinSalaire, var2);
                                          if (this.salariesContrats != null) {
                                             this.lesAbsences = this.salariesCongesDao.chargerlesAbsencesValidePeriode(this.salaries, this.salariesContrats.getSalconNum(), this.d1, this.d2, var2);
                                          } else {
                                             this.lesAbsences = this.salariesCongesDao.chargerlesAbsencesValidePeriode(this.salaries, "", this.d1, this.d2, var2);
                                          }

                                          this.verificationNetAAtteindre();
                                          if (this.netAAtteindre != 0.0D) {
                                             boolean var25 = true;
                                             double var26 = 0.0D;
                                             double var12 = 0.0D;
                                             double var14 = 0.0D;

                                             for(int var16 = 0; var16 < 100; ++var16) {
                                                this.generationBulletin(var2);
                                                var14 = 0.0D;

                                                int var17;
                                                for(var17 = 0; var17 < this.lesBulletinsLigne.size(); ++var17) {
                                                   if (((BulletinLigne)this.lesBulletinsLigne.get(var17)).getBulligRubrique().equals("100030")) {
                                                      var12 = ((BulletinLigne)this.lesBulletinsLigne.get(var17)).getBulligValColE();
                                                   }

                                                   if (((BulletinLigne)this.lesBulletinsLigne.get(var17)).getBulligNature() == 80) {
                                                      var14 += ((BulletinLigne)this.lesBulletinsLigne.get(var17)).getBulligValColE() * -1.0D;
                                                   }

                                                   if (((BulletinLigne)this.lesBulletinsLigne.get(var17)).getBulligRubrique().equals("699999")) {
                                                      double var18 = ((BulletinLigne)this.lesBulletinsLigne.get(var17)).getBulligValColE() + var14;
                                                      if (var18 != this.netAAtteindre && var16 != 99) {
                                                         this.montantSursalaire += this.netAAtteindre - var18;
                                                         var25 = true;
                                                         break;
                                                      }

                                                      var25 = false;
                                                      break;
                                                   }
                                                }

                                                if (!var25) {
                                                   if (this.lesBulletinsLigne.size() != 0) {
                                                      for(var17 = 0; var17 < this.lesBulletinsLigne.size(); ++var17) {
                                                         this.bulletinLigne = (BulletinLigne)this.lesBulletinsLigne.get(var17);
                                                         if (this.bulletinLigne.getBulligValColE() != 0.0D) {
                                                            this.bulletinLigne.setBulletinSalaire(this.bulletinSalaire);
                                                            this.bulletinLigne.setExercicesPaye(this.exercicesPaye);
                                                            this.bulletinLigne.setSalaries(this.salaries);
                                                            this.bulletinLigne = this.bulletinLigneDao.insert(this.bulletinLigne, var2);
                                                         }
                                                      }

                                                      this.calculEnteteBulletin(var2);
                                                      this.bulletinSalaire = this.bulletinSalaireDao.pourParapheur(this.bulletinSalaire.getBulsalId(), var2);
                                                      if (this.bulletinSalaire != null) {
                                                         this.bulletinSalaire.setBulsalUserModif(this.usersLog.getUsrid());
                                                         this.bulletinSalaire = this.bulletinSalaireDao.modif(this.bulletinSalaire, var2);
                                                      }
                                                   }
                                                   break;
                                                }

                                                this.lesBulletinsLigne.clear();
                                             }
                                          } else {
                                             this.generationBulletin(var2);
                                          }

                                          var2.flush();
                                          this.gestionListe();
                                       } else {
                                          this.bulletinSalaire = new BulletinSalaire();
                                          this.bulletinSalaire.setObservations("LE SALARIE EST EN CONGES");
                                          this.bulletinSalaire.setBulsalMatricule(this.salaries.getSalMatricule());
                                          this.bulletinSalaire.setSalaries(this.salaries);
                                          this.gestionListe();
                                       }
                                    } else {
                                       this.bulletinSalaire = new BulletinSalaire();
                                       this.bulletinSalaire.setObservations("LE SALARIE EST GELE");
                                       this.bulletinSalaire.setBulsalMatricule(this.salaries.getSalMatricule());
                                       this.bulletinSalaire.setSalaries(this.salaries);
                                       this.bulletinSalaire.setBulsalEtat(9);
                                       this.gestionListe();
                                    }
                                 } else {
                                    this.bulletinSalaire = new BulletinSalaire();
                                    this.bulletinSalaire.setObservations("PAS DE VARIABLES SALARIES");
                                    this.bulletinSalaire.setBulsalMatricule(this.salaries.getSalMatricule());
                                    this.bulletinSalaire.setSalaries(this.salaries);
                                    this.gestionListe();
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         this.dataModelLesBulletins.setWrappedData(this.lesBulletins);
         var3.commit();
      } catch (HibernateException var23) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var23;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_affiche_bouton = false;
   }

   public void gestionListe() {
      if (this.lesBulletins.size() != 0) {
         new BulletinSalaire();
         boolean var2 = false;

         for(int var3 = 0; var3 < this.lesBulletins.size(); ++var3) {
            BulletinSalaire var1 = (BulletinSalaire)this.lesBulletins.get(var3);
            if (var1.getBulsalMatricule().equals(this.bulletinSalaire.getBulsalMatricule()) && var1.getBulsalContrat().equals(this.bulletinSalaire.getBulsalContrat())) {
               var2 = true;
               this.lesBulletins.remove(var3);
               this.lesBulletins.add(var3, this.bulletinSalaire);
            }
         }

         if (!var2) {
            this.lesBulletins.add(this.bulletinSalaire);
         }
      } else {
         this.lesBulletins.add(this.bulletinSalaire);
      }

   }

   public void verificationNBenfants(Session var1) throws HibernateException, NamingException {
      if (this.optionPaye.getNbEnfantsFiscaux().equals("0")) {
         this.lesSalariesGrh = this.salariesGrhDao.chargerlesElementRhFamille(this.salaries, var1);
         int var2 = this.formBakingBeanPaye.calculNbEnfants(this.salaries, this.lesSalariesGrh);
         if (var2 != this.salariesElements.getSaleleNbEnfant()) {
            this.salariesElements.setSaleleNbEnfant(var2);
            float var3 = this.formBakingBeanPaye.calculNbPartsFiscales(this.salaries, this.lesSalariesGrh);
            this.salariesElements.setSaleleNbPartFiscal(var3);
            this.salariesElements = this.salariesElementsDao.modif(this.salariesElements, var1);
         }
      }

   }

   public void generationBulletin(Session var1) throws HibernateException, NamingException, ParseException {
      if (this.d1 != null && this.d2 != null) {
         this.calculBulletin(var1);
         this.calculEnteteBulletin(var1);
         if (this.montantAtteindre == 0.0D) {
            this.bulletinSalaire.setBulsalUserModif(this.usersLog.getUsrid());
            this.bulletinSalaire = this.bulletinSalaireDao.modif(this.bulletinSalaire, var1);
            if (this.lesBulletinsLigne.size() != 0) {
               for(int var2 = 0; var2 < this.lesBulletinsLigne.size(); ++var2) {
                  if (((BulletinLigne)this.lesBulletinsLigne.get(var2)).getBulligIdPretligne() != 0L) {
                     this.bulletinLigne = (BulletinLigne)this.lesBulletinsLigne.get(var2);
                     new ArrayList();
                     List var3 = this.salariesPretsLignesDao.chargerlesPretsLignes(this.bulletinLigne.getBulligNumPret(), this.bulletinLigne.getSalaries(), var1);
                     if (var3.size() != 0) {
                        double var4 = 0.0D;
                        double var6 = 0.0D;

                        for(int var8 = 0; var8 < var3.size(); ++var8) {
                           var4 += ((SalariesPretsLignes)var3.get(var8)).getSalpreligMontantTheo();
                           var6 += ((SalariesPretsLignes)var3.get(var8)).getSalpreligMontantReel();
                        }

                        this.salariesPrets = this.salariesPretsDao.pourParapheur(this.bulletinLigne.getBulligNumPret(), this.bulletinLigne.getSalaries(), var1);
                        if (this.salariesPrets != null) {
                           this.salariesPrets.setSalpreRmb(var6);
                           this.salariesPrets = this.salariesPretsDao.modif(this.salariesPrets, var1);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public boolean verifBulletin(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (this.salariesContrats != null) {
         this.bulletinSalaire = this.bulletinSalaireDao.rechercheBulletinSalariePeriode(this.salaries.getSalMatricule(), this.salariesContrats.getSalconNum(), this.bulletinMois.getBulmenPeriode(), var1);
      } else {
         this.bulletinSalaire = this.bulletinSalaireDao.rechercheBulletinSalariePeriode(this.salaries.getSalMatricule(), this.bulletinMois.getBulmenPeriode(), var1);
      }

      if (this.bulletinSalaire != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public BulletinSalaire calculEnteteBulletin(Session var1) throws HibernateException, NamingException, ParseException {
      float var2 = 0.0F;
      float var3 = 0.0F;
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      double var10 = 0.0D;
      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = 0.0D;
      double var18 = 0.0D;
      double var20 = 0.0D;
      double var22 = 0.0D;
      double var24 = 0.0D;
      double var26 = 0.0D;
      double var28 = 0.0D;
      float var30 = 0.0F;
      float var31 = 0.0F;
      float var32 = 0.0F;
      float var33 = 0.0F;
      float var34 = 0.0F;
      float var35 = 0.0F;
      float var36 = 0.0F;
      double var37 = 0.0D;
      double var39 = 0.0D;
      int var41;
      if (this.lesHistoriques.size() != 0) {
         for(var41 = 0; var41 < this.lesHistoriques.size(); ++var41) {
            if (((SalariesHistorique)this.lesHistoriques.get(var41)).getSalhisCode().equals("BRUT")) {
               var8 += ((SalariesHistorique)this.lesHistoriques.get(var41)).getSalhisValeurColE();
            } else if (((SalariesHistorique)this.lesHistoriques.get(var41)).getSalhisCode().startsWith("CP")) {
               var10 += ((SalariesHistorique)this.lesHistoriques.get(var41)).getSalhisValeurColE();
            } else if (((SalariesHistorique)this.lesHistoriques.get(var41)).getSalhisCode().startsWith("NBJS")) {
               var30 += (float)((SalariesHistorique)this.lesHistoriques.get(var41)).getSalhisValeurColE();
            }
         }
      }

      if (this.lesConges.size() != 0) {
         for(var41 = 0; var41 < this.lesConges.size(); ++var41) {
            if (((SalariesConges)this.lesConges.get(var41)).getSalcngType() == 1 && ((SalariesConges)this.lesConges.get(var41)).getSalcngEtat() == 1 && ((SalariesConges)this.lesConges.get(var41)).getSalcngNature() == 8) {
               var31 += ((SalariesConges)this.lesConges.get(var41)).getSalcngDuree();
            }
         }
      }

      new ArrayList();
      List var49 = this.bulletinLigneDao.chargerlesBulletinsbySalarieExercice(this.salaries, this.exercicesPaye, var1);
      if (var49.size() != 0) {
         new BulletinLigne();

         for(int var43 = 0; var43 < var49.size(); ++var43) {
            BulletinLigne var42 = (BulletinLigne)var49.get(var43);
            Date var44 = var42.getBulletinSalaire().getBulsalDateDebut();
            if (var42.getBulletinSalaire().getBulsalDateDebut().compareTo(this.dateGeneration) <= 0) {
               if (var42.getBulligNature() == 50) {
                  var6 += var42.getBulligValColE();
                  if (var42.getBulletinSalaire().getBulsalId() == this.bulletinSalaire.getBulsalId()) {
                     var4 += var42.getBulligValColE();
                  }
               } else if (var42.getBulligNature() == 59) {
                  if (var42.getBulletinSalaire().getBulsalId() == this.bulletinSalaire.getBulsalId()) {
                     var39 = var42.getBulligValColE();
                  }
               } else if (var42.getBulligNature() == 10) {
                  double var45;
                  double var47;
                  if (var42.getBulletinSalaire().getBulsalId() == this.bulletinSalaire.getBulsalId()) {
                     if (var42.getBulligRubrique().startsWith("100000")) {
                        var2 = (float)var42.getBulligValColD();
                     } else if (var42.getBulligRubrique().startsWith("100010")) {
                        if (var42.getBulligValColA() == 0.0D) {
                           var42.setBulligValColA(this.M000158());
                        }

                        var45 = var42.getBulligValColA() - var42.getBulligValColD();
                        var47 = this.utilNombre.myRound(var45 / 8.0D, 2);
                        var2 = (float)((double)this.nbJourRef - var47);
                     } else if (var42.getBulligRubrique().startsWith("100050")) {
                        var2 = (float)((double)var2 - var42.getBulligValColD());
                     }
                  }

                  if (var42.getBulligRubrique().startsWith("100000")) {
                     var3 = (float)((double)var3 + var42.getBulligValColD());
                  } else if (var42.getBulligRubrique().startsWith("100010")) {
                     if (var42.getBulligValColA() == 0.0D) {
                        var42.setBulligValColA(this.M000158());
                     }

                     var45 = var42.getBulligValColA() - var42.getBulligValColD();
                     var47 = this.utilNombre.myRound(var45 / 8.0D, 2);
                     var3 = (float)((double)var3 + ((double)this.nbJourRef - var47));
                  } else if (var42.getBulligRubrique().startsWith("100050")) {
                     var3 = (float)((double)var3 - var42.getBulligValColD());
                  }
               } else if (var42.getBulligNature() == 40) {
                  if (var42.getBulletinSalaire().getBulsalId() == this.bulletinSalaire.getBulsalId()) {
                     var10 += var42.getBulligValColE();
                     if (var42.getBulligRubrique().startsWith("208000")) {
                        var35 = (float)var42.getBulligValColD();
                     }
                  }

                  if (var42.getBulligRubrique().startsWith("208000")) {
                     var33 = (float)((double)var33 + var42.getBulligValColD());
                  }
               } else if (var42.getBulligNature() == 89) {
                  if (var42.getBulletinSalaire().getBulsalId() == this.bulletinSalaire.getBulsalId()) {
                     var37 += var42.getBulligValColE();
                  }
               } else if (!this.structureLog.getStrcodepays().equals("0029") && !this.structureLog.getStrcodepays().equals("0041")) {
                  if (this.structureLog.getStrcodepays().equals("0050")) {
                     if (var42.getBulligRubrique().startsWith("300000")) {
                        var12 += var42.getBulligValColE();
                     } else if (var42.getBulligRubrique().startsWith("300200")) {
                        var14 += var42.getBulligValColE();
                     } else if (var42.getBulligRubrique().startsWith("300400")) {
                        var16 += var42.getBulligValColE();
                     } else {
                        var18 = 0.0D;
                        var20 = 0.0D;
                        var22 = 0.0D;
                        var24 = 0.0D;
                        var26 = 0.0D;
                        var28 = 0.0D;
                     }
                  } else if (!this.structureLog.getStrcodepays().equals("0056")) {
                     if (this.structureLog.getStrcodepays().equals("0077")) {
                        if (var42.getBulligRubrique().startsWith("300000")) {
                           var12 += var42.getBulligValColE();
                        } else if (var42.getBulligRubrique().startsWith("300020")) {
                           var14 += var42.getBulligValColE();
                        } else if (var42.getBulligRubrique().startsWith("300100")) {
                           var16 += var42.getBulligValColE();
                        } else if (var42.getBulligRubrique().startsWith("300200")) {
                           var18 += var42.getBulligValColE();
                        } else {
                           var20 = 0.0D;
                           var22 = 0.0D;
                           var24 = 0.0D;
                           var26 = 0.0D;
                           var28 = 0.0D;
                        }
                     } else if (!this.structureLog.getStrcodepays().equals("0078") && !this.structureLog.getStrcodepays().equals("0088") && !this.structureLog.getStrcodepays().equals("0089") && !this.structureLog.getStrcodepays().equals("0090")) {
                        if (this.structureLog.getStrcodepays().equals("0138")) {
                           if (var42.getBulligRubrique().startsWith("300010")) {
                              var12 += var42.getBulligValColE();
                           } else if (!var42.getBulligRubrique().startsWith("300020") && !var42.getBulligRubrique().startsWith("300021") && !var42.getBulligRubrique().startsWith("300022") && !var42.getBulligRubrique().startsWith("300023") && !var42.getBulligRubrique().startsWith("300024") && !var42.getBulligRubrique().startsWith("300025") && !var42.getBulligRubrique().startsWith("300026") && !var42.getBulligRubrique().startsWith("300027") && !var42.getBulligRubrique().startsWith("300028") && !var42.getBulligRubrique().startsWith("300029")) {
                              if (var42.getBulligRubrique().startsWith("300220")) {
                                 var16 += var42.getBulligValColE();
                              } else if (var42.getBulligRubrique().startsWith("900020")) {
                                 var18 += var42.getBulligValColE();
                              } else if (!var42.getBulligRubrique().startsWith("900040") && !var42.getBulligRubrique().startsWith("900041") && !var42.getBulligRubrique().startsWith("900042") && !var42.getBulligRubrique().startsWith("900043") && !var42.getBulligRubrique().startsWith("900044") && !var42.getBulligRubrique().startsWith("900045") && !var42.getBulligRubrique().startsWith("900046") && !var42.getBulligRubrique().startsWith("900047") && !var42.getBulligRubrique().startsWith("900048") && !var42.getBulligRubrique().startsWith("900049")) {
                                 var22 = 0.0D;
                                 var24 = 0.0D;
                                 var26 = 0.0D;
                                 var28 = 0.0D;
                              } else {
                                 var20 += var42.getBulligValColE();
                              }
                           } else {
                              var14 += var42.getBulligValColE();
                           }
                        } else if (!this.structureLog.getStrcodepays().equals("0142")) {
                           if (this.structureLog.getStrcodepays().equals("0202")) {
                              if (!var42.getBulligRubrique().startsWith("300000") && !var42.getBulligRubrique().startsWith("300010") && !var42.getBulligRubrique().startsWith("300020")) {
                                 if (var42.getBulligRubrique().startsWith("300100")) {
                                    var14 += var42.getBulligValColE();
                                 } else if (!var42.getBulligRubrique().startsWith("300200") && !var42.getBulligRubrique().startsWith("300220")) {
                                    if (var42.getBulligRubrique().startsWith("300300")) {
                                       var18 += var42.getBulligValColE();
                                    } else {
                                       var20 = 0.0D;
                                       var22 = 0.0D;
                                       var24 = 0.0D;
                                       var26 = 0.0D;
                                       var28 = 0.0D;
                                    }
                                 } else {
                                    var16 += var42.getBulligValColE();
                                 }
                              } else {
                                 var12 += var42.getBulligValColE();
                              }
                           } else if (!this.structureLog.getStrcodepays().equals("0222")) {
                              var12 = 0.0D;
                              var14 = 0.0D;
                              var16 = 0.0D;
                              var18 = 0.0D;
                              var20 = 0.0D;
                              var22 = 0.0D;
                              var24 = 0.0D;
                              var26 = 0.0D;
                              var28 = 0.0D;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      this.bulletinSalaire.setBulsalAvNat(var4);
      if (this.montantAtteindre == 0.0D) {
         this.bulletinSalaire.setBulsalBaseImposableFiscale(this.calculBaseImposasableFiscaleEnCours(var1));
         this.bulletinSalaire.setBulsalBaseImposableSociale(this.calculBaseImposasableSocialeEnCours(var1));
      } else {
         this.bulletinSalaire.setBulsalBaseImposableFiscale(0.0D);
         this.bulletinSalaire.setBulsalBaseImposableSociale(0.0D);
      }

      this.bulletinSalaire.setBulsalImpot1(var12);
      this.bulletinSalaire.setBulsalImpot2(var14);
      this.bulletinSalaire.setBulsalImpot3(var16);
      this.bulletinSalaire.setBulsalImpot4(var18);
      this.bulletinSalaire.setBulsalImpot5(var20);
      this.bulletinSalaire.setBulsalImpot6(var22);
      this.bulletinSalaire.setBulsalImpot7(var24);
      this.bulletinSalaire.setBulsalImpot8(var26);
      this.bulletinSalaire.setBulsalImpot9(var28);
      this.bulletinSalaire.setBulsalImpot10(var6);
      this.bulletinSalaire.setBulsalTypeCP(this.type_conges);
      this.bulletinSalaire.setBulsalCP(var10);
      this.salariesElements.setSaleleNbJourTr(this.salariesElements.getSaleleNbJourTr());
      this.salariesElements.setSaleleNbJourCp(this.salariesElements.getSaleleNbJourCp());
      float var50;
      if (var2 != 0.0F) {
         if (this.salariesElements.getSaleleNbJourTr() != 0.0F) {
            var50 = this.salariesElements.getSaleleNbJourTr() / (float)this.nbJourRef;
            this.bulletinSalaire.setBulsalNbCpAcquis(this.salariesElements.getSaleleNbJourCp() / (this.salariesElements.getSaleleNbJourTr() / var50) * var2);
         } else {
            this.bulletinSalaire.setBulsalNbCpAcquis(this.salariesElements.getSaleleNbJourCp());
         }
      } else {
         this.bulletinSalaire.setBulsalNbCpAcquis(0.0F);
      }

      if (var10 != 0.0D) {
         this.bulletinSalaire.setBulsalNbCpPris(var35);
         if (this.bulletinSalaire.getBulsalTypeCP() != 4 && this.bulletinSalaire.getBulsalTypeCP() != 6) {
            this.bulletinSalaire.setBulsalNbDispo(this.bulletinSalaire.getBulsalNbDispo() - this.bulletinSalaire.getBulsalNbCpPris());
            if (this.bulletinSalaire.getBulsalNbDispo() <= 0.0F) {
               this.bulletinSalaire.setBulsalNbDispo(0.0F);
            }

            this.bulletinSalaire.setBulsalBrut(this.bulletinSalaire.getBulsalBrut() - var39);
            if (this.bulletinSalaire.getBulsalBrut() <= 0.0D) {
               this.bulletinSalaire.setBulsalBrut(0.0D);
            }
         } else {
            this.bulletinSalaire.setBulsalBrut(0.0D);
            this.bulletinSalaire.setBulsalNbDispo(0.0F);
         }
      } else {
         this.bulletinSalaire.setBulsalNbCpPris(0.0F);
         this.bulletinSalaire.setBulsalBrut(this.base_conges);
      }

      if (this.absenceSurConges != 0.0F) {
         this.bulletinSalaire.setBulsalNbCpPris(this.bulletinSalaire.getBulsalNbCpPris() + this.absenceSurConges);
      }

      if (this.salariesElements.getSaleleNbJourTr() != 0.0F) {
         var50 = this.salariesElements.getSaleleNbJourTr() / (float)this.nbJourRef;
         var32 = this.salariesElements.getSaleleNbJourCp() / (this.salariesElements.getSaleleNbJourTr() / var50) * var3;
      } else {
         var32 = 0.0F;
      }

      var36 = var30 + var32 + var31 - var33;
      if (var36 < 0.0F) {
         var36 = 0.0F;
      }

      this.bulletinSalaire.setBulsalNbDispo(var36);
      this.bulletinSalaire.setBulsalNetPayer(var37);
      this.bulletinSalaire.setBulsalBaseReference(0.0D);
      this.bulletinSalaire.setBulsalNature(this.salariesElements.getSaleleNature());
      this.bulletinSalaire.setBulsalEtat(this.salariesElements.getSaleleEtat());
      this.bulletinSalaire.setBulsalCivilite(this.salariesElements.getSaleleCivilite());
      this.bulletinSalaire.setBulsalFonction(this.salariesElements.getSaleleFonction());
      this.bulletinSalaire.setBulsalSecu1(this.salaries.getSalNumSecu());
      if (!this.structureLog.getStrcodepays().equals("0029") && !this.structureLog.getStrcodepays().equals("0041") && !this.structureLog.getStrcodepays().equals("0050") && !this.structureLog.getStrcodepays().equals("0056")) {
         if (this.structureLog.getStrcodepays().equals("0077")) {
            this.bulletinSalaire.setBulsalSecu2(this.salaries.getSalNumCnamgs());
         } else if (!this.structureLog.getStrcodepays().equals("0078") && !this.structureLog.getStrcodepays().equals("0088") && !this.structureLog.getStrcodepays().equals("0089") && !this.structureLog.getStrcodepays().equals("0090")) {
            if (this.structureLog.getStrcodepays().equals("0138")) {
               this.bulletinSalaire.setBulsalSecu2(this.salaries.getSalNumAmo());
            } else {
               this.bulletinSalaire.setBulsalSecu2("");
            }
         }
      }

      this.bulletinSalaire.setBulsalSite(this.salariesElements.getSaleleSite());
      this.bulletinSalaire.setBulsalDepartement(this.salariesElements.getSaleleDepartement());
      this.bulletinSalaire.setBulsalService(this.salariesElements.getSaleleService());
      this.bulletinSalaire.setBulsalLibService(this.salariesElements.getSaleleLibService());
      this.bulletinSalaire.setBulsalActivite(this.salariesElements.getSaleleActivite());
      this.bulletinSalaire.setBulsalBudget(this.salariesElements.getSaleleBudget());
      this.bulletinSalaire.setBulsalParc(this.salariesElements.getSaleleParc());
      this.bulletinSalaire.setBulsalGenre(this.salariesElements.getSaleleGenre());
      this.bulletinSalaire.setBulsalSitFamille(this.salariesElements.getSaleleSitFamille());
      this.bulletinSalaire.setBulsalNbEnfant(this.salariesElements.getSaleleNbEnfant());
      this.bulletinSalaire.setBulsalNbPartFiscal(this.salariesElements.getSaleleNbPartFiscal());
      this.bulletinSalaire.setBulsalNbFemme(this.salariesElements.getSaleleNbFemme());
      this.bulletinSalaire.setBulsalNbPartTrimf(this.salariesElements.getSaleleNbPartTrimf());
      this.bulletinSalaire.setBulsalMotifSortie(this.salariesElements.getSaleleMotifSortie());
      this.bulletinSalaire.setBulsalConvention(this.salariesElements.getSaleleConvention());
      this.bulletinSalaire.setBulsalLibConvention(this.salariesElements.getSaleleLibConvention());
      this.bulletinSalaire.setBulsalCentresImpots(this.salariesElements.getSaleleCentresImpots());
      this.bulletinSalaire.setBulsalLibCentresImpots(this.salariesElements.getSaleleLibCentresImpots());
      this.bulletinSalaire.setBulsalCentresSecurite(this.salariesElements.getSaleleCentresSecurite());
      this.bulletinSalaire.setBulsalLibCentresSecurite(this.salariesElements.getSaleleLibCentresSecurite());
      this.bulletinSalaire.setBulsalClassement(this.salariesElements.getSaleleClassement());
      this.bulletinSalaire.setBulsalLibClassement(this.salariesElements.getSaleleLibClassement());
      this.bulletinSalaire.setBulsalNivEmploi(this.salariesElements.getSaleleNivEmploi());
      this.bulletinSalaire.setBulsalLibNivEmploi(this.salariesElements.getSaleleLibNivEmploi());
      this.bulletinSalaire.setBulsalLocalisation(this.salariesElements.getSaleleLocalisation());
      this.bulletinSalaire.setBulsalGrille(this.salariesElements.getSaleleGrille());
      this.bulletinSalaire.setBulsalCle1Anal(this.salariesElements.getSaleleCle1Anal());
      this.bulletinSalaire.setBulsalCle2Anal(this.salariesElements.getSaleleCle2Anal());
      this.bulletinSalaire.setBulsalModeReglement(this.salariesElements.getSaleleModeReglement());
      this.bulletinSalaire.setBulsalNumBanque(this.salariesElements.getSaleleNumBanque());
      this.bulletinSalaire.setBulsalGuichetBanque(this.salariesElements.getSaleleGuichetBanque());
      this.bulletinSalaire.setBulsalCompteBanque(this.salariesElements.getSaleleCompteBanque());
      this.bulletinSalaire.setBulsalCleBanque(this.salariesElements.getSaleleCleBanque());
      this.bulletinSalaire.setBulsalIban(this.salariesElements.getSaleleIban());
      this.bulletinSalaire.setBulsalSwift(this.salariesElements.getSaleleSwift());
      this.bulletinSalaire.setBulsalCompteMembre(this.salariesElements.getSaleleCompteMembre());
      if (this.salariesContrats != null) {
         this.bulletinSalaire.setBulsalIdTiers(this.salariesContrats.getSalconIdTiers());
      }

      return this.bulletinSalaire;
   }

   public void calculBulletin(Session var1) throws HibernateException, NamingException, ParseException {
      if (this.bulletinSalaire != null) {
         this.majLigne = true;

         for(int var2 = 0; var2 < this.lesRubriques.size(); ++var2) {
            this.ligneEnCours = var2;
            this.calculRubrique = (FeuilleCalculRubrique)this.lesRubriques.get(var2);
            this.preCalcul = false;
            this.calculBulletinLigne(var1);
         }
      }

   }

   public void calculBulletinLigne(Session var1) throws HibernateException, NamingException, ParseException {
      if (this.calculRubrique != null) {
         this.bulletinLigne = new BulletinLigne();
         this.bulletinLigne.setExercicesPaye(this.exercicesPaye);
         this.bulletinLigne.setSalaries(this.salaries);
         this.bulletinLigne.setBulletinSalaire(this.bulletinSalaire);
         this.bulletinLigne.setBulligLibelle(this.calculRubrique.getPlanPaye().getPlpLibelleFR());
         this.bulletinLigne.setBulligRubrique(this.calculRubrique.getFeurubCode());
         this.bulletinLigne.setBulligNature(this.calculRubrique.getPlanPaye().getPlpNature());
         this.bulletinLigne.setBulligBaseFiscale(this.calculRubrique.getPlanPaye().isPlpBaseFiscale());
         this.bulletinLigne.setBulligBaseSociale(this.calculRubrique.getPlanPaye().isPlpBaseSociale());
         this.bulletinLigne.setBulligBaseConges(this.calculRubrique.getPlanPaye().isPlpBaseConges());
         this.bulletinLigne.setBulligBasePatronale(this.calculRubrique.getPlanPaye().isPlpBasePatronale());
         this.bulletinLigne.setBulligBaseAutre(this.calculRubrique.getPlanPaye().isPlpBaseAutre());
         this.bulletinLigne.setBulligSens(this.calculRubrique.getPlanPaye().getPlpSens());
         this.bulletinLigne.setBulligProrataTemporis(this.calculRubrique.getPlanPaye().getPlpProrataTemporis());
         this.lesformules.clear();
         this.lesPretsLignes.clear();
         double var2 = 0.0D;
         double var4 = 0.0D;
         double var6 = 0.0D;
         double var8 = 0.0D;
         double var10 = 0.0D;
         this.var_si = 0;
         this.base_imposable_fiscale = 0.0D;
         this.base_imposable_sociale = 0.0D;
         this.lesformules = this.feuilleCalculFormuleDao.chargerRubriqueFeuille(this.calculRubrique, var1);
         if (this.lesformules.size() != 0) {
            int var12;
            if (this.calculRubrique.isFeurubColA()) {
               this.operateur = "";
               this.memoValeur = 0.0D;
               this.etatTest = false;

               for(var12 = 0; var12 < this.lesformules.size(); ++var12) {
                  this.feuilleCalculFormule = (FeuilleCalculFormule)this.lesformules.get(var12);
                  if (this.feuilleCalculFormule.getFeurubforColonne().equals("A")) {
                     if (this.feuilleCalculFormule.getFeurubforFormule().equals("=")) {
                        this.operateur = "=";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("+")) {
                        this.operateur = "+";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("-")) {
                        this.operateur = "-";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("*")) {
                        this.operateur = "*";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("/")) {
                        this.operateur = "/";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().startsWith("SI(")) {
                        this.calculCondition();
                        this.operateur = "SI";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("SINON")) {
                        this.var_si = 1;
                        this.operateur = "SINON";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("FINSI")) {
                        this.var_si = 0;
                        this.operateur = "FINSI";
                     } else if (this.var_si == 0 || this.var_si == 1) {
                        var2 = this.calculFormule("A", this.calculRubrique, var1);
                     }
                  }
               }
            }

            this.bulletinLigne.setBulligAffColA(this.calculRubrique.isFeurubColA());
            this.bulletinLigne.setBulligValColA(var2);
            if (this.calculRubrique.isFeurubColB()) {
               this.operateur = "";
               this.memoValeur = 0.0D;
               this.etatTest = false;

               for(var12 = 0; var12 < this.lesformules.size(); ++var12) {
                  this.feuilleCalculFormule = (FeuilleCalculFormule)this.lesformules.get(var12);
                  if (this.feuilleCalculFormule.getFeurubforColonne().equals("B")) {
                     if (this.feuilleCalculFormule.getFeurubforFormule().equals("=")) {
                        this.operateur = "=";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("+")) {
                        this.operateur = "+";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("-")) {
                        this.operateur = "-";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("*")) {
                        this.operateur = "*";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("/")) {
                        this.operateur = "/";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().startsWith("SI(")) {
                        this.calculCondition();
                        this.operateur = "SI";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("SINON")) {
                        this.var_si = 1;
                        this.operateur = "SINON";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("FINSI")) {
                        this.var_si = 0;
                        this.operateur = "FINSI";
                     } else if (this.var_si == 0 || this.var_si == 1) {
                        var4 = this.calculFormule("B", this.calculRubrique, var1);
                     }
                  }
               }
            }

            this.bulletinLigne.setBulligAffColB(this.calculRubrique.isFeurubColB());
            this.bulletinLigne.setBulligValColB(var4);
            if (this.calculRubrique.isFeurubColC()) {
               this.operateur = "";
               this.memoValeur = 0.0D;
               this.etatTest = false;

               for(var12 = 0; var12 < this.lesformules.size(); ++var12) {
                  this.feuilleCalculFormule = (FeuilleCalculFormule)this.lesformules.get(var12);
                  if (this.feuilleCalculFormule.getFeurubforColonne().equals("C")) {
                     if (this.feuilleCalculFormule.getFeurubforFormule().equals("=")) {
                        this.operateur = "=";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("+")) {
                        this.operateur = "+";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("-")) {
                        this.operateur = "-";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("*")) {
                        this.operateur = "*";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("/")) {
                        this.operateur = "/";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().startsWith("SI(")) {
                        this.calculCondition();
                        this.operateur = "SI";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("SINON")) {
                        this.var_si = 1;
                        this.operateur = "SINON";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("FINSI")) {
                        this.var_si = 0;
                        this.operateur = "FINSI";
                     } else if (this.var_si == 0 || this.var_si == 1) {
                        var6 = this.calculFormule("C", this.calculRubrique, var1);
                     }
                  }
               }
            }

            this.bulletinLigne.setBulligAffColC(this.calculRubrique.isFeurubColC());
            this.bulletinLigne.setBulligValColC(var6);
            if (this.calculRubrique.isFeurubColD()) {
               this.operateur = "";
               this.memoValeur = 0.0D;
               this.etatTest = false;

               for(var12 = 0; var12 < this.lesformules.size(); ++var12) {
                  this.feuilleCalculFormule = (FeuilleCalculFormule)this.lesformules.get(var12);
                  if (this.feuilleCalculFormule.getFeurubforColonne().equals("D")) {
                     if (this.feuilleCalculFormule.getFeurubforFormule().equals("=")) {
                        this.operateur = "=";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("+")) {
                        this.operateur = "+";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("-")) {
                        this.operateur = "-";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("*")) {
                        this.operateur = "*";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("/")) {
                        this.operateur = "/";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().startsWith("SI(")) {
                        this.calculCondition();
                        this.operateur = "SI";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("SINON")) {
                        this.var_si = 1;
                        this.operateur = "SINON";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("FINSI")) {
                        this.var_si = 0;
                        this.operateur = "FINSI";
                     } else if (this.var_si == 0 || this.var_si == 1) {
                        var8 = this.calculFormule("D", this.calculRubrique, var1);
                     }
                  }
               }
            }

            this.bulletinLigne.setBulligAffColD(this.calculRubrique.isFeurubColD());
            this.bulletinLigne.setBulligValColD(var8);
            if (this.calculRubrique.isFeurubColE()) {
               this.operateur = "";
               this.memoValeur = 0.0D;
               this.etatTest = false;

               for(var12 = 0; var12 < this.lesformules.size(); ++var12) {
                  this.feuilleCalculFormule = (FeuilleCalculFormule)this.lesformules.get(var12);
                  if (this.feuilleCalculFormule.getFeurubforColonne().equals("E")) {
                     if (this.feuilleCalculFormule.getFeurubforFormule().equals("=")) {
                        this.operateur = "=";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("+")) {
                        this.operateur = "+";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("-")) {
                        this.operateur = "-";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("*")) {
                        this.operateur = "*";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("/")) {
                        this.operateur = "/";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().startsWith("SI(")) {
                        this.calculCondition();
                        this.operateur = "SI";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("SINON")) {
                        if (this.var_si == 1) {
                           this.var_si = 2;
                        } else {
                           this.var_si = 1;
                        }

                        this.operateur = "SINON";
                     } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("FINSI")) {
                        this.var_si = 0;
                        this.operateur = "FINSI";
                     } else if ((this.var_si == 0 || this.var_si == 1) && this.lesPretsLignes.size() == 0) {
                        var10 = this.calculSigne(this.calculFormule("E", this.calculRubrique, var1));
                        if (this.bulletinLigne.getBulligProrataTemporis() == 1 && this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && (this.salariesElements.getSaleleNature().equals("01D") || this.salariesElements.getSaleleNature().equals("01I") || this.salariesElements.getSaleleNature().equals("02D") || this.salariesElements.getSaleleNature().equals("02I"))) {
                           if (this.nombreJourPresence == 0.0F) {
                              this.M000040(var1);
                           }

                           var10 = var10 / (double)this.nbJourRef * (double)this.nombreJourPresence;
                           this.bulletinLigne.setBulligAffColD(true);
                           this.bulletinLigne.setBulligValColD((double)this.nombreJourPresence);
                        }
                     }
                  }
               }
            }

            if (this.rubriqueEcart == null || this.rubriqueEcart.isEmpty()) {
               this.rubriqueEcart = "100030";
            }

            if (this.bulletinLigne.getBulligRubrique().equals("100030") && this.montantAtteindre != 0.0D) {
               var10 = this.montantSursalaire;
            } else if (this.bulletinLigne.getBulligRubrique().equals(this.rubriqueEcart) && this.netAAtteindre != 0.0D) {
               var10 = this.montantSursalaire;
            }

            if (this.bulletinLigne.getBulligNature() <= 30 && this.type_conges == 2) {
               var10 = 0.0D;
            }

            this.bulletinLigne.setBulligAffColE(this.calculRubrique.isFeurubColE());
            this.bulletinLigne.setBulligValColE(var10);
            String var26 = this.bulletinLigne.getBulligRubrique();
            int var13 = this.bulletinLigne.getBulligNature();
            int var14 = this.bulletinLigne.getBulligSens();
            String var15 = this.bulletinLigne.getBulligObservation();
            double var27;
            if (this.lesPretsLignes.size() != 0 && this.montantAtteindre == 0.0D && this.majLigne && var10 != 0.0D) {
               for(int var28 = 0; var28 < this.lesPretsLignes.size(); ++var28) {
                  this.salariesPretsLignes = (SalariesPretsLignes)this.lesPretsLignes.get(var28);
                  if (this.salariesPretsLignes.getSalpreligMontantTheo() != 0.0D) {
                     this.bulletinLigne = new BulletinLigne();
                     this.bulletinLigne.setBulletinSalaire(this.bulletinSalaire);
                     this.bulletinLigne.setExercicesPaye(this.exercicesPaye);
                     this.bulletinLigne.setSalaries(this.salaries);
                     this.bulletinLigne.setBulligRubrique(var26);
                     this.bulletinLigne.setBulligNature(var13);
                     this.bulletinLigne.setBulligSens(var14);
                     this.bulletinLigne.setBulligObservation(var15);
                     this.salariesPrets = this.salariesPretsDao.pourParapheur(this.salariesPretsLignes.getSalpreligNum(), this.salaries, var1);
                     if (this.salariesPrets != null) {
                        var27 = 0.0D;
                        double var19 = 0.0D;
                        double var21 = 0.0D;
                        new ArrayList();
                        List var23 = this.salariesPretsLignesDao.chargerlesPretsLignes(this.salariesPrets, var1);
                        int var24;
                        if (this.salariesElements.getSaleleEtat() >= 2 && this.salariesElements.getSaleleModeSolde() == 0) {
                           if (var23.size() != 0) {
                              for(var24 = 0; var24 < var23.size(); ++var24) {
                                 this.salariesPretsLignes = (SalariesPretsLignes)var23.get(var24);
                                 if (this.salariesPretsLignes.getSalpreligMontantTheo() != 0.0D && (this.salariesPretsLignes.getSalpreligMontantReel() == 0.0D || this.salariesPretsLignes.getSalpreligDateReel().equals(this.d1))) {
                                    var21 += this.salariesPretsLignes.getSalpreligMontantTheo();
                                    this.salariesPretsLignes.setSalpreligDateReel(this.bulletinSalaire.getBulsalDateDebut());
                                    this.salariesPretsLignes.setSalpreligMontantReel(this.salariesPretsLignes.getSalpreligMontantTheo());
                                    this.salariesPretsLignesDao.modif(this.salariesPretsLignes, var1);
                                 }
                              }
                           }

                           this.bulletinLigne.setBulligAffColA(false);
                           this.bulletinLigne.setBulligAffColB(false);
                           this.bulletinLigne.setBulligAffColC(false);
                           this.bulletinLigne.setBulligAffColD(false);
                           this.bulletinLigne.setBulligAffColE(true);
                           this.bulletinLigne.setBulligValColA(0.0D);
                           this.bulletinLigne.setBulligValColB(0.0D);
                           this.bulletinLigne.setBulligValColC(0.0D);
                           this.bulletinLigne.setBulligValColD(0.0D);
                           this.bulletinLigne.setBulligValColE(this.calculSigne(var21));
                           if (this.salariesPrets.getSalpreObjet() != null && !this.salariesPrets.getSalpreObjet().isEmpty()) {
                              this.bulletinLigne.setBulligLibelle(this.salariesPrets.getSalpreObjet() + " (n° " + this.salariesPrets.getSalpreNum() + ") #SOLDE");
                           } else if (this.salariesPrets.getSalpreNature() == 7) {
                              this.bulletinLigne.setBulligLibelle("Avance étalée n° " + this.salariesPrets.getSalpreNum() + " #SOLDE");
                           } else {
                              this.bulletinLigne.setBulligLibelle("Remboursement prêt n° " + this.salariesPrets.getSalpreNum() + " #SOLDE");
                           }

                           this.bulletinLigne.setBulligIdPretligne(0L);
                           this.bulletinLigne.setBulligNumPret(this.salariesPrets.getSalpreNum());
                           this.bulletinLigne.setBulligNaturePret(this.salariesPrets.getSalpreNature());
                           if (this.montantAtteindre == 0.0D && this.netAAtteindre == 0.0D && this.majLigne) {
                              this.bulletinLigne = this.bulletinLigneDao.insert(this.bulletinLigne, var1);
                           }

                           this.lesBulletinsLigne.add(this.bulletinLigne);
                        } else {
                           if (var23.size() != 0) {
                              for(var24 = 0; var24 < var23.size(); ++var24) {
                                 if (((SalariesPretsLignes)var23.get(var24)).getSalpreligMontantReel() == 0.0D) {
                                    Date var25 = ((SalariesPretsLignes)var23.get(var24)).getSalpreligDateTheo();
                                    if (!this.d1.before(var25) && !this.d1.equals(var25) || !this.d2.after(var25) && !this.d2.equals(var25)) {
                                       var27 += ((SalariesPretsLignes)var23.get(var24)).getSalpreligMontantTheo() - ((SalariesPretsLignes)var23.get(var24)).getSalpreligMontantReel();
                                       ++var19;
                                    }
                                 }
                              }
                           }

                           this.bulletinLigne.setBulligAffColA(false);
                           this.bulletinLigne.setBulligAffColB(true);
                           this.bulletinLigne.setBulligAffColC(false);
                           this.bulletinLigne.setBulligAffColD(true);
                           this.bulletinLigne.setBulligAffColE(true);
                           this.bulletinLigne.setBulligValColA(0.0D);
                           this.bulletinLigne.setBulligValColB(var27);
                           this.bulletinLigne.setBulligValColC(0.0D);
                           this.bulletinLigne.setBulligValColD(var19);
                           this.bulletinLigne.setBulligValColE(this.calculSigne(this.salariesPretsLignes.getSalpreligMontantTheo()));
                           if (this.salariesPrets.getSalpreObjet() != null && !this.salariesPrets.getSalpreObjet().isEmpty()) {
                              this.bulletinLigne.setBulligLibelle(this.salariesPrets.getSalpreObjet() + " (n° " + this.salariesPrets.getSalpreNum() + ")");
                           } else if (this.salariesPrets.getSalpreNature() == 7) {
                              this.bulletinLigne.setBulligLibelle("Avance étalée n° " + this.salariesPrets.getSalpreNum());
                           } else {
                              this.bulletinLigne.setBulligLibelle("Remboursement prêt n° " + this.salariesPrets.getSalpreNum());
                           }

                           this.bulletinLigne.setBulligIdPretligne(this.salariesPretsLignes.getSalpreligId());
                           this.bulletinLigne.setBulligNumPret(this.salariesPrets.getSalpreNum());
                           this.bulletinLigne.setBulligNaturePret(this.salariesPrets.getSalpreNature());
                           if (this.montantAtteindre == 0.0D && this.netAAtteindre == 0.0D && this.majLigne) {
                              this.bulletinLigne = this.bulletinLigneDao.insert(this.bulletinLigne, var1);
                           }

                           this.lesBulletinsLigne.add(this.bulletinLigne);
                           this.salariesPretsLignes.setSalpreligDateReel(this.bulletinSalaire.getBulsalDateDebut());
                           this.salariesPretsLignes.setSalpreligMontantReel(this.salariesPretsLignes.getSalpreligMontantTheo());
                           this.salariesPretsLignesDao.modif(this.salariesPretsLignes, var1);
                        }
                     }
                  }
               }
            } else {
               boolean var16;
               int var17;
               if (!this.preCalcul) {
                  if (this.bulletinLigne.getBulligValColE() != 0.0D) {
                     if (this.salariesContrats != null && this.salariesContrats.getSalconTaux() != 0.0F && this.bulletinLigne.getBulligNature() != 60 && this.bulletinLigne.getBulligNature() != 61 && this.bulletinLigne.getBulligNature() != 88 && this.bulletinLigne.getBulligNature() != 90 && !this.bulletinLigne.getBulligRubrique().equals("299999") && !this.bulletinLigne.getBulligRubrique().equals("499999") && !this.bulletinLigne.getBulligRubrique().equals("699999")) {
                        var16 = true;
                        if (this.lesformules.size() != 0) {
                           for(var17 = 0; var17 < this.lesformules.size(); ++var17) {
                              if (((FeuilleCalculFormule)this.lesformules.get(var17)).getFeurubforFormule().equals("RUB(100000:E)") || ((FeuilleCalculFormule)this.lesformules.get(var17)).getFeurubforFormule().equals("RUB(100010:E)")) {
                                 var16 = false;
                                 break;
                              }
                           }
                        }

                        if (this.bulletinLigne.getBulligRubrique().equals("100000") || this.bulletinLigne.getBulligRubrique().equals("100010") || var16) {
                           this.bulletinLigne.setBulligAffColC(true);
                           this.bulletinLigne.setBulligValColC((double)this.salariesContrats.getSalconTaux());
                           var27 = this.utilNombre.myRoundDevise(this.bulletinLigne.getBulligValColE() * this.bulletinLigne.getBulligValColC() / 100.0D, this.structureLog.getStrdevise());
                           this.bulletinLigne.setBulligValColE(var27);
                        }
                     }

                     if (this.montantAtteindre == 0.0D && this.netAAtteindre == 0.0D && this.majLigne) {
                        this.bulletinLigne = this.bulletinLigneDao.insert(this.bulletinLigne, var1);
                     }
                  }

                  this.lesBulletinsLigne.add(this.bulletinLigne);
               } else if (this.salariesContrats != null && this.salariesContrats.getSalconTaux() != 0.0F && this.bulletinLigne.getBulligNature() != 60 && this.bulletinLigne.getBulligNature() != 61 && this.bulletinLigne.getBulligNature() != 88 && this.bulletinLigne.getBulligNature() != 90 && !this.bulletinLigne.getBulligRubrique().equals("299999") && !this.bulletinLigne.getBulligRubrique().equals("499999") && !this.bulletinLigne.getBulligRubrique().equals("699999")) {
                  var16 = true;
                  if (this.lesformules.size() != 0) {
                     for(var17 = 0; var17 < this.lesformules.size(); ++var17) {
                        if (((FeuilleCalculFormule)this.lesformules.get(var17)).getFeurubforFormule().equals("RUB(100000:E)") || ((FeuilleCalculFormule)this.lesformules.get(var17)).getFeurubforFormule().equals("RUB(100010:E)")) {
                           var16 = false;
                           break;
                        }
                     }
                  }

                  if (this.bulletinLigne.getBulligRubrique().equals("100000") || this.bulletinLigne.getBulligRubrique().equals("100010") || var16) {
                     this.bulletinLigne.setBulligAffColC(true);
                     this.bulletinLigne.setBulligValColC((double)this.salariesContrats.getSalconTaux());
                     var27 = this.utilNombre.myRoundDevise(this.bulletinLigne.getBulligValColE() * this.bulletinLigne.getBulligValColC() / 100.0D, this.structureLog.getStrdevise());
                     this.bulletinLigne.setBulligValColE(var27);
                  }
               }
            }
         }
      }

   }

   public void calculCondition() {
      double var1 = 0.0D;
      String[] var3 = this.feuilleCalculFormule.getFeurubforFormule().split(":");
      var1 = Double.parseDouble(var3[1]);
      if (this.feuilleCalculFormule.getFeurubforFormule().startsWith("SI(>)")) {
         if (this.memoValeur > var1) {
            this.var_si = 1;
         } else {
            this.var_si = 2;
         }
      } else if (this.feuilleCalculFormule.getFeurubforFormule().startsWith("SI(>=)")) {
         if (this.memoValeur >= var1) {
            this.var_si = 1;
         } else {
            this.var_si = 2;
         }
      } else if (this.feuilleCalculFormule.getFeurubforFormule().startsWith("SI(<)")) {
         if (this.memoValeur < var1) {
            this.var_si = 1;
         } else {
            this.var_si = 2;
         }
      } else if (this.feuilleCalculFormule.getFeurubforFormule().startsWith("SI(<=)")) {
         if (this.memoValeur <= var1) {
            this.var_si = 1;
         } else {
            this.var_si = 2;
         }
      } else if (this.feuilleCalculFormule.getFeurubforFormule().startsWith("SI(==)")) {
         if (this.memoValeur == var1) {
            this.var_si = 1;
         } else {
            this.var_si = 2;
         }
      } else if (this.feuilleCalculFormule.getFeurubforFormule().startsWith("SI(<>)")) {
         if (this.memoValeur != var1) {
            this.var_si = 1;
         } else {
            this.var_si = 2;
         }
      } else {
         this.var_si = 0;
      }

   }

   public double calculFormule(String var1, FeuilleCalculRubrique var2, Session var3) throws HibernateException, NamingException, ParseException {
      this.valeur = 0.0D;
      this.modeRegularisation = var2.getPlanPaye().getPlpOption();
      if (this.var_info != null && !this.var_info.isEmpty() && this.var_info.startsWith("Simulation")) {
         this.modeRegularisation = 0;
      }

      if (this.feuilleCalculFormule.getFeurubforFormule().equals("ABS()")) {
         this.calculABS(var1);
      } else if (this.feuilleCalculFormule.getFeurubforFormule().startsWith("ARR(")) {
         this.calculARR(var1);
      } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("INV()")) {
         this.calculINV(var1);
      } else if (this.feuilleCalculFormule.getFeurubforFormule().startsWith("TOT(")) {
         this.calculTOT(var1);
      } else if (this.feuilleCalculFormule.getFeurubforFormule().startsWith("SOM(")) {
         this.calculSOM(var1);
         this.calculOperateurs();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().startsWith("COL(")) {
         this.calculCOL(var1);
         this.calculOperateurs();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().startsWith("VAL(")) {
         this.calculVAL(var1);
         this.calculOperateurs();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().startsWith("RUB(")) {
         this.calculRUB(var1, var2, this.feuilleCalculFormule, var3);
         this.calculOperateurs();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().startsWith("MAC(")) {
         this.calculMAC(var1, var3);
         this.calculOperateurs();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().startsWith("SAL(")) {
         this.calculSAL(var1);
         this.calculOperateurs();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().startsWith("VAR(")) {
         this.calculVAR(var1);
         this.calculOperateurs();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().startsWith("TST(")) {
         this.calculTST(var1);
         this.calculOperateurs();
      }

      this.memoValeur = this.valeur;
      return this.valeur;
   }

   public void calculOperateurs() {
      if (this.operateur != null && !this.operateur.isEmpty() && !this.operateur.equals("=")) {
         if (this.operateur.equals("+")) {
            this.valeur += this.memoValeur;
         } else if (this.operateur.equals("-")) {
            this.valeur = this.memoValeur - this.valeur;
         } else if (this.operateur.equals("*")) {
            this.valeur = this.memoValeur * this.valeur;
         } else if (this.operateur.equals("/")) {
            if (this.valeur != 0.0D) {
               this.valeur = this.memoValeur / this.valeur;
            } else {
               this.valeur = 0.0D;
            }
         }
      }

   }

   public void calculABS(String var1) {
      this.valeur = Math.abs(this.memoValeur);
   }

   public void calculARR(String var1) {
      String var2 = this.feuilleCalculFormule.getFeurubforFormule().substring(4, this.feuilleCalculFormule.getFeurubforFormule().length() - 1);
      int var3 = Integer.parseInt(var2);
      this.valeur = this.utilNombre.myRound(this.memoValeur, var3);
   }

   public double calculARR(double var1) {
      double var3 = this.utilNombre.myRoundDevise(var1, this.structureLog.getStrdevise());
      return var3;
   }

   public void calculINV(String var1) {
      this.valeur = this.memoValeur * -1.0D;
   }

   public void calculTOT(String var1) throws HibernateException, NamingException {
      new BulletinLigne();
      double var3 = 0.0D;
      BulletinLigne var2;
      int var5;
      if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(BRUT)")) {
         for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
            var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
            if ((var2.getBulligNature() == 10 || var2.getBulligNature() == 11 || var2.getBulligNature() == 20 || var2.getBulligNature() == 21 || var2.getBulligNature() == 25 || var2.getBulligNature() == 30 || var2.getBulligNature() == 40 || var2.getBulligNature() == 41 || var2.getBulligNature() == 42) && var2.getBulligSens() <= 3) {
               var3 += var2.getBulligValColE();
            }
         }
      } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(INDEMNITE_COMPENSATRICE)")) {
         for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
            var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
            if (var2.getBulligNature() == 25 && var2.getBulligSens() <= 3) {
               var3 += var2.getBulligValColE();
            }
         }
      } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(AVANTAGE_NATURE)")) {
         for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
            var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
            if (var2.getBulligNature() == 50 && var2.getBulligSens() <= 3) {
               var3 += var2.getBulligValColE();
            }
         }
      } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(BASE_FISCALE)")) {
         for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
            var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
            if ((var2.getBulligNature() == 50 || var2.getBulligNature() == 59) && var2.getBulligSens() <= 3) {
               var3 += var2.getBulligValColE();
            }
         }
      } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(BASE_FISCALE-N41)")) {
         for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
            var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
            if (var2.getBulligNature() != 50 && var2.getBulligNature() != 59) {
               if (var2.getBulligNature() == 41 && var2.getBulligSens() <= 3) {
                  var3 += var2.getBulligValColE();
               }
            } else if (var2.getBulligSens() <= 3) {
               var3 += var2.getBulligValColE();
            }
         }
      } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(NET)")) {
         for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
            var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
            if ((var2.getBulligNature() == 59 || var2.getBulligNature() == 60 || var2.getBulligNature() == 61 || var2.getBulligNature() == 62) && var2.getBulligSens() <= 3) {
               var3 += var2.getBulligValColE();
            }
         }
      } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(INDEMNITES)")) {
         for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
            var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
            if (var2.getBulligNature() == 70 && var2.getBulligSens() <= 3) {
               var3 += var2.getBulligValColE();
            }
         }
      } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(RETENUES)")) {
         for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
            var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
            if (var2.getBulligNature() == 80 && var2.getBulligSens() <= 3) {
               var3 += var2.getBulligValColE();
            }
         }
      } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(NET_A_PAYER)")) {
         for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
            var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
            if ((var2.getBulligNature() == 69 || var2.getBulligNature() == 70 || var2.getBulligNature() == 80 || var2.getBulligNature() == 88) && var2.getBulligSens() <= 3) {
               var3 += var2.getBulligValColE();
            }
         }
      } else {
         int var6;
         if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(109500-109559)")) {
            for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
               var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
               var6 = Integer.parseInt(var2.getBulligRubrique());
               if ((var6 >= 109500 || var6 <= 109559) && var2.getBulligSens() <= 3) {
                  var3 += var2.getBulligValColE();
               }
            }
         } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(109560-109599)")) {
            for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
               var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
               var6 = Integer.parseInt(var2.getBulligRubrique());
               if ((var6 >= 109560 || var6 <= 109599) && var2.getBulligSens() <= 3) {
                  var3 += var2.getBulligValColE();
               }
            }
         } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(NATURE_10)")) {
            for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
               var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
               if (var2.getBulligNature() == 10 && var2.getBulligSens() <= 3) {
                  var3 += var2.getBulligValColE();
               }
            }
         } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(NATURE_11)")) {
            for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
               var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
               if (var2.getBulligNature() == 11 && var2.getBulligSens() <= 3) {
                  var3 += var2.getBulligValColE();
               }
            }
         } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(NATURE_20)")) {
            for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
               var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
               if (var2.getBulligNature() == 20 && var2.getBulligSens() <= 3) {
                  var3 += var2.getBulligValColE();
               }
            }
         } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(NATURE_21)")) {
            for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
               var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
               if (var2.getBulligNature() == 21 && var2.getBulligSens() <= 3) {
                  var3 += var2.getBulligValColE();
               }
            }
         } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(NATURE_30)")) {
            for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
               var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
               if (var2.getBulligNature() == 30 && var2.getBulligSens() <= 3) {
                  var3 += var2.getBulligValColE();
               }
            }
         } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(NATURE_40)")) {
            for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
               var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
               if (var2.getBulligNature() == 40 && var2.getBulligSens() <= 3) {
                  var3 += var2.getBulligValColE();
               }
            }
         } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(NATURE_41)")) {
            for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
               var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
               if (var2.getBulligNature() == 41 && var2.getBulligSens() <= 3) {
                  var3 += var2.getBulligValColE();
               }
            }
         } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(NATURE_42)")) {
            for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
               var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
               if (var2.getBulligNature() == 42 && var2.getBulligSens() <= 3) {
                  var3 += var2.getBulligValColE();
               }
            }
         } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(NATURE_60)")) {
            for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
               var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
               if (var2.getBulligNature() == 60 && var2.getBulligSens() <= 3) {
                  var3 += var2.getBulligValColE();
               }
            }
         } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(NATURE_61)")) {
            for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
               var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
               if (var2.getBulligNature() == 61 && var2.getBulligSens() <= 3) {
                  var3 += var2.getBulligValColE();
               }
            }
         } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(NATURE_62)")) {
            for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
               var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
               if (var2.getBulligNature() == 62 && var2.getBulligSens() <= 3) {
                  var3 += var2.getBulligValColE();
               }
            }
         } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(NATURE_90)")) {
            for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
               var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
               if (var2.getBulligNature() == 90 && var2.getBulligSens() <= 3) {
                  var3 += var2.getBulligValColE();
               }
            }
         } else if (this.feuilleCalculFormule.getFeurubforFormule().equals("TOT(BASE+SURSALAIRE)")) {
            for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
               var2 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
               if (var2.getBulligNature() == 10 && var2.getBulligSens() <= 3) {
                  if (var2.getBulligValColB() != 0.0D) {
                     var3 += var2.getBulligValColB();
                  } else {
                     var3 += var2.getBulligValColE();
                  }
               }
            }
         }
      }

      this.valeur = var3;
   }

   public void calculSOM(String var1) {
      String var2 = this.feuilleCalculFormule.getFeurubforFormule().substring(4, this.feuilleCalculFormule.getFeurubforFormule().length() - 1);
      String[] var3 = var2.split(":");
      int var4 = Integer.parseInt(var3[0]);
      int var5 = Integer.parseInt(var3[1]);
      double var6 = 0.0D;
      int var8;
      BulletinLigne var9;
      int var10;
      if (var1.equals("A")) {
         for(var8 = 0; var8 < this.lesBulletinsLigne.size(); ++var8) {
            new BulletinLigne();
            var9 = (BulletinLigne)this.lesBulletinsLigne.get(var8);
            var10 = Integer.parseInt(var9.getBulligRubrique());
            if (var10 >= var4 && var10 <= var5) {
               if (var9.getBulligSens() == 0) {
                  var6 += var9.getBulligValColA();
               } else if (var9.getBulligSens() == 1) {
                  var6 -= var9.getBulligValColA();
               }
            }
         }
      } else if (var1.equals("B")) {
         for(var8 = 0; var8 < this.lesBulletinsLigne.size(); ++var8) {
            new BulletinLigne();
            var9 = (BulletinLigne)this.lesBulletinsLigne.get(var8);
            var10 = Integer.parseInt(var9.getBulligRubrique());
            if (var10 >= var4 && var10 <= var5) {
               if (var9.getBulligSens() == 0) {
                  var6 += var9.getBulligValColB();
               } else if (var9.getBulligSens() == 1) {
                  var6 -= var9.getBulligValColB();
               }
            }
         }
      } else if (var1.equals("C")) {
         for(var8 = 0; var8 < this.lesBulletinsLigne.size(); ++var8) {
            new BulletinLigne();
            var9 = (BulletinLigne)this.lesBulletinsLigne.get(var8);
            var10 = Integer.parseInt(var9.getBulligRubrique());
            if (var10 >= var4 && var10 <= var5) {
               if (var9.getBulligSens() == 0) {
                  var6 += var9.getBulligValColC();
               } else if (var9.getBulligSens() == 1) {
                  var6 -= var9.getBulligValColC();
               }
            }
         }
      } else if (var1.equals("D")) {
         for(var8 = 0; var8 < this.lesBulletinsLigne.size(); ++var8) {
            new BulletinLigne();
            var9 = (BulletinLigne)this.lesBulletinsLigne.get(var8);
            var10 = Integer.parseInt(var9.getBulligRubrique());
            if (var10 >= var4 && var10 <= var5) {
               if (var9.getBulligSens() == 0) {
                  var6 += var9.getBulligValColD();
               } else if (var9.getBulligSens() == 1) {
                  var6 -= var9.getBulligValColD();
               }
            }
         }
      } else if (var1.equals("E")) {
         for(var8 = 0; var8 < this.lesBulletinsLigne.size(); ++var8) {
            new BulletinLigne();
            var9 = (BulletinLigne)this.lesBulletinsLigne.get(var8);
            var10 = Integer.parseInt(var9.getBulligRubrique());
            if (var10 >= var4 && var10 <= var5) {
               if (var9.getBulligSens() == 0) {
                  var6 += var9.getBulligValColE();
               } else if (var9.getBulligSens() == 1) {
                  var6 -= var9.getBulligValColE();
               }
            }
         }
      }

      this.valeur = var6;
   }

   public void calculCOL(String var1) {
      String var2 = this.feuilleCalculFormule.getFeurubforFormule().substring(4, this.feuilleCalculFormule.getFeurubforFormule().length() - 1);
      if (!var2.equals("A") && !var2.equals("B") && !var2.equals("C") && !var2.equals("D") && !var2.equals("E")) {
         var2 = "E";
      }

      if (var2.equals("A")) {
         this.valeur = this.bulletinLigne.getBulligValColA();
      } else if (var2.equals("B")) {
         this.valeur = this.bulletinLigne.getBulligValColB();
      } else if (var2.equals("C")) {
         this.valeur = this.bulletinLigne.getBulligValColC();
      } else if (var2.equals("D")) {
         this.valeur = this.bulletinLigne.getBulligValColD();
      } else if (var2.equals("E")) {
         this.valeur = this.bulletinLigne.getBulligValColE();
      } else {
         this.valeur = 0.0D;
      }

   }

   public void calculTST(String var1) {
      String var2 = this.feuilleCalculFormule.getFeurubforFormule().substring(4, this.feuilleCalculFormule.getFeurubforFormule().length() - 1);
      if (!var2.equals("A") && !var2.equals("B") && !var2.equals("C") && !var2.equals("D") && !var2.equals("E")) {
         var2 = "E";
      }

      double var3 = 0.0D;
      if (var2.equals("A")) {
         var3 = this.bulletinLigne.getBulligValColA();
         if (var3 == 0.0D) {
            this.memoValeur = 0.0D;
            this.valeur = 0.0D;
         } else if (var1.equals("A")) {
            this.valeur = this.bulletinLigne.getBulligValColA();
         } else if (var1.equals("B")) {
            this.valeur = this.bulletinLigne.getBulligValColB();
         } else if (var1.equals("C")) {
            this.valeur = this.bulletinLigne.getBulligValColC();
         } else if (var1.equals("D")) {
            this.valeur = this.bulletinLigne.getBulligValColD();
         } else if (var1.equals("E")) {
            this.valeur = this.bulletinLigne.getBulligValColE();
         } else {
            this.memoValeur = 0.0D;
            this.valeur = 0.0D;
         }
      } else if (var2.equals("B")) {
         var3 = this.bulletinLigne.getBulligValColB();
         if (var3 == 0.0D) {
            this.memoValeur = 0.0D;
            this.valeur = 0.0D;
         } else if (var1.equals("A")) {
            this.valeur = this.bulletinLigne.getBulligValColA();
         } else if (var1.equals("B")) {
            this.valeur = this.bulletinLigne.getBulligValColB();
         } else if (var1.equals("C")) {
            this.valeur = this.bulletinLigne.getBulligValColC();
         } else if (var1.equals("D")) {
            this.valeur = this.bulletinLigne.getBulligValColD();
         } else if (var1.equals("E")) {
            this.valeur = this.bulletinLigne.getBulligValColE();
         } else {
            this.memoValeur = 0.0D;
            this.valeur = 0.0D;
         }
      } else if (var2.equals("C")) {
         var3 = this.bulletinLigne.getBulligValColC();
         if (var3 == 0.0D) {
            this.memoValeur = 0.0D;
            this.valeur = 0.0D;
         } else if (var1.equals("A")) {
            this.valeur = this.bulletinLigne.getBulligValColA();
         } else if (var1.equals("B")) {
            this.valeur = this.bulletinLigne.getBulligValColB();
         } else if (var1.equals("C")) {
            this.valeur = this.bulletinLigne.getBulligValColC();
         } else if (var1.equals("D")) {
            this.valeur = this.bulletinLigne.getBulligValColD();
         } else if (var1.equals("E")) {
            this.valeur = this.bulletinLigne.getBulligValColE();
         } else {
            this.memoValeur = 0.0D;
            this.valeur = 0.0D;
         }
      } else if (var2.equals("D")) {
         var3 = this.bulletinLigne.getBulligValColD();
         if (var3 == 0.0D) {
            this.memoValeur = 0.0D;
            this.valeur = 0.0D;
         } else if (var1.equals("A")) {
            this.valeur = this.bulletinLigne.getBulligValColA();
         } else if (var1.equals("B")) {
            this.valeur = this.bulletinLigne.getBulligValColB();
         } else if (var1.equals("C")) {
            this.valeur = this.bulletinLigne.getBulligValColC();
         } else if (var1.equals("D")) {
            this.valeur = this.bulletinLigne.getBulligValColD();
         } else if (var1.equals("E")) {
            this.valeur = this.bulletinLigne.getBulligValColE();
         } else {
            this.memoValeur = 0.0D;
            this.valeur = 0.0D;
         }
      } else if (var2.equals("E")) {
         var3 = this.bulletinLigne.getBulligValColE();
         if (var3 == 0.0D) {
            this.memoValeur = 0.0D;
            this.valeur = 0.0D;
         } else if (var1.equals("A")) {
            this.valeur = this.bulletinLigne.getBulligValColA();
         } else if (var1.equals("B")) {
            this.valeur = this.bulletinLigne.getBulligValColB();
         } else if (var1.equals("C")) {
            this.valeur = this.bulletinLigne.getBulligValColC();
         } else if (var1.equals("D")) {
            this.valeur = this.bulletinLigne.getBulligValColD();
         } else if (var1.equals("E")) {
            this.valeur = this.bulletinLigne.getBulligValColE();
         } else {
            this.memoValeur = 0.0D;
            this.valeur = 0.0D;
         }
      } else {
         this.memoValeur = 0.0D;
         this.valeur = 0.0D;
      }

   }

   public void calculVAL(String var1) {
      String var2 = this.feuilleCalculFormule.getFeurubforFormule().substring(4, this.feuilleCalculFormule.getFeurubforFormule().length() - 1);
      if (var2 != null && !var2.isEmpty()) {
         var2 = this.filtreNumerique(var2);
      } else {
         var2 = "0";
      }

      this.valeur = Double.parseDouble(var2);
   }

   public String filtreNumerique(String var1) {
      String var2 = "";
      String var3 = "";

      for(int var4 = 0; var4 < var1.length(); ++var4) {
         var3 = (String)var1.subSequence(var4, var4 + 1);
         if ("1234567890.".contains(var3)) {
            var2 = var2 + var3.toUpperCase();
         }
      }

      return var2;
   }

   public void calculRUB(String var1, FeuilleCalculRubrique var2, FeuilleCalculFormule var3, Session var4) throws HibernateException, NamingException {
      String var5 = var3.getFeurubforFormule().substring(4, var3.getFeurubforFormule().length() - 1);
      if (var5 != null && !var5.isEmpty() && var5.contains(":")) {
         String[] var6 = var5.split(":");
         String var7 = var6[0];
         String var8 = var6[1];
         if (!var8.equals("A") && !var8.equals("B") && !var8.equals("C") && !var8.equals("D") && !var8.equals("E")) {
            var8 = "E";
         }

         this.valeur = 0.0D;
         if (this.lesBulletinsLigne.size() != 0) {
            boolean var9 = false;

            for(int var10 = 0; var10 < this.lesBulletinsLigne.size(); ++var10) {
               if (((BulletinLigne)this.lesBulletinsLigne.get(var10)).getBulligRubrique().equals(var7)) {
                  if (var8.equals("A")) {
                     this.valeur = ((BulletinLigne)this.lesBulletinsLigne.get(var10)).getBulligValColA();
                  } else if (var8.equals("B")) {
                     this.valeur = ((BulletinLigne)this.lesBulletinsLigne.get(var10)).getBulligValColB();
                  } else if (var8.equals("C")) {
                     this.valeur = ((BulletinLigne)this.lesBulletinsLigne.get(var10)).getBulligValColC();
                  } else if (var8.equals("D")) {
                     this.valeur = ((BulletinLigne)this.lesBulletinsLigne.get(var10)).getBulligValColD();
                  } else if (var8.equals("E")) {
                     this.valeur = ((BulletinLigne)this.lesBulletinsLigne.get(var10)).getBulligValColE();
                  }

                  var9 = true;
                  break;
               }
            }

            if (!var9) {
            }
         }
      }

   }

   public void calculMAC(String var1, Session var2) throws HibernateException, NamingException, ParseException {
      if (this.feuilleCalculFormule.getFeurubforFormule() != null && !this.feuilleCalculFormule.getFeurubforFormule().isEmpty() && !this.feuilleCalculFormule.getFeurubforFormule().equals("MAC()")) {
         String var3 = this.feuilleCalculFormule.getFeurubforFormule().substring(4, this.feuilleCalculFormule.getFeurubforFormule().length() - 1);
         String[] var4 = var3.split(":");
         String var5 = var4[1];
         if (var5.equals("M000001")) {
            this.M000001(var2);
         } else if (var5.equals("M000002")) {
            this.M000002(var2);
         } else if (var5.equals("M000003")) {
            this.M000003(var2);
         } else if (var5.equals("M000004")) {
            this.M000004(var2);
         } else if (var5.equals("M000005")) {
            this.M000005(var2);
         } else if (var5.equals("M000006")) {
            this.M000006(var2);
         } else if (var5.equals("M000007")) {
            this.M000007(var2);
         } else if (var5.equals("M000008")) {
            this.M000008(var2);
         } else if (var5.equals("M000009")) {
            this.M000009(var2);
         } else if (var5.equals("M000010")) {
            this.M000010(var2);
         } else if (var5.equals("M000011")) {
            this.M000011(var2);
         } else if (var5.equals("M000012")) {
            this.M000012(var2);
         } else if (var5.equals("M000013")) {
            this.M000013(var2);
         } else if (var5.equals("M000014")) {
            this.M000014(var2);
         } else if (var5.equals("M000015")) {
            this.M000015(var2);
         } else if (var5.equals("M000016")) {
            this.M000016(var2);
         } else if (var5.equals("M000017")) {
            this.M000017(var2);
         } else if (var5.equals("M000018")) {
            this.M000018(var2);
         } else if (var5.equals("M000019")) {
            this.M000019(var2);
         } else if (var5.equals("M000020")) {
            this.M000020(var2);
         } else if (var5.equals("M000021")) {
            this.M000021(var2);
         } else if (var5.equals("M000022")) {
            this.M000022(var2);
         } else if (var5.equals("M000023")) {
            this.M000023(var2);
         } else if (var5.equals("M000024")) {
            this.M000024(var2);
         } else if (var5.equals("M000025")) {
            this.M000025(var2);
         } else if (var5.equals("M000026")) {
            this.M000026(var2);
         } else if (var5.equals("M000027")) {
            this.M000027(var2);
         } else if (var5.equals("M000028")) {
            this.M000028(var2);
         } else if (var5.equals("M000029")) {
            this.M000029(var2);
         } else if (var5.equals("M000030")) {
            this.M000030(var2);
         } else if (var5.equals("M000031")) {
            this.M000031(var2);
         } else if (var5.equals("M000032")) {
            this.M000032(var2);
         } else if (var5.equals("M000033")) {
            this.M000033(var2);
         } else if (var5.equals("M000034")) {
            this.M000034(var2);
         } else if (var5.equals("M000035")) {
            this.M000035(var2);
         } else if (var5.equals("M000036")) {
            this.M000036(var2);
         } else if (var5.equals("M000037")) {
            this.M000037(var2);
         } else if (var5.equals("M000038")) {
            this.M000038(var2);
         } else if (var5.equals("M000039")) {
            this.M000039(var2);
         } else if (var5.equals("M000040")) {
            this.M000040(var2);
         } else if (var5.equals("M000041")) {
            this.M000041(var2);
         } else if (var5.equals("M000042")) {
            this.M000042(var2);
         } else if (var5.equals("M000043")) {
            this.M000043(var2);
         } else if (var5.equals("M000044")) {
            this.M000044(var2);
         } else if (var5.equals("M000045")) {
            this.M000045(var2);
         } else if (var5.equals("M000046")) {
            this.M000046(var2);
         } else if (var5.equals("M000047")) {
            this.M000047();
         } else if (var5.equals("M000048")) {
            this.M000048();
         } else if (var5.equals("M000049")) {
            this.M000049();
         } else if (var5.equals("M000050")) {
            this.M000050();
         } else if (var5.equals("M000051")) {
            this.M000051();
         } else if (var5.equals("M000052")) {
            this.M000052();
         } else if (var5.equals("M000053")) {
            this.M000053();
         } else if (var5.equals("M000054")) {
            this.M000054();
         } else if (var5.equals("M000055")) {
            this.M000055();
         } else if (var5.equals("M000056")) {
            this.M000056();
         } else if (var5.equals("M000057")) {
            this.M000057();
         } else if (var5.equals("M000058")) {
            this.M000058();
         } else if (var5.equals("M000059")) {
            this.M000059();
         } else if (var5.equals("M000060")) {
            this.M000060();
         } else if (var5.equals("M000061")) {
            this.M000061();
         } else if (var5.equals("M000062")) {
            this.M000062();
         } else if (var5.equals("M000063")) {
            this.M000063();
         } else if (var5.equals("M000064")) {
            this.M000064();
         } else if (var5.equals("M000065")) {
            this.M000065();
         } else if (var5.equals("M000066")) {
            this.M000066();
         } else if (var5.equals("M000067")) {
            this.M000067();
         } else if (var5.equals("M000068")) {
            this.M000068();
         } else if (var5.equals("M000069")) {
            this.M000069(var2);
         } else if (var5.equals("M000070")) {
            this.M000070(var2);
         } else if (var5.equals("M000071")) {
            this.M000071(var2);
         } else if (var5.equals("M000072")) {
            this.M000072(var2);
         } else if (var5.equals("M000073")) {
            this.M000073();
         } else if (var5.equals("M000074")) {
            this.M000074();
         } else if (var5.equals("M000075")) {
            this.M000075();
         } else if (var5.equals("M000076")) {
            this.M000076();
         } else if (var5.equals("M000077")) {
            this.M000077(var2);
         } else if (var5.equals("M000078")) {
            this.M000078(var2);
         } else if (var5.equals("M000079")) {
            this.M000079(var2);
         } else if (var5.equals("M000080")) {
            this.M000080(var2);
         } else if (var5.equals("M000081")) {
            this.M000081();
         } else if (var5.equals("M000082")) {
            this.M000082();
         } else if (var5.equals("M000083")) {
            this.M000083();
         } else if (var5.equals("M000084")) {
            this.M000084();
         } else if (var5.equals("M000085")) {
            this.M000085(var2);
         } else if (var5.equals("M000086")) {
            this.M000086();
         } else if (var5.equals("M000087")) {
            this.M000087();
         } else if (var5.equals("M000088")) {
            this.M000088();
         } else if (var5.equals("M000089")) {
            this.M000089();
         } else if (var5.equals("M000090")) {
            this.M000090(var2);
         } else if (var5.equals("M000091")) {
            this.M000091(var2);
         } else if (var5.equals("M000092")) {
            this.M000092(var2);
         } else if (var5.equals("M000093")) {
            this.M000093();
         } else if (var5.equals("M000094")) {
            this.M000094(var2);
         } else if (var5.equals("M000095")) {
            this.M000095();
         } else if (var5.equals("M000096")) {
            this.M000096(var2);
         } else if (var5.equals("M000097")) {
            this.M000097(var2);
         } else if (var5.equals("M000098")) {
            this.M000098(var2);
         } else if (var5.equals("M000099")) {
            this.M000099(var2);
         } else if (var5.equals("M000100")) {
            this.M000100(var2);
         } else if (var5.equals("M000101")) {
            this.M000101(var2);
         } else if (var5.equals("M000102")) {
            this.M000102(var2);
         } else if (var5.equals("M000103")) {
            this.M000103(var2);
         } else if (var5.equals("M000104")) {
            this.M000104(var2);
         } else if (var5.equals("M000105")) {
            this.M000105(var2);
         } else if (var5.equals("M000106")) {
            this.M000106(var2);
         } else if (var5.equals("M000107")) {
            this.M000107(var2);
         } else if (var5.equals("M000108")) {
            this.M000108(var2);
         } else if (var5.equals("M000109")) {
            this.M000109(var2);
         } else if (var5.equals("M000110")) {
            this.M000110(var2);
         } else if (var5.equals("M000111")) {
            this.M000111(var2);
         } else if (var5.equals("M000112")) {
            this.M000112(var2);
         } else if (var5.equals("M000113")) {
            this.M000113(var2);
         } else if (var5.equals("M000114")) {
            this.M000114(var2);
         } else if (var5.equals("M000115")) {
            this.M000115(var2);
         } else if (var5.equals("M000116")) {
            this.M000116(var2);
         } else if (var5.equals("M000117")) {
            this.M000117(var2);
         } else if (var5.equals("M000118")) {
            this.M000118(var2);
         } else if (var5.equals("M000119")) {
            this.M000119(var2);
         } else if (var5.equals("M000120")) {
            this.M000120(var2);
         } else if (var5.equals("M000121")) {
            this.M000121(var2);
         } else if (var5.equals("M000122")) {
            this.M000122(var2);
         } else if (var5.equals("M000123")) {
            this.M000123(var2);
         } else if (var5.equals("M000124")) {
            this.M000124(var2);
         } else if (var5.equals("M000125")) {
            this.M000125(var2);
         } else if (var5.equals("M000126")) {
            this.M000126(var2);
         } else if (var5.equals("M000127")) {
            this.M000127(var2);
         } else if (var5.equals("M000128")) {
            this.M000128(var2);
         } else if (var5.equals("M000129")) {
            this.M000129(var2);
         } else if (var5.equals("M000130")) {
            this.M000130();
         } else if (var5.equals("M000131")) {
            this.M000131();
         } else if (var5.equals("M000132")) {
            this.M000132();
         } else if (var5.equals("M000133")) {
            this.M000133();
         } else if (var5.equals("M000134")) {
            this.M000134(var2);
         } else if (var5.equals("M000135")) {
            this.M000135(var2);
         } else if (var5.equals("M000136")) {
            this.M000136(var2);
         } else if (var5.equals("M000137")) {
            this.M000137(var2);
         } else if (var5.equals("M000138")) {
            this.M000138(var2);
         } else if (var5.equals("M000139")) {
            this.M000139(var2);
         } else if (var5.equals("M000140")) {
            this.M000140(var2);
         } else if (var5.equals("M000141")) {
            this.M000141(var2);
         } else if (var5.equals("M000142")) {
            this.M000142(var2);
         } else if (var5.equals("M000143")) {
            this.M000143(var2);
         } else if (var5.equals("M000144")) {
            this.M000144(var2);
         } else if (var5.equals("M000145")) {
            this.M000145(var2);
         } else if (var5.equals("M000146")) {
            this.M000146(var2);
         } else if (var5.equals("M000147")) {
            this.M000147();
         } else if (var5.equals("M000148")) {
            this.M000148(var2);
         } else if (var5.equals("M000149")) {
            this.M000149(var2);
         } else if (var5.equals("M000150")) {
            this.M000150(var2);
         } else if (var5.equals("M000151")) {
            this.M000151(var2);
         } else if (var5.equals("M000152")) {
            this.M000152(var2);
         } else if (var5.equals("M000153")) {
            this.M000153();
         } else if (var5.equals("M000154")) {
            this.M000154();
         } else if (var5.equals("M000155")) {
            this.M000155();
         } else if (var5.equals("M000156")) {
            this.M000156();
         } else if (var5.equals("M000157")) {
            this.M000157();
         } else if (var5.equals("M000158")) {
            this.M000158();
         } else if (var5.equals("M000159")) {
            this.M000159(var2);
         } else if (var5.equals("M000160")) {
            this.M000160(var2);
         } else if (var5.equals("M000161")) {
            this.M000161(var2);
         } else if (var5.equals("M000162")) {
            this.M000162(var2);
         } else if (var5.equals("M000163")) {
            this.M000163(var2);
         } else if (var5.equals("M000164")) {
            this.M000164(var2);
         } else if (var5.equals("M000165")) {
            this.M000165(var2);
         } else if (var5.equals("M000166")) {
            this.M000166(var2);
         } else if (var5.equals("M000167")) {
            this.M000167(var2);
         } else if (var5.equals("M000168")) {
            this.M000168(var2);
         } else if (!var5.equals("M000169") && !var5.equals("M000170") && !var5.equals("M000171") && !var5.equals("M000172") && !var5.equals("M000173") && !var5.equals("M000174") && !var5.equals("M000175") && !var5.equals("M000176") && !var5.equals("M000177") && !var5.equals("M000178")) {
            if (var5.equals("M000179")) {
               this.M000179(var2);
            } else if (var5.equals("M000180")) {
               this.M000180(var2);
            } else if (var5.equals("M000181")) {
               this.M000181(var2);
            } else if (var5.equals("M000182")) {
               this.M000182(var2);
            } else if (var5.equals("M000183")) {
               this.M000183(var2);
            } else if (var5.equals("M000184")) {
               this.M000184(var2);
            } else if (var5.equals("M000185")) {
               this.M000185(var2);
            } else if (var5.equals("M000186")) {
               this.M000186(var2);
            } else if (var5.equals("M000187")) {
               this.M000187(var2);
            } else if (var5.equals("M000188")) {
               this.M000188(var2);
            } else if (var5.equals("M000189")) {
               this.M000189(var2);
            } else if (var5.equals("M000190")) {
               this.M000190(var2);
            } else if (var5.equals("M000191")) {
               this.M000191(var2);
            } else if (var5.equals("M000192")) {
               this.M000192(var2);
            } else if (var5.equals("M000193")) {
               this.M000193(var2);
            } else if (var5.equals("M000194")) {
               this.M000194(var2);
            } else if (var5.equals("M000195")) {
               this.M000195(var2);
            } else if (var5.equals("M000196")) {
               this.M000196(var2);
            } else if (var5.equals("M000197")) {
               this.M000197(var2);
            } else if (var5.equals("M000198")) {
               this.M000198(var2);
            } else if (var5.equals("M000199")) {
               this.M000199(var2);
            } else if (var5.equals("M000200")) {
               this.M000200(var2);
            } else if (var5.equals("M000201")) {
               this.M000201(var2);
            } else if (var5.equals("M000202")) {
               this.M000202(var2);
            } else if (var5.equals("M000203")) {
               this.M000203(var2);
            } else if (var5.equals("M000204")) {
               this.M000204(var2);
            } else if (var5.equals("M000205")) {
               this.M000205(var2);
            } else if (var5.equals("M000206")) {
               this.M000206(var2);
            } else if (var5.equals("M000207")) {
               this.M000207(var2);
            } else if (var5.equals("M000208")) {
               this.M000208(var2);
            } else if (var5.equals("M000209")) {
               this.M000209(var2);
            } else if (var5.equals("M000210")) {
               this.M000210(var2);
            } else if (var5.equals("M000211")) {
               this.M000211(var2);
            } else if (var5.equals("M000212")) {
               this.M000212(var2);
            } else if (var5.equals("M000213")) {
               this.M000213(var2);
            } else if (var5.equals("M000214")) {
               this.M000214(var2);
            } else if (var5.equals("M000215")) {
               this.M000215(var2);
            } else if (var5.equals("M000216")) {
               this.M000216(var2);
            } else if (var5.equals("M000217")) {
               this.M000217(var2);
            } else if (var5.equals("M000218")) {
               this.M000218(var2);
            } else if (var5.equals("M000219")) {
               this.M000219(var2);
            } else if (var5.equals("M000220")) {
               this.M000220(var2);
            } else if (var5.equals("M000221")) {
               this.M000221(var2);
            } else if (var5.equals("M000222")) {
               this.M000222(var2);
            } else if (var5.equals("M000223")) {
               this.M000223(var2);
            } else if (var5.equals("M000224")) {
               this.M000224(var2);
            } else if (var5.equals("M000225")) {
               this.M000225();
            } else if (var5.equals("M000226")) {
               this.M000226();
            } else if (var5.equals("M000227")) {
               this.M000227();
            } else if (var5.equals("M000228")) {
               this.M000228(var2);
            } else if (var5.equals("M000229")) {
               this.M000229(var2);
            } else if (var5.equals("M000230")) {
               this.M000230(var2);
            } else if (var5.equals("M000231")) {
               this.M000231(var2);
            } else if (var5.equals("M000232")) {
               this.M000232(var2);
            } else if (var5.equals("M000233")) {
               this.M000233(var2);
            } else if (var5.equals("M000234")) {
               this.M000234(var2);
            } else if (var5.equals("M000235")) {
               this.M000235(var2);
            } else if (var5.equals("M000236")) {
               this.M000236(var2);
            } else if (var5.equals("M000237")) {
               this.M000237(var2);
            } else if (var5.equals("M000238")) {
               this.M000238(var2);
            } else if (var5.equals("M000239")) {
               this.M000239(var2);
            } else if (var5.equals("M000240")) {
               this.M000240(var2);
            } else if (var5.equals("M000241")) {
               this.M000241(var2);
            } else if (var5.equals("M000242")) {
               this.M000242(var2);
            } else if (var5.equals("M000243")) {
               this.M000243(var2);
            } else if (var5.equals("M000244")) {
               this.M000244(var2);
            } else if (var5.equals("M000245")) {
               this.M000245(var2);
            } else if (var5.equals("M000246")) {
               this.M000246(var2);
            }
         }
      } else {
         this.valeur = 0.0D;
      }

   }

   public void calculSAL(String var1) {
      if (this.feuilleCalculFormule.getFeurubforFormule().contains("saleleEtat")) {
         this.valeur = (double)this.salariesElements.getSaleleEtat();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("saleleGenre")) {
         this.valeur = (double)this.salariesElements.getSaleleGenre();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("saleleSitFamille")) {
         this.valeur = (double)this.salariesElements.getSaleleSitFamille();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("saleleNbEnfant")) {
         this.valeur = (double)this.salariesElements.getSaleleNbEnfant();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("saleleNbPartFiscal")) {
         this.valeur = (double)this.salariesElements.getSaleleNbPartFiscal();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("saleleNbFemme")) {
         this.valeur = (double)this.salariesElements.getSaleleNbFemme();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("saleleNbPartTrimf")) {
         this.valeur = (double)this.salariesElements.getSaleleNbPartTrimf();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("saleleNbJourCp")) {
         this.valeur = (double)this.salariesElements.getSaleleNbJourCp();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("saleleNbJourTr")) {
         this.valeur = (double)this.salariesElements.getSaleleNbJourTr();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("saleleFeuille")) {
         this.valeur = Double.parseDouble(this.salariesElements.getSaleleFeuille());
      } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("salconPrimeRendement")) {
         this.valeur = this.salariesContrats.getSalconPrimeRendement();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("salconPrimeResponsabilite")) {
         this.valeur = this.salariesContrats.getSalconPrimeResponsabilite();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("salconPrimeFonction")) {
         this.valeur = this.salariesContrats.getSalconPrimeFonction();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("salconIndemniteCaisse")) {
         this.valeur = this.salariesContrats.getSalconIndemniteCaisse();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("salconIndemniteTransport")) {
         this.valeur = this.salariesContrats.getSalconIndemniteTransport();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("salconIndemniteLogement")) {
         this.valeur = this.salariesContrats.getSalconIndemniteLogement();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("salconAvnLogement")) {
         this.valeur = this.salariesContrats.getSalconIndemniteLogement();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("salconAvnDomesticite")) {
         this.valeur = this.salariesContrats.getSalconAvnDomesticite();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("salconAvnEau")) {
         this.valeur = this.salariesContrats.getSalconAvnEau();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("salconAvnElectricite")) {
         this.valeur = this.salariesContrats.getSalconAvnElectricite();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("salconAvnNourriture")) {
         this.valeur = this.salariesContrats.getSalconAvnNourriture();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("salconAvnVehicule")) {
         this.valeur = this.salariesContrats.getSalconAvnVehicule();
      } else if (this.feuilleCalculFormule.getFeurubforFormule().contains("salconAvnTelephone")) {
         this.valeur = this.salariesContrats.getSalconAvnTelephone();
      }

   }

   public void calculVAR(String var1) {
      for(int var2 = 0; var2 < this.lesVariables.size(); ++var2) {
         if (((SalariesVariables)this.lesVariables.get(var2)).getSalvarCode().equals(this.bulletinLigne.getBulligRubrique())) {
            if (var1.equals("A")) {
               this.valeur = ((SalariesVariables)this.lesVariables.get(var2)).getSalvarValeurColA();
            } else if (var1.equals("B")) {
               this.valeur = ((SalariesVariables)this.lesVariables.get(var2)).getSalvarValeurColB();
            } else if (var1.equals("C")) {
               this.valeur = ((SalariesVariables)this.lesVariables.get(var2)).getSalvarValeurColC();
            } else if (var1.equals("D")) {
               this.valeur = ((SalariesVariables)this.lesVariables.get(var2)).getSalvarValeurColD();
            } else if (var1.equals("E")) {
               this.valeur = ((SalariesVariables)this.lesVariables.get(var2)).getSalvarValeurColE();
            }
            break;
         }
      }

   }

   public void selectionBulletin() {
      if (this.dataModelListeBulletins.isRowAvailable()) {
         this.bulletinSalaire = (BulletinSalaire)this.dataModelListeBulletins.getRowData();
      } else {
         this.bulletinSalaire = null;
      }

   }

   public void impressionBulletin() {
      if (this.bulletinSalaire != null) {
      }

   }

   public void cloturePeriode() throws HibernateException, NamingException, ParseException {
      if (this.lesBulletins.size() != 0) {
         int var1 = 0;
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            var2.setFlushMode(FlushMode.MANUAL);
            int var4 = Integer.parseInt(this.optionPaye.getTriAgents());
            Object var5 = new ArrayList();
            if (this.modeRepartition == 0) {
               var5 = this.feuilleCalculRubriqueDao.chargerRubriqueFeuille(this.feuilleCalcul, var2);
            }

            String[] var6 = this.bulletinMois.getBulmenPeriode().split(":");
            Date var7 = this.utilDate.stringToDateSQLLight(var6[1] + "-" + var6[0] + "-01");
            Date var8 = this.utilDate.dateMoisSuivant(var7);
            String var9 = this.formatPeriode(var8);

            for(int var10 = 0; var10 < this.lesBulletins.size(); ++var10) {
               this.bulletinSalaire = (BulletinSalaire)this.lesBulletins.get(var10);
               this.salaries = this.bulletinSalaire.getSalaries();
               if (this.salaries.getSalEtat() <= 1) {
                  this.lesVariables.clear();
                  this.lesVariables = this.salariesVariablesDao.chargerlesVariablesPeriode(this.salaries, var9, this.bulletinSalaire.getBulsalContrat(), var2);
                  if (this.lesVariables.size() == 0) {
                     this.lesVariables = this.salariesVariablesDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), this.bulletinSalaire.getBulsalContrat(), var2);
                     if (this.lesVariables.size() != 0) {
                        for(int var11 = 0; var11 < this.lesVariables.size(); ++var11) {
                           this.salariesVariables = (SalariesVariables)this.lesVariables.get(var11);
                           SalariesVariables var12 = new SalariesVariables();
                           var12.setPlanPaye(this.salariesVariables.getPlanPaye());
                           var12.setSalaries(this.salariesVariables.getSalaries());
                           var12.setSalvarCode(this.salariesVariables.getSalvarCode());
                           var12.setSalvarFeuille(this.salariesVariables.getSalvarFeuille());
                           var12.setSalvarContrat(this.salariesVariables.getSalvarContrat());
                           var12.setSalvarPeriode(var9);
                           boolean var13 = false;
                           if (this.modeRepartition == 1) {
                              ((List)var5).clear();
                              this.feuilleCalcul = this.feuilleCalculDao.chercherCode(this.salaries.getSalFeuille(), this.exercicesPaye.getExepayId(), var2);
                              if (this.feuilleCalcul != null) {
                                 var5 = this.feuilleCalculRubriqueDao.chargerRubriqueFeuille(this.feuilleCalcul, var2);
                              }
                           } else if (this.modeRepartition == 2) {
                              ((List)var5).clear();
                              this.feuilleCalcul = this.feuilleCalculDao.chercherCode(this.salaries.getSalService(), this.exercicesPaye.getExepayId(), var2);
                              if (this.feuilleCalcul != null) {
                                 var5 = this.feuilleCalculRubriqueDao.chargerRubriqueFeuille(this.feuilleCalcul, var2);
                              }
                           } else if (this.modeRepartition == 3) {
                              ((List)var5).clear();
                              this.feuilleCalcul = this.feuilleCalculDao.chercherCode(this.salaries.getSalFeuille(), this.exercicesPaye.getExepayId(), var2);
                              if (this.feuilleCalcul != null) {
                                 var5 = this.feuilleCalculRubriqueDao.chargerRubriqueFeuille(this.feuilleCalcul, var2);
                              }
                           } else if (this.modeRepartition == 4) {
                              ((List)var5).clear();
                              this.feuilleCalcul = this.feuilleCalculDao.chercherCode(this.salaries.getSalFeuille(), this.exercicesPaye.getExepayId(), var2);
                              if (this.feuilleCalcul != null) {
                                 var5 = this.feuilleCalculRubriqueDao.chargerRubriqueFeuille(this.feuilleCalcul, var2);
                              }
                           }

                           for(int var14 = 0; var14 < ((List)var5).size(); ++var14) {
                              this.feuilleCalculRubrique = (FeuilleCalculRubrique)((List)var5).get(var14);
                              if (this.feuilleCalculRubrique.getFeurubCode().equals(this.salariesVariables.getSalvarCode())) {
                                 var13 = true;
                                 if (this.feuilleCalculRubrique.isFeurubColARaz()) {
                                    var12.setSalvarValeurColA(0.0D);
                                 } else {
                                    var12.setSalvarValeurColA(this.salariesVariables.getSalvarValeurColA());
                                 }

                                 if (this.feuilleCalculRubrique.isFeurubColBRaz()) {
                                    var12.setSalvarValeurColB(0.0D);
                                 } else {
                                    var12.setSalvarValeurColB(this.salariesVariables.getSalvarValeurColB());
                                 }

                                 if (this.feuilleCalculRubrique.isFeurubColCRaz()) {
                                    var12.setSalvarValeurColC(0.0D);
                                 } else {
                                    var12.setSalvarValeurColC(this.salariesVariables.getSalvarValeurColC());
                                 }

                                 if (this.feuilleCalculRubrique.isFeurubColDRaz()) {
                                    var12.setSalvarValeurColD(0.0D);
                                 } else {
                                    var12.setSalvarValeurColD(this.salariesVariables.getSalvarValeurColD());
                                 }

                                 if (this.feuilleCalculRubrique.isFeurubColERaz()) {
                                    var12.setSalvarValeurColE(0.0D);
                                 } else {
                                    var12.setSalvarValeurColE(this.salariesVariables.getSalvarValeurColE());
                                 }
                                 break;
                              }
                           }

                           if (!var13) {
                              var12.setSalvarValeurColA(this.salariesVariables.getSalvarValeurColA());
                              var12.setSalvarValeurColB(this.salariesVariables.getSalvarValeurColB());
                              var12.setSalvarValeurColC(this.salariesVariables.getSalvarValeurColC());
                              var12.setSalvarValeurColD(this.salariesVariables.getSalvarValeurColD());
                              var12.setSalvarValeurColE(this.salariesVariables.getSalvarValeurColE());
                           }

                           var12.setSalvarVariableA(this.salariesVariables.isSalvarVariableA());
                           var12.setSalvarVariableB(this.salariesVariables.isSalvarVariableB());
                           var12.setSalvarVariableC(this.salariesVariables.isSalvarVariableC());
                           var12.setSalvarVariableD(this.salariesVariables.isSalvarVariableD());
                           var12.setSalvarVariableE(this.salariesVariables.isSalvarVariableE());
                           new SalariesVariables();
                           SalariesVariables var26 = this.salariesVariablesDao.chargerlesVariablesPeriodeRubrique(this.salaries, var9, this.salariesVariables.getSalvarContrat(), this.salariesVariables.getSalvarCode(), var2);
                           if (var26 == null) {
                              this.salariesVariablesDao.insert(var12, var2);
                           }

                           ++var1;
                           if (var1 == this.cptMaxFlush) {
                              var2.flush();
                              var1 = 0;
                           }
                        }

                        var2.flush();
                     }
                  }

                  this.salariesElements = this.salariesElementsDao.chargerlesVariablesPeriode(this.salaries, var9, this.bulletinSalaire.getBulsalContrat(), var2);
                  if (this.salariesElements == null) {
                     this.salariesElements = this.salariesElementsDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), this.bulletinSalaire.getBulsalContrat(), var2);
                     if (this.salariesElements != null) {
                        SalariesElements var22 = new SalariesElements();
                        var22.setSalaries(this.salaries);
                        var22.setSaleleContrat(this.salariesElements.getSaleleContrat());
                        var22.setSaleleActivite(this.salariesElements.getSaleleActivite());
                        var22.setSaleleBudget(this.salariesElements.getSaleleBudget());
                        var22.setSaleleCentresImpots(this.salariesElements.getSaleleCentresImpots());
                        var22.setSaleleCentresSecurite(this.salariesElements.getSaleleCentresSecurite());
                        var22.setSaleleCivilite(this.salariesElements.getSaleleCivilite());
                        var22.setSaleleClassement(this.salariesElements.getSaleleClassement());
                        var22.setSaleleConvention(this.salariesElements.getSaleleConvention());
                        var22.setSaleleDateConcubinage(this.salariesElements.getSaleleDateConcubinage());
                        var22.setSaleleDateDivorce(this.salariesElements.getSaleleDateDivorce());
                        var22.setSaleleDateMarie(this.salariesElements.getSaleleDateMarie());
                        var22.setSaleleDatePacs(this.salariesElements.getSaleleDatePacs());
                        var22.setSaleleDateEntree(this.salariesElements.getSaleleDateEntree());
                        var22.setSaleleDateSortie(this.salariesElements.getSaleleDateSortie());
                        var22.setSaleleDateVeuf(this.salariesElements.getSaleleDateVeuf());
                        var22.setSaleleDepartement(this.salariesElements.getSaleleDepartement());
                        var22.setSaleleEtat(this.salariesElements.getSaleleEtat());
                        var22.setSaleleFeuille(this.salariesElements.getSaleleFeuille());
                        var22.setSaleleFonction(this.salariesElements.getSaleleFonction());
                        var22.setSaleleGenre(this.salariesElements.getSaleleGenre());
                        var22.setSaleleGrille(this.salariesElements.getSaleleGrille());
                        var22.setSaleleLibCentresImpots(this.salariesElements.getSaleleLibCentresImpots());
                        var22.setSaleleLibCentresSecurite(this.salariesElements.getSaleleLibCentresSecurite());
                        var22.setSaleleLibClassement(this.salariesElements.getSaleleLibClassement());
                        var22.setSaleleLibConvention(this.salariesElements.getSaleleLibConvention());
                        var22.setSaleleLibGrille(this.salariesElements.getSaleleLibGrille());
                        var22.setSaleleLibNivEmploi(this.salariesElements.getSaleleLibNivEmploi());
                        var22.setSaleleMatricule(this.salariesElements.getSaleleMatricule());
                        var22.setSaleleMotifSortie(this.salariesElements.getSaleleMotifSortie());
                        var22.setSaleleNature(this.salariesElements.getSaleleNature());
                        var22.setSaleleNbEnfant(this.salariesElements.getSaleleNbEnfant());
                        var22.setSaleleNbFemme(this.salariesElements.getSaleleNbFemme());
                        var22.setSaleleNbJourCp(this.salariesElements.getSaleleNbJourCp());
                        var22.setSaleleNbJourTr(this.salariesElements.getSaleleNbJourTr());
                        var22.setSaleleNbPartFiscal(this.salariesElements.getSaleleNbPartFiscal());
                        var22.setSaleleNbPartTrimf(this.salariesElements.getSaleleNbPartTrimf());
                        var22.setSaleleNivEmploi(this.salariesElements.getSaleleNivEmploi());
                        var22.setSaleleParc(this.salariesElements.getSaleleParc());
                        var22.setSalelePeriode(var9);
                        var22.setSaleleService(this.salariesElements.getSaleleService());
                        var22.setSaleleLibService(this.salariesElements.getSaleleLibService());
                        var22.setSaleleSitFamille(this.salariesElements.getSaleleSitFamille());
                        var22.setSaleleSite(this.salariesElements.getSaleleSite());
                        var22.setSaleleModeReglement(this.salariesElements.getSaleleModeReglement());
                        var22.setSaleleNumBanque(this.salariesElements.getSaleleNumBanque());
                        var22.setSaleleGuichetBanque(this.salariesElements.getSaleleGuichetBanque());
                        var22.setSaleleCompteBanque(this.salariesElements.getSaleleCompteBanque());
                        var22.setSaleleCleBanque(this.salariesElements.getSaleleCleBanque());
                        var22.setSaleleIban(this.salariesElements.getSaleleIban());
                        var22.setSaleleSwift(this.salariesElements.getSaleleSwift());
                        var22.setSaleleCompteMembre(this.salariesElements.getSaleleCompteMembre());
                        this.salariesElementsDao.insert(var22, var2);
                        var2.flush();
                     }
                  }

                  new ArrayList();
                  String[] var24 = this.bulletinMois.getBulmenPeriode().split(":");
                  Date var25 = this.utilDate.stringToDateSQLLight(var24[1] + "-" + var24[0] + "-01");
                  Date var27 = this.utilDate.datePremierJourMois(var25);
                  Date var15 = this.utilDate.dateDernierJourMois(var25);
                  List var23 = this.salariesContratsDao.listelesContratsActif(this.salaries, var27, var15, var2);
                  if (var23.size() != 0) {
                     for(int var16 = 0; var16 < var23.size(); ++var16) {
                        this.salariesContrats = (SalariesContrats)var23.get(var16);
                        if (this.salariesContrats.getSalconDateFin() != null && this.salariesContrats.getSalconDateFin().getMonth() == var15.getMonth() && this.salariesContrats.getSalconDateFin().getYear() == var15.getYear()) {
                           if (this.salariesContrats.getSalconEtat() <= 1) {
                              this.salariesContrats.setSalconEtat(6);
                           }

                           this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats, var2);
                           var2.flush();
                           this.salaries = this.salariesDao.chercherIdSalaries(this.salaries.getSalId(), var2);
                           if (this.salaries != null) {
                              this.salaries.setSalEtat(this.salariesContrats.getSalconEtat());
                              this.salaries = this.salariesDao.modif(this.salaries, var2);
                              var2.flush();
                           }
                        }
                     }
                  }
               }
            }

            if (this.bulletinMois != null) {
               this.bulletinMois.setBulmenUserIdJournal(0L);
               this.bulletinMois.setBulmenOpenUserJournal("");
               this.bulletinMois.setBulmenOpenJournal(0);
               this.bulletinMois.setBulmenUserIdGeneration(0L);
               this.bulletinMois.setBulmenOpenUserGeneration("");
               this.bulletinMois.setBulmenOpenGeneration(0);
               if (this.bulletinMois.getBulmenEtat() == 2) {
                  this.bulletinMois.setBulmenEtat(3);
               }

               this.bulletinMois = this.bulletinMoisDao.majJournal(this.bulletinMois, var2);
               var2.flush();
            }

            this.afficheTJM = false;
            this.var_action = 0;
            var3.commit();
         } catch (HibernateException var20) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var20;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void verrouillerBulletin() throws HibernateException, NamingException, ParseException {
      if (this.lesBulletins.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesBulletins.size(); ++var3) {
               this.bulletinSalaire = (BulletinSalaire)this.lesBulletins.get(var3);
               this.bulletinSalaire = this.bulletinSalaireDao.pourParapheur(this.bulletinSalaire.getBulsalId(), var1);
               if (this.bulletinSalaire != null) {
                  this.bulletinSalaire.setBulsalEtatBulletin(true);
                  this.bulletinSalaire.setObservations("BULLETIN VERROUILLE");
                  this.bulletinSalaire.setBulsalUserModif(this.usersLog.getUsrid());
                  this.bulletinSalaire = this.bulletinSalaireDao.modif(this.bulletinSalaire, var1);
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

         this.chagerSalarieGeneration();
      }

   }

   public void deVerrouillerBulletin() throws HibernateException, NamingException, ParseException {
      if (this.lesBulletins.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesBulletins.size(); ++var3) {
               this.bulletinSalaire = (BulletinSalaire)this.lesBulletins.get(var3);
               this.bulletinSalaire = this.bulletinSalaireDao.pourParapheur(this.bulletinSalaire.getBulsalId(), var1);
               if (this.bulletinSalaire != null) {
                  this.bulletinSalaire.setBulsalEtatBulletin(false);
                  this.bulletinSalaire.setObservations("");
                  this.bulletinSalaire.setBulsalUserModif(this.usersLog.getUsrid());
                  this.bulletinSalaire = this.bulletinSalaireDao.modif(this.bulletinSalaire, var1);
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

         this.chagerSalarieGeneration();
      }

   }

   public void nouvelleGenerationJournalier() throws HibernateException, NamingException, ParseException {
      if (this.feuilleCalcul != null) {
         this.var_info = "Initialisation en cours...";
         this.var_currentValue = 0;
         this.lesBulletins.clear();
         this.lesBulletinsLigne.clear();
         this.dateGeneration = this.bulletinMois.getBulmenJour();
         this.d1 = this.dateGeneration;
         this.d2 = this.dateGeneration;
         this.d1Reel = this.dateGeneration;
         this.d2Reel = this.dateGeneration;
         int var1 = 0;
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var3 = null;

         List var4;
         int var5;
         int var6;
         try {
            var3 = var2.beginTransaction();
            var2.setFlushMode(FlushMode.MANUAL);
            this.var_info = "Suppression ancienne generation...";
            new ArrayList();
            var5 = Integer.parseInt(this.optionPaye.getTriAgents());
            var4 = this.bulletinSalaireDao.chargerlesBulletinsbyFeuilleJour(this.feuilleCalcul.getFeuCode(), var5, this.bulletinMois.getBulmenJour(), this.var_service_rec, var2);
            if (var4.size() != 0) {
               for(var6 = 0; var6 < var4.size(); ++var6) {
                  this.bulletinSalaire = (BulletinSalaire)var4.get(var6);
                  if (this.bulletinSalaire != null) {
                     new ArrayList();
                     List var7 = this.bulletinLigneDao.chargerleslignesBulletin(this.bulletinSalaire, var2);
                     if (var7.size() != 0) {
                        for(int var8 = 0; var8 < var7.size(); ++var8) {
                           this.bulletinLigne = (BulletinLigne)var7.get(var8);
                           this.bulletinLigneDao.delete(this.bulletinLigne, var2);
                           var2.flush();
                        }
                     }

                     this.bulletinSalaireDao.delete(this.bulletinSalaire, var2);
                     ++var1;
                     var2.flush();
                  }
               }
            }

            var3.commit();
         } catch (HibernateException var24) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var24;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         var4 = null;

         try {
            Transaction var26 = var2.beginTransaction();
            var2.setFlushMode(FlushMode.MANUAL);
            this.lesRubriques.clear();
            this.lesRubriques = this.feuilleCalculRubriqueDao.chargerRubriqueFeuilleActive(this.feuilleCalcul, this.exercicesPaye.getExepayId(), var2);
            if (this.lesRubriques.size() != 0) {
               this.verificationPrecalcul(var2);
               this.lesSalaries.clear();
               this.lesElements.clear();
               var5 = Integer.parseInt(this.optionPaye.getTriAgents());
               this.lesElements = this.salariesElementsDao.chargerlesElementsByJournaliers(this.bulletinMois.getBulmenJour(), var5, this.bulletinMois.getBulmenFeuille(), var2);
               if (this.lesElements.size() != 0) {
                  for(var6 = 0; var6 < this.lesElements.size(); ++var6) {
                     this.salariesElements = (SalariesElements)this.lesElements.get(var6);
                     this.salaries = this.salariesElements.getSalaries();
                     this.var_info = "Calcul du salarie : " + this.salaries.getSalNom();
                     if (var6 != 0) {
                        double var27 = (double)this.lesElements.size();
                        double var9 = this.utilNombre.myRound(var27 / (double)var6, 4);
                        double var11 = this.utilNombre.myRound(100.0D / var9, 2);
                        this.var_currentValue = (int)var11;
                     }

                     this.lesVariables.clear();
                     this.lesAbsences.clear();
                     this.lesConges.clear();
                     this.lesPretsLignes.clear();
                     this.lesHistoriques.clear();
                     this.montantSursalaire = 0.0D;
                     this.absenceSurConges = 0.0F;
                     this.absenceSurReposMaladie = 0.0F;
                     this.lesVariables = this.salariesVariablesDao.chargerlesVariablesDate(this.salaries, this.bulletinMois.getBulmenJour(), var2);
                     if (this.lesVariables.size() != 0) {
                        if (this.salariesElements != null) {
                           if (this.salariesElements.getSaleleEtat() != 9) {
                              this.verificationNBenfants(var2);
                              this.salariesCapitalisation = null;
                              this.salariesContrats = null;
                              this.lesBulletinsLigne.clear();
                              this.bulletinSalaire = new BulletinSalaire();
                              this.bulletinSalaire.setBulsalActivite(this.salariesElements.getSaleleActivite());
                              this.bulletinSalaire.setBulsalBudget(this.salariesElements.getSaleleBudget());
                              this.bulletinSalaire.setBulsalCentresImpots(this.salariesElements.getSaleleCentresImpots());
                              this.bulletinSalaire.setBulsalCentresSecurite(this.salariesElements.getSaleleCentresSecurite());
                              this.bulletinSalaire.setBulsalCivilite(this.salariesElements.getSaleleCivilite());
                              this.bulletinSalaire.setBulsalClassement(this.salariesElements.getSaleleClassement());
                              this.bulletinSalaire.setBulsalConvention(this.salariesElements.getSaleleConvention());
                              this.bulletinSalaire.setBulsalContrat("");
                              this.bulletinSalaire.setBulsalDateDebut(this.dateGeneration);
                              this.bulletinSalaire.setBulsalDateFin(this.dateGeneration);
                              this.bulletinSalaire.setBulsalDateentree((Date)null);
                              this.bulletinSalaire.setBulsalDateSortie((Date)null);
                              this.bulletinSalaire.setBulsalDepartement(this.salariesElements.getSaleleDepartement());
                              this.bulletinSalaire.setBulsalEtat(this.salariesElements.getSaleleEtat());
                              this.bulletinSalaire.setBulsalFeuille(this.salariesElements.getSaleleFeuille());
                              this.bulletinSalaire.setBulsalFonction(this.salariesElements.getSaleleFonction());
                              this.bulletinSalaire.setBulsalSecu1(this.salaries.getSalNumSecu());
                              if (!this.structureLog.getStrcodepays().equals("0029") && !this.structureLog.getStrcodepays().equals("0041") && !this.structureLog.getStrcodepays().equals("0050") && !this.structureLog.getStrcodepays().equals("0056")) {
                                 if (this.structureLog.getStrcodepays().equals("0077")) {
                                    this.bulletinSalaire.setBulsalSecu2(this.salaries.getSalNumCnamgs());
                                 } else if (!this.structureLog.getStrcodepays().equals("0078") && !this.structureLog.getStrcodepays().equals("0088") && !this.structureLog.getStrcodepays().equals("0089") && !this.structureLog.getStrcodepays().equals("0090")) {
                                    if (this.structureLog.getStrcodepays().equals("0138")) {
                                       this.bulletinSalaire.setBulsalSecu2(this.salaries.getSalNumAmo());
                                    } else {
                                       this.bulletinSalaire.setBulsalSecu2("");
                                    }
                                 }
                              }

                              this.bulletinSalaire.setBulsalGenre(this.salariesElements.getSaleleGenre());
                              this.bulletinSalaire.setBulsalGrille(this.salariesElements.getSaleleGrille());
                              this.bulletinSalaire.setBulsalLibCentresImpots(this.salariesElements.getSaleleLibCentresImpots());
                              this.bulletinSalaire.setBulsalLibCentresSecurite(this.salariesElements.getSaleleLibCentresSecurite());
                              this.bulletinSalaire.setBulsalLibClassement(this.salariesElements.getSaleleLibClassement());
                              this.bulletinSalaire.setBulsalLibConvention(this.salariesElements.getSaleleLibConvention());
                              this.bulletinSalaire.setBulsalLibGrille(this.salariesElements.getSaleleLibGrille());
                              this.bulletinSalaire.setBulsalLibNivEmploi(this.salariesElements.getSaleleLibNivEmploi());
                              this.bulletinSalaire.setBulsalLocalisation(this.salariesElements.getSaleleLocalisation());
                              this.bulletinSalaire.setBulsalMatricule(this.salariesElements.getSaleleMatricule());
                              this.bulletinSalaire.setBulsalMotifSortie(this.salariesElements.getSaleleMotifSortie());
                              this.bulletinSalaire.setBulsalNature(this.salariesElements.getSaleleNature());
                              this.bulletinSalaire.setBulsalNbEnfant(this.salariesElements.getSaleleNbEnfant());
                              this.bulletinSalaire.setBulsalNbFemme(this.salariesElements.getSaleleNbFemme());
                              this.bulletinSalaire.setBulsalNbJourCp(this.salariesElements.getSaleleNbJourCp());
                              this.bulletinSalaire.setBulsalNbJourTr(this.salariesElements.getSaleleNbJourTr());
                              this.bulletinSalaire.setBulsalNbPartFiscal(this.salariesElements.getSaleleNbPartFiscal());
                              this.bulletinSalaire.setBulsalNbPartTrimf(this.salariesElements.getSaleleNbPartTrimf());
                              this.bulletinSalaire.setBulsalNivEmploi(this.salariesElements.getSaleleNivEmploi());
                              this.bulletinSalaire.setBulsalParc(this.salariesElements.getSaleleParc());
                              this.bulletinSalaire.setBulsalPeriode(this.utilDate.dateToPeriodeFr(this.dateGeneration));
                              this.bulletinSalaire.setBulsalService(this.salariesElements.getSaleleService());
                              this.bulletinSalaire.setBulsalLibService(this.salariesElements.getSaleleLibService());
                              this.bulletinSalaire.setBulsalSitFamille(this.salariesElements.getSaleleSitFamille());
                              this.bulletinSalaire.setBulsalSite(this.salariesElements.getSaleleSite());
                              this.bulletinSalaire.setBulsalCle1Anal(this.salariesElements.getSaleleCle1Anal());
                              this.bulletinSalaire.setBulsalCle2Anal(this.salariesElements.getSaleleCle2Anal());
                              this.bulletinSalaire.setBulsalModeReglement(this.salariesElements.getSaleleModeReglement());
                              this.bulletinSalaire.setBulsalNumBanque(this.salariesElements.getSaleleNumBanque());
                              this.bulletinSalaire.setBulsalGuichetBanque(this.salariesElements.getSaleleGuichetBanque());
                              this.bulletinSalaire.setBulsalCompteBanque(this.salariesElements.getSaleleCompteBanque());
                              this.bulletinSalaire.setBulsalCleBanque(this.salariesElements.getSaleleCleBanque());
                              this.bulletinSalaire.setBulsalIban(this.salariesElements.getSaleleIban());
                              this.bulletinSalaire.setBulsalSwift(this.salariesElements.getSaleleSwift());
                              this.bulletinSalaire.setBulsalCompteMembre(this.salariesElements.getSaleleCompteMembre());
                              this.bulletinSalaire.setExercicesPaye(this.exercicesPaye);
                              this.bulletinSalaire.setSalaries(this.salaries);
                              this.bulletinSalaire.setBulsalUserCreat(this.usersLog.getUsrid());
                              this.bulletinSalaire = this.bulletinSalaireDao.insert(this.bulletinSalaire, var2);
                              this.netAAtteindre = 0.0D;
                              this.generationBulletinJournalier(var2);
                              var2.flush();
                              this.lesBulletins.add(this.bulletinSalaire);
                           } else {
                              this.bulletinSalaire = new BulletinSalaire();
                              this.bulletinSalaire.setObservations("LE JOURNALIER EST GELE");
                              this.bulletinSalaire.setBulsalMatricule(this.salariesElements.getSaleleMatricule());
                              this.bulletinSalaire.setSalaries(this.salaries);
                              this.bulletinSalaire.setBulsalEtat(9);
                              this.lesBulletins.add(this.bulletinSalaire);
                           }
                        } else {
                           this.bulletinSalaire = new BulletinSalaire();
                           this.bulletinSalaire.setObservations("PAS D`ELEMENTS JOURNLIERS");
                           this.bulletinSalaire.setBulsalMatricule(this.salariesElements.getSaleleMatricule());
                           this.bulletinSalaire.setSalaries(this.salaries);
                           this.lesBulletins.add(this.bulletinSalaire);
                        }
                     } else {
                        this.bulletinSalaire = new BulletinSalaire();
                        this.bulletinSalaire.setObservations("PAS DE VARIABLES JOURNALIERS");
                        this.bulletinSalaire.setBulsalMatricule(this.salariesElements.getSaleleMatricule());
                        this.bulletinSalaire.setSalaries(this.salaries);
                        this.lesBulletins.add(this.bulletinSalaire);
                     }
                  }
               } else {
                  this.bulletinSalaire = new BulletinSalaire();
                  this.bulletinSalaire.setObservations("PAS DE JOURNALIERS POUR CETTE PERIODE");
                  this.bulletinSalaire.setBulsalMatricule(this.salariesElements.getSaleleMatricule());
                  this.bulletinSalaire.setSalaries(this.salaries);
                  this.lesBulletins.add(this.bulletinSalaire);
               }

               this.dataModelLesBulletins.setWrappedData(this.lesBulletins);
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
      }

      if (this.bulletinMois.getBulmenEtat() <= 2) {
         if (this.bulletinMois.getBulmenEtat() == 1) {
            this.bulletinMois.setBulmenEtat(2);
         }

         this.bulletinMois = this.bulletinMoisDao.majJournal(this.bulletinMois);
      }

      this.var_affiche_bouton = false;
   }

   public void selectionRegenerationJournalier() throws HibernateException, NamingException {
      this.modeSelection = 0;
      this.libelleSelection = "SELECTION DU/DES JOURNALIER(S)";
      int var1 = Integer.parseInt(this.optionPaye.getTriAgents());
      this.dateGeneration = this.bulletinMois.getBulmenJour();
      this.d1 = this.dateGeneration;
      this.d2 = this.dateGeneration;
      this.d1Reel = this.dateGeneration;
      this.d2Reel = this.dateGeneration;
      this.lesSalaries.clear();
      new ArrayList();
      List var2 = this.salariesElementsDao.chargerlesElementsByJournaliers(this.dateGeneration, var1, this.bulletinMois.getBulmenFeuille(), (Session)null);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.lesSalaries.add(((SalariesElements)var2.get(var3)).getSalaries());
         }

         if (this.lesSalaries.size() != 0) {
            this.datamodelSalaries.setWrappedData(this.lesSalaries);
            this.salaries = null;
            this.showModalPanelSalaries = true;
         }
      }

   }

   public void generationBulletinJournalier(Session var1) throws HibernateException, NamingException, ParseException {
      if (this.d1 != null && this.d2 != null) {
         this.calculBulletinJournalier(var1);
         this.calculEnteteBulletinJournalier(var1);
      }

   }

   public void regenerationSurListeJournalier() throws HibernateException, NamingException, ParseException {
      this.showModalPanelSalaries = false;
      if (this.lesSalaries.size() != 0) {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.lesSalaries.size(); ++var2) {
            this.salaries = (Salaries)this.lesSalaries.get(var2);
            if (this.salaries.isSelect_agent()) {
               var1 = true;
               if (this.salaries != null) {
                  this.bulletinSalaire = null;
                  long var3 = 0L;
                  String var5 = this.salaries.getSalMatricule();
                  int var6 = 0;

                  for(int var7 = 0; var7 < this.lesBulletins.size(); ++var7) {
                     this.bulletinSalaire = (BulletinSalaire)this.lesBulletins.get(var7);
                     if (this.bulletinSalaire.getBulsalMatricule().equals(var5)) {
                        var3 = this.bulletinSalaire.getBulsalId();
                        var6 = var7;
                        break;
                     }
                  }

                  this.var_info = "Initialisation en cours...";
                  this.var_currentValue = 0;
                  this.lesBulletinsLigne.clear();
                  this.dateGeneration = this.bulletinMois.getBulmenJour();
                  this.d1 = this.dateGeneration;
                  this.d2 = this.dateGeneration;
                  this.d1Reel = this.dateGeneration;
                  this.d2Reel = this.dateGeneration;
                  boolean var21 = true;
                  int var8 = 0;
                  if (var3 != 0L) {
                     Session var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
                     Transaction var10 = null;

                     try {
                        var10 = var9.beginTransaction();
                        var9.setFlushMode(FlushMode.MANUAL);
                        this.var_info = "Suppression ancienne generation...";
                        new ArrayList();

                        for(int var12 = 0; var12 < this.lesBulletins.size(); ++var12) {
                           this.bulletinSalaire = (BulletinSalaire)this.lesBulletins.get(var12);
                           long var13 = this.bulletinSalaire.getBulsalId();
                           if (this.bulletinSalaire.getBulsalMatricule().equals(this.salaries.getSalMatricule())) {
                              List var11 = this.bulletinLigneDao.chargerleslignesBulletin(this.bulletinSalaire, var9);
                              if (var11.size() != 0) {
                                 for(int var15 = 0; var15 < var11.size(); ++var15) {
                                    this.bulletinLigne = (BulletinLigne)var11.get(var15);
                                    this.bulletinLigneDao.delete(this.bulletinLigne, var9);
                                    var9.flush();
                                 }
                              }

                              this.bulletinSalaire = this.bulletinSalaireDao.pourParapheur(var13, var9);
                              if (this.bulletinSalaire != null) {
                                 this.bulletinSalaireDao.delete(this.bulletinSalaire, var9);
                              }

                              ++var8;
                              var9.flush();
                           }
                        }

                        this.bulletinSalaire = null;
                        var10.commit();
                     } catch (HibernateException var19) {
                        var21 = false;
                        if (var10 != null) {
                           var10.rollback();
                        }

                        throw var19;
                     } finally {
                        this.utilInitHibernate.closeSession();
                     }
                  } else {
                     var21 = true;
                  }

                  if (var21) {
                     this.reGenerationBulletinJournalier(var6);
                  }
               }
            }
         }

         if (var1 && this.bulletinMois.getBulmenEtat() <= 2) {
            if (this.bulletinMois.getBulmenEtat() == 1) {
               this.bulletinMois.setBulmenEtat(2);
            }

            this.bulletinMois = this.bulletinMoisDao.majJournal(this.bulletinMois);
         }
      }

      this.var_affiche_bouton = false;
   }

   public void reGenerationBulletinJournalier(int var1) throws HibernateException, NamingException, ParseException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.setFlushMode(FlushMode.MANUAL);
         this.lesRubriques.clear();
         this.lesRubriques = this.feuilleCalculRubriqueDao.chargerRubriqueFeuilleActive(this.feuilleCalcul, this.exercicesPaye.getExepayId(), var2);
         if (this.lesRubriques.size() != 0) {
            this.verificationPrecalcul(var2);
            this.var_info = "Calcul du salarie : " + this.salaries.getSalNom();
            this.var_currentValue = 1;
            new ArrayList();
            List var4 = this.salariesElementsDao.chargerlesElementsByJournaliers(this.salaries, this.dateGeneration, this.bulletinMois.getBulmenFeuille(), var2);
            if (var4.size() != 0) {
               for(int var5 = 0; var5 < var4.size(); ++var5) {
                  this.salariesElements = (SalariesElements)var4.get(var5);
                  this.lesVariables.clear();
                  this.lesAbsences.clear();
                  this.lesConges.clear();
                  this.lesPretsLignes.clear();
                  this.lesHistoriques.clear();
                  this.montantSursalaire = 0.0D;
                  this.absenceSurConges = 0.0F;
                  this.absenceSurReposMaladie = 0.0F;
                  this.lesVariables = this.salariesVariablesDao.chargerlesVariablesDate(this.salaries, this.bulletinMois.getBulmenJour(), var2);
                  if (this.lesVariables.size() != 0) {
                     if (this.salariesElements != null) {
                        if (this.salariesElements.getSaleleEtat() != 9) {
                           this.verificationNBenfants(var2);
                           this.salariesCapitalisation = null;
                           this.salariesContrats = null;
                           this.lesBulletinsLigne.clear();
                           this.bulletinSalaire = new BulletinSalaire();
                           this.bulletinSalaire.setBulsalActivite(this.salariesElements.getSaleleActivite());
                           this.bulletinSalaire.setBulsalBudget(this.salariesElements.getSaleleBudget());
                           this.bulletinSalaire.setBulsalCentresImpots(this.salariesElements.getSaleleCentresImpots());
                           this.bulletinSalaire.setBulsalCentresSecurite(this.salariesElements.getSaleleCentresSecurite());
                           this.bulletinSalaire.setBulsalCivilite(this.salariesElements.getSaleleCivilite());
                           this.bulletinSalaire.setBulsalClassement(this.salariesElements.getSaleleClassement());
                           this.bulletinSalaire.setBulsalConvention(this.salariesElements.getSaleleConvention());
                           this.bulletinSalaire.setBulsalContrat("");
                           this.bulletinSalaire.setBulsalProjet("");
                           this.bulletinSalaire.setBulsalDateDebut(this.dateGeneration);
                           this.bulletinSalaire.setBulsalDateFin(this.dateGeneration);
                           this.bulletinSalaire.setBulsalDateentree((Date)null);
                           this.bulletinSalaire.setBulsalDateSortie((Date)null);
                           this.bulletinSalaire.setBulsalDepartement(this.salariesElements.getSaleleDepartement());
                           this.bulletinSalaire.setBulsalEtat(this.salariesElements.getSaleleEtat());
                           this.bulletinSalaire.setBulsalFeuille(this.salariesElements.getSaleleFeuille());
                           this.bulletinSalaire.setBulsalFonction(this.salariesElements.getSaleleFonction());
                           this.bulletinSalaire.setBulsalSecu1(this.salaries.getSalNumSecu());
                           if (!this.structureLog.getStrcodepays().equals("0029") && !this.structureLog.getStrcodepays().equals("0041") && !this.structureLog.getStrcodepays().equals("0050") && !this.structureLog.getStrcodepays().equals("0056")) {
                              if (this.structureLog.getStrcodepays().equals("0077")) {
                                 this.bulletinSalaire.setBulsalSecu2(this.salaries.getSalNumCnamgs());
                              } else if (!this.structureLog.getStrcodepays().equals("0078") && !this.structureLog.getStrcodepays().equals("0088") && !this.structureLog.getStrcodepays().equals("0089") && !this.structureLog.getStrcodepays().equals("0090")) {
                                 if (this.structureLog.getStrcodepays().equals("0138")) {
                                    this.bulletinSalaire.setBulsalSecu2(this.salaries.getSalNumAmo());
                                 } else {
                                    this.bulletinSalaire.setBulsalSecu2("");
                                 }
                              }
                           }

                           this.bulletinSalaire.setBulsalGenre(this.salariesElements.getSaleleGenre());
                           this.bulletinSalaire.setBulsalGrille(this.salariesElements.getSaleleGrille());
                           this.bulletinSalaire.setBulsalLibCentresImpots(this.salariesElements.getSaleleLibCentresImpots());
                           this.bulletinSalaire.setBulsalLibCentresSecurite(this.salariesElements.getSaleleLibCentresSecurite());
                           this.bulletinSalaire.setBulsalLibClassement(this.salariesElements.getSaleleLibClassement());
                           this.bulletinSalaire.setBulsalLibConvention(this.salariesElements.getSaleleLibConvention());
                           this.bulletinSalaire.setBulsalLibGrille(this.salariesElements.getSaleleLibGrille());
                           this.bulletinSalaire.setBulsalLibNivEmploi(this.salariesElements.getSaleleLibNivEmploi());
                           this.bulletinSalaire.setBulsalLocalisation(this.salariesElements.getSaleleLocalisation());
                           this.bulletinSalaire.setBulsalMatricule(this.salariesElements.getSaleleMatricule());
                           this.bulletinSalaire.setBulsalMotifSortie(this.salariesElements.getSaleleMotifSortie());
                           this.bulletinSalaire.setBulsalNature(this.salariesElements.getSaleleNature());
                           this.bulletinSalaire.setBulsalNbEnfant(this.salariesElements.getSaleleNbEnfant());
                           this.bulletinSalaire.setBulsalNbFemme(this.salariesElements.getSaleleNbFemme());
                           this.bulletinSalaire.setBulsalNbJourCp(this.salariesElements.getSaleleNbJourCp());
                           this.bulletinSalaire.setBulsalNbJourTr(this.salariesElements.getSaleleNbJourTr());
                           this.bulletinSalaire.setBulsalNbPartFiscal(this.salariesElements.getSaleleNbPartFiscal());
                           this.bulletinSalaire.setBulsalNbPartTrimf(this.salariesElements.getSaleleNbPartTrimf());
                           this.bulletinSalaire.setBulsalNivEmploi(this.salariesElements.getSaleleNivEmploi());
                           this.bulletinSalaire.setBulsalParc(this.salariesElements.getSaleleParc());
                           this.bulletinSalaire.setBulsalPeriode(this.utilDate.dateToPeriodeFr(this.dateGeneration));
                           this.bulletinSalaire.setBulsalService(this.salariesElements.getSaleleService());
                           this.bulletinSalaire.setBulsalLibService(this.salariesElements.getSaleleLibService());
                           this.bulletinSalaire.setBulsalSitFamille(this.salariesElements.getSaleleSitFamille());
                           this.bulletinSalaire.setBulsalSite(this.salariesElements.getSaleleSite());
                           this.bulletinSalaire.setBulsalCle1Anal(this.salariesElements.getSaleleCle1Anal());
                           this.bulletinSalaire.setBulsalCle2Anal(this.salariesElements.getSaleleCle2Anal());
                           this.bulletinSalaire.setBulsalModeReglement(this.salariesElements.getSaleleModeReglement());
                           this.bulletinSalaire.setBulsalNumBanque(this.salariesElements.getSaleleNumBanque());
                           this.bulletinSalaire.setBulsalGuichetBanque(this.salariesElements.getSaleleGuichetBanque());
                           this.bulletinSalaire.setBulsalCompteBanque(this.salariesElements.getSaleleCompteBanque());
                           this.bulletinSalaire.setBulsalCleBanque(this.salariesElements.getSaleleCleBanque());
                           this.bulletinSalaire.setBulsalIban(this.salariesElements.getSaleleIban());
                           this.bulletinSalaire.setBulsalSwift(this.salariesElements.getSaleleSwift());
                           this.bulletinSalaire.setBulsalCompteMembre(this.salariesElements.getSaleleCompteMembre());
                           this.bulletinSalaire.setExercicesPaye(this.exercicesPaye);
                           this.bulletinSalaire.setSalaries(this.salaries);
                           this.bulletinSalaire.setBulsalUserCreat(this.usersLog.getUsrid());
                           this.bulletinSalaire = this.bulletinSalaireDao.insert(this.bulletinSalaire, var2);
                           this.netAAtteindre = 0.0D;
                           this.generationBulletinJournalier(var2);
                           var2.flush();
                           this.gestionListe();
                        } else {
                           this.bulletinSalaire = new BulletinSalaire();
                           this.bulletinSalaire.setObservations("LE JOURNALIER EST GELE");
                           this.bulletinSalaire.setBulsalMatricule(this.salariesElements.getSaleleMatricule());
                           this.bulletinSalaire.setSalaries(this.salaries);
                           this.bulletinSalaire.setBulsalEtat(9);
                           this.gestionListe();
                        }
                     } else {
                        this.bulletinSalaire = new BulletinSalaire();
                        this.bulletinSalaire.setObservations("PAS D`ELEMENTS JOURNALIERS");
                        this.bulletinSalaire.setBulsalMatricule(this.salariesElements.getSaleleMatricule());
                        this.bulletinSalaire.setSalaries(this.salaries);
                        this.gestionListe();
                     }
                  } else {
                     this.bulletinSalaire = new BulletinSalaire();
                     this.bulletinSalaire.setObservations("PAS DE VARIABLES JOURNALIERS");
                     this.bulletinSalaire.setBulsalMatricule(this.salariesElements.getSaleleMatricule());
                     this.bulletinSalaire.setSalaries(this.salaries);
                     this.gestionListe();
                  }
               }
            } else {
               this.bulletinSalaire = new BulletinSalaire();
               this.bulletinSalaire.setObservations("PAS DE JOURNALIERS POUR CETTE PERIODE");
               this.bulletinSalaire.setBulsalMatricule(this.salariesElements.getSaleleMatricule());
               this.bulletinSalaire.setSalaries(this.salaries);
               this.gestionListe();
            }
         }

         this.dataModelLesBulletins.setWrappedData(this.lesBulletins);
         var3.commit();
      } catch (HibernateException var9) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_affiche_bouton = false;
   }

   public void calculBulletinJournalier(Session var1) throws HibernateException, NamingException, ParseException {
      if (this.bulletinSalaire != null) {
         this.majLigne = true;

         for(int var2 = 0; var2 < this.lesRubriques.size(); ++var2) {
            this.ligneEnCours = var2;
            this.calculRubrique = (FeuilleCalculRubrique)this.lesRubriques.get(var2);
            this.preCalcul = false;
            this.calculBulletinLigne(var1);
         }
      }

   }

   public void calculEnteteBulletinJournalier(Session var1) throws HibernateException, NamingException, ParseException {
      float var2 = 0.0F;
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
      double var25 = 0.0D;
      double var27 = 0.0D;
      float var29 = 0.0F;
      float var30 = 0.0F;
      float var31 = 0.0F;
      double var32 = 0.0D;
      double var34 = 0.0D;
      if (this.lesBulletinsLigne.size() != 0) {
         new BulletinLigne();

         for(int var37 = 0; var37 < this.lesBulletinsLigne.size(); ++var37) {
            BulletinLigne var36 = (BulletinLigne)this.lesBulletinsLigne.get(var37);
            if (var36.getBulligNature() == 50) {
               var3 += var36.getBulligValColE();
            } else if (var36.getBulligNature() == 59) {
               var34 = var36.getBulligValColE();
            } else if (var36.getBulligNature() == 40) {
               var7 += var36.getBulligValColE();
            } else if (var36.getBulligNature() == 89) {
               var32 += var36.getBulligValColE();
            } else if (var36.getBulligRubrique() != null && !var36.getBulligRubrique().isEmpty() && !this.structureLog.getStrcodepays().equals("0029") && !this.structureLog.getStrcodepays().equals("0041") && !this.structureLog.getStrcodepays().equals("0050") && !this.structureLog.getStrcodepays().equals("0056") && !this.structureLog.getStrcodepays().equals("0077") && !this.structureLog.getStrcodepays().equals("0078") && !this.structureLog.getStrcodepays().equals("0088") && !this.structureLog.getStrcodepays().equals("0089") && !this.structureLog.getStrcodepays().equals("0090")) {
               if (this.structureLog.getStrcodepays().equals("0138")) {
                  if (var36.getBulligRubrique().equals("100000")) {
                     var2 = (float)((double)var2 + var36.getBulligValColD());
                  } else if (var36.getBulligRubrique().equals("100050")) {
                     var2 = (float)((double)var2 - var36.getBulligValColD());
                  } else if (var36.getBulligRubrique().startsWith("300010")) {
                     var9 += var36.getBulligValColE();
                  } else if (!var36.getBulligRubrique().startsWith("300020") && !var36.getBulligRubrique().startsWith("300021") && !var36.getBulligRubrique().startsWith("300022") && !var36.getBulligRubrique().startsWith("300023") && !var36.getBulligRubrique().startsWith("300024") && !var36.getBulligRubrique().startsWith("300025") && !var36.getBulligRubrique().startsWith("300026") && !var36.getBulligRubrique().startsWith("300027") && !var36.getBulligRubrique().startsWith("300028") && !var36.getBulligRubrique().startsWith("300029")) {
                     if (var36.getBulligRubrique().startsWith("300220")) {
                        var13 += var36.getBulligValColE();
                     } else if (var36.getBulligRubrique().startsWith("900020")) {
                        var15 += var36.getBulligValColE();
                     } else if (!var36.getBulligRubrique().startsWith("900040") && !var36.getBulligRubrique().startsWith("900041") && !var36.getBulligRubrique().startsWith("900042") && !var36.getBulligRubrique().startsWith("900043") && !var36.getBulligRubrique().startsWith("900044") && !var36.getBulligRubrique().startsWith("900045") && !var36.getBulligRubrique().startsWith("900046") && !var36.getBulligRubrique().startsWith("900047") && !var36.getBulligRubrique().startsWith("900048") && !var36.getBulligRubrique().startsWith("900049")) {
                        var19 = 0.0D;
                        var21 = 0.0D;
                        var23 = 0.0D;
                        var25 = 0.0D;
                        var27 = 0.0D;
                     } else {
                        var17 += var36.getBulligValColE();
                     }
                  } else {
                     var11 += var36.getBulligValColE();
                  }
               } else if (!this.structureLog.getStrcodepays().equals("0142")) {
                  if (this.structureLog.getStrcodepays().equals("0202")) {
                     if (var36.getBulligRubrique().equals("100000")) {
                        var2 = (float)((double)var2 + var36.getBulligValColD());
                     } else if (var36.getBulligRubrique().equals("100050")) {
                        var2 = (float)((double)var2 - var36.getBulligValColD());
                     } else if (!var36.getBulligRubrique().startsWith("300000") && !var36.getBulligRubrique().startsWith("300010") && !var36.getBulligRubrique().startsWith("300020")) {
                        if (var36.getBulligRubrique().startsWith("300100")) {
                           var11 += var36.getBulligValColE();
                        } else if (!var36.getBulligRubrique().startsWith("300200") && !var36.getBulligRubrique().startsWith("300220")) {
                           if (var36.getBulligRubrique().startsWith("300300")) {
                              var15 += var36.getBulligValColE();
                           } else {
                              var17 = 0.0D;
                              var19 = 0.0D;
                              var21 = 0.0D;
                              var23 = 0.0D;
                              var25 = 0.0D;
                              var27 = 0.0D;
                           }
                        } else {
                           var13 += var36.getBulligValColE();
                        }
                     } else {
                        var9 += var36.getBulligValColE();
                     }
                  } else if (!this.structureLog.getStrcodepays().equals("0222")) {
                     if (var36.getBulligRubrique().equals("100000")) {
                        var2 = (float)((double)var2 + var36.getBulligValColD());
                     } else if (var36.getBulligRubrique().equals("100050")) {
                        var2 = (float)((double)var2 - var36.getBulligValColD());
                     } else {
                        var9 = 0.0D;
                        var11 = 0.0D;
                        var13 = 0.0D;
                        var15 = 0.0D;
                        var17 = 0.0D;
                        var19 = 0.0D;
                        var21 = 0.0D;
                        var23 = 0.0D;
                        var25 = 0.0D;
                        var27 = 0.0D;
                     }
                  }
               }
            }
         }
      }

      this.bulletinSalaire.setBulsalAvNat(var3);
      this.bulletinSalaire.setBulsalBaseImposableFiscale(this.calculBaseImposasableFiscaleEnCours(var1));
      this.bulletinSalaire.setBulsalBaseImposableSociale(this.calculBaseImposasableSocialeEnCours(var1));
      this.bulletinSalaire.setBulsalImpot1(var9);
      this.bulletinSalaire.setBulsalImpot2(var11);
      this.bulletinSalaire.setBulsalImpot3(var13);
      this.bulletinSalaire.setBulsalImpot4(var15);
      this.bulletinSalaire.setBulsalImpot5(var17);
      this.bulletinSalaire.setBulsalImpot6(var19);
      this.bulletinSalaire.setBulsalImpot7(var21);
      this.bulletinSalaire.setBulsalImpot8(var23);
      this.bulletinSalaire.setBulsalImpot9(var25);
      this.bulletinSalaire.setBulsalImpot10(var27);
      this.bulletinSalaire.setBulsalTypeCP(0);
      this.bulletinSalaire.setBulsalCP(0.0D);
      this.salariesElements.setSaleleNbJourTr(0.0F);
      this.salariesElements.setSaleleNbJourCp(0.0F);
      this.bulletinSalaire.setBulsalNetPayer(var32);
      this.bulletinSalaire.setBulsalNature(this.salariesElements.getSaleleNature());
      this.bulletinSalaire.setBulsalEtat(this.salariesElements.getSaleleEtat());
      this.bulletinSalaire.setBulsalCivilite(this.salariesElements.getSaleleCivilite());
      this.bulletinSalaire.setBulsalFonction(this.salariesElements.getSaleleFonction());
      this.bulletinSalaire.setBulsalSecu1(this.salaries.getSalNumSecu());
      if (!this.structureLog.getStrcodepays().equals("0029") && !this.structureLog.getStrcodepays().equals("0041") && !this.structureLog.getStrcodepays().equals("0050") && !this.structureLog.getStrcodepays().equals("0056")) {
         if (this.structureLog.getStrcodepays().equals("0077")) {
            this.bulletinSalaire.setBulsalSecu2(this.salaries.getSalNumCnamgs());
         } else if (!this.structureLog.getStrcodepays().equals("0078") && !this.structureLog.getStrcodepays().equals("0088") && !this.structureLog.getStrcodepays().equals("0089") && !this.structureLog.getStrcodepays().equals("0090")) {
            if (this.structureLog.getStrcodepays().equals("0138")) {
               this.bulletinSalaire.setBulsalSecu2(this.salaries.getSalNumAmo());
            } else {
               this.bulletinSalaire.setBulsalSecu2("");
            }
         }
      }

      this.bulletinSalaire.setBulsalSite(this.salariesElements.getSaleleSite());
      this.bulletinSalaire.setBulsalDepartement(this.salariesElements.getSaleleDepartement());
      this.bulletinSalaire.setBulsalService(this.salariesElements.getSaleleService());
      this.bulletinSalaire.setBulsalLibService(this.salariesElements.getSaleleLibService());
      this.bulletinSalaire.setBulsalActivite(this.salariesElements.getSaleleActivite());
      this.bulletinSalaire.setBulsalBudget(this.salariesElements.getSaleleBudget());
      this.bulletinSalaire.setBulsalParc(this.salariesElements.getSaleleParc());
      this.bulletinSalaire.setBulsalGenre(this.salariesElements.getSaleleGenre());
      this.bulletinSalaire.setBulsalSitFamille(this.salariesElements.getSaleleSitFamille());
      this.bulletinSalaire.setBulsalNbEnfant(this.salariesElements.getSaleleNbEnfant());
      this.bulletinSalaire.setBulsalNbPartFiscal(this.salariesElements.getSaleleNbPartFiscal());
      this.bulletinSalaire.setBulsalNbFemme(this.salariesElements.getSaleleNbFemme());
      this.bulletinSalaire.setBulsalNbPartTrimf(this.salariesElements.getSaleleNbPartTrimf());
      this.bulletinSalaire.setBulsalMotifSortie(this.salariesElements.getSaleleMotifSortie());
      this.bulletinSalaire.setBulsalConvention(this.salariesElements.getSaleleConvention());
      this.bulletinSalaire.setBulsalLibConvention(this.salariesElements.getSaleleLibConvention());
      this.bulletinSalaire.setBulsalCentresImpots(this.salariesElements.getSaleleCentresImpots());
      this.bulletinSalaire.setBulsalLibCentresImpots(this.salariesElements.getSaleleLibCentresImpots());
      this.bulletinSalaire.setBulsalCentresSecurite(this.salariesElements.getSaleleCentresSecurite());
      this.bulletinSalaire.setBulsalLibCentresSecurite(this.salariesElements.getSaleleLibCentresSecurite());
      this.bulletinSalaire.setBulsalClassement(this.salariesElements.getSaleleClassement());
      this.bulletinSalaire.setBulsalLibClassement(this.salariesElements.getSaleleLibClassement());
      this.bulletinSalaire.setBulsalNivEmploi(this.salariesElements.getSaleleNivEmploi());
      this.bulletinSalaire.setBulsalLibNivEmploi(this.salariesElements.getSaleleLibNivEmploi());
      this.bulletinSalaire.setBulsalLocalisation(this.salariesElements.getSaleleLocalisation());
      this.bulletinSalaire.setBulsalGrille(this.salariesElements.getSaleleGrille());
      this.bulletinSalaire.setBulsalCle1Anal(this.salariesElements.getSaleleCle1Anal());
      this.bulletinSalaire.setBulsalCle2Anal(this.salariesElements.getSaleleCle2Anal());
      this.bulletinSalaire.setBulsalModeReglement(this.salariesElements.getSaleleModeReglement());
      this.bulletinSalaire.setBulsalNumBanque(this.salariesElements.getSaleleNumBanque());
      this.bulletinSalaire.setBulsalGuichetBanque(this.salariesElements.getSaleleGuichetBanque());
      this.bulletinSalaire.setBulsalCompteBanque(this.salariesElements.getSaleleCompteBanque());
      this.bulletinSalaire.setBulsalCleBanque(this.salariesElements.getSaleleCleBanque());
      this.bulletinSalaire.setBulsalIban(this.salariesElements.getSaleleIban());
      this.bulletinSalaire.setBulsalSwift(this.salariesElements.getSaleleSwift());
      this.bulletinSalaire.setBulsalCompteMembre(this.salariesElements.getSaleleCompteMembre());
      this.bulletinSalaire.setBulsalIdTiers(0L);
   }

   public void cloturePeriodeJournalier() throws HibernateException, NamingException, ParseException {
      if (this.lesBulletins.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            if (this.bulletinMois != null) {
               this.bulletinMois.setBulmenUserIdJournal(0L);
               this.bulletinMois.setBulmenOpenUserJournal("");
               this.bulletinMois.setBulmenOpenJournal(0);
               this.bulletinMois.setBulmenUserIdGeneration(0L);
               this.bulletinMois.setBulmenOpenUserGeneration("");
               this.bulletinMois.setBulmenOpenGeneration(0);
               if (this.bulletinMois.getBulmenEtat() == 2) {
                  this.bulletinMois.setBulmenEtat(3);
               }

               this.bulletinMois = this.bulletinMoisDao.majJournal(this.bulletinMois, var1);
            }

            this.afficheTJM = false;
            this.var_action = 0;
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

   public void simulation() throws ParseException {
      this.salaries = new Salaries();
      this.salariesConges = new SalariesConges();
      this.salariesContrats = new SalariesContrats();
      this.salariesElements = new SalariesElements();
      this.salariesPrets = new SalariesPrets(this.mesNaturesPretsItems);
      this.salariesVariables = new SalariesVariables();
      this.bulletinSalaire = new BulletinSalaire();
      this.bulletinLigne = new BulletinLigne();
      this.dataModelBulletinsLigne = new ListDataModel();
      this.bulletinSalaireDao = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
      this.bulletinLigneDao = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
      this.feuilleCalcul = new FeuilleCalcul();
      this.bulletinMois = new BulletinMois();
      this.bulletinMois.setBulmenPeriode("00:0000");
      this.lesVariables = new ArrayList();
      this.dataModelVariables = new ListDataModel();
      this.lesRubriques = new ArrayList();
      this.datamodelRubriques = new ListDataModel();
      this.lesSalariesGrh = new ArrayList();
      this.lesformules = new ArrayList();
      this.feuilleCalculDao = new FeuilleCalculDao(this.baseLog, this.utilInitHibernate);
      this.feuilleCalculFormuleDao = new FeuilleCalculFormuleDao(this.baseLog, this.utilInitHibernate);
      this.feuilleCalculRubriqueDao = new FeuilleCalculRubriqueDao(this.baseLog, this.utilInitHibernate);
      this.lesConges = new ArrayList();
      this.lesAbsences = new ArrayList();
      this.lesPretsLignes = new ArrayList();
      this.lesBulletins = new ArrayList();
      this.lesBulletinsLigne = new ArrayList();
      this.mesGrillesItems = new ArrayList();
      this.lesHistoriques = new ArrayList();
      this.salariesCapitalisation = new SalariesCapitalisation();
      this.dateGeneration = this.utilDate.stringToDateSQLLight((new Date()).getYear() + 1900 + "-01" + "-01");
      this.d1 = this.utilDate.datePremierJourMois(this.dateGeneration);
      this.d2 = this.utilDate.dateDernierJourMois(this.dateGeneration);
      this.d1Reel = this.utilDate.datePremierJourMois(this.dateGeneration);
      this.d2Reel = this.utilDate.dateDernierJourMois(this.dateGeneration);
      this.var_action = 0;
      this.var_action_contrat = 0;
      this.modeRegularisation = 0;
      this.modePlafond = "0";
   }

   public void razSimulation() {
      this.lesVariables.clear();
      this.dataModelVariables.setWrappedData(this.lesVariables);
      this.lesRubriques.clear();
      this.datamodelRubriques.setWrappedData(this.lesRubriques);
      this.lesSalariesGrh.clear();
      this.lesformules.clear();
      this.lesConges.clear();
      this.lesAbsences.clear();
      this.lesPretsLignes.clear();
      this.lesBulletins.clear();
      this.lesBulletinsLigne.clear();
      this.mesGrillesItems.clear();
      this.lesHistoriques.clear();
      this.dataModelBulletinsLigne.setWrappedData(this.lesBulletinsLigne);
   }

   public void calculNbPartsSimulation() throws HibernateException, NamingException {
      this.salaries.setSalSitFamille(this.salariesElements.getSaleleSitFamille());
      this.salaries.setSalGenre(this.salariesElements.getSaleleGenre());
      this.lesSalariesGrh = this.salariesGrhDao.chargerlesElementRh(this.salaries, (Session)null);
      if (this.salaries.getSalNature() != null && !this.salaries.getSalNature().isEmpty() && !this.salaries.getSalNature().equals("04") && this.optionPaye.getNbEnfantsFiscaux().equals("0")) {
         this.salariesElements.setSaleleNbEnfant(this.formBakingBeanPaye.calculNbEnfants(this.salaries, this.lesSalariesGrh));
      }

      this.salariesElements.setSaleleNbFemme(this.formBakingBeanPaye.calculNbFemme(this.salaries, this.lesSalariesGrh));
      this.salariesElements.setSaleleNbPartFiscal(this.formBakingBeanPaye.calculNbPartsFiscales(this.salariesElements, this.lesSalariesGrh));
      this.salariesElements.setSaleleNbPartTrimf(this.formBakingBeanPaye.calculNbtrimf(this.salaries, this.lesSalariesGrh));
   }

   public void calculSimulation() throws HibernateException, NamingException, ParseException {
      if (this.salaries != null && this.salariesContrats != null && this.montantAtteindre != 0.0D) {
         if (this.choixCalcul == 0) {
            this.choixResultat = 1;
         } else {
            this.choixResultat = 2;
         }

         this.bulletinSalaire = this.bulletinSalaireDao.rechercheBulletinSalariePeriode(this.salaries.getSalMatricule(), "SIMUL", (Session)null);
         Session var1;
         Transaction var2;
         if (this.bulletinSalaire != null) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
            var2 = null;

            try {
               var2 = var1.beginTransaction();
               var1.setFlushMode(FlushMode.MANUAL);
               this.var_info = "Suppression ancienne generation...";
               new ArrayList();
               List var3 = this.bulletinLigneDao.chargerleslignesBulletin(this.bulletinSalaire, var1);
               new BulletinLigne();

               for(int var5 = 0; var5 < var3.size(); ++var5) {
                  BulletinLigne var4 = (BulletinLigne)var3.get(var5);
                  this.bulletinLigneDao.delete(var4, var1);
               }

               this.bulletinSalaire = this.bulletinSalaireDao.rechercheBulletinSalariePeriode(this.salaries.getSalMatricule(), "SIMUL", var1);
               if (this.bulletinSalaire != null) {
                  this.bulletinSalaireDao.delete(this.bulletinSalaire, var1);
               }

               var2.commit();
            } catch (HibernateException var25) {
               if (var2 != null) {
                  var2.rollback();
               }

               throw var25;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }

         this.montantSursalaire = this.montantAtteindre;
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            this.lesRubriques.clear();
            this.lesRubriques = this.feuilleCalculRubriqueDao.chargerRubriqueFeuilleActive(this.feuilleCalcul, this.exercicesPaye.getExepayId(), var1);
            if (this.lesRubriques.size() == 0) {
               StaticModePegase.setTexte_message("Il n'y a pas de rubrique dans la feuille");
               StaticModePegase.setAffiche_message(true);
            } else {
               this.var_info = "Simulation pour le salarie : " + this.salaries.getSalNom();
               this.var_currentValue = 1;
               this.verificationPrecalcul(var1);
               this.lesVariables.clear();
               this.lesHistoriques.clear();
               if (this.salariesContrats != null) {
                  this.lesVariables = this.salariesVariablesDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), this.salariesContrats.getSalconNum(), var1);
               } else {
                  this.lesVariables = this.salariesVariablesDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), "", var1);
               }

               if (this.lesVariables.size() == 0) {
                  StaticModePegase.setTexte_message("il n'y a pas de variables salaries");
                  StaticModePegase.setAffiche_message(true);
               } else {
                  if (this.salariesContrats != null) {
                     this.salariesElements = this.salariesElementsDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), this.salariesContrats.getSalconNum(), var1);
                  } else {
                     this.salariesElements = this.salariesElementsDao.chargerlesVariablesPeriode(this.salaries, this.bulletinMois.getBulmenPeriode(), "", var1);
                  }

                  if (this.salariesElements == null) {
                     StaticModePegase.setTexte_message("il n'y a pas d'elements salaries");
                     StaticModePegase.setAffiche_message(true);
                  } else {
                     this.verificationNBenfants(var1);
                     this.capitalisationActive = false;
                     this.salariesCapitalisation = null;
                     if (this.salariesContrats != null) {
                        this.lesHistoriques = this.salariesHistoriqueDao.chargerlesHistoriquesBySalaries(this.salaries, this.salariesContrats.getSalconNum(), this.exercicesPaye, var1);
                        if (this.lesHistoriques.size() == 0) {
                           this.lesHistoriques = this.salariesHistoriqueDao.chargerlesHistoriquesBySalaries(this.salaries, "", this.exercicesPaye, var1);
                        }
                     } else {
                        this.lesHistoriques = this.salariesHistoriqueDao.chargerlesHistoriquesBySalaries(this.salaries, "", this.exercicesPaye, var1);
                     }

                     this.lesBulletinsLigne.clear();
                     this.bulletinSalaire = new BulletinSalaire();
                     this.bulletinSalaire.setBulsalActivite(this.salariesElements.getSaleleActivite());
                     this.bulletinSalaire.setBulsalBudget(this.salariesElements.getSaleleBudget());
                     this.bulletinSalaire.setBulsalCentresImpots(this.salariesElements.getSaleleCentresImpots());
                     this.bulletinSalaire.setBulsalCentresSecurite(this.salariesElements.getSaleleCentresSecurite());
                     this.bulletinSalaire.setBulsalCivilite(this.salariesElements.getSaleleCivilite());
                     this.bulletinSalaire.setBulsalClassement(this.salariesElements.getSaleleClassement());
                     this.bulletinSalaire.setBulsalConvention(this.salariesElements.getSaleleConvention());
                     this.bulletinSalaire.setBulsalContrat(this.salariesContrats.getSalconNum());
                     this.d1 = this.utilDate.datePremierJourMois(this.dateGeneration);
                     this.d2 = this.utilDate.dateDernierJourMois(this.dateGeneration);
                     this.bulletinSalaire.setBulsalDateDebut(this.d1);
                     this.bulletinSalaire.setBulsalDateFin(this.d2);
                     if (this.bulletinSalaire.getBulsalDateDebutReel() == null) {
                        this.bulletinSalaire.setBulsalDateDebutReel(this.d1);
                     }

                     if (this.bulletinSalaire.getBulsalDateFinReel() == null) {
                        this.bulletinSalaire.setBulsalDateFinReel(this.d2);
                     }

                     this.bulletinSalaire.setBulsalDateentree(this.salariesContrats.getSalconDateDebut());
                     this.bulletinSalaire.setBulsalDateSortie(this.salariesContrats.getSalconDateFin());
                     this.bulletinSalaire.setBulsalDepartement(this.salariesElements.getSaleleDepartement());
                     this.bulletinSalaire.setBulsalEtat(this.salariesElements.getSaleleEtat());
                     this.bulletinSalaire.setBulsalFeuille(this.salariesElements.getSaleleFeuille());
                     this.bulletinSalaire.setBulsalFonction(this.salariesElements.getSaleleFonction());
                     this.bulletinSalaire.setBulsalSecu1(this.salaries.getSalNumSecu());
                     if (!this.structureLog.getStrcodepays().equals("0029") && !this.structureLog.getStrcodepays().equals("0041") && !this.structureLog.getStrcodepays().equals("0050") && !this.structureLog.getStrcodepays().equals("0056")) {
                        if (this.structureLog.getStrcodepays().equals("0077")) {
                           this.bulletinSalaire.setBulsalSecu2(this.salaries.getSalNumCnamgs());
                        } else if (!this.structureLog.getStrcodepays().equals("0078") && !this.structureLog.getStrcodepays().equals("0088") && !this.structureLog.getStrcodepays().equals("0089") && !this.structureLog.getStrcodepays().equals("0090")) {
                           if (this.structureLog.getStrcodepays().equals("0138")) {
                              this.bulletinSalaire.setBulsalSecu2(this.salaries.getSalNumAmo());
                           } else {
                              this.bulletinSalaire.setBulsalSecu2("");
                           }
                        }
                     }

                     this.bulletinSalaire.setBulsalGenre(this.salariesElements.getSaleleGenre());
                     this.bulletinSalaire.setBulsalGrille(this.salariesElements.getSaleleGrille());
                     this.bulletinSalaire.setBulsalLibCentresImpots(this.salariesElements.getSaleleLibCentresImpots());
                     this.bulletinSalaire.setBulsalLibCentresSecurite(this.salariesElements.getSaleleLibCentresSecurite());
                     this.bulletinSalaire.setBulsalLibClassement(this.salariesElements.getSaleleLibClassement());
                     this.bulletinSalaire.setBulsalLibConvention(this.salariesElements.getSaleleLibConvention());
                     this.bulletinSalaire.setBulsalLibGrille(this.salariesElements.getSaleleLibGrille());
                     this.bulletinSalaire.setBulsalLibNivEmploi(this.salariesElements.getSaleleLibNivEmploi());
                     this.bulletinSalaire.setBulsalLocalisation(this.salariesElements.getSaleleLocalisation());
                     this.bulletinSalaire.setBulsalMatricule(this.salariesElements.getSaleleMatricule());
                     this.bulletinSalaire.setBulsalMotifSortie(this.salariesElements.getSaleleMotifSortie());
                     this.bulletinSalaire.setBulsalNature(this.salariesElements.getSaleleNature());
                     this.bulletinSalaire.setBulsalNbEnfant(this.salariesElements.getSaleleNbEnfant());
                     this.bulletinSalaire.setBulsalNbFemme(this.salariesElements.getSaleleNbFemme());
                     this.bulletinSalaire.setBulsalNbJourCp(this.salariesElements.getSaleleNbJourCp());
                     this.bulletinSalaire.setBulsalNbJourTr(this.salariesElements.getSaleleNbJourTr());
                     this.bulletinSalaire.setBulsalNbPartFiscal(this.salariesElements.getSaleleNbPartFiscal());
                     this.bulletinSalaire.setBulsalNbPartTrimf(this.salariesElements.getSaleleNbPartTrimf());
                     this.bulletinSalaire.setBulsalNivEmploi(this.salariesElements.getSaleleNivEmploi());
                     this.bulletinSalaire.setBulsalParc(this.salariesElements.getSaleleParc());
                     this.bulletinSalaire.setBulsalPeriode(this.bulletinMois.getBulmenPeriode());
                     this.bulletinSalaire.setBulsalService(this.salariesElements.getSaleleService());
                     this.bulletinSalaire.setBulsalLibService(this.salariesElements.getSaleleLibService());
                     this.bulletinSalaire.setBulsalSitFamille(this.salariesElements.getSaleleSitFamille());
                     this.bulletinSalaire.setBulsalSite(this.salariesElements.getSaleleSite());
                     this.bulletinSalaire.setBulsalCle1Anal(this.salariesElements.getSaleleCle1Anal());
                     this.bulletinSalaire.setBulsalCle2Anal(this.salariesElements.getSaleleCle2Anal());
                     this.bulletinSalaire.setBulsalModeReglement(this.salariesElements.getSaleleModeReglement());
                     this.bulletinSalaire.setBulsalNumBanque(this.salariesElements.getSaleleNumBanque());
                     this.bulletinSalaire.setBulsalGuichetBanque(this.salariesElements.getSaleleGuichetBanque());
                     this.bulletinSalaire.setBulsalCompteBanque(this.salariesElements.getSaleleCompteBanque());
                     this.bulletinSalaire.setBulsalCleBanque(this.salariesElements.getSaleleCleBanque());
                     this.bulletinSalaire.setBulsalIban(this.salariesElements.getSaleleIban());
                     this.bulletinSalaire.setBulsalSwift(this.salariesElements.getSaleleSwift());
                     this.bulletinSalaire.setBulsalCompteMembre(this.salariesElements.getSaleleCompteMembre());
                     this.bulletinSalaire.setExercicesPaye(this.exercicesPaye);
                     this.bulletinSalaire.setSalaries(this.salaries);
                     boolean var27 = true;
                     double var28 = 0.0D;
                     double var6 = 0.0D;
                     double var8 = 0.0D;

                     for(int var10 = 0; var10 < 100; ++var10) {
                        this.netAAtteindre = 0.0D;
                        this.generationBulletin(var1);
                        var8 = 0.0D;

                        for(int var11 = 0; var11 < this.lesBulletinsLigne.size(); ++var11) {
                           if (((BulletinLigne)this.lesBulletinsLigne.get(var11)).getBulligRubrique().equals("100030")) {
                              var6 = ((BulletinLigne)this.lesBulletinsLigne.get(var11)).getBulligValColE();
                              if (var6 < 0.0D) {
                                 boolean var12 = false;
                              }
                           }

                           if (((BulletinLigne)this.lesBulletinsLigne.get(var11)).getBulligNature() == 80) {
                              var8 += ((BulletinLigne)this.lesBulletinsLigne.get(var11)).getBulligValColE() * -1.0D;
                           }

                           if (((BulletinLigne)this.lesBulletinsLigne.get(var11)).getBulligRubrique().equals("699999")) {
                              double var29 = ((BulletinLigne)this.lesBulletinsLigne.get(var11)).getBulligValColE() + var8;
                              if (var29 != this.montantAtteindre && var10 != 99) {
                                 this.montantSursalaire += this.montantAtteindre - var29;
                                 var27 = true;
                                 break;
                              }

                              var27 = false;
                              break;
                           }
                        }

                        if (!var27) {
                           this.enregistrementSimulation(var1);
                           this.dataModelBulletinsLigne.setWrappedData(this.lesBulletinsLigne);
                           break;
                        }

                        this.lesBulletinsLigne.clear();
                     }
                  }
               }
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

         if (this.lesBulletinsLigne.size() != 0) {
            this.dataModelBulletinsLigne.setWrappedData(this.lesBulletinsLigne);
         }
      } else {
         this.choixResultat = 0;
         StaticModePegase.setTexte_message("Un salarié doit être sélectionné et le montant à atteindre doit être supérieur à 0!");
         StaticModePegase.setAffiche_message(true);
      }

   }

   public void enregistrementSimulation(Session var1) throws HibernateException, NamingException, ParseException {
      if (this.montantAtteindre != 0.0D && this.lesBulletinsLigne.size() != 0) {
         this.calculEnteteBulletin(var1);
         this.bulletinSalaire.setBulsalPeriode("SIMUL");
         this.bulletinSalaire.setBulsalUserCreat(this.usersLog.getUsrid());
         this.bulletinSalaire = this.bulletinSalaireDao.insert(this.bulletinSalaire, var1);

         for(int var2 = 0; var2 < this.lesBulletinsLigne.size(); ++var2) {
            this.bulletinLigne = (BulletinLigne)this.lesBulletinsLigne.get(var2);
            if (this.bulletinLigne.getBulligValColE() != 0.0D) {
               this.bulletinLigne.setBulletinSalaire(this.bulletinSalaire);
               this.bulletinLigne.setExercicesPaye(this.exercicesPaye);
               this.bulletinLigne.setSalaries(this.salaries);
               this.bulletinLigne = this.bulletinLigneDao.insert(this.bulletinLigne, var1);
            }
         }
      }

   }

   public void majSursalaireContrat() throws HibernateException, NamingException {
      if (this.salariesContrats != null) {
         double var1 = 0.0D;

         for(int var3 = 0; var3 < this.lesBulletinsLigne.size(); ++var3) {
            if (((BulletinLigne)this.lesBulletinsLigne.get(var3)).getBulligRubrique().equals("100030")) {
               var1 = ((BulletinLigne)this.lesBulletinsLigne.get(var3)).getBulligValColE();
               break;
            }
         }

         this.salariesContrats.setSalconSursalaire(var1);
         this.salariesContratsDao.modif(this.salariesContrats);
      }

   }

   public void saisieVariables() throws HibernateException, NamingException, ParseException {
      if (this.salaries != null && this.salaries.getSalFeuille() != null && !this.salaries.getSalFeuille().isEmpty()) {
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
         }

         this.utilInitHibernate.closeSession();
         this.showModalPanelVariable = true;
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

                     for(int var9 = 0; var9 < this.lesVariables.size(); ++var9) {
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

            label175:
            while(true) {
               SalariesVariables var16;
               if (var14 >= this.lesVariables.size()) {
                  if (var3.size() != 0) {
                     for(var14 = 0; var14 < var3.size(); ++var14) {
                        var16 = (SalariesVariables)var3.get(var14);
                        var16 = this.salariesVariablesDao.pourParapheur(((SalariesVariables)var3.get(var14)).getSalvarId(), var1);
                        if (var16 != null) {
                           this.salariesVariablesDao.delete(var16, var1);
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
                        break label175;
                     }

                     var16 = (SalariesVariables)this.lesVariables.get(var14);
                     if (var16.getSalvarCode().equals(this.optionPaye.getRubQuinzaine())) {
                        var16.setSalvarVariableA(false);
                        var16.setSalvarVariableB(false);
                        var16.setSalvarVariableC(false);
                        var16.setSalvarVariableD(false);
                        var16.setSalvarVariableE(false);
                     }

                     ++var14;
                  }
               }

               var16 = (SalariesVariables)this.lesVariables.get(var14);
               if (var16.getSalvarCode() != null && !var16.getSalvarCode().isEmpty()) {
                  if (this.lesRubriques.size() == 0) {
                     var4.add(var16);
                  } else {
                     boolean var15 = false;

                     for(int var17 = 0; var17 < this.lesRubriques.size(); ++var17) {
                        if (((FeuilleCalculRubrique)this.lesRubriques.get(var17)).getFeurubCode() != null && !((FeuilleCalculRubrique)this.lesRubriques.get(var17)).getFeurubCode().isEmpty() && ((FeuilleCalculRubrique)this.lesRubriques.get(var17)).getFeurubCode().equals(var16.getSalvarCode())) {
                           boolean var18 = false;
                           if (((FeuilleCalculRubrique)this.lesRubriques.get(var17)).isFeurubColA() && ((FeuilleCalculRubrique)this.lesRubriques.get(var17)).isFeurubVariableA()) {
                              var18 = true;
                           }

                           boolean var10 = false;
                           if (((FeuilleCalculRubrique)this.lesRubriques.get(var17)).isFeurubColB() && ((FeuilleCalculRubrique)this.lesRubriques.get(var17)).isFeurubVariableB()) {
                              var10 = true;
                           }

                           boolean var11 = false;
                           if (((FeuilleCalculRubrique)this.lesRubriques.get(var17)).isFeurubColC() && ((FeuilleCalculRubrique)this.lesRubriques.get(var17)).isFeurubVariableC()) {
                              var11 = true;
                           }

                           boolean var12 = false;
                           if (((FeuilleCalculRubrique)this.lesRubriques.get(var17)).isFeurubColD() && ((FeuilleCalculRubrique)this.lesRubriques.get(var17)).isFeurubVariableD()) {
                              var12 = true;
                           }

                           boolean var13 = false;
                           if (((FeuilleCalculRubrique)this.lesRubriques.get(var17)).isFeurubColE() && ((FeuilleCalculRubrique)this.lesRubriques.get(var17)).isFeurubVariableE()) {
                              var13 = true;
                           }

                           if (!var18 && !var10 && !var11 && !var12 && !var13) {
                              var15 = false;
                           } else {
                              var15 = true;
                           }
                           break;
                        }
                     }

                     if (!var15) {
                        var3.add(var16);
                     } else {
                        var4.add(var16);
                     }
                  }
               }

               ++var14;
            }
         }

         this.dataModelVariables.setWrappedData(var4);
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
            this.salariesElements.setSaleleEtat(this.salariesContrats.getSalconEtat());
            this.salariesElements.setSaleleDateEntree(this.salariesContrats.getSalconDateDebut());
            this.salariesElements.setSaleleDateSortie(this.salariesContrats.getSalconDateFin());
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
      }

   }

   public void gestionRH(Session var1) throws HibernateException, NamingException {
      this.lesSalariesGrh.clear();
      this.lesSalariesGrh = this.salariesGrhDao.chargerlesElementRh(this.salaries, var1);
   }

   public void selectionVariable() {
      if (this.dataModelVariables.isRowAvailable()) {
         this.salariesVariables = (SalariesVariables)this.dataModelVariables.getRowData();
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
                        var1 = (double)(((ObjetGrilleSalaire)this.lesGrilles.get(var5)).getVal_mois() / (float)this.nbJourRef);
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

   public void fermerVariables() {
      this.showModalPanelVariable = false;
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
            var2 = var23.getSalvarContrat();
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

         int var26;
         if (this.var_securite != null && !this.var_securite.isEmpty()) {
            this.salariesElements.setSaleleCentresSecurite(this.var_securite);
            if (this.mesCentresSecuritesItems.size() != 0) {
               for(var26 = 0; var26 < this.mesCentresSecuritesItems.size(); ++var26) {
                  if (((SelectItem)this.mesCentresSecuritesItems.get(var26)).getValue().toString().equals(this.var_securite)) {
                     String[] var27 = ((SelectItem)this.mesCentresSecuritesItems.get(var26)).getLabel().toString().split(":");
                     this.salariesElements.setSaleleLibCentresSecurite(var27[0]);
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
            this.salariesElements = this.salariesElementsDao.insert(this.salariesElements, var1);
         } else {
            this.salariesElements = this.salariesElementsDao.modif(this.salariesElements, var1);
         }

         var1.flush();
         if (this.salariesContrats != null) {
            if (this.salariesContrats.getSalconBase() == 0.0D && this.salariesContrats.getSalconConvention() != null && !this.salariesContrats.getSalconConvention().isEmpty() && this.salariesContrats.getSalconGrille() != null && !this.salariesContrats.getSalconGrille().isEmpty()) {
               this.var_convention = this.salariesContrats.getSalconConvention() + ":" + this.salariesContrats.getSalconLibConvention();
               this.chargerGrille();
               if (this.lesGrilles.size() != 0) {
                  for(var26 = 0; var26 < this.lesGrilles.size(); ++var26) {
                     if (((ObjetGrilleSalaire)this.lesGrilles.get(var26)).getCode().equals(this.salariesContrats.getSalconGrille())) {
                        if (this.salariesContrats.getSalconType() != null && !this.salariesContrats.getSalconType().isEmpty() && (this.salariesContrats.getSalconType().equals("03D") || this.salariesContrats.getSalconType().equals("03I"))) {
                           this.salariesContrats.setSalconBase((double)((ObjetGrilleSalaire)this.lesGrilles.get(var26)).getVal_heure());
                        } else if (this.salariesContrats.getSalconType() == null || this.salariesContrats.getSalconType().isEmpty() || !this.salariesContrats.getSalconType().equals("13") && !this.salariesContrats.getSalconType().equals("14")) {
                           if (this.salariesContrats.getSalconType() != null && !this.salariesContrats.getSalconType().isEmpty() && this.salariesContrats.getSalconType().equals("04")) {
                              this.salariesContrats.setSalconBase((double)((ObjetGrilleSalaire)this.lesGrilles.get(var26)).getVal_heure());
                           } else {
                              this.salariesContrats.setSalconBase((double)((ObjetGrilleSalaire)this.lesGrilles.get(var26)).getVal_mois());
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
            if (this.salariesElements.getSaleleEtat() != 9 && (this.salariesContrats == null || this.salariesContrats != null && this.salariesContrats.getSalconEtat() != 9)) {
               this.salariesContrats.setSalconEtat(this.salariesElements.getSaleleEtat());
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
               if (this.salariesElements.getSaleleEtat() != 9 && (this.salariesContrats == null || this.salariesContrats != null && this.salariesContrats.getSalconEtat() != 9)) {
                  this.salaries.setSalEtat(this.salariesElements.getSaleleEtat());
               }

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

   public void verificationPrecalcul(Session var1) throws HibernateException, NamingException {
      this.gestionBasesReference = false;
      this.lesBasesReferences.clear();
      if (this.lesRubriques.size() != 0) {
         new PlanPaye();

         for(int var3 = 0; var3 < this.lesRubriques.size(); ++var3) {
            PlanPaye var2 = ((FeuilleCalculRubrique)this.lesRubriques.get(var3)).getPlanPaye();
            if (var2.getPlpCalculBase() != null && !var2.getPlpCalculBase().isEmpty()) {
               this.objetBaseReference = new ObjetBaseReference();
               this.objetBaseReference.setCodeRubrique(var2.getPlpCode());
               this.objetBaseReference.setCalculReference(var2.getPlpCalculBase());
               this.objetBaseReference.setValeurBaseReference(0.0D);
               this.lesBasesReferences.add(this.objetBaseReference);
               this.gestionBasesReference = true;
            }
         }
      }

      this.rubriqueEcart = "";
      new ArrayList();
      new FeuilleCalculFormule();
      List var5 = this.feuilleCalculFormuleDao.chargerFeuille(this.feuilleCalcul, var1);
      if (var5.size() != 0) {
         for(int var4 = 0; var4 < var5.size(); ++var4) {
            FeuilleCalculFormule var6 = (FeuilleCalculFormule)var5.get(var4);
            if (var6.getFeurubforFormule() != null && !var6.getFeurubforFormule().isEmpty() && var6.getFeurubforFormule().contains("M000129")) {
               this.rubriqueEcart = var6.getFeurubforCode();
            }
         }
      }

   }

   public void verificationNetAAtteindre() {
      this.netAAtteindre = 0.0D;
      if (this.lesVariables.size() != 0) {
         for(int var1 = 0; var1 < this.lesVariables.size(); ++var1) {
            if (((SalariesVariables)this.lesVariables.get(var1)).getSalvarCode().equals("901000")) {
               this.netAAtteindre = ((SalariesVariables)this.lesVariables.get(var1)).getSalvarValeurColE();
            }
         }

         if (this.netAAtteindre != 0.0D) {
            double var3 = this.M000040((Session)null);
            this.netAAtteindre = this.utilNombre.myRoundDevise(this.netAAtteindre / (double)this.nbJourRef * var3, this.structureLog.getStrdevise());
         }
      }

   }

   public float calculNbMoisPresence() {
      float var1 = 0.0F;
      if (this.salaries.getSalDateImpot() != null) {
         if (this.salaries.getSalDateImpot().getYear() + 1900 < this.exercicesPaye.getExepayDateDebut().getYear() + 1900) {
            var1 = (float)(this.dateGeneration.getMonth() + 1);
         } else {
            var1 = (float)(this.dateGeneration.getMonth() + 1 - (this.salaries.getSalDateImpot().getMonth() + 1) + 1);
         }
      } else if (this.salariesContrats.getSalconDateDebut().getYear() + 1900 < this.exercicesPaye.getExepayDateDebut().getYear() + 1900) {
         var1 = (float)(this.dateGeneration.getMonth() + 1);
      } else {
         var1 = (float)(this.dateGeneration.getMonth() + 1 - (this.salariesContrats.getSalconDateDebut().getMonth() + 1) + 1);
      }

      return var1;
   }

   public int calculAge(Date var1) {
      int var2 = 0;
      if (var1 != null) {
         var2 = (new Date()).getYear() + 1900 - (var1.getYear() + 1900);
      }

      return var2;
   }

   public boolean verifConges() throws ParseException {
      boolean var1 = false;
      this.type_conges = 0;
      if (this.lesConges.size() != 0) {
         new SalariesConges();

         for(int var3 = 0; var3 < this.lesConges.size(); ++var3) {
            SalariesConges var2 = (SalariesConges)this.lesConges.get(var3);
            if (var2.getSalcngNature() != 1 && var2.getSalcngNature() != 6) {
               if (var2.getSalcngNature() == 2 && var2.getSalcngDateDebut().getYear() == this.d1.getYear() && var2.getSalcngDateDebut().getMonth() == this.d1.getMonth()) {
                  this.type_conges = var2.getSalcngNature();
                  break;
               }

               if (var2.getSalcngNature() == 3 && var2.getSalcngDateDebut().getYear() == this.d1.getYear() && var2.getSalcngDateDebut().getMonth() == this.d1.getMonth()) {
                  this.type_conges = var2.getSalcngNature();
                  break;
               }

               if ((var2.getSalcngNature() != 4 || var2.getSalcngDateDebut().getYear() != this.d1.getYear() || var2.getSalcngDateDebut().getMonth() != this.d1.getMonth()) && var2.getSalcngNature() == 5) {
                  Date var4 = var2.getSalcngDateDebut();
                  Date var5 = var2.getSalcngDateFin();
                  if (this.d1.compareTo(var2.getSalcngDateDebut()) >= 0 && this.d2.compareTo(var2.getSalcngDateFin()) <= 0) {
                     var1 = true;
                     this.type_conges = var2.getSalcngNature();
                     break;
                  }
               }
            } else if (var2.getSalcngDateDebut().equals(this.d1) && var2.getSalcngDateFin().equals(this.d2)) {
               var1 = true;
               this.type_conges = var2.getSalcngNature();
               break;
            }
         }
      }

      return var1;
   }

   public double calculSigne(double var1) {
      if (this.bulletinLigne.getBulligSens() == 1 || this.bulletinLigne.getBulligNature() == 90) {
         var1 *= -1.0D;
      }

      return var1;
   }

   public double calculBrutTotal(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      new ArrayList();
      List var4 = this.bulletinLigneDao.chargerleslignesbyNatureSalaries(59, this.exercicesPaye.getExepayDateDebut(), this.dateGeneration, this.salaries, var1);
      int var5;
      if (var4.size() != 0) {
         for(var5 = 0; var5 < var4.size(); ++var5) {
            var2 += ((BulletinLigne)var4.get(var5)).getBulligValColE();
         }
      }

      if (this.netAAtteindre != 0.0D && this.lesBulletinsLigne.size() != 0) {
         for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
            if (((BulletinLigne)this.lesBulletinsLigne.get(var5)).getBulligNature() == 59) {
               var2 += ((BulletinLigne)this.lesBulletinsLigne.get(var5)).getBulligValColE();
            }
         }
      }

      return var2;
   }

   public double calculBrutEnCours(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      if (this.lesBulletinsLigne.size() != 0) {
         for(int var4 = 0; var4 < this.lesBulletinsLigne.size(); ++var4) {
            if (((BulletinLigne)this.lesBulletinsLigne.get(var4)).getBulligNature() == 59) {
               var2 = ((BulletinLigne)this.lesBulletinsLigne.get(var4)).getBulligValColE();
               break;
            }
         }
      }

      return var2;
   }

   public double calculLicenciementTotal(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      new ArrayList();
      List var4 = this.bulletinLigneDao.chargerleslignesbyNatureSalaries(41, this.exercicesPaye.getExepayDateDebut(), this.dateGeneration, this.salaries, var1);
      int var5;
      if (var4.size() != 0) {
         for(var5 = 0; var5 < var4.size(); ++var5) {
            var2 += ((BulletinLigne)var4.get(var5)).getBulligValColE();
         }
      }

      if (this.netAAtteindre != 0.0D && this.lesBulletinsLigne.size() != 0) {
         for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
            if (((BulletinLigne)this.lesBulletinsLigne.get(var5)).getBulligNature() == 41) {
               var2 += ((BulletinLigne)this.lesBulletinsLigne.get(var5)).getBulligValColE();
            }
         }
      }

      return var2;
   }

   public double calculLicenciementEnCours(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      if (this.lesBulletinsLigne.size() != 0) {
         for(int var4 = 0; var4 < this.lesBulletinsLigne.size(); ++var4) {
            if (((BulletinLigne)this.lesBulletinsLigne.get(var4)).getBulligNature() == 41) {
               var2 = ((BulletinLigne)this.lesBulletinsLigne.get(var4)).getBulligValColE();
               break;
            }
         }
      }

      return var2;
   }

   public double calculIndCompTotal(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      new ArrayList();
      List var4 = this.bulletinLigneDao.chargerleslignesbyNatureSalaries(25, this.exercicesPaye.getExepayDateDebut(), this.dateGeneration, this.salaries, var1);
      int var5;
      if (var4.size() != 0) {
         for(var5 = 0; var5 < var4.size(); ++var5) {
            var2 += ((BulletinLigne)var4.get(var5)).getBulligValColE();
         }
      }

      if (this.netAAtteindre != 0.0D && this.lesBulletinsLigne.size() != 0) {
         for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
            if (((BulletinLigne)this.lesBulletinsLigne.get(var5)).getBulligNature() == 50) {
               var2 += ((BulletinLigne)this.lesBulletinsLigne.get(var5)).getBulligValColE();
            }
         }
      }

      return var2;
   }

   public double calculAvnTotal(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      new ArrayList();
      List var4 = this.bulletinLigneDao.chargerleslignesbyNatureSalaries(50, this.exercicesPaye.getExepayDateDebut(), this.dateGeneration, this.salaries, var1);
      int var5;
      if (var4.size() != 0) {
         for(var5 = 0; var5 < var4.size(); ++var5) {
            var2 += ((BulletinLigne)var4.get(var5)).getBulligValColE();
         }
      }

      if (this.netAAtteindre != 0.0D && this.lesBulletinsLigne.size() != 0) {
         for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
            if (((BulletinLigne)this.lesBulletinsLigne.get(var5)).getBulligNature() == 50) {
               var2 += ((BulletinLigne)this.lesBulletinsLigne.get(var5)).getBulligValColE();
            }
         }
      }

      return var2;
   }

   public double calculAvnEnCours(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      if (this.lesBulletinsLigne.size() != 0) {
         for(int var4 = 0; var4 < this.lesBulletinsLigne.size(); ++var4) {
            if (((BulletinLigne)this.lesBulletinsLigne.get(var4)).getBulligNature() == 50) {
               var2 += ((BulletinLigne)this.lesBulletinsLigne.get(var4)).getBulligValColE();
            }
         }
      }

      return var2;
   }

   public double calculIndCompEnCours(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      if (this.lesBulletinsLigne.size() != 0) {
         for(int var4 = 0; var4 < this.lesBulletinsLigne.size(); ++var4) {
            if (((BulletinLigne)this.lesBulletinsLigne.get(var4)).getBulligNature() == 25) {
               var2 += ((BulletinLigne)this.lesBulletinsLigne.get(var4)).getBulligValColE();
            }
         }
      }

      return var2;
   }

   public double calculRubriqueTotal(String var1, Session var2) throws HibernateException, NamingException {
      double var3 = 0.0D;
      new ArrayList();
      List var5 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries(var1, this.exercicesPaye.getExepayDateDebut(), this.dateGeneration, this.salaries, var2);
      int var6;
      if (var5.size() != 0) {
         for(var6 = 0; var6 < var5.size(); ++var6) {
            var3 += ((BulletinLigne)var5.get(var6)).getBulligValColE();
         }
      }

      if (this.netAAtteindre != 0.0D && this.lesBulletinsLigne.size() != 0) {
         for(var6 = 0; var6 < this.lesBulletinsLigne.size(); ++var6) {
            if (((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligRubrique().equals(var1)) {
               var3 += ((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligValColE();
            }
         }
      }

      return var3;
   }

   public double calculRubriqueEnCours(String var1, Session var2) throws HibernateException, NamingException {
      double var3 = 0.0D;
      if (this.lesBulletinsLigne.size() != 0) {
         for(int var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
            if (((BulletinLigne)this.lesBulletinsLigne.get(var5)).getBulligRubrique().equals(var1)) {
               var3 = ((BulletinLigne)this.lesBulletinsLigne.get(var5)).getBulligValColE();
               break;
            }
         }
      }

      return var3;
   }

   public double calculRubriqueTotal(String var1, String var2, Session var3) throws HibernateException, NamingException {
      double var4 = 0.0D;
      new ArrayList();
      List var6 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries(var1, var2, this.exercicesPaye.getExepayDateDebut(), this.dateGeneration, this.salaries, var3);
      if (var6.size() != 0) {
         for(int var7 = 0; var7 < var6.size(); ++var7) {
            var4 += ((BulletinLigne)var6.get(var7)).getBulligValColE();
         }
      }

      if (this.netAAtteindre != 0.0D && this.lesBulletinsLigne.size() != 0) {
         double var14 = Double.parseDouble(var1);
         double var9 = Double.parseDouble(var2);

         for(int var11 = 0; var11 < this.lesBulletinsLigne.size(); ++var11) {
            double var12 = Double.parseDouble(((BulletinLigne)this.lesBulletinsLigne.get(var11)).getBulligRubrique());
            if (var12 >= var14 && var12 <= var9) {
               var4 += ((BulletinLigne)this.lesBulletinsLigne.get(var11)).getBulligValColE();
            }
         }
      }

      return var4;
   }

   public double calculRubriqueEnCours(String var1, String var2, Session var3) throws HibernateException, NamingException {
      double var4 = 0.0D;
      if (this.lesBulletinsLigne.size() != 0) {
         int var6 = Integer.parseInt(var1);
         int var7 = Integer.parseInt(var2);

         for(int var8 = 0; var8 < this.lesBulletinsLigne.size(); ++var8) {
            int var9 = Integer.parseInt(((BulletinLigne)this.lesBulletinsLigne.get(var8)).getBulligRubrique());
            if (var9 >= var6 && var9 <= var7) {
               var4 += ((BulletinLigne)this.lesBulletinsLigne.get(var8)).getBulligValColE();
            }
         }
      }

      return var4;
   }

   public double calculRubriquePeriode(String var1, String var2, Session var3) throws HibernateException, NamingException {
      double var4 = 0.0D;
      new BulletinLigne();
      BulletinLigne var6 = this.bulletinLigneDao.chargerleslignesbyRubriquesPeriode(var1, var2, this.salaries, var3);
      if (var6 != null) {
         var4 = var6.getBulligValColE();
      } else {
         var4 = 0.0D;
      }

      return var4;
   }

   public double calculBaseHeureSupEnCours(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      new BulletinLigne();

      int var5;
      for(var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
         BulletinLigne var4 = (BulletinLigne)this.lesBulletinsLigne.get(var5);

         for(int var6 = 0; var6 < this.lesRubriques.size(); ++var6) {
            this.feuilleCalculRubrique = (FeuilleCalculRubrique)this.lesRubriques.get(var6);
            if (var4.getBulligRubrique().equals(this.feuilleCalculRubrique.getFeurubCode())) {
               var2 += var4.getBulligValColE();
            }
         }
      }

      if (this.lesRubriques.size() != 0) {
         for(var5 = 0; var5 < this.lesRubriques.size(); ++var5) {
            this.feuilleCalculRubrique = (FeuilleCalculRubrique)this.lesRubriques.get(var5);
            if (this.feuilleCalculRubrique.getFeurubCode().equals("205000")) {
               var2 += this.salariesContrats.getSalconAvnLogement();
            } else if (this.feuilleCalculRubrique.getFeurubCode().equals("205010")) {
               var2 += this.salariesContrats.getSalconAvnDomesticite();
            } else if (this.feuilleCalculRubrique.getFeurubCode().equals("205020")) {
               var2 += this.salariesContrats.getSalconAvnEau();
            } else if (this.feuilleCalculRubrique.getFeurubCode().equals("205030")) {
               var2 += this.salariesContrats.getSalconAvnElectricite();
            } else if (this.feuilleCalculRubrique.getFeurubCode().equals("205040")) {
               var2 += this.salariesContrats.getSalconAvnNourriture();
            } else if (this.feuilleCalculRubrique.getFeurubCode().equals("205050")) {
               var2 += this.salariesContrats.getSalconAvnVehicule();
            } else if (this.feuilleCalculRubrique.getFeurubCode().equals("205060")) {
               var2 += this.salariesContrats.getSalconAvnTelephone();
            }
         }
      }

      return var2;
   }

   public double calculBaseImposasableFiscaleTotal(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      if (this.optionPaye.getCalculRegularisation().equals("1")) {
         new ArrayList();
         if (this.bulletinLigne != null) {
            List var4 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries(this.bulletinLigne.getBulligRubrique(), this.exercicesPaye.getExepayDateDebut(), this.dateGeneration, this.salaries, var1);
            if (var4.size() != 0) {
               for(int var5 = 0; var5 < var4.size(); ++var5) {
                  var2 += ((BulletinLigne)var4.get(var5)).getBulligValColB();
               }
            }
         }
      } else {
         Object var9 = new ArrayList();
         new BulletinLigne();

         for(int var6 = 0; var6 < this.lesBulletinsLigne.size(); ++var6) {
            BulletinLigne var10 = (BulletinLigne)this.lesBulletinsLigne.get(var6);

            for(int var7 = 0; var7 < this.lesRubriques.size(); ++var7) {
               this.feuilleCalculRubrique = (FeuilleCalculRubrique)this.lesRubriques.get(var7);
               if (var10.getBulligRubrique().equals(this.feuilleCalculRubrique.getFeurubCode()) && this.feuilleCalculRubrique.getPlanPaye().isPlpBaseFiscale()) {
                  ((List)var9).clear();
                  var9 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries(this.feuilleCalculRubrique.getFeurubCode(), (String)null, this.exercicesPaye.getExepayDateDebut(), this.dateGeneration, this.salaries, var1);
                  if (((List)var9).size() != 0) {
                     for(int var8 = 0; var8 < ((List)var9).size(); ++var8) {
                        var2 += ((BulletinLigne)((List)var9).get(var8)).getBulligValColE() * (double)this.feuilleCalculRubrique.getPlanPaye().getPlpTauxFiscale() / 100.0D;
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   public double calculBaseImposasableFiscaleEnCours(Session var1) throws HibernateException, NamingException, ParseException {
      double var2 = 0.0D;
      if (this.bulletinLigne != null) {
         new BulletinLigne();

         for(int var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
            BulletinLigne var4 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
            if (var4.getBulligValColE() != 0.0D) {
               for(int var6 = 0; var6 < this.lesRubriques.size(); ++var6) {
                  this.feuilleCalculRubrique = (FeuilleCalculRubrique)this.lesRubriques.get(var6);
                  if (var4.getBulligRubrique().equals(this.feuilleCalculRubrique.getFeurubCode())) {
                     if (!this.feuilleCalculRubrique.getPlanPaye().isPlpBaseFiscale()) {
                        break;
                     }

                     if (this.feuilleCalculRubrique.getPlanPaye().getPlpFormuleFiscale() != null && !this.feuilleCalculRubrique.getPlanPaye().getPlpFormuleFiscale().isEmpty()) {
                        if (!this.feuilleCalculRubrique.getPlanPaye().getPlpFormuleFiscale().equalsIgnoreCase("transport")) {
                           double var8;
                           String var12;
                           if (this.feuilleCalculRubrique.getPlanPaye().getPlpFormuleFiscale().startsWith("<")) {
                              var12 = this.feuilleCalculRubrique.getPlanPaye().getPlpFormuleFiscale().substring(1, this.feuilleCalculRubrique.getPlanPaye().getPlpFormuleFiscale().length());
                              var8 = Double.parseDouble(var12);
                              if (var4.getBulligValColE() > var8) {
                                 var2 += var4.getBulligValColE() - var8;
                              }
                           } else if (this.feuilleCalculRubrique.getPlanPaye().getPlpFormuleFiscale().startsWith(">")) {
                              var12 = this.feuilleCalculRubrique.getPlanPaye().getPlpFormuleFiscale().substring(1, this.feuilleCalculRubrique.getPlanPaye().getPlpFormuleFiscale().length());
                              var8 = Double.parseDouble(var12);
                              if (var4.getBulligValColE() > var8) {
                                 var2 += var8;
                              } else {
                                 var2 += var4.getBulligValColE();
                              }
                           } else {
                              var2 += var4.getBulligValColE() * (double)this.feuilleCalculRubrique.getPlanPaye().getPlpTauxFiscale() / 100.0D;
                           }
                           break;
                        }

                        double var7 = 0.0D;
                        if (this.gestionBasesReference) {
                           var7 = this.M000096(var1);
                        } else {
                           for(int var9 = 0; var9 < this.lesBulletinsLigne.size(); ++var9) {
                              if (((BulletinLigne)this.lesBulletinsLigne.get(var9)).getBulligRubrique().equals("100000")) {
                                 var7 = ((BulletinLigne)this.lesBulletinsLigne.get(var9)).getBulligValColE();
                                 break;
                              }
                           }
                        }

                        var7 = this.utilNombre.myRound(var7 * 10.0D / 100.0D, 0);
                        double var13 = 0.0D;

                        for(int var11 = 0; var11 < this.lesBulletinsLigne.size(); ++var11) {
                           if (((BulletinLigne)this.lesBulletinsLigne.get(var11)).getBulligRubrique().equals(var4.getBulligRubrique())) {
                              var13 = ((BulletinLigne)this.lesBulletinsLigne.get(var11)).getBulligValColE();
                              break;
                           }
                        }

                        if (var7 > var13) {
                           var7 = 0.0D;
                           var13 = 0.0D;
                        }

                        var2 += (var13 - var7) * (double)this.feuilleCalculRubrique.getPlanPaye().getPlpTauxFiscale() / 100.0D;
                        break;
                     }

                     var2 += var4.getBulligValColE() * (double)this.feuilleCalculRubrique.getPlanPaye().getPlpTauxFiscale() / 100.0D;
                     break;
                  }
               }
            }
         }
      }

      return var2;
   }

   public double calculBaseImposasableSocialeTotal(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      if (this.optionPaye.getCalculRegularisation().equals("1")) {
         new ArrayList();
         if (this.bulletinLigne != null) {
            List var4 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries(this.bulletinLigne.getBulligRubrique(), this.exercicesPaye.getExepayDateDebut(), this.dateGeneration, this.salaries, var1);
            if (var4.size() != 0) {
               for(int var5 = 0; var5 < var4.size(); ++var5) {
                  var2 += ((BulletinLigne)var4.get(var5)).getBulligValColB();
               }
            }
         }
      } else {
         Object var9 = new ArrayList();
         new BulletinLigne();

         for(int var6 = 0; var6 < this.lesBulletinsLigne.size(); ++var6) {
            BulletinLigne var10 = (BulletinLigne)this.lesBulletinsLigne.get(var6);

            for(int var7 = 0; var7 < this.lesRubriques.size(); ++var7) {
               this.feuilleCalculRubrique = (FeuilleCalculRubrique)this.lesRubriques.get(var7);
               if (var10.getBulligRubrique().equals(this.feuilleCalculRubrique.getFeurubCode()) && this.feuilleCalculRubrique.getPlanPaye().isPlpBaseSociale()) {
                  ((List)var9).clear();
                  var9 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries(this.feuilleCalculRubrique.getFeurubCode(), (String)null, this.exercicesPaye.getExepayDateDebut(), this.dateGeneration, this.salaries, var1);
                  if (((List)var9).size() != 0) {
                     for(int var8 = 0; var8 < ((List)var9).size(); ++var8) {
                        var2 += ((BulletinLigne)((List)var9).get(var8)).getBulligValColE() * (double)this.feuilleCalculRubrique.getPlanPaye().getPlpTauxSociale() / 100.0D;
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   public double calculBaseImposasableSocialeEnCours(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      new BulletinLigne();

      for(int var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
         BulletinLigne var4 = (BulletinLigne)this.lesBulletinsLigne.get(var5);

         for(int var6 = 0; var6 < this.lesRubriques.size(); ++var6) {
            this.feuilleCalculRubrique = (FeuilleCalculRubrique)this.lesRubriques.get(var6);
            if (var4.getBulligRubrique().equals(this.feuilleCalculRubrique.getFeurubCode()) && this.feuilleCalculRubrique.getPlanPaye().isPlpBaseSociale()) {
               var2 += var4.getBulligValColE() * (double)this.feuilleCalculRubrique.getPlanPaye().getPlpTauxSociale() / 100.0D;
            }
         }
      }

      return var2;
   }

   public double calculBaseImposasableAutreTotal(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      if (this.optionPaye.getCalculRegularisation().equals("X")) {
         new ArrayList();
         if (this.bulletinLigne != null) {
            List var4 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries(this.bulletinLigne.getBulligRubrique(), this.exercicesPaye.getExepayDateDebut(), this.dateGeneration, this.salaries, var1);
            if (var4.size() != 0) {
               for(int var5 = 0; var5 < var4.size(); ++var5) {
                  var2 += ((BulletinLigne)var4.get(var5)).getBulligValColB();
               }
            }
         }
      } else {
         Object var9 = new ArrayList();
         new BulletinLigne();

         for(int var6 = 0; var6 < this.lesBulletinsLigne.size(); ++var6) {
            BulletinLigne var10 = (BulletinLigne)this.lesBulletinsLigne.get(var6);

            for(int var7 = 0; var7 < this.lesRubriques.size(); ++var7) {
               this.feuilleCalculRubrique = (FeuilleCalculRubrique)this.lesRubriques.get(var7);
               if (var10.getBulligRubrique().equals(this.feuilleCalculRubrique.getFeurubCode()) && this.feuilleCalculRubrique.getPlanPaye().isPlpBaseAutre()) {
                  ((List)var9).clear();
                  var9 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries(this.feuilleCalculRubrique.getFeurubCode(), (String)null, this.exercicesPaye.getExepayDateDebut(), this.dateGeneration, this.salaries, var1);
                  if (((List)var9).size() != 0) {
                     for(int var8 = 0; var8 < ((List)var9).size(); ++var8) {
                        var2 += ((BulletinLigne)((List)var9).get(var8)).getBulligValColE() * 100.0D / 100.0D;
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   public double calculBaseImposasableAutreEnCours(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      new BulletinLigne();

      for(int var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
         BulletinLigne var4 = (BulletinLigne)this.lesBulletinsLigne.get(var5);

         for(int var6 = 0; var6 < this.lesRubriques.size(); ++var6) {
            this.feuilleCalculRubrique = (FeuilleCalculRubrique)this.lesRubriques.get(var6);
            if (var4.getBulligRubrique().equals(this.feuilleCalculRubrique.getFeurubCode()) && this.feuilleCalculRubrique.getPlanPaye().isPlpBaseAutre()) {
               var2 += var4.getBulligValColE() * 100.0D / 100.0D;
            }
         }
      }

      return var2;
   }

   public double calculBaseImposasablePatronaleTotal(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      if (this.optionPaye.getCalculRegularisation().equals("X")) {
         new ArrayList();
         if (this.bulletinLigne != null) {
            List var4 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries(this.bulletinLigne.getBulligRubrique(), this.exercicesPaye.getExepayDateDebut(), this.dateGeneration, this.salaries, var1);
            if (var4.size() != 0) {
               for(int var5 = 0; var5 < var4.size(); ++var5) {
                  var2 += ((BulletinLigne)var4.get(var5)).getBulligValColB();
               }
            }
         }
      } else {
         Object var9 = new ArrayList();
         new BulletinLigne();

         for(int var6 = 0; var6 < this.lesBulletinsLigne.size(); ++var6) {
            BulletinLigne var10 = (BulletinLigne)this.lesBulletinsLigne.get(var6);

            for(int var7 = 0; var7 < this.lesRubriques.size(); ++var7) {
               this.feuilleCalculRubrique = (FeuilleCalculRubrique)this.lesRubriques.get(var7);
               if (var10.getBulligRubrique().equals(this.feuilleCalculRubrique.getFeurubCode()) && this.feuilleCalculRubrique.getPlanPaye().isPlpBasePatronale()) {
                  ((List)var9).clear();
                  var9 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries(this.feuilleCalculRubrique.getFeurubCode(), (String)null, this.exercicesPaye.getExepayDateDebut(), this.dateGeneration, this.salaries, var1);
                  if (((List)var9).size() != 0) {
                     for(int var8 = 0; var8 < ((List)var9).size(); ++var8) {
                        var2 += ((BulletinLigne)((List)var9).get(var8)).getBulligValColE() * (double)this.feuilleCalculRubrique.getPlanPaye().getPlpTauxPatronal() / 100.0D;
                     }
                  }
               }
            }
         }
      }

      return var2;
   }

   public double calculBaseImposasablePatronaleEnCours(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      new BulletinLigne();

      for(int var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
         BulletinLigne var4 = (BulletinLigne)this.lesBulletinsLigne.get(var5);

         for(int var6 = 0; var6 < this.lesRubriques.size(); ++var6) {
            this.feuilleCalculRubrique = (FeuilleCalculRubrique)this.lesRubriques.get(var6);
            if (var4.getBulligRubrique().equals(this.feuilleCalculRubrique.getFeurubCode()) && this.feuilleCalculRubrique.getPlanPaye().isPlpBasePatronale()) {
               var2 += var4.getBulligValColE() * (double)this.feuilleCalculRubrique.getPlanPaye().getPlpTauxPatronal() / 100.0D;
            }
         }
      }

      return var2;
   }

   public void M000001(Session var1) {
      if (this.salariesContrats != null && this.salariesContrats.getSalconBase() != 0.0D) {
         this.valeur = this.salariesContrats.getSalconBase();
      } else if (this.salariesElements.getSaleleConvention() != null && !this.salariesElements.getSaleleConvention().isEmpty() && this.salariesElements.getSaleleGrille() != null && !this.salariesElements.getSaleleGrille().isEmpty()) {
         new ArrayList();
         LectureGrilleSalaire var3 = new LectureGrilleSalaire();
         var3.setStrId(this.structureLog.getStrid());
         var3.setStructureLog(this.structureLog);
         var3.recuperePaye(this.salariesElements.getSaleleConvention());
         List var2 = var3.getMesGrillesSalaires();
         if (var2 != null && var2.size() != 0) {
            int var4;
            if (this.salariesContrats == null) {
               if (this.salariesElements.getSaleleNature() == null || this.salariesElements.getSaleleNature().isEmpty() || !this.salariesElements.getSaleleNature().equals("03D") && !this.salariesElements.getSaleleNature().equals("03I")) {
                  if (this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && (this.salariesElements.getSaleleNature().equals("13") || this.salariesElements.getSaleleNature().equals("14"))) {
                     this.valeur = 0.0D;
                  } else if (this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && this.salariesElements.getSaleleNature().equals("04")) {
                     for(var4 = 0; var4 < var2.size(); ++var4) {
                        if (((ObjetGrilleSalaire)var2.get(var4)).getCode().equals(this.salariesElements.getSaleleGrille())) {
                           this.valeur = (double)((ObjetGrilleSalaire)var2.get(var4)).getVal_heure();
                           break;
                        }
                     }
                  } else {
                     for(var4 = 0; var4 < var2.size(); ++var4) {
                        if (((ObjetGrilleSalaire)var2.get(var4)).getCode().equals(this.salariesElements.getSaleleGrille())) {
                           this.valeur = (double)((ObjetGrilleSalaire)var2.get(var4)).getVal_mois();
                           break;
                        }
                     }
                  }
               } else {
                  for(var4 = 0; var4 < var2.size(); ++var4) {
                     if (((ObjetGrilleSalaire)var2.get(var4)).getCode().equals(this.salariesElements.getSaleleGrille())) {
                        this.valeur = (double)((ObjetGrilleSalaire)var2.get(var4)).getVal_heure();
                        break;
                     }
                  }
               }
            } else if (this.salariesContrats.getSalconType() == null || this.salariesContrats.getSalconType().isEmpty() || !this.salariesContrats.getSalconType().equals("03D") && !this.salariesContrats.getSalconType().equals("03I")) {
               if (this.salariesContrats.getSalconType() != null && !this.salariesContrats.getSalconType().isEmpty() && (this.salariesContrats.getSalconType().equals("13") || this.salariesContrats.getSalconType().equals("14"))) {
                  this.valeur = 0.0D;
               } else if (this.salariesContrats.getSalconType() != null && !this.salariesContrats.getSalconType().isEmpty() && this.salariesContrats.getSalconType().equals("04")) {
                  for(var4 = 0; var4 < var2.size(); ++var4) {
                     if (((ObjetGrilleSalaire)var2.get(var4)).getCode().equals(this.salariesElements.getSaleleGrille())) {
                        this.valeur = (double)((ObjetGrilleSalaire)var2.get(var4)).getVal_heure();
                        break;
                     }
                  }
               } else {
                  for(var4 = 0; var4 < var2.size(); ++var4) {
                     if (((ObjetGrilleSalaire)var2.get(var4)).getCode().equals(this.salariesElements.getSaleleGrille())) {
                        this.valeur = (double)((ObjetGrilleSalaire)var2.get(var4)).getVal_mois();
                        break;
                     }
                  }
               }
            } else {
               for(var4 = 0; var4 < var2.size(); ++var4) {
                  if (((ObjetGrilleSalaire)var2.get(var4)).getCode().equals(this.salariesElements.getSaleleGrille())) {
                     this.valeur = (double)((ObjetGrilleSalaire)var2.get(var4)).getVal_heure();
                     break;
                  }
               }
            }
         } else {
            this.valeur = 9.99999999E8D;
         }
      } else {
         this.valeur = 9.99999999E8D;
      }

      if (this.type_conges == 2) {
         this.valeur = 0.0D;
      }

   }

   public void M000002(Session var1) throws ParseException {
      this.valeur = 0.0D;
      this.M000003(var1);
      double var2 = this.valeur;
      double var4;
      int var6;
      if (this.type_conges == 2) {
         if (this.salariesContrats != null && this.salariesContrats.getSalconBase() != 0.0D) {
            this.bulletinLigne.setBulligValColB(this.salariesContrats.getSalconBase());
         } else {
            var4 = 0.0D;

            for(var6 = 0; var6 < this.lesBulletinsLigne.size(); ++var6) {
               if (((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligRubrique().equals("")) {
                  var4 = ((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligValColB();
                  break;
               }
            }

            this.bulletinLigne.setBulligValColB(var4);
         }
      }

      if (!this.structureLog.getStrcodepays().equals("0029") && !this.structureLog.getStrcodepays().equals("0041")) {
         double var8;
         double var11;
         if (this.structureLog.getStrcodepays().equals("0050")) {
            if (this.valeur >= 2.0D) {
               if (this.salariesContrats.getSalconConvention() != null && !this.salariesContrats.getSalconConvention().isEmpty() && this.salariesContrats.getSalconConvention().equals("ASSURANCES")) {
                  this.valeur += 2.0D;
                  if (this.valeur >= 25.0D && this.valeur <= 29.0D) {
                     var2 = 25.0D;
                  } else if (this.valeur >= 30.0D) {
                     var2 = 30.0D;
                  } else {
                     var2 = this.valeur;
                  }
               } else {
                  var2 = this.valeur;
               }

               this.valeur = 0.0D;
               var4 = 0.0D;
               if (this.bulletinLigne.getBulligValColB() != 0.0D) {
                  var4 = this.bulletinLigne.getBulligValColB();
               } else {
                  for(var6 = 0; var6 < this.lesBulletinsLigne.size(); ++var6) {
                     if (((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligNature() == 10 || ((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligNature() == 11) {
                        var4 += ((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligValColE();
                     }
                  }
               }

               if (this.salaries.getSalNature() != null && !this.salaries.getSalNature().isEmpty() && (this.salaries.getSalNature().equals("03D") || this.salaries.getSalNature().equals("03I"))) {
                  this.valeur = this.utilNombre.myRoundDevise(var4 * var2 / 100.0D, this.structureLog.getStrdevise());
               } else if (this.bulletinLigne.getBulligValColD() != (double)this.nbJourRef && this.bulletinLigne.getBulligValColD() != 0.0D) {
                  var11 = this.utilNombre.myRoundDevise(var4 * var2 / 100.0D, this.structureLog.getStrdevise());
                  var8 = var11 / (double)this.nbJourRef * this.bulletinLigne.getBulligValColD();
                  this.valeur = this.utilNombre.myRoundDevise(var8, this.structureLog.getStrdevise());
               } else if (this.bulletinLigne.getBulligValColD() == (double)this.nbJourRef && this.bulletinLigne.getBulligValColD() == 0.0D) {
                  this.valeur = this.utilNombre.myRoundDevise(var4 * var2 / 100.0D, this.structureLog.getStrdevise());
               } else {
                  this.valeur = this.utilNombre.myRoundDevise(var4 * var2 / 100.0D, this.structureLog.getStrdevise());
               }
            } else {
               this.valeur = 0.0D;
            }
         } else if (!this.structureLog.getStrcodepays().equals("0056")) {
            if (this.structureLog.getStrcodepays().equals("0077")) {
               if (this.valeur >= 2.0D) {
                  if (this.salariesContrats.getSalconConvention() != null && !this.salariesContrats.getSalconConvention().isEmpty() && this.salariesContrats.getSalconConvention().equals("ASSURANCES")) {
                     this.valeur += 2.0D;
                     if (this.valeur >= 30.0D) {
                        var2 = 30.0D;
                     } else {
                        var2 = this.valeur;
                     }
                  } else {
                     var2 = this.valeur;
                  }

                  this.valeur = 0.0D;
                  var4 = 0.0D;
                  if (this.bulletinLigne.getBulligValColB() != 0.0D) {
                     var4 = this.bulletinLigne.getBulligValColB();
                  } else {
                     for(var6 = 0; var6 < this.lesBulletinsLigne.size(); ++var6) {
                        if (((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligNature() == 10 || ((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligNature() == 11) {
                           var4 += ((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligValColE();
                        }
                     }
                  }

                  if (this.salaries.getSalNature() == null || this.salaries.getSalNature().isEmpty() || !this.salaries.getSalNature().equals("03D") && !this.salaries.getSalNature().equals("03I")) {
                     if (this.bulletinLigne.getBulligValColD() != (double)this.nbJourRef && this.bulletinLigne.getBulligValColD() != 0.0D) {
                        var11 = this.utilNombre.myRoundDevise(var4 * var2 / 100.0D, this.structureLog.getStrdevise());
                        var8 = var11 / (double)this.nbJourRef * this.bulletinLigne.getBulligValColD();
                        this.valeur = this.utilNombre.myRoundDevise(var8, this.structureLog.getStrdevise());
                     } else if (this.bulletinLigne.getBulligValColD() == (double)this.nbJourRef && this.bulletinLigne.getBulligValColD() == 0.0D) {
                        this.valeur = this.utilNombre.myRoundDevise(var4 * var2 / 100.0D, this.structureLog.getStrdevise());
                     } else {
                        this.valeur = this.utilNombre.myRoundDevise(var4 * var2 / 100.0D, this.structureLog.getStrdevise());
                     }
                  } else {
                     this.valeur = this.utilNombre.myRoundDevise(var4 * var2 / 100.0D, this.structureLog.getStrdevise());
                  }
               } else {
                  this.valeur = 0.0D;
               }
            } else if (!this.structureLog.getStrcodepays().equals("0078") && !this.structureLog.getStrcodepays().equals("0088")) {
               if (this.structureLog.getStrcodepays().equals("0089")) {
                  if (this.valeur < 3.0D) {
                     this.valeur = 0.0D;
                  }
               } else if (!this.structureLog.getStrcodepays().equals("0090")) {
                  if (this.structureLog.getStrcodepays().equals("0138")) {
                     boolean var13 = false;
                     if (this.salariesContrats.getSalconConvention() != null && !this.salariesContrats.getSalconConvention().isEmpty() && this.salariesContrats.getSalconConvention().equals("BANQUE")) {
                        if (this.valeur >= 3.0D) {
                           var2 = 5.0D + (this.valeur - 3.0D) * 1.5D;
                           var13 = true;
                        }
                     } else if (this.valeur >= 3.0D) {
                        var2 = this.valeur;
                        if (this.valeur >= 15.0D) {
                           var2 = 15.0D;
                        }

                        var13 = true;
                     }

                     this.valeur = 0.0D;
                     if (var13) {
                        double var5 = 0.0D;
                        if (this.bulletinLigne.getBulligValColB() != 0.0D) {
                           var5 = this.bulletinLigne.getBulligValColB();
                        } else {
                           for(int var7 = 0; var7 < this.lesBulletinsLigne.size(); ++var7) {
                              if (((BulletinLigne)this.lesBulletinsLigne.get(var7)).getBulligNature() == 10 || ((BulletinLigne)this.lesBulletinsLigne.get(var7)).getBulligNature() == 11) {
                                 var5 += ((BulletinLigne)this.lesBulletinsLigne.get(var7)).getBulligValColE();
                              }
                           }
                        }

                        if (this.salaries.getSalNature() == null || this.salaries.getSalNature().isEmpty() || !this.salaries.getSalNature().equals("03D") && !this.salaries.getSalNature().equals("03I")) {
                           if (this.bulletinLigne.getBulligValColD() != (double)this.nbJourRef && this.bulletinLigne.getBulligValColD() != 0.0D) {
                              double var12 = this.utilNombre.myRoundDevise(var5 * var2 / 100.0D, this.structureLog.getStrdevise());
                              double var9 = var12 / (double)this.nbJourRef * this.bulletinLigne.getBulligValColD();
                              this.valeur = this.utilNombre.myRoundDevise(var9, this.structureLog.getStrdevise());
                           } else if (this.bulletinLigne.getBulligValColD() == (double)this.nbJourRef && this.bulletinLigne.getBulligValColD() == 0.0D) {
                              this.valeur = this.utilNombre.myRoundDevise(var5 * var2 / 100.0D, this.structureLog.getStrdevise());
                           } else {
                              this.valeur = this.utilNombre.myRoundDevise(var5 * var2 / 100.0D, this.structureLog.getStrdevise());
                           }
                        } else {
                           this.valeur = var5;
                        }
                     } else {
                        this.valeur = 0.0D;
                     }
                  } else if (!this.structureLog.getStrcodepays().equals("0142")) {
                     if (this.structureLog.getStrcodepays().equals("0202")) {
                        if (this.valeur >= 2.0D) {
                           if (this.salariesContrats.getSalconConvention() != null && !this.salariesContrats.getSalconConvention().isEmpty() && this.salariesContrats.getSalconConvention().equals("ASSURANCES")) {
                              this.valeur += 3.0D;
                              if (this.valeur >= 30.0D) {
                                 var2 = 30.0D;
                              } else {
                                 var2 = this.valeur;
                              }
                           } else if (this.valeur >= 25.0D) {
                              var2 = 25.0D;
                           } else {
                              var2 = this.valeur;
                           }

                           this.valeur = 0.0D;
                           var4 = 0.0D;
                           if (this.bulletinLigne.getBulligValColB() != 0.0D) {
                              var4 = this.bulletinLigne.getBulligValColB();
                           } else {
                              for(var6 = 0; var6 < this.lesBulletinsLigne.size(); ++var6) {
                                 if (((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligNature() == 10 || ((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligNature() == 11) {
                                    var4 += ((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligValColE();
                                 }
                              }
                           }

                           if (this.salaries.getSalNature() == null || this.salaries.getSalNature().isEmpty() || !this.salaries.getSalNature().equals("03D") && !this.salaries.getSalNature().equals("03I")) {
                              if (this.bulletinLigne.getBulligValColD() != (double)this.nbJourRef && this.bulletinLigne.getBulligValColD() != 0.0D) {
                                 var11 = this.utilNombre.myRoundDevise(var4 * var2 / 100.0D, this.structureLog.getStrdevise());
                                 var8 = var11 / (double)this.nbJourRef * this.bulletinLigne.getBulligValColD();
                                 this.valeur = this.utilNombre.myRoundDevise(var8, this.structureLog.getStrdevise());
                              } else if (this.bulletinLigne.getBulligValColD() == (double)this.nbJourRef && this.bulletinLigne.getBulligValColD() == 0.0D) {
                                 this.valeur = this.utilNombre.myRoundDevise(var4 * var2 / 100.0D, this.structureLog.getStrdevise());
                              } else {
                                 this.valeur = this.utilNombre.myRoundDevise(var4 * var2 / 100.0D, this.structureLog.getStrdevise());
                              }
                           } else {
                              this.valeur = var4;
                           }
                        } else {
                           this.valeur = 0.0D;
                        }
                     } else if (!this.structureLog.getStrcodepays().equals("0222")) {
                        this.valeur = 0.0D;
                        if (var2 >= 2.0D) {
                           var4 = 0.0D;
                           if (this.bulletinLigne.getBulligValColB() != 0.0D) {
                              var4 = this.bulletinLigne.getBulligValColB();
                           } else {
                              for(var6 = 0; var6 < this.lesBulletinsLigne.size(); ++var6) {
                                 if (((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligNature() == 10 || ((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligNature() == 11) {
                                    var4 += ((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligValColE();
                                 }
                              }
                           }

                           if (this.salaries.getSalNature() == null || this.salaries.getSalNature().isEmpty() || !this.salaries.getSalNature().equals("03D") && !this.salaries.getSalNature().equals("03I")) {
                              if (this.bulletinLigne.getBulligValColD() != (double)this.nbJourRef && this.bulletinLigne.getBulligValColD() != 0.0D) {
                                 var11 = this.utilNombre.myRoundDevise(var4 * var2 / 100.0D, this.structureLog.getStrdevise());
                                 var8 = var11 / (double)this.nbJourRef * this.bulletinLigne.getBulligValColD();
                                 this.valeur = this.utilNombre.myRoundDevise(var8, this.structureLog.getStrdevise());
                              } else if (this.bulletinLigne.getBulligValColD() != (double)this.nbJourRef && this.bulletinLigne.getBulligValColD() == 0.0D) {
                                 this.valeur = this.utilNombre.myRoundDevise(var4 * var2 / 100.0D, this.structureLog.getStrdevise());
                              } else {
                                 this.valeur = this.utilNombre.myRoundDevise(var4 * var2 / 100.0D, this.structureLog.getStrdevise());
                              }
                           } else {
                              this.valeur = var4;
                           }
                        } else {
                           this.valeur = 0.0D;
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public double M000003(Session var1) throws ParseException {
      Date var2 = null;
      if (this.salaries.getSalDateEntreeInitial() != null) {
         var2 = this.salaries.getSalDateEntreeInitial();
      } else if (this.salariesContrats.getSalconDateDebut() != null) {
         var2 = this.salariesContrats.getSalconDateDebut();
      }

      if (this.salariesContrats != null && var2 != null) {
         byte var3 = 1;
         byte var4 = 12;
         boolean var5 = false;
         boolean var6 = false;
         long var7 = 0L;
         Calendar var9 = Calendar.getInstance();
         Calendar var10 = Calendar.getInstance();
         Calendar var11 = Calendar.getInstance();
         var9.setTime(var2);
         var10.setTime(this.utilDate.dateDernierJourMois(this.dateGeneration));
         int var13 = 0;

         label33:
         while(true) {
            do {
               if (!var9.before(var10)) {
                  int var12 = var13 / var4;
                  var13 -= var12 * var4;
                  var11 = Calendar.getInstance();
                  var11.setTime(var2);
                  var11.add(1, var12);
                  var11.add(2, var13);
                  var7 = (var10.getTimeInMillis() - var11.getTimeInMillis()) / 86400000L;
                  this.valeur = (double)this.utilNombre.myRound((float)var12, 2);
                  break label33;
               }

               var9.add(2, var3);
            } while(!var9.before(var10) && !var9.equals(var10));

            ++var13;
         }
      } else {
         this.valeur = 0.0D;
      }

      if (this.valeur >= 100.0D) {
         this.valeur = 0.0D;
      }

      return this.valeur;
   }

   public void M000004(Session var1) throws HibernateException, NamingException, ParseException {
      this.base_conges = 0.0D;
      Date var2 = null;
      double var3 = 0.0D;
      double var5 = 0.0D;
      if (this.lesHistoriques.size() != 0) {
         for(int var7 = 0; var7 < this.lesHistoriques.size(); ++var7) {
            if ((long)(((SalariesHistorique)this.lesHistoriques.get(var7)).getSalhisDate().getYear() + 1900) == this.exercicesPaye.getExepayId()) {
               if (((SalariesHistorique)this.lesHistoriques.get(var7)).getSalhisCode().equals("BRUT")) {
                  var3 += ((SalariesHistorique)this.lesHistoriques.get(var7)).getSalhisValeurColE();
                  var2 = this.utilDate.dateMoisPrecedent(((SalariesHistorique)this.lesHistoriques.get(var7)).getSalhisDate());
               } else if (((SalariesHistorique)this.lesHistoriques.get(var7)).getSalhisCode().equals("PRDCP")) {
                  var3 -= ((SalariesHistorique)this.lesHistoriques.get(var7)).getSalhisValeurColE();
               } else if (((SalariesHistorique)this.lesHistoriques.get(var7)).getSalhisCode().equals("CP")) {
                  var5 -= ((SalariesHistorique)this.lesHistoriques.get(var7)).getSalhisValeurColE();
               } else if (((SalariesHistorique)this.lesHistoriques.get(var7)).getSalhisCode().equals("NBJS")) {
               }
            }
         }
      }

      new ArrayList();
      List var15 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("208000", this.salaries, var1);
      if (var15.size() != 0) {
         List var8;
         int var9;
         if (var2 != null && var2.compareTo(((BulletinLigne)var15.get(var15.size() - 1)).getBulletinSalaire().getBulsalDateDebut()) < 0) {
            var2 = ((BulletinLigne)var15.get(var15.size() - 1)).getBulletinSalaire().getBulsalDateDebut();
            var3 = 0.0D;
            if (this.optionPaye.getBaseconges().equals("2")) {
               var5 = ((BulletinLigne)var15.get(var15.size() - 1)).getBulligValColE();
               new ArrayList();
               var8 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("208100", this.salaries, var1);
               if (var8.size() != 0) {
                  for(var9 = 0; var9 < var8.size(); ++var9) {
                     if (((BulletinLigne)var8.get(var9)).getBulletinSalaire().getBulsalId() == ((BulletinLigne)var15.get(var15.size() - 1)).getBulletinSalaire().getBulsalId()) {
                        var5 += ((BulletinLigne)var8.get(var9)).getBulligValColE();
                     }
                  }
               }
            }
         } else {
            var2 = ((BulletinLigne)var15.get(var15.size() - 1)).getBulletinSalaire().getBulsalDateDebut();
            var3 = 0.0D;
            if (this.optionPaye.getBaseconges().equals("2")) {
               var5 = ((BulletinLigne)var15.get(var15.size() - 1)).getBulligValColE();
               new ArrayList();
               var8 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("208100", this.salaries, var1);
               if (var8.size() != 0) {
                  for(var9 = 0; var9 < var8.size(); ++var9) {
                     if (((BulletinLigne)var8.get(var9)).getBulletinSalaire().getBulsalId() == ((BulletinLigne)var15.get(var15.size() - 1)).getBulletinSalaire().getBulsalId()) {
                        var5 += ((BulletinLigne)var8.get(var9)).getBulligValColE();
                     }
                  }
               }
            }
         }
      }

      if (var2 == null) {
         var2 = this.utilDate.stringToDateSQLLight("2000-01-01");
      } else {
         var2 = this.utilDate.dateMoisSuivant(var2);
      }

      double var16 = 0.0D;
      new ArrayList();
      List var10 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("299999", var2, this.dateGeneration, this.salaries, var1);
      if (var10.size() != 0) {
         for(int var11 = 0; var11 < var10.size(); ++var11) {
            var16 += ((BulletinLigne)var10.get(var11)).getBulligValColE();
         }
      }

      double var17 = 0.0D;
      new BulletinLigne();

      for(int var14 = 0; var14 < this.lesBulletinsLigne.size(); ++var14) {
         BulletinLigne var13 = (BulletinLigne)this.lesBulletinsLigne.get(var14);
         if (var13.getBulligNature() == 10 || var13.getBulligNature() == 11 || var13.getBulligNature() == 20 || var13.getBulligNature() == 21 || var13.getBulligNature() == 25 || var13.getBulligNature() == 30 || var13.getBulligNature() == 40 || var13.getBulligNature() == 41 || var13.getBulligNature() == 42) {
            var17 += var13.getBulligValColE();
         }
      }

      this.valeur = var3 + var16 + var17 + var5;
      this.base_conges = this.valeur;
   }

   public void M000005(Session var1) throws ParseException, HibernateException, NamingException {
      float var2 = 0.0F;
      float var10;
      if (this.lesConges.size() != 0) {
         Date var3 = this.utilDate.datePremierJourMois(this.dateGeneration);
         Date var4 = this.utilDate.dateDernierJourMois(this.dateGeneration);
         Date var5 = this.utilDate.dateMoisSuivant(this.dateGeneration);
         Date var6 = this.utilDate.datePremierJourMois(var5);
         Date var7 = this.utilDate.dateDernierJourMois(var5);
         new SalariesConges();

         SalariesConges var8;
         int var9;
         for(var9 = 0; var9 < this.lesConges.size(); ++var9) {
            var8 = (SalariesConges)this.lesConges.get(var9);
            if (var8.getSalcngNature() != 0 && var8.getSalcngNature() != 4) {
               if (var8.getSalcngNature() == 2) {
                  if (var3.equals(var8.getSalcngDateDebut()) && var4.equals(var8.getSalcngDateFin())) {
                     var8.setSalcngDuree((float)this.nbJourRef);
                     var2 = var8.getSalcngDuree();
                     this.bulletinSalaire.setBulsalTypeCP(var8.getSalcngNature());
                     break;
                  }
               } else if (var8.getSalcngNature() == 3) {
                  if (var8.getSalcngDateDebut().compareTo(var3) >= 0 && var8.getSalcngDateDebut().compareTo(var4) <= 0) {
                     if (var8.getSalcngDuree() == 0.0F) {
                        if (var8.getSalcngDateDebut() != null && var8.getSalcngDateFin() != null) {
                           var10 = 0.0F;
                           var10 = (float)((var8.getSalcngDateFin().getTime() - var8.getSalcngDateDebut().getTime()) / 86400000L + 1L);
                           var8.setSalcngDuree(var10);
                        } else {
                           var8.setSalcngDuree(0.0F);
                        }
                     }

                     this.bulletinSalaire.setBulsalTypeCP(var8.getSalcngNature());
                     var2 = var8.getSalcngDuree();
                     break;
                  }
               } else if (var8.getSalcngDateDebut().compareTo(var3) >= 0 && var8.getSalcngDateDebut().compareTo(var4) <= 0) {
                  if (var8.getSalcngDuree() == 0.0F) {
                     if (var8.getSalcngDateDebut() != null && var8.getSalcngDateFin() != null) {
                        var10 = 0.0F;
                        var10 = (float)((var8.getSalcngDateFin().getTime() - var8.getSalcngDateDebut().getTime()) / 86400000L + 1L);
                        var8.setSalcngDuree(var10);
                     } else {
                        var8.setSalcngDuree(0.0F);
                     }
                  }

                  this.bulletinSalaire.setBulsalTypeCP(var8.getSalcngNature());
                  var2 = var8.getSalcngDuree();
                  new ArrayList();
                  List var25 = this.bulletinSalaireDao.chargerlesBulletinsbySalarie(this.salaries, var1);
                  float var11 = 0.0F;

                  for(int var12 = 0; var12 < var25.size(); ++var12) {
                     Date var13 = null;
                     if (((BulletinSalaire)var25.get(var12)).getBulsalDateDebutReel() != null) {
                        var13 = ((BulletinSalaire)var25.get(var12)).getBulsalDateDebutReel();
                     } else {
                        var13 = ((BulletinSalaire)var25.get(var12)).getBulsalDateDebut();
                     }

                     if (var13.compareTo(this.dateGeneration) < 0) {
                        var11 = ((BulletinSalaire)var25.get(var12)).getBulsalNbDispo();
                     }
                  }

                  if (var2 > var11) {
                     var2 = var11;
                  }
                  break;
               }
            }
         }

         if (var2 == 0.0F) {
            for(var9 = 0; var9 < this.lesConges.size(); ++var9) {
               var8 = (SalariesConges)this.lesConges.get(var9);
               if (var6.equals(var8.getSalcngDateDebut()) && var7.equals(var8.getSalcngDateFin())) {
                  var8.setSalcngDuree((float)this.nbJourRef);
                  this.bulletinSalaire.setBulsalTypeCP(var8.getSalcngNature());
                  var2 = var8.getSalcngDuree();
                  break;
               }
            }
         }
      }

      if (this.salariesElements.getSaleleEtat() == 2 || this.salariesElements.getSaleleEtat() == 3 || this.salariesElements.getSaleleEtat() == 4 || this.salariesElements.getSaleleEtat() == 5 || this.salariesElements.getSaleleEtat() == 6 || this.salariesElements.getSaleleEtat() == 10) {
         this.type_conges = 1;
         float var18 = 0.0F;
         float var19 = 0.0F;
         float var20 = 0.0F;
         float var21 = 0.0F;
         float var22 = 0.0F;
         float var23 = 0.0F;
         float var24 = 0.0F;
         var10 = 0.0F;
         int var26;
         if (this.lesHistoriques.size() != 0) {
            for(var26 = 0; var26 < this.lesHistoriques.size(); ++var26) {
               if (((SalariesHistorique)this.lesHistoriques.get(var26)).getSalhisCode().startsWith("NBJS")) {
                  var19 += (float)((SalariesHistorique)this.lesHistoriques.get(var26)).getSalhisValeurColE();
               }
            }
         }

         if (this.lesConges.size() != 0) {
            for(var26 = 0; var26 < this.lesConges.size(); ++var26) {
               if (((SalariesConges)this.lesConges.get(var26)).getSalcngType() == 1 && ((SalariesConges)this.lesConges.get(var26)).getSalcngEtat() == 1 && ((SalariesConges)this.lesConges.get(var26)).getSalcngNature() == 8) {
                  var20 += ((SalariesConges)this.lesConges.get(var26)).getSalcngDuree();
               }
            }
         }

         new ArrayList();
         List var28 = this.bulletinLigneDao.chargerlesBulletinsbySalarieExercice(this.salaries, this.exercicesPaye, var1);
         if (var28.size() != 0) {
            new BulletinLigne();

            for(int var30 = 0; var30 < var28.size(); ++var30) {
               BulletinLigne var27 = (BulletinLigne)var28.get(var30);
               if (var27.getBulletinSalaire().getBulsalDateDebut().compareTo(this.dateGeneration) <= 0) {
                  if (var27.getBulligNature() == 10) {
                     double var14;
                     double var16;
                     if (var27.getBulletinSalaire().getBulsalId() == this.bulletinSalaire.getBulsalId()) {
                        if (var27.getBulligRubrique().startsWith("100000")) {
                           var18 = (float)var27.getBulligValColD();
                        } else if (var27.getBulligRubrique().startsWith("100010")) {
                           if (var27.getBulligValColA() == 0.0D) {
                              var27.setBulligValColA(this.M000158());
                           }

                           var14 = var27.getBulligValColA() - var27.getBulligValColD();
                           var16 = this.utilNombre.myRound(var14 / 8.0D, 2);
                           var18 = (float)((double)this.nbJourRef - var16);
                        } else if (var27.getBulligRubrique().startsWith("100050")) {
                           var18 = (float)((double)var18 - var27.getBulligValColD());
                        }
                     }

                     if (var27.getBulligRubrique().startsWith("100000")) {
                        var10 = (float)((double)var10 + var27.getBulligValColD());
                     } else if (var27.getBulligRubrique().startsWith("100010")) {
                        if (var27.getBulligValColA() == 0.0D) {
                           var27.setBulligValColA(this.M000158());
                        }

                        var14 = var27.getBulligValColA() - var27.getBulligValColD();
                        var16 = this.utilNombre.myRound(var14 / 8.0D, 2);
                        var10 = (float)((double)var10 + ((double)this.nbJourRef - var16));
                     } else if (var27.getBulligRubrique().startsWith("100050")) {
                        var10 = (float)((double)var10 - var27.getBulligValColD());
                     }
                  } else if (var27.getBulligNature() == 40) {
                     if (var27.getBulletinSalaire().getBulsalId() == this.bulletinSalaire.getBulsalId() && var27.getBulligRubrique().startsWith("208000")) {
                        var21 = (float)var27.getBulligValColD();
                     }

                     if (var27.getBulligRubrique().startsWith("208000")) {
                        var22 = (float)((double)var22 + var27.getBulligValColD());
                     }
                  }
               }
            }
         }

         if (this.salariesElements.getSaleleNbJourTr() != 0.0F) {
            float var29 = this.salariesElements.getSaleleNbJourTr() / (float)this.nbJourRef;
            var24 = this.salariesElements.getSaleleNbJourCp() / (this.salariesElements.getSaleleNbJourTr() / var29) * var10;
         } else {
            var24 = 0.0F;
         }

         var23 = var19 + var24 + var20 - var22;
         if (var23 < 0.0F) {
            var23 = 0.0F;
         }

         var2 = var23;
         if (var23 == 0.0F) {
            var2 = 1.0F;
         }
      }

      this.valeur = (double)var2;
   }

   public void M000006(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      if (this.bulletinLigne.getBulligValColB() != 0.0D && this.bulletinLigne.getBulligValColD() != 0.0D) {
         if (this.bulletinSalaire.getBulsalTypeCP() != 4 && this.bulletinSalaire.getBulsalTypeCP() != 6) {
            if (this.salariesElements.getSaleleNbJourTr() != 0.0F || this.salariesElements.getSaleleEtat() >= 2 && this.salariesElements.getSaleleEtat() <= 6) {
               var2 = this.bulletinLigne.getBulligValColB() * (double)this.salariesElements.getSaleleNbJourCp() / (double)this.salariesElements.getSaleleNbJourTr();
            }
         } else {
            float var4 = 0.0F;
            float var5 = 0.0F;
            float var6 = 0.0F;
            float var7 = 0.0F;
            if (this.lesHistoriques.size() != 0) {
               for(int var8 = 0; var8 < this.lesHistoriques.size(); ++var8) {
                  if (((SalariesHistorique)this.lesHistoriques.get(var8)).getSalhisCode().equals("NBJS")) {
                     var4 = (float)((SalariesHistorique)this.lesHistoriques.get(var8)).getSalhisValeurColE();
                     break;
                  }
               }
            }

            new ArrayList();
            List var15 = this.bulletinSalaireDao.chargerlesBulletinsbySalarie(this.salaries, this.dateGeneration, var1);
            if (var15.size() != 0) {
               for(int var9 = 0; var9 < var15.size(); ++var9) {
                  var5 += ((BulletinSalaire)var15.get(var9)).getBulsalNbCpAcquis();
                  var6 += ((BulletinSalaire)var15.get(var9)).getBulsalNbCpPris();
               }
            }

            var7 = var4 + var5 - var6;
            if (var7 != 0.0F) {
               if (this.bulletinLigne.getBulligValColD() > (double)var7) {
                  this.bulletinLigne.setBulligValColD((double)var7);
               }

               double var16 = this.bulletinLigne.getBulligValColB() * (double)this.salariesElements.getSaleleNbJourCp() / (double)this.salariesElements.getSaleleNbJourTr();
               double var11 = var16 / (double)var7;
               var2 = var11 * this.bulletinLigne.getBulligValColD();
            }
         }

         if (this.bulletinSalaire.getBulsalTypeCP() == 2) {
            new BulletinLigne();

            for(int var14 = 0; var14 < this.lesBulletinsLigne.size(); ++var14) {
               BulletinLigne var13 = (BulletinLigne)this.lesBulletinsLigne.get(var14);
               if (var13.getBulligNature() <= 30 || var13.getBulligNature() == 40 || var13.getBulligNature() == 42) {
                  var13 = this.bulletinLigneDao.trouvePorParapheur(var13.getBulligId(), var1);
                  if (var13 != null) {
                     this.bulletinLigneDao.delete(var13, var1);
                     this.lesBulletinsLigne.remove(var13);
                     --var14;
                  }
               }
            }
         }

         var2 = this.calculARR(var2);
      }

      this.valeur = var2;
   }

   public void M000007(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      if (this.modeRegularisation == 0 && this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12) {
         var2 = this.calculBrutEnCours(var1);
         var4 = this.optionPaye.getSecuriteSocialeGene();
      } else if (this.modeRegularisation == 2) {
         var2 = this.calculBrutEnCours(var1);
         var4 = this.optionPaye.getSecuriteSocialeGene();
      } else {
         var2 = this.calculBrutTotal(var1);
         var6 = this.calculRubriqueTotal("300000", var1) * -1.0D;
         var4 = this.optionPaye.getSecuriteSocialeGene() * (double)this.calculNbMoisPresence();
      }

      if (this.bulletinLigne.getBulligValColB() != 0.0D) {
         if (var2 > var4) {
            this.valeur = var4 * this.bulletinLigne.getBulligValColC() / 100.0D;
         } else {
            this.valeur = var2 * this.bulletinLigne.getBulligValColC() / 100.0D;
         }
      } else {
         this.valeur = 0.0D;
      }

      this.valeur -= var6;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000008(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
         var2 = this.calculBrutEnCours(var1);
         var4 = this.optionPaye.getSecuriteSocialeGene();
      } else if (this.modeRegularisation == 2) {
         var2 = this.calculBrutEnCours(var1);
         var4 = this.optionPaye.getSecuriteSocialeGene();
      } else {
         var2 = this.calculBrutTotal(var1);
         var6 = this.calculRubriqueTotal("900000", var1) * -1.0D;
         var4 = this.optionPaye.getSecuriteSocialeGene() * (double)this.calculNbMoisPresence();
      }

      if (this.bulletinLigne.getBulligValColB() != 0.0D) {
         if (var2 > var4) {
            this.valeur = var4 * this.bulletinLigne.getBulligValColC() / 100.0D;
         } else {
            this.valeur = var2 * this.bulletinLigne.getBulligValColC() / 100.0D;
         }
      } else {
         this.valeur = 0.0D;
      }

      this.valeur -= var6;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000009(Session var1) throws HibernateException, NamingException {
      if (this.salariesElements.getSaleleNivEmploi().equals("1")) {
         double var2 = 0.0D;
         double var4 = 0.0D;
         double var6 = 0.0D;
         if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
            var2 = this.calculBrutEnCours(var1);
            var4 = this.optionPaye.getSecuriteSocialeCadre();
         } else if (this.modeRegularisation == 2) {
            var2 = this.calculBrutEnCours(var1);
            var4 = this.optionPaye.getSecuriteSocialeCadre();
         } else {
            var2 = this.calculBrutTotal(var1);
            var6 = this.calculRubriqueTotal("300010", var1) * -1.0D;
            var4 = this.optionPaye.getSecuriteSocialeCadre() * (double)this.calculNbMoisPresence();
         }

         if (this.bulletinLigne.getBulligValColB() != 0.0D) {
            if (var2 > var4) {
               this.valeur = var4 * this.bulletinLigne.getBulligValColC() / 100.0D;
            } else {
               this.valeur = var2 * this.bulletinLigne.getBulligValColC() / 100.0D;
            }
         } else {
            this.valeur = 0.0D;
         }

         this.valeur -= var6;
         this.valeur = this.calculARR(this.valeur);
      } else {
         this.valeur = 0.0D;
      }

   }

   public void M000010(Session var1) throws HibernateException, NamingException {
      if (this.salariesElements.getSaleleNivEmploi().equals("1")) {
         double var2 = 0.0D;
         double var4 = 0.0D;
         double var6 = 0.0D;
         if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
            var2 = this.calculBrutEnCours(var1);
            var4 = this.optionPaye.getSecuriteSocialeCadre();
         } else if (this.modeRegularisation == 2) {
            var2 = this.calculBrutEnCours(var1);
            var4 = this.optionPaye.getSecuriteSocialeCadre();
         } else {
            var2 = this.calculBrutTotal(var1);
            var6 = this.calculRubriqueTotal("900010", var1) * -1.0D;
            var4 = this.optionPaye.getSecuriteSocialeCadre() * (double)this.calculNbMoisPresence();
         }

         if (this.bulletinLigne.getBulligValColB() != 0.0D) {
            if (var2 > var4) {
               this.valeur = var4 * this.bulletinLigne.getBulligValColC() / 100.0D;
            } else {
               this.valeur = var2 * this.bulletinLigne.getBulligValColC() / 100.0D;
            }
         } else {
            this.valeur = 0.0D;
         }

         this.valeur -= var6;
         this.valeur = this.calculARR(this.valeur);
      } else {
         this.valeur = 0.0D;
      }

   }

   public void M000011(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
         var2 = this.calculBrutEnCours(var1);
         var4 = this.optionPaye.getPrestationMedicaleGene();
      } else if (this.modeRegularisation == 2) {
         var2 = this.calculBrutEnCours(var1);
         var4 = this.optionPaye.getPrestationMedicaleGene();
      } else {
         var2 = this.calculBrutTotal(var1);
         var6 = this.calculRubriqueTotal("300100", var1) * -1.0D;
         var4 = this.optionPaye.getPrestationMedicaleGene() * (double)this.calculNbMoisPresence();
      }

      if (this.optionPaye.getPrestationMedicaleGene() != 0.0D) {
         if (var2 > var4) {
            this.valeur = var4 * this.bulletinLigne.getBulligValColC() / 100.0D;
         } else {
            this.valeur = var2 * this.bulletinLigne.getBulligValColC() / 100.0D;
         }
      } else {
         this.valeur = 0.0D;
         var6 = 0.0D;
      }

      this.valeur -= var6;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000012(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
         var2 = this.calculBrutEnCours(var1);
         var4 = this.optionPaye.getPrestationMedicaleGene();
      } else if (this.modeRegularisation == 2) {
         var2 = this.calculBrutEnCours(var1);
         var4 = this.optionPaye.getPrestationMedicaleGene();
      } else {
         var2 = this.calculBrutTotal(var1);
         var6 = this.calculRubriqueTotal("900050", var1) * -1.0D;
         var4 = this.optionPaye.getPrestationMedicaleGene() * (double)this.calculNbMoisPresence();
      }

      if (this.optionPaye.getPrestationMedicaleGene() != 0.0D) {
         if (var2 > var4) {
            this.valeur = var4 * this.bulletinLigne.getBulligValColC() / 100.0D;
         } else {
            this.valeur = var2 * this.bulletinLigne.getBulligValColC() / 100.0D;
         }
      } else {
         this.valeur = 0.0D;
         var6 = 0.0D;
      }

      this.valeur -= var6;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000013(Session var1) throws HibernateException, NamingException {
      int var2 = 1;
      int var3 = 1;
      if (this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && this.salariesElements.getSaleleNature().equals("04")) {
         var3 = 360;
      }

      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      double var10 = 0.0D;
      boolean var12 = false;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0 && this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && !this.salariesElements.getSaleleNature().equals("04")) {
         var4 = this.calculBrutEnCours(var1);
         var6 = this.calculAvnEnCours(var1);
         var10 = (var4 + var6) * 12.0D;
      } else if (this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && this.salariesElements.getSaleleNature().equals("04")) {
         var10 = this.calculBrutEnCours(var1);
      } else if (this.modeRegularisation == 2) {
         var4 = this.calculBrutEnCours(var1);
         var6 = this.calculAvnEnCours(var1);
         var10 = (var4 + var6) * 12.0D;
      } else {
         var2 = (int)this.calculNbMoisPresence();
         var3 = var2;
         var4 = this.calculBrutTotal(var1);
         var6 = this.calculAvnTotal(var1);
         var8 = this.calculRubriqueTotal("300200", var1) * -1.0D;
         var10 = var4 + var6;
         var12 = true;
      }

      double var13 = this.utilNombre.myRound(var10 * 0.3D, 0);
      if (var13 > (double)(900000 / var3 * var2)) {
         var13 = (double)(900000 / var3 * var2);
      }

      double var15 = var10 - var13;
      double var17 = 0.0D;
      if (var15 <= (double)(630000 / var3 * var2)) {
         var17 = 0.0D;
      } else if (var15 >= (double)(630001 / var3 * var2) & var15 <= (double)(1500000 / var3 * var2)) {
         var17 = (var15 - (double)(630000 / var3 * var2)) * 0.2D;
      } else if (var15 >= (double)(1500001 / var3 * var2) & var15 <= (double)(4000000 / var3 * var2)) {
         var17 = (double)(870000 / var3 * var2) * 0.2D + (var15 - (double)(1500000 / var3 * var2)) * 0.3D;
      } else if (var15 >= (double)(4000000 / var3 * var2) & var15 <= (double)(8000000 / var3 * var2)) {
         var17 = (double)(870000 / var3 * var2) * 0.2D + (double)(2500000 / var3 * var2) * 0.3D + (var15 - (double)(4000000 / var3 * var2)) * 0.35D;
      } else if (var15 >= (double)(8000000 / var3 * var2) & var15 <= (double)(13500000 / var3 * var2)) {
         var17 = (double)(870000 / var3 * var2) * 0.2D + (double)(2500000 / var3 * var2) * 0.3D + (double)(4000000 / var3 * var2) * 0.35D + (var15 - (double)(8000000 / var3 * var2)) * 0.37D;
      } else if (var15 >= (double)(13500001 / var3 * var2)) {
         var17 = (double)(870000 / var3 * var2) * 0.2D + (double)(2500000 / var3 * var2) * 0.3D + (double)(4000000 / var3 * var2) * 0.35D + (double)(5500000 / var3 * var2) * 0.37D + (var15 - (double)(13500000 / var3 * var2)) * 0.4D;
      }

      var17 = this.calculARR(var17);
      double var19 = 0.0D;
      if (this.salariesElements.getSaleleNbPartFiscal() == 1.0F) {
         var19 = 0.0D;
      } else if ((double)this.salariesElements.getSaleleNbPartFiscal() == 1.5D) {
         var19 = var17 * 0.1D;
         if (var19 >= (double)(300000 / var3 * var2)) {
            var19 = (double)(300000 / var3 * var2);
         } else if (var19 <= (double)(100000 / var3 * var2)) {
            var19 = (double)(100000 / var3 * var2);
         }
      } else if (this.salariesElements.getSaleleNbPartFiscal() == 2.0F) {
         var19 = var17 * 0.15D;
         if (var19 >= (double)(650000 / var3 * var2)) {
            var19 = (double)(650000 / var3 * var2);
         } else if (var19 <= (double)(200000 / var3 * var2)) {
            var19 = (double)(200000 / var3 * var2);
         }
      } else if ((double)this.salariesElements.getSaleleNbPartFiscal() == 2.5D) {
         var19 = var17 * 0.2D;
         if (var19 >= (double)(1100000 / var3 * var2)) {
            var19 = (double)(1100000 / var3 * var2);
         } else if (var19 <= (double)(300000 / var3 * var2)) {
            var19 = (double)(300000 / var3 * var2);
         }
      } else if (this.salariesElements.getSaleleNbPartFiscal() == 3.0F) {
         var19 = var17 * 0.25D;
         if (var19 >= (double)(1650000 / var3 * var2)) {
            var19 = (double)(1650000 / var3 * var2);
         } else if (var19 <= (double)(400000 / var3 * var2)) {
            var19 = (double)(400000 / var3 * var2);
         }
      } else if ((double)this.salariesElements.getSaleleNbPartFiscal() == 3.5D) {
         var19 = var17 * 0.3D;
         if (var19 >= (double)(2030000 / var3 * var2)) {
            var19 = (double)(2030000 / var3 * var2);
         } else if (var19 <= (double)(500000 / var3 * var2)) {
            var19 = (double)(500000 / var3 * var2);
         }
      } else if (this.salariesElements.getSaleleNbPartFiscal() == 4.0F) {
         var19 = var17 * 0.35D;
         if (var19 >= (double)(2490000 / var3 * var2)) {
            var19 = (double)(2490000 / var3 * var2);
         } else if (var19 <= (double)(600000 / var3 * var2)) {
            var19 = (double)(600000 / var3 * var2);
         }
      } else if ((double)this.salariesElements.getSaleleNbPartFiscal() == 4.5D) {
         var19 = var17 * 0.4D;
         if (var19 >= (double)(2755000 / var3 * var2)) {
            var19 = (double)(2755000 / var3 * var2);
         } else if (var19 <= (double)(700000 / var3 * var2)) {
            var19 = (double)(700000 / var3 * var2);
         }
      } else if (this.salariesElements.getSaleleNbPartFiscal() == 5.0F) {
         var19 = var17 * 0.45D;
         if (var19 >= (double)(3180000 / var3 * var2)) {
            var19 = (double)(3180000 / var3 * var2);
         } else if (var19 <= (double)(800000 / var3 * var2)) {
            var19 = (double)(800000 / var3 * var2);
         }
      }

      double var21 = 0.0D;
      if (var17 > var19) {
         var21 = var17 - var19;
      } else {
         var21 = 0.0D;
      }

      if (this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && !this.salariesElements.getSaleleNature().equals("04")) {
         if (!var12) {
            var21 /= 12.0D;
         } else {
            var21 -= var8;
         }
      }

      this.valeur = this.calculARR(var21);
   }

   public void M000014(Session var1) throws HibernateException, NamingException {
      short var2 = 1;
      if (this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && this.salariesElements.getSaleleNature().equals("04")) {
         var2 = 360;
      }

      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = 0.0D;
      float var11 = 1.0F;
      float var12 = this.salariesElements.getSaleleNbPartTrimf();
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0 && this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && !this.salariesElements.getSaleleNature().equals("04")) {
         var3 = this.calculBrutEnCours(var1);
         var5 = this.calculAvnEnCours(var1);
      } else if (this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && this.salariesElements.getSaleleNature().equals("04")) {
         var3 = this.calculBrutEnCours(var1);
         var5 = this.calculAvnEnCours(var1);
      } else if (this.modeRegularisation == 2) {
         var3 = this.calculBrutEnCours(var1);
         var5 = this.calculAvnEnCours(var1);
      } else {
         if (this.salariesElements.getSaleleEtat() >= 2) {
            var11 = 12.0F;
         } else {
            var11 = this.calculNbMoisPresence();
         }

         var3 = this.calculBrutTotal(var1);
         var5 = this.calculAvnTotal(var1);
         var7 = this.calculRubriqueTotal("300300", var1) * -1.0D;
      }

      double var13 = var3 + var5;
      if (var13 <= (double)((float)('썏' / var2) * var11)) {
         var9 = 0.0D;
      } else if (var13 >= (double)((float)('썐' / var2) * var11) & var13 <= (double)((float)(83332 / var2) * var11)) {
         var9 = (double)((float)(300 / var2) * var11);
      } else if (var13 >= (double)((float)(83333 / var2) * var11) & var13 <= (double)((float)(166665 / var2) * var11)) {
         var9 = (double)((float)(400 / var2) * var11);
      } else if (var13 >= (double)((float)(166666 / var2) * var11) & var13 <= (double)((float)(583332 / var2) * var11)) {
         if (this.optionPaye.getTrimf().equals("1")) {
            var9 = (double)((float)(500 / var2) * var11);
         } else {
            var9 = (double)((float)(1000 / var2) * var11);
         }
      } else if (var13 >= (double)((float)(583333 / var2) * var11) & var13 <= (double)((float)(999999 / var2) * var11)) {
         var9 = (double)((float)(1500 / var2) * var11);
      } else if (var13 >= (double)((float)(1000000 / var2) * var11)) {
         var9 = (double)((float)(3000 / var2) * var11);
      }

      if (var12 == 0.0F) {
         var12 = 1.0F;
      }

      double var15 = this.utilNombre.myRoundDevise(var9 * (double)var12, this.structureLog.getStrdevise());
      this.valeur = var15 - var7;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000015(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
         var2 = this.calculBrutEnCours(var1);
         var4 = this.optionPaye.getCotisationSocialeGene();
      } else if (this.modeRegularisation == 2) {
         var2 = this.calculBrutEnCours(var1);
         var4 = this.optionPaye.getCotisationSocialeGene();
      } else {
         var2 = this.calculBrutTotal(var1);
         var6 = this.calculRubriqueTotal("900020", var1) * -1.0D;
         var4 = this.optionPaye.getCotisationSocialeGene() * (double)this.calculNbMoisPresence();
      }

      if (this.optionPaye.getCotisationSocialeGene() != 0.0D) {
         if (var2 > var4) {
            this.valeur = var4 * this.bulletinLigne.getBulligValColC() / 100.0D;
         } else {
            this.valeur = var2 * this.bulletinLigne.getBulligValColC() / 100.0D;
         }
      } else {
         this.valeur = 0.0D;
         var6 = 0.0D;
      }

      this.valeur -= var6;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000016(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
         var2 = this.calculBrutEnCours(var1);
         var4 = this.optionPaye.getCotisationSocialeGene();
      } else if (this.modeRegularisation == 2) {
         var2 = this.calculBrutEnCours(var1);
         var4 = this.optionPaye.getCotisationSocialeGene();
      } else {
         var2 = this.calculBrutTotal(var1);
         var6 = this.calculRubriqueTotal("900030", var1) * -1.0D;
         var4 = this.optionPaye.getCotisationSocialeGene() * (double)this.calculNbMoisPresence();
      }

      if (this.optionPaye.getCotisationSocialeGene() != 0.0D) {
         if (var2 > var4) {
            this.valeur = var4 * this.bulletinLigne.getBulligValColC() / 100.0D;
         } else {
            this.valeur = var2 * this.bulletinLigne.getBulligValColC() / 100.0D;
         }
      } else {
         this.valeur = 0.0D;
         var6 = 0.0D;
      }

      this.valeur -= var6;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000017(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() != 12 && this.modeRegularisation == 0) {
         var2 = this.bulletinLigne.getBulligValColB();
      } else if (this.modeRegularisation == 2) {
         var2 = this.bulletinLigne.getBulligValColB();
      } else {
         var2 = this.calculBaseImposasableSocialeTotal(var1);
      }

      this.valeur = var2 * this.bulletinLigne.getBulligValColC() / 100.0D;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000018(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
         var2 = this.bulletinLigne.getBulligValColB();
      } else if (this.modeRegularisation == 2) {
         var2 = this.bulletinLigne.getBulligValColB();
      } else {
         var2 = this.calculBaseImposasableSocialeTotal(var1);
      }

      this.valeur = var2 * this.bulletinLigne.getBulligValColC() / 100.0D;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000019(Session var1) throws HibernateException, NamingException, ParseException {
      double var2 = 0.0D;
      double var4 = 0.0D;
      boolean var6 = false;
      var2 = this.bulletinLigne.getBulligValColB();
      var4 = (double)((int)(var2 / 250.0D));
      var4 = var4 * 250.0D * 12.0D;
      double var7 = 0.0D;
      if (!this.dateGeneration.after(this.utilDate.stringToDateSQLLight("2016-05-01")) && !this.dateGeneration.equals(this.utilDate.stringToDateSQLLight("2016-05-01"))) {
         if (var4 <= 175000.0D) {
            var7 = 0.0D;
            var6 = true;
         } else if (var4 >= 175001.0D & var4 <= 600000.0D) {
            var7 = (var4 - 175001.0D) * 0.05D;
         } else if (var4 >= 600001.0D & var4 <= 1200000.0D) {
            var7 = 21250.0D + (var4 - 600001.0D) * 0.13D;
         } else if (var4 >= 1200001.0D & var4 <= 1800000.0D) {
            var7 = 99250.0D + (var4 - 1200001.0D) * 0.2D;
         } else if (var4 >= 1800001.0D & var4 <= 2400000.0D) {
            var7 = 219250.0D + (var4 - 1800001.0D) * 0.28D;
         } else if (var4 >= 2400001.0D & var4 <= 3500000.0D) {
            var7 = 387250.0D + (var4 - 2400001.0D) * 0.34D;
         } else if (var4 >= 3500001.0D) {
            var7 = 761250.0D + (var4 - 3500001.0D) * 0.4D;
         }
      } else if (var4 <= 330000.0D) {
         var7 = 0.0D;
         var6 = true;
      } else if (var4 >= 330001.0D & var4 <= 578400.0D) {
         var7 = (var4 - 330001.0D) * 0.05D;
      } else if (var4 >= 578401.0D & var4 <= 1176400.0D) {
         var7 = 12400.0D + (var4 - 578401.0D) * 0.12D;
      } else if (var4 >= 1176401.0D & var4 <= 1789733.0D) {
         var7 = 84160.0D + (var4 - 1176401.0D) * 0.18D;
      } else if (var4 >= 1789734.0D & var4 <= 2384195.0D) {
         var7 = 194560.0D + (var4 - 1789733.0D) * 0.26D;
      } else if (var4 >= 2384196.0D & var4 <= 3494130.0D) {
         var7 = 349120.0D + (var4 - 2384195.0D) * 0.31D;
      } else if (var4 >= 3494131.0D) {
         var7 = 693200.0D + (var4 - 3494130.0D) * 0.37D;
      }

      if (!var6) {
         var7 = this.calculARR(var7);
         double var9 = 0.0D;
         if (this.salariesElements.getSaleleSitFamille() != 0 && this.salariesElements.getSaleleSitFamille() != 4 && this.salariesElements.getSaleleSitFamille() != 5) {
            var9 = 10.0D;
         } else {
            var9 = 0.0D;
         }

         if (this.salariesElements.getSaleleNbEnfant() >= 10) {
            this.salariesElements.setSaleleNbEnfant(10);
         }

         var9 += (double)this.salariesElements.getSaleleNbEnfant() * 2.5D;
         if (var9 != 0.0D) {
            var7 -= var7 * var9 / 100.0D;
         }

         float var11 = (float)(var7 / var4 * 100.0D);
         float var12 = var11 - 2.0F;
         double var13 = var4 * (double)var12 / 100.0D;
         double var15 = var13 / 12.0D;
         this.valeur = this.calculARR(var15);
      } else {
         this.valeur = this.calculARR(0.0D);
      }

   }

   public void M000020(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      double var4 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
         var2 = this.bulletinLigne.getBulligValColB();
      } else if (this.modeRegularisation == 2) {
         var2 = this.bulletinLigne.getBulligValColB();
      } else {
         var2 = this.calculBaseImposasablePatronaleTotal(var1);
         var4 = this.calculRubriqueTotal("900050", var1) * -1.0D;
      }

      if (this.bulletinLigne.getBulligValColC() != 0.0D) {
         this.valeur = var2 * this.bulletinLigne.getBulligValColC() / 100.0D;
      } else {
         this.valeur = var2 * 3.5D / 100.0D;
      }

      this.valeur -= var4;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000021(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      double var4 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
         var2 = this.bulletinLigne.getBulligValColB();
      } else if (this.modeRegularisation == 2) {
         var2 = this.bulletinLigne.getBulligValColB();
      } else {
         var2 = this.calculBaseImposasablePatronaleTotal(var1);
         var4 = this.calculRubriqueTotal("900060", var1) * -1.0D;
      }

      if (this.bulletinLigne.getBulligValColC() != 0.0D) {
         this.valeur = var2 * this.bulletinLigne.getBulligValColC() / 100.0D;
      } else {
         this.valeur = var2 * 2.0D / 100.0D;
      }

      this.valeur -= var4;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000022(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      double var4 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
         var2 = this.bulletinLigne.getBulligValColB();
      } else if (this.modeRegularisation == 2) {
         var2 = this.bulletinLigne.getBulligValColB();
      } else {
         var2 = this.calculBaseImposasablePatronaleTotal(var1);
         var4 = this.calculRubriqueTotal("900070", var1) * -1.0D;
      }

      if (this.bulletinLigne.getBulligValColC() != 0.0D) {
         this.valeur = var2 * this.bulletinLigne.getBulligValColC() / 100.0D;
      } else {
         this.valeur = var2 * 1.0D / 100.0D;
      }

      this.valeur -= var4;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000023(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      double var4 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
         var2 = this.bulletinLigne.getBulligValColB();
      } else if (this.modeRegularisation == 2) {
         var2 = this.bulletinLigne.getBulligValColB();
      } else {
         var2 = this.calculBaseImposasablePatronaleTotal(var1);
         var4 = this.calculRubriqueTotal("900080", var1) * -1.0D;
      }

      if (this.bulletinLigne.getBulligValColC() != 0.0D) {
         this.valeur = var2 * this.bulletinLigne.getBulligValColC() / 100.0D;
      } else {
         this.valeur = var2 * 2.0D / 100.0D;
      }

      this.valeur -= var4;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000024(Session var1) throws HibernateException, NamingException, ParseException {
      boolean var2 = true;
      boolean var3 = true;
      if (this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && this.salariesElements.getSaleleNature().equals("04")) {
         var3 = true;
      }

      this.valeur = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      Date var10 = this.d1;
      Date var11 = this.d2;
      var8 = this.optionPaye.getSecuriteSocialeGene() * this.optionPaye.getTauxcnssPS() / 100.0D;
      if (this.dateGeneration.getMonth() + 1 != 3 && this.dateGeneration.getMonth() + 1 != 6 && this.dateGeneration.getMonth() + 1 != 9 && this.dateGeneration.getMonth() + 1 != 12) {
         this.valeur = this.bulletinLigne.getBulligValColB() * (this.optionPaye.getTauxcnssPS() / 100.0D);
      } else {
         if (this.dateGeneration.getMonth() + 1 == 3) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-01-01");
            var11 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-03-31");
         } else if (this.dateGeneration.getMonth() + 1 == 6) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-04-01");
            var11 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-06-30");
         } else if (this.dateGeneration.getMonth() + 1 == 9) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-07-01");
            var11 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-09-30");
         } else if (this.dateGeneration.getMonth() + 1 == 12) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-10-01");
            var11 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-12-31");
         }

         new ArrayList();
         new ArrayList();
         double var14 = 0.0D;
         if (this.netAAtteindre != 0.0D) {
            for(int var16 = 0; var16 < this.lesBulletinsLigne.size(); ++var16) {
               if (((BulletinLigne)this.lesBulletinsLigne.get(var16)).getBulligNature() == 59) {
                  var14 += ((BulletinLigne)this.lesBulletinsLigne.get(var16)).getBulligValColE();
               }
            }
         }

         double var19 = 0.0D;
         List var13 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("299999", var10, var11, this.salaries, var1);

         int var18;
         for(var18 = 0; var18 < var13.size(); ++var18) {
            var19 += ((BulletinLigne)var13.get(var18)).getBulligValColE();
         }

         List var12 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("300000", var10, var11, this.salaries, var1);

         for(var18 = 0; var18 < var12.size(); ++var18) {
            var4 += ((BulletinLigne)var12.get(var18)).getBulligValColE();
         }

         var4 *= -1.0D;
         var6 = var19 + var14;
         this.valeur = var6 * (this.optionPaye.getTauxcnssPS() / 100.0D);
         this.valeur -= var4;
      }

      if (this.valeur > var8) {
         this.valeur = var8;
      }

      this.valeur = this.calculARR(this.valeur);
   }

   public void M000025(Session var1) throws HibernateException, NamingException, ParseException {
      boolean var2 = true;
      boolean var3 = true;
      if (this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && this.salariesElements.getSaleleNature().equals("04")) {
         var3 = true;
      }

      this.valeur = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      Date var10 = this.d1;
      Date var11 = this.d2;
      var8 = this.optionPaye.getSecuriteSocialeGene() * this.optionPaye.getTauxcnssPP() / 100.0D;
      if (this.dateGeneration.getMonth() + 1 != 3 && this.dateGeneration.getMonth() + 1 != 6 && this.dateGeneration.getMonth() + 1 != 9 && this.dateGeneration.getMonth() + 1 != 12) {
         this.valeur = this.bulletinLigne.getBulligValColB() * (this.optionPaye.getTauxcnssPP() / 100.0D);
      } else {
         if (this.dateGeneration.getMonth() + 1 == 3) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-01-01");
            var11 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-03-31");
         } else if (this.dateGeneration.getMonth() + 1 == 6) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-04-01");
            var11 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-06-30");
         } else if (this.dateGeneration.getMonth() + 1 == 9) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-07-01");
            var11 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-09-30");
         } else if (this.dateGeneration.getMonth() + 1 == 12) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-10-01");
            var11 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-12-31");
         }

         new ArrayList();
         new ArrayList();
         double var14 = 0.0D;
         if (this.netAAtteindre != 0.0D) {
            for(int var16 = 0; var16 < this.lesBulletinsLigne.size(); ++var16) {
               if (((BulletinLigne)this.lesBulletinsLigne.get(var16)).getBulligNature() == 59) {
                  var14 += ((BulletinLigne)this.lesBulletinsLigne.get(var16)).getBulligValColE();
               }
            }
         }

         double var19 = 0.0D;
         List var13 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("299999", var10, var11, this.salaries, var1);

         int var18;
         for(var18 = 0; var18 < var13.size(); ++var18) {
            var19 += ((BulletinLigne)var13.get(var18)).getBulligValColE();
         }

         List var12 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("900000", var10, var11, this.salaries, var1);

         for(var18 = 0; var18 < var12.size(); ++var18) {
            var4 += ((BulletinLigne)var12.get(var18)).getBulligValColE();
         }

         var4 *= -1.0D;
         var6 = var19 + var14;
         this.valeur = var6 * (this.optionPaye.getTauxcnssPP() / 100.0D);
         this.valeur -= var4;
      }

      if (this.valeur > var8) {
         this.valeur = var8;
      }

      this.valeur = this.calculARR(this.valeur);
   }

   public void M000026(Session var1) throws HibernateException, NamingException {
      int var2 = 1;
      short var3 = 1;
      if (this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && this.salariesElements.getSaleleNature().equals("04")) {
         var3 = 360;
      }

      this.valeur = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      if (this.bulletinLigne.getBulligValColA() == 0.0D) {
         var6 = this.M000150(var1);
         this.valeur = 0.0D;
      } else {
         var6 = this.bulletinLigne.getBulligValColA();
      }

      if ((this.salariesElements.getSaleleEtat() > 1 || this.dateGeneration.getMonth() + 1 == 12 || this.modeRegularisation != 0) && this.modeRegularisation != 2) {
         var2 = (int)this.calculNbMoisPresence();
         var4 = this.calculRubriqueTotal("300100", var1) * -1.0D;
      }

      if (this.dateGeneration.getYear() + 1900 <= 2009) {
         if (var6 >= (double)(66000 / var3 * var2)) {
            if (var6 <= (double)(100000 / var3 * var2)) {
               this.valeur = var6 * 0.01D;
            } else {
               this.valeur = (var6 - (double)(100000 / var3 * var2)) * 0.055D + 1000.0D;
            }
         }
      } else if (this.dateGeneration.getYear() + 1900 >= 2010 && this.dateGeneration.getYear() + 1900 <= 2012) {
         if (var6 >= (double)(100000 / var3 * var2)) {
            this.valeur = (var6 - (double)(100000 / var3 * var2)) * 0.055D;
         }
      } else if (this.dateGeneration.getYear() + 1900 >= 2013 && var6 >= (double)(150000 / var3 * var2)) {
         this.valeur = (var6 - (double)(150000 / var3 * var2)) * 0.05D;
      }

      this.valeur -= var4;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000027(Session var1) throws HibernateException, NamingException {
      int var2 = 1;
      short var3 = 1;
      if (this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && this.salariesElements.getSaleleNature().equals("04")) {
         var3 = 360;
      }

      this.valeur = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      if (this.bulletinLigne.getBulligValColA() == 0.0D) {
         var6 = this.M000151(var1);
         this.valeur = 0.0D;
      } else {
         var6 = this.bulletinLigne.getBulligValColA();
      }

      if ((this.salariesElements.getSaleleEtat() > 1 || this.dateGeneration.getMonth() + 1 == 12 || this.modeRegularisation != 0) && this.modeRegularisation != 2) {
         var2 = (int)this.calculNbMoisPresence();
         var4 = this.calculRubriqueTotal("300200", var1) * -1.0D;
      }

      if (this.dateGeneration.getYear() + 1900 <= 2009) {
         if (var6 <= (double)(100000 / var3 * var2)) {
            this.valeur = 0.0D;
         } else if (var6 >= (double)(100001 / var3 * var2) && var6 <= (double)(125000 / var3 * var2)) {
            this.valeur = var6 * 0.05D - (double)(5000 / var3 * var2);
         } else if (var6 >= (double)(125001 / var3 * var2) && var6 <= (double)(160000 / var3 * var2)) {
            this.valeur = var6 * 0.1D - (double)(11250 / var3 * var2);
         } else if (var6 >= (double)(160001 / var3 * var2) && var6 <= (double)(225000 / var3 * var2)) {
            this.valeur = var6 * 0.15D - (double)(19250 / var3 * var2);
         } else if (var6 >= (double)(225001 / var3 * var2) && var6 <= (double)(300000 / var3 * var2)) {
            this.valeur = var6 * 0.2D - (double)(30500 / var3 * var2);
         } else if (var6 >= (double)(300001 / var3 * var2) && var6 <= (double)(430000 / var3 * var2)) {
            this.valeur = var6 * 0.25D - (double)('놼' / var3 * var2);
         } else if (var6 >= (double)(430001 / var3 * var2) && var6 <= (double)(625000 / var3 * var2)) {
            this.valeur = var6 * 0.3D - (double)(67000 / var3 * var2);
         } else if (var6 >= (double)(625001 / var3 * var2) && var6 <= (double)(916666 / var3 * var2)) {
            this.valeur = var6 * 0.35D - (double)(98250 / var3 * var2);
         } else if (var6 >= (double)(916667 / var3 * var2) && var6 <= (double)(1250000 / var3 * var2)) {
            this.valeur = var6 * 0.4D - (double)(144083 / var3 * var2);
         } else if (var6 >= (double)(1250001 / var3 * var2) && var6 <= (double)(1833333 / var3 * var2)) {
            this.valeur = var6 * 0.45D - (double)(206583 / var3 * var2);
         } else if (var6 >= (double)(1833334 / var3 * var2)) {
            this.valeur = var6 * 0.5D - (double)(298250 / var3 * var2);
         }
      } else if (var6 <= (double)(125000 / var3 * var2)) {
         this.valeur = 0.0D;
      } else if (var6 >= (double)(125001 / var3 * var2) && var6 <= (double)(160000 / var3 * var2)) {
         this.valeur = var6 * 0.05D - (double)(6250 / var3 * var2);
      } else if (var6 >= (double)(160001 / var3 * var2) && var6 <= (double)(225000 / var3 * var2)) {
         this.valeur = var6 * 0.1D - (double)(14250 / var3 * var2);
      } else if (var6 >= (double)(225001 / var3 * var2) && var6 <= (double)(300000 / var3 * var2)) {
         this.valeur = var6 * 0.15D - (double)(25500 / var3 * var2);
      } else if (var6 >= (double)(300001 / var3 * var2) && var6 <= (double)(430000 / var3 * var2)) {
         this.valeur = var6 * 0.2D - (double)('鸴' / var3 * var2);
      } else if (var6 >= (double)(430001 / var3 * var2) && var6 <= (double)(625000 / var3 * var2)) {
         this.valeur = var6 * 0.25D - (double)('\uf230' / var3 * var2);
      } else if (var6 >= (double)(625001 / var3 * var2) && var6 <= (double)(916666 / var3 * var2)) {
         this.valeur = var6 * 0.3D - (double)(93250 / var3 * var2);
      } else if (var6 >= (double)(916667 / var3 * var2)) {
         this.valeur = var6 * 0.35D - (double)(139083 / var3 * var2);
      }

      this.valeur = this.valeur * (double)this.salariesElements.getSaleleNbPartFiscal() - var4;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000028(Session var1) {
   }

   public void M000029(Session var1) {
   }

   public void M000030(Session var1) throws ParseException, HibernateException, NamingException {
      this.valeur = 0.0D;
      if (this.salaries.getSalDateNaissance() != null && this.salaries.getSalGenre() == 1 && this.dateGeneration.getMonth() + 1 <= 3 && this.dateGeneration.before(this.utilDate.stringToDateSQLLight("2009-12_31"))) {
         int var2 = this.dateGeneration.getYear() + 1900 - (this.salaries.getSalDateNaissance().getYear() + 1900);
         if (var2 < 50 && this.calculBrutEnCours(var1) >= 67500.0D) {
            double var3 = this.calculRubriqueTotal("300400", var1) * -1.0D;
            if (this.salaries.getSalCentresImpots().startsWith("2")) {
               this.valeur = 2000.0D - var3;
            } else {
               this.valeur = 3000.0D - var3;
            }
         }
      }

   }

   public void M000031(Session var1) throws ParseException, HibernateException, NamingException {
      this.valeur = 0.0D;
      if (this.salaries.getSalDateNaissance() != null && this.dateGeneration.getMonth() + 1 <= 3 && this.dateGeneration.before(this.utilDate.stringToDateSQLLight("2009-12_31"))) {
         int var2 = this.dateGeneration.getYear() + 1900 - (this.salaries.getSalDateNaissance().getYear() + 1900);
         if (var2 < 50 && this.calculBrutEnCours(var1) >= 150000.0D) {
            double var3 = this.calculRubriqueTotal("300500", var1) * -1.0D;
            this.valeur = 2000.0D - var3;
         }
      }

   }

   public void M000032(Session var1) throws HibernateException, NamingException, ParseException {
      this.valeur = this.calculBaseImposasableFiscaleEnCours(var1);
   }

   public void M000033(Session var1) throws HibernateException, NamingException {
      this.valeur = this.calculBaseImposasableSocialeEnCours(var1);
   }

   public void M000034(Session var1) throws HibernateException, NamingException {
      if (this.montantAtteindre == 0.0D) {
         new ArrayList();
         new ArrayList();
         List var3 = this.salariesPretsDao.chargerlesPretsInternesValide(this.salaries, 1, var1);
         if (var3.size() != 0) {
            for(int var4 = 0; var4 < var3.size(); ++var4) {
               this.salariesPrets = (SalariesPrets)var3.get(var4);
               List var2 = this.salariesPretsLignesDao.chargerlesPretsLignes(this.salariesPrets, var1);
               if (var2.size() != 0) {
                  double var5 = 0.0D;
                  double var7 = 0.0D;
                  int var9 = 0;
                  boolean var10 = true;
                  SalariesPretsLignes var11 = new SalariesPretsLignes();

                  int var12;
                  for(var12 = 0; var12 < var2.size(); ++var12) {
                     this.salariesPretsLignes = (SalariesPretsLignes)var2.get(var12);
                     if (this.salariesPretsLignes.getSalpreligMontantTheo() != 0.0D) {
                        if (this.salariesElements.getSaleleEtat() >= 2 && this.salariesElements.getSaleleModeSolde() == 0) {
                           if (this.salariesPretsLignes.getSalpreligMontantReel() == 0.0D || this.salariesPretsLignes.getSalpreligDateReel().equals(this.d1)) {
                              var5 += this.salariesPretsLignes.getSalpreligMontantTheo();
                              var7 += this.salariesPretsLignes.getSalpreligMontantReel();
                              var9 = 0;
                              var11 = this.salariesPretsLignes;
                              var10 = false;
                              break;
                           }
                        } else if (this.salariesPretsLignes.getSalpreligDateTheo().compareTo(this.d1) >= 0 && this.salariesPretsLignes.getSalpreligDateTheo().compareTo(this.d2) <= 0) {
                           var10 = false;
                           var5 += this.salariesPretsLignes.getSalpreligMontantTheo();
                           var7 += this.salariesPretsLignes.getSalpreligMontantReel();
                           if (this.salariesPretsLignes.getSalpreligMontantReel() == 0.0D) {
                              ++var9;
                           }

                           String var13 = this.formatPeriode(this.salariesPretsLignes.getSalpreligDateTheo());
                           if (this.bulletinMois.getBulmenPeriode().equals(var13)) {
                              var11 = this.salariesPretsLignes;
                              break;
                           }
                        } else {
                           this.totalPret += this.salariesPretsLignes.getSalpreligMontantTheo();
                           ++var9;
                        }
                     }
                  }

                  if (var11 != null && var5 != 0.0D) {
                     var11.setTotalPret(var5);
                     var11.setTotalRmb(var7);
                     var11.setNbReste(var9);
                     var11.setSalpreligNum(this.salariesPretsLignes.getSalariesPrets().getSalpreNum());
                     this.lesPretsLignes.add(var11);
                     this.valeur = var5;
                  }

                  if (this.optionPaye.getEcheanceprets().equals("1") && var10) {
                     for(var12 = 0; var12 < var2.size(); ++var12) {
                        this.salariesPretsLignes = (SalariesPretsLignes)var2.get(var12);
                        if (this.salariesPretsLignes.getSalpreligMontantTheo() != 0.0D && this.salariesPretsLignes.getSalpreligMontantReel() == 0.0D && this.salariesPretsLignes.getSalpreligDateTheo().compareTo(this.d1) < 0) {
                           var5 = this.salariesPretsLignes.getSalpreligMontantTheo();
                           var7 = 0.0D;
                           var9 = 0;
                           var11 = this.salariesPretsLignes;
                           break;
                        }
                     }

                     if (var11 != null && var5 != 0.0D) {
                        var11.setTotalPret(var5);
                        var11.setTotalRmb(var7);
                        var11.setNbReste(var9);
                        var11.setSalpreligNum(this.salariesPretsLignes.getSalariesPrets().getSalpreNum());
                        this.lesPretsLignes.add(var11);
                        this.valeur += var5;
                     }
                  }
               }
            }
         }
      }

   }

   public void M000035(Session var1) throws HibernateException, NamingException {
      if (this.montantAtteindre == 0.0D) {
         new ArrayList();
         new ArrayList();
         List var3 = this.salariesPretsDao.chargerlesPretsExternesValide(this.salaries, 1, var1);
         if (var3.size() != 0) {
            for(int var4 = 0; var4 < var3.size(); ++var4) {
               this.salariesPrets = (SalariesPrets)var3.get(var4);
               List var2 = this.salariesPretsLignesDao.chargerlesPretsLignes(this.salariesPrets, var1);
               if (var2.size() != 0) {
                  double var5 = 0.0D;
                  double var7 = 0.0D;
                  int var9 = 0;
                  boolean var10 = true;
                  SalariesPretsLignes var11 = new SalariesPretsLignes();

                  int var12;
                  for(var12 = 0; var12 < var2.size(); ++var12) {
                     this.salariesPretsLignes = (SalariesPretsLignes)var2.get(var12);
                     if (this.salariesPretsLignes.getSalpreligMontantTheo() != 0.0D) {
                        if (this.salariesElements.getSaleleEtat() >= 2 && this.salariesElements.getSaleleModeSolde() == 0) {
                           if (this.salariesPretsLignes.getSalpreligMontantReel() == 0.0D || this.salariesPretsLignes.getSalpreligDateReel().equals(this.d1)) {
                              var5 += this.salariesPretsLignes.getSalpreligMontantTheo();
                              var7 += this.salariesPretsLignes.getSalpreligMontantReel();
                              var9 = 0;
                              var11 = this.salariesPretsLignes;
                              var10 = false;
                           }
                        } else if ((this.d1.before(this.salariesPretsLignes.getSalpreligDateTheo()) || this.d1.equals(this.salariesPretsLignes.getSalpreligDateTheo())) && (this.d2.after(this.salariesPretsLignes.getSalpreligDateTheo()) || this.d2.equals(this.salariesPretsLignes.getSalpreligDateTheo()))) {
                           var10 = false;
                           var5 += this.salariesPretsLignes.getSalpreligMontantTheo();
                           var7 += this.salariesPretsLignes.getSalpreligMontantReel();
                           if (this.salariesPretsLignes.getSalpreligMontantReel() == 0.0D) {
                              ++var9;
                           }

                           String var13 = this.formatPeriode(this.salariesPretsLignes.getSalpreligDateTheo());
                           if (this.bulletinMois.getBulmenPeriode().equals(var13)) {
                              var11 = this.salariesPretsLignes;
                           }
                        } else {
                           this.totalPret += this.salariesPretsLignes.getSalpreligMontantTheo();
                           ++var9;
                        }
                     }
                  }

                  if (this.optionPaye.getEcheanceprets().equals("1") && var10) {
                     for(var12 = 0; var12 < var2.size(); ++var12) {
                        this.salariesPretsLignes = (SalariesPretsLignes)var2.get(var12);
                        if (this.salariesPretsLignes.getSalpreligMontantTheo() != 0.0D && this.salariesPretsLignes.getSalpreligMontantReel() == 0.0D && this.salariesPretsLignes.getSalpreligDateTheo().before(this.d1)) {
                           var5 = this.salariesPretsLignes.getSalpreligMontantTheo();
                           var7 = 0.0D;
                           var9 = 0;
                           var11 = this.salariesPretsLignes;
                           break;
                        }
                     }
                  }

                  if (var11 != null && var5 != 0.0D) {
                     var11.setTotalPret(var5);
                     var11.setTotalRmb(var7);
                     var11.setNbReste(var9);
                     var11.setSalpreligNum(this.salariesPretsLignes.getSalariesPrets().getSalpreNum());
                     this.lesPretsLignes.add(var11);
                     this.valeur = var5;
                  }
               }
            }
         }
      }

   }

   public void M000036(Session var1) throws NamingException, ParseException {
      if (this.montantAtteindre == 0.0D) {
         Date var2 = this.utilDate.dateMoisPrecedent(this.dateGeneration);
         String var3 = this.formatPeriode(var2);
         this.valeur = this.calculRubriquePeriode("609100", var3, var1);
         if (this.valeur == 0.0D && this.lesHistoriques.size() != 0) {
            for(int var4 = 0; var4 < this.lesHistoriques.size(); ++var4) {
               if (((SalariesHistorique)this.lesHistoriques.get(var4)).getSalhisCode().equals("ADM")) {
                  this.valeur = ((SalariesHistorique)this.lesHistoriques.get(var4)).getSalhisValeurColE();
               }
            }
         }
      } else {
         this.valeur = 0.0D;
      }

   }

   public void M000037(Session var1) {
      if (this.montantAtteindre == 0.0D) {
         boolean var2 = false;
         if (this.optionPaye.getArrondiNet().equals("0")) {
            if (this.salariesElements.getSaleleModeReglement() == 0) {
               var2 = true;
            }
         } else if (this.optionPaye.getArrondiNet().equals("1")) {
            if (this.salariesElements.getSaleleModeReglement() == 0 || this.salariesElements.getSaleleModeReglement() == 1) {
               var2 = true;
            }
         } else if (this.optionPaye.getArrondiNet().equals("2")) {
            if (this.salariesElements.getSaleleModeReglement() == 0 || this.salariesElements.getSaleleModeReglement() == 1 || this.salariesElements.getSaleleModeReglement() == 3 || this.salariesElements.getSaleleModeReglement() == 4 || this.salariesElements.getSaleleModeReglement() == 5) {
               var2 = true;
            }
         } else if (this.optionPaye.getArrondiNet().equals("3") && this.salariesElements.getSaleleModeReglement() >= 0 && this.salariesElements.getSaleleModeReglement() <= 5) {
            var2 = true;
         }

         if (var2) {
            double var3 = 0.0D;
            new BulletinLigne();

            for(int var6 = 0; var6 < this.lesBulletinsLigne.size(); ++var6) {
               BulletinLigne var5 = (BulletinLigne)this.lesBulletinsLigne.get(var6);
               if (var5.getBulligNature() == 69 || var5.getBulligNature() == 70 || var5.getBulligNature() == 80 || var5.getBulligNature() == 88) {
                  var3 += var5.getBulligValColE();
               }
            }

            if (var3 >= 0.0D) {
               var3 = this.utilNombre.myRoundDevise(var3, this.structureLog.getStrdevise());
               byte var14 = 100;
               double var7 = var3 / (double)var14;
               if (var7 != 0.0D) {
                  String var9 = "" + var7;
                  int var10 = Integer.parseInt(var9.substring(var9.indexOf(".") + 1));
                  if (var10 != 0) {
                     var9 = "" + (var7 + 1.0D);
                     String var11 = var9.substring(0, var9.indexOf("."));
                     double var12 = Double.parseDouble(var11);
                     this.valeur = this.utilNombre.myRoundDevise(var12 * (double)var14 - var3, this.structureLog.getStrdevise());
                  } else {
                     this.valeur = 0.0D;
                  }
               } else {
                  this.valeur = 0.0D;
               }
            } else {
               this.valeur = 0.0D;
            }
         } else {
            this.valeur = 0.0D;
         }
      } else {
         this.valeur = 0.0D;
      }

   }

   public void M000038(Session var1) {
      if (this.montantAtteindre == 0.0D) {
         boolean var2 = false;
         if (this.optionPaye.getArrondiNet().equals("0")) {
            if (this.salariesElements.getSaleleModeReglement() == 0) {
               var2 = true;
            }
         } else if (this.optionPaye.getArrondiNet().equals("1")) {
            if (this.salariesElements.getSaleleModeReglement() == 0 || this.salariesElements.getSaleleModeReglement() == 1) {
               var2 = true;
            }
         } else if (this.optionPaye.getArrondiNet().equals("2")) {
            if (this.salariesElements.getSaleleModeReglement() == 0 || this.salariesElements.getSaleleModeReglement() == 1 || this.salariesElements.getSaleleModeReglement() == 3 || this.salariesElements.getSaleleModeReglement() == 4 || this.salariesElements.getSaleleModeReglement() == 5) {
               var2 = true;
            }
         } else if (this.optionPaye.getArrondiNet().equals("3") && this.salariesElements.getSaleleModeReglement() >= 0 && this.salariesElements.getSaleleModeReglement() <= 5) {
            var2 = true;
         }

         if (var2) {
            double var3 = 0.0D;
            new BulletinLigne();

            for(int var6 = 0; var6 < this.lesBulletinsLigne.size(); ++var6) {
               BulletinLigne var5 = (BulletinLigne)this.lesBulletinsLigne.get(var6);
               if (var5.getBulligNature() == 69 || var5.getBulligNature() == 70 || var5.getBulligNature() == 80 || var5.getBulligNature() == 88) {
                  var3 += var5.getBulligValColE();
               }
            }

            if (var3 >= 0.0D) {
               var3 = this.utilNombre.myRoundDevise(var3, this.structureLog.getStrdevise());
               short var14 = 500;
               double var7 = var3 / (double)var14;
               if (var7 != 0.0D) {
                  String var9 = "" + var7;
                  int var10 = Integer.parseInt(var9.substring(var9.indexOf(".") + 1));
                  if (var10 != 0) {
                     var9 = "" + (var7 + 1.0D);
                     String var11 = var9.substring(0, var9.indexOf("."));
                     double var12 = Double.parseDouble(var11);
                     this.valeur = this.utilNombre.myRoundDevise(var12 * (double)var14 - var3, this.structureLog.getStrdevise());
                  } else {
                     this.valeur = 0.0D;
                  }
               } else {
                  this.valeur = 0.0D;
               }
            } else {
               this.valeur = 0.0D;
            }
         } else {
            this.valeur = 0.0D;
         }
      } else {
         this.valeur = 0.0D;
      }

   }

   public void M000039(Session var1) {
      if (this.montantAtteindre == 0.0D) {
         boolean var2 = false;
         if (this.optionPaye.getArrondiNet().equals("0")) {
            if (this.salariesElements.getSaleleModeReglement() == 0) {
               var2 = true;
            }
         } else if (this.optionPaye.getArrondiNet().equals("1")) {
            if (this.salariesElements.getSaleleModeReglement() == 0 || this.salariesElements.getSaleleModeReglement() == 1) {
               var2 = true;
            }
         } else if (this.optionPaye.getArrondiNet().equals("2")) {
            if (this.salariesElements.getSaleleModeReglement() == 0 || this.salariesElements.getSaleleModeReglement() == 1 || this.salariesElements.getSaleleModeReglement() == 3 || this.salariesElements.getSaleleModeReglement() == 4 || this.salariesElements.getSaleleModeReglement() == 5) {
               var2 = true;
            }
         } else if (this.optionPaye.getArrondiNet().equals("3") && this.salariesElements.getSaleleModeReglement() >= 0 && this.salariesElements.getSaleleModeReglement() <= 5) {
            var2 = true;
         }

         if (var2) {
            double var3 = 0.0D;
            new BulletinLigne();

            for(int var6 = 0; var6 < this.lesBulletinsLigne.size(); ++var6) {
               BulletinLigne var5 = (BulletinLigne)this.lesBulletinsLigne.get(var6);
               if (var5.getBulligNature() == 69 || var5.getBulligNature() == 70 || var5.getBulligNature() == 80 || var5.getBulligNature() == 88) {
                  var3 += var5.getBulligValColE();
               }
            }

            if (var3 >= 0.0D) {
               var3 = this.utilNombre.myRoundDevise(var3, this.structureLog.getStrdevise());
               short var14 = 1000;
               double var7 = var3 / (double)var14;
               if (var7 != 0.0D) {
                  String var9 = "" + var7;
                  int var10 = Integer.parseInt(var9.substring(var9.indexOf(".") + 1));
                  if (var10 != 0) {
                     var9 = "" + (var7 + 1.0D);
                     String var11 = var9.substring(0, var9.indexOf("."));
                     double var12 = Double.parseDouble(var11);
                     this.valeur = this.utilNombre.myRoundDevise(var12 * (double)var14 - var3, this.structureLog.getStrdevise());
                  } else {
                     this.valeur = 0.0D;
                  }
               } else {
                  this.valeur = 0.0D;
               }
            } else {
               this.valeur = 0.0D;
            }
         } else {
            this.valeur = 0.0D;
         }
      } else {
         this.valeur = 0.0D;
      }

   }

   public double M000040(Session var1) {
      this.nombreJourPresence = 0.0F;
      this.absenceSurConges = 0.0F;
      this.absenceSurReposMaladie = 0.0F;
      double var2 = 0.0D;
      double var4 = 0.0D;
      boolean var6 = false;
      boolean var7 = false;
      double var8 = 0.0D;
      boolean var10 = false;
      boolean var11 = false;
      new BulletinLigne();
      BulletinLigne var12;
      int var13;
      double var14;
      double var16;
      if (this.lesBulletinsLigne.size() != 0) {
         var11 = false;
         if (this.salariesElements.getSaleleNature() == null || this.salariesElements.getSaleleNature().isEmpty() || !this.salariesElements.getSaleleNature().equals("03D") && !this.salariesElements.getSaleleNature().equals("03I")) {
            for(var13 = 0; var13 < this.lesBulletinsLigne.size(); ++var13) {
               var12 = (BulletinLigne)this.lesBulletinsLigne.get(var13);
               if (var12.getBulligRubrique().equals("100000")) {
                  var2 = var12.getBulligValColD();
                  var6 = true;
                  break;
               }
            }
         } else {
            for(var13 = 0; var13 < this.lesBulletinsLigne.size(); ++var13) {
               var12 = (BulletinLigne)this.lesBulletinsLigne.get(var13);
               if (var12.getBulligRubrique().equals("100010")) {
                  var14 = var12.getBulligValColA() - var12.getBulligValColD();
                  var16 = this.utilNombre.myRound(var14 / 8.0D, 2);
                  var4 = (double)((float)((double)this.nbJourRef - var16));
                  var7 = true;
                  break;
               }
            }
         }
      } else {
         var11 = true;
      }

      if (var11) {
         if (!var6 && !var7) {
            for(var13 = 0; var13 < this.lesBulletinsLigne.size(); ++var13) {
               var12 = (BulletinLigne)this.lesBulletinsLigne.get(var13);
               if (var12.getBulligRubrique().equals("100000")) {
                  var2 = var12.getBulligValColD();
                  var6 = true;
                  break;
               }

               if (var12.getBulligRubrique().equals("100010")) {
                  var14 = var12.getBulligValColA() - var12.getBulligValColD();
                  var16 = this.utilNombre.myRound(var14 / 8.0D, 2);
                  var4 = (double)((float)((double)this.nbJourRef - var16));
                  var7 = true;
                  break;
               }
            }
         }

         new SalariesVariables();
         if (var6) {
            int var18;
            for(var18 = 0; var18 < this.lesBulletinsLigne.size(); ++var18) {
               var12 = (BulletinLigne)this.lesBulletinsLigne.get(var18);
               if (var12.getBulligRubrique().equals("100050")) {
                  var8 = var12.getBulligValColD();
                  var10 = true;
                  break;
               }
            }

            if (!var10) {
               new SalariesVariables();

               for(var18 = 0; var18 < this.lesVariables.size(); ++var18) {
                  SalariesVariables var19 = (SalariesVariables)this.lesVariables.get(var18);
                  if (var19.getSalvarCode().equals("100050")) {
                     var8 = var19.getSalvarValeurColD();
                     var10 = true;
                     break;
                  }
               }
            }

            this.valeur = var2 - var8;
         } else if (var7) {
            this.valeur = var4;
         } else if (this.salariesElements.getSaleleNature() == null || this.salariesElements.getSaleleNature().isEmpty() || !this.salariesElements.getSaleleNature().equals("03D") && !this.salariesElements.getSaleleNature().equals("03I")) {
            this.valeur = (double)this.nbJourRef;
            var6 = true;
         } else {
            this.valeur = this.M000158();
            var7 = true;
         }

         if (var6 || var7) {
            int var15;
            SalariesConges var21;
            if (this.lesAbsences.size() != 0) {
               new SalariesConges();

               for(var15 = 0; var15 < this.lesAbsences.size(); ++var15) {
                  var21 = (SalariesConges)this.lesAbsences.get(var15);
                  if (var21.getSalcngType() == 1) {
                     if (var21.getSalcngNature() == 12) {
                        var8 += (double)(var21.getSalcngDuree() - var21.getSalcngNbJoursExclus());
                     } else if (var21.getSalcngNature() == 13) {
                        this.absenceSurConges += var21.getSalcngDuree() - var21.getSalcngNbJoursExclus();
                     } else if (var21.getSalcngNature() == 16) {
                        this.absenceSurReposMaladie += var21.getSalcngDuree() - var21.getSalcngNbJoursExclus();
                     } else if (var21.getSalcngNature() == 17) {
                     }
                  }
               }

               if (var8 != 0.0D) {
                  new BulletinLigne();

                  for(int var22 = 0; var22 < this.lesBulletinsLigne.size(); ++var22) {
                     BulletinLigne var20 = (BulletinLigne)this.lesBulletinsLigne.get(var22);
                     if (var20.getBulligRubrique().equals("100000")) {
                        var20.setBulligObservation(var8 + " jour(s) d'absence non payée(s)");
                        break;
                     }
                  }
               }
            }

            if (this.lesConges.size() != 0) {
               new SalariesConges();

               for(var15 = 0; var15 < this.lesConges.size(); ++var15) {
                  var21 = (SalariesConges)this.lesConges.get(var15);
                  if (var21.getSalcngType() == 0 && (var21.getSalcngNature() == 1 || var21.getSalcngNature() == 2 || var21.getSalcngNature() == 4 || var21.getSalcngNature() == 5 || var21.getSalcngNature() == 6 || var21.getSalcngNature() == 7)) {
                     if (var21.getSalcngDateDebut() != null && var21.getSalcngDateDebut().after(this.d1) && var21.getSalcngDateFin().before(this.d2)) {
                        var8 += (double)var21.getSalcngDuree();
                     } else if (var21.getSalcngDateDebut() != null && var21.getSalcngDateDebut().after(this.d1) && var21.getSalcngDateDebut().before(this.d2)) {
                        var8 += (double)((this.d2.getTime() - var21.getSalcngDateDebut().getTime()) / 86400000L);
                     } else if (var21.getSalcngDateFin() != null && var21.getSalcngDateFin().after(this.d1) && var21.getSalcngDateFin().before(this.d2)) {
                        var8 += (double)((var21.getSalcngDateFin().getTime() - this.d1.getTime()) / 86400000L);
                     }
                  }
               }
            }

            if (this.salariesContrats.getSalconDateDebut() != null && this.salariesContrats.getSalconDateDebut().getYear() == this.dateGeneration.getYear() && this.salariesContrats.getSalconDateDebut().getMonth() == this.dateGeneration.getMonth()) {
               var8 += (double)((this.salariesContrats.getSalconDateDebut().getTime() - this.dateGeneration.getTime()) / 86400000L);
            }

            if (this.salariesElements.getSaleleEtat() >= 2 && this.salariesElements.getSaleleEtat() <= 7 && this.salariesElements.getSaleleDateSortie() != null && this.salariesElements.getSaleleDateSortie().getMonth() == this.dateGeneration.getMonth() && this.salariesElements.getSaleleDateSortie().getYear() == this.dateGeneration.getYear()) {
               var8 += (double)(this.nbJourRef - this.salariesElements.getSaleleDateSortie().getDate());
               if (this.salariesElements.getSaleleDateSortie().getDate() == 1) {
                  ++var8;
               }
            }

            this.valeur -= var8;
            if (this.montantAtteindre != 0.0D) {
               this.valeur = (double)this.nbJourRef;
            }
         }
      } else if (var7) {
         this.valeur = var4;
      } else {
         this.valeur = var2;
      }

      this.nombreJourPresence = (float)this.valeur;
      return this.valeur;
   }

   public void M000041(Session var1) throws HibernateException, NamingException {
      this.valeur = this.calculBaseImposasableAutreEnCours(var1);
   }

   public void M000042(Session var1) throws HibernateException, NamingException {
      this.valeur = this.calculBaseImposasableFiscaleTotal(var1);
   }

   public void M000043(Session var1) throws HibernateException, NamingException {
      this.valeur = this.calculBaseImposasableSocialeTotal(var1);
   }

   public void M000044(Session var1) throws HibernateException, NamingException {
      this.valeur = this.calculBaseImposasableAutreTotal(var1);
   }

   public void M000045(Session var1) throws HibernateException, NamingException {
      this.valeur = this.calculBaseImposasablePatronaleEnCours(var1);
   }

   public void M000046(Session var1) throws HibernateException, NamingException {
      this.valeur = this.calculBaseImposasablePatronaleTotal(var1);
   }

   public void M000047() throws NamingException, ParseException {
      double var1 = this.optionPaye.getSecuriteSocialeGene();
      boolean var3 = false;
      if (this.lesConges.size() != 0 && this.modePlafond.equals("1")) {
         Date var4 = this.utilDate.dateMoisSuivant(this.dateGeneration);
         Date var5 = this.utilDate.datePremierJourMois(var4);
         Date var6 = this.utilDate.dateDernierJourMois(var5);
         new SalariesConges();

         for(int var8 = 0; var8 < this.lesConges.size(); ++var8) {
            SalariesConges var7 = (SalariesConges)this.lesConges.get(var8);
            if (var7.getSalcngDateDebut().equals(var5) && var7.getSalcngDateFin().equals(var6)) {
               var3 = true;
            }
         }
      }

      if (var3) {
         var1 *= 2.0D;
      }

      double var9 = this.calculBrutEnCours((Session)null);
      if (var9 > var1) {
         this.valeur = var1;
      } else {
         this.valeur = var9;
      }

   }

   public void M000048() throws NamingException, ParseException {
      double var1 = this.optionPaye.getSecuriteSocialeCadre();
      boolean var3 = false;
      if (this.lesConges.size() != 0 && this.modePlafond.equals("1")) {
         Date var4 = this.utilDate.dateMoisSuivant(this.dateGeneration);
         Date var5 = this.utilDate.datePremierJourMois(var4);
         Date var6 = this.utilDate.dateDernierJourMois(var5);
         new SalariesConges();

         for(int var8 = 0; var8 < this.lesConges.size(); ++var8) {
            SalariesConges var7 = (SalariesConges)this.lesConges.get(var8);
            if (var7.getSalcngDateDebut().equals(var5) && var7.getSalcngDateFin().equals(var6)) {
               var3 = true;
            }
         }
      }

      if (var3) {
         var1 *= 2.0D;
      }

      double var9 = this.calculBrutEnCours((Session)null);
      if (var9 > var1) {
         this.valeur = var1;
      } else {
         this.valeur = var9;
      }

   }

   public void M000049() throws NamingException, ParseException {
      double var1 = this.optionPaye.getCotisationSocialeGene();
      boolean var3 = false;
      if (this.lesConges.size() != 0 && this.modePlafond.equals("1")) {
         Date var4 = this.utilDate.dateMoisSuivant(this.dateGeneration);
         Date var5 = this.utilDate.datePremierJourMois(var4);
         Date var6 = this.utilDate.dateDernierJourMois(var5);
         new SalariesConges();

         for(int var8 = 0; var8 < this.lesConges.size(); ++var8) {
            SalariesConges var7 = (SalariesConges)this.lesConges.get(var8);
            if (var7.getSalcngDateDebut().equals(var5) && var7.getSalcngDateFin().equals(var6)) {
               var3 = true;
            }
         }
      }

      if (var3) {
         var1 *= 2.0D;
      }

      double var9 = this.calculBrutEnCours((Session)null);
      if (var9 > var1) {
         this.valeur = var1;
      } else {
         this.valeur = var9;
      }

   }

   public void M000050() throws NamingException, ParseException {
      double var1 = this.optionPaye.getPrestationMedicaleGene();
      boolean var3 = false;
      if (this.lesConges.size() != 0 && this.modePlafond.equals("1")) {
         Date var4 = this.utilDate.dateMoisSuivant(this.dateGeneration);
         Date var5 = this.utilDate.datePremierJourMois(var4);
         Date var6 = this.utilDate.dateDernierJourMois(var5);
         new SalariesConges();

         for(int var8 = 0; var8 < this.lesConges.size(); ++var8) {
            SalariesConges var7 = (SalariesConges)this.lesConges.get(var8);
            if (var7.getSalcngDateDebut().equals(var5) && var7.getSalcngDateFin().equals(var6)) {
               var3 = true;
            }
         }
      }

      if (var3) {
         var1 *= 2.0D;
      }

      double var9 = this.calculBrutEnCours((Session)null);
      if (var9 > var1) {
         this.valeur = var1;
      } else {
         this.valeur = var9;
      }

   }

   public void M000051() {
      this.valeur = this.optionPaye.getSmig();
   }

   public void M000052() {
      this.valeur = this.salariesContrats.getSalconSursalaire();
      if (this.type_conges == 2) {
         this.valeur = 0.0D;
      }

   }

   public void M000053() {
      this.valeur = this.salariesContrats.getSalconPrimeRendement();
      if (this.type_conges == 2) {
         this.valeur = 0.0D;
      }

   }

   public void M000054() {
      this.valeur = this.salariesContrats.getSalconPrimeResponsabilite();
      if (this.type_conges == 2) {
         this.valeur = 0.0D;
      }

   }

   public void M000055() {
      this.valeur = this.salariesContrats.getSalconPrimeFonction();
   }

   public void M000056() {
      this.valeur = this.salariesContrats.getSalconIndemniteCaisse();
      if (this.type_conges == 2) {
         this.valeur = 0.0D;
      }

   }

   public void M000057() {
      this.valeur = this.salariesContrats.getSalconIndemniteTransport();
      if (this.type_conges == 2) {
         this.valeur = 0.0D;
      }

   }

   public void M000058() {
      this.valeur = this.salariesContrats.getSalconIndemniteLogement();
   }

   public void M000059() {
      this.valeur = this.salariesContrats.getSalconIndemniteDeplacement();
      if (this.type_conges == 2) {
         this.valeur = 0.0D;
      }

   }

   public void M000060() {
      this.valeur = this.salariesContrats.getSalconIndemniteKilometrique();
      if (this.type_conges == 2) {
         this.valeur = 0.0D;
      }

   }

   public void M000061() {
      this.valeur = this.salariesContrats.getSalconIndemniteSalissure();
      if (this.type_conges == 2) {
         this.valeur = 0.0D;
      }

   }

   public void M000062() {
      this.valeur = this.salariesContrats.getSalconAvnLogement();
      if (this.type_conges == 2) {
         this.valeur = 0.0D;
      }

   }

   public void M000063() {
      this.valeur = this.salariesContrats.getSalconAvnDomesticite();
      if (this.type_conges == 2) {
         this.valeur = 0.0D;
      }

   }

   public void M000064() {
      this.valeur = this.salariesContrats.getSalconAvnTelephone();
      if (this.type_conges == 2) {
         this.valeur = 0.0D;
      }

   }

   public void M000065() {
      this.valeur = this.salariesContrats.getSalconAvnEau();
      if (this.type_conges == 2) {
         this.valeur = 0.0D;
      }

   }

   public void M000066() {
      this.valeur = this.salariesContrats.getSalconAvnElectricite();
      if (this.type_conges == 2) {
         this.valeur = 0.0D;
      }

   }

   public void M000067() {
      this.valeur = this.salariesContrats.getSalconAvnNourriture();
      if (this.type_conges == 2) {
         this.valeur = 0.0D;
      }

   }

   public void M000068() {
      this.valeur = this.salariesContrats.getSalconAvnVehicule();
      if (this.type_conges == 2) {
         this.valeur = 0.0D;
      }

   }

   public double M000069(Session var1) throws ParseException {
      double var2 = 0.0D;
      boolean var4 = false;
      double var5 = 0.0D;
      double var7 = 0.0D;
      if (this.lesBulletinsLigne.size() != 0) {
         for(int var9 = 0; var9 < this.lesBulletinsLigne.size(); ++var9) {
            if (((BulletinLigne)this.lesBulletinsLigne.get(var9)).getBulligRubrique().equals("208000")) {
               if (((BulletinLigne)this.lesBulletinsLigne.get(var9)).getBulligValColE() != 0.0D) {
                  var5 = ((BulletinLigne)this.lesBulletinsLigne.get(var9)).getBulligValColB();
                  var7 = ((BulletinLigne)this.lesBulletinsLigne.get(var9)).getBulligValColE();
                  var4 = true;
               }
               break;
            }
         }
      } else {
         var4 = true;
         var7 = 1.0D;
      }

      double var14 = 0.0D;
      if (var4 && var7 != 0.0D) {
         this.valeur = 0.0D;
         this.M000003(var1);
         double var11 = this.valeur;
         this.valeur = 0.0D;
         if (!this.structureLog.getStrcodepays().equals("0029")) {
            if (this.structureLog.getStrcodepays().equals("0041")) {
               if (var11 >= 5.0D && var11 <= 9.0D) {
                  var2 = 3.0D;
               } else if (var11 >= 10.0D && var11 <= 14.0D) {
                  var2 = 6.0D;
               } else if (var11 >= 15.0D && var11 <= 18.0D) {
                  var2 = 9.0D;
               } else if (var11 >= 19.0D && var11 <= 22.0D) {
                  var2 = 12.0D;
               } else if (var11 >= 23.0D && var11 <= 26.0D) {
                  var2 = 15.0D;
               } else if (var11 >= 27.0D && var11 <= 30.0D) {
                  var2 = 18.0D;
               } else if (var11 >= 31.0D && var11 <= 34.0D) {
                  var2 = 21.0D;
               } else if (var11 >= 35.0D && var11 <= 38.0D) {
                  var2 = 24.0D;
               } else if (var11 >= 39.0D && var11 <= 42.0D) {
                  var2 = 27.0D;
               } else if (var11 >= 43.0D) {
                  var2 = 30.0D;
               }
            } else if (this.structureLog.getStrcodepays().equals("0050")) {
               if (var11 >= 3.0D && var11 <= 5.0D) {
                  var2 = 3.0D;
               } else if (var11 >= 6.0D && var11 <= 10.0D) {
                  var2 = 5.0D;
               } else if (var11 >= 11.0D && var11 <= 15.0D) {
                  var2 = 6.0D;
               } else if (var11 >= 16.0D && var11 <= 20.0D) {
                  var2 = 8.0D;
               } else if (var11 >= 21.0D && var11 <= 25.0D) {
                  var2 = 9.0D;
               } else if (var11 >= 26.0D && var11 <= 30.0D) {
                  var2 = 10.0D;
               } else if (var11 >= 31.0D) {
                  var2 = 15.0D;
               }
            } else if (this.structureLog.getStrcodepays().equals("0056")) {
               if (var11 >= 5.0D && var11 <= 9.0D) {
                  var2 = 1.0D;
               } else if (var11 >= 10.0D && var11 <= 14.0D) {
                  var2 = 2.0D;
               } else if (var11 >= 15.0D && var11 <= 19.0D) {
                  var2 = 3.0D;
               } else if (var11 >= 20.0D && var11 <= 24.0D) {
                  var2 = 5.0D;
               } else if (var11 >= 25.0D) {
                  var2 = 7.0D;
               }
            } else if (this.structureLog.getStrcodepays().equals("0077")) {
               if (var11 >= 5.0D) {
                  var2 = var11 - 3.0D;
               }
            } else if (!this.structureLog.getStrcodepays().equals("0078") && !this.structureLog.getStrcodepays().equals("0088") && !this.structureLog.getStrcodepays().equals("0089") && !this.structureLog.getStrcodepays().equals("0090")) {
               if (this.structureLog.getStrcodepays().equals("0138")) {
                  if (var11 >= 10.0D && var11 <= 19.0D) {
                     var2 = 3.0D;
                  } else if (var11 >= 20.0D && var11 <= 24.0D) {
                     var2 = 5.0D;
                  } else if (var11 >= 25.0D) {
                     var2 = 7.0D;
                  }
               } else if (!this.structureLog.getStrcodepays().equals("0142")) {
                  if (this.structureLog.getStrcodepays().equals("0202")) {
                     if (this.salariesContrats.getSalconConvention().equals("ASSURANCES")) {
                        if (var11 >= 11.0D && var11 <= 15.0D) {
                           var2 = 1.0D;
                        } else if (var11 >= 16.0D && var11 <= 20.0D) {
                           var2 = 2.0D;
                        } else if (var11 >= 21.0D && var11 <= 25.0D) {
                           var2 = 3.0D;
                        } else if (var11 >= 26.0D) {
                           var2 = 6.0D;
                        }
                     } else if (var11 >= 11.0D && var11 <= 15.0D) {
                        var2 = 1.0D;
                     } else if (var11 >= 16.0D && var11 <= 20.0D) {
                        var2 = 2.0D;
                     } else if (var11 >= 21.0D && var11 <= 25.0D) {
                        var2 = 3.0D;
                     } else if (var11 >= 26.0D) {
                        var2 = 6.0D;
                     }
                  } else if (!this.structureLog.getStrcodepays().equals("0222") && var11 >= 5.0D) {
                     var2 = var11 - 3.0D;
                  }
               }
            }
         }

         boolean var13 = true;
         int var15;
         if (this.structureLog.getStrcodepays().equals("0077")) {
            var15 = 24;
         } else {
            var15 = (int)this.salariesElements.getSaleleNbJourTr();
         }

         if (var15 != 0) {
            var14 = var7 / (double)var15 * var2;
         }

         var14 = this.calculARR(var14);
      }

      this.valeur = var14;
      return var2;
   }

   public int M000070(Session var1) throws HibernateException, NamingException {
      int var2 = 0;
      if (this.salariesElements.getSaleleGenre() == 0) {
         boolean var3 = false;
         double var4 = 0.0D;
         double var6 = 0.0D;
         if (this.lesBulletinsLigne.size() != 0) {
            for(int var8 = 0; var8 < this.lesBulletinsLigne.size(); ++var8) {
               if (((BulletinLigne)this.lesBulletinsLigne.get(var8)).getBulligRubrique().equals("208000")) {
                  if (((BulletinLigne)this.lesBulletinsLigne.get(var8)).getBulligValColE() != 0.0D) {
                     var4 = ((BulletinLigne)this.lesBulletinsLigne.get(var8)).getBulligValColB();
                     var6 = ((BulletinLigne)this.lesBulletinsLigne.get(var8)).getBulligValColE();
                     var3 = true;
                  }
                  break;
               }
            }
         } else {
            var3 = true;
            var6 = 1.0D;
         }

         double var12 = 0.0D;
         if (var3 && var6 != 0.0D) {
            this.lesSalariesGrh = this.salariesGrhDao.chargerlesElementRh(this.salaries, var1);
            if (this.lesSalariesGrh.size() != 0) {
               for(int var10 = 0; var10 < this.lesSalariesGrh.size(); ++var10) {
                  if (((SalariesGrh)this.lesSalariesGrh.get(var10)).getSalgrhType() == 15) {
                     int var11 = this.calculAge(((SalariesGrh)this.lesSalariesGrh.get(var10)).getSalgrhDate());
                     if (this.structureLog.getStrcodepays().equals("0029")) {
                        if (var11 <= 18) {
                           ++var2;
                        }
                     } else if (this.structureLog.getStrcodepays().equals("0041")) {
                        if (var11 <= 18) {
                           ++var2;
                        }
                     } else if (this.structureLog.getStrcodepays().equals("0050")) {
                        if (var11 <= 18) {
                           ++var2;
                        }
                     } else if (this.structureLog.getStrcodepays().equals("0056")) {
                        if (var11 <= 18) {
                           ++var2;
                        }
                     } else if (this.structureLog.getStrcodepays().equals("0077")) {
                        if (var11 <= 16) {
                           ++var2;
                        }
                     } else if (this.structureLog.getStrcodepays().equals("0078")) {
                        if (var11 <= 18) {
                           ++var2;
                        }
                     } else if (this.structureLog.getStrcodepays().equals("0088")) {
                        if (var11 <= 18) {
                           ++var2;
                        }
                     } else if (this.structureLog.getStrcodepays().equals("0089")) {
                        var2 = 0;
                     } else if (this.structureLog.getStrcodepays().equals("0090")) {
                        if (var11 <= 18) {
                           ++var2;
                        }
                     } else if (this.structureLog.getStrcodepays().equals("0138")) {
                        if (var11 <= 18) {
                           ++var2;
                        }
                     } else if (this.structureLog.getStrcodepays().equals("0142")) {
                        if (var11 <= 18) {
                           ++var2;
                        }
                     } else if (this.structureLog.getStrcodepays().equals("0202")) {
                        if (var11 <= 14) {
                           ++var2;
                        }
                     } else if (this.structureLog.getStrcodepays().equals("0222")) {
                        if (var11 <= 18) {
                           ++var2;
                        }
                     } else if (var11 <= 18) {
                        ++var2;
                     }
                  }
               }
            }

            var12 = var6 / 24.0D * (double)var2;
            var12 = this.calculARR(var12);
         }

         this.valeur = var12;
      } else {
         this.valeur = 0.0D;
      }

      return var2;
   }

   public void M000071(Session var1) {
      boolean var2 = false;
      double var3 = 0.0D;
      double var5 = 0.0D;

      for(int var7 = 0; var7 < this.lesBulletinsLigne.size(); ++var7) {
         if (((BulletinLigne)this.lesBulletinsLigne.get(var7)).getBulligRubrique().equals("208000")) {
            if (((BulletinLigne)this.lesBulletinsLigne.get(var7)).getBulligValColE() != 0.0D) {
               var3 = ((BulletinLigne)this.lesBulletinsLigne.get(var7)).getBulligValColB();
               var5 = ((BulletinLigne)this.lesBulletinsLigne.get(var7)).getBulligValColE();
               var2 = true;
            }
            break;
         }
      }

   }

   public void M000072(Session var1) {
      boolean var2 = false;
      double var3 = 0.0D;
      double var5 = 0.0D;

      for(int var7 = 0; var7 < this.lesBulletinsLigne.size(); ++var7) {
         if (((BulletinLigne)this.lesBulletinsLigne.get(var7)).getBulligRubrique().equals("208000")) {
            if (((BulletinLigne)this.lesBulletinsLigne.get(var7)).getBulligValColE() != 0.0D) {
               var3 = ((BulletinLigne)this.lesBulletinsLigne.get(var7)).getBulligValColB();
               var5 = ((BulletinLigne)this.lesBulletinsLigne.get(var7)).getBulligValColE();
               var2 = true;
            }
            break;
         }
      }

      if (this.salariesElements.getSaleleNivEmploi() != null && !this.salariesElements.getSaleleNivEmploi().isEmpty() && this.salariesElements.getSaleleNivEmploi().equals("1")) {
         this.valeur = var5 / 22.0D;
      } else {
         this.valeur = var5 / 24.0D;
      }

   }

   public void M000073() {
      this.valeur = (double)this.salariesElements.getSaleleNbEnfant();
   }

   public void M000074() {
      this.valeur = (double)this.salariesElements.getSaleleNbFemme();
   }

   public void M000075() {
      this.valeur = (double)this.salariesElements.getSaleleNbPartFiscal();
   }

   public void M000076() {
      this.valeur = (double)this.salariesElements.getSaleleNbPartTrimf();
   }

   public void M000077(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
         var2 = this.calculBrutEnCours(var1);
         var4 = this.calculAvnEnCours(var1);
      } else if (this.modeRegularisation == 2) {
         var2 = this.calculBrutEnCours(var1);
         var4 = this.calculAvnEnCours(var1);
      } else {
         var2 = this.calculBrutTotal(var1);
         var4 = this.calculAvnTotal(var1);
         var6 = this.calculRubriqueTotal("900100", var1) * -1.0D;
      }

      this.valeur = (var2 + var4) * this.bulletinLigne.getBulligValColC() / 100.0D;
      this.valeur -= var6;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000078(Session var1) throws HibernateException, NamingException {
      this.valeur = this.calculBaseHeureSupEnCours(var1);
   }

   public void M000079(Session var1) throws HibernateException, NamingException {
      if (this.salaries.getSalNumAmo() != null && !this.salaries.getSalNumAmo().isEmpty()) {
         double var2 = 0.0D;
         if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
            var2 = this.bulletinLigne.getBulligValColB();
         } else if (this.modeRegularisation == 2) {
            var2 = this.bulletinLigne.getBulligValColB();
         } else {
            var2 = this.calculBaseImposasableSocialeTotal(var1);
         }

         this.valeur = var2 * this.bulletinLigne.getBulligValColC() / 100.0D;
         this.valeur = this.calculARR(this.valeur);
      } else {
         this.valeur = 0.0D;
      }

   }

   public void M000080(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
         var2 = this.bulletinLigne.getBulligValColB();
      } else if (this.modeRegularisation == 2) {
         var2 = this.bulletinLigne.getBulligValColB();
      } else {
         var2 = this.calculBaseImposasableSocialeTotal(var1);
      }

      this.valeur = var2 * this.bulletinLigne.getBulligValColC() / 100.0D;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000081() {
      this.valeur = (double)this.salariesElements.getSaleleNbEnfant();
      double var1 = this.optionPaye.getNbEnfantAllocation();
      if (this.valeur > var1) {
         this.valeur = var1;
      }

   }

   public void M000082() {
      this.valeur = this.salariesContrats.getSalconPrimeSujetion();
   }

   public void M000083() {
      this.valeur = this.salariesContrats.getSalconIndemniteRepresentation();
   }

   public void M000084() {
      this.valeur = this.salariesContrats.getSalconBase();
      if (this.type_conges == 2) {
         this.valeur = 0.0D;
      }

   }

   public void M000085(Session var1) {
      if (this.montantAtteindre == 0.0D) {
         this.valeur = 0.0D;
         double var2 = 0.0D;
         new BulletinLigne();

         for(int var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
            BulletinLigne var4 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
            if (var4.getBulligNature() == 69 || var4.getBulligNature() == 70 || var4.getBulligNature() == 80 || var4.getBulligNature() == 88) {
               var2 += var4.getBulligValColE();
            }
         }

         double var16 = 0.0D;
         this.M000040(var1);
         var16 = this.valeur;
         this.valeur = 0.0D;
         double var7 = this.bulletinLigne.getBulligValColA();
         if (var7 != 0.0D) {
            double var9 = var7 - var2;
            this.valeur = this.utilNombre.myRoundDevise(var9 / (double)this.nbJourRef * var16, this.structureLog.getStrdevise());
         } else if (var2 != 0.0D) {
            short var17 = 500;
            double var10 = var2 / (double)var17;
            if (var10 != 0.0D) {
               String var12 = "" + var10;
               String var13 = var12.substring(0, var12.indexOf("."));
               double var14 = Double.parseDouble(var13) + 1.0D;
               this.valeur = var14 * (double)var17 - var2;
            }
         } else {
            this.valeur = 0.0D;
         }
      } else {
         this.valeur = 0.0D;
      }

   }

   public void M000086() {
      if (this.salaries.getSalCodeNaissance() != null && !this.salaries.getSalCodeNaissance().isEmpty()) {
         if (this.salaries.getSalCodeNaissance().equals(this.structureLog.getStrcodepays())) {
            this.valeur = this.memoValeur;
         } else {
            this.valeur = 0.0D;
         }
      }

   }

   public void M000087() {
      if (this.salaries.getSalCodeNaissance() != null && !this.salaries.getSalCodeNaissance().isEmpty()) {
         if (this.salaries.getSalCodeNaissance().equals(this.structureLog.getStrcodepays())) {
            this.valeur = 0.0D;
         } else {
            this.valeur = this.memoValeur;
         }
      }

   }

   public void M000088() {
      this.valeur = this.salariesContrats.getSalconForfaitSup();
      if (this.type_conges == 2) {
         this.valeur = 0.0D;
      }

   }

   public void M000089() {
      this.valeur = this.salariesContrats.getSalconPrimeOutillage();
   }

   public void M000090(Session var1) {
      if (this.salariesContrats != null && this.salariesContrats.getSalconDateDebut() != null) {
         long var2 = (this.dateGeneration.getTime() - this.salariesContrats.getSalconDateDebut().getTime()) / 86400000L / 30L;
         this.valeur = (double)this.utilNombre.myRound((float)var2, 2);
      } else {
         this.valeur = 0.0D;
      }

   }

   public void M000091(Session var1) throws HibernateException, NamingException {
      if (this.salariesCapitalisation != null) {
         if (this.salariesElements.getSaleleEtat() >= 2) {
            this.M000092(var1);
         } else {
            this.valeur = this.salariesCapitalisation.getSalcapMontant();
         }
      } else {
         this.valeur = 0.0D;
      }

   }

   public void M000092(Session var1) throws HibernateException, NamingException {
      if (this.salariesCapitalisation != null) {
         new ArrayList();
         List var2 = this.salariesCapitalisationDao.chargerlesMvts(this.salaries, this.salariesCapitalisation, var1);
         double var3 = 0.0D;
         double var5 = 0.0D;
         if (var2.size() != 0) {
            for(int var7 = 0; var7 < var2.size(); ++var7) {
               if (((BulletinLigne)var2.get(var7)).getBulletinSalaire().getBulsalDateDebut().compareTo(this.dateGeneration) <= 0) {
                  var3 += ((BulletinLigne)var2.get(var7)).getDepense();
                  var5 += ((BulletinLigne)var2.get(var7)).getRecette();
               }
            }
         }

         this.valeur = this.salariesCapitalisation.getSalcapInitial() + var3 - var5;
      } else {
         this.valeur = 0.0D;
      }

   }

   public void M000093() {
      this.valeur = this.salariesContrats.getSalconPrimeAstreinte();
      if (this.type_conges == 2) {
         this.valeur = 0.0D;
      }

   }

   public void M000094(Session var1) throws HibernateException, NamingException {
      if (this.salariesContrats.getSalconEtat() != 6 || !this.salariesContrats.getSalconType().equals("05") && !this.salariesContrats.getSalconType().equals("11")) {
         this.valeur = 0.0D;
      } else {
         double var2 = this.calculBrutTotal(var1);
         double var4 = 0.0D;
         if (this.lesBulletinsLigne.size() != 0) {
            for(int var6 = 0; var6 < this.lesBulletinsLigne.size(); ++var6) {
               if (((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligNature() <= 49) {
                  var4 += ((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligValColE();
               }
            }
         }

         this.valeur = var2 + var4;
      }

   }

   public void M000095() {
      if (this.salariesContrats.getSalconEtat() == 6 && (this.salariesContrats.getSalconType().equals("05") || this.salariesContrats.getSalconType().equals("11"))) {
         if (this.bulletinLigne.getBulligValColC() != 0.0D) {
            double var1 = this.bulletinLigne.getBulligValColB() * this.bulletinLigne.getBulligValColC() / 100.0D;
            this.valeur = this.utilNombre.myRoundDevise(var1, this.structureLog.getStrdevise());
         } else {
            this.valeur = 0.0D;
         }
      } else {
         this.valeur = 0.0D;
      }

   }

   public double M000096(Session var1) throws HibernateException, NamingException, ParseException {
      new BulletinLigne();
      BulletinLigne var2 = this.bulletinLigne;
      new FeuilleCalculRubrique();
      FeuilleCalculRubrique var3 = this.calculRubrique;
      String var4 = this.bulletinLigne.getBulligRubrique();
      if (var4 == null || var4.isEmpty()) {
         var4 = "100000";
      }

      double var5 = 0.0D;
      if (this.gestionBasesReference && this.lesBasesReferences.size() != 0) {
         label88:
         for(int var7 = 0; var7 < this.lesBasesReferences.size(); ++var7) {
            this.objetBaseReference = (ObjetBaseReference)this.lesBasesReferences.get(var7);
            this.objetBaseReference.setValeurBaseReference(0.0D);
            if (this.objetBaseReference.getCalculReference() != null && !this.objetBaseReference.getCalculReference().isEmpty() && this.objetBaseReference.getCodeRubrique().equals(var4)) {
               String[] var8;
               String var11;
               if (this.objetBaseReference.getCalculReference().contains("#")) {
                  var8 = this.objetBaseReference.getCalculReference().split("#");
                  int var9 = 0;

                  while(true) {
                     if (var9 >= var8.length) {
                        break label88;
                     }

                     String[] var10 = var8[var9].split(":");
                     var11 = var10[0];
                     float var12 = 0.0F;
                     String var13 = "";
                     var11 = var10[0];
                     var12 = Float.parseFloat(var10[2]);
                     var13 = var10[3];
                     this.calculRubrique = new FeuilleCalculRubrique();
                     this.calculRubrique.setPlanPaye((PlanPaye)null);
                     if (this.lesRubriques.size() != 0) {
                        new PlanPaye();

                        for(int var15 = 0; var15 < this.lesRubriques.size(); ++var15) {
                           this.calculRubrique = (FeuilleCalculRubrique)this.lesRubriques.get(var15);
                           PlanPaye var14 = this.calculRubrique.getPlanPaye();
                           this.feuilleCalcul = this.calculRubrique.getFeuilleCalcul();
                           if (var14.getPlpCode().equals(var11)) {
                              this.calculRubrique.setPlanPaye(var14);
                              this.calculRubrique.setFeuilleCalcul(this.feuilleCalcul);
                              this.calculRubrique.setFeurubCode(var11);
                              break;
                           }
                        }
                     }

                     if (this.calculRubrique.getPlanPaye() != null) {
                        this.preCalcul = true;
                        this.calculBulletinLigne(var1);
                        double var22 = this.bulletinLigne.getBulligValColE();
                        String var16 = this.bulletinLigne.getBulligRubrique();
                        if (this.objetBaseReference.getCalculReference().contains(var16)) {
                           if (var12 == 100.0F) {
                              var5 += this.utilNombre.myRoundDevise(var22, this.structureLog.getStrdevise());
                           } else if (var12 != 0.0F) {
                              var5 += this.utilNombre.myRoundDevise(var22 * (double)var12 / 100.0D, this.structureLog.getStrdevise());
                           }
                        }
                     }

                     ++var9;
                  }
               } else {
                  var8 = this.objetBaseReference.getCalculReference().split(":");
                  String var17 = "";
                  float var18 = 0.0F;
                  var11 = "";
                  var17 = var8[0];
                  var18 = Float.parseFloat(var8[2]);
                  var11 = var8[3];
                  this.calculRubrique = new FeuilleCalculRubrique();
                  this.calculRubrique.setPlanPaye((PlanPaye)null);
                  if (this.lesRubriques.size() != 0) {
                     new PlanPaye();

                     for(int var21 = 0; var21 < this.lesRubriques.size(); ++var21) {
                        this.calculRubrique = (FeuilleCalculRubrique)this.lesRubriques.get(var21);
                        PlanPaye var19 = this.calculRubrique.getPlanPaye();
                        this.feuilleCalcul = this.calculRubrique.getFeuilleCalcul();
                        if (var19.getPlpCode().equals(var17)) {
                           this.calculRubrique.setPlanPaye(var19);
                           this.calculRubrique.setFeuilleCalcul(this.feuilleCalcul);
                           this.calculRubrique.setFeurubCode(var17);
                           break;
                        }
                     }
                  }

                  if (this.calculRubrique.getPlanPaye() != null) {
                     this.preCalcul = true;
                     this.calculBulletinLigne(var1);
                     double var20 = this.bulletinLigne.getBulligValColE();
                     String var23 = this.bulletinLigne.getBulligRubrique();
                     if (this.objetBaseReference.getCalculReference().contains(var23)) {
                        if (var18 == 100.0F) {
                           var5 += this.utilNombre.myRoundDevise(var20, this.structureLog.getStrdevise());
                        } else if (var18 != 0.0F) {
                           var5 += this.utilNombre.myRoundDevise(var20 * (double)var18 / 100.0D, this.structureLog.getStrdevise());
                        }
                     }
                  }
                  break;
               }
            }
         }
      }

      this.bulletinLigne = var2;
      this.calculRubrique = var3;
      this.lesformules = this.feuilleCalculFormuleDao.chargerRubriqueFeuille(this.calculRubrique, var1);
      this.memoValeur = 0.0D;
      this.operateur = "=";
      this.preCalcul = false;
      this.valeur = var5;
      return this.valeur;
   }

   public void M000097(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
         var2 = this.bulletinLigne.getBulligValColB();
      } else if (this.modeRegularisation == 2) {
         var2 = this.bulletinLigne.getBulligValColB();
      } else {
         var2 = this.calculBaseImposasableSocialeTotal(var1);
      }

      this.valeur = var2 * this.bulletinLigne.getBulligValColC() / 100.0D;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000098(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
         var2 = this.bulletinLigne.getBulligValColB();
      } else if (this.modeRegularisation == 2) {
         var2 = this.bulletinLigne.getBulligValColB();
      } else {
         var2 = this.calculBaseImposasableSocialeTotal(var1);
      }

      this.valeur = var2 * this.bulletinLigne.getBulligValColC() / 100.0D;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000099(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
         var2 = this.bulletinLigne.getBulligValColB();
      } else if (this.modeRegularisation == 2) {
         var2 = this.bulletinLigne.getBulligValColB();
      } else {
         var2 = this.calculBaseImposasableSocialeTotal(var1);
      }

      this.valeur = var2 * this.bulletinLigne.getBulligValColC() / 100.0D;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000100(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
         var2 = this.bulletinLigne.getBulligValColB();
      } else if (this.modeRegularisation == 2) {
         var2 = this.bulletinLigne.getBulligValColB();
      } else {
         var2 = this.calculBaseImposasableSocialeTotal(var1);
      }

      this.valeur = var2 * this.bulletinLigne.getBulligValColC() / 100.0D;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000101(Session var1) {
      if (this.montantAtteindre == 0.0D) {
         boolean var2 = false;
         if (this.optionPaye.getArrondiNet().equals("0")) {
            if (this.salariesElements.getSaleleModeReglement() == 0) {
               var2 = true;
            }
         } else if (this.optionPaye.getArrondiNet().equals("1")) {
            if (this.salariesElements.getSaleleModeReglement() == 0 || this.salariesElements.getSaleleModeReglement() == 1) {
               var2 = true;
            }
         } else if (this.optionPaye.getArrondiNet().equals("2")) {
            if (this.salariesElements.getSaleleModeReglement() == 0 || this.salariesElements.getSaleleModeReglement() == 1 || this.salariesElements.getSaleleModeReglement() == 3 || this.salariesElements.getSaleleModeReglement() == 4 || this.salariesElements.getSaleleModeReglement() == 5) {
               var2 = true;
            }
         } else if (this.optionPaye.getArrondiNet().equals("3") && this.salariesElements.getSaleleModeReglement() >= 0 && this.salariesElements.getSaleleModeReglement() <= 5) {
            var2 = true;
         }

         if (var2) {
            double var3 = 0.0D;
            new BulletinLigne();

            for(int var6 = 0; var6 < this.lesBulletinsLigne.size(); ++var6) {
               BulletinLigne var5 = (BulletinLigne)this.lesBulletinsLigne.get(var6);
               if (var5.getBulligNature() == 69 || var5.getBulligNature() == 70 || var5.getBulligNature() == 80 || var5.getBulligNature() == 88) {
                  var3 += var5.getBulligValColE();
               }
            }

            if (var3 >= 0.0D) {
               var3 = this.utilNombre.myRoundDevise(var3, this.structureLog.getStrdevise());
               byte var14 = 10;
               double var7 = var3 / (double)var14;
               if (var7 != 0.0D) {
                  String var9 = "" + var7;
                  int var10 = Integer.parseInt(var9.substring(var9.indexOf(".") + 1));
                  if (var10 != 0) {
                     var9 = "" + (var7 + 1.0D);
                     String var11 = var9.substring(0, var9.indexOf("."));
                     double var12 = Double.parseDouble(var11);
                     this.valeur = this.utilNombre.myRoundDevise(var12 * (double)var14 - var3, this.structureLog.getStrdevise());
                  } else {
                     this.valeur = 0.0D;
                  }
               } else {
                  this.valeur = 0.0D;
               }
            } else {
               this.valeur = 0.0D;
            }
         } else {
            this.valeur = 0.0D;
         }
      } else {
         this.valeur = 0.0D;
      }

   }

   public void M000102(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      if (var2 <= 1000000.0D) {
         this.valeur = 0.0D;
      } else if (var2 >= 1000001.0D && var2 <= 5000000.0D) {
         this.valeur = this.utilNombre.myRoundDevise(var2 * 0.05D, this.structureLog.getStrdevise());
      } else if (var2 >= 5000001.0D && var2 <= 1.0E7D) {
         this.valeur = this.utilNombre.myRoundDevise(var2 * 0.1D, this.structureLog.getStrdevise());
      } else if (var2 >= 1.0000001E7D) {
         this.valeur = this.utilNombre.myRoundDevise(var2 * 0.15D, this.structureLog.getStrdevise());
      }

      this.valeur = this.calculARR(this.valeur);
   }

   public void M000103(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      if (var2 <= this.optionPaye.getSmig()) {
         this.valeur = 0.0D;
      } else {
         if (var2 >= this.optionPaye.getSecuriteSocialeGene()) {
            var2 = this.optionPaye.getSecuriteSocialeGene();
         }

         double var4 = 0.013D;
         if (this.bulletinLigne.getBulligValColC() != 0.0D) {
            var4 = this.bulletinLigne.getBulligValColC() / 100.0D;
         }

         this.valeur = this.utilNombre.myRoundDevise(var2 * var4, this.structureLog.getStrdevise());
      }

      this.valeur = this.calculARR(this.valeur);
   }

   public void M000104(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      if (var2 <= this.optionPaye.getSmig()) {
         this.valeur = 0.0D;
      } else {
         if (var2 >= this.optionPaye.getSecuriteSocialeGene()) {
            var2 = this.optionPaye.getSecuriteSocialeGene();
         }

         double var4 = 0.0086D;
         if (this.bulletinLigne.getBulligValColC() != 0.0D) {
            var4 = this.bulletinLigne.getBulligValColC() / 100.0D;
         }

         this.valeur = this.utilNombre.myRoundDevise(var2 * var4, this.structureLog.getStrdevise());
      }

      this.valeur = this.calculARR(this.valeur);
   }

   public void M000105(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      if (var2 <= this.optionPaye.getSmig()) {
         this.valeur = 0.0D;
      } else {
         if (var2 >= this.optionPaye.getSecuriteSocialeGene()) {
            var2 = this.optionPaye.getSecuriteSocialeGene();
         }

         double var4 = 0.0142D;
         if (this.bulletinLigne.getBulligValColC() != 0.0D) {
            var4 = this.bulletinLigne.getBulligValColC() / 100.0D;
         }

         this.valeur = this.utilNombre.myRoundDevise(var2 * var4, this.structureLog.getStrdevise());
      }

      this.valeur = this.calculARR(this.valeur);
   }

   public void M000106(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      if (var2 <= this.optionPaye.getSmig()) {
         this.valeur = 0.0D;
      } else {
         if (var2 >= this.optionPaye.getSecuriteSocialeGene()) {
            var2 = this.optionPaye.getSecuriteSocialeGene();
         }

         double var4 = 0.0142D;
         if (this.bulletinLigne.getBulligValColC() != 0.0D) {
            var4 = this.bulletinLigne.getBulligValColC() / 100.0D;
         }

         this.valeur = this.utilNombre.myRoundDevise(var2 * var4, this.structureLog.getStrdevise());
      }

      this.valeur = this.calculARR(this.valeur);
   }

   public void M000107(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      double var4 = 0.06D;
      if (this.bulletinLigne.getBulligValColC() != 0.0D) {
         var4 = this.bulletinLigne.getBulligValColC() / 100.0D;
      }

      this.valeur = this.utilNombre.myRoundDevise(var2 * var4, this.structureLog.getStrdevise());
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000108(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      double var4 = 0.03D;
      if (this.bulletinLigne.getBulligValColC() != 0.0D) {
         var4 = this.bulletinLigne.getBulligValColC() / 100.0D;
      }

      this.valeur = this.utilNombre.myRoundDevise(var2 * var4, this.structureLog.getStrdevise());
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000109(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      if (var2 <= this.optionPaye.getSmig()) {
         this.valeur = 0.0D;
      } else {
         if (var2 >= this.optionPaye.getSecuriteSocialeGene()) {
            var2 = this.optionPaye.getSecuriteSocialeGene();
         }

         double var4 = 0.047D;
         if (this.bulletinLigne.getBulligValColC() != 0.0D) {
            var4 = this.bulletinLigne.getBulligValColC() / 100.0D;
         }

         this.valeur = this.utilNombre.myRoundDevise(var2 * var4, this.structureLog.getStrdevise());
      }

      this.valeur = this.calculARR(this.valeur);
   }

   public void M000110(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      if (var2 <= this.optionPaye.getSmig()) {
         this.valeur = 0.0D;
      } else {
         if (var2 >= this.optionPaye.getSecuriteSocialeGene()) {
            var2 = this.optionPaye.getSecuriteSocialeGene();
         }

         double var4 = 0.0314D;
         if (this.bulletinLigne.getBulligValColC() != 0.0D) {
            var4 = this.bulletinLigne.getBulligValColC() / 100.0D;
         }

         this.valeur = this.utilNombre.myRoundDevise(var2 * var4, this.structureLog.getStrdevise());
      }

      this.valeur = this.calculARR(this.valeur);
   }

   public void M000111(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      if (var2 <= this.optionPaye.getSmig()) {
         this.valeur = 0.0D;
      } else {
         if (var2 >= this.optionPaye.getSecuriteSocialeGene()) {
            var2 = this.optionPaye.getSecuriteSocialeGene();
         }

         double var4 = 0.0508D;
         if (this.bulletinLigne.getBulligValColC() != 0.0D) {
            var4 = this.bulletinLigne.getBulligValColC() / 100.0D;
         }

         this.valeur = this.utilNombre.myRoundDevise(var2 * var4, this.structureLog.getStrdevise());
      }

      this.valeur = this.calculARR(this.valeur);
   }

   public void M000112(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      if (var2 <= this.optionPaye.getSmig()) {
         this.valeur = 0.0D;
      } else {
         if (var2 >= this.optionPaye.getSecuriteSocialeGene()) {
            var2 = this.optionPaye.getSecuriteSocialeGene();
         }

         double var4 = 0.0508D;
         if (this.bulletinLigne.getBulligValColC() != 0.0D) {
            var4 = this.bulletinLigne.getBulligValColC() / 100.0D;
         }

         this.valeur = this.utilNombre.myRoundDevise(var2 * var4, this.structureLog.getStrdevise());
      }

      this.valeur = this.calculARR(this.valeur);
   }

   public void M000113(Session var1) throws ParseException, HibernateException, NamingException {
      boolean var2 = true;
      boolean var3 = true;
      if (this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && this.salariesElements.getSaleleNature().equals("04")) {
         var3 = true;
      }

      this.valeur = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      Date var10 = this.d1;
      Date var11 = this.d2;
      var8 = this.optionPaye.getCnamgs() * this.optionPaye.getTauxcnamgsPS() / 100.0D;
      if (this.dateGeneration.getMonth() + 1 != 3 && this.dateGeneration.getMonth() + 1 != 6 && this.dateGeneration.getMonth() + 1 != 9 && this.dateGeneration.getMonth() + 1 != 12) {
         this.valeur = this.bulletinLigne.getBulligValColB() * (this.optionPaye.getTauxcnamgsPS() / 100.0D);
      } else {
         if (this.dateGeneration.getMonth() + 1 == 3) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-01-01");
            this.d2 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-03-31");
         } else if (this.dateGeneration.getMonth() + 1 == 6) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-04-01");
            this.d2 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-06-30");
         } else if (this.dateGeneration.getMonth() + 1 == 9) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-07-01");
            this.d2 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-09-30");
         } else if (this.dateGeneration.getMonth() + 1 == 12) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-10-01");
            this.d2 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-12-31");
         }

         new ArrayList();
         new ArrayList();
         new ArrayList();
         new ArrayList();
         double var16 = 0.0D;
         if (this.netAAtteindre != 0.0D) {
            for(int var18 = 0; var18 < this.lesBulletinsLigne.size(); ++var18) {
               if (((BulletinLigne)this.lesBulletinsLigne.get(var18)).getBulligNature() == 59) {
                  var16 += ((BulletinLigne)this.lesBulletinsLigne.get(var18)).getBulligValColE();
               }
            }
         }

         double var33 = 0.0D;
         List var13 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("299999", var10, this.d2, this.salaries, var1);

         for(int var20 = 0; var20 < var13.size(); ++var20) {
            var33 += ((BulletinLigne)var13.get(var20)).getBulligValColE();
         }

         double var34 = 0.0D;

         int var22;
         for(var22 = 0; var22 < this.lesBulletinsLigne.size(); ++var22) {
            int var23 = Integer.parseInt(((BulletinLigne)this.lesBulletinsLigne.get(var22)).getBulligRubrique());
            if (var23 >= 109500 && var23 <= 109559) {
               var34 += ((BulletinLigne)this.lesBulletinsLigne.get(var22)).getBulligValColE();
            }
         }

         List var15 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("109500", "109559", var10, this.d2, this.salaries, var1);

         for(var22 = 0; var22 < var15.size(); ++var22) {
            var34 += ((BulletinLigne)var15.get(var22)).getBulligValColE();
         }

         if (var34 >= 4000000.0D) {
            var34 = 4000000.0D;
         }

         double var35 = 0.0D;

         int var24;
         for(var24 = 0; var24 < this.lesBulletinsLigne.size(); ++var24) {
            int var25 = Integer.parseInt(((BulletinLigne)this.lesBulletinsLigne.get(var24)).getBulligRubrique());
            if (var25 >= 109560 && var25 <= 109599) {
               var35 += ((BulletinLigne)this.lesBulletinsLigne.get(var24)).getBulligValColE();
            }
         }

         var15 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("109560", "109599", var10, this.d2, this.salaries, var1);

         for(var24 = 0; var24 < var15.size(); ++var24) {
            var35 += ((BulletinLigne)var15.get(var24)).getBulligValColE();
         }

         double var36 = 0.0D;
         if (this.netAAtteindre != 0.0D) {
            for(int var26 = 0; var26 < this.lesBulletinsLigne.size(); ++var26) {
               if (((BulletinLigne)this.lesBulletinsLigne.get(var26)).getBulligNature() == 50) {
                  var36 += ((BulletinLigne)this.lesBulletinsLigne.get(var26)).getBulligValColE();
               }
            }
         }

         double var37 = 0.0D;
         List var14 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries(50, var10, this.d2, this.salaries, var1);

         for(int var28 = 0; var28 < var14.size(); ++var28) {
            var37 += ((BulletinLigne)var14.get(var28)).getBulligValColE();
         }

         double var38 = 0.0D;
         if (this.netAAtteindre != 0.0D) {
            for(int var30 = 0; var30 < this.lesBulletinsLigne.size(); ++var30) {
               if (((BulletinLigne)this.lesBulletinsLigne.get(var30)).getBulligRubrique().equals("300020")) {
                  var38 = ((BulletinLigne)this.lesBulletinsLigne.get(var30)).getBulligValColE();
                  break;
               }
            }
         }

         double var39 = 0.0D;
         List var12 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("300000", var10, this.d2, this.salaries, var1);

         int var32;
         for(var32 = 0; var32 < var12.size(); ++var32) {
            var39 += ((BulletinLigne)var12.get(var32)).getBulligValColE();
         }

         var12 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("300020", var10, this.d2, this.salaries, var1);

         for(var32 = 0; var32 < var12.size(); ++var32) {
            var4 += ((BulletinLigne)var12.get(var32)).getBulligValColE();
         }

         var6 = var33 + var16 + var39 + var38 - var34 - var35 + var37 + var36;
         this.valeur = var6 * (this.optionPaye.getTauxcnamgsPS() / 100.0D);
         this.valeur += var4;
      }

      if (this.valeur > var8) {
         this.valeur = var8;
      }

      this.valeur = this.calculARR(this.valeur);
   }

   public void M000114(Session var1) throws HibernateException, NamingException, ParseException {
      boolean var2 = true;
      boolean var3 = true;
      if (this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && this.salariesElements.getSaleleNature().equals("04")) {
         var3 = true;
      }

      this.valeur = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      Date var10 = this.d1;
      Date var11 = this.d2;
      var8 = this.optionPaye.getCnamgs() * this.optionPaye.getTauxcnamgsPP() / 100.0D;
      if (this.dateGeneration.getMonth() + 1 != 3 && this.dateGeneration.getMonth() + 1 != 6 && this.dateGeneration.getMonth() + 1 != 9 && this.dateGeneration.getMonth() + 1 != 12) {
         this.valeur = this.bulletinLigne.getBulligValColB() * (this.optionPaye.getTauxcnamgsPP() / 100.0D);
      } else {
         if (this.dateGeneration.getMonth() + 1 == 3) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-01-01");
            var11 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-03-31");
         } else if (this.dateGeneration.getMonth() + 1 == 6) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-04-01");
            var11 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-06-30");
         } else if (this.dateGeneration.getMonth() + 1 == 9) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-07-01");
            var11 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-09-30");
         } else if (this.dateGeneration.getMonth() + 1 == 12) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-10-01");
            var11 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-12-31");
         }

         new ArrayList();
         new ArrayList();
         new ArrayList();
         new ArrayList();
         double var16 = 0.0D;
         if (this.netAAtteindre != 0.0D) {
            for(int var18 = 0; var18 < this.lesBulletinsLigne.size(); ++var18) {
               if (((BulletinLigne)this.lesBulletinsLigne.get(var18)).getBulligNature() == 59) {
                  var16 += ((BulletinLigne)this.lesBulletinsLigne.get(var18)).getBulligValColE();
               }
            }
         }

         double var33 = 0.0D;
         List var13 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("299999", var10, var11, this.salaries, var1);

         for(int var20 = 0; var20 < var13.size(); ++var20) {
            var33 += ((BulletinLigne)var13.get(var20)).getBulligValColE();
         }

         double var34 = 0.0D;

         int var22;
         for(var22 = 0; var22 < this.lesBulletinsLigne.size(); ++var22) {
            int var23 = Integer.parseInt(((BulletinLigne)this.lesBulletinsLigne.get(var22)).getBulligRubrique());
            if (var23 >= 109500 && var23 <= 109559) {
               var34 += ((BulletinLigne)this.lesBulletinsLigne.get(var22)).getBulligValColE();
            }
         }

         List var15 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("109500", "109559", var10, this.d2, this.salaries, var1);

         for(var22 = 0; var22 < var15.size(); ++var22) {
            var34 += ((BulletinLigne)var15.get(var22)).getBulligValColE();
         }

         if (var34 >= 4000000.0D) {
            var34 = 4000000.0D;
         }

         double var35 = 0.0D;

         int var24;
         for(var24 = 0; var24 < this.lesBulletinsLigne.size(); ++var24) {
            int var25 = Integer.parseInt(((BulletinLigne)this.lesBulletinsLigne.get(var24)).getBulligRubrique());
            if (var25 >= 109560 && var25 <= 109599) {
               var35 += ((BulletinLigne)this.lesBulletinsLigne.get(var24)).getBulligValColE();
            }
         }

         var15 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("109560", "109599", var10, this.d2, this.salaries, var1);

         for(var24 = 0; var24 < var15.size(); ++var24) {
            var35 += ((BulletinLigne)var15.get(var24)).getBulligValColE();
         }

         double var36 = 0.0D;

         for(int var26 = 0; var26 < this.lesBulletinsLigne.size(); ++var26) {
            if (((BulletinLigne)this.lesBulletinsLigne.get(var26)).getBulligNature() == 50) {
               var36 += ((BulletinLigne)this.lesBulletinsLigne.get(var26)).getBulligValColE();
            }
         }

         double var37 = 0.0D;
         List var14 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries(50, var10, var11, this.salaries, var1);

         for(int var28 = 0; var28 < var14.size(); ++var28) {
            var37 += ((BulletinLigne)var14.get(var28)).getBulligValColE();
         }

         double var38 = 0.0D;
         if (this.netAAtteindre != 0.0D) {
            for(int var30 = 0; var30 < this.lesBulletinsLigne.size(); ++var30) {
               if (((BulletinLigne)this.lesBulletinsLigne.get(var30)).getBulligRubrique().equals("900000")) {
                  var38 = ((BulletinLigne)this.lesBulletinsLigne.get(var30)).getBulligValColE();
                  break;
               }
            }
         }

         double var39 = 0.0D;
         List var12 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("900000", var10, var11, this.salaries, var1);

         int var32;
         for(var32 = 0; var32 < var12.size(); ++var32) {
            var39 += ((BulletinLigne)var12.get(var32)).getBulligValColE();
         }

         var12 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("900020", var10, var11, this.salaries, var1);

         for(var32 = 0; var32 < var12.size(); ++var32) {
            var4 += ((BulletinLigne)var12.get(var32)).getBulligValColE();
         }

         var6 = var33 + var16 + var39 + var38 + var37 + var36 - var34 - var35;
         this.valeur = var6 * (this.optionPaye.getTauxcnamgsPP() / 100.0D);
         this.valeur += var4;
      }

      if (this.valeur > var8) {
         this.valeur = var8;
      }

      this.valeur = this.calculARR(this.valeur);
   }

   public void M000115(Session var1) throws HibernateException, NamingException, ParseException {
      boolean var2 = true;
      boolean var3 = true;
      if (this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && this.salariesElements.getSaleleNature().equals("04")) {
         var3 = true;
      }

      this.valeur = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      Date var10 = this.d1;
      Date var11 = this.d2;
      var8 = this.optionPaye.getSecuriteSocialeGene() * this.optionPaye.getTauxfnhPP() / 100.0D;
      if (this.dateGeneration.getMonth() + 1 != 3 && this.dateGeneration.getMonth() + 1 != 6 && this.dateGeneration.getMonth() + 1 != 9 && this.dateGeneration.getMonth() + 1 != 12) {
         this.valeur = this.bulletinLigne.getBulligValColB() * (this.optionPaye.getTauxfnhPP() / 100.0D);
      } else {
         if (this.dateGeneration.getMonth() + 1 == 3) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-01-01");
            var11 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-03-31");
         } else if (this.dateGeneration.getMonth() + 1 == 6) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-04-01");
            var11 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-06-30");
         } else if (this.dateGeneration.getMonth() + 1 == 9) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-07-01");
            var11 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-09-30");
         } else if (this.dateGeneration.getMonth() + 1 == 12) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-10-01");
            var11 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-12-31");
         }

         new ArrayList();
         new ArrayList();
         double var14 = 0.0D;
         if (this.netAAtteindre != 0.0D) {
            for(int var16 = 0; var16 < this.lesBulletinsLigne.size(); ++var16) {
               if (((BulletinLigne)this.lesBulletinsLigne.get(var16)).getBulligNature() == 59) {
                  var14 += ((BulletinLigne)this.lesBulletinsLigne.get(var16)).getBulligValColE();
               }
            }
         }

         double var19 = 0.0D;
         List var13 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("299999", var10, var11, this.salaries, var1);

         int var18;
         for(var18 = 0; var18 < var13.size(); ++var18) {
            var19 += ((BulletinLigne)var13.get(var18)).getBulligValColE();
         }

         List var12 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("900010", var10, var11, this.salaries, var1);

         for(var18 = 0; var18 < var12.size(); ++var18) {
            var4 += ((BulletinLigne)var12.get(var18)).getBulligValColE();
         }

         var4 *= -1.0D;
         var6 = var19 + var14;
         this.valeur = var6 * (this.optionPaye.getTauxfnhPP() / 100.0D);
         this.valeur -= var4;
      }

      if (this.valeur > var8) {
         this.valeur = var8;
      }

      this.valeur = this.calculARR(this.valeur);
   }

   public void M000116(Session var1) {
      this.valeur = this.optionPaye.getTauxcnssPS();
   }

   public void M000117(Session var1) {
      this.valeur = this.optionPaye.getTauxcnssPP();
   }

   public void M000118(Session var1) {
      this.valeur = this.optionPaye.getTauxcnamgsPS();
   }

   public void M000119(Session var1) {
      this.valeur = this.optionPaye.getTauxcnamgsPP();
   }

   public void M000120(Session var1) {
      this.valeur = this.optionPaye.getSecuriteSocialeGene();
   }

   public void M000121(Session var1) {
      this.valeur = this.optionPaye.getCnamgs();
   }

   public void M000122(Session var1) throws HibernateException, NamingException {
      this.valeur = 0.0D;
      double var2 = this.calculBrutEnCours(var1);
      this.valeur = var2 * 0.02D;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000123(Session var1) throws HibernateException, NamingException {
      this.valeur = 0.0D;
      double var2 = this.calculBrutEnCours(var1);
      this.valeur = var2 * 0.006D;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000124(Session var1) {
      if (this.bulletinLigne.getBulligValColA() >= this.optionPaye.getSecuriteSocialeGene()) {
         this.valeur = this.optionPaye.getSecuriteSocialeGene();
      } else {
         this.valeur = this.bulletinLigne.getBulligValColA();
      }

   }

   public void M000125(Session var1) {
      if (this.bulletinLigne.getBulligValColA() >= this.optionPaye.getCnamgs()) {
         this.valeur = this.optionPaye.getCnamgs();
      } else {
         this.valeur = this.bulletinLigne.getBulligValColA();
      }

   }

   public void M000126(Session var1) {
      this.valeur = this.optionPaye.getTauxfnhPP();
   }

   public void M000127(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      if (this.bulletinLigne != null) {
      }

      var2 = this.calculBrutEnCours(var1);
      this.valeur = var2;
   }

   public void M000128(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      double var4 = this.calculAvnEnCours(var1);
      double var6 = this.calculIndCompEnCours(var1);
      double var8 = 0.0D;
      if (var4 != 0.0D && var6 != 0.0D) {
         if (var4 > var6) {
            ;
         }
      } else if (var4 == 0.0D) {
         if (var6 != 0.0D) {
            ;
         }
      }

      double var10 = this.calculRubriqueEnCours("300000", var1);
      double var12 = this.calculRubriqueEnCours("109500", "109559", var1);
      double var14 = this.calculRubriqueEnCours("109560", "109599", var1);
      this.valeur = var2 + var4 + var10 - var12 - var14;
   }

   public void M000129(Session var1) {
   }

   public void M000130() {
      if (this.salariesContrats != null) {
         if (this.salariesContrats.getSalconNivEmploi() != null && !this.salariesContrats.getSalconNivEmploi().isEmpty()) {
            if (this.salariesContrats.getSalconNivEmploi().equals("1")) {
               this.valeur = this.memoValeur;
               this.memoValeur = 0.0D;
            } else {
               this.valeur = 0.0D;
               this.memoValeur = 0.0D;
            }
         } else {
            this.valeur = 0.0D;
            this.memoValeur = 0.0D;
         }
      } else if (this.salariesElements != null && this.salariesElements.getSaleleNivEmploi() != null && !this.salariesElements.getSaleleNivEmploi().isEmpty()) {
         if (this.salariesElements.getSaleleNivEmploi().equals("1")) {
            this.valeur = this.memoValeur;
            this.memoValeur = 0.0D;
         } else {
            this.valeur = 0.0D;
            this.memoValeur = 0.0D;
         }
      } else {
         this.valeur = 0.0D;
         this.memoValeur = 0.0D;
      }

   }

   public void M000131() {
      if (this.salariesContrats != null) {
         if (this.salariesContrats.getSalconNivEmploi() != null && !this.salariesContrats.getSalconNivEmploi().isEmpty()) {
            if (this.salariesContrats.getSalconNivEmploi().equals("1")) {
               this.valeur = 0.0D;
               this.memoValeur = 0.0D;
            } else {
               this.valeur = this.memoValeur;
               this.memoValeur = 0.0D;
            }
         } else {
            this.valeur = 0.0D;
            this.memoValeur = 0.0D;
         }
      } else if (this.salariesElements != null && this.salariesElements.getSaleleNivEmploi() != null && !this.salariesElements.getSaleleNivEmploi().isEmpty()) {
         if (this.salariesElements.getSaleleNivEmploi().equals("1")) {
            this.valeur = 0.0D;
            this.memoValeur = 0.0D;
         } else {
            this.valeur = this.memoValeur;
            this.memoValeur = 0.0D;
         }
      } else {
         this.valeur = 0.0D;
         this.memoValeur = 0.0D;
      }

   }

   public void M000132() {
      if (this.salariesContrats != null) {
         if (this.salariesContrats.getSalconNivEmploi() != null && !this.salariesContrats.getSalconNivEmploi().isEmpty()) {
            if (!this.salariesContrats.getSalconNivEmploi().equals("2") && !this.salariesContrats.getSalconNivEmploi().equals("3")) {
               this.valeur = 0.0D;
               this.memoValeur = 0.0D;
            } else {
               this.valeur = this.memoValeur;
               this.memoValeur = 0.0D;
            }
         } else {
            this.valeur = 0.0D;
            this.memoValeur = 0.0D;
         }
      } else if (this.salariesElements != null && this.salariesElements.getSaleleNivEmploi() != null && !this.salariesElements.getSaleleNivEmploi().isEmpty()) {
         if (!this.salariesElements.getSaleleNivEmploi().equals("2") && !this.salariesElements.getSaleleNivEmploi().equals("3")) {
            this.valeur = 0.0D;
            this.memoValeur = 0.0D;
         } else {
            this.valeur = this.memoValeur;
            this.memoValeur = 0.0D;
         }
      } else {
         this.valeur = 0.0D;
         this.memoValeur = 0.0D;
      }

   }

   public void M000133() {
      if (this.salariesContrats != null) {
         if (this.salariesContrats.getSalconNivEmploi() != null && !this.salariesContrats.getSalconNivEmploi().isEmpty()) {
            if (!this.salariesContrats.getSalconNivEmploi().equals("4") && !this.salariesContrats.getSalconNivEmploi().equals("5") && !this.salariesContrats.getSalconNivEmploi().equals("6")) {
               this.valeur = 0.0D;
               this.memoValeur = 0.0D;
            } else {
               this.valeur = this.memoValeur;
               this.memoValeur = 0.0D;
            }
         } else {
            this.valeur = 0.0D;
            this.memoValeur = 0.0D;
         }
      } else if (this.salariesElements != null && this.salariesElements.getSaleleNivEmploi() != null && !this.salariesElements.getSaleleNivEmploi().isEmpty()) {
         if (!this.salariesContrats.getSalconNivEmploi().equals("4") && !this.salariesContrats.getSalconNivEmploi().equals("5") && !this.salariesContrats.getSalconNivEmploi().equals("6")) {
            this.valeur = 0.0D;
            this.memoValeur = 0.0D;
         } else {
            this.valeur = this.memoValeur;
            this.memoValeur = 0.0D;
         }
      } else {
         this.valeur = 0.0D;
         this.memoValeur = 0.0D;
      }

   }

   public void M000134(Session var1) throws ParseException, HibernateException, NamingException {
      Date var2 = this.utilDate.dateMoisPrecedent(this.dateGeneration);
      String var3 = this.formatPeriode(var2);
      this.valeur = this.calculRubriquePeriode("699999", var3, var1);
      if (this.valeur >= 0.0D) {
         this.valeur = 0.0D;
      }

   }

   public void M000135(Session var1) {
      double var2 = 0.0D;
      double var4 = 0.0D;
      if (this.lesBulletinsLigne.size() != 0) {
         for(int var6 = 0; var6 < this.lesBulletinsLigne.size(); ++var6) {
            if (((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligNature() <= 49 || ((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligNature() == 70) {
               if (((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligNature() == 11) {
                  var4 += ((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligValColE();
               } else {
                  var2 += ((BulletinLigne)this.lesBulletinsLigne.get(var6)).getBulligValColE();
               }
            }
         }
      }

      double var9 = this.optionPaye.getSmig();
      float var8 = 0.0F;
      var8 = (float)this.M000040(var1);
      var9 = this.utilNombre.myRoundDevise(var9 / (double)this.nbJourRef * (double)var8, this.structureLog.getStrdevise());
      if (var2 < var9) {
         this.valeur = var9 - var2;
      } else {
         this.valeur = 0.0D;
      }

   }

   public void M000136(Session var1) throws ParseException, HibernateException, NamingException {
      boolean var2 = false;

      for(int var3 = 0; var3 < this.lesBulletinsLigne.size(); ++var3) {
         if (((BulletinLigne)this.lesBulletinsLigne.get(var3)).getBulligRubrique().equals("208000")) {
            if (((BulletinLigne)this.lesBulletinsLigne.get(var3)).getBulligValColD() != 0.0D) {
               var2 = true;
            }
            break;
         }
      }

      if (var2) {
         Date var5 = this.utilDate.dateMoisPrecedent(this.dateGeneration);
         String var4 = this.formatPeriode(var5);
         this.valeur = this.calculRubriquePeriode("208030", var4, var1);
      }

   }

   public void M000137(Session var1) throws ParseException {
      float var2 = 0.0F;
      if (this.lesAbsences.size() != 0) {
         for(int var3 = 0; var3 < this.lesAbsences.size(); ++var3) {
            if (((SalariesConges)this.lesAbsences.get(var3)).getSalcngType() == 1 && ((SalariesConges)this.lesAbsences.get(var3)).getSalcngNature() == 14) {
               var2 += ((SalariesConges)this.lesAbsences.get(var3)).getSalcngNbHeure();
            }
         }
      }

      this.valeur = (double)var2;
   }

   public void M000138(Session var1) {
      this.valeur = this.optionPaye.getTauxcfpPP();
   }

   public void M000139(Session var1) throws HibernateException, NamingException, ParseException {
      boolean var2 = true;
      boolean var3 = true;
      if (this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && this.salariesElements.getSaleleNature().equals("04")) {
         var3 = true;
      }

      this.valeur = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      Date var10 = this.d1;
      Date var11 = this.d2;
      var8 = this.optionPaye.getSecuriteSocialeGene() * this.optionPaye.getTauxcfpPP() / 100.0D;
      if (this.dateGeneration.getMonth() + 1 != 3 && this.dateGeneration.getMonth() + 1 != 6 && this.dateGeneration.getMonth() + 1 != 9 && this.dateGeneration.getMonth() + 1 != 12) {
         this.valeur = this.bulletinLigne.getBulligValColB() * (this.optionPaye.getTauxcfpPP() / 100.0D);
      } else {
         if (this.dateGeneration.getMonth() + 1 == 3) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-01-01");
            var11 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-03-31");
         } else if (this.dateGeneration.getMonth() + 1 == 6) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-04-01");
            var11 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-06-30");
         } else if (this.dateGeneration.getMonth() + 1 == 9) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-07-01");
            var11 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-09-30");
         } else if (this.dateGeneration.getMonth() + 1 == 12) {
            var10 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-10-01");
            var11 = this.utilDate.stringToDateSQLLight(this.dateGeneration.getYear() + 1900 + "-12-31");
         }

         new ArrayList();
         new ArrayList();
         double var14 = 0.0D;
         if (this.netAAtteindre != 0.0D) {
            for(int var16 = 0; var16 < this.lesBulletinsLigne.size(); ++var16) {
               if (((BulletinLigne)this.lesBulletinsLigne.get(var16)).getBulligNature() == 59) {
                  var14 += ((BulletinLigne)this.lesBulletinsLigne.get(var16)).getBulligValColE();
               }
            }
         }

         double var19 = 0.0D;
         List var13 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("299999", var10, var11, this.salaries, var1);

         int var18;
         for(var18 = 0; var18 < var13.size(); ++var18) {
            var19 += ((BulletinLigne)var13.get(var18)).getBulligValColE();
         }

         List var12 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("900040", var10, var11, this.salaries, var1);

         for(var18 = 0; var18 < var12.size(); ++var18) {
            var4 += ((BulletinLigne)var12.get(var18)).getBulligValColE();
         }

         var4 *= -1.0D;
         var6 = var19 + var14;
         this.valeur = var6 * (this.optionPaye.getTauxcfpPP() / 100.0D);
         this.valeur -= var4;
      }

      if (this.valeur > var8) {
         this.valeur = var8;
      }

      this.valeur = this.calculARR(this.valeur);
   }

   public void M000140(Session var1) {
      this.valeur = this.optionPaye.getTauxipressGenePS();
   }

   public void M000141(Session var1) {
      this.valeur = this.optionPaye.getTauxipressCadrePS();
   }

   public void M000142(Session var1) {
      this.valeur = this.optionPaye.getTauxipressGenePP();
   }

   public void M000143(Session var1) {
      this.valeur = this.optionPaye.getTauxipressCadrePP();
   }

   public void M000144(Session var1) {
      this.valeur = this.optionPaye.getTauxcsspfPP();
   }

   public void M000145(Session var1) {
      this.valeur = this.optionPaye.getTauxcssatPP();
   }

   public void M000146(Session var1) {
      this.valeur = this.optionPaye.getTauxcfcePP();
   }

   public void M000147() {
      this.valeur = this.salariesContrats.getSalconPrimeExceptionnelle();
      if (this.type_conges == 2) {
         this.valeur = 0.0D;
      }

   }

   public void M000148(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      if (this.bulletinLigne.getBulligValColB() != 0.0D && this.bulletinLigne.getBulligValColD() == 1.0D) {
         if (this.salariesElements.getSaleleNbJourTr() != 0.0F) {
            var2 = this.bulletinLigne.getBulligValColB() * (double)this.salariesElements.getSaleleNbJourCp() / (double)this.salariesElements.getSaleleNbJourTr();
            if (this.bulletinSalaire.getBulsalTypeCP() == 2) {
               new BulletinLigne();

               for(int var5 = 0; var5 < this.lesBulletinsLigne.size(); ++var5) {
                  BulletinLigne var4 = (BulletinLigne)this.lesBulletinsLigne.get(var5);
                  if (var4.getBulligNature() <= 30 || var4.getBulligNature() == 40 || var4.getBulligNature() == 42) {
                     var4 = this.bulletinLigneDao.trouvePorParapheur(var4.getBulligId(), var1);
                     if (var4 != null) {
                        this.bulletinLigneDao.delete(var4, var1);
                        this.lesBulletinsLigne.remove(var4);
                        --var5;
                     }
                  }
               }
            }
         }

         var2 = this.calculARR(var2);
      }

      this.valeur = var2;
   }

   public void M000149(Session var1) throws HibernateException, NamingException, ParseException {
      this.base_conges = 0.0D;
      Date var2 = null;
      double var3 = 0.0D;
      double var5 = 0.0D;
      if (this.lesHistoriques.size() != 0) {
         for(int var7 = 0; var7 < this.lesHistoriques.size(); ++var7) {
            if ((long)(((SalariesHistorique)this.lesHistoriques.get(var7)).getSalhisDate().getYear() + 1900) == this.exercicesPaye.getExepayId()) {
               if (((SalariesHistorique)this.lesHistoriques.get(var7)).getSalhisCode().equals("BRUT")) {
                  var3 += ((SalariesHistorique)this.lesHistoriques.get(var7)).getSalhisValeurColE();
                  var2 = this.utilDate.dateMoisPrecedent(((SalariesHistorique)this.lesHistoriques.get(var7)).getSalhisDate());
               } else if (((SalariesHistorique)this.lesHistoriques.get(var7)).getSalhisCode().equals("PRDCP")) {
                  var3 -= ((SalariesHistorique)this.lesHistoriques.get(var7)).getSalhisValeurColE();
               } else if (((SalariesHistorique)this.lesHistoriques.get(var7)).getSalhisCode().equals("CP")) {
                  var5 -= ((SalariesHistorique)this.lesHistoriques.get(var7)).getSalhisValeurColE();
               } else if (((SalariesHistorique)this.lesHistoriques.get(var7)).getSalhisCode().equals("NBJS")) {
               }
            }
         }
      }

      new ArrayList();
      List var19 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("208000", this.salaries, var1);
      List var8;
      if (var19.size() != 0) {
         int var9;
         if (var2 != null && var2.compareTo(((BulletinLigne)var19.get(var19.size() - 1)).getBulletinSalaire().getBulsalDateDebut()) < 0) {
            var2 = ((BulletinLigne)var19.get(var19.size() - 1)).getBulletinSalaire().getBulsalDateDebut();
            var3 = 0.0D;
            if (this.optionPaye.getBaseconges().equals("2")) {
               var5 = ((BulletinLigne)var19.get(var19.size() - 1)).getBulligValColE();
               new ArrayList();
               var8 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("208100", this.salaries, var1);
               if (var8.size() != 0) {
                  for(var9 = 0; var9 < var8.size(); ++var9) {
                     if (((BulletinLigne)var8.get(var9)).getBulletinSalaire().getBulsalId() == ((BulletinLigne)var19.get(var19.size() - 1)).getBulletinSalaire().getBulsalId()) {
                        var5 += ((BulletinLigne)var8.get(var9)).getBulligValColE();
                     }
                  }
               }
            }
         } else {
            var2 = ((BulletinLigne)var19.get(var19.size() - 1)).getBulletinSalaire().getBulsalDateDebut();
            var3 = 0.0D;
            if (this.optionPaye.getBaseconges().equals("2")) {
               var5 = ((BulletinLigne)var19.get(var19.size() - 1)).getBulligValColE();
               new ArrayList();
               var8 = this.bulletinLigneDao.chargerleslignesbyRubriquesSalaries("208100", this.salaries, var1);
               if (var8.size() != 0) {
                  for(var9 = 0; var9 < var8.size(); ++var9) {
                     if (((BulletinLigne)var8.get(var9)).getBulletinSalaire().getBulsalId() == ((BulletinLigne)var19.get(var19.size() - 1)).getBulletinSalaire().getBulsalId()) {
                        var5 += ((BulletinLigne)var8.get(var9)).getBulligValColE();
                     }
                  }
               }
            }
         }
      }

      if (var2 == null) {
         var2 = this.utilDate.stringToDateSQLLight("2000-01-01");
      } else {
         var2 = this.utilDate.dateMoisSuivant(var2);
      }

      new ArrayList();
      double var20 = var5;
      String var11 = this.calculRubrique.getPlanPaye().getPlpCalculBase();
      if (var11 != null && !var11.isEmpty()) {
         String[] var12;
         String var13;
         if (var11.contains("#")) {
            var12 = var11.split("#");
            var13 = "";

            int var14;
            String[] var15;
            String var16;
            for(var14 = 0; var14 < var12.length; ++var14) {
               var15 = var12[var14].split(":");
               var16 = var15[0];
               if (var13 != null && !var13.isEmpty()) {
                  var13 = var13 + ",'" + var16 + "'";
               } else {
                  var13 = "'" + var16 + "'";
               }
            }

            var8 = this.bulletinLigneDao.chargerleslignesLikeRubriquesSalaries(var13, var2, this.dateGeneration, this.salaries, var1);
            if (var8.size() != 0) {
               for(var14 = 0; var14 < var12.length; ++var14) {
                  var15 = var12[var14].split(":");
                  var16 = var15[0];
                  float var17 = Float.parseFloat(var15[2]);

                  for(int var18 = 0; var18 < var8.size(); ++var18) {
                     if (((BulletinLigne)var8.get(var18)).getBulligRubrique().equals(var16)) {
                        if (var17 == 100.0F) {
                           var20 += this.utilNombre.myRoundDevise(((BulletinLigne)var8.get(var18)).getBulligValColE(), this.structureLog.getStrdevise());
                        } else if (var17 == -100.0F) {
                           var20 -= this.utilNombre.myRoundDevise(((BulletinLigne)var8.get(var18)).getBulligValColE(), this.structureLog.getStrdevise());
                        } else {
                           var20 += this.utilNombre.myRoundDevise(((BulletinLigne)var8.get(var18)).getBulligValColE() * (double)var17 / 100.0D, this.structureLog.getStrdevise());
                        }
                     }
                  }
               }
            }
         } else {
            var12 = var11.split(":");
            var13 = "'" + var12[0] + "'";
            float var21 = Float.parseFloat(var12[2]);
            var8 = this.bulletinLigneDao.chargerleslignesLikeRubriquesSalaries(var13, var2, this.dateGeneration, this.salaries, var1);
            if (var8.size() != 0) {
               for(int var22 = 0; var22 < var8.size(); ++var22) {
                  if (var21 == 100.0F) {
                     var20 += this.utilNombre.myRoundDevise(((BulletinLigne)var8.get(var22)).getBulligValColE(), this.structureLog.getStrdevise());
                  } else if (var21 == -100.0F) {
                     var20 -= this.utilNombre.myRoundDevise(((BulletinLigne)var8.get(var22)).getBulligValColE(), this.structureLog.getStrdevise());
                  } else {
                     var20 += this.utilNombre.myRoundDevise(((BulletinLigne)var8.get(var22)).getBulligValColE() * (double)var21 / 100.0D, this.structureLog.getStrdevise());
                  }
               }
            }
         }
      }

      this.valeur = var20 + var3;
      this.base_conges = this.valeur;
   }

   public double M000150(Session var1) throws HibernateException, NamingException {
      boolean var2 = true;
      boolean var3 = true;
      if (this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && this.salariesElements.getSaleleNature().equals("04")) {
         var3 = true;
      }

      this.valeur = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      double var10 = 0.0D;
      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = 0.0D;
      double var18 = 0.0D;
      double var20 = 0.0D;
      double var22 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
         var4 = this.calculBrutEnCours(var1);
         var6 = this.calculLicenciementEnCours(var1);
         var8 = this.calculRubriqueEnCours("109500", "109559", var1);
         if (var8 >= 4000000.0D) {
            var8 = 4000000.0D;
         }

         var10 = this.calculRubriqueEnCours("109560", "109599", var1);
         var12 = this.calculAvnEnCours(var1);
         var14 = this.calculIndCompEnCours(var1);
         if (var12 != 0.0D && var14 != 0.0D) {
            if (var12 > var14) {
               ;
            }
         } else if (var12 == 0.0D) {
            if (var14 != 0.0D) {
               ;
            }
         }

         var16 = var12;
         var18 = this.calculRubriqueEnCours("300000", var1) * -1.0D;
         var20 = this.calculRubriqueEnCours("300020", var1) * -1.0D;
      } else if (this.modeRegularisation == 2) {
         var4 = this.calculBrutEnCours(var1);
         var6 = this.calculLicenciementEnCours(var1);
         var8 = this.calculRubriqueEnCours("109500", "109559", var1);
         if (var8 >= 4000000.0D) {
            var8 = 4000000.0D;
         }

         var10 = this.calculRubriqueEnCours("109560", "109599", var1);
         var12 = this.calculAvnEnCours(var1);
         var14 = this.calculIndCompEnCours(var1);
         if (var12 != 0.0D && var14 != 0.0D) {
            if (var12 > var14) {
               ;
            }
         } else if (var12 == 0.0D) {
            if (var14 != 0.0D) {
               ;
            }
         }

         var16 = var12;
         var18 = this.calculRubriqueEnCours("300000", var1) * -1.0D;
         var20 = this.calculRubriqueEnCours("300020", var1) * -1.0D;
      } else {
         int var24 = (int)this.calculNbMoisPresence();
         var4 = this.calculBrutTotal(var1);
         var6 = this.calculLicenciementTotal(var1);
         var8 = this.calculRubriqueTotal("109500", "109559", var1);
         if (var8 >= 4000000.0D) {
            var8 = 4000000.0D;
         }

         var10 = this.calculRubriqueTotal("109560", "109599", var1);
         var12 = this.calculIndCompTotal(var1);
         var14 = this.calculIndCompTotal(var1);
         if (var12 != 0.0D && var14 != 0.0D) {
            if (var12 > var14) {
               ;
            }
         } else if (var12 == 0.0D) {
            if (var14 != 0.0D) {
               ;
            }
         }

         var16 = var12;
         var18 = this.calculRubriqueTotal("300000", var1) * -1.0D;
         var20 = this.calculRubriqueTotal("300020", var1) * -1.0D;
      }

      var22 = var4 - var6 - var8 - var10 + var16 - var18 - var20;
      this.valeur = var22;
      return this.valeur;
   }

   public double M000151(Session var1) throws HibernateException, NamingException {
      int var2 = 1;
      short var3 = 1;
      if (this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && this.salariesElements.getSaleleNature().equals("04")) {
         var3 = 360;
      }

      this.valeur = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      double var10 = 0.0D;
      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = 0.0D;
      double var18 = 0.0D;
      double var20 = 0.0D;
      double var22 = 0.0D;
      double var24 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
         var4 = this.calculBrutEnCours(var1);
         var6 = this.calculLicenciementEnCours(var1);
         var8 = this.calculRubriqueEnCours("109500", "109559", var1);
         if (var8 >= 4000000.0D) {
            var8 = 4000000.0D;
         }

         var10 = this.calculRubriqueEnCours("109560", "109599", var1);
         var12 = this.calculAvnEnCours(var1);
         var14 = this.calculIndCompEnCours(var1);
         if (var12 != 0.0D && var14 != 0.0D) {
            if (var12 > var14) {
               ;
            }
         } else if (var12 == 0.0D) {
            if (var14 != 0.0D) {
               ;
            }
         }

         var16 = var12;
         var18 = this.calculRubriqueEnCours("300000", var1) * -1.0D;
         var20 = this.calculRubriqueEnCours("300020", var1) * -1.0D;
         var22 = this.calculRubriqueEnCours("300100", var1) * -1.0D;
      } else if (this.modeRegularisation == 2) {
         var4 = this.calculBrutEnCours(var1);
         var6 = this.calculLicenciementEnCours(var1);
         var8 = this.calculRubriqueEnCours("109500", "109559", var1);
         if (var8 >= 4000000.0D) {
            var8 = 4000000.0D;
         }

         var10 = this.calculRubriqueEnCours("109560", "109599", var1);
         var12 = this.calculAvnEnCours(var1);
         var14 = this.calculIndCompEnCours(var1);
         if (var12 != 0.0D && var14 != 0.0D) {
            if (var12 > var14) {
               ;
            }
         } else if (var12 == 0.0D) {
            if (var14 != 0.0D) {
               ;
            }
         }

         var16 = var12;
         var18 = this.calculRubriqueEnCours("300000", var1) * -1.0D;
         var20 = this.calculRubriqueEnCours("300020", var1) * -1.0D;
         var22 = this.calculRubriqueEnCours("300100", var1) * -1.0D;
      } else {
         var2 = (int)this.calculNbMoisPresence();
         var4 = this.calculBrutTotal(var1);
         var6 = this.calculLicenciementTotal(var1);
         var8 = this.calculRubriqueTotal("109500", "109559", var1);
         if (var8 >= 4000000.0D) {
            var8 = 4000000.0D;
         }

         var10 = this.calculRubriqueTotal("109560", "109599", var1);
         var12 = this.calculAvnTotal(var1);
         var14 = this.calculIndCompTotal(var1);
         if (var12 != 0.0D && var14 != 0.0D) {
            if (var12 > var14) {
               ;
            }
         } else if (var12 == 0.0D) {
            if (var14 != 0.0D) {
               ;
            }
         }

         var16 = var12;
         var18 = this.calculRubriqueTotal("300000", var1) * -1.0D;
         var20 = this.calculRubriqueTotal("300020", var1) * -1.0D;
         var22 = this.calculRubriqueTotal("300100", var1) * -1.0D;
      }

      var24 = var4 - var6 - var8 - var10 + var16 - var18 - var20 - var22;
      if (var24 >= 4166666.66D / (double)var3 * (double)var2) {
         var24 -= 833333.33D / (double)var3 * (double)var2;
      } else {
         var24 *= 0.8D;
      }

      if (this.salariesElements.getSaleleNbPartFiscal() == 0.0F) {
         this.salariesElements.setSaleleNbPartFiscal(1.0F);
      }

      this.valeur = var24 / (double)this.salariesElements.getSaleleNbPartFiscal();
      return this.valeur;
   }

   public void M000152(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      if (this.salariesContrats.getSalconConvention() != null && !this.salariesContrats.getSalconConvention().isEmpty()) {
         LectureConventions var4 = new LectureConventions();
         var4.setStrId(this.structureLog.getStrid());
         var4.setStructureLog(this.structureLog);
         new ArrayList();
         var4.recuperePaye();
         List var5 = var4.getMesConventions();
         if (var5.size() != 0) {
            new ObjetConvention();

            for(int var7 = 0; var7 < var5.size(); ++var7) {
               ObjetConvention var6 = (ObjetConvention)var5.get(var7);
               if (var6.getCode() != null && !var6.getCode().isEmpty() && var6.getCode().equals(this.salariesContrats.getSalconConvention())) {
                  var2 = (double)var6.getAt();
                  break;
               }
            }
         }
      }

      this.valeur = var2;
   }

   public void M000153() {
      float var1 = 0.0F;
      if (this.lesAbsences.size() != 0) {
         for(int var2 = 0; var2 < this.lesAbsences.size(); ++var2) {
            if (((SalariesConges)this.lesAbsences.get(var2)).getSalcngType() == 1 && ((SalariesConges)this.lesAbsences.get(var2)).getSalcngNature() == 16) {
               var1 += ((SalariesConges)this.lesAbsences.get(var2)).getSalcngDuree() - ((SalariesConges)this.lesAbsences.get(var2)).getSalcngNbJoursExclus();
            }
         }
      }

      this.absenceSurReposMaladie = var1;
      this.valeur = (double)this.absenceSurReposMaladie;
   }

   public void M000154() {
      this.valeur = this.salariesContrats.getSalconIndemniteDiverse();
   }

   public void M000155() {
      this.valeur = this.bulletinMois.getBulmenNbHeureRelle();
      if (this.valeur == 0.0D) {
         this.valeur = this.M000158();
      }

   }

   public void M000156() {
      this.valeur = this.salariesContrats.getSalconIndemniteResponsabilite();
   }

   public void M000157() {
      this.valeur = this.salariesContrats.getSalconIndemniteNourriture();
   }

   public double M000158() {
      double var1 = 0.0D;
      if (this.salariesElements.getSaleleConvention() != null && !this.salariesElements.getSaleleConvention().isEmpty()) {
         new ArrayList();
         LectureConventions var4 = new LectureConventions();
         var4.setStrId(this.structureLog.getStrid());
         var4.setStructureLog(this.structureLog);
         var4.recuperePaye();
         List var3 = var4.getMesConventionsUtils();
         if (var3.size() != 0) {
            for(int var5 = 0; var5 < var3.size(); ++var5) {
               if (this.salariesContrats != null) {
                  if (((ObjetConvention)var3.get(var5)).getCode().equals(this.salariesContrats.getSalconConvention())) {
                     this.valeur = (double)((ObjetConvention)var3.get(var5)).getHeure_mois();
                     break;
                  }
               } else if (((ObjetConvention)var3.get(var5)).getCode().equals(this.salaries.getSalConvention())) {
                  this.valeur = (double)((ObjetConvention)var3.get(var5)).getHeure_mois();
                  break;
               }
            }
         } else {
            this.valeur = 0.0D;
         }
      } else {
         this.valeur = 0.0D;
      }

      var1 = this.valeur;
      return var1;
   }

   public void M000159(Session var1) {
      if (this.montantAtteindre == 0.0D) {
         boolean var2 = false;
         if (this.optionPaye.getArrondiNet().equals("0")) {
            if (this.salariesElements.getSaleleModeReglement() == 0) {
               var2 = true;
            }
         } else if (this.optionPaye.getArrondiNet().equals("1")) {
            if (this.salariesElements.getSaleleModeReglement() == 0 || this.salariesElements.getSaleleModeReglement() == 1) {
               var2 = true;
            }
         } else if (this.optionPaye.getArrondiNet().equals("2")) {
            if (this.salariesElements.getSaleleModeReglement() == 0 || this.salariesElements.getSaleleModeReglement() == 1 || this.salariesElements.getSaleleModeReglement() == 3 || this.salariesElements.getSaleleModeReglement() == 4 || this.salariesElements.getSaleleModeReglement() == 5) {
               var2 = true;
            }
         } else if (this.optionPaye.getArrondiNet().equals("3") && this.salariesElements.getSaleleModeReglement() >= 0 && this.salariesElements.getSaleleModeReglement() <= 5) {
            var2 = true;
         }

         if (var2) {
            double var3 = 0.0D;
            new BulletinLigne();

            for(int var6 = 0; var6 < this.lesBulletinsLigne.size(); ++var6) {
               BulletinLigne var5 = (BulletinLigne)this.lesBulletinsLigne.get(var6);
               if (var5.getBulligNature() == 69 || var5.getBulligNature() == 70 || var5.getBulligNature() == 80 || var5.getBulligNature() == 88) {
                  var3 += var5.getBulligValColE();
               }
            }

            if (var3 >= 0.0D) {
               var3 = this.utilNombre.myRoundDevise(var3, this.structureLog.getStrdevise());
               byte var14 = 5;
               double var7 = var3 / (double)var14;
               if (var7 != 0.0D) {
                  String var9 = "" + var7;
                  int var10 = Integer.parseInt(var9.substring(var9.indexOf(".") + 1));
                  if (var10 != 0) {
                     var9 = "" + (var7 + 1.0D);
                     String var11 = var9.substring(0, var9.indexOf("."));
                     double var12 = Double.parseDouble(var11);
                     this.valeur = this.utilNombre.myRoundDevise(var12 * (double)var14 - var3, this.structureLog.getStrdevise());
                  } else {
                     this.valeur = 0.0D;
                  }
               } else {
                  this.valeur = 0.0D;
               }
            } else {
               this.valeur = 0.0D;
            }
         } else {
            this.valeur = 0.0D;
         }
      } else {
         this.valeur = 0.0D;
      }

   }

   public void M000160(Session var1) {
      this.valeur = this.optionPaye.getSecuriteSocialeGene();
   }

   public void M000161(Session var1) throws HibernateException, NamingException {
      if (this.bulletinLigne.getBulligValColA() == 0.0D) {
         this.bulletinLigne.setBulligValColA(this.M000162(var1));
      }

      if (this.bulletinLigne.getBulligValColA() >= this.optionPaye.getSecuriteSocialeGene()) {
         this.valeur = this.optionPaye.getSecuriteSocialeGene();
      } else {
         this.valeur = this.bulletinLigne.getBulligValColA();
      }

   }

   public double M000162(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      double var4 = this.calculAvnEnCours(var1);
      this.valeur = var2 + var4;
      return this.valeur;
   }

   public void M000163(Session var1) {
      this.valeur = this.optionPaye.getTauxcnssPS();
   }

   public void M000164(Session var1) throws ParseException, HibernateException, NamingException {
      this.valeur = 0.0D;
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
         var2 = this.calculBrutEnCours(var1);
         var6 = this.optionPaye.getSecuriteSocialeGene() * this.optionPaye.getTauxcnssPS() / 100.0D;
      } else if (this.modeRegularisation == 2) {
         var2 = this.calculBrutEnCours(var1);
         var6 = this.optionPaye.getSecuriteSocialeGene() * this.optionPaye.getTauxcnssPS() / 100.0D;
      } else {
         var2 = this.calculBrutTotal(var1);
         var4 = this.calculRubriqueTotal("300000", var1) * -1.0D;
         var6 = this.optionPaye.getSecuriteSocialeGene() * this.optionPaye.getTauxcnssPS() / 100.0D * (double)this.calculNbMoisPresence();
      }

      var2 = var2 * this.optionPaye.getTauxcnssPS() / 100.0D;
      this.valeur = var2 - var4;
      if (this.valeur > var6) {
         this.valeur = var6;
      }

      this.valeur = this.calculARR(this.valeur);
   }

   public void M000165(Session var1) {
      this.valeur = this.optionPaye.getTauxcnssPP();
   }

   public void M000166(Session var1) throws HibernateException, NamingException, ParseException {
      this.valeur = 0.0D;
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
         var2 = this.calculBrutEnCours(var1);
         var6 = this.optionPaye.getSecuriteSocialeGene() * this.optionPaye.getTauxcnssPP() / 100.0D;
      } else if (this.modeRegularisation == 2) {
         var2 = this.calculBrutEnCours(var1);
         var6 = this.optionPaye.getSecuriteSocialeGene() * this.optionPaye.getTauxcnssPP() / 100.0D;
      } else {
         var2 = this.calculBrutTotal(var1);
         var4 = this.calculRubriqueTotal("900000", var1) * -1.0D;
         var6 = this.optionPaye.getSecuriteSocialeGene() * this.optionPaye.getTauxcnssPP() / 100.0D * (double)this.calculNbMoisPresence();
      }

      var2 = var2 * this.optionPaye.getTauxcnssPP() / 100.0D;
      this.valeur = var2 - var4;
      if (this.valeur > var6) {
         this.valeur = var6;
      }

      this.valeur = this.calculARR(this.valeur);
   }

   public double M000167(Session var1) throws HibernateException, NamingException {
      boolean var2 = true;
      boolean var3 = true;
      if (this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && this.salariesElements.getSaleleNature().equals("04")) {
         var3 = true;
      }

      this.valeur = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      double var10 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
         var4 = this.calculBrutEnCours(var1);
         var6 = this.calculAvnEnCours(var1);
         var8 = this.calculRubriqueEnCours("300000", var1) * -1.0D;
      } else if (this.modeRegularisation == 2) {
         var4 = this.calculBrutEnCours(var1);
         var6 = this.calculAvnEnCours(var1);
         var8 = this.calculRubriqueEnCours("300000", var1) * -1.0D;
      } else {
         int var12 = (int)this.calculNbMoisPresence();
         var4 = this.calculBrutTotal(var1);
         var6 = this.calculAvnTotal(var1);
         var8 = this.calculRubriqueTotal("300000", var1) * -1.0D;
      }

      var10 = (var4 + var6 - var8) * 0.8D;
      if (this.salariesElements.getSaleleNbPartFiscal() == 0.0F) {
         this.salariesElements.setSaleleNbPartFiscal(1.0F);
      }

      this.valeur = var10 / (double)this.salariesElements.getSaleleNbPartFiscal();
      return this.valeur;
   }

   public void M000168(Session var1) throws HibernateException, NamingException {
      int var2 = 1;
      short var3 = 1;
      if (this.salariesElements.getSaleleNature() != null && !this.salariesElements.getSaleleNature().isEmpty() && this.salariesElements.getSaleleNature().equals("04")) {
         var3 = 360;
      }

      this.valeur = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      if (this.bulletinLigne.getBulligValColA() == 0.0D) {
         var6 = this.M000167(var1);
         this.valeur = 0.0D;
      } else {
         var6 = this.bulletinLigne.getBulligValColA();
      }

      if ((this.salariesElements.getSaleleEtat() > 1 || this.dateGeneration.getMonth() + 1 == 12 || this.modeRegularisation != 0) && this.modeRegularisation != 2) {
         var2 = (int)this.calculNbMoisPresence();
         var4 = this.calculRubriqueTotal("300200", var1) * -1.0D;
      }

      double var8 = 0.0D;
      double var10 = 0.0D;
      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = 0.0D;
      if (var6 >= (double)(0 / var3 * var2) && var6 <= (double)('霊' / var3 * var2)) {
         var8 = (var6 - (double)(0 / var3 * var2)) * 0.01D;
      } else if (var6 >= (double)('霋' / var3 * var2) && var6 <= (double)(83333 / var3 * var2)) {
         var8 = (double)('霋' / var3 * var2) * 0.01D;
         var10 = (var6 - (double)('霋' / var3 * var2)) * 0.1D;
      } else if (var6 >= (double)(83334 / var3 * var2) && var6 <= (double)(250000 / var3 * var2)) {
         var8 = (double)('霋' / var3 * var2) * 0.01D;
         var10 = (double)(83334 / var3 * var2 - '霋' / var3 * var2) * 0.1D;
         var12 = (var6 - (double)(83334 / var3 * var2)) * 0.25D;
      } else if (var6 >= (double)(250001 / var3 * var2) && var6 <= (double)(666666 / var3 * var2)) {
         var8 = (double)('霋' / var3 * var2) * 0.01D;
         var10 = (double)(83334 / var3 * var2 - '霋' / var3 * var2) * 0.1D;
         var12 = (double)(250001 / var3 * var2 - 83334 / var3 * var2) * 0.25D;
         var14 = (var6 - (double)(250001 / var3 * var2)) * 0.4D;
      } else if (var6 >= (double)(666667 / var3 * var2)) {
         var8 = (double)('霋' / var3 * var2) * 0.01D;
         var10 = (double)(83334 / var3 * var2 - '霋' / var3 * var2) * 0.1D;
         var12 = (double)(250001 / var3 * var2 - 83334 / var3 * var2) * 0.25D;
         var14 = (double)(666666 / var3 * var2 - 250001 / var3 * var2) * 0.4D;
         var16 = (var6 - (double)(666667 / var3 * var2)) * 0.45D;
      }

      this.valeur = (var8 + var10 + var12 + var14 + var16) * (double)this.salariesElements.getSaleleNbPartFiscal() - var4;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000179(Session var1) throws HibernateException, NamingException, ParseException {
      this.valeur = 0.0D;
      double var2 = 0.0D;
      if (this.bulletinLigne.getBulligValColE() == 0.0D) {
         for(int var4 = 0; var4 < this.lesBulletinsLigne.size(); ++var4) {
            if (((BulletinLigne)this.lesBulletinsLigne.get(var4)).getBulligRubrique().equals("100000") || ((BulletinLigne)this.lesBulletinsLigne.get(var4)).getBulligRubrique().equals("100010")) {
               var2 += ((BulletinLigne)this.lesBulletinsLigne.get(var4)).getBulligValColE();
            }
         }
      } else {
         var2 = this.bulletinLigne.getBulligValColE();
      }

      if (this.dateGeneration.compareTo(this.utilDate.stringToDateSQLLight("2018-06-01")) >= 0) {
         if (var2 > 2000.0D && var2 <= 2535.0D) {
            this.valeur = ((var2 - 2000.0D) / 5.0D + 1.0D) * 0.25D;
         } else if (var2 > 2535.01D && var2 <= 3670.0D) {
            this.valeur = (var2 - 2535.0D) / 5.0D * 0.5D + 42.33D;
         } else if (var2 > 3670.01D && var2 <= 4505.0D) {
            this.valeur = (var2 - 3670.0D) / 5.0D * 0.75D + 126.25D;
         } else if (var2 > 4505.01D && var2 <= 5335.0D) {
            this.valeur = (var2 - 4505.0D) / 5.0D * 1.0D + 252.0D;
         } else if (var2 > 5335.01D && var2 <= 20000.0D) {
            this.valeur = (var2 - 5335.0D) / 5.0D * 1.25D + 418.33D;
         } else if (var2 > 20000.01D) {
            this.valeur = (var2 - 20000.0D) * 0.25D + 4083.33D;
         }
      } else if (var2 > 1500.0D && var2 <= 2330.0D) {
         this.valeur = ((var2 - 1500.0D) / 5.0D + 1.0D) * 0.25D;
      } else if (var2 > 2330.01D && var2 <= 3165.0D) {
         this.valeur = (var2 - 2330.0D) / 5.0D * 0.5D + 41.83D;
      } else if (var2 > 3165.01D && var2 <= 3995.0D) {
         this.valeur = (var2 - 3170.0D) / 5.0D * 0.75D + 126.25D;
      } else if (var2 > 3995.01D && var2 <= 4830.0D) {
         this.valeur = (var2 - 4000.0D) / 5.0D * 1.0D + 251.0D;
      } else if (var2 > 4830.01D) {
         this.valeur = (var2 - 4830.0D) / 5.0D * 1.5D + 417.17D;
      }

      this.valeur = this.calculARR(this.valeur);
   }

   public void M000180(Session var1) throws HibernateException, NamingException, ParseException {
      this.valeur = 0.0D;
      double var2 = 0.0D;
      if (this.bulletinLigne.getBulligValColE() == 0.0D) {
         for(int var4 = 0; var4 < this.lesBulletinsLigne.size(); ++var4) {
            if (((BulletinLigne)this.lesBulletinsLigne.get(var4)).getBulligRubrique().equals("100000") || ((BulletinLigne)this.lesBulletinsLigne.get(var4)).getBulligRubrique().equals("100010")) {
               var2 += ((BulletinLigne)this.lesBulletinsLigne.get(var4)).getBulligValColE();
            }
         }
      } else {
         var2 = this.bulletinLigne.getBulligValColE();
      }

      var2 -= 12500.0D;
      if (var2 > 0.0D) {
         this.valeur = var2 * 0.3D;
      }

      this.valeur = this.calculARR(this.valeur);
   }

   public void M000181(Session var1) {
      this.valeur = this.optionPaye.getTauxcnssPS();
   }

   public void M000182(Session var1) throws HibernateException, NamingException {
      this.valeur = this.bulletinLigne.getBulligValColB() * this.bulletinLigne.getBulligValColC() / 100.0D;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000183(Session var1) throws HibernateException, NamingException {
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      var2 = this.calculBrutEnCours(var1);
      var4 = this.calculAvnEnCours(var1);
      var6 = var2 + var4;
      if (var6 <= 50000.0D) {
         this.valeur = 0.0D;
      } else if (var6 >= 50001.0D && var6 <= 130000.0D) {
         this.valeur = (this.valeur - 50000.0D) * 0.1D;
      } else if (var6 >= 130001.0D && var6 <= 280000.0D) {
         this.valeur = (this.valeur - 130000.0D) * 0.15D + 8000.0D;
      } else if (var6 >= 280001.0D && var6 <= 530000.0D) {
         this.valeur = (this.valeur - 280000.0D) * 0.2D + 8000.0D + 22500.0D;
      } else if (var6 >= 530001.0D) {
         this.valeur = (this.valeur - 530000.0D) * 0.35D + 8000.0D + 22500.0D + 50000.0D;
      }

      if (this.salariesElements.getSaleleChefFamille() == 1 && this.salariesElements.getSaleleNbEnfant() > 1) {
         if (this.salariesElements.getSaleleNbEnfant() == 2) {
            this.valeur -= this.valeur * 0.05D;
         } else if (this.salariesElements.getSaleleNbEnfant() == 3) {
            this.valeur -= this.valeur * 0.1D;
         } else if (this.salariesElements.getSaleleNbEnfant() == 4) {
            this.valeur -= this.valeur * 0.15D;
         } else if (this.salariesElements.getSaleleNbEnfant() == 5) {
            this.valeur -= this.valeur * 0.2D;
         } else if (this.salariesElements.getSaleleNbEnfant() >= 6) {
            this.valeur -= this.valeur * 0.23D;
         }
      }

      this.valeur = this.calculARR(this.valeur);
   }

   public void M000184(Session var1) {
      this.valeur = this.optionPaye.getTauxipressCadrePP();
   }

   public void M000185(Session var1) throws HibernateException, NamingException {
      this.valeur = this.bulletinLigne.getBulligValColB() * this.bulletinLigne.getBulligValColC() / 100.0D;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000186(Session var1) {
      this.valeur = this.optionPaye.getTauxipressGenePP();
   }

   public void M000187(Session var1) throws HibernateException, NamingException {
      this.valeur = this.bulletinLigne.getBulligValColB() * this.bulletinLigne.getBulligValColC() / 100.0D;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000188(Session var1) {
      this.valeur = this.optionPaye.getTauxcfcePP();
   }

   public void M000189(Session var1) throws HibernateException, NamingException {
      this.valeur = this.bulletinLigne.getBulligValColB() * this.bulletinLigne.getBulligValColC() / 100.0D;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000190(Session var1) {
      this.valeur = this.optionPaye.getTauxcnssPS();
   }

   public void M000191(Session var1) throws HibernateException, NamingException {
      this.valeur = this.bulletinLigne.getBulligValColB() * this.bulletinLigne.getBulligValColC() / 100.0D;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000192(Session var1) {
      this.valeur = this.optionPaye.getTauxcnssPS();
   }

   public void M000193(Session var1) throws HibernateException, NamingException {
      this.valeur = this.bulletinLigne.getBulligValColB() * this.bulletinLigne.getBulligValColC() / 100.0D;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000194(Session var1) throws HibernateException, NamingException {
      int var2 = 1;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = 0.0D;
      if (this.salariesElements.getSaleleEtat() <= 1 && this.dateGeneration.getMonth() + 1 != 12 && this.modeRegularisation == 0) {
         var3 = this.calculBrutEnCours(var1);
         var5 = this.calculAvnEnCours(var1);
         var9 = (var3 + var5) * 12.0D;
      } else if (this.modeRegularisation == 2) {
         var3 = this.calculBrutEnCours(var1);
         var5 = this.calculAvnEnCours(var1);
         var9 = (var3 + var5) * 12.0D;
      } else {
         var2 = (int)this.calculNbMoisPresence();
         var3 = this.calculBrutTotal(var1);
         var5 = this.calculAvnTotal(var1);
         var7 = this.calculRubriqueTotal("300200", var1) * -1.0D;
         var9 = var3 + var5;
      }

      double var13 = 0.0D;
      if (var9 <= (double)(75000 * var2)) {
         var13 = 0.0D;
      } else if (var9 >= (double)(75001 * var2) && var9 <= 333333.333D * (double)var2) {
         var13 = (var9 - (double)(75000 * var2)) * 0.07D;
      } else if (var9 >= (double)(333334 * var2) && var9 <= (double)(500000 * var2)) {
         var13 = var9 - 333333.333D * (double)var2 * 0.15D + (double)(18083 * var2);
      } else if (var9 >= (double)(500001 * var2) && var9 <= 833333.333D * (double)var2) {
         var13 = (var9 - (double)(500000 * var2)) * 0.25D + (double)('ꡋ' * var2);
      } else if (var9 >= (double)(833334 * var2) && var9 <= (double)(1250000 * var2)) {
         var13 = (var9 - 833333.333D * (double)var2) * 0.3D + (double)(126417 * var2);
      } else if (var9 >= (double)(1250001 * var2)) {
         var13 = (var9 - (double)(1250000 * var2)) * 0.35D + (double)(251417 * var2);
      }

      double var15 = 0.0D;

      for(int var17 = 0; var17 < this.lesBulletinsLigne.size(); ++var17) {
         if (((BulletinLigne)this.lesBulletinsLigne.get(var17)).getBulligRubrique().equals("299999")) {
            var15 = ((BulletinLigne)this.lesBulletinsLigne.get(var17)).getBulligValColE();
            break;
         }
      }

      double var20 = 0.0D;
      if (var15 > 833333.0D) {
         byte var19 = 0;
         if (this.salariesElements.getSaleleSitFamille() != 1 && this.salariesElements.getSaleleSitFamille() != 2 && this.salariesElements.getSaleleSitFamille() == 3) {
         }

         int var21 = var19 + this.salariesElements.getSaleleNbEnfant();
         var20 = (double)(72000 * var21);
         if (var20 > 432000.0D) {
            var20 = 432000.0D;
         }
      }

      var13 -= var20 / (double)var2;
      var13 -= var7;
      this.valeur = this.calculARR(var13);
   }

   public void M000195(Session var1) {
      this.valeur = Double.parseDouble(this.optionPaye.getPlafond());
   }

   public void M000196(Session var1) throws HibernateException, NamingException {
      if (this.bulletinLigne.getBulligValColB() <= this.bulletinLigne.getBulligValColC()) {
         this.valeur = 250.0D;
      } else {
         this.valeur = 125.0D;
      }

      this.valeur = this.calculARR(this.valeur);
   }

   public void M000197(Session var1) {
      this.valeur = this.optionPaye.getTauxipressCadrePP();
   }

   public void M000198(Session var1) throws HibernateException, NamingException {
      this.valeur = this.bulletinLigne.getBulligValColB() * this.bulletinLigne.getBulligValColC() / 100.0D;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000199(Session var1) {
      this.valeur = this.optionPaye.getTauxipressGenePP();
   }

   public void M000200(Session var1) throws HibernateException, NamingException {
      this.valeur = this.bulletinLigne.getBulligValColB() * this.bulletinLigne.getBulligValColC() / 100.0D;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000201(Session var1) {
      this.valeur = this.optionPaye.getTauxcfcePP();
   }

   public void M000202(Session var1) throws HibernateException, NamingException {
      this.valeur = this.bulletinLigne.getBulligValColB() * this.bulletinLigne.getBulligValColC() / 100.0D;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000203(Session var1) {
      this.valeur = this.optionPaye.getTauxcfpPP();
   }

   public void M000204(Session var1) throws HibernateException, NamingException {
      this.valeur = this.bulletinLigne.getBulligValColB() * this.bulletinLigne.getBulligValColC() / 100.0D;
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000205(Session var1) {
      this.valeur = this.optionPaye.getSecuriteSocialeGene();
   }

   public void M000206(Session var1) {
      this.valeur = this.optionPaye.getTauxcnssPS();
   }

   public void M000207(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      if (var2 >= this.optionPaye.getSecuriteSocialeGene()) {
         var2 = this.optionPaye.getSecuriteSocialeGene();
      }

      double var4 = 0.0D;
      if (this.bulletinLigne.getBulligValColC() != 0.0D) {
         var4 = this.bulletinLigne.getBulligValColC() / 100.0D;
      }

      this.valeur = this.utilNombre.myRoundDevise(var2 * var4, this.structureLog.getStrdevise());
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000208(Session var1) {
      this.valeur = this.optionPaye.getTauxcnamgsPS();
   }

   public void M000209(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      if (var2 >= this.optionPaye.getSecuriteSocialeGene()) {
         var2 = this.optionPaye.getSecuriteSocialeGene();
      }

      double var4 = 0.0D;
      if (this.bulletinLigne.getBulligValColC() != 0.0D) {
         var4 = this.bulletinLigne.getBulligValColC() / 100.0D;
      }

      this.valeur = this.utilNombre.myRoundDevise(var2 * var4, this.structureLog.getStrdevise());
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000210(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      double var4 = this.M000222(var1);
      if (var4 <= 1200000.0D) {
         var2 -= var4;
      }

      if (var2 <= 1000000.0D) {
         this.valeur = 0.0D;
      } else if (var2 >= 1000001.0D && var2 <= 5000000.0D) {
         this.valeur = this.utilNombre.myRoundDevise(var2 * 0.05D, this.structureLog.getStrdevise());
      } else if (var2 >= 5000001.0D && var2 <= 1.0E7D) {
         this.valeur = this.utilNombre.myRoundDevise(var2 * 0.1D, this.structureLog.getStrdevise());
      } else if (var2 >= 1.0000001E7D && var2 <= 2.0E7D) {
         this.valeur = this.utilNombre.myRoundDevise(var2 * 0.15D, this.structureLog.getStrdevise());
      } else if (var2 >= 2.0000001E7D) {
         this.valeur = this.utilNombre.myRoundDevise(var2 * 0.2D, this.structureLog.getStrdevise());
      }

      this.valeur = this.calculARR(this.valeur);
   }

   public void M000211(Session var1) {
      this.valeur = this.optionPaye.getTauxcnssPP();
   }

   public void M000212(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      if (var2 >= this.optionPaye.getSecuriteSocialeGene()) {
         var2 = this.optionPaye.getSecuriteSocialeGene();
      }

      double var4 = 0.0D;
      if (this.bulletinLigne.getBulligValColC() != 0.0D) {
         var4 = this.bulletinLigne.getBulligValColC() / 100.0D;
      }

      this.valeur = this.utilNombre.myRoundDevise(var2 * var4, this.structureLog.getStrdevise());
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000213(Session var1) {
      this.valeur = this.optionPaye.getTauxcnamgsPP();
   }

   public void M000214(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      if (var2 >= this.optionPaye.getSecuriteSocialeGene()) {
         var2 = this.optionPaye.getSecuriteSocialeGene();
      }

      double var4 = 0.0D;
      if (this.bulletinLigne.getBulligValColC() != 0.0D) {
         var4 = this.bulletinLigne.getBulligValColC() / 100.0D;
      }

      this.valeur = this.utilNombre.myRoundDevise(var2 * var4, this.structureLog.getStrdevise());
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000215(Session var1) {
      this.valeur = this.optionPaye.getTauxAt();
   }

   public void M000216(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      if (var2 >= this.optionPaye.getSecuriteSocialeGene()) {
         var2 = this.optionPaye.getSecuriteSocialeGene();
      }

      double var4 = 0.0D;
      if (this.bulletinLigne.getBulligValColC() != 0.0D) {
         var4 = this.bulletinLigne.getBulligValColC() / 100.0D;
      }

      this.valeur = this.utilNombre.myRoundDevise(var2 * var4, this.structureLog.getStrdevise());
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000217(Session var1) {
      this.valeur = this.optionPaye.getTauxPf();
   }

   public void M000218(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      if (var2 >= this.optionPaye.getSecuriteSocialeGene()) {
         var2 = this.optionPaye.getSecuriteSocialeGene();
      }

      double var4 = 0.0D;
      if (this.bulletinLigne.getBulligValColC() != 0.0D) {
         var4 = this.bulletinLigne.getBulligValColC() / 100.0D;
      }

      this.valeur = this.utilNombre.myRoundDevise(var2 * var4, this.structureLog.getStrdevise());
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000219(Session var1) {
      this.valeur = this.optionPaye.getTauxVf();
   }

   public void M000220(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      double var4 = this.calculAvnEnCours(var1);
      double var6 = this.M000222(var1);
      if (var6 <= 1200000.0D) {
         var2 -= var6;
      }

      double var8 = 0.0D;
      if (this.bulletinLigne.getBulligValColC() != 0.0D) {
         var8 = this.bulletinLigne.getBulligValColC() / 100.0D;
      }

      this.valeur = this.utilNombre.myRoundDevise((var2 + var4) * var8, this.structureLog.getStrdevise());
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000221(Session var1) {
      this.valeur = this.optionPaye.getTauxTa();
   }

   public double M000222(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      double var4 = this.calculAvnEnCours(var1);
      double var6 = 0.0D;
      if (this.bulletinLigne.getBulligValColC() != 0.0D) {
         var6 = this.bulletinLigne.getBulligValColC() / 100.0D;
      }

      this.valeur = this.utilNombre.myRoundDevise((var2 + var4) * var6, this.structureLog.getStrdevise());
      this.valeur = this.calculARR(this.valeur);
      return this.valeur;
   }

   public void M000223(Session var1) {
      this.valeur = this.optionPaye.getTauxCfpa();
   }

   public void M000224(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      double var4 = this.calculAvnEnCours(var1);
      double var6 = 0.0D;
      if (this.bulletinLigne.getBulligValColC() != 0.0D) {
         var6 = this.bulletinLigne.getBulligValColC() / 100.0D;
      }

      this.valeur = this.utilNombre.myRoundDevise((var2 + var4) * var6, this.structureLog.getStrdevise());
      this.valeur = this.calculARR(this.valeur);
   }

   public void M000225() {
      this.valeur = this.salariesContrats.getSalconPrimeTransport();
   }

   public void M000226() {
      this.valeur = this.salariesContrats.getSalconPrimeLogement();
   }

   public void M000227() {
      this.valeur = (double)this.salariesContrats.getSalconNbHeureMois();
      if (this.valeur == 0.0D) {
         this.valeur = 173.33D;
      }

   }

   public double M000228(Session var1) {
      this.M000040(var1);
      this.valeur += (double)this.absenceSurReposMaladie;
      return this.valeur;
   }

   public void M000229(Session var1) throws ParseException {
      boolean var2 = false;
      double var3 = 0.0D;
      double var5 = 0.0D;

      for(int var7 = 0; var7 < this.lesBulletinsLigne.size(); ++var7) {
         if (((BulletinLigne)this.lesBulletinsLigne.get(var7)).getBulligRubrique().equals("208000")) {
            if (((BulletinLigne)this.lesBulletinsLigne.get(var7)).getBulligValColE() != 0.0D) {
               var3 = ((BulletinLigne)this.lesBulletinsLigne.get(var7)).getBulligValColB();
               var5 = ((BulletinLigne)this.lesBulletinsLigne.get(var7)).getBulligValColE();
               var2 = true;
            }
            break;
         }
      }

      byte var10 = 0;
      double var8 = this.M000003(var1);
      if (var8 <= 9.0D) {
         var10 = 0;
      } else if (var8 >= 10.0D && var8 <= 14.0D) {
         var10 = 1;
      } else if (var8 >= 15.0D && var8 <= 19.0D) {
         var10 = 2;
      } else if (var8 >= 20.0D && var8 <= 24.0D) {
         var10 = 3;
      } else if (var8 >= 25.0D) {
         var10 = 6;
      }

      if (this.salariesElements.getSaleleNivEmploi() != null && !this.salariesElements.getSaleleNivEmploi().isEmpty() && this.salariesElements.getSaleleNivEmploi().equals("1")) {
         this.valeur = var5 * (double)var10 / 22.0D;
      } else {
         this.valeur = var5 * (double)var10 / 24.0D;
      }

   }

   public void M000230(Session var1) throws ParseException {
      boolean var2 = false;
      double var3 = 0.0D;
      double var5 = 0.0D;

      for(int var7 = 0; var7 < this.lesBulletinsLigne.size(); ++var7) {
         if (((BulletinLigne)this.lesBulletinsLigne.get(var7)).getBulligRubrique().equals("208000")) {
            if (((BulletinLigne)this.lesBulletinsLigne.get(var7)).getBulligValColE() != 0.0D) {
               var3 = ((BulletinLigne)this.lesBulletinsLigne.get(var7)).getBulligValColB();
               var5 = ((BulletinLigne)this.lesBulletinsLigne.get(var7)).getBulligValColE();
               var2 = true;
            }
            break;
         }
      }

      if (this.salariesElements.getSaleleNivEmploi() != null && !this.salariesElements.getSaleleNivEmploi().isEmpty() && this.salariesElements.getSaleleNivEmploi().equals("1")) {
         this.valeur = var5 * 4.0D / 22.0D;
      } else {
         this.valeur = 0.0D;
      }

   }

   public void M000231(Session var1) throws ParseException, HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      double var4 = this.calculRubriqueEnCours("300000", var1);
      double var6 = this.calculRubriqueEnCours("109500", "109559", var1);
      if (var6 >= 4000000.0D) {
         var6 = 4000000.0D;
      }

      double var8 = this.calculRubriqueEnCours("109560", "109699", var1);
      this.valeur = var2 + var4 - var6 - var8;
   }

   public void M000232(Session var1) throws ParseException {
      float var2 = 0.0F;

      for(int var3 = 0; var3 < this.lesAbsences.size(); ++var3) {
         if (((SalariesConges)this.lesAbsences.get(var3)).getSalcngEtat() == 1 && ((SalariesConges)this.lesAbsences.get(var3)).getSalcngNature() == 12) {
            var2 += ((SalariesConges)this.lesAbsences.get(var3)).getSalcngDuree();
         }
      }

      this.valeur = (double)var2;
   }

   public void M000233(Session var1) throws ParseException {
      float var2 = 0.0F;

      for(int var3 = 0; var3 < this.lesAbsences.size(); ++var3) {
         if (((SalariesConges)this.lesAbsences.get(var3)).getSalcngEtat() == 1 && ((SalariesConges)this.lesAbsences.get(var3)).getSalcngNature() == 11) {
            var2 += ((SalariesConges)this.lesAbsences.get(var3)).getSalcngDuree();
         }
      }

      this.valeur = (double)var2;
   }

   public void M000234(Session var1) throws ParseException {
      float var2 = 0.0F;

      for(int var3 = 0; var3 < this.lesAbsences.size(); ++var3) {
         if (((SalariesConges)this.lesAbsences.get(var3)).getSalcngEtat() == 1 && ((SalariesConges)this.lesAbsences.get(var3)).getSalcngNature() == 13) {
            var2 += ((SalariesConges)this.lesAbsences.get(var3)).getSalcngDuree();
         }
      }

      this.valeur = (double)var2;
   }

   public void M000235(Session var1) throws ParseException {
      float var2 = 0.0F;

      for(int var3 = 0; var3 < this.lesAbsences.size(); ++var3) {
         if (((SalariesConges)this.lesAbsences.get(var3)).getSalcngEtat() == 1 && ((SalariesConges)this.lesAbsences.get(var3)).getSalcngNature() == 17) {
            var2 += ((SalariesConges)this.lesAbsences.get(var3)).getSalcngDuree();
         }
      }

      this.valeur = (double)var2;
   }

   public void M000236(Session var1) {
      this.valeur = this.optionPaye.getTauxtusPP();
   }

   public void M000237(Session var1) throws HibernateException, NamingException {
      double var2 = this.calculBrutEnCours(var1);
      double var4 = var2 * this.bulletinLigne.getBulligValColC() / 100.0D;
      this.valeur = this.calculARR(var4);
   }

   public void M000238(Session var1) {
      this.valeur = this.optionPaye.getTaxeTolCv();
   }

   public void M000239(Session var1) {
      this.valeur = this.optionPaye.getTaxeTolPeriph();
   }

   public void M000240(Session var1) {
      this.valeur = this.optionPaye.getSecuriteSocialeCadre();
   }

   public void M000241(Session var1) {
      if (this.salaries.getSalIlot() != null && !this.salaries.getSalIlot().isEmpty()) {
         if (this.salaries.getSalIlot().equals("1")) {
            this.valeur = this.optionPaye.getTaxeTolCv();
         } else {
            this.valeur = this.optionPaye.getTaxeTolPeriph();
         }
      } else {
         this.valeur = 0.0D;
      }

   }

   public void M000242(Session var1) {
      double var2 = 0.0D;
      if (this.bulletinLigne.getBulligValColA() != 0.0D) {
         var2 = this.bulletinLigne.getBulligValColA();
      }

      double var4 = 0.0D;
      if (var2 >= this.bulletinLigne.getBulligValColB()) {
         var4 = this.bulletinLigne.getBulligValColB();
      } else {
         var4 = var2;
      }

      this.valeur = this.utilNombre.myRoundDevise(var4 * this.bulletinLigne.getBulligValColC() / 100.0D, this.structureLog.getStrdevise());
   }

   public void M000243(Session var1) {
      double var2 = 0.0D;
      if (this.bulletinLigne.getBulligValColA() != 0.0D) {
         var2 = this.bulletinLigne.getBulligValColA();
      }

      double var4 = 0.0D;
      if (var2 >= this.bulletinLigne.getBulligValColB()) {
         var4 = this.bulletinLigne.getBulligValColB();
      } else {
         var4 = var2;
      }

      this.valeur = this.utilNombre.myRoundDevise(var4 * this.bulletinLigne.getBulligValColC() / 100.0D, this.structureLog.getStrdevise());
   }

   public void M000244(Session var1) {
      if (this.salariesContrats != null && this.salariesContrats.getSalconType() != null && !this.salariesContrats.getSalconType().isEmpty()) {
         if (!this.salariesContrats.getSalconType().equals("01D") && !this.salariesContrats.getSalconType().equals("01I")) {
            if (this.salariesContrats.getSalconType().equals("02D") || this.salariesContrats.getSalconType().equals("02I")) {
               double var2 = 0.0D;

               for(int var4 = 0; var4 < this.lesBulletinsLigne.size(); ++var4) {
                  if (((BulletinLigne)this.lesBulletinsLigne.get(var4)).getBulligRubrique().equals("100000")) {
                     var2 = ((BulletinLigne)this.lesBulletinsLigne.get(var4)).getBulligValColB();
                     break;
                  }
               }

               if (var2 != 0.0D) {
                  this.valeur = this.utilNombre.myRoundDevise(var2 * this.optionPaye.getEloignementExpat() / 100.0D, this.structureLog.getStrdevise());
               } else {
                  this.valeur = 0.0D;
               }
            }
         } else {
            this.valeur = this.optionPaye.getEloignementLocal();
         }
      } else {
         this.valeur = 0.0D;
      }

   }

   public void M000245(Session var1) {
      this.valeur = this.optionPaye.getTauxPf();
   }

   public void M000246(Session var1) {
      this.valeur = this.optionPaye.getTauxAt();
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
         this.lesGrilles = var2.getMesGrillesSalaires();
      }

   }

   public void rechercheSalarieContrat() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.razSimulation();
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

   public void calculeRubriqueContrat(Session var1) throws HibernateException, NamingException {
      this.var_sursalaire = false;
      this.var_forfaitHeureSup = false;
      this.var_forfaitPrestataire = false;
      this.var_outillage = false;
      this.var_astreinte = false;
      this.var_redement = false;
      this.var_responsbilite = false;
      this.var_fonction = false;
      this.var_sujetion = false;
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
            }
         }
      }

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

   public void initImpressionGene() {
      this.var_choix_modele = 0;
      this.chargerLesModelesImpresion();
      this.affMail = false;
      this.format = "PRT";
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.showModalPanelPrintGene = true;
   }

   public void initImpressionGeneJournalier() {
      this.var_choix_modele = 0;
      this.chargerLesModelesImpresion();
      this.affMail = false;
      this.format = "PRT";
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.showModalPanelPrintGene = true;
   }

   public void closeImpressionGene() {
      this.showModalPanelPrintGene = false;
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
            if (this.feuilleCalcul.getFeuModeleMat() != null && !this.feuilleCalcul.getFeuModeleMat().isEmpty()) {
               this.documentImpressionItems.add(new SelectItem(this.feuilleCalcul.getFeuModeleMat()));
            }
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

         this.lotActif = false;
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
                  if (var5.startsWith("Lot_")) {
                     this.lotActif = true;
                  }
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
         boolean var2 = false;
         if (this.lesBulletins.size() != 0) {
            for(int var3 = 0; var3 < this.lesBulletins.size(); ++var3) {
               if (((BulletinSalaire)this.lesBulletins.get(var3)).getBulsalLot() == 0) {
                  var2 = true;
                  break;
               }
            }
         }

         if (var2) {
            this.bulletinMois.setBulmenLot(this.bulletinMois.getBulmenLot() + 1);
         }

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
      ArrayList var8;
      if (this.var_choix_modele == 0) {
         if (this.nomModeleDocument != null && !this.nomModeleDocument.isEmpty()) {
            this.utilPrint.setRapport(this.nomModeleDocument);
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "document" + File.separator + "bulletin" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Impression bulletin");
            this.utilPrint.setNomMapping("Salarie");
            this.utilPrint.setTri(this.optionPaye.getTriAgents());
            if (this.optionPaye.getTriAgents().equals("0")) {
               var1 = " order by pay_salaries.sal_matricule";
            } else {
               var1 = " order by pay_salaries.sal_nom, pay_salaries.sal_prenom, pay_salaries.sal_matricule";
            }

            var2 = "";
            var3 = "";
            if (this.lesBulletins.size() != 0) {
               var4 = 0;

               while(true) {
                  if (var4 >= this.lesBulletins.size()) {
                     var2 = " pay_bulletin_salaire.bulsal_id in (" + var3 + ") and bullig_nature <> 99" + var1;
                     break;
                  }

                  if (var3 != null && !var3.isEmpty()) {
                     var3 = var3 + "," + ((BulletinSalaire)this.lesBulletins.get(var4)).getBulsalId();
                  } else {
                     var3 = "" + ((BulletinSalaire)this.lesBulletins.get(var4)).getBulsalId();
                  }

                  ++var4;
               }
            }

            this.utilPrint.setRequete(var2);
            this.utilPrint.setFormat(this.format);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setDestinataireCC(this.impDestinataireCC);
            this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setTiersSelectionne((Tiers)null);
            var8 = new ArrayList();
            var5 = new JRBeanCollectionDataSource(var8);
            this.utilPrint.setjRBeanCollectionDataSource(var5);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.imprimeRapport();
            this.majDateImpressionMultiple(var3);
            this.chagerSalarieGeneration((Session)null);
         }
      } else if (this.var_choix_modele == 1) {
         if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty()) {
            this.utilPrint.setRapport(this.nomModeleListe);
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "salarie" + File.separator + "01-mensuel" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Impression génération");
            if (this.nomModeleListe.equals("AgentControle")) {
               new ObjetCtrlAgent();
               ArrayList var14 = new ArrayList();
               new ArrayList();
               Session var11 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
               int var10 = Integer.parseInt(this.optionPaye.getTriAgents());
               List var9 = this.salariesContratsDao.listelesContratsActif(this.modeRepartition, var10, this.d1, this.d2, this.bulletinMois.getBulmenFeuille(), this.var_agent_rec, this.var_activite_rec, this.var_service_rec, this.var_departement_rec, this.var_localisation_rec, this.var_projet_rec, this.var_feuille_rec, this.var_idclient_rec, var11);
               if (var9.size() != 0) {
                  for(int var6 = 0; var6 < var9.size(); ++var6) {
                     this.salaries = ((SalariesContrats)var9.get(var6)).getSalaries();
                     if (this.salaries.getSalDateEntree() != null) {
                        this.salariesContrats = (SalariesContrats)var9.get(var6);
                        ObjetCtrlAgent var7 = new ObjetCtrlAgent();
                        var7.setMatricule(this.salaries.getSalMatricule());
                        var7.setPatronyme(this.salaries.getPatronyme());
                        var7.setActivite(this.salariesContrats.getSalconActivite());
                        var7.setService(this.salariesContrats.getSalconService());
                        var7.setLocalisation(this.salariesContrats.getSalconLocalisation());
                        var7.setPeriode(this.bulletinMois.getBulmenPeriode());
                        this.bulletinSalaire = this.bulletinSalaireDao.rechercheBulletinSalariePeriode(this.salaries.getSalMatricule(), this.bulletinMois.getBulmenPeriode(), var11);
                        if (this.bulletinSalaire != null) {
                           var7.setEtat(this.bulletinSalaire.getBulsalPeriode());
                        } else {
                           var7.setEtat("");
                        }

                        var14.add(var7);
                     }
                  }
               }

               this.utilPrint.setNomMapping("");
               this.utilPrint.setTri(this.optionPaye.getTriAgents());
               this.utilPrint.setRequete("");
               this.utilPrint.setFormat(this.format);
               this.utilPrint.setFiltre("");
               this.utilPrint.setInfoOrigineDoc(this.banqueSociete);
               this.utilPrint.setId_doc((long)this.modeBulletin);
               this.utilPrint.setDestinataire(this.impDestinataire);
               this.utilPrint.setDestinataireCC(this.impDestinataireCC);
               this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
               this.utilPrint.setEmetteur(this.impEmetteur);
               this.utilPrint.setTiersSelectionne((Tiers)null);
               JRBeanCollectionDataSource var13 = new JRBeanCollectionDataSource(var14);
               this.utilPrint.setjRBeanCollectionDataSource(var13);
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
            } else {
               this.utilPrint.setNomMapping("Salarie");
               this.utilPrint.setTri(this.optionPaye.getTriAgents());
               if (this.nomModeleListe.startsWith("Lot_")) {
                  var1 = "";
               } else if (this.optionPaye.getTriAgents().equals("0")) {
                  var1 = " order by pay_salaries.sal_matricule";
               } else {
                  var1 = " order by pay_salaries.sal_nom, pay_salaries.sal_prenom, pay_salaries.sal_matricule";
               }

               var2 = "";
               var3 = "";
               if (this.nomModeleListe.equals("AgentControle")) {
                  if (this.optionPaye.getModeTravail().equals("0")) {
                     var2 = "salcon_feuille = " + this.feuilleCalcul.getFeuCode();
                  } else if (this.optionPaye.getModeTravail().equals("1")) {
                     var2 = "salcon_activite = " + this.feuilleCalcul.getFeuCode();
                  } else if (this.optionPaye.getModeTravail().equals("2")) {
                     var2 = "sal_service = " + this.feuilleCalcul.getFeuCode();
                  } else if (this.optionPaye.getModeTravail().equals("3")) {
                     var2 = "salcon_projet = " + this.feuilleCalcul.getFeuCode();
                  } else if (this.optionPaye.getModeTravail().equals("4")) {
                     var2 = "salcon_id_tiers = " + this.feuilleCalcul.getFeuCode();
                  }
               } else if (this.lesBulletins.size() != 0) {
                  for(var4 = 0; var4 < this.lesBulletins.size(); ++var4) {
                     if (var3 != null && !var3.isEmpty()) {
                        var3 = var3 + "," + ((BulletinSalaire)this.lesBulletins.get(var4)).getBulsalId();
                     } else {
                        var3 = "" + ((BulletinSalaire)this.lesBulletins.get(var4)).getBulsalId();
                     }
                  }

                  if (this.modeBulletin == 0) {
                     var2 = " pay_bulletin_salaire.bulsal_id in (" + var3 + ") " + var1;
                  } else if (this.modeBulletin == 1) {
                     var2 = " pay_bulletin_salaire.bulsal_id in (" + var3 + ") and bulsal_paye_id_caissier = 0 " + var1;
                  } else if (this.modeBulletin == 2) {
                     var2 = " pay_bulletin_salaire.bulsal_id in (" + var3 + ") and bulsal_paye_id_caissier > 0 " + var1;
                  } else if (this.modeBulletin == 3) {
                     var2 = " pay_bulletin_salaire.bulsal_id in (" + var3 + ") and bulsal_paye_id_caissier > 0 " + var1;
                  }
               }

               this.utilPrint.setRequete(var2);
               this.utilPrint.setFormat(this.format);
               if (this.lotActif) {
                  if (this.var_lot_rec != null && !this.var_lot_rec.isEmpty()) {
                     if (this.var_lot_rec.equals("*****")) {
                        this.utilPrint.setFiltre("Sans lot");
                     } else {
                        this.utilPrint.setFiltre("Lot n° " + this.var_lot_rec);
                     }
                  } else {
                     this.utilPrint.setFiltre("Tous les lots");
                  }
               } else {
                  this.utilPrint.setFiltre("");
               }

               this.utilPrint.setInfoOrigineDoc(this.banqueSociete);
               this.utilPrint.setId_doc((long)this.modeBulletin);
               this.utilPrint.setDestinataire(this.impDestinataire);
               this.utilPrint.setDestinataireCC(this.impDestinataireCC);
               this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
               this.utilPrint.setEmetteur(this.impEmetteur);
               this.utilPrint.setTiersSelectionne((Tiers)null);
               var8 = new ArrayList();
               var5 = new JRBeanCollectionDataSource(var8);
               this.utilPrint.setjRBeanCollectionDataSource(var5);
               this.utilPrint.setBaseLog(this.baseLog);
               this.utilPrint.setStructureLog(this.structureLog);
               this.utilPrint.setUsersLog(this.usersLog);
               this.utilPrint.imprimeRapport();
               if (this.nomModeleListe.startsWith("Lot_")) {
                  this.majDateImpressionLot(var3);
                  this.calculLotBulletin();
               } else {
                  var2 = var2 + " and pay_bulletin_salaire.bulsal_lot = 0 ";
                  this.majDateImpressionMultiple(var3);
               }
            }

            this.chagerSalarieGeneration((Session)null);
         }
      } else if (this.var_choix_modele == 2) {
         if (this.nomModeleListe != null && !this.nomModeleListe.isEmpty() && this.lesContrats.size() != 0) {
            this.utilPrint.setRapport(this.nomModeleListe);
            this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "liste" + File.separator + "preparation" + File.separator);
            this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
            this.utilPrint.setEntete("Impression préparation");
            this.utilPrint.setNomMapping("Salarie");
            if (this.optionPaye.getTriAgents().equals("0")) {
               var1 = " order by pay_salaries.sal_matricule";
            } else {
               var1 = " order by pay_salaries.sal_nom, pay_salaries.sal_prenom, pay_salaries.sal_matricule";
            }

            var2 = "";
            if (this.lesContrats.size() != 0) {
               var3 = "";
               var4 = 0;

               while(true) {
                  if (var4 >= this.lesContrats.size()) {
                     var2 = " salvar_periode = '" + this.bulletinMois.getBulmenPeriode() + "' and pay_salaries.sal_id in (" + var3 + ") " + var1;
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
            var8 = new ArrayList();
            var5 = new JRBeanCollectionDataSource(var8);
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
            if (this.optionPaye.getTriAgents().equals("0")) {
               var1 = " order by pay_salaries.sal_matricule";
            } else {
               var1 = " order by pay_salaries.sal_nom, pay_salaries.sal_prenom, pay_salaries.sal_matricule";
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

            this.utilPrint.setFiltre(var3);
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
            var8 = new ArrayList();
            var5 = new JRBeanCollectionDataSource(var8);
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
         ArrayList var12 = new ArrayList();
         if (this.lesElements.size() != 0) {
            new Salaries();

            for(int var17 = 0; var17 < this.lesElements.size(); ++var17) {
               new Salaries();
               Salaries var15 = ((SalariesElements)this.lesElements.get(var17)).getSalaries();
               var15.setDateContratJournalier(this.bulletinMois.getBulmenJour());
               var12.add(var15);
            }
         }

         JRBeanCollectionDataSource var16 = new JRBeanCollectionDataSource(var12);
         this.utilPrint.setjRBeanCollectionDataSource(var16);
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

   public boolean isLotActif() {
      return this.lotActif;
   }

   public void setLotActif(boolean var1) {
      this.lotActif = var1;
   }

   public boolean isAccesInterim() {
      return this.accesInterim;
   }

   public void setAccesInterim(boolean var1) {
      this.accesInterim = var1;
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

   public String getBanqueSociete() {
      return this.banqueSociete;
   }

   public void setBanqueSociete(String var1) {
      this.banqueSociete = var1;
   }

   public List getMesBanqueItems() {
      return this.mesBanqueItems;
   }

   public void setMesBanqueItems(List var1) {
      this.mesBanqueItems = var1;
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

   public Date getDateGeneration() {
      return this.dateGeneration;
   }

   public void setDateGeneration(Date var1) {
      this.dateGeneration = var1;
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

   public boolean isShowModalPanelPaiement() {
      return this.showModalPanelPaiement;
   }

   public void setShowModalPanelPaiement(boolean var1) {
      this.showModalPanelPaiement = var1;
   }

   public boolean isVar_affiche_bd() {
      return this.var_affiche_bd;
   }

   public void setVar_affiche_bd(boolean var1) {
      this.var_affiche_bd = var1;
   }

   public boolean isVar_affiche_dollar() {
      return this.var_affiche_dollar;
   }

   public void setVar_affiche_dollar(boolean var1) {
      this.var_affiche_dollar = var1;
   }

   public boolean isImputAll() {
      return this.imputAll;
   }

   public void setImputAll(boolean var1) {
      this.imputAll = var1;
   }

   public int getModeBulletin() {
      return this.modeBulletin;
   }

   public void setModeBulletin(int var1) {
      this.modeBulletin = var1;
   }

   public String getNomCaissier() {
      return this.nomCaissier;
   }

   public void setNomCaissier(String var1) {
      this.nomCaissier = var1;
   }
}
