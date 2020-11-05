package com.epegase.forms.comptabilite;

import com.epegase.forms.commun.FormAnalytique;
import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Brouillard;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresAnalytique;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.FactureEnteteMedical;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.PlansTresorerie;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.dao.EcrituresAnalytiquesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FactureEnteteMedicalDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LectureNatureJournaux;
import com.epegase.systeme.xml.LireLesoptionsMedical;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.OptionComptabilite;
import com.epegase.systeme.xml.OptionMedical;
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
import java.util.List;
import java.util.Locale;
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

public class FormExtraitCompte implements Serializable {
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
   private String var_erreur_lettrage;
   private String messageAlerte;
   private boolean affichageAccesJr = false;
   private Ecritures ecritures;
   private EcrituresDao ecrituresDao;
   private List lesEcritures = new ArrayList();
   private transient DataModel dataModelEcritures = new ListDataModel();
   private List lesEcrituresLettrees = new ArrayList();
   private String periode;
   private String inputnum = "";
   private UtilDate utilDate = new UtilDate();
   private double tmouvDeb = 0.0D;
   private double tmouvCred = 0.0D;
   private double solDebit = 0.0D;
   private double solCredit = 0.0D;
   private double ecrDebitL = 0.0D;
   private double ecrCreditL = 0.0D;
   private double ecrDebitNL = 0.0D;
   private double ecrCreditNL = 0.0D;
   private double ecrDebitS = 0.0D;
   private double ecrCreditS = 0.0D;
   private double soldeDebitS = 0.0D;
   private double soldeCreditS = 0.0D;
   private boolean testdeliste = true;
   private boolean testequilibre = false;
   private boolean var_affiche_bouton = false;
   private int choix_compte;
   private boolean var_solde_ante = false;
   private boolean showModalFind = false;
   private Date dateDebut;
   private Date dateFin;
   private String filtrage = "1";
   private String lettrage = "";
   private String pointage = "";
   private String piece = "";
   private String libEC = "";
   private String ref1 = "";
   private String ref2 = "";
   private double montant = 0.0D;
   private String journal = "";
   private String analytique = "";
   private String dossier = "";
   private String natureJournal = "";
   private boolean situationRech = false;
   private boolean reserveRech = false;
   private PlanComptableDao planComptableDao;
   private PlanComptable planComptable = new PlanComptable();
   private String pointModal = "";
   private boolean showModalPanelPointage = false;
   private String lettrModal = "";
   private String lettreCumul = "";
   private int delettre = 0;
   private boolean showModalpanelFiltre = false;
   private Date dateDu;
   private Date dateAu;
   private int choixFiltre;
   private boolean showModalPanelLettrage = false;
   private boolean showModalPanelDelettrage = false;
   private boolean showModalPanelCompense = false;
   private double var_compense;
   private Date var_date_compense;
   private UtilNombre utilNombre = new UtilNombre();
   private double var_debit_compense;
   private double var_credit_compense;
   private String var_libelle_compense;
   private String var_memo_compte;
   private String var_compte_compense;
   private transient DataModel dataModelDetailPiece = new ListDataModel();
   private double var_tot_debit;
   private double var_tot_credit;
   private double var_solde;
   private boolean showModalPanelModifPiece = false;
   private Ecritures ecrituresDetail;
   private List listDetail = new ArrayList();
   private List lesModelsimpression = new ArrayList();
   private boolean showModalPanelPrint = false;
   private boolean forceVerrou;
   private boolean testAffOutilsCorr = false;
   private int outilChoisi;
   private String toolsCompteOld;
   private List lesEcrituresAReimputer;
   private transient DataModel dataModelEcritureAReimputer;
   private boolean showModalPanelCorrection = false;
   private boolean showModalPanelAnalytiqueCorrection = false;
   private boolean var_affiche_analytique = false;
   private boolean showModalPanelAnalytique = false;
   private long var_memo_ligne_gene;
   private FormAnalytique formAnalytique;
   private EcrituresAnalytiquesDao ecrituresAnalytiquesDao;
   private List listeRepartitionAnal = new ArrayList();
   private EcrituresAnalytique ecrituresAnalytique;
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
   private List lesModelesAutorises;
   private boolean afficheBudgetTresoProjet = false;
   private boolean afficheBudgetTresoStandard = false;
   private PlansTresorerie plansTresorerie;
   private String memo_compte_budgetTreso;
   private boolean comptaProjet;
   private JournauxComptables journauxComptables;
   private JournauxComptablesDao journauxComptablesDao;
   private boolean showModalPanelPJ = false;
   private UploadedFile uploadedFile;
   private UtilDownload utilDownload;
   private String urlphotoProd;
   private static final int DEFAULT_BUFFER_SIZE = 10240;
   private int typeFichier;
   private String fichierMine;
   private URL fichierUrl;
   private String urlExplorateur;
   private int choixRacine;
   private String selecFiscalite;
   private boolean showModalPanelInformation = false;
   private String nomCreation;
   private String nomModification;
   private transient DataModel dataModelJournaux = new ListDataModel();
   private transient DataModel dataModelNature = new ListDataModel();
   private List lesJournaux = new ArrayList();
   private List lesNatures = new ArrayList();
   private boolean showModalPanelJournaux = false;
   private boolean showModalPanelNature = false;

   public void InstancesDaoUtilses() {
      this.ecrituresDao = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresAnalytiquesDao = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
   }

   public void init() {
      this.dateDebut = this.selectedExo.getExecptDateDebut();
      this.dateFin = this.selectedExo.getExecptDateFin();
      this.periode = "PERIODE du " + this.utilDate.dateToStringFr(this.dateDebut) + " au " + this.utilDate.dateToStringFr(this.dateFin);
      if (this.optionComptabilite.getNbLigneMaxEx() != null && !this.optionComptabilite.getNbLigneMaxEx().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionComptabilite.getNbLigneMaxEx());
      } else {
         this.var_nb_max = 100;
      }

      this.testAffOutilsCorr = false;
      if (this.usersLog.getUsrAccesCorrection() == 1 && this.selectedExo.getExecptEtat() == 0) {
         this.testAffOutilsCorr = true;
      }

      if (this.optionComptabilite.getTrf_brl().equals(this.piece)) {
         this.affichageAccesJr = false;
      } else {
         this.affichageAccesJr = true;
      }

      this.comptaProjet = this.rechercheModule(40300);
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

   public void chargerFirst() throws HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanComptable");
      this.planComptable = new PlanComptable();
      this.planComptable = this.planComptableDao.getFirstPC(this.selectedExo, var1);
      if (this.planComptable != null) {
         this.inputnum = this.planComptable.getPlcCompte();
      } else {
         this.inputnum = "";
      }

      this.chargerEcritures(var1);
      this.var_affiche_bouton = false;
      this.utilInitHibernate.closeSession();
   }

   public void chargerLast() throws HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanComptable");
      this.planComptable = new PlanComptable();
      this.planComptable = this.planComptableDao.getLastPC(this.selectedExo, var1);
      if (this.planComptable != null) {
         this.inputnum = this.planComptable.getPlcCompte();
      } else {
         this.inputnum = "";
      }

      this.chargerEcritures(var1);
      this.var_affiche_bouton = false;
      this.utilInitHibernate.closeSession();
   }

   public void chargerNext() throws HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanComptable");
      this.planComptable = new PlanComptable();
      this.planComptable = this.planComptableDao.getNextPC(this.inputnum, this.selectedExo, var1);
      if (this.planComptable == null) {
         this.chargerFirst();
      } else {
         this.inputnum = this.planComptable.getPlcCompte();
      }

      this.chargerEcritures(var1);
      this.var_affiche_bouton = false;
      this.utilInitHibernate.closeSession();
   }

   public void chargerPrevious() throws HibernateException, NamingException, ParseException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanComptable");
      this.planComptable = new PlanComptable();
      this.planComptable = this.planComptableDao.getPreviousPC(this.inputnum, this.selectedExo, var1);
      if (this.planComptable == null) {
         this.chargerLast();
      } else {
         this.inputnum = this.planComptable.getPlcCompte();
      }

      this.chargerEcritures(var1);
      this.var_affiche_bouton = false;
      this.utilInitHibernate.closeSession();
   }

   public void trouverCompte() {
      this.showModalFind = true;
   }

   public void annuleRecherche() {
      this.showModalFind = false;
   }

   public void chargerEcritures() throws HibernateException, NamingException, ParseException {
      this.chargerEcritures((Session)null);
   }

   public void chargerEcritures(Session var1) throws HibernateException, NamingException, ParseException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         var2 = true;
      }

      String var3 = "";
      if (this.analytique != null && !this.analytique.isEmpty()) {
         var3 = " Analytique " + this.analytique;
      }

      String var4 = "";
      if (this.dossier != null && !this.dossier.isEmpty()) {
         var4 = " Dossier " + this.dossier;
      }

      this.periode = "PERIODE du " + this.utilDate.dateToStringFr(this.dateDebut) + " au " + this.utilDate.dateToStringFr(this.dateFin) + var3 + var4;
      this.lesEcritures.clear();
      this.lesEcrituresLettrees.clear();
      if (this.planComptable != null && this.inputnum != null && !this.inputnum.isEmpty()) {
         Object var5 = new ArrayList();
         String var6 = this.utilDate.dateToStringSQLLight(this.dateDebut);
         Date var7 = this.utilDate.stringToDateSQLLight(var6);
         String var8 = this.utilDate.dateToStringSQLLight(this.dateFin);
         Date var9 = this.utilDate.stringToDateSQLLight(var8);
         Date var10 = null;
         ArrayList var11 = new ArrayList();
         int var13;
         if (this.journal != null && !this.journal.isEmpty()) {
            if (!this.journal.contains(":")) {
               var11.add(this.journal);
            } else {
               String[] var12 = this.journal.split(":");

               for(var13 = 0; var13 < var12.length; ++var13) {
                  String var14 = var12[var13];
                  var11.add(var14);
               }
            }
         }

         ArrayList var24 = new ArrayList();
         int var15;
         int var26;
         if (this.natureJournal != null && !this.natureJournal.isEmpty()) {
            if (!this.natureJournal.contains(":")) {
               var24.add(Integer.parseInt(this.natureJournal));
            } else {
               String[] var25 = this.natureJournal.split(":");

               for(var26 = 0; var26 < var25.length; ++var26) {
                  var15 = Integer.parseInt(var25[var26]);
                  var24.add(var15);
               }
            }
         }

         if (this.optionComptabilite.getTri_extrait() == null || this.optionComptabilite.getTri_extrait().isEmpty() || this.optionComptabilite.getTri_extrait().equals("piece")) {
            this.optionComptabilite.setTri_extrait("0");
         }

         var13 = Integer.parseInt(this.optionComptabilite.getTri_extrait());
         if (this.var_solde_ante) {
            var10 = this.utilDate.dateJourPrecedent(var7);
            var5 = this.ecrituresDao.chargerExtraitCompte(this.selectedExo.getExecptDateDebut(), var10, this.inputnum, this.situationRech, this.reserveRech, this.filtrage, this.libEC, this.lettrage, this.pointage, this.ref1, this.ref2, var11, var24, this.piece, this.montant, this.usersLog.getUsrCptInterdit(), this.usersLog.getUsrJrxInterdit(), var13, var1);
         }

         int var19;
         Ecritures var36;
         int var39;
         if (this.dateFin.equals(this.selectedExo.getExecptDateFin())) {
            this.lesEcritures = this.ecrituresDao.chargerExtraitCompte(var7, var9, this.inputnum, this.situationRech, this.reserveRech, this.filtrage, this.libEC, this.lettrage, this.pointage, this.ref1, this.ref2, var11, var24, this.piece, this.montant, this.usersLog.getUsrCptInterdit(), this.usersLog.getUsrJrxInterdit(), var13, var1);
            if (this.lesEcritures.size() != 0) {
               for(var26 = 0; var26 < this.lesEcritures.size(); ++var26) {
                  this.ecritures = (Ecritures)this.lesEcritures.get(var26);
                  if (this.ecritures.getEcrAnaActif() == 0) {
                     this.ecritures.setErreurAnalytique(this.testCompteAnalytique(this.ecritures));
                  } else {
                     this.ecritures.setErreurAnalytique(false);
                  }
               }
            }
         } else {
            new ArrayList();
            ArrayList var28 = new ArrayList();
            List var27 = this.ecrituresDao.chargerExtraitCompte(var7, var9, this.inputnum, this.situationRech, this.reserveRech, "0", this.libEC, this.lettrage, this.pointage, this.ref1, this.ref2, var11, var24, this.piece, this.montant, this.usersLog.getUsrCptInterdit(), this.usersLog.getUsrJrxInterdit(), var13, var1);
            int var17;
            if (var27.size() != 0) {
               new Ecritures();

               for(var17 = 0; var17 < var27.size(); ++var17) {
                  Ecritures var16 = (Ecritures)var27.get(var17);
                  if (var16.getEcrAnaActif() == 0) {
                     var16.setErreurAnalytique(this.testCompteAnalytique(var16));
                  } else {
                     var16.setErreurAnalytique(false);
                  }

                  if (var16.getEcrLettrage() != null && !var16.getEcrLettrage().isEmpty()) {
                     if (var28.size() == 0) {
                        var28.add(var16.getEcrLettrage());
                     } else {
                        boolean var18 = false;

                        for(var19 = 0; var19 < var28.size(); ++var19) {
                           if (((String)var28.get(var19)).equals(var16.getEcrLettrage())) {
                              var18 = true;
                              break;
                           }
                        }

                        if (!var18) {
                           var28.add(var16.getEcrLettrage());
                        }
                     }
                  }
               }
            }

            String var30 = "";
            var17 = 0;

            label421:
            while(true) {
               if (var17 >= var28.size()) {
                  this.lesEcritures.clear();
                  new Ecritures();
                  var39 = 0;

                  while(true) {
                     if (var39 >= var27.size()) {
                        break label421;
                     }

                     var36 = (Ecritures)var27.get(var39);
                     if (this.filtrage.equals("0")) {
                        this.lesEcritures.add(var36);
                     } else if (this.filtrage.equals("1")) {
                        if (var36.getEcrLettrage() == null || var36.getEcrLettrage().isEmpty()) {
                           this.lesEcritures.add(var36);
                        }
                     } else if (this.filtrage.equals("2")) {
                        if (var36.getEcrLettrage() != null && !var36.getEcrLettrage().isEmpty()) {
                           this.lesEcritures.add(var36);
                        }
                     } else if (this.filtrage.equals("3")) {
                        if (var36.getEcrPointage() == null || var36.getEcrPointage().isEmpty()) {
                           this.lesEcritures.add(var36);
                        }
                     } else if (this.filtrage.equals("4")) {
                        if (var36.getEcrPointage() != null && !var36.getEcrPointage().isEmpty()) {
                           this.lesEcritures.add(var36);
                        }
                     } else if (this.filtrage.equals("5")) {
                        if ((var36.getEcrLettrage() == null || var36.getEcrLettrage().isEmpty()) && (var36.getEcrPointage() == null || var36.getEcrPointage().isEmpty())) {
                           this.lesEcritures.add(var36);
                        }
                     } else if (this.filtrage.equals("6") && var36.getEcrLettrage() != null && !var36.getEcrLettrage().isEmpty() && var36.getEcrPointage() != null && !var36.getEcrPointage().isEmpty()) {
                        this.lesEcritures.add(var36);
                     }

                     ++var39;
                  }
               }

               var30 = ((String)var28.get(var17)).toString();
               new Ecritures();
               double var40 = 0.0D;
               double var21 = 0.0D;

               int var23;
               Ecritures var37;
               for(var23 = 0; var23 < var27.size(); ++var23) {
                  var37 = (Ecritures)var27.get(var23);
                  if (var37.getEcrLettrage() != null && !var37.getEcrLettrage().isEmpty() && var37.getEcrLettrage().equals(var30)) {
                     var40 += var37.getEcrDebitPays();
                     var21 += var37.getEcrCreditPays();
                  }
               }

               if (var40 != var21) {
                  for(var23 = 0; var23 < var27.size(); ++var23) {
                     var37 = (Ecritures)var27.get(var23);
                     if (var37.getEcrLettrage() != null && !var37.getEcrLettrage().isEmpty() && var37.getEcrLettrage().equals(var30)) {
                        var37.setErreurLettrage("L:" + var37.getEcrLettrage());
                     }
                  }
               }

               ++var17;
            }
         }

         this.lesEcrituresLettrees = this.ecrituresDao.chargerLesEcritureslettres(this.selectedExo.getExecpt_id(), "", this.planComptable.getPlcCompte(), var1);
         if (this.var_solde_ante && ((List)var5).size() != 0) {
            double var29 = 0.0D;
            double var34 = 0.0D;

            for(var39 = 0; var39 < ((List)var5).size(); ++var39) {
               new Ecritures();
               Ecritures var41 = (Ecritures)((List)var5).get(var39);
               var29 += var41.getEcrDebitPays();
               var34 += var41.getEcrCreditPays();
            }

            this.ecritures = new Ecritures();
            this.ecritures.setEcrDateSaisie(var10);
            this.ecritures.setEcrCode("XX");
            this.ecritures.setEcrCompte(this.inputnum);
            if (var29 > var34) {
               this.ecritures.setEcrDebitPays(var29 - var34);
               this.ecritures.setEcrCreditPays(0.0D);
            } else {
               this.ecritures.setEcrDebitPays(0.0D);
               this.ecritures.setEcrCreditPays(var34 - var29);
            }

            this.ecritures.setEcrLibelle("Solde antérieur");
            this.lesEcritures.add(1, this.ecritures);
         }

         ArrayList var32 = new ArrayList();
         int var35;
         if (this.lesEcritures.size() != 0 && (this.analytique != null && !this.analytique.isEmpty() || this.dossier != null && !this.dossier.isEmpty())) {
            this.ecrituresAnalytiquesDao = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
            new ArrayList();

            for(var35 = 0; var35 < this.lesEcritures.size(); ++var35) {
               new Ecritures();
               var36 = (Ecritures)this.lesEcritures.get(var35);
               List var31 = this.ecrituresAnalytiquesDao.chargerLesEcrituresAnalytiques(var36, var1);
               if (var31.size() != 0) {
                  for(var39 = 0; var39 < var31.size(); ++var39) {
                     new EcrituresAnalytique();
                     EcrituresAnalytique var42 = (EcrituresAnalytique)var31.get(var39);
                     if (this.analytique != null && !this.analytique.isEmpty() && (var42.getEcranaActivite() != null && var42.getEcranaActivite().startsWith(this.analytique) || var42.getEcranaAnal1() != null && var42.getEcranaAnal1().startsWith(this.analytique) || var42.getEcranaAnal2() != null && var42.getEcranaAnal2().startsWith(this.analytique) || var42.getEcranaAnal3() != null && var42.getEcranaAnal3().startsWith(this.analytique) || var42.getEcranaAtelier() != null && var42.getEcranaAtelier().startsWith(this.analytique) || var42.getEcranaDepartement() != null && var42.getEcranaDepartement().startsWith(this.analytique) || var42.getEcranaLigne() != null && var42.getEcranaLigne().startsWith(this.analytique) || var42.getEcranaPdv() != null && var42.getEcranaPdv().startsWith(this.analytique) || var42.getEcranaRegion() != null && var42.getEcranaRegion().startsWith(this.analytique) || var42.getEcranaSecteur() != null && var42.getEcranaSecteur().startsWith(this.analytique) || var42.getEcranaService() != null && var42.getEcranaService().startsWith(this.analytique) || var42.getEcranaSite() != null && var42.getEcranaSite().startsWith(this.analytique))) {
                        var32.add(var36);
                        break;
                     }

                     if (this.dossier != null && !this.dossier.isEmpty() && var42.getEcranaAnal4() != null && var42.getEcranaAnal4().startsWith(this.dossier)) {
                        var32.add(var36);
                        break;
                     }
                  }
               }
            }
         } else {
            for(var15 = 0; var15 < this.lesEcritures.size(); ++var15) {
               var32.add(this.lesEcritures.get(var15));
            }

            this.lesEcritures.clear();
         }

         if (var32.size() != 0) {
            if (this.optionComptabilite.getAnalytiqueErreur().equals("1")) {
               Object var33 = new ArrayList();

               for(var35 = 0; var35 < var32.size(); ++var35) {
                  this.ecritures = (Ecritures)var32.get(var35);
                  if (this.optionComptabilite.getAnalytique().equals("true") && this.ecritures.getEcrAnaActif() == 1) {
                     ((List)var33).clear();
                     var33 = this.ecrituresAnalytiquesDao.chargerLesEcrituresAnalytiques(this.ecritures, var1);
                     if (((List)var33).size() == 0) {
                        this.ecritures.setErreurAnalytique(true);
                     } else {
                        double var38 = 0.0D;

                        for(var19 = 0; var19 < ((List)var33).size(); ++var19) {
                           var38 += ((EcrituresAnalytique)((List)var33).get(var19)).getEcranaMontantSaisie();
                        }

                        if (var38 != this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) {
                           if (var38 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 2.0D) {
                              if (var38 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 3.0D) {
                                 if (var38 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 4.0D) {
                                    if (var38 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 5.0D) {
                                       if (var38 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 6.0D) {
                                          if (var38 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 7.0D) {
                                             if (var38 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 8.0D) {
                                                if (var38 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 9.0D) {
                                                   if (var38 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 10.0D) {
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
                     }
                  }

                  this.lesEcritures.add(this.ecritures);
               }
            } else {
               for(var15 = 0; var15 < var32.size(); ++var15) {
                  this.lesEcritures.add(var32.get(var15));
               }
            }
         }
      }

      this.dataModelEcritures.setWrappedData(this.lesEcritures);
      this.showModalFind = false;
      this.calculerTotaux();
      this.testequilibre = false;
      this.var_erreur_lettrage = "";
      this.calculerProchaineLettre();
      this.testEquilibre();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculerTotaux() {
      this.tmouvDeb = 0.0D;
      this.tmouvCred = 0.0D;
      this.solDebit = 0.0D;
      this.solCredit = 0.0D;
      this.testdeliste = true;
      if (this.lesEcritures.size() != 0) {
         this.testdeliste = false;

         for(int var1 = 0; var1 < this.lesEcritures.size(); ++var1) {
            Ecritures var2 = (Ecritures)this.lesEcritures.get(var1);
            this.tmouvDeb += var2.getEcrDebitPays();
            this.tmouvCred += var2.getEcrCreditPays();
         }
      }

      if (this.tmouvDeb > this.tmouvCred) {
         this.solDebit = this.utilNombre.myRoundDevise(this.tmouvDeb, this.structureLog.getStrdevise()) - this.utilNombre.myRoundDevise(this.tmouvCred, this.structureLog.getStrdevise());
         this.solCredit = 0.0D;
      } else {
         this.solCredit = this.utilNombre.myRoundDevise(this.tmouvCred, this.structureLog.getStrdevise()) - this.utilNombre.myRoundDevise(this.tmouvDeb, this.structureLog.getStrdevise());
         this.solDebit = 0.0D;
      }

      this.ecrDebitL = 0.0D;
      this.ecrDebitNL = 0.0D;
      this.ecrDebitS = 0.0D;
      this.ecrCreditL = 0.0D;
      this.ecrCreditNL = 0.0D;
      this.ecrCreditS = 0.0D;
      this.soldeDebitS = 0.0D;
      this.soldeCreditS = 0.0D;
   }

   public void testEquilibre() {
      this.var_erreur_lettrage = "";
      if (this.lesEcrituresLettrees.size() != 0) {
         ArrayList var1 = new ArrayList();

         for(int var2 = 0; var2 < this.lesEcrituresLettrees.size(); ++var2) {
            String var3 = ((Ecritures)this.lesEcrituresLettrees.get(var2)).getEcrLettrage();
            if (var3 != null && !var3.isEmpty()) {
               if (var1.size() == 0) {
                  var1.add(var3);
               } else {
                  boolean var4 = false;

                  for(int var5 = 0; var5 < var1.size(); ++var5) {
                     if (((String)var1.get(var5)).equals(var3)) {
                        var4 = true;
                        break;
                     }
                  }

                  if (!var4) {
                     var1.add(var3);
                  }
               }
            }
         }

         this.var_erreur_lettrage = "ERREUR : ";
         boolean var11 = false;
         if (var1.size() != 0) {
            for(int var12 = 0; var12 < var1.size(); ++var12) {
               String var13 = ((String)var1.get(var12)).toString();
               double var14 = 0.0D;
               double var7 = 0.0D;
               new Ecritures();

               for(int var10 = 0; var10 < this.lesEcrituresLettrees.size(); ++var10) {
                  Ecritures var9 = (Ecritures)this.lesEcrituresLettrees.get(var10);
                  if (var9.getEcrLettrage() != null && !var9.getEcrLettrage().isEmpty() && var9.getEcrLettrage().equals(var13)) {
                     var14 += var9.getEcrDebitPays();
                     var7 += var9.getEcrCreditPays();
                  }
               }

               if (this.utilNombre.myRoundDevise(var14, this.structureLog.getStrdevise()) != this.utilNombre.myRoundDevise(var7, this.structureLog.getStrdevise())) {
                  var11 = true;
                  this.var_erreur_lettrage = this.var_erreur_lettrage + var13 + ", ";
               }
            }
         }

         if (var11) {
            this.testequilibre = true;
         } else {
            this.var_erreur_lettrage = "";
         }
      }

   }

   public void recherchePlanComptable() throws JDOMException, IOException, HibernateException, NamingException {
      this.choix_compte = 0;
      this.planComptable = this.formRecherche.recherchePlanComptable((String)null, this.inputnum, 534, this.selectedExo, 0, this.usersLog.getUsrCptInterdit(), this.optionComptabilite);
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

   public void rechercheCompteCompense() throws ClassCastException, HibernateException, NamingException, JDOMException, IOException {
      this.choix_compte = 1;
      this.planComptable = this.formRecherche.recherchePlanComptable(this.selecFiscalite, this.var_compte_compense, 534, this.selectedExo, 0, this.usersLog.getUsrCptInterdit(), this.optionComptabilite);
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

   public void rechercheCompteOutils() throws ClassCastException, HibernateException, NamingException, JDOMException, IOException {
      this.choix_compte = 2;
      this.planComptable = this.formRecherche.recherchePlanComptable(this.selecFiscalite, this.ecritures.getEcrCompte(), 534, this.selectedExo, 0, this.usersLog.getUsrCptInterdit(), this.optionComptabilite);
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

   public void calculePlanComptable() throws JDOMException, IOException {
      if (this.choix_compte == 0) {
         if (this.planComptable != null) {
            this.inputnum = this.planComptable.getPlcCompte();
         } else {
            this.inputnum = "";
         }
      } else if (this.choix_compte == 1) {
         if (this.planComptable != null) {
            this.var_compte_compense = this.planComptable.getPlcCompte();
         } else {
            this.var_compte_compense = "";
         }
      } else if (this.choix_compte == 2) {
         if (this.planComptable != null) {
            this.ecritures.setEcrCompte(this.planComptable.getPlcCompte());
         } else {
            this.ecritures.setEcrCompte("");
         }
      }

      this.var_action = this.var_memo_action;
   }

   public void annulePlanComptable() {
      if (this.choix_compte == 0) {
         this.inputnum = "";
      } else if (this.choix_compte == 1) {
         this.var_compte_compense = "";
      } else if (this.choix_compte == 2) {
         this.ecritures.setEcrCompte("");
      }

      this.var_action = this.var_memo_action;
   }

   public void selectionLigne() throws ParseException {
      try {
         if (this.dataModelEcritures.isRowAvailable()) {
            this.ecritures = (Ecritures)this.dataModelEcritures.getRowData();
            this.var_memo_ligne_gene = this.ecritures.getEcr_id();
            this.calculeSelection();
         }
      } catch (Exception var2) {
         this.ecritures = null;
         this.var_memo_ligne_gene = 0L;
      }

   }

   public void calculeSelection() throws ParseException {
      if (this.ecritures != null) {
         String var1 = "";
         if (this.lettreCumul != null && !this.lettreCumul.isEmpty() && (this.lettreCumul == null || this.lettreCumul.isEmpty() || this.ecrDebitL != this.ecrCreditL)) {
            var1 = this.lettreCumul;
         } else if (this.ecritures.getEcrLettrage() != null && !this.ecritures.getEcrLettrage().isEmpty()) {
            var1 = this.ecritures.getEcrLettrage();
         }

         this.ecrDebitL = 0.0D;
         this.ecrCreditL = 0.0D;
         this.ecrDebitNL = 0.0D;
         this.ecrCreditNL = 0.0D;
         new Ecritures();

         for(int var3 = 0; var3 < this.lesEcritures.size(); ++var3) {
            Ecritures var2 = (Ecritures)this.lesEcritures.get(var3);
            if (var2.getEcrLettrage() != null && !var2.getEcrLettrage().isEmpty()) {
               if (var2.getEcrLettrage().equalsIgnoreCase(var1)) {
                  this.ecrDebitL += var2.getEcrDebitPays();
                  this.ecrCreditL += var2.getEcrCreditPays();
               }
            } else {
               this.ecrDebitNL += var2.getEcrDebitPays();
               this.ecrCreditNL += var2.getEcrCreditPays();
            }
         }

         if (this.ecrDebitL == this.ecrCreditL) {
            this.lettreCumul = var1;
            this.lettrModal = var1;
            if (this.lettreCumul.equals(this.lettrModal) || this.lettrModal == null || this.lettrModal.isEmpty()) {
               this.calculerProchaineLettre();
            }
         } else {
            this.lettreCumul = var1;
            this.lettrModal = var1;
         }

         this.var_affiche_bouton = true;
         this.verifLettrage();
      }

   }

   public void calculeSelectionLight() {
      this.ecrDebitS = 0.0D;
      this.ecrCreditS = 0.0D;
      this.soldeDebitS = 0.0D;
      this.soldeCreditS = 0.0D;
      new Ecritures();

      for(int var2 = 0; var2 < this.lesEcritures.size(); ++var2) {
         Ecritures var1 = (Ecritures)this.lesEcritures.get(var2);
         if (var1.isSel_ecriture()) {
            this.ecrDebitS += var1.getEcrDebitPays();
            this.ecrCreditS += var1.getEcrCreditPays();
         }
      }

      if (this.ecrDebitS > this.ecrCreditS) {
         this.soldeDebitS = this.ecrDebitS - this.ecrCreditS;
         this.soldeCreditS = 0.0D;
      } else {
         this.soldeDebitS = 0.0D;
         this.soldeCreditS = this.ecrCreditS - this.ecrDebitS;
      }

   }

   public void toutDeSelectionner() throws ParseException {
      if (this.lesEcritures.size() != 0) {
         for(int var1 = 0; var1 < this.lesEcritures.size(); ++var1) {
            this.ecritures = (Ecritures)this.lesEcritures.get(var1);
            this.ecritures.setSel_ecriture(false);
         }

         this.dataModelEcritures.setWrappedData(this.lesEcritures);
         this.calculeSelectionLight();
      }

   }

   public void toutSelectionner() throws ParseException {
      if (this.lesEcritures.size() != 0) {
         for(int var1 = 0; var1 < this.lesEcritures.size(); ++var1) {
            this.ecritures = (Ecritures)this.lesEcritures.get(var1);
            this.ecritures.setSel_ecriture(true);
         }

         this.dataModelEcritures.setWrappedData(this.lesEcritures);
         this.calculeSelectionLight();
      }

   }

   public void selectionPointage() {
      this.pointModal = "";
      this.showModalPanelPointage = true;
   }

   public void pointerSelection() throws HibernateException, NamingException {
      if (this.lesEcritures.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);

            for(int var3 = 0; var3 < this.lesEcritures.size(); ++var3) {
               this.ecritures = new Ecritures();
               this.ecritures = (Ecritures)this.lesEcritures.get(var3);
               if (this.ecritures.isSel_ecriture()) {
                  this.ecritures.setEcrPointage(this.pointModal.toUpperCase());
                  this.ecritures.setSel_ecriture(false);
                  this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
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

      this.showModalPanelPointage = false;
   }

   public void fermerPointage() {
      this.showModalPanelPointage = false;
   }

   public void ouvrirLettre() {
      this.showModalPanelLettrage = true;
   }

   public void verifLettrage() {
      if (this.lettreCumul != null && !this.lettreCumul.isEmpty() && this.ecrDebitL != this.ecrCreditL) {
         this.testequilibre = true;
      } else if (this.lettreCumul != null && !this.lettreCumul.isEmpty() && this.ecrDebitL == this.ecrCreditL) {
         this.testequilibre = false;
      } else {
         this.lettreCumul = "";
         this.testequilibre = false;
      }

   }

   public void valideLettre() {
      this.showModalPanelLettrage = false;
   }

   public void lettreLigne() throws NamingException, ParseException {
      if (this.dataModelEcritures.isRowAvailable()) {
         this.ecritures = (Ecritures)this.dataModelEcritures.getRowData();
      }

      if (this.ecritures != null && this.lettrModal != null && !this.lettrModal.isEmpty()) {
         boolean var1 = false;
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            var2.setFlushMode(FlushMode.MANUAL);
            this.ecritures.setSel_ecriture(false);
            if (this.ecritures.getEcrLettrage() != null && !this.ecritures.getEcrLettrage().isEmpty()) {
               this.ecritures.setEcrLettrage("");
               this.ecritures = this.ecrituresDao.modif(this.ecritures, var2);
               var2.flush();
               var1 = true;
            } else {
               this.ecritures.setEcrLettrage(this.lettrModal);
               this.ecritures = this.ecrituresDao.modif(this.ecritures, var2);
               var2.flush();
               this.lesEcrituresLettrees.add(this.ecritures);
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

         if (var1) {
            this.lesEcrituresLettrees.clear();
            if (this.planComptable != null) {
               this.lesEcrituresLettrees = this.ecrituresDao.chargerLesEcritureslettres(this.selectedExo.getExecpt_id(), "", this.planComptable.getPlcCompte(), (Session)null);
            }
         }

         this.var_erreur_lettrage = "";
         this.calculeSelection();
         this.testEquilibre();
         if (this.filtrage.equalsIgnoreCase("1") && this.lettreCumul != null && !this.lettreCumul.isEmpty() && this.ecrDebitL == this.ecrCreditL && this.lesEcritures.size() != 0) {
            for(int var4 = 0; var4 < this.lesEcritures.size(); ++var4) {
               this.ecritures = new Ecritures();
               this.ecritures = (Ecritures)this.lesEcritures.get(var4);
               if (this.ecritures.getEcrLettrage() != null && !this.ecritures.getEcrLettrage().isEmpty()) {
                  this.lesEcritures.remove(this.ecritures);
               }
            }

            this.dataModelEcritures.setWrappedData(this.lesEcritures);
         }
      }

   }

   public void verifierSelection() throws NamingException, HibernateException, ParseException {
      this.var_debit_compense = 0.0D;
      this.var_credit_compense = 0.0D;
      this.var_memo_compte = this.planComptable.getPlcCompte();

      for(int var1 = 0; var1 < this.lesEcritures.size(); ++var1) {
         if (((Ecritures)this.lesEcritures.get(var1)).isSel_ecriture()) {
            this.var_debit_compense += ((Ecritures)this.lesEcritures.get(var1)).getEcrDebitSaisie();
            this.var_credit_compense += ((Ecritures)this.lesEcritures.get(var1)).getEcrCreditSaisie();
            this.var_date_compense = ((Ecritures)this.lesEcritures.get(var1)).getEcrDateSaisie();
         }
      }

      if (this.var_debit_compense != this.var_credit_compense) {
         if (this.var_debit_compense > this.var_credit_compense) {
            this.var_compense = this.var_debit_compense - this.var_credit_compense;
            this.var_compte_compense = this.optionComptabilite.getEcartDebit();
         } else {
            this.var_compense = this.var_credit_compense - this.var_debit_compense;
            this.var_compte_compense = this.optionComptabilite.getEcartCredit();
         }

         this.var_libelle_compense = "";
         this.showModalPanelCompense = true;
      } else {
         this.var_date_compense = null;
         this.var_compense = 0.0D;
         this.var_compte_compense = "";
         this.var_libelle_compense = "";
         this.showModalPanelCompense = false;
         this.lettrerSelection();
      }

   }

   public void fermerSelection() {
      this.showModalPanelCompense = false;
   }

   public void lettrerSelection() throws NamingException, HibernateException, ParseException {
      boolean var1 = false;
      if (this.lesEcritures.size() != 0 && this.lettrModal != null && !this.lettrModal.isEmpty()) {
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            var2.setFlushMode(FlushMode.MANUAL);

            for(int var4 = 0; var4 < this.lesEcritures.size(); ++var4) {
               this.ecritures = new Ecritures();
               this.ecritures = (Ecritures)this.lesEcritures.get(var4);
               if (this.ecritures.isSel_ecriture()) {
                  this.ecritures.setEcrLettrage(this.lettrModal);
                  this.ecritures.setSel_ecriture(false);
                  this.ecritures = this.ecrituresDao.modif(this.ecritures, var2);
                  var2.flush();
               }
            }

            this.lesEcrituresLettrees.add(this.ecritures);
            if (this.var_compense != 0.0D && this.var_date_compense != null && this.inputnum != null && !this.inputnum.isEmpty()) {
               this.journauxComptables = this.journauxComptablesDao.chercherCode("OD", this.selectedExo.getExecpt_id(), var2);
               if (this.journauxComptables != null) {
                  new PlanComptable();
                  PlanComptable var18 = this.planComptableDao.chercherCompte(this.selecFiscalite, this.var_compte_compense, this.selectedExo.getExecpt_id(), var2);
                  this.planComptable = this.planComptableDao.chercherCompte(this.selecFiscalite, this.var_memo_compte, this.selectedExo.getExecpt_id(), var2);
                  if (var18 != null) {
                     String var5 = this.numComposeJournal(var2);
                     double var6 = this.utilNombre.myRoundDevise(this.var_debit_compense, this.structureLog.getStrdevise());
                     double var8 = this.utilNombre.myRoundDevise(this.var_credit_compense, this.structureLog.getStrdevise());
                     this.ecritures = new Ecritures();
                     this.ecritures.setExercicesComptable(this.selectedExo);
                     this.ecritures.setBrouillard((Brouillard)null);
                     this.ecritures.setEcrDateSaisie(this.var_date_compense);
                     this.ecritures.setEcrJour(this.var_date_compense.getDate());
                     this.ecritures.setEcrCode(this.journauxComptables.getPljCode());
                     this.ecritures.setEcrNatureJrx(this.journauxComptables.getPljNature());
                     this.ecritures.setEcrReserve(this.journauxComptables.getPljReserve());
                     String var10 = "" + (this.ecritures.getEcrDateSaisie().getYear() + 1900);
                     String var11 = "";
                     if (this.ecritures.getEcrDateSaisie().getMonth() + 1 <= 9) {
                        var11 = "0" + (this.ecritures.getEcrDateSaisie().getMonth() + 1);
                     } else {
                        var11 = "" + (this.ecritures.getEcrDateSaisie().getMonth() + 1);
                     }

                     String var12 = "";
                     if (this.ecritures.getEcrJour() <= 9) {
                        var12 = "0" + this.ecritures.getEcrJour();
                     } else {
                        var12 = "" + this.ecritures.getEcrJour();
                     }

                     this.ecritures.setEcrPeriode(var11 + ":" + var10);
                     this.ecritures.setEcrAnnee(var10);
                     this.ecritures.setEcrEtat(0);
                     this.ecritures.setEcrCompte(this.planComptable.getPlcCompte());
                     this.ecritures.setEcrClasse(this.planComptable.getPlcCompte().substring(0, 1));
                     this.ecritures.setEcrLibCompte(this.planComptable.getPlcLibelleCpteFR());
                     this.ecritures.setEcrNature(this.planComptable.getPlcNature());
                     this.ecritures.setEcrCle1(this.ecritures.getEcrCode() + ":" + this.ecritures.getEcrPeriode());
                     this.ecritures.setEcrCle2(this.ecritures.getEcrCode() + ":" + var10 + ":" + var11 + ":" + var12);
                     this.ecritures.setEcrOrdre(0L);
                     if (var6 > var8) {
                        this.ecritures.setEcrDebitSaisie(0.0D);
                        this.ecritures.setEcrCreditSaisie(var6 - var8);
                     } else {
                        this.ecritures.setEcrDebitSaisie(var8 - var6);
                        this.ecritures.setEcrCreditSaisie(0.0D);
                     }

                     this.ecritures.setEcrLibelle(this.var_libelle_compense);
                     this.ecritures.setEcrLettrage(this.lettrModal);
                     if (this.journauxComptables.getPljTypeDevise() == 0) {
                        this.ecritures.setEcrDeviseSaisie(this.structureLog.getStrdevise());
                     } else if (this.journauxComptables.getPljTypeDevise() == 1) {
                        this.ecritures.setEcrDeviseSaisie(this.journauxComptables.getPljChoixDevise());
                     } else if (this.journauxComptables.getPljTypeDevise() == 2) {
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
                     this.ecritures.setEcrDateCreat(new Date());
                     this.ecritures.setEcrUserCreat(this.usersLog.getUsrid());
                     this.ecritures.setEcrPiece(var5);
                     this.ecritures = this.ecrituresDao.insert(this.ecritures, var2);
                     var2.flush();
                     this.lesEcritures.add(this.ecritures);
                     this.ecritures = new Ecritures();
                     this.ecritures.setExercicesComptable(this.selectedExo);
                     this.ecritures.setBrouillard((Brouillard)null);
                     this.ecritures.setEcrDateSaisie(this.var_date_compense);
                     this.ecritures.setEcrJour(this.ecritures.getEcrDateSaisie().getDate());
                     this.ecritures.setEcrCode(this.journauxComptables.getPljCode());
                     this.ecritures.setEcrNatureJrx(this.journauxComptables.getPljNature());
                     this.ecritures.setEcrReserve(this.journauxComptables.getPljReserve());
                     this.ecritures.setEcrPeriode(var11 + ":" + var10);
                     this.ecritures.setEcrAnnee(var10);
                     this.ecritures.setEcrEtat(0);
                     this.ecritures.setEcrCompte(var18.getPlcCompte());
                     this.ecritures.setEcrClasse(var18.getPlcCompte().substring(0, 1));
                     this.ecritures.setEcrLibCompte(var18.getPlcLibelleCpteFR());
                     this.ecritures.setEcrNature(var18.getPlcNature());
                     this.ecritures.setEcrCle1(this.ecritures.getEcrCode() + ":" + this.ecritures.getEcrPeriode());
                     this.ecritures.setEcrCle2(this.ecritures.getEcrCode() + ":" + var10 + ":" + var11 + ":" + var12);
                     this.ecritures.setEcrOrdre(0L);
                     if (var6 > var8) {
                        this.ecritures.setEcrDebitSaisie(var6 - var8);
                        this.ecritures.setEcrCreditSaisie(0.0D);
                     } else {
                        this.ecritures.setEcrDebitSaisie(0.0D);
                        this.ecritures.setEcrCreditSaisie(var8 - var6);
                     }

                     this.ecritures.setEcrLibelle(this.var_libelle_compense);
                     this.ecritures.setEcrLettrage("");
                     if (this.journauxComptables.getPljTypeDevise() == 0) {
                        this.ecritures.setEcrDeviseSaisie(this.structureLog.getStrdevise());
                     } else if (this.journauxComptables.getPljTypeDevise() == 1) {
                        this.ecritures.setEcrDeviseSaisie(this.journauxComptables.getPljChoixDevise());
                     } else if (this.journauxComptables.getPljTypeDevise() == 2) {
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
                     this.ecritures.setEcrDateCreat(new Date());
                     this.ecritures.setEcrUserCreat(this.usersLog.getUsrid());
                     this.ecritures.setEcrPiece(var5);
                     this.ecritures = this.ecrituresDao.insert(this.ecritures, var2);
                     var2.flush();
                     var1 = true;
                  }
               }
            } else {
               var1 = true;
            }

            if (var1) {
               var3.commit();
               this.dataModelEcritures.setWrappedData(this.lesEcritures);
            }
         } catch (HibernateException var16) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var16;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         if (this.filtrage.equalsIgnoreCase("1")) {
            this.chargerEcritures((Session)null);
         } else if (this.var_erreur_lettrage != null && !this.var_erreur_lettrage.isEmpty()) {
            this.chargerEcritures((Session)null);
         } else {
            this.calculerProchaineLettre();
            this.testEquilibre();
         }
      }

      this.showModalPanelCompense = false;
   }

   public String numComposeJournal(Session var1) {
      String var2 = "";
      return var2;
   }

   public void calculerProchaineLettre() throws ParseException {
      if (this.planComptable != null && this.ecrDebitL == this.ecrCreditL && !this.testequilibre) {
         boolean var1 = false;
         if (this.lesEcrituresLettrees.size() != 0) {
            this.lettrModal = "";
            int var2 = 0;

            int var3;
            String var4;
            for(var3 = 0; var3 < this.lesEcrituresLettrees.size(); ++var3) {
               if (((Ecritures)this.lesEcrituresLettrees.get(var3)).getEcrLettrage() != null && !((Ecritures)this.lesEcrituresLettrees.get(var3)).getEcrLettrage().isEmpty()) {
                  var4 = ((Ecritures)this.lesEcrituresLettrees.get(var3)).getEcrLettrage();
                  if (var4.length() > var2) {
                     var2 = var4.length();
                  }
               }
            }

            for(var3 = 0; var3 < this.lesEcrituresLettrees.size(); ++var3) {
               if (((Ecritures)this.lesEcrituresLettrees.get(var3)).getEcrLettrage() != null && !((Ecritures)this.lesEcrituresLettrees.get(var3)).getEcrLettrage().isEmpty()) {
                  var4 = ((Ecritures)this.lesEcrituresLettrees.get(var3)).getEcrLettrage();
                  if (var4 != null && !var4.isEmpty() && var4.length() >= var2) {
                     this.lettrModal = ((Ecritures)this.lesEcrituresLettrees.get(var3)).getEcrLettrage();
                  }
               }
            }

            if (this.lettrModal != null && !this.lettrModal.isEmpty()) {
               var1 = true;
            } else {
               this.lettrModal = "A";
               var1 = false;
            }

            if (var1) {
               new ArrayList();
               List var22 = this.calculeListeLettre();
               new ArrayList();
               List var23 = this.calculeListeLettre();
               new ArrayList();
               List var5 = this.calculeListeLettre();
               new ArrayList();
               List var6 = this.calculeListeLettre();
               String var7 = "";
               int var8 = this.lettrModal.length();
               int var9;
               boolean var10;
               if (var8 == 1) {
                  var9 = 0;
                  var10 = false;

                  for(int var24 = 0; var24 < var22.size(); ++var24) {
                     if (((String)var22.get(var24)).equalsIgnoreCase(this.lettrModal)) {
                        var9 = var24;
                        var10 = true;
                        break;
                     }
                  }

                  if (var10 = var9 < 25) {
                     var7 = (String)var22.get(var9 + 1);
                  } else {
                     var7 = (String)var22.get(0) + (String)var23.get(0);
                  }
               } else {
                  String var11;
                  int var12;
                  boolean var13;
                  String var14;
                  int var15;
                  if (var8 == 2) {
                     var9 = 0;
                     var10 = false;
                     var11 = this.lettrModal.substring(0, 1);

                     for(var12 = 0; var12 < var22.size(); ++var12) {
                        if (((String)var22.get(var12)).equalsIgnoreCase(var11)) {
                           var9 = var12;
                           var10 = true;
                           break;
                        }
                     }

                     var12 = 0;
                     var13 = false;
                     var14 = this.lettrModal.substring(1, 2);

                     for(var15 = 0; var15 < var23.size(); ++var15) {
                        if (((String)var23.get(var15)).equalsIgnoreCase(var14)) {
                           var12 = var15;
                           var13 = true;
                           break;
                        }
                     }

                     if (var13 = var12 < 25) {
                        var7 = (String)var22.get(var9) + (String)var23.get(var12 + 1);
                     } else if (var10 = var9 < 25) {
                        var7 = (String)var22.get(var9 + 1) + (String)var23.get(0);
                     } else {
                        var7 = (String)var22.get(var9) + (String)var23.get(0) + (String)var5.get(0);
                     }
                  } else {
                     boolean var16;
                     String var17;
                     int var18;
                     if (var8 == 3) {
                        var9 = 0;
                        var10 = false;
                        var11 = this.lettrModal.substring(0, 1);

                        for(var12 = 0; var12 < var22.size(); ++var12) {
                           if (((String)var22.get(var12)).equalsIgnoreCase(var11)) {
                              var9 = var12;
                              var10 = true;
                              break;
                           }
                        }

                        var12 = 0;
                        var13 = false;
                        var14 = this.lettrModal.substring(1, 2);

                        for(var15 = 0; var15 < var23.size(); ++var15) {
                           if (((String)var23.get(var15)).equalsIgnoreCase(var14)) {
                              var12 = var15;
                              var13 = true;
                              break;
                           }
                        }

                        var15 = 0;
                        var16 = false;
                        var17 = this.lettrModal.substring(2, 3);

                        for(var18 = 0; var18 < var5.size(); ++var18) {
                           if (((String)var5.get(var18)).equalsIgnoreCase(var17)) {
                              var15 = var18;
                              var16 = true;
                              break;
                           }
                        }

                        if (var16 = var15 < 25) {
                           var7 = (String)var22.get(var9) + (String)var23.get(var12) + (String)var5.get(var15 + 1);
                        } else if (var13 = var12 < 25) {
                           var7 = (String)var22.get(var9) + (String)var23.get(var12 + 1) + (String)var5.get(0);
                        } else if (var10 = var9 < 25) {
                           var7 = (String)var22.get(var9 + 1) + (String)var23.get(0) + (String)var5.get(0);
                        } else {
                           var7 = (String)var22.get(var9) + (String)var23.get(var9) + (String)var5.get(0) + (String)var6.get(0);
                        }
                     } else if (var8 != 4) {
                        var7 = "A";
                     } else {
                        var9 = 0;
                        var10 = false;
                        var11 = this.lettrModal.substring(0, 1);

                        for(var12 = 0; var12 < var22.size(); ++var12) {
                           if (((String)var22.get(var12)).equalsIgnoreCase(var11)) {
                              var9 = var12;
                              var10 = true;
                              break;
                           }
                        }

                        var12 = 0;
                        var13 = false;
                        var14 = this.lettrModal.substring(1, 2);

                        for(var15 = 0; var15 < var23.size(); ++var15) {
                           if (((String)var23.get(var15)).equalsIgnoreCase(var14)) {
                              var12 = var15;
                              var13 = true;
                              break;
                           }
                        }

                        var15 = 0;
                        var16 = false;
                        var17 = this.lettrModal.substring(2, 3);

                        for(var18 = 0; var18 < var5.size(); ++var18) {
                           if (((String)var5.get(var18)).equalsIgnoreCase(var17)) {
                              var15 = var18;
                              var16 = true;
                              break;
                           }
                        }

                        var18 = 0;
                        boolean var19 = false;
                        String var20 = this.lettrModal.substring(3, 4);

                        for(int var21 = 0; var21 < var6.size(); ++var21) {
                           if (((String)var6.get(var21)).equalsIgnoreCase(var20)) {
                              var18 = var21;
                              var19 = true;
                              break;
                           }
                        }

                        if (var19 = var18 < 25) {
                           var7 = (String)var22.get(var9) + (String)var23.get(var12) + (String)var5.get(var15) + (String)var6.get(var18 + 1);
                        } else if (var16 = var15 < 25) {
                           var7 = (String)var22.get(var9) + (String)var23.get(var12) + (String)var5.get(var15 + 1) + (String)var6.get(0);
                        } else if (var13 = var12 < 25) {
                           var7 = (String)var22.get(var9) + (String)var23.get(var12 + 1) + (String)var5.get(0) + (String)var6.get(0);
                        } else if (var10 = var9 < 25) {
                           var7 = (String)var22.get(var9 + 1) + (String)var23.get(0) + (String)var5.get(0) + (String)var6.get(0);
                        } else {
                           var7 = (String)var22.get(0);
                        }
                     }
                  }
               }

               this.lettrModal = var7;
            }
         } else {
            this.lettrModal = "A";
         }
      }

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

   public void ouvrirFiltre() {
      this.dateDu = this.dateDebut;
      this.dateAu = this.dateFin;
      this.choixFiltre = 0;
      this.showModalpanelFiltre = true;
   }

   public void valideFiltre() throws ParseException {
      if (this.lesEcritures.size() != 0) {
         this.dateDu = this.utilDate.dateJourPrecedent(this.dateDu);
         this.dateAu = this.utilDate.dateMoisSuivant(this.dateAu);

         for(int var1 = 0; var1 < this.lesEcritures.size(); ++var1) {
            this.ecritures = new Ecritures();
            this.ecritures = (Ecritures)this.lesEcritures.get(var1);
            if (this.choixFiltre == 0 && this.ecritures.getEcrDateSaisie().after(this.dateDu) && this.ecritures.getEcrDateSaisie().before(this.dateAu)) {
               this.ecritures.setSel_ecriture(true);
            }
         }

         this.calculeSelection();
         this.dataModelEcritures.setWrappedData(this.lesEcritures);
      }

      this.showModalpanelFiltre = false;
   }

   public void fermerFiltre() {
      this.showModalpanelFiltre = false;
   }

   public void fermerLettrage() {
      this.showModalPanelLettrage = false;
   }

   public void ouvrirDelettrage() {
      this.delettre = 10;
      this.showModalPanelDelettrage = true;
   }

   public void deLettrerSelection() throws HibernateException, NamingException, ParseException {
      if (this.lesEcritures.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            if (this.delettre == 0) {
               if (this.ecritures != null && this.ecritures.isSel_ecriture()) {
                  this.ecritures.setEcrLettrage("");
                  this.ecritures.setSel_ecriture(false);
                  this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
                  var1.flush();
               }
            } else {
               int var3;
               if (this.delettre == 1) {
                  for(var3 = 0; var3 < this.lesEcritures.size(); ++var3) {
                     this.ecritures = new Ecritures();
                     this.ecritures = (Ecritures)this.lesEcritures.get(var3);
                     if (this.ecritures.getEcrLettrage() != null && !this.ecritures.getEcrLettrage().isEmpty() && this.ecritures.getEcrLettrage().equalsIgnoreCase(this.lettreCumul)) {
                        this.ecritures.setEcrLettrage("");
                        this.ecritures.setSel_ecriture(false);
                        this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
                        var1.flush();
                     }
                  }
               } else if (this.delettre == 2) {
                  for(var3 = 0; var3 < this.lesEcritures.size(); ++var3) {
                     this.ecritures = new Ecritures();
                     this.ecritures = (Ecritures)this.lesEcritures.get(var3);
                     this.ecritures.setSel_ecriture(false);
                     this.ecritures.setEcrLettrage("");
                     this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
                     var1.flush();
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

         this.lesEcrituresLettrees.clear();
         if (this.planComptable != null) {
            this.lesEcrituresLettrees = this.ecrituresDao.chargerLesEcritureslettres(this.selectedExo.getExecpt_id(), "", this.planComptable.getPlcCompte(), (Session)null);
         }

         if (this.var_erreur_lettrage != null && !this.var_erreur_lettrage.isEmpty()) {
            this.chargerEcritures((Session)null);
         } else {
            this.calculerProchaineLettre();
            this.testEquilibre();
         }
      }

      this.showModalPanelDelettrage = false;
   }

   public void fermerDelettrage() {
      this.showModalPanelDelettrage = false;
   }

   public void visualisationPiece() throws HibernateException, NamingException {
      int var1;
      if (this.ecritures != null && this.ecritures.getEcrPiece() != null && !this.ecritures.getEcrPiece().isEmpty()) {
         this.listDetail.clear();
         this.listDetail = this.ecrituresDao.selectPiece(this.ecritures.getEcrCode(), this.ecritures.getEcrPiece(), this.ecritures.getEcrPeriode());
         if (this.listDetail.size() != 0) {
            this.var_tot_debit = 0.0D;
            this.var_tot_credit = 0.0D;
            this.var_solde = 0.0D;

            for(var1 = 0; var1 < this.listDetail.size(); ++var1) {
               this.var_tot_debit += ((Ecritures)this.listDetail.get(var1)).getEcrDebitSaisie();
               this.var_tot_credit += ((Ecritures)this.listDetail.get(var1)).getEcrCreditSaisie();
            }

            if (this.planComptable.getPlcSens() == 1) {
               this.var_solde = this.var_tot_credit - this.var_tot_debit;
            } else {
               this.var_solde = this.var_tot_debit - this.var_tot_credit;
            }

            this.dataModelDetailPiece.setWrappedData(this.listDetail);
            this.ecrituresDetail = null;
            this.var_action = 15;
            this.var_memo_action = this.var_action;
         }
      } else if (this.ecritures != null && (this.ecritures.getEcrPiece() == null || this.ecritures.getEcrPiece().isEmpty())) {
         this.listDetail.clear();
         this.listDetail = this.ecrituresDao.ChargerLesEcrituresById(this.ecritures.getEcr_id(), (Session)null);
         if (this.listDetail.size() != 0) {
            this.var_tot_debit = 0.0D;
            this.var_tot_credit = 0.0D;
            this.var_solde = 0.0D;

            for(var1 = 0; var1 < this.listDetail.size(); ++var1) {
               this.var_tot_debit += ((Ecritures)this.listDetail.get(var1)).getEcrDebitSaisie();
               this.var_tot_credit += ((Ecritures)this.listDetail.get(var1)).getEcrCreditSaisie();
            }

            if (this.planComptable.getPlcSens() == 1) {
               this.var_solde = this.var_tot_credit - this.var_tot_debit;
            } else {
               this.var_solde = this.var_tot_debit - this.var_tot_credit;
            }

            this.dataModelDetailPiece.setWrappedData(this.listDetail);
            this.ecrituresDetail = null;
            this.var_action = 15;
            this.var_memo_action = this.var_action;
         }
      }

   }

   public void selectionPiece() {
      if (this.dataModelDetailPiece.isRowAvailable()) {
         this.ecrituresDetail = (Ecritures)this.dataModelDetailPiece.getRowData();
      }

   }

   public void fermerDetailPiece() {
      if (this.ecrituresDetail != null && this.ecritures.getEcr_id() == this.ecrituresDetail.getEcr_id()) {
         int var1 = 0;

         for(int var2 = 0; var2 < this.lesEcritures.size(); ++var2) {
            if (((Ecritures)this.lesEcritures.get(var2)).getEcr_id() == this.ecrituresDetail.getEcr_id()) {
               var1 = var2;
               break;
            }
         }

         this.lesEcritures.remove(this.ecritures);
         this.ecritures = this.ecrituresDetail;
         this.lesEcritures.add(var1, this.ecritures);
      }

      this.var_action = 0;
   }

   public void modifierEcriture() throws HibernateException, NamingException, ParseException {
      this.selectionPiece();
      if (this.ecrituresDetail != null) {
         this.afficheBudgetTresorerie();
         this.showModalPanelModifPiece = true;
      }

   }

   public void afficheBudgetTresorerie() throws HibernateException, NamingException {
      this.afficheBudgetTresoProjet = false;
      this.afficheBudgetTresoStandard = false;
      if (this.optionComptabilite.getTresorerie().equals("true")) {
         this.journauxComptables = this.journauxComptablesDao.chercherCode(this.ecrituresDetail.getEcrCode(), this.ecrituresDetail.getExercicesComptable().getExecpt_id(), (Session)null);
         this.memo_compte_budgetTreso = "";
         if (this.journauxComptables.getPljCompteTreso() != null && !this.journauxComptables.getPljCompteTreso().isEmpty()) {
            if (this.comptaProjet) {
               if (this.journauxComptables.getPljNature() != 7 && this.journauxComptables.getPljNature() != 9) {
                  if (this.ecritures.getEcrCompte().equals(this.journauxComptables.getPljCompteTreso()) && this.structureLog.isStrProjet()) {
                     this.afficheBudgetTresoProjet = true;
                  }
               } else if (this.structureLog.isStrProjet()) {
                  this.afficheBudgetTresoProjet = true;
               }
            } else if (this.journauxComptables.getPljNature() != 7 && this.journauxComptables.getPljNature() != 9) {
               if (this.ecritures.getEcrCompte().equals(this.journauxComptables.getPljCompteTreso()) && this.structureLog.isStrProjet()) {
                  this.afficheBudgetTresoStandard = true;
               }
            } else if (this.structureLog.isStrProjet()) {
               this.afficheBudgetTresoStandard = true;
            }
         }
      }

   }

   public void fermerModifierPiece() {
      this.ecrituresDetail = null;
      this.showModalPanelModifPiece = false;
   }

   public void vaiderModifierEcriture() throws HibernateException, NamingException {
      if (this.ecrituresDetail != null) {
         this.ecrituresDetail = this.ecrituresDao.modif(this.ecrituresDetail);
      }

      this.showModalPanelModifPiece = false;
   }

   public boolean testCompteAnalytique(Ecritures var1) {
      boolean var2 = false;
      if (var1.getEcrNature() == 1) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c1());
      } else if (var1.getEcrNature() == 2) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c2());
      } else if (var1.getEcrNature() == 3) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c3());
      } else if (var1.getEcrNature() == 4) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c4());
      } else if (var1.getEcrNature() == 5) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c5());
      } else if (var1.getEcrNature() == 6) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c6());
      } else if (var1.getEcrNature() == 7) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c7());
      } else if (var1.getEcrNature() == 8) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c8());
      } else if (var1.getEcrNature() == 9) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c9());
      } else if (var1.getEcrNature() == 10) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c10());
      } else if (var1.getEcrNature() == 11) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c11());
      } else if (var1.getEcrNature() == 12) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c12());
      } else if (var1.getEcrNature() == 13) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c13());
      } else if (var1.getEcrNature() == 14) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c14());
      } else if (var1.getEcrNature() == 15) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c15());
      } else if (var1.getEcrNature() == 16) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c16());
      } else if (var1.getEcrNature() == 17) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c17());
      } else if (var1.getEcrNature() == 18) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c18());
      } else if (var1.getEcrNature() == 19) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c19());
      } else if (var1.getEcrNature() == 20) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c20());
      } else if (var1.getEcrNature() == 21) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c21());
      } else if (var1.getEcrNature() == 22) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c22());
      } else if (var1.getEcrNature() == 23) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c23());
      } else if (var1.getEcrNature() == 24) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getAnal_c24());
      } else {
         var2 = false;
      }

      return var2;
   }

   public void rechercheBudgetTresorerie() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      String var1 = this.utilDate.dateToStringSQLLight(this.ecrituresDetail.getEcrDateSaisie());
      if (this.comptaProjet) {
         this.plansTresorerie = this.formRecherche.rechercheBudgetTresorerie(this.journauxComptables.getPljProjet(), this.ecrituresDetail.getEcrPosteTreso(), var1, 534, this.ecrituresDetail.getExercicesComptable(), this.optionComptabilite);
      } else {
         this.plansTresorerie = this.formRecherche.rechercheBudgetTresorerie((String)null, this.ecrituresDetail.getEcrTreso(), var1, 534, this.ecrituresDetail.getExercicesComptable(), this.optionComptabilite);
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
         this.ecrituresDetail.setEcrPosteTreso(this.plansTresorerie.getTreCode());
         if (this.plansTresorerie.getTreProjet() != null && !this.plansTresorerie.getTreProjet().isEmpty()) {
            if (this.plansTresorerie.getTreProjet().contains(":")) {
               String[] var1 = this.plansTresorerie.getTreProjet().split(":");
               this.ecrituresDetail.setEcrBudgetTreso(var1[0]);
               this.ecrituresDetail.setEcrContrePartie(this.plansTresorerie.getTreCompte());
            } else {
               this.ecrituresDetail.setEcrBudgetTreso(this.plansTresorerie.getTreProjet());
               this.ecrituresDetail.setEcrContrePartie(this.plansTresorerie.getTreCompte());
            }

            this.memo_compte_budgetTreso = this.plansTresorerie.getTreCompte();
         } else {
            this.ecrituresDetail.setEcrBudgetTreso("");
            this.memo_compte_budgetTreso = "";
         }
      } else if (this.plansTresorerie != null && !this.comptaProjet) {
         this.ecrituresDetail.setEcrTreso(this.plansTresorerie.getTreCode());
         this.memo_compte_budgetTreso = this.plansTresorerie.getTreCompte();
      } else {
         this.plansTresorerie = null;
         this.ecrituresDetail.setEcrPosteTreso("");
         this.ecrituresDetail.setEcrBudgetTreso("");
         this.ecrituresDetail.setEcrTreso("");
         this.memo_compte_budgetTreso = "";
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleBudgetTresorerie() {
      this.plansTresorerie = null;
      this.ecrituresDetail.setEcrBudgetTreso("");
      this.ecrituresDetail.setEcrPosteTreso("");
      this.ecrituresDetail.setEcrTreso("");
      this.memo_compte_budgetTreso = "";
      this.var_action = this.var_memo_action;
   }

   public String recupereJournal() {
      String var1 = "";
      if (this.ecritures != null) {
         var1 = this.ecritures.getEcrCode();
      }

      return var1;
   }

   public Date recuperePeriode() {
      Date var1 = null;
      if (this.ecritures != null) {
         var1 = this.ecritures.getEcrDateSaisie();
      }

      return var1;
   }

   public String recuperePiece() {
      String var1 = "";
      if (this.ecritures != null) {
         var1 = this.ecritures.getEcrPiece();
      }

      return var1;
   }

   public void ouvrirJournal() {
      this.var_action = 17;
   }

   public void ouvrirJournalErreur() {
      this.messageAlerte = "Le journal " + this.ecritures.getEcrCode() + " est soit déjà ouvert par un autre agent soit indisponible pour le moment....";
      this.var_action = 18;
   }

   public void fermerJournal() throws HibernateException, NamingException, ParseException {
      this.chargerEcritures();
      this.var_action = 0;
   }

   public void ouvrirDetailsAnalytique() throws HibernateException, NamingException, ParseException {
      this.ouvrirDetailsAnalytique((Session)null);
   }

   public void ouvrirDetailsAnalytique(Session var1) throws HibernateException, NamingException, ParseException {
      this.selectionLigne();
      if (this.ecritures != null && this.ecritures.getEcrAnaActif() == 1) {
         if (this.formAnalytique == null) {
            this.formAnalytique = new FormAnalytique(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
         }

         this.formAnalytique.initAnalytique(this.optionComptabilite, var1);
         this.formAnalytique.chargementDetailAnalytique(this.ecritures, true, var1);
         this.showModalPanelAnalytique = true;
      }

   }

   public void modifierDetailsAnalytique() throws HibernateException, NamingException, ParseException {
      this.modifierDetailsAnalytique((Session)null);
   }

   public void modifierDetailsAnalytique(Session var1) throws HibernateException, NamingException, ParseException {
      this.selectionLigne();
      if (this.ecritures != null && this.ecritures.getEcrAnaActif() == 1) {
         if (this.formAnalytique == null) {
            this.formAnalytique = new FormAnalytique(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
         }

         this.formAnalytique.initAnalytique(this.optionComptabilite, var1);
         this.formAnalytique.chargementDetailAnalytique(this.ecritures, false, var1);
         this.showModalPanelAnalytique = true;
      }

   }

   public void fermerDetailsAnalytique() {
      this.showModalPanelAnalytique = false;
      this.showModalPanelAnalytiqueCorrection = false;
      this.showModalPanelCorrection = false;
   }

   public void fermerAnalytique() {
      this.showModalPanelAnalytique = false;
      this.showModalPanelAnalytiqueCorrection = false;
      this.showModalPanelCorrection = false;
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

   public void valideAnalytique() throws HibernateException, NamingException {
      if (this.var_memo_ligne_gene != 0L) {
         this.formAnalytique.saveDetailAnalytique(this.var_memo_ligne_gene, this.ecrituresDao);
         this.ecritures.setErreurAnalytique(false);
      }

      this.showModalPanelAnalytiqueCorrection = false;
      this.showModalPanelAnalytique = false;
   }

   public void interchangeEcritures() throws IOException, ParseException {
      this.var_action = 4;
      this.var_memo_action = this.var_action;
      this.outilChoisi = 99;
      this.forceVerrou = false;
      this.inputnum = this.planComptable.getPlcCompte();
      this.ecritures = new Ecritures();
      this.toolsCompteOld = "";
      this.lesEcrituresAReimputer = new ArrayList();
      this.dataModelEcritureAReimputer = new ListDataModel();
      this.showModalPanelCorrection = false;
   }

   public void selectionAll() {
      if (this.lesEcritures.size() != 0) {
         for(int var1 = 0; var1 < this.lesEcritures.size(); ++var1) {
            this.ecritures = new Ecritures();
            this.ecritures = (Ecritures)this.lesEcritures.get(var1);
            this.ecritures.setSel_ecriture(true);
         }

         this.dataModelEcritures.setWrappedData(this.lesEcritures);
      }

   }

   public void deselectionAll() {
      if (this.lesEcritures.size() != 0) {
         for(int var1 = 0; var1 < this.lesEcritures.size(); ++var1) {
            this.ecritures = new Ecritures();
            this.ecritures = (Ecritures)this.lesEcritures.get(var1);
            this.ecritures.setSel_ecriture(false);
         }

         this.dataModelEcritures.setWrappedData(this.lesEcritures);
      }

   }

   public void majCorrection() throws HibernateException, NamingException, ParseException {
      if (this.lesEcritures.size() != 0) {
         this.ecrituresAnalytiquesDao = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         this.listeRepartitionAnal = new ArrayList();
         this.ecrituresAnalytique = new EcrituresAnalytique();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "EcrituresCorrections");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            String var3 = "";
            if (this.outilChoisi == 5 && this.planComptable != null) {
               var3 = "Correction Ecriture extrait compte: " + this.inputnum + ": change compte vers " + this.planComptable.getPlcCompte();
               this.outilsChoisi5(var1);
            } else if (this.outilChoisi == 17) {
               var3 = "Correction Ecriture extrait compte: " + this.inputnum + ": recopie lettrage vers pointage";
               this.outilsChoisi17(var1);
            } else if (this.outilChoisi == 18) {
               var3 = "Correction Ecriture extrait compte: " + this.inputnum + ": recopie pointage vers lettrage";
               this.outilsChoisi18(var1);
            } else if (this.outilChoisi == 19) {
               var3 = "Correction Ecriture extrait de compte: Recalcul compte CNAMGS";
               this.outilsChoisi19(var1);
            }

            this.majEspion(var1, var3);
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.chargerEcritures((Session)null);
      }

      if (this.lesEcrituresAReimputer.size() != 0) {
         this.showModalPanelCorrection = true;
      } else {
         this.var_action = 0;
      }

   }

   public void outilsChoisi5(Session var1) throws HibernateException, NamingException {
      this.lesEcrituresAReimputer.clear();

      for(int var2 = 0; var2 < this.lesEcritures.size(); ++var2) {
         this.ecritures = (Ecritures)this.lesEcritures.get(var2);
         if (this.ecritures.isSel_ecriture() && (!this.ecritures.isNbrEcrLettrage() && !this.forceVerrou || this.forceVerrou)) {
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
            this.listeRepartitionAnal = new ArrayList();
            this.listeRepartitionAnal = this.ecrituresAnalytiquesDao.chargerLesEcrituresAnalytiques(this.ecritures, var1);
            int var3;
            if (this.listeRepartitionAnal.size() != 0 && this.ecritures.getEcrAnaActif() == 1) {
               for(var3 = 0; var3 < this.listeRepartitionAnal.size(); ++var3) {
                  this.ecrituresAnalytique = (EcrituresAnalytique)this.listeRepartitionAnal.get(var3);
                  this.ecrituresAnalytique.setEcranaCompte(this.ecritures.getEcrCompte());
                  this.ecrituresAnalytique.setEcranaClasse(this.ecritures.getEcrClasse());
                  this.ecrituresAnalytique.setEcranaNature(this.ecritures.getEcrNature());
                  this.ecrituresAnalytique.setEcranaLigneLib(this.ecritures.getEcrLibCompte());
                  this.ecrituresAnalytiquesDao.modifEcritureAnalytiques(var1, this.ecrituresAnalytique);
                  var1.flush();
               }
            } else if (this.listeRepartitionAnal.size() != 0 && this.ecritures.getEcrAnaActif() == 0) {
               for(var3 = 0; var3 < this.listeRepartitionAnal.size(); ++var3) {
                  this.ecrituresAnalytique = (EcrituresAnalytique)this.listeRepartitionAnal.get(var3);
                  this.ecrituresAnalytiquesDao.nettoyageAnalytique(this.ecrituresAnalytique, var1);
                  var1.flush();
               }
            } else if (this.listeRepartitionAnal.size() == 0 && this.ecritures.getEcrAnaActif() == 1) {
               this.ecritures.setErreurAnalytique(true);
               this.lesEcrituresAReimputer.add(this.ecritures);
            }
         }
      }

      this.dataModelEcritureAReimputer.setWrappedData(this.lesEcrituresAReimputer);
   }

   public void outilsChoisi17(Session var1) {
      for(int var2 = 0; var2 < this.lesEcritures.size(); ++var2) {
         this.ecritures = new Ecritures();
         this.ecritures = (Ecritures)this.lesEcritures.get(var2);
         if (this.ecritures.isSel_ecriture() && this.ecritures.getEcrLettrage() != null && !this.ecritures.getEcrLettrage().isEmpty()) {
            this.ecritures.setEcrPointage(this.ecritures.getEcrLettrage());
            this.ecritures.setEcrLettrage((String)null);
            this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
            var1.flush();
         }
      }

   }

   public void outilsChoisi18(Session var1) {
      for(int var2 = 0; var2 < this.lesEcritures.size(); ++var2) {
         this.ecritures = new Ecritures();
         this.ecritures = (Ecritures)this.lesEcritures.get(var2);
         if (this.ecritures.isSel_ecriture() && this.ecritures.getEcrPointage() != null && !this.ecritures.getEcrPointage().isEmpty()) {
            String var3 = "";
            if (this.ecritures.getEcrPointage().contains(":")) {
               String[] var4 = this.ecritures.getEcrPointage().split(":");
               var3 = var4[1];
            } else {
               var3 = this.ecritures.getEcrPointage();
            }

            if (var3.length() > 4) {
               var3 = var3.substring(4);
            }

            this.ecritures.setEcrLettrage(var3);
            this.ecritures.setEcrPointage((String)null);
            this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
            var1.flush();
         }
      }

   }

   public void outilsChoisi19(Session var1) throws HibernateException, NamingException {
      if (this.planComptable != null && this.planComptable.getPlcLibelleCpteFR().startsWith("CNAMGS")) {
         LireLesoptionsMedical var2 = new LireLesoptionsMedical();
         var2.setStrId(this.structureLog.getStrid());
         new OptionMedical();
         OptionMedical var3 = var2.lancer();
         FactureEnteteMedicalDao var4 = new FactureEnteteMedicalDao(this.baseLog, this.utilInitHibernate);
         new FactureEnteteMedical();

         for(int var6 = 0; var6 < this.lesEcritures.size(); ++var6) {
            this.ecritures = new Ecritures();
            this.ecritures = (Ecritures)this.lesEcritures.get(var6);
            if (this.ecritures.isSel_ecriture() && this.ecritures.getEcrReference1() != null && !this.ecritures.getEcrReference1().isEmpty()) {
               String var7 = "";
               String var8 = "";
               String var9 = "";
               if (this.ecritures.getEcrReference1().contains(":")) {
                  String[] var10 = this.ecritures.getEcrReference1().split(":");
                  var8 = var10[1];
               } else {
                  var8 = this.ecritures.getEcrReference1();
               }

               FactureEnteteMedical var5 = var4.pourParapheur(var8, var1);
               if (var5 != null) {
                  if (var5.getFacFondCnamgs() != 1 && var5.getFacFondCnamgs() != 11 && var5.getFacFondCnamgs() != 21 && var5.getFacFondCnamgs() != 31) {
                     if (var5.getFacFondCnamgs() != 2 && var5.getFacFondCnamgs() != 12 && var5.getFacFondCnamgs() != 22 && var5.getFacFondCnamgs() != 32) {
                        if (var5.getFacFondCnamgs() != 3 && var5.getFacFondCnamgs() != 13 && var5.getFacFondCnamgs() != 23 && var5.getFacFondCnamgs() != 33) {
                           var7 = var3.getCompteCNAMGSAP();
                        } else {
                           var7 = var3.getCompteCNAMGSGEF();
                        }
                     } else {
                        var7 = var3.getCompteCNAMGSSP();
                     }
                  } else {
                     var7 = var3.getCompteCNAMGSAP();
                  }

                  if (var7 != null && !var7.isEmpty()) {
                     this.ecritures.setEcrCompte(var7);
                     this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
                     var1.flush();
                  }
               }
            }
         }
      }

   }

   public void majEspion(Session var1, String var2) {
      Espion var3 = new Espion();
      var3.setEspdtecreat(new Date());
      var3.setUsers(this.usersLog);
      var3.setEspaction(var2);
      var3.setEsptype(0);
      EspionDao var4 = new EspionDao(this.baseLog, this.utilInitHibernate);
      var4.mAJEspion(var3, var1);
   }

   public void fermerCorrection() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
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

   public void ouvrirPjConsultation() throws HibernateException, NamingException, MalformedURLException, IOException, ParseException {
      if (this.ecritures == null) {
         this.selectionLigne();
      }

      if (this.ecritures != null && this.ecritures.getEcrPiece() != null && !this.ecritures.getEcrPiece().isEmpty()) {
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "scanCompta" + this.selectedExo.getExecpt_id() + File.separator;
         String var2 = this.ecritures.getEcrCode() + ":" + this.ecritures.getEcrPeriode() + ":" + this.ecritures.getEcrPiece().replaceAll("/", "_");
         File var3 = new File(var1 + var2 + ".pdf");
         if (var3.exists()) {
            this.typeFichier = 1;
            var2 = var2 + ".pdf";
         } else {
            this.typeFichier = 0;
            var2 = var2 + ".jpg";
         }

         if (this.typeFichier == 1) {
            if (this.utilDownload == null) {
               this.utilDownload = new UtilDownload();
            }

            this.fichierUrl = this.utilDownload.convertirFichierUtl(var1 + var2, this.urlExplorateur);
            this.fichierMine = this.utilDownload.calculeTypeMine(var2);
            this.typeFichier = 1;
         } else {
            this.urlphotoProd = "structure" + this.structureLog.getStrid() + "/photos/scanCompta" + this.selectedExo.getExecpt_id() + "/" + var2;
            this.typeFichier = 0;
         }

         this.showModalPanelPJ = true;
      }

   }

   public void fermerPj() {
      this.showModalPanelPJ = false;
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

   public void listeJournaux() throws HibernateException, NamingException {
      this.lesJournaux.clear();
      this.lesJournaux = this.journauxComptablesDao.chargerLesJournauxComptables(this.selectedExo.getExecpt_id(), 0, (Session)null);
      if (this.journal != null && !this.journal.isEmpty()) {
         this.journauxComptables = new JournauxComptables();
         if (!this.journal.contains(":")) {
            for(int var1 = 0; var1 < this.lesJournaux.size(); ++var1) {
               this.journauxComptables = (JournauxComptables)this.lesJournaux.get(var1);
               if (this.journauxComptables.getPljCode().equals(this.journal)) {
                  this.journauxComptables.setSelect(true);
               }
            }
         } else {
            String[] var5 = this.journal.split(":");
            int var2 = var5.length;

            for(int var3 = 0; var3 < var2; ++var3) {
               for(int var4 = 0; var4 < this.lesJournaux.size(); ++var4) {
                  this.journauxComptables = (JournauxComptables)this.lesJournaux.get(var4);
                  if (this.journauxComptables.getPljCode().equals(var5[var3])) {
                     this.journauxComptables.setSelect(true);
                     break;
                  }
               }
            }
         }
      }

      this.dataModelJournaux.setWrappedData(this.lesJournaux);
      this.showModalPanelJournaux = true;
   }

   public void listeNature() throws IOException {
      LectureNatureJournaux var1 = new LectureNatureJournaux();
      var1.recupereNatureJournaux();
      this.lesNatures.clear();
      this.lesNatures = var1.getMesNatureJournaux();
      if (this.natureJournal != null && !this.natureJournal.isEmpty()) {
         new ObjetCompte();
         ObjetCompte var2;
         if (!this.natureJournal.contains(":")) {
            for(int var3 = 0; var3 < this.lesNatures.size(); ++var3) {
               var2 = (ObjetCompte)this.lesNatures.get(var3);
               if (var2.getCode().equals(this.natureJournal)) {
                  var2.setValide(true);
               }
            }
         } else {
            String[] var7 = this.natureJournal.split(":");
            int var4 = var7.length;

            for(int var5 = 0; var5 < var4; ++var5) {
               for(int var6 = 0; var6 < this.lesNatures.size(); ++var6) {
                  var2 = (ObjetCompte)this.lesNatures.get(var6);
                  if (var2.getCode().equals(var7[var5])) {
                     var2.setValide(true);
                     break;
                  }
               }
            }
         }
      }

      this.dataModelNature.setWrappedData(this.lesNatures);
      this.showModalPanelNature = true;
   }

   public void fermerListeJournaux() {
      this.showModalPanelJournaux = false;
   }

   public void fermerListeNature() {
      this.showModalPanelNature = false;
   }

   public void validerListeJournaux() {
      this.journal = "";

      for(int var1 = 0; var1 < this.lesJournaux.size(); ++var1) {
         if (((JournauxComptables)this.lesJournaux.get(var1)).isSelect()) {
            if (this.journal != null && !this.journal.isEmpty()) {
               this.journal = this.journal + ":" + ((JournauxComptables)this.lesJournaux.get(var1)).getPljCode();
            } else {
               this.journal = ((JournauxComptables)this.lesJournaux.get(var1)).getPljCode();
            }
         }
      }

      this.showModalPanelJournaux = false;
   }

   public void validerListeNature() {
      this.natureJournal = "";

      for(int var1 = 0; var1 < this.lesNatures.size(); ++var1) {
         if (((ObjetCompte)this.lesNatures.get(var1)).isValide()) {
            if (this.natureJournal != null && !this.natureJournal.isEmpty()) {
               this.natureJournal = this.natureJournal + ":" + ((ObjetCompte)this.lesNatures.get(var1)).getCode();
            } else {
               this.natureJournal = ((ObjetCompte)this.lesNatures.get(var1)).getCode();
            }
         }
      }

      this.showModalPanelNature = false;
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
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_gene" + File.separator + "extrait_compte";
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
      if (var4 != null && !var4.isEmpty()) {
         if (var1 == null) {
            var1 = new UtilPrint(this.utilInitHibernate);
         }

         var1.setRapport(var4);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_gene" + File.separator + "extrait_compte" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
         var1.setEntete("Extrait de compte " + this.planComptable.getPlcCompte() + " " + this.planComptable.getPlcLibelleCpteFR());
         SimpleDateFormat var11 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);
         String var12 = var11.format(this.dateDebut);
         String var13 = var11.format(this.dateFin);
         String var14 = "";
         if (this.filtrage.equals("0")) {
            var14 = "Toutes les écritures";
         } else if (this.filtrage.equals("1")) {
            var14 = "Ecritures non lettrées";
         } else if (this.filtrage.equals("2")) {
            var14 = "Ecritures lettrées";
         } else if (this.filtrage.equals("3")) {
            var14 = "Ecritures non pointées";
         } else if (this.filtrage.equals("4")) {
            var14 = "Ecritures pointées";
         } else if (this.filtrage.equals("5")) {
            var14 = "Ecritures non lettrées et pointées";
         } else if (this.filtrage.equals("6")) {
            var14 = "Ecritures lettrées et pointées";
         }

         var1.setFiltre(var14 + " du " + var12 + " au " + var13);
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataireCC(var8);
         var1.setDestinataireCCI(var9);
         var1.setCorpsMail(var10);
         var1.setTiersSelectionne((Tiers)null);
         ArrayList var15 = new ArrayList();
         if (this.lesEcritures.size() != 0) {
            boolean var16 = false;

            int var17;
            for(var17 = 0; var17 < this.lesEcritures.size(); ++var17) {
               if (((Ecritures)this.lesEcritures.get(var17)).isSel_ecriture()) {
                  var16 = true;
                  break;
               }
            }

            if (var16) {
               for(var17 = 0; var17 < this.lesEcritures.size(); ++var17) {
                  if (((Ecritures)this.lesEcritures.get(var17)).isSel_ecriture()) {
                     this.ecritures = new Ecritures();
                     this.ecritures = (Ecritures)this.lesEcritures.get(var17);
                     var15.add(this.ecritures);
                  }
               }
            } else {
               for(var17 = 0; var17 < this.lesEcritures.size(); ++var17) {
                  this.ecritures = new Ecritures();
                  this.ecritures = (Ecritures)this.lesEcritures.get(var17);
                  var15.add(this.ecritures);
               }
            }
         }

         JRBeanCollectionDataSource var18 = new JRBeanCollectionDataSource(var15);
         var1.setjRBeanCollectionDataSource(var18);
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
      if (this.lesEcritures.size() != 0) {
         if (this.valQteGraph == 0) {
            this.uniteGraph = "COMPTE en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         }

         this.titreGraph = "Analyse du compte : " + this.planComptable.getPlcCompte() + " : " + this.planComptable.getPlcLibelleCpteFR();
         String var2 = this.utilDate.dateToStringFr(this.dateDebut);
         String var3 = this.utilDate.dateToStringFr(this.dateFin);
         this.titreGraph = this.titreGraph + " Du " + var2 + " au " + var3;
         this.sousTitreGraph = "";
         if (this.filtrage.equals("0")) {
            this.sousTitreGraph = "Toutes les ecritures";
         } else if (this.filtrage.equals("1")) {
            this.sousTitreGraph = "Ecritures non lettrees";
         } else if (this.filtrage.equals("2")) {
            this.sousTitreGraph = "Ecritures lettrees";
         } else if (this.filtrage.equals("3")) {
            this.sousTitreGraph = "Ecritures non pointees";
         } else if (this.filtrage.equals("4")) {
            this.sousTitreGraph = "Ecritures pointees";
         } else if (this.filtrage.equals("5")) {
            this.sousTitreGraph = "Ecritures non lettrees et non pointees";
         } else if (this.filtrage.equals("6")) {
            this.sousTitreGraph = "Ecritures lettrees et pointees";
         }

         if (this.modeGraph == 0) {
            this.sousTitreGraph = this.sousTitreGraph + " - En Global (" + this.uniteGraph + ")";
         }

         new Ecritures();
         if (this.valQteGraph != 1 && this.modeGraph != 5 && this.modeGraph != 6 && this.lesEcritures.size() != 0) {
            String var5 = "";
            long var6 = 0L;
            boolean var8 = false;

            for(int var9 = 0; var9 < this.lesEcritures.size(); ++var9) {
               Ecritures var4 = (Ecritures)this.lesEcritures.get(var9);
               var5 = "";
               var6 = 0L;
               int var11 = 0;
               if (this.modeGraph == 0) {
                  int var10 = var4.getEcrDateSaisie().getYear() + 1900;
                  var5 = "" + var10;
               }

               if (var4.getEcrDebitPays() == 0.0D && var4.getEcrCreditPays() != 0.0D) {
                  var6 = (long)var4.getEcrCreditPays();
               } else {
                  var6 = (long)var4.getEcrDebitPays();
               }

               if (this.timeDecoupage == 0) {
                  var11 = var4.getEcrDateSaisie().getDate();
               } else if (this.timeDecoupage == 1) {
                  var11 = var4.getEcrDateSaisie().getMonth() + 1;
               } else if (this.timeDecoupage == 2) {
                  if (var4.getEcrDateSaisie().getMonth() + 1 >= 1 && var4.getEcrDateSaisie().getMonth() + 1 <= 3) {
                     var11 = 1;
                  } else if (var4.getEcrDateSaisie().getMonth() + 1 >= 4 && var4.getEcrDateSaisie().getMonth() + 1 <= 6) {
                     var11 = 2;
                  } else if (var4.getEcrDateSaisie().getMonth() + 1 >= 7 && var4.getEcrDateSaisie().getMonth() + 1 <= 9) {
                     var11 = 3;
                  } else if (var4.getEcrDateSaisie().getMonth() + 1 >= 10 && var4.getEcrDateSaisie().getMonth() + 1 <= 12) {
                     var11 = 4;
                  }
               } else if (this.timeDecoupage == 3) {
                  if (var4.getEcrDateSaisie().getMonth() + 1 >= 1 && var4.getEcrDateSaisie().getMonth() + 1 <= 6) {
                     var11 = 1;
                  } else if (var4.getEcrDateSaisie().getMonth() + 1 >= 7 && var4.getEcrDateSaisie().getMonth() + 1 <= 12) {
                     var11 = 2;
                  }
               } else if (this.timeDecoupage == 4) {
                  var11 = 1;
               }

               var1 = this.calculeListe((List)var1, var5, var11, var6);
            }

            var1 = this.calculePourcentage((List)var1);
         }
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

   public PlanComptable getPlanComptable() {
      return this.planComptable;
   }

   public void setPlanComptable(PlanComptable var1) {
      this.planComptable = var1;
   }

   public List getLesModelsimpression() {
      return this.lesModelsimpression;
   }

   public void setLesModelsimpression(List var1) {
      this.lesModelsimpression = var1;
   }

   public Ecritures getEcritures() {
      return this.ecritures;
   }

   public void setEcritures(Ecritures var1) {
      this.ecritures = var1;
   }

   public boolean isTestdeliste() {
      return this.testdeliste;
   }

   public void setTestdeliste(boolean var1) {
      this.testdeliste = var1;
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

   public ExercicesComptable getLastExo() {
      return this.lastExo;
   }

   public void setLastExo(ExercicesComptable var1) {
      this.lastExo = var1;
   }

   public String getJournal() {
      return this.journal;
   }

   public void setJournal(String var1) {
      this.journal = var1;
   }

   public String getLettrModal() {
      return this.lettrModal;
   }

   public void setLettrModal(String var1) {
      this.lettrModal = var1;
   }

   public double getMontant() {
      return this.montant;
   }

   public void setMontant(double var1) {
      this.montant = var1;
   }

   public String getPiece() {
      return this.piece;
   }

   public void setPiece(String var1) {
      this.piece = var1;
   }

   public String getPointModal() {
      return this.pointModal;
   }

   public void setPointModal(String var1) {
      this.pointModal = var1;
   }

   public String getRef1() {
      return this.ref1;
   }

   public void setRef1(String var1) {
      this.ref1 = var1;
   }

   public String getRef2() {
      return this.ref2;
   }

   public void setRef2(String var1) {
      this.ref2 = var1;
   }

   public double getSolCredit() {
      return this.solCredit;
   }

   public void setSolCredit(double var1) {
      this.solCredit = var1;
   }

   public double getSolDebit() {
      return this.solDebit;
   }

   public void setSolDebit(double var1) {
      this.solDebit = var1;
   }

   public double getTmouvCred() {
      return this.tmouvCred;
   }

   public void setTmouvCred(double var1) {
      this.tmouvCred = var1;
   }

   public double getTmouvDeb() {
      return this.tmouvDeb;
   }

   public void setTmouvDeb(double var1) {
      this.tmouvDeb = var1;
   }

   public String getFiltrage() {
      return this.filtrage;
   }

   public void setFiltrage(String var1) {
      this.filtrage = var1;
   }

   public String getInputnum() {
      return this.inputnum;
   }

   public void setInputnum(String var1) {
      this.inputnum = var1;
   }

   public String getLibEC() {
      return this.libEC;
   }

   public void setLibEC(String var1) {
      this.libEC = var1;
   }

   public boolean isReserveRech() {
      return this.reserveRech;
   }

   public void setReserveRech(boolean var1) {
      this.reserveRech = var1;
   }

   public boolean isSituationRech() {
      return this.situationRech;
   }

   public void setSituationRech(boolean var1) {
      this.situationRech = var1;
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

   public boolean isShowModalFind() {
      return this.showModalFind;
   }

   public void setShowModalFind(boolean var1) {
      this.showModalFind = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public String getLettrage() {
      return this.lettrage;
   }

   public void setLettrage(String var1) {
      this.lettrage = var1;
   }

   public String getPointage() {
      return this.pointage;
   }

   public void setPointage(String var1) {
      this.pointage = var1;
   }

   public String getLettreCumul() {
      return this.lettreCumul;
   }

   public void setLettreCumul(String var1) {
      this.lettreCumul = var1;
   }

   public int getDelettre() {
      return this.delettre;
   }

   public void setDelettre(int var1) {
      this.delettre = var1;
   }

   public boolean isTestequilibre() {
      return this.testequilibre;
   }

   public void setTestequilibre(boolean var1) {
      this.testequilibre = var1;
   }

   public double getEcrCreditL() {
      return this.ecrCreditL;
   }

   public void setEcrCreditL(double var1) {
      this.ecrCreditL = var1;
   }

   public double getEcrCreditNL() {
      return this.ecrCreditNL;
   }

   public void setEcrCreditNL(double var1) {
      this.ecrCreditNL = var1;
   }

   public double getEcrCreditS() {
      return this.ecrCreditS;
   }

   public void setEcrCreditS(double var1) {
      this.ecrCreditS = var1;
   }

   public double getEcrDebitL() {
      return this.ecrDebitL;
   }

   public void setEcrDebitL(double var1) {
      this.ecrDebitL = var1;
   }

   public double getEcrDebitNL() {
      return this.ecrDebitNL;
   }

   public void setEcrDebitNL(double var1) {
      this.ecrDebitNL = var1;
   }

   public double getEcrDebitS() {
      return this.ecrDebitS;
   }

   public void setEcrDebitS(double var1) {
      this.ecrDebitS = var1;
   }

   public double getSoldeCreditS() {
      return this.soldeCreditS;
   }

   public void setSoldeCreditS(double var1) {
      this.soldeCreditS = var1;
   }

   public double getSoldeDebitS() {
      return this.soldeDebitS;
   }

   public void setSoldeDebitS(double var1) {
      this.soldeDebitS = var1;
   }

   public DataModel getDataModelDetailPiece() {
      return this.dataModelDetailPiece;
   }

   public void setDataModelDetailPiece(DataModel var1) {
      this.dataModelDetailPiece = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public double getVar_solde() {
      return this.var_solde;
   }

   public void setVar_solde(double var1) {
      this.var_solde = var1;
   }

   public double getVar_tot_credit() {
      return this.var_tot_credit;
   }

   public void setVar_tot_credit(double var1) {
      this.var_tot_credit = var1;
   }

   public double getVar_tot_debit() {
      return this.var_tot_debit;
   }

   public void setVar_tot_debit(double var1) {
      this.var_tot_debit = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
   }

   public String getVar_erreur_lettrage() {
      return this.var_erreur_lettrage;
   }

   public void setVar_erreur_lettrage(String var1) {
      this.var_erreur_lettrage = var1;
   }

   public List getLesEcritures() {
      return this.lesEcritures;
   }

   public void setLesEcritures(List var1) {
      this.lesEcritures = var1;
   }

   public DataModel getDataModelEcritures() {
      return this.dataModelEcritures;
   }

   public void setDataModelEcritures(DataModel var1) {
      this.dataModelEcritures = var1;
   }

   public boolean isShowModalPanelCompense() {
      return this.showModalPanelCompense;
   }

   public void setShowModalPanelCompense(boolean var1) {
      this.showModalPanelCompense = var1;
   }

   public double getVar_compense() {
      return this.var_compense;
   }

   public void setVar_compense(double var1) {
      this.var_compense = var1;
   }

   public Date getVar_date_compense() {
      return this.var_date_compense;
   }

   public void setVar_date_compense(Date var1) {
      this.var_date_compense = var1;
   }

   public String getVar_libelle_compense() {
      return this.var_libelle_compense;
   }

   public void setVar_libelle_compense(String var1) {
      this.var_libelle_compense = var1;
   }

   public String getVar_compte_compense() {
      return this.var_compte_compense;
   }

   public void setVar_compte_compense(String var1) {
      this.var_compte_compense = var1;
   }

   public boolean isShowModalpanelFiltre() {
      return this.showModalpanelFiltre;
   }

   public void setShowModalpanelFiltre(boolean var1) {
      this.showModalpanelFiltre = var1;
   }

   public Date getDateAu() {
      return this.dateAu;
   }

   public void setDateAu(Date var1) {
      this.dateAu = var1;
   }

   public Date getDateDu() {
      return this.dateDu;
   }

   public void setDateDu(Date var1) {
      this.dateDu = var1;
   }

   public int getChoixFiltre() {
      return this.choixFiltre;
   }

   public void setChoixFiltre(int var1) {
      this.choixFiltre = var1;
   }

   public int getOutilChoisi() {
      return this.outilChoisi;
   }

   public void setOutilChoisi(int var1) {
      this.outilChoisi = var1;
   }

   public boolean isTestAffOutilsCorr() {
      return this.testAffOutilsCorr;
   }

   public void setTestAffOutilsCorr(boolean var1) {
      this.testAffOutilsCorr = var1;
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

   public boolean isVar_affiche_analytique() {
      return this.var_affiche_analytique;
   }

   public void setVar_affiche_analytique(boolean var1) {
      this.var_affiche_analytique = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public String getAnalytique() {
      return this.analytique;
   }

   public void setAnalytique(String var1) {
      this.analytique = var1;
   }

   public String getMessageAlerte() {
      return this.messageAlerte;
   }

   public void setMessageAlerte(String var1) {
      this.messageAlerte = var1;
   }

   public boolean isAffichageAccesJr() {
      return this.affichageAccesJr;
   }

   public void setAffichageAccesJr(boolean var1) {
      this.affichageAccesJr = var1;
   }

   public String getDossier() {
      return this.dossier;
   }

   public void setDossier(String var1) {
      this.dossier = var1;
   }

   public boolean isVar_solde_ante() {
      return this.var_solde_ante;
   }

   public void setVar_solde_ante(boolean var1) {
      this.var_solde_ante = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isShowModalPanelModifPiece() {
      return this.showModalPanelModifPiece;
   }

   public void setShowModalPanelModifPiece(boolean var1) {
      this.showModalPanelModifPiece = var1;
   }

   public boolean isShowModalPanelDelettrage() {
      return this.showModalPanelDelettrage;
   }

   public void setShowModalPanelDelettrage(boolean var1) {
      this.showModalPanelDelettrage = var1;
   }

   public boolean isShowModalPanelLettrage() {
      return this.showModalPanelLettrage;
   }

   public void setShowModalPanelLettrage(boolean var1) {
      this.showModalPanelLettrage = var1;
   }

   public boolean isShowModalPanelPointage() {
      return this.showModalPanelPointage;
   }

   public void setShowModalPanelPointage(boolean var1) {
      this.showModalPanelPointage = var1;
   }

   public Ecritures getEcrituresDetail() {
      return this.ecrituresDetail;
   }

   public void setEcrituresDetail(Ecritures var1) {
      this.ecrituresDetail = var1;
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

   public DataModel getDataModelEcritureAReimputer() {
      return this.dataModelEcritureAReimputer;
   }

   public void setDataModelEcritureAReimputer(DataModel var1) {
      this.dataModelEcritureAReimputer = var1;
   }

   public boolean isShowModalPanelCorrection() {
      return this.showModalPanelCorrection;
   }

   public void setShowModalPanelCorrection(boolean var1) {
      this.showModalPanelCorrection = var1;
   }

   public boolean isShowModalPanelAnalytique() {
      return this.showModalPanelAnalytique;
   }

   public void setShowModalPanelAnalytique(boolean var1) {
      this.showModalPanelAnalytique = var1;
   }

   public FormAnalytique getFormAnalytique() {
      return this.formAnalytique;
   }

   public void setFormAnalytique(FormAnalytique var1) {
      this.formAnalytique = var1;
   }

   public boolean isShowModalPanelAnalytiqueCorrection() {
      return this.showModalPanelAnalytiqueCorrection;
   }

   public void setShowModalPanelAnalytiqueCorrection(boolean var1) {
      this.showModalPanelAnalytiqueCorrection = var1;
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

   public int getTypeFichier() {
      return this.typeFichier;
   }

   public void setTypeFichier(int var1) {
      this.typeFichier = var1;
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

   public boolean isForceVerrou() {
      return this.forceVerrou;
   }

   public void setForceVerrou(boolean var1) {
      this.forceVerrou = var1;
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

   public DataModel getDataModelJournaux() {
      return this.dataModelJournaux;
   }

   public void setDataModelJournaux(DataModel var1) {
      this.dataModelJournaux = var1;
   }

   public DataModel getDataModelNature() {
      return this.dataModelNature;
   }

   public void setDataModelNature(DataModel var1) {
      this.dataModelNature = var1;
   }

   public String getNatureJournal() {
      return this.natureJournal;
   }

   public void setNatureJournal(String var1) {
      this.natureJournal = var1;
   }

   public boolean isShowModalPanelJournaux() {
      return this.showModalPanelJournaux;
   }

   public void setShowModalPanelJournaux(boolean var1) {
      this.showModalPanelJournaux = var1;
   }

   public boolean isShowModalPanelNature() {
      return this.showModalPanelNature;
   }

   public void setShowModalPanelNature(boolean var1) {
      this.showModalPanelNature = var1;
   }
}
