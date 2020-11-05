package com.epegase.forms.comptabilite;

import com.epegase.systeme.classe.BudgetLigne;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresAnalytique;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.PlanBudgetaireCompte;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.PlansBudgetaires;
import com.epegase.systeme.classe.PointDeVente;
import com.epegase.systeme.classe.Region;
import com.epegase.systeme.classe.Secteur;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.dao.ActivitesDao;
import com.epegase.systeme.dao.BudgetLigneDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.EcrituresAnalytiquesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.JournauxComptablesDao;
import com.epegase.systeme.dao.PlanBudgetaireCompteDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PlansBudgetairesDao;
import com.epegase.systeme.dao.PointDeVenteDao;
import com.epegase.systeme.dao.RegionDao;
import com.epegase.systeme.dao.SecteurDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.OptionComptabilite;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jdom.JDOMException;

public class FormImpressionAnalytique implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private ExercicesComptable exoSelectionne;
   private OptionComptabilite optionComptabilite;
   private UtilDate utilDate;
   private List mesUsersItems = new ArrayList();
   private List lesRepImpression = new ArrayList();
   private transient DataModel dataModelImpgen = new ListDataModel();
   private List lesFichImpression = new ArrayList();
   private transient DataModel dataModelImpgenFichier = new ListDataModel();
   private boolean testafficheLigne = false;
   private String nomRepertoire;
   private String nomEtat = "";
   private String periode;
   private List mesPeriodesItems = new ArrayList();
   private boolean inclureJournauxS;
   private boolean inclureJournauxR;
   private String calculAmortissement;
   private String calculEcheance;
   private String typeEcriture;
   private int nbreCaractere;
   private Date filtreDateDebut;
   private Date filtreDateFin;
   private String region;
   private String mission;
   private String chantier;
   private String secteur;
   private String salarie;
   private String pdv;
   private String site;
   private String departement;
   private String service;
   private String filtreCompteDebut;
   private String filtreCompteFin;
   private String parc;
   private String activite;
   private String ligne;
   private String atelier;
   private String anal1;
   private String anal2;
   private String anal3;
   private String anal4;
   private String projet;
   private String dossier;
   private String journal;
   private String mois;
   private String etat;
   private String filtreActiviteDebut;
   private String filtreActiviteFin;
   private String filtreChantierDebut;
   private String filtreChantierFin;
   private long createur;
   private String structure;
   private String var_entete;
   private String var_filtre;
   private String var_requete;
   private int budgetSelect;
   private int budgetMode;
   private List mesSecteursItems = new ArrayList();
   private List mesPdvItems = new ArrayList();
   private List mesDepartementsItems = new ArrayList();
   private List mesServicesItems = new ArrayList();
   private List mesStructuresItems = new ArrayList();
   private EcrituresAnalytiqueCtrl ecrituresAnalytiqueCtrl;
   private boolean var_anal_activite = false;
   private int var_anal_dossier;
   private boolean var_anal_mission = false;
   private boolean var_anal_chantier = false;
   private boolean var_anal_parc = false;
   private boolean var_anal_agent = false;
   private boolean var_anal_site = false;
   private boolean var_anal_departement = false;
   private boolean var_anal_service = false;
   private boolean var_anal_region = false;
   private boolean var_anal_secteur = false;
   private boolean var_anal_pdv = false;
   private boolean var_anal_str = false;
   private boolean decoupageActivite = false;
   private List laColonne1Items;
   private List laColonne2Items;
   private List laColonne3Items;
   private String var_colonne1;
   private String var_colonne2;
   private String var_colonne3;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private String format = "PDF";
   private boolean var_affiche_impression = false;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private String impEmetteur;
   private boolean var_ctrl_imp = false;
   private boolean showModalPanelComptes = false;
   private transient DataModel datamodelComptes = new ListDataModel();
   private PlanComptable planComptable;
   private boolean type_Compte = false;
   private PlansAnalytiques plansAnalytiques;
   private String testaffiche;
   private List lesplanComptables = new ArrayList();
   private PlanComptableDao planComptableDao;
   private List touslesjournauxComptables = new ArrayList();
   private JournauxComptablesDao journauxComptablesDao;
   private List lesplanComptablesTiers;
   private List touslesjournauxComptablesItem = new ArrayList();
   private List touslesMoisItem = new ArrayList();
   private List lesModelesAutorises;
   private int choixRacine;
   private String selecFiscalite;

   public FormImpressionAnalytique() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilDate = new UtilDate();
      this.laColonne1Items = new ArrayList();
      this.laColonne2Items = new ArrayList();
      this.laColonne3Items = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.planComptableDao = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      this.journauxComptablesDao = new JournauxComptablesDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerLesRepImpCompta(Session var1) throws HibernateException, NamingException {
      this.lesRepImpression.clear();
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_ana";
      File var3 = new File(var2);
      if (!var3.exists()) {
         var3.mkdir();
      }

      String[] var4 = var3.list();
      if (var4 != null) {
         var4 = this.triAlphabetique(var4, var4.length);

         for(int var5 = 0; var5 < var4.length; ++var5) {
            if (!var4[var5].equalsIgnoreCase(".svn") && !var4[var5].equalsIgnoreCase("index.html") && !var4[var5].startsWith("extrait") && !var4[var5].equalsIgnoreCase("loyer")) {
               String var6 = "";
               var6 = var4[var5].toUpperCase();
               this.lesRepImpression.add(var6);
            }
         }
      }

      this.dataModelImpgen.setWrappedData(this.lesRepImpression);
      this.selecFiscalite = null;
      this.mesUsersItems.clear();
      UserDao var7 = new UserDao(this.baseLog, this.utilInitHibernate);
      this.mesUsersItems = var7.chargerLesComptablesItems(var1);
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

   public void chargerLesPCetJC(Session var1) throws HibernateException, NamingException {
      this.lesplanComptables.clear();
      this.lesplanComptables = this.planComptableDao.chargerLesPlcComptables(this.selecFiscalite, this.exoSelectionne.getExecpt_id(), this.usersLog.getUsrCptInterdit(), var1);
      this.touslesjournauxComptables.clear();
      this.touslesjournauxComptables = this.journauxComptablesDao.mesjournauxActifs(this.exoSelectionne.getExecpt_id(), this.usersLog.getUsrJrxInterdit(), this.usersLog.getUsrJrxReserve(), var1);
      String var2 = "Tous les Journaux";
      this.touslesjournauxComptablesItem.clear();
      SelectItem var3 = new SelectItem(var2);
      this.touslesjournauxComptablesItem.add(var3);

      for(int var4 = 0; var4 < this.touslesjournauxComptables.size(); ++var4) {
         JournauxComptables var5 = (JournauxComptables)this.touslesjournauxComptables.get(var4);
         String var6 = var5.getPljCode();
         String var7 = var5.getPljLibelleFr();
         SelectItem var8 = new SelectItem(var6.concat(":") + var7);
         this.touslesjournauxComptablesItem.add(var8);
      }

   }

   public void calculeAnalytique() {
      this.var_anal_activite = false;
      this.var_anal_site = false;
      this.var_anal_departement = false;
      this.var_anal_service = false;
      this.var_anal_region = false;
      this.var_anal_secteur = false;
      this.var_anal_pdv = false;
      this.var_anal_dossier = 0;
      this.var_anal_parc = false;
      this.var_anal_mission = false;
      this.var_anal_chantier = false;
      this.var_anal_agent = false;
      this.var_anal_str = false;
      if (this.structureLog.isStrActivite()) {
         this.var_anal_activite = true;
      }

      if (this.structureLog.isStrSite()) {
         this.var_anal_site = true;
         this.var_anal_departement = true;
         this.var_anal_service = true;
      }

      if (this.structureLog.isStrRegion()) {
         this.var_anal_region = true;
         this.var_anal_secteur = true;
         this.var_anal_pdv = true;
      }

      this.var_anal_dossier = this.structureLog.getStrDossier();
      if (this.structureLog.isStrParc()) {
         this.var_anal_parc = true;
      }

      if (this.structureLog.isStrMission()) {
         this.var_anal_mission = true;
      }

      if (this.structureLog.isStrChantier()) {
         this.var_anal_chantier = true;
      }

      if (this.structureLog.isStrAgent()) {
         this.var_anal_agent = true;
      }

      if (this.structureLog.isStrStructure()) {
         this.var_anal_str = true;
      }

   }

   public void chargerSecteur() throws HibernateException, NamingException {
      this.mesSecteursItems.clear();
      this.mesPdvItems.clear();
      if (this.region != null && !this.region.isEmpty() && this.region.contains(":")) {
         new ArrayList();
         String[] var2 = this.region.split(":");
         new Region();
         RegionDao var4 = new RegionDao(this.baseLog, this.utilInitHibernate);
         Region var3 = var4.rechercheRegion(var2[0], (Session)null);
         if (var3 != null) {
            SecteurDao var5 = new SecteurDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listSecteurByRegion((Region)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesSecteursItems.add(new SelectItem(((Secteur)var1.get(var6)).getSecCode() + ":" + ((Secteur)var1.get(var6)).getSecNomFr()));
               }
            }
         }
      }

   }

   public void chargerPdv() throws HibernateException, NamingException {
      this.mesPdvItems.clear();
      if (this.secteur != null && !this.secteur.isEmpty() && this.secteur.contains(":")) {
         new ArrayList();
         String[] var2 = this.secteur.split(":");
         new Secteur();
         SecteurDao var4 = new SecteurDao(this.baseLog, this.utilInitHibernate);
         Secteur var3 = var4.rechercheSecteur(var2[0], (Session)null);
         if (var3 != null) {
            PointDeVenteDao var5 = new PointDeVenteDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listPdvBySecteur((Secteur)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesPdvItems.add(new SelectItem(((PointDeVente)var1.get(var6)).getPdvCode() + ":" + ((PointDeVente)var1.get(var6)).getPdvNomFr()));
               }
            }
         }
      }

   }

   public void chargerDepartement() throws HibernateException, NamingException {
      this.mesDepartementsItems.clear();
      this.mesServicesItems.clear();
      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         new ArrayList();
         String[] var2 = this.site.split(":");
         new Site();
         SiteDao var4 = new SiteDao(this.baseLog, this.utilInitHibernate);
         Site var3 = var4.rechercheSite(var2[0], (Session)null);
         if (var3 != null) {
            DepartementDao var5 = new DepartementDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listDepartementBySit((Site)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesDepartementsItems.add(new SelectItem(((Departement)var1.get(var6)).getDepCode() + ":" + ((Departement)var1.get(var6)).getDepNomFr()));
               }
            }
         }
      }

   }

   public void chargerService() throws HibernateException, NamingException {
      this.mesServicesItems.clear();
      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         new ArrayList();
         String[] var2 = this.departement.split(":");
         new Departement();
         DepartementDao var4 = new DepartementDao(this.baseLog, this.utilInitHibernate);
         Departement var3 = var4.rechercheDepartement(var2[0], (Session)null);
         if (var3 != null) {
            ServiceDao var5 = new ServiceDao(this.baseLog, this.utilInitHibernate);
            List var1 = var5.listServiceByDep((Departement)var3, (Session)null);
            if (var1.size() != 0) {
               for(int var6 = 0; var6 < var1.size(); ++var6) {
                  this.mesServicesItems.add(new SelectItem(((Service)var1.get(var6)).getSerCode() + ":" + ((Service)var1.get(var6)).getSerNomFr()));
               }
            }
         }
      }

   }

   public void calculerLesDecoupagesActivites(Session var1) throws HibernateException, NamingException {
      if (this.decoupageActivite) {
         ActivitesDao var2 = new ActivitesDao(this.baseLog, this.utilInitHibernate);
         if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
            this.laColonne1Items = var2.chargerLesDecoupages(this.structureLog.getStrCode1(), var1);
         }

         if (this.structureLog.getStrCode2() != null && !this.structureLog.getStrCode2().isEmpty()) {
            this.laColonne2Items = var2.chargerLesDecoupages(this.structureLog.getStrCode2(), var1);
         }

         if (this.structureLog.getStrCode3() != null && !this.structureLog.getStrCode3().isEmpty()) {
            this.laColonne3Items = var2.chargerLesDecoupages(this.structureLog.getStrCode3(), var1);
         }
      }

   }

   public void calculerMoisExercice(Session var1) {
      this.touslesMoisItem.clear();
      this.filtreDateDebut = this.exoSelectionne.getExecptDateDebut();
      this.filtreDateFin = this.exoSelectionne.getExecptDateFin();
      Date var2 = this.exoSelectionne.getExecptDateDebut();
      Date var3 = this.exoSelectionne.getExecptDateFin();
      int var4 = var2.getYear();
      int var5 = var3.getYear();
      int var6 = var2.getMonth();
      int var7 = var3.getMonth();
      String var8 = "0";

      for(int var9 = var4; var9 <= var5; ++var9) {
         if (var5 > var4 && var8.equalsIgnoreCase("0")) {
            var7 = 11;
         }

         if (var5 > var4 && var8.equalsIgnoreCase("1")) {
            var7 = var3.getMonth();
         }

         for(int var10 = var6; var10 <= var7; ++var10) {
            int var11 = var10 + 1;
            String var12 = this.convertirIntMois(var11);
            int var13 = this.convrtirAnne(var9);
            String var14 = "" + var12 + ":" + var13;
            SelectItem var15 = new SelectItem(var14);
            this.touslesMoisItem.add(var15);
            var6 = 0;
            var8 = "1";
         }
      }

   }

   public String convertirIntMois(int var1) {
      String var2 = "" + var1;
      if (var1 < 10) {
         var2 = "0" + var1;
      }

      return var2;
   }

   public int convrtirAnne(int var1) {
      int var2 = var1 - 100 + 2000;
      return var2;
   }

   public void recupererNomrep() throws HibernateException, NamingException {
      this.testafficheLigne = false;
      if (this.dataModelImpgen.isRowAvailable()) {
         this.nomRepertoire = (String)this.dataModelImpgen.getRowData();
         this.nomRepertoire = this.nomRepertoire.toLowerCase();
         this.nomEtat = "";
         this.lesFichImpression.clear();
         String var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_ana" + File.separator + this.nomRepertoire;
         this.testafficheLigne = false;
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         String[] var3 = var2.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(int var4 = 0; var4 < var3.length; ++var4) {
               if (var3[var4].endsWith("jasper")) {
                  String var5 = var3[var4];
                  if (this.verificationAutorisation(var5)) {
                     String var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                     this.lesFichImpression.add(var6);
                  }
               }
            }
         }

         if (!this.nomRepertoire.equalsIgnoreCase("balance") && !this.nomRepertoire.equalsIgnoreCase("grand_livre") && !this.nomRepertoire.equalsIgnoreCase("synthese")) {
            if (!this.nomRepertoire.equalsIgnoreCase("brouillard") && !this.nomRepertoire.equalsIgnoreCase("controles") && !this.nomRepertoire.equalsIgnoreCase("utilisateur")) {
               if (this.nomRepertoire.equalsIgnoreCase("budget")) {
                  this.setTestaffiche("budget");
               } else if (this.nomRepertoire.equalsIgnoreCase("amortissement")) {
                  this.setTestaffiche("amortissement");
               } else if (this.nomRepertoire.equalsIgnoreCase("loyer")) {
                  this.setTestaffiche("loyer");
               } else if (this.nomRepertoire.equalsIgnoreCase("bilan")) {
                  this.setTestaffiche("bilan");
               }
            } else {
               this.setTestaffiche("brouillard");
            }
         } else {
            this.setTestaffiche("balance");
         }

         this.filtreDateDebut = this.exoSelectionne.getExecptDateDebut();
         this.filtreDateFin = this.exoSelectionne.getExecptDateFin();
         this.calculerNumCpte();
         this.dataModelImpgenFichier.setWrappedData(this.lesFichImpression);
         this.var_affiche_impression = true;
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

   public void calculerNumCpte() throws HibernateException, NamingException {
      String var1;
      if (this.nomRepertoire.contains("fournisseurs")) {
         var1 = "from PlanComptable where exercicesComptable=" + this.exoSelectionne.getExecpt_id() + " and plcNature=6 order by plcCompte ASC";
         this.lesplanComptablesTiers = this.planComptableDao.chargerPlanComptableImp(var1, (Session)null);
      } else if (this.nomRepertoire.contains("clients")) {
         var1 = "from PlanComptable where exercicesComptable=" + this.exoSelectionne.getExecpt_id() + " and plcNature=7 order by plcCompte ASC";
         this.lesplanComptablesTiers = this.planComptableDao.chargerPlanComptableImp(var1, (Session)null);
      } else if (this.nomRepertoire.contains("personnels")) {
         var1 = "from PlanComptable where exercicesComptable=" + this.exoSelectionne.getExecpt_id() + " and plcNature=8 order by plcCompte ASC";
         this.lesplanComptablesTiers = this.planComptableDao.chargerPlanComptableImp(var1, (Session)null);
      } else {
         var1 = "from PlanComptable where exercicesComptable=" + this.exoSelectionne.getExecpt_id() + " order by plcCompte ASC";
         this.lesplanComptablesTiers = this.planComptableDao.chargerPlanComptableImp(var1, (Session)null);
      }

      if (this.lesplanComptablesTiers.size() > 0) {
         new PlanComptable();
         PlanComptable var3 = (PlanComptable)this.lesplanComptablesTiers.get(0);
         this.filtreCompteDebut = var3.getPlcCompte();
         int var2 = this.lesplanComptablesTiers.size() - 1;
         var3 = (PlanComptable)this.lesplanComptablesTiers.get(var2);
         this.filtreCompteFin = var3.getPlcCompte();
      } else {
         this.filtreCompteDebut = "";
         this.filtreCompteFin = "";
      }

   }

   public void recupererNomfich() throws HibernateException, NamingException, ParseException {
      if (this.dataModelImpgenFichier.isRowAvailable()) {
         this.nomEtat = (String)this.dataModelImpgenFichier.getRowData();
         this.filtreDateDebut = this.exoSelectionne.getExecptDateDebut();
         this.filtreDateFin = this.exoSelectionne.getExecptDateFin();
         this.calculerNumCpte();
         this.var_affiche_impression = true;
         this.calculeDates();
      }

   }

   public void rechercheComptesDebut() throws ClassCastException, HibernateException, NamingException {
      new ArrayList();
      if (this.filtreCompteDebut != null && !this.filtreCompteDebut.isEmpty()) {
         String var2 = "";
         List var1 = this.planComptableDao.chargerlesNumCpte("", this.filtreCompteDebut, this.exoSelectionne.getExecpt_id(), this.usersLog.getUsrCptInterdit(), (Session)null);
         this.datamodelComptes.setWrappedData(var1);
         this.showModalPanelComptes = true;
         this.type_Compte = false;
      }

   }

   public void rechercheComptesFin() throws ClassCastException, HibernateException, NamingException {
      new ArrayList();
      if (this.filtreCompteFin != null && !this.filtreCompteFin.isEmpty()) {
         String var2 = "";
         List var1 = this.planComptableDao.chargerlesNumCpte("", this.filtreCompteFin, this.exoSelectionne.getExecpt_id(), this.usersLog.getUsrCptInterdit(), (Session)null);
         this.datamodelComptes.setWrappedData(var1);
         this.showModalPanelComptes = true;
         this.type_Compte = true;
      }

   }

   public void selectionligneCompte() throws JDOMException, IOException {
      if (this.datamodelComptes.isRowAvailable()) {
         this.planComptable = (PlanComptable)this.datamodelComptes.getRowData();
      }

   }

   public void calculeCompte() throws JDOMException, IOException {
      if (this.planComptable == null) {
         this.selectionligneCompte();
      }

      if (this.planComptable != null) {
         if (!this.type_Compte) {
            this.filtreCompteDebut = this.planComptable.getPlcCompte();
            this.filtreCompteFin = this.planComptable.getPlcCompte();
         } else {
            this.filtreCompteFin = this.planComptable.getPlcCompte();
         }
      } else {
         this.planComptable = null;
         if (!this.type_Compte) {
            this.filtreCompteDebut = "";
            this.filtreCompteFin = "";
         } else {
            this.filtreCompteFin = "";
         }
      }

      this.showModalPanelComptes = false;
   }

   public void annuleCompte() {
      this.planComptable = null;
      if (!this.type_Compte) {
         this.filtreCompteDebut = "";
      } else {
         this.filtreCompteFin = "";
      }

      this.showModalPanelComptes = false;
   }

   public void chargerPeriodes() throws ParseException {
      this.mesPeriodesItems.clear();
      this.mesPeriodesItems.add(new SelectItem(""));
      Date var1 = this.exoSelectionne.getExecptDateDebut();
      GregorianCalendar var2 = new GregorianCalendar();
      var2.setTime(var1);
      Date var3 = this.exoSelectionne.getExecptDateFin();
      GregorianCalendar var4 = new GregorianCalendar();
      var4.setTime(var3);
      var2.add(2, -1);
      var4.add(2, -1);
      String var5 = null;

      while(var2.compareTo(var4) < 0) {
         var2.add(2, 1);
         Date var6 = var2.getTime();
         var5 = this.formatPeriode(var6);
         this.mesPeriodesItems.add(new SelectItem(var5));
      }

      this.mesPeriodesItems.add(new SelectItem("1er trimestre"));
      this.mesPeriodesItems.add(new SelectItem("2eme trimestre"));
      this.mesPeriodesItems.add(new SelectItem("3eme trimestre"));
      this.mesPeriodesItems.add(new SelectItem("4eme trimestre"));
      this.mesPeriodesItems.add(new SelectItem("1er semestre"));
      this.mesPeriodesItems.add(new SelectItem("2eme semestre"));
      this.mesPeriodesItems.add(new SelectItem("Annuel"));
      this.filtreDateDebut = var1;
      this.filtreDateFin = var3;
   }

   public String formatPeriode(Date var1) {
      SimpleDateFormat var2 = new SimpleDateFormat("dd-MM-yyyy");
      var2.format(var1);
      String var3 = "" + var2.format(var1);
      String[] var4 = var3.split("-");
      String var5 = var4[0];
      String var6 = var4[1];
      String var7 = var4[2];
      String var8 = var6 + ":" + var7;
      return var8;
   }

   public void calculeDates() throws ParseException {
      if (this.periode != null && !this.periode.isEmpty()) {
         if (this.periode.contains(":")) {
            String[] var1 = this.periode.split(":");
            String var2 = var1[0];
            String var3 = var1[1];
            this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var3 + "-" + var2 + "-" + "01");
            this.filtreDateFin = this.utilDate.dateDernierJourMois(this.filtreDateDebut);
         } else {
            int var4 = (new Date()).getYear() + 1900;
            if (this.periode.equals("1er trimestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "03" + "-" + "31");
            } else if (this.periode.equals("2eme trimestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "04" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "06" + "-" + "30");
            } else if (this.periode.equals("3eme trimestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "07" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "09" + "-" + "30");
            } else if (this.periode.equals("4eme trimestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "10" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
            } else if (this.periode.equals("1er semestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "06" + "-" + "30");
            } else if (this.periode.equals("2eme semestre")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "07" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
            } else if (this.periode.equals("Annuel")) {
               this.filtreDateDebut = this.utilDate.stringToDateSQLLight(var4 + "-" + "01" + "-" + "01");
               this.filtreDateFin = this.utilDate.stringToDateSQLLight(var4 + "-" + "12" + "-" + "31");
            }
         }
      }

   }

   public void initImpression(Session var1) throws HibernateException, NamingException {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.affMail = false;
      if (this.structureLog.getStrCode1() != null && !this.structureLog.getStrCode1().isEmpty()) {
         this.decoupageActivite = true;
         this.calculerLesDecoupagesActivites(var1);
      } else {
         this.decoupageActivite = false;
      }

   }

   public void imprimerPRT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PRT";
      this.imprimer();
   }

   public void imprimerJRV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "JRV";
      this.imprimer();
   }

   public void imprimerPDF() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "PDF";
      this.imprimer();
   }

   public void imprimerODT() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "ODT";
      this.imprimer();
   }

   public void imprimerXLS() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XLS";
      this.imprimer();
   }

   public void imprimerDOC() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "DOC";
      this.imprimer();
   }

   public void imprimerHTML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "HTML";
      this.imprimer();
   }

   public void imprimerXML() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "XML";
      this.imprimer();
   }

   public void imprimerCSV() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "CSV";
      this.imprimer();
   }

   public void imprimerMAIL() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      if (this.impEmetteur != null && !this.impEmetteur.isEmpty() && (this.impDestinataire != null && !this.impDestinataire.isEmpty() || this.impDestinataireCC != null && !this.impDestinataireCC.isEmpty() || this.impDestinataireCCI != null && !this.impDestinataireCCI.isEmpty())) {
         this.format = "MAIL";
         this.imprimer();
      }

   }

   public void envoieMAIL() throws SQLException, JRException, IOException, HibernateException, NamingException {
      if (!this.affMail) {
         this.utilPrint.chargerLesBalEmtteurs(this.baseLog, this.structureLog, this.usersLog, (Tiers)null, "");
         if (this.utilPrint.getLesbalEmetteursItems().size() != 0 && this.utilPrint.getLesbalDestinatairesItems().size() != 0) {
            this.affMail = true;
         } else {
            this.affMail = false;
         }
      } else {
         this.affMail = false;
      }

   }

   public void imprimer() throws SQLException, JRException, IOException, ClassNotFoundException, Exception {
      if (this.nomRepertoire != null && !this.nomRepertoire.isEmpty() && this.nomEtat != null && !this.nomEtat.isEmpty()) {
         this.var_ctrl_imp = true;
         this.calculeRequete();
         this.utilPrint.setRapport(this.nomEtat);
         this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "compta_ana" + File.separator + this.nomRepertoire + File.separator);
         this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "compta" + File.separator + "sous_rapport" + File.separator);
         JRBeanCollectionDataSource var2;
         if (this.nomRepertoire.equalsIgnoreCase("controles")) {
            new ArrayList();
            List var1;
            if (this.nomEtat.equalsIgnoreCase("ControleSansDossier")) {
               var1 = this.controleSansDossier();
            } else if (this.nomEtat.equalsIgnoreCase("ControleSansActivite")) {
               var1 = this.controleSansActivite();
            } else {
               var1 = this.controleSansAnalytique();
            }

            var2 = new JRBeanCollectionDataSource(var1);
            this.utilPrint.setjRBeanCollectionDataSource(var2);
            this.utilInitHibernate.closeSession();
         } else if (this.nomRepertoire.equalsIgnoreCase("budget")) {
            this.utilPrint.setRequete("");
            JRBeanCollectionDataSource var3 = new JRBeanCollectionDataSource(this.calculBudget());
            this.utilPrint.setjRBeanCollectionDataSource(var3);
         } else {
            ArrayList var4 = new ArrayList();
            var2 = new JRBeanCollectionDataSource(var4);
            this.utilPrint.setjRBeanCollectionDataSource(var2);
            this.utilPrint.setRequete(this.var_requete);
         }

         if (this.var_entete != null && !this.var_entete.isEmpty()) {
            this.utilPrint.setEntete(this.var_entete.replace("_", " "));
         } else {
            this.utilPrint.setEntete("");
         }

         if (this.var_filtre != null && !this.var_filtre.isEmpty()) {
            this.utilPrint.setFiltre(this.var_filtre.replace("_", " "));
         } else {
            this.utilPrint.setFiltre("");
         }

         this.utilPrint.setNbCar(this.nbreCaractere);
         this.utilPrint.setExercice(this.exoSelectionne.getExecpt_id());
         this.utilPrint.setFormat(this.format);
         this.utilPrint.setEmetteur(this.impEmetteur);
         this.utilPrint.setDestinataire(this.impDestinataire);
         this.utilPrint.setDestinataireCC(this.impDestinataireCC);
         this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
         this.utilPrint.setTiersSelectionne((Tiers)null);
         this.utilPrint.setBaseLog(this.baseLog);
         this.utilPrint.setStructureLog(this.structureLog);
         this.utilPrint.setUsersLog(this.usersLog);
         this.utilPrint.imprimeRapport();
         this.var_ctrl_imp = false;
      }

   }

   public void calculeRequete() throws ParseException {
      this.var_entete = "";
      this.var_filtre = "";
      this.var_requete = "";
      String var1 = this.utilDate.dateToStringSQLLight(this.filtreDateDebut);
      String var2 = this.utilDate.dateToStringSQLLight(this.filtreDateFin);
      String var3 = this.utilDate.dateToStringFr(this.filtreDateDebut);
      String var4 = this.utilDate.dateToStringFr(this.filtreDateFin);
      String var5 = this.journal;
      if (this.nomRepertoire.equalsIgnoreCase("amortissement")) {
         this.var_filtre = var5 + " du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
         this.var_entete = "Amortissements calculés du " + var3 + " au " + var4;
         if (this.calculAmortissement.equalsIgnoreCase("0")) {
            this.var_filtre = "Calcul sur taux comptable";
         } else {
            this.var_filtre = "Calcul sur taux fiscal";
         }

         this.var_requete = "amo_compteAmo !='' and amo_inactif=0";
      } else {
         String[] var6;
         String var7;
         if (!this.nomRepertoire.equalsIgnoreCase("balance") && !this.nomRepertoire.equalsIgnoreCase("grand_livre") && !this.nomRepertoire.equalsIgnoreCase("synthese")) {
            if (!this.nomRepertoire.equalsIgnoreCase("brouillard") && !this.nomRepertoire.equalsIgnoreCase("utilisateur")) {
               if (this.nomRepertoire.equalsIgnoreCase("budget")) {
                  String var8 = "";
                  if (this.budgetMode == 0) {
                     var8 = "(initial)";
                  } else if (this.budgetMode == 1) {
                     var8 = "(réam1)";
                  } else if (this.budgetMode == 2) {
                     var8 = "(réam2)";
                  } else if (this.budgetMode == 3) {
                     var8 = "(réam3)";
                  }

                  if (this.budgetSelect == 1) {
                     this.var_entete = "Budget " + var8 + " Vente du ";
                  } else if (this.budgetSelect == 2) {
                     this.var_entete = "Budget " + var8 + " Achat du ";
                  } else if (this.budgetSelect == 3) {
                     this.var_entete = "Budget " + var8 + " Production du ";
                  } else if (this.budgetSelect == 4) {
                     this.var_entete = "Budget " + var8 + " Frais Généraux du ";
                  } else if (this.budgetSelect == 5) {
                     this.var_entete = "Budget " + var8 + " Investissement du ";
                  } else if (this.budgetSelect == 6) {
                     this.var_entete = "Budget " + var8 + " TVA du ";
                  } else if (this.budgetSelect == 7) {
                     this.var_entete = "Budget " + var8 + " Impôts et Taxes du ";
                  } else if (this.budgetSelect == 8) {
                     this.var_entete = "Budget " + var8 + " Personnel du ";
                  }

                  this.var_entete = this.var_entete + var3 + " au " + var4;
                  this.var_filtre = "";
               } else if (this.nomRepertoire.equalsIgnoreCase("loyer")) {
                  this.var_entete = "Loyer " + var3 + " au " + var4;
                  this.var_filtre = "";
                  this.var_requete = "loy_date between  '" + var1 + "' AND ' " + var2 + "'";
               } else if (this.nomRepertoire.equalsIgnoreCase("controles")) {
                  this.var_entete = this.nomRepertoire.toUpperCase() + " du " + var3 + " au " + var4;
                  if (this.nomEtat.contains("Budget")) {
                     this.var_filtre = "Du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
                     this.var_filtre = "Les natures des comptes " + this.filtreCompteDebut;
                  } else {
                     this.var_filtre = "Du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
                  }

                  this.var_requete = "ecr_ana_Actif=1 and  ecr_date_saisie between '" + var1 + "' AND '" + var2 + "' AND  ecr_compte>='" + this.filtreCompteDebut + "' AND ecr_compte<='" + this.filtreCompteFin + "'";
                  if (!this.inclureJournauxS) {
                     this.var_requete = this.var_requete + " AND ecr_nature_jrx<>11";
                  }

                  if (!this.inclureJournauxR) {
                     this.var_requete = this.var_requete + " AND ecr_reserve=0";
                  }

                  if (this.journal != null && !this.journal.isEmpty() && this.journal.contains(":")) {
                     var6 = this.journal.split(":");
                     var7 = var6[0];
                     this.var_requete = this.var_requete + " AND ecr_code='" + var7 + "'";
                  } else {
                     this.var_requete = this.var_requete + " AND ecr_nature_jrx<>13";
                  }
               }
            } else {
               this.var_entete = this.nomRepertoire + " du " + var3 + " au " + var4;
               this.var_requete = "ecrana_date_saisie between '" + var1 + "' AND '" + var2 + "' AND ecrana_compte>='" + this.filtreCompteDebut + "' AND ecrana_compte<='" + this.filtreCompteFin + "'";
               if (!this.inclureJournauxS) {
                  this.var_requete = this.var_requete + " AND ecrana_nature_jrx<>11";
               }

               if (!this.inclureJournauxR) {
                  this.var_requete = this.var_requete + " AND ecrana_reserve=0";
               }

               if (this.journal != null && !this.journal.isEmpty() && !this.journal.equalsIgnoreCase("Tous les journaux")) {
                  var6 = this.journal.split(":");
                  var7 = var6[0];
                  this.var_requete = this.var_requete + " AND ecrana_code='" + var7 + "'";
               } else {
                  this.var_requete = this.var_requete + " AND ecrana_nature_jrx<>13";
               }
            }
         } else {
            this.var_entete = this.nomRepertoire.toUpperCase() + " du " + var3 + " au " + var4;
            if (this.typeEcriture.equalsIgnoreCase("0")) {
               this.var_filtre = "Toutes les écritures du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               this.var_requete = "(ecrana_date_saisie>='" + var1 + "' AND ecrana_date_saisie<='" + var2 + "') AND  (ecrana_compte>='" + this.filtreCompteDebut + "' AND ecrana_compte<='" + this.filtreCompteFin + "')";
            } else if (this.typeEcriture.equalsIgnoreCase("1")) {
               this.var_filtre = "Ecritures non lettrées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               if (!this.filtreDateFin.equals(this.exoSelectionne.getExecptDateFin())) {
                  this.var_requete = "(ecrana_date_saisie>='" + var1 + "' AND ecrana_date_saisie<='" + var2 + "') AND (ecrana_compte>='" + this.filtreCompteDebut + "' AND ecrana_compte<='" + this.filtreCompteFin + "')";
               } else {
                  this.var_requete = "(ecrana_date_saisie>='" + var1 + "' AND ecrana_date_saisie<='" + var2 + "') AND (ecrana_compte>='" + this.filtreCompteDebut + "' AND ecrana_compte<='" + this.filtreCompteFin + "') AND (cpt_ecritures.ecr_lettrage='' or cpt_ecritures.ecr_lettrage is null)";
               }
            } else if (this.typeEcriture.equalsIgnoreCase("2")) {
               this.var_filtre = "Ecritures lettrées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               this.var_requete = "(ecrana_date_saisie>='" + var1 + "' AND ecrana_date_saisie<='" + var2 + "') AND (ecrana_compte>='" + this.filtreCompteDebut + "' AND ecrana_compte<='" + this.filtreCompteFin + "') AND (cpt_ecritures.ecr_lettrage<>'' and cpt_ecritures.ecr_lettrage is not null)";
            } else if (this.typeEcriture.equalsIgnoreCase("3")) {
               this.var_filtre = "Ecritures non pointées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               this.var_requete = "(ecrana_date_saisie>='" + var1 + "' AND ecrana_date_saisie<='" + var2 + "') AND (ecrana_compte>='" + this.filtreCompteDebut + "' AND ecrana_compte<='" + this.filtreCompteFin + "') AND (cpt_ecritures.ecr_pointage='' or cpt_ecritures.ecr_pointage is null)";
            } else if (this.typeEcriture.equalsIgnoreCase("4")) {
               this.var_filtre = "Ecritures pointées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               this.var_requete = "(ecrana_date_saisie>='" + var1 + "' AND ecrana_date_saisie<='" + var2 + "') AND (ecrana_compte>='" + this.filtreCompteDebut + "' AND ecrana_compte<='" + this.filtreCompteFin + "') AND (cpt_ecritures.ecr_pointage<>'' and cpt_ecritures.ecr_pointage is not null)";
            } else if (this.typeEcriture.equalsIgnoreCase("5")) {
               this.var_filtre = "Ecritures non lettrées et pointées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               this.var_requete = "(ecrana_date_saisie>='" + var1 + "' AND ecrana_date_saisie<='" + var2 + "') AND  (ecrana_compte>='" + this.filtreCompteDebut + "' AND ecrana_compte<='" + this.filtreCompteFin + "') AND (cpt_ecritures.ecr_lettrage='' or cpt_ecritures.ecr_lettrage is null) AND (cpt_ecritures.ecr_pointage<>'' and cpt_ecritures.ecr_pointage is not null)";
            } else if (this.typeEcriture.equalsIgnoreCase("6")) {
               this.var_filtre = "Ecritures lettrées et pointées du compte " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               this.var_requete = "(ecrana_date_saisie>='" + var1 + "' AND ecrana_date_saisie<='" + var2 + "') AND (ecrana_compte>='" + this.filtreCompteDebut + "' AND ecrana_compte<='" + this.filtreCompteFin + "') AND (cpt_ecritures.ecr_lettrage='' or cpt_ecritures.ecr_lettrage is null) AND (cpt_ecritures.ecr_pointage='' or cpt_ecritures.ecr_pointage is null)";
            } else if (this.typeEcriture.equalsIgnoreCase("7")) {
               this.var_filtre = "Toutes les écritures du compte hors comptes soldés " + this.filtreCompteDebut + " au compte " + this.filtreCompteFin;
               this.var_requete = "(ecrana_date_saisie>='" + var1 + "' AND ecrana_date_saisie<='" + var2 + "') AND  (ecrana_compte>='" + this.filtreCompteDebut + "' AND ecrana_compte<='" + this.filtreCompteFin + "')";
            }

            if (!this.inclureJournauxS) {
               this.var_requete = this.var_requete + " AND ecrana_nature_jrx<>11";
            }

            if (!this.inclureJournauxR) {
               this.var_requete = this.var_requete + " AND ecrana_reserve=0";
            }

            if (this.journal != null && !this.journal.isEmpty() && this.journal.contains(":")) {
               var6 = this.journal.split(":");
               var7 = var6[0];
               this.var_requete = this.var_requete + " AND ecrana_code='" + var7 + "'";
            } else {
               this.var_requete = this.var_requete + " AND ecrana_nature_jrx<>13";
            }

            if (!this.decoupageActivite) {
               if (this.activite != null && !this.activite.isEmpty() && this.activite.contains(":")) {
                  var6 = this.activite.split(":");
                  var7 = var6[0];
                  this.var_requete = this.var_requete + " AND ecrana_activite='" + var7 + "'";
               } else if (this.activite != null && !this.activite.isEmpty() && this.activite.equals("*") && this.filtreActiviteDebut != null && !this.filtreActiviteDebut.isEmpty() && this.filtreActiviteFin != null && !this.filtreActiviteFin.isEmpty()) {
                  this.var_requete = this.var_requete + " AND (ecrana_activite>='" + this.filtreActiviteDebut + "' and ecrana_activite<='" + this.filtreActiviteFin + "')";
               }
            } else {
               if (this.var_colonne1 != null && this.var_colonne1.contains(":")) {
                  var6 = this.var_colonne1.split(":");
                  var7 = var6[0];
                  this.var_requete = this.var_requete + " AND ecrana_activite='" + var7 + "'";
               }

               if (this.var_colonne2 != null && this.var_colonne2.contains(":")) {
                  var6 = this.var_colonne2.split(":");
                  var7 = var6[0];
                  this.var_requete = this.var_requete + " AND ecrana_anal1='" + var7 + "'";
               }

               if (this.var_colonne3 != null && this.var_colonne3.contains(":")) {
                  var6 = this.var_colonne3.split(":");
                  var7 = var6[0];
                  this.var_requete = this.var_requete + " AND ecrana_ana3='" + var7 + "'";
               }
            }

            if (this.parc != null && this.parc.contains(":")) {
               var6 = this.parc.split(":");
               var7 = var6[0];
               this.var_requete = this.var_requete + " AND ecrana_anal2='" + var7 + "'";
            }

            if (this.dossier != null && this.dossier.contains(":")) {
               var6 = this.dossier.split(":");
               var7 = var6[0];
               this.var_requete = this.var_requete + " AND ecrana_anal4='" + var7 + "'";
            }

            if (this.mission != null && this.mission.contains(":")) {
               var6 = this.mission.split(":");
               var7 = var6[0];
               this.var_requete = this.var_requete + " AND ecrana_anal3='" + var7 + "'";
            }

            if (this.chantier != null && !this.chantier.isEmpty()) {
               if (this.chantier.contains(":")) {
                  var6 = this.chantier.split(":");
                  var7 = var6[0];
                  this.var_requete = this.var_requete + " AND ecrana_anal1='" + var7 + "'";
               } else if (this.chantier.equals("*") && this.filtreChantierDebut != null && !this.filtreChantierDebut.isEmpty() && this.filtreChantierFin != null && !this.filtreChantierFin.isEmpty()) {
                  this.var_requete = this.var_requete + " AND (ecrana_anal1>='" + this.filtreChantierDebut + "' and ecrana_anal1<='" + this.filtreChantierFin + "')";
               }
            }

            if (this.site != null && this.site.contains(":")) {
               var6 = this.site.split(":");
               var7 = var6[0];
               this.var_requete = this.var_requete + " AND ecrana_site='" + var7 + "'";
            }

            if (this.departement != null && this.departement.contains(":")) {
               var6 = this.departement.split(":");
               var7 = var6[0];
               this.var_requete = this.var_requete + " AND ecrana_departement='" + var7 + "'";
            }

            if (this.salarie != null && this.salarie.contains(":")) {
               var6 = this.salarie.split(":");
               var7 = var6[0];
               this.var_requete = this.var_requete + " AND ecrana_agent='" + var7 + "'";
            }

            if (this.service != null && this.service.contains(":")) {
               var6 = this.service.split(":");
               var7 = var6[0];
               this.var_requete = this.var_requete + " AND ecrana_service='" + var7 + "'";
            }

            if (this.region != null && this.region.contains(":")) {
               var6 = this.region.split(":");
               var7 = var6[0];
               this.var_requete = this.var_requete + " AND ecrana_region='" + var7 + "'";
            }

            if (this.secteur != null && this.secteur.contains(":")) {
               var6 = this.secteur.split(":");
               var7 = var6[0];
               this.var_requete = this.var_requete + " AND ecrana_secteur='" + var7 + "'";
            }

            if (this.pdv != null && this.pdv.contains(":")) {
               var6 = this.pdv.split(":");
               var7 = var6[0];
               this.var_requete = this.var_requete + " AND ecrana_pdv='" + var7 + "'";
            }

            if (this.structure != null && this.structure.contains(":")) {
               var6 = this.structure.split(":");
               var7 = var6[0];
               this.var_requete = this.var_requete + " AND ecrana_str='" + var7 + "'";
            }
         }
      }

   }

   public String calculeCompteBudget() {
      String var1 = "";
      if (this.optionComptabilite.getBud_c1().equals("true")) {
         var1 = this.calculChaine(var1, "1");
      }

      if (this.optionComptabilite.getBud_c2().equals("true")) {
         var1 = this.calculChaine(var1, "2");
      }

      if (this.optionComptabilite.getBud_c3().equals("true")) {
         var1 = this.calculChaine(var1, "3");
      }

      if (this.optionComptabilite.getBud_c4().equals("true")) {
         var1 = this.calculChaine(var1, "4");
      }

      if (this.optionComptabilite.getBud_c5().equals("true")) {
         var1 = this.calculChaine(var1, "5");
      }

      if (this.optionComptabilite.getBud_c6().equals("true")) {
         var1 = this.calculChaine(var1, "6");
      }

      if (this.optionComptabilite.getBud_c7().equals("true")) {
         var1 = this.calculChaine(var1, "7");
      }

      if (this.optionComptabilite.getBud_c8().equals("true")) {
         var1 = this.calculChaine(var1, "8");
      }

      if (this.optionComptabilite.getBud_c9().equals("true")) {
         var1 = this.calculChaine(var1, "9");
      }

      if (this.optionComptabilite.getBud_c10().equals("true")) {
         var1 = this.calculChaine(var1, "10");
      }

      if (this.optionComptabilite.getBud_c11().equals("true")) {
         var1 = this.calculChaine(var1, "11");
      }

      if (this.optionComptabilite.getBud_c12().equals("true")) {
         var1 = this.calculChaine(var1, "12");
      }

      if (this.optionComptabilite.getBud_c13().equals("true")) {
         var1 = this.calculChaine(var1, "13");
      }

      if (this.optionComptabilite.getBud_c14().equals("true")) {
         var1 = this.calculChaine(var1, "14");
      }

      if (this.optionComptabilite.getBud_c15().equals("true")) {
         var1 = this.calculChaine(var1, "15");
      }

      if (this.optionComptabilite.getBud_c16().equals("true")) {
         var1 = this.calculChaine(var1, "16");
      }

      if (this.optionComptabilite.getBud_c17().equals("true")) {
         var1 = this.calculChaine(var1, "17");
      }

      if (this.optionComptabilite.getBud_c18().equals("true")) {
         var1 = this.calculChaine(var1, "18");
      }

      if (this.optionComptabilite.getBud_c19().equals("true")) {
         var1 = this.calculChaine(var1, "19");
      }

      if (this.optionComptabilite.getBud_c20().equals("true")) {
         var1 = this.calculChaine(var1, "20");
      }

      if (this.optionComptabilite.getBud_c21().equals("true")) {
         var1 = this.calculChaine(var1, "21");
      }

      if (this.optionComptabilite.getBud_c22().equals("true")) {
         var1 = this.calculChaine(var1, "22");
      }

      if (this.optionComptabilite.getBud_c23().equals("true")) {
         var1 = this.calculChaine(var1, "23");
      }

      if (this.optionComptabilite.getBud_c24().equals("true")) {
         var1 = this.calculChaine(var1, "24");
      }

      return var1;
   }

   public String calculeCompteAnalytique() {
      String var1 = "";
      if (this.optionComptabilite.getAnal_c1().equals("true")) {
         var1 = this.calculChaine(var1, "1");
      }

      if (this.optionComptabilite.getAnal_c2().equals("true")) {
         var1 = this.calculChaine(var1, "2");
      }

      if (this.optionComptabilite.getAnal_c3().equals("true")) {
         var1 = this.calculChaine(var1, "3");
      }

      if (this.optionComptabilite.getAnal_c4().equals("true")) {
         var1 = this.calculChaine(var1, "4");
      }

      if (this.optionComptabilite.getAnal_c5().equals("true")) {
         var1 = this.calculChaine(var1, "5");
      }

      if (this.optionComptabilite.getAnal_c6().equals("true")) {
         var1 = this.calculChaine(var1, "6");
      }

      if (this.optionComptabilite.getAnal_c7().equals("true")) {
         var1 = this.calculChaine(var1, "7");
      }

      if (this.optionComptabilite.getAnal_c8().equals("true")) {
         var1 = this.calculChaine(var1, "8");
      }

      if (this.optionComptabilite.getAnal_c9().equals("true")) {
         var1 = this.calculChaine(var1, "9");
      }

      if (this.optionComptabilite.getAnal_c10().equals("true")) {
         var1 = this.calculChaine(var1, "10");
      }

      if (this.optionComptabilite.getAnal_c11().equals("true")) {
         var1 = this.calculChaine(var1, "11");
      }

      if (this.optionComptabilite.getAnal_c12().equals("true")) {
         var1 = this.calculChaine(var1, "12");
      }

      if (this.optionComptabilite.getAnal_c13().equals("true")) {
         var1 = this.calculChaine(var1, "13");
      }

      if (this.optionComptabilite.getAnal_c14().equals("true")) {
         var1 = this.calculChaine(var1, "14");
      }

      if (this.optionComptabilite.getAnal_c15().equals("true")) {
         var1 = this.calculChaine(var1, "15");
      }

      if (this.optionComptabilite.getAnal_c16().equals("true")) {
         var1 = this.calculChaine(var1, "16");
      }

      if (this.optionComptabilite.getAnal_c17().equals("true")) {
         var1 = this.calculChaine(var1, "17");
      }

      if (this.optionComptabilite.getAnal_c18().equals("true")) {
         var1 = this.calculChaine(var1, "18");
      }

      if (this.optionComptabilite.getAnal_c19().equals("true")) {
         var1 = this.calculChaine(var1, "19");
      }

      if (this.optionComptabilite.getAnal_c20().equals("true")) {
         var1 = this.calculChaine(var1, "20");
      }

      if (this.optionComptabilite.getAnal_c21().equals("true")) {
         var1 = this.calculChaine(var1, "21");
      }

      if (this.optionComptabilite.getAnal_c22().equals("true")) {
         var1 = this.calculChaine(var1, "22");
      }

      if (this.optionComptabilite.getAnal_c23().equals("true")) {
         var1 = this.calculChaine(var1, "23");
      }

      if (this.optionComptabilite.getAnal_c24().equals("true")) {
         var1 = this.calculChaine(var1, "24");
      }

      return var1;
   }

   public String calculChaine(String var1, String var2) {
      String var3 = "";
      if (var1 != null && !var1.isEmpty()) {
         var3 = var1 + ",'" + var2 + "'";
      } else {
         var3 = "'" + var2 + "'";
      }

      return var3;
   }

   public List calculBudget() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlansBudgetaires");
      int var2 = this.filtreDateDebut.getMonth() + 1;
      int var3 = this.filtreDateFin.getMonth() + 1;
      double var4 = 0.0D;
      ArrayList var6 = new ArrayList();
      new BudgetLigne();
      new ArrayList();
      BudgetLigneDao var9 = new BudgetLigneDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      new PlanBudgetaireCompte();
      new ArrayList();
      new PlansBudgetaires();
      new ArrayList();
      PlansBudgetairesDao var15 = new PlansBudgetairesDao(this.baseLog, this.utilInitHibernate);
      PlanBudgetaireCompteDao var16 = new PlanBudgetaireCompteDao(this.baseLog, this.utilInitHibernate);
      EcrituresAnalytiquesDao var17 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      String var18 = "" + (this.filtreDateDebut.getYear() + 1900);
      String var19 = "" + this.budgetSelect;
      List var14 = var15.chargerLesPlansBudgetaires(this.exoSelectionne, 0, var19, var18, var1);
      if (var14.size() != 0) {
         for(int var20 = 0; var20 < var14.size(); ++var20) {
            PlansBudgetaires var13 = (PlansBudgetaires)var14.get(var20);
            List var8 = var9.chargerLigneBudget(var13.getPlbCode(), var1);
            List var12 = var16.chargerLesPlansBudgetaireCompte(var13.getPlb_id(), 0, 0, var1);
            if (var12.size() != 0) {
               for(int var21 = 0; var21 < var12.size(); ++var21) {
                  PlanBudgetaireCompte var11 = (PlanBudgetaireCompte)var12.get(var21);
                  new EcrituresAnalytique();
                  List var10 = var17.chargerLesEcrituresAnalytiques(this.filtreDateDebut, this.filtreDateFin, var11.getPlbcptCompte(), this.inclureJournauxS, this.inclureJournauxR, this.site, this.departement, this.service, this.region, this.secteur, this.pdv, this.ligne, this.atelier, this.anal1, this.anal2, this.anal3, this.anal4, this.activite, this.projet, var1);
                  if (var10.size() != 0) {
                     boolean var23 = false;

                     for(int var24 = 0; var24 < var10.size(); ++var24) {
                        EcrituresAnalytique var22 = (EcrituresAnalytique)var10.get(var24);
                        if (var6.size() == 0) {
                           var23 = false;
                        } else {
                           var23 = false;

                           for(int var25 = 0; var25 < var6.size(); ++var25) {
                              this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)var6.get(var25);
                              if (var22.getEcranaSite().equals(this.ecrituresAnalytiqueCtrl.getEcranaSite()) && var22.getEcranaDepartement().equals(this.ecrituresAnalytiqueCtrl.getEcranaDepartement()) && var22.getEcranaService().equals(this.ecrituresAnalytiqueCtrl.getEcranaService()) && var22.getEcranaRegion().equals(this.ecrituresAnalytiqueCtrl.getEcranaRegion()) && var22.getEcranaSecteur().equals(this.ecrituresAnalytiqueCtrl.getEcranaSecteur()) && var22.getEcranaPdv().equals(this.ecrituresAnalytiqueCtrl.getEcranaPdv()) && var22.getEcranaAnal1().equals(this.ecrituresAnalytiqueCtrl.getEcranaAnal1()) && var22.getEcranaAnal2().equals(this.ecrituresAnalytiqueCtrl.getEcranaAnal2()) && var22.getEcranaAnal3().equals(this.ecrituresAnalytiqueCtrl.getEcranaAnal3()) && var22.getEcranaAnal4().equals(this.ecrituresAnalytiqueCtrl.getEcranaAnal4()) && var22.getEcranaActivite().equals(this.ecrituresAnalytiqueCtrl.getEcranaActivite())) {
                                 var23 = true;
                                 break;
                              }
                           }
                        }

                        double var28 = 0.0D;
                        if (var8.size() != 0) {
                           for(int var27 = 0; var27 < var8.size(); ++var27) {
                              BudgetLigne var7 = (BudgetLigne)var8.get(var27);
                              if (var22.getEcranaSite().equals(var7.getBudligSite()) && var22.getEcranaDepartement().equals(var7.getBudligDepartement()) && var22.getEcranaService().equals(var7.getBudligService()) && var22.getEcranaRegion().equals(var7.getBudligRegion()) && var22.getEcranaSecteur().equals(var7.getBudligSecteur()) && var22.getEcranaPdv().equals(var7.getBudligPdv()) && var22.getEcranaAnal1().equals(var7.getBudligAnal1()) && var22.getEcranaAnal3().equals(var7.getBudligAnal3()) && var22.getEcranaActivite().equals(var7.getBudligActivite())) {
                                 if (this.budgetMode == 0) {
                                    if (1 >= var2 && 1 <= var3) {
                                       var28 += var7.getBudlig01R1Val();
                                    }

                                    if (2 >= var2 && 2 <= var3) {
                                       var28 += var7.getBudlig02R1Val();
                                    }

                                    if (3 >= var2 && 3 <= var3) {
                                       var28 += var7.getBudlig03R1Val();
                                    }

                                    if (4 >= var2 && 4 <= var3) {
                                       var28 += var7.getBudlig04R1Val();
                                    }

                                    if (5 >= var2 && 5 <= var3) {
                                       var28 += var7.getBudlig05R1Val();
                                    }

                                    if (6 >= var2 && 6 <= var3) {
                                       var28 += var7.getBudlig06R1Val();
                                    }

                                    if (7 >= var2 && 7 <= var3) {
                                       var28 += var7.getBudlig07R1Val();
                                    }

                                    if (8 >= var2 && 8 <= var3) {
                                       var28 += var7.getBudlig08R1Val();
                                    }

                                    if (9 >= var2 && 9 <= var3) {
                                       var28 += var7.getBudlig09R1Val();
                                    }

                                    if (10 >= var2 && 10 <= var3) {
                                       var28 += var7.getBudlig10R1Val();
                                    }

                                    if (11 >= var2 && 11 <= var3) {
                                       var28 += var7.getBudlig11R1Val();
                                    }

                                    if (12 >= var2 && 12 <= var3) {
                                       var28 += var7.getBudlig12R1Val();
                                    }
                                 } else if (this.budgetMode == 1) {
                                    if (1 >= var2 && 1 <= var3) {
                                       var28 += var7.getBudlig01R2Val();
                                    }

                                    if (2 >= var2 && 2 <= var3) {
                                       var28 += var7.getBudlig02R2Val();
                                    }

                                    if (3 >= var2 && 3 <= var3) {
                                       var28 += var7.getBudlig03R2Val();
                                    }

                                    if (4 >= var2 && 4 <= var3) {
                                       var28 += var7.getBudlig04R2Val();
                                    }

                                    if (5 >= var2 && 5 <= var3) {
                                       var28 += var7.getBudlig05R2Val();
                                    }

                                    if (6 >= var2 && 6 <= var3) {
                                       var28 += var7.getBudlig06R2Val();
                                    }

                                    if (7 >= var2 && 7 <= var3) {
                                       var28 += var7.getBudlig07R2Val();
                                    }

                                    if (8 >= var2 && 8 <= var3) {
                                       var28 += var7.getBudlig08R2Val();
                                    }

                                    if (9 >= var2 && 9 <= var3) {
                                       var28 += var7.getBudlig09R2Val();
                                    }

                                    if (10 >= var2 && 10 <= var3) {
                                       var28 += var7.getBudlig10R2Val();
                                    }

                                    if (11 >= var2 && 11 <= var3) {
                                       var28 += var7.getBudlig11R2Val();
                                    }

                                    if (12 >= var2 && 12 <= var3) {
                                       var28 += var7.getBudlig12R2Val();
                                    }
                                 } else if (this.budgetMode == 2) {
                                    if (1 >= var2 && 1 <= var3) {
                                       var28 += var7.getBudlig01R3Val();
                                    }

                                    if (2 >= var2 && 2 <= var3) {
                                       var28 += var7.getBudlig02R3Val();
                                    }

                                    if (3 >= var2 && 3 <= var3) {
                                       var28 += var7.getBudlig03R3Val();
                                    }

                                    if (4 >= var2 && 4 <= var3) {
                                       var28 += var7.getBudlig04R3Val();
                                    }

                                    if (5 >= var2 && 5 <= var3) {
                                       var28 += var7.getBudlig05R3Val();
                                    }

                                    if (6 >= var2 && 6 <= var3) {
                                       var28 += var7.getBudlig06R3Val();
                                    }

                                    if (7 >= var2 && 7 <= var3) {
                                       var28 += var7.getBudlig07R3Val();
                                    }

                                    if (8 >= var2 && 8 <= var3) {
                                       var28 += var7.getBudlig08R3Val();
                                    }

                                    if (9 >= var2 && 9 <= var3) {
                                       var28 += var7.getBudlig09R3Val();
                                    }

                                    if (10 >= var2 && 10 <= var3) {
                                       var28 += var7.getBudlig10R3Val();
                                    }

                                    if (11 >= var2 && 11 <= var3) {
                                       var28 += var7.getBudlig11R3Val();
                                    }

                                    if (12 >= var2 && 12 <= var3) {
                                       var28 += var7.getBudlig12R3Val();
                                    }
                                 } else if (this.budgetMode == 3) {
                                    if (1 >= var2 && 1 <= var3) {
                                       var28 += var7.getBudlig01R4Val();
                                    }

                                    if (2 >= var2 && 2 <= var3) {
                                       var28 += var7.getBudlig02R4Val();
                                    }

                                    if (3 >= var2 && 3 <= var3) {
                                       var28 += var7.getBudlig03R4Val();
                                    }

                                    if (4 >= var2 && 4 <= var3) {
                                       var28 += var7.getBudlig04R4Val();
                                    }

                                    if (5 >= var2 && 5 <= var3) {
                                       var28 += var7.getBudlig05R4Val();
                                    }

                                    if (6 >= var2 && 6 <= var3) {
                                       var28 += var7.getBudlig06R4Val();
                                    }

                                    if (7 >= var2 && 7 <= var3) {
                                       var28 += var7.getBudlig07R4Val();
                                    }

                                    if (8 >= var2 && 8 <= var3) {
                                       var28 += var7.getBudlig08R4Val();
                                    }

                                    if (9 >= var2 && 9 <= var3) {
                                       var28 += var7.getBudlig09R4Val();
                                    }

                                    if (10 >= var2 && 10 <= var3) {
                                       var28 += var7.getBudlig10R4Val();
                                    }

                                    if (11 >= var2 && 11 <= var3) {
                                       var28 += var7.getBudlig11R4Val();
                                    }

                                    if (12 >= var2 && 12 <= var3) {
                                       var28 += var7.getBudlig12R4Val();
                                    }
                                 }
                              }
                           }
                        }

                        if (!var23) {
                           this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
                           this.ecrituresAnalytiqueCtrl.setPoste(var13.getPlbCode());
                           this.ecrituresAnalytiqueCtrl.setLibPoste(var13.getPlbLibelleFr());
                           this.ecrituresAnalytiqueCtrl.setEcranaCompte(var11.getPlbcptCompte());
                           this.ecrituresAnalytiqueCtrl.setEcranaLibelle(var11.getPlbcptLibelleFr());
                           this.ecrituresAnalytiqueCtrl.setEcranaSite(var22.getEcranaSite());
                           this.ecrituresAnalytiqueCtrl.setEcranaDepartement(var22.getEcranaDepartement());
                           this.ecrituresAnalytiqueCtrl.setEcranaService(var22.getEcranaService());
                           this.ecrituresAnalytiqueCtrl.setEcranaRegion(var22.getEcranaRegion());
                           this.ecrituresAnalytiqueCtrl.setEcranaSecteur(var22.getEcranaSecteur());
                           this.ecrituresAnalytiqueCtrl.setEcranaPdv(var22.getEcranaPdv());
                           this.ecrituresAnalytiqueCtrl.setEcranaLigne(var22.getEcranaLigne());
                           this.ecrituresAnalytiqueCtrl.setEcranaAtelier(var22.getEcranaAtelier());
                           this.ecrituresAnalytiqueCtrl.setEcranaAnal1(var22.getEcranaAnal1());
                           this.ecrituresAnalytiqueCtrl.setEcranaAnal2(var22.getEcranaAnal2());
                           this.ecrituresAnalytiqueCtrl.setEcranaAnal3(var22.getEcranaAnal3());
                           this.ecrituresAnalytiqueCtrl.setEcranaAnal4(var22.getEcranaAnal4());
                           this.ecrituresAnalytiqueCtrl.setEcranaActivite(var22.getEcranaActivite());
                           this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(var22.getEcranaMontantSaisie());
                           this.ecrituresAnalytiqueCtrl.setMontantBudget(var28);
                           var6.add(this.ecrituresAnalytiqueCtrl);
                        } else {
                           this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie() + var22.getEcranaMontantSaisie());
                        }
                     }
                  }
               }
            }
         }
      }

      this.utilPrint.setValeur1(var4);
      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List controleSansAnalytique() throws HibernateException, NamingException {
      new ArrayList();
      ArrayList var2 = new ArrayList();
      Object var3 = new ArrayList();
      EcrituresDao var4 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      EcrituresAnalytiquesDao var5 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      List var1 = var4.ChargerLesEcrituresRecherche(this.var_requete, var6);
      if (var1.size() != 0) {
         for(int var7 = 0; var7 < var1.size(); ++var7) {
            new Ecritures();
            Ecritures var8 = (Ecritures)var1.get(var7);
            ((List)var3).clear();
            if (this.nomEtat.contains("Budget")) {
               var3 = var5.chargerLesEcrituresAnalytiques(var8, 1, var6);
               if (((List)var3).size() == 0) {
                  var2.add(var8);
               }
            } else {
               var3 = var5.chargerLesEcrituresAnalytiques(var8, 0, var6);
               if (((List)var3).size() == 0) {
                  var2.add(var8);
               }
            }
         }
      }

      return var2;
   }

   public List controleSansDossier() throws HibernateException, NamingException {
      new ArrayList();
      ArrayList var2 = new ArrayList();
      Object var3 = new ArrayList();
      EcrituresDao var4 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      EcrituresAnalytiquesDao var5 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      List var1 = var4.ChargerLesEcrituresRecherche(this.var_requete, var6);
      if (var1.size() != 0) {
         for(int var7 = 0; var7 < var1.size(); ++var7) {
            new Ecritures();
            Ecritures var8 = (Ecritures)var1.get(var7);
            ((List)var3).clear();
            var3 = var5.chargerLesEcrituresAnalytiques(var8, 0, var6);
            if (((List)var3).size() == 0) {
               var2.add(var8);
            } else {
               for(int var9 = 0; var9 < ((List)var3).size(); ++var9) {
                  if ((((EcrituresAnalytique)((List)var3).get(var9)).getEcranaSite() == null || ((EcrituresAnalytique)((List)var3).get(var9)).getEcranaSite().isEmpty()) && (((EcrituresAnalytique)((List)var3).get(var9)).getEcranaRegion() == null || ((EcrituresAnalytique)((List)var3).get(var9)).getEcranaRegion().isEmpty()) && (((EcrituresAnalytique)((List)var3).get(var9)).getEcranaProjet() == null || ((EcrituresAnalytique)((List)var3).get(var9)).getEcranaProjet().isEmpty()) && (((EcrituresAnalytique)((List)var3).get(var9)).getEcranaAnal1() == null || ((EcrituresAnalytique)((List)var3).get(var9)).getEcranaAnal1().isEmpty()) && (((EcrituresAnalytique)((List)var3).get(var9)).getEcranaAnal2() == null || ((EcrituresAnalytique)((List)var3).get(var9)).getEcranaAnal2().isEmpty()) && (((EcrituresAnalytique)((List)var3).get(var9)).getEcranaAnal3() == null || ((EcrituresAnalytique)((List)var3).get(var9)).getEcranaAnal3().isEmpty()) && (((EcrituresAnalytique)((List)var3).get(var9)).getEcranaActivite() == null || ((EcrituresAnalytique)((List)var3).get(var9)).getEcranaActivite().isEmpty()) && (((EcrituresAnalytique)((List)var3).get(var9)).getEcranaAgent() == null || ((EcrituresAnalytique)((List)var3).get(var9)).getEcranaAgent().isEmpty()) && (((EcrituresAnalytique)((List)var3).get(var9)).getEcranaStr() == null || ((EcrituresAnalytique)((List)var3).get(var9)).getEcranaStr().isEmpty()) && (((EcrituresAnalytique)((List)var3).get(var9)).getEcranaPoste() == null || ((EcrituresAnalytique)((List)var3).get(var9)).getEcranaPoste().isEmpty()) && (((EcrituresAnalytique)((List)var3).get(var9)).getEcranaAnal4() == null || ((EcrituresAnalytique)((List)var3).get(var9)).getEcranaAnal4().isEmpty())) {
                     var2.add(var8);
                     break;
                  }
               }
            }
         }
      }

      return var2;
   }

   public List controleSansActivite() throws HibernateException, NamingException {
      new ArrayList();
      ArrayList var2 = new ArrayList();
      Object var3 = new ArrayList();
      EcrituresDao var4 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
      EcrituresAnalytiquesDao var5 = new EcrituresAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "Ecritures");
      List var1 = var4.ChargerLesEcrituresRecherche(this.var_requete, var6);
      if (var1.size() != 0) {
         for(int var7 = 0; var7 < var1.size(); ++var7) {
            new Ecritures();
            Ecritures var8 = (Ecritures)var1.get(var7);
            ((List)var3).clear();
            var3 = var5.chargerLesEcrituresAnalytiques(var8, 0, var6);
            if (((List)var3).size() == 0) {
               var2.add(var8);
            } else {
               for(int var9 = 0; var9 < ((List)var3).size(); ++var9) {
                  if ((((EcrituresAnalytique)((List)var3).get(var9)).getEcranaSite() == null || ((EcrituresAnalytique)((List)var3).get(var9)).getEcranaSite().isEmpty()) && (((EcrituresAnalytique)((List)var3).get(var9)).getEcranaRegion() == null || ((EcrituresAnalytique)((List)var3).get(var9)).getEcranaRegion().isEmpty()) && (((EcrituresAnalytique)((List)var3).get(var9)).getEcranaProjet() == null || ((EcrituresAnalytique)((List)var3).get(var9)).getEcranaProjet().isEmpty()) && (((EcrituresAnalytique)((List)var3).get(var9)).getEcranaAnal1() == null || ((EcrituresAnalytique)((List)var3).get(var9)).getEcranaAnal1().isEmpty()) && (((EcrituresAnalytique)((List)var3).get(var9)).getEcranaAnal2() == null || ((EcrituresAnalytique)((List)var3).get(var9)).getEcranaAnal2().isEmpty()) && (((EcrituresAnalytique)((List)var3).get(var9)).getEcranaAnal3() == null || ((EcrituresAnalytique)((List)var3).get(var9)).getEcranaAnal3().isEmpty()) && (((EcrituresAnalytique)((List)var3).get(var9)).getEcranaAnal4() == null || ((EcrituresAnalytique)((List)var3).get(var9)).getEcranaAnal4().isEmpty()) && (((EcrituresAnalytique)((List)var3).get(var9)).getEcranaAgent() == null || ((EcrituresAnalytique)((List)var3).get(var9)).getEcranaAgent().isEmpty()) && (((EcrituresAnalytique)((List)var3).get(var9)).getEcranaStr() == null || ((EcrituresAnalytique)((List)var3).get(var9)).getEcranaStr().isEmpty()) && (((EcrituresAnalytique)((List)var3).get(var9)).getEcranaPoste() == null || ((EcrituresAnalytique)((List)var3).get(var9)).getEcranaPoste().isEmpty()) && (((EcrituresAnalytique)((List)var3).get(var9)).getEcranaActivite() == null || ((EcrituresAnalytique)((List)var3).get(var9)).getEcranaActivite().isEmpty())) {
                     var2.add(var8);
                     break;
                  }
               }
            }
         }
      }

      return var2;
   }

   public OptionComptabilite getOptionComptabilite() {
      return this.optionComptabilite;
   }

   public void setOptionComptabilite(OptionComptabilite var1) {
      this.optionComptabilite = var1;
   }

   public ExercicesComptable getExoSelectionne() {
      return this.exoSelectionne;
   }

   public void setExoSelectionne(ExercicesComptable var1) {
      this.exoSelectionne = var1;
   }

   public List getMesDepartementsItems() {
      return this.mesDepartementsItems;
   }

   public void setMesDepartementsItems(List var1) {
      this.mesDepartementsItems = var1;
   }

   public List getMesPdvItems() {
      return this.mesPdvItems;
   }

   public void setMesPdvItems(List var1) {
      this.mesPdvItems = var1;
   }

   public List getMesSecteursItems() {
      return this.mesSecteursItems;
   }

   public void setMesSecteursItems(List var1) {
      this.mesSecteursItems = var1;
   }

   public List getMesServicesItems() {
      return this.mesServicesItems;
   }

   public void setMesServicesItems(List var1) {
      this.mesServicesItems = var1;
   }

   public String getTestaffiche() {
      return this.testaffiche;
   }

   public void setTestaffiche(String var1) {
      this.testaffiche = var1;
   }

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public DataModel getDataModelImpgen() {
      return this.dataModelImpgen;
   }

   public void setDataModelImpgen(DataModel var1) {
      this.dataModelImpgen = var1;
   }

   public DataModel getDataModelImpgenFichier() {
      return this.dataModelImpgenFichier;
   }

   public void setDataModelImpgenFichier(DataModel var1) {
      this.dataModelImpgenFichier = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public String getImpDestinataire() {
      return this.impDestinataire;
   }

   public void setImpDestinataire(String var1) {
      this.impDestinataire = var1;
   }

   public String getImpEmetteur() {
      return this.impEmetteur;
   }

   public void setImpEmetteur(String var1) {
      this.impEmetteur = var1;
   }

   public List getTouslesjournauxComptablesItem() {
      return this.touslesjournauxComptablesItem;
   }

   public void setTouslesjournauxComptablesItem(List var1) {
      this.touslesjournauxComptablesItem = var1;
   }

   public DataModel getDatamodelComptes() {
      return this.datamodelComptes;
   }

   public void setDatamodelComptes(DataModel var1) {
      this.datamodelComptes = var1;
   }

   public boolean isShowModalPanelComptes() {
      return this.showModalPanelComptes;
   }

   public void setShowModalPanelComptes(boolean var1) {
      this.showModalPanelComptes = var1;
   }

   public List getTouslesMoisItem() {
      return this.touslesMoisItem;
   }

   public void setTouslesMoisItem(List var1) {
      this.touslesMoisItem = var1;
   }

   public boolean isVar_ctrl_imp() {
      return this.var_ctrl_imp;
   }

   public void setVar_ctrl_imp(boolean var1) {
      this.var_ctrl_imp = var1;
   }

   public boolean isVar_anal_activite() {
      return this.var_anal_activite;
   }

   public void setVar_anal_activite(boolean var1) {
      this.var_anal_activite = var1;
   }

   public boolean isVar_anal_departement() {
      return this.var_anal_departement;
   }

   public void setVar_anal_departement(boolean var1) {
      this.var_anal_departement = var1;
   }

   public int getVar_anal_dossier() {
      return this.var_anal_dossier;
   }

   public void setVar_anal_dossier(int var1) {
      this.var_anal_dossier = var1;
   }

   public boolean isVar_anal_parc() {
      return this.var_anal_parc;
   }

   public void setVar_anal_parc(boolean var1) {
      this.var_anal_parc = var1;
   }

   public boolean isVar_anal_pdv() {
      return this.var_anal_pdv;
   }

   public void setVar_anal_pdv(boolean var1) {
      this.var_anal_pdv = var1;
   }

   public boolean isVar_anal_region() {
      return this.var_anal_region;
   }

   public void setVar_anal_region(boolean var1) {
      this.var_anal_region = var1;
   }

   public boolean isVar_anal_secteur() {
      return this.var_anal_secteur;
   }

   public void setVar_anal_secteur(boolean var1) {
      this.var_anal_secteur = var1;
   }

   public boolean isVar_anal_service() {
      return this.var_anal_service;
   }

   public void setVar_anal_service(boolean var1) {
      this.var_anal_service = var1;
   }

   public boolean isVar_anal_site() {
      return this.var_anal_site;
   }

   public void setVar_anal_site(boolean var1) {
      this.var_anal_site = var1;
   }

   public boolean isVar_anal_agent() {
      return this.var_anal_agent;
   }

   public void setVar_anal_agent(boolean var1) {
      this.var_anal_agent = var1;
   }

   public String getActivite() {
      return this.activite;
   }

   public void setActivite(String var1) {
      this.activite = var1;
   }

   public String getCalculAmortissement() {
      return this.calculAmortissement;
   }

   public void setCalculAmortissement(String var1) {
      this.calculAmortissement = var1;
   }

   public String getCalculEcheance() {
      return this.calculEcheance;
   }

   public void setCalculEcheance(String var1) {
      this.calculEcheance = var1;
   }

   public long getCreateur() {
      return this.createur;
   }

   public void setCreateur(long var1) {
      this.createur = var1;
   }

   public String getDepartement() {
      return this.departement;
   }

   public void setDepartement(String var1) {
      this.departement = var1;
   }

   public String getDossier() {
      return this.dossier;
   }

   public void setDossier(String var1) {
      this.dossier = var1;
   }

   public String getEtat() {
      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public String getFiltreCompteDebut() {
      return this.filtreCompteDebut;
   }

   public void setFiltreCompteDebut(String var1) {
      this.filtreCompteDebut = var1;
   }

   public String getFiltreCompteFin() {
      return this.filtreCompteFin;
   }

   public void setFiltreCompteFin(String var1) {
      this.filtreCompteFin = var1;
   }

   public Date getFiltreDateDebut() {
      return this.filtreDateDebut;
   }

   public void setFiltreDateDebut(Date var1) {
      this.filtreDateDebut = var1;
   }

   public Date getFiltreDateFin() {
      return this.filtreDateFin;
   }

   public void setFiltreDateFin(Date var1) {
      this.filtreDateFin = var1;
   }

   public String getFormat() {
      return this.format;
   }

   public void setFormat(String var1) {
      this.format = var1;
   }

   public boolean isInclureJournauxR() {
      return this.inclureJournauxR;
   }

   public void setInclureJournauxR(boolean var1) {
      this.inclureJournauxR = var1;
   }

   public boolean isInclureJournauxS() {
      return this.inclureJournauxS;
   }

   public void setInclureJournauxS(boolean var1) {
      this.inclureJournauxS = var1;
   }

   public String getJournal() {
      return this.journal;
   }

   public void setJournal(String var1) {
      this.journal = var1;
   }

   public int getNbreCaractere() {
      return this.nbreCaractere;
   }

   public void setNbreCaractere(int var1) {
      this.nbreCaractere = var1;
   }

   public String getNomEtat() {
      return this.nomEtat;
   }

   public void setNomEtat(String var1) {
      this.nomEtat = var1;
   }

   public String getNomRepertoire() {
      return this.nomRepertoire;
   }

   public void setNomRepertoire(String var1) {
      this.nomRepertoire = var1;
   }

   public String getParc() {
      return this.parc;
   }

   public void setParc(String var1) {
      this.parc = var1;
   }

   public String getPdv() {
      return this.pdv;
   }

   public void setPdv(String var1) {
      this.pdv = var1;
   }

   public String getRegion() {
      return this.region;
   }

   public void setRegion(String var1) {
      this.region = var1;
   }

   public String getSecteur() {
      return this.secteur;
   }

   public void setSecteur(String var1) {
      this.secteur = var1;
   }

   public String getService() {
      return this.service;
   }

   public void setService(String var1) {
      this.service = var1;
   }

   public String getSite() {
      return this.site;
   }

   public void setSite(String var1) {
      this.site = var1;
   }

   public String getMois() {
      return this.mois;
   }

   public void setMois(String var1) {
      this.mois = var1;
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

   public String getImpDestinataireCC() {
      return this.impDestinataireCC;
   }

   public void setImpDestinataireCC(String var1) {
      this.impDestinataireCC = var1;
   }

   public String getImpDestinataireCCI() {
      return this.impDestinataireCCI;
   }

   public void setImpDestinataireCCI(String var1) {
      this.impDestinataireCCI = var1;
   }

   public List getMesPeriodesItems() {
      return this.mesPeriodesItems;
   }

   public void setMesPeriodesItems(List var1) {
      this.mesPeriodesItems = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
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

   public String getVar_colonne1() {
      return this.var_colonne1;
   }

   public void setVar_colonne1(String var1) {
      this.var_colonne1 = var1;
   }

   public String getVar_colonne2() {
      return this.var_colonne2;
   }

   public void setVar_colonne2(String var1) {
      this.var_colonne2 = var1;
   }

   public String getVar_colonne3() {
      return this.var_colonne3;
   }

   public void setVar_colonne3(String var1) {
      this.var_colonne3 = var1;
   }

   public int getBudgetMode() {
      return this.budgetMode;
   }

   public void setBudgetMode(int var1) {
      this.budgetMode = var1;
   }

   public int getBudgetSelect() {
      return this.budgetSelect;
   }

   public void setBudgetSelect(int var1) {
      this.budgetSelect = var1;
   }

   public List getMesStructuresItems() {
      return this.mesStructuresItems;
   }

   public void setMesStructuresItems(List var1) {
      this.mesStructuresItems = var1;
   }

   public boolean isVar_anal_str() {
      return this.var_anal_str;
   }

   public void setVar_anal_str(boolean var1) {
      this.var_anal_str = var1;
   }

   public String getStructure() {
      return this.structure;
   }

   public void setStructure(String var1) {
      this.structure = var1;
   }

   public List getLesModelesAutorises() {
      return this.lesModelesAutorises;
   }

   public void setLesModelesAutorises(List var1) {
      this.lesModelesAutorises = var1;
   }

   public String getAnal1() {
      return this.anal1;
   }

   public void setAnal1(String var1) {
      this.anal1 = var1;
   }

   public String getAnal2() {
      return this.anal2;
   }

   public void setAnal2(String var1) {
      this.anal2 = var1;
   }

   public String getAnal3() {
      return this.anal3;
   }

   public void setAnal3(String var1) {
      this.anal3 = var1;
   }

   public String getAnal4() {
      return this.anal4;
   }

   public void setAnal4(String var1) {
      this.anal4 = var1;
   }

   public String getAtelier() {
      return this.atelier;
   }

   public void setAtelier(String var1) {
      this.atelier = var1;
   }

   public String getChantier() {
      return this.chantier;
   }

   public void setChantier(String var1) {
      this.chantier = var1;
   }

   public String getMission() {
      return this.mission;
   }

   public void setMission(String var1) {
      this.mission = var1;
   }

   public boolean isVar_anal_chantier() {
      return this.var_anal_chantier;
   }

   public void setVar_anal_chantier(boolean var1) {
      this.var_anal_chantier = var1;
   }

   public boolean isVar_anal_mission() {
      return this.var_anal_mission;
   }

   public void setVar_anal_mission(boolean var1) {
      this.var_anal_mission = var1;
   }

   public List getMesUsersItems() {
      return this.mesUsersItems;
   }

   public void setMesUsersItems(List var1) {
      this.mesUsersItems = var1;
   }

   public String getSalarie() {
      return this.salarie;
   }

   public void setSalarie(String var1) {
      this.salarie = var1;
   }

   public String getTypeEcriture() {
      return this.typeEcriture;
   }

   public void setTypeEcriture(String var1) {
      this.typeEcriture = var1;
   }

   public String getFiltreActiviteDebut() {
      return this.filtreActiviteDebut;
   }

   public void setFiltreActiviteDebut(String var1) {
      this.filtreActiviteDebut = var1;
   }

   public String getFiltreActiviteFin() {
      return this.filtreActiviteFin;
   }

   public void setFiltreActiviteFin(String var1) {
      this.filtreActiviteFin = var1;
   }

   public String getFiltreChantierDebut() {
      return this.filtreChantierDebut;
   }

   public void setFiltreChantierDebut(String var1) {
      this.filtreChantierDebut = var1;
   }

   public String getFiltreChantierFin() {
      return this.filtreChantierFin;
   }

   public void setFiltreChantierFin(String var1) {
      this.filtreChantierFin = var1;
   }
}
