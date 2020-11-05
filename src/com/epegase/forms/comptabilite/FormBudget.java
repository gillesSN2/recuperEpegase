package com.epegase.forms.comptabilite;

import com.epegase.forms.commun.FormAnalytique;
import com.epegase.systeme.classe.Budget;
import com.epegase.systeme.classe.BudgetLigne;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.PlanBudgetaireCompte;
import com.epegase.systeme.classe.PlansBudgetaires;
import com.epegase.systeme.classe.Projets;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.BudgetDao;
import com.epegase.systeme.dao.BudgetLigneDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.PlanBudgetaireCompteDao;
import com.epegase.systeme.dao.PlansBudgetairesDao;
import com.epegase.systeme.dao.ProjetsDao;
import com.epegase.systeme.util.StaticModePegase;
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
import java.util.Collection;
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

public class FormBudget implements Serializable {
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
   private List mesTypesItems = new ArrayList();
   private Budget budget = new Budget();
   private BudgetDao budgetDao;
   private List lesBudgets = new ArrayList();
   private transient DataModel dataModelLesBudgets = new ListDataModel();
   private BudgetLigne budgetLigne = new BudgetLigne();
   private BudgetLigneDao budgetLigneDao;
   private List lesBudgetsLigne = new ArrayList();
   private transient DataModel dataModelLesBudgetsLigne = new ListDataModel();
   private List lesexercicesItem = new ArrayList();
   private String var_choix_reamenagement = "0";
   private boolean budtestDupliquer = true;
   private boolean testaffSupp = false;
   private int typeDuplication;
   private boolean testDuplicReam = false;
   private boolean testDuplicAnnee = false;
   private boolean testDuplicReamEtAnnee = true;
   private boolean disableButton;
   private PlansBudgetairesDao plansBudgetairesDao;
   private boolean testactivite = false;
   private boolean testagent = false;
   private boolean showModalPanelEntite = false;
   private boolean recopieValeurposte;
   private String var_annee;
   private List mesAnneeItems;
   private String var_nature;
   private String var_activite;
   private boolean showButtonPanel = false;
   private boolean showButtonRec = false;
   private List mesEntitesItems = new ArrayList();
   private String var_choix_entite = "";
   private boolean afficheEntite = false;
   private boolean var_affiche_analytique = false;
   private int selectionModeSaisie;
   private boolean decoupageActivite;
   private boolean showModalPanelDetail = false;
   private double montantTotal = 0.0D;
   private double montantMax = 0.0D;
   private float qteTotal = 0.0F;
   private float qteMax = 0.0F;
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
   private float qte01 = 0.0F;
   private float qte02 = 0.0F;
   private float qte03 = 0.0F;
   private float qte04 = 0.0F;
   private float qte05 = 0.0F;
   private float qte06 = 0.0F;
   private float qte07 = 0.0F;
   private float qte08 = 0.0F;
   private float qte09 = 0.0F;
   private float qte10 = 0.0F;
   private float qte11 = 0.0F;
   private float qte12 = 0.0F;
   private List lesModelsimpression = new ArrayList();
   private boolean showModalPanelPrint = false;
   private FormAnalytique formAnalytique;
   private List lesModelesAutorises;

   public FormBudget() throws IOException {
   }

   public void InstancesDaoUtilses() {
      this.budgetDao = new BudgetDao(this.baseLog, this.utilInitHibernate);
      this.budgetLigneDao = new BudgetLigneDao(this.baseLog, this.utilInitHibernate);
      this.plansBudgetairesDao = new PlansBudgetairesDao(this.baseLog, this.utilInitHibernate);
   }

   public void initAnalytique(Session var1) throws HibernateException, NamingException {
      if (this.optionComptabilite.getNbLigneMaxBu() != null && !this.optionComptabilite.getNbLigneMaxBu().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionComptabilite.getNbLigneMaxBu());
      } else {
         this.var_nb_max = 100;
      }

      this.testactivite = this.structureLog.isStrActivite();
      this.testagent = this.structureLog.isStrAgent();
      if (this.optionComptabilite.getAnalytique().equals("true")) {
         this.var_affiche_analytique = true;
      } else {
         this.var_affiche_analytique = false;
      }

      if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
         this.decoupageActivite = true;
      } else {
         this.decoupageActivite = false;
      }

      this.mesTypesItems.clear();
      this.mesTypesItems.add(new SelectItem(1, "Ventes"));
      this.mesTypesItems.add(new SelectItem(2, "Achats"));
      if (this.structureLog.getStrtypeentreprise().equals("2")) {
         this.mesTypesItems.add(new SelectItem(3, "Production"));
      }

      this.mesTypesItems.add(new SelectItem(4, "Frais généraux"));
      this.mesTypesItems.add(new SelectItem(5, "Investissements"));
      this.mesTypesItems.add(new SelectItem(6, "TVA"));
      this.mesTypesItems.add(new SelectItem(7, "Impôts et Taxes"));
      this.mesTypesItems.add(new SelectItem(8, "Personnels"));
      this.mesTypesItems.add(new SelectItem(9, "Familles/Produits Achats"));
      new ArrayList();
      ProjetsDao var3 = new ProjetsDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.selectAllProjets(0, var1);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            if (((Projets)var2.get(var4)).getProCode() != null && !((Projets)var2.get(var4)).getProCode().isEmpty()) {
               this.mesTypesItems.add(new SelectItem(((Projets)var2.get(var4)).getProCode(), ((Projets)var2.get(var4)).getProCode() + ":" + ((Projets)var2.get(var4)).getProNomFR()));
            }
         }
      }

      this.formAnalytique = new FormAnalytique(this.baseLog, this.structureLog, this.usersLog, this.utilInitHibernate);
   }

   public void calculAnnee() {
      int var1 = this.selectedExo.getExecptDateDebut().getYear() + 1900;
      int var2 = this.selectedExo.getExecptDateFin().getYear() + 1900;
      this.mesAnneeItems = new ArrayList();
      String var3 = "";

      for(int var4 = var1; var4 <= var2; ++var4) {
         var3 = "" + var4;
         this.mesAnneeItems.add(new SelectItem(var3));
      }

   }

   public void buttonPanel() throws HibernateException, NamingException, ParseException {
      if (this.var_annee.length() == 4 && !this.var_nature.equalsIgnoreCase("0")) {
         this.showButtonRec = true;
      } else {
         this.showButtonRec = false;
      }

      this.lesBudgets.clear();
      this.budget = new Budget();
   }

   public void recherche() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Budget");
      byte var2 = 0;
      if (this.var_nature != null && !this.var_nature.isEmpty() && this.var_nature.equals("9")) {
         var2 = 1;
      }

      new ArrayList();
      List var3 = this.plansBudgetairesDao.chargerLesPlansBudgetaires(this.selectedExo, var2, this.var_nature, this.var_annee, var1);
      new ArrayList();
      List var4 = this.budgetDao.chargerLesBudgets(this.var_nature, this.var_annee, this.var_activite, var1);
      this.calculeEntite(var4);
      this.utilInitHibernate.closeSession();
      this.lesBudgets.clear();
      Budget var6;
      int var7;
      boolean var8;
      int var9;
      if (var3.size() != 0) {
         new PlansBudgetaires();
         new Budget();

         for(var7 = 0; var7 < var3.size(); ++var7) {
            PlansBudgetaires var5 = (PlansBudgetaires)var3.get(var7);
            if (this.var_choix_entite == null || this.var_choix_entite.isEmpty() || this.var_choix_entite != null && !this.var_choix_entite.isEmpty() && var5.getPlbEntite() != null && !var5.getPlbEntite().isEmpty() && var5.getPlbEntite().equals(this.var_choix_entite)) {
               if (var4.size() == 0) {
                  var6 = new Budget();
                  var6.setBudAnnee(var5.getPlbAnnee());
                  var6.setBudCode(var5.getPlbCode());
                  var6.setBudEntite(var5.getPlbEntite());
                  var6.setBudLibelleFr(var5.getPlbLibelleFr());
                  var6.setBudLibelleSp(var5.getPlbLibelleSp());
                  var6.setBudLibelleUk(var5.getPlbLibelleUk());
                  var6.setBudNature(var5.getPlbNature());
                  var6.setBudType(var5.getPlbType());
                  var6.setBudProjet(var5.getPlbProjet());
                  var6.setBudUtil(0);
                  var6.setExercicescomptable(this.selectedExo);
                  if (var5.getPlbCode() != null && !var5.getPlbCode().isEmpty()) {
                     this.lesBudgets.add(var6);
                  }
               } else {
                  var8 = false;

                  for(var9 = 0; var9 < var4.size(); ++var9) {
                     var6 = (Budget)var4.get(var9);
                     if (var5.getPlbCode() != null && !var5.getPlbCode().isEmpty() && var5.getPlbCode().equalsIgnoreCase(var6.getBudCode())) {
                        var8 = true;
                        var6.setChoixReam(Integer.parseInt(this.var_choix_reamenagement));
                        this.lesBudgets.add(var6);
                        break;
                     }
                  }

                  if (!var8) {
                     var6 = new Budget();
                     var6.setBudAnnee(var5.getPlbAnnee());
                     var6.setBudCode(var5.getPlbCode());
                     var6.setBudEntite(var5.getPlbEntite());
                     var6.setBudLibelleFr(var5.getPlbLibelleFr());
                     var6.setBudLibelleSp(var5.getPlbLibelleSp());
                     var6.setBudLibelleUk(var5.getPlbLibelleUk());
                     var6.setBudNature(var5.getPlbNature());
                     var6.setBudType(var5.getPlbType());
                     var6.setBudProjet(var5.getPlbProjet());
                     var6.setBudUtil(0);
                     var6.setExercicescomptable(this.selectedExo);
                     if (var5.getPlbCode() != null && !var5.getPlbCode().isEmpty()) {
                        this.lesBudgets.add(var6);
                     }
                  }
               }
            }
         }
      }

      if (var4.size() != 0) {
         new Budget();
         new Budget();

         for(var7 = 0; var7 < var4.size(); ++var7) {
            Budget var10 = (Budget)var4.get(var7);
            if (this.var_choix_entite == null || this.var_choix_entite.isEmpty() || this.var_choix_entite != null && !this.var_choix_entite.isEmpty() && var10.getBudEntite() != null && !var10.getBudEntite().isEmpty() && var10.getBudEntite().equals(this.var_choix_entite)) {
               var8 = false;

               for(var9 = 0; var9 < this.lesBudgets.size(); ++var9) {
                  var6 = (Budget)this.lesBudgets.get(var9);
                  if (var10.getBudCode() != null && !var10.getBudCode().isEmpty() && var10.getBudCode().equalsIgnoreCase(var6.getBudCode())) {
                     var8 = true;
                     break;
                  }
               }

               if (!var8 && var10.getBudCode() != null && !var10.getBudCode().isEmpty()) {
                  this.lesBudgets.add(var10);
               }
            }
         }
      }

      this.miseAJourBudget();
      this.dataModelLesBudgets.setWrappedData(this.lesBudgets);
      if (this.lesBudgets.size() != 0) {
         this.showButtonPanel = true;
      } else {
         this.showButtonPanel = false;
      }

      this.budget = new Budget();
      this.budtestDupliquer = false;
      this.testaffSupp = false;
   }

   public void miseAJourBudget() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Budget");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.lesBudgets.size() != 0) {
            new Budget();

            for(int var4 = 0; var4 < this.lesBudgets.size(); ++var4) {
               Budget var3 = (Budget)this.lesBudgets.get(var4);
               if (var3.getBud_id() == 0L) {
                  this.budgetDao.insert(var3, var1);
               }
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

   public void calculeEntite(List var1) throws HibernateException, NamingException {
      this.mesEntitesItems.clear();
      this.afficheEntite = false;
      if (var1.size() != 0) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            if (((Budget)var1.get(var2)).getBudType() == 15 && ((Budget)var1.get(var2)).getBudEntite() != null && !((Budget)var1.get(var2)).getBudEntite().isEmpty()) {
               this.mesEntitesItems.add(new SelectItem(((Budget)var1.get(var2)).getBudEntite(), ((Budget)var1.get(var2)).getBudEntite() + ":" + ((Budget)var1.get(var2)).getBudLibelleFr()));
               this.afficheEntite = true;
            }
         }
      }

   }

   public void modifierBudget() throws HibernateException, NamingException {
      this.recopieValeurposte = false;
      if (this.budget != null) {
         if (this.var_choix_reamenagement.equals("0")) {
            this.montantTotal = this.budget.getBud01TotVal();
            this.qteTotal = this.budget.getBud01TotQte();
         } else if (this.var_choix_reamenagement.equals("1")) {
            this.montantTotal = this.budget.getBud02TotVal();
            this.qteTotal = this.budget.getBud02TotQte();
         } else if (this.var_choix_reamenagement.equals("2")) {
            this.montantTotal = this.budget.getBud03TotVal();
            this.qteTotal = this.budget.getBud03TotQte();
         } else if (this.var_choix_reamenagement.equals("3")) {
            this.montantTotal = this.budget.getBud04TotVal();
            this.qteTotal = this.budget.getBud04TotQte();
         }

         if (this.var_choix_reamenagement.equalsIgnoreCase("0")) {
            this.montantTotal = this.budget.getBud01TotVal();
            this.qteTotal = this.budget.getBud01TotQte();
            this.val01 = this.budget.getBud01R1Val();
            this.val02 = this.budget.getBud02R1Val();
            this.val03 = this.budget.getBud03R1Val();
            this.val04 = this.budget.getBud04R1Val();
            this.val05 = this.budget.getBud05R1Val();
            this.val06 = this.budget.getBud06R1Val();
            this.val07 = this.budget.getBud07R1Val();
            this.val08 = this.budget.getBud08R1Val();
            this.val09 = this.budget.getBud09R1Val();
            this.val10 = this.budget.getBud10R1Val();
            this.val11 = this.budget.getBud11R1Val();
            this.val12 = this.budget.getBud12R1Val();
            this.qte01 = this.budget.getBud01R1Qte();
            this.qte02 = this.budget.getBud02R1Qte();
            this.qte03 = this.budget.getBud03R1Qte();
            this.qte04 = this.budget.getBud04R1Qte();
            this.qte05 = this.budget.getBud05R1Qte();
            this.qte06 = this.budget.getBud06R1Qte();
            this.qte07 = this.budget.getBud07R1Qte();
            this.qte08 = this.budget.getBud08R1Qte();
            this.qte09 = this.budget.getBud09R1Qte();
            this.qte10 = this.budget.getBud10R1Qte();
            this.qte11 = this.budget.getBud11R1Qte();
            this.qte12 = this.budget.getBud12R1Qte();
         } else if (this.var_choix_reamenagement.equalsIgnoreCase("1")) {
            this.montantTotal = this.budget.getBud02TotVal();
            this.qteTotal = this.budget.getBud02TotQte();
            this.val01 = this.budget.getBud01R2Val();
            this.val02 = this.budget.getBud02R2Val();
            this.val03 = this.budget.getBud03R2Val();
            this.val04 = this.budget.getBud04R2Val();
            this.val05 = this.budget.getBud05R2Val();
            this.val06 = this.budget.getBud06R2Val();
            this.val07 = this.budget.getBud07R2Val();
            this.val08 = this.budget.getBud08R2Val();
            this.val09 = this.budget.getBud09R2Val();
            this.val10 = this.budget.getBud10R2Val();
            this.val11 = this.budget.getBud11R2Val();
            this.val12 = this.budget.getBud12R2Val();
            this.qte01 = this.budget.getBud01R2Qte();
            this.qte02 = this.budget.getBud02R2Qte();
            this.qte03 = this.budget.getBud03R2Qte();
            this.qte04 = this.budget.getBud04R2Qte();
            this.qte05 = this.budget.getBud05R2Qte();
            this.qte06 = this.budget.getBud06R2Qte();
            this.qte07 = this.budget.getBud07R2Qte();
            this.qte08 = this.budget.getBud08R2Qte();
            this.qte09 = this.budget.getBud09R2Qte();
            this.qte10 = this.budget.getBud10R2Qte();
            this.qte11 = this.budget.getBud11R2Qte();
            this.qte12 = this.budget.getBud12R2Qte();
         } else if (this.var_choix_reamenagement.equalsIgnoreCase("2")) {
            this.montantTotal = this.budget.getBud03TotVal();
            this.qteTotal = this.budget.getBud03TotQte();
            this.val01 = this.budget.getBud01R3Val();
            this.val02 = this.budget.getBud02R3Val();
            this.val03 = this.budget.getBud03R3Val();
            this.val04 = this.budget.getBud04R3Val();
            this.val05 = this.budget.getBud05R3Val();
            this.val06 = this.budget.getBud06R3Val();
            this.val07 = this.budget.getBud07R3Val();
            this.val08 = this.budget.getBud08R3Val();
            this.val09 = this.budget.getBud09R3Val();
            this.val10 = this.budget.getBud10R3Val();
            this.val11 = this.budget.getBud11R3Val();
            this.val12 = this.budget.getBud12R3Val();
            this.qte01 = this.budget.getBud01R3Qte();
            this.qte02 = this.budget.getBud02R3Qte();
            this.qte03 = this.budget.getBud03R3Qte();
            this.qte04 = this.budget.getBud04R3Qte();
            this.qte05 = this.budget.getBud05R3Qte();
            this.qte06 = this.budget.getBud06R3Qte();
            this.qte07 = this.budget.getBud07R3Qte();
            this.qte08 = this.budget.getBud08R3Qte();
            this.qte09 = this.budget.getBud09R3Qte();
            this.qte10 = this.budget.getBud10R3Qte();
            this.qte11 = this.budget.getBud11R3Qte();
            this.qte12 = this.budget.getBud12R3Qte();
         } else if (this.var_choix_reamenagement.equalsIgnoreCase("3")) {
            this.montantTotal = this.budget.getBud04TotVal();
            this.qteTotal = this.budget.getBud04TotQte();
            this.val01 = this.budget.getBud01R4Val();
            this.val02 = this.budget.getBud02R4Val();
            this.val03 = this.budget.getBud03R4Val();
            this.val04 = this.budget.getBud04R4Val();
            this.val05 = this.budget.getBud05R4Val();
            this.val06 = this.budget.getBud06R4Val();
            this.val07 = this.budget.getBud07R4Val();
            this.val08 = this.budget.getBud08R4Val();
            this.val09 = this.budget.getBud09R4Val();
            this.val10 = this.budget.getBud10R4Val();
            this.val11 = this.budget.getBud11R4Val();
            this.val12 = this.budget.getBud12R4Val();
            this.qte01 = this.budget.getBud01R4Qte();
            this.qte02 = this.budget.getBud02R4Qte();
            this.qte03 = this.budget.getBud03R4Qte();
            this.qte04 = this.budget.getBud04R4Qte();
            this.qte05 = this.budget.getBud05R4Qte();
            this.qte06 = this.budget.getBud06R4Qte();
            this.qte07 = this.budget.getBud07R4Qte();
            this.qte08 = this.budget.getBud08R4Qte();
            this.qte09 = this.budget.getBud09R4Qte();
            this.qte10 = this.budget.getBud10R4Qte();
            this.qte11 = this.budget.getBud11R4Qte();
            this.qte12 = this.budget.getBud12R4Qte();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Budget");
         this.formAnalytique.initAnalytique(this.optionComptabilite, var1);
         this.formAnalytique.chargementDetailAnalytiqueBudget(this.budget, false, this.var_choix_reamenagement, var1);
         this.utilInitHibernate.closeSession();
         this.showModalPanelDetail = true;
      }

   }

   public void supprimerBudget() throws HibernateException, NamingException {
      if (this.budget != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Budget");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            var1.setFlushMode(FlushMode.MANUAL);
            this.lesBudgetsLigne.clear();
            this.lesBudgetsLigne = this.budgetLigneDao.chargerLigneBudget(this.budget, var1);
            if (this.lesBudgetsLigne.size() != 0) {
               this.budgetLigne = new BudgetLigne();

               for(int var3 = 0; var3 < this.lesBudgetsLigne.size(); ++var3) {
                  this.budgetLigne = (BudgetLigne)this.lesBudgetsLigne.get(var3);
                  this.budgetLigneDao.delete(this.budgetLigne, var1);
               }

               var1.flush();
            }

            this.budgetDao.delete(this.budget, var1);
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
      }

      this.recherche();
   }

   public void duppliquerBudget() throws NamingException {
      if (this.lesBudgets.size() != 0) {
         long var1 = 0L;
         ExercicesComptableDao var3 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
         new ExercicesComptable();
         ExercicesComptable var4;
         if (this.selectedExo.getExecptEtat() != 0) {
            var4 = var3.recupererLastExo((Session)null);
            var1 = var4.getExecpt_id();
         } else {
            var1 = this.selectedExo.getExecpt_id() + 1L;
            var4 = var3.recupererLExoPrecis(var1, (Session)null);
            if (var4 == null) {
               var1 = this.selectedExo.getExecpt_id();

               for(int var5 = 0; var5 < this.mesAnneeItems.size(); ++var5) {
                  this.var_annee = ((SelectItem)this.mesAnneeItems.get(var5)).getValue().toString();
               }

               var4 = var3.recupererLExoPrecis(var1, (Session)null);
               if (var4.getExecpt_id() != Long.parseLong(this.var_annee)) {
                  var1 = Long.parseLong(this.var_annee);
               } else {
                  var4 = null;
               }
            }
         }

         if (var4 != null && var4.getExecpt_id() != 0L) {
            Session var29 = this.utilInitHibernate.getOpenSession(this.baseLog, "Budget");
            Transaction var6 = null;

            try {
               var6 = var29.beginTransaction();
               ArrayList var7 = new ArrayList();
               new Budget();

               Budget var8;
               for(int var9 = 0; var9 < this.lesBudgets.size(); ++var9) {
                  this.budget = (Budget)this.lesBudgets.get(var9);
                  var8 = this.budgetDao.rechercheBudget(this.baseLog, "" + var1, var29);
                  if (var8 == null) {
                     var8 = new Budget();
                     var8.setBud01R1Qte(this.budget.getBud01R1Qte());
                     var8.setBud01R2Qte(this.budget.getBud01R1Qte());
                     var8.setBud01R3Qte(this.budget.getBud01R1Qte());
                     var8.setBud01R4Qte(this.budget.getBud01R1Qte());
                     var8.setBud01R1Val(this.budget.getBud01R1Val());
                     var8.setBud01R2Val(this.budget.getBud01R2Val());
                     var8.setBud01R3Val(this.budget.getBud01R3Val());
                     var8.setBud01R4Val(this.budget.getBud01R4Val());
                     var8.setBud02R1Qte(this.budget.getBud02R1Qte());
                     var8.setBud02R2Qte(this.budget.getBud02R1Qte());
                     var8.setBud02R3Qte(this.budget.getBud02R1Qte());
                     var8.setBud02R4Qte(this.budget.getBud02R1Qte());
                     var8.setBud02R1Val(this.budget.getBud02R1Val());
                     var8.setBud02R2Val(this.budget.getBud02R2Val());
                     var8.setBud02R3Val(this.budget.getBud02R3Val());
                     var8.setBud02R4Val(this.budget.getBud02R4Val());
                     var8.setBud03R1Qte(this.budget.getBud03R1Qte());
                     var8.setBud03R2Qte(this.budget.getBud03R1Qte());
                     var8.setBud03R3Qte(this.budget.getBud03R1Qte());
                     var8.setBud03R4Qte(this.budget.getBud03R1Qte());
                     var8.setBud03R1Val(this.budget.getBud03R1Val());
                     var8.setBud03R2Val(this.budget.getBud03R2Val());
                     var8.setBud03R3Val(this.budget.getBud03R3Val());
                     var8.setBud03R4Val(this.budget.getBud03R4Val());
                     var8.setBud04R1Qte(this.budget.getBud04R1Qte());
                     var8.setBud04R2Qte(this.budget.getBud04R1Qte());
                     var8.setBud04R3Qte(this.budget.getBud04R1Qte());
                     var8.setBud04R4Qte(this.budget.getBud04R1Qte());
                     var8.setBud04R1Val(this.budget.getBud04R1Val());
                     var8.setBud04R2Val(this.budget.getBud04R2Val());
                     var8.setBud04R3Val(this.budget.getBud04R3Val());
                     var8.setBud04R4Val(this.budget.getBud04R4Val());
                     var8.setBud05R1Qte(this.budget.getBud05R1Qte());
                     var8.setBud05R2Qte(this.budget.getBud05R1Qte());
                     var8.setBud05R3Qte(this.budget.getBud05R1Qte());
                     var8.setBud05R4Qte(this.budget.getBud05R1Qte());
                     var8.setBud05R1Val(this.budget.getBud05R1Val());
                     var8.setBud05R2Val(this.budget.getBud05R2Val());
                     var8.setBud05R3Val(this.budget.getBud05R3Val());
                     var8.setBud05R4Val(this.budget.getBud05R4Val());
                     var8.setBud06R1Qte(this.budget.getBud06R1Qte());
                     var8.setBud06R2Qte(this.budget.getBud06R1Qte());
                     var8.setBud06R3Qte(this.budget.getBud06R1Qte());
                     var8.setBud06R4Qte(this.budget.getBud06R1Qte());
                     var8.setBud06R1Val(this.budget.getBud06R1Val());
                     var8.setBud06R2Val(this.budget.getBud06R2Val());
                     var8.setBud06R3Val(this.budget.getBud06R3Val());
                     var8.setBud06R4Val(this.budget.getBud06R4Val());
                     var8.setBud07R1Qte(this.budget.getBud07R1Qte());
                     var8.setBud07R2Qte(this.budget.getBud07R1Qte());
                     var8.setBud07R3Qte(this.budget.getBud07R1Qte());
                     var8.setBud07R4Qte(this.budget.getBud07R1Qte());
                     var8.setBud07R1Val(this.budget.getBud07R1Val());
                     var8.setBud07R2Val(this.budget.getBud07R2Val());
                     var8.setBud07R3Val(this.budget.getBud07R3Val());
                     var8.setBud07R4Val(this.budget.getBud07R4Val());
                     var8.setBud08R1Qte(this.budget.getBud08R1Qte());
                     var8.setBud08R2Qte(this.budget.getBud08R1Qte());
                     var8.setBud08R3Qte(this.budget.getBud08R1Qte());
                     var8.setBud08R4Qte(this.budget.getBud08R1Qte());
                     var8.setBud08R1Val(this.budget.getBud08R1Val());
                     var8.setBud08R2Val(this.budget.getBud08R2Val());
                     var8.setBud08R3Val(this.budget.getBud08R3Val());
                     var8.setBud08R4Val(this.budget.getBud08R4Val());
                     var8.setBud09R1Qte(this.budget.getBud09R1Qte());
                     var8.setBud09R2Qte(this.budget.getBud09R1Qte());
                     var8.setBud09R3Qte(this.budget.getBud09R1Qte());
                     var8.setBud09R4Qte(this.budget.getBud09R1Qte());
                     var8.setBud09R1Val(this.budget.getBud09R1Val());
                     var8.setBud09R2Val(this.budget.getBud09R2Val());
                     var8.setBud09R3Val(this.budget.getBud09R3Val());
                     var8.setBud09R4Val(this.budget.getBud09R4Val());
                     var8.setBud10R1Qte(this.budget.getBud10R1Qte());
                     var8.setBud10R2Qte(this.budget.getBud10R1Qte());
                     var8.setBud10R3Qte(this.budget.getBud10R1Qte());
                     var8.setBud10R4Qte(this.budget.getBud10R1Qte());
                     var8.setBud10R1Val(this.budget.getBud10R1Val());
                     var8.setBud10R2Val(this.budget.getBud10R2Val());
                     var8.setBud10R3Val(this.budget.getBud10R3Val());
                     var8.setBud10R4Val(this.budget.getBud10R4Val());
                     var8.setBud11R1Qte(this.budget.getBud11R1Qte());
                     var8.setBud11R2Qte(this.budget.getBud11R1Qte());
                     var8.setBud11R3Qte(this.budget.getBud11R1Qte());
                     var8.setBud11R4Qte(this.budget.getBud11R1Qte());
                     var8.setBud11R1Val(this.budget.getBud11R1Val());
                     var8.setBud11R2Val(this.budget.getBud11R2Val());
                     var8.setBud11R3Val(this.budget.getBud11R3Val());
                     var8.setBud11R4Val(this.budget.getBud11R4Val());
                     var8.setBud12R1Qte(this.budget.getBud12R1Qte());
                     var8.setBud12R2Qte(this.budget.getBud12R1Qte());
                     var8.setBud12R3Qte(this.budget.getBud12R1Qte());
                     var8.setBud12R4Qte(this.budget.getBud12R1Qte());
                     var8.setBud12R1Val(this.budget.getBud12R1Val());
                     var8.setBud12R2Val(this.budget.getBud12R2Val());
                     var8.setBud12R3Val(this.budget.getBud12R3Val());
                     var8.setBud12R4Val(this.budget.getBud12R4Val());
                     var8.setBud01TotQte(this.budget.getBud01TotQte());
                     var8.setBud01TotVal(this.budget.getBud01TotVal());
                     var8.setBud02TotQte(this.budget.getBud02TotQte());
                     var8.setBud02TotVal(this.budget.getBud02TotVal());
                     var8.setBud03TotQte(this.budget.getBud03TotQte());
                     var8.setBud03TotVal(this.budget.getBud03TotVal());
                     var8.setBud04TotQte(this.budget.getBud04TotQte());
                     var8.setBud04TotVal(this.budget.getBud04TotVal());
                     var8.setBudAxe01(this.budget.isBudAxe01());
                     var8.setBudAxe02(this.budget.isBudAxe02());
                     var8.setBudAxe03(this.budget.isBudAxe03());
                     var8.setBudAxe04(this.budget.isBudAxe04());
                     var8.setBudAxe05(this.budget.isBudAxe05());
                     var8.setBudAxe06(this.budget.isBudAxe06());
                     var8.setBudAxe07(this.budget.isBudAxe07());
                     var8.setBudAxe08(this.budget.isBudAxe08());
                     var8.setBudAxe09(this.budget.isBudAxe09());
                     var8.setBudAxe10(this.budget.isBudAxe10());
                     var8.setBudAxe11(this.budget.isBudAxe11());
                     var8.setBudAxe12(this.budget.isBudAxe12());
                     var8.setBudCode(this.budget.getBudCode());
                     var8.setBudLibelleFr(this.budget.getBudLibelleFr());
                     var8.setBudLibelleSp(this.budget.getBudLibelleSp());
                     var8.setBudLibelleUk(this.budget.getBudLibelleUk());
                     var8.setBudEntite(this.budget.getBudEntite());
                     var8.setBudNature(this.budget.getBudNature());
                     var8.setBudProjet(this.budget.getBudProjet());
                     var8.setBudAnnee("" + var1);
                     var8.setBudUserCreat(this.usersLog.getUsrid());
                     var8.setBudDateCreat(new Date());
                     var8.setBudUserModif(0L);
                     var8.setBudDateModif((Date)null);
                     var8.setBudIdOld(this.budget.getBud_id());
                     var8.setExercicescomptable(var4);
                     var8 = this.budgetDao.insert(var8, var29);
                     var7.add(var8);
                  } else {
                     var7.add(var8);
                  }
               }

               new ArrayList();
               List var30 = this.budgetLigneDao.chargerLigneBudget(this.selectedExo, this.var_annee, var29);
               this.budgetLigneDao.delete(var30, var29);
               long var10 = var1 - 1L;
               var30 = this.budgetLigneDao.chargerLigneBudget(this.selectedExo, "" + var10, var29);
               int var16;
               if (var30.size() != 0) {
                  new BudgetLigne();

                  for(int var13 = 0; var13 < var30.size(); ++var13) {
                     this.budgetLigne = (BudgetLigne)var30.get(var13);
                     BudgetLigne var12 = new BudgetLigne();
                     var12.setBudlig01R1Qte(this.budgetLigne.getBudlig01R1Qte());
                     var12.setBudlig01R2Qte(this.budgetLigne.getBudlig01R2Qte());
                     var12.setBudlig01R3Qte(this.budgetLigne.getBudlig01R3Qte());
                     var12.setBudlig01R4Qte(this.budgetLigne.getBudlig01R4Qte());
                     var12.setBudlig02R1Qte(this.budgetLigne.getBudlig02R1Qte());
                     var12.setBudlig02R2Qte(this.budgetLigne.getBudlig02R2Qte());
                     var12.setBudlig02R3Qte(this.budgetLigne.getBudlig02R3Qte());
                     var12.setBudlig02R4Qte(this.budgetLigne.getBudlig02R4Qte());
                     var12.setBudlig03R1Qte(this.budgetLigne.getBudlig03R1Qte());
                     var12.setBudlig03R2Qte(this.budgetLigne.getBudlig03R2Qte());
                     var12.setBudlig03R3Qte(this.budgetLigne.getBudlig03R3Qte());
                     var12.setBudlig03R4Qte(this.budgetLigne.getBudlig03R4Qte());
                     var12.setBudlig04R1Qte(this.budgetLigne.getBudlig04R1Qte());
                     var12.setBudlig04R2Qte(this.budgetLigne.getBudlig04R2Qte());
                     var12.setBudlig04R3Qte(this.budgetLigne.getBudlig04R3Qte());
                     var12.setBudlig04R4Qte(this.budgetLigne.getBudlig04R4Qte());
                     var12.setBudlig05R1Qte(this.budgetLigne.getBudlig05R1Qte());
                     var12.setBudlig05R2Qte(this.budgetLigne.getBudlig05R2Qte());
                     var12.setBudlig05R3Qte(this.budgetLigne.getBudlig05R3Qte());
                     var12.setBudlig05R4Qte(this.budgetLigne.getBudlig05R4Qte());
                     var12.setBudlig06R1Qte(this.budgetLigne.getBudlig06R1Qte());
                     var12.setBudlig06R2Qte(this.budgetLigne.getBudlig06R2Qte());
                     var12.setBudlig06R3Qte(this.budgetLigne.getBudlig06R3Qte());
                     var12.setBudlig06R4Qte(this.budgetLigne.getBudlig06R4Qte());
                     var12.setBudlig07R1Qte(this.budgetLigne.getBudlig07R1Qte());
                     var12.setBudlig07R2Qte(this.budgetLigne.getBudlig07R2Qte());
                     var12.setBudlig07R3Qte(this.budgetLigne.getBudlig07R3Qte());
                     var12.setBudlig07R4Qte(this.budgetLigne.getBudlig07R4Qte());
                     var12.setBudlig08R1Qte(this.budgetLigne.getBudlig08R1Qte());
                     var12.setBudlig08R2Qte(this.budgetLigne.getBudlig08R2Qte());
                     var12.setBudlig08R3Qte(this.budgetLigne.getBudlig08R3Qte());
                     var12.setBudlig08R4Qte(this.budgetLigne.getBudlig08R4Qte());
                     var12.setBudlig09R1Qte(this.budgetLigne.getBudlig09R1Qte());
                     var12.setBudlig09R2Qte(this.budgetLigne.getBudlig09R2Qte());
                     var12.setBudlig09R3Qte(this.budgetLigne.getBudlig09R3Qte());
                     var12.setBudlig09R4Qte(this.budgetLigne.getBudlig09R4Qte());
                     var12.setBudlig10R1Qte(this.budgetLigne.getBudlig10R1Qte());
                     var12.setBudlig10R2Qte(this.budgetLigne.getBudlig10R2Qte());
                     var12.setBudlig10R3Qte(this.budgetLigne.getBudlig10R3Qte());
                     var12.setBudlig10R4Qte(this.budgetLigne.getBudlig10R4Qte());
                     var12.setBudlig11R1Qte(this.budgetLigne.getBudlig11R1Qte());
                     var12.setBudlig11R2Qte(this.budgetLigne.getBudlig11R2Qte());
                     var12.setBudlig11R3Qte(this.budgetLigne.getBudlig11R3Qte());
                     var12.setBudlig11R4Qte(this.budgetLigne.getBudlig11R4Qte());
                     var12.setBudlig12R1Qte(this.budgetLigne.getBudlig12R1Qte());
                     var12.setBudlig12R2Qte(this.budgetLigne.getBudlig12R2Qte());
                     var12.setBudlig12R3Qte(this.budgetLigne.getBudlig12R3Qte());
                     var12.setBudlig12R4Qte(this.budgetLigne.getBudlig12R4Qte());
                     var12.setBudlig01R1Val(this.budgetLigne.getBudlig01R1Val());
                     var12.setBudlig01R2Val(this.budgetLigne.getBudlig01R2Val());
                     var12.setBudlig01R3Val(this.budgetLigne.getBudlig01R3Val());
                     var12.setBudlig01R4Val(this.budgetLigne.getBudlig01R4Val());
                     var12.setBudlig02R1Val(this.budgetLigne.getBudlig02R1Val());
                     var12.setBudlig02R2Val(this.budgetLigne.getBudlig02R2Val());
                     var12.setBudlig02R3Val(this.budgetLigne.getBudlig02R3Val());
                     var12.setBudlig02R4Val(this.budgetLigne.getBudlig02R4Val());
                     var12.setBudlig03R1Val(this.budgetLigne.getBudlig03R1Val());
                     var12.setBudlig03R2Val(this.budgetLigne.getBudlig03R2Val());
                     var12.setBudlig03R3Val(this.budgetLigne.getBudlig03R3Val());
                     var12.setBudlig03R4Val(this.budgetLigne.getBudlig03R4Val());
                     var12.setBudlig04R1Val(this.budgetLigne.getBudlig04R1Val());
                     var12.setBudlig04R2Val(this.budgetLigne.getBudlig04R2Val());
                     var12.setBudlig04R3Val(this.budgetLigne.getBudlig04R3Val());
                     var12.setBudlig04R4Val(this.budgetLigne.getBudlig04R4Val());
                     var12.setBudlig05R1Val(this.budgetLigne.getBudlig05R1Val());
                     var12.setBudlig05R2Val(this.budgetLigne.getBudlig05R2Val());
                     var12.setBudlig05R3Val(this.budgetLigne.getBudlig05R3Val());
                     var12.setBudlig05R4Val(this.budgetLigne.getBudlig05R4Val());
                     var12.setBudlig06R1Val(this.budgetLigne.getBudlig06R1Val());
                     var12.setBudlig06R2Val(this.budgetLigne.getBudlig06R2Val());
                     var12.setBudlig06R3Val(this.budgetLigne.getBudlig06R3Val());
                     var12.setBudlig06R4Val(this.budgetLigne.getBudlig06R4Val());
                     var12.setBudlig07R1Val(this.budgetLigne.getBudlig07R1Val());
                     var12.setBudlig07R2Val(this.budgetLigne.getBudlig07R2Val());
                     var12.setBudlig07R3Val(this.budgetLigne.getBudlig07R3Val());
                     var12.setBudlig07R4Val(this.budgetLigne.getBudlig07R4Val());
                     var12.setBudlig08R1Val(this.budgetLigne.getBudlig08R1Val());
                     var12.setBudlig08R2Val(this.budgetLigne.getBudlig08R2Val());
                     var12.setBudlig08R3Val(this.budgetLigne.getBudlig08R3Val());
                     var12.setBudlig08R4Val(this.budgetLigne.getBudlig08R4Val());
                     var12.setBudlig09R1Val(this.budgetLigne.getBudlig09R1Val());
                     var12.setBudlig09R2Val(this.budgetLigne.getBudlig09R2Val());
                     var12.setBudlig09R3Val(this.budgetLigne.getBudlig09R3Val());
                     var12.setBudlig09R4Val(this.budgetLigne.getBudlig09R4Val());
                     var12.setBudlig10R1Val(this.budgetLigne.getBudlig10R1Val());
                     var12.setBudlig10R2Val(this.budgetLigne.getBudlig10R2Val());
                     var12.setBudlig10R3Val(this.budgetLigne.getBudlig10R3Val());
                     var12.setBudlig10R4Val(this.budgetLigne.getBudlig10R4Val());
                     var12.setBudlig11R1Val(this.budgetLigne.getBudlig11R1Val());
                     var12.setBudlig11R2Val(this.budgetLigne.getBudlig11R2Val());
                     var12.setBudlig11R3Val(this.budgetLigne.getBudlig11R3Val());
                     var12.setBudlig11R4Val(this.budgetLigne.getBudlig11R4Val());
                     var12.setBudlig12R1Val(this.budgetLigne.getBudlig12R1Val());
                     var12.setBudlig12R2Val(this.budgetLigne.getBudlig12R2Val());
                     var12.setBudlig12R3Val(this.budgetLigne.getBudlig12R3Val());
                     var12.setBudlig12R4Val(this.budgetLigne.getBudlig12R4Val());
                     var12.setBudlig01TotQte(this.budgetLigne.getBudlig01TotQte());
                     var12.setBudlig02TotQte(this.budgetLigne.getBudlig02TotQte());
                     var12.setBudlig03TotQte(this.budgetLigne.getBudlig03TotQte());
                     var12.setBudlig04TotQte(this.budgetLigne.getBudlig04TotQte());
                     var12.setBudlig01TotVal(this.budgetLigne.getBudlig01TotVal());
                     var12.setBudlig02TotVal(this.budgetLigne.getBudlig02TotVal());
                     var12.setBudlig03TotVal(this.budgetLigne.getBudlig03TotVal());
                     var12.setBudlig04TotVal(this.budgetLigne.getBudlig04TotVal());
                     var12.setBudligActivite(this.budgetLigne.getBudligActivite());
                     var12.setBudligAgent(this.budgetLigne.getBudligAgent());
                     var12.setBudligAgentLib(this.budgetLigne.getBudligAgentLib());
                     var12.setBudligAnal1(this.budgetLigne.getBudligAnal1());
                     var12.setBudligAnal2(this.budgetLigne.getBudligAnal2());
                     var12.setBudligAnal3(this.budgetLigne.getBudligAnal3());
                     var12.setBudligAnal4(this.budgetLigne.getBudligAnal4());
                     var12.setBudligAtelier(this.budgetLigne.getBudligAtelier());
                     var12.setBudligAtelierLib(this.budgetLigne.getBudligAtelierLib());
                     var12.setBudligAxe(this.budgetLigne.getBudligAxe());
                     var12.setBudligCode(this.budgetLigne.getBudligCode());
                     var12.setBudligDepartement(this.budgetLigne.getBudligDepartement());
                     var12.setBudligDepartementLib(this.budgetLigne.getBudligDepartementLib());
                     var12.setBudligEntite(this.budgetLigne.getBudligEntite());
                     var12.setBudligEntiteLib(this.budgetLigne.getBudligEntiteLib());
                     var12.setBudligLibActivite(this.budgetLigne.getBudligLibActivite());
                     var12.setBudligLibAnal1(this.budgetLigne.getBudligLibAnal1());
                     var12.setBudligLibAnal2(this.budgetLigne.getBudligLibAnal2());
                     var12.setBudligLibAnal3(this.budgetLigne.getBudligLibAnal3());
                     var12.setBudligLibAnal4(this.budgetLigne.getBudligLibAnal4());
                     var12.setBudligLigne(this.budgetLigne.getBudligLigne());
                     var12.setBudligLigneLib(this.budgetLigne.getBudligLigneLib());
                     var12.setBudligMontantSaisie(this.budgetLigne.getBudligMontantSaisie());
                     var12.setBudligPdv(this.budgetLigne.getBudligPdv());
                     var12.setBudligPdvLib(this.budgetLigne.getBudligPdvLib());
                     var12.setBudligPoste(this.budgetLigne.getBudligPoste());
                     var12.setBudligPosteLib(this.budgetLigne.getBudligPosteLib());
                     var12.setBudligPourcentSaisie(this.budgetLigne.getBudligPourcentSaisie());
                     var12.setBudligProjet(this.budgetLigne.getBudligProjet());
                     var12.setBudligProjetLib(this.budgetLigne.getBudligProjetLib());
                     var12.setBudligQteSaisie(this.budgetLigne.getBudligQteSaisie());
                     var12.setBudligRegion(this.budgetLigne.getBudligRegion());
                     var12.setBudligRegionLib(this.budgetLigne.getBudligRegionLib());
                     var12.setBudligRepCle(this.budgetLigne.getBudligRepCle());
                     var12.setBudligSecteur(this.budgetLigne.getBudligSecteur());
                     var12.setBudligSecteurLib(this.budgetLigne.getBudligSecteurLib());
                     var12.setBudligService(this.budgetLigne.getBudligService());
                     var12.setBudligServiceLib(this.budgetLigne.getBudligServiceLib());
                     var12.setBudligSite(this.budgetLigne.getBudligSite());
                     var12.setBudligSiteLib(this.budgetLigne.getBudligSiteLib());
                     var12.setBudligStr(this.budgetLigne.getBudligStr());
                     var12.setBudligStrCle(this.budgetLigne.getBudligStrCle());
                     var12.setBudligStrLib(this.budgetLigne.getBudligStrLib());
                     var12.setBudligTypeCle(this.budgetLigne.getBudligTypeCle());
                     var12.setBudligUtil(this.budgetLigne.getBudligUtil());
                     long var14 = this.budgetLigne.getBudget().getBud_id();

                     for(var16 = 0; var16 < var7.size(); ++var16) {
                        var8 = (Budget)var7.get(var16);
                        if (var8.getBudIdOld() == var14) {
                           var12.setBudget(var8);
                           var12 = this.budgetLigneDao.insert(var12, var29);
                        }
                     }
                  }
               }

               new ArrayList();
               ArrayList var32 = new ArrayList();
               List var31 = this.plansBudgetairesDao.chargerLesPlansBudgetaires(var4, 0, this.var_nature, this.var_annee, var29);
               new PlansBudgetaires();
               new PlansBudgetaires();

               PlansBudgetaires var33;
               for(var16 = 0; var16 < var31.size(); ++var16) {
                  var33 = (PlansBudgetaires)var31.get(var16);
                  PlansBudgetaires var15 = new PlansBudgetaires();
                  var15.setPlbActivite(var33.getPlbActivite());
                  var15.setPlbBloque(var33.getPlbBloque());
                  var15.setPlbChoixBudget(var33.getPlbChoixBudget());
                  var15.setPlbCode(var33.getPlbCode());
                  var15.setPlbEntite(var33.getPlbEntite());
                  var15.setPlbInactif(var33.getPlbInactif());
                  var15.setPlbLibelleFr(var33.getPlbLibelleFr());
                  var15.setPlbLibelleSp(var33.getPlbLibelleSp());
                  var15.setPlbLibelleUk(var33.getPlbLibelleUk());
                  var15.setPlbNature(var33.getPlbNature());
                  var15.setPlbOrdre(var33.getPlbOrdre());
                  var15.setPlbProjet(var33.getPlbProjet());
                  var15.setPlbType(var33.getPlbType());
                  var15.setPlbAnnee("" + var1);
                  var15.setPlbUserCreat(this.usersLog.getUsrid());
                  var15.setPlbDateCreat(new Date());
                  var15.setPlbUserModif(0L);
                  var15.setPlbDateModif((Date)null);
                  var15.setPlbIdOld(var33.getPlb_id());
                  var15.setExercicesComptable(var4);
                  var15 = this.plansBudgetairesDao.insert(var15, var29);
                  var32.add(var15);
               }

               new ArrayList();
               PlanBudgetaireCompteDao var17 = new PlanBudgetaireCompteDao(this.baseLog, this.utilInitHibernate);
               List var34 = var17.chargerLesComptesAnnee((ExercicesComptable)this.selectedExo, 0, var29);
               if (var34.size() != 0) {
                  new PlanBudgetaireCompte();
                  new PlanBudgetaireCompte();

                  for(int var20 = 0; var20 < var34.size(); ++var20) {
                     PlanBudgetaireCompte var18 = (PlanBudgetaireCompte)var34.get(var20);
                     PlanBudgetaireCompte var19 = new PlanBudgetaireCompte();
                     var19.setPlbcpt01R1Val(var18.getPlbcpt01R1Val());
                     var19.setPlbcpt01R2Val(var18.getPlbcpt01R2Val());
                     var19.setPlbcpt01R3Val(var18.getPlbcpt01R3Val());
                     var19.setPlbcpt01R4Val(var18.getPlbcpt01R4Val());
                     var19.setPlbcpt02R1Val(var18.getPlbcpt02R1Val());
                     var19.setPlbcpt02R2Val(var18.getPlbcpt02R2Val());
                     var19.setPlbcpt02R3Val(var18.getPlbcpt02R3Val());
                     var19.setPlbcpt02R4Val(var18.getPlbcpt02R4Val());
                     var19.setPlbcpt03R1Val(var18.getPlbcpt03R1Val());
                     var19.setPlbcpt03R2Val(var18.getPlbcpt03R2Val());
                     var19.setPlbcpt03R3Val(var18.getPlbcpt03R3Val());
                     var19.setPlbcpt03R4Val(var18.getPlbcpt03R4Val());
                     var19.setPlbcpt04R1Val(var18.getPlbcpt04R1Val());
                     var19.setPlbcpt04R2Val(var18.getPlbcpt04R2Val());
                     var19.setPlbcpt04R3Val(var18.getPlbcpt04R3Val());
                     var19.setPlbcpt04R4Val(var18.getPlbcpt04R4Val());
                     var19.setPlbcpt05R1Val(var18.getPlbcpt05R1Val());
                     var19.setPlbcpt05R2Val(var18.getPlbcpt05R2Val());
                     var19.setPlbcpt05R3Val(var18.getPlbcpt05R3Val());
                     var19.setPlbcpt05R4Val(var18.getPlbcpt05R4Val());
                     var19.setPlbcpt06R1Val(var18.getPlbcpt06R1Val());
                     var19.setPlbcpt06R2Val(var18.getPlbcpt06R2Val());
                     var19.setPlbcpt06R3Val(var18.getPlbcpt06R3Val());
                     var19.setPlbcpt06R4Val(var18.getPlbcpt06R4Val());
                     var19.setPlbcpt07R1Val(var18.getPlbcpt07R1Val());
                     var19.setPlbcpt07R2Val(var18.getPlbcpt07R2Val());
                     var19.setPlbcpt07R3Val(var18.getPlbcpt07R3Val());
                     var19.setPlbcpt07R4Val(var18.getPlbcpt07R4Val());
                     var19.setPlbcpt08R1Val(var18.getPlbcpt08R1Val());
                     var19.setPlbcpt08R2Val(var18.getPlbcpt08R2Val());
                     var19.setPlbcpt08R3Val(var18.getPlbcpt08R3Val());
                     var19.setPlbcpt08R4Val(var18.getPlbcpt08R4Val());
                     var19.setPlbcpt09R1Val(var18.getPlbcpt09R1Val());
                     var19.setPlbcpt09R2Val(var18.getPlbcpt09R2Val());
                     var19.setPlbcpt09R3Val(var18.getPlbcpt09R3Val());
                     var19.setPlbcpt09R4Val(var18.getPlbcpt09R4Val());
                     var19.setPlbcpt10R1Val(var18.getPlbcpt10R1Val());
                     var19.setPlbcpt10R2Val(var18.getPlbcpt10R2Val());
                     var19.setPlbcpt10R3Val(var18.getPlbcpt10R3Val());
                     var19.setPlbcpt10R4Val(var18.getPlbcpt10R4Val());
                     var19.setPlbcpt11R1Val(var18.getPlbcpt11R1Val());
                     var19.setPlbcpt11R2Val(var18.getPlbcpt11R2Val());
                     var19.setPlbcpt11R3Val(var18.getPlbcpt11R3Val());
                     var19.setPlbcpt11R4Val(var18.getPlbcpt11R4Val());
                     var19.setPlbcpt12R1Val(var18.getPlbcpt12R1Val());
                     var19.setPlbcpt12R2Val(var18.getPlbcpt12R2Val());
                     var19.setPlbcpt12R3Val(var18.getPlbcpt12R3Val());
                     var19.setPlbcpt12R4Val(var18.getPlbcpt12R4Val());
                     var19.setPlbcptChoixBudget(var18.getPlbcptChoixBudget());
                     var19.setPlbcptCode(var18.getPlbcptCode());
                     var19.setPlbcptCompte(var18.getPlbcptCompte());
                     var19.setPlbcptLibelleFr(var18.getPlbcptLibelleFr());
                     var19.setPlbcptLibelleSp(var18.getPlbcptLibelleSp());
                     var19.setPlbcptLibelleUk(var18.getPlbcptLibelleUk());
                     var19.setPlbcptNature(var18.getPlbcptNature());
                     var19.setPlbcptType(var18.getPlbcptType());
                     long var21 = var18.getPlanbudgetaire().getPlbIdOld();

                     for(int var23 = 0; var23 < var32.size(); ++var23) {
                        var33 = (PlansBudgetaires)var32.get(var23);
                        if (var33.getPlbIdOld() == var21) {
                           var19.setPlanbudgetaire(var33);
                           var19 = var17.insert(var19, var29);
                        }
                     }
                  }
               }

               var6.commit();
            } catch (HibernateException var27) {
               if (var6 != null) {
                  var6.rollback();
               }

               throw var27;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

   }

   public void selectionBudget() throws HibernateException, NamingException {
      if (this.dataModelLesBudgets.isRowAvailable()) {
         this.budget = (Budget)this.dataModelLesBudgets.getRowData();
         this.budget.setBudUtil(Integer.parseInt(this.var_choix_reamenagement));
         this.lesBudgetsLigne.clear();
         this.budgetLigne.setBudligUtil(Integer.parseInt(this.var_choix_reamenagement));
         this.lesBudgetsLigne = this.budgetLigneDao.chargerLigneBudget((Budget)this.budget, (Session)null);
         this.dataModelLesBudgetsLigne.setWrappedData(this.lesBudgetsLigne);
         this.testaffSupp = true;
         this.budtestDupliquer = true;
      }

   }

   public void annulerBudget() {
      this.showModalPanelDetail = false;
   }

   public void duppliquerEntiteBudget() throws NamingException {
      if (this.budget != null && this.budget.getBudType() == 15 && this.budget.getBudEntite() != null && !this.budget.getBudEntite().isEmpty()) {
         String var1 = this.budget.getBudEntite();
         int var2 = 0;
         if (this.mesEntitesItems.size() != 0) {
            for(int var3 = 0; var3 < this.mesEntitesItems.size(); ++var3) {
               if (this.budget.getBudType() == 15) {
                  ++var2;
               }
            }
         }

         ++var2;
         String var15 = "";
         if (var2 >= 1 && var2 <= 9) {
            var15 = "00" + var2;
         } else if (var2 >= 10 && var2 <= 99) {
            var15 = "0" + var2;
         } else {
            var15 = "" + var2;
         }

         ArrayList var4 = new ArrayList();

         for(int var5 = 0; var5 < this.lesBudgets.size(); ++var5) {
            if (((Budget)this.lesBudgets.get(var5)).getBudEntite().equals(var1)) {
               var4.add(this.lesBudgets.get(var5));
            }
         }

         if (var4.size() != 0) {
            Session var16 = this.utilInitHibernate.getOpenSession(this.baseLog, "Budget");
            Transaction var6 = null;

            try {
               var6 = var16.beginTransaction();
               new Budget();
               int var8 = 0;

               while(true) {
                  if (var8 >= var4.size()) {
                     var6.commit();
                     break;
                  }

                  Budget var7 = new Budget();
                  var7.setBud01R1Qte(((Budget)var4.get(var8)).getBud01R1Qte());
                  var7.setBud01R1Val(((Budget)var4.get(var8)).getBud01R1Val());
                  var7.setBud01R2Qte(((Budget)var4.get(var8)).getBud01R2Qte());
                  var7.setBud01R2Val(((Budget)var4.get(var8)).getBud01R2Val());
                  var7.setBud01R3Qte(((Budget)var4.get(var8)).getBud01R3Qte());
                  var7.setBud01R3Val(((Budget)var4.get(var8)).getBud01R3Val());
                  var7.setBud01R4Qte(((Budget)var4.get(var8)).getBud01R4Qte());
                  var7.setBud01R4Val(((Budget)var4.get(var8)).getBud01R4Val());
                  var7.setBud02R1Qte(((Budget)var4.get(var8)).getBud02R1Qte());
                  var7.setBud02R1Val(((Budget)var4.get(var8)).getBud02R1Val());
                  var7.setBud02R2Qte(((Budget)var4.get(var8)).getBud02R2Qte());
                  var7.setBud02R2Val(((Budget)var4.get(var8)).getBud02R2Val());
                  var7.setBud02R3Qte(((Budget)var4.get(var8)).getBud02R3Qte());
                  var7.setBud02R3Val(((Budget)var4.get(var8)).getBud02R3Val());
                  var7.setBud02R4Qte(((Budget)var4.get(var8)).getBud02R4Qte());
                  var7.setBud02R4Val(((Budget)var4.get(var8)).getBud02R4Val());
                  var7.setBud03R1Qte(((Budget)var4.get(var8)).getBud03R1Qte());
                  var7.setBud03R1Val(((Budget)var4.get(var8)).getBud03R1Val());
                  var7.setBud03R2Qte(((Budget)var4.get(var8)).getBud03R2Qte());
                  var7.setBud03R2Val(((Budget)var4.get(var8)).getBud03R2Val());
                  var7.setBud03R3Qte(((Budget)var4.get(var8)).getBud03R3Qte());
                  var7.setBud03R3Val(((Budget)var4.get(var8)).getBud03R3Val());
                  var7.setBud03R4Qte(((Budget)var4.get(var8)).getBud03R4Qte());
                  var7.setBud03R4Val(((Budget)var4.get(var8)).getBud03R4Val());
                  var7.setBud04R1Qte(((Budget)var4.get(var8)).getBud04R1Qte());
                  var7.setBud04R1Val(((Budget)var4.get(var8)).getBud04R1Val());
                  var7.setBud04R2Qte(((Budget)var4.get(var8)).getBud04R2Qte());
                  var7.setBud04R2Val(((Budget)var4.get(var8)).getBud04R2Val());
                  var7.setBud04R3Qte(((Budget)var4.get(var8)).getBud04R3Qte());
                  var7.setBud04R3Val(((Budget)var4.get(var8)).getBud04R3Val());
                  var7.setBud04R4Qte(((Budget)var4.get(var8)).getBud04R4Qte());
                  var7.setBud04R4Val(((Budget)var4.get(var8)).getBud04R4Val());
                  var7.setBud05R1Qte(((Budget)var4.get(var8)).getBud05R1Qte());
                  var7.setBud05R1Val(((Budget)var4.get(var8)).getBud05R1Val());
                  var7.setBud05R2Qte(((Budget)var4.get(var8)).getBud05R2Qte());
                  var7.setBud05R2Val(((Budget)var4.get(var8)).getBud05R2Val());
                  var7.setBud05R3Qte(((Budget)var4.get(var8)).getBud05R3Qte());
                  var7.setBud05R3Val(((Budget)var4.get(var8)).getBud05R3Val());
                  var7.setBud05R4Qte(((Budget)var4.get(var8)).getBud05R4Qte());
                  var7.setBud05R4Val(((Budget)var4.get(var8)).getBud05R4Val());
                  var7.setBud06R1Qte(((Budget)var4.get(var8)).getBud06R1Qte());
                  var7.setBud06R1Val(((Budget)var4.get(var8)).getBud06R1Val());
                  var7.setBud06R2Qte(((Budget)var4.get(var8)).getBud06R2Qte());
                  var7.setBud06R2Val(((Budget)var4.get(var8)).getBud06R2Val());
                  var7.setBud06R3Qte(((Budget)var4.get(var8)).getBud06R3Qte());
                  var7.setBud06R3Val(((Budget)var4.get(var8)).getBud06R3Val());
                  var7.setBud06R4Qte(((Budget)var4.get(var8)).getBud06R4Qte());
                  var7.setBud06R4Val(((Budget)var4.get(var8)).getBud06R4Val());
                  var7.setBud07R1Qte(((Budget)var4.get(var8)).getBud07R1Qte());
                  var7.setBud07R1Val(((Budget)var4.get(var8)).getBud07R1Val());
                  var7.setBud07R2Qte(((Budget)var4.get(var8)).getBud07R2Qte());
                  var7.setBud07R2Val(((Budget)var4.get(var8)).getBud07R2Val());
                  var7.setBud07R3Qte(((Budget)var4.get(var8)).getBud07R3Qte());
                  var7.setBud07R3Val(((Budget)var4.get(var8)).getBud07R3Val());
                  var7.setBud07R4Qte(((Budget)var4.get(var8)).getBud07R4Qte());
                  var7.setBud07R4Val(((Budget)var4.get(var8)).getBud07R4Val());
                  var7.setBud08R1Qte(((Budget)var4.get(var8)).getBud08R1Qte());
                  var7.setBud08R1Val(((Budget)var4.get(var8)).getBud08R1Val());
                  var7.setBud08R2Qte(((Budget)var4.get(var8)).getBud08R2Qte());
                  var7.setBud08R2Val(((Budget)var4.get(var8)).getBud08R2Val());
                  var7.setBud08R3Qte(((Budget)var4.get(var8)).getBud08R3Qte());
                  var7.setBud08R3Val(((Budget)var4.get(var8)).getBud08R3Val());
                  var7.setBud08R4Qte(((Budget)var4.get(var8)).getBud08R4Qte());
                  var7.setBud08R4Val(((Budget)var4.get(var8)).getBud08R4Val());
                  var7.setBud09R1Qte(((Budget)var4.get(var8)).getBud09R1Qte());
                  var7.setBud09R1Val(((Budget)var4.get(var8)).getBud09R1Val());
                  var7.setBud09R2Qte(((Budget)var4.get(var8)).getBud09R2Qte());
                  var7.setBud09R2Val(((Budget)var4.get(var8)).getBud09R2Val());
                  var7.setBud09R3Qte(((Budget)var4.get(var8)).getBud09R3Qte());
                  var7.setBud09R3Val(((Budget)var4.get(var8)).getBud09R3Val());
                  var7.setBud09R4Qte(((Budget)var4.get(var8)).getBud09R4Qte());
                  var7.setBud09R4Val(((Budget)var4.get(var8)).getBud09R4Val());
                  var7.setBud10R1Qte(((Budget)var4.get(var8)).getBud10R1Qte());
                  var7.setBud10R1Val(((Budget)var4.get(var8)).getBud10R1Val());
                  var7.setBud10R2Qte(((Budget)var4.get(var8)).getBud10R2Qte());
                  var7.setBud10R2Val(((Budget)var4.get(var8)).getBud10R2Val());
                  var7.setBud10R3Qte(((Budget)var4.get(var8)).getBud10R3Qte());
                  var7.setBud10R3Val(((Budget)var4.get(var8)).getBud10R3Val());
                  var7.setBud10R4Qte(((Budget)var4.get(var8)).getBud10R4Qte());
                  var7.setBud10R4Val(((Budget)var4.get(var8)).getBud10R4Val());
                  var7.setBud11R1Qte(((Budget)var4.get(var8)).getBud11R1Qte());
                  var7.setBud11R1Val(((Budget)var4.get(var8)).getBud11R1Val());
                  var7.setBud11R2Qte(((Budget)var4.get(var8)).getBud11R2Qte());
                  var7.setBud11R2Val(((Budget)var4.get(var8)).getBud11R2Val());
                  var7.setBud11R3Qte(((Budget)var4.get(var8)).getBud11R3Qte());
                  var7.setBud11R3Val(((Budget)var4.get(var8)).getBud11R3Val());
                  var7.setBud11R4Qte(((Budget)var4.get(var8)).getBud11R4Qte());
                  var7.setBud11R4Val(((Budget)var4.get(var8)).getBud11R4Val());
                  var7.setBud12R1Qte(((Budget)var4.get(var8)).getBud12R1Qte());
                  var7.setBud12R1Val(((Budget)var4.get(var8)).getBud12R1Val());
                  var7.setBud12R2Qte(((Budget)var4.get(var8)).getBud12R2Qte());
                  var7.setBud12R2Val(((Budget)var4.get(var8)).getBud12R2Val());
                  var7.setBud12R3Qte(((Budget)var4.get(var8)).getBud12R3Qte());
                  var7.setBud12R3Val(((Budget)var4.get(var8)).getBud12R3Val());
                  var7.setBud12R4Qte(((Budget)var4.get(var8)).getBud12R4Qte());
                  var7.setBud12R4Val(((Budget)var4.get(var8)).getBud12R4Val());
                  var7.setBud01TotQte(((Budget)var4.get(var8)).getBud01TotQte());
                  var7.setBud01TotVal(((Budget)var4.get(var8)).getBud01TotVal());
                  var7.setBud02TotQte(((Budget)var4.get(var8)).getBud02TotQte());
                  var7.setBud02TotVal(((Budget)var4.get(var8)).getBud02TotVal());
                  var7.setBud03TotQte(((Budget)var4.get(var8)).getBud03TotQte());
                  var7.setBud03TotVal(((Budget)var4.get(var8)).getBud03TotVal());
                  var7.setBud04TotQte(((Budget)var4.get(var8)).getBud04TotQte());
                  var7.setBud04TotVal(((Budget)var4.get(var8)).getBud04TotVal());
                  var7.setBudAnnee(((Budget)var4.get(var8)).getBudAnnee());
                  var7.setBudAxe01(((Budget)var4.get(var8)).isBudAxe01());
                  var7.setBudAxe02(((Budget)var4.get(var8)).isBudAxe02());
                  var7.setBudAxe03(((Budget)var4.get(var8)).isBudAxe03());
                  var7.setBudAxe04(((Budget)var4.get(var8)).isBudAxe04());
                  var7.setBudAxe05(((Budget)var4.get(var8)).isBudAxe05());
                  var7.setBudAxe06(((Budget)var4.get(var8)).isBudAxe06());
                  var7.setBudAxe07(((Budget)var4.get(var8)).isBudAxe07());
                  var7.setBudAxe08(((Budget)var4.get(var8)).isBudAxe08());
                  var7.setBudAxe09(((Budget)var4.get(var8)).isBudAxe09());
                  var7.setBudAxe10(((Budget)var4.get(var8)).isBudAxe10());
                  var7.setBudAxe11(((Budget)var4.get(var8)).isBudAxe11());
                  var7.setBudAxe12(((Budget)var4.get(var8)).isBudAxe12());
                  var7.setBudAxe13(((Budget)var4.get(var8)).isBudAxe13());
                  if (((Budget)var4.get(var8)).getBudCode().contains("-")) {
                     String[] var9 = ((Budget)var4.get(var8)).getBudCode().split("-");
                     var7.setBudCode(var9[0] + "-" + var15);
                  } else {
                     var7.setBudCode(((Budget)var4.get(var8)).getBudCode() + "-" + var15);
                  }

                  var7.setBudEntite(var15);
                  var7.setBudDateCreat(new Date());
                  var7.setBudDateModif((Date)null);
                  var7.setBudIdOld(((Budget)var4.get(var8)).getBud_id());
                  var7.setBudLibelleFr(((Budget)var4.get(var8)).getBudLibelleFr().replace(var1, var15));
                  var7.setBudLibelleSp(((Budget)var4.get(var8)).getBudLibelleSp());
                  var7.setBudLibelleUk(((Budget)var4.get(var8)).getBudLibelleUk());
                  var7.setBudNature(((Budget)var4.get(var8)).getBudNature());
                  var7.setBudProjet(((Budget)var4.get(var8)).getBudProjet());
                  var7.setBudSens(((Budget)var4.get(var8)).getBudSens());
                  var7.setBudType(((Budget)var4.get(var8)).getBudType());
                  var7.setBudUserCreat(this.usersLog.getUsrid());
                  var7.setBudUserModif(0L);
                  var7.setBudUtil(((Budget)var4.get(var8)).getBudUtil());
                  var7.setExercicescomptable(((Budget)var4.get(var8)).getExercicescomptable());
                  this.budgetDao.insert(var7, var16);
                  ++var8;
               }
            } catch (HibernateException var13) {
               if (var6 != null) {
                  var6.rollback();
               }

               throw var13;
            } finally {
               this.utilInitHibernate.closeSession();
            }

            this.recherche();
         }
      }

   }

   public void supprimerEntiteBudget() throws HibernateException, NamingException {
      if (this.budget != null && this.budget.getBudType() == 15) {
         String var1 = this.budget.getBudEntite();
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "Budget");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            if (this.lesBudgets.size() != 0) {
               for(int var4 = 0; var4 < this.lesBudgets.size(); ++var4) {
                  this.budget = (Budget)this.lesBudgets.get(var4);
                  if (this.budget.getBudEntite() != null && !this.budget.getBudEntite().isEmpty() && this.budget.getBudEntite().equals(var1)) {
                     this.budgetDao.delete(this.budget, var2);
                  }
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

         this.recherche();
      }

   }

   public void modifierEntiteBudget() {
      if (this.budget != null && this.budget.getBudType() == 15) {
         this.showModalPanelEntite = true;
      }

   }

   public void annulerEntite() {
      this.showModalPanelEntite = false;
   }

   public void validerEntite() throws HibernateException, NamingException {
      if (this.budget != null) {
         this.budget = this.budgetDao.modif(this.budget);
      }

      this.showModalPanelEntite = false;
   }

   public void selectionBudgetLigne() {
      if (this.dataModelLesBudgetsLigne.isRowAvailable()) {
         this.budgetLigne = (BudgetLigne)this.dataModelLesBudgetsLigne.getRowData();
      }

   }

   public void selectionMontant() {
      this.selectionModeSaisie = 1;
   }

   public void selectionQuantite() {
      this.selectionModeSaisie = 2;
   }

   public void calculeRepartitionMontant() {
      if (this.montantTotal != 0.0D) {
         double var1 = this.montantTotal / 12.0D;
         UtilNombre var3 = new UtilNombre();
         var1 = var3.myRoundDevise(var1, this.structureLog.getStrdevise());
         this.montantMax = var1 * 2.0D;
         this.val01 = var1;
         this.val02 = var1;
         this.val03 = var1;
         this.val04 = var1;
         this.val05 = var1;
         this.val06 = var1;
         this.val07 = var1;
         this.val08 = var1;
         this.val09 = var1;
         this.val10 = var1;
         this.val11 = var1;
         double var4 = this.montantTotal - (this.val01 + this.val02 + this.val03 + this.val04 + this.val05 + this.val06 + this.val07 + this.val08 + this.val09 + this.val10 + this.val11);
         this.val12 = var4;
      } else {
         this.montantMax = 0.0D;
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

      this.formAnalytique.setMontantAImputer(this.montantTotal);
      this.formAnalytique.calculEcart();
   }

   public void calculeCumulMontant() {
      this.montantTotal = this.val01 + this.val02 + this.val03 + this.val04 + this.val05 + this.val06 + this.val07 + this.val08 + this.val09 + this.val10 + this.val11 + this.val12;
   }

   public void calculeRepartitionQte() {
      if (this.qteTotal != 0.0F) {
         float var1 = this.qteTotal / 12.0F;
         this.qteMax = var1 * 2.0F;
         this.budgetLigne.setLigqte01(var1);
         this.budgetLigne.setLigval02((double)var1);
         this.budgetLigne.setLigval03((double)var1);
         this.budgetLigne.setLigval04((double)var1);
         this.budgetLigne.setLigval05((double)var1);
         this.budgetLigne.setLigval06((double)var1);
         this.budgetLigne.setLigval07((double)var1);
         this.budgetLigne.setLigval08((double)var1);
         this.budgetLigne.setLigval09((double)var1);
         this.budgetLigne.setLigval10((double)var1);
         this.budgetLigne.setLigval11((double)var1);
         float var2 = this.qteTotal - (this.budgetLigne.getLigqte01() + this.budgetLigne.getLigqte02() + this.budgetLigne.getLigqte03() + this.budgetLigne.getLigqte04() + this.budgetLigne.getLigqte05() + this.budgetLigne.getLigqte06() + this.budgetLigne.getLigqte07() + this.budgetLigne.getLigqte08() + this.budgetLigne.getLigqte09() + this.budgetLigne.getLigqte10() + this.budgetLigne.getLigqte11());
         this.budgetLigne.setLigval12((double)var2);
      } else {
         this.budgetLigne.setLigqte01(0.0F);
         this.budgetLigne.setLigval02(0.0D);
         this.budgetLigne.setLigval03(0.0D);
         this.budgetLigne.setLigval04(0.0D);
         this.budgetLigne.setLigval05(0.0D);
         this.budgetLigne.setLigval06(0.0D);
         this.budgetLigne.setLigval07(0.0D);
         this.budgetLigne.setLigval08(0.0D);
         this.budgetLigne.setLigval09(0.0D);
         this.budgetLigne.setLigval10(0.0D);
         this.budgetLigne.setLigval11(0.0D);
         this.budgetLigne.setLigval12(0.0D);
      }

      this.formAnalytique.setQteAImputer(this.qteTotal);
      this.formAnalytique.calculEcart();
   }

   public void calculeCumulQte() {
      this.qteTotal = this.budgetLigne.getLigqte01() + this.budgetLigne.getLigqte02() + this.budgetLigne.getLigqte03() + this.budgetLigne.getLigqte04() + this.budgetLigne.getLigqte05() + this.budgetLigne.getLigqte06() + this.budgetLigne.getLigqte07() + this.budgetLigne.getLigqte08() + this.budgetLigne.getLigqte09() + this.budgetLigne.getLigqte10() + this.budgetLigne.getLigqte11() + this.budgetLigne.getLigqte12();
   }

   public void validerBudget() throws HibernateException, NamingException {
      if (this.var_choix_reamenagement.equalsIgnoreCase("0")) {
         this.budget.setBud01TotVal(this.montantTotal);
         this.budget.setBud01TotQte(this.qteTotal);
         this.budget.setBud01R1Val(this.val01);
         this.budget.setBud02R1Val(this.val02);
         this.budget.setBud03R1Val(this.val03);
         this.budget.setBud04R1Val(this.val04);
         this.budget.setBud05R1Val(this.val05);
         this.budget.setBud06R1Val(this.val06);
         this.budget.setBud07R1Val(this.val07);
         this.budget.setBud08R1Val(this.val08);
         this.budget.setBud09R1Val(this.val09);
         this.budget.setBud10R1Val(this.val10);
         this.budget.setBud11R1Val(this.val11);
         this.budget.setBud12R1Val(this.val12);
         this.budget.setBud01R1Qte(this.qte01);
         this.budget.setBud02R1Qte(this.qte02);
         this.budget.setBud03R1Qte(this.qte03);
         this.budget.setBud04R1Qte(this.qte04);
         this.budget.setBud05R1Qte(this.qte05);
         this.budget.setBud06R1Qte(this.qte06);
         this.budget.setBud07R1Qte(this.qte07);
         this.budget.setBud08R1Qte(this.qte08);
         this.budget.setBud09R1Qte(this.qte09);
         this.budget.setBud10R1Qte(this.qte10);
         this.budget.setBud11R1Qte(this.qte11);
         this.budget.setBud12R1Qte(this.qte12);
      } else if (this.var_choix_reamenagement.equalsIgnoreCase("1")) {
         this.budget.setBud02TotVal(this.montantTotal);
         this.budget.setBud02TotQte(this.qteTotal);
         this.budget.setBud01R2Val(this.val01);
         this.budget.setBud02R2Val(this.val02);
         this.budget.setBud03R2Val(this.val03);
         this.budget.setBud04R2Val(this.val04);
         this.budget.setBud05R2Val(this.val05);
         this.budget.setBud06R2Val(this.val06);
         this.budget.setBud07R2Val(this.val07);
         this.budget.setBud08R2Val(this.val08);
         this.budget.setBud09R2Val(this.val09);
         this.budget.setBud10R2Val(this.val10);
         this.budget.setBud11R2Val(this.val11);
         this.budget.setBud12R2Val(this.val12);
         this.budget.setBud01R2Qte(this.qte01);
         this.budget.setBud02R2Qte(this.qte02);
         this.budget.setBud03R2Qte(this.qte03);
         this.budget.setBud04R2Qte(this.qte04);
         this.budget.setBud05R2Qte(this.qte05);
         this.budget.setBud06R2Qte(this.qte06);
         this.budget.setBud07R2Qte(this.qte07);
         this.budget.setBud08R2Qte(this.qte08);
         this.budget.setBud09R2Qte(this.qte09);
         this.budget.setBud10R2Qte(this.qte10);
         this.budget.setBud11R2Qte(this.qte11);
         this.budget.setBud12R2Qte(this.qte12);
      } else if (this.var_choix_reamenagement.equalsIgnoreCase("2")) {
         this.budget.setBud03TotVal(this.montantTotal);
         this.budget.setBud03TotQte(this.qteTotal);
         this.budget.setBud01R3Val(this.val01);
         this.budget.setBud02R3Val(this.val02);
         this.budget.setBud03R3Val(this.val03);
         this.budget.setBud04R3Val(this.val04);
         this.budget.setBud05R3Val(this.val05);
         this.budget.setBud06R3Val(this.val06);
         this.budget.setBud07R3Val(this.val07);
         this.budget.setBud08R3Val(this.val08);
         this.budget.setBud09R3Val(this.val09);
         this.budget.setBud10R3Val(this.val10);
         this.budget.setBud11R3Val(this.val11);
         this.budget.setBud12R3Val(this.val12);
         this.budget.setBud01R3Qte(this.qte01);
         this.budget.setBud02R3Qte(this.qte02);
         this.budget.setBud03R3Qte(this.qte03);
         this.budget.setBud04R3Qte(this.qte04);
         this.budget.setBud05R3Qte(this.qte05);
         this.budget.setBud06R3Qte(this.qte06);
         this.budget.setBud07R3Qte(this.qte07);
         this.budget.setBud08R3Qte(this.qte08);
         this.budget.setBud09R3Qte(this.qte09);
         this.budget.setBud10R3Qte(this.qte10);
         this.budget.setBud11R3Qte(this.qte11);
         this.budget.setBud12R3Qte(this.qte12);
      } else if (this.var_choix_reamenagement.equalsIgnoreCase("3")) {
         this.budget.setBud04TotVal(this.montantTotal);
         this.budget.setBud04TotQte(this.qteTotal);
         this.budget.setBud01R4Val(this.val01);
         this.budget.setBud02R4Val(this.val02);
         this.budget.setBud03R4Val(this.val03);
         this.budget.setBud04R4Val(this.val04);
         this.budget.setBud05R4Val(this.val05);
         this.budget.setBud06R4Val(this.val06);
         this.budget.setBud07R4Val(this.val07);
         this.budget.setBud08R4Val(this.val08);
         this.budget.setBud09R4Val(this.val09);
         this.budget.setBud10R4Val(this.val10);
         this.budget.setBud11R4Val(this.val11);
         this.budget.setBud12R4Val(this.val12);
         this.budget.setBud01R4Qte(this.qte01);
         this.budget.setBud02R4Qte(this.qte02);
         this.budget.setBud03R4Qte(this.qte03);
         this.budget.setBud04R4Qte(this.qte04);
         this.budget.setBud05R4Qte(this.qte05);
         this.budget.setBud06R4Qte(this.qte06);
         this.budget.setBud07R4Qte(this.qte07);
         this.budget.setBud08R4Qte(this.qte08);
         this.budget.setBud09R4Qte(this.qte09);
         this.budget.setBud10R4Qte(this.qte10);
         this.budget.setBud11R4Qte(this.qte11);
         this.budget.setBud12R4Qte(this.qte12);
      }

      this.budget.setExercicescomptable(this.selectedExo);
      this.budget.setBudUtil(Integer.parseInt(this.var_choix_reamenagement));
      if (this.budget.getBud_id() == 0L) {
         this.budget.setBudDateCreat(new Date());
         this.budget.setBudUserCreat(this.usersLog.getUsrid());
         this.budget = this.budgetDao.insert(this.budget);
      } else {
         this.budget.setBudDateModif(new Date());
         this.budget.setBudUserModif(this.usersLog.getUsrid());
         this.budget = this.budgetDao.modif(this.budget);
      }

      if (this.recopieValeurposte) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Budget");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new ArrayList();
            String var4 = "";
            if (this.budget.getBudCode().contains("-")) {
               String[] var5 = this.budget.getBudCode().split("-");
               var4 = var5[0];
            } else {
               var4 = this.budget.getBudCode();
            }

            List var3 = this.budgetDao.chargerLesBudgets(var4, var1);
            new Budget();

            for(int var6 = 0; var6 < var3.size(); ++var6) {
               Budget var12 = (Budget)var3.get(var6);
               var12.setBud01R1Qte(this.budget.getBud01R1Qte());
               var12.setBud01R1Val(this.budget.getBud01R1Val());
               var12.setBud01R2Qte(this.budget.getBud01R2Qte());
               var12.setBud01R2Val(this.budget.getBud01R2Val());
               var12.setBud01R3Qte(this.budget.getBud01R3Qte());
               var12.setBud01R3Val(this.budget.getBud01R3Val());
               var12.setBud01R4Qte(this.budget.getBud01R4Qte());
               var12.setBud01R4Val(this.budget.getBud01R4Val());
               var12.setBud02R1Qte(this.budget.getBud02R1Qte());
               var12.setBud02R1Val(this.budget.getBud02R1Val());
               var12.setBud02R2Qte(this.budget.getBud02R2Qte());
               var12.setBud02R2Val(this.budget.getBud02R2Val());
               var12.setBud02R3Qte(this.budget.getBud02R3Qte());
               var12.setBud02R3Val(this.budget.getBud02R3Val());
               var12.setBud02R4Qte(this.budget.getBud02R4Qte());
               var12.setBud02R4Val(this.budget.getBud02R4Val());
               var12.setBud03R1Qte(this.budget.getBud03R1Qte());
               var12.setBud03R1Val(this.budget.getBud03R1Val());
               var12.setBud03R2Qte(this.budget.getBud03R2Qte());
               var12.setBud03R2Val(this.budget.getBud03R2Val());
               var12.setBud03R3Qte(this.budget.getBud03R3Qte());
               var12.setBud03R3Val(this.budget.getBud03R3Val());
               var12.setBud03R4Qte(this.budget.getBud03R4Qte());
               var12.setBud03R4Val(this.budget.getBud03R4Val());
               var12.setBud04R1Qte(this.budget.getBud04R1Qte());
               var12.setBud04R1Val(this.budget.getBud04R1Val());
               var12.setBud04R2Qte(this.budget.getBud04R2Qte());
               var12.setBud04R2Val(this.budget.getBud04R2Val());
               var12.setBud04R3Qte(this.budget.getBud04R3Qte());
               var12.setBud04R3Val(this.budget.getBud04R3Val());
               var12.setBud04R4Qte(this.budget.getBud04R4Qte());
               var12.setBud04R4Val(this.budget.getBud04R4Val());
               var12.setBud05R1Qte(this.budget.getBud05R1Qte());
               var12.setBud05R1Val(this.budget.getBud05R1Val());
               var12.setBud05R2Qte(this.budget.getBud05R2Qte());
               var12.setBud05R2Val(this.budget.getBud05R2Val());
               var12.setBud05R3Qte(this.budget.getBud05R3Qte());
               var12.setBud05R3Val(this.budget.getBud05R3Val());
               var12.setBud05R4Qte(this.budget.getBud05R4Qte());
               var12.setBud05R4Val(this.budget.getBud05R4Val());
               var12.setBud06R1Qte(this.budget.getBud06R1Qte());
               var12.setBud06R1Val(this.budget.getBud06R1Val());
               var12.setBud06R2Qte(this.budget.getBud06R2Qte());
               var12.setBud06R2Val(this.budget.getBud06R2Val());
               var12.setBud06R3Qte(this.budget.getBud06R3Qte());
               var12.setBud06R3Val(this.budget.getBud06R3Val());
               var12.setBud06R4Qte(this.budget.getBud06R4Qte());
               var12.setBud06R4Val(this.budget.getBud06R4Val());
               var12.setBud07R1Qte(this.budget.getBud07R1Qte());
               var12.setBud07R1Val(this.budget.getBud07R1Val());
               var12.setBud07R2Qte(this.budget.getBud07R2Qte());
               var12.setBud07R2Val(this.budget.getBud07R2Val());
               var12.setBud07R3Qte(this.budget.getBud07R3Qte());
               var12.setBud07R3Val(this.budget.getBud07R3Val());
               var12.setBud07R4Qte(this.budget.getBud07R4Qte());
               var12.setBud07R4Val(this.budget.getBud07R4Val());
               var12.setBud08R1Qte(this.budget.getBud08R1Qte());
               var12.setBud08R1Val(this.budget.getBud08R1Val());
               var12.setBud08R2Qte(this.budget.getBud08R2Qte());
               var12.setBud08R2Val(this.budget.getBud08R2Val());
               var12.setBud08R3Qte(this.budget.getBud08R3Qte());
               var12.setBud08R3Val(this.budget.getBud08R3Val());
               var12.setBud08R4Qte(this.budget.getBud08R4Qte());
               var12.setBud08R4Val(this.budget.getBud08R4Val());
               var12.setBud09R1Qte(this.budget.getBud09R1Qte());
               var12.setBud09R1Val(this.budget.getBud09R1Val());
               var12.setBud09R2Qte(this.budget.getBud09R2Qte());
               var12.setBud09R2Val(this.budget.getBud09R2Val());
               var12.setBud09R3Qte(this.budget.getBud09R3Qte());
               var12.setBud09R3Val(this.budget.getBud09R3Val());
               var12.setBud09R4Qte(this.budget.getBud09R4Qte());
               var12.setBud09R4Val(this.budget.getBud09R4Val());
               var12.setBud10R1Qte(this.budget.getBud10R1Qte());
               var12.setBud10R1Val(this.budget.getBud10R1Val());
               var12.setBud10R2Qte(this.budget.getBud10R2Qte());
               var12.setBud10R2Val(this.budget.getBud10R2Val());
               var12.setBud10R3Qte(this.budget.getBud10R3Qte());
               var12.setBud10R3Val(this.budget.getBud10R3Val());
               var12.setBud10R4Qte(this.budget.getBud10R4Qte());
               var12.setBud10R4Val(this.budget.getBud10R4Val());
               var12.setBud11R1Qte(this.budget.getBud11R1Qte());
               var12.setBud11R1Val(this.budget.getBud11R1Val());
               var12.setBud11R2Qte(this.budget.getBud11R2Qte());
               var12.setBud11R2Val(this.budget.getBud11R2Val());
               var12.setBud11R3Qte(this.budget.getBud11R3Qte());
               var12.setBud11R3Val(this.budget.getBud11R3Val());
               var12.setBud11R4Qte(this.budget.getBud11R4Qte());
               var12.setBud11R4Val(this.budget.getBud11R4Val());
               var12.setBud12R1Qte(this.budget.getBud12R1Qte());
               var12.setBud12R1Val(this.budget.getBud12R1Val());
               var12.setBud12R2Qte(this.budget.getBud12R2Qte());
               var12.setBud12R2Val(this.budget.getBud12R2Val());
               var12.setBud12R3Qte(this.budget.getBud12R3Qte());
               var12.setBud12R3Val(this.budget.getBud12R3Val());
               var12.setBud12R4Qte(this.budget.getBud12R4Qte());
               var12.setBud12R4Val(this.budget.getBud12R4Val());
               var12.setBud01TotQte(this.budget.getBud01TotQte());
               var12.setBud01TotVal(this.budget.getBud01TotVal());
               var12.setBud02TotQte(this.budget.getBud02TotQte());
               var12.setBud02TotVal(this.budget.getBud02TotVal());
               var12.setBud03TotQte(this.budget.getBud03TotQte());
               var12.setBud03TotVal(this.budget.getBud03TotVal());
               var12.setBud04TotQte(this.budget.getBud04TotQte());
               var12.setBud04TotVal(this.budget.getBud04TotVal());
               this.budgetDao.modif(var12, var1);
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

      this.formAnalytique.saveDetailAnalytique(this.budget.getBud_id(), this.budgetDao);
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
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "budget";
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
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "budget" + File.separator);
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

         if (this.var_nature.equalsIgnoreCase("1")) {
            var1.setFiltre("Plans budgétaires : Vente - Année " + this.var_annee + " - " + var11);
         } else if (this.var_nature.equalsIgnoreCase("2")) {
            var1.setFiltre("Plans budgétaires : Achats - Année " + this.var_annee + " - " + var11);
         } else if (this.var_nature.equalsIgnoreCase("3")) {
            var1.setFiltre("Plans budgétaires : Production - Année " + this.var_annee + " - " + var11);
         } else if (this.var_nature.equalsIgnoreCase("4")) {
            var1.setFiltre("Plans budgétaires : Frais généraux - Année " + this.var_annee + " - " + var11);
         } else if (this.var_nature.equalsIgnoreCase("5")) {
            var1.setFiltre("Plans budgétaires : Investissements - Année " + this.var_annee + " - " + var11);
         } else if (this.var_nature.equalsIgnoreCase("6")) {
            var1.setFiltre("Plans budgétaires : T.V.A. - Année " + this.var_annee + " - " + var11);
         } else if (this.var_nature.equalsIgnoreCase("7")) {
            var1.setFiltre("Plans budgétaires : Impôts et taxes - Année " + this.var_annee + " - " + var11);
         } else if (this.var_nature.equalsIgnoreCase("8")) {
            var1.setFiltre("Plans budgétaires : Personnels - Année " + this.var_annee + " - " + var11);
         } else if (this.var_nature.equalsIgnoreCase("9")) {
            var1.setFiltre("Plans budgétaires : Prodtuis achats - Année " + this.var_annee + " - " + var11);
         } else {
            var1.setFiltre("Plans budgétaires :" + this.budget.getBudProjet() + " - Année " + this.var_annee + " - " + var11);
         }

         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataire(var8);
         var1.setDestinataire(var9);
         var1.setCorpsMail(var10);
         var1.setTiersSelectionne((Tiers)null);
         JRBeanCollectionDataSource var12 = null;
         int var15;
         if (!var4.contains("SansDetail")) {
            Object var20 = new ArrayList();
            if (this.lesBudgets.size() != 0) {
               String var21 = "";

               for(var15 = 0; var15 < this.lesBudgets.size(); ++var15) {
                  if (var21 != null && !var21.isEmpty()) {
                     var21 = var21 + "," + ((Budget)this.lesBudgets.get(var15)).getBud_id();
                  } else {
                     var21 = "" + ((Budget)this.lesBudgets.get(var15)).getBud_id();
                  }
               }

               var20 = this.budgetLigneDao.chargerLigneBudgetByIdBudget(var21, (Session)null);
            }

            var12 = new JRBeanCollectionDataSource((Collection)var20);
         } else {
            ArrayList var13 = new ArrayList();
            if (this.lesBudgets.size() != 0) {
               new Budget();

               Budget var14;
               for(var15 = 0; var15 < this.lesBudgets.size(); ++var15) {
                  var14 = (Budget)this.lesBudgets.get(var15);
                  var13.add(var14);
               }

               for(var15 = 0; var15 < var13.size(); ++var15) {
                  var14 = (Budget)var13.get(var15);
                  double var16;
                  float var18;
                  int var19;
                  if (var14.getBudType() == 20) {
                     var16 = 0.0D;
                     var18 = 0.0F;

                     for(var19 = var15 + 1; var19 < var13.size(); ++var19) {
                        if (((Budget)var13.get(var19)).getBudType() == 1) {
                           var16 += ((Budget)var13.get(var19)).getBud01TotVal();
                           var18 += ((Budget)var13.get(var19)).getBud01TotQte();
                        }

                        if (((Budget)var13.get(var19)).getBudType() == 20) {
                           break;
                        }
                     }

                     var14.setBud01TotVal(var16);
                     var14.setBud01TotQte(var18);
                  } else if (var14.getBudType() == 21) {
                     var16 = 0.0D;
                     var18 = 0.0F;

                     for(var19 = var15 + 1; var19 < var13.size(); ++var19) {
                        if (((Budget)var13.get(var19)).getBudType() == 1) {
                           var16 += ((Budget)var13.get(var19)).getBud01TotVal();
                           var18 += ((Budget)var13.get(var19)).getBud01TotQte();
                        }

                        if (((Budget)var13.get(var19)).getBudType() == 21 || ((Budget)var13.get(var19)).getBudType() == 20) {
                           break;
                        }
                     }

                     var14.setBud01TotVal(var16);
                     var14.setBud01TotQte(var18);
                  } else if (var14.getBudType() == 22) {
                     var16 = 0.0D;
                     var18 = 0.0F;

                     for(var19 = var15 + 1; var19 < var13.size(); ++var19) {
                        if (((Budget)var13.get(var19)).getBudType() == 1) {
                           var16 += ((Budget)var13.get(var19)).getBud01TotVal();
                           var18 += ((Budget)var13.get(var19)).getBud01TotQte();
                        }

                        if (((Budget)var13.get(var19)).getBudType() == 22 || ((Budget)var13.get(var19)).getBudType() == 21 || ((Budget)var13.get(var19)).getBudType() == 20) {
                           break;
                        }
                     }

                     var14.setBud01TotVal(var16);
                     var14.setBud01TotQte(var18);
                  }
               }
            }

            var12 = new JRBeanCollectionDataSource(var13);
         }

         var1.setjRBeanCollectionDataSource(var12);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

   }

   public Budget getBudget() {
      return this.budget;
   }

   public void setBudget(Budget var1) {
      this.budget = var1;
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

   public String getVar_nature() {
      return this.var_nature;
   }

   public void setVar_nature(String var1) {
      this.var_nature = var1;
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

   public boolean isTestagent() {
      return this.testagent;
   }

   public void setTestagent(boolean var1) {
      this.testagent = var1;
   }

   public double getMontantTotal() {
      return this.montantTotal;
   }

   public void setMontantTotal(double var1) {
      this.montantTotal = var1;
   }

   public double getMontantMax() {
      return this.montantMax;
   }

   public void setMontantMax(double var1) {
      this.montantMax = var1;
   }

   public boolean isShowButtonRec() {
      return this.showButtonRec;
   }

   public void setShowButtonRec(boolean var1) {
      this.showButtonRec = var1;
   }

   public float getQte01() {
      return this.qte01;
   }

   public void setQte01(float var1) {
      this.qte01 = var1;
   }

   public float getQte02() {
      return this.qte02;
   }

   public void setQte02(float var1) {
      this.qte02 = var1;
   }

   public float getQte03() {
      return this.qte03;
   }

   public void setQte03(float var1) {
      this.qte03 = var1;
   }

   public float getQte04() {
      return this.qte04;
   }

   public void setQte04(float var1) {
      this.qte04 = var1;
   }

   public float getQte05() {
      return this.qte05;
   }

   public void setQte05(float var1) {
      this.qte05 = var1;
   }

   public float getQte06() {
      return this.qte06;
   }

   public void setQte06(float var1) {
      this.qte06 = var1;
   }

   public float getQte07() {
      return this.qte07;
   }

   public void setQte07(float var1) {
      this.qte07 = var1;
   }

   public float getQte08() {
      return this.qte08;
   }

   public void setQte08(float var1) {
      this.qte08 = var1;
   }

   public float getQte09() {
      return this.qte09;
   }

   public void setQte09(float var1) {
      this.qte09 = var1;
   }

   public float getQte10() {
      return this.qte10;
   }

   public void setQte10(float var1) {
      this.qte10 = var1;
   }

   public float getQte11() {
      return this.qte11;
   }

   public void setQte11(float var1) {
      this.qte11 = var1;
   }

   public float getQte12() {
      return this.qte12;
   }

   public void setQte12(float var1) {
      this.qte12 = var1;
   }

   public float getQteMax() {
      return this.qteMax;
   }

   public void setQteMax(float var1) {
      this.qteMax = var1;
   }

   public float getQteTotal() {
      return this.qteTotal;
   }

   public void setQteTotal(float var1) {
      this.qteTotal = var1;
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

   public List getLesBudgets() {
      return this.lesBudgets;
   }

   public void setLesBudgets(List var1) {
      this.lesBudgets = var1;
   }

   public BudgetLigne getBudgetLigne() {
      return this.budgetLigne;
   }

   public void setBudgetLigne(BudgetLigne var1) {
      this.budgetLigne = var1;
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

   public boolean isDecoupageActivite() {
      return this.decoupageActivite;
   }

   public void setDecoupageActivite(boolean var1) {
      this.decoupageActivite = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public List getMesTypesItems() {
      return this.mesTypesItems;
   }

   public void setMesTypesItems(List var1) {
      this.mesTypesItems = var1;
   }

   public FormAnalytique getFormAnalytique() {
      return this.formAnalytique;
   }

   public void setFormAnalytique(FormAnalytique var1) {
      this.formAnalytique = var1;
   }

   public boolean isShowModalPanelDetail() {
      return this.showModalPanelDetail;
   }

   public void setShowModalPanelDetail(boolean var1) {
      this.showModalPanelDetail = var1;
   }

   public List getMesEntitesItems() {
      return this.mesEntitesItems;
   }

   public void setMesEntitesItems(List var1) {
      this.mesEntitesItems = var1;
   }

   public String getVar_choix_entite() {
      return this.var_choix_entite;
   }

   public void setVar_choix_entite(String var1) {
      this.var_choix_entite = var1;
   }

   public boolean isAfficheEntite() {
      return this.afficheEntite;
   }

   public void setAfficheEntite(boolean var1) {
      this.afficheEntite = var1;
   }

   public List getLesModelesAutorises() {
      return this.lesModelesAutorises;
   }

   public void setLesModelesAutorises(List var1) {
      this.lesModelesAutorises = var1;
   }

   public boolean isShowModalPanelEntite() {
      return this.showModalPanelEntite;
   }

   public void setShowModalPanelEntite(boolean var1) {
      this.showModalPanelEntite = var1;
   }

   public boolean isRecopieValeurposte() {
      return this.recopieValeurposte;
   }

   public void setRecopieValeurposte(boolean var1) {
      this.recopieValeurposte = var1;
   }
}
