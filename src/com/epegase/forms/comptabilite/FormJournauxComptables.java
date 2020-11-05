package com.epegase.forms.comptabilite;

import com.epegase.forms.commun.FormAnalytique;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Brouillard;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.Devise;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresAnalytique;
import com.epegase.systeme.classe.EcrituresModeles;
import com.epegase.systeme.classe.EcrituresModelesLignes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.JournauxMois;
import com.epegase.systeme.classe.Mails;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.PlansTresorerie;
import com.epegase.systeme.classe.Racines;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.EcrituresLight;
import com.epegase.systeme.dao.BrouillardDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.EcrituresAnalytiquesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.EcrituresModelesDao;
import com.epegase.systeme.dao.EcrituresModelesLignesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.JournauxMoisDao;
import com.epegase.systeme.dao.MailsDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.RacinesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilMail;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTrie;
import com.epegase.systeme.xml.OptionComptabilite;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.apache.taglibs.standard.extra.spath.ParseException;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;

public class FormJournauxComptables implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action;
   private int var_memo_action;
   private boolean modeConsultation;
   private String pageIndex;
   private int nature;
   private FormRecherche formRecherche;
   private OptionComptabilite optionComptabilite;
   private ExercicesComptable selectedExo;
   private ExercicesComptable lastExo;
   private int var_nb_max = 100;
   private boolean var_acces_direct = false;
   private String var_piece_compte;
   private String var_journal_compte;
   private List lesjournauxActifs = new LinkedList();
   private List lesjournauxMois = new LinkedList();
   private JournauxComptables journauxActif = new JournauxComptables();
   private JournauxMois journauxMois = new JournauxMois();
   private transient DataModel datamodelJournaux = new ListDataModel();
   private UIDataTable extDTableJournaux = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionJournaux = new SimpleSelection();
   private transient DataModel dataModelMois = new ListDataModel();
   private UIDataTable extDTablePeriode = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionPeriode = new SimpleSelection();
   private JournauxMoisDao journauxMoisDao;
   private JournauxComptablesDao journauxComptablesDao;
   private boolean afficheTJM = false;
   private int nbPeriode;
   private List mesPeriodes = new LinkedList();
   private boolean sansChrono = false;
   private int modeAcces = 0;
   private transient DataModel dataModelListeCompte = new ListDataModel();
   private boolean showModalPanelListeCompte = false;
   private List lesDevises = new LinkedList();
   private boolean showModalPanelSupprimer = false;
   private Ecritures ecritures = new Ecritures();
   private EcrituresDao ecrituresDao;
   private List lesEcritures = new LinkedList();
   private transient DataModel datamodelEcritures = new ListDataModel();
   private String var_periode;
   private int var_jr_nature;
   private int var_format_devise;
   private UtilDate utilDate = new UtilDate();
   private UtilNombre utilNombre = new UtilNombre();
   private boolean testfermerleJournal = true;
   private String cpTreso;
   private String var_hauteur;
   private String var_nom_champ;
   private int var_type_compte;
   private PlanComptable planComptable = new PlanComptable();
   private PlanComptableDao planComptableDao;
   private double totalMvtscredit;
   private double totalMvtsdebit;
   private double soldeMvts;
   private double soldeCred;
   private double soldeDeb;
   private double soldefinalCred;
   private double soldefinalDeb;
   private double debitAnterieur;
   private double creditAnterieur;
   private double soldeAnterieur;
   private List lesjoursItems = new LinkedList();
   private boolean testAffSuppImpList;
   private boolean showModalPanelLpr = false;
   private boolean var_modif = false;
   private Date dateDebut;
   private Date dateFin;
   private boolean var_affiche_analytique = false;
   private boolean showModalPanelAnalytique = false;
   private long var_memo_ligne_gene;
   private FormAnalytique formAnalytique;
   private boolean var_affiche_dossier;
   private transient DataModel datamodelDossier = new ListDataModel();
   private String codeDossier;
   private boolean showModalPanelDossier = false;
   private Brouillard brouillard;
   private boolean showModalPanelBrouillard = false;
   private BrouillardDao brouillardDao;
   private String userBrouillard;
   private boolean testAffBrouillard = false;
   private boolean pieceVide = true;
   private boolean ligneSel = false;
   private int modeImp = 0;
   private List lesModelsimpression = new ArrayList();
   private boolean showModalPanelPrint = false;
   private Espion espion = new Espion();
   private EspionDao espionDao;
   private int modeSupp = 100;
   private boolean testnat = false;
   private Chrono chrono;
   private CalculChrono calculChrono;
   private ChronoDao chronoDao;
   private boolean verrouNum = false;
   private String memoRef1;
   private String memoRef2;
   private String memoLib;
   private String memoCompte;
   private String memoCP;
   private Date memoDteEche;
   private Date memoDteVal;
   private double memoDebit;
   private double memoCredit;
   private int memoNatCompte;
   private int memoJour;
   private String memoPiece;
   private UtilDate dateEcheance;
   private boolean disableEcheance = true;
   private int valindexD = 11;
   private int valindexC = 12;
   private boolean showModalPanelValidation = false;
   private int var_choix_validation;
   private int var_jourDebut;
   private int var_jourFin;
   private List lesPiecesSelectionnes = new ArrayList();
   private List lesPeriodes = new ArrayList();
   private String periode;
   private boolean showModalPanelCreationCompte = false;
   private String maNature;
   private String maRacine;
   private String racinecle;
   private boolean existeCopteDeja = false;
   private List mesNatureCompteItem = new ArrayList();
   private List mesRacineCompteItem = new ArrayList();
   private int nombrCaracter;
   private String partieCompte;
   private int nbcarmax;
   private boolean showModalPanelPiece = false;
   private String var_nouveau_numero;
   private String var_ancien_numero;
   private int var_mode_chg;
   private long ecrIdMemo;
   private boolean forceVerrou;
   private boolean testAffOutilsCorr = false;
   private int outilChoisi;
   private List toolsLesJournauxComptables;
   private String toolsCode;
   private List toolsLesPeriode;
   private String toolsPeriode;
   private String toolsCompteOld;
   private List lesEcrituresAReimputer;
   private transient DataModel dataModelEcritureAReimputer;
   private boolean showModalPanelCorrection = false;
   private boolean showModalPanelAnalytiqueCorrection = false;
   private boolean afficheBudgetTresoProjet = false;
   private boolean afficheBudgetTresoStandard = false;
   private PlansTresorerie plansTresorerie = new PlansTresorerie();
   private String memo_compte_budgetTreso;
   private boolean comptaProjet;
   private FormExtraitCompte formExtraitCompte;
   private List lesModelesAutorises;
   private boolean showModalPanelPJ = false;
   private boolean showModalPanelAjoutPJ = false;
   private int modePj;
   private boolean conditionPj;
   private String valueScanPj;
   private UploadedFile uploadedFile;
   private UtilDownload utilDownload = new UtilDownload();
   private String urlphotoProd;
   private static final int DEFAULT_BUFFER_SIZE = 10240;
   private int typeFichier;
   private String fichierMine;
   private URL fichierUrl;
   private String urlExplorateur;
   private List lesPjSecretariat = new ArrayList();
   private transient DataModel dataModelPjSecretariat = new ListDataModel();
   private Mails mails = new Mails();
   private int choixRacine;
   private String selecFiscalite;
   private boolean showModalPanelInformation = false;
   private String nomCreation;
   private String nomModification;
   private EcrituresModelesDao ecrituresModelesDao;
   private EcrituresModelesLignesDao ecrituresModelesLignesDao;
   private EcrituresModeles ecrituresModeles;
   private boolean showModalPanelModele = false;
   private List mesModelesItems = new ArrayList();
   private List lesEcrituresModeles = new ArrayList();
   private transient DataModel dataModelEcrituresModele = new ListDataModel();
   private String codeModele;
   private double montantModele;
   private int jourModele;
   private String libelleModele;
   private String referenceModele;
   private String pieceModele;

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.journauxMoisDao = new JournauxMoisDao(this.baseLog, this.utilInitHibernate);
      this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresDao = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresModelesDao = new EcrituresModelesDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresModelesLignesDao = new EcrituresModelesLignesDao(this.baseLog, this.utilInitHibernate);
   }

   public void initAnalytique() {
      this.dateDebut = this.selectedExo.getExecptDateDebut();
      this.dateFin = this.selectedExo.getExecptDateFin();
      this.periode = "PERIODE du " + this.utilDate.dateToStringFr(this.dateDebut) + " au " + this.utilDate.dateToStringFr(this.dateFin);
      if (this.optionComptabilite.getNbLigneMaxJr() != null && !this.optionComptabilite.getNbLigneMaxJr().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionComptabilite.getNbLigneMaxJr());
      } else {
         this.var_nb_max = 100;
      }

      if (this.optionComptabilite.getAnalytique().equals("true")) {
         this.var_affiche_analytique = true;
         this.formAnalytique = new FormAnalytique(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
      } else {
         this.var_affiche_analytique = false;
      }

      if (this.structureLog.getStrDossier() == 3) {
         this.var_affiche_dossier = true;
      } else {
         this.var_affiche_dossier = false;
      }

      this.testAffOutilsCorr = false;
      if (this.usersLog.getUsrAccesCorrection() == 1 && this.selectedExo.getExecpt_id() == this.lastExo.getExecpt_id() && this.selectedExo.getExecptEtat() == 0) {
         this.testAffOutilsCorr = true;
      }

      this.comptaProjet = this.rechercheModule(40300);
      this.var_action = 0;
      this.selecFiscalite = this.structureLog.getStrzonefiscale();
      if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty()) {
         long var1 = (long)(this.selectedExo.getExecptDateDebut().getYear() + 1900);
         long var3 = (long)(this.selectedExo.getExecptDateFin().getYear() + 1900);
         if (this.structureLog.getStrdatefiscale2() != null && var1 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900) && var3 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900)) {
            this.selecFiscalite = this.structureLog.getStrzonefiscale2();
         } else if (this.structureLog.getStrdatefiscale2() != null && var1 < (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900) && var3 < (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900)) {
            this.selecFiscalite = this.structureLog.getStrzonefiscale();
         } else {
            this.selecFiscalite = null;
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

   public void calculPeriode() throws ParseException {
      this.nbPeriode = 0;
      this.mesPeriodes.clear();
      Date var1 = this.selectedExo.getExecptDateDebut();
      GregorianCalendar var2 = new GregorianCalendar();
      var2.setTime(var1);
      Date var3 = this.selectedExo.getExecptDateFin();
      GregorianCalendar var4 = new GregorianCalendar();
      var4.setTime(var3);
      var2.add(2, -1);
      var4.add(2, -1);
      String var5 = null;

      while(var2.compareTo(var4) < 0) {
         var2.add(2, 1);
         Date var6 = var2.getTime();
         var5 = this.formatPeriode(var6);
         ++this.nbPeriode;
         this.mesPeriodes.add(var5);
         this.lesPeriodes.add(new SelectItem(var5));
      }

   }

   public void calculUnePeriode(Date var1) throws ParseException, java.text.ParseException {
      this.nbPeriode = 0;
      this.mesPeriodes.clear();
      GregorianCalendar var3 = new GregorianCalendar();
      var3.setTime(var1);
      String var4 = null;
      Date var5 = var3.getTime();
      var4 = this.formatPeriode(var5);
      this.nbPeriode = 1;
      this.mesPeriodes.add(var4);
      this.lesPeriodes.add(new SelectItem(var4));
      this.selecFiscalite = this.structureLog.getStrzonefiscale();
      if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty()) {
         long var6 = (long)(var1.getYear() + 1900);
         if (this.structureLog.getStrdatefiscale2() != null && (var1.compareTo(this.structureLog.getStrdatefiscale2()) > 0 || var6 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900))) {
            this.selecFiscalite = this.structureLog.getStrzonefiscale2();
         }
      }

   }

   public void calculUnePiece(String var1) throws ParseException {
      this.var_piece_compte = var1;
   }

   public void calculUnJournal(String var1) throws ParseException {
      this.var_journal_compte = var1;
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

   public void chargerLesJournauxComptable(Session var1) throws HibernateException, NamingException {
      this.var_acces_direct = true;
      this.lesjournauxActifs.clear();
      this.lesjournauxActifs = this.journauxComptablesDao.mesjournauxActifs(this.selectedExo.getExecpt_id(), this.usersLog.getUsrJrxInterdit(), this.usersLog.getUsrJrxReserve(), var1);
      if (this.lesjournauxActifs != null) {
         String var2 = "" + this.selectedExo.getExecpt_id();

         for(int var3 = 0; var3 < this.lesjournauxActifs.size(); ++var3) {
            this.journauxActif = new JournauxComptables();
            this.journauxActif = (JournauxComptables)this.lesjournauxActifs.get(var3);
            if (this.journauxActif.getPljPiece() != 0) {
               this.chrono = new Chrono();
               this.chrono = this.chronoDao.chronoByNatAndJournalPeriode(this.nature, this.journauxActif.getPljCode(), var2, var1);
               if (this.chrono == null) {
                  this.journauxActif.setPljLibelleFr(this.journauxActif.getPljLibelleFr() + " (***SANS CHRONO***)");
               }
            }
         }
      }

      this.datamodelJournaux.setWrappedData(this.lesjournauxActifs);
   }

   public void calculerLesJournauxComptable(String var1, Session var2) throws HibernateException, NamingException {
      this.var_acces_direct = false;
      this.lesjournauxActifs.clear();
      this.lesjournauxActifs = this.journauxComptablesDao.unJournalActif(this.selectedExo.getExecpt_id(), this.usersLog.getUsrJrxInterdit(), this.usersLog.getUsrJrxReserve(), var1, var2);
      this.datamodelJournaux.setWrappedData(this.lesjournauxActifs);
   }

   public void chargerLesDevises(Session var1) throws HibernateException, NamingException {
      this.lesDevises.clear();
      if (this.journauxActif.getPljTypeDevise() == 0) {
         this.lesDevises.add(new SelectItem(this.structureLog.getStrdevise()));
      } else if (this.journauxActif.getPljTypeDevise() == 1) {
         this.lesDevises.add(new SelectItem(this.journauxActif.getPljChoixDevise()));
      } else if (this.journauxActif.getPljTypeDevise() == 2) {
         this.lesDevises.add(new SelectItem(this.structureLog.getStrdevise()));
         new ArrayList();
         DeviseDao var3 = new DeviseDao(this.baseLog, this.utilInitHibernate);
         List var2 = var3.chargerLesDevises(var1);
         if (var2.size() != 0) {
            for(int var4 = 0; var4 < var2.size(); ++var4) {
               this.lesDevises.add(new SelectItem(((Devise)var2.get(var4)).getDevCode()));
            }
         }
      }

   }

   public boolean testCompteBudget() {
      boolean var1 = false;
      if (this.ecritures.getEcrNature() == 1) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c1());
      } else if (this.ecritures.getEcrNature() == 2) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c2());
      } else if (this.ecritures.getEcrNature() == 3) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c3());
      } else if (this.ecritures.getEcrNature() == 4) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c4());
      } else if (this.ecritures.getEcrNature() == 5) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c5());
      } else if (this.ecritures.getEcrNature() == 6) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c6());
      } else if (this.ecritures.getEcrNature() == 7) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c7());
      } else if (this.ecritures.getEcrNature() == 8) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c8());
      } else if (this.ecritures.getEcrNature() == 9) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c9());
      } else if (this.ecritures.getEcrNature() == 10) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c10());
      } else if (this.ecritures.getEcrNature() == 11) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c11());
      } else if (this.ecritures.getEcrNature() == 12) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c12());
      } else if (this.ecritures.getEcrNature() == 13) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c13());
      } else if (this.ecritures.getEcrNature() == 14) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c14());
      } else if (this.ecritures.getEcrNature() == 15) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c15());
      } else if (this.ecritures.getEcrNature() == 16) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c16());
      } else if (this.ecritures.getEcrNature() == 17) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c17());
      } else if (this.ecritures.getEcrNature() == 18) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c18());
      } else if (this.ecritures.getEcrNature() == 19) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c19());
      } else if (this.ecritures.getEcrNature() == 20) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c20());
      } else if (this.ecritures.getEcrNature() == 21) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c21());
      } else if (this.ecritures.getEcrNature() == 22) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c22());
      } else if (this.ecritures.getEcrNature() == 23) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c23());
      } else if (this.ecritures.getEcrNature() == 24) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c24());
      }

      return var1;
   }

   public boolean testCompteAnalytique() {
      boolean var1 = false;
      if (this.ecritures.getEcrNature() == 1) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c1());
      } else if (this.ecritures.getEcrNature() == 2) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c2());
      } else if (this.ecritures.getEcrNature() == 3) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c3());
      } else if (this.ecritures.getEcrNature() == 4) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c4());
      } else if (this.ecritures.getEcrNature() == 5) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c5());
      } else if (this.ecritures.getEcrNature() == 6) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c6());
      } else if (this.ecritures.getEcrNature() == 7) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c7());
      } else if (this.ecritures.getEcrNature() == 8) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c8());
      } else if (this.ecritures.getEcrNature() == 9) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c9());
      } else if (this.ecritures.getEcrNature() == 10) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c10());
      } else if (this.ecritures.getEcrNature() == 11) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c11());
      } else if (this.ecritures.getEcrNature() == 12) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c12());
      } else if (this.ecritures.getEcrNature() == 13) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c13());
      } else if (this.ecritures.getEcrNature() == 14) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c14());
      } else if (this.ecritures.getEcrNature() == 15) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c15());
      } else if (this.ecritures.getEcrNature() == 16) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c16());
      } else if (this.ecritures.getEcrNature() == 17) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c17());
      } else if (this.ecritures.getEcrNature() == 18) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c18());
      } else if (this.ecritures.getEcrNature() == 19) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c19());
      } else if (this.ecritures.getEcrNature() == 20) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c20());
      } else if (this.ecritures.getEcrNature() == 21) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c21());
      } else if (this.ecritures.getEcrNature() == 22) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c22());
      } else if (this.ecritures.getEcrNature() == 23) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c23());
      } else if (this.ecritures.getEcrNature() == 24) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c24());
      } else {
         var1 = false;
      }

      return var1;
   }

   public String calculeCompteTreso(String var1) throws java.text.ParseException {
      this.cpTreso = "";
      if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty() && var1 != null && !var1.isEmpty()) {
         Date var2 = null;
         String[] var3 = this.journauxMois.getJoumenPeriode().split(":");
         String var4 = var3[0];
         String var5 = var3[1];
         var2 = this.utilDate.stringToDateSQLLight(var5 + "-" + var4 + "-" + "01");
         long var6 = (long)(var2.getYear() + 1900);
         if (this.structureLog.getStrdatefiscale2() == null || var2.compareTo(this.structureLog.getStrdatefiscale2()) <= 0 && var6 < (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900)) {
            this.cpTreso = this.journauxActif.getPljCompteTreso();
         } else {
            this.cpTreso = this.journauxActif.getPljCompteTresoNew();
         }
      } else {
         this.cpTreso = this.journauxActif.getPljCompteTreso();
      }

      if (this.cpTreso == null || this.cpTreso.isEmpty()) {
         this.cpTreso = "***COMPTE ABSENT***";
      }

      return this.cpTreso;
   }

   public void selectionJournauxActifs() throws NamingException {
      if (this.extDTableJournaux != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionJournaux.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTableJournaux.setRowKey(var3);
            if (this.extDTableJournaux.isRowAvailable()) {
               var1.add(this.extDTableJournaux.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.journauxActif = (JournauxComptables)var1.get(0);
            this.selectionJournauxActifsSuite();
         }
      }

   }

   public void selectionJournauxActifsSuite() throws NamingException {
      if (this.journauxActif != null) {
         this.afficheTJM = true;
         if (this.journauxActif.getPljLibelleFr().contains("(***SANS CHRONO***)")) {
            this.sansChrono = true;
         } else {
            this.sansChrono = false;
         }

         this.lesjournauxMois.clear();
         this.lesjournauxMois = this.journauxMoisDao.mesjournauxmois(this.journauxActif.getPljCode(), this.selectedExo, (Session)null);
         if (this.nbPeriode > this.lesjournauxMois.size()) {
            this.journauxMoisDao.ajoutPeriode(this.journauxActif, this.selectedExo, this.mesPeriodes);
            this.lesjournauxMois.clear();
            this.lesjournauxMois = this.journauxMoisDao.mesjournauxmois(this.journauxActif.getPljCode(), this.selectedExo, (Session)null);
         }

         UtilTrie var1 = new UtilTrie();
         this.lesjournauxMois = var1.triListeJournaux(this.lesjournauxMois);
         this.lesjournauxMois = var1.triListeJournaux(this.lesjournauxMois);
         this.dataModelMois.setWrappedData(this.lesjournauxMois);
         this.chargerLesDevises((Session)null);
         this.journauxMois = null;
      }

   }

   public void selectionMoisSaisieLight() throws HibernateException, NamingException, ParseException {
      if (this.journauxActif != null && this.extDTablePeriode != null) {
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

         for(int var5 = 0; var5 < this.lesjournauxMois.size(); ++var5) {
            this.journauxMois = (JournauxMois)this.lesjournauxMois.get(var5);
            if (var5 == var1) {
               this.journauxMois.setSelect(true);
            } else {
               this.journauxMois.setSelect(false);
            }
         }

         if (var2.size() != 0) {
            this.journauxMois = (JournauxMois)var2.get(0);
         }
      }

   }

   public void selectionMoisSaisie() throws HibernateException, NamingException, java.text.ParseException {
      if (this.extDTablePeriode != null) {
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
            this.journauxMois = (JournauxMois)var1.get(0);
            this.journauxMois = this.journauxMoisDao.recupererJournauxMois(this.journauxMois.getJoumenCle1(), this.selectedExo, (Session)null);
            if (this.journauxMois.getJoumenUserIdJournal() != 0L && this.journauxMois.getJoumenUserIdJournal() != this.usersLog.getUsrid()) {
               this.afficheTJM = false;
               StaticModePegase.setTexte_message("Ce journal est déjà ouvert avec un autre utilisateur...");
               StaticModePegase.setAffiche_message(true);
            } else {
               this.selecFiscalite = this.structureLog.getStrzonefiscale();
               String var4;
               if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty()) {
                  String[] var14 = this.journauxMois.getJoumenPeriode().split(":");
                  var4 = var14[0];
                  String var5 = var14[1];
                  Date var6 = this.utilDate.stringToDateSQLLight(var5 + "-" + var4 + "-" + "01");
                  long var7 = (long)(var6.getYear() + 1900);
                  if (this.structureLog.getStrdatefiscale2() != null && (var6.compareTo(this.structureLog.getStrdatefiscale2()) > 0 || var7 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900))) {
                     this.selecFiscalite = this.structureLog.getStrzonefiscale2();
                  }
               }

               this.ouvrirLeJournalEncours();
               Session var15 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
               var4 = null;

               try {
                  Transaction var16 = var15.beginTransaction();
                  this.var_periode = this.journauxMois.getJoumenPeriode();
                  if (this.journauxActif.getPljNature() != 7 && this.journauxActif.getPljNature() != 8 && this.journauxActif.getPljNature() != 9 && this.journauxActif.getPljNature() != 10) {
                     this.debitAnterieur = 0.0D;
                     this.creditAnterieur = 0.0D;
                     this.cpTreso = "";
                     this.var_hauteur = "height:110px";
                  } else {
                     this.cpTreso = this.calculeCompteTreso(this.journauxMois.getJoumenPeriode());
                     this.calculerSoldeAnterieur(var15);
                     this.var_hauteur = "height:140px";
                  }

                  this.ChargerLesEcritures(var15);
                  this.calculLesJourDunMois();
                  if (!this.optionComptabilite.getTrf_brl().equalsIgnoreCase("1") && this.journauxMois.getJoumenEtat() == 0 && this.journauxActif.getPljSasieInterdite() != 1) {
                     if (this.selectedExo.getExecpt_id() != this.lastExo.getExecpt_id()) {
                        this.var_action = 3;
                     } else {
                        this.var_action = 1;
                     }
                  } else {
                     this.var_action = 3;
                  }

                  this.var_memo_action = this.var_action;
                  this.verifExitChrono(var15);
                  var16.commit();
               } catch (HibernateException var12) {
                  if (var4 != null) {
                     var4.rollback();
                  }

                  throw var12;
               } finally {
                  this.utilInitHibernate.closeSession();
               }

               this.ajouterLigne();
            }
         }
      }

   }

   public boolean ouvrirAPartirExtraitCompte() throws HibernateException, NamingException, java.text.ParseException {
      boolean var1 = false;
      this.journauxActif = (JournauxComptables)this.lesjournauxActifs.get(0);
      if (this.journauxActif != null) {
         String var2 = this.journauxActif.getPljCode() + ":" + this.mesPeriodes.get(0).toString();
         String[] var3 = this.mesPeriodes.get(0).toString().split(":");
         long var4 = Long.parseLong(var3[1]);
         if (var4 != this.selectedExo.getExecpt_id()) {
            ExercicesComptableDao var6 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
            this.selectedExo = var6.recupererLExoSelect(var4, (Session)null);
         }

         this.journauxMois = this.journauxMoisDao.recupererJournauxMois(var2, this.selectedExo, (Session)null);
         if (this.journauxMois != null && (this.journauxMois.getJoumenUserIdJournal() == 0L || this.journauxMois.getJoumenUserIdJournal() == this.usersLog.getUsrid())) {
            this.ouvrirLeJournalEncours();
            Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
            this.var_periode = this.journauxMois.getJoumenPeriode();
            if (this.var_piece_compte != null && !this.var_piece_compte.isEmpty()) {
               this.debitAnterieur = 0.0D;
               this.creditAnterieur = 0.0D;
               this.cpTreso = "";
               this.var_hauteur = "height:110px";
               this.ChargerLesEcrituresPieceJournalExtrait(var7);
               this.calculLesJourDunMois();
            } else {
               if (this.journauxActif.getPljNature() != 7 && this.journauxActif.getPljNature() != 8 && this.journauxActif.getPljNature() != 9 && this.journauxActif.getPljNature() != 10) {
                  this.debitAnterieur = 0.0D;
                  this.creditAnterieur = 0.0D;
                  this.cpTreso = "";
                  this.var_hauteur = "height:110px";
               } else {
                  this.cpTreso = this.calculeCompteTreso(this.journauxMois.getJoumenPeriode());
                  this.calculerSoldeAnterieur(var7);
                  this.var_hauteur = "height:140px";
               }

               this.ChargerLesEcrituresJournalExtrait(var7);
               this.calculLesJourDunMois();
            }

            if (!this.optionComptabilite.getTrf_brl().equalsIgnoreCase("1") && this.journauxMois.getJoumenEtat() == 0) {
               if (this.selectedExo.getExecpt_id() != this.lastExo.getExecpt_id()) {
                  this.var_action = 3;
               } else {
                  this.var_action = 1;
               }
            } else {
               this.var_action = 3;
            }

            this.ajouterLigne();
            this.datamodelEcritures.setWrappedData(this.lesEcritures);
            this.verifExitChrono(var7);
            this.var_memo_action = this.var_action;
            this.utilInitHibernate.closeSession();
            var1 = true;
         } else {
            this.afficheTJM = false;
         }
      }

      return var1;
   }

   public void selectionMoisConsult() throws HibernateException, NamingException {
      if (this.dataModelMois.isRowAvailable()) {
         this.journauxMois = (JournauxMois)this.dataModelMois.getRowData();
         this.ChargerLesEcritures((Session)null);
         this.ouvrirLeJournalEncours();
         this.var_action = 3;
         this.var_memo_action = this.var_action;
      }

   }

   public void ChargerLesEcritures(Session var1) throws HibernateException, NamingException {
      if (this.lesEcritures == null) {
         this.lesEcritures = new LinkedList();
      }

      this.lesEcritures.clear();
      this.datamodelEcritures = new ListDataModel();
      if (this.journauxActif != null) {
         this.var_periode = this.journauxMois.getJoumenPeriode();
         this.var_format_devise = this.journauxActif.getPljFormatDevise();
         this.var_jr_nature = this.journauxActif.getPljNature();
         this.lesEcritures = this.ecrituresDao.ChargerLesEcritures(this.journauxMois.getJoumenCle1(), 1, this.selectedExo.getExecpt_id(), var1);
         if (this.lesEcritures != null && this.lesEcritures.size() != 0 && this.optionComptabilite.getVerrouImport().equals("1")) {
            for(int var2 = 0; var2 < this.lesEcritures.size(); ++var2) {
               this.ecritures = (Ecritures)this.lesEcritures.get(var2);
               this.ecritures.setVerrouImport(1);
            }
         }

         if (this.journauxActif.getPljNature() == 7 || this.journauxActif.getPljNature() == 9) {
            this.nettoyerMvtMois(var1);
         }

         this.datamodelEcritures.setWrappedData(this.lesEcritures);
      }

      this.calcultotaux();
   }

   public void ChargerLesEcrituresJournalExtrait(Session var1) throws HibernateException, NamingException {
      this.lesEcritures.clear();
      this.datamodelEcritures = new ListDataModel();
      if (this.journauxActif != null) {
         this.var_format_devise = this.journauxActif.getPljFormatDevise();
         this.var_jr_nature = this.journauxActif.getPljNature();
         String var2 = this.var_journal_compte + ":" + this.var_periode;
         this.lesEcritures = this.ecrituresDao.ChargerLesEcritures(var2, 1, 0L, var1);
         if (this.lesEcritures != null && this.lesEcritures.size() != 0 && this.optionComptabilite.getVerrouImport().equals("1")) {
            for(int var3 = 0; var3 < this.lesEcritures.size(); ++var3) {
               this.ecritures = (Ecritures)this.lesEcritures.get(var3);
               this.ecritures.setVerrouImport(1);
            }
         }

         this.datamodelEcritures.setWrappedData(this.lesEcritures);
         this.calcultotaux();
      }

   }

   public void ChargerLesEcrituresPiece(Session var1) throws HibernateException, NamingException {
      this.lesEcritures.clear();
      this.datamodelEcritures = new ListDataModel();
      if (this.journauxActif != null) {
         this.var_periode = this.journauxMois.getJoumenPeriode();
         this.var_format_devise = this.journauxActif.getPljFormatDevise();
         this.var_jr_nature = this.journauxActif.getPljNature();
         this.lesEcritures = this.ecrituresDao.ChargerLesEcrituresPiece(this.journauxMois.getJoumenCle1(), this.var_piece_compte, 1, this.selectedExo.getExecpt_id(), var1);
         if (this.lesEcritures != null && this.lesEcritures.size() != 0 && this.optionComptabilite.getVerrouImport().equals("1")) {
            for(int var2 = 0; var2 < this.lesEcritures.size(); ++var2) {
               this.ecritures = (Ecritures)this.lesEcritures.get(var2);
               this.ecritures.setVerrouImport(1);
            }
         }

         this.datamodelEcritures.setWrappedData(this.lesEcritures);
         this.calcultotaux();
      }

   }

   public void ChargerLesEcrituresPieceJournalExtrait(Session var1) throws HibernateException, NamingException {
      this.lesEcritures.clear();
      this.datamodelEcritures = new ListDataModel();
      if (this.journauxActif != null) {
         this.var_format_devise = this.journauxActif.getPljFormatDevise();
         this.var_jr_nature = this.journauxActif.getPljNature();
         String var2 = this.var_journal_compte + ":" + this.var_periode;
         this.lesEcritures = this.ecrituresDao.ChargerLesEcrituresPiece(var2, this.var_piece_compte, 1, this.selectedExo.getExecpt_id(), var1);
         if (this.lesEcritures != null && this.lesEcritures.size() != 0 && this.optionComptabilite.getVerrouImport().equals("1")) {
            for(int var3 = 0; var3 < this.lesEcritures.size(); ++var3) {
               this.ecritures = (Ecritures)this.lesEcritures.get(var3);
               this.ecritures.setVerrouImport(1);
            }
         }

         this.datamodelEcritures.setWrappedData(this.lesEcritures);
         this.calcultotaux();
      }

   }

   public void calculLesJourDunMois() throws java.text.ParseException {
      this.lesjoursItems.clear();
      String[] var1 = this.journauxMois.getJoumenPeriode().split(":");
      String var2 = var1[0];
      String var3 = var1[1];
      Date var4 = this.utilDate.stringToDateFr("01-" + var2 + "-" + var3);
      GregorianCalendar var5 = new GregorianCalendar();
      var5.setTime(var4);
      Date var6 = this.utilDate.dateDernierJourMois(var4);
      GregorianCalendar var7 = new GregorianCalendar();
      var7.setTime(var6);

      for(int var8 = 1; var5.compareTo(var7) <= 0; ++var8) {
         var5.add(5, 1);
         this.lesjoursItems.add(new SelectItem(var8));
      }

   }

   public void ouvrirLeJournalEncours() throws HibernateException, NamingException {
      if (this.journauxMois != null && !this.modeConsultation) {
         this.journauxMois.setJoumenOpenJournal(1);
         if (this.usersLog.getUsrPatronyme() != null && !this.usersLog.getUsrPatronyme().isEmpty()) {
            this.journauxMois.setJoumenOpenUserJournal(this.usersLog.getUsrPatronyme());
         } else {
            this.journauxMois.setJoumenOpenUserJournal(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         }

         this.journauxMois.setJoumenUserIdJournal(this.usersLog.getUsrid());
         this.journauxMois = this.journauxMoisDao.majJournal(this.journauxMois);
      }

   }

   public void fermerLeJournalEncours() throws NamingException, JDOMException, IOException, java.text.ParseException {
      if (this.journauxMois != null && !this.modeConsultation) {
         this.journauxMois.setJoumenOpenUserJournal("");
         this.journauxMois.setJoumenOpenJournal(0);
         this.journauxMois.setJoumenUserIdJournal(0L);
         if (this.lesEcritures != null) {
            this.journauxMois.setJoumenSaisie(1);
         } else {
            this.journauxMois.setJoumenSaisie(0);
         }

         this.journauxMois = this.journauxMoisDao.majJournal(this.journauxMois);
         if (this.journauxActif.getPljNature() == 7 || this.journauxActif.getPljNature() == 9) {
            this.cloturerMvtDuMois();
         }
      }

      if (this.var_acces_direct) {
         this.afficheTJM = true;
         this.var_action = 0;
         this.var_memo_action = this.var_action;
      }

   }

   public void cloturerMvtDuMois() throws NamingException, JDOMException, IOException, java.text.ParseException {
      if (!this.modeConsultation && this.lesEcritures != null && this.lesEcritures.size() != 0) {
         this.ecritures = new Ecritures();
         String var1 = this.calculeCompteTreso(this.journauxMois.getJoumenPeriode());
         String var2 = "Mouvements du mois";
         this.ecritures.setEcrCompte(var1);
         this.ecritures.setEcrOrdre(999999999L);
         if (this.totalMvtscredit > this.totalMvtsdebit) {
            this.ecritures.setEcrCreditSaisie(0.0D);
            this.ecritures.setEcrDebitSaisie(this.totalMvtscredit - this.totalMvtsdebit);
         } else if (this.totalMvtsdebit > this.totalMvtscredit) {
            this.ecritures.setEcrCreditSaisie(this.totalMvtsdebit - this.totalMvtscredit);
            this.ecritures.setEcrDebitSaisie(0.0D);
         } else {
            this.ecritures.setEcrCreditSaisie(0.0D);
            this.ecritures.setEcrDebitSaisie(0.0D);
         }

         this.ecritures.setEcrLibelle(var2);
         if (this.ecritures.getEcrDebitSaisie() != 0.0D || this.ecritures.getEcrCreditSaisie() != 0.0D) {
            String[] var3 = this.journauxMois.getJoumenPeriode().split(":");
            String var4 = var3[1] + "-" + var3[0] + "-01";
            this.ecritures.setEcrCode(this.journauxActif.getPljCode());
            this.ecritures.setEcrDateSaisie(this.utilDate.dateDernierJourMois(this.utilDate.stringToDateSQLLight(var4)));
            this.ecritures.setEcrJour(this.ecritures.getEcrDateSaisie().getDate());
            String var5 = "" + (this.ecritures.getEcrDateSaisie().getYear() + 1900);
            String var6 = "";
            if (this.ecritures.getEcrDateSaisie().getMonth() + 1 <= 9) {
               var6 = "0" + (this.ecritures.getEcrDateSaisie().getMonth() + 1);
            } else {
               var6 = "" + (this.ecritures.getEcrDateSaisie().getMonth() + 1);
            }

            String var7 = "";
            if (this.ecritures.getEcrJour() <= 9) {
               var7 = "0" + this.ecritures.getEcrJour();
            } else {
               var7 = "" + this.ecritures.getEcrJour();
            }

            this.ecritures.setEcrAnnee(var5);
            this.ecritures.setEcrPeriode(this.journauxMois.getJoumenPeriode());
            this.ecritures.setEcrCle1(this.ecritures.getEcrCode() + ":" + this.ecritures.getEcrPeriode());
            this.ecritures.setEcrCle2(this.ecritures.getEcrCode() + ":" + var5 + ":" + var6 + ":" + var7);
            if (this.journauxActif.getPljNature() == 9) {
               this.ecritures.setEcrNature(10);
            } else {
               this.ecritures.setEcrNature(11);
            }

            this.ecritures.setEcrDeviseSaisie(this.structureLog.getStrdevise());
            this.ecritures.setEcrCoefEuro(this.utilNombre.deviseTaux1(this.ecritures.getEcrDeviseSaisie(), this.ecritures.getEcrDateSaisie()));
            this.ecritures.setEcrDebitEuro(this.utilNombre.myRoundFormat(this.ecritures.getEcrDebitSaisie() * (double)this.ecritures.getEcrCoefEuro(), 1));
            this.ecritures.setEcrCreditEuro(this.utilNombre.myRoundFormat(this.ecritures.getEcrCreditSaisie() * (double)this.ecritures.getEcrCoefEuro(), 1));
            this.ecritures.setEcrDevisePays(this.structureLog.getStrdevise());
            if (this.ecritures.getEcrDevisePays().equalsIgnoreCase(this.ecritures.getEcrDeviseSaisie())) {
               this.ecritures.setEcrCoefPays(1.0F);
               this.ecritures.setEcrDebitPays(this.ecritures.getEcrDebitSaisie());
               this.ecritures.setEcrCreditPays(this.ecritures.getEcrCreditSaisie());
            } else {
               this.ecritures.setEcrCoefPays(this.utilNombre.deviseTaux2(this.ecritures.getEcrDevisePays(), this.ecritures.getEcrDateSaisie()));
               this.ecritures.setEcrDebitPays(this.utilNombre.myRoundDevise(this.ecritures.getEcrDebitSaisie() * (double)this.ecritures.getEcrCoefPays(), this.ecritures.getEcrDevisePays()));
               this.ecritures.setEcrCreditPays(this.utilNombre.myRoundDevise(this.ecritures.getEcrCreditSaisie() * (double)this.ecritures.getEcrCoefPays(), this.ecritures.getEcrDevisePays()));
            }

            this.ecritures.setEcrDeviseGrp(this.structureLog.getStrdevise());
            this.ecritures.setEcrCoefGrp(1.0F);
            this.ecritures.setEcrDebitGrp(this.ecritures.getEcrDebitSaisie());
            this.ecritures.setEcrCreditGrp(this.ecritures.getEcrCreditSaisie());
            this.ecritures.setEcrNatureJrx(this.journauxActif.getPljNature());
            this.ecritures.setEcrUserCreat(this.usersLog.getUsrid());
            this.ecritures.setBrouillard((Brouillard)null);
            this.ecritures.setExercicesComptable(this.selectedExo);
            this.ecritures = this.ecrituresDao.insert(this.ecritures);
         }
      }

   }

   public void nettoyerMvtMois(Session var1) throws HibernateException, NamingException {
      if (!this.modeConsultation && this.lesEcritures != null && this.lesEcritures.size() != 0) {
         for(int var2 = 0; var2 < this.lesEcritures.size(); ++var2) {
            this.ecritures = (Ecritures)this.lesEcritures.get(var2);
            if (this.ecritures.getEcrOrdre() >= 999999999L) {
               this.ecrituresDao.removeSelectedEC0(this.ecritures, 1, var1);
               this.lesEcritures.remove(this.ecritures);
               --var2;
            }
         }
      }

   }

   public void ajouterLigne() {
      this.ecritures = new Ecritures();
      this.planComptable = new PlanComptable();
      this.testAffSuppImpList = false;
      this.pieceVide = true;
      this.ligneSel = false;
      this.var_modif = false;
      this.ecritures.setEcrJour(this.calculeDernierJour());
   }

   public int calculeDernierJour() {
      int var1 = 1;
      if (this.lesEcritures != null && this.lesEcritures.size() != 0) {
         for(int var2 = 0; var2 < this.lesEcritures.size(); ++var2) {
            if (((Ecritures)this.lesEcritures.get(var2)).getEcrJour() > var1) {
               var1 = ((Ecritures)this.lesEcritures.get(var2)).getEcrJour();
            }
         }
      }

      return var1;
   }

   public void ajouterPiece() throws HibernateException, NamingException {
      if (this.ecritures != null) {
         String var1 = "";
         long var2 = 0L;
         if (this.verrouNum) {
            var2 = this.enregitrerNumero((Session)null);
            var1 = this.calculChrono.formattageChrono(this.chrono, var2, this.journauxActif.getPljCode(), "", this.ecritures.getEcrDateSaisie());
            this.ecritures.setEcrPiece(var1);
         }
      }

   }

   public void duppliquerLigne() {
      if (this.ecritures != null) {
         new Ecritures();
         Ecritures var1 = this.ecritures;
         this.ecritures = new Ecritures();
         this.ecritures.setVerrouImport(Integer.parseInt(this.optionComptabilite.getVerrouImport()));
         this.ecritures.setBrouillard(this.brouillard);
         this.ecritures.setEcrAnaActif(var1.getEcrAnaActif());
         this.ecritures.setEcrAnnee(var1.getEcrAnnee());
         this.ecritures.setEcrBudgetTreso(var1.getEcrBudgetTreso());
         this.ecritures.setEcrClasse(var1.getEcrClasse());
         this.ecritures.setEcrCle1(var1.getEcrCle1());
         this.ecritures.setEcrCle2(var1.getEcrCle2());
         this.ecritures.setEcrCloture(var1.getEcrCloture());
         this.ecritures.setEcrCode(var1.getEcrCode());
         this.ecritures.setEcrCoefEuro(var1.getEcrCoefEuro());
         this.ecritures.setEcrCoefGrp(var1.getEcrCoefGrp());
         this.ecritures.setEcrCoefPays(var1.getEcrCoefPays());
         this.ecritures.setEcrCompte(var1.getEcrCompte());
         this.ecritures.setEcrContrePartie(var1.getEcrContrePartie());
         this.ecritures.setEcrCreditEuro(0.0D);
         this.ecritures.setEcrCreditGrp(0.0D);
         this.ecritures.setEcrCreditPays(0.0D);
         this.ecritures.setEcrCreditSaisie(0.0D);
         this.ecritures.setEcrDateCreat(new Date());
         this.ecritures.setEcrDateEcheance(var1.getEcrDateEcheance());
         this.ecritures.setEcrDateModif((Date)null);
         this.ecritures.setEcrDatePaiement((Date)null);
         this.ecritures.setEcrDateSaisie(var1.getEcrDateSaisie());
         this.ecritures.setEcrDateValeurReelle(var1.getEcrDateValeurReelle());
         this.ecritures.setEcrDateValeurTheo(var1.getEcrDateValeurTheo());
         this.ecritures.setEcrDebitEuro(0.0D);
         this.ecritures.setEcrDebitGrp(0.0D);
         this.ecritures.setEcrDebitPays(0.0D);
         this.ecritures.setEcrDebitSaisie(0.0D);
         this.ecritures.setEcrDeviseGrp(var1.getEcrDeviseGrp());
         this.ecritures.setEcrDevisePays(var1.getEcrDevisePays());
         this.ecritures.setEcrDeviseSaisie(var1.getEcrDeviseSaisie());
         this.ecritures.setEcrEtat(var1.getEcrEtat());
         this.ecritures.setEcrIdOrigine(var1.getEcrIdOrigine());
         this.ecritures.setEcrJour(var1.getEcrJour());
         this.ecritures.setEcrLettrage(var1.getEcrLettrage());
         this.ecritures.setEcrLibCompte(var1.getEcrLibCompte());
         this.ecritures.setEcrLibelle(var1.getEcrLibelle());
         this.ecritures.setEcrNature(var1.getEcrNature());
         this.ecritures.setEcrNatureJrx(var1.getEcrNatureJrx());
         this.ecritures.setEcrNumIf(var1.getEcrNumIf());
         this.ecritures.setEcrNumTrf(var1.getEcrNumTrf());
         this.ecritures.setEcrOrdre(var1.getEcrOrdre());
         this.ecritures.setEcrOrigineBanque(var1.getEcrOrigineBanque());
         this.ecritures.setEcrPeriode(var1.getEcrPeriode());
         this.ecritures.setEcrPiece(var1.getEcrPiece());
         this.ecritures.setEcrPj(false);
         this.ecritures.setEcrPointage(var1.getEcrPointage());
         this.ecritures.setEcrPosteTreso(var1.getEcrPosteTreso());
         this.ecritures.setEcrRapprochement(var1.getEcrRapprochement());
         this.ecritures.setEcrReference1(var1.getEcrReference1());
         this.ecritures.setEcrReference2(var1.getEcrReference2());
         this.ecritures.setEcrReserve(var1.getEcrReserve());
         this.ecritures.setEcrTreso(var1.getEcrTreso());
         this.ecritures.setEcrTypeOrigine(var1.getEcrTypeOrigine());
         this.ecritures.setEcrUserCreat(this.usersLog.getUsrid());
         this.ecritures.setEcrUserModif(0L);
      }

   }

   public void supprimerLigne() {
      if (this.ecritures != null) {
         if (this.ecritures.getEcrPiece() != null && !this.ecritures.getEcrPiece().isEmpty()) {
            this.pieceVide = false;
         } else {
            this.pieceVide = true;
         }

         this.ligneSel = true;
      } else {
         this.pieceVide = false;
         this.ligneSel = false;
         this.testAffSuppImpList = false;
      }

      this.showModalPanelSupprimer = true;
   }

   public void selectionEcriture() throws HibernateException, NamingException {
      this.selectionEcriture((Session)null);
   }

   public void selectionEcriture(Session var1) throws HibernateException, NamingException {
      this.brouillard = new Brouillard();
      if (this.datamodelEcritures.isRowAvailable()) {
         this.ecritures = (Ecritures)this.datamodelEcritures.getRowData();
         if (this.selectedExo.getExecpt_id() != this.lastExo.getExecpt_id() && this.usersLog.getUsrAccesCorrection() == 2) {
            this.ecritures.setEcrEtat(0);
            this.ecritures.setEcrRapprochement("");
            this.ecritures.setEcrDteRapprochement((Date)null);
         }

         if (this.optionComptabilite.getVerrouImport().equals("0")) {
            this.ecritures.setVerrouImport(0);
         } else {
            this.ecritures.setVerrouImport(1);
         }

         this.var_memo_ligne_gene = this.ecritures.getEcr_id();
         this.ligneSel = true;
         if (this.ecritures.getEcrPiece() != null && !this.ecritures.getEcrPiece().isEmpty()) {
            this.pieceVide = false;
         } else {
            this.pieceVide = true;
         }

         if (this.ecritures.getEcrCompte() != null && !this.ecritures.getEcrCompte().isEmpty()) {
            this.planComptable = this.planComptable = this.planComptableDao.trouveCompte(this.selecFiscalite, this.selectedExo.getExecpt_id(), this.ecritures.getEcrCompte(), var1);
            if (this.planComptable == null) {
               this.planComptable = new PlanComptable();
               this.ecritures.setEcrLibCompte("*** COMPTE INEXISTENT ***");
            }
         } else {
            this.planComptable = new PlanComptable();
         }

         this.brouillard = this.ecritures.getBrouillard();
         if (this.brouillard != null) {
            this.testAffBrouillard = true;
         } else {
            this.testAffBrouillard = false;
         }

         this.testAffSuppImpList = true;
         this.afficheBudgetTresorerie();
         this.affichePj();
      } else {
         this.var_memo_ligne_gene = 0L;
         if (this.ecritures != null) {
            this.ligneSel = true;
            if (this.ecritures.getEcrPiece() != null && !this.ecritures.getEcrPiece().isEmpty()) {
               this.pieceVide = false;
            } else {
               this.pieceVide = true;
            }

            if (this.ecritures.getEcrCompte() != null && !this.ecritures.getEcrCompte().isEmpty()) {
               this.planComptable = this.planComptable = this.planComptableDao.trouveCompte(this.selecFiscalite, this.selectedExo.getExecpt_id(), this.ecritures.getEcrCompte(), var1);
            } else {
               this.planComptable = new PlanComptable();
            }

            this.brouillard = this.ecritures.getBrouillard();
            if (this.brouillard != null) {
               this.testAffBrouillard = true;
            } else {
               this.testAffBrouillard = false;
            }

            this.testAffSuppImpList = true;
            this.afficheBudgetTresorerie();
            this.affichePj();
         }
      }

   }

   public void ouvrirLpr() throws HibernateException, NamingException {
      this.selectionEcriture();
      if (this.ecritures != null) {
         this.showModalPanelLpr = true;
      }

   }

   public void fermerLpr() {
      this.showModalPanelLpr = false;
   }

   public void ouvrirDetailsAnalytique() throws HibernateException, NamingException {
      this.ouvrirDetailsAnalytique((Session)null);
   }

   public void ouvrirDetailsAnalytique(Session var1) throws HibernateException, NamingException {
      this.selectionEcriture(var1);
      if (this.ecritures != null && this.ecritures.getEcrAnaActif() == 1) {
         this.formAnalytique.initAnalytique(this.optionComptabilite, var1);
         this.formAnalytique.chargementDetailAnalytique(this.ecritures, true, var1);
         this.showModalPanelAnalytique = true;
      }

   }

   public void fermerDetailsAnalytique() {
      this.showModalPanelAnalytique = false;
   }

   public void ouvrirPj() throws HibernateException, NamingException, MalformedURLException, IOException {
      if (this.ecritures != null && !this.ecritures.isEcrPj()) {
         this.modePj = 1;
         this.uploadedFile = null;
         this.typeFichier = 0;
         this.valueScanPj = "";
         this.showModalPanelPJ = false;
         this.showModalPanelAjoutPJ = true;
      } else {
         this.ouvrirPjConsultation();
      }

   }

   public void ouvrirPjConsultation() throws HibernateException, NamingException, MalformedURLException, IOException {
      this.selectionEcriture();
      if (this.ecritures != null && this.ecritures.getEcrPiece() != null && !this.ecritures.getEcrPiece().isEmpty()) {
         this.modePj = 2;
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanCompta" + this.selectedExo.getExecpt_id() + File.separator;
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         String var3 = this.ecritures.getEcrCode() + ":" + this.ecritures.getEcrPeriode() + ":" + this.ecritures.getEcrPiece().replaceAll("/", "_");
         File var4 = new File(var1 + var3 + ".pdf");
         if (var4.exists()) {
            this.typeFichier = 1;
            var3 = var3 + ".pdf";
         } else {
            this.typeFichier = 0;
            var3 = var3 + ".jpg";
         }

         if (this.typeFichier == 1) {
            this.fichierUrl = this.utilDownload.convertirFichierUtl(var1 + var3, this.urlExplorateur);
            this.fichierMine = this.utilDownload.calculeTypeMine(var3);
            this.typeFichier = 1;
         } else {
            this.urlphotoProd = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanCompta" + this.selectedExo.getExecpt_id() + File.separator + var3;
            this.typeFichier = 0;
         }

         this.showModalPanelPJ = true;
      }

   }

   public void fermerPj() {
      this.showModalPanelPJ = false;
      this.showModalPanelAjoutPJ = false;
   }

   public void validerPj() throws IOException, NamingException, JDOMException, java.text.ParseException {
      if (this.ecritures.getEcr_id() == 0L) {
         this.saveEcritureLight();
      }

      String var1 = "";
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "scanCompta" + this.selectedExo.getExecpt_id();
      File var3 = new File(var2);
      if (!var3.exists()) {
         var3.mkdir();
      }

      try {
         if (this.uploadedFile != null && this.ecritures != null && this.ecritures.getEcrPiece() != null && !this.ecritures.getEcrPiece().isEmpty()) {
            var1 = this.ecritures.getEcrCode() + ":" + this.ecritures.getEcrPeriode() + ":" + this.ecritures.getEcrPiece().replaceAll("/", "_");
            String var5 = "";
            if (!this.uploadedFile.getName().endsWith("pdf") && !this.uploadedFile.getName().endsWith("PDF")) {
               var5 = ".jpg";
            } else {
               var5 = ".pdf";
            }

            File var4 = new File(var2 + File.separator + var1 + var5);
            var4.delete();
            File var6 = this.utilDownload.uniqueFile(new File(var2 + File.separator), var1 + var5);
            this.utilDownload.write(var6, this.uploadedFile.getInputStream());
         }
      } catch (IOException var7) {
      }

      if (var1 != null && !var1.isEmpty()) {
         this.ecritures.setEcrPj(true);
      } else {
         this.ecritures.setEcrPj(false);
      }

      this.showModalPanelPJ = false;
      this.showModalPanelAjoutPJ = false;
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

   public void reInitPj() {
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanCompta" + this.selectedExo.getExecpt_id() + File.separator;
      String var2 = this.ecritures.getEcrCode() + ":" + this.ecritures.getEcrPeriode() + ":" + this.ecritures.getEcrPiece().replaceAll("/", "_");
      File var3 = new File(var1 + var2 + ".pdf");
      if (var3.exists()) {
         var3.delete();
      } else {
         var3 = new File(var1 + var2 + ".jpg");
         if (var3.exists()) {
            var3.delete();
         }
      }

      this.ecritures.setEcrPj(false);
      this.showModalPanelPJ = false;
      this.showModalPanelAjoutPJ = false;
   }

   public void chargerDoc1() {
      this.lesPjSecretariat.clear();
      this.dataModelPjSecretariat.setWrappedData(this.lesPjSecretariat);
      this.mails = new Mails();
   }

   public void chargerDoc2() throws HibernateException, NamingException {
      this.lesPjSecretariat.clear();
      MailsDao var1 = new MailsDao(this.baseLog, this.utilInitHibernate);
      this.lesPjSecretariat = var1.mailsNonTraiteEnCompta();
      this.dataModelPjSecretariat.setWrappedData(this.lesPjSecretariat);
      this.mails = new Mails();
   }

   public void selectionPj() {
      if (this.dataModelPjSecretariat.isRowAvailable()) {
         this.mails = (Mails)this.dataModelPjSecretariat.getRowData();
      }

   }

   public void validerPjSecretariat() throws HibernateException, NamingException, IOException {
      if (this.mails != null && this.mails.getMaiId() != 0L) {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "scanCourriers";
         String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "scanCompta" + this.selectedExo.getExecpt_id();
         File var3 = new File(var2 + File.separator);
         if (!var3.exists()) {
            var3.mkdir();
         }

         String var4 = this.ecritures.getEcrCode() + ":" + this.ecritures.getEcrPeriode() + ":" + this.ecritures.getEcrPiece().replaceAll("/", "_");
         File var5 = new File(var2 + File.separator + var4 + ".pdf");
         if (var5.exists()) {
            this.typeFichier = 1;
            var4 = var4 + ".pdf";
         } else {
            this.typeFichier = 0;
            var4 = var4 + ".jpg";
         }

         File var6 = new File(var1 + File.separator + this.mails.getMaiScanCourrier());
         if (var6.exists()) {
            File var7 = new File(var2 + File.separator + var4);
            this.utilDownload.copy(var6, var7);
            this.ecritures.setEcrPj(true);
         }

         MailsDao var8 = new MailsDao(this.baseLog, this.utilInitHibernate);
         this.mails.setMaiDateTransfert(new Date());
         this.mails = var8.modifMail(this.mails);
      }

      this.showModalPanelPJ = false;
      this.showModalPanelAjoutPJ = false;
   }

   public void changerNumPiece() {
      if (this.ecritures != null) {
         this.var_nouveau_numero = "";
         this.var_ancien_numero = this.ecritures.getEcrPiece();
         this.ecrIdMemo = this.ecritures.getEcr_id();
         this.var_mode_chg = 0;
         this.showModalPanelPiece = true;
      }

   }

   public void fermerNumPiece() {
      this.showModalPanelPiece = false;
   }

   public void valideNumPiece() throws HibernateException, NamingException {
      if (this.ecritures != null && this.var_nouveau_numero != null && !this.var_nouveau_numero.isEmpty()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Brouillard");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            if (this.ecritures.getBrouillard() != null) {
               this.brouillardDao = new BrouillardDao(this.baseLog, this.utilInitHibernate);
               this.brouillard.setBroPiece(this.var_nouveau_numero);
               this.brouillard = this.brouillardDao.modif(this.brouillard, var1);
               var1.flush();
            }

            boolean var3 = false;
            if (this.lesEcritures.size() != 0) {
               new Ecritures();
               EcrituresAnalytiquesDao var5 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
               Object var6 = new ArrayList();

               for(int var7 = 0; var7 < this.lesEcritures.size(); ++var7) {
                  Ecritures var4 = (Ecritures)this.lesEcritures.get(var7);
                  if ((this.var_mode_chg == 0 || this.var_mode_chg == 1 && var4.getEcr_id() == this.ecrIdMemo) && var4.getEcrPiece().equalsIgnoreCase(this.var_ancien_numero)) {
                     var4.setEcrPiece(this.var_nouveau_numero);
                     this.ecrituresDao.modif(var4, var1);
                     var1.flush();
                     if (var4.getEcrAnaActif() == 1) {
                        ((List)var6).clear();
                        var6 = var5.chargerLesEcrituresAnalytiques(var4, var1);
                        if (((List)var6).size() != 0) {
                           for(int var8 = 0; var8 < ((List)var6).size(); ++var8) {
                              new EcrituresAnalytique();
                              EcrituresAnalytique var9 = (EcrituresAnalytique)((List)var6).get(var8);
                              var9.setEcranaPiece(this.var_nouveau_numero);
                              var5.modifEcritureAnalytiques(var1, var9);
                              var1.flush();
                           }
                        }
                     }

                     if (var4.isEcrPj()) {
                        var3 = true;
                     }
                  }
               }
            }

            if (var3) {
               String var15 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanCompta" + this.selectedExo.getExecpt_id() + File.separator;
               String var16 = this.ecritures.getEcrCode() + ":" + this.ecritures.getEcrPeriode() + ":" + this.var_ancien_numero.replaceAll("/", "_");
               String var17 = this.ecritures.getEcrCode() + ":" + this.ecritures.getEcrPeriode() + ":" + this.var_nouveau_numero.replaceAll("/", "_");
               File var18 = new File(var15 + var16 + ".pdf");
               if (var18.exists()) {
                  this.typeFichier = 1;
                  var16 = var16 + ".pdf";
                  var17 = var17 + ".pdf";
               } else {
                  this.typeFichier = 0;
                  var16 = var16 + ".jpg";
                  var17 = var17 + ".jpg";
               }

               File var19 = new File(var15 + var17);
               var18.renameTo(var19);
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

      this.ajouterLigne();
      this.showModalPanelPiece = false;
   }

   public void informationPiece() throws HibernateException, NamingException {
      if (this.ecritures != null) {
         this.nomCreation = "";
         this.nomModification = "";
         new Users();
         UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Users var1;
         if (this.ecritures.getEcrUserCreat() != 0L) {
            var1 = var2.selectUserD(this.ecritures.getEcrUserCreat(), var3);
            if (var1 != null) {
               this.nomCreation = var1.getUsrPatronyme();
            }
         }

         if (this.ecritures.getEcrUserModif() != 0L) {
            var1 = var2.selectUserD(this.ecritures.getEcrUserModif(), var3);
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

   public void recherchePlanComptable() throws JDOMException, IOException, HibernateException, NamingException, java.text.ParseException {
      if (this.ecritures.getEcrCompte() != null && !this.ecritures.getEcrCompte().isEmpty() && this.ecritures.getEcrCompte().equals("#")) {
         this.var_type_compte = 2;
         this.ecrituresModeles = new EcrituresModeles();
         new ArrayList();
         List var1 = this.ecrituresModelesDao.selectModelesByJournal(this.journauxMois.getJoumenCode(), (Session)null);
         if (var1.size() != 0) {
            this.mesModelesItems.clear();

            for(int var2 = 0; var2 < var1.size(); ++var2) {
               this.mesModelesItems.add(new SelectItem(((EcrituresModeles)var1.get(var2)).getModCode(), ((EcrituresModeles)var1.get(var2)).getModCode() + ":" + ((EcrituresModeles)var1.get(var2)).getModLibelle()));
            }

            this.lesEcrituresModeles.clear();
            this.dataModelEcrituresModele.setWrappedData(this.lesEcrituresModeles);
            this.jourModele = (new Date()).getDate();
            this.codeModele = "";
            this.pieceModele = "";
            this.referenceModele = "";
            this.libelleModele = "";
            this.montantModele = 0.0D;
            this.showModalPanelModele = true;
         }
      } else {
         this.var_type_compte = 0;
         this.planComptable = this.formRecherche.recherchePlanComptable(this.selecFiscalite, this.ecritures.getEcrCompte(), 533, this.selectedExo, this.journauxActif.getPljNature(), this.usersLog.getUsrCptInterdit(), this.optionComptabilite);
         if (this.planComptable != null) {
            if (this.planComptable.getPlcId() != 0L) {
               this.calculePlanComptable();
            } else if (this.modeAcces != 1 && this.modeAcces != 2) {
               this.var_action = 10;
            } else {
               this.dataModelListeCompte.setWrappedData(this.formRecherche.getLesPlanComptable());
               this.showModalPanelListeCompte = true;
            }
         } else if (this.planComptable == null) {
            this.annulePlanComptable();
         }
      }

   }

   public void rechercheContrePartie() throws JDOMException, IOException, HibernateException, NamingException, java.text.ParseException {
      this.var_type_compte = 1;
      this.planComptable = this.formRecherche.recherchePlanComptable(this.selecFiscalite, this.ecritures.getEcrContrePartie(), 533, this.selectedExo, this.journauxActif.getPljNature(), this.usersLog.getUsrCptInterdit(), this.optionComptabilite);
      if (this.planComptable != null) {
         if (this.planComptable.getPlcId() != 0L) {
            this.calculePlanComptable();
         } else {
            this.var_action = 10;
         }
      } else if (this.planComptable == null) {
         this.annulePlanComptable();
      }

   }

   public void recuperationPlanComptable() throws JDOMException, IOException, HibernateException, NamingException, java.text.ParseException {
      this.planComptable = this.formRecherche.calculePlanComptable();
      this.calculePlanComptable();
   }

   public void calculePlanComptable() throws JDOMException, IOException, HibernateException, NamingException, java.text.ParseException {
      if (this.planComptable != null) {
         if (this.var_type_compte == 1) {
            this.ecritures.setEcrContrePartie(this.planComptable.getPlcCompte());
         } else {
            this.ecritures.setEcrCompte(this.planComptable.getPlcCompte());
            this.ecritures.setEcrLibCompte(this.planComptable.getPlcLibelleCpteFR());
            this.ecritures.setEcrNature(this.planComptable.getPlcNature());
            this.ecritures.setEcrClasse(this.planComptable.getPlcCompte().substring(0, 1));
            if (this.planComptable != null) {
               if (this.planComptable.getPlcNature() != 3 && this.planComptable.getPlcNature() != 13 && this.planComptable.getPlcNature() != 14 && this.planComptable.getPlcNature() != 15) {
                  if (this.planComptable.getPlcNature() == 6 || this.planComptable.getPlcNature() == 7) {
                     this.calculDateEcheance();
                  }
               } else {
                  new Racines();
                  RacinesDao var2 = new RacinesDao(this.baseLog, this.structureLog, this.utilInitHibernate);
                  Racines var1 = var2.rechercherCodeRacine(this.selecFiscalite, this.planComptable.getPlcCodeRacine(), (Session)null);
                  if (var1 != null && var1.getRactaux() != 0.0F) {
                     float var3 = var1.getRactaux() / 100.0F + 1.0F;
                     String var4 = this.structureLog.getStrdevise();
                     if (this.journauxActif.getPljChoixDevise() != null && !this.journauxActif.getPljChoixDevise().isEmpty()) {
                        var4 = this.journauxActif.getPljChoixDevise();
                     }

                     if (this.planComptable.getPlcNature() == 13) {
                        if (this.soldeDeb != 0.0D && this.soldeCred == 0.0D) {
                           this.ecritures.setEcrDebitSaisie(this.utilNombre.myRoundDevise(this.soldeDeb * (double)var3, var4) - this.soldeDeb);
                        } else {
                           this.ecritures.setEcrDebitSaisie(this.soldeCred - this.utilNombre.myRoundDevise(this.soldeCred / (double)var3, var4));
                        }
                     } else if (this.planComptable.getPlcNature() == 14) {
                        if (this.soldeDeb != 0.0D && this.soldeCred == 0.0D) {
                           this.ecritures.setEcrCreditSaisie(this.soldeDeb - this.utilNombre.myRoundDevise(this.soldeDeb / (double)var3, var4));
                        } else {
                           this.ecritures.setEcrCreditSaisie(this.utilNombre.myRoundDevise(this.soldeCred * (double)var3, var4) - this.soldeCred);
                        }
                     } else if (this.soldeDeb != 0.0D && this.soldeCred == 0.0D) {
                        this.ecritures.setEcrCreditSaisie(this.utilNombre.myRoundDevise(this.soldeDeb * (double)var3, var4) - this.soldeDeb);
                     } else {
                        this.ecritures.setEcrDebitSaisie(this.utilNombre.myRoundDevise(this.soldeCred * (double)var3, var4) - this.soldeCred);
                     }
                  }
               }
            }
         }

         this.afficheBudgetTresorerie();
         this.affichePj();
      } else {
         this.planComptable = new PlanComptable();
         if (this.var_type_compte == 1) {
            this.ecritures.setEcrContrePartie("");
         } else {
            this.ecritures.setEcrCompte("");
            this.ecritures.setEcrLibCompte("");
            this.ecritures.setEcrNature(0);
            this.ecritures.setEcrClasse("");
         }

         this.afficheBudgetTresoProjet = false;
         this.afficheBudgetTresoStandard = false;
         this.conditionPj = false;
      }

      this.var_action = this.var_memo_action;
   }

   public void afficheBudgetTresorerie() {
      this.afficheBudgetTresoProjet = false;
      this.afficheBudgetTresoStandard = false;
      if (this.optionComptabilite.getTresorerie().equals("true")) {
         this.memo_compte_budgetTreso = "";
         if (this.cpTreso != null && !this.cpTreso.isEmpty()) {
            if (this.comptaProjet) {
               if (this.journauxActif.getPljNature() != 7 && this.journauxActif.getPljNature() != 9) {
                  if (this.ecritures.getEcrCompte().equals(this.cpTreso)) {
                     this.afficheBudgetTresoProjet = true;
                  }
               } else if (!this.ecritures.getEcrCompte().equals(this.cpTreso)) {
                  this.afficheBudgetTresoProjet = true;
               }
            } else if (this.journauxActif.getPljNature() != 7 && this.journauxActif.getPljNature() != 9) {
               if (this.ecritures.getEcrCompte().equals(this.cpTreso)) {
                  this.afficheBudgetTresoStandard = true;
               }
            } else if (!this.ecritures.getEcrCompte().equals(this.cpTreso)) {
               this.afficheBudgetTresoStandard = true;
            }
         }
      }

   }

   public void affichePj() {
      this.conditionPj = false;
      if (this.ecritures != null && this.ecritures.getEcrPiece() != null && !this.ecritures.getEcrPiece().isEmpty()) {
         if (this.journauxActif.getPljNature() != 7 && this.journauxActif.getPljNature() != 8 && this.journauxActif.getPljNature() != 9 && this.journauxActif.getPljNature() != 10) {
            if (this.ecritures.getEcrCompte() != null && !this.ecritures.getEcrCompte().isEmpty() && (this.ecritures.getEcrCompte().startsWith("3") || this.ecritures.getEcrCompte().startsWith("4"))) {
               this.conditionPj = true;
            }
         } else if (this.planComptable.getPlcNature() != 10 && this.planComptable.getPlcNature() != 11) {
            this.conditionPj = true;
         }
      }

   }

   public void annulePlanComptable() {
      this.planComptable = new PlanComptable();
      if (this.var_type_compte == 1) {
         this.ecritures.setEcrContrePartie("");
      } else {
         this.ecritures.setEcrCompte("");
         this.ecritures.setEcrLibCompte("");
         this.ecritures.setEcrNature(0);
         this.ecritures.setEcrClasse("");
      }

      this.afficheBudgetTresoProjet = false;
      this.afficheBudgetTresoStandard = false;
      this.var_action = this.var_memo_action;
   }

   public void fermerPlanComptable() {
      this.showModalPanelListeCompte = false;
   }

   public void selectionnerPlanComptable() {
      if (this.dataModelListeCompte.isRowAvailable()) {
         this.planComptable = (PlanComptable)this.dataModelListeCompte.getRowData();
      }

   }

   public void validerPlanComptable() throws JDOMException, IOException, HibernateException, NamingException, java.text.ParseException {
      this.calculePlanComptable();
      this.showModalPanelListeCompte = false;
   }

   public void fermerModele() {
      this.showModalPanelModele = false;
   }

   public void selectionModele() throws HibernateException, NamingException, JDOMException, IOException, ParseException, java.text.ParseException {
      if (this.codeModele != null && !this.codeModele.isEmpty()) {
         this.ecrituresModeles = this.ecrituresModelesDao.chargerModele(this.codeModele, (Session)null);
         if (this.ecrituresModeles != null) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
            new ArrayList();
            List var2 = this.ecrituresModelesLignesDao.selectModelesLignes(this.ecrituresModeles, var1);
            if (var2.size() != 0) {
               this.lesEcrituresModeles.clear();
               new EcrituresModelesLignes();

               for(int var4 = 0; var4 < var2.size(); ++var4) {
                  EcrituresModelesLignes var3 = (EcrituresModelesLignes)var2.get(var4);
                  this.saveLigneEcriture(this.ecrituresModeles, var3, "XXXXXX", var1);
               }

               this.dataModelEcrituresModele.setWrappedData(this.lesEcrituresModeles);
            }

            this.utilInitHibernate.closeSession();
         }
      } else {
         this.lesEcrituresModeles.clear();
         this.dataModelEcrituresModele.setWrappedData(this.lesEcrituresModeles);
      }

   }

   public void validerModele() throws HibernateException, NamingException, JDOMException, IOException, ParseException, java.text.ParseException {
      if (this.ecrituresModeles != null && this.ecrituresModeles.getModId() != 0L && this.montantModele != 0.0D) {
         if (this.lesEcrituresModeles.size() != 0) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
            Transaction var2 = null;

            try {
               var2 = var1.beginTransaction();
               String var3 = "";
               if (this.verrouNum) {
                  String[] var4 = this.journauxMois.getJoumenPeriode().split(":");
                  String var5 = "";
                  if (this.jourModele <= 9) {
                     var5 = "0" + this.jourModele;
                  } else {
                     var5 = "" + this.jourModele;
                  }

                  Date var6 = this.utilDate.stringToDateSQLLight(var4[1] + "-" + var4[0] + "-" + var5);
                  this.chrono = this.chronoDao.chronoByNatAndJournalPeriode(53, this.journauxMois.getJoumenCode(), "" + var4[1], var1);
                  if (this.chrono != null) {
                     long var7 = 0L;
                     var7 = this.enregitrerNumero(var1);
                     var3 = this.calculChrono.formattageChrono(this.chrono, var7, this.ecrituresModeles.getModJournal(), "", var6);
                  } else {
                     var3 = "";
                  }
               } else {
                  var3 = this.pieceModele;
               }

               if (this.lesEcritures == null) {
                  this.lesEcritures = new ArrayList();
               }

               int var14 = 0;

               while(true) {
                  if (var14 >= this.lesEcrituresModeles.size()) {
                     this.datamodelEcritures.setWrappedData(this.lesEcritures);
                     var2.commit();
                     break;
                  }

                  this.ecritures = (Ecritures)this.lesEcrituresModeles.get(var14);
                  if (var3 != null && !var3.isEmpty()) {
                     this.ecritures.setEcrPiece(var3);
                  } else {
                     this.ecritures.setEcrPiece("");
                  }

                  this.ecritures.setEcrDateCreat(new Date());
                  this.ecritures.setEcrUserCreat(this.usersLog.getUsrid());
                  this.ecritures.setExercicesComptable(this.selectedExo);
                  this.ecritures.setBrouillard((Brouillard)null);
                  this.ecritures = this.ecrituresDao.insert(this.ecritures, var1);
                  this.lesEcritures.add(this.ecritures);
                  ++var14;
               }
            } catch (HibernateException var12) {
               if (var2 != null) {
                  var2.rollback();
               }

               throw var12;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }

         this.ajouterLigne();
      }

      this.showModalPanelModele = false;
   }

   public void saveLigneEcriture(EcrituresModeles var1, EcrituresModelesLignes var2, String var3, Session var4) throws NamingException, JDOMException, IOException, ParseException, java.text.ParseException {
      this.ecritures = new Ecritures();
      this.ecritures.setEcrCode(var1.getModJournal());
      this.ecritures.setEcrNatureJrx(this.journauxActif.getPljNature());
      this.ecritures.setEcrReserve(this.journauxActif.getPljReserve());
      String[] var5 = this.journauxMois.getJoumenPeriode().split(":");
      String var6 = "";
      if (this.jourModele <= 9) {
         var6 = "0" + this.jourModele;
      } else {
         var6 = "" + this.jourModele;
      }

      Date var7 = this.utilDate.stringToDateSQLLight(var5[1] + "-" + var5[0] + "-" + var6);
      this.ecritures.setEcrAnnee(var5[1]);
      this.ecritures.setEcrDateSaisie(var7);
      this.ecritures.setEcrEtat(0);
      this.ecritures.setEcrJour(this.jourModele);
      this.ecritures.setEcrPeriode(this.journauxMois.getJoumenPeriode());
      this.ecritures.setEcrPiece(var3);
      this.ecritures.setEcrCompte(var2.getModligCompte());
      this.ecritures.setEcrLibCompte(var2.getModligLibelle());
      this.planComptable = this.planComptableDao.chercherCompte(this.selecFiscalite, var2.getModligCompte(), this.selectedExo.getExecpt_id(), var4);
      if (this.planComptable != null) {
         this.ecritures.setEcrNature(this.planComptable.getPlcNature());
      } else {
         this.ecritures.setEcrNature(0);
      }

      this.ecritures.setEcrClasse(this.ecritures.getEcrCompte().substring(0, 1));
      this.ecritures.setEcrLibelle(this.libelleModele);
      this.ecritures.setEcrReference1(this.referenceModele);
      this.ecritures.setEcrReference2("");
      this.ecritures.setEcrCle1(this.ecritures.getEcrCode() + ":" + this.ecritures.getEcrPeriode());
      this.ecritures.setEcrCle2(this.ecritures.getEcrCode() + ":" + var5[1] + ":" + var5[0] + ":" + var6);
      this.ecritures.setEcrOrdre(0L);
      double var8 = 0.0D;
      if (var2.getModligCalcul() == 0) {
         var8 = this.montantModele;
      } else if (var2.getModligCalcul() == 1 && var2.getModligTaux() != 0.0F) {
         var8 = this.utilNombre.myRoundDevise(this.montantModele * (double)var2.getModligTaux() / 100.0D, this.structureLog.getStrdevise());
      } else if (var2.getModligCalcul() == 2 && var2.getModligTaux() != 0.0F) {
         var8 = this.utilNombre.myRoundDevise(this.montantModele - this.montantModele / (double)(1.0F + (var2.getModligTaux() + var2.getModligTc()) / 100.0F), this.structureLog.getStrdevise());
      } else if (var2.getModligCalcul() == 3 && var2.getModligTaux() != 0.0F) {
         var8 = this.utilNombre.myRoundDevise(this.montantModele * (double)var2.getModligTaux() / 100.0D, this.structureLog.getStrdevise());
      } else if (var2.getModligCalcul() == 4 && var2.getModligTaux() != 0.0F) {
         var8 = this.utilNombre.myRoundDevise(this.montantModele - this.montantModele / (double)(1.0F + (var2.getModligTaux() + var2.getModligTc()) / 100.0F), this.structureLog.getStrdevise());
      } else if (var2.getModligCalcul() == 5) {
         var8 = this.utilNombre.myRoundDevise(this.montantModele * (double)var2.getModligTc() / 100.0D, this.structureLog.getStrdevise());
      } else if (var2.getModligCalcul() == 6) {
         var8 = this.utilNombre.myRoundDevise(this.montantModele - this.montantModele / (double)(1.0F + (var2.getModligTaux() + var2.getModligTc()) / 100.0F), this.structureLog.getStrdevise());
      } else if (var2.getModligCalcul() == 7) {
         var8 = this.utilNombre.myRoundDevise(this.montantModele / (double)(1.0F + (var2.getModligTaux() + var2.getModligTc()) / 100.0F), this.structureLog.getStrdevise());
      } else if (var2.getModligCalcul() == 8) {
         double var10 = this.utilNombre.myRoundDevise(this.montantModele * (double)var2.getModligTaux() / 100.0D, this.structureLog.getStrdevise());
         double var12 = this.utilNombre.myRoundDevise(this.montantModele * (double)var2.getModligTc() / 100.0D, this.structureLog.getStrdevise());
         var8 = var10 + var12;
      }

      if (var2.getModligSens() == 0) {
         this.ecritures.setEcrDebitSaisie(var8);
         this.ecritures.setEcrCreditSaisie(0.0D);
      } else {
         this.ecritures.setEcrDebitSaisie(0.0D);
         this.ecritures.setEcrCreditSaisie(var8);
      }

      this.ecritures.setEcrDeviseSaisie(this.structureLog.getStrdevise());
      this.ecritures.setEcrCoefEuro(this.utilNombre.deviseTaux1(this.ecritures.getEcrDeviseSaisie(), this.ecritures.getEcrDateSaisie()));
      this.ecritures.setEcrDebitEuro(this.utilNombre.myRoundFormat(this.ecritures.getEcrDebitSaisie() * (double)this.ecritures.getEcrCoefEuro(), 1));
      this.ecritures.setEcrCreditEuro(this.utilNombre.myRoundFormat(this.ecritures.getEcrCreditSaisie() * (double)this.ecritures.getEcrCoefEuro(), 1));
      this.ecritures.setEcrDevisePays(this.structureLog.getStrdevise());
      if (this.ecritures.getEcrDevisePays().equalsIgnoreCase(this.ecritures.getEcrDeviseSaisie())) {
         this.ecritures.setEcrCoefPays(1.0F);
         this.ecritures.setEcrDebitPays(this.ecritures.getEcrDebitSaisie());
         this.ecritures.setEcrCreditPays(this.ecritures.getEcrCreditSaisie());
      } else {
         this.ecritures.setEcrCoefPays(this.utilNombre.deviseTaux2(this.ecritures.getEcrDevisePays(), this.ecritures.getEcrDateSaisie()));
         this.ecritures.setEcrDebitPays(this.utilNombre.myRoundDevise(this.ecritures.getEcrDebitSaisie() * (double)this.ecritures.getEcrCoefPays(), this.ecritures.getEcrDevisePays()));
         this.ecritures.setEcrCreditPays(this.utilNombre.myRoundDevise(this.ecritures.getEcrCreditSaisie() * (double)this.ecritures.getEcrCoefPays(), this.ecritures.getEcrDevisePays()));
      }

      this.ecritures.setEcrDeviseGrp(this.structureLog.getStrdevise());
      this.ecritures.setEcrCoefGrp(1.0F);
      this.ecritures.setEcrDebitGrp(this.ecritures.getEcrDebitSaisie());
      this.ecritures.setEcrCreditGrp(this.ecritures.getEcrCreditSaisie());
      this.ecritures.setEcrIdOrigine(0L);
      this.ecritures.setEcrTypeOrigine("");
      this.lesEcrituresModeles.add(this.ecritures);
   }

   public void rechercheBudgetTresorerie() throws JDOMException, IOException, HibernateException, NamingException, java.text.ParseException {
      String var1 = this.journauxMois.getJoumenPeriode();
      int var2 = this.ecritures.getEcrJour();
      String[] var3 = var1.split(":");
      String var4 = var3[0];
      String var5 = var3[1];
      String var6 = null;
      if (var2 <= 9) {
         var6 = var5 + "-" + var4 + "-" + "0" + var2;
      } else {
         var6 = var5 + "-" + var4 + "-" + var2;
      }

      if (this.comptaProjet) {
         this.plansTresorerie = this.formRecherche.rechercheBudgetTresorerie(this.journauxActif.getPljProjet(), this.ecritures.getEcrPosteTreso(), var6, 533, (ExercicesComptable)null, this.optionComptabilite);
      } else {
         this.plansTresorerie = this.formRecherche.rechercheBudgetTresorerie((String)null, this.ecritures.getEcrTreso(), var6, 533, this.selectedExo, this.optionComptabilite);
      }

      if (this.plansTresorerie != null) {
         if (this.plansTresorerie.getTreId() != 0L) {
            this.calculeBudgetTresorerie();
         } else {
            this.var_action = 11;
         }
      } else if (this.plansTresorerie == null) {
         this.annuleBudgetTresorerie();
      }

   }

   public void recuperationBudgetTresorerie() throws JDOMException, IOException, HibernateException, NamingException {
      this.plansTresorerie = this.formRecherche.calculeBudgetTresorerie();
      this.calculeBudgetTresorerie();
   }

   public void calculeBudgetTresorerie() throws JDOMException, IOException {
      if (this.plansTresorerie != null && this.comptaProjet) {
         this.ecritures.setEcrPosteTreso(this.plansTresorerie.getTreCode());
         if (this.plansTresorerie.getTreProjet() != null && !this.plansTresorerie.getTreProjet().isEmpty()) {
            if (this.plansTresorerie.getTreProjet().contains(":")) {
               String[] var1 = this.plansTresorerie.getTreProjet().split(":");
               this.ecritures.setEcrBudgetTreso(var1[0]);
               this.ecritures.setEcrContrePartie(this.plansTresorerie.getTreCompte());
            } else {
               this.ecritures.setEcrBudgetTreso(this.plansTresorerie.getTreProjet());
               this.ecritures.setEcrContrePartie(this.plansTresorerie.getTreCompte());
            }

            this.memo_compte_budgetTreso = this.plansTresorerie.getTreCompte();
         } else {
            this.ecritures.setEcrBudgetTreso("");
            this.memo_compte_budgetTreso = "";
         }
      } else if (this.plansTresorerie != null && !this.comptaProjet) {
         this.ecritures.setEcrTreso(this.plansTresorerie.getTreCode());
         this.memo_compte_budgetTreso = this.plansTresorerie.getTreCompte();
      } else {
         this.plansTresorerie = null;
         this.ecritures.setEcrPosteTreso("");
         this.ecritures.setEcrBudgetTreso("");
         this.ecritures.setEcrTreso("");
         this.memo_compte_budgetTreso = "";
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleBudgetTresorerie() {
      this.plansTresorerie = null;
      this.ecritures.setEcrBudgetTreso("");
      this.ecritures.setEcrPosteTreso("");
      this.ecritures.setEcrTreso("");
      this.memo_compte_budgetTreso = "";
      this.var_action = this.var_memo_action;
   }

   public void detailTiers() throws JDOMException, IOException, HibernateException, NamingException, java.text.ParseException {
      if (this.ecritures != null) {
         this.formRecherche.setNature(534);
         this.formRecherche.rechercheTiers(this.ecritures.getEcrCompte(), this.calculdateSasisie());
      }

      this.var_action = 12;
   }

   public void annuleDetailTiers() {
      this.var_action = this.var_memo_action;
   }

   public void extraitCompte() throws HibernateException, NamingException, java.text.ParseException {
      if (this.ecritures != null) {
         this.var_memo_action = this.var_action;
         this.var_action = 13;
         this.formExtraitCompte = new FormExtraitCompte();
         this.formExtraitCompte.setBaseLog(this.baseLog);
         this.formExtraitCompte.setStructureLog(this.structureLog);
         this.formExtraitCompte.setUsersLog(this.usersLog);
         this.formExtraitCompte.setFormRecherche(this.formRecherche);
         this.formExtraitCompte.setutilInitHibernate(this.utilInitHibernate);
         this.formExtraitCompte.InstancesDaoUtilses();
         this.formExtraitCompte.setPlanComptable(this.planComptable);
         this.formExtraitCompte.setInputnum(this.ecritures.getEcrCompte());
         this.formExtraitCompte.setDateDebut(this.selectedExo.getExecptDateDebut());
         this.formExtraitCompte.setDateFin(this.selectedExo.getExecptDateFin());
         this.formExtraitCompte.setSelectedExo(this.selectedExo);
         this.formExtraitCompte.setAnalytique((String)null);
         this.formExtraitCompte.setDossier((String)null);
         this.formExtraitCompte.setSituationRech(false);
         this.formExtraitCompte.setReserveRech(false);
         this.formExtraitCompte.setFiltrage("1");
         this.formExtraitCompte.setLibEC("");
         this.formExtraitCompte.setLettrage("");
         this.formExtraitCompte.setPointage("");
         this.formExtraitCompte.setRef1("");
         this.formExtraitCompte.setRef2("");
         this.formExtraitCompte.setPiece("");
         this.formExtraitCompte.setMontant(0.0D);
         this.formExtraitCompte.setOptionComptabilite(this.optionComptabilite);
         this.formExtraitCompte.setSelecFiscalite(this.selecFiscalite);
         this.formExtraitCompte.chargerEcritures();
      }

   }

   public void fermerJournauxExtrait() {
      if (!this.optionComptabilite.getTrf_brl().equalsIgnoreCase("1") && this.journauxMois.getJoumenEtat() == 0) {
         if (this.selectedExo.getExecpt_id() != this.lastExo.getExecpt_id()) {
            this.var_action = 3;
         } else {
            this.var_action = 1;
         }
      } else {
         this.var_action = 3;
      }

      this.var_memo_action = this.var_action;
   }

   public Date calculdateSasisie() throws java.text.ParseException {
      String var1 = this.journauxMois.getJoumenPeriode();
      int var2 = this.ecritures.getEcrJour();
      String[] var3 = var1.split(":");
      String var4 = var3[0];
      String var5 = var3[1];
      String var6 = null;
      if (var2 <= 9) {
         var6 = var5 + "-" + var4 + "-0" + var2;
      } else {
         var6 = var5 + "-" + var4 + "-" + var2;
      }

      Date var7 = this.utilDate.stringToDateSQLLight(var6);
      return var7;
   }

   public Date calculDatedeValeurTheo() throws java.text.ParseException {
      Date var1 = new Date();
      int var2 = this.journauxActif.getPljDvMbsp();
      int var3 = this.journauxActif.getPljDvMbhp();
      int var4 = this.journauxActif.getPljDvAbsp();
      int var5 = this.journauxActif.getPljDvAbhp();
      if (this.ecritures.getEcrOrigineBanque() == 0) {
         var1 = this.datedevaleurTheo(var2);
      } else if (this.ecritures.getEcrOrigineBanque() == 1) {
         var1 = this.datedevaleurTheo(var3);
      } else if (this.ecritures.getEcrOrigineBanque() == 2) {
         var1 = this.datedevaleurTheo(var4);
      } else if (this.ecritures.getEcrOrigineBanque() == 3) {
         var1 = this.datedevaleurTheo(var5);
      }

      return var1;
   }

   public Date datedevaleurTheo(int var1) throws java.text.ParseException {
      GregorianCalendar var2 = new GregorianCalendar();
      var2.setTime(this.calculdateSasisie());
      var2.add(5, var1);
      Date var3 = var2.getTime();
      return var3;
   }

   public void calculDateEcheance() throws HibernateException, NamingException, java.text.ParseException {
      if (this.ecritures != null && this.ecritures.getEcrDateEcheance() == null && (this.journauxActif.getPljNature() == 1 || this.journauxActif.getPljNature() == 2) && this.planComptable != null && (this.planComptable.getPlcNature() == 6 || this.planComptable.getPlcNature() == 7)) {
         new Tiers();
         TiersDao var2 = new TiersDao(this.baseLog, this.utilInitHibernate);
         Tiers var1 = var2.chargerTiersByCompte(this.ecritures.getEcrCompte());
         if (var1 != null) {
            Date var3 = this.calculdateSasisie();
            this.ecritures.setEcrDateEcheance(this.utilDate.CalculDateEcheance(var3, var1.getTietypereg(), var1.getTienbecheance(), var1.getTienbarrondi()));
         } else {
            this.ecritures.setEcrDateEcheance((Date)null);
         }
      }

   }

   public void calcultotaux() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      if (this.lesEcritures != null) {
         for(int var5 = 0; var5 < this.lesEcritures.size(); ++var5) {
            if (((Ecritures)this.lesEcritures.get(var5)).getEcrEtat() <= 1) {
               var1 += ((Ecritures)this.lesEcritures.get(var5)).getEcrCreditSaisie();
               var3 += ((Ecritures)this.lesEcritures.get(var5)).getEcrDebitSaisie();
            }
         }

         this.totalMvtsdebit = this.utilNombre.myRoundDevise(var3, this.journauxActif.getPljChoixDevise());
         this.totalMvtscredit = this.utilNombre.myRoundDevise(var1, this.journauxActif.getPljChoixDevise());
         double var7 = 0.0D;
         if (this.totalMvtscredit >= this.totalMvtsdebit) {
            var7 = this.totalMvtscredit - this.totalMvtsdebit;
            this.soldeCred = var7;
            this.soldeDeb = 0.0D;
         } else if (this.totalMvtsdebit > this.totalMvtscredit) {
            var7 = this.totalMvtsdebit - this.totalMvtscredit;
            this.soldeCred = 0.0D;
            this.soldeDeb = var7;
         } else if (this.totalMvtsdebit == this.totalMvtscredit) {
         }

         if (this.journauxActif.getPljNature() == 7 || this.journauxActif.getPljNature() == 8 || this.journauxActif.getPljNature() == 9 || this.journauxActif.getPljNature() == 10) {
            this.calculerSoldeFinal();
         }

         this.testAffSuppImpList = true;
      } else {
         this.totalMvtsdebit = 0.0D;
         this.totalMvtscredit = 0.0D;
         this.soldefinalDeb = 0.0D;
         this.soldefinalCred = 0.0D;
         this.testAffSuppImpList = false;
         this.testAffBrouillard = false;
      }

      if (this.optionComptabilite.getTrf_brl().equalsIgnoreCase("1")) {
         this.testfermerleJournal = true;
      } else if (this.journauxActif.getPljNature() != 7 && this.journauxActif.getPljNature() != 9) {
         if (this.totalMvtsdebit == this.totalMvtscredit) {
            this.testfermerleJournal = true;
         } else {
            this.testfermerleJournal = false;
         }
      } else {
         this.testfermerleJournal = true;
      }

   }

   public void calculerSoldeAnterieur(Session var1) throws NamingException {
      this.debitAnterieur = 0.0D;
      this.creditAnterieur = 0.0D;
      if (this.journauxActif.getPljNature() == 7 || this.journauxActif.getPljNature() == 8 || this.journauxActif.getPljNature() == 9 || this.journauxActif.getPljNature() == 10) {
         String var2 = this.convertitrPeriodeSql(this.var_periode);
         String var3 = var2 + "-" + "01";
         new ArrayList();
         String var5 = "";
         if (this.selectedExo.getExecptDateDebut().getMonth() + 1 <= 9) {
            var5 = "0" + (this.selectedExo.getExecptDateDebut().getMonth() + 1);
         } else {
            var5 = "" + (this.selectedExo.getExecptDateDebut().getMonth() + 1);
         }

         String var6 = "" + (this.selectedExo.getExecptDateDebut().getYear() + 1900);
         String var7 = var5 + ":" + var6;
         List var4 = this.ecrituresDao.calculSoldeAnterieur(var7, var3, this.cpTreso, this.journauxActif.getPljCode(), this.selectedExo.getExecpt_id(), var1);
         double var8 = 0.0D;
         double var10 = 0.0D;
         new Ecritures();

         for(int var13 = 0; var13 < var4.size(); ++var13) {
            Ecritures var12 = (Ecritures)var4.get(var13);
            if (var12.getEcrEtat() <= 1) {
               var8 += var12.getEcrDebitSaisie();
               var10 += var12.getEcrCreditSaisie();
            }
         }

         double var15;
         if (var8 > var10) {
            var15 = var8 - var10;
            this.debitAnterieur = var15;
            this.creditAnterieur = 0.0D;
         } else {
            var15 = var10 - var8;
            this.debitAnterieur = 0.0D;
            this.creditAnterieur = var15;
         }
      }

   }

   public String convertitrPeriodeSql(String var1) {
      String[] var2 = var1.split(":");
      String var3 = var2[0];
      String var4 = var2[1];
      String var5 = var4 + "-" + var3;
      return var5;
   }

   public void calculerSoldeFinal() {
      this.soldefinalDeb = 0.0D;
      this.soldefinalCred = 0.0D;
      double var1 = this.debitAnterieur;
      double var3 = this.creditAnterieur;
      Ecritures var5;
      int var6;
      double var7;
      if (this.journauxActif.getPljNature() != 7 && this.journauxActif.getPljNature() != 9) {
         if (this.journauxActif.getPljNature() == 8 || this.journauxActif.getPljNature() == 10) {
            if (this.lesEcritures != null) {
               new Ecritures();

               for(var6 = 0; var6 < this.lesEcritures.size(); ++var6) {
                  var5 = (Ecritures)this.lesEcritures.get(var6);
                  if (var5.getEcrCompte().equalsIgnoreCase(this.cpTreso)) {
                     var1 += var5.getEcrDebitSaisie();
                     var3 += var5.getEcrCreditSaisie();
                  }
               }
            }

            if (var1 > var3) {
               var7 = var1 - var3;
               this.soldefinalDeb = var7;
               this.soldefinalCred = 0.0D;
            } else {
               var7 = var3 - var1;
               this.soldefinalDeb = 0.0D;
               this.soldefinalCred = var7;
            }
         }
      } else {
         if (this.lesEcritures != null) {
            new Ecritures();

            for(var6 = 0; var6 < this.lesEcritures.size(); ++var6) {
               var5 = (Ecritures)this.lesEcritures.get(var6);
               if (!var5.getEcrCompte().equalsIgnoreCase(this.cpTreso)) {
                  var1 += var5.getEcrCreditSaisie();
                  var3 += var5.getEcrDebitSaisie();
               }
            }
         }

         if (var1 > var3) {
            var7 = var1 - var3;
            this.soldefinalDeb = var7;
            this.soldefinalCred = 0.0D;
         } else {
            var7 = var3 - var1;
            this.soldefinalDeb = 0.0D;
            this.soldefinalCred = var7;
         }
      }

   }

   public void saveEcritureLight() throws HibernateException, NamingException, java.text.ParseException {
      if (this.ecritures.getEcrLibelle() == null || this.ecritures.getEcrLibelle().isEmpty()) {
         this.ecritures.setEcrLibelle("Libellé");
      }

      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.ecritures.getEcrDebitSaisie() != 0.0D && this.ecritures.getEcrCreditSaisie() != 0.0D) {
            if (this.soldeDeb != 0.0D) {
               this.ecritures.setEcrDebitSaisie(0.0D);
            } else {
               this.ecritures.setEcrCreditSaisie(0.0D);
            }
         }

         if ((this.ecritures.getEcrContrePartie() == null || this.ecritures.getEcrContrePartie().isEmpty()) && this.ecritures.getEcrCompte().startsWith("5")) {
            this.ecritures.setEcrContrePartie(this.memoCompte);
         }

         this.ecritures.setExercicesComptable(this.selectedExo);
         this.ecritures.setBrouillard((Brouillard)null);
         this.ecritures.setEcrDateSaisie(this.calculdateSasisie());
         this.ecritures.setEcrPeriode(this.var_periode);
         this.ecritures.setEcrCode(this.journauxActif.getPljCode());
         this.ecritures.setEcrNatureJrx(this.journauxActif.getPljNature());
         this.ecritures.setEcrReserve(this.journauxActif.getPljReserve());
         String var3 = "" + (this.ecritures.getEcrDateSaisie().getYear() + 1900);
         String var4 = "";
         if (this.ecritures.getEcrDateSaisie().getMonth() + 1 <= 9) {
            var4 = "0" + (this.ecritures.getEcrDateSaisie().getMonth() + 1);
         } else {
            var4 = "" + (this.ecritures.getEcrDateSaisie().getMonth() + 1);
         }

         String var5 = "";
         if (this.ecritures.getEcrJour() <= 9) {
            var5 = "0" + this.ecritures.getEcrJour();
         } else {
            var5 = "" + this.ecritures.getEcrJour();
         }

         this.ecritures.setEcrAnnee(var3);
         this.ecritures.setEcrEtat(0);
         this.ecritures.setEcrNature(this.planComptable.getPlcNature());
         this.ecritures.setEcrCle1(this.ecritures.getEcrCode() + ":" + this.ecritures.getEcrPeriode());
         this.ecritures.setEcrCle2(this.ecritures.getEcrCode() + ":" + var3 + ":" + var4 + ":" + var5);
         this.ecritures.setEcrOrdre(0L);
         if (this.journauxActif.getPljTypeDevise() == 0) {
            this.ecritures.setEcrDeviseSaisie(this.structureLog.getStrdevise());
         } else if (this.journauxActif.getPljTypeDevise() == 1) {
            this.ecritures.setEcrDeviseSaisie(this.journauxActif.getPljChoixDevise());
         } else if (this.journauxActif.getPljTypeDevise() == 2) {
         }

         this.ecritures.setEcrCoefEuro(this.utilNombre.deviseTaux1(this.ecritures.getEcrDeviseSaisie(), this.ecritures.getEcrDateSaisie()));
         this.ecritures.setEcrDebitEuro(this.utilNombre.myRoundFormat(this.ecritures.getEcrDebitSaisie() * (double)this.ecritures.getEcrCoefEuro(), 1));
         this.ecritures.setEcrCreditEuro(this.utilNombre.myRoundFormat(this.ecritures.getEcrCreditSaisie() * (double)this.ecritures.getEcrCoefEuro(), 1));
         this.ecritures.setEcrDevisePays(this.structureLog.getStrdevise());
         if (this.ecritures.getEcrDevisePays().equalsIgnoreCase(this.ecritures.getEcrDeviseSaisie())) {
            this.ecritures.setEcrCoefPays(1.0F);
            this.ecritures.setEcrDebitPays(this.ecritures.getEcrDebitSaisie());
            this.ecritures.setEcrCreditPays(this.ecritures.getEcrCreditSaisie());
         } else {
            this.ecritures.setEcrCoefPays(this.utilNombre.deviseTaux2(this.ecritures.getEcrDevisePays(), this.ecritures.getEcrDateSaisie()));
            this.ecritures.setEcrDebitPays(this.utilNombre.myRoundDevise(this.ecritures.getEcrDebitSaisie() * (double)this.ecritures.getEcrCoefPays(), this.ecritures.getEcrDevisePays()));
            this.ecritures.setEcrCreditPays(this.utilNombre.myRoundDevise(this.ecritures.getEcrCreditSaisie() * (double)this.ecritures.getEcrCoefPays(), this.ecritures.getEcrDevisePays()));
         }

         this.ecritures.setEcrDeviseGrp(this.structureLog.getStrdevise());
         this.ecritures.setEcrCoefGrp(1.0F);
         this.ecritures.setEcrDebitGrp(this.ecritures.getEcrDebitSaisie());
         this.ecritures.setEcrCreditGrp(this.ecritures.getEcrCreditSaisie());
         if (this.ecritures.getEcr_id() != 0L) {
            this.var_modif = true;
            this.ecritures.setEcrDateModif(new Date());
            this.ecritures.setEcrUserModif(this.usersLog.getUsrid());
            this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
         } else {
            this.var_modif = false;
            this.ecritures.setEcrDateCreat(new Date());
            this.ecritures.setEcrUserCreat(this.usersLog.getUsrid());
            if (this.verrouNum && (this.ecritures.getEcrPiece() == null || this.ecritures.getEcrPiece().isEmpty())) {
               this.ecritures.setEcrPiece(this.numComposeJournal(var1));
            }

            this.ecritures = this.ecrituresDao.insert(this.ecritures, var1);
            if (this.lesEcritures == null) {
               this.lesEcritures = new LinkedList();
               this.datamodelEcritures = new ListDataModel();
            }

            this.lesEcritures.add(this.ecritures);
            this.datamodelEcritures.setWrappedData(this.lesEcritures);
         }

         this.calcultotaux();
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

   public void saveEcritureComptable() throws NamingException, JDOMException, IOException, java.text.ParseException {
      if (this.planComptable != null && this.ecritures.getEcrCompte() != null && this.ecritures.getEcrLibelle() != null && !this.ecritures.getEcrLibelle().isEmpty() && (this.ecritures.getEcrDebitSaisie() != 0.0D || this.ecritures.getEcrCreditSaisie() != 0.0D)) {
         this.saveEcritureLight();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.var_memo_ligne_gene = 0L;
            if (this.optionComptabilite.getAnalytique().equals("true") && this.ecritures.getEcrEtat() == 0 && this.journauxActif.getPljAnalytique() == 0 && (this.optionComptabilite.getSaisieAnalytique().equals("0") || this.optionComptabilite.getSaisieAnalytique().equals("1"))) {
               boolean var3 = this.testCompteAnalytique();
               boolean var4 = this.testCompteBudget();
               if (!var3 && !var4) {
                  if (!var3 && !var4) {
                     this.var_memo_ligne_gene = this.ecritures.getEcr_id();
                     this.formAnalytique.nettoyageDetailAnalytique(this.ecritures, var1);
                     if (this.ecritures.getEcrAnaActif() == 1) {
                        this.ecritures = this.ecrituresDao.recupererSelectedECById(this.var_memo_ligne_gene, var1);
                        if (this.ecritures != null) {
                           this.ecritures.setEcrAnaActif(0);
                           this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
                        }
                     }
                  }
               } else {
                  this.ecritures.setEcrAnaActif(1);
                  this.var_memo_ligne_gene = this.ecritures.getEcr_id();
                  this.formAnalytique.initAnalytique(this.optionComptabilite, var1);
                  this.formAnalytique.chargementDetailAnalytique(this.ecritures, false, var1);
                  this.showModalPanelAnalytique = true;
               }
            }

            if (this.totalMvtscredit == this.totalMvtsdebit) {
               this.memoCompte = "";
               this.memoCP = "";
               this.memoDteEche = null;
               this.memoDteVal = null;
               this.memoRef1 = "";
               this.memoRef2 = "";
               this.memoPiece = "";
               this.memoLib = "";
               this.memoDebit = 0.0D;
               this.memoCredit = 0.0D;
               this.memoNatCompte = 0;
               this.memoJour = this.calculeDernierJour();
            } else {
               this.memoCompte = this.ecritures.getEcrCompte();
               this.memoCP = this.ecritures.getEcrContrePartie();
               this.memoDteEche = this.ecritures.getEcrDateEcheance();
               this.memoDteVal = this.ecritures.getEcrDateValeurTheo();
               this.memoRef1 = this.ecritures.getEcrReference1();
               this.memoRef2 = this.ecritures.getEcrReference2();
               this.memoPiece = this.ecritures.getEcrPiece();
               this.memoLib = this.ecritures.getEcrLibelle();
               this.memoDebit = this.soldeDeb;
               this.memoCredit = this.soldeCred;
               this.memoNatCompte = this.ecritures.getEcrNature();
               this.memoJour = this.ecritures.getEcrJour();
               if (this.journauxActif.getPljNature() == 7 || this.journauxActif.getPljNature() == 8 || this.journauxActif.getPljNature() == 9 || this.journauxActif.getPljNature() == 10) {
                  this.memoCompte = this.cpTreso;
                  if (this.memoDebit > 0.0D) {
                     this.memoCredit = this.memoDebit;
                     this.memoDebit = 0.0D;
                  } else {
                     this.memoDebit = this.memoCredit;
                     this.memoCredit = 0.0D;
                  }
               }
            }

            this.calculeLigneSuivante(var1);
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

   }

   public void removeSelectedEC() throws NamingException {
      if (this.ecritures != null) {
         String var1 = this.ecritures.getEcrPiece();
         String var2 = this.ecritures.getEcrCompte();
         String var3 = this.ecritures.getEcrCode();
         String var4 = this.ecritures.getEcrPeriode();
         boolean var5 = false;
         if (this.testSupprimableEcriture()) {
            Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
            Transaction var7 = null;

            EcrituresAnalytiquesDao var8;
            try {
               var7 = var6.beginTransaction();
               var6.setFlushMode(FlushMode.MANUAL);
               var8 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
               Object var9 = new ArrayList();
               if (this.modeSupp == 0) {
                  var9 = var8.chargerLesEcrituresAnalytiques(this.ecritures, var6);
               } else if (this.modeSupp == 1) {
                  var9 = var8.chargerLesEcrituresAnalytiquesByPiece(var1, var4, var3, var6);
               } else if (this.modeSupp == 2) {
                  var9 = var8.chargerLesEcrituresAnalytiquesByJournal(var4, var3, var6);
               }

               if (((List)var9).size() != 0) {
                  var8.inserEcritureAnalytiquesDestroy((List)var9, this.usersLog, var6);
                  var6.flush();
                  var8.nettoyageAnalytiqueByEcriture((List)var9, var6);
                  var6.flush();
               }

               var7.commit();
               var5 = true;
            } catch (HibernateException var23) {
               if (var7 != null) {
                  var7.rollback();
               }

               var5 = false;
               throw var23;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            if (var5) {
               var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
               var8 = null;

               try {
                  Transaction var25 = var6.beginTransaction();
                  var6.setFlushMode(FlushMode.MANUAL);
                  String var11;
                  long var26;
                  String var27;
                  if (this.modeSupp == 0) {
                     this.ecrituresDao.inserEcrituresDestroyEC0(this.ecritures, this.usersLog, 100, var6);
                     var6.flush();
                     this.ecrituresDao.removeSelectedEC0(this.ecritures, 100, var6);
                     var6.flush();
                     this.suppressionPj(this.ecritures.getEcrPiece());
                     if (this.chrono != null && this.totalMvtsdebit == this.totalMvtscredit) {
                        var26 = this.recupererNumero();
                        var11 = this.calculChrono.formattageChrono(this.chrono, var26, this.journauxActif.getPljCode(), "", this.ecritures.getEcrDateSaisie());
                        if (var1.equalsIgnoreCase(var11)) {
                           this.decrementeNumero(var6);
                        }
                     }

                     var27 = "Suppression de l'écriture du journal : " + var3 + " du : " + var4 + " Pièce N° : " + var1 + " Ligne du compte : " + var2;
                     this.mAJEspion(var6, var27);
                     var6.flush();
                  } else if (this.modeSupp == 1) {
                     this.ecrituresDao.inserEcrituresDestroyEC1(this.lesEcritures, var1, this.usersLog, 100, var6);
                     var6.flush();
                     this.ecrituresDao.removeSelectedEC1(this.lesEcritures, var1, 100, var6);
                     var6.flush();
                     this.suppressionPj(var1);
                     if (this.chrono != null) {
                        var26 = this.recupererNumero();
                        var11 = this.calculChrono.formattageChrono(this.chrono, var26, this.journauxActif.getPljCode(), "", this.ecritures.getEcrDateSaisie());
                        if (var1.equalsIgnoreCase(var11)) {
                           this.decrementeNumero(var6);
                        }
                     }

                     var27 = "Suppression des écritures du journal : " + var3 + " du : " + var4 + " Pièce N° : " + var1;
                     this.mAJEspion(var6, var27);
                     var6.flush();
                  } else if (this.modeSupp == 2) {
                     this.ecrituresDao.inserEcrituresDestroyEC2(this.lesEcritures, this.usersLog, 100, var6);
                     var6.flush();
                     this.ecrituresDao.removeSelectedEC2(this.lesEcritures, 100, var6);
                     var6.flush();
                     this.suppressionPj("");
                     if (this.chrono != null) {
                        this.razNumero(var6);
                     }

                     var27 = "Supression des écritures du journal : " + var3 + " du : " + var4;
                     this.mAJEspion(var6, var27);
                     var6.flush();
                  }

                  var25.commit();
               } catch (HibernateException var21) {
                  if (var8 != null) {
                     var8.rollback();
                  }

                  throw var21;
               } finally {
                  this.utilInitHibernate.closeSession();
               }

               this.ChargerLesEcritures((Session)null);
               this.datamodelEcritures.setWrappedData(this.lesEcritures);
            }
         } else {
            this.formRecherche.setMessageTexte("La suppression est impossible car il y a des écritures lettrées ou rapprochées ou validées...");
            this.formRecherche.setShowModalPanelMessage(true);
         }

         this.modeSupp = 100;
         this.testnat = false;
         this.calcultotaux();
         this.ajouterLigne();
         this.memoCompte = "";
         this.memoCP = "";
         this.memoDteEche = null;
         this.memoDteVal = null;
         this.memoRef1 = "";
         this.memoRef2 = "";
         this.memoPiece = "";
         this.memoLib = "";
         this.memoDebit = 0.0D;
         this.memoCredit = 0.0D;
      }

      this.showModalPanelSupprimer = false;
   }

   public void suppressionPj(String var1) {
      Ecritures var2;
      int var3;
      String var4;
      String var5;
      File var6;
      if (var1 == null || var1.isEmpty() || this.modeSupp != 0 && this.modeSupp != 1) {
         if ((var1 == null || var1.isEmpty()) && this.modeSupp == 2 && this.lesEcritures.size() != 0) {
            new Ecritures();

            for(var3 = 0; var3 < this.lesEcritures.size(); ++var3) {
               var2 = (Ecritures)this.lesEcritures.get(var3);
               if (var2.getEcrPiece() != null && !var2.getEcrPiece().isEmpty() && var2.isEcrPj()) {
                  var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanCompta" + this.selectedExo.getExecpt_id() + File.separator;
                  var5 = var2.getEcrCode() + ":" + var2.getEcrPeriode() + ":" + var2.getEcrPiece().replaceAll("/", "_");
                  var6 = new File(var4 + var5 + ".pdf");
                  if (var6.exists()) {
                     var6.delete();
                  } else {
                     var6 = new File(var4 + var5 + ".jpg");
                     if (var6.exists()) {
                        var6.delete();
                     }
                  }
               }
            }
         }
      } else if (this.lesEcritures.size() != 0) {
         new Ecritures();

         for(var3 = 0; var3 < this.lesEcritures.size(); ++var3) {
            var2 = (Ecritures)this.lesEcritures.get(var3);
            if (var2.getEcrPiece() != null && !var2.getEcrPiece().isEmpty() && var2.getEcrPiece().equals(var1) && var2.isEcrPj()) {
               var4 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanCompta" + this.selectedExo.getExecpt_id() + File.separator;
               var5 = var2.getEcrCode() + ":" + var2.getEcrPeriode() + ":" + var2.getEcrPiece().replaceAll("/", "_");
               var6 = new File(var4 + var5 + ".pdf");
               if (var6.exists()) {
                  var6.delete();
               } else {
                  var6 = new File(var4 + var5 + ".jpg");
                  if (var6.exists()) {
                     var6.delete();
                  }
               }
            }
         }
      }

   }

   public void annulerSuppression() {
      this.showModalPanelSupprimer = false;
   }

   public boolean testSupprimableEcriture() {
      boolean var1 = true;
      if (this.modeSupp == 0) {
         if (this.ecritures != null && (this.ecritures.getEcrEtat() == 1 || this.ecritures.getEcrLettrage() != null && !this.ecritures.getEcrLettrage().isEmpty() || this.ecritures.getEcrPointage() != null && !this.ecritures.getEcrPointage().isEmpty() || this.ecritures.getEcrRapprochement() != null && !this.ecritures.getEcrRapprochement().isEmpty())) {
            var1 = false;
         }
      } else if (this.modeSupp == 1) {
         String var2 = this.ecritures.getEcrPiece();
         if (this.lesEcritures != null) {
            for(int var3 = 0; var3 < this.lesEcritures.size(); ++var3) {
               new Ecritures();
               Ecritures var4 = (Ecritures)this.lesEcritures.get(var3);
               if (var4.getEcrPiece().equalsIgnoreCase(var2) && (var4.getEcrEtat() == 1 || var4.getEcrLettrage() != null && !var4.getEcrLettrage().isEmpty() || var4.getEcrPointage() != null && !var4.getEcrPointage().isEmpty() || var4.getEcrRapprochement() != null && !var4.getEcrRapprochement().isEmpty())) {
                  var1 = false;
                  break;
               }
            }
         }
      } else if (this.modeSupp == 2 && this.lesEcritures != null) {
         for(int var5 = 0; var5 < this.lesEcritures.size(); ++var5) {
            new Ecritures();
            Ecritures var6 = (Ecritures)this.lesEcritures.get(var5);
            if (var6.getEcrEtat() == 1 || var6.getEcrLettrage() != null && !var6.getEcrLettrage().isEmpty() || var6.getEcrPointage() != null && !var6.getEcrPointage().isEmpty() || var6.getEcrRapprochement() != null && !var6.getEcrRapprochement().isEmpty()) {
               var1 = false;
               break;
            }
         }
      }

      return var1;
   }

   public void mAJEspion(Session var1, String var2) {
      this.espion = new Espion();
      this.espion.setEspdtecreat(new Date());
      this.espion.setUsers(this.usersLog);
      this.espion.setEspaction(var2);
      this.espion.setEsptype(0);
      this.espionDao.mAJEspion(this.espion, var1);
   }

   public void fermerAnalytique() {
      this.showModalPanelAnalytique = false;
      this.showModalPanelAnalytiqueCorrection = false;
      this.showModalPanelCorrection = false;
   }

   public void valideAnalytique() throws HibernateException, NamingException {
      if (this.var_memo_ligne_gene != 0L) {
         this.formAnalytique.saveDetailAnalytique(this.var_memo_ligne_gene, this.ecrituresDao);
         this.ecritures.setErreurAnalytique(false);
      }

      this.showModalPanelAnalytique = false;
      this.showModalPanelAnalytiqueCorrection = false;
   }

   public void calculSens() {
      if (this.planComptable.getPlcNature() == 6) {
         if (this.journauxActif.getPljNature() != 7 && this.journauxActif.getPljNature() != 8 && this.journauxActif.getPljNature() != 9 && this.journauxActif.getPljNature() != 10) {
            this.valindexD = 0;
            this.valindexC = 11;
         } else {
            this.valindexD = 11;
            this.valindexC = 0;
         }
      } else if (this.planComptable.getPlcNature() == 7) {
         if (this.journauxActif.getPljNature() != 7 && this.journauxActif.getPljNature() != 8 && this.journauxActif.getPljNature() != 9 && this.journauxActif.getPljNature() != 10) {
            this.valindexD = 11;
            this.valindexC = 0;
         } else {
            this.valindexD = 0;
            this.valindexC = 11;
         }
      } else if (this.planComptable.getPlcNature() == 16) {
         if (this.journauxActif.getPljNature() == 1) {
            this.valindexD = 11;
            this.valindexC = 0;
         } else {
            this.valindexD = 11;
            this.valindexC = 12;
         }
      } else if (this.planComptable.getPlcNature() == 17) {
         if (this.journauxActif.getPljNature() == 2) {
            this.valindexD = 0;
            this.valindexC = 11;
         } else {
            this.valindexD = 11;
            this.valindexC = 12;
         }
      } else {
         this.valindexD = 11;
         this.valindexC = 12;
      }

   }

   public void scenarioTaux() {
      if (this.totalMvtsdebit != this.totalMvtscredit) {
         double var1 = 0.0D;
         if (this.totalMvtsdebit > this.totalMvtscredit) {
            var1 = this.totalMvtsdebit - this.totalMvtscredit;
         } else {
            var1 = this.totalMvtscredit - this.totalMvtsdebit;
         }

         double var3;
         float var5;
         if (this.memoNatCompte != 6 && this.memoNatCompte != 7) {
            if (this.memoNatCompte != 3 && this.memoNatCompte != 4 && this.memoNatCompte != 5 && this.memoNatCompte != 16) {
               if (this.memoNatCompte == 17) {
                  if (this.planComptable.getPlcNature() == 13 || this.planComptable.getPlcNature() == 14) {
                     var3 = 0.0D;
                     var5 = this.planComptable.getPlcTauxTaxe();
                     var3 = var1 * (double)var5 / 100.0D;
                     var3 = this.utilNombre.myRoundFormat(var3, this.journauxActif.getPljFormatDevise());
                     if (this.totalMvtsdebit > this.totalMvtscredit) {
                        this.ecritures.setEcrCreditSaisie(0.0D);
                        this.ecritures.setEcrDebitSaisie(var3);
                     } else {
                        this.ecritures.setEcrCreditSaisie(var3);
                        this.ecritures.setEcrDebitSaisie(0.0D);
                     }
                  }
               } else if (this.planComptable.getPlcNature() != 13 && this.planComptable.getPlcNature() != 14) {
                  if (this.totalMvtsdebit > this.totalMvtscredit) {
                     this.ecritures.setEcrCreditSaisie(this.totalMvtsdebit - this.totalMvtscredit);
                     this.ecritures.setEcrDebitSaisie(0.0D);
                  } else {
                     this.ecritures.setEcrCreditSaisie(0.0D);
                     this.ecritures.setEcrDebitSaisie(this.totalMvtscredit - this.totalMvtsdebit);
                  }
               } else {
                  var3 = 0.0D;
                  var5 = this.planComptable.getPlcTauxTaxe() / 100.0F;
                  var3 = var1 * (double)var5;
                  var3 = this.utilNombre.myRoundFormat(var3, this.journauxActif.getPljFormatDevise());
                  if (this.totalMvtsdebit > this.totalMvtscredit) {
                     this.ecritures.setEcrCreditSaisie(var3);
                     this.ecritures.setEcrDebitSaisie(0.0D);
                  } else {
                     this.ecritures.setEcrCreditSaisie(0.0D);
                     this.ecritures.setEcrDebitSaisie(var3);
                  }
               }
            } else if (this.planComptable.getPlcNature() == 13 || this.planComptable.getPlcNature() == 14) {
               var3 = 0.0D;
               if (this.planComptable.getPlcTauxTaxe() == null) {
                  this.planComptable.setPlcTauxTaxe(0.0F);
               }

               var5 = this.planComptable.getPlcTauxTaxe();
               var3 = var1 * (double)var5 / 100.0D;
               var3 = this.utilNombre.myRoundFormat(var3, this.journauxActif.getPljFormatDevise());
               if (this.totalMvtsdebit > this.totalMvtscredit) {
                  this.ecritures.setEcrCreditSaisie(0.0D);
                  this.ecritures.setEcrDebitSaisie(var3);
               } else {
                  this.ecritures.setEcrCreditSaisie(var3);
                  this.ecritures.setEcrDebitSaisie(0.0D);
               }
            }
         } else if (this.planComptable.getPlcNature() == 13 || this.planComptable.getPlcNature() == 14) {
            var3 = 0.0D;
            var5 = 1.0F + this.planComptable.getPlcTauxTaxe() / 100.0F;
            var3 = var1 - var1 / (double)var5;
            var3 = this.utilNombre.myRoundFormat(var3, this.journauxActif.getPljFormatDevise());
            if (this.totalMvtsdebit > this.totalMvtscredit) {
               this.ecritures.setEcrCreditSaisie(var3);
               this.ecritures.setEcrDebitSaisie(0.0D);
            } else {
               this.ecritures.setEcrCreditSaisie(0.0D);
               this.ecritures.setEcrDebitSaisie(var3);
            }
         }
      }

   }

   public void calculeLigneSuivante(Session var1) throws NamingException, JDOMException, IOException, IOException, HibernateException, java.text.ParseException {
      if (!this.var_modif) {
         this.ajouterLigne();
         this.ecritures = new Ecritures();
         if (this.cpTreso == null || this.cpTreso.isEmpty() || this.journauxActif.getPljNature() != 8 && this.journauxActif.getPljNature() != 10) {
            if (this.cpTreso != null && !this.cpTreso.isEmpty() && (this.journauxActif.getPljNature() == 7 || this.journauxActif.getPljNature() == 9)) {
               this.memoLib = "";
               this.memoRef1 = "";
               this.memoRef2 = "";
            }
         } else if (this.totalMvtsdebit != this.totalMvtscredit) {
            if (this.memo_compte_budgetTreso != null && !this.memo_compte_budgetTreso.isEmpty()) {
               this.ecritures.setEcrCompte(this.memo_compte_budgetTreso);
            } else {
               this.ecritures.setEcrCompte(this.cpTreso);
            }

            if (this.totalMvtsdebit >= this.totalMvtscredit) {
               this.ecritures.setEcrDebitSaisie(0.0D);
               this.ecritures.setEcrCreditSaisie(this.soldeDeb);
            } else {
               this.ecritures.setEcrDebitSaisie(this.soldeCred);
               this.ecritures.setEcrCreditSaisie(0.0D);
            }
         }

         this.ecritures.setEcrJour(this.memoJour);
         this.ecritures.setEcrLibelle(this.memoLib);
         this.ecritures.setEcrPiece(this.memoPiece);
         this.ecritures.setEcrReference1(this.memoRef1);
         this.ecritures.setEcrReference2(this.memoRef2);
         if (this.ecritures.getEcrCompte() != null && !this.ecritures.getEcrCompte().isEmpty()) {
            this.planComptable = this.formRecherche.rechercheCompte(this.ecritures.getEcrCompte(), this.selectedExo.getExecpt_id(), var1);
            if (this.planComptable != null) {
               this.calculePlanComptable();
            }
         }

         this.testAffSuppImpList = false;
      } else {
         this.ajouterLigne();
      }

   }

   public void verifExitChrono(Session var1) throws HibernateException, NamingException {
      this.verrouNum = false;
      if (this.journauxActif.getPljPiece() != 0) {
         this.chrono = new Chrono();
         if (this.journauxMois != null) {
            String[] var2 = this.journauxMois.getJoumenPeriode().split(":");
            String var3 = "" + var2[1];
            this.chrono = this.chronoDao.chronoByNatAndJournalPeriode(this.nature, this.journauxActif.getPljCode(), var3, var1);
            if (this.chrono != null) {
               this.verrouNum = true;
            }
         }
      }

      if (!this.verrouNum) {
         this.var_nom_champ = "sm:formsm:pieceId";
      } else {
         this.var_nom_champ = "sm:formsm:ref1Id";
      }

   }

   public String numComposeJournal(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      long var3 = 0L;
      if (this.verrouNum) {
         if (this.journauxActif.getPljPiece() == 1) {
            var3 = this.enregitrerNumero(var1);
         } else if (this.journauxActif.getPljPiece() == 2) {
            if (this.totalMvtscredit == this.totalMvtsdebit) {
               var3 = this.enregitrerNumero(var1);
            } else {
               var3 = this.recupererNumero();
            }
         } else {
            var3 = this.recupererNumero();
         }

         var2 = this.calculChrono.formattageChrono(this.chrono, var3, this.journauxActif.getPljCode(), "", this.ecritures.getEcrDateSaisie());
      } else {
         var2 = "" + this.ecritures.getEcrPiece();
      }

      return var2;
   }

   public long recupererNumero() {
      long var1 = 0L;
      if (this.chrono.getChrMode() == 0) {
         var1 = this.chrono.getChrNumAn();
      } else if (this.chrono.getChrMode() == 1) {
         String[] var3 = this.journauxMois.getJoumenPeriode().split(":");
         String var4 = var3[0];
         if (var4.equalsIgnoreCase("01")) {
            var1 = this.chrono.getChrNum01();
         } else if (var4.equalsIgnoreCase("02")) {
            var1 = this.chrono.getChrNum02();
         } else if (var4.equalsIgnoreCase("03")) {
            var1 = this.chrono.getChrNum03();
         } else if (var4.equalsIgnoreCase("04")) {
            var1 = this.chrono.getChrNum04();
         } else if (var4.equalsIgnoreCase("05")) {
            var1 = this.chrono.getChrNum05();
         } else if (var4.equalsIgnoreCase("06")) {
            var1 = this.chrono.getChrNum06();
         } else if (var4.equalsIgnoreCase("07")) {
            var1 = this.chrono.getChrNum07();
         } else if (var4.equalsIgnoreCase("08")) {
            var1 = this.chrono.getChrNum08();
         } else if (var4.equalsIgnoreCase("09")) {
            var1 = this.chrono.getChrNum09();
         } else if (var4.equalsIgnoreCase("10")) {
            var1 = this.chrono.getChrNum10();
         } else if (var4.equalsIgnoreCase("11")) {
            var1 = this.chrono.getChrNum11();
         } else if (var4.equalsIgnoreCase("12")) {
            var1 = this.chrono.getChrNum12();
         }
      } else if (this.chrono.getChrMode() == 2) {
         var1 = this.chrono.getChrNum();
      }

      return var1;
   }

   public long enregitrerNumero(Session var1) throws HibernateException, NamingException {
      long var2 = 0L;
      if (this.chrono.getChrMode() == 0) {
         this.chrono.setChrNumAn(this.chrono.getChrNumAn() + 1L);
         var2 = this.chrono.getChrNumAn();
      } else if (this.chrono.getChrMode() == 1) {
         String[] var4 = this.journauxMois.getJoumenPeriode().split(":");
         String var5 = var4[0];
         if (var5.equalsIgnoreCase("01")) {
            this.chrono.setChrNum01(this.chrono.getChrNum01() + 1L);
            var2 = this.chrono.getChrNum01();
         } else if (var5.equalsIgnoreCase("02")) {
            this.chrono.setChrNum02(this.chrono.getChrNum02() + 1L);
            var2 = this.chrono.getChrNum02();
         } else if (var5.equalsIgnoreCase("03")) {
            this.chrono.setChrNum03(this.chrono.getChrNum03() + 1L);
            var2 = this.chrono.getChrNum03();
         } else if (var5.equalsIgnoreCase("04")) {
            this.chrono.setChrNum04(this.chrono.getChrNum04() + 1L);
            var2 = this.chrono.getChrNum04();
         } else if (var5.equalsIgnoreCase("05")) {
            this.chrono.setChrNum05(this.chrono.getChrNum05() + 1L);
            var2 = this.chrono.getChrNum05();
         } else if (var5.equalsIgnoreCase("06")) {
            this.chrono.setChrNum06(this.chrono.getChrNum06() + 1L);
            var2 = this.chrono.getChrNum06();
         } else if (var5.equalsIgnoreCase("07")) {
            this.chrono.setChrNum07(this.chrono.getChrNum07() + 1L);
            var2 = this.chrono.getChrNum07();
         } else if (var5.equalsIgnoreCase("08")) {
            this.chrono.setChrNum08(this.chrono.getChrNum08() + 1L);
            var2 = this.chrono.getChrNum08();
         } else if (var5.equalsIgnoreCase("09")) {
            this.chrono.setChrNum09(this.chrono.getChrNum09() + 1L);
            var2 = this.chrono.getChrNum09();
         } else if (var5.equalsIgnoreCase("10")) {
            this.chrono.setChrNum10(this.chrono.getChrNum10() + 1L);
            var2 = this.chrono.getChrNum10();
         } else if (var5.equalsIgnoreCase("11")) {
            this.chrono.setChrNum11(this.chrono.getChrNum11() + 1L);
            var2 = this.chrono.getChrNum11();
         } else if (var5.equalsIgnoreCase("12")) {
            this.chrono.setChrNum12(this.chrono.getChrNum12() + 1L);
            var2 = this.chrono.getChrNum12();
         }
      } else if (this.chrono.getChrMode() == 2) {
         this.chrono.setChrNum(this.chrono.getChrNum() + 1L);
         var2 = this.chrono.getChrNum();
      }

      this.chronoDao.modifierChrono(this.chrono, var1);
      return var2;
   }

   public void decrementeNumero(Session var1) throws HibernateException, NamingException {
      long var2 = 0L;
      if (this.chrono.getChrMode() == 0) {
         this.chrono.setChrNumAn(this.chrono.getChrNumAn() - 1L);
      } else if (this.chrono.getChrMode() == 1) {
         String[] var4 = this.journauxMois.getJoumenPeriode().split(":");
         String var5 = var4[0];
         if (var5.equalsIgnoreCase("01")) {
            this.chrono.setChrNum01(this.chrono.getChrNum01() - 1L);
         } else if (var5.equalsIgnoreCase("02")) {
            this.chrono.setChrNum02(this.chrono.getChrNum02() - 1L);
         } else if (var5.equalsIgnoreCase("03")) {
            this.chrono.setChrNum03(this.chrono.getChrNum03() - 1L);
         } else if (var5.equalsIgnoreCase("04")) {
            this.chrono.setChrNum04(this.chrono.getChrNum04() - 1L);
         } else if (var5.equalsIgnoreCase("05")) {
            this.chrono.setChrNum05(this.chrono.getChrNum05() - 1L);
         } else if (var5.equalsIgnoreCase("06")) {
            this.chrono.setChrNum06(this.chrono.getChrNum06() - 1L);
         } else if (var5.equalsIgnoreCase("07")) {
            this.chrono.setChrNum07(this.chrono.getChrNum07() - 1L);
         } else if (var5.equalsIgnoreCase("08")) {
            this.chrono.setChrNum08(this.chrono.getChrNum08() - 1L);
         } else if (var5.equalsIgnoreCase("09")) {
            this.chrono.setChrNum09(this.chrono.getChrNum09() - 1L);
         } else if (var5.equalsIgnoreCase("10")) {
            this.chrono.setChrNum10(this.chrono.getChrNum10() - 1L);
         } else if (var5.equalsIgnoreCase("11")) {
            this.chrono.setChrNum11(this.chrono.getChrNum11() - 1L);
         } else if (var5.equalsIgnoreCase("12")) {
            this.chrono.setChrNum12(this.chrono.getChrNum12() - 1L);
         }
      } else if (this.chrono.getChrMode() == 2) {
         this.chrono.setChrNum(this.chrono.getChrNum() - 1L);
      }

      this.chronoDao.modifierChrono(this.chrono, var1);
      var1.flush();
   }

   public void razNumero(Session var1) throws HibernateException, NamingException {
      long var2 = 0L;
      if (this.chrono.getChrMode() == 0) {
         this.chrono.setChrNumAn(0L);
      } else if (this.chrono.getChrMode() == 1) {
         String[] var4 = this.journauxMois.getJoumenPeriode().split(":");
         String var5 = var4[0];
         if (var5.equalsIgnoreCase("01")) {
            this.chrono.setChrNum01(0L);
         } else if (var5.equalsIgnoreCase("02")) {
            this.chrono.setChrNum02(0L);
         } else if (var5.equalsIgnoreCase("03")) {
            this.chrono.setChrNum03(0L);
         } else if (var5.equalsIgnoreCase("04")) {
            this.chrono.setChrNum04(0L);
         } else if (var5.equalsIgnoreCase("05")) {
            this.chrono.setChrNum05(0L);
         } else if (var5.equalsIgnoreCase("06")) {
            this.chrono.setChrNum06(0L);
         } else if (var5.equalsIgnoreCase("07")) {
            this.chrono.setChrNum07(0L);
         } else if (var5.equalsIgnoreCase("08")) {
            this.chrono.setChrNum08(0L);
         } else if (var5.equalsIgnoreCase("09")) {
            this.chrono.setChrNum09(0L);
         } else if (var5.equalsIgnoreCase("10")) {
            this.chrono.setChrNum10(0L);
         } else if (var5.equalsIgnoreCase("11")) {
            this.chrono.setChrNum11(0L);
         } else if (var5.equalsIgnoreCase("12")) {
            this.chrono.setChrNum12(0L);
         }
      } else if (this.chrono.getChrMode() == 2) {
         this.chrono.setChrNum(0L);
      }

      this.chronoDao.modifierChrono(this.chrono, var1);
      var1.flush();
   }

   public void rechercheDossier() throws HibernateException, NamingException {
      if (this.ecritures.getEcrDossier() != null && !this.ecritures.getEcrDossier().isEmpty()) {
         new ArrayList();
         PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         List var1 = var2.selectAnal("6", this.ecritures.getEcrDossier(), "", this.nature, (Session)null);
         if (var1.size() != 0) {
            this.datamodelDossier.setWrappedData(var1);
            this.codeDossier = "";
            this.showModalPanelDossier = true;
         }
      }

   }

   public void selectionRecherche() {
      if (this.datamodelDossier.isRowAvailable()) {
         new PlansAnalytiques();
         PlansAnalytiques var1 = (PlansAnalytiques)this.datamodelDossier.getRowData();
         this.codeDossier = var1.getAnaCode();
      }

   }

   public void annuleDossier() {
      this.codeDossier = "";
      this.showModalPanelDossier = false;
   }

   public void valideDossier() {
      this.ecritures.setEcrDossier(this.codeDossier);
      this.showModalPanelDossier = false;
   }

   public void chargerBrouillard() throws HibernateException, NamingException {
      if (this.brouillard != null) {
         UserDao var1 = new UserDao(this.baseLog, this.utilInitHibernate);
         this.userBrouillard = var1.selectByIdUsers(this.brouillard.getBroUserCreat(), (Session)null).getUsrPatronyme();
         this.showModalPanelBrouillard = true;
      }

   }

   public void fermerBrouillard() {
      this.showModalPanelBrouillard = false;
   }

   public void validationLignes() {
      this.var_choix_validation = 0;
      this.var_jourDebut = 1;
      this.var_jourFin = Integer.parseInt(((SelectItem)this.lesjoursItems.get(this.lesjoursItems.size() - 1)).getValue().toString());
      this.lesPiecesSelectionnes.clear();
      new EcrituresLight();
      if (this.lesEcritures.size() != 0) {
         for(int var2 = 0; var2 < this.lesEcritures.size(); ++var2) {
            if (((Ecritures)this.lesEcritures.get(var2)).getEcrEtat() == 0) {
               String var3 = ((Ecritures)this.lesEcritures.get(var2)).getEcrPiece();
               boolean var4 = false;
               if (this.lesPiecesSelectionnes.size() != 0) {
                  for(int var5 = 0; var5 < this.lesPiecesSelectionnes.size(); ++var5) {
                     if (var3.equals(((EcrituresLight)this.lesPiecesSelectionnes.get(var5)).getEcrPiece())) {
                        var4 = true;
                        break;
                     }
                  }
               }

               if (!var4) {
                  EcrituresLight var1 = new EcrituresLight();
                  var1.setSelect(false);
                  var1.setEcrPiece(var3);
                  this.lesPiecesSelectionnes.add(var1);
               }
            }
         }
      }

      this.showModalPanelValidation = true;
   }

   public void attenteLignes() throws HibernateException, NamingException {
      if (this.ecritures != null && this.ecritures.getEcrEtat() != 1 && !this.ecritures.isNbrEcrLettrage()) {
         if (this.ecritures.getEcrEtat() == 0) {
            this.ecritures.setEcrEtat(2);
         } else {
            this.ecritures.setEcrEtat(0);
         }

         this.ecritures = this.ecrituresDao.modif(this.ecritures);
         this.calcultotaux();
      }

   }

   public void selectionToutesPieces() {
      if (this.lesPiecesSelectionnes.size() != 0) {
         for(int var1 = 0; var1 < this.lesPiecesSelectionnes.size(); ++var1) {
            new EcrituresLight();
            EcrituresLight var2 = (EcrituresLight)this.lesPiecesSelectionnes.get(var1);
            if (var2.isSelect()) {
               var2.setSelect(false);
            } else {
               var2.setSelect(true);
            }
         }
      }

   }

   public void annulerValidationLignes() {
      this.showModalPanelValidation = false;
   }

   public void saveValidationLignes() throws HibernateException, NamingException {
      if (this.lesEcritures.size() != 0) {
         this.ajouterLigne();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            String var3;
            if (this.var_choix_validation == 0) {
               for(int var12 = 0; var12 < this.lesEcritures.size(); ++var12) {
                  this.ecritures = new Ecritures();
                  this.ecritures = (Ecritures)this.lesEcritures.get(var12);
                  if (this.ecritures.getEcrJour() >= this.var_jourDebut && this.ecritures.getEcrJour() <= this.var_jourFin && this.ecritures.getEcrEtat() == 0) {
                     this.ecritures.setEcrEtat(1);
                     this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
                     var1.flush();
                  }
               }

               var3 = "Validation des écritures du journal : " + this.journauxMois.getJoumenCode() + " du : " + this.var_jourDebut + " au : " + this.var_jourFin;
               this.mAJEspion(var1, var3);
               var1.flush();
            } else if (this.lesPiecesSelectionnes.size() != 0) {
               var3 = "";
               int var4 = 0;

               while(true) {
                  if (var4 >= this.lesPiecesSelectionnes.size()) {
                     String var13 = "Validation des écritures du journal : " + this.journauxMois.getJoumenCode() + " de(s) pièce(s) : " + var3;
                     this.mAJEspion(var1, var13);
                     var1.flush();
                     break;
                  }

                  if (((EcrituresLight)this.lesPiecesSelectionnes.get(var4)).isSelect()) {
                     String var5 = ((EcrituresLight)this.lesPiecesSelectionnes.get(var4)).getEcrPiece();
                     var3 = var3 + var5 + ",";

                     for(int var6 = 0; var6 < this.lesEcritures.size(); ++var6) {
                        this.ecritures = new Ecritures();
                        this.ecritures = (Ecritures)this.lesEcritures.get(var6);
                        if (this.ecritures.getEcrPiece().equals(var5) && this.ecritures.getEcrEtat() == 0) {
                           this.ecritures.setEcrEtat(1);
                           this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
                           var1.flush();
                        }
                     }
                  }

                  ++var4;
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

      this.showModalPanelValidation = false;
   }

   public void cloturerPeriode() throws NamingException, java.text.ParseException, Exception {
      if (this.periode.contains(":")) {
         String[] var1 = this.periode.split(":");
         String var2 = "01-" + var1[0] + "-" + var1[1];
         SimpleDateFormat var3 = new SimpleDateFormat("dd-MM-yyyy");
         Date var4 = var3.parse(var2);
         this.dateDebut = this.selectedExo.getExecptDateDebut();
         this.dateFin = this.utilDate.dateDernierJourMois(var4);
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var6 = null;

         try {
            var6 = var5.beginTransaction();
            new ArrayList();
            List var7 = this.journauxMoisDao.listeJouMemPourCloture(this.periode, this.lastExo, var5);
            if (var7.size() != 0) {
               new JournauxMois();

               for(int var9 = 0; var9 < var7.size(); ++var9) {
                  JournauxMois var8 = (JournauxMois)var7.get(var9);
                  var8.setJoumenEtat(1);
                  this.journauxMoisDao.majJournal(var8, var5);
                  var5.flush();
               }
            }

            this.ecrituresDao.chargerEcrituresPourCloture(this.selectedExo.getExecpt_id(), this.dateDebut, this.dateFin, var5);
            var5.flush();
            String var16 = "Cloture des écritures du journal : " + this.journauxMois.getJoumenCode();
            this.mAJEspion(var5, var16);
            var5.flush();
            if (this.optionComptabilite.getMailClotureRappro() != null && !this.optionComptabilite.getMailClotureRappro().isEmpty() && this.optionComptabilite.getMailClotureRappro().contains("@")) {
               UtilMail var17 = new UtilMail(this.structureLog);
               String var10 = "Banque: " + this.journauxMois.getJoumenCode() + " Période:" + this.journauxMois.getJoumenPeriode();
               var17.envoieMailJournal(this.structureLog, this.usersLog, var10, 0, this.optionComptabilite.getMailClotureRappro(), this.utilDate);
            }

            var6.commit();
         } catch (HibernateException var14) {
            if (var6 != null) {
               var6.rollback();
            }

            throw var14;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void interchangeEcritures() throws IOException, NamingException {
      this.var_action = 4;
      this.var_memo_action = this.var_action;
      this.outilChoisi = 99;
      this.forceVerrou = false;
      this.toolsLesJournauxComptables = new ArrayList();
      this.toolsLesJournauxComptables = this.journauxComptablesDao.mesjournauxActifsItems(this.selectedExo.getExecpt_id(), this.usersLog.getUsrJrxInterdit(), this.usersLog.getUsrJrxReserve(), (Session)null);
      this.toolsCode = "";
      this.toolsLesPeriode = new ArrayList();
      this.toolsLesPeriode = this.lesPeriodes;
      this.toolsPeriode = "";
      this.ecritures = new Ecritures();
      this.toolsCompteOld = "";
      this.lesEcrituresAReimputer = new ArrayList();
      this.dataModelEcritureAReimputer = new ListDataModel();
   }

   public void selectionAll() {
      if (this.lesEcritures.size() != 0) {
         for(int var1 = 0; var1 < this.lesEcritures.size(); ++var1) {
            this.ecritures = new Ecritures();
            this.ecritures = (Ecritures)this.lesEcritures.get(var1);
            this.ecritures.setSel_ecriture(true);
         }

         this.datamodelEcritures.setWrappedData(this.lesEcritures);
      }

   }

   public void deselectionAll() {
      if (this.lesEcritures.size() != 0) {
         for(int var1 = 0; var1 < this.lesEcritures.size(); ++var1) {
            this.ecritures = new Ecritures();
            this.ecritures = (Ecritures)this.lesEcritures.get(var1);
            this.ecritures.setSel_ecriture(false);
         }

         this.datamodelEcritures.setWrappedData(this.lesEcritures);
      }

   }

   public void majCorrection() throws HibernateException, NamingException, java.text.ParseException, FileNotFoundException, IOException {
      if (this.lesEcritures.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            String var3 = "";
            this.ecritures = new Ecritures();
            if (this.outilChoisi == 0) {
               var3 = "Correction Ecriture du journal: " + this.journauxActif.getPljCode() + "/" + this.journauxMois.getJoumenPeriode() + ": inverse Débit/crédit";
               this.outilChoisi0(var1);
            } else if (this.outilChoisi == 1) {
               var3 = "Correction Ecriture du journal: " + this.journauxActif.getPljCode() + "/" + this.journauxMois.getJoumenPeriode() + ": inverse sens Débit";
               this.outilChoisi1(var1);
            } else if (this.outilChoisi == 2) {
               var3 = "Correction Ecriture du journal: " + this.journauxActif.getPljCode() + "/" + this.journauxMois.getJoumenPeriode() + ": inverse sens Crédit";
               this.outilChoisi2(var1);
            } else if (this.outilChoisi == 3 && this.toolsCode != null && !this.toolsCode.isEmpty()) {
               var3 = "Correction Ecriture du journal: " + this.journauxActif.getPljCode() + "/" + this.journauxMois.getJoumenPeriode() + ": change code journal vers" + this.toolsCode;
               this.outilChoisi3(var1);
            } else if (this.outilChoisi == 4) {
               var3 = "Correction Ecriture du journal: " + this.journauxActif.getPljCode() + "/" + this.journauxMois.getJoumenPeriode() + ": change période vers " + this.toolsPeriode;
               this.outilChoisi4(var1);
            } else if (this.outilChoisi == 5 && this.planComptable != null) {
               var3 = "Correction Ecriture du journal: " + this.journauxActif.getPljCode() + "/" + this.journauxMois.getJoumenPeriode() + ": change compte vers " + this.planComptable.getPlcCompte();
               this.outilChoisi5(var1);
            } else if (this.outilChoisi == 17) {
               var3 = "Correction Ecriture du journal: " + this.journauxActif.getPljCode() + "/" + this.journauxMois.getJoumenPeriode() + ": calculer contre partie";
               this.outilChoisi17(var1);
            } else if (this.outilChoisi == 20) {
               var3 = "Correction Ecriture du journal: " + this.journauxActif.getPljCode() + "/" + this.journauxMois.getJoumenPeriode() + ": duppliquer vers période vers " + this.toolsPeriode;
               this.outilChoisi20(var1);
            } else if (this.outilChoisi == 21) {
               var3 = "Correction Ecriture du journal: " + this.journauxActif.getPljCode() + "/" + this.journauxMois.getJoumenPeriode() + ": duppliquer vers journal vers " + this.toolsCode;
               this.outilChoisi21(var1);
            } else if (this.outilChoisi == 22) {
               var3 = "Correction Ecriture du journal: " + this.journauxActif.getPljCode() + "/" + this.journauxMois.getJoumenPeriode() + ": optimise journal par pièce et compte";
               this.outilChoisi22(var1);
            }

            this.mAJEspion(var1, var3);
            var1.flush();
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.ChargerLesEcritures((Session)null);
         this.ajouterLigne();
      }

      if (this.lesEcrituresAReimputer.size() != 0) {
         this.showModalPanelCorrection = true;
      } else {
         this.var_action = 1;
         this.var_memo_action = this.var_action;
      }

   }

   public void outilChoisi0(Session var1) throws HibernateException, NamingException, java.text.ParseException {
      for(int var2 = 0; var2 < this.lesEcritures.size(); ++var2) {
         this.ecritures = (Ecritures)this.lesEcritures.get(var2);
         if (this.ecritures.isSel_ecriture() && (!this.ecritures.isNbrEcrLettrage() && !this.forceVerrou || this.forceVerrou)) {
            double var3 = 0.0D;
            var3 = this.ecritures.getEcrDebitSaisie();
            this.ecritures.setEcrDebitSaisie(this.ecritures.getEcrCreditSaisie());
            this.ecritures.setEcrCreditSaisie(var3);
            var3 = this.ecritures.getEcrDebitPays();
            this.ecritures.setEcrDebitPays(this.ecritures.getEcrCreditPays());
            this.ecritures.setEcrCreditPays(var3);
            var3 = this.ecritures.getEcrDebitEuro();
            this.ecritures.setEcrDebitEuro(this.ecritures.getEcrCreditEuro());
            this.ecritures.setEcrCreditEuro(var3);
            var3 = this.ecritures.getEcrDebitGrp();
            this.ecritures.setEcrDebitGrp(this.ecritures.getEcrCreditGrp());
            this.ecritures.setEcrCreditGrp(var3);
            this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
            var1.flush();
         }
      }

   }

   public void outilChoisi1(Session var1) throws HibernateException, NamingException, java.text.ParseException {
      for(int var2 = 0; var2 < this.lesEcritures.size(); ++var2) {
         this.ecritures = (Ecritures)this.lesEcritures.get(var2);
         if (this.ecritures.isSel_ecriture() && (!this.ecritures.isNbrEcrLettrage() && !this.forceVerrou || this.forceVerrou)) {
            double var3 = 0.0D;
            var3 = this.ecritures.getEcrDebitSaisie() * -1.0D;
            this.ecritures.setEcrDebitSaisie(var3);
            var3 = this.ecritures.getEcrDebitPays() * -1.0D;
            this.ecritures.setEcrDebitPays(var3);
            var3 = this.ecritures.getEcrDebitEuro() * -1.0D;
            this.ecritures.setEcrDebitEuro(var3);
            var3 = this.ecritures.getEcrDebitGrp() * -1.0D;
            this.ecritures.setEcrDebitGrp(var3);
            this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
            var1.flush();
         }
      }

   }

   public void outilChoisi2(Session var1) throws HibernateException, NamingException, java.text.ParseException {
      for(int var2 = 0; var2 < this.lesEcritures.size(); ++var2) {
         this.ecritures = (Ecritures)this.lesEcritures.get(var2);
         if (this.ecritures.isSel_ecriture() && (!this.ecritures.isNbrEcrLettrage() && !this.forceVerrou || this.forceVerrou)) {
            double var3 = 0.0D;
            var3 = this.ecritures.getEcrCreditSaisie() * -1.0D;
            this.ecritures.setEcrCreditSaisie(var3);
            var3 = this.ecritures.getEcrCreditPays() * -1.0D;
            this.ecritures.setEcrCreditPays(var3);
            var3 = this.ecritures.getEcrCreditEuro() * -1.0D;
            this.ecritures.setEcrCreditEuro(var3);
            var3 = this.ecritures.getEcrCreditGrp() * -1.0D;
            this.ecritures.setEcrCreditGrp(var3);
            this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
            var1.flush();
         }
      }

   }

   public void outilChoisi3(Session var1) throws HibernateException, NamingException, java.text.ParseException {
      this.journauxActif = this.journauxComptablesDao.chercherCode(this.toolsCode, this.selectedExo.getExecpt_id(), var1);
      if (this.journauxActif != null) {
         this.lesEcrituresAReimputer.clear();
         new ArrayList();
         EcrituresAnalytiquesDao var3 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);

         for(int var4 = 0; var4 < this.lesEcritures.size(); ++var4) {
            this.ecritures = (Ecritures)this.lesEcritures.get(var4);
            if (this.ecritures.isSel_ecriture()) {
               this.ecritures.setEcrCode(this.toolsCode);
               String var5 = "" + (this.ecritures.getEcrDateSaisie().getYear() + 1900);
               String var6 = "";
               if (this.ecritures.getEcrDateSaisie().getMonth() + 1 <= 9) {
                  var6 = "0" + (this.ecritures.getEcrDateSaisie().getMonth() + 1);
               } else {
                  var6 = "" + (this.ecritures.getEcrDateSaisie().getMonth() + 1);
               }

               String var7 = "";
               if (this.ecritures.getEcrJour() <= 9) {
                  var7 = "0" + this.ecritures.getEcrJour();
               } else {
                  var7 = "" + this.ecritures.getEcrJour();
               }

               this.ecritures.setEcrCle1(this.ecritures.getEcrCode() + ":" + this.ecritures.getEcrPeriode());
               this.ecritures.setEcrCle2(this.ecritures.getEcrCode() + ":" + var5 + ":" + var6 + ":" + var7);
               this.ecritures.setEcrNatureJrx(this.journauxActif.getPljNature());
               this.ecritures.setEcrReserve(this.journauxActif.getPljReserve());
               if (this.testCompteAnalytique()) {
                  this.ecritures.setEcrAnaActif(1);
               } else {
                  this.ecritures.setEcrAnaActif(0);
               }

               this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
               List var2 = var3.chargerLesEcrituresAnalytiques(this.ecritures, var1);
               if (var2.size() != 0 && this.ecritures.getEcrAnaActif() == 1) {
                  new EcrituresAnalytique();

                  for(int var9 = 0; var9 < var2.size(); ++var9) {
                     EcrituresAnalytique var8 = (EcrituresAnalytique)var2.get(var9);
                     var8.setEcranaCode(this.ecritures.getEcrCode());
                     var8.setEcranaCle1(this.ecritures.getEcrCle1());
                     var8.setEcranaCle2(this.ecritures.getEcrCle2());
                     var8.setEcranaNatureJrx(this.journauxActif.getPljNature());
                     var8.setEcranaReserve(this.journauxActif.getPljReserve());
                     var3.modifEcritureAnalytiques(var1, var8);
                     var1.flush();
                  }
               }

               if (this.ecritures.getBrouillard() != null) {
                  this.ecritures.getBrouillard().setBroCode(this.ecritures.getEcrCode());
                  this.ecrituresDao.modifBrouillard(this.ecritures, var1);
                  var1.flush();
               }
            }
         }

         this.dataModelEcritureAReimputer.setWrappedData(this.lesEcrituresAReimputer);
      }

   }

   public void outilChoisi4(Session var1) throws HibernateException, NamingException, java.text.ParseException {
      new ArrayList();
      EcrituresAnalytiquesDao var3 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);

      for(int var4 = 0; var4 < this.lesEcritures.size(); ++var4) {
         this.ecritures = (Ecritures)this.lesEcritures.get(var4);
         if (this.ecritures.isSel_ecriture()) {
            Date var5 = this.utilDate.calculDateTrf(this.toolsPeriode, this.ecritures.getEcrJour());
            this.ecritures.setEcrDateSaisie(var5);
            this.ecritures.setEcrPeriode(this.toolsPeriode);
            this.ecritures.setEcrJour(this.ecritures.getEcrDateSaisie().getDate());
            String var6 = "" + (this.ecritures.getEcrDateSaisie().getYear() + 1900);
            String var7 = "";
            if (this.ecritures.getEcrDateSaisie().getMonth() + 1 <= 9) {
               var7 = "0" + (this.ecritures.getEcrDateSaisie().getMonth() + 1);
            } else {
               var7 = "" + (this.ecritures.getEcrDateSaisie().getMonth() + 1);
            }

            String var8 = "";
            if (this.ecritures.getEcrJour() <= 9) {
               var8 = "0" + this.ecritures.getEcrJour();
            } else {
               var8 = "" + this.ecritures.getEcrJour();
            }

            this.ecritures.setEcrCle1(this.ecritures.getEcrCode() + ":" + this.ecritures.getEcrPeriode());
            this.ecritures.setEcrCle2(this.ecritures.getEcrCode() + ":" + var6 + ":" + var7 + ":" + var8);
            this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
            var1.flush();
            List var2 = var3.chargerLesEcrituresAnalytiques(this.ecritures, var1);
            if (var2.size() != 0) {
               new EcrituresAnalytique();

               for(int var10 = 0; var10 < var2.size(); ++var10) {
                  new EcrituresAnalytique();
                  EcrituresAnalytique var9 = (EcrituresAnalytique)var2.get(var10);
                  var9.setEcranaDateSaisie(this.ecritures.getEcrDateSaisie());
                  var9.setEcranaPeriode(this.ecritures.getEcrPeriode());
                  var9.setEcranaCle1(this.ecritures.getEcrCle1());
                  var9.setEcranaCle2(this.ecritures.getEcrCle2());
                  var3.modifEcritureAnalytiques(var1, var9);
                  var1.flush();
               }
            }

            if (this.ecritures.getBrouillard() != null) {
               this.ecritures.getBrouillard().setBroDateSaisie(this.ecritures.getEcrDateSaisie());
               this.ecritures.getBrouillard().setBroPeriode(this.ecritures.getEcrPeriode());
               this.ecrituresDao.modifBrouillard(this.ecritures, var1);
               var1.flush();
            }
         }
      }

   }

   public void outilChoisi5(Session var1) throws HibernateException, NamingException {
      this.lesEcrituresAReimputer.clear();
      new ArrayList();
      EcrituresAnalytiquesDao var3 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);

      for(int var4 = 0; var4 < this.lesEcritures.size(); ++var4) {
         this.ecritures = (Ecritures)this.lesEcritures.get(var4);
         if (this.ecritures.isSel_ecriture() && (!this.ecritures.isNbrEcrLettrage() && !this.forceVerrou || this.forceVerrou) && this.ecritures.getEcrCompte().equals(this.toolsCompteOld)) {
            this.ecritures.setEcrCompte(this.planComptable.getPlcCompte());
            this.ecritures.setEcrClasse(this.planComptable.getPlcCompte().substring(0, 1));
            this.ecritures.setEcrNature(this.planComptable.getPlcNature());
            this.ecritures.setEcrLibCompte(this.planComptable.getPlcLibelleCpteFR());
            if (this.testCompteAnalytique()) {
               this.ecritures.setEcrAnaActif(1);
            } else {
               this.ecritures.setEcrAnaActif(0);
            }

            this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
            var1.flush();
            List var2 = var3.chargerLesEcrituresAnalytiques(this.ecritures, var1);
            EcrituresAnalytique var5;
            int var6;
            if (var2.size() != 0 && this.ecritures.getEcrAnaActif() == 1) {
               new EcrituresAnalytique();

               for(var6 = 0; var6 < var2.size(); ++var6) {
                  var5 = (EcrituresAnalytique)var2.get(var6);
                  var5.setEcranaCompte(this.ecritures.getEcrCompte());
                  var5.setEcranaClasse(this.ecritures.getEcrClasse());
                  var5.setEcranaNature(this.ecritures.getEcrNature());
                  var5.setEcranaLigneLib(this.ecritures.getEcrLibCompte());
                  var3.modifEcritureAnalytiques(var1, var5);
                  var1.flush();
               }
            } else if (var2.size() != 0 && this.ecritures.getEcrAnaActif() == 0) {
               new EcrituresAnalytique();

               for(var6 = 0; var6 < var2.size(); ++var6) {
                  var5 = (EcrituresAnalytique)var2.get(var6);
                  var3.nettoyageAnalytique(var5, var1);
                  var1.flush();
               }
            } else if (var2.size() == 0 && this.ecritures.getEcrAnaActif() == 1) {
               this.ecritures.setErreurAnalytique(true);
               this.lesEcrituresAReimputer.add(this.ecritures);
            }
         }
      }

      this.dataModelEcritureAReimputer.setWrappedData(this.lesEcrituresAReimputer);
   }

   public void outilChoisi17(Session var1) {
      String var2 = "";
      String var3 = "";
      String var4 = "";

      for(int var5 = 0; var5 < this.lesEcritures.size(); ++var5) {
         this.ecritures = (Ecritures)this.lesEcritures.get(var5);
         if (this.ecritures.isSel_ecriture() && (!this.ecritures.isNbrEcrLettrage() && !this.forceVerrou || this.forceVerrou) && this.ecritures.getEcrCompte().startsWith("5")) {
            var2 = this.ecritures.getEcrPiece();
            var3 = this.ecritures.getEcrCompte();
            new Ecritures();

            for(int var7 = 0; var7 < this.lesEcritures.size(); ++var7) {
               Ecritures var6 = (Ecritures)this.lesEcritures.get(var7);
               if (var6.isSel_ecriture() && !var6.getEcrCompte().startsWith("5") && var6.getEcrPiece().equals(var2)) {
                  var4 = var6.getEcrCompte();
                  break;
               }
            }

            this.ecritures.setEcrContrePartie(var4);
            this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
            var1.flush();
         }
      }

   }

   public void outilChoisi20(Session var1) throws HibernateException, NamingException, java.text.ParseException {
      new Ecritures();
      new ArrayList();
      EcrituresAnalytiquesDao var4 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);

      for(int var5 = 0; var5 < this.lesEcritures.size(); ++var5) {
         this.ecritures = (Ecritures)this.lesEcritures.get(var5);
         if (this.ecritures.isSel_ecriture()) {
            List var3 = var4.chargerLesEcrituresAnalytiques(this.ecritures, var1);
            Ecritures var2 = new Ecritures();
            var2.setEcrAnaActif(this.ecritures.getEcrAnaActif());
            var2.setEcrAnnee(this.ecritures.getEcrAnnee());
            var2.setEcrBudgetTreso(this.ecritures.getEcrBudgetTreso());
            var2.setEcrClasse(this.ecritures.getEcrClasse());
            var2.setEcrCloture(this.ecritures.getEcrCloture());
            var2.setEcrCode(this.ecritures.getEcrCode());
            var2.setEcrCoefEuro(this.ecritures.getEcrCoefEuro());
            var2.setEcrCoefGrp(this.ecritures.getEcrCoefGrp());
            var2.setEcrCoefPays(this.ecritures.getEcrCoefPays());
            var2.setEcrCompte(this.ecritures.getEcrCompte());
            var2.setEcrContrePartie(this.ecritures.getEcrContrePartie());
            var2.setEcrCreditEuro(this.ecritures.getEcrCreditEuro());
            var2.setEcrCreditGrp(this.ecritures.getEcrCreditGrp());
            var2.setEcrCreditSaisie(this.ecritures.getEcrCreditSaisie());
            var2.setEcrCreditPays(this.ecritures.getEcrCreditPays());
            var2.setEcrDateEcheance((Date)null);
            var2.setEcrDateModif((Date)null);
            var2.setEcrDatePaiement((Date)null);
            var2.setEcrDteRapprochement((Date)null);
            var2.setEcrDateValeurReelle((Date)null);
            var2.setEcrDateValeurTheo((Date)null);
            var2.setEcrDebitEuro(this.ecritures.getEcrDebitEuro());
            var2.setEcrDebitGrp(this.ecritures.getEcrDebitGrp());
            var2.setEcrDebitPays(this.ecritures.getEcrDebitPays());
            var2.setEcrDebitSaisie(this.ecritures.getEcrDebitSaisie());
            var2.setEcrDeviseGrp(this.ecritures.getEcrDeviseGrp());
            var2.setEcrDevisePays(this.ecritures.getEcrDevisePays());
            var2.setEcrDeviseSaisie(this.ecritures.getEcrDeviseSaisie());
            var2.setEcrEtat(this.ecritures.getEcrEtat());
            var2.setEcrIdOrigine(this.ecritures.getEcrIdOrigine());
            var2.setEcrLettrage("");
            var2.setEcrLibCompte(this.ecritures.getEcrLibCompte());
            var2.setEcrLibelle(this.ecritures.getEcrLibelle());
            var2.setEcrNature(this.ecritures.getEcrNature());
            var2.setEcrNatureJrx(this.ecritures.getEcrNatureJrx());
            var2.setEcrNumIf(this.ecritures.getEcrNumIf());
            var2.setEcrNumTrf(this.ecritures.getEcrNumTrf());
            var2.setEcrOrdre(this.ecritures.getEcrOrdre());
            var2.setEcrOrigineBanque(this.ecritures.getEcrOrigineBanque());
            var2.setEcrPiece(this.ecritures.getEcrPiece());
            var2.setEcrPointage("");
            var2.setEcrPosteTreso(this.ecritures.getEcrPosteTreso());
            var2.setEcrRapprochement("");
            var2.setEcrReference1(this.ecritures.getEcrReference1());
            var2.setEcrReference2(this.ecritures.getEcrReference2());
            var2.setEcrReserve(this.ecritures.getEcrReserve());
            var2.setEcrTreso(this.ecritures.getEcrTreso());
            var2.setEcrTypeOrigine(this.ecritures.getEcrTypeOrigine());
            var2.setEcrUserModif(0L);
            var2.setEcrDateCreat(new Date());
            var2.setEcrUserCreat(this.usersLog.getUsrid());
            Date var6 = this.utilDate.calculDateTrf(this.toolsPeriode, this.ecritures.getEcrJour());
            var2.setEcrDateSaisie(var6);
            var2.setEcrPeriode(this.toolsPeriode);
            var2.setEcrJour(var2.getEcrDateSaisie().getDate());
            String var7 = "" + (var2.getEcrDateSaisie().getYear() + 1900);
            String var8 = "";
            if (var2.getEcrDateSaisie().getMonth() + 1 <= 9) {
               var8 = "0" + (var2.getEcrDateSaisie().getMonth() + 1);
            } else {
               var8 = "" + (var2.getEcrDateSaisie().getMonth() + 1);
            }

            String var9 = "";
            if (var2.getEcrJour() <= 9) {
               var9 = "0" + var2.getEcrJour();
            } else {
               var9 = "" + var2.getEcrJour();
            }

            var2.setEcrCle1(var2.getEcrCode() + ":" + var2.getEcrPeriode());
            var2.setEcrCle2(var2.getEcrCode() + ":" + var7 + ":" + var8 + ":" + var9);
            var2.setBrouillard((Brouillard)null);
            var2.setExercicesComptable(this.ecritures.getExercicesComptable());
            var2 = this.ecrituresDao.insert(var2, var1);
            var1.flush();
            if (var3.size() != 0) {
               new EcrituresAnalytique();
               new EcrituresAnalytique();

               for(int var12 = 0; var12 < var3.size(); ++var12) {
                  EcrituresAnalytique var11 = (EcrituresAnalytique)var3.get(var12);
                  EcrituresAnalytique var10 = new EcrituresAnalytique();
                  var10.setEcranaActivite(var11.getEcranaActivite());
                  var10.setEcranaActiviteLib(var11.getEcranaActiviteLib());
                  var10.setEcranaAnal1(var11.getEcranaAnal1());
                  var10.setEcranaAnal1Lib(var11.getEcranaAnal1Lib());
                  var10.setEcranaAnal2(var11.getEcranaAnal2());
                  var10.setEcranaAnal2Lib(var11.getEcranaAnal2Lib());
                  var10.setEcranaAnal3(var11.getEcranaAnal3());
                  var10.setEcranaAnal3Lib(var11.getEcranaAnal3Lib());
                  var10.setEcranaAnal4(var11.getEcranaAnal4());
                  var10.setEcranaAnal4Lib(var11.getEcranaAnal4Lib());
                  var10.setEcranaAtelier(var11.getEcranaAtelier());
                  var10.setEcranaAtelierLib(var11.getEcranaAtelierLib());
                  var10.setEcranaAxe(var11.getEcranaAxe());
                  var10.setEcranaClasse(var11.getEcranaClasse());
                  var10.setEcranaCle(var11.getEcranaCle());
                  var10.setEcranaCode(var11.getEcranaCode());
                  var10.setEcranaCompte(var11.getEcranaCompte());
                  var10.setEcranaDepartement(var11.getEcranaDepartement());
                  var10.setEcranaDepartementLib(var11.getEcranaDepartementLib());
                  var10.setEcranaIdOrigine(var11.getEcranaId());
                  var10.setEcranaLibelle(var11.getEcranaLibelle());
                  var10.setEcranaLigne(var11.getEcranaLigne());
                  var10.setEcranaLigneLib(var11.getEcranaLigneLib());
                  var10.setEcranaMontantSaisie(var11.getEcranaMontantSaisie());
                  var10.setEcranaNature(var11.getEcranaNature());
                  var10.setEcranaNatureJrx(var11.getEcranaNatureJrx());
                  var10.setEcranaOrdre(var11.getEcranaOrdre());
                  var10.setEcranaPdv(var11.getEcranaPdv());
                  var10.setEcranaPdvLib(var11.getEcranaPdvLib());
                  var10.setEcranaPiece(var11.getEcranaPiece());
                  var10.setEcranaPourcentage(var11.getEcranaPourcentage());
                  var10.setEcranaReference1(var11.getEcranaReference1());
                  var10.setEcranaReference2(var11.getEcranaReference2());
                  var10.setEcranaRegion(var11.getEcranaRegion());
                  var10.setEcranaRegionLib(var11.getEcranaRegionLib());
                  var10.setEcranaSite(var11.getEcranaSite());
                  var10.setEcranaSiteLib(var11.getEcranaSiteLib());
                  var10.setEcranaSens(var11.getEcranaSens());
                  var10.setEcranaSecteur(var11.getEcranaSecteur());
                  var10.setEcranaSecteurLib(var11.getEcranaSecteurLib());
                  var10.setEcranaSite(var11.getEcranaSite());
                  var10.setEcranaSiteLib(var11.getEcranaSiteLib());
                  var10.setEcranaStr(var11.getEcranaStr());
                  var10.setEcranaStrLib(var11.getEcranaStrLib());
                  var10.setEcranaAgent(var11.getEcranaAgent());
                  var10.setEcranaAgentLib(var11.getEcranaAgentLib());
                  var10.setEcranaTypeOrigine(var11.getEcranaTypeOrigine());
                  var10.setEcranaDateSaisie(var2.getEcrDateSaisie());
                  var10.setEcranaCle1(var2.getEcrCle1());
                  var10.setEcranaCle2(var2.getEcrCle2());
                  var10.setEcritures(var2);
                  var4.inserEcritureAnalytiques(var1, var10);
                  var1.flush();
               }
            }

            if (this.ecritures.getBrouillard() != null) {
               Brouillard var13 = new Brouillard();
               var13.setBroAnnee(this.brouillard.getBroAnnee());
               var13.setBroCloture(this.brouillard.getBroCloture());
               var13.setBroCode(this.brouillard.getBroCode());
               var13.setBroCoefEuro(this.brouillard.getBroCoefEuro());
               var13.setBroCoefGrp(this.brouillard.getBroCoefGrp());
               var13.setBroCoefPays(this.brouillard.getBroCoefPays());
               var13.setBroCreditEuro(this.brouillard.getBroCreditEuro());
               var13.setBroCreditGrp(this.brouillard.getBroCreditGrp());
               var13.setBroCreditPays(this.brouillard.getBroCreditPays());
               var13.setBroCreditSaisie(this.brouillard.getBroCreditSaisie());
               var13.setBroDateModif((Date)null);
               var13.setBroDebitEuro(this.brouillard.getBroDebitEuro());
               var13.setBroDebitGrp(this.brouillard.getBroDebitGrp());
               var13.setBroDebitPays(this.brouillard.getBroDebitPays());
               var13.setBroDebitSaisie(this.brouillard.getBroDebitSaisie());
               var13.setBroDeviseGrp(this.brouillard.getBroDeviseGrp());
               var13.setBroDevisePays(this.brouillard.getBroDevisePays());
               var13.setBroDeviseSaisie(this.brouillard.getBroDeviseSaisie());
               var13.setBroEtat(this.brouillard.getBroEtat());
               var13.setBroIdOrigine(this.brouillard.getBroIdOrigine());
               var13.setBroLibelle(this.brouillard.getBroLibelle());
               var13.setBroNatureJrx(this.brouillard.getBroNatureJrx());
               var13.setBroNum(this.brouillard.getBroNum());
               var13.setBroNumTrf(this.brouillard.getBroNumTrf());
               var13.setBroPiece(this.brouillard.getBroPiece());
               var13.setBroReference1(this.brouillard.getBroReference1());
               var13.setBroReference2(this.brouillard.getBroReference2());
               var13.setBroTypeOrigine(this.brouillard.getBroTypeOrigine());
               var13.setBroUserModif(0L);
               var13.setBroDateCreat(new Date());
               var13.setBroUserCreat(this.usersLog.getUsrid());
               var13.setBroPeriode(var2.getEcrPeriode());
               var13.setBroDateSaisie(var2.getEcrDateSaisie());
               var13.setBroJour(var2.getEcrJour());
               var13.setExercicescomptable(var2.getExercicesComptable());
               var13 = this.brouillardDao.insert(var13, var1);
               var2.setBrouillard(var13);
               this.ecrituresDao.modifBrouillard(var2, var1);
               var1.flush();
            }
         }
      }

   }

   public void outilChoisi21(Session var1) throws HibernateException, NamingException {
      this.journauxActif = this.journauxComptablesDao.chercherCode(this.toolsCode, this.selectedExo.getExecpt_id(), var1);
      if (this.journauxActif != null) {
         new Ecritures();
         EcrituresAnalytiquesDao var3 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();

         for(int var5 = 0; var5 < this.lesEcritures.size(); ++var5) {
            this.ecritures = (Ecritures)this.lesEcritures.get(var5);
            if (this.ecritures.isSel_ecriture()) {
               List var4 = var3.chargerLesEcrituresAnalytiques(this.ecritures, var1);
               Ecritures var2 = new Ecritures();
               var2.setEcrAnaActif(this.ecritures.getEcrAnaActif());
               var2.setEcrAnnee(this.ecritures.getEcrAnnee());
               var2.setEcrBudgetTreso(this.ecritures.getEcrBudgetTreso());
               var2.setEcrClasse(this.ecritures.getEcrClasse());
               var2.setEcrCloture(this.ecritures.getEcrCloture());
               var2.setEcrCoefEuro(this.ecritures.getEcrCoefEuro());
               var2.setEcrCoefGrp(this.ecritures.getEcrCoefGrp());
               var2.setEcrCoefPays(this.ecritures.getEcrCoefPays());
               var2.setEcrCompte(this.ecritures.getEcrCompte());
               var2.setEcrContrePartie(this.ecritures.getEcrContrePartie());
               var2.setEcrCreditEuro(this.ecritures.getEcrCreditEuro());
               var2.setEcrCreditGrp(this.ecritures.getEcrCreditGrp());
               var2.setEcrCreditPays(this.ecritures.getEcrCreditPays());
               var2.setEcrCreditSaisie(this.ecritures.getEcrCreditSaisie());
               var2.setEcrDateEcheance((Date)null);
               var2.setEcrDateModif((Date)null);
               var2.setEcrDatePaiement((Date)null);
               var2.setEcrDteRapprochement((Date)null);
               var2.setEcrDateSaisie(this.ecritures.getEcrDateSaisie());
               var2.setEcrDateValeurReelle((Date)null);
               var2.setEcrDateValeurTheo((Date)null);
               var2.setEcrDebitEuro(this.ecritures.getEcrDebitEuro());
               var2.setEcrDebitGrp(this.ecritures.getEcrDebitGrp());
               var2.setEcrDebitPays(this.ecritures.getEcrDebitPays());
               var2.setEcrDebitSaisie(this.ecritures.getEcrDebitSaisie());
               var2.setEcrDeviseGrp(this.ecritures.getEcrDeviseGrp());
               var2.setEcrDevisePays(this.ecritures.getEcrDevisePays());
               var2.setEcrDeviseSaisie(this.ecritures.getEcrDeviseSaisie());
               var2.setEcrEtat(this.ecritures.getEcrEtat());
               var2.setEcrIdOrigine(this.ecritures.getEcrIdOrigine());
               var2.setEcrJour(this.ecritures.getEcrJour());
               var2.setEcrLettrage("");
               var2.setEcrLibCompte(this.ecritures.getEcrLibCompte());
               var2.setEcrLibelle(this.ecritures.getEcrLibelle());
               var2.setEcrNature(this.ecritures.getEcrNature());
               var2.setEcrNumIf(this.ecritures.getEcrNumIf());
               var2.setEcrNumTrf(this.ecritures.getEcrNumTrf());
               var2.setEcrOrdre(this.ecritures.getEcrOrdre());
               var2.setEcrOrigineBanque(this.ecritures.getEcrOrigineBanque());
               var2.setEcrPeriode(this.ecritures.getEcrPeriode());
               var2.setEcrPiece(this.ecritures.getEcrPiece());
               var2.setEcrPointage("");
               var2.setEcrPosteTreso(this.ecritures.getEcrPosteTreso());
               var2.setEcrRapprochement("");
               var2.setEcrReference1(this.ecritures.getEcrReference1());
               var2.setEcrReference2(this.ecritures.getEcrReference2());
               var2.setEcrTreso(this.ecritures.getEcrTreso());
               var2.setEcrTypeOrigine(this.ecritures.getEcrTypeOrigine());
               var2.setEcrUserModif(0L);
               var2.setEcrDateCreat(new Date());
               var2.setEcrUserCreat(this.usersLog.getUsrid());
               var2.setEcrCode(this.toolsCode);
               String var6 = "" + (this.ecritures.getEcrDateSaisie().getYear() + 1900);
               String var7 = "";
               if (var2.getEcrDateSaisie().getMonth() + 1 <= 9) {
                  var7 = "0" + (var2.getEcrDateSaisie().getMonth() + 1);
               } else {
                  var7 = "" + (var2.getEcrDateSaisie().getMonth() + 1);
               }

               String var8 = "";
               if (var2.getEcrJour() <= 9) {
                  var8 = "0" + var2.getEcrJour();
               } else {
                  var8 = "" + var2.getEcrJour();
               }

               var2.setEcrCle1(var2.getEcrCode() + ":" + var2.getEcrPeriode());
               var2.setEcrCle2(var2.getEcrCode() + ":" + var6 + ":" + var7 + ":" + var8);
               var2.setEcrNatureJrx(this.journauxActif.getPljNature());
               var2.setEcrReserve(this.journauxActif.getPljReserve());
               var2.setBrouillard((Brouillard)null);
               var2.setExercicesComptable(this.ecritures.getExercicesComptable());
               var2 = this.ecrituresDao.insert(var2, var1);
               var1.flush();
               if (var4.size() != 0) {
                  new EcrituresAnalytique();
                  new EcrituresAnalytique();

                  for(int var11 = 0; var11 < var4.size(); ++var11) {
                     EcrituresAnalytique var10 = (EcrituresAnalytique)var4.get(var11);
                     EcrituresAnalytique var9 = new EcrituresAnalytique();
                     var9.setEcranaActivite(var10.getEcranaActivite());
                     var9.setEcranaActiviteLib(var10.getEcranaActiviteLib());
                     var9.setEcranaAnal1(var10.getEcranaAnal1());
                     var9.setEcranaAnal1Lib(var10.getEcranaAnal1Lib());
                     var9.setEcranaAnal2(var10.getEcranaAnal2());
                     var9.setEcranaAnal2Lib(var10.getEcranaAnal2Lib());
                     var9.setEcranaAnal3(var10.getEcranaAnal3());
                     var9.setEcranaAnal3Lib(var10.getEcranaAnal3Lib());
                     var9.setEcranaAnal4(var10.getEcranaAnal4());
                     var9.setEcranaAnal4Lib(var10.getEcranaAnal4Lib());
                     var9.setEcranaAtelier(var10.getEcranaAtelier());
                     var9.setEcranaAtelierLib(var10.getEcranaAtelierLib());
                     var9.setEcranaAxe(var10.getEcranaAxe());
                     var9.setEcranaClasse(var10.getEcranaClasse());
                     var9.setEcranaCle(var10.getEcranaCle());
                     var9.setEcranaCompte(var10.getEcranaCompte());
                     var9.setEcranaDateSaisie(var10.getEcranaDateSaisie());
                     var9.setEcranaDepartement(var10.getEcranaDepartement());
                     var9.setEcranaDepartementLib(var10.getEcranaDepartementLib());
                     var9.setEcranaIdOrigine(var10.getEcranaId());
                     var9.setEcranaLibelle(var10.getEcranaLibelle());
                     var9.setEcranaLigne(var10.getEcranaLigne());
                     var9.setEcranaLigneLib(var10.getEcranaLigneLib());
                     var9.setEcranaMontantSaisie(var10.getEcranaMontantSaisie());
                     var9.setEcranaNature(var10.getEcranaNature());
                     var9.setEcranaOrdre(var10.getEcranaOrdre());
                     var9.setEcranaPdv(var10.getEcranaPdv());
                     var9.setEcranaPdvLib(var10.getEcranaPdvLib());
                     var9.setEcranaPeriode(var10.getEcranaPeriode());
                     var9.setEcranaPiece(var10.getEcranaPiece());
                     var9.setEcranaPourcentage(var10.getEcranaPourcentage());
                     var9.setEcranaReference1(var10.getEcranaReference1());
                     var9.setEcranaReference2(var10.getEcranaReference2());
                     var9.setEcranaRegion(var10.getEcranaRegion());
                     var9.setEcranaRegionLib(var10.getEcranaRegionLib());
                     var9.setEcranaSite(var10.getEcranaSite());
                     var9.setEcranaSiteLib(var10.getEcranaSiteLib());
                     var9.setEcranaSens(var10.getEcranaSens());
                     var9.setEcranaSecteur(var10.getEcranaSecteur());
                     var9.setEcranaSecteurLib(var10.getEcranaSecteurLib());
                     var9.setEcranaSite(var10.getEcranaSite());
                     var9.setEcranaSiteLib(var10.getEcranaSiteLib());
                     var9.setEcranaStr(var10.getEcranaStr());
                     var9.setEcranaStrLib(var10.getEcranaStrLib());
                     var9.setEcranaAgent(var10.getEcranaAgent());
                     var9.setEcranaAgentLib(var10.getEcranaAgentLib());
                     var9.setEcranaTypeOrigine(var10.getEcranaTypeOrigine());
                     var9.setEcranaCode(var2.getEcrCode());
                     var9.setEcranaNatureJrx(var2.getEcrNatureJrx());
                     var9.setEcranaCle1(var2.getEcrCle1());
                     var9.setEcranaCle2(var2.getEcrCle2());
                     var9.setEcritures(var2);
                     var3.inserEcritureAnalytiques(var1, var9);
                     var1.flush();
                  }
               }

               if (this.ecritures.getBrouillard() != null) {
                  Brouillard var12 = new Brouillard();
                  var12.setBroAnnee(this.brouillard.getBroAnnee());
                  var12.setBroCloture(this.brouillard.getBroCloture());
                  var12.setBroCoefEuro(this.brouillard.getBroCoefEuro());
                  var12.setBroCoefGrp(this.brouillard.getBroCoefGrp());
                  var12.setBroCoefPays(this.brouillard.getBroCoefPays());
                  var12.setBroCreditEuro(this.brouillard.getBroCreditEuro());
                  var12.setBroCreditGrp(this.brouillard.getBroCreditGrp());
                  var12.setBroCreditPays(this.brouillard.getBroCreditPays());
                  var12.setBroCreditSaisie(this.brouillard.getBroCreditSaisie());
                  var12.setBroDateModif((Date)null);
                  var12.setBroDateSaisie(this.brouillard.getBroDateSaisie());
                  var12.setBroDebitEuro(this.brouillard.getBroDebitEuro());
                  var12.setBroDebitGrp(this.brouillard.getBroDebitGrp());
                  var12.setBroDebitPays(this.brouillard.getBroDebitPays());
                  var12.setBroDebitSaisie(this.brouillard.getBroDebitSaisie());
                  var12.setBroDeviseGrp(this.brouillard.getBroDeviseGrp());
                  var12.setBroDevisePays(this.brouillard.getBroDevisePays());
                  var12.setBroDeviseSaisie(this.brouillard.getBroDeviseSaisie());
                  var12.setBroEtat(this.brouillard.getBroEtat());
                  var12.setBroIdOrigine(this.brouillard.getBroIdOrigine());
                  var12.setBroJour(this.brouillard.getBroJour());
                  var12.setBroLibelle(this.brouillard.getBroLibelle());
                  var12.setBroNum(this.brouillard.getBroNum());
                  var12.setBroNumTrf(this.brouillard.getBroNumTrf());
                  var12.setBroPiece(this.brouillard.getBroPiece());
                  var12.setBroPeriode(this.brouillard.getBroPeriode());
                  var12.setBroReference1(this.brouillard.getBroReference1());
                  var12.setBroReference2(this.brouillard.getBroReference2());
                  var12.setBroTypeOrigine(this.brouillard.getBroTypeOrigine());
                  var12.setBroUserModif(0L);
                  var12.setBroDateCreat(new Date());
                  var12.setBroUserCreat(this.usersLog.getUsrid());
                  var12.setBroCode(var2.getEcrCode());
                  var12.setBroNatureJrx(var2.getEcrNatureJrx());
                  var12.setExercicescomptable(var2.getExercicesComptable());
                  var12 = this.brouillardDao.insert(var12, var1);
                  var2.setBrouillard(var12);
                  this.ecrituresDao.modifBrouillard(var2, var1);
                  var1.flush();
               }
            }
         }
      }

   }

   public void outilChoisi22(Session var1) throws HibernateException, NamingException {
      if (this.lesEcritures.size() != 0) {
         ArrayList var2 = new ArrayList();

         for(int var3 = 0; var3 < this.lesEcritures.size(); ++var3) {
            this.ecritures = (Ecritures)this.lesEcritures.get(var3);
            if (this.ecritures.isSel_ecriture() && (this.ecritures.getEcrLettrage() == null || this.ecritures.getEcrLettrage().isEmpty()) && this.ecritures.getEcrPiece() != null && !this.ecritures.getEcrPiece().isEmpty()) {
               if (var2.size() == 0) {
                  var2.add(this.ecritures.getEcrPiece());
               } else {
                  boolean var4 = false;

                  for(int var5 = 0; var5 < var2.size(); ++var5) {
                     if (((String)var2.get(var5)).toString().equals(this.ecritures.getEcrPiece())) {
                        var4 = true;
                        break;
                     }
                  }

                  if (!var4) {
                     var2.add(this.ecritures.getEcrPiece());
                  }
               }
            }
         }

         LinkedList var28 = new LinkedList();
         LinkedList var29 = new LinkedList();
         LinkedList var30 = new LinkedList();
         Object var6 = new ArrayList();

         for(int var7 = 0; var7 < var2.size(); ++var7) {
            var28.clear();
            var29.clear();
            var30.clear();
            ((List)var6).clear();

            int var8;
            for(var8 = 0; var8 < this.lesEcritures.size(); ++var8) {
               this.ecritures = (Ecritures)this.lesEcritures.get(var8);
               if (this.ecritures.isSel_ecriture() && this.ecritures.getEcrPiece() != null && !this.ecritures.getEcrPiece().isEmpty() && this.ecritures.getEcrPiece().equals(((String)var2.get(var7)).toString())) {
                  var28.add(this.ecritures);
               }
            }

            if (var28.size() != 0) {
               for(var8 = 0; var8 < var28.size(); ++var8) {
                  this.ecritures = (Ecritures)var28.get(var8);
                  double var9 = this.ecritures.getEcrDebitSaisie();
                  double var11 = this.ecritures.getEcrCreditSaisie();
                  double var13 = this.ecritures.getEcrDebitPays();
                  double var15 = (double)this.ecritures.getEcrCoefPays();
                  double var17 = this.ecritures.getEcrDebitEuro();
                  double var19 = this.ecritures.getEcrCreditEuro();
                  double var21 = this.ecritures.getEcrDebitGrp();
                  double var23 = this.ecritures.getEcrCreditGrp();
                  if (var29.size() == 0) {
                     var29.add(this.ecritures);
                  } else {
                     boolean var25 = false;
                     Ecritures var26 = new Ecritures();

                     for(int var27 = 0; var27 < var29.size(); ++var27) {
                        var26 = (Ecritures)var29.get(var27);
                        if (var26.getEcrCompte().equals(this.ecritures.getEcrCompte())) {
                           var25 = true;
                           break;
                        }
                     }

                     if (!var25) {
                        var29.add(this.ecritures);
                     } else {
                        var26.setEcrDebitSaisie(var26.getEcrDebitSaisie() + var9);
                        var26.setEcrCreditSaisie(var26.getEcrCreditSaisie() + var11);
                        var26.setEcrDebitPays(var26.getEcrDebitPays() + var13);
                        var26.setEcrCreditPays(var26.getEcrCreditPays() + var15);
                        var26.setEcrDebitEuro(var26.getEcrDebitEuro() + var17);
                        var26.setEcrCreditEuro(var26.getEcrCreditEuro() + var19);
                        var26.setEcrDebitGrp(var26.getEcrDebitGrp() + var21);
                        var26.setEcrCreditGrp(var26.getEcrCreditGrp() + var23);
                        var30.add(this.ecritures);
                     }
                  }
               }
            }

            if (var29.size() != 0) {
               for(var8 = 0; var8 < var29.size(); ++var8) {
                  this.ecritures = (Ecritures)var29.get(var8);
                  this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
                  var1.flush();
               }
            }

            if (var30.size() != 0) {
               EcrituresAnalytiquesDao var32 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);

               for(int var31 = 0; var31 < var30.size(); ++var31) {
                  this.ecritures = (Ecritures)var30.get(var31);
                  this.ecritures = this.ecrituresDao.recupererSelectedECById(this.ecritures.getEcr_id(), var1);
                  if (this.ecritures != null) {
                     var6 = var32.chargerLesEcrituresAnalytiques(this.ecritures, var1);
                     if (((List)var6).size() != 0) {
                        new EcrituresAnalytique();

                        for(int var33 = 0; var33 < ((List)var6).size(); ++var33) {
                           EcrituresAnalytique var10 = (EcrituresAnalytique)((List)var6).get(var33);
                           var32.nettoyageAnalytique(var10, var1);
                        }

                        var1.flush();
                     }

                     this.ecrituresDao.removeSelectedEC0(this.ecritures, 1, var1);
                  }
               }
            }

            var1.flush();
         }
      }

   }

   public void fermerCorrection() {
      this.var_action = 1;
      this.var_memo_action = this.var_action;
   }

   public void selectionLigneCorrection() {
      if (this.dataModelEcritureAReimputer.isRowAvailable()) {
         this.ecritures = (Ecritures)this.dataModelEcritureAReimputer.getRowData();
         this.var_memo_ligne_gene = this.ecritures.getEcr_id();
      }

   }

   public void saisieImputation() throws HibernateException, NamingException {
      if (this.ecritures == null) {
         this.selectionLigneCorrection();
      }

      if (this.ecritures != null && this.optionComptabilite.getAnalytique().equals("true") && this.ecritures.getEcrEtat() == 0 && (this.optionComptabilite.getSaisieAnalytique().equals("0") || this.optionComptabilite.getSaisieAnalytique().equals("1"))) {
         boolean var1 = this.testCompteAnalytique();
         boolean var2 = this.testCompteBudget();
         if (var1 || var2) {
            Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
            this.ecritures.setEcrAnaActif(1);
            if (this.formAnalytique == null) {
               this.formAnalytique = new FormAnalytique(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
            }

            this.formAnalytique.initAnalytique(this.optionComptabilite, var3);
            this.formAnalytique.chargementDetailAnalytique(this.ecritures, false, var3);
            this.showModalPanelAnalytiqueCorrection = true;
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void chargerAnalytiqueErreur() throws HibernateException, NamingException {
      this.lesEcritures.clear();
      this.datamodelEcritures = new ListDataModel();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      new ArrayList();
      ArrayList var3 = new ArrayList();
      EcrituresAnalytiquesDao var4 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      List var2 = this.ecrituresDao.ChargerLesEcritures(this.journauxMois.getJoumenCle1(), 1, this.selectedExo.getExecpt_id(), var1);
      if (var2.size() != 0) {
         boolean var5 = false;

         for(int var6 = 0; var6 < var2.size(); ++var6) {
            this.ecritures = (Ecritures)var2.get(var6);
            int var11 = 0;
            if (this.testCompteAnalytique()) {
               var11 = 1;
            }

            if (this.testCompteBudget()) {
               ++var11;
            }

            if (var11 != 0) {
               var3.add(this.ecritures);
            }
         }

         Object var12 = new ArrayList();

         for(int var7 = 0; var7 < var3.size(); ++var7) {
            this.ecritures = (Ecritures)var3.get(var7);
            if (this.optionComptabilite.getAnalytique().equals("true") && this.ecritures.getEcrAnaActif() == 1) {
               ((List)var12).clear();
               var12 = var4.chargerLesEcrituresAnalytiques(this.ecritures, var1);
               if (((List)var12).size() == 0) {
                  this.ecritures.setErreurAnalytique(true);
                  this.lesEcritures.add(this.ecritures);
               } else {
                  double var8 = 0.0D;

                  for(int var10 = 0; var10 < ((List)var12).size(); ++var10) {
                     var8 += ((EcrituresAnalytique)((List)var12).get(var10)).getEcranaMontantSaisie();
                  }

                  if (var8 != this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) {
                     this.ecritures.setErreurAnalytique(true);
                     this.lesEcritures.add(this.ecritures);
                  } else {
                     this.ecritures.setErreurAnalytique(false);
                  }
               }
            }
         }
      }

      this.datamodelEcritures.setWrappedData(this.lesEcritures);
      this.utilInitHibernate.closeSession();
      this.calcultotaux();
   }

   public void selectionImputationSaisie() throws HibernateException, NamingException, java.text.ParseException {
      if (this.dataModelMois.isRowAvailable()) {
         this.journauxMois = (JournauxMois)this.dataModelMois.getRowData();
         this.journauxMois = this.journauxMoisDao.recupererJournauxMois(this.journauxMois.getJoumenCle1(), this.selectedExo, (Session)null);
         if (this.journauxMois.getJoumenUserIdJournal() != 0L && this.journauxMois.getJoumenUserIdJournal() != this.usersLog.getUsrid()) {
            this.afficheTJM = false;
            StaticModePegase.setTexte_message("Ce journal est déjà ouvert avec un autre utilisateur...");
            StaticModePegase.setAffiche_message(true);
         } else {
            this.ouvrirLeJournalImputation();
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
            Transaction var2 = null;

            try {
               var2 = var1.beginTransaction();
               this.var_periode = this.journauxMois.getJoumenPeriode();
               this.debitAnterieur = 0.0D;
               this.creditAnterieur = 0.0D;
               this.cpTreso = "";
               this.var_hauteur = "height:110px";
               this.ChargerLesEcrituresImputation(var1);
               this.calculLesJourDunMois();
               if (!this.optionComptabilite.getTrf_brl().equalsIgnoreCase("1") && this.journauxMois.getJoumenEtat() == 0 && this.journauxActif.getPljSasieInterdite() != 1) {
                  if (this.selectedExo.getExecpt_id() != this.lastExo.getExecpt_id()) {
                     this.var_action = 3;
                  } else {
                     this.var_action = 1;
                  }
               } else {
                  this.var_action = 3;
               }

               this.var_memo_action = this.var_action;
               this.verifExitChrono(var1);
               var2.commit();
            } catch (HibernateException var7) {
               if (var2 != null) {
                  var2.rollback();
               }

               throw var7;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            this.ajouterLigne();
         }
      }

   }

   public void ouvrirLeJournalImputation() throws HibernateException, NamingException {
      if (this.journauxMois != null && !this.modeConsultation) {
         this.journauxMois.setJoumenOpenJournal(1);
         if (this.usersLog.getUsrPatronyme() != null && !this.usersLog.getUsrPatronyme().isEmpty()) {
            this.journauxMois.setJoumenOpenUserJournal(this.usersLog.getUsrPatronyme());
         } else {
            this.journauxMois.setJoumenOpenUserJournal(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         }

         this.journauxMois.setJoumenUserIdJournal(this.usersLog.getUsrid());
         this.journauxMois = this.journauxMoisDao.majJournal(this.journauxMois);
      }

   }

   public void ChargerLesEcrituresImputation(Session var1) throws HibernateException, NamingException {
      if (this.lesEcritures == null) {
         this.lesEcritures = new LinkedList();
      }

      this.lesEcritures.clear();
      this.datamodelEcritures = new ListDataModel();
      if (this.journauxActif != null) {
         this.var_periode = this.journauxMois.getJoumenPeriode();
         this.var_format_devise = this.journauxActif.getPljFormatDevise();
         this.var_jr_nature = this.journauxActif.getPljNature();
         Object var2 = new ArrayList();
         new ArrayList();
         EcrituresAnalytiquesDao var4 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         List var3 = this.ecrituresDao.ChargerLesEcritures(this.journauxMois.getJoumenCle1(), 1, this.selectedExo.getExecpt_id(), var1);
         if (var3.size() != 0) {
            boolean var5 = false;

            for(int var6 = 0; var6 < var3.size(); ++var6) {
               this.ecritures = (Ecritures)var3.get(var6);
               int var10 = 0;
               if (this.testCompteAnalytique()) {
                  var10 = 1;
               }

               if (this.testCompteBudget()) {
                  ++var10;
               }

               if (var10 != 0) {
                  if (this.optionComptabilite.getAnalytiqueErreur().equals("1")) {
                     ((List)var2).clear();
                     var2 = var4.chargerLesEcrituresAnalytiques(this.ecritures, var1);
                     if (((List)var2).size() != 0) {
                        double var7 = 0.0D;

                        for(int var9 = 0; var9 < ((List)var2).size(); ++var9) {
                           var7 += ((EcrituresAnalytique)((List)var2).get(var9)).getEcranaMontantSaisie();
                        }

                        if (var7 != this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) {
                           if (var7 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 2.0D) {
                              if (var7 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 3.0D) {
                                 if (var7 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 4.0D) {
                                    if (var7 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 5.0D) {
                                       if (var7 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 6.0D) {
                                          if (var7 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 7.0D) {
                                             if (var7 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 8.0D) {
                                                if (var7 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 9.0D) {
                                                   if (var7 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 10.0D) {
                                                      this.ecritures.setErreurAnalytique(true);
                                                   } else {
                                                      this.ecritures.setErreurAnalytique(false);
                                                   }
                                                } else {
                                                   this.ecritures.setErreurAnalytique(false);
                                                }
                                             } else {
                                                this.ecritures.setErreurAnalytique(false);
                                             }
                                          } else {
                                             this.ecritures.setErreurAnalytique(false);
                                          }
                                       } else {
                                          this.ecritures.setErreurAnalytique(false);
                                       }
                                    } else {
                                       this.ecritures.setErreurAnalytique(false);
                                    }
                                 } else {
                                    this.ecritures.setErreurAnalytique(false);
                                 }
                              } else {
                                 this.ecritures.setErreurAnalytique(false);
                              }
                           } else {
                              this.ecritures.setErreurAnalytique(false);
                           }
                        } else {
                           this.ecritures.setErreurAnalytique(false);
                        }
                     } else {
                        this.ecritures.setErreurAnalytique(true);
                     }
                  }

                  this.lesEcritures.add(this.ecritures);
               }
            }
         }

         this.datamodelEcritures.setWrappedData(this.lesEcritures);
         this.calcultotaux();
      }

   }

   public void fermerLeJournalImputation() throws NamingException, JDOMException, IOException, java.text.ParseException {
      if (this.journauxMois != null && !this.modeConsultation) {
         this.journauxMois.setJoumenOpenUserJournal("");
         this.journauxMois.setJoumenOpenJournal(0);
         this.journauxMois.setJoumenUserIdJournal(0L);
         if (this.lesEcritures != null) {
            this.journauxMois.setJoumenSaisie(1);
         } else {
            this.journauxMois.setJoumenSaisie(0);
         }

         this.journauxMois = this.journauxMoisDao.majJournal(this.journauxMois);
         if (this.journauxActif.getPljNature() == 7 || this.journauxActif.getPljNature() == 9) {
            this.cloturerMvtDuMois();
         }
      }

      if (this.var_acces_direct) {
         this.afficheTJM = true;
         this.var_action = 0;
         this.var_memo_action = this.var_action;
      }

   }

   public void saveEcritureImputation() throws NamingException, JDOMException, IOException, java.text.ParseException {
      if (this.planComptable != null && this.ecritures.getEcrCompte() != null && this.ecritures.getEcrLibelle() != null && !this.ecritures.getEcrLibelle().isEmpty() && (this.ecritures.getEcrDebitSaisie() != 0.0D || this.ecritures.getEcrCreditSaisie() != 0.0D)) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.ecritures.getEcrDebitSaisie() != 0.0D && this.ecritures.getEcrCreditSaisie() != 0.0D) {
               if (this.soldeDeb != 0.0D) {
                  this.ecritures.setEcrDebitSaisie(0.0D);
               } else {
                  this.ecritures.setEcrCreditSaisie(0.0D);
               }
            }

            if ((this.ecritures.getEcrContrePartie() == null || this.ecritures.getEcrContrePartie().isEmpty()) && this.ecritures.getEcrCompte().startsWith("5")) {
               this.ecritures.setEcrContrePartie(this.memoCompte);
            }

            this.ecritures.setExercicesComptable(this.selectedExo);
            this.ecritures.setBrouillard((Brouillard)null);
            this.ecritures.setEcrDateSaisie(this.calculdateSasisie());
            this.ecritures.setEcrPeriode(this.var_periode);
            this.ecritures.setEcrCode(this.journauxActif.getPljCode());
            this.ecritures.setEcrNatureJrx(this.journauxActif.getPljNature());
            this.ecritures.setEcrReserve(this.journauxActif.getPljReserve());
            String var3 = "" + (this.ecritures.getEcrDateSaisie().getYear() + 1900);
            String var4 = "";
            if (this.ecritures.getEcrDateSaisie().getMonth() + 1 <= 9) {
               var4 = "0" + (this.ecritures.getEcrDateSaisie().getMonth() + 1);
            } else {
               var4 = "" + (this.ecritures.getEcrDateSaisie().getMonth() + 1);
            }

            String var5 = "";
            if (this.ecritures.getEcrJour() <= 9) {
               var5 = "0" + this.ecritures.getEcrJour();
            } else {
               var5 = "" + this.ecritures.getEcrJour();
            }

            this.ecritures.setEcrAnnee(var3);
            this.ecritures.setEcrEtat(0);
            this.ecritures.setEcrNature(this.planComptable.getPlcNature());
            this.ecritures.setEcrCle1(this.ecritures.getEcrCode() + ":" + this.ecritures.getEcrPeriode());
            this.ecritures.setEcrCle2(this.ecritures.getEcrCode() + ":" + var3 + ":" + var4 + ":" + var5);
            this.ecritures.setEcrOrdre(0L);
            if (this.journauxActif.getPljTypeDevise() == 0) {
               this.ecritures.setEcrDeviseSaisie(this.structureLog.getStrdevise());
            } else if (this.journauxActif.getPljTypeDevise() == 1) {
               this.ecritures.setEcrDeviseSaisie(this.journauxActif.getPljChoixDevise());
            } else if (this.journauxActif.getPljTypeDevise() == 2) {
            }

            this.ecritures.setEcrCoefEuro(this.utilNombre.deviseTaux1(this.ecritures.getEcrDeviseSaisie(), this.ecritures.getEcrDateSaisie()));
            this.ecritures.setEcrDebitEuro(this.utilNombre.myRoundFormat(this.ecritures.getEcrDebitSaisie() * (double)this.ecritures.getEcrCoefEuro(), 1));
            this.ecritures.setEcrCreditEuro(this.utilNombre.myRoundFormat(this.ecritures.getEcrCreditSaisie() * (double)this.ecritures.getEcrCoefEuro(), 1));
            this.ecritures.setEcrDevisePays(this.structureLog.getStrdevise());
            if (this.ecritures.getEcrDevisePays().equalsIgnoreCase(this.ecritures.getEcrDeviseSaisie())) {
               this.ecritures.setEcrCoefPays(1.0F);
               this.ecritures.setEcrDebitPays(this.ecritures.getEcrDebitSaisie());
               this.ecritures.setEcrCreditPays(this.ecritures.getEcrCreditSaisie());
            } else {
               this.ecritures.setEcrCoefPays(this.utilNombre.deviseTaux2(this.ecritures.getEcrDevisePays(), this.ecritures.getEcrDateSaisie()));
               this.ecritures.setEcrDebitPays(this.utilNombre.myRoundDevise(this.ecritures.getEcrDebitSaisie() * (double)this.ecritures.getEcrCoefPays(), this.ecritures.getEcrDevisePays()));
               this.ecritures.setEcrCreditPays(this.utilNombre.myRoundDevise(this.ecritures.getEcrCreditSaisie() * (double)this.ecritures.getEcrCoefPays(), this.ecritures.getEcrDevisePays()));
            }

            this.ecritures.setEcrDeviseGrp(this.structureLog.getStrdevise());
            this.ecritures.setEcrCoefGrp(1.0F);
            this.ecritures.setEcrDebitGrp(this.ecritures.getEcrDebitSaisie());
            this.ecritures.setEcrCreditGrp(this.ecritures.getEcrCreditSaisie());
            if (this.ecritures.getEcr_id() == 0L) {
               this.var_modif = false;
               this.ecritures.setEcrDateCreat(new Date());
               this.ecritures.setEcrUserCreat(this.usersLog.getUsrid());
               if (this.verrouNum && (this.ecritures.getEcrPiece() == null || this.ecritures.getEcrPiece().isEmpty())) {
                  this.ecritures.setEcrPiece(this.numComposeJournal(var1));
               }

               this.ecritures = this.ecrituresDao.insert(this.ecritures, var1);
               if (this.lesEcritures == null) {
                  this.lesEcritures = new LinkedList();
                  this.datamodelEcritures = new ListDataModel();
               }

               this.lesEcritures.add(this.ecritures);
               this.datamodelEcritures.setWrappedData(this.lesEcritures);
            } else {
               this.var_modif = true;
               this.ecritures.setEcrDateModif(new Date());
               this.ecritures.setEcrUserModif(this.usersLog.getUsrid());
               this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
            }

            this.calcultotaux();
            var2.commit();
         } catch (HibernateException var9) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         this.var_memo_ligne_gene = 0L;
         if (this.optionComptabilite.getAnalytique().equals("true") && this.ecritures.getEcrEtat() == 0 && (this.optionComptabilite.getSaisieAnalytique().equals("0") || this.optionComptabilite.getSaisieAnalytique().equals("2"))) {
            boolean var11 = this.testCompteAnalytique();
            boolean var12 = this.testCompteBudget();
            if (!var11 && !var12) {
               if (!var11 && !var12) {
                  this.var_memo_ligne_gene = this.ecritures.getEcr_id();
                  this.formAnalytique.nettoyageDetailAnalytique(this.ecritures, var1);
                  if (this.ecritures.getEcrAnaActif() == 1) {
                     this.ecritures.setEcrAnaActif(0);
                     this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
                  }
               }
            } else {
               this.ecritures.setEcrAnaActif(1);
               this.var_memo_ligne_gene = this.ecritures.getEcr_id();
               this.formAnalytique.initAnalytique(this.optionComptabilite, var1);
               this.formAnalytique.chargementDetailAnalytique(this.ecritures, false, var1);
               this.showModalPanelAnalytique = true;
            }
         }

         this.utilInitHibernate.closeSession();
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

   public void chargerLesModelesImpresion() {
      this.modeImp = 0;
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_gene" + File.separator + "journal_mensuel";
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);
         this.lesModelsimpression = new ArrayList();

         for(int var4 = 0; var4 < var3.length; ++var4) {
            String var5 = var3[var4];
            if (var5.endsWith("jasper")) {
               String var6 = var3[var4];
               if (this.verificationAutorisation(var6)) {
                  int var7 = var5.indexOf(".");
                  var5 = var5.substring(0, var7);
                  this.lesModelsimpression.add(new SelectItem(var5));
               }
            }
         }
      }

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

   public void impression(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10) throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      this.calcultotaux();
      if (var4 != null && !var4.isEmpty()) {
         if (var1 == null) {
            var1 = new UtilPrint(this.utilInitHibernate);
         }

         var1.setRapport(var4);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_gene" + File.separator + "journal_mensuel" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
         var1.setEntete("Impression Journal (Mois)");
         var1.setFiltre(this.journauxActif.getPljCode() + "/" + this.journauxMois.getJoumenPeriode());
         String var11 = this.journauxMois.getJoumenCle1();
         String var12 = "ecr_cle1='" + var11 + "' and ecr_etat<=1";
         if (this.modeImp == 1) {
            var12 = var12 + " and ecr_piece='" + this.ecritures.getEcrPiece() + "'";
         } else if (this.modeImp == 2) {
            var12 = var12 + " and ecr_reference1='" + this.ecritures.getEcrReference1() + "'";
         } else if (this.modeImp == 3) {
            var12 = var12 + " and ecr_reference2='" + this.ecritures.getEcrReference2() + "'";
         }

         var1.setRequete(var12);
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataireCC(var8);
         var1.setDestinataireCCI(var9);
         var1.setCorpsMail(var10);
         var1.setTiersSelectionne((Tiers)null);
         if (this.journauxActif.getPljNature() >= 7 && this.journauxActif.getPljNature() <= 10) {
            var1.setEtat_init(1);
         } else {
            var1.setEtat_init(0);
         }

         var1.setPlafond(this.soldefinalDeb - this.soldefinalCred);
         ArrayList var13 = new ArrayList();
         JRBeanCollectionDataSource var14 = new JRBeanCollectionDataSource(var13);
         var1.setjRBeanCollectionDataSource(var14);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public boolean isTestfermerleJournal() {
      return this.testfermerleJournal;
   }

   public void setTestfermerleJournal(boolean var1) {
      this.testfermerleJournal = var1;
   }

   public double getSoldefinalCred() {
      return this.soldefinalCred;
   }

   public void setSoldefinalCred(double var1) {
      this.soldefinalCred = var1;
   }

   public double getSoldefinalDeb() {
      return this.soldefinalDeb;
   }

   public void setSoldefinalDeb(double var1) {
      this.soldefinalDeb = var1;
   }

   public boolean isTestAffOutilsCorr() {
      return this.testAffOutilsCorr;
   }

   public void setTestAffOutilsCorr(boolean var1) {
      this.testAffOutilsCorr = var1;
   }

   public List getLesModelsimpression() {
      return this.lesModelsimpression;
   }

   public void setLesModelsimpression(List var1) {
      this.lesModelsimpression = var1;
   }

   public boolean isVerrouNum() {
      return this.verrouNum;
   }

   public void setVerrouNum(boolean var1) {
      this.verrouNum = var1;
   }

   public int getValindexC() {
      return this.valindexC;
   }

   public void setValindexC(int var1) {
      this.valindexC = var1;
   }

   public int getValindexD() {
      return this.valindexD;
   }

   public void setValindexD(int var1) {
      this.valindexD = var1;
   }

   public boolean isPieceVide() {
      return this.pieceVide;
   }

   public void setPieceVide(boolean var1) {
      this.pieceVide = var1;
   }

   public List getLesjoursItems() {
      return this.lesjoursItems;
   }

   public void setLesjoursItems(List var1) {
      this.lesjoursItems = var1;
   }

   public JournauxComptables getJournauxActif() {
      return this.journauxActif;
   }

   public void setJournauxActif(JournauxComptables var1) {
      this.journauxActif = var1;
   }

   public JournauxMois getJournauxMois() {
      return this.journauxMois;
   }

   public void setJournauxMois(JournauxMois var1) {
      this.journauxMois = var1;
   }

   public boolean isAfficheTJM() {
      return this.afficheTJM;
   }

   public void setAfficheTJM(boolean var1) {
      this.afficheTJM = var1;
   }

   public double getSoldeCred() {
      return this.soldeCred;
   }

   public void setSoldeCred(double var1) {
      this.soldeCred = var1;
   }

   public double getSoldeDeb() {
      return this.soldeDeb;
   }

   public void setSoldeDeb(double var1) {
      this.soldeDeb = var1;
   }

   public int getModeSupp() {
      return this.modeSupp;
   }

   public void setModeSupp(int var1) {
      this.modeSupp = var1;
   }

   public int getModeImp() {
      return this.modeImp;
   }

   public void setModeImp(int var1) {
      this.modeImp = var1;
   }

   public double getCreditAnterieur() {
      return this.creditAnterieur;
   }

   public void setCreditAnterieur(double var1) {
      this.creditAnterieur = var1;
   }

   public double getDebitAnterieur() {
      return this.debitAnterieur;
   }

   public void setDebitAnterieur(double var1) {
      this.debitAnterieur = var1;
   }

   public double getSoldeAnterieur() {
      return this.soldeAnterieur;
   }

   public void setSoldeAnterieur(double var1) {
      this.soldeAnterieur = var1;
   }

   public DataModel getDataModelMois() {
      return this.dataModelMois;
   }

   public void setDataModelMois(DataModel var1) {
      this.dataModelMois = var1;
   }

   public DataModel getDatamodelJournaux() {
      return this.datamodelJournaux;
   }

   public void setDatamodelJournaux(DataModel var1) {
      this.datamodelJournaux = var1;
   }

   public double getTotalMvtscredit() {
      return this.totalMvtscredit;
   }

   public void setTotalMvtscredit(double var1) {
      this.totalMvtscredit = var1;
   }

   public double getTotalMvtsdebit() {
      return this.totalMvtsdebit;
   }

   public void setTotalMvtsdebit(double var1) {
      this.totalMvtsdebit = var1;
   }

   public boolean isTestAffSuppImpList() {
      return this.testAffSuppImpList;
   }

   public void setTestAffSuppImpList(boolean var1) {
      this.testAffSuppImpList = var1;
   }

   public String getDevise() {
      return this.journauxActif.getPljChoixDevise();
   }

   public int getVar_format_devise() {
      return this.var_format_devise;
   }

   public void setVar_format_devise(int var1) {
      this.var_format_devise = var1;
   }

   public ExercicesComptable getLastExo() {
      return this.lastExo;
   }

   public void setLastExo(ExercicesComptable var1) {
      this.lastExo = var1;
   }

   public OptionComptabilite getOptionComptabilite() {
      return this.optionComptabilite;
   }

   public void setOptionComptabilite(OptionComptabilite var1) {
      this.optionComptabilite = var1;
   }

   public ExercicesComptable getSelectedExo() {
      return this.selectedExo;
   }

   public void setSelectedExo(ExercicesComptable var1) {
      this.selectedExo = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public DataModel getDatamodelEcritures() {
      return this.datamodelEcritures;
   }

   public void setDatamodelEcritures(DataModel var1) {
      this.datamodelEcritures = var1;
   }

   public Ecritures getEcritures() {
      return this.ecritures;
   }

   public void setEcritures(Ecritures var1) {
      this.ecritures = var1;
   }

   public String getCpTreso() {
      return this.cpTreso;
   }

   public void setCpTreso(String var1) {
      this.cpTreso = var1;
   }

   public Brouillard getBrouillard() {
      return this.brouillard;
   }

   public void setBrouillard(Brouillard var1) {
      this.brouillard = var1;
   }

   public boolean isShowModalPanelBrouillard() {
      return this.showModalPanelBrouillard;
   }

   public void setShowModalPanelBrouillard(boolean var1) {
      this.showModalPanelBrouillard = var1;
   }

   public boolean isTestAffBrouillard() {
      return this.testAffBrouillard;
   }

   public void setTestAffBrouillard(boolean var1) {
      this.testAffBrouillard = var1;
   }

   public String getUserBrouillard() {
      return this.userBrouillard;
   }

   public void setUserBrouillard(String var1) {
      this.userBrouillard = var1;
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

   public boolean isLigneSel() {
      return this.ligneSel;
   }

   public void setLigneSel(boolean var1) {
      this.ligneSel = var1;
   }

   public boolean isSansChrono() {
      return this.sansChrono;
   }

   public void setSansChrono(boolean var1) {
      this.sansChrono = var1;
   }

   public boolean isShowModalPanelLpr() {
      return this.showModalPanelLpr;
   }

   public void setShowModalPanelLpr(boolean var1) {
      this.showModalPanelLpr = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public boolean isShowModalPanelAnalytique() {
      return this.showModalPanelAnalytique;
   }

   public void setShowModalPanelAnalytique(boolean var1) {
      this.showModalPanelAnalytique = var1;
   }

   public String getVar_hauteur() {
      return this.var_hauteur;
   }

   public void setVar_hauteur(String var1) {
      this.var_hauteur = var1;
   }

   public boolean isVar_affiche_analytique() {
      return this.var_affiche_analytique;
   }

   public void setVar_affiche_analytique(boolean var1) {
      this.var_affiche_analytique = var1;
   }

   public PlanComptable getPlanComptable() {
      return this.planComptable;
   }

   public void setPlanComptable(PlanComptable var1) {
      this.planComptable = var1;
   }

   public boolean isShowModalPanelValidation() {
      return this.showModalPanelValidation;
   }

   public void setShowModalPanelValidation(boolean var1) {
      this.showModalPanelValidation = var1;
   }

   public int getVar_jourDebut() {
      return this.var_jourDebut;
   }

   public void setVar_jourDebut(int var1) {
      this.var_jourDebut = var1;
   }

   public int getVar_jourFin() {
      return this.var_jourFin;
   }

   public void setVar_jourFin(int var1) {
      this.var_jourFin = var1;
   }

   public int getVar_choix_validation() {
      return this.var_choix_validation;
   }

   public void setVar_choix_validation(int var1) {
      this.var_choix_validation = var1;
   }

   public List getLesPiecesSelectionnes() {
      return this.lesPiecesSelectionnes;
   }

   public void setLesPiecesSelectionnes(List var1) {
      this.lesPiecesSelectionnes = var1;
   }

   public List getLesPeriodes() {
      return this.lesPeriodes;
   }

   public void setLesPeriodes(List var1) {
      this.lesPeriodes = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public boolean isExisteCopteDeja() {
      return this.existeCopteDeja;
   }

   public void setExisteCopteDeja(boolean var1) {
      this.existeCopteDeja = var1;
   }

   public String getMaNature() {
      return this.maNature;
   }

   public void setMaNature(String var1) {
      this.maNature = var1;
   }

   public String getMaRacine() {
      return this.maRacine;
   }

   public void setMaRacine(String var1) {
      this.maRacine = var1;
   }

   public List getMesNatureCompteItem() {
      return this.mesNatureCompteItem;
   }

   public void setMesNatureCompteItem(List var1) {
      this.mesNatureCompteItem = var1;
   }

   public List getMesRacineCompteItem() {
      return this.mesRacineCompteItem;
   }

   public void setMesRacineCompteItem(List var1) {
      this.mesRacineCompteItem = var1;
   }

   public String getPartieCompte() {
      return this.partieCompte;
   }

   public void setPartieCompte(String var1) {
      this.partieCompte = var1;
   }

   public String getRacinecle() {
      return this.racinecle;
   }

   public void setRacinecle(String var1) {
      this.racinecle = var1;
   }

   public boolean isShowModalPanelCreationCompte() {
      return this.showModalPanelCreationCompte;
   }

   public void setShowModalPanelCreationCompte(boolean var1) {
      this.showModalPanelCreationCompte = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
   }

   public boolean isShowModalPanelPiece() {
      return this.showModalPanelPiece;
   }

   public void setShowModalPanelPiece(boolean var1) {
      this.showModalPanelPiece = var1;
   }

   public String getVar_ancien_numero() {
      return this.var_ancien_numero;
   }

   public void setVar_ancien_numero(String var1) {
      this.var_ancien_numero = var1;
   }

   public String getVar_nouveau_numero() {
      return this.var_nouveau_numero;
   }

   public void setVar_nouveau_numero(String var1) {
      this.var_nouveau_numero = var1;
   }

   public int getNbcarmax() {
      return this.nbcarmax;
   }

   public void setNbcarmax(int var1) {
      this.nbcarmax = var1;
   }

   public int getOutilChoisi() {
      return this.outilChoisi;
   }

   public void setOutilChoisi(int var1) {
      this.outilChoisi = var1;
   }

   public String getToolsCode() {
      return this.toolsCode;
   }

   public void setToolsCode(String var1) {
      this.toolsCode = var1;
   }

   public List getToolsLesJournauxComptables() {
      return this.toolsLesJournauxComptables;
   }

   public void setToolsLesJournauxComptables(List var1) {
      this.toolsLesJournauxComptables = var1;
   }

   public List getToolsLesPeriode() {
      return this.toolsLesPeriode;
   }

   public void setToolsLesPeriode(List var1) {
      this.toolsLesPeriode = var1;
   }

   public String getToolsPeriode() {
      return this.toolsPeriode;
   }

   public void setToolsPeriode(String var1) {
      this.toolsPeriode = var1;
   }

   public String getToolsCompteOld() {
      return this.toolsCompteOld;
   }

   public void setToolsCompteOld(String var1) {
      this.toolsCompteOld = var1;
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

   public boolean isShowModalPanelSupprimer() {
      return this.showModalPanelSupprimer;
   }

   public void setShowModalPanelSupprimer(boolean var1) {
      this.showModalPanelSupprimer = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public boolean isVar_acces_direct() {
      return this.var_acces_direct;
   }

   public void setVar_acces_direct(boolean var1) {
      this.var_acces_direct = var1;
   }

   public boolean isAfficheBudgetTresoProjet() {
      return this.afficheBudgetTresoProjet;
   }

   public void setAfficheBudgetTresoProjet(boolean var1) {
      this.afficheBudgetTresoProjet = var1;
   }

   public boolean isAfficheBudgetTresoStandard() {
      return this.afficheBudgetTresoStandard;
   }

   public void setAfficheBudgetTresoStandard(boolean var1) {
      this.afficheBudgetTresoStandard = var1;
   }

   public int getVar_mode_chg() {
      return this.var_mode_chg;
   }

   public void setVar_mode_chg(int var1) {
      this.var_mode_chg = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public FormExtraitCompte getFormExtraitCompte() {
      return this.formExtraitCompte;
   }

   public void setFormExtraitCompte(FormExtraitCompte var1) {
      this.formExtraitCompte = var1;
   }

   public String getVar_nom_champ() {
      return this.var_nom_champ;
   }

   public void setVar_nom_champ(String var1) {
      this.var_nom_champ = var1;
   }

   public FormAnalytique getFormAnalytique() {
      return this.formAnalytique;
   }

   public void setFormAnalytique(FormAnalytique var1) {
      this.formAnalytique = var1;
   }

   public boolean isVar_affiche_dossier() {
      return this.var_affiche_dossier;
   }

   public void setVar_affiche_dossier(boolean var1) {
      this.var_affiche_dossier = var1;
   }

   public DataModel getDatamodelDossier() {
      return this.datamodelDossier;
   }

   public void setDatamodelDossier(DataModel var1) {
      this.datamodelDossier = var1;
   }

   public boolean isShowModalPanelDossier() {
      return this.showModalPanelDossier;
   }

   public void setShowModalPanelDossier(boolean var1) {
      this.showModalPanelDossier = var1;
   }

   public boolean isModeConsultation() {
      return this.modeConsultation;
   }

   public void setModeConsultation(boolean var1) {
      this.modeConsultation = var1;
   }

   public List getLesModelesAutorises() {
      return this.lesModelesAutorises;
   }

   public void setLesModelesAutorises(List var1) {
      this.lesModelesAutorises = var1;
   }

   public UIDataTable getExtDTableJournaux() {
      return this.extDTableJournaux;
   }

   public void setExtDTableJournaux(UIDataTable var1) {
      this.extDTableJournaux = var1;
   }

   public UIDataTable getExtDTablePeriode() {
      return this.extDTablePeriode;
   }

   public void setExtDTablePeriode(UIDataTable var1) {
      this.extDTablePeriode = var1;
   }

   public SimpleSelection getSimpleSelectionJournaux() {
      return this.simpleSelectionJournaux;
   }

   public void setSimpleSelectionJournaux(SimpleSelection var1) {
      this.simpleSelectionJournaux = var1;
   }

   public SimpleSelection getSimpleSelectionPeriode() {
      return this.simpleSelectionPeriode;
   }

   public void setSimpleSelectionPeriode(SimpleSelection var1) {
      this.simpleSelectionPeriode = var1;
   }

   public boolean isShowModalPanelCorrection() {
      return this.showModalPanelCorrection;
   }

   public void setShowModalPanelCorrection(boolean var1) {
      this.showModalPanelCorrection = var1;
   }

   public boolean isShowModalPanelAnalytiqueCorrection() {
      return this.showModalPanelAnalytiqueCorrection;
   }

   public void setShowModalPanelAnalytiqueCorrection(boolean var1) {
      this.showModalPanelAnalytiqueCorrection = var1;
   }

   public DataModel getDataModelEcritureAReimputer() {
      return this.dataModelEcritureAReimputer;
   }

   public void setDataModelEcritureAReimputer(DataModel var1) {
      this.dataModelEcritureAReimputer = var1;
   }

   public boolean isShowModalPanelPJ() {
      return this.showModalPanelPJ;
   }

   public void setShowModalPanelPJ(boolean var1) {
      this.showModalPanelPJ = var1;
   }

   public int getModePj() {
      return this.modePj;
   }

   public void setModePj(int var1) {
      this.modePj = var1;
   }

   public boolean isConditionPj() {
      return this.conditionPj;
   }

   public void setConditionPj(boolean var1) {
      this.conditionPj = var1;
   }

   public String getValueScanPj() {
      return this.valueScanPj;
   }

   public void setValueScanPj(String var1) {
      this.valueScanPj = var1;
   }

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
   }

   public String getUrlphotoProd() {
      return this.urlphotoProd;
   }

   public void setUrlphotoProd(String var1) {
      this.urlphotoProd = var1;
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

   public int getTypeFichier() {
      return this.typeFichier;
   }

   public void setTypeFichier(int var1) {
      this.typeFichier = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public boolean isShowModalPanelAjoutPJ() {
      return this.showModalPanelAjoutPJ;
   }

   public void setShowModalPanelAjoutPJ(boolean var1) {
      this.showModalPanelAjoutPJ = var1;
   }

   public boolean isForceVerrou() {
      return this.forceVerrou;
   }

   public void setForceVerrou(boolean var1) {
      this.forceVerrou = var1;
   }

   public DataModel getDataModelPjSecretariat() {
      return this.dataModelPjSecretariat;
   }

   public void setDataModelPjSecretariat(DataModel var1) {
      this.dataModelPjSecretariat = var1;
   }

   public boolean isShowModalPanelInformation() {
      return this.showModalPanelInformation;
   }

   public void setShowModalPanelInformation(boolean var1) {
      this.showModalPanelInformation = var1;
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

   public int getModeAcces() {
      return this.modeAcces;
   }

   public void setModeAcces(int var1) {
      this.modeAcces = var1;
   }

   public DataModel getDataModelListeCompte() {
      return this.dataModelListeCompte;
   }

   public void setDataModelListeCompte(DataModel var1) {
      this.dataModelListeCompte = var1;
   }

   public boolean isShowModalPanelListeCompte() {
      return this.showModalPanelListeCompte;
   }

   public void setShowModalPanelListeCompte(boolean var1) {
      this.showModalPanelListeCompte = var1;
   }

   public DataModel getDataModelEcrituresModele() {
      return this.dataModelEcrituresModele;
   }

   public void setDataModelEcrituresModele(DataModel var1) {
      this.dataModelEcrituresModele = var1;
   }

   public double getMontantModele() {
      return this.montantModele;
   }

   public void setMontantModele(double var1) {
      this.montantModele = var1;
   }

   public boolean isShowModalPanelModele() {
      return this.showModalPanelModele;
   }

   public void setShowModalPanelModele(boolean var1) {
      this.showModalPanelModele = var1;
   }

   public int getJourModele() {
      return this.jourModele;
   }

   public void setJourModele(int var1) {
      this.jourModele = var1;
   }

   public String getLibelleModele() {
      return this.libelleModele;
   }

   public void setLibelleModele(String var1) {
      this.libelleModele = var1;
   }

   public String getReferenceModele() {
      return this.referenceModele;
   }

   public void setReferenceModele(String var1) {
      this.referenceModele = var1;
   }

   public String getPieceModele() {
      return this.pieceModele;
   }

   public void setPieceModele(String var1) {
      this.pieceModele = var1;
   }

   public EcrituresModeles getEcrituresModeles() {
      return this.ecrituresModeles;
   }

   public void setEcrituresModeles(EcrituresModeles var1) {
      this.ecrituresModeles = var1;
   }

   public List getMesModelesItems() {
      return this.mesModelesItems;
   }

   public void setMesModelesItems(List var1) {
      this.mesModelesItems = var1;
   }

   public String getCodeModele() {
      return this.codeModele;
   }

   public void setCodeModele(String var1) {
      this.codeModele = var1;
   }
}
