package com.epegase.forms.comptabilite;

import com.epegase.forms.commun.FormAnalytique;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Brouillard;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.Devise;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresAnalytique;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.JournauxMois;
import com.epegase.systeme.classe.Mails;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.PlansAnalytiques;
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
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.OptionComptabilite;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;

public class FormBrouillardsComptables implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action;
   private int var_memo_action;
   private String pageIndex;
   private int nature;
   private FormRecherche formRecherche;
   private OptionComptabilite optionComptabilite;
   private ExercicesComptable selectedExo;
   private ExercicesComptable lastExo;
   private int var_nb_max = 100;
   private Brouillard brouillard = new Brouillard();
   private List lesBrouillards = new ArrayList();
   private transient DataModel dataModelLesBrouillards = new ListDataModel();
   private BrouillardDao brouillardDao;
   private Ecritures ecritures = new Ecritures();
   private List lesEcritures = new ArrayList();
   private transient DataModel dataModelLesEcritures = new ListDataModel();
   private EcrituresDao ecrituresDao;
   private List lesJournauxComptables = new ArrayList();
   private List lesPeriodes = new ArrayList();
   private JournauxComptablesDao journauxComptablesDao;
   private JournauxComptables journauxComptables;
   private UtilDate utilDate = new UtilDate();
   private UtilNombre utilNombre = new UtilNombre("");
   private TiersDao tiersDao;
   private JournauxMois journauxMois;
   private JournauxMoisDao journauxMoisDao;
   private List lesDevises = new ArrayList();
   private boolean testsaisibrouillard = false;
   private boolean testAffMAjbrouillard = false;
   private boolean testAffSupbrouillard = false;
   private boolean testAffValbrouillard = false;
   private boolean testAffMAjbrouillardLigne = false;
   private boolean testValiderSaisie = false;
   private boolean testAnnulerSaisie = false;
   private double totalBroDeb;
   private double totalBroCred;
   private double soldeTotal;
   private ChronoDao chronoDao;
   private Chrono chronoEcriture;
   private boolean verrouPiece = false;
   private CalculChrono calculChronoEcriture;
   private String jour;
   private String cpTreso;
   private String code;
   private String periode;
   private List lesjoursItems = new ArrayList();
   private Date datePeriode;
   private String propritaire;
   private List lesuserItems = new ArrayList();
   private UserDao userDao;
   private long idProprietaire;
   private String nomProprietaire;
   private int etat = 0;
   private boolean var_saisieProprietaire = false;
   private PlanComptableDao planComptableDao;
   private PlanComptable planComptable = new PlanComptable();
   private int var_type_compte;
   private double totalMvtscredit;
   private double totalMvtsdebit;
   private double soldeMvts;
   private boolean var_modif = false;
   private boolean var_affiche_analytique = false;
   private boolean showModalPanelAnalytique = false;
   private long var_memo_ligne_gene;
   private FormAnalytique formAnalytique;
   private boolean var_affiche_dossier;
   private transient DataModel datamodelDossier = new ListDataModel();
   private String codeDossier;
   private boolean showModalPanelDossier = false;
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
   private int valindexD = 10;
   private int valindexC = 11;
   private boolean journalVide = true;
   private boolean pieceVide = true;
   private boolean periodeVide = true;
   private int modeImp;
   private List lesModelsimpression = new ArrayList();
   private boolean showModalPanelPrint = false;
   private boolean showModalPanelValidation = false;
   private int var_choix_validation;
   private int var_jourDebut;
   private int var_jourFin;
   private List lesPiecesSelectionnes = new ArrayList();
   private boolean showModalPanelPiece = false;
   private String var_nouveau_numero;
   private String var_ancien_numero;
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

   public void InstancesDaoUtilses() {
      this.calculChronoEcriture = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.brouillardDao = new BrouillardDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresDao = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      this.chronoDao = new ChronoDao(this.baseLog, this.utilInitHibernate);
      this.journauxMoisDao = new JournauxMoisDao(this.baseLog, this.utilInitHibernate);
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
   }

   public void initGeneral() throws HibernateException, NamingException {
      this.initGeneral((Session)null);
   }

   public void initGeneral(Session var1) throws HibernateException, NamingException {
      this.razBrouillard();
      if (this.code != null && !this.code.isEmpty()) {
         this.journauxComptables = this.journauxComptablesDao.rechercheJCByCode(this.code, this.usersLog.getUsrJrxReserve(), this.selectedExo.getExecpt_id(), var1);
      } else {
         this.journauxComptables = null;
      }

      if (this.optionComptabilite.getNbLigneMaxBr() != null && !this.optionComptabilite.getNbLigneMaxBr().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionComptabilite.getNbLigneMaxBr());
      } else {
         this.var_nb_max = 100;
      }

      this.initAnalytique();
      this.calculeAgentSaisie();
   }

   public void razBrouillard() {
      this.lesBrouillards.clear();
      this.lesEcritures.clear();
      this.totalBroCred = 0.0D;
      this.totalBroDeb = 0.0D;
      this.soldeTotal = 0.0D;
      this.journalVide = false;
      this.testsaisibrouillard = false;
   }

   public void initAnalytique() {
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

   }

   public void calculPeriode(Session var1) throws HibernateException, NamingException {
      this.lesjoursItems.clear();
      this.lesjoursItems.add(new SelectItem(""));
      this.lesPeriodes.clear();
      this.lesPeriodes.add(new SelectItem("Sélectionner une période"));
      Date var2 = this.selectedExo.getExecptDateDebut();
      GregorianCalendar var3 = new GregorianCalendar();
      var3.setTime(var2);
      Date var4 = this.selectedExo.getExecptDateFin();
      GregorianCalendar var5 = new GregorianCalendar();
      var5.setTime(var4);
      var3.add(2, -1);
      var5.add(2, -1);
      String var6 = null;

      while(var3.compareTo(var5) < 0) {
         var3.add(2, 1);
         Date var7 = var3.getTime();
         var6 = this.formatPeriode(var7);
         if (this.journauxComptables != null) {
            String var8 = this.journauxComptables.getPljCode() + ":" + var6;
            this.journauxMois = this.journauxMoisDao.recupererJournauxMois(var8, this.selectedExo, var1);
            if (this.journauxMois != null && this.journauxMois.getJoumenEtat() == 0) {
               this.lesPeriodes.add(new SelectItem(var6));
            }
         }
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

   public void calculLesJourDunMois() throws ParseException {
      if (this.periode != null && !this.periode.isEmpty() && this.periode.contains(":")) {
         String var1 = "01:" + this.periode;
         SimpleDateFormat var2 = new SimpleDateFormat("dd:MM:yyyy");
         this.datePeriode = var2.parse(var1);
         this.lesjoursItems.clear();
         GregorianCalendar var3 = new GregorianCalendar();
         var3.setTime(this.datePeriode);
         GregorianCalendar var4 = new GregorianCalendar();
         var4.setTime(this.datePeriode);
         var3.add(2, 0);
         var4.add(2, 1);
         var4.add(5, -1);

         for(int var5 = 1; var3.compareTo(var4) <= 0; ++var5) {
            var3.add(5, 1);
            this.lesjoursItems.add(new SelectItem(var5));
         }
      }

   }

   public void chargerLesJournauxComptable(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      List var2 = this.journauxComptablesDao.mesjournauxActifs(this.selectedExo.getExecpt_id(), this.usersLog.getUsrJrxInterdit(), this.usersLog.getUsrJrxReserve(), var1);
      this.lesJournauxComptables = new ArrayList();
      this.lesJournauxComptables.add(new SelectItem("", "Sélectionner un journal"));

      for(int var3 = 0; var3 < var2.size(); ++var3) {
         JournauxComptables var4 = (JournauxComptables)var2.get(var3);
         String var5 = var4.getPljCode();
         String var6 = var4.getPljLibelleFr();
         this.lesJournauxComptables.add(new SelectItem(var5, var5 + ":" + var6));
      }

   }

   public void chargerLesPeriodesJournal() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "JournauxComptables");
      this.initGeneral(var1);
      if (this.journauxComptables != null) {
         this.calculPeriode(var1);
      } else {
         this.lesPeriodes.clear();
         this.lesPeriodes.add(new SelectItem("Sélectionner une période"));
         this.lesjoursItems.clear();
         this.lesjoursItems.add(new SelectItem(""));
      }

      this.utilInitHibernate.closeSession();
   }

   public void chargerLesDevises(Session var1) throws HibernateException, NamingException {
      this.lesDevises.clear();
      if (this.journauxComptables.getPljTypeDevise() == 0) {
         this.lesDevises.add(new SelectItem(this.structureLog.getStrdevise()));
      } else if (this.journauxComptables.getPljTypeDevise() == 1) {
         this.lesDevises.add(new SelectItem(this.journauxComptables.getPljChoixDevise()));
      } else if (this.journauxComptables.getPljTypeDevise() == 2) {
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

   public void chargerLesUsers(Session var1) throws HibernateException, NamingException {
      if (this.usersLog.getUsrAccesBrouillard() == 0) {
         this.lesuserItems.add(new SelectItem("0", "Aucun utilisateur des brouillards !!!"));
         this.testAffValbrouillard = false;
      } else if (this.usersLog.getUsrAccesBrouillard() == 1) {
         this.lesuserItems.add(new SelectItem(this.usersLog.getUsrid(), this.usersLog.getUsrPatronyme()));
         this.testAffValbrouillard = false;
      } else if (this.usersLog.getUsrAccesBrouillard() == 2) {
         new ArrayList();
         List var2 = this.userDao.selectUserBrouillards(var1);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               new Users();
               Users var4 = (Users)var2.get(var3);
               this.lesuserItems.add(new SelectItem(var4.getUsrid(), var4.getUsrPatronyme()));
            }

            this.testAffValbrouillard = true;
         } else {
            this.lesuserItems.add(new SelectItem("0", "Aucun utilisateur des brouillards !!!"));
            this.testAffValbrouillard = false;
         }
      }

   }

   public void calculeAgentSaisie() {
      this.idProprietaire = 0L;
      this.nomProprietaire = "";
      if (this.propritaire != null && !this.propritaire.isEmpty() && !this.propritaire.equals("0")) {
         for(int var1 = 0; var1 < this.lesuserItems.size(); ++var1) {
            if (((SelectItem)this.lesuserItems.get(var1)).getValue().toString().equals(this.propritaire)) {
               this.idProprietaire = Long.parseLong(((SelectItem)this.lesuserItems.get(var1)).getValue().toString());
               this.nomProprietaire = ((SelectItem)this.lesuserItems.get(var1)).getLabel();
               break;
            }
         }
      }

      if (this.idProprietaire == this.usersLog.getUsrid()) {
         this.var_saisieProprietaire = true;
      } else {
         this.var_saisieProprietaire = false;
      }

   }

   public boolean testCompteBudget() {
      boolean var1 = false;
      if (this.planComptable.getPlcNature() == 1) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c1());
      } else if (this.planComptable.getPlcNature() == 2) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c2());
      } else if (this.planComptable.getPlcNature() == 3) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c3());
      } else if (this.planComptable.getPlcNature() == 4) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c4());
      } else if (this.planComptable.getPlcNature() == 5) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c5());
      } else if (this.planComptable.getPlcNature() == 6) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c6());
      } else if (this.planComptable.getPlcNature() == 7) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c7());
      } else if (this.planComptable.getPlcNature() == 8) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c8());
      } else if (this.planComptable.getPlcNature() == 9) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c9());
      } else if (this.planComptable.getPlcNature() == 10) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c10());
      } else if (this.planComptable.getPlcNature() == 11) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c11());
      } else if (this.planComptable.getPlcNature() == 12) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c12());
      } else if (this.planComptable.getPlcNature() == 13) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c13());
      } else if (this.planComptable.getPlcNature() == 14) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c14());
      } else if (this.planComptable.getPlcNature() == 15) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c15());
      } else if (this.planComptable.getPlcNature() == 16) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c16());
      } else if (this.planComptable.getPlcNature() == 17) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c17());
      } else if (this.planComptable.getPlcNature() == 18) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c18());
      } else if (this.planComptable.getPlcNature() == 19) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c19());
      } else if (this.planComptable.getPlcNature() == 20) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c20());
      } else if (this.planComptable.getPlcNature() == 21) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c21());
      } else if (this.planComptable.getPlcNature() == 22) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c22());
      } else if (this.planComptable.getPlcNature() == 23) {
         var1 = Boolean.parseBoolean(this.optionComptabilite.getBud_c23());
      } else if (this.planComptable.getPlcNature() == 24) {
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

   public String calculeCompteTreso(JournauxComptables var1, String var2) throws ParseException {
      this.cpTreso = "";
      if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty() && (this.datePeriode != null || var2 != null && !var2.isEmpty())) {
         Date var3 = null;
         if (this.datePeriode != null) {
            var3 = this.datePeriode;
         } else if (var2 != null && !var2.isEmpty()) {
            String[] var4 = this.journauxMois.getJoumenPeriode().split(":");
            String var5 = var4[0];
            String var6 = var4[1];
            var3 = this.utilDate.stringToDateSQLLight(var6 + "-" + var5 + "-" + "01");
         }

         long var7 = (long)(var3.getYear() + 1900);
         if (this.structureLog.getStrdatefiscale2() == null || var3.compareTo(this.structureLog.getStrdatefiscale2()) <= 0 && var7 < (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900)) {
            this.cpTreso = var1.getPljCompteTreso();
         } else {
            this.cpTreso = var1.getPljCompteTresoNew();
         }
      } else {
         this.cpTreso = var1.getPljCompteTreso();
      }

      if (this.cpTreso == null || this.cpTreso.isEmpty()) {
         this.cpTreso = "***COMPTE ABSENT***";
      }

      return this.cpTreso;
   }

   public void chargerLesBrouillardsMois() throws NamingException, ParseException {
      if (this.code != null && !this.code.isEmpty() && this.periode != null && !this.periode.isEmpty() && this.periode.contains(":") && this.selectedExo.getExecpt_id() == this.lastExo.getExecpt_id() && !this.propritaire.equals("0")) {
         this.modeImp = 2;
         this.testsaisibrouillard = true;
         this.periodeVide = false;
         this.calculeAgentSaisie();
         this.lesBrouillards = new ArrayList();
         this.lesEcritures = new ArrayList();
         this.totalBroCred = 0.0D;
         this.totalBroDeb = 0.0D;
         this.soldeTotal = 0.0D;
         this.journalVide = true;
         this.lesBrouillards = this.brouillardDao.chargerLesBrouillards(this.getCode(), this.getPeriode(), this.idProprietaire, this.etat, this.selectedExo.getExecpt_id());
         this.dataModelLesBrouillards.setWrappedData(this.lesBrouillards);
         if (this.lesBrouillards != null) {
            double var1 = 0.0D;
            double var3 = 0.0D;

            for(int var5 = 0; var5 < this.lesBrouillards.size(); ++var5) {
               var3 += ((Brouillard)this.lesBrouillards.get(var5)).getBroDebitSaisie();
               var1 += ((Brouillard)this.lesBrouillards.get(var5)).getBroCreditSaisie();
            }

            this.totalBroDeb = var3;
            this.totalBroCred = var1;
            if (var3 > var1) {
               this.soldeTotal = var3 - var1;
            } else {
               this.soldeTotal = var1 - var3;
            }

            this.journalVide = false;
         }

         this.calculLesJourDunMois();
      } else {
         this.testsaisibrouillard = false;
         this.totalBroCred = 0.0D;
         this.totalBroDeb = 0.0D;
         this.soldeTotal = 0.0D;
         this.periodeVide = true;
         this.lesBrouillards.clear();
         this.lesEcritures.clear();
         this.dataModelLesBrouillards.setWrappedData(this.lesBrouillards);
      }

      this.brouillard = new Brouillard();
      this.testAffMAjbrouillard = false;
      this.testAffSupbrouillard = false;
   }

   public void chargerLesBrouillardsJour() throws NamingException, ParseException {
      if (this.code != null && !this.code.isEmpty() && this.periode != null && !this.periode.isEmpty() && this.periode.contains(":") && this.selectedExo.getExecpt_id() == this.lastExo.getExecpt_id() && !this.propritaire.equals("0")) {
         this.modeImp = 12;
         this.testsaisibrouillard = true;
         this.periodeVide = false;
         this.calculeAgentSaisie();
         this.lesBrouillards = new ArrayList();
         this.lesEcritures = new ArrayList();
         this.totalBroCred = 0.0D;
         this.totalBroDeb = 0.0D;
         this.soldeTotal = 0.0D;
         this.journalVide = true;
         String var1 = this.jour + ":" + this.periode;
         SimpleDateFormat var2 = new SimpleDateFormat("dd:MM:yyyy");
         Date var3 = var2.parse(var1);
         this.lesBrouillards = this.brouillardDao.chargerLesBrouillards(this.getCode(), var3, this.idProprietaire, this.etat, this.selectedExo.getExecpt_id());
         this.dataModelLesBrouillards.setWrappedData(this.lesBrouillards);
         if (this.lesBrouillards != null) {
            double var4 = 0.0D;
            double var6 = 0.0D;

            for(int var8 = 0; var8 < this.lesBrouillards.size(); ++var8) {
               var6 += ((Brouillard)this.lesBrouillards.get(var8)).getBroDebitSaisie();
               var4 += ((Brouillard)this.lesBrouillards.get(var8)).getBroCreditSaisie();
            }

            this.totalBroDeb = var6;
            this.totalBroCred = var4;
            if (var6 > var4) {
               this.soldeTotal = var6 - var4;
            } else {
               this.soldeTotal = var4 - var6;
            }

            this.journalVide = false;
         }

         this.calculLesJourDunMois();
      } else {
         this.testsaisibrouillard = false;
         this.totalBroCred = 0.0D;
         this.totalBroDeb = 0.0D;
         this.soldeTotal = 0.0D;
         this.periodeVide = true;
         this.lesBrouillards.clear();
         this.lesEcritures.clear();
         this.dataModelLesBrouillards.setWrappedData(this.lesBrouillards);
      }

      this.brouillard = new Brouillard();
      this.testAffMAjbrouillard = false;
      this.testAffSupbrouillard = false;
   }

   public void selctionPiece() throws HibernateException, NamingException, ParseException {
      if (this.dataModelLesBrouillards.isRowAvailable()) {
         this.brouillard = (Brouillard)this.dataModelLesBrouillards.getRowData();
         this.trouverJournal((Session)null);
         this.lesEcritures.clear();
         this.lesEcritures = this.ecrituresDao.chargerLesBrouillardLignes(this.brouillard);
         this.dataModelLesEcritures.setWrappedData(this.lesEcritures);
         this.calculTotalDebCredMvts();
         this.conditionPj = false;
         if (this.lesEcritures.size() != 0) {
            for(int var1 = 0; var1 < this.lesEcritures.size(); ++var1) {
               if (((Ecritures)this.lesEcritures.get(var1)).getEcrPiece() != null && !((Ecritures)this.lesEcritures.get(var1)).getEcrPiece().isEmpty()) {
                  if (((Ecritures)this.lesEcritures.get(var1)).getEcrNatureJrx() == 7 || ((Ecritures)this.lesEcritures.get(var1)).getEcrNatureJrx() == 8 || ((Ecritures)this.lesEcritures.get(var1)).getEcrNatureJrx() == 9 || ((Ecritures)this.lesEcritures.get(var1)).getEcrNatureJrx() == 10) {
                     this.conditionPj = true;
                     break;
                  }

                  if (((Ecritures)this.lesEcritures.get(var1)).getEcrCompte() != null && !((Ecritures)this.lesEcritures.get(var1)).getEcrCompte().isEmpty() && (((Ecritures)this.lesEcritures.get(var1)).getEcrCompte().startsWith("3") || ((Ecritures)this.lesEcritures.get(var1)).getEcrCompte().startsWith("4"))) {
                     this.conditionPj = true;
                     break;
                  }
               }
            }
         }

         if (this.selectedExo.getExecpt_id() == this.lastExo.getExecpt_id()) {
            this.testAffMAjbrouillard = true;
            if (this.usersLog.getUsrid() == this.brouillard.getBroUserCreat()) {
               this.testAffSupbrouillard = true;
            } else {
               this.testAffSupbrouillard = false;
            }
         } else {
            this.testAffMAjbrouillard = false;
            this.testAffSupbrouillard = false;
         }

         this.pieceVide = false;
      }

   }

   public void ajouterPiece() throws HibernateException, NamingException, ParseException {
      this.brouillard = new Brouillard();
      this.brouillard.setBroCode(this.code);
      this.brouillard.setBroPeriode(this.periode);
      this.ecritures = new Ecritures();
      if (this.jour != null && !this.jour.isEmpty()) {
         this.brouillard.setBroJour(Integer.parseInt(this.jour));
      } else {
         this.brouillard.setBroJour((new Date()).getDay());
      }

      this.lesEcritures.clear();
      this.totalMvtscredit = 0.0D;
      this.totalMvtsdebit = 0.0D;
      this.soldeMvts = 0.0D;
      this.pieceVide = true;
      this.trouverJournal((Session)null);
      this.var_action = 1;
      this.var_memo_action = this.var_action;
      this.testValiderSaisie = false;
      this.testAnnulerSaisie = true;
   }

   public void modifierPiece() throws HibernateException, NamingException, ParseException {
      this.trouverJournal((Session)null);
      this.var_action = 2;
      this.var_memo_action = this.var_action;
   }

   public void consulterPiece() throws HibernateException, NamingException, ParseException {
      this.trouverJournal((Session)null);
      this.verrouPiece = true;
      this.var_action = 3;
      this.var_memo_action = this.var_action;
   }

   public void supprimerPiece() throws HibernateException, NamingException {
      if (this.brouillard.getBro_id() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var2 = null;

         EcrituresAnalytiquesDao var3;
         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            if (this.lesEcritures.size() != 0) {
               var3 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);

               for(int var4 = 0; var4 < this.lesEcritures.size(); ++var4) {
                  new Ecritures();
                  Ecritures var5 = (Ecritures)this.lesEcritures.get(var4);
                  new ArrayList();
                  List var6 = var3.chargerLesEcrituresAnalytiques(var5, var1);
                  if (var6.size() != 0) {
                     var3.nettoyageAnalytiqueByEcriture(var6, var1);
                     var1.flush();
                  }
               }
            }

            var2.commit();
         } catch (HibernateException var19) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var19;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         if (this.brouillard.getBroPiece() != null && !this.brouillard.getBroPiece().isEmpty() && this.brouillard.isBroPj()) {
            String var21 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanCompta" + this.selectedExo.getExecpt_id() + File.separator;
            String var23 = this.brouillard.getBroCode() + ":" + this.brouillard.getBroPeriode() + ":" + this.brouillard.getBroPiece().replaceAll("/", "_");
            File var25 = new File(var21 + var23 + ".pdf");
            if (var25.exists()) {
               var25.delete();
            } else {
               var25 = new File(var21 + var23 + ".jpg");
               if (var25.exists()) {
                  var25.delete();
               }
            }
         }

         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         var3 = null;

         try {
            Transaction var22 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            if (this.lesEcritures.size() != 0) {
               new Ecritures();

               for(int var26 = 0; var26 < this.lesEcritures.size(); ++var26) {
                  Ecritures var24 = (Ecritures)this.lesEcritures.get(var26);
                  this.ecrituresDao.removeSelectedEC0(var24, 100, var1);
                  var1.flush();
               }
            }

            var22.commit();
         } catch (HibernateException var17) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var17;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.lesEcritures.clear();
         this.lesBrouillards.remove(this.brouillard);
         this.dataModelLesBrouillards.setWrappedData(this.lesBrouillards);
         this.brouillardDao.delete(this.brouillard);
         this.brouillard = new Brouillard();
         this.testAffMAjbrouillard = false;
         this.testAffSupbrouillard = false;
      }

   }

   public void annulerSaisie() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.pieceVide = true;
      this.testAffMAjbrouillard = false;
      this.testAffSupbrouillard = false;
   }

   public void ajouterLigne() {
      this.ecritures = new Ecritures();
      this.testAffMAjbrouillardLigne = false;
   }

   public void supprimerLigne() throws HibernateException, NamingException {
      this.lesEcritures.remove(this.ecritures);
      this.dataModelLesEcritures.setWrappedData(this.lesEcritures);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         var1.setFlushMode(FlushMode.MANUAL);
         this.ecrituresDao.removeSelectedEC0(this.ecritures, 100, var1);
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

      this.ecritures = new Ecritures();
      this.calculTotalDebCredMvts();
      this.testAffMAjbrouillardLigne = false;
   }

   public void selectionEcriture() throws HibernateException, NamingException {
      if (this.dataModelLesEcritures.isRowAvailable()) {
         this.ecritures = (Ecritures)this.dataModelLesEcritures.getRowData();
         this.testAffMAjbrouillardLigne = true;
         if (this.ecritures.getEcrCompte() != null && !this.ecritures.getEcrCompte().isEmpty()) {
            this.planComptable = this.planComptableDao.trouveCompte(this.selecFiscalite, this.selectedExo.getExecpt_id(), this.ecritures.getEcrCompte(), (Session)null);
         } else {
            this.planComptable = null;
         }
      }

   }

   public void ouvrirDetailsAnalytique() throws HibernateException, NamingException {
      this.ouvrirDetailsAnalytique((Session)null);
   }

   public void ouvrirDetailsAnalytique(Session var1) throws HibernateException, NamingException {
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
      if (this.brouillard != null && this.brouillard.isBroPj()) {
         this.ouvrirPjConsultation();
      } else if (this.ecritures != null && !this.ecritures.isEcrPj()) {
         this.modePj = 1;
         this.uploadedFile = null;
         this.typeFichier = 0;
         this.showModalPanelAjoutPJ = true;
      } else {
         this.ouvrirPjConsultation();
      }

   }

   public void ouvrirPjConsultation() throws HibernateException, NamingException, MalformedURLException, IOException {
      this.selectionEcriture();
      if (this.brouillard != null && this.brouillard.getBroPiece() != null && !this.brouillard.getBroPiece().isEmpty()) {
         this.modePj = 2;
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanCompta" + this.selectedExo.getExecpt_id() + File.separator;
         String var2 = this.brouillard.getBroCode() + ":" + this.brouillard.getBroPeriode() + ":" + this.brouillard.getBroPiece().replaceAll("/", "_");
         File var3 = new File(var1 + var2 + ".pdf");
         if (var3.exists()) {
            this.typeFichier = 1;
            var2 = var2 + ".pdf";
         } else {
            this.typeFichier = 0;
            var2 = var2 + ".jpg";
         }

         if (this.typeFichier == 1) {
            this.fichierUrl = this.utilDownload.convertirFichierUtl(var1 + var2, this.urlExplorateur);
            this.fichierMine = this.utilDownload.calculeTypeMine(var2);
            this.typeFichier = 1;
         } else {
            this.urlphotoProd = "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanCompta" + this.selectedExo.getExecpt_id() + File.separator + var2;
            this.typeFichier = 0;
         }

         this.showModalPanelPJ = true;
      }

   }

   public void fermerPj() {
      this.showModalPanelPJ = false;
      this.showModalPanelAjoutPJ = false;
   }

   public void validerPj() {
      String var1 = "";

      try {
         if (this.uploadedFile != null && this.brouillard != null && this.brouillard.getBroPiece() != null && !this.brouillard.getBroPiece().isEmpty()) {
            var1 = this.brouillard.getBroCode() + ":" + this.brouillard.getBroPeriode() + ":" + this.brouillard.getBroPiece().replaceAll("/", "_");
            String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "photos" + File.separator + "scanCompta" + this.selectedExo.getExecpt_id();
            File var4 = new File(var3);
            if (!var4.exists()) {
               var4.mkdir();
            }

            String var5 = "";
            if (!this.uploadedFile.getName().endsWith("pdf") && !this.uploadedFile.getName().endsWith("PDF")) {
               var5 = ".jpg";
            } else {
               var5 = ".pdf";
            }

            File var2 = new File(var3 + File.separator + var1 + var5);
            var2.delete();
            File var6 = this.utilDownload.uniqueFile(new File(var3 + File.separator), var1 + var5);
            this.utilDownload.write(var6, this.uploadedFile.getInputStream());
         }
      } catch (IOException var7) {
      }

      if (var1 != null && !var1.isEmpty()) {
         this.brouillard.setBroPj(true);
      } else {
         this.brouillard.setBroPj(false);
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
      String var2 = this.brouillard.getBroCode() + ":" + this.brouillard.getBroPeriode() + ":" + this.brouillard.getBroPiece().replaceAll("/", "_");
      File var3 = new File(var1 + var2 + ".pdf");
      if (var3.exists()) {
         var3.delete();
      } else {
         var3 = new File(var1 + var2 + ".jpg");
         if (var3.exists()) {
            var3.delete();
         }
      }

      this.brouillard.setBroPj(false);
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
      if (this.brouillard != null) {
         this.var_nouveau_numero = "";
         this.var_ancien_numero = this.brouillard.getBroPiece();
         this.showModalPanelPiece = true;
      }

   }

   public void fermerNumPiece() {
      this.showModalPanelPiece = false;
   }

   public void valideNumPiece() throws HibernateException, NamingException {
      if (this.brouillard != null && this.var_nouveau_numero != null && !this.var_nouveau_numero.isEmpty()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Brouillard");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            this.brouillard.setBroPiece(this.var_nouveau_numero);
            this.brouillard = this.brouillardDao.modif(this.brouillard, var1);
            var1.flush();
            if (this.lesEcritures.size() != 0) {
               new Ecritures();
               EcrituresAnalytiquesDao var4 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
               Object var5 = new ArrayList();

               for(int var6 = 0; var6 < this.lesEcritures.size(); ++var6) {
                  Ecritures var3 = (Ecritures)this.lesEcritures.get(var6);
                  var3.setEcrPiece(this.var_nouveau_numero);
                  this.ecrituresDao.modif(var3, var1);
                  var1.flush();
                  if (var3.getEcrAnaActif() == 1) {
                     ((List)var5).clear();
                     var5 = var4.chargerLesEcrituresAnalytiques(var3, var1);
                     if (((List)var5).size() != 0) {
                        new EcrituresAnalytique();

                        for(int var8 = 0; var8 < ((List)var5).size(); ++var8) {
                           EcrituresAnalytique var7 = (EcrituresAnalytique)((List)var5).get(var8);
                           var7.setEcranaPiece(this.var_nouveau_numero);
                           var4.modifEcritureAnalytiques(var1, var7);
                           var1.flush();
                        }
                     }
                  }
               }
            }

            if (this.brouillard.isBroPj()) {
               String var14 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanCompta" + this.selectedExo.getExecpt_id() + File.separator;
               String var15 = this.brouillard.getBroCode() + ":" + this.brouillard.getBroPeriode() + ":" + this.var_ancien_numero.replaceAll("/", "_");
               String var16 = this.brouillard.getBroCode() + ":" + this.brouillard.getBroPeriode() + ":" + this.var_nouveau_numero.replaceAll("/", "_");
               File var17 = new File(var14 + var15 + ".pdf");
               if (var17.exists()) {
                  this.typeFichier = 1;
                  var15 = var15 + ".pdf";
                  var16 = var16 + ".pdf";
               } else {
                  this.typeFichier = 0;
                  var15 = var15 + ".jpg";
                  var16 = var16 + ".jpg";
               }

               File var18 = new File(var14 + var16);
               var17.renameTo(var18);
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

      this.showModalPanelPiece = false;
   }

   public void informationPiece() throws HibernateException, NamingException {
      if (this.ecritures != null) {
         this.nomCreation = "";
         this.nomModification = "";
         new Users();
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Users var1;
         if (this.ecritures.getEcrUserCreat() != 0L) {
            var1 = this.userDao.selectUserD(this.ecritures.getEcrUserCreat(), var2);
            if (var1 != null) {
               this.nomCreation = var1.getUsrPatronyme();
            }
         }

         if (this.ecritures.getEcrUserModif() != 0L) {
            var1 = this.userDao.selectUserD(this.ecritures.getEcrUserModif(), var2);
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

   public void recherchePlanComptable() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.var_type_compte = 0;
      this.planComptable = this.formRecherche.recherchePlanComptable(this.selecFiscalite, this.ecritures.getEcrCompte(), 532, this.selectedExo, this.journauxComptables.getPljNature(), this.usersLog.getUsrCptInterdit(), this.optionComptabilite);
      if (this.planComptable != null) {
         if (this.planComptable.getPlcId() != 0L) {
            this.calculePlanComptable();
         } else {
            this.var_action = 10;
         }
      } else if (this.planComptable == null) {
         this.calculePlanComptable();
      }

   }

   public void rechercheContrePartie() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.var_type_compte = 1;
      this.planComptable = this.formRecherche.recherchePlanComptable(this.selecFiscalite, this.ecritures.getEcrContrePartie(), 532, this.selectedExo, this.journauxComptables.getPljNature(), this.usersLog.getUsrCptInterdit(), this.optionComptabilite);
      if (this.planComptable != null) {
         if (this.planComptable.getPlcId() != 0L) {
            this.calculePlanComptable();
         } else {
            this.var_action = 10;
         }
      } else if (this.planComptable == null) {
         this.calculePlanComptable();
      }

   }

   public void recuperationPlanComptable() throws JDOMException, IOException, HibernateException, NamingException {
      this.planComptable = this.formRecherche.calculePlanComptable();
      this.calculePlanComptable();
   }

   public void calculePlanComptable() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.planComptable != null) {
         if (this.var_type_compte == 1) {
            this.ecritures.setEcrContrePartie(this.planComptable.getPlcCompte());
         } else {
            this.ecritures.setEcrCompte(this.planComptable.getPlcCompte());
            this.ecritures.setEcrLibCompte(this.planComptable.getPlcLibelleCpteFR());
            this.ecritures.setEcrNature(this.planComptable.getPlcNature());
            this.ecritures.setEcrClasse(this.planComptable.getPlcCompte().substring(0, 1));
            if (this.planComptable != null && (this.planComptable.getPlcNature() == 3 || this.planComptable.getPlcNature() == 13 || this.planComptable.getPlcNature() == 14 || this.planComptable.getPlcNature() == 15)) {
               new Racines();
               RacinesDao var2 = new RacinesDao(this.baseLog, this.structureLog, this.utilInitHibernate);
               Racines var1 = var2.rechercherCodeRacine(this.selecFiscalite, this.planComptable.getPlcCodeRacine(), (Session)null);
               if (var1 != null && var1.getRactaux() != 0.0F) {
                  float var3 = var1.getRactaux() / 100.0F + 1.0F;
                  String var4 = this.structureLog.getStrdevise();
                  if (this.journauxComptables.getPljChoixDevise() != null && !this.journauxComptables.getPljChoixDevise().isEmpty()) {
                     var4 = this.journauxComptables.getPljChoixDevise();
                  }

                  double var5 = Math.abs(this.soldeMvts);
                  if (this.planComptable.getPlcNature() == 13) {
                     if (this.soldeMvts < 0.0D) {
                        this.ecritures.setEcrDebitSaisie(this.utilNombre.myRoundDevise(var5 * (double)var3, var4) - var5);
                     } else {
                        this.ecritures.setEcrDebitSaisie(var5 - this.utilNombre.myRoundDevise(var5 / (double)var3, var4));
                     }
                  } else if (this.planComptable.getPlcNature() == 14) {
                     if (this.soldeMvts < 0.0D) {
                        this.ecritures.setEcrCreditSaisie(var5 - this.utilNombre.myRoundDevise(var5 / (double)var3, var4));
                     } else {
                        this.ecritures.setEcrCreditSaisie(this.utilNombre.myRoundDevise(var5 * (double)var3, var4) - var5);
                     }
                  } else if (this.soldeMvts < 0.0D) {
                     this.ecritures.setEcrCreditSaisie(this.utilNombre.myRoundDevise(var5 * (double)var3, var4) - var5);
                  } else {
                     this.ecritures.setEcrDebitSaisie(this.utilNombre.myRoundDevise(var5 * (double)var3, var4) - var5);
                  }
               }
            }
         }
      } else {
         this.planComptable = null;
         if (this.var_type_compte == 1) {
            this.ecritures.setEcrContrePartie("");
         } else {
            this.ecritures.setEcrCompte("");
            this.ecritures.setEcrLibCompte("");
            this.ecritures.setEcrNature(0);
            this.ecritures.setEcrClasse("");
         }
      }

      this.var_action = this.var_memo_action;
   }

   public void annulePlanComptable() {
      this.planComptable = null;
      if (this.var_type_compte == 1) {
         this.ecritures.setEcrContrePartie("");
      } else {
         this.ecritures.setEcrCompte("");
         this.ecritures.setEcrLibCompte("");
         this.ecritures.setEcrNature(0);
         this.ecritures.setEcrClasse("");
      }

      this.var_action = this.var_memo_action;
   }

   public Date calculDateEchéance() throws NamingException, ParseException {
      Date var1 = new Date();
      Tiers var2 = this.tiersDao.tiersCalculDateEchéance(this.ecritures.getEcrCompte());
      if (var2 != null) {
         int var3 = var2.getTietypereg();
         int var4 = var2.getTienbecheance();
         int var5 = var2.getTienbarrondi();
         var1 = this.utilDate.CalculDateEcheance(this.calculdateSasisie(), var3, var4, var5);
      }

      return var1;
   }

   public Date calculDatedeValeurTheo() throws ParseException {
      Date var1 = new Date();
      int var2 = this.getJournauxComptables().getPljDvMbsp();
      int var3 = this.getJournauxComptables().getPljDvMbhp();
      int var4 = this.getJournauxComptables().getPljDvAbsp();
      int var5 = this.getJournauxComptables().getPljDvAbhp();
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

   public Date datedevaleurTheo(int var1) throws ParseException {
      GregorianCalendar var2 = new GregorianCalendar();
      var2.setTime(this.calculdateSasisie());
      var2.add(5, var1);
      Date var3 = var2.getTime();
      return var3;
   }

   public void affichePj() {
      this.conditionPj = false;
      if (this.ecritures != null && this.ecritures.getEcrPiece() != null && !this.ecritures.getEcrPiece().isEmpty()) {
         if (this.journauxComptables.getPljNature() != 7 && this.journauxComptables.getPljNature() != 8 && this.journauxComptables.getPljNature() != 9 && this.journauxComptables.getPljNature() != 10) {
            if (this.ecritures.getEcrCompte() != null && !this.ecritures.getEcrCompte().isEmpty() && (this.ecritures.getEcrCompte().startsWith("3") || this.ecritures.getEcrCompte().startsWith("4"))) {
               this.conditionPj = true;
            }
         } else {
            this.conditionPj = true;
         }
      }

   }

   public void calculTotalDebCredMvts() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      if (this.lesEcritures.size() != 0) {
         for(int var5 = 0; var5 < this.lesEcritures.size(); ++var5) {
            var3 += ((Ecritures)this.lesEcritures.get(var5)).getEcrDebitSaisie();
            var1 += ((Ecritures)this.lesEcritures.get(var5)).getEcrCreditSaisie();
         }
      }

      this.totalMvtsdebit = var3;
      this.totalMvtscredit = var1;
      this.brouillard.setBroDebitSaisie(var3);
      this.brouillard.setBroCreditSaisie(var1);
      if (var3 > var1) {
         this.soldeMvts = var3 - var1;
      } else {
         this.soldeMvts = var1 - var3;
      }

      if (this.soldeMvts == 0.0D && (this.totalMvtscredit != 0.0D || this.totalMvtsdebit != 0.0D)) {
         this.testValiderSaisie = true;
         this.testAnnulerSaisie = true;
      } else {
         this.testValiderSaisie = false;
         if (this.soldeMvts == 0.0D && this.lesEcritures.size() == 0) {
            this.testAnnulerSaisie = true;
         } else {
            this.testAnnulerSaisie = false;
         }
      }

   }

   public void saveGlobal() throws NamingException, ParseException {
      if (this.lesEcritures.size() != 0) {
         this.saveBrouillard(0);
         this.journauxMois.setJoumenSaisie(1);
         this.journauxMois = this.journauxMoisDao.majJournal(this.journauxMois);
         this.testAffMAjbrouillard = false;
         this.testAffSupbrouillard = false;
         this.var_action = 0;
      }

   }

   public void saveGlobalEtValideJour() throws NamingException, ParseException {
      if (this.lesEcritures.size() != 0) {
         this.saveBrouillard(1);
         this.journauxMois.setJoumenSaisie(1);
         this.journauxMois = this.journauxMoisDao.majJournal(this.journauxMois);
         this.testAffMAjbrouillard = false;
         this.testAffSupbrouillard = false;
         this.chargerLesBrouillardsJour();
         this.var_action = 0;
      }

   }

   public void saveGlobalEtValideMois() throws NamingException, ParseException {
      if (this.lesEcritures.size() != 0) {
         this.saveBrouillard(1);
         this.journauxMois.setJoumenSaisie(1);
         this.journauxMois = this.journauxMoisDao.majJournal(this.journauxMois);
         this.testAffMAjbrouillard = false;
         this.testAffSupbrouillard = false;
         this.chargerLesBrouillardsMois();
         this.var_action = 0;
      }

   }

   public void saveBrouillard(int var1) throws NamingException, ParseException {
      this.calculTotalDebCredMvts();
      this.brouillard.setExercicescomptable(this.selectedExo);
      this.brouillard.setBroAnnee("" + this.selectedExo.getExecpt_id());
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Brouillard");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.setFlushMode(FlushMode.MANUAL);
         this.brouillard.setBroDateSaisie(this.calculdateSasisie());
         this.brouillard.setBroCloture(0);
         this.brouillard.setBroEtat(var1);
         this.brouillard.setBroJour(this.brouillard.getBroDateSaisie().getDate());
         this.verifExitChronoJournal(var2);
         if (this.brouillard.getBro_id() == 0L) {
            this.brouillard.setBroDateCreat(new Date());
            this.brouillard.setBroUserCreat(this.usersLog.getUsrid());
            this.brouillard.setBroNum(this.numComposeBrouillard(this.code, this.periode, var2));
            if (this.verrouPiece) {
               this.brouillard.setBroPiece(this.numComposeJournal(var2));
            }

            this.brouillard = this.brouillardDao.insert(this.brouillard, var2);
            var2.flush();
            this.lesBrouillards.add(this.brouillard);
            this.dataModelLesBrouillards.setWrappedData(this.lesBrouillards);
         } else {
            this.brouillard.setBroDateModif(new Date());
            this.brouillard.setBroUserModif(this.usersLog.getUsrid());
            this.brouillard.setBroCoefEuro(this.utilNombre.deviseTaux1(this.brouillard.getBroDeviseSaisie(), this.brouillard.getBroDateSaisie()));
            this.brouillard.setBroDebitEuro(this.utilNombre.myRoundFormat(this.brouillard.getBroDebitSaisie() * (double)this.brouillard.getBroCoefEuro(), 1));
            this.brouillard.setBroCreditEuro(this.utilNombre.myRoundFormat(this.brouillard.getBroCreditSaisie() * (double)this.brouillard.getBroCoefEuro(), 1));
            this.brouillard.setBroDevisePays(this.structureLog.getStrdevise());
            if (this.brouillard.getBroDevisePays().equalsIgnoreCase(this.brouillard.getBroDeviseSaisie())) {
               this.brouillard.setBroCoefPays(1.0F);
               this.brouillard.setBroDebitPays(this.brouillard.getBroDebitSaisie());
               this.brouillard.setBroCreditPays(this.brouillard.getBroCreditSaisie());
            } else {
               this.brouillard.setBroCoefPays(this.utilNombre.deviseTaux2(this.brouillard.getBroDevisePays(), this.brouillard.getBroDateSaisie()));
               this.brouillard.setBroDebitPays(this.utilNombre.myRoundDevise(this.brouillard.getBroDebitSaisie() * (double)this.brouillard.getBroCoefPays(), this.brouillard.getBroDevisePays()));
               this.brouillard.setBroCreditPays(this.utilNombre.myRoundDevise(this.brouillard.getBroCreditSaisie() * (double)this.brouillard.getBroCoefPays(), this.brouillard.getBroDevisePays()));
            }

            this.brouillard.setBroDeviseGrp(this.structureLog.getStrdevise());
            this.brouillard.setBroCoefGrp(1.0F);
            this.brouillard.setBroDebitGrp(this.brouillard.getBroDebitSaisie());
            this.brouillard.setBroCreditGrp(this.brouillard.getBroCreditSaisie());
            this.brouillard = this.brouillardDao.modif(this.brouillard, var2);
            var2.flush();
         }

         this.affichePj();
         if (this.lesEcritures.size() != 0) {
            for(int var4 = 0; var4 < this.lesEcritures.size(); ++var4) {
               this.ecritures = (Ecritures)this.lesEcritures.get(var4);
               this.ecritures.setEcrEtat(var1);
               if (this.brouillard.isBroPj()) {
                  if (this.ecritures.getEcrNature() != 6 && this.ecritures.getEcrNature() != 7 && this.ecritures.getEcrNature() != 10 && this.ecritures.getEcrNature() != 11) {
                     this.ecritures.setEcrPj(false);
                  } else {
                     this.ecritures.setEcrPj(true);
                  }
               } else {
                  this.ecritures.setEcrPj(false);
               }

               this.ecritures = this.ecrituresDao.modif(this.ecritures, var2);
               var2.flush();
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

      this.calculTotalDebCredMvts();
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
         this.memoJour = 1;
      } else {
         this.memoCompte = this.ecritures.getEcrCompte();
         this.memoCP = this.ecritures.getEcrContrePartie();
         this.memoDteEche = this.ecritures.getEcrDateEcheance();
         this.memoDteVal = this.ecritures.getEcrDateValeurTheo();
         this.memoRef1 = this.ecritures.getEcrReference1();
         this.memoRef2 = this.ecritures.getEcrReference2();
         this.memoPiece = this.ecritures.getEcrPiece();
         this.memoLib = this.ecritures.getEcrLibelle();
         if (this.totalMvtsdebit > this.totalMvtscredit) {
            this.memoDebit = this.totalMvtsdebit - this.totalMvtscredit;
            this.memoCredit = 0.0D;
         } else {
            this.memoDebit = 0.0D;
            this.memoCredit = this.totalMvtscredit - this.totalMvtsdebit;
         }

         this.memoNatCompte = this.ecritures.getEcrNature();
         this.memoJour = this.ecritures.getEcrJour();
         if (this.journauxComptables.getPljNature() == 7 || this.journauxComptables.getPljNature() == 8 || this.journauxComptables.getPljNature() == 9 || this.journauxComptables.getPljNature() == 10) {
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

   }

   public Date calculdateSasisie() throws ParseException {
      String var1 = this.brouillard.getBroPeriode();
      int var2 = this.brouillard.getBroJour();
      String[] var3 = var1.split(":");
      String var4 = var3[0];
      String var5 = var3[1];
      String var6 = null;
      if (var2 <= 9) {
         var6 = var5 + "-" + var4 + "-0" + var2;
      } else {
         var6 = var5 + "-" + var4 + "-" + var2;
      }

      SimpleDateFormat var7 = new SimpleDateFormat("yyyy-MM-dd");
      Date var8 = var7.parse(var6);
      return var8;
   }

   public void saveLigneEcriture() throws NamingException, JDOMException, IOException, ParseException {
      if (this.brouillard.getBro_id() == 0L) {
         this.saveBrouillard(0);
      } else {
         this.calculTotalDebCredMvts();
      }

      if (this.ecritures.getEcrCompte() != null && !this.ecritures.getEcrCompte().isEmpty() && (this.ecritures.getEcrDebitSaisie() != 0.0D || this.ecritures.getEcrCreditSaisie() != 0.0D)) {
         this.ecritures.setEcrCode(this.journauxComptables.getPljCode());
         this.ecritures.setEcrNatureJrx(this.journauxComptables.getPljNature());
         this.ecritures.setEcrReserve(this.journauxComptables.getPljReserve());
         String var1 = "" + (this.brouillard.getBroDateSaisie().getYear() + 1900);
         String var2 = "";
         if (this.brouillard.getBroDateSaisie().getMonth() + 1 <= 9) {
            var2 = "0" + (this.brouillard.getBroDateSaisie().getMonth() + 1);
         } else {
            var2 = "" + (this.brouillard.getBroDateSaisie().getMonth() + 1);
         }

         String var3 = "";
         if (this.brouillard.getBroDateSaisie().getDate() <= 9) {
            var3 = "0" + this.brouillard.getBroDateSaisie().getDate();
         } else {
            var3 = "" + this.brouillard.getBroDateSaisie().getDate();
         }

         this.ecritures.setEcrAnnee(var1);
         this.ecritures.setEcrDateSaisie(this.brouillard.getBroDateSaisie());
         this.ecritures.setEcrEtat(0);
         this.ecritures.setEcrJour(this.brouillard.getBroJour());
         this.ecritures.setEcrPeriode(this.brouillard.getBroPeriode());
         this.ecritures.setEcrPiece(this.brouillard.getBroPiece());
         if (this.ecritures.getEcrLibelle() == null || this.ecritures.getEcrLibelle().isEmpty()) {
            this.ecritures.setEcrLibelle(this.brouillard.getBroLibelle());
         }

         this.ecritures.setEcrReference1(this.brouillard.getBroReference1());
         this.ecritures.setEcrReference2(this.brouillard.getBroReference2());
         this.ecritures.setEcrCle1(this.ecritures.getEcrCode() + ":" + this.ecritures.getEcrPeriode());
         this.ecritures.setEcrCle2(this.ecritures.getEcrCode() + ":" + var1 + ":" + var2 + ":" + var3);
         this.ecritures.setEcrOrdre(0L);
         this.ecritures.setEcrDeviseSaisie(this.brouillard.getBroDeviseSaisie());
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
            this.ecritures.setEcrDateCreat(new Date());
            this.ecritures.setEcrUserCreat(this.usersLog.getUsrid());
            this.ecritures.setExercicesComptable(this.selectedExo);
            this.ecritures.setBrouillard(this.brouillard);
            this.ecritures = this.ecrituresDao.insertBrouillard(this.ecritures);
            this.lesEcritures.add(this.ecritures);
            this.dataModelLesEcritures.setWrappedData(this.lesEcritures);
         } else {
            this.ecritures = this.ecrituresDao.modifBrouillard(this.ecritures);
         }
      }

      this.calculTotalDebCredMvts();
      this.var_memo_ligne_gene = 0L;
      if (this.optionComptabilite.getAnalytique().equals("true") && this.journauxComptables.getPljAnalytique() == 0) {
         boolean var4 = this.testCompteAnalytique();
         if (var4) {
            if (var4) {
               this.ecritures.setEcrAnaActif(1);
               this.var_memo_ligne_gene = this.ecritures.getEcr_id();
               this.formAnalytique.initAnalytique(this.optionComptabilite, (Session)null);
               this.formAnalytique.chargementDetailAnalytique(this.ecritures, false, (Session)null);
               this.showModalPanelAnalytique = true;
            } else if (!var4) {
               this.formAnalytique.nettoyageDetailAnalytique((Ecritures)this.ecritures, (Session)null);
               if (this.ecritures.getEcrAnaActif() == 1) {
                  this.ecritures.setEcrAnaActif(0);
                  this.ecritures = this.ecrituresDao.modif(this.ecritures);
               }
            }
         }
      }

      this.calculeLigneSuivante((Session)null);
   }

   public void calculSens() {
      if (this.planComptable.getPlcNature() == 6) {
         if (this.journauxComptables.getPljNature() != 7 && this.journauxComptables.getPljNature() != 8 && this.journauxComptables.getPljNature() != 9 && this.journauxComptables.getPljNature() != 10) {
            this.valindexD = 0;
            this.valindexC = 14;
         } else {
            this.valindexD = 13;
            this.valindexC = 0;
         }
      } else if (this.planComptable.getPlcNature() == 7) {
         if (this.journauxComptables.getPljNature() != 7 && this.journauxComptables.getPljNature() != 8 && this.journauxComptables.getPljNature() != 9 && this.journauxComptables.getPljNature() != 10) {
            this.valindexD = 13;
            this.valindexC = 0;
         } else {
            this.valindexD = 0;
            this.valindexC = 14;
         }
      } else if (this.planComptable.getPlcNature() == 16) {
         if (this.journauxComptables.getPljNature() == 1) {
            this.valindexD = 13;
            this.valindexC = 0;
         } else {
            this.valindexD = 13;
            this.valindexC = 14;
         }
      } else if (this.planComptable.getPlcNature() == 17) {
         if (this.journauxComptables.getPljNature() == 2) {
            this.valindexD = 0;
            this.valindexC = 14;
         } else {
            this.valindexD = 13;
            this.valindexC = 14;
         }
      } else {
         this.valindexD = 13;
         this.valindexC = 14;
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
                     var3 = this.utilNombre.myRoundFormat(var3, this.journauxComptables.getPljFormatDevise());
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
                  var3 = this.utilNombre.myRoundFormat(var3, this.journauxComptables.getPljFormatDevise());
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
               var5 = this.planComptable.getPlcTauxTaxe();
               var3 = var1 * (double)var5 / 100.0D;
               var3 = this.utilNombre.myRoundFormat(var3, this.journauxComptables.getPljFormatDevise());
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
            var3 = this.utilNombre.myRoundFormat(var3, this.journauxComptables.getPljFormatDevise());
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

   public void calculeLigneSuivante(Session var1) throws NamingException, JDOMException, IOException {
      if (!this.var_modif) {
         this.ajouterLigne();
         this.ecritures = new Ecritures();
         if (this.cpTreso != null && !this.cpTreso.isEmpty() && this.totalMvtsdebit != this.totalMvtscredit) {
            this.ecritures.setEcrCompte(this.cpTreso);
            if (this.totalMvtsdebit >= this.totalMvtscredit) {
               this.ecritures.setEcrDebitSaisie(0.0D);
               this.ecritures.setEcrCreditSaisie(this.soldeMvts);
            } else {
               this.ecritures.setEcrDebitSaisie(this.soldeMvts);
               this.ecritures.setEcrCreditSaisie(0.0D);
            }
         }

         this.ecritures.setEcrJour(this.memoJour);
         this.ecritures.setEcrLibelle(this.memoLib);
         this.ecritures.setEcrPiece(this.memoPiece);
         this.ecritures.setEcrReference1(this.memoRef1);
         this.ecritures.setEcrReference2(this.memoRef2);
         if (this.ecritures.getEcrCompte() != null && !this.ecritures.getEcrCompte().isEmpty()) {
            this.planComptable = this.formRecherche.rechercheCompte(this.ecritures.getEcrCompte(), this.selectedExo.getExecpt_id());
            if (this.planComptable != null) {
               this.calculePlanComptable();
            }
         }

         this.testAffMAjbrouillardLigne = false;
      }

   }

   public JournauxComptables trouverJournal(Session var1) throws HibernateException, NamingException, ParseException {
      this.journauxComptables = new JournauxComptables();
      this.journauxComptables = this.journauxComptablesDao.rechercheJCByCode(this.code, this.usersLog.getUsrJrxReserve(), this.selectedExo.getExecpt_id(), var1);
      this.chargerLesDevises(var1);
      this.journauxMois = new JournauxMois();
      String var2 = this.brouillard.getBroCode() + ":" + this.brouillard.getBroPeriode();
      this.journauxMois = this.journauxMoisDao.recupererJournauxMois(var2, this.selectedExo, var1);
      this.selecFiscalite = this.structureLog.getStrzonefiscale();
      if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty()) {
         String[] var3 = this.periode.split(":");
         String var4 = var3[0];
         String var5 = var3[1];
         Date var6 = this.utilDate.stringToDateSQLLight(var5 + "-" + var4 + "-" + "01");
         long var7 = (long)(var6.getYear() + 1900);
         if (this.structureLog.getStrdatefiscale2() != null && (var6.compareTo(this.structureLog.getStrdatefiscale2()) > 0 || var7 >= (long)(this.structureLog.getStrdatefiscale2().getYear() + 1900))) {
            this.selecFiscalite = this.structureLog.getStrzonefiscale2();
         }
      }

      this.calculeCompteTreso(this.journauxComptables, this.periode);
      return this.journauxComptables;
   }

   public void verifExitChronoJournal(Session var1) throws HibernateException, NamingException {
      this.verrouPiece = false;
      int var2 = this.journauxComptables.getPljPiece();
      this.chronoEcriture = new Chrono();
      String var3 = "" + (this.brouillard.getBroDateSaisie().getYear() + 1900);
      this.chronoEcriture = this.chronoDao.chronoByNatAndJournalPeriode(53, this.code, var3, var1);
      if (var2 != 0 && this.chronoEcriture != null) {
         this.verrouPiece = true;
      }

   }

   public String numComposeJournal(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      long var3 = 0L;
      if (this.verrouPiece) {
         if (this.journauxComptables.getPljPiece() == 1) {
            var3 = this.enregitrerNumeroJournal(var1);
         } else if (this.journauxComptables.getPljPiece() == 2 && this.totalMvtscredit == this.totalMvtsdebit) {
            var3 = this.enregitrerNumeroJournal(var1);
         }

         var2 = this.calculChronoEcriture.formattageChrono(this.chronoEcriture, var3, this.journauxComptables.getPljCode(), "", this.brouillard.getBroDateSaisie());
      } else {
         var2 = "" + this.brouillard.getBroPiece();
      }

      return var2;
   }

   public long enregitrerNumeroJournal(Session var1) throws HibernateException, NamingException {
      long var2 = 0L;
      if (this.chronoEcriture.getChrMode() == 0) {
         this.chronoEcriture.setChrNumAn(this.chronoEcriture.getChrNumAn() + 1L);
         var2 = this.chronoEcriture.getChrNumAn();
      } else if (this.chronoEcriture.getChrMode() == 1) {
         String[] var4 = this.periode.split(":");
         String var5 = var4[0];
         if (var5.equalsIgnoreCase("01")) {
            this.chronoEcriture.setChrNum01(this.chronoEcriture.getChrNum01() + 1L);
            var2 = this.chronoEcriture.getChrNum01();
         } else if (var5.equalsIgnoreCase("02")) {
            this.chronoEcriture.setChrNum02(this.chronoEcriture.getChrNum02() + 1L);
            var2 = this.chronoEcriture.getChrNum02();
         } else if (var5.equalsIgnoreCase("03")) {
            this.chronoEcriture.setChrNum03(this.chronoEcriture.getChrNum03() + 1L);
            var2 = this.chronoEcriture.getChrNum03();
         } else if (var5.equalsIgnoreCase("04")) {
            this.chronoEcriture.setChrNum04(this.chronoEcriture.getChrNum04() + 1L);
            var2 = this.chronoEcriture.getChrNum04();
         } else if (var5.equalsIgnoreCase("05")) {
            this.chronoEcriture.setChrNum05(this.chronoEcriture.getChrNum05() + 1L);
            var2 = this.chronoEcriture.getChrNum05();
         } else if (var5.equalsIgnoreCase("06")) {
            this.chronoEcriture.setChrNum06(this.chronoEcriture.getChrNum06() + 1L);
            var2 = this.chronoEcriture.getChrNum06();
         } else if (var5.equalsIgnoreCase("07")) {
            this.chronoEcriture.setChrNum07(this.chronoEcriture.getChrNum07() + 1L);
            var2 = this.chronoEcriture.getChrNum07();
         } else if (var5.equalsIgnoreCase("08")) {
            this.chronoEcriture.setChrNum08(this.chronoEcriture.getChrNum08() + 1L);
            var2 = this.chronoEcriture.getChrNum08();
         } else if (var5.equalsIgnoreCase("09")) {
            this.chronoEcriture.setChrNum09(this.chronoEcriture.getChrNum09() + 1L);
            var2 = this.chronoEcriture.getChrNum09();
         } else if (var5.equalsIgnoreCase("10")) {
            this.chronoEcriture.setChrNum10(this.chronoEcriture.getChrNum10() + 1L);
            var2 = this.chronoEcriture.getChrNum10();
         } else if (var5.equalsIgnoreCase("11")) {
            this.chronoEcriture.setChrNum11(this.chronoEcriture.getChrNum11() + 1L);
            var2 = this.chronoEcriture.getChrNum11();
         } else if (var5.equalsIgnoreCase("12")) {
            this.chronoEcriture.setChrNum12(this.chronoEcriture.getChrNum12() + 1L);
            var2 = this.chronoEcriture.getChrNum12();
         }
      } else if (this.chronoEcriture.getChrMode() == 2) {
         this.chronoEcriture.setChrNum(this.chronoEcriture.getChrNum() + 1L);
         var2 = this.chronoEcriture.getChrNum();
      }

      this.chronoDao.modifierChrono(this.chronoEcriture, var1);
      return var2;
   }

   public long numComposeBrouillard(String var1, String var2, Session var3) throws HibernateException, NamingException {
      long var4 = 0L;
      var4 = this.brouillardDao.chercherDernierBrouillard(var1, var2, this.usersLog.getUsrid(), this.selectedExo.getExecpt_id(), var3);
      var3.flush();
      return var4;
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

   public void validationLignes() {
      this.var_choix_validation = 0;
      this.var_jourDebut = 1;
      this.var_jourFin = Integer.parseInt(((SelectItem)this.lesjoursItems.get(this.lesjoursItems.size() - 1)).getValue().toString());
      this.lesPiecesSelectionnes.clear();
      new EcrituresLight();
      if (this.lesBrouillards.size() != 0) {
         for(int var2 = 0; var2 < this.lesBrouillards.size(); ++var2) {
            if (((Brouillard)this.lesBrouillards.get(var2)).getBroEtat() == 0) {
               String var3 = ((Brouillard)this.lesBrouillards.get(var2)).getBroPiece();
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
      if (this.lesBrouillards.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            int var3;
            String var4;
            int var5;
            List var13;
            if (this.var_choix_validation == 0) {
               for(var3 = 0; var3 < this.lesBrouillards.size(); ++var3) {
                  this.brouillard = new Brouillard();
                  this.brouillard = (Brouillard)this.lesBrouillards.get(var3);
                  if (this.brouillard.getBroJour() >= this.var_jourDebut && this.brouillard.getBroJour() <= this.var_jourFin && this.brouillard.getBroEtat() == 0) {
                     this.brouillard.setBroEtat(1);
                     this.brouillard = this.brouillardDao.modif(this.brouillard, var1);
                     var1.flush();
                  }
               }

               new ArrayList();
               var4 = this.code + ":" + this.periode;
               var13 = this.ecrituresDao.ChargerLesEcritures(var4, 1, this.selectedExo.getExecpt_id(), var1);
               if (var13.size() != 0) {
                  for(var5 = 0; var5 < var13.size(); ++var5) {
                     this.ecritures = new Ecritures();
                     this.ecritures = (Ecritures)var13.get(var5);
                     if (this.ecritures.getEcrJour() >= this.var_jourDebut && this.ecritures.getEcrJour() <= this.var_jourFin && this.ecritures.getEcrEtat() == 0 && this.ecritures.getEcrUserCreat() == this.idProprietaire) {
                        this.ecritures.setEcrEtat(1);
                        this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
                        var1.flush();
                     }
                  }
               }
            } else if (this.lesPiecesSelectionnes.size() != 0) {
               var3 = 0;

               label253:
               while(true) {
                  if (var3 >= this.lesPiecesSelectionnes.size()) {
                     new ArrayList();
                     var4 = this.code + ":" + this.periode;
                     var13 = this.ecrituresDao.ChargerLesEcritures(var4, 1, this.selectedExo.getExecpt_id(), var1);
                     if (var13.size() == 0) {
                        break;
                     }

                     var5 = 0;

                     while(true) {
                        if (var5 >= this.lesPiecesSelectionnes.size()) {
                           break label253;
                        }

                        if (((EcrituresLight)this.lesPiecesSelectionnes.get(var5)).isSelect()) {
                           String var6 = ((EcrituresLight)this.lesPiecesSelectionnes.get(var5)).getEcrPiece();

                           for(int var7 = 0; var7 < var13.size(); ++var7) {
                              this.ecritures = new Ecritures();
                              this.ecritures = (Ecritures)var13.get(var7);
                              if (this.ecritures.getEcrPiece().equals(var6) && this.ecritures.getEcrEtat() == 0 && this.ecritures.getEcrUserCreat() == this.idProprietaire) {
                                 this.ecritures.setEcrEtat(1);
                                 this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
                                 var1.flush();
                              }
                           }
                        }

                        ++var5;
                     }
                  }

                  if (((EcrituresLight)this.lesPiecesSelectionnes.get(var3)).isSelect()) {
                     var4 = ((EcrituresLight)this.lesPiecesSelectionnes.get(var3)).getEcrPiece();

                     for(var5 = 0; var5 < this.lesBrouillards.size(); ++var5) {
                        this.brouillard = new Brouillard();
                        this.brouillard = (Brouillard)this.lesBrouillards.get(var5);
                        if (this.brouillard.getBroPiece().equals(var4) && this.brouillard.getBroEtat() == 0) {
                           this.brouillard.setBroEtat(1);
                           this.brouillard = this.brouillardDao.modif(this.brouillard, var1);
                           var1.flush();
                        }
                     }
                  }

                  ++var3;
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

      this.testsaisibrouillard = false;
      this.showModalPanelValidation = false;
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
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_gene" + File.separator + "brouillard";
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
      if (var4 != null && !var4.isEmpty()) {
         if (var1 == null) {
            var1 = new UtilPrint(this.utilInitHibernate);
         }

         var1.setRapport(var4);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_gene" + File.separator + "brouillard" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
         var1.setEntete("Impression Brouillard");
         var1.setFiltre("Saisie par " + this.nomProprietaire);
         String var11 = "";
         if (this.modeImp == 1) {
            var11 = "bro_periode='" + this.periode + "' and bro_user_creat=" + this.idProprietaire;
         } else if (this.modeImp == 2) {
            var11 = "bro_code='" + this.code + "' and bro_periode='" + this.periode + "' and bro_user_creat=" + this.idProprietaire;
         } else if (this.modeImp == 3) {
            var11 = "cpt_ecritures.`bro_id`=" + this.brouillard.getBro_id();
         } else {
            String[] var12;
            String var13;
            String var14;
            if (this.modeImp == 11) {
               var12 = this.periode.split(":");
               var13 = "";
               if (this.jour.length() == 1) {
                  var13 = "0" + this.jour;
               } else {
                  var13 = this.jour;
               }

               var14 = var12[1] + "-" + var12[0] + "-" + var13;
               var11 = "bro_date_saisie='" + var14 + "' and bro_user_creat=" + this.idProprietaire;
            } else if (this.modeImp == 12) {
               var12 = this.periode.split(":");
               var13 = "";
               if (this.jour.length() == 1) {
                  var13 = "0" + this.jour;
               } else {
                  var13 = this.jour;
               }

               var14 = var12[1] + "-" + var12[0] + "-" + var13;
               var11 = "bro_code='" + this.code + "' and bro_date_saisie='" + var14 + "' and bro_user_creat=" + this.idProprietaire;
            }
         }

         var1.setNomMapping("Brouillard");
         var1.setRequete(var11);
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataireCC(var8);
         var1.setDestinataireCCI(var9);
         var1.setCorpsMail(var10);
         var1.setTiersSelectionne((Tiers)null);
         ArrayList var15 = new ArrayList();
         JRBeanCollectionDataSource var16 = new JRBeanCollectionDataSource(var15);
         var1.setjRBeanCollectionDataSource(var16);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

   }

   public Brouillard getBrouillard() {
      return this.brouillard;
   }

   public void setBrouillard(Brouillard var1) {
      this.brouillard = var1;
   }

   public DataModel getDataModelLesBrouillards() {
      return this.dataModelLesBrouillards;
   }

   public void setDataModelLesBrouillards(DataModel var1) {
      this.dataModelLesBrouillards = var1;
   }

   public List getLesJournauxComptables() {
      return this.lesJournauxComptables;
   }

   public void setLesJournauxComptables(List var1) {
      this.lesJournauxComptables = var1;
   }

   public List getLesPeriodes() {
      return this.lesPeriodes;
   }

   public void setLesPeriodes(List var1) {
      this.lesPeriodes = var1;
   }

   public boolean isTestsaisibrouillard() {
      return this.testsaisibrouillard;
   }

   public void setTestsaisibrouillard(boolean var1) {
      this.testsaisibrouillard = var1;
   }

   public boolean isTestAffMAjbrouillard() {
      return this.testAffMAjbrouillard;
   }

   public void setTestAffMAjbrouillard(boolean var1) {
      this.testAffMAjbrouillard = var1;
   }

   public boolean isTestValiderSaisie() {
      return this.testValiderSaisie;
   }

   public void setTestValiderSaisie(boolean var1) {
      this.testValiderSaisie = var1;
   }

   public double getTotalBroCred() {
      return this.totalBroCred;
   }

   public void setTotalBroCred(double var1) {
      this.totalBroCred = var1;
   }

   public double getTotalBroDeb() {
      return this.totalBroDeb;
   }

   public void setTotalBroDeb(double var1) {
      this.totalBroDeb = var1;
   }

   public double getSoldeTotal() {
      return this.soldeTotal;
   }

   public void setSoldeTotal(double var1) {
      this.soldeTotal = var1;
   }

   public boolean isTestAffMAjbrouillardLigne() {
      return this.testAffMAjbrouillardLigne;
   }

   public void setTestAffMAjbrouillardLigne(boolean var1) {
      this.testAffMAjbrouillardLigne = var1;
   }

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public List getLesModelsimpression() {
      return this.lesModelsimpression;
   }

   public void setLesModelsimpression(List var1) {
      this.lesModelsimpression = var1;
   }

   public List getLesjoursItems() {
      return this.lesjoursItems;
   }

   public void setLesjoursItems(List var1) {
      this.lesjoursItems = var1;
   }

   public int getModeImp() {
      return this.modeImp;
   }

   public void setModeImp(int var1) {
      this.modeImp = var1;
   }

   public UtilNombre getUtilNombre() {
      return this.utilNombre;
   }

   public void setUtilNombre(UtilNombre var1) {
      this.utilNombre = var1;
   }

   public boolean isVerrouPiece() {
      return this.verrouPiece;
   }

   public void setVerrouPiece(boolean var1) {
      this.verrouPiece = var1;
   }

   public Date getDatePeriode() {
      return this.datePeriode;
   }

   public void setDatePeriode(Date var1) {
      this.datePeriode = var1;
   }

   public ExercicesComptable getLastExo() {
      return this.lastExo;
   }

   public void setLastExo(ExercicesComptable var1) {
      this.lastExo = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
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

   public JournauxComptables getJournauxComptables() {
      return this.journauxComptables;
   }

   public void setJournauxComptables(JournauxComptables var1) {
      this.journauxComptables = var1;
   }

   public List getLesBrouillards() {
      return this.lesBrouillards;
   }

   public void setLesBrouillards(List var1) {
      this.lesBrouillards = var1;
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

   public UtilDate getUtilDate() {
      return this.utilDate;
   }

   public void setUtilDate(UtilDate var1) {
      this.utilDate = var1;
   }

   public boolean isJournalVide() {
      return this.journalVide;
   }

   public void setJournalVide(boolean var1) {
      this.journalVide = var1;
   }

   public boolean isPeriodeVide() {
      return this.periodeVide;
   }

   public void setPeriodeVide(boolean var1) {
      this.periodeVide = var1;
   }

   public boolean isPieceVide() {
      return this.pieceVide;
   }

   public void setPieceVide(boolean var1) {
      this.pieceVide = var1;
   }

   public double getSoldeMvts() {
      return this.soldeMvts;
   }

   public void setSoldeMvts(double var1) {
      this.soldeMvts = var1;
   }

   public String getPropritaire() {
      return this.propritaire;
   }

   public void setPropritaire(String var1) {
      this.propritaire = var1;
   }

   public List getLesuserItems() {
      return this.lesuserItems;
   }

   public void setLesuserItems(List var1) {
      this.lesuserItems = var1;
   }

   public long getIdProprietaire() {
      return this.idProprietaire;
   }

   public void setIdProprietaire(long var1) {
      this.idProprietaire = var1;
   }

   public String getNomProprietaire() {
      return this.nomProprietaire;
   }

   public void setNomProprietaire(String var1) {
      this.nomProprietaire = var1;
   }

   public boolean isTestAffSupbrouillard() {
      return this.testAffSupbrouillard;
   }

   public void setTestAffSupbrouillard(boolean var1) {
      this.testAffSupbrouillard = var1;
   }

   public boolean isTestAffValbrouillard() {
      return this.testAffValbrouillard;
   }

   public void setTestAffValbrouillard(boolean var1) {
      this.testAffValbrouillard = var1;
   }

   public DataModel getDataModelLesEcritures() {
      return this.dataModelLesEcritures;
   }

   public void setDataModelLesEcritures(DataModel var1) {
      this.dataModelLesEcritures = var1;
   }

   public Ecritures getEcritures() {
      return this.ecritures;
   }

   public void setEcritures(Ecritures var1) {
      this.ecritures = var1;
   }

   public List getLesEcritures() {
      return this.lesEcritures;
   }

   public void setLesEcritures(List var1) {
      this.lesEcritures = var1;
   }

   public PlanComptable getPlanComptable() {
      return this.planComptable;
   }

   public void setPlanComptable(PlanComptable var1) {
      this.planComptable = var1;
   }

   public List getLesDevises() {
      return this.lesDevises;
   }

   public void setLesDevises(List var1) {
      this.lesDevises = var1;
   }

   public int getEtat() {
      return this.etat;
   }

   public void setEtat(int var1) {
      this.etat = var1;
   }

   public JournauxMois getJournauxMois() {
      return this.journauxMois;
   }

   public void setJournauxMois(JournauxMois var1) {
      this.journauxMois = var1;
   }

   public boolean isTestAnnulerSaisie() {
      return this.testAnnulerSaisie;
   }

   public void setTestAnnulerSaisie(boolean var1) {
      this.testAnnulerSaisie = var1;
   }

   public boolean isShowModalPanelAnalytique() {
      return this.showModalPanelAnalytique;
   }

   public void setShowModalPanelAnalytique(boolean var1) {
      this.showModalPanelAnalytique = var1;
   }

   public boolean isVar_affiche_analytique() {
      return this.var_affiche_analytique;
   }

   public void setVar_affiche_analytique(boolean var1) {
      this.var_affiche_analytique = var1;
   }

   public boolean isVar_saisieProprietaire() {
      return this.var_saisieProprietaire;
   }

   public void setVar_saisieProprietaire(boolean var1) {
      this.var_saisieProprietaire = var1;
   }

   public String getJour() {
      return this.jour;
   }

   public void setJour(String var1) {
      this.jour = var1;
   }

   public boolean isShowModalPanelValidation() {
      return this.showModalPanelValidation;
   }

   public void setShowModalPanelValidation(boolean var1) {
      this.showModalPanelValidation = var1;
   }

   public int getVar_choix_validation() {
      return this.var_choix_validation;
   }

   public void setVar_choix_validation(int var1) {
      this.var_choix_validation = var1;
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

   public List getLesPiecesSelectionnes() {
      return this.lesPiecesSelectionnes;
   }

   public void setLesPiecesSelectionnes(List var1) {
      this.lesPiecesSelectionnes = var1;
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

   public String getVar_nouveau_numero() {
      return this.var_nouveau_numero;
   }

   public void setVar_nouveau_numero(String var1) {
      this.var_nouveau_numero = var1;
   }

   public String getVar_ancien_numero() {
      return this.var_ancien_numero;
   }

   public void setVar_ancien_numero(String var1) {
      this.var_ancien_numero = var1;
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

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public FormAnalytique getFormAnalytique() {
      return this.formAnalytique;
   }

   public void setFormAnalytique(FormAnalytique var1) {
      this.formAnalytique = var1;
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

   public boolean isVar_affiche_dossier() {
      return this.var_affiche_dossier;
   }

   public void setVar_affiche_dossier(boolean var1) {
      this.var_affiche_dossier = var1;
   }

   public List getLesModelesAutorises() {
      return this.lesModelesAutorises;
   }

   public void setLesModelesAutorises(List var1) {
      this.lesModelesAutorises = var1;
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

   public int getModePj() {
      return this.modePj;
   }

   public void setModePj(int var1) {
      this.modePj = var1;
   }

   public boolean isShowModalPanelAjoutPJ() {
      return this.showModalPanelAjoutPJ;
   }

   public void setShowModalPanelAjoutPJ(boolean var1) {
      this.showModalPanelAjoutPJ = var1;
   }

   public boolean isShowModalPanelPJ() {
      return this.showModalPanelPJ;
   }

   public void setShowModalPanelPJ(boolean var1) {
      this.showModalPanelPJ = var1;
   }

   public UploadedFile getUploadedFile() {
      return this.uploadedFile;
   }

   public void setUploadedFile(UploadedFile var1) {
      this.uploadedFile = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public String getUrlphotoProd() {
      return this.urlphotoProd;
   }

   public void setUrlphotoProd(String var1) {
      this.urlphotoProd = var1;
   }

   public boolean isConditionPj() {
      return this.conditionPj;
   }

   public void setConditionPj(boolean var1) {
      this.conditionPj = var1;
   }

   public String getCpTreso() {
      return this.cpTreso;
   }

   public void setCpTreso(String var1) {
      this.cpTreso = var1;
   }

   public int getTypeFichier() {
      return this.typeFichier;
   }

   public void setTypeFichier(int var1) {
      this.typeFichier = var1;
   }

   public String getValueScanPj() {
      return this.valueScanPj;
   }

   public void setValueScanPj(String var1) {
      this.valueScanPj = var1;
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

   public DataModel getDataModelPjSecretariat() {
      return this.dataModelPjSecretariat;
   }

   public void setDataModelPjSecretariat(DataModel var1) {
      this.dataModelPjSecretariat = var1;
   }
}
