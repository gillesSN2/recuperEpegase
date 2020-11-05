package com.epegase.forms.administration;

import com.epegase.systeme.classe.Activites;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.Devise;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlanAnalytiqueRepartition;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.PointDeVente;
import com.epegase.systeme.classe.ProductionAtelier;
import com.epegase.systeme.classe.ProductionLigne;
import com.epegase.systeme.classe.Projets;
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.StructurePeg;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.DeviseDao;
import com.epegase.systeme.dao.EcrituresAnalytiquesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PlanAnalytiqueRepartitionDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.ProductionAtelierDao;
import com.epegase.systeme.dao.ProductionLigneDao;
import com.epegase.systeme.dao.ProjetsDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LectureDevises;
import com.epegase.systeme.xml.ObjetDevises;
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

public class FormPlansAnalytiques implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String pageIndex;
   private ExercicesComptable lastExercice;
   private ExercicesComptable exoSelectionne;
   private PlansAnalytiques plansAnalytiques = new PlansAnalytiques();
   private List lesPlansAnalytiques = new ArrayList();
   private transient DataModel dataModelLesPlansAnalytiques = new ListDataModel();
   private boolean existCod = true;
   private boolean inactifPlb = false;
   private boolean showButtonSupp = false;
   private boolean showButtonModif = false;
   private boolean showButtonPanel = false;
   private boolean showOngletCompte = false;
   private boolean showModalPanelPlan = false;
   private long idPlbEncours;
   private boolean testMode;
   private int ordre;
   private ExercicesComptableDao exercicesComptableDao;
   private EcrituresAnalytiquesDao ecrituresAnalytiquesDao;
   private EcrituresDao ecrituresDao;
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
   private int affiche_dossier = 0;
   private boolean affiche_parc = false;
   private boolean affiche_agent = false;
   private boolean affiche_chantier = false;
   private boolean affiche_mission = false;
   private boolean affiche_str = false;
   private boolean moduleParc = false;
   private boolean modulePaye = false;
   private boolean moduleUsine = false;
   private boolean moduleProjet = false;
   private String var_annee;
   private List mesAnneeItems;
   private String var_nature;
   private String var_libelle;
   private List mesAnneeSelectionneeItems;
   private String var_annee_selectionnee;
   private PlansAnalytiquesDao plansAnalytiquesDao;
   private ActivitesDao activitesDao;
   private ParcDao parcDao;
   private PlanAnalytiqueRepartitionDao planAnalytiqueRepartitionDao;
   private PlanAnalytiqueRepartition planAnalytiqueRepartition;
   private List lesPlanAnalytiqueRepartitions = new ArrayList();
   private transient DataModel dataModelRepartition = new ListDataModel();
   private boolean testplbCptesup = false;
   private boolean showModalPanelRepartition = false;
   private int natureRepartition;
   private List lesActivites = new ArrayList();
   private List lesParcs = new ArrayList();
   private List lesDossiers = new ArrayList();
   private List lesMissions = new ArrayList();
   private List lesChantiers = new ArrayList();
   private List lesAgents = new ArrayList();
   private SalariesDao salariesDao;
   private List lesSitDepSer = new ArrayList();
   private List lesRegSecPdv = new ArrayList();
   private List lesSitLigAte = new ArrayList();
   private boolean mode_calcul = false;
   private List mesAxesAnalytique = new ArrayList();
   private Projets projets;
   private ProjetsDao projetsDao;
   private List lesProjets = new ArrayList();
   private boolean showModalPanelActivite = false;
   private String filtre;
   private String requete;
   private List mesdevisesItems = new ArrayList();
   private List lesStructures = new ArrayList();
   private double totRepartition;

   public void InstancesDaoUtilses() {
      this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.activitesDao = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      this.exercicesComptableDao = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresDao = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      this.ecrituresAnalytiquesDao = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.planAnalytiqueRepartitionDao = new PlanAnalytiqueRepartitionDao(this.baseLog, this.utilInitHibernate);
      this.parcDao = new ParcDao(this.baseLog, this.utilInitHibernate);
      this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
      this.projetsDao = new ProjetsDao(this.baseLog, this.utilInitHibernate);
   }

   public void calculAnnee() {
      int var1 = this.exoSelectionne.getExecptDateDebut().getYear() + 1900;
      int var2 = this.exoSelectionne.getExecptDateFin().getYear() + 1900;
      this.mesAnneeItems = new ArrayList();
      String var3 = "";

      for(int var4 = var1; var4 <= var2; ++var4) {
         var3 = "" + var4;
         this.mesAnneeItems.add(new SelectItem(var3));
      }

      this.mesAnneeSelectionneeItems = this.mesAnneeItems;
   }

   public void recupererAxesAnalytiques() {
      this.mesAxesAnalytique.clear();
      if (this.structureLog.isStrSite()) {
         this.mesAxesAnalytique.add(new SelectItem(100, "Sites-Départements-Services"));
      }

      if (this.structureLog.isStrRegion()) {
         this.mesAxesAnalytique.add(new SelectItem(101, "Régions-Secteurs-Points de vente"));
      }

      if (this.structureLog.getStrtypeentreprise().equals("2")) {
         this.moduleUsine = true;
         if (this.structureLog.isStrUsine()) {
            this.mesAxesAnalytique.add(new SelectItem(102, "Sites-Ateliers-Lignes"));
         }
      }

      if (this.structureLog.isStrActivite()) {
         this.mesAxesAnalytique.add(new SelectItem(110, "Activités"));
      }

      if (this.rechercheModule(70000)) {
         this.moduleParc = true;
         if (this.structureLog.isStrParc()) {
            this.mesAxesAnalytique.add(new SelectItem(120, "Parcs"));
         }
      }

      if (this.structureLog.getStrDossier() != 0) {
         this.mesAxesAnalytique.add(new SelectItem(6, "Dossiers/Affaires"));
      }

      if (this.rechercheModule(50000)) {
         this.modulePaye = true;
         if (this.structureLog.isStrAgent()) {
            this.mesAxesAnalytique.add(new SelectItem(122, "Agents"));
         }
      }

      if (this.structureLog.isStrChantier()) {
         this.mesAxesAnalytique.add(new SelectItem(7, "Chantiers"));
      }

      if (this.structureLog.isStrMission()) {
         this.mesAxesAnalytique.add(new SelectItem(8, "Missions/Frais"));
      }

      if (this.rechercheModule(40300)) {
         this.moduleProjet = true;
         if (this.structureLog.isStrProjet()) {
            this.mesAxesAnalytique.add(new SelectItem(130, "Projets"));
         }
      }

      if (this.structureLog.isStrCles()) {
         this.mesAxesAnalytique.add(new SelectItem(9, "Clés répartitions"));
      }

      if (this.structureLog.isStrStructure()) {
         this.mesAxesAnalytique.add(new SelectItem(200, "Clés répartitions structure"));
         this.mesAxesAnalytique.add(new SelectItem(201, "Axes structure"));
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

   public void listeDevise(Session var1) throws HibernateException, NamingException {
      this.mesdevisesItems.clear();
      DeviseDao var2 = new DeviseDao(this.baseLog, this.utilInitHibernate);
      this.mesdevisesItems = var2.chargerLesDevisesUtiliseesItem(this.structureLog, var1);
   }

   public void recupererClesStructure() throws HibernateException, NamingException {
      this.lesPlansAnalytiques.clear();
      this.lesPlansAnalytiques = this.plansAnalytiquesDao.chargerLesPlansAnalytiques("9", (Session)null);
      this.dataModelLesPlansAnalytiques.setWrappedData(this.lesPlansAnalytiques);
   }

   public void buttonPanel() throws HibernateException, NamingException {
      this.showButtonPanel = false;
      this.showModalPanelRepartition = false;
      this.showModalPanelPlan = false;
      this.mode_calcul = false;
      this.lesPlansAnalytiques.clear();
      this.dataModelLesPlansAnalytiques.setWrappedData(this.lesPlansAnalytiques);
      if (this.var_annee.length() == 4 && !this.var_nature.equalsIgnoreCase("0")) {
         if (!this.var_nature.equals("6") && !this.var_nature.equals("7") && !this.var_nature.equals("8") && !this.var_nature.equals("9")) {
            this.showButtonPanel = false;
         } else {
            this.showButtonPanel = true;
         }
      } else {
         this.showButtonPanel = false;
      }

      this.showButtonModif = false;
      this.showButtonSupp = false;
      this.recherche();
   }

   public void saveStructure() throws HibernateException, NamingException {
      StructureDao var1 = new StructureDao(this.baseLog, this.utilInitHibernate);
      var1.modStructure(this.structureLog);
   }

   public void recherche() throws HibernateException, NamingException {
      this.lesPlansAnalytiques.clear();
      if (this.var_annee.length() != 4) {
         this.var_annee = "";
      }

      int var1;
      PlansAnalytiques var2;
      if (this.var_nature.equals("110")) {
         this.lesActivites = this.activitesDao.selectActivites((Session)null);
         if (this.lesActivites.size() != 0) {
            for(var1 = 0; var1 < this.lesActivites.size(); ++var1) {
               var2 = new PlansAnalytiques();
               var2.setAnaId(((Activites)this.lesActivites.get(var1)).getActId());
               var2.setAnaAnneeDebut(((Activites)this.lesActivites.get(var1)).getActAnneeDebut());
               var2.setAnaAnneeFin(((Activites)this.lesActivites.get(var1)).getActAnneeFin());
               var2.setAnaCode(((Activites)this.lesActivites.get(var1)).getActCode());
               var2.setAnaNomFr(((Activites)this.lesActivites.get(var1)).getActNomFr());
               var2.setAnaNature(((Activites)this.lesActivites.get(var1)).getActColonne());
               var2.setAnaVte(((Activites)this.lesActivites.get(var1)).isActVte());
               var2.setAnaAch(((Activites)this.lesActivites.get(var1)).isActAch());
               var2.setAnaPrd(((Activites)this.lesActivites.get(var1)).isActPrd());
               var2.setAnaFrg(((Activites)this.lesActivites.get(var1)).isActFrg());
               var2.setAnaInv(((Activites)this.lesActivites.get(var1)).isActInv());
               var2.setAnaTva(((Activites)this.lesActivites.get(var1)).isActTva());
               var2.setAnaTax(((Activites)this.lesActivites.get(var1)).isActTax());
               var2.setAnaSal(((Activites)this.lesActivites.get(var1)).isActSal());
               var2.setAnaInactif(((Activites)this.lesActivites.get(var1)).getActInactif());
               this.lesPlansAnalytiques.add(var2);
            }
         }
      } else if (this.var_nature.equals("120")) {
         this.lesParcs = this.parcDao.selectLesParcs((Session)null);
         if (this.lesParcs.size() != 0) {
            for(var1 = 0; var1 < this.lesParcs.size(); ++var1) {
               var2 = new PlansAnalytiques();
               var2.setAnaId(((Parc)this.lesParcs.get(var1)).getPrcId());
               var2.setAnaAnneeDebut(0);
               var2.setAnaAnneeFin(0);
               var2.setAnaCode(((Parc)this.lesParcs.get(var1)).getPrcImmatriculation());
               var2.setAnaNomFr(((Parc)this.lesParcs.get(var1)).getPrcLibFamille() + " " + ((Parc)this.lesParcs.get(var1)).getPrcMarque());
               var2.setAnaVte(false);
               var2.setAnaAch(false);
               var2.setAnaPrd(false);
               var2.setAnaFrg(false);
               var2.setAnaInv(false);
               var2.setAnaTva(false);
               var2.setAnaTax(false);
               var2.setAnaSal(false);
               var2.setAnaInactif(((Parc)this.lesParcs.get(var1)).getPrcInactif());
               this.lesPlansAnalytiques.add(var2);
            }
         }
      } else if (!this.var_nature.equals("100") && !this.var_nature.equals("101") && !this.var_nature.equals("102")) {
         if (this.var_nature.equals("122")) {
            this.lesAgents = this.salariesDao.chargerlesSalariesActif((Session)null);
            if (this.lesAgents.size() != 0) {
               for(var1 = 0; var1 < this.lesAgents.size(); ++var1) {
                  var2 = new PlansAnalytiques();
                  var2.setAnaId(((Salaries)this.lesAgents.get(var1)).getSalId());
                  var2.setAnaAnneeDebut(0);
                  var2.setAnaAnneeFin(0);
                  var2.setAnaCode(((Salaries)this.lesAgents.get(var1)).getSalMatricule());
                  var2.setAnaNomFr(((Salaries)this.lesAgents.get(var1)).getPatronyme());
                  var2.setAnaVte(false);
                  var2.setAnaAch(false);
                  var2.setAnaPrd(false);
                  var2.setAnaFrg(false);
                  var2.setAnaInv(false);
                  var2.setAnaTva(false);
                  var2.setAnaTax(false);
                  var2.setAnaSal(false);
                  if (((Salaries)this.lesAgents.get(var1)).getSalEtat() <= 2) {
                     var2.setAnaInactif(1);
                  } else {
                     var2.setAnaInactif(0);
                  }

                  this.lesPlansAnalytiques.add(var2);
               }
            }
         } else if (this.var_nature.equals("130")) {
            this.lesProjets = this.projetsDao.selectAllProjets(0, (Session)null);
            if (this.lesProjets.size() != 0) {
               for(var1 = 0; var1 < this.lesProjets.size(); ++var1) {
                  var2 = new PlansAnalytiques();
                  var2.setAnaId(((Projets)this.lesProjets.get(var1)).getProId());
                  var2.setAnaAnneeDebut(0);
                  var2.setAnaAnneeFin(0);
                  var2.setAnaCode(((Projets)this.lesProjets.get(var1)).getProCode());
                  var2.setAnaNomFr(((Projets)this.lesProjets.get(var1)).getProNomFR());
                  var2.setAnaVte(false);
                  var2.setAnaAch(false);
                  var2.setAnaPrd(false);
                  var2.setAnaFrg(false);
                  var2.setAnaInv(false);
                  var2.setAnaTva(false);
                  var2.setAnaTax(false);
                  var2.setAnaSal(false);
                  var2.setAnaInactif(((Projets)this.lesProjets.get(var1)).getProInactif());
                  this.lesPlansAnalytiques.add(var2);
               }
            }
         } else if (this.var_nature.equals("200")) {
            this.lesPlansAnalytiques = this.plansAnalytiquesDao.chargerLesPlansAnalytiques(this.var_nature, this.var_annee, (Session)null);
         } else if (this.var_nature.equals("201")) {
            this.lesPlansAnalytiques = this.plansAnalytiquesDao.chargerLesPlansAnalytiques(this.var_nature, this.var_annee, (Session)null);
         } else {
            this.lesPlansAnalytiques = this.plansAnalytiquesDao.chargerLesPlansAnalytiques(this.var_nature, this.var_annee, (Session)null);
         }
      }

      this.dataModelLesPlansAnalytiques.setWrappedData(this.lesPlansAnalytiques);
   }

   public void selectionPlanAnalytique() throws HibernateException, NamingException {
      if (this.dataModelLesPlansAnalytiques.isRowAvailable()) {
         this.plansAnalytiques = (PlansAnalytiques)this.dataModelLesPlansAnalytiques.getRowData();
         this.idPlbEncours = this.plansAnalytiques.getAnaId();
         this.var_annee_selectionnee = this.plansAnalytiques.getAnaAnnee();
         if (this.plansAnalytiques.getAnaInactif() == 1) {
            this.inactifPlb = true;
         } else {
            this.inactifPlb = false;
         }

         this.lesPlanAnalytiqueRepartitions.clear();
         this.lesPlanAnalytiqueRepartitions = this.planAnalytiqueRepartitionDao.chargerLesRepartitions((PlansAnalytiques)this.plansAnalytiques, (Session)null);
         this.dataModelRepartition.setWrappedData(this.lesPlanAnalytiqueRepartitions);
         if (this.lesPlanAnalytiqueRepartitions.size() != 0) {
            this.miseEnFormeResultat();
            this.testplbCptesup = true;
         } else {
            this.testplbCptesup = false;
         }

         this.showButtonModif = true;
         if (this.plansAnalytiques.getAnaInactif() != 3) {
            this.showButtonSupp = true;
         } else {
            this.showButtonSupp = false;
         }

         if (this.var_nature.equalsIgnoreCase("6")) {
            this.filtre = "Plans analytiques : Dossiers";
         } else if (this.var_nature.equalsIgnoreCase("7")) {
            this.filtre = "Plans analytiques : Missions";
         } else if (this.var_nature.equalsIgnoreCase("8")) {
            this.filtre = "Plans analytiques : Parcs";
         } else if (this.var_nature.equalsIgnoreCase("9")) {
            this.filtre = "Plans analytiques : Clés de répartition";
         } else if (this.var_nature.equalsIgnoreCase("20")) {
            this.filtre = "Plans analytiques : Axe Structure";
         }

         if (this.plansAnalytiques.isAnaStr()) {
            this.showButtonModif = false;
            this.showButtonSupp = false;
         }
      }

   }

   public void ajouterPoste() {
      this.plansAnalytiques = new PlansAnalytiques();
      this.lesPlanAnalytiqueRepartitions.clear();
      this.natureRepartition = 0;
      this.idPlbEncours = 0L;
      this.existCod = true;
      this.testMode = false;
      this.initVariable();
      this.var_annee_selectionnee = null;
      this.showOngletCompte = false;
      if (this.var_nature.equals("100")) {
         this.showModalPanelActivite = true;
      } else {
         this.showModalPanelPlan = true;
      }

   }

   public void modifierPoste() {
      this.existCod = false;
      this.initVariable();
      if (this.var_nature.equals("100")) {
         this.showModalPanelActivite = true;
      } else {
         this.showOngletCompte = true;
         this.showModalPanelPlan = true;
      }

   }

   public void supprimerPoste() throws HibernateException, NamingException {
      if (this.var_nature.equals("100")) {
         new Activites();
         Activites var1 = this.activitesDao.rechercheActivite(this.plansAnalytiques.getAnaId(), (Session)null);
         if (var1 != null) {
            this.activitesDao.delete(var1);
         }
      } else {
         if (this.var_nature.equalsIgnoreCase("9")) {
            if (this.lesPlanAnalytiqueRepartitions.size() != 0) {
               this.planAnalytiqueRepartitionDao.deletelesRepartitions(this.lesPlanAnalytiqueRepartitions);
            }

            this.lesPlanAnalytiqueRepartitions.clear();
         }

         this.plansAnalytiquesDao.delete(this.plansAnalytiques);
      }

      this.recherche();
      this.showModalPanelActivite = false;
      this.showModalPanelPlan = false;
      this.showModalPanelRepartition = false;
   }

   public void annulerSaisie() {
      this.showModalPanelPlan = false;
      this.showModalPanelRepartition = false;
      this.showModalPanelActivite = false;
   }

   public void annulerActivite() {
      this.showModalPanelActivite = false;
   }

   public void savePlanAnalytique() throws HibernateException, NamingException {
      this.plansAnalytiques.setAnaAnnee(this.var_annee);
      if (this.plansAnalytiques.getAnaInactif() <= 1) {
         if (this.inactifPlb) {
            this.plansAnalytiques.setAnaInactif(1);
         } else {
            this.plansAnalytiques.setAnaInactif(0);
         }
      }

      if (this.var_annee_selectionnee != null && !this.var_annee_selectionnee.equals("0")) {
         this.plansAnalytiques.setAnaAnnee(this.var_annee_selectionnee);
      } else {
         this.plansAnalytiques.setAnaAnnee((String)null);
      }

      this.plansAnalytiques.setAnaNature(this.var_nature);
      this.plansAnalytiques.setAnaNatureRepartition(this.natureRepartition);
      this.plansAnalytiques.setAnaOrdre(this.getOrdre());
      if (this.plansAnalytiques.getAnaId() == 0L) {
         this.plansAnalytiques.setAnaDateCreat(new Date());
         this.plansAnalytiques.setAnaUserCreat(this.usersLog.getUsrid());
         this.plansAnalytiques = this.plansAnalytiquesDao.insert(this.plansAnalytiques);
         this.lesPlansAnalytiques.add(this.plansAnalytiques);
         this.dataModelLesPlansAnalytiques.setWrappedData(this.lesPlansAnalytiques);
      } else {
         this.plansAnalytiques.setAnaDateModif(new Date());
         this.plansAnalytiques.setAnaUserModif(this.usersLog.getUsrid());
         this.plansAnalytiques = this.plansAnalytiquesDao.modif(this.plansAnalytiques);
      }

      this.showModalPanelPlan = false;
   }

   public void verifCode() throws HibernateException, NamingException {
      this.existCod = false;
      this.existCod = this.plansAnalytiquesDao.existCode(this.var_nature, this.plansAnalytiques.getAnaCode(), (Session)null);
   }

   public boolean verifMouvment() throws HibernateException, NamingException {
      String var4 = this.plansAnalytiques.getAnaCode();
      int var5 = this.plansAnalytiques.getAnaInactif();
      boolean var2 = this.ecrituresAnalytiquesDao.verifMouvmentBud(var4);
      boolean var1;
      if (var2 && var5 != 2 && this.lastExercice.getExecpt_id() == this.exoSelectionne.getExecpt_id()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void razTab() {
      this.showButtonPanel = false;
      this.showModalPanelRepartition = false;
      this.showModalPanelPlan = false;
      this.mode_calcul = false;
      this.var_annee = "0";
      this.var_nature = "0";
      this.lesPlansAnalytiques.clear();
      this.dataModelLesPlansAnalytiques.setWrappedData(this.lesPlansAnalytiques);
   }

   public void savePlanActivite() throws HibernateException, NamingException {
      new Activites();
      Activites var1 = this.activitesDao.rechercheActivite(this.plansAnalytiques.getAnaId(), (Session)null);
      if (var1 != null) {
         if (var1.getActInactif() <= 1) {
            if (this.inactifPlb) {
               var1.setActInactif(1);
            } else {
               var1.setActInactif(0);
            }
         }

         var1.setActDateModif(new Date());
         var1.setActUserModif(this.usersLog.getUsrid());
         var1.setActAnneeDebut(this.plansAnalytiques.getAnaAnneeDebut());
         var1.setActAnneeFin(this.plansAnalytiques.getAnaAnneeFin());
         var1.setActCode(this.plansAnalytiques.getAnaCode());
         var1.setActNomFr(this.plansAnalytiques.getAnaNomFr());
         var1.setActVte(this.plansAnalytiques.isAnaVte());
         var1.setActAch(this.plansAnalytiques.isAnaAch());
         var1.setActPrd(this.plansAnalytiques.isAnaPrd());
         var1.setActFrg(this.plansAnalytiques.isAnaFrg());
         var1.setActInv(this.plansAnalytiques.isAnaInv());
         var1.setActTva(this.plansAnalytiques.isAnaTva());
         var1.setActTax(this.plansAnalytiques.isAnaTax());
         var1.setActSal(this.plansAnalytiques.isAnaSal());
         this.activitesDao.modif(var1);
      } else {
         var1 = new Activites();
         if (var1.getActInactif() <= 1) {
            if (this.inactifPlb) {
               var1.setActInactif(1);
            } else {
               var1.setActInactif(0);
            }
         }

         var1.setActDateCreat(new Date());
         var1.setActUserCreat(this.usersLog.getUsrid());
         var1.setActAnneeDebut(this.plansAnalytiques.getAnaAnneeDebut());
         var1.setActAnneeFin(this.plansAnalytiques.getAnaAnneeFin());
         var1.setActCode(this.plansAnalytiques.getAnaCode());
         var1.setActNomFr(this.plansAnalytiques.getAnaNomFr());
         var1.setActVte(this.plansAnalytiques.isAnaVte());
         var1.setActAch(this.plansAnalytiques.isAnaAch());
         var1.setActPrd(this.plansAnalytiques.isAnaPrd());
         var1.setActFrg(this.plansAnalytiques.isAnaFrg());
         var1.setActInv(this.plansAnalytiques.isAnaInv());
         var1.setActTva(this.plansAnalytiques.isAnaTva());
         var1.setActTax(this.plansAnalytiques.isAnaTax());
         var1.setActSal(this.plansAnalytiques.isAnaSal());
         this.activitesDao.insert(var1);
      }

      this.recherche();
      this.showModalPanelActivite = false;
   }

   public void verifCodeActivite() throws HibernateException, NamingException {
      this.existCod = false;
      this.existCod = this.activitesDao.existCode(this.plansAnalytiques.getAnaCode(), (Session)null);
   }

   public void calculDevise() throws HibernateException, NamingException {
      this.plansAnalytiques.setAnaTypeTauxDevise(0.0F);
      this.calculDevise((Session)null);
   }

   public void calculDevise(Session var1) throws HibernateException, NamingException {
      if (this.plansAnalytiques.getAnaTypeDevise() != null) {
         if (this.plansAnalytiques.getAnaTypeTauxDevise() == 0.0F) {
            if (this.plansAnalytiques.getAnaTypeDevise().equals(this.structureLog.getStrdevise())) {
               this.plansAnalytiques.setAnaTypeTauxDevise(1.0F);
            } else {
               new ObjetDevises();
               LectureDevises var3 = new LectureDevises();
               new Devise();
               DeviseDao var5 = new DeviseDao(this.baseLog, this.utilInitHibernate);
               Devise var4 = var5.chargerLesDevises(this.plansAnalytiques.getAnaTypeDevise(), var1);
               ObjetDevises var2;
               float var6;
               float var7;
               float var8;
               float var9;
               if (var4 != null) {
                  var6 = var4.getDevTaux1();
                  var7 = var4.getDevTaux2();
                  var2 = var3.devisesRecherchee(this.structureLog.getStrdevise(), this.structureLog.getStrdevise());
                  var8 = Float.parseFloat(var2.getTaux1());
                  var9 = Float.parseFloat(var2.getTaux2());
                  this.plansAnalytiques.setAnaTypeTauxDevise(var6 * var9);
               }

               if (this.plansAnalytiques.getAnaTypeTauxDevise() == 0.0F) {
                  var2 = var3.devisesRecherchee(this.plansAnalytiques.getAnaTypeDevise(), this.structureLog.getStrdevise());
                  var6 = Float.parseFloat(var2.getTaux1());
                  var7 = Float.parseFloat(var2.getTaux2());
                  var2 = var3.devisesRecherchee(this.structureLog.getStrdevise(), this.structureLog.getStrdevise());
                  var8 = Float.parseFloat(var2.getTaux1());
                  var9 = Float.parseFloat(var2.getTaux2());
                  this.plansAnalytiques.setAnaTypeTauxDevise(var6 * var9);
               }
            }
         }
      } else {
         this.plansAnalytiques.setAnaTypeTauxDevise(1.0F);
      }

   }

   public void validerDecoupage() throws HibernateException, NamingException {
      StructureDao var1 = new StructureDao(this.baseLog, this.utilInitHibernate);
      this.structureLog = var1.modStructure(this.structureLog);
      this.recupererAxesAnalytiques();
   }

   public void ajouterRepartition() {
      this.showModalPanelRepartition = true;
      this.mode_calcul = false;
      this.initVariable();
      this.natureRepartition = 0;
   }

   public void annulerRepartition() {
      this.showModalPanelRepartition = false;
   }

   public void modifierRepartition() {
      this.showModalPanelRepartition = true;
      this.mode_calcul = true;
      this.natureRepartition = this.plansAnalytiques.getAnaNatureRepartition();
   }

   public void supprimerRepartition() throws HibernateException, NamingException {
      if (this.var_nature.equalsIgnoreCase("9")) {
         if (this.lesPlanAnalytiqueRepartitions.size() != 0) {
            this.planAnalytiqueRepartitionDao.deletelesRepartitions(this.lesPlanAnalytiqueRepartitions);
         }

         this.lesPlanAnalytiqueRepartitions.clear();
      }

      this.testplbCptesup = false;
   }

   public void structureNature() throws HibernateException, NamingException {
      this.initVariable();
      this.mode_calcul = false;
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Analytique");
      if (this.natureRepartition == 100) {
         this.tableSitDepSer(var1);
      } else if (this.natureRepartition == 101) {
         this.tableRegSecPdv(var1);
      } else if (this.natureRepartition == 102) {
         this.tableSitLigAte(var1);
      } else {
         int var2;
         PlansAnalytiques var3;
         if (this.natureRepartition == 110) {
            this.lesActivites = this.activitesDao.selectActivites(var1);
            if (this.lesActivites.size() != 0) {
               for(var2 = 0; var2 < this.lesActivites.size(); ++var2) {
                  var3 = new PlansAnalytiques();
                  var3.setAnaId(((Activites)this.lesActivites.get(var2)).getActId());
                  var3.setAnaAnneeDebut(((Activites)this.lesActivites.get(var2)).getActAnneeDebut());
                  var3.setAnaAnneeFin(((Activites)this.lesActivites.get(var2)).getActAnneeFin());
                  var3.setAnaCode(((Activites)this.lesActivites.get(var2)).getActCode());
                  var3.setAnaNomFr(((Activites)this.lesActivites.get(var2)).getActNomFr());
                  var3.setAnaNature(((Activites)this.lesActivites.get(var2)).getActColonne());
                  var3.setAnaVte(((Activites)this.lesActivites.get(var2)).isActVte());
                  var3.setAnaAch(((Activites)this.lesActivites.get(var2)).isActAch());
                  var3.setAnaPrd(((Activites)this.lesActivites.get(var2)).isActPrd());
                  var3.setAnaFrg(((Activites)this.lesActivites.get(var2)).isActFrg());
                  var3.setAnaInv(((Activites)this.lesActivites.get(var2)).isActInv());
                  var3.setAnaTva(((Activites)this.lesActivites.get(var2)).isActTva());
                  var3.setAnaTax(((Activites)this.lesActivites.get(var2)).isActTax());
                  var3.setAnaSal(((Activites)this.lesActivites.get(var2)).isActSal());
                  var3.setAnaInactif(((Activites)this.lesActivites.get(var2)).getActInactif());
                  this.lesPlansAnalytiques.add(var3);
               }
            }
         } else if (this.natureRepartition == 120) {
            this.lesParcs = this.parcDao.selectLesParcs(var1);
            if (this.lesParcs.size() != 0) {
               for(var2 = 0; var2 < this.lesParcs.size(); ++var2) {
                  var3 = new PlansAnalytiques();
                  var3.setAnaId(((Parc)this.lesParcs.get(var2)).getPrcId());
                  var3.setAnaAnneeDebut(0);
                  var3.setAnaAnneeFin(0);
                  var3.setAnaCode(((Parc)this.lesParcs.get(var2)).getPrcImmatriculation());
                  var3.setAnaNomFr(((Parc)this.lesParcs.get(var2)).getPrcLibFamille() + " " + ((Parc)this.lesParcs.get(var2)).getPrcMarque());
                  var3.setAnaVte(false);
                  var3.setAnaAch(false);
                  var3.setAnaPrd(false);
                  var3.setAnaFrg(false);
                  var3.setAnaInv(false);
                  var3.setAnaTva(false);
                  var3.setAnaTax(false);
                  var3.setAnaSal(false);
                  var3.setAnaInactif(((Parc)this.lesParcs.get(var2)).getPrcInactif());
                  this.lesPlansAnalytiques.add(var3);
               }
            }
         } else if (this.natureRepartition == 122) {
            this.lesAgents = this.salariesDao.chargerlesSalariesActif(var1);
            if (this.lesAgents.size() != 0) {
               for(var2 = 0; var2 < this.lesAgents.size(); ++var2) {
                  var3 = new PlansAnalytiques();
                  var3.setAnaId(((Salaries)this.lesAgents.get(var2)).getSalId());
                  var3.setAnaAnneeDebut(0);
                  var3.setAnaAnneeFin(0);
                  var3.setAnaCode(((Salaries)this.lesAgents.get(var2)).getSalMatricule());
                  var3.setAnaNomFr(((Salaries)this.lesAgents.get(var2)).getPatronyme());
                  var3.setAnaVte(false);
                  var3.setAnaAch(false);
                  var3.setAnaPrd(false);
                  var3.setAnaFrg(false);
                  var3.setAnaInv(false);
                  var3.setAnaTva(false);
                  var3.setAnaTax(false);
                  var3.setAnaSal(false);
                  if (((Salaries)this.lesAgents.get(var2)).getSalEtat() <= 2) {
                     var3.setAnaInactif(1);
                  } else {
                     var3.setAnaInactif(0);
                  }

                  this.lesPlansAnalytiques.add(var3);
               }
            }
         } else if (this.natureRepartition == 130) {
            this.lesProjets = this.projetsDao.selectAllProjets(0, var1);
            if (this.lesProjets.size() != 0) {
               for(var2 = 0; var2 < this.lesProjets.size(); ++var2) {
                  var3 = new PlansAnalytiques();
                  var3.setAnaId(((Projets)this.lesProjets.get(var2)).getProId());
                  var3.setAnaAnneeDebut(0);
                  var3.setAnaAnneeFin(0);
                  var3.setAnaCode(((Projets)this.lesProjets.get(var2)).getProCode());
                  var3.setAnaNomFr(((Projets)this.lesProjets.get(var2)).getProNomFR());
                  var3.setAnaVte(false);
                  var3.setAnaAch(false);
                  var3.setAnaPrd(false);
                  var3.setAnaFrg(false);
                  var3.setAnaInv(false);
                  var3.setAnaTva(false);
                  var3.setAnaTax(false);
                  var3.setAnaSal(false);
                  var3.setAnaInactif(((Projets)this.lesProjets.get(var2)).getProInactif());
                  this.lesPlansAnalytiques.add(var3);
               }
            }
         } else if (this.natureRepartition != 200 && this.natureRepartition != 201) {
            if (this.natureRepartition == 6) {
               this.lesDossiers = this.plansAnalytiquesDao.chargerLesPlansAnalytiques("6", this.var_annee, var1);
            } else if (this.natureRepartition == 7) {
               this.lesChantiers = this.plansAnalytiquesDao.chargerLesPlansAnalytiques("7", this.var_annee, var1);
            } else if (this.natureRepartition == 8) {
               this.lesMissions = this.plansAnalytiquesDao.chargerLesPlansAnalytiques("8", this.var_annee, var1);
            } else if (this.natureRepartition == 9) {
               this.lesMissions = this.plansAnalytiquesDao.chargerLesPlansAnalytiques("9", this.var_annee, var1);
            }
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public void initVariable() {
      this.lesActivites.clear();
      this.lesSitDepSer.clear();
      this.lesRegSecPdv.clear();
      this.lesSitLigAte.clear();
      this.lesParcs.clear();
      this.lesDossiers.clear();
      this.lesAgents.clear();
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
      this.affiche_dossier = 0;
      this.affiche_parc = false;
      this.affiche_agent = false;
      this.affiche_chantier = false;
      this.affiche_mission = false;
      this.affiche_str = false;
   }

   public void tableSitDepSer(Session var1) throws HibernateException, NamingException {
      this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
      this.affiche_site = true;
      new ArrayList();
      SiteDao var3 = new SiteDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.chargerLesSitesList(var1);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            new Site();
            Site var5 = (Site)var2.get(var4);
            this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
            this.planAnalytiqueRepartition.setAffiche_site(true);
            this.planAnalytiqueRepartition.setAffiche_departement(false);
            this.planAnalytiqueRepartition.setAffiche_service(false);
            this.planAnalytiqueRepartition.setCleCodeSite(var5.getSitCode());
            this.planAnalytiqueRepartition.setCleLibelleSite(var5.getSitNomFr());
            this.lesSitDepSer.add(this.planAnalytiqueRepartition);
            this.affiche_departement = true;
            new ArrayList();
            DepartementDao var7 = new DepartementDao(this.baseLog, this.utilInitHibernate);
            List var6 = var7.listDepartementBySit(var5, var1);
            if (var6.size() != 0) {
               for(int var8 = 0; var8 < var6.size(); ++var8) {
                  new Departement();
                  Departement var9 = (Departement)var6.get(var8);
                  this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                  this.planAnalytiqueRepartition.setAffiche_site(false);
                  this.planAnalytiqueRepartition.setAffiche_departement(true);
                  this.planAnalytiqueRepartition.setAffiche_service(false);
                  this.planAnalytiqueRepartition.setCleCodeSite(var9.getSite().getSitCode());
                  this.planAnalytiqueRepartition.setCleLibelleSite(var9.getSite().getSitNomFr());
                  this.planAnalytiqueRepartition.setCleCodeDepartement(var9.getDepCode());
                  this.planAnalytiqueRepartition.setCleLibelleDepartement(var9.getDepNomFr());
                  this.lesSitDepSer.add(this.planAnalytiqueRepartition);
                  this.affiche_service = true;
                  new ArrayList();
                  ServiceDao var11 = new ServiceDao(this.baseLog, this.utilInitHibernate);
                  List var10 = var11.listServiceByDep(var9, var1);
                  if (var10.size() != 0) {
                     for(int var12 = 0; var12 < var10.size(); ++var12) {
                        new Service();
                        Service var13 = (Service)var10.get(var12);
                        this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                        this.planAnalytiqueRepartition.setAffiche_site(false);
                        this.planAnalytiqueRepartition.setAffiche_departement(false);
                        this.planAnalytiqueRepartition.setAffiche_service(true);
                        this.planAnalytiqueRepartition.setCleCodeSite(var13.getSite().getSitCode());
                        this.planAnalytiqueRepartition.setCleLibelleSite(var13.getSite().getSitNomFr());
                        this.planAnalytiqueRepartition.setCleCodeDepartement(var13.getDepartement().getDepCode());
                        this.planAnalytiqueRepartition.setCleLibelleDepartement(var13.getDepartement().getDepNomFr());
                        this.planAnalytiqueRepartition.setCleCodeService(var13.getSerCode());
                        this.planAnalytiqueRepartition.setCleLibelleService(var13.getSerNomFr());
                        this.lesSitDepSer.add(this.planAnalytiqueRepartition);
                     }
                  }
               }
            }
         }
      }

   }

   public void tableRegSecPdv(Session var1) throws HibernateException, NamingException {
      this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
      this.affiche_region = true;
      new ArrayList();
      RegionDao var3 = new RegionDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.chargerLesRegionList(var1);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            new Region();
            Region var5 = (Region)var2.get(var4);
            this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
            this.planAnalytiqueRepartition.setCleCodeRegion(var5.getRegCode());
            this.planAnalytiqueRepartition.setCleLibelleRegion(var5.getRegNomFr());
            this.lesRegSecPdv.add(this.planAnalytiqueRepartition);
            this.affiche_secteur = true;
            new ArrayList();
            SecteurDao var7 = new SecteurDao(this.baseLog, this.utilInitHibernate);
            List var6 = var7.listSecteurByRegion(var5, var1);
            if (var6.size() != 0) {
               for(int var8 = 0; var8 < var6.size(); ++var8) {
                  new Secteur();
                  Secteur var9 = (Secteur)var6.get(var8);
                  this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                  this.planAnalytiqueRepartition.setCleCodeRegion(var9.getRegion().getRegCode());
                  this.planAnalytiqueRepartition.setCleLibelleRegion(var9.getRegion().getRegNomFr());
                  this.planAnalytiqueRepartition.setCleCodeSecteur(var9.getSecCode());
                  this.planAnalytiqueRepartition.setCleLibelleSecteur(var9.getSecNomFr());
                  this.lesRegSecPdv.add(this.planAnalytiqueRepartition);
                  this.affiche_pdv = true;
                  new ArrayList();
                  PointDeVenteDao var11 = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
                  List var10 = var11.listPdvBySecteur(var9, var1);
                  if (var10.size() != 0) {
                     for(int var12 = 0; var12 < var10.size(); ++var12) {
                        new PointDeVente();
                        PointDeVente var13 = (PointDeVente)var10.get(var12);
                        this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                        this.planAnalytiqueRepartition.setCleCodeRegion(var13.getRegion().getRegCode());
                        this.planAnalytiqueRepartition.setCleLibelleRegion(var13.getRegion().getRegNomFr());
                        this.planAnalytiqueRepartition.setCleCodeSecteur(var13.getSecteur().getSecCode());
                        this.planAnalytiqueRepartition.setCleLibelleSecteur(var13.getSecteur().getSecNomFr());
                        this.planAnalytiqueRepartition.setCleCodePdv(var13.getPdvNomFr());
                        this.planAnalytiqueRepartition.setCleLibellePdv(var13.getPdvNomFr());
                        this.lesRegSecPdv.add(this.planAnalytiqueRepartition);
                     }
                  }
               }
            }
         }
      }

   }

   public void tableSitLigAte(Session var1) throws HibernateException, NamingException {
      this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
      this.affiche_sitePrdv = true;
      new ArrayList();
      SiteDao var3 = new SiteDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.chargerLesSitesList(var1);
      if (var2.size() != 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            new Site();
            Site var5 = (Site)var2.get(var4);
            this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
            this.planAnalytiqueRepartition.setAffiche_site(true);
            this.planAnalytiqueRepartition.setAffiche_ligne(false);
            this.planAnalytiqueRepartition.setAffiche_atelier(false);
            this.planAnalytiqueRepartition.setCleCodeSite(var5.getSitCode());
            this.planAnalytiqueRepartition.setCleLibelleSite(var5.getSitNomFr());
            this.lesSitLigAte.add(this.planAnalytiqueRepartition);
            this.affiche_ligne = true;
            new ArrayList();
            ProductionLigneDao var7 = new ProductionLigneDao(this.baseLog, this.utilInitHibernate);
            List var6 = var7.listProductionLigneBySit(var5, var1);
            if (var6.size() != 0) {
               for(int var8 = 0; var8 < var6.size(); ++var8) {
                  new ProductionLigne();
                  ProductionLigne var9 = (ProductionLigne)var6.get(var8);
                  this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                  this.planAnalytiqueRepartition.setAffiche_site(false);
                  this.planAnalytiqueRepartition.setAffiche_ligne(true);
                  this.planAnalytiqueRepartition.setAffiche_atelier(false);
                  this.planAnalytiqueRepartition.setCleCodeSite(var9.getSite().getSitCode());
                  this.planAnalytiqueRepartition.setCleLibelleSite(var9.getSite().getSitNomFr());
                  this.planAnalytiqueRepartition.setCleCodeLigne(var9.getLigCode());
                  this.planAnalytiqueRepartition.setCleLibelleLigne(var9.getLigNomFr());
                  this.lesSitLigAte.add(this.planAnalytiqueRepartition);
                  this.affiche_atelier = true;
                  new ArrayList();
                  ProductionAtelierDao var11 = new ProductionAtelierDao(this.baseLog, this.utilInitHibernate);
                  List var10 = var11.listProductionAtelierByLigne(var9, var1);
                  if (var10.size() != 0) {
                     for(int var12 = 0; var12 < var10.size(); ++var12) {
                        new ProductionAtelier();
                        ProductionAtelier var13 = (ProductionAtelier)var10.get(var12);
                        this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                        this.planAnalytiqueRepartition.setAffiche_site(false);
                        this.planAnalytiqueRepartition.setAffiche_ligne(false);
                        this.planAnalytiqueRepartition.setAffiche_atelier(true);
                        this.planAnalytiqueRepartition.setCleCodeSite(var13.getSite().getSitCode());
                        this.planAnalytiqueRepartition.setCleLibelleSite(var13.getSite().getSitNomFr());
                        this.planAnalytiqueRepartition.setCleCodeLigne(var13.getProductionLigne().getLigCode());
                        this.planAnalytiqueRepartition.setCleLibelleLigne(var13.getProductionLigne().getLigNomFr());
                        this.planAnalytiqueRepartition.setCleCodeAtelier(var13.getAteCode());
                        this.planAnalytiqueRepartition.setCleLibelleAtelier(var13.getAteNomFr());
                        this.lesSitLigAte.add(this.planAnalytiqueRepartition);
                     }
                  }
               }
            }
         }
      }

   }

   public void calculeRepartition() {
      this.mode_calcul = true;
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
      this.affiche_dossier = 0;
      this.affiche_parc = false;
      this.affiche_agent = false;
      this.affiche_chantier = false;
      this.affiche_mission = false;
      this.affiche_str = false;
      this.lesPlanAnalytiqueRepartitions = new ArrayList();
      this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
      this.calculeActivite();
      this.calculeSite();
      this.calculeDepartement();
      this.calculeService();
      this.calculeRegion();
      this.calculeSecteur();
      this.calculePdv();
      this.calculeSitePrd();
      this.calculeLigne();
      this.calculeAtelier();
      this.calculerDossier();
      this.calculerChantier();
      this.calculerMission();
      this.calculerParc();
      this.calculerAgent();
      this.miseEnFormeResultat();
   }

   public List trfList() {
      ArrayList var1 = new ArrayList();
      if (this.lesPlanAnalytiqueRepartitions.size() != 0) {
         for(int var2 = 0; var2 < this.lesPlanAnalytiqueRepartitions.size(); ++var2) {
            new PlanAnalytiqueRepartition();
            PlanAnalytiqueRepartition var3 = (PlanAnalytiqueRepartition)this.lesPlanAnalytiqueRepartitions.get(var2);
            var1.add(var3);
         }
      }

      return var1;
   }

   public void calculeActivite() {
      if (this.lesActivites.size() != 0) {
         new Activites();

         for(int var2 = 0; var2 < this.lesActivites.size(); ++var2) {
            Activites var1 = (Activites)this.lesActivites.get(var2);
            if (var1.isSelect_activite()) {
               this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
               this.planAnalytiqueRepartition.setCleCodeActivite(var1.getActCode());
               this.planAnalytiqueRepartition.setCleLibelleActivite(var1.getActNomFr());
               this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
               this.affiche_activite = true;
            }
         }
      }

   }

   public void calculeSite() {
      if (this.lesSitDepSer.size() != 0) {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.lesSitDepSer.size(); ++var2) {
            if (((PlanAnalytiqueRepartition)this.lesSitDepSer.get(var2)).isSelect_site()) {
               var1 = true;
               break;
            }
         }

         if (var1) {
            new ArrayList();
            new ArrayList();
            List var7 = this.trfList();
            this.lesPlanAnalytiqueRepartitions.clear();
            if (var7.size() != 0) {
               for(int var3 = 0; var3 < var7.size(); ++var3) {
                  new PlanAnalytiqueRepartition();
                  PlanAnalytiqueRepartition var4 = (PlanAnalytiqueRepartition)var7.get(var3);
                  new PlanAnalytiqueRepartition();

                  for(int var6 = 0; var6 < this.lesSitDepSer.size(); ++var6) {
                     PlanAnalytiqueRepartition var5 = (PlanAnalytiqueRepartition)this.lesSitDepSer.get(var6);
                     if (var5.isSelect_site()) {
                        this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                        this.planAnalytiqueRepartition.setCleCodeSite(var5.getCleCodeSite());
                        this.planAnalytiqueRepartition.setCleLibelleSite(var5.getCleLibelleSite());
                        this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                        this.affiche_site = true;
                     }
                  }
               }
            } else {
               new PlanAnalytiqueRepartition();

               for(int var9 = 0; var9 < this.lesSitDepSer.size(); ++var9) {
                  PlanAnalytiqueRepartition var8 = (PlanAnalytiqueRepartition)this.lesSitDepSer.get(var9);
                  if (var8.isSelect_site()) {
                     this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                     this.planAnalytiqueRepartition.setCleCodeSite(var8.getCleCodeSite());
                     this.planAnalytiqueRepartition.setCleLibelleSite(var8.getCleLibelleSite());
                     this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                     this.affiche_site = true;
                  }
               }
            }
         }
      }

   }

   public void calculeDepartement() {
      if (this.lesSitDepSer.size() != 0) {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.lesSitDepSer.size(); ++var2) {
            if (((PlanAnalytiqueRepartition)this.lesSitDepSer.get(var2)).isSelect_departement()) {
               var1 = true;
               break;
            }
         }

         if (var1) {
            new ArrayList();
            new ArrayList();
            List var7 = this.trfList();
            this.lesPlanAnalytiqueRepartitions.clear();
            if (var7.size() != 0) {
               for(int var3 = 0; var3 < var7.size(); ++var3) {
                  new PlanAnalytiqueRepartition();
                  PlanAnalytiqueRepartition var4 = (PlanAnalytiqueRepartition)var7.get(var3);
                  new PlanAnalytiqueRepartition();

                  for(int var6 = 0; var6 < this.lesSitDepSer.size(); ++var6) {
                     PlanAnalytiqueRepartition var5 = (PlanAnalytiqueRepartition)this.lesSitDepSer.get(var6);
                     if (var5.isSelect_departement() && var5.getCleCodeSite().equalsIgnoreCase(var4.getCleCodeSite())) {
                        this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                        this.planAnalytiqueRepartition.setCleCodeSite(var4.getCleCodeSite());
                        this.planAnalytiqueRepartition.setCleLibelleSite(var4.getCleLibelleSite());
                        this.planAnalytiqueRepartition.setCleCodeDepartement(var5.getCleCodeDepartement());
                        this.planAnalytiqueRepartition.setCleLibelleDepartement(var5.getCleLibelleDepartement());
                        this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                        this.affiche_departement = true;
                     }
                  }
               }
            } else {
               new PlanAnalytiqueRepartition();

               for(int var9 = 0; var9 < this.lesSitDepSer.size(); ++var9) {
                  PlanAnalytiqueRepartition var8 = (PlanAnalytiqueRepartition)this.lesSitDepSer.get(var9);
                  if (var8.isSelect_departement()) {
                     this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                     this.planAnalytiqueRepartition.setCleCodeDepartement(var8.getCleCodeDepartement());
                     this.planAnalytiqueRepartition.setCleLibelleDepartement(var8.getCleLibelleDepartement());
                     this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                     this.affiche_departement = true;
                  }
               }
            }
         }
      }

   }

   public void calculeService() {
      if (this.lesSitDepSer.size() != 0) {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.lesSitDepSer.size(); ++var2) {
            if (((PlanAnalytiqueRepartition)this.lesSitDepSer.get(var2)).isSelect_service()) {
               var1 = true;
               break;
            }
         }

         if (var1) {
            new ArrayList();
            new ArrayList();
            List var7 = this.trfList();
            this.lesPlanAnalytiqueRepartitions.clear();
            if (var7.size() != 0) {
               for(int var3 = 0; var3 < var7.size(); ++var3) {
                  new PlanAnalytiqueRepartition();
                  PlanAnalytiqueRepartition var4 = (PlanAnalytiqueRepartition)var7.get(var3);
                  new PlanAnalytiqueRepartition();

                  for(int var6 = 0; var6 < this.lesSitDepSer.size(); ++var6) {
                     PlanAnalytiqueRepartition var5 = (PlanAnalytiqueRepartition)this.lesSitDepSer.get(var6);
                     if (var5.isSelect_service() && var5.getCleCodeDepartement().equalsIgnoreCase(var4.getCleCodeDepartement())) {
                        this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                        this.planAnalytiqueRepartition.setCleCodeSite(var4.getCleCodeSite());
                        this.planAnalytiqueRepartition.setCleLibelleSite(var4.getCleLibelleSite());
                        this.planAnalytiqueRepartition.setCleCodeDepartement(var4.getCleCodeDepartement());
                        this.planAnalytiqueRepartition.setCleLibelleDepartement(var4.getCleLibelleDepartement());
                        this.planAnalytiqueRepartition.setCleCodeService(var5.getCleCodeService());
                        this.planAnalytiqueRepartition.setCleLibelleService(var5.getCleLibelleService());
                        this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                        this.affiche_service = true;
                     }
                  }
               }
            } else {
               new PlanAnalytiqueRepartition();

               for(int var9 = 0; var9 < this.lesSitDepSer.size(); ++var9) {
                  PlanAnalytiqueRepartition var8 = (PlanAnalytiqueRepartition)this.lesSitDepSer.get(var9);
                  if (var8.isSelect_service()) {
                     this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                     this.planAnalytiqueRepartition.setCleCodeService(var8.getCleCodeService());
                     this.planAnalytiqueRepartition.setCleLibelleService(var8.getCleLibelleService());
                     this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                     this.affiche_service = true;
                  }
               }
            }
         }
      }

   }

   public void calculeRegion() {
      if (this.lesRegSecPdv.size() != 0) {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.lesRegSecPdv.size(); ++var2) {
            if (((PlanAnalytiqueRepartition)this.lesRegSecPdv.get(var2)).isSelect_region()) {
               var1 = true;
               break;
            }
         }

         if (var1) {
            new ArrayList();
            new ArrayList();
            List var7 = this.trfList();
            this.lesPlanAnalytiqueRepartitions.clear();
            if (var7.size() != 0) {
               for(int var3 = 0; var3 < var7.size(); ++var3) {
                  new PlanAnalytiqueRepartition();
                  PlanAnalytiqueRepartition var4 = (PlanAnalytiqueRepartition)var7.get(var3);
                  new PlanAnalytiqueRepartition();

                  for(int var6 = 0; var6 < this.lesRegSecPdv.size(); ++var6) {
                     PlanAnalytiqueRepartition var5 = (PlanAnalytiqueRepartition)this.lesRegSecPdv.get(var6);
                     if (var5.isSelect_region()) {
                        this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                        this.planAnalytiqueRepartition.setCleCodeRegion(var5.getCleCodeRegion());
                        this.planAnalytiqueRepartition.setCleLibelleRegion(var5.getCleLibelleRegion());
                        this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                        this.affiche_region = true;
                     }
                  }
               }
            } else {
               new PlanAnalytiqueRepartition();

               for(int var9 = 0; var9 < this.lesRegSecPdv.size(); ++var9) {
                  PlanAnalytiqueRepartition var8 = (PlanAnalytiqueRepartition)this.lesRegSecPdv.get(var9);
                  if (var8.isSelect_region()) {
                     this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                     this.planAnalytiqueRepartition.setCleCodeRegion(var8.getCleCodeRegion());
                     this.planAnalytiqueRepartition.setCleLibelleRegion(var8.getCleLibelleRegion());
                     this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                     this.affiche_region = true;
                  }
               }
            }
         }
      }

   }

   public void calculeSecteur() {
      if (this.lesRegSecPdv.size() != 0) {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.lesRegSecPdv.size(); ++var2) {
            if (((PlanAnalytiqueRepartition)this.lesRegSecPdv.get(var2)).isSelect_secteur()) {
               var1 = true;
               break;
            }
         }

         if (var1) {
            new ArrayList();
            new ArrayList();
            List var7 = this.trfList();
            this.lesPlanAnalytiqueRepartitions.clear();
            if (var7.size() != 0) {
               for(int var3 = 0; var3 < var7.size(); ++var3) {
                  new PlanAnalytiqueRepartition();
                  PlanAnalytiqueRepartition var4 = (PlanAnalytiqueRepartition)var7.get(var3);
                  new PlanAnalytiqueRepartition();

                  for(int var6 = 0; var6 < this.lesRegSecPdv.size(); ++var6) {
                     PlanAnalytiqueRepartition var5 = (PlanAnalytiqueRepartition)this.lesRegSecPdv.get(var6);
                     if (var5.isSelect_secteur() && var5.getCleCodeRegion().equalsIgnoreCase(var4.getCleCodeRegion())) {
                        this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                        this.planAnalytiqueRepartition.setCleCodeRegion(var4.getCleCodeRegion());
                        this.planAnalytiqueRepartition.setCleLibelleRegion(var4.getCleLibelleRegion());
                        this.planAnalytiqueRepartition.setCleCodeDepartement(var4.getCleCodeDepartement());
                        this.planAnalytiqueRepartition.setCleLibelleDepartement(var4.getCleLibelleDepartement());
                        this.planAnalytiqueRepartition.setCleCodeSecteur(var5.getCleCodeSecteur());
                        this.planAnalytiqueRepartition.setCleLibelleSecteur(var5.getCleLibelleSecteur());
                        this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                        this.affiche_secteur = true;
                     }
                  }
               }
            } else {
               new PlanAnalytiqueRepartition();

               for(int var9 = 0; var9 < this.lesRegSecPdv.size(); ++var9) {
                  PlanAnalytiqueRepartition var8 = (PlanAnalytiqueRepartition)this.lesRegSecPdv.get(var9);
                  if (var8.isSelect_secteur()) {
                     this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                     this.planAnalytiqueRepartition.setCleCodeSecteur(var8.getCleCodeSecteur());
                     this.planAnalytiqueRepartition.setCleLibelleSecteur(var8.getCleLibelleSecteur());
                     this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                     this.affiche_secteur = true;
                  }
               }
            }
         }
      }

   }

   public void calculePdv() {
      if (this.lesRegSecPdv.size() != 0) {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.lesRegSecPdv.size(); ++var2) {
            if (((PlanAnalytiqueRepartition)this.lesRegSecPdv.get(var2)).isSelect_pdv()) {
               var1 = true;
               break;
            }
         }

         if (var1) {
            new ArrayList();
            new ArrayList();
            List var7 = this.trfList();
            this.lesPlanAnalytiqueRepartitions.clear();
            if (var7.size() != 0) {
               for(int var3 = 0; var3 < var7.size(); ++var3) {
                  new PlanAnalytiqueRepartition();
                  PlanAnalytiqueRepartition var4 = (PlanAnalytiqueRepartition)var7.get(var3);
                  new PlanAnalytiqueRepartition();

                  for(int var6 = 0; var6 < this.lesRegSecPdv.size(); ++var6) {
                     PlanAnalytiqueRepartition var5 = (PlanAnalytiqueRepartition)this.lesRegSecPdv.get(var6);
                     if (var5.isSelect_departement() && var5.getCleCodeSecteur().equalsIgnoreCase(var4.getCleCodeSecteur())) {
                        this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                        this.planAnalytiqueRepartition.setCleCodeRegion(var4.getCleCodeRegion());
                        this.planAnalytiqueRepartition.setCleLibelleRegion(var4.getCleLibelleRegion());
                        this.planAnalytiqueRepartition.setCleCodeDepartement(var4.getCleCodeDepartement());
                        this.planAnalytiqueRepartition.setCleLibelleDepartement(var4.getCleLibelleDepartement());
                        this.planAnalytiqueRepartition.setCleCodeSecteur(var4.getCleCodeSecteur());
                        this.planAnalytiqueRepartition.setCleLibelleSecteur(var4.getCleLibelleSecteur());
                        this.planAnalytiqueRepartition.setCleCodePdv(var5.getCleCodePdv());
                        this.planAnalytiqueRepartition.setCleLibellePdv(var5.getCleLibellePdv());
                        this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                        this.affiche_pdv = true;
                     }
                  }
               }
            } else {
               new PlanAnalytiqueRepartition();

               for(int var9 = 0; var9 < this.lesRegSecPdv.size(); ++var9) {
                  PlanAnalytiqueRepartition var8 = (PlanAnalytiqueRepartition)this.lesRegSecPdv.get(var9);
                  if (var8.isSelect_service()) {
                     this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                     this.planAnalytiqueRepartition.setCleCodePdv(var8.getCleCodePdv());
                     this.planAnalytiqueRepartition.setCleLibellePdv(var8.getCleLibellePdv());
                     this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                     this.affiche_pdv = true;
                  }
               }
            }
         }
      }

   }

   public void calculeSitePrd() {
      if (this.lesSitLigAte.size() != 0) {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.lesSitLigAte.size(); ++var2) {
            if (((PlanAnalytiqueRepartition)this.lesSitLigAte.get(var2)).isSelect_site()) {
               var1 = true;
               break;
            }
         }

         if (var1) {
            new ArrayList();
            new ArrayList();
            List var7 = this.trfList();
            this.lesPlanAnalytiqueRepartitions.clear();
            if (var7.size() != 0) {
               for(int var3 = 0; var3 < var7.size(); ++var3) {
                  new PlanAnalytiqueRepartition();
                  PlanAnalytiqueRepartition var4 = (PlanAnalytiqueRepartition)var7.get(var3);
                  new PlanAnalytiqueRepartition();

                  for(int var6 = 0; var6 < this.lesSitLigAte.size(); ++var6) {
                     PlanAnalytiqueRepartition var5 = (PlanAnalytiqueRepartition)this.lesSitLigAte.get(var6);
                     if (var5.isSelect_site()) {
                        this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                        this.planAnalytiqueRepartition.setCleCodeSite(var5.getCleCodeSite());
                        this.planAnalytiqueRepartition.setCleLibelleSite(var5.getCleLibelleSite());
                        this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                        this.affiche_sitePrdv = true;
                     }
                  }
               }
            } else {
               new PlanAnalytiqueRepartition();

               for(int var9 = 0; var9 < this.lesSitLigAte.size(); ++var9) {
                  PlanAnalytiqueRepartition var8 = (PlanAnalytiqueRepartition)this.lesSitLigAte.get(var9);
                  if (var8.isSelect_site()) {
                     this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                     this.planAnalytiqueRepartition.setCleCodeSite(var8.getCleCodeSite());
                     this.planAnalytiqueRepartition.setCleLibelleSite(var8.getCleLibelleSite());
                     this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                     this.affiche_sitePrdv = true;
                  }
               }
            }
         }
      }

   }

   public void calculeLigne() {
      if (this.lesSitLigAte.size() != 0) {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.lesSitLigAte.size(); ++var2) {
            if (((PlanAnalytiqueRepartition)this.lesSitLigAte.get(var2)).isSelect_ligne()) {
               var1 = true;
               break;
            }
         }

         if (var1) {
            new ArrayList();
            new ArrayList();
            List var7 = this.trfList();
            this.lesPlanAnalytiqueRepartitions.clear();
            if (var7.size() != 0) {
               for(int var3 = 0; var3 < var7.size(); ++var3) {
                  new PlanAnalytiqueRepartition();
                  PlanAnalytiqueRepartition var4 = (PlanAnalytiqueRepartition)var7.get(var3);
                  new PlanAnalytiqueRepartition();

                  for(int var6 = 0; var6 < this.lesSitLigAte.size(); ++var6) {
                     PlanAnalytiqueRepartition var5 = (PlanAnalytiqueRepartition)this.lesSitLigAte.get(var6);
                     if (var5.isSelect_ligne() && var5.getCleCodeSite().equalsIgnoreCase(var4.getCleCodeSite())) {
                        this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                        this.planAnalytiqueRepartition.setCleCodeSite(var4.getCleCodeSite());
                        this.planAnalytiqueRepartition.setCleLibelleSite(var4.getCleLibelleSite());
                        this.planAnalytiqueRepartition.setCleCodeLigne(var5.getCleCodeLigne());
                        this.planAnalytiqueRepartition.setCleLibelleLigne(var5.getCleLibelleLigne());
                        this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                        this.affiche_ligne = true;
                     }
                  }
               }
            } else {
               new PlanAnalytiqueRepartition();

               for(int var9 = 0; var9 < this.lesSitLigAte.size(); ++var9) {
                  PlanAnalytiqueRepartition var8 = (PlanAnalytiqueRepartition)this.lesSitLigAte.get(var9);
                  if (var8.isSelect_ligne()) {
                     this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                     this.planAnalytiqueRepartition.setCleCodeLigne(var8.getCleCodeLigne());
                     this.planAnalytiqueRepartition.setCleLibelleLigne(var8.getCleLibelleLigne());
                     this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                     this.affiche_ligne = true;
                  }
               }
            }
         }
      }

   }

   public void calculeAtelier() {
      if (this.lesSitLigAte.size() != 0) {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.lesSitLigAte.size(); ++var2) {
            if (((PlanAnalytiqueRepartition)this.lesSitLigAte.get(var2)).isSelect_atelier()) {
               var1 = true;
               break;
            }
         }

         if (var1) {
            new ArrayList();
            new ArrayList();
            List var7 = this.trfList();
            this.lesPlanAnalytiqueRepartitions.clear();
            if (var7.size() != 0) {
               for(int var3 = 0; var3 < var7.size(); ++var3) {
                  new PlanAnalytiqueRepartition();
                  PlanAnalytiqueRepartition var4 = (PlanAnalytiqueRepartition)var7.get(var3);
                  new PlanAnalytiqueRepartition();

                  for(int var6 = 0; var6 < this.lesSitLigAte.size(); ++var6) {
                     PlanAnalytiqueRepartition var5 = (PlanAnalytiqueRepartition)this.lesSitLigAte.get(var6);
                     if (var5.isSelect_atelier() && var5.getCleCodeLigne().equalsIgnoreCase(var4.getCleCodeLigne())) {
                        this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                        this.planAnalytiqueRepartition.setCleCodeSite(var4.getCleCodeSite());
                        this.planAnalytiqueRepartition.setCleLibelleSite(var4.getCleLibelleSite());
                        this.planAnalytiqueRepartition.setCleCodeLigne(var4.getCleCodeLigne());
                        this.planAnalytiqueRepartition.setCleLibelleLigne(var4.getCleLibelleLigne());
                        this.planAnalytiqueRepartition.setCleCodeAtelier(var5.getCleCodeAtelier());
                        this.planAnalytiqueRepartition.setCleLibelleAtelier(var5.getCleLibelleAtelier());
                        this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                        this.affiche_atelier = true;
                     }
                  }
               }
            } else {
               new PlanAnalytiqueRepartition();

               for(int var9 = 0; var9 < this.lesSitLigAte.size(); ++var9) {
                  PlanAnalytiqueRepartition var8 = (PlanAnalytiqueRepartition)this.lesSitLigAte.get(var9);
                  if (var8.isSelect_atelier()) {
                     this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                     this.planAnalytiqueRepartition.setCleCodeAtelier(var8.getCleCodeAtelier());
                     this.planAnalytiqueRepartition.setCleLibelleAtelier(var8.getCleLibelleAtelier());
                     this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                     this.affiche_atelier = true;
                  }
               }
            }
         }
      }

   }

   public void calculerDossier() {
      if (this.lesDossiers.size() != 0) {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.lesDossiers.size(); ++var2) {
            if (((PlansAnalytiques)this.lesDossiers.get(var2)).isSelect_analytique()) {
               var1 = true;
               break;
            }
         }

         if (var1) {
            new ArrayList();
            new ArrayList();
            List var7 = this.trfList();
            this.lesPlanAnalytiqueRepartitions.clear();
            if (var7.size() != 0) {
               for(int var3 = 0; var3 < var7.size(); ++var3) {
                  new PlanAnalytiqueRepartition();
                  PlanAnalytiqueRepartition var4 = (PlanAnalytiqueRepartition)var7.get(var3);
                  new PlansAnalytiques();

                  for(int var6 = 0; var6 < this.lesDossiers.size(); ++var6) {
                     PlansAnalytiques var5 = (PlansAnalytiques)this.lesDossiers.get(var6);
                     if (var5.isSelect_analytique()) {
                        this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                        this.planAnalytiqueRepartition.setCleCodeDossier(var5.getAnaCode());
                        this.planAnalytiqueRepartition.setCleLibelleDossier(var5.getAnaNomFr());
                        this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                        this.affiche_dossier = 1;
                     }
                  }
               }
            } else {
               new PlansAnalytiques();

               for(int var9 = 0; var9 < this.lesDossiers.size(); ++var9) {
                  PlansAnalytiques var8 = (PlansAnalytiques)this.lesDossiers.get(var9);
                  if (var8.isSelect_analytique()) {
                     this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                     this.planAnalytiqueRepartition.setCleCodeDossier(var8.getAnaCode());
                     this.planAnalytiqueRepartition.setCleLibelleDossier(var8.getAnaNomFr());
                     this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                     this.affiche_dossier = 1;
                  }
               }
            }
         }
      }

   }

   public void calculerChantier() {
      if (this.lesChantiers.size() != 0) {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.lesChantiers.size(); ++var2) {
            if (((PlansAnalytiques)this.lesChantiers.get(var2)).isSelect_analytique()) {
               var1 = true;
               break;
            }
         }

         if (var1) {
            new ArrayList();
            new ArrayList();
            List var7 = this.trfList();
            this.lesPlanAnalytiqueRepartitions.clear();
            if (var7.size() != 0) {
               for(int var3 = 0; var3 < var7.size(); ++var3) {
                  new PlanAnalytiqueRepartition();
                  PlanAnalytiqueRepartition var4 = (PlanAnalytiqueRepartition)var7.get(var3);
                  new PlansAnalytiques();

                  for(int var6 = 0; var6 < this.lesChantiers.size(); ++var6) {
                     PlansAnalytiques var5 = (PlansAnalytiques)this.lesChantiers.get(var6);
                     if (var5.isSelect_analytique()) {
                        this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                        this.planAnalytiqueRepartition.setCleCodeDossier(var5.getAnaCode());
                        this.planAnalytiqueRepartition.setCleLibelleDossier(var5.getAnaNomFr());
                        this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                        this.affiche_chantier = true;
                     }
                  }
               }
            } else {
               new PlansAnalytiques();

               for(int var9 = 0; var9 < this.lesChantiers.size(); ++var9) {
                  PlansAnalytiques var8 = (PlansAnalytiques)this.lesChantiers.get(var9);
                  if (var8.isSelect_analytique()) {
                     this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                     this.planAnalytiqueRepartition.setCleCodeDossier(var8.getAnaCode());
                     this.planAnalytiqueRepartition.setCleLibelleDossier(var8.getAnaNomFr());
                     this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                     this.affiche_chantier = true;
                  }
               }
            }
         }
      }

   }

   public void calculerMission() {
      if (this.lesMissions.size() != 0) {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.lesMissions.size(); ++var2) {
            if (((PlansAnalytiques)this.lesMissions.get(var2)).isSelect_analytique()) {
               var1 = true;
               break;
            }
         }

         if (var1) {
            new ArrayList();
            new ArrayList();
            List var7 = this.trfList();
            this.lesPlanAnalytiqueRepartitions.clear();
            if (var7.size() != 0) {
               for(int var3 = 0; var3 < var7.size(); ++var3) {
                  new PlanAnalytiqueRepartition();
                  PlanAnalytiqueRepartition var4 = (PlanAnalytiqueRepartition)var7.get(var3);
                  new PlansAnalytiques();

                  for(int var6 = 0; var6 < this.lesMissions.size(); ++var6) {
                     PlansAnalytiques var5 = (PlansAnalytiques)this.lesMissions.get(var6);
                     if (var5.isSelect_analytique()) {
                        this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                        this.planAnalytiqueRepartition.setCleCodeDossier(var5.getAnaCode());
                        this.planAnalytiqueRepartition.setCleLibelleDossier(var5.getAnaNomFr());
                        this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                        this.affiche_mission = true;
                     }
                  }
               }
            } else {
               new PlansAnalytiques();

               for(int var9 = 0; var9 < this.lesMissions.size(); ++var9) {
                  PlansAnalytiques var8 = (PlansAnalytiques)this.lesMissions.get(var9);
                  if (var8.isSelect_analytique()) {
                     this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                     this.planAnalytiqueRepartition.setCleCodeDossier(var8.getAnaCode());
                     this.planAnalytiqueRepartition.setCleLibelleDossier(var8.getAnaNomFr());
                     this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                     this.affiche_mission = true;
                  }
               }
            }
         }
      }

   }

   public void calculerParc() {
      if (this.lesParcs.size() != 0) {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.lesParcs.size(); ++var2) {
            if (((Parc)this.lesParcs.get(var2)).isSelect_parc()) {
               var1 = true;
               break;
            }
         }

         if (var1) {
            new ArrayList();
            new ArrayList();
            List var7 = this.trfList();
            this.lesPlanAnalytiqueRepartitions.clear();
            if (var7.size() != 0) {
               for(int var3 = 0; var3 < var7.size(); ++var3) {
                  new PlanAnalytiqueRepartition();
                  PlanAnalytiqueRepartition var4 = (PlanAnalytiqueRepartition)var7.get(var3);
                  new Parc();

                  for(int var6 = 0; var6 < this.lesParcs.size(); ++var6) {
                     Parc var5 = (Parc)this.lesParcs.get(var6);
                     if (var5.isSelect_parc()) {
                        this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                        this.planAnalytiqueRepartition.setCleCodeParc(var5.getPrcImmatriculation());
                        this.planAnalytiqueRepartition.setCleLibelleParc(var5.getPrcLibNature() + " " + var5.getPrcMarque());
                        this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                        this.affiche_parc = true;
                     }
                  }
               }
            } else {
               new Parc();

               for(int var9 = 0; var9 < this.lesParcs.size(); ++var9) {
                  Parc var8 = (Parc)this.lesParcs.get(var9);
                  if (var8.isSelect_parc()) {
                     this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                     this.planAnalytiqueRepartition.setCleCodeParc(var8.getPrcImmatriculation());
                     this.planAnalytiqueRepartition.setCleLibelleParc(var8.getPrcLibNature() + " " + var8.getPrcMarque());
                     this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                     this.affiche_parc = true;
                  }
               }
            }
         }
      }

   }

   public void calculerAgent() {
      if (this.lesAgents.size() != 0) {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.lesAgents.size(); ++var2) {
            if (((Salaries)this.lesAgents.get(var2)).isSelect_agent()) {
               var1 = true;
               break;
            }
         }

         if (var1) {
            new ArrayList();
            new ArrayList();
            List var7 = this.trfList();
            this.lesPlanAnalytiqueRepartitions.clear();
            if (var7.size() != 0) {
               for(int var3 = 0; var3 < var7.size(); ++var3) {
                  new PlanAnalytiqueRepartition();
                  PlanAnalytiqueRepartition var4 = (PlanAnalytiqueRepartition)var7.get(var3);
                  new Salaries();

                  for(int var6 = 0; var6 < this.lesAgents.size(); ++var6) {
                     Salaries var5 = (Salaries)this.lesAgents.get(var6);
                     if (var5.isSelect_agent()) {
                        this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                        this.planAnalytiqueRepartition.setCleCodeAgent(var5.getSalMatricule());
                        this.planAnalytiqueRepartition.setCleLibelleAgent(var5.getSalNom() + " " + var5.getSalPrenom());
                        this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                        this.affiche_agent = true;
                     }
                  }
               }
            } else {
               new Salaries();

               for(int var9 = 0; var9 < this.lesAgents.size(); ++var9) {
                  Salaries var8 = (Salaries)this.lesAgents.get(var9);
                  if (var8.isSelect_agent()) {
                     this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                     this.planAnalytiqueRepartition.setCleCodeActivite(var8.getSalMatricule());
                     this.planAnalytiqueRepartition.setCleLibelleActivite(var8.getSalNom() + " " + var8.getSalPrenom());
                     this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
                     this.affiche_agent = true;
                  }
               }
            }
         }
      }

   }

   public void miseEnFormeResultat() {
      if (this.lesPlanAnalytiqueRepartitions.size() != 0) {
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
         new PlanAnalytiqueRepartition();

         for(int var16 = 0; var16 < this.lesPlanAnalytiqueRepartitions.size(); ++var16) {
            PlanAnalytiqueRepartition var15 = (PlanAnalytiqueRepartition)this.lesPlanAnalytiqueRepartitions.get(var16);
            if (var15.getCleCodeActivite() != null && !var15.getCleCodeActivite().equalsIgnoreCase(var1)) {
               var15.setAffiche_activite(true);
               var1 = var15.getCleCodeActivite();
            } else {
               var15.setAffiche_activite(false);
            }

            if (var15.getCleCodeSite() != null && !var15.getCleCodeSite().equalsIgnoreCase(var2)) {
               var15.setAffiche_site(true);
               var2 = var15.getCleCodeSite();
            } else {
               var15.setAffiche_site(false);
            }

            if (var15.getCleCodeDepartement() != null && !var15.getCleCodeDepartement().equalsIgnoreCase(var3)) {
               var15.setAffiche_departement(true);
               var3 = var15.getCleCodeDepartement();
            } else {
               var15.setAffiche_departement(false);
            }

            if (var15.getCleCodeService() != null && !var15.getCleCodeService().equalsIgnoreCase(var4)) {
               var15.setAffiche_service(true);
               var4 = var15.getCleCodeService();
            } else {
               var15.setAffiche_service(false);
            }

            if (var15.getCleCodeRegion() != null && !var15.getCleCodeRegion().equalsIgnoreCase(var5)) {
               var15.setAffiche_region(true);
               var5 = var15.getCleCodeRegion();
            } else {
               var15.setAffiche_region(false);
            }

            if (var15.getCleCodeSecteur() != null && !var15.getCleCodeSecteur().equalsIgnoreCase(var6)) {
               var15.setAffiche_secteur(true);
               var6 = var15.getCleCodeSecteur();
            } else {
               var15.setAffiche_secteur(false);
            }

            if (var15.getCleCodePdv() != null && !var15.getCleCodePdv().equalsIgnoreCase(var7)) {
               var15.setAffiche_pdv(true);
               var7 = var15.getCleCodePdv();
            } else {
               var15.setAffiche_pdv(false);
            }

            if (var15.getCleCodeLigne() != null && !var15.getCleCodeLigne().equalsIgnoreCase(var8)) {
               var15.setAffiche_ligne(true);
               var8 = var15.getCleCodeLigne();
            } else {
               var15.setAffiche_ligne(false);
            }

            if (var15.getCleCodeAtelier() != null && !var15.getCleCodeAtelier().equalsIgnoreCase(var9)) {
               var15.setAffiche_atelier(true);
               var9 = var15.getCleCodeAtelier();
            } else {
               var15.setAffiche_atelier(false);
            }

            if (var15.getCleCodeDossier() != null && !var15.getCleCodeDossier().equalsIgnoreCase(var10)) {
               var15.setAffiche_dossier(true);
               var10 = var15.getCleCodeDossier();
            } else {
               var15.setAffiche_dossier(false);
            }

            if (var15.getCleCodeChantier() != null && !var15.getCleCodeChantier().equalsIgnoreCase(var11)) {
               var15.setAffiche_chantier(true);
               var11 = var15.getCleCodeChantier();
            } else {
               var15.setAffiche_chantier(false);
            }

            if (var15.getCleCodeMission() != null && !var15.getCleCodeMission().equalsIgnoreCase(var12)) {
               var15.setAffiche_mission(true);
               var12 = var15.getCleCodeMission();
            } else {
               var15.setAffiche_mission(false);
            }

            if (var15.getCleCodeParc() != null && !var15.getCleCodeParc().equalsIgnoreCase(var13)) {
               var15.setAffiche_parc(true);
               var13 = var15.getCleCodeParc();
            } else {
               var15.setAffiche_parc(false);
            }

            if (var15.getCleCodeAgent() != null && !var15.getCleCodeAgent().equalsIgnoreCase(var14)) {
               var15.setAffiche_agent(true);
               var14 = var15.getCleCodeAgent();
            } else {
               var15.setAffiche_agent(false);
            }
         }
      }

   }

   public void validerRepartition() throws HibernateException, NamingException {
      if (this.lesPlanAnalytiqueRepartitions.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlansAnalytiques");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.planAnalytiqueRepartitionDao.deletelesRepartitions(this.plansAnalytiques, var1);
            float var3 = 0.0F;
            float var4 = 0.0F;
            float var5 = 0.0F;
            float var6 = 0.0F;
            float var7 = 0.0F;
            float var8 = 0.0F;
            float var9 = 0.0F;
            float var10 = 0.0F;
            float var11 = 0.0F;
            float var12 = 0.0F;
            float var13 = 0.0F;
            float var14 = 0.0F;
            float var15 = 0.0F;
            float var16 = 0.0F;
            float var17 = 0.0F;
            int var18 = 0;

            while(true) {
               if (var18 >= this.lesPlanAnalytiqueRepartitions.size()) {
                  this.plansAnalytiques.setAnaNatureRepartition(this.natureRepartition);
                  this.plansAnalytiquesDao.modif(this.plansAnalytiques, var1);
                  var2.commit();
                  break;
               }

               new PlanAnalytiqueRepartition();
               PlanAnalytiqueRepartition var19 = (PlanAnalytiqueRepartition)this.lesPlanAnalytiqueRepartitions.get(var18);
               if (var19.getCleRepActivite() != 0.0D) {
                  var3 = (float)var19.getCleRepActivite();
               }

               if (var19.getCleRepSite() != 0.0D) {
                  var4 = (float)var19.getCleRepSite();
               }

               if (var19.getCleRepDepartement() != 0.0D) {
                  var5 = (float)var19.getCleRepDepartement();
               }

               if (var19.getCleRepService() != 0.0D) {
                  var6 = (float)var19.getCleRepService();
               }

               if (var19.getCleRepRegion() != 0.0D) {
                  var7 = (float)var19.getCleRepRegion();
               }

               if (var19.getCleRepSecteur() != 0.0D) {
                  var8 = (float)var19.getCleRepSecteur();
               }

               if (var19.getCleRepPdv() != 0.0D) {
                  var9 = (float)var19.getCleRepPdv();
               }

               if (var19.getCleRepLigne() != 0.0D) {
                  var10 = (float)var19.getCleRepLigne();
               }

               if (var19.getCleRepAtelier() != 0.0D) {
                  var11 = (float)var19.getCleRepAtelier();
               }

               if (var19.getCleRepDossier() != 0.0D) {
                  var12 = (float)var19.getCleRepDossier();
               }

               if (var19.getCleRepChantier() != 0.0D) {
                  var13 = (float)var19.getCleRepChantier();
               }

               if (var19.getCleRepMission() != 0.0D) {
                  var14 = (float)var19.getCleRepMission();
               }

               if (var19.getCleRepParc() != 0.0D) {
                  var15 = (float)var19.getCleRepParc();
               }

               if (var19.getCleRepAgent() != 0.0D) {
                  var16 = (float)var19.getCleRepAgent();
               }

               if (var19.getCleRepStr() != 0.0D) {
                  var17 = (float)var19.getCleRepStr();
               }

               if (var19.getCleRepActivite() == 0.0D) {
                  var19.setCleRepActivite((double)var3);
               }

               if (var19.getCleRepSite() == 0.0D) {
                  var19.setCleRepSite((double)var4);
               }

               if (var19.getCleRepDepartement() == 0.0D) {
                  var19.setCleRepDepartement((double)var5);
               }

               if (var19.getCleRepService() == 0.0D) {
                  var19.setCleRepService((double)var6);
               }

               if (var19.getCleRepRegion() == 0.0D) {
                  var19.setCleRepRegion((double)var7);
               }

               if (var19.getCleRepSecteur() == 0.0D) {
                  var19.setCleRepSecteur((double)var8);
               }

               if (var19.getCleRepPdv() == 0.0D) {
                  var19.setCleRepPdv((double)var9);
               }

               if (var19.getCleRepLigne() == 0.0D) {
                  var19.setCleRepLigne((double)var10);
               }

               if (var19.getCleRepAtelier() == 0.0D) {
                  var19.setCleRepAtelier((double)var11);
               }

               if (var19.getCleRepDossier() == 0.0D) {
                  var19.setCleRepDossier((double)var12);
               }

               if (var19.getCleRepParc() == 0.0D) {
                  var19.setCleRepParc((double)var15);
               }

               if (var19.getCleRepAgent() == 0.0D) {
                  var19.setCleRepAgent((double)var16);
               }

               var19.setCleOrdre(var18);
               var19.setPlansAnalytiques(this.plansAnalytiques);
               this.planAnalytiqueRepartitionDao.insert(var19, var1);
               ++var18;
            }
         } catch (HibernateException var23) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var23;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.dataModelRepartition.setWrappedData(this.lesPlanAnalytiqueRepartitions);
         if (this.lesPlanAnalytiqueRepartitions.size() != 0) {
            this.miseEnFormeResultat();
            this.testplbCptesup = true;
         } else {
            this.testplbCptesup = false;
         }
      }

      this.showModalPanelRepartition = false;
      this.recherche();
   }

   public void selectionCle() throws HibernateException, NamingException {
      if (this.dataModelLesPlansAnalytiques.isRowAvailable()) {
         this.plansAnalytiques = (PlansAnalytiques)this.dataModelLesPlansAnalytiques.getRowData();
         if (this.plansAnalytiques.getAnaInactif() == 1) {
            this.inactifPlb = true;
         } else {
            this.inactifPlb = false;
         }

         this.lesPlanAnalytiqueRepartitions.clear();
         this.lesPlanAnalytiqueRepartitions = this.planAnalytiqueRepartitionDao.chargerLesRepartitions((PlansAnalytiques)this.plansAnalytiques, (Session)null);
         this.dataModelRepartition.setWrappedData(this.lesPlanAnalytiqueRepartitions);
         if (this.lesPlanAnalytiqueRepartitions.size() != 0) {
            this.testplbCptesup = true;
         } else {
            this.testplbCptesup = false;
         }

         this.showButtonModif = true;
         if (this.plansAnalytiques.getAnaInactif() != 3) {
            this.showButtonSupp = true;
         } else {
            this.showButtonSupp = false;
         }

         this.calculTotal();
      }

   }

   public void ajouterCle() {
      this.plansAnalytiques = new PlansAnalytiques();
      this.lesPlanAnalytiqueRepartitions.clear();
      if (this.lesStructures.size() != 0) {
         for(int var1 = 0; var1 < this.lesStructures.size(); ++var1) {
            this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
            this.planAnalytiqueRepartition.setCleIdStr(((StructurePeg)this.lesStructures.get(var1)).getStrId());
            this.planAnalytiqueRepartition.setCleSigleStr(((StructurePeg)this.lesStructures.get(var1)).getStrsigle());
            this.planAnalytiqueRepartition.setCleNomStr(((StructurePeg)this.lesStructures.get(var1)).getStrraisonsociale());
            this.planAnalytiqueRepartition.setCleRepStr(0.0D);
            this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
         }
      }

      this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
      this.dataModelRepartition.setWrappedData(this.lesPlanAnalytiqueRepartitions);
      this.calculTotal();
      this.existCod = true;
      this.showModalPanelActivite = true;
   }

   public void modifierCle() {
      if (this.plansAnalytiques != null) {
         boolean var1 = false;
         if (this.lesStructures.size() != 0) {
            for(int var2 = 0; var2 < this.lesStructures.size(); ++var2) {
               long var3 = ((StructurePeg)this.lesStructures.get(var2)).getStrId();
               var1 = false;
               if (this.lesPlanAnalytiqueRepartitions.size() != 0) {
                  for(int var5 = 0; var5 < this.lesPlanAnalytiqueRepartitions.size(); ++var5) {
                     if (((PlanAnalytiqueRepartition)this.lesPlanAnalytiqueRepartitions.get(var5)).getCleIdStr() == var3) {
                        var1 = true;
                        break;
                     }
                  }
               }

               if (!var1) {
                  this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                  this.planAnalytiqueRepartition.setCleIdStr(((StructurePeg)this.lesStructures.get(var2)).getStrId());
                  this.planAnalytiqueRepartition.setCleSigleStr(((StructurePeg)this.lesStructures.get(var2)).getStrsigle());
                  this.planAnalytiqueRepartition.setCleNomStr(((StructurePeg)this.lesStructures.get(var2)).getStrraisonsociale());
                  this.planAnalytiqueRepartition.setCleRepStr(0.0D);
                  this.lesPlanAnalytiqueRepartitions.add(this.planAnalytiqueRepartition);
               }
            }
         }

         this.existCod = false;
         this.showModalPanelActivite = true;
      }

   }

   public void supprimerCle() throws HibernateException, NamingException {
      if (this.plansAnalytiques != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlansAnalytiques");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.lesPlanAnalytiqueRepartitions.size() != 0) {
               for(int var3 = 0; var3 < this.lesPlanAnalytiqueRepartitions.size(); ++var3) {
                  this.planAnalytiqueRepartition = (PlanAnalytiqueRepartition)this.lesPlanAnalytiqueRepartitions.get(var3);
                  this.planAnalytiqueRepartitionDao.deletelesRepartitions(this.plansAnalytiques, var1);
               }
            }

            this.plansAnalytiquesDao.delete(this.plansAnalytiques, var1);
            this.lesPlansAnalytiques.remove(this.plansAnalytiques);
            this.dataModelLesPlansAnalytiques.setWrappedData(this.lesPlansAnalytiques);
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

   }

   public void annuelerCle() {
      this.showButtonModif = false;
      this.showButtonSupp = false;
      this.showModalPanelActivite = false;
   }

   public void validerCle() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlansAnalytiques");
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         if (this.plansAnalytiques.getAnaInactif() <= 1) {
            if (this.inactifPlb) {
               this.plansAnalytiques.setAnaInactif(1);
            } else {
               this.plansAnalytiques.setAnaInactif(0);
            }
         }

         this.plansAnalytiques.setAnaAnnee("" + this.exoSelectionne.getExecpt_id());
         this.plansAnalytiques.setAnaStr(true);
         this.plansAnalytiques.setAnaNature("9");
         this.plansAnalytiques.setAnaNatureRepartition(200);
         this.plansAnalytiques.setAnaOrdre(this.getOrdre());
         if (this.plansAnalytiques.getAnaId() == 0L) {
            this.plansAnalytiques.setAnaDateCreat(new Date());
            this.plansAnalytiques.setAnaUserCreat(this.usersLog.getUsrid());
            this.plansAnalytiques = this.plansAnalytiquesDao.insert(this.plansAnalytiques, var1);
            this.lesPlansAnalytiques.add(this.plansAnalytiques);
            this.dataModelRepartition.setWrappedData(this.lesPlansAnalytiques);
         } else {
            this.plansAnalytiques.setAnaDateModif(new Date());
            this.plansAnalytiques.setAnaUserModif(this.usersLog.getUsrid());
            this.plansAnalytiques = this.plansAnalytiquesDao.modif(this.plansAnalytiques, var1);
         }

         if (this.lesPlanAnalytiqueRepartitions.size() != 0) {
            for(int var3 = 0; var3 < this.lesPlanAnalytiqueRepartitions.size(); ++var3) {
               this.planAnalytiqueRepartition = (PlanAnalytiqueRepartition)this.lesPlanAnalytiqueRepartitions.get(var3);
               if (this.planAnalytiqueRepartition.getCleRepStr() != 0.0D) {
                  if (this.planAnalytiqueRepartition.getCleId() == 0L) {
                     this.planAnalytiqueRepartition.setPlansAnalytiques(this.plansAnalytiques);
                     this.planAnalytiqueRepartition = this.planAnalytiqueRepartitionDao.insert(this.planAnalytiqueRepartition, var1);
                  } else {
                     this.planAnalytiqueRepartition = this.planAnalytiqueRepartitionDao.modif(this.planAnalytiqueRepartition, var1);
                  }
               } else if (this.planAnalytiqueRepartition.getCleId() != 0L) {
                  this.planAnalytiqueRepartitionDao.deletelesRepartitions(this.plansAnalytiques, var1);
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

      this.showModalPanelActivite = false;
   }

   public void calculTotal() {
      this.totRepartition = 0.0D;
      if (this.lesPlanAnalytiqueRepartitions.size() != 0) {
         for(int var1 = 0; var1 < this.lesPlanAnalytiqueRepartitions.size(); ++var1) {
            this.totRepartition += ((PlanAnalytiqueRepartition)this.lesPlanAnalytiqueRepartitions.get(var1)).getCleRepStr();
         }
      }

   }

   public void verifCle() throws HibernateException, NamingException {
      this.existCod = false;
      this.existCod = this.plansAnalytiquesDao.existCode("9", this.plansAnalytiques.getAnaCode(), (Session)null);
   }

   public void majClesStructure() throws HibernateException, NamingException {
      if (this.lesPlansAnalytiques.size() != 0) {
         new PlansAnalytiques();
         new PlanAnalytiqueRepartition();
         new ArrayList();

         for(int var4 = 0; var4 < this.lesPlansAnalytiques.size(); ++var4) {
            this.plansAnalytiques = (PlansAnalytiques)this.lesPlansAnalytiques.get(var4);
            this.lesPlanAnalytiqueRepartitions.clear();
            this.lesPlanAnalytiqueRepartitions = this.planAnalytiqueRepartitionDao.chargerLesRepartitions((PlansAnalytiques)this.plansAnalytiques, (Session)null);
            if (this.lesStructures.size() != 0) {
               for(int var5 = 0; var5 < this.lesStructures.size(); ++var5) {
                  String var6 = "structure" + ((StructurePeg)this.lesStructures.get(var5)).getStrId();
                  StructureDao var7 = new StructureDao(var6, this.utilInitHibernate);
                  Session var8 = this.utilInitHibernate.getOpenSession(var6, "PlansAnalytiques");
                  Transaction var9 = null;

                  try {
                     var9 = var8.beginTransaction();
                     PlansAnalytiques var1 = this.plansAnalytiquesDao.rechercheAnal("9", this.plansAnalytiques.getAnaCode(), var8);
                     if (var1 != null) {
                        var1.setAnaNatureRepartition(this.plansAnalytiques.getAnaNatureRepartition());
                        var1.setAnaNomFr(this.plansAnalytiques.getAnaNomFr());
                        var1.setAnaAch(true);
                        var1.setAnaFrg(true);
                        var1.setAnaInv(true);
                        var1.setAnaPrd(true);
                        var1.setAnaSal(true);
                        var1.setAnaTax(true);
                        var1.setAnaTva(true);
                        var1.setAnaVte(true);
                        var1.setAnaStr(true);
                        var1.setAnaDateModif(this.plansAnalytiques.getAnaDateModif());
                        var1.setAnaUserModif(this.plansAnalytiques.getAnaUserModif());
                        var1 = this.plansAnalytiquesDao.modif(var1, var8);
                     } else {
                        var1 = new PlansAnalytiques();
                        var1.setAnaCode(this.plansAnalytiques.getAnaCode());
                        var1.setAnaNature(this.plansAnalytiques.getAnaNature());
                        var1.setAnaNatureRepartition(this.plansAnalytiques.getAnaNatureRepartition());
                        var1.setAnaNomFr(this.plansAnalytiques.getAnaNomFr());
                        var1.setAnaAch(true);
                        var1.setAnaFrg(true);
                        var1.setAnaInv(true);
                        var1.setAnaPrd(true);
                        var1.setAnaSal(true);
                        var1.setAnaTax(true);
                        var1.setAnaTva(true);
                        var1.setAnaVte(true);
                        var1.setAnaStr(true);
                        var1.setAnaDateCreat(this.plansAnalytiques.getAnaDateCreat());
                        var1.setAnaUserCreat(this.plansAnalytiques.getAnaUserCreat());
                        var1 = this.plansAnalytiquesDao.insert(var1, var8);
                     }

                     List var3 = this.planAnalytiqueRepartitionDao.chargerLesRepartitions(var1, var8);
                     PlanAnalytiqueRepartition var2;
                     int var10;
                     if (var3.size() != 0) {
                        for(var10 = 0; var10 < var3.size(); ++var10) {
                           var2 = (PlanAnalytiqueRepartition)var3.get(var10);
                           this.planAnalytiqueRepartitionDao.delete(var2, var8);
                        }
                     }

                     if (this.lesPlanAnalytiqueRepartitions.size() != 0) {
                        for(var10 = 0; var10 < this.lesPlanAnalytiqueRepartitions.size(); ++var10) {
                           var2 = (PlanAnalytiqueRepartition)this.lesPlanAnalytiqueRepartitions.get(var10);
                           var2.setPlansAnalytiques(var1);
                           this.planAnalytiqueRepartitionDao.insert(var2, var8);
                        }
                     }

                     new Structure();
                     Structure var16 = var7.logStructureId(((StructurePeg)this.lesStructures.get(var5)).getStrId(), var8);
                     if (var16 != null) {
                        var16.setStrStructure(true);
                        var7.modStructure(var16, var8);
                     }

                     var9.commit();
                  } catch (HibernateException var14) {
                     if (var9 != null) {
                        var9.rollback();
                     }

                     throw var14;
                  } finally {
                     this.utilInitHibernate.closeSession();
                  }
               }
            }
         }
      }

   }

   public long getIdPlbEncours() {
      return this.idPlbEncours;
   }

   public void setIdPlbEncours(long var1) {
      this.idPlbEncours = var1;
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

   public boolean isExistCod() {
      return this.existCod;
   }

   public void setExistCod(boolean var1) {
      this.existCod = var1;
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

   public boolean isTestMode() {
      return this.testMode;
   }

   public void setTestMode(boolean var1) {
      this.testMode = var1;
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

   public DataModel getDataModelLesPlansAnalytiques() {
      return this.dataModelLesPlansAnalytiques;
   }

   public void setDataModelLesPlansAnalytiques(DataModel var1) {
      this.dataModelLesPlansAnalytiques = var1;
   }

   public List getLesPlansAnalytiques() {
      return this.lesPlansAnalytiques;
   }

   public void setLesPlansAnalytiques(List var1) {
      this.lesPlansAnalytiques = var1;
   }

   public PlansAnalytiques getPlansAnalytiques() {
      return this.plansAnalytiques;
   }

   public void setPlansAnalytiques(PlansAnalytiques var1) {
      this.plansAnalytiques = var1;
   }

   public List getLesPlanAnalytiqueRepartitions() {
      return this.lesPlanAnalytiqueRepartitions;
   }

   public void setLesPlanAnalytiqueRepartitions(List var1) {
      this.lesPlanAnalytiqueRepartitions = var1;
   }

   public PlanAnalytiqueRepartition getPlanAnalytiqueRepartition() {
      return this.planAnalytiqueRepartition;
   }

   public void setPlanAnalytiqueRepartition(PlanAnalytiqueRepartition var1) {
      this.planAnalytiqueRepartition = var1;
   }

   public boolean isShowModalPanelRepartition() {
      return this.showModalPanelRepartition;
   }

   public void setShowModalPanelRepartition(boolean var1) {
      this.showModalPanelRepartition = var1;
   }

   public boolean isTestplbCptesup() {
      return this.testplbCptesup;
   }

   public void setTestplbCptesup(boolean var1) {
      this.testplbCptesup = var1;
   }

   public String getVar_libelle() {
      return this.var_libelle;
   }

   public void setVar_libelle(String var1) {
      this.var_libelle = var1;
   }

   public int getNatureRepartition() {
      return this.natureRepartition;
   }

   public void setNatureRepartition(int var1) {
      this.natureRepartition = var1;
   }

   public List getLesActivites() {
      return this.lesActivites;
   }

   public void setLesActivites(List var1) {
      this.lesActivites = var1;
   }

   public List getLesDossiers() {
      return this.lesDossiers;
   }

   public void setLesDossiers(List var1) {
      this.lesDossiers = var1;
   }

   public List getLesParcs() {
      return this.lesParcs;
   }

   public void setLesParcs(List var1) {
      this.lesParcs = var1;
   }

   public boolean isAffiche_activite() {
      return this.affiche_activite;
   }

   public void setAffiche_activite(boolean var1) {
      this.affiche_activite = var1;
   }

   public boolean isAffiche_agent() {
      return this.affiche_agent;
   }

   public void setAffiche_agent(boolean var1) {
      this.affiche_agent = var1;
   }

   public int getAffiche_dossier() {
      return this.affiche_dossier;
   }

   public void setAffiche_dossier(int var1) {
      this.affiche_dossier = var1;
   }

   public boolean isAffiche_ligne() {
      return this.affiche_ligne;
   }

   public void setAffiche_ligne(boolean var1) {
      this.affiche_ligne = var1;
   }

   public boolean isAffiche_parc() {
      return this.affiche_parc;
   }

   public void setAffiche_parc(boolean var1) {
      this.affiche_parc = var1;
   }

   public boolean isAffiche_region() {
      return this.affiche_region;
   }

   public void setAffiche_region(boolean var1) {
      this.affiche_region = var1;
   }

   public boolean isAffiche_site() {
      return this.affiche_site;
   }

   public void setAffiche_site(boolean var1) {
      this.affiche_site = var1;
   }

   public List getLesRegSecPdv() {
      return this.lesRegSecPdv;
   }

   public void setLesRegSecPdv(List var1) {
      this.lesRegSecPdv = var1;
   }

   public List getLesSitDepSer() {
      return this.lesSitDepSer;
   }

   public void setLesSitDepSer(List var1) {
      this.lesSitDepSer = var1;
   }

   public List getLesSitLigAte() {
      return this.lesSitLigAte;
   }

   public void setLesSitLigAte(List var1) {
      this.lesSitLigAte = var1;
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

   public boolean isAffiche_pdv() {
      return this.affiche_pdv;
   }

   public void setAffiche_pdv(boolean var1) {
      this.affiche_pdv = var1;
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

   public boolean isAffiche_sitePrdv() {
      return this.affiche_sitePrdv;
   }

   public void setAffiche_sitePrdv(boolean var1) {
      this.affiche_sitePrdv = var1;
   }

   public boolean isMode_calcul() {
      return this.mode_calcul;
   }

   public void setMode_calcul(boolean var1) {
      this.mode_calcul = var1;
   }

   public DataModel getDataModelRepartition() {
      return this.dataModelRepartition;
   }

   public void setDataModelRepartition(DataModel var1) {
      this.dataModelRepartition = var1;
   }

   public List getLesAgents() {
      return this.lesAgents;
   }

   public void setLesAgents(List var1) {
      this.lesAgents = var1;
   }

   public boolean isShowModalPanelActivite() {
      return this.showModalPanelActivite;
   }

   public void setShowModalPanelActivite(boolean var1) {
      this.showModalPanelActivite = var1;
   }

   public List getMesAxesAnalytique() {
      return this.mesAxesAnalytique;
   }

   public void setMesAxesAnalytique(List var1) {
      this.mesAxesAnalytique = var1;
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

   public List getMesAnneeSelectionneeItems() {
      return this.mesAnneeSelectionneeItems;
   }

   public void setMesAnneeSelectionneeItems(List var1) {
      this.mesAnneeSelectionneeItems = var1;
   }

   public String getVar_annee_selectionnee() {
      return this.var_annee_selectionnee;
   }

   public void setVar_annee_selectionnee(String var1) {
      this.var_annee_selectionnee = var1;
   }

   public List getMesdevisesItems() {
      return this.mesdevisesItems;
   }

   public void setMesdevisesItems(List var1) {
      this.mesdevisesItems = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public List getLesStructures() {
      return this.lesStructures;
   }

   public void setLesStructures(List var1) {
      this.lesStructures = var1;
   }

   public double getTotRepartition() {
      return this.totRepartition;
   }

   public void setTotRepartition(double var1) {
      this.totRepartition = var1;
   }

   public List getLesProjets() {
      return this.lesProjets;
   }

   public void setLesProjets(List var1) {
      this.lesProjets = var1;
   }

   public List getLesChantiers() {
      return this.lesChantiers;
   }

   public void setLesChantiers(List var1) {
      this.lesChantiers = var1;
   }

   public List getLesMissions() {
      return this.lesMissions;
   }

   public void setLesMissions(List var1) {
      this.lesMissions = var1;
   }

   public boolean isAffiche_chantier() {
      return this.affiche_chantier;
   }

   public void setAffiche_chantier(boolean var1) {
      this.affiche_chantier = var1;
   }

   public boolean isAffiche_mission() {
      return this.affiche_mission;
   }

   public void setAffiche_mission(boolean var1) {
      this.affiche_mission = var1;
   }

   public boolean isAffiche_str() {
      return this.affiche_str;
   }

   public void setAffiche_str(boolean var1) {
      this.affiche_str = var1;
   }

   public boolean isModuleParc() {
      return this.moduleParc;
   }

   public void setModuleParc(boolean var1) {
      this.moduleParc = var1;
   }

   public boolean isModulePaye() {
      return this.modulePaye;
   }

   public void setModulePaye(boolean var1) {
      this.modulePaye = var1;
   }

   public boolean isModuleProjet() {
      return this.moduleProjet;
   }

   public void setModuleProjet(boolean var1) {
      this.moduleProjet = var1;
   }

   public boolean isModuleUsine() {
      return this.moduleUsine;
   }

   public void setModuleUsine(boolean var1) {
      this.moduleUsine = var1;
   }
}
