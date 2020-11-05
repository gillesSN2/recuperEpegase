package com.epegase.forms.paye;

import com.epegase.systeme.classe.BulletinLigne;
import com.epegase.systeme.classe.BulletinSalaire;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.ContratEnteteVentes;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.PlanPaye;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesContrats;
import com.epegase.systeme.classe.SalariesElements;
import com.epegase.systeme.classe.SalariesHistorique;
import com.epegase.systeme.classe.SalariesPointage;
import com.epegase.systeme.classe.SalariesVariables;
import com.epegase.systeme.classe.Service;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.ObjetCp;
import com.epegase.systeme.control.ObjetCtrlAgent;
import com.epegase.systeme.control.ObjetIsr;
import com.epegase.systeme.control.ObjetTable;
import com.epegase.systeme.control.ObjetTempsFactures;
import com.epegase.systeme.control.TransfertPaye;
import com.epegase.systeme.dao.BulletinLigneDao;
import com.epegase.systeme.dao.BulletinSalaireDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.ContratEnteteVentesDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.ExercicesPayeDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.PlanPayeDao;
import com.epegase.systeme.dao.SalariesContratsDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.SalariesHistoriqueDao;
import com.epegase.systeme.dao.SalariesPointageDao;
import com.epegase.systeme.dao.SalariesVariablesDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TachesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.xml.LectureConventions;
import com.epegase.systeme.xml.LectureGrilleSalaire;
import com.epegase.systeme.xml.ObjetConvention;
import com.epegase.systeme.xml.OptionPaye;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import jxl.CellView;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class FormImpressionPaye {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private ExercicesPaye exoSelectionne;
   private OptionPaye optionPaye;
   private UtilDate utilDate;
   private boolean showModalPanelBordereau = false;
   private List lesRepImpression = new ArrayList();
   private transient DataModel dataModelImpgen = new ListDataModel();
   private List lesFichImpression = new ArrayList();
   private transient DataModel dataModelImpgenFichier = new ListDataModel();
   private boolean testafficheLigne = false;
   private boolean testafficheDocument = false;
   private boolean testafficheDocumentUser = false;
   private UsersChronoDao usersChronoDao;
   private int nature;
   private String nomRepertoire;
   private String nomEtat = "";
   private boolean interim;
   private String periode;
   private List mesPeriodesItems = new ArrayList();
   private Date filtreDateDebut;
   private Date filtreDateFin;
   private String nomSalarie;
   private String matricule;
   private int etatSalarie = 100;
   private int modeExportation = 0;
   private String libelleEtat;
   private String site;
   private String departement;
   private String[] listeService = new String[]{""};
   private String service;
   private String projet;
   private String parc;
   private String activite;
   private String[] listeActivite = new String[]{""};
   private String localisation;
   private String convention;
   private String grille;
   private String centre;
   private String securite;
   private String feuille;
   private String classement;
   private String natureSalarie;
   private String natureAutorisee;
   private String niveauEmploi;
   private String pays;
   private String nationnalite;
   private String budget;
   private String lot;
   private String banqueSal;
   private String[] listeBanque = new String[]{""};
   private String banqueSociete;
   private String rubrique;
   private String natureRubrique;
   private long tiers;
   private String[] listeClients = new String[]{"0"};
   private String nomtiers;
   private String var_entete;
   private String var_filtre;
   private String var_requete;
   private int selectionMode;
   private List mesNatureAgentItems;
   private List mesCentresImpotsItems;
   private List mesCentresSecuritesItems;
   private List mesClassementsItems;
   private List mesNiveauxEmploisItems;
   private List mesConventionsItems;
   private List mesGrillesItems;
   private List mesPaysItems;
   private List mesNationnalitesItems;
   private List mesLanguesItems;
   private List mesActiviteItems;
   private List mesLocalisationItems;
   private List mesBudgetItems;
   private List mesProjetItems;
   private List mesParcItems;
   private List mesFeuillesItems;
   private List mesClesItems;
   private List mesSecteursItems = new ArrayList();
   private List mesSitesItems;
   private List mesDepartementsItems = new ArrayList();
   private List mesServicesItems = new ArrayList();
   private List mesRubriquesItems;
   private List mesNatureRubriqueItems;
   private List mesBanqueItems;
   private List mesBanqueAgentsItems;
   private boolean var_anal_activite = false;
   private boolean var_anal_parc = false;
   private boolean var_anal_site = false;
   private boolean var_anal_departement = false;
   private boolean var_anal_service = false;
   private boolean var_anal_agent = false;
   private UtilPrint utilPrint;
   private boolean affMail = false;
   private String format = "PDF";
   private boolean var_affiche_impression = false;
   private String impDestinataire;
   private String impDestinataireCC;
   private String impDestinataireCCI;
   private String impEmetteur;
   private boolean showModalPanelSalaries = false;
   private transient DataModel datamodelSalaries = new ListDataModel();
   private Salaries salaries;
   private PlansAnalytiques plansAnalytiques;
   private boolean decoupageActivite = false;
   private List laColonne1Items;
   private List laColonne2Items;
   private List laColonne3Items;
   private String var_colonne1;
   private String var_colonne2;
   private String var_colonne3;
   private ObjetIsr objetIsr;
   private List lesIsr;
   private ObjetCp objetCp;
   private List lesCp;
   private ObjetCtrlAgent objetCtrl;
   private List lesCtrl;
   private int nbSalEmbauche;
   private int nbSaloccasionnel;
   private int nbSalAdherent;
   private int nbSalNonAdherent;
   private String rubITS;
   private int nbsalMoins1000000;
   private int nbSamPlus1000000;
   private double totSalMoins1000000;
   private double totSalPlus1000000;
   private List lesVirements;
   private boolean afficheFichierExport = false;
   private boolean testafficheExport = false;
   private String cheminExportOrigine;
   private String cheminExportDestination;
   private String fichierMine;
   private URL fichierUrl;
   private String nomFichier;
   private Element racine;
   private Document document;
   private Chrono chronoTransfert;
   private UtilNombre utilNombre;
   private String urlExplorateur;
   private List lesTrfPaye;
   private List lesModelesAutorises;
   private Tiers tiersRec;
   private TiersDao tiersDao;
   private float tauxCss;
   private transient DataModel datamodelColonnes;
   private List lesColonnes;
   private List lesColonnesChoisies;
   private String chaineColonne;
   private long idTiersRec;
   private String missionRec;
   private String tacheRec;
   private long salarieRec;
   private List mesTiersItems;
   private List mesMisisonsItems;
   private List mesTachesItems;
   private List mesSalarieItems;
   private List lesComparatifTF;

   public FormImpressionPaye() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.utilDate = new UtilDate();
      this.objetIsr = new ObjetIsr();
      this.lesIsr = new ArrayList();
      this.lesVirements = new ArrayList();
      this.lesTrfPaye = new ArrayList();
      this.utilNombre = new UtilNombre();
      this.datamodelColonnes = new ListDataModel();
      this.lesColonnes = new ArrayList();
      this.lesColonnesChoisies = new ArrayList();
      this.mesTiersItems = new ArrayList();
      this.mesMisisonsItems = new ArrayList();
      this.mesTachesItems = new ArrayList();
      this.mesSalarieItems = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
   }

   public void chargerLesRepImpPaye(Session var1) {
      this.lesRepImpression.clear();
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "salarie";
      File var3 = new File(var2);
      if (!var3.exists()) {
         var3.mkdir();
      }

      String[] var4 = var3.list();
      int var5;
      if (var4 != null) {
         var4 = this.triAlphabetique(var4, var4.length);

         for(var5 = 0; var5 < var4.length; ++var5) {
            if (!var4[var5].equalsIgnoreCase(".svn") && !var4[var5].equalsIgnoreCase("index.html")) {
               String var6 = "";
               var6 = var4[var5].toUpperCase();
               this.lesRepImpression.add(var6);
            }
         }

         boolean var8 = false;

         for(int var9 = 0; var9 < this.lesRepImpression.size(); ++var9) {
            if (((String)this.lesRepImpression.get(var9)).toString().contains("06-utilisateurs".toUpperCase())) {
               var8 = true;
            }
         }

         if (!var8) {
            this.lesRepImpression.add("06-utilisateurs".toUpperCase());
         }

         boolean var10 = false;

         for(int var7 = 0; var7 < this.lesRepImpression.size(); ++var7) {
            if (((String)this.lesRepImpression.get(var7)).toString().contains("90-exportations".toUpperCase())) {
               var10 = true;
            }
         }

         if (!var10) {
            this.lesRepImpression.add("90-exportations".toUpperCase());
         }
      }

      this.dataModelImpgen.setWrappedData(this.lesRepImpression);
      this.selectionMode();
      if (this.mesNatureAgentItems.size() != 0) {
         for(var5 = 0; var5 < this.mesNatureAgentItems.size(); ++var5) {
            if (((SelectItem)this.mesNatureAgentItems.get(var5)).getValue().toString() != null && !((SelectItem)this.mesNatureAgentItems.get(var5)).getValue().toString().isEmpty()) {
               if (this.natureAutorisee != null && !this.natureAutorisee.isEmpty()) {
                  this.natureAutorisee = this.natureAutorisee + "," + "'" + ((SelectItem)this.mesNatureAgentItems.get(var5)).getValue().toString() + "'";
               } else {
                  this.natureAutorisee = "'" + ((SelectItem)this.mesNatureAgentItems.get(var5)).getValue().toString() + "'";
               }
            }
         }
      }

   }

   public void chargerLesRepImpTemps(Session var1) {
      this.lesRepImpression.clear();
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "temps";
      File var3 = new File(var2);
      if (!var3.exists()) {
         var3.mkdir();
      }

      String[] var4 = var3.list();
      int var5;
      if (var4 != null) {
         var4 = this.triAlphabetique(var4, var4.length);

         for(var5 = 0; var5 < var4.length; ++var5) {
            if (!var4[var5].equalsIgnoreCase(".svn") && !var4[var5].equalsIgnoreCase("index.html")) {
               String var6 = "";
               var6 = var4[var5].toUpperCase();
               this.lesRepImpression.add(var6);
            }
         }
      }

      this.dataModelImpgen.setWrappedData(this.lesRepImpression);
      this.selectionMode();
      if (this.mesNatureAgentItems.size() != 0) {
         for(var5 = 0; var5 < this.mesNatureAgentItems.size(); ++var5) {
            if (((SelectItem)this.mesNatureAgentItems.get(var5)).getValue().toString() != null && !((SelectItem)this.mesNatureAgentItems.get(var5)).getValue().toString().isEmpty()) {
               if (this.natureAutorisee != null && !this.natureAutorisee.isEmpty()) {
                  this.natureAutorisee = this.natureAutorisee + "," + "'" + ((SelectItem)this.mesNatureAgentItems.get(var5)).getValue().toString() + "'";
               } else {
                  this.natureAutorisee = "'" + ((SelectItem)this.mesNatureAgentItems.get(var5)).getValue().toString() + "'";
               }
            }
         }
      }

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

   public void calculeAnalytique() {
      this.var_anal_activite = false;
      this.var_anal_site = false;
      this.var_anal_departement = false;
      this.var_anal_service = false;
      this.var_anal_parc = false;
      this.var_anal_agent = false;
      if (this.optionPaye.getAxeActivite().equals("true")) {
         this.var_anal_activite = true;
      }

      if (this.optionPaye.getAxeSite().equals("true")) {
         this.var_anal_site = true;
         this.var_anal_departement = true;
         this.var_anal_service = true;
      }

      if (this.optionPaye.getAxeParc().equals("true")) {
         this.var_anal_parc = true;
      }

      if (this.optionPaye.getAxeAgent().equals("true")) {
         this.var_anal_agent = true;
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

   public void chargerServiceClient() throws HibernateException, NamingException {
      this.mesServicesItems.clear();
      String var1 = this.calculeClients();
      List var2;
      SiteDao var3;
      int var4;
      if (var1 != null && !var1.isEmpty()) {
         new ArrayList();
         var3 = new SiteDao(this.baseLog, this.utilInitHibernate);
         var2 = var3.chargerLesSitesListByClient(var1.replace("|", ","), (Session)null);
         if (var2.size() != 0) {
            for(var4 = 0; var4 < var2.size(); ++var4) {
               this.mesServicesItems.add(new SelectItem(((Site)var2.get(var4)).getSitCode() + ":" + ((Site)var2.get(var4)).getSitNomFr()));
            }
         }
      } else {
         new ArrayList();
         var3 = new SiteDao(this.baseLog, this.utilInitHibernate);
         var2 = var3.chargerLesSitesList((Session)null);
         if (var2.size() != 0) {
            for(var4 = 0; var4 < var2.size(); ++var4) {
               this.mesServicesItems.add(new SelectItem(((Site)var2.get(var4)).getSitCode() + ":" + ((Site)var2.get(var4)).getSitNomFr()));
            }
         }
      }

   }

   public void selectionMode() {
      if (this.rechercheModule(40300)) {
         this.selectionMode = 2;
      } else {
         this.selectionMode = 1;
      }

      this.interim = this.rechercheModule(80400);
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

   public void rechercheSalarie() throws HibernateException, NamingException {
      new ArrayList();
      SalariesDao var2 = new SalariesDao(this.baseLog, this.utilInitHibernate);
      List var1 = var2.chargerlesSalaries(this.nomSalarie, this.etatSalarie, (Session)null);
      this.datamodelSalaries.setWrappedData(var1);
      if (var1.size() != 0) {
         this.showModalPanelSalaries = true;
      } else {
         this.nomSalarie = "";
      }

   }

   public void selectionSalarie() {
      if (this.datamodelSalaries.isRowAvailable()) {
         this.salaries = (Salaries)this.datamodelSalaries.getRowData();
      }

   }

   public void annuleSalarie() {
      this.showModalPanelSalaries = false;
   }

   public void calculeSalarie() {
      this.nomSalarie = this.salaries.getSalMatricule();
      this.showModalPanelSalaries = false;
   }

   public void recupererThesaurus() throws IOException, HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ImpressionPaye");
      SalariesContratsDao var2 = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
      BulletinLigneDao var3 = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
      this.mesCentresImpotsItems = new ArrayList();
      this.mesCentresImpotsItems = var2.chargerLesContratGroupCentre(var1);
      this.mesCentresSecuritesItems = new ArrayList();
      if (this.structureLog.getStrNumSecuMultiple() == 1) {
         this.mesCentresSecuritesItems = var2.chargerLesContratGroupCentreSecurite(var1);
      }

      this.mesClassementsItems = new ArrayList();
      this.mesClassementsItems = var2.chargerLesContratGroupClassement(var1);
      this.mesNiveauxEmploisItems = new ArrayList();
      this.mesNiveauxEmploisItems = var2.chargerLesContratGroupNiveau(var1);
      this.mesConventionsItems = new ArrayList();
      this.mesConventionsItems = var2.chargerLesContratGroupConvention(var1);
      this.mesGrillesItems = new ArrayList();
      this.mesGrillesItems = var2.chargerLesContratGroupGrille(var1);
      this.mesServicesItems = new ArrayList();
      this.mesServicesItems = var2.chargerLesContratGroupService(var1);
      this.mesActiviteItems = new ArrayList();
      this.mesActiviteItems = var2.chargerLesContratGroupActivite(var1);
      this.mesSitesItems = new ArrayList();
      this.mesSitesItems = var2.chargerLesContratGroupSite(var1);
      this.mesBudgetItems = new ArrayList();
      this.mesBudgetItems = var2.chargerLesContratGroupBudget(var1);
      this.mesProjetItems = new ArrayList();
      this.mesProjetItems = var2.chargerLesContratGroupProjet(var1);
      this.mesParcItems = new ArrayList();
      this.mesParcItems = var2.chargerLesContratGroupParc(var1);
      this.mesRubriquesItems = new ArrayList();
      this.mesRubriquesItems = var3.chargerLesContratGroupRubique(this.exoSelectionne, var1);
      this.utilInitHibernate.closeSession();
   }

   public void recupererNomrep() throws HibernateException, NamingException {
      this.testafficheLigne = false;
      if (this.dataModelImpgen.isRowAvailable()) {
         this.nomRepertoire = (String)this.dataModelImpgen.getRowData();
         this.nomRepertoire = this.nomRepertoire.toLowerCase();
         this.nomEtat = "";
         if (!this.nomRepertoire.equals("04-ressources_humaines") && !this.nomRepertoire.equals("05-contrat")) {
            this.testafficheDocument = false;
         } else {
            this.testafficheDocument = true;
         }

         this.lesFichImpression.clear();
         String var1 = null;
         this.testafficheDocumentUser = false;
         this.lesColonnes.clear();
         this.datamodelColonnes.setWrappedData(this.lesColonnes);
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "salarie" + File.separator + this.nomRepertoire;
         this.testafficheLigne = false;
         File var2 = new File(var1);
         if (!var2.exists()) {
            var2.mkdir();
         }

         if (this.nomRepertoire.equals("90-exportations")) {
            this.testafficheExport = true;
            if (this.verificationAutorisation("0:Export modèle simple")) {
               this.lesFichImpression.add("0:Export modèle simple");
            }

            if (this.verificationAutorisation("1:Export modèle (BIS)")) {
               this.lesFichImpression.add("1:Export modèle (BIS)");
            }

            if (this.verificationAutorisation("2:Export modèle AFB120")) {
               this.lesFichImpression.add("2:Export modèle AFB120");
            }

            if (this.verificationAutorisation("3:Export modèle AFB160")) {
               this.lesFichImpression.add("3:Export modèle AFB160");
            }

            if (this.verificationAutorisation("4:Export modèle MicroFinance")) {
               this.lesFichImpression.add("4:Export modèle MicroFinance");
            }

            if (this.verificationAutorisation("5:Export modèle OrangeMoney")) {
               this.lesFichImpression.add("5:Export modèle OrangeMoney");
            }

            if (this.verificationAutorisation("6:Export modèle (CBAO)")) {
               this.lesFichImpression.add("6:Export modèle (CBAO)");
            }

            if (this.structureLog.getStrcodepays().equals("0077")) {
               if (this.verificationAutorisation("20:Export DTS CNSS")) {
                  this.lesFichImpression.add("20:Export DTS CNSS");
               }

               if (this.verificationAutorisation("21:Export DTS CNAMGS")) {
                  this.lesFichImpression.add("21:Export DTS CNAMGS");
               }
            }
         } else {
            if (this.nomRepertoire.equals("06-utilisateurs")) {
               this.testafficheExport = true;
               if (this.verificationAutorisation("colonnes_contrats")) {
                  this.lesFichImpression.add("colonnes_contrats");
               }

               if (this.verificationAutorisation("colonnes_salaries")) {
                  this.lesFichImpression.add("colonnes_salaries");
               }

               if (this.verificationAutorisation("colonnes_bulletins")) {
                  this.lesFichImpression.add("colonnes_bulletins");
               }
            } else {
               this.testafficheExport = false;
            }

            String[] var3 = var2.list();
            String var6;
            if (var3 != null) {
               var3 = this.triAlphabetique(var3, var3.length);

               for(int var4 = 0; var4 < var3.length; ++var4) {
                  if (var3[var4].endsWith("jasper")) {
                     String var5 = var3[var4];
                     if (this.verificationAutorisation(var5)) {
                        var6 = var3[var4].substring(0, var3[var4].indexOf("."));
                        if (!var6.startsWith("Lot_")) {
                           this.lesFichImpression.add(var6);
                        }
                     }
                  }
               }
            }

            var1 = StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "pays" + File.separator + this.structureLog.getStrcodepays() + File.separator + this.nomRepertoire;
            this.testafficheLigne = false;
            var2 = new File(var1);
            if (var2.exists()) {
               String[] var8 = var2.list();
               var8 = this.triAlphabetique(var8, var8.length);

               for(int var9 = 0; var9 < var8.length; ++var9) {
                  if (var8[var9].endsWith("jasper")) {
                     var6 = var8[var9];
                     if (this.verificationAutorisation(var6)) {
                        String var7 = var8[var9].substring(0, var8[var9].indexOf("."));
                        this.lesFichImpression.add(var7);
                     }
                  }
               }
            }
         }

         this.dataModelImpgenFichier.setWrappedData(this.lesFichImpression);
         this.var_affiche_impression = true;
         this.afficheFichierExport = false;
      }

   }

   public void recupererNomrepTemps() throws HibernateException, NamingException {
      this.testafficheLigne = false;
      if (this.dataModelImpgen.isRowAvailable()) {
         this.nomRepertoire = (String)this.dataModelImpgen.getRowData();
         this.nomRepertoire = this.nomRepertoire.toLowerCase();
         this.nomEtat = "";
         this.lesFichImpression.clear();
         String var1 = null;
         this.testafficheDocumentUser = false;
         this.lesColonnes.clear();
         this.datamodelColonnes.setWrappedData(this.lesColonnes);
         var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "temps" + File.separator + this.nomRepertoire;
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

         this.dataModelImpgenFichier.setWrappedData(this.lesFichImpression);
         this.var_affiche_impression = true;
         this.afficheFichierExport = false;
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

   public void recupererNomfich() throws ParseException, HibernateException, NamingException {
      if (this.dataModelImpgenFichier.isRowAvailable()) {
         this.nomEtat = (String)this.dataModelImpgenFichier.getRowData();
         this.filtreDateDebut = this.exoSelectionne.getExepayDateDebut();
         this.filtreDateFin = this.exoSelectionne.getExepayDateFin();
         this.var_affiche_impression = true;
         this.afficheFichierExport = false;
         this.calculeDates();
         if (this.nomRepertoire.equals("06-utilisateurs")) {
            this.testafficheDocumentUser = true;
         } else {
            this.testafficheDocumentUser = false;
         }

         this.lesColonnes.clear();
         if (this.testafficheDocumentUser) {
            String var1 = "Paye";
            String var2 = "";
            if (this.nomEtat.equals("colonnes_contrats")) {
               var2 = "pay_salaries_contrats";
            } else if (this.nomEtat.equals("colonnes_salaries")) {
               var2 = "pay_salaries";
            } else if (this.nomEtat.equals("colonnes_bulletins")) {
               var2 = "pay_bulletin_ligne";
            }

            Session var3 = this.utilInitHibernate.getOpenSessionModule(this.baseLog, var1);
            List var4 = var3.createSQLQuery("SELECT COLUMN_NAME FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var2 + "'").list();
            List var5 = var3.createSQLQuery("SELECT COLUMN_COMMENT FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME='" + var2 + "'").list();
            if (var4.size() != 0 && var5.size() != 0) {
               for(int var6 = 0; var6 < var4.size(); ++var6) {
                  String var7 = var4.get(var6).toString();
                  String var8 = var5.get(var6).toString();
                  String var9 = "";
                  String var10 = "";
                  ObjetTable var11 = new ObjetTable();
                  var11.setIndice(var6);
                  var11.setColumn_name(var7);
                  var11.setColumn_comment(var8);
                  this.lesColonnes.add(var11);
               }

               ObjetTable var12;
               if (this.nomEtat.equals("colonnes_contrats")) {
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_salaries.sal_matricule");
                  var12.setColumn_comment("salarié: matricule");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_salaries.sal_nom");
                  var12.setColumn_comment("salarié: nom");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_salaries.sal_prenom");
                  var12.setColumn_comment("salarié: prenom");
                  this.lesColonnes.add(var12);
               } else if (this.nomEtat.equals("colonnes_bulletins")) {
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_salaries.sal_matricule");
                  var12.setColumn_comment("salarié: matricule");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_salaries.sal_nom");
                  var12.setColumn_comment("salarié: nom");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_salaries.sal_prenom");
                  var12.setColumn_comment("salarié: prenom");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_feuille");
                  var12.setColumn_comment("bulletin: feuille");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_contrat");
                  var12.setColumn_comment("bulletin: contrat");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_periode");
                  var12.setColumn_comment("bulletin: periode");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_date_debut");
                  var12.setColumn_comment("bulletin: date debut");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_date_fin");
                  var12.setColumn_comment("bulletin: date fin");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_nature");
                  var12.setColumn_comment("bulletin: nature");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_etat");
                  var12.setColumn_comment("bulletin: etat");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_fonction");
                  var12.setColumn_comment("bulletin: fonction");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_id_tiers");
                  var12.setColumn_comment("bulletin: tiers");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_projet");
                  var12.setColumn_comment("bulletin: projet");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_site");
                  var12.setColumn_comment("bulletin: site");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_departement");
                  var12.setColumn_comment("bulletin: departement");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_service");
                  var12.setColumn_comment("bulletin: service");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_lib_service");
                  var12.setColumn_comment("bulletin: libellé service");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_acticvite");
                  var12.setColumn_comment("bulletin: activite");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_localisation");
                  var12.setColumn_comment("bulletin: localisation");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_budget");
                  var12.setColumn_comment("bulletin: budget");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_parc");
                  var12.setColumn_comment("bulletin: parc");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_genre");
                  var12.setColumn_comment("bulletin: genre");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_sit_famille");
                  var12.setColumn_comment("bulletin: situation de famille");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_nb_enfant");
                  var12.setColumn_comment("bulletin: nombre enfants");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_nb_part_fiscal");
                  var12.setColumn_comment("bulletin: nombre part fiscale");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_nb_femme");
                  var12.setColumn_comment("bulletin: nombre femme");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_nb_part_trimf");
                  var12.setColumn_comment("bulletin: nombre part TRIMF");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_nb_jour_tr");
                  var12.setColumn_comment("bulletin: nombre jours congés");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_nb_jour_cp");
                  var12.setColumn_comment("bulletin: nombre jours travail");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_date_entree");
                  var12.setColumn_comment("bulletin: date entrée");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_date_sortie");
                  var12.setColumn_comment("bulletin: date sortie");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_motif_sortie");
                  var12.setColumn_comment("bulletin: motif sortie");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_convention");
                  var12.setColumn_comment("bulletin: convention");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_lib_convention");
                  var12.setColumn_comment("bulletin: libellé convention");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_Cod_Centres_Impots");
                  var12.setColumn_comment("bulletin: centres impots");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_Lib_Centres_Impots");
                  var12.setColumn_comment("bulletin: libellé centres impots");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_centres_securite");
                  var12.setColumn_comment("bulletin: centres sécurité sociale");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_lib_centres_securite");
                  var12.setColumn_comment("bulletin: libellé centres sécurités sociales");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_classement");
                  var12.setColumn_comment("bulletin: classement");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_lib_classement");
                  var12.setColumn_comment("bulletin: libellé classement");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_niv_emploi");
                  var12.setColumn_comment("bulletin: niveau emploi");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_lib_niv_emploi");
                  var12.setColumn_comment("bulletin: libellé niveau emploi");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_grille");
                  var12.setColumn_comment("bulletin: grille");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_lib_grille");
                  var12.setColumn_comment("bulletin: libellé grille");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_av_nat");
                  var12.setColumn_comment("bulletin: avantage en nature");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_brut");
                  var12.setColumn_comment("bulletin: brut");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_base_reference");
                  var12.setColumn_comment("bulletin: base référence");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_type_cp");
                  var12.setColumn_comment("bulletin: base cp");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_cp");
                  var12.setColumn_comment("bulletin: cp");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_nb_cp_pris");
                  var12.setColumn_comment("bulletin: nb cp pris");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_nb_cp_acquis");
                  var12.setColumn_comment("bulletin: nb cp acquis");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_nb_cp_feries");
                  var12.setColumn_comment("bulletin: nb jours féries");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_nb_dispo");
                  var12.setColumn_comment("bulletin: nb jours dispo.");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_base_imposable_fiscale");
                  var12.setColumn_comment("bulletin: base imposable fiscale");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_base_imposable_sociale");
                  var12.setColumn_comment("bulletin: base imposable sociale");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_net_payer");
                  var12.setColumn_comment("bulletin: net à payer");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_impot1");
                  var12.setColumn_comment("bulletin: impot 1");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_impot2");
                  var12.setColumn_comment("bulletin: impot 2");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_impot3");
                  var12.setColumn_comment("bulletin: impot 3");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_impot4");
                  var12.setColumn_comment("bulletin: impot 4");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_impot5");
                  var12.setColumn_comment("bulletin: impot 5");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_impot6");
                  var12.setColumn_comment("bulletin: impot 6");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_impot7");
                  var12.setColumn_comment("bulletin: impot 7");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_impot8");
                  var12.setColumn_comment("bulletin: impot 8");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_impot9");
                  var12.setColumn_comment("bulletin: impot 9");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_impot10");
                  var12.setColumn_comment("bulletin: impot 10");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_date_transfert");
                  var12.setColumn_comment("bulletin: date transfert");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_cle1_anal");
                  var12.setColumn_comment("bulletin: cle analytique 1");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_cle2_anal");
                  var12.setColumn_comment("bulletin: cle analytique 2");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_mode_reglement");
                  var12.setColumn_comment("bulletin: mode de règlement");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_num_banque");
                  var12.setColumn_comment("bulletin: code banque");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_guichet_banque");
                  var12.setColumn_comment("bulletin: code guichet");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_compte_banque");
                  var12.setColumn_comment("bulletin: compte");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_cle_banque");
                  var12.setColumn_comment("bulletin: clé rib");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_iban");
                  var12.setColumn_comment("bulletin: iban");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_swift");
                  var12.setColumn_comment("bulletin: swift");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_compte_membre");
                  var12.setColumn_comment("bulletin: compte membre");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_manuel");
                  var12.setColumn_comment("bulletin: bulletin manuel");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_date_impression");
                  var12.setColumn_comment("bulletin: date impression");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_lot");
                  var12.setColumn_comment("bulletin: numéro lot");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_secu1");
                  var12.setColumn_comment("bulletin: numéro sécurité 1");
                  this.lesColonnes.add(var12);
                  var12 = new ObjetTable();
                  var12.setIndice(this.lesColonnes.size() + 1);
                  var12.setColumn_name("pay_bulletin_salaire.bulsal_secu2");
                  var12.setColumn_comment("bulletin: numéro sécurité 2");
                  this.lesColonnes.add(var12);
               }
            }
         }

         this.datamodelColonnes.setWrappedData(this.lesColonnes);
      }

   }

   public void recupererNomfichTemps() throws ParseException, HibernateException, NamingException {
      if (this.dataModelImpgenFichier.isRowAvailable()) {
         this.nomEtat = (String)this.dataModelImpgenFichier.getRowData();
         this.filtreDateDebut = this.exoSelectionne.getExepayDateDebut();
         this.filtreDateFin = this.exoSelectionne.getExepayDateFin();
         this.var_affiche_impression = true;
         this.afficheFichierExport = false;
         this.calculeDates();
      }

   }

   public void chargerGrille() {
      this.mesGrillesItems.clear();
      if (this.convention != null && !this.convention.isEmpty() && !this.convention.equals("100") && this.convention.contains(":")) {
         String[] var1 = this.convention.split(":");
         LectureGrilleSalaire var2 = new LectureGrilleSalaire();
         var2.setStrId(this.structureLog.getStrid());
         var2.setStructureLog(this.structureLog);
         var2.recuperePaye(var1[0]);
         this.mesGrillesItems = var2.getMesGrillesSalairesItems();
      }

   }

   public void openBordereau() {
      this.showModalPanelBordereau = true;
   }

   public void majBordereau() throws HibernateException, NamingException {
      ExercicesPayeDao var1 = new ExercicesPayeDao(this.baseLog, this.utilInitHibernate);
      this.exoSelectionne = var1.modif(this.exoSelectionne);
      this.showModalPanelBordereau = false;
   }

   public void closeBordereaux() {
      this.showModalPanelBordereau = false;
   }

   public void chargerElementsTemps(Session var1) throws HibernateException, NamingException {
      this.mesTiersItems = this.tiersDao.chargerLesClientsByIdItems(1, var1);
      this.mesMisisonsItems.clear();
      this.mesTachesItems.clear();
      TachesDao var2 = new TachesDao(this.baseLog, this.utilInitHibernate);
      this.mesTachesItems = var2.selectTachesActifItem(var1);
      this.mesSalarieItems.clear();
      SalariesDao var3 = new SalariesDao(this.baseLog, this.utilInitHibernate);
      this.mesSalarieItems = var3.chargerlesSalariesActifItem("", var1);
   }

   public void calculeMission() throws HibernateException, NamingException {
      this.mesMisisonsItems.clear();
      if (this.idTiersRec != 0L) {
         ContratEnteteVentesDao var1 = new ContratEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         this.tiersRec = this.tiersDao.selectTierD(this.idTiersRec);
         if (this.tiersRec != null) {
            new ArrayList();
            List var2 = var1.rechercheByTiers(this.tiersRec, (Session)null);
            if (var2.size() != 0) {
               for(int var3 = 0; var3 < var2.size(); ++var3) {
                  this.mesMisisonsItems.add(new SelectItem(((ContratEnteteVentes)var2.get(var3)).getCrtNum()));
               }
            }
         }
      }

   }

   public void chargerPeriodes() throws ParseException {
      this.mesPeriodesItems.clear();
      this.mesPeriodesItems.add(new SelectItem(""));
      Date var1 = this.exoSelectionne.getExepayDateDebut();
      GregorianCalendar var2 = new GregorianCalendar();
      var2.setTime(var1);
      Date var3 = this.exoSelectionne.getExepayDateFin();
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

   public void initImpression() {
      this.utilPrint = new UtilPrint(this.utilInitHibernate);
      this.affMail = false;
   }

   public void imprimerEXP() throws SQLException, JRException, IOException, MalformedURLException, Exception {
      this.affMail = false;
      this.format = "EXP";
      this.imprimer();
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
      this.nbSalEmbauche = 0;
      this.nbSaloccasionnel = 0;
      this.nbSalAdherent = 0;
      this.nbSalNonAdherent = 0;
      this.nbSamPlus1000000 = 0;
      this.nbsalMoins1000000 = 0;
      this.totSalMoins1000000 = 0.0D;
      this.totSalPlus1000000 = 0.0D;
      this.rubITS = null;
      if (this.nomRepertoire != null && !this.nomRepertoire.isEmpty() && this.nomEtat != null && !this.nomEtat.isEmpty()) {
         this.calculeRequete();
         if (this.nomRepertoire.equalsIgnoreCase("90-exportations")) {
            this.exportationsVirements(this.urlExplorateur);
         } else if (this.nomRepertoire.equalsIgnoreCase("06-utilisateurs") && this.nomEtat.startsWith("colonnes_")) {
            this.exportationsColonnes(this.urlExplorateur);
         } else {
            this.utilPrint.setRapport(this.nomEtat);
            if (!this.nomEtat.startsWith("*") && !this.nomEtat.startsWith("-")) {
               if (this.nomRepertoire.equalsIgnoreCase("temps")) {
                  this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "temps" + File.separator + this.nomRepertoire + File.separator);
                  this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
               } else {
                  this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "salarie" + File.separator + this.nomRepertoire + File.separator);
                  this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
               }
            } else {
               this.utilPrint.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "pays" + File.separator + this.structureLog.getStrcodepays() + File.separator + this.nomRepertoire + File.separator);
               this.utilPrint.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "impression" + File.separator + "fr" + File.separator + "paye" + File.separator + "sous_rapport" + File.separator);
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

            this.utilPrint.setRequete(this.var_requete);
            this.utilPrint.setAnnexe2(this.rubITS);
            this.utilPrint.setExercice(this.exoSelectionne.getExepayId());
            this.utilPrint.setValeur1(this.exoSelectionne.getExepayRedevance());
            JRBeanCollectionDataSource var1;
            if (this.nomEtat.contains("(ISR)")) {
               var1 = new JRBeanCollectionDataSource(this.lesIsr);
               this.utilPrint.setjRBeanCollectionDataSource(var1);
               this.utilPrint.setRequete("");
            } else if (!this.nomEtat.contains("(CP)") && !this.nomEtat.contains("(BASE_CONGES)")) {
               if (this.nomEtat.contains("AgentControle")) {
                  var1 = new JRBeanCollectionDataSource(this.lesCtrl);
                  this.utilPrint.setjRBeanCollectionDataSource(var1);
                  this.utilPrint.setRequete("");
               } else if (this.nomEtat.contains("Temps_facturation")) {
                  var1 = new JRBeanCollectionDataSource(this.lesComparatifTF);
                  this.utilPrint.setjRBeanCollectionDataSource(var1);
                  this.utilPrint.setRequete("");
               } else {
                  ArrayList var3 = new ArrayList();
                  JRBeanCollectionDataSource var2 = new JRBeanCollectionDataSource(var3);
                  this.utilPrint.setjRBeanCollectionDataSource(var2);
               }
            } else {
               var1 = new JRBeanCollectionDataSource(this.lesCp);
               this.utilPrint.setjRBeanCollectionDataSource(var1);
               this.utilPrint.setRequete("");
            }

            this.utilPrint.setFormat(this.format);
            this.utilPrint.setDateDeb(this.filtreDateDebut);
            this.utilPrint.setDateFin(this.filtreDateFin);
            this.utilPrint.setEmetteur(this.impEmetteur);
            this.utilPrint.setDestinataire(this.impDestinataire);
            this.utilPrint.setDestinataireCC(this.impDestinataireCC);
            this.utilPrint.setDestinataireCCI(this.impDestinataireCCI);
            this.utilPrint.setInfoOrigineDoc(this.banqueSociete);
            this.utilPrint.setAdresseFacturation(this.calculeContactBanque(this.banqueSociete));
            this.utilPrint.setEtat_init(0);
            this.utilPrint.setVar_nom_col1("" + this.nbSalEmbauche);
            this.utilPrint.setVar_nom_col2("" + this.nbSaloccasionnel);
            this.utilPrint.setVar_nom_col3("" + this.nbSalAdherent);
            this.utilPrint.setVar_nom_col4("" + this.nbSalNonAdherent);
            this.utilPrint.setVar_nom_col5("" + this.nbsalMoins1000000);
            this.utilPrint.setVar_nom_col6("" + this.nbSamPlus1000000);
            this.utilPrint.setVar_nom_col7("" + this.totSalMoins1000000);
            this.utilPrint.setVar_nom_col8("" + this.totSalPlus1000000);
            this.utilPrint.setVar_nom_col9("" + (this.nbsalMoins1000000 + this.nbSamPlus1000000));
            this.utilPrint.setVar_nom_col10("" + (this.totSalMoins1000000 + this.totSalPlus1000000));
            this.utilPrint.setJournal("");
            this.utilPrint.setCentreImpot("");
            if (!this.structureLog.getStrcodepays().equals("0077")) {
               if (this.structureLog.getStrcodepays().equals("0138")) {
                  this.utilPrint.setJournal(this.centre);
                  this.utilPrint.setCentreImpot(this.centre);
               } else if (this.structureLog.getStrcodepays().equals("0202")) {
                  this.utilPrint.setTaux(this.tauxCss);
               }
            } else {
               this.utilPrint.setTaux((float)(this.optionPaye.getTauxcnssPS() + this.optionPaye.getTauxcnssPP()));
               this.utilPrint.setTaux2((float)this.optionPaye.getTauxcnamgsPP());
               this.utilPrint.setTaux3((float)this.optionPaye.getTauxcnamgsPS());
               this.utilPrint.setPlafond(this.optionPaye.getCnamgs());
               this.utilPrint.setDateFinUk(this.utilDate.dateToStringFr(this.utilDate.dateDernierJourMois(this.utilDate.dateEcheanceArrondi(this.filtreDateFin, 10))));
               double var4 = 0.0D;
               if (this.filtreDateDebut.getMonth() + 1 >= 1 && this.filtreDateDebut.getMonth() + 1 <= 3) {
                  var4 = this.exoSelectionne.getExepayTotAll01() + this.exoSelectionne.getExepayTotAll02() + this.exoSelectionne.getExepayTotAll03();
               } else if (this.filtreDateDebut.getMonth() + 1 >= 4 && this.filtreDateDebut.getMonth() + 1 <= 6) {
                  var4 = this.exoSelectionne.getExepayTotAll04() + this.exoSelectionne.getExepayTotAll05() + this.exoSelectionne.getExepayTotAll06();
               } else if (this.filtreDateDebut.getMonth() + 1 >= 7 && this.filtreDateDebut.getMonth() + 1 <= 9) {
                  var4 = this.exoSelectionne.getExepayTotAll07() + this.exoSelectionne.getExepayTotAll08() + this.exoSelectionne.getExepayTotAll09();
               } else if (this.filtreDateDebut.getMonth() + 1 >= 10 && this.filtreDateDebut.getMonth() + 1 <= 12) {
                  var4 = this.exoSelectionne.getExepayTotAll10() + this.exoSelectionne.getExepayTotAll11() + this.exoSelectionne.getExepayTotAll12();
               }

               this.utilPrint.setIdEquipe((long)var4);
            }

            this.utilPrint.setTiersSelectionne((Tiers)null);
            this.utilPrint.setBaseLog(this.baseLog);
            this.utilPrint.setStructureLog(this.structureLog);
            this.utilPrint.setUsersLog(this.usersLog);
            this.utilPrint.setAnnexe1(this.utilDate.dateToStringSQL(this.filtreDateFin));
            this.utilPrint.imprimeRapport();
         }
      }

   }

   public String calculeBanqueSalaries() {
      String var1 = "";
      if (this.listeBanque != null && this.listeBanque.length != 0) {
         for(int var2 = 0; var2 < this.listeBanque.length; ++var2) {
            if (this.listeBanque[var2].contains(":")) {
               String[] var3 = this.listeBanque[var2].split(":");
               if (var1 != null && !var1.isEmpty()) {
                  var1 = var1 + ",'" + var3[0] + "'";
               } else {
                  var1 = "'" + var3[0] + "'";
               }
            }
         }

         if (var1 != null && !var1.isEmpty()) {
            var1 = "(" + var1 + ")";
         }
      } else {
         var1 = this.banqueSal;
      }

      return var1;
   }

   public String calculeActivitesSalaries() {
      String var1 = "";
      String var2 = "";
      if (this.listeActivite != null && this.listeActivite.length != 0) {
         for(int var3 = 0; var3 < this.listeActivite.length; ++var3) {
            if (this.listeActivite[var3].contains(":")) {
               String[] var4 = this.listeActivite[var3].split(":");
               if (var1 != null && !var1.isEmpty()) {
                  var1 = var1 + ",'" + var4[0] + "'";
                  var2 = var2 + "," + var4[0] + ":" + var4[1];
               } else {
                  var1 = "'" + var4[0] + "'";
                  var2 = var4[0] + ":" + var4[1];
               }
            }
         }

         if (var1 != null && !var1.isEmpty()) {
            var1 = "(" + var1 + ")";
            this.var_filtre = this.var_filtre + " Le(s) activités(s) : " + var2;
         }
      } else {
         var1 = this.activite;
      }

      return var1;
   }

   public String calculeServicesSalaries() {
      String var1 = "";
      String var2 = "";
      if (this.listeService != null && this.listeService.length != 0) {
         for(int var3 = 0; var3 < this.listeService.length; ++var3) {
            if (this.listeService[var3].contains(":")) {
               String[] var4 = this.listeService[var3].split(":");
               if (var1 != null && !var1.isEmpty()) {
                  var1 = var1 + ",'" + var4[0] + "'";
                  var2 = var2 + "," + var4[0] + ":" + var4[1];
               } else {
                  var1 = "'" + var4[0] + "'";
                  var2 = var4[0] + ":" + var4[1];
               }
            }
         }

         if (var1 != null && !var1.isEmpty()) {
            var1 = "(" + var1 + ")";
            this.var_filtre = this.var_filtre + " Le(s) services(s) : " + var2;
         }
      } else {
         var1 = this.service;
      }

      return var1;
   }

   public String calculeClients() throws HibernateException, NamingException {
      this.tauxCss = 0.0F;
      String var1 = "";
      if (this.listeClients != null && this.listeClients.length == 1) {
         if (!this.listeClients[0].equals("0")) {
            var1 = this.listeClients[0];
            if (var1 != null && !var1.isEmpty()) {
               var1 = "(" + var1 + ")";
               this.tiersRec = this.tiersDao.selectTierD(Long.parseLong(this.listeClients[0]));
               if (this.tiersRec != null) {
                  this.tauxCss = this.tiersRec.getTiecoefpvmedical();
               }
            }
         }
      } else if (this.listeClients != null && this.listeClients.length >= 2) {
         for(int var2 = 0; var2 < this.listeClients.length; ++var2) {
            if (!this.listeClients[0].equals("0")) {
               if (var1 != null && !var1.isEmpty()) {
                  var1 = var1 + "|" + this.listeClients[var2];
               } else {
                  var1 = this.listeClients[var2];
               }
            }
         }

         if (var1 != null && !var1.isEmpty()) {
            var1 = "(" + var1 + ")";
         }
      } else {
         var1 = "";
      }

      return var1;
   }

   public void calculeRequete() throws HibernateException, NamingException, ParseException, IOException {
      this.var_entete = "";
      this.var_filtre = "";
      if (this.etatSalarie == 0) {
         this.libelleEtat = "Actif";
      } else if (this.etatSalarie == 1) {
         this.libelleEtat = "En congès";
      } else if (this.etatSalarie == 2) {
         this.libelleEtat = "Licencié";
      } else if (this.etatSalarie == 3) {
         this.libelleEtat = "Démissioné";
      } else if (this.etatSalarie == 4) {
         this.libelleEtat = "Décédé";
      } else if (this.etatSalarie == 5) {
         this.libelleEtat = "Retraité";
      } else if (this.etatSalarie == 6) {
         this.libelleEtat = "Fin de contrat";
      } else if (this.etatSalarie == 7) {
         this.libelleEtat = "Arret/Suspendu";
      } else if (this.etatSalarie == 8) {
         this.libelleEtat = "Mutation";
      } else if (this.etatSalarie == 9) {
         this.libelleEtat = "Gelé";
      } else if (this.etatSalarie == 10) {
         this.libelleEtat = "Départ négocié";
      } else {
         this.libelleEtat = "Tout Etat";
      }

      String var1 = this.calculeBanqueSalaries();
      String var2 = this.calculeActivitesSalaries();
      String var3 = this.calculeServicesSalaries();
      String var4 = this.calculeClients();
      String var5 = this.utilDate.dateToStringSQLLight(this.filtreDateDebut);
      String var6 = this.utilDate.dateToStringSQLLight(this.filtreDateFin);
      String var7 = this.utilDate.dateToStringFr(this.filtreDateDebut);
      String var8 = this.utilDate.dateToStringFr(this.filtreDateFin);
      String[] var9;
      String var10;
      String var11;
      if (!this.nomRepertoire.equalsIgnoreCase("04-ressources_humaines") && !this.nomEtat.equals("colonnes_rh") && !this.nomEtat.equals("colonnes_salaries")) {
         if (!this.nomRepertoire.equalsIgnoreCase("05-contrat") && !this.nomEtat.equals("colonnes_contrats")) {
            if (this.nomRepertoire.equalsIgnoreCase("90-exportations")) {
               if (this.nomEtat.startsWith("20:") || this.nomEtat.startsWith("21:")) {
                  this.modeExportation = 2;
               }

               if (this.modeExportation == 1) {
                  this.exportAcompte(var5, var6, var7, var8, var2, var3, var1, var4);
               } else if (this.modeExportation == 0) {
                  this.exportNetAPayer(var5, var6, var7, var8, var2, var3, var1, var4);
               } else if (this.modeExportation == 2) {
                  this.exportDts(this.filtreDateDebut, this.filtreDateFin, var7, var8, var2, var3, var1, var4);
               }
            } else if (this.nomRepertoire.equalsIgnoreCase("temps")) {
               this.var_entete = this.nomEtat.toUpperCase() + " du " + var7 + " au " + var8;
               this.var_requete = "(salpoi_date>='" + var5 + "' AND salpoi_date<='" + var6 + "')";
               if (this.idTiersRec != 0L) {
                  this.tiersRec = this.tiersDao.selectTierD(this.idTiersRec);
                  if (this.tiersRec != null) {
                     this.var_filtre = this.var_filtre + " Le client : " + this.tiersRec.getTieraisonsocialenom();
                     this.var_requete = this.var_requete + " and salpoi_id_tiers =" + this.idTiersRec;
                  }
               }

               if (this.missionRec != null && !this.missionRec.isEmpty()) {
                  this.var_filtre = this.var_filtre + " La mission : " + this.missionRec;
                  this.var_requete = this.var_requete + " and salpoi_mission = '" + this.missionRec + "'";
               }

               if (this.tacheRec != null && !this.tacheRec.isEmpty()) {
                  this.var_filtre = this.var_filtre + " La tache : " + this.tacheRec;
                  this.var_requete = this.var_requete + " and salpoi_tache like '" + this.tacheRec + "%'";
               }

               if (this.salarieRec != 0L) {
                  SalariesDao var12 = new SalariesDao(this.baseLog, this.utilInitHibernate);
                  this.salaries = var12.pourParapheur(this.salarieRec, (Session)null);
                  if (this.salaries != null) {
                     this.var_filtre = this.var_filtre + " Le collaborateur : " + this.salaries.getPatronyme();
                     this.var_requete = this.var_requete + " and pay_salaries.sal_id = " + this.salaries.getSalId();
                  }
               }

               if (this.nomEtat.equals("Temps_facturation")) {
                  this.calculeTempsFacturation(var5, var6);
               }
            } else if (this.nomEtat.contains("(ISR)")) {
               this.calculIsr(var8, var6, var2);
            } else if (!this.nomEtat.contains("(CP)") && !this.nomEtat.contains("(BASE_CONGES)")) {
               if (this.nomEtat.contains("AgentControle")) {
                  this.calculCtrl(var8, var6, var2);
               } else {
                  this.rechercheBulletin(this.filtreDateDebut, this.filtreDateFin, var7, var8, var2, var3, var1, var4);
                  if (this.nomEtat.equals("-BINPS(Bordereau)")) {
                     this.calculNbMali();
                  } else if (this.nomEtat.startsWith("-BITS")) {
                     this.calculITSMali();
                  } else if (this.nomEtat.equals("-DAS(ID20)")) {
                     this.calculNbGabon(var5, var6);
                  }
               }
            } else {
               this.calculCp(var8, var6, var2);
            }
         } else {
            this.var_requete = "salcon_id>0 ";
            if (this.nomSalarie != null && !this.nomSalarie.isEmpty()) {
               this.var_filtre = this.var_filtre + " Le salarié : " + this.nomSalarie;
               this.var_requete = this.var_requete + " and Salaries.sal_matricule like '" + this.nomSalarie + "%'";
            }

            if (this.etatSalarie != 100) {
               this.var_filtre = this.var_filtre + " L'état : " + this.libelleEtat;
               if (this.etatSalarie == 0) {
                  this.var_requete = this.var_requete + " and salcon_etat <= 1";
               } else {
                  this.var_requete = this.var_requete + " and salcon_etat =" + this.etatSalarie;
               }
            }

            if (this.natureSalarie != null && !this.natureSalarie.isEmpty() && !this.natureSalarie.equals("100")) {
               this.var_filtre = this.var_filtre + " La nature : " + this.natureSalarie;
               this.var_requete = this.var_requete + " and salcon_type ='" + this.natureSalarie + "'";
            } else if (this.natureAutorisee != null && !this.natureAutorisee.isEmpty()) {
               this.var_requete = this.var_requete + " and salcon_type in (" + this.natureAutorisee + ")";
            }

            if (this.feuille != null && !this.feuille.isEmpty() && !this.feuille.equals("100")) {
               this.var_filtre = this.var_filtre + " La feuille : " + this.feuille;
               this.var_requete = this.var_requete + " and salcon_feuille ='" + this.feuille + "'";
            }

            if (this.convention != null && !this.convention.isEmpty() && this.convention.contains(":")) {
               var9 = this.convention.split(":");
               this.var_filtre = this.var_filtre + " La convention : " + var9[0];
               this.var_requete = this.var_requete + " and salcon_convention ='" + var9[0] + "'";
            }

            if (this.grille != null && !this.grille.isEmpty() && this.grille.contains(":")) {
               var9 = this.grille.split(":");
               this.var_filtre = this.var_filtre + " La catégorie : " + var9[0];
               this.var_requete = this.var_requete + " and salcon_grille ='" + var9[0] + "'";
            }

            if (this.centre != null && !this.centre.isEmpty() && this.centre.contains(":")) {
               var9 = this.centre.split(":");
               this.var_filtre = this.var_filtre + " Le centre d'impôt : " + var9[1];
               this.var_requete = this.var_requete + " and salcon_centres_impots ='" + var9[0] + "'";
            }

            if (this.securite != null && !this.securite.isEmpty() && this.securite.contains(":")) {
               var9 = this.securite.split(":");
               this.var_filtre = this.var_filtre + " Le centre de sécurité sociale : " + var9[1] + " : " + var9[0];
               this.var_requete = this.var_requete + " and salcon_centres_securite ='" + var9[0] + "'";
            }

            if (this.classement != null && !this.classement.isEmpty() && this.classement.contains(":")) {
               var9 = this.classement.split(":");
               this.var_filtre = this.var_filtre + " Le classement : " + var9[1];
               this.var_requete = this.var_requete + " and salcon_classement ='" + var9[0] + "'";
            }

            if (this.niveauEmploi != null && !this.niveauEmploi.isEmpty() && this.niveauEmploi.contains(":")) {
               var9 = this.niveauEmploi.split(":");
               this.var_filtre = this.var_filtre + " Le niveau : " + var9[1];
               this.var_requete = this.var_requete + " and salcon_niv_emploi ='" + var9[0] + "'";
            }

            if (this.pays != null && !this.pays.isEmpty() && !this.pays.equals("100")) {
               this.var_filtre = this.var_filtre + " Le pays : " + this.pays;
               this.var_requete = this.var_requete + " and Salaries.sal_pays_naissance ='" + this.pays + "'";
            }

            if (this.nationnalite != null && !this.nationnalite.isEmpty() && !this.nationnalite.equals("100")) {
               this.var_filtre = this.var_filtre + " La nationalité : " + this.nationnalite;
               this.var_requete = this.var_requete + " and Salaries.sal_nationnalite ='" + this.nationnalite + "'";
            }

            if (this.localisation != null && !this.localisation.isEmpty()) {
               this.var_filtre = this.var_filtre + " La localisation : " + this.localisation;
               this.var_requete = this.var_requete + " and salcon_localisation ='" + this.localisation + "'";
            }

            if (this.decoupageActivite) {
               if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
                  var9 = this.var_colonne1.split(":");
                  this.var_filtre = this.var_filtre + " " + this.structureLog.getStrLib1() + " : " + var9[1];
                  this.var_requete = this.var_requete + " and salcon_activite ='%" + var9[0] + "%'";
               }

               if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
                  var9 = this.var_colonne2.split(":");
                  this.var_filtre = this.var_filtre + " " + this.structureLog.getStrLib2() + " : " + var9[1];
                  this.var_requete = this.var_requete + " and salcon_activite ='%" + var9[0] + "%'";
               }

               if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
                  var9 = this.var_colonne3.split(":");
                  this.var_filtre = this.var_filtre + " " + this.structureLog.getStrLib3() + " : " + var9[1];
                  this.var_requete = this.var_requete + " and salcon_activite ='%" + var9[0] + "%'";
               }
            } else if (var2 != null && !var2.isEmpty()) {
               if (var2.contains(":")) {
                  var9 = var2.split(":");
                  var10 = var9[0];
                  this.var_filtre = this.var_filtre + " L`activité : " + var10;
                  this.var_requete = this.var_requete + " AND salcon_activite='" + var10 + "'";
               } else if (var2.contains("(")) {
                  this.var_requete = this.var_requete + " AND salcon_activite in" + var2;
               }
            }

            if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
               var9 = this.site.split(":");
               this.var_filtre = this.var_filtre + " Le site : " + var9[1];
               this.var_requete = this.var_requete + " and salcon_site ='" + var9[0] + "'";
            }

            if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
               var9 = this.departement.split(":");
               this.var_filtre = this.var_filtre + " Le département : " + var9[1];
               this.var_requete = this.var_requete + " and salcon_departement ='" + var9[0] + "'";
            }

            if (var3 != null && !var3.isEmpty()) {
               if (var3.contains(":")) {
                  var9 = var3.split(":");
                  var10 = var9[0];
                  this.var_filtre = this.var_filtre + " Le service : " + var10;
                  this.var_requete = this.var_requete + " AND salcon_service='" + var10 + "'";
               } else if (var3.contains("(")) {
                  this.var_requete = this.var_requete + " AND salcon_service in" + var3;
               }
            }

            if (this.projet != null && !this.projet.isEmpty() && this.projet.contains(":")) {
               var9 = this.projet.split(":");
               this.var_filtre = this.var_filtre + " Le projet : " + var9[1];
               this.var_requete = this.var_requete + " and salcon_projet ='" + var9[0] + "'";
            }

            if (this.budget != null && !this.budget.isEmpty() && this.budget.contains(":")) {
               var9 = this.budget.split(":");
               this.var_filtre = this.var_filtre + " Le budget : " + var9[1];
               this.var_requete = this.var_requete + " and salcon_budget ='" + var9[0] + "'";
            }

            if (var4 != null && !var4.isEmpty()) {
               if (!var4.contains("|")) {
                  var11 = var4.replace("(", "").replace(")", "");
                  this.tiersRec = this.tiersDao.selectTierD(Long.parseLong(var11));
                  if (this.tiersRec != null) {
                     this.var_filtre = this.var_filtre + " Le tiers : " + this.tiersRec.getTieraisonsocialenom();
                     this.var_requete = this.var_requete + " AND salcon_id_tiers=" + Long.parseLong(var11);
                  }
               } else {
                  this.var_filtre = this.var_filtre + " Le(s) tiers : " + var4;
                  this.var_requete = this.var_requete + " AND salcon_id_tiers in" + var4;
               }
            }

            if (this.var_requete != null && !this.var_requete.isEmpty() && this.var_requete.contains("|")) {
               this.var_requete = this.var_requete.replace("|", ",");
            }
         }
      } else {
         this.var_requete = "sal_id>0 ";
         if (this.nomSalarie != null && !this.nomSalarie.isEmpty()) {
            this.var_filtre = this.var_filtre + " Le salarié : " + this.nomSalarie;
            this.var_requete = this.var_requete + " and sal_matricule like '" + this.nomSalarie + "%'";
         }

         if (this.etatSalarie != 100) {
            this.var_filtre = this.var_filtre + " L'état : " + this.libelleEtat;
            if (this.etatSalarie == 0) {
               this.var_requete = this.var_requete + " and sal_etat <= 1";
            } else {
               this.var_requete = this.var_requete + " and sal_etat =" + this.etatSalarie;
            }
         }

         if (this.natureSalarie != null && !this.natureSalarie.isEmpty() && !this.natureSalarie.equals("100")) {
            this.var_filtre = this.var_filtre + " La nature : " + this.natureSalarie;
            this.var_requete = this.var_requete + " and sal_nature ='" + this.natureSalarie + "'";
         } else if (this.natureAutorisee != null && !this.natureAutorisee.isEmpty()) {
            this.var_requete = this.var_requete + " and sal_nature in (" + this.natureAutorisee + ")";
         }

         if (this.feuille != null && !this.feuille.isEmpty() && !this.feuille.equals("100")) {
            this.var_filtre = this.var_filtre + " La feuille : " + this.feuille;
            this.var_requete = this.var_requete + " and sal_feuille ='" + this.feuille + "'";
         }

         if (this.convention != null && !this.convention.isEmpty() && this.convention.contains(":")) {
            var9 = this.convention.split(":");
            this.var_filtre = this.var_filtre + " La convention : " + var9[0];
            this.var_requete = this.var_requete + " and sal_convention ='" + var9[0] + "'";
         }

         if (this.grille != null && !this.grille.isEmpty() && this.grille.contains(":")) {
            var9 = this.grille.split(":");
            this.var_filtre = this.var_filtre + " La catégorie : " + var9[0];
            this.var_requete = this.var_requete + " and sal_grille ='" + var9[0] + "'";
         }

         if (this.centre != null && !this.centre.isEmpty() && this.centre.contains(":")) {
            var9 = this.centre.split(":");
            this.var_filtre = this.var_filtre + " Le centre d'impôt : " + var9[1];
            this.var_requete = this.var_requete + " and sal_Cod_Centres_Impots ='" + var9[0] + "'";
         }

         if (this.securite != null && !this.securite.isEmpty() && this.securite.contains(":")) {
            var9 = this.securite.split(":");
            this.var_filtre = this.var_filtre + " Le centre de sécurité sociale : " + var9[1] + " : " + var9[0];
            this.var_requete = this.var_requete + " and sal_centres_securite ='" + var9[0] + "'";
         }

         if (this.classement != null && !this.classement.isEmpty() && this.classement.contains(":")) {
            var9 = this.classement.split(":");
            this.var_filtre = this.var_filtre + " Le classement : " + var9[1];
            this.var_requete = this.var_requete + " and sal_classement ='" + var9[0] + "'";
         }

         if (this.niveauEmploi != null && !this.niveauEmploi.isEmpty() && this.niveauEmploi.contains(":")) {
            var9 = this.niveauEmploi.split(":");
            this.var_filtre = this.var_filtre + " Le niveau : " + var9[1];
            this.var_requete = this.var_requete + " and sal_niv_emploi ='" + var9[0] + "'";
         }

         if (this.pays != null && !this.pays.isEmpty() && !this.pays.equals("100")) {
            this.var_filtre = this.var_filtre + " Le pays : " + this.pays;
            this.var_requete = this.var_requete + " and sal_pays_naissance ='" + this.pays + "'";
         }

         if (this.nationnalite != null && !this.nationnalite.isEmpty() && !this.nationnalite.equals("100")) {
            this.var_filtre = this.var_filtre + " La nationalité : " + this.nationnalite;
            this.var_requete = this.var_requete + " and sal_nationnalite ='" + this.nationnalite + "'";
         }

         if (this.decoupageActivite) {
            if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
               var9 = this.var_colonne1.split(":");
               this.var_filtre = this.var_filtre + " " + this.structureLog.getStrLib1() + " : " + var9[1];
               this.var_requete = this.var_requete + " and sal_activite ='%" + var9[0] + "%'";
            }

            if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
               var9 = this.var_colonne2.split(":");
               this.var_filtre = this.var_filtre + " " + this.structureLog.getStrLib2() + " : " + var9[1];
               this.var_requete = this.var_requete + " and sal_activite ='%" + var9[0] + "%'";
            }

            if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
               var9 = this.var_colonne3.split(":");
               this.var_filtre = this.var_filtre + " " + this.structureLog.getStrLib3() + " : " + var9[1];
               this.var_requete = this.var_requete + " and sal_activite ='%" + var9[0] + "%'";
            }
         } else if (var2 != null && !var2.isEmpty()) {
            if (var2.contains(":")) {
               var9 = var2.split(":");
               var10 = var9[0];
               this.var_filtre = this.var_filtre + " L`activité : " + var10;
               this.var_requete = this.var_requete + " AND sal_activite='" + var10 + "'";
            } else if (var2.contains("(")) {
               this.var_requete = this.var_requete + " AND sal_activite in" + var2;
            }
         }

         if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
            var9 = this.site.split(":");
            this.var_filtre = this.var_filtre + " Le site : " + var9[1];
            this.var_requete = this.var_requete + " and sal_site ='" + var9[0] + "'";
         }

         if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
            var9 = this.departement.split(":");
            this.var_filtre = this.var_filtre + " Le département : " + var9[1];
            this.var_requete = this.var_requete + " and sal_departement ='" + var9[0] + "'";
         }

         if (var3 != null && !var3.isEmpty()) {
            if (var3.contains(":")) {
               var9 = var3.split(":");
               var10 = var9[0];
               this.var_filtre = this.var_filtre + " Le service : " + var10;
               this.var_requete = this.var_requete + " AND sal_service='" + var10 + "'";
            } else if (var3.contains("(")) {
               this.var_requete = this.var_requete + " AND sal_service in" + var3;
            }
         }

         if (this.projet != null && !this.projet.isEmpty() && this.projet.contains(":")) {
            var9 = this.projet.split(":");
            this.var_filtre = this.var_filtre + " Le projet : " + var9[1];
            this.var_requete = this.var_requete + " and sal_projet ='" + var9[0] + "'";
         }

         if (this.budget != null && !this.budget.isEmpty() && this.budget.contains(":")) {
            var9 = this.budget.split(":");
            this.var_filtre = this.var_filtre + " Le budget : " + var9[1];
            this.var_requete = this.var_requete + " and sal_budget ='" + var9[0] + "'";
         }

         if (var1 != null && !var1.isEmpty()) {
            if (var1.contains(":")) {
               var9 = var1.split(":");
               var10 = var9[0];
               this.var_filtre = this.var_filtre + " La banque : " + var10;
               this.var_requete = this.var_requete + " AND sal_num_banque='" + var10 + "'";
            } else if (var1.contains("(")) {
               this.var_filtre = this.var_filtre + " Le(s) banque(s) : " + var1;
               this.var_requete = this.var_requete + " AND sal_num_banque in" + var1;
            }
         }

         if (var4 != null && !var4.isEmpty()) {
            if (!var4.contains("|")) {
               var11 = var4.replace("(", "").replace(")", "");
               this.tiersRec = this.tiersDao.selectTierD(Long.parseLong(var11));
               if (this.tiersRec != null) {
                  this.var_filtre = this.var_filtre + " Le tiers : " + this.tiersRec.getTieraisonsocialenom();
                  this.var_requete = this.var_requete + " AND sal_id_tiers=" + Long.parseLong(var11);
               }
            } else {
               this.var_filtre = this.var_filtre + " Le(s) tiers : " + var4;
               this.var_requete = this.var_requete + " AND sal_id_tiers in" + var4;
            }
         }

         if (this.var_requete != null && !this.var_requete.isEmpty() && this.var_requete.contains("|")) {
            this.var_requete = this.var_requete.replace("|", ",");
         }
      }

      if (this.nomRepertoire.equalsIgnoreCase("06-utilisateurs") && this.nomEtat.startsWith("colonnes_")) {
         if (!this.nomEtat.equals("colonnes_rh") && !this.nomEtat.equals("colonnes_salaries")) {
            if (this.nomEtat.equals("colonnes_contrats")) {
               this.calculeColonnesContrats();
            } else if (this.nomEtat.equals("colonnes_bulletins")) {
               this.calculeColonnesBulletins();
            }
         } else {
            this.calculeColonnesSalaries();
         }
      }

   }

   public void rechercheBulletin(Date var1, Date var2, String var3, String var4, String var5, String var6, String var7, String var8) throws HibernateException, NamingException {
      String var9 = this.utilDate.dateToStringSQLLight(var1);
      String var10 = this.utilDate.dateToStringSQLLight(var2);
      this.var_entete = this.nomEtat.toUpperCase() + " du " + var3 + " au " + var4;
      this.var_requete = "(bulsal_date_debut>='" + var9 + "' AND bulsal_date_debut<='" + var10 + "') and bulsal_periode <> 'SIMUL'";
      if (this.nomSalarie != null && !this.nomSalarie.isEmpty()) {
         this.var_filtre = this.var_filtre + " Le salarié : " + this.nomSalarie;
         this.var_requete = this.var_requete + " and bulsal_matricule like '" + this.nomSalarie + "%'";
      }

      if (this.etatSalarie != 100) {
         this.var_filtre = this.var_filtre + " L'état : " + this.libelleEtat;
         if (this.etatSalarie == 0) {
            this.var_requete = this.var_requete + " and bulsal_etat <= 1";
         } else {
            this.var_requete = this.var_requete + " and bulsal_etat =" + this.etatSalarie;
         }
      }

      if (this.feuille != null && !this.feuille.isEmpty() && !this.feuille.equals("100")) {
         this.var_filtre = this.var_filtre + " La feuille : " + this.feuille;
         this.var_requete = this.var_requete + " and bulsal_feuille ='" + this.feuille + "'";
      }

      String var11;
      if (this.natureSalarie != null && !this.natureSalarie.isEmpty() && !this.natureSalarie.equals("100")) {
         this.var_filtre = this.var_filtre + " La nature : " + this.natureSalarie;
         this.var_requete = this.var_requete + " and bulsal_nature ='" + this.natureSalarie + "'";
      } else if (this.nomRepertoire.equals("03-annuel")) {
         if (this.mesNatureAgentItems.size() != 0) {
            var11 = "";

            for(int var12 = 0; var12 < this.mesNatureAgentItems.size(); ++var12) {
               if (((SelectItem)this.mesNatureAgentItems.get(var12)).getValue().toString() != null && !((SelectItem)this.mesNatureAgentItems.get(var12)).getValue().toString().isEmpty() && ((SelectItem)this.mesNatureAgentItems.get(var12)).getValue().toString().startsWith("0")) {
                  if (var11 != null && !var11.isEmpty()) {
                     var11 = var11 + "," + "'" + ((SelectItem)this.mesNatureAgentItems.get(var12)).getValue().toString() + "'";
                  } else {
                     var11 = "'" + ((SelectItem)this.mesNatureAgentItems.get(var12)).getValue().toString() + "'";
                  }
               }
            }

            this.var_requete = this.var_requete + " and bulsal_nature in (" + var11 + ")";
         }
      } else if (!this.nomEtat.equals("Etat_centralisation_mensuelle") && this.natureAutorisee != null && !this.natureAutorisee.isEmpty()) {
         this.var_requete = this.var_requete + " and bulsal_nature in (" + this.natureAutorisee + ")";
      }

      String[] var13;
      if (this.convention != null && !this.convention.isEmpty() && this.convention.contains(":")) {
         var13 = this.convention.split(":");
         this.var_filtre = this.var_filtre + " La convention : " + var13[0];
         this.var_requete = this.var_requete + " and bulsal_convention ='" + var13[0] + "'";
      }

      if (this.grille != null && !this.grille.isEmpty() && this.grille.contains(":")) {
         var13 = this.grille.split(":");
         this.var_filtre = this.var_filtre + " La catégorie : " + var13[0];
         this.var_requete = this.var_requete + " and bulsal_grille ='" + var13[0] + "'";
      }

      if (this.centre != null && !this.centre.isEmpty() && this.centre.contains(":")) {
         var13 = this.centre.split(":");
         this.var_filtre = this.var_filtre + " Le centre d'impôt : " + var13[1];
         this.var_requete = this.var_requete + " and bulsal_Cod_Centres_Impots ='" + var13[0] + "'";
      }

      if (this.securite != null && !this.securite.isEmpty() && this.securite.contains(":")) {
         var13 = this.securite.split(":");
         this.var_filtre = this.var_filtre + " Le centre de sécurité sociale : " + var13[1] + " : " + var13[0];
         this.var_requete = this.var_requete + " and bulsal_centres_securite ='" + var13[0] + "'";
      }

      if (this.classement != null && !this.classement.isEmpty() && this.classement.contains(":")) {
         var13 = this.classement.split(":");
         this.var_filtre = this.var_filtre + " Le classement : " + var13[1];
         this.var_requete = this.var_requete + " and bulsal_classement ='" + var13[0] + "'";
      }

      if (this.niveauEmploi != null && !this.niveauEmploi.isEmpty() && this.niveauEmploi.contains(":")) {
         var13 = this.niveauEmploi.split(":");
         this.var_filtre = this.var_filtre + " Le niveau : " + var13[1];
         this.var_requete = this.var_requete + " and bulsal_niv_emploi ='" + var13[0] + "'";
      }

      if (this.localisation != null && !this.localisation.isEmpty()) {
         this.var_filtre = this.var_filtre + " La localisation : " + this.localisation;
         this.var_requete = this.var_requete + " and bulsal_localisation ='" + this.localisation + "'";
      }

      String var14;
      if (var5 != null && !var5.isEmpty()) {
         if (var5.contains(":")) {
            var13 = var5.split(":");
            var14 = var13[0];
            this.var_filtre = this.var_filtre + " L`activité : " + var14;
            this.var_requete = this.var_requete + " AND bulsal_acticvite='" + var14 + "'";
         } else if (var5.contains("(")) {
            this.var_requete = this.var_requete + " AND bulsal_acticvite in" + var5;
         }
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         var13 = this.site.split(":");
         this.var_filtre = this.var_filtre + " Le site : " + var13[1];
         this.var_requete = this.var_requete + " and bulsal_site ='" + var13[0] + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         var13 = this.departement.split(":");
         this.var_filtre = this.var_filtre + " Le département : " + var13[1];
         this.var_requete = this.var_requete + " and bulsal_departement ='" + var13[0] + "'";
      }

      if (var6 != null && !var6.isEmpty()) {
         if (var6.contains(":")) {
            var13 = var6.split(":");
            var14 = var13[0];
            this.var_filtre = this.var_filtre + " Le service : " + var14;
            this.var_requete = this.var_requete + " AND bulsal_service='" + var14 + "'";
         } else if (var6.contains("(")) {
            this.var_requete = this.var_requete + " AND bulsal_service in" + var6;
         }
      }

      if (this.projet != null && !this.projet.isEmpty() && this.projet.contains(":")) {
         var13 = this.projet.split(":");
         this.var_filtre = this.var_filtre + " Le projet : " + var13[1];
         this.var_requete = this.var_requete + " and bulsal_projet ='" + var13[0] + "'";
      }

      if (this.budget != null && !this.budget.isEmpty() && this.budget.contains(":")) {
         var13 = this.budget.split(":");
         this.var_filtre = this.var_filtre + " Le budget : " + var13[1];
         this.var_requete = this.var_requete + " and bulsal_budget ='" + var13[0] + "'";
      }

      if (this.lot != null && !this.lot.isEmpty()) {
         this.var_filtre = this.var_filtre + " Le lot : " + this.lot;
         this.var_requete = this.var_requete + " and bulsal_lot ='" + this.lot + "'";
      }

      if (var7 != null && !var7.isEmpty()) {
         if (var7.contains(":")) {
            var13 = var7.split(":");
            var14 = var13[0];
            this.var_filtre = this.var_filtre + " La banque : " + var14;
            this.var_requete = this.var_requete + " AND bulsal_num_banque='" + var14 + "'";
         } else if (var7.contains("(")) {
            this.var_filtre = this.var_filtre + " Le(s) banque(s) : " + var7;
            this.var_requete = this.var_requete + " AND bulsal_num_banque in" + var7;
         }
      }

      if (var8 != null && !var8.isEmpty()) {
         if (!var8.contains("|")) {
            var11 = var8.replace("(", "").replace(")", "");
            this.tiersRec = this.tiersDao.selectTierD(Long.parseLong(var11));
            if (this.tiersRec != null) {
               this.var_filtre = this.var_filtre + " Le tiers : " + this.tiersRec.getTieraisonsocialenom();
               this.var_requete = this.var_requete + " AND bulsal_id_tiers=" + Long.parseLong(var11);
            }
         } else {
            this.var_filtre = this.var_filtre + " Le(s) tiers : " + var8;
            this.var_requete = this.var_requete + " AND bulsal_id_tiers in" + var8;
         }
      }

      if (this.nomEtat.toLowerCase().contains("rubrique") || this.nomEtat.equals("colonnes_bulletins")) {
         if (this.natureRubrique != null && !this.natureRubrique.isEmpty() && !this.natureRubrique.equals("100")) {
            this.var_filtre = this.var_filtre + " La nature rubrique : " + this.natureRubrique;
            this.var_requete = this.var_requete + " and bullig_nature='" + this.natureRubrique + "'";
         }

         if (this.rubrique != null && !this.rubrique.isEmpty() && !this.rubrique.equals("100")) {
            this.var_filtre = this.var_filtre + " La rubrique : " + this.rubrique;
            var11 = "";
            if (this.rubrique.contains(":")) {
               String[] var15 = this.rubrique.split(":");
               var11 = var15[0];
            } else {
               var11 = this.rubrique;
            }

            this.var_requete = this.var_requete + " and bullig_rubrique='" + var11 + "'";
         }

         this.var_requete = this.var_requete + " and bullig_nature <> 99";
      }

      if (this.var_requete != null && !this.var_requete.isEmpty() && this.var_requete.contains("|")) {
         this.var_requete = this.var_requete.replace("|", ",");
      }

   }

   public void exportAcompte(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8) throws HibernateException, NamingException {
      this.var_entete = this.nomEtat.toUpperCase() + " du " + var3 + " au " + var4;
      this.var_requete = "salvar_periode ='" + this.periode + "' and salvar_periode <> 'SIMUL'";
      if (this.nomEtat.startsWith("5:")) {
         this.var_requete = this.var_requete + " and Salaries.salModeReglement15 = 5 ";
      } else if (this.nomEtat.startsWith("4:")) {
         this.var_requete = this.var_requete + " and Salaries.salModeReglement15 = 4 ";
      } else {
         this.var_requete = this.var_requete + " and Salaries.salModeReglement15 = 2 ";
      }

      if (this.nomSalarie != null && !this.nomSalarie.isEmpty()) {
         this.var_filtre = this.var_filtre + " Le salarié : " + this.nomSalarie;
         this.var_requete = this.var_requete + " and Salaries.salMatricule like '" + this.nomSalarie + "%'";
      }

      if (this.natureSalarie != null && !this.natureSalarie.isEmpty() && !this.natureSalarie.equals("100")) {
         this.var_filtre = this.var_filtre + " La nature : " + this.natureSalarie;
         this.var_requete = this.var_requete + " and Salaries.salNature ='" + this.natureSalarie + "'";
      } else if (this.natureAutorisee != null && !this.natureAutorisee.isEmpty()) {
         this.var_requete = this.var_requete + " and Salaries.salNature in (" + this.natureAutorisee + ")";
      }

      if (this.feuille != null && !this.feuille.isEmpty() && !this.feuille.equals("100")) {
         this.var_filtre = this.var_filtre + " La feuille : " + this.feuille;
         this.var_requete = this.var_requete + " and salvar_feuille ='" + this.feuille + "'";
      }

      String[] var9;
      if (this.convention != null && !this.convention.isEmpty() && this.convention.contains(":")) {
         var9 = this.convention.split(":");
         this.var_filtre = this.var_filtre + " La convention : " + var9[0];
         this.var_requete = this.var_requete + " and Salaries.salConvention ='" + var9[0] + "'";
      }

      if (this.grille != null && !this.grille.isEmpty() && this.grille.contains(":")) {
         var9 = this.grille.split(":");
         this.var_filtre = this.var_filtre + " La catégorie : " + var9[0];
         this.var_requete = this.var_requete + " and Salaries.salGrille ='" + var9[0] + "'";
      }

      if (this.centre != null && !this.centre.isEmpty() && this.centre.contains(":")) {
         var9 = this.centre.split(":");
         this.var_filtre = this.var_filtre + " Le centre d'impôt : " + var9[1];
         this.var_requete = this.var_requete + " and Salaries.salCod_Centres_Impots ='" + var9[0] + "'";
      }

      if (this.securite != null && !this.securite.isEmpty() && this.securite.contains(":")) {
         var9 = this.securite.split(":");
         this.var_filtre = this.var_filtre + " Le centre de sécurité sociale : " + var9[1] + " : " + var9[0];
         this.var_requete = this.var_requete + " and Salaries.salNatureCentresSecurite ='" + var9[0] + "'";
      }

      if (this.classement != null && !this.classement.isEmpty() && this.classement.contains(":")) {
         var9 = this.classement.split(":");
         this.var_filtre = this.var_filtre + " Le classement : " + var9[1];
         this.var_requete = this.var_requete + " and Salaries.salClassement ='" + var9[0] + "'";
      }

      if (this.niveauEmploi != null && !this.niveauEmploi.isEmpty() && this.niveauEmploi.contains(":")) {
         var9 = this.niveauEmploi.split(":");
         this.var_filtre = this.var_filtre + " Le niveau : " + var9[1];
         this.var_requete = this.var_requete + " and Salaries.salNivEmploi ='" + var9[0] + "'";
      }

      String var10;
      if (var5 != null && !var5.isEmpty()) {
         if (var5.contains(":")) {
            var9 = var5.split(":");
            var10 = var9[0];
            this.var_filtre = this.var_filtre + " L`activité : " + var10;
            this.var_requete = this.var_requete + " AND Salaries.salActicvite='" + var10 + "'";
         } else if (var5.contains("(")) {
            this.var_requete = this.var_requete + " AND Salaries.salActicvite in" + var5;
         }
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         var9 = this.site.split(":");
         this.var_filtre = this.var_filtre + " Le site : " + var9[1];
         this.var_requete = this.var_requete + " and Salaries.salSite ='" + var9[0] + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         var9 = this.departement.split(":");
         this.var_filtre = this.var_filtre + " Le département : " + var9[1];
         this.var_requete = this.var_requete + " and Salaries.salDepartement ='" + var9[0] + "'";
      }

      if (var6 != null && !var6.isEmpty()) {
         if (var6.contains(":")) {
            var9 = var6.split(":");
            var10 = var9[0];
            this.var_filtre = this.var_filtre + " Le service : " + var10;
            this.var_requete = this.var_requete + " AND Salaries.salService='" + var10 + "'";
         } else if (var6.contains("(")) {
            this.var_requete = this.var_requete + " AND Salaries.salService in" + var6;
         }
      }

      if (this.budget != null && !this.budget.isEmpty() && this.budget.contains(":")) {
         var9 = this.budget.split(":");
         this.var_filtre = this.var_filtre + " Le budget : " + var9[1];
         this.var_requete = this.var_requete + " and Salaries.salBudget ='" + var9[0] + "'";
      }

      if (var7 != null && !var7.isEmpty()) {
         if (var7.contains(":")) {
            var9 = var7.split(":");
            var10 = var9[0];
            this.var_filtre = this.var_filtre + " La banque : " + var10;
            this.var_requete = this.var_requete + " AND Salaries.salNumBanque15='" + var10 + "'";
         } else if (var7.contains("(")) {
            this.var_filtre = this.var_filtre + " Le(s) banque(s) : " + var7;
            this.var_requete = this.var_requete + " AND Salaries.salNumBanque15 in" + var7;
         }
      }

      if (this.var_requete != null && !this.var_requete.isEmpty() && this.var_requete.contains("|")) {
         this.var_requete = this.var_requete.replace("|", ",");
      }

      SalariesVariablesDao var15 = new SalariesVariablesDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var14 = var15.chargerlesVariablesByRequeteVirement(this.var_requete, (Session)null);
      this.lesVirements.clear();
      if (var14.size() != 0) {
         new SalariesVariables();

         for(int var12 = 0; var12 < var14.size(); ++var12) {
            SalariesVariables var11 = (SalariesVariables)var14.get(var12);
            BulletinSalaire var13 = new BulletinSalaire();
            var13.setSalaries(var11.getSalaries());
            var13.setPatronyme(var11.getSalaries().getPatronyme());
            var13.setBulsalMatricule(var11.getSalaries().getSalMatricule());
            var13.setBulsalNetPayer(var11.getSalvarValeurColE());
            var13.setBulsalPeriode(var11.getSalvarPeriode());
            var13.setBulsalModeReglement(var11.getSalaries().getSalModeReglement15());
            var13.setBulsalCompteBanque(var11.getSalaries().getSalCompteBanque15());
            var13.setBulsalGuichetBanque(var11.getSalaries().getSalGuichetBanque15());
            var13.setBulsalNumBanque(var11.getSalaries().getSalNumBanque15());
            var13.setBulsalCleBanque(var11.getSalaries().getSalCleBanque15());
            this.lesVirements.add(var13);
         }
      }

   }

   public void exportNetAPayer(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8) throws HibernateException, NamingException {
      this.var_entete = this.nomEtat.toUpperCase() + " du " + var3 + " au " + var4;
      this.var_requete = "(bulsal_date_debut>='" + var1 + "' AND bulsal_date_debut<='" + var2 + "') and bulsal_periode <> 'SIMUL'";
      if (this.nomEtat.startsWith("5:")) {
         this.var_requete = this.var_requete + " and bulsal_mode_reglement = 5 ";
      } else if (this.nomEtat.startsWith("4:")) {
         this.var_requete = this.var_requete + " and bulsal_mode_reglement = 4 ";
      } else {
         this.var_requete = this.var_requete + " and bulsal_mode_reglement = 2 ";
      }

      if (this.nomSalarie != null && !this.nomSalarie.isEmpty()) {
         this.var_filtre = this.var_filtre + " Le salarié : " + this.nomSalarie;
         this.var_requete = this.var_requete + " and bulsal_matricule like '" + this.nomSalarie + "%'";
      }

      if (this.natureSalarie != null && !this.natureSalarie.isEmpty() && !this.natureSalarie.equals("100")) {
         this.var_filtre = this.var_filtre + " La nature : " + this.natureSalarie;
         this.var_requete = this.var_requete + " and bulsal_nature ='" + this.natureSalarie + "'";
      } else if (this.natureAutorisee != null && !this.natureAutorisee.isEmpty()) {
         this.var_requete = this.var_requete + " and bulsal_nature in (" + this.natureAutorisee + ")";
      }

      if (this.feuille != null && !this.feuille.isEmpty() && !this.feuille.equals("100")) {
         this.var_filtre = this.var_filtre + " La feuille : " + this.feuille;
         this.var_requete = this.var_requete + " and bulsal_feuille ='" + this.feuille + "'";
      }

      String[] var9;
      if (this.convention != null && !this.convention.isEmpty() && this.convention.contains(":")) {
         var9 = this.convention.split(":");
         this.var_filtre = this.var_filtre + " La convention : " + var9[0];
         this.var_requete = this.var_requete + " and bulsal_convention ='" + var9[0] + "'";
      }

      if (this.grille != null && !this.grille.isEmpty() && this.grille.contains(":")) {
         var9 = this.grille.split(":");
         this.var_filtre = this.var_filtre + " La catégorie : " + var9[0];
         this.var_requete = this.var_requete + " and bulsal_grille ='" + var9[0] + "'";
      }

      if (this.centre != null && !this.centre.isEmpty() && this.centre.contains(":")) {
         var9 = this.centre.split(":");
         this.var_filtre = this.var_filtre + " Le centre d'impôt : " + var9[1];
         this.var_requete = this.var_requete + " and bulsal_Cod_Centres_Impots ='" + var9[0] + "'";
      }

      if (this.securite != null && !this.securite.isEmpty() && this.securite.contains(":")) {
         var9 = this.securite.split(":");
         this.var_filtre = this.var_filtre + " Le centre de sécurité sociale : " + var9[1] + " : " + var9[0];
         this.var_requete = this.var_requete + " and bulsal_centres_securite ='" + var9[0] + "'";
      }

      if (this.classement != null && !this.classement.isEmpty() && this.classement.contains(":")) {
         var9 = this.classement.split(":");
         this.var_filtre = this.var_filtre + " Le classement : " + var9[1];
         this.var_requete = this.var_requete + " and bulsal_classement ='" + var9[0] + "'";
      }

      if (this.niveauEmploi != null && !this.niveauEmploi.isEmpty() && this.niveauEmploi.contains(":")) {
         var9 = this.niveauEmploi.split(":");
         this.var_filtre = this.var_filtre + " Le niveau : " + var9[1];
         this.var_requete = this.var_requete + " and bulsal_niv_emploi ='" + var9[0] + "'";
      }

      if (this.localisation != null && !this.localisation.isEmpty()) {
         this.var_filtre = this.var_filtre + " La localisation : " + this.localisation;
         this.var_requete = this.var_requete + " and bulsal_localisation ='" + this.localisation + "'";
      }

      String var10;
      if (var5 != null && !var5.isEmpty()) {
         if (var5.contains(":")) {
            var9 = var5.split(":");
            var10 = var9[0];
            this.var_filtre = this.var_filtre + " L`activité : " + var10;
            this.var_requete = this.var_requete + " AND bulsal_acticvite='" + var10 + "'";
         } else if (var5.contains("(")) {
            this.var_requete = this.var_requete + " AND bulsal_acticvite in" + var5;
         }
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         var9 = this.site.split(":");
         this.var_filtre = this.var_filtre + " Le site : " + var9[1];
         this.var_requete = this.var_requete + " and bulsal_site ='" + var9[0] + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         var9 = this.departement.split(":");
         this.var_filtre = this.var_filtre + " Le département : " + var9[1];
         this.var_requete = this.var_requete + " and bulsal_departement ='" + var9[0] + "'";
      }

      if (var6 != null && !var6.isEmpty()) {
         if (var6.contains(":")) {
            var9 = var6.split(":");
            var10 = var9[0];
            this.var_filtre = this.var_filtre + " Le service : " + var10;
            this.var_requete = this.var_requete + " AND bulsal_service='" + var10 + "'";
         } else if (var6.contains("(")) {
            this.var_requete = this.var_requete + " AND bulsal_service in" + var6;
         }
      }

      if (this.projet != null && !this.projet.isEmpty() && this.projet.contains(":")) {
         var9 = this.projet.split(":");
         this.var_filtre = this.var_filtre + " Le projet : " + var9[1];
         this.var_requete = this.var_requete + " and bulsal_projet ='" + var9[0] + "'";
      }

      if (this.budget != null && !this.budget.isEmpty() && this.budget.contains(":")) {
         var9 = this.budget.split(":");
         this.var_filtre = this.var_filtre + " Le budget : " + var9[1];
         this.var_requete = this.var_requete + " and bulsal_budget ='" + var9[0] + "'";
      }

      if (this.lot != null && !this.lot.isEmpty()) {
         this.var_filtre = this.var_filtre + " Le lot : " + this.lot;
         this.var_requete = this.var_requete + " and bulsal_lot ='" + this.lot + "'";
      }

      if (var7 != null && !var7.isEmpty()) {
         if (var7.contains(":")) {
            var9 = var7.split(":");
            var10 = var9[0];
            this.var_filtre = this.var_filtre + " La banque : " + var10;
            this.var_requete = this.var_requete + " AND bulsal_num_banque='" + var10 + "'";
         } else if (var7.contains("(")) {
            this.var_filtre = this.var_filtre + " Le(s) banque(s) : " + var7;
            this.var_requete = this.var_requete + " AND bulsal_num_banque in" + var7;
         }
      }

      if (var8 != null && !var8.isEmpty()) {
         if (!var8.contains("|")) {
            String var11 = var8.replace("(", "").replace(")", "");
            this.tiersRec = this.tiersDao.selectTierD(Long.parseLong(var11));
            if (this.tiersRec != null) {
               this.var_filtre = this.var_filtre + " Le tiers : " + this.tiersRec.getTieraisonsocialenom();
               this.var_requete = this.var_requete + " AND bulsal_id_tiers=" + Long.parseLong(var11);
            }
         } else {
            this.var_filtre = this.var_filtre + " Le(s) tiers : " + var8;
            this.var_requete = this.var_requete + " AND bulsal_id_tiers in" + var8;
         }
      }

      if (this.var_requete != null && !this.var_requete.isEmpty() && this.var_requete.contains("|")) {
         this.var_requete = this.var_requete.replace("|", ",");
      }

      BulletinSalaireDao var12 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
      this.lesVirements = var12.chargerlesBulletinsByRequeteVirement(this.var_requete, (Session)null);
   }

   public void exportDts(Date var1, Date var2, String var3, String var4, String var5, String var6, String var7, String var8) throws HibernateException, NamingException {
      this.rechercheBulletin(var1, var2, var3, var4, var5, var6, var7, var8);
      Session var9 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      new ArrayList();
      BulletinSalaireDao var11 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
      List var10 = var11.chargerlesBulletinsByRequete(this.var_requete, var9);
      if (var10.size() != 0) {
         String var12 = "";

         for(int var13 = 0; var13 < var10.size(); ++var13) {
            if (var12 != null && !var12.isEmpty()) {
               var12 = var12 + "," + ((BulletinSalaire)var10.get(var13)).getBulsalId();
            } else {
               var12 = "" + ((BulletinSalaire)var10.get(var13)).getBulsalId();
            }
         }

         this.lesTrfPaye = new ArrayList();
         new ArrayList();
         BulletinLigneDao var14 = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
         String var15 = "(BulletinSalaire.bulsalId in (" + var12 + ") and (bulligRubrique='100000' or bulligRubrique='100010' or bulligRubrique='100050' or bulligRubrique='300000' or bulligRubrique='300020' or bulligRubrique='900000' or bulligRubrique='900020'))";
         List var22 = var14.chargerLigneBulletinsRequete(var15, var9);
         if (var22.size() != 0) {
            new BulletinLigne();
            TransfertPaye var17 = new TransfertPaye();

            for(int var18 = 0; var18 < var22.size(); ++var18) {
               BulletinLigne var16 = (BulletinLigne)var22.get(var18);
               this.salaries = var16.getSalaries();
               int var19 = var16.getBulletinSalaire().getBulsalDateDebutReel().getMonth() + 1;
               boolean var20 = false;

               for(int var21 = 0; var21 < this.lesTrfPaye.size(); ++var21) {
                  if (((TransfertPaye)this.lesTrfPaye.get(var21)).getTrfNomFeuille().equals(this.salaries.getSalMatricule())) {
                     var17 = (TransfertPaye)this.lesTrfPaye.get(var21);
                     var20 = true;
                     break;
                  }
               }

               if (var20) {
                  if (var19 != 1 && var19 != 4 && var19 != 7 && var19 != 10) {
                     if (var19 != 2 && var19 != 5 && var19 != 8 && var19 != 11) {
                        if (var19 == 3 || var19 == 6 || var19 == 9 || var19 == 12) {
                           if (!var16.getBulligRubrique().equals("100000") && !var16.getBulligRubrique().equals("100010")) {
                              if (var16.getBulligRubrique().equals("100050")) {
                                 var17.setTrfColN46(var17.getTrfColN46());
                              } else if (var16.getBulligRubrique().equals("300000")) {
                                 var17.setTrfColN51(var17.getTrfColN51() + var16.getBulligValColA());
                                 var17.setTrfColN52(var17.getTrfColN52() + var16.getBulligValColB());
                                 var17.setTrfColN41(var17.getTrfColN41() + var16.getBulligValColE());
                              } else if (var16.getBulligRubrique().equals("300020")) {
                                 var17.setTrfColN53(var17.getTrfColN53() + var16.getBulligValColA());
                                 var17.setTrfColN54(var17.getTrfColN54() + var16.getBulligValColB());
                                 var17.setTrfColN42(var17.getTrfColN42() + var16.getBulligValColE());
                              } else if (var16.getBulligRubrique().equals("900000")) {
                                 var17.setTrfColN43(var17.getTrfColN43() + var16.getBulligValColE());
                              } else if (var16.getBulligRubrique().equals("900020")) {
                                 var17.setTrfColN44(var17.getTrfColN44() + var16.getBulligValColE());
                              }
                           } else {
                              var17.setTrfColN40(var17.getTrfColN40() + var16.getBulligValColE());
                              if (var17.getTrfColN45() == 0.0D) {
                                 var17.setTrfColN45(30.0D);
                              }

                              var17.setTrfColN45(var17.getTrfColN45());
                           }
                        }
                     } else if (!var16.getBulligRubrique().equals("100000") && !var16.getBulligRubrique().equals("100010")) {
                        if (var16.getBulligRubrique().equals("100050")) {
                           var17.setTrfColN26(var17.getTrfColN26());
                        } else if (var16.getBulligRubrique().equals("300000")) {
                           var17.setTrfColN31(var17.getTrfColN31() + var16.getBulligValColA());
                           var17.setTrfColN32(var17.getTrfColN32() + var16.getBulligValColB());
                           var17.setTrfColN21(var17.getTrfColN21() + var16.getBulligValColE());
                        } else if (var16.getBulligRubrique().equals("300020")) {
                           var17.setTrfColN33(var17.getTrfColN33() + var16.getBulligValColA());
                           var17.setTrfColN34(var17.getTrfColN34() + var16.getBulligValColB());
                           var17.setTrfColN22(var17.getTrfColN22() + var16.getBulligValColE());
                        } else if (var16.getBulligRubrique().equals("900000")) {
                           var17.setTrfColN23(var17.getTrfColN23() + var16.getBulligValColE());
                        } else if (var16.getBulligRubrique().equals("900020")) {
                           var17.setTrfColN24(var17.getTrfColN24() + var16.getBulligValColE());
                        }
                     } else {
                        var17.setTrfColN20(var17.getTrfColN20() + var16.getBulligValColE());
                        if (var17.getTrfColN25() == 0.0D) {
                           var17.setTrfColN25(30.0D);
                        }

                        var17.setTrfColN25(var17.getTrfColN25());
                     }
                  } else if (!var16.getBulligRubrique().equals("100000") && !var16.getBulligRubrique().equals("100010")) {
                     if (var16.getBulligRubrique().equals("100050")) {
                        var17.setTrfColN06(var17.getTrfColN06());
                     } else if (var16.getBulligRubrique().equals("300000")) {
                        var17.setTrfColN11(var17.getTrfColN11() + var16.getBulligValColA());
                        var17.setTrfColN12(var17.getTrfColN12() + var16.getBulligValColB());
                        var17.setTrfColN01(var17.getTrfColN01() + var16.getBulligValColE());
                     } else if (var16.getBulligRubrique().equals("300020")) {
                        var17.setTrfColN13(var17.getTrfColN13() + var16.getBulligValColA());
                        var17.setTrfColN14(var17.getTrfColN14() + var16.getBulligValColB());
                        var17.setTrfColN02(var17.getTrfColN02() + var16.getBulligValColE());
                     } else if (var16.getBulligRubrique().equals("900000")) {
                        var17.setTrfColN03(var17.getTrfColN03() + var16.getBulligValColE());
                     } else if (var16.getBulligRubrique().equals("900020")) {
                        var17.setTrfColN04(var17.getTrfColN04() + var16.getBulligValColE());
                     }
                  } else {
                     var17.setTrfColN00(var17.getTrfColN00() + var16.getBulligValColE());
                     if (var17.getTrfColN05() == 0.0D) {
                        var17.setTrfColN05(30.0D);
                     }

                     var17.setTrfColN05(var17.getTrfColN05());
                  }
               } else {
                  var17 = new TransfertPaye();
                  var17.setTrfNomFeuille(this.salaries.getSalMatricule());
                  var17.setTrfColT00(this.filtreCaracteres(this.salaries.getSalNom()));
                  if (this.salaries.getSalPrenom() != null && !this.salaries.getSalPrenom().isEmpty()) {
                     var17.setTrfColT01(this.filtreCaracteres(this.salaries.getSalPrenom()));
                  } else {
                     var17.setTrfColT01("");
                  }

                  var17.setTrfColT02(this.salaries.getSalNumSecu());
                  var17.setTrfColT03(this.salaries.getSalNumCnamgs());
                  if (this.salaries.getSalDateEntree() != null) {
                     var17.setTrfColT04(this.utilDate.dateToStringSQLLight(this.salaries.getSalDateEntree()).replace("-", ""));
                  } else {
                     var17.setTrfColT04("");
                  }

                  if (this.salaries.getSalDateSortie() != null) {
                     var17.setTrfColT05(this.utilDate.dateToStringSQLLight(this.salaries.getSalDateSortie()).replace("-", ""));
                  } else {
                     var17.setTrfColT05("");
                  }

                  if (var19 != 1 && var19 != 4 && var19 != 7 && var19 != 10) {
                     if (var19 != 2 && var19 != 5 && var19 != 8 && var19 != 11) {
                        if (var19 == 3 || var19 == 6 || var19 == 9 || var19 == 12) {
                           if (!var16.getBulligRubrique().equals("100000") && !var16.getBulligRubrique().equals("100010")) {
                              if (var16.getBulligRubrique().equals("100050")) {
                                 var17.setTrfColN46(var16.getBulligValColD());
                              } else if (var16.getBulligRubrique().equals("300000")) {
                                 var17.setTrfColN51(var16.getBulligValColA());
                                 var17.setTrfColN52(var16.getBulligValColB());
                                 var17.setTrfColN41(var16.getBulligValColE());
                              } else if (var16.getBulligRubrique().equals("300020")) {
                                 var17.setTrfColN53(var16.getBulligValColA());
                                 var17.setTrfColN54(var16.getBulligValColB());
                                 var17.setTrfColN42(var16.getBulligValColE());
                              } else if (var16.getBulligRubrique().equals("900000")) {
                                 var17.setTrfColN43(var16.getBulligValColE());
                              } else if (var16.getBulligRubrique().equals("900020")) {
                                 var17.setTrfColN44(var16.getBulligValColE());
                              }
                           } else {
                              var17.setTrfColN40(var16.getBulligValColE());
                              if (var16.getBulligRubrique().equals("100010")) {
                                 var17.setTrfColN45(var16.getBulligValColD() / 8.0D);
                              } else {
                                 var17.setTrfColN45(var16.getBulligValColD());
                              }
                           }
                        }
                     } else if (!var16.getBulligRubrique().equals("100000") && !var16.getBulligRubrique().equals("100010")) {
                        if (var16.getBulligRubrique().equals("100050")) {
                           var17.setTrfColN26(var16.getBulligValColD());
                        } else if (var16.getBulligRubrique().equals("300000")) {
                           var17.setTrfColN31(var16.getBulligValColA());
                           var17.setTrfColN32(var16.getBulligValColB());
                           var17.setTrfColN21(var16.getBulligValColE());
                        } else if (var16.getBulligRubrique().equals("300020")) {
                           var17.setTrfColN33(var16.getBulligValColA());
                           var17.setTrfColN34(var16.getBulligValColB());
                           var17.setTrfColN22(var16.getBulligValColE());
                        } else if (var16.getBulligRubrique().equals("900000")) {
                           var17.setTrfColN23(var16.getBulligValColE());
                        } else if (var16.getBulligRubrique().equals("900020")) {
                           var17.setTrfColN24(var16.getBulligValColE());
                        }
                     } else {
                        var17.setTrfColN20(var16.getBulligValColE());
                        if (var16.getBulligRubrique().equals("100010")) {
                           var17.setTrfColN25(var16.getBulligValColD() / 8.0D);
                        } else {
                           var17.setTrfColN25(var16.getBulligValColD());
                        }
                     }
                  } else if (!var16.getBulligRubrique().equals("100000") && !var16.getBulligRubrique().equals("100010")) {
                     if (var16.getBulligRubrique().equals("100050")) {
                        var17.setTrfColN06(var16.getBulligValColD());
                     } else if (var16.getBulligRubrique().equals("300000")) {
                        var17.setTrfColN11(var16.getBulligValColA());
                        var17.setTrfColN12(var16.getBulligValColB());
                        var17.setTrfColN01(var16.getBulligValColE());
                     } else if (var16.getBulligRubrique().equals("300020")) {
                        var17.setTrfColN13(var16.getBulligValColA());
                        var17.setTrfColN14(var16.getBulligValColB());
                        var17.setTrfColN02(var16.getBulligValColE());
                     } else if (var16.getBulligRubrique().equals("900000")) {
                        var17.setTrfColN03(var16.getBulligValColE());
                     } else if (var16.getBulligRubrique().equals("900020")) {
                        var17.setTrfColN04(var16.getBulligValColE());
                     }
                  } else {
                     var17.setTrfColN00(var16.getBulligValColE());
                     if (var16.getBulligRubrique().equals("100010")) {
                        var17.setTrfColN05(var16.getBulligValColD() / 8.0D);
                     } else {
                        var17.setTrfColN05(var16.getBulligValColD());
                     }
                  }

                  this.lesTrfPaye.add(var17);
               }
            }
         }
      }

      this.utilInitHibernate.closeSession();
   }

   public String calculeContactBanque(String var1) throws HibernateException, NamingException {
      String var2 = "";
      if (var1 != null && !var1.isEmpty() && var1.contains("=") && var1.contains(":")) {
         String[] var3 = var1.split("=");
         String var4 = var3[0];
         String var5 = var3[1];
         String[] var6 = var5.split(":");
         String var7 = var6[0];
         String var8 = var6[1];
         String var9 = var6[2];
         String var10 = var6[3];
         new Contacts();
         ContactDao var12 = new ContactDao(this.baseLog, this.utilInitHibernate);
         Contacts var11 = var12.chargerLesContactsBq(var7, var8, var9, var10, (Session)null);
         if (var11 != null) {
            if (var11.getConcivilite() != null && !var11.getConcivilite().isEmpty()) {
               var2 = var11.getConcivilite();
            }

            var2 = var2 + " " + var11.getConpatronyme();
         }
      }

      return var2;
   }

   public void calculIsr(String var1, String var2, String var3) throws HibernateException, NamingException, ParseException {
      this.lesIsr.clear();
      new ArrayList();
      new ArrayList();
      this.var_entete = this.nomEtat.toUpperCase() + " au " + var1;
      this.var_requete = "(salcon_date_fin is null or salcon_date_fin<='" + var2 + "')";
      if (this.nomSalarie != null && !this.nomSalarie.isEmpty()) {
         this.var_filtre = this.var_filtre + " Le salarié : " + this.nomSalarie;
         this.var_requete = this.var_requete + " and Salaries.bul_matricule like '" + this.nomSalarie + "%'";
      }

      if (this.etatSalarie != 100) {
         this.var_filtre = this.var_filtre + " L'état : " + this.libelleEtat;
         if (this.etatSalarie == 0) {
            this.var_requete = this.var_requete + " and salcon_etat <= 1";
         } else {
            this.var_requete = this.var_requete + " and salcon_etat =" + this.etatSalarie;
         }
      }

      if (this.tiers != 0L) {
         this.tiersRec = this.tiersDao.selectTierD(this.tiers);
         if (this.tiersRec != null) {
            this.nomtiers = this.tiersRec.getTieraisonsocialenom();
         } else {
            this.nomtiers = "" + this.tiers;
         }

         this.var_filtre = this.var_filtre + " Le tiers : " + this.nomtiers;
         this.var_requete = this.var_requete + " and salcon_id_tiers =" + this.tiers;
      }

      if (this.feuille != null && !this.feuille.isEmpty() && !this.feuille.equals("100")) {
         this.var_filtre = this.var_filtre + " La feuille : " + this.feuille;
         this.var_requete = this.var_requete + " and salcon_feuille ='" + this.feuille + "'";
      }

      if (this.natureSalarie != null && !this.natureSalarie.isEmpty() && !this.natureSalarie.equals("100")) {
         this.var_filtre = this.var_filtre + " La nature : " + this.natureSalarie;
         this.var_requete = this.var_requete + " and salcon_type ='" + this.natureSalarie + "'";
      } else if (this.natureAutorisee != null && !this.natureAutorisee.isEmpty()) {
         this.var_requete = this.var_requete + " and salcon_type in (" + this.natureAutorisee + ")";
      }

      String[] var6;
      if (this.convention != null && !this.convention.isEmpty() && this.convention.contains(":")) {
         var6 = this.convention.split(":");
         this.var_filtre = this.var_filtre + " La convention : " + var6[0];
         this.var_requete = this.var_requete + " and salcon_convention ='" + var6[0] + "'";
      }

      if (this.grille != null && !this.grille.isEmpty() && this.grille.contains(":")) {
         var6 = this.grille.split(":");
         this.var_filtre = this.var_filtre + " La catégorie : " + var6[0];
         this.var_requete = this.var_requete + " and salcon_grille ='" + var6[0] + "'";
      }

      if (this.centre != null && !this.centre.isEmpty() && this.centre.contains(":")) {
         var6 = this.centre.split(":");
         this.var_filtre = this.var_filtre + " Le centre d'impôt : " + var6[1];
         this.var_requete = this.var_requete + " and bulsal_Cod_Centres_Impots ='" + var6[0] + "'";
      }

      if (this.classement != null && !this.classement.isEmpty() && this.classement.contains(":")) {
         var6 = this.classement.split(":");
         this.var_filtre = this.var_filtre + " Le classement : " + var6[1];
         this.var_requete = this.var_requete + " and salcon_classement ='" + var6[0] + "'";
      }

      if (this.niveauEmploi != null && !this.niveauEmploi.isEmpty() && this.niveauEmploi.contains(":")) {
         var6 = this.niveauEmploi.split(":");
         this.var_filtre = this.var_filtre + " Le niveau : " + var6[1];
         this.var_requete = this.var_requete + " salcon_niv_emploi ='" + var6[0] + "'";
      }

      if (var3 != null && !var3.isEmpty()) {
         if (var3.contains(":")) {
            var6 = var3.split(":");
            String var7 = var6[0];
            this.var_filtre = this.var_filtre + " L`activité : " + var7;
            this.var_requete = this.var_requete + " AND salcon_acticvite='" + var7 + "'";
         } else if (var3.contains("(")) {
            this.var_filtre = this.var_filtre + " Le(s) actvité(s) : " + var3;
            this.var_requete = this.var_requete + " AND salcon_acticvite in" + var3;
         }
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         var6 = this.site.split(":");
         this.var_filtre = this.var_filtre + " Le site : " + var6[1];
         this.var_requete = this.var_requete + " and salcon_site ='" + var6[0] + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         var6 = this.departement.split(":");
         this.var_filtre = this.var_filtre + " Le département : " + var6[1];
         this.var_requete = this.var_requete + " and salcon_departement ='" + var6[0] + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         var6 = this.service.split(":");
         this.var_filtre = this.var_filtre + " Le service : " + var6[1];
         this.var_requete = this.var_requete + " and salcon_service ='" + var6[0] + "'";
      }

      if (this.budget != null && !this.budget.isEmpty() && this.budget.contains(":")) {
         var6 = this.budget.split(":");
         this.var_filtre = this.var_filtre + " Le budget : " + var6[1];
         this.var_requete = this.var_requete + " and salcon_budget ='" + var6[0] + "'";
      }

      Session var48 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      SalariesContratsDao var47 = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
      BulletinLigneDao var8 = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
      new SalariesContrats();
      List var4 = var47.chargerlesContratsByRequete(this.var_requete, var48);
      if (var4.size() != 0) {
         new ArrayList();
         LectureConventions var11 = new LectureConventions();
         var11.setStrId(this.structureLog.getStrid());
         var11.setStructureLog(this.structureLog);
         var11.recuperePaye();
         List var10 = var11.getMesConventionsUtils();
         if (var10.size() == 0) {
            var10 = var11.getMesConventions();
         }

         Date var12 = this.utilDate.datedevaleurMois(this.utilDate.datePremierJourMois(this.filtreDateFin), -12);

         label226:
         for(int var13 = 0; var13 < var4.size(); ++var13) {
            this.salaries = ((SalariesContrats)var4.get(var13)).getSalaries();
            SalariesContrats var9 = (SalariesContrats)var4.get(var13);
            List var5 = var8.chargerles12BulletinsbySalarie(var12, this.filtreDateFin, this.salaries, var48);
            boolean var14 = false;
            boolean var15 = false;
            long var16 = 0L;
            double var18 = 0.0D;
            double var20 = 0.0D;
            float var22 = 0.0F;
            float var23 = 0.0F;
            float var24 = 0.0F;
            float var25 = 0.0F;
            float var26 = 0.0F;
            if (var9.getSalconConvention() != null && !var9.getSalconConvention().isEmpty()) {
               for(int var27 = 0; var27 < var10.size(); ++var27) {
                  if (((ObjetConvention)var10.get(var27)).getCode().equals(var9.getSalconConvention())) {
                     var22 = ((ObjetConvention)var10.get(var27)).getTranche1();
                     var23 = ((ObjetConvention)var10.get(var27)).getTranche2();
                     var24 = ((ObjetConvention)var10.get(var27)).getTranche3();
                     var25 = ((ObjetConvention)var10.get(var27)).getTranche4();
                     var26 = ((ObjetConvention)var10.get(var27)).getTranche5();
                     break;
                  }
               }

               byte var51 = 1;
               byte var28 = 12;
               Calendar var29 = Calendar.getInstance();
               Calendar var30 = Calendar.getInstance();
               Calendar var31 = Calendar.getInstance();
               var29.setTime(var9.getSalconDateDebut());
               var30.setTime(this.utilDate.dateDernierJourMois(this.filtreDateFin));
               int var50 = 0;

               while(true) {
                  do {
                     if (!var29.before(var30)) {
                        int var49 = var50 / var28;
                        var50 -= var49 * var28;
                        var31 = Calendar.getInstance();
                        var31.setTime(var9.getSalconDateDebut());
                        var31.add(1, var49);
                        var31.add(2, var50);
                        var16 = (var30.getTimeInMillis() - var31.getTimeInMillis()) / 86400000L;
                        int var32 = 0;
                        Date var33 = null;
                        Date var34 = null;
                        int var35;
                        if (var5.size() != 0) {
                           for(var35 = 0; var35 < var5.size(); ++var35) {
                              var18 += ((BulletinLigne)var5.get(var35)).getBulligValColE();
                              if (var33 == null && var35 == 0) {
                                 var33 = ((BulletinLigne)var5.get(var35)).getBulletinSalaire().getBulsalDateDebut();
                              }

                              if (var34 == null && var35 == var5.size() - 1) {
                                 var34 = ((BulletinLigne)var5.get(var35)).getBulletinSalaire().getBulsalDateDebut();
                              }
                           }

                           for(var35 = 1; var34.compareTo(var33) < 0; var32 = var35++) {
                              var34 = this.utilDate.dateMoisSuivant(var34);
                           }

                           var20 = var18 / (double)(var32 + 1);
                        }

                        this.objetIsr = new ObjetIsr();
                        this.objetIsr.setMatricule(this.salaries.getSalMatricule());
                        this.objetIsr.setPatronyme(this.salaries.getPatronyme());
                        this.objetIsr.setConvention(var9.getSalconConvention());
                        this.objetIsr.setDateEntree(var9.getSalconDateDebut());
                        this.objetIsr.setNbAnee(var49);
                        this.objetIsr.setNbMois(var50);
                        this.objetIsr.setBaseBrute(var18);
                        this.objetIsr.setMoyBrute(var20);
                        boolean var52 = false;
                        float var36 = 0.0F;
                        if (var49 >= 2) {
                           this.objetIsr.setTauxT1(var22);
                           var36 = var22;
                           if (var49 > 5) {
                              var35 = 5;
                           } else {
                              var35 = var49;
                           }

                           this.objetIsr.setNbAnneeT1(var35);
                           double var37 = this.utilNombre.myRoundDevise(this.objetIsr.getMoyBrute() * (double)this.objetIsr.getTauxT1() / 100.0D * (double)this.objetIsr.getNbAnneeT1(), this.structureLog.getStrdevise());
                           this.objetIsr.setValT1(var37);
                           var49 -= var35;
                           double var39;
                           if (var49 != 0) {
                              this.objetIsr.setTauxT2(var23);
                              var36 = var23;
                              if (var49 > 5) {
                                 var35 = 5;
                              } else {
                                 var35 = var49;
                              }

                              this.objetIsr.setNbAnneeT2(var35);
                              var39 = this.utilNombre.myRoundDevise(this.objetIsr.getMoyBrute() * (double)this.objetIsr.getTauxT2() / 100.0D * (double)this.objetIsr.getNbAnneeT2(), this.structureLog.getStrdevise());
                              this.objetIsr.setValT2(var39);
                              var49 -= var35;
                              if (var49 != 0) {
                                 this.objetIsr.setTauxT3(var24);
                                 var36 = var24;
                                 if (var49 > 5) {
                                    var35 = 5;
                                 } else {
                                    var35 = var49;
                                 }

                                 this.objetIsr.setNbAnneeT3(var35);
                                 double var41 = this.utilNombre.myRoundDevise(this.objetIsr.getMoyBrute() * (double)this.objetIsr.getTauxT3() / 100.0D * (double)this.objetIsr.getNbAnneeT3(), this.structureLog.getStrdevise());
                                 this.objetIsr.setValT3(var41);
                                 var49 -= var35;
                                 if (var49 != 0) {
                                    this.objetIsr.setTauxT4(var25);
                                    if (var49 > 5) {
                                       var35 = 5;
                                    } else {
                                       var35 = var49;
                                    }

                                    this.objetIsr.setNbAnneeT4(var35);
                                    double var43 = this.utilNombre.myRoundDevise(this.objetIsr.getMoyBrute() * (double)this.objetIsr.getTauxT4() / 100.0D * (double)this.objetIsr.getNbAnneeT4(), this.structureLog.getStrdevise());
                                    this.objetIsr.setValT4(var43);
                                    var49 -= var35;
                                    this.objetIsr.setTauxT5(var26);
                                    var36 = var26;
                                    if (var49 > 0) {
                                       this.objetIsr.setNbAnneeT5(var49);
                                       double var45 = this.utilNombre.myRoundDevise(this.objetIsr.getMoyBrute() * (double)this.objetIsr.getTauxT5() / 100.0D * (double)this.objetIsr.getNbAnneeT5(), this.structureLog.getStrdevise());
                                       this.objetIsr.setValT5(var45);
                                    }
                                 }
                              }
                           }

                           this.objetIsr.setTauxT6(var36);
                           if (var50 > 0) {
                              this.objetIsr.setNbMoisT6(var50);
                              var39 = this.utilNombre.myRoundDevise(this.objetIsr.getMoyBrute() * (double)this.objetIsr.getTauxT6() / 100.0D * (double)(this.objetIsr.getNbMoisT6() / 12), this.structureLog.getStrdevise());
                              this.objetIsr.setValT6(var39);
                           }

                           var39 = this.objetIsr.getValT1() + this.objetIsr.getValT2() + this.objetIsr.getValT3() + this.objetIsr.getValT4() + this.objetIsr.getValT5() + this.objetIsr.getValT6();
                           this.objetIsr.setValIsr(var39);
                        }

                        this.lesIsr.add(this.objetIsr);
                        continue label226;
                     }

                     var29.add(2, var51);
                  } while(!var29.before(var30) && !var29.equals(var30));

                  ++var50;
               }
            }
         }
      }

   }

   public void calculCp(String var1, String var2, String var3) throws HibernateException, NamingException, ParseException, IOException {
      String var4 = "";
      this.lesCp = new ArrayList();
      new ArrayList();
      ArrayList var6 = new ArrayList();
      ArrayList var7 = new ArrayList();
      this.var_entete = this.nomEtat.toUpperCase() + " au " + var1;
      this.var_requete = "(salcon_date_fin is null or salcon_date_fin<='" + var2 + "')";
      if (this.nomSalarie != null && !this.nomSalarie.isEmpty()) {
         this.var_filtre = this.var_filtre + " Le salarié : " + this.nomSalarie;
         this.var_requete = this.var_requete + " and Salaries.bul_matricule like '" + this.nomSalarie + "%'";
      }

      if (this.etatSalarie != 100) {
         this.var_filtre = this.var_filtre + " L'état : " + this.libelleEtat;
         if (this.etatSalarie == 0) {
            this.var_requete = this.var_requete + " and salcon_etat <= 1";
         } else {
            this.var_requete = this.var_requete + " and salcon_etat =" + this.etatSalarie;
         }
      }

      if (this.tiers != 0L) {
         this.tiersRec = this.tiersDao.selectTierD(this.tiers);
         if (this.tiersRec != null) {
            this.nomtiers = this.tiersRec.getTieraisonsocialenom();
         } else {
            this.nomtiers = "" + this.tiers;
         }

         this.var_filtre = this.var_filtre + " Le tiers : " + this.nomtiers;
         this.var_requete = this.var_requete + " and salcon_id_tiers =" + this.tiers;
      }

      if (this.feuille != null && !this.feuille.isEmpty() && !this.feuille.equals("100")) {
         this.var_filtre = this.var_filtre + " La feuille : " + this.feuille;
         this.var_requete = this.var_requete + " and salcon_feuille ='" + this.feuille + "'";
      }

      if (this.natureSalarie != null && !this.natureSalarie.isEmpty() && !this.natureSalarie.equals("100")) {
         this.var_filtre = this.var_filtre + " La nature : " + this.natureSalarie;
         this.var_requete = this.var_requete + " and salcon_type ='" + this.natureSalarie + "'";
      } else if (this.natureAutorisee != null && !this.natureAutorisee.isEmpty()) {
         this.var_requete = this.var_requete + " and salcon_type in (" + this.natureAutorisee + ")";
      }

      String[] var8;
      if (this.convention != null && !this.convention.isEmpty() && this.convention.contains(":")) {
         var8 = this.convention.split(":");
         this.var_filtre = this.var_filtre + " La convention : " + var8[0];
         this.var_requete = this.var_requete + " and salcon_convention ='" + var8[0] + "'";
      }

      if (this.grille != null && !this.grille.isEmpty() && this.grille.contains(":")) {
         var8 = this.grille.split(":");
         this.var_filtre = this.var_filtre + " La catégorie : " + var8[0];
         this.var_requete = this.var_requete + " and salcon_grille ='" + var8[0] + "'";
      }

      if (this.centre != null && !this.centre.isEmpty() && this.centre.contains(":")) {
         var8 = this.centre.split(":");
         this.var_filtre = this.var_filtre + " Le centre d'impôt : " + var8[1];
         this.var_requete = this.var_requete + " and bulsal_Cod_Centres_Impots ='" + var8[0] + "'";
      }

      if (this.classement != null && !this.classement.isEmpty() && this.classement.contains(":")) {
         var8 = this.classement.split(":");
         this.var_filtre = this.var_filtre + " Le classement : " + var8[1];
         this.var_requete = this.var_requete + " and salcon_classement ='" + var8[0] + "'";
      }

      if (this.niveauEmploi != null && !this.niveauEmploi.isEmpty() && this.niveauEmploi.contains(":")) {
         var8 = this.niveauEmploi.split(":");
         this.var_filtre = this.var_filtre + " Le niveau : " + var8[1];
         this.var_requete = this.var_requete + " salcon_niv_emploi ='" + var8[0] + "'";
      }

      String var9;
      if (var3 != null && !var3.isEmpty()) {
         if (var3.contains(":")) {
            var8 = var3.split(":");
            var9 = var8[0];
            this.var_filtre = this.var_filtre + " L`activité : " + var9;
            this.var_requete = this.var_requete + " AND salcon_acticvite='" + var9 + "'";
         } else if (var3.contains("(")) {
            this.var_filtre = this.var_filtre + " Le(s) actvité(s) : " + var3;
            this.var_requete = this.var_requete + " AND salcon_acticvite in" + var3;
         }
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         var8 = this.site.split(":");
         this.var_filtre = this.var_filtre + " Le site : " + var8[1];
         this.var_requete = this.var_requete + " and salcon_site ='" + var8[0] + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         var8 = this.departement.split(":");
         this.var_filtre = this.var_filtre + " Le département : " + var8[1];
         this.var_requete = this.var_requete + " and salcon_departement ='" + var8[0] + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         var8 = this.service.split(":");
         this.var_filtre = this.var_filtre + " Le service : " + var8[1];
         this.var_requete = this.var_requete + " and salcon_service ='" + var8[0] + "'";
      }

      if (this.budget != null && !this.budget.isEmpty() && this.budget.contains(":")) {
         var8 = this.budget.split(":");
         this.var_filtre = this.var_filtre + " Le budget : " + var8[1];
         this.var_requete = this.var_requete + " and salcon_budget ='" + var8[0] + "'";
      }

      String var29 = "" + (this.filtreDateFin.getYear() + 1900);
      var9 = "";
      if (this.filtreDateFin.getMonth() + 1 <= 9) {
         var9 = "0" + (this.filtreDateFin.getMonth() + 1);
      } else {
         var9 = "" + (this.filtreDateFin.getMonth() + 1);
      }

      var4 = var9 + ":" + var29;
      Session var10 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      FormCalculBulletin var11 = new FormCalculBulletin();
      var11.setutilInitHibernate(this.utilInitHibernate);
      var11.setBaseLog(this.baseLog);
      var11.setStructureLog(this.structureLog);
      var11.setUsersLog(this.usersLog);
      var11.InstancesDaoUtilses();
      var11.setNature(this.nature);
      var11.setExercicesPaye(this.exoSelectionne);
      var11.setLastExoPaye(this.exoSelectionne);
      var11.setOptionPaye(this.optionPaye);
      SalariesContratsDao var12 = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
      new SalariesContrats();
      SalariesElements var14 = new SalariesElements();
      BulletinSalaireDao var15 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
      BulletinLigneDao var16 = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
      new BulletinLigne();
      new SalariesHistoriqueDao(this.baseLog, this.utilInitHibernate);
      new SalariesHistorique();
      List var5 = var12.chargerlesContratsByRequete(this.var_requete, var10);
      if (var5.size() != 0) {
         for(int var20 = 0; var20 < var5.size(); ++var20) {
            SalariesContrats var13 = (SalariesContrats)var5.get(var20);
            this.salaries = var13.getSalaries();
            if (var13.getSalconDateDebut() != null) {
               var11.setSalaries(this.salaries);
               var11.setSalariesContrats(var13);
               var11.setDateGeneration(this.filtreDateFin);
               var14.setSalaries(this.salaries);
               var14.setSaleleGenre(this.salaries.getSalGenre());
               var11.setSalariesElements(var14);
               var7.clear();
               var6.clear();
               this.objetCp = new ObjetCp();
               this.objetCp.setMatricule(this.salaries.getSalMatricule());
               this.objetCp.setPatronyme(this.salaries.getPatronyme());
               this.objetCp.setNbJourCp((double)var13.getSalconNbJourCp());
               this.objetCp.setNbJourTr((double)var13.getSalconNbJourTr());
               this.objetCp.setDateEntree(var13.getSalconDateDebut());
               this.objetCp.setNbJourAnciennete(var11.M000069(var10));
               if (this.salaries.getSalGenre() == 0) {
                  this.objetCp.setNbJourEnfant((double)var11.M000070(var10));
               } else {
                  this.objetCp.setNbJourEnfant(0.0D);
               }

               this.objetCp = this.M000004(var15, var13, var7, var16, var6, this.objetCp, var4, var10);
               double var21 = this.objetCp.getNbJourAcquis() + this.objetCp.getNbJourAnciennete() + this.objetCp.getNbJourEnfant() - this.objetCp.getNbJourPris();
               this.objetCp.setNbJourDu(var21);
               if (this.objetCp.getDateRetour() != null) {
                  this.objetCp.setDateDepartTheo(this.utilDate.datedevaleurMois(this.objetCp.getDateRetour(), 12));
               } else if (this.objetCp.getDateEntree() != null) {
                  this.objetCp.setDateDepartTheo(this.utilDate.datedevaleurMois(this.objetCp.getDateEntree(), 12));
               } else {
                  this.objetCp.setDateDepartTheo((Date)null);
               }

               if (this.objetCp.getNbJourTr() == 0.0D) {
                  this.objetCp.setNbJourTr(1.0D);
               }

               double var23 = 0.0D;
               if (this.objetCp.getNbJourTr() != 0.0D) {
                  var23 = this.objetCp.getBaseConges() * this.objetCp.getNbJourCp() / this.objetCp.getNbJourTr();
               } else {
                  var23 = this.utilNombre.myRoundDevise(var23, this.structureLog.getStrdevise());
               }

               double var25 = var23 / this.objetCp.getNbJourTr() * this.objetCp.getNbJourAnciennete();
               double var27 = var23 / this.objetCp.getNbJourTr() * this.objetCp.getNbJourEnfant();
               this.objetCp.setValeurCongesTheo(var23);
               this.objetCp.setValeurCongesTheoAnciennete(var25);
               this.objetCp.setValeurCongesTheoEnfant(var27);
               this.lesCp.add(this.objetCp);
            }
         }
      }

   }

   public void calculCtrl(String var1, String var2, String var3) throws HibernateException, NamingException, ParseException {
      String var4 = "";
      this.lesCtrl = new ArrayList();
      new ArrayList();
      this.var_entete = this.nomEtat.toUpperCase() + " au " + var1;
      this.var_requete = "(salcon_date_fin is null or salcon_date_fin<='" + var2 + "') and salcon_etat = 0";
      if (this.nomSalarie != null && !this.nomSalarie.isEmpty()) {
         this.var_filtre = this.var_filtre + " Le salarié : " + this.nomSalarie;
         this.var_requete = this.var_requete + " and Salaries.bul_matricule like '" + this.nomSalarie + "%'";
      }

      if (this.tiers != 0L) {
         this.tiersRec = this.tiersDao.selectTierD(this.tiers);
         if (this.tiersRec != null) {
            this.nomtiers = this.tiersRec.getTieraisonsocialenom();
         } else {
            this.nomtiers = "" + this.tiers;
         }

         this.var_filtre = this.var_filtre + " Le tiers : " + this.nomtiers;
         this.var_requete = this.var_requete + " and salcon_id_tiers =" + this.tiers;
      }

      if (this.feuille != null && !this.feuille.isEmpty() && !this.feuille.equals("100")) {
         this.var_filtre = this.var_filtre + " La feuille : " + this.feuille;
         this.var_requete = this.var_requete + " and salcon_feuille ='" + this.feuille + "'";
      }

      if (this.natureSalarie != null && !this.natureSalarie.isEmpty() && !this.natureSalarie.equals("100")) {
         this.var_filtre = this.var_filtre + " La nature : " + this.natureSalarie;
         this.var_requete = this.var_requete + " and salcon_type ='" + this.natureSalarie + "'";
      } else if (this.natureAutorisee != null && !this.natureAutorisee.isEmpty()) {
         this.var_requete = this.var_requete + " and salcon_type in (" + this.natureAutorisee + ")";
      }

      String[] var6;
      if (this.convention != null && !this.convention.isEmpty() && this.convention.contains(":")) {
         var6 = this.convention.split(":");
         this.var_filtre = this.var_filtre + " La convention : " + var6[0];
         this.var_requete = this.var_requete + " and salcon_convention ='" + var6[0] + "'";
      }

      if (this.grille != null && !this.grille.isEmpty() && this.grille.contains(":")) {
         var6 = this.grille.split(":");
         this.var_filtre = this.var_filtre + " La catégorie : " + var6[0];
         this.var_requete = this.var_requete + " and salcon_grille ='" + var6[0] + "'";
      }

      if (this.centre != null && !this.centre.isEmpty() && this.centre.contains(":")) {
         var6 = this.centre.split(":");
         this.var_filtre = this.var_filtre + " Le centre d'impôt : " + var6[1];
         this.var_requete = this.var_requete + " and salcon_centres_impots ='" + var6[0] + "'";
      }

      if (this.classement != null && !this.classement.isEmpty() && this.classement.contains(":")) {
         var6 = this.classement.split(":");
         this.var_filtre = this.var_filtre + " Le classement : " + var6[1];
         this.var_requete = this.var_requete + " and salcon_classement ='" + var6[0] + "'";
      }

      if (this.niveauEmploi != null && !this.niveauEmploi.isEmpty() && this.niveauEmploi.contains(":")) {
         var6 = this.niveauEmploi.split(":");
         this.var_filtre = this.var_filtre + " Le niveau : " + var6[1];
         this.var_requete = this.var_requete + " salcon_niv_emploi ='" + var6[0] + "'";
      }

      String var7;
      if (var3 != null && !var3.isEmpty()) {
         if (var3.contains(":")) {
            var6 = var3.split(":");
            var7 = var6[0];
            this.var_filtre = this.var_filtre + " L`activité : " + var7;
            this.var_requete = this.var_requete + " AND salcon_acticvite='" + var7 + "'";
         } else if (var3.contains("(")) {
            this.var_filtre = this.var_filtre + " Le(s) actvité(s) : " + var3;
            this.var_requete = this.var_requete + " AND salcon_acticvite in" + var3;
         }
      }

      if (this.site != null && !this.site.isEmpty() && this.site.contains(":")) {
         var6 = this.site.split(":");
         this.var_filtre = this.var_filtre + " Le site : " + var6[1];
         this.var_requete = this.var_requete + " and salcon_site ='" + var6[0] + "'";
      }

      if (this.departement != null && !this.departement.isEmpty() && this.departement.contains(":")) {
         var6 = this.departement.split(":");
         this.var_filtre = this.var_filtre + " Le département : " + var6[1];
         this.var_requete = this.var_requete + " and salcon_departement ='" + var6[0] + "'";
      }

      if (this.service != null && !this.service.isEmpty() && this.service.contains(":")) {
         var6 = this.service.split(":");
         this.var_filtre = this.var_filtre + " Le service : " + var6[1];
         this.var_requete = this.var_requete + " and salcon_service ='" + var6[0] + "'";
      }

      if (this.budget != null && !this.budget.isEmpty() && this.budget.contains(":")) {
         var6 = this.budget.split(":");
         this.var_filtre = this.var_filtre + " Le budget : " + var6[1];
         this.var_requete = this.var_requete + " and salcon_budget ='" + var6[0] + "'";
      }

      String var14 = "" + (this.filtreDateFin.getYear() + 1900);
      var7 = "";
      if (this.filtreDateFin.getMonth() + 1 <= 9) {
         var7 = "0" + (this.filtreDateFin.getMonth() + 1);
      } else {
         var7 = "" + (this.filtreDateFin.getMonth() + 1);
      }

      var4 = var7 + ":" + var14;
      Session var8 = this.utilInitHibernate.getOpenSession(this.baseLog, "Salarie");
      SalariesContratsDao var9 = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
      new SalariesContrats();
      new BulletinSalaire();
      BulletinSalaireDao var12 = new BulletinSalaireDao(this.baseLog, this.utilInitHibernate);
      List var5 = var9.chargerlesContratsByRequete(this.var_requete, var8);
      if (var5.size() != 0) {
         for(int var13 = 0; var13 < var5.size(); ++var13) {
            this.salaries = ((SalariesContrats)var5.get(var13)).getSalaries();
            if (this.salaries.getSalDateEntree() != null) {
               SalariesContrats var10 = (SalariesContrats)var5.get(var13);
               this.objetCtrl = new ObjetCtrlAgent();
               this.objetCtrl.setMatricule(this.salaries.getSalMatricule());
               this.objetCtrl.setPatronyme(this.salaries.getPatronyme());
               this.objetCtrl.setActivite(var10.getSalconActivite());
               this.objetCtrl.setService(var10.getSalconService());
               this.objetCtrl.setLocalisation(var10.getSalconLocalisation());
               this.objetCtrl.setPeriode(var4);
               BulletinSalaire var11 = var12.rechercheBulletinSalariePeriode(this.salaries.getSalMatricule(), var4, var8);
               if (var11 != null) {
                  this.objetCtrl.setEtat(var11.getBulsalPeriode());
               } else {
                  this.objetCtrl.setEtat("");
               }

               this.lesCtrl.add(this.objetCtrl);
            }
         }
      }

   }

   public ObjetCp M000004(BulletinSalaireDao var1, SalariesContrats var2, List var3, BulletinLigneDao var4, List var5, ObjetCp var6, String var7, Session var8) throws HibernateException, NamingException, ParseException {
      double var9 = 0.0D;
      Date var11 = null;
      float var12 = 0.0F;
      float var13 = 0.0F;
      ArrayList var14 = new ArrayList();
      if (var14.size() == 0) {
         Date var15 = null;
         double var16 = 0.0D;
         double var18 = 0.0D;
         new ArrayList();
         List var20 = var4.chargerleslignesbyRubriquesSalaries("208000", this.salaries, var8);
         if (var20.size() != 0 && var15 == null) {
            for(int var21 = 0; var21 < var20.size(); ++var21) {
               if (((BulletinLigne)var20.get(var21)).getBulletinSalaire().getBulsalDateDebut().compareTo(this.filtreDateFin) <= 0) {
                  var15 = ((BulletinLigne)var20.get(var21)).getBulletinSalaire().getBulsalDateFin();
                  var15 = this.utilDate.dateJourSuivant(var15);
                  var11 = var15;
               }
            }
         }

         double var27 = 0.0D;
         int var23 = 0;
         new ArrayList();
         Date var25 = var15;
         if (var15 == null) {
            if (var2 != null) {
               var25 = var2.getSalconDateDebut();
            } else {
               var25 = this.filtreDateFin;
            }
         }

         List var24 = var4.chargerleslignesbyRubriquesSalaries("299999", var25, this.filtreDateFin, this.salaries, var8);
         if (var24.size() != 0) {
            for(int var26 = 0; var26 < var24.size(); ++var26) {
               var27 += ((BulletinLigne)var24.get(var26)).getBulligValColE();
               var13 += ((BulletinLigne)var24.get(var26)).getBulletinSalaire().getBulsalNbCpAcquis();
               var12 += ((BulletinLigne)var24.get(var26)).getBulletinSalaire().getBulsalNbCpPris();
               ++var23;
            }
         }

         if (var23 == 0) {
            boolean var28 = true;
         }

         var9 = var16 + var27 + var18;
      }

      var6.setBaseConges(var9);
      var6.setDateRetour(var11);
      var6.setNbJourPris((double)var12);
      var6.setNbJourAcquis((double)var13);
      return var6;
   }

   public void calculNbMali() throws HibernateException, NamingException {
      new ArrayList();
      BulletinLigneDao var2 = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
      List var1 = var2.chargerLigneBulletinsRequete(this.var_requete, (Session)null);
      this.nbSalEmbauche = 0;
      this.nbSaloccasionnel = 0;
      this.nbSalAdherent = 0;
      this.nbSalNonAdherent = 0;
      if (var1.size() != 0) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            if (!((BulletinLigne)var1.get(var3)).getBulletinSalaire().getSalaries().getSalNature().startsWith("01") && !((BulletinLigne)var1.get(var3)).getBulletinSalaire().getSalaries().getSalNature().startsWith("02") && !((BulletinLigne)var1.get(var3)).getBulletinSalaire().getSalaries().getSalNature().startsWith("03")) {
               if (((BulletinLigne)var1.get(var3)).getBulletinSalaire().getSalaries().getSalNature().equals("04") || ((BulletinLigne)var1.get(var3)).getBulletinSalaire().getSalaries().getSalNature().equals("05")) {
                  ++this.nbSaloccasionnel;
               }
            } else {
               ++this.nbSalEmbauche;
            }

            if (((BulletinLigne)var1.get(var3)).getBulletinSalaire().getBulsalSecu2() != null && !((BulletinLigne)var1.get(var3)).getBulletinSalaire().getBulsalSecu2().isEmpty()) {
               ++this.nbSalAdherent;
            } else {
               ++this.nbSalNonAdherent;
            }
         }
      }

   }

   public void calculITSMali() throws HibernateException, NamingException {
      new PlanPaye();
      PlanPayeDao var2 = new PlanPayeDao(this.baseLog, this.utilInitHibernate);
      PlanPaye var1 = var2.chercherCode("300220", this.exoSelectionne.getExepayId(), (Session)null);
      if (var1 != null) {
         this.rubITS = var1.getPlpCalculBase();
      } else {
         this.rubITS = null;
      }

   }

   public void calculNbGabon(String var1, String var2) throws HibernateException, NamingException {
      BulletinLigneDao var3 = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
      String var4 = "";
      if (this.tiers != 0L) {
         var4 = "BulletinSalaire.bulsalIdTiers=" + this.tiers + " and (BulletinSalaire.bulsalDateDebut>='" + var1 + "' AND BulletinSalaire.bulsalDateDebut<='" + var2 + "') and bulligRubrique = '299999' and bulligValColE<>0 and BulletinSalaire.bulsalPeriode <> 'SIMUL'";
      } else {
         var4 = "(BulletinSalaire.bulsalDateDebut>='" + var1 + "' AND BulletinSalaire.bulsalDateDebut<='" + var2 + "') and bulligRubrique = '299999' and bulligValColE<>0 and BulletinSalaire.bulsalPeriode <> 'SIMUL' and BulletinSalaire.bulsalNature in ('01D','01I')";
      }

      new ArrayList();
      List var5 = var3.chargerLigneBulletinsRequeteBySalarie(var4, (Session)null);
      new ArrayList();
      List var6 = var3.chargerLigneBulletinsRequeteDetail(var4, (Session)null);
      this.nbsalMoins1000000 = 0;
      this.nbSamPlus1000000 = 0;
      this.totSalMoins1000000 = 0.0D;
      this.totSalPlus1000000 = 0.0D;
      if (var5.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            this.salaries = (Salaries)var5.get(var7);
            int var8 = 0;
            int var9 = 0;
            double var10 = 0.0D;
            new BulletinLigne();

            for(int var13 = 0; var13 < var6.size(); ++var13) {
               BulletinLigne var12 = (BulletinLigne)var6.get(var13);
               if (this.salaries.getSalMatricule().equals(var12.getBulletinSalaire().getBulsalMatricule())) {
                  var10 += var12.getBulligValColE();
                  if (var12.getBulligValColE() >= 1000000.0D) {
                     ++var9;
                  } else {
                     ++var8;
                  }
               }
            }

            if (var9 >= var8) {
               ++this.nbSamPlus1000000;
               this.totSalPlus1000000 += var10;
            } else {
               ++this.nbsalMoins1000000;
               this.totSalMoins1000000 += var10;
            }
         }
      }

   }

   public void calculeColonnesSalaries() throws HibernateException, NamingException {
      this.lesColonnesChoisies.clear();
      this.chaineColonne = "";
      ObjetConvention var1 = new ObjetConvention();
      new ObjetTable();

      ObjetTable var2;
      for(int var3 = 0; var3 < this.lesColonnes.size(); ++var3) {
         var2 = (ObjetTable)this.lesColonnes.get(var3);
         if (var2.isColumn_select()) {
            this.chaineColonne = this.chaineColonne + var2.getColumn_name() + "|";
         }
      }

      var1.setLib_FR(this.chaineColonne);
      this.lesColonnesChoisies.add(var1);
      SalariesDao var7 = new SalariesDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var4 = var7.chargerlesSalariesByRequete(this.var_requete, (Session)null);
      if (var4.size() != 0) {
         this.salaries = new Salaries();

         for(int var5 = 0; var5 < var4.size(); ++var5) {
            this.salaries = (Salaries)var4.get(var5);
            this.chaineColonne = "";

            for(int var6 = 0; var6 < this.lesColonnes.size(); ++var6) {
               var2 = (ObjetTable)this.lesColonnes.get(var6);
               if (var2.isColumn_select() && var2.getColumn_name() != null & !var2.getColumn_name().isEmpty()) {
                  if (var2.getColumn_name().equals("sal_id")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalId() + "|";
                  } else if (var2.getColumn_name().equals("sal_date_creat")) {
                     if (this.salaries.getSalDateCreat() != null) {
                        this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(this.salaries.getSalDateCreat()) + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_date_modif")) {
                     if (this.salaries.getSalDateModif() != null) {
                        this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(this.salaries.getSalDateModif()) + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_user_creat")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalUserCreat() + "|";
                  } else if (var2.getColumn_name().equals("sal_user_modif")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalUserModif() + "|";
                  } else if (var2.getColumn_name().equals("sal_matricule")) {
                     this.chaineColonne = this.chaineColonne + "" + this.salaries.getSalMatricule() + "|";
                  } else if (var2.getColumn_name().equals("sal_photo")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalPhoto() + "|";
                  } else if (var2.getColumn_name().equals("sal_document")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalDocument() + "|";
                  } else if (var2.getColumn_name().equals("sal_nature")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalNature() + "|";
                  } else if (var2.getColumn_name().equals("sal_protege")) {
                     if (this.salaries.getSalProtege() == 0) {
                        this.chaineColonne = this.chaineColonne + "Non protégé" + "|";
                     } else if (this.salaries.getSalProtege() == 1) {
                        this.chaineColonne = this.chaineColonne + "Bulletin Invisible" + "|";
                     } else if (this.salaries.getSalProtege() == 2) {
                        this.chaineColonne = this.chaineColonne + "Salarié Invisible" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_etat")) {
                     if (this.salaries.getSalEtat() == 0) {
                        this.chaineColonne = this.chaineColonne + "Actif(ve)" + "|";
                     } else if (this.salaries.getSalEtat() == 1) {
                        this.chaineColonne = this.chaineColonne + "En Congés" + "|";
                     } else if (this.salaries.getSalEtat() == 2) {
                        this.chaineColonne = this.chaineColonne + "Licencié(e)" + "|";
                     } else if (this.salaries.getSalEtat() == 3) {
                        this.chaineColonne = this.chaineColonne + "Démissionné(e)" + "|";
                     } else if (this.salaries.getSalEtat() == 4) {
                        this.chaineColonne = this.chaineColonne + "Décédé(e)" + "|";
                     } else if (this.salaries.getSalEtat() == 5) {
                        this.chaineColonne = this.chaineColonne + "Retraité(e)" + "|";
                     } else if (this.salaries.getSalEtat() == 6) {
                        this.chaineColonne = this.chaineColonne + "Fin de contrat" + "|";
                     } else if (this.salaries.getSalEtat() == 7) {
                        this.chaineColonne = this.chaineColonne + "Arrêt ou suspension" + "|";
                     } else if (this.salaries.getSalEtat() == 8) {
                        this.chaineColonne = this.chaineColonne + "Mutation" + "|";
                     } else if (this.salaries.getSalEtat() == 9) {
                        this.chaineColonne = this.chaineColonne + "Gelé(e)" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_nom")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalNom() + "|";
                  } else if (var2.getColumn_name().equals("sal_nom_jf")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalNomJf() + "|";
                  } else if (var2.getColumn_name().equals("sal_prenom")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalPrenom() + "|";
                  } else if (var2.getColumn_name().equals("sal_nom_pays")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalNompays() + "|";
                  } else if (var2.getColumn_name().equals("sal_langue")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalLangue() + "|";
                  } else if (var2.getColumn_name().equals("sal_fonction")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalFonction() + "|";
                  } else if (var2.getColumn_name().equals("sal_profession")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalProfession() + "|";
                  } else if (var2.getColumn_name().equals("sal_site")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalSite() + "|";
                  } else if (var2.getColumn_name().equals("sal_departement")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalDepartement() + "|";
                  } else if (var2.getColumn_name().equals("sal_service")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalService() + "|";
                  } else if (var2.getColumn_name().equals("sal_lib_service")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalLibService() + "|";
                  } else if (var2.getColumn_name().equals("sal_activite")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalActivite() + "|";
                  } else if (var2.getColumn_name().equals("sal_localisation")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalLocalisation() + "|";
                  } else if (var2.getColumn_name().equals("sal_budget")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalBudget() + "|";
                  } else if (var2.getColumn_name().equals("sal_parc")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalParc() + "|";
                  } else if (var2.getColumn_name().equals("sal_date_naissance")) {
                     if (this.salaries.getSalDateNaissance() != null) {
                        this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(this.salaries.getSalDateNaissance()) + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_lieu_naissance")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalLieuNaissance() + "|";
                  } else if (var2.getColumn_name().equals("sal_pays_naissance")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalPaysNaissance() + "|";
                  } else if (var2.getColumn_name().equals("sal_code_naissance")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalCodeNaissance() + "|";
                  } else if (var2.getColumn_name().equals("sal_nationnalite")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalNationnalite() + "|";
                  } else if (var2.getColumn_name().equals("sal_ethnie")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalEthnie() + "|";
                  } else if (var2.getColumn_name().equals("sal_anniversaire")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalAnniversaire() + "|";
                  } else if (var2.getColumn_name().equals("sal_tel_bur")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalTelBur() + "|";
                  } else if (var2.getColumn_name().equals("sal_tel_dom")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalTelDom() + "|";
                  } else if (var2.getColumn_name().equals("sal_cel1")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalCel1() + "|";
                  } else if (var2.getColumn_name().equals("sal_cel2")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalCel2() + "|";
                  } else if (var2.getColumn_name().equals("sal_cel3")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalCel3() + "|";
                  } else if (var2.getColumn_name().equals("sal_adresse")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalAdresse() + "|";
                  } else if (var2.getColumn_name().equals("sal_rue")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalRue() + "|";
                  } else if (var2.getColumn_name().equals("sal_lot")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalLot() + "|";
                  } else if (var2.getColumn_name().equals("sal_ilot")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalIlot() + "|";
                  } else if (var2.getColumn_name().equals("sal_batiment")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalBatiment() + "|";
                  } else if (var2.getColumn_name().equals("sal_porte")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalPorte() + "|";
                  } else if (var2.getColumn_name().equals("sal_escalier")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalEscalier() + "|";
                  } else if (var2.getColumn_name().equals("sal_ascensseur")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalAscensseur() + "|";
                  } else if (var2.getColumn_name().equals("sal_etage")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalEtage() + "|";
                  } else if (var2.getColumn_name().equals("sal_quartier")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalQuartier() + "|";
                  } else if (var2.getColumn_name().equals("sal_commune")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalCommune() + "|";
                  } else if (var2.getColumn_name().equals("sal_departe")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalDeparte() + "|";
                  } else if (var2.getColumn_name().equals("sal_zone")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalZone() + "|";
                  } else if (var2.getColumn_name().equals("sal_bp")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalBp() + "|";
                  } else if (var2.getColumn_name().equals("sal_ville")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalVille() + "|";
                  } else if (var2.getColumn_name().equals("sal_yahoo")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalYahoo() + "|";
                  } else if (var2.getColumn_name().equals("sal_msn")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalMsn() + "|";
                  } else if (var2.getColumn_name().equals("sal_skype")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalSkype() + "|";
                  } else if (var2.getColumn_name().equals("sal_aol")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalAol() + "|";
                  } else if (var2.getColumn_name().equals("sal_mail1")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalMail1() + "|";
                  } else if (var2.getColumn_name().equals("sal_observation")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalObservation() + "|";
                  } else if (var2.getColumn_name().equals("sal_mode_reglement")) {
                     if (this.salaries.getSalModeReglement() == 0) {
                        this.chaineColonne = this.chaineColonne + "Espèce" + "|";
                     } else if (this.salaries.getSalModeReglement() == 1) {
                        this.chaineColonne = this.chaineColonne + "Chèque" + "|";
                     } else if (this.salaries.getSalModeReglement() == 2) {
                        this.chaineColonne = this.chaineColonne + "Virement" + "|";
                     } else if (this.salaries.getSalModeReglement() == 3) {
                        this.chaineColonne = this.chaineColonne + "Carte sans compte" + "|";
                     } else if (this.salaries.getSalModeReglement() == 4) {
                        this.chaineColonne = this.chaineColonne + "Microfinance" + "|";
                     } else if (this.salaries.getSalModeReglement() == 5) {
                        this.chaineColonne = this.chaineColonne + "Orange money" + "|";
                     } else if (this.salaries.getSalModeReglement() == 9) {
                        this.chaineColonne = this.chaineColonne + "Autre" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_num_banque")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalNumBanque() + "|";
                  } else if (var2.getColumn_name().equals("sal_guichet_banque")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalGuichetBanque() + "|";
                  } else if (var2.getColumn_name().equals("sal_compte_banque")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalCompteBanque() + "|";
                  } else if (var2.getColumn_name().equals("sal_cle_banque")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalCleBanque() + "|";
                  } else if (var2.getColumn_name().equals("sal_iban")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalIban() + "|";
                  } else if (var2.getColumn_name().equals("sal_swift")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalSwift() + "|";
                  } else if (var2.getColumn_name().equals("sal_compte_membre")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalCompteMembre() + "|";
                  } else if (var2.getColumn_name().equals("sal_mode_reglement_15")) {
                     if (this.salaries.getSalModeReglement15() == 0) {
                        this.chaineColonne = this.chaineColonne + "Espèce" + "|";
                     } else if (this.salaries.getSalModeReglement15() == 1) {
                        this.chaineColonne = this.chaineColonne + "Chèque" + "|";
                     } else if (this.salaries.getSalModeReglement15() == 2) {
                        this.chaineColonne = this.chaineColonne + "Virement" + "|";
                     } else if (this.salaries.getSalModeReglement15() == 3) {
                        this.chaineColonne = this.chaineColonne + "Carte sans compte" + "|";
                     } else if (this.salaries.getSalModeReglement15() == 4) {
                        this.chaineColonne = this.chaineColonne + "Microfinance" + "|";
                     } else if (this.salaries.getSalModeReglement15() == 5) {
                        this.chaineColonne = this.chaineColonne + "Orange money" + "|";
                     } else if (this.salaries.getSalModeReglement15() == 9) {
                        this.chaineColonne = this.chaineColonne + "Autre" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_num_banque_15")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalNumBanque15() + "|";
                  } else if (var2.getColumn_name().equals("sal_guichet_banque_15")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalGuichetBanque15() + "|";
                  } else if (var2.getColumn_name().equals("sal_compte_banque_15")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalCompteBanque15() + "|";
                  } else if (var2.getColumn_name().equals("sal_cle_banque_15")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalCleBanque15() + "|";
                  } else if (var2.getColumn_name().equals("sal_iban_15")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalIban15() + "|";
                  } else if (var2.getColumn_name().equals("sal_swift_15")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalSwift15() + "|";
                  } else if (var2.getColumn_name().equals("sal_compte_membre_15")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalCompteMembre15() + "|";
                  } else if (var2.getColumn_name().equals("sal_genre")) {
                     if (this.salaries.getSalGenre() == 0) {
                        this.chaineColonne = this.chaineColonne + "Femme" + "|";
                     } else if (this.salaries.getSalGenre() == 1) {
                        this.chaineColonne = this.chaineColonne + "Homme" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_sit_famille")) {
                     if (this.salaries.getSalSitFamille() == 0) {
                        this.chaineColonne = this.chaineColonne + "Célibataire" + "|";
                     } else if (this.salaries.getSalSitFamille() == 1) {
                        this.chaineColonne = this.chaineColonne + "Marié(e)" + "|";
                     } else if (this.salaries.getSalSitFamille() == 2) {
                        this.chaineColonne = this.chaineColonne + "Concubin(e)" + "|";
                     } else if (this.salaries.getSalSitFamille() == 3) {
                        this.chaineColonne = this.chaineColonne + "Pacsé(e)" + "|";
                     } else if (this.salaries.getSalSitFamille() == 4) {
                        this.chaineColonne = this.chaineColonne + "Divorcé(e)" + "|";
                     } else if (this.salaries.getSalSitFamille() == 5) {
                        this.chaineColonne = this.chaineColonne + "Veuf(ve)" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_nb_enfant")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalNbEnfant() + "|";
                  } else if (var2.getColumn_name().equals("sal_nb_part_fiscal")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalNbPartFiscal() + "|";
                  } else if (var2.getColumn_name().equals("sal_nb_femme")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalNbFemme() + "|";
                  } else if (var2.getColumn_name().equals("sal_nb_part_trimf")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalNbPartTrimf() + "|";
                  } else if (var2.getColumn_name().equals("sal_nb_jour_cp")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalNbJourCp() + "|";
                  } else if (var2.getColumn_name().equals("sal_nb_jour_tr")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalNbJourTr() + "|";
                  } else if (var2.getColumn_name().equals("sal_date_marie")) {
                     if (this.salaries.getSalDateModif() != null) {
                        this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(this.salaries.getSalDateMarie()) + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_date_divorce")) {
                     if (this.salaries.getSalDateModif() != null) {
                        this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(this.salaries.getSalDateDivorce()) + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_date_veuf")) {
                     if (this.salaries.getSalDateModif() != null) {
                        this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(this.salaries.getSalDateVeuf()) + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_date_concubinage")) {
                     if (this.salaries.getSalDateConcubinage() != null) {
                        this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(this.salaries.getSalDateConcubinage()) + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_date_pacs")) {
                     if (this.salaries.getSalDatePacs() != null) {
                        this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(this.salaries.getSalDatePacs()) + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_convention")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalConvention() + "|";
                  } else if (var2.getColumn_name().equals("sal_lib_convention")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalLibConvention() + "|";
                  } else if (var2.getColumn_name().equals("sal_Cod_Centres_Impots")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalCentresImpots() + "|";
                  } else if (var2.getColumn_name().equals("sal_Lib_Centres_Impots")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalLibCentresImpots() + "|";
                  } else if (var2.getColumn_name().equals("sal_classement")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalClassement() + "|";
                  } else if (var2.getColumn_name().equals("sal_lib_classement")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalLibClassement() + "|";
                  } else if (var2.getColumn_name().equals("sal_code_emploi")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalCodeEmploi() + "|";
                  } else if (var2.getColumn_name().equals("sal_niv_emploi")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalNivEmploi() + "|";
                  } else if (var2.getColumn_name().equals("sal_lib_niv_emploi")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalLibNivEmploi() + "|";
                  } else if (var2.getColumn_name().equals("sal_grille")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalGrille() + "|";
                  } else if (var2.getColumn_name().equals("sal_lib_grille")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalLibGrille() + "|";
                  } else if (var2.getColumn_name().equals("sal_date_entree")) {
                     if (this.salaries.getSalDateEntree() != null) {
                        this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(this.salaries.getSalDateEntree()) + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_date_sortie")) {
                     if (this.salaries.getSalDateSortie() != null) {
                        this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(this.salaries.getSalDateSortie()) + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_motif_sortie")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalMotifSortie() + "|";
                  } else if (var2.getColumn_name().equals("sal_date_impot")) {
                     if (this.salaries.getSalDateImpot() != null) {
                        this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(this.salaries.getSalDateImpot()) + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_feuille")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalFeuille() + "|";
                  } else if (var2.getColumn_name().equals("sal_num_ci")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalNumCi() + "|";
                  } else if (var2.getColumn_name().equals("sal_date_ci")) {
                     if (this.salaries.getSalDateCi() != null) {
                        this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(this.salaries.getSalDateCi()) + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_delivre_ci")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalDelivreCi() + "|";
                  } else if (var2.getColumn_name().equals("sal_lieu_ci")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalLieuCi() + "|";
                  } else if (var2.getColumn_name().equals("sal_num_secu")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalNumSecu() + "|";
                  } else if (var2.getColumn_name().equals("sal_date_secu")) {
                     if (this.salaries.getSalDateSecu() != null) {
                        this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(this.salaries.getSalDateSecu()) + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_num_retraite")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalNumRetraite() + "|";
                  } else if (var2.getColumn_name().equals("sal_date_retraite")) {
                     if (this.salaries.getSalDateRetraite() != null) {
                        this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(this.salaries.getSalDateRetraite()) + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_num_cnamgs")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalNumCnamgs() + "|";
                  } else if (var2.getColumn_name().equals("sal_date_cnamgs")) {
                     if (this.salaries.getSalDateCnamgs() != null) {
                        this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(this.salaries.getSalDateCnamgs()) + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_num_amo")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalNumAmo() + "|";
                  } else if (var2.getColumn_name().equals("sal_date_amo")) {
                     if (this.salaries.getSalDateAmo() != null) {
                        this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(this.salaries.getSalDateAmo()) + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_num_allocataire")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalNumAllocataire() + "|";
                  } else if (var2.getColumn_name().equals("sal_date_allocataire")) {
                     if (this.salaries.getSalDateAllocataire() != null) {
                        this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(this.salaries.getSalDateAllocataire()) + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_num_fiscal")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalNumFiscal() + "|";
                  } else if (var2.getColumn_name().equals("sal_approb_insp")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalApprobInsp() + "|";
                  } else if (var2.getColumn_name().equals("sal_visa_enreg")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalVisaEnreg() + "|";
                  } else if (var2.getColumn_name().equals("sal_classe_recrut")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalClasseRecrut() + "|";
                  } else if (var2.getColumn_name().equals("sal_service_mil")) {
                     if (this.salaries.isSalServiceMil()) {
                        this.chaineColonne = this.chaineColonne + "Service militaire non fait" + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "Service militaie effectué" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_corps_app")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalCoprsApp() + "|";
                  } else if (var2.getColumn_name().equals("sal_grade")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalGrade() + "|";
                  } else if (var2.getColumn_name().equals("sal_date_entree_pays")) {
                     if (this.salaries.getSalDateEntreePays() != null) {
                        this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(this.salaries.getSalDateEntreePays()) + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_pere")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalPere() + "|";
                  } else if (var2.getColumn_name().equals("sal_mere")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalMere() + "|";
                  } else if (var2.getColumn_name().equals("sal_compte_net")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalCompteNet() + "|";
                  } else if (var2.getColumn_name().equals("sal_compte_acompte")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalCompteAcompte() + "|";
                  } else if (var2.getColumn_name().equals("sal_compte_avance")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalCompteAvance() + "|";
                  } else if (var2.getColumn_name().equals("sal_cle_anal1")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalCleAnal1() + "|";
                  } else if (var2.getColumn_name().equals("sal_lib_cle_anal1")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalLibCleAnal1() + "|";
                  } else if (var2.getColumn_name().equals("sal_cle_anal2")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalLibCleAnal2() + "|";
                  } else if (var2.getColumn_name().equals("sal_lib_cle_anal2")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalLibCleAnal2() + "|";
                  } else if (var2.getColumn_name().equals("sal_mise_relation")) {
                     if (this.salaries.isSalMiseRelation()) {
                        this.chaineColonne = this.chaineColonne + "Sans mise en relation" + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "Avec mise en relation" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_disponible")) {
                     if (this.salaries.getSalDisponible() == 0) {
                        this.chaineColonne = this.chaineColonne + "Disponible" + "|";
                     } else if (this.salaries.getSalDisponible() == 1) {
                        this.chaineColonne = this.chaineColonne + "Non disponible" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_dispo_du")) {
                     if (this.salaries.getSalDateEntreePays() != null) {
                        this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(this.salaries.getSalDispoDu()) + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_dispo_Au")) {
                     if (this.salaries.getSalDispoAu() != null) {
                        this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(this.salaries.getSalDispoAu()) + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_mobile")) {
                     if (this.salaries.getSalMobile() == 0) {
                        this.chaineColonne = this.chaineColonne + "Mobile" + "|";
                     } else if (this.salaries.getSalMobile() == 1) {
                        this.chaineColonne = this.chaineColonne + "Mobile sauf" + "|";
                     } else if (this.salaries.getSalMobile() == 2) {
                        this.chaineColonne = this.chaineColonne + "Non mobile" + "|";
                     }
                  } else if (var2.getColumn_name().equals("sal_mobile_sauf")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalMobileSauf() + "|";
                  } else if (var2.getColumn_name().equals("sal_id_tiers")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalIdTiers() + "|";
                  } else if (var2.getColumn_name().equals("sal_nom_tiers")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalNomTiers() + "|";
                  } else if (var2.getColumn_name().equals("sal_conjoint_nom_prenom")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalConjointNomPrenom() + "|";
                  } else if (var2.getColumn_name().equals("sal_conjoint_num_fiscal")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalConjointNumFiscal() + "|";
                  } else if (var2.getColumn_name().equals("sal_conjoint_nom_jf")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalConjointNomJf() + "|";
                  } else if (var2.getColumn_name().equals("sal_conjoint_employeur_nom")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalConjointEmployeurNom() + "|";
                  } else if (var2.getColumn_name().equals("sal_conjoint_employeur_adresse")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalConjointEmployeurAdresse() + "|";
                  } else if (var2.getColumn_name().equals("sal_conjoint_employeur_bp")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalConjointEmployeurBp() + "|";
                  } else if (var2.getColumn_name().equals("sal_conjoint_employeur_ville")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalConjointEmployeurVille() + "|";
                  } else if (var2.getColumn_name().equals("sal_conjoint_employeur_tel")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalConjointEmployeurTel() + "|";
                  } else if (var2.getColumn_name().equals("sal_conjoint_employeur_fonction")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalConjointEmployeurFonction() + "|";
                  } else if (var2.getColumn_name().equals("sal_id_groupe")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalIdGroupe() + "|";
                  } else if (var2.getColumn_name().equals("sal_id_old")) {
                     this.chaineColonne = this.chaineColonne + this.salaries.getSalIdTiers() + "|";
                  }
               }
            }

            var1 = new ObjetConvention();
            var1.setLib_FR(this.chaineColonne);
            this.lesColonnesChoisies.add(var1);
         }
      }

   }

   public void calculeColonnesContrats() throws HibernateException, NamingException {
      this.lesColonnesChoisies.clear();
      this.chaineColonne = "";
      new ObjetConvention();
      new ObjetTable();

      ObjetTable var2;
      for(int var3 = 0; var3 < this.lesColonnes.size(); ++var3) {
         var2 = (ObjetTable)this.lesColonnes.get(var3);
         if (var2.isColumn_select()) {
            this.chaineColonne = this.chaineColonne + var2.getColumn_name() + "|";
         }
      }

      ObjetConvention var1 = new ObjetConvention();
      var1.setLib_FR(this.chaineColonne);
      this.lesColonnesChoisies.add(var1);
      SalariesContratsDao var8 = new SalariesContratsDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var4 = var8.chargerlesContratsByRequete(this.var_requete, (Session)null);
      if (var4.size() != 0) {
         new SalariesContrats();

         for(int var6 = 0; var6 < var4.size(); ++var6) {
            SalariesContrats var5 = (SalariesContrats)var4.get(var6);
            this.chaineColonne = "";

            for(int var7 = 0; var7 < this.lesColonnes.size(); ++var7) {
               var2 = (ObjetTable)this.lesColonnes.get(var7);
               if (var2.isColumn_select() && var2.getColumn_name() != null & !var2.getColumn_name().isEmpty()) {
                  if (var2.getColumn_name().equals("salcon_id")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconId() + "|";
                  } else if (var2.getColumn_name().equals("salcon_date_creat")) {
                     this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(var5.getSalconDateCreat()) + "|";
                  } else if (var2.getColumn_name().equals("salcon_date_modif")) {
                     this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(var5.getSalconDateModif()) + "|";
                  } else if (var2.getColumn_name().equals("salcon_user_creat")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconUserCreat() + "|";
                  } else if (var2.getColumn_name().equals("salcon_user_modif")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconUserModif() + "|";
                  } else if (var2.getColumn_name().equals("salcon_num")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconNum() + "|";
                  } else if (var2.getColumn_name().equals("salcon_type")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconType() + "|";
                  } else if (var2.getColumn_name().equals("salcon_feuille")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconFeuille() + "|";
                  } else if (var2.getColumn_name().equals("salcon_etat")) {
                     if (var5.getSalconEtat() == 0) {
                        this.chaineColonne = this.chaineColonne + "Actif(ve)" + "|";
                     } else if (var5.getSalconEtat() == 1) {
                        this.chaineColonne = this.chaineColonne + "En Congés" + "|";
                     } else if (var5.getSalconEtat() == 2) {
                        this.chaineColonne = this.chaineColonne + "Licencié(e)" + "|";
                     } else if (var5.getSalconEtat() == 3) {
                        this.chaineColonne = this.chaineColonne + "Démissionné(e)" + "|";
                     } else if (var5.getSalconEtat() == 4) {
                        this.chaineColonne = this.chaineColonne + "Décédé(e)" + "|";
                     } else if (var5.getSalconEtat() == 5) {
                        this.chaineColonne = this.chaineColonne + "Retraité(e)" + "|";
                     } else if (var5.getSalconEtat() == 6) {
                        this.chaineColonne = this.chaineColonne + "Fin de contrat" + "|";
                     } else if (var5.getSalconEtat() == 7) {
                        this.chaineColonne = this.chaineColonne + "Arrêt ou suspension" + "|";
                     } else if (var5.getSalconEtat() == 8) {
                        this.chaineColonne = this.chaineColonne + "Mutation" + "|";
                     } else if (var5.getSalconEtat() == 9) {
                        this.chaineColonne = this.chaineColonne + "Gelé(e)" + "|";
                     }
                  } else if (var2.getColumn_name().equals("salcon_essai")) {
                     if (var5.getSalconEssai() == 0) {
                        this.chaineColonne = this.chaineColonne + "Sans période essai" + "|";
                     } else if (var5.getSalconEssai() == 1) {
                        this.chaineColonne = this.chaineColonne + "Avec périoe essai" + "|";
                     }
                  } else if (var2.getColumn_name().equals("salcon_nb_mois_essai")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconNbMoisEssai() + "|";
                  } else if (var2.getColumn_name().equals("salcon_fonction")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconFonction() + "|";
                  } else if (var2.getColumn_name().equals("salcon_site")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconSite() + "|";
                  } else if (var2.getColumn_name().equals("salcon_departement")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconDepartement() + "|";
                  } else if (var2.getColumn_name().equals("salcon_localisation")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconLocalisation() + "|";
                  } else if (var2.getColumn_name().equals("salcon_service")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconService() + "|";
                  } else if (var2.getColumn_name().equals("salcon_lib_service")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconLibService() + "|";
                  } else if (var2.getColumn_name().equals("salcon_date_debut")) {
                     this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(var5.getSalconDateDebut()) + "|";
                  } else if (var2.getColumn_name().equals("salcon_lieu_travail")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconLieuTravail() + "|";
                  } else if (var2.getColumn_name().equals("salcon_convention")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconConvention() + "|";
                  } else if (var2.getColumn_name().equals("salcon_lib_convention")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconLibConvention() + "|";
                  } else if (var2.getColumn_name().equals("salcon_centres_impots")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconCentresImpots() + "|";
                  } else if (var2.getColumn_name().equals("salcon_lib_centres_impots")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconLibCentresImpots() + "|";
                  } else if (var2.getColumn_name().equals("salcon_classement")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconClassement() + "|";
                  } else if (var2.getColumn_name().equals("salcon_lib_classement")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconLibClassement() + "|";
                  } else if (var2.getColumn_name().equals("salcon_code_emploi")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconCodeEmploi() + "|";
                  } else if (var2.getColumn_name().equals("salcon_niv_emploi")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconNivEmploi() + "|";
                  } else if (var2.getColumn_name().equals("salcon_lib_niv_emploi")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconLibNivEmploi() + "|";
                  } else if (var2.getColumn_name().equals("salcon_grille")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconGrille() + "|";
                  } else if (var2.getColumn_name().equals("salcon_lib_grille")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconLibGrille() + "|";
                  } else if (var2.getColumn_name().equals("salcon_activite")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconActivite() + "|";
                  } else if (var2.getColumn_name().equals("salcon_lib_activite")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconLibActivite() + "|";
                  } else if (var2.getColumn_name().equals("salcon_budget")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconBudget() + "|";
                  } else if (var2.getColumn_name().equals("salcon_lib_budget")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconLibBudget() + "|";
                  } else if (var2.getColumn_name().equals("salcon_projet")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconProjet() + "|";
                  } else if (var2.getColumn_name().equals("salcon_lib_projet")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconLibProjet() + "|";
                  } else if (var2.getColumn_name().equals("salcon_vehicule")) {
                     if (var5.getSalconVehicule() == 0) {
                        this.chaineColonne = this.chaineColonne + "Sans véhicule" + "|";
                     } else if (var5.getSalconVehicule() == 1) {
                        this.chaineColonne = this.chaineColonne + "Avec véhicule personnel" + "|";
                     } else if (var5.getSalconVehicule() == 2) {
                        this.chaineColonne = this.chaineColonne + "Avec véhicule société" + "|";
                     }
                  } else if (var2.getColumn_name().equals("salcon_rmb_kms")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconRbmKms() + "|";
                  } else if (var2.getColumn_name().equals("salcon_parc")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconParc() + "|";
                  } else if (var2.getColumn_name().equals("salcon_text")) {
                     this.chaineColonne = this.chaineColonne + "texte du contrat" + "|";
                  } else if (var2.getColumn_name().equals("salcon_date_fin")) {
                     this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(var5.getSalconDateFin()) + "|";
                  } else if (var2.getColumn_name().equals("salcon_motif_sortie")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconMotifSortie() + "|";
                  } else if (var2.getColumn_name().equals("salcon_date_remise")) {
                     this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(var5.getSalconDateRemise()) + "|";
                  } else if (var2.getColumn_name().equals("salcon_date_retour")) {
                     this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(var5.getSalconDateRetour()) + "|";
                  } else if (var2.getColumn_name().equals("salcon_date_confirmation")) {
                     this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(var5.getSalconDateConfirmation()) + "|";
                  } else if (var2.getColumn_name().equals("salcon_id_representant")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconIdRepresetant() + "|";
                  } else if (var2.getColumn_name().equals("salcon_nom_representant")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconNomRepresentant() + "|";
                  } else if (var2.getColumn_name().equals("salcon_qualite")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconQualite() + "|";
                  } else if (var2.getColumn_name().equals("salcon_etat_val")) {
                     if (var5.getSalconEtatVal() == 0) {
                        this.chaineColonne = this.chaineColonne + "Sans habilitation" + "|";
                     } else if (var5.getSalconEtatVal() == 1) {
                        this.chaineColonne = this.chaineColonne + "Avec habilitation" + "|";
                     }
                  } else if (var2.getColumn_name().equals("salcon_etat_h")) {
                     if (var5.getSalconEtatH() == 0) {
                        this.chaineColonne = this.chaineColonne + "En cours" + "|";
                     } else if (var5.getSalconEtatH() == 1) {
                        this.chaineColonne = this.chaineColonne + "Validé" + "|";
                     }
                  } else if (var2.getColumn_name().equals("salcon_date_valide")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconDateValide() + "|";
                  } else if (var2.getColumn_name().equals("salcon_pos_signature")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconPosSignature() + "|";
                  } else if (var2.getColumn_name().equals("salcon_date_imp")) {
                     this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(var5.getSalconDateImp()) + "|";
                  } else if (var2.getColumn_name().equals("salcon_base")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconBase() + "|";
                  } else if (var2.getColumn_name().equals("salcon_sursalaire")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconSursalaire() + "|";
                  } else if (var2.getColumn_name().equals("salcon_forfait_sup")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconForfaitSup() + "|";
                  } else if (var2.getColumn_name().equals("salcon_prime_rendement")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconPrimeRendement() + "|";
                  } else if (var2.getColumn_name().equals("salcon_prime_responsabilite")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconPrimeResponsabilite() + "|";
                  } else if (var2.getColumn_name().equals("salcon_prime_exceptionelle")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconPrimeExceptionnelle() + "|";
                  } else if (var2.getColumn_name().equals("salcon_prime_sujetion")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconPrimeSujetion() + "|";
                  } else if (var2.getColumn_name().equals("salcon_prime_fonction")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconPrimeFonction() + "|";
                  } else if (var2.getColumn_name().equals("salcon_prime_outillage")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconPrimeOutillage() + "|";
                  } else if (var2.getColumn_name().equals("salcon_prime_astreinte")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconPrimeAstreinte() + "|";
                  } else if (var2.getColumn_name().equals("salcon_indemnite_caisse")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconIndemniteCaisse() + "|";
                  } else if (var2.getColumn_name().equals("salcon_indemnite_transport")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconIndemniteTransport() + "|";
                  } else if (var2.getColumn_name().equals("salcon_indemnite_logement")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconIndemniteLogement() + "|";
                  } else if (var2.getColumn_name().equals("salcon_indemnite_deplacement")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconIndemniteDeplacement() + "|";
                  } else if (var2.getColumn_name().equals("salcon_indemnite_kilometrique")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconIndemniteKilometrique() + "|";
                  } else if (var2.getColumn_name().equals("salcon_indemnite_salissure")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconIndemniteSalissure() + "|";
                  } else if (var2.getColumn_name().equals("salcon_indemnite_representation")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconIndemniteRepresentation() + "|";
                  } else if (var2.getColumn_name().equals("salcon_indemnite_diverse")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconIndemniteDiverse() + "|";
                  } else if (var2.getColumn_name().equals("salcon_indemnite_responsabilite")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconIndemniteResponsabilite() + "|";
                  } else if (var2.getColumn_name().equals("salcon_indemnite_nourriture")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconIndemniteNourriture() + "|";
                  } else if (var2.getColumn_name().equals("salcon_avn_logement")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconAvnLogement() + "|";
                  } else if (var2.getColumn_name().equals("salcon_avn_domesticite")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconAvnDomesticite() + "|";
                  } else if (var2.getColumn_name().equals("salcon_avn_telephone")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconAvnTelephone() + "|";
                  } else if (var2.getColumn_name().equals("salcon_avn_eau")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconAvnEau() + "|";
                  } else if (var2.getColumn_name().equals("salcon_avn_electricite")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconAvnElectricite() + "|";
                  } else if (var2.getColumn_name().equals("salcon_avn_nourriture")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconAvnNourriture() + "|";
                  } else if (var2.getColumn_name().equals("salcon_avn_vehicule")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconAvnVehicule() + "|";
                  } else if (var2.getColumn_name().equals("salcon_nb_jour_cp")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconNbJourCp() + "|";
                  } else if (var2.getColumn_name().equals("salcon_nb_jour_tr")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconNbJourTr() + "|";
                  } else if (var2.getColumn_name().equals("salcon_cle1_anal")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconCle1Anal() + "|";
                  } else if (var2.getColumn_name().equals("salcon_lib_cle1_anal")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconLibCle1Anal() + "|";
                  } else if (var2.getColumn_name().equals("salcon_cle2_anal")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconCle2Anal() + "|";
                  } else if (var2.getColumn_name().equals("salcon_lib_cle2_anal")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconLibCle2Anal() + "|";
                  } else if (var2.getColumn_name().equals("salcon_id_tiers")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconIdTiers() + "|";
                  } else if (var2.getColumn_name().equals("salcon_nom_tiers")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconNomTiers() + "|";
                  } else if (var2.getColumn_name().equals("salcon_date_avenant_deb1")) {
                     this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(var5.getSalconDateAvenantDeb1()) + "|";
                  } else if (var2.getColumn_name().equals("salcon_date_avenant_fin1")) {
                     this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(var5.getSalconDateAvenantFin1()) + "|";
                  } else if (var2.getColumn_name().equals("salcon_date_avenant_fin2")) {
                     this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(var5.getSalconDateAvenantFin2()) + "|";
                  } else if (var2.getColumn_name().equals("salcon_date_avenant_fin3")) {
                     this.chaineColonne = this.chaineColonne + this.utilDate.dateToStringFr(var5.getSalconDateAvenantFin3()) + "|";
                  } else if (var2.getColumn_name().equals("salcon_document")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconDocument() + "|";
                  } else if (var2.getColumn_name().equals("salcon_taux")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalconTaux() + "|";
                  } else if (var2.getColumn_name().equals("pay_salaries.sal_matricule")) {
                     this.chaineColonne = this.chaineColonne + "" + var5.getSalaries().getSalMatricule() + "|";
                  } else if (var2.getColumn_name().equals("pay_salaries.sal_nom")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalaries().getSalNom() + "|";
                  } else if (var2.getColumn_name().equals("pay_salaries.sal_prenom")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalaries().getSalPrenom() + "|";
                  }
               }
            }

            var1 = new ObjetConvention();
            var1.setLib_FR(this.chaineColonne);
            this.lesColonnesChoisies.add(var1);
         }
      }

   }

   public void calculeColonnesBulletins() throws HibernateException, NamingException {
      this.lesColonnesChoisies.clear();
      this.chaineColonne = "";
      new ObjetConvention();
      new ObjetTable();

      ObjetTable var2;
      for(int var3 = 0; var3 < this.lesColonnes.size(); ++var3) {
         var2 = (ObjetTable)this.lesColonnes.get(var3);
         if (var2.isColumn_select()) {
            this.chaineColonne = this.chaineColonne + var2.getColumn_name() + "|";
         }
      }

      ObjetConvention var1 = new ObjetConvention();
      var1.setLib_FR(this.chaineColonne);
      this.lesColonnesChoisies.add(var1);
      BulletinLigneDao var8 = new BulletinLigneDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var4 = var8.chargerLigneBulletinsRequete(this.var_requete, (Session)null);
      if (var4.size() != 0) {
         new BulletinLigne();

         for(int var6 = 0; var6 < var4.size(); ++var6) {
            BulletinLigne var5 = (BulletinLigne)var4.get(var6);
            this.chaineColonne = "";

            for(int var7 = 0; var7 < this.lesColonnes.size(); ++var7) {
               var2 = (ObjetTable)this.lesColonnes.get(var7);
               if (var2.isColumn_select() && var2.getColumn_name() != null & !var2.getColumn_name().isEmpty()) {
                  if (var2.getColumn_name().equals("bullig_id")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulligId() + "|";
                  } else if (var2.getColumn_name().equals("bullig_rubrique")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulligRubrique() + "|";
                  } else if (var2.getColumn_name().equals("bullig_libelle")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulligLibelle() + "|";
                  } else if (var2.getColumn_name().equals("bullig_aff_colA")) {
                     this.chaineColonne = this.chaineColonne + var5.isBulligAffColA() + "|";
                  } else if (var2.getColumn_name().equals("bullig_aff_colB")) {
                     this.chaineColonne = this.chaineColonne + var5.isBulligAffColB() + "|";
                  } else if (var2.getColumn_name().equals("bullig_aff_colC")) {
                     this.chaineColonne = this.chaineColonne + var5.isBulligAffColC() + "|";
                  } else if (var2.getColumn_name().equals("bullig_aff_colD")) {
                     this.chaineColonne = this.chaineColonne + var5.isBulligAffColD() + "|";
                  } else if (var2.getColumn_name().equals("bullig_aff_colE")) {
                     this.chaineColonne = this.chaineColonne + var5.isBulligAffColE() + "|";
                  } else if (var2.getColumn_name().equals("bullig_val_colA")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulligValColA() + "|";
                  } else if (var2.getColumn_name().equals("bullig_val_colB")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulligValColB() + "|";
                  } else if (var2.getColumn_name().equals("bullig_val_colC")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulligValColC() + "|";
                  } else if (var2.getColumn_name().equals("bullig_val_colD")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulligValColD() + "|";
                  } else if (var2.getColumn_name().equals("bullig_val_colE")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulligValColE() + "|";
                  } else if (var2.getColumn_name().equals("bullig_nature")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulligNature() + "|";
                  } else if (var2.getColumn_name().equals("bullig_base_fiscale")) {
                     this.chaineColonne = this.chaineColonne + var5.isBulligBaseFiscale() + "|";
                  } else if (var2.getColumn_name().equals("bullig_base_sociale")) {
                     this.chaineColonne = this.chaineColonne + var5.isBulligBaseSociale() + "|";
                  } else if (var2.getColumn_name().equals("bullig_base_autre")) {
                     this.chaineColonne = this.chaineColonne + var5.isBulligBaseAutre() + "|";
                  } else if (var2.getColumn_name().equals("bullig_base_patronale")) {
                     this.chaineColonne = this.chaineColonne + var5.isBulligBasePatronale() + "|";
                  } else if (var2.getColumn_name().equals("bullig_base_conges")) {
                     this.chaineColonne = this.chaineColonne + var5.isBulligBaseConges() + "|";
                  } else if (var2.getColumn_name().equals("bullig_sens")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulligSens() + "|";
                  } else if (var2.getColumn_name().equals("bullig_prorata_temporis")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulligProrataTemporis() + "|";
                  } else if (var2.getColumn_name().equals("bullig_id_pret_ligne")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulligIdPretligne() + "|";
                  } else if (var2.getColumn_name().equals("bullig_num_pret")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulligNumPret() + "|";
                  } else if (var2.getColumn_name().equals("bullig_nature_pret")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulligNaturePret() + "|";
                  } else if (var2.getColumn_name().equals("bullig_observation")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulligObservation() + "|";
                  } else if (var2.getColumn_name().equals("bullig_non_print")) {
                     this.chaineColonne = this.chaineColonne + var5.isBulligNonPrint() + "|";
                  } else if (var2.getColumn_name().equals("pay_salaries.sal_matricule")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalaries().getSalMatricule() + "|";
                  } else if (var2.getColumn_name().equals("pay_salaries.sal_nom")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalaries().getSalNom() + "|";
                  } else if (var2.getColumn_name().equals("pay_salaries.sal_prenom")) {
                     this.chaineColonne = this.chaineColonne + var5.getSalaries().getSalPrenom() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_feuille")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalFeuille() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_contrat")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalContrat() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_periode")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalPeriode() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_date_debut")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalDateDebut() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_date_fin")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalDateFin() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_etat_bulletin")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalEtat() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_nature")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalNature() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_etat")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalEtat() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_fonction")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalFonction() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_id_tiers")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalIdTiers() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_projet")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalProjet() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_site")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalSite() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_departement")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalDepartement() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_service")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalService() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_lib_service")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalLibService() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_acticvite")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalActivite() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_localisation")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalLocalisation() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_budget")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalBudget() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_parc")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalParc() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_genre")) {
                     if (var5.getBulletinSalaire().getBulsalGenre() == 0) {
                        this.chaineColonne = this.chaineColonne + "Femme" + "|";
                     } else if (var5.getBulletinSalaire().getBulsalGenre() == 1) {
                        this.chaineColonne = this.chaineColonne + "Homme" + "|";
                     }
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_sit_famille")) {
                     if (var5.getBulletinSalaire().getBulsalSitFamille() == 0) {
                        this.chaineColonne = this.chaineColonne + "Célibataire" + "|";
                     } else if (var5.getBulletinSalaire().getBulsalSitFamille() == 1) {
                        this.chaineColonne = this.chaineColonne + "Marié(e)" + "|";
                     } else if (var5.getBulletinSalaire().getBulsalSitFamille() == 2) {
                        this.chaineColonne = this.chaineColonne + "Concubin(e)" + "|";
                     } else if (var5.getBulletinSalaire().getBulsalSitFamille() == 3) {
                        this.chaineColonne = this.chaineColonne + "Pacsé(e)" + "|";
                     } else if (var5.getBulletinSalaire().getBulsalSitFamille() == 4) {
                        this.chaineColonne = this.chaineColonne + "Divorcé(e)" + "|";
                     } else if (var5.getBulletinSalaire().getBulsalSitFamille() == 5) {
                        this.chaineColonne = this.chaineColonne + "Veuf(ve)" + "|";
                     }
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_nb_enfant")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalNbEnfant() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_nb_part_fiscal")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalNbPartFiscal() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_nb_femme")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalNbFemme() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_nb_part_trimf")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalNbPartTrimf() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_nb_jour_cp")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalNbJourCp() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_nb_jour_tr")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalNbJourTr() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_date_entree")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalDateentree() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_motif_sortie")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalMotifSortie() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_convention")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalConvention() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_lib_convention")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalLibConvention() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_Cod_Centres_Impots")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalCentresImpots() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_Lib_Centres_Impots")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalLibCentresImpots() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_centres_securite")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalCentresSecurite() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_lib_centres_securite")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalLibCentresSecurite() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_classement")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalClassement() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_lib_classement")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalLibClassement() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_niv_emploi")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalNivEmploi() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_lib_niv_emploi")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalLibNivEmploi() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_grille")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalGrille() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_lib_grille")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalLibGrille() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_av_nat")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalAvNat() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_brut")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalBrut() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_base_reference")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalBaseReference() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_type_cp")) {
                     if (var5.getBulletinSalaire().getBulsalTypeCP() == 0) {
                        this.chaineColonne = this.chaineColonne + "Normal" + "|";
                     } else if (var5.getBulletinSalaire().getBulsalTypeCP() == 1) {
                        this.chaineColonne = this.chaineColonne + "Normal" + "|";
                     } else if (var5.getBulletinSalaire().getBulsalTypeCP() == 2) {
                        this.chaineColonne = this.chaineColonne + "Bulletin CP" + "|";
                     } else if (var5.getBulletinSalaire().getBulsalTypeCP() == 3) {
                        this.chaineColonne = this.chaineColonne + "Cp travaillés" + "|";
                     } else if (var5.getBulletinSalaire().getBulsalTypeCP() == 4) {
                        this.chaineColonne = this.chaineColonne + "Cp immédiat" + "|";
                     } else if (var5.getBulletinSalaire().getBulsalTypeCP() == 5) {
                        this.chaineColonne = this.chaineColonne + "Cp maternité" + "|";
                     }
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_cp")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalCP() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_nb_cp_pris")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalNbCpPris() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_nb_cp_acquis")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalNbCpAcquis() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_nb_dispo")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalNbDispo() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_base_imposable_fiscale")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalBaseImposableFiscale() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_base_imposable_sociale")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalBaseImposableSociale() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_net_payer")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalNetPayer() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_impot1")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalImpot1() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_impot2")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalImpot2() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_impot3")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalImpot3() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_impot4")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalImpot4() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_impot5")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalImpot5() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_impot6")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalImpot6() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_impot7")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalImpot7() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_impot8")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalImpot8() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_impot9")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalImpot9() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_impot10")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalImpot10() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_date_transfert")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalDateTransfert() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_cle1_anal")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalCle1Anal() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_cle2_anal")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalCle2Anal() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_mode_reglement")) {
                     if (var5.getBulletinSalaire().getBulsalModeReglement() == 0) {
                        this.chaineColonne = this.chaineColonne + "Espèces" + "|";
                     } else if (var5.getBulletinSalaire().getBulsalModeReglement() == 1) {
                        this.chaineColonne = this.chaineColonne + "Chèque" + "|";
                     } else if (var5.getBulletinSalaire().getBulsalModeReglement() == 2) {
                        this.chaineColonne = this.chaineColonne + "Virement" + "|";
                     } else if (var5.getBulletinSalaire().getBulsalModeReglement() == 3) {
                        this.chaineColonne = this.chaineColonne + "Carte sans compte" + "|";
                     } else if (var5.getBulletinSalaire().getBulsalModeReglement() == 4) {
                        this.chaineColonne = this.chaineColonne + "Micro Finance" + "|";
                     } else if (var5.getBulletinSalaire().getBulsalModeReglement() == 5) {
                        this.chaineColonne = this.chaineColonne + "Mobile" + "|";
                     } else {
                        this.chaineColonne = this.chaineColonne + "Autre" + "|";
                     }
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_num_banque")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalNumBanque() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_guichet_banque")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalGuichetBanque() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_compte_banque")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalCompteBanque() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_cle_banque")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalCleBanque() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_iban")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalIban() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_swift")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalSwift() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_compte_membre")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalCompteMembre() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_manuel")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalManuel() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_date_impression")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalDateImpression() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_lot")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalLot() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_secu1")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalSecu1() + "|";
                  } else if (var2.getColumn_name().equals("pay_bulletin_salaire.bulsal_secu2")) {
                     this.chaineColonne = this.chaineColonne + var5.getBulletinSalaire().getBulsalSecu2() + "|";
                  }
               }
            }

            var1 = new ObjetConvention();
            var1.setLib_FR(this.chaineColonne);
            this.lesColonnesChoisies.add(var1);
         }
      }

   }

   public void calculeTempsFacturation(String var1, String var2) throws HibernateException, NamingException {
      this.lesComparatifTF = new ArrayList();
      new ObjetTempsFactures();
      new ArrayList();
      SalariesPointageDao var5 = new SalariesPointageDao(this.baseLog, this.utilInitHibernate);
      List var4 = var5.chargerlesPointagesRequete(this.var_requete, (Session)null);
      if (var4.size() != 0) {
         String var6 = "";
         ArrayList var7 = new ArrayList();

         int var11;
         for(int var8 = 0; var8 < var4.size(); ++var8) {
            String var9 = ((SalariesPointage)var4.get(var8)).getSalpoiMission();
            if (var9 == null || var9.isEmpty()) {
               var9 = "*";
            }

            boolean var10 = false;

            for(var11 = 0; var11 < var7.size(); ++var11) {
               if (((String)var7.get(var11)).equals(var9)) {
                  var10 = true;
                  break;
               }
            }

            if (!var10) {
               if (var6 != null && !var6.isEmpty()) {
                  var6 = var6 + "," + "'" + var9 + "'";
               } else {
                  var6 = "'" + var9 + "'";
               }

               var7.add(var9);
            }
         }

         String var22 = "fac_date >='" + var1 + " 00-00-00' and fac_date <='" + var2 + " 23-59-59' and fac_contrat in (" + var6 + ")";
         new ArrayList();
         FactureEnteteVentesDao var23 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
         List var24 = var23.rechercheFactureRequete(var22, (Session)null);

         for(var11 = 0; var11 < var7.size(); ++var11) {
            String var12 = ((String)var7.get(var11)).toString();
            float var13 = 0.0F;
            double var14 = 0.0D;
            double var16 = 0.0D;

            for(int var18 = 0; var18 < var4.size(); ++var18) {
               if (((SalariesPointage)var4.get(var18)).getSalpoiMission() != null && !((SalariesPointage)var4.get(var18)).getSalpoiMission().isEmpty() && ((SalariesPointage)var4.get(var18)).getSalpoiMission().equals(var12)) {
                  var13 = ((SalariesPointage)var4.get(var18)).getSalpoiDuree();
                  var14 += ((SalariesPointage)var4.get(var18)).getSalpoiPr();
                  var16 += ((SalariesPointage)var4.get(var18)).getSalpoiPv();
               }
            }

            String var25 = "";
            double var19 = 0.0D;

            for(int var21 = 0; var21 < var24.size(); ++var21) {
               if (((FactureEnteteVentes)var24.get(var21)).getFacContrat() != null && !((FactureEnteteVentes)var24.get(var21)).getFacContrat().isEmpty() && ((FactureEnteteVentes)var24.get(var21)).getFacContrat().equals(var12)) {
                  var25 = ((FactureEnteteVentes)var24.get(var21)).getFacNomTiers();
                  var19 = ((FactureEnteteVentes)var24.get(var21)).getFacTotHt();
               }
            }

            ObjetTempsFactures var3 = new ObjetTempsFactures();
            var3.setMission(var12);
            var3.setClient(var25);
            var3.setDuree(var13);
            var3.setPr(var14);
            var3.setPv(var16);
            var3.setTotalFacture(var19);
            this.lesComparatifTF.add(var3);
         }
      }

   }

   public String exportationsVirements(String var1) throws IOException, HibernateException, NamingException {
      this.afficheFichierExport = false;
      File var2 = null;
      String var3 = this.utilDate.dateToStringSQL(new Date());
      String[] var4 = var3.split(" ");
      String[] var5 = var4[1].split(":");
      String var6 = "";
      String var7 = "EXPORT_VRT";
      String var8 = ".TXT";
      if (this.nomEtat.startsWith("0:")) {
         var6 = "STD";
      } else if (this.nomEtat.startsWith("1:")) {
         var6 = "BIS";
      } else if (this.nomEtat.startsWith("2:")) {
         var6 = "AFB120";
      } else if (this.nomEtat.startsWith("3:")) {
         var6 = "AFB160";
      } else if (this.nomEtat.startsWith("4:")) {
         var6 = "MFN";
      } else if (this.nomEtat.startsWith("5:")) {
         var6 = "ORM";
      } else if (this.nomEtat.startsWith("6:")) {
         var6 = "CBAO";
      } else if (this.nomEtat.startsWith("20:")) {
         var6 = "DTSCNSS";
         var7 = "EXPORT_DTSCNSS";
      } else if (this.nomEtat.startsWith("21:")) {
         var6 = "DTSCNAMGS";
         var7 = "EXPORT_DTSCNAMGS";
         var8 = ".XLS";
      }

      String var9 = var7 + "_" + var6 + "_" + var4[0] + "_" + var5[0] + "-" + var5[1] + "-" + var5[2] + var8;
      String var10 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "export" + File.separator;
      this.verificationRepertoireOrigine(var10);
      this.cheminExportOrigine = var10 + var9;
      var2 = new File(this.cheminExportOrigine);
      if (var2.exists()) {
         var2.delete();
         var2 = new File(this.cheminExportOrigine);
      }

      this.verificationRepertoireDestination(this.optionPaye.getDossierExport(), var9);
      String var11 = "";
      if (this.cheminExportOrigine != null && !this.cheminExportOrigine.isEmpty()) {
         var11 = "00000";
         if (this.nomEtat.startsWith("0:")) {
            this.exportSimpleModele1(var2, var11);
         } else if (this.nomEtat.startsWith("1:")) {
            this.exportBis(var2, var11);
         } else if (this.nomEtat.startsWith("2:")) {
            this.exportAfb120(var2, var11);
         } else if (this.nomEtat.startsWith("3:")) {
            this.exportAfb160(var2, var11);
         } else if (this.nomEtat.startsWith("4:")) {
            this.exportMicroFinance(var2, var11);
         } else if (this.nomEtat.startsWith("5:")) {
            this.exportOrangeMoney(var2, var11);
         } else if (this.nomEtat.startsWith("6:")) {
            this.exportCbao(var2, var11);
         } else if (this.nomEtat.startsWith("20:")) {
            this.exportDtsCnss(var2, var11);
         } else if (this.nomEtat.startsWith("21:")) {
            this.exportDtsCnamgs(var2, var11);
         }

         if ((this.lesVirements.size() != 0 || this.lesTrfPaye.size() != 0) && var9 != null && !var9.isEmpty()) {
            this.nomFichier = var9;
            UtilDownload var12 = new UtilDownload();
            String var13 = var1 + "epegase" + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "export" + File.separator + var9;
            this.fichierUrl = var12.convertirFichierUtl(var13, var1);
            this.fichierMine = var12.calculeTypeMine(this.nomFichier);
            var11 = var11 + ":" + var9;
            this.afficheFichierExport = true;
         } else {
            var11 = null;
         }
      }

      return var11;
   }

   public void verificationRepertoireOrigine(String var1) {
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdirs();
      }

   }

   public void verificationRepertoireDestination(String var1, String var2) {
      File var3;
      if (var1 != null && !var1.isEmpty()) {
         if (!var1.endsWith(".TXT") && !var1.endsWith(".txt")) {
            if (var1.endsWith("/")) {
               var3 = new File(var1);
               if (!var3.exists()) {
                  var3.mkdirs();
               }

               this.cheminExportDestination = var1 + var2;
            } else {
               var3 = new File(var1);
               if (!var3.exists()) {
                  var3.mkdirs();
               }

               this.cheminExportDestination = var1 + File.separator + var2;
            }
         } else {
            this.cheminExportDestination = var1;
         }
      } else {
         var1 = "C:" + File.separator + "EXPORT" + File.separator;
         var3 = new File(var1);
         if (!var3.exists()) {
            var3.mkdirs();
         }

         this.cheminExportDestination = var1 + var2;
      }

   }

   public String longueurTexte(String var1, int var2) {
      boolean var3 = false;
      if (var2 < 0) {
         var3 = true;
         var2 *= -1;
      }

      String var4 = "";
      if (var1 != null && !var1.isEmpty() && var1.length() > var2) {
         var4 = var1.substring(0, var2);
      } else if (var1 != null && !var1.isEmpty() && var1.length() >= var2) {
         var4 = var1;
      } else {
         boolean var5 = false;
         int var7;
         if (var1 != null && !var1.isEmpty()) {
            var7 = var2 - var1.length();
         } else {
            var1 = "";
            var7 = var2;
         }

         var4 = "";

         for(int var6 = 0; var6 < var7; ++var6) {
            var4 = var4 + " ";
         }

         if (var3) {
            var4 = var4 + var1;
         } else {
            var4 = var1 + var4;
         }
      }

      return var4;
   }

   public void exportSimpleModele1(File var1, String var2) throws IOException {
      if (this.lesVirements.size() != 0) {
         new BulletinSalaire();
         PrintWriter var4 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(var1), "UTF-8"));

         for(int var5 = 0; var5 < this.lesVirements.size(); ++var5) {
            BulletinSalaire var3 = (BulletinSalaire)this.lesVirements.get(var5);
            String var6 = var3.getBulsalNumBanque() + " " + var3.getBulsalGuichetBanque() + " " + var3.getBulsalCompteBanque() + " " + var3.getBulsalCleBanque();
            long var7 = (long)this.utilNombre.myRoundDevise(var3.getBulsalNetPayer(), this.structureLog.getStrdevise());
            String var9 = this.chiffreExport(var7);
            String var10 = "";
            if (this.banqueSociete != null && !this.banqueSociete.isEmpty() && this.banqueSociete.contains("=")) {
               String[] var11 = this.banqueSociete.split("=");
               String[] var12 = var11[1].split(":");
               var10 = var12[0] + " " + var12[1] + " " + var12[2] + " " + var12[3];
            }

            var4.print(var6 + "|" + var3.getPatronyme() + "|" + var9 + "|" + var3.getBulsalPeriode() + "|" + var10 + "|" + "\r\n");
         }

         var4.close();
      }

   }

   public void exportBis(File var1, String var2) throws IOException {
      if (this.lesVirements.size() != 0) {
         new BulletinSalaire();
         PrintWriter var4 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(var1), "UTF-8"));

         for(int var5 = 0; var5 < this.lesVirements.size(); ++var5) {
            BulletinSalaire var3 = (BulletinSalaire)this.lesVirements.get(var5);
            String var6 = var3.getBulsalNumBanque() + " " + var3.getBulsalGuichetBanque() + " " + var3.getBulsalCompteBanque() + " " + var3.getBulsalCleBanque();
            long var7 = (long)this.utilNombre.myRoundDevise(var3.getBulsalNetPayer(), this.structureLog.getStrdevise());
            String var9 = this.chiffreExport(var7);
            String var10 = "";
            if (this.banqueSociete != null && !this.banqueSociete.isEmpty() && this.banqueSociete.contains("=")) {
               String[] var11 = this.banqueSociete.split("=");
               String[] var12 = var11[1].split(":");
               var10 = var12[0] + " " + var12[1] + " " + var12[2] + " " + var12[3];
            }

            var4.print(var6 + "|" + var9 + "|" + var3.getPatronyme() + "|" + var10 + "|" + "\r\n");
         }

         var4.close();
      }

   }

   public void exportAfb120(File var1, String var2) throws IOException, HibernateException, NamingException {
      if (this.lesVirements.size() != 0) {
         new BulletinSalaire();
         PrintWriter var4 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(var1), "UTF-8"));
         String var5 = "";
         String var6 = "";
         String var7 = "";
         String var8 = "";
         String var9 = "";
         if (this.banqueSociete != null && !this.banqueSociete.isEmpty() && this.banqueSociete.contains("=")) {
            String[] var10 = this.banqueSociete.split("=");
            String[] var11 = var10[1].split(":");
            var5 = var11[0];
            var6 = var11[1];
            var7 = var11[2];
            var8 = var11[3];
            new Contacts();
            ContactDao var13 = new ContactDao(this.baseLog, this.utilInitHibernate);
            Contacts var12 = var13.chargerLesContactsBq(var5, var6, var7, var8, (Session)null);
            if (var12 != null) {
               var9 = var12.getConrefbanque();
            }
         }

         String var37 = "";
         String var38 = "";
         String var39 = "";
         if (this.filtreDateFin.getDate() + 1 <= 9) {
            var37 = "0" + (this.filtreDateFin.getDate() + 1);
         } else {
            var37 = "" + (this.filtreDateFin.getDate() + 1);
         }

         if (this.filtreDateFin.getMonth() + 1 <= 9) {
            var38 = "0" + (this.filtreDateFin.getMonth() + 1);
         } else {
            var38 = "" + (this.filtreDateFin.getMonth() + 1);
         }

         var39 = "" + (this.filtreDateFin.getYear() + 1900 - 2000);
         String var40 = "03";
         String var14 = "02";
         String var15 = this.completeZoneVide("", 8);
         String var16 = this.completeZoneVide(var9, 6);
         String var17 = this.completeZoneVide("", 1);
         String var18 = this.completeZoneVide("", 5);
         String var19 = var37 + var38 + var39;
         String var20 = this.completeZoneVide(this.structureLog.getStrraisonsociale(), 24);
         String var21 = this.completeZoneVide("", 7);
         String var22 = this.completeZoneVide("", 17);
         String var23 = this.completeZoneVide("", 8);
         String var27 = this.completeZoneVide("", 13);
         String var28 = this.completeZoneVide("", 31);
         String var30 = this.completeZoneVide("", 6);
         var4.print(var40 + var14 + var15 + var16 + var17 + var18 + var19 + var20 + var21 + var22 + var23 + var6 + var7 + var8 + var27 + var28 + var5 + var30 + "\r\n");
         double var31 = 0.0D;

         String var24;
         String var25;
         String var26;
         String var29;
         for(int var33 = 0; var33 < this.lesVirements.size(); ++var33) {
            BulletinSalaire var3 = (BulletinSalaire)this.lesVirements.get(var33);
            var31 += var3.getBulsalNetPayer();
            long var34 = (long)this.utilNombre.myRoundDevise(var3.getBulsalNetPayer(), this.structureLog.getStrdevise());
            String var36 = this.chiffreExport(var34);
            var40 = "06";
            var14 = "02";
            var15 = this.completeZoneVide("", 8);
            var16 = this.completeZoneVide(var9, 6);
            var17 = this.completeZoneVide("", 12);
            var18 = "";
            var19 = "";
            var20 = this.completeZoneVide(var3.getPatronyme(), 24);
            var21 = this.completeZoneVide("", 20);
            var22 = this.completeZoneVide("", 4);
            var23 = this.completeZoneVide("", 8);
            var24 = var3.getBulsalGuichetBanque();
            var25 = var3.getBulsalCompteBanque();
            var26 = var3.getBulsalCleBanque();
            var27 = this.completeZone0(var36, 13);
            if (this.modeExportation == 1) {
               var28 = this.completeZoneVide("QUINZAINE MOIS " + var3.getBulsalPeriode(), 31);
            } else {
               var28 = this.completeZoneVide("SALAIRE MOIS " + var3.getBulsalPeriode(), 31);
            }

            var29 = var3.getBulsalNumBanque();
            var30 = this.completeZoneVide("", 6);
            var4.print(var40 + var14 + var15 + var16 + var17 + var18 + var19 + var20 + var21 + var22 + var23 + var24 + var25 + var26 + var27 + var28 + var29 + var30 + "\r\n");
         }

         long var41 = (long)this.utilNombre.myRoundDevise(var31, this.structureLog.getStrdevise());
         String var35 = this.chiffreExport(var41);
         var40 = "08";
         var14 = "02";
         var15 = this.completeZoneVide("", 8);
         var16 = this.completeZoneVide(var9, 6);
         var17 = this.completeZoneVide("", 12);
         var18 = "";
         var19 = "";
         var20 = this.completeZoneVide("", 24);
         var21 = this.completeZoneVide("", 20);
         var22 = "";
         var23 = this.completeZoneVide("", 8);
         var24 = this.completeZoneVide("", 5);
         var25 = this.completeZoneVide("", 12);
         var26 = this.completeZoneVide("", 2);
         var27 = this.completeZone0(var35, 16);
         var28 = this.completeZoneVide("", 33);
         var29 = this.completeZoneVide("", 5);
         var30 = this.completeZoneVide("", 6);
         var4.print(var40 + var14 + var15 + var16 + var17 + var18 + var19 + var20 + var21 + var22 + var23 + var24 + var25 + var26 + var27 + var28 + var29 + var30 + "\r\n");
         var4.close();
      }

   }

   public void exportAfb160(File var1, String var2) throws IOException, HibernateException, NamingException {
      if (this.lesVirements.size() != 0) {
         BulletinSalaire var3 = new BulletinSalaire();
         String var4 = "";
         String var5 = "";
         String var6 = "";
         String var7 = "";
         String var8 = "";
         if (this.banqueSociete != null && !this.banqueSociete.isEmpty() && this.banqueSociete.contains("=")) {
            String[] var9 = this.banqueSociete.split("=");
            String[] var10 = var9[1].split(":");
            var4 = var10[0];
            var5 = var10[1];
            var6 = var10[2];
            var7 = var10[3];
            new Contacts();
            ContactDao var12 = new ContactDao(this.baseLog, this.utilInitHibernate);
            Contacts var11 = var12.chargerLesContactsBq(var4, var5, var6, var7, (Session)null);
            if (var11 != null) {
               var8 = var11.getConrefbanque();
            }
         }

         String var30 = "";
         String var31 = "";
         String var32 = "";
         if (this.filtreDateFin.getDate() + 1 <= 9) {
            var30 = "0" + (this.filtreDateFin.getDate() + 1);
         } else {
            var30 = "" + (this.filtreDateFin.getDate() + 1);
         }

         if (this.filtreDateFin.getMonth() + 1 <= 9) {
            var31 = "0" + (this.filtreDateFin.getMonth() + 1);
         } else {
            var31 = "" + (this.filtreDateFin.getMonth() + 1);
         }

         var32 = "" + (this.filtreDateFin.getYear() + 1900 - 2000);
         PrintWriter var33 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(var1), "UTF-8"));
         String var13 = "03";
         String var14 = "02";
         String var15 = this.completeZoneVide("", 8) + this.completeZoneVide(var8, 6);
         String var16 = this.completeZoneVide("", 7) + var30 + var31 + var32.substring(1, 2);
         String var17 = this.completeZoneVide(this.structureLog.getStrraisonsociale(), 24);
         String var18 = this.completeZoneVide("", 32);
         String var19 = this.completeZoneVide(var5, 5);
         String var20 = this.completeZoneVide(var6, 11);
         String var21 = "";
         String var22 = this.completeZoneVide("", 47);
         String var23 = this.completeZoneVide(var4, 5) + this.completeZoneVide("", 6);
         var33.print(var13 + var14 + var15 + var16 + var17 + var18 + var19 + var20 + var21 + var22 + var23 + "\r\n");
         double var24 = 0.0D;

         for(int var26 = 0; var26 < this.lesVirements.size(); ++var26) {
            var3 = (BulletinSalaire)this.lesVirements.get(var26);
            var24 += var3.getBulsalNetPayer();
            long var27 = (long)this.utilNombre.myRoundDevise(var3.getBulsalNetPayer(), this.structureLog.getStrdevise());
            String var29 = this.chiffreExport(var27);
            var13 = "06";
            var14 = "02";
            var15 = this.completeZoneVide("", 8) + this.completeZoneVide(var8, 6);
            var16 = this.completeZoneVide(var3.getBulsalPeriode(), 12);
            var17 = this.completeZoneVide(var3.getPatronyme(), 24);
            var18 = this.completeZoneVide("", 32);
            var19 = this.completeZoneVide(var3.getBulsalGuichetBanque(), 5);
            var20 = this.completeZoneVide(var3.getBulsalCompteBanque(), 11);
            var21 = this.completeZone0(var29, 16);
            if (this.modeExportation == 1) {
               var22 = this.completeZoneVide("QUINZAINE MOIS " + var3.getBulsalPeriode(), 31);
            } else {
               var22 = this.completeZoneVide("SALAIRE MOIS " + var3.getBulsalPeriode(), 31);
            }

            var23 = this.completeZoneVide(var3.getBulsalNumBanque(), 5) + this.completeZoneVide("", 6);
            var33.print(var13 + var14 + var15 + var16 + var17 + var18 + var19 + var20 + var21 + var22 + var23 + "\r\n");
         }

         long var34 = (long)this.utilNombre.myRoundDevise(var24, this.structureLog.getStrdevise());
         String var28 = this.chiffreExport(var34);
         var13 = "08";
         var14 = "02";
         var15 = this.completeZoneVide("", 8) + this.completeZoneVide(var8, 6);
         var16 = this.completeZoneVide("", 84);
         var21 = this.completeZone0(var28, 16);
         if (this.modeExportation == 1) {
            var22 = this.completeZoneVide("QUINZAINE MOIS " + var3.getBulsalPeriode(), 31);
         } else {
            var22 = this.completeZoneVide("SALAIRE MOIS " + var3.getBulsalPeriode(), 31);
         }

         var23 = this.completeZoneVide("", 5) + this.completeZoneVide("", 6);
         var33.print(var13 + var14 + var15 + var16 + var21 + var22 + var23 + "\r\n");
         var33.close();
      }

   }

   public void exportMicroFinance(File var1, String var2) throws IOException {
      if (this.lesVirements.size() != 0) {
         new BulletinSalaire();
         PrintWriter var4 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(var1), "UTF-8"));

         for(int var5 = 0; var5 < this.lesVirements.size(); ++var5) {
            BulletinSalaire var3 = (BulletinSalaire)this.lesVirements.get(var5);
            String var6 = var3.getBulsalNumBanque() + " " + var3.getBulsalGuichetBanque() + " " + var3.getBulsalCompteBanque() + " " + var3.getBulsalCleBanque();
            long var7 = (long)this.utilNombre.myRoundDevise(var3.getBulsalNetPayer(), this.structureLog.getStrdevise());
            String var9 = this.chiffreExport(var7);
            String var10 = "";
            if (this.banqueSociete != null && !this.banqueSociete.isEmpty() && this.banqueSociete.contains("=")) {
               String[] var11 = this.banqueSociete.split("=");
               String[] var12 = var11[1].split(":");
               var10 = var12[0] + " " + var12[1] + " " + var12[2] + " " + var12[3];
            }

            var4.print(var6 + "|" + var9 + "|" + var3.getBulsalCompteMembre() + "|" + var10 + "|" + "\r\n");
         }

         var4.close();
      }

   }

   public void exportOrangeMoney(File var1, String var2) throws IOException {
      if (this.lesVirements.size() != 0) {
         new BulletinSalaire();
         PrintWriter var4 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(var1), "UTF-8"));
         var4.print("Numéro distributeur|Numéro client|Net à payer|\r\n");
         double var5 = 0.0D;
         int var7 = 0;

         for(int var8 = 0; var8 < this.lesVirements.size(); ++var8) {
            BulletinSalaire var3 = (BulletinSalaire)this.lesVirements.get(var8);
            ++var7;
            var5 += var3.getBulsalNetPayer();
            long var9 = (long)this.utilNombre.myRoundDevise(var3.getBulsalNetPayer(), this.structureLog.getStrdevise());
            String var11 = this.chiffreExport(var9);
            var4.print(this.structureLog.getStrcpteorange() + "|" + var3.getSalaries().getSalCompteBanque() + "|" + var11 + "|" + "\r\n");
         }

         long var12 = (long)this.utilNombre.myRoundDevise(var5, this.structureLog.getStrdevise());
         String var10 = this.chiffreExport(var12);
         var4.print(var7 + "|" + "Total net à payer" + "|" + var10 + "|" + "\r\n");
         var4.close();
      }

   }

   public void exportCbao(File var1, String var2) throws IOException {
      if (this.lesVirements.size() != 0) {
         new BulletinSalaire();
         PrintWriter var4 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(var1), "UTF-8"));
         String var5 = "";
         String var6 = "";
         String var7 = "";
         String var8 = "";
         if (this.banqueSociete != null && !this.banqueSociete.isEmpty() && this.banqueSociete.contains("=")) {
            String[] var9 = this.banqueSociete.split("=");
            String[] var10 = var9[1].split(":");
            var5 = var10[0];
            var6 = var10[1];
            var7 = var10[2];
            var8 = var10[3];
         }

         String var33 = "";
         String var34 = "";
         String var11 = "";
         if ((new Date()).getDate() <= 9) {
            var33 = "0" + (new Date()).getDate();
         } else {
            var33 = "" + (new Date()).getDate();
         }

         if ((new Date()).getMonth() + 1 <= 9) {
            var34 = "0" + ((new Date()).getMonth() + 1);
         } else {
            var34 = "" + ((new Date()).getMonth() + 1);
         }

         var11 = "" + ((new Date()).getYear() + 1900 - 2000);
         String var12 = "1";
         String var13 = "        ";
         String var14 = var33 + var34 + var11;
         String var15 = this.completeZoneVide(this.structureLog.getStrraisonsociale(), 36);
         String var16 = this.completeZoneVide(var5, 5);
         String var17 = this.completeZoneVide(var6, 5);
         String var18 = this.completeZoneVide(var7, 12);
         String var19 = "    " + this.completeZoneVide(var8, 2);
         String var20 = this.completeZone0(this.chiffreExport((long)this.lesVirements.size()), 6);
         double var21 = 0.0D;

         for(int var23 = 0; var23 < this.lesVirements.size(); ++var23) {
            var21 += ((BulletinSalaire)this.lesVirements.get(var23)).getBulsalNetPayer();
         }

         long var35 = (long)this.utilNombre.myRoundDevise(var21, this.structureLog.getStrdevise());
         String var25 = this.chiffreExport(var35);
         String var26 = this.completeZone0(var25, 20);
         String var27 = "";
         String var28 = "";
         String var29 = "";
         if (this.filtreDateFin.getDate() <= 9) {
            var27 = "0" + this.filtreDateFin.getDate();
         } else {
            var27 = "" + this.filtreDateFin.getDate();
         }

         if (this.filtreDateFin.getMonth() + 1 <= 9) {
            var28 = "0" + (this.filtreDateFin.getMonth() + 1);
         } else {
            var28 = "" + (this.filtreDateFin.getMonth() + 1);
         }

         var29 = "" + (this.filtreDateFin.getYear() + 1900 - 2000);
         String var30 = "";
         if (this.modeExportation == 1) {
            var30 = "   QUNZAINE         " + var27 + var28 + var29;
         } else {
            var30 = "   VIREMENT SALAIRE " + var27 + var28 + var29;
         }

         String var31 = "          001";
         var4.print(var12 + var13 + var14 + var15 + var16 + var17 + var18 + var19 + var20 + var26 + var30 + var31 + "\r\n");

         for(int var32 = 0; var32 < this.lesVirements.size(); ++var32) {
            BulletinSalaire var3 = (BulletinSalaire)this.lesVirements.get(var32);
            var35 = (long)this.utilNombre.myRoundDevise(var3.getBulsalNetPayer(), this.structureLog.getStrdevise());
            var25 = this.chiffreExport(var35);
            var12 = "2            ";
            var13 = this.completeZoneVide(this.filtreCaracteres(var3.getSalaries().getPatronyme()), 60);
            var14 = this.completeZoneVide(var3.getBulsalNumBanque(), 5);
            var15 = this.completeZoneVide(var3.getBulsalGuichetBanque(), 5);
            var16 = this.completeZoneVide(var3.getBulsalCompteBanque(), 12);
            var17 = "    " + this.completeZoneVide(var3.getBulsalCleBanque(), 2);
            var18 = this.completeZoneVide(var25, 23);
            if (this.modeExportation == 1) {
               var19 = "QINZAINE         " + var27 + var28 + var29;
            } else {
               var19 = "VIREMENT SALAIRE " + var27 + var28 + var29;
            }

            var20 = "              1";
            var4.print(var12 + var13 + var14 + var15 + var16 + var17 + var18 + var19 + var20 + "\r\n");
         }

         var4.close();
      }

   }

   public void exportDtsCnss(File var1, String var2) throws UnsupportedEncodingException, FileNotFoundException {
      if (this.lesTrfPaye.size() != 0) {
         new TransfertPaye();
         String var4 = "";
         String var5 = "";
         String var6 = "";
         if ((new Date()).getDate() + 1 <= 9) {
            var4 = "0" + ((new Date()).getDate() + 1);
         } else {
            var4 = "" + ((new Date()).getDate() + 1);
         }

         if ((new Date()).getMonth() + 1 <= 9) {
            var5 = "0" + ((new Date()).getMonth() + 1);
         } else {
            var5 = "" + ((new Date()).getMonth() + 1);
         }

         var6 = "" + (this.filtreDateFin.getYear() + 1900);
         PrintWriter var7 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(var1), "UTF-8"));
         String var8 = "03";
         String var9 = "";
         if (this.filtreDateFin.getMonth() + 1 == 3) {
            var9 = "1";
         } else if (this.filtreDateFin.getMonth() + 1 == 6) {
            var9 = "2";
         } else if (this.filtreDateFin.getMonth() + 1 == 9) {
            var9 = "3";
         } else if (this.filtreDateFin.getMonth() + 1 == 12) {
            var9 = "4";
         }

         String var11 = this.completeZoneVide(this.structureLog.getStrnum5(), 14);
         String var12 = this.completeZoneVide(this.structureLog.getStrraisonsociale(), 50);
         String var13 = this.completeZoneVide(this.structureLog.getStrsigle(), 15);
         String var14 = this.completeZoneVide(this.structureLog.getStrbp(), 6);
         String var15 = this.completeZoneVide(this.structureLog.getStrville(), 30);
         String var16 = this.completeZoneVide(this.structureLog.getStrtel1(), 10);
         String var17 = this.completeZoneVide(this.structureLog.getStrfax(), 10);
         String var18 = this.completeZoneVide("", 30);
         String var19 = this.completeZoneVide((new Date()).getYear() + 1900 + var5 + var4, 8);
         var7.print(var8 + ";" + var9 + ";" + var6 + ";" + var11 + ";" + var12 + ";" + var13 + ";" + var14 + ";" + var15 + ";" + var16 + ";" + var17 + ";" + var18 + ";" + var19 + "\r\n");
         String var20 = "";
         String var21 = "";
         String var22 = "";
         String var23 = "";
         String var24 = "";
         String var25 = "";
         String var26 = "";
         String var27 = "";
         String var28 = "";
         String var29 = "";
         String var30 = "";
         String var31 = "";
         double var32 = 0.0D;
         double var34 = 0.0D;
         double var36 = 0.0D;
         int var38 = 0;
         String var39 = "" + (this.optionPaye.getTauxcnssPS() + this.optionPaye.getTauxcnssPP()) + "0";

         String var10;
         for(int var40 = 0; var40 < this.lesTrfPaye.size(); ++var40) {
            TransfertPaye var3 = (TransfertPaye)this.lesTrfPaye.get(var40);
            ++var38;
            var8 = "06";
            var9 = this.completeZone0("" + (var40 + 1), 4);
            var10 = this.completeZoneVide(((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColT02(), 15);
            var11 = this.completeZoneVide(((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColT03(), 15);
            var12 = this.completeZoneVide(((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfNomFeuille(), 15);
            var13 = this.completeZoneVide(((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColT00(), 50);
            var14 = this.completeZoneVide(((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColT01(), 50);
            var15 = this.completeZone0(var39.replace(".", ""), 4);
            var16 = this.completeZone0("0000", 4);
            var17 = this.completeZoneVide(((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColT04(), 8);
            var18 = this.completeZoneVide(((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColT05(), 8);
            var20 = this.completeZone0(this.chiffreExport((long)((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN11()), 10);
            var21 = this.completeZone0(this.chiffreExport((long)((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN12()), 10);
            var22 = this.completeZone0("0", 10);
            var23 = this.completeZone0(this.chiffreExport((long)(((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN05() - ((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN06())), 2);
            var32 += ((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN12();
            var34 += (((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN01() + ((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN03()) * -1.0D;
            var36 = var36 + ((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN05() - ((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN06();
            var24 = this.completeZone0(this.chiffreExport((long)((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN31()), 10);
            var25 = this.completeZone0(this.chiffreExport((long)((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN32()), 10);
            var26 = this.completeZone0("0", 10);
            var27 = this.completeZone0(this.chiffreExport((long)(((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN25() - ((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN26())), 2);
            var32 += ((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN32();
            var34 += (((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN21() + ((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN23()) * -1.0D;
            var36 = var36 + ((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN25() - ((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN26();
            var28 = this.completeZone0(this.chiffreExport((long)((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN51()), 10);
            var29 = this.completeZone0(this.chiffreExport((long)((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN52()), 10);
            var30 = this.completeZone0("0", 10);
            var31 = this.completeZone0(this.chiffreExport((long)(((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN45() - ((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN46())), 2);
            var32 += ((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN52();
            var34 += (((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN41() + ((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN43()) * -1.0D;
            var36 = var36 + ((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN45() - ((TransfertPaye)this.lesTrfPaye.get(var40)).getTrfColN46();
            var7.print(var8 + ";" + var9 + ";" + var10 + ";" + var11 + ";" + var12 + ";" + var13 + ";" + var14 + ";" + var15 + ";" + var16 + ";" + var17 + ";" + var18 + ";" + var20 + ";" + var21 + ";" + var22 + ";" + var23 + ";" + var24 + ";" + var25 + ";" + var26 + ";" + var27 + ";" + var28 + ";" + var29 + ";" + var30 + ";" + var31 + "\r\n");
         }

         String var44 = this.chiffreExport((long)var32);
         String var41 = this.chiffreExport((long)var34);
         String var42 = this.chiffreExport((long)var36);
         String var43 = this.chiffreExport((long)var38);
         var8 = "07";
         var9 = this.completeZone0(var44, 12);
         var10 = this.completeZone0(var41, 12);
         var11 = this.completeZone0("0", 12);
         var12 = this.completeZone0(var41, 12);
         var13 = this.completeZone0(var43, 4);
         var14 = this.completeZone0(var42, 7);
         var15 = this.completeZone0(var39.replace(".", ""), 4);
         var7.print(var8 + ";" + var9 + ";" + var10 + ";" + var11 + ";" + var12 + ";" + var13 + ";" + var14 + ";" + var15 + "\r\n");
         var8 = "08";
         var9 = this.completeZone0("0", 12);
         var10 = this.completeZone0("0", 12);
         var11 = this.completeZone0("0", 4);
         var12 = this.completeZone0("0", 7);
         var13 = this.completeZone0("0", 4);
         var7.print(var8 + ";" + var9 + ";" + var10 + ";" + var11 + ";" + var12 + ";" + var13 + "\r\n");
         var7.close();
      }

   }

   public void exportDtsCnamgs(File var1, String var2) throws FileNotFoundException, UnsupportedEncodingException {
      if (this.lesTrfPaye.size() != 0) {
         try {
            new TransfertPaye();
            String var4 = "";
            String var5 = "";
            String var6 = "";
            if ((new Date()).getDate() + 1 <= 9) {
               var4 = "0" + ((new Date()).getDate() + 1);
            } else {
               var4 = "" + ((new Date()).getDate() + 1);
            }

            if ((new Date()).getMonth() + 1 <= 9) {
               var5 = "0" + ((new Date()).getMonth() + 1);
            } else {
               var5 = "" + ((new Date()).getMonth() + 1);
            }

            var6 = "" + (this.filtreDateFin.getYear() + 1900);
            String var7 = "";
            if (this.filtreDateFin.getMonth() + 1 == 3) {
               var7 = "1";
            } else if (this.filtreDateFin.getMonth() + 1 == 6) {
               var7 = "2";
            } else if (this.filtreDateFin.getMonth() + 1 == 9) {
               var7 = "3";
            } else if (this.filtreDateFin.getMonth() + 1 == 12) {
               var7 = "4";
            }

            String var8 = "" + this.utilNombre.myRound(this.optionPaye.getTauxcnamgsPS() + this.optionPaye.getTauxcnamgsPP(), 2);
            WritableWorkbook var9 = Workbook.createWorkbook(var1);
            WritableSheet var10 = var9.createSheet("Feuille HORUS", 0);
            Label var11 = null;
            WritableCellFormat var12 = new WritableCellFormat();
            var12.setBackground(Colour.GREY_25_PERCENT);
            var12.setBorder(Border.ALL, BorderLineStyle.THIN);
            WritableCellFormat var13 = new WritableCellFormat();
            var13.setBackground(Colour.WHITE);
            var13.setBorder(Border.ALL, BorderLineStyle.THIN);
            double var14 = 0.0D;
            double var16 = 0.0D;
            double var18 = 0.0D;
            double var20 = 0.0D;
            double var22 = 0.0D;
            double var24 = 0.0D;
            double var26 = 0.0D;

            int var28;
            for(var28 = 0; var28 < this.lesTrfPaye.size(); ++var28) {
               var14 = var14 + ((TransfertPaye)this.lesTrfPaye.get(var28)).getTrfColN02() + ((TransfertPaye)this.lesTrfPaye.get(var28)).getTrfColN04() + ((TransfertPaye)this.lesTrfPaye.get(var28)).getTrfColN22() + ((TransfertPaye)this.lesTrfPaye.get(var28)).getTrfColN24() + ((TransfertPaye)this.lesTrfPaye.get(var28)).getTrfColN42() + ((TransfertPaye)this.lesTrfPaye.get(var28)).getTrfColN44();
               var18 = var18 + ((TransfertPaye)this.lesTrfPaye.get(var28)).getTrfColN02() + ((TransfertPaye)this.lesTrfPaye.get(var28)).getTrfColN22() + ((TransfertPaye)this.lesTrfPaye.get(var28)).getTrfColN42();
               var16 = var16 + ((TransfertPaye)this.lesTrfPaye.get(var28)).getTrfColN04() + ((TransfertPaye)this.lesTrfPaye.get(var28)).getTrfColN24() + ((TransfertPaye)this.lesTrfPaye.get(var28)).getTrfColN44();
               var20 = var20 + ((TransfertPaye)this.lesTrfPaye.get(var28)).getTrfColN13() + ((TransfertPaye)this.lesTrfPaye.get(var28)).getTrfColN33() + ((TransfertPaye)this.lesTrfPaye.get(var28)).getTrfColN53();
               var22 += ((TransfertPaye)this.lesTrfPaye.get(var28)).getTrfColN13();
               var24 += ((TransfertPaye)this.lesTrfPaye.get(var28)).getTrfColN33();
               var26 += ((TransfertPaye)this.lesTrfPaye.get(var28)).getTrfColN53();
            }

            var11 = new Label(0, 9, "Matricule employeur CNAMGS");
            var10.addCell(var11);
            var11 = new Label(0, 10, this.structureLog.getStrnum4());
            var10.addCell(var11);
            var11 = new Label(0, 10, this.structureLog.getStrnum4());
            var10.addCell(var11);
            var11 = new Label(0, 12, this.structureLog.getStrraisonsociale());
            var10.addCell(var11);
            var11 = new Label(0, 14, "B.P.: ");
            var10.addCell(var11);
            var11 = new Label(1, 14, this.structureLog.getStrbp());
            var10.addCell(var11);
            var11 = new Label(2, 14, "Ville: " + this.structureLog.getStrville());
            var10.addCell(var11);
            var11 = new Label(0, 16, "Tel.: ");
            var10.addCell(var11);
            var11 = new Label(1, 16, this.structureLog.getStrtel1());
            var10.addCell(var11);
            var11 = new Label(2, 16, "Fax: " + this.structureLog.getStrfax());
            var10.addCell(var11);
            var11 = new Label(0, 18, "eMAIL: ");
            var10.addCell(var11);
            var11 = new Label(0, 19, "Cotisations nettes dues CNAMGS");
            var10.addCell(var11);
            var11 = new Label(0, 20, "" + var14 * -1.0D);
            var10.addCell(var11);
            var11 = new Label(0, 21, "Cotisations payées à la CNAMGS");
            var10.addCell(var11);
            var11 = new Label(0, 22, "" + var14 * -1.0D);
            var10.addCell(var11);
            var11 = new Label(0, 24, "Récap. ");
            var10.addCell(var11);
            var11 = new Label(1, 24, "Effectif");
            var10.addCell(var11);
            var11 = new Label(2, 24, "" + this.lesTrfPaye.size());
            var10.addCell(var11);
            var11 = new Label(4, 5, "DECLARATION TRIMESTRIELLE DE SALAIRES");
            var10.addCell(var11);
            var11 = new Label(5, 6, "PERIODE: " + var7);
            var10.addCell(var11);
            var11 = new Label(4, 13, "Taux de cotisation: ");
            var10.addCell(var11);
            var11 = new Label(6, 13, var8);
            var10.addCell(var11);
            var11 = new Label(4, 14, "Employeur: ");
            var10.addCell(var11);
            var11 = new Label(6, 14, "" + this.utilNombre.myRound(this.optionPaye.getTauxcnamgsPP(), 2));
            var10.addCell(var11);
            var11 = new Label(4, 15, "Travailleur: ");
            var10.addCell(var11);
            var11 = new Label(6, 15, "" + this.utilNombre.myRound(this.optionPaye.getTauxcnamgsPS(), 2));
            var10.addCell(var11);
            var11 = new Label(4, 18, "Plafond mensuel CNAMGS");
            var10.addCell(var11);
            var11 = new Label(6, 18, "" + this.optionPaye.getCnamgs());
            var10.addCell(var11);
            var11 = new Label(3, 24, "MASSE SALARIALE SOUMISE A COTISATION :");
            var10.addCell(var11);
            var11 = new Label(6, 24, "" + var20);
            var10.addCell(var11);
            var11 = new Label(4, 27, " TOTAL A REPORTER PAGE SUIVANTE:");
            var10.addCell(var11);
            var11 = new Label(5, 27, "" + var22);
            var10.addCell(var11);
            var11 = new Label(7, 27, "" + var24);
            var10.addCell(var11);
            var11 = new Label(9, 27, "" + var26);
            var10.addCell(var11);
            var11 = new Label(8, 11, "CACHET ET SIGNATURE :");
            var10.addCell(var11);
            var11 = new Label(8, 19, "DATE DE RECEPTION :");
            var10.addCell(var11);
            var11 = new Label(7, 24, "COTISATIONS SOCIALES :");
            var10.addCell(var11);
            var11 = new Label(9, 24, "" + var14 * -1.0D);
            var10.addCell(var11);
            var11 = new Label(7, 25, "Part patronale :");
            var10.addCell(var11);
            var11 = new Label(9, 25, "" + var16 * -1.0D);
            var10.addCell(var11);
            var11 = new Label(7, 26, "Part salariale :");
            var10.addCell(var11);
            var11 = new Label(9, 26, "" + var18 * -1.0D);
            var10.addCell(var11);
            var11 = new Label(0, 30, "Date limite de retour de la DTS à la CNAMGS :");
            var10.addCell(var11);
            var11 = new Label(0, 31, "Date limite de paiement des cotisations dues à la CNAMGS :");
            var10.addCell(var11);
            var11 = new Label(0, 33, "Au-delà de la date ci-dessus, une pénalité est appliquée conformément à la loi :");
            var10.addCell(var11);
            var11 = new Label(0, 34, "- 25% pour non dépôt de la DTS calculé sur le montant de la DTS du dernier trimestre déclaré ;");
            var10.addCell(var11);
            var11 = new Label(0, 35, "- 2% pour non paiement des cotisations par mois de retard cumulable au prorata temporis ;");
            var10.addCell(var11);
            var11 = new Label(0, 36, "NB: Veuillez mettre les effectifs à jour avec les mouvements justifiés entrants et sortants du personnel");
            var10.addCell(var11);
            var11 = new Label(3, 38, "Date");
            var10.addCell(var11);
            var11 = new Label(5, 38, "Mois 1");
            var10.addCell(var11);
            var11 = new Label(7, 38, "Mois 2");
            var10.addCell(var11);
            var11 = new Label(9, 38, "Mois 3");
            var10.addCell(var11);
            var11 = new Label(0, 39, "N°");
            var10.addCell(var11);
            var11 = new Label(1, 39, "MATRICULE");
            var10.addCell(var11);
            var11 = new Label(2, 39, "NOM E TPRENOM");
            var10.addCell(var11);
            var11 = new Label(3, 39, "EMBAUCHE");
            var10.addCell(var11);
            var11 = new Label(4, 39, "CESSATION");
            var10.addCell(var11);
            var11 = new Label(5, 39, "Assiette soumis à cotisation");
            var10.addCell(var11);
            var11 = new Label(6, 39, "Nbre Hrs/Jrs");
            var10.addCell(var11);
            var11 = new Label(7, 39, "Assiette soumis à cotisation");
            var10.addCell(var11);
            var11 = new Label(8, 39, "Nbre Hrs/Jrs");
            var10.addCell(var11);
            var11 = new Label(9, 39, "Assiette soumis à cotisation");
            var10.addCell(var11);
            var11 = new Label(10, 39, "Nbre Hrs/Jrs");
            var10.addCell(var11);
            boolean var33 = false;

            for(int var29 = 0; var29 < this.lesTrfPaye.size(); ++var29) {
               var11 = new Label(0, var29 + 40, "" + (var29 + 1));
               var10.addCell(var11);
               var11 = new Label(1, var29 + 40, ((TransfertPaye)this.lesTrfPaye.get(var29)).getTrfColT03());
               var10.addCell(var11);
               var11 = new Label(2, var29 + 40, ((TransfertPaye)this.lesTrfPaye.get(var29)).getTrfColT00() + " " + ((TransfertPaye)this.lesTrfPaye.get(var29)).getTrfColT01());
               var10.addCell(var11);
               var11 = new Label(3, var29 + 40, ((TransfertPaye)this.lesTrfPaye.get(var29)).getTrfColT04());
               var10.addCell(var11);
               var11 = new Label(4, var29 + 40, ((TransfertPaye)this.lesTrfPaye.get(var29)).getTrfColT05());
               var10.addCell(var11);
               var11 = new Label(5, var29 + 40, "" + ((TransfertPaye)this.lesTrfPaye.get(var29)).getTrfColN14());
               var10.addCell(var11);
               var11 = new Label(6, var29 + 40, "" + (((TransfertPaye)this.lesTrfPaye.get(var29)).getTrfColN05() - ((TransfertPaye)this.lesTrfPaye.get(var29)).getTrfColN06()));
               var10.addCell(var11);
               var11 = new Label(7, var29 + 40, "" + ((TransfertPaye)this.lesTrfPaye.get(var29)).getTrfColN34());
               var10.addCell(var11);
               var11 = new Label(8, var29 + 40, "" + (((TransfertPaye)this.lesTrfPaye.get(var29)).getTrfColN25() - ((TransfertPaye)this.lesTrfPaye.get(var29)).getTrfColN26()));
               var10.addCell(var11);
               var11 = new Label(9, var29 + 40, "" + ((TransfertPaye)this.lesTrfPaye.get(var29)).getTrfColN54());
               var10.addCell(var11);
               var11 = new Label(10, var29 + 40, "" + (((TransfertPaye)this.lesTrfPaye.get(var29)).getTrfColN45() - ((TransfertPaye)this.lesTrfPaye.get(var29)).getTrfColN46()));
               var10.addCell(var11);
               var28 = var29 + 1;
            }

            new CellView();

            for(int var30 = 0; var30 < var10.getColumns(); ++var30) {
               CellView var34 = var10.getColumnView(var30);
               var34.setSize(10);
               var34.setDimension(10);
               var10.setColumnView(var30, var34);
            }

            var9.write();
            var9.close();
         } catch (IOException var31) {
            var31.printStackTrace();
         } catch (WriteException var32) {
            var32.printStackTrace();
         }
      }

   }

   public String chiffreExport(long var1) {
      String var3 = "";
      String var4 = "" + var1;
      if (var4.contains(".")) {
         String var5 = "";
         boolean var6 = false;
         int var7 = var4.indexOf(".");
         var5 = var4.substring(0, var7);
         var3 = var5;
      } else {
         var3 = var4;
      }

      return var3;
   }

   public String completeZone0(String var1, int var2) {
      String var3 = "";
      int var4 = var1.length();
      int var5 = var2 - var4;

      for(int var6 = 0; var6 < var5; ++var6) {
         var3 = var3 + "0";
      }

      var3 = var3 + var1;
      return var3;
   }

   public String completeZoneVide(String var1, int var2) {
      String var3 = "";
      boolean var4 = false;
      boolean var5 = false;
      int var8;
      if (var1 != null && !var1.isEmpty() && !var1.equalsIgnoreCase("null")) {
         var8 = var1.length();
      } else {
         var8 = 0;
      }

      int var7 = var2 - var8;
      if (var7 > 0) {
         for(int var6 = 0; var6 < var7; ++var6) {
            var3 = var3 + " ";
         }

         var3 = var1 + var3;
      } else {
         var3 = var1.substring(0, var2);
      }

      return var3;
   }

   public String filtreCaracteres(String var1) {
      String var2 = "";
      String var3 = "";

      for(int var4 = 0; var4 < var1.length(); ++var4) {
         var3 = (String)var1.subSequence(var4, var4 + 1);
         if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz:=,1234567890 ".contains(var3)) {
            var2 = var2 + var3.toUpperCase();
         }
      }

      return var2;
   }

   public void enregistre(File var1) {
      try {
         XMLOutputter var2 = new XMLOutputter(Format.getPrettyFormat());
         FileOutputStream var3 = new FileOutputStream(var1);
         var2.output(this.document, var3);
         var3.close();
      } catch (IOException var4) {
      }

   }

   public String exportationsColonnes(String var1) throws IOException, HibernateException, NamingException {
      this.afficheFichierExport = false;
      File var2 = null;
      String var3 = this.utilDate.dateToStringSQL(new Date());
      String[] var4 = var3.split(" ");
      String[] var5 = var4[1].split(":");
      String var6 = "";
      if (this.nomEtat.contains("salaries")) {
         var6 = "SAL";
      } else if (this.nomEtat.contains("rh")) {
         var6 = "RH";
      } else if (this.nomEtat.contains("contrats")) {
         var6 = "CRT";
      } else if (this.nomEtat.contains("bulletins")) {
         var6 = "BUL";
      }

      String var7 = "EXPORT_COLONNES_" + var6 + "_" + var4[0] + "_" + var5[0] + "-" + var5[1] + "-" + var5[2] + ".TXT";
      String var8 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "export" + File.separator;
      this.verificationRepertoireOrigine(var8);
      this.cheminExportOrigine = var8 + var7;
      var2 = new File(this.cheminExportOrigine);
      if (var2.exists()) {
         var2.delete();
         var2 = new File(this.cheminExportOrigine);
      }

      this.verificationRepertoireDestination(this.optionPaye.getDossierExport(), var7);
      String var9 = "";
      if (this.cheminExportOrigine != null && !this.cheminExportOrigine.isEmpty()) {
         var9 = "00000";
         if (this.lesColonnesChoisies.size() != 0) {
            new ObjetConvention();
            PrintWriter var11 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(var2), "UTF-8"));

            for(int var12 = 0; var12 < this.lesColonnesChoisies.size(); ++var12) {
               ObjetConvention var10 = (ObjetConvention)this.lesColonnesChoisies.get(var12);
               var11.print(var10.getLib_FR() + "\r\n");
            }

            var11.close();
         }

         if (this.lesColonnesChoisies.size() != 0 && var7 != null && !var7.isEmpty()) {
            this.nomFichier = var7;
            UtilDownload var13 = new UtilDownload();
            String var14 = var1 + "epegase" + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "export" + File.separator + var7;
            this.fichierUrl = var13.convertirFichierUtl(var14, var1);
            this.fichierMine = var13.calculeTypeMine(this.nomFichier);
            var9 = var9 + ":" + var7;
            this.afficheFichierExport = true;
         } else {
            var9 = null;
         }
      }

      return var9;
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

   public DataModel getDatamodelSalaries() {
      return this.datamodelSalaries;
   }

   public void setDatamodelSalaries(DataModel var1) {
      this.datamodelSalaries = var1;
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

   public String getImpDestinataire() {
      return this.impDestinataire;
   }

   public void setImpDestinataire(String var1) {
      this.impDestinataire = var1;
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

   public String getImpEmetteur() {
      return this.impEmetteur;
   }

   public void setImpEmetteur(String var1) {
      this.impEmetteur = var1;
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

   public OptionPaye getOptionPaye() {
      return this.optionPaye;
   }

   public void setOptionPaye(OptionPaye var1) {
      this.optionPaye = var1;
   }

   public UtilInitHibernate getUtilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setUtilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
   }

   public boolean isShowModalPanelSalaries() {
      return this.showModalPanelSalaries;
   }

   public void setShowModalPanelSalaries(boolean var1) {
      this.showModalPanelSalaries = var1;
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

   public boolean isAffMail() {
      return this.affMail;
   }

   public void setAffMail(boolean var1) {
      this.affMail = var1;
   }

   public ExercicesPaye getExoSelectionne() {
      return this.exoSelectionne;
   }

   public void setExoSelectionne(ExercicesPaye var1) {
      this.exoSelectionne = var1;
   }

   public UtilPrint getUtilPrint() {
      return this.utilPrint;
   }

   public void setUtilPrint(UtilPrint var1) {
      this.utilPrint = var1;
   }

   public boolean isTestafficheDocument() {
      return this.testafficheDocument;
   }

   public void setTestafficheDocument(boolean var1) {
      this.testafficheDocument = var1;
   }

   public String getMatricule() {
      return this.matricule;
   }

   public void setMatricule(String var1) {
      this.matricule = var1;
   }

   public String getNomSalarie() {
      return this.nomSalarie;
   }

   public void setNomSalarie(String var1) {
      this.nomSalarie = var1;
   }

   public boolean isVar_anal_activite() {
      return this.var_anal_activite;
   }

   public void setVar_anal_activite(boolean var1) {
      this.var_anal_activite = var1;
   }

   public List getMesActiviteItems() {
      return this.mesActiviteItems;
   }

   public void setMesActiviteItems(List var1) {
      this.mesActiviteItems = var1;
   }

   public List getMesBudgetItems() {
      return this.mesBudgetItems;
   }

   public void setMesBudgetItems(List var1) {
      this.mesBudgetItems = var1;
   }

   public List getMesCentresImpotsItems() {
      return this.mesCentresImpotsItems;
   }

   public void setMesCentresImpotsItems(List var1) {
      this.mesCentresImpotsItems = var1;
   }

   public List getMesClassementsItems() {
      return this.mesClassementsItems;
   }

   public void setMesClassementsItems(List var1) {
      this.mesClassementsItems = var1;
   }

   public List getMesClesItems() {
      return this.mesClesItems;
   }

   public void setMesClesItems(List var1) {
      this.mesClesItems = var1;
   }

   public List getMesConventionsItems() {
      return this.mesConventionsItems;
   }

   public void setMesConventionsItems(List var1) {
      this.mesConventionsItems = var1;
   }

   public List getMesDepartementsItems() {
      return this.mesDepartementsItems;
   }

   public void setMesDepartementsItems(List var1) {
      this.mesDepartementsItems = var1;
   }

   public List getMesFeuillesItems() {
      return this.mesFeuillesItems;
   }

   public void setMesFeuillesItems(List var1) {
      this.mesFeuillesItems = var1;
   }

   public List getMesGrillesItems() {
      return this.mesGrillesItems;
   }

   public void setMesGrillesItems(List var1) {
      this.mesGrillesItems = var1;
   }

   public List getMesLanguesItems() {
      return this.mesLanguesItems;
   }

   public void setMesLanguesItems(List var1) {
      this.mesLanguesItems = var1;
   }

   public List getMesNationnalitesItems() {
      return this.mesNationnalitesItems;
   }

   public void setMesNationnalitesItems(List var1) {
      this.mesNationnalitesItems = var1;
   }

   public List getMesNatureAgentItems() {
      return this.mesNatureAgentItems;
   }

   public void setMesNatureAgentItems(List var1) {
      this.mesNatureAgentItems = var1;
   }

   public List getMesNiveauxEmploisItems() {
      return this.mesNiveauxEmploisItems;
   }

   public void setMesNiveauxEmploisItems(List var1) {
      this.mesNiveauxEmploisItems = var1;
   }

   public List getMesParcItems() {
      return this.mesParcItems;
   }

   public void setMesParcItems(List var1) {
      this.mesParcItems = var1;
   }

   public List getMesPaysItems() {
      return this.mesPaysItems;
   }

   public void setMesPaysItems(List var1) {
      this.mesPaysItems = var1;
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

   public List getMesSitesItems() {
      return this.mesSitesItems;
   }

   public void setMesSitesItems(List var1) {
      this.mesSitesItems = var1;
   }

   public String getActivite() {
      return this.activite;
   }

   public void setActivite(String var1) {
      this.activite = var1;
   }

   public boolean isVar_anal_agent() {
      return this.var_anal_agent;
   }

   public void setVar_anal_agent(boolean var1) {
      this.var_anal_agent = var1;
   }

   public boolean isVar_anal_departement() {
      return this.var_anal_departement;
   }

   public void setVar_anal_departement(boolean var1) {
      this.var_anal_departement = var1;
   }

   public boolean isVar_anal_parc() {
      return this.var_anal_parc;
   }

   public void setVar_anal_parc(boolean var1) {
      this.var_anal_parc = var1;
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

   public String getCentre() {
      return this.centre;
   }

   public void setCentre(String var1) {
      this.centre = var1;
   }

   public String getClassement() {
      return this.classement;
   }

   public void setClassement(String var1) {
      this.classement = var1;
   }

   public String getConvention() {
      return this.convention;
   }

   public void setConvention(String var1) {
      this.convention = var1;
   }

   public String getDepartement() {
      return this.departement;
   }

   public void setDepartement(String var1) {
      this.departement = var1;
   }

   public String getFeuille() {
      return this.feuille;
   }

   public void setFeuille(String var1) {
      this.feuille = var1;
   }

   public String getGrille() {
      return this.grille;
   }

   public void setGrille(String var1) {
      this.grille = var1;
   }

   public String getNatureSalarie() {
      return this.natureSalarie;
   }

   public void setNatureSalarie(String var1) {
      this.natureSalarie = var1;
   }

   public String getNiveauEmploi() {
      return this.niveauEmploi;
   }

   public void setNiveauEmploi(String var1) {
      this.niveauEmploi = var1;
   }

   public String getParc() {
      return this.parc;
   }

   public void setParc(String var1) {
      this.parc = var1;
   }

   public String getPays() {
      return this.pays;
   }

   public void setPays(String var1) {
      this.pays = var1;
   }

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
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

   public String getBudget() {
      return this.budget;
   }

   public void setBudget(String var1) {
      this.budget = var1;
   }

   public List getMesRubriquesItems() {
      return this.mesRubriquesItems;
   }

   public void setMesRubriquesItems(List var1) {
      this.mesRubriquesItems = var1;
   }

   public String getRubrique() {
      return this.rubrique;
   }

   public void setRubrique(String var1) {
      this.rubrique = var1;
   }

   public List getMesNatureRubriqueItems() {
      return this.mesNatureRubriqueItems;
   }

   public void setMesNatureRubriqueItems(List var1) {
      this.mesNatureRubriqueItems = var1;
   }

   public String getNatureRubrique() {
      return this.natureRubrique;
   }

   public void setNatureRubrique(String var1) {
      this.natureRubrique = var1;
   }

   public String[] getListeBanque() {
      return this.listeBanque;
   }

   public void setListeBanque(String[] var1) {
      this.listeBanque = var1;
   }

   public List getMesBanqueItems() {
      return this.mesBanqueItems;
   }

   public void setMesBanqueItems(List var1) {
      this.mesBanqueItems = var1;
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

   public List getMesProjetItems() {
      return this.mesProjetItems;
   }

   public void setMesProjetItems(List var1) {
      this.mesProjetItems = var1;
   }

   public boolean isShowModalPanelBordereau() {
      return this.showModalPanelBordereau;
   }

   public void setShowModalPanelBordereau(boolean var1) {
      this.showModalPanelBordereau = var1;
   }

   public String getUrlExplorateur() {
      return this.urlExplorateur;
   }

   public void setUrlExplorateur(String var1) {
      this.urlExplorateur = var1;
   }

   public boolean isTestafficheExport() {
      return this.testafficheExport;
   }

   public void setTestafficheExport(boolean var1) {
      this.testafficheExport = var1;
   }

   public boolean isAfficheFichierExport() {
      return this.afficheFichierExport;
   }

   public void setAfficheFichierExport(boolean var1) {
      this.afficheFichierExport = var1;
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

   public String getNomFichier() {
      return this.nomFichier;
   }

   public void setNomFichier(String var1) {
      this.nomFichier = var1;
   }

   public List getMesBanqueAgentsItems() {
      return this.mesBanqueAgentsItems;
   }

   public void setMesBanqueAgentsItems(List var1) {
      this.mesBanqueAgentsItems = var1;
   }

   public String getBanqueSociete() {
      return this.banqueSociete;
   }

   public void setBanqueSociete(String var1) {
      this.banqueSociete = var1;
   }

   public String getProjet() {
      return this.projet;
   }

   public void setProjet(String var1) {
      this.projet = var1;
   }

   public int getSelectionMode() {
      return this.selectionMode;
   }

   public void setSelectionMode(int var1) {
      this.selectionMode = var1;
   }

   public String getLocalisation() {
      return this.localisation;
   }

   public void setLocalisation(String var1) {
      this.localisation = var1;
   }

   public List getMesLocalisationItems() {
      return this.mesLocalisationItems;
   }

   public void setMesLocalisationItems(List var1) {
      this.mesLocalisationItems = var1;
   }

   public int getEtatSalarie() {
      return this.etatSalarie;
   }

   public void setEtatSalarie(int var1) {
      this.etatSalarie = var1;
   }

   public List getLesModelesAutorises() {
      return this.lesModelesAutorises;
   }

   public void setLesModelesAutorises(List var1) {
      this.lesModelesAutorises = var1;
   }

   public long getTiers() {
      return this.tiers;
   }

   public void setTiers(long var1) {
      this.tiers = var1;
   }

   public boolean isInterim() {
      return this.interim;
   }

   public void setInterim(boolean var1) {
      this.interim = var1;
   }

   public String[] getListeClients() {
      return this.listeClients;
   }

   public void setListeClients(String[] var1) {
      this.listeClients = var1;
   }

   public DataModel getDatamodelColonnes() {
      return this.datamodelColonnes;
   }

   public void setDatamodelColonnes(DataModel var1) {
      this.datamodelColonnes = var1;
   }

   public boolean isTestafficheDocumentUser() {
      return this.testafficheDocumentUser;
   }

   public void setTestafficheDocumentUser(boolean var1) {
      this.testafficheDocumentUser = var1;
   }

   public String getSecurite() {
      return this.securite;
   }

   public void setSecurite(String var1) {
      this.securite = var1;
   }

   public List getMesCentresSecuritesItems() {
      return this.mesCentresSecuritesItems;
   }

   public void setMesCentresSecuritesItems(List var1) {
      this.mesCentresSecuritesItems = var1;
   }

   public String getLot() {
      return this.lot;
   }

   public void setLot(String var1) {
      this.lot = var1;
   }

   public String getNationnalite() {
      return this.nationnalite;
   }

   public void setNationnalite(String var1) {
      this.nationnalite = var1;
   }

   public String[] getListeActivite() {
      return this.listeActivite;
   }

   public void setListeActivite(String[] var1) {
      this.listeActivite = var1;
   }

   public String[] getListeService() {
      return this.listeService;
   }

   public void setListeService(String[] var1) {
      this.listeService = var1;
   }

   public List getMesMisisonsItems() {
      return this.mesMisisonsItems;
   }

   public void setMesMisisonsItems(List var1) {
      this.mesMisisonsItems = var1;
   }

   public List getMesSalarieItems() {
      return this.mesSalarieItems;
   }

   public void setMesSalarieItems(List var1) {
      this.mesSalarieItems = var1;
   }

   public List getMesTachesItems() {
      return this.mesTachesItems;
   }

   public void setMesTachesItems(List var1) {
      this.mesTachesItems = var1;
   }

   public List getMesTiersItems() {
      return this.mesTiersItems;
   }

   public void setMesTiersItems(List var1) {
      this.mesTiersItems = var1;
   }

   public String getMissionRec() {
      return this.missionRec;
   }

   public void setMissionRec(String var1) {
      this.missionRec = var1;
   }

   public long getSalarieRec() {
      return this.salarieRec;
   }

   public void setSalarieRec(long var1) {
      this.salarieRec = var1;
   }

   public String getTacheRec() {
      return this.tacheRec;
   }

   public void setTacheRec(String var1) {
      this.tacheRec = var1;
   }

   public long getIdTiersRec() {
      return this.idTiersRec;
   }

   public void setIdTiersRec(long var1) {
      this.idTiersRec = var1;
   }

   public int getModeExportation() {
      return this.modeExportation;
   }

   public void setModeExportation(int var1) {
      this.modeExportation = var1;
   }
}
