package com.epegase.forms.paye;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Activites;
import com.epegase.systeme.classe.Budget;
import com.epegase.systeme.classe.BulletinLigne;
import com.epegase.systeme.classe.BulletinMois;
import com.epegase.systeme.classe.BulletinSalaire;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.FeuilleCalcul;
import com.epegase.systeme.classe.FeuilleCalculRubrique;
import com.epegase.systeme.classe.LocalisationSalarie;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlanPaye;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Projets;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesContrats;
import com.epegase.systeme.classe.SalariesElements;
import com.epegase.systeme.classe.SalariesHistorique;
import com.epegase.systeme.classe.SalariesPointage;
import com.epegase.systeme.classe.SalariesVariables;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.control.TransfertPaye;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.BudgetDao;
import com.epegase.systeme.dao.BulletinLigneDao;
import com.epegase.systeme.dao.BulletinMoisDao;
import com.epegase.systeme.dao.BulletinSalaireDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FeuilleCalculDao;
import com.epegase.systeme.dao.FeuilleCalculRubriqueDao;
import com.epegase.systeme.dao.LocalisationSalarieDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PlanPayeDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.ProjetsDao;
import com.epegase.systeme.dao.SalariesContratsDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.SalariesElementsDao;
import com.epegase.systeme.dao.SalariesHistoriqueDao;
import com.epegase.systeme.dao.SalariesPointageDao;
import com.epegase.systeme.dao.SalariesVariablesDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilExcel;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.LectureCentresImpots;
import com.epegase.systeme.xml.LectureCentresSecuriteSociale;
import com.epegase.systeme.xml.LectureClassementsAgents;
import com.epegase.systeme.xml.LectureConventions;
import com.epegase.systeme.xml.LectureGrilleSalaire;
import com.epegase.systeme.xml.LectureNiveauxEmplois;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.ObjetConvention;
import com.epegase.systeme.xml.ObjetGrilleSalaire;
import com.epegase.systeme.xml.OptionPaye;
import groovyjarjarcommonscli.ParseException;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormTransfertBulletin implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action = 0;
   private String pageIndex;
   private int nature;
   private List mesOnglets;
   private OptionPaye optionPaye;
   private ExercicesPaye exercicesPaye;
   private ExercicesPaye lastExoPaye;
   private EspionDao espionDao;
   private int var_nb_max = 100;
   private UtilDate utilDate = new UtilDate();
   private UtilNombre utilNombre = new UtilNombre();
   private FormRecherche formRecherche;
   private List lesFeuilles;
   private List lesPeriodes = new ArrayList();
   private List lesFeuillesItems = new ArrayList();
   private List lesPeriodesItems = new ArrayList();
   private int nbPeriode = 0;
   private FeuilleCalcul feuilleCalcul = new FeuilleCalcul();
   private BulletinSalaire bulletinSalaire;
   private BulletinLigne bulletinLigne;
   private BulletinLigneDao bulletinLigneDao;
   private BulletinSalaireDao bulletinSalaireDao;
   private BulletinMois bulletinMois = new BulletinMois();
   private BulletinMoisDao bulletinMoisDao;
   private String numFeuille;
   private String periode;
   private transient DataModel datamodelDocument = new ListDataModel();
   private List listDocument = new ArrayList();
   private boolean var_affiche_bouton = false;
   private int var_choix_importation;
   private boolean importSage;
   private boolean variableExcel;
   private boolean salarieSage;
   private boolean payeSage;
   private List lesTransfertPaye;
   private TransfertPaye transfertPaye;
   private Chrono chrono;
   private Chrono chronoTransfert;
   private ChronoDao chronoDao;
   private int balance = 0;
   private Salaries salaries = new Salaries();
   private SalariesDao salariesDao;
   private SalariesContrats salariesContrats = new SalariesContrats();
   private SalariesContratsDao salariesContratsDao;
   private String rub00 = "";
   private String rub01 = "";
   private String rub02 = "";
   private String rub03 = "";
   private String rub04 = "";
   private String rub05 = "";
   private String rub06 = "";
   private String rub07 = "";
   private String rub08 = "";
   private String rub09 = "";
   private String rub10 = "";
   private String rub11 = "";
   private String rub12 = "";
   private String rub13 = "";
   private String rub14 = "";
   private String rub15 = "";
   private String rub16 = "";
   private String rub17 = "";
   private String rub18 = "";
   private String rub19 = "";
   private String rub20 = "";
   private String rub21 = "";
   private String rub22 = "";
   private String rub23 = "";
   private String rub24 = "";
   private String rub25 = "";
   private String rub26 = "";
   private String rub27 = "";
   private String rub28 = "";
   private String rub29 = "";
   private String rub30 = "";
   private String rub31 = "";
   private String rub32 = "";
   private String rub33 = "";
   private String rub34 = "";
   private String rub35 = "";
   private String rub36 = "";
   private String rub37 = "";
   private String rub38 = "";
   private String rub39 = "";
   private String rub40 = "";
   private SalariesVariables salariesVariables = new SalariesVariables();
   private SalariesVariablesDao salariesVariablesDao;
   private List lePlanPaye = new ArrayList();
   private PlanPayeDao planPayeDao;
   private PlanPaye planPaye;
   private FeuilleCalculRubrique feuilleCalculRubrique = new FeuilleCalculRubrique();
   private FeuilleCalculRubriqueDao feuilleCalculRubriqueDao;
   private List leFeuilleRubrique = new ArrayList();
   private SalariesElements salariesElements = new SalariesElements();
   private SalariesElementsDao salariesElementsDao;
   private List lesErreurs = new ArrayList();
   private Service service = new Service();
   private ServiceDao serviceDao;
   private int var_currentValue = 0;
   private boolean var_showBarProgMaj = false;
   private String var_info;
   private String messageErreur;
   private FeuilleCalculDao feuilleCalculDao;
   private SalariesHistoriqueDao salariesHistoriqueDao;
   private SalariesHistorique salariesHistorique;
   private Site site;
   private SiteDao siteDao;
   private Departement departement;
   private DepartementDao departementDao;
   private Activites activites;
   private ActivitesDao activitesDao;
   private LocalisationSalarie localisationSalarie;
   private LocalisationSalarieDao localisationSalarieDao;
   private Budget budget;
   private BudgetDao budgetDao;
   private Parc parc;
   private ParcDao parcDao;
   private LectureConventions lectureConventions;
   private LectureCentresImpots lectureCentresImpots;
   private LectureCentresSecuriteSociale lectureCentresSecuriteSociale;
   private LectureClassementsAgents lectureClassementsAgents;
   private LectureNiveauxEmplois lectureNiveauxEmplois;
   private Projets projets;
   private ProjetsDao projetsDao;
   private PlansAnalytiques plansAnalytiques;
   private PlansAnalytiquesDao plansAnalytiquesDao;
   private CalculChrono calculChrono;
   private transient DataModel dataModelChampSalarie = new ListDataModel();
   private transient DataModel dataModelChampContrat = new ListDataModel();
   private UtilTdt utilTdt = new UtilTdt();
   private float jrPaye;
   private float nbPanier;
   private float nbChantier;
   private float nbAssiduite;
   private float nbNuit;
   private double nbHeure10;
   private double nbHeure30;
   private double nbHeure40;
   private double nbHeure60;

   public FormTransfertBulletin() throws IOException {
   }

   public void InstancesDaoUtilses() {
      this.bulletinSalaireDao = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
      this.bulletinMoisDao = new BulletinMoisDao(this.baseLog, this.utilInitHibernate);
      this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
   }

   public void initialisation(Session var1) {
      if (this.optionPaye.getNbLigneMax() != null && !this.optionPaye.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionPaye.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.lesFeuilles.size() != 0) {
         for(int var2 = 0; var2 < this.lesFeuilles.size(); ++var2) {
            this.feuilleCalcul = (FeuilleCalcul)this.lesFeuilles.get(var2);
            this.lesFeuillesItems.add(new SelectItem(this.feuilleCalcul.getFeuCode(), this.feuilleCalcul.getFeuCode() + ":" + this.feuilleCalcul.getFeuLibelleFr()));
         }
      }

   }

   public void initImportation() throws HibernateException, NamingException {
      this.dataModelChampSalarie.setWrappedData(this.utilTdt.rubriqueAgent(this.utilInitHibernate, this.baseLog));
      this.dataModelChampContrat.setWrappedData(this.utilTdt.rubriqueContrat(this.utilInitHibernate, this.baseLog));
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
         this.lesPeriodesItems.add(new SelectItem(var6));
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

   public void executerRequete() throws HibernateException, NamingException {
      int var1 = Integer.parseInt(this.optionPaye.getModeTravail());
      int var2 = Integer.parseInt(this.optionPaye.getTriAgents());
      this.listDocument.clear();
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      new ArrayList();
      List var4 = this.bulletinSalaireDao.rechercheBulletinATransfererCompta(var1, this.numFeuille, this.periode, var3);
      if (var4.size() != 0) {
         for(int var5 = 0; var5 < var4.size(); ++var5) {
            this.bulletinSalaire = (BulletinSalaire)var4.get(var5);
            if (var1 == 0) {
               this.bulletinMois = this.bulletinMoisDao.recupererBulletinMoisFeuille(this.bulletinSalaire.getBulsalPeriode(), this.bulletinSalaire.getBulsalFeuille(), var3);
            } else if (var1 == 1) {
               this.bulletinMois = this.bulletinMoisDao.recupererBulletinMoisFeuille(this.bulletinSalaire.getBulsalPeriode(), this.bulletinSalaire.getBulsalActivite(), var3);
            } else if (var1 == 2) {
               this.bulletinMois = this.bulletinMoisDao.recupererBulletinMoisFeuille(this.bulletinSalaire.getBulsalPeriode(), this.bulletinSalaire.getBulsalService(), var3);
            } else if (var1 == 3) {
               this.bulletinMois = this.bulletinMoisDao.recupererBulletinMoisFeuille(this.bulletinSalaire.getBulsalPeriode(), this.bulletinSalaire.getBulsalProjet(), var3);
            } else if (var1 == 4) {
               this.bulletinMois = this.bulletinMoisDao.recupererBulletinMoisFeuille(this.bulletinSalaire.getBulsalPeriode(), "" + this.bulletinSalaire.getBulsalIdTiers(), var3);
            }

            if (this.bulletinMois != null && this.bulletinMois.getBulmenEtat() == 3) {
               DocumentEntete var6 = new DocumentEntete();
               var6.setDocNature(88);
               var6.setDocId(this.bulletinSalaire.getBulsalId());
               var6.setDocDate(this.bulletinSalaire.getBulsalDateDebut());
               var6.setDocNum(this.bulletinSalaire.getBulsalMatricule());
               var6.setDocSerie(this.bulletinSalaire.getBulsalFeuille());
               if (this.bulletinSalaire.getSalaries().getSalPrenom() != null && !this.bulletinSalaire.getSalaries().getSalPrenom().isEmpty()) {
                  var6.setDocNomTiers(this.bulletinSalaire.getSalaries().getSalNom() + " " + this.bulletinSalaire.getSalaries().getSalPrenom());
               } else {
                  var6.setDocNomTiers(this.bulletinSalaire.getSalaries().getSalNom());
               }

               var6.setDocTotHt(this.bulletinSalaire.getBulsalNetPayer());
               if (this.bulletinSalaire.getSalaries().getSalCompteNet() != null && !this.bulletinSalaire.getSalaries().getSalCompteNet().isEmpty()) {
                  var6.setNumComptetier(this.bulletinSalaire.getSalaries().getSalCompteNet());
               } else {
                  var6.setNumComptetier("");
               }

               var6.setDocSelect(true);
               this.listDocument.add(var6);
            }
         }
      }

      this.datamodelDocument.setWrappedData(this.listDocument);
      this.utilInitHibernate.closeSession();
      if (this.listDocument.size() != 0) {
         this.var_affiche_bouton = true;
      } else {
         this.var_affiche_bouton = false;
      }

   }

   public void selectionLigne() {
      if (this.datamodelDocument.isRowAvailable()) {
      }

   }

   public void selectionAll() {
      if (this.listDocument.size() != 0) {
         for(int var1 = 0; var1 < this.listDocument.size(); ++var1) {
            new DocumentEntete();
            DocumentEntete var2 = (DocumentEntete)this.listDocument.get(var1);
            var2.setDocSelect(true);
         }

         this.datamodelDocument.setWrappedData(this.listDocument);
      }

   }

   public void deSelectionAll() {
      if (this.listDocument.size() != 0) {
         for(int var1 = 0; var1 < this.listDocument.size(); ++var1) {
            new DocumentEntete();
            DocumentEntete var2 = (DocumentEntete)this.listDocument.get(var1);
            var2.setDocSelect(false);
         }

         this.datamodelDocument.setWrappedData(this.listDocument);
      }

   }

   public void transfertImport(List var1) throws HibernateException, NamingException, ParseException, java.text.ParseException {
      boolean var2 = false;
      this.importSage = false;
      this.variableExcel = false;
      this.chrono = new Chrono();
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.lesTransfertPaye = new ArrayList();
      if (var1.size() != 0) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            String var4 = (String)var1.get(var3);
            if (var4.toString().contains(".xls:") || var4.toString().contains(".xlsx:") || var4.toString().contains(".XLS:") || var4.toString().contains(".XLSX:")) {
               this.variableExcel = true;
               String[] var8 = var4.split(":");
               this.importExcel(var8[1]);
               break;
            }

            if (var4 != null && !var4.isEmpty() && var4.startsWith("#FLG")) {
               this.importSage = true;
            }

            boolean var5 = false;
            String[] var6 = null;
            if (!this.variableExcel && var4 != null && !var4.isEmpty() && var4.contains(",")) {
               var6 = var4.split(",");
               int var7 = var6.length;
            } else {
               var5 = true;
            }
         }
      }

   }

   public void importExcel(String var1) throws HibernateException, NamingException {
      byte var2 = 0;
      UtilExcel var3 = new UtilExcel();
      File var4 = new File(var1);
      new ArrayList();
      List var5 = var3.lectureFichierPaye(var4, this.structureLog.getStrid());
      if (var5.size() != 0) {
         Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "SuiviPaye");

         for(int var7 = 0; var7 < var5.size(); ++var7) {
            this.transfertPaye = (TransfertPaye)var5.get(var7);
            if (var7 == 0) {
               if (this.transfertPaye.getTrfColT00() != null && !this.transfertPaye.getTrfColT00().isEmpty() && this.transfertPaye.getTrfColT00().equals("RUBRIQUE")) {
                  var2 = 0;
                  this.transfertPaye.setTrfNomFeuille("RUBRIQUE");
                  this.transfertPaye.setTrfPeriode("PERIODE");
                  this.transfertPaye.setTrfColT00("ACTIVITE");
                  this.transfertPaye.setTrfColT01("SERVICE");
                  this.transfertPaye.setTrfColT02("LOCALISATION");
                  this.transfertPaye.setTrfColT03("MATRICULE");
                  this.transfertPaye.setTrfColT04("NOM ET PRENOM");
                  this.transfertPaye.setTrfColT05("ETAT");
                  this.lesTransfertPaye.add(this.transfertPaye);
               } else if (this.transfertPaye.getTrfColT00() != null && !this.transfertPaye.getTrfColT00().isEmpty() && this.transfertPaye.getTrfColT00().contains("CHAMP")) {
                  var2 = 4;
                  this.transfertPaye.setTrfNomFeuille("CHAMP");
                  this.lesTransfertPaye.add(this.transfertPaye);
               } else if (this.transfertPaye.getTrfColT00() != null && !this.transfertPaye.getTrfColT00().isEmpty() && this.transfertPaye.getTrfColT00().contains("_")) {
                  var2 = 6;
                  this.lesTransfertPaye.add(this.transfertPaye);
               } else if (this.transfertPaye.getTrfColT00() != null && !this.transfertPaye.getTrfColT00().isEmpty() && this.transfertPaye.getTrfColT00().equals("POINTAGE-OMEGA") && this.structureLog.getStrid() == 179L) {
                  var2 = 7;
                  this.lesTransfertPaye.add(this.transfertPaye);
               }
            } else if (var2 == 0) {
               if (this.transfertPaye.getTrfColT00() != null && !this.transfertPaye.getTrfColT00().isEmpty() && this.transfertPaye.getTrfColT00().equals("RUBRIQUE")) {
                  this.transfertPaye.setTrfNomFeuille("RUBRIQUE");
                  this.transfertPaye.setTrfPeriode("PERIODE");
                  this.transfertPaye.setTrfColT00("ACTIVITE");
                  this.transfertPaye.setTrfColT01("SERVICE");
                  this.transfertPaye.setTrfColT02("LOCALISATION");
                  this.transfertPaye.setTrfColT03("MATRICULE");
                  this.transfertPaye.setTrfColT04("NOM ET PRENOM");
                  this.transfertPaye.setTrfColT05("ETAT");
                  this.lesTransfertPaye.add(this.transfertPaye);
               } else {
                  if (this.transfertPaye.getTrfColT00() != null && !this.transfertPaye.getTrfColT00().isEmpty() && this.transfertPaye.getTrfColT00().equals("0")) {
                     this.transfertPaye.setTrfColT00("");
                  }

                  if (this.transfertPaye.getTrfColT01() != null && !this.transfertPaye.getTrfColT01().isEmpty() && this.transfertPaye.getTrfColT01().equals("0")) {
                     this.transfertPaye.setTrfColT01("");
                  }

                  if (this.transfertPaye.getTrfColT02() != null && !this.transfertPaye.getTrfColT02().isEmpty() && this.transfertPaye.getTrfColT02().equals("0")) {
                     this.transfertPaye.setTrfColT02("");
                  }

                  this.transfertPaye.setTrfColT03(this.verficationMatricule(this.transfertPaye.getTrfColT03(), var6));
                  this.transfertPaye.setTrfColN05(this.conversionTN(this.transfertPaye.getTrfColT05()));
                  this.transfertPaye.setTrfColN06(this.conversionTN(this.transfertPaye.getTrfColT06()));
                  this.transfertPaye.setTrfColN07(this.conversionTN(this.transfertPaye.getTrfColT07()));
                  this.transfertPaye.setTrfColN08(this.conversionTN(this.transfertPaye.getTrfColT08()));
                  this.transfertPaye.setTrfColN09(this.conversionTN(this.transfertPaye.getTrfColT09()));
                  this.transfertPaye.setTrfColN10(this.conversionTN(this.transfertPaye.getTrfColT10()));
                  this.transfertPaye.setTrfColN11(this.conversionTN(this.transfertPaye.getTrfColT11()));
                  this.transfertPaye.setTrfColN12(this.conversionTN(this.transfertPaye.getTrfColT12()));
                  this.transfertPaye.setTrfColN13(this.conversionTN(this.transfertPaye.getTrfColT13()));
                  this.transfertPaye.setTrfColN14(this.conversionTN(this.transfertPaye.getTrfColT14()));
                  this.transfertPaye.setTrfColN15(this.conversionTN(this.transfertPaye.getTrfColT15()));
                  this.transfertPaye.setTrfColN16(this.conversionTN(this.transfertPaye.getTrfColT16()));
                  this.transfertPaye.setTrfColN17(this.conversionTN(this.transfertPaye.getTrfColT17()));
                  this.transfertPaye.setTrfColN18(this.conversionTN(this.transfertPaye.getTrfColT18()));
                  this.transfertPaye.setTrfColN19(this.conversionTN(this.transfertPaye.getTrfColT19()));
                  this.transfertPaye.setTrfColN20(this.conversionTN(this.transfertPaye.getTrfColT20()));
                  this.transfertPaye.setTrfColN21(this.conversionTN(this.transfertPaye.getTrfColT21()));
                  this.transfertPaye.setTrfColN22(this.conversionTN(this.transfertPaye.getTrfColT22()));
                  this.transfertPaye.setTrfColN23(this.conversionTN(this.transfertPaye.getTrfColT23()));
                  this.transfertPaye.setTrfColN24(this.conversionTN(this.transfertPaye.getTrfColT24()));
                  this.transfertPaye.setTrfColN25(this.conversionTN(this.transfertPaye.getTrfColT25()));
                  this.transfertPaye.setTrfColN26(this.conversionTN(this.transfertPaye.getTrfColT26()));
                  this.transfertPaye.setTrfColN27(this.conversionTN(this.transfertPaye.getTrfColT27()));
                  this.transfertPaye.setTrfColN28(this.conversionTN(this.transfertPaye.getTrfColT28()));
                  this.transfertPaye.setTrfColN29(this.conversionTN(this.transfertPaye.getTrfColT29()));
                  this.transfertPaye.setTrfColN30(this.conversionTN(this.transfertPaye.getTrfColT30()));
                  this.transfertPaye.setTrfColN31(this.conversionTN(this.transfertPaye.getTrfColT31()));
                  this.transfertPaye.setTrfColN32(this.conversionTN(this.transfertPaye.getTrfColT32()));
                  this.transfertPaye.setTrfColN33(this.conversionTN(this.transfertPaye.getTrfColT33()));
                  this.transfertPaye.setTrfColN34(this.conversionTN(this.transfertPaye.getTrfColT34()));
                  this.transfertPaye.setTrfColN35(this.conversionTN(this.transfertPaye.getTrfColT35()));
                  this.transfertPaye.setTrfColN36(this.conversionTN(this.transfertPaye.getTrfColT36()));
                  this.transfertPaye.setTrfColN37(this.conversionTN(this.transfertPaye.getTrfColT37()));
                  this.transfertPaye.setTrfColN38(this.conversionTN(this.transfertPaye.getTrfColT38()));
                  this.transfertPaye.setTrfColN39(this.conversionTN(this.transfertPaye.getTrfColT39()));
                  this.transfertPaye.setTrfColN40(this.conversionTN(this.transfertPaye.getTrfColT40()));
                  this.lesTransfertPaye.add(this.transfertPaye);
               }
            } else if (var2 == 4) {
               this.lesTransfertPaye.add(this.transfertPaye);
            } else if (var2 == 6) {
               this.lesTransfertPaye.add(this.transfertPaye);
            } else if (var2 == 7 && (this.transfertPaye.getTrfColT00() != null && !this.transfertPaye.getTrfColT00().isEmpty() && !this.transfertPaye.getTrfColT00().equals("0.0") || this.transfertPaye.getTrfColT04() != null && !this.transfertPaye.getTrfColT04().isEmpty() && this.transfertPaye.getTrfColT04().equals("JOURS A PAYER") || this.transfertPaye.getTrfColT08() != null && !this.transfertPaye.getTrfColT08().isEmpty() && this.transfertPaye.getTrfColT08().equals("TOTAL"))) {
               this.lesTransfertPaye.add(this.transfertPaye);
            }
         }

         this.utilInitHibernate.closeSession();
      }

      this.datamodelDocument.setWrappedData(this.lesTransfertPaye);
      if (var2 == 4) {
         this.balance = 4;
      } else if (var2 == 6) {
         this.balance = 6;
      } else if (var2 == 7) {
         this.balance = 7;
      } else {
         this.balance = 1;
      }

      this.var_affiche_bouton = true;
   }

   public double conversionTN(String var1) {
      double var2 = 0.0D;
      if (var1 != null && !var1.isEmpty()) {
         boolean var4 = false;
         String var5 = "";
         if (",".contains(var1)) {
            var1 = var1.replace(",", ".");
         } else if ("%".contains(var1)) {
            var1 = var1.replace("%", "");
         }

         for(int var6 = 0; var6 < var1.length(); ++var6) {
            var5 = (String)var1.subSequence(var6, var6 + 1);
            if (!"0123456789.".contains(var5)) {
               var4 = true;
               break;
            }
         }

         if (!var4) {
            var2 = Double.parseDouble(var1);
         }
      }

      return var2;
   }

   public String calculeMatricule(String var1) throws HibernateException, NamingException {
      String var2 = "";
      if (var1 != null && !var1.isEmpty() && var1.contains(".0")) {
         var1 = var1.substring(0, var1.length() - 2);
      }

      if (var1 != null && !var1.isEmpty()) {
         String var3 = "";
         byte var4 = 6;
         boolean var5 = false;
         int var8 = var1.length();
         int var6 = var4 - var8;
         String var7 = "";
         if (var6 == 1) {
            var7 = "0";
         } else if (var6 == 2) {
            var7 = "00";
         } else if (var6 == 3) {
            var7 = "000";
         } else if (var6 == 4) {
            var7 = "0000";
         } else if (var6 == 5) {
            var7 = "00000";
         } else if (var6 == 6) {
            var7 = "000000";
         } else if (var6 == 7) {
            var7 = "0000000";
         } else if (var6 == 8) {
            var7 = "00000000";
         } else if (var6 == 9) {
            var7 = "000000000";
         } else if (var6 == 10) {
            var7 = "0000000000";
         } else if (var6 == 11) {
            var7 = "00000000000";
         } else if (var6 == 12) {
            var7 = "000000000000";
         } else if (var6 == 13) {
            var7 = "0000000000000";
         } else if (var6 == 14) {
            var7 = "00000000000000";
         } else if (var6 == 15) {
            var7 = "000000000000000";
         } else if (var6 == 16) {
            var7 = "0000000000000000";
         } else if (var6 == 17) {
            var7 = "00000000000000000";
         } else if (var6 == 18) {
            var7 = "000000000000000000";
         } else if (var6 == 19) {
            var7 = "0000000000000000000";
         } else if (var6 == 20) {
            var7 = "00000000000000000000";
         }

         var2 = var7 + "" + var1;
      }

      return var2;
   }

   public String verficationMatricule(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = this.calculeMatricule(var1);
      String var4 = "";
      if (var3 != null && !var3.isEmpty()) {
         this.salaries = this.salariesDao.chercherIdSalaries(var3, var2);
         if (this.salaries != null) {
            var4 = this.salaries.getSalMatricule();
         } else {
            var4 = "???";
         }
      } else {
         var4 = "???";
      }

      return var4;
   }

   public void importerVariables() throws HibernateException, NamingException {
      this.lesErreurs.clear();
      if (this.lesTransfertPaye.size() != 0) {
         this.var_showBarProgMaj = true;
         this.var_currentValue = 0;
         this.var_info = "Chargement des elements de base...";
         int var1 = 0;
         this.salariesVariablesDao = new SalariesVariablesDao(this.baseLog, this.utilInitHibernate);
         this.salariesElementsDao = new SalariesElementsDao(this.baseLog, this.utilInitHibernate);
         this.salariesContratsDao = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
         this.planPayeDao = new PlanPayeDao(this.baseLog, this.utilInitHibernate);
         this.feuilleCalculRubriqueDao = new FeuilleCalculRubriqueDao(this.baseLog, this.utilInitHibernate);
         int var2 = Integer.parseInt(this.optionPaye.getModeTravail());
         this.lePlanPaye = this.planPayeDao.chargerPlanPaye(this.exercicesPaye.getExepayId(), (Session)null);
         this.leFeuilleRubrique = this.feuilleCalculRubriqueDao.chargerRubriqueToutesFeuilles((Session)null);
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();
            var3.setFlushMode(FlushMode.MANUAL);

            for(int var5 = 0; var5 < this.lesTransfertPaye.size(); ++var5) {
               this.transfertPaye = (TransfertPaye)this.lesTransfertPaye.get(var5);
               this.var_info = "Salarie " + this.transfertPaye.getTrfColT01() + " - Nb elements : " + this.lesTransfertPaye.size();
               if (var5 != 0) {
                  double var6 = (double)this.lesTransfertPaye.size();
                  double var8 = this.utilNombre.myRound(var6 / (double)var5, 4);
                  double var10 = this.utilNombre.myRound(100.0D / var8, 2);
                  this.var_currentValue = (int)var10;
               }

               if (this.transfertPaye.getTrfNomFeuille().equals("RUBRIQUE")) {
                  this.calculEntete();
               } else {
                  this.calculSalarie(var3);
                  if (this.salaries != null && this.salaries.getSalFeuille() != null && !this.salaries.getSalFeuille().isEmpty()) {
                     if (this.optionPaye.getModeTravail().equals("0")) {
                        this.bulletinMois = this.bulletinMoisDao.recupererBulletinMoisFeuille(this.transfertPaye.getTrfPeriode(), this.salaries.getSalFeuille(), var3);
                     } else if (this.optionPaye.getModeTravail().equals("1")) {
                        this.bulletinMois = this.bulletinMoisDao.recupererBulletinMoisFeuille(this.transfertPaye.getTrfPeriode(), this.salaries.getSalActivite(), var3);
                     } else if (this.optionPaye.getModeTravail().equals("2")) {
                        this.bulletinMois = this.bulletinMoisDao.recupererBulletinMoisFeuille(this.transfertPaye.getTrfPeriode(), this.salaries.getSalService(), var3);
                     } else if (this.optionPaye.getModeTravail().equals("3")) {
                        this.bulletinMois = this.bulletinMoisDao.recupererBulletinMoisFeuille(this.transfertPaye.getTrfPeriode(), this.salariesContrats.getSalconProjet(), var3);
                     } else if (this.optionPaye.getModeTravail().equals("4")) {
                        this.bulletinMois = this.bulletinMoisDao.recupererBulletinMoisFeuille(this.transfertPaye.getTrfPeriode(), "" + this.salaries.getSalIdTiers(), var3);
                     }

                     if (this.bulletinMois != null && this.bulletinMois.getBulmenEtat() <= 2) {
                        if (this.bulletinMois.getBulmenEtat() == 0) {
                           this.bulletinMois.setBulmenEtat(1);
                           this.bulletinMois = this.bulletinMoisDao.majJournal(this.bulletinMois, var3);
                           var3.flush();
                        }

                        this.calculeRubrique(this.rub05, this.transfertPaye.getTrfColN05(), var2, var3);
                        this.calculeRubrique(this.rub06, this.transfertPaye.getTrfColN06(), var2, var3);
                        this.calculeRubrique(this.rub07, this.transfertPaye.getTrfColN07(), var2, var3);
                        this.calculeRubrique(this.rub08, this.transfertPaye.getTrfColN08(), var2, var3);
                        this.calculeRubrique(this.rub09, this.transfertPaye.getTrfColN09(), var2, var3);
                        this.calculeRubrique(this.rub10, this.transfertPaye.getTrfColN10(), var2, var3);
                        this.calculeRubrique(this.rub11, this.transfertPaye.getTrfColN11(), var2, var3);
                        this.calculeRubrique(this.rub12, this.transfertPaye.getTrfColN12(), var2, var3);
                        this.calculeRubrique(this.rub13, this.transfertPaye.getTrfColN13(), var2, var3);
                        this.calculeRubrique(this.rub14, this.transfertPaye.getTrfColN14(), var2, var3);
                        this.calculeRubrique(this.rub15, this.transfertPaye.getTrfColN15(), var2, var3);
                        this.calculeRubrique(this.rub16, this.transfertPaye.getTrfColN16(), var2, var3);
                        this.calculeRubrique(this.rub17, this.transfertPaye.getTrfColN17(), var2, var3);
                        this.calculeRubrique(this.rub18, this.transfertPaye.getTrfColN18(), var2, var3);
                        this.calculeRubrique(this.rub19, this.transfertPaye.getTrfColN19(), var2, var3);
                        this.calculeRubrique(this.rub20, this.transfertPaye.getTrfColN20(), var2, var3);
                        this.calculeRubrique(this.rub21, this.transfertPaye.getTrfColN21(), var2, var3);
                        this.calculeRubrique(this.rub22, this.transfertPaye.getTrfColN22(), var2, var3);
                        this.calculeRubrique(this.rub23, this.transfertPaye.getTrfColN23(), var2, var3);
                        this.calculeRubrique(this.rub24, this.transfertPaye.getTrfColN24(), var2, var3);
                        this.calculeRubrique(this.rub25, this.transfertPaye.getTrfColN25(), var2, var3);
                        this.calculeRubrique(this.rub26, this.transfertPaye.getTrfColN26(), var2, var3);
                        this.calculeRubrique(this.rub27, this.transfertPaye.getTrfColN27(), var2, var3);
                        this.calculeRubrique(this.rub28, this.transfertPaye.getTrfColN28(), var2, var3);
                        this.calculeRubrique(this.rub29, this.transfertPaye.getTrfColN29(), var2, var3);
                        this.calculeRubrique(this.rub30, this.transfertPaye.getTrfColN30(), var2, var3);
                        this.calculeRubrique(this.rub31, this.transfertPaye.getTrfColN31(), var2, var3);
                        this.calculeRubrique(this.rub32, this.transfertPaye.getTrfColN32(), var2, var3);
                        this.calculeRubrique(this.rub33, this.transfertPaye.getTrfColN33(), var2, var3);
                        this.calculeRubrique(this.rub34, this.transfertPaye.getTrfColN34(), var2, var3);
                        this.calculeRubrique(this.rub35, this.transfertPaye.getTrfColN35(), var2, var3);
                        this.calculeRubrique(this.rub36, this.transfertPaye.getTrfColN36(), var2, var3);
                        this.calculeRubrique(this.rub37, this.transfertPaye.getTrfColN37(), var2, var3);
                        this.calculeRubrique(this.rub38, this.transfertPaye.getTrfColN38(), var2, var3);
                        this.calculeRubrique(this.rub39, this.transfertPaye.getTrfColN39(), var2, var3);
                        this.calculeRubrique(this.rub40, this.transfertPaye.getTrfColN40(), var2, var3);
                     }
                  } else if (this.salaries != null) {
                     this.transfertPaye.setTrfNomFeuille("la feuille N° " + this.salaries.getSalFeuille() + " est verrouillée pour la période " + this.transfertPaye.getTrfPeriode());
                     this.lesErreurs.add(this.transfertPaye);
                  } else if (this.salariesContrats != null) {
                     this.transfertPaye.setTrfNomFeuille("la feuille du salarié " + this.transfertPaye.getTrfColT04() + " est verrouillée pour la période " + this.transfertPaye.getTrfPeriode());
                  }

                  ++var1;
                  if (var1 == 50) {
                     var3.flush();
                     var1 = 0;
                  }
               }
            }

            var4.commit();
         } catch (HibernateException var15) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var15;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.datamodelDocument.setWrappedData(this.lesErreurs);
         this.var_affiche_bouton = false;
         this.balance = 2;
         this.var_showBarProgMaj = false;
      }

   }

   public void calculEntete() {
      this.rub01 = "";
      this.rub02 = "";
      this.rub03 = "";
      this.rub04 = "";
      this.rub05 = this.transfertPaye.getTrfColT05();
      this.rub06 = this.transfertPaye.getTrfColT06();
      this.rub07 = this.transfertPaye.getTrfColT07();
      this.rub08 = this.transfertPaye.getTrfColT08();
      this.rub09 = this.transfertPaye.getTrfColT09();
      this.rub10 = this.transfertPaye.getTrfColT10();
      this.rub11 = this.transfertPaye.getTrfColT11();
      this.rub12 = this.transfertPaye.getTrfColT12();
      this.rub13 = this.transfertPaye.getTrfColT13();
      this.rub14 = this.transfertPaye.getTrfColT14();
      this.rub15 = this.transfertPaye.getTrfColT15();
      this.rub16 = this.transfertPaye.getTrfColT16();
      this.rub17 = this.transfertPaye.getTrfColT17();
      this.rub18 = this.transfertPaye.getTrfColT18();
      this.rub19 = this.transfertPaye.getTrfColT19();
      this.rub20 = this.transfertPaye.getTrfColT20();
      this.rub21 = this.transfertPaye.getTrfColT21();
      this.rub22 = this.transfertPaye.getTrfColT22();
      this.rub23 = this.transfertPaye.getTrfColT23();
      this.rub24 = this.transfertPaye.getTrfColT24();
      this.rub25 = this.transfertPaye.getTrfColT25();
      this.rub26 = this.transfertPaye.getTrfColT26();
      this.rub27 = this.transfertPaye.getTrfColT27();
      this.rub28 = this.transfertPaye.getTrfColT28();
      this.rub29 = this.transfertPaye.getTrfColT29();
      this.rub30 = this.transfertPaye.getTrfColT30();
      this.rub31 = this.transfertPaye.getTrfColT31();
      this.rub32 = this.transfertPaye.getTrfColT32();
      this.rub33 = this.transfertPaye.getTrfColT33();
      this.rub34 = this.transfertPaye.getTrfColT34();
      this.rub35 = this.transfertPaye.getTrfColT35();
      this.rub36 = this.transfertPaye.getTrfColT36();
      this.rub37 = this.transfertPaye.getTrfColT37();
      this.rub38 = this.transfertPaye.getTrfColT38();
      this.rub39 = this.transfertPaye.getTrfColT39();
      this.rub40 = this.transfertPaye.getTrfColT40();
   }

   public void calculSalarie(Session var1) throws HibernateException, NamingException {
      this.salaries = null;
      this.salariesContrats = null;
      this.salariesElements = null;
      if (this.transfertPaye.getTrfColT00() != null && !this.transfertPaye.getTrfColT00().isEmpty()) {
         if (!this.transfertPaye.getTrfColT03().equals("???")) {
            this.salaries = this.salariesDao.chercherIdSalaries(this.transfertPaye.getTrfColT03(), var1);
            if (this.salaries != null) {
               if (this.salaries.getSalFeuille() == null || this.salaries.getSalFeuille().isEmpty() || this.salaries.getSalEtat() > 1 && this.salaries.getSalEtat() != 9) {
                  this.transfertPaye.setTrfNomFeuille("Sal. " + this.salaries.getSalMatricule() + " n`a pas de feuille");
                  this.lesErreurs.add(this.transfertPaye);
                  this.salaries = null;
               } else {
                  this.transfertPaye.setTrfColT03(this.salaries.getSalMatricule());
                  if (this.salaries.getSalPrenom() != null && !this.salaries.getSalPrenom().isEmpty()) {
                     this.transfertPaye.setTrfColT04(this.salaries.getSalNom() + " " + this.salaries.getSalPrenom());
                  } else {
                     this.transfertPaye.setTrfColT04(this.salaries.getSalNom());
                  }

                  this.salaries.setSalActivite(this.transfertPaye.getTrfColT00());
                  if (this.transfertPaye.getTrfColT01() != null && !this.transfertPaye.getTrfColT01().isEmpty()) {
                     if (this.transfertPaye.getTrfColT01().equals("0") || this.transfertPaye.getTrfColT01().equals("1") || this.transfertPaye.getTrfColT01().equals("2") || this.transfertPaye.getTrfColT01().equals("3") || this.transfertPaye.getTrfColT01().equals("4") || this.transfertPaye.getTrfColT01().equals("5") || this.transfertPaye.getTrfColT01().equals("6") || this.transfertPaye.getTrfColT01().equals("7") || this.transfertPaye.getTrfColT01().equals("8") || this.transfertPaye.getTrfColT01().equals("9")) {
                        this.transfertPaye.setTrfColT01("0" + this.transfertPaye.getTrfColT01());
                     }

                     this.service = this.serviceDao.chargerLeServiceCode(this.transfertPaye.getTrfColT01(), var1);
                     if (this.service != null) {
                        this.salaries.setSalService(this.transfertPaye.getTrfColT01());
                        this.salaries.setSalLibService(this.service.getSerNomFr());
                        this.salaries.setSalDepartement(this.service.getDepartement().getDepCode());
                        this.salaries.setSalSite(this.service.getSite().getSitCode());
                     } else {
                        this.salaries.setSalService("");
                        this.salaries.setSalLibService("");
                        this.salaries.setSalDepartement("");
                        this.salaries.setSalSite("");
                     }
                  } else {
                     this.salaries.setSalService("");
                     this.salaries.setSalLibService("");
                     this.salaries.setSalDepartement("");
                     this.salaries.setSalSite("");
                  }

                  this.salaries.setSalLocalisation(this.transfertPaye.getTrfColT02());
                  if (this.transfertPaye.getTrfColN05() != 0.0D) {
                     this.salaries.setSalEtat(9);
                  } else {
                     this.salaries.setSalEtat(0);
                  }

                  this.salaries = this.salariesDao.modif(this.salaries, var1);
                  var1.flush();
                  this.salariesContrats = this.salariesContratsDao.chargerlesContratsActif(this.salaries, var1);
                  if (this.salariesContrats != null) {
                     this.salariesContrats.setSalconActivite(this.salaries.getSalActivite());
                     this.salariesContrats.setSalconService(this.salaries.getSalService());
                     this.salariesContrats.setSalconLibService(this.salaries.getSalLibService());
                     this.salariesContrats.setSalconDepartement(this.salaries.getSalDepartement());
                     this.salariesContrats.setSalconSite(this.salaries.getSalSite());
                     this.salariesContrats.setSalconLocalisation(this.salaries.getSalLocalisation());
                     this.salariesContrats.setSalconEtat(this.salaries.getSalEtat());
                     this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats, var1);
                     var1.flush();
                     this.salariesElements = this.salariesElementsDao.chargerlesVariablesPeriode(this.salaries, this.transfertPaye.getTrfPeriode(), this.salariesContrats.getSalconNum(), var1);
                     if (this.salariesElements == null) {
                        this.salariesElements = new SalariesElements();
                     }

                     if (this.salaries.getSalEtat() <= 1) {
                        this.salariesElements.setSalaries(this.salaries);
                        this.salariesElements.setSaleleActivite(this.salariesContrats.getSalconActivite());
                        this.salariesElements.setSaleleService(this.salariesContrats.getSalconService());
                        this.salariesElements.setSaleleLibService(this.salariesContrats.getSalconLibService());
                        this.salariesElements.setSaleleLocalisation(this.salariesContrats.getSalconLocalisation());
                        this.salariesElements.setSaleleBudget(this.salariesContrats.getSalconBudget());
                        this.salariesElements.setSaleleCentresImpots(this.salariesContrats.getSalconCentresImpots());
                        this.salariesElements.setSaleleCivilite(this.salaries.getSalCivilite());
                        this.salariesElements.setSaleleClassement(this.salariesContrats.getSalconClassement());
                        this.salariesElements.setSaleleCle1Anal(this.salariesContrats.getSalconCle1Anal());
                        this.salariesElements.setSaleleCle2Anal(this.salariesContrats.getSalconCle2Anal());
                        this.salariesElements.setSaleleCleBanque(this.salaries.getSalCleBanque());
                        this.salariesElements.setSaleleCompteMembre("");
                        this.salariesElements.setSaleleContrat(this.salariesContrats.getSalconNum());
                        this.salariesElements.setSaleleConvention(this.salariesContrats.getSalconConvention());
                        this.salariesElements.setSaleleDateConcubinage(this.salaries.getSalDateConcubinage());
                        this.salariesElements.setSaleleDateDivorce(this.salaries.getSalDateDivorce());
                        this.salariesElements.setSaleleDateEntree(this.salaries.getSalDateEntree());
                        this.salariesElements.setSaleleDateMarie(this.salaries.getSalDateMarie());
                        this.salariesElements.setSaleleDatePacs(this.salaries.getSalDatePacs());
                        this.salariesElements.setSaleleDateSortie(this.salaries.getSalDateSortie());
                        this.salariesElements.setSaleleDateVeuf(this.salaries.getSalDateVeuf());
                        this.salariesElements.setSaleleDepartement(this.salariesContrats.getSalconDepartement());
                        this.salariesElements.setSaleleDureeJour(0);
                        this.salariesElements.setSaleleEtat(0);
                        this.salariesElements.setSaleleFeuille(this.salariesContrats.getSalconFeuille());
                        this.salariesElements.setSaleleFonction(this.salariesContrats.getSalconFonction());
                        this.salariesElements.setSaleleGenre(this.salaries.getSalGenre());
                        this.salariesElements.setSaleleGrille(this.salariesContrats.getSalconGrille());
                        this.salariesElements.setSaleleGuichetBanque(this.salaries.getSalGuichetBanque());
                        this.salariesElements.setSaleleIban(this.salaries.getSalIban());
                        this.salariesElements.setSaleleJour((Date)null);
                        this.salariesElements.setSaleleLibCentresImpots(this.salariesContrats.getSalconLibCentresImpots());
                        this.salariesElements.setSaleleLibClassement(this.salariesContrats.getSalconLibClassement());
                        this.salariesElements.setSaleleLibCle1Anal(this.salariesContrats.getSalconLibCle1Anal());
                        this.salariesElements.setSaleleLibCle2Anal(this.salariesContrats.getSalconLibCle2Anal());
                        this.salariesElements.setSaleleLibConvention(this.salariesContrats.getSalconLibConvention());
                        this.salariesElements.setSaleleLibGrille(this.salariesContrats.getSalconLibGrille());
                        this.salariesElements.setSaleleLibNivEmploi(this.salariesContrats.getSalconLibNivEmploi());
                        this.salariesElements.setSaleleLibService(this.salariesContrats.getSalconLibService());
                        this.salariesElements.setSaleleMatricule(this.salaries.getSalMatricule());
                        this.salariesElements.setSaleleModeReglement(this.salaries.getSalModeReglement());
                        this.salariesElements.setSaleleModeSolde(0);
                        this.salariesElements.setSaleleMotifSortie(this.salariesContrats.getSalconMotifSortie());
                        this.salariesElements.setSaleleNature(this.salariesContrats.getSalconType());
                        this.salariesElements.setSaleleNbEnfant(this.salaries.getSalNbEnfant());
                        this.salariesElements.setSaleleNbFemme(this.salaries.getSalNbFemme());
                        this.salariesElements.setSaleleNbJourCp(this.salariesContrats.getSalconNbJourCp());
                        this.salariesElements.setSaleleNbJourTr(this.salariesContrats.getSalconNbJourTr());
                        this.salariesElements.setSaleleNbPartFiscal(this.salaries.getSalNbPartFiscal());
                        this.salariesElements.setSaleleNbPartTrimf(this.salaries.getSalNbPartTrimf());
                        this.salariesElements.setSaleleNivEmploi(this.salariesContrats.getSalconNivEmploi());
                        this.salariesElements.setSaleleNumBanque(this.salaries.getSalNumBanque());
                        this.salariesElements.setSaleleParc(this.salariesContrats.getSalconParc());
                        this.salariesElements.setSalelePeriode(this.transfertPaye.getTrfPeriode());
                        this.salariesElements.setSaleleService(this.salariesContrats.getSalconService());
                        this.salariesElements.setSaleleSitFamille(this.salaries.getSalSitFamille());
                        this.salariesElements.setSaleleSite(this.salariesContrats.getSalconSite());
                        this.salariesElements.setSaleleSwift(this.salaries.getSalSwift());
                        if (this.salariesElements.getSaleleId() == 0L) {
                           this.salariesElements = this.salariesElementsDao.insert(this.salariesElements, var1);
                        } else {
                           this.salariesElements = this.salariesElementsDao.modif(this.salariesElements, var1);
                        }
                     } else {
                        if (this.salariesElements.getSaleleId() != 0L) {
                           this.salariesElementsDao.delete(this.salariesElements, var1);
                           this.salariesContrats = null;
                        }

                        this.transfertPaye.setTrfNomFeuille("Sal. " + this.salaries.getSalMatricule() + " est gelé");
                        this.lesErreurs.add(this.transfertPaye);
                        this.salariesContrats = null;
                        this.salaries = null;
                     }

                     var1.flush();
                  } else {
                     this.transfertPaye.setTrfNomFeuille("Sal. " + this.salaries.getSalMatricule() + " n`a pas de contrat");
                     this.lesErreurs.add(this.transfertPaye);
                     this.salariesContrats = null;
                  }
               }
            } else {
               this.transfertPaye.setTrfNomFeuille("Sal. " + this.transfertPaye.getTrfColT01() + " n`existe pas");
               this.lesErreurs.add(this.transfertPaye);
            }
         } else {
            this.transfertPaye.setTrfNomFeuille("Sal. " + this.transfertPaye.getTrfColT01() + " n`existe pas");
            this.lesErreurs.add(this.transfertPaye);
         }
      }

   }

   public void calculeRubrique(String var1, double var2, int var4, Session var5) throws HibernateException, NamingException {
      if (var1 != null && !var1.isEmpty() && var2 != 0.0D) {
         var1 = this.enlevePoint(var1);
         if (var1.length() == 6) {
            this.planPaye = null;
            boolean var6 = false;
            int var7;
            if (this.lePlanPaye.size() != 0) {
               for(var7 = 0; var7 < this.lePlanPaye.size(); ++var7) {
                  if (((PlanPaye)this.lePlanPaye.get(var7)).getPlpCode().equals(var1)) {
                     this.planPaye = (PlanPaye)this.lePlanPaye.get(var7);
                     var6 = true;
                     break;
                  }
               }
            }

            if (var6) {
               this.feuilleCalculRubrique = null;
               if (this.leFeuilleRubrique.size() != 0) {
                  for(var7 = 0; var7 < this.leFeuilleRubrique.size(); ++var7) {
                     if (((FeuilleCalculRubrique)this.leFeuilleRubrique.get(var7)).getFeurubCode().equals(var1) && ((FeuilleCalculRubrique)this.leFeuilleRubrique.get(var7)).getFeuilleCalcul().getFeuCode().equals(this.salaries.getSalFeuille())) {
                        this.feuilleCalculRubrique = (FeuilleCalculRubrique)this.leFeuilleRubrique.get(var7);
                        break;
                     }
                  }
               }

               this.salariesVariables = this.salariesVariablesDao.chargerlesVariablesPeriodeRubrique(this.salaries, this.transfertPaye.getTrfPeriode(), (String)null, var1, var5);
               if (this.salariesVariables == null) {
                  this.salariesVariables = new SalariesVariables();
               }

               this.salariesVariables.setPlanPaye(this.planPaye);
               this.salariesVariables.setSalaries(this.salaries);
               this.salariesVariables.setSalvarCode(var1);
               if (this.salariesContrats != null) {
                  this.salariesVariables.setSalvarContrat(this.salariesContrats.getSalconNum());
                  if (this.salaries.getSalFeuille() != null && !this.salaries.getSalFeuille().isEmpty()) {
                     String var9 = "";
                     if (var4 == 0) {
                        var9 = this.salariesContrats.getSalconFeuille();
                     } else if (var4 == 1) {
                        var9 = this.salariesContrats.getSalconActivite();
                     } else if (var4 == 2) {
                        var9 = this.salariesContrats.getSalconService();
                     } else if (var4 == 3) {
                        var9 = this.salariesContrats.getSalconProjet();
                     } else if (var4 == 4) {
                        var9 = "" + this.salariesContrats.getSalconIdTiers();
                     }

                     this.salariesVariables.setSalvarFeuille(var9);
                     this.salariesVariables.setSalvarPeriode(this.transfertPaye.getTrfPeriode());
                     if (this.feuilleCalculRubrique != null) {
                        this.salariesVariables.setSalvarVariableA(this.feuilleCalculRubrique.isFeurubVariableA());
                        this.salariesVariables.setSalvarVariableB(this.feuilleCalculRubrique.isFeurubVariableB());
                        this.salariesVariables.setSalvarVariableC(this.feuilleCalculRubrique.isFeurubVariableC());
                        this.salariesVariables.setSalvarVariableD(this.feuilleCalculRubrique.isFeurubVariableD());
                        this.salariesVariables.setSalvarVariableE(this.feuilleCalculRubrique.isFeurubVariableE());
                        this.salariesVariables.setSalvarValeurColA(0.0D);
                        this.salariesVariables.setSalvarValeurColB(0.0D);
                        this.salariesVariables.setSalvarValeurColC(0.0D);
                        this.salariesVariables.setSalvarValeurColD(0.0D);
                        this.salariesVariables.setSalvarValeurColE(0.0D);
                        boolean var8 = true;
                        if (this.salariesVariables.isSalvarVariableA()) {
                           this.salariesVariables.setSalvarValeurColA(var2);
                        } else if (this.salariesVariables.isSalvarVariableB()) {
                           this.salariesVariables.setSalvarValeurColB(var2);
                        } else if (this.salariesVariables.isSalvarVariableC()) {
                           this.salariesVariables.setSalvarValeurColC(var2);
                        } else if (this.salariesVariables.isSalvarVariableD()) {
                           this.salariesVariables.setSalvarValeurColD(var2);
                        } else if (this.salariesVariables.isSalvarVariableE()) {
                           this.salariesVariables.setSalvarValeurColE(var2);
                        } else {
                           var8 = false;
                        }

                        if (var8) {
                           if (this.salariesVariables.getSalvarId() == 0L) {
                              this.salariesVariables = this.salariesVariablesDao.insert(this.salariesVariables, var5);
                           } else {
                              this.salariesVariables = this.salariesVariablesDao.modif(this.salariesVariables, var5);
                           }

                           var5.flush();
                        } else {
                           this.transfertPaye.setTrfNomFeuille("Rub. " + var1 + " n`est pas une variable dans la feuille " + this.salaries.getSalFeuille() + " pour le salarié " + this.salaries.getSalMatricule());
                           this.lesErreurs.add(this.transfertPaye);
                        }
                     } else {
                        this.transfertPaye.setTrfNomFeuille("Rub. " + var1 + " n`est pas dans la feuille " + this.salaries.getSalFeuille());
                        this.lesErreurs.add(this.transfertPaye);
                     }
                  } else {
                     this.transfertPaye.setTrfNomFeuille("Sal. " + this.salaries.getSalMatricule() + " n`est pas de feuille");
                     this.lesErreurs.add(this.transfertPaye);
                  }
               } else {
                  this.transfertPaye.setTrfNomFeuille("Sal. " + this.salaries.getSalMatricule() + " n`est pas de contrat");
                  this.lesErreurs.add(this.transfertPaye);
                  if (this.salariesVariables != null && this.salariesVariables.getSalvarId() != 0L) {
                     this.salariesVariablesDao.delete(this.salariesVariables, var5);
                     var5.flush();
                  }
               }
            } else {
               this.transfertPaye.setTrfNomFeuille("Rub. " + var1 + " n`existe pas");
               this.lesErreurs.add(this.transfertPaye);
            }
         }
      }

   }

   public void importerRubrique() throws HibernateException, NamingException, java.text.ParseException {
      this.lesErreurs.clear();
      if (this.lesTransfertPaye.size() != 0) {
         this.var_showBarProgMaj = true;
         this.var_currentValue = 0;
         this.var_info = "Chargement des elements de base...";
         boolean var1 = false;
         this.salariesVariablesDao = new SalariesVariablesDao(this.baseLog, this.utilInitHibernate);
         this.salariesElementsDao = new SalariesElementsDao(this.baseLog, this.utilInitHibernate);
         this.salariesHistorique = new SalariesHistorique();
         this.salariesHistoriqueDao = new SalariesHistoriqueDao(this.baseLog, this.utilInitHibernate);
         this.salariesContratsDao = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
         String var2 = "";
         String var3 = "";
         Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var5 = null;

         try {
            var5 = var4.beginTransaction();
            var4.setFlushMode(FlushMode.MANUAL);
            int var6 = 0;

            while(true) {
               if (var6 >= this.lesTransfertPaye.size()) {
                  var5.commit();
                  break;
               }

               this.transfertPaye = (TransfertPaye)this.lesTransfertPaye.get(var6);
               this.var_info = "Salarie " + this.transfertPaye.getTrfColT00() + " - Nb elements : " + this.lesTransfertPaye.size();
               double var7;
               if (var6 != 0) {
                  var7 = (double)this.lesTransfertPaye.size();
                  double var9 = this.utilNombre.myRound(var7 / (double)var6, 4);
                  double var11 = this.utilNombre.myRound(100.0D / var9, 2);
                  this.var_currentValue = (int)var11;
               }

               if (var6 == 0) {
                  if (this.transfertPaye.getTrfColT00().equals("CHAMP") && this.transfertPaye.getTrfColT01() != null && !this.transfertPaye.getTrfColT01().isEmpty()) {
                     if (this.transfertPaye.getTrfColT01().startsWith("salhis_")) {
                        var2 = "SalariesHistorique";
                        if (this.transfertPaye.getTrfColT01().contains(":")) {
                           String[] var18 = this.transfertPaye.getTrfColT01().split(":");
                           var3 = var18[1];
                        } else {
                           var3 = "";
                        }
                     } else if (this.transfertPaye.getTrfColT01().startsWith("salcon_")) {
                        var2 = "SalariesContrat";
                        var3 = this.transfertPaye.getTrfColT01();
                     } else if (this.transfertPaye.getTrfColT01().startsWith("salele_")) {
                        var2 = "SalariesElements";
                        var3 = this.transfertPaye.getTrfColT01();
                     }
                  }
               } else {
                  if (this.transfertPaye.getTrfColT00() != null && !this.transfertPaye.getTrfColT00().isEmpty()) {
                     this.salaries = this.salariesDao.chargerlesSalaries(this.calculeMatricule(this.transfertPaye.getTrfColT00()), var4);
                  }

                  if (this.salaries != null) {
                     if (var2.equals("SalariesHistorique")) {
                        var7 = this.conversionDouble(this.transfertPaye.getTrfColT01());
                        boolean var22 = true;
                        if (var3 != null && !var3.isEmpty()) {
                           this.salariesHistorique = this.salariesHistoriqueDao.chargerlesHistoriquesByCode(this.salaries, this.exercicesPaye.getExepayDateDebut(), var3, var4);
                           if (this.salariesHistorique == null) {
                              this.salariesHistorique = new SalariesHistorique();
                           }

                           this.salariesHistorique.setExercicesPaye(this.exercicesPaye);
                           this.salariesHistorique.setSalaries(this.salaries);
                           this.salariesContrats = this.salariesContratsDao.chargerTousLesContrats(this.salaries, var4);
                           if (this.salariesContrats != null) {
                              this.salariesHistorique.setSalhisContrat(this.salariesContrats.getSalconNum());
                           } else {
                              this.salariesHistorique.setSalhisContrat("");
                           }

                           this.salariesHistorique.setSalhisCode(var3);
                           this.salariesHistorique.setSalhisDate(this.exercicesPaye.getExepayDateDebut());
                           if (var3.equals("BRUT")) {
                              this.salariesHistorique.setSalhisLibelle("Salaire Brut");
                           } else if (var3.equals("CP")) {
                              this.salariesHistorique.setSalhisLibelle("Congés Payés");
                           } else if (var3.equals("NBJS")) {
                              this.salariesHistorique.setSalhisLibelle("Nombre de jours de congés acquis");
                           } else if (var3.equals("ADM")) {
                              this.salariesHistorique.setSalhisLibelle("Appoint dernier mois");
                           } else if (var3.equals("PRDCP")) {
                              this.salariesHistorique.setSalhisLibelle("Primes imposables à déduire des CP");
                           } else {
                              this.transfertPaye.setTrfNomFeuille("le rubrique " + var3 + " n`existe pas.");
                              this.lesErreurs.add(this.transfertPaye);
                              var22 = false;
                           }

                           this.salariesHistorique.setSalhisValeurColE(var7);
                           if (var22) {
                              if (this.salariesHistorique.getSalhisId() == 0L) {
                                 this.salariesHistorique.setExercicesPaye(this.exercicesPaye);
                                 this.salariesHistorique.setSalaries(this.salaries);
                                 this.salariesHistorique.setSalhisDate(this.exercicesPaye.getExepayDateDebut());
                                 this.salariesHistorique = this.salariesHistoriqueDao.insert(this.salariesHistorique, var4);
                                 var4.flush();
                              } else {
                                 this.salariesHistorique.setExercicesPaye(this.exercicesPaye);
                                 this.salariesHistorique.setSalaries(this.salaries);
                                 this.salariesHistorique.setSalhisDate(this.exercicesPaye.getExepayDateDebut());
                                 this.salariesHistorique = this.salariesHistoriqueDao.modif(this.salariesHistorique, var4);
                                 var4.flush();
                              }
                           }
                        }
                     } else if (var2.equals("SalariesContrat")) {
                        String var19 = this.transfertPaye.getTrfColT01();
                        new ArrayList();
                        List var8 = this.salariesContratsDao.chargerlesContrats(this.salaries, var4);
                        if (var8.size() != 0) {
                           for(int var23 = 0; var23 < var8.size(); ++var23) {
                              this.salariesContrats = (SalariesContrats)var8.get(var23);
                              this.calculeRubContrat(var3, var19, var4);
                              this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats, var4);
                              var4.flush();
                           }
                        } else {
                           this.transfertPaye.setTrfNomFeuille("les contrats pour " + this.salaries.getSalMatricule() + " n`existent pas.");
                           this.lesErreurs.add(this.transfertPaye);
                        }
                     } else if (var2.equals("SalariesElements")) {
                        boolean var20 = true;
                        String var21 = this.transfertPaye.getTrfColT01();
                        new ArrayList();
                        List var24 = this.salariesElementsDao.chargerlesElementsBySalaries(this.salaries, var4);
                        if (var24.size() != 0) {
                           for(int var10 = 0; var10 < var24.size(); ++var10) {
                              this.salariesElements = (SalariesElements)var24.get(var10);
                              if (var3.equalsIgnoreCase("salele_num_banque")) {
                                 this.salariesElements.setSaleleNumBanque(var21);
                              } else if (var3.equalsIgnoreCase("salele_guichet_banque")) {
                                 this.salariesElements.setSaleleGuichetBanque(var21);
                              } else if (var3.equalsIgnoreCase("salele_compte_banque")) {
                                 this.salariesElements.setSaleleCompteBanque(var21);
                              } else if (var3.equalsIgnoreCase("salele_cle_banque")) {
                                 this.salariesElements.setSaleleCleBanque(var21);
                              } else if (var3.equalsIgnoreCase("salele_compte_membre")) {
                                 this.salariesElements.setSaleleCompteMembre(var21);
                              } else {
                                 this.transfertPaye.setTrfNomFeuille("le rubrique " + var3 + " n`existe pas.");
                                 this.lesErreurs.add(this.transfertPaye);
                                 var20 = false;
                              }

                              if (var20) {
                                 this.salariesElements = this.salariesElementsDao.modif(this.salariesElements, var4);
                                 var4.flush();
                              }
                           }
                        } else {
                           this.transfertPaye.setTrfNomFeuille("les éléments pour " + this.salaries.getSalMatricule() + " n`existent pas.");
                           this.lesErreurs.add(this.transfertPaye);
                        }
                     }
                  } else if (this.salaries == null) {
                     this.transfertPaye.setTrfNomFeuille("le salarié " + this.calculeMatricule(this.transfertPaye.getTrfColT00()) + " n`existe pas.");
                     this.lesErreurs.add(this.transfertPaye);
                  }
               }

               ++var6;
            }
         } catch (HibernateException var16) {
            if (var5 != null) {
               var5.rollback();
            }

            throw var16;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.datamodelDocument.setWrappedData(this.lesErreurs);
         this.var_affiche_bouton = false;
         this.balance = 2;
         this.var_showBarProgMaj = false;
      }

   }

   public void importLibre() throws HibernateException, NamingException, java.text.ParseException {
      this.lesErreurs.clear();
      if (this.lesTransfertPaye.size() != 0) {
         this.var_showBarProgMaj = true;
         this.var_currentValue = 0;
         this.var_info = "Chargement des elements de base...";
         boolean var1 = false;
         this.salariesContratsDao = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
         this.feuilleCalculDao = new FeuilleCalculDao(this.baseLog, this.utilInitHibernate);
         this.feuilleCalcul = new FeuilleCalcul();
         this.site = new Site();
         this.siteDao = new SiteDao(this.baseLog, this.utilInitHibernate);
         this.departement = new Departement();
         this.departementDao = new DepartementDao(this.baseLog, this.utilInitHibernate);
         this.service = new Service();
         this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
         this.activites = new Activites();
         this.activitesDao = new ActivitesDao(this.baseLog, this.utilInitHibernate);
         this.localisationSalarie = new LocalisationSalarie();
         this.localisationSalarieDao = new LocalisationSalarieDao(this.baseLog, this.utilInitHibernate);
         this.budget = new Budget();
         this.budgetDao = new BudgetDao(this.baseLog, this.utilInitHibernate);
         this.parc = new Parc();
         this.parcDao = new ParcDao(this.baseLog, this.utilInitHibernate);
         this.lectureConventions = new LectureConventions();
         this.lectureConventions.setStrId(this.structureLog.getStrid());
         this.lectureConventions.setStructureLog(this.structureLog);
         this.lectureConventions.recuperePaye();
         this.lectureCentresImpots = new LectureCentresImpots();
         this.lectureCentresImpots.setStructureLog(this.structureLog);
         this.lectureCentresImpots.recuperePaye();
         this.lectureCentresSecuriteSociale = new LectureCentresSecuriteSociale();
         this.lectureCentresSecuriteSociale.setStructureLog(this.structureLog);
         this.lectureCentresSecuriteSociale.recuperePaye();
         this.lectureClassementsAgents = new LectureClassementsAgents();
         this.lectureClassementsAgents.setStructureLog(this.structureLog);
         this.lectureClassementsAgents.recuperePaye();
         this.lectureNiveauxEmplois = new LectureNiveauxEmplois();
         this.lectureNiveauxEmplois.setStrId(this.structureLog.getStrid());
         this.lectureNiveauxEmplois.setStructureLog(this.structureLog);
         this.lectureNiveauxEmplois.recuperePaye();
         this.projets = new Projets();
         this.projetsDao = new ProjetsDao(this.baseLog, this.utilInitHibernate);
         this.plansAnalytiques = new PlansAnalytiques();
         this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
         String var2 = "";
         String var3 = "";
         String var4 = "";
         String var5 = "";
         String var6 = "";
         String var7 = "";
         String var8 = "";
         String var9 = "";
         String var10 = "";
         String var11 = "";
         String var12 = "";
         String var13 = "";
         String var14 = "";
         String var15 = "";
         String var16 = "";
         String var17 = "";
         String var18 = "";
         String var19 = "";
         String var20 = "";
         String var21 = "";
         String var22 = "";
         String var23 = "";
         String var24 = "";
         String var25 = "";
         String var26 = "";
         String var27 = "";
         String var28 = "";
         String var29 = "";
         String var30 = "";
         String var31 = "";
         String var32 = "";
         String var33 = "";
         String var34 = "";
         String var35 = "";
         String var36 = "";
         String var37 = "";
         String var38 = "";
         String var39 = "";
         String var40 = "";
         String var41 = "";
         String var42 = "";
         String var43 = "";
         String var44 = "";
         Session var45 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var46 = null;

         try {
            var46 = var45.beginTransaction();
            var45.setFlushMode(FlushMode.MANUAL);

            for(int var47 = 0; var47 < this.lesTransfertPaye.size(); ++var47) {
               this.transfertPaye = (TransfertPaye)this.lesTransfertPaye.get(var47);
               this.var_info = "Element " + var47 + " - Nb elements : " + this.lesTransfertPaye.size();
               if (var47 != 0) {
                  double var48 = (double)this.lesTransfertPaye.size();
                  double var50 = this.utilNombre.myRound(var48 / (double)var47, 4);
                  double var52 = this.utilNombre.myRound(100.0D / var50, 2);
                  this.var_currentValue = (int)var52;
               }

               if (var47 == 0) {
                  var4 = this.transfertPaye.getTrfColT00();
                  var5 = this.transfertPaye.getTrfColT01();
                  var6 = this.transfertPaye.getTrfColT02();
                  var7 = this.transfertPaye.getTrfColT03();
                  var8 = this.transfertPaye.getTrfColT04();
                  var9 = this.transfertPaye.getTrfColT05();
                  var10 = this.transfertPaye.getTrfColT06();
                  var11 = this.transfertPaye.getTrfColT07();
                  var12 = this.transfertPaye.getTrfColT08();
                  var13 = this.transfertPaye.getTrfColT09();
                  var14 = this.transfertPaye.getTrfColT10();
                  var15 = this.transfertPaye.getTrfColT11();
                  var16 = this.transfertPaye.getTrfColT12();
                  var17 = this.transfertPaye.getTrfColT13();
                  var18 = this.transfertPaye.getTrfColT14();
                  var19 = this.transfertPaye.getTrfColT15();
                  var20 = this.transfertPaye.getTrfColT16();
                  var21 = this.transfertPaye.getTrfColT17();
                  var22 = this.transfertPaye.getTrfColT18();
                  var23 = this.transfertPaye.getTrfColT19();
                  var24 = this.transfertPaye.getTrfColT20();
                  var25 = this.transfertPaye.getTrfColT21();
                  var26 = this.transfertPaye.getTrfColT22();
                  var27 = this.transfertPaye.getTrfColT23();
                  var28 = this.transfertPaye.getTrfColT24();
                  var29 = this.transfertPaye.getTrfColT25();
                  var30 = this.transfertPaye.getTrfColT26();
                  var31 = this.transfertPaye.getTrfColT27();
                  var32 = this.transfertPaye.getTrfColT28();
                  var33 = this.transfertPaye.getTrfColT29();
                  var34 = this.transfertPaye.getTrfColT30();
                  var35 = this.transfertPaye.getTrfColT31();
                  var36 = this.transfertPaye.getTrfColT32();
                  var37 = this.transfertPaye.getTrfColT33();
                  var38 = this.transfertPaye.getTrfColT34();
                  var39 = this.transfertPaye.getTrfColT35();
                  var40 = this.transfertPaye.getTrfColT36();
                  var41 = this.transfertPaye.getTrfColT37();
                  var42 = this.transfertPaye.getTrfColT38();
                  var43 = this.transfertPaye.getTrfColT39();
                  var44 = this.transfertPaye.getTrfColT40();
               } else {
                  boolean var59 = this.recherhceSalarie(var4, this.transfertPaye.getTrfColT00(), var45);
                  if (this.salaries != null) {
                     if (var47 == 1280) {
                        boolean var49 = false;
                     }

                     this.salariesContrats = null;
                     String var60 = "";
                     if (var6 != null && !var6.isEmpty()) {
                        var60 = var6;
                     } else {
                        var60 = var5;
                     }

                     if (var60.startsWith("sal_")) {
                        if (var5 != null && !var5.isEmpty()) {
                           this.calculeRubSalarie(var5, this.transfertPaye.getTrfColT01(), var45);
                        }

                        if (var6 != null && !var6.isEmpty()) {
                           this.calculeRubSalarie(var6, this.transfertPaye.getTrfColT02(), var45);
                        }

                        if (var7 != null && !var7.isEmpty()) {
                           this.calculeRubSalarie(var7, this.transfertPaye.getTrfColT03(), var45);
                        }

                        if (var8 != null && !var8.isEmpty()) {
                           this.calculeRubSalarie(var8, this.transfertPaye.getTrfColT04(), var45);
                        }

                        if (var9 != null && !var9.isEmpty()) {
                           this.calculeRubSalarie(var9, this.transfertPaye.getTrfColT05(), var45);
                        }

                        if (var10 != null && !var10.isEmpty()) {
                           this.calculeRubSalarie(var10, this.transfertPaye.getTrfColT06(), var45);
                        }

                        if (var11 != null && !var11.isEmpty()) {
                           this.calculeRubSalarie(var11, this.transfertPaye.getTrfColT07(), var45);
                        }

                        if (var12 != null && !var12.isEmpty()) {
                           this.calculeRubSalarie(var12, this.transfertPaye.getTrfColT08(), var45);
                        }

                        if (var13 != null && !var13.isEmpty()) {
                           this.calculeRubSalarie(var13, this.transfertPaye.getTrfColT09(), var45);
                        }

                        if (var14 != null && !var14.isEmpty()) {
                           this.calculeRubSalarie(var14, this.transfertPaye.getTrfColT10(), var45);
                        }

                        if (var15 != null && !var15.isEmpty()) {
                           this.calculeRubSalarie(var15, this.transfertPaye.getTrfColT11(), var45);
                        }

                        if (var16 != null && !var16.isEmpty()) {
                           this.calculeRubSalarie(var16, this.transfertPaye.getTrfColT12(), var45);
                        }

                        if (var17 != null && !var17.isEmpty()) {
                           this.calculeRubSalarie(var17, this.transfertPaye.getTrfColT13(), var45);
                        }

                        if (var18 != null && !var18.isEmpty()) {
                           this.calculeRubSalarie(var18, this.transfertPaye.getTrfColT14(), var45);
                        }

                        if (var19 != null && !var19.isEmpty()) {
                           this.calculeRubSalarie(var19, this.transfertPaye.getTrfColT15(), var45);
                        }

                        if (var20 != null && !var20.isEmpty()) {
                           this.calculeRubSalarie(var20, this.transfertPaye.getTrfColT16(), var45);
                        }

                        if (var21 != null && !var21.isEmpty()) {
                           this.calculeRubSalarie(var21, this.transfertPaye.getTrfColT17(), var45);
                        }

                        if (var22 != null && !var22.isEmpty()) {
                           this.calculeRubSalarie(var22, this.transfertPaye.getTrfColT18(), var45);
                        }

                        if (var23 != null && !var23.isEmpty()) {
                           this.calculeRubSalarie(var23, this.transfertPaye.getTrfColT19(), var45);
                        }

                        if (var24 != null && !var24.isEmpty()) {
                           this.calculeRubSalarie(var24, this.transfertPaye.getTrfColT20(), var45);
                        }

                        if (var25 != null && !var25.isEmpty()) {
                           this.calculeRubSalarie(var25, this.transfertPaye.getTrfColT21(), var45);
                        }

                        if (var26 != null && !var26.isEmpty()) {
                           this.calculeRubSalarie(var26, this.transfertPaye.getTrfColT22(), var45);
                        }

                        if (var27 != null && !var27.isEmpty()) {
                           this.calculeRubSalarie(var27, this.transfertPaye.getTrfColT23(), var45);
                        }

                        if (var28 != null && !var28.isEmpty()) {
                           this.calculeRubSalarie(var28, this.transfertPaye.getTrfColT24(), var45);
                        }

                        if (var29 != null && !var29.isEmpty()) {
                           this.calculeRubSalarie(var29, this.transfertPaye.getTrfColT25(), var45);
                        }

                        if (var30 != null && !var30.isEmpty()) {
                           this.calculeRubSalarie(var30, this.transfertPaye.getTrfColT26(), var45);
                        }

                        if (var31 != null && !var31.isEmpty()) {
                           this.calculeRubSalarie(var31, this.transfertPaye.getTrfColT27(), var45);
                        }

                        if (var32 != null && !var32.isEmpty()) {
                           this.calculeRubSalarie(var32, this.transfertPaye.getTrfColT28(), var45);
                        }

                        if (var33 != null && !var33.isEmpty()) {
                           this.calculeRubSalarie(var33, this.transfertPaye.getTrfColT29(), var45);
                        }

                        if (var34 != null && !var34.isEmpty()) {
                           this.calculeRubSalarie(var34, this.transfertPaye.getTrfColT30(), var45);
                        }

                        if (var35 != null && !var35.isEmpty()) {
                           this.calculeRubSalarie(var35, this.transfertPaye.getTrfColT31(), var45);
                        }

                        if (var36 != null && !var36.isEmpty()) {
                           this.calculeRubSalarie(var36, this.transfertPaye.getTrfColT32(), var45);
                        }

                        if (var37 != null && !var37.isEmpty()) {
                           this.calculeRubSalarie(var37, this.transfertPaye.getTrfColT33(), var45);
                        }

                        if (var38 != null && !var38.isEmpty()) {
                           this.calculeRubSalarie(var38, this.transfertPaye.getTrfColT34(), var45);
                        }

                        if (var39 != null && !var39.isEmpty()) {
                           this.calculeRubSalarie(var39, this.transfertPaye.getTrfColT35(), var45);
                        }

                        if (var40 != null && !var40.isEmpty()) {
                           this.calculeRubSalarie(var40, this.transfertPaye.getTrfColT36(), var45);
                        }

                        if (var41 != null && !var41.isEmpty()) {
                           this.calculeRubSalarie(var41, this.transfertPaye.getTrfColT37(), var45);
                        }

                        if (var42 != null && !var42.isEmpty()) {
                           this.calculeRubSalarie(var42, this.transfertPaye.getTrfColT38(), var45);
                        }

                        if (var43 != null && !var43.isEmpty()) {
                           this.calculeRubSalarie(var43, this.transfertPaye.getTrfColT39(), var45);
                        }

                        if (var44 != null && !var44.isEmpty()) {
                           this.calculeRubSalarie(var44, this.transfertPaye.getTrfColT40(), var45);
                        }

                        if (!var59) {
                           this.salaries.setSalDateCreat(new Date());
                           this.salaries.setSalUserCreat(this.usersLog.getUsrid());
                           this.salaries.setExercicesPaye(this.exercicesPaye);
                           this.salaries = this.salariesDao.insert(this.salaries, var45);
                        } else {
                           this.salaries.setSalDateModif(new Date());
                           this.salaries.setSalUserModif(this.usersLog.getUsrid());
                           this.salaries = this.salariesDao.modif(this.salaries, var45);
                        }

                        var45.flush();
                     } else if (!var59 && var60.startsWith("salcon_")) {
                        this.transfertPaye.setTrfNomFeuille("le salarié " + this.transfertPaye.getTrfColT00() + " n`existe pas.");
                        this.transfertPaye.setTrfPeriode("");
                        this.transfertPaye.setTrfColT00(this.salaries.getSalActivite());
                        this.transfertPaye.setTrfColT01(this.salaries.getSalMatricule());
                        this.transfertPaye.setTrfColT02(this.salaries.getPatronyme());
                        this.lesErreurs.add(this.transfertPaye);
                     } else if (var59 && var60.startsWith("salcon_")) {
                        boolean var61 = false;
                        new ArrayList();
                        List var51 = this.salariesContratsDao.chargerlesContrats(this.salaries, var45);
                        if (var51.size() != 0) {
                           for(int var62 = 0; var62 < var51.size(); ++var62) {
                              if (((SalariesContrats)var51.get(var62)).getSalconEtat() == 0) {
                                 this.salariesContrats = (SalariesContrats)var51.get(var62);
                                 var61 = true;
                                 break;
                              }
                           }
                        }

                        if (!var61) {
                           this.salariesContrats = new SalariesContrats();
                        }

                        if (var5 != null && !var5.isEmpty()) {
                           var61 = this.calculeRubContrat(var5, this.transfertPaye.getTrfColT01(), var45);
                        }

                        if (var6 != null && !var6.isEmpty()) {
                           var61 = this.calculeRubContrat(var6, this.transfertPaye.getTrfColT02(), var45);
                        }

                        if (var7 != null && !var7.isEmpty()) {
                           var61 = this.calculeRubContrat(var7, this.transfertPaye.getTrfColT03(), var45);
                        }

                        if (var8 != null && !var8.isEmpty()) {
                           var61 = this.calculeRubContrat(var8, this.transfertPaye.getTrfColT04(), var45);
                        }

                        if (var9 != null && !var9.isEmpty()) {
                           var61 = this.calculeRubContrat(var9, this.transfertPaye.getTrfColT05(), var45);
                        }

                        if (var10 != null && !var10.isEmpty()) {
                           var61 = this.calculeRubContrat(var10, this.transfertPaye.getTrfColT06(), var45);
                        }

                        if (var11 != null && !var11.isEmpty()) {
                           var61 = this.calculeRubContrat(var11, this.transfertPaye.getTrfColT07(), var45);
                        }

                        if (var12 != null && !var12.isEmpty()) {
                           var61 = this.calculeRubContrat(var12, this.transfertPaye.getTrfColT08(), var45);
                        }

                        if (var13 != null && !var13.isEmpty()) {
                           var61 = this.calculeRubContrat(var13, this.transfertPaye.getTrfColT09(), var45);
                        }

                        if (var14 != null && !var14.isEmpty()) {
                           var61 = this.calculeRubContrat(var14, this.transfertPaye.getTrfColT10(), var45);
                        }

                        if (var15 != null && !var15.isEmpty()) {
                           var61 = this.calculeRubContrat(var15, this.transfertPaye.getTrfColT11(), var45);
                        }

                        if (var16 != null && !var16.isEmpty()) {
                           var61 = this.calculeRubContrat(var16, this.transfertPaye.getTrfColT12(), var45);
                        }

                        if (var17 != null && !var17.isEmpty()) {
                           var61 = this.calculeRubContrat(var17, this.transfertPaye.getTrfColT13(), var45);
                        }

                        if (var18 != null && !var18.isEmpty()) {
                           var61 = this.calculeRubContrat(var18, this.transfertPaye.getTrfColT14(), var45);
                        }

                        if (var19 != null && !var19.isEmpty()) {
                           var61 = this.calculeRubContrat(var19, this.transfertPaye.getTrfColT15(), var45);
                        }

                        if (var20 != null && !var20.isEmpty()) {
                           var61 = this.calculeRubContrat(var20, this.transfertPaye.getTrfColT16(), var45);
                        }

                        if (var21 != null && !var21.isEmpty()) {
                           var61 = this.calculeRubContrat(var21, this.transfertPaye.getTrfColT17(), var45);
                        }

                        if (var22 != null && !var22.isEmpty()) {
                           var61 = this.calculeRubContrat(var22, this.transfertPaye.getTrfColT18(), var45);
                        }

                        if (var23 != null && !var23.isEmpty()) {
                           var61 = this.calculeRubContrat(var23, this.transfertPaye.getTrfColT19(), var45);
                        }

                        if (var24 != null && !var24.isEmpty()) {
                           var61 = this.calculeRubContrat(var24, this.transfertPaye.getTrfColT20(), var45);
                        }

                        if (var25 != null && !var25.isEmpty()) {
                           var61 = this.calculeRubContrat(var25, this.transfertPaye.getTrfColT21(), var45);
                        }

                        if (var26 != null && !var26.isEmpty()) {
                           var61 = this.calculeRubContrat(var26, this.transfertPaye.getTrfColT22(), var45);
                        }

                        if (var27 != null && !var27.isEmpty()) {
                           var61 = this.calculeRubContrat(var27, this.transfertPaye.getTrfColT23(), var45);
                        }

                        if (var28 != null && !var28.isEmpty()) {
                           var61 = this.calculeRubContrat(var28, this.transfertPaye.getTrfColT24(), var45);
                        }

                        if (var29 != null && !var29.isEmpty()) {
                           var61 = this.calculeRubContrat(var29, this.transfertPaye.getTrfColT25(), var45);
                        }

                        if (var30 != null && !var30.isEmpty()) {
                           var61 = this.calculeRubContrat(var30, this.transfertPaye.getTrfColT26(), var45);
                        }

                        if (var31 != null && !var31.isEmpty()) {
                           var61 = this.calculeRubContrat(var31, this.transfertPaye.getTrfColT27(), var45);
                        }

                        if (var32 != null && !var32.isEmpty()) {
                           var61 = this.calculeRubContrat(var32, this.transfertPaye.getTrfColT28(), var45);
                        }

                        if (var33 != null && !var33.isEmpty()) {
                           var61 = this.calculeRubContrat(var33, this.transfertPaye.getTrfColT29(), var45);
                        }

                        if (var34 != null && !var34.isEmpty()) {
                           var61 = this.calculeRubContrat(var34, this.transfertPaye.getTrfColT30(), var45);
                        }

                        if (var35 != null && !var35.isEmpty()) {
                           var61 = this.calculeRubContrat(var35, this.transfertPaye.getTrfColT31(), var45);
                        }

                        if (var36 != null && !var36.isEmpty()) {
                           var61 = this.calculeRubContrat(var36, this.transfertPaye.getTrfColT32(), var45);
                        }

                        if (var37 != null && !var37.isEmpty()) {
                           var61 = this.calculeRubContrat(var37, this.transfertPaye.getTrfColT33(), var45);
                        }

                        if (var38 != null && !var38.isEmpty()) {
                           var61 = this.calculeRubContrat(var38, this.transfertPaye.getTrfColT34(), var45);
                        }

                        if (var39 != null && !var39.isEmpty()) {
                           var61 = this.calculeRubContrat(var39, this.transfertPaye.getTrfColT35(), var45);
                        }

                        if (var40 != null && !var40.isEmpty()) {
                           var61 = this.calculeRubContrat(var40, this.transfertPaye.getTrfColT36(), var45);
                        }

                        if (var41 != null && !var41.isEmpty()) {
                           var61 = this.calculeRubContrat(var41, this.transfertPaye.getTrfColT37(), var45);
                        }

                        if (var42 != null && !var42.isEmpty()) {
                           var61 = this.calculeRubContrat(var42, this.transfertPaye.getTrfColT38(), var45);
                        }

                        if (var43 != null && !var43.isEmpty()) {
                           var61 = this.calculeRubContrat(var43, this.transfertPaye.getTrfColT39(), var45);
                        }

                        if (var44 != null && !var44.isEmpty()) {
                           var61 = this.calculeRubContrat(var44, this.transfertPaye.getTrfColT40(), var45);
                        }

                        if (!var61) {
                           String var63 = this.calculChrono.numCompose(new Date(), 82, "", var45);
                           this.salariesContrats.setSalconDateCreat(new Date());
                           this.salariesContrats.setSalconUserCreat(this.usersLog.getUsrid());
                           this.salariesContrats.setSalaries(this.salaries);
                           this.salariesContrats.setSalconNum(var63);
                           this.salariesContrats = this.salariesContratsDao.insert(this.salariesContrats, var45);
                        } else {
                           this.salariesContrats.setSalconDateModif(new Date());
                           this.salariesContrats.setSalconUserModif(this.usersLog.getUsrid());
                           this.salariesContrats = this.salariesContratsDao.modif(this.salariesContrats, var45);
                        }

                        var45.flush();
                     }
                  }
               }
            }

            var46.commit();
         } catch (HibernateException var57) {
            if (var46 != null) {
               var46.rollback();
            }

            throw var57;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.datamodelDocument.setWrappedData(this.lesErreurs);
         this.var_affiche_bouton = false;
         this.balance = 2;
         this.var_showBarProgMaj = false;
      }

   }

   public void transfertImportPointageOmega() throws HibernateException, NamingException, java.text.ParseException {
      this.lesErreurs.clear();
      if (this.lesTransfertPaye.size() != 0) {
         int var1 = Integer.parseInt(this.optionPaye.getModeTravail());
         this.var_showBarProgMaj = true;
         this.var_currentValue = 0;
         this.var_info = "Chargement des elements pointage OMEGA...";
         boolean var2 = false;
         this.salariesContratsDao = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
         this.planPayeDao = new PlanPayeDao(this.baseLog, this.utilInitHibernate);
         this.salariesVariablesDao = new SalariesVariablesDao(this.baseLog, this.utilInitHibernate);
         this.feuilleCalculDao = new FeuilleCalculDao(this.baseLog, this.utilInitHibernate);
         this.feuilleCalcul = new FeuilleCalcul();
         this.lectureConventions = new LectureConventions();
         this.lectureConventions.setStrId(this.structureLog.getStrid());
         this.lectureConventions.setStructureLog(this.structureLog);
         this.lectureConventions.recuperePaye();
         this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
         new SalariesPointage();
         SalariesPointageDao var4 = new SalariesPointageDao(this.baseLog, this.utilInitHibernate);
         this.salaries = null;
         String var5 = "";
         String var6 = "";
         String var7 = "";
         String var8 = "";
         String var9 = "";
         String var10 = "";
         String var11 = "";
         String var12 = "";
         String var13 = "";
         String var14 = "";
         String var15 = "";
         String var16 = "";
         String var17 = "";
         String var18 = "";
         String var19 = "";
         String var20 = "";
         String var21 = "";
         String var22 = "";
         String var23 = "";
         String var24 = "";
         String var25 = "";
         String var26 = "";
         String var27 = "";
         String var28 = "";
         String var29 = "";
         String var30 = "";
         String var31 = "";
         String var32 = "";
         String var33 = "";
         String var34 = "";
         String var35 = "";
         String var36 = "";
         String var37 = "";
         String var38 = "";
         String var39 = "";
         String var40 = "";
         String var41 = "";
         String var42 = "";
         String var43 = "";
         String var44 = "";
         String var45 = "";
         String var46 = "";
         String var47 = "";
         Session var48 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
         Transaction var49 = null;

         try {
            var49 = var48.beginTransaction();
            var48.setFlushMode(FlushMode.MANUAL);

            for(int var50 = 0; var50 < this.lesTransfertPaye.size(); ++var50) {
               this.transfertPaye = (TransfertPaye)this.lesTransfertPaye.get(var50);
               if (this.transfertPaye.getTrfColT00() != null && !this.transfertPaye.getTrfColT00().isEmpty() && this.transfertPaye.getTrfColT00().equals("POINTAGE-OMEGA") && this.transfertPaye.getTrfColT01() != null && !this.transfertPaye.getTrfColT01().isEmpty() && this.transfertPaye.getTrfColT01().equals("Matricule") && this.transfertPaye.getTrfColT03() != null && !this.transfertPaye.getTrfColT03().isEmpty() && !this.transfertPaye.getTrfColT03().equals("0.0")) {
                  this.jrPaye = 0.0F;
                  this.nbPanier = 0.0F;
                  this.nbChantier = 0.0F;
                  this.nbAssiduite = 0.0F;
                  this.nbNuit = 0.0F;
                  this.nbHeure10 = 0.0D;
                  this.nbHeure30 = 0.0D;
                  this.nbHeure40 = 0.0D;
                  this.nbHeure60 = 0.0D;
                  boolean var51 = false;
                  var51 = this.recherhceSalarie("sal_matricule", this.transfertPaye.getTrfColT03(), var48);
                  if (!var51) {
                     this.salaries = null;
                  }
               }

               if (this.salaries != null) {
                  this.var_info = "Agent:" + this.salaries.getSalMatricule() + " - Element " + var50 + " - Nb elements : " + this.lesTransfertPaye.size();
                  if (var50 != 0) {
                     double var68 = (double)this.lesTransfertPaye.size();
                     double var53 = this.utilNombre.myRound(var68 / (double)var50, 4);
                     double var55 = this.utilNombre.myRound(100.0D / var53, 2);
                     this.var_currentValue = (int)var55;
                  }

                  if (this.transfertPaye.getTrfColT00() == null || this.transfertPaye.getTrfColT00().isEmpty() || !this.transfertPaye.getTrfColT00().startsWith("Di") && !this.transfertPaye.getTrfColT00().endsWith("di")) {
                     if (this.transfertPaye.getTrfColT04() != null && !this.transfertPaye.getTrfColT04().isEmpty() && this.transfertPaye.getTrfColT04().equals("JOURS A PAYER")) {
                        if (this.transfertPaye.getTrfColT06() != null && !this.transfertPaye.getTrfColT06().isEmpty()) {
                           this.jrPaye = this.conversionFloat(this.transfertPaye.getTrfColT06());
                        }
                     } else if (this.transfertPaye.getTrfColT00() != null && !this.transfertPaye.getTrfColT00().isEmpty() && this.transfertPaye.getTrfColT00().equals("PANIER")) {
                        if (this.transfertPaye.getTrfColT02() != null && !this.transfertPaye.getTrfColT02().isEmpty()) {
                           this.nbPanier = this.conversionFloat(this.transfertPaye.getTrfColT02());
                        }
                     } else if (this.transfertPaye.getTrfColT00() != null && !this.transfertPaye.getTrfColT00().isEmpty() && this.transfertPaye.getTrfColT00().equals("CHANTIER")) {
                        if (this.transfertPaye.getTrfColT02() != null && !this.transfertPaye.getTrfColT02().isEmpty()) {
                           this.nbChantier = this.conversionFloat(this.transfertPaye.getTrfColT02());
                        }
                     } else if (this.transfertPaye.getTrfColT00() != null && !this.transfertPaye.getTrfColT00().isEmpty() && this.transfertPaye.getTrfColT00().equals("ASSIDUITE")) {
                        if (this.transfertPaye.getTrfColT02() != null && !this.transfertPaye.getTrfColT02().isEmpty()) {
                           this.nbAssiduite = this.conversionFloat(this.transfertPaye.getTrfColT02());
                        }
                     } else if (this.transfertPaye.getTrfColT00() != null && !this.transfertPaye.getTrfColT00().isEmpty() && this.transfertPaye.getTrfColT00().equals("NUIT")) {
                        if (this.transfertPaye.getTrfColT02() != null && !this.transfertPaye.getTrfColT02().isEmpty()) {
                           this.nbNuit = this.conversionFloat(this.transfertPaye.getTrfColT02());
                        }
                     } else if (this.transfertPaye.getTrfColT08() != null && !this.transfertPaye.getTrfColT08().isEmpty() && this.transfertPaye.getTrfColT08().equals("TOTAL")) {
                        if (this.transfertPaye.getTrfColT10() != null && !this.transfertPaye.getTrfColT10().isEmpty()) {
                           this.nbHeure10 = this.conversionDouble(this.conversionHeure(this.transfertPaye.getTrfColT10()));
                        }

                        if (this.transfertPaye.getTrfColT11() != null && !this.transfertPaye.getTrfColT11().isEmpty()) {
                           this.nbHeure30 = this.conversionDouble(this.conversionHeure(this.transfertPaye.getTrfColT11()));
                        }

                        if (this.transfertPaye.getTrfColT12() != null && !this.transfertPaye.getTrfColT12().isEmpty()) {
                           this.nbHeure40 = this.conversionDouble(this.conversionHeure(this.transfertPaye.getTrfColT12()));
                        }

                        if (this.transfertPaye.getTrfColT13() != null && !this.transfertPaye.getTrfColT13().isEmpty()) {
                           this.nbHeure60 = this.conversionDouble(this.conversionHeure(this.transfertPaye.getTrfColT13()));
                        }

                        this.majVariablesOmega("100000", (double)this.jrPaye, var1, var48);
                        this.majVariablesOmega("105563", (double)this.nbPanier, var1, var48);
                        this.majVariablesOmega("105664", (double)this.nbChantier, var1, var48);
                        this.majVariablesOmega("105010", (double)this.nbAssiduite, var1, var48);
                        this.majVariablesOmega("105240", (double)this.nbNuit, var1, var48);
                        this.majVariablesOmega("100100", this.nbHeure10, var1, var48);
                        this.majVariablesOmega("100300", this.nbHeure30, var1, var48);
                        this.majVariablesOmega("100400", this.nbHeure40, var1, var48);
                        this.majVariablesOmega("100600", this.nbHeure60, var1, var48);
                     }
                  } else {
                     Date var69 = this.conversionDate(this.transfertPaye.getTrfColT01());
                     String var52 = this.enlevePoint(this.transfertPaye.getTrfColT02());
                     String var70 = "";
                     String var54 = "";
                     String var71 = "";
                     boolean var56 = false;
                     if (this.transfertPaye.getTrfColT08() == null || this.transfertPaye.getTrfColT08().isEmpty() || this.transfertPaye.getTrfColT08().equals("-") || this.transfertPaye.getTrfColT08().equals("FERIE")) {
                        var56 = true;
                     }

                     if (this.transfertPaye.getTrfColT05() != null && !this.transfertPaye.getTrfColT05().isEmpty() && !this.transfertPaye.getTrfColT05().equals("-") && !this.transfertPaye.getTrfColT05().equals("FERIE")) {
                        var70 = this.conversionHeure(this.transfertPaye.getTrfColT05());
                     } else {
                        var70 = this.conversionHeure("00:00");
                     }

                     if (this.transfertPaye.getTrfColT06() != null && !this.transfertPaye.getTrfColT06().isEmpty() && !this.transfertPaye.getTrfColT06().equals("-") && !this.transfertPaye.getTrfColT06().equals("FERIE")) {
                        var54 = this.conversionHeure(this.transfertPaye.getTrfColT06());
                     } else {
                        var54 = this.conversionHeure("00:00");
                     }

                     if (this.transfertPaye.getTrfColT07() != null && !this.transfertPaye.getTrfColT07().isEmpty() && !this.transfertPaye.getTrfColT07().equals("-") && !this.transfertPaye.getTrfColT07().equals("FERIE")) {
                        var71 = this.conversionHeure(this.transfertPaye.getTrfColT07());
                     } else {
                        var71 = this.conversionHeure("00:00");
                     }

                     SalariesPointage var3 = var4.pointageJourBySalarie(this.salaries, var69, var48);
                     if (var3 == null) {
                        var3 = new SalariesPointage();
                        var3.setSalpoiDateCreat(new Date());
                     } else {
                        var3.setSalpoiDateModif(new Date());
                     }

                     var3.setExercicesPaye(this.exercicesPaye);
                     var3.setSalaries(this.salaries);
                     var3.setSalpoiDate(var69);
                     var3.setSalpoiEtat(1);
                     if (var56) {
                        var3.setSalpoiType(1);
                     } else {
                        var3.setSalpoiType(0);
                     }

                     String[] var57 = var70.split(":");
                     var3.setSalpoiHeureDebut(Integer.parseInt(var57[0]));
                     var3.setSalpoiMinuteDebut(Integer.parseInt(var57[1]));
                     String[] var58 = var54.split(":");
                     var3.setSalpoiHeureFin(Integer.parseInt(var58[0]));
                     var3.setSalpoiMinuteFin(Integer.parseInt(var58[1]));
                     String[] var59 = var71.split(":");
                     float var60 = Float.parseFloat(var59[0] + "." + var59[1]);
                     var3.setSalpoiDuree(var60);
                     var3.setSalpoiNature(0);
                     String var61 = "";
                     if (var3.getSalpoiDate().getMonth() + 1 <= 9) {
                        var61 = "0" + (var3.getSalpoiDate().getMonth() + 1);
                     } else {
                        var61 = "" + (var3.getSalpoiDate().getMonth() + 1);
                     }

                     String var62 = "" + (var3.getSalpoiDate().getYear() + 1900);
                     this.periode = var61 + ":" + var62;
                     var3.setSalpoiPeriode(this.periode);
                     var3.setSalpoiObjet(var52);
                     var3.setSalpoiUserCreat(this.usersLog.getUsrid());
                     if (var3.getSalpoiId() == 0L) {
                        var4.insert(var3, var48);
                     } else {
                        var4.modif(var3, var48);
                     }

                     var48.flush();
                  }
               }
            }

            var49.commit();
         } catch (HibernateException var66) {
            if (var49 != null) {
               var49.rollback();
            }

            throw var66;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.datamodelDocument.setWrappedData(this.lesErreurs);
         this.var_affiche_bouton = false;
         this.balance = 2;
         this.var_showBarProgMaj = false;
      }

   }

   public void majVariablesOmega(String var1, double var2, int var4, Session var5) throws HibernateException, NamingException {
      this.planPaye = this.planPayeDao.chercherCode(var1, this.exercicesPaye.getExepayId(), var5);
      if (this.planPaye != null) {
         this.salariesContrats = this.salariesContratsDao.chargerlesContratsActif(this.salaries, var5);
         if (this.salariesContrats != null) {
            this.salariesVariables = this.salariesVariablesDao.chargerlesVariablesPeriodeRubrique(this.salaries, this.periode, this.salariesContrats.getSalconNum(), var1, var5);
            if (this.salariesVariables == null) {
               this.salariesVariables = new SalariesVariables();
            }

            this.salariesVariables.setSalvarCode(var1);
            this.salariesVariables.setSalvarContrat(this.salariesContrats.getSalconNum());
            String var6 = "";
            if (var4 == 0) {
               var6 = this.salariesContrats.getSalconFeuille();
            } else if (var4 == 1) {
               var6 = this.salariesContrats.getSalconActivite();
            } else if (var4 == 2) {
               var6 = this.salariesContrats.getSalconService();
            } else if (var4 == 3) {
               var6 = this.salariesContrats.getSalconProjet();
            } else if (var4 == 4) {
               var6 = "" + this.salariesContrats.getSalconIdTiers();
            }

            this.salariesVariables.setSalvarFeuille(var6);
            this.salariesVariables.setSalvarPeriode(this.periode);
            if (var1.equals("105010")) {
               this.salariesVariables.setSalvarValeurColC(var2);
               this.salariesVariables.setSalvarVariableC(true);
               this.salariesVariables.setSalvarVariableD(false);
               this.salariesVariables.setSalvarValeurColD(0.0D);
            } else {
               this.salariesVariables.setSalvarValeurColD(var2);
               this.salariesVariables.setSalvarVariableD(true);
               this.salariesVariables.setSalvarVariableC(false);
               this.salariesVariables.setSalvarValeurColC(0.0D);
            }

            this.salariesVariables.setSalvarVariableA(false);
            this.salariesVariables.setSalvarVariableB(false);
            this.salariesVariables.setSalvarVariableE(false);
            this.salariesVariables.setPlanPaye(this.planPaye);
            this.salariesVariables.setSalaries(this.salaries);
            if (this.salariesVariables.getSalvarId() == 0L) {
               this.salariesVariables = this.salariesVariablesDao.insert(this.salariesVariables, var5);
            } else {
               this.salariesVariables = this.salariesVariablesDao.modif(this.salariesVariables, var5);
            }

            var5.flush();
         }
      }

   }

   public boolean recherhceSalarie(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var1 != null && !var1.isEmpty() && var1.equals("sal_id")) {
         long var7 = this.conversionLong(var2);
         this.salaries = this.salariesDao.chercherIdSalaries(var7, var3);
         if (this.salaries == null) {
            this.salaries = new Salaries();
            var4 = false;
         } else {
            var4 = true;
         }
      } else if (var1 != null && !var1.isEmpty() && var1.equals("sal_matricule")) {
         String var5 = "";
         if (var2.contains(".")) {
            int var6 = var2.indexOf(".");
            var5 = var2.substring(0, var6);
         } else {
            var5 = var2;
         }

         var5 = this.calculeMatricule(var5);
         this.salaries = this.salariesDao.chercherIdSalaries(var5, var3);
         if (this.salaries == null) {
            this.salaries = new Salaries();
            this.salaries.setSalMatricule(var5);
            var4 = false;
         } else {
            var4 = true;
         }
      }

      return var4;
   }

   public String enlevePoint(String var1) {
      String var2 = "";
      if (var1 != null && !var1.isEmpty() && var1.contains(".0")) {
         int var3 = var1.indexOf(".0");
         var2 = var1.substring(0, var3);
      } else {
         var2 = var1;
      }

      if (var2 != null && !var2.isEmpty()) {
         var2 = var2.replace("'", "`");
      }

      return var2;
   }

   public int conversionInteger(String var1) {
      String var2 = "";
      int var3 = 0;
      if (var1 != null && !var1.isEmpty()) {
         if (this.testNumerique(var1)) {
            if (var1.contains(".0")) {
               int var4 = var1.indexOf(".0");
               var2 = var1.substring(0, var4);
            } else {
               var2 = var1;
            }
         }

         var3 = Integer.parseInt(var2);
      }

      return var3;
   }

   public double conversionDouble(String var1) {
      double var2 = 0.0D;
      if (var1 != null && !var1.isEmpty()) {
         if (var1.contains(":")) {
            String[] var4 = var1.split(":");
            String var5 = var4[0];
            String var6 = var4[1];
            int var7 = 0;
            int var8 = 0;
            if (this.testNumerique(var5)) {
               var7 = Integer.parseInt(var5);
            }

            if (this.testNumerique(var6)) {
               var8 = Integer.parseInt(var6);
            }

            var2 = Double.parseDouble(var7 + "." + var8);
         } else if (this.testNumerique(var1)) {
            var2 = Double.parseDouble(var1);
         }
      }

      return var2;
   }

   public float conversionFloat(String var1) {
      float var2 = 0.0F;
      if (var1 != null && !var1.isEmpty()) {
         if (var1.contains(":")) {
            String[] var3 = var1.split(":");
            String var4 = var3[0];
            String var5 = var3[1];
            int var6 = 0;
            int var7 = 0;
            if (this.testNumerique(var4)) {
               var6 = Integer.parseInt(var4);
            }

            if (this.testNumerique(var5)) {
               var7 = Integer.parseInt(var5);
            }

            var2 = Float.parseFloat(var6 + "," + var7);
         } else if (this.testNumerique(var1)) {
            var2 = Float.parseFloat(var1);
         }
      }

      return var2;
   }

   public long conversionLong(String var1) {
      String var2 = "";
      long var3 = 0L;
      if (var1 != null && !var1.isEmpty()) {
         if (this.testNumerique(var1)) {
            if (var1.contains(".0")) {
               int var5 = var1.indexOf(".0");
               var2 = var1.substring(0, var5);
            } else {
               var2 = var1;
            }
         }

         var3 = Long.parseLong(var2);
      }

      return var3;
   }

   public Date conversionDate(String var1) throws java.text.ParseException {
      Date var2 = null;
      if (var1 != null && !var1.isEmpty()) {
         if (var1.contains("-")) {
            if (var1.substring(4, 4).equals("-")) {
               String[] var3 = var1.split("-");
               String var4 = var3[2];
               String var5 = var3[1];
               String var6 = var3[0];
               var2 = this.utilDate.stringToDateSQLLight(var4 + "-" + var5 + "-" + var6);
            } else {
               var2 = this.utilDate.stringToDateSQLLight(var1);
            }
         } else {
            int var7 = this.conversionInteger(var1);
            if (var7 >= 10000 && var7 <= 60000) {
               GregorianCalendar var8 = new GregorianCalendar(1900, 0, 1);
               var8.add(5, var7 - 2);
               var2 = var8.getTime();
            } else {
               var2 = null;
            }
         }
      } else {
         var2 = null;
      }

      return var2;
   }

   public String conversionHeure(String var1) throws java.text.ParseException {
      String var2 = null;
      if (var1 != null && !var1.isEmpty()) {
         String var5;
         if (var1.contains(":")) {
            String[] var3 = var1.split(":");
            String var4 = var3[0];
            var5 = var3[1];
            var2 = var4 + ":" + var5;
         } else if (!var1.equals("0")) {
            int var7 = (int)(Float.parseFloat(var1) * 24.0F);
            int var8 = (int)(Float.parseFloat(var1) * 1440.0F - (float)(var7 * 60));
            var5 = "";
            if (var7 <= 9) {
               var5 = "0" + var7;
            } else {
               var5 = "" + var7;
            }

            String var6 = "";
            if (var8 <= 9) {
               var6 = "0" + var8;
            } else {
               var6 = "" + var8;
            }

            var2 = var5 + ":" + var6;
         } else {
            var2 = "00:00";
         }
      } else {
         var2 = "00:00";
      }

      return var2;
   }

   public boolean testNumerique(String var1) {
      boolean var2 = true;

      for(int var3 = 0; var3 < var1.length(); ++var3) {
         String var4 = (String)var1.subSequence(var3, var3 + 1);
         if (!".1234567890".contains(var4)) {
            var2 = false;
            break;
         }
      }

      return var2;
   }

   public void calculeRubSalarie(String var1, String var2, Session var3) throws java.text.ParseException, HibernateException, NamingException {
      this.messageErreur = "";
      String var4;
      if (var1.equalsIgnoreCase("sal_matricule")) {
         var4 = "";
         if (var2.contains(".")) {
            int var5 = var2.indexOf(".");
            var4 = var2.substring(0, var5);
         } else {
            var4 = var2;
         }

         this.salaries.setSalMatricule(this.calculeMatricule(var4));
      } else if (var1.equalsIgnoreCase("sal_photo")) {
         this.salaries.setSalPhoto(this.enlevePoint(var2));
      } else if (var1.equalsIgnoreCase("sal_document")) {
         this.salaries.setSalDocument(this.enlevePoint(var2));
      } else if (var1.equalsIgnoreCase("sal_nature")) {
         this.salaries.setSalNature(this.enlevePoint(var2));
      } else if (var1.equalsIgnoreCase("sal_protege")) {
         this.salaries.setSalProtege(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("sal_etat")) {
         this.salaries.setSalEtat(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("sal_nom")) {
         if (var2 != null && !var2.isEmpty()) {
            this.salaries.setSalNom(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("sal_nom_jf")) {
         if (var2 != null && !var2.isEmpty()) {
            this.salaries.setSalNomJf(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("sal_prenom")) {
         if (var2 != null && !var2.isEmpty()) {
            this.salaries.setSalPrenom(this.enlevePoint(var2).toLowerCase());
         }
      } else if (var1.equalsIgnoreCase("sal_civilite")) {
         this.salaries.setSalCivilite(this.enlevePoint(var2));
      } else if (var1.equalsIgnoreCase("sal_nom_pays")) {
         if (var2 != null && !var2.isEmpty()) {
            this.salaries.setSalNompays(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("sal_langue")) {
         if (var2 != null && !var2.isEmpty()) {
            this.salaries.setSalLangue(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("sal_fonction")) {
         if (var2 != null && !var2.isEmpty()) {
            this.salaries.setSalFonction(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("sal_profession")) {
         if (var2 != null && !var2.isEmpty()) {
            this.salaries.setSalProfession(this.enlevePoint(var2).toUpperCase());
         }
      } else if (var1.equalsIgnoreCase("sal_site")) {
         this.verifSite(var2, var3);
      } else if (var1.equalsIgnoreCase("sal_departement")) {
         this.verifDepartement(var2, var3);
      } else if (var1.equalsIgnoreCase("sal_service")) {
         this.verifService(var2, var3);
      } else if (!var1.equalsIgnoreCase("sal_lib_service")) {
         if (var1.equalsIgnoreCase("sal_activite")) {
            this.verifActivite(var2, var3);
         } else if (var1.equalsIgnoreCase("sal_localisation")) {
            this.verifLocalisation(var2, var3);
         } else if (var1.equalsIgnoreCase("sal_budget")) {
            this.verifBudget(var2, var3);
         } else if (var1.equalsIgnoreCase("sal_parc")) {
            this.verifParc(var2, var3);
         } else if (var1.equalsIgnoreCase("sal_date_naissance")) {
            this.salaries.setSalDateNaissance(this.conversionDate(var2));
            if (this.salaries.getSalDateNaissance() != null) {
               var4 = "";
               if (this.salaries.getSalDateNaissance().getDate() <= 9) {
                  var4 = "0" + this.salaries.getSalDateNaissance().getDate();
               } else {
                  var4 = "" + this.salaries.getSalDateNaissance().getDate();
               }

               String var6 = "";
               if (this.salaries.getSalDateNaissance().getMonth() + 1 <= 9) {
                  var6 = "0" + (this.salaries.getSalDateNaissance().getMonth() + 1);
               } else {
                  var6 = "" + (this.salaries.getSalDateNaissance().getMonth() + 1);
               }

               this.salaries.setSalAnniversaire(var4 + ":" + var6);
            } else {
               this.salaries.setSalAnniversaire("");
            }
         } else if (var1.equalsIgnoreCase("sal_lieu_naissance")) {
            if (var2 != null && !var2.isEmpty()) {
               this.salaries.setSalLieuNaissance(this.enlevePoint(var2).toUpperCase());
            }
         } else if (var1.equalsIgnoreCase("sal_pays_naissance")) {
            if (var2 != null && !var2.isEmpty()) {
               this.salaries.setSalPaysNaissance(this.enlevePoint(var2).toUpperCase());
            }
         } else if (var1.equalsIgnoreCase("sal_code_naissance")) {
            if (var2 != null && !var2.isEmpty()) {
               this.salaries.setSalCodeNaissance(this.enlevePoint(var2).toUpperCase());
            }
         } else if (var1.equalsIgnoreCase("sal_nationnalite")) {
            if (var2 != null && !var2.isEmpty()) {
               this.salaries.setSalNationnalite(this.enlevePoint(var2).toUpperCase());
            }
         } else if (var1.equalsIgnoreCase("sal_ethnie")) {
            if (var2 != null && !var2.isEmpty()) {
               this.salaries.setSalEthnie(this.enlevePoint(var2).toUpperCase());
            }
         } else if (var1.equalsIgnoreCase("sal_tel_bur")) {
            this.salaries.setSalTelBur(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_tel_dom")) {
            this.salaries.setSalTelDom(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_cel1")) {
            this.salaries.setSalCel1(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_cel2")) {
            this.salaries.setSalCel2(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_cel3")) {
            this.salaries.setSalCel3(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_adresse")) {
            this.salaries.setSalAdresse(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_rue")) {
            this.salaries.setSalRue(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_lot")) {
            this.salaries.setSalLot(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_ilot")) {
            this.salaries.setSalIlot(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_batiment")) {
            this.salaries.setSalBatiment(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_porte")) {
            this.salaries.setSalPorte(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_escalier")) {
            this.salaries.setSalEscalier(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_ascensseur")) {
            this.salaries.setSalAscensseur(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_etage")) {
            this.salaries.setSalEtage(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_quartier")) {
            this.salaries.setSalQuartier(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_commune")) {
            this.salaries.setSalCommune(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_departe")) {
            this.salaries.setSalDeparte(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_zone")) {
            this.salaries.setSalZone(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_bp")) {
            this.salaries.setSalBp(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_ville")) {
            this.salaries.setSalVille(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_yahoo")) {
            this.salaries.setSalYahoo(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_msn")) {
            this.salaries.setSalMsn(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_skype")) {
            this.salaries.setSalSkype(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_aol")) {
            this.salaries.setSalAol(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_mail1")) {
            this.salaries.setSalMail1(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_observation")) {
            this.salaries.setSalObservation(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_mode_reglement")) {
            this.salaries.setSalModeReglement(this.conversionInteger(var2));
         } else if (var1.equalsIgnoreCase("sal_num_banque")) {
            this.salaries.setSalNumBanque(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_guichet_banque")) {
            this.salaries.setSalGuichetBanque(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_compte_banque")) {
            this.salaries.setSalCompteBanque(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_cle_banque")) {
            this.salaries.setSalCleBanque(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_iban")) {
            this.salaries.setSalIban(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_swift")) {
            this.salaries.setSalSwift(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_compte_membre")) {
            this.salaries.setSalCompteMembre(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_mode_reglement_15")) {
            this.salaries.setSalModeReglement15(this.conversionInteger(var2));
         } else if (var1.equalsIgnoreCase("sal_num_banque_15")) {
            this.salaries.setSalNumBanque15(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_guichet_banque_15")) {
            this.salaries.setSalGuichetBanque15(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_compte_banque_15")) {
            this.salaries.setSalCompteBanque15(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_cle_banque_15")) {
            this.salaries.setSalCleBanque15(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_iban_15")) {
            this.salaries.setSalIban15(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_swift_15")) {
            this.salaries.setSalSwift15(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_compte_membre_15")) {
            this.salaries.setSalCompteMembre15(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("sal_genre")) {
            this.salaries.setSalGenre(this.conversionInteger(var2));
         } else if (var1.equalsIgnoreCase("sal_sit_famille")) {
            this.salaries.setSalSitFamille(this.conversionInteger(var2));
         } else if (var1.equalsIgnoreCase("sal_nb_enfant")) {
            this.salaries.setSalNbEnfant(this.conversionInteger(var2));
         } else if (var1.equalsIgnoreCase("sal_nb_part_fiscal")) {
            if (var2 != null && !var2.isEmpty()) {
               this.salaries.setSalNbPartFiscal(Float.parseFloat(var2));
            } else {
               this.salaries.setSalNbPartFiscal(0.0F);
            }
         } else if (var1.equalsIgnoreCase("sal_nb_femme")) {
            this.salaries.setSalNbFemme(this.conversionInteger(var2));
         } else if (var1.equalsIgnoreCase("sal_nb_part_trimf")) {
            if (var2 != null && !var2.isEmpty()) {
               this.salaries.setSalNbPartTrimf(Float.parseFloat(var2));
            } else {
               this.salaries.setSalNbPartTrimf(0.0F);
            }
         } else if (var1.equalsIgnoreCase("sal_nb_jour_cp")) {
            if (var2 != null && !var2.isEmpty()) {
               this.salaries.setSalNbJourCp(Float.parseFloat(var2));
            } else {
               this.salaries.setSalNbJourCp(0.0F);
            }
         } else if (var1.equalsIgnoreCase("sal_nb_jour_tr")) {
            if (var2 != null && !var2.isEmpty()) {
               this.salaries.setSalNbJourTr(Float.parseFloat(var2));
            } else {
               this.salaries.setSalNbJourTr(0.0F);
            }
         } else if (var1.equalsIgnoreCase("sal_date_marie")) {
            this.salaries.setSalDateMarie(this.conversionDate(var2));
         } else if (var1.equalsIgnoreCase("sal_date_divorce")) {
            this.salaries.setSalDateDivorce(this.conversionDate(var2));
         } else if (var1.equalsIgnoreCase("sal_date_veuf")) {
            this.salaries.setSalDateVeuf(this.conversionDate(var2));
         } else if (var1.equalsIgnoreCase("sal_date_concubinage")) {
            this.salaries.setSalDateConcubinage(this.conversionDate(var2));
         } else if (var1.equalsIgnoreCase("sal_date_pacs")) {
            this.salaries.setSalDatePacs(this.conversionDate(var2));
         } else if (var1.equalsIgnoreCase("sal_convention")) {
            this.verifConvention(var2, var3);
         } else if (!var1.equalsIgnoreCase("sal_lib_convention")) {
            if (var1.equalsIgnoreCase("sal_Cod_Centres_Impots")) {
               this.verifCentreImpot(var2, var3);
            } else if (!var1.equalsIgnoreCase("sal_Lib_Centres_Impots")) {
               if (var1.equalsIgnoreCase("sal_centres_securite")) {
                  this.verifCentreSecurite(var2, var3);
               } else if (!var1.equalsIgnoreCase("sal_lib_centres_securite")) {
                  if (var1.equalsIgnoreCase("sal_classement")) {
                     this.verifClassement(var2, var3);
                  } else if (!var1.equalsIgnoreCase("sal_lib_classement")) {
                     if (var1.equalsIgnoreCase("sal_code_emploi")) {
                        this.salaries.setSalCodeEmploi(this.enlevePoint(var2).toUpperCase());
                     } else if (var1.equalsIgnoreCase("sal_niv_emploi")) {
                        this.verifNiveauEmploi(var2, var3);
                     } else if (!var1.equalsIgnoreCase("sal_lib_niv_emploi")) {
                        if (var1.equalsIgnoreCase("sal_grille")) {
                           this.verifGrille(var2, var3);
                        } else if (!var1.equalsIgnoreCase("sal_lib_grille")) {
                           if (var1.equalsIgnoreCase("sal_date_entree")) {
                              this.salaries.setSalDateEntree(this.conversionDate(var2));
                           } else if (var1.equalsIgnoreCase("sal_date_sortie")) {
                              this.salaries.setSalDateSortie(this.conversionDate(var2));
                           } else if (var1.equalsIgnoreCase("sal_motif_sortie")) {
                              this.salaries.setSalMotifSortie(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_date_impot")) {
                              this.salaries.setSalDateImpot(this.conversionDate(var2));
                           } else if (var1.equalsIgnoreCase("sal_feuille")) {
                              this.verifFeuille(var2, var3);
                           } else if (var1.equalsIgnoreCase("sal_num_ci")) {
                              this.salaries.setSalNumCi(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_date_ci")) {
                              this.salaries.setSalDateCi(this.conversionDate(var2));
                           } else if (var1.equalsIgnoreCase("sal_delivre_ci")) {
                              this.salaries.setSalDelivreCi(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_lieu_ci")) {
                              this.salaries.setSalLieuCi(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_num_secu")) {
                              this.salaries.setSalNumSecu(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_date_secu")) {
                              this.salaries.setSalDateSecu(this.conversionDate(var2));
                           } else if (var1.equalsIgnoreCase("sal_num_retraite")) {
                              this.salaries.setSalNumRetraite(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_date_retraite")) {
                              this.salaries.setSalDateRetraite(this.conversionDate(var2));
                           } else if (var1.equalsIgnoreCase("sal_num_cnamgs")) {
                              this.salaries.setSalNumCnamgs(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_date_cnamgs")) {
                              this.salaries.setSalDateCnamgs(this.conversionDate(var2));
                           } else if (var1.equalsIgnoreCase("sal_num_amo")) {
                              this.salaries.setSalNumAmo(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_date_amo")) {
                              this.salaries.setSalDateAmo(this.conversionDate(var2));
                           } else if (var1.equalsIgnoreCase("sal_num_allocataire")) {
                              this.salaries.setSalNumAllocataire(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_date_allocataire")) {
                              this.salaries.setSalDateAllocataire(this.conversionDate(var2));
                           } else if (var1.equalsIgnoreCase("sal_num_fiscal")) {
                              this.salaries.setSalNumFiscal(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_approb_insp")) {
                              this.salaries.setSalApprobInsp(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_visa_enreg")) {
                              this.salaries.setSalVisaEnreg(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_classe_recrut")) {
                              this.salaries.setSalClasseRecrut(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_service_mil")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalServiceMil(false);
                              } else {
                                 this.salaries.setSalServiceMil(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_corps_app")) {
                              this.salaries.setSalCoprsApp(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_grade")) {
                              this.salaries.setSalGrade(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_date_entree_pays")) {
                              this.salaries.setSalDateEntreePays(this.conversionDate(var2));
                           } else if (var1.equalsIgnoreCase("sal_pere")) {
                              this.salaries.setSalPere(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_mere")) {
                              this.salaries.setSalMere(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_compte_net")) {
                              this.salaries.setSalCompteNet(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_compte_acompte")) {
                              this.salaries.setSalCompteAcompte(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_compte_avance")) {
                              this.salaries.setSalCompteAvance(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_cle_anal1")) {
                              this.salaries.setSalCleAnal1(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_lib_cle_anal1")) {
                              this.salaries.setSalLibCleAnal1(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_cle_anal2")) {
                              this.salaries.setSalCleAnal2(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_lib_cle_anal2")) {
                              this.salaries.setSalLibCleAnal2(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_mise_relation")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalMiseRelation(false);
                              } else {
                                 this.salaries.setSalMiseRelation(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_disponible")) {
                              this.salaries.setSalDisponible(this.conversionInteger(var2));
                           } else if (var1.equalsIgnoreCase("sal_dispo_du")) {
                              this.salaries.setSalDispoDu(this.conversionDate(var2));
                           } else if (var1.equalsIgnoreCase("sal_dispo_au")) {
                              this.salaries.setSalDispoAu(this.conversionDate(var2));
                           } else if (var1.equalsIgnoreCase("sal_mobile")) {
                              this.salaries.setSalMobile(this.conversionInteger(var2));
                           } else if (var1.equalsIgnoreCase("sal_mobile_sauf")) {
                              this.salaries.setSalMobileSauf(this.enlevePoint(var2));
                           } else if (var1.equalsIgnoreCase("sal_dom_act1")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct1(false);
                              } else {
                                 this.salaries.setSalDomAct1(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act2")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct2(false);
                              } else {
                                 this.salaries.setSalDomAct2(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act3")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct3(false);
                              } else {
                                 this.salaries.setSalDomAct3(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act4")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct4(false);
                              } else {
                                 this.salaries.setSalDomAct4(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act5")) {
                              if (var2 != null && !var2.isEmpty() && (var2.equals("1") || var2.equalsIgnoreCase("true"))) {
                                 this.salaries.setSalDomAct5(true);
                              } else {
                                 this.salaries.setSalDomAct5(false);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act6")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct6(false);
                              } else {
                                 this.salaries.setSalDomAct6(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act7")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct7(false);
                              } else {
                                 this.salaries.setSalDomAct7(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act8")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct8(false);
                              } else {
                                 this.salaries.setSalDomAct8(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act9")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct9(false);
                              } else {
                                 this.salaries.setSalDomAct9(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act10")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct10(false);
                              } else {
                                 this.salaries.setSalDomAct10(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act11")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct11(false);
                              } else {
                                 this.salaries.setSalDomAct11(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act12")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct12(false);
                              } else {
                                 this.salaries.setSalDomAct12(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act13")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct13(false);
                              } else {
                                 this.salaries.setSalDomAct13(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act14")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct14(false);
                              } else {
                                 this.salaries.setSalDomAct14(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act15")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct15(false);
                              } else {
                                 this.salaries.setSalDomAct15(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act16")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct16(false);
                              } else {
                                 this.salaries.setSalDomAct16(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act17")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct17(false);
                              } else {
                                 this.salaries.setSalDomAct17(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act18")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct18(false);
                              } else {
                                 this.salaries.setSalDomAct18(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act19")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct19(false);
                              } else {
                                 this.salaries.setSalDomAct19(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act20")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct20(false);
                              } else {
                                 this.salaries.setSalDomAct20(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act21")) {
                              if (var2 != null && !var2.isEmpty() && (var2.equals("1") || var2.equalsIgnoreCase("true"))) {
                                 this.salaries.setSalDomAct21(true);
                              } else {
                                 this.salaries.setSalDomAct21(false);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act22")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct22(false);
                              } else {
                                 this.salaries.setSalDomAct22(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act23")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct23(false);
                              } else {
                                 this.salaries.setSalDomAct23(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act24")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct24(false);
                              } else {
                                 this.salaries.setSalDomAct24(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act25")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct25(false);
                              } else {
                                 this.salaries.setSalDomAct25(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act26")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct26(false);
                              } else {
                                 this.salaries.setSalDomAct26(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act27")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct27(false);
                              } else {
                                 this.salaries.setSalDomAct27(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act28")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct28(false);
                              } else {
                                 this.salaries.setSalDomAct28(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act29")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct29(false);
                              } else {
                                 this.salaries.setSalDomAct29(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_dom_act30")) {
                              if (var2 == null || var2.isEmpty() || !var2.equals("1") && !var2.equalsIgnoreCase("true")) {
                                 this.salaries.setSalDomAct30(false);
                              } else {
                                 this.salaries.setSalDomAct30(true);
                              }
                           } else if (var1.equalsIgnoreCase("sal_nb_annee")) {
                              this.salaries.setSalNbAnnee(this.conversionInteger(var2));
                           } else if (var1.equalsIgnoreCase("sal_fr_lire")) {
                              this.salaries.setSalFrLire(this.conversionInteger(var2));
                           } else if (var1.equalsIgnoreCase("sal_fr_ecrire")) {
                              this.salaries.setSalFrEcrire(this.conversionInteger(var2));
                           } else if (var1.equalsIgnoreCase("sal_fr_parler")) {
                              this.salaries.setSalFrParler(this.conversionInteger(var2));
                           } else if (var1.equalsIgnoreCase("sal_us_lire")) {
                              this.salaries.setSalUsLire(this.conversionInteger(var2));
                           } else if (var1.equalsIgnoreCase("sal_us_ecrire")) {
                              this.salaries.setSalUsEcrire(this.conversionInteger(var2));
                           } else if (var1.equalsIgnoreCase("sal_us_parler")) {
                              this.salaries.setSalUsParler(this.conversionInteger(var2));
                           } else if (var1.equalsIgnoreCase("sal_loc_lire")) {
                              this.salaries.setSalLocLire(this.conversionInteger(var2));
                           } else if (var1.equalsIgnoreCase("sal_loc_ecrire")) {
                              this.salaries.setSalLocEcrire(this.conversionInteger(var2));
                           } else if (var1.equalsIgnoreCase("sal_duree_jour")) {
                              this.salaries.setSalDureeJour(this.conversionInteger(var2));
                           } else if (var1.equalsIgnoreCase("sal_id_tiers")) {
                              this.verifTiers(var2, var3);
                           } else if (!var1.equalsIgnoreCase("sal_nom_tiers")) {
                              if (var1.equalsIgnoreCase("sal_conjoint_nom_prenom")) {
                                 this.salaries.setSalConjointNomPrenom(this.enlevePoint(var2));
                              } else if (var1.equalsIgnoreCase("sal_conjoint_num_fiscal")) {
                                 this.salaries.setSalConjointNumFiscal(this.enlevePoint(var2));
                              } else if (var1.equalsIgnoreCase("sal_conjoint_nom_jf")) {
                                 this.salaries.setSalConjointNomJf(this.enlevePoint(var2));
                              } else if (var1.equalsIgnoreCase("sal_conjoint_employeur_nom")) {
                                 this.salaries.setSalConjointEmployeurNom(this.enlevePoint(var2));
                              } else if (var1.equalsIgnoreCase("sal_conjoint_employeur_adresse")) {
                                 this.salaries.setSalConjointEmployeurAdresse(this.enlevePoint(var2));
                              } else if (var1.equalsIgnoreCase("sal_conjoint_employeur_bp")) {
                                 this.salaries.setSalConjointEmployeurBp(this.enlevePoint(var2));
                              } else if (var1.equalsIgnoreCase("sal_conjoint_employeur_ville")) {
                                 this.salaries.setSalConjointEmployeurVille(this.enlevePoint(var2));
                              } else if (var1.equalsIgnoreCase("sal_conjoint_employeur_tel")) {
                                 this.salaries.setSalConjointEmployeurTel(this.enlevePoint(var2));
                              } else if (var1.equalsIgnoreCase("sal_conjoint_employeur_fonction")) {
                                 this.salaries.setSalConjointEmployeurFonction(this.enlevePoint(var2));
                              } else if (var1.equalsIgnoreCase("sal_id_groupe")) {
                                 this.salaries.setSalIdGroupe(this.conversionLong(var2));
                              } else if (var1.equalsIgnoreCase("sal_id_old")) {
                                 this.salaries.setSalIdOld(this.conversionLong(var2));
                              } else {
                                 this.messageErreur = "La rubrique " + var1 + " n`existe pas...";
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      if (this.messageErreur != null && !this.messageErreur.isEmpty()) {
         this.transfertPaye.setTrfNomFeuille(this.messageErreur);
         this.transfertPaye.setTrfPeriode("");
         this.transfertPaye.setTrfColT00(this.salaries.getSalActivite());
         this.transfertPaye.setTrfColT01(this.salaries.getSalMatricule());
         this.transfertPaye.setTrfColT02(this.salaries.getPatronyme());
         this.lesErreurs.add(this.transfertPaye);
      }

   }

   public boolean calculeRubContrat(String var1, String var2, Session var3) throws HibernateException, NamingException, java.text.ParseException {
      boolean var4 = false;
      this.messageErreur = "";
      if (var1.equalsIgnoreCase("salcon_num")) {
         this.salariesContrats.setSalconNum(this.enlevePoint(var2));
      } else if (var1.equalsIgnoreCase("salcon_type")) {
         this.salariesContrats.setSalconType(this.enlevePoint(var2));
      } else if (var1.equalsIgnoreCase("salcon_feuille")) {
         this.verifFeuille(var2, var3);
      } else if (var1.equalsIgnoreCase("salcon_etat")) {
         this.salariesContrats.setSalconEtat(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("salcon_essai")) {
         this.salariesContrats.setSalconEssai(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("salcon_nb_mois_essai")) {
         this.salariesContrats.setSalconNbMoisEssai(this.conversionInteger(var2));
      } else if (var1.equalsIgnoreCase("salcon_fonction")) {
         this.salariesContrats.setSalconFonction(this.enlevePoint(var2));
      } else if (var1.equalsIgnoreCase("salcon_site")) {
         this.verifSite(var2, var3);
      } else if (var1.equalsIgnoreCase("salcon_departement")) {
         this.verifDepartement(var2, var3);
      } else if (var1.equalsIgnoreCase("salcon_localisation")) {
         this.verifLocalisation(var2, var3);
      } else if (var1.equalsIgnoreCase("salcon_service")) {
         this.verifService(var2, var3);
      } else if (!var1.equalsIgnoreCase("salcon_lib_service")) {
         if (var1.equalsIgnoreCase("salcon_date_debut")) {
            this.salariesContrats.setSalconDateDebut(this.conversionDate(var2));
         } else if (var1.equalsIgnoreCase("salcon_lieu_travail")) {
            this.salariesContrats.setSalconLieuTravail(this.enlevePoint(var2));
         } else if (var1.equalsIgnoreCase("salcon_convention")) {
            this.verifConvention(var2, var3);
         } else if (!var1.equalsIgnoreCase("salcon_lib_convention")) {
            if (var1.equalsIgnoreCase("salcon_centres_impots")) {
               this.verifCentreImpot(var2, var3);
            } else if (!var1.equalsIgnoreCase("salcon_lib_centres_impots")) {
               if (var1.equalsIgnoreCase("salcon_centres_securite")) {
                  this.verifCentreSecurite(var2, var3);
               } else if (!var1.equalsIgnoreCase("salcon_lib_centres_securite")) {
                  if (var1.equalsIgnoreCase("salcon_classement")) {
                     this.verifClassement(var2, var3);
                  } else if (!var1.equalsIgnoreCase("salcon_lib_classement")) {
                     if (var1.equalsIgnoreCase("salcon_code_emploi")) {
                        this.salariesContrats.setSalconCodeEmploi(this.enlevePoint(var2));
                     } else if (var1.equalsIgnoreCase("salcon_niv_emploi")) {
                        this.verifNiveauEmploi(var2, var3);
                     } else if (!var1.equalsIgnoreCase("salcon_lib_niv_emploi")) {
                        if (var1.equalsIgnoreCase("salcon_grille")) {
                           this.verifGrille(var2, var3);
                        } else if (!var1.equalsIgnoreCase("salcon_lib_grille")) {
                           if (var1.equalsIgnoreCase("salcon_activite")) {
                              this.verifActivite(var2, var3);
                           } else if (!var1.equalsIgnoreCase("salcon_lib_activite")) {
                              if (var1.equalsIgnoreCase("salcon_budget")) {
                                 this.verifBudget(var2, var3);
                              } else if (!var1.equalsIgnoreCase("salcon_lib_budget")) {
                                 if (var1.equalsIgnoreCase("salcon_projet")) {
                                    this.verifProjet(var2, var3);
                                 } else if (!var1.equalsIgnoreCase("salcon_lib_projet")) {
                                    if (var1.equalsIgnoreCase("salcon_vehicule")) {
                                       this.salariesContrats.setSalconVehicule(this.conversionInteger(var2));
                                    } else if (var1.equalsIgnoreCase("salcon_rmb_kms")) {
                                       this.salariesContrats.setSalconRbmKms((double)this.conversionInteger(var2));
                                    } else if (var1.equalsIgnoreCase("salcon_parc")) {
                                       this.verifParc(var2, var3);
                                    } else if (!var1.equalsIgnoreCase("salcon_text")) {
                                       if (var1.equalsIgnoreCase("salcon_date_fin")) {
                                          this.salariesContrats.setSalconDateFin(this.conversionDate(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_motif_sortie")) {
                                          this.salariesContrats.setSalconMotifSortie(this.enlevePoint(var1));
                                       } else if (var1.equalsIgnoreCase("salcon_date_remise")) {
                                          this.salariesContrats.setSalconDateRemise(this.conversionDate(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_date_retour")) {
                                          this.salariesContrats.setSalconDateRetour(this.conversionDate(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_date_confirmation")) {
                                          this.salariesContrats.setSalconDateConfirmation(this.conversionDate(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_id_representant")) {
                                          this.salariesContrats.setSalconIdRepresetant((long)this.conversionInteger(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_nom_representant")) {
                                          this.salariesContrats.setSalconNomRepresentant(this.enlevePoint(var1));
                                       } else if (var1.equalsIgnoreCase("salcon_qualite")) {
                                          this.salariesContrats.setSalconQualite(this.enlevePoint(var1));
                                       } else if (var1.equalsIgnoreCase("salcon_etat_val")) {
                                          this.salariesContrats.setSalconEtatVal(this.conversionInteger(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_etat_h")) {
                                          this.salariesContrats.setSalconEtatH(this.conversionInteger(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_date_valide")) {
                                          this.salariesContrats.setSalconDateValide(this.conversionDate(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_pos_signature")) {
                                          this.salariesContrats.setSalconPosSignature(this.conversionInteger(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_date_imp")) {
                                          this.salariesContrats.setSalconDateImp(this.conversionDate(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_base")) {
                                          this.salariesContrats.setSalconBase(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_sursalaire")) {
                                          this.salariesContrats.setSalconSursalaire((double)this.conversionFloat(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_forfait_sup")) {
                                          this.salariesContrats.setSalconForfaitSup(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_prime_rendement")) {
                                          this.salariesContrats.setSalconPrimeRendement(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_prime_responsabilite")) {
                                          this.salariesContrats.setSalconPrimeResponsabilite(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_prime_exceptionelle")) {
                                          this.salariesContrats.setSalconPrimeExceptionnelle(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_prime_sujetion")) {
                                          this.salariesContrats.setSalconPrimeSujetion(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_prime_fonction")) {
                                          this.salariesContrats.setSalconPrimeFonction(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_prime_outillage")) {
                                          this.salariesContrats.setSalconPrimeOutillage(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_prime_astreinte")) {
                                          this.salariesContrats.setSalconPrimeAstreinte(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_indemnite_caisse")) {
                                          this.salariesContrats.setSalconIndemniteCaisse(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_indemnite_transport")) {
                                          this.salariesContrats.setSalconIndemniteTransport(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_indemnite_logement")) {
                                          this.salariesContrats.setSalconIndemniteLogement(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_indemnite_deplacement")) {
                                          this.salariesContrats.setSalconIndemniteDeplacement(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_indemnite_kilometrique")) {
                                          this.salariesContrats.setSalconIndemniteKilometrique(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_indemnite_salissure")) {
                                          this.salariesContrats.setSalconIndemniteSalissure(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_indemnite_representation")) {
                                          this.salariesContrats.setSalconIndemniteRepresentation(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_indemnite_diverse")) {
                                          this.salariesContrats.setSalconIndemniteDiverse(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_indemnite_responsabilite")) {
                                          this.salariesContrats.setSalconIndemniteResponsabilite(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_indemnite_nourriture")) {
                                          this.salariesContrats.setSalconIndemniteNourriture(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_avn_logement")) {
                                          this.salariesContrats.setSalconAvnLogement(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_avn_domesticite")) {
                                          this.salariesContrats.setSalconAvnDomesticite(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_avn_telephone")) {
                                          this.salariesContrats.setSalconAvnTelephone(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_avn_eau")) {
                                          this.salariesContrats.setSalconAvnEau(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_avn_electricite")) {
                                          this.salariesContrats.setSalconAvnElectricite(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_avn_nourriture")) {
                                          this.salariesContrats.setSalconAvnNourriture(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_avn_vehicule")) {
                                          this.salariesContrats.setSalconAvnVehicule(this.conversionDouble(var2));
                                       } else if (var1.equalsIgnoreCase("salcon_nb_jour_cp")) {
                                          if (var2 != null && !var2.isEmpty()) {
                                             this.salariesContrats.setSalconNbJourCp(Float.parseFloat(var2));
                                          } else {
                                             this.salariesContrats.setSalconNbJourCp(0.0F);
                                          }
                                       } else if (var1.equalsIgnoreCase("salcon_nb_jour_tr")) {
                                          if (var2 != null && !var2.isEmpty()) {
                                             this.salariesContrats.setSalconNbJourTr(Float.parseFloat(var2));
                                          } else {
                                             this.salariesContrats.setSalconNbJourTr(0.0F);
                                          }
                                       } else if (var1.equalsIgnoreCase("salcon_cle1_anal")) {
                                          this.verifAnal1(var2, var3);
                                       } else if (!var1.equalsIgnoreCase("salcon_lib_cle1_anal")) {
                                          if (var1.equalsIgnoreCase("salcon_cle2_anal")) {
                                             this.verifAnal2(var2, var3);
                                          } else if (!var1.equalsIgnoreCase("salcon_lib_cle2_anal")) {
                                             if (var1.equalsIgnoreCase("salcon_id_tiers")) {
                                                this.verifTiers(var2, var3);
                                             } else if (!var1.equalsIgnoreCase("salcon_nom_tiers")) {
                                                if (var1.equalsIgnoreCase("salcon_date_avenant_deb1")) {
                                                   this.salariesContrats.setSalconDateAvenantDeb1(this.conversionDate(var2));
                                                } else if (var1.equalsIgnoreCase("salcon_date_avenant_fin1")) {
                                                   this.salariesContrats.setSalconDateAvenantFin1(this.conversionDate(var2));
                                                } else if (var1.equalsIgnoreCase("salcon_date_avenant_fin2")) {
                                                   this.salariesContrats.setSalconDateAvenantFin2(this.conversionDate(var2));
                                                } else if (var1.equalsIgnoreCase("salcon_date_avenant_fin3")) {
                                                   this.salariesContrats.setSalconDateAvenantFin3(this.conversionDate(var2));
                                                } else if (var1.equalsIgnoreCase("salcon_document")) {
                                                   this.salariesContrats.setSalconDocument(this.enlevePoint(var1));
                                                } else if (var1.equalsIgnoreCase("salcon_taux")) {
                                                   if (var2 != null && !var2.isEmpty()) {
                                                      this.salariesContrats.setSalconTaux(Float.parseFloat(var2));
                                                   } else {
                                                      this.salariesContrats.setSalconTaux(0.0F);
                                                   }
                                                } else if (var1.equalsIgnoreCase("salcon_nb_heure_mois")) {
                                                   if (var2 != null && !var2.isEmpty()) {
                                                      this.salariesContrats.setSalconNbHeureMois(Float.parseFloat(var2));
                                                   } else {
                                                      this.salariesContrats.setSalconNbHeureMois(0.0F);
                                                   }
                                                } else if (var1.equalsIgnoreCase("salcon_prime_transport")) {
                                                   this.salariesContrats.setSalconPrimeTransport(this.conversionDouble(var2));
                                                } else if (var1.equalsIgnoreCase("salcon_prime_logement")) {
                                                   this.salariesContrats.setSalconPrimeLogement(this.conversionDouble(var2));
                                                } else {
                                                   this.messageErreur = "La rubrique " + var1 + " n`existe pas...";
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
                  }
               }
            }
         }
      }

      if (this.messageErreur != null && !this.messageErreur.isEmpty()) {
         this.transfertPaye.setTrfNomFeuille(this.messageErreur);
         this.transfertPaye.setTrfPeriode("");
         this.transfertPaye.setTrfColT00(this.salaries.getSalActivite());
         this.transfertPaye.setTrfColT01(this.salaries.getSalMatricule());
         this.transfertPaye.setTrfColT02(this.salaries.getPatronyme());
         this.lesErreurs.add(this.transfertPaye);
      }

      return var4;
   }

   public void verifSite(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = this.enlevePoint(var1);
      if (var3 != null && !var3.isEmpty()) {
         var3 = var3.toUpperCase();
         this.site = this.siteDao.rechercheSite(var3, var2);
         if (this.site != null) {
            this.salaries.setSalSite(var3);
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconSite(var3);
            }
         } else {
            this.salaries.setSalSite("");
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconSite("");
            }

            this.messageErreur = "La site " + var3 + " du salarié " + this.salaries.getSalMatricule() + " n`existe pas....";
         }
      } else {
         this.salaries.setSalSite("");
         if (this.salariesContrats != null) {
            this.salariesContrats.setSalconSite("");
         }
      }

   }

   public void verifDepartement(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = this.enlevePoint(var1);
      if (var3 != null && !var3.isEmpty()) {
         var3 = var3.toUpperCase();
         this.departement = this.departementDao.rechercheDepartement(var3, var2);
         if (this.departement != null) {
            this.salaries.setSalDepartement(var3);
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconDepartement(var3);
            }
         } else {
            this.salaries.setSalDepartement("");
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconDepartement("");
            }

            this.messageErreur = "La département " + var3 + " du salarié " + this.salaries.getSalMatricule() + " n`existe pas....";
         }
      } else {
         this.salaries.setSalDepartement("");
         if (this.salariesContrats != null) {
            this.salariesContrats.setSalconDepartement("");
         }
      }

   }

   public void verifService(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = this.enlevePoint(var1);
      if (var3 != null && !var3.isEmpty()) {
         var3 = var3.toUpperCase();
         if (var3.equals("0") || var3.equals("1") || var3.equals("2") || var3.equals("3") || var3.equals("4") || var3.equals("5") || var3.equals("6") || var3.equals("7") || var3.equals("8") || var3.equals("9")) {
            var3 = "0" + var3;
         }

         this.service = this.serviceDao.rechercheService(var3, var2);
         if (this.service != null) {
            this.salaries.setSalService(var3);
            this.salaries.setSalLibService(this.service.getSerNomFr());
            this.salaries.setSalDepartement(this.service.getDepartement().getDepCode());
            this.salaries.setSalSite(this.service.getSite().getSitCode());
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconService(var3);
               this.salariesContrats.setSalconLibService(this.service.getSerNomFr());
               this.salariesContrats.setSalconDepartement(this.service.getDepartement().getDepCode());
               this.salariesContrats.setSalconSite(this.service.getSite().getSitCode());
            }
         } else {
            this.salaries.setSalService("");
            this.salaries.setSalLibService("");
            this.salaries.setSalDepartement("");
            this.salaries.setSalSite("");
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconService("");
               this.salariesContrats.setSalconLibService("");
               this.salariesContrats.setSalconDepartement("");
               this.salariesContrats.setSalconSite("");
            }

            this.messageErreur = "La service " + var3 + " du salarié " + this.salaries.getSalMatricule() + " n`existe pas....";
         }
      } else {
         this.salaries.setSalService("");
         this.salaries.setSalLibService("");
         this.salaries.setSalDepartement("");
         this.salaries.setSalSite("");
         if (this.salariesContrats != null) {
            this.salariesContrats.setSalconService("");
            this.salariesContrats.setSalconLibService("");
            this.salariesContrats.setSalconDepartement("");
            this.salariesContrats.setSalconSite("");
         }
      }

   }

   public void verifActivite(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = this.enlevePoint(var1);
      if (var3 != null && !var3.isEmpty()) {
         var3 = var3.toUpperCase();
         this.activites = this.activitesDao.rechercheActivite(var3, var2);
         if (this.activites != null) {
            this.salaries.setSalActivite(var3);
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconActivite(var3);
               this.salariesContrats.setSalconLibActivite(var3);
            }
         } else {
            this.salaries.setSalActivite("");
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconActivite("");
               this.salariesContrats.setSalconLibActivite("");
            }

            this.messageErreur = "L`activité " + var3 + " du salarié " + this.salaries.getSalMatricule() + " n`existe pas....";
         }
      } else {
         this.salaries.setSalActivite("");
         if (this.salariesContrats != null) {
            this.salariesContrats.setSalconActivite("");
            this.salariesContrats.setSalconLibActivite("");
         }
      }

   }

   public void verifLocalisation(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = this.enlevePoint(var1);
      if (var3 != null && !var3.isEmpty()) {
         var3 = var3.toUpperCase();
         this.localisationSalarie = this.localisationSalarieDao.chargeLieu(var3, var2);
         if (this.localisationSalarie != null) {
            this.salaries.setSalLocalisation(var3);
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconLocalisation(var3);
            }
         } else {
            this.salaries.setSalLocalisation("");
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconLocalisation("");
            }

            this.messageErreur = "La localisation " + var3 + " du salarié " + this.salaries.getSalMatricule() + " n`existe pas....";
         }
      } else {
         this.salaries.setSalLocalisation("");
         if (this.salariesContrats != null) {
            this.salariesContrats.setSalconLocalisation("");
         }
      }

   }

   public void verifBudget(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = this.enlevePoint(var1);
      if (var3 != null && !var3.isEmpty()) {
         var3 = var3.toUpperCase();
         this.budget = this.budgetDao.rechercheBudget(var3, var2);
         if (this.budget != null) {
            this.salaries.setSalBudget(var3);
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconBudget(var3);
               this.salariesContrats.setSalconLibBudget(this.budget.getBudLibelleFr());
            }
         } else {
            this.salaries.setSalBudget("");
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconBudget("");
               this.salariesContrats.setSalconLibBudget("");
            }

            this.messageErreur = "Le budget " + var3 + " du salarié " + this.salaries.getSalMatricule() + " n`existe pas....";
         }
      } else {
         this.salaries.setSalBudget("");
         if (this.salariesContrats != null) {
            this.salariesContrats.setSalconBudget("");
            this.salariesContrats.setSalconLibBudget("");
         }
      }

   }

   public void verifParc(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = this.enlevePoint(var1);
      if (var3 != null && !var3.isEmpty()) {
         var3 = var3.toUpperCase();
         this.parc = this.parcDao.rechercheParc(var3, var2);
         if (this.parc != null) {
            this.salaries.setSalParc(var3);
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconParc(var3);
            }
         } else {
            this.salaries.setSalParc("");
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconParc("");
            }

            this.messageErreur = "Le parc " + var3 + " du salarié " + this.salaries.getSalMatricule() + " n`existe pas....";
         }
      } else {
         this.salaries.setSalParc("");
         if (this.salariesContrats != null) {
            this.salariesContrats.setSalconParc("");
         }
      }

   }

   public void verifConvention(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = this.enlevePoint(var1);
      if (var3 != null && !var3.isEmpty()) {
         var3 = var3.toUpperCase();
         new ArrayList();
         List var4 = this.lectureConventions.getMesConventions();
         if (var4.size() != 0) {
            boolean var5 = false;

            for(int var6 = 0; var6 < var4.size(); ++var6) {
               if (((ObjetConvention)var4.get(var6)).getCode().equals(var3)) {
                  this.salaries.setSalConvention(((ObjetConvention)var4.get(var6)).getCode());
                  this.salaries.setSalLibConvention(((ObjetConvention)var4.get(var6)).getLib_FR());
                  if (this.salariesContrats != null) {
                     this.salariesContrats.setSalconConvention(((ObjetConvention)var4.get(var6)).getCode());
                     this.salariesContrats.setSalconLibConvention(((ObjetConvention)var4.get(var6)).getLib_FR());
                  }

                  var5 = true;
                  break;
               }
            }

            if (!var5) {
               this.salaries.setSalConvention("");
               this.salaries.setSalLibConvention("");
               if (this.salariesContrats != null) {
                  this.salariesContrats.setSalconConvention("");
                  this.salariesContrats.setSalconLibConvention("");
               }

               this.messageErreur = "La convention " + var3 + " du salarié " + this.salaries.getSalMatricule() + " n`existe pas....";
            }
         }
      } else {
         this.salaries.setSalConvention("");
         this.salaries.setSalLibConvention("");
         if (this.salariesContrats != null) {
            this.salariesContrats.setSalconConvention("");
            this.salariesContrats.setSalconLibConvention("");
         }
      }

   }

   public void verifGrille(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = this.enlevePoint(var1);
      if (var3 != null && !var3.isEmpty()) {
         var3 = var3.toUpperCase();
         if (this.salaries.getSalConvention() != null && !this.salaries.getSalConvention().isEmpty()) {
            LectureGrilleSalaire var4 = new LectureGrilleSalaire();
            var4.setStrId(this.structureLog.getStrid());
            var4.setStructureLog(this.structureLog);
            var4.recuperePaye(this.salaries.getSalConvention());
            new ArrayList();
            List var5 = var4.getMesGrillesSalaires();
            if (var5.size() != 0) {
               boolean var6 = false;

               for(int var7 = 0; var7 < var5.size(); ++var7) {
                  if (((ObjetGrilleSalaire)var5.get(var7)).getCode().equals(var3)) {
                     this.salaries.setSalGrille(((ObjetGrilleSalaire)var5.get(var7)).getCode());
                     this.salaries.setSalLibGrille(((ObjetGrilleSalaire)var5.get(var7)).getLib_FR());
                     if (this.salariesContrats != null) {
                        this.salariesContrats.setSalconGrille(((ObjetGrilleSalaire)var5.get(var7)).getCode());
                        this.salariesContrats.setSalconLibGrille(((ObjetGrilleSalaire)var5.get(var7)).getLib_FR());
                     }

                     var6 = true;
                     break;
                  }
               }

               if (!var6) {
                  this.salaries.setSalConvention("");
                  this.salaries.setSalLibConvention("");
                  if (this.salariesContrats != null) {
                     this.salariesContrats.setSalconGrille("");
                     this.salariesContrats.setSalconLibGrille("");
                  }

                  this.messageErreur = "La grille " + var3 + " du salarié " + this.salaries.getSalMatricule() + " n`existe pas....";
               }
            } else {
               this.salaries.setSalGrille("");
               this.salaries.setSalLibGrille("");
               if (this.salariesContrats != null) {
                  this.salariesContrats.setSalconGrille("");
                  this.salariesContrats.setSalconLibGrille("");
               }
            }
         } else {
            this.salaries.setSalGrille("");
            this.salaries.setSalLibGrille("");
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconGrille("");
               this.salariesContrats.setSalconLibGrille("");
            }
         }
      } else {
         this.salaries.setSalGrille("");
         this.salaries.setSalLibGrille("");
         if (this.salariesContrats != null) {
            this.salariesContrats.setSalconGrille("");
            this.salariesContrats.setSalconLibGrille("");
         }
      }

   }

   public void verifCentreImpot(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = this.enlevePoint(var1);
      if (var3 != null && !var3.isEmpty()) {
         var3 = var3.toUpperCase();
         new ArrayList();
         List var4 = this.lectureCentresImpots.getMesCentresImpots();
         if (var4.size() != 0) {
            boolean var5 = false;

            for(int var6 = 0; var6 < var4.size(); ++var6) {
               if (((ObjetCompte)var4.get(var6)).getCode().equals(var3)) {
                  this.salaries.setSalCentresImpots(((ObjetCompte)var4.get(var6)).getCode());
                  this.salaries.setSalLibCentresImpots(((ObjetCompte)var4.get(var6)).getNom_FR());
                  if (this.salariesContrats != null) {
                     this.salariesContrats.setSalconCentresImpots(((ObjetCompte)var4.get(var6)).getCode());
                     this.salariesContrats.setSalconLibCentresImpots(((ObjetCompte)var4.get(var6)).getNom_FR());
                  }

                  var5 = true;
                  break;
               }
            }

            if (!var5) {
               this.salaries.setSalCentresImpots("");
               this.salaries.setSalLibCentresImpots("");
               if (this.salariesContrats != null) {
                  this.salariesContrats.setSalconCentresImpots("");
                  this.salariesContrats.setSalconLibCentresImpots("");
               }

               this.messageErreur = "La centre d`impôt " + var3 + " du salarié " + this.salaries.getSalMatricule() + " n`existe pas....";
            }
         }
      } else {
         this.salaries.setSalCentresImpots("");
         this.salaries.setSalLibCentresImpots("");
         if (this.salariesContrats != null) {
            this.salariesContrats.setSalconCentresImpots("");
            this.salariesContrats.setSalconLibCentresImpots("");
         }
      }

   }

   public void verifCentreSecurite(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = this.enlevePoint(var1);
      if (var3 != null && !var3.isEmpty()) {
         var3 = var3.toUpperCase();
         new ArrayList();
         List var4 = this.lectureCentresSecuriteSociale.getMesCentresImpots();
         if (var4.size() != 0) {
            boolean var5 = false;

            for(int var6 = 0; var6 < var4.size(); ++var6) {
               if (((ObjetCompte)var4.get(var6)).getCode().equals(var3)) {
                  this.salaries.setSalCentresSecurite(((ObjetCompte)var4.get(var6)).getCode());
                  this.salaries.setSalLibCentresSecurite(((ObjetCompte)var4.get(var6)).getNom_FR());
                  if (this.salariesContrats != null) {
                     this.salariesContrats.setSalconCentresSecurite(((ObjetCompte)var4.get(var6)).getCode());
                     this.salariesContrats.setSalconLibCentresSecurite(((ObjetCompte)var4.get(var6)).getNom_FR());
                  }

                  var5 = true;
                  break;
               }
            }

            if (!var5) {
               this.salaries.setSalCentresSecurite("");
               this.salaries.setSalLibCentresSecurite("");
               if (this.salariesContrats != null) {
                  this.salariesContrats.setSalconCentresSecurite("");
                  this.salariesContrats.setSalconLibCentresSecurite("");
               }

               this.messageErreur = "La centre de sécurité sociale " + var3 + " du salarié " + this.salaries.getSalMatricule() + " n`existe pas....";
            }
         }
      } else {
         this.salaries.setSalCentresSecurite("");
         this.salaries.setSalLibCentresSecurite("");
         if (this.salariesContrats != null) {
            this.salariesContrats.setSalconCentresSecurite("");
            this.salariesContrats.setSalconLibCentresSecurite("");
         }
      }

   }

   public void verifClassement(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = this.enlevePoint(var1);
      if (var3 != null && !var3.isEmpty()) {
         var3 = var3.toUpperCase();
         new ArrayList();
         List var4 = this.lectureClassementsAgents.getMesClassements();
         if (var4.size() != 0) {
            boolean var5 = false;

            for(int var6 = 0; var6 < var4.size(); ++var6) {
               if (((ObjetCompte)var4.get(var6)).getCode().equals(var3)) {
                  this.salaries.setSalClassement(((ObjetCompte)var4.get(var6)).getCode());
                  this.salaries.setSalLibClassement(((ObjetCompte)var4.get(var6)).getNom_FR());
                  if (this.salariesContrats != null) {
                     this.salariesContrats.setSalconClassement(((ObjetCompte)var4.get(var6)).getCode());
                     this.salariesContrats.setSalconLibClassement(((ObjetCompte)var4.get(var6)).getNom_FR());
                  }

                  var5 = true;
                  break;
               }
            }

            if (!var5) {
               this.salaries.setSalClassement("");
               this.salaries.setSalLibClassement("");
               if (this.salariesContrats != null) {
                  this.salariesContrats.setSalconClassement("");
                  this.salariesContrats.setSalconLibClassement("");
               }

               this.messageErreur = "La classement " + var3 + " du salarié " + this.salaries.getSalMatricule() + " n`existe pas....";
            }
         }
      } else {
         this.salaries.setSalClassement("");
         this.salaries.setSalLibClassement("");
         if (this.salariesContrats != null) {
            this.salariesContrats.setSalconClassement("");
            this.salariesContrats.setSalconLibClassement("");
         }
      }

   }

   public void verifNiveauEmploi(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = this.enlevePoint(var1);
      if (var3 != null && !var3.isEmpty()) {
         var3 = var3.toUpperCase();
         new ArrayList();
         List var4 = this.lectureNiveauxEmplois.getMesNiveauxEmplois();
         if (var4.size() != 0) {
            boolean var5 = false;

            for(int var6 = 0; var6 < var4.size(); ++var6) {
               if (((ObjetCompte)var4.get(var6)).getCode().equals(var3)) {
                  this.salaries.setSalNivEmploi(((ObjetCompte)var4.get(var6)).getCode());
                  this.salaries.setSalLibNivEmploi(((ObjetCompte)var4.get(var6)).getNom_FR());
                  if (this.salariesContrats != null) {
                     this.salariesContrats.setSalconNivEmploi(((ObjetCompte)var4.get(var6)).getCode());
                     this.salariesContrats.setSalconLibNivEmploi(((ObjetCompte)var4.get(var6)).getNom_FR());
                  }

                  var5 = true;
                  break;
               }
            }

            if (!var5) {
               this.salaries.setSalNivEmploi("");
               this.salaries.setSalLibNivEmploi("");
               if (this.salariesContrats != null) {
                  this.salariesContrats.setSalconNivEmploi("");
                  this.salariesContrats.setSalconLibNivEmploi("");
               }

               this.messageErreur = "Le niveaud`emploi " + var3 + " du salarié " + this.salaries.getSalMatricule() + " n`existe pas....";
            }
         }
      } else {
         this.salaries.setSalNivEmploi("");
         this.salaries.setSalLibNivEmploi("");
         if (this.salariesContrats != null) {
            this.salariesContrats.setSalconNivEmploi("");
            this.salariesContrats.setSalconLibNivEmploi("");
         }
      }

   }

   public void verifFeuille(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = this.enlevePoint(var1);
      if (var3 != null && !var3.isEmpty()) {
         var3 = var3.toUpperCase();
         this.feuilleCalcul = this.feuilleCalculDao.chercherCode(var3, 0L, var2);
         if (this.feuilleCalcul != null) {
            this.salaries.setSalFeuille(var3);
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconFeuille(var3);
            }
         } else {
            this.salaries.setSalFeuille("");
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconFeuille("");
            }

            this.messageErreur = "La feuille " + var3 + " du salarié " + this.salaries.getSalMatricule() + " n`existe pas....";
         }
      } else {
         this.salaries.setSalFeuille("");
      }

   }

   public void verifProjet(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = this.enlevePoint(var1);
      if (var3 != null && !var3.isEmpty()) {
         var3 = var3.toUpperCase();
         this.projets = this.projetsDao.chargerLeProjet(0, var3, var2);
         if (this.projets != null) {
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconProjet(var3);
               this.salariesContrats.setSalconLibProjet(this.projets.getProNomFR());
            }
         } else {
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconProjet("");
               this.salariesContrats.setSalconLibProjet("");
            }

            this.messageErreur = "Le projet " + var3 + " du salarié " + this.salaries.getSalMatricule() + " n`existe pas....";
         }
      } else if (this.salariesContrats != null) {
         this.salariesContrats.setSalconProjet("");
         this.salariesContrats.setSalconLibProjet("");
      }

   }

   public void verifAnal1(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = this.enlevePoint(var1);
      if (var3 != null && !var3.isEmpty()) {
         var3 = var3.toUpperCase();
         this.plansAnalytiques = this.plansAnalytiquesDao.rechercheAnal("9", var1, var2);
         if (this.plansAnalytiques != null) {
            this.salaries.setSalCleAnal1(var3);
            this.salaries.setSalLibCleAnal1(this.plansAnalytiques.getAnaNomFr());
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconCle1Anal(var3);
               this.salariesContrats.setSalconLibCle1Anal(this.plansAnalytiques.getAnaNomFr());
            }
         } else {
            this.salaries.setSalCleAnal1("");
            this.salaries.setSalLibCleAnal1("");
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconCle1Anal("");
               this.salariesContrats.setSalconLibCle1Anal("");
            }

            this.messageErreur = "La clé 1 " + var3 + " du salarié " + this.salaries.getSalMatricule() + " n`existe pas....";
         }
      } else {
         this.salaries.setSalCleAnal1("");
         this.salaries.setSalLibCleAnal1("");
         if (this.salariesContrats != null) {
            this.salariesContrats.setSalconCle1Anal("");
            this.salariesContrats.setSalconLibCle1Anal("");
         }
      }

   }

   public void verifAnal2(String var1, Session var2) throws HibernateException, NamingException {
      String var3 = this.enlevePoint(var1);
      if (var3 != null && !var3.isEmpty()) {
         var3 = var3.toUpperCase();
         this.plansAnalytiques = this.plansAnalytiquesDao.rechercheAnal("9", var1, var2);
         if (this.plansAnalytiques != null) {
            this.salaries.setSalCleAnal2(var3);
            this.salaries.setSalLibCleAnal2(this.plansAnalytiques.getAnaNomFr());
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconCle2Anal(var3);
               this.salariesContrats.setSalconLibCle2Anal(this.plansAnalytiques.getAnaNomFr());
            }
         } else {
            this.salaries.setSalCleAnal2("");
            this.salaries.setSalLibCleAnal2("");
            if (this.salariesContrats != null) {
               this.salariesContrats.setSalconCle2Anal("");
               this.salariesContrats.setSalconLibCle2Anal("");
            }

            this.messageErreur = "La clé 2 " + var3 + " du salarié " + this.salaries.getSalMatricule() + " n`existe pas....";
         }
      } else {
         this.salaries.setSalCleAnal2("");
         this.salaries.setSalLibCleAnal2("");
         if (this.salariesContrats != null) {
            this.salariesContrats.setSalconCle2Anal("");
            this.salariesContrats.setSalconLibCle2Anal("");
         }
      }

   }

   public void verifTiers(String var1, Session var2) throws HibernateException, NamingException {
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

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
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

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
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

   public List getLesFeuilles() {
      return this.lesFeuilles;
   }

   public void setLesFeuilles(List var1) {
      this.lesFeuilles = var1;
   }

   public BulletinSalaire getBulletinSalaire() {
      return this.bulletinSalaire;
   }

   public void setBulletinSalaire(BulletinSalaire var1) {
      this.bulletinSalaire = var1;
   }

   public List getLesFeuillesItems() {
      return this.lesFeuillesItems;
   }

   public void setLesFeuillesItems(List var1) {
      this.lesFeuillesItems = var1;
   }

   public List getLesPeriodesItems() {
      return this.lesPeriodesItems;
   }

   public void setLesPeriodesItems(List var1) {
      this.lesPeriodesItems = var1;
   }

   public String getNumFeuille() {
      return this.numFeuille;
   }

   public void setNumFeuille(String var1) {
      this.numFeuille = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public DataModel getDatamodelDocument() {
      return this.datamodelDocument;
   }

   public void setDatamodelDocument(DataModel var1) {
      this.datamodelDocument = var1;
   }

   public List getListDocument() {
      return this.listDocument;
   }

   public void setListDocument(List var1) {
      this.listDocument = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public boolean isImportSage() {
      return this.importSage;
   }

   public void setImportSage(boolean var1) {
      this.importSage = var1;
   }

   public int getVar_choix_importation() {
      return this.var_choix_importation;
   }

   public void setVar_choix_importation(int var1) {
      this.var_choix_importation = var1;
   }

   public boolean isVariableExcel() {
      return this.variableExcel;
   }

   public void setVariableExcel(boolean var1) {
      this.variableExcel = var1;
   }

   public int getBalance() {
      return this.balance;
   }

   public void setBalance(int var1) {
      this.balance = var1;
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

   public boolean isVar_showBarProgMaj() {
      return this.var_showBarProgMaj;
   }

   public void setVar_showBarProgMaj(boolean var1) {
      this.var_showBarProgMaj = var1;
   }

   public DataModel getDataModelChampContrat() {
      return this.dataModelChampContrat;
   }

   public void setDataModelChampContrat(DataModel var1) {
      this.dataModelChampContrat = var1;
   }

   public DataModel getDataModelChampSalarie() {
      return this.dataModelChampSalarie;
   }

   public void setDataModelChampSalarie(DataModel var1) {
      this.dataModelChampSalarie = var1;
   }
}
