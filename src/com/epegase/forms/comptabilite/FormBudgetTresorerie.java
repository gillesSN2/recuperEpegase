package com.epegase.forms.comptabilite;

import com.epegase.systeme.classe.Activites;
import com.epegase.systeme.classe.BudgetTresorerie;
import com.epegase.systeme.classe.BudgetTresorerieLigne;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.PlansTresorerie;
import com.epegase.systeme.classe.Projets;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.LigneDocument;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.BudgetTresorerieDao;
import com.epegase.systeme.dao.BudgetTresorerieLigneDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.PlansTresorerieDao;
import com.epegase.systeme.dao.ProjetsDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.OptionComptabilite;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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

public class FormBudgetTresorerie implements Serializable {
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
   private BudgetTresorerie budgetTresorerie = new BudgetTresorerie();
   private BudgetTresorerieDao budgetTresorerieDao;
   private List lesBudgets = new ArrayList();
   private transient DataModel dataModelLesBudgets = new ListDataModel();
   private BudgetTresorerieLigne budgetTresorerieLigne = new BudgetTresorerieLigne();
   private BudgetTresorerieLigneDao budgetTresorerieLigneDao;
   private List lesBudgetsLigne = new ArrayList();
   private transient DataModel dataModelLesBudgetsLigne = new ListDataModel();
   private List lesexercicesItem = new ArrayList();
   private String var_choix_reamenagement = "0";
   private boolean budtestDupliquer;
   private boolean testaffSupp = false;
   private int typeDuplication;
   private boolean testDuplicReam = false;
   private boolean testDuplicAnnee = false;
   private boolean testDuplicReamEtAnnee = true;
   private boolean disableButton;
   private PlansTresorerieDao plansTresorerieDao;
   private boolean testactivite = false;
   private boolean showModalPanelSaisie = false;
   private List listPlanBudget = new ArrayList();
   private List listBudget = new ArrayList();
   private String var_annee;
   private List mesAnneeItems;
   private String var_activite;
   private boolean showButtonPanel = false;
   private boolean showButtonRec = false;
   private boolean showModalPanelDetail = false;
   private List lesActivites = new ArrayList();
   private boolean affiche_activite = false;
   private boolean mode_calcul = false;
   private ActivitesDao activitesDao;
   private double var_montant_impute;
   private double var_montant_restant;
   private String var_activite_select;
   private double var_activite_montant;
   private List mesActivitesItems = new ArrayList();
   private int selectionSaisie;
   private int selectionModeSaisie;
   private List listeSasieValeurDetail = new ArrayList();
   private boolean showModalPanelSaisieValeurDetail = false;
   private double var_total_imput;
   private double var_ecart_imput;
   private boolean var_valide_valeur = false;
   private boolean var_valide_ligne = false;
   private boolean showModalPanelModif = false;
   private double montantTotal = 0.0D;
   private double val01 = 0.0D;
   private double val02 = 0.0D;
   private double val03 = 0.0D;
   private double val04 = 0.0D;
   private double val05 = 0.0D;
   private double val06 = 0.0D;
   private double val07 = 0.0D;
   private double val08 = 0.0D;
   private double val09 = 0.0D;
   private double val10 = 0.0D;
   private double val11 = 0.0D;
   private double val12 = 0.0D;
   private boolean projetPresent = false;
   private List mesProjetsItems = new ArrayList();
   private ProjetsDao projetsDao;
   private String var_projet;
   private UtilDate utilDate = new UtilDate();
   private List lesModelsimpression = new ArrayList();
   private boolean showModalPanelPrint = false;
   private boolean aff_janvier = false;
   private boolean aff_fevrier = false;
   private boolean aff_mars = false;
   private boolean aff_avril = false;
   private boolean aff_mai = false;
   private boolean aff_juin = false;
   private boolean aff_juillet = false;
   private boolean aff_aout = false;
   private boolean aff_septembre = false;
   private boolean aff_octobre = false;
   private boolean aff_novembre = false;
   private boolean aff_decembre = false;
   private String lib_janvier;
   private String lib_fevrier;
   private String lib_mars;
   private String lib_avril;
   private String lib_mai;
   private String lib_juin;
   private String lib_juillet;
   private String lib_aout;
   private String lib_septembre;
   private String lib_octobre;
   private String lib_novembre;
   private String lib_decembre;
   private List lesModelesAutorises;

   public FormBudgetTresorerie() throws IOException {
   }

   public void InstancesDaoUtilses() {
      this.budgetTresorerieDao = new BudgetTresorerieDao(this.baseLog, this.utilInitHibernate);
      this.budgetTresorerieLigneDao = new BudgetTresorerieLigneDao(this.baseLog, this.utilInitHibernate);
      this.plansTresorerieDao = new PlansTresorerieDao(this.baseLog, this.utilInitHibernate);
      this.activitesDao = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      this.projetsDao = new ProjetsDao(this.baseLog, this.utilInitHibernate);
   }

   public void initAnalytique(Session var1) throws HibernateException, NamingException {
      if (this.optionComptabilite.getNbLigneMaxBu() != null && !this.optionComptabilite.getNbLigneMaxBu().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionComptabilite.getNbLigneMaxBu());
      } else {
         this.var_nb_max = 100;
      }

      this.testactivite = this.structureLog.isStrActivite();
      if (this.testactivite) {
         this.mesActivitesItems = this.activitesDao.chargerLesActivites(var1);
         if (this.mesActivitesItems.size() == 0) {
            this.testactivite = false;
         }
      } else {
         this.mesActivitesItems.clear();
      }

      this.projetPresent = this.rechercheModule(40300);
   }

   public void calculAnnee() throws HibernateException, NamingException {
      this.mesAnneeItems = new ArrayList();
      ExercicesComptableDao var1 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var2 = var1.selectExercicesCompta((Session)null);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.mesAnneeItems.add(new SelectItem(((ExercicesComptable)var2.get(var3)).getExecpt_id()));
            if (((ExercicesComptable)var2.get(var3)).getExecpt_id() != (long)(((ExercicesComptable)var2.get(var3)).getExecptDateFin().getYear() + 1900)) {
               long var4 = (long)(((ExercicesComptable)var2.get(var3)).getExecptDateFin().getYear() + 1900) - ((ExercicesComptable)var2.get(var3)).getExecpt_id();

               for(int var6 = 0; (long)var6 < var4; ++var6) {
                  this.mesAnneeItems.add(new SelectItem(((ExercicesComptable)var2.get(var3)).getExecpt_id() + (long)(var6 + 1)));
               }
            }
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

   public void calculAnneeProjet() throws HibernateException, NamingException, ParseException {
      if (this.var_projet != null && !this.var_projet.isEmpty() && this.var_projet.contains(":")) {
         String[] var1 = this.var_projet.split(":");
         new Projets();
         Projets var2 = this.projetsDao.chargerLeProjet(0, var1[0], (Session)null);
         if (var2 != null) {
            this.mesAnneeItems = new ArrayList();
            int var3 = var2.getProDateDebut().getYear() + 1900;
            int var4 = var2.getProDateFin().getYear() + 1900;
            String var5 = "";

            for(int var6 = var3; var6 <= var4; ++var6) {
               var5 = "" + var6;
               this.mesAnneeItems.add(new SelectItem(var5));
            }
         }
      }

      this.buttonPanel();
   }

   public void buttonPanel() throws HibernateException, NamingException, ParseException {
      this.mesProjetsItems.clear();
      if (this.var_annee != null && !this.var_annee.isEmpty() && this.var_annee.length() == 4) {
         if (this.projetPresent) {
            this.showButtonRec = true;
            this.chargeProjet();
         } else {
            this.showButtonRec = true;
         }
      } else {
         this.showButtonRec = false;
      }

      this.lesBudgets.clear();
   }

   public void chargeProjet() throws HibernateException, NamingException, ParseException {
      this.mesProjetsItems.clear();
      this.mesProjetsItems = this.projetsDao.chargerLesProjets(0, this.var_annee, (Session)null);
   }

   public void recherche() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Budget");
      this.listPlanBudget.clear();
      this.listPlanBudget = this.plansTresorerieDao.chargerLesPlansTresorerie(this.selectedExo.getExecpt_id(), this.var_annee, this.var_projet, true, var1);
      this.listBudget.clear();
      this.listBudget = this.budgetTresorerieDao.chargerLesBudgetTresoreries(this.var_projet, this.var_annee, this.var_activite, true, var1);
      this.utilInitHibernate.closeSession();
      this.lesBudgets.clear();
      if (this.listPlanBudget.size() != 0) {
         new BudgetTresorerie();

         for(int var3 = 0; var3 < this.listPlanBudget.size(); ++var3) {
            new PlansTresorerie();
            PlansTresorerie var4 = (PlansTresorerie)this.listPlanBudget.get(var3);
            BudgetTresorerie var2;
            if (this.listBudget.size() == 0) {
               var2 = new BudgetTresorerie();
               var2.setBudAnnee(var4.getTreAnnee());
               var2.setBudCode(var4.getTreCode());
               var2.setBudLibelleFr(var4.getTreLibelleFr());
               var2.setBudLibelleSp(var4.getTreLibelleSp());
               var2.setBudLibelleUk(var4.getTreLibelleUk());
               var2.setBudSens(var4.getTreType());
               var2.setMontant(0.0D);
               var2.setBudProjet(var4.getTreProjet());
               var2.setBudUtil(0);
               var2.setExercicescomptable(this.selectedExo);
               this.lesBudgets.add(var2);
            } else {
               boolean var5 = false;

               for(int var6 = 0; var6 < this.listBudget.size(); ++var6) {
                  var2 = (BudgetTresorerie)this.listBudget.get(var6);
                  if (var4.getTreCode().equalsIgnoreCase(var2.getBudCode())) {
                     var5 = true;
                     var2.setChoixReam(Integer.parseInt(this.var_choix_reamenagement));
                     this.lesBudgets.add(var2);
                     break;
                  }
               }

               if (!var5) {
                  var2 = new BudgetTresorerie();
                  var2.setBudAnnee(var4.getTreAnnee());
                  var2.setBudCode(var4.getTreCode());
                  var2.setBudLibelleFr(var4.getTreLibelleFr());
                  var2.setBudLibelleSp(var4.getTreLibelleSp());
                  var2.setBudLibelleUk(var4.getTreLibelleUk());
                  var2.setBudSens(var4.getTreType());
                  var2.setMontant(0.0D);
                  var2.setBudProjet(var4.getTreProjet());
                  var2.setBudUtil(0);
                  var2.setExercicescomptable(this.selectedExo);
                  this.lesBudgets.add(var2);
               }
            }
         }
      }

      this.dataModelLesBudgets.setWrappedData(this.lesBudgets);
      if (this.projetPresent) {
         if (this.var_annee.length() == 4) {
            if (this.var_projet != null && !this.var_projet.isEmpty() && this.var_projet.contains(":")) {
               this.showButtonPanel = true;
            } else {
               this.showButtonPanel = false;
            }
         } else {
            this.showButtonPanel = false;
         }
      } else if (this.var_annee.length() == 4) {
         this.showButtonPanel = true;
      } else {
         this.showButtonPanel = false;
      }

   }

   public void modifierBudget() {
      this.budgetTresorerieLigne = new BudgetTresorerieLigne();
      if (this.budgetTresorerie != null) {
         if (this.var_choix_reamenagement.equals("0")) {
            this.montantTotal = this.budgetTresorerie.getBud01TotVal();
         } else if (this.var_choix_reamenagement.equals("1")) {
            this.montantTotal = this.budgetTresorerie.getBud02TotVal();
         } else if (this.var_choix_reamenagement.equals("2")) {
            this.montantTotal = this.budgetTresorerie.getBud03TotVal();
         } else if (this.var_choix_reamenagement.equals("3")) {
            this.montantTotal = this.budgetTresorerie.getBud04TotVal();
         }

         this.showModalPanelSaisie = true;
      }

   }

   public void supprimerBudget() throws HibernateException, NamingException {
      if (this.lesBudgets.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Budget");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            new BudgetTresorerie();

            for(int var4 = 0; var4 < this.lesBudgets.size(); ++var4) {
               BudgetTresorerie var3 = (BudgetTresorerie)this.lesBudgets.get(var4);
               var3 = this.budgetTresorerieDao.rechercheBudgetTresorerie(var3.getBud_id(), var1);
               if (var3 != null) {
                  this.lesBudgetsLigne.clear();
                  this.lesBudgetsLigne = this.budgetTresorerieLigneDao.chargerLigneBudgetTresorerie(var3, var1);
                  if (this.lesBudgetsLigne.size() != 0) {
                     this.budgetTresorerieLigne = new BudgetTresorerieLigne();
                     this.budgetTresorerieLigne = (BudgetTresorerieLigne)this.lesBudgetsLigne.get(var4);
                     this.budgetTresorerieLigneDao.delete(this.budgetTresorerieLigne, var1);
                     var1.flush();
                  }

                  this.budgetTresorerieDao.delete(var3, var1);
                  var1.flush();
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
      }

   }

   public void duppliquerBudget() {
      if (this.lesBudgets.size() != 0) {
      }

   }

   public void selectionBudget() throws HibernateException, NamingException {
      if (this.dataModelLesBudgets.isRowAvailable()) {
         this.budgetTresorerie = (BudgetTresorerie)this.dataModelLesBudgets.getRowData();
         if (this.budgetTresorerie.getBudSens() <= 1) {
            this.budgetTresorerie.setBudUtil(Integer.parseInt(this.var_choix_reamenagement));
            this.lesBudgetsLigne.clear();
            this.lesBudgetsLigne = this.budgetTresorerieLigneDao.chargerLigneBudgetTresorerie(this.budgetTresorerie, (Session)null);
            this.dataModelLesBudgetsLigne.setWrappedData(this.lesBudgetsLigne);
            this.testaffSupp = true;
            if (this.projetPresent && this.budgetTresorerie.getBudProjet() != null && !this.budgetTresorerie.getBudProjet().isEmpty()) {
               this.aff_janvier = false;
               this.aff_fevrier = false;
               this.aff_mars = false;
               this.aff_avril = false;
               this.aff_mai = false;
               this.aff_juin = false;
               this.aff_juillet = false;
               this.aff_aout = false;
               this.aff_septembre = false;
               this.aff_octobre = false;
               this.aff_novembre = false;
               this.aff_decembre = false;
               this.lib_janvier = "";
               this.lib_fevrier = "";
               this.lib_mars = "";
               this.lib_avril = "";
               this.lib_mai = "";
               this.lib_juin = "";
               this.lib_juillet = "";
               this.lib_aout = "";
               this.lib_septembre = "";
               this.lib_octobre = "";
               this.lib_novembre = "";
               this.lib_decembre = "";
               new Projets();
               Projets var1 = this.projetsDao.chargerLeProjet(0, this.budgetTresorerie.getBudProjet(), (Session)null);
               if (var1 != null && var1.getProDateEcheanceDeb() != null && !var1.getProDateEcheanceDeb().isEmpty()) {
                  if (!var1.getProDateEcheanceDeb().contains(":")) {
                     this.aff_janvier = true;
                  } else {
                     String[] var2 = var1.getProDateEcheanceDeb().split(":");

                     for(int var3 = 0; var3 < var2.length; ++var3) {
                        if (var3 == 0) {
                           this.aff_janvier = true;
                           this.lib_janvier = "Tranche 1";
                        } else if (var3 == 1) {
                           this.aff_fevrier = true;
                           this.lib_fevrier = "Tranche 2";
                        } else if (var3 == 2) {
                           this.aff_mars = true;
                           this.lib_mars = "Tranche 3";
                        } else if (var3 == 3) {
                           this.aff_avril = true;
                           this.lib_avril = "Tranche 4";
                        } else if (var3 == 4) {
                           this.aff_mai = true;
                           this.lib_mai = "Tranche 5";
                        } else if (var3 == 5) {
                           this.aff_juin = true;
                           this.lib_juin = "Tranche 6";
                        } else if (var3 == 6) {
                           this.aff_juillet = true;
                           this.lib_juillet = "Tranche 7";
                        } else if (var3 == 7) {
                           this.aff_aout = true;
                           this.lib_aout = "Tranche 8";
                        } else if (var3 == 8) {
                           this.aff_septembre = true;
                           this.lib_septembre = "Tranche 9";
                        } else if (var3 == 9) {
                           this.aff_octobre = true;
                           this.lib_octobre = "Tranche 10";
                        } else if (var3 == 10) {
                           this.aff_novembre = true;
                           this.lib_novembre = "Tranche 11";
                        } else if (var3 == 11) {
                           this.aff_decembre = true;
                           this.lib_decembre = "Tranche 12";
                        }
                     }
                  }
               }
            } else {
               this.aff_janvier = true;
               this.aff_fevrier = true;
               this.aff_mars = true;
               this.aff_avril = true;
               this.aff_mai = true;
               this.aff_juin = true;
               this.aff_juillet = true;
               this.aff_aout = true;
               this.aff_septembre = true;
               this.aff_octobre = true;
               this.aff_novembre = true;
               this.aff_decembre = true;
               this.lib_janvier = "Janvier";
               this.lib_fevrier = "Février";
               this.lib_mars = "Mars";
               this.lib_avril = "Avril";
               this.lib_mai = "Mai";
               this.lib_juin = "Juin";
               this.lib_juillet = "Juillet";
               this.lib_aout = "Aout";
               this.lib_septembre = "Septembre";
               this.lib_octobre = "Octobre";
               this.lib_novembre = "Novembre";
               this.lib_decembre = "Décembre";
            }
         } else {
            this.lesBudgetsLigne.clear();
            this.dataModelLesBudgetsLigne.setWrappedData(this.lesBudgetsLigne);
            this.testaffSupp = false;
         }
      }

   }

   public void filtreColonneMois(Date var1) {
      int var2 = var1.getMonth() + 1;
      if (var2 == 1) {
         this.aff_janvier = true;
      } else if (var2 == 2) {
         this.aff_fevrier = true;
      } else if (var2 == 3) {
         this.aff_mars = true;
      } else if (var2 == 4) {
         this.aff_avril = true;
      } else if (var2 == 5) {
         this.aff_mai = true;
      } else if (var2 == 6) {
         this.aff_juin = true;
      } else if (var2 == 7) {
         this.aff_juillet = true;
      } else if (var2 == 8) {
         this.aff_aout = true;
      } else if (var2 == 9) {
         this.aff_septembre = true;
      } else if (var2 == 10) {
         this.aff_octobre = true;
      } else if (var2 == 11) {
         this.aff_novembre = true;
      } else if (var2 == 12) {
         this.aff_decembre = true;
      }

   }

   public void annulerBudget() {
      this.showModalPanelSaisie = false;
   }

   public void selectionBudgetLigne() {
      if (this.dataModelLesBudgetsLigne.isRowAvailable()) {
         this.budgetTresorerieLigne = (BudgetTresorerieLigne)this.dataModelLesBudgetsLigne.getRowData();
      }

   }

   public void selectionMontant() {
      this.selectionModeSaisie = 1;
   }

   public void calculeRepartitionMontant() {
      if (this.montantTotal != 0.0D) {
         int var1 = 0;
         if (this.aff_janvier) {
            ++var1;
         }

         if (this.aff_fevrier) {
            ++var1;
         }

         if (this.aff_mars) {
            ++var1;
         }

         if (this.aff_avril) {
            ++var1;
         }

         if (this.aff_mai) {
            ++var1;
         }

         if (this.aff_juin) {
            ++var1;
         }

         if (this.aff_juillet) {
            ++var1;
         }

         if (this.aff_aout) {
            ++var1;
         }

         if (this.aff_septembre) {
            ++var1;
         }

         if (this.aff_octobre) {
            ++var1;
         }

         if (this.aff_novembre) {
            ++var1;
         }

         if (this.aff_decembre) {
            ++var1;
         }

         if (var1 != 0) {
            double var2 = this.montantTotal / (double)var1;
            UtilNombre var4 = new UtilNombre();
            var2 = var4.myRoundDevise(var2, this.structureLog.getStrdevise());
            if (this.aff_janvier) {
               this.val01 = var2;
            } else {
               this.val01 = 0.0D;
            }

            if (this.aff_fevrier) {
               this.val02 = var2;
            } else {
               this.val02 = 0.0D;
            }

            if (this.aff_mars) {
               this.val03 = var2;
            } else {
               this.val03 = 0.0D;
            }

            if (this.aff_avril) {
               this.val04 = var2;
            } else {
               this.val04 = 0.0D;
            }

            if (this.aff_mai) {
               this.val05 = var2;
            } else {
               this.val05 = 0.0D;
            }

            if (this.aff_juin) {
               this.val06 = var2;
            } else {
               this.val06 = 0.0D;
            }

            if (this.aff_juillet) {
               this.val07 = var2;
            } else {
               this.val07 = 0.0D;
            }

            if (this.aff_aout) {
               this.val08 = var2;
            } else {
               this.val08 = 0.0D;
            }

            if (this.aff_septembre) {
               this.val09 = var2;
            } else {
               this.val09 = 0.0D;
            }

            if (this.aff_octobre) {
               this.val10 = var2;
            } else {
               this.val10 = 0.0D;
            }

            if (this.aff_novembre) {
               this.val11 = var2;
            } else {
               this.val11 = 0.0D;
            }

            if (var1 == 12) {
               double var5 = this.montantTotal - (this.val01 + this.val02 + this.val03 + this.val04 + this.val05 + this.val06 + this.val07 + this.val08 + this.val09 + this.val10 + this.val11);
               this.val12 = var5;
            }
         }
      } else {
         this.val01 = 0.0D;
         this.val02 = 0.0D;
         this.val03 = 0.0D;
         this.val04 = 0.0D;
         this.val05 = 0.0D;
         this.val06 = 0.0D;
         this.val07 = 0.0D;
         this.val08 = 0.0D;
         this.val09 = 0.0D;
         this.val10 = 0.0D;
         this.val11 = 0.0D;
         this.val12 = 0.0D;
      }

   }

   public void calculeCumulMontant() {
      this.montantTotal = this.val01 + this.val02 + this.val03 + this.val04 + this.val05 + this.val06 + this.val07 + this.val08 + this.val09 + this.val10 + this.val11 + this.val12;
   }

   public void validerBudget() throws HibernateException, NamingException {
      this.val01 = 0.0D;
      this.val02 = 0.0D;
      this.val03 = 0.0D;
      this.val04 = 0.0D;
      this.val05 = 0.0D;
      this.val06 = 0.0D;
      this.val07 = 0.0D;
      this.val08 = 0.0D;
      this.val09 = 0.0D;
      this.val10 = 0.0D;
      this.val11 = 0.0D;
      this.val12 = 0.0D;
      this.montantTotal = 0.0D;
      if (this.lesBudgetsLigne.size() != 0) {
         for(int var1 = 0; var1 < this.lesBudgetsLigne.size(); ++var1) {
            this.budgetTresorerieLigne = new BudgetTresorerieLigne();
            this.budgetTresorerieLigne = (BudgetTresorerieLigne)this.lesBudgetsLigne.get(var1);
            if (this.var_choix_reamenagement.equalsIgnoreCase("0")) {
               this.montantTotal += this.budgetTresorerieLigne.getBudlig01TotVal();
               this.val01 += this.budgetTresorerieLigne.getBudlig01R1Val();
               this.val02 += this.budgetTresorerieLigne.getBudlig02R1Val();
               this.val03 += this.budgetTresorerieLigne.getBudlig03R1Val();
               this.val04 += this.budgetTresorerieLigne.getBudlig04R1Val();
               this.val05 += this.budgetTresorerieLigne.getBudlig05R1Val();
               this.val06 += this.budgetTresorerieLigne.getBudlig06R1Val();
               this.val07 += this.budgetTresorerieLigne.getBudlig07R1Val();
               this.val08 += this.budgetTresorerieLigne.getBudlig08R1Val();
               this.val09 += this.budgetTresorerieLigne.getBudlig09R1Val();
               this.val10 += this.budgetTresorerieLigne.getBudlig10R1Val();
               this.val11 += this.budgetTresorerieLigne.getBudlig11R1Val();
               this.val12 += this.budgetTresorerieLigne.getBudlig12R1Val();
            } else if (this.var_choix_reamenagement.equalsIgnoreCase("1")) {
               this.montantTotal += this.budgetTresorerieLigne.getBudlig02TotVal();
               this.val01 += this.budgetTresorerieLigne.getBudlig01R2Val();
               this.val02 += this.budgetTresorerieLigne.getBudlig02R2Val();
               this.val03 += this.budgetTresorerieLigne.getBudlig03R2Val();
               this.val04 += this.budgetTresorerieLigne.getBudlig04R2Val();
               this.val05 += this.budgetTresorerieLigne.getBudlig05R2Val();
               this.val06 += this.budgetTresorerieLigne.getBudlig06R2Val();
               this.val07 += this.budgetTresorerieLigne.getBudlig07R2Val();
               this.val08 += this.budgetTresorerieLigne.getBudlig08R2Val();
               this.val09 += this.budgetTresorerieLigne.getBudlig09R2Val();
               this.val10 += this.budgetTresorerieLigne.getBudlig10R2Val();
               this.val11 += this.budgetTresorerieLigne.getBudlig11R2Val();
               this.val12 += this.budgetTresorerieLigne.getBudlig12R2Val();
            } else if (this.var_choix_reamenagement.equalsIgnoreCase("2")) {
               this.montantTotal += this.budgetTresorerieLigne.getBudlig03TotVal();
               this.val01 += this.budgetTresorerieLigne.getBudlig01R3Val();
               this.val02 += this.budgetTresorerieLigne.getBudlig02R3Val();
               this.val03 += this.budgetTresorerieLigne.getBudlig03R3Val();
               this.val04 += this.budgetTresorerieLigne.getBudlig04R3Val();
               this.val05 += this.budgetTresorerieLigne.getBudlig05R3Val();
               this.val06 += this.budgetTresorerieLigne.getBudlig06R3Val();
               this.val07 += this.budgetTresorerieLigne.getBudlig07R3Val();
               this.val08 += this.budgetTresorerieLigne.getBudlig08R3Val();
               this.val09 += this.budgetTresorerieLigne.getBudlig09R3Val();
               this.val10 += this.budgetTresorerieLigne.getBudlig10R3Val();
               this.val11 += this.budgetTresorerieLigne.getBudlig11R3Val();
               this.val12 += this.budgetTresorerieLigne.getBudlig12R3Val();
            } else if (this.var_choix_reamenagement.equalsIgnoreCase("3")) {
               this.montantTotal += this.budgetTresorerieLigne.getBudlig04TotVal();
               this.val01 += this.budgetTresorerieLigne.getBudlig01R4Val();
               this.val02 += this.budgetTresorerieLigne.getBudlig02R4Val();
               this.val03 += this.budgetTresorerieLigne.getBudlig03R4Val();
               this.val04 += this.budgetTresorerieLigne.getBudlig04R4Val();
               this.val05 += this.budgetTresorerieLigne.getBudlig05R4Val();
               this.val06 += this.budgetTresorerieLigne.getBudlig06R4Val();
               this.val07 += this.budgetTresorerieLigne.getBudlig07R4Val();
               this.val08 += this.budgetTresorerieLigne.getBudlig08R4Val();
               this.val09 += this.budgetTresorerieLigne.getBudlig09R4Val();
               this.val10 += this.budgetTresorerieLigne.getBudlig10R4Val();
               this.val11 += this.budgetTresorerieLigne.getBudlig11R4Val();
               this.val12 += this.budgetTresorerieLigne.getBudlig12R4Val();
            }
         }
      }

      if (this.var_choix_reamenagement.equalsIgnoreCase("0")) {
         this.budgetTresorerie.setBud01TotVal(this.montantTotal);
         this.budgetTresorerie.setBud01R1Val(this.val01);
         this.budgetTresorerie.setBud02R1Val(this.val02);
         this.budgetTresorerie.setBud03R1Val(this.val03);
         this.budgetTresorerie.setBud04R1Val(this.val04);
         this.budgetTresorerie.setBud05R1Val(this.val05);
         this.budgetTresorerie.setBud06R1Val(this.val06);
         this.budgetTresorerie.setBud07R1Val(this.val07);
         this.budgetTresorerie.setBud08R1Val(this.val08);
         this.budgetTresorerie.setBud09R1Val(this.val09);
         this.budgetTresorerie.setBud10R1Val(this.val10);
         this.budgetTresorerie.setBud11R1Val(this.val11);
         this.budgetTresorerie.setBud12R1Val(this.val12);
      } else if (this.var_choix_reamenagement.equalsIgnoreCase("1")) {
         this.budgetTresorerie.setBud02TotVal(this.montantTotal);
         this.budgetTresorerie.setBud01R2Val(this.val01);
         this.budgetTresorerie.setBud02R2Val(this.val02);
         this.budgetTresorerie.setBud03R2Val(this.val03);
         this.budgetTresorerie.setBud04R2Val(this.val04);
         this.budgetTresorerie.setBud05R2Val(this.val05);
         this.budgetTresorerie.setBud06R2Val(this.val06);
         this.budgetTresorerie.setBud07R2Val(this.val07);
         this.budgetTresorerie.setBud08R2Val(this.val08);
         this.budgetTresorerie.setBud09R2Val(this.val09);
         this.budgetTresorerie.setBud10R2Val(this.val10);
         this.budgetTresorerie.setBud11R2Val(this.val11);
         this.budgetTresorerie.setBud12R2Val(this.val12);
      } else if (this.var_choix_reamenagement.equalsIgnoreCase("2")) {
         this.budgetTresorerie.setBud03TotVal(this.montantTotal);
         this.budgetTresorerie.setBud01R3Val(this.val01);
         this.budgetTresorerie.setBud02R3Val(this.val02);
         this.budgetTresorerie.setBud03R3Val(this.val03);
         this.budgetTresorerie.setBud04R3Val(this.val04);
         this.budgetTresorerie.setBud05R3Val(this.val05);
         this.budgetTresorerie.setBud06R3Val(this.val06);
         this.budgetTresorerie.setBud07R3Val(this.val07);
         this.budgetTresorerie.setBud08R3Val(this.val08);
         this.budgetTresorerie.setBud09R3Val(this.val09);
         this.budgetTresorerie.setBud10R3Val(this.val10);
         this.budgetTresorerie.setBud11R3Val(this.val11);
         this.budgetTresorerie.setBud12R3Val(this.val12);
      } else if (this.var_choix_reamenagement.equalsIgnoreCase("3")) {
         this.budgetTresorerie.setBud04TotVal(this.montantTotal);
         this.budgetTresorerie.setBud01R4Val(this.val01);
         this.budgetTresorerie.setBud02R4Val(this.val02);
         this.budgetTresorerie.setBud03R4Val(this.val03);
         this.budgetTresorerie.setBud04R4Val(this.val04);
         this.budgetTresorerie.setBud05R4Val(this.val05);
         this.budgetTresorerie.setBud06R4Val(this.val06);
         this.budgetTresorerie.setBud07R4Val(this.val07);
         this.budgetTresorerie.setBud08R4Val(this.val08);
         this.budgetTresorerie.setBud09R4Val(this.val09);
         this.budgetTresorerie.setBud10R4Val(this.val10);
         this.budgetTresorerie.setBud11R4Val(this.val11);
         this.budgetTresorerie.setBud12R4Val(this.val12);
      }

      this.budgetTresorerie.setBudUtil(Integer.parseInt(this.var_choix_reamenagement));
      if (this.budgetTresorerie.getBud_id() == 0L) {
         this.budgetTresorerie.setExercicescomptable(this.selectedExo);
         this.budgetTresorerie.setBudDateCreat(new Date());
         this.budgetTresorerie.setBudUserCreat(this.usersLog.getUsrid());
         this.budgetTresorerie = this.budgetTresorerieDao.insert(this.budgetTresorerie);
      } else {
         this.budgetTresorerie.setBudDateModif(new Date());
         this.budgetTresorerie.setBudUserModif(this.usersLog.getUsrid());
         this.budgetTresorerie = this.budgetTresorerieDao.modif(this.budgetTresorerie);
      }

      this.showModalPanelSaisie = false;
   }

   public void ajouterLigne() {
      if (this.budgetTresorerie != null) {
         this.mode_calcul = false;
         this.initVariable();
         this.var_activite_select = "0";
         this.var_activite_montant = 0.0D;
         this.selectionSaisie = 0;
         this.selectionModeSaisie = 1;
         this.calculCumulMontantImpute();
         this.budgetTresorerieLigne = new BudgetTresorerieLigne();
         this.showModalPanelModif = true;
      }

   }

   public void calculCumulMontantImpute() {
      if (this.lesBudgetsLigne.size() != 0) {
         for(int var1 = 0; var1 < this.lesBudgetsLigne.size(); ++var1) {
            if (this.selectionModeSaisie <= 1) {
               if (this.var_choix_reamenagement.equals("0")) {
                  this.var_montant_impute += ((BudgetTresorerieLigne)this.lesBudgetsLigne.get(var1)).getBudlig01TotVal();
               } else if (this.var_choix_reamenagement.equals("1")) {
                  this.var_montant_impute += ((BudgetTresorerieLigne)this.lesBudgetsLigne.get(var1)).getBudlig02TotVal();
               } else if (this.var_choix_reamenagement.equals("2")) {
                  this.var_montant_impute += ((BudgetTresorerieLigne)this.lesBudgetsLigne.get(var1)).getBudlig03TotVal();
               } else if (this.var_choix_reamenagement.equals("3")) {
                  this.var_montant_impute += ((BudgetTresorerieLigne)this.lesBudgetsLigne.get(var1)).getBudlig04TotVal();
               }
            }
         }
      } else {
         this.var_montant_impute = 0.0D;
      }

      this.var_montant_restant = this.montantTotal - this.var_montant_impute;
   }

   public void modifierLigne() {
      if (this.budgetTresorerieLigne != null) {
         this.montantTotal = this.budgetTresorerieLigne.getLigvalTotal();
         double var1 = this.montantTotal / 12.0D;
         UtilNombre var3 = new UtilNombre();
         var3.myRoundDevise(var1, this.structureLog.getStrdevise());
         this.val01 = this.budgetTresorerieLigne.getLigval01();
         this.val02 = this.budgetTresorerieLigne.getLigval02();
         this.val03 = this.budgetTresorerieLigne.getLigval03();
         this.val04 = this.budgetTresorerieLigne.getLigval04();
         this.val05 = this.budgetTresorerieLigne.getLigval05();
         this.val06 = this.budgetTresorerieLigne.getLigval06();
         this.val07 = this.budgetTresorerieLigne.getLigval07();
         this.val08 = this.budgetTresorerieLigne.getLigval08();
         this.val09 = this.budgetTresorerieLigne.getLigval09();
         this.val10 = this.budgetTresorerieLigne.getLigval10();
         this.val11 = this.budgetTresorerieLigne.getLigval11();
         this.val12 = this.budgetTresorerieLigne.getLigval12();
         this.showModalPanelModif = true;
      } else {
         this.showModalPanelModif = false;
      }

   }

   public void annulerModification() {
      this.showModalPanelModif = false;
   }

   public void valideModification() throws HibernateException, NamingException {
      if (this.budgetTresorerieLigne != null) {
         if (this.budgetTresorerie.getBud_id() == 0L) {
            this.budgetTresorerie.setExercicescomptable(this.selectedExo);
            this.budgetTresorerie.setBudDateCreat(new Date());
            this.budgetTresorerie.setBudUserCreat(this.usersLog.getUsrid());
            this.budgetTresorerie = this.budgetTresorerieDao.insert(this.budgetTresorerie);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Budget");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            if (this.var_choix_reamenagement.equals("0")) {
               this.budgetTresorerieLigne.setBudlig01TotVal(this.montantTotal);
               this.budgetTresorerieLigne.setBudlig01R1Val(this.val01);
               this.budgetTresorerieLigne.setBudlig02R1Val(this.val02);
               this.budgetTresorerieLigne.setBudlig03R1Val(this.val03);
               this.budgetTresorerieLigne.setBudlig04R1Val(this.val04);
               this.budgetTresorerieLigne.setBudlig05R1Val(this.val05);
               this.budgetTresorerieLigne.setBudlig06R1Val(this.val06);
               this.budgetTresorerieLigne.setBudlig07R1Val(this.val07);
               this.budgetTresorerieLigne.setBudlig08R1Val(this.val08);
               this.budgetTresorerieLigne.setBudlig09R1Val(this.val09);
               this.budgetTresorerieLigne.setBudlig10R1Val(this.val10);
               this.budgetTresorerieLigne.setBudlig11R1Val(this.val11);
               this.budgetTresorerieLigne.setBudlig12R1Val(this.val12);
            } else if (this.var_choix_reamenagement.equals("1")) {
               this.budgetTresorerieLigne.setBudlig02TotVal(this.montantTotal);
               this.budgetTresorerieLigne.setBudlig01R2Val(this.val01);
               this.budgetTresorerieLigne.setBudlig02R2Val(this.val02);
               this.budgetTresorerieLigne.setBudlig03R2Val(this.val03);
               this.budgetTresorerieLigne.setBudlig04R2Val(this.val04);
               this.budgetTresorerieLigne.setBudlig05R2Val(this.val05);
               this.budgetTresorerieLigne.setBudlig06R2Val(this.val06);
               this.budgetTresorerieLigne.setBudlig07R2Val(this.val07);
               this.budgetTresorerieLigne.setBudlig08R2Val(this.val08);
               this.budgetTresorerieLigne.setBudlig09R2Val(this.val09);
               this.budgetTresorerieLigne.setBudlig10R2Val(this.val10);
               this.budgetTresorerieLigne.setBudlig11R2Val(this.val11);
               this.budgetTresorerieLigne.setBudlig12R2Val(this.val12);
            } else if (this.var_choix_reamenagement.equals("2")) {
               this.budgetTresorerieLigne.setBudlig03TotVal(this.montantTotal);
               this.budgetTresorerieLigne.setBudlig01R3Val(this.val01);
               this.budgetTresorerieLigne.setBudlig02R3Val(this.val02);
               this.budgetTresorerieLigne.setBudlig03R3Val(this.val03);
               this.budgetTresorerieLigne.setBudlig04R3Val(this.val04);
               this.budgetTresorerieLigne.setBudlig05R3Val(this.val05);
               this.budgetTresorerieLigne.setBudlig06R3Val(this.val06);
               this.budgetTresorerieLigne.setBudlig07R3Val(this.val07);
               this.budgetTresorerieLigne.setBudlig08R3Val(this.val08);
               this.budgetTresorerieLigne.setBudlig09R3Val(this.val09);
               this.budgetTresorerieLigne.setBudlig10R3Val(this.val10);
               this.budgetTresorerieLigne.setBudlig11R3Val(this.val11);
               this.budgetTresorerieLigne.setBudlig12R3Val(this.val12);
            } else if (this.var_choix_reamenagement.equals("3")) {
               this.budgetTresorerieLigne.setBudlig04TotVal(this.montantTotal);
               this.budgetTresorerieLigne.setBudlig01R4Val(this.val01);
               this.budgetTresorerieLigne.setBudlig02R4Val(this.val02);
               this.budgetTresorerieLigne.setBudlig03R4Val(this.val03);
               this.budgetTresorerieLigne.setBudlig04R4Val(this.val04);
               this.budgetTresorerieLigne.setBudlig05R4Val(this.val05);
               this.budgetTresorerieLigne.setBudlig06R4Val(this.val06);
               this.budgetTresorerieLigne.setBudlig07R4Val(this.val07);
               this.budgetTresorerieLigne.setBudlig08R4Val(this.val08);
               this.budgetTresorerieLigne.setBudlig09R4Val(this.val09);
               this.budgetTresorerieLigne.setBudlig10R4Val(this.val10);
               this.budgetTresorerieLigne.setBudlig11R4Val(this.val11);
               this.budgetTresorerieLigne.setBudlig12R4Val(this.val12);
            }

            this.budgetTresorerieLigne.setBudligCode(this.budgetTresorerie.getBudCode());
            this.budgetTresorerieLigne.setBudligUtil(Integer.parseInt(this.var_choix_reamenagement));
            this.budgetTresorerieLigne.setBudligActivite(this.var_activite);
            if (this.budgetTresorerieLigne.getBudlig_id() == 0L) {
               this.budgetTresorerieLigne.setBudgetTresorerie(this.budgetTresorerie);
               this.budgetTresorerieLigne = this.budgetTresorerieLigneDao.insert(this.budgetTresorerieLigne, var1);
               var1.flush();
               this.lesBudgetsLigne.add(this.budgetTresorerieLigne);
               this.dataModelLesBudgetsLigne.setWrappedData(this.lesBudgetsLigne);
            } else {
               this.budgetTresorerieLigne = this.budgetTresorerieLigneDao.modif(this.budgetTresorerieLigne, var1);
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

      this.showModalPanelModif = false;
   }

   public void supprimerLigne() throws HibernateException, NamingException {
      if (this.lesBudgetsLigne.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Budget");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            int var3 = 0;

            while(true) {
               if (var3 >= this.lesBudgetsLigne.size()) {
                  var2.commit();
                  break;
               }

               this.budgetTresorerieLigne = new BudgetTresorerieLigne();
               this.budgetTresorerieLigne = (BudgetTresorerieLigne)this.lesBudgetsLigne.get(var3);
               this.budgetTresorerieLigneDao.delete(this.budgetTresorerieLigne, var1);
               var1.flush();
               ++var3;
            }
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.lesBudgetsLigne.clear();
         this.montantTotal = 0.0D;
      }

   }

   public void annuleSaisieDetailLigne() {
      this.showModalPanelDetail = false;
   }

   public void validerDetailLigne() {
      this.showModalPanelDetail = false;
   }

   public void structureNature() throws HibernateException, NamingException, ParseException {
      this.initVariable();
      this.mode_calcul = false;
   }

   public void initVariable() {
      this.lesBudgetsLigne.clear();
      this.lesActivites.clear();
      this.affiche_activite = false;
      this.val01 = 0.0D;
      this.val02 = 0.0D;
      this.val03 = 0.0D;
      this.val04 = 0.0D;
      this.val05 = 0.0D;
      this.val06 = 0.0D;
      this.val07 = 0.0D;
      this.val08 = 0.0D;
      this.val09 = 0.0D;
      this.val10 = 0.0D;
      this.val11 = 0.0D;
      this.val12 = 0.0D;
   }

   public void calculeRepartition() {
      this.mode_calcul = true;
      this.calculeActivite();
   }

   public void calculeActivite() {
      if (this.lesActivites.size() != 0) {
         for(int var1 = 0; var1 < this.lesActivites.size(); ++var1) {
            new Activites();
            Activites var2 = (Activites)this.lesActivites.get(var1);
            if (var2.isSelect_activite()) {
            }
         }
      }

   }

   public void annulerSaisieValeurDetail() {
      this.showModalPanelSaisieValeurDetail = false;
   }

   public void controleSaisieValeurDetail() {
      this.var_total_imput = 0.0D;
      this.var_ecart_imput = 0.0D;
      this.var_valide_valeur = false;
      if (this.listeSasieValeurDetail.size() != 0) {
         for(int var1 = 0; var1 < this.listeSasieValeurDetail.size(); ++var1) {
            this.var_total_imput += ((LigneDocument)this.listeSasieValeurDetail.get(var1)).getLigPu();
         }
      }

      this.var_ecart_imput = this.var_activite_montant - this.var_total_imput;
      if (this.var_ecart_imput == 0.0D) {
         this.var_valide_valeur = true;
      } else {
         this.var_valide_valeur = false;
      }

   }

   public void validerRepartition() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Budget");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         var1.setFlushMode(FlushMode.MANUAL);
         if (this.budgetTresorerie.getBud_id() == 0L) {
            this.budgetTresorerie.setExercicescomptable(this.selectedExo);
            this.budgetTresorerie.setBudUtil(Integer.parseInt(this.var_choix_reamenagement));
            this.budgetTresorerie.setBudDateCreat(new Date());
            this.budgetTresorerie.setBudUserCreat(this.usersLog.getUsrid());
            this.budgetTresorerie = this.budgetTresorerieDao.insert(this.budgetTresorerie, var1);
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

      if (this.budgetTresorerie.getBud_id() != 0L) {
         this.validerBudget();
      }

      this.showModalPanelDetail = false;
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
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_gene" + File.separator + "budgetTresorerie";
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
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_gene" + File.separator + "budgetTresorerie" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
         var1.setEntete("Impression Budget");
         String var11 = "";
         if (this.var_choix_reamenagement.contentEquals("0")) {
            var11 = "Budget initial";
         } else if (this.var_choix_reamenagement.contentEquals("1")) {
            var11 = "Réaménagement N° 1";
         } else if (this.var_choix_reamenagement.contentEquals("2")) {
            var11 = "Réaménagement N° 2";
         } else if (this.var_choix_reamenagement.contentEquals("3")) {
            var11 = "Réaménagement N° 3";
         }

         if (this.var_projet != null && !this.var_projet.isEmpty()) {
            var1.setFiltre("Plans budgétaires : Projet : " + this.var_projet + " - Année " + this.var_annee + " - " + var11);
         } else {
            var1.setFiltre("Plans budgétaires : Année " + this.var_annee + " - " + var11);
         }

         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataire(var8);
         var1.setDestinataire(var9);
         var1.setCorpsMail(var10);
         var1.setTiersSelectionne((Tiers)null);
         JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(this.lesBudgets);
         var1.setjRBeanCollectionDataSource(var12);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

   }

   public BudgetTresorerie getBudgetTresorerie() {
      return this.budgetTresorerie;
   }

   public void setBudgetTresorerie(BudgetTresorerie var1) {
      this.budgetTresorerie = var1;
   }

   public DataModel getDataModelLesBudgets() {
      return this.dataModelLesBudgets;
   }

   public void setDataModelLesBudgets(DataModel var1) {
      this.dataModelLesBudgets = var1;
   }

   public List getLesexercicesItem() {
      return this.lesexercicesItem;
   }

   public void setLesexercicesItem(List var1) {
      this.lesexercicesItem = var1;
   }

   public String getVar_choix_reamenagement() {
      return this.var_choix_reamenagement;
   }

   public void setVar_choix_reamenagement(String var1) {
      this.var_choix_reamenagement = var1;
   }

   public boolean isTestaffSupp() {
      return this.testaffSupp;
   }

   public void setTestaffSupp(boolean var1) {
      this.testaffSupp = var1;
   }

   public int getTypeDuplication() {
      return this.typeDuplication;
   }

   public void setTypeDuplication(int var1) {
      this.typeDuplication = var1;
   }

   public boolean isTestDuplicReam() {
      return this.testDuplicReam;
   }

   public void setTestDuplicReam(boolean var1) {
      this.testDuplicReam = var1;
   }

   public boolean isTestDuplicAnnee() {
      return this.testDuplicAnnee;
   }

   public void setTestDuplicAnnee(boolean var1) {
      this.testDuplicAnnee = var1;
   }

   public boolean isTestDuplicReamEtAnnee() {
      return this.testDuplicReamEtAnnee;
   }

   public void setTestDuplicReamEtAnnee(boolean var1) {
      this.testDuplicReamEtAnnee = var1;
   }

   public boolean isDisableButton() {
      return this.disableButton;
   }

   public void setDisableButton(boolean var1) {
      this.disableButton = var1;
   }

   public boolean isBudtestDupliquer() {
      return this.budtestDupliquer;
   }

   public void setBudtestDupliquer(boolean var1) {
      this.budtestDupliquer = var1;
   }

   public List getLesModelsimpression() {
      return this.lesModelsimpression;
   }

   public void setLesModelsimpression(List var1) {
      this.lesModelsimpression = var1;
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

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public List getMesAnneeItems() {
      return this.mesAnneeItems;
   }

   public void setMesAnneeItems(List var1) {
      this.mesAnneeItems = var1;
   }

   public String getVar_activite() {
      return this.var_activite;
   }

   public void setVar_activite(String var1) {
      this.var_activite = var1;
   }

   public String getVar_annee() {
      return this.var_annee;
   }

   public void setVar_annee(String var1) {
      this.var_annee = var1;
   }

   public boolean isShowButtonPanel() {
      return this.showButtonPanel;
   }

   public void setShowButtonPanel(boolean var1) {
      this.showButtonPanel = var1;
   }

   public boolean isTestactivite() {
      return this.testactivite;
   }

   public void setTestactivite(boolean var1) {
      this.testactivite = var1;
   }

   public double getMontantTotal() {
      return this.montantTotal;
   }

   public void setMontantTotal(double var1) {
      this.montantTotal = var1;
   }

   public boolean isShowButtonRec() {
      return this.showButtonRec;
   }

   public void setShowButtonRec(boolean var1) {
      this.showButtonRec = var1;
   }

   public double getVal01() {
      return this.val01;
   }

   public void setVal01(double var1) {
      this.val01 = var1;
   }

   public double getVal02() {
      return this.val02;
   }

   public void setVal02(double var1) {
      this.val02 = var1;
   }

   public double getVal03() {
      return this.val03;
   }

   public void setVal03(double var1) {
      this.val03 = var1;
   }

   public double getVal04() {
      return this.val04;
   }

   public void setVal04(double var1) {
      this.val04 = var1;
   }

   public double getVal05() {
      return this.val05;
   }

   public void setVal05(double var1) {
      this.val05 = var1;
   }

   public double getVal06() {
      return this.val06;
   }

   public void setVal06(double var1) {
      this.val06 = var1;
   }

   public double getVal07() {
      return this.val07;
   }

   public void setVal07(double var1) {
      this.val07 = var1;
   }

   public double getVal08() {
      return this.val08;
   }

   public void setVal08(double var1) {
      this.val08 = var1;
   }

   public double getVal09() {
      return this.val09;
   }

   public void setVal09(double var1) {
      this.val09 = var1;
   }

   public double getVal10() {
      return this.val10;
   }

   public void setVal10(double var1) {
      this.val10 = var1;
   }

   public double getVal11() {
      return this.val11;
   }

   public void setVal11(double var1) {
      this.val11 = var1;
   }

   public double getVal12() {
      return this.val12;
   }

   public void setVal12(double var1) {
      this.val12 = var1;
   }

   public DataModel getDataModelLesBudgetsLigne() {
      return this.dataModelLesBudgetsLigne;
   }

   public void setDataModelLesBudgetsLigne(DataModel var1) {
      this.dataModelLesBudgetsLigne = var1;
   }

   public ExercicesComptable getLastExo() {
      return this.lastExo;
   }

   public void setLastExo(ExercicesComptable var1) {
      this.lastExo = var1;
   }

   public ExercicesComptable getSelectedExo() {
      return this.selectedExo;
   }

   public void setSelectedExo(ExercicesComptable var1) {
      this.selectedExo = var1;
   }

   public boolean isShowModalPanelSaisie() {
      return this.showModalPanelSaisie;
   }

   public void setShowModalPanelSaisie(boolean var1) {
      this.showModalPanelSaisie = var1;
   }

   public boolean isShowModalPanelDetail() {
      return this.showModalPanelDetail;
   }

   public void setShowModalPanelDetail(boolean var1) {
      this.showModalPanelDetail = var1;
   }

   public boolean isAffiche_activite() {
      return this.affiche_activite;
   }

   public void setAffiche_activite(boolean var1) {
      this.affiche_activite = var1;
   }

   public List getLesActivites() {
      return this.lesActivites;
   }

   public void setLesActivites(List var1) {
      this.lesActivites = var1;
   }

   public List getLesBudgets() {
      return this.lesBudgets;
   }

   public void setLesBudgets(List var1) {
      this.lesBudgets = var1;
   }

   public boolean isMode_calcul() {
      return this.mode_calcul;
   }

   public void setMode_calcul(boolean var1) {
      this.mode_calcul = var1;
   }

   public double getVar_montant_impute() {
      return this.var_montant_impute;
   }

   public void setVar_montant_impute(double var1) {
      this.var_montant_impute = var1;
   }

   public double getVar_montant_restant() {
      return this.var_montant_restant;
   }

   public void setVar_montant_restant(double var1) {
      this.var_montant_restant = var1;
   }

   public double getVar_activite_montant() {
      return this.var_activite_montant;
   }

   public void setVar_activite_montant(double var1) {
      this.var_activite_montant = var1;
   }

   public String getVar_activite_select() {
      return this.var_activite_select;
   }

   public void setVar_activite_select(String var1) {
      this.var_activite_select = var1;
   }

   public List getListeSasieValeurDetail() {
      return this.listeSasieValeurDetail;
   }

   public void setListeSasieValeurDetail(List var1) {
      this.listeSasieValeurDetail = var1;
   }

   public boolean isShowModalPanelSaisieValeurDetail() {
      return this.showModalPanelSaisieValeurDetail;
   }

   public void setShowModalPanelSaisieValeurDetail(boolean var1) {
      this.showModalPanelSaisieValeurDetail = var1;
   }

   public double getVar_ecart_imput() {
      return this.var_ecart_imput;
   }

   public void setVar_ecart_imput(double var1) {
      this.var_ecart_imput = var1;
   }

   public double getVar_total_imput() {
      return this.var_total_imput;
   }

   public void setVar_total_imput(double var1) {
      this.var_total_imput = var1;
   }

   public boolean isVar_valide_valeur() {
      return this.var_valide_valeur;
   }

   public void setVar_valide_valeur(boolean var1) {
      this.var_valide_valeur = var1;
   }

   public List getMesActivitesItems() {
      return this.mesActivitesItems;
   }

   public void setMesActivitesItems(List var1) {
      this.mesActivitesItems = var1;
   }

   public boolean isVar_valide_ligne() {
      return this.var_valide_ligne;
   }

   public void setVar_valide_ligne(boolean var1) {
      this.var_valide_ligne = var1;
   }

   public boolean isShowModalPanelModif() {
      return this.showModalPanelModif;
   }

   public void setShowModalPanelModif(boolean var1) {
      this.showModalPanelModif = var1;
   }

   public BudgetTresorerieLigne getBudgetTresorerieLigne() {
      return this.budgetTresorerieLigne;
   }

   public void setBudgetTresorerieLigne(BudgetTresorerieLigne var1) {
      this.budgetTresorerieLigne = var1;
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

   public String getVar_projet() {
      return this.var_projet;
   }

   public void setVar_projet(String var1) {
      this.var_projet = var1;
   }

   public boolean isProjetPresent() {
      return this.projetPresent;
   }

   public void setProjetPresent(boolean var1) {
      this.projetPresent = var1;
   }

   public boolean isAff_aout() {
      return this.aff_aout;
   }

   public void setAff_aout(boolean var1) {
      this.aff_aout = var1;
   }

   public boolean isAff_avril() {
      return this.aff_avril;
   }

   public void setAff_avril(boolean var1) {
      this.aff_avril = var1;
   }

   public boolean isAff_decembre() {
      return this.aff_decembre;
   }

   public void setAff_decembre(boolean var1) {
      this.aff_decembre = var1;
   }

   public boolean isAff_fevrier() {
      return this.aff_fevrier;
   }

   public void setAff_fevrier(boolean var1) {
      this.aff_fevrier = var1;
   }

   public boolean isAff_janvier() {
      return this.aff_janvier;
   }

   public void setAff_janvier(boolean var1) {
      this.aff_janvier = var1;
   }

   public boolean isAff_juillet() {
      return this.aff_juillet;
   }

   public void setAff_juillet(boolean var1) {
      this.aff_juillet = var1;
   }

   public boolean isAff_juin() {
      return this.aff_juin;
   }

   public void setAff_juin(boolean var1) {
      this.aff_juin = var1;
   }

   public boolean isAff_mai() {
      return this.aff_mai;
   }

   public void setAff_mai(boolean var1) {
      this.aff_mai = var1;
   }

   public boolean isAff_mars() {
      return this.aff_mars;
   }

   public void setAff_mars(boolean var1) {
      this.aff_mars = var1;
   }

   public boolean isAff_novembre() {
      return this.aff_novembre;
   }

   public void setAff_novembre(boolean var1) {
      this.aff_novembre = var1;
   }

   public boolean isAff_octobre() {
      return this.aff_octobre;
   }

   public void setAff_octobre(boolean var1) {
      this.aff_octobre = var1;
   }

   public boolean isAff_septembre() {
      return this.aff_septembre;
   }

   public void setAff_septembre(boolean var1) {
      this.aff_septembre = var1;
   }

   public String getLib_aout() {
      return this.lib_aout;
   }

   public void setLib_aout(String var1) {
      this.lib_aout = var1;
   }

   public String getLib_avril() {
      return this.lib_avril;
   }

   public void setLib_avril(String var1) {
      this.lib_avril = var1;
   }

   public String getLib_decembre() {
      return this.lib_decembre;
   }

   public void setLib_decembre(String var1) {
      this.lib_decembre = var1;
   }

   public String getLib_fevrier() {
      return this.lib_fevrier;
   }

   public void setLib_fevrier(String var1) {
      this.lib_fevrier = var1;
   }

   public String getLib_janvier() {
      return this.lib_janvier;
   }

   public void setLib_janvier(String var1) {
      this.lib_janvier = var1;
   }

   public String getLib_juillet() {
      return this.lib_juillet;
   }

   public void setLib_juillet(String var1) {
      this.lib_juillet = var1;
   }

   public String getLib_juin() {
      return this.lib_juin;
   }

   public void setLib_juin(String var1) {
      this.lib_juin = var1;
   }

   public String getLib_mai() {
      return this.lib_mai;
   }

   public void setLib_mai(String var1) {
      this.lib_mai = var1;
   }

   public String getLib_mars() {
      return this.lib_mars;
   }

   public void setLib_mars(String var1) {
      this.lib_mars = var1;
   }

   public String getLib_novembre() {
      return this.lib_novembre;
   }

   public void setLib_novembre(String var1) {
      this.lib_novembre = var1;
   }

   public String getLib_octobre() {
      return this.lib_octobre;
   }

   public void setLib_octobre(String var1) {
      this.lib_octobre = var1;
   }

   public String getLib_septembre() {
      return this.lib_septembre;
   }

   public void setLib_septembre(String var1) {
      this.lib_septembre = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public List getLesModelesAutorises() {
      return this.lesModelesAutorises;
   }

   public void setLesModelesAutorises(List var1) {
      this.lesModelesAutorises = var1;
   }
}
