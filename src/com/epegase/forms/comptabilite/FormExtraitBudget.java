package com.epegase.forms.comptabilite;

import com.epegase.systeme.classe.Budget;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresAnalytique;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.PlanBudgetaireCompte;
import com.epegase.systeme.classe.PlansBudgetaires;
import com.epegase.systeme.classe.Projets;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.BudgetDao;
import com.epegase.systeme.dao.BudgetLigneDao;
import com.epegase.systeme.dao.EcrituresAnalytiquesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.PlanBudgetaireCompteDao;
import com.epegase.systeme.dao.PlansBudgetairesDao;
import com.epegase.systeme.dao.ProjetsDao;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class FormExtraitBudget implements Serializable {
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
   private ProjetsDao projetsDao;
   private Projets projets;
   private Budget budget = new Budget();
   private BudgetDao budgetDao;
   private List lesBudgets = new ArrayList();
   private transient DataModel dataModelLesBudgets = new ListDataModel();
   private BudgetLigneDao budgetLigneDao;
   private List lesBudgetsLigne = new ArrayList();
   private List lesexercicesItem = new ArrayList();
   private String var_choix_reamenagement = "0";
   private PlansBudgetairesDao plansBudgetairesDao;
   private PlanBudgetaireCompteDao planBudgetaireCompteDao;
   private boolean testactivite = false;
   private boolean testagent = false;
   private boolean showModalPanelBudget = false;
   private boolean var_affiche_bouton = false;
   private String inputProjet = "";
   private boolean showModalPanelDetailPiece = false;
   private transient DataModel dataModelLesBudgetsLigne = new ListDataModel();
   private double var_tot_debit;
   private double var_tot_credit;
   private double var_solde;
   private Ecritures ecritures;
   private EcrituresDao ecrituresDao;
   private EcrituresAnalytique ecrituresAnalytique;
   private EcrituresAnalytiquesDao ecrituresAnalytiquesDao;
   private String var_annee;
   private List mesAnneeItems;
   private String var_nature;
   private String var_activite;
   private Date dateDebut;
   private Date dateFin;
   private String debut;
   private String fin;
   private UtilDate utilDate = new UtilDate();
   private String periode;
   private List mesEntitesItems = new ArrayList();
   private String var_entite;
   private boolean afficheEntite = false;
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
   private double totalBudget;
   private double totalRealise;
   private double totalEcart;
   private List lesModelsimpression = new ArrayList();
   private boolean showModalPanelPrint = false;
   private List lesModelesAutorises;

   public FormExtraitBudget() throws IOException {
   }

   public void InstancesDaoUtilses() {
      this.budgetDao = new BudgetDao(this.baseLog, this.utilInitHibernate);
      this.budgetLigneDao = new BudgetLigneDao(this.baseLog, this.utilInitHibernate);
      this.plansBudgetairesDao = new PlansBudgetairesDao(this.baseLog, this.utilInitHibernate);
      this.planBudgetaireCompteDao = new PlanBudgetaireCompteDao(this.baseLog, this.utilInitHibernate);
      this.projetsDao = new ProjetsDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresDao = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresAnalytiquesDao = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
   }

   public void initAnalytique() throws HibernateException, NamingException {
      if (this.optionComptabilite.getNbLigneMaxBu() != null && !this.optionComptabilite.getNbLigneMaxBu().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionComptabilite.getNbLigneMaxBu());
      } else {
         this.var_nb_max = 100;
      }

      this.testactivite = this.structureLog.isStrActivite();
      this.testagent = this.structureLog.isStrAgent();
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
      new ArrayList();
      List var1 = this.projetsDao.selectAllProjets(0, (Session)null);
      if (var1.size() != 0) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            this.mesTypesItems.add(new SelectItem(((Projets)var1.get(var2)).getProCode(), ((Projets)var1.get(var2)).getProCode() + ":" + ((Projets)var1.get(var2)).getProNomFR()));
         }
      }

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

   public void trouverBudget() throws HibernateException, NamingException, ParseException {
      this.dateDebut = this.selectedExo.getExecptDateDebut();
      this.dateFin = this.selectedExo.getExecptDateFin();
      this.showModalPanelBudget = true;
   }

   public void calculeEntite() throws HibernateException, NamingException {
      this.mesEntitesItems.clear();
      this.afficheEntite = false;
      new ArrayList();
      List var1 = this.budgetDao.chargerLesBudgets(this.var_nature, this.var_annee, "", (Session)null);
      if (var1.size() != 0) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            if (((Budget)var1.get(var2)).getBudType() == 15) {
               this.mesEntitesItems.add(new SelectItem(((Budget)var1.get(var2)).getBudEntite(), ((Budget)var1.get(var2)).getBudEntite() + ":" + ((Budget)var1.get(var2)).getBudLibelleFr()));
               this.afficheEntite = true;
            }
         }
      }

   }

   public void annulerBudget() {
      this.showModalPanelBudget = false;
   }

   public void recherche() throws HibernateException, NamingException {
      this.totalBudget = 0.0D;
      this.totalRealise = 0.0D;
      this.totalEcart = 0.0D;
      this.lesBudgets.clear();
      this.debut = this.utilDate.dateToStringSQLLight(this.dateDebut);
      this.fin = this.utilDate.dateToStringSQLLight(this.dateFin);
      this.periode = "Période du " + this.utilDate.dateToStringFr(this.dateDebut) + " au " + this.utilDate.dateToStringFr(this.dateFin);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Budget");
      this.projets = this.projetsDao.chargerLeProjet(0, this.var_nature, var1);
      if (this.projets == null) {
         this.projets = new Projets();
      }

      this.inputProjet = "";
      String var2 = "";
      if (this.var_choix_reamenagement.contentEquals("0")) {
         var2 = "Budget initial";
      } else if (this.var_choix_reamenagement.contentEquals("1")) {
         var2 = "Réaménagement N° 1";
      } else if (this.var_choix_reamenagement.contentEquals("2")) {
         var2 = "Réaménagement N° 2";
      } else if (this.var_choix_reamenagement.contentEquals("3")) {
         var2 = "Réaménagement N° 3";
      }

      byte var3 = 0;
      if (this.var_nature.equalsIgnoreCase("1")) {
         this.inputProjet = "Plans budgétaires : Vente - Année " + this.var_annee + " - " + var2;
      } else if (this.var_nature.equalsIgnoreCase("2")) {
         this.inputProjet = "Plans budgétaires : Achats - Année " + this.var_annee + " - " + var2;
      } else if (this.var_nature.equalsIgnoreCase("3")) {
         this.inputProjet = "Plans budgétaires : Production - Année " + this.var_annee + " - " + var2;
      } else if (this.var_nature.equalsIgnoreCase("4")) {
         this.inputProjet = "Plans budgétaires : Frais généraux - Année " + this.var_annee + " - " + var2;
      } else if (this.var_nature.equalsIgnoreCase("5")) {
         this.inputProjet = "Plans budgétaires : Investissements - Année " + this.var_annee + " - " + var2;
      } else if (this.var_nature.equalsIgnoreCase("6")) {
         this.inputProjet = "Plans budgétaires : T.V.A. - Année " + this.var_annee + " - " + var2;
      } else if (this.var_nature.equalsIgnoreCase("7")) {
         this.inputProjet = "Plans budgétaires : Impôts et taxes - Année " + this.var_annee + " - " + var2;
      } else if (this.var_nature.equalsIgnoreCase("8")) {
         this.inputProjet = "Plans budgétaires : Personnels - Année " + this.var_annee + " - " + var2;
      } else if (this.var_nature.equalsIgnoreCase("9")) {
         this.inputProjet = "Plans budgétaires : Familles/Produits - Année " + this.var_annee + " - " + var2;
         var3 = 1;
      } else {
         this.inputProjet = "Plans budgétaires :" + this.projets.getProCode() + ":" + this.projets.getProNomFR() + " - Année " + this.var_annee + " - " + var2;
      }

      new ArrayList();
      List var4;
      if (this.var_entite != null && !this.var_entite.isEmpty()) {
         var4 = this.plansBudgetairesDao.chargerLesPlansBudgetaires(this.selectedExo, var3, this.var_nature, this.var_annee, this.var_entite, var1);
      } else {
         var4 = this.plansBudgetairesDao.chargerLesPlansBudgetaires(this.selectedExo, var3, this.var_nature, this.var_annee, var1);
      }

      new ArrayList();
      List var5;
      if (this.var_entite != null && !this.var_entite.isEmpty()) {
         var5 = this.budgetDao.chargerLesBudgetsEntite(this.var_nature, this.var_annee, this.var_entite, var1);
      } else {
         var5 = this.budgetDao.chargerLesBudgets(this.var_nature, this.var_annee, this.var_activite, var1);
      }

      Budget var7;
      int var8;
      boolean var9;
      int var10;
      if (var4.size() != 0) {
         PlansBudgetaires var6;
         if (this.projets != null && this.projets.getProId() != 0L) {
            new PlansBudgetaires();
            new Budget();

            for(var8 = 0; var8 < var4.size(); ++var8) {
               var6 = (PlansBudgetaires)var4.get(var8);
               if (this.var_entite == null || this.var_entite.isEmpty() || this.var_entite != null && !this.var_entite.isEmpty() && var6.getPlbEntite() != null && !var6.getPlbEntite().isEmpty() && var6.getPlbEntite().equals(this.var_entite)) {
                  if (var5.size() == 0) {
                     var7 = new Budget();
                     var7.setBudAnnee(var6.getPlbAnnee());
                     var7.setBudCode(var6.getPlbCode());
                     var7.setBudEntite(var6.getPlbEntite());
                     var7.setBudLibelleFr(var6.getPlbLibelleFr());
                     var7.setBudLibelleSp(var6.getPlbLibelleSp());
                     var7.setBudLibelleUk(var6.getPlbLibelleUk());
                     var7.setBudNature(var6.getPlbNature());
                     var7.setBudType(var6.getPlbType());
                     var7.setBudProjet(var6.getPlbProjet());
                     var7.setBudUtil(0);
                     if (this.var_choix_reamenagement.equals("0")) {
                        var7.setVarBudget(var7.getBud01TotVal());
                     } else if (this.var_choix_reamenagement.equals("1")) {
                        var7.setVarBudget(var7.getBud02TotVal());
                     } else if (this.var_choix_reamenagement.equals("2")) {
                        var7.setVarBudget(var7.getBud03TotVal());
                     } else if (this.var_choix_reamenagement.equals("3")) {
                        var7.setVarBudget(var7.getBud04TotVal());
                     }

                     var7.setExercicescomptable(this.selectedExo);
                     this.lesBudgets.add(var7);
                  } else {
                     var9 = false;

                     for(var10 = 0; var10 < var5.size(); ++var10) {
                        var7 = (Budget)var5.get(var10);
                        if (var6.getPlbCode() != null && !var6.getPlbCode().isEmpty() && var7.getBudCode() != null && !var7.getBudCode().isEmpty() && var6.getPlbCode().equalsIgnoreCase(var7.getBudCode()) || this.projets.getProId() == 0L) {
                           var9 = true;
                           var7.setChoixReam(Integer.parseInt(this.var_choix_reamenagement));
                           if (this.var_choix_reamenagement.equals("0")) {
                              var7.setVarBudget(var7.getBud01TotVal());
                           } else if (this.var_choix_reamenagement.equals("1")) {
                              var7.setVarBudget(var7.getBud02TotVal());
                           } else if (this.var_choix_reamenagement.equals("2")) {
                              var7.setVarBudget(var7.getBud03TotVal());
                           } else if (this.var_choix_reamenagement.equals("3")) {
                              var7.setVarBudget(var7.getBud04TotVal());
                           }

                           this.lesBudgets.add(var7);
                           break;
                        }
                     }

                     if (!var9) {
                        var7 = new Budget();
                        var7.setBudAnnee(var6.getPlbAnnee());
                        var7.setBudCode(var6.getPlbCode());
                        var7.setBudEntite(var6.getPlbEntite());
                        var7.setBudLibelleFr(var6.getPlbLibelleFr());
                        var7.setBudLibelleSp(var6.getPlbLibelleSp());
                        var7.setBudLibelleUk(var6.getPlbLibelleUk());
                        var7.setBudNature(var6.getPlbNature());
                        var7.setBudType(var6.getPlbType());
                        var7.setBudProjet(var6.getPlbProjet());
                        var7.setBudUtil(0);
                        if (this.var_choix_reamenagement.equals("0")) {
                           var7.setVarBudget(var7.getBud01TotVal());
                        } else if (this.var_choix_reamenagement.equals("1")) {
                           var7.setVarBudget(var7.getBud02TotVal());
                        } else if (this.var_choix_reamenagement.equals("2")) {
                           var7.setVarBudget(var7.getBud03TotVal());
                        } else if (this.var_choix_reamenagement.equals("3")) {
                           var7.setVarBudget(var7.getBud04TotVal());
                        }

                        var7.setExercicescomptable(this.selectedExo);
                        this.lesBudgets.add(var7);
                     }
                  }
               }
            }
         } else {
            new PlansBudgetaires();
            new Budget();

            for(var8 = 0; var8 < var4.size(); ++var8) {
               var6 = (PlansBudgetaires)var4.get(var8);
               if (this.var_entite == null || this.var_entite.isEmpty() || this.var_entite != null && !this.var_entite.isEmpty() && var6.getPlbEntite() != null && !var6.getPlbEntite().isEmpty() && var6.getPlbEntite().equals(this.var_entite)) {
                  if (var5.size() == 0) {
                     var7 = new Budget();
                     var7.setBudAnnee(var6.getPlbAnnee());
                     var7.setBudCode(var6.getPlbCode());
                     var7.setBudEntite(var6.getPlbEntite());
                     var7.setBudLibelleFr(var6.getPlbLibelleFr());
                     var7.setBudLibelleSp(var6.getPlbLibelleSp());
                     var7.setBudLibelleUk(var6.getPlbLibelleUk());
                     var7.setBudNature(var6.getPlbNature());
                     var7.setBudType(var6.getPlbType());
                     var7.setBudProjet(var6.getPlbProjet());
                     var7.setBudUtil(0);
                     if (this.var_choix_reamenagement.equals("0")) {
                        var7.setVarBudget(var7.getBud01TotVal());
                     } else if (this.var_choix_reamenagement.equals("1")) {
                        var7.setVarBudget(var7.getBud02TotVal());
                     } else if (this.var_choix_reamenagement.equals("2")) {
                        var7.setVarBudget(var7.getBud03TotVal());
                     } else if (this.var_choix_reamenagement.equals("3")) {
                        var7.setVarBudget(var7.getBud04TotVal());
                     }

                     var7.setExercicescomptable(this.selectedExo);
                     this.lesBudgets.add(var7);
                  } else {
                     var9 = false;

                     for(var10 = 0; var10 < var5.size(); ++var10) {
                        var7 = (Budget)var5.get(var10);
                        if (var6.getPlbCode() != null && !var6.getPlbCode().isEmpty() && var7.getBudCode() != null && !var7.getBudCode().isEmpty() && var6.getPlbCode().equalsIgnoreCase(var7.getBudCode())) {
                           var9 = true;
                           var7.setChoixReam(Integer.parseInt(this.var_choix_reamenagement));
                           if (this.var_choix_reamenagement.equals("0")) {
                              var7.setVarBudget(var7.getBud01TotVal());
                           } else if (this.var_choix_reamenagement.equals("1")) {
                              var7.setVarBudget(var7.getBud02TotVal());
                           } else if (this.var_choix_reamenagement.equals("2")) {
                              var7.setVarBudget(var7.getBud03TotVal());
                           } else if (this.var_choix_reamenagement.equals("3")) {
                              var7.setVarBudget(var7.getBud04TotVal());
                           }

                           this.lesBudgets.add(var7);
                           break;
                        }
                     }

                     if (!var9) {
                        var7 = new Budget();
                        var7.setBudAnnee(var6.getPlbAnnee());
                        var7.setBudCode(var6.getPlbCode());
                        var7.setBudEntite(var6.getPlbEntite());
                        var7.setBudLibelleFr(var6.getPlbLibelleFr());
                        var7.setBudLibelleSp(var6.getPlbLibelleSp());
                        var7.setBudLibelleUk(var6.getPlbLibelleUk());
                        var7.setBudNature(var6.getPlbNature());
                        var7.setBudType(var6.getPlbType());
                        var7.setBudProjet(var6.getPlbProjet());
                        var7.setBudUtil(0);
                        if (this.var_choix_reamenagement.equals("0")) {
                           var7.setVarBudget(var7.getBud01TotVal());
                        } else if (this.var_choix_reamenagement.equals("1")) {
                           var7.setVarBudget(var7.getBud02TotVal());
                        } else if (this.var_choix_reamenagement.equals("2")) {
                           var7.setVarBudget(var7.getBud03TotVal());
                        } else if (this.var_choix_reamenagement.equals("3")) {
                           var7.setVarBudget(var7.getBud04TotVal());
                        }

                        var7.setExercicescomptable(this.selectedExo);
                        this.lesBudgets.add(var7);
                     }
                  }
               }
            }
         }
      }

      if (this.var_entite != null && !this.var_entite.isEmpty() && var5.size() != 0) {
         new Budget();
         new Budget();

         for(var8 = 0; var8 < var5.size(); ++var8) {
            Budget var11 = (Budget)var5.get(var8);
            if (this.var_entite == null || this.var_entite.isEmpty() || this.var_entite != null && !this.var_entite.isEmpty() && var11.getBudEntite() != null && !var11.getBudEntite().isEmpty() && var11.getBudEntite().equals(this.var_entite)) {
               var9 = false;

               for(var10 = 0; var10 < this.lesBudgets.size(); ++var10) {
                  var7 = (Budget)this.lesBudgets.get(var10);
                  if (var11.getBudCode() != null && !var11.getBudCode().isEmpty() && var7.getBudCode() != null && !var7.getBudCode().isEmpty() && var11.getBudCode().equalsIgnoreCase(var7.getBudCode())) {
                     var9 = true;
                     break;
                  }
               }

               if (!var9) {
                  this.lesBudgets.add(var11);
               }
            }
         }
      }

      if (this.projets != null && this.projets.getProId() != 0L) {
         this.lesBudgets = this.caluleRealiseProjet(var1);
      } else {
         this.lesBudgets = this.caluleRealiseCompte(var1);
      }

      for(int var12 = 0; var12 < this.lesBudgets.size(); ++var12) {
         this.totalBudget += ((Budget)this.lesBudgets.get(var12)).getVarBudget();
         this.totalRealise += ((Budget)this.lesBudgets.get(var12)).getVarRealise();
      }

      this.totalEcart = this.totalBudget - this.totalRealise;
      this.miseEnForme();
      this.utilInitHibernate.closeSession();
      this.dataModelLesBudgets.setWrappedData(this.lesBudgets);
      this.showModalPanelBudget = false;
   }

   public List caluleRealiseProjet(Session var1) throws HibernateException, NamingException {
      ArrayList var2 = new ArrayList();
      List var3;
      int var4;
      double var5;
      if (this.var_entite == null || this.var_entite.isEmpty()) {
         new ArrayList();
         var3 = this.ecrituresDao.chargerEcrituresBudget(this.debut, this.fin, this.var_nature, var1);
         if (var3.size() != 0) {
            for(var4 = 0; var4 < this.lesBudgets.size(); ++var4) {
               this.budget = (Budget)this.lesBudgets.get(var4);
               var5 = 0.0D;
               double var7 = 0.0D;
               if (this.budget.getBudType() != 0 && this.budget.getBudType() != 1) {
                  var2.add(this.budget);
               } else {
                  for(int var9 = 0; var9 < var3.size(); ++var9) {
                     if (((Ecritures)var3.get(var9)).getEcrPosteTreso() != null && !((Ecritures)var3.get(var9)).getEcrPosteTreso().isEmpty() && this.budget.getBudCode() != null && !this.budget.getBudCode().isEmpty() && ((Ecritures)var3.get(var9)).getEcrPosteTreso().equals(this.budget.getBudCode())) {
                        var5 += ((Ecritures)var3.get(var9)).getEcrDebitPays();
                        var7 += ((Ecritures)var3.get(var9)).getEcrCreditPays();
                     }
                  }

                  this.budget.setVarRealise(var5 - var7);
                  var2.add(this.budget);
               }
            }
         } else {
            for(var4 = 0; var4 < this.lesBudgets.size(); ++var4) {
               this.budget = (Budget)this.lesBudgets.get(var4);
               var2.add(this.budget);
            }
         }
      }

      if (this.var_entite != null && !this.var_entite.isEmpty()) {
         new ArrayList();
         var3 = this.ecrituresAnalytiquesDao.chargerEcrituresEntite(this.debut, this.fin, this.var_nature, this.var_entite, var1);
         if (var3.size() != 0) {
            for(var4 = 0; var4 < this.lesBudgets.size(); ++var4) {
               this.budget = (Budget)this.lesBudgets.get(var4);
               var5 = 0.0D;
               if (this.budget.getBudType() != 0 && this.budget.getBudType() != 1) {
                  var2.add(this.budget);
               } else {
                  for(int var10 = 0; var10 < var3.size(); ++var10) {
                     if (((EcrituresAnalytique)var3.get(var10)).getEcranaPoste() != null && !((EcrituresAnalytique)var3.get(var10)).getEcranaPoste().isEmpty() && this.budget.getBudCode() != null && !this.budget.getBudCode().isEmpty() && ((EcrituresAnalytique)var3.get(var10)).getEcranaPoste().equals(this.budget.getBudCode())) {
                        if (((EcrituresAnalytique)var3.get(var10)).getEcranaSens() == 1) {
                           var5 -= ((EcrituresAnalytique)var3.get(var10)).getEcranaMontantSaisie();
                        } else {
                           var5 += ((EcrituresAnalytique)var3.get(var10)).getEcranaMontantSaisie();
                        }
                     }
                  }

                  this.budget.setVarRealise(var5);
                  var2.add(this.budget);
               }
            }
         } else {
            for(var4 = 0; var4 < this.lesBudgets.size(); ++var4) {
               this.budget = (Budget)this.lesBudgets.get(var4);
               var2.add(this.budget);
            }
         }
      }

      return var2;
   }

   public List caluleRealiseCompte(Session var1) throws HibernateException, NamingException {
      ArrayList var2 = new ArrayList();
      new ArrayList();

      for(int var4 = 0; var4 < this.lesBudgets.size(); ++var4) {
         this.budget = (Budget)this.lesBudgets.get(var4);
         double var5 = 0.0D;
         double var7 = 0.0D;
         if (this.budget.getBudType() != 0 && this.budget.getBudType() != 1) {
            var2.add(this.budget);
         } else {
            List var3 = this.planBudgetaireCompteDao.chargerLesComptesCode(this.var_annee, this.budget.getBudCode(), 0, var1);
            if (var3.size() == 0) {
               var2.add(this.budget);
            } else {
               var5 = 0.0D;
               var7 = 0.0D;
               new ArrayList();

               for(int var10 = 0; var10 < var3.size(); ++var10) {
                  List var9 = this.ecrituresDao.chargerEcrituresByCompte(this.dateDebut, this.dateFin, ((PlanBudgetaireCompte)var3.get(var10)).getPlbcptCompte(), var1);
                  if (var9.size() != 0) {
                     for(int var11 = 0; var11 < var9.size(); ++var11) {
                        var5 += ((Ecritures)var9.get(var11)).getEcrDebitPays();
                        var7 += ((Ecritures)var9.get(var11)).getEcrCreditPays();
                     }
                  }
               }

               this.budget.setVarRealise(var5 - var7);
               var2.add(this.budget);
            }
         }
      }

      return var2;
   }

   public void miseEnForme() {
      if (this.lesBudgets.size() != 0) {
         for(int var1 = 0; var1 < this.lesBudgets.size(); ++var1) {
            this.budget = (Budget)this.lesBudgets.get(var1);
            double var2;
            double var4;
            int var6;
            if (this.budget.getBudType() == 15) {
               var2 = 0.0D;
               var4 = 0.0D;

               for(var6 = var1 + 1; var6 < this.lesBudgets.size(); ++var6) {
                  if (((Budget)this.lesBudgets.get(var6)).getBudType() == 1) {
                     var2 += ((Budget)this.lesBudgets.get(var6)).getVarBudget();
                     var4 += ((Budget)this.lesBudgets.get(var6)).getVarRealise();
                  }

                  if (((Budget)this.lesBudgets.get(var6)).getBudType() == 15) {
                     break;
                  }
               }

               this.budget.setVarBudget(var2);
               this.budget.setVarRealise(var4);
            } else if (this.budget.getBudType() == 20) {
               var2 = 0.0D;
               var4 = 0.0D;

               for(var6 = var1 + 1; var6 < this.lesBudgets.size(); ++var6) {
                  if (((Budget)this.lesBudgets.get(var6)).getBudType() == 1) {
                     var2 += ((Budget)this.lesBudgets.get(var6)).getVarBudget();
                     var4 += ((Budget)this.lesBudgets.get(var6)).getVarRealise();
                  }

                  if (((Budget)this.lesBudgets.get(var6)).getBudType() == 20) {
                     break;
                  }
               }

               this.budget.setVarBudget(var2);
               this.budget.setVarRealise(var4);
            } else if (this.budget.getBudType() == 21) {
               var2 = 0.0D;
               var4 = 0.0D;

               for(var6 = var1 + 1; var6 < this.lesBudgets.size(); ++var6) {
                  if (((Budget)this.lesBudgets.get(var6)).getBudType() == 1) {
                     var2 += ((Budget)this.lesBudgets.get(var6)).getVarBudget();
                     var4 += ((Budget)this.lesBudgets.get(var6)).getVarRealise();
                  }

                  if (((Budget)this.lesBudgets.get(var6)).getBudType() == 21) {
                     break;
                  }
               }

               this.budget.setVarBudget(var2);
               this.budget.setVarRealise(var4);
            } else if (this.budget.getBudType() == 22) {
               var2 = 0.0D;
               var4 = 0.0D;

               for(var6 = var1 + 1; var6 < this.lesBudgets.size(); ++var6) {
                  if (((Budget)this.lesBudgets.get(var6)).getBudType() == 1) {
                     var2 += ((Budget)this.lesBudgets.get(var6)).getVarBudget();
                     var4 += ((Budget)this.lesBudgets.get(var6)).getVarRealise();
                  }

                  if (((Budget)this.lesBudgets.get(var6)).getBudType() == 22) {
                     break;
                  }
               }

               this.budget.setVarBudget(var2);
               this.budget.setVarRealise(var4);
            }
         }
      }

   }

   public void selectionBudget() throws HibernateException, NamingException {
      if (this.dataModelLesBudgets.isRowAvailable()) {
         this.budget = (Budget)this.dataModelLesBudgets.getRowData();
         this.var_affiche_bouton = true;
      }

   }

   public void visualisationPoste() throws HibernateException, NamingException {
      if (this.budget != null) {
         if (this.var_entite != null && !this.var_entite.isEmpty()) {
            this.avecProjet();
         } else if (this.var_nature == null || this.var_nature.isEmpty() || !this.var_nature.equals("1") && !this.var_nature.equals("2") && !this.var_nature.equals("3") && !this.var_nature.equals("4") && !this.var_nature.equals("5") && !this.var_nature.equals("6") && !this.var_nature.equals("7")) {
            this.sansProjet();
         } else {
            this.sansProjetImplicite();
         }
      }

   }

   public void avecProjet() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Budget");
      ArrayList var2 = new ArrayList();
      new ArrayList();
      List var3 = this.ecrituresAnalytiquesDao.chargerEcrituresEntite(this.debut, this.fin, this.var_nature, this.budget.getBudCode(), this.var_entite, var1);
      int var4;
      if (var3.size() != 0) {
         for(var4 = 0; var4 < var3.size(); ++var4) {
            this.ecritures = ((EcrituresAnalytique)var3.get(var4)).getEcritures();
            if (this.ecritures.getEcrDebitPays() != 0.0D && this.ecritures.getEcrCreditPays() == 0.0D) {
               this.ecritures.setEcrDebitPays(((EcrituresAnalytique)var3.get(var4)).getEcranaMontantSaisie());
            } else {
               this.ecritures.setEcrCreditPays(((EcrituresAnalytique)var3.get(var4)).getEcranaMontantSaisie());
            }

            var2.add(this.ecritures);
         }
      }

      this.var_tot_debit = 0.0D;
      this.var_tot_credit = 0.0D;
      if (var2.size() != 0) {
         for(var4 = 0; var4 < var2.size(); ++var4) {
            this.var_tot_debit += ((Ecritures)var2.get(var4)).getEcrDebitPays();
            this.var_tot_credit += ((Ecritures)var2.get(var4)).getEcrCreditPays();
         }
      }

      this.var_solde = this.var_tot_debit - this.var_tot_credit;
      this.utilInitHibernate.closeSession();
      this.dataModelLesBudgetsLigne.setWrappedData(var2);
      this.showModalPanelDetailPiece = true;
   }

   public void sansProjet() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Budget");
      ArrayList var2 = new ArrayList();
      new ArrayList();
      List var3 = this.ecrituresDao.chargerEcrituresBudget(this.debut, this.fin, this.var_nature, this.budget.getBudCode(), var1);
      int var4;
      if (var3.size() != 0) {
         for(var4 = 0; var4 < var3.size(); ++var4) {
            this.ecritures = (Ecritures)var3.get(var4);
            var2.add(this.ecritures);
         }
      }

      this.var_tot_debit = 0.0D;
      this.var_tot_credit = 0.0D;
      if (var2.size() != 0) {
         for(var4 = 0; var4 < var2.size(); ++var4) {
            this.var_tot_debit += ((Ecritures)var2.get(var4)).getEcrDebitPays();
            this.var_tot_credit += ((Ecritures)var2.get(var4)).getEcrCreditPays();
         }
      }

      this.var_solde = this.var_tot_debit - this.var_tot_credit;
      this.utilInitHibernate.closeSession();
      this.dataModelLesBudgetsLigne.setWrappedData(var2);
      this.showModalPanelDetailPiece = true;
   }

   public void sansProjetImplicite() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Budget");
      ArrayList var2 = new ArrayList();
      if (this.budget.getBudType() == 0 || this.budget.getBudType() == 1) {
         ArrayList var3 = new ArrayList();
         new ArrayList();
         List var4 = this.planBudgetaireCompteDao.chargerLesComptesCode(this.var_annee, this.budget.getBudCode(), 0, var1);
         if (var4.size() != 0) {
            for(int var5 = 0; var5 < var4.size(); ++var5) {
               var3.add(((PlanBudgetaireCompte)var4.get(var5)).getPlbcptCompte());
            }

            new ArrayList();
            List var8 = this.ecrituresDao.chargerEcrituresBudget(this.debut, this.fin, (List)var3, var1);
            if (var8.size() != 0) {
               for(int var6 = 0; var6 < var8.size(); ++var6) {
                  this.ecritures = (Ecritures)var8.get(var6);
                  var2.add(this.ecritures);
               }
            }
         }
      }

      this.var_tot_debit = 0.0D;
      this.var_tot_credit = 0.0D;
      if (var2.size() != 0) {
         for(int var7 = 0; var7 < var2.size(); ++var7) {
            this.var_tot_debit += ((Ecritures)var2.get(var7)).getEcrDebitPays();
            this.var_tot_credit += ((Ecritures)var2.get(var7)).getEcrCreditPays();
         }
      }

      this.var_solde = this.var_tot_debit - this.var_tot_credit;
      this.utilInitHibernate.closeSession();
      this.dataModelLesBudgetsLigne.setWrappedData(var2);
      this.showModalPanelDetailPiece = true;
   }

   public void fermerDetailPoste() {
      this.showModalPanelDetailPiece = false;
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
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_gene" + File.separator + "extrait_budget";
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
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_gene" + File.separator + "extrait_budget" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
         var1.setEntete("Impression Budget");
         var1.setFiltre(this.inputProjet);
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataire(var8);
         var1.setDestinataire(var9);
         var1.setCorpsMail(var10);
         var1.setTiersSelectionne((Tiers)null);
         JRBeanCollectionDataSource var11 = new JRBeanCollectionDataSource(this.lesBudgets);
         var1.setjRBeanCollectionDataSource(var11);
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

   public boolean isShowModalPanelBudget() {
      return this.showModalPanelBudget;
   }

   public void setShowModalPanelBudget(boolean var1) {
      this.showModalPanelBudget = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public boolean isShowModalPanelDetailPiece() {
      return this.showModalPanelDetailPiece;
   }

   public void setShowModalPanelDetailPiece(boolean var1) {
      this.showModalPanelDetailPiece = var1;
   }

   public String getInputProjet() {
      return this.inputProjet;
   }

   public void setInputProjet(String var1) {
      this.inputProjet = var1;
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

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
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

   public List getMesEntitesItems() {
      return this.mesEntitesItems;
   }

   public void setMesEntitesItems(List var1) {
      this.mesEntitesItems = var1;
   }

   public String getVar_entite() {
      return this.var_entite;
   }

   public void setVar_entite(String var1) {
      this.var_entite = var1;
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
}
