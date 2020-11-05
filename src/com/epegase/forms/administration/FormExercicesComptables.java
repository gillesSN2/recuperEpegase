package com.epegase.forms.administration;

import com.epegase.forms.comptabilite.FormAmortissements;
import com.epegase.systeme.classe.AmortissementTab;
import com.epegase.systeme.classe.Brouillard;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.ComplementInformations;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresAnalytique;
import com.epegase.systeme.classe.EcrituresAnterieur;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.JournauxMois;
import com.epegase.systeme.classe.Loyer;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.PlansBudgetaires;
import com.epegase.systeme.classe.PlansTresorerie;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TabResultats;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.EcrituresLight;
import com.epegase.systeme.dao.AmortissementTabDao;
import com.epegase.systeme.dao.BrouillardDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.ComplementInformationsDao;
import com.epegase.systeme.dao.EcrituresAnalytiquesDao;
import com.epegase.systeme.dao.EcrituresAnterieurDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.JournauxMoisDao;
import com.epegase.systeme.dao.LoyerDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PlansBudgetairesDao;
import com.epegase.systeme.dao.PlansTresorerieDao;
import com.epegase.systeme.dao.TabResultatsDao;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.utilitaires.FormUtilitaires;
import com.epegase.systeme.xml.LireLesoptionsCompta;
import com.epegase.systeme.xml.ObjetMessageSysteme;
import com.epegase.systeme.xml.OptionComptabilite;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;
import org.xml.sax.SAXException;

public class FormExercicesComptables implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private transient DataModel madatamodel;
   private ExercicesComptable exercicesComptable;
   private ExercicesComptable exerciceLast;
   private List lesexercicesComptables;
   private boolean testDateAj;
   private boolean noExo;
   private Locale locale = Locale.getDefault();
   private DateFormat dateFormat;
   private ExercicesComptableDao exercicesComptableDao;
   private long leIdExo;
   private boolean disable;
   private List listExo;
   private Date datecloture;
   private UtilDate utilDate;
   private Date memoDateFin;
   private List mesPeriodes;
   private ExercicesComptable exerciceNouvel;
   private boolean showModalPanelAssistant;
   private boolean var_showBarProg;
   private int var_currentValue;
   private int var_valueMax;
   private List listeEcriture;
   private List listeEcritureLight;
   private List listeLettre;
   private EcrituresDao ecrituresDao;
   private BrouillardDao brouillardDao;
   private EcrituresAnalytiquesDao ecrituresAnalytiquesDao;
   private ObjetMessageSysteme obm;
   private String dateDebutCloture;
   private String dateFinCloture;
   private String dateFinExercice;
   private UtilNombre utilNombre;
   private boolean showModalPanelErreur;
   private Ecritures ecritureResultat;
   private Ecritures ecritureReportBenefice;
   private Ecritures ecritureReportPerte;
   private FormAmortissements formAmortissements;
   private int var_mode_cloture;
   private List listeAN;
   private List listeANLettre;
   private List listeANComplement;
   private List listeANComplementTmp;
   private List listeAnalytique;
   private List listeCompte;
   private List listeResultatAnterieur;
   private int cptMaxFlush;
   private int sensPerteBenefie;
   private ExercicesComptable exercicePrecedent;
   private boolean var_mode_anterieur;
   private OptionComptabilite optionComptabilite;
   private LireLesoptionsCompta lireLesoptionsCompta;
   private int choixRacine;
   private String selecFiscalite;

   public FormExercicesComptables() throws IOException, JDOMException {
      this.dateFormat = DateFormat.getDateInstance(0, this.locale);
      this.leIdExo = 0L;
      this.showModalPanelAssistant = false;
      this.var_showBarProg = false;
      this.var_valueMax = 50;
      this.showModalPanelErreur = false;
      this.cptMaxFlush = 500;
      this.sensPerteBenefie = 0;
      this.exercicesComptable = new ExercicesComptable();
      this.lesexercicesComptables = new ArrayList();
      this.testDateAj = true;
      this.listExo = new ArrayList();
      this.noExo = false;
      this.listeEcriture = new ArrayList();
      this.listeEcritureLight = new ArrayList();
      this.listeLettre = new ArrayList();
      this.obm = new ObjetMessageSysteme();
      this.utilNombre = new UtilNombre();
      this.madatamodel = new ListDataModel();
      this.utilDate = new UtilDate();
      this.mesPeriodes = new ArrayList();
      this.listeAN = new ArrayList();
      this.listeANLettre = new ArrayList();
      this.listeANComplement = new ArrayList();
      this.listeANComplementTmp = new ArrayList();
      this.listeAnalytique = new ArrayList();
      this.listeCompte = new ArrayList();
      this.listeResultatAnterieur = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.exercicesComptableDao = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresDao = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresAnalytiquesDao = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.brouillardDao = new BrouillardDao(this.baseLog, this.utilInitHibernate);
   }

   public void enregistrerExercicesCompta() throws IOException, JDOMException, SAXException, HibernateException, NamingException {
      Date var1 = this.exercicesComptable.getExecptDateDebut();
      Date var2 = this.exercicesComptable.getExecptDateFin();
      if (var1.after(var2)) {
         this.testDateAj = false;
      } else {
         this.testDateAj = true;
         int var3 = var2.getYear() + 1900;
         this.exercicesComptable.setExecpt_id((long)var3);
         this.exercicesComptable.setExecptUserCreat(this.usersLog.getUsrid());
         this.exercicesComptable.setExecptUserModif(0L);
         this.exercicesComptable.setExecptDateCreat(new Date());
         this.exercicesComptable.setExecptDateModif((Date)null);
         Object var4 = new ArrayList();
         if (this.madatamodel.getRowCount() > 0) {
            var4 = (List)this.madatamodel.getWrappedData();
         }

         int var5 = this.madatamodel.getRowCount() + 2;
         this.exercicesComptable.setIndice(var5);
         ((List)var4).add(this.exercicesComptable);
         this.madatamodel.setWrappedData(var4);
         Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var7 = null;

         try {
            var7 = var6.beginTransaction();
            this.exercicesComptable = this.exercicesComptableDao.insert(this.exercicesComptable, var6);
            this.lesexercicesComptables.add(this.exercicesComptable);
            this.madatamodel.setWrappedData(this.lesexercicesComptables);
            var7.commit();
         } catch (HibernateException var12) {
            if (var7 != null) {
               var7.rollback();
            }

            throw var12;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.noExo = false;
      }

   }

   public ExercicesComptable recupererLastExo(Session var1) throws HibernateException, NamingException {
      ExercicesComptable var2 = this.exercicesComptableDao.recupererLastExo(var1);
      return var2;
   }

   public void selectionLigneExercice() throws HibernateException, NamingException {
      this.var_mode_anterieur = false;
      if (this.madatamodel.isRowAvailable()) {
         this.exercicesComptable = (ExercicesComptable)this.madatamodel.getRowData();
         this.memoDateFin = this.exercicesComptable.getExecptDateFin();
         Long var1 = this.exercicesComptable.getExecpt_id() - 1L;
         this.exercicePrecedent = this.exercicesComptableDao.recupererLExoPrecis(var1, (Session)null);
         if (this.exercicePrecedent != null) {
            if (this.exercicePrecedent.getExecptEtat() == 1) {
               this.var_mode_anterieur = true;
            } else {
               this.var_mode_anterieur = false;
            }
         }

         int var2 = this.lesexercicesComptables.size();
         int var3 = 0;

         for(int var4 = 0; var4 < this.lesexercicesComptables.size(); ++var4) {
            if (this.exercicesComptable.getExecpt_id() == ((ExercicesComptable)this.lesexercicesComptables.get(var4)).getExecpt_id()) {
               var3 = var4 + 1;
               break;
            }
         }

         if (var2 == var3) {
            this.noExo = false;
         } else {
            this.noExo = true;
         }
      }

   }

   public void chargerDate() throws ParseException {
      this.exercicesComptable.setExecptDateDebut(this.debutinitial());
      this.exercicesComptable.setExecptDateFin(this.finalinitial());
   }

   public Date debutinitial() throws ParseException {
      Date var1 = new Date();
      int var2 = var1.getYear() + 1900;
      String var3 = "01-01-" + var2;
      UtilDate var4 = new UtilDate();
      Date var5 = var4.stringToDateFr(var3);
      return var5;
   }

   public Date finalinitial() throws ParseException {
      Date var1 = new Date();
      int var2 = var1.getYear() + 1900;
      String var3 = "31-12-" + var2;
      UtilDate var4 = new UtilDate();
      Date var5 = var4.stringToDateFr(var3);
      return var5;
   }

   public void modifier() throws HibernateException, NamingException, ParseException {
      String var1 = "dd-MM-yyyy";
      SimpleDateFormat var2 = new SimpleDateFormat(var1, Locale.FRANCE);
      String var3 = var2.format(this.exercicesComptable.getExecptDateDebut());
      Date var4 = var2.parse(var3);
      String var5 = var2.format(this.exercicesComptable.getExecptDateFin());
      Date var6 = var2.parse(var5);
      if (!var4.after(var6)) {
         Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         Transaction var8 = null;

         try {
            var8 = var7.beginTransaction();
            this.exercicesComptable.setExecptUserModif(this.usersLog.getUsrid());
            this.exercicesComptable.setExecptDateModif(new Date());
            this.exercicesComptable = this.exercicesComptableDao.modifierExercicesCompta(this.exercicesComptable, var7);
            if (this.exercicesComptable.getExecptDateFin().getYear() + 1900 != this.memoDateFin.getYear() + 1900) {
               new ArrayList();
               ChronoDao var10 = new ChronoDao(this.baseLog, this.utilInitHibernate);
               List var9 = var10.selectListCompta(0, var7);
               if (var9.size() != 0) {
                  new Chrono();

                  for(int var12 = 0; var12 < var9.size(); ++var12) {
                     Chrono var11 = (Chrono)var9.get(var12);
                     if (var11.getChrPeriode() != null && !var11.getChrPeriode().isEmpty()) {
                        String var13 = "" + (this.memoDateFin.getYear() + 1900);
                        if (var11.getChrPeriode().equals(var13)) {
                           Chrono var14 = new Chrono();
                           var14.setChrPeriode("" + (this.exercicesComptable.getExecptDateFin().getYear() + 1900));
                           var14.setChrFormat(var11.getChrFormat());
                           var14.setChrJournal(var11.getChrJournal());
                           var14.setChrMode(var11.getChrMode());
                           var14.setChrNature(var11.getChrNature());
                           var14.setChrNbCar(var11.getChrNbCar());
                           var14.setChrNom(var11.getChrNom());
                           var14.setChrPrefixe(var11.getChrPrefixe());
                           var14.setChrPrive(var11.getChrPrive());
                           var14.setChrSerie(var11.getChrSerie());
                           var14.setChrService(var11.getChrService());
                           var14.setChrSufixe(var11.getChrSufixe());
                           var10.insertChrono(var14, var7);
                        }
                     }
                  }
               }
            }

            var8.commit();
         } catch (HibernateException var18) {
            if (var8 != null) {
               var8.rollback();
            }

            throw var18;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.lesexercicesComptables = this.recupererLesexercices((Session)null);
      this.madatamodel.setWrappedData(this.lesexercicesComptables);
   }

   public List recupererLesexercices(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      List var2 = this.exercicesComptableDao.selectExercicesCompta(var1);
      this.listExo = new ArrayList();
      if (var2.size() == 0) {
         this.noExo = true;
      } else {
         this.noExo = false;

         for(int var3 = 0; var3 < var2.size(); ++var3) {
            ExercicesComptable var4 = (ExercicesComptable)var2.get(var3);
            var4.setIndice(var3 + 1);
            String var5 = "dd-MM-yyyy";
            SimpleDateFormat var6 = new SimpleDateFormat(var5, Locale.FRANCE);
            String var7 = var6.format(var4.getExecptDateDebut());
            String var8 = var6.format(var4.getExecptDateFin());
            long var9 = var4.getExecpt_id();
            this.listExo.add(new SelectItem(var9, var7 + "...................." + var8));
         }
      }

      this.setLesexercicesComptables(var2);
      return var2;
   }

   public void genererNvlExo(Session var1) throws HibernateException, NamingException {
      this.exerciceLast = this.exercicesComptableDao.recupererLastExo(var1);
      this.exerciceLast.setExecptDateCloture(new Date());
      this.exerciceLast.setExecptEtat(this.var_mode_cloture);
      this.exerciceLast.setExecptDateFin(this.datecloture);
      this.exerciceLast.setExecptUserCloture(this.usersLog.getUsrid());
      this.exercicesComptableDao.modifierExercicesCompta(this.exerciceLast, var1);
      GregorianCalendar var2 = new GregorianCalendar();
      var2.setTime(this.datecloture);
      var2.add(5, 1);
      Date var3 = var2.getTime();
      this.exerciceNouvel = new ExercicesComptable();
      this.exerciceNouvel.setExecptDateDebut(var3);
      this.exerciceNouvel.setExecpt_id(this.exerciceLast.getExecpt_id() + 1L);
      var2.add(2, 12);
      var2.add(5, -1);
      Date var4 = var2.getTime();
      this.exerciceNouvel.setExecptDateFin(var4);
      this.exerciceNouvel.setExecptAdresseCabinet(this.exerciceLast.getExecptAdresseCabinet());
      this.exerciceNouvel.setExecptAdresseCommissaire(this.exerciceLast.getExecptAdresseCommissaire());
      this.exerciceNouvel.setExecptAdresseComptable(this.exerciceLast.getExecptAdresseComptable());
      this.exerciceNouvel.setExecptAdresseContact(this.exerciceLast.getExecptAdresseContact());
      this.exerciceNouvel.setExecptAgrement(this.exerciceLast.getExecptAgrement());
      this.exerciceNouvel.setExecptAnneeActivitePays(this.exerciceLast.getExecptAnneeActivitePays());
      this.exerciceNouvel.setExecptCapProduction(0);
      this.exerciceNouvel.setExecptCentreImpot(this.exerciceLast.getExecptCentreImpot());
      this.exerciceNouvel.setExecptCodeActivite(this.exerciceLast.getExecptCodeActivite());
      this.exerciceNouvel.setExecptConvention(this.exerciceLast.getExecptConvention());
      this.exerciceNouvel.setExecptCtrlPriveEtr(this.exerciceLast.isExecptCtrlPriveEtr());
      this.exerciceNouvel.setExecptCtrlPriveLoc(this.exerciceLast.isExecptCtrlPriveLoc());
      this.exerciceNouvel.setExecptCtrlPublique(this.exerciceLast.isExecptCtrlPublique());
      this.exerciceNouvel.setExecptDateAgrement(this.exerciceLast.getExecptDateAgrement());
      this.exerciceNouvel.setExecptDateArretCompte((Date)null);
      this.exerciceNouvel.setExecptDateClotPrec(this.exerciceLast.getExecptDateFin());
      this.exerciceNouvel.setExecptDateCloture((Date)null);
      this.exerciceNouvel.setExecptDateCreat(new Date());
      this.exerciceNouvel.setExecptDateCreationEntreprise(this.exerciceLast.getExecptDateCreationEntreprise());
      this.exerciceNouvel.setExecptDateModif((Date)null);
      this.exerciceNouvel.setExecptDureeAgrement(this.exerciceLast.getExecptDureeAgrement());
      int var5 = this.exerciceLast.getExecptDateFin().getMonth() - this.exerciceLast.getExecptDateDebut().getMonth() + 1;
      this.exerciceNouvel.setExecptDureePrec(var5);
      this.exerciceNouvel.setExecptEFAAP(false);
      this.exerciceNouvel.setExecptEFANA(false);
      this.exerciceNouvel.setExecptEFANAP(false);
      this.exerciceNouvel.setExecptEFASR(false);
      this.exerciceNouvel.setExecptEFCAR(false);
      this.exerciceNouvel.setExecptEFCNA(false);
      this.exerciceNouvel.setExecptEFCR(false);
      this.exerciceNouvel.setExecptETDateDebut((Date)null);
      this.exerciceNouvel.setExecptETDateFin((Date)null);
      this.exerciceNouvel.setExecptEtatAnterieur(this.exerciceLast.getExecptEtat());
      this.exerciceNouvel.setExecptEtatStr(this.exerciceLast.getExecptEtatStr());
      this.exerciceNouvel.setExecptInscription(this.exerciceLast.getExecptInscription());
      this.exerciceNouvel.setExecptJrxRsv(false);
      this.exerciceNouvel.setExecptJrxSit(false);
      this.exerciceNouvel.setExecptLibActivite(this.exerciceLast.getExecptLibActivite());
      this.exerciceNouvel.setExecptNbEtablissementHors(this.exerciceLast.getExecptNbEtablissementHors());
      this.exerciceNouvel.setExecptNbEtablissementPays(this.exerciceLast.getExecptNbEtablissementPays());
      this.exerciceNouvel.setExecptNomCabinet(this.exerciceLast.getExecptNomCabinet());
      this.exerciceNouvel.setExecptNomCommissaire(this.exerciceLast.getExecptNomCommissaire());
      this.exerciceNouvel.setExecptNomComptable(this.exerciceLast.getExecptNomComptable());
      this.exerciceNouvel.setExecptNomContact(this.exerciceLast.getExecptNomContact());
      this.exerciceNouvel.setExecptNomSignataire(this.exerciceLast.getExecptNomSignataire());
      this.exerciceNouvel.setExecptQuaContact(this.exerciceLast.getExecptQuaContact());
      this.exerciceNouvel.setExecptQuaSignataire(this.exerciceLast.getExecptQuaSignataire());
      this.exerciceNouvel.setExecptRegime(this.exerciceLast.getExecptRegime());
      this.exerciceNouvel.setExecptSalarieComptable(this.exerciceLast.isExecptSalarieComptable());
      this.exerciceNouvel.setExecptTBDateDebut((Date)null);
      this.exerciceNouvel.setExecptTBDateFin((Date)null);
      this.exerciceNouvel.setExecptTelephoneCabinet(this.exerciceLast.getExecptTelephoneCabinet());
      this.exerciceNouvel.setExecptTelephoneCommissaire(this.exerciceLast.getExecptTelephoneCommissaire());
      this.exerciceNouvel.setExecptTelephoneComptable(this.exerciceLast.getExecptTelephoneComptable());
      this.exerciceNouvel.setExecptTelephoneContact(this.exerciceLast.getExecptTelephoneContact());
      this.exerciceNouvel.setExecptTypeEntreprise(this.exerciceLast.getExecptTypeEntreprise());
      this.exerciceNouvel.setExecptUserCloture(0L);
      this.exerciceNouvel.setExecptUserCreat(this.usersLog.getUsrid());
      this.exerciceNouvel.setExecptUserModif(0L);
      this.exerciceNouvel.setExecptVilleCabinet(this.exerciceLast.getExecptVilleCabinet());
      this.exerciceNouvel.setExecptVilleCommissaire(this.exerciceLast.getExecptVilleCommissaire());
      this.exerciceNouvel.setExecptVilleComptable(this.exerciceLast.getExecptVilleComptable());
      this.exerciceNouvel.setExecptVilleContact(this.exerciceLast.getExecptVilleContact());
      this.exercicesComptableDao.insert(this.exerciceNouvel, var1);
      var1.flush();
   }

   public void chargerLesExo() throws HibernateException, NamingException, IOException {
      this.optionComptabilite = new OptionComptabilite();
      this.lireLesoptionsCompta = new LireLesoptionsCompta(this.structureLog);
      this.lireLesoptionsCompta.setStrId(this.structureLog.getStrid());
      this.optionComptabilite = this.lireLesoptionsCompta.lancer();
      this.lesexercicesComptables = this.recupererLesexercices((Session)null);
      this.madatamodel.setWrappedData(this.lesexercicesComptables);
      this.noExo = false;
   }

   public void ouvrirCloture() throws ParseException, IOException {
      if (this.optionComptabilite != null) {
         this.optionComptabilite.setClotureSansControle("1");
         this.datecloture = this.utilDate.dateDernierJourAnnee(this.exercicesComptable.getExecptDateDebut());
         this.showModalPanelAssistant = true;
         this.var_showBarProg = false;
         this.var_currentValue = 0;
         this.var_mode_cloture = 2;
      }

   }

   public void fermerCloture() {
      this.showModalPanelAssistant = false;
      this.var_showBarProg = false;
   }

   public void fermerErreur() {
      this.showModalPanelErreur = false;
   }

   public void cloturer() throws JDOMException, IOException, HibernateException, NamingException, SAXException, ParseException {
      if (this.datecloture != null) {
         if (this.optionComptabilite.getClotureSansControle().equals("1")) {
            this.var_valueMax = 60;
         }

         this.obm = new ObjetMessageSysteme();
         this.obm.setTexte("Initialisation de la cloture...");
         ++this.var_currentValue;
         FormUtilitaires var1 = new FormUtilitaires();
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.setutilInitHibernate(this.utilInitHibernate);
         var1.InstancesDaoUtilses();
         boolean var2 = true;
         this.formAmortissements = new FormAmortissements();
         this.formAmortissements.setBaseLog(this.baseLog);
         this.formAmortissements.setutilInitHibernate(this.utilInitHibernate);
         this.formAmortissements.setUsersLog(this.usersLog);
         this.formAmortissements.setStructureLog(this.structureLog);
         this.formAmortissements.InstancesDaoUtilses();
         this.ecritureResultat = new Ecritures();
         this.ecritureReportBenefice = new Ecritures();
         this.ecritureReportPerte = new Ecritures();
         this.showModalPanelAssistant = false;
         this.var_showBarProg = true;
         int var3 = this.datecloture.getDate();
         String var4 = "";
         if (var3 <= 9) {
            var4 = "0" + var3;
         } else {
            var4 = "" + var3;
         }

         int var5 = this.datecloture.getMonth() + 1;
         String var6 = "";
         if (var5 <= 9) {
            var6 = "0" + var5;
         } else {
            var6 = "" + var5;
         }

         String var7 = "" + (this.datecloture.getYear() + 1900);
         this.dateFinCloture = var7 + "-" + var6 + "-" + var4;
         this.dateDebutCloture = this.utilDate.dateToStringSQLLight(this.exercicesComptable.getExecptDateDebut());
         this.dateFinExercice = this.utilDate.dateToStringSQLLight(this.exercicesComptable.getExecptDateFin());
         this.annulationlettrageInutile();
         int var8 = 0;
         if (this.optionComptabilite.getClotureSansControle().equals("1")) {
            var8 = this.verificationCompta();
            if (var8 == 0) {
               var8 = this.verificationImmobilisation();
            }
         }

         if (var8 == 0) {
            if (this.optionComptabilite.getClotureBackup().equals("1")) {
               FormBackupDatas var9 = new FormBackupDatas(this.utilInitHibernate, this.utilDate);
               var9.setBaseLog(this.baseLog);
               var9.setStructureLog(this.structureLog);
               var9.setUsersLog(this.usersLog);
               var9.backupDBModule("cpt_");
            }

            Session var17 = this.utilInitHibernate.getOpenSession(this.baseLog, "ClotureCompte");
            Transaction var10 = null;

            try {
               var10 = var17.beginTransaction();
               var17.setFlushMode(FlushMode.MANUAL);
               this.verfierJournaux(var17);
               this.generationJournalAA(var17);
               this.genererNvlExo(var17);
               this.recopieThesaurus(var17);
               this.recopieChronoCompta(var17);
               this.generationJournalAN(var17);
               this.recopieEcritures(var17);
               this.recopieBrouillards(var17);
               this.recopieJournaux(var17);
               if (this.optionComptabilite.getClotureSansRappro().equals("1")) {
                  this.traitementRapprochement(var17);
               } else {
                  this.traitementRapprochementFlag(var17);
               }

               this.traitementLoyer(var17);
               this.traitementInfoLiasses(var17);
               var10.commit();
            } catch (HibernateException var15) {
               var2 = false;
               if (var10 != null) {
                  var10.rollback();
               }

               throw var15;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            this.chargerLesExo();
            this.showModalPanelErreur = false;
         } else {
            this.showModalPanelErreur = true;
         }
      }

      this.showModalPanelAssistant = false;
      this.var_showBarProg = false;
   }

   public void verfierJournaux(Session var1) throws HibernateException, NamingException {
      JournauxComptablesDao var2 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      new JournauxComptables();
      JournauxComptables var3 = var2.chercherCode("AA", this.exercicesComptable.getExecpt_id(), var1);
      if (var3 == null) {
         var3 = new JournauxComptables();
         var3.setExercice(this.exercicesComptable);
         var3.setPljNature(14);
         var3.setPljCode("AA");
         var3.setPljChoixDevise(this.structureLog.getStrdevise());
         var3.setPljFormatDevise(this.structureLog.getStrformatdevise());
         var3.setPljLibelleFr("Journal de cloture");
         var3.setPljLibelleSp("");
         var3.setPljLibelleUk("");
         var3.setPljUserCreat(this.usersLog.getUsrid());
         var3.setPljDateCreat(new Date());
         var2.insert(var3, var1);
         var1.flush();
      }

      new JournauxComptables();
      var3 = var2.chercherCode("AA", this.exercicesComptable.getExecpt_id(), var1);
      if (var3 == null) {
         var3 = new JournauxComptables();
         var3.setExercice(this.exercicesComptable);
         var3.setPljNature(15);
         var3.setPljCode("AN");
         var3.setPljChoixDevise(this.structureLog.getStrdevise());
         var3.setPljFormatDevise(this.structureLog.getStrformatdevise());
         var3.setPljLibelleFr("Journal des A Nouveaux");
         var3.setPljLibelleSp("");
         var3.setPljLibelleUk("");
         var3.setPljUserCreat(this.usersLog.getUsrid());
         var3.setPljDateCreat(new Date());
         var2.insert(var3, var1);
         var1.flush();
      }

   }

   public void recopieChronoCompta(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Recalcule les chronos compta...");
      ++this.var_currentValue;
      new ArrayList();
      JournauxComptablesDao var3 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.chargerLesJournauxComptables(this.exerciceNouvel.getExecpt_id(), 0, var1);
      if (var2.size() != 0) {
         new ArrayList();
         ChronoDao var5 = new ChronoDao(this.baseLog, this.utilInitHibernate);
         List var4 = var5.selectListCompta(0, var1);
         boolean var6 = false;
         Chrono var7 = new Chrono();
         new JournauxComptables();
         String var9 = "" + this.exerciceNouvel.getExecpt_id();

         for(int var10 = 0; var10 < var2.size(); ++var10) {
            JournauxComptables var8 = (JournauxComptables)var2.get(var10);
            byte var12 = 0;
            if (var4.size() != 0) {
               for(int var11 = 0; var11 < var4.size(); ++var11) {
                  var7 = (Chrono)var4.get(var11);
                  if (var8.getPljCode().equals(var7.getChrJournal()) && var7.getChrPeriode() != null && !var7.getChrPeriode().isEmpty() && var7.getChrPeriode().equals(var9)) {
                     var12 = 1;
                     break;
                  }
               }
            } else {
               var12 = 2;
            }

            if (var12 == 0 && var7 != null) {
               Chrono var13 = new Chrono();
               var13.setChrPeriode("" + this.exerciceNouvel.getExecpt_id());
               var13.setChrFormat(var7.getChrFormat());
               var13.setChrJournal(var8.getPljCode());
               var13.setChrMode(var7.getChrMode());
               var13.setChrNature(var7.getChrNature());
               var13.setChrNbCar(var7.getChrNbCar());
               var13.setChrNom(var7.getChrNom());
               var13.setChrPrefixe(var7.getChrPrefixe());
               var13.setChrPrive(var7.getChrPrive());
               var13.setChrSerie(var7.getChrSerie());
               var13.setChrService(var7.getChrService());
               var13.setChrSufixe(var7.getChrSufixe());
               var5.insertChrono(var13, var1);
            } else if (var12 == 2) {
            }
         }
      }

   }

   public void lettrageAutomatique() throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Chargement des comptes 38 et 4 non lettrees du " + this.dateDebutCloture + " au " + this.dateFinExercice);
      ++this.var_currentValue;
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ClotureCompteLight");
      new ArrayList();
      List var2 = this.ecrituresDao.chargerEcrituresNonLettrees("38", this.dateDebutCloture, this.dateFinExercice, var1);
      new ArrayList();
      List var3 = this.ecrituresDao.chargerEcrituresNonLettrees("4", this.dateDebutCloture, this.dateFinExercice, var1);
      this.listeEcriture.clear();
      int var4;
      if (var2.size() != 0) {
         for(var4 = 0; var4 < var2.size(); ++var4) {
            this.listeEcriture.add(var2.get(var4));
         }
      }

      if (var3.size() != 0) {
         for(var4 = 0; var4 < var3.size(); ++var4) {
            this.listeEcriture.add(var3.get(var4));
         }
      }

      if (this.listeEcriture.size() != 0) {
         this.obm = new ObjetMessageSysteme();
         this.obm.setTexte("Generation lettrage des comptes 38 et 4 soldes");
         ++this.var_currentValue;
         ArrayList var23 = new ArrayList();
         ArrayList var5 = new ArrayList();
         String var6 = "";
         String var7 = "";
         boolean var8 = false;

         for(int var9 = 0; var9 < this.listeEcriture.size(); ++var9) {
            var6 = ((Ecritures)this.listeEcriture.get(var9)).getEcrCompte();
            if (var23.size() == 0) {
               var23.add(var6);
            } else {
               var8 = false;

               for(int var10 = 0; var10 < var23.size(); ++var10) {
                  if (((String)var23.get(var10)).toString().equals(var6)) {
                     var8 = true;
                     break;
                  }
               }

               if (!var8) {
                  var23.add(var6);
               }
            }
         }

         if (var23.size() != 0) {
            Transaction var24 = null;

            try {
               var24 = var1.beginTransaction();
               new Ecritures();

               for(int var11 = 0; var11 < var23.size(); ++var11) {
                  var6 = ((String)var23.get(var11)).toString();
                  var5.clear();

                  int var12;
                  Ecritures var25;
                  for(var12 = 0; var12 < this.listeEcriture.size(); ++var12) {
                     var25 = (Ecritures)this.listeEcriture.get(var12);
                     if (var25.getEcrCompte().equals(var6) && (var25.getEcrLettrage() == null || var25.getEcrLettrage().isEmpty())) {
                        var5.add(var25);
                     }
                  }

                  if (var5.size() != 0) {
                     var7 = "";
                     var12 = 0;

                     int var13;
                     String var14;
                     for(var13 = 0; var13 < var5.size(); ++var13) {
                        if (((Ecritures)var5.get(var13)).getEcrLettrage() != null && !((Ecritures)var5.get(var13)).getEcrLettrage().isEmpty()) {
                           var14 = ((Ecritures)var5.get(var13)).getEcrLettrage();
                           if (var14.length() > var12) {
                              var12 = var14.length();
                           }
                        }
                     }

                     for(var13 = 0; var13 < var5.size(); ++var13) {
                        if (((Ecritures)var5.get(var13)).getEcrLettrage() != null && !((Ecritures)var5.get(var13)).getEcrLettrage().isEmpty()) {
                           var14 = ((Ecritures)var5.get(var13)).getEcrLettrage();
                           if (var14 != null && !var14.isEmpty() && var14.length() >= var12) {
                              var7 = ((Ecritures)var5.get(var13)).getEcrLettrage();
                           }
                        }
                     }

                     if (var7 == null || var7.isEmpty()) {
                        var7 = "A";
                     }

                     if (var5.size() != 0) {
                        double var26 = 0.0D;
                        double var15 = 0.0D;

                        int var17;
                        for(var17 = 0; var17 < var5.size(); ++var17) {
                           var26 += ((Ecritures)var5.get(var17)).getEcrDebitPays();
                           var15 += ((Ecritures)var5.get(var17)).getEcrCreditPays();
                        }

                        if (var26 - var15 == 0.0D) {
                           var7 = this.calculProchaineLettre(var7);

                           for(var17 = 0; var17 < var5.size(); ++var17) {
                              var25 = (Ecritures)var5.get(var17);
                              var25.setEcrLettrage(var7);
                              this.ecrituresDao.modif(var25, var1);
                           }
                        }
                     }
                  }
               }

               var24.commit();
            } catch (HibernateException var21) {
               if (var24 != null) {
                  var24.rollback();
               }

               throw var21;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         } else {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.utilInitHibernate.closeSession();
      }

   }

   public String calculProchaineLettre(String var1) {
      String var2 = "";
      if (var1 != null && !var1.isEmpty()) {
         if (var1 != null && var1.equals("A")) {
            new ArrayList();
            List var3 = this.calculeListeLettre();
            new ArrayList();
            List var4 = this.calculeListeLettre();
            new ArrayList();
            List var5 = this.calculeListeLettre();
            new ArrayList();
            List var6 = this.calculeListeLettre();
            int var7 = var1.length();
            int var8;
            boolean var9;
            if (var7 == 1) {
               var8 = 0;
               var9 = false;

               for(int var10 = 0; var10 < var3.size(); ++var10) {
                  if (((String)var3.get(var10)).equalsIgnoreCase(var1)) {
                     var8 = var10;
                     var9 = true;
                     break;
                  }
               }

               if (var9 = var8 < 25) {
                  var2 = (String)var3.get(var8 + 1);
               } else {
                  var2 = (String)var3.get(0) + (String)var4.get(0);
               }
            } else {
               int var11;
               boolean var12;
               String var13;
               int var14;
               String var21;
               if (var7 == 2) {
                  var8 = 0;
                  var9 = false;
                  var21 = var1.substring(0, 1);

                  for(var11 = 0; var11 < var3.size(); ++var11) {
                     if (((String)var3.get(var11)).equalsIgnoreCase(var21)) {
                        var8 = var11;
                        var9 = true;
                        break;
                     }
                  }

                  var11 = 0;
                  var12 = false;
                  var13 = var1.substring(1, 2);

                  for(var14 = 0; var14 < var4.size(); ++var14) {
                     if (((String)var4.get(var14)).equalsIgnoreCase(var13)) {
                        var11 = var14;
                        var12 = true;
                        break;
                     }
                  }

                  if (var12 = var11 < 25) {
                     var2 = (String)var3.get(var8) + (String)var4.get(var11 + 1);
                  } else if (var9 = var8 < 25) {
                     var2 = (String)var3.get(var8 + 1) + (String)var4.get(0);
                  } else {
                     var2 = (String)var3.get(var8) + (String)var4.get(0) + (String)var5.get(0);
                  }
               } else {
                  boolean var15;
                  String var16;
                  int var17;
                  if (var7 == 3) {
                     var8 = 0;
                     var9 = false;
                     var21 = var1.substring(0, 1);

                     for(var11 = 0; var11 < var3.size(); ++var11) {
                        if (((String)var3.get(var11)).equalsIgnoreCase(var21)) {
                           var8 = var11;
                           var9 = true;
                           break;
                        }
                     }

                     var11 = 0;
                     var12 = false;
                     var13 = var1.substring(1, 2);

                     for(var14 = 0; var14 < var4.size(); ++var14) {
                        if (((String)var4.get(var14)).equalsIgnoreCase(var13)) {
                           var11 = var14;
                           var12 = true;
                           break;
                        }
                     }

                     var14 = 0;
                     var15 = false;
                     var16 = var1.substring(2, 3);

                     for(var17 = 0; var17 < var5.size(); ++var17) {
                        if (((String)var5.get(var17)).equalsIgnoreCase(var16)) {
                           var14 = var17;
                           var15 = true;
                           break;
                        }
                     }

                     if (var15 = var14 < 25) {
                        var2 = (String)var3.get(var8) + (String)var4.get(var11) + (String)var5.get(var14 + 1);
                     } else if (var12 = var11 < 25) {
                        var2 = (String)var3.get(var8) + (String)var4.get(var11 + 1) + (String)var5.get(0);
                     } else if (var9 = var8 < 25) {
                        var2 = (String)var3.get(var8 + 1) + (String)var4.get(0) + (String)var5.get(0);
                     } else {
                        var2 = (String)var3.get(var8) + (String)var4.get(var8) + (String)var5.get(0) + (String)var6.get(0);
                     }
                  } else if (var7 == 4) {
                     var8 = 0;
                     var9 = false;
                     var21 = var1.substring(0, 1);

                     for(var11 = 0; var11 < var3.size(); ++var11) {
                        if (((String)var3.get(var11)).equalsIgnoreCase(var21)) {
                           var8 = var11;
                           var9 = true;
                           break;
                        }
                     }

                     var11 = 0;
                     var12 = false;
                     var13 = var1.substring(1, 2);

                     for(var14 = 0; var14 < var4.size(); ++var14) {
                        if (((String)var4.get(var14)).equalsIgnoreCase(var13)) {
                           var11 = var14;
                           var12 = true;
                           break;
                        }
                     }

                     var14 = 0;
                     var15 = false;
                     var16 = var1.substring(2, 3);

                     for(var17 = 0; var17 < var5.size(); ++var17) {
                        if (((String)var5.get(var17)).equalsIgnoreCase(var16)) {
                           var14 = var17;
                           var15 = true;
                           break;
                        }
                     }

                     var17 = 0;
                     boolean var18 = false;
                     String var19 = var1.substring(3, 4);

                     for(int var20 = 0; var20 < var6.size(); ++var20) {
                        if (((String)var6.get(var20)).equalsIgnoreCase(var19)) {
                           var17 = var20;
                           var18 = true;
                           break;
                        }
                     }

                     if (var18 = var17 < 25) {
                        var2 = (String)var3.get(var8) + (String)var4.get(var11) + (String)var5.get(var14) + (String)var6.get(var17 + 1);
                     } else if (var15 = var14 < 25) {
                        var2 = (String)var3.get(var8) + (String)var4.get(var11) + (String)var5.get(var14 + 1) + (String)var6.get(0);
                     } else if (var12 = var11 < 25) {
                        var2 = (String)var3.get(var8) + (String)var4.get(var11 + 1) + (String)var5.get(0) + (String)var6.get(0);
                     } else if (var9 = var8 < 25) {
                        var2 = (String)var3.get(var8 + 1) + (String)var4.get(0) + (String)var5.get(0) + (String)var6.get(0);
                     } else {
                        var2 = (String)var3.get(0);
                     }
                  } else {
                     var2 = "A";
                  }
               }
            }
         }
      } else {
         var2 = "A";
      }

      return var2;
   }

   public List calculeListeLettre() {
      ArrayList var1 = new ArrayList();
      var1.add("A");
      var1.add("B");
      var1.add("C");
      var1.add("D");
      var1.add("E");
      var1.add("F");
      var1.add("G");
      var1.add("H");
      var1.add("I");
      var1.add("J");
      var1.add("K");
      var1.add("L");
      var1.add("M");
      var1.add("N");
      var1.add("O");
      var1.add("P");
      var1.add("Q");
      var1.add("R");
      var1.add("S");
      var1.add("T");
      var1.add("U");
      var1.add("V");
      var1.add("W");
      var1.add("X");
      var1.add("Y");
      var1.add("Z");
      return var1;
   }

   public void annulationlettrageInutile() throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Effacement des lettrages inutiles de la periode en cours du " + this.dateDebutCloture + " au " + this.dateFinExercice);
      ++this.var_currentValue;
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ClotureCompteLight");
      this.listeEcriture = this.ecrituresDao.chargerEcrituresEffaceLettrage(this.dateDebutCloture, this.dateFinExercice, var1);
      if (this.listeEcriture.size() != 0) {
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new Ecritures();
            int var4 = 0;

            for(int var5 = 0; var5 < this.listeEcriture.size(); ++var5) {
               Ecritures var3 = (Ecritures)this.listeEcriture.get(var5);
               if (var3.getEcrLettrage() != null && !var3.getEcrLettrage().isEmpty()) {
                  var3.setEcrLettrage((String)null);
                  this.ecrituresDao.modif(var3, var1);
               }

               ++var4;
               if (var4 == this.cptMaxFlush) {
                  var1.flush();
                  var4 = 0;
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
      } else {
         this.utilInitHibernate.closeSession();
      }

      this.listeEcriture.clear();
   }

   public void calculPeriode() throws ParseException {
      int var1 = 0;
      this.mesPeriodes.clear();
      Date var2 = this.exercicesComptable.getExecptDateDebut();
      GregorianCalendar var3 = new GregorianCalendar();
      var3.setTime(var2);
      Date var4 = this.exercicesComptable.getExecptDateFin();
      GregorianCalendar var5 = new GregorianCalendar();
      var5.setTime(var4);
      var3.add(2, -1);
      var5.add(2, -1);
      String var6 = null;

      while(var3.compareTo(var5) < 0) {
         var3.add(2, 1);
         Date var7 = var3.getTime();
         var6 = this.formatPeriode(var7);
         ++var1;
         this.mesPeriodes.add(var6);
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

   public int verificationCompta() throws HibernateException, NamingException, ParseException {
      byte var1 = 0;
      Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "ClotureCompte");
      this.calculPeriode();
      if (this.mesPeriodes.size() != 0) {
         for(int var3 = 0; var3 < this.mesPeriodes.size(); ++var3) {
            String var4 = this.mesPeriodes.get(var3).toString();
            String[] var5 = var4.split(":");
            if (var5[1].equals("" + this.exercicesComptable.getExecpt_id())) {
               String var6 = var5[1] + "-" + var5[0] + "-01";
               String var7 = this.utilDate.dateToStringSQLLight(this.utilDate.dateDernierJourMois(this.utilDate.stringToDateSQL(var6 + " 00:00:00")));
               this.obm = new ObjetMessageSysteme();
               this.obm.setTexte("Verification equilibre des journaux du " + var6 + " au " + var7);
               ++this.var_currentValue;
               this.listeEcritureLight.clear();
               this.listeEcritureLight = this.ecrituresDao.chargerEcrituresLight(var6, var7, var7, var2);
               if (this.listeEcritureLight.size() != 0) {
                  double var8 = 0.0D;
                  double var10 = 0.0D;

                  for(int var12 = 0; var12 < this.listeEcritureLight.size(); ++var12) {
                     var8 += ((EcrituresLight)this.listeEcritureLight.get(var12)).getEcrDebitSaisie();
                     var10 += ((EcrituresLight)this.listeEcritureLight.get(var12)).getEcrCreditSaisie();
                  }

                  var8 = this.utilNombre.myRoundDevise(var8, this.structureLog.getStrdevise());
                  var10 = this.utilNombre.myRoundDevise(var10, this.structureLog.getStrdevise());
                  if (var8 != var10) {
                     var1 = 1;
                     double var18 = var8 - var10;
                     var18 = this.utilNombre.myRoundDevise(var18, this.structureLog.getStrdevise());
                     this.obm.setCat("Certains journaux ne sont pas équilibrés. (Faites un récapitulatif dossier).<br>Total débit: " + var8 + " Total crédit: " + var10 + " Ecart: " + var18);
                     this.showModalPanelErreur = true;
                     break;
                  }
               }
            }
         }

         if (var1 == 0) {
            this.obm = new ObjetMessageSysteme();
            this.obm.setTexte("Verification equilibre des lettrages du " + this.dateDebutCloture + " au " + this.dateFinExercice);
            ++this.var_currentValue;
            this.listeEcritureLight.clear();
            this.listeEcritureLight = this.ecrituresDao.chargerEcrituresCtrlLettrageLight(this.dateDebutCloture, this.dateFinExercice, var2);
            if (this.listeEcritureLight.size() != 0) {
               double var14 = 0.0D;
               double var15 = 0.0D;

               for(int var16 = 0; var16 < this.listeEcritureLight.size(); ++var16) {
                  if (((EcrituresLight)this.listeEcritureLight.get(var16)).getEcrLettrage() != null && !((EcrituresLight)this.listeEcritureLight.get(var16)).getEcrLettrage().isEmpty()) {
                     var14 += ((EcrituresLight)this.listeEcritureLight.get(var16)).getEcrDebitSaisie();
                     var15 += ((EcrituresLight)this.listeEcritureLight.get(var16)).getEcrCreditSaisie();
                  }
               }

               var14 = this.utilNombre.myRoundDevise(var14, this.structureLog.getStrdevise());
               var15 = this.utilNombre.myRoundDevise(var15, this.structureLog.getStrdevise());
               if (var14 != var15) {
                  var1 = 2;
                  double var17 = var14 - var15;
                  var17 = this.utilNombre.myRoundDevise(var17, this.structureLog.getStrdevise());
                  this.obm.setCat("Certaines lettres ne sont pas équilibrées. (Faites une balance des écritutes lettrées).  Total débit: " + var14 + " Total crédit: " + var15 + " Ecart: " + var17);
                  this.showModalPanelErreur = true;
               }
            }
         }
      } else {
         var1 = 1;
         this.obm.setCat("IL n` y a pas de periode comptable a cloturer!");
         this.showModalPanelErreur = true;
      }

      this.listeEcriture.clear();
      this.utilInitHibernate.closeSession();
      return var1;
   }

   public int verificationImmobilisation() throws HibernateException, NamingException {
      byte var1 = 0;
      new ArrayList();
      AmortissementTabDao var3 = new AmortissementTabDao(this.baseLog, this.utilInitHibernate);
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Verification des dotations du " + this.dateDebutCloture + " au " + this.dateFinCloture);
      ++this.var_currentValue;
      List var2 = var3.chargerAmotDot(this.dateDebutCloture, this.dateFinCloture, (Session)null);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            if (((AmortissementTab)var2.get(var4)).getAmotabDateTrf() == null) {
               var1 = 10;
               break;
            }
         }
      }

      if (var1 != 0) {
         this.obm.setCat("Toutes les dotations n'ont pas été transférées en comptabilité...");
         this.showModalPanelErreur = true;
      }

      return var1;
   }

   public void generationJournalAA(Session var1) throws HibernateException, NamingException, ParseException {
      int var2 = 0;
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Chargement des ecritures de la periode (cloture) du " + this.dateDebutCloture + " au " + this.dateFinCloture);
      ++this.var_currentValue;
      this.listeEcriture.clear();
      this.listeEcritureLight.clear();
      this.ecritureResultat = null;
      this.listeEcritureLight = this.ecrituresDao.chargerEcrituresLight(this.dateDebutCloture, this.dateFinCloture, this.dateFinCloture, var1);
      if (this.listeEcritureLight.size() != 0) {
         new EcrituresLight();
         new Ecritures();

         Ecritures var4;
         for(int var5 = 0; var5 < this.listeEcritureLight.size(); ++var5) {
            EcrituresLight var3 = (EcrituresLight)this.listeEcritureLight.get(var5);
            if (var3.getEcrNatureJrx() == 15 && (var3.getEcrCompte().startsWith("131") || var3.getEcrCompte().startsWith("139"))) {
               var4 = this.ecrituresDao.recupererSelectedECById(var3.getEcr_id(), var1);
               if (var4 != null) {
                  this.listeResultatAnterieur.add(var4);
               }

               this.listeEcritureLight.remove(var3);
               --var5;
            }
         }

         this.obm = new ObjetMessageSysteme();
         this.obm.setTexte("Verification journal de cloture...");
         ++this.var_currentValue;
         new JournauxComptables();
         JournauxComptablesDao var6 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
         JournauxComptables var27 = var6.chercherCode("AA", this.exercicesComptable.getExecpt_id(), var1);
         if (var27 == null) {
            var27 = new JournauxComptables();
            var27.setExercice(this.exercicesComptable);
            var27.setPljBudjet(this.baseLog);
            var27.setPljChoixDevise(this.structureLog.getStrdevise());
            var27.setPljCode("AA");
            var27.setPljDateCreat(new Date());
            var27.setPljLibelleFr("Journal de cloture");
            var27.setPljNature(14);
            var27.setPljFormatDevise(this.structureLog.getStrformatdevise());
            var27.setPljTypeDevise(0);
            var27.setPljUserCreat(this.usersLog.getUsrid());
            var6.insert(var27, var1);
            var1.flush();
         }

         this.obm = new ObjetMessageSysteme();
         this.obm.setTexte("Suppression ancienne cloture (AA)...");
         ++this.var_currentValue;
         String var7 = "AA:" + this.calculPeriode(this.dateFinCloture);
         new ArrayList();
         List var8 = this.ecrituresDao.recupererSelectedECByCle1(var7, var1);
         if (var8.size() != 0) {
            this.ecrituresDao.removeSelectedEC2(var8, this.cptMaxFlush, var1);
            var1.flush();
            var8.clear();
         }

         ArrayList var9 = new ArrayList();
         this.listeCompte.clear();
         this.obm = new ObjetMessageSysteme();
         this.obm.setTexte("Generation journal cloture : comptes de charge");
         ++this.var_currentValue;
         this.listeCompte = this.ecrituresDao.chargerComptesCharges(this.dateDebutCloture, this.dateFinCloture, var1);
         int var10;
         String var11;
         String var12;
         int var13;
         String var14;
         String var15;
         String var16;
         double var17;
         double var19;
         EcrituresLight var21;
         int var22;
         if (this.listeCompte.size() != 0) {
            for(var10 = 0; var10 < this.listeCompte.size(); ++var10) {
               var11 = ((PlanComptable)this.listeCompte.get(var10)).getPlcCompte();
               var12 = ((PlanComptable)this.listeCompte.get(var10)).getPlcLibelleCpteFR();
               var13 = ((PlanComptable)this.listeCompte.get(var10)).getPlcNature();
               var14 = "";
               var15 = "";
               var16 = "";
               if (this.listeEcritureLight.size() != 0) {
                  var17 = 0.0D;
                  var19 = 0.0D;
                  new EcrituresLight();

                  for(var22 = 0; var22 < this.listeEcritureLight.size(); ++var22) {
                     var21 = (EcrituresLight)this.listeEcritureLight.get(var22);
                     if (var21.getEcrCompte().equals(var11)) {
                        var17 += var21.getEcrDebitSaisie();
                        var19 += var21.getEcrCreditSaisie();
                        if (var21.getEcrDeviseSaisie() != null && !var21.getEcrDeviseSaisie().isEmpty()) {
                           var14 = var21.getEcrDeviseSaisie();
                        } else {
                           var14 = this.structureLog.getStrdevise();
                        }

                        if (var21.getEcrDevisePays() != null && !var21.getEcrDevisePays().isEmpty()) {
                           var15 = var21.getEcrDevisePays();
                        } else {
                           var15 = this.structureLog.getStrdevise();
                        }

                        if (var21.getEcrDeviseGrp() != null && !var21.getEcrDeviseGrp().isEmpty()) {
                           var16 = var21.getEcrDeviseGrp();
                        } else {
                           var16 = this.structureLog.getStrdevise();
                        }
                     }
                  }

                  var4 = new Ecritures();
                  var4.setExercicesComptable(this.exercicesComptable);
                  var4.setEcrCode("AA");
                  var4.setEcrNatureJrx(14);
                  var4.setEcrCompte(var11);
                  var4.setEcrNature(var13);
                  var4.setEcrPiece("AA");
                  var4.setEcrDateSaisie(this.datecloture);
                  var4.setEcrJour(this.datecloture.getDay() + 1);
                  var4.setEcrAnnee("" + (this.datecloture.getYear() + 1900));
                  var4.setEcrPeriode(this.calculPeriode(this.dateFinCloture));
                  var4.setEcrCloture(0);
                  var4.setEcrLibelle(var12);
                  var4.setEcrLibCompte(var12);
                  var4.setEcrDeviseSaisie(var14);
                  var4.setEcrDevisePays(var15);
                  var4.setEcrDeviseGrp(var16);
                  var4.setEcrCle1(this.calculCle1(var4.getEcrPeriode(), var4.getEcrCode()));
                  var4.setEcrCle2(this.calculCle2(var4.getEcrCode(), this.dateFinCloture));
                  if (var17 < 0.0D) {
                     var4.setEcrDebitSaisie(var19 - var17);
                     var4.setEcrCreditSaisie(0.0D);
                  } else if (var17 > var19) {
                     var4.setEcrDebitSaisie(0.0D);
                     var4.setEcrCreditSaisie(var17 - var19);
                  } else {
                     var4.setEcrDebitSaisie(var19 - var17);
                     var4.setEcrCreditSaisie(0.0D);
                  }

                  if (var17 != 0.0D || var19 != 0.0D) {
                     var4 = this.calculSuiteEcriture(var4);
                     var9.add(var4);
                  }
               }
            }
         }

         this.obm = new ObjetMessageSysteme();
         this.obm.setTexte("Generation journal cloture : comptes de produit");
         ++this.var_currentValue;
         this.listeCompte.clear();
         this.listeCompte = this.ecrituresDao.chargerComptesProduits(this.dateDebutCloture, this.dateFinCloture, var1);
         if (this.listeCompte.size() != 0) {
            for(var10 = 0; var10 < this.listeCompte.size(); ++var10) {
               var11 = ((PlanComptable)this.listeCompte.get(var10)).getPlcCompte();
               var12 = ((PlanComptable)this.listeCompte.get(var10)).getPlcLibelleCpteFR();
               var13 = ((PlanComptable)this.listeCompte.get(var10)).getPlcNature();
               var14 = "";
               var15 = "";
               var16 = "";
               if (this.listeEcritureLight.size() != 0) {
                  var17 = 0.0D;
                  var19 = 0.0D;
                  new EcrituresLight();

                  for(var22 = 0; var22 < this.listeEcritureLight.size(); ++var22) {
                     var21 = (EcrituresLight)this.listeEcritureLight.get(var22);
                     if (var21.getEcrCompte().equals(var11)) {
                        var17 += var21.getEcrDebitSaisie();
                        var19 += var21.getEcrCreditSaisie();
                        if (var21.getEcrDeviseSaisie() != null && !var21.getEcrDeviseSaisie().isEmpty()) {
                           var14 = var21.getEcrDeviseSaisie();
                        } else {
                           var14 = this.structureLog.getStrdevise();
                        }

                        if (var21.getEcrDevisePays() != null && !var21.getEcrDevisePays().isEmpty()) {
                           var15 = var21.getEcrDevisePays();
                        } else {
                           var15 = this.structureLog.getStrdevise();
                        }

                        if (var21.getEcrDeviseGrp() != null && !var21.getEcrDeviseGrp().isEmpty()) {
                           var16 = var21.getEcrDeviseGrp();
                        } else {
                           var16 = this.structureLog.getStrdevise();
                        }
                     }
                  }

                  var4 = new Ecritures();
                  var4.setExercicesComptable(this.exercicesComptable);
                  var4.setEcrCode("AA");
                  var4.setEcrNatureJrx(14);
                  var4.setEcrCompte(var11);
                  var4.setEcrNature(var13);
                  var4.setEcrPiece("AA");
                  var4.setEcrDateSaisie(this.datecloture);
                  var4.setEcrJour(this.datecloture.getDay() + 1);
                  var4.setEcrAnnee("" + (this.datecloture.getYear() + 1900));
                  var4.setEcrPeriode(this.calculPeriode(this.dateFinCloture));
                  var4.setEcrCloture(0);
                  var4.setEcrLibelle(var12);
                  var4.setEcrLibCompte(var12);
                  var4.setEcrDeviseSaisie(var14);
                  var4.setEcrDevisePays(var15);
                  var4.setEcrDeviseGrp(var16);
                  var4.setEcrCle1(this.calculCle1(var4.getEcrPeriode(), var4.getEcrCode()));
                  var4.setEcrCle2(this.calculCle2(var4.getEcrCode(), this.dateFinCloture));
                  if (var19 < 0.0D) {
                     var4.setEcrDebitSaisie(0.0D);
                     var4.setEcrCreditSaisie(var17 - var19);
                  } else if (var19 > var17) {
                     var4.setEcrDebitSaisie(var19 - var17);
                     var4.setEcrCreditSaisie(0.0D);
                  } else {
                     var4.setEcrDebitSaisie(var17 - var19);
                     var4.setEcrCreditSaisie(0.0D);
                  }

                  if (var17 != 0.0D || var19 != 0.0D) {
                     var4 = this.calculSuiteEcriture(var4);
                     var9.add(var4);
                  }
               }
            }
         }

         this.obm = new ObjetMessageSysteme();
         this.obm.setTexte("Generation journal cloture : recuperation resultat en attente");
         ++this.var_currentValue;
         new ArrayList();
         List var28 = this.ecrituresDao.chargerComptesResultat(this.dateDebutCloture, this.dateFinCloture, var1);
         double var32;
         if (var28.size() != 0) {
            double var29 = 0.0D;
            var32 = 0.0D;
            var15 = "";
            var16 = "";
            int var34 = 0;

            for(int var18 = 0; var18 < var28.size(); ++var18) {
               var15 = ((Ecritures)var28.get(var18)).getEcrCompte();
               var16 = ((Ecritures)var28.get(var18)).getEcrLibCompte();
               var34 = ((Ecritures)var28.get(var18)).getEcrNature();
               var29 += ((Ecritures)var28.get(var18)).getEcrDebitSaisie();
               var32 += ((Ecritures)var28.get(var18)).getEcrCreditSaisie();
            }

            var4 = new Ecritures();
            var4.setExercicesComptable(this.exercicesComptable);
            var4.setEcrCode("AA");
            var4.setEcrNatureJrx(14);
            var4.setEcrCompte(var15);
            var4.setEcrNature(var34);
            var4.setEcrPiece("AA");
            var4.setEcrDateSaisie(this.datecloture);
            var4.setEcrJour(this.datecloture.getDay() + 1);
            var4.setEcrAnnee("" + (this.datecloture.getYear() + 1900));
            var4.setEcrPeriode(this.calculPeriode(this.dateFinCloture));
            var4.setEcrCloture(0);
            var4.setEcrLibelle(var16);
            var4.setEcrLibCompte(var16);
            var4.setEcrDeviseSaisie(this.structureLog.getStrdevise());
            var4.setEcrDevisePays(this.structureLog.getStrdevise());
            var4.setEcrDeviseGrp(this.structureLog.getStrdevise());
            var4.setEcrCle1(this.calculCle1(var4.getEcrPeriode(), var4.getEcrCode()));
            var4.setEcrCle2(this.calculCle2(var4.getEcrCode(), this.dateFinCloture));
            if (var29 > var32) {
               var4.setEcrDebitSaisie(var29 - var32);
               var4.setEcrCreditSaisie(0.0D);
            } else {
               var4.setEcrDebitSaisie(0.0D);
               var4.setEcrCreditSaisie(var32 - var29);
            }

            if (var29 != 0.0D || var32 != 0.0D) {
               var4 = this.calculSuiteEcriture(var4);
               var9.add(var4);
            }

            var4 = new Ecritures();
            var4.setExercicesComptable(this.exercicesComptable);
            var4.setEcrCode("AA");
            var4.setEcrNatureJrx(14);
            var4.setEcrCompte(var15);
            var4.setEcrNature(var34);
            var4.setEcrPiece("AA");
            var4.setEcrDateSaisie(this.datecloture);
            var4.setEcrJour(this.datecloture.getDay() + 1);
            var4.setEcrAnnee("" + (this.datecloture.getYear() + 1900));
            var4.setEcrPeriode(this.calculPeriode(this.dateFinCloture));
            var4.setEcrCloture(0);
            var4.setEcrLibelle(var16);
            var4.setEcrLibCompte(var16);
            var4.setEcrDeviseSaisie(this.structureLog.getStrdevise());
            var4.setEcrDevisePays(this.structureLog.getStrdevise());
            var4.setEcrDeviseGrp(this.structureLog.getStrdevise());
            var4.setEcrCle1(this.calculCle1(var4.getEcrPeriode(), var4.getEcrCode()));
            var4.setEcrCle2(this.calculCle2(var4.getEcrCode(), this.dateFinCloture));
            if (var29 > var32) {
               var4.setEcrDebitSaisie(0.0D);
               var4.setEcrCreditSaisie(var29 - var32);
            } else {
               var4.setEcrDebitSaisie(var32 - var29);
               var4.setEcrCreditSaisie(0.0D);
            }

            if (var29 != 0.0D || var32 != 0.0D) {
               var4 = this.calculSuiteEcriture(var4);
               var9.add(var4);
            }
         }

         Date var30 = this.utilDate.stringToDateSQLLight(this.dateDebutCloture);
         Date var31 = this.utilDate.stringToDateSQLLight(this.dateFinCloture);
         var32 = 0.0D;
         double var33 = 0.0D;
         var17 = 0.0D;
         var19 = 0.0D;
         double var35 = 0.0D;
         double var23 = 0.0D;
         this.obm = new ObjetMessageSysteme();
         this.obm.setTexte("Generation journal cloture : calcul du resultat anterieur");
         ++this.var_currentValue;
         int var25;
         if (this.listeResultatAnterieur.size() != 0) {
            this.sensPerteBenefie = 0;

            for(var25 = 0; var25 < this.listeResultatAnterieur.size(); ++var25) {
               if (((Ecritures)this.listeResultatAnterieur.get(var25)).getEcrCompte().startsWith("139")) {
                  var32 += ((Ecritures)this.listeResultatAnterieur.get(var25)).getEcrDebitSaisie();
                  var33 += ((Ecritures)this.listeResultatAnterieur.get(var25)).getEcrCreditSaisie();
                  this.sensPerteBenefie = 1;
               } else if (((Ecritures)this.listeResultatAnterieur.get(var25)).getEcrCompte().startsWith("131")) {
                  var17 += ((Ecritures)this.listeResultatAnterieur.get(var25)).getEcrDebitSaisie();
                  var19 += ((Ecritures)this.listeResultatAnterieur.get(var25)).getEcrCreditSaisie();
                  this.sensPerteBenefie = 2;
               }
            }

            var4 = new Ecritures();
            var4.setExercicesComptable(this.exercicesComptable);
            var4.setEcrCode("AA");
            var4.setEcrNatureJrx(14);
            var4.setEcrPiece("AA");
            var4.setEcrDateSaisie(this.datecloture);
            var4.setEcrJour(this.datecloture.getDay() + 1);
            var4.setEcrAnnee("" + (this.datecloture.getYear() + 1900));
            var4.setEcrPeriode(this.calculPeriode(this.dateFinCloture));
            var4.setEcrCloture(0);
            var4.setEcrCle1(this.calculCle1(var4.getEcrPeriode(), var4.getEcrCode()));
            var4.setEcrCle2(this.calculCle2(var4.getEcrCode(), this.dateFinCloture));
            if (this.sensPerteBenefie == 1) {
               var4.setEcrCompte("1290000000");
               var4.setEcrNature(1);
               var4.setEcrLibelle("Repport à nouveau perte");
               var4.setEcrLibCompte("Repport à nouveau perte");
               var4.setEcrDebitSaisie(var32);
               var4.setEcrCreditSaisie(0.0D);
            } else if (this.sensPerteBenefie == 2) {
               var4.setEcrCompte("1210000000");
               var4.setEcrNature(1);
               var4.setEcrLibelle("Report à nouveau bénéfice");
               var4.setEcrLibCompte("Report à nouveau bénéfice");
               var4.setEcrDebitSaisie(0.0D);
               var4.setEcrCreditSaisie(var19);
            }

            var4.setEcrDeviseSaisie(this.structureLog.getStrdevise());
            var4.setEcrDevisePays(this.structureLog.getStrdevise());
            var4.setEcrDeviseGrp(this.structureLog.getStrdevise());
            var4 = this.calculSuiteEcriture(var4);
            this.ecritureReportBenefice = new Ecritures();
            this.ecritureReportPerte = new Ecritures();
            if (this.sensPerteBenefie == 1) {
               this.ecritureReportPerte = var4;
            } else if (this.sensPerteBenefie == 2) {
               this.ecritureReportBenefice = var4;
            }
         }

         if (this.listeEcritureLight.size() != 0) {
            this.obm = new ObjetMessageSysteme();
            this.obm.setTexte("Generation journal cloture : calcul du resultat exercice");
            ++this.var_currentValue;
            new EcrituresLight();
            int var26 = 0;

            while(true) {
               if (var26 >= this.listeEcritureLight.size()) {
                  var4 = new Ecritures();
                  var4.setExercicesComptable(this.exercicesComptable);
                  var4.setEcrCode("AA");
                  var4.setEcrNatureJrx(14);
                  var4.setEcrPiece("AA");
                  var4.setEcrDateSaisie(this.datecloture);
                  var4.setEcrJour(this.datecloture.getDay() + 1);
                  var4.setEcrAnnee("" + (this.datecloture.getYear() + 1900));
                  var4.setEcrPeriode(this.calculPeriode(this.dateFinCloture));
                  var4.setEcrCloture(0);
                  var4.setEcrCle1(this.calculCle1(var4.getEcrPeriode(), var4.getEcrCode()));
                  var4.setEcrCle2(this.calculCle2(var4.getEcrCode(), this.dateFinCloture));
                  if (var35 > var23) {
                     var4.setEcrCompte("1390000000");
                     var4.setEcrNature(1);
                     var4.setEcrLibelle("Résultat Net: Perte");
                     var4.setEcrLibCompte("Résultat Net: Perte");
                     var4.setEcrDebitSaisie(var35 - var23);
                     var4.setEcrCreditSaisie(0.0D);
                  } else {
                     var4.setEcrCompte("1310000000");
                     var4.setEcrNature(1);
                     var4.setEcrLibelle("Résultat Net: Bénéfice");
                     var4.setEcrLibCompte("Résultat Net: Bénéfice");
                     var4.setEcrDebitSaisie(0.0D);
                     var4.setEcrCreditSaisie(var23 - var35);
                  }

                  var4.setEcrDeviseSaisie(this.structureLog.getStrdevise());
                  var4.setEcrDevisePays(this.structureLog.getStrdevise());
                  var4.setEcrDeviseGrp(this.structureLog.getStrdevise());
                  if (var35 != 0.0D || var23 != 0.0D) {
                     var4 = this.calculSuiteEcriture(var4);
                     this.ecritureResultat = new Ecritures();
                     this.ecritureResultat = var4;
                     var9.add(var4);
                  }
                  break;
               }

               EcrituresLight var36 = (EcrituresLight)this.listeEcritureLight.get(var26);
               if ((var36.getEcrCompte().startsWith("6") || var36.getEcrCompte().startsWith("7") || var36.getEcrCompte().startsWith("8")) && (var36.getEcrDateSaisie().after(var30) || var36.getEcrDateSaisie().equals(var30)) && (var36.getEcrDateSaisie().before(var31) || var36.getEcrDateSaisie().equals(var31))) {
                  var35 += var36.getEcrDebitSaisie();
                  var23 += var36.getEcrCreditSaisie();
               }

               ++var26;
            }
         }

         if (var9.size() != 0) {
            new Ecritures();

            for(var25 = 0; var25 < var9.size(); ++var25) {
               var4 = (Ecritures)var9.get(var25);
               var4.setEcrEtat(1);
               this.ecrituresDao.insert(var4, var1);
               ++var2;
               if (var2 == this.cptMaxFlush) {
                  var1.flush();
                  var2 = 0;
               }
            }

            var1.flush();
         }
      }

      this.listeEcritureLight.clear();
   }

   public String calculPeriode(String var1) throws ParseException {
      String var2 = "";
      if (var1.contains("-")) {
         Date var3 = this.utilDate.stringToDateSQLLight(var1);
         int var4 = var3.getMonth() + 1;
         String var5 = "";
         if (var4 <= 9) {
            var5 = "0" + var4;
         } else {
            var5 = "" + var4;
         }

         var2 = var5 + ":" + (var3.getYear() + 1900);
      } else {
         String[] var6 = var1.split(":");
         var2 = var6[1] + ":" + var6[0];
      }

      return var2;
   }

   public String calculCle1(String var1, String var2) {
      String var3 = var2 + ":" + var1;
      return var3;
   }

   public String calculCle2(String var1, String var2) {
      String[] var3 = var2.split("-");
      String var4 = var1 + ":" + var3[0] + ":" + var3[1] + ":" + var3[2];
      return var4;
   }

   public Ecritures calculSuiteEcriture(Ecritures var1) {
      var1.setEcrJour(var1.getEcrDateSaisie().getDay());
      var1.setEcrClasse(var1.getEcrCompte().substring(0, 1));
      var1.setEcrDeviseSaisie(this.structureLog.getStrdevise());
      var1.setEcrCoefEuro(this.utilNombre.deviseTaux1(var1.getEcrDeviseSaisie(), var1.getEcrDateSaisie()));
      var1.setEcrDebitEuro(this.utilNombre.myRoundFormat(var1.getEcrDebitSaisie() * (double)var1.getEcrCoefEuro(), 1));
      var1.setEcrCreditEuro(this.utilNombre.myRoundFormat(var1.getEcrCreditSaisie() * (double)var1.getEcrCoefEuro(), 1));
      var1.setEcrDevisePays(var1.getEcrDevisePays());
      if (var1.getEcrDevisePays() == null || var1.getEcrDevisePays().isEmpty()) {
         var1.setEcrDevisePays(this.structureLog.getStrdevise());
      }

      if (var1.getEcrDevisePays().equalsIgnoreCase(var1.getEcrDeviseSaisie())) {
         var1.setEcrCoefPays(1.0F);
         var1.setEcrDebitPays(var1.getEcrDebitSaisie());
         var1.setEcrCreditPays(var1.getEcrCreditSaisie());
      } else {
         var1.setEcrCoefPays(this.utilNombre.deviseTaux2(var1.getEcrDevisePays(), var1.getEcrDateSaisie()));
         var1.setEcrDebitPays(this.utilNombre.myRoundDevise(var1.getEcrDebitSaisie() * (double)var1.getEcrCoefPays(), var1.getEcrDevisePays()));
         var1.setEcrCreditPays(this.utilNombre.myRoundDevise(var1.getEcrCreditSaisie() * (double)var1.getEcrCoefPays(), var1.getEcrDevisePays()));
      }

      var1.setEcrDeviseGrp(var1.getEcrDeviseGrp());
      if (var1.getEcrDeviseGrp() == null || var1.getEcrDeviseGrp().isEmpty()) {
         var1.setEcrDeviseGrp(this.structureLog.getStrdevise());
      }

      if (var1.getEcrDeviseGrp().equalsIgnoreCase(var1.getEcrDeviseSaisie())) {
         var1.setEcrCoefGrp(1.0F);
         var1.setEcrDebitGrp(var1.getEcrDebitSaisie());
         var1.setEcrCreditGrp(var1.getEcrCreditSaisie());
      } else {
         var1.setEcrCoefGrp(this.utilNombre.deviseTaux2(var1.getEcrDeviseGrp(), var1.getEcrDateSaisie()));
         var1.setEcrDebitGrp(this.utilNombre.myRoundDevise(var1.getEcrDebitSaisie() * (double)var1.getEcrCoefGrp(), var1.getEcrDeviseGrp()));
         var1.setEcrCreditGrp(this.utilNombre.myRoundDevise(var1.getEcrCreditSaisie() * (double)var1.getEcrCoefGrp(), var1.getEcrDeviseGrp()));
      }

      return var1;
   }

   public void recopieThesaurus(Session var1) throws HibernateException, NamingException {
      int var2 = 0;
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Recopie plan comptable...");
      ++this.var_currentValue;
      new ArrayList();
      PlanComptableDao var4 = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.selecFiscalite = this.structureLog.getStrzonefiscale();
      if (this.structureLog.getStrdatefiscale2() != null && this.exerciceNouvel.getExecptDateDebut().compareTo(this.structureLog.getStrdatefiscale2()) >= 0) {
         this.selecFiscalite = this.structureLog.getStrzonefiscale2();
      }

      List var3 = var4.chargerLesPlanComptables(this.exerciceLast.getExecpt_id(), var1);
      if (var3.size() != 0) {
         for(int var5 = 0; var5 < var3.size(); ++var5) {
            PlanComptable var6 = new PlanComptable();
            new PlanComptable();
            PlanComptable var7 = (PlanComptable)var3.get(var5);
            if (var7.getPlcInactif() == 0) {
               var6.setExercicesComptable(this.exerciceNouvel);
               var6.setPlcFiscalite(this.selecFiscalite);
               var6.setPlcAnalCle1(var7.getPlcAnalCle1());
               var6.setPlcAnalCle2(var7.getPlcAnalCle2());
               var6.setPlcCodeRacine(var7.getPlcCodeRacine());
               var6.setPlcCompte(var7.getPlcCompte());
               var6.setPlcDateCreat(new Date());
               var6.setPlcDateModif((Date)null);
               var6.setPlcInactif(var7.getPlcInactif());
               var6.setPlcLibelleCpteFR(var7.getPlcLibelleCpteFR());
               var6.setPlcLibelleCpteSP(var7.getPlcLibelleCpteSP());
               var6.setPlcLibelleCpteUK(var7.getPlcLibelleCpteUK());
               var6.setPlcLibelleNatureFR(var7.getPlcLibelleNatureFR());
               var6.setPlcLibelleNatureSP(var7.getPlcLibelleNatureSP());
               var6.setPlcLibelleNatureUK(var7.getPlcLibelleNatureUK());
               var6.setPlcLibelleRacineFR(var7.getPlcLibelleRacineFR());
               var6.setPlcLibelleRacineSP(var7.getPlcLibelleRacineSP());
               var6.setPlcLibelleRacineUK(var7.getPlcLibelleRacineUK());
               var6.setPlcLibre(var7.getPlcLibre());
               var6.setPlcNature(var7.getPlcNature());
               var6.setPlcRanDetaille(var7.isPlcRanDetaille());
               var6.setPlcSens(var7.getPlcSens());
               var6.setPlcTauxTaxe(var7.getPlcTauxTaxe());
               var6.setPlcUserCreat(this.usersLog.getUsrid());
               var6.setPlcUserModif(0L);
               var4.insert(var6, var1);
               ++var2;
               if (var2 == this.cptMaxFlush) {
                  var1.flush();
                  var2 = 0;
               }
            }
         }

         var1.flush();
      }

      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Recopie journaux comptables...");
      ++this.var_currentValue;
      new ArrayList();
      JournauxComptablesDao var16 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      List var15 = var16.chargerLesJournauxComptables(this.exerciceLast.getExecpt_id(), 0, var1);
      if (var15.size() != 0) {
         for(int var17 = 0; var17 < var15.size(); ++var17) {
            JournauxComptables var8 = new JournauxComptables();
            new JournauxComptables();
            JournauxComptables var9 = (JournauxComptables)var15.get(var17);
            if (var9.getPljInactif() == 0) {
               var8.setExercice(this.exerciceNouvel);
               var8.setPljBudjet(var9.getPljBudjet());
               var8.setPljChoixDevise(var9.getPljChoixDevise());
               var8.setPljCode(var9.getPljCode());
               var8.setPljCompteTreso(var9.getPljCompteTreso());
               var8.setPljCompteTresoNew(var9.getPljCompteTresoNew());
               var8.setPljDateCreat(new Date());
               var8.setPljDateModif((Date)null);
               var8.setPljDvAbhp(var9.getPljDvAbhp());
               var8.setPljDvAbsp(var9.getPljDvAbsp());
               var8.setPljDvMbhp(var9.getPljDvMbhp());
               var8.setPljDvMbsp(var9.getPljDvMbsp());
               var8.setPljFormatDevise(var9.getPljFormatDevise());
               var8.setPljInactif(var9.getPljInactif());
               var8.setPljInactifFR(var9.getPljInactifFR());
               var8.setPljLibelleFr(var9.getPljLibelleFr());
               var8.setPljLibelleSp(var9.getPljLibelleSp());
               var8.setPljLibelleUk(var9.getPljLibelleUk());
               var8.setPljModeTreso(var9.getPljModeTreso());
               var8.setPljNature(var9.getPljNature());
               var8.setPljPiece(var9.getPljPiece());
               var8.setPljReserve(var9.getPljReserve());
               var8.setPljScenario(var9.getPljScenario());
               var8.setPljTypeDevise(var9.getPljTypeDevise());
               var8.setPljUserCreat(this.usersLog.getUsrid());
               var8.setPljUserModif(0L);
               var16.insert(var8, var1);
               ++var2;
               if (var2 == this.cptMaxFlush) {
                  var1.flush();
                  var2 = 0;
               }
            }
         }

         var1.flush();
      }

      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Recopie plan budgetaire...");
      ++this.var_currentValue;
      new ArrayList();
      PlansBudgetairesDao var19 = new PlansBudgetairesDao(this.baseLog, this.utilInitHibernate);
      String var20 = "" + this.exerciceNouvel.getExecpt_id();
      List var18 = var19.chargerLesPlansBudgetairesAnnee(0, var20, var1);
      if (var18.size() != 0) {
         for(int var10 = 0; var10 < var18.size(); ++var10) {
            new PlansBudgetaires();
            PlansBudgetaires var11 = (PlansBudgetaires)var18.get(var10);
            var11.setExercicesComptable(this.exerciceNouvel);
            var19.modif(var11, var1);
            ++var2;
            if (var2 == this.cptMaxFlush) {
               var1.flush();
               var2 = 0;
            }
         }

         var1.flush();
      }

      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Recopie plan de trésoreie...");
      ++this.var_currentValue;
      new ArrayList();
      PlansTresorerieDao var22 = new PlansTresorerieDao(this.baseLog, this.utilInitHibernate);
      List var21 = var22.chargerLesPlansTresorerieAnnee(this.exerciceLast, var1);
      if (var21.size() != 0) {
         for(int var12 = 0; var12 < var21.size(); ++var12) {
            PlansTresorerie var13 = new PlansTresorerie();
            new PlansTresorerie();
            PlansTresorerie var14 = (PlansTresorerie)var21.get(var12);
            if (var14.getTreInactif() == 0) {
               var13.setExercicesComptable(this.exerciceNouvel);
               var13.setTreAnnee("" + this.exerciceNouvel.getExecpt_id());
               var13.setTreCode(var14.getTreCode());
               var13.setTreCompte(var14.getTreCompte());
               var13.setTreDateCreat(new Date());
               var13.setTreDateModif((Date)null);
               var13.setTreIdUsers(var14.getTreIdUsers());
               var13.setTreInactif(0);
               var13.setTreLibelleCompte(var14.getTreLibelleCompte());
               var13.setTreLibelleFr(var14.getTreLibelleFr());
               var13.setTreLibelleSp(var14.getTreLibelleSp());
               var13.setTreLibelleUk(var14.getTreLibelleUk());
               var13.setTreOrdre(var14.getTreOrdre());
               var13.setTreProjet(var14.getTreProjet());
               var13.setTreType(var14.getTreType());
               var13.setTreUserCreat(this.usersLog.getUsrid());
               var13.setTreUserModif(0L);
               var22.insert(var13, var1);
               ++var2;
               if (var2 == this.cptMaxFlush) {
                  var1.flush();
                  var2 = 0;
               }
            }
         }

         var1.flush();
      }

   }

   public void generationJournalAN(Session var1) throws HibernateException, NamingException, ParseException {
      Date var2 = this.utilDate.dateJourSuivant(this.datecloture);
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Suppression ancienne clotue (AN)...");
      ++this.var_currentValue;
      String var3 = "AN:" + this.calculPeriode(this.utilDate.dateToStringSQL(var2));
      new ArrayList();
      List var4 = this.ecrituresDao.recupererSelectedECByCle1(var3, var1);
      if (var4.size() != 0) {
         this.ecrituresDao.removeSelectedEC2(var4, this.cptMaxFlush, var1);
         var1.flush();
         var4.clear();
      }

      byte var5 = 1;
      String var6 = "";
      if (var5 <= 9) {
         var6 = "0" + var5;
      } else {
         var6 = "" + var5;
      }

      int var7 = var2.getMonth() + 1;
      String var8 = "";
      if (var7 <= 9) {
         var8 = "0" + var7;
      } else {
         var8 = "" + var7;
      }

      String var9 = "" + (var2.getYear() + 1900);
      String var10 = var9 + "-" + var8 + "-" + var6;
      Date var11 = this.utilDate.stringToDateSQLLight(var10);
      this.listeAN.clear();
      this.listeANLettre.clear();
      this.listeANComplement.clear();
      this.listeANComplementTmp.clear();
      this.listeAnalytique.clear();
      this.listeCompte.clear();
      Ecritures var12 = new Ecritures();
      this.classe1AN(var12, var11, var10, var1);
      this.classe2AN(var12, var11, var10, var1);
      this.classe3AN(var12, var11, var10, var1);
      this.classe38AN(var12, var11, var10, var1);
      this.classe4AN(var12, var11, var10, var1);
      this.classe5AN(var12, var11, var10, var1);
      this.resultatAN(var12, var11, var10, var1);
      this.lettrageCheval(var12, var11, var10, var1);
      this.listeEcriture.clear();
      this.majAN(var12, var1);
      this.majLettresAN(var12, var1);
      this.effacelettreAN(var12, var1);
      this.recopieAnalytiqueAN(var12, var1);
   }

   public void classe1AN(Ecritures var1, Date var2, String var3, Session var4) throws HibernateException, NamingException, ParseException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Generation journal AN...Classe 1...");
      ++this.var_currentValue;
      this.listeCompte = this.ecrituresDao.chargerComptesClasse(this.dateDebutCloture, this.dateFinCloture, "1", var4);
      if (this.listeCompte.size() != 0) {
         this.obm = new ObjetMessageSysteme();
         this.obm.setTexte("Chargement des ecritures Classe 1 du " + this.dateDebutCloture + " au " + this.dateFinCloture);
         ++this.var_currentValue;
         this.listeEcriture.clear();
         this.listeEcriture = this.ecrituresDao.chargerEcrituresByClasse("1", this.dateDebutCloture, this.dateFinCloture, this.dateFinCloture, var4);

         for(int var5 = 0; var5 < this.listeCompte.size(); ++var5) {
            String var6 = ((PlanComptable)this.listeCompte.get(var5)).getPlcCompte();
            this.obm.setTexte("Chargement des ecritures Classe 1 du " + this.dateDebutCloture + " au " + this.dateFinCloture + ": compte " + var6);
            String var7 = ((PlanComptable)this.listeCompte.get(var5)).getPlcLibelleCpteFR();
            int var8 = ((PlanComptable)this.listeCompte.get(var5)).getPlcNature();
            String var9 = "";
            String var10 = "";
            String var11 = "";
            if (!var6.startsWith("131") && !var6.startsWith("139") && this.listeEcriture.size() != 0) {
               double var12 = 0.0D;
               double var14 = 0.0D;

               for(int var16 = 0; var16 < this.listeEcriture.size(); ++var16) {
                  if (((Ecritures)this.listeEcriture.get(var16)).getEcrCompte().equals(var6)) {
                     var12 += ((Ecritures)this.listeEcriture.get(var16)).getEcrDebitSaisie();
                     var14 += ((Ecritures)this.listeEcriture.get(var16)).getEcrCreditSaisie();
                     if (((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseSaisie() != null && !((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseSaisie().isEmpty()) {
                        var9 = ((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseSaisie();
                     } else {
                        var9 = this.structureLog.getStrdevise();
                     }

                     if (((Ecritures)this.listeEcriture.get(var16)).getEcrDevisePays() != null && !((Ecritures)this.listeEcriture.get(var16)).getEcrDevisePays().isEmpty()) {
                        var10 = ((Ecritures)this.listeEcriture.get(var16)).getEcrDevisePays();
                     } else {
                        var10 = this.structureLog.getStrdevise();
                     }

                     if (((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseGrp() != null && !((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseGrp().isEmpty()) {
                        var11 = ((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseGrp();
                     } else {
                        var11 = this.structureLog.getStrdevise();
                     }
                  }
               }

               var1 = new Ecritures();
               var1.setExercicesComptable(this.exerciceNouvel);
               var1.setEcrCode("AN");
               var1.setEcrNatureJrx(15);
               var1.setEcrCompte(var6);
               var1.setEcrNature(var8);
               var1.setEcrPiece("AN");
               var1.setEcrDateSaisie(var2);
               var1.setEcrJour(var2.getDay() + 1);
               var1.setEcrAnnee("" + (var2.getYear() + 1900));
               var1.setEcrPeriode(this.calculPeriode(var3));
               var1.setEcrCloture(0);
               var1.setEcrLibelle(var7);
               var1.setEcrLibCompte(var7);
               var1.setEcrDeviseSaisie(var9);
               var1.setEcrDevisePays(var10);
               var1.setEcrDeviseGrp(var11);
               var1.setEcrCle1(this.calculCle1(var1.getEcrPeriode(), var1.getEcrCode()));
               var1.setEcrCle2(this.calculCle2(var1.getEcrCode(), var3));
               if (var12 > var14) {
                  var1.setEcrDebitSaisie(var12 - var14);
                  var1.setEcrCreditSaisie(0.0D);
               } else {
                  var1.setEcrDebitSaisie(0.0D);
                  var1.setEcrCreditSaisie(var14 - var12);
               }

               if (var12 != 0.0D || var14 != 0.0D) {
                  var1 = this.calculSuiteEcriture(var1);
                  this.listeAN.add(var1);
               }
            }
         }
      }

   }

   public void classe2AN(Ecritures var1, Date var2, String var3, Session var4) throws HibernateException, NamingException, ParseException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Generation journal AN...Classe 2...");
      ++this.var_currentValue;
      this.listeCompte = this.ecrituresDao.chargerComptesClasse(this.dateDebutCloture, this.dateFinCloture, "2", var4);
      if (this.listeCompte.size() != 0) {
         this.obm = new ObjetMessageSysteme();
         this.obm.setTexte("Chargement des ecritures Classe 2 du " + this.dateDebutCloture + " au " + this.dateFinCloture);
         ++this.var_currentValue;
         this.listeEcriture.clear();
         this.listeEcriture = this.ecrituresDao.chargerEcrituresByClasse("2", this.dateDebutCloture, this.dateFinCloture, this.dateFinCloture, var4);

         for(int var5 = 0; var5 < this.listeCompte.size(); ++var5) {
            String var6 = ((PlanComptable)this.listeCompte.get(var5)).getPlcCompte();
            this.obm.setTexte("Chargement des ecritures Classe 2 du " + this.dateDebutCloture + " au " + this.dateFinCloture + ": compte " + var6);
            String var7 = ((PlanComptable)this.listeCompte.get(var5)).getPlcLibelleCpteFR();
            int var8 = ((PlanComptable)this.listeCompte.get(var5)).getPlcNature();
            String var9 = "";
            String var10 = "";
            String var11 = "";
            if (this.listeEcriture.size() != 0) {
               double var12 = 0.0D;
               double var14 = 0.0D;

               for(int var16 = 0; var16 < this.listeEcriture.size(); ++var16) {
                  if (((Ecritures)this.listeEcriture.get(var16)).getEcrCompte().equals(var6)) {
                     var12 += ((Ecritures)this.listeEcriture.get(var16)).getEcrDebitSaisie();
                     var14 += ((Ecritures)this.listeEcriture.get(var16)).getEcrCreditSaisie();
                     if (((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseSaisie() != null && !((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseSaisie().isEmpty()) {
                        var9 = ((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseSaisie();
                     } else {
                        var9 = this.structureLog.getStrdevise();
                     }

                     if (((Ecritures)this.listeEcriture.get(var16)).getEcrDevisePays() != null && !((Ecritures)this.listeEcriture.get(var16)).getEcrDevisePays().isEmpty()) {
                        var10 = ((Ecritures)this.listeEcriture.get(var16)).getEcrDevisePays();
                     } else {
                        var10 = this.structureLog.getStrdevise();
                     }

                     if (((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseGrp() != null && !((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseGrp().isEmpty()) {
                        var11 = ((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseGrp();
                     } else {
                        var11 = this.structureLog.getStrdevise();
                     }
                  }
               }

               var1 = new Ecritures();
               var1.setExercicesComptable(this.exerciceNouvel);
               var1.setEcrCode("AN");
               var1.setEcrNatureJrx(15);
               var1.setEcrCompte(var6);
               var1.setEcrNature(var8);
               var1.setEcrPiece("AN");
               var1.setEcrDateSaisie(var2);
               var1.setEcrJour(var2.getDay() + 1);
               var1.setEcrAnnee("" + (var2.getYear() + 1900));
               var1.setEcrPeriode(this.calculPeriode(var3));
               var1.setEcrCloture(0);
               var1.setEcrLibelle(var7);
               var1.setEcrLibCompte(var7);
               var1.setEcrDeviseSaisie(var9);
               var1.setEcrDevisePays(var10);
               var1.setEcrDeviseGrp(var11);
               var1.setEcrCle1(this.calculCle1(var1.getEcrPeriode(), var1.getEcrCode()));
               var1.setEcrCle2(this.calculCle2(var1.getEcrCode(), var3));
               if (var12 > var14) {
                  var1.setEcrDebitSaisie(var12 - var14);
                  var1.setEcrCreditSaisie(0.0D);
               } else {
                  var1.setEcrDebitSaisie(0.0D);
                  var1.setEcrCreditSaisie(var14 - var12);
               }

               if (var12 != 0.0D || var14 != 0.0D) {
                  var1 = this.calculSuiteEcriture(var1);
                  this.listeAN.add(var1);
               }
            }
         }
      }

   }

   public void classe3AN(Ecritures var1, Date var2, String var3, Session var4) throws HibernateException, NamingException, ParseException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Generation journal AN...Classe 3, sauf 38...");
      ++this.var_currentValue;
      this.listeCompte = this.ecrituresDao.chargerComptesClasse(this.dateDebutCloture, this.dateFinCloture, "3", var4);
      if (this.listeCompte.size() != 0) {
         this.obm = new ObjetMessageSysteme();
         this.obm.setTexte("Chargement des ecritures Classe 3 du " + this.dateDebutCloture + " au " + this.dateFinCloture);
         ++this.var_currentValue;
         this.listeEcriture.clear();
         this.listeEcriture = this.ecrituresDao.chargerEcrituresByClasse("3", this.dateDebutCloture, this.dateFinCloture, this.dateFinCloture, var4);

         for(int var5 = 0; var5 < this.listeCompte.size(); ++var5) {
            if (!((PlanComptable)this.listeCompte.get(var5)).getPlcCompte().startsWith("38")) {
               String var6 = ((PlanComptable)this.listeCompte.get(var5)).getPlcCompte();
               this.obm.setTexte("Chargement des ecritures Classe 3 du " + this.dateDebutCloture + " au " + this.dateFinCloture + ": compte " + var6);
               String var7 = ((PlanComptable)this.listeCompte.get(var5)).getPlcLibelleCpteFR();
               int var8 = ((PlanComptable)this.listeCompte.get(var5)).getPlcNature();
               String var9 = "";
               String var10 = "";
               String var11 = "";
               if (this.listeEcriture.size() != 0) {
                  double var12 = 0.0D;
                  double var14 = 0.0D;

                  for(int var16 = 0; var16 < this.listeEcriture.size(); ++var16) {
                     if (((Ecritures)this.listeEcriture.get(var16)).getEcrCompte().equals(var6)) {
                        var12 += ((Ecritures)this.listeEcriture.get(var16)).getEcrDebitSaisie();
                        var14 += ((Ecritures)this.listeEcriture.get(var16)).getEcrCreditSaisie();
                        if (((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseSaisie() != null && !((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseSaisie().isEmpty()) {
                           var9 = ((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseSaisie();
                        } else {
                           var9 = this.structureLog.getStrdevise();
                        }

                        if (((Ecritures)this.listeEcriture.get(var16)).getEcrDevisePays() != null && !((Ecritures)this.listeEcriture.get(var16)).getEcrDevisePays().isEmpty()) {
                           var10 = ((Ecritures)this.listeEcriture.get(var16)).getEcrDevisePays();
                        } else {
                           var10 = this.structureLog.getStrdevise();
                        }

                        if (((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseGrp() != null && !((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseGrp().isEmpty()) {
                           var11 = ((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseGrp();
                        } else {
                           var11 = this.structureLog.getStrdevise();
                        }
                     }
                  }

                  var1 = new Ecritures();
                  var1.setExercicesComptable(this.exerciceNouvel);
                  var1.setEcrCode("AN");
                  var1.setEcrNatureJrx(15);
                  var1.setEcrCompte(var6);
                  var1.setEcrNature(var8);
                  var1.setEcrPiece("AN");
                  var1.setEcrDateSaisie(var2);
                  var1.setEcrJour(var2.getDay() + 1);
                  var1.setEcrAnnee("" + (var2.getYear() + 1900));
                  var1.setEcrPeriode(this.calculPeriode(var3));
                  var1.setEcrCloture(0);
                  var1.setEcrLibelle(var7);
                  var1.setEcrLibCompte(var7);
                  var1.setEcrDeviseSaisie(var9);
                  var1.setEcrDevisePays(var10);
                  var1.setEcrDeviseGrp(var11);
                  var1.setEcrCle1(this.calculCle1(var1.getEcrPeriode(), var1.getEcrCode()));
                  var1.setEcrCle2(this.calculCle2(var1.getEcrCode(), var3));
                  if (var12 > var14) {
                     var1.setEcrDebitSaisie(var12 - var14);
                     var1.setEcrCreditSaisie(0.0D);
                  } else {
                     var1.setEcrDebitSaisie(0.0D);
                     var1.setEcrCreditSaisie(var14 - var12);
                  }

                  if (var12 != 0.0D || var14 != 0.0D) {
                     var1 = this.calculSuiteEcriture(var1);
                     this.listeAN.add(var1);
                  }
               }
            }
         }
      }

   }

   public void classe38AN(Ecritures var1, Date var2, String var3, Session var4) throws HibernateException, NamingException, ParseException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Generation journal AN...Classe 38...");
      ++this.var_currentValue;
      this.listeCompte = this.ecrituresDao.chargerComptesClasse(this.dateDebutCloture, this.dateFinCloture, "38", var4);
      if (this.listeCompte.size() != 0) {
         this.obm = new ObjetMessageSysteme();
         this.obm.setTexte("Chargement des ecritures Classe 38 du " + this.dateDebutCloture + " au " + this.dateFinCloture);
         ++this.var_currentValue;
         this.listeEcriture.clear();
         this.listeEcriture = this.ecrituresDao.chargerEcrituresByClasse("3", this.dateDebutCloture, this.dateFinCloture, this.dateFinCloture, var4);

         for(int var5 = 0; var5 < this.listeCompte.size(); ++var5) {
            String var6 = ((PlanComptable)this.listeCompte.get(var5)).getPlcCompte();
            this.obm.setTexte("Chargement des ecritures Classe 38 du " + this.dateDebutCloture + " au " + this.dateFinCloture + ": compte " + var6);
            if (this.listeEcriture.size() != 0) {
               boolean var7 = false;

               for(int var8 = 0; var8 < this.listeEcriture.size(); ++var8) {
                  if (((Ecritures)this.listeEcriture.get(var8)).getEcrCompte().equals(var6)) {
                     if (((Ecritures)this.listeEcriture.get(var8)).getEcrLettrage() != null && !((Ecritures)this.listeEcriture.get(var8)).getEcrLettrage().isEmpty()) {
                        var1 = (Ecritures)this.listeEcriture.get(var8);
                        this.listeANLettre.add(var1);
                        var7 = false;
                     } else {
                        var1 = new Ecritures();
                        var1.setExercicesComptable(this.exerciceNouvel);
                        var1.setEcrCode("AN");
                        var1.setEcrNatureJrx(15);
                        var1.setEcrDateSaisie(var2);
                        var1.setEcrJour(var2.getDay() + 1);
                        var1.setEcrCompte(var6);
                        var1.setEcrNature(((Ecritures)this.listeEcriture.get(var8)).getEcrNature());
                        var1.setEcrPiece(((Ecritures)this.listeEcriture.get(var8)).getEcrPiece());
                        var1.setEcrLettrage(((Ecritures)this.listeEcriture.get(var8)).getEcrLettrage());
                        var1.setEcrReference1(((Ecritures)this.listeEcriture.get(var8)).getEcrReference1());
                        var1.setEcrReference2(((Ecritures)this.listeEcriture.get(var8)).getEcrReference2());
                        var1.setEcrDateEcheance(((Ecritures)this.listeEcriture.get(var8)).getEcrDateEcheance());
                        var1.setEcrDateValeurReelle(((Ecritures)this.listeEcriture.get(var8)).getEcrDateValeurReelle());
                        var1.setEcrDateValeurTheo(((Ecritures)this.listeEcriture.get(var8)).getEcrDateValeurTheo());
                        var1.setEcrAnnee("" + (var2.getYear() + 1900));
                        var1.setEcrPeriode(this.calculPeriode(var3));
                        var1.setEcrCloture(0);
                        var1.setEcrLibelle(((Ecritures)this.listeEcriture.get(var8)).getEcrLibelle());
                        var1.setEcrLibCompte(((Ecritures)this.listeEcriture.get(var8)).getEcrLibCompte());
                        var1.setEcrCle1(this.calculCle1(var1.getEcrPeriode(), var1.getEcrCode()));
                        var1.setEcrCle2(this.calculCle2(var1.getEcrCode(), var3));
                        var1.setEcrDebitSaisie(((Ecritures)this.listeEcriture.get(var8)).getEcrDebitSaisie());
                        var1.setEcrCreditSaisie(((Ecritures)this.listeEcriture.get(var8)).getEcrCreditSaisie());
                        var1.setEcrDeviseSaisie(((Ecritures)this.listeEcriture.get(var8)).getEcrDeviseSaisie());
                        var1.setEcrDevisePays(((Ecritures)this.listeEcriture.get(var8)).getEcrDevisePays());
                        var1.setEcrDeviseGrp(((Ecritures)this.listeEcriture.get(var8)).getEcrDeviseGrp());
                        var1 = this.calculSuiteEcriture(var1);
                        var1.setEcrAnaActif(1);
                        if (((Ecritures)this.listeEcriture.get(var8)).getEcrDebitSaisie() != 0.0D || ((Ecritures)this.listeEcriture.get(var8)).getEcrCreditSaisie() != 0.0D) {
                           this.listeAN.add(var1);
                        }

                        var7 = true;
                     }

                     if (var7) {
                        new ArrayList();
                        List var9 = this.ecrituresAnalytiquesDao.chargerLesEcrituresAnalytiques((Ecritures)this.listeEcriture.get(var8), var4);
                        if (var9.size() != 0) {
                           for(int var10 = 0; var10 < var9.size(); ++var10) {
                              EcrituresAnalytique var11 = new EcrituresAnalytique();
                              var11.setEcranaActivite(((EcrituresAnalytique)var9.get(var10)).getEcranaActivite());
                              var11.setEcranaActiviteLib(((EcrituresAnalytique)var9.get(var10)).getEcranaActiviteLib());
                              var11.setEcranaAnal1(((EcrituresAnalytique)var9.get(var10)).getEcranaAnal1());
                              var11.setEcranaAnal1Lib(((EcrituresAnalytique)var9.get(var10)).getEcranaAnal1Lib());
                              var11.setEcranaAnal2(((EcrituresAnalytique)var9.get(var10)).getEcranaAnal2());
                              var11.setEcranaAnal2Lib(((EcrituresAnalytique)var9.get(var10)).getEcranaAnal2Lib());
                              var11.setEcranaAnal3(((EcrituresAnalytique)var9.get(var10)).getEcranaAnal3());
                              var11.setEcranaAnal3Lib(((EcrituresAnalytique)var9.get(var10)).getEcranaAnal3Lib());
                              var11.setEcranaAnal4(((EcrituresAnalytique)var9.get(var10)).getEcranaAnal4());
                              var11.setEcranaAnal4Lib(((EcrituresAnalytique)var9.get(var10)).getEcranaAnal4Lib());
                              var11.setEcranaAtelier(((EcrituresAnalytique)var9.get(var10)).getEcranaAtelier());
                              var11.setEcranaAtelierLib(((EcrituresAnalytique)var9.get(var10)).getEcranaAtelierLib());
                              var11.setEcranaAxe(((EcrituresAnalytique)var9.get(var10)).getEcranaAxe());
                              var11.setEcranaClasse(((EcrituresAnalytique)var9.get(var10)).getEcranaClasse());
                              var11.setEcranaCle(((EcrituresAnalytique)var9.get(var10)).getEcranaCle());
                              var11.setEcranaPeriode(this.calculPeriode(var3));
                              var11.setEcranaCode("AN");
                              var11.setEcranaCle1(this.calculCle1(var11.getEcranaPeriode(), var11.getEcranaCode()));
                              var11.setEcranaCle2(this.calculCle2(var11.getEcranaCode(), var3));
                              var11.setEcranaCompte(((EcrituresAnalytique)var9.get(var10)).getEcranaCompte());
                              var11.setEcranaDateSaisie(var2);
                              var11.setEcranaDepartement(((EcrituresAnalytique)var9.get(var10)).getEcranaDepartement());
                              var11.setEcranaDepartementLib(((EcrituresAnalytique)var9.get(var10)).getEcranaDepartementLib());
                              var11.setEcranaLibelle(((EcrituresAnalytique)var9.get(var10)).getEcranaLibelle());
                              var11.setEcranaLigne(((EcrituresAnalytique)var9.get(var10)).getEcranaLigne());
                              var11.setEcranaLigneLib(((EcrituresAnalytique)var9.get(var10)).getEcranaLigneLib());
                              var11.setEcranaMontantSaisie(((EcrituresAnalytique)var9.get(var10)).getEcranaMontantSaisie());
                              var11.setEcranaNature(((EcrituresAnalytique)var9.get(var10)).getEcranaNature());
                              var11.setEcranaNatureJrx(15);
                              var11.setEcranaOrdre(((EcrituresAnalytique)var9.get(var10)).getEcranaOrdre());
                              var11.setEcranaPdv(((EcrituresAnalytique)var9.get(var10)).getEcranaPdv());
                              var11.setEcranaPdvLib(((EcrituresAnalytique)var9.get(var10)).getEcranaPdvLib());
                              var11.setEcranaPiece(((EcrituresAnalytique)var9.get(var10)).getEcranaPiece());
                              var11.setEcranaPourcentage(((EcrituresAnalytique)var9.get(var10)).getEcranaPourcentage());
                              var11.setEcranaReference1(((EcrituresAnalytique)var9.get(var10)).getEcranaReference1());
                              var11.setEcranaReference2(((EcrituresAnalytique)var9.get(var10)).getEcranaReference2());
                              var11.setEcranaRegion(((EcrituresAnalytique)var9.get(var10)).getEcranaRegion());
                              var11.setEcranaRegionLib(((EcrituresAnalytique)var9.get(var10)).getEcranaRegionLib());
                              var11.setEcranaReserve(((EcrituresAnalytique)var9.get(var10)).getEcranaReserve());
                              var11.setEcranaSecteur(((EcrituresAnalytique)var9.get(var10)).getEcranaSecteur());
                              var11.setEcranaSecteurLib(((EcrituresAnalytique)var9.get(var10)).getEcranaSecteurLib());
                              var11.setEcranaService(((EcrituresAnalytique)var9.get(var10)).getEcranaService());
                              var11.setEcranaServiceLib(((EcrituresAnalytique)var9.get(var10)).getEcranaServiceLib());
                              var11.setEcranaSite(((EcrituresAnalytique)var9.get(var10)).getEcranaSite());
                              var11.setEcranaSiteLib(((EcrituresAnalytique)var9.get(var10)).getEcranaSiteLib());
                              var11.setEcranaStr(((EcrituresAnalytique)var9.get(var10)).getEcranaStr());
                              var11.setEcranaStrLib(((EcrituresAnalytique)var9.get(var10)).getEcranaStrLib());
                              var11.setEcranaAgent(((EcrituresAnalytique)var9.get(var10)).getEcranaAgent());
                              var11.setEcranaAgentLib(((EcrituresAnalytique)var9.get(var10)).getEcranaAgentLib());
                              if (var11.getEcranaMontantSaisie() != 0.0D) {
                                 var11.setEcranaIdOrigine((long)this.listeAN.indexOf(var1));
                                 var11.setEcranaTypeOrigine("");
                                 this.listeAnalytique.add(var11);
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

   public void classe4AN(Ecritures var1, Date var2, String var3, Session var4) throws HibernateException, NamingException, ParseException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Generation journal AN...Classe 4...");
      ++this.var_currentValue;
      this.listeCompte = this.ecrituresDao.chargerComptesClasse(this.dateDebutCloture, this.dateFinCloture, "4", var4);
      if (this.listeCompte.size() != 0) {
         this.obm = new ObjetMessageSysteme();
         this.obm.setTexte("Chargement des ecritures Classe 4 du " + this.dateDebutCloture + " au " + this.dateFinCloture);
         ++this.var_currentValue;
         new EcrituresLight();

         for(int var6 = 0; var6 < this.listeCompte.size(); ++var6) {
            String var7 = ((PlanComptable)this.listeCompte.get(var6)).getPlcCompte();
            if (var7 != null && !var7.isEmpty()) {
               this.obm.setTexte("Chargement des ecritures Classe 4 du " + this.dateDebutCloture + " au " + this.dateFinCloture + ": compte " + var7);
               this.listeEcritureLight.clear();
               this.listeEcritureLight = this.ecrituresDao.chargerEcrituresByClasseLight(var7, this.dateDebutCloture, this.dateFinCloture, this.dateFinCloture, var4);
               if (this.listeEcriture.size() != 0) {
                  double var8 = 0.0D;
                  double var10 = 0.0D;
                  boolean var12 = false;

                  EcrituresLight var5;
                  int var13;
                  for(var13 = 0; var13 < this.listeEcritureLight.size(); ++var13) {
                     var5 = (EcrituresLight)this.listeEcritureLight.get(var13);
                     if (var5.getEcrDateSaisie().getYear() + 1900 == this.datecloture.getYear() + 1900 && (var5.getEcrLettrage() == null || var5.getEcrLettrage().isEmpty())) {
                        var8 += var5.getEcrDebitSaisie();
                        var10 += var5.getEcrCreditSaisie();
                     }
                  }

                  if (var8 != var10 || var8 == 0.0D && var10 == 0.0D) {
                     var12 = false;
                  } else {
                     var12 = true;
                  }

                  for(var13 = 0; var13 < this.listeEcritureLight.size(); ++var13) {
                     var5 = (EcrituresLight)this.listeEcritureLight.get(var13);
                     if (var5.getEcrLettrage() != null && !var5.getEcrLettrage().isEmpty()) {
                        new Ecritures();
                        var1 = this.ecrituresDao.recupererSelectedECById(var5.getEcr_id(), var4);
                        if (var1 != null) {
                           this.listeANLettre.add(var1);
                        }
                     } else if (!var12) {
                        var1 = new Ecritures();
                        var1.setExercicesComptable(this.exerciceNouvel);
                        var1.setEcrCode("AN");
                        var1.setEcrNatureJrx(15);
                        var1.setEcrDateSaisie(var2);
                        var1.setEcrJour(var2.getDay() + 1);
                        var1.setEcrCompte(var7);
                        var1.setEcrNature(var5.getEcrNature());
                        var1.setEcrPiece(var5.getEcrPiece());
                        var1.setEcrLettrage(var5.getEcrLettrage());
                        var1.setEcrReference1(var5.getEcrReference1());
                        var1.setEcrReference2(var5.getEcrReference2());
                        var1.setEcrDateEcheance(var5.getEcrDateEcheance());
                        var1.setEcrDateValeurReelle((Date)null);
                        var1.setEcrDateValeurTheo(var5.getEcrDateValeurTheo());
                        var1.setEcrAnnee("" + (var2.getYear() + 1900));
                        var1.setEcrPeriode(this.calculPeriode(var3));
                        var1.setEcrCloture(0);
                        var1.setEcrLibelle(var5.getEcrLibelle());
                        var1.setEcrLibCompte(var5.getEcrLibCompte());
                        var1.setEcrCle1(this.calculCle1(var1.getEcrPeriode(), var1.getEcrCode()));
                        var1.setEcrCle2(this.calculCle2(var1.getEcrCode(), var3));
                        var1.setEcrDebitSaisie(var5.getEcrDebitSaisie());
                        var1.setEcrCreditSaisie(var5.getEcrCreditSaisie());
                        var1.setEcrDeviseSaisie(var5.getEcrDeviseSaisie());
                        var1.setEcrDevisePays(var5.getEcrDevisePays());
                        var1.setEcrDeviseGrp(var5.getEcrDeviseGrp());
                        var1 = this.calculSuiteEcriture(var1);
                        if (var5.getEcrDebitSaisie() != 0.0D || var5.getEcrCreditSaisie() != 0.0D) {
                           this.listeAN.add(var1);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public void classe5AN(Ecritures var1, Date var2, String var3, Session var4) throws HibernateException, NamingException, ParseException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Generation journal AN...Classe 5...");
      ++this.var_currentValue;
      this.listeCompte = this.ecrituresDao.chargerComptesClasse(this.dateDebutCloture, this.dateFinCloture, "5", var4);
      if (this.listeCompte.size() != 0) {
         this.obm = new ObjetMessageSysteme();
         this.obm.setTexte("Chargement des ecritures Classe 5 du " + this.dateDebutCloture + " au " + this.dateFinCloture);
         ++this.var_currentValue;
         this.listeEcriture.clear();
         this.listeEcriture = this.ecrituresDao.chargerEcrituresByClasse("5", this.dateDebutCloture, this.dateFinCloture, this.dateFinCloture, var4);

         for(int var5 = 0; var5 < this.listeCompte.size(); ++var5) {
            String var6 = ((PlanComptable)this.listeCompte.get(var5)).getPlcCompte();
            this.obm.setTexte("Chargement des ecritures Classe 5 du " + this.dateDebutCloture + " au " + this.dateFinCloture + ":compte " + var6);
            String var7 = ((PlanComptable)this.listeCompte.get(var5)).getPlcLibelleCpteFR();
            int var8 = ((PlanComptable)this.listeCompte.get(var5)).getPlcNature();
            String var9 = "";
            String var10 = "";
            String var11 = "";
            if (this.listeEcriture.size() != 0) {
               double var12 = 0.0D;
               double var14 = 0.0D;

               for(int var16 = 0; var16 < this.listeEcriture.size(); ++var16) {
                  if (((Ecritures)this.listeEcriture.get(var16)).getEcrCompte().equals(var6) && (((Ecritures)this.listeEcriture.get(var16)).getEcrLettrage() == null || ((Ecritures)this.listeEcriture.get(var16)).getEcrLettrage().isEmpty())) {
                     var12 += ((Ecritures)this.listeEcriture.get(var16)).getEcrDebitSaisie();
                     var14 += ((Ecritures)this.listeEcriture.get(var16)).getEcrCreditSaisie();
                     if (((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseSaisie() != null && !((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseSaisie().isEmpty()) {
                        var9 = ((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseSaisie();
                     } else {
                        var9 = this.structureLog.getStrdevise();
                     }

                     if (((Ecritures)this.listeEcriture.get(var16)).getEcrDevisePays() != null && !((Ecritures)this.listeEcriture.get(var16)).getEcrDevisePays().isEmpty()) {
                        var10 = ((Ecritures)this.listeEcriture.get(var16)).getEcrDevisePays();
                     } else {
                        var10 = this.structureLog.getStrdevise();
                     }

                     if (((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseGrp() != null && !((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseGrp().isEmpty()) {
                        var11 = ((Ecritures)this.listeEcriture.get(var16)).getEcrDeviseGrp();
                     } else {
                        var11 = this.structureLog.getStrdevise();
                     }
                  }
               }

               var1 = new Ecritures();
               var1.setExercicesComptable(this.exerciceNouvel);
               var1.setEcrCode("AN");
               var1.setEcrNatureJrx(15);
               var1.setEcrCompte(var6);
               var1.setEcrNature(var8);
               var1.setEcrPiece("AN");
               var1.setEcrDateSaisie(var2);
               var1.setEcrJour(var2.getDay() + 1);
               var1.setEcrAnnee("" + (var2.getYear() + 1900));
               var1.setEcrPeriode(this.calculPeriode(var3));
               var1.setEcrCloture(0);
               var1.setEcrLibelle(var7);
               var1.setEcrLibCompte(var7);
               var1.setEcrDeviseSaisie(var9);
               var1.setEcrDevisePays(var10);
               var1.setEcrDeviseGrp(var11);
               var1.setEcrCle1(this.calculCle1(var1.getEcrPeriode(), var1.getEcrCode()));
               var1.setEcrCle2(this.calculCle2(var1.getEcrCode(), var3));
               if (var12 > var14) {
                  var1.setEcrDebitSaisie(var12 - var14);
                  var1.setEcrCreditSaisie(0.0D);
               } else {
                  var1.setEcrDebitSaisie(0.0D);
                  var1.setEcrCreditSaisie(var14 - var12);
               }

               if (var12 != 0.0D || var14 != 0.0D) {
                  var1 = this.calculSuiteEcriture(var1);
                  this.listeAN.add(var1);
               }
            }
         }
      }

   }

   public void resultatAN(Ecritures var1, Date var2, String var3, Session var4) throws HibernateException, NamingException, ParseException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Generation journal cloture : recuperation resultat en attente");
      ++this.var_currentValue;
      String var5;
      String var6;
      int var7;
      double var8;
      double var10;
      if (this.ecritureResultat != null) {
         var5 = this.ecritureResultat.getEcrCompte();
         var6 = this.ecritureResultat.getEcrLibCompte();
         var7 = this.ecritureResultat.getEcrNature();
         var8 = this.ecritureResultat.getEcrDebitSaisie();
         var10 = this.ecritureResultat.getEcrCreditSaisie();
         var1 = new Ecritures();
         var1.setExercicesComptable(this.exerciceNouvel);
         var1.setEcrCode("AN");
         var1.setEcrNatureJrx(15);
         int var12 = var5.length() - 4;
         String var13 = "";
         if (var5.contains("131")) {
            var13 = "1301";
         } else {
            var13 = "1309";
         }

         if (var12 == 1) {
            var1.setEcrCompte(var13 + "0");
         } else if (var12 == 2) {
            var1.setEcrCompte(var13 + "00");
         } else if (var12 == 3) {
            var1.setEcrCompte(var13 + "000");
         } else if (var12 == 4) {
            var1.setEcrCompte(var13 + "0000");
         } else if (var12 == 5) {
            var1.setEcrCompte(var13 + "00000");
         } else if (var12 == 6) {
            var1.setEcrCompte(var13 + "000000");
         } else if (var12 == 7) {
            var1.setEcrCompte(var13 + "0000000");
         } else if (var12 == 8) {
            var1.setEcrCompte(var13 + "00000000");
         } else if (var12 == 9) {
            var1.setEcrCompte(var13 + "000000000");
         } else if (var12 == 10) {
            var1.setEcrCompte(var13 + "0000000000");
         } else if (var12 == 11) {
            var1.setEcrCompte(var13 + "00000000000");
         } else if (var12 == 12) {
            var1.setEcrCompte(var13 + "000000000000");
         } else if (var12 == 13) {
            var1.setEcrCompte(var13 + "0000000000000");
         } else if (var12 == 14) {
            var1.setEcrCompte(var13 + "00000000000000");
         } else if (var12 == 15) {
            var1.setEcrCompte(var13 + "000000000000000");
         } else if (var12 == 16) {
            var1.setEcrCompte(var13 + "0000000000000000");
         }

         var1.setEcrNature(var7);
         var1.setEcrPiece("AN");
         var1.setEcrDateSaisie(var2);
         var1.setEcrJour(var2.getDay() + 1);
         var1.setEcrAnnee("" + (var2.getYear() + 1900));
         var1.setEcrPeriode(this.calculPeriode(var3));
         var1.setEcrCloture(0);
         var1.setEcrLibelle(var6);
         var1.setEcrLibCompte(var6);
         var1.setEcrDeviseSaisie(this.structureLog.getStrdevise());
         var1.setEcrDevisePays(this.structureLog.getStrdevise());
         var1.setEcrDeviseGrp(this.structureLog.getStrdevise());
         var1.setEcrCle1(this.calculCle1(var1.getEcrPeriode(), var1.getEcrCode()));
         var1.setEcrCle2(this.calculCle2(var1.getEcrCode(), var3));
         var1.setEcrDebitSaisie(var8);
         var1.setEcrCreditSaisie(var10);
         if (var8 != 0.0D || var10 != 0.0D) {
            var1 = this.calculSuiteEcriture(var1);
            this.listeAN.add(var1);
         }
      }

      if (this.sensPerteBenefie == 1) {
         if (this.ecritureReportPerte != null) {
            var5 = this.ecritureReportPerte.getEcrCompte();
            var6 = this.ecritureReportPerte.getEcrLibCompte();
            var7 = this.ecritureReportPerte.getEcrNature();
            var8 = this.ecritureReportPerte.getEcrDebitSaisie();
            var10 = this.ecritureReportPerte.getEcrCreditSaisie();
            var1 = new Ecritures();
            var1.setExercicesComptable(this.exerciceNouvel);
            var1.setEcrCode("AN");
            var1.setEcrCompte(var5);
            var1.setEcrNatureJrx(15);
            var1.setEcrNature(var7);
            var1.setEcrPiece("AN");
            var1.setEcrDateSaisie(var2);
            var1.setEcrJour(var2.getDay() + 1);
            var1.setEcrAnnee("" + (var2.getYear() + 1900));
            var1.setEcrPeriode(this.calculPeriode(var3));
            var1.setEcrCloture(0);
            var1.setEcrLibelle(var6);
            var1.setEcrLibCompte(var6);
            var1.setEcrDeviseSaisie(this.structureLog.getStrdevise());
            var1.setEcrDevisePays(this.structureLog.getStrdevise());
            var1.setEcrDeviseGrp(this.structureLog.getStrdevise());
            var1.setEcrCle1(this.calculCle1(var1.getEcrPeriode(), var1.getEcrCode()));
            var1.setEcrCle2(this.calculCle2(var1.getEcrCode(), var3));
            var1.setEcrDebitSaisie(var8);
            var1.setEcrCreditSaisie(var10);
            if (var8 != 0.0D || var10 != 0.0D) {
               var1 = this.calculSuiteEcriture(var1);
               this.listeAN.add(var1);
            }
         }
      } else if (this.sensPerteBenefie == 2 && this.ecritureReportBenefice != null) {
         var5 = this.ecritureReportBenefice.getEcrCompte();
         var6 = this.ecritureReportBenefice.getEcrLibCompte();
         var7 = this.ecritureReportBenefice.getEcrNature();
         var8 = this.ecritureReportBenefice.getEcrDebitSaisie();
         var10 = this.ecritureReportBenefice.getEcrCreditSaisie();
         var1 = new Ecritures();
         var1.setExercicesComptable(this.exerciceNouvel);
         var1.setEcrCode("AN");
         var1.setEcrCompte(var5);
         var1.setEcrNatureJrx(15);
         var1.setEcrNature(var7);
         var1.setEcrPiece("AN");
         var1.setEcrDateSaisie(var2);
         var1.setEcrJour(var2.getDay() + 1);
         var1.setEcrAnnee("" + (var2.getYear() + 1900));
         var1.setEcrPeriode(this.calculPeriode(var3));
         var1.setEcrCloture(0);
         var1.setEcrLibelle(var6);
         var1.setEcrLibCompte(var6);
         var1.setEcrDeviseSaisie(this.structureLog.getStrdevise());
         var1.setEcrDevisePays(this.structureLog.getStrdevise());
         var1.setEcrDeviseGrp(this.structureLog.getStrdevise());
         var1.setEcrCle1(this.calculCle1(var1.getEcrPeriode(), var1.getEcrCode()));
         var1.setEcrCle2(this.calculCle2(var1.getEcrCode(), var3));
         var1.setEcrDebitSaisie(var8);
         var1.setEcrCreditSaisie(var10);
         if (var8 != 0.0D || var10 != 0.0D) {
            var1 = this.calculSuiteEcriture(var1);
            this.listeAN.add(var1);
         }
      }

   }

   public void lettrageCheval(Ecritures var1, Date var2, String var3, Session var4) throws HibernateException, NamingException, ParseException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Gestion des lettrages sur 2 exercices");
      ++this.var_currentValue;
      if (this.listeANLettre.size() != 0) {
         ArrayList var5 = new ArrayList();
         ArrayList var6 = new ArrayList();
         ArrayList var7 = new ArrayList();
         Object var8 = new ArrayList();
         new Ecritures();
         String var9 = "";
         String var10 = "";
         boolean var11 = false;

         int var12;
         int var13;
         for(var12 = 0; var12 < this.listeANLettre.size(); ++var12) {
            var1 = (Ecritures)this.listeANLettre.get(var12);
            var9 = var1.getEcrCompte();
            if (var5.size() == 0) {
               var5.add(var9);
            } else {
               var11 = false;

               for(var13 = 0; var13 < var5.size(); ++var13) {
                  if (((String)var5.get(var13)).toString().equals(var9)) {
                     var11 = true;
                     break;
                  }
               }

               if (!var11) {
                  var5.add(var9);
               }
            }
         }

         if (var5.size() != 0) {
            for(var12 = 0; var12 < var5.size(); ++var12) {
               var9 = ((String)var5.get(var12)).toString();
               this.obm.setTexte("Gestion des lettrages sur 2 exercices: compte " + var9);
               var7.clear();

               for(var13 = 0; var13 < this.listeANLettre.size(); ++var13) {
                  if (((Ecritures)this.listeANLettre.get(var13)).getEcrCompte().equals(var9)) {
                     var7.add(this.listeANLettre.get(var13));
                  }
               }

               if (var7.size() != 0) {
                  var6.clear();

                  for(var13 = 0; var13 < var7.size(); ++var13) {
                     var10 = ((Ecritures)var7.get(var13)).getEcrLettrage();
                     if (var6.size() == 0) {
                        var6.add(var10);
                     } else {
                        var11 = false;

                        for(int var14 = 0; var14 < var6.size(); ++var14) {
                           if (((String)var6.get(var14)).toString().equals(var10)) {
                              var11 = true;
                              break;
                           }
                        }

                        if (!var11) {
                           var6.add(var10);
                        }
                     }
                  }

                  if (var6.size() != 0) {
                     for(var13 = 0; var13 < var6.size(); ++var13) {
                        var10 = ((String)var6.get(var13)).toString();
                        this.obm.setTexte("Gestion des lettrages sur 2 exercices: compte " + var9 + " lettre " + var10);
                        ((List)var8).clear();
                        double var59 = 0.0D;
                        double var16 = 0.0D;

                        for(int var18 = 0; var18 < var7.size(); ++var18) {
                           if (((Ecritures)var7.get(var18)).getEcrLettrage().equalsIgnoreCase(var10)) {
                              ((List)var8).add(var7.get(var18));
                              var59 += ((Ecritures)var7.get(var18)).getEcrDebitPays();
                              var16 += ((Ecritures)var7.get(var18)).getEcrCreditPays();
                           }
                        }

                        if (((List)var8).size() != 0) {
                           if (var59 != var16) {
                              ((List)var8).clear();
                              var8 = this.ecrituresDao.chargerEcrituresByClasse(var9, var10, this.dateDebutCloture, this.dateFinCloture, this.dateFinExercice, var4);
                           }

                           boolean var60 = false;
                           long var19 = (long)(((Ecritures)((List)var8).get(0)).getEcrDateSaisie().getYear() + 1900);
                           long var21 = 0L;

                           for(int var23 = 0; var23 < ((List)var8).size(); ++var23) {
                              var21 = (long)(((Ecritures)((List)var8).get(var23)).getEcrDateSaisie().getYear() + 1900);
                              if (var21 != var19) {
                                 var60 = true;
                                 break;
                              }
                           }

                           if (var60) {
                              new Ecritures();
                              this.listeANComplementTmp.clear();

                              for(int var24 = 0; var24 < ((List)var8).size(); ++var24) {
                                 var1 = (Ecritures)((List)var8).get(var24);
                                 Ecritures var61 = new Ecritures();
                                 var61.setBrouillard((Brouillard)null);
                                 var61.setEcrCompte(var9);
                                 var61.setEcrLettrage(var10);
                                 var61.setEcrIdOrigine(0L);
                                 var61.setEcrLibCompte(var1.getEcrLibCompte());
                                 var61.setEcrNature(var1.getEcrNature());
                                 var61.setEcrNumIf(var1.getEcrNumIf());
                                 var61.setEcrNumTrf("");
                                 var61.setEcrOrdre(var1.getEcrOrdre());
                                 var61.setEcrOrigineBanque(0);
                                 var61.setEcrPiece(var1.getEcrPeriode());
                                 var61.setEcrPointage("");
                                 var61.setEcrPosteTreso("");
                                 var61.setEcrRapprochement("");
                                 var61.setEcrDteRapprochement((Date)null);
                                 var61.setEcrReference1("");
                                 var61.setEcrReference2("");
                                 var61.setEcrReserve(0);
                                 var61.setEcrTreso("");
                                 var61.setEcrTypeOrigine(var1.getEcrTypeOrigine());
                                 var61.setEcrDeviseSaisie(var1.getEcrDeviseSaisie());
                                 var61.setEcrDebitSaisie(var1.getEcrDebitSaisie());
                                 var61.setEcrCreditSaisie(var1.getEcrCreditSaisie());
                                 var61.setEcrDevisePays(var1.getEcrDevisePays());
                                 var61.setEcrCoefPays(var1.getEcrCoefPays());
                                 var61.setEcrDebitPays(var1.getEcrDebitPays());
                                 var61.setEcrCreditPays(var1.getEcrCreditPays());
                                 var61.setEcrCoefEuro(var1.getEcrCoefEuro());
                                 var61.setEcrDebitEuro(var1.getEcrDebitEuro());
                                 var61.setEcrCreditEuro(var1.getEcrCreditEuro());
                                 var61.setEcrDeviseGrp(var1.getEcrDeviseGrp());
                                 var61.setEcrCoefGrp(var1.getEcrCoefGrp());
                                 var61.setEcrDebitGrp(var1.getEcrDebitGrp());
                                 var61.setEcrCreditGrp(var1.getEcrCreditGrp());
                                 if (var1.getEcrDateSaisie().getYear() + 1900 < this.exerciceNouvel.getExecptDateDebut().getYear() + 1900) {
                                    var61.setEcrCode("AN");
                                    var61.setEcrNatureJrx(15);
                                    var61.setEcrLibelle("Cumul lettre " + var1.getEcrLettrage() + " (année précédente)");
                                    var61.setExercicesComptable(this.exerciceNouvel);
                                    var61.setEcrDateSaisie(this.exerciceNouvel.getExecptDateDebut());
                                    var1.setEcrJour(var61.getEcrDateSaisie().getDay() + 1);
                                    var61.setEcrAnnee("" + (var61.getEcrDateSaisie().getYear() + 1900));
                                    var61.setEcrPeriode(this.calculPeriode(this.utilDate.dateToStringSQLLight(var61.getEcrDateSaisie())));
                                    var61.setEcrCle1(this.calculCle1(var61.getEcrPeriode(), var61.getEcrCode()));
                                    var61.setEcrCle2(this.calculCle2(var61.getEcrCode(), this.utilDate.dateToStringSQLLight(var61.getEcrDateSaisie())));
                                    this.listeANComplementTmp.add(var61);
                                 } else {
                                    var61.setEcrCode("....");
                                    var61.setEcrNatureJrx(13);
                                    var61.setEcrLibelle("Cumul lettre " + var1.getEcrLettrage() + " (année suivante)");
                                    var61.setExercicesComptable(this.exercicesComptable);
                                    var61.setEcrDateSaisie(this.datecloture);
                                    var1.setEcrJour(var61.getEcrDateSaisie().getDay() + 1);
                                    var61.setEcrAnnee("" + (this.datecloture.getYear() + 1900));
                                    var61.setEcrPeriode(this.calculPeriode(this.utilDate.dateToStringSQLLight(this.datecloture)));
                                    var61.setEcrCle1(this.calculCle1(var61.getEcrPeriode(), var61.getEcrCode()));
                                    var61.setEcrCle2(this.calculCle2(var61.getEcrCode(), this.utilDate.dateToStringSQLLight(this.datecloture)));
                                    this.listeANComplementTmp.add(var61);
                                 }
                              }

                              if (this.listeANComplementTmp.size() != 0) {
                                 Ecritures var62 = null;
                                 Ecritures var25 = null;
                                 double var26 = 0.0D;
                                 double var28 = 0.0D;
                                 double var30 = 0.0D;
                                 double var32 = 0.0D;
                                 double var34 = 0.0D;
                                 double var36 = 0.0D;
                                 double var38 = 0.0D;
                                 double var40 = 0.0D;
                                 double var42 = 0.0D;
                                 double var44 = 0.0D;
                                 double var46 = 0.0D;
                                 double var48 = 0.0D;
                                 double var50 = 0.0D;
                                 double var52 = 0.0D;
                                 double var54 = 0.0D;
                                 double var56 = 0.0D;

                                 for(int var58 = 0; var58 < this.listeANComplementTmp.size(); ++var58) {
                                    var1 = (Ecritures)this.listeANComplementTmp.get(var58);
                                    if (var1.getEcrDateSaisie().getYear() + 1900 == this.exerciceNouvel.getExecptDateDebut().getYear() + 1900) {
                                       new Ecritures();
                                       var62 = var1;
                                       var26 += var1.getEcrDebitSaisie();
                                       var28 += var1.getEcrCreditSaisie();
                                       var30 += var1.getEcrDebitPays();
                                       var32 += var1.getEcrCreditPays();
                                       var34 += var1.getEcrDebitEuro();
                                       var36 += var1.getEcrCreditEuro();
                                       var38 += var1.getEcrDebitGrp();
                                       var40 += var1.getEcrCreditGrp();
                                    } else {
                                       new Ecritures();
                                       var25 = var1;
                                       var42 += var1.getEcrDebitSaisie();
                                       var44 += var1.getEcrCreditSaisie();
                                       var46 += var1.getEcrDebitPays();
                                       var48 += var1.getEcrCreditPays();
                                       var50 += var1.getEcrDebitEuro();
                                       var52 += var1.getEcrCreditEuro();
                                       var54 += var1.getEcrDebitGrp();
                                       var56 += var1.getEcrCreditGrp();
                                    }
                                 }

                                 if (var62 != null) {
                                    var62.setEcrDebitSaisie(var26);
                                    var62.setEcrCreditSaisie(var28);
                                    var62.setEcrDebitPays(var30);
                                    var62.setEcrCreditPays(var32);
                                    var62.setEcrDebitEuro(var34);
                                    var62.setEcrCreditEuro(var36);
                                    var62.setEcrDebitGrp(var38);
                                    var62.setEcrCreditGrp(var40);
                                    this.listeANComplement.add(var62);
                                 }

                                 if (var25 != null) {
                                    var25.setEcrDebitSaisie(var42);
                                    var25.setEcrCreditSaisie(var44);
                                    var25.setEcrDebitPays(var46);
                                    var25.setEcrCreditPays(var48);
                                    var25.setEcrDebitEuro(var50);
                                    var25.setEcrCreditEuro(var52);
                                    var25.setEcrDebitGrp(var54);
                                    var25.setEcrCreditGrp(var56);
                                    this.listeANComplement.add(var25);
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         var5.clear();
         var6.clear();
         ((List)var8).clear();
         this.listeANComplementTmp.clear();
      }

   }

   public void majAN(Ecritures var1, Session var2) {
      int var3 = 0;
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Mise a jour du journal des AN...");
      ++this.var_currentValue;
      if (this.listeAN.size() != 0) {
         new Ecritures();

         for(int var4 = 0; var4 < this.listeAN.size(); ++var4) {
            var1 = (Ecritures)this.listeAN.get(var4);
            var1.setEcrEtat(1);
            this.obm.setTexte("Mise a jour du journal des AN..." + var4 + " sur " + this.listeAN.size());
            double var5;
            if (var1.getEcrDebitSaisie() != 0.0D && var1.getEcrCreditSaisie() != 0.0D) {
               var5 = var1.getEcrDebitSaisie() - var1.getEcrCreditSaisie();
               if (var5 > 0.0D) {
                  var1.setEcrDebitSaisie(var5);
                  var1.setEcrCreditSaisie(0.0D);
               } else {
                  var1.setEcrDebitSaisie(0.0D);
                  var1.setEcrCreditSaisie(var5 * -1.0D);
               }
            }

            if (var1.getEcrDebitPays() != 0.0D && var1.getEcrCreditPays() != 0.0D) {
               var5 = var1.getEcrDebitPays() - var1.getEcrCreditPays();
               if (var5 > 0.0D) {
                  var1.setEcrDebitPays(var5);
                  var1.setEcrCreditPays(0.0D);
               } else {
                  var1.setEcrDebitPays(0.0D);
                  var1.setEcrCreditPays(var5 * -1.0D);
               }
            }

            if (var1.getEcrDebitGrp() != 0.0D && var1.getEcrCreditGrp() != 0.0D) {
               var5 = var1.getEcrDebitGrp() - var1.getEcrCreditGrp();
               if (var5 > 0.0D) {
                  var1.setEcrDebitGrp(var5);
                  var1.setEcrCreditGrp(0.0D);
               } else {
                  var1.setEcrDebitGrp(0.0D);
                  var1.setEcrCreditGrp(var5 * -1.0D);
               }
            }

            if (var1.getEcrDebitEuro() != 0.0D && var1.getEcrCreditEuro() != 0.0D) {
               var5 = var1.getEcrDebitEuro() - var1.getEcrCreditEuro();
               if (var5 > 0.0D) {
                  var1.setEcrDebitEuro(var5);
                  var1.setEcrCreditEuro(0.0D);
               } else {
                  var1.setEcrDebitEuro(0.0D);
                  var1.setEcrCreditEuro(var5 * -1.0D);
               }
            }

            this.ecrituresDao.insert(var1, var2);
            ++var3;
            if (var3 == this.cptMaxFlush) {
               var2.flush();
               var3 = 0;
            }
         }

         var2.flush();
      }

   }

   public void majLettresAN(Ecritures var1, Session var2) {
      int var3 = 0;
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Mse a jour des lettrages journal des AN...");
      ++this.var_currentValue;
      if (this.listeANComplement.size() != 0) {
         for(int var4 = 0; var4 < this.listeANComplement.size(); ++var4) {
            var1 = (Ecritures)this.listeANComplement.get(var4);
            double var5;
            if (var1.getEcrDebitSaisie() != 0.0D && var1.getEcrCreditSaisie() != 0.0D) {
               var5 = var1.getEcrDebitSaisie() - var1.getEcrCreditSaisie();
               if (var5 > 0.0D) {
                  var1.setEcrDebitSaisie(var5);
                  var1.setEcrCreditSaisie(0.0D);
               } else {
                  var1.setEcrDebitSaisie(0.0D);
                  var1.setEcrCreditSaisie(var5 * -1.0D);
               }
            }

            if (var1.getEcrDebitPays() != 0.0D && var1.getEcrCreditPays() != 0.0D) {
               var5 = var1.getEcrDebitPays() - var1.getEcrCreditPays();
               if (var5 > 0.0D) {
                  var1.setEcrDebitPays(var5);
                  var1.setEcrCreditPays(0.0D);
               } else {
                  var1.setEcrDebitPays(0.0D);
                  var1.setEcrCreditPays(var5 * -1.0D);
               }
            }

            if (var1.getEcrDebitGrp() != 0.0D && var1.getEcrCreditGrp() != 0.0D) {
               var5 = var1.getEcrDebitGrp() - var1.getEcrCreditGrp();
               if (var5 > 0.0D) {
                  var1.setEcrDebitGrp(var5);
                  var1.setEcrCreditGrp(0.0D);
               } else {
                  var1.setEcrDebitGrp(0.0D);
                  var1.setEcrCreditGrp(var5 * -1.0D);
               }
            }

            if (var1.getEcrDebitEuro() != 0.0D && var1.getEcrCreditEuro() != 0.0D) {
               var5 = var1.getEcrDebitEuro() - var1.getEcrCreditEuro();
               if (var5 > 0.0D) {
                  var1.setEcrDebitEuro(var5);
                  var1.setEcrCreditEuro(0.0D);
               } else {
                  var1.setEcrDebitEuro(0.0D);
                  var1.setEcrCreditEuro(var5 * -1.0D);
               }
            }

            this.ecrituresDao.insert(var1, var2);
            ++var3;
            if (var3 == this.cptMaxFlush) {
               var2.flush();
               var3 = 0;
            }
         }

         var2.flush();
      }

   }

   public void effacelettreAN(Ecritures var1, Session var2) {
      this.listeLettre.clear();
      if (this.listeANLettre.size() != 0) {
         for(int var3 = 0; var3 < this.listeANLettre.size(); ++var3) {
            if (((Ecritures)this.listeANLettre.get(var3)).getEcrLettrage() != null && !((Ecritures)this.listeANLettre.get(var3)).getEcrLettrage().isEmpty()) {
               this.listeLettre.add(this.listeANLettre.get(var3));
            }
         }
      }

   }

   public void recopieAnalytiqueAN(Ecritures var1, Session var2) {
      int var3 = 0;
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Recopie des analytiques dans le nouvel exercice...");
      ++this.var_currentValue;
      if (this.listeAnalytique.size() != 0) {
         new EcrituresAnalytique();

         for(int var5 = 0; var5 < this.listeAnalytique.size(); ++var5) {
            EcrituresAnalytique var4 = (EcrituresAnalytique)this.listeAnalytique.get(var5);

            for(int var6 = 0; var6 < this.listeAN.size(); ++var6) {
               if ((long)var6 == var4.getEcranaIdOrigine()) {
                  var1 = (Ecritures)this.listeAN.get(var6);
                  break;
               }
            }

            if (var1 != null) {
               var4.setEcritures(var1);
               this.ecrituresAnalytiquesDao.inserEcritureAnalytiques(var2, var4);
               ++var3;
               if (var3 == this.cptMaxFlush) {
                  var2.flush();
                  var3 = 0;
               }
            }
         }

         var2.flush();
      }

   }

   public void recopieEcritures(Session var1) throws NamingException, ParseException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Recopie ecritures dans le nouvel exercice...");
      ++this.var_currentValue;
      Date var2 = this.utilDate.dateJourSuivant(this.datecloture);
      int var3 = var2.getDate();
      String var4 = "";
      if (var3 <= 9) {
         var4 = "0" + var3;
      } else {
         var4 = "" + var3;
      }

      int var5 = var2.getMonth() + 1;
      String var6 = "";
      if (var5 <= 9) {
         var6 = "0" + var5;
      } else {
         var6 = "" + var5;
      }

      String var7 = "" + (var2.getYear() + 1900);
      String var8 = var7 + ":" + var6 + ":" + var4;
      this.ecrituresDao.changerExercice(var8, this.exerciceNouvel, var1);
   }

   public void recopieBrouillards(Session var1) throws NamingException, ParseException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Recopie brouillards dans le nouvel exercice...");
      ++this.var_currentValue;
      Date var2 = this.utilDate.dateJourSuivant(this.datecloture);
      int var3 = var2.getDate();
      String var4 = "";
      if (var3 <= 9) {
         var4 = "0" + var3;
      } else {
         var4 = "" + var3;
      }

      int var5 = var2.getMonth() + 1;
      String var6 = "";
      if (var5 <= 9) {
         var6 = "0" + var5;
      } else {
         var6 = "" + var5;
      }

      String var7 = "" + (var2.getYear() + 1900);
      String var8 = var7 + ":" + var6 + ":" + var4;
      this.brouillardDao.changerExercice(var8, this.exerciceNouvel, var1);
   }

   public void recopieJournaux(Session var1) throws NamingException, ParseException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Recopie journaux mois dans le nouvel exercice...");
      ++this.var_currentValue;
      new ArrayList();
      JournauxMoisDao var3 = new JournauxMoisDao(this.baseLog, this.utilInitHibernate);
      Date var4 = this.utilDate.dateJourSuivant(this.datecloture);
      int var5 = this.datecloture.getDate();
      String var6 = "";
      if (var5 <= 9) {
         (new StringBuilder()).append("0").append(var5).toString();
      } else {
         (new StringBuilder()).append("").append(var5).toString();
      }

      int var7 = this.datecloture.getMonth() + 1;
      String var8 = "";
      if (var7 <= 9) {
         var8 = "0" + var7;
      } else {
         var8 = "" + var7;
      }

      String var9 = var8 + ":" + (this.datecloture.getYear() + 1900);
      String var10 = ":" + (this.datecloture.getYear() + 1900);
      List var2 = var3.listeJouMemCloture(this.exerciceLast, var1);
      if (var2.size() != 0) {
         new JournauxMois();

         for(int var12 = 0; var12 < var2.size(); ++var12) {
            JournauxMois var11 = (JournauxMois)var2.get(var12);
            String[] var13 = var11.getJoumenPeriode().split(":");
            String var14 = var13[1] + "-" + var13[0] + "-01";
            Date var15 = this.utilDate.stringToDateSQLLight(var14);
            if (!var15.after(var4) && !var15.equals(var4)) {
               if (var11.getJoumenPeriode().equals(var9)) {
                  if (var11.getJoumenCode().equals("AA")) {
                     var11.setJoumenSaisie(1);
                     var3.majJournal(var11, var1);
                     var1.flush();
                  }
               } else if (!var11.getJoumenPeriode().contains(var10)) {
                  var11.setExercicesComptable(this.exerciceNouvel);
                  var3.majJournal(var11, var1);
               }
            } else {
               var11.setExercicesComptable(this.exerciceNouvel);
               if (var11.getJoumenCode().equals("AN") && var15.equals(var4)) {
                  var11.setJoumenSaisie(1);
               }

               var3.majJournal(var11, var1);
               var1.flush();
            }
         }
      }

   }

   public void traitementRapprochement(Session var1) throws HibernateException, NamingException, ParseException {
      boolean var2 = false;
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Calcul des rapprochements bancaires anterieurs...");
      ++this.var_currentValue;
      EcrituresAnterieurDao var3 = new EcrituresAnterieurDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var4 = var3.chargerAnterieur(this.exerciceLast.getExecpt_id(), 0, var1);
      if (var4.size() != 0) {
         new EcrituresAnterieur();

         for(int var6 = 0; var6 < var4.size(); ++var6) {
            EcrituresAnterieur var5 = (EcrituresAnterieur)var4.get(var6);
            if (var5.getEcrantDteRapprochement() == null) {
               EcrituresAnterieur var7 = new EcrituresAnterieur();
               String var8 = "";
               int var9 = this.datecloture.getMonth() + 1;
               if (var9 <= 9) {
                  var8 = "0" + var9;
               } else {
                  var8 = "" + var9;
               }

               String var10 = "" + (this.datecloture.getYear() + 1900);
               var7.setEcrantAnnee(var10);
               var7.setEcrantPeriode(var8 + ":" + var10);
               var7.setEcrantCode(var5.getEcrantCode());
               var7.setEcrantCle1(var7.getEcrantCode() + ":" + var7.getEcrantPeriode());
               var7.setEcrantCloture(0);
               var7.setEcrantCreditSaisie(var5.getEcrantCreditSaisie());
               var7.setEcrantDate(var5.getEcrantDate());
               var7.setEcrantDebitSaisie(var5.getEcrantDebitSaisie());
               var7.setEcrantLibelle(var5.getEcrantLibelle());
               var7.setEcrantPiece(var5.getEcrantPiece());
               var7.setEcrantRapprochement("");
               var7.setEcrantDteRapprochement((Date)null);
               var7.setEcrantReference1(var5.getEcrantReference1());
               var7.setEcrantReference2(var5.getEcrantReference2());
               var7.setEcrantType(0);
               var7.setExercicesComptable(this.exerciceNouvel);
               var3.inser(var7, var1);
               var1.flush();
            }
         }
      }

      new ArrayList();
      List var12 = this.ecrituresDao.ChargerLesEcrituresNonRapp(this.exercicesComptable.getExecpt_id(), this.datecloture, var1);
      if (var12.size() != 0) {
         new Ecritures();

         for(int var14 = 0; var14 < var12.size(); ++var14) {
            Ecritures var13 = (Ecritures)var12.get(var14);
            EcrituresAnterieur var15 = new EcrituresAnterieur();
            var15.setEcrantAnnee(var13.getEcrAnnee());
            String var16 = "";
            int var17 = this.datecloture.getMonth() + 1;
            if (var17 <= 9) {
               var16 = "0" + var17;
            } else {
               var16 = "" + var17;
            }

            String var11 = "" + (this.datecloture.getYear() + 1900);
            var15.setEcrantPeriode(var16 + ":" + var11);
            var15.setEcrantCode(var13.getEcrCode());
            var15.setEcrantCle1(var15.getEcrantCode() + ":" + var15.getEcrantPeriode());
            var15.setEcrantCloture(0);
            var15.setEcrantCreditSaisie(var13.getEcrCreditSaisie());
            var15.setEcrantDate(this.datecloture);
            var15.setEcrantDebitSaisie(var13.getEcrDebitSaisie());
            var15.setEcrantLibelle(var13.getEcrLibelle());
            var15.setEcrantPiece(var13.getEcrPiece());
            var15.setEcrantRapprochement(var13.getEcrRapprochement());
            var15.setEcrantDteRapprochement(var13.getEcrDteRapprochement());
            var15.setEcrantReference1(var13.getEcrReference1());
            var15.setEcrantReference2(var13.getEcrReference2());
            var15.setEcrantType(0);
            var15.setExercicesComptable(this.exerciceNouvel);
            var3.inser(var15, var1);
            var1.flush();
         }
      }

      this.soldeAnterieurRapprochement(var1);
   }

   public void traitementRapprochementFlag(Session var1) throws HibernateException, NamingException, ParseException {
      boolean var2 = false;
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Flag des rapprochements bancaires anterieurs...");
      ++this.var_currentValue;
      new ArrayList();
      List var3 = this.ecrituresDao.ChargerLesEcrituresNonRapp(this.exercicesComptable.getExecpt_id(), this.datecloture, var1);
      if (var3.size() != 0) {
         new Ecritures();

         for(int var5 = 0; var5 < var3.size(); ++var5) {
            Ecritures var4 = (Ecritures)var3.get(var5);
            String var6 = "";
            int var7 = var4.getEcrDateSaisie().getMonth() + 1;
            if (var7 <= 9) {
               var6 = "0" + var7;
            } else {
               var6 = "" + var7;
            }

            String var8 = "" + (var4.getEcrDateSaisie().getYear() + 1900);
            var4.setEcrRapprochement(var6 + ":" + var8);
            var4.setEcrDteRapprochement(this.utilDate.stringToDateSQLLight(var8 + "-" + var6 + "-" + "01"));
            this.ecrituresDao.modif(var4, var1);
            var1.flush();
         }

         var1.flush();
      }

   }

   public void soldeAnterieurRapprochement(Session var1) throws HibernateException, NamingException, ParseException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Calcul des soldes anterieurs des rapprochements bancaires...");
      ++this.var_currentValue;
      new JournauxComptables();
      JournauxComptablesDao var3 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      JournauxMoisDao var5 = new JournauxMoisDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var6 = var5.listeJouMemClotureByJournal(this.exerciceLast, var1);
      if (var6.size() != 0) {
         List var4 = var5.listeJouMemCloture(this.exerciceLast, var1);
         Date var7 = this.utilDate.dateJourSuivant(this.datecloture);
         int var8 = this.datecloture.getMonth() + 1;
         String var9 = "";
         if (var8 <= 9) {
            var9 = "0" + var8;
         } else {
            var9 = "" + var8;
         }

         String var10 = var9 + ":" + (this.datecloture.getYear() + 1900);
         int var11 = var7.getMonth() + 1;
         String var12 = "";
         if (var11 <= 9) {
            var12 = "0" + var11;
         } else {
            var12 = "" + var11;
         }

         String var13 = var12 + ":" + (var7.getYear() + 1900);
         double var14 = 0.0D;

         for(int var16 = 0; var16 < var6.size(); ++var16) {
            String var17 = ((String)var6.get(var16)).toString();
            JournauxComptables var2 = var3.chercherCode(var17, this.leIdExo, var1);
            if (var2 != null && var2.getPljNature() >= 7 && var2.getPljNature() <= 10) {
               JournauxMois var18;
               int var19;
               if (var4.size() != 0) {
                  new JournauxMois();

                  for(var19 = 0; var19 < var4.size(); ++var19) {
                     var18 = (JournauxMois)var4.get(var19);
                     if (var18.getJoumenCode().equals(var17) && var18.getJoumenPeriode().equals(var10)) {
                        var14 = var18.getJoumenReleve();
                        break;
                     }
                  }
               }

               if (var4.size() != 0) {
                  new JournauxMois();

                  for(var19 = 0; var19 < var4.size(); ++var19) {
                     var18 = (JournauxMois)var4.get(var19);
                     if (var18.getJoumenCode().equals(var17) && var18.getJoumenPeriode().equals(var13)) {
                        var18.setJoumenReleveAnte(var14);
                        var5.majJournal(var18, var1);
                        var1.flush();
                        break;
                     }
                  }
               }
            }
         }
      }

   }

   public void traitementLoyer(Session var1) throws HibernateException, NamingException {
      int var2 = 0;
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Recopie des loyers...");
      ++this.var_currentValue;
      new ArrayList();
      LoyerDao var4 = new LoyerDao(this.baseLog, this.utilInitHibernate);
      List var3 = var4.chargerLesloyersActif(this.exercicesComptable.getExecpt_id(), var1);
      if (var3.size() != 0) {
         new Loyer();

         for(int var6 = 0; var6 < var3.size(); ++var6) {
            Loyer var5 = (Loyer)var3.get(var6);
            if (var5.getLoyInactif() == 0) {
               Loyer var7 = new Loyer();
               var7.setExercicescomptable(this.exerciceNouvel);
               var7.setLoyActiviteCode(var5.getLoyActiviteCode());
               var7.setLoyActiviteLib(var5.getLoyActiviteLib());
               var7.setLoyAgentCode(var5.getLoyAgentCode());
               var7.setLoyAgentLib(var5.getLoyAgentLib());
               var7.setLoyBudgetCode(var5.getLoyBudgetCode());
               var7.setLoyBudgetLib(var5.getLoyBudgetLib());
               var7.setLoyCategorie(var5.getLoyCategorie());
               var7.setLoyCle1Code(var5.getLoyCle1Lib());
               var7.setLoyCle1Lib(var5.getLoyCle1Lib());
               var7.setLoyCompteImpot(var5.getLoyCompteImpot());
               var7.setLoyCompteLoyer(var5.getLoyCompteLoyer());
               var7.setLoyCompteTaxe(var5.getLoyCompteTaxe());
               var7.setLoyCompteTiers(var5.getLoyCompteTiers());
               var7.setLoyDateCreat(var5.getLoyDateCreat());
               var7.setLoyDateDebut(var5.getLoyDateDebut());
               var7.setLoyDateFin(var5.getLoyDateFin());
               var7.setLoyDateModif(var5.getLoyDateModif());
               var7.setLoyDepartementCode(var5.getLoyDepartementCode());
               var7.setLoyDepartementLib(var5.getLoyDepartementLib());
               var7.setLoyDescription(var5.getLoyDescription());
               var7.setLoyDossierCode(var5.getLoyDossierCode());
               var7.setLoyDossierLib(var5.getLoyDossierLib());
               var7.setLoyInactif(var5.getLoyInactif());
               var7.setLoyLibCompteImpot(var5.getLoyLibCompteImpot());
               var7.setLoyLibCompteLoyer(var5.getLoyLibCompteLoyer());
               var7.setLoyLibCompteTaxe(var5.getLoyLibCompteTaxe());
               var7.setLoyLibCompteTiers(var5.getLoyLibCompteTiers());
               var7.setLoyMissionCode(var5.getLoyMissionCode());
               var7.setLoyMissionLib(var5.getLoyMissionLib());
               var7.setLoyMode(var5.getLoyMode());
               var7.setLoyMontantBrut(var5.getLoyMontantBrut());
               var7.setLoyMontantImpot(var5.getLoyMontantImpot());
               var7.setLoyMontantNet(var5.getLoyMontantNet());
               var7.setLoyMontantTaxe(var5.getLoyMontantTaxe());
               var7.setLoyNumBail(var5.getLoyNumBail());
               var7.setLoyNumContribuable(var5.getLoyNumContribuable());
               var7.setLoyParcCode(var5.getLoyParcCode());
               var7.setLoyParcLib(var5.getLoyParcLib());
               var7.setLoyPdvCode(var5.getLoyPdvCode());
               var7.setLoyPdvLib(var5.getLoyPdvLib());
               var7.setLoyRegionCode(var5.getLoyRegionCode());
               var7.setLoyRegionLib(var5.getLoyRegionLib());
               var7.setLoySecteurCode(var5.getLoySecteurCode());
               var7.setLoySecteurLib(var5.getLoySecteurLib());
               var7.setLoyServiceCode(var5.getLoyServiceCode());
               var7.setLoyServiceLib(var5.getLoyServiceLib());
               var7.setLoySiteCode(var5.getLoySiteCode());
               var7.setLoySiteLib(var5.getLoySiteLib());
               var7.setLoyTauxImpot(var5.getLoyTauxImpot());
               var7.setLoyTauxTaxe(var5.getLoyTauxTaxe());
               var7.setLoyType(var5.getLoyType());
               var7.setLoyTypeImpot(var5.getLoyTypeImpot());
               var7.setLoyTypeTaxe(var5.getLoyTypeTaxe());
               var7.setLoyUsage(var5.getLoyUsage());
               var7.setLoyUserCreat(var5.getLoyUserCreat());
               var7.setLoyUserModif(var5.getLoyUserModif());
               var4.insert(var7, var1);
               ++var2;
               if (var2 == this.cptMaxFlush) {
                  var1.flush();
                  var2 = 0;
               }
            }
         }

         var1.flush();
      }

   }

   public void traitementInfoLiasses(Session var1) throws HibernateException, NamingException {
      int var2 = 0;
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Recopie des informations liasses...");
      ++this.var_currentValue;
      new ArrayList();
      ComplementInformationsDao var4 = new ComplementInformationsDao(this.baseLog, this.utilInitHibernate);
      List var3 = var4.chargerMesComplements(99, this.exercicesComptable.getExecpt_id(), var1);
      if (var3.size() != 0) {
         new ComplementInformations();

         for(int var6 = 0; var6 < var3.size(); ++var6) {
            ComplementInformations var5 = (ComplementInformations)var3.get(var6);
            ComplementInformations var7 = new ComplementInformations();
            var7.setExercicesComptable(this.exerciceNouvel);
            var7.setCplmenAdresse(var5.getCplmenAdresse());
            var7.setCplmenCode(var5.getCplmenCode());
            var7.setCplmenDesignation(var5.getCplmenDesignation());
            var7.setCplmenFiscal(var5.getCplmenFiscal());
            var7.setCplmenLibelle(var5.getCplmenLibelle());
            var7.setCplmenNation(var5.getCplmenNation());
            var7.setCplmenNom(var5.getCplmenNom());
            var7.setCplmenPourcentage(var5.getCplmenPourcentage());
            var7.setCplmenPrenom(var5.getCplmenPrenom());
            var7.setCplmenQualite(var5.getCplmenQualite());
            var7.setCplmenTotal(var5.getCplmenTotal());
            var7.setCplmenType(var5.getCplmenType());
            var4.inser(var7, var1);
            ++var2;
            if (var2 == this.cptMaxFlush) {
               var1.flush();
               var2 = 0;
            }
         }

         var1.flush();
      }

   }

   public void nettoyageLettrage() throws HibernateException, NamingException {
      int var1 = 0;
      if (this.listeLettre.size() != 0) {
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "ClotureCompte");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            this.obm = new ObjetMessageSysteme();
            this.obm.setTexte("Nettoyage des lettrages dans l`ancien exercice...");
            ++this.var_currentValue;
            new Ecritures();

            for(int var5 = 0; var5 < this.listeLettre.size(); ++var5) {
               Ecritures var4 = (Ecritures)this.listeLettre.get(var5);
               if (var4.getEcrLettrage() != null && !var4.getEcrLettrage().isEmpty()) {
                  var4.setEcrLettrage((String)null);
                  this.ecrituresDao.modif(var4, var2);
                  ++var1;
                  if (var1 == this.cptMaxFlush) {
                     var2.flush();
                     var1 = 0;
                  }
               }
            }

            var2.flush();
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

   }

   public void deCloture() throws NamingException, IOException, SAXException, ParseException {
      if (this.exercicesComptable != null && this.exercicePrecedent != null) {
         boolean var1 = true;
         this.ecritureResultat = new Ecritures();
         this.showModalPanelAssistant = false;
         this.var_showBarProg = true;
         this.dateDebutCloture = this.utilDate.dateToStringSQLLight(this.exercicesComptable.getExecptDateDebut());
         this.dateFinCloture = this.utilDate.dateToStringSQLLight(this.exercicesComptable.getExecptDateFin());
         this.datecloture = this.utilDate.dateJourPrecedent(this.exercicesComptable.getExecptDateDebut());
         this.obm = new ObjetMessageSysteme();
         this.obm.setTexte("Chargement des ecritures de la periode en cours du " + this.dateDebutCloture + " au " + this.dateFinCloture);
         ++this.var_currentValue;
         Session var2;
         Transaction var3;
         if (this.exercicesComptable.getExecptEtat() == 0 && this.exercicePrecedent.getExecptEtat() == 1 && this.exercicePrecedent != null) {
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "ClotureCompte");
            var3 = null;

            try {
               var3 = var2.beginTransaction();
               this.suppressionJournalAA(var2);
               var2.flush();
               this.suppressionThesaurus(var2);
               var2.flush();
               this.suppressionJournalAN(var2);
               var2.flush();
               this.restoreEcritures(var2);
               var2.flush();
               this.restoreBrouillards(var2);
               var2.flush();
               this.restoreJournaux(var2);
               var2.flush();
               this.suppressionRapprochement(var2);
               var2.flush();
               this.suppressionLoyer(var2);
               var2.flush();
               this.suppressionResultat(var2);
               var2.flush();
               this.suppressionInfoLiasses(var2);
               var2.flush();
               var3.commit();
            } catch (HibernateException var15) {
               var1 = true;
               if (var3 != null) {
                  var3.rollback();
               }

               throw var15;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }

         if (var1) {
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "ClotureCompte");
            var3 = null;

            try {
               var3 = var2.beginTransaction();
               this.suppressionNvlExo(var2);
               var3.commit();
            } catch (HibernateException var17) {
               var1 = true;
               if (var3 != null) {
                  var3.rollback();
               }

               throw var17;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }

         this.chargerLesExo();
      }

      this.showModalPanelAssistant = false;
      this.var_showBarProg = false;
      this.showModalPanelErreur = false;
   }

   public void suppressionJournalAA(Session var1) {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Suppression journal AA...");
      ++this.var_currentValue;
      int var2 = this.datecloture.getMonth() + 1;
      String var3 = "";
      if (var2 <= 9) {
         var3 = "0" + var2;
      } else {
         var3 = "" + var2;
      }

      String var4 = "" + (this.datecloture.getYear() + 1900);
      String var5 = "AA:" + var3 + ":" + var4;
      new ArrayList();
      List var6 = this.ecrituresDao.recupererSelectedECByCle1(var5, var1);
      if (var6.size() != 0) {
         this.ecrituresDao.removeSelectedEC2(var6, this.cptMaxFlush, var1);
         var1.flush();
         var6.clear();
      }

   }

   public void suppressionThesaurus(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Suppression plan comptable...");
      ++this.var_currentValue;
      new ArrayList();
      PlanComptableDao var3 = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.selecFiscalite = this.structureLog.getStrzonefiscale();
      if (this.structureLog.getStrdatefiscale2() != null && this.exercicesComptable.getExecptDateFin().compareTo(this.structureLog.getStrdatefiscale2()) > 0) {
         this.selecFiscalite = this.structureLog.getStrzonefiscale2();
      }

      List var2 = var3.chargerLesPlanComptables(this.selecFiscalite, this.exercicesComptable.getExecpt_id(), var1);
      if (var2.size() != 0) {
         new PlanComptable();

         for(int var5 = 0; var5 < var2.size(); ++var5) {
            PlanComptable var4 = (PlanComptable)var2.get(var5);
            var3.delete(var4, var1);
         }
      }

      var1.flush();
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Supression journaux comptables...");
      ++this.var_currentValue;
      new ArrayList();
      JournauxComptablesDao var11 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      List var10 = var11.chargerLesJournauxComptables(this.exercicesComptable.getExecpt_id(), 0, var1);
      if (var10.size() != 0) {
         new JournauxComptables();

         for(int var7 = 0; var7 < var10.size(); ++var7) {
            JournauxComptables var6 = (JournauxComptables)var10.get(var7);
            if (var6.getPljInactif() == 0) {
               var11.delete(var6, var1);
            }
         }
      }

      var1.flush();
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Suppression plan budgetaire...");
      ++this.var_currentValue;
      new ArrayList();
      PlansBudgetairesDao var13 = new PlansBudgetairesDao(this.baseLog, this.utilInitHibernate);
      List var12 = var13.chargerLesPlansBudgetairesAnnee(this.exercicesComptable, 0, var1);
      if (var12.size() != 0) {
         new PlansBudgetaires();

         for(int var9 = 0; var9 < var12.size(); ++var9) {
            PlansBudgetaires var8 = (PlansBudgetaires)var12.get(var9);
            var8.setExercicesComptable(this.exercicePrecedent);
            var13.modif(var8, var1);
         }
      }

   }

   public void suppressionJournalAN(Session var1) {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Suppression journal AN...");
      ++this.var_currentValue;
      int var2 = this.exercicesComptable.getExecptDateDebut().getMonth() + 1;
      String var3 = "";
      if (var2 <= 9) {
         var3 = "0" + var2;
      } else {
         var3 = "" + var2;
      }

      String var4 = "" + (this.exercicesComptable.getExecptDateDebut().getYear() + 1900);
      String var5 = "AN:" + var3 + ":" + var4;
      new ArrayList();
      List var6 = this.ecrituresDao.recupererSelectedECByCle1(var5, var1);
      if (var6.size() != 0) {
         this.ecrituresDao.removeSelectedEC2(var6, this.cptMaxFlush, var1);
         var6.clear();
      }

      var1.flush();
      var4 = "" + (this.datecloture.getYear() + 1900);
      var5 = "....:" + var3 + ":" + var4;
      new ArrayList();
      var6 = this.ecrituresDao.recupererSelectedECByCle1(var5, var1);
      if (var6.size() != 0) {
         this.ecrituresDao.removeSelectedEC2(var6, this.cptMaxFlush, var1);
         var6.clear();
      }

      var1.flush();
   }

   public void restoreEcritures(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Restore les ecritures...");
      ++this.var_currentValue;
      this.listeEcriture.clear();
      this.listeEcriture = this.ecrituresDao.chargerEcritures(this.exercicesComptable, var1);
      if (this.listeEcriture.size() != 0) {
         new Ecritures();

         for(int var3 = 0; var3 < this.listeEcriture.size(); ++var3) {
            Ecritures var2 = (Ecritures)this.listeEcriture.get(var3);
            var2.setExercicesComptable(this.exercicePrecedent);
            this.ecrituresDao.modif(var2, var1);
         }
      }

   }

   public void restoreBrouillards(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Restore les brouillards...");
      ++this.var_currentValue;
      new ArrayList();
      List var2 = this.brouillardDao.chargerEcritures(this.exercicesComptable, var1);
      if (var2.size() != 0) {
         new Brouillard();

         for(int var4 = 0; var4 < var2.size(); ++var4) {
            Brouillard var3 = (Brouillard)var2.get(var4);
            var3.setExercicescomptable(this.exercicePrecedent);
            this.brouillardDao.modif(var3, var1);
         }
      }

   }

   public void restoreJournaux(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Restore les journaux...");
      ++this.var_currentValue;
      new ArrayList();
      JournauxMoisDao var3 = new JournauxMoisDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.listeJouMemCloture(this.exercicesComptable, var1);
      if (var2.size() != 0) {
         new JournauxMois();

         for(int var5 = 0; var5 < var2.size(); ++var5) {
            JournauxMois var4 = (JournauxMois)var2.get(var5);
            var4.setExercicesComptable(this.exercicePrecedent);
            var3.majJournal(var4, var1);
         }
      }

   }

   public void suppressionRapprochement(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Suppression les rapprochements bancaires...");
      ++this.var_currentValue;
      new ArrayList();
      EcrituresAnterieurDao var3 = new EcrituresAnterieurDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.chargerLesEcrituresRapp(this.exercicesComptable.getExecpt_id(), var1);
      if (var2.size() != 0) {
         new EcrituresAnterieur();

         for(int var5 = 0; var5 < var2.size(); ++var5) {
            EcrituresAnterieur var4 = (EcrituresAnterieur)var2.get(var5);
            var3.delete(var4, var1);
         }
      }

   }

   public void suppressionLoyer(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Suppression les loyers...");
      ++this.var_currentValue;
      new ArrayList();
      LoyerDao var3 = new LoyerDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.chargerLesloyers(this.exercicesComptable.getExecpt_id(), var1);
      if (var2.size() != 0) {
         new Loyer();

         for(int var5 = 0; var5 < var2.size(); ++var5) {
            Loyer var4 = (Loyer)var2.get(var5);
            var3.delete(var4, var1);
         }
      }

   }

   public void suppressionResultat(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Suppression les resultats...");
      ++this.var_currentValue;
      new ArrayList();
      new ComplementInformations();
      ComplementInformationsDao var4 = new ComplementInformationsDao(this.baseLog, this.utilInitHibernate);
      List var2 = var4.chargerMesComplements(99, this.exercicesComptable.getExecpt_id(), var1);
      if (var2.size() != 0) {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            ComplementInformations var3 = (ComplementInformations)var2.get(var5);
            var4.delete(var3, var1);
         }
      }

      new ArrayList();
      TabResultatsDao var6 = new TabResultatsDao(this.baseLog, this.utilInitHibernate);
      List var9 = var6.chargerMesTabResultats(this.exercicesComptable.getExecpt_id(), var1);
      if (var9.size() != 0) {
         new TabResultats();

         for(int var8 = 0; var8 < var9.size(); ++var8) {
            TabResultats var7 = (TabResultats)var9.get(var8);
            var6.delete(var7, var1);
         }
      }

   }

   public void suppressionInfoLiasses(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Suppression les inforlations des liasses...");
      ++this.var_currentValue;
      new ArrayList();
      ComplementInformationsDao var3 = new ComplementInformationsDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.chargerMesComplements(99, this.exercicesComptable.getExecpt_id(), var1);
      if (var2.size() != 0) {
         new ComplementInformations();

         for(int var5 = 0; var5 < var2.size(); ++var5) {
            ComplementInformations var4 = (ComplementInformations)var2.get(var5);
            var3.delete(var4, var1);
         }
      }

   }

   public void suppressionNvlExo(Session var1) throws HibernateException, NamingException {
      this.obm = new ObjetMessageSysteme();
      this.obm.setTexte("Suppression l'exercice en cours...");
      ++this.var_currentValue;
      if (this.exercicesComptable != null) {
         Date var2 = this.exercicesComptable.getExecptDateFin();
         this.exercicesComptableDao.delete(this.exercicesComptable, var1);
         this.exercicePrecedent = this.exercicesComptableDao.recupererLExoPrecis(this.exercicePrecedent.getExecpt_id(), var1);
         if (this.exercicePrecedent != null) {
            this.exercicePrecedent.setExecptEtat(0);
            this.exercicePrecedent.setExecptDateFin(var2);
            this.exercicePrecedent = this.exercicesComptableDao.modifierExercicesCompta(this.exercicePrecedent, var1);
         }
      }

   }

   public DateFormat getDateFormat() {
      return this.dateFormat;
   }

   public void setDateFormat(DateFormat var1) {
      this.dateFormat = var1;
   }

   public Date getDatecloture() {
      return this.datecloture;
   }

   public void setDatecloture(Date var1) {
      this.datecloture = var1;
   }

   public boolean isDisable() {
      return this.disable;
   }

   public void setDisable(boolean var1) {
      this.disable = var1;
   }

   public ExercicesComptable getExercicesComptable() {
      return this.exercicesComptable;
   }

   public void setExercicesComptable(ExercicesComptable var1) {
      this.exercicesComptable = var1;
   }

   public long getLeIdExo() {
      return this.leIdExo;
   }

   public void setLeIdExo(long var1) {
      this.leIdExo = var1;
   }

   public List getLesexercicesComptables() {
      return this.lesexercicesComptables;
   }

   public void setLesexercicesComptables(List var1) {
      this.lesexercicesComptables = var1;
   }

   public List getListExo() {
      return this.listExo;
   }

   public void setListExo(List var1) {
      this.listExo = var1;
   }

   public Locale getLocale() {
      return this.locale;
   }

   public void setLocale(Locale var1) {
      this.locale = var1;
   }

   public DataModel getMadatamodel() {
      return this.madatamodel;
   }

   public void setMadatamodel(DataModel var1) {
      this.madatamodel = var1;
   }

   public boolean isNoExo() {
      return this.noExo;
   }

   public void setNoExo(boolean var1) {
      this.noExo = var1;
   }

   public boolean isTestDateAj() {
      return this.testDateAj;
   }

   public void setTestDateAj(boolean var1) {
      this.testDateAj = var1;
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

   public boolean isShowModalPanelAssistant() {
      return this.showModalPanelAssistant;
   }

   public void setShowModalPanelAssistant(boolean var1) {
      this.showModalPanelAssistant = var1;
   }

   public ObjetMessageSysteme getObm() {
      return this.obm;
   }

   public void setObm(ObjetMessageSysteme var1) {
      this.obm = var1;
   }

   public int getVar_currentValue() {
      return this.var_currentValue;
   }

   public void setVar_currentValue(int var1) {
      this.var_currentValue = var1;
   }

   public boolean isVar_showBarProg() {
      return this.var_showBarProg;
   }

   public void setVar_showBarProg(boolean var1) {
      this.var_showBarProg = var1;
   }

   public int getVar_valueMax() {
      return this.var_valueMax;
   }

   public void setVar_valueMax(int var1) {
      this.var_valueMax = var1;
   }

   public boolean isShowModalPanelErreur() {
      return this.showModalPanelErreur;
   }

   public void setShowModalPanelErreur(boolean var1) {
      this.showModalPanelErreur = var1;
   }

   public int getVar_mode_cloture() {
      return this.var_mode_cloture;
   }

   public void setVar_mode_cloture(int var1) {
      this.var_mode_cloture = var1;
   }

   public boolean isVar_mode_anterieur() {
      return this.var_mode_anterieur;
   }

   public void setVar_mode_anterieur(boolean var1) {
      this.var_mode_anterieur = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public OptionComptabilite getOptionComptabilite() {
      return this.optionComptabilite;
   }

   public void setOptionComptabilite(OptionComptabilite var1) {
      this.optionComptabilite = var1;
   }
}
