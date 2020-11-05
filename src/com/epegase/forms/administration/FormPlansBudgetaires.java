package com.epegase.forms.administration;

import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.FamillesProduitsAchats;
import com.epegase.systeme.classe.PlanBudgetaireCompte;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.PlansBudgetaires;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.Projets;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.EcrituresAnalytiquesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.PlanBudgetaireCompteDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PlansBudgetairesDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.ProjetsDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormPlansBudgetaires implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private ExercicesComptable lastExercice;
   private ExercicesComptable exoSelectionne;
   private PlansBudgetaires plansBudgetaires = new PlansBudgetaires();
   private List lesPlansBudgetaires = new ArrayList();
   private transient DataModel dataModelLesPlansBudgetaires = new ListDataModel();
   private boolean existCod = true;
   private boolean inactifPlb = false;
   private boolean showButtonSupp = false;
   private boolean showButtonModif = false;
   private boolean showButtonPanel = false;
   private boolean showOngletCompte = false;
   private boolean showModalPanelPlan = false;
   private boolean valideDupplication = false;
   private long idPlbEncours;
   private int ordre;
   private int var_aff_nature;
   private int choixBudget;
   private PlanBudgetaireCompteDao planBudgetaireCompteDao;
   private PlansBudgetairesDao plansBudgetairesDao;
   private ExercicesComptableDao exercicesComptableDao;
   private EcrituresAnalytiquesDao ecrituresAnalytiquesDao;
   private EcrituresDao ecrituresDao;
   private List mesTypesItems = new ArrayList();
   private boolean moduleProjet = false;
   private String var_annee = "0";
   private String var_anneeDestination;
   private List mesAnneeItems;
   private String var_nature;
   private String var_activite = "";
   private List mesActivitesItems;
   private PlanComptableDao planComptableDao;
   private PlanComptable planComptable;
   private List lesPlansComptables = new ArrayList();
   private transient DataModel dataModelPlbCompte = new ListDataModel();
   private transient DataModel dataModelPlbPlansComptables = new ListDataModel();
   private boolean testplbCptesup = false;
   private PlanBudgetaireCompte planBudgetaireCompte = new PlanBudgetaireCompte();
   private List lesplanBudgetaireCompte = new ArrayList();
   private PlanBudgetaireCompte planBudgetaireProduit;
   private ProduitsVtesDao produitsVtesDao;
   private ProduitsAchsDao produitsAchsDao;
   private Produits produits;
   private List lesProduits = new ArrayList();
   private transient DataModel dataModelProduits = new ListDataModel();
   private boolean testplbProdesup = false;
   private transient DataModel dataModelPlbPlansProduits = new ListDataModel();
   private List lesplanBudgetaireProduit = new ArrayList();
   private long idPlbPrec;
   private long idPlbSuiv;
   private long idPlbCpte;
   private int plbOrdreEncours;
   private int plbOrdrePrecedent;
   private int plbOrdreSuivant;
   private int plbIndex;
   private String filtre;
   private String entete;
   private String requete;
   private boolean showModalPanelBudget = false;
   private boolean showModalPanelBudgetFiche = false;
   private transient DataModel dataModelListeBudget = new ListDataModel();
   private List lesBudgets = new ArrayList();
   private Projets projets;
   private ProjetsDao projetsDao;
   private boolean afficheBudget;
   private boolean existBudget;
   private List mesEntitestems = new ArrayList();
   private int choixRacine;
   private String selecFiscalite;

   public void InstancesDaoUtilses() {
      this.planBudgetaireCompteDao = new PlanBudgetaireCompteDao(this.baseLog, this.utilInitHibernate);
      this.plansBudgetairesDao = new PlansBudgetairesDao(this.baseLog, this.utilInitHibernate);
      this.exercicesComptableDao = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresDao = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresAnalytiquesDao = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.produitsVtesDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      this.projetsDao = new ProjetsDao(this.baseLog, this.utilInitHibernate);
   }

   public void calculAnnee(Session var1) throws HibernateException, NamingException {
      this.moduleProjet = this.rechercheModule(40300);
      int var2 = this.exoSelectionne.getExecptDateDebut().getYear() + 1900;
      int var3 = this.exoSelectionne.getExecptDateFin().getYear() + 1900;
      this.mesAnneeItems = new ArrayList();
      String var4 = "";

      for(int var5 = var2; var5 <= var3; ++var5) {
         var4 = "" + var5;
         this.mesAnneeItems.add(new SelectItem(var4));
      }

      this.mesTypesItems.clear();
      if (this.choixBudget == 0) {
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
      } else {
         this.mesTypesItems.add(new SelectItem(9, "Familles/Produits Achats"));
      }

      if (!this.moduleProjet) {
         new ArrayList();
         List var7 = this.projetsDao.selectAllProjets(this.choixBudget, var1);
         if (var7.size() != 0) {
            for(int var6 = 0; var6 < var7.size(); ++var6) {
               if (((Projets)var7.get(var6)).getProCode() != null && !((Projets)var7.get(var6)).getProCode().isEmpty()) {
                  this.mesTypesItems.add(new SelectItem(((Projets)var7.get(var6)).getProCode(), ((Projets)var7.get(var6)).getProCode() + ":" + ((Projets)var7.get(var6)).getProNomFR()));
               }
            }
         }
      }

      this.selecFiscalite = this.structureLog.getStrzonefiscale();
   }

   public void calculActivites(Session var1) throws HibernateException, NamingException {
      this.mesActivitesItems = new ArrayList();
      ActivitesDao var2 = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      this.mesActivitesItems = var2.chargerLesActivites(var1);
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

   public void buttonPanel() {
      this.lesPlansBudgetaires.clear();
      this.lesPlansComptables.clear();
      this.lesProduits.clear();
      this.lesplanBudgetaireCompte.clear();
      this.lesplanBudgetaireProduit.clear();
      if (this.var_annee != null && this.var_annee.length() == 4 && this.var_nature != null && !this.var_nature.equalsIgnoreCase("0")) {
         this.showButtonPanel = true;
      } else {
         this.showButtonPanel = false;
      }

   }

   public void recherche() throws HibernateException, NamingException {
      this.lesPlansBudgetaires.clear();
      if (this.var_annee.length() != 4) {
         this.var_annee = "";
      }

      String var1 = "";
      if (this.var_activite.contains(":")) {
         String[] var2 = this.var_activite.split(":");
         var1 = var2[0];
      }

      this.requete = " plb_annee='" + this.var_annee + "' and plb_nature='" + this.var_nature + "' and plb_choix_budget=" + this.choixBudget + " order by plb_code";
      this.lesPlansBudgetaires = this.plansBudgetairesDao.chargerLesPlansBudgetaires(this.exoSelectionne, this.choixBudget, this.var_nature, this.var_annee, (Session)null);
      this.dataModelLesPlansBudgetaires.setWrappedData(this.lesPlansBudgetaires);
   }

   public void calculeEntite() {
      this.mesEntitestems.clear();
      if (this.lesPlansBudgetaires.size() != 0) {
         for(int var1 = 0; var1 < this.lesPlansBudgetaires.size(); ++var1) {
            if (((PlansBudgetaires)this.lesPlansBudgetaires.get(var1)).getPlbType() == 15) {
               this.mesEntitestems.add(new SelectItem(((PlansBudgetaires)this.lesPlansBudgetaires.get(var1)).getPlbEntite(), ((PlansBudgetaires)this.lesPlansBudgetaires.get(var1)).getPlbEntite() + ":" + ((PlansBudgetaires)this.lesPlansBudgetaires.get(var1)).getPlbLibelleFr()));
            }
         }
      }

   }

   public void selectionPlanBudget() throws HibernateException, NamingException {
      if (this.dataModelLesPlansBudgetaires.isRowAvailable()) {
         this.plansBudgetaires = (PlansBudgetaires)this.dataModelLesPlansBudgetaires.getRowData();
         this.idPlbEncours = this.plansBudgetaires.getPlb_id();
         if (this.plansBudgetaires.getPlbInactif() == 1) {
            this.inactifPlb = true;
         } else {
            this.inactifPlb = false;
         }

         if (this.plansBudgetaires.getPlbNature().equalsIgnoreCase("1")) {
            this.var_aff_nature = 1;
         } else if (this.plansBudgetaires.getPlbNature().equalsIgnoreCase("2")) {
            this.var_aff_nature = 2;
         } else if (this.plansBudgetaires.getPlbNature().equalsIgnoreCase("3")) {
            this.var_aff_nature = 3;
         } else if (!this.plansBudgetaires.getPlbNature().equalsIgnoreCase("4") && !this.plansBudgetaires.getPlbNature().equalsIgnoreCase("5") && !this.plansBudgetaires.getPlbNature().equalsIgnoreCase("6") && !this.plansBudgetaires.getPlbNature().equalsIgnoreCase("7")) {
            if (this.plansBudgetaires.getPlbNature().equalsIgnoreCase("8")) {
               this.var_aff_nature = 5;
            } else {
               this.var_aff_nature = 9;
            }
         } else {
            this.var_aff_nature = 4;
         }

         this.lesplanBudgetaireCompte.clear();
         this.lesplanBudgetaireCompte = this.planBudgetaireCompteDao.chargerLesPlansBudgetaireCompte(this.plansBudgetaires.getPlb_id(), 0, this.choixBudget, (Session)null);
         this.dataModelPlbPlansComptables.setWrappedData(this.lesplanBudgetaireCompte);
         this.lesplanBudgetaireProduit.clear();
         this.lesplanBudgetaireProduit = this.planBudgetaireCompteDao.chargerLesPlansBudgetaireCompte(this.plansBudgetaires.getPlb_id(), 1, this.choixBudget, (Session)null);
         this.dataModelPlbPlansProduits.setWrappedData(this.lesplanBudgetaireProduit);
         this.showButtonModif = true;
         this.showButtonSupp = true;
         if (this.var_nature.equalsIgnoreCase("1")) {
            this.filtre = "Plans budgétaires : Vente - Année " + this.var_annee;
         } else if (this.var_nature.equalsIgnoreCase("2")) {
            this.filtre = "Plans budgétaires : Achats - Année " + this.var_annee;
         } else if (this.var_nature.equalsIgnoreCase("3")) {
            this.filtre = "Plans budgétaires : Production - Année " + this.var_annee;
         } else if (this.var_nature.equalsIgnoreCase("4")) {
            this.filtre = "Plans budgétaires : Frais généraux - Année " + this.var_annee;
         } else if (this.var_nature.equalsIgnoreCase("5")) {
            this.filtre = "Plans budgétaires : Investissements - Année " + this.var_annee;
         } else if (this.var_nature.equalsIgnoreCase("6")) {
            this.filtre = "Plans budgétaires : T.V.A. - Année " + this.var_annee;
         } else if (this.var_nature.equalsIgnoreCase("7")) {
            this.filtre = "Plans budgétaires : Impôts et Taxes - Année " + this.var_annee;
         } else if (this.var_nature.equalsIgnoreCase("8")) {
            this.filtre = "Plans budgétaires : Personnels - Année " + this.var_annee;
         } else {
            this.filtre = "Plans budgétaires : " + this.plansBudgetaires.getPlbProjet() + " - Année " + this.var_annee;
         }
      }

   }

   public void ajouterPoste() throws NamingException {
      if (this.var_nature != null && !this.var_nature.isEmpty() && this.var_nature.equals("9")) {
         this.recherche();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlansBudgetaires");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            int var3;
            if (this.lesPlansBudgetaires.size() != 0) {
               for(var3 = 0; var3 < this.lesPlansBudgetaires.size(); ++var3) {
                  this.plansBudgetaires = (PlansBudgetaires)this.lesPlansBudgetaires.get(var3);
                  this.plansBudgetairesDao.delete(this.plansBudgetaires, var1);
               }
            }

            this.lesPlansBudgetaires.clear();
            var3 = 0;
            new ExercicesAchats();
            ExercicesAchatsDao var5 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
            ExercicesAchats var4 = var5.recupererLastExo(var1);
            if (var4 != null) {
               new ArrayList();
               new ArrayList();
               new FamillesProduitsAchats();
               FamillesProduitsAchatsDao var9 = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
               List var7 = var9.selectAllFamillProd(var4.getExeachId(), var1);
               if (var7.size() != 0) {
                  for(int var10 = 0; var10 < var7.size(); ++var10) {
                     FamillesProduitsAchats var8 = (FamillesProduitsAchats)var7.get(var10);
                     ++var3;
                     this.plansBudgetaires = new PlansBudgetaires();
                     this.plansBudgetaires.setExercicesComptable(this.exoSelectionne);
                     this.plansBudgetaires.setPlbAnnee(this.var_annee);
                     this.plansBudgetaires.setPlbBloque(0);
                     this.plansBudgetaires.setPlbChoixBudget(1);
                     this.plansBudgetaires.setPlbCode(var8.getFamachCode());
                     this.plansBudgetaires.setPlbDateCreat(new Date());
                     this.plansBudgetaires.setPlbEntite((String)null);
                     this.plansBudgetaires.setPlbLibelleFr(var8.getFamachLibelleFr());
                     this.plansBudgetaires.setPlbNature("9");
                     this.plansBudgetaires.setPlbOrdre(var3);
                     this.plansBudgetaires.setPlbProjet((String)null);
                     this.plansBudgetaires.setPlbType(2);
                     this.plansBudgetaires.setPlbUserCreat(this.usersLog.getUsrid());
                     if (var8.getFamachCode() != null && !var8.getFamachCode().isEmpty()) {
                        this.lesPlansBudgetaires.add(this.plansBudgetaires);
                        if (var8.getFamachCat() <= 3) {
                           List var6 = this.produitsAchsDao.chargerLesProduitsAchatsByFamille(var8.getFamachCode(), var1);
                           if (var6.size() != 0) {
                              for(int var11 = 0; var11 < var6.size(); ++var11) {
                                 this.produits = (Produits)var6.get(var11);
                                 ++var3;
                                 this.plansBudgetaires = new PlansBudgetaires();
                                 this.plansBudgetaires.setExercicesComptable(this.exoSelectionne);
                                 this.plansBudgetaires.setPlbAnnee(this.var_annee);
                                 this.plansBudgetaires.setPlbBloque(0);
                                 this.plansBudgetaires.setPlbChoixBudget(1);
                                 this.plansBudgetaires.setPlbCode(this.produits.getProCode());
                                 this.plansBudgetaires.setPlbDateCreat(new Date());
                                 this.plansBudgetaires.setPlbEntite((String)null);
                                 this.plansBudgetaires.setPlbLibelleFr(this.produits.getProLibClient());
                                 this.plansBudgetaires.setPlbNature("9");
                                 this.plansBudgetaires.setPlbOrdre(var3);
                                 this.plansBudgetaires.setPlbProjet((String)null);
                                 this.plansBudgetaires.setPlbType(0);
                                 this.plansBudgetaires.setPlbUserCreat(this.usersLog.getUsrid());
                                 if (this.produits.getProCode() != null && !this.produits.getProCode().isEmpty()) {
                                    this.lesPlansBudgetaires.add(this.plansBudgetaires);
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            if (this.lesPlansBudgetaires.size() != 0) {
               for(int var17 = 0; var17 < this.lesPlansBudgetaires.size(); ++var17) {
                  this.plansBudgetaires = (PlansBudgetaires)this.lesPlansBudgetaires.get(var17);
                  this.plansBudgetaires = this.plansBudgetairesDao.insert(this.plansBudgetaires, var1);
               }
            }

            var2.commit();
         } catch (HibernateException var15) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var15;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.dataModelLesPlansBudgetaires.setWrappedData(this.lesPlansBudgetaires);
         this.showOngletCompte = false;
      } else {
         this.calculeEntite();
         this.plansBudgetaires = new PlansBudgetaires();
         if (this.lesPlansBudgetaires.size() == 0) {
            this.plansBudgetaires.setPlbType(20);
         } else {
            this.plansBudgetaires.setPlbType(1);
         }

         this.idPlbEncours = 0L;
         this.existCod = true;
         this.showOngletCompte = false;
         this.showModalPanelPlan = true;
      }

   }

   public void modifierPoste() {
      this.calculeEntite();
      this.existCod = false;
      this.showOngletCompte = true;
      this.showModalPanelPlan = true;
   }

   public void supprimerPoste() throws HibernateException, NamingException {
      if (this.lesplanBudgetaireCompte.size() != 0) {
         this.planBudgetaireCompteDao.deletelesPlanBudgetComptes(this.lesplanBudgetaireCompte);
      }

      this.plansBudgetairesDao.delete(this.plansBudgetaires);
      this.recherche();
      this.showModalPanelPlan = false;
   }

   public void annulerSaisie() {
      this.showModalPanelPlan = false;
   }

   public void savePlanBudgetaire() throws HibernateException, NamingException {
      this.plansBudgetaires.setPlbAnnee(this.var_annee);
      String var1 = "";
      if (this.var_activite.contains(":")) {
         String[] var2 = this.var_activite.split(":");
         var1 = var2[0];
      }

      if (this.inactifPlb) {
         this.plansBudgetaires.setPlbInactif(1);
      } else {
         this.plansBudgetaires.setPlbInactif(0);
      }

      this.plansBudgetaires.setPlbChoixBudget(this.choixBudget);
      this.plansBudgetaires.setPlbNature(this.var_nature);
      this.plansBudgetaires.setPlbOrdre(this.getOrdre());
      if (this.plansBudgetaires.getPlb_id() == 0L) {
         this.plansBudgetaires.setPlbDateCreat(new Date());
         this.plansBudgetaires.setPlbUserCreat(this.usersLog.getUsrid());
         this.plansBudgetaires.setExercicesComptable(this.exoSelectionne);
         this.plansBudgetaires = this.plansBudgetairesDao.insert(this.plansBudgetaires);
         this.lesPlansBudgetaires.add(this.plansBudgetaires);
         this.dataModelLesPlansBudgetaires.setWrappedData(this.lesPlansBudgetaires);
      } else {
         this.plansBudgetaires.setPlbDateModif(new Date());
         this.plansBudgetaires.setPlbUserModif(this.usersLog.getUsrid());
         this.plansBudgetaires = this.plansBudgetairesDao.modif(this.plansBudgetaires);
      }

      if (this.plansBudgetaires.getPlbType() == 15 && this.plansBudgetaires.getPlbEntite() != null && !this.plansBudgetaires.getPlbEntite().isEmpty()) {
         String var12 = this.plansBudgetaires.getPlbEntite();
         Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlansBudgetaires");
         Transaction var4 = null;

         try {
            var4 = var3.beginTransaction();
            new PlansBudgetaires();

            for(int var6 = 0; var6 < this.lesPlansBudgetaires.size(); ++var6) {
               PlansBudgetaires var5 = (PlansBudgetaires)this.lesPlansBudgetaires.get(var6);
               if (var5.getPlbEntite() == null || var5.getPlbEntite().isEmpty()) {
                  var5.setPlbEntite(var12);
                  this.plansBudgetairesDao.modif(var5, var3);
               }
            }

            var4.commit();
         } catch (HibernateException var10) {
            if (var4 != null) {
               var4.rollback();
            }

            throw var10;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.recherche();
      }

      this.showModalPanelPlan = false;
   }

   public void verifCode() throws HibernateException, NamingException {
      this.existCod = false;
      this.existCod = this.plansBudgetairesDao.existCode(this.choixBudget, this.plansBudgetaires.getPlbCode(), this.var_nature, this.exoSelectionne.getExecpt_id(), (Session)null);
   }

   public boolean verifMouvment() throws HibernateException, NamingException {
      String var4 = this.plansBudgetaires.getPlbCode();
      int var5 = this.plansBudgetaires.getPlbInactif();
      boolean var2 = this.ecrituresAnalytiquesDao.verifMouvmentBud(var4);
      boolean var1;
      if (var2 && var5 != 2 && this.lastExercice.getExecpt_id() == this.exoSelectionne.getExecpt_id()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void listeBudget() throws HibernateException, NamingException {
      this.lesBudgets.clear();
      this.lesBudgets = this.projetsDao.selectAllProjets(this.choixBudget, (Session)null);
      this.dataModelListeBudget.setWrappedData(this.lesBudgets);
      this.showModalPanelBudget = true;
      this.afficheBudget = false;
   }

   public void fermerBudget() {
      this.showModalPanelBudget = false;
   }

   public void selectionBudget() {
      if (this.dataModelListeBudget.isRowAvailable()) {
         this.projets = (Projets)this.dataModelListeBudget.getRowData();
         this.afficheBudget = true;
      }

   }

   public void ajouterBuget() {
      this.projets = new Projets();
      this.showModalPanelBudgetFiche = true;
   }

   public void modifierBudget() {
      if (this.projets != null) {
         this.showModalPanelBudgetFiche = true;
      }

   }

   public void supprimerBudget() throws HibernateException, NamingException {
      if (this.projets != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlansBudgetaires");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            new ArrayList();
            List var3 = this.plansBudgetairesDao.chargerLesPlansBudgetaires(this.exoSelectionne, this.choixBudget, this.var_nature, this.var_annee, var1);
            if (var3.size() != 0) {
               new PlansBudgetaires();

               for(int var5 = 0; var5 < var3.size(); ++var5) {
                  PlansBudgetaires var4 = (PlansBudgetaires)var3.get(var5);
                  this.plansBudgetairesDao.delete(var4, var1);
               }
            }

            this.projetsDao.delete(this.projets, var1);
            this.lesBudgets.remove(this.projets);
            this.dataModelListeBudget.setWrappedData(this.lesBudgets);
            this.afficheBudget = false;
            this.projets = null;
            var2.commit();
         } catch (HibernateException var9) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.calculAnnee((Session)null);
      }

   }

   public void annulerBudget() {
      this.afficheBudget = false;
      this.showModalPanelBudgetFiche = false;
   }

   public void saveBudget() throws HibernateException, NamingException {
      this.projets.setProCode(this.projets.getProCode().toUpperCase());
      this.projets.setProNomFR(this.projets.getProNomFR().toUpperCase());
      this.projets.setProChoixBudget(this.choixBudget);
      if (this.projets.getProId() == 0L) {
         this.projets = this.projetsDao.insert(this.projets);
         this.lesBudgets.add(this.projets);
         this.dataModelListeBudget.setWrappedData(this.lesBudgets);
      } else {
         this.projets = this.projetsDao.miseAjourProjet(this.projets);
      }

      this.showModalPanelBudgetFiche = false;
      this.calculAnnee((Session)null);
   }

   public void verifCodeBudget() throws HibernateException, NamingException {
      this.existBudget = false;
      this.existBudget = this.projetsDao.existCode(this.choixBudget, this.projets.getProCode());
   }

   public void duppliquerPlanBud() {
   }

   public void validerDuppliquer() throws HibernateException, NamingException {
      new ArrayList();
      List var1 = this.plansBudgetairesDao.chargerLesPlansBudgetairesAnnee(this.choixBudget, this.var_annee, (Session)null);
      if (var1.size() != 0) {
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlansBudgetaires");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            new PlansBudgetaires();
            int var5 = 0;

            while(true) {
               if (var5 >= var1.size()) {
                  var3.commit();
                  break;
               }

               PlansBudgetaires var4 = (PlansBudgetaires)var1.get(var5);
               PlansBudgetaires var6 = new PlansBudgetaires();
               var6.setExercicesComptable(this.exoSelectionne);
               var6.setPlbActivite(var4.getPlbActivite());
               var6.setPlbAnnee(this.var_anneeDestination);
               var6.setPlbBloque(var4.getPlbBloque());
               var6.setPlbCode(var4.getPlbCode());
               var6.setPlbDateCreat(new Date());
               var6.setPlbDateModif((Date)null);
               var6.setPlbInactif(var4.getPlbInactif());
               var6.setPlbLibelleFr(var4.getPlbLibelleFr());
               var6.setPlbLibelleSp(var4.getPlbLibelleSp());
               var6.setPlbLibelleUk(var4.getPlbLibelleUk());
               var6.setPlbChoixBudget(var4.getPlbChoixBudget());
               var6.setPlbNature(var4.getPlbNature());
               var6.setPlbOrdre(var4.getPlbOrdre());
               var6.setPlbProjet(var4.getPlbProjet());
               var6.setPlbType(var4.getPlbType());
               var6.setPlbUserCreat(this.usersLog.getUsrid());
               var6.setPlbUserModif(0L);
               this.plansBudgetairesDao.insert(var6, var2);
               ++var5;
            }
         } catch (HibernateException var21) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var21;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         new ArrayList();
         List var23 = this.planBudgetaireCompteDao.chargerLesComptesAnnee((String)this.var_annee, this.choixBudget, (Session)null);
         if (var23.size() != 0) {
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlansBudgetaires");
            Transaction var24 = null;

            try {
               var24 = var2.beginTransaction();
               new PlanBudgetaireCompte();
               new PlansBudgetaires();

               for(int var8 = 0; var8 < var23.size(); ++var8) {
                  PlanBudgetaireCompte var25 = (PlanBudgetaireCompte)var23.get(var8);
                  PlanBudgetaireCompte var9 = new PlanBudgetaireCompte();
                  PlansBudgetaires var7 = this.plansBudgetairesDao.rechercheCode(this.choixBudget, var25.getPlbcptCode(), var25.getPlbcptNature(), this.var_anneeDestination, var2);
                  if (var7 != null) {
                     var9.setPlanbudgetaire(var7);
                     var9.setPlbcptCode(var25.getPlbcptCode());
                     var9.setPlbcptCompte(var25.getPlbcptCompte());
                     var9.setPlbcptLibelleFr(var25.getPlbcptLibelleFr());
                     var9.setPlbcptLibelleSp(var25.getPlbcptLibelleSp());
                     var9.setPlbcptLibelleUk(var25.getPlbcptLibelleUk());
                     var9.setPlbcptNature(var25.getPlbcptNature());
                     var9.setPlbcptChoixBudget(var25.getPlbcptChoixBudget());
                     var9.setPlbcptType(var25.getPlbcptType());
                     this.planBudgetaireCompteDao.insert(var9, var2);
                  }
               }

               var24.commit();
            } catch (HibernateException var19) {
               if (var24 != null) {
                  var24.rollback();
               }

               throw var19;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

   }

   public void verifDuppliquer() {
      if (this.var_anneeDestination != null && !this.var_anneeDestination.isEmpty()) {
         if (!this.var_annee.equals(this.var_anneeDestination)) {
            this.valideDupplication = true;
         } else {
            this.valideDupplication = false;
         }
      } else {
         this.valideDupplication = false;
      }

   }

   public void recupererPlanBudgetProduit() {
      if (this.dataModelPlbPlansProduits.isRowAvailable()) {
         this.planBudgetaireProduit = (PlanBudgetaireCompte)this.dataModelPlbPlansProduits.getRowData();
         this.testplbProdesup = true;
      }

   }

   public void ajouterProdVte() throws HibernateException, NamingException {
      this.produits = new Produits();
      this.planBudgetaireProduit = new PlanBudgetaireCompte();
      this.lesProduits = new ArrayList();
      this.dataModelProduits = new ListDataModel();
      this.lesProduits = this.produitsVtesDao.selectAllProduits((Session)null);
      this.dataModelProduits.setWrappedData(this.lesProduits);
      if (this.lesplanBudgetaireProduit.size() != 0) {
         for(int var1 = 0; var1 < this.lesplanBudgetaireProduit.size(); ++var1) {
            new PlanBudgetaireCompte();
            PlanBudgetaireCompte var2 = (PlanBudgetaireCompte)this.lesplanBudgetaireProduit.get(var1);
            String var3 = var2.getPlbcptCompte();
            if (this.lesProduits.size() != 0) {
               for(int var4 = 0; var4 < this.lesProduits.size(); ++var4) {
                  new Produits();
                  Produits var5 = (Produits)this.lesProduits.get(var4);
                  String var6 = var5.getProCode();
                  if (var3.equalsIgnoreCase(var6)) {
                     this.lesProduits.remove(var5);
                  }
               }
            }
         }
      }

   }

   public void ajouterProdAch() throws HibernateException, NamingException {
      this.produits = new Produits();
      this.planBudgetaireProduit = new PlanBudgetaireCompte();
      this.lesProduits = new ArrayList();
      this.dataModelProduits = new ListDataModel();
      this.lesProduits = this.produitsAchsDao.chargerLesProduitsAchats((Session)null);
      this.dataModelProduits.setWrappedData(this.lesProduits);
      if (this.lesplanBudgetaireProduit.size() != 0) {
         for(int var1 = 0; var1 < this.lesplanBudgetaireProduit.size(); ++var1) {
            new PlanBudgetaireCompte();
            PlanBudgetaireCompte var2 = (PlanBudgetaireCompte)this.lesplanBudgetaireProduit.get(var1);
            String var3 = var2.getPlbcptCompte();
            if (this.lesProduits.size() != 0) {
               for(int var4 = 0; var4 < this.lesProduits.size(); ++var4) {
                  new Produits();
                  Produits var5 = (Produits)this.lesProduits.get(var4);
                  String var6 = var5.getProCode();
                  if (var3.equalsIgnoreCase(var6)) {
                     this.lesProduits.remove(var5);
                  }
               }
            }
         }
      }

   }

   public void ajouterProdPrd() throws HibernateException, NamingException {
      this.produits = new Produits();
      this.planBudgetaireProduit = new PlanBudgetaireCompte();
      this.lesProduits = new ArrayList();
      this.dataModelProduits = new ListDataModel();
      this.lesProduits = this.produitsAchsDao.chargerLesProduitsProd((Session)null);
      this.dataModelProduits.setWrappedData(this.lesProduits);
      if (this.lesplanBudgetaireProduit.size() != 0) {
         for(int var1 = 0; var1 < this.lesplanBudgetaireProduit.size(); ++var1) {
            new PlanBudgetaireCompte();
            PlanBudgetaireCompte var2 = (PlanBudgetaireCompte)this.lesplanBudgetaireProduit.get(var1);
            String var3 = var2.getPlbcptCompte();
            if (this.lesProduits.size() != 0) {
               for(int var4 = 0; var4 < this.lesProduits.size(); ++var4) {
                  new Produits();
                  Produits var5 = (Produits)this.lesProduits.get(var4);
                  String var6 = var5.getProCode();
                  if (var3.equalsIgnoreCase(var6)) {
                     this.lesProduits.remove(var5);
                  }
               }
            }
         }
      }

   }

   public void selectionProduit() {
      if (this.dataModelProduits.isRowAvailable()) {
         this.produits = (Produits)this.dataModelProduits.getRowData();
         this.testplbProdesup = true;
      }

   }

   public void validerProduit() throws HibernateException, NamingException {
      if (this.lesProduits.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlansBudgetaires");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.planBudgetaireCompteDao.insertlesPlanBudgetProduits(this.lesProduits, this.plansBudgetaires, this.choixBudget, var1);
            this.lesPlansComptables.clear();
            int var3 = 0;

            while(true) {
               if (var3 >= this.lesProduits.size()) {
                  this.planBudgetaireCompteDao.insertlesPlanBudgetComptes(this.lesPlansComptables, this.plansBudgetaires, this.choixBudget, var1);
                  var2.commit();
                  break;
               }

               new Produits();
               Produits var4 = (Produits)this.lesProduits.get(var3);
               if (var4.isVar_select()) {
                  boolean var5;
                  if (this.var_aff_nature != 2 && this.choixBudget != 1) {
                     if (this.var_aff_nature == 1) {
                        if (var4.getProVteCpteLoc() != null && !var4.getProVteCpteLoc().isEmpty()) {
                           var5 = this.verifCompteNonUtilise(var4.getProVteCpteLoc());
                           if (!var5) {
                              this.planComptable = new PlanComptable();
                              this.planComptable = this.planComptableDao.trouveCompte(this.selecFiscalite, this.exoSelectionne.getExecpt_id(), var4.getProVteCpteLoc(), var1);
                              if (this.planComptable != null) {
                                 this.planComptable.setVar_select(true);
                                 this.lesPlansComptables.add(this.planComptable);
                              }
                           }
                        }

                        if (var4.getProVteCpteZ() != null && !var4.getProVteCpteZ().isEmpty()) {
                           var5 = this.verifCompteNonUtilise(var4.getProVteCpteZ());
                           if (!var5) {
                              this.planComptable = new PlanComptable();
                              this.planComptable = this.planComptableDao.trouveCompte(this.selecFiscalite, this.exoSelectionne.getExecpt_id(), var4.getProVteCpteZ(), var1);
                              if (this.planComptable != null) {
                                 this.planComptable.setVar_select(true);
                                 this.lesPlansComptables.add(this.planComptable);
                              }
                           }
                        }

                        if (var4.getProVteCpteHz() != null && !var4.getProVteCpteHz().isEmpty()) {
                           var5 = this.verifCompteNonUtilise(var4.getProVteCpteHz());
                           if (!var5) {
                              this.planComptable = new PlanComptable();
                              this.planComptable = this.planComptableDao.trouveCompte(this.selecFiscalite, this.exoSelectionne.getExecpt_id(), var4.getProVteCpteHz(), var1);
                              if (this.planComptable != null) {
                                 this.planComptable.setVar_select(true);
                                 this.lesPlansComptables.add(this.planComptable);
                              }
                           }
                        }
                     }
                  } else {
                     if (var4.getProAchCpteLoc() != null && !var4.getProAchCpteLoc().isEmpty()) {
                        var5 = this.verifCompteNonUtilise(var4.getProAchCpteLoc());
                        if (!var5) {
                           this.planComptable = new PlanComptable();
                           this.planComptable = this.planComptableDao.trouveCompte(this.selecFiscalite, this.exoSelectionne.getExecpt_id(), var4.getProAchCpteLoc(), var1);
                           if (this.planComptable != null) {
                              this.planComptable.setVar_select(true);
                              this.lesPlansComptables.add(this.planComptable);
                           }
                        }
                     }

                     if (var4.getProAchCpteZ() != null && !var4.getProAchCpteZ().isEmpty()) {
                        var5 = this.verifCompteNonUtilise(var4.getProAchCpteZ());
                        if (!var5) {
                           this.planComptable = new PlanComptable();
                           this.planComptable = this.planComptableDao.trouveCompte(this.selecFiscalite, this.exoSelectionne.getExecpt_id(), var4.getProAchCpteZ(), var1);
                           if (this.planComptable != null) {
                              this.planComptable.setVar_select(true);
                              this.lesPlansComptables.add(this.planComptable);
                           }
                        }
                     }

                     if (var4.getProAchCpteHz() != null && !var4.getProAchCpteHz().isEmpty()) {
                        var5 = this.verifCompteNonUtilise(var4.getProAchCpteHz());
                        if (!var5) {
                           this.planComptable = new PlanComptable();
                           this.planComptable = this.planComptableDao.trouveCompte(this.selecFiscalite, this.exoSelectionne.getExecpt_id(), var4.getProAchCpteHz(), var1);
                           if (this.planComptable != null) {
                              this.planComptable.setVar_select(true);
                              this.lesPlansComptables.add(this.planComptable);
                           }
                        }
                     }
                  }
               }

               ++var3;
            }
         } catch (HibernateException var9) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlansBudgetaires");
         this.lesplanBudgetaireProduit.clear();
         this.lesplanBudgetaireProduit = this.planBudgetaireCompteDao.chargerLesPlansBudgetaireCompte(this.idPlbEncours, 1, this.choixBudget, var1);
         this.dataModelPlbPlansProduits.setWrappedData(this.lesplanBudgetaireProduit);
         this.lesplanBudgetaireCompte.clear();
         this.lesplanBudgetaireCompte = this.planBudgetaireCompteDao.chargerLesPlansBudgetaireCompte(this.idPlbEncours, 0, this.choixBudget, var1);
         this.dataModelPlbPlansComptables.setWrappedData(this.lesplanBudgetaireCompte);
         this.utilInitHibernate.closeSession();
      }

      this.testplbProdesup = false;
   }

   public boolean verifCompteNonUtilise(String var1) {
      boolean var2 = false;
      int var3;
      if (this.lesPlansComptables.size() != 0) {
         for(var3 = 0; var3 < this.lesPlansComptables.size(); ++var3) {
            if (((PlanComptable)this.lesPlansComptables.get(var3)).getPlcCompte().equals(var1)) {
               var2 = true;
               break;
            }
         }
      }

      if (!var2 && this.lesplanBudgetaireCompte.size() != 0) {
         for(var3 = 0; var3 < this.lesplanBudgetaireCompte.size(); ++var3) {
            if (((PlanBudgetaireCompte)this.lesplanBudgetaireCompte.get(var3)).getPlbcptCompte().equals(var1)) {
               var2 = true;
               break;
            }
         }
      }

      return var2;
   }

   public void supprimerPlanBudgetProduit() throws HibernateException, NamingException {
      if (this.planBudgetaireProduit != null) {
         this.planBudgetaireCompteDao.delete(this.planBudgetaireProduit);
         this.lesplanBudgetaireProduit.clear();
         this.lesplanBudgetaireProduit = this.planBudgetaireCompteDao.chargerLesPlansBudgetaireCompte(this.idPlbEncours, 1, this.choixBudget, (Session)null);
         this.dataModelPlbPlansProduits.setWrappedData(this.lesplanBudgetaireProduit);
         this.testplbProdesup = false;
      }

   }

   public void recupererPlanBudgetCompte() {
      if (this.dataModelPlbPlansComptables.isRowAvailable()) {
         this.planBudgetaireCompte = (PlanBudgetaireCompte)this.dataModelPlbPlansComptables.getRowData();
         this.testplbCptesup = true;
      }

   }

   public void ajouterCompte() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanComptable");
      this.planComptable = new PlanComptable();
      this.lesPlansComptables.clear();
      this.lesPlansComptables = this.planComptableDao.chargerLesPlanscomptables(this.selecFiscalite, this.exoSelectionne.getExecpt_id(), var1);
      new ArrayList();
      int var3 = Integer.parseInt(this.var_nature);
      List var2 = this.planBudgetaireCompteDao.chargerLesComptesAnnee(this.var_annee, 0, var3, this.choixBudget, var1);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            new PlanBudgetaireCompte();
            PlanBudgetaireCompte var5 = (PlanBudgetaireCompte)var2.get(var4);
            String var6 = var5.getPlbcptCompte();
            if (this.lesPlansComptables.size() != 0) {
               for(int var7 = 0; var7 < this.lesPlansComptables.size(); ++var7) {
                  new PlanComptable();
                  PlanComptable var8 = (PlanComptable)this.lesPlansComptables.get(var7);
                  String var9 = var8.getPlcCompte();
                  if (var6.equalsIgnoreCase(var9)) {
                     this.lesPlansComptables.remove(var8);
                  }
               }
            }
         }
      }

      this.dataModelPlbCompte.setWrappedData(this.lesPlansComptables);
      this.utilInitHibernate.closeSession();
   }

   public void selectionCompte() {
      if (this.dataModelPlbCompte.isRowAvailable()) {
         this.planComptable = (PlanComptable)this.dataModelPlbCompte.getRowData();
         this.testplbCptesup = true;
      }

   }

   public void validerCompte() throws HibernateException, NamingException {
      if (this.lesPlansComptables.size() != 0) {
         this.planBudgetaireCompteDao.insertlesPlanBudgetComptes(this.lesPlansComptables, this.plansBudgetaires, this.choixBudget);
         this.lesplanBudgetaireCompte.clear();
         this.lesplanBudgetaireCompte = this.planBudgetaireCompteDao.chargerLesPlansBudgetaireCompte(this.idPlbEncours, 0, this.choixBudget, (Session)null);
         this.dataModelPlbPlansComptables.setWrappedData(this.lesplanBudgetaireCompte);
      }

      this.testplbCptesup = false;
   }

   public void supprimerPlanBudgetCompte() throws HibernateException, NamingException {
      if (this.planBudgetaireCompte != null) {
         this.planBudgetaireCompteDao.delete(this.planBudgetaireCompte);
         this.lesplanBudgetaireCompte.clear();
         this.lesplanBudgetaireCompte = this.planBudgetaireCompteDao.chargerLesPlansBudgetaireCompte(this.idPlbEncours, 0, this.choixBudget, (Session)null);
         this.dataModelPlbPlansComptables.setWrappedData(this.lesplanBudgetaireCompte);
         this.testplbCptesup = false;
      }

   }

   public long getIdPlbEncours() {
      return this.idPlbEncours;
   }

   public void setIdPlbEncours(long var1) {
      this.idPlbEncours = var1;
   }

   public long getIdPlbCpte() {
      return this.idPlbCpte;
   }

   public void setIdPlbCpte(long var1) {
      this.idPlbCpte = var1;
   }

   public boolean isExistCod() {
      return this.existCod;
   }

   public void setExistCod(boolean var1) {
      this.existCod = var1;
   }

   public List getLesPlansComptables() {
      return this.lesPlansComptables;
   }

   public void setLesPlansComptables(List var1) {
      this.lesPlansComptables = var1;
   }

   public PlanComptable getPlanComptable() {
      return this.planComptable;
   }

   public void setPlanComptable(PlanComptable var1) {
      this.planComptable = var1;
   }

   public ExercicesComptable getExoSelectionne() {
      return this.exoSelectionne;
   }

   public void setExoSelectionne(ExercicesComptable var1) {
      this.exoSelectionne = var1;
   }

   public ExercicesComptable getLastExercice() {
      return this.lastExercice;
   }

   public void setLastExercice(ExercicesComptable var1) {
      this.lastExercice = var1;
   }

   public void setPlansBudgetaires(PlansBudgetaires var1) {
      this.plansBudgetaires = var1;
   }

   public DataModel getDataModelLesPlansBudgetaires() {
      return this.dataModelLesPlansBudgetaires;
   }

   public void setDataModelLesPlansBudgetaires(DataModel var1) {
      this.dataModelLesPlansBudgetaires = var1;
   }

   public DataModel getDataModelPlbCompte() {
      return this.dataModelPlbCompte;
   }

   public void setDataModelPlbCompte(DataModel var1) {
      this.dataModelPlbCompte = var1;
   }

   public PlanBudgetaireCompte getPlanBudgetaireCompte() {
      return this.planBudgetaireCompte;
   }

   public void setPlanBudgetaireCompte(PlanBudgetaireCompte var1) {
      this.planBudgetaireCompte = var1;
   }

   public DataModel getDataModelPlbPlansComptables() {
      return this.dataModelPlbPlansComptables;
   }

   public void setDataModelPlbPlansComptables(DataModel var1) {
      this.dataModelPlbPlansComptables = var1;
   }

   public boolean isTestplbCptesup() {
      return this.testplbCptesup;
   }

   public void setTestplbCptesup(boolean var1) {
      this.testplbCptesup = var1;
   }

   public long getIdPlbPrec() {
      return this.idPlbPrec;
   }

   public void setIdPlbPrec(long var1) {
      this.idPlbPrec = var1;
   }

   public int getPlbOrdreEncours() {
      return this.plbOrdreEncours;
   }

   public void setPlbOrdreEncours(int var1) {
      this.plbOrdreEncours = var1;
   }

   public int getPlbOrdrePrecedent() {
      return this.plbOrdrePrecedent;
   }

   public void setPlbOrdrePrecedent(int var1) {
      this.plbOrdrePrecedent = var1;
   }

   public int getPlbIndex() {
      return this.plbIndex;
   }

   public void setPlbIndex(int var1) {
      this.plbIndex = var1;
   }

   public long getIdPlbSuiv() {
      return this.idPlbSuiv;
   }

   public void setIdPlbSuiv(long var1) {
      this.idPlbSuiv = var1;
   }

   public int getPlbOrdreSuivant() {
      return this.plbOrdreSuivant;
   }

   public void setPlbOrdreSuivant(int var1) {
      this.plbOrdreSuivant = var1;
   }

   public int getOrdre() {
      return this.ordre;
   }

   public void setOrdre(int var1) {
      this.ordre = var1;
   }

   public boolean isShowButtonModif() {
      return this.showButtonModif;
   }

   public void setShowButtonModif(boolean var1) {
      this.showButtonModif = var1;
   }

   public boolean isShowButtonSupp() {
      return this.showButtonSupp;
   }

   public void setShowButtonSupp(boolean var1) {
      this.showButtonSupp = var1;
   }

   public List getMesActivitesItems() {
      return this.mesActivitesItems;
   }

   public void setMesActivitesItems(List var1) {
      this.mesActivitesItems = var1;
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

   public PlansBudgetaires getPlansBudgetaires() {
      return this.plansBudgetaires;
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

   public boolean isShowOngletCompte() {
      return this.showOngletCompte;
   }

   public void setShowOngletCompte(boolean var1) {
      this.showOngletCompte = var1;
   }

   public boolean isShowModalPanelPlan() {
      return this.showModalPanelPlan;
   }

   public void setShowModalPanelPlan(boolean var1) {
      this.showModalPanelPlan = var1;
   }

   public boolean isInactifPlb() {
      return this.inactifPlb;
   }

   public void setInactifPlb(boolean var1) {
      this.inactifPlb = var1;
   }

   public int getVar_aff_nature() {
      return this.var_aff_nature;
   }

   public void setVar_aff_nature(int var1) {
      this.var_aff_nature = var1;
   }

   public DataModel getDataModelProduits() {
      return this.dataModelProduits;
   }

   public void setDataModelProduits(DataModel var1) {
      this.dataModelProduits = var1;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public DataModel getDataModelPlbPlansProduits() {
      return this.dataModelPlbPlansProduits;
   }

   public void setDataModelPlbPlansProduits(DataModel var1) {
      this.dataModelPlbPlansProduits = var1;
   }

   public boolean isTestplbProdesup() {
      return this.testplbProdesup;
   }

   public void setTestplbProdesup(boolean var1) {
      this.testplbProdesup = var1;
   }

   public PlanBudgetaireCompte getPlanBudgetaireProduit() {
      return this.planBudgetaireProduit;
   }

   public void setPlanBudgetaireProduit(PlanBudgetaireCompte var1) {
      this.planBudgetaireProduit = var1;
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

   public String getEntete() {
      return this.entete;
   }

   public void setEntete(String var1) {
      this.entete = var1;
   }

   public String getFiltre() {
      return this.filtre;
   }

   public void setFiltre(String var1) {
      this.filtre = var1;
   }

   public String getRequete() {
      return this.requete;
   }

   public void setRequete(String var1) {
      this.requete = var1;
   }

   public String getVar_anneeDestination() {
      return this.var_anneeDestination;
   }

   public void setVar_anneeDestination(String var1) {
      this.var_anneeDestination = var1;
   }

   public boolean isValideDupplication() {
      return this.valideDupplication;
   }

   public void setValideDupplication(boolean var1) {
      this.valideDupplication = var1;
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

   public boolean isModuleProjet() {
      return this.moduleProjet;
   }

   public void setModuleProjet(boolean var1) {
      this.moduleProjet = var1;
   }

   public DataModel getDataModelListeBudget() {
      return this.dataModelListeBudget;
   }

   public void setDataModelListeBudget(DataModel var1) {
      this.dataModelListeBudget = var1;
   }

   public Projets getProjets() {
      return this.projets;
   }

   public void setProjets(Projets var1) {
      this.projets = var1;
   }

   public boolean isShowModalPanelBudget() {
      return this.showModalPanelBudget;
   }

   public void setShowModalPanelBudget(boolean var1) {
      this.showModalPanelBudget = var1;
   }

   public boolean isShowModalPanelBudgetFiche() {
      return this.showModalPanelBudgetFiche;
   }

   public void setShowModalPanelBudgetFiche(boolean var1) {
      this.showModalPanelBudgetFiche = var1;
   }

   public boolean isAfficheBudget() {
      return this.afficheBudget;
   }

   public void setAfficheBudget(boolean var1) {
      this.afficheBudget = var1;
   }

   public boolean isExistBudget() {
      return this.existBudget;
   }

   public void setExistBudget(boolean var1) {
      this.existBudget = var1;
   }

   public List getMesEntitestems() {
      return this.mesEntitestems;
   }

   public void setMesEntitestems(List var1) {
      this.mesEntitestems = var1;
   }

   public int getChoixBudget() {
      return this.choixBudget;
   }

   public void setChoixBudget(int var1) {
      this.choixBudget = var1;
   }
}
