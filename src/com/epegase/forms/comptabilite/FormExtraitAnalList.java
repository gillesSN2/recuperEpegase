package com.epegase.forms.comptabilite;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Activites;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresAnalytique;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlanAnalytiqueRepartition;
import com.epegase.systeme.classe.PlanComptable;
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
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.control.ObjetTable;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.EcrituresAnalytiquesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.ExercicesAchatsDao;
import com.epegase.systeme.dao.ExercicesPayeDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.ProductionAtelierDao;
import com.epegase.systeme.dao.ProductionLigneDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LireLesoptionsAchats;
import com.epegase.systeme.xml.LireLesoptionsCaisses;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.OptionAchats;
import com.epegase.systeme.xml.OptionCaisses;
import com.epegase.systeme.xml.OptionComptabilite;
import com.epegase.systeme.xml.OptionVentes;
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
import org.hibernate.Transaction;
import org.jdom.JDOMException;

public class FormExtraitAnalList implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action;
   private int var_memo_action;
   private String pageIndex;
   private int nature;
   private FormRecherche formRecherche;
   private OptionComptabilite optionComptabilite;
   private ExercicesComptable selectedExo;
   private ExercicesComptable lastExo;
   private int var_nb_max = 100;
   private EcrituresAnalytique ecrituresAnalytique;
   private EcrituresAnalytique ecrituresAnalytiqueMemo;
   private EcrituresAnalytiquesDao ecrituresAnalytiquesDao;
   private transient DataModel dataModelEcrituresAnalytiques = new ListDataModel();
   private List lesEcrituresAnalytiques = new ArrayList();
   private String periode;
   private UtilDate utilDate = new UtilDate();
   private double var_total_debit = 0.0D;
   private double var_total_credit = 0.0D;
   private double var_solde_debit = 0.0D;
   private double var_solde_credit = 0.0D;
   private double var_total_select_debit = 0.0D;
   private double var_total_select_credit = 0.0D;
   private boolean var_affiche_bouton = false;
   private boolean testdeliste = true;
   private UtilNombre utilNombre = new UtilNombre();
   private boolean showModalFind = false;
   private boolean showModalFindLight = false;
   private Date dateDebut;
   private Date dateFin;
   private boolean situationRech = false;
   private boolean reserveRech = false;
   private List lesModelsimpression = new ArrayList();
   private boolean showModalPanelPrint = false;
   private boolean mode_calcul = false;
   private PlansAnalytiques plansAnalytiques;
   private PlansAnalytiquesDao plansAnalytiquesDao;
   private PlanAnalytiqueRepartition planAnalytiqueRepartition;
   private Salaries salaries;
   private SalariesDao salariesDao;
   private Activites activites;
   private ActivitesDao activitesDao;
   private Parc parc;
   private ParcDao parcDao;
   private int var_nature_analytique;
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
   private boolean affiche_clesStr = false;
   private boolean affiche_axesStr = false;
   private int affiche_dossier = 0;
   private boolean affiche_parc = false;
   private boolean affiche_agent = false;
   private String rec_dossier;
   private String rec_activite;
   private String var_filtre_analytique;
   private List listeOngletAnalytique = new ArrayList();
   private ObjetTable objetTable = new ObjetTable();
   private List mesOngletsAnalytiqueItems = new ArrayList();
   private int var_axe;
   private List lesActivites = new ArrayList();
   private List lesParcs = new ArrayList();
   private List lesDossiers = new ArrayList();
   private List lesChantiers = new ArrayList();
   private List lesMissions = new ArrayList();
   private List lesClesStructures = new ArrayList();
   private List lesAxesStructures = new ArrayList();
   private List lesAgents = new ArrayList();
   private List lesSitDepSer = new ArrayList();
   private List lesRegSecPdv = new ArrayList();
   private List lesSitLigAte = new ArrayList();
   private boolean liste_activite = false;
   private boolean liste_site = false;
   private boolean liste_departement = false;
   private boolean liste_service = false;
   private boolean liste_region = false;
   private boolean liste_secteur = false;
   private boolean liste_pdv = false;
   private boolean liste_sitePrdv = false;
   private boolean liste_ligne = false;
   private boolean liste_atelier = false;
   private boolean liste_clesStr = false;
   private boolean liste_axesStr = false;
   private boolean liste_parc = false;
   private boolean liste_agent = false;
   private boolean liste_dossier = false;
   private boolean liste_anal1 = false;
   private boolean liste_anal2 = false;
   private boolean liste_anal3 = false;
   private boolean decoupageActivite = false;
   private List lesColones1 = new ArrayList();
   private List lesColones2 = new ArrayList();
   private List lesColones3 = new ArrayList();
   private PlanComptable planComptable = new PlanComptable();
   private String inpCompte;
   private String inpClasse;
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
   private List mesAxesAnalytique = new ArrayList();
   private boolean var_consult_analytique = false;
   private transient DataModel dataModelDetAnalytique = new ListDataModel();
   private boolean showModalPanelAnalytique = false;
   private boolean showModalPanelAnalRecup = false;
   private boolean showModalPanelParc = false;
   private boolean showModalPanelDossier = false;
   private List mesClesItems = new ArrayList();
   private String var_cle_analytique;
   private List listeRepartitionAnal = new ArrayList();
   private boolean var_affiche_saisie_anal = false;
   private boolean var_sens_analytique = false;
   private boolean affiche_anal1 = false;
   private boolean affiche_anal2 = false;
   private boolean affiche_anal3 = false;
   private boolean affiche_anal4 = false;
   private double var_montant_ligne;
   private double var_montant_impute;
   private double var_ecart;
   private boolean var_valide_analytique = false;
   private long var_memo_ligne_gene;
   private transient DataModel dataModelParc = new ListDataModel();
   private transient DataModel dataModelDossier = new ListDataModel();
   private transient DataModel dataModelChantier = new ListDataModel();
   private transient DataModel dataModelMissison = new ListDataModel();
   private transient DataModel dataModelAgent = new ListDataModel();
   private transient DataModel dataModelActivite = new ListDataModel();
   private boolean showModalPanelActivite = false;
   private List laColonne1Items = new ArrayList();
   private List laColonne2Items = new ArrayList();
   private List laColonne3Items = new ArrayList();
   private Ecritures ecritures = new Ecritures();
   private transient DataModel dataModelAxeCumul = new ListDataModel();
   private List listeAxeCumul = new ArrayList();
   private ObjetCompte objetCompte;
   private int numAxe;
   private List lesModelesAutorises;
   private boolean showModalPanelInformation = false;
   private String nomCreation;
   private String nomModification;

   public void InstancesDaoUtilses() {
      this.ecrituresAnalytiquesDao = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
      this.activitesDao = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      this.parcDao = new ParcDao(this.baseLog, this.utilInitHibernate);
   }

   public void init() throws HibernateException, NamingException {
      this.dateDebut = this.selectedExo.getExecptDateDebut();
      this.dateFin = this.selectedExo.getExecptDateFin();
      this.periode = "PERIODE du " + this.utilDate.dateToStringFr(this.dateDebut) + " au " + this.utilDate.dateToStringFr(this.dateFin);
      if (this.optionComptabilite.getNbLigneMaxEx() != null && !this.optionComptabilite.getNbLigneMaxEx().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionComptabilite.getNbLigneMaxEx());
      } else {
         this.var_nb_max = 100;
      }

      if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
         this.decoupageActivite = true;
      } else {
         this.decoupageActivite = false;
      }

      this.recupererAxesAnalytiques();
   }

   public void recupererAxesAnalytiques() {
      this.mesAxesAnalytique.clear();
      new OptionVentes();
      LireLesoptionsVentes var2 = new LireLesoptionsVentes();
      var2.setStrId(this.structureLog.getStrid());
      var2.lancer();
      OptionVentes var1 = var2.getOptionsVentes();
      new OptionAchats();
      LireLesoptionsAchats var4 = new LireLesoptionsAchats();
      var4.setStrId(this.structureLog.getStrid());
      var4.lancer();
      OptionAchats var3 = var4.getOptionAchats();
      new OptionCaisses();
      LireLesoptionsCaisses var6 = new LireLesoptionsCaisses();
      var6.setStrId(this.structureLog.getStrid());
      var6.lancer();
      OptionCaisses var5 = var6.getOptionsCaisses();
      if (this.structureLog.isStrSite() || var1.getAxeSite().equals("true") || var3.getAxeSite().equals("true") || var5.getAxeSite().equals("true")) {
         this.mesAxesAnalytique.add(new SelectItem(100, "Sites-Départements-Services"));
      }

      if (this.structureLog.isStrRegion() || var1.getAxeRegion().equals("true") || var3.getAxeRegion().equals("true") || var5.getAxeRegion().equals("true")) {
         this.mesAxesAnalytique.add(new SelectItem(101, "Régions-Secteurs-Points de vente"));
      }

      if (this.structureLog.getStrtypeentreprise().equals("2") && (this.structureLog.isStrUsine() || var1.getAxeUsine().equals("true") || var3.getAxeUsine().equals("true") || var5.getAxeUsine().equals("true"))) {
         this.mesAxesAnalytique.add(new SelectItem(102, "Sites-Ateliers-Lignes"));
      }

      if (this.structureLog.isStrActivite() || var1.getAxeActivite().equals("true") || var3.getAxeActivite().equals("true") || var5.getAxeActivite().equals("true")) {
         this.mesAxesAnalytique.add(new SelectItem(110, "Activités"));
      }

      if (this.rechercheModule(70000) && (this.structureLog.isStrParc() || var1.getAxeParc().equals("true") || var3.getAxeParc().equals("true") || var5.getAxeParc().equals("true"))) {
         this.mesAxesAnalytique.add(new SelectItem(120, "Parcs"));
      }

      if (this.structureLog.getStrDossier() != 0 || var1.getAxeDossier().equals("1") || var3.getAxeDossier().equals("1") || var5.getAxeDossier().equals("1") || var1.getAxeDossier().equals("2") || var3.getAxeDossier().equals("2") || var5.getAxeDossier().equals("2")) {
         this.mesAxesAnalytique.add(new SelectItem(6, "Dossiers"));
      }

      if (this.rechercheModule(50000) && (this.structureLog.isStrAgent() || var1.getAxeAgent().equals("true") || var3.getAxeAgent().equals("true") || var5.getAxeAgent().equals("true"))) {
         this.mesAxesAnalytique.add(new SelectItem(122, "Agents"));
      }

      if (this.structureLog.isStrChantier() || var1.getAxeChantier().equals("true") || var3.getAxeChantier().equals("true") || var5.getAxeChantier().equals("true")) {
         this.mesAxesAnalytique.add(new SelectItem(7, "Chantiers"));
      }

      if (this.structureLog.isStrMission() || var1.getAxeMission().equals("true") || var3.getAxeMission().equals("true") || var5.getAxeMission().equals("true")) {
         this.mesAxesAnalytique.add(new SelectItem(8, "Missions/Frais"));
      }

      if (this.rechercheModule(40300) && (this.structureLog.isStrProjet() || var1.getAxeProjet().equals("true") || var3.getAxeProjet().equals("true") || var5.getAxeProjet().equals("true"))) {
         this.mesAxesAnalytique.add(new SelectItem(130, "Projets"));
      }

      if (this.structureLog.isStrCles() || var1.getAxeCles().equals("true") || var3.getAxeCles().equals("true") || var5.getAxeCles().equals("true")) {
         this.mesAxesAnalytique.add(new SelectItem(9, "Clés répartitions"));
      }

      if (this.structureLog.isStrStructure() || var1.getAxeStructure().equals("true") || var3.getAxeStructure().equals("true") || var5.getAxeStructure().equals("true")) {
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

   public void trouverCompte() throws HibernateException, NamingException {
      this.inpCompte = "";
      this.inpClasse = "";
      this.listeAxeCumul.clear();
      this.dataModelAxeCumul.setWrappedData(this.listeAxeCumul);
      this.initVariable();
      this.var_filtre_analytique = "";
      this.numAxe = 1;
      this.mode_calcul = false;
      if (this.usersLog.getUsrExtraitAnal() != 0) {
         this.var_nature_analytique = this.usersLog.getUsrExtraitAnal();
         this.structureNature();
         this.showModalFindLight = true;
      } else {
         this.var_nature_analytique = 0;
         this.showModalFind = true;
      }

   }

   public void annuleRecherche() {
      this.showModalFind = false;
      this.showModalFindLight = false;
   }

   public void initVariable() {
      this.lesActivites.clear();
      this.lesSitDepSer.clear();
      this.lesRegSecPdv.clear();
      this.lesSitLigAte.clear();
      this.lesParcs.clear();
      this.lesDossiers.clear();
      this.lesMissions.clear();
      this.lesChantiers.clear();
      this.lesAgents.clear();
      this.lesColones1.clear();
      this.lesColones2.clear();
      this.lesColones3.clear();
      this.lesClesStructures.clear();
      this.lesAxesStructures.clear();
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
      this.affiche_anal1 = false;
      this.affiche_anal2 = false;
      this.affiche_anal3 = false;
      this.affiche_anal4 = false;
      this.affiche_agent = false;
      this.affiche_clesStr = false;
      this.affiche_axesStr = false;
      this.plansAnalytiques = null;
      this.rec_dossier = "";
      this.rec_dossier = "";
   }

   public void structureNature() throws HibernateException, NamingException {
      this.initVariable();
      if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
         this.decoupageActivite = true;
      } else {
         this.decoupageActivite = false;
      }

      this.mode_calcul = true;
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Analytique");
      if (this.var_nature_analytique == 100) {
         this.tableSitDepSer(var1);
      } else if (this.var_nature_analytique == 101) {
         this.tableRegSecPdv(var1);
      } else if (this.var_nature_analytique == 102) {
         this.tableSitLigAte(var1);
      } else if (this.var_nature_analytique == 110) {
         this.affiche_activite = true;
         if (this.decoupageActivite) {
            this.calculerLesDecoupagesActivites(var1);
         } else if (this.structureLog.getStrActiviteModeSasie() == 0) {
            this.lesActivites = this.activitesDao.selectActivites(var1);
         }
      } else if (this.var_nature_analytique == 120) {
         this.affiche_parc = true;
         this.lesParcs = this.parcDao.selectLesParcs(var1);
      } else if (this.var_nature_analytique == 6) {
         this.affiche_dossier = this.structureLog.getStrDossier();
         if (this.structureLog.getStrDossier() == 3) {
            this.lesDossiers.clear();
         } else {
            this.lesDossiers = this.plansAnalytiquesDao.selectAnal("6", var1);
         }
      } else if (this.var_nature_analytique == 122) {
         this.lesAgents.clear();
         new ExercicesPaye();
         ExercicesPayeDao var3 = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
         ExercicesPaye var2 = var3.recupererLastExo(var1);
         if (var2 != null) {
            this.lesAgents = this.salariesDao.chargerlesSalariesActif("*", var1);
            this.affiche_agent = true;
         } else {
            this.affiche_agent = false;
         }
      } else if (this.var_nature_analytique == 7) {
         this.affiche_anal1 = true;
         this.lesChantiers = this.plansAnalytiquesDao.selectAnal("7", var1);
      } else if (this.var_nature_analytique == 8) {
         this.affiche_anal3 = true;
         this.lesMissions = this.plansAnalytiquesDao.selectAnal("8", var1);
      } else if (this.var_nature_analytique != 130 && this.var_nature_analytique != 9) {
         if (this.var_nature_analytique == 200) {
            this.affiche_clesStr = true;
            this.lesClesStructures = this.plansAnalytiquesDao.selectAnal("9", var1);
         } else if (this.var_nature_analytique == 201) {
            this.affiche_axesStr = true;
            this.lesAxesStructures = this.plansAnalytiquesDao.selectAnal("20", var1);
         }
      }

      if (!this.decoupageActivite) {
         if (this.lesActivites.size() == 0 && this.structureLog.getStrActiviteModeSasie() == 0) {
            this.affiche_activite = false;
         }
      } else if (this.lesColones1.size() == 0) {
         this.affiche_activite = false;
         if (this.lesColones2.size() == 0) {
            this.affiche_activite = false;
            if (this.lesColones3.size() == 0) {
               this.affiche_activite = false;
            } else {
               this.affiche_activite = true;
            }
         } else {
            this.affiche_activite = true;
         }
      } else {
         this.affiche_activite = true;
      }

      if (this.lesParcs.size() == 0) {
         this.affiche_parc = false;
      }

      if (this.lesDossiers.size() == 0 && this.structureLog.getStrDossier() <= 1) {
         this.affiche_dossier = 0;
      }

      if (this.lesAgents.size() == 0) {
         this.affiche_agent = false;
      }

      if (this.lesSitDepSer.size() == 0) {
         this.affiche_site = false;
         this.affiche_departement = false;
         this.affiche_service = false;
      }

      if (this.lesRegSecPdv.size() == 0) {
         this.affiche_region = false;
         this.affiche_secteur = false;
         this.affiche_pdv = false;
      }

      if (this.lesSitLigAte.size() == 0) {
         this.affiche_sitePrdv = false;
         this.affiche_atelier = false;
         this.affiche_ligne = false;
      }

      if (this.lesClesStructures.size() == 0) {
         this.affiche_clesStr = false;
      }

      if (this.lesAxesStructures.size() == 0) {
         this.affiche_axesStr = false;
      }

      this.utilInitHibernate.closeSession();
   }

   public void tableSitDepSer(Session var1) throws HibernateException, NamingException {
      this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
      this.affiche_site = true;
      new ArrayList();
      SiteDao var3 = new SiteDao(this.baseLog, this.utilInitHibernate);
      List var2 = var3.chargerLesSitesList(var1);
      if (var2.size() != 0) {
         new Site();

         for(int var5 = 0; var5 < var2.size(); ++var5) {
            Site var4 = (Site)var2.get(var5);
            this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
            this.planAnalytiqueRepartition.setAffiche_site(true);
            this.planAnalytiqueRepartition.setAffiche_departement(false);
            this.planAnalytiqueRepartition.setAffiche_service(false);
            this.planAnalytiqueRepartition.setCleCodeSite(var4.getSitCode());
            this.planAnalytiqueRepartition.setCleLibelleSite(var4.getSitNomFr());
            this.lesSitDepSer.add(this.planAnalytiqueRepartition);
            this.affiche_departement = true;
            new ArrayList();
            DepartementDao var7 = new DepartementDao(this.baseLog, this.utilInitHibernate);
            List var6 = var7.listDepartementBySit(var4, var1);
            if (var6.size() != 0) {
               new Departement();

               for(int var9 = 0; var9 < var6.size(); ++var9) {
                  Departement var8 = (Departement)var6.get(var9);
                  this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                  this.planAnalytiqueRepartition.setAffiche_site(false);
                  this.planAnalytiqueRepartition.setAffiche_departement(true);
                  this.planAnalytiqueRepartition.setAffiche_service(false);
                  this.planAnalytiqueRepartition.setCleCodeSite(var8.getSite().getSitCode());
                  this.planAnalytiqueRepartition.setCleLibelleSite(var8.getSite().getSitNomFr());
                  this.planAnalytiqueRepartition.setCleCodeDepartement(var8.getDepCode());
                  this.planAnalytiqueRepartition.setCleLibelleDepartement(var8.getDepNomFr());
                  this.lesSitDepSer.add(this.planAnalytiqueRepartition);
                  this.affiche_service = true;
                  new ArrayList();
                  ServiceDao var11 = new ServiceDao(this.baseLog, this.utilInitHibernate);
                  List var10 = var11.listServiceByDep(var8, var1);
                  if (var10.size() != 0) {
                     new Service();

                     for(int var13 = 0; var13 < var10.size(); ++var13) {
                        Service var12 = (Service)var10.get(var13);
                        this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                        this.planAnalytiqueRepartition.setAffiche_site(false);
                        this.planAnalytiqueRepartition.setAffiche_departement(false);
                        this.planAnalytiqueRepartition.setAffiche_service(true);
                        this.planAnalytiqueRepartition.setCleCodeSite(var12.getSite().getSitCode());
                        this.planAnalytiqueRepartition.setCleLibelleSite(var12.getSite().getSitNomFr());
                        this.planAnalytiqueRepartition.setCleCodeDepartement(var12.getDepartement().getDepCode());
                        this.planAnalytiqueRepartition.setCleLibelleDepartement(var12.getDepartement().getDepNomFr());
                        this.planAnalytiqueRepartition.setCleCodeService(var12.getSerCode());
                        this.planAnalytiqueRepartition.setCleLibelleService(var12.getSerNomFr());
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
         new Region();

         for(int var5 = 0; var5 < var2.size(); ++var5) {
            Region var4 = (Region)var2.get(var5);
            this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
            this.planAnalytiqueRepartition.setCleCodeRegion(var4.getRegCode());
            this.planAnalytiqueRepartition.setCleLibelleRegion(var4.getRegNomFr());
            this.lesRegSecPdv.add(this.planAnalytiqueRepartition);
            this.affiche_secteur = true;
            new ArrayList();
            SecteurDao var7 = new SecteurDao(this.baseLog, this.utilInitHibernate);
            List var6 = var7.listSecteurByRegion(var4, var1);
            if (var6.size() != 0) {
               new Secteur();

               for(int var9 = 0; var9 < var6.size(); ++var9) {
                  Secteur var8 = (Secteur)var6.get(var9);
                  this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                  this.planAnalytiqueRepartition.setCleCodeRegion(var8.getRegion().getRegCode());
                  this.planAnalytiqueRepartition.setCleLibelleRegion(var8.getRegion().getRegNomFr());
                  this.planAnalytiqueRepartition.setCleCodeSecteur(var8.getSecCode());
                  this.planAnalytiqueRepartition.setCleLibelleSecteur(var8.getSecNomFr());
                  this.lesRegSecPdv.add(this.planAnalytiqueRepartition);
                  this.affiche_pdv = true;
                  new ArrayList();
                  PointDeVenteDao var11 = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
                  List var10 = var11.listPdvBySecteur(var8, var1);
                  if (var10.size() != 0) {
                     new PointDeVente();

                     for(int var13 = 0; var13 < var10.size(); ++var13) {
                        PointDeVente var12 = (PointDeVente)var10.get(var13);
                        this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                        this.planAnalytiqueRepartition.setCleCodeRegion(var12.getRegion().getRegCode());
                        this.planAnalytiqueRepartition.setCleLibelleRegion(var12.getRegion().getRegNomFr());
                        this.planAnalytiqueRepartition.setCleCodeSecteur(var12.getSecteur().getSecCode());
                        this.planAnalytiqueRepartition.setCleLibelleSecteur(var12.getSecteur().getSecNomFr());
                        this.planAnalytiqueRepartition.setCleCodePdv(var12.getPdvCode());
                        this.planAnalytiqueRepartition.setCleLibellePdv(var12.getPdvNomFr());
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
         new Site();

         for(int var5 = 0; var5 < var2.size(); ++var5) {
            Site var4 = (Site)var2.get(var5);
            this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
            this.planAnalytiqueRepartition.setAffiche_site(true);
            this.planAnalytiqueRepartition.setAffiche_ligne(false);
            this.planAnalytiqueRepartition.setAffiche_atelier(false);
            this.planAnalytiqueRepartition.setCleCodeSite(var4.getSitCode());
            this.planAnalytiqueRepartition.setCleLibelleSite(var4.getSitNomFr());
            this.lesSitLigAte.add(this.planAnalytiqueRepartition);
            this.affiche_ligne = true;
            new ArrayList();
            ProductionLigneDao var7 = new ProductionLigneDao(this.baseLog, this.utilInitHibernate);
            List var6 = var7.listProductionLigneBySit(var4, var1);
            if (var6.size() != 0) {
               new ProductionLigne();

               for(int var9 = 0; var9 < var6.size(); ++var9) {
                  ProductionLigne var8 = (ProductionLigne)var6.get(var9);
                  this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                  this.planAnalytiqueRepartition.setAffiche_site(false);
                  this.planAnalytiqueRepartition.setAffiche_ligne(true);
                  this.planAnalytiqueRepartition.setAffiche_atelier(false);
                  this.planAnalytiqueRepartition.setCleCodeSite(var8.getSite().getSitCode());
                  this.planAnalytiqueRepartition.setCleLibelleSite(var8.getSite().getSitNomFr());
                  this.planAnalytiqueRepartition.setCleCodeLigne(var8.getLigCode());
                  this.planAnalytiqueRepartition.setCleLibelleLigne(var8.getLigNomFr());
                  this.lesSitLigAte.add(this.planAnalytiqueRepartition);
                  this.affiche_atelier = true;
                  new ArrayList();
                  ProductionAtelierDao var11 = new ProductionAtelierDao(this.baseLog, this.utilInitHibernate);
                  List var10 = var11.listProductionAtelierByLigne(var8, var1);
                  if (var10.size() != 0) {
                     new ProductionAtelier();

                     for(int var13 = 0; var13 < var10.size(); ++var13) {
                        ProductionAtelier var12 = (ProductionAtelier)var10.get(var13);
                        this.planAnalytiqueRepartition = new PlanAnalytiqueRepartition();
                        this.planAnalytiqueRepartition.setAffiche_site(false);
                        this.planAnalytiqueRepartition.setAffiche_ligne(false);
                        this.planAnalytiqueRepartition.setAffiche_atelier(true);
                        this.planAnalytiqueRepartition.setCleCodeSite(var12.getSite().getSitCode());
                        this.planAnalytiqueRepartition.setCleLibelleSite(var12.getSite().getSitNomFr());
                        this.planAnalytiqueRepartition.setCleCodeLigne(var12.getProductionLigne().getLigCode());
                        this.planAnalytiqueRepartition.setCleLibelleLigne(var12.getProductionLigne().getLigNomFr());
                        this.planAnalytiqueRepartition.setCleCodeAtelier(var12.getAteCode());
                        this.planAnalytiqueRepartition.setCleLibelleAtelier(var12.getAteNomFr());
                        this.lesSitLigAte.add(this.planAnalytiqueRepartition);
                     }
                  }
               }
            }
         }
      }

   }

   public void calculerLesDecoupagesActivites(Session var1) throws HibernateException, NamingException {
      if (this.decoupageActivite) {
         boolean var2 = false;
         if (var1 == null) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Activites");
            var2 = true;
         }

         if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
            this.lesColones1 = this.activitesDao.selectActivites(this.structureLog.getStrCode1(), var1);
         }

         if (this.structureLog.getStrCode2() != null && !this.structureLog.getStrCode2().isEmpty()) {
            this.lesColones2 = this.activitesDao.selectActivites(this.structureLog.getStrCode2(), var1);
         }

         if (this.structureLog.getStrCode3() != null && !this.structureLog.getStrCode3().isEmpty()) {
            this.lesColones3 = this.activitesDao.selectActivites(this.structureLog.getStrCode3(), var1);
         }

         if (var2) {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void rechercheDossier() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      if (this.rec_dossier != null && !this.rec_dossier.isEmpty()) {
         new ExercicesAchats();
         ExercicesAchatsDao var2 = new ExercicesAchatsDao(this.baseLog, this.utilInitHibernate);
         ExercicesAchats var1 = var2.recupererLastExo((Session)null);
         if (var1 != null) {
            String var3 = "" + ((new Date()).getYear() + 1900);
            this.plansAnalytiques = this.formRecherche.rechercheDossier(this.rec_dossier, var3, 535, new Date(), var1, "", "");
            if (this.plansAnalytiques != null) {
               if (this.plansAnalytiques.getAnaId() != 0L) {
                  this.calculeDossier();
               } else {
                  this.var_action = 16;
               }
            } else if (this.plansAnalytiques == null) {
               this.calculeDossier();
            }
         }
      }

   }

   public void recuperationDossier() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.plansAnalytiques = this.formRecherche.calculeDossier();
      this.calculeDossier();
   }

   public void calculeDossier() throws NamingException {
      if (this.plansAnalytiques != null) {
         this.rec_dossier = this.plansAnalytiques.getAnaCode();
      } else {
         this.rec_dossier = "";
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleDossier() {
      this.rec_dossier = "";
      this.var_action = this.var_memo_action;
   }

   public void rechercheActivite() throws HibernateException, NamingException, JDOMException, IOException, ParseException {
      this.activites = this.formRecherche.rechercheActivites(this.rec_activite, 535);
      if (this.activites != null) {
         if (this.activites.getActId() != 0L) {
            this.calculeActvite();
         } else {
            this.var_action = 15;
         }
      } else if (this.activites == null) {
         this.calculeActvite();
      }

   }

   public void recuperationActivite() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.activites = this.formRecherche.calculeActivite();
      this.calculeActvite();
   }

   public void calculeActvite() throws NamingException {
      if (this.activites != null) {
         this.rec_activite = this.activites.getActCode();
      } else {
         this.rec_activite = "";
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleActivite() {
      this.rec_activite = "";
      this.var_action = this.var_memo_action;
   }

   public void recherchePlanComptable() throws JDOMException, IOException, HibernateException, NamingException {
      this.planComptable = this.formRecherche.recherchePlanComptable("", this.inpCompte, 535, this.selectedExo, 0, this.usersLog.getUsrCptInterdit(), this.optionComptabilite);
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
      if (this.planComptable != null) {
         this.inpCompte = this.planComptable.getPlcCompte();
      } else {
         this.inpCompte = "";
      }

      this.var_action = this.var_memo_action;
   }

   public void annulePlanComptable() {
      this.inpCompte = "";
      this.inpClasse = "";
      this.var_action = this.var_memo_action;
   }

   public void memoriseAxe() {
      int var1;
      if (this.lesActivites.size() != 0 && this.structureLog.getStrActiviteModeSasie() == 0) {
         for(var1 = 0; var1 < this.lesActivites.size(); ++var1) {
            if (((Activites)this.lesActivites.get(var1)).isSelect_activite()) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setIndice(1);
               this.objetCompte.setNumAxe(this.numAxe);
               this.objetCompte.setLot("Activité");
               this.objetCompte.setCode(((Activites)this.lesActivites.get(var1)).getActCode());
               this.objetCompte.setNom_FR(((Activites)this.lesActivites.get(var1)).getActNomFr());
               this.listeAxeCumul.add(this.objetCompte);
            }
         }
      } else if (this.rec_activite != null && !this.rec_activite.isEmpty() && this.structureLog.getStrActiviteModeSasie() == 1) {
         this.objetCompte = new ObjetCompte();
         this.objetCompte.setIndice(1);
         this.objetCompte.setNumAxe(this.numAxe);
         this.objetCompte.setLot("Activité");
         this.objetCompte.setCode(this.activites.getActCode());
         this.objetCompte.setNom_FR(this.activites.getActNomFr());
         this.listeAxeCumul.add(this.objetCompte);
      }

      if (this.lesSitDepSer.size() != 0) {
         for(var1 = 0; var1 < this.lesSitDepSer.size(); ++var1) {
            if (((PlanAnalytiqueRepartition)this.lesSitDepSer.get(var1)).isSelect_site()) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setIndice(2);
               this.objetCompte.setNumAxe(this.numAxe);
               this.objetCompte.setLot("Site");
               this.objetCompte.setCode(((PlanAnalytiqueRepartition)this.lesSitDepSer.get(var1)).getCleCodeSite());
               this.objetCompte.setNom_FR(((PlanAnalytiqueRepartition)this.lesSitDepSer.get(var1)).getCleLibelleSite());
               if (this.objetCompte.getCode() != null && !this.objetCompte.getCode().isEmpty()) {
                  this.listeAxeCumul.add(this.objetCompte);
               }
            }

            if (((PlanAnalytiqueRepartition)this.lesSitDepSer.get(var1)).isSelect_departement()) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setIndice(3);
               this.objetCompte.setNumAxe(this.numAxe);
               this.objetCompte.setLot("Département");
               this.objetCompte.setCode(((PlanAnalytiqueRepartition)this.lesSitDepSer.get(var1)).getCleCodeDepartement());
               this.objetCompte.setNom_FR(((PlanAnalytiqueRepartition)this.lesSitDepSer.get(var1)).getCleLibelleDepartement());
               if (this.objetCompte.getCode() != null && !this.objetCompte.getCode().isEmpty()) {
                  this.listeAxeCumul.add(this.objetCompte);
               }
            }

            if (((PlanAnalytiqueRepartition)this.lesSitDepSer.get(var1)).isSelect_service()) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setIndice(4);
               this.objetCompte.setNumAxe(this.numAxe);
               this.objetCompte.setLot("Service");
               this.objetCompte.setCode(((PlanAnalytiqueRepartition)this.lesSitDepSer.get(var1)).getCleCodeService());
               this.objetCompte.setNom_FR(((PlanAnalytiqueRepartition)this.lesSitDepSer.get(var1)).getCleLibelleService());
               if (this.objetCompte.getCode() != null && !this.objetCompte.getCode().isEmpty()) {
                  this.listeAxeCumul.add(this.objetCompte);
               }
            }
         }
      }

      if (this.lesRegSecPdv.size() != 0) {
         for(var1 = 0; var1 < this.lesRegSecPdv.size(); ++var1) {
            if (((PlanAnalytiqueRepartition)this.lesRegSecPdv.get(var1)).isSelect_region()) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setIndice(5);
               this.objetCompte.setNumAxe(this.numAxe);
               this.objetCompte.setLot("Région");
               this.objetCompte.setCode(((PlanAnalytiqueRepartition)this.lesRegSecPdv.get(var1)).getCleCodeRegion());
               this.objetCompte.setNom_FR(((PlanAnalytiqueRepartition)this.lesRegSecPdv.get(var1)).getCleLibelleRegion());
               if (this.objetCompte.getCode() != null && !this.objetCompte.getCode().isEmpty()) {
                  this.listeAxeCumul.add(this.objetCompte);
               }
            }

            if (((PlanAnalytiqueRepartition)this.lesRegSecPdv.get(var1)).isSelect_secteur()) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setIndice(6);
               this.objetCompte.setNumAxe(this.numAxe);
               this.objetCompte.setLot("Secteur");
               this.objetCompte.setCode(((PlanAnalytiqueRepartition)this.lesRegSecPdv.get(var1)).getCleCodeSecteur());
               this.objetCompte.setNom_FR(((PlanAnalytiqueRepartition)this.lesRegSecPdv.get(var1)).getCleLibelleSecteur());
               if (this.objetCompte.getCode() != null && !this.objetCompte.getCode().isEmpty()) {
                  this.listeAxeCumul.add(this.objetCompte);
               }
            }

            if (((PlanAnalytiqueRepartition)this.lesRegSecPdv.get(var1)).isSelect_pdv()) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setIndice(7);
               this.objetCompte.setNumAxe(this.numAxe);
               this.objetCompte.setLot("PDV");
               this.objetCompte.setCode(((PlanAnalytiqueRepartition)this.lesRegSecPdv.get(var1)).getCleCodePdv());
               this.objetCompte.setNom_FR(((PlanAnalytiqueRepartition)this.lesRegSecPdv.get(var1)).getCleLibellePdv());
               if (this.objetCompte.getCode() != null && !this.objetCompte.getCode().isEmpty()) {
                  this.listeAxeCumul.add(this.objetCompte);
               }
            }
         }
      }

      if (this.lesSitLigAte.size() != 0) {
         for(var1 = 0; var1 < this.lesSitLigAte.size(); ++var1) {
            if (((PlanAnalytiqueRepartition)this.lesSitLigAte.get(var1)).isSelect_site()) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setIndice(8);
               this.objetCompte.setNumAxe(this.numAxe);
               this.objetCompte.setLot("Site");
               this.objetCompte.setCode(((PlanAnalytiqueRepartition)this.lesSitLigAte.get(var1)).getCleCodeSite());
               this.objetCompte.setNom_FR(((PlanAnalytiqueRepartition)this.lesSitLigAte.get(var1)).getCleLibelleSite());
               if (this.objetCompte.getCode() != null && !this.objetCompte.getCode().isEmpty()) {
                  this.listeAxeCumul.add(this.objetCompte);
               }
            }

            if (((PlanAnalytiqueRepartition)this.lesSitLigAte.get(var1)).isSelect_ligne()) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setIndice(9);
               this.objetCompte.setNumAxe(this.numAxe);
               this.objetCompte.setLot("Ligne");
               this.objetCompte.setCode(((PlanAnalytiqueRepartition)this.lesSitLigAte.get(var1)).getCleCodeLigne());
               this.objetCompte.setNom_FR(((PlanAnalytiqueRepartition)this.lesSitLigAte.get(var1)).getCleLibelleLigne());
               if (this.objetCompte.getCode() != null && !this.objetCompte.getCode().isEmpty()) {
                  this.listeAxeCumul.add(this.objetCompte);
               }
            }

            if (((PlanAnalytiqueRepartition)this.lesSitLigAte.get(var1)).isSelect_atelier()) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setIndice(10);
               this.objetCompte.setNumAxe(this.numAxe);
               this.objetCompte.setLot("Atelier");
               this.objetCompte.setCode(((PlanAnalytiqueRepartition)this.lesSitLigAte.get(var1)).getCleCodeAtelier());
               this.objetCompte.setNom_FR(((PlanAnalytiqueRepartition)this.lesSitLigAte.get(var1)).getCleLibelleAtelier());
               if (this.objetCompte.getCode() != null && !this.objetCompte.getCode().isEmpty()) {
                  this.listeAxeCumul.add(this.objetCompte);
               }
            }
         }
      }

      if (this.lesParcs.size() != 0) {
         for(var1 = 0; var1 < this.lesParcs.size(); ++var1) {
            if (((Parc)this.lesParcs.get(var1)).isSelect_parc()) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setIndice(11);
               this.objetCompte.setNumAxe(this.numAxe);
               this.objetCompte.setLot("Parc");
               this.objetCompte.setCode(((Parc)this.lesParcs.get(var1)).getPrcImmatriculation());
               this.objetCompte.setNom_FR(((Parc)this.lesParcs.get(var1)).getPrcLibFamille() + " " + ((Parc)this.lesParcs.get(var1)).getPrcMarque());
               this.listeAxeCumul.add(this.objetCompte);
            }
         }
      }

      if (this.lesDossiers.size() != 0) {
         for(var1 = 0; var1 < this.lesDossiers.size(); ++var1) {
            if (((PlansAnalytiques)this.lesDossiers.get(var1)).isSelect_analytique()) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setIndice(12);
               this.objetCompte.setNumAxe(this.numAxe);
               this.objetCompte.setLot("Dossier");
               this.objetCompte.setCode(((PlansAnalytiques)this.lesDossiers.get(var1)).getAnaCode());
               this.objetCompte.setNom_FR(((PlansAnalytiques)this.lesDossiers.get(var1)).getAnaNomFr());
               this.listeAxeCumul.add(this.objetCompte);
            }
         }
      } else if (this.rec_dossier != null && !this.rec_dossier.isEmpty()) {
         if (this.structureLog.getStrDossier() == 3) {
            this.objetCompte = new ObjetCompte();
            this.objetCompte.setIndice(12);
            this.objetCompte.setNumAxe(this.numAxe);
            this.objetCompte.setLot("Dossier transit");
            this.objetCompte.setCode(this.rec_dossier);
            this.objetCompte.setNom_FR("");
            this.listeAxeCumul.add(this.objetCompte);
         } else if (this.structureLog.getStrDossier() == 2) {
            this.objetCompte = new ObjetCompte();
            this.objetCompte.setIndice(12);
            this.objetCompte.setNumAxe(this.numAxe);
            this.objetCompte.setLot("Affaire");
            this.objetCompte.setCode(this.rec_dossier);
            this.objetCompte.setNom_FR("");
            this.listeAxeCumul.add(this.objetCompte);
         }
      }

      if (this.plansAnalytiques != null && this.rec_dossier != null && !this.rec_dossier.isEmpty()) {
         this.objetCompte = new ObjetCompte();
         this.objetCompte.setIndice(12);
         this.objetCompte.setNumAxe(this.numAxe);
         this.objetCompte.setLot("Dossier");
         this.objetCompte.setCode(this.plansAnalytiques.getAnaCode());
         this.objetCompte.setNom_FR(this.plansAnalytiques.getAnaNomFr());
         this.listeAxeCumul.add(this.objetCompte);
      }

      if (this.lesChantiers.size() != 0) {
         for(var1 = 0; var1 < this.lesChantiers.size(); ++var1) {
            if (((PlansAnalytiques)this.lesChantiers.get(var1)).isSelect_analytique()) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setIndice(20);
               this.objetCompte.setNumAxe(this.numAxe);
               this.objetCompte.setLot("Chantier");
               this.objetCompte.setCode(((PlansAnalytiques)this.lesChantiers.get(var1)).getAnaCode());
               this.objetCompte.setNom_FR(((PlansAnalytiques)this.lesChantiers.get(var1)).getAnaNomFr());
               this.listeAxeCumul.add(this.objetCompte);
            }
         }
      }

      if (this.lesMissions.size() != 0) {
         for(var1 = 0; var1 < this.lesMissions.size(); ++var1) {
            if (((PlansAnalytiques)this.lesMissions.get(var1)).isSelect_analytique()) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setIndice(21);
               this.objetCompte.setNumAxe(this.numAxe);
               this.objetCompte.setLot("Mission");
               this.objetCompte.setCode(((PlansAnalytiques)this.lesMissions.get(var1)).getAnaCode());
               this.objetCompte.setNom_FR(((PlansAnalytiques)this.lesMissions.get(var1)).getAnaNomFr());
               this.listeAxeCumul.add(this.objetCompte);
            }
         }
      }

      if (this.lesAgents.size() != 0) {
         for(var1 = 0; var1 < this.lesAgents.size(); ++var1) {
            if (((Salaries)this.lesAgents.get(var1)).isSelect_agent()) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setIndice(13);
               this.objetCompte.setNumAxe(this.numAxe);
               this.objetCompte.setLot("Agent");
               this.objetCompte.setCode(((Salaries)this.lesAgents.get(var1)).getSalMatricule());
               this.objetCompte.setNom_FR(((Salaries)this.lesAgents.get(var1)).getPatronyme());
               this.listeAxeCumul.add(this.objetCompte);
            }
         }
      }

      if (this.lesColones1.size() != 0) {
         for(var1 = 0; var1 < this.lesColones1.size(); ++var1) {
            if (((Activites)this.lesColones1.get(var1)).isSelect_activite()) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setIndice(14);
               this.objetCompte.setNumAxe(this.numAxe);
               this.objetCompte.setLot(this.structureLog.getStrLib1());
               this.objetCompte.setCode(((Activites)this.lesColones1.get(var1)).getActCode());
               this.objetCompte.setNom_FR(((Activites)this.lesColones1.get(var1)).getActNomFr());
               this.listeAxeCumul.add(this.objetCompte);
            }
         }
      }

      if (this.lesColones2.size() != 0) {
         for(var1 = 0; var1 < this.lesColones2.size(); ++var1) {
            if (((Activites)this.lesColones2.get(var1)).isSelect_activite()) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setIndice(15);
               this.objetCompte.setNumAxe(this.numAxe);
               this.objetCompte.setLot(this.structureLog.getStrLib2());
               this.objetCompte.setCode(((Activites)this.lesColones2.get(var1)).getActCode());
               this.objetCompte.setNom_FR(((Activites)this.lesColones2.get(var1)).getActNomFr());
               this.listeAxeCumul.add(this.objetCompte);
            }
         }
      }

      if (this.lesColones3.size() != 0) {
         for(var1 = 0; var1 < this.lesColones3.size(); ++var1) {
            if (((Activites)this.lesColones3.get(var1)).isSelect_activite()) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setIndice(16);
               this.objetCompte.setNumAxe(this.numAxe);
               this.objetCompte.setLot(this.structureLog.getStrLib3());
               this.objetCompte.setCode(((Activites)this.lesColones3.get(var1)).getActCode());
               this.objetCompte.setNom_FR(((Activites)this.lesColones3.get(var1)).getActNomFr());
               this.listeAxeCumul.add(this.objetCompte);
            }
         }
      }

      if (this.lesClesStructures.size() != 0) {
         for(var1 = 0; var1 < this.lesClesStructures.size(); ++var1) {
            if (((PlansAnalytiques)this.lesClesStructures.get(var1)).isSelect_analytique()) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setIndice(17);
               this.objetCompte.setNumAxe(this.numAxe);
               this.objetCompte.setLot("ClesStructure");
               this.objetCompte.setCode(((PlansAnalytiques)this.lesClesStructures.get(var1)).getAnaCode());
               this.objetCompte.setNom_FR(((PlansAnalytiques)this.lesClesStructures.get(var1)).getAnaNomFr());
               this.listeAxeCumul.add(this.objetCompte);
            }
         }
      }

      if (this.lesAxesStructures.size() != 0) {
         for(var1 = 0; var1 < this.lesAxesStructures.size(); ++var1) {
            if (((PlansAnalytiques)this.lesAxesStructures.get(var1)).isSelect_analytique()) {
               this.objetCompte = new ObjetCompte();
               this.objetCompte.setIndice(18);
               this.objetCompte.setNumAxe(this.numAxe);
               this.objetCompte.setLot("AxesStructure");
               this.objetCompte.setCode(((PlansAnalytiques)this.lesAxesStructures.get(var1)).getAnaCode());
               this.objetCompte.setNom_FR(((PlansAnalytiques)this.lesAxesStructures.get(var1)).getAnaNomFr());
               this.listeAxeCumul.add(this.objetCompte);
            }
         }
      }

      this.dataModelAxeCumul.setWrappedData(this.listeAxeCumul);
      this.initVariable();
      this.var_nature_analytique = 0;
      ++this.numAxe;
   }

   public void chargerEcrituresLight() throws ParseException, HibernateException, NamingException {
      this.memoriseAxe();
      this.chargerEcritures((Session)null);
   }

   public void chargerEcritures() throws ParseException, HibernateException, NamingException {
      this.chargerEcritures((Session)null);
   }

   public void chargerEcritures(Session var1) throws ParseException, HibernateException, NamingException {
      if (this.inpCompte == null || this.inpCompte.isEmpty() || this.inpClasse != null && !this.inpClasse.isEmpty()) {
         if ((this.inpCompte == null || this.inpCompte.isEmpty()) && this.inpClasse != null && !this.inpClasse.isEmpty()) {
            this.periode = "PERIODE du " + this.utilDate.dateToStringFr(this.dateDebut) + " au " + this.utilDate.dateToStringFr(this.dateFin) + " Classe " + this.inpClasse;
         } else {
            this.periode = "PERIODE du " + this.utilDate.dateToStringFr(this.dateDebut) + " au " + this.utilDate.dateToStringFr(this.dateFin);
         }
      } else {
         this.periode = "PERIODE du " + this.utilDate.dateToStringFr(this.dateDebut) + " au " + this.utilDate.dateToStringFr(this.dateFin) + " Compte " + this.inpCompte;
      }

      this.lesEcrituresAnalytiques = new ArrayList();
      this.dataModelEcrituresAnalytiques = new ListDataModel();
      String var2 = this.utilDate.dateToStringSQLLight(this.dateDebut);
      Date var3 = this.utilDate.stringToDateSQLLight(var2);
      String var4 = this.utilDate.dateToStringSQLLight(this.dateFin);
      Date var5 = this.utilDate.stringToDateSQLLight(var4);
      this.liste_activite = false;
      this.liste_site = false;
      this.liste_departement = false;
      this.liste_service = false;
      this.liste_region = false;
      this.liste_secteur = false;
      this.liste_pdv = false;
      this.liste_sitePrdv = false;
      this.liste_ligne = false;
      this.liste_atelier = false;
      this.liste_anal1 = false;
      this.liste_anal2 = false;
      this.liste_anal3 = false;
      this.liste_clesStr = false;
      this.liste_axesStr = false;
      this.liste_agent = false;
      this.liste_parc = false;
      ArrayList var6 = new ArrayList();
      ArrayList var7 = new ArrayList();
      ArrayList var8 = new ArrayList();
      ArrayList var9 = new ArrayList();
      ArrayList var10 = new ArrayList();
      ArrayList var11 = new ArrayList();
      ArrayList var12 = new ArrayList();
      ArrayList var13 = new ArrayList();
      ArrayList var14 = new ArrayList();
      ArrayList var15 = new ArrayList();
      ArrayList var16 = new ArrayList();
      ArrayList var17 = new ArrayList();
      ArrayList var18 = new ArrayList();
      ArrayList var19 = new ArrayList();
      ArrayList var20 = new ArrayList();
      ArrayList var21 = new ArrayList();
      ArrayList var22 = new ArrayList();
      ArrayList var23 = new ArrayList();
      ArrayList var24 = new ArrayList();
      ArrayList var25 = new ArrayList();
      Object var26 = new ArrayList();
      Object var27 = new ArrayList();
      ArrayList var28 = new ArrayList();
      if (this.listeAxeCumul.size() != 0) {
         this.var_filtre_analytique = "";

         for(int var29 = 1; var29 < this.numAxe; ++var29) {
            var6.clear();
            var7.clear();
            var8.clear();
            var9.clear();
            var10.clear();
            var11.clear();
            var12.clear();
            var13.clear();
            var14.clear();
            var15.clear();
            var16.clear();
            var17.clear();
            var18.clear();
            var19.clear();
            var20.clear();
            var21.clear();
            var24.clear();
            var25.clear();
            var22.clear();
            var23.clear();
            var28.clear();

            int var30;
            for(var30 = 0; var30 < this.listeAxeCumul.size(); ++var30) {
               if (((ObjetCompte)this.listeAxeCumul.get(var30)).getNumAxe() == var29) {
                  if (((ObjetCompte)this.listeAxeCumul.get(var30)).getIndice() == 1) {
                     var6.add(((ObjetCompte)this.listeAxeCumul.get(var30)).getCode());
                     this.liste_activite = true;
                  } else if (((ObjetCompte)this.listeAxeCumul.get(var30)).getIndice() == 2) {
                     var10.add(((ObjetCompte)this.listeAxeCumul.get(var30)).getCode());
                     this.liste_site = true;
                  } else if (((ObjetCompte)this.listeAxeCumul.get(var30)).getIndice() == 3) {
                     var11.add(((ObjetCompte)this.listeAxeCumul.get(var30)).getCode());
                     this.liste_departement = true;
                  } else if (((ObjetCompte)this.listeAxeCumul.get(var30)).getIndice() == 4) {
                     var12.add(((ObjetCompte)this.listeAxeCumul.get(var30)).getCode());
                     this.liste_service = true;
                  } else if (((ObjetCompte)this.listeAxeCumul.get(var30)).getIndice() == 5) {
                     var13.add(((ObjetCompte)this.listeAxeCumul.get(var30)).getCode());
                     this.liste_region = true;
                  } else if (((ObjetCompte)this.listeAxeCumul.get(var30)).getIndice() == 6) {
                     var14.add(((ObjetCompte)this.listeAxeCumul.get(var30)).getCode());
                     this.liste_secteur = true;
                  } else if (((ObjetCompte)this.listeAxeCumul.get(var30)).getIndice() == 7) {
                     var15.add(((ObjetCompte)this.listeAxeCumul.get(var30)).getCode());
                     this.liste_pdv = true;
                  } else if (((ObjetCompte)this.listeAxeCumul.get(var30)).getIndice() == 8) {
                     var16.add(((ObjetCompte)this.listeAxeCumul.get(var30)).getCode());
                     this.liste_sitePrdv = true;
                  } else if (((ObjetCompte)this.listeAxeCumul.get(var30)).getIndice() == 9) {
                     var17.add(((ObjetCompte)this.listeAxeCumul.get(var30)).getCode());
                     this.liste_ligne = true;
                  } else if (((ObjetCompte)this.listeAxeCumul.get(var30)).getIndice() == 10) {
                     var18.add(((ObjetCompte)this.listeAxeCumul.get(var30)).getCode());
                     this.liste_atelier = true;
                  } else if (((ObjetCompte)this.listeAxeCumul.get(var30)).getIndice() == 11) {
                     var20.add(((ObjetCompte)this.listeAxeCumul.get(var30)).getCode());
                     this.liste_parc = true;
                  } else if (((ObjetCompte)this.listeAxeCumul.get(var30)).getIndice() == 12) {
                     var19.add(((ObjetCompte)this.listeAxeCumul.get(var30)).getCode());
                     this.liste_dossier = true;
                  } else if (((ObjetCompte)this.listeAxeCumul.get(var30)).getIndice() == 13) {
                     var21.add(((ObjetCompte)this.listeAxeCumul.get(var30)).getCode());
                     this.liste_agent = true;
                  } else if (((ObjetCompte)this.listeAxeCumul.get(var30)).getIndice() == 14) {
                     var7.add(((ObjetCompte)this.listeAxeCumul.get(var30)).getCode());
                     this.liste_anal1 = true;
                  } else if (((ObjetCompte)this.listeAxeCumul.get(var30)).getIndice() == 15) {
                     var8.add(((ObjetCompte)this.listeAxeCumul.get(var30)).getCode());
                     this.liste_anal2 = true;
                  } else if (((ObjetCompte)this.listeAxeCumul.get(var30)).getIndice() == 16) {
                     var9.add(((ObjetCompte)this.listeAxeCumul.get(var30)).getCode());
                     this.liste_anal3 = true;
                  } else if (((ObjetCompte)this.listeAxeCumul.get(var30)).getIndice() == 17) {
                     var24.add(((ObjetCompte)this.listeAxeCumul.get(var30)).getCode());
                     this.liste_clesStr = true;
                  } else if (((ObjetCompte)this.listeAxeCumul.get(var30)).getIndice() == 18) {
                     var25.add(((ObjetCompte)this.listeAxeCumul.get(var30)).getCode());
                     this.liste_axesStr = true;
                  } else if (((ObjetCompte)this.listeAxeCumul.get(var30)).getIndice() == 20) {
                     var22.add(((ObjetCompte)this.listeAxeCumul.get(var30)).getCode());
                     this.liste_anal1 = true;
                  } else if (((ObjetCompte)this.listeAxeCumul.get(var30)).getIndice() == 21) {
                     var23.add(((ObjetCompte)this.listeAxeCumul.get(var30)).getCode());
                     this.liste_anal3 = true;
                  }
               }

               if (var29 == 1) {
                  this.var_filtre_analytique = this.var_filtre_analytique + ((ObjetCompte)this.listeAxeCumul.get(var30)).getCode() + ", ";
               }
            }

            if (var29 == 1 && this.structureLog.getStrDossier() == 3 && var19.size() != 0) {
               new ArrayList();
               EcrituresDao var34 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
               List var33 = var34.recherche(var1, this.selectedExo.getExecpt_id(), var3, var5, this.situationRech, this.reserveRech, var19, this.inpCompte, this.inpClasse);
               if (var33.size() != 0) {
                  for(int var32 = 0; var32 < var33.size(); ++var32) {
                     this.ecritures = (Ecritures)var33.get(var32);
                     this.ecrituresAnalytique = new EcrituresAnalytique();
                     this.ecrituresAnalytique.setEcranaCompte(this.ecritures.getEcrCompte());
                     this.ecrituresAnalytique.setEcranaClasse(this.ecritures.getEcrClasse());
                     this.ecrituresAnalytique.setEcranaNature(this.ecritures.getEcrNature());
                     this.ecrituresAnalytique.setEcranaNatureJrx(this.ecritures.getEcrNatureJrx());
                     this.ecrituresAnalytique.setEcranaCode(this.ecritures.getEcrCode());
                     this.ecrituresAnalytique.setEcranaPiece(this.ecritures.getEcrPiece());
                     this.ecrituresAnalytique.setEcranaReference1(this.ecritures.getEcrReference1());
                     this.ecrituresAnalytique.setEcranaReference2(this.ecritures.getEcrReference2());
                     this.ecrituresAnalytique.setEcranaDateSaisie(this.ecritures.getEcrDateSaisie());
                     this.ecrituresAnalytique.setEcranaAnal4(this.ecritures.getEcrDossier());
                     this.ecrituresAnalytique.setEcranaAnal4Lib(this.ecritures.getEcrDossier());
                     this.ecrituresAnalytique.setEcranaLibelle(this.ecritures.getEcrLibelle());
                     this.ecrituresAnalytique.setEcranaAxe(9);
                     if (this.ecritures.getEcrDebitSaisie() != 0.0D && this.ecritures.getEcrCreditSaisie() == 0.0D) {
                        this.ecrituresAnalytique.setEcranaSens(0);
                        this.ecrituresAnalytique.setEcranaMontantSaisie(this.ecritures.getEcrDebitSaisie());
                     } else {
                        this.ecrituresAnalytique.setEcranaSens(1);
                        this.ecrituresAnalytique.setEcranaMontantSaisie(this.ecritures.getEcrCreditSaisie());
                     }

                     ((List)var26).add(this.ecrituresAnalytique);
                  }

                  var27 = var26;
                  this.lesEcrituresAnalytiques = (List)var26;
                  this.dataModelEcrituresAnalytiques.setWrappedData(this.lesEcrituresAnalytiques);
               }
            } else {
               var26 = this.ecrituresAnalytiquesDao.recherche(var1, this.selectedExo.getExecpt_id(), var3, var5, this.situationRech, this.reserveRech, this.decoupageActivite, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, this.inpCompte, this.inpClasse, var24, var25, var22, var23);
               if (((List)var26).size() != 0) {
                  if (var29 == 1) {
                     var27 = var26;
                     this.lesEcrituresAnalytiques = (List)var26;
                     this.dataModelEcrituresAnalytiques.setWrappedData(this.lesEcrituresAnalytiques);
                  } else {
                     for(var30 = 0; var30 < ((List)var26).size(); ++var30) {
                        this.ecrituresAnalytique = (EcrituresAnalytique)((List)var26).get(var30);
                        if (((List)var27).size() != 0) {
                           for(int var31 = 0; var31 < ((List)var27).size(); ++var31) {
                              if (((EcrituresAnalytique)((List)var27).get(var31)).getEcritures().getEcr_id() == this.ecrituresAnalytique.getEcritures().getEcr_id()) {
                                 var28.add(this.ecrituresAnalytique);
                                 break;
                              }
                           }
                        }
                     }

                     var27 = var28;
                     this.lesEcrituresAnalytiques = var28;
                     this.dataModelEcrituresAnalytiques.setWrappedData(this.lesEcrituresAnalytiques);
                  }
               }
            }
         }
      }

      this.showModalFind = false;
      this.showModalFindLight = false;
      this.calculerTotaux();
      this.var_affiche_bouton = false;
   }

   public void calculerTotaux() {
      this.var_total_debit = 0.0D;
      this.var_total_credit = 0.0D;
      this.var_solde_debit = 0.0D;
      this.var_solde_credit = 0.0D;
      this.var_total_select_debit = 0.0D;
      this.var_total_select_credit = 0.0D;
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      this.testdeliste = true;
      if (this.lesEcrituresAnalytiques.size() != 0) {
         this.testdeliste = false;
         new EcrituresAnalytique();

         for(int var10 = 0; var10 < this.lesEcrituresAnalytiques.size(); ++var10) {
            EcrituresAnalytique var9 = (EcrituresAnalytique)this.lesEcrituresAnalytiques.get(var10);
            if (var9.isSel_ecriture()) {
               var5 += var9.getValDebit();
               var7 += var9.getValCredit();
            }

            var1 += var9.getValDebit();
            var3 += var9.getValCredit();
         }
      }

      this.var_total_debit = var1;
      this.var_total_credit = var3;
      if (this.var_total_debit > this.var_total_credit) {
         this.var_solde_debit = var1 - var3;
      } else {
         this.var_solde_credit = var3 - var1;
      }

      this.var_total_select_debit = var5;
      this.var_total_select_credit = var7;
   }

   public void toutDeSelectionner() {
      if (this.lesEcrituresAnalytiques.size() != 0) {
         new EcrituresAnalytique();

         for(int var2 = 0; var2 < this.lesEcrituresAnalytiques.size(); ++var2) {
            EcrituresAnalytique var1 = (EcrituresAnalytique)this.lesEcrituresAnalytiques.get(var2);
            var1.setSel_ecriture(false);
         }

         this.dataModelEcrituresAnalytiques.setWrappedData(this.lesEcrituresAnalytiques);
         this.calculTotalSelectionCochee();
      }

   }

   public void toutSelectionner() {
      if (this.lesEcrituresAnalytiques.size() != 0) {
         new EcrituresAnalytique();

         for(int var2 = 0; var2 < this.lesEcrituresAnalytiques.size(); ++var2) {
            EcrituresAnalytique var1 = (EcrituresAnalytique)this.lesEcrituresAnalytiques.get(var2);
            var1.setSel_ecriture(true);
         }

         this.dataModelEcrituresAnalytiques.setWrappedData(this.lesEcrituresAnalytiques);
         this.calculTotalSelectionCochee();
      }

   }

   public void selectionEcriture() {
      if (this.dataModelEcrituresAnalytiques.isRowAvailable()) {
         this.ecrituresAnalytique = (EcrituresAnalytique)this.dataModelEcrituresAnalytiques.getRowData();
         this.ecrituresAnalytiqueMemo = (EcrituresAnalytique)this.dataModelEcrituresAnalytiques.getRowData();
         this.ecritures = this.ecrituresAnalytiqueMemo.getEcritures();
         this.var_affiche_bouton = true;
      }

   }

   public void calculTotalSelectionCochee() {
      this.var_total_select_debit = 0.0D;
      this.var_total_select_credit = 0.0D;
      if (this.lesEcrituresAnalytiques.size() != 0) {
         new EcrituresAnalytique();

         for(int var2 = 0; var2 < this.lesEcrituresAnalytiques.size(); ++var2) {
            EcrituresAnalytique var1 = (EcrituresAnalytique)this.lesEcrituresAnalytiques.get(var2);
            if (var1.isSel_ecriture()) {
               this.var_total_select_debit += var1.getValDebit();
               this.var_total_select_credit += var1.getValCredit();
            }
         }
      }

   }

   public void gestionAnalytique() throws ParseException, HibernateException, NamingException {
      if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
         this.decoupageActivite = true;
      } else {
         this.decoupageActivite = false;
      }

      if (this.ecrituresAnalytiqueMemo != null) {
         this.ecrituresAnalytique = new EcrituresAnalytique();
         this.var_memo_ligne_gene = this.ecrituresAnalytiqueMemo.getEcranaId();
         this.ecritures = this.ecrituresAnalytiqueMemo.getEcritures();
         if (this.ecritures != null) {
            if (this.ecrituresAnalytiqueMemo.getEcritures().getEcrDebitSaisie() != 0.0D && this.ecrituresAnalytiqueMemo.getEcritures().getEcrCreditSaisie() == 0.0D) {
               this.var_sens_analytique = false;
               this.var_montant_ligne = Math.abs(this.ecrituresAnalytiqueMemo.getEcritures().getEcrDebitSaisie());
            } else {
               this.var_sens_analytique = true;
               this.var_montant_ligne = Math.abs(this.ecrituresAnalytiqueMemo.getEcritures().getEcrCreditSaisie());
            }

            if (this.optionComptabilite.getAnalytique().equals("true") && this.ecrituresAnalytiqueMemo.getEcritures().getEcrEtat() == 0) {
               boolean var1 = this.testCompteAnalytique(this.ecritures);
               if (var1) {
                  boolean var2 = this.ecrituresAnalytiquesDao.exsitLesEcrituresAnalytiques(this.ecritures, (Session)null);
                  if (var2) {
                     this.ouvrirDetailsAnalytique();
                     this.var_consult_analytique = true;
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
                     this.affiche_clesStr = false;
                     this.affiche_axesStr = false;
                     this.listeOngletAnalytique.clear();
                     this.mesOngletsAnalytiqueItems.clear();
                     this.listeRepartitionAnal.clear();
                     this.dataModelDetAnalytique.setWrappedData(this.listeRepartitionAnal);
                  }
               }
            }

            this.var_memo_action = this.var_action;
            this.var_action = 17;
         }
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
         this.affiche_clesStr = false;
         this.affiche_axesStr = false;
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
                           var14.setEcranaStr(var12.getEcranaStr());
                           var14.setEcranaStrLib(var12.getEcranaStrLib());
                           var15.add(var14);
                        }
                     }

                     this.objetTable.setListEcrituresAnalytiqueCtrl(var15);
                     this.listeOngletAnalytique.add(this.objetTable);
                  }

                  ++var7;
               }
            } else if (((EcrituresAnalytique)var3.get(0)).getEcranaAxe() != 0 && (((EcrituresAnalytique)var3.get(0)).getEcranaCle() == null || ((EcrituresAnalytique)var3.get(0)).getEcranaCle().isEmpty())) {
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
                  if (var8 != var4) {
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
                        if (var4 == var12.getEcranaAxe()) {
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
                           var14.setEcranaStr(var12.getEcranaStr());
                           var14.setEcranaStrLib(var12.getEcranaStrLib());
                           var15.add(var14);
                        }
                     }

                     this.objetTable.setListEcrituresAnalytiqueCtrl(var15);
                     this.listeOngletAnalytique.add(this.objetTable);
                  }

                  ++var7;
               }
            } else {
               this.dataModelDetAnalytique.setWrappedData(var3);
               var1 = 2;
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
                     this.ecrituresAnalytique.setEcranaStr(var3.getEcranaStr());
                     this.ecrituresAnalytique.setEcranaStrLib(var3.getEcranaStrLib());
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
      } else if (var1 == 110) {
         var2 = "Activités";
      } else if (var1 == 120) {
         var2 = "Parcs";
      } else if (var1 == 121) {
         var2 = "Dossiers";
      } else if (var1 == 122) {
         var2 = "Agents";
      } else if (var1 == 200) {
         var2 = "Clés Structure";
      } else if (var1 == 201) {
         var2 = "Axes Structure";
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
         String var15 = "";
         String var16 = "";

         for(int var17 = 0; var17 < this.listeRepartitionAnal.size(); ++var17) {
            this.ecrituresAnalytique = (EcrituresAnalytique)this.listeRepartitionAnal.get(var17);
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

            if (this.affiche_clesStr) {
               if (this.ecrituresAnalytique.getEcranaStrCle() != null && !this.ecrituresAnalytique.getEcranaStrCle().isEmpty() && !var15.equals(this.ecrituresAnalytique.getEcranaStrCle())) {
                  var15 = this.ecrituresAnalytique.getEcranaStrCle();
               } else {
                  var15 = "";
               }
            }

            if (this.affiche_axesStr) {
               if (this.ecrituresAnalytique.getEcranaStr() != null && !this.ecrituresAnalytique.getEcranaStr().isEmpty() && !var15.equals(this.ecrituresAnalytique.getEcranaStr())) {
                  var16 = this.ecrituresAnalytique.getEcranaStr();
               } else {
                  var16 = "";
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
      this.affiche_clesStr = false;
      this.affiche_axesStr = false;
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
      } else if (this.ecrituresAnalytique.getEcranaAxe() == 110) {
         if (this.decoupageActivite) {
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
      } else if (this.ecrituresAnalytique.getEcranaAxe() == 200) {
         this.affiche_clesStr = true;
      } else if (this.ecrituresAnalytique.getEcranaAxe() == 201) {
         this.affiche_axesStr = true;
      }

   }

   public void fermerDetailsAnalytique() {
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
      this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      List var1 = this.plansAnalytiquesDao.selectAnal("8", this.ecrituresAnalytique.getEcranaAnal2(), "", this.nature, (Session)null);
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
      this.activitesDao = new ActivitesDao(this.baseLog, this.utilInitHibernate);
      List var1 = this.activitesDao.selectActivites((Session)null);
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
      this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      List var1 = this.plansAnalytiquesDao.selectAnal("6", this.ecrituresAnalytique.getEcranaAnal4(), this.ecritures.getEcrAnnee(), this.nature, (Session)null);
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
         this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
         var1 = this.salariesDao.chargerlesSalariesActif(this.ecrituresAnalytique.getEcranaAnal3(), (Session)null);
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
      String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_ana" + File.separator + "extrait";
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
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_ana" + File.separator + "extrait" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
         var1.setEntete("Extrait analytique ");
         SimpleDateFormat var11 = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);
         String var12 = var11.format(this.dateDebut);
         String var13 = var11.format(this.dateFin);
         var1.setFiltre(" du " + var12 + " au " + var13 + "  " + this.var_filtre_analytique);
         var1.setRequete("");
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataireCC(var8);
         var1.setDestinataireCCI(var9);
         var1.setCorpsMail(var10);
         var1.setTiersSelectionne((Tiers)null);
         ArrayList var14 = new ArrayList();
         if (this.lesEcrituresAnalytiques.size() != 0) {
            boolean var15 = false;

            int var16;
            for(var16 = 0; var16 < this.lesEcrituresAnalytiques.size(); ++var16) {
               if (((EcrituresAnalytique)this.lesEcrituresAnalytiques.get(var16)).isSel_ecriture()) {
                  var15 = true;
                  break;
               }
            }

            if (var15) {
               for(var16 = 0; var16 < this.lesEcrituresAnalytiques.size(); ++var16) {
                  if (((EcrituresAnalytique)this.lesEcrituresAnalytiques.get(var16)).isSel_ecriture()) {
                     this.ecrituresAnalytique = new EcrituresAnalytique();
                     this.ecrituresAnalytique = (EcrituresAnalytique)this.lesEcrituresAnalytiques.get(var16);
                     var14.add(this.ecrituresAnalytique);
                  }
               }
            } else {
               for(var16 = 0; var16 < this.lesEcrituresAnalytiques.size(); ++var16) {
                  this.ecrituresAnalytique = new EcrituresAnalytique();
                  this.ecrituresAnalytique = (EcrituresAnalytique)this.lesEcrituresAnalytiques.get(var16);
                  var14.add(this.ecrituresAnalytique);
               }
            }
         }

         JRBeanCollectionDataSource var17 = new JRBeanCollectionDataSource(var14);
         var1.setjRBeanCollectionDataSource(var17);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

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
      if (this.lesEcrituresAnalytiques.size() != 0) {
         if (this.valQteGraph == 0) {
            this.uniteGraph = "ANALYTIQUE en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         }

         this.titreGraph = "Analyse de l'axe : " + this.var_filtre_analytique;
         String var2 = this.utilDate.dateToStringFr(this.dateDebut);
         String var3 = this.utilDate.dateToStringFr(this.dateFin);
         this.titreGraph = this.titreGraph + " Du " + var2 + " au " + var3;
         this.sousTitreGraph = "";
         if (this.modeGraph == 0) {
            this.sousTitreGraph = this.sousTitreGraph + " - En Global (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 1) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par compte (" + this.uniteGraph + ")";
         }

         new EcrituresAnalytique();
         if (this.valQteGraph != 1 && this.modeGraph != 5 && this.modeGraph != 6 && this.lesEcrituresAnalytiques.size() != 0) {
            String var5 = "";
            long var6 = 0L;
            boolean var8 = false;

            for(int var9 = 0; var9 < this.lesEcrituresAnalytiques.size(); ++var9) {
               EcrituresAnalytique var4 = (EcrituresAnalytique)this.lesEcrituresAnalytiques.get(var9);
               var5 = "";
               var6 = 0L;
               int var11 = 0;
               if (this.modeGraph == 0) {
                  int var10 = var4.getEcritures().getEcrDateSaisie().getYear() + 1900;
                  var5 = "" + var10;
               } else if (this.modeGraph == 1) {
                  var5 = var4.getEcranaCompte();
               }

               var6 = (long)var4.getEcranaMontantSaisie();
               if (this.timeDecoupage == 0) {
                  var11 = var4.getEcritures().getEcrDateSaisie().getDate();
               } else if (this.timeDecoupage == 1) {
                  var11 = var4.getEcritures().getEcrDateSaisie().getMonth() + 1;
               } else if (this.timeDecoupage == 2) {
                  if (var4.getEcritures().getEcrDateSaisie().getMonth() + 1 >= 1 && var4.getEcritures().getEcrDateSaisie().getMonth() + 1 <= 3) {
                     var11 = 1;
                  } else if (var4.getEcritures().getEcrDateSaisie().getMonth() + 1 >= 4 && var4.getEcritures().getEcrDateSaisie().getMonth() + 1 <= 6) {
                     var11 = 2;
                  } else if (var4.getEcritures().getEcrDateSaisie().getMonth() + 1 >= 7 && var4.getEcritures().getEcrDateSaisie().getMonth() + 1 <= 9) {
                     var11 = 3;
                  } else if (var4.getEcritures().getEcrDateSaisie().getMonth() + 1 >= 10 && var4.getEcritures().getEcrDateSaisie().getMonth() + 1 <= 12) {
                     var11 = 4;
                  }
               } else if (this.timeDecoupage == 3) {
                  if (var4.getEcritures().getEcrDateSaisie().getMonth() + 1 >= 1 && var4.getEcritures().getEcrDateSaisie().getMonth() + 1 <= 6) {
                     var11 = 1;
                  } else if (var4.getEcritures().getEcrDateSaisie().getMonth() + 1 >= 7 && var4.getEcritures().getEcrDateSaisie().getMonth() + 1 <= 12) {
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
            var8.setV12(var8.getV13() + var4);
         } else if (var3 == 14) {
            var8.setV12(var8.getV14() + var4);
         } else if (var3 == 15) {
            var8.setV12(var8.getV15() + var4);
         } else if (var3 == 16) {
            var8.setV12(var8.getV16() + var4);
         } else if (var3 == 17) {
            var8.setV12(var8.getV17() + var4);
         } else if (var3 == 18) {
            var8.setV12(var8.getV18() + var4);
         } else if (var3 == 19) {
            var8.setV12(var8.getV19() + var4);
         } else if (var3 == 20) {
            var8.setV12(var8.getV20() + var4);
         } else if (var3 == 21) {
            var8.setV12(var8.getV21() + var4);
         } else if (var3 == 22) {
            var8.setV12(var8.getV22() + var4);
         } else if (var3 == 23) {
            var8.setV12(var8.getV23() + var4);
         } else if (var3 == 24) {
            var8.setV12(var8.getV24() + var4);
         } else if (var3 == 25) {
            var8.setV12(var8.getV25() + var4);
         } else if (var3 == 26) {
            var8.setV12(var8.getV26() + var4);
         } else if (var3 == 27) {
            var8.setV12(var8.getV27() + var4);
         } else if (var3 == 28) {
            var8.setV12(var8.getV28() + var4);
         } else if (var3 == 29) {
            var8.setV12(var8.getV29() + var4);
         } else if (var3 == 30) {
            var8.setV12(var8.getV30() + var4);
         } else if (var3 == 31) {
            var8.setV12(var8.getV31() + var4);
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

   public DataModel getDataModelEcrituresAnalytiques() {
      return this.dataModelEcrituresAnalytiques;
   }

   public void setDataModelEcrituresAnalytiques(DataModel var1) {
      this.dataModelEcrituresAnalytiques = var1;
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

   public EcrituresAnalytique getEcrituresAnalytique() {
      return this.ecrituresAnalytique;
   }

   public void setEcrituresAnalytique(EcrituresAnalytique var1) {
      this.ecrituresAnalytique = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
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

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public boolean isShowModalFind() {
      return this.showModalFind;
   }

   public void setShowModalFind(boolean var1) {
      this.showModalFind = var1;
   }

   public boolean isShowModalFindLight() {
      return this.showModalFindLight;
   }

   public void setShowModalFindLight(boolean var1) {
      this.showModalFindLight = var1;
   }

   public double getVar_solde_credit() {
      return this.var_solde_credit;
   }

   public void setVar_solde_credit(double var1) {
      this.var_solde_credit = var1;
   }

   public double getVar_solde_debit() {
      return this.var_solde_debit;
   }

   public void setVar_solde_debit(double var1) {
      this.var_solde_debit = var1;
   }

   public double getVar_total_credit() {
      return this.var_total_credit;
   }

   public void setVar_total_credit(double var1) {
      this.var_total_credit = var1;
   }

   public double getVar_total_debit() {
      return this.var_total_debit;
   }

   public void setVar_total_debit(double var1) {
      this.var_total_debit = var1;
   }

   public double getVar_total_select_credit() {
      return this.var_total_select_credit;
   }

   public void setVar_total_select_credit(double var1) {
      this.var_total_select_credit = var1;
   }

   public double getVar_total_select_debit() {
      return this.var_total_select_debit;
   }

   public void setVar_total_select_debit(double var1) {
      this.var_total_select_debit = var1;
   }

   public List getLesModelsimpression() {
      return this.lesModelsimpression;
   }

   public void setLesModelsimpression(List var1) {
      this.lesModelsimpression = var1;
   }

   public int getVar_nature_analytique() {
      return this.var_nature_analytique;
   }

   public void setVar_nature_analytique(int var1) {
      this.var_nature_analytique = var1;
   }

   public Activites getActivites() {
      return this.activites;
   }

   public void setActivites(Activites var1) {
      this.activites = var1;
   }

   public ActivitesDao getActivitesDao() {
      return this.activitesDao;
   }

   public void setActivitesDao(ActivitesDao var1) {
      this.activitesDao = var1;
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

   public List getLesActivites() {
      return this.lesActivites;
   }

   public void setLesActivites(List var1) {
      this.lesActivites = var1;
   }

   public List getLesAgents() {
      return this.lesAgents;
   }

   public void setLesAgents(List var1) {
      this.lesAgents = var1;
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

   public boolean isMode_calcul() {
      return this.mode_calcul;
   }

   public void setMode_calcul(boolean var1) {
      this.mode_calcul = var1;
   }

   public int getVar_axe() {
      return this.var_axe;
   }

   public void setVar_axe(int var1) {
      this.var_axe = var1;
   }

   public String getVar_filtre_analytique() {
      return this.var_filtre_analytique;
   }

   public void setVar_filtre_analytique(String var1) {
      this.var_filtre_analytique = var1;
   }

   public int getVar_nb_max() {
      return this.var_nb_max;
   }

   public void setVar_nb_max(int var1) {
      this.var_nb_max = var1;
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

   public String getRec_dossier() {
      return this.rec_dossier;
   }

   public void setRec_dossier(String var1) {
      this.rec_dossier = var1;
   }

   public String getInpCompte() {
      return this.inpCompte;
   }

   public void setInpCompte(String var1) {
      this.inpCompte = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public List getLesColones1() {
      return this.lesColones1;
   }

   public void setLesColones1(List var1) {
      this.lesColones1 = var1;
   }

   public List getLesColones2() {
      return this.lesColones2;
   }

   public void setLesColones2(List var1) {
      this.lesColones2 = var1;
   }

   public List getLesColones3() {
      return this.lesColones3;
   }

   public void setLesColones3(List var1) {
      this.lesColones3 = var1;
   }

   public boolean isDecoupageActivite() {
      return this.decoupageActivite;
   }

   public void setDecoupageActivite(boolean var1) {
      this.decoupageActivite = var1;
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

   public String getDeviseGraph() {
      return this.deviseGraph;
   }

   public void setDeviseGraph(String var1) {
      this.deviseGraph = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public String getInpClasse() {
      return this.inpClasse;
   }

   public void setInpClasse(String var1) {
      this.inpClasse = var1;
   }

   public boolean isTestdeliste() {
      return this.testdeliste;
   }

   public void setTestdeliste(boolean var1) {
      this.testdeliste = var1;
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

   public boolean isVar_affiche_saisie_anal() {
      return this.var_affiche_saisie_anal;
   }

   public void setVar_affiche_saisie_anal(boolean var1) {
      this.var_affiche_saisie_anal = var1;
   }

   public String getVar_cle_analytique() {
      return this.var_cle_analytique;
   }

   public void setVar_cle_analytique(String var1) {
      this.var_cle_analytique = var1;
   }

   public boolean isVar_consult_analytique() {
      return this.var_consult_analytique;
   }

   public void setVar_consult_analytique(boolean var1) {
      this.var_consult_analytique = var1;
   }

   public double getVar_ecart() {
      return this.var_ecart;
   }

   public void setVar_ecart(double var1) {
      this.var_ecart = var1;
   }

   public boolean isVar_sens_analytique() {
      return this.var_sens_analytique;
   }

   public void setVar_sens_analytique(boolean var1) {
      this.var_sens_analytique = var1;
   }

   public boolean isVar_valide_analytique() {
      return this.var_valide_analytique;
   }

   public void setVar_valide_analytique(boolean var1) {
      this.var_valide_analytique = var1;
   }

   public double getVar_montant_impute() {
      return this.var_montant_impute;
   }

   public void setVar_montant_impute(double var1) {
      this.var_montant_impute = var1;
   }

   public double getVar_montant_ligne() {
      return this.var_montant_ligne;
   }

   public void setVar_montant_ligne(double var1) {
      this.var_montant_ligne = var1;
   }

   public Ecritures getEcritures() {
      return this.ecritures;
   }

   public void setEcritures(Ecritures var1) {
      this.ecritures = var1;
   }

   public EcrituresAnalytique getEcrituresAnalytiqueMemo() {
      return this.ecrituresAnalytiqueMemo;
   }

   public void setEcrituresAnalytiqueMemo(EcrituresAnalytique var1) {
      this.ecrituresAnalytiqueMemo = var1;
   }

   public DataModel getDataModelAxeCumul() {
      return this.dataModelAxeCumul;
   }

   public void setDataModelAxeCumul(DataModel var1) {
      this.dataModelAxeCumul = var1;
   }

   public boolean isAffiche_axesStr() {
      return this.affiche_axesStr;
   }

   public void setAffiche_axesStr(boolean var1) {
      this.affiche_axesStr = var1;
   }

   public boolean isAffiche_clesStr() {
      return this.affiche_clesStr;
   }

   public void setAffiche_clesStr(boolean var1) {
      this.affiche_clesStr = var1;
   }

   public List getLesAxesStructures() {
      return this.lesAxesStructures;
   }

   public void setLesAxesStructures(List var1) {
      this.lesAxesStructures = var1;
   }

   public List getLesClesStructures() {
      return this.lesClesStructures;
   }

   public void setLesClesStructures(List var1) {
      this.lesClesStructures = var1;
   }

   public boolean isListe_activite() {
      return this.liste_activite;
   }

   public void setListe_activite(boolean var1) {
      this.liste_activite = var1;
   }

   public boolean isListe_atelier() {
      return this.liste_atelier;
   }

   public void setListe_atelier(boolean var1) {
      this.liste_atelier = var1;
   }

   public boolean isListe_departement() {
      return this.liste_departement;
   }

   public void setListe_departement(boolean var1) {
      this.liste_departement = var1;
   }

   public boolean isListe_dossier() {
      return this.liste_dossier;
   }

   public void setListe_dossier(boolean var1) {
      this.liste_dossier = var1;
   }

   public boolean isListe_ligne() {
      return this.liste_ligne;
   }

   public void setListe_ligne(boolean var1) {
      this.liste_ligne = var1;
   }

   public boolean isListe_pdv() {
      return this.liste_pdv;
   }

   public void setListe_pdv(boolean var1) {
      this.liste_pdv = var1;
   }

   public boolean isListe_region() {
      return this.liste_region;
   }

   public void setListe_region(boolean var1) {
      this.liste_region = var1;
   }

   public boolean isListe_secteur() {
      return this.liste_secteur;
   }

   public void setListe_secteur(boolean var1) {
      this.liste_secteur = var1;
   }

   public boolean isListe_service() {
      return this.liste_service;
   }

   public void setListe_service(boolean var1) {
      this.liste_service = var1;
   }

   public boolean isListe_site() {
      return this.liste_site;
   }

   public void setListe_site(boolean var1) {
      this.liste_site = var1;
   }

   public boolean isListe_sitePrdv() {
      return this.liste_sitePrdv;
   }

   public void setListe_sitePrdv(boolean var1) {
      this.liste_sitePrdv = var1;
   }

   public boolean isListe_anal1() {
      return this.liste_anal1;
   }

   public void setListe_anal1(boolean var1) {
      this.liste_anal1 = var1;
   }

   public boolean isListe_anal2() {
      return this.liste_anal2;
   }

   public void setListe_anal2(boolean var1) {
      this.liste_anal2 = var1;
   }

   public boolean isListe_anal3() {
      return this.liste_anal3;
   }

   public void setListe_anal3(boolean var1) {
      this.liste_anal3 = var1;
   }

   public boolean isListe_agent() {
      return this.liste_agent;
   }

   public void setListe_agent(boolean var1) {
      this.liste_agent = var1;
   }

   public boolean isListe_parc() {
      return this.liste_parc;
   }

   public void setListe_parc(boolean var1) {
      this.liste_parc = var1;
   }

   public boolean isListe_axesStr() {
      return this.liste_axesStr;
   }

   public void setListe_axesStr(boolean var1) {
      this.liste_axesStr = var1;
   }

   public boolean isListe_clesStr() {
      return this.liste_clesStr;
   }

   public void setListe_clesStr(boolean var1) {
      this.liste_clesStr = var1;
   }

   public List getMesOngletsAnalytiqueItems() {
      return this.mesOngletsAnalytiqueItems;
   }

   public void setMesOngletsAnalytiqueItems(List var1) {
      this.mesOngletsAnalytiqueItems = var1;
   }

   public DataModel getDataModelChantier() {
      return this.dataModelChantier;
   }

   public void setDataModelChantier(DataModel var1) {
      this.dataModelChantier = var1;
   }

   public DataModel getDataModelMissison() {
      return this.dataModelMissison;
   }

   public void setDataModelMissison(DataModel var1) {
      this.dataModelMissison = var1;
   }

   public List getMesAxesAnalytique() {
      return this.mesAxesAnalytique;
   }

   public void setMesAxesAnalytique(List var1) {
      this.mesAxesAnalytique = var1;
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

   public List getLesModelesAutorises() {
      return this.lesModelesAutorises;
   }

   public void setLesModelesAutorises(List var1) {
      this.lesModelesAutorises = var1;
   }

   public String getRec_activite() {
      return this.rec_activite;
   }

   public void setRec_activite(String var1) {
      this.rec_activite = var1;
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
