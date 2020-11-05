package com.epegase.forms.comptabilite;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Activites;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresAnalytique;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.control.ObjetTable;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.EcrituresAnalytiquesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.ExercicesPayeDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LectureNatureJournaux;
import com.epegase.systeme.xml.ObjetCompte;
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

public class FormExtraitClasse implements Serializable {
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
   private String messageAlerte;
   private Ecritures ecritures;
   private EcrituresDao ecrituresDao;
   private transient DataModel dataModelEcritures = new ListDataModel();
   private List lesEcritures = new ArrayList();
   private String classe;
   private String analytique;
   private String dossier;
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
   private double soldEL = 0.0D;
   private double soldENL = 0.0D;
   private double soldTE = 0.0D;
   private boolean testdeliste = true;
   private boolean testdelettre = true;
   private boolean testequilibre = false;
   private boolean var_affiche_bouton = false;
   private int choix_compte;
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
   private String natureJournal = "";
   private boolean situationRech = false;
   private boolean reserveRech = false;
   private PlanComptableDao planComptableDao;
   private PlanComptable planComptable = new PlanComptable();
   private boolean forceVerrou;
   private boolean testAffOutilsCorr = false;
   private int outilChoisi;
   private String toolsCompteOld;
   private List lesEcrituresAReimputer;
   private transient DataModel dataModelEcritureAReimputer;
   private boolean showModalPanelCorrection = false;
   private boolean showModalPanelAnalytiqueCorrection = false;
   private UtilNombre utilNombre;
   private boolean var_consult_analytique = false;
   private transient DataModel dataModelDetAnalytique = new ListDataModel();
   private PlansAnalytiques plansAnalytiques;
   private Salaries salaries;
   private EcrituresAnalytique ecrituresAnalytique;
   private EcrituresAnalytiquesDao ecrituresAnalytiquesDao;
   private boolean showModalPanelAnalytique = false;
   private boolean showModalPanelAnalRecup = false;
   private boolean showModalPanelParc = false;
   private boolean showModalPanelDossier = false;
   private int var_nature_analytique;
   private List mesClesItems = new ArrayList();
   private String var_cle_analytique;
   private List listeRepartitionAnal = new ArrayList();
   private boolean var_affiche_saisie_anal = false;
   private boolean var_sens_analytique = false;
   private boolean affiche_activite = false;
   private boolean affiche_site = false;
   private boolean affiche_departement = false;
   private boolean affiche_service = false;
   private boolean affiche_region = false;
   private boolean affiche_secteur = false;
   private boolean affiche_pdv = false;
   private boolean affiche_sitePrdv = false;
   private boolean affiche_ligne = false;
   private boolean affiche_atelier = false;
   private boolean affiche_anal1 = false;
   private boolean affiche_anal2 = false;
   private boolean affiche_anal3 = false;
   private boolean affiche_anal4 = false;
   private double var_montant_ligne;
   private double var_montant_impute;
   private double var_ecart;
   private boolean var_valide_analytique = false;
   private long var_memo_ligne_gene;
   private List listeOngletAnalytique = new ArrayList();
   private ObjetTable objetTable = new ObjetTable();
   private List mesOngletsAnalytiqueItems = new ArrayList();
   private int var_axe;
   private transient DataModel dataModelParc = new ListDataModel();
   private transient DataModel dataModelDossier = new ListDataModel();
   private transient DataModel dataModelAgent = new ListDataModel();
   private transient DataModel dataModelActivite = new ListDataModel();
   private boolean showModalPanelActivite = false;
   private Activites activites;
   private boolean decoupageActivite = false;
   private List laColonne1Items = new ArrayList();
   private List laColonne2Items = new ArrayList();
   private List laColonne3Items = new ArrayList();
   private String pointModal = "";
   private String lettrModal = "";
   private String lettreCumul = "";
   private int delettre = 0;
   private transient DataModel dataModelDetailPiece = new ListDataModel();
   private double var_tot_debit;
   private double var_tot_credit;
   private double var_solde;
   private boolean showModalPanelModifPiece = false;
   private Ecritures ecrituresDetail;
   private List listDetail = new ArrayList();
   private List lesModelsimpression = new ArrayList();
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
   private List lesModelesAutorises;
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

   public void trouverCompte() {
      this.showModalFind = true;
   }

   public void annuleRecherche() {
      this.showModalFind = false;
   }

   public void chargerEcritures() throws ParseException, HibernateException, NamingException {
      this.chargerEcritures((Session)null);
   }

   public void chargerEcritures(Session var1) throws ParseException, HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         var2 = true;
      }

      String var3 = "";
      if (this.analytique != null && !this.analytique.isEmpty()) {
         (new StringBuilder()).append(" Analytique ").append(this.analytique).toString();
      }

      String var4 = "";
      if (this.dossier != null && !this.dossier.isEmpty()) {
         (new StringBuilder()).append(" Dossier ").append(this.dossier).toString();
      }

      this.periode = "PERIODE du " + this.utilDate.dateToStringFr(this.dateDebut) + " au " + this.utilDate.dateToStringFr(this.dateFin);
      this.lesEcritures = new ArrayList();
      this.dataModelEcritures = new ListDataModel();
      String var5 = this.utilDate.dateToStringSQLLight(this.dateDebut);
      Date var6 = this.utilDate.stringToDateSQLLight(var5);
      String var7 = this.utilDate.dateToStringSQLLight(this.dateFin);
      Date var8 = this.utilDate.stringToDateSQLLight(var7);
      ArrayList var9 = new ArrayList();
      int var11;
      if (this.journal != null && !this.journal.isEmpty()) {
         if (!this.journal.contains(":")) {
            var9.add(this.journal);
         } else {
            String[] var10 = this.journal.split(":");

            for(var11 = 0; var11 < var10.length; ++var11) {
               String var12 = var10[var11];
               var9.add(var12);
            }
         }
      }

      ArrayList var28 = new ArrayList();
      int var13;
      int var30;
      if (this.natureJournal != null && !this.natureJournal.isEmpty()) {
         if (!this.natureJournal.contains(":")) {
            var28.add(Integer.parseInt(this.natureJournal));
         } else {
            String[] var29 = this.natureJournal.split(":");

            for(var30 = 0; var30 < var29.length; ++var30) {
               var13 = Integer.parseInt(var29[var30]);
               var28.add(var13);
            }
         }
      }

      if (this.optionComptabilite.getTri_extrait() == null || this.optionComptabilite.getTri_extrait().isEmpty() || this.optionComptabilite.getTri_extrait().equals("piece")) {
         this.optionComptabilite.setTri_extrait("0");
      }

      var11 = Integer.parseInt(this.optionComptabilite.getTri_extrait());
      Ecritures var15;
      int var16;
      List var31;
      ArrayList var32;
      if (this.dateFin.equals(this.selectedExo.getExecptDateFin())) {
         this.lesEcritures = this.ecrituresDao.chargerExtraitClasse(var6, var8, this.inputnum, this.situationRech, this.reserveRech, this.filtrage, this.libEC, this.lettrage, this.pointage, this.ref1, this.ref2, var9, var28, this.piece, this.montant, this.usersLog.getUsrCptInterdit(), this.usersLog.getUsrJrxInterdit(), var11, var1);
         if (this.lesEcritures.size() != 0) {
            for(var30 = 0; var30 < this.lesEcritures.size(); ++var30) {
               this.ecritures = (Ecritures)this.lesEcritures.get(var30);
               if (this.ecritures.getEcrAnaActif() == 0) {
                  this.ecritures.setErreurAnalytique(this.testCompteAnalytique(this.ecritures));
               } else {
                  this.ecritures.setErreurAnalytique(false);
               }
            }
         }
      } else {
         var32 = new ArrayList();
         new ArrayList();
         ArrayList var14 = new ArrayList();
         var31 = this.ecrituresDao.chargerExtraitClasse(var6, var8, this.inputnum, this.situationRech, this.reserveRech, "0", this.libEC, this.lettrage, this.pointage, this.ref1, this.ref2, var9, var28, this.piece, this.montant, this.usersLog.getUsrCptInterdit(), this.usersLog.getUsrJrxInterdit(), var11, var1);
         if (var31.size() != 0) {
            new Ecritures();

            for(var16 = 0; var16 < var31.size(); ++var16) {
               var15 = (Ecritures)var31.get(var16);
               if (var15.getEcrAnaActif() == 0) {
                  var15.setErreurAnalytique(this.testCompteAnalytique(var15));
               } else {
                  var15.setErreurAnalytique(false);
               }

               if (var15.getEcrCompte() != null && !var15.getEcrCompte().isEmpty()) {
                  if (var32.size() == 0) {
                     var32.add(var15.getEcrCompte());
                  } else {
                     boolean var17 = false;

                     for(int var18 = 0; var18 < var32.size(); ++var18) {
                        if (((String)var32.get(var18)).equals(var15.getEcrCompte())) {
                           var17 = true;
                           break;
                        }
                     }

                     if (!var17) {
                        var32.add(var15.getEcrCompte());
                     }
                  }
               }
            }

            for(var16 = 0; var16 < var32.size(); ++var16) {
               String var36 = ((String)var32.get(var16)).toString();
               var14.clear();
               new Ecritures();
               int var19 = 0;

               int var22;
               Ecritures var38;
               for(int var20 = 0; var20 < var31.size(); ++var20) {
                  var38 = (Ecritures)var31.get(var20);
                  if (var38.getEcrCompte() != null && var38.getEcrCompte().equals(var36)) {
                     ++var19;
                     if (var38.getEcrLettrage() != null && !var38.getEcrLettrage().isEmpty()) {
                        if (var14.size() == 0) {
                           var14.add(var38.getEcrLettrage());
                        } else {
                           boolean var21 = false;

                           for(var22 = 0; var22 < var14.size(); ++var22) {
                              if (((String)var14.get(var22)).equals(var38.getEcrLettrage())) {
                                 var21 = true;
                                 break;
                              }
                           }

                           if (!var21) {
                              var14.add(var38.getEcrLettrage());
                           }
                        }
                     }
                  }
               }

               String var40 = "";
               new Ecritures();

               for(var22 = 0; var22 < var14.size(); ++var22) {
                  var40 = ((String)var14.get(var22)).toString();
                  double var23 = 0.0D;
                  double var25 = 0.0D;

                  int var27;
                  Ecritures var41;
                  for(var27 = 0; var27 < var31.size(); ++var27) {
                     var41 = (Ecritures)var31.get(var27);
                     if (var41.getEcrCompte() != null && var41.getEcrCompte().equals(var36) && var41.getEcrLettrage() != null && !var41.getEcrLettrage().isEmpty() && var41.getEcrLettrage().equals(var40)) {
                        var23 += var41.getEcrDebitPays();
                        var25 += var41.getEcrCreditPays();
                     }
                  }

                  if (var23 != var25) {
                     for(var27 = 0; var27 < var31.size(); ++var27) {
                        var41 = (Ecritures)var31.get(var27);
                        if (var41.getEcrCompte() != null && var41.getEcrCompte().equals(var36) && var41.getEcrLettrage() != null && !var41.getEcrLettrage().isEmpty() && var41.getEcrLettrage().equals(var40)) {
                           var41.setEcrPointage("L:" + var41.getEcrLettrage());
                           var41.setEcrLettrage((String)null);
                        }
                     }
                  }
               }

               this.lesEcritures.clear();

               for(var22 = 0; var22 < var31.size(); ++var22) {
                  var38 = (Ecritures)var31.get(var22);
                  if (this.filtrage.equals("0")) {
                     this.lesEcritures.add(var38);
                  } else if (this.filtrage.equals("1")) {
                     if (var38.getEcrLettrage() == null || var38.getEcrLettrage().isEmpty()) {
                        this.lesEcritures.add(var38);
                     }
                  } else if (this.filtrage.equals("2")) {
                     if (var38.getEcrLettrage() != null && !var38.getEcrLettrage().isEmpty()) {
                        this.lesEcritures.add(var38);
                     }
                  } else if (this.filtrage.equals("3")) {
                     if (var38.getEcrPointage() == null || var38.getEcrPointage().isEmpty()) {
                        this.lesEcritures.add(var38);
                     }
                  } else if (this.filtrage.equals("4")) {
                     if (var38.getEcrPointage() != null && !var38.getEcrPointage().isEmpty()) {
                        this.lesEcritures.add(var38);
                     }
                  } else if (this.filtrage.equals("5")) {
                     if ((var38.getEcrLettrage() == null || var38.getEcrLettrage().isEmpty()) && (var38.getEcrPointage() == null || var38.getEcrPointage().isEmpty())) {
                        this.lesEcritures.add(var38);
                     }
                  } else if (this.filtrage.equals("6") && var38.getEcrLettrage() != null && !var38.getEcrLettrage().isEmpty() && var38.getEcrPointage() != null && !var38.getEcrPointage().isEmpty()) {
                     this.lesEcritures.add(var38);
                  }
               }
            }
         }
      }

      var32 = new ArrayList();
      int var33;
      if (this.lesEcritures.size() != 0 && (this.analytique != null && !this.analytique.isEmpty() || this.dossier != null && !this.dossier.isEmpty())) {
         this.ecrituresAnalytiquesDao = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();

         for(var33 = 0; var33 < this.lesEcritures.size(); ++var33) {
            new Ecritures();
            var15 = (Ecritures)this.lesEcritures.get(var33);
            var31 = this.ecrituresAnalytiquesDao.chargerLesEcrituresAnalytiques(var15, var1);
            if (var31.size() != 0) {
               for(var16 = 0; var16 < var31.size(); ++var16) {
                  new EcrituresAnalytique();
                  EcrituresAnalytique var37 = (EcrituresAnalytique)var31.get(var16);
                  if (this.analytique != null && !this.analytique.isEmpty() && (var37.getEcranaActivite() != null && var37.getEcranaActivite().startsWith(this.analytique) || var37.getEcranaAnal1() != null && var37.getEcranaAnal1().startsWith(this.analytique) || var37.getEcranaAnal2() != null && var37.getEcranaAnal2().startsWith(this.analytique) || var37.getEcranaAnal3() != null && var37.getEcranaAnal3().startsWith(this.analytique) || var37.getEcranaAtelier() != null && var37.getEcranaAtelier().startsWith(this.analytique) || var37.getEcranaDepartement() != null && var37.getEcranaDepartement().startsWith(this.analytique) || var37.getEcranaLigne() != null && var37.getEcranaLigne().startsWith(this.analytique) || var37.getEcranaPdv() != null && var37.getEcranaPdv().startsWith(this.analytique) || var37.getEcranaRegion() != null && var37.getEcranaRegion().startsWith(this.analytique) || var37.getEcranaSecteur() != null && var37.getEcranaSecteur().startsWith(this.analytique) || var37.getEcranaService() != null && var37.getEcranaService().startsWith(this.analytique) || var37.getEcranaSite() != null && var37.getEcranaSite().startsWith(this.analytique))) {
                     var32.add(var15);
                     break;
                  }

                  if (this.dossier != null && !this.dossier.isEmpty() && var37.getEcranaAnal4() != null && var37.getEcranaAnal4().startsWith(this.dossier)) {
                     var32.add(var15);
                     break;
                  }
               }
            }
         }
      } else {
         for(var13 = 0; var13 < this.lesEcritures.size(); ++var13) {
            var32.add(this.lesEcritures.get(var13));
         }

         this.lesEcritures.clear();
      }

      if (var32.size() != 0) {
         if (this.optionComptabilite.getAnalytiqueErreur().equals("1")) {
            Object var34 = new ArrayList();

            for(var33 = 0; var33 < var32.size(); ++var33) {
               this.ecritures = (Ecritures)var32.get(var33);
               if (this.optionComptabilite.getAnalytique().equals("true") && this.ecritures.getEcrAnaActif() == 1) {
                  ((List)var34).clear();
                  var34 = this.ecrituresAnalytiquesDao.chargerLesEcrituresAnalytiques(this.ecritures, var1);
                  if (((List)var34).size() == 0) {
                     this.ecritures.setErreurAnalytique(true);
                  } else {
                     double var35 = 0.0D;

                     for(int var39 = 0; var39 < ((List)var34).size(); ++var39) {
                        var35 += ((EcrituresAnalytique)((List)var34).get(var39)).getEcranaMontantSaisie();
                     }

                     if (var35 != this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) {
                        if (var35 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 2.0D) {
                           if (var35 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 3.0D) {
                              if (var35 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 4.0D) {
                                 if (var35 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 5.0D) {
                                    if (var35 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 6.0D) {
                                       if (var35 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 7.0D) {
                                          if (var35 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 8.0D) {
                                             if (var35 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 9.0D) {
                                                if (var35 != (this.ecritures.getEcrDebitSaisie() + this.ecritures.getEcrCreditSaisie()) * 10.0D) {
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
            for(var13 = 0; var13 < var32.size(); ++var13) {
               this.lesEcritures.add(var32.get(var13));
            }
         }
      }

      this.dataModelEcritures.setWrappedData(this.lesEcritures);
      this.showModalFind = false;
      this.calculerTotaux();
      this.var_affiche_bouton = false;
   }

   public void calculerTotaux() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      this.testdeliste = true;
      if (this.lesEcritures.size() != 0) {
         this.testdeliste = false;

         for(int var9 = 0; var9 < this.lesEcritures.size(); ++var9) {
            Ecritures var10 = (Ecritures)this.lesEcritures.get(var9);
            var1 += var10.getEcrDebitPays();
            var3 += var10.getEcrCreditPays();
            if (var10.getEcrLettrage() != null && !var10.getEcrLettrage().isEmpty()) {
               var5 += var10.getEcrDebitPays();
               var7 += var10.getEcrCreditPays();
            }
         }
      }

      this.tmouvCred = var3;
      this.tmouvDeb = var1;
      if (this.tmouvDeb > this.tmouvCred) {
         this.solDebit = this.tmouvDeb - this.tmouvCred;
         this.solCredit = 0.0D;
      } else {
         this.solCredit = this.tmouvCred - this.tmouvDeb;
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
      this.soldEL = 0.0D;
      this.soldENL = 0.0D;
      this.soldTE = 0.0D;
   }

   public void toutDeSelectionner() {
      if (this.lesEcritures.size() != 0) {
         new Ecritures();

         for(int var2 = 0; var2 < this.lesEcritures.size(); ++var2) {
            Ecritures var1 = (Ecritures)this.lesEcritures.get(var2);
            var1.setSel_ecriture(false);
         }

         this.dataModelEcritures.setWrappedData(this.lesEcritures);
         this.calculTotalSelectionCochee();
      }

   }

   public void toutSelectionner() {
      if (this.lesEcritures.size() != 0) {
         new Ecritures();

         for(int var2 = 0; var2 < this.lesEcritures.size(); ++var2) {
            Ecritures var1 = (Ecritures)this.lesEcritures.get(var2);
            var1.setSel_ecriture(true);
         }

         this.dataModelEcritures.setWrappedData(this.lesEcritures);
         this.calculTotalSelectionCochee();
      }

   }

   public void selectionEcriture() {
      if (this.dataModelEcritures.isRowAvailable()) {
         this.ecritures = (Ecritures)this.dataModelEcritures.getRowData();
         this.var_affiche_bouton = true;
      }

   }

   public void calculTotalSelectionCochee() {
      this.ecrDebitL = 0.0D;
      this.ecrDebitNL = 0.0D;
      this.ecrDebitS = 0.0D;
      this.ecrCreditL = 0.0D;
      this.ecrCreditNL = 0.0D;
      this.ecrCreditS = 0.0D;
      this.soldeDebitS = 0.0D;
      this.soldeCreditS = 0.0D;
      this.soldEL = 0.0D;
      this.soldENL = 0.0D;
      this.soldTE = 0.0D;
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = 0.0D;
      double var11 = 0.0D;
      this.lettreCumul = "";
      this.testdelettre = true;
      if (this.lesEcritures.size() != 0) {
         new Ecritures();

         for(int var14 = 0; var14 < this.lesEcritures.size(); ++var14) {
            Ecritures var13 = (Ecritures)this.lesEcritures.get(var14);
            if (var13.isSel_ecriture()) {
               if (var13.getEcrLettrage() != null && !var13.getEcrLettrage().isEmpty()) {
                  this.lettreCumul = var13.getEcrLettrage();
                  this.testdelettre = false;
                  var1 += var13.getEcrDebitSaisie();
                  var3 += var13.getEcrCreditSaisie();
               } else {
                  var5 += var13.getEcrDebitSaisie();
                  var7 += var13.getEcrCreditSaisie();
               }

               var9 += var13.getEcrDebitSaisie();
               var11 += var13.getEcrCreditSaisie();
            }
         }
      }

      this.ecrDebitL = var1;
      this.ecrCreditL = var3;
      this.ecrDebitNL = var5;
      this.ecrCreditNL = var7;
      this.ecrDebitS = var9;
      this.ecrCreditS = var11;
      if (this.ecrDebitS > this.ecrCreditS) {
         this.soldeDebitS = this.ecrDebitS - this.ecrCreditS;
         this.soldeCreditS = 0.0D;
      } else {
         this.soldeDebitS = 0.0D;
         this.soldeCreditS = this.ecrCreditS - this.ecrDebitS;
      }

      this.soldEL = var1 - var3;
      this.soldENL = var5 - var7;
      this.soldTE = this.soldEL + this.soldENL;
   }

   public void deLettrerSelection() throws HibernateException, NamingException {
      if (this.lesEcritures.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.ecritures = new Ecritures();
            int var3;
            if (this.delettre == 0) {
               for(var3 = 0; var3 < this.lesEcritures.size(); ++var3) {
                  this.ecritures = (Ecritures)this.lesEcritures.get(var3);
                  if (this.ecritures.isSel_ecriture() && this.ecritures.getEcrLettrage() != null && !this.ecritures.getEcrLettrage().isEmpty() && this.ecritures.getEcrLettrage().equalsIgnoreCase(this.lettreCumul)) {
                     this.ecritures.setEcrLettrage("");
                     this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
                  }
               }
            } else if (this.delettre == 1) {
               for(var3 = 0; var3 < this.lesEcritures.size(); ++var3) {
                  this.ecritures = (Ecritures)this.lesEcritures.get(var3);
                  if (this.ecritures.getEcrLettrage() != null && !this.ecritures.getEcrLettrage().isEmpty() && this.ecritures.getEcrLettrage().equalsIgnoreCase(this.lettreCumul)) {
                     this.ecritures.setEcrLettrage("");
                     this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
                  }
               }
            } else if (this.delettre == 2) {
               for(var3 = 0; var3 < this.lesEcritures.size(); ++var3) {
                  this.ecritures = (Ecritures)this.lesEcritures.get(var3);
                  if (this.ecritures.getEcrLettrage() != null && !this.ecritures.getEcrLettrage().isEmpty()) {
                     this.ecritures.setEcrLettrage("");
                     this.ecritures = this.ecrituresDao.modif(this.ecritures, var1);
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

         this.calculTotalSelectionCochee();
      }

   }

   public void visualisationPiece() throws HibernateException, NamingException {
      if (this.ecritures != null && this.ecritures.getEcrPiece() != null && !this.ecritures.getEcrPiece().isEmpty()) {
         this.listDetail.clear();
         this.listDetail = this.ecrituresDao.selectPiece(this.ecritures.getEcrCode(), this.ecritures.getEcrPiece(), this.ecritures.getEcrPeriode());
         if (this.listDetail.size() != 0) {
            this.var_tot_debit = 0.0D;
            this.var_tot_credit = 0.0D;
            this.var_solde = 0.0D;

            for(int var1 = 0; var1 < this.listDetail.size(); ++var1) {
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
         this.showModalPanelModifPiece = true;
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

   public void gestionAnalytique() throws ParseException, HibernateException, NamingException {
      this.ecritures = null;
      if (this.dataModelEcritures.isRowAvailable()) {
         this.ecritures = (Ecritures)this.dataModelEcritures.getRowData();
      }

      if (this.ecritures != null) {
         this.var_memo_ligne_gene = this.ecritures.getEcr_id();
         if (this.ecritures.getEcrDebitSaisie() != 0.0D && this.ecritures.getEcrCreditSaisie() == 0.0D) {
            this.var_sens_analytique = false;
            this.var_montant_ligne = Math.abs(this.ecritures.getEcrDebitSaisie());
         } else {
            this.var_sens_analytique = true;
            this.var_montant_ligne = Math.abs(this.ecritures.getEcrCreditSaisie());
         }

         if (this.optionComptabilite.getAnalytique().equals("true") && this.ecritures.getEcrEtat() == 0) {
            boolean var1 = this.testCompteAnalytique(this.ecritures);
            if (var1) {
               boolean var2 = this.ecrituresAnalytiquesDao.exsitLesEcrituresAnalytiques(this.ecritures, (Session)null);
               if (var2) {
                  if (this.ecritures.getEcrAnaActif() == 0) {
                     this.ecritures.setEcrAnaActif(1);
                     this.ecritures = this.ecrituresDao.modif(this.ecritures);
                  }

                  this.ouvrirDetailsAnalytique();
                  this.var_consult_analytique = false;
                  this.var_valide_analytique = false;
               } else {
                  this.objetTable = new ObjetTable();
                  this.listeOngletAnalytique = new ArrayList();
                  this.mesOngletsAnalytiqueItems = new ArrayList();
                  this.mesOngletsAnalytiqueItems.add(new SelectItem(0, "Nouvel axe"));
                  this.var_nature_analytique = 0;
                  this.var_cle_analytique = "0";
                  this.var_montant_impute = 0.0D;
                  this.var_affiche_saisie_anal = false;
                  this.var_valide_analytique = false;
                  this.ecrituresAnalytique = new EcrituresAnalytique();
                  this.plansAnalytiques = new PlansAnalytiques();
                  this.var_consult_analytique = false;
                  this.showModalPanelAnalytique = true;
                  this.affiche_activite = false;
                  this.affiche_site = false;
                  this.affiche_departement = false;
                  this.affiche_service = false;
                  this.affiche_region = false;
                  this.affiche_secteur = false;
                  this.affiche_pdv = false;
                  this.affiche_sitePrdv = false;
                  this.affiche_ligne = false;
                  this.affiche_atelier = false;
                  this.affiche_anal1 = false;
                  this.affiche_anal2 = false;
                  this.affiche_anal3 = false;
                  this.affiche_anal4 = false;
                  this.listeOngletAnalytique.clear();
                  this.mesOngletsAnalytiqueItems.clear();
                  this.listeRepartitionAnal.clear();
                  this.dataModelDetAnalytique.setWrappedData(this.listeRepartitionAnal);
               }
            }
         }

         this.var_memo_action = this.var_action;
         this.var_action = 16;
      }

   }

   public void ouvrirDetailsAnalytique() throws HibernateException, NamingException, ParseException {
      if (this.ecritures != null && this.ecritures.getEcrAnaActif() == 1) {
         this.affiche_activite = false;
         this.affiche_site = false;
         this.affiche_departement = false;
         this.affiche_service = false;
         this.affiche_region = false;
         this.affiche_secteur = false;
         this.affiche_pdv = false;
         this.affiche_sitePrdv = false;
         this.affiche_ligne = false;
         this.affiche_atelier = false;
         this.affiche_anal1 = false;
         this.affiche_anal2 = false;
         this.affiche_anal3 = false;
         this.affiche_anal4 = false;
         this.listeOngletAnalytique.clear();
         this.mesOngletsAnalytiqueItems.clear();
         this.listeRepartitionAnal.clear();
         byte var1 = 0;
         int var2 = 0;
         this.dataModelDetAnalytique.setWrappedData(this.listeRepartitionAnal);
         new ArrayList();
         List var3 = this.ecrituresAnalytiquesDao.chargerLesEcrituresAnalytiques(this.ecritures, (Session)null);
         if (var3.size() != 0) {
            int var4;
            String var5;
            EcrituresAnalytique var6;
            int var7;
            int var8;
            String var9;
            String var10;
            String var11;
            EcrituresAnalytique var12;
            int var13;
            EcrituresAnalytiqueCtrl var14;
            ArrayList var15;
            if (((EcrituresAnalytique)var3.get(0)).getEcranaAxe() != 0 && ((EcrituresAnalytique)var3.get(0)).getEcranaCle() != null && !((EcrituresAnalytique)var3.get(0)).getEcranaCle().isEmpty()) {
               var4 = 0;
               var5 = "";
               new EcrituresAnalytique();
               var7 = 0;

               while(true) {
                  if (var7 >= var3.size()) {
                     if (this.mesOngletsAnalytiqueItems.size() != 0) {
                        this.mesOngletsAnalytiqueItems.get(0);
                        this.listeOngletAnalytique.get(0);
                        this.var_axe = this.objetTable.getIndice();
                        this.chargerAxe();
                        if (this.listeRepartitionAnal.size() != 0) {
                           this.ecrituresAnalytique = (EcrituresAnalytique)this.listeRepartitionAnal.get(0);
                           this.afficheColonne();
                        }

                        if (this.ecrituresAnalytique.getEcranaAxe() <= 90) {
                           this.miseEnFormeCle();
                        }
                     }
                     break;
                  }

                  var6 = (EcrituresAnalytique)var3.get(var7);
                  var8 = var6.getEcranaAxe();
                  var9 = var6.getEcranaCle();
                  if (var8 != var4 || !var9.equals(var5)) {
                     var1 = 1;
                     ++var2;
                     var4 = var6.getEcranaAxe();
                     var5 = var6.getEcranaCle();
                     var10 = this.calculeAxe(var4);
                     if (var5 != null && !var5.isEmpty()) {
                        var11 = var10 + ":" + var5;
                        this.mesOngletsAnalytiqueItems.add(new SelectItem(var2, var11));
                     } else {
                        this.mesOngletsAnalytiqueItems.add(new SelectItem(var2, var10));
                     }

                     this.objetTable = new ObjetTable();
                     this.objetTable.setIndice(var2);
                     this.objetTable.setNature(var4);
                     this.objetTable.setColumn_comment(var10);
                     this.objetTable.setColumn_name(var5);
                     var15 = new ArrayList();
                     new EcrituresAnalytique();

                     for(var13 = 0; var13 < var3.size(); ++var13) {
                        var12 = (EcrituresAnalytique)var3.get(var13);
                        if (var4 == var12.getEcranaAxe() && var5.equals(var12.getEcranaCle())) {
                           var14 = new EcrituresAnalytiqueCtrl();
                           var14.setEcranaAxe(var12.getEcranaAxe());
                           var14.setEcranaCle(var12.getEcranaCle());
                           var14.setEcranaMontantSaisie(var12.getEcranaMontantSaisie());
                           var14.setEcranaPourcentage(var12.getEcranaPourcentage());
                           var14.setEcranaActivite(var12.getEcranaActivite());
                           var14.setEcranaActiviteLib(var12.getEcranaActiviteLib());
                           var14.setZoneActivite(var6.getEcranaActivite() + ":" + var6.getEcranaActiviteLib());
                           var14.setEcranaAnal1(var12.getEcranaAnal1());
                           var14.setEcranaAnal1Lib(var12.getEcranaAnal1Lib());
                           var14.setZoneAnal1(var6.getEcranaAnal1() + ":" + var6.getEcranaAnal1Lib());
                           var14.setEcranaAnal2(var12.getEcranaAnal2());
                           var14.setEcranaAnal2Lib(var12.getEcranaAnal2Lib());
                           var14.setEcranaAnal3(var12.getEcranaAnal3());
                           var14.setEcranaAnal3Lib(var12.getEcranaAnal3Lib());
                           var14.setZoneAnal3(var6.getEcranaAnal3() + ":" + var6.getEcranaAnal3Lib());
                           var14.setEcranaAnal4(var12.getEcranaAnal4());
                           var14.setEcranaAnal4Lib(var12.getEcranaAnal4Lib());
                           var14.setEcranaSite(var12.getEcranaSite());
                           var14.setEcranaSiteLib(var12.getEcranaSiteLib());
                           var14.setEcranaDepartement(var12.getEcranaDepartement());
                           var14.setEcranaDepartementLib(var12.getEcranaDepartementLib());
                           var14.setEcranaService(var12.getEcranaService());
                           var14.setEcranaServiceLib(var12.getEcranaServiceLib());
                           var14.setEcranaLigne(var12.getEcranaLigne());
                           var14.setEcranaLigneLib(var12.getEcranaLigneLib());
                           var14.setEcranaAtelier(var12.getEcranaAtelier());
                           var14.setEcranaAtelierLib(var12.getEcranaAtelierLib());
                           var14.setEcranaRegion(var12.getEcranaRegion());
                           var14.setEcranaRegionLib(var12.getEcranaRegion());
                           var14.setEcranaSecteur(var12.getEcranaSecteur());
                           var14.setEcranaSecteurLib(var12.getEcranaSecteurLib());
                           var14.setEcranaPdv(var12.getEcranaPdv());
                           var14.setEcranaPdvLib(var12.getEcranaPdvLib());
                           var15.add(var14);
                        }
                     }

                     this.objetTable.setListEcrituresAnalytiqueCtrl(var15);
                     this.listeOngletAnalytique.add(this.objetTable);
                  }

                  ++var7;
               }
            } else if (((EcrituresAnalytique)var3.get(0)).getEcranaAxe() == 0 || ((EcrituresAnalytique)var3.get(0)).getEcranaCle() != null && !((EcrituresAnalytique)var3.get(0)).getEcranaCle().isEmpty()) {
               this.dataModelDetAnalytique.setWrappedData(var3);
               var1 = 2;
            } else {
               var4 = 0;
               var5 = "";
               new EcrituresAnalytique();
               var7 = 0;

               while(true) {
                  if (var7 >= var3.size()) {
                     if (this.mesOngletsAnalytiqueItems.size() != 0) {
                        this.mesOngletsAnalytiqueItems.get(0);
                        this.listeOngletAnalytique.get(0);
                        this.var_axe = this.objetTable.getIndice();
                        this.chargerAxe();
                        if (this.listeRepartitionAnal.size() != 0) {
                           this.ecrituresAnalytique = (EcrituresAnalytique)this.listeRepartitionAnal.get(0);
                           this.afficheColonne();
                        }

                        if (this.ecrituresAnalytique.getEcranaAxe() <= 90) {
                           this.miseEnFormeCle();
                        }
                     }
                     break;
                  }

                  var6 = (EcrituresAnalytique)var3.get(var7);
                  var8 = var6.getEcranaAxe();
                  var9 = var6.getEcranaCle();
                  if (var8 != var4 || !var9.equals(var5)) {
                     var1 = 1;
                     ++var2;
                     var4 = var6.getEcranaAxe();
                     var5 = var6.getEcranaCle();
                     var10 = this.calculeAxe(var4);
                     if (var5 != null && !var5.isEmpty()) {
                        var11 = var10 + ":" + var5;
                        this.mesOngletsAnalytiqueItems.add(new SelectItem(var2, var11));
                     } else {
                        this.mesOngletsAnalytiqueItems.add(new SelectItem(var2, var10));
                     }

                     this.objetTable = new ObjetTable();
                     this.objetTable.setIndice(var2);
                     this.objetTable.setNature(var4);
                     this.objetTable.setColumn_comment(var10);
                     this.objetTable.setColumn_name(var5);
                     var15 = new ArrayList();
                     new EcrituresAnalytique();
                     var13 = 0;

                     while(true) {
                        if (var13 >= var3.size()) {
                           this.objetTable.setListEcrituresAnalytiqueCtrl(var15);
                           this.listeOngletAnalytique.add(this.objetTable);
                           break;
                        }

                        var12 = (EcrituresAnalytique)var3.get(var13);
                        if (var4 == var12.getEcranaAxe() && (var5 == null || var5.isEmpty() || var5 != null && !var5.isEmpty() && var5.equals(var12.getEcranaCle()))) {
                           var14 = new EcrituresAnalytiqueCtrl();
                           var14.setEcranaAxe(var12.getEcranaAxe());
                           var14.setEcranaCle(var12.getEcranaCle());
                           var14.setEcranaMontantSaisie(var12.getEcranaMontantSaisie());
                           var14.setEcranaPourcentage(var12.getEcranaPourcentage());
                           var14.setEcranaActivite(var12.getEcranaActivite());
                           var14.setEcranaActiviteLib(var12.getEcranaActiviteLib());
                           var14.setZoneActivite(var6.getEcranaActivite() + ":" + var6.getEcranaActiviteLib());
                           var14.setEcranaAnal1(var12.getEcranaAnal1());
                           var14.setEcranaAnal1Lib(var12.getEcranaAnal1Lib());
                           var14.setZoneAnal1(var6.getEcranaAnal1() + ":" + var6.getEcranaAnal1Lib());
                           var14.setEcranaAnal2(var12.getEcranaAnal2());
                           var14.setEcranaAnal2Lib(var12.getEcranaAnal2Lib());
                           var14.setEcranaAnal3(var12.getEcranaAnal3());
                           var14.setEcranaAnal3Lib(var12.getEcranaAnal3Lib());
                           var14.setZoneAnal3(var6.getEcranaAnal3() + ":" + var6.getEcranaAnal3Lib());
                           var14.setEcranaAnal4(var12.getEcranaAnal4());
                           var14.setEcranaAnal4Lib(var12.getEcranaAnal4Lib());
                           var14.setEcranaSite(var12.getEcranaSite());
                           var14.setEcranaSiteLib(var12.getEcranaSiteLib());
                           var14.setEcranaDepartement(var12.getEcranaDepartement());
                           var14.setEcranaDepartementLib(var12.getEcranaDepartementLib());
                           var14.setEcranaService(var12.getEcranaService());
                           var14.setEcranaServiceLib(var12.getEcranaServiceLib());
                           var14.setEcranaLigne(var12.getEcranaLigne());
                           var14.setEcranaLigneLib(var12.getEcranaLigneLib());
                           var14.setEcranaAtelier(var12.getEcranaAtelier());
                           var14.setEcranaAtelierLib(var12.getEcranaAtelierLib());
                           var14.setEcranaRegion(var12.getEcranaRegion());
                           var14.setEcranaRegionLib(var12.getEcranaRegion());
                           var14.setEcranaSecteur(var12.getEcranaSecteur());
                           var14.setEcranaSecteurLib(var12.getEcranaSecteurLib());
                           var14.setEcranaPdv(var12.getEcranaPdv());
                           var14.setEcranaPdvLib(var12.getEcranaPdvLib());
                           var15.add(var14);
                        }

                        ++var13;
                     }
                  }

                  ++var7;
               }
            }

            this.var_consult_analytique = true;
            this.var_affiche_saisie_anal = true;
            if (var1 == 1) {
               this.showModalPanelAnalytique = true;
               this.showModalPanelAnalRecup = false;
            } else {
               this.showModalPanelAnalytique = false;
               this.showModalPanelAnalRecup = true;
            }
         } else {
            this.objetTable = new ObjetTable();
            this.listeOngletAnalytique = new ArrayList();
            this.mesOngletsAnalytiqueItems = new ArrayList();
            this.mesOngletsAnalytiqueItems.add(new SelectItem(0, "Nouvel axe"));
            this.var_nature_analytique = 0;
            this.var_cle_analytique = "0";
            this.var_montant_impute = 0.0D;
            this.var_affiche_saisie_anal = false;
            this.var_valide_analytique = false;
            this.ecrituresAnalytique = new EcrituresAnalytique();
            this.plansAnalytiques = new PlansAnalytiques();
            this.var_consult_analytique = false;
            this.showModalPanelAnalytique = true;
         }
      }

   }

   public void chargerAxe() {
      if (this.var_axe == 0) {
         this.listeRepartitionAnal.clear();
         this.var_nature_analytique = 0;
         this.var_cle_analytique = "0";
         this.var_montant_impute = 0.0D;
         this.var_valide_analytique = false;
         this.var_ecart = this.var_montant_ligne - this.var_montant_impute;
         this.var_affiche_saisie_anal = false;
      } else {
         this.listeRepartitionAnal.clear();
         if (this.listeOngletAnalytique.size() != 0) {
            boolean var1 = false;

            for(int var2 = 0; var2 < this.listeOngletAnalytique.size(); ++var2) {
               this.objetTable = (ObjetTable)this.listeOngletAnalytique.get(var2);
               if (this.objetTable.getIndice() == this.var_axe) {
                  var1 = true;
                  break;
               }
            }

            if (var1) {
               this.var_nature_analytique = this.objetTable.getNature();
               this.var_cle_analytique = this.objetTable.getColumn_name();
               new ArrayList();
               List var6 = this.objetTable.getListEcrituresAnalytiqueCtrl();
               if (var6.size() != 0) {
                  new EcrituresAnalytiqueCtrl();

                  for(int var4 = 0; var4 < var6.size(); ++var4) {
                     EcrituresAnalytiqueCtrl var3 = (EcrituresAnalytiqueCtrl)var6.get(var4);
                     this.ecrituresAnalytique = new EcrituresAnalytique();
                     this.ecrituresAnalytique.setEcranaAxe(var3.getEcranaAxe());
                     this.ecrituresAnalytique.setEcranaCle(var3.getEcranaCle());
                     this.ecrituresAnalytique.setEcranaMontantSaisie(var3.getEcranaMontantSaisie());
                     this.ecrituresAnalytique.setEcranaPourcentage(var3.getEcranaPourcentage());
                     this.ecrituresAnalytique.setEcranaActivite(var3.getEcranaActivite());
                     this.ecrituresAnalytique.setEcranaActiviteLib(var3.getEcranaActiviteLib());
                     this.ecrituresAnalytique.setZoneActivite(var3.getEcranaActivite() + ":" + var3.getEcranaActiviteLib());
                     this.ecrituresAnalytique.setEcranaAnal1(var3.getEcranaAnal1());
                     this.ecrituresAnalytique.setEcranaAnal1Lib(var3.getEcranaAnal1Lib());
                     this.ecrituresAnalytique.setZoneAnal1(var3.getEcranaAnal1() + ":" + var3.getEcranaAnal1Lib());
                     this.ecrituresAnalytique.setEcranaAnal2(var3.getEcranaAnal2());
                     this.ecrituresAnalytique.setEcranaAnal2Lib(var3.getEcranaAnal2Lib());
                     this.ecrituresAnalytique.setEcranaAnal3(var3.getEcranaAnal3());
                     this.ecrituresAnalytique.setEcranaAnal3Lib(var3.getEcranaAnal3Lib());
                     this.ecrituresAnalytique.setZoneAnal3(var3.getEcranaAnal3() + ":" + var3.getEcranaAnal3Lib());
                     this.ecrituresAnalytique.setEcranaAnal4(var3.getEcranaAnal4());
                     this.ecrituresAnalytique.setEcranaAnal4Lib(var3.getEcranaAnal4Lib());
                     this.ecrituresAnalytique.setEcranaSite(var3.getEcranaSite());
                     this.ecrituresAnalytique.setEcranaSiteLib(var3.getEcranaSiteLib());
                     this.ecrituresAnalytique.setEcranaDepartement(var3.getEcranaDepartement());
                     this.ecrituresAnalytique.setEcranaDepartementLib(var3.getEcranaDepartementLib());
                     this.ecrituresAnalytique.setEcranaService(var3.getEcranaService());
                     this.ecrituresAnalytique.setEcranaServiceLib(var3.getEcranaServiceLib());
                     this.ecrituresAnalytique.setEcranaLigne(var3.getEcranaLigne());
                     this.ecrituresAnalytique.setEcranaLigneLib(var3.getEcranaLigneLib());
                     this.ecrituresAnalytique.setEcranaAtelier(var3.getEcranaAtelier());
                     this.ecrituresAnalytique.setEcranaAtelierLib(var3.getEcranaAtelierLib());
                     this.ecrituresAnalytique.setEcranaRegion(var3.getEcranaRegion());
                     this.ecrituresAnalytique.setEcranaRegionLib(var3.getEcranaRegion());
                     this.ecrituresAnalytique.setEcranaSecteur(var3.getEcranaSecteur());
                     this.ecrituresAnalytique.setEcranaSecteurLib(var3.getEcranaSecteurLib());
                     this.ecrituresAnalytique.setEcranaPdv(var3.getEcranaPdv());
                     this.ecrituresAnalytique.setEcranaPdvLib(var3.getEcranaPdvLib());
                     this.listeRepartitionAnal.add(this.ecrituresAnalytique);
                     this.afficheColonne();
                  }
               } else {
                  this.listeRepartitionAnal = null;
               }

               this.dataModelDetAnalytique.setWrappedData(this.listeRepartitionAnal);
            }
         }

         this.var_montant_impute = 0.0D;
         if (this.listeRepartitionAnal != null && this.listeRepartitionAnal.size() != 0) {
            for(int var5 = 0; var5 < this.listeRepartitionAnal.size(); ++var5) {
               this.var_montant_impute += ((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaMontantSaisie();
            }
         }

         this.var_ecart = this.var_montant_ligne - this.var_montant_impute;
         this.var_affiche_saisie_anal = true;
      }

   }

   public String calculeAxe(int var1) {
      String var2 = "";
      if (var1 == 10) {
         var2 = "Ventes Commerciales";
      } else if (var1 == 11) {
         var2 = "Ventes Administratives";
      } else if (var1 == 20) {
         var2 = "Achats Commerciaux";
      } else if (var1 == 21) {
         var2 = "Achats Administratifs";
      } else if (var1 == 30) {
         var2 = "Production";
      } else if (var1 == 40) {
         var2 = "Frais Généraux Commerciaux";
      } else if (var1 == 41) {
         var2 = "Frais Généraux Administratifs";
      } else if (var1 == 50) {
         var2 = "Investissement";
      } else if (var1 == 70) {
         var2 = "Impôts et Taxes";
      } else if (var1 == 80) {
         var2 = "Personnel";
      } else if (var1 == 120) {
         var2 = "Parcs";
      } else if (var1 == 121) {
         var2 = "Dossiers";
      } else if (var1 == 122) {
         var2 = "Agents";
      }

      return var2;
   }

   public void miseEnFormeCle() {
      if (this.listeRepartitionAnal.size() != 0) {
         String var1 = "";
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

         for(int var15 = 0; var15 < this.listeRepartitionAnal.size(); ++var15) {
            this.ecrituresAnalytique = (EcrituresAnalytique)this.listeRepartitionAnal.get(var15);
            if (this.affiche_activite = true) {
               if (this.ecrituresAnalytique.getEcranaActivite() != null && !this.ecrituresAnalytique.getEcranaActivite().isEmpty() && !var1.equals(this.ecrituresAnalytique.getEcranaActivite())) {
                  var1 = this.ecrituresAnalytique.getEcranaActivite();
               } else {
                  var1 = "";
               }
            }

            if (this.affiche_anal1 = true) {
               if (this.ecrituresAnalytique.getEcranaAnal1() != null && !this.ecrituresAnalytique.getEcranaAnal1().isEmpty() && !var11.equals(this.ecrituresAnalytique.getEcranaAnal1())) {
                  var11 = this.ecrituresAnalytique.getEcranaAnal1();
               } else {
                  var11 = "";
               }
            }

            if (this.affiche_anal2 = true) {
               if (this.ecrituresAnalytique.getEcranaAnal2() != null && !this.ecrituresAnalytique.getEcranaAnal2().isEmpty() && !var12.equals(this.ecrituresAnalytique.getEcranaAnal2())) {
                  var12 = this.ecrituresAnalytique.getEcranaAnal2();
               } else {
                  var12 = "";
               }
            }

            if (this.affiche_anal3 = true) {
               if (this.ecrituresAnalytique.getEcranaAnal3() != null && !this.ecrituresAnalytique.getEcranaAnal3().isEmpty() && !var13.equals(this.ecrituresAnalytique.getEcranaAnal3())) {
                  var13 = this.ecrituresAnalytique.getEcranaAnal3();
               } else {
                  var13 = "";
               }
            }

            if (this.affiche_anal4 = true) {
               if (this.ecrituresAnalytique.getEcranaAnal4() != null && !this.ecrituresAnalytique.getEcranaAnal4().isEmpty() && !var14.equals(this.ecrituresAnalytique.getEcranaAnal4())) {
                  var14 = this.ecrituresAnalytique.getEcranaAnal4();
               } else {
                  var14 = "";
               }
            }

            if (this.affiche_site) {
               if (this.ecrituresAnalytique.getEcranaSite() != null && !this.ecrituresAnalytique.getEcranaSite().isEmpty() && !var2.equals(this.ecrituresAnalytique.getEcranaSite())) {
                  var2 = this.ecrituresAnalytique.getEcranaSite();
               } else {
                  var2 = "";
               }

               if (this.affiche_departement) {
                  if (this.ecrituresAnalytique.getEcranaDepartement() != null && !this.ecrituresAnalytique.getEcranaDepartement().isEmpty() && !var3.equals(this.ecrituresAnalytique.getEcranaDepartement())) {
                     var3 = this.ecrituresAnalytique.getEcranaDepartement();
                  } else {
                     var3 = "";
                  }

                  if (this.affiche_service) {
                     if (this.ecrituresAnalytique.getEcranaService() != null && !this.ecrituresAnalytique.getEcranaService().isEmpty() && !var4.equals(this.ecrituresAnalytique.getEcranaService())) {
                        var4 = this.ecrituresAnalytique.getEcranaService();
                     } else {
                        var4 = "";
                     }
                  }
               }
            }

            if (this.affiche_region) {
               if (this.ecrituresAnalytique.getEcranaRegion() != null && !this.ecrituresAnalytique.getEcranaRegion().isEmpty() && !var5.equals(this.ecrituresAnalytique.getEcranaRegion())) {
                  var5 = this.ecrituresAnalytique.getEcranaRegion();
               } else {
                  var5 = "";
               }

               if (this.affiche_secteur) {
                  if (this.ecrituresAnalytique.getEcranaSecteur() != null && !this.ecrituresAnalytique.getEcranaSecteur().isEmpty() && !var6.equals(this.ecrituresAnalytique.getEcranaSecteur())) {
                     var6 = this.ecrituresAnalytique.getEcranaSecteur();
                  } else {
                     var6 = "";
                  }

                  if (this.affiche_pdv) {
                     if (this.ecrituresAnalytique.getEcranaPdv() != null && !this.ecrituresAnalytique.getEcranaPdv().isEmpty() && !var7.equals(this.ecrituresAnalytique.getEcranaPdv())) {
                        var7 = this.ecrituresAnalytique.getEcranaPdv();
                     } else {
                        var7 = "";
                     }
                  }
               }
            }

            if (this.affiche_sitePrdv) {
               if (this.ecrituresAnalytique.getEcranaSite() != null && !this.ecrituresAnalytique.getEcranaSite().isEmpty() && !var8.equals(this.ecrituresAnalytique.getEcranaSite())) {
                  var8 = this.ecrituresAnalytique.getEcranaSite();
               } else {
                  var8 = "";
               }

               if (this.affiche_ligne) {
                  if (this.ecrituresAnalytique.getEcranaLigne() != null && !this.ecrituresAnalytique.getEcranaLigne().isEmpty() && !var9.equals(this.ecrituresAnalytique.getEcranaLigne())) {
                     var9 = this.ecrituresAnalytique.getEcranaLigne();
                  } else {
                     var9 = "";
                  }

                  if (this.affiche_atelier) {
                     if (this.ecrituresAnalytique.getEcranaAtelier() != null && !this.ecrituresAnalytique.getEcranaAtelier().isEmpty() && !var10.equals(this.ecrituresAnalytique.getEcranaAtelier())) {
                        var10 = this.ecrituresAnalytique.getEcranaAtelier();
                     } else {
                        var10 = "";
                     }
                  }
               }
            }
         }

         this.dataModelDetAnalytique.setWrappedData(this.listeRepartitionAnal);
      }

   }

   public void afficheColonne() {
      this.affiche_activite = false;
      this.affiche_site = false;
      this.affiche_departement = false;
      this.affiche_service = false;
      this.affiche_region = false;
      this.affiche_secteur = false;
      this.affiche_pdv = false;
      this.affiche_sitePrdv = false;
      this.affiche_ligne = false;
      this.affiche_atelier = false;
      this.affiche_anal1 = false;
      this.affiche_anal2 = false;
      this.affiche_anal3 = false;
      this.affiche_anal4 = false;
      if (this.ecrituresAnalytique.getEcranaAxe() <= 90) {
         if (this.ecrituresAnalytique.getEcranaActivite() != null && !this.ecrituresAnalytique.getEcranaActivite().isEmpty()) {
            this.affiche_activite = true;
         }

         if (this.ecrituresAnalytique.getEcranaAxe() == 30) {
            if (this.ecrituresAnalytique.getEcranaSite() != null && !this.ecrituresAnalytique.getEcranaSite().isEmpty()) {
               this.affiche_sitePrdv = true;
            }

            if (this.ecrituresAnalytique.getEcranaLigne() != null && !this.ecrituresAnalytique.getEcranaLigne().isEmpty()) {
               this.affiche_ligne = true;
            }

            if (this.ecrituresAnalytique.getEcranaAtelier() != null && !this.ecrituresAnalytique.getEcranaAtelier().isEmpty()) {
               this.affiche_atelier = true;
            }
         } else {
            if (this.ecrituresAnalytique.getEcranaSite() != null && !this.ecrituresAnalytique.getEcranaSite().isEmpty()) {
               this.affiche_site = true;
            }

            if (this.ecrituresAnalytique.getEcranaDepartement() != null && !this.ecrituresAnalytique.getEcranaDepartement().isEmpty()) {
               this.affiche_departement = true;
            }

            if (this.ecrituresAnalytique.getEcranaService() != null && !this.ecrituresAnalytique.getEcranaService().isEmpty()) {
               this.affiche_service = true;
            }

            if (this.ecrituresAnalytique.getEcranaRegion() != null && !this.ecrituresAnalytique.getEcranaRegion().isEmpty()) {
               this.affiche_region = true;
            }

            if (this.ecrituresAnalytique.getEcranaSecteur() != null && !this.ecrituresAnalytique.getEcranaSecteur().isEmpty()) {
               this.affiche_secteur = true;
            }

            if (this.ecrituresAnalytique.getEcranaPdv() != null && !this.ecrituresAnalytique.getEcranaPdv().isEmpty()) {
               this.affiche_pdv = true;
            }
         }
      } else if (this.ecrituresAnalytique.getEcranaAxe() == 110 && this.decoupageActivite) {
         if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
            this.affiche_activite = true;
         }

         if (this.structureLog.getStrCode2() != null && !this.structureLog.getStrCode2().isEmpty()) {
            this.affiche_anal1 = true;
         }

         if (this.structureLog.getStrCode3() != null && !this.structureLog.getStrCode3().isEmpty()) {
            this.affiche_anal3 = true;
         }
      }

   }

   public void fermerDetailsAnalytique() {
      if (this.ecritures != null) {
         if (this.ecritures.getEcrAnaActif() == 1) {
            this.ecritures.setErreurAnalytique(false);
         } else {
            this.ecritures.setErreurAnalytique(true);
         }

         this.ecrituresDetail = this.ecritures;
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
      this.showModalPanelAnalRecup = false;
      this.showModalPanelAnalytique = false;
   }

   public void modifierAxe() {
      if (this.var_axe != 0 && this.objetTable != null) {
         int var1 = this.listeOngletAnalytique.indexOf(this.objetTable);
         String var2 = this.objetTable.getColumn_comment();
         String var3 = this.objetTable.getColumn_name();
         int var4 = this.objetTable.getIndice();
         int var5 = this.objetTable.getNature();
         this.listeOngletAnalytique.remove(this.objetTable);
         this.objetTable = new ObjetTable();
         this.objetTable.setIndice(var4);
         this.objetTable.setNature(var5);
         this.objetTable.setColumn_comment(var2);
         this.objetTable.setColumn_name(var3);
         ArrayList var6 = new ArrayList();
         if (this.listeRepartitionAnal.size() == 0) {
            var6 = null;
         } else {
            new EcrituresAnalytique();

            for(int var8 = 0; var8 < this.listeRepartitionAnal.size(); ++var8) {
               EcrituresAnalytique var7 = (EcrituresAnalytique)this.listeRepartitionAnal.get(var8);
               EcrituresAnalytiqueCtrl var9 = new EcrituresAnalytiqueCtrl();
               var9.setEcranaAxe(var7.getEcranaAxe());
               var9.setEcranaCle(var7.getEcranaCle());
               var9.setEcranaMontantSaisie(var7.getEcranaMontantSaisie());
               String[] var10;
               if (var7.getZoneActivite() != null && var7.getZoneActivite().contains(":")) {
                  var10 = var7.getZoneActivite().split(":");
                  var9.setEcranaActivite(var10[0]);
                  var9.setEcranaActiviteLib(var10[1]);
                  var9.setZoneActivite(var7.getEcranaActivite() + ":" + var7.getEcranaActiviteLib());
               } else {
                  var9.setEcranaActivite("");
                  var9.setEcranaActiviteLib("");
                  var9.setZoneActivite("");
               }

               if (var7.getZoneAnal1() != null && var7.getZoneAnal1().contains(":")) {
                  var10 = var7.getZoneAnal1().split(":");
                  var9.setEcranaAnal1(var10[0]);
                  var9.setEcranaAnal1Lib(var10[1]);
                  var9.setZoneAnal1(var7.getEcranaAnal1() + ":" + var7.getEcranaAnal1Lib());
               } else {
                  var9.setEcranaAnal1("");
                  var9.setEcranaAnal1Lib("");
                  var9.setZoneAnal1("");
               }

               var9.setEcranaAnal2(var7.getEcranaAnal2());
               var9.setEcranaAnal2Lib(var7.getEcranaAnal2Lib());
               if (var7.getZoneAnal3() != null && var7.getZoneAnal3().contains(":")) {
                  var10 = var7.getZoneAnal3().split(":");
                  var9.setEcranaAnal3(var10[0]);
                  var9.setEcranaAnal3Lib(var10[1]);
                  var9.setZoneAnal3(var7.getEcranaAnal3() + ":" + var7.getEcranaAnal3Lib());
               } else {
                  var9.setEcranaAnal3("");
                  var9.setEcranaAnal3Lib("");
                  var9.setZoneAnal3("");
               }

               var9.setEcranaAnal4(var7.getEcranaAnal4());
               var9.setEcranaAnal4Lib(var7.getEcranaAnal4Lib());
               var9.setEcranaSite(var7.getEcranaSite());
               var9.setEcranaSiteLib(var7.getEcranaSiteLib());
               var9.setEcranaDepartement(var7.getEcranaDepartement());
               var9.setEcranaDepartementLib(var7.getEcranaDepartementLib());
               var9.setEcranaService(var7.getEcranaService());
               var9.setEcranaServiceLib(var7.getEcranaServiceLib());
               var9.setEcranaLigne(var7.getEcranaLigne());
               var9.setEcranaLigneLib(var7.getEcranaLigneLib());
               var9.setEcranaAtelier(var7.getEcranaAtelier());
               var9.setEcranaAtelierLib(var7.getEcranaAtelierLib());
               var9.setEcranaRegion(var7.getEcranaRegion());
               var9.setEcranaRegionLib(var7.getEcranaRegion());
               var9.setEcranaSecteur(var7.getEcranaSecteur());
               var9.setEcranaSecteurLib(var7.getEcranaSecteurLib());
               var9.setEcranaPdv(var7.getEcranaPdv());
               var9.setEcranaPdvLib(var7.getEcranaPdvLib());
               var6.add(var9);
            }
         }

         this.objetTable.setListEcrituresAnalytiqueCtrl(var6);
         this.listeOngletAnalytique.add(var1, this.objetTable);
      }

   }

   public void selectionAnalytique() {
      if (this.dataModelDetAnalytique.isRowAvailable()) {
         this.ecrituresAnalytique = (EcrituresAnalytique)this.dataModelDetAnalytique.getRowData();
      }

   }

   public void controleEcartAnalytique() {
      if (this.listeRepartitionAnal.size() != 0 && this.ecrituresAnalytique != null) {
         double var1;
         if (this.ecrituresAnalytique.getEcranaPourcentage() != 0.0F) {
            var1 = this.utilNombre.myRoundDevise(this.var_montant_ligne * (double)this.ecrituresAnalytique.getEcranaPourcentage() / 100.0D, this.ecritures.getEcrDeviseSaisie());
            this.ecrituresAnalytique.setEcranaMontantSaisie(var1);
         }

         this.var_montant_impute = 0.0D;

         for(int var8 = 0; var8 < this.listeRepartitionAnal.size(); ++var8) {
            this.var_montant_impute += ((EcrituresAnalytique)this.listeRepartitionAnal.get(var8)).getEcranaMontantSaisie();
         }

         this.var_ecart = this.var_montant_ligne - this.var_montant_impute;
         if (this.var_nature_analytique != 120 && this.var_nature_analytique != 121 && this.var_nature_analytique != 122) {
            String var3;
            int var4;
            int var5;
            int var6;
            if (this.var_nature_analytique == 110) {
               if (this.decoupageActivite) {
                  if (this.var_ecart > 0.0D && this.ecrituresAnalytique.getEcranaMontantSaisie() != 0.0D) {
                     this.ecrituresAnalytique = new EcrituresAnalytique();
                     this.listeRepartitionAnal.add(this.ecrituresAnalytique);
                     this.dataModelDetAnalytique.setWrappedData(this.listeRepartitionAnal);
                  }
               } else {
                  String[] var7;
                  String[] var10;
                  if (this.affiche_activite) {
                     var1 = 0.0D;
                     var3 = "";

                     for(var4 = 0; var4 < this.listeRepartitionAnal.size(); ++var4) {
                        this.ecrituresAnalytique = new EcrituresAnalytique();
                        this.ecrituresAnalytique = (EcrituresAnalytique)this.listeRepartitionAnal.get(var4);
                        var1 = 0.0D;
                        if (this.ecrituresAnalytique.getZoneActivite() != null && !this.ecrituresAnalytique.getZoneActivite().isEmpty() && this.ecrituresAnalytique.getZoneActivite().contains(":")) {
                           var10 = this.ecrituresAnalytique.getZoneActivite().split(":");
                           var3 = var10[0];

                           for(var6 = 0; var6 < this.listeRepartitionAnal.size(); ++var6) {
                              var7 = ((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getZoneActivite().split(":");
                              if (var3.equals(var7[0])) {
                                 var1 += ((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaMontantSaisie();
                              }
                           }
                        } else {
                           var3 = this.ecrituresAnalytique.getEcranaActivite();
                           if (var3 != null && !var3.isEmpty()) {
                              for(var5 = 0; var5 < this.listeRepartitionAnal.size(); ++var5) {
                                 if (var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaActivite())) {
                                    var1 += ((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaMontantSaisie();
                                 }
                              }
                           }
                        }

                        if ((this.structureLog.getStrCode1() == null || this.structureLog.getStrCode1().isEmpty()) && var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var4)).getEcranaActivite())) {
                           this.ecrituresAnalytique.setEcranaMontantSaisie(var1);
                        }
                     }
                  }

                  if (this.affiche_anal1) {
                     var1 = 0.0D;
                     var3 = "";

                     for(var4 = 0; var4 < this.listeRepartitionAnal.size(); ++var4) {
                        this.ecrituresAnalytique = new EcrituresAnalytique();
                        this.ecrituresAnalytique = (EcrituresAnalytique)this.listeRepartitionAnal.get(var4);
                        var1 = 0.0D;
                        if (this.ecrituresAnalytique.getZoneAnal1() != null && !this.ecrituresAnalytique.getZoneAnal1().isEmpty() && this.ecrituresAnalytique.getZoneAnal1().contains(":")) {
                           var10 = this.ecrituresAnalytique.getZoneAnal1().split(":");
                           var3 = var10[0];

                           for(var6 = 0; var6 < this.listeRepartitionAnal.size(); ++var6) {
                              var7 = ((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getZoneAnal1().split(":");
                              if (var3.equals(var7[0])) {
                                 var1 += ((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaMontantSaisie();
                              }
                           }
                        } else {
                           var3 = this.ecrituresAnalytique.getEcranaAnal1();
                           if (var3 != null && !var3.isEmpty()) {
                              for(var5 = 0; var5 < this.listeRepartitionAnal.size(); ++var5) {
                                 if (var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaAnal1())) {
                                    var1 += ((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaMontantSaisie();
                                 }
                              }
                           }
                        }
                     }
                  }

                  if (this.affiche_anal3) {
                     var1 = 0.0D;
                     var3 = "";

                     for(var4 = 0; var4 < this.listeRepartitionAnal.size(); ++var4) {
                        this.ecrituresAnalytique = new EcrituresAnalytique();
                        this.ecrituresAnalytique = (EcrituresAnalytique)this.listeRepartitionAnal.get(var4);
                        var1 = 0.0D;
                        if (this.ecrituresAnalytique.getZoneAnal3() != null && !this.ecrituresAnalytique.getZoneAnal3().isEmpty() && this.ecrituresAnalytique.getZoneAnal3().contains(":")) {
                           var10 = this.ecrituresAnalytique.getZoneAnal3().split(":");
                           var3 = var10[0];

                           for(var6 = 0; var6 < this.listeRepartitionAnal.size(); ++var6) {
                              var7 = ((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getZoneAnal3().split(":");
                              if (var3.equals(var7[0])) {
                                 var1 += ((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaMontantSaisie();
                              }
                           }
                        } else {
                           var3 = this.ecrituresAnalytique.getEcranaAnal3();
                           if (var3 != null && !var3.isEmpty()) {
                              for(var5 = 0; var5 < this.listeRepartitionAnal.size(); ++var5) {
                                 if (var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaAnal3())) {
                                    var1 += ((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaMontantSaisie();
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            } else {
               if (this.affiche_activite) {
                  var1 = 0.0D;
                  var3 = "";

                  for(var4 = 0; var4 < this.listeRepartitionAnal.size(); ++var4) {
                     this.ecrituresAnalytique = new EcrituresAnalytique();
                     this.ecrituresAnalytique = (EcrituresAnalytique)this.listeRepartitionAnal.get(var4);
                     var3 = this.ecrituresAnalytique.getEcranaActivite();
                     var1 = 0.0D;

                     for(var5 = 0; var5 < this.listeRepartitionAnal.size(); ++var5) {
                        if (var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaActivite())) {
                           var1 += ((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaMontantSaisie();
                        }
                     }

                     if (var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var4)).getEcranaActivite())) {
                        this.ecrituresAnalytique.setEcranaMontantSaisie(var1);
                     }
                  }
               }

               String var9;
               if (this.affiche_site) {
                  var1 = 0.0D;
                  var3 = "";
                  var9 = "";

                  for(var5 = 0; var5 < this.listeRepartitionAnal.size(); ++var5) {
                     this.ecrituresAnalytique = new EcrituresAnalytique();
                     this.ecrituresAnalytique = (EcrituresAnalytique)this.listeRepartitionAnal.get(var5);
                     var9 = this.ecrituresAnalytique.getEcranaActivite();
                     var3 = this.ecrituresAnalytique.getEcranaSite();
                     var1 = 0.0D;

                     for(var6 = 0; var6 < this.listeRepartitionAnal.size(); ++var6) {
                        if (var9.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaActivite()) && var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaSite())) {
                           var1 += ((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaMontantSaisie();
                        }
                     }

                     if (var9.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaActivite()) && var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaSite())) {
                        this.ecrituresAnalytique.setEcranaMontantSaisie(var1);
                     }
                  }

                  if (this.affiche_departement) {
                     var1 = 0.0D;
                     var3 = "";
                     var9 = "";

                     for(var5 = 0; var5 < this.listeRepartitionAnal.size(); ++var5) {
                        this.ecrituresAnalytique = new EcrituresAnalytique();
                        this.ecrituresAnalytique = (EcrituresAnalytique)this.listeRepartitionAnal.get(var5);
                        var9 = this.ecrituresAnalytique.getEcranaActivite();
                        var3 = this.ecrituresAnalytique.getEcranaDepartement();
                        var1 = 0.0D;

                        for(var6 = 0; var6 < this.listeRepartitionAnal.size(); ++var6) {
                           if (var9.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaActivite()) && var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaDepartement())) {
                              var1 += ((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaMontantSaisie();
                           }
                        }

                        if (var9.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaActivite()) && var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaDepartement())) {
                           this.ecrituresAnalytique.setEcranaMontantSaisie(var1);
                        }
                     }

                     if (this.affiche_service) {
                        var1 = 0.0D;
                        var3 = "";
                        var9 = "";

                        for(var5 = 0; var5 < this.listeRepartitionAnal.size(); ++var5) {
                           this.ecrituresAnalytique = new EcrituresAnalytique();
                           this.ecrituresAnalytique = (EcrituresAnalytique)this.listeRepartitionAnal.get(var5);
                           var9 = this.ecrituresAnalytique.getEcranaActivite();
                           var3 = this.ecrituresAnalytique.getEcranaService();
                           var1 = 0.0D;

                           for(var6 = 0; var6 < this.listeRepartitionAnal.size(); ++var6) {
                              if (var9.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaActivite()) && var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaService())) {
                                 var1 += ((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaMontantSaisie();
                              }
                           }

                           if (var9.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaActivite()) && var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaService())) {
                              this.ecrituresAnalytique.setEcranaMontantSaisie(var1);
                           }
                        }
                     }
                  }
               }

               if (this.affiche_region) {
                  var1 = 0.0D;
                  var3 = "";
                  var9 = "";

                  for(var5 = 0; var5 < this.listeRepartitionAnal.size(); ++var5) {
                     this.ecrituresAnalytique = new EcrituresAnalytique();
                     this.ecrituresAnalytique = (EcrituresAnalytique)this.listeRepartitionAnal.get(var5);
                     var9 = this.ecrituresAnalytique.getEcranaActivite();
                     var3 = this.ecrituresAnalytique.getEcranaRegion();
                     var1 = 0.0D;

                     for(var6 = 0; var6 < this.listeRepartitionAnal.size(); ++var6) {
                        if (var9.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaActivite()) && var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaRegion())) {
                           var1 += ((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaMontantSaisie();
                        }
                     }

                     if (var9.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaActivite()) && var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaRegion())) {
                        this.ecrituresAnalytique.setEcranaMontantSaisie(var1);
                     }
                  }

                  if (this.affiche_departement) {
                     var1 = 0.0D;
                     var3 = "";
                     var9 = "";

                     for(var5 = 0; var5 < this.listeRepartitionAnal.size(); ++var5) {
                        this.ecrituresAnalytique = new EcrituresAnalytique();
                        this.ecrituresAnalytique = (EcrituresAnalytique)this.listeRepartitionAnal.get(var5);
                        var9 = this.ecrituresAnalytique.getEcranaActivite();
                        var3 = this.ecrituresAnalytique.getEcranaSecteur();
                        var1 = 0.0D;

                        for(var6 = 0; var6 < this.listeRepartitionAnal.size(); ++var6) {
                           if (var9.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaActivite()) && var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaSecteur())) {
                              var1 += ((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaMontantSaisie();
                           }
                        }

                        if (var9.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaActivite()) && var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaSecteur())) {
                           this.ecrituresAnalytique.setEcranaMontantSaisie(var1);
                        }
                     }

                     if (this.affiche_service) {
                        var1 = 0.0D;
                        var3 = "";
                        var9 = "";

                        for(var5 = 0; var5 < this.listeRepartitionAnal.size(); ++var5) {
                           this.ecrituresAnalytique = new EcrituresAnalytique();
                           this.ecrituresAnalytique = (EcrituresAnalytique)this.listeRepartitionAnal.get(var5);
                           var9 = this.ecrituresAnalytique.getEcranaActivite();
                           var3 = this.ecrituresAnalytique.getEcranaPdv();
                           var1 = 0.0D;

                           for(var6 = 0; var6 < this.listeRepartitionAnal.size(); ++var6) {
                              if (var9.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaActivite()) && var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaPdv())) {
                                 var1 += ((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaMontantSaisie();
                              }
                           }

                           if (var9.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaActivite()) && var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaPdv())) {
                              this.ecrituresAnalytique.setEcranaMontantSaisie(var1);
                           }
                        }
                     }
                  }
               }

               if (this.affiche_sitePrdv) {
                  var1 = 0.0D;
                  var3 = "";
                  var9 = "";

                  for(var5 = 0; var5 < this.listeRepartitionAnal.size(); ++var5) {
                     this.ecrituresAnalytique = new EcrituresAnalytique();
                     this.ecrituresAnalytique = (EcrituresAnalytique)this.listeRepartitionAnal.get(var5);
                     var9 = this.ecrituresAnalytique.getEcranaActivite();
                     var3 = this.ecrituresAnalytique.getEcranaSite();
                     var1 = 0.0D;

                     for(var6 = 0; var6 < this.listeRepartitionAnal.size(); ++var6) {
                        if (var9.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaActivite()) && var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaSite())) {
                           var1 += ((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaMontantSaisie();
                        }
                     }

                     if (var9.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaActivite()) && var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaSite())) {
                        this.ecrituresAnalytique.setEcranaMontantSaisie(var1);
                     }
                  }

                  if (this.affiche_ligne) {
                     var1 = 0.0D;
                     var3 = "";
                     var9 = "";

                     for(var5 = 0; var5 < this.listeRepartitionAnal.size(); ++var5) {
                        this.ecrituresAnalytique = new EcrituresAnalytique();
                        this.ecrituresAnalytique = (EcrituresAnalytique)this.listeRepartitionAnal.get(var5);
                        var9 = this.ecrituresAnalytique.getEcranaActivite();
                        var3 = this.ecrituresAnalytique.getEcranaLigne();
                        var1 = 0.0D;

                        for(var6 = 0; var6 < this.listeRepartitionAnal.size(); ++var6) {
                           if (var9.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaActivite()) && var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaLigne())) {
                              var1 += ((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaMontantSaisie();
                           }
                        }

                        if (var9.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaActivite()) && var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaLigne())) {
                           this.ecrituresAnalytique.setEcranaMontantSaisie(var1);
                        }
                     }

                     if (this.affiche_service) {
                        var1 = 0.0D;
                        var3 = "";
                        var9 = "";

                        for(var5 = 0; var5 < this.listeRepartitionAnal.size(); ++var5) {
                           this.ecrituresAnalytique = new EcrituresAnalytique();
                           this.ecrituresAnalytique = (EcrituresAnalytique)this.listeRepartitionAnal.get(var5);
                           var9 = this.ecrituresAnalytique.getEcranaActivite();
                           var3 = this.ecrituresAnalytique.getEcranaAtelier();
                           var1 = 0.0D;

                           for(var6 = 0; var6 < this.listeRepartitionAnal.size(); ++var6) {
                              if (var9.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaActivite()) && var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaAtelier())) {
                                 var1 += ((EcrituresAnalytique)this.listeRepartitionAnal.get(var6)).getEcranaMontantSaisie();
                              }
                           }

                           if (var9.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaActivite()) && var3.equals(((EcrituresAnalytique)this.listeRepartitionAnal.get(var5)).getEcranaAtelier())) {
                              this.ecrituresAnalytique.setEcranaMontantSaisie(var1);
                           }
                        }
                     }
                  }
               }

               this.dataModelDetAnalytique.setWrappedData(this.listeRepartitionAnal);
            }
         } else if (this.ecrituresAnalytique.getEcranaMontantSaisie() != 0.0D && this.var_ecart != 0.0D) {
            this.ecrituresAnalytique = new EcrituresAnalytique();
            this.listeRepartitionAnal.add(0, this.ecrituresAnalytique);
            this.dataModelDetAnalytique.setWrappedData(this.listeRepartitionAnal);
         }

         this.modifierAxe();
         if (this.var_ecart == 0.0D) {
            this.var_valide_analytique = true;
         } else {
            this.var_valide_analytique = false;
         }
      }

   }

   public void valideAnalytique() throws NamingException, JDOMException, IOException {
      if (this.ecritures != null) {
         boolean var1 = false;
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            var2.setFlushMode(FlushMode.MANUAL);
            new ArrayList();
            List var4 = this.ecrituresAnalytiquesDao.chargerLesEcrituresAnalytiques(this.ecritures, var2);
            if (var4.size() != 0) {
               this.ecrituresAnalytiquesDao.nettoyageAnalytiqueByEcriture(var4, var2);
               var2.flush();
            }

            if (this.listeOngletAnalytique.size() != 0) {
               for(int var5 = 0; var5 < this.listeOngletAnalytique.size(); ++var5) {
                  this.objetTable = new ObjetTable();
                  this.objetTable = (ObjetTable)this.listeOngletAnalytique.get(var5);
                  this.var_axe = this.objetTable.getIndice();
                  this.var_nature_analytique = this.objetTable.getNature();
                  this.var_cle_analytique = this.objetTable.getColumn_name();
                  this.chargerAxe();
                  if (this.listeRepartitionAnal.size() != 0) {
                     var1 = true;
                     if (this.var_nature_analytique >= 100) {
                        this.var_cle_analytique = "";
                     }

                     for(int var6 = 0; var6 < this.listeRepartitionAnal.size(); ++var6) {
                        this.ecrituresAnalytique = (EcrituresAnalytique)this.listeRepartitionAnal.get(var6);
                        this.ecrituresAnalytique.setEcranaAxe(this.var_nature_analytique);
                     }

                     this.ecrituresAnalytiquesDao.miseAJourAnalytiqueByEcriture(this.var_cle_analytique, this.ecritures, this.listeRepartitionAnal, var2);
                     var2.flush();
                     if (this.ecritures != null && var1 && this.ecritures.getEcrAnaActif() == 0) {
                        this.ecritures.setEcrAnaActif(1);
                        this.ecritures.setErreurAnalytique(false);
                        this.ecritures = this.ecrituresDao.modif(this.ecritures, var2);
                        var2.flush();
                     }
                  }
               }
            }

            var3.commit();
         } catch (HibernateException var10) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.fermerDetailsAnalytique();
   }

   public void rechercherParc() throws HibernateException, NamingException {
      new ArrayList();
      this.plansAnalytiques = new PlansAnalytiques();
      PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      List var1 = var2.selectAnal("8", this.ecrituresAnalytique.getEcranaAnal2(), "", this.nature, (Session)null);
      this.dataModelParc.setWrappedData(var1);
      this.showModalPanelParc = true;
   }

   public void selectionParc() {
      if (this.dataModelParc.isRowAvailable()) {
         this.plansAnalytiques = (PlansAnalytiques)this.dataModelParc.getRowData();
      }

   }

   public void valideParc() {
      if (this.plansAnalytiques != null) {
         this.ecrituresAnalytique.setEcranaAnal2(this.plansAnalytiques.getAnaCode());
         this.ecrituresAnalytique.setEcranaAnal2Lib(this.plansAnalytiques.getAnaNomFr());
      }

      this.showModalPanelParc = true;
   }

   public void annulerParc() {
      this.ecrituresAnalytique.setEcranaAnal2("");
      this.ecrituresAnalytique.setEcranaAnal2Lib("");
      this.showModalPanelParc = false;
   }

   public void rechercherActivite() throws HibernateException, NamingException {
      new ArrayList();
      this.activites = new Activites();
      ActivitesDao var2 = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      List var1 = var2.selectActivites((Session)null);
      this.dataModelActivite.setWrappedData(var1);
      this.showModalPanelActivite = true;
   }

   public void selectionActivite() {
      if (this.dataModelActivite.isRowAvailable()) {
         this.activites = (Activites)this.dataModelActivite.getRowData();
      }

   }

   public void valideActivite() {
      if (this.activites != null) {
         this.ecrituresAnalytique.setEcranaActivite(this.activites.getActCode());
         this.ecrituresAnalytique.setEcranaActiviteLib(this.activites.getActNomFr());
      }

      this.showModalPanelActivite = false;
   }

   public void annulerActivite() {
      this.ecrituresAnalytique.setEcranaActivite("");
      this.ecrituresAnalytique.setEcranaActiviteLib("");
      this.showModalPanelActivite = false;
   }

   public void rechercherDossier() throws HibernateException, NamingException {
      new ArrayList();
      this.plansAnalytiques = new PlansAnalytiques();
      PlansAnalytiquesDao var2 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      List var1 = var2.selectAnal("6", this.ecrituresAnalytique.getEcranaAnal4(), this.ecritures.getEcrAnnee(), this.nature, (Session)null);
      this.dataModelDossier.setWrappedData(var1);
      this.showModalPanelDossier = true;
   }

   public void selectionDossier() {
      if (this.dataModelDossier.isRowAvailable()) {
         this.plansAnalytiques = (PlansAnalytiques)this.dataModelDossier.getRowData();
      }

   }

   public void valideDossier() {
      if (this.plansAnalytiques != null) {
         this.ecrituresAnalytique.setEcranaAnal4(this.plansAnalytiques.getAnaCode());
         this.ecrituresAnalytique.setEcranaAnal4Lib(this.plansAnalytiques.getAnaNomFr());
      }

      this.showModalPanelDossier = false;
   }

   public void annulerDossier() {
      this.ecrituresAnalytique.setEcranaAnal4("");
      this.ecrituresAnalytique.setEcranaAnal4Lib("");
      this.showModalPanelDossier = false;
   }

   public void rechercherAgent() throws NamingException {
      Object var1 = new ArrayList();
      this.salaries = new Salaries();
      new ExercicesPaye();
      ExercicesPayeDao var3 = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
      ExercicesPaye var2 = var3.recupererLastExo((Session)null);
      if (var2 != null) {
         SalariesDao var4 = new SalariesDao(this.baseLog, this.utilInitHibernate);
         var1 = var4.chargerlesSalariesActif(this.ecrituresAnalytique.getEcranaAnal3(), (Session)null);
      }

      this.dataModelAgent.setWrappedData(var1);
   }

   public void selectionAgent() {
      if (this.dataModelAgent.isRowAvailable()) {
         this.salaries = (Salaries)this.dataModelAgent.getRowData();
      }

   }

   public void valideAgent() {
      if (this.salaries != null) {
         this.ecrituresAnalytique.setEcranaAnal3(this.salaries.getSalMatricule());
         this.ecrituresAnalytique.setEcranaAnal3Lib(this.salaries.getSalNom() + " " + this.salaries.getSalPrenom());
      }

   }

   public void valideColonne1() {
      if (this.ecrituresAnalytique.getZoneActivite() != null && !this.ecrituresAnalytique.getZoneActivite().isEmpty() && this.ecrituresAnalytique.getZoneActivite().contains(":")) {
         String[] var1 = this.ecrituresAnalytique.getZoneActivite().split(":");
         this.ecrituresAnalytique.setEcranaActivite(var1[0]);
         this.ecrituresAnalytique.setEcranaActiviteLib(var1[1]);
      }

   }

   public void valideColonne2() {
      if (this.ecrituresAnalytique.getZoneAnal1() != null && !this.ecrituresAnalytique.getZoneAnal1().isEmpty() && this.ecrituresAnalytique.getZoneAnal1().contains(":")) {
         String[] var1 = this.ecrituresAnalytique.getZoneAnal1().split(":");
         this.ecrituresAnalytique.setEcranaAnal1(var1[0]);
         this.ecrituresAnalytique.setEcranaAnal1Lib(var1[1]);
      }

   }

   public void valideColonne3() {
      if (this.ecrituresAnalytique.getZoneAnal3() != null && !this.ecrituresAnalytique.getZoneAnal3().isEmpty() && this.ecrituresAnalytique.getZoneAnal3().contains(":")) {
         String[] var1 = this.ecrituresAnalytique.getZoneAnal3().split(":");
         this.ecrituresAnalytique.setEcranaAnal3(var1[0]);
         this.ecrituresAnalytique.setEcranaAnal3Lib(var1[1]);
      }

   }

   public void calculPourcentage() {
      if (this.ecrituresAnalytique != null && this.ecrituresAnalytique.getEcranaPourcentage() != 0.0F) {
         double var1 = this.utilNombre.myRoundDevise(this.var_montant_ligne * (double)this.ecrituresAnalytique.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
         this.ecrituresAnalytique.setEcranaMontantSaisie(var1);
      }

   }

   public void supprimerAnalytique() {
      if (this.ecrituresAnalytique == null) {
         this.selectionAnalytique();
      }

      if (this.ecrituresAnalytique != null) {
         if (this.ecrituresAnalytique.getEcranaAxe() == 110) {
            this.listeRepartitionAnal.remove(this.ecrituresAnalytique);
            this.dataModelDetAnalytique.setWrappedData(this.listeRepartitionAnal);
            this.ecrituresAnalytique = null;
         } else {
            this.ecrituresAnalytique.setEcranaMontantSaisie(0.0D);
            this.ecrituresAnalytique.setEcranaPourcentage(0.0F);
            this.var_montant_impute = 0.0D;

            for(int var1 = 0; var1 < this.listeRepartitionAnal.size(); ++var1) {
               this.var_montant_impute += ((EcrituresAnalytique)this.listeRepartitionAnal.get(var1)).getEcranaMontantSaisie();
            }

            this.var_ecart = this.var_montant_ligne - this.var_montant_impute;
            if (this.var_ecart == 0.0D) {
               this.var_valide_analytique = true;
            } else {
               this.var_valide_analytique = false;
            }
         }
      }

      if (this.listeRepartitionAnal.size() == 0) {
         this.ecrituresAnalytique = new EcrituresAnalytique();
         this.listeRepartitionAnal.add(this.ecrituresAnalytique);
         this.dataModelDetAnalytique.setWrappedData(this.listeRepartitionAnal);
      }

      this.var_valide_analytique = false;
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
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
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

   public void rechercheCompteOutils() throws ClassCastException, HibernateException, NamingException, JDOMException, IOException {
      this.choix_compte = 2;
      this.planComptable = this.formRecherche.recherchePlanComptable(this.selecFiscalite, this.ecritures.getEcrCompte(), 538, this.selectedExo, 0, this.usersLog.getUsrCptInterdit(), this.optionComptabilite);
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
      if (this.choix_compte == 2) {
         if (this.planComptable != null) {
            this.ecritures.setEcrCompte(this.planComptable.getPlcCompte());
         } else {
            this.ecritures.setEcrCompte("");
         }
      }

      this.var_action = this.var_memo_action;
   }

   public void annulePlanComptable() {
      if (this.choix_compte == 2) {
         this.ecritures.setEcrCompte("");
      }

      this.var_action = this.var_memo_action;
   }

   public void ouvrirPjConsultation() throws HibernateException, NamingException, MalformedURLException, IOException {
      if (this.ecritures == null) {
         this.selectionEcriture();
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
      JournauxComptablesDao var1 = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
      this.lesJournaux = var1.chargerLesJournauxComptables(this.selectedExo.getExecpt_id(), 0, (Session)null);
      if (this.journal != null && !this.journal.isEmpty()) {
         new JournauxComptables();
         JournauxComptables var2;
         if (!this.journal.contains(":")) {
            for(int var3 = 0; var3 < this.lesJournaux.size(); ++var3) {
               var2 = (JournauxComptables)this.lesJournaux.get(var3);
               if (var2.getPljCode().equals(this.journal)) {
                  var2.setSelect(true);
               }
            }
         } else {
            String[] var7 = this.journal.split(":");
            int var4 = var7.length;

            for(int var5 = 0; var5 < var4; ++var5) {
               for(int var6 = 0; var6 < this.lesJournaux.size(); ++var6) {
                  var2 = (JournauxComptables)this.lesJournaux.get(var6);
                  if (var2.getPljCode().equals(var7[var5])) {
                     var2.setSelect(true);
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
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_gene" + File.separator + "extrait_classe";
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
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_gene" + File.separator + "extrait_classe" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
         var1.setEntete("Extrait de classe " + this.inputnum);
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
         var1.setRequete("");
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

   public List grapher() throws HibernateException, NamingException {
      Object var1 = new ArrayList();
      if (this.lesEcritures.size() != 0) {
         if (this.valQteGraph == 0) {
            this.uniteGraph = "CLASSE en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         }

         this.titreGraph = "Analyse de la classe : " + this.inputnum;
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
         } else if (this.modeGraph == 1) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par compte (" + this.uniteGraph + ")";
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
               } else if (this.modeGraph == 1) {
                  var5 = var4.getEcrCompte();
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

   public double getSoldEL() {
      return this.soldEL;
   }

   public void setSoldEL(double var1) {
      this.soldEL = var1;
   }

   public double getSoldENL() {
      return this.soldENL;
   }

   public void setSoldENL(double var1) {
      this.soldENL = var1;
   }

   public double getSoldTE() {
      return this.soldTE;
   }

   public void setSoldTE(double var1) {
      this.soldTE = var1;
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

   public DataModel getDataModelEcritures() {
      return this.dataModelEcritures;
   }

   public void setDataModelEcritures(DataModel var1) {
      this.dataModelEcritures = var1;
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

   public boolean isTestdelettre() {
      return this.testdelettre;
   }

   public void setTestdelettre(boolean var1) {
      this.testdelettre = var1;
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

   public String getClasse() {
      return this.classe;
   }

   public void setClasse(String var1) {
      this.classe = var1;
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

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
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

   public String getAnalytique() {
      return this.analytique;
   }

   public void setAnalytique(String var1) {
      this.analytique = var1;
   }

   public String getDossier() {
      return this.dossier;
   }

   public void setDossier(String var1) {
      this.dossier = var1;
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

   public boolean isTestAffOutilsCorr() {
      return this.testAffOutilsCorr;
   }

   public void setTestAffOutilsCorr(boolean var1) {
      this.testAffOutilsCorr = var1;
   }

   public Activites getActivites() {
      return this.activites;
   }

   public void setActivites(Activites var1) {
      this.activites = var1;
   }

   public boolean isAffiche_activite() {
      return this.affiche_activite;
   }

   public void setAffiche_activite(boolean var1) {
      this.affiche_activite = var1;
   }

   public boolean isAffiche_anal1() {
      return this.affiche_anal1;
   }

   public void setAffiche_anal1(boolean var1) {
      this.affiche_anal1 = var1;
   }

   public boolean isAffiche_anal2() {
      return this.affiche_anal2;
   }

   public void setAffiche_anal2(boolean var1) {
      this.affiche_anal2 = var1;
   }

   public boolean isAffiche_anal3() {
      return this.affiche_anal3;
   }

   public void setAffiche_anal3(boolean var1) {
      this.affiche_anal3 = var1;
   }

   public boolean isAffiche_anal4() {
      return this.affiche_anal4;
   }

   public void setAffiche_anal4(boolean var1) {
      this.affiche_anal4 = var1;
   }

   public boolean isAffiche_atelier() {
      return this.affiche_atelier;
   }

   public void setAffiche_atelier(boolean var1) {
      this.affiche_atelier = var1;
   }

   public boolean isAffiche_departement() {
      return this.affiche_departement;
   }

   public void setAffiche_departement(boolean var1) {
      this.affiche_departement = var1;
   }

   public boolean isAffiche_ligne() {
      return this.affiche_ligne;
   }

   public void setAffiche_ligne(boolean var1) {
      this.affiche_ligne = var1;
   }

   public boolean isAffiche_pdv() {
      return this.affiche_pdv;
   }

   public void setAffiche_pdv(boolean var1) {
      this.affiche_pdv = var1;
   }

   public boolean isAffiche_region() {
      return this.affiche_region;
   }

   public void setAffiche_region(boolean var1) {
      this.affiche_region = var1;
   }

   public boolean isAffiche_secteur() {
      return this.affiche_secteur;
   }

   public void setAffiche_secteur(boolean var1) {
      this.affiche_secteur = var1;
   }

   public boolean isAffiche_service() {
      return this.affiche_service;
   }

   public void setAffiche_service(boolean var1) {
      this.affiche_service = var1;
   }

   public boolean isAffiche_site() {
      return this.affiche_site;
   }

   public void setAffiche_site(boolean var1) {
      this.affiche_site = var1;
   }

   public boolean isAffiche_sitePrdv() {
      return this.affiche_sitePrdv;
   }

   public void setAffiche_sitePrdv(boolean var1) {
      this.affiche_sitePrdv = var1;
   }

   public DataModel getDataModelActivite() {
      return this.dataModelActivite;
   }

   public void setDataModelActivite(DataModel var1) {
      this.dataModelActivite = var1;
   }

   public DataModel getDataModelAgent() {
      return this.dataModelAgent;
   }

   public void setDataModelAgent(DataModel var1) {
      this.dataModelAgent = var1;
   }

   public DataModel getDataModelDetAnalytique() {
      return this.dataModelDetAnalytique;
   }

   public void setDataModelDetAnalytique(DataModel var1) {
      this.dataModelDetAnalytique = var1;
   }

   public DataModel getDataModelDossier() {
      return this.dataModelDossier;
   }

   public void setDataModelDossier(DataModel var1) {
      this.dataModelDossier = var1;
   }

   public DataModel getDataModelParc() {
      return this.dataModelParc;
   }

   public void setDataModelParc(DataModel var1) {
      this.dataModelParc = var1;
   }

   public boolean isDecoupageActivite() {
      return this.decoupageActivite;
   }

   public void setDecoupageActivite(boolean var1) {
      this.decoupageActivite = var1;
   }

   public List getLaColonne1Items() {
      return this.laColonne1Items;
   }

   public void setLaColonne1Items(List var1) {
      this.laColonne1Items = var1;
   }

   public List getLaColonne2Items() {
      return this.laColonne2Items;
   }

   public void setLaColonne2Items(List var1) {
      this.laColonne2Items = var1;
   }

   public List getLaColonne3Items() {
      return this.laColonne3Items;
   }

   public void setLaColonne3Items(List var1) {
      this.laColonne3Items = var1;
   }

   public List getMesClesItems() {
      return this.mesClesItems;
   }

   public void setMesClesItems(List var1) {
      this.mesClesItems = var1;
   }

   public boolean isShowModalPanelActivite() {
      return this.showModalPanelActivite;
   }

   public void setShowModalPanelActivite(boolean var1) {
      this.showModalPanelActivite = var1;
   }

   public boolean isShowModalPanelAnalRecup() {
      return this.showModalPanelAnalRecup;
   }

   public void setShowModalPanelAnalRecup(boolean var1) {
      this.showModalPanelAnalRecup = var1;
   }

   public boolean isShowModalPanelAnalytique() {
      return this.showModalPanelAnalytique;
   }

   public void setShowModalPanelAnalytique(boolean var1) {
      this.showModalPanelAnalytique = var1;
   }

   public boolean isShowModalPanelDossier() {
      return this.showModalPanelDossier;
   }

   public void setShowModalPanelDossier(boolean var1) {
      this.showModalPanelDossier = var1;
   }

   public boolean isShowModalPanelParc() {
      return this.showModalPanelParc;
   }

   public void setShowModalPanelParc(boolean var1) {
      this.showModalPanelParc = var1;
   }

   public boolean isVar_consult_analytique() {
      return this.var_consult_analytique;
   }

   public void setVar_consult_analytique(boolean var1) {
      this.var_consult_analytique = var1;
   }

   public boolean isShowModalPanelModifPiece() {
      return this.showModalPanelModifPiece;
   }

   public void setShowModalPanelModifPiece(boolean var1) {
      this.showModalPanelModifPiece = var1;
   }

   public int getVar_nature_analytique() {
      return this.var_nature_analytique;
   }

   public void setVar_nature_analytique(int var1) {
      this.var_nature_analytique = var1;
   }

   public boolean isVar_valide_analytique() {
      return this.var_valide_analytique;
   }

   public void setVar_valide_analytique(boolean var1) {
      this.var_valide_analytique = var1;
   }

   public double getVar_montant_ligne() {
      return this.var_montant_ligne;
   }

   public void setVar_montant_ligne(double var1) {
      this.var_montant_ligne = var1;
   }

   public double getVar_montant_impute() {
      return this.var_montant_impute;
   }

   public void setVar_montant_impute(double var1) {
      this.var_montant_impute = var1;
   }

   public boolean isVar_affiche_saisie_anal() {
      return this.var_affiche_saisie_anal;
   }

   public void setVar_affiche_saisie_anal(boolean var1) {
      this.var_affiche_saisie_anal = var1;
   }

   public int getVar_axe() {
      return this.var_axe;
   }

   public void setVar_axe(int var1) {
      this.var_axe = var1;
   }

   public String getVar_cle_analytique() {
      return this.var_cle_analytique;
   }

   public void setVar_cle_analytique(String var1) {
      this.var_cle_analytique = var1;
   }

   public double getVar_ecart() {
      return this.var_ecart;
   }

   public void setVar_ecart(double var1) {
      this.var_ecart = var1;
   }

   public String getMessageAlerte() {
      return this.messageAlerte;
   }

   public void setMessageAlerte(String var1) {
      this.messageAlerte = var1;
   }

   public PlanComptable getPlanComptable() {
      return this.planComptable;
   }

   public void setPlanComptable(PlanComptable var1) {
      this.planComptable = var1;
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

   public int getChoixRacine() {
      return this.choixRacine;
   }

   public void setChoixRacine(int var1) {
      this.choixRacine = var1;
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

   public int getOutilChoisi() {
      return this.outilChoisi;
   }

   public void setOutilChoisi(int var1) {
      this.outilChoisi = var1;
   }

   public String getToolsCompteOld() {
      return this.toolsCompteOld;
   }

   public void setToolsCompteOld(String var1) {
      this.toolsCompteOld = var1;
   }

   public boolean isForceVerrou() {
      return this.forceVerrou;
   }

   public void setForceVerrou(boolean var1) {
      this.forceVerrou = var1;
   }

   public DataModel getDataModelEcritureAReimputer() {
      return this.dataModelEcritureAReimputer;
   }

   public void setDataModelEcritureAReimputer(DataModel var1) {
      this.dataModelEcritureAReimputer = var1;
   }

   public boolean isShowModalPanelAnalytiqueCorrection() {
      return this.showModalPanelAnalytiqueCorrection;
   }

   public void setShowModalPanelAnalytiqueCorrection(boolean var1) {
      this.showModalPanelAnalytiqueCorrection = var1;
   }

   public boolean isShowModalPanelCorrection() {
      return this.showModalPanelCorrection;
   }

   public void setShowModalPanelCorrection(boolean var1) {
      this.showModalPanelCorrection = var1;
   }

   public int getChoix_compte() {
      return this.choix_compte;
   }

   public void setChoix_compte(int var1) {
      this.choix_compte = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
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

   public String getNatureJournal() {
      return this.natureJournal;
   }

   public void setNatureJournal(String var1) {
      this.natureJournal = var1;
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
