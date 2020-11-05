package com.epegase.forms.comptabilite;

import com.epegase.systeme.classe.BudgetTresorerie;
import com.epegase.systeme.classe.BudgetTresorerieLigne;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresAnalytique;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.PlansTresorerie;
import com.epegase.systeme.classe.Projets;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.BudgetTresorerieDao;
import com.epegase.systeme.dao.BudgetTresorerieLigneDao;
import com.epegase.systeme.dao.EcrituresAnalytiquesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.PlansTresorerieDao;
import com.epegase.systeme.dao.ProjetsDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.OptionComptabilite;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
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
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class FormExtraitProjet implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action;
   private String pageIndex;
   private int nature;
   private OptionComptabilite optionComptabilite;
   private ExercicesComptable selectedExo;
   private ExercicesComptable lastExo;
   private int var_nb_max = 100;
   private String classe;
   private String periode;
   private String inputnum = "";
   private UtilDate utilDate = new UtilDate();
   private double totalBudget = 0.0D;
   private double totalRealise = 0.0D;
   private double totalEcart = 0.0D;
   private boolean testdeliste = true;
   private boolean testdelettre = true;
   private boolean testequilibre = false;
   private boolean var_affiche_bouton = false;
   private boolean comptaProjet;
   private boolean var_visuTrfVrt = false;
   private String var_annee;
   private List mesAnneeItems = new ArrayList();
   private String inputProjet;
   private boolean showModalFind = false;
   private Date dateDebut;
   private Date dateFin;
   private List mesProjetsItems = new ArrayList();
   private Projets projets = new Projets();
   private ProjetsDao projetsDao;
   private PlansTresorerieDao plansTresorerieDao;
   private BudgetTresorerie budgetTresorerie;
   private BudgetTresorerieDao budgetTresorerieDao;
   private List lesBudgets = new ArrayList();
   private transient DataModel dataModelLesBudgets = new ListDataModel();
   private BudgetTresorerieLigne budgetTresorerieLigne;
   private BudgetTresorerieLigneDao budgetTresorerieLigneDao;
   private List lesBudgetsLigne;
   private transient DataModel dataModelLesBudgetsLigne;
   private Ecritures ecritures;
   private EcrituresAnalytique ecrituresAnalytique;
   private EcrituresDao ecrituresDao;
   private EcrituresAnalytiquesDao ecrituresAnalytiquesDao;
   private List lesEcritures = new ArrayList();
   private List lesEcrituresAnalytique = new ArrayList();
   private transient DataModel dataModelDetailPiece = new ListDataModel();
   private boolean showModalPanelDetailPiece = false;
   private boolean showModalPanelDetailPieceAnal = false;
   private double var_tot_debit;
   private double var_tot_credit;
   private double var_solde;
   private double var_montant;
   private List lesModelsimpression = new ArrayList();
   private boolean showModalPanelPrint = false;
   private List lesModelesAutorises;
   private int choixRacine;
   private String selecFiscalite;
   private boolean showModalPanelInformation = false;
   private String nomCreation;
   private String nomModification;

   public void InstancesDaoUtilses() {
      this.ecrituresDao = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresAnalytiquesDao = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.projetsDao = new ProjetsDao(this.baseLog, this.utilInitHibernate);
      this.plansTresorerieDao = new PlansTresorerieDao(this.baseLog, this.utilInitHibernate);
      this.budgetTresorerieDao = new BudgetTresorerieDao(this.baseLog, this.utilInitHibernate);
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

      this.comptaProjet = this.rechercheModule(40300);
      this.selecFiscalite = this.structureLog.getStrzonefiscale();
      if (this.structureLog.getStrzonefiscale2() != null && !this.structureLog.getStrzonefiscale2().isEmpty()) {
         this.selecFiscalite = null;
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

   public void trouverProjet() throws HibernateException, NamingException {
      this.mesProjetsItems.clear();
      this.mesProjetsItems = this.projetsDao.chargerLesProjets(0, (Session)null);
      this.showModalFind = true;
   }

   public void calculAnneeProjet() throws HibernateException, NamingException {
      this.mesAnneeItems.clear();
      if (this.inputProjet != null && !this.inputProjet.isEmpty() && this.inputProjet.contains(":")) {
         String[] var1 = this.inputProjet.split(":");
         this.projets = this.projetsDao.chargerLeProjet(0, var1[0], (Session)null);
         if (this.projets != null) {
            this.mesAnneeItems = new ArrayList();
            int var2 = this.projets.getProDateDebut().getYear() + 1900;
            int var3 = this.projets.getProDateFin().getYear() + 1900;
            String var4 = "";
            if (!this.projets.getProDateEcheanceDeb().contains(":")) {
               this.mesAnneeItems.add(new SelectItem(this.projets.getProDateDebut() + ":" + this.projets.getProDateEcheanceFin()));
            } else {
               String[] var5 = this.projets.getProDateEcheanceDeb().split(":");
               String[] var6 = this.projets.getProDateEcheanceFin().split(":");

               for(int var7 = 0; var7 < var5.length; ++var7) {
                  String var8 = var5[var7];
                  if (var8 == null || var8.isEmpty()) {
                     var8 = null;
                  }

                  String var9 = var8;
                  var8 = var6[var7];
                  if (var8 == null || var8.isEmpty()) {
                     var8 = null;
                  }

                  this.mesAnneeItems.add(new SelectItem(var9 + ":" + var8));
               }

               this.mesAnneeItems.add(new SelectItem("Toutes les périodes"));
            }
         }
      }

   }

   public void annuleRecherche() {
      this.showModalFind = false;
   }

   public void chargerEcritures() throws HibernateException, NamingException, ParseException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Budget");
      new ArrayList();
      new ArrayList();
      if (this.var_annee != null) {
         String[] var4;
         if (this.var_annee.contains(":")) {
            var4 = this.var_annee.split(":");
            this.dateDebut = this.utilDate.stringToDateSQLLight(var4[0]);
            this.dateFin = this.utilDate.stringToDateSQLLight(var4[1]);
         } else {
            var4 = this.inputProjet.split(":");
            this.projets = this.projetsDao.chargerLeProjet(0, var4[0], var1);
            if (this.projets != null) {
               this.dateDebut = this.projets.getProDateDebut();
               this.dateFin = this.projets.getProDateFin();
            } else {
               this.dateDebut = this.selectedExo.getExecptDateDebut();
               this.dateFin = this.selectedExo.getExecptDateFin();
            }
         }

         this.periode = "PERIODE du " + this.utilDate.dateToStringFr(this.dateDebut) + " au " + this.utilDate.dateToStringFr(this.dateFin);
         List var3 = this.plansTresorerieDao.chargerLesPlansTresorerie(this.selectedExo.getExecpt_id(), "", this.inputProjet, this.var_visuTrfVrt, var1);
         List var2 = this.budgetTresorerieDao.chargerLesBudgetTresoreries(this.inputProjet, "", "", this.var_visuTrfVrt, var1);
         this.lesBudgets = new ArrayList();
         this.dataModelLesBudgets = new ListDataModel();
         if (var3.size() != 0) {
            for(int var9 = 0; var9 < var3.size(); ++var9) {
               new PlansTresorerie();
               PlansTresorerie var5 = (PlansTresorerie)var3.get(var9);
               if (var2.size() == 0) {
                  BudgetTresorerie var10 = new BudgetTresorerie();
                  var10.setBudAnnee(var5.getTreAnnee());
                  var10.setBudCode(var5.getTreCode());
                  var10.setBudLibelleFr(var5.getTreLibelleFr());
                  var10.setBudLibelleSp(var5.getTreLibelleSp());
                  var10.setBudLibelleUk(var5.getTreLibelleUk());
                  var10.setBudSens(var5.getTreType());
                  var10.setMontant(0.0D);
                  var10.setBudProjet(var5.getTreProjet());
                  var10.setBudUtil(0);
                  var10.setVarBudget(this.calculBudget(var10, var1));
                  var10.setVarRealise(this.calculRealise(var10, var1));
                  var10.setVarEcart(var10.getVarBudget() - var10.getVarRealise());
                  var10.setExercicescomptable(this.selectedExo);
                  this.lesBudgets.add(var10);
               } else {
                  boolean var6 = false;

                  for(int var7 = 0; var7 < var2.size(); ++var7) {
                     new BudgetTresorerie();
                     BudgetTresorerie var8 = (BudgetTresorerie)var2.get(var7);
                     if (var5.getTreCode().equalsIgnoreCase(var8.getBudCode())) {
                        var8.setVarBudget(this.calculBudget(var8, var1));
                        var8.setVarRealise(this.calculRealise(var8, var1));
                        var8.setVarEcart(var8.getVarBudget() - var8.getVarRealise());
                        var6 = true;
                        this.lesBudgets.add(var8);
                        break;
                     }
                  }

                  if (!var6) {
                     BudgetTresorerie var11 = new BudgetTresorerie();
                     var11.setBudAnnee(var5.getTreAnnee());
                     var11.setBudCode(var5.getTreCode());
                     var11.setBudLibelleFr(var5.getTreLibelleFr());
                     var11.setBudLibelleSp(var5.getTreLibelleSp());
                     var11.setBudLibelleUk(var5.getTreLibelleUk());
                     var11.setBudSens(var5.getTreType());
                     var11.setMontant(0.0D);
                     var11.setBudProjet(var5.getTreProjet());
                     var11.setBudUtil(0);
                     var11.setVarBudget(this.calculBudget(var11, var1));
                     var11.setVarRealise(this.calculRealise(var11, var1));
                     var11.setVarEcart(var11.getVarBudget() - var11.getVarRealise());
                     var11.setExercicescomptable(this.selectedExo);
                     this.lesBudgets.add(var11);
                  }
               }
            }
         }
      }

      this.dataModelLesBudgets.setWrappedData(this.lesBudgets);
      this.calculerTotaux();
      this.utilInitHibernate.closeSession();
      this.var_affiche_bouton = false;
      this.showModalFind = false;
   }

   public double calculBudget(BudgetTresorerie var1, Session var2) throws HibernateException, NamingException {
      double var3 = 0.0D;
      if (this.var_annee.equals("Toutes les périodes")) {
         new ArrayList();
         List var5 = this.budgetTresorerieDao.chargerLesBudgetTresoreries(this.inputProjet, "", "", this.var_visuTrfVrt, var2);
         if (var5.size() != 0) {
            for(int var6 = 0; var6 < var5.size(); ++var6) {
               this.budgetTresorerie = (BudgetTresorerie)var5.get(var6);
               if (var1.getBudCode().equals(this.budgetTresorerie.getBudCode())) {
                  var3 = var3 + var1.getBud01TotVal() + var1.getBud02TotVal() + var1.getBud03TotVal() + var1.getBud04TotVal();
               }
            }
         }
      } else {
         var3 = var3 + var1.getBud01TotVal() + var1.getBud02TotVal() + var1.getBud03TotVal() + var1.getBud04TotVal();
      }

      return var3;
   }

   public double calculRealise(BudgetTresorerie var1, Session var2) throws HibernateException, NamingException {
      double var3 = 0.0D;
      String var5 = var1.getBudCode();
      String var6 = var1.getBudProjet();
      if (var6 != null && var6.contains(":")) {
         String[] var7 = var6.split(":");
         var6 = var7[0];
      }

      String var11 = this.utilDate.dateToStringSQLLight(this.dateDebut);
      String var8 = this.utilDate.dateToStringSQLLight(this.dateFin);
      new ArrayList();
      List var9 = this.ecrituresDao.chargerEcrituresProjet(var11, var8, var5, var6, var2);
      if (var9.size() != 0) {
         for(int var10 = 0; var10 < var9.size(); ++var10) {
            var3 += ((Ecritures)var9.get(var10)).getEcrDebitPays() - ((Ecritures)var9.get(var10)).getEcrCreditPays();
         }
      } else {
         var3 = 0.0D;
      }

      var3 = Math.abs(var3);
      return var3;
   }

   public void calculerTotaux() {
      this.totalBudget = 0.0D;
      this.totalRealise = 0.0D;
      this.totalEcart = 0.0D;
      this.testdeliste = true;
      if (this.lesBudgets.size() != 0) {
         this.testdeliste = false;

         for(int var1 = 0; var1 < this.lesBudgets.size(); ++var1) {
            BudgetTresorerie var2 = (BudgetTresorerie)this.lesBudgets.get(var1);
            this.totalBudget += var2.getVarBudget();
            this.totalRealise += var2.getVarRealise();
         }
      }

      this.totalEcart = this.totalBudget - this.totalRealise;
   }

   public void selectionPoste() {
      if (this.dataModelLesBudgets.isRowAvailable()) {
         this.budgetTresorerie = (BudgetTresorerie)this.dataModelLesBudgets.getRowData();
         this.var_affiche_bouton = true;
      }

   }

   public void visualisationPoste() throws HibernateException, NamingException {
      if (this.budgetTresorerie != null) {
         this.var_tot_debit = 0.0D;
         this.var_tot_credit = 0.0D;
         this.var_montant = 0.0D;
         this.var_solde = 0.0D;
         String var1 = this.budgetTresorerie.getBudCode();
         String var2 = this.budgetTresorerie.getBudProjet();
         if (var2 != null && var2.contains(":")) {
            String[] var3 = var2.split(":");
            var2 = var3[0];
         }

         String var6 = this.utilDate.dateToStringSQLLight(this.dateDebut);
         String var4 = this.utilDate.dateToStringSQLLight(this.dateFin);
         this.lesEcritures.clear();
         this.lesEcritures = this.ecrituresDao.chargerEcrituresProjet(var6, var4, var1, var2, (Session)null);
         if (this.lesEcritures.size() != 0) {
            for(int var5 = 0; var5 < this.lesEcritures.size(); ++var5) {
               this.var_tot_debit += ((Ecritures)this.lesEcritures.get(var5)).getEcrDebitPays();
               this.var_tot_credit += ((Ecritures)this.lesEcritures.get(var5)).getEcrCreditPays();
            }
         }

         this.var_solde = this.var_tot_debit - this.var_tot_credit;
         this.var_solde = Math.abs(this.var_solde);
         this.dataModelDetailPiece.setWrappedData(this.lesEcritures);
         this.showModalPanelDetailPiece = true;
      }

   }

   public void fermerDetailPoste() {
      this.showModalPanelDetailPiece = false;
      this.showModalPanelDetailPieceAnal = false;
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
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_projet" + File.separator + "extrait_projet";
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
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_projet" + File.separator + "extrait_projet" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
         var1.setEntete("Extrait du projet " + this.inputProjet);
         SimpleDateFormat var11 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);
         String var12 = var11.format(this.dateDebut);
         String var13 = var11.format(this.dateFin);
         String var14 = this.utilDate.dateToStringSQLLight(this.dateDebut);
         String var15 = this.utilDate.dateToStringSQLLight(this.dateFin);
         String var16 = "";
         if (this.inputProjet != null && !this.inputProjet.isEmpty() && this.inputProjet.contains(":")) {
            String[] var17 = this.inputProjet.split(":");
            var16 = var17[0];
         }

         String var25 = "";
         var25 = "Toutes les écritures";
         var1.setFiltre(var25 + " du " + var12 + " au " + var13);
         var1.setRequete("");
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataireCC(var8);
         var1.setDestinataireCCI(var9);
         var1.setCorpsMail(var10);
         var1.setTiersSelectionne((Tiers)null);
         JRBeanCollectionDataSource var18 = null;
         if (!var4.contains("Detail")) {
            var18 = new JRBeanCollectionDataSource(this.lesBudgets);
         } else {
            ArrayList var19 = new ArrayList();
            new ArrayList();
            List var20 = this.ecrituresDao.chargerEcrituresProjet(var14, var15, var16, (Session)null);
            if (this.lesBudgets.size() != 0) {
               for(int var21 = 0; var21 < this.lesBudgets.size(); ++var21) {
                  this.budgetTresorerie = (BudgetTresorerie)this.lesBudgets.get(var21);
                  String var22 = this.budgetTresorerie.getBudCode();
                  this.budgetTresorerie.setEcrAnaActif(0);
                  this.budgetTresorerie.setEcrBudgetTreso("");
                  this.budgetTresorerie.setEcrCloture(0);
                  this.budgetTresorerie.setEcrCode("");
                  this.budgetTresorerie.setEcrCoefEuro(0.0F);
                  this.budgetTresorerie.setEcrCoefGrp(0.0F);
                  this.budgetTresorerie.setEcrCoefPays(0.0F);
                  this.budgetTresorerie.setEcrCompte("");
                  this.budgetTresorerie.setEcrContrePartie("");
                  this.budgetTresorerie.setEcrCreditEuro(0.0D);
                  this.budgetTresorerie.setEcrCreditGrp(0.0D);
                  this.budgetTresorerie.setEcrCreditPays(0.0D);
                  this.budgetTresorerie.setEcrCreditSaisie(0.0D);
                  this.budgetTresorerie.setEcrDateEcheance((Date)null);
                  this.budgetTresorerie.setEcrDatePaiement((Date)null);
                  this.budgetTresorerie.setEcrDateSaisie((Date)null);
                  this.budgetTresorerie.setEcrDateValeurReelle((Date)null);
                  this.budgetTresorerie.setEcrDateValeurTheo((Date)null);
                  this.budgetTresorerie.setEcrDebitEuro(0.0D);
                  this.budgetTresorerie.setEcrDebitGrp(0.0D);
                  this.budgetTresorerie.setEcrDebitPays(0.0D);
                  this.budgetTresorerie.setEcrDebitSaisie(0.0D);
                  this.budgetTresorerie.setEcrDeviseSaisie("");
                  this.budgetTresorerie.setEcrEtat(0);
                  this.budgetTresorerie.setEcrLettrage("");
                  this.budgetTresorerie.setEcrLibCompte("");
                  this.budgetTresorerie.setEcrLibelle("");
                  this.budgetTresorerie.setEcrNature(0);
                  this.budgetTresorerie.setEcrNatureJrx(0);
                  this.budgetTresorerie.setEcrNumIf("");
                  this.budgetTresorerie.setEcrNumTrf("");
                  this.budgetTresorerie.setEcrOrdre(0L);
                  this.budgetTresorerie.setEcrOrigineBanque(0);
                  this.budgetTresorerie.setEcrPeriode("");
                  this.budgetTresorerie.setEcrPiece("");
                  this.budgetTresorerie.setEcrPointage("");
                  this.budgetTresorerie.setEcrPosteTreso("");
                  this.budgetTresorerie.setEcrRapprochement("");
                  this.budgetTresorerie.setEcrReference1("");
                  this.budgetTresorerie.setEcrReference2("");
                  this.budgetTresorerie.setEcrReserve(0);
                  this.budgetTresorerie.setEcrTreso("");
                  var19.add(this.budgetTresorerie);
                  if (this.budgetTresorerie.getBudSens() <= 1) {
                     new Ecritures();

                     for(int var24 = 0; var24 < var20.size(); ++var24) {
                        Ecritures var23 = (Ecritures)var20.get(var24);
                        if (var23.getEcrPosteTreso().equals(var22)) {
                           this.budgetTresorerie = new BudgetTresorerie();
                           this.budgetTresorerie.setBudSens(3);
                           this.budgetTresorerie.setEcrAnaActif(var23.getEcrAnaActif());
                           this.budgetTresorerie.setEcrBudgetTreso(var23.getEcrBudgetTreso());
                           this.budgetTresorerie.setEcrCloture(var23.getEcrCloture());
                           this.budgetTresorerie.setEcrCode(var23.getEcrCode());
                           this.budgetTresorerie.setEcrCoefEuro(var23.getEcrCoefEuro());
                           this.budgetTresorerie.setEcrCoefGrp(var23.getEcrCoefGrp());
                           this.budgetTresorerie.setEcrCoefPays(var23.getEcrCoefPays());
                           this.budgetTresorerie.setEcrCompte(var23.getEcrCompte());
                           this.budgetTresorerie.setEcrContrePartie(var23.getEcrContrePartie());
                           this.budgetTresorerie.setEcrCreditEuro(var23.getEcrCreditEuro());
                           this.budgetTresorerie.setEcrCreditGrp(var23.getEcrCreditGrp());
                           this.budgetTresorerie.setEcrCreditPays(var23.getEcrCreditPays());
                           this.budgetTresorerie.setEcrCreditSaisie(var23.getEcrCreditSaisie());
                           this.budgetTresorerie.setEcrDateEcheance(var23.getEcrDateEcheance());
                           this.budgetTresorerie.setEcrDatePaiement(var23.getEcrDatePaiement());
                           this.budgetTresorerie.setEcrDateSaisie(var23.getEcrDateSaisie());
                           this.budgetTresorerie.setEcrDateValeurReelle(var23.getEcrDateValeurReelle());
                           this.budgetTresorerie.setEcrDateValeurTheo(var23.getEcrDateValeurTheo());
                           this.budgetTresorerie.setEcrDebitEuro(var23.getEcrDebitEuro());
                           this.budgetTresorerie.setEcrDebitGrp(var23.getEcrDebitGrp());
                           this.budgetTresorerie.setEcrDebitPays(var23.getEcrDebitPays());
                           this.budgetTresorerie.setEcrDebitSaisie(var23.getEcrDebitSaisie());
                           this.budgetTresorerie.setEcrDeviseSaisie(var23.getEcrDeviseSaisie());
                           this.budgetTresorerie.setEcrEtat(var23.getEcrEtat());
                           this.budgetTresorerie.setEcrLettrage(var23.getEcrLettrage());
                           this.budgetTresorerie.setEcrLibCompte(var23.getEcrLibCompte());
                           this.budgetTresorerie.setEcrLibelle(var23.getEcrLibelle());
                           this.budgetTresorerie.setEcrNature(var23.getEcrNature());
                           this.budgetTresorerie.setEcrNatureJrx(var23.getEcrNatureJrx());
                           this.budgetTresorerie.setEcrNumIf(var23.getEcrNumIf());
                           this.budgetTresorerie.setEcrNumTrf(var23.getEcrNumTrf());
                           this.budgetTresorerie.setEcrOrdre(var23.getEcrOrdre());
                           this.budgetTresorerie.setEcrOrigineBanque(var23.getEcrOrigineBanque());
                           this.budgetTresorerie.setEcrPeriode(var23.getEcrPeriode());
                           this.budgetTresorerie.setEcrPiece(var23.getEcrPiece());
                           this.budgetTresorerie.setEcrPointage(var23.getEcrPointage());
                           this.budgetTresorerie.setEcrPosteTreso(var23.getEcrPosteTreso());
                           this.budgetTresorerie.setEcrRapprochement(var23.getEcrRapprochement());
                           this.budgetTresorerie.setEcrReference1(var23.getEcrReference1());
                           this.budgetTresorerie.setEcrReference2(var23.getEcrReference2());
                           this.budgetTresorerie.setEcrReserve(var23.getEcrReserve());
                           this.budgetTresorerie.setEcrTreso(var23.getEcrTreso());
                           var19.add(this.budgetTresorerie);
                        }
                     }
                  }
               }
            }

            var18 = new JRBeanCollectionDataSource(var19);
         }

         var1.setjRBeanCollectionDataSource(var18);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

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

   public String getInputnum() {
      return this.inputnum;
   }

   public void setInputnum(String var1) {
      this.inputnum = var1;
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

   public boolean isTestdelettre() {
      return this.testdelettre;
   }

   public void setTestdelettre(boolean var1) {
      this.testdelettre = var1;
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

   public DataModel getDataModelDetailPiece() {
      return this.dataModelDetailPiece;
   }

   public void setDataModelDetailPiece(DataModel var1) {
      this.dataModelDetailPiece = var1;
   }

   public boolean isShowModalPanelDetailPiece() {
      return this.showModalPanelDetailPiece;
   }

   public void setShowModalPanelDetailPiece(boolean var1) {
      this.showModalPanelDetailPiece = var1;
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

   public List getMesProjetsItems() {
      return this.mesProjetsItems;
   }

   public void setMesProjetsItems(List var1) {
      this.mesProjetsItems = var1;
   }

   public String getInputProjet() {
      return this.inputProjet;
   }

   public void setInputProjet(String var1) {
      this.inputProjet = var1;
   }

   public DataModel getDataModelLesBudgets() {
      return this.dataModelLesBudgets;
   }

   public void setDataModelLesBudgets(DataModel var1) {
      this.dataModelLesBudgets = var1;
   }

   public DataModel getDataModelLesBudgetsLigne() {
      return this.dataModelLesBudgetsLigne;
   }

   public void setDataModelLesBudgetsLigne(DataModel var1) {
      this.dataModelLesBudgetsLigne = var1;
   }

   public List getMesAnneeItems() {
      return this.mesAnneeItems;
   }

   public void setMesAnneeItems(List var1) {
      this.mesAnneeItems = var1;
   }

   public String getVar_annee() {
      return this.var_annee;
   }

   public void setVar_annee(String var1) {
      this.var_annee = var1;
   }

   public double getTotalBudget() {
      return this.totalBudget;
   }

   public void setTotalBudget(double var1) {
      this.totalBudget = var1;
   }

   public double getTotalEcart() {
      return this.totalEcart;
   }

   public void setTotalEcart(double var1) {
      this.totalEcart = var1;
   }

   public double getTotalRealise() {
      return this.totalRealise;
   }

   public void setTotalRealise(double var1) {
      this.totalRealise = var1;
   }

   public BudgetTresorerie getBudgetTresorerie() {
      return this.budgetTresorerie;
   }

   public void setBudgetTresorerie(BudgetTresorerie var1) {
      this.budgetTresorerie = var1;
   }

   public boolean isVar_visuTrfVrt() {
      return this.var_visuTrfVrt;
   }

   public void setVar_visuTrfVrt(boolean var1) {
      this.var_visuTrfVrt = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public boolean isComptaProjet() {
      return this.comptaProjet;
   }

   public void setComptaProjet(boolean var1) {
      this.comptaProjet = var1;
   }

   public boolean isShowModalPanelDetailPieceAnal() {
      return this.showModalPanelDetailPieceAnal;
   }

   public void setShowModalPanelDetailPieceAnal(boolean var1) {
      this.showModalPanelDetailPieceAnal = var1;
   }

   public List getLesModelesAutorises() {
      return this.lesModelesAutorises;
   }

   public void setLesModelesAutorises(List var1) {
      this.lesModelesAutorises = var1;
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
}
