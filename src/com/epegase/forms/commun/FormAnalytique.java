package com.epegase.forms.commun;

import com.epegase.systeme.classe.Activites;
import com.epegase.systeme.classe.Budget;
import com.epegase.systeme.classe.BudgetLigne;
import com.epegase.systeme.classe.CleAnalytique;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresAnalytique;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlanAnalytiqueRepartition;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.PointDeVente;
import com.epegase.systeme.classe.ProductionAtelier;
import com.epegase.systeme.classe.ProductionLigne;
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.BudgetDao;
import com.epegase.systeme.dao.BudgetLigneDao;
import com.epegase.systeme.dao.CleAnalytiqueDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.EcrituresAnalytiquesDao;
import com.epegase.systeme.dao.EcrituresDao;
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
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.OptionComptabilite;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormAnalytique implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int nature;
   private UtilNombre utilNombre;
   private boolean affiche_activite = false;
   private boolean decoupageActivite = false;
   private boolean affiche_site = false;
   private boolean affiche_region = false;
   private boolean affiche_sitePrdv = false;
   private boolean affiche_anal1 = false;
   private boolean affiche_anal2 = false;
   private boolean affiche_anal3 = false;
   private boolean affiche_anal4 = false;
   private boolean affiche_str = false;
   private boolean affiche_cles = false;
   private boolean affiche_agent = false;
   private boolean affiche_autre = false;
   private boolean affiche_projet = false;
   private OptionComptabilite optionComptabilite;
   private EcrituresAnalytique ecrituresAnalytique;
   private EcrituresAnalytiquesDao ecrituresAnalytiquesDao;
   private BudgetLigne budgetLigne;
   private BudgetLigneDao budgetLigneDao;
   private String reamenagement;
   private Activites activites;
   private ActivitesDao activitesDao;
   private PlansAnalytiques plansAnalytiques;
   private PlansAnalytiquesDao plansAnalytiquesDao;
   private PlanAnalytiqueRepartition planAnalytiqueRepartition;
   private PlanAnalytiqueRepartitionDao planAnalytiqueRepartitionDao;
   private Site site;
   private SiteDao siteDao;
   private Departement departement;
   private DepartementDao departementDao;
   private Service service;
   private ServiceDao serviceDao;
   private Region region;
   private RegionDao regionDao;
   private Secteur secteur;
   private SecteurDao secteurDao;
   private PointDeVente pdv;
   private PointDeVenteDao pdvDao;
   private ProductionLigne productionLigne;
   private ProductionLigneDao productionLigneDao;
   private ProductionAtelier productionAtelier;
   private ProductionAtelierDao productionAtelierDao;
   private Parc parc;
   private ParcDao parcDao;
   private Salaries salaries;
   private SalariesDao salariesDao;
   private CleAnalytique cleAnalytique;
   private CleAnalytiqueDao cleAnalytiqueDao;
   private ProjetsDao projetsDao;
   private BudgetDao budgetDao;
   private EcrituresAnalytiqueCtrl analytiqueCtrl01;
   private EcrituresAnalytiqueCtrl analytiqueCtrl02;
   private EcrituresAnalytiqueCtrl analytiqueCtrl03;
   private EcrituresAnalytiqueCtrl analytiqueCtrl04;
   private EcrituresAnalytiqueCtrl analytiqueCtrl05;
   private EcrituresAnalytiqueCtrl analytiqueCtrl06;
   private EcrituresAnalytiqueCtrl analytiqueCtrl07;
   private EcrituresAnalytiqueCtrl analytiqueCtrl08;
   private EcrituresAnalytiqueCtrl analytiqueCtrl09;
   private EcrituresAnalytiqueCtrl analytiqueCtrl10;
   private EcrituresAnalytiqueCtrl analytiqueCtrl11;
   private EcrituresAnalytiqueCtrl analytiqueCtrl12;
   private EcrituresAnalytiqueCtrl analytiqueCtrl13;
   private List lesSitesItems;
   private List lesDepartementsItems;
   private List lesServicesItems;
   private List lesRegionsItems;
   private List lesSecteursItems;
   private List lesPdvItems;
   private List lesSitesPrdItems;
   private List lesAteliersItems;
   private List lesLignesItems;
   private List lesColonnes1Items;
   private List lesColonnes2Items;
   private List lesColonnes3Items;
   private List lesClesStandardsItems;
   private List lesClesStructureItems;
   private List lesProjetsItems;
   private List lesEntitesItems;
   private List lesPostesItems;
   private String cleStandard;
   private String cleStructure;
   private transient DataModel dataModelAxe01;
   private transient DataModel dataModelAxe02;
   private transient DataModel dataModelAxe03;
   private transient DataModel dataModelAxe04;
   private transient DataModel dataModelAxe05;
   private transient DataModel dataModelAxe06;
   private transient DataModel dataModelAxe07;
   private transient DataModel dataModelAxe08;
   private transient DataModel dataModelAxe09;
   private transient DataModel dataModelAxe10;
   private transient DataModel dataModelAxe11;
   private transient DataModel dataModelAxe12;
   private transient DataModel dataModelAxe13;
   private List listeAxe01;
   private List listeAxe02;
   private List listeAxe03;
   private List listeAxe04;
   private List listeAxe05;
   private List listeAxe06;
   private List listeAxe07;
   private List listeAxe08;
   private List listeAxe09;
   private List listeAxe10;
   private List listeAxe11;
   private List listeAxe12;
   private List listeAxe13;
   private int util_axe01;
   private int util_axe02;
   private int util_axe03;
   private int util_axe04;
   private int util_axe05;
   private int util_axe06;
   private int util_axe07;
   private int util_axe08;
   private int util_axe09;
   private int util_axe10;
   private int util_axe11;
   private int util_axe12;
   private int util_axe13;
   private String deviseEcriture;
   double montantAImputer = 0.0D;
   float qteAImputer = 0.0F;
   int sens = 0;
   double totImputation01;
   double ecart01;
   double totImputation02;
   double ecart02;
   double totImputation03;
   double ecart03;
   double totImputation04;
   double ecart04;
   double totImputation05;
   double ecart05;
   double totImputation06;
   double ecart06;
   double totImputation07;
   double ecart07;
   double totImputation08;
   double ecart08;
   double totImputation09;
   double ecart09;
   double totImputation10;
   double ecart10;
   double totImputation11;
   double ecart11;
   double totImputation12;
   double ecart12;
   double totImputation13;
   double ecart13;
   private boolean var_valide_analytique;
   private boolean modeConsultation;
   private String ongletActif;
   private String libelleRecherche;
   private ObjetCompte objetCompte;
   private boolean selectObjet;
   private int natureCleRepartition;
   private transient DataModel dataModelRecherche;
   private boolean showModalPanelRecherche = false;
   private boolean modeTransit = false;
   private List lesImputDossiers;
   private transient DataModel dataModelImputDossier;
   private double totDebit;
   private double totCredit;
   private double totSolde;
   private boolean showModalPanelAxe04 = false;
   private boolean boutonAxe04 = false;
   private int ajoutAxe04;

   public FormAnalytique(String var1, Structure var2, Users var3, UtilInitHibernate var4) {
      this.baseLog = var1;
      this.structureLog = var2;
      this.usersLog = var3;
      this.utilInitHibernate = var4;
      this.lesSitesItems = new ArrayList();
      this.lesSitesPrdItems = new ArrayList();
      this.lesLignesItems = new ArrayList();
      this.lesAteliersItems = new ArrayList();
      this.lesDepartementsItems = new ArrayList();
      this.lesServicesItems = new ArrayList();
      this.lesRegionsItems = new ArrayList();
      this.lesSecteursItems = new ArrayList();
      this.lesPdvItems = new ArrayList();
      this.lesColonnes1Items = new ArrayList();
      this.lesColonnes2Items = new ArrayList();
      this.lesColonnes3Items = new ArrayList();
      this.lesClesStandardsItems = new ArrayList();
      this.lesClesStructureItems = new ArrayList();
      this.lesProjetsItems = new ArrayList();
      this.lesEntitesItems = new ArrayList();
      this.lesPostesItems = new ArrayList();
      this.dataModelAxe01 = new ListDataModel();
      this.dataModelAxe02 = new ListDataModel();
      this.dataModelAxe03 = new ListDataModel();
      this.dataModelAxe04 = new ListDataModel();
      this.dataModelAxe05 = new ListDataModel();
      this.dataModelAxe06 = new ListDataModel();
      this.dataModelAxe07 = new ListDataModel();
      this.dataModelAxe08 = new ListDataModel();
      this.dataModelAxe09 = new ListDataModel();
      this.dataModelAxe10 = new ListDataModel();
      this.dataModelAxe11 = new ListDataModel();
      this.dataModelAxe12 = new ListDataModel();
      this.dataModelAxe13 = new ListDataModel();
      this.listeAxe01 = new ArrayList();
      this.listeAxe02 = new ArrayList();
      this.listeAxe03 = new ArrayList();
      this.listeAxe04 = new ArrayList();
      this.listeAxe05 = new ArrayList();
      this.listeAxe06 = new ArrayList();
      this.listeAxe07 = new ArrayList();
      this.listeAxe08 = new ArrayList();
      this.listeAxe09 = new ArrayList();
      this.listeAxe10 = new ArrayList();
      this.listeAxe11 = new ArrayList();
      this.listeAxe12 = new ArrayList();
      this.listeAxe13 = new ArrayList();
      this.dataModelRecherche = new ListDataModel();
      this.utilNombre = new UtilNombre();
      this.lesImputDossiers = new ArrayList();
      this.dataModelImputDossier = new ListDataModel();
   }

   public void initAnalytique(OptionComptabilite var1, Session var2) throws HibernateException, NamingException {
      this.optionComptabilite = var1;
      this.affiche_site = false;
      this.affiche_region = false;
      this.affiche_sitePrdv = false;
      this.affiche_activite = false;
      this.decoupageActivite = false;
      this.affiche_agent = false;
      this.affiche_anal1 = false;
      this.affiche_anal2 = false;
      this.affiche_anal3 = false;
      this.affiche_anal4 = false;
      this.affiche_projet = false;
      this.affiche_cles = false;
      this.affiche_str = false;
      if (this.structureLog.isStrSite()) {
         this.affiche_site = true;
         this.chargerSitesItems(var2);
      }

      if (this.structureLog.isStrRegion()) {
         this.affiche_region = true;
         this.chargerLesRegionsItems(var2);
      }

      if (this.structureLog.getStrtypeentreprise().equals("2") && this.structureLog.isStrUsine()) {
         this.affiche_sitePrdv = true;
         this.chargerSitesPrdItems(var2);
      }

      if (this.structureLog.isStrActivite()) {
         this.affiche_activite = true;
         this.chargersActivites(var2);
         if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
            this.decoupageActivite = true;
         } else {
            this.decoupageActivite = false;
         }
      }

      if (this.rechercheModule(70000) && this.structureLog.isStrParc()) {
         this.affiche_anal2 = true;
      }

      if (this.structureLog.getStrDossier() == 1) {
         this.affiche_anal4 = true;
      }

      if (this.rechercheModule(50000) && this.structureLog.isStrAgent()) {
         this.affiche_agent = true;
      }

      if (this.structureLog.isStrChantier()) {
         this.affiche_anal1 = true;
      }

      if (this.structureLog.isStrMission()) {
         this.affiche_anal3 = true;
      }

      if (this.structureLog.isStrCles()) {
         this.affiche_cles = true;
         this.chargerClesStandards(var2);
      }

      if (this.structureLog.isStrStructure()) {
         this.affiche_str = true;
         this.chargerClesStructure(var2);
      }

      if (!this.rechercheModule(40300) && this.optionComptabilite.getBudget().equals("true")) {
         this.affiche_projet = true;
         this.chargerProjets(0, var2);
         if (this.lesProjetsItems.size() == 0) {
            this.affiche_projet = false;
         }
      }

      this.util_axe01 = 0;
      this.util_axe02 = 0;
      this.util_axe03 = 0;
      this.util_axe04 = 0;
      this.util_axe05 = 0;
      this.util_axe06 = 0;
      this.util_axe07 = 0;
      this.util_axe08 = 0;
      this.util_axe09 = 0;
      this.util_axe10 = 0;
      this.util_axe11 = 0;
      this.util_axe12 = 0;
      this.util_axe13 = 0;
   }

   public boolean testCompteBudget(Ecritures var1) {
      boolean var2 = false;
      if (var1.getEcrNature() == 1) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c1());
      } else if (var1.getEcrNature() == 2) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c2());
      } else if (var1.getEcrNature() == 3) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c3());
      } else if (var1.getEcrNature() == 4) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c4());
      } else if (var1.getEcrNature() == 5) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c5());
      } else if (var1.getEcrNature() == 6) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c6());
      } else if (var1.getEcrNature() == 7) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c7());
      } else if (var1.getEcrNature() == 8) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c8());
      } else if (var1.getEcrNature() == 9) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c9());
      } else if (var1.getEcrNature() == 10) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c10());
      } else if (var1.getEcrNature() == 11) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c11());
      } else if (var1.getEcrNature() == 12) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c12());
      } else if (var1.getEcrNature() == 13) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c13());
      } else if (var1.getEcrNature() == 14) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c14());
      } else if (var1.getEcrNature() == 15) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c15());
      } else if (var1.getEcrNature() == 16) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c16());
      } else if (var1.getEcrNature() == 17) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c17());
      } else if (var1.getEcrNature() == 18) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c18());
      } else if (var1.getEcrNature() == 19) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c19());
      } else if (var1.getEcrNature() == 20) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c20());
      } else if (var1.getEcrNature() == 21) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c21());
      } else if (var1.getEcrNature() == 22) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c22());
      } else if (var1.getEcrNature() == 23) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c23());
      } else if (var1.getEcrNature() == 24) {
         var2 = Boolean.parseBoolean(this.optionComptabilite.getBud_c24());
      }

      return var2;
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

   public void chargerSitesItems() throws HibernateException, NamingException {
      this.chargerSitesItems((Session)null);
   }

   public void chargerSitesItems(Session var1) throws HibernateException, NamingException {
      this.lesSitesItems.clear();
      if (this.siteDao == null) {
         this.siteDao = new SiteDao(this.baseLog, this.utilInitHibernate);
      }

      this.lesSitesItems = this.siteDao.chargerLesSitesItems(var1);
      this.lesDepartementsItems.clear();
      this.lesServicesItems.clear();
      if (this.analytiqueCtrl01 != null) {
         this.analytiqueCtrl01.setZoneDepartement("");
         this.analytiqueCtrl01.setEcranaDepartement("");
         this.analytiqueCtrl01.setEcranaDepartementLib("");
         this.analytiqueCtrl01.setMesDepartementsItems(new ArrayList());
         this.analytiqueCtrl01.setDepVide(true);
         this.analytiqueCtrl01.setZoneService("");
         this.analytiqueCtrl01.setEcranaService("");
         this.analytiqueCtrl01.setEcranaServiceLib("");
         this.analytiqueCtrl01.setMesServicesItems(new ArrayList());
         this.analytiqueCtrl01.setSerVide(true);
      }

   }

   public void chargerDepartementsItems() throws HibernateException, NamingException {
      this.chargerDepartementsItems((Session)null);
   }

   public void chargerDepartementsItems(Session var1) throws HibernateException, NamingException {
      this.lesDepartementsItems.clear();
      if (this.analytiqueCtrl01.getZoneSite() != null && !this.analytiqueCtrl01.getZoneSite().isEmpty() && this.analytiqueCtrl01.getZoneSite().contains(":")) {
         String[] var2 = this.analytiqueCtrl01.getZoneSite().split(":");
         this.analytiqueCtrl01.setEcranaSite(var2[0]);
         this.analytiqueCtrl01.setEcranaSiteLib(var2[1]);
         new ArrayList();
         if (this.departementDao == null) {
            this.departementDao = new DepartementDao(this.baseLog, this.utilInitHibernate);
         }

         List var3 = this.departementDao.listDepartementBySit(var2[0], var1);
         if (var3.size() != 0) {
            for(int var4 = 0; var4 < var3.size(); ++var4) {
               this.lesDepartementsItems.add(new SelectItem(((Departement)var3.get(var4)).getDepCode() + ":" + ((Departement)var3.get(var4)).getDepNomFr()));
            }

            this.analytiqueCtrl01.setDepVide(false);
         }

         this.analytiqueCtrl01.setMesDepartementsItems(this.lesDepartementsItems);
      }

      this.lesServicesItems.clear();
      if (this.analytiqueCtrl01 != null) {
         this.analytiqueCtrl01.setZoneService("");
         this.analytiqueCtrl01.setEcranaService("");
         this.analytiqueCtrl01.setEcranaServiceLib("");
         this.analytiqueCtrl01.setMesServicesItems(new ArrayList());
         this.analytiqueCtrl01.setSerVide(true);
      }

   }

   public void chargerServicesItems() throws HibernateException, NamingException {
      this.chargerServicesItems((Session)null);
   }

   public void chargerServicesItems(Session var1) throws HibernateException, NamingException {
      this.lesServicesItems.clear();
      if (this.analytiqueCtrl01.getZoneDepartement() != null && !this.analytiqueCtrl01.getZoneDepartement().isEmpty() && this.analytiqueCtrl01.getZoneDepartement().contains(":")) {
         String[] var2 = this.analytiqueCtrl01.getZoneDepartement().split(":");
         this.analytiqueCtrl01.setEcranaDepartement(var2[0]);
         this.analytiqueCtrl01.setEcranaDepartementLib(var2[1]);
         if (this.serviceDao == null) {
            this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
         }

         new ArrayList();
         List var3 = this.serviceDao.listServiceByDep(var2[0], var1);
         if (var3.size() != 0) {
            for(int var4 = 0; var4 < var3.size(); ++var4) {
               this.lesServicesItems.add(new SelectItem(((Service)var3.get(var4)).getSerCode() + ":" + ((Service)var3.get(var4)).getSerNomFr()));
            }

            this.analytiqueCtrl01.setSerVide(false);
         }

         this.analytiqueCtrl01.setMesServicesItems(this.lesServicesItems);
      }

   }

   public void calculerServicesItems() throws HibernateException, NamingException {
      if (this.analytiqueCtrl01.getZoneService() != null && !this.analytiqueCtrl01.getZoneService().isEmpty() && this.analytiqueCtrl01.getZoneService().contains(":")) {
         String[] var1 = this.analytiqueCtrl01.getZoneService().split(":");
         this.analytiqueCtrl01.setEcranaService(var1[0]);
         this.analytiqueCtrl01.setEcranaServiceLib(var1[1]);
      }

   }

   public void chargerLesRegionsItems() throws HibernateException, NamingException {
      this.chargerLesRegionsItems((Session)null);
   }

   public void chargerLesRegionsItems(Session var1) throws HibernateException, NamingException {
      this.lesRegionsItems.clear();
      if (this.regionDao == null) {
         this.regionDao = new RegionDao(this.baseLog, this.utilInitHibernate);
      }

      this.lesRegionsItems = this.regionDao.chargerLesRegionItems(var1);
      this.lesSecteursItems.clear();
      this.lesPdvItems.clear();
      if (this.analytiqueCtrl02 != null) {
         this.analytiqueCtrl02.setZoneSecteur("");
         this.analytiqueCtrl02.setEcranaSecteur("");
         this.analytiqueCtrl02.setEcranaSecteurLib("");
         this.analytiqueCtrl02.setMesSecteursItems(new ArrayList());
         this.analytiqueCtrl02.setSecVide(true);
         this.analytiqueCtrl02.setZonePdv("");
         this.analytiqueCtrl02.setEcranaPdv("");
         this.analytiqueCtrl02.setEcranaPdvLib("");
         this.analytiqueCtrl02.setMesPdvItems(new ArrayList());
         this.analytiqueCtrl02.setPdvVide(true);
      }

   }

   public void chargerSecteursItems() throws HibernateException, NamingException {
      this.chargerSecteursItems((Session)null);
   }

   public void chargerSecteursItems(Session var1) throws HibernateException, NamingException {
      this.lesSecteursItems.clear();
      if (this.analytiqueCtrl02.getZoneRegion() != null && !this.analytiqueCtrl02.getZoneRegion().isEmpty() && this.analytiqueCtrl02.getZoneRegion().contains(":")) {
         String[] var2 = this.analytiqueCtrl02.getZoneRegion().split(":");
         this.analytiqueCtrl02.setEcranaRegion(var2[0]);
         this.analytiqueCtrl02.setEcranaRegionLib(var2[1]);
         new ArrayList();
         if (this.secteurDao == null) {
            this.secteurDao = new SecteurDao(this.baseLog, this.utilInitHibernate);
         }

         List var3 = this.secteurDao.listSecteurByRegion(var2[0], var1);
         if (var3.size() != 0) {
            for(int var4 = 0; var4 < var3.size(); ++var4) {
               this.lesSecteursItems.add(new SelectItem(((Secteur)var3.get(var4)).getSecCode() + ":" + ((Secteur)var3.get(var4)).getSecNomFr()));
            }

            this.analytiqueCtrl02.setSecVide(false);
         }

         this.analytiqueCtrl02.setMesSecteursItems(this.lesSecteursItems);
      }

      this.lesPdvItems.clear();
      if (this.analytiqueCtrl02 != null) {
         this.analytiqueCtrl02.setZonePdv("");
         this.analytiqueCtrl02.setEcranaPdv("");
         this.analytiqueCtrl02.setEcranaPdvLib("");
         this.analytiqueCtrl02.setMesPdvItems(new ArrayList());
         this.analytiqueCtrl02.setPdvVide(true);
      }

   }

   public void chargerPdvItems() throws HibernateException, NamingException {
      this.chargerPdvItems((Session)null);
   }

   public void chargerPdvItems(Session var1) throws HibernateException, NamingException {
      this.lesPdvItems.clear();
      if (this.analytiqueCtrl02.getZoneSecteur() != null && !this.analytiqueCtrl02.getZoneSecteur().isEmpty() && this.analytiqueCtrl02.getZoneSecteur().contains(":")) {
         String[] var2 = this.analytiqueCtrl02.getZoneSecteur().split(":");
         this.analytiqueCtrl02.setEcranaSecteur(var2[0]);
         this.analytiqueCtrl02.setEcranaSecteurLib(var2[1]);
         new ArrayList();
         if (this.pdvDao == null) {
            this.pdvDao = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
         }

         List var3 = this.pdvDao.listPdvBySecteur(var2[0], var1);
         if (var3.size() != 0) {
            for(int var4 = 0; var4 < var3.size(); ++var4) {
               this.lesPdvItems.add(new SelectItem(((PointDeVente)var3.get(var4)).getPdvCode() + ":" + ((PointDeVente)var3.get(var4)).getPdvNomFr()));
            }

            this.analytiqueCtrl02.setPdvVide(false);
         }

         this.analytiqueCtrl02.setMesPdvItems(this.lesPdvItems);
      }

   }

   public void calculerPdvItems() throws HibernateException, NamingException {
      if (this.analytiqueCtrl02.getZonePdv() != null && !this.analytiqueCtrl02.getZonePdv().isEmpty() && this.analytiqueCtrl02.getZonePdv().contains(":")) {
         String[] var1 = this.analytiqueCtrl02.getZonePdv().split(":");
         this.analytiqueCtrl02.setEcranaPdv(var1[0]);
         this.analytiqueCtrl02.setEcranaPdvLib(var1[1]);
      }

   }

   public void chargerSitesPrdItems() throws HibernateException, NamingException {
      this.chargerSitesPrdItems((Session)null);
   }

   public void chargerSitesPrdItems(Session var1) throws HibernateException, NamingException {
      this.lesSitesPrdItems.clear();
      if (this.siteDao == null) {
         this.siteDao = new SiteDao(this.baseLog, this.utilInitHibernate);
      }

      this.lesSitesPrdItems = this.siteDao.chargerLesSitesItems(var1);
      this.lesLignesItems.clear();
      this.lesAteliersItems.clear();
      if (this.analytiqueCtrl03 != null) {
         this.analytiqueCtrl03.setZoneLigne("");
         this.analytiqueCtrl03.setEcranaLigne("");
         this.analytiqueCtrl03.setEcranaLigneLib("");
         this.analytiqueCtrl03.setMesLignesItems(new ArrayList());
         this.analytiqueCtrl03.setLigVide(true);
         this.analytiqueCtrl03.setZoneAtelier("");
         this.analytiqueCtrl03.setEcranaAtelier("");
         this.analytiqueCtrl03.setEcranaAtelierLib("");
         this.analytiqueCtrl03.setMesAteliersItems(new ArrayList());
         this.analytiqueCtrl03.setAteVide(true);
      }

   }

   public void chargerLignesItems() throws HibernateException, NamingException {
      this.chargerLignesItems((Session)null);
   }

   public void chargerLignesItems(Session var1) throws HibernateException, NamingException {
      this.lesLignesItems.clear();
      if (this.analytiqueCtrl03.getZoneSitePrd() != null && !this.analytiqueCtrl03.getZoneSitePrd().isEmpty() && this.analytiqueCtrl03.getZoneSitePrd().contains(":")) {
         String[] var2 = this.analytiqueCtrl03.getZoneSitePrd().split(":");
         this.analytiqueCtrl03.setEcranaSite(var2[0]);
         this.analytiqueCtrl03.setEcranaSiteLib(var2[1]);
         new ArrayList();
         if (this.productionLigneDao == null) {
            this.productionLigneDao = new ProductionLigneDao(this.baseLog, this.utilInitHibernate);
         }

         List var3 = this.productionLigneDao.listProductionLigneBySit(var2[0], var1);
         if (var3.size() != 0) {
            for(int var4 = 0; var4 < var3.size(); ++var4) {
               this.lesLignesItems.add(new SelectItem(((ProductionLigne)var3.get(var4)).getLigCode() + ":" + ((ProductionLigne)var3.get(var4)).getLigNomFr()));
            }

            this.analytiqueCtrl03.setLigVide(true);
         }

         this.analytiqueCtrl03.setMesLignesItems(this.lesLignesItems);
      }

      this.lesAteliersItems.clear();
      if (this.analytiqueCtrl03 != null) {
         this.analytiqueCtrl03.setZoneAtelier("");
         this.analytiqueCtrl03.setEcranaAtelier("");
         this.analytiqueCtrl03.setEcranaAtelierLib("");
         this.analytiqueCtrl03.setMesAteliersItems(new ArrayList());
         this.analytiqueCtrl03.setAteVide(true);
      }

   }

   public void chargerAteliersItems() throws HibernateException, NamingException {
      this.chargerAteliersItems((Session)null);
   }

   public void chargerAteliersItems(Session var1) throws HibernateException, NamingException {
      this.lesAteliersItems.clear();
      if (this.analytiqueCtrl03.getZoneLigne() != null && !this.analytiqueCtrl03.getZoneLigne().isEmpty() && this.analytiqueCtrl03.getZoneLigne().contains(":")) {
         String[] var2 = this.analytiqueCtrl03.getZoneLigne().split(":");
         this.analytiqueCtrl03.setEcranaLigne(var2[0]);
         this.analytiqueCtrl03.setEcranaLigneLib(var2[1]);
         new ArrayList();
         if (this.productionAtelierDao == null) {
            this.productionAtelierDao = new ProductionAtelierDao(this.baseLog, this.utilInitHibernate);
         }

         List var3 = this.productionAtelierDao.listProductionAtelierByLigne(var2[0], var1);
         if (var3.size() != 0) {
            for(int var4 = 0; var4 < var3.size(); ++var4) {
               this.lesAteliersItems.add(new SelectItem(((ProductionAtelier)var3.get(var4)).getAteCode() + ":" + ((ProductionAtelier)var3.get(var4)).getAteNomFr()));
            }

            this.analytiqueCtrl03.setAteVide(false);
         }

         this.analytiqueCtrl03.setMesAteliersItems(this.lesAteliersItems);
      }

   }

   public void calculerAteliersItems(Session var1) throws HibernateException, NamingException {
      if (this.analytiqueCtrl03.getZoneAtelier() != null && !this.analytiqueCtrl03.getZoneAtelier().isEmpty() && this.analytiqueCtrl03.getZoneAtelier().contains(":")) {
         String[] var2 = this.analytiqueCtrl03.getZoneAtelier().split(":");
         this.analytiqueCtrl03.setEcranaAtelier(var2[0]);
         this.analytiqueCtrl03.setEcranaAtelierLib(var2[1]);
      }

   }

   public void chargersActivites() throws HibernateException, NamingException {
      this.chargersActivites((Session)null);
   }

   public void chargersActivites(Session var1) throws HibernateException, NamingException {
      this.lesColonnes1Items.clear();
      this.lesColonnes2Items.clear();
      this.lesColonnes3Items.clear();
      if (this.structureLog.getStrActiviteModeSasie() == 0) {
         if (this.activitesDao == null) {
            this.activitesDao = new ActivitesDao(this.baseLog, this.utilInitHibernate);
         }

         if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
            this.decoupageActivite = true;
         } else {
            this.decoupageActivite = false;
         }

         if (this.decoupageActivite) {
            if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
               this.lesColonnes1Items = this.activitesDao.chargerLesDecoupages(this.structureLog.getStrCode1(), var1);
            }

            if (this.structureLog.getStrChainageAxes() == 1) {
               String var2;
               if (this.structureLog.getStrCode2() != null && !this.structureLog.getStrCode2().isEmpty()) {
                  var2 = "";
                  if (this.analytiqueCtrl04 != null) {
                     var2 = this.analytiqueCtrl04.getEcranaActivite();
                  }

                  this.lesColonnes2Items = this.activitesDao.chargerLesDecoupagesLies(this.structureLog.getStrCode2(), var2, var1);
               }

               if (this.structureLog.getStrCode3() != null && !this.structureLog.getStrCode3().isEmpty()) {
                  var2 = "";
                  if (this.analytiqueCtrl04 != null) {
                     var2 = this.analytiqueCtrl04.getEcranaAnal1();
                  }

                  this.lesColonnes3Items = this.activitesDao.chargerLesDecoupagesLies(this.structureLog.getStrCode3(), var2, var1);
               }
            } else {
               if (this.structureLog.getStrCode2() != null && !this.structureLog.getStrCode2().isEmpty()) {
                  this.lesColonnes2Items = this.activitesDao.chargerLesDecoupages(this.structureLog.getStrCode2(), var1);
               }

               if (this.structureLog.getStrCode3() != null && !this.structureLog.getStrCode3().isEmpty()) {
                  this.lesColonnes3Items = this.activitesDao.chargerLesDecoupages(this.structureLog.getStrCode3(), var1);
               }
            }
         } else {
            this.lesColonnes1Items = this.activitesDao.chargerLesActivites(var1);
         }
      }

      if (this.analytiqueCtrl04 != null) {
         this.analytiqueCtrl04.setMesColonnes1Items(this.lesColonnes1Items);
         this.analytiqueCtrl04.setMesColonnes2Items(this.lesColonnes2Items);
         this.analytiqueCtrl04.setMesColonnes3Items(this.lesColonnes3Items);
      }

   }

   public void chargerActiviteCol1Items() throws HibernateException, NamingException {
      if (this.analytiqueCtrl04.getZoneCol1() != null && !this.analytiqueCtrl04.getZoneCol1().isEmpty() && this.analytiqueCtrl04.getZoneCol1().contains(":")) {
         String[] var1 = this.analytiqueCtrl04.getZoneCol1().split(":");
         this.analytiqueCtrl04.setEcranaActivite(var1[0]);
         this.analytiqueCtrl04.setEcranaActiviteLib(var1[1]);
         if (this.structureLog.getStrChainageAxes() == 1) {
            this.lesColonnes2Items.clear();
            if (this.structureLog.getStrCode2() != null && !this.structureLog.getStrCode2().isEmpty()) {
               this.lesColonnes2Items = this.activitesDao.chargerLesDecoupagesLies(this.structureLog.getStrCode2(), var1[0], (Session)null);
            }

            this.lesColonnes3Items.clear();
            this.analytiqueCtrl04.setMesColonnes2Items(this.lesColonnes2Items);
            this.analytiqueCtrl04.setMesColonnes3Items(this.lesColonnes3Items);
         }
      } else if (this.structureLog.getStrChainageAxes() == 1) {
         this.lesColonnes2Items.clear();
         this.lesColonnes3Items.clear();
         this.analytiqueCtrl04.setMesColonnes2Items(this.lesColonnes2Items);
         this.analytiqueCtrl04.setMesColonnes3Items(this.lesColonnes3Items);
      }

   }

   public void chargerActiviteCol0Items() {
      if (this.analytiqueCtrl04.getZoneActivite() != null && !this.analytiqueCtrl04.getZoneActivite().isEmpty() && this.analytiqueCtrl04.getZoneActivite().contains(":")) {
         String[] var1 = this.analytiqueCtrl04.getZoneActivite().split(":");
         this.analytiqueCtrl04.setEcranaActivite(var1[0]);
         this.analytiqueCtrl04.setEcranaActiviteLib(var1[1]);
      }

   }

   public void chargerActiviteCol2Items() throws HibernateException, NamingException {
      if (this.analytiqueCtrl04.getZoneCol2() != null && !this.analytiqueCtrl04.getZoneCol2().isEmpty() && this.analytiqueCtrl04.getZoneCol2().contains(":")) {
         String[] var1 = this.analytiqueCtrl04.getZoneCol2().split(":");
         this.analytiqueCtrl04.setEcranaAnal1(var1[0]);
         this.analytiqueCtrl04.setEcranaAnal1Lib(var1[1]);
         if (this.structureLog.getStrChainageAxes() == 1) {
            this.lesColonnes3Items.clear();
            if (this.structureLog.getStrCode3() != null && !this.structureLog.getStrCode3().isEmpty()) {
               this.lesColonnes3Items = this.activitesDao.chargerLesDecoupagesLies(this.structureLog.getStrCode3(), var1[0], (Session)null);
            }

            this.analytiqueCtrl04.setMesColonnes3Items(this.lesColonnes3Items);
         }
      } else if (this.structureLog.getStrChainageAxes() == 1) {
         this.lesColonnes3Items.clear();
         this.analytiqueCtrl04.setMesColonnes3Items(this.lesColonnes3Items);
      }

   }

   public void chargerActiviteCol3Items() {
      if (this.analytiqueCtrl04.getZoneCol3() != null && !this.analytiqueCtrl04.getZoneCol3().isEmpty() && this.analytiqueCtrl04.getZoneCol3().contains(":")) {
         String[] var1 = this.analytiqueCtrl04.getZoneCol3().split(":");
         this.analytiqueCtrl04.setEcranaAnal3(var1[0]);
         this.analytiqueCtrl04.setEcranaAnal3Lib(var1[1]);
      }

   }

   public void chargerParcs() {
   }

   public void chargerDossiers() {
   }

   public void chargerMissions() {
   }

   public void chargerChantiers() {
   }

   public void chargerProjets(int var1, Session var2) throws HibernateException, NamingException {
      this.lesProjetsItems.clear();
      if (this.projetsDao == null) {
         this.projetsDao = new ProjetsDao(this.baseLog, this.utilInitHibernate);
      }

      this.lesProjetsItems = this.projetsDao.chargerLesProjets(var1, var2);
      this.lesEntitesItems.clear();
      this.lesPostesItems.clear();
      if (this.analytiqueCtrl10 != null) {
         this.analytiqueCtrl10.setZoneEntite("");
         this.analytiqueCtrl10.setEcranaEntite("");
         this.analytiqueCtrl10.setEcranaEntiteLib("");
         this.analytiqueCtrl10.setMesEntitesItems(new ArrayList());
         this.analytiqueCtrl10.setEntVide(true);
         this.analytiqueCtrl10.setZonePoste("");
         this.analytiqueCtrl10.setEcranaPoste("");
         this.analytiqueCtrl10.setEcranaPosteLib("");
         this.analytiqueCtrl10.setMesPostesItems(new ArrayList());
         this.analytiqueCtrl10.setPosVide(true);
      }

   }

   public void chargerEntitesItems() throws HibernateException, NamingException {
      this.chargerEntitesItems((Session)null);
   }

   public void chargerEntitesItems(Session var1) throws HibernateException, NamingException {
      this.lesEntitesItems.clear();
      this.lesPostesItems.clear();
      if (this.analytiqueCtrl10.getZoneProjet() != null && !this.analytiqueCtrl10.getZoneProjet().isEmpty() && this.analytiqueCtrl10.getZoneProjet().contains(":")) {
         String[] var2 = this.analytiqueCtrl10.getZoneProjet().split(":");
         this.analytiqueCtrl10.setEcranaProjet(var2[0]);
         this.analytiqueCtrl10.setEcranaProjetLib(var2[1]);
         if (this.budgetDao == null) {
            this.budgetDao = new BudgetDao(this.baseLog, this.utilInitHibernate);
         }

         new ArrayList();
         List var3 = this.budgetDao.chargerLesBudgetsEntitesTitre(var2[0], "", "", var1);
         if (var3.size() != 0) {
            for(int var4 = 0; var4 < var3.size(); ++var4) {
               if (((Budget)var3.get(var4)).getBudType() == 15) {
                  this.lesEntitesItems.add(new SelectItem(((Budget)var3.get(var4)).getBudEntite() + ":" + ((Budget)var3.get(var4)).getBudLibelleFr()));
               }
            }
         }

         if (this.lesEntitesItems.size() != 0) {
            this.analytiqueCtrl10.setEntVide(false);
         }

         this.analytiqueCtrl10.setMesEntitesItems(this.lesEntitesItems);
      }

      if (this.lesEntitesItems.size() == 0) {
         this.chargerPostesItems(var1);
      } else {
         this.lesPostesItems.clear();
         if (this.analytiqueCtrl10 != null) {
            this.analytiqueCtrl10.setZonePoste("");
            this.analytiqueCtrl10.setEcranaPoste("");
            this.analytiqueCtrl10.setEcranaPosteLib("");
            this.analytiqueCtrl10.setMesPostesItems(new ArrayList());
            this.analytiqueCtrl10.setPosVide(true);
         }
      }

   }

   public void chargerPostesItems() throws HibernateException, NamingException {
      this.chargerPostesItems((Session)null);
   }

   public void chargerPostesItems(Session var1) throws HibernateException, NamingException {
      this.lesPostesItems.clear();
      String[] var2;
      List var3;
      int var4;
      if (this.analytiqueCtrl10.getZoneEntite() != null && !this.analytiqueCtrl10.getZoneEntite().isEmpty() && this.analytiqueCtrl10.getZoneEntite().contains(":")) {
         var2 = this.analytiqueCtrl10.getZoneEntite().split(":");
         this.analytiqueCtrl10.setEcranaEntite(var2[0]);
         this.analytiqueCtrl10.setEcranaEntiteLib(var2[1]);
         if (this.budgetDao == null) {
            this.budgetDao = new BudgetDao(this.baseLog, this.utilInitHibernate);
         }

         new ArrayList();
         var3 = this.budgetDao.chargerLesBudgetsEntitesDetail(var2[0], "", "", var1);
         if (var3.size() != 0) {
            for(var4 = 0; var4 < var3.size(); ++var4) {
               if (((Budget)var3.get(var4)).getBudType() == 1) {
                  this.lesPostesItems.add(new SelectItem(((Budget)var3.get(var4)).getBudCode() + ":" + ((Budget)var3.get(var4)).getBudLibelleFr()));
               }
            }
         }

         if (this.lesPostesItems.size() != 0) {
            this.analytiqueCtrl10.setPosVide(false);
         }

         this.analytiqueCtrl10.setMesPostesItems(this.lesPostesItems);
      } else if (this.analytiqueCtrl10.getZoneProjet() != null && !this.analytiqueCtrl10.getZoneProjet().isEmpty() && this.analytiqueCtrl10.getZoneProjet().contains(":")) {
         var2 = this.analytiqueCtrl10.getZoneProjet().split(":");
         this.analytiqueCtrl10.setEcranaPoste(var2[0]);
         this.analytiqueCtrl10.setEcranaPosteLib(var2[1]);
         if (this.budgetDao == null) {
            this.budgetDao = new BudgetDao(this.baseLog, this.utilInitHibernate);
         }

         new ArrayList();
         var3 = this.budgetDao.chargerLesBudgets(var2[0], "", "", var1);
         if (var3.size() != 0) {
            for(var4 = 0; var4 < var3.size(); ++var4) {
               if (((Budget)var3.get(var4)).getBudType() == 1) {
                  this.lesPostesItems.add(new SelectItem(((Budget)var3.get(var4)).getBudCode() + ":" + ((Budget)var3.get(var4)).getBudLibelleFr()));
               }
            }
         }

         if (this.lesPostesItems.size() != 0) {
            this.analytiqueCtrl10.setPosVide(false);
         }

         this.analytiqueCtrl10.setMesPostesItems(this.lesPostesItems);
      }

   }

   public void calculerPostesItems() throws HibernateException, NamingException {
      if (this.analytiqueCtrl10.getZonePoste() != null && !this.analytiqueCtrl10.getZonePoste().isEmpty() && this.analytiqueCtrl10.getZonePoste().contains(":")) {
         String[] var1 = this.analytiqueCtrl10.getZonePoste().split(":");
         this.analytiqueCtrl10.setEcranaPoste(var1[0]);
         this.analytiqueCtrl10.setEcranaPosteLib(var1[1]);
      }

   }

   public void chargerAgents() {
   }

   public void chargerClesStandards() throws HibernateException, NamingException {
      this.chargerClesStandards((Session)null);
   }

   public void chargerClesStandards(Session var1) throws HibernateException, NamingException {
      this.lesClesStandardsItems.clear();
      if (this.plansAnalytiquesDao == null) {
         this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      }

      this.lesClesStandardsItems = this.plansAnalytiquesDao.chargerLesAnalytiquesStandard(200, var1);
   }

   public void chargerClesStructure() throws HibernateException, NamingException {
      this.chargerClesStructure((Session)null);
   }

   public void chargerClesStructure(Session var1) throws HibernateException, NamingException {
      this.lesClesStructureItems.clear();
      if (this.plansAnalytiquesDao == null) {
         this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         this.planAnalytiqueRepartitionDao = new PlanAnalytiqueRepartitionDao(this.baseLog, this.utilInitHibernate);
      }

      this.lesClesStructureItems = this.plansAnalytiquesDao.chargerLesAnalytiquesStructure(var1);
   }

   public void ongletAxe01() {
      this.ongletActif = "idAxe01";
   }

   public void ongletAxe02() {
      this.ongletActif = "idAxe02";
   }

   public void ongletAxe03() {
      this.ongletActif = "idAxe03";
   }

   public void ongletAxe04() {
      this.ongletActif = "idAxe04";
   }

   public void ongletAxe05() {
      this.ongletActif = "idAxe05";
   }

   public void ongletAxe06() {
      this.ongletActif = "idAxe06";
   }

   public void ongletAxe07() {
      this.ongletActif = "idAxe07";
   }

   public void ongletAxe08() {
      this.ongletActif = "idAxe08";
   }

   public void ongletAxe09() {
      this.ongletActif = "idAxe09";
   }

   public void ongletAxe10() {
      this.ongletActif = "idAxe10";
   }

   public void ongletAxe11() {
      this.ongletActif = "idAxe11";
   }

   public void ongletAxe12() {
      this.ongletActif = "idAxe12";
   }

   public void ongletAxe13() {
      this.ongletActif = "idAxe13";
   }

   public void ongletAxeTransit() {
      this.ongletActif = "idAxeTransit";
   }

   public void selctionAxe01() {
      if (this.dataModelAxe01.isRowAvailable()) {
         this.analytiqueCtrl01 = (EcrituresAnalytiqueCtrl)this.dataModelAxe01.getRowData();
      }

   }

   public void selctionAxe02() {
      if (this.dataModelAxe02.isRowAvailable()) {
         this.analytiqueCtrl02 = (EcrituresAnalytiqueCtrl)this.dataModelAxe02.getRowData();
      }

   }

   public void selctionAxe03() {
      if (this.dataModelAxe03.isRowAvailable()) {
         this.analytiqueCtrl03 = (EcrituresAnalytiqueCtrl)this.dataModelAxe03.getRowData();
      }

   }

   public void selctionAxe04() {
      if (this.dataModelAxe04.isRowAvailable()) {
         this.analytiqueCtrl04 = (EcrituresAnalytiqueCtrl)this.dataModelAxe04.getRowData();
         this.boutonAxe04 = true;
      }

   }

   public void selctionAxe05() {
      if (this.dataModelAxe05.isRowAvailable()) {
         this.analytiqueCtrl05 = (EcrituresAnalytiqueCtrl)this.dataModelAxe05.getRowData();
      }

   }

   public void selctionAxe06() {
      if (this.dataModelAxe06.isRowAvailable()) {
         this.analytiqueCtrl06 = (EcrituresAnalytiqueCtrl)this.dataModelAxe06.getRowData();
      }

   }

   public void selctionAxe07() {
      if (this.dataModelAxe07.isRowAvailable()) {
         this.analytiqueCtrl07 = (EcrituresAnalytiqueCtrl)this.dataModelAxe07.getRowData();
      }

   }

   public void selctionAxe08() {
      if (this.dataModelAxe08.isRowAvailable()) {
         this.analytiqueCtrl08 = (EcrituresAnalytiqueCtrl)this.dataModelAxe08.getRowData();
      }

   }

   public void selctionAxe09() {
      if (this.dataModelAxe09.isRowAvailable()) {
         this.analytiqueCtrl09 = (EcrituresAnalytiqueCtrl)this.dataModelAxe09.getRowData();
      }

   }

   public void selctionAxe10() {
      if (this.dataModelAxe10.isRowAvailable()) {
         this.analytiqueCtrl10 = (EcrituresAnalytiqueCtrl)this.dataModelAxe10.getRowData();
      }

   }

   public void selctionAxe11() {
      if (this.dataModelAxe11.isRowAvailable()) {
         this.analytiqueCtrl11 = (EcrituresAnalytiqueCtrl)this.dataModelAxe11.getRowData();
      }

   }

   public void selctionAxe12() {
      if (this.dataModelAxe12.isRowAvailable()) {
         this.analytiqueCtrl12 = (EcrituresAnalytiqueCtrl)this.dataModelAxe12.getRowData();
      }

   }

   public void selctionAxe13() {
      if (this.dataModelAxe13.isRowAvailable()) {
         this.analytiqueCtrl13 = (EcrituresAnalytiqueCtrl)this.dataModelAxe13.getRowData();
      }

   }

   public void utilisationAxe01() {
      if (this.util_axe01 == 1) {
         this.listeAxe01.clear();
         this.ecart01 = 0.0D;
      } else if (this.listeAxe01.size() == 0) {
         this.analytiqueCtrl01 = new EcrituresAnalytiqueCtrl();
         this.analytiqueCtrl01.setMesSitesItems(this.lesSitesItems);
         this.analytiqueCtrl01.setMesDepartementsItems(new ArrayList());
         this.analytiqueCtrl01.setDepVide(true);
         this.analytiqueCtrl01.setMesServicesItems(new ArrayList());
         this.analytiqueCtrl01.setSerVide(true);
         this.listeAxe01.add(this.analytiqueCtrl01);
      }

      this.dataModelAxe01.setWrappedData(this.listeAxe01);
      this.calculEcart01();
   }

   public void utilisationAxe02() {
      if (this.util_axe02 == 1) {
         this.listeAxe02.clear();
         this.ecart02 = 0.0D;
      } else if (this.listeAxe02.size() == 0) {
         this.analytiqueCtrl02 = new EcrituresAnalytiqueCtrl();
         this.analytiqueCtrl02.setMesRegionsItems(this.lesRegionsItems);
         this.analytiqueCtrl02.setMesSecteursItems(new ArrayList());
         this.analytiqueCtrl02.setSecVide(true);
         this.analytiqueCtrl02.setMesPdvItems(new ArrayList());
         this.analytiqueCtrl02.setPdvVide(true);
         this.listeAxe02.add(this.analytiqueCtrl02);
      }

      this.dataModelAxe02.setWrappedData(this.listeAxe02);
      this.calculEcart02();
   }

   public void utilisationAxe03() {
      if (this.util_axe03 == 1) {
         this.listeAxe03.clear();
         this.ecart03 = 0.0D;
      } else if (this.listeAxe03.size() == 0) {
         this.analytiqueCtrl03 = new EcrituresAnalytiqueCtrl();
         this.analytiqueCtrl03.setMesSitesItems(this.lesSitesPrdItems);
         this.analytiqueCtrl03.setMesLignesItems(new ArrayList());
         this.analytiqueCtrl03.setLigVide(true);
         this.analytiqueCtrl03.setMesAteliersItems(new ArrayList());
         this.analytiqueCtrl03.setAteVide(true);
         this.listeAxe03.add(this.analytiqueCtrl03);
      }

      this.dataModelAxe01.setWrappedData(this.listeAxe01);
      this.calculEcart03();
   }

   public void utilisationAxe04() throws HibernateException, NamingException {
      if (this.util_axe04 == 1) {
         if (this.listeAxe04.size() != 0) {
            for(int var1 = 0; var1 < this.listeAxe04.size(); ++var1) {
               this.analytiqueCtrl04 = (EcrituresAnalytiqueCtrl)this.listeAxe04.get(var1);
               this.ecrituresAnalytiquesDao.nettoyageAnalytique(this.analytiqueCtrl04.getEcranaId());
            }
         }

         this.listeAxe04.clear();
         this.ecart04 = 0.0D;
      }

      this.dataModelAxe04.setWrappedData(this.listeAxe04);
      this.boutonAxe04 = false;
      this.calculEcart04();
   }

   public void ajouterAxeActivite() {
      this.analytiqueCtrl04 = new EcrituresAnalytiqueCtrl();
      this.analytiqueCtrl04.setMesColonnes1Items(this.lesColonnes1Items);
      if (this.structureLog.getStrChainageAxes() == 1) {
         this.lesColonnes2Items.clear();
         this.lesColonnes3Items.clear();
      }

      this.analytiqueCtrl04.setMesColonnes2Items(this.lesColonnes2Items);
      this.analytiqueCtrl04.setMesColonnes3Items(this.lesColonnes3Items);
      this.ajoutAxe04 = 0;
      this.showModalPanelAxe04 = true;
   }

   public void modifierAxeActivite() throws HibernateException, NamingException {
      if (this.analytiqueCtrl04 != null) {
         this.analytiqueCtrl04.setMesColonnes1Items(this.lesColonnes1Items);
         if (this.structureLog.getStrChainageAxes() == 1) {
            String var1;
            if (this.structureLog.getStrCode2() != null && !this.structureLog.getStrCode2().isEmpty()) {
               var1 = "";
               if (this.analytiqueCtrl04 != null) {
                  var1 = this.analytiqueCtrl04.getEcranaActivite();
               }

               this.lesColonnes2Items = this.activitesDao.chargerLesDecoupagesLies(this.structureLog.getStrCode2(), var1, (Session)null);
            }

            if (this.structureLog.getStrCode3() != null && !this.structureLog.getStrCode3().isEmpty()) {
               var1 = "";
               if (this.analytiqueCtrl04 != null) {
                  var1 = this.analytiqueCtrl04.getEcranaAnal1();
               }

               this.lesColonnes3Items = this.activitesDao.chargerLesDecoupagesLies(this.structureLog.getStrCode3(), var1, (Session)null);
            }
         }

         this.analytiqueCtrl04.setMesColonnes2Items(this.lesColonnes2Items);
         this.analytiqueCtrl04.setMesColonnes3Items(this.lesColonnes3Items);
         this.ajoutAxe04 = 1;
         this.showModalPanelAxe04 = true;
      }

   }

   public void panelFermerAxe04() {
      this.showModalPanelAxe04 = false;
      this.boutonAxe04 = false;
   }

   public void panelValiderAxe04() {
      if (this.analytiqueCtrl04 != null) {
         if (this.ajoutAxe04 == 0) {
            this.listeAxe04.add(this.analytiqueCtrl04);
         }

         this.dataModelAxe04.setWrappedData(this.listeAxe04);
         this.calculEcart04();
      }

      this.showModalPanelAxe04 = false;
   }

   public void supprimerAxeActivite() throws HibernateException, NamingException {
      if (this.analytiqueCtrl04 != null) {
         this.ecrituresAnalytiquesDao.nettoyageAnalytique(this.analytiqueCtrl04.getEcranaId());
         this.listeAxe04.remove(this.analytiqueCtrl04);
         this.dataModelAxe04.setWrappedData(this.listeAxe04);
         this.boutonAxe04 = false;
         this.calculEcart04();
      }

   }

   public void utilisationAxe05() {
      if (this.util_axe05 == 1) {
         this.listeAxe05.clear();
         this.ecart05 = 0.0D;
      } else if (this.listeAxe05.size() == 0) {
         this.analytiqueCtrl05 = new EcrituresAnalytiqueCtrl();
         this.listeAxe05.add(this.analytiqueCtrl05);
      }

      this.dataModelAxe05.setWrappedData(this.listeAxe05);
      this.calculEcart05();
   }

   public void utilisationAxe06() {
      if (this.util_axe06 == 1) {
         this.listeAxe06.clear();
         this.ecart06 = 0.0D;
      } else if (this.listeAxe06.size() == 0) {
         this.analytiqueCtrl06 = new EcrituresAnalytiqueCtrl();
         this.listeAxe06.add(this.analytiqueCtrl06);
      }

      this.dataModelAxe06.setWrappedData(this.listeAxe06);
      this.calculEcart06();
   }

   public void utilisationAxe07() {
      if (this.util_axe07 == 1) {
         this.listeAxe07.clear();
         this.ecart07 = 0.0D;
      } else if (this.listeAxe07.size() == 0) {
         this.analytiqueCtrl07 = new EcrituresAnalytiqueCtrl();
         this.listeAxe07.add(this.analytiqueCtrl07);
      }

      this.dataModelAxe07.setWrappedData(this.listeAxe07);
      this.calculEcart07();
   }

   public void utilisationAxe08() {
      if (this.util_axe08 == 1) {
         this.listeAxe08.clear();
         this.ecart08 = 0.0D;
      } else if (this.listeAxe08.size() == 0) {
         this.analytiqueCtrl08 = new EcrituresAnalytiqueCtrl();
         this.listeAxe08.add(this.analytiqueCtrl08);
      }

      this.dataModelAxe08.setWrappedData(this.listeAxe08);
      this.calculEcart08();
   }

   public void utilisationAxe09() {
      if (this.util_axe09 == 1) {
         this.listeAxe09.clear();
         this.ecart09 = 0.0D;
      } else if (this.listeAxe09.size() == 0) {
         this.analytiqueCtrl09 = new EcrituresAnalytiqueCtrl();
         this.listeAxe09.add(this.analytiqueCtrl09);
      }

      this.dataModelAxe09.setWrappedData(this.listeAxe09);
      this.calculEcart09();
   }

   public void utilisationAxe10() {
      if (this.util_axe10 == 1) {
         this.listeAxe10.clear();
         this.ecart10 = 0.0D;
      } else if (this.listeAxe10.size() == 0) {
         this.analytiqueCtrl10 = new EcrituresAnalytiqueCtrl();
         this.analytiqueCtrl10.setMesProjetsItems(this.lesProjetsItems);
         this.analytiqueCtrl10.setMesEntitesItems(new ArrayList());
         this.analytiqueCtrl10.setEntVide(true);
         this.analytiqueCtrl10.setMesPostesItems(new ArrayList());
         this.analytiqueCtrl10.setPosVide(true);
         this.listeAxe10.add(this.analytiqueCtrl10);
      }

      this.dataModelAxe10.setWrappedData(this.listeAxe10);
      this.calculEcart10();
   }

   public void utilisationAxe11() {
      if (this.util_axe11 == 1) {
         this.listeAxe11.clear();
         this.ecart11 = 0.0D;
      }

      this.dataModelAxe11.setWrappedData(this.listeAxe11);
      this.calculEcart11();
   }

   public void utilisationAxe12() {
      if (this.util_axe12 == 1) {
         this.listeAxe12.clear();
         this.ecart12 = 0.0D;
      }

      this.dataModelAxe12.setWrappedData(this.listeAxe12);
      this.calculEcart12();
   }

   public void utilisationAxe13() {
      if (this.util_axe13 == 1) {
         this.listeAxe13.clear();
         this.ecart13 = 0.0D;
      }

      this.dataModelAxe13.setWrappedData(this.listeAxe13);
      this.calculEcart13();
   }

   public void calculLigne01() {
      if (this.analytiqueCtrl01 != null) {
         if (this.analytiqueCtrl01.getEcranaPourcentage() != 0.0F) {
            double var1 = this.utilNombre.myRoundDevise(this.montantAImputer * (double)this.analytiqueCtrl01.getEcranaPourcentage() / 100.0D, this.deviseEcriture);
            this.analytiqueCtrl01.setEcranaMontantSaisie(var1);
         }

         this.calculNouvelleLigne01();
      }

   }

   public void calculLigne02() {
      if (this.analytiqueCtrl02 != null) {
         if (this.analytiqueCtrl02.getEcranaPourcentage() != 0.0F) {
            double var1 = this.utilNombre.myRoundDevise(this.montantAImputer * (double)this.analytiqueCtrl02.getEcranaPourcentage() / 100.0D, this.deviseEcriture);
            this.analytiqueCtrl02.setEcranaMontantSaisie(var1);
         }

         this.calculNouvelleLigne02();
      }

   }

   public void calculLigne03() {
      if (this.analytiqueCtrl03 != null) {
         if (this.analytiqueCtrl03.getEcranaPourcentage() != 0.0F) {
            double var1 = this.utilNombre.myRoundDevise(this.montantAImputer * (double)this.analytiqueCtrl03.getEcranaPourcentage() / 100.0D, this.deviseEcriture);
            this.analytiqueCtrl03.setEcranaMontantSaisie(var1);
         }

         this.calculNouvelleLigne03();
      }

   }

   public void calculLigne04() {
      if (this.analytiqueCtrl04 != null && this.analytiqueCtrl04.getEcranaPourcentage() != 0.0F) {
         double var1 = this.utilNombre.myRoundDevise(this.montantAImputer * (double)this.analytiqueCtrl04.getEcranaPourcentage() / 100.0D, this.deviseEcriture);
         this.analytiqueCtrl04.setEcranaMontantSaisie(var1);
      }

   }

   public void calculLigne05() {
      if (this.analytiqueCtrl05 != null) {
         if (this.analytiqueCtrl05.getEcranaPourcentage() != 0.0F) {
            double var1 = this.utilNombre.myRoundDevise(this.montantAImputer * (double)this.analytiqueCtrl05.getEcranaPourcentage() / 100.0D, this.deviseEcriture);
            this.analytiqueCtrl05.setEcranaMontantSaisie(var1);
         }

         this.calculNouvelleLigne05();
      }

   }

   public void calculLigne06() {
      if (this.analytiqueCtrl06 != null) {
         if (this.analytiqueCtrl06.getEcranaPourcentage() != 0.0F) {
            double var1 = this.utilNombre.myRoundDevise(this.montantAImputer * (double)this.analytiqueCtrl06.getEcranaPourcentage() / 100.0D, this.deviseEcriture);
            this.analytiqueCtrl06.setEcranaMontantSaisie(var1);
         }

         this.calculNouvelleLigne06();
      }

   }

   public void calculLigne07() {
      if (this.analytiqueCtrl07 != null) {
         if (this.analytiqueCtrl07.getEcranaPourcentage() != 0.0F) {
            double var1 = this.utilNombre.myRoundDevise(this.montantAImputer * (double)this.analytiqueCtrl07.getEcranaPourcentage() / 100.0D, this.deviseEcriture);
            this.analytiqueCtrl07.setEcranaMontantSaisie(var1);
         }

         this.calculNouvelleLigne07();
      }

   }

   public void calculLigne08() {
      if (this.analytiqueCtrl08 != null) {
         if (this.analytiqueCtrl08.getEcranaPourcentage() != 0.0F) {
            double var1 = this.utilNombre.myRoundDevise(this.montantAImputer * (double)this.analytiqueCtrl08.getEcranaPourcentage() / 100.0D, this.deviseEcriture);
            this.analytiqueCtrl08.setEcranaMontantSaisie(var1);
         }

         this.calculNouvelleLigne08();
      }

   }

   public void calculLigne09() {
      if (this.analytiqueCtrl09 != null) {
         if (this.analytiqueCtrl09.getEcranaPourcentage() != 0.0F) {
            double var1 = this.utilNombre.myRoundDevise(this.montantAImputer * (double)this.analytiqueCtrl09.getEcranaPourcentage() / 100.0D, this.deviseEcriture);
            this.analytiqueCtrl09.setEcranaMontantSaisie(var1);
         }

         this.calculNouvelleLigne09();
      }

   }

   public void calculLigne10() {
      if (this.analytiqueCtrl10 != null) {
         if (this.analytiqueCtrl10.getEcranaPourcentage() != 0.0F) {
            double var1 = this.utilNombre.myRoundDevise(this.montantAImputer * (double)this.analytiqueCtrl10.getEcranaPourcentage() / 100.0D, this.deviseEcriture);
            this.analytiqueCtrl10.setEcranaMontantSaisie(var1);
         }

         this.calculNouvelleLigne10();
      }

   }

   public void calculLigne11() {
      if (this.analytiqueCtrl11 != null) {
         if (this.analytiqueCtrl11.getEcranaPourcentage() != 0.0F) {
            double var1 = this.utilNombre.myRoundDevise(this.montantAImputer * (double)this.analytiqueCtrl11.getEcranaPourcentage() / 100.0D, this.deviseEcriture);
            this.analytiqueCtrl11.setEcranaMontantSaisie(var1);
         }

         this.calculEcart11();
      }

   }

   public void calculLigne12() {
      if (this.analytiqueCtrl12 != null) {
         if (this.analytiqueCtrl12.getEcranaPourcentage() != 0.0F) {
            double var1 = this.utilNombre.myRoundDevise(this.montantAImputer * (double)this.analytiqueCtrl12.getEcranaPourcentage() / 100.0D, this.deviseEcriture);
            this.analytiqueCtrl12.setEcranaMontantSaisie(var1);
         }

         this.calculEcart12();
      }

   }

   public void calculLigne13() {
      if (this.analytiqueCtrl13 != null) {
         if (this.analytiqueCtrl13.getEcranaPourcentage() != 0.0F) {
            double var1 = this.utilNombre.myRoundDevise(this.montantAImputer * (double)this.analytiqueCtrl13.getEcranaPourcentage() / 100.0D, this.deviseEcriture);
            this.analytiqueCtrl13.setEcranaMontantSaisie(var1);
         }

         this.calculEcart13();
      }

   }

   public void calculNouvelleLigne01() {
      if (this.analytiqueCtrl01 != null) {
         this.calculEcart01();
         if (this.ecart01 != 0.0D) {
            boolean var1 = false;
            if (this.listeAxe01.size() != 0) {
               for(int var2 = 0; var2 < this.listeAxe01.size(); ++var2) {
                  if (((EcrituresAnalytiqueCtrl)this.listeAxe01.get(var2)).getEcranaMontantSaisie() == 0.0D) {
                     var1 = true;
                     break;
                  }
               }
            }

            if (!var1) {
               this.analytiqueCtrl01 = new EcrituresAnalytiqueCtrl();
               this.analytiqueCtrl01.setMesSitesItems(this.lesSitesItems);
               this.analytiqueCtrl01.setMesDepartementsItems(new ArrayList());
               this.analytiqueCtrl01.setDepVide(true);
               this.analytiqueCtrl01.setMesServicesItems(new ArrayList());
               this.analytiqueCtrl01.setSerVide(true);
               this.listeAxe01.add(this.analytiqueCtrl01);
               this.dataModelAxe01.setWrappedData(this.listeAxe01);
            }
         }
      }

   }

   public void calculNouvelleLigne02() {
      if (this.analytiqueCtrl02 != null) {
         this.calculEcart02();
         if (this.ecart02 != 0.0D) {
            boolean var1 = false;
            if (this.listeAxe02.size() != 0) {
               for(int var2 = 0; var2 < this.listeAxe02.size(); ++var2) {
                  if (((EcrituresAnalytiqueCtrl)this.listeAxe02.get(var2)).getEcranaMontantSaisie() == 0.0D) {
                     var1 = true;
                     break;
                  }
               }
            }

            if (!var1) {
               this.analytiqueCtrl02 = new EcrituresAnalytiqueCtrl();
               this.analytiqueCtrl02.setMesRegionsItems(this.lesRegionsItems);
               this.analytiqueCtrl02.setMesSecteursItems(new ArrayList());
               this.analytiqueCtrl02.setSecVide(true);
               this.analytiqueCtrl02.setMesPdvItems(new ArrayList());
               this.analytiqueCtrl02.setPdvVide(true);
               this.listeAxe02.add(this.analytiqueCtrl02);
               this.dataModelAxe02.setWrappedData(this.listeAxe02);
            }
         }
      }

   }

   public void calculNouvelleLigne03() {
      if (this.analytiqueCtrl03 != null) {
         this.calculEcart03();
         if (this.ecart03 != 0.0D) {
            boolean var1 = false;
            if (this.listeAxe03.size() != 0) {
               for(int var2 = 0; var2 < this.listeAxe03.size(); ++var2) {
                  if (((EcrituresAnalytiqueCtrl)this.listeAxe03.get(var2)).getEcranaMontantSaisie() == 0.0D) {
                     var1 = true;
                     break;
                  }
               }
            }

            if (!var1) {
               this.analytiqueCtrl03 = new EcrituresAnalytiqueCtrl();
               this.analytiqueCtrl03.setMesSitesItems(this.lesSitesPrdItems);
               this.analytiqueCtrl03.setMesLignesItems(new ArrayList());
               this.analytiqueCtrl03.setLigVide(true);
               this.analytiqueCtrl03.setMesAteliersItems(new ArrayList());
               this.analytiqueCtrl03.setAteVide(true);
               this.listeAxe03.add(this.analytiqueCtrl03);
               this.dataModelAxe03.setWrappedData(this.listeAxe03);
            }
         }
      }

   }

   public void calculNouvelleLigne04() {
      if (this.analytiqueCtrl04 != null) {
         this.calculEcart04();
         if (this.ecart04 != 0.0D) {
            boolean var1 = false;
            if (this.listeAxe04.size() != 0) {
               for(int var2 = 0; var2 < this.listeAxe04.size(); ++var2) {
                  if (((EcrituresAnalytiqueCtrl)this.listeAxe04.get(var2)).getEcranaMontantSaisie() == 0.0D) {
                     var1 = true;
                     break;
                  }
               }
            }

            if (!var1) {
               this.analytiqueCtrl04 = new EcrituresAnalytiqueCtrl();
               this.analytiqueCtrl04.setMesColonnes1Items(this.lesColonnes1Items);
               this.analytiqueCtrl04.setMesColonnes2Items(this.lesColonnes2Items);
               this.analytiqueCtrl04.setMesColonnes3Items(this.lesColonnes3Items);
               this.listeAxe04.add(this.analytiqueCtrl04);
               this.dataModelAxe04.setWrappedData(this.listeAxe04);
            }
         }
      }

   }

   public void calculNouvelleLigne05() {
      if (this.analytiqueCtrl05 != null) {
         this.calculEcart05();
         if (this.ecart05 != 0.0D) {
            boolean var1 = false;
            if (this.listeAxe05.size() != 0) {
               for(int var2 = 0; var2 < this.listeAxe05.size(); ++var2) {
                  if (((EcrituresAnalytiqueCtrl)this.listeAxe05.get(var2)).getEcranaMontantSaisie() == 0.0D) {
                     var1 = true;
                     break;
                  }
               }
            }

            if (!var1) {
               this.analytiqueCtrl05 = new EcrituresAnalytiqueCtrl();
               this.listeAxe05.add(this.analytiqueCtrl05);
               this.dataModelAxe05.setWrappedData(this.listeAxe05);
            }
         }
      }

   }

   public void calculNouvelleLigne06() {
      if (this.analytiqueCtrl06 != null) {
         this.calculEcart06();
         if (this.ecart06 != 0.0D) {
            boolean var1 = false;
            if (this.listeAxe06.size() != 0) {
               for(int var2 = 0; var2 < this.listeAxe06.size(); ++var2) {
                  if (((EcrituresAnalytiqueCtrl)this.listeAxe06.get(var2)).getEcranaMontantSaisie() == 0.0D) {
                     var1 = true;
                     break;
                  }
               }
            }

            if (!var1) {
               this.analytiqueCtrl06 = new EcrituresAnalytiqueCtrl();
               this.listeAxe06.add(this.analytiqueCtrl06);
               this.dataModelAxe06.setWrappedData(this.listeAxe06);
            }
         }
      }

   }

   public void calculNouvelleLigne07() {
      if (this.analytiqueCtrl07 != null) {
         this.calculEcart07();
         if (this.ecart07 != 0.0D) {
            boolean var1 = false;
            if (this.listeAxe07.size() != 0) {
               for(int var2 = 0; var2 < this.listeAxe07.size(); ++var2) {
                  if (((EcrituresAnalytiqueCtrl)this.listeAxe07.get(var2)).getEcranaMontantSaisie() == 0.0D) {
                     var1 = true;
                     break;
                  }
               }
            }

            if (!var1) {
               this.analytiqueCtrl07 = new EcrituresAnalytiqueCtrl();
               this.listeAxe07.add(this.analytiqueCtrl07);
               this.dataModelAxe07.setWrappedData(this.listeAxe07);
            }
         }
      }

   }

   public void calculNouvelleLigne08() {
      if (this.analytiqueCtrl08 != null) {
         this.calculEcart08();
         if (this.ecart08 != 0.0D) {
            boolean var1 = false;
            if (this.listeAxe08.size() != 0) {
               for(int var2 = 0; var2 < this.listeAxe08.size(); ++var2) {
                  if (((EcrituresAnalytiqueCtrl)this.listeAxe08.get(var2)).getEcranaMontantSaisie() == 0.0D) {
                     var1 = true;
                     break;
                  }
               }
            }

            if (!var1) {
               this.analytiqueCtrl08 = new EcrituresAnalytiqueCtrl();
               this.listeAxe08.add(this.analytiqueCtrl08);
               this.dataModelAxe08.setWrappedData(this.listeAxe08);
            }
         }
      }

   }

   public void calculNouvelleLigne09() {
      if (this.analytiqueCtrl09 != null) {
         this.calculEcart09();
         if (this.ecart09 != 0.0D) {
            boolean var1 = false;
            if (this.listeAxe09.size() != 0) {
               for(int var2 = 0; var2 < this.listeAxe09.size(); ++var2) {
                  if (((EcrituresAnalytiqueCtrl)this.listeAxe09.get(var2)).getEcranaMontantSaisie() == 0.0D) {
                     var1 = true;
                     break;
                  }
               }
            }

            if (!var1) {
               this.analytiqueCtrl09 = new EcrituresAnalytiqueCtrl();
               this.listeAxe09.add(this.analytiqueCtrl09);
               this.dataModelAxe09.setWrappedData(this.listeAxe09);
            }
         }
      }

   }

   public void calculNouvelleLigne10() {
      if (this.analytiqueCtrl10 != null) {
         this.calculEcart10();
         if (this.ecart10 != 0.0D) {
            boolean var1 = false;
            if (this.listeAxe10.size() != 0) {
               for(int var2 = 0; var2 < this.listeAxe10.size(); ++var2) {
                  if (((EcrituresAnalytiqueCtrl)this.listeAxe10.get(var2)).getEcranaMontantSaisie() == 0.0D) {
                     var1 = true;
                     break;
                  }
               }
            }

            if (!var1) {
               this.analytiqueCtrl10 = new EcrituresAnalytiqueCtrl();
               this.analytiqueCtrl10.setMesProjetsItems(this.lesProjetsItems);
               this.analytiqueCtrl10.setMesEntitesItems(new ArrayList());
               this.analytiqueCtrl10.setEntVide(true);
               this.analytiqueCtrl10.setMesPostesItems(new ArrayList());
               this.analytiqueCtrl10.setPosVide(true);
               this.listeAxe10.add(this.analytiqueCtrl10);
               this.dataModelAxe10.setWrappedData(this.listeAxe10);
            }
         }
      }

   }

   public void calculNouvelleLigne11() {
      if (this.analytiqueCtrl11 != null) {
         this.calculEcart11();
      }

   }

   public void calculNouvelleLigne12() {
      if (this.analytiqueCtrl12 != null) {
         this.calculEcart12();
      }

   }

   public void calculNouvelleLigne13() {
      if (this.analytiqueCtrl13 != null) {
         this.calculEcart13();
      }

   }

   public void calculEcart01() {
      this.totImputation01 = 0.0D;
      if (this.util_axe01 == 0) {
         if (this.listeAxe01.size() != 0) {
            for(int var1 = 0; var1 < this.listeAxe01.size(); ++var1) {
               this.totImputation01 += ((EcrituresAnalytiqueCtrl)this.listeAxe01.get(var1)).getEcranaMontantSaisie();
            }
         }

         if (this.totImputation01 < 0.0D) {
            this.ecart01 = this.montantAImputer + this.totImputation01;
         } else {
            this.ecart01 = this.montantAImputer - this.totImputation01;
         }
      }

      this.controleValidation();
   }

   public void calculEcart02() {
      this.totImputation02 = 0.0D;
      if (this.util_axe02 == 0) {
         if (this.listeAxe02.size() != 0) {
            for(int var1 = 0; var1 < this.listeAxe02.size(); ++var1) {
               this.totImputation02 += ((EcrituresAnalytiqueCtrl)this.listeAxe02.get(var1)).getEcranaMontantSaisie();
            }
         }

         if (this.totImputation02 < 0.0D) {
            this.ecart02 = this.montantAImputer + this.totImputation02;
         } else {
            this.ecart02 = this.montantAImputer - this.totImputation02;
         }
      }

      this.controleValidation();
   }

   public void calculEcart03() {
      this.totImputation03 = 0.0D;
      if (this.util_axe03 == 0) {
         if (this.listeAxe03.size() != 0) {
            for(int var1 = 0; var1 < this.listeAxe03.size(); ++var1) {
               this.totImputation03 += ((EcrituresAnalytiqueCtrl)this.listeAxe03.get(var1)).getEcranaMontantSaisie();
            }
         }

         if (this.totImputation03 < 0.0D) {
            this.ecart03 = this.montantAImputer + this.totImputation03;
         } else {
            this.ecart03 = this.montantAImputer - this.totImputation03;
         }
      }

      this.controleValidation();
   }

   public void calculEcart04() {
      this.totImputation04 = 0.0D;
      if (this.util_axe04 == 0) {
         if (this.listeAxe04.size() != 0) {
            for(int var1 = 0; var1 < this.listeAxe04.size(); ++var1) {
               this.totImputation04 += ((EcrituresAnalytiqueCtrl)this.listeAxe04.get(var1)).getEcranaMontantSaisie();
            }
         }

         if (this.totImputation04 < 0.0D) {
            this.ecart04 = this.montantAImputer + this.totImputation04;
         } else {
            this.ecart04 = this.montantAImputer - this.totImputation04;
         }
      }

      this.controleValidation();
   }

   public void calculEcart05() {
      this.totImputation05 = 0.0D;
      if (this.util_axe05 == 0) {
         if (this.listeAxe05.size() != 0) {
            int var1 = 0;

            while(true) {
               if (var1 >= this.listeAxe05.size()) {
                  this.dataModelAxe05.setWrappedData(this.listeAxe05);
                  break;
               }

               if (((EcrituresAnalytiqueCtrl)this.listeAxe05.get(var1)).getEcranaAgent() != null && !((EcrituresAnalytiqueCtrl)this.listeAxe05.get(var1)).getEcranaAgent().isEmpty()) {
                  if (((EcrituresAnalytiqueCtrl)this.listeAxe05.get(var1)).getEcranaPourcentage() != 0.0F) {
                     double var2 = this.utilNombre.myRoundDevise(this.montantAImputer * (double)((EcrituresAnalytiqueCtrl)this.listeAxe05.get(var1)).getEcranaPourcentage() / 100.0D, this.deviseEcriture);
                     ((EcrituresAnalytiqueCtrl)this.listeAxe05.get(var1)).setEcranaMontantSaisie(var2);
                  }

                  this.totImputation05 += ((EcrituresAnalytiqueCtrl)this.listeAxe05.get(var1)).getEcranaMontantSaisie();
               } else {
                  ((EcrituresAnalytiqueCtrl)this.listeAxe05.get(var1)).setEcranaAgentLib("");
                  ((EcrituresAnalytiqueCtrl)this.listeAxe05.get(var1)).setEcranaPourcentage(0.0F);
                  ((EcrituresAnalytiqueCtrl)this.listeAxe05.get(var1)).setEcranaMontantSaisie(0.0D);
               }

               ++var1;
            }
         }

         if (this.totImputation05 < 0.0D) {
            this.ecart05 = this.montantAImputer + this.totImputation05;
         } else {
            this.ecart05 = this.montantAImputer - this.totImputation05;
         }
      }

      this.controleValidation();
   }

   public void calculEcart06() {
      this.totImputation06 = 0.0D;
      if (this.util_axe06 == 0) {
         if (this.listeAxe06.size() != 0) {
            int var1 = 0;

            while(true) {
               if (var1 >= this.listeAxe06.size()) {
                  this.dataModelAxe06.setWrappedData(this.listeAxe06);
                  break;
               }

               if (((EcrituresAnalytiqueCtrl)this.listeAxe06.get(var1)).getEcranaAnal1() != null && !((EcrituresAnalytiqueCtrl)this.listeAxe06.get(var1)).getEcranaAnal1().isEmpty()) {
                  if (((EcrituresAnalytiqueCtrl)this.listeAxe06.get(var1)).getEcranaPourcentage() != 0.0F) {
                     double var2 = this.utilNombre.myRoundDevise(this.montantAImputer * (double)((EcrituresAnalytiqueCtrl)this.listeAxe06.get(var1)).getEcranaPourcentage() / 100.0D, this.deviseEcriture);
                     ((EcrituresAnalytiqueCtrl)this.listeAxe06.get(var1)).setEcranaMontantSaisie(var2);
                  }

                  this.totImputation06 += ((EcrituresAnalytiqueCtrl)this.listeAxe06.get(var1)).getEcranaMontantSaisie();
               } else {
                  ((EcrituresAnalytiqueCtrl)this.listeAxe06.get(var1)).setEcranaAnal2Lib("");
                  ((EcrituresAnalytiqueCtrl)this.listeAxe06.get(var1)).setEcranaPourcentage(0.0F);
                  ((EcrituresAnalytiqueCtrl)this.listeAxe06.get(var1)).setEcranaMontantSaisie(0.0D);
               }

               ++var1;
            }
         }

         if (this.totImputation06 < 0.0D) {
            this.ecart06 = this.montantAImputer + this.totImputation06;
         } else {
            this.ecart06 = this.montantAImputer - this.totImputation06;
         }
      }

      this.controleValidation();
   }

   public void calculEcart07() {
      this.totImputation07 = 0.0D;
      if (this.util_axe07 == 0) {
         if (this.listeAxe07.size() != 0) {
            int var1 = 0;

            while(true) {
               if (var1 >= this.listeAxe07.size()) {
                  this.dataModelAxe07.setWrappedData(this.listeAxe07);
                  break;
               }

               if (((EcrituresAnalytiqueCtrl)this.listeAxe07.get(var1)).getEcranaAnal2() != null && !((EcrituresAnalytiqueCtrl)this.listeAxe07.get(var1)).getEcranaAnal2().isEmpty()) {
                  if (((EcrituresAnalytiqueCtrl)this.listeAxe07.get(var1)).getEcranaPourcentage() != 0.0F) {
                     double var2 = this.utilNombre.myRoundDevise(this.montantAImputer * (double)((EcrituresAnalytiqueCtrl)this.listeAxe07.get(var1)).getEcranaPourcentage() / 100.0D, this.deviseEcriture);
                     ((EcrituresAnalytiqueCtrl)this.listeAxe07.get(var1)).setEcranaMontantSaisie(var2);
                  }

                  this.totImputation07 += ((EcrituresAnalytiqueCtrl)this.listeAxe07.get(var1)).getEcranaMontantSaisie();
               } else {
                  ((EcrituresAnalytiqueCtrl)this.listeAxe07.get(var1)).setEcranaAnal2Lib("");
                  ((EcrituresAnalytiqueCtrl)this.listeAxe07.get(var1)).setEcranaPourcentage(0.0F);
                  ((EcrituresAnalytiqueCtrl)this.listeAxe07.get(var1)).setEcranaMontantSaisie(0.0D);
               }

               ++var1;
            }
         }

         if (this.totImputation07 < 0.0D) {
            this.ecart07 = this.montantAImputer + this.totImputation07;
         } else {
            this.ecart07 = this.montantAImputer - this.totImputation07;
         }
      }

      this.controleValidation();
   }

   public void calculEcart08() {
      this.totImputation08 = 0.0D;
      if (this.util_axe08 == 0) {
         if (this.listeAxe08.size() != 0) {
            int var1 = 0;

            while(true) {
               if (var1 >= this.listeAxe08.size()) {
                  this.dataModelAxe08.setWrappedData(this.listeAxe08);
                  break;
               }

               if (((EcrituresAnalytiqueCtrl)this.listeAxe08.get(var1)).getEcranaAnal3() != null && !((EcrituresAnalytiqueCtrl)this.listeAxe08.get(var1)).getEcranaAnal3().isEmpty()) {
                  if (((EcrituresAnalytiqueCtrl)this.listeAxe08.get(var1)).getEcranaPourcentage() != 0.0F) {
                     double var2 = this.utilNombre.myRoundDevise(this.montantAImputer * (double)((EcrituresAnalytiqueCtrl)this.listeAxe08.get(var1)).getEcranaPourcentage() / 100.0D, this.deviseEcriture);
                     ((EcrituresAnalytiqueCtrl)this.listeAxe08.get(var1)).setEcranaMontantSaisie(var2);
                  }

                  this.totImputation08 += ((EcrituresAnalytiqueCtrl)this.listeAxe08.get(var1)).getEcranaMontantSaisie();
               } else {
                  ((EcrituresAnalytiqueCtrl)this.listeAxe08.get(var1)).setEcranaAnal3Lib("");
                  ((EcrituresAnalytiqueCtrl)this.listeAxe08.get(var1)).setEcranaPourcentage(0.0F);
                  ((EcrituresAnalytiqueCtrl)this.listeAxe08.get(var1)).setEcranaMontantSaisie(0.0D);
               }

               ++var1;
            }
         }

         if (this.totImputation08 < 0.0D) {
            this.ecart08 = this.montantAImputer + this.totImputation08;
         } else {
            this.ecart08 = this.montantAImputer - this.totImputation08;
         }
      }

      this.controleValidation();
   }

   public void calculEcart09() {
      this.totImputation09 = 0.0D;
      if (this.util_axe09 == 0) {
         if (this.listeAxe09.size() != 0) {
            int var1 = 0;

            while(true) {
               if (var1 >= this.listeAxe09.size()) {
                  this.dataModelAxe09.setWrappedData(this.listeAxe09);
                  break;
               }

               if (((EcrituresAnalytiqueCtrl)this.listeAxe09.get(var1)).getEcranaAnal4() != null && !((EcrituresAnalytiqueCtrl)this.listeAxe09.get(var1)).getEcranaAnal4().isEmpty()) {
                  if (((EcrituresAnalytiqueCtrl)this.listeAxe09.get(var1)).getEcranaPourcentage() != 0.0F) {
                     double var2 = this.utilNombre.myRoundDevise(this.montantAImputer * (double)((EcrituresAnalytiqueCtrl)this.listeAxe09.get(var1)).getEcranaPourcentage() / 100.0D, this.deviseEcriture);
                     ((EcrituresAnalytiqueCtrl)this.listeAxe09.get(var1)).setEcranaMontantSaisie(var2);
                  }

                  this.totImputation09 += ((EcrituresAnalytiqueCtrl)this.listeAxe09.get(var1)).getEcranaMontantSaisie();
               } else {
                  ((EcrituresAnalytiqueCtrl)this.listeAxe09.get(var1)).setEcranaAnal4Lib("");
                  ((EcrituresAnalytiqueCtrl)this.listeAxe09.get(var1)).setEcranaPourcentage(0.0F);
                  ((EcrituresAnalytiqueCtrl)this.listeAxe09.get(var1)).setEcranaMontantSaisie(0.0D);
               }

               ++var1;
            }
         }

         if (this.totImputation09 < 0.0D) {
            this.ecart09 = this.montantAImputer + this.totImputation09;
         } else {
            this.ecart09 = this.montantAImputer - this.totImputation09;
         }
      }

      this.controleValidation();
   }

   public void calculEcart10() {
      this.totImputation10 = 0.0D;
      if (this.util_axe10 == 0) {
         if (this.listeAxe10.size() != 0) {
            for(int var1 = 0; var1 < this.listeAxe10.size(); ++var1) {
               this.totImputation10 += ((EcrituresAnalytiqueCtrl)this.listeAxe10.get(var1)).getEcranaMontantSaisie();
            }
         }

         if (this.totImputation10 < 0.0D) {
            this.ecart10 = this.montantAImputer + this.totImputation10;
         } else {
            this.ecart10 = this.montantAImputer - this.totImputation10;
         }
      }

      this.controleValidation();
   }

   public void calculEcart11() {
      this.totImputation11 = 0.0D;
      if (this.util_axe11 == 0) {
         if (this.listeAxe11.size() != 0) {
            for(int var1 = 0; var1 < this.listeAxe11.size(); ++var1) {
               this.totImputation11 += ((EcrituresAnalytiqueCtrl)this.listeAxe11.get(var1)).getEcranaMontantSaisie();
            }
         }

         if (this.totImputation11 < 0.0D) {
            this.ecart11 = this.montantAImputer + this.totImputation11;
         } else {
            this.ecart11 = this.montantAImputer - this.totImputation11;
         }
      }

      this.controleValidation();
   }

   public void calculEcart12() {
      this.totImputation12 = 0.0D;
      if (this.util_axe12 == 0) {
         if (this.listeAxe12.size() != 0) {
            for(int var1 = 0; var1 < this.listeAxe12.size(); ++var1) {
               this.totImputation12 += ((EcrituresAnalytiqueCtrl)this.listeAxe12.get(var1)).getEcranaMontantSaisie();
            }
         }

         if (this.totImputation12 < 0.0D) {
            this.ecart12 = this.montantAImputer + this.totImputation12;
         } else {
            this.ecart12 = this.montantAImputer - this.totImputation12;
         }
      }

      this.controleValidation();
   }

   public void calculEcart13() {
      this.totImputation13 = 0.0D;
      if (this.util_axe13 == 0) {
         if (this.listeAxe13.size() != 0) {
            for(int var1 = 0; var1 < this.listeAxe13.size(); ++var1) {
               this.totImputation13 += ((EcrituresAnalytiqueCtrl)this.listeAxe13.get(var1)).getEcranaMontantSaisie();
            }
         }

         if (this.totImputation13 < 0.0D) {
            this.ecart13 = this.montantAImputer + this.totImputation13;
         } else {
            this.ecart13 = this.montantAImputer - this.totImputation13;
         }
      }

      this.controleValidation();
   }

   public void calculCleStandard() throws HibernateException, NamingException {
      if (this.cleStandard != null && !this.cleStandard.isEmpty()) {
         this.listeAxe11.clear();
         String[] var1 = this.cleStandard.split(":");
         this.plansAnalytiques = this.plansAnalytiquesDao.rechercheAnal("9", var1[0], (Session)null);
         if (this.plansAnalytiques != null) {
            new ArrayList();
            if (this.planAnalytiqueRepartitionDao == null) {
               this.planAnalytiqueRepartitionDao = new PlanAnalytiqueRepartitionDao(this.baseLog, this.utilInitHibernate);
            }

            this.natureCleRepartition = this.plansAnalytiques.getAnaNatureRepartition();
            List var2 = this.planAnalytiqueRepartitionDao.chargerLesRepartitions((PlansAnalytiques)this.plansAnalytiques, (Session)null);
            if (var2.size() != 0) {
               double var3 = 0.0D;

               for(int var5 = 0; var5 < var2.size(); ++var5) {
                  this.analytiqueCtrl11 = new EcrituresAnalytiqueCtrl();
                  this.analytiqueCtrl11.setEcranaRepCle(var1[0]);
                  this.analytiqueCtrl11.setEcranaTypeCle(this.natureCleRepartition);
                  if (this.natureCleRepartition == 100) {
                     this.analytiqueCtrl11.setEcranaSite(((PlanAnalytiqueRepartition)var2.get(var5)).getCleCodeSite());
                     this.analytiqueCtrl11.setEcranaSiteLib(((PlanAnalytiqueRepartition)var2.get(var5)).getCleLibelleSite());
                     this.analytiqueCtrl11.setEcranaDepartement(((PlanAnalytiqueRepartition)var2.get(var5)).getCleCodeDepartement());
                     this.analytiqueCtrl11.setEcranaDepartementLib(((PlanAnalytiqueRepartition)var2.get(var5)).getCleLibelleDepartement());
                     this.analytiqueCtrl11.setEcranaService(((PlanAnalytiqueRepartition)var2.get(var5)).getCleCodeService());
                     this.analytiqueCtrl11.setEcranaServiceLib(((PlanAnalytiqueRepartition)var2.get(var5)).getCleLibelleService());
                     this.analytiqueCtrl11.setEcranaPourcentage((float)((PlanAnalytiqueRepartition)var2.get(var5)).getCleRepSite());
                  } else if (this.natureCleRepartition == 101) {
                     this.analytiqueCtrl11.setEcranaRegion(((PlanAnalytiqueRepartition)var2.get(var5)).getCleCodeRegion());
                     this.analytiqueCtrl11.setEcranaRegionLib(((PlanAnalytiqueRepartition)var2.get(var5)).getCleLibelleRegion());
                     this.analytiqueCtrl11.setEcranaSecteur(((PlanAnalytiqueRepartition)var2.get(var5)).getCleCodeSecteur());
                     this.analytiqueCtrl11.setEcranaSecteurLib(((PlanAnalytiqueRepartition)var2.get(var5)).getCleLibelleSecteur());
                     this.analytiqueCtrl11.setEcranaPdv(((PlanAnalytiqueRepartition)var2.get(var5)).getCleCodePdv());
                     this.analytiqueCtrl11.setEcranaPdvLib(((PlanAnalytiqueRepartition)var2.get(var5)).getCleLibellePdv());
                     this.analytiqueCtrl11.setEcranaPourcentage((float)((PlanAnalytiqueRepartition)var2.get(var5)).getCleRepRegion());
                  } else if (this.natureCleRepartition == 102) {
                     this.analytiqueCtrl11.setEcranaSite(((PlanAnalytiqueRepartition)var2.get(var5)).getCleCodeSite());
                     this.analytiqueCtrl11.setEcranaSiteLib(((PlanAnalytiqueRepartition)var2.get(var5)).getCleLibelleSite());
                     this.analytiqueCtrl11.setEcranaLigne(((PlanAnalytiqueRepartition)var2.get(var5)).getCleCodeLigne());
                     this.analytiqueCtrl11.setEcranaLigneLib(((PlanAnalytiqueRepartition)var2.get(var5)).getCleLibelleLigne());
                     this.analytiqueCtrl11.setEcranaAtelier(((PlanAnalytiqueRepartition)var2.get(var5)).getCleCodeAtelier());
                     this.analytiqueCtrl11.setEcranaAtelierLib(((PlanAnalytiqueRepartition)var2.get(var5)).getCleLibelleAtelier());
                     this.analytiqueCtrl11.setEcranaPourcentage((float)((PlanAnalytiqueRepartition)var2.get(var5)).getCleRepLigne());
                  } else if (this.natureCleRepartition == 110) {
                     this.analytiqueCtrl11.setEcranaActivite(((PlanAnalytiqueRepartition)var2.get(var5)).getCleCodeActivite());
                     this.analytiqueCtrl11.setEcranaActiviteLib(((PlanAnalytiqueRepartition)var2.get(var5)).getCleLibelleActivite());
                     this.analytiqueCtrl11.setEcranaPourcentage((float)((PlanAnalytiqueRepartition)var2.get(var5)).getCleRepActivite());
                  } else if (this.natureCleRepartition == 120) {
                     this.analytiqueCtrl11.setEcranaAnal2(((PlanAnalytiqueRepartition)var2.get(var5)).getCleCodeParc());
                     this.analytiqueCtrl11.setEcranaAnal2Lib(((PlanAnalytiqueRepartition)var2.get(var5)).getCleLibelleParc());
                     this.analytiqueCtrl11.setEcranaPourcentage((float)((PlanAnalytiqueRepartition)var2.get(var5)).getCleRepParc());
                  } else if (this.natureCleRepartition == 122) {
                     this.analytiqueCtrl11.setEcranaAgent(((PlanAnalytiqueRepartition)var2.get(var5)).getCleCodeAgent());
                     this.analytiqueCtrl11.setEcranaAgentLib(((PlanAnalytiqueRepartition)var2.get(var5)).getCleLibelleAgent());
                     this.analytiqueCtrl11.setEcranaPourcentage((float)((PlanAnalytiqueRepartition)var2.get(var5)).getCleRepAgent());
                  } else if (this.natureCleRepartition == 6) {
                     this.analytiqueCtrl11.setEcranaAnal4(((PlanAnalytiqueRepartition)var2.get(var5)).getCleCodeDossier());
                     this.analytiqueCtrl11.setEcranaAnal4Lib(((PlanAnalytiqueRepartition)var2.get(var5)).getCleLibelleDossier());
                     this.analytiqueCtrl11.setEcranaPourcentage((float)((PlanAnalytiqueRepartition)var2.get(var5)).getCleRepDossier());
                  } else if (this.natureCleRepartition == 7) {
                     this.analytiqueCtrl11.setEcranaAnal1(((PlanAnalytiqueRepartition)var2.get(var5)).getCleCodeChantier());
                     this.analytiqueCtrl11.setEcranaAnal1Lib(((PlanAnalytiqueRepartition)var2.get(var5)).getCleLibelleChantier());
                     this.analytiqueCtrl11.setEcranaPourcentage((float)((PlanAnalytiqueRepartition)var2.get(var5)).getCleRepChantier());
                  } else if (this.natureCleRepartition == 8) {
                     this.analytiqueCtrl11.setEcranaAnal3(((PlanAnalytiqueRepartition)var2.get(var5)).getCleCodeMission());
                     this.analytiqueCtrl11.setEcranaAnal3Lib(((PlanAnalytiqueRepartition)var2.get(var5)).getCleLibelleMission());
                     this.analytiqueCtrl11.setEcranaPourcentage((float)((PlanAnalytiqueRepartition)var2.get(var5)).getCleRepMission());
                  }

                  double var6 = 0.0D;
                  if (this.analytiqueCtrl11.getEcranaPourcentage() != 0.0F) {
                     var6 = this.utilNombre.myRoundDevise(this.montantAImputer * (double)this.analytiqueCtrl11.getEcranaPourcentage() / 100.0D, this.deviseEcriture);
                     if (var5 == var2.size() - 1) {
                        this.analytiqueCtrl11.setEcranaMontantSaisie(this.montantAImputer - var3);
                     } else {
                        this.analytiqueCtrl11.setEcranaMontantSaisie(var6);
                     }
                  } else {
                     this.analytiqueCtrl11.setEcranaMontantSaisie(0.0D);
                  }

                  var3 += var6;
                  this.listeAxe11.add(this.analytiqueCtrl11);
               }
            }
         }
      } else {
         this.listeAxe11.clear();
      }

      this.dataModelAxe11.setWrappedData(this.listeAxe11);
      this.calculEcart11();
   }

   public void calculCleStructure() throws HibernateException, NamingException {
      if (this.cleStructure != null && !this.cleStructure.isEmpty()) {
         String[] var1 = this.cleStructure.split(":");
         boolean var2 = true;
         if (this.listeAxe12.size() != 0) {
            for(int var3 = 0; var3 < this.listeAxe12.size(); ++var3) {
               if (((EcrituresAnalytiqueCtrl)this.listeAxe12.get(var3)).getEcranaAxe() == 200) {
                  this.listeAxe12.clear();
                  break;
               }

               if (((EcrituresAnalytiqueCtrl)this.listeAxe12.get(var3)).getEcranaStr() != null && !((EcrituresAnalytiqueCtrl)this.listeAxe12.get(var3)).getEcranaStr().isEmpty() && ((EcrituresAnalytiqueCtrl)this.listeAxe12.get(var3)).getEcranaStr().equals(var1[0])) {
                  var2 = false;
               }
            }
         }

         if (var2) {
            this.plansAnalytiques = this.plansAnalytiquesDao.rechercheAnal("9", var1[0], (Session)null);
            if (this.plansAnalytiques != null) {
               this.listeAxe12.clear();
               new ArrayList();
               if (this.planAnalytiqueRepartitionDao == null) {
                  this.planAnalytiqueRepartitionDao = new PlanAnalytiqueRepartitionDao(this.baseLog, this.utilInitHibernate);
               }

               List var9 = this.planAnalytiqueRepartitionDao.chargerLesRepartitions((PlansAnalytiques)this.plansAnalytiques, (Session)null);
               if (var9.size() != 0) {
                  double var4 = 0.0D;

                  for(int var6 = 0; var6 < var9.size(); ++var6) {
                     this.analytiqueCtrl12 = new EcrituresAnalytiqueCtrl();
                     this.analytiqueCtrl12.setEcranaStr(((PlanAnalytiqueRepartition)var9.get(var6)).getCleSigleStr());
                     this.analytiqueCtrl12.setEcranaStrLib(((PlanAnalytiqueRepartition)var9.get(var6)).getCleNomStr());
                     this.analytiqueCtrl12.setEcranaStrCle(var1[0]);
                     this.analytiqueCtrl12.setEcranaPourcentage((float)((PlanAnalytiqueRepartition)var9.get(var6)).getCleRepStr());
                     double var7 = 0.0D;
                     if (this.analytiqueCtrl12.getEcranaPourcentage() != 0.0F) {
                        var7 = this.utilNombre.myRoundDevise(this.montantAImputer * (double)this.analytiqueCtrl12.getEcranaPourcentage() / 100.0D, this.deviseEcriture);
                        if (var6 == var9.size() - 1) {
                           this.analytiqueCtrl12.setEcranaMontantSaisie(this.montantAImputer - var4);
                        } else {
                           this.analytiqueCtrl12.setEcranaMontantSaisie(var7);
                        }
                     } else {
                        this.analytiqueCtrl12.setEcranaMontantSaisie(0.0D);
                     }

                     var4 += var7;
                     this.listeAxe12.add(this.analytiqueCtrl12);
                  }
               }
            } else {
               this.plansAnalytiques = this.plansAnalytiquesDao.rechercheAnal("20", var1[0], (Session)null);
               if (this.plansAnalytiques != null) {
                  this.analytiqueCtrl12 = new EcrituresAnalytiqueCtrl();
                  this.analytiqueCtrl12.setEcranaStr(var1[0]);
                  this.analytiqueCtrl12.setEcranaStrLib(var1[1]);
                  this.analytiqueCtrl12.setEcranaStrCle((String)null);
                  this.analytiqueCtrl12.setEcranaPourcentage(0.0F);
                  this.analytiqueCtrl12.setEcranaMontantSaisie(0.0D);
                  this.listeAxe12.add(this.analytiqueCtrl12);
               }
            }
         }
      } else {
         this.listeAxe12.clear();
      }

      this.dataModelAxe12.setWrappedData(this.listeAxe12);
      this.calculEcart12();
   }

   public String calculeValeurListe07() {
      String var1 = "";
      boolean var2 = true;
      if (this.listeAxe07.size() != 0) {
         new EcrituresAnalytiqueCtrl();

         for(int var4 = 0; var4 < this.listeAxe07.size(); ++var4) {
            EcrituresAnalytiqueCtrl var3 = (EcrituresAnalytiqueCtrl)this.listeAxe07.get(var4);
            if (var3.getEcranaAnal2() != null && !var3.getEcranaAnal2().isEmpty()) {
               if (var2) {
                  var1 = var3.getEcranaAnal2() + ":" + var3.getEcranaAnal2Lib() + ":0:" + var3.getEcranaMontantSaisie();
                  var2 = false;
               } else {
                  var1 = var1 + "#" + var3.getEcranaAnal2() + ":" + var3.getEcranaAnal2Lib() + ":0:" + var3.getEcranaMontantSaisie();
               }
            }
         }
      }

      return var1;
   }

   public double calculeTotalListe07() {
      double var1 = 0.0D;
      if (this.listeAxe07.size() != 0) {
         new EcrituresAnalytiqueCtrl();

         for(int var4 = 0; var4 < this.listeAxe07.size(); ++var4) {
            EcrituresAnalytiqueCtrl var3 = (EcrituresAnalytiqueCtrl)this.listeAxe07.get(var4);
            if (var3.getEcranaAnal2() != null && !var3.getEcranaAnal2().isEmpty()) {
               var1 += var3.getEcranaMontantSaisie();
            }
         }
      }

      return var1;
   }

   public void fixeMontantImputRecette07(double var1) {
      this.affiche_site = false;
      this.affiche_region = false;
      this.affiche_sitePrdv = false;
      this.affiche_activite = false;
      this.decoupageActivite = false;
      this.affiche_agent = false;
      this.affiche_anal1 = false;
      this.affiche_anal2 = true;
      this.affiche_anal3 = false;
      this.affiche_anal4 = false;
      this.affiche_projet = false;
      this.affiche_cles = false;
      this.affiche_str = false;
      this.sens = 0;
      this.montantAImputer = var1;
      this.util_axe01 = 0;
      this.util_axe02 = 0;
      this.util_axe03 = 0;
      this.util_axe04 = 0;
      this.util_axe05 = 0;
      this.util_axe06 = 0;
      this.util_axe07 = 0;
      this.util_axe08 = 0;
      this.util_axe09 = 0;
      this.util_axe10 = 0;
      this.util_axe11 = 0;
      this.util_axe12 = 0;
      this.util_axe13 = 0;
   }

   public void fixeMontantImputDepense07(double var1) {
      this.affiche_site = false;
      this.affiche_region = false;
      this.affiche_sitePrdv = false;
      this.affiche_activite = false;
      this.decoupageActivite = false;
      this.affiche_agent = false;
      this.affiche_anal1 = false;
      this.affiche_anal2 = true;
      this.affiche_anal3 = false;
      this.affiche_anal4 = false;
      this.affiche_projet = false;
      this.affiche_cles = false;
      this.affiche_str = false;
      this.sens = 1;
      this.montantAImputer = var1;
      this.util_axe01 = 0;
      this.util_axe02 = 0;
      this.util_axe03 = 0;
      this.util_axe04 = 0;
      this.util_axe05 = 0;
      this.util_axe06 = 0;
      this.util_axe07 = 0;
      this.util_axe08 = 0;
      this.util_axe09 = 0;
      this.util_axe10 = 0;
      this.util_axe11 = 0;
      this.util_axe12 = 0;
      this.util_axe13 = 0;
   }

   public void fixeMontantImputVirement07(double var1) {
      this.affiche_site = false;
      this.affiche_region = false;
      this.affiche_sitePrdv = false;
      this.affiche_activite = false;
      this.decoupageActivite = false;
      this.affiche_agent = false;
      this.affiche_anal1 = false;
      this.affiche_anal2 = true;
      this.affiche_anal3 = false;
      this.affiche_anal4 = false;
      this.affiche_projet = false;
      this.affiche_cles = false;
      this.affiche_str = false;
      this.sens = 0;
      this.montantAImputer = var1;
      this.util_axe01 = 0;
      this.util_axe02 = 0;
      this.util_axe03 = 0;
      this.util_axe04 = 0;
      this.util_axe05 = 0;
      this.util_axe06 = 0;
      this.util_axe07 = 0;
      this.util_axe08 = 0;
      this.util_axe09 = 0;
      this.util_axe10 = 0;
      this.util_axe11 = 0;
      this.util_axe12 = 0;
      this.util_axe13 = 0;
   }

   public void fixeMontantImputBonEntree07(double var1) {
      this.affiche_site = false;
      this.affiche_region = false;
      this.affiche_sitePrdv = false;
      this.affiche_activite = false;
      this.decoupageActivite = false;
      this.affiche_agent = false;
      this.affiche_anal1 = false;
      this.affiche_anal2 = true;
      this.affiche_anal3 = false;
      this.affiche_anal4 = false;
      this.affiche_projet = false;
      this.affiche_cles = false;
      this.affiche_str = false;
      this.sens = 0;
      this.montantAImputer = var1;
      this.util_axe01 = 0;
      this.util_axe02 = 0;
      this.util_axe03 = 0;
      this.util_axe04 = 0;
      this.util_axe05 = 0;
      this.util_axe06 = 0;
      this.util_axe07 = 0;
      this.util_axe08 = 0;
      this.util_axe09 = 0;
      this.util_axe10 = 0;
      this.util_axe11 = 0;
      this.util_axe12 = 0;
      this.util_axe13 = 0;
   }

   public void fixeMontantImputBonSortie07(double var1) {
      this.affiche_site = false;
      this.affiche_region = false;
      this.affiche_sitePrdv = false;
      this.affiche_activite = false;
      this.decoupageActivite = false;
      this.affiche_agent = false;
      this.affiche_anal1 = false;
      this.affiche_anal2 = true;
      this.affiche_anal3 = false;
      this.affiche_anal4 = false;
      this.affiche_projet = false;
      this.affiche_cles = false;
      this.affiche_str = false;
      this.sens = 1;
      this.montantAImputer = var1;
      this.util_axe01 = 0;
      this.util_axe02 = 0;
      this.util_axe03 = 0;
      this.util_axe04 = 0;
      this.util_axe05 = 0;
      this.util_axe06 = 0;
      this.util_axe07 = 0;
      this.util_axe08 = 0;
      this.util_axe09 = 0;
      this.util_axe10 = 0;
      this.util_axe11 = 0;
      this.util_axe12 = 0;
      this.util_axe13 = 0;
   }

   public void chargementDetailAnalytique(Ecritures var1, boolean var2, Session var3) throws HibernateException, NamingException {
      this.modeConsultation = var2;
      if (this.structureLog.getStrDossier() == 3) {
         this.modeTransit = true;
      } else {
         this.modeTransit = false;
      }

      this.montantAImputer = 0.0D;
      this.sens = 0;
      if (var1.getEcrDebitSaisie() != 0.0D && var1.getEcrCreditSaisie() == 0.0D) {
         this.sens = 0;
         this.montantAImputer = Math.abs(var1.getEcrDebitSaisie());
      } else {
         this.sens = 1;
         this.montantAImputer = Math.abs(var1.getEcrCreditSaisie());
      }

      this.deviseEcriture = var1.getEcrDeviseSaisie();
      if (this.deviseEcriture == null || this.deviseEcriture.isEmpty()) {
         this.deviseEcriture = this.structureLog.getStrdevise();
      }

      if (this.ecrituresAnalytiquesDao == null) {
         this.ecrituresAnalytiquesDao = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      }

      if (this.affiche_projet) {
         this.affiche_projet = this.testCompteBudget(var1);
      }

      this.listeAxe01.clear();
      this.listeAxe02.clear();
      this.listeAxe03.clear();
      this.listeAxe04.clear();
      this.listeAxe05.clear();
      this.listeAxe06.clear();
      this.listeAxe07.clear();
      this.listeAxe08.clear();
      this.listeAxe09.clear();
      this.listeAxe10.clear();
      this.listeAxe11.clear();
      this.listeAxe12.clear();
      this.listeAxe13.clear();
      this.lesImputDossiers.clear();
      this.affiche_autre = false;
      new ArrayList();
      List var4 = this.ecrituresAnalytiquesDao.chargerLesEcrituresAnalytiques(var1, var3);
      this.ecrituresAnalytique = new EcrituresAnalytique();
      if (var4.size() != 0) {
         for(int var5 = 0; var5 < var4.size(); ++var5) {
            this.ecrituresAnalytique = (EcrituresAnalytique)var4.get(var5);
            if (this.ecrituresAnalytique.getEcranaAxe() == 100) {
               this.affiche_site = true;
               this.analytiqueCtrl01 = new EcrituresAnalytiqueCtrl();
               this.analytiqueCtrl01.setMesSitesItems(this.lesSitesItems);
               this.analytiqueCtrl01.setMesDepartementsItems(new ArrayList());
               this.analytiqueCtrl01.setMesServicesItems(new ArrayList());
               this.analytiqueCtrl01.setDepVide(true);
               this.analytiqueCtrl01.setSerVide(true);
               this.listeAxe01.add(this.calculeEcrCtrl(this.analytiqueCtrl01, this.ecrituresAnalytique));
            } else if (this.ecrituresAnalytique.getEcranaAxe() == 101) {
               this.affiche_region = true;
               this.analytiqueCtrl02 = new EcrituresAnalytiqueCtrl();
               this.analytiqueCtrl02.setMesRegionsItems(this.lesRegionsItems);
               this.analytiqueCtrl02.setMesSecteursItems(new ArrayList());
               this.analytiqueCtrl02.setMesPdvItems(new ArrayList());
               this.analytiqueCtrl02.setSecVide(true);
               this.analytiqueCtrl02.setPdvVide(true);
               this.listeAxe02.add(this.calculeEcrCtrl(this.analytiqueCtrl02, this.ecrituresAnalytique));
            } else if (this.ecrituresAnalytique.getEcranaAxe() == 102) {
               this.affiche_sitePrdv = true;
               this.analytiqueCtrl03 = new EcrituresAnalytiqueCtrl();
               this.analytiqueCtrl03.setMesSitesItems(this.lesSitesPrdItems);
               this.analytiqueCtrl03.setMesLignesItems(new ArrayList());
               this.analytiqueCtrl03.setMesAteliersItems(new ArrayList());
               this.analytiqueCtrl03.setLigVide(true);
               this.analytiqueCtrl03.setAteVide(true);
               this.listeAxe03.add(this.calculeEcrCtrl(this.analytiqueCtrl03, this.ecrituresAnalytique));
            } else if (this.ecrituresAnalytique.getEcranaAxe() == 110) {
               this.affiche_activite = true;
               this.analytiqueCtrl04 = new EcrituresAnalytiqueCtrl();
               this.analytiqueCtrl04.setMesColonnes1Items(this.lesColonnes1Items);
               this.analytiqueCtrl04.setMesColonnes2Items(this.lesColonnes2Items);
               this.analytiqueCtrl04.setMesColonnes3Items(this.lesColonnes3Items);
               this.listeAxe04.add(this.calculeEcrCtrl(this.analytiqueCtrl04, this.ecrituresAnalytique));
            } else if (this.ecrituresAnalytique.getEcranaAxe() == 122) {
               this.affiche_agent = true;
               this.analytiqueCtrl05 = new EcrituresAnalytiqueCtrl();
               this.listeAxe05.add(this.calculeEcrCtrl(this.analytiqueCtrl05, this.ecrituresAnalytique));
            } else if (this.ecrituresAnalytique.getEcranaAxe() == 7) {
               this.affiche_anal1 = true;
               this.analytiqueCtrl06 = new EcrituresAnalytiqueCtrl();
               this.listeAxe06.add(this.calculeEcrCtrl(this.analytiqueCtrl06, this.ecrituresAnalytique));
            } else if (this.ecrituresAnalytique.getEcranaAxe() == 120) {
               this.affiche_anal2 = true;
               this.analytiqueCtrl07 = new EcrituresAnalytiqueCtrl();
               this.listeAxe07.add(this.calculeEcrCtrl(this.analytiqueCtrl07, this.ecrituresAnalytique));
            } else if (this.ecrituresAnalytique.getEcranaAxe() == 8) {
               this.affiche_anal3 = true;
               this.analytiqueCtrl08 = new EcrituresAnalytiqueCtrl();
               this.listeAxe08.add(this.calculeEcrCtrl(this.analytiqueCtrl08, this.ecrituresAnalytique));
            } else if (this.ecrituresAnalytique.getEcranaAxe() != 6 && this.ecrituresAnalytique.getEcranaAxe() != 121) {
               if (this.ecrituresAnalytique.getEcranaAxe() == 150) {
                  this.affiche_projet = true;
                  this.analytiqueCtrl10 = new EcrituresAnalytiqueCtrl();
                  this.analytiqueCtrl10.setMesProjetsItems(this.lesProjetsItems);
                  this.analytiqueCtrl10.setMesEntitesItems(new ArrayList());
                  this.analytiqueCtrl10.setEntVide(true);
                  this.analytiqueCtrl10.setMesPostesItems(new ArrayList());
                  this.analytiqueCtrl10.setPosVide(true);
                  this.listeAxe10.add(this.calculeEcrCtrl(this.analytiqueCtrl10, this.ecrituresAnalytique));
               } else if (this.ecrituresAnalytique.getEcranaAxe() == 9) {
                  this.affiche_cles = true;
                  this.analytiqueCtrl11 = new EcrituresAnalytiqueCtrl();
                  this.listeAxe11.add(this.calculeEcrCtrl(this.analytiqueCtrl11, this.ecrituresAnalytique));
               } else if (this.ecrituresAnalytique.getEcranaAxe() == 200) {
                  this.affiche_str = true;
                  this.analytiqueCtrl12 = new EcrituresAnalytiqueCtrl();
                  this.listeAxe12.add(this.calculeEcrCtrl(this.analytiqueCtrl12, this.ecrituresAnalytique));
               } else {
                  this.affiche_autre = true;
                  this.analytiqueCtrl13 = new EcrituresAnalytiqueCtrl();
                  this.listeAxe13.add(this.calculeEcrCtrl(this.analytiqueCtrl13, this.ecrituresAnalytique));
               }
            } else {
               this.affiche_anal4 = true;
               this.analytiqueCtrl09 = new EcrituresAnalytiqueCtrl();
               this.listeAxe09.add(this.calculeEcrCtrl(this.analytiqueCtrl09, this.ecrituresAnalytique));
            }
         }
      }

      if (!var1.isEcrAnaAxe01() && this.affiche_site) {
         this.util_axe01 = 0;
      } else {
         this.util_axe01 = 1;
      }

      if (!var1.isEcrAnaAxe02() && this.affiche_region) {
         this.util_axe02 = 0;
      } else {
         this.util_axe02 = 1;
      }

      if (!var1.isEcrAnaAxe03() && this.affiche_sitePrdv) {
         this.util_axe03 = 0;
      } else {
         this.util_axe03 = 1;
      }

      if (!var1.isEcrAnaAxe04() && this.affiche_activite) {
         this.util_axe04 = 0;
      } else {
         this.util_axe04 = 1;
      }

      if (!var1.isEcrAnaAxe05() && this.affiche_agent) {
         this.util_axe05 = 0;
      } else {
         this.util_axe05 = 1;
      }

      if (!var1.isEcrAnaAxe06() && this.affiche_anal1) {
         this.util_axe06 = 0;
      } else {
         this.util_axe06 = 1;
      }

      if (!var1.isEcrAnaAxe07() && this.affiche_anal2) {
         this.util_axe07 = 0;
      } else {
         this.util_axe07 = 1;
      }

      if (!var1.isEcrAnaAxe08() && this.affiche_anal3) {
         this.util_axe08 = 0;
      } else {
         this.util_axe08 = 1;
      }

      if (!var1.isEcrAnaAxe09() && this.affiche_anal4) {
         this.util_axe09 = 0;
      } else {
         this.util_axe09 = 1;
      }

      if (!var1.isEcrAnaAxe10() && this.affiche_projet) {
         this.util_axe10 = 0;
      } else {
         this.util_axe10 = 1;
      }

      if (!var1.isEcrAnaAxe11() && this.affiche_cles) {
         this.util_axe11 = 0;
      } else {
         this.util_axe11 = 1;
      }

      if (!var1.isEcrAnaAxe12() && this.affiche_str) {
         this.util_axe12 = 0;
      } else {
         this.util_axe12 = 1;
      }

      if (!var1.isEcrAnaAxe13() && this.affiche_autre) {
         this.util_axe13 = 0;
      } else {
         this.util_axe13 = 1;
      }

      if (var4.size() == 0) {
         if (this.usersLog.isUsrCptSite()) {
            this.util_axe01 = 1;
         }

         if (this.usersLog.isUsrCptRegion()) {
            this.util_axe02 = 1;
         }

         if (this.usersLog.isUsrCptUsine()) {
            this.util_axe03 = 1;
         }

         if (this.usersLog.isUsrCptActivite()) {
            this.util_axe04 = 1;
         }

         if (this.usersLog.isUsrCptAgent()) {
            this.util_axe05 = 1;
         }

         if (this.usersLog.isUsrCptChantier()) {
            this.util_axe06 = 1;
         }

         if (this.usersLog.isUsrCptParc()) {
            this.util_axe07 = 1;
         }

         if (this.usersLog.isUsrCptMission()) {
            this.util_axe08 = 1;
         }

         if (this.usersLog.isUsrCptDossier()) {
            this.util_axe09 = 1;
         }

         if (this.usersLog.isUsrCptProjet()) {
            this.util_axe10 = 1;
         }

         if (this.usersLog.isUsrCptCles()) {
            this.util_axe11 = 1;
         }

         if (this.usersLog.isUsrCptStructure()) {
            this.util_axe12 = 1;
         }
      }

      if (!this.modeConsultation) {
         this.initialiseLigne();
      }

      this.totDebit = 0.0D;
      this.totCredit = 0.0D;
      this.totSolde = 0.0D;
      if (this.modeTransit && var1.getEcrDossier() != null && !var1.getEcrDossier().isEmpty()) {
         EcrituresDao var7 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
         this.lesImputDossiers = var7.chargerEcrituresTransit(var1.getEcrDossier(), var3);

         for(int var6 = 0; var6 < this.lesImputDossiers.size(); ++var6) {
            this.totDebit += ((Ecritures)this.lesImputDossiers.get(var6)).getEcrDebitSaisie();
            this.totCredit += ((Ecritures)this.lesImputDossiers.get(var6)).getEcrCreditSaisie();
         }

         this.totSolde = this.totDebit - this.totCredit;
      }

      this.dataModelAxe01.setWrappedData(this.listeAxe01);
      this.dataModelAxe02.setWrappedData(this.listeAxe02);
      this.dataModelAxe03.setWrappedData(this.listeAxe03);
      this.dataModelAxe04.setWrappedData(this.listeAxe04);
      this.dataModelAxe05.setWrappedData(this.listeAxe05);
      this.dataModelAxe06.setWrappedData(this.listeAxe06);
      this.dataModelAxe07.setWrappedData(this.listeAxe07);
      this.dataModelAxe08.setWrappedData(this.listeAxe08);
      this.dataModelAxe09.setWrappedData(this.listeAxe09);
      this.dataModelAxe10.setWrappedData(this.listeAxe10);
      this.dataModelAxe11.setWrappedData(this.listeAxe11);
      this.dataModelAxe12.setWrappedData(this.listeAxe12);
      this.dataModelAxe13.setWrappedData(this.listeAxe13);
      this.dataModelImputDossier.setWrappedData(this.lesImputDossiers);
      this.calculEcart01();
      this.calculEcart02();
      this.calculEcart03();
      this.calculEcart04();
      this.calculEcart05();
      this.calculEcart06();
      this.calculEcart07();
      this.calculEcart08();
      this.calculEcart09();
      this.calculEcart10();
      this.calculEcart11();
      this.calculEcart12();
      this.calculEcart13();
      if (var2) {
         if (this.affiche_site && this.listeAxe01.size() == 0) {
            this.affiche_site = false;
         }

         if (this.affiche_region && this.listeAxe02.size() == 0) {
            this.affiche_region = false;
         }

         if (this.affiche_sitePrdv && this.listeAxe03.size() == 0) {
            this.affiche_sitePrdv = false;
         }

         if (this.affiche_activite && this.listeAxe04.size() == 0) {
            this.affiche_activite = false;
         }

         if (this.affiche_agent && this.listeAxe05.size() == 0) {
            this.affiche_agent = false;
         }

         if (this.affiche_anal1 && this.listeAxe06.size() == 0) {
            this.affiche_anal1 = false;
         }

         if (this.affiche_anal2 && this.listeAxe07.size() == 0) {
            this.affiche_anal2 = false;
         }

         if (this.affiche_anal3 && this.listeAxe08.size() == 0) {
            this.affiche_anal3 = false;
         }

         if (this.affiche_anal4 && this.listeAxe09.size() == 0) {
            this.affiche_anal4 = false;
         }

         if (this.affiche_projet && this.listeAxe10.size() == 0) {
            this.affiche_projet = false;
         }

         if (this.affiche_cles && this.listeAxe11.size() == 0) {
            this.affiche_cles = false;
         }

         if (this.affiche_str && this.listeAxe12.size() == 0) {
            this.affiche_str = false;
         }
      }

   }

   public void initialiseLigne() {
      this.ecrituresAnalytique = new EcrituresAnalytique();
      if (this.affiche_site && this.listeAxe01.size() == 0 && this.util_axe01 == 0) {
         this.analytiqueCtrl01 = new EcrituresAnalytiqueCtrl();
         this.analytiqueCtrl01.setMesSitesItems(this.lesSitesItems);
         this.analytiqueCtrl01.setMesDepartementsItems(new ArrayList());
         this.analytiqueCtrl01.setMesServicesItems(new ArrayList());
         this.analytiqueCtrl01.setDepVide(true);
         this.analytiqueCtrl01.setSerVide(true);
         this.listeAxe01.add(this.calculeEcrCtrl(this.analytiqueCtrl01, this.ecrituresAnalytique));
      }

      if (this.affiche_region && this.listeAxe02.size() == 0 && this.util_axe02 == 0) {
         this.analytiqueCtrl02 = new EcrituresAnalytiqueCtrl();
         this.analytiqueCtrl02.setMesRegionsItems(this.lesRegionsItems);
         this.analytiqueCtrl02.setMesSecteursItems(new ArrayList());
         this.analytiqueCtrl02.setMesPdvItems(new ArrayList());
         this.analytiqueCtrl02.setSecVide(true);
         this.analytiqueCtrl02.setPdvVide(true);
         this.listeAxe02.add(this.calculeEcrCtrl(this.analytiqueCtrl02, this.ecrituresAnalytique));
      }

      if (this.affiche_sitePrdv && this.listeAxe03.size() == 0 && this.util_axe03 == 0) {
         this.analytiqueCtrl03 = new EcrituresAnalytiqueCtrl();
         this.analytiqueCtrl03.setMesSitesItems(this.lesSitesPrdItems);
         this.analytiqueCtrl03.setMesLignesItems(new ArrayList());
         this.analytiqueCtrl03.setMesAteliersItems(new ArrayList());
         this.analytiqueCtrl03.setLigVide(true);
         this.analytiqueCtrl03.setAteVide(true);
         this.listeAxe03.add(this.calculeEcrCtrl(this.analytiqueCtrl03, this.ecrituresAnalytique));
      }

      if (this.affiche_activite && this.listeAxe04.size() == 0 && this.util_axe04 == 0) {
         this.analytiqueCtrl04 = new EcrituresAnalytiqueCtrl();
         this.analytiqueCtrl04.setMesColonnes1Items(this.lesColonnes1Items);
         this.analytiqueCtrl04.setMesColonnes2Items(this.lesColonnes2Items);
         this.analytiqueCtrl04.setMesColonnes3Items(this.lesColonnes3Items);
         this.listeAxe04.add(this.calculeEcrCtrl(this.analytiqueCtrl04, this.ecrituresAnalytique));
      }

      if (this.affiche_agent && this.listeAxe05.size() == 0 && this.util_axe05 == 0) {
         this.analytiqueCtrl05 = new EcrituresAnalytiqueCtrl();
         this.listeAxe05.add(this.calculeEcrCtrl(this.analytiqueCtrl05, this.ecrituresAnalytique));
      }

      if (this.affiche_anal1 && this.listeAxe06.size() == 0 && this.util_axe06 == 0) {
         this.analytiqueCtrl06 = new EcrituresAnalytiqueCtrl();
         this.listeAxe06.add(this.calculeEcrCtrl(this.analytiqueCtrl06, this.ecrituresAnalytique));
      }

      if (this.affiche_anal2 && this.listeAxe07.size() == 0 && this.util_axe07 == 0) {
         this.analytiqueCtrl07 = new EcrituresAnalytiqueCtrl();
         this.listeAxe07.add(this.calculeEcrCtrl(this.analytiqueCtrl07, this.ecrituresAnalytique));
      }

      if (this.affiche_anal3 && this.listeAxe08.size() == 0 && this.util_axe08 == 0) {
         this.analytiqueCtrl08 = new EcrituresAnalytiqueCtrl();
         this.listeAxe08.add(this.calculeEcrCtrl(this.analytiqueCtrl08, this.ecrituresAnalytique));
      }

      if (this.affiche_anal4 && this.listeAxe09.size() == 0 && this.util_axe09 == 0 && this.structureLog.getStrDossier() == 1) {
         this.analytiqueCtrl09 = new EcrituresAnalytiqueCtrl();
         this.listeAxe09.add(this.calculeEcrCtrl(this.analytiqueCtrl09, this.ecrituresAnalytique));
      }

      if (this.affiche_projet && this.listeAxe10.size() == 0 && this.util_axe10 == 0) {
         this.analytiqueCtrl10 = new EcrituresAnalytiqueCtrl();
         this.analytiqueCtrl10.setMesProjetsItems(this.lesProjetsItems);
         this.analytiqueCtrl10.setMesEntitesItems(new ArrayList());
         this.analytiqueCtrl10.setEntVide(true);
         this.analytiqueCtrl10.setMesPostesItems(new ArrayList());
         this.analytiqueCtrl10.setPosVide(true);
         this.listeAxe10.add(this.calculeEcrCtrl(this.analytiqueCtrl10, this.ecrituresAnalytique));
      }

      if (this.affiche_cles && this.listeAxe11.size() == 0 && this.util_axe11 == 0) {
      }

      if (this.affiche_str && this.listeAxe12.size() == 0 && this.util_axe12 == 0) {
      }

   }

   public EcrituresAnalytiqueCtrl calculeEcrCtrl(EcrituresAnalytiqueCtrl var1, EcrituresAnalytique var2) {
      var1.setEcranaAxe(var2.getEcranaAxe());
      var1.setEcranaClasse(var2.getEcranaClasse());
      var1.setEcranaCle(var2.getEcranaCle());
      var1.setEcranaCle1(var2.getEcranaCle1());
      var1.setEcranaCle2(var2.getEcranaCle2());
      var1.setEcranaCode(var2.getEcranaCode());
      var1.setEcranaCompte(var2.getEcranaCompte());
      var1.setEcranaDateSaisie(var2.getEcranaDateSaisie());
      var1.setEcranaId(var2.getEcranaId());
      var1.setEcranaIdOrigine(var2.getEcranaIdOrigine());
      var1.setEcranaLibelle(var2.getEcranaLibelle());
      var1.setEcranaMontantSaisie(var2.getEcranaMontantSaisie());
      var1.setEcranaNature(var2.getEcranaNature());
      var1.setEcranaNatureJrx(var2.getEcranaNatureJrx());
      var1.setEcranaOrdre(var2.getEcranaOrdre());
      var1.setEcranaPeriode(var2.getEcranaPeriode());
      var1.setEcranaPiece(var2.getEcranaPiece());
      var1.setEcranaPourcentage(var2.getEcranaPourcentage());
      var1.setEcranaReference1(var2.getEcranaReference1());
      var1.setEcranaReference2(var2.getEcranaReference2());
      var1.setEcranaReserve(var2.getEcranaReserve());
      var1.setEcranaTypeOrigine(var2.getEcranaTypeOrigine());
      var1.setEcranaActivite(var2.getEcranaActivite());
      var1.setEcranaActiviteLib(var2.getEcranaActiviteLib());
      if (this.decoupageActivite) {
         var1.setZoneCol1(var2.getEcranaActivite() + ":" + var2.getEcranaActiviteLib());
         var1.setZoneCol2(var2.getEcranaAnal1() + ":" + var2.getEcranaAnal1Lib());
         var1.setZoneCol3(var2.getEcranaAnal3() + ":" + var2.getEcranaAnal3Lib());
      } else {
         var1.setZoneActivite(var2.getEcranaActivite() + ":" + var2.getEcranaActiviteLib());
      }

      var1.setEcranaAnal1(var2.getEcranaAnal1());
      var1.setEcranaAnal1Lib(var2.getEcranaAnal1Lib());
      var1.setEcranaAnal2(var2.getEcranaAnal2());
      var1.setEcranaAnal2Lib(var2.getEcranaAnal2Lib());
      var1.setEcranaAnal3(var2.getEcranaAnal3());
      var1.setEcranaAnal3Lib(var2.getEcranaAnal3Lib());
      var1.setEcranaAnal4(var2.getEcranaAnal4());
      var1.setEcranaAnal4Lib(var2.getEcranaAnal4Lib());
      var1.setEcranaSite(var2.getEcranaSite());
      var1.setEcranaSiteLib(var2.getEcranaSiteLib());
      var1.setZoneSite(var2.getEcranaSite() + ":" + var2.getEcranaSiteLib());
      var1.setEcranaDepartement(var2.getEcranaDepartement());
      var1.setEcranaDepartementLib(var2.getEcranaDepartementLib());
      var1.setZoneDepartement(var2.getEcranaDepartement() + ":" + var2.getEcranaDepartementLib());
      var1.setEcranaService(var2.getEcranaService());
      var1.setEcranaServiceLib(var2.getEcranaServiceLib());
      var1.setZoneService(var2.getEcranaService() + ":" + var2.getEcranaServiceLib());
      var1.setEcranaRegion(var2.getEcranaRegion());
      var1.setEcranaRegionLib(var2.getEcranaRegionLib());
      var1.setZoneRegion(var2.getEcranaRegion() + ":" + var2.getEcranaRegionLib());
      var1.setEcranaSecteur(var2.getEcranaSecteur());
      var1.setEcranaSecteurLib(var2.getEcranaSecteurLib());
      var1.setZoneSecteur(var2.getEcranaSecteur() + ":" + var2.getEcranaSecteurLib());
      var1.setEcranaPdv(var2.getEcranaPdv());
      var1.setEcranaPdvLib(var2.getEcranaPdvLib());
      var1.setZonePdv(var2.getEcranaPdv() + ":" + var2.getEcranaPdvLib());
      var1.setEcranaLigne(var2.getEcranaLigne());
      var1.setEcranaLigneLib(var2.getEcranaLigneLib());
      var1.setZoneLigne(var2.getEcranaLigne() + ":" + var2.getEcranaLigneLib());
      var1.setEcranaAtelier(var2.getEcranaAtelier());
      var1.setEcranaAtelierLib(var2.getEcranaAtelierLib());
      var1.setZoneAtelier(var2.getEcranaAtelier() + ":" + var2.getEcranaAtelierLib());
      var1.setEcranaAgent(var2.getEcranaAgent());
      var1.setEcranaAgentLib(var2.getEcranaAgentLib());
      var1.setEcranaStr(var2.getEcranaStr());
      var1.setEcranaStrLib(var2.getEcranaStrLib());
      var1.setEcranaStrCle(var2.getEcranaStrCle());
      var1.setEcranaRepCle(var2.getEcranaRepCle());
      var1.setEcranaTypeCle(var2.getEcranaTypeCle());
      var1.setEcranaProjet(var2.getEcranaProjet());
      var1.setEcranaProjetLib(var2.getEcranaProjetLib());
      var1.setZoneProjet(var2.getEcranaProjet() + ":" + var2.getEcranaProjetLib());
      var1.setEcranaEntite(var2.getEcranaEntite());
      var1.setEcranaEntiteLib(var2.getEcranaEntiteLib());
      var1.setZonePoste(var2.getEcranaEntite() + ":" + var2.getEcranaEntiteLib());
      var1.setEcranaPoste(var2.getEcranaPoste());
      var1.setEcranaPosteLib(var2.getEcranaPosteLib());
      var1.setZonePoste(var2.getEcranaPoste() + ":" + var2.getEcranaPosteLib());
      return var1;
   }

   public EcrituresAnalytique calculeEcrCtrl(Ecritures var1, EcrituresAnalytiqueCtrl var2) {
      EcrituresAnalytique var3 = new EcrituresAnalytique();
      var3.setEcritures(var1);
      var3.setEcranaSens(this.sens);
      var3.setEcranaClasse(var1.getEcrClasse());
      var3.setEcranaCle1(var1.getEcrCle1());
      var3.setEcranaCle2(var1.getEcrCle2());
      var3.setEcranaCode(var1.getEcrCode());
      var3.setEcranaCompte(var1.getEcrCompte());
      var3.setEcranaDateSaisie(var1.getEcrDateSaisie());
      var3.setEcranaIdOrigine(var1.getEcrIdOrigine());
      var3.setEcranaLibelle(var1.getEcrLibelle());
      var3.setEcranaNature(var1.getEcrNature());
      var3.setEcranaNatureJrx(var1.getEcrNatureJrx());
      var3.setEcranaPeriode(var1.getEcrPeriode());
      var3.setEcranaPiece(var1.getEcrPiece());
      var3.setEcranaReference1(var1.getEcrReference1());
      var3.setEcranaReference2(var1.getEcrReference2());
      var3.setEcranaReserve(var1.getEcrReserve());
      var3.setEcranaTypeOrigine(var1.getEcrTypeOrigine());
      var3.setEcranaAxe(var2.getEcranaAxe());
      if (var1.getEcrDebitSaisie() != 0.0D && var1.getEcrCreditSaisie() == 0.0D) {
         if (var1.getEcrDebitSaisie() < 0.0D) {
            var3.setEcranaMontantSaisie(Math.abs(var2.getEcranaMontantSaisie()) * -1.0D);
         } else {
            var3.setEcranaMontantSaisie(Math.abs(var2.getEcranaMontantSaisie()));
         }
      } else if (var1.getEcrCreditSaisie() < 0.0D) {
         var3.setEcranaMontantSaisie(Math.abs(var2.getEcranaMontantSaisie()) * -1.0D);
      } else {
         var3.setEcranaMontantSaisie(Math.abs(var2.getEcranaMontantSaisie()));
      }

      var3.setEcranaPourcentage(var2.getEcranaPourcentage());
      var3.setEcranaOrdre(var2.getEcranaOrdre());
      var3.setEcranaCle(var2.getEcranaCle());
      var3.setEcranaActivite(var2.getEcranaActivite());
      var3.setEcranaActiviteLib(var2.getEcranaActiviteLib());
      var3.setEcranaAnal1(var2.getEcranaAnal1());
      var3.setEcranaAnal1Lib(var2.getEcranaAnal1Lib());
      var3.setEcranaAnal2(var2.getEcranaAnal2());
      var3.setEcranaAnal2Lib(var2.getEcranaAnal2Lib());
      var3.setEcranaAnal3(var2.getEcranaAnal3());
      var3.setEcranaAnal3Lib(var2.getEcranaAnal3Lib());
      var3.setEcranaAnal4(var2.getEcranaAnal4());
      var3.setEcranaAnal4Lib(var2.getEcranaAnal4Lib());
      var3.setEcranaSite(var2.getEcranaSite());
      var3.setEcranaSiteLib(var2.getEcranaSiteLib());
      var3.setEcranaDepartement(var2.getEcranaDepartement());
      var3.setEcranaDepartementLib(var2.getEcranaDepartementLib());
      var3.setEcranaService(var2.getEcranaService());
      var3.setEcranaServiceLib(var2.getEcranaServiceLib());
      var3.setEcranaRegion(var2.getEcranaRegion());
      var3.setEcranaRegionLib(var2.getEcranaRegionLib());
      var3.setEcranaSecteur(var2.getEcranaSecteur());
      var3.setEcranaSecteurLib(var2.getEcranaSecteurLib());
      var3.setEcranaPdv(var2.getEcranaPdv());
      var3.setEcranaPdvLib(var2.getEcranaPdvLib());
      var3.setEcranaLigne(var2.getEcranaLigne());
      var3.setEcranaLigneLib(var2.getEcranaLigneLib());
      var3.setEcranaAtelier(var2.getEcranaAtelier());
      var3.setEcranaAtelierLib(var2.getEcranaAtelierLib());
      var3.setEcranaAgent(var2.getEcranaAgent());
      var3.setEcranaAgentLib(var2.getEcranaAgentLib());
      var3.setEcranaStr(var2.getEcranaStr());
      var3.setEcranaStrLib(var2.getEcranaStrLib());
      var3.setEcranaStrCle(var2.getEcranaStrCle());
      var3.setEcranaRepCle(var2.getEcranaRepCle());
      var3.setEcranaTypeCle(var2.getEcranaTypeCle());
      var3.setEcranaProjet(var2.getEcranaProjet());
      var3.setEcranaProjetLib(var2.getEcranaProjetLib());
      var3.setEcranaEntite(var2.getEcranaEntite());
      var3.setEcranaEntiteLib(var2.getEcranaEntiteLib());
      var3.setEcranaPoste(var2.getEcranaPoste());
      var3.setEcranaPosteLib(var2.getEcranaPosteLib());
      return var3;
   }

   public void saveDetailAnalytique(long var1, EcrituresDao var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         new Ecritures();
         Ecritures var6 = var3.recupererSelectedECById(var1, var4);
         if (var6 != null) {
            this.nettoyageDetailAnalytique(var6, var4);
            int var7;
            if (this.listeAxe01.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe01.size(); ++var7) {
                  this.analytiqueCtrl01 = (EcrituresAnalytiqueCtrl)this.listeAxe01.get(var7);
                  if (this.analytiqueCtrl01.getEcranaMontantSaisie() != 0.0D) {
                     this.analytiqueCtrl01.setEcranaAxe(100);
                     this.ecrituresAnalytiquesDao.inserEcritureAnalytiques(var4, this.calculeEcrCtrl(var6, this.analytiqueCtrl01));
                  }
               }
            }

            if (this.listeAxe02.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe02.size(); ++var7) {
                  this.analytiqueCtrl02 = (EcrituresAnalytiqueCtrl)this.listeAxe02.get(var7);
                  if (this.analytiqueCtrl02.getEcranaMontantSaisie() != 0.0D) {
                     this.analytiqueCtrl02.setEcranaAxe(101);
                     this.ecrituresAnalytiquesDao.inserEcritureAnalytiques(var4, this.calculeEcrCtrl(var6, this.analytiqueCtrl02));
                  }
               }
            }

            if (this.listeAxe03.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe03.size(); ++var7) {
                  this.analytiqueCtrl03 = (EcrituresAnalytiqueCtrl)this.listeAxe03.get(var7);
                  if (this.analytiqueCtrl03.getEcranaMontantSaisie() != 0.0D) {
                     this.analytiqueCtrl03.setEcranaAxe(102);
                     this.ecrituresAnalytiquesDao.inserEcritureAnalytiques(var4, this.calculeEcrCtrl(var6, this.analytiqueCtrl03));
                  }
               }
            }

            if (this.listeAxe04.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe04.size(); ++var7) {
                  this.analytiqueCtrl04 = (EcrituresAnalytiqueCtrl)this.listeAxe04.get(var7);
                  if (this.analytiqueCtrl04.getEcranaMontantSaisie() != 0.0D) {
                     this.analytiqueCtrl04.setEcranaAxe(110);
                     this.ecrituresAnalytiquesDao.inserEcritureAnalytiques(var4, this.calculeEcrCtrl(var6, this.analytiqueCtrl04));
                  }
               }
            }

            if (this.listeAxe05.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe05.size(); ++var7) {
                  this.analytiqueCtrl05 = (EcrituresAnalytiqueCtrl)this.listeAxe05.get(var7);
                  if (this.analytiqueCtrl05.getEcranaMontantSaisie() != 0.0D) {
                     this.analytiqueCtrl05.setEcranaAxe(122);
                     this.ecrituresAnalytiquesDao.inserEcritureAnalytiques(var4, this.calculeEcrCtrl(var6, this.analytiqueCtrl05));
                  }
               }
            }

            if (this.listeAxe06.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe06.size(); ++var7) {
                  this.analytiqueCtrl06 = (EcrituresAnalytiqueCtrl)this.listeAxe06.get(var7);
                  if (this.analytiqueCtrl06.getEcranaMontantSaisie() != 0.0D) {
                     this.analytiqueCtrl06.setEcranaAxe(7);
                     this.ecrituresAnalytiquesDao.inserEcritureAnalytiques(var4, this.calculeEcrCtrl(var6, this.analytiqueCtrl06));
                  }
               }
            }

            if (this.listeAxe07.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe07.size(); ++var7) {
                  this.analytiqueCtrl07 = (EcrituresAnalytiqueCtrl)this.listeAxe07.get(var7);
                  if (this.analytiqueCtrl07.getEcranaMontantSaisie() != 0.0D) {
                     this.analytiqueCtrl07.setEcranaAxe(120);
                     this.ecrituresAnalytiquesDao.inserEcritureAnalytiques(var4, this.calculeEcrCtrl(var6, this.analytiqueCtrl07));
                  }
               }
            }

            if (this.listeAxe08.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe08.size(); ++var7) {
                  this.analytiqueCtrl08 = (EcrituresAnalytiqueCtrl)this.listeAxe08.get(var7);
                  if (this.analytiqueCtrl08.getEcranaMontantSaisie() != 0.0D) {
                     this.analytiqueCtrl08.setEcranaAxe(8);
                     this.ecrituresAnalytiquesDao.inserEcritureAnalytiques(var4, this.calculeEcrCtrl(var6, this.analytiqueCtrl08));
                  }
               }
            }

            if (this.listeAxe09.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe09.size(); ++var7) {
                  this.analytiqueCtrl09 = (EcrituresAnalytiqueCtrl)this.listeAxe09.get(var7);
                  if (this.analytiqueCtrl09.getEcranaMontantSaisie() != 0.0D) {
                     this.analytiqueCtrl09.setEcranaAxe(6);
                     this.ecrituresAnalytiquesDao.inserEcritureAnalytiques(var4, this.calculeEcrCtrl(var6, this.analytiqueCtrl09));
                  }
               }
            }

            if (this.listeAxe10.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe10.size(); ++var7) {
                  this.analytiqueCtrl10 = (EcrituresAnalytiqueCtrl)this.listeAxe10.get(var7);
                  if (this.analytiqueCtrl10.getEcranaMontantSaisie() != 0.0D) {
                     this.analytiqueCtrl10.setEcranaAxe(150);
                     this.ecrituresAnalytiquesDao.inserEcritureAnalytiques(var4, this.calculeEcrCtrl(var6, this.analytiqueCtrl10));
                  }
               }
            }

            if (this.listeAxe11.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe11.size(); ++var7) {
                  this.analytiqueCtrl11 = (EcrituresAnalytiqueCtrl)this.listeAxe11.get(var7);
                  if (this.analytiqueCtrl11.getEcranaMontantSaisie() != 0.0D) {
                     this.analytiqueCtrl11.setEcranaAxe(9);
                     this.ecrituresAnalytiquesDao.inserEcritureAnalytiques(var4, this.calculeEcrCtrl(var6, this.analytiqueCtrl11));
                  }
               }
            }

            if (this.listeAxe12.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe12.size(); ++var7) {
                  this.analytiqueCtrl12 = (EcrituresAnalytiqueCtrl)this.listeAxe12.get(var7);
                  if (this.analytiqueCtrl12.getEcranaMontantSaisie() != 0.0D) {
                     this.analytiqueCtrl12.setEcranaAxe(200);
                     this.ecrituresAnalytiquesDao.inserEcritureAnalytiques(var4, this.calculeEcrCtrl(var6, this.analytiqueCtrl12));
                  }
               }
            }

            if (this.listeAxe13.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe13.size(); ++var7) {
                  this.analytiqueCtrl13 = (EcrituresAnalytiqueCtrl)this.listeAxe13.get(var7);
                  if (this.analytiqueCtrl13.getEcranaMontantSaisie() != 0.0D) {
                     this.analytiqueCtrl13.setEcranaAxe(999);
                     this.ecrituresAnalytiquesDao.inserEcritureAnalytiques(var4, this.calculeEcrCtrl(var6, this.analytiqueCtrl13));
                  }
               }
            }

            if (this.util_axe01 == 1) {
               var6.setEcrAnaAxe01(true);
            } else {
               var6.setEcrAnaAxe01(false);
            }

            if (this.util_axe02 == 1) {
               var6.setEcrAnaAxe02(true);
            } else {
               var6.setEcrAnaAxe02(false);
            }

            if (this.util_axe03 == 1) {
               var6.setEcrAnaAxe03(true);
            } else {
               var6.setEcrAnaAxe03(false);
            }

            if (this.util_axe04 == 1) {
               var6.setEcrAnaAxe04(true);
            } else {
               var6.setEcrAnaAxe04(false);
            }

            if (this.util_axe05 == 1) {
               var6.setEcrAnaAxe05(true);
            } else {
               var6.setEcrAnaAxe05(false);
            }

            if (this.util_axe06 == 1) {
               var6.setEcrAnaAxe06(true);
            } else {
               var6.setEcrAnaAxe06(false);
            }

            if (this.util_axe07 == 1) {
               var6.setEcrAnaAxe07(true);
            } else {
               var6.setEcrAnaAxe07(false);
            }

            if (this.util_axe08 == 1) {
               var6.setEcrAnaAxe08(true);
            } else {
               var6.setEcrAnaAxe08(false);
            }

            if (this.util_axe09 == 1) {
               var6.setEcrAnaAxe09(true);
            } else {
               var6.setEcrAnaAxe09(false);
            }

            if (this.util_axe10 == 1) {
               var6.setEcrAnaAxe10(true);
            } else {
               var6.setEcrAnaAxe10(false);
            }

            if (this.util_axe11 == 1) {
               var6.setEcrAnaAxe11(true);
            } else {
               var6.setEcrAnaAxe11(false);
            }

            if (this.util_axe12 == 1) {
               var6.setEcrAnaAxe12(true);
            } else {
               var6.setEcrAnaAxe12(false);
            }

            if (this.util_axe13 == 1) {
               var6.setEcrAnaAxe13(true);
            } else {
               var6.setEcrAnaAxe13(false);
            }

            var6.setEcrAnaActif(1);
            var3.modif(var6, var4);
         }

         var5.commit();
      } catch (HibernateException var11) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void nettoyageDetailAnalytique(Ecritures var1, Session var2) throws HibernateException, NamingException {
      if (this.ecrituresAnalytiquesDao == null) {
         this.ecrituresAnalytiquesDao = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      }

      new ArrayList();
      List var3 = this.ecrituresAnalytiquesDao.chargerLesEcrituresAnalytiques(var1, var2);
      if (var3.size() != 0) {
         this.ecrituresAnalytiquesDao.nettoyageAnalytiqueByEcriture(var3, var2);
      }

   }

   public void controleValidation() {
      int var1 = 0;
      if (this.affiche_site && this.ecart01 != 0.0D) {
         ++var1;
      }

      if (this.affiche_region && this.ecart02 != 0.0D) {
         ++var1;
      }

      if (this.affiche_sitePrdv && this.ecart03 != 0.0D) {
         ++var1;
      }

      if (this.affiche_activite && this.ecart04 != 0.0D) {
         ++var1;
      }

      if (this.affiche_agent && this.ecart05 != 0.0D) {
         ++var1;
      }

      if (this.affiche_anal1 && this.ecart06 != 0.0D) {
         ++var1;
      }

      if (this.affiche_anal2 && this.ecart07 != 0.0D) {
         ++var1;
      }

      if (this.affiche_anal3 && this.ecart08 != 0.0D) {
         ++var1;
      }

      if (this.affiche_anal4 && this.ecart09 != 0.0D) {
         ++var1;
      }

      if (this.affiche_projet && this.ecart10 != 0.0D) {
         ++var1;
      }

      if (this.affiche_cles && this.ecart11 != 0.0D) {
         ++var1;
      }

      if (this.affiche_str && this.ecart12 != 0.0D) {
         ++var1;
      }

      if (this.affiche_autre && this.ecart13 != 0.0D) {
         ++var1;
      }

      if (var1 == 0) {
         this.var_valide_analytique = true;
      } else {
         this.var_valide_analytique = false;
      }

   }

   public void chargementDetailAnalytiqueBudget(Budget var1, boolean var2, String var3, Session var4) throws HibernateException, NamingException {
      this.modeConsultation = var2;
      this.ongletActif = "idAxe00";
      this.montantAImputer = 0.0D;
      this.qteAImputer = 0.0F;
      this.sens = 0;
      this.reamenagement = var3;
      if (this.reamenagement.equals("0")) {
         this.montantAImputer = var1.getBud01TotVal();
         this.qteAImputer = var1.getBud01TotQte();
      } else if (this.reamenagement.equals("1")) {
         this.montantAImputer = var1.getBud02TotVal();
         this.qteAImputer = var1.getBud02TotQte();
      } else if (this.reamenagement.equals("2")) {
         this.montantAImputer = var1.getBud03TotVal();
         this.qteAImputer = var1.getBud03TotQte();
      } else if (this.reamenagement.equals("3")) {
         this.montantAImputer = var1.getBud04TotVal();
         this.qteAImputer = var1.getBud04TotQte();
      }

      this.deviseEcriture = this.structureLog.getStrdevise();
      if (this.deviseEcriture == null || this.deviseEcriture.isEmpty()) {
         this.deviseEcriture = this.structureLog.getStrdevise();
      }

      if (this.budgetLigneDao == null) {
         this.budgetLigneDao = new BudgetLigneDao(this.baseLog, this.utilInitHibernate);
      }

      this.affiche_projet = false;
      this.listeAxe01.clear();
      this.listeAxe02.clear();
      this.listeAxe03.clear();
      this.listeAxe04.clear();
      this.listeAxe05.clear();
      this.listeAxe06.clear();
      this.listeAxe07.clear();
      this.listeAxe08.clear();
      this.listeAxe09.clear();
      this.listeAxe10.clear();
      this.listeAxe11.clear();
      this.listeAxe12.clear();
      this.listeAxe13.clear();
      this.affiche_autre = false;
      new ArrayList();
      List var5 = this.budgetLigneDao.chargerLigneBudget(var1, var4);
      this.budgetLigne = new BudgetLigne();
      if (var5.size() != 0) {
         for(int var6 = 0; var6 < var5.size(); ++var6) {
            this.budgetLigne = (BudgetLigne)var5.get(var6);
            if (this.budgetLigne.getBudligAxe() == 100) {
               this.affiche_site = true;
               this.analytiqueCtrl01 = new EcrituresAnalytiqueCtrl();
               this.analytiqueCtrl01.setMesSitesItems(this.lesSitesItems);
               this.analytiqueCtrl01.setMesDepartementsItems(new ArrayList());
               this.analytiqueCtrl01.setMesServicesItems(new ArrayList());
               this.analytiqueCtrl01.setDepVide(true);
               this.analytiqueCtrl01.setSerVide(true);
               this.listeAxe01.add(this.calculeEcrCtrl(this.analytiqueCtrl01, this.budgetLigne));
            } else if (this.budgetLigne.getBudligAxe() == 101) {
               this.affiche_region = true;
               this.analytiqueCtrl02 = new EcrituresAnalytiqueCtrl();
               this.analytiqueCtrl02.setMesRegionsItems(this.lesRegionsItems);
               this.analytiqueCtrl02.setMesSecteursItems(new ArrayList());
               this.analytiqueCtrl02.setMesPdvItems(new ArrayList());
               this.analytiqueCtrl02.setSecVide(true);
               this.analytiqueCtrl02.setPdvVide(true);
               this.listeAxe02.add(this.calculeEcrCtrl(this.analytiqueCtrl02, this.budgetLigne));
            } else if (this.budgetLigne.getBudligAxe() == 102) {
               this.affiche_sitePrdv = true;
               this.analytiqueCtrl03 = new EcrituresAnalytiqueCtrl();
               this.analytiqueCtrl03.setMesSitesItems(this.lesSitesPrdItems);
               this.analytiqueCtrl03.setMesLignesItems(new ArrayList());
               this.analytiqueCtrl03.setMesAteliersItems(new ArrayList());
               this.analytiqueCtrl03.setLigVide(true);
               this.analytiqueCtrl03.setAteVide(true);
               this.listeAxe03.add(this.calculeEcrCtrl(this.analytiqueCtrl03, this.budgetLigne));
            } else if (this.budgetLigne.getBudligAxe() == 110) {
               this.affiche_activite = true;
               this.analytiqueCtrl04 = new EcrituresAnalytiqueCtrl();
               this.analytiqueCtrl04.setMesColonnes1Items(this.lesColonnes1Items);
               this.analytiqueCtrl04.setMesColonnes2Items(this.lesColonnes2Items);
               this.analytiqueCtrl04.setMesColonnes3Items(this.lesColonnes3Items);
               this.listeAxe04.add(this.calculeEcrCtrl(this.analytiqueCtrl04, this.budgetLigne));
            } else if (this.budgetLigne.getBudligAxe() == 122) {
               this.affiche_agent = true;
               this.analytiqueCtrl05 = new EcrituresAnalytiqueCtrl();
               this.listeAxe05.add(this.calculeEcrCtrl(this.analytiqueCtrl05, this.budgetLigne));
            } else if (this.budgetLigne.getBudligAxe() == 7) {
               this.affiche_anal1 = true;
               this.analytiqueCtrl06 = new EcrituresAnalytiqueCtrl();
               this.listeAxe06.add(this.calculeEcrCtrl(this.analytiqueCtrl06, this.budgetLigne));
            } else if (this.budgetLigne.getBudligAxe() == 120) {
               this.affiche_anal2 = true;
               this.analytiqueCtrl07 = new EcrituresAnalytiqueCtrl();
               this.listeAxe07.add(this.calculeEcrCtrl(this.analytiqueCtrl07, this.budgetLigne));
            } else if (this.budgetLigne.getBudligAxe() == 8) {
               this.affiche_anal3 = true;
               this.analytiqueCtrl08 = new EcrituresAnalytiqueCtrl();
               this.listeAxe08.add(this.calculeEcrCtrl(this.analytiqueCtrl08, this.budgetLigne));
            } else if (this.budgetLigne.getBudligAxe() == 6 && this.structureLog.getStrDossier() == 1) {
               this.affiche_anal4 = true;
               this.analytiqueCtrl09 = new EcrituresAnalytiqueCtrl();
               this.listeAxe09.add(this.calculeEcrCtrl(this.analytiqueCtrl09, this.budgetLigne));
            } else if (this.budgetLigne.getBudligAxe() == 150) {
               this.affiche_projet = false;
            } else if (this.budgetLigne.getBudligAxe() == 9) {
               this.affiche_cles = true;
               this.analytiqueCtrl11 = new EcrituresAnalytiqueCtrl();
               this.listeAxe11.add(this.calculeEcrCtrl(this.analytiqueCtrl11, this.budgetLigne));
            } else if (this.budgetLigne.getBudligAxe() == 200) {
               this.affiche_str = true;
               this.analytiqueCtrl12 = new EcrituresAnalytiqueCtrl();
               this.listeAxe12.add(this.calculeEcrCtrl(this.analytiqueCtrl12, this.budgetLigne));
            } else {
               this.affiche_autre = true;
               this.analytiqueCtrl13 = new EcrituresAnalytiqueCtrl();
               this.listeAxe13.add(this.calculeEcrCtrl(this.analytiqueCtrl13, this.budgetLigne));
            }
         }
      }

      if (!var1.isBudAxe01() && this.affiche_site) {
         this.util_axe01 = 0;
      } else {
         this.util_axe01 = 1;
      }

      if (!var1.isBudAxe02() && this.affiche_region) {
         this.util_axe02 = 0;
      } else {
         this.util_axe02 = 1;
      }

      if (!var1.isBudAxe03() && this.affiche_sitePrdv) {
         this.util_axe03 = 0;
      } else {
         this.util_axe03 = 1;
      }

      if (!var1.isBudAxe04() && this.affiche_activite) {
         this.util_axe04 = 0;
      } else {
         this.util_axe04 = 1;
      }

      if (!var1.isBudAxe05() && this.affiche_agent) {
         this.util_axe05 = 0;
      } else {
         this.util_axe05 = 1;
      }

      if (!var1.isBudAxe06() && this.affiche_anal1) {
         this.util_axe06 = 0;
      } else {
         this.util_axe06 = 1;
      }

      if (!var1.isBudAxe07() && this.affiche_anal2) {
         this.util_axe07 = 0;
      } else {
         this.util_axe07 = 1;
      }

      if (!var1.isBudAxe08() && this.affiche_anal3) {
         this.util_axe08 = 0;
      } else {
         this.util_axe08 = 1;
      }

      if (!var1.isBudAxe09() && this.affiche_anal4) {
         this.util_axe09 = 0;
      } else {
         this.util_axe09 = 1;
      }

      this.util_axe10 = 1;
      if (!var1.isBudAxe11() && this.affiche_cles) {
         this.util_axe11 = 0;
      } else {
         this.util_axe11 = 1;
      }

      if (!var1.isBudAxe12() && this.affiche_str) {
         this.util_axe12 = 0;
      } else {
         this.util_axe12 = 1;
      }

      if (!var1.isBudAxe13() && this.affiche_autre) {
         this.util_axe13 = 0;
      } else {
         this.util_axe13 = 1;
      }

      if (!this.modeConsultation) {
         this.initialiseLigneBudget();
      }

      this.dataModelAxe01.setWrappedData(this.listeAxe01);
      this.dataModelAxe02.setWrappedData(this.listeAxe02);
      this.dataModelAxe03.setWrappedData(this.listeAxe03);
      this.dataModelAxe04.setWrappedData(this.listeAxe04);
      this.dataModelAxe05.setWrappedData(this.listeAxe05);
      this.dataModelAxe06.setWrappedData(this.listeAxe06);
      this.dataModelAxe07.setWrappedData(this.listeAxe07);
      this.dataModelAxe08.setWrappedData(this.listeAxe08);
      this.dataModelAxe09.setWrappedData(this.listeAxe09);
      this.dataModelAxe10.setWrappedData(this.listeAxe10);
      this.dataModelAxe11.setWrappedData(this.listeAxe11);
      this.dataModelAxe12.setWrappedData(this.listeAxe12);
      this.dataModelAxe13.setWrappedData(this.listeAxe13);
      this.calculEcart();
   }

   public void calculEcart() {
      this.calculEcart01();
      this.calculEcart02();
      this.calculEcart03();
      this.calculEcart04();
      this.calculEcart05();
      this.calculEcart06();
      this.calculEcart07();
      this.calculEcart08();
      this.calculEcart09();
      this.calculEcart10();
      this.calculEcart11();
      this.calculEcart12();
      this.calculEcart13();
   }

   public void initialiseLigneBudget() {
      this.budgetLigne = new BudgetLigne();
      if (this.affiche_site && this.listeAxe01.size() == 0 && this.util_axe01 == 0) {
         this.analytiqueCtrl01 = new EcrituresAnalytiqueCtrl();
         this.analytiqueCtrl01.setMesSitesItems(this.lesSitesItems);
         this.analytiqueCtrl01.setMesDepartementsItems(new ArrayList());
         this.analytiqueCtrl01.setMesServicesItems(new ArrayList());
         this.analytiqueCtrl01.setDepVide(true);
         this.analytiqueCtrl01.setSerVide(true);
         this.listeAxe01.add(this.calculeEcrCtrl(this.analytiqueCtrl01, this.budgetLigne));
      }

      if (this.affiche_region && this.listeAxe02.size() == 0 && this.util_axe02 == 0) {
         this.analytiqueCtrl02 = new EcrituresAnalytiqueCtrl();
         this.analytiqueCtrl02.setMesRegionsItems(this.lesRegionsItems);
         this.analytiqueCtrl02.setMesSecteursItems(new ArrayList());
         this.analytiqueCtrl02.setMesPdvItems(new ArrayList());
         this.analytiqueCtrl02.setSecVide(true);
         this.analytiqueCtrl02.setPdvVide(true);
         this.listeAxe02.add(this.calculeEcrCtrl(this.analytiqueCtrl02, this.budgetLigne));
      }

      if (this.affiche_sitePrdv && this.listeAxe03.size() == 0 && this.util_axe03 == 0) {
         this.analytiqueCtrl03 = new EcrituresAnalytiqueCtrl();
         this.analytiqueCtrl03.setMesSitesItems(this.lesSitesPrdItems);
         this.analytiqueCtrl03.setMesLignesItems(new ArrayList());
         this.analytiqueCtrl03.setMesAteliersItems(new ArrayList());
         this.analytiqueCtrl03.setLigVide(true);
         this.analytiqueCtrl03.setAteVide(true);
         this.listeAxe03.add(this.calculeEcrCtrl(this.analytiqueCtrl03, this.budgetLigne));
      }

      if (this.affiche_activite && this.listeAxe04.size() == 0 && this.util_axe04 == 0) {
         this.analytiqueCtrl04 = new EcrituresAnalytiqueCtrl();
         this.analytiqueCtrl04.setMesColonnes1Items(this.lesColonnes1Items);
         this.analytiqueCtrl04.setMesColonnes2Items(this.lesColonnes2Items);
         this.analytiqueCtrl04.setMesColonnes3Items(this.lesColonnes3Items);
         this.listeAxe04.add(this.calculeEcrCtrl(this.analytiqueCtrl04, this.budgetLigne));
      }

      if (this.affiche_agent && this.listeAxe05.size() == 0 && this.util_axe05 == 0) {
         this.analytiqueCtrl05 = new EcrituresAnalytiqueCtrl();
         this.listeAxe05.add(this.calculeEcrCtrl(this.analytiqueCtrl05, this.budgetLigne));
      }

      if (this.affiche_anal1 && this.listeAxe06.size() == 0 && this.util_axe06 == 0) {
         this.analytiqueCtrl06 = new EcrituresAnalytiqueCtrl();
         this.listeAxe06.add(this.calculeEcrCtrl(this.analytiqueCtrl06, this.budgetLigne));
      }

      if (this.affiche_anal2 && this.listeAxe07.size() == 0 && this.util_axe07 == 0) {
         this.analytiqueCtrl07 = new EcrituresAnalytiqueCtrl();
         this.listeAxe07.add(this.calculeEcrCtrl(this.analytiqueCtrl07, this.budgetLigne));
      }

      if (this.affiche_anal3 && this.listeAxe08.size() == 0 && this.util_axe08 == 0) {
         this.analytiqueCtrl08 = new EcrituresAnalytiqueCtrl();
         this.listeAxe08.add(this.calculeEcrCtrl(this.analytiqueCtrl08, this.budgetLigne));
      }

      if (this.affiche_anal4 && this.listeAxe09.size() == 0 && this.util_axe09 == 0 && this.structureLog.getStrDossier() == 1) {
         this.analytiqueCtrl09 = new EcrituresAnalytiqueCtrl();
         this.listeAxe09.add(this.calculeEcrCtrl(this.analytiqueCtrl09, this.budgetLigne));
      }

      if (this.affiche_projet && this.listeAxe10.size() == 0 && this.util_axe10 == 0) {
      }

      if (this.affiche_cles && this.listeAxe11.size() == 0 && this.util_axe11 == 0) {
      }

      if (this.affiche_str && this.listeAxe12.size() == 0 && this.util_axe12 == 0) {
      }

   }

   public EcrituresAnalytiqueCtrl calculeEcrCtrl(EcrituresAnalytiqueCtrl var1, BudgetLigne var2) {
      if (var2.getBudget() != null) {
         var1.setEcranaAxe(var2.getBudligAxe());
      }

      var1.setEcranaMontantSaisie(var2.getBudligMontantSaisie());
      var1.setEcranaQteSaisie(var2.getBudligQteSaisie());
      var1.setEcranaPourcentage(var2.getBudligPourcentSaisie());
      var1.setEcranaActivite(var2.getBudligActivite());
      var1.setEcranaActiviteLib(var2.getBudligLibActivite());
      if (this.decoupageActivite) {
         var1.setZoneCol1(var2.getBudligActivite() + ":" + var2.getBudligLibActivite());
         var1.setZoneCol2(var2.getBudligAnal1() + ":" + var2.getBudligLibAnal1());
         var1.setZoneCol3(var2.getBudligAnal3() + ":" + var2.getBudligLibAnal3());
      } else {
         var1.setZoneActivite(var2.getBudligActivite() + ":" + var2.getBudligLibActivite());
      }

      var1.setEcranaAnal1(var2.getBudligAnal1());
      var1.setEcranaAnal1Lib(var2.getBudligLibAnal1());
      var1.setEcranaAnal2(var2.getBudligAnal2());
      var1.setEcranaAnal2Lib(var2.getBudligLibAnal2());
      var1.setEcranaAnal3(var2.getBudligAnal3());
      var1.setEcranaAnal3Lib(var2.getBudligLibAnal3());
      var1.setEcranaAnal4(var2.getBudligAnal4());
      var1.setEcranaAnal4Lib(var2.getBudligLibAnal4());
      var1.setEcranaSite(var2.getBudligSite());
      var1.setEcranaSiteLib(var2.getBudligSiteLib());
      var1.setZoneSite(var2.getBudligSite() + ":" + var2.getBudligSiteLib());
      var1.setEcranaDepartement(var2.getBudligDepartement());
      var1.setEcranaDepartementLib(var2.getBudligDepartementLib());
      var1.setZoneDepartement(var2.getBudligDepartement() + ":" + var2.getBudligDepartementLib());
      var1.setEcranaService(var2.getBudligService());
      var1.setEcranaServiceLib(var2.getBudligServiceLib());
      var1.setZoneService(var2.getBudligService() + ":" + var2.getBudligServiceLib());
      var1.setEcranaRegion(var2.getBudligRegion());
      var1.setEcranaRegionLib(var2.getBudligRegionLib());
      var1.setZoneRegion(var2.getBudligRegion() + ":" + var2.getBudligRegionLib());
      var1.setEcranaSecteur(var2.getBudligSecteur());
      var1.setEcranaSecteurLib(var2.getBudligSecteurLib());
      var1.setZoneSecteur(var2.getBudligSecteur() + ":" + var2.getBudligSecteurLib());
      var1.setEcranaPdv(var2.getBudligPdv());
      var1.setEcranaPdvLib(var2.getBudligPdvLib());
      var1.setZonePdv(var2.getBudligPdv() + ":" + var2.getBudligPdvLib());
      var1.setEcranaLigne(var2.getBudligLigne());
      var1.setEcranaLigneLib(var2.getBudligLigneLib());
      var1.setZoneLigne(var2.getBudligLigne() + ":" + var2.getBudligLigneLib());
      var1.setEcranaAtelier(var2.getBudligAtelier());
      var1.setEcranaAtelierLib(var2.getBudligAtelierLib());
      var1.setZoneAtelier(var2.getBudligAtelier() + ":" + var2.getBudligAtelierLib());
      var1.setEcranaAgent(var2.getBudligAgent());
      var1.setEcranaAgentLib(var2.getBudligAgentLib());
      var1.setEcranaStr(var2.getBudligStr());
      var1.setEcranaStrLib(var2.getBudligStrLib());
      var1.setEcranaStrCle(var2.getBudligStrCle());
      var1.setEcranaRepCle(var2.getBudligRepCle());
      var1.setEcranaTypeCle(var2.getBudligTypeCle());
      var1.setEcranaProjet(var2.getBudligProjet());
      var1.setEcranaProjetLib(var2.getBudligProjetLib());
      var1.setZoneProjet(var2.getBudligProjet() + ":" + var2.getBudligProjetLib());
      var1.setEcranaEntite(var2.getBudligEntite());
      var1.setEcranaEntiteLib(var2.getBudligEntiteLib());
      var1.setZonePoste(var2.getBudligEntite() + ":" + var2.getBudligEntiteLib());
      var1.setEcranaPoste(var2.getBudligPoste());
      var1.setEcranaPosteLib(var2.getBudligPosteLib());
      var1.setZonePoste(var2.getBudligPoste() + ":" + var2.getBudligPosteLib());
      return var1;
   }

   public BudgetLigne calculeEcrCtrl(Budget var1, EcrituresAnalytiqueCtrl var2) {
      BudgetLigne var3 = new BudgetLigne();
      var3.setBudget(var1);
      var3.setBudligCode(var1.getBudCode());
      var3.setBudligAxe(var2.getEcranaAxe());
      var3.setBudligMontantSaisie(var2.getEcranaMontantSaisie());
      var3.setBudligQteSaisie(var2.getEcranaQteSaisie());
      var3.setBudligPourcentSaisie(var2.getEcranaPourcentage());
      if (this.reamenagement.equals("0")) {
         var3.setBudlig01TotVal(var2.getEcranaMontantSaisie());
         var3.setBudlig01TotQte(var2.getEcranaQteSaisie());
      } else if (this.reamenagement.equals("1")) {
         var3.setBudlig02TotVal(var2.getEcranaMontantSaisie());
         var3.setBudlig02TotQte(var2.getEcranaQteSaisie());
      } else if (this.reamenagement.equals("2")) {
         var3.setBudlig03TotVal(var2.getEcranaMontantSaisie());
         var3.setBudlig03TotQte(var2.getEcranaQteSaisie());
      } else if (this.reamenagement.equals("3")) {
         var3.setBudlig04TotVal(var2.getEcranaMontantSaisie());
         var3.setBudlig04TotQte(var2.getEcranaQteSaisie());
      }

      var3 = this.calculeRepartitionLigne(var3, var2);
      var3.setBudligActivite(var2.getEcranaActivite());
      var3.setBudligLibActivite(var2.getEcranaActiviteLib());
      var3.setBudligAnal1(var2.getEcranaAnal1());
      var3.setBudligLibAnal1(var2.getEcranaAnal1Lib());
      var3.setBudligAnal2(var2.getEcranaAnal2());
      var3.setBudligLibAnal2(var2.getEcranaAnal2Lib());
      var3.setBudligAnal3(var2.getEcranaAnal3());
      var3.setBudligLibAnal3(var2.getEcranaAnal3Lib());
      var3.setBudligAnal4(var2.getEcranaAnal4());
      var3.setBudligLibAnal4(var2.getEcranaAnal4Lib());
      var3.setBudligSite(var2.getEcranaSite());
      var3.setBudligSiteLib(var2.getEcranaSiteLib());
      var3.setBudligDepartement(var2.getEcranaDepartement());
      var3.setBudligDepartementLib(var2.getEcranaDepartementLib());
      var3.setBudligService(var2.getEcranaService());
      var3.setBudligServiceLib(var2.getEcranaServiceLib());
      var3.setBudligRegion(var2.getEcranaRegion());
      var3.setBudligRegionLib(var2.getEcranaRegionLib());
      var3.setBudligSecteur(var2.getEcranaSecteur());
      var3.setBudligSecteurLib(var2.getEcranaSecteurLib());
      var3.setBudligPdv(var2.getEcranaPdv());
      var3.setBudligPdvLib(var2.getEcranaPdvLib());
      var3.setBudligLigne(var2.getEcranaLigne());
      var3.setBudligLigneLib(var2.getEcranaLigneLib());
      var3.setBudligAtelier(var2.getEcranaAtelier());
      var3.setBudligAtelierLib(var2.getEcranaAtelierLib());
      var3.setBudligAgent(var2.getEcranaAgent());
      var3.setBudligAgentLib(var2.getEcranaAgentLib());
      var3.setBudligStr(var2.getEcranaStr());
      var3.setBudligStrLib(var2.getEcranaStrLib());
      var3.setBudligStrCle(var2.getEcranaStrCle());
      var3.setBudligRepCle(var2.getEcranaRepCle());
      var3.setBudligTypeCle(var2.getEcranaTypeCle());
      var3.setBudligProjet(var2.getEcranaProjet());
      var3.setBudligProjetLib(var2.getEcranaProjetLib());
      var3.setBudligEntite(var2.getEcranaEntite());
      var3.setBudligEntiteLib(var2.getEcranaEntiteLib());
      var3.setBudligPoste(var2.getEcranaPoste());
      var3.setBudligPosteLib(var2.getEcranaPosteLib());
      return var3;
   }

   public BudgetLigne calculeRepartitionLigne(BudgetLigne var1, EcrituresAnalytiqueCtrl var2) {
      if (var2.getEcranaMontantSaisie() != 0.0D) {
         double var3 = var2.getEcranaMontantSaisie() / 12.0D;
         var3 = this.utilNombre.myRoundDevise(var3, this.structureLog.getStrdevise());
         double var5;
         if (this.reamenagement.equals("0")) {
            var1.setBudlig01R1Val(var3);
            var1.setBudlig02R1Val(var3);
            var1.setBudlig03R1Val(var3);
            var1.setBudlig04R1Val(var3);
            var1.setBudlig05R1Val(var3);
            var1.setBudlig06R1Val(var3);
            var1.setBudlig07R1Val(var3);
            var1.setBudlig08R1Val(var3);
            var1.setBudlig09R1Val(var3);
            var1.setBudlig10R1Val(var3);
            var1.setBudlig11R1Val(var3);
            var5 = var2.getEcranaMontantSaisie() - (var1.getBudlig01R1Val() + var1.getBudlig02R1Val() + var1.getBudlig03R1Val() + var1.getBudlig04R1Val() + var1.getBudlig05R1Val() + var1.getBudlig06R1Val() + var1.getBudlig07R1Val() + var1.getBudlig08R1Val() + var1.getBudlig09R1Val() + var1.getBudlig10R1Val() + var1.getBudlig11R1Val());
            var1.setBudlig12R1Val(var5);
         } else if (this.reamenagement.equals("1")) {
            var1.setBudlig01R2Val(var3);
            var1.setBudlig02R2Val(var3);
            var1.setBudlig03R2Val(var3);
            var1.setBudlig04R2Val(var3);
            var1.setBudlig05R2Val(var3);
            var1.setBudlig06R2Val(var3);
            var1.setBudlig07R2Val(var3);
            var1.setBudlig08R2Val(var3);
            var1.setBudlig09R2Val(var3);
            var1.setBudlig10R2Val(var3);
            var1.setBudlig11R2Val(var3);
            var5 = var2.getEcranaMontantSaisie() - (var1.getBudlig01R2Val() + var1.getBudlig02R2Val() + var1.getBudlig03R2Val() + var1.getBudlig04R2Val() + var1.getBudlig05R2Val() + var1.getBudlig06R2Val() + var1.getBudlig07R2Val() + var1.getBudlig08R2Val() + var1.getBudlig09R2Val() + var1.getBudlig10R2Val() + var1.getBudlig11R2Val());
            var1.setBudlig12R1Val(var5);
         } else if (this.reamenagement.equals("2")) {
            var1.setBudlig01R3Val(var3);
            var1.setBudlig02R3Val(var3);
            var1.setBudlig03R3Val(var3);
            var1.setBudlig04R3Val(var3);
            var1.setBudlig05R3Val(var3);
            var1.setBudlig06R3Val(var3);
            var1.setBudlig07R3Val(var3);
            var1.setBudlig08R3Val(var3);
            var1.setBudlig09R3Val(var3);
            var1.setBudlig10R3Val(var3);
            var1.setBudlig11R3Val(var3);
            var5 = var2.getEcranaMontantSaisie() - (var1.getBudlig01R3Val() + var1.getBudlig02R3Val() + var1.getBudlig03R3Val() + var1.getBudlig04R3Val() + var1.getBudlig05R3Val() + var1.getBudlig06R3Val() + var1.getBudlig07R3Val() + var1.getBudlig08R3Val() + var1.getBudlig09R3Val() + var1.getBudlig10R3Val() + var1.getBudlig11R3Val());
            var1.setBudlig12R3Val(var5);
         } else if (this.reamenagement.equals("3")) {
            var1.setBudlig01R4Val(var3);
            var1.setBudlig02R4Val(var3);
            var1.setBudlig03R4Val(var3);
            var1.setBudlig04R4Val(var3);
            var1.setBudlig05R4Val(var3);
            var1.setBudlig06R4Val(var3);
            var1.setBudlig07R4Val(var3);
            var1.setBudlig08R4Val(var3);
            var1.setBudlig09R4Val(var3);
            var1.setBudlig10R4Val(var3);
            var1.setBudlig11R4Val(var3);
            var5 = var2.getEcranaMontantSaisie() - (var1.getBudlig01R4Val() + var1.getBudlig02R4Val() + var1.getBudlig03R4Val() + var1.getBudlig04R4Val() + var1.getBudlig05R4Val() + var1.getBudlig06R4Val() + var1.getBudlig07R4Val() + var1.getBudlig08R4Val() + var1.getBudlig09R4Val() + var1.getBudlig10R4Val() + var1.getBudlig11R4Val());
            var1.setBudlig12R4Val(var5);
         }
      } else if (this.reamenagement.equals("0")) {
         var1.setBudlig01R1Val(0.0D);
         var1.setBudlig02R1Val(0.0D);
         var1.setBudlig03R1Val(0.0D);
         var1.setBudlig04R1Val(0.0D);
         var1.setBudlig05R1Val(0.0D);
         var1.setBudlig06R1Val(0.0D);
         var1.setBudlig07R1Val(0.0D);
         var1.setBudlig08R1Val(0.0D);
         var1.setBudlig09R1Val(0.0D);
         var1.setBudlig10R1Val(0.0D);
         var1.setBudlig11R1Val(0.0D);
         var1.setBudlig12R1Val(0.0D);
      } else if (this.reamenagement.equals("1")) {
         var1.setBudlig01R2Val(0.0D);
         var1.setBudlig02R2Val(0.0D);
         var1.setBudlig03R2Val(0.0D);
         var1.setBudlig04R2Val(0.0D);
         var1.setBudlig05R2Val(0.0D);
         var1.setBudlig06R2Val(0.0D);
         var1.setBudlig07R2Val(0.0D);
         var1.setBudlig08R2Val(0.0D);
         var1.setBudlig09R2Val(0.0D);
         var1.setBudlig10R2Val(0.0D);
         var1.setBudlig11R2Val(0.0D);
         var1.setBudlig12R2Val(0.0D);
      } else if (this.reamenagement.equals("2")) {
         var1.setBudlig01R3Val(0.0D);
         var1.setBudlig02R3Val(0.0D);
         var1.setBudlig03R3Val(0.0D);
         var1.setBudlig04R3Val(0.0D);
         var1.setBudlig05R3Val(0.0D);
         var1.setBudlig06R3Val(0.0D);
         var1.setBudlig07R3Val(0.0D);
         var1.setBudlig08R3Val(0.0D);
         var1.setBudlig09R3Val(0.0D);
         var1.setBudlig10R3Val(0.0D);
         var1.setBudlig11R3Val(0.0D);
         var1.setBudlig12R3Val(0.0D);
      } else if (this.reamenagement.equals("3")) {
         var1.setBudlig01R4Val(0.0D);
         var1.setBudlig02R4Val(0.0D);
         var1.setBudlig03R4Val(0.0D);
         var1.setBudlig04R4Val(0.0D);
         var1.setBudlig05R4Val(0.0D);
         var1.setBudlig06R4Val(0.0D);
         var1.setBudlig07R4Val(0.0D);
         var1.setBudlig08R4Val(0.0D);
         var1.setBudlig09R4Val(0.0D);
         var1.setBudlig10R4Val(0.0D);
         var1.setBudlig11R4Val(0.0D);
         var1.setBudlig12R4Val(0.0D);
      }

      if (var2.getEcranaQteSaisie() != 0.0F) {
         float var7 = var2.getEcranaQteSaisie() / 12.0F;
         var7 = this.utilNombre.myRoundDevise(var7, this.structureLog.getStrdevise());
         float var4;
         if (this.reamenagement.equals("0")) {
            var1.setBudlig01R1Qte(var7);
            var1.setBudlig02R1Qte(var7);
            var1.setBudlig03R1Qte(var7);
            var1.setBudlig04R1Qte(var7);
            var1.setBudlig05R1Qte(var7);
            var1.setBudlig06R1Qte(var7);
            var1.setBudlig07R1Qte(var7);
            var1.setBudlig08R1Qte(var7);
            var1.setBudlig09R1Qte(var7);
            var1.setBudlig10R1Qte(var7);
            var1.setBudlig11R1Qte(var7);
            var4 = var2.getEcranaQteSaisie() - (var1.getBudlig01R1Qte() + var1.getBudlig02R1Qte() + var1.getBudlig03R1Qte() + var1.getBudlig04R1Qte() + var1.getBudlig05R1Qte() + var1.getBudlig06R1Qte() + var1.getBudlig07R1Qte() + var1.getBudlig08R1Qte() + var1.getBudlig09R1Qte() + var1.getBudlig10R1Qte() + var1.getBudlig11R1Qte());
            var1.setBudlig12R1Qte(var4);
         } else if (this.reamenagement.equals("1")) {
            var1.setBudlig01R2Qte(var7);
            var1.setBudlig02R2Qte(var7);
            var1.setBudlig03R2Qte(var7);
            var1.setBudlig04R2Qte(var7);
            var1.setBudlig05R2Qte(var7);
            var1.setBudlig06R2Qte(var7);
            var1.setBudlig07R2Qte(var7);
            var1.setBudlig08R2Qte(var7);
            var1.setBudlig09R2Qte(var7);
            var1.setBudlig10R2Qte(var7);
            var1.setBudlig11R2Qte(var7);
            var4 = var2.getEcranaQteSaisie() - (var1.getBudlig01R2Qte() + var1.getBudlig02R2Qte() + var1.getBudlig03R2Qte() + var1.getBudlig04R2Qte() + var1.getBudlig05R2Qte() + var1.getBudlig06R2Qte() + var1.getBudlig07R2Qte() + var1.getBudlig08R2Qte() + var1.getBudlig09R2Qte() + var1.getBudlig10R2Qte() + var1.getBudlig11R2Qte());
            var1.setBudlig12R1Qte(var4);
         } else if (this.reamenagement.equals("2")) {
            var1.setBudlig01R3Qte(var7);
            var1.setBudlig02R3Qte(var7);
            var1.setBudlig03R3Qte(var7);
            var1.setBudlig04R3Qte(var7);
            var1.setBudlig05R3Qte(var7);
            var1.setBudlig06R3Qte(var7);
            var1.setBudlig07R3Qte(var7);
            var1.setBudlig08R3Qte(var7);
            var1.setBudlig09R3Qte(var7);
            var1.setBudlig10R3Qte(var7);
            var1.setBudlig11R3Qte(var7);
            var4 = var2.getEcranaQteSaisie() - (var1.getBudlig01R3Qte() + var1.getBudlig02R3Qte() + var1.getBudlig03R3Qte() + var1.getBudlig04R3Qte() + var1.getBudlig05R3Qte() + var1.getBudlig06R3Qte() + var1.getBudlig07R3Qte() + var1.getBudlig08R3Qte() + var1.getBudlig09R3Qte() + var1.getBudlig10R3Qte() + var1.getBudlig11R3Qte());
            var1.setBudlig12R3Qte(var4);
         } else if (this.reamenagement.equals("3")) {
            var1.setBudlig01R4Qte(var7);
            var1.setBudlig02R4Qte(var7);
            var1.setBudlig03R4Qte(var7);
            var1.setBudlig04R4Qte(var7);
            var1.setBudlig05R4Qte(var7);
            var1.setBudlig06R4Qte(var7);
            var1.setBudlig07R4Qte(var7);
            var1.setBudlig08R4Qte(var7);
            var1.setBudlig09R4Qte(var7);
            var1.setBudlig10R4Qte(var7);
            var1.setBudlig11R4Qte(var7);
            var4 = var2.getEcranaQteSaisie() - (var1.getBudlig01R4Qte() + var1.getBudlig02R4Qte() + var1.getBudlig03R4Qte() + var1.getBudlig04R4Qte() + var1.getBudlig05R4Qte() + var1.getBudlig06R4Qte() + var1.getBudlig07R4Qte() + var1.getBudlig08R4Qte() + var1.getBudlig09R4Qte() + var1.getBudlig10R4Qte() + var1.getBudlig11R4Qte());
            var1.setBudlig12R4Qte(var4);
         }
      } else if (this.reamenagement.equals("0")) {
         var1.setBudlig01R1Qte(0.0F);
         var1.setBudlig02R1Qte(0.0F);
         var1.setBudlig03R1Qte(0.0F);
         var1.setBudlig04R1Qte(0.0F);
         var1.setBudlig05R1Qte(0.0F);
         var1.setBudlig06R1Qte(0.0F);
         var1.setBudlig07R1Qte(0.0F);
         var1.setBudlig08R1Qte(0.0F);
         var1.setBudlig09R1Qte(0.0F);
         var1.setBudlig10R1Qte(0.0F);
         var1.setBudlig11R1Qte(0.0F);
         var1.setBudlig12R1Qte(0.0F);
      } else if (this.reamenagement.equals("1")) {
         var1.setBudlig01R2Qte(0.0F);
         var1.setBudlig02R2Qte(0.0F);
         var1.setBudlig03R2Qte(0.0F);
         var1.setBudlig04R2Qte(0.0F);
         var1.setBudlig05R2Qte(0.0F);
         var1.setBudlig06R2Qte(0.0F);
         var1.setBudlig07R2Qte(0.0F);
         var1.setBudlig08R2Qte(0.0F);
         var1.setBudlig09R2Qte(0.0F);
         var1.setBudlig10R2Qte(0.0F);
         var1.setBudlig11R2Qte(0.0F);
         var1.setBudlig12R2Qte(0.0F);
      } else if (this.reamenagement.equals("2")) {
         var1.setBudlig01R3Qte(0.0F);
         var1.setBudlig02R3Qte(0.0F);
         var1.setBudlig03R3Qte(0.0F);
         var1.setBudlig04R3Qte(0.0F);
         var1.setBudlig05R3Qte(0.0F);
         var1.setBudlig06R3Qte(0.0F);
         var1.setBudlig07R3Qte(0.0F);
         var1.setBudlig08R3Qte(0.0F);
         var1.setBudlig09R3Qte(0.0F);
         var1.setBudlig10R3Qte(0.0F);
         var1.setBudlig11R3Qte(0.0F);
         var1.setBudlig12R3Qte(0.0F);
      } else if (this.reamenagement.equals("3")) {
         var1.setBudlig01R4Qte(0.0F);
         var1.setBudlig02R4Qte(0.0F);
         var1.setBudlig03R4Qte(0.0F);
         var1.setBudlig04R4Qte(0.0F);
         var1.setBudlig05R4Qte(0.0F);
         var1.setBudlig06R4Qte(0.0F);
         var1.setBudlig07R4Qte(0.0F);
         var1.setBudlig08R4Qte(0.0F);
         var1.setBudlig09R4Qte(0.0F);
         var1.setBudlig10R4Qte(0.0F);
         var1.setBudlig11R4Qte(0.0F);
         var1.setBudlig12R4Qte(0.0F);
      }

      return var1;
   }

   public void saveDetailAnalytique(long var1, BudgetDao var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "Budget");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         new Budget();
         Budget var6 = var3.recupererSelectedECById(var1, var4);
         if (var6 != null) {
            this.nettoyageDetailAnalytique(var6, var4);
            int var7;
            if (this.listeAxe01.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe01.size(); ++var7) {
                  this.analytiqueCtrl01 = (EcrituresAnalytiqueCtrl)this.listeAxe01.get(var7);
                  this.analytiqueCtrl01.setEcranaAxe(100);
                  this.budgetLigneDao.insert(this.calculeEcrCtrl(var6, this.analytiqueCtrl01), var4);
               }
            }

            if (this.listeAxe02.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe02.size(); ++var7) {
                  this.analytiqueCtrl02 = (EcrituresAnalytiqueCtrl)this.listeAxe02.get(var7);
                  this.analytiqueCtrl02.setEcranaAxe(101);
                  this.budgetLigneDao.insert(this.calculeEcrCtrl(var6, this.analytiqueCtrl02), var4);
               }
            }

            if (this.listeAxe03.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe03.size(); ++var7) {
                  this.analytiqueCtrl03 = (EcrituresAnalytiqueCtrl)this.listeAxe03.get(var7);
                  this.analytiqueCtrl03.setEcranaAxe(102);
                  this.budgetLigneDao.insert(this.calculeEcrCtrl(var6, this.analytiqueCtrl03), var4);
               }
            }

            if (this.listeAxe04.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe04.size(); ++var7) {
                  this.analytiqueCtrl04 = (EcrituresAnalytiqueCtrl)this.listeAxe04.get(var7);
                  this.analytiqueCtrl04.setEcranaAxe(110);
                  this.budgetLigneDao.insert(this.calculeEcrCtrl(var6, this.analytiqueCtrl04), var4);
               }
            }

            if (this.listeAxe05.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe05.size(); ++var7) {
                  this.analytiqueCtrl05 = (EcrituresAnalytiqueCtrl)this.listeAxe05.get(var7);
                  this.analytiqueCtrl05.setEcranaAxe(122);
                  this.budgetLigneDao.insert(this.calculeEcrCtrl(var6, this.analytiqueCtrl05), var4);
               }
            }

            if (this.listeAxe06.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe06.size(); ++var7) {
                  this.analytiqueCtrl06 = (EcrituresAnalytiqueCtrl)this.listeAxe06.get(var7);
                  this.analytiqueCtrl06.setEcranaAxe(7);
                  this.budgetLigneDao.insert(this.calculeEcrCtrl(var6, this.analytiqueCtrl06), var4);
               }
            }

            if (this.listeAxe07.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe07.size(); ++var7) {
                  this.analytiqueCtrl07 = (EcrituresAnalytiqueCtrl)this.listeAxe07.get(var7);
                  this.analytiqueCtrl07.setEcranaAxe(120);
                  this.budgetLigneDao.insert(this.calculeEcrCtrl(var6, this.analytiqueCtrl07), var4);
               }
            }

            if (this.listeAxe08.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe08.size(); ++var7) {
                  this.analytiqueCtrl08 = (EcrituresAnalytiqueCtrl)this.listeAxe08.get(var7);
                  this.analytiqueCtrl08.setEcranaAxe(8);
                  this.budgetLigneDao.insert(this.calculeEcrCtrl(var6, this.analytiqueCtrl08), var4);
               }
            }

            if (this.listeAxe09.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe09.size(); ++var7) {
                  this.analytiqueCtrl09 = (EcrituresAnalytiqueCtrl)this.listeAxe09.get(var7);
                  this.analytiqueCtrl09.setEcranaAxe(6);
                  this.budgetLigneDao.insert(this.calculeEcrCtrl(var6, this.analytiqueCtrl09), var4);
               }
            }

            if (this.listeAxe10.size() != 0) {
            }

            if (this.listeAxe11.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe11.size(); ++var7) {
                  this.analytiqueCtrl11 = (EcrituresAnalytiqueCtrl)this.listeAxe11.get(var7);
                  this.analytiqueCtrl11.setEcranaAxe(9);
                  this.budgetLigneDao.insert(this.calculeEcrCtrl(var6, this.analytiqueCtrl11), var4);
               }
            }

            if (this.listeAxe12.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe12.size(); ++var7) {
                  this.analytiqueCtrl12 = (EcrituresAnalytiqueCtrl)this.listeAxe12.get(var7);
                  this.analytiqueCtrl12.setEcranaAxe(200);
                  this.budgetLigneDao.insert(this.calculeEcrCtrl(var6, this.analytiqueCtrl12), var4);
               }
            }

            if (this.listeAxe13.size() != 0) {
               for(var7 = 0; var7 < this.listeAxe13.size(); ++var7) {
                  this.analytiqueCtrl13 = (EcrituresAnalytiqueCtrl)this.listeAxe13.get(var7);
                  this.analytiqueCtrl13.setEcranaAxe(999);
                  this.budgetLigneDao.insert(this.calculeEcrCtrl(var6, this.analytiqueCtrl13), var4);
               }
            }

            if (this.util_axe01 == 1) {
               var6.setBudAxe01(true);
            } else {
               var6.setBudAxe01(false);
            }

            if (this.util_axe02 == 1) {
               var6.setBudAxe02(true);
            } else {
               var6.setBudAxe02(false);
            }

            if (this.util_axe03 == 1) {
               var6.setBudAxe03(true);
            } else {
               var6.setBudAxe03(false);
            }

            if (this.util_axe04 == 1) {
               var6.setBudAxe04(true);
            } else {
               var6.setBudAxe04(false);
            }

            if (this.util_axe05 == 1) {
               var6.setBudAxe05(true);
            } else {
               var6.setBudAxe05(false);
            }

            if (this.util_axe06 == 1) {
               var6.setBudAxe06(true);
            } else {
               var6.setBudAxe06(false);
            }

            if (this.util_axe07 == 1) {
               var6.setBudAxe07(true);
            } else {
               var6.setBudAxe07(false);
            }

            if (this.util_axe08 == 1) {
               var6.setBudAxe08(true);
            } else {
               var6.setBudAxe08(false);
            }

            if (this.util_axe09 == 1) {
               var6.setBudAxe09(true);
            } else {
               var6.setBudAxe09(false);
            }

            if (this.util_axe10 == 1) {
               var6.setBudAxe10(true);
            } else {
               var6.setBudAxe10(false);
            }

            if (this.util_axe11 == 1) {
               var6.setBudAxe11(true);
            } else {
               var6.setBudAxe11(false);
            }

            if (this.util_axe12 == 1) {
               var6.setBudAxe12(true);
            } else {
               var6.setBudAxe12(false);
            }

            if (this.util_axe13 == 1) {
               var6.setBudAxe13(true);
            } else {
               var6.setBudAxe13(false);
            }

            var3.modif(var6, var4);
         }

         var5.commit();
      } catch (HibernateException var11) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var11;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void nettoyageDetailAnalytique(Budget var1, Session var2) throws HibernateException, NamingException {
      if (this.budgetLigneDao == null) {
         this.budgetLigneDao = new BudgetLigneDao(this.baseLog, this.utilInitHibernate);
      }

      new ArrayList();
      List var3 = this.budgetLigneDao.chargerLigneBudget(var1, var2);
      if (var3.size() != 0) {
         this.budgetLigneDao.nettoyageAnalytiqueByEcriture(var3, var2);
      }

   }

   public void rechercherAgent() throws NamingException {
      if (this.analytiqueCtrl05.getEcranaAgent() != null && !this.analytiqueCtrl05.getEcranaAgent().isEmpty()) {
         ArrayList var1 = new ArrayList();
         new ArrayList();
         this.salaries = new Salaries();
         this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
         List var2 = this.salariesDao.chargerlesSalariesActif(this.analytiqueCtrl05.getEcranaAgent(), (Session)null);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setCode(((Salaries)var2.get(var3)).getSalMatricule());
               this.objetCompte.setNom_FR(((Salaries)var2.get(var3)).getPatronyme());
               this.objetCompte.setType("SALARIE");
               var1.add(this.objetCompte);
            }

            if (var1.size() == 1) {
               this.objetCompte = (ObjetCompte)var1.get(0);
               this.analytiqueCtrl05.setEcranaAgent(this.objetCompte.getCode());
               this.analytiqueCtrl05.setEcranaAgentLib(this.objetCompte.getNom_FR());
            } else {
               this.dataModelRecherche.setWrappedData(var1);
               this.libelleRecherche = "AGENTS";
               this.selectObjet = false;
               this.showModalPanelRecherche = true;
            }
         } else {
            this.analytiqueCtrl05.setEcranaAgent("");
            this.analytiqueCtrl05.setEcranaAgentLib("");
            this.analytiqueCtrl05.setEcranaPourcentage(0.0F);
            this.analytiqueCtrl05.setEcranaMontantSaisie(0.0D);
            this.calculEcart05();
         }
      } else {
         this.analytiqueCtrl05.setEcranaAgent("");
         this.analytiqueCtrl05.setEcranaAgentLib("");
         this.analytiqueCtrl05.setEcranaPourcentage(0.0F);
         this.analytiqueCtrl05.setEcranaMontantSaisie(0.0D);
         this.calculEcart05();
      }

   }

   public void rechercherChantier() throws HibernateException, NamingException {
      if (this.analytiqueCtrl06.getEcranaAnal1() != null && !this.analytiqueCtrl06.getEcranaAnal1().isEmpty()) {
         ArrayList var1 = new ArrayList();
         new ArrayList();
         this.plansAnalytiques = new PlansAnalytiques();
         this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         List var2 = this.plansAnalytiquesDao.selectAnal("7", this.analytiqueCtrl06.getEcranaAnal1(), "", this.nature, (Session)null);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setCode(((PlansAnalytiques)var2.get(var3)).getAnaCode());
               this.objetCompte.setNom_FR(((PlansAnalytiques)var2.get(var3)).getAnaNomFr());
               this.objetCompte.setType(((PlansAnalytiques)var2.get(var3)).getAnaNature());
               var1.add(this.objetCompte);
            }

            if (var1.size() == 1) {
               this.objetCompte = (ObjetCompte)var1.get(0);
               this.analytiqueCtrl06.setEcranaAnal1(this.objetCompte.getCode());
               this.analytiqueCtrl06.setEcranaAnal1Lib(this.objetCompte.getNom_FR());
            } else {
               this.dataModelRecherche.setWrappedData(var1);
               this.libelleRecherche = "CHANTIERS";
               this.selectObjet = false;
               this.showModalPanelRecherche = true;
            }
         } else {
            this.analytiqueCtrl06.setEcranaAnal1("");
            this.analytiqueCtrl06.setEcranaAnal1Lib("");
            this.analytiqueCtrl06.setEcranaPourcentage(0.0F);
            this.analytiqueCtrl06.setEcranaMontantSaisie(0.0D);
            this.calculEcart06();
         }
      } else {
         this.analytiqueCtrl06.setEcranaAnal1("");
         this.analytiqueCtrl06.setEcranaAnal1Lib("");
         this.analytiqueCtrl06.setEcranaPourcentage(0.0F);
         this.analytiqueCtrl06.setEcranaMontantSaisie(0.0D);
         this.calculEcart06();
      }

   }

   public void rechercherActivite() throws HibernateException, NamingException {
      if (this.analytiqueCtrl04.getEcranaActivite() != null && !this.analytiqueCtrl04.getEcranaActivite().isEmpty()) {
         ArrayList var1 = new ArrayList();
         new ArrayList();
         this.activites = new Activites();
         this.activitesDao = new ActivitesDao(this.baseLog, this.utilInitHibernate);
         List var2 = this.activitesDao.selectActivitesByCode(this.analytiqueCtrl04.getEcranaActivite(), (Session)null);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setCode(((Activites)var2.get(var3)).getActCode());
               this.objetCompte.setNom_FR(((Activites)var2.get(var3)).getActNomFr());
               this.objetCompte.setType("ACTIVITES");
               var1.add(this.objetCompte);
            }

            if (var1.size() == 1) {
               this.objetCompte = (ObjetCompte)var1.get(0);
               this.analytiqueCtrl04.setEcranaActivite(this.objetCompte.getCode());
               this.analytiqueCtrl04.setEcranaActiviteLib(this.objetCompte.getNom_FR());
            } else {
               this.dataModelRecherche.setWrappedData(var1);
               this.libelleRecherche = "ACTIVITES";
               this.selectObjet = false;
               this.showModalPanelRecherche = true;
            }
         } else {
            this.analytiqueCtrl04.setEcranaActivite("");
         }
      }

   }

   public void rechercherParc() throws HibernateException, NamingException {
      if (this.analytiqueCtrl07.getEcranaAnal2() != null && !this.analytiqueCtrl07.getEcranaAnal2().isEmpty()) {
         ArrayList var1 = new ArrayList();
         new ArrayList();
         this.parc = new Parc();
         this.parcDao = new ParcDao(this.baseLog, this.utilInitHibernate);
         List var2 = this.parcDao.selectParc(this.analytiqueCtrl07.getEcranaAnal2(), (Session)null);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setCode(((Parc)var2.get(var3)).getPrcImmatriculation());
               if (((Parc)var2.get(var3)).getLibelleParc() != null && !((Parc)var2.get(var3)).getLibelleParc().isEmpty()) {
                  this.objetCompte.setNom_FR(((Parc)var2.get(var3)).getLibelleParc());
               } else {
                  this.objetCompte.setNom_FR(((Parc)var2.get(var3)).getPrcNomFr());
               }

               this.objetCompte.setType("PARC");
               var1.add(this.objetCompte);
            }

            if (var1.size() == 1) {
               this.objetCompte = (ObjetCompte)var1.get(0);
               this.analytiqueCtrl07.setEcranaAnal2(this.objetCompte.getCode());
               this.analytiqueCtrl07.setEcranaAnal2Lib(this.objetCompte.getNom_FR());
            } else {
               this.dataModelRecherche.setWrappedData(var1);
               this.libelleRecherche = "PARCS";
               this.selectObjet = false;
               this.showModalPanelRecherche = true;
            }
         } else {
            this.analytiqueCtrl07.setEcranaAnal2("");
            this.analytiqueCtrl07.setEcranaAnal2Lib("");
            this.analytiqueCtrl07.setEcranaPourcentage(0.0F);
            this.analytiqueCtrl07.setEcranaMontantSaisie(0.0D);
            this.calculEcart07();
         }
      } else {
         this.analytiqueCtrl07.setEcranaAnal2("");
         this.analytiqueCtrl07.setEcranaAnal2Lib("");
         this.analytiqueCtrl07.setEcranaPourcentage(0.0F);
         this.analytiqueCtrl07.setEcranaMontantSaisie(0.0D);
         this.calculEcart07();
      }

   }

   public void rechercherMission() throws HibernateException, NamingException {
      if (this.analytiqueCtrl08.getEcranaAnal3() != null && !this.analytiqueCtrl08.getEcranaAnal3().isEmpty()) {
         ArrayList var1 = new ArrayList();
         new ArrayList();
         this.plansAnalytiques = new PlansAnalytiques();
         this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         List var2 = this.plansAnalytiquesDao.selectAnal("8", this.analytiqueCtrl08.getEcranaAnal3(), "", this.nature, (Session)null);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setCode(((PlansAnalytiques)var2.get(var3)).getAnaCode());
               this.objetCompte.setNom_FR(((PlansAnalytiques)var2.get(var3)).getAnaNomFr());
               this.objetCompte.setType(((PlansAnalytiques)var2.get(var3)).getAnaNature());
               var1.add(this.objetCompte);
            }

            if (var1.size() == 1) {
               this.objetCompte = (ObjetCompte)var1.get(0);
               this.analytiqueCtrl08.setEcranaAnal3(this.objetCompte.getCode());
               this.analytiqueCtrl08.setEcranaAnal3Lib(this.objetCompte.getNom_FR());
            } else {
               this.dataModelRecherche.setWrappedData(var1);
               this.libelleRecherche = "MISSIONS";
               this.selectObjet = false;
               this.showModalPanelRecherche = true;
            }
         } else {
            this.analytiqueCtrl08.setEcranaAnal3("");
            this.analytiqueCtrl08.setEcranaAnal3Lib("");
            this.analytiqueCtrl08.setEcranaPourcentage(0.0F);
            this.analytiqueCtrl08.setEcranaMontantSaisie(0.0D);
            this.calculEcart08();
         }
      } else {
         this.analytiqueCtrl08.setEcranaAnal3("");
         this.analytiqueCtrl08.setEcranaAnal3Lib("");
         this.analytiqueCtrl08.setEcranaPourcentage(0.0F);
         this.analytiqueCtrl08.setEcranaMontantSaisie(0.0D);
         this.calculEcart08();
      }

   }

   public void rechercherDossier() throws HibernateException, NamingException {
      if (this.analytiqueCtrl09.getEcranaAnal4() != null && !this.analytiqueCtrl09.getEcranaAnal4().isEmpty()) {
         ArrayList var1 = new ArrayList();
         new ArrayList();
         this.plansAnalytiques = new PlansAnalytiques();
         this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         List var2 = this.plansAnalytiquesDao.selectAnal("6", this.analytiqueCtrl09.getEcranaAnal4(), "", this.nature, (Session)null);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setCode(((PlansAnalytiques)var2.get(var3)).getAnaCode());
               this.objetCompte.setNom_FR(((PlansAnalytiques)var2.get(var3)).getAnaNomFr());
               this.objetCompte.setType(((PlansAnalytiques)var2.get(var3)).getAnaNature());
               var1.add(this.objetCompte);
            }

            if (var1.size() == 1) {
               this.objetCompte = (ObjetCompte)var1.get(0);
               this.analytiqueCtrl09.setEcranaAnal4(this.objetCompte.getCode());
               this.analytiqueCtrl09.setEcranaAnal4Lib(this.objetCompte.getNom_FR());
            } else {
               this.dataModelRecherche.setWrappedData(var1);
               this.libelleRecherche = "DOSSIERS";
               this.selectObjet = false;
               this.showModalPanelRecherche = true;
            }
         } else {
            this.analytiqueCtrl09.setEcranaAnal4("");
            this.analytiqueCtrl09.setEcranaAnal4Lib("");
            this.analytiqueCtrl09.setEcranaPourcentage(0.0F);
            this.analytiqueCtrl09.setEcranaMontantSaisie(0.0D);
            this.calculEcart09();
         }
      } else {
         this.analytiqueCtrl09.setEcranaAnal4("");
         this.analytiqueCtrl09.setEcranaAnal4Lib("");
         this.analytiqueCtrl09.setEcranaPourcentage(0.0F);
         this.analytiqueCtrl09.setEcranaMontantSaisie(0.0D);
         this.calculEcart09();
      }

   }

   public void selectionRecherche() {
      if (this.dataModelRecherche.isRowAvailable()) {
         this.objetCompte = (ObjetCompte)this.dataModelRecherche.getRowData();
         this.selectObjet = true;
      }

   }

   public void annulerRecherche() {
      if (this.ongletActif.equals("idAxe05")) {
         this.analytiqueCtrl05.setEcranaAgent("");
         this.analytiqueCtrl05.setEcranaAgentLib("");
      } else if (this.ongletActif.equals("idAxe06")) {
         this.analytiqueCtrl06.setEcranaAnal1("");
         this.analytiqueCtrl06.setEcranaAnal1Lib("");
      } else if (this.ongletActif.equals("idAxe07")) {
         this.analytiqueCtrl07.setEcranaAnal2("");
         this.analytiqueCtrl07.setEcranaAnal2Lib("");
      } else if (this.ongletActif.equals("idAxe08")) {
         this.analytiqueCtrl08.setEcranaAnal3("");
         this.analytiqueCtrl08.setEcranaAnal3Lib("");
      } else if (this.ongletActif.equals("idAxe09")) {
         this.analytiqueCtrl09.setEcranaAnal4("");
         this.analytiqueCtrl09.setEcranaAnal4Lib("");
      }

      this.showModalPanelRecherche = false;
   }

   public void valideRecherche() {
      if (this.ongletActif != null && !this.ongletActif.isEmpty()) {
         if (this.ongletActif.equals("idAxe04")) {
            this.analytiqueCtrl04.setEcranaActivite(this.objetCompte.getCode());
            this.analytiqueCtrl04.setEcranaActiviteLib(this.objetCompte.getNom_FR());
         } else if (this.ongletActif.equals("idAxe05")) {
            this.analytiqueCtrl05.setEcranaAgent(this.objetCompte.getCode());
            this.analytiqueCtrl05.setEcranaAgentLib(this.objetCompte.getNom_FR());
         } else if (this.ongletActif.equals("idAxe06")) {
            this.analytiqueCtrl06.setEcranaAnal1(this.objetCompte.getCode());
            this.analytiqueCtrl06.setEcranaAnal1Lib(this.objetCompte.getNom_FR());
         } else if (this.ongletActif.equals("idAxe07")) {
            this.analytiqueCtrl07.setEcranaAnal2(this.objetCompte.getCode());
            this.analytiqueCtrl07.setEcranaAnal2Lib(this.objetCompte.getNom_FR());
         } else if (this.ongletActif.equals("idAxe08")) {
            this.analytiqueCtrl08.setEcranaAnal3(this.objetCompte.getCode());
            this.analytiqueCtrl08.setEcranaAnal3Lib(this.objetCompte.getNom_FR());
         } else if (this.ongletActif.equals("idAxe09")) {
            this.analytiqueCtrl09.setEcranaAnal4(this.objetCompte.getCode());
            this.analytiqueCtrl09.setEcranaAnal4Lib(this.objetCompte.getNom_FR());
         }
      }

      this.showModalPanelRecherche = false;
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

   public boolean isAffiche_cles() {
      return this.affiche_cles;
   }

   public void setAffiche_cles(boolean var1) {
      this.affiche_cles = var1;
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

   public boolean isAffiche_sitePrdv() {
      return this.affiche_sitePrdv;
   }

   public void setAffiche_sitePrdv(boolean var1) {
      this.affiche_sitePrdv = var1;
   }

   public boolean isAffiche_str() {
      return this.affiche_str;
   }

   public void setAffiche_str(boolean var1) {
      this.affiche_str = var1;
   }

   public boolean isDecoupageActivite() {
      return this.decoupageActivite;
   }

   public void setDecoupageActivite(boolean var1) {
      this.decoupageActivite = var1;
   }

   public List getLesColonnes1Items() {
      return this.lesColonnes1Items;
   }

   public void setLesColonnes1Items(List var1) {
      this.lesColonnes1Items = var1;
   }

   public List getLesColonnes2Items() {
      return this.lesColonnes2Items;
   }

   public void setLesColonnes2Items(List var1) {
      this.lesColonnes2Items = var1;
   }

   public List getLesColonnes3Items() {
      return this.lesColonnes3Items;
   }

   public void setLesColonnes3Items(List var1) {
      this.lesColonnes3Items = var1;
   }

   public List getLesDepartementsItems() {
      return this.lesDepartementsItems;
   }

   public void setLesDepartementsItems(List var1) {
      this.lesDepartementsItems = var1;
   }

   public List getLesPdvItems() {
      return this.lesPdvItems;
   }

   public void setLesPdvItems(List var1) {
      this.lesPdvItems = var1;
   }

   public List getLesRegionsItems() {
      return this.lesRegionsItems;
   }

   public void setLesRegionsItems(List var1) {
      this.lesRegionsItems = var1;
   }

   public List getLesSecteursItems() {
      return this.lesSecteursItems;
   }

   public void setLesSecteursItems(List var1) {
      this.lesSecteursItems = var1;
   }

   public List getLesServicesItems() {
      return this.lesServicesItems;
   }

   public void setLesServicesItems(List var1) {
      this.lesServicesItems = var1;
   }

   public List getLesSitesItems() {
      return this.lesSitesItems;
   }

   public void setLesSitesItems(List var1) {
      this.lesSitesItems = var1;
   }

   public List getLesAteliersItems() {
      return this.lesAteliersItems;
   }

   public void setLesAteliersItems(List var1) {
      this.lesAteliersItems = var1;
   }

   public List getLesClesStandardsItems() {
      return this.lesClesStandardsItems;
   }

   public void setLesClesStandardsItems(List var1) {
      this.lesClesStandardsItems = var1;
   }

   public List getLesClesStructureItems() {
      return this.lesClesStructureItems;
   }

   public void setLesClesStructureItems(List var1) {
      this.lesClesStructureItems = var1;
   }

   public List getLesLignesItems() {
      return this.lesLignesItems;
   }

   public void setLesLignesItems(List var1) {
      this.lesLignesItems = var1;
   }

   public List getLesSitesPrdItems() {
      return this.lesSitesPrdItems;
   }

   public void setLesSitesPrdItems(List var1) {
      this.lesSitesPrdItems = var1;
   }

   public DataModel getDataModelAxe01() {
      return this.dataModelAxe01;
   }

   public void setDataModelAxe01(DataModel var1) {
      this.dataModelAxe01 = var1;
   }

   public DataModel getDataModelAxe02() {
      return this.dataModelAxe02;
   }

   public void setDataModelAxe02(DataModel var1) {
      this.dataModelAxe02 = var1;
   }

   public DataModel getDataModelAxe03() {
      return this.dataModelAxe03;
   }

   public void setDataModelAxe03(DataModel var1) {
      this.dataModelAxe03 = var1;
   }

   public DataModel getDataModelAxe04() {
      return this.dataModelAxe04;
   }

   public void setDataModelAxe04(DataModel var1) {
      this.dataModelAxe04 = var1;
   }

   public DataModel getDataModelAxe05() {
      return this.dataModelAxe05;
   }

   public void setDataModelAxe05(DataModel var1) {
      this.dataModelAxe05 = var1;
   }

   public DataModel getDataModelAxe06() {
      return this.dataModelAxe06;
   }

   public void setDataModelAxe06(DataModel var1) {
      this.dataModelAxe06 = var1;
   }

   public DataModel getDataModelAxe07() {
      return this.dataModelAxe07;
   }

   public void setDataModelAxe07(DataModel var1) {
      this.dataModelAxe07 = var1;
   }

   public DataModel getDataModelAxe08() {
      return this.dataModelAxe08;
   }

   public void setDataModelAxe08(DataModel var1) {
      this.dataModelAxe08 = var1;
   }

   public DataModel getDataModelAxe09() {
      return this.dataModelAxe09;
   }

   public void setDataModelAxe09(DataModel var1) {
      this.dataModelAxe09 = var1;
   }

   public DataModel getDataModelAxe11() {
      return this.dataModelAxe11;
   }

   public void setDataModelAxe11(DataModel var1) {
      this.dataModelAxe11 = var1;
   }

   public DataModel getDataModelAxe12() {
      return this.dataModelAxe12;
   }

   public void setDataModelAxe12(DataModel var1) {
      this.dataModelAxe12 = var1;
   }

   public DataModel getDataModelAxe13() {
      return this.dataModelAxe13;
   }

   public void setDataModelAxe13(DataModel var1) {
      this.dataModelAxe13 = var1;
   }

   public boolean isAffiche_autre() {
      return this.affiche_autre;
   }

   public void setAffiche_autre(boolean var1) {
      this.affiche_autre = var1;
   }

   public int getUtil_axe01() {
      return this.util_axe01;
   }

   public void setUtil_axe01(int var1) {
      this.util_axe01 = var1;
   }

   public int getUtil_axe02() {
      return this.util_axe02;
   }

   public void setUtil_axe02(int var1) {
      this.util_axe02 = var1;
   }

   public int getUtil_axe03() {
      return this.util_axe03;
   }

   public void setUtil_axe03(int var1) {
      this.util_axe03 = var1;
   }

   public int getUtil_axe04() {
      return this.util_axe04;
   }

   public void setUtil_axe04(int var1) {
      this.util_axe04 = var1;
   }

   public int getUtil_axe05() {
      return this.util_axe05;
   }

   public void setUtil_axe05(int var1) {
      this.util_axe05 = var1;
   }

   public int getUtil_axe06() {
      return this.util_axe06;
   }

   public void setUtil_axe06(int var1) {
      this.util_axe06 = var1;
   }

   public int getUtil_axe07() {
      return this.util_axe07;
   }

   public void setUtil_axe07(int var1) {
      this.util_axe07 = var1;
   }

   public int getUtil_axe08() {
      return this.util_axe08;
   }

   public void setUtil_axe08(int var1) {
      this.util_axe08 = var1;
   }

   public int getUtil_axe09() {
      return this.util_axe09;
   }

   public void setUtil_axe09(int var1) {
      this.util_axe09 = var1;
   }

   public int getUtil_axe11() {
      return this.util_axe11;
   }

   public void setUtil_axe11(int var1) {
      this.util_axe11 = var1;
   }

   public int getUtil_axe12() {
      return this.util_axe12;
   }

   public void setUtil_axe12(int var1) {
      this.util_axe12 = var1;
   }

   public int getUtil_axe13() {
      return this.util_axe13;
   }

   public void setUtil_axe13(int var1) {
      this.util_axe13 = var1;
   }

   public double getEcart01() {
      return this.ecart01;
   }

   public void setEcart01(double var1) {
      this.ecart01 = var1;
   }

   public double getEcart02() {
      return this.ecart02;
   }

   public void setEcart02(double var1) {
      this.ecart02 = var1;
   }

   public double getEcart03() {
      return this.ecart03;
   }

   public void setEcart03(double var1) {
      this.ecart03 = var1;
   }

   public double getEcart04() {
      return this.ecart04;
   }

   public void setEcart04(double var1) {
      this.ecart04 = var1;
   }

   public double getEcart05() {
      return this.ecart05;
   }

   public void setEcart05(double var1) {
      this.ecart05 = var1;
   }

   public double getEcart06() {
      return this.ecart06;
   }

   public void setEcart06(double var1) {
      this.ecart06 = var1;
   }

   public double getEcart07() {
      return this.ecart07;
   }

   public void setEcart07(double var1) {
      this.ecart07 = var1;
   }

   public double getEcart08() {
      return this.ecart08;
   }

   public void setEcart08(double var1) {
      this.ecart08 = var1;
   }

   public double getEcart09() {
      return this.ecart09;
   }

   public void setEcart09(double var1) {
      this.ecart09 = var1;
   }

   public double getEcart11() {
      return this.ecart11;
   }

   public void setEcart11(double var1) {
      this.ecart11 = var1;
   }

   public double getEcart12() {
      return this.ecart12;
   }

   public void setEcart12(double var1) {
      this.ecart12 = var1;
   }

   public double getEcart13() {
      return this.ecart13;
   }

   public void setEcart13(double var1) {
      this.ecart13 = var1;
   }

   public double getTotImputation01() {
      return this.totImputation01;
   }

   public void setTotImputation01(double var1) {
      this.totImputation01 = var1;
   }

   public double getTotImputation02() {
      return this.totImputation02;
   }

   public void setTotImputation02(double var1) {
      this.totImputation02 = var1;
   }

   public double getTotImputation03() {
      return this.totImputation03;
   }

   public void setTotImputation03(double var1) {
      this.totImputation03 = var1;
   }

   public double getTotImputation04() {
      return this.totImputation04;
   }

   public void setTotImputation04(double var1) {
      this.totImputation04 = var1;
   }

   public double getTotImputation05() {
      return this.totImputation05;
   }

   public void setTotImputation05(double var1) {
      this.totImputation05 = var1;
   }

   public double getTotImputation06() {
      return this.totImputation06;
   }

   public void setTotImputation06(double var1) {
      this.totImputation06 = var1;
   }

   public double getTotImputation07() {
      return this.totImputation07;
   }

   public void setTotImputation07(double var1) {
      this.totImputation07 = var1;
   }

   public double getTotImputation08() {
      return this.totImputation08;
   }

   public void setTotImputation08(double var1) {
      this.totImputation08 = var1;
   }

   public double getTotImputation09() {
      return this.totImputation09;
   }

   public void setTotImputation09(double var1) {
      this.totImputation09 = var1;
   }

   public double getTotImputation11() {
      return this.totImputation11;
   }

   public void setTotImputation11(double var1) {
      this.totImputation11 = var1;
   }

   public double getTotImputation12() {
      return this.totImputation12;
   }

   public void setTotImputation12(double var1) {
      this.totImputation12 = var1;
   }

   public double getTotImputation13() {
      return this.totImputation13;
   }

   public void setTotImputation13(double var1) {
      this.totImputation13 = var1;
   }

   public String getCleStandard() {
      return this.cleStandard;
   }

   public void setCleStandard(String var1) {
      this.cleStandard = var1;
   }

   public String getCleStructure() {
      return this.cleStructure;
   }

   public void setCleStructure(String var1) {
      this.cleStructure = var1;
   }

   public boolean isVar_valide_analytique() {
      return this.var_valide_analytique;
   }

   public void setVar_valide_analytique(boolean var1) {
      this.var_valide_analytique = var1;
   }

   public boolean isModeConsultation() {
      return this.modeConsultation;
   }

   public void setModeConsultation(boolean var1) {
      this.modeConsultation = var1;
   }

   public String getOngletActif() {
      return this.ongletActif;
   }

   public void setOngletActif(String var1) {
      this.ongletActif = var1;
   }

   public DataModel getDataModelRecherche() {
      return this.dataModelRecherche;
   }

   public void setDataModelRecherche(DataModel var1) {
      this.dataModelRecherche = var1;
   }

   public String getLibelleRecherche() {
      return this.libelleRecherche;
   }

   public void setLibelleRecherche(String var1) {
      this.libelleRecherche = var1;
   }

   public boolean isShowModalPanelRecherche() {
      return this.showModalPanelRecherche;
   }

   public void setShowModalPanelRecherche(boolean var1) {
      this.showModalPanelRecherche = var1;
   }

   public boolean isSelectObjet() {
      return this.selectObjet;
   }

   public void setSelectObjet(boolean var1) {
      this.selectObjet = var1;
   }

   public int getNatureCleRepartition() {
      return this.natureCleRepartition;
   }

   public void setNatureCleRepartition(int var1) {
      this.natureCleRepartition = var1;
   }

   public boolean isAffiche_projet() {
      return this.affiche_projet;
   }

   public void setAffiche_projet(boolean var1) {
      this.affiche_projet = var1;
   }

   public DataModel getDataModelAxe10() {
      return this.dataModelAxe10;
   }

   public void setDataModelAxe10(DataModel var1) {
      this.dataModelAxe10 = var1;
   }

   public double getEcart10() {
      return this.ecart10;
   }

   public void setEcart10(double var1) {
      this.ecart10 = var1;
   }

   public List getLesProjetsItems() {
      return this.lesProjetsItems;
   }

   public void setLesProjetsItems(List var1) {
      this.lesProjetsItems = var1;
   }

   public int getUtil_axe10() {
      return this.util_axe10;
   }

   public void setUtil_axe10(int var1) {
      this.util_axe10 = var1;
   }

   public List getLesPostesItems() {
      return this.lesPostesItems;
   }

   public void setLesPostesItems(List var1) {
      this.lesPostesItems = var1;
   }

   public double getMontantAImputer() {
      return this.montantAImputer;
   }

   public void setMontantAImputer(double var1) {
      this.montantAImputer = var1;
   }

   public float getQteAImputer() {
      return this.qteAImputer;
   }

   public void setQteAImputer(float var1) {
      this.qteAImputer = var1;
   }

   public DataModel getDataModelImputDossier() {
      return this.dataModelImputDossier;
   }

   public void setDataModelImputDossier(DataModel var1) {
      this.dataModelImputDossier = var1;
   }

   public boolean isModeTransit() {
      return this.modeTransit;
   }

   public void setModeTransit(boolean var1) {
      this.modeTransit = var1;
   }

   public double getTotCredit() {
      return this.totCredit;
   }

   public void setTotCredit(double var1) {
      this.totCredit = var1;
   }

   public double getTotDebit() {
      return this.totDebit;
   }

   public void setTotDebit(double var1) {
      this.totDebit = var1;
   }

   public double getTotSolde() {
      return this.totSolde;
   }

   public void setTotSolde(double var1) {
      this.totSolde = var1;
   }

   public boolean isShowModalPanelAxe04() {
      return this.showModalPanelAxe04;
   }

   public void setShowModalPanelAxe04(boolean var1) {
      this.showModalPanelAxe04 = var1;
   }

   public boolean isBoutonAxe04() {
      return this.boutonAxe04;
   }

   public void setBoutonAxe04(boolean var1) {
      this.boutonAxe04 = var1;
   }

   public EcrituresAnalytiqueCtrl getAnalytiqueCtrl04() {
      return this.analytiqueCtrl04;
   }

   public void setAnalytiqueCtrl04(EcrituresAnalytiqueCtrl var1) {
      this.analytiqueCtrl04 = var1;
   }
}
