package com.epegase.forms.stock;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Activites;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.DepotAchats;
import com.epegase.systeme.classe.Equipes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.FabricationEnteteAchats;
import com.epegase.systeme.classe.FabricationLigneAchats;
import com.epegase.systeme.classe.FamillesProduitsAchats;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.InventaireLigne;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.ProcessEnteteAchats;
import com.epegase.systeme.classe.ProcessLigneAchats;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ReceptionAvicultureAchats;
import com.epegase.systeme.classe.ReceptionEnteteAchats;
import com.epegase.systeme.classe.ReceptionLigneAchats;
import com.epegase.systeme.classe.ReceptionLotAchats;
import com.epegase.systeme.classe.ReceptionSerieAchats;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Taches;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.classe.UsersFavoris;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.EtatDocument;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.CommandeLigneVentesDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.EquipesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FabricationEnteteAchatsDao;
import com.epegase.systeme.dao.FabricationLigneAchatsDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.ProcessEnteteAchatsDao;
import com.epegase.systeme.dao.ProcessLigneAchatsDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsMclesDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ReceptionAvicultureAchatsDao;
import com.epegase.systeme.dao.ReceptionEnteteAchatsDao;
import com.epegase.systeme.dao.ReceptionLigneAchatsDao;
import com.epegase.systeme.dao.ReceptionLotAchatsDao;
import com.epegase.systeme.dao.ReceptionSerieAchatsDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.TachesDao;
import com.epegase.systeme.dao.UniteDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.dao.UsersFavorisDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.CalculStock;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilParapheur;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionAchats;
import com.epegase.systeme.xml.OptionStocks;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;
import org.xml.sax.SAXException;

public class FormProduction implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
   private String urlphotoProd;
   private List mesOnglets;
   private OptionAchats optionAchats;
   private OptionStocks optionStocks;
   private ExercicesAchats exercicesAchats;
   private ExercicesAchats lastExoAchats;
   private EspionDao espionDao;
   private CalculChrono calculChrono;
   private UtilNombre utilNombre = new UtilNombre();
   private int var_nb_max = 100;
   private int modeReception;
   private String libelleModeReception;
   private Date var_date;
   private String var_heure;
   private String var_minute;
   private String var_seconde;
   private boolean visibleOnglet = false;
   private boolean var_sansstock = false;
   private boolean var_aff_detail_prod = false;
   private boolean existParapheur = false;
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private UserDao usersDao;
   private long var_nom_equipe;
   private Equipes equipes;
   private EquipesDao equipesDao;
   private List mesEquipeItem = new ArrayList();
   private List lesEquipes = new ArrayList();
   private FabricationEnteteAchats fabricationEnteteAchats = new FabricationEnteteAchats();
   private FabricationEnteteAchatsDao fabricationEnteteAchatsDao;
   private List lesEntetesList = new ArrayList();
   private boolean verrouNum = false;
   private transient DataModel datamodelEntete = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean visibiliteBton = false;
   private boolean visibiliteBtonlig = true;
   private boolean visibleOngleEntete;
   private boolean var_aff_action = false;
   private boolean var_valide_doc = false;
   private boolean var_affiche_filtre = false;
   private double montantPump = 0.0D;
   private int var_nb_ligne = 0;
   private UtilDate utilDate = new UtilDate();
   private boolean showModalPanelImput = false;
   private String var_imput_serie;
   private DepotAchats depotAchatsProduction = new DepotAchats();
   private String var_process;
   private List lesDatesItems = new ArrayList();
   private FabricationLigneAchats fabricationLigneAchatsGeneres = new FabricationLigneAchats();
   private FabricationLigneAchats fabricationLigneAchatsIntrants = new FabricationLigneAchats();
   private FabricationLigneAchats fabricationLigneAchatsSousProduits = new FabricationLigneAchats();
   private FabricationLigneAchats fabricationLigneAchatsDechets = new FabricationLigneAchats();
   private FabricationLigneAchats fabricationLigneAchatsTaches = new FabricationLigneAchats();
   private FabricationLigneAchatsDao fabricationLigneAchatsDao;
   private transient DataModel datamodelGeneres = new ListDataModel();
   private transient DataModel datamodelIntrants = new ListDataModel();
   private transient DataModel datamodelSousProduits = new ListDataModel();
   private transient DataModel datamodelDechets = new ListDataModel();
   private transient DataModel datamodelTaches = new ListDataModel();
   private List lesLignesGeneres = new ArrayList();
   private List lesLignesIntrants = new ArrayList();
   private List lesLignesSousProduits = new ArrayList();
   private List lesLignesDechets = new ArrayList();
   private List lesLignesTaches = new ArrayList();
   private double totauxPump = 0.0D;
   private boolean griserchamps = false;
   private int ajoutLigne;
   private ServiceDao serviceDao;
   private Produits produits;
   private ProduitsAchsDao produitsDao;
   private ProduitsDepot produitsDepot = new ProduitsDepot();
   private ProduitsDepotDao produitsDepotDao;
   private FamillesProduitsAchatsDao famillesProduitsAchatsDao;
   private FamillesProduitsAchats famillesProduitsAchats;
   private ProduitsServicesDao produitsServicesDao;
   private ProduitsMclesDao produitsMclesDao;
   private String var_depot_production;
   private long var_nom_responsable;
   private CalculStock calculStock = new CalculStock();
   private int typeProduits;
   private String nomOnglet = "tabDoc";
   private List mesProduitInterchangeablesItems = new ArrayList();
   private String var_produit_interchangeable;
   private List mesDepotsProduitsItems = new ArrayList();
   private Taches taches;
   private TachesDao tachesDao;
   private boolean showModalPanelDetailTache = false;
   private int validationLigne;
   private String messageStockNegatif;
   private List mesConditionnementsProduits = new ArrayList();
   private List mesUnitesItems;
   private List mesUnitesProduits = new ArrayList();
   private boolean var_aff_condit = false;
   private boolean var_aff_unite = false;
   private int var_code_unite;
   private Unite unite = new Unite();
   private UniteDao uniteDao;
   private List mesProcessItems = new ArrayList();
   private List mesDepotAchItems = new ArrayList();
   private String inpService = "100";
   private String inpSerie = "100";
   private String inpSite = "100";
   private String inpLigne = "100";
   private String inpAtelier = "100";
   private int inpEtat = 0;
   private String periode;
   private String inpNum = "";
   private String inpResponsable = "";
   private String inpActivite = "100";
   private String inpProcess = "100";
   private String inpParc = "100";
   private String inpDossier = "100";
   private String inpDepot = "100";
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean var_more_search = false;
   private DepotAchatsDao depotAchatsDao;
   private ProcessEnteteAchats processEnteteAchats;
   private ProcessEnteteAchatsDao processEnteteAchatsDao;
   private ProcessLigneAchats processLigneAchats;
   private ProcessLigneAchatsDao processLigneAchatsDao;
   private List mesAteliersItems;
   private boolean var_methode;
   private boolean var_piege;
   private boolean var_commande;
   private CommandeEnteteVentesDao commandeEnteteVentesDao;
   private CommandeLigneVentesDao commandeLigneVentesDao;
   private transient DataModel datamodelLigneCommande = new ListDataModel();
   private List lesLignesCommandes = new ArrayList();
   private ReceptionAvicultureAchats receptionAvicultureAchats;
   private ReceptionEnteteAchats receptionEnteteAchats;
   private ReceptionAvicultureAchatsDao receptionAvicultureAchatsDao;
   private List lesPlaningsAviculture;
   private List lesEntetesPouletList = new ArrayList();
   private ReceptionEnteteAchatsDao receptionEnteteAchatsDao;
   private boolean showModalPanelPlanning = false;
   private boolean verrouPump = false;
   private boolean affichagePump = false;
   private boolean accesProduits;
   private boolean var_acc_document = false;
   private boolean var_acc_imputation = false;
   private boolean var_acc_complement = false;
   private boolean var_acc_verification = false;
   private boolean var_acc_habilitation = false;
   private boolean var_acc_etat = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private boolean var_verrou_comm = false;
   private Habilitation habilitation;
   private UtilParapheur utilParapheur;
   private UtilTdt utilTdt = new UtilTdt();
   private boolean showModalPanelPrint = false;
   private String montant_lettre;
   private PlansAnalytiques plansAnalytiques = new PlansAnalytiques();
   private String code_planAnalytique;
   private PlansAnalytiquesDao plansAnalytiquesDao;
   private boolean var_anal_activite = false;
   private int var_anal_dossier;
   private boolean var_anal_parc = false;
   private boolean var_anal_chantier = false;
   private boolean decoupageActivite = false;
   private List laColonne1Items;
   private List laColonne2Items;
   private List laColonne3Items;
   private EcrituresAnalytiqueCtrl ecrituresAnalytiqueCtrl;
   private List lesDecoupagesActivites = new ArrayList();
   private transient DataModel dataModelDecoupageActivtes = new ListDataModel();
   private String var_colonne1;
   private String var_colonne2;
   private String var_colonne3;
   private double totalImputation;
   private double soldeImputation;
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
   private int nbIndividusAnte;
   private int nbIndividusReste;
   private String dateJour;
   private boolean var_depot_famille;
   private ReceptionLotAchats receptionLotAchats;
   private ReceptionLotAchatsDao receptionLotAchatsDao;
   private ReceptionSerieAchats receptionSerieAchats;
   private ReceptionSerieAchatsDao receptionSerieAchatsDao;
   private List lesNumSerie = new ArrayList();
   private List mesLotsItems = new ArrayList();
   private List mesLotsEnteteItems = new ArrayList();
   private UsersFavoris usersFavoris;
   private UsersFavorisDao usersFavorisDao;
   private String verrouDepotUser;
   private String depotDechet;
   private Activites activites;
   private String code_activite;

   public FormProduction() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.fabricationEnteteAchatsDao = new FabricationEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.fabricationLigneAchatsDao = new FabricationLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.equipesDao = new EquipesDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsAchatsDao = new FamillesProduitsAchatsDao(this.baseLog, this.utilInitHibernate);
      this.produitsMclesDao = new ProduitsMclesDao(this.baseLog, this.utilInitHibernate);
      this.produitsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      this.produitsServicesDao = new ProduitsServicesDao(this.baseLog, this.utilInitHibernate);
      this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      this.uniteDao = new UniteDao(this.baseLog, this.utilInitHibernate);
      this.depotAchatsDao = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
      this.tachesDao = new TachesDao(this.baseLog, this.utilInitHibernate);
      this.processEnteteAchatsDao = new ProcessEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.processLigneAchatsDao = new ProcessLigneAchatsDao(this.baseLog, this.utilInitHibernate);
      this.commandeLigneVentesDao = new CommandeLigneVentesDao(this.baseLog, this.utilInitHibernate);
      this.commandeEnteteVentesDao = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.receptionEnteteAchatsDao = new ReceptionEnteteAchatsDao(this.baseLog, this.utilInitHibernate);
      this.receptionAvicultureAchatsDao = new ReceptionAvicultureAchatsDao(this.baseLog, this.utilInitHibernate);
      this.receptionLotAchatsDao = new ReceptionLotAchatsDao(this.baseLog, this.utilInitHibernate);
      this.receptionSerieAchatsDao = new ReceptionSerieAchatsDao(this.baseLog, this.utilInitHibernate);
      this.usersFavorisDao = new UsersFavorisDao(this.baseLog, this.utilInitHibernate);
      this.plansAnalytiquesDao = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
   }

   public void configAchats(Session var1) throws HibernateException, NamingException, IOException {
      if (!this.structureLog.getStrtypeentreprise().contentEquals("1") && !this.structureLog.getStrtypeentreprise().contentEquals("3")) {
         this.var_sansstock = true;
      } else {
         this.var_sansstock = false;
      }

      if (!this.optionStocks.getLib1().isEmpty() && !this.optionStocks.getLib2().isEmpty() && !this.optionStocks.getLib3().isEmpty() && !this.optionStocks.getLib4().isEmpty() && !this.optionStocks.getLib5().isEmpty() && !this.optionStocks.getLib6().isEmpty() && !this.optionStocks.getLib7().isEmpty() && !this.optionStocks.getLib8().isEmpty() && !this.optionStocks.getLib9().isEmpty() && !this.optionStocks.getLib10().isEmpty()) {
         this.visibleOngleEntete = false;
      } else {
         this.visibleOngleEntete = true;
      }

      if (this.optionStocks.getNbLigneMax() != null && !this.optionStocks.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionStocks.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.structureLog.isStrActivite()) {
         this.var_anal_activite = true;
      }

      this.var_anal_dossier = this.structureLog.getStrDossier();
      if (this.structureLog.isStrParc()) {
         this.var_anal_parc = true;
      }

      if (this.optionAchats.getAxeChantier().equals("true")) {
         this.var_anal_chantier = true;
      } else {
         this.var_anal_chantier = false;
      }

      this.periode = this.optionStocks.getAffichInGlobViewCES();
      if (this.habilitation != null) {
         this.existParapheur = true;
      } else {
         this.existParapheur = false;
      }

      this.initPage();
      this.utilParapheur = new UtilParapheur(this.utilInitHibernate, this.structureLog, this.baseLog, this.usersLog);
      if (this.rechercheModule(60010)) {
         this.modeReception = 1;
         this.libelleModeReception = "(PAPETERIE)";
         this.inpEtat = 0;
      } else if (this.rechercheModule(60020)) {
         this.modeReception = 2;
         this.libelleModeReception = "(AVICULTURE)";
         this.inpEtat = 1;
         this.receptionAvicultureAchatsDao = new ReceptionAvicultureAchatsDao(this.baseLog, this.utilInitHibernate);
         this.lesPlaningsAviculture = new ArrayList();
      } else {
         this.modeReception = 0;
         this.libelleModeReception = "";
         this.inpEtat = 0;
      }

      this.depotDechet = this.depotAchatsDao.trouveDepotDechet(var1);
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
            break;
         }
      }

      return var2;
   }

   public void accesResteintUser() {
      if (this.usersLog.getUsrAchPump() == 0) {
         this.affichagePump = false;
      } else {
         this.affichagePump = true;
         if (this.usersLog.getUsrAchPump() == 2) {
            this.verrouPump = true;
         } else {
            this.verrouPump = false;
         }
      }

      if (this.usersLog.getUsrProdServiceAch() == 0) {
         this.accesProduits = false;
      } else {
         this.accesProduits = true;
      }

      this.visibiliteBton = false;
      if (this.usersLog.getUsrCommAchats() == 2) {
         this.var_verrou_comm = false;
      } else if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty() && this.usersLog.getUsrProdServiceAch() == 1) {
         this.var_verrou_comm = false;
      } else {
         this.var_verrou_comm = true;
      }

   }

   public void accesResteintGroupe() {
      this.var_acc_document = false;
      this.var_acc_imputation = false;
      this.var_acc_complement = false;
      this.var_acc_verification = false;
      this.var_acc_habilitation = false;
      this.var_acc_etat = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("51")) {
               this.var_acc_document = true;
            } else if (var1.getCode().equals("52")) {
               this.var_acc_imputation = true;
            } else if (var1.getCode().equals("53")) {
               this.var_acc_complement = true;
            } else if (var1.getCode().equals("55")) {
               this.var_acc_verification = true;
            } else if (var1.getCode().equals("56")) {
               this.var_acc_habilitation = true;
            } else if (var1.getCode().equals("57")) {
               this.var_acc_etat = true;
            }
         }
      }

   }

   public void autorisationDocument() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("51")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationImputation() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("52")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationComplement() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("53")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationVerification() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("55")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationHabilitation() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("56")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationEtat() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("57")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void initPage() {
      this.var_action = 0;
      this.montantPump = 0.0D;
      this.inpSerie = "100";
      this.inpSite = "100";
      this.inpLigne = "100";
      this.inpAtelier = "100";
      this.inpDepot = "100";
      this.inpEtat = 0;
      this.lesEntetesList.clear();
      this.lesEntetesPouletList.clear();
      this.lesLignesIntrants.clear();
      this.lesLignesSousProduits.clear();
      this.lesLignesDechets.clear();
      this.lesLignesTaches.clear();
      this.lesDecoupagesActivites.clear();
      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
   }

   public void chargerEquipes(Session var1) throws HibernateException, NamingException {
      this.lesEquipes.clear();
      this.lesEquipes = this.equipesDao.selectEquipes(var1);
      this.mesEquipeItem.clear();
      if (this.lesEquipes.size() != 0) {
         this.mesEquipeItem.add(new SelectItem(0, ""));

         for(int var2 = 0; var2 < this.lesEquipes.size(); ++var2) {
            this.mesEquipeItem.add(new SelectItem(((Equipes)this.lesEquipes.get(var2)).getEquCode() + ":" + ((Equipes)this.lesEquipes.get(var2)).getEquNomFr()));
         }
      }

   }

   public void chargerlisteProcess() throws HibernateException, NamingException {
      this.chargerlisteProcess((Session)null);
   }

   public void chargerlisteProcess(Session var1) throws HibernateException, NamingException {
      this.mesProcessItems.clear();
      if (this.usersLog.getUsrAchats() == 1) {
         new ArrayList();
         List var2 = this.usersFavorisDao.selectUsersProcess(this.usersLog, var1);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               this.mesProcessItems.add(new SelectItem(((UsersFavoris)var2.get(var3)).getUsrfavLogin() + ":" + ((UsersFavoris)var2.get(var3)).getUsrfavNom()));
            }
         }
      } else if (this.inpService != null && !this.inpService.isEmpty() && !this.inpService.equals("100")) {
         this.mesProcessItems = this.processEnteteAchatsDao.chargerLesProcessByService(this.inpService, var1);
      } else if (this.inpService != null && !this.inpService.isEmpty() && this.inpService.equals("-100")) {
         this.mesProcessItems = this.processEnteteAchatsDao.chargerLesProcessSansService(var1);
      } else {
         this.mesProcessItems = this.processEnteteAchatsDao.chargerLesProcess(var1);
      }

   }

   public void chargerlisteDepot() throws HibernateException, NamingException {
      this.chargerlisteDepot((Session)null);
   }

   public void chargerlisteDepot(Session var1) throws HibernateException, NamingException {
      this.mesDepotAchItems.clear();
      if (this.inpService != null && !this.inpService.isEmpty() && !this.inpService.equals("100")) {
         this.mesDepotAchItems = this.depotAchatsDao.selectActifDepotByServiceItems(this.nature, this.inpService, var1);
      } else if (this.inpService != null && !this.inpService.isEmpty() && this.inpService.equals("-100")) {
         this.mesDepotAchItems = this.depotAchatsDao.selectActifDepotSansServiceItems(this.nature, var1);
      } else {
         this.mesDepotAchItems = this.depotAchatsDao.selectActifDepotCodeItems(this.nature, var1);
      }

   }

   public void moreSearch() throws ParseException {
      if (!this.var_more_search) {
         this.var_more_search = true;
         this.periode = "100";
         String var1 = (new Date()).getYear() + 1900 + "-01-01";
         this.inpDu = this.utilDate.stringToDateSQLLight(var1);
         String var2 = (new Date()).getYear() + 1900 + "-12-31";
         this.inpAu = this.utilDate.stringToDateSQLLight(var2);
      } else {
         this.var_more_search = false;
         this.inpDu = null;
         this.inpAu = null;
         this.inpResponsable = "";
         this.inpActivite = "100";
      }

   }

   public void executerRequete() throws IOException, HibernateException, NamingException, ParseException {
      this.chargeListeDetail((Session)null);
   }

   public void chargeListeDetail(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesEntetesList.clear();
      this.lesEntetesPouletList.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      double var2 = 0.0D;
      this.var_nb_ligne = 0;
      String var4 = "";
      String var5 = "";
      if (this.var_more_search) {
         if (this.inpDu != null) {
            var4 = this.utilDate.dateToStringSQLLight(this.inpDu);
         }

         if (this.inpAu != null) {
            var5 = this.utilDate.dateToStringSQLLight(this.inpAu);
         }
      } else {
         var4 = null;
         var5 = null;
      }

      ArrayList var6 = new ArrayList();
      int var8;
      if (this.inpDepot != null && !this.inpDepot.isEmpty()) {
         String[] var7;
         if (this.inpDepot.equals("100") && this.verrouDepotUser != null && !this.verrouDepotUser.isEmpty()) {
            var7 = this.verrouDepotUser.split(",");
            var8 = var7.length;

            for(int var9 = 0; var9 < var8; ++var9) {
               var6.add(var7[var9]);
            }
         } else if (this.inpDepot.contains(":")) {
            var7 = this.inpDepot.split(":");
            var6.add(var7[0]);
         } else {
            var6.clear();
         }
      } else {
         var6.clear();
      }

      if (this.inpEtat != 50) {
         if (this.modeReception == 2) {
            this.lesEntetesPouletList = this.receptionEnteteAchatsDao.recherche(var1, this.exercicesAchats.getExeachId(), (String)null, 0L, (String)null, this.inpEtat, this.inpSerie, "100", this.periode, (String)null, this.usersLog.getUsrid(), this.usersLog.getUsrAchats(), (String)null, (String)null, (String)null, (String)null, var4, var5);
         } else {
            this.lesEntetesList = this.fabricationEnteteAchatsDao.recherche(var1, this.exercicesAchats.getExeachId(), this.getInpNum(), var6, this.getInpEtat(), this.getInpSerie(), this.getPeriode(), this.getInpProcess(), this.getInpService(), this.usersLog.getUsrid(), this.usersLog.getUsrAchats(), "", this.getInpActivite(), var4, var5);
         }
      }

      this.datamodelEntete = new ListDataModel();
      if (this.lesEntetesList.size() > 0) {
         new FabricationEnteteAchats();

         for(var8 = 0; var8 < this.lesEntetesList.size(); ++var8) {
            FabricationEnteteAchats var10 = (FabricationEnteteAchats)this.lesEntetesList.get(var8);
            var2 += var10.getFabTotPump();
         }

         this.var_nb_ligne = this.lesEntetesList.size();
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      } else if (this.lesEntetesPouletList.size() > 0) {
         this.var_nb_ligne = this.lesEntetesPouletList.size();
         this.datamodelEntete.setWrappedData(this.lesEntetesPouletList);
      }

      this.totauxPump = var2;
      this.visibiliteBton = false;
   }

   public void selectionLigne() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.extDTable != null) {
         ArrayList var1 = new ArrayList();
         Iterator var2 = this.simpleSelectionEntete.getKeys();

         while(var2.hasNext()) {
            Object var3 = var2.next();
            this.extDTable.setRowKey(var3);
            if (this.extDTable.isRowAvailable()) {
               var1.add(this.extDTable.getRowData());
            }
         }

         if (var1.size() != 0) {
            this.var_aff_condit = false;
            this.code_activite = "";
            this.code_planAnalytique = "";
            this.fabricationEnteteAchats = (FabricationEnteteAchats)var1.get(0);
            if (this.fabricationEnteteAchats.getFabOption2() == 2) {
               this.var_process = "ACTIVITE";
               this.code_activite = this.fabricationEnteteAchats.getFabActivite();
               this.typeProduits = 1;
            } else if (this.fabricationEnteteAchats.getFabOption2() == 3) {
               this.var_process = "CHANTIER";
               this.code_planAnalytique = this.fabricationEnteteAchats.getFabActivite();
               this.typeProduits = 1;
            } else {
               this.var_process = this.fabricationEnteteAchats.getFabProcess() + ":" + this.fabricationEnteteAchats.getFabLibClient();
            }

            this.var_date = this.fabricationEnteteAchats.getFabDate();
            if (this.fabricationEnteteAchats.getFabDepot() != null && !this.fabricationEnteteAchats.getFabDepot().isEmpty()) {
               if (this.fabricationEnteteAchats.getFabDepot().contains(":")) {
                  String[] var4 = this.fabricationEnteteAchats.getFabDepot().split(":");
                  this.var_depot_production = var4[0];
               } else {
                  this.var_depot_production = this.fabricationEnteteAchats.getFabDepot();
               }
            }

            if (this.fabricationEnteteAchats.getFabCondition() != null && !this.fabricationEnteteAchats.getFabCondition().isEmpty()) {
               this.var_aff_condit = true;
            }

            if (this.fabricationEnteteAchats.getFabDate().getHours() <= 9) {
               this.var_heure = "0" + this.fabricationEnteteAchats.getFabDate().getHours();
            } else {
               this.var_heure = "" + this.fabricationEnteteAchats.getFabDate().getHours();
            }

            if (this.fabricationEnteteAchats.getFabDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.fabricationEnteteAchats.getFabDate().getMinutes();
            } else {
               this.var_minute = "" + this.fabricationEnteteAchats.getFabDate().getMinutes();
            }

            if (this.fabricationEnteteAchats.getFabDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.fabricationEnteteAchats.getFabDate().getSeconds();
            } else {
               this.var_seconde = "" + this.fabricationEnteteAchats.getFabDate().getSeconds();
            }

            this.var_methode = false;
            this.var_piege = false;
            this.var_commande = false;
            Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
            if (this.fabricationEnteteAchats.getFabProcess() != null && !this.fabricationEnteteAchats.getFabProcess().isEmpty()) {
               if (this.fabricationEnteteAchats.getFabProcess().equals("PAPIER")) {
                  this.processEnteteAchats = new ProcessEnteteAchats();
                  this.processEnteteAchats.setProcesCode("PAPIER");
               } else if (this.fabricationEnteteAchats.getFabProcess().equals("ACTIVITE")) {
                  this.processEnteteAchats = new ProcessEnteteAchats();
                  this.processEnteteAchats.setProcesCode("ACTIVITE");
               } else if (this.fabricationEnteteAchats.getFabProcess().equals("CHANTIER")) {
                  this.processEnteteAchats = new ProcessEnteteAchats();
                  this.processEnteteAchats.setProcesCode("CHANTIER");
               } else {
                  this.processEnteteAchats = this.processEnteteAchatsDao.rechercheProcess(this.fabricationEnteteAchats.getFabProcess(), var5);
                  if (this.processEnteteAchats.getProcesMethode() != null && !this.processEnteteAchats.getProcesMethode().isEmpty()) {
                     this.var_methode = true;
                  }

                  if (this.processEnteteAchats.getProcesPiege() != null && !this.processEnteteAchats.getProcesPiege().isEmpty()) {
                     this.var_piege = true;
                  }

                  if (this.processEnteteAchats.getProcesCondition() != null && !this.processEnteteAchats.getProcesCondition().isEmpty()) {
                     this.var_aff_condit = true;
                  }
               }
            } else {
               this.processEnteteAchats = null;
            }

            this.produits = this.produitsDao.chargeToutProduit(this.fabricationEnteteAchats.getFabProcess(), var5);
            if (this.produits != null) {
               this.mesUnitesProduits = this.chargerUniteProduit(var5);
               this.mesConditionnementsProduits = this.chargerConditionnementProduit(var5);
            } else {
               this.produits = new Produits();
            }

            this.chargerDocumentLigne(var5);
            this.chargerUserChrono(var5);
            if (this.decoupageActivite) {
               this.chargerDetailanalytique();
               this.controleEcartAnalytique();
            }

            this.utilInitHibernate.closeSession();
            this.montantPump = this.fabricationEnteteAchats.getFabTotPump();
            this.verrouNum = true;
            this.visibiliteBton = true;
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.fabricationEnteteAchats != null) {
         if (this.fabricationEnteteAchats.getFabEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.lesLignesIntrants.clear();
      this.lesLignesSousProduits.clear();
      this.lesLignesDechets.clear();
      this.lesLignesTaches.clear();
      this.lesLignesGeneres.clear();
      new ArrayList();
      if (this.fabricationEnteteAchats != null) {
         List var2 = this.fabricationLigneAchatsDao.chargerLesLignes(this.fabricationEnteteAchats, var1);
         boolean var3 = true;
         boolean var4 = true;
         boolean var5 = true;
         boolean var6 = true;
         boolean var7 = true;
         if (var2.size() != 0) {
            for(int var8 = 0; var8 < var2.size(); ++var8) {
               if (((FabricationLigneAchats)var2.get(var8)).getFabligType() == 1) {
                  this.lesLignesIntrants.add(var2.get(var8));
                  var3 = false;
               } else if (((FabricationLigneAchats)var2.get(var8)).getFabligType() == 2) {
                  this.lesLignesSousProduits.add(var2.get(var8));
                  var4 = false;
               } else if (((FabricationLigneAchats)var2.get(var8)).getFabligType() == 3) {
                  this.lesLignesDechets.add(var2.get(var8));
                  var5 = false;
               } else if (((FabricationLigneAchats)var2.get(var8)).getFabligType() == 4) {
                  this.lesLignesTaches.add(var2.get(var8));
                  var6 = false;
               } else if (((FabricationLigneAchats)var2.get(var8)).getFabligType() == 5) {
                  this.lesLignesGeneres.add(var2.get(var8));
                  var7 = false;
               }
            }
         }

         if (var3) {
            this.processEnteteAchats = this.processEnteteAchatsDao.rechercheProcess(this.fabricationEnteteAchats.getFabProcess(), var1);
            if (this.processEnteteAchats != null) {
               new ArrayList();
               List var11 = this.processLigneAchatsDao.chargerDetailProcess(this.processEnteteAchats, var1);
               if (var11.size() != 0) {
                  this.processLigneAchats = new ProcessLigneAchats();

                  for(int var9 = 0; var9 < var11.size(); ++var9) {
                     this.processLigneAchats = (ProcessLigneAchats)var11.get(var9);
                     if (this.processLigneAchats.getProcesligType() == 1) {
                        this.lesLignesIntrants.add(this.convertirProcessProduit(this.processLigneAchats, var1));
                     } else if (this.processLigneAchats.getProcesligType() == 2 && var4) {
                        this.lesLignesSousProduits.add(this.convertirProcessProduit(this.processLigneAchats, var1));
                     } else if (this.processLigneAchats.getProcesligType() == 3 && var5) {
                        this.lesLignesDechets.add(this.convertirProcessProduit(this.processLigneAchats, var1));
                     } else if (this.processLigneAchats.getProcesligType() == 4 && var6) {
                        this.lesLignesTaches.add(this.convertirProcessTache(this.processLigneAchats, var1));
                     } else if (this.processLigneAchats.getProcesligType() == 5 && var6) {
                        this.lesLignesGeneres.add(this.convertirProcessProduit(this.processLigneAchats, var1));
                     }
                  }
               }
            }
         }
      }

      this.datamodelIntrants.setWrappedData(this.lesLignesIntrants);
      this.datamodelSousProduits.setWrappedData(this.lesLignesSousProduits);
      this.datamodelDechets.setWrappedData(this.lesLignesDechets);
      this.datamodelTaches.setWrappedData(this.lesLignesTaches);
      this.datamodelGeneres.setWrappedData(this.lesLignesGeneres);
      this.addLigne();
      this.lesLignesCommandes.clear();
      if (this.fabricationEnteteAchats.getFabCommande() != null && !this.fabricationEnteteAchats.getFabCommande().isEmpty()) {
         new CommandeEnteteVentes();
         CommandeEnteteVentes var10 = this.commandeEnteteVentesDao.selectByNum(var1, this.fabricationEnteteAchats.getFabCommande());
         if (var10 != null) {
            this.var_commande = true;
            this.lesLignesCommandes = this.commandeLigneVentesDao.chargerLesLignes(var10, var1);
         }
      }

      this.datamodelLigneCommande.setWrappedData(this.lesLignesCommandes);
   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.fabricationEnteteAchats != null && this.fabricationEnteteAchats.getFabSerie() != null && !this.fabricationEnteteAchats.getFabSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.fabricationEnteteAchats.getFabSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.processEnteteAchats.getProcesActivite() != null && !this.processEnteteAchats.getProcesActivite().isEmpty() && this.processEnteteAchats.getProcesActivite().contains(":")) {
         String[] var1 = null;
         if (!this.processEnteteAchats.getProcesActivite().contains("#")) {
            var1 = this.processEnteteAchats.getProcesActivite().split(":");
            if (var1.length == 8) {
               this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
               this.ecrituresAnalytiqueCtrl.setEcranaActivite(var1[0]);
               this.ecrituresAnalytiqueCtrl.setEcranaActiviteLib(var1[1]);
               this.ecrituresAnalytiqueCtrl.setZoneActivite(this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib());
               this.ecrituresAnalytiqueCtrl.setEcranaAnal1(var1[2]);
               this.ecrituresAnalytiqueCtrl.setEcranaAnal1Lib(var1[3]);
               this.ecrituresAnalytiqueCtrl.setZoneAnal1(this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib());
               this.ecrituresAnalytiqueCtrl.setEcranaAnal3(var1[4]);
               this.ecrituresAnalytiqueCtrl.setEcranaAnal3Lib(var1[5]);
               this.ecrituresAnalytiqueCtrl.setZoneAnal3(this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib());
               this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(Float.parseFloat(var1[6]));
               this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(Double.parseDouble(var1[7]));
               this.totalImputation += this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
               this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
            }
         } else {
            String[] var2 = this.processEnteteAchats.getProcesActivite().split("#");

            for(int var3 = 0; var3 < var2.length; ++var3) {
               var1 = var2[var3].split(":");
               if (var1.length == 8) {
                  this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
                  this.ecrituresAnalytiqueCtrl.setEcranaActivite(var1[0]);
                  this.ecrituresAnalytiqueCtrl.setEcranaActiviteLib(var1[1]);
                  this.ecrituresAnalytiqueCtrl.setZoneActivite(this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib());
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal1(var1[2]);
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal1Lib(var1[3]);
                  this.ecrituresAnalytiqueCtrl.setZoneAnal1(this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib());
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal3(var1[4]);
                  this.ecrituresAnalytiqueCtrl.setEcranaAnal3Lib(var1[5]);
                  this.ecrituresAnalytiqueCtrl.setZoneAnal3(this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib());
                  this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(Float.parseFloat(var1[6]));
                  this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(Double.parseDouble(var1[7]));
                  this.totalImputation += this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                  this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
               }
            }
         }
      }

      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
   }

   public void selectionAnalytique() {
      if (this.dataModelDecoupageActivtes.isRowAvailable()) {
         this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.dataModelDecoupageActivtes.getRowData();
      }

   }

   public void valideColonne1() {
      if (this.ecrituresAnalytiqueCtrl.getZoneActivite() != null && !this.ecrituresAnalytiqueCtrl.getZoneActivite().isEmpty() && this.ecrituresAnalytiqueCtrl.getZoneActivite().contains(":")) {
         String[] var1 = this.ecrituresAnalytiqueCtrl.getZoneActivite().split(":");
         this.ecrituresAnalytiqueCtrl.setEcranaActivite(var1[0]);
         this.ecrituresAnalytiqueCtrl.setEcranaActiviteLib(var1[1]);
      }

   }

   public void valideColonne2() {
      if (this.ecrituresAnalytiqueCtrl.getZoneAnal1() != null && !this.ecrituresAnalytiqueCtrl.getZoneAnal1().isEmpty() && this.ecrituresAnalytiqueCtrl.getZoneAnal1().contains(":")) {
         String[] var1 = this.ecrituresAnalytiqueCtrl.getZoneAnal1().split(":");
         this.ecrituresAnalytiqueCtrl.setEcranaAnal1(var1[0]);
         this.ecrituresAnalytiqueCtrl.setEcranaAnal1Lib(var1[1]);
      }

   }

   public void valideColonne3() {
      if (this.ecrituresAnalytiqueCtrl.getZoneAnal3() != null && !this.ecrituresAnalytiqueCtrl.getZoneAnal3().isEmpty() && this.ecrituresAnalytiqueCtrl.getZoneAnal3().contains(":")) {
         String[] var1 = this.ecrituresAnalytiqueCtrl.getZoneAnal3().split(":");
         this.ecrituresAnalytiqueCtrl.setEcranaAnal3(var1[0]);
         this.ecrituresAnalytiqueCtrl.setEcranaAnal3Lib(var1[1]);
      }

   }

   public void calculPourcentage() {
      if (this.ecrituresAnalytiqueCtrl != null && this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() != 0.0F) {
         double var1 = this.utilNombre.myRoundDevise(this.processEnteteAchats.getProcesTotPump() * (double)this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() / 100.0D, this.structureLog.getStrdevise());
         this.ecrituresAnalytiqueCtrl.setEcranaMontantSaisie(var1);
      }

   }

   public void supprimerAnalytique() {
      if (this.ecrituresAnalytiqueCtrl == null) {
         this.selectionAnalytique();
      }

      if (this.ecrituresAnalytiqueCtrl != null) {
         this.lesDecoupagesActivites.remove(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
         this.ecrituresAnalytiqueCtrl = null;
      }

      if (this.lesDecoupagesActivites.size() == 0) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

   }

   public void controleEcartAnalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      float var1 = 0.0F;
      if (this.lesDecoupagesActivites.size() != 0) {
         for(int var2 = 0; var2 < this.lesDecoupagesActivites.size(); ++var2) {
            this.totalImputation += ((EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var2)).getEcranaMontantSaisie();
            var1 += ((EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var2)).getEcranaPourcentage();
         }
      }

      this.soldeImputation = this.processEnteteAchats.getProcesTotPump() - this.totalImputation;
      if (this.soldeImputation > 0.0D) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         if (var1 != 0.0F) {
            this.ecrituresAnalytiqueCtrl.setEcranaPourcentage(100.0F - var1);
         }

         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

   }

   public void typeOngletProduit() {
      this.typeProduits = 0;
      this.nomOnglet = "tabDoc";
   }

   public void typeOngletIntrant() {
      this.typeProduits = 1;
      this.nomOnglet = "tabIntrants";
   }

   public void typeOngletSousProduit() {
      this.typeProduits = 2;
      this.nomOnglet = "tabSousProd";
   }

   public void typeOngletDechet() {
      this.typeProduits = 3;
      this.nomOnglet = "tabDechet";
      if (this.lesLignesIntrants.size() != 0) {
         for(int var1 = 0; var1 < this.lesLignesIntrants.size(); ++var1) {
            this.fabricationLigneAchatsIntrants = (FabricationLigneAchats)this.lesLignesIntrants.get(var1);
            if (this.fabricationLigneAchatsIntrants.getFabligCode() != null && !this.fabricationLigneAchatsIntrants.getFabligCode().isEmpty()) {
               boolean var2 = false;
               if (this.lesLignesDechets.size() != 0) {
                  for(int var3 = 0; var3 < this.lesLignesDechets.size(); ++var3) {
                     if (((FabricationLigneAchats)this.lesLignesDechets.get(var3)).getFabligCode() != null && !((FabricationLigneAchats)this.lesLignesDechets.get(var3)).getFabligCode().isEmpty() && ((FabricationLigneAchats)this.lesLignesDechets.get(var3)).getFabligCode().equals(this.fabricationLigneAchatsIntrants.getFabligCode())) {
                        var2 = true;
                     }
                  }
               }

               if (!var2) {
                  this.fabricationLigneAchatsDechets = new FabricationLigneAchats();
                  this.fabricationLigneAchatsDechets.setFabligCasier(this.fabricationLigneAchatsIntrants.getFabligCasier());
                  this.fabricationLigneAchatsDechets.setFabligCode(this.fabricationLigneAchatsIntrants.getFabligCode());
                  this.fabricationLigneAchatsDechets.setFabligCondition(this.fabricationLigneAchatsIntrants.getFabligCondition());
                  this.fabricationLigneAchatsDechets.setFabligDepot(this.depotDechet);
                  this.fabricationLigneAchatsDechets.setFabligDescription(this.fabricationLigneAchatsIntrants.getFabligDescription());
                  this.fabricationLigneAchatsDechets.setFabligDiam(this.fabricationLigneAchatsIntrants.getFabligDiam());
                  this.fabricationLigneAchatsDechets.setFabligFamille(this.fabricationLigneAchatsIntrants.getFabligFamille());
                  this.fabricationLigneAchatsDechets.setFabligHaut(this.fabricationLigneAchatsIntrants.getFabligHaut());
                  this.fabricationLigneAchatsDechets.setFabligHh(this.fabricationLigneAchatsIntrants.getFabligHh());
                  this.fabricationLigneAchatsDechets.setFabligInterChange(this.fabricationLigneAchatsIntrants.isFabligInterChange());
                  this.fabricationLigneAchatsDechets.setFabligJj(this.fabricationLigneAchatsIntrants.getFabligJj());
                  this.fabricationLigneAchatsDechets.setFabligLarg(this.fabricationLigneAchatsIntrants.getFabligLarg());
                  this.fabricationLigneAchatsDechets.setFabligLibelle(this.fabricationLigneAchatsIntrants.getFabligLibelle());
                  this.fabricationLigneAchatsDechets.setFabligLong(this.fabricationLigneAchatsIntrants.getFabligLong());
                  this.fabricationLigneAchatsDechets.setFabligLot(this.fabricationLigneAchatsIntrants.getFabligLot());
                  this.fabricationLigneAchatsDechets.setFabligMateriel(this.fabricationLigneAchatsIntrants.getFabligMateriel());
                  this.fabricationLigneAchatsDechets.setFabligMetier(this.fabricationLigneAchatsIntrants.getFabligMetier());
                  this.fabricationLigneAchatsDechets.setFabligMm(this.fabricationLigneAchatsIntrants.getFabligMm());
                  this.fabricationLigneAchatsDechets.setFabligNb(this.fabricationLigneAchatsIntrants.getFabligNb());
                  this.fabricationLigneAchatsDechets.setFabligNumSerie(this.fabricationLigneAchatsIntrants.getFabligNumSerie());
                  this.fabricationLigneAchatsDechets.setFabligObs(this.fabricationLigneAchatsIntrants.getFabligObs());
                  this.fabricationLigneAchatsDechets.setFabligOrdre(this.fabricationLigneAchatsIntrants.getFabligOrdre());
                  this.fabricationLigneAchatsDechets.setFabligPoidsBrut(this.fabricationLigneAchatsIntrants.getFabligPoidsBrut());
                  this.fabricationLigneAchatsDechets.setFabligPoidsNet(this.fabricationLigneAchatsIntrants.getFabligPoidsNet());
                  this.fabricationLigneAchatsDechets.setFabligProduitInterchangeable(this.fabricationLigneAchatsIntrants.getFabligProduitInterchangeable());
                  this.fabricationLigneAchatsDechets.setFabligPump(this.fabricationLigneAchatsIntrants.getFabligPump());
                  this.fabricationLigneAchatsDechets.setFabligQte(0.0F);
                  this.fabricationLigneAchatsDechets.setFabligQteReference(this.fabricationLigneAchatsIntrants.getFabligQteReference());
                  this.fabricationLigneAchatsDechets.setFabligQteRestant(0.0F);
                  this.fabricationLigneAchatsDechets.setFabligQteStock(this.fabricationLigneAchatsIntrants.getFabligQteStock());
                  this.fabricationLigneAchatsDechets.setFabligQteUtil(0.0F);
                  this.fabricationLigneAchatsDechets.setFabligReference(this.fabricationLigneAchatsIntrants.getFabligReference());
                  this.fabricationLigneAchatsDechets.setFabligSs(this.fabricationLigneAchatsIntrants.getFabligSs());
                  this.fabricationLigneAchatsDechets.setFabligStock(this.fabricationLigneAchatsIntrants.getFabligStock());
                  this.fabricationLigneAchatsDechets.setFabligTotal(0.0D);
                  this.fabricationLigneAchatsDechets.setFabligType(this.fabricationLigneAchatsIntrants.getFabligType());
                  this.fabricationLigneAchatsDechets.setFabligUnite(this.fabricationLigneAchatsIntrants.getFabligUnite());
                  this.fabricationLigneAchatsDechets.setFabligVolume(this.fabricationLigneAchatsIntrants.getFabligVolume());
                  this.lesLignesDechets.add(this.fabricationLigneAchatsDechets);
               }
            }
         }

         this.datamodelDechets.setWrappedData(this.lesLignesDechets);
      }

      this.fabricationLigneAchatsDechets = new FabricationLigneAchats();
   }

   public void typeOngletTache() {
      this.typeProduits = 4;
      this.nomOnglet = "tabTache";
   }

   public void typeOngletEquipe() {
      this.typeProduits = 5;
      this.nomOnglet = "tabEquipe";
   }

   public void typeOngletImputation() {
      this.typeProduits = 6;
      this.nomOnglet = "tabImput";
   }

   public void typeOngletComplement() {
      this.typeProduits = 7;
      this.nomOnglet = "tabComplement";
   }

   public void typeOngletMethode() {
      this.typeProduits = 8;
      this.nomOnglet = "tabMethode";
   }

   public void typeOngletPiege() {
      this.typeProduits = 9;
      this.nomOnglet = "tabPiege";
   }

   public void typeOngletCommande() {
      this.typeProduits = 10;
      this.nomOnglet = "tabCommande";
   }

   public void selectionProcess() throws HibernateException, NamingException {
      this.var_valide_doc = false;
      this.var_aff_action = false;
      this.var_aff_condit = false;
      this.var_depot_production = "";
      this.depotAchatsProduction = null;
      this.lesLignesGeneres.clear();
      this.lesLignesIntrants.clear();
      this.lesLignesSousProduits.clear();
      this.lesLignesDechets.clear();
      this.lesLignesTaches.clear();
      this.mesLotsItems.clear();
      this.mesLotsEnteteItems.clear();
      this.mesConditionnementsProduits.clear();
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
      if (this.var_process != null && !this.var_process.isEmpty() && this.var_process.contains(":")) {
         String[] var2 = this.var_process.split(":");
         this.processEnteteAchats = this.processEnteteAchatsDao.rechercheProcess(var2[0], var1);
         if (this.processEnteteAchats != null) {
            this.var_depot_production = this.processEnteteAchats.getProcesDepot();
            if (this.var_depot_production != null && !this.var_depot_production.isEmpty()) {
               if (this.var_depot_production.contains(":")) {
                  String[] var3 = this.var_depot_production.split(":");
                  this.depotAchatsProduction = this.depotAchatsDao.trouveDepot(var3[0], var1);
               } else {
                  this.depotAchatsProduction = this.depotAchatsDao.trouveDepot(this.var_depot_production, var1);
               }
            } else {
               this.depotAchatsProduction = null;
            }

            this.var_valide_doc = true;
            this.fabricationEnteteAchats.setFabMode(this.processEnteteAchats.getProcesMode());
            this.fabricationEnteteAchats.setFabOption1(this.processEnteteAchats.getProcesOption1());
            this.fabricationEnteteAchats.setFabOption2(this.processEnteteAchats.getProcesOption2());
            this.fabricationEnteteAchats.setFabActivite(this.processEnteteAchats.getProcesActivite());
            this.fabricationEnteteAchats.setFabAtelier(this.processEnteteAchats.getProcesAtelier());
            this.fabricationEnteteAchats.setFabLigne(this.processEnteteAchats.getProcesLigne());
            this.fabricationEnteteAchats.setFabSite(this.processEnteteAchats.getProcesSite());
            this.fabricationEnteteAchats.setFabService(this.processEnteteAchats.getProcesService());
            this.fabricationEnteteAchats.setFabSuffixe(this.processEnteteAchats.getProcesSuffixe());
            if (this.fabricationEnteteAchats.getFabOption2() == 0) {
               this.produits = this.produitsDao.chargeToutProduit(this.processEnteteAchats.getProcesCode(), var1);
               if (this.produits != null) {
                  this.fabricationEnteteAchats.setFabProcess(this.produits.getProCode());
                  this.fabricationEnteteAchats.setFabLibClient(this.produits.getProLibClient());
                  this.fabricationEnteteAchats.setFabLibTech(this.produits.getProLibTech());
                  if (this.produits.getProAchCode() != null && !this.produits.getProAchCode().isEmpty()) {
                     this.fabricationEnteteAchats.setFabFamille(this.produits.getProAchCode());
                  } else {
                     this.fabricationEnteteAchats.setFabFamille(this.produits.getProVteCode());
                  }

                  this.fabricationEnteteAchats.setFabEchelle(this.processEnteteAchats.getProcesEchelle());
                  this.fabricationEnteteAchats.setFabDepot(this.processEnteteAchats.getProcesDepot());
                  this.fabricationEnteteAchats.setFabStock(this.processEnteteAchats.getProcesStock());
                  this.fabricationEnteteAchats.setFabCoef(this.processEnteteAchats.getProcesCoef());
                  this.mesUnitesProduits = this.chargerUniteProduit(var1);
                  if (this.mesUnitesProduits.size() != 0) {
                     this.fabricationEnteteAchats.setFabUnite(((SelectItem)this.mesUnitesProduits.get(0)).getValue().toString());
                  } else {
                     this.fabricationEnteteAchats.setFabUnite(this.processEnteteAchats.getProcesUnite());
                  }

                  this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
                  if (this.mesConditionnementsProduits.size() != 0) {
                     this.fabricationEnteteAchats.setFabCondition(((SelectItem)this.mesConditionnementsProduits.get(0)).getValue().toString());
                  } else {
                     this.fabricationEnteteAchats.setFabCondition(this.processEnteteAchats.getProcesCondition());
                  }
               }
            } else {
               this.produits = null;
               this.fabricationEnteteAchats.setFabProcess(this.processEnteteAchats.getProcesCode());
               this.fabricationEnteteAchats.setFabLibClient(this.processEnteteAchats.getProcesLibClient());
               this.fabricationEnteteAchats.setFabLibTech(this.processEnteteAchats.getProcesLibTech());
               this.fabricationEnteteAchats.setFabFamille("");
               this.fabricationEnteteAchats.setFabEchelle(this.processEnteteAchats.getProcesEchelle());
               this.fabricationEnteteAchats.setFabDepot(this.processEnteteAchats.getProcesDepot());
               this.fabricationEnteteAchats.setFabStock(this.processEnteteAchats.getProcesStock());
               this.fabricationEnteteAchats.setFabCoef(this.processEnteteAchats.getProcesCoef());
               this.mesUnitesProduits = this.chargerUniteProduit(var1);
               this.fabricationEnteteAchats.setFabUnite(this.processEnteteAchats.getProcesUnite());
               this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
               this.fabricationEnteteAchats.setFabCondition(this.processEnteteAchats.getProcesCondition());
            }

            new ArrayList();
            List var5 = this.processLigneAchatsDao.chargerDetailProcess(this.processEnteteAchats, var1);
            if (var5.size() != 0) {
               this.processLigneAchats = new ProcessLigneAchats();

               for(int var4 = 0; var4 < var5.size(); ++var4) {
                  this.processLigneAchats = (ProcessLigneAchats)var5.get(var4);
                  if (this.processLigneAchats.getProcesligType() == 1) {
                     this.lesLignesIntrants.add(this.convertirProcessProduit(this.processLigneAchats, var1));
                  } else if (this.processLigneAchats.getProcesligType() == 2) {
                     this.lesLignesSousProduits.add(this.convertirProcessProduit(this.processLigneAchats, var1));
                  } else if (this.processLigneAchats.getProcesligType() == 3) {
                     this.lesLignesDechets.add(this.convertirProcessProduit(this.processLigneAchats, var1));
                  } else if (this.processLigneAchats.getProcesligType() == 4) {
                     this.lesLignesTaches.add(this.convertirProcessTache(this.processLigneAchats, var1));
                  } else if (this.processLigneAchats.getProcesligType() == 5) {
                     this.lesLignesGeneres.add(this.convertirProcessProduit(this.processLigneAchats, var1));
                  }
               }
            }
         }
      } else if (this.var_process != null && !this.var_process.isEmpty() && this.var_process.equals("ACTIVITE")) {
         this.var_valide_doc = true;
         this.typeProduits = 1;
         this.produits = null;
         this.processEnteteAchats = new ProcessEnteteAchats();
         this.fabricationEnteteAchats.setFabMode(0);
         this.fabricationEnteteAchats.setFabOption1(0);
         this.fabricationEnteteAchats.setFabOption2(2);
         this.fabricationEnteteAchats.setFabAtelier("");
         this.fabricationEnteteAchats.setFabLigne("");
         this.fabricationEnteteAchats.setFabSite("");
         this.fabricationEnteteAchats.setFabService("");
         this.fabricationEnteteAchats.setFabSuffixe("");
         this.fabricationEnteteAchats.setFabProcess("ACTIVITE");
         this.fabricationEnteteAchats.setFabLibClient("");
         this.fabricationEnteteAchats.setFabLibTech("");
         this.fabricationEnteteAchats.setFabFamille("");
         this.fabricationEnteteAchats.setFabEchelle(0);
         this.fabricationEnteteAchats.setFabDepot("");
         this.fabricationEnteteAchats.setFabStock(0);
         this.fabricationEnteteAchats.setFabCoef(0.0F);
         this.fabricationEnteteAchats.setFabUnite("");
         this.fabricationEnteteAchats.setFabCondition("");
      } else if (this.var_process != null && !this.var_process.isEmpty() && this.var_process.equals("CHANTIER")) {
         this.var_valide_doc = true;
         this.typeProduits = 1;
         this.produits = null;
         this.processEnteteAchats = new ProcessEnteteAchats();
         this.fabricationEnteteAchats.setFabMode(0);
         this.fabricationEnteteAchats.setFabOption1(0);
         this.fabricationEnteteAchats.setFabOption2(3);
         this.fabricationEnteteAchats.setFabAtelier("");
         this.fabricationEnteteAchats.setFabLigne("");
         this.fabricationEnteteAchats.setFabSite("");
         this.fabricationEnteteAchats.setFabService("");
         this.fabricationEnteteAchats.setFabSuffixe("");
         this.fabricationEnteteAchats.setFabProcess("CHANTIER");
         this.fabricationEnteteAchats.setFabLibClient("");
         this.fabricationEnteteAchats.setFabLibTech("");
         this.fabricationEnteteAchats.setFabFamille("");
         this.fabricationEnteteAchats.setFabEchelle(0);
         this.fabricationEnteteAchats.setFabDepot("");
         this.fabricationEnteteAchats.setFabStock(0);
         this.fabricationEnteteAchats.setFabCoef(0.0F);
         this.fabricationEnteteAchats.setFabUnite("");
         this.fabricationEnteteAchats.setFabCondition("");
      } else {
         this.processEnteteAchats = new ProcessEnteteAchats();
         this.fabricationEnteteAchats = new FabricationEnteteAchats();
      }

      this.utilInitHibernate.closeSession();
      this.datamodelGeneres.setWrappedData(this.lesLignesGeneres);
      this.datamodelIntrants.setWrappedData(this.lesLignesIntrants);
      this.datamodelSousProduits.setWrappedData(this.lesLignesSousProduits);
      this.datamodelDechets.setWrappedData(this.lesLignesDechets);
      this.datamodelTaches.setWrappedData(this.lesLignesTaches);
      this.addLigne();
   }

   public void selectionLotEntete() {
   }

   public void calculQteProduite() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
      if (this.lesLignesGeneres.size() != 0) {
         float var2 = 0.0F;

         for(int var3 = 0; var3 < this.lesLignesGeneres.size(); ++var3) {
            var2 += ((FabricationLigneAchats)this.lesLignesGeneres.get(var3)).getFabligQte();
         }

         this.fabricationEnteteAchats.setFabQte(var2);
      }

      if (this.fabricationEnteteAchats.getFabQte() != 0.0F) {
         if (this.fabricationEnteteAchats.getFabCondition() != null && !this.fabricationEnteteAchats.getFabCondition().isEmpty() && this.fabricationEnteteAchats.getFabCondition().contains(":")) {
            ConditionnementDao var5 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
            String[] var7 = this.fabricationEnteteAchats.getFabCondition().split(":");
            String var4 = var5.rechercheConditionnement(var7[0], var1).getCdtDescription();
            if (var4 != null && !var4.isEmpty()) {
               this.fabricationEnteteAchats.setFabDescription(var4);
            } else {
               this.fabricationEnteteAchats.setFabDescription("");
            }

            if (this.fabricationEnteteAchats.getFabEchelle() == 0) {
               this.unite = new Unite();
               this.unite = this.uniteDao.selectUnite(var7[0], var1);
               if (this.unite != null) {
                  this.fabricationEnteteAchats.setFabEchelle(this.unite.getUniEchelle());
               }
            }

            this.fabricationEnteteAchats.setFabQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.fabricationEnteteAchats.getFabCondition(), this.fabricationEnteteAchats.getFabQte(), this.produits.getProLongueur(), this.produits.getProLargeur(), this.produits.getProEpaisseur(), this.produits.getProDiamInt(), this.produits.getProNbUnite(), this.baseLog, this.utilInitHibernate, var1));
         } else {
            this.fabricationEnteteAchats.setFabDescription("");
            this.fabricationEnteteAchats.setFabEchelle(0);
            this.fabricationEnteteAchats.setFabQteUtil(this.fabricationEnteteAchats.getFabQte());
         }

         if (this.fabricationEnteteAchats.getFabMode() == 0) {
            int var6;
            if (this.lesLignesIntrants.size() != 0) {
               for(var6 = 0; var6 < this.lesLignesIntrants.size(); ++var6) {
                  this.fabricationLigneAchatsIntrants = (FabricationLigneAchats)this.lesLignesIntrants.get(var6);
                  this.fabricationLigneAchatsIntrants.setFabligQte((float)(this.fabricationLigneAchatsIntrants.getFabligQteReference() * (double)this.fabricationEnteteAchats.getFabQte()));
                  this.fabricationLigneAchatsIntrants.setFabligQteUtil(this.fabricationLigneAchatsIntrants.getFabligQte());
                  if (this.fabricationLigneAchatsIntrants.getFabligCode() != null && !this.fabricationLigneAchatsIntrants.getFabligCode().isEmpty() && this.fabricationLigneAchatsIntrants.getFabligDepot() != null && !this.fabricationLigneAchatsIntrants.getFabligDepot().isEmpty()) {
                     this.calculeQteDispo(var1);
                  }
               }
            }

            if (this.lesLignesSousProduits.size() != 0) {
               for(var6 = 0; var6 < this.lesLignesSousProduits.size(); ++var6) {
                  this.fabricationLigneAchatsSousProduits = (FabricationLigneAchats)this.lesLignesSousProduits.get(var6);
                  this.fabricationLigneAchatsSousProduits.setFabligQte((float)(this.fabricationLigneAchatsSousProduits.getFabligQteReference() * (double)this.fabricationEnteteAchats.getFabQte()));
                  this.fabricationLigneAchatsSousProduits.setFabligQteUtil(this.fabricationLigneAchatsSousProduits.getFabligQte());
               }
            }

            if (this.lesLignesDechets.size() != 0) {
               for(var6 = 0; var6 < this.lesLignesDechets.size(); ++var6) {
                  this.fabricationLigneAchatsDechets = (FabricationLigneAchats)this.lesLignesDechets.get(var6);
                  this.fabricationLigneAchatsDechets.setFabligQte((float)(this.fabricationLigneAchatsDechets.getFabligQteReference() * (double)this.fabricationEnteteAchats.getFabQte()));
                  this.fabricationLigneAchatsDechets.setFabligQteUtil(this.fabricationLigneAchatsDechets.getFabligQte());
               }
            }
         }
      }

      this.utilInitHibernate.closeSession();
      this.addLigne();
   }

   public FabricationLigneAchats convertirProcessProduit(ProcessLigneAchats var1, Session var2) throws HibernateException, NamingException {
      if (var1.getProcesligCode() != null && !var1.getProcesligCode().isEmpty()) {
         this.produits = this.produitsDao.chargeToutProduit(var1.getProcesligCode(), var2);
         if (this.produits != null) {
            if (var1.getProcesligDepot() != null && !var1.getProcesligDepot().isEmpty()) {
               this.produitsDepot = this.produitsDepotDao.produitDepByprod(var1.getProcesligCode(), var1.getProcesligDepot(), var2);
               if (this.produitsDepot == null) {
                  this.produitsDepot = new ProduitsDepot();
               }
            }
         } else {
            this.produits = new Produits();
            this.produitsDepot = new ProduitsDepot();
         }
      } else {
         this.produits = new Produits();
         this.produitsDepot = new ProduitsDepot();
      }

      FabricationLigneAchats var3 = new FabricationLigneAchats();
      var3.setFabligCasier(this.produitsDepot.getProdepCasier());
      var3.setFabligCode(var1.getProcesligCode());
      var3.setFabligCondition("");
      var3.setFabligDepot(var1.getProcesligDepot());
      var3.setFabligDescription("");
      var3.setFabligDiam(this.produits.getProDiamExt());
      var3.setFabligFamille(this.produits.getProAchCode());
      var3.setFabligHaut(this.produits.getProEpaisseur());
      var3.setFabligLarg(this.produits.getProLargeur());
      var3.setFabligLibelle(var1.getProcesligLibClient());
      var3.setFabligLong(this.produits.getProLongueur());
      var3.setFabligNb(this.produits.getProNbUnite());
      var3.setFabligObs("");
      var3.setFabligOrdre(var1.getProcesligOrdre());
      var3.setFabligPoidsBrut(this.produits.getProPoidsBrut());
      var3.setFabligPoidsNet(this.produits.getProPoidsNet());
      var3.setFabligJj(0);
      var3.setFabligHh(0);
      var3.setFabligMm(0);
      var3.setFabligSs(0);
      var3.setFabligPump(this.produitsDepot.getProdepPump());
      var3.setFabligInterChange(var1.isProcesligInterChange());
      var3.setFabligProduitInterchangeable(var1.getProcesligProduitInterchangeable());
      var3.setFabligMetier("");
      var3.setFabligMateriel("");
      var3.setFabligQteReference(var1.getProcesligQte());
      var3.setFabligQte(0.0F);
      var3.setFabligQteStock(this.produitsDepot.getProdepQteStk());
      var3.setFabligQteUtil(0.0F);
      var3.setFabligReference("");
      var3.setFabligStock(this.produits.getProStock());
      var3.setFabligTotal(0.0D);
      var3.setFabligType(var1.getProcesligType());
      var3.setFabligUnite(var1.getProcesligUnite());
      var3.setFabligVolume(this.produits.getProVolume());
      return var3;
   }

   public FabricationLigneAchats convertirProcessTache(ProcessLigneAchats var1, Session var2) throws HibernateException, NamingException {
      if (var1.getProcesligCode() != null && !var1.getProcesligCode().isEmpty()) {
         this.taches = this.tachesDao.rechercheTache(var1.getProcesligCode(), var2);
      } else {
         this.taches = new Taches();
      }

      FabricationLigneAchats var3 = new FabricationLigneAchats();
      var3.setFabligCasier("");
      var3.setFabligCode(var1.getProcesligCode());
      var3.setFabligCondition("");
      var3.setFabligDepot("");
      var3.setFabligDescription("");
      var3.setFabligDiam(0.0F);
      var3.setFabligFamille(this.taches.getTacCode());
      var3.setFabligHaut(0.0F);
      var3.setFabligLarg(0.0F);
      var3.setFabligLibelle(this.taches.getTacNomFr());
      var3.setFabligLong(0.0F);
      var3.setFabligNb(0.0F);
      var3.setFabligObs("");
      var3.setFabligOrdre(var1.getProcesligOrdre());
      var3.setFabligPoidsBrut(0.0F);
      var3.setFabligPoidsNet(0.0F);
      var3.setFabligJj(this.taches.getTacValJj());
      var3.setFabligHh(this.taches.getTacValHh());
      var3.setFabligMm(this.taches.getTacValMm());
      var3.setFabligSs(this.taches.getTacValSs());
      var3.setFabligPump((double)this.taches.getTacValPr());
      var3.setFabligInterChange(false);
      var3.setFabligProduitInterchangeable("");
      var3.setFabligMetier(var1.getProcesligMetier());
      var3.setFabligMateriel(var1.getProcesligMateriel());
      var3.setFabligQteReference(0.0D);
      var3.setFabligQte(0.0F);
      var3.setFabligQteStock(0.0F);
      var3.setFabligQteUtil(0.0F);
      var3.setFabligReference("");
      var3.setFabligStock(0);
      var3.setFabligTotal(0.0D);
      var3.setFabligType(var1.getProcesligType());
      var3.setFabligUnite("");
      var3.setFabligVolume(0.0F);
      return var3;
   }

   public void ajoutDocument() throws IOException, JDOMException {
      this.processEnteteAchats = new ProcessEnteteAchats();
      this.receptionLotAchats = new ReceptionLotAchats();
      this.receptionSerieAchats = new ReceptionSerieAchats();
      this.fabricationEnteteAchats = new FabricationEnteteAchats();
      this.fabricationLigneAchatsIntrants = new FabricationLigneAchats();
      this.fabricationLigneAchatsSousProduits = new FabricationLigneAchats();
      this.fabricationLigneAchatsDechets = new FabricationLigneAchats();
      this.fabricationLigneAchatsTaches = new FabricationLigneAchats();
      this.depotAchatsProduction = new DepotAchats();
      this.fabricationEnteteAchats.setUsers(this.usersLog);
      this.fabricationEnteteAchats.setFabIdCreateur(this.usersLog.getUsrid());
      this.fabricationEnteteAchats.setFabNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.fabricationEnteteAchats.setFabIdResponsable(this.usersLog.getUsrid());
      this.fabricationEnteteAchats.setFabNomResponsable(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
      this.fabricationEnteteAchats.setFabDate(new Date());
      this.var_date = new Date();
      if ((new Date()).getHours() <= 9) {
         this.var_heure = "0" + (new Date()).getHours();
      } else {
         this.var_heure = "" + (new Date()).getHours();
      }

      if ((new Date()).getMinutes() <= 9) {
         this.var_minute = "0" + (new Date()).getMinutes();
      } else {
         this.var_minute = "" + (new Date()).getMinutes();
      }

      if ((new Date()).getSeconds() <= 9) {
         this.var_seconde = "0" + (new Date()).getSeconds();
      } else {
         this.var_seconde = "" + (new Date()).getSeconds();
      }

      this.lesLignesIntrants.clear();
      this.lesLignesSousProduits.clear();
      this.lesLignesDechets.clear();
      this.lesLignesTaches.clear();
      this.lesNumSerie.clear();
      this.mesLotsItems.clear();
      this.mesLotsEnteteItems.clear();
      this.var_action = 1;
      this.nomOnglet = "tabDoc";
      this.var_memo_action = this.var_action;
      this.var_depot_production = "";
      this.var_nom_responsable = 0L;
      this.var_aff_action = false;
      this.var_valide_doc = false;
      this.var_affiche_filtre = false;
      this.depotAchatsProduction = null;
      this.verrouNum = false;
      this.visibleOnglet = false;
      this.visibiliteBtonlig = true;
      this.var_process = "0";
      if (this.modeReception == 1) {
         this.typeProduits = 1;
         this.processEnteteAchats.setProcesCode("PAPIER");
      } else {
         this.typeProduits = 0;
      }

      this.code_activite = "";
      this.code_planAnalytique = "";
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
      }

      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      this.autorisationDocument();
      this.addLigne();
   }

   public void modifDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.fabricationEnteteAchats != null) {
         this.montantPump = this.fabricationEnteteAchats.getFabTotPump();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         this.chargerDocumentLigne(var1);
         this.chargerUserChrono(var1);
         this.var_action = 1;
         this.nomOnglet = "tabDoc";
         this.var_memo_action = this.var_action;
         this.var_aff_action = false;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         if (this.fabricationEnteteAchats.getFabDepot() != null && !this.fabricationEnteteAchats.getFabDepot().isEmpty()) {
            this.depotAchatsProduction = new DepotAchats();
            this.depotAchatsProduction = this.depotAchatsDao.trouveDepot(this.fabricationEnteteAchats.getFabDepot(), var1);
            if (this.depotAchatsProduction != null) {
               this.var_depot_production = this.depotAchatsProduction.getDpoCode() + ":" + this.depotAchatsProduction.getDpoLibelle();
            } else {
               this.var_depot_production = "";
            }
         } else {
            this.var_depot_production = "";
         }

         if (this.fabricationEnteteAchats.getFabIdResponsable() != 0L) {
            new Users();
            Users var2 = this.usersDao.selectByIdUsers(this.fabricationEnteteAchats.getFabIdResponsable(), var1);
            if (var2 != null) {
               if (this.usersLog.getUsrPrenom() == null) {
                  this.usersLog.setUsrPrenom("");
               }

               if (this.usersLog.getUsrFonction() == null) {
                  this.usersLog.setUsrFonction("");
               }

               if (this.usersLog.getUsrFonction().contains("fonction")) {
                  this.usersLog.setUsrFonction("");
               }

               this.var_nom_responsable = this.usersLog.getUsrid();
            } else {
               this.var_nom_responsable = 0L;
            }
         } else {
            this.var_nom_responsable = 0L;
         }

         if (this.fabricationEnteteAchats.getFabProcess() != null && !this.fabricationEnteteAchats.getFabProcess().isEmpty() && this.fabricationEnteteAchats.getFabProcess().equals("PAPIER")) {
            this.processEnteteAchats = new ProcessEnteteAchats();
            this.processEnteteAchats.setProcesCode("PAPIER");
         } else if (this.fabricationEnteteAchats.getFabOption2() == 2) {
            this.processEnteteAchats = new ProcessEnteteAchats();
            this.fabricationEnteteAchats.setFabProcess("ACTIVITE");
         } else if (this.fabricationEnteteAchats.getFabOption2() == 3) {
            this.processEnteteAchats = new ProcessEnteteAchats();
            this.fabricationEnteteAchats.setFabProcess("CHANTIER");
         } else {
            this.processEnteteAchats = this.processEnteteAchatsDao.rechercheProcess(this.fabricationEnteteAchats.getFabProcess(), var1);
            if (this.processEnteteAchats != null) {
               new ArrayList();
               List var6 = this.processLigneAchatsDao.chargerDetailProcess(this.processEnteteAchats, var1);
               if (var6.size() != 0) {
                  for(int var3 = 0; var3 < var6.size(); ++var3) {
                     this.processLigneAchats = (ProcessLigneAchats)var6.get(var3);
                     if (this.processLigneAchats.getProcesligType() == 1) {
                        boolean var4 = false;

                        for(int var5 = 0; var5 < this.lesLignesIntrants.size(); ++var5) {
                           this.fabricationLigneAchatsIntrants = (FabricationLigneAchats)this.lesLignesIntrants.get(var5);
                           if (this.processLigneAchats.getProcesligCode() != null && !this.processLigneAchats.getProcesligCode().isEmpty() && this.fabricationLigneAchatsIntrants.getFabligCode() != null && !this.fabricationLigneAchatsIntrants.getFabligCode().isEmpty() && this.processLigneAchats.getProcesligCode().equals(this.fabricationLigneAchatsIntrants.getFabligCode())) {
                              var4 = true;
                              break;
                           }

                           if (this.processLigneAchats.getProcesligProduitInterchangeable() != null && !this.processLigneAchats.getProcesligProduitInterchangeable().isEmpty() && this.fabricationLigneAchatsIntrants.getFabligCode() != null && !this.fabricationLigneAchatsIntrants.getFabligCode().isEmpty() && this.processLigneAchats.getProcesligProduitInterchangeable().contains(this.fabricationLigneAchatsIntrants.getFabligCode())) {
                              var4 = true;
                              break;
                           }
                        }

                        if (!var4) {
                           this.lesLignesIntrants.add(this.convertirProcessProduit(this.processLigneAchats, var1));
                        }
                     }
                  }
               }
            }
         }

         this.utilInitHibernate.closeSession();
         this.autorisationDocument();
         this.addLigne();
      }

   }

   public void consultDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.fabricationEnteteAchats != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         this.chargerDocumentLigne(var1);
         this.var_action = 2;
         this.nomOnglet = "tabDoc";
         this.var_memo_action = this.var_action;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         if (this.fabricationEnteteAchats.getFabDepot() != null && !this.fabricationEnteteAchats.getFabDepot().isEmpty()) {
            this.depotAchatsProduction = new DepotAchats();
            this.depotAchatsProduction = this.depotAchatsDao.trouveDepot(this.fabricationEnteteAchats.getFabDepot(), var1);
            if (this.depotAchatsProduction != null) {
               this.var_depot_production = this.depotAchatsProduction.getDpoCode() + ":" + this.depotAchatsProduction.getDpoLibelle();
            } else {
               this.var_depot_production = "";
            }
         } else {
            this.var_depot_production = "";
         }

         this.utilInitHibernate.closeSession();
         this.autorisationDocument();
      }

   }

   public boolean verificationValidation() {
      boolean var1 = false;
      if (this.usersLog.getUsrDepotSel() == 1 && this.verrouDepotUser != null && !this.verrouDepotUser.isEmpty()) {
         ArrayList var2 = new ArrayList();
         if (!this.verrouDepotUser.contains(",")) {
            var2.add(this.verrouDepotUser);
         } else {
            String[] var3 = this.verrouDepotUser.split(",");
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
               var2.add(var3[var5]);
            }
         }

         for(int var6 = 0; var6 < var2.size(); ++var6) {
            if (((String)var2.get(var6)).toString().equals(this.fabricationEnteteAchats.getFabDepot())) {
               var1 = true;
               break;
            }
         }
      } else {
         var1 = true;
      }

      return var1;
   }

   public void fermerVerificationValidation() {
      this.formRecherche.setShowModalPanelMessage(false);
   }

   public void valideDocument() throws HibernateException, NamingException, ParseException {
      if (this.verificationValidation()) {
         boolean var1 = false;
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         Transaction var3 = null;

         int var8;
         try {
            var3 = var2.beginTransaction();
            if (this.fabricationEnteteAchats.getFabEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.fabricationEnteteAchats.setFabEtat(1);
               double var4 = 0.0D;
               float var6 = 0.0F;

               int var7;
               for(var7 = 0; var7 < this.lesLignesIntrants.size(); ++var7) {
                  var4 += ((FabricationLigneAchats)this.lesLignesIntrants.get(var7)).getFabligPump() * (double)((FabricationLigneAchats)this.lesLignesIntrants.get(var7)).getFabligQte();
                  var6 += ((FabricationLigneAchats)this.lesLignesIntrants.get(var7)).getFabligQte();
               }

               this.fabricationEnteteAchats.setFabTotPump(var4);
               if (this.fabricationEnteteAchats.getFabQte() != 0.0F) {
                  this.fabricationEnteteAchats.setFabPump(var4 / (double)this.fabricationEnteteAchats.getFabQte());
               } else {
                  this.fabricationEnteteAchats.setFabPump(var4 / (double)var6);
               }

               this.fabricationEnteteAchats = this.fabricationEnteteAchatsDao.modif(this.fabricationEnteteAchats, var2);
               if (this.lesLignesGeneres.size() != 0) {
                  float var26 = 0.0F;

                  for(var8 = 0; var8 < this.lesLignesGeneres.size(); ++var8) {
                     var26 += ((FabricationLigneAchats)this.lesLignesGeneres.get(var8)).getFabligPoidsNet();
                  }

                  for(var8 = 0; var8 < this.lesLignesGeneres.size(); ++var8) {
                     this.fabricationLigneAchatsGeneres = (FabricationLigneAchats)this.lesLignesGeneres.get(var8);
                     float var9 = this.fabricationLigneAchatsGeneres.getFabligPoidsNet() / var26;
                     this.fabricationLigneAchatsGeneres.setFabligPump(this.utilNombre.myRound(var4 / (double)this.fabricationLigneAchatsGeneres.getFabligQte() * (double)var9, 2));
                  }

                  this.calculStock.majFabrication((List)this.lesLignesGeneres, 0, this.baseLog, var2);
               } else if (this.fabricationEnteteAchats.getFabOption2() != 2) {
                  this.calculStock.majFabrication((FabricationEnteteAchats)this.fabricationEnteteAchats, 0, this.baseLog, var2);
               }

               if (this.fabricationEnteteAchats.getFabOption1() == 0) {
                  this.fabricationLigneAchatsIntrants.setFabligQteRestant((float)this.fabricationLigneAchatsIntrants.getFabligStock() - this.fabricationLigneAchatsIntrants.getFabligQte());
               } else if (this.fabricationEnteteAchats.getFabOption1() == 1) {
                  this.fabricationLigneAchatsIntrants.setFabligQte((float)this.fabricationLigneAchatsIntrants.getFabligStock() - this.fabricationLigneAchatsIntrants.getFabligQteRestant());
               }

               this.calculStock.majFabrication((List)this.lesLignesIntrants, 1, this.baseLog, var2);
               this.calculStock.majFabrication((List)this.lesLignesSousProduits, 0, this.baseLog, var2);
               this.calculStock.majFabrication((List)this.lesLignesDechets, 0, this.baseLog, var2);
               if (this.fabricationEnteteAchats.getFabStock() != 0 && this.fabricationEnteteAchats.getFabStock() != 1) {
                  if (this.fabricationEnteteAchats.getFabStock() != 2 && this.fabricationEnteteAchats.getFabStock() != 3 && this.fabricationEnteteAchats.getFabStock() != 4) {
                     if (this.fabricationEnteteAchats.getFabStock() != 5 && this.fabricationEnteteAchats.getFabStock() == 6) {
                     }
                  } else {
                     this.produits = this.produitsDao.chargeToutProduit(this.fabricationEnteteAchats.getFabProcess(), var2);
                     if (this.produits == null) {
                        this.produits = new Produits();
                     }

                     boolean var27 = false;
                     this.receptionLotAchats = this.receptionLotAchatsDao.rechercheLot(this.fabricationEnteteAchats.getFabId(), var2);
                     if (this.receptionLotAchats == null) {
                        this.receptionLotAchats = new ReceptionLotAchats();
                        this.receptionLotAchats.setReclotQteConso(0.0F);
                     } else {
                        var27 = true;
                     }

                     this.receptionLotAchats.setReclotCode(this.fabricationEnteteAchats.getFabProcess());
                     this.receptionLotAchats.setReclotDateAchat((Date)null);
                     this.receptionLotAchats.setReclotDateFab(this.fabricationEnteteAchats.getFabDate());
                     this.receptionLotAchats.setReclotDateValable(this.fabricationEnteteAchats.getFabDatePeremption());
                     this.receptionLotAchats.setReclotDepot(this.fabricationEnteteAchats.getFabDepot());
                     this.receptionLotAchats.setReclotDiam(this.produits.getProDiamInt());
                     this.receptionLotAchats.setReclotHaut(this.produits.getProEpaisseur());
                     this.receptionLotAchats.setReclotIdLigne(0L);
                     this.receptionLotAchats.setReclotIdLigneFab(this.fabricationEnteteAchats.getFabId());
                     this.receptionLotAchats.setReclotLarg(this.produits.getProLargeur());
                     this.receptionLotAchats.setReclotLong(this.produits.getProLongueur());
                     this.receptionLotAchats.setReclotNb(this.produits.getProNbUnite());
                     this.receptionLotAchats.setReclotNum("");
                     this.receptionLotAchats.setReclotNumFab(this.fabricationEnteteAchats.getFabNum());
                     this.receptionLotAchats.setReclotNumero(this.fabricationEnteteAchats.getFabNumLot());
                     this.receptionLotAchats.setReclotPoidsBrut(this.produits.getProPoidsBrut());
                     this.receptionLotAchats.setReclotPoidsNet(this.produits.getProPoidsNet());
                     this.receptionLotAchats.setReclotPoidsTare(this.produits.getProPoidsTare());
                     this.receptionLotAchats.setReclotPr(this.fabricationEnteteAchats.getFabTotPump());
                     this.receptionLotAchats.setReclotQte(this.receptionLotAchats.getReclotQte() + this.fabricationEnteteAchats.getFabQte());
                     this.receptionLotAchats.setReclotQteUtil(this.receptionLotAchats.getReclotQteUtil() + this.fabricationEnteteAchats.getFabQte());
                     if (!var27) {
                        this.receptionLotAchats = this.receptionLotAchatsDao.insert(this.receptionLotAchats, var2);
                     } else {
                        this.receptionLotAchats = this.receptionLotAchatsDao.modif(this.receptionLotAchats, var2);
                     }
                  }
               }

               if (this.lesLignesIntrants.size() != 0) {
                  for(var7 = 0; var7 < this.lesLignesIntrants.size(); ++var7) {
                     this.fabricationLigneAchatsIntrants = (FabricationLigneAchats)this.lesLignesIntrants.get(var7);
                     if ((this.fabricationLigneAchatsIntrants.getFabligStock() == 2 || this.fabricationLigneAchatsIntrants.getFabligStock() == 3 || this.fabricationLigneAchatsIntrants.getFabligStock() == 4) && this.fabricationLigneAchatsIntrants.getFabligLot() != null && !this.fabricationLigneAchatsIntrants.getFabligLot().isEmpty()) {
                        this.receptionLotAchats = this.receptionLotAchatsDao.rechercheLot(this.fabricationLigneAchatsIntrants.getFabligCode(), this.fabricationLigneAchatsIntrants.getFabligDepot(), this.fabricationLigneAchatsIntrants.getFabligLot(), var2);
                        if (this.receptionLotAchats != null) {
                           this.receptionLotAchats.setReclotQteConso(this.receptionLotAchats.getReclotQteConso() + this.fabricationLigneAchatsIntrants.getFabligQte());
                           this.receptionLotAchats.setReclotQteUtilConso(this.receptionLotAchats.getReclotQteUtilConso() + this.fabricationLigneAchatsIntrants.getFabligQteUtil());
                           this.receptionLotAchats = this.receptionLotAchatsDao.modif(this.receptionLotAchats, var2);
                           if (this.receptionLotAchats.getReclotQteUtilConso() >= this.receptionLotAchats.getReclotQteUtil()) {
                              this.plansAnalytiques = new PlansAnalytiques();
                              this.plansAnalytiques = this.plansAnalytiquesDao.rechercheAnal("5", this.fabricationLigneAchatsIntrants.getFabligLot(), var2);
                              if (this.plansAnalytiques != null) {
                                 this.plansAnalytiques.setAnaDateModif(new Date());
                                 this.plansAnalytiques.setAnaUserModif(this.usersLog.getUsrid());
                                 this.plansAnalytiques.setAnaMissionFin(new Date());
                                 this.plansAnalytiques.setAnaLotEtat(1);
                                 this.plansAnalytiques = this.plansAnalytiquesDao.modif(this.plansAnalytiques, var2);
                              }
                           }
                        }
                     }
                  }
               }

               Espion var30 = new Espion();
               var30.setUsers(this.usersLog);
               var30.setEsptype(0);
               var30.setEspdtecreat(new Date());
               var30.setEspaction("Validation manuelle production (S.) N° " + this.fabricationEnteteAchats.getFabNum() + " du " + this.utilDate.dateToStringSQLLight(this.fabricationEnteteAchats.getFabDate()));
               this.espionDao.mAJEspion(var30, var2);
            }

            var3.commit();
         } catch (HibernateException var22) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var22;
         } finally {
            var1 = true;
            this.utilInitHibernate.closeSession();
         }

         if (var1 && (this.lesLignesIntrants.size() != 0 || this.lesLignesGeneres.size() != 0)) {
            var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "CalculMouvementStock");
            Transaction var24 = null;

            try {
               var24 = var2.beginTransaction();
               new OptionVentes();
               LireLesoptionsVentes var25 = new LireLesoptionsVentes();
               var25.setStrId(this.structureLog.getStrid());
               var25.lancer();
               OptionVentes var5 = var25.getOptionsVentes();
               new InventaireLigne();
               String var28;
               InventaireLigne var31;
               if (this.lesLignesGeneres.size() == 0) {
                  if (this.fabricationEnteteAchats.getFabProcess() != null && !this.fabricationEnteteAchats.getFabProcess().isEmpty() && this.fabricationEnteteAchats.getFabDepot() != null && !this.fabricationEnteteAchats.getFabDepot().isEmpty()) {
                     this.produits = this.produitsDao.chargeProduit(this.fabricationEnteteAchats.getFabProcess(), var2);
                     if (this.produits != null) {
                        String var29 = "";
                        if (this.produits.getProAchNat() == null || this.produits.getProAchNat().isEmpty() || !this.produits.getProAchNat().equals("1105") && !this.produits.getProAchNat().equals("0104") && !this.produits.getProAchNat().equals("0105") && !this.produits.getProAchNat().equals("1604") && !this.produits.getProAchNat().equals("1605")) {
                           if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty() && (this.produits.getProVteNat().equals("1105") || this.produits.getProVteNat().equals("0104") || this.produits.getProVteNat().equals("0105") || this.produits.getProVteNat().equals("1604") || this.produits.getProVteNat().equals("1605"))) {
                              var29 = this.produits.getProVteNat();
                           } else if (this.produits.getProAchNat() != null && !this.produits.getProAchNat().isEmpty()) {
                              var29 = this.produits.getProAchNat();
                           } else if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty()) {
                              var29 = this.produits.getProVteNat();
                           }
                        } else {
                           var29 = this.produits.getProAchNat();
                        }

                        this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.produits.getProCode(), this.fabricationEnteteAchats.getFabDepot(), var2);
                        if (this.produitsDepot != null) {
                           var31 = this.calculStock.chercheDernierInventaire(this.produits.getProCode(), this.fabricationEnteteAchats.getFabDepot(), this.baseLog, var2);
                           this.produitsDepot = this.calculStock.recalculStock(var29, this.produitsDepot, var31, this.produits.getProCode(), (String)null, this.fabricationEnteteAchats.getFabDepot(), 0L, var5.getGestionStockBc(), this.baseLog, this.structureLog, var2);
                           this.produitsDepot = this.produitsDepotDao.modif(this.produitsDepot, var2);
                        }
                     }
                  }
               } else {
                  for(var8 = 0; var8 < this.lesLignesGeneres.size(); ++var8) {
                     this.fabricationLigneAchatsGeneres = (FabricationLigneAchats)this.lesLignesGeneres.get(var8);
                     if (this.fabricationLigneAchatsGeneres.getFabligCode() != null && !this.fabricationLigneAchatsGeneres.getFabligCode().isEmpty() && this.fabricationLigneAchatsGeneres.getFabligDepot() != null && !this.fabricationLigneAchatsGeneres.getFabligDepot().isEmpty()) {
                        this.produits = this.produitsDao.chargeProduit(this.fabricationLigneAchatsGeneres.getFabligCode(), var2);
                        if (this.produits != null) {
                           var28 = "";
                           if (this.produits.getProAchNat() == null || this.produits.getProAchNat().isEmpty() || !this.produits.getProAchNat().equals("1105") && !this.produits.getProAchNat().equals("0104") && !this.produits.getProAchNat().equals("0105") && !this.produits.getProAchNat().equals("1604") && !this.produits.getProAchNat().equals("1605")) {
                              if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty() && (this.produits.getProVteNat().equals("1105") || this.produits.getProVteNat().equals("0104") || this.produits.getProVteNat().equals("0105") || this.produits.getProVteNat().equals("1604") || this.produits.getProVteNat().equals("1605"))) {
                                 var28 = this.produits.getProVteNat();
                              } else if (this.produits.getProAchNat() != null && !this.produits.getProAchNat().isEmpty()) {
                                 var28 = this.produits.getProAchNat();
                              } else if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty()) {
                                 var28 = this.produits.getProVteNat();
                              }
                           } else {
                              var28 = this.produits.getProAchNat();
                           }

                           this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.produits.getProCode(), this.fabricationLigneAchatsGeneres.getFabligDepot(), var2);
                           if (this.produitsDepot != null) {
                              var31 = this.calculStock.chercheDernierInventaire(this.produits.getProCode(), this.fabricationLigneAchatsGeneres.getFabligDepot(), this.baseLog, var2);
                              this.produitsDepot = this.calculStock.recalculStock(var28, this.produitsDepot, var31, this.produits.getProCode(), (String)null, this.fabricationLigneAchatsGeneres.getFabligDepot(), 0L, var5.getGestionStockBc(), this.baseLog, this.structureLog, var2);
                              this.produitsDepot = this.produitsDepotDao.modif(this.produitsDepot, var2);
                           }
                        }
                     }
                  }
               }

               for(var8 = 0; var8 < this.lesLignesIntrants.size(); ++var8) {
                  this.fabricationLigneAchatsIntrants = (FabricationLigneAchats)this.lesLignesIntrants.get(var8);
                  if (this.fabricationLigneAchatsIntrants.getFabligCode() != null && !this.fabricationLigneAchatsIntrants.getFabligCode().isEmpty() && this.fabricationLigneAchatsIntrants.getFabligDepot() != null && !this.fabricationLigneAchatsIntrants.getFabligDepot().isEmpty()) {
                     this.produits = this.produitsDao.chargeProduit(this.fabricationLigneAchatsIntrants.getFabligCode(), var2);
                     if (this.produits != null) {
                        var28 = "";
                        if (this.produits.getProAchNat() != null && !this.produits.getProAchNat().isEmpty() && (this.produits.getProAchNat().equals("1105") || this.produits.getProAchNat().equals("0104") || this.produits.getProAchNat().equals("0105") || this.produits.getProAchNat().equals("1604") || this.produits.getProAchNat().equals("1605"))) {
                           var28 = this.produits.getProAchNat();
                        } else if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty() && (this.produits.getProVteNat().equals("1105") || this.produits.getProVteNat().equals("0104") || this.produits.getProVteNat().equals("0105") || this.produits.getProVteNat().equals("1604") || this.produits.getProVteNat().equals("1605"))) {
                           var28 = this.produits.getProVteNat();
                        } else if (this.produits.getProAchNat() != null && !this.produits.getProAchNat().isEmpty()) {
                           var28 = this.produits.getProAchNat();
                        } else if (this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty()) {
                           var28 = this.produits.getProVteNat();
                        }

                        this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.produits.getProCode(), this.fabricationLigneAchatsIntrants.getFabligDepot(), var2);
                        if (this.produitsDepot != null) {
                           var31 = this.calculStock.chercheDernierInventaire(this.produits.getProCode(), this.fabricationLigneAchatsIntrants.getFabligDepot(), this.baseLog, var2);
                           this.produitsDepot = this.calculStock.recalculStock(var28, this.produitsDepot, var31, this.produits.getProCode(), (String)null, this.fabricationLigneAchatsIntrants.getFabligDepot(), 0L, var5.getGestionStockBc(), this.baseLog, this.structureLog, var2);
                           this.produitsDepot = this.produitsDepotDao.modif(this.produitsDepot, var2);
                        }
                     }
                  }
               }

               var24.commit();
            } catch (HibernateException var20) {
               if (var24 != null) {
                  var24.rollback();
               }

               throw var20;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      } else {
         this.formRecherche.setMessageTexte("Vous n'avez pas l'autorisation de valider cette production, car le dépôt de production ne fait pas parti de vos dépôts autorisés...");
         this.formRecherche.setShowModalPanelMessage(true);
      }

   }

   public void deValideDocument() throws HibernateException, NamingException {
      if (this.verificationValidation()) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.fabricationEnteteAchats.getFabEtat() == 1 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.fabricationEnteteAchats.setFabEtat(0);
               this.fabricationEnteteAchats = this.fabricationEnteteAchatsDao.modif(this.fabricationEnteteAchats, var1);
               if (this.fabricationEnteteAchats.getFabOption2() == 0) {
                  this.calculStock.majFabrication((FabricationEnteteAchats)this.fabricationEnteteAchats, 1, this.baseLog, var1);
               } else if (this.lesLignesGeneres.size() != 0) {
                  this.calculStock.majFabrication((List)this.lesLignesGeneres, 1, this.baseLog, var1);
               }

               this.calculStock.majFabrication((List)this.lesLignesIntrants, 0, this.baseLog, var1);
               this.calculStock.majFabrication((List)this.lesLignesSousProduits, 1, this.baseLog, var1);
               this.calculStock.majFabrication((List)this.lesLignesDechets, 1, this.baseLog, var1);
               if (this.fabricationEnteteAchats.getFabStock() != 0 && this.fabricationEnteteAchats.getFabStock() != 1) {
                  if (this.fabricationEnteteAchats.getFabStock() != 2 && this.fabricationEnteteAchats.getFabStock() != 3 && this.fabricationEnteteAchats.getFabStock() != 4) {
                     if (this.fabricationEnteteAchats.getFabStock() != 5 && this.fabricationEnteteAchats.getFabStock() == 6) {
                     }
                  } else {
                     this.produits = this.produitsDao.chargeToutProduit(this.fabricationEnteteAchats.getFabProcess(), var1);
                     if (this.produits != null) {
                        this.receptionLotAchats = this.receptionLotAchatsDao.rechercheLot(this.fabricationEnteteAchats.getFabId(), var1);
                        if (this.receptionLotAchats != null) {
                           this.receptionLotAchats.setReclotCode(this.fabricationEnteteAchats.getFabProcess());
                           this.receptionLotAchats.setReclotDateAchat((Date)null);
                           this.receptionLotAchats.setReclotDateFab(this.fabricationEnteteAchats.getFabDate());
                           this.receptionLotAchats.setReclotDateValable(this.fabricationEnteteAchats.getFabDatePeremption());
                           this.receptionLotAchats.setReclotDepot(this.fabricationEnteteAchats.getFabDepot());
                           this.receptionLotAchats.setReclotDiam(this.produits.getProDiamInt());
                           this.receptionLotAchats.setReclotHaut(this.produits.getProEpaisseur());
                           this.receptionLotAchats.setReclotIdLigne(0L);
                           this.receptionLotAchats.setReclotIdLigneFab(this.fabricationEnteteAchats.getFabId());
                           this.receptionLotAchats.setReclotLarg(this.produits.getProLargeur());
                           this.receptionLotAchats.setReclotLong(this.produits.getProLongueur());
                           this.receptionLotAchats.setReclotNb(this.produits.getProNbUnite());
                           this.receptionLotAchats.setReclotNum("");
                           this.receptionLotAchats.setReclotNumFab(this.fabricationEnteteAchats.getFabNum());
                           this.receptionLotAchats.setReclotNumero(this.fabricationEnteteAchats.getFabNumLot());
                           this.receptionLotAchats.setReclotPoidsBrut(this.produits.getProPoidsBrut());
                           this.receptionLotAchats.setReclotPoidsNet(this.produits.getProPoidsNet());
                           this.receptionLotAchats.setReclotPoidsTare(this.produits.getProPoidsTare());
                           this.receptionLotAchats.setReclotPr(this.fabricationEnteteAchats.getFabTotPump());
                           this.receptionLotAchats.setReclotQte(this.receptionLotAchats.getReclotQte() - this.fabricationEnteteAchats.getFabQte());
                           this.receptionLotAchats.setReclotQteUtil(this.receptionLotAchats.getReclotQteUtil() - this.fabricationEnteteAchats.getFabQte());
                           this.receptionLotAchats = this.receptionLotAchatsDao.modif(this.receptionLotAchats, var1);
                        }
                     }
                  }
               }

               if (this.lesLignesIntrants.size() != 0) {
                  for(int var3 = 0; var3 < this.lesLignesIntrants.size(); ++var3) {
                     this.fabricationLigneAchatsIntrants = (FabricationLigneAchats)this.lesLignesIntrants.get(var3);
                     if ((this.fabricationLigneAchatsIntrants.getFabligStock() == 2 || this.fabricationLigneAchatsIntrants.getFabligStock() == 3 || this.fabricationLigneAchatsIntrants.getFabligStock() == 4) && this.fabricationLigneAchatsIntrants.getFabligLot() != null && !this.fabricationLigneAchatsIntrants.getFabligLot().isEmpty()) {
                        this.receptionLotAchats = this.receptionLotAchatsDao.rechercheLot(this.fabricationLigneAchatsIntrants.getFabligCode(), this.fabricationLigneAchatsIntrants.getFabligDepot(), this.fabricationLigneAchatsIntrants.getFabligLot(), var1);
                        if (this.receptionLotAchats != null) {
                           this.receptionLotAchats.setReclotQteConso(this.receptionLotAchats.getReclotQteConso() - this.fabricationLigneAchatsIntrants.getFabligQte());
                           this.receptionLotAchats.setReclotQteUtilConso(this.receptionLotAchats.getReclotQteUtilConso() - this.fabricationLigneAchatsIntrants.getFabligQteUtil());
                           this.receptionLotAchats = this.receptionLotAchatsDao.modif(this.receptionLotAchats, var1);
                           this.plansAnalytiques = new PlansAnalytiques();
                           this.plansAnalytiques = this.plansAnalytiquesDao.rechercheAnal("5", this.fabricationLigneAchatsIntrants.getFabligLot(), var1);
                           if (this.plansAnalytiques != null) {
                              this.plansAnalytiques.setAnaDateModif(new Date());
                              this.plansAnalytiques.setAnaUserModif(this.usersLog.getUsrid());
                              this.plansAnalytiques.setAnaMissionFin((Date)null);
                              this.plansAnalytiques.setAnaLotEtat(0);
                              this.plansAnalytiques = this.plansAnalytiquesDao.modif(this.plansAnalytiques, var1);
                           }
                        }
                     }
                  }
               }

               Espion var9 = new Espion();
               var9.setUsers(this.usersLog);
               var9.setEsptype(0);
               var9.setEspdtecreat(new Date());
               var9.setEspaction("Dévalidation manuelle production (S.) N° " + this.fabricationEnteteAchats.getFabNum() + " du " + this.utilDate.dateToStringSQLLight(this.fabricationEnteteAchats.getFabDate()));
               this.espionDao.mAJEspion(var9, var1);
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
      } else {
         this.formRecherche.setMessageTexte("Vous n'avez pas l'autorisation de dé-valider cette production, car le dépôt de production ne fait pas parti de vos dépôts autorisés...");
         this.formRecherche.setShowModalPanelMessage(true);
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException, IOException, JDOMException {
      if (this.fabricationEnteteAchats != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.fabricationEnteteAchats.getFabNum();
            Date var4 = this.fabricationEnteteAchats.getFabDate();
            this.fabricationLigneAchatsDao.deleteAllLigne(this.fabricationEnteteAchats, var1);
            if (this.fabricationEnteteAchats.getFabStock() != 2 && this.fabricationEnteteAchats.getFabStock() != 3 && this.fabricationEnteteAchats.getFabStock() == 4) {
            }

            this.utilParapheur.supprimerParapheur(this.fabricationEnteteAchats.getFabId(), this.nature, var1);
            this.fabricationEnteteAchatsDao.delete(this.fabricationEnteteAchats.getFabId(), var1);
            this.lesEntetesList.remove(this.fabricationEnteteAchats);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            Espion var5 = new Espion();
            var5.setUsers(this.usersLog);
            var5.setEsptype(0);
            var5.setEspdtecreat(new Date());
            var5.setEspaction("Suppression production N° " + var3 + " du " + var4);
            this.espionDao.mAJEspion(var5, var1);
            var2.commit();
         } catch (HibernateException var9) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.annule();
      }

   }

   public void annule() throws IOException, JDOMException {
      this.var_action = 0;
      this.visibleOnglet = false;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.lesLignesIntrants.clear();
      this.datamodelIntrants.setWrappedData(this.lesLignesIntrants);
   }

   public void save() throws IOException, HibernateException, NamingException, Exception {
      this.majAnalytique();
      this.verifieExistenceHabilitation((Session)null);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
      this.cumulPrix();
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.fabricationEnteteAchats.setFabDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
         if (this.fabricationEnteteAchats.getUsers() == null) {
            this.fabricationEnteteAchats.setUsers(this.usersLog);
         }

         this.fabricationEnteteAchats.setFabIdEquipe(0L);
         this.fabricationEnteteAchats.setFabNomEquipe("");
         new Users();
         Users var3 = this.usersDao.selectByIdUsers(this.fabricationEnteteAchats.getFabIdResponsable(), var1);
         if (var3 != null) {
            this.fabricationEnteteAchats.setFabIdResponsable(var3.getUsrid());
            this.fabricationEnteteAchats.setFabNomResponsable(var3.getUsrPatronyme());
            this.equipes = this.equipesDao.rechercheEquipes(this.fabricationEnteteAchats.getFabIdResponsable(), var1);
            if (this.equipes != null) {
               this.fabricationEnteteAchats.setFabIdEquipe(this.equipes.getEquId());
               this.fabricationEnteteAchats.setFabNomEquipe(this.equipes.getEquNomFr());
            }
         } else {
            this.fabricationEnteteAchats.setFabIdResponsable(0L);
            this.fabricationEnteteAchats.setFabNomResponsable("");
         }

         if (this.processEnteteAchats != null && this.fabricationEnteteAchats.getFabOption2() != 2) {
            this.fabricationEnteteAchats.setFabProcess(this.processEnteteAchats.getProcesCode());
         }

         if (this.fabricationEnteteAchats.getFabId() != 0L) {
            if (this.fabricationEnteteAchats.getFabEtat() == 6) {
               if (this.fabricationEnteteAchats.getFabEtatVal() == 1) {
                  this.fabricationEnteteAchats.setFabEtat(0);
               } else {
                  this.fabricationEnteteAchats.setFabEtat(0);
               }
            }

            this.fabricationEnteteAchats.setFabDateModif(new Date());
            this.fabricationEnteteAchats.setFabIdModif(this.usersLog.getUsrid());
            this.fabricationEnteteAchats.setFabNomModif(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            this.verifieExistenceHabilitation(var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
            this.majLignes(var1);
            this.cumulPrix();
            this.fabricationEnteteAchats = this.fabricationEnteteAchatsDao.modif(this.fabricationEnteteAchats, var1);
         } else {
            if (this.fabricationEnteteAchats.getFabProcess() != null && !this.fabricationEnteteAchats.getFabProcess().isEmpty() && this.fabricationEnteteAchats.getFabProcess().equals("PAPIER")) {
               this.fabricationEnteteAchats.setFabQuart(0);
            } else {
               int var4 = this.fabricationEnteteAchatsDao.selectLastNum(this.fabricationEnteteAchats.getFabProcess(), this.fabricationEnteteAchats.getFabDate(), var1);
               this.fabricationEnteteAchats.setFabQuart(var4);
            }

            this.fabricationEnteteAchats.setExercicesAchats(this.exercicesAchats);
            this.fabricationEnteteAchats.setFabDateCreat(new Date());
            this.fabricationEnteteAchats.setFabIdCreateur(this.usersLog.getUsrid());
            this.fabricationEnteteAchats.setFabNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
            if (!this.fabricationEnteteAchats.getFabSerie().equalsIgnoreCase("X") && !this.fabricationEnteteAchats.getFabSerie().isEmpty()) {
               this.fabricationEnteteAchats.setFabNum(this.calculChrono.numCompose(this.fabricationEnteteAchats.getFabDate(), this.nature, this.fabricationEnteteAchats.getFabSerie(), var1));
               boolean var16 = false;

               label232:
               while(true) {
                  while(true) {
                     if (var16) {
                        break label232;
                     }

                     new FabricationEnteteAchats();
                     FabricationEnteteAchats var5 = this.fabricationEnteteAchatsDao.pourParapheur(this.fabricationEnteteAchats.getFabNum(), this.fabricationEnteteAchats.getFabSerie(), var1);
                     if (var5 != null) {
                        long var6 = 100000000L * this.usersLog.getUsrid();

                        for(long var8 = 0L; var8 < var6; ++var8) {
                        }

                        this.fabricationEnteteAchats.setFabNum(this.calculChrono.numCompose(this.fabricationEnteteAchats.getFabDate(), this.nature, this.fabricationEnteteAchats.getFabSerie(), var1));
                        var16 = false;
                     } else {
                        var16 = true;
                     }
                  }
               }
            } else {
               long var15 = this.fabricationEnteteAchatsDao.selectLastNum(var1);
               this.fabricationEnteteAchats.setFabNum("" + var15);
            }

            this.fabricationEnteteAchats.setFabEtat(0);
            this.fabricationEnteteAchats.setFabEtatVal(0);
            this.fabricationEnteteAchats.setFabDateValide((Date)null);
            this.fabricationEnteteAchats = this.fabricationEnteteAchatsDao.insert(this.fabricationEnteteAchats, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.fabricationEnteteAchats);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         }

         if (this.processEnteteAchats != null && this.processEnteteAchats.getProcesCreationLot() == 1 && (this.fabricationEnteteAchats.getFabNumLot() == null || this.fabricationEnteteAchats.getFabNumLot().isEmpty())) {
            String var17 = this.calculChrono.numCompose(this.fabricationEnteteAchats.getFabDate(), 38, this.fabricationEnteteAchats.getFabSerie(), var1);
            this.fabricationEnteteAchats.setFabNumLot(var17);
            this.plansAnalytiques = new PlansAnalytiques();
            this.plansAnalytiques = this.plansAnalytiquesDao.rechercheAnal("5", var17, var1);
            if (this.plansAnalytiques == null) {
               this.plansAnalytiques = new PlansAnalytiques();
               this.plansAnalytiques.setAnaDateCreat(new Date());
               this.plansAnalytiques.setAnaUserCreat(this.usersLog.getUsrid());
               this.plansAnalytiques.setAnaCode(var17);
               this.plansAnalytiques.setAnaAnnee("" + (this.fabricationEnteteAchats.getFabDate().getYear() + 1900));
               this.plansAnalytiques.setAnaMissionDebut(new Date());
               this.plansAnalytiques.setAnaMissionFin((Date)null);
               this.plansAnalytiques.setAnaNature("5");
               this.plansAnalytiques.setAnaNomFr(this.fabricationEnteteAchats.getFabLibTech());
               this.plansAnalytiques.setAnaAffaireService(this.fabricationEnteteAchats.getFabService());
               this.plansAnalytiques.setAnaLotEtat(0);
               this.plansAnalytiques = this.plansAnalytiquesDao.insert(this.plansAnalytiques, var1);
            }
         }

         if (this.lesNumSerie.size() != 0) {
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.fabricationEnteteAchats.getFabId(), this.fabricationEnteteAchats.getFabNum(), this.fabricationEnteteAchats.getFabNomResponsable(), this.fabricationEnteteAchats.getFabDate(), this.structureLog.getStrdevise(), this.fabricationEnteteAchats.getFabTotPump(), this.fabricationEnteteAchats.getFabModeleImp(), (Tiers)null, this.calculeCheminRapport(this.baseLog), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), this.structureLog.getStrformatdevise(), 0, var1);
         }

         var2.commit();
      } catch (HibernateException var13) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var13;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void majLignes(Session var1) {
      int var2;
      if (this.lesLignesIntrants.size() != 0) {
         for(var2 = 0; var2 < this.lesLignesIntrants.size(); ++var2) {
            this.fabricationLigneAchatsIntrants = (FabricationLigneAchats)this.lesLignesIntrants.get(var2);
            this.fabricationLigneAchatsIntrants.setFabligType(1);
            if (this.fabricationLigneAchatsIntrants.getFabligId() == 0L) {
               this.fabricationLigneAchatsIntrants.setFabricationEnteteAchats(this.fabricationEnteteAchats);
               this.fabricationLigneAchatsIntrants = this.fabricationLigneAchatsDao.insertLigne(this.fabricationLigneAchatsIntrants, var1);
            } else {
               this.fabricationLigneAchatsIntrants = this.fabricationLigneAchatsDao.modifLigne(this.fabricationLigneAchatsIntrants, var1);
            }
         }
      }

      if (this.lesLignesSousProduits.size() != 0) {
         for(var2 = 0; var2 < this.lesLignesSousProduits.size(); ++var2) {
            this.fabricationLigneAchatsSousProduits = (FabricationLigneAchats)this.lesLignesSousProduits.get(var2);
            this.fabricationLigneAchatsSousProduits.setFabligType(2);
            if (this.fabricationLigneAchatsSousProduits.getFabligId() == 0L) {
               this.fabricationLigneAchatsSousProduits.setFabricationEnteteAchats(this.fabricationEnteteAchats);
               this.fabricationLigneAchatsSousProduits = this.fabricationLigneAchatsDao.insertLigne(this.fabricationLigneAchatsSousProduits, var1);
            } else {
               this.fabricationLigneAchatsSousProduits = this.fabricationLigneAchatsDao.modifLigne(this.fabricationLigneAchatsSousProduits, var1);
            }
         }
      }

      if (this.lesLignesDechets.size() != 0) {
         for(var2 = 0; var2 < this.lesLignesDechets.size(); ++var2) {
            this.fabricationLigneAchatsDechets = (FabricationLigneAchats)this.lesLignesDechets.get(var2);
            if (this.fabricationLigneAchatsDechets.getFabligQte() != 0.0F) {
               this.fabricationLigneAchatsDechets.setFabligType(3);
               if (this.fabricationLigneAchatsDechets.getFabligId() == 0L) {
                  this.fabricationLigneAchatsDechets.setFabricationEnteteAchats(this.fabricationEnteteAchats);
                  this.fabricationLigneAchatsDechets = this.fabricationLigneAchatsDao.insertLigne(this.fabricationLigneAchatsDechets, var1);
               } else {
                  this.fabricationLigneAchatsDechets = this.fabricationLigneAchatsDao.modifLigne(this.fabricationLigneAchatsDechets, var1);
               }
            } else {
               this.fabricationLigneAchatsDao.deleteOneLigne(this.fabricationLigneAchatsDechets, var1);
            }
         }
      }

      if (this.lesLignesTaches.size() != 0) {
         for(var2 = 0; var2 < this.lesLignesTaches.size(); ++var2) {
            this.fabricationLigneAchatsTaches = (FabricationLigneAchats)this.lesLignesTaches.get(var2);
            this.fabricationLigneAchatsTaches.setFabligType(4);
            if (this.fabricationLigneAchatsTaches.getFabligId() == 0L) {
               this.fabricationLigneAchatsTaches.setFabricationEnteteAchats(this.fabricationEnteteAchats);
               this.fabricationLigneAchatsTaches = this.fabricationLigneAchatsDao.insertLigne(this.fabricationLigneAchatsTaches, var1);
            } else {
               this.fabricationLigneAchatsTaches = this.fabricationLigneAchatsDao.modifLigne(this.fabricationLigneAchatsTaches, var1);
            }
         }
      }

      if (this.lesLignesGeneres.size() != 0) {
         for(var2 = 0; var2 < this.lesLignesGeneres.size(); ++var2) {
            this.fabricationLigneAchatsGeneres = (FabricationLigneAchats)this.lesLignesGeneres.get(var2);
            this.fabricationLigneAchatsGeneres.setFabligType(5);
            if (this.fabricationLigneAchatsGeneres.getFabligId() == 0L) {
               this.fabricationLigneAchatsGeneres.setFabricationEnteteAchats(this.fabricationEnteteAchats);
               this.fabricationLigneAchatsGeneres = this.fabricationLigneAchatsDao.insertLigne(this.fabricationLigneAchatsGeneres, var1);
            } else {
               this.fabricationLigneAchatsGeneres = this.fabricationLigneAchatsDao.modifLigne(this.fabricationLigneAchatsGeneres, var1);
            }
         }
      }

   }

   public void majAnalytique() throws HibernateException, NamingException {
      if (this.processEnteteAchats != null) {
         this.fabricationEnteteAchats.setFabActivite(this.processEnteteAchats.getProcesActivite());
         this.fabricationEnteteAchats.setFabAtelier(this.processEnteteAchats.getProcesAtelier());
         this.fabricationEnteteAchats.setFabLigne(this.processEnteteAchats.getProcesLigne());
         this.fabricationEnteteAchats.setFabSite(this.processEnteteAchats.getProcesSite());
         this.fabricationEnteteAchats.setFabService(this.processEnteteAchats.getProcesService());
      } else {
         this.fabricationEnteteAchats.setFabSite(this.usersLog.getUsrSite());
         this.fabricationEnteteAchats.setFabLigne(this.usersLog.getUsrDepartement());
         this.fabricationEnteteAchats.setFabService(this.usersLog.getUsrService());
      }

      if (this.fabricationEnteteAchats.getFabOption2() == 2) {
         this.fabricationEnteteAchats.setFabProcess("ACTIVITE");
         this.fabricationEnteteAchats.setFabActivite(this.code_activite);
      } else if (this.fabricationEnteteAchats.getFabOption2() == 3) {
         this.fabricationEnteteAchats.setFabProcess("CHANTIER");
         this.fabricationEnteteAchats.setFabActivite(this.code_planAnalytique);
      } else if (!this.var_anal_activite) {
         this.fabricationEnteteAchats.setFabActivite("");
      } else if (this.optionAchats.getActiviteEnteteLigne().equals("0")) {
         if (this.decoupageActivite) {
            String var1 = "";
            boolean var2 = true;
            if (this.lesDecoupagesActivites.size() != 0) {
               for(int var3 = 0; var3 < this.lesDecoupagesActivites.size(); ++var3) {
                  this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var3);
                  if (this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie() != 0.0D) {
                     if (var2) {
                        var1 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                        var2 = false;
                     } else {
                        var1 = var1 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                     }
                  }
               }
            }

            this.fabricationEnteteAchats.setFabActivite(var1);
         }
      } else {
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         String var6 = "";
         boolean var7 = true;
         new Produits();
         Produits var4;
         if (this.decoupageActivite) {
            if (this.fabricationEnteteAchats.getFabProcess() != null && !this.fabricationEnteteAchats.getFabProcess().isEmpty()) {
               var4 = this.produitsDao.chargeToutProduit(this.fabricationEnteteAchats.getFabProcess(), var5);
               if (var4 != null && var4.getProActivite() != null && !var4.getProActivite().isEmpty()) {
                  if (var7) {
                     var6 = var4.getProActivite();
                     var7 = false;
                  } else {
                     var6 = var6 + "#" + var4.getProActivite();
                  }
               }
            }
         } else if (this.fabricationEnteteAchats.getFabProcess() != null && !this.fabricationEnteteAchats.getFabProcess().isEmpty()) {
            var4 = this.produitsDao.chargeToutProduit(this.fabricationEnteteAchats.getFabProcess(), var5);
            if (var4 != null && var4.getProActivite() != null && !var4.getProActivite().isEmpty()) {
               if (var7) {
                  var6 = var4.getProActivite();
                  var7 = false;
               } else {
                  var6 = var6 + "#" + var4.getProActivite();
               }
            }
         }

         this.fabricationEnteteAchats.setFabActivite(var6);
         this.utilInitHibernate.closeSession();
      }

      if (this.fabricationEnteteAchats.getFabAnal1() != null && this.fabricationEnteteAchats.getFabAnal1().length() <= 2) {
         this.fabricationEnteteAchats.setFabAnal1("");
      }

   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.fabricationEnteteAchats.setFabEtatVal(1);
         this.fabricationEnteteAchats.setFabEtat(0);
         this.fabricationEnteteAchats.setFabDateValide((Date)null);
         return true;
      } else {
         this.fabricationEnteteAchats.setFabEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.fabricationEnteteAchats.setFabEtat(1);
               this.fabricationEnteteAchats.setFabDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.fabricationEnteteAchats.setFabEtat(0);
               this.fabricationEnteteAchats.setFabDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void calculPrixGeneres() throws HibernateException, NamingException {
      this.calculPrixGeneres((Session)null);
   }

   public void calculPrixGeneres(Session var1) throws HibernateException, NamingException {
      if (this.fabricationLigneAchatsGeneres.getFabligQte() != 0.0F) {
         boolean var2 = false;
         if (var1 == null) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
            var2 = true;
         }

         this.fabricationLigneAchatsGeneres.setFabligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.fabricationLigneAchatsGeneres.getFabligCondition(), this.fabricationLigneAchatsGeneres.getFabligQte(), this.fabricationLigneAchatsGeneres.getFabligLong(), this.fabricationLigneAchatsGeneres.getFabligLarg(), this.fabricationLigneAchatsGeneres.getFabligHaut(), this.fabricationLigneAchatsGeneres.getFabligDiam(), this.fabricationLigneAchatsGeneres.getFabligNb(), this.baseLog, this.utilInitHibernate, var1));
         if (var2) {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.fabricationLigneAchatsGeneres.setFabligQteUtil(0.0F);
      }

      double var7 = 0.0D;
      if (this.fabricationLigneAchatsGeneres.getFabligCondition() != null && !this.fabricationLigneAchatsGeneres.getFabligCondition().isEmpty() && this.fabricationLigneAchatsGeneres.getFabligCondition().contains("/")) {
         String[] var4 = this.fabricationLigneAchatsGeneres.getFabligCondition().split("/");
         String[] var5 = var4[1].split(":");
         float var6 = Float.parseFloat(var5[0]);
         if (var6 == 0.0F) {
            var6 = 1.0F;
         }

         var7 = this.fabricationLigneAchatsGeneres.getFabligPump() / (double)var6 * (double)this.fabricationLigneAchatsGeneres.getFabligQteUtil();
      } else {
         var7 = this.fabricationLigneAchatsGeneres.getFabligPump() * (double)this.fabricationLigneAchatsGeneres.getFabligQteUtil();
      }

      this.totauxPump = this.utilNombre.myRoundFormat(var7, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      this.fabricationLigneAchatsGeneres.setFabligTotal(this.totauxPump);
   }

   public void calculPrixIntrants() throws HibernateException, NamingException {
      this.calculPrixIntrants((Session)null);
   }

   public void calculPrixIntrants(Session var1) throws HibernateException, NamingException {
      this.messageStockNegatif = "";
      if (this.structureLog.getStrstockNegatif() == 2) {
         if (this.produitsDepot.getProdepQteStk() < this.fabricationLigneAchatsIntrants.getFabligQte() && this.fabricationLigneAchatsIntrants.getFabligQte() != 0.0F) {
            this.validationLigne = 2;
            this.messageStockNegatif = "Quantité demandée : " + this.fabricationLigneAchatsIntrants.getFabligQte() + " Quantité en stock : " + this.produitsDepot.getProdepQteStk() + " ==> QUANTITE INSUFFISANTE";
         } else {
            this.validationLigne = 0;
         }
      } else if (this.structureLog.getStrstockNegatif() == 1) {
         if (this.produitsDepot.getProdepQteStk() < this.fabricationLigneAchatsIntrants.getFabligQte() && this.fabricationLigneAchatsIntrants.getFabligQte() != 0.0F) {
            this.validationLigne = 1;
            this.messageStockNegatif = "Quantité demandée : " + this.fabricationLigneAchatsIntrants.getFabligQte() + " Quantité en stock : " + this.produitsDepot.getProdepQteStk() + " ==> QUANTITE INSUFFISANTE";
         } else {
            this.validationLigne = 0;
         }
      } else {
         this.validationLigne = 0;
      }

      if (this.produitsDepot.getProdepQteMini() != 0.0F && this.fabricationLigneAchatsIntrants.getFabligQte() != 0.0F && this.produitsDepot.getProdepQteMini() >= this.produitsDepot.getProdepQteStk() - this.fabricationLigneAchatsIntrants.getFabligQte()) {
         this.messageStockNegatif = "Quantité en stock : " + (this.produitsDepot.getProdepQteStk() - this.fabricationLigneAchatsIntrants.getFabligQte()) + " Quantité minimale : " + this.produitsDepot.getProdepQteMini() + " ==> LA QUANTITE MINIMALE A ETE ATTEINTE";
         this.formRecherche.setMessageTexte(this.messageStockNegatif);
         this.formRecherche.setShowModalPanelMessage(true);
      }

      if (this.fabricationLigneAchatsIntrants.getFabligQte() != 0.0F) {
         boolean var2 = false;
         if (var1 == null) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
            var2 = true;
         }

         this.fabricationLigneAchatsIntrants.setFabligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.fabricationLigneAchatsIntrants.getFabligCondition(), this.fabricationLigneAchatsIntrants.getFabligQte(), this.fabricationLigneAchatsIntrants.getFabligLong(), this.fabricationLigneAchatsIntrants.getFabligLarg(), this.fabricationLigneAchatsIntrants.getFabligHaut(), this.fabricationLigneAchatsIntrants.getFabligDiam(), this.fabricationLigneAchatsIntrants.getFabligNb(), this.baseLog, this.utilInitHibernate, var1));
         if (var2) {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.fabricationLigneAchatsIntrants.setFabligQteUtil(0.0F);
      }

      double var7 = 0.0D;
      if (this.fabricationLigneAchatsIntrants.getFabligCondition() != null && !this.fabricationLigneAchatsIntrants.getFabligCondition().isEmpty() && this.fabricationLigneAchatsIntrants.getFabligCondition().contains("/")) {
         String[] var4 = this.fabricationLigneAchatsIntrants.getFabligCondition().split("/");
         String[] var5 = var4[1].split(":");
         float var6 = Float.parseFloat(var5[0]);
         if (var6 == 0.0F) {
            var6 = 1.0F;
         }

         var7 = this.fabricationLigneAchatsIntrants.getFabligPump() / (double)var6 * (double)this.fabricationLigneAchatsIntrants.getFabligQteUtil();
      } else {
         var7 = this.fabricationLigneAchatsIntrants.getFabligPump() * (double)this.fabricationLigneAchatsIntrants.getFabligQteUtil();
      }

      this.totauxPump = this.utilNombre.myRoundFormat(var7, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      this.fabricationLigneAchatsIntrants.setFabligTotal(this.totauxPump);
   }

   public void calculPrixSousProduits() throws HibernateException, NamingException {
      this.calculPrixSousProduits((Session)null);
   }

   public void calculPrixSousProduits(Session var1) throws HibernateException, NamingException {
      if (this.fabricationLigneAchatsSousProduits.getFabligQte() != 0.0F) {
         boolean var2 = false;
         if (var1 == null) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
            var2 = true;
         }

         this.fabricationLigneAchatsSousProduits.setFabligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.fabricationLigneAchatsSousProduits.getFabligCondition(), this.fabricationLigneAchatsSousProduits.getFabligQte(), this.fabricationLigneAchatsSousProduits.getFabligLong(), this.fabricationLigneAchatsSousProduits.getFabligLarg(), this.fabricationLigneAchatsSousProduits.getFabligHaut(), this.fabricationLigneAchatsSousProduits.getFabligDiam(), this.fabricationLigneAchatsSousProduits.getFabligNb(), this.baseLog, this.utilInitHibernate, var1));
         if (var2) {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.fabricationLigneAchatsSousProduits.setFabligQteUtil(0.0F);
      }

      double var7 = 0.0D;
      if (this.fabricationLigneAchatsSousProduits.getFabligCondition() != null && !this.fabricationLigneAchatsSousProduits.getFabligCondition().isEmpty() && this.fabricationLigneAchatsSousProduits.getFabligCondition().contains("/")) {
         String[] var4 = this.fabricationLigneAchatsSousProduits.getFabligCondition().split("/");
         String[] var5 = var4[1].split(":");
         float var6 = Float.parseFloat(var5[0]);
         if (var6 == 0.0F) {
            var6 = 1.0F;
         }

         var7 = this.fabricationLigneAchatsSousProduits.getFabligPump() / (double)var6 * (double)this.fabricationLigneAchatsSousProduits.getFabligQteUtil();
      } else {
         var7 = this.fabricationLigneAchatsSousProduits.getFabligPump() * (double)this.fabricationLigneAchatsSousProduits.getFabligQteUtil();
      }

      this.totauxPump = this.utilNombre.myRoundFormat(var7, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      this.fabricationLigneAchatsSousProduits.setFabligTotal(this.totauxPump);
   }

   public void calculPrixDechets() throws HibernateException, NamingException {
      this.calculPrixDechets((Session)null);
   }

   public void calculPrixDechets(Session var1) throws HibernateException, NamingException {
      if (this.fabricationLigneAchatsDechets.getFabligQte() != 0.0F) {
         boolean var2 = false;
         if (var1 == null) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
            var2 = true;
         }

         this.fabricationLigneAchatsDechets.setFabligQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.fabricationLigneAchatsDechets.getFabligCondition(), this.fabricationLigneAchatsDechets.getFabligQte(), this.fabricationLigneAchatsDechets.getFabligLong(), this.fabricationLigneAchatsDechets.getFabligLarg(), this.fabricationLigneAchatsDechets.getFabligHaut(), this.fabricationLigneAchatsDechets.getFabligDiam(), this.fabricationLigneAchatsDechets.getFabligNb(), this.baseLog, this.utilInitHibernate, var1));
         if (var2) {
            this.utilInitHibernate.closeSession();
         }
      } else {
         this.fabricationLigneAchatsDechets.setFabligQteUtil(0.0F);
      }

      double var7 = 0.0D;
      if (this.fabricationLigneAchatsDechets.getFabligCondition() != null && !this.fabricationLigneAchatsDechets.getFabligCondition().isEmpty() && this.fabricationLigneAchatsDechets.getFabligCondition().contains("/")) {
         String[] var4 = this.fabricationLigneAchatsDechets.getFabligCondition().split("/");
         String[] var5 = var4[1].split(":");
         float var6 = Float.parseFloat(var5[0]);
         if (var6 == 0.0F) {
            var6 = 1.0F;
         }

         var7 = this.fabricationLigneAchatsDechets.getFabligPump() / (double)var6 * (double)this.fabricationLigneAchatsDechets.getFabligQteUtil();
      } else {
         var7 = this.fabricationLigneAchatsDechets.getFabligPump() * (double)this.fabricationLigneAchatsDechets.getFabligQteUtil();
      }

      this.totauxPump = this.utilNombre.myRoundFormat(var7, this.utilNombre.nbDecimal(this.structureLog.getStrdevise()));
      this.fabricationLigneAchatsDechets.setFabligTotal(this.totauxPump);
   }

   public void calculPrixTaches() throws HibernateException, NamingException {
      this.calculPrixTaches((Session)null);
   }

   public void calculPrixTaches(Session var1) throws HibernateException, NamingException {
      if (this.fabricationLigneAchatsTaches != null) {
         double var2 = 0.0D;
         if (this.fabricationLigneAchatsTaches.getFabligJj() != 0) {
            var2 = (double)this.fabricationLigneAchatsTaches.getFabligJj() * this.fabricationLigneAchatsTaches.getFabligPump() * 24.0D;
         }

         if (this.fabricationLigneAchatsTaches.getFabligHh() != 0) {
            var2 += (double)this.fabricationLigneAchatsTaches.getFabligHh() * this.fabricationLigneAchatsTaches.getFabligPump();
         }

         if (this.fabricationLigneAchatsTaches.getFabligMm() != 0) {
            var2 += (double)this.fabricationLigneAchatsTaches.getFabligMm() * (this.fabricationLigneAchatsTaches.getFabligPump() / 60.0D);
         }

         if (this.fabricationLigneAchatsTaches.getFabligSs() != 0) {
            var2 += (double)this.fabricationLigneAchatsTaches.getFabligSs() * (this.fabricationLigneAchatsTaches.getFabligPump() / 3600.0D);
         }

         this.fabricationLigneAchatsTaches.setFabligTotal(var2);
      }

   }

   public void cumulPrix() {
      double var1 = 0.0D;
      new FabricationLigneAchats();

      FabricationLigneAchats var3;
      int var4;
      for(var4 = 0; var4 < this.lesLignesIntrants.size(); ++var4) {
         var3 = (FabricationLigneAchats)this.lesLignesIntrants.get(var4);
         var1 += var3.getFabligTotal();
      }

      for(var4 = 0; var4 < this.lesLignesSousProduits.size(); ++var4) {
         var3 = (FabricationLigneAchats)this.lesLignesSousProduits.get(var4);
         var1 += var3.getFabligTotal();
      }

      for(var4 = 0; var4 < this.lesLignesDechets.size(); ++var4) {
         var3 = (FabricationLigneAchats)this.lesLignesDechets.get(var4);
         var1 += var3.getFabligTotal();
      }

      for(var4 = 0; var4 < this.lesLignesTaches.size(); ++var4) {
         var3 = (FabricationLigneAchats)this.lesLignesTaches.get(var4);
         var1 += var3.getFabligTotal();
      }

      this.fabricationEnteteAchats.setFabTotPump(var1);
   }

   public void selectionLigneGeneres() throws HibernateException, NamingException {
      this.ajoutLigne = 2;
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      this.mesProduitInterchangeablesItems.clear();
      this.mesDepotsProduitsItems.clear();
      this.mesLotsItems.clear();
      if (this.datamodelGeneres.isRowAvailable()) {
         this.fabricationLigneAchatsGeneres = (FabricationLigneAchats)this.datamodelGeneres.getRowData();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         if (this.fabricationLigneAchatsGeneres.getFabligCode() != null && this.fabricationLigneAchatsGeneres.getFabligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeToutProduit(this.fabricationLigneAchatsGeneres.getFabligCode(), var1);
            if (this.produits != null) {
               if (this.modeReception != 1) {
                  this.fabricationLigneAchatsGeneres.setFabligCode(this.produits.getProCode());
                  this.fabricationLigneAchatsGeneres.setFabligLibelle(this.produits.getProLibClient());
                  this.fabricationLigneAchatsGeneres.setFabligFamille(this.produits.getProAchCode());
                  this.fabricationLigneAchatsGeneres.setFabligStock(this.produits.getProStock());
                  this.fabricationLigneAchatsGeneres.setFabligPoidsBrut(this.produits.getProPoidsBrut());
                  this.fabricationLigneAchatsGeneres.setFabligPoidsNet(this.produits.getProPoidsNet());
               }

               this.var_aff_detail_prod = true;
               this.griserchamps = true;
               this.calculeDepotProduitGeneres(var1);
               this.mesUnitesProduits = this.chargerUniteProduit(var1);
               this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
            }
         }

         this.utilInitHibernate.closeSession();
      } else {
         this.var_aff_detail_prod = false;
         this.var_aff_condit = false;
         this.griserchamps = false;
      }

   }

   public void selectionLigneIntrant() throws HibernateException, NamingException {
      this.ajoutLigne = 2;
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      this.mesProduitInterchangeablesItems.clear();
      this.mesDepotsProduitsItems.clear();
      this.mesLotsItems.clear();
      if (this.datamodelIntrants.isRowAvailable()) {
         this.fabricationLigneAchatsIntrants = (FabricationLigneAchats)this.datamodelIntrants.getRowData();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         this.var_produit_interchangeable = "";
         if (this.fabricationLigneAchatsIntrants.getFabligProduitInterchangeable() != null && !this.fabricationLigneAchatsIntrants.getFabligProduitInterchangeable().isEmpty()) {
            this.var_produit_interchangeable = this.fabricationLigneAchatsIntrants.getFabligCode() + ":" + this.fabricationLigneAchatsIntrants.getFabligLibelle();
            new Produits();
            Produits var2;
            if (!this.fabricationLigneAchatsIntrants.getFabligProduitInterchangeable().contains(":")) {
               var2 = this.produitsDao.chargeToutProduit(this.fabricationLigneAchatsIntrants.getFabligProduitInterchangeable(), var1);
               if (var2 != null) {
                  this.mesProduitInterchangeablesItems.add(new SelectItem(var2.getProCode() + ":" + var2.getProLibClient()));
               }
            } else {
               String[] var3 = this.fabricationLigneAchatsIntrants.getFabligProduitInterchangeable().split(":");
               int var4 = var3.length;

               for(int var5 = 0; var5 < var4; ++var5) {
                  String var6 = var3[var5];
                  var2 = this.produitsDao.chargeToutProduit(var6, var1);
                  if (var2 != null) {
                     this.mesProduitInterchangeablesItems.add(new SelectItem(var2.getProCode() + ":" + var2.getProLibClient()));
                  }
               }
            }
         }

         if (this.fabricationLigneAchatsIntrants.getFabligCode() != null && this.fabricationLigneAchatsIntrants.getFabligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeToutProduit(this.fabricationLigneAchatsIntrants.getFabligCode(), var1);
            if (this.produits != null) {
               this.fabricationLigneAchatsIntrants.setFabligCode(this.produits.getProCode());
               this.fabricationLigneAchatsIntrants.setFabligLibelle(this.produits.getProLibClient());
               this.fabricationLigneAchatsIntrants.setFabligFamille(this.produits.getProAchCode());
               this.fabricationLigneAchatsIntrants.setFabligStock(this.produits.getProStock());
               this.fabricationLigneAchatsIntrants.setFabligPoidsBrut(this.produits.getProPoidsBrut());
               this.fabricationLigneAchatsIntrants.setFabligPoidsNet(this.produits.getProPoidsNet());
               this.var_aff_detail_prod = true;
               this.griserchamps = true;
               this.calculeLotProduitIntrant(var1);
               this.calculeDepotProduitIntrant(var1);
               this.calculeQteDispo(var1);
               this.mesUnitesProduits = this.chargerUniteProduit(var1);
               this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
            }
         }

         this.utilInitHibernate.closeSession();
      } else {
         this.var_aff_detail_prod = false;
         this.var_aff_condit = false;
         this.griserchamps = false;
      }

   }

   public boolean controlePresenceDepot(String var1) {
      boolean var2 = false;
      if (var1 != null && !var1.isEmpty() && this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty()) {
         String[] var3 = this.usersLog.getUsrService().split(":");
         if (var1.contains(",")) {
            String[] var4 = var1.split(",");
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               String var7 = var4[var6];
               if (var7.equals(var3[0])) {
                  var2 = true;
                  break;
               }
            }
         } else if (var1.equals(var3[0])) {
            var2 = true;
         }
      }

      return var2;
   }

   public void calculeDepotInterchangeable() throws HibernateException, NamingException {
      if (this.fabricationLigneAchatsIntrants != null && this.var_produit_interchangeable != null && !this.var_produit_interchangeable.isEmpty() && this.var_produit_interchangeable.contains(":")) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         this.calculeDepotInterchangeable(var1);
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculeDepotInterchangeable(Session var1) throws HibernateException, NamingException {
      if (this.fabricationLigneAchatsIntrants != null && this.var_produit_interchangeable != null && !this.var_produit_interchangeable.isEmpty() && this.var_produit_interchangeable.contains(":")) {
         String[] var2 = this.var_produit_interchangeable.split(":");
         this.produits = this.produitsDao.chargeToutProduit(var2[0], var1);
         if (this.produits != null) {
            this.calculeDepotProduitIntrant(var1);
            this.calculeQteDispo(var1);
            this.mesUnitesProduits = this.chargerUniteProduit(var1);
            this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         }
      }

   }

   public void calculeLotProduitIntrant(Session var1) throws HibernateException, NamingException {
      this.mesLotsItems.clear();
      if (this.fabricationLigneAchatsIntrants.getFabligStock() >= 2 && this.fabricationLigneAchatsIntrants.getFabligStock() <= 4) {
         new ArrayList();
         List var2 = this.receptionLotAchatsDao.selectLotDispo(this.fabricationLigneAchatsIntrants.getFabligCode(), this.fabricationEnteteAchats.getFabDate(), var1);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               if (((ReceptionLotAchats)var2.get(var3)).getReclotNumFab() != null && !((ReceptionLotAchats)var2.get(var3)).getReclotNumFab().isEmpty()) {
                  this.mesLotsItems.add(new SelectItem(((ReceptionLotAchats)var2.get(var3)).getReclotNumero(), ((ReceptionLotAchats)var2.get(var3)).getReclotNumero() + ":" + ((ReceptionLotAchats)var2.get(var3)).getReclotDepot() + "(Fab:" + ((ReceptionLotAchats)var2.get(var3)).getReclotNumFab() + ")"));
               } else if (((ReceptionLotAchats)var2.get(var3)).getReclotNum() != null && !((ReceptionLotAchats)var2.get(var3)).getReclotNum().isEmpty()) {
                  this.mesLotsItems.add(new SelectItem(((ReceptionLotAchats)var2.get(var3)).getReclotNumero(), ((ReceptionLotAchats)var2.get(var3)).getReclotNumero() + ":" + ((ReceptionLotAchats)var2.get(var3)).getReclotDepot() + "(Ach:" + ((ReceptionLotAchats)var2.get(var3)).getReclotNum() + ")"));
               } else {
                  this.mesLotsItems.add(new SelectItem(((ReceptionLotAchats)var2.get(var3)).getReclotNumero(), ((ReceptionLotAchats)var2.get(var3)).getReclotNumero() + ":" + ((ReceptionLotAchats)var2.get(var3)).getReclotDepot()));
               }
            }

            this.calculeQteLot(var1);
         }
      }

   }

   public void calculeDepotProduitIntrant() throws HibernateException, NamingException {
      this.calculeDepotProduitIntrant((Session)null);
   }

   public void calculeDepotProduitIntrant(Session var1) throws HibernateException, NamingException {
      this.mesDepotsProduitsItems.clear();
      if (this.produits != null) {
         new ArrayList();
         Object var2 = this.produitsDepotDao.selectProdDepByprod(this.produits, var1);
         if (this.verrouDepotUser != null && !this.verrouDepotUser.isEmpty()) {
            ArrayList var3 = new ArrayList();
            int var4 = 0;

            while(true) {
               if (var4 >= ((List)var2).size()) {
                  var2 = var3;
                  break;
               }

               if (!this.verrouDepotUser.contains(",")) {
                  if (((ProduitsDepot)((List)var2).get(var4)).getDepot().getDpoCode().equals(this.verrouDepotUser)) {
                     var3.add(((List)var2).get(var4));
                  }
               } else {
                  String[] var5 = this.verrouDepotUser.split(",");
                  int var6 = var5.length;

                  for(int var7 = 0; var7 < var6; ++var7) {
                     if (((ProduitsDepot)((List)var2).get(var4)).getDepot().getDpoCode().equals(var5[var7])) {
                        var3.add(((List)var2).get(var4));
                        break;
                     }
                  }
               }

               ++var4;
            }
         }

         if (((List)var2).size() != 0) {
            for(int var8 = 0; var8 < ((List)var2).size(); ++var8) {
               if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty() && this.usersLog.getUsrProdServiceAch() == 1) {
                  if (((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoService() != null && !((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoService().isEmpty() && this.controlePresenceDepot(((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoService())) {
                     this.mesDepotsProduitsItems.add(new SelectItem(((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoCode()));
                  }
               } else if (((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoService() != null && !((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoService().isEmpty()) {
                  this.mesDepotsProduitsItems.add(new SelectItem(((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoCode()));
               } else {
                  this.mesDepotsProduitsItems.add(new SelectItem(((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoCode()));
               }
            }
         }
      }

   }

   public void calculeDepotProduitGeneres() throws HibernateException, NamingException {
      this.calculeDepotProduitGeneres((Session)null);
   }

   public void calculeDepotProduitGeneres(Session var1) throws HibernateException, NamingException {
      this.mesDepotsProduitsItems.clear();
      if (this.produits != null) {
         new ArrayList();
         Object var2 = this.produitsDepotDao.selectProdDepByprod(this.produits, var1);
         if (this.verrouDepotUser != null && !this.verrouDepotUser.isEmpty()) {
            ArrayList var3 = new ArrayList();
            int var4 = 0;

            while(true) {
               if (var4 >= ((List)var2).size()) {
                  var2 = var3;
                  break;
               }

               if (!this.verrouDepotUser.contains(",")) {
                  if (((ProduitsDepot)((List)var2).get(var4)).getDepot().getDpoCode().equals(this.verrouDepotUser)) {
                     var3.add(((List)var2).get(var4));
                  }
               } else {
                  String[] var5 = this.verrouDepotUser.split(",");
                  int var6 = var5.length;

                  for(int var7 = 0; var7 < var6; ++var7) {
                     if (((ProduitsDepot)((List)var2).get(var4)).getDepot().getDpoCode().equals(var5[var7])) {
                        var3.add(((List)var2).get(var4));
                        break;
                     }
                  }
               }

               ++var4;
            }
         }

         if (((List)var2).size() != 0) {
            for(int var8 = 0; var8 < ((List)var2).size(); ++var8) {
               if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty() && this.usersLog.getUsrProdServiceAch() == 1) {
                  if (((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoService() != null && !((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoService().isEmpty() && this.controlePresenceDepot(((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoService())) {
                     this.mesDepotsProduitsItems.add(new SelectItem(((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoCode()));
                  }
               } else if (((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoService() != null && !((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoService().isEmpty()) {
                  this.mesDepotsProduitsItems.add(new SelectItem(((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoCode()));
               } else {
                  this.mesDepotsProduitsItems.add(new SelectItem(((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoCode()));
               }
            }
         }
      }

   }

   public void calculeQteLot() throws HibernateException, NamingException {
      this.calculeQteLot((Session)null);
   }

   public void calculeQteLot(Session var1) throws HibernateException, NamingException {
      this.mesDepotsProduitsItems.clear();
      if ((this.fabricationLigneAchatsIntrants.getFabligLot() == null || this.fabricationLigneAchatsIntrants.getFabligLot().isEmpty()) && this.mesLotsItems.size() != 0) {
         this.fabricationLigneAchatsIntrants.setFabligLot(((SelectItem)this.mesLotsItems.get(0)).getValue().toString());
      }

      if (this.fabricationLigneAchatsIntrants.getFabligLot() != null && !this.fabricationLigneAchatsIntrants.getFabligLot().isEmpty()) {
         this.receptionLotAchats = this.receptionLotAchatsDao.rechercheLot(this.fabricationLigneAchatsIntrants.getFabligCode(), this.fabricationLigneAchatsIntrants.getFabligLot(), var1);
         if (this.receptionLotAchats != null) {
            this.mesDepotsProduitsItems.add(new SelectItem(this.receptionLotAchats.getReclotDepot()));
            this.fabricationLigneAchatsIntrants.setFabligDepot(this.receptionLotAchats.getReclotDepot());
            this.fabricationLigneAchatsIntrants.setFabligQteStock(this.receptionLotAchats.getReclotQteUtil() - this.receptionLotAchats.getReclotQteUtilConso());
         }
      }

      this.fusionLot();
   }

   public void calculeQteDispo() throws HibernateException, NamingException {
      this.calculeQteDispo((Session)null);
   }

   public void calculeQteDispo(Session var1) throws HibernateException, NamingException {
      this.fabricationLigneAchatsIntrants.setFabligQteStock(0.0F);
      if (this.fabricationLigneAchatsIntrants.getFabligLot() != null && !this.fabricationLigneAchatsIntrants.getFabligLot().isEmpty() && (this.fabricationLigneAchatsIntrants.getFabligStock() == 2 || this.fabricationLigneAchatsIntrants.getFabligStock() == 3 || this.fabricationLigneAchatsIntrants.getFabligStock() == 4)) {
         this.receptionLotAchats = this.receptionLotAchatsDao.rechercheLot(this.fabricationLigneAchatsIntrants.getFabligCode(), this.fabricationLigneAchatsIntrants.getFabligLot(), var1);
         if (this.receptionLotAchats != null) {
            this.mesDepotsProduitsItems.add(new SelectItem(this.receptionLotAchats.getReclotDepot()));
            this.fabricationLigneAchatsIntrants.setFabligDepot(this.receptionLotAchats.getReclotDepot());
            this.fabricationLigneAchatsIntrants.setFabligQteStock(this.receptionLotAchats.getReclotQteUtil() - this.receptionLotAchats.getReclotQteUtilConso());
         }
      } else {
         if (this.mesDepotsProduitsItems.size() != 0 && (this.fabricationLigneAchatsIntrants.getFabligDepot() == null || this.fabricationLigneAchatsIntrants.getFabligDepot().isEmpty())) {
            this.fabricationLigneAchatsIntrants.setFabligDepot(((SelectItem)this.mesDepotsProduitsItems.get(0)).getValue().toString());
         }

         if (this.fabricationLigneAchatsIntrants != null && this.fabricationLigneAchatsIntrants.getFabligCode() != null && !this.fabricationLigneAchatsIntrants.getFabligCode().isEmpty() && this.fabricationLigneAchatsIntrants.getFabligDepot() != null && !this.fabricationLigneAchatsIntrants.getFabligDepot().isEmpty()) {
            this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.fabricationLigneAchatsIntrants.getFabligCode(), this.fabricationLigneAchatsIntrants.getFabligDepot(), var1);
            if (this.produitsDepot != null) {
               this.fabricationLigneAchatsIntrants.setFabligPump(this.produitsDepot.getProdepPump());
               this.fabricationLigneAchatsIntrants.setFabligQteStock(this.produitsDepot.getProdepQteStk());
            }
         } else if (this.fabricationLigneAchatsIntrants != null && this.fabricationLigneAchatsIntrants.getFabligDepot() != null && !this.fabricationLigneAchatsIntrants.getFabligDepot().isEmpty() && this.var_produit_interchangeable != null && !this.var_produit_interchangeable.isEmpty() && this.var_produit_interchangeable.contains(":")) {
            String[] var2 = this.var_produit_interchangeable.split(":");
            this.produitsDepot = this.produitsDepotDao.produitDepByprod(var2[0], this.fabricationLigneAchatsIntrants.getFabligDepot(), var1);
            if (this.produitsDepot != null) {
               this.fabricationLigneAchatsIntrants.setFabligPump(this.produitsDepot.getProdepPump());
               this.fabricationLigneAchatsIntrants.setFabligQteStock(this.produitsDepot.getProdepQteStk());
            }
         }
      }

      this.fusionLot();
   }

   public void fusionLot() {
      this.fabricationEnteteAchats.setFabNumLot("");
      String var1 = "";
      if (this.lesLignesIntrants.size() != 0) {
         for(int var2 = 0; var2 < this.lesLignesIntrants.size(); ++var2) {
            if (((FabricationLigneAchats)this.lesLignesIntrants.get(var2)).getFabligLot() != null && !((FabricationLigneAchats)this.lesLignesIntrants.get(var2)).getFabligLot().isEmpty()) {
               if (var1 != null && !var1.isEmpty()) {
                  if (!((FabricationLigneAchats)this.lesLignesIntrants.get(var2)).getFabligLot().contains(var1)) {
                     var1 = var1 + ":" + ((FabricationLigneAchats)this.lesLignesIntrants.get(var2)).getFabligLot();
                  }
               } else {
                  var1 = ((FabricationLigneAchats)this.lesLignesIntrants.get(var2)).getFabligLot();
               }
            }
         }
      }

      this.fabricationEnteteAchats.setFabNumLot(var1);
   }

   public void selectionLigneSousProduit() throws HibernateException, NamingException {
      this.ajoutLigne = 2;
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      if (this.datamodelSousProduits.isRowAvailable()) {
         this.fabricationLigneAchatsSousProduits = (FabricationLigneAchats)this.datamodelSousProduits.getRowData();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         if (this.fabricationLigneAchatsSousProduits.getFabligCode() != null && this.fabricationLigneAchatsSousProduits.getFabligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeToutProduit(this.fabricationLigneAchatsSousProduits.getFabligCode(), var1);
            if (this.produits != null) {
               this.fabricationLigneAchatsSousProduits.setFabligCode(this.produits.getProCode());
               this.fabricationLigneAchatsSousProduits.setFabligLibelle(this.produits.getProLibClient());
               this.fabricationLigneAchatsSousProduits.setFabligFamille(this.produits.getProAchCode());
               this.fabricationLigneAchatsSousProduits.setFabligStock(this.produits.getProStock());
               this.fabricationLigneAchatsSousProduits.setFabligPoidsBrut(this.produits.getProPoidsBrut());
               this.fabricationLigneAchatsSousProduits.setFabligPoidsNet(this.produits.getProPoidsNet());
               this.var_aff_detail_prod = true;
               this.griserchamps = true;
               this.calculeDepotSousProduit(var1);
               this.calculeDepotProduitIntrant(var1);
               this.mesUnitesProduits = this.chargerUniteProduit(var1);
               this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
            }
         }

         this.utilInitHibernate.closeSession();
      } else {
         this.var_aff_detail_prod = false;
         this.var_aff_condit = false;
         this.griserchamps = false;
      }

   }

   public void calculeDepotSousProduit(Session var1) throws HibernateException, NamingException {
      this.mesDepotsProduitsItems.clear();
      if (this.produits != null) {
         new ArrayList();
         Object var2 = this.produitsDepotDao.selectProdDepByprod(this.produits, var1);
         if (this.verrouDepotUser != null && !this.verrouDepotUser.isEmpty()) {
            ArrayList var3 = new ArrayList();
            int var4 = 0;

            while(true) {
               if (var4 >= ((List)var2).size()) {
                  var2 = var3;
                  break;
               }

               if (!this.verrouDepotUser.contains(",")) {
                  if (((ProduitsDepot)((List)var2).get(var4)).getDepot().getDpoCode().equals(this.verrouDepotUser)) {
                     var3.add(((List)var2).get(var4));
                  }
               } else {
                  String[] var5 = this.verrouDepotUser.split(",");
                  int var6 = var5.length;

                  for(int var7 = 0; var7 < var6; ++var7) {
                     if (((ProduitsDepot)((List)var2).get(var4)).getDepot().getDpoCode().equals(var5[var7])) {
                        var3.add(((List)var2).get(var4));
                        break;
                     }
                  }
               }

               ++var4;
            }
         }

         if (((List)var2).size() != 0) {
            for(int var8 = 0; var8 < ((List)var2).size(); ++var8) {
               if (this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty() && this.usersLog.getUsrProdServiceAch() == 1) {
                  if (((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoService() != null && !((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoService().isEmpty() && this.controlePresenceDepot(((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoService())) {
                     this.mesDepotsProduitsItems.add(new SelectItem(((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoCode()));
                  }
               } else if (((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoService() != null && !((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoService().isEmpty()) {
                  this.mesDepotsProduitsItems.add(new SelectItem(((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoCode()));
               } else {
                  this.mesDepotsProduitsItems.add(new SelectItem(((ProduitsDepot)((List)var2).get(var8)).getDepot().getDpoCode()));
               }
            }
         }
      }

   }

   public void selectionLigneDechet() throws HibernateException, NamingException {
      this.ajoutLigne = 2;
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      this.produits = null;
      if (this.datamodelDechets.isRowAvailable()) {
         this.fabricationLigneAchatsDechets = (FabricationLigneAchats)this.datamodelDechets.getRowData();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         if (this.fabricationLigneAchatsDechets.getFabligCode() != null && this.fabricationLigneAchatsDechets.getFabligCode().length() >= 2) {
            this.produits = this.produitsDao.chargeToutProduit(this.fabricationLigneAchatsDechets.getFabligCode(), var1);
            if (this.produits != null) {
               this.fabricationLigneAchatsDechets.setFabligCode(this.produits.getProCode());
               this.fabricationLigneAchatsDechets.setFabligLibelle(this.produits.getProLibClient());
               this.fabricationLigneAchatsDechets.setFabligFamille(this.produits.getProAchCode());
               this.fabricationLigneAchatsDechets.setFabligStock(this.produits.getProStock());
               this.fabricationLigneAchatsDechets.setFabligPoidsBrut(this.produits.getProPoidsBrut());
               this.fabricationLigneAchatsDechets.setFabligPoidsNet(this.produits.getProPoidsNet());
               this.var_aff_detail_prod = true;
               this.griserchamps = true;
               this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.fabricationLigneAchatsDechets.getFabligCode(), this.fabricationLigneAchatsDechets.getFabligDepot(), var1);
               this.mesUnitesProduits = this.chargerUniteProduit(var1);
               this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
            }
         }

         this.utilInitHibernate.closeSession();
      } else {
         this.var_aff_detail_prod = false;
         this.var_aff_condit = false;
         this.griserchamps = false;
      }

   }

   public void selectionLigneTache() throws HibernateException, NamingException {
      this.ajoutLigne = 2;
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      if (this.datamodelTaches.isRowAvailable()) {
         this.fabricationLigneAchatsTaches = (FabricationLigneAchats)this.datamodelTaches.getRowData();
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         if (this.fabricationLigneAchatsTaches.getFabligCode() != null && this.fabricationLigneAchatsTaches.getFabligCode().length() >= 2) {
            this.taches = this.tachesDao.rechercheTache(this.fabricationLigneAchatsTaches.getFabligCode(), var1);
            if (this.taches != null) {
               this.fabricationLigneAchatsTaches.setFabligCode(this.taches.getTacCode());
               this.fabricationLigneAchatsTaches.setFabligLibelle(this.taches.getTacNomFr());
               this.fabricationLigneAchatsTaches.setFabligJj(this.taches.getTacValJj());
               this.fabricationLigneAchatsTaches.setFabligHh(this.taches.getTacValHh());
               this.fabricationLigneAchatsTaches.setFabligMm(this.taches.getTacValMm());
               this.fabricationLigneAchatsTaches.setFabligSs(this.taches.getTacValSs());
               this.fabricationLigneAchatsTaches.setFabligPump((double)this.taches.getTacValPr());
               this.var_aff_detail_prod = true;
               this.griserchamps = true;
               this.produitsDepot = null;
               this.mesUnitesProduits = null;
               this.mesConditionnementsProduits = null;
            }
         }

         this.utilInitHibernate.closeSession();
      } else {
         this.var_aff_detail_prod = false;
         this.var_aff_condit = false;
         this.griserchamps = false;
      }

   }

   public void addLigne() {
      this.taches = new Taches();
      this.produits = new Produits();
      this.produitsDepot = new ProduitsDepot();
      this.fabricationLigneAchatsGeneres = new FabricationLigneAchats();
      this.fabricationLigneAchatsIntrants = new FabricationLigneAchats();
      this.fabricationLigneAchatsSousProduits = new FabricationLigneAchats();
      this.fabricationLigneAchatsDechets = new FabricationLigneAchats();
      this.fabricationLigneAchatsTaches = new FabricationLigneAchats();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.validationLigne = 0;
      this.messageStockNegatif = "";
      this.mesDepotsProduitsItems.clear();
      this.ajoutLigne = 1;
   }

   public void saveOneLigneGeneres() throws IOException, HibernateException, NamingException, Exception {
      if (this.fabricationLigneAchatsGeneres.getFabligQte() != 0.0F || this.fabricationLigneAchatsGeneres.getFabligCode() != null && !this.fabricationLigneAchatsGeneres.getFabligCode().isEmpty() && (this.fabricationLigneAchatsGeneres.getFabligCode().equals("-") || this.fabricationLigneAchatsGeneres.getFabligCode().equals("+") || this.fabricationLigneAchatsGeneres.getFabligCode().equals("="))) {
         if (this.fabricationEnteteAchats.getFabId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.calculPrixGeneres(var1);
            String[] var3;
            if ((this.fabricationLigneAchatsGeneres.getFabligCode() == null || this.fabricationLigneAchatsGeneres.getFabligCode().isEmpty()) && this.fabricationLigneAchatsGeneres.getFabligDepot() != null && !this.fabricationLigneAchatsGeneres.getFabligDepot().isEmpty()) {
               var3 = this.fabricationLigneAchatsGeneres.getFabligFamille().split(":");
               long var4 = this.produitsDao.nbProduitByFamilleAch(var3[0], var1);
               String var6 = this.fabricationEnteteAchats.getFabNum() + "-" + var3[0] + "-" + var4;
               boolean var7 = true;

               while(var7) {
                  var7 = this.produitsDao.existCode(var6, var1);
                  if (var7) {
                     ++var4;
                     var6 = this.fabricationEnteteAchats.getFabNum() + "-" + var3[0] + "-" + var4;
                  } else {
                     var7 = false;
                  }
               }

               this.produits = new Produits();
               this.produits.setProDateCreat(new Date());
               this.produits.setProCode(var6);
               this.produits.setProLibClient(this.fabricationLigneAchatsGeneres.getFabligLibelle());
               this.produits.setProLibTech("");
               this.produits.setProCouleur(this.fabricationLigneAchatsGeneres.getFabligCouleur());
               this.produits.setProPoidsNet(this.fabricationLigneAchatsGeneres.getFabligPoidsNet());
               this.produits.setProLargeur(this.fabricationLigneAchatsGeneres.getFabligLarg());
               this.produits.setProLongueur(this.fabricationLigneAchatsGeneres.getFabligLong());
               this.produits.setProEpaisseur(this.fabricationLigneAchatsGeneres.getFabligHaut());
               this.produits.setProMode(0);
               if (this.famillesProduitsAchats == null) {
                  this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByCode(this.exercicesAchats.getExeachId(), var3[0], var1);
               }

               this.produits.setProAchCode(this.famillesProduitsAchats.getFamachCode());
               this.produits.setProAchLib(this.famillesProduitsAchats.getFamachLibelleFr());
               this.produits.setProAchDouane(this.fabricationLigneAchatsGeneres.getFabligDouane());
               this.produits.setProAchNat(this.famillesProduitsAchats.getFamachNature());
               this.produits.setProAchTva(this.famillesProduitsAchats.getFamachTaxe());
               this.produits.setProStock(this.famillesProduitsAchats.getFamachStock());
               this.produits.setProCondition1(this.famillesProduitsAchats.getFamachCondition1());
               this.produits.setProCondition2(this.famillesProduitsAchats.getFamachCondition2());
               this.produits.setProCondition3(this.famillesProduitsAchats.getFamachCondition3());
               this.produits.setProCondition4(this.famillesProduitsAchats.getFamachCondition4());
               this.produits.setProCondition5(this.famillesProduitsAchats.getFamachCondition5());
               new FamillesProduitsVentes();
               FamillesProduitsVentesDao var9 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
               FamillesProduitsVentes var8 = var9.rechercheFamilleByCode(this.exercicesAchats.getExeachId(), var3[0], var1);
               if (var8 != null) {
                  this.produits.setProVteCode(var8.getFamvteCode());
                  this.produits.setProVteLib(var8.getFamvteLibelleFr());
                  this.produits.setProVteNat(var8.getFamvteNature());
                  this.produits.setProVteTva(var8.getFamvteTaxe());
               } else {
                  this.produits.setProVteCode("");
                  this.produits.setProVteLib("");
                  this.produits.setProVteNat("");
                  this.produits.setProVteTva("");
               }

               this.produits.setProImpDesciption(1);
               this.produits = this.produitsDao.insert(this.produits, var1);
               this.fabricationLigneAchatsGeneres.setFabligCode(this.produits.getProCode());
            }

            if (this.fabricationLigneAchatsGeneres.getFabligProduitInterchangeable() != null && !this.fabricationLigneAchatsGeneres.getFabligProduitInterchangeable().isEmpty() && this.var_produit_interchangeable != null && !this.var_produit_interchangeable.isEmpty()) {
               var3 = this.var_produit_interchangeable.split(":");
               this.produits = this.produitsDao.chargeToutProduit(var3[0], var1);
               if (this.produits != null) {
                  this.fabricationLigneAchatsGeneres.setFabligCode(this.produits.getProCode());
                  this.fabricationLigneAchatsGeneres.setFabligLibelle(this.produits.getProLibClient());
                  this.fabricationLigneAchatsGeneres.setFabligFamille(this.produits.getProAchCode());
               }
            }

            if (this.produits != null) {
               this.fabricationLigneAchatsGeneres.setFabligType(5);
               if (this.fabricationLigneAchatsGeneres.getFabligId() == 0L) {
                  this.fabricationLigneAchatsGeneres.setFabricationEnteteAchats(this.fabricationEnteteAchats);
                  this.fabricationLigneAchatsGeneres = this.fabricationLigneAchatsDao.insertLigne(this.fabricationLigneAchatsGeneres, var1);
                  if (this.ajoutLigne == 1) {
                     this.lesLignesGeneres.add(this.fabricationLigneAchatsGeneres);
                     this.datamodelGeneres.setWrappedData(this.lesLignesGeneres);
                  }
               } else {
                  this.fabricationLigneAchatsGeneres = this.fabricationLigneAchatsDao.modifLigne(this.fabricationLigneAchatsGeneres, var1);
               }

               this.cumulPrix();
               this.fabricationEnteteAchats = this.fabricationEnteteAchatsDao.modif(this.fabricationEnteteAchats, var1);
            }

            var2.commit();
         } catch (HibernateException var13) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var13;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.addLigne();
   }

   public void saveOneLigneIntrant() throws IOException, HibernateException, NamingException, Exception {
      if (this.fabricationLigneAchatsIntrants.getFabligQte() != 0.0F || this.fabricationLigneAchatsIntrants.getFabligCode() != null && !this.fabricationLigneAchatsIntrants.getFabligCode().isEmpty() && (this.fabricationLigneAchatsIntrants.getFabligCode().equals("-") || this.fabricationLigneAchatsIntrants.getFabligCode().equals("+") || this.fabricationLigneAchatsIntrants.getFabligCode().equals("="))) {
         if (this.fabricationEnteteAchats.getFabId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.calculPrixIntrants(var1);
            if (this.fabricationLigneAchatsIntrants.getFabligProduitInterchangeable() != null && !this.fabricationLigneAchatsIntrants.getFabligProduitInterchangeable().isEmpty() && this.var_produit_interchangeable != null && !this.var_produit_interchangeable.isEmpty()) {
               String[] var3 = this.var_produit_interchangeable.split(":");
               this.produits = this.produitsDao.chargeToutProduit(var3[0], var1);
               if (this.produits != null) {
                  this.fabricationLigneAchatsIntrants.setFabligCode(this.produits.getProCode());
                  this.fabricationLigneAchatsIntrants.setFabligLibelle(this.produits.getProLibClient());
                  this.fabricationLigneAchatsIntrants.setFabligFamille(this.produits.getProAchCode());
               }
            }

            if (this.produits != null) {
               this.fabricationLigneAchatsIntrants.setFabligType(1);
               if (this.fabricationLigneAchatsIntrants.getFabligId() == 0L) {
                  this.fabricationLigneAchatsIntrants.setFabricationEnteteAchats(this.fabricationEnteteAchats);
                  this.fabricationLigneAchatsIntrants = this.fabricationLigneAchatsDao.insertLigne(this.fabricationLigneAchatsIntrants, var1);
                  if (this.ajoutLigne == 1) {
                     this.lesLignesIntrants.add(this.fabricationLigneAchatsIntrants);
                     this.datamodelIntrants.setWrappedData(this.lesLignesIntrants);
                  }
               } else {
                  this.fabricationLigneAchatsIntrants = this.fabricationLigneAchatsDao.modifLigne(this.fabricationLigneAchatsIntrants, var1);
               }

               this.cumulPrix();
               this.fabricationEnteteAchats = this.fabricationEnteteAchatsDao.modif(this.fabricationEnteteAchats, var1);
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

      this.addLigne();
   }

   public void saveOneLigneSousProduit() throws IOException, HibernateException, NamingException, Exception {
      if (this.fabricationLigneAchatsSousProduits.getFabligQte() != 0.0F || this.fabricationLigneAchatsSousProduits.getFabligCode() != null && !this.fabricationLigneAchatsSousProduits.getFabligCode().isEmpty() && (this.fabricationLigneAchatsSousProduits.getFabligCode().equals("-") || this.fabricationLigneAchatsSousProduits.getFabligCode().equals("+") || this.fabricationLigneAchatsSousProduits.getFabligCode().equals("="))) {
         if (this.fabricationEnteteAchats.getFabId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.calculPrixSousProduits(var1);
            if (this.produits != null) {
               this.fabricationLigneAchatsSousProduits.setFabligType(2);
               if (this.fabricationLigneAchatsSousProduits.getFabligId() == 0L) {
                  this.fabricationLigneAchatsSousProduits.setFabricationEnteteAchats(this.fabricationEnteteAchats);
                  this.fabricationLigneAchatsSousProduits = this.fabricationLigneAchatsDao.insertLigne(this.fabricationLigneAchatsSousProduits, var1);
                  if (this.ajoutLigne == 1) {
                     this.lesLignesSousProduits.add(this.fabricationLigneAchatsSousProduits);
                     this.datamodelSousProduits.setWrappedData(this.lesLignesSousProduits);
                  }
               } else {
                  this.fabricationLigneAchatsSousProduits = this.fabricationLigneAchatsDao.modifLigne(this.fabricationLigneAchatsSousProduits, var1);
               }

               this.cumulPrix();
               this.fabricationEnteteAchats = this.fabricationEnteteAchatsDao.modif(this.fabricationEnteteAchats, var1);
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

      this.addLigne();
   }

   public void saveOneLigneDechet() throws IOException, HibernateException, NamingException, Exception {
      if (this.fabricationLigneAchatsDechets.getFabligQte() != 0.0F || this.fabricationLigneAchatsDechets.getFabligCode() != null && !this.fabricationLigneAchatsDechets.getFabligCode().isEmpty() && (this.fabricationLigneAchatsDechets.getFabligCode().equals("-") || this.fabricationLigneAchatsDechets.getFabligCode().equals("+") || this.fabricationLigneAchatsDechets.getFabligCode().equals("="))) {
         if (this.fabricationEnteteAchats.getFabId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.calculPrixDechets(var1);
            if (this.produits != null) {
               this.fabricationLigneAchatsDechets.setFabligType(3);
               if (this.fabricationLigneAchatsDechets.getFabligId() == 0L) {
                  this.fabricationLigneAchatsDechets.setFabricationEnteteAchats(this.fabricationEnteteAchats);
                  this.fabricationLigneAchatsDechets = this.fabricationLigneAchatsDao.insertLigne(this.fabricationLigneAchatsDechets, var1);
                  if (this.ajoutLigne == 1) {
                     this.lesLignesDechets.add(this.fabricationLigneAchatsDechets);
                     this.datamodelDechets.setWrappedData(this.lesLignesDechets);
                  }
               } else {
                  this.fabricationLigneAchatsDechets = this.fabricationLigneAchatsDao.modifLigne(this.fabricationLigneAchatsDechets, var1);
               }

               this.cumulPrix();
               this.fabricationEnteteAchats = this.fabricationEnteteAchatsDao.modif(this.fabricationEnteteAchats, var1);
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

      this.addLigne();
   }

   public void saveOneLigneTache() throws IOException, HibernateException, NamingException, Exception {
      if (this.fabricationLigneAchatsTaches.getFabligQte() != 0.0F || this.fabricationLigneAchatsTaches.getFabligCode() != null && !this.fabricationLigneAchatsTaches.getFabligCode().isEmpty() && (this.fabricationLigneAchatsTaches.getFabligCode().equals("-") || this.fabricationLigneAchatsTaches.getFabligCode().equals("+") || this.fabricationLigneAchatsTaches.getFabligCode().equals("="))) {
         if (this.fabricationEnteteAchats.getFabId() == 0L) {
            this.save();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.calculPrixTaches(var1);
            if (this.taches != null) {
               this.fabricationLigneAchatsTaches.setFabligType(4);
               if (this.fabricationLigneAchatsTaches.getFabligId() == 0L) {
                  this.fabricationLigneAchatsTaches.setFabricationEnteteAchats(this.fabricationEnteteAchats);
                  this.fabricationLigneAchatsTaches = this.fabricationLigneAchatsDao.insertLigne(this.fabricationLigneAchatsTaches, var1);
                  if (this.ajoutLigne == 1) {
                     this.lesLignesTaches.add(this.fabricationLigneAchatsTaches);
                     this.datamodelTaches.setWrappedData(this.lesLignesTaches);
                  }
               } else {
                  this.fabricationLigneAchatsTaches = this.fabricationLigneAchatsDao.modifLigne(this.fabricationLigneAchatsTaches, var1);
               }

               this.cumulPrix();
               this.fabricationEnteteAchats = this.fabricationEnteteAchatsDao.modif(this.fabricationEnteteAchats, var1);
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

      this.addLigne();
   }

   public void deleteLigneGeneres() throws HibernateException, NamingException {
      if (this.fabricationLigneAchatsGeneres.getFabligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.fabricationLigneAchatsGeneres.getFabligCode();
            this.fabricationLigneAchatsDao.deleteOneLigne(this.fabricationLigneAchatsGeneres, var1);
            this.lesLignesGeneres.remove(this.fabricationLigneAchatsGeneres);
            this.datamodelGeneres.setWrappedData(this.lesLignesGeneres);
            this.addLigne();
            this.cumulPrix();
            this.var_aff_detail_prod = false;
            Espion var4 = new Espion();
            var4.setUsers(this.usersLog);
            var4.setEsptype(0);
            var4.setEspdtecreat(new Date());
            var4.setEspaction("Suppression ligne produit fabriqués " + var3 + " de la production N° " + this.fabricationEnteteAchats.getFabNum() + " du " + this.fabricationEnteteAchats.getFabDate());
            this.espionDao.mAJEspion(var4, var1);
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

   public void deleteLigneIntrant() throws HibernateException, NamingException {
      if (this.fabricationLigneAchatsIntrants.getFabligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.fabricationLigneAchatsIntrants.getFabligCode();
            this.fabricationLigneAchatsDao.deleteOneLigne(this.fabricationLigneAchatsIntrants, var1);
            this.lesLignesIntrants.remove(this.fabricationLigneAchatsIntrants);
            this.datamodelIntrants.setWrappedData(this.lesLignesIntrants);
            this.addLigne();
            this.cumulPrix();
            this.var_aff_detail_prod = false;
            Espion var4 = new Espion();
            var4.setUsers(this.usersLog);
            var4.setEsptype(0);
            var4.setEspdtecreat(new Date());
            var4.setEspaction("Suppression ligne produit intrant " + var3 + " de la production N° " + this.fabricationEnteteAchats.getFabNum() + " du " + this.fabricationEnteteAchats.getFabDate());
            this.espionDao.mAJEspion(var4, var1);
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

   public void deleteLigneSousProduit() throws HibernateException, NamingException {
      if (this.fabricationLigneAchatsSousProduits.getFabligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.fabricationLigneAchatsSousProduits.getFabligCode();
            this.fabricationLigneAchatsDao.deleteOneLigne(this.fabricationLigneAchatsSousProduits, var1);
            this.lesLignesSousProduits.remove(this.fabricationLigneAchatsSousProduits);
            this.datamodelSousProduits.setWrappedData(this.lesLignesSousProduits);
            this.addLigne();
            this.cumulPrix();
            this.var_aff_detail_prod = false;
            Espion var4 = new Espion();
            var4.setUsers(this.usersLog);
            var4.setEsptype(0);
            var4.setEspdtecreat(new Date());
            var4.setEspaction("Suppression ligne sous produit " + var3 + " de la production N° " + this.fabricationEnteteAchats.getFabNum() + " du " + this.fabricationEnteteAchats.getFabDate());
            this.espionDao.mAJEspion(var4, var1);
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

   public void deleteLigneDechet() throws HibernateException, NamingException {
      if (this.fabricationLigneAchatsDechets.getFabligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.fabricationLigneAchatsDechets.getFabligCode();
            this.fabricationLigneAchatsDao.deleteOneLigne(this.fabricationLigneAchatsDechets, var1);
            this.lesLignesDechets.remove(this.fabricationLigneAchatsDechets);
            this.datamodelDechets.setWrappedData(this.lesLignesDechets);
            this.addLigne();
            this.cumulPrix();
            this.var_aff_detail_prod = false;
            Espion var4 = new Espion();
            var4.setUsers(this.usersLog);
            var4.setEsptype(0);
            var4.setEspdtecreat(new Date());
            var4.setEspaction("Suppression ligne produit déchet " + var3 + " de la production N° " + this.fabricationEnteteAchats.getFabNum() + " du " + this.fabricationEnteteAchats.getFabDate());
            this.espionDao.mAJEspion(var4, var1);
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

   public void deleteLigneTache() throws HibernateException, NamingException {
      if (this.fabricationLigneAchatsTaches.getFabligId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.fabricationLigneAchatsTaches.getFabligCode();
            this.fabricationLigneAchatsDao.deleteOneLigne(this.fabricationLigneAchatsTaches, var1);
            this.lesLignesTaches.remove(this.fabricationLigneAchatsTaches);
            this.datamodelTaches.setWrappedData(this.lesLignesTaches);
            this.addLigne();
            this.cumulPrix();
            this.var_aff_detail_prod = false;
            Espion var4 = new Espion();
            var4.setUsers(this.usersLog);
            var4.setEsptype(0);
            var4.setEspdtecreat(new Date());
            var4.setEspaction("Suppression ligne tache " + var3 + " de la production N° " + this.fabricationEnteteAchats.getFabNum() + " du " + this.fabricationEnteteAchats.getFabDate());
            this.espionDao.mAJEspion(var4, var1);
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

   public void extractCodeUniteIntrants() throws HibernateException, NamingException {
      this.extractCodeUniteIntrants((Session)null);
   }

   public void extractCodeUniteIntrants(Session var1) throws HibernateException, NamingException {
      if (this.fabricationLigneAchatsIntrants.getFabligUnite() != null && !this.fabricationLigneAchatsIntrants.getFabligUnite().isEmpty() && this.fabricationLigneAchatsIntrants.getFabligUnite().contains(":")) {
         String[] var2 = this.fabricationLigneAchatsIntrants.getFabligUnite().split(":");
         String var3 = var2[0];
         UniteDao var4 = new UniteDao(this.baseLog, this.utilInitHibernate);
         this.var_code_unite = var4.selectUnite(var3, var1).getUniEchelle();
      } else {
         this.var_code_unite = 0;
      }

   }

   public void extractCodeUniteSousProduits() throws HibernateException, NamingException {
      this.extractCodeUniteSousProduits((Session)null);
   }

   public void extractCodeUniteSousProduits(Session var1) throws HibernateException, NamingException {
      if (this.fabricationLigneAchatsSousProduits.getFabligUnite() != null && !this.fabricationLigneAchatsSousProduits.getFabligUnite().isEmpty() && this.fabricationLigneAchatsSousProduits.getFabligUnite().contains(":")) {
         String[] var2 = this.fabricationLigneAchatsSousProduits.getFabligUnite().split(":");
         String var3 = var2[0];
         UniteDao var4 = new UniteDao(this.baseLog, this.utilInitHibernate);
         this.var_code_unite = var4.selectUnite(var3, var1).getUniEchelle();
      } else {
         this.var_code_unite = 0;
      }

   }

   public void extractCodeUniteDechets() throws HibernateException, NamingException {
      this.extractCodeUniteDechets((Session)null);
   }

   public void extractCodeUniteDechets(Session var1) throws HibernateException, NamingException {
      if (this.fabricationLigneAchatsDechets.getFabligUnite() != null && !this.fabricationLigneAchatsDechets.getFabligUnite().isEmpty() && this.fabricationLigneAchatsDechets.getFabligUnite().contains(":")) {
         String[] var2 = this.fabricationLigneAchatsDechets.getFabligUnite().split(":");
         String var3 = var2[0];
         UniteDao var4 = new UniteDao(this.baseLog, this.utilInitHibernate);
         this.var_code_unite = var4.selectUnite(var3, var1).getUniEchelle();
      } else {
         this.var_code_unite = 0;
      }

   }

   public void calculDateProduction() {
      this.lesDatesItems.clear();
   }

   public void selectionLignePoulet() throws HibernateException, NamingException {
      if (this.datamodelEntete.isRowAvailable()) {
         this.receptionEnteteAchats = (ReceptionEnteteAchats)this.datamodelEntete.getRowData();
         this.var_date = this.receptionEnteteAchats.getRecDate();
         this.var_depot_production = "";
         if (this.receptionEnteteAchats.getRecDate().getHours() <= 9) {
            this.var_heure = "0" + this.receptionEnteteAchats.getRecDate().getHours();
         } else {
            this.var_heure = "" + this.receptionEnteteAchats.getRecDate().getHours();
         }

         if (this.receptionEnteteAchats.getRecDate().getMinutes() <= 9) {
            this.var_minute = "0" + this.receptionEnteteAchats.getRecDate().getMinutes();
         } else {
            this.var_minute = "" + this.receptionEnteteAchats.getRecDate().getMinutes();
         }

         if (this.receptionEnteteAchats.getRecDate().getSeconds() <= 9) {
            this.var_seconde = "0" + this.receptionEnteteAchats.getRecDate().getSeconds();
         } else {
            this.var_seconde = "" + this.receptionEnteteAchats.getRecDate().getSeconds();
         }

         this.var_methode = false;
         this.var_piege = false;
         this.var_commande = false;
         this.nbIndividusAnte = 0;
         this.nbIndividusReste = 0;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ReceptionEnteteLight");
         this.processEnteteAchats = null;
         this.chargerDocumentLignePoulet(var1);
         this.utilInitHibernate.closeSession();
         this.montantPump = this.fabricationEnteteAchats.getFabTotPump();
         this.verrouNum = true;
         this.visibiliteBton = true;
      } else {
         this.visibiliteBton = false;
      }

   }

   public void chargerDocumentLignePoulet(Session var1) throws HibernateException, NamingException {
      this.lesPlaningsAviculture.clear();
      this.lesDatesItems.clear();
      if (this.receptionEnteteAchats != null) {
         this.lesPlaningsAviculture = this.receptionAvicultureAchatsDao.chargerLesLignes(this.receptionEnteteAchats, var1);
         if (this.lesPlaningsAviculture.size() != 0) {
            for(int var2 = 0; var2 < this.lesPlaningsAviculture.size(); ++var2) {
               this.lesDatesItems.add(new SelectItem(this.utilDate.dateToStringFr(((ReceptionAvicultureAchats)this.lesPlaningsAviculture.get(var2)).getRecaviDate())));
            }
         }
      }

      this.datamodelIntrants.setWrappedData(this.lesPlaningsAviculture);
   }

   public void modifierPoulet() throws ParseException, HibernateException, NamingException {
      if (this.receptionEnteteAchats != null) {
         this.var_date = new Date();
         this.dateJour = this.utilDate.dateToStringFr(this.var_date);
         this.chargerJour();
         this.showModalPanelPlanning = true;
      }

   }

   public void chargerJour() throws ParseException, HibernateException, NamingException {
      this.nbIndividusAnte = 0;
      this.nbIndividusReste = 0;
      int var1 = 0;
      int var2 = 0;
      if (this.dateJour != null && !this.dateJour.isEmpty()) {
         new ArrayList();
         ReceptionLigneAchatsDao var4 = new ReceptionLigneAchatsDao(this.baseLog, this.utilInitHibernate);
         List var3 = var4.chargerLesLignes((ReceptionEnteteAchats)this.receptionEnteteAchats, (Session)null);
         if (var3.size() != 0) {
            for(int var5 = 0; var5 < var3.size(); ++var5) {
               var1 = (int)((float)var1 + ((ReceptionLigneAchats)var3.get(var5)).getRecligQte());
            }
         }

         String[] var9 = this.dateJour.split("-");
         Date var6 = this.utilDate.dateJourPrecedent(this.utilDate.stringToDateSQLLight(var9[2] + "-" + var9[1] + "-" + var9[0]));
         if (this.lesPlaningsAviculture.size() != 0) {
            for(int var7 = 0; var7 < this.lesPlaningsAviculture.size(); ++var7) {
               if (((ReceptionAvicultureAchats)this.lesPlaningsAviculture.get(var7)).getRecaviDate().compareTo(var6) <= 0) {
                  var2 += ((ReceptionAvicultureAchats)this.lesPlaningsAviculture.get(var7)).getRecaviNbMortaliteReel();
               }
            }
         }

         boolean var10 = false;
         var6 = this.utilDate.stringToDateSQLLight(var9[2] + "-" + var9[1] + "-" + var9[0]);
         if (this.lesPlaningsAviculture.size() != 0) {
            for(int var8 = 0; var8 < this.lesPlaningsAviculture.size(); ++var8) {
               if (((ReceptionAvicultureAchats)this.lesPlaningsAviculture.get(var8)).getRecaviDate().compareTo(var6) == 0) {
                  this.receptionAvicultureAchats = (ReceptionAvicultureAchats)this.lesPlaningsAviculture.get(var8);
                  var10 = true;
                  break;
               }
            }
         }

         if (!var10) {
            this.receptionAvicultureAchats = new ReceptionAvicultureAchats();
         }
      } else {
         this.receptionAvicultureAchats = new ReceptionAvicultureAchats();
      }

      this.nbIndividusAnte = var1 - var2;
      this.nbIndividusReste = this.nbIndividusAnte - this.receptionAvicultureAchats.getRecaviNbMortaliteReel();
   }

   public void fermerPlanning() {
      this.showModalPanelPlanning = false;
   }

   public void validePlanning() throws HibernateException, NamingException {
      if (this.receptionAvicultureAchats != null) {
         this.receptionAvicultureAchats = this.receptionAvicultureAchatsDao.modifLigne(this.receptionAvicultureAchats);
      }

      this.showModalPanelPlanning = false;
   }

   public void calculReste() {
      this.nbIndividusReste = this.nbIndividusAnte - this.receptionAvicultureAchats.getRecaviNbMortaliteReel();
   }

   public void consulterPoulet() {
      if (this.receptionEnteteAchats != null) {
         this.var_action = 3;
         this.var_memo_action = this.var_action;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
      }

   }

   public void calculFamille() throws HibernateException, NamingException {
      if (this.fabricationLigneAchatsGeneres.getFabligFamille() != null && !this.fabricationLigneAchatsGeneres.getFabligFamille().isEmpty() && this.fabricationLigneAchatsGeneres.getFabligFamille().contains(":")) {
         this.mesDepotsProduitsItems.clear();
         this.var_depot_famille = false;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "FamillesProduitsAchats");
         String[] var2 = this.fabricationLigneAchatsGeneres.getFabligFamille().split(":");
         this.famillesProduitsAchats = this.famillesProduitsAchatsDao.rechercheFamilleByCode(this.exercicesAchats.getExeachId(), var2[0], var1);
         if (this.famillesProduitsAchats != null) {
            this.fabricationLigneAchatsGeneres.setFabligDouane(this.famillesProduitsAchats.getFamachDouane());
            this.fabricationLigneAchatsGeneres.setFabligTauxDouane(0.0F);
            if (this.famillesProduitsAchats.getFamachStock() >= 1) {
               this.var_depot_famille = true;
               this.depotAchatsDao = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
               new ArrayList();
               List var3 = this.depotAchatsDao.selectActifDepot(13, var1);
               if (var3.size() != 0) {
                  for(int var4 = 0; var4 < var3.size(); ++var4) {
                     DepotAchats var5 = (DepotAchats)var3.get(var4);
                     this.mesDepotsProduitsItems.add(new SelectItem(var5.getDpoCode() + "=0.0"));
                  }
               }
            }
         }

         this.utilInitHibernate.closeSession();
         this.calculLibelle();
      }

   }

   public void calculMode() {
      if (this.fabricationLigneAchatsGeneres.getFabligModePapier() == 0) {
         this.fabricationLigneAchatsGeneres.setFabligLarg(0.0F);
      } else if (this.fabricationLigneAchatsGeneres.getFabligModePapier() == 1) {
         this.fabricationLigneAchatsGeneres.setFabligLong(0.0F);
         this.fabricationLigneAchatsGeneres.setFabligHaut(0.0F);
      }

      this.calculLibelle();
   }

   public void calculLibelle() {
      String var1 = "";
      if (this.fabricationLigneAchatsGeneres.getFabligFamille() != null && !this.fabricationLigneAchatsGeneres.getFabligFamille().isEmpty() && this.fabricationLigneAchatsGeneres.getFabligFamille().contains(":")) {
         String[] var2 = this.fabricationLigneAchatsGeneres.getFabligFamille().split(":");
         var1 = var2[1];
      } else if (this.fabricationLigneAchatsGeneres.getFabligFamille() != null && !this.fabricationLigneAchatsGeneres.getFabligFamille().isEmpty() && !this.fabricationLigneAchatsGeneres.getFabligFamille().contains(":")) {
         var1 = this.famillesProduitsAchats.getFamachLibelleFr();
      }

      if (this.fabricationLigneAchatsGeneres.getFabligGr() != 0.0F) {
         var1 = var1 + " Grs " + this.fabricationLigneAchatsGeneres.getFabligGr();
      }

      if (this.fabricationLigneAchatsGeneres.getFabligCouleur() != null && !this.fabricationLigneAchatsGeneres.getFabligCouleur().isEmpty()) {
         var1 = var1 + " " + this.fabricationLigneAchatsGeneres.getFabligCouleur();
      }

      if (this.fabricationLigneAchatsGeneres.getFabligLarg() != 0.0F) {
         var1 = var1 + " Laize " + this.fabricationLigneAchatsGeneres.getFabligLarg();
      }

      if (this.fabricationLigneAchatsGeneres.getFabligHaut() != 0.0F && this.fabricationLigneAchatsGeneres.getFabligLong() != 0.0F) {
         var1 = var1 + " " + this.fabricationLigneAchatsGeneres.getFabligHaut() + "x" + this.fabricationLigneAchatsGeneres.getFabligLong();
      }

      this.fabricationLigneAchatsGeneres.setFabligLibelle(var1);
   }

   public void calculQtePapierIntrant() {
      float var1 = 0.0F;
      float var2 = 0.0F;
      float var3 = 0.0F;
      float var4 = 0.0F;
      if (this.fabricationLigneAchatsIntrants.getFabligGr() == 0.0F) {
         var1 = 1.0F;
      } else {
         var1 = this.fabricationLigneAchatsIntrants.getFabligGr();
      }

      if (this.fabricationLigneAchatsIntrants.getFabligHaut() == 0.0F) {
         var2 = 1.0F;
      } else {
         var2 = this.fabricationLigneAchatsIntrants.getFabligHaut();
      }

      if (this.fabricationLigneAchatsIntrants.getFabligLong() == 0.0F) {
         var3 = 1.0F;
      } else {
         var3 = this.fabricationLigneAchatsIntrants.getFabligLong();
      }

      if (this.fabricationLigneAchatsIntrants.getFabligLarg() == 0.0F) {
         var4 = 1.0F;
      } else {
         var4 = this.fabricationLigneAchatsIntrants.getFabligLarg();
      }

      if (this.fabricationLigneAchatsIntrants.getFabligModePapier() == 0) {
         float var5;
         if (this.fabricationLigneAchatsIntrants.getFabligQte() == 0.0F && this.fabricationLigneAchatsIntrants.getFabligPoidsNet() != 0.0F) {
            var5 = this.utilNombre.myRound(this.fabricationLigneAchatsIntrants.getFabligPoidsNet() / (var1 * var2 * var3 * var4) * 1.0E7F, 0);
            this.fabricationLigneAchatsIntrants.setFabligQte(var5);
         } else if (this.fabricationLigneAchatsIntrants.getFabligQte() != 0.0F && this.fabricationLigneAchatsIntrants.getFabligPoidsNet() == 0.0F) {
            var5 = this.utilNombre.myRound(this.fabricationLigneAchatsIntrants.getFabligQte() * var1 * var2 * var3 * var4 / 1.0E7F, 2);
            this.fabricationLigneAchatsIntrants.setFabligPoidsNet(var5);
         } else {
            this.fabricationLigneAchatsIntrants.setFabligQte(0.0F);
            var5 = this.utilNombre.myRound(this.fabricationLigneAchatsIntrants.getFabligPoidsNet() / (var1 * var2 * var3 * var4) * 1.0E7F, 0);
            this.fabricationLigneAchatsIntrants.setFabligQte(var5);
         }
      } else if (this.fabricationLigneAchatsIntrants.getFabligModePapier() == 1) {
         this.fabricationLigneAchatsIntrants.setFabligQte(this.fabricationLigneAchatsIntrants.getFabligPoidsNet());
      } else {
         this.fabricationLigneAchatsIntrants.setFabligQte(this.fabricationLigneAchatsIntrants.getFabligPoidsNet());
      }

      this.fabricationLigneAchatsIntrants.setFabligQteUtil(this.fabricationLigneAchatsIntrants.getFabligQte());
   }

   public void calculQtePapier() {
      float var1 = 0.0F;
      float var2 = 0.0F;
      float var3 = 0.0F;
      float var4 = 0.0F;
      if (this.fabricationLigneAchatsGeneres.getFabligGr() == 0.0F) {
         var1 = 1.0F;
      } else {
         var1 = this.fabricationLigneAchatsGeneres.getFabligGr();
      }

      if (this.fabricationLigneAchatsGeneres.getFabligHaut() == 0.0F) {
         var2 = 1.0F;
      } else {
         var2 = this.fabricationLigneAchatsGeneres.getFabligHaut();
      }

      if (this.fabricationLigneAchatsGeneres.getFabligLong() == 0.0F) {
         var3 = 1.0F;
      } else {
         var3 = this.fabricationLigneAchatsGeneres.getFabligLong();
      }

      if (this.fabricationLigneAchatsGeneres.getFabligLarg() == 0.0F) {
         var4 = 1.0F;
      } else {
         var4 = this.fabricationLigneAchatsGeneres.getFabligLarg();
      }

      if (this.fabricationLigneAchatsGeneres.getFabligModePapier() == 0) {
         float var5;
         if (this.fabricationLigneAchatsGeneres.getFabligQte() == 0.0F && this.fabricationLigneAchatsGeneres.getFabligPoidsNet() != 0.0F) {
            var5 = this.utilNombre.myRound(this.fabricationLigneAchatsGeneres.getFabligPoidsNet() / (var1 * var2 * var3 * var4) * 1.0E7F, 0);
            this.fabricationLigneAchatsGeneres.setFabligQte(var5);
         } else if (this.fabricationLigneAchatsGeneres.getFabligQte() != 0.0F && this.fabricationLigneAchatsGeneres.getFabligPoidsNet() == 0.0F) {
            var5 = this.utilNombre.myRound(this.fabricationLigneAchatsGeneres.getFabligQte() * var1 * var2 * var3 * var4 / 1.0E7F, 2);
            this.fabricationLigneAchatsGeneres.setFabligPoidsNet(var5);
         } else {
            this.fabricationLigneAchatsGeneres.setFabligQte(0.0F);
            var5 = this.utilNombre.myRound(this.fabricationLigneAchatsGeneres.getFabligPoidsNet() / (var1 * var2 * var3 * var4) * 1.0E7F, 0);
            this.fabricationLigneAchatsGeneres.setFabligQte(var5);
         }
      } else if (this.fabricationLigneAchatsGeneres.getFabligModePapier() == 1) {
         this.fabricationLigneAchatsGeneres.setFabligQte(this.fabricationLigneAchatsGeneres.getFabligPoidsNet());
      } else {
         this.fabricationLigneAchatsGeneres.setFabligQte(this.fabricationLigneAchatsGeneres.getFabligPoidsNet());
      }

      this.fabricationLigneAchatsGeneres.setFabligQteUtil(this.fabricationLigneAchatsGeneres.getFabligQte());
   }

   public void rechercheProduits() throws JDOMException, IOException, HibernateException, NamingException {
      String var1 = "";
      if (this.typeProduits == 1) {
         var1 = this.fabricationLigneAchatsIntrants.getFabligCode();
      } else if (this.typeProduits == 2) {
         var1 = this.fabricationLigneAchatsSousProduits.getFabligCode();
      } else if (this.typeProduits == 3) {
      }

      if (var1 != null && !var1.isEmpty()) {
         this.produits = this.formRecherche.rechercheProduitTout(var1, this.nature);
         if (this.produits != null) {
            if (this.produits.getProId() != 0L) {
               this.calculeProduits();
            } else {
               this.var_action = 15;
            }
         } else if (this.produits == null) {
            this.calculeProduits();
         }
      }

   }

   public void recuperationProduit() throws JDOMException, IOException, HibernateException, NamingException {
      this.produits = this.formRecherche.calculeProduit();
      this.calculeProduits();
   }

   public void calculeProduits() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.produits != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         if (this.typeProduits == 1) {
            this.fabricationLigneAchatsIntrants.setFabligCode(this.produits.getProCode());
            this.fabricationLigneAchatsIntrants.setFabligLibelle(this.produits.getProLibClient());
            if (this.produits.getProAchCode() != null && !this.produits.getProAchCode().isEmpty()) {
               this.fabricationLigneAchatsIntrants.setFabligFamille(this.produits.getProAchCode());
            } else {
               this.fabricationLigneAchatsIntrants.setFabligFamille(this.produits.getProVteCode());
            }

            this.fabricationLigneAchatsIntrants.setFabligReference("");
            if (this.modeReception == 1) {
               new ReceptionLigneAchats();
               ReceptionLigneAchatsDao var3 = new ReceptionLigneAchatsDao(this.baseLog, this.utilInitHibernate);
               ReceptionLigneAchats var2 = var3.rechercheReception(this.produits.getProCode(), var1);
               if (var2 != null) {
                  this.fabricationLigneAchatsIntrants.setFabligModePapier(var2.getRecligMode());
                  this.fabricationLigneAchatsIntrants.setFabligCouleur(var2.getRecligCouleur());
                  this.fabricationLigneAchatsIntrants.setFabligGr(var2.getRecligGr());
                  this.fabricationLigneAchatsIntrants.setFabligHaut(var2.getRecligHaut());
                  this.fabricationLigneAchatsIntrants.setFabligLong(var2.getRecligLong());
                  this.fabricationLigneAchatsIntrants.setFabligLarg(var2.getRecligLarg());
                  this.fabricationLigneAchatsIntrants.setFabligPump(var2.getRecligPump());
               } else {
                  this.fabricationLigneAchatsIntrants.setFabligModePapier(0);
                  this.fabricationLigneAchatsIntrants.setFabligCouleur("");
                  this.fabricationLigneAchatsIntrants.setFabligGr(0.0F);
                  this.fabricationLigneAchatsIntrants.setFabligHaut(0.0F);
                  this.fabricationLigneAchatsIntrants.setFabligLong(0.0F);
                  this.fabricationLigneAchatsIntrants.setFabligLarg(0.0F);
                  this.fabricationLigneAchatsIntrants.setFabligPump(0.0D);
               }

               this.fabricationLigneAchatsIntrants.setFabligPoidsBrut(0.0F);
               this.fabricationLigneAchatsIntrants.setFabligPoidsNet(0.0F);
               this.fabricationLigneAchatsIntrants.setFabligVolume(0.0F);
            } else {
               this.fabricationLigneAchatsIntrants.setFabligModePapier(0);
               this.fabricationLigneAchatsIntrants.setFabligLong(this.produits.getProLongueur());
               this.fabricationLigneAchatsIntrants.setFabligLarg(this.produits.getProLargeur());
               this.fabricationLigneAchatsIntrants.setFabligHaut(this.produits.getProEpaisseur());
               this.fabricationLigneAchatsIntrants.setFabligPoidsBrut(this.produits.getProPoidsBrut());
               this.fabricationLigneAchatsIntrants.setFabligPoidsNet(this.produits.getProPoidsNet());
               this.fabricationLigneAchatsIntrants.setFabligVolume(this.produits.getProVolume());
            }

            this.calculeLotProduitIntrant(var1);
            this.calculeDepotProduitIntrant(var1);
            this.calculeQteDispo(var1);
            this.griserchamps = true;
            this.var_aff_detail_prod = true;
            this.calculPrixIntrants(var1);
            this.ajoutLigne = 1;
         } else if (this.typeProduits != 2) {
            if (this.typeProduits == 3) {
            }
         } else {
            this.fabricationLigneAchatsSousProduits.setFabligCode(this.produits.getProCode());
            this.fabricationLigneAchatsSousProduits.setFabligLibelle(this.produits.getProLibClient());
            if (this.produits.getProAchCode() != null && !this.produits.getProAchCode().isEmpty()) {
               this.fabricationLigneAchatsSousProduits.setFabligFamille(this.produits.getProAchCode());
            } else {
               this.fabricationLigneAchatsSousProduits.setFabligFamille(this.produits.getProVteCode());
            }

            this.fabricationLigneAchatsIntrants.setFabligLong(this.produits.getProLongueur());
            this.fabricationLigneAchatsIntrants.setFabligLarg(this.produits.getProLargeur());
            this.fabricationLigneAchatsIntrants.setFabligHaut(this.produits.getProEpaisseur());
            this.fabricationLigneAchatsIntrants.setFabligPoidsBrut(this.produits.getProPoidsBrut());
            this.fabricationLigneAchatsIntrants.setFabligPoidsNet(this.produits.getProPoidsNet());
            this.fabricationLigneAchatsIntrants.setFabligVolume(this.produits.getProVolume());
            this.fabricationLigneAchatsSousProduits.setFabligReference("");
            this.calculeDepotSousProduit(var1);
            this.calculeDepotProduitIntrant(var1);
            this.griserchamps = true;
            this.var_aff_detail_prod = true;
            this.calculPrixSousProduits(var1);
            this.ajoutLigne = 1;
         }

         this.utilInitHibernate.closeSession();
      } else {
         this.annuleProduits();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleProduits() {
      this.produits = null;
      if (this.typeProduits == 1) {
         this.fabricationLigneAchatsIntrants.setFabligCode("");
         this.fabricationLigneAchatsIntrants.setFabligLibelle("");
      } else if (this.typeProduits == 2) {
         this.fabricationLigneAchatsSousProduits.setFabligCode("");
         this.fabricationLigneAchatsSousProduits.setFabligLibelle("");
      } else if (this.typeProduits == 3) {
         this.fabricationLigneAchatsDechets.setFabligCode("");
         this.fabricationLigneAchatsDechets.setFabligLibelle("");
      }

      this.mesConditionnementsProduits.clear();
      this.mesUnitesProduits.clear();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.var_aff_condit = false;
      this.var_aff_unite = false;
      this.var_code_unite = 0;
      this.var_action = this.var_memo_action;
   }

   public List chargerUniteProduit(Session var1) throws HibernateException, NamingException {
      this.mesUnitesProduits.clear();
      if (this.produits != null && this.produitsDepot != null) {
         if (this.produitsDepot.getProdepUnite() != null && !this.produitsDepot.getProdepUnite().isEmpty()) {
            this.mesUnitesProduits.add(new SelectItem(this.produitsDepot.getProdepUnite()));
         }
      } else {
         if (this.mesUnitesItems.size() == 0) {
            this.mesUnitesItems = this.uniteDao.chargerLesUnitesItems(var1);
         }

         this.mesUnitesProduits = this.mesUnitesItems;
      }

      if (this.mesUnitesProduits.size() != 0) {
         this.var_aff_unite = true;
      } else {
         this.var_aff_unite = false;
      }

      return this.mesUnitesProduits;
   }

   public List chargerConditionnementProduit(Session var1) {
      this.mesConditionnementsProduits.clear();
      this.mesConditionnementsProduits = this.calculStock.calculConditionnementStock((List)null, this.produits, this.produitsDepot, var1);
      if (this.mesConditionnementsProduits.size() != 0) {
         this.var_aff_condit = true;
      } else {
         this.var_aff_condit = false;
      }

      return this.mesConditionnementsProduits;
   }

   public void detailProduitIntrant() {
      if (this.fabricationLigneAchatsIntrants != null && this.produits != null) {
         if (this.produits.getProPhoto() != null) {
            this.formRecherche.setUrlphotoProd(this.urlphotoProd);
         } else {
            this.urlphotoProd = "";
            this.formRecherche.setUrlphotoProd(this.urlphotoProd);
         }

         this.formRecherche.setProduits(this.produits);
         this.formRecherche.setNature(this.nature);
         this.var_action = 13;
      }

   }

   public void detailProduitSousProduit() {
      if (this.fabricationLigneAchatsSousProduits != null && this.produits != null) {
         if (this.produits.getProPhoto() != null) {
            this.formRecherche.setUrlphotoProd(this.urlphotoProd);
         } else {
            this.urlphotoProd = "";
            this.formRecherche.setUrlphotoProd(this.urlphotoProd);
         }

         this.formRecherche.setProduits(this.produits);
         this.formRecherche.setNature(this.nature);
         this.var_action = 13;
      }

   }

   public void detailProduitDechet() {
      if (this.fabricationLigneAchatsDechets != null && this.produits != null) {
         if (this.produits.getProPhoto() != null) {
            this.formRecherche.setUrlphotoProd(this.urlphotoProd);
         } else {
            this.urlphotoProd = "";
            this.formRecherche.setUrlphotoProd(this.urlphotoProd);
         }

         this.formRecherche.setProduits(this.produits);
         this.formRecherche.setNature(this.nature);
         this.var_action = 13;
      }

   }

   public void annuleDetailProduit() {
      this.var_action = this.var_memo_action;
   }

   public void rechercheActivites() throws JDOMException, IOException, HibernateException, NamingException {
      String var1 = "";
      if (this.code_activite != null && !this.code_activite.isEmpty()) {
         if (this.code_activite.contains(":")) {
            String[] var2 = this.code_activite.split(":");
            var1 = var2[0];
         } else {
            var1 = this.code_activite;
         }
      }

      if (var1 != null && !var1.isEmpty()) {
         this.activites = this.formRecherche.rechercheActivites(var1, this.nature);
         if (this.activites != null) {
            if (this.activites.getActId() != 0L) {
               this.calculeActivites();
            } else {
               this.var_action = 17;
            }
         } else if (this.activites == null) {
            this.calculeActivites();
         }
      }

   }

   public void recuperationActivites() throws JDOMException, IOException, HibernateException, NamingException {
      this.activites = this.formRecherche.calculeActivite();
      this.calculeActivites();
   }

   public void calculeActivites() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.activites != null) {
         this.code_activite = this.activites.getActCode() + ":" + this.activites.getActNomFr();
      } else {
         this.annuleActivites();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleActivites() {
      this.activites = null;
      this.code_activite = "";
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.var_aff_condit = false;
      this.var_aff_unite = false;
      this.var_code_unite = 0;
      this.var_action = this.var_memo_action;
   }

   public void rechercheChantiers() throws JDOMException, IOException, HibernateException, NamingException {
      String var1 = "";
      if (this.code_planAnalytique != null && !this.code_planAnalytique.isEmpty()) {
         if (this.code_planAnalytique.contains(":")) {
            String[] var2 = this.code_planAnalytique.split(":");
            var1 = var2[0];
         } else {
            var1 = this.code_planAnalytique;
         }
      }

      if (var1 != null && !var1.isEmpty()) {
         this.plansAnalytiques = this.formRecherche.rechercheChantiers(var1, this.nature);
         if (this.plansAnalytiques != null) {
            if (this.plansAnalytiques.getAnaId() != 0L) {
               this.calculeChantiers();
            } else {
               this.var_action = 18;
            }
         } else if (this.plansAnalytiques == null) {
            this.calculeChantiers();
         }
      }

   }

   public void recuperationChantiers() throws JDOMException, IOException, HibernateException, NamingException {
      this.plansAnalytiques = this.formRecherche.calculeChantier();
      this.calculeChantiers();
   }

   public void calculeChantiers() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.plansAnalytiques != null) {
         this.code_planAnalytique = this.plansAnalytiques.getAnaCode() + ":" + this.plansAnalytiques.getAnaNomFr();
      } else {
         this.annuleChantiers();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleChantiers() {
      this.plansAnalytiques = null;
      this.code_planAnalytique = "";
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.var_aff_condit = false;
      this.var_aff_unite = false;
      this.var_code_unite = 0;
      this.var_action = this.var_memo_action;
   }

   public void rechercheTaches() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.fabricationLigneAchatsTaches.getFabligCode() != null && !this.fabricationLigneAchatsTaches.getFabligCode().isEmpty()) {
         this.taches = this.formRecherche.rechercheTaches(this.fabricationLigneAchatsTaches.getFabligCode(), this.nature);
         if (this.taches != null) {
            if (this.taches.getTacId() != 0L) {
               this.calculeTaches();
            } else {
               this.var_action = 16;
            }
         } else if (this.taches == null) {
            this.calculeTaches();
         }
      }

   }

   public void recuperationTaches() throws JDOMException, IOException, HibernateException, NamingException {
      this.taches = this.formRecherche.calculeTaches();
      this.calculeTaches();
   }

   public void calculeTaches() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.taches != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         this.fabricationLigneAchatsTaches.setFabligCode(this.taches.getTacCode());
         this.fabricationLigneAchatsTaches.setFabligLibelle(this.taches.getTacNomFr());
         this.fabricationLigneAchatsTaches.setFabligJj(this.taches.getTacValJj());
         this.fabricationLigneAchatsTaches.setFabligHh(this.taches.getTacValHh());
         this.fabricationLigneAchatsTaches.setFabligMm(this.taches.getTacValMm());
         this.fabricationLigneAchatsTaches.setFabligSs(this.taches.getTacValSs());
         this.fabricationLigneAchatsTaches.setFabligPump((double)this.taches.getTacValPr());
         this.griserchamps = true;
         this.var_aff_detail_prod = true;
         this.calculPrixTaches(var1);
         this.utilInitHibernate.closeSession();
      } else {
         this.annuleTaches();
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleTaches() {
      this.taches = null;
      this.fabricationLigneAchatsTaches.setFabligCode("");
      this.fabricationLigneAchatsTaches.setFabligLibelle("");
      this.mesConditionnementsProduits.clear();
      this.mesUnitesProduits.clear();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.var_aff_condit = false;
      this.var_aff_unite = false;
      this.var_code_unite = 0;
      this.var_action = this.var_memo_action;
   }

   public void accesImputSerie() {
      this.var_imput_serie = this.fabricationEnteteAchats.getFabSerie();
      this.showModalPanelImput = true;
   }

   public void miseajourImput() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      if (!this.var_imput_serie.equalsIgnoreCase("X")) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.fabricationEnteteAchats.getFabNum();
            this.fabricationEnteteAchats.setFabSerie(this.var_imput_serie);
            this.fabricationEnteteAchats.setFabNum(this.calculChrono.numCompose(this.fabricationEnteteAchats.getFabDate(), this.nature, this.fabricationEnteteAchats.getFabSerie(), var1));
            this.fabricationEnteteAchatsDao.modif(this.fabricationEnteteAchats, var1);
            new ArrayList();
            ParapheurDao var5 = new ParapheurDao(this.baseLog, this.utilInitHibernate);
            ArrayList var4 = (ArrayList)var5.parapheurDocument(this.fabricationEnteteAchats.getFabId(), this.nature, var1);
            if (var4 != null) {
               for(int var6 = 0; var6 < var4.size(); ++var6) {
                  new Parapheur();
                  Parapheur var7 = (Parapheur)var4.get(var6);
                  var7.setPhrNum(this.fabricationEnteteAchats.getFabNum());
                  var5.modif(var7, var1);
               }
            }

            Espion var13 = new Espion();
            var13.setUsers(this.usersLog);
            var13.setEsptype(0);
            var13.setEspdtecreat(new Date());
            var13.setEspaction("Imputation production X N° " + var3 + " en production " + this.fabricationEnteteAchats.getFabSerie() + " N° " + this.fabricationEnteteAchats.getFabNum());
            this.espionDao.mAJEspion(var13, var1);
            var2.commit();
         } catch (HibernateException var11) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var11;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.annuleImputSerie();
      this.annule();
      this.chargeListeDetail((Session)null);
   }

   public void annuleImputSerie() {
      this.setShowModalPanelImput(false);
   }

   public String calculeCheminRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "document" + File.separator + "production" + File.separator;
      return var2;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1) throws HibernateException, NamingException {
      String var2 = "";
      if (this.fabricationEnteteAchats.getFabEtat() == 0) {
         File var3 = new File(this.calculeCheminSousRapport(var1) + "formatEncours.jpg");
         if (var3.exists()) {
            var2 = "formatEncours.jpg";
         }
      }

      return var2;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException {
      ArrayList var1 = new ArrayList();
      FabricationLigneAchats var2;
      int var3;
      if (this.lesLignesIntrants.size() != 0) {
         new FabricationLigneAchats();

         for(var3 = 0; var3 < this.lesLignesIntrants.size(); ++var3) {
            var2 = (FabricationLigneAchats)this.lesLignesIntrants.get(var3);
            var2.setFabricationEnteteAchats(this.fabricationEnteteAchats);
            var1.add(var2);
         }
      }

      if (this.lesLignesSousProduits.size() != 0) {
         new FabricationLigneAchats();

         for(var3 = 0; var3 < this.lesLignesSousProduits.size(); ++var3) {
            var2 = (FabricationLigneAchats)this.lesLignesSousProduits.get(var3);
            var2.setFabricationEnteteAchats(this.fabricationEnteteAchats);
            var1.add(var2);
         }
      }

      if (this.lesLignesDechets.size() != 0) {
         new FabricationLigneAchats();

         for(var3 = 0; var3 < this.lesLignesDechets.size(); ++var3) {
            var2 = (FabricationLigneAchats)this.lesLignesDechets.get(var3);
            var2.setFabricationEnteteAchats(this.fabricationEnteteAchats);
            var1.add(var2);
         }
      }

      if (this.lesLignesTaches.size() != 0) {
         new FabricationLigneAchats();

         for(var3 = 0; var3 < this.lesLignesTaches.size(); ++var3) {
            var2 = (FabricationLigneAchats)this.lesLignesTaches.get(var3);
            var2.setFabricationEnteteAchats(this.fabricationEnteteAchats);
            var1.add(var2);
         }
      }

      this.montant_lettre = this.utilNombre.begin(this.fabricationEnteteAchats.getFabTotPump(), this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var4 = new JRBeanCollectionDataSource(var1);
      return var4;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new Parc();
      Parc var3;
      if (this.fabricationEnteteAchats.getFabAnal2() != null && !this.fabricationEnteteAchats.getFabAnal2().isEmpty()) {
         String var4 = "";
         if (this.fabricationEnteteAchats.getFabAnal2().contains(":")) {
            String[] var5 = this.fabricationEnteteAchats.getFabAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.fabricationEnteteAchats.getFabAnal2();
         }

         ParcDao var6 = new ParcDao(this.baseLog, this.utilInitHibernate);
         var3 = var6.rechercheParc(var4, var1);
         if (var3 != null) {
            var2 = var3.getPrcImmatriculation();
         }
      } else {
         var3 = null;
      }

      return var2;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException {
      boolean var2 = false;
      Session var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();
         if (this.fabricationEnteteAchats.getFabDateImp() != null) {
            var2 = true;
         }

         boolean var5 = false;
         this.fabricationEnteteAchats.setFabDateImp(new Date());
         if (this.fabricationEnteteAchats.getFabEtat() == 0 && this.fabricationEnteteAchats.getFabEtatVal() == 0 && this.usersChrono.getUsrchrValidation() == 0 && this.verificationValidation()) {
            this.fabricationEnteteAchats.setFabEtat(1);
            var5 = true;
         }

         this.fabricationEnteteAchats.setFabModeleImp(var1);
         this.fabricationEnteteAchats = this.fabricationEnteteAchatsDao.modif(this.fabricationEnteteAchats, var3);
         if (var5) {
            this.calculStock = new CalculStock();
            this.calculStock.majFabrication((FabricationEnteteAchats)this.fabricationEnteteAchats, 0, this.baseLog, var3);
            this.calculStock.majFabrication((List)this.lesLignesIntrants, 1, this.baseLog, var3);
            this.calculStock.majFabrication((List)this.lesLignesSousProduits, 0, this.baseLog, var3);
            this.calculStock.majFabrication((List)this.lesLignesDechets, 0, this.baseLog, var3);
         }

         var4.commit();
      } catch (HibernateException var9) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      return var2;
   }

   public void impression(UtilPrint var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var2 == 0) {
         if (var3 != null && !var3.isEmpty()) {
            boolean var11 = this.majDateImpression(var3);
            var1.setRapport(var3);
            var1.setEntete("Impression production");
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid()));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid()));
            var1.setDuplicata("" + var11);
            var1.setNbDecQte(this.optionStocks.getNbDecQteProd());
            var1.setFormat(var5);
            var1.setEmetteur(var6);
            var1.setDestinataire(var7);
            var1.setDestinataireCC(var8);
            var1.setDestinataireCCI(var9);
            var1.setCorpsMail(var10);
            var1.setIdResponsable(this.fabricationEnteteAchats.getFabIdResponsable());
            var1.setTiersSelectionne((Tiers)null);
            var1.setNature(this.nature);
            var1.setId_doc(this.fabricationEnteteAchats.getFabId());
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var1.setRapport(var4);
         var1.setEntete("Impression de la liste des cessions");
         var1.setTotauxTtc("" + this.totauxPump);
         var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "liste" + File.separator + "production" + File.separator);
         var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "stock" + File.separator + "sous_rapport" + File.separator);
         var1.setFormat(var5);
         var1.setEmetteur(var6);
         var1.setDestinataire(var7);
         var1.setDestinataireCC(var8);
         var1.setDestinataireCCI(var9);
         var1.setCorpsMail(var10);
         var1.setIdResponsable(0L);
         var1.setTiersSelectionne((Tiers)null);
         var1.setNature(this.nature);
         var1.setId_doc(0L);
         JRBeanCollectionDataSource var12 = new JRBeanCollectionDataSource(this.lesEntetesList);
         var1.setjRBeanCollectionDataSource(var12);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
      }

   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
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
      if (this.lesEntetesList.size() != 0) {
         if (this.valQteGraph == 0) {
            this.uniteGraph = "PRODUCTION : Total PUMP en " + this.structureLog.getStrdevise();
            this.deviseGraph = this.structureLog.getStrdevise();
            if (!this.structureLog.getStrdevise().equals("XOF") && !this.structureLog.getStrdevise().equals("XAF")) {
               this.nbDecGraph = 2;
            } else {
               this.nbDecGraph = 0;
            }
         } else {
            this.uniteGraph = "PRODUCTION : Quantites";
            this.deviseGraph = "";
            this.nbDecGraph = Integer.parseInt(this.optionAchats.getNbDecQte());
         }

         this.titreGraph = "Analyse des mouvements de production";
         EtatDocument var2 = new EtatDocument();
         if (this.inpDu != null && this.inpAu != null) {
            String var3 = this.utilDate.dateToStringFr(this.inpDu);
            String var4 = this.utilDate.dateToStringFr(this.inpAu);
            this.titreGraph = this.titreGraph + " Du " + var3 + " au " + var4;
         } else if (this.periode.equals("100")) {
            this.titreGraph = this.titreGraph + " Toutes periodes";
         } else {
            this.titreGraph = this.titreGraph + " " + var2.calculeLibellePeriode(this.periode);
         }

         if (this.inpDepot.equals("100")) {
            this.titreGraph = this.titreGraph + " TOUS DEPOTS";
         } else {
            this.titreGraph = this.titreGraph + " DEPOT : " + this.inpDepot;
         }

         this.sousTitreGraph = "";
         this.sousTitreGraph = this.sousTitreGraph + " Serie:" + this.inpSerie + " -";
         if (this.inpEtat == 100) {
            this.sousTitreGraph = this.sousTitreGraph + " Tous les Etats";
         } else {
            this.sousTitreGraph = this.sousTitreGraph + " Etats: " + var2.calculeLibelleEtat(this.nature, this.inpEtat, 0);
         }

         if (this.modeGraph == 0) {
            this.sousTitreGraph = this.sousTitreGraph + " - En Global (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 1) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par responsable (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 3) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par equipe (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 5) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par famille de produit (" + this.uniteGraph + ")";
         } else if (this.modeGraph == 6) {
            this.sousTitreGraph = this.sousTitreGraph + " - Par produit (" + this.uniteGraph + ")";
         }

         new FabricationEnteteAchats();
         new FabricationLigneAchats();
         Session var5 = this.utilInitHibernate.getOpenSession(this.baseLog, "ProcessAchats");
         String var6 = "";

         FabricationEnteteAchats var14;
         for(int var7 = 0; var7 < this.lesEntetesList.size(); ++var7) {
            var14 = (FabricationEnteteAchats)this.lesEntetesList.get(var7);
            if (var6.isEmpty()) {
               var6 = "'" + var14.getFabNum() + "'";
            } else {
               var6 = var6 + ",'" + var14.getFabNum() + "'";
            }
         }

         int var12;
         int var19;
         if (this.valQteGraph != 1 && this.modeGraph != 5 && this.modeGraph != 6) {
            if (this.lesEntetesList.size() != 0) {
               String var17 = "";
               long var20 = 0L;
               boolean var10 = false;
               var19 = 0;

               while(true) {
                  if (var19 >= this.lesEntetesList.size()) {
                     var1 = this.calculePourcentage((List)var1);
                     break;
                  }

                  var14 = (FabricationEnteteAchats)this.lesEntetesList.get(var19);
                  var17 = "";
                  var20 = 0L;
                  int var18 = 0;
                  if (this.modeGraph == 0) {
                     var12 = var14.getFabDate().getYear() + 1900;
                     var17 = "" + var12;
                  } else if (this.modeGraph == 1) {
                     if (var14.getFabNomResponsable() != null && !var14.getFabNomResponsable().isEmpty()) {
                        var17 = var14.getFabNomResponsable();
                     } else {
                        var17 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var14.getFabNomEquipe() != null && !var14.getFabNomEquipe().isEmpty()) {
                        var17 = var14.getFabNomEquipe();
                     } else {
                        var17 = "Sans Equipe";
                     }
                  }

                  var20 = (long)var14.getFabTotPump();
                  if (this.timeDecoupage == 0) {
                     var18 = var14.getFabDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var18 = var14.getFabDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var14.getFabDate().getMonth() + 1 >= 1 && var14.getFabDate().getMonth() + 1 <= 3) {
                        var18 = 1;
                     } else if (var14.getFabDate().getMonth() + 1 >= 4 && var14.getFabDate().getMonth() + 1 <= 6) {
                        var18 = 2;
                     } else if (var14.getFabDate().getMonth() + 1 >= 7 && var14.getFabDate().getMonth() + 1 <= 9) {
                        var18 = 3;
                     } else if (var14.getFabDate().getMonth() + 1 >= 10 && var14.getFabDate().getMonth() + 1 <= 12) {
                        var18 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var14.getFabDate().getMonth() + 1 >= 1 && var14.getFabDate().getMonth() + 1 <= 6) {
                        var18 = 1;
                     } else if (var14.getFabDate().getMonth() + 1 >= 7 && var14.getFabDate().getMonth() + 1 <= 12) {
                        var18 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var18 = 1;
                  }

                  var1 = this.calculeListe((List)var1, var17, var18, var20);
                  ++var19;
               }
            }
         } else {
            new ArrayList();
            List var16 = this.fabricationLigneAchatsDao.chargerLesLignesFab(var6, var5);
            if (var16.size() != 0) {
               String var8 = "";
               long var9 = 0L;
               boolean var11 = false;
               var12 = 0;

               while(true) {
                  if (var12 >= var16.size()) {
                     var1 = this.calculePourcentage((List)var1);
                     break;
                  }

                  FabricationLigneAchats var15 = (FabricationLigneAchats)var16.get(var12);
                  var8 = "";
                  var9 = 0L;
                  var19 = 0;
                  if (this.modeGraph == 0) {
                     int var13 = var15.getFabricationEnteteAchats().getFabDate().getYear() + 1900;
                     var8 = "" + var13;
                  } else if (this.modeGraph == 1) {
                     if (var15.getFabricationEnteteAchats().getFabNomResponsable() != null && !var15.getFabricationEnteteAchats().getFabNomResponsable().isEmpty()) {
                        var8 = var15.getFabricationEnteteAchats().getFabNomResponsable();
                     } else {
                        var8 = "Sans Responsable";
                     }
                  } else if (this.modeGraph == 3) {
                     if (var15.getFabricationEnteteAchats().getFabNomEquipe() != null && !var15.getFabricationEnteteAchats().getFabNomEquipe().isEmpty()) {
                        var8 = var15.getFabricationEnteteAchats().getFabNomEquipe();
                     } else {
                        var8 = "Sans Equipe";
                     }
                  } else if (this.modeGraph == 5) {
                     if (var15.getFabligFamille() != null && !var15.getFabligFamille().isEmpty()) {
                        var8 = var15.getFabligFamille();
                     } else {
                        var8 = "Sans Famille Produit";
                     }
                  } else if (this.modeGraph == 6) {
                     if (var15.getFabligLibelle() != null && !var15.getFabligLibelle().isEmpty()) {
                        var8 = var15.getFabligLibelle();
                     } else {
                        var8 = "Sans Libelle Produit";
                     }
                  }

                  if (this.valQteGraph == 0) {
                     var9 = (long)var15.getFabligTotal();
                  } else {
                     var9 = (long)this.utilNombre.myRound(var15.getFabligQte(), 1);
                  }

                  if (this.timeDecoupage == 0) {
                     var19 = var15.getFabricationEnteteAchats().getFabDate().getDate();
                  } else if (this.timeDecoupage == 1) {
                     var19 = var15.getFabricationEnteteAchats().getFabDate().getMonth() + 1;
                  } else if (this.timeDecoupage == 2) {
                     if (var15.getFabricationEnteteAchats().getFabDate().getMonth() + 1 >= 1 && var15.getFabricationEnteteAchats().getFabDate().getMonth() + 1 <= 3) {
                        var19 = 1;
                     } else if (var15.getFabricationEnteteAchats().getFabDate().getMonth() + 1 >= 4 && var15.getFabricationEnteteAchats().getFabDate().getMonth() + 1 <= 6) {
                        var19 = 2;
                     } else if (var15.getFabricationEnteteAchats().getFabDate().getMonth() + 1 >= 7 && var15.getFabricationEnteteAchats().getFabDate().getMonth() + 1 <= 9) {
                        var19 = 3;
                     } else if (var15.getFabricationEnteteAchats().getFabDate().getMonth() + 1 >= 10 && var15.getFabricationEnteteAchats().getFabDate().getMonth() + 1 <= 12) {
                        var19 = 4;
                     }
                  } else if (this.timeDecoupage == 3) {
                     if (var15.getFabricationEnteteAchats().getFabDate().getMonth() + 1 >= 1 && var15.getFabricationEnteteAchats().getFabDate().getMonth() + 1 <= 6) {
                        var19 = 1;
                     } else if (var15.getFabricationEnteteAchats().getFabDate().getMonth() + 1 >= 7 && var15.getFabricationEnteteAchats().getFabDate().getMonth() + 1 <= 12) {
                        var19 = 2;
                     }
                  } else if (this.timeDecoupage == 4) {
                     var19 = 1;
                  }

                  var1 = this.calculeListe((List)var1, var8, var19, var9);
                  ++var12;
               }
            }
         }

         this.utilInitHibernate.closeSession();
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
            var8.setV13(var8.getV13() + var4);
         } else if (var3 == 14) {
            var8.setV14(var8.getV14() + var4);
         } else if (var3 == 15) {
            var8.setV15(var8.getV15() + var4);
         } else if (var3 == 16) {
            var8.setV16(var8.getV16() + var4);
         } else if (var3 == 17) {
            var8.setV17(var8.getV17() + var4);
         } else if (var3 == 18) {
            var8.setV18(var8.getV18() + var4);
         } else if (var3 == 19) {
            var8.setV19(var8.getV19() + var4);
         } else if (var3 == 20) {
            var8.setV20(var8.getV20() + var4);
         } else if (var3 == 21) {
            var8.setV21(var8.getV21() + var4);
         } else if (var3 == 22) {
            var8.setV22(var8.getV22() + var4);
         } else if (var3 == 23) {
            var8.setV23(var8.getV23() + var4);
         } else if (var3 == 24) {
            var8.setV24(var8.getV24() + var4);
         } else if (var3 == 25) {
            var8.setV25(var8.getV25() + var4);
         } else if (var3 == 26) {
            var8.setV26(var8.getV26() + var4);
         } else if (var3 == 27) {
            var8.setV27(var8.getV27() + var4);
         } else if (var3 == 28) {
            var8.setV28(var8.getV28() + var4);
         } else if (var3 == 29) {
            var8.setV29(var8.getV29() + var4);
         } else if (var3 == 30) {
            var8.setV30(var8.getV30() + var4);
         } else if (var3 == 31) {
            var8.setV31(var8.getV31() + var4);
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

   public boolean isAccesProduits() {
      return this.accesProduits;
   }

   public void setAccesProduits(boolean var1) {
      this.accesProduits = var1;
   }

   public boolean isAffichagePump() {
      return this.affichagePump;
   }

   public void setAffichagePump(boolean var1) {
      this.affichagePump = var1;
   }

   public boolean isVar_valide_doc() {
      return this.var_valide_doc;
   }

   public void setVar_valide_doc(boolean var1) {
      this.var_valide_doc = var1;
   }

   public FabricationEnteteAchats getFabricationEnteteAchats() {
      return this.fabricationEnteteAchats;
   }

   public void setFabricationEnteteAchats(FabricationEnteteAchats var1) {
      this.fabricationEnteteAchats = var1;
   }

   public FabricationLigneAchats getFabricationLigneAchatsDechets() {
      return this.fabricationLigneAchatsDechets;
   }

   public void setFabricationLigneAchatsDechets(FabricationLigneAchats var1) {
      this.fabricationLigneAchatsDechets = var1;
   }

   public FabricationLigneAchats getFabricationLigneAchatsIntrants() {
      return this.fabricationLigneAchatsIntrants;
   }

   public void setFabricationLigneAchatsIntrants(FabricationLigneAchats var1) {
      this.fabricationLigneAchatsIntrants = var1;
   }

   public FabricationLigneAchats getFabricationLigneAchatsSousProduits() {
      return this.fabricationLigneAchatsSousProduits;
   }

   public void setFabricationLigneAchatsSousProduits(FabricationLigneAchats var1) {
      this.fabricationLigneAchatsSousProduits = var1;
   }

   public FabricationLigneAchats getFabricationLigneAchatsTaches() {
      return this.fabricationLigneAchatsTaches;
   }

   public void setFabricationLigneAchatsTaches(FabricationLigneAchats var1) {
      this.fabricationLigneAchatsTaches = var1;
   }

   public boolean isGriserchamps() {
      return this.griserchamps;
   }

   public void setGriserchamps(boolean var1) {
      this.griserchamps = var1;
   }

   public String getInpActivite() {
      return this.inpActivite;
   }

   public void setInpActivite(String var1) {
      this.inpActivite = var1;
   }

   public Date getInpAu() {
      return this.inpAu;
   }

   public void setInpAu(Date var1) {
      this.inpAu = var1;
   }

   public Date getInpDu() {
      return this.inpDu;
   }

   public void setInpDu(Date var1) {
      this.inpDu = var1;
   }

   public int getInpEtat() {
      return this.inpEtat;
   }

   public void setInpEtat(int var1) {
      this.inpEtat = var1;
   }

   public String getInpNum() {
      return this.inpNum;
   }

   public void setInpNum(String var1) {
      this.inpNum = var1;
   }

   public String getInpResponsable() {
      return this.inpResponsable;
   }

   public void setInpResponsable(String var1) {
      this.inpResponsable = var1;
   }

   public String getInpSerie() {
      return this.inpSerie;
   }

   public void setInpSerie(String var1) {
      this.inpSerie = var1;
   }

   public String getInpAtelier() {
      return this.inpAtelier;
   }

   public void setInpAtelier(String var1) {
      this.inpAtelier = var1;
   }

   public String getInpLigne() {
      return this.inpLigne;
   }

   public void setInpLigne(String var1) {
      this.inpLigne = var1;
   }

   public String getInpSite() {
      return this.inpSite;
   }

   public void setInpSite(String var1) {
      this.inpSite = var1;
   }

   public List getMesConditionnementsProduits() {
      return this.mesConditionnementsProduits;
   }

   public void setMesConditionnementsProduits(List var1) {
      this.mesConditionnementsProduits = var1;
   }

   public List getMesUnitesProduits() {
      return this.mesUnitesProduits;
   }

   public void setMesUnitesProduits(List var1) {
      this.mesUnitesProduits = var1;
   }

   public OptionAchats getOptionAchats() {
      return this.optionAchats;
   }

   public void setOptionAchats(OptionAchats var1) {
      this.optionAchats = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public boolean isShowModalPanelImput() {
      return this.showModalPanelImput;
   }

   public void setShowModalPanelImput(boolean var1) {
      this.showModalPanelImput = var1;
   }

   public String getUrlphotoProd() {
      return this.urlphotoProd;
   }

   public void setUrlphotoProd(String var1) {
      this.urlphotoProd = var1;
   }

   public boolean isVar_acc_complement() {
      return this.var_acc_complement;
   }

   public void setVar_acc_complement(boolean var1) {
      this.var_acc_complement = var1;
   }

   public boolean isVar_acc_etat() {
      return this.var_acc_etat;
   }

   public void setVar_acc_etat(boolean var1) {
      this.var_acc_etat = var1;
   }

   public boolean isVar_acc_habilitation() {
      return this.var_acc_habilitation;
   }

   public void setVar_acc_habilitation(boolean var1) {
      this.var_acc_habilitation = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public boolean isVar_aff_action() {
      return this.var_aff_action;
   }

   public void setVar_aff_action(boolean var1) {
      this.var_aff_action = var1;
   }

   public boolean isVar_aff_condit() {
      return this.var_aff_condit;
   }

   public void setVar_aff_condit(boolean var1) {
      this.var_aff_condit = var1;
   }

   public boolean isVar_aff_detail_prod() {
      return this.var_aff_detail_prod;
   }

   public void setVar_aff_detail_prod(boolean var1) {
      this.var_aff_detail_prod = var1;
   }

   public boolean isVar_ajt() {
      return this.var_ajt;
   }

   public void setVar_ajt(boolean var1) {
      this.var_ajt = var1;
   }

   public int getVar_code_unite() {
      return this.var_code_unite;
   }

   public void setVar_code_unite(int var1) {
      this.var_code_unite = var1;
   }

   public boolean isVar_imp() {
      return this.var_imp;
   }

   public void setVar_imp(boolean var1) {
      this.var_imp = var1;
   }

   public String getVar_imput_serie() {
      return this.var_imput_serie;
   }

   public void setVar_imput_serie(String var1) {
      this.var_imput_serie = var1;
   }

   public boolean isVar_mod() {
      return this.var_mod;
   }

   public void setVar_mod(boolean var1) {
      this.var_mod = var1;
   }

   public boolean isVar_more_search() {
      return this.var_more_search;
   }

   public void setVar_more_search(boolean var1) {
      this.var_more_search = var1;
   }

   public int getVar_nb_ligne() {
      return this.var_nb_ligne;
   }

   public void setVar_nb_ligne(int var1) {
      this.var_nb_ligne = var1;
   }

   public boolean isVar_sansstock() {
      return this.var_sansstock;
   }

   public void setVar_sansstock(boolean var1) {
      this.var_sansstock = var1;
   }

   public boolean isVar_sup() {
      return this.var_sup;
   }

   public void setVar_sup(boolean var1) {
      this.var_sup = var1;
   }

   public boolean isVar_verrou_comm() {
      return this.var_verrou_comm;
   }

   public void setVar_verrou_comm(boolean var1) {
      this.var_verrou_comm = var1;
   }

   public boolean isVerrouNum() {
      return this.verrouNum;
   }

   public void setVerrouNum(boolean var1) {
      this.verrouNum = var1;
   }

   public boolean isVisibiliteBton() {
      return this.visibiliteBton;
   }

   public void setVisibiliteBton(boolean var1) {
      this.visibiliteBton = var1;
   }

   public boolean isVisibleOnglet() {
      return this.visibleOnglet;
   }

   public void setVisibleOnglet(boolean var1) {
      this.visibleOnglet = var1;
   }

   public String getInpDepot() {
      return this.inpDepot;
   }

   public void setInpDepot(String var1) {
      this.inpDepot = var1;
   }

   public String getInpParc() {
      return this.inpParc;
   }

   public void setInpParc(String var1) {
      this.inpParc = var1;
   }

   public boolean isVisibiliteBtonlig() {
      return this.visibiliteBtonlig;
   }

   public void setVisibiliteBtonlig(boolean var1) {
      this.visibiliteBtonlig = var1;
   }

   public boolean isVisibleOngleEntete() {
      return this.visibleOngleEntete;
   }

   public void setVisibleOngleEntete(boolean var1) {
      this.visibleOngleEntete = var1;
   }

   public DataModel getDatamodelEntete() {
      return this.datamodelEntete;
   }

   public void setDatamodelEntete(DataModel var1) {
      this.datamodelEntete = var1;
   }

   public boolean isVar_acc_document() {
      return this.var_acc_document;
   }

   public void setVar_acc_document(boolean var1) {
      this.var_acc_document = var1;
   }

   public boolean isVar_acc_imputation() {
      return this.var_acc_imputation;
   }

   public void setVar_acc_imputation(boolean var1) {
      this.var_acc_imputation = var1;
   }

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public Habilitation getHabilitation() {
      return this.habilitation;
   }

   public void setHabilitation(Habilitation var1) {
      this.habilitation = var1;
   }

   public ExercicesAchats getLastExoAchats() {
      return this.lastExoAchats;
   }

   public void setLastExoAchats(ExercicesAchats var1) {
      this.lastExoAchats = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public List getMesUnitesItems() {
      return this.mesUnitesItems;
   }

   public void setMesUnitesItems(List var1) {
      this.mesUnitesItems = var1;
   }

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
   }

   public boolean isVar_anal_activite() {
      return this.var_anal_activite;
   }

   public void setVar_anal_activite(boolean var1) {
      this.var_anal_activite = var1;
   }

   public boolean isVar_anal_parc() {
      return this.var_anal_parc;
   }

   public void setVar_anal_parc(boolean var1) {
      this.var_anal_parc = var1;
   }

   public int getVar_anal_dossier() {
      return this.var_anal_dossier;
   }

   public void setVar_anal_dossier(int var1) {
      this.var_anal_dossier = var1;
   }

   public double getMontantPump() {
      return this.montantPump;
   }

   public void setMontantPump(double var1) {
      this.montantPump = var1;
   }

   public String getVar_depot_production() {
      return this.var_depot_production;
   }

   public void setVar_depot_production(String var1) {
      this.var_depot_production = var1;
   }

   public boolean isVar_acc_verification() {
      return this.var_acc_verification;
   }

   public void setVar_acc_verification(boolean var1) {
      this.var_acc_verification = var1;
   }

   public boolean isVar_affiche_filtre() {
      return this.var_affiche_filtre;
   }

   public void setVar_affiche_filtre(boolean var1) {
      this.var_affiche_filtre = var1;
   }

   public long getVar_nom_responsable() {
      return this.var_nom_responsable;
   }

   public void setVar_nom_responsable(long var1) {
      this.var_nom_responsable = var1;
   }

   public boolean isVerrouPump() {
      return this.verrouPump;
   }

   public void setVerrouPump(boolean var1) {
      this.verrouPump = var1;
   }

   public String getInpDossier() {
      return this.inpDossier;
   }

   public void setInpDossier(String var1) {
      this.inpDossier = var1;
   }

   public OptionStocks getOptionStocks() {
      return this.optionStocks;
   }

   public void setOptionStocks(OptionStocks var1) {
      this.optionStocks = var1;
   }

   public Date getVar_date() {
      return this.var_date;
   }

   public void setVar_date(Date var1) {
      this.var_date = var1;
   }

   public String getVar_heure() {
      return this.var_heure;
   }

   public void setVar_heure(String var1) {
      this.var_heure = var1;
   }

   public String getVar_minute() {
      return this.var_minute;
   }

   public void setVar_minute(String var1) {
      this.var_minute = var1;
   }

   public String getVar_seconde() {
      return this.var_seconde;
   }

   public void setVar_seconde(String var1) {
      this.var_seconde = var1;
   }

   public ProduitsDepot getProduitsDepot() {
      return this.produitsDepot;
   }

   public void setProduitsDepot(ProduitsDepot var1) {
      this.produitsDepot = var1;
   }

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
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

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public UtilParapheur getUtilParapheur() {
      return this.utilParapheur;
   }

   public void setUtilParapheur(UtilParapheur var1) {
      this.utilParapheur = var1;
   }

   public String getInpProcess() {
      return this.inpProcess;
   }

   public void setInpProcess(String var1) {
      this.inpProcess = var1;
   }

   public List getMesEquipeItem() {
      return this.mesEquipeItem;
   }

   public void setMesEquipeItem(List var1) {
      this.mesEquipeItem = var1;
   }

   public List getMesAteliersItems() {
      return this.mesAteliersItems;
   }

   public void setMesAteliersItems(List var1) {
      this.mesAteliersItems = var1;
   }

   public String getVar_process() {
      return this.var_process;
   }

   public void setVar_process(String var1) {
      this.var_process = var1;
   }

   public DataModel getDataModelDecoupageActivtes() {
      return this.dataModelDecoupageActivtes;
   }

   public void setDataModelDecoupageActivtes(DataModel var1) {
      this.dataModelDecoupageActivtes = var1;
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

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public String getMessageStockNegatif() {
      return this.messageStockNegatif;
   }

   public void setMessageStockNegatif(String var1) {
      this.messageStockNegatif = var1;
   }

   public int getValidationLigne() {
      return this.validationLigne;
   }

   public void setValidationLigne(int var1) {
      this.validationLigne = var1;
   }

   public DataModel getDatamodelDechets() {
      return this.datamodelDechets;
   }

   public void setDatamodelDechets(DataModel var1) {
      this.datamodelDechets = var1;
   }

   public DataModel getDatamodelIntrants() {
      return this.datamodelIntrants;
   }

   public void setDatamodelIntrants(DataModel var1) {
      this.datamodelIntrants = var1;
   }

   public DataModel getDatamodelSousProduits() {
      return this.datamodelSousProduits;
   }

   public void setDatamodelSousProduits(DataModel var1) {
      this.datamodelSousProduits = var1;
   }

   public DataModel getDatamodelTaches() {
      return this.datamodelTaches;
   }

   public void setDatamodelTaches(DataModel var1) {
      this.datamodelTaches = var1;
   }

   public boolean isShowModalPanelGraph() {
      return this.showModalPanelGraph;
   }

   public void setShowModalPanelGraph(boolean var1) {
      this.showModalPanelGraph = var1;
   }

   public String getDeviseGraph() {
      return this.deviseGraph;
   }

   public void setDeviseGraph(String var1) {
      this.deviseGraph = var1;
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

   public int getValQteGraph() {
      return this.valQteGraph;
   }

   public void setValQteGraph(int var1) {
      this.valQteGraph = var1;
   }

   public boolean isVar_aff_unite() {
      return this.var_aff_unite;
   }

   public void setVar_aff_unite(boolean var1) {
      this.var_aff_unite = var1;
   }

   public boolean isShowModalPanelDetailTache() {
      return this.showModalPanelDetailTache;
   }

   public void setShowModalPanelDetailTache(boolean var1) {
      this.showModalPanelDetailTache = var1;
   }

   public boolean isVar_commande() {
      return this.var_commande;
   }

   public void setVar_commande(boolean var1) {
      this.var_commande = var1;
   }

   public boolean isVar_methode() {
      return this.var_methode;
   }

   public void setVar_methode(boolean var1) {
      this.var_methode = var1;
   }

   public boolean isVar_piege() {
      return this.var_piege;
   }

   public void setVar_piege(boolean var1) {
      this.var_piege = var1;
   }

   public ProcessEnteteAchats getProcessEnteteAchats() {
      return this.processEnteteAchats;
   }

   public void setProcessEnteteAchats(ProcessEnteteAchats var1) {
      this.processEnteteAchats = var1;
   }

   public DataModel getDatamodelLigneCommande() {
      return this.datamodelLigneCommande;
   }

   public void setDatamodelLigneCommande(DataModel var1) {
      this.datamodelLigneCommande = var1;
   }

   public String getLibelleModeReception() {
      return this.libelleModeReception;
   }

   public void setLibelleModeReception(String var1) {
      this.libelleModeReception = var1;
   }

   public int getModeReception() {
      return this.modeReception;
   }

   public void setModeReception(int var1) {
      this.modeReception = var1;
   }

   public ReceptionEnteteAchats getReceptionEnteteAchats() {
      return this.receptionEnteteAchats;
   }

   public void setReceptionEnteteAchats(ReceptionEnteteAchats var1) {
      this.receptionEnteteAchats = var1;
   }

   public boolean isShowModalPanelPlanning() {
      return this.showModalPanelPlanning;
   }

   public void setShowModalPanelPlanning(boolean var1) {
      this.showModalPanelPlanning = var1;
   }

   public ReceptionAvicultureAchats getReceptionAvicultureAchats() {
      return this.receptionAvicultureAchats;
   }

   public void setReceptionAvicultureAchats(ReceptionAvicultureAchats var1) {
      this.receptionAvicultureAchats = var1;
   }

   public List getLesDatesItems() {
      return this.lesDatesItems;
   }

   public void setLesDatesItems(List var1) {
      this.lesDatesItems = var1;
   }

   public int getNbIndividusAnte() {
      return this.nbIndividusAnte;
   }

   public void setNbIndividusAnte(int var1) {
      this.nbIndividusAnte = var1;
   }

   public int getNbIndividusReste() {
      return this.nbIndividusReste;
   }

   public void setNbIndividusReste(int var1) {
      this.nbIndividusReste = var1;
   }

   public String getDateJour() {
      return this.dateJour;
   }

   public void setDateJour(String var1) {
      this.dateJour = var1;
   }

   public String getInpService() {
      return this.inpService;
   }

   public void setInpService(String var1) {
      this.inpService = var1;
   }

   public List getMesProcessItems() {
      return this.mesProcessItems;
   }

   public void setMesProcessItems(List var1) {
      this.mesProcessItems = var1;
   }

   public List getMesDepotAchItems() {
      return this.mesDepotAchItems;
   }

   public void setMesDepotAchItems(List var1) {
      this.mesDepotAchItems = var1;
   }

   public List getMesProduitInterchangeablesItems() {
      return this.mesProduitInterchangeablesItems;
   }

   public void setMesProduitInterchangeablesItems(List var1) {
      this.mesProduitInterchangeablesItems = var1;
   }

   public String getVar_produit_interchangeable() {
      return this.var_produit_interchangeable;
   }

   public void setVar_produit_interchangeable(String var1) {
      this.var_produit_interchangeable = var1;
   }

   public List getMesDepotsProduitsItems() {
      return this.mesDepotsProduitsItems;
   }

   public void setMesDepotsProduitsItems(List var1) {
      this.mesDepotsProduitsItems = var1;
   }

   public String getUniteGraph() {
      return this.uniteGraph;
   }

   public void setUniteGraph(String var1) {
      this.uniteGraph = var1;
   }

   public String getVerrouDepotUser() {
      return this.verrouDepotUser;
   }

   public void setVerrouDepotUser(String var1) {
      this.verrouDepotUser = var1;
   }

   public SimpleSelection getSimpleSelectionEntete() {
      return this.simpleSelectionEntete;
   }

   public void setSimpleSelectionEntete(SimpleSelection var1) {
      this.simpleSelectionEntete = var1;
   }

   public String getNomOnglet() {
      return this.nomOnglet;
   }

   public void setNomOnglet(String var1) {
      this.nomOnglet = var1;
   }

   public UIDataTable getExtDTable() {
      return this.extDTable;
   }

   public void setExtDTable(UIDataTable var1) {
      this.extDTable = var1;
   }

   public List getMesLotsItems() {
      return this.mesLotsItems;
   }

   public void setMesLotsItems(List var1) {
      this.mesLotsItems = var1;
   }

   public List getMesLotsEnteteItems() {
      return this.mesLotsEnteteItems;
   }

   public void setMesLotsEnteteItems(List var1) {
      this.mesLotsEnteteItems = var1;
   }

   public DataModel getDatamodelGeneres() {
      return this.datamodelGeneres;
   }

   public void setDatamodelGeneres(DataModel var1) {
      this.datamodelGeneres = var1;
   }

   public FabricationLigneAchats getFabricationLigneAchatsGeneres() {
      return this.fabricationLigneAchatsGeneres;
   }

   public void setFabricationLigneAchatsGeneres(FabricationLigneAchats var1) {
      this.fabricationLigneAchatsGeneres = var1;
   }

   public boolean isVar_depot_famille() {
      return this.var_depot_famille;
   }

   public void setVar_depot_famille(boolean var1) {
      this.var_depot_famille = var1;
   }

   public String getCode_activite() {
      return this.code_activite;
   }

   public void setCode_activite(String var1) {
      this.code_activite = var1;
   }

   public String getCode_planAnalytique() {
      return this.code_planAnalytique;
   }

   public void setCode_planAnalytique(String var1) {
      this.code_planAnalytique = var1;
   }

   public boolean isVar_anal_chantier() {
      return this.var_anal_chantier;
   }

   public void setVar_anal_chantier(boolean var1) {
      this.var_anal_chantier = var1;
   }
}
