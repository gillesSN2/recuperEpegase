package com.epegase.forms.parc;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Baremes;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.Departement;
import com.epegase.systeme.classe.DevisEnteteVentes;
import com.epegase.systeme.classe.DevisLigneVentes;
import com.epegase.systeme.classe.Equipes;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesParc;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureInterneEnteteVentes;
import com.epegase.systeme.classe.FactureInterneLigneVentes;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.ManifestEntete;
import com.epegase.systeme.classe.ManifestEnteteImport;
import com.epegase.systeme.classe.ManifestLigne;
import com.epegase.systeme.classe.ManifestLigneImport;
import com.epegase.systeme.classe.ManifestProduit;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.ParcAffectation;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.Site;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.TransitLieuVentes;
import com.epegase.systeme.classe.TransitPortVentes;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.ObjetGraph;
import com.epegase.systeme.dao.BaremesDao;
import com.epegase.systeme.dao.DepartementDao;
import com.epegase.systeme.dao.DevisEnteteVentesDao;
import com.epegase.systeme.dao.DevisLigneVentesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.EquipesDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FactureInterneEnteteVentesDao;
import com.epegase.systeme.dao.FactureInterneLigneVentesDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.HabilitationDao;
import com.epegase.systeme.dao.ManifestEnteteDao;
import com.epegase.systeme.dao.ManifestEnteteImportDao;
import com.epegase.systeme.dao.ManifestLigneDao;
import com.epegase.systeme.dao.ManifestLigneImporteDao;
import com.epegase.systeme.dao.ManifestProduitDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.ParcAffectationDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.SiteDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.TransitLieuVentesDao;
import com.epegase.systeme.dao.TransitPortVentesDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilParapheur;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.LectureFamillesClients;
import com.epegase.systeme.xml.LectureManifest;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetIncoterm;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionParcs;
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

public class FormManifestePrc implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private FormRecherche formRecherche;
   private int var_action = 0;
   private int var_memo_action = 0;
   private String pageIndex;
   private int nature;
   private int typeVente;
   private String urlphotoProd;
   private List mesOnglets;
   private OptionVentes optionsVentes;
   private OptionParcs optionParcs;
   private int var_option_parc;
   private boolean var_contener_parc;
   private ExercicesVentes exercicesVentes;
   private ExercicesParc exercicesParc;
   private ExercicesVentes lastExoVentes;
   private ExercicesParc lastExoParc;
   private EspionDao espionDao;
   private CalculChrono calculChrono;
   private int var_nb_max = 100;
   private List mesSerieUserItem;
   private Date var_date;
   private boolean visibleOnglet = false;
   private boolean existParapheur = false;
   private PlansAnalytiques plansAnalytiques = new PlansAnalytiques();
   private Users responsable;
   private long var_nom_commercial;
   private List mesCommercialItem = new ArrayList();
   private long var_nom_equipe;
   private Equipes equipes;
   private EquipesDao equipesDao;
   private List mesEquipeItem = new ArrayList();
   private List lesEquipes = new ArrayList();
   private UsersChrono usersChrono = new UsersChrono();
   private UsersChronoDao usersChronoDao;
   private UserDao usersDao;
   private List mesUsersItem = new ArrayList();
   private ManifestEntete manifestEntete = new ManifestEntete();
   private ManifestEnteteDao manifestEnteteDao;
   private List lesEntetesList = new ArrayList();
   private boolean verrouNum = false;
   private transient DataModel datamodelEntete = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean visibiliteBton = false;
   private boolean visibiliteBtonlig = false;
   private boolean visibleOngleEntete;
   private boolean var_aff_action = false;
   private boolean var_valide_doc = false;
   private boolean var_valide_lv = false;
   private boolean var_valide_prd = false;
   private double montantTtc = 0.0D;
   private double montantHt = 0.0D;
   private double montantTTva = 0.0D;
   private double montantSolde = 0.0D;
   private double montantReglement = 0.0D;
   private double montantTtcElmt = 0.0D;
   private double montantSoldeElmt = 0.0D;
   private double montantReglementElmt = 0.0D;
   private int var_nb_ligne = 0;
   private ObjetIncoterm incoterms;
   private UtilDate utilDate = new UtilDate();
   private String conditRegtier;
   private boolean showModalPanelImput = false;
   private String var_imput_serie;
   private String var_imput_cat;
   private int var_imput_choix;
   private String var_imput_num;
   private List mesParcsItems = new ArrayList();
   private long var_nom_responsable;
   private boolean showModalPanelAnnuler = false;
   private ServiceDao serviceDao;
   private List mesNaturesManifestItems = new ArrayList();
   private List mesNaviresItems = new ArrayList();
   private List mesVehiculesItems = new ArrayList();
   private List mesRemorquesItems = new ArrayList();
   private List mesPortsItemsDep = new ArrayList();
   private List mesPortsItemsArr = new ArrayList();
   private List mesLieuxItemsDep = new ArrayList();
   private List mesLieuxItemsArr = new ArrayList();
   private ManifestLigne manifestLigne = new ManifestLigne();
   private ManifestLigneDao manifestLigneDao;
   private transient DataModel datamodelLigne = new ListDataModel();
   private List lesLignesList = new ArrayList();
   private String var_depotProd;
   private boolean griserchamps = false;
   private double prixPlancher;
   private boolean griserValider = false;
   private int numLigne;
   private boolean showModalPanelLettre = false;
   private boolean var_aff_action_lv = false;
   private ParcDao parcDao;
   private Parc parc;
   private TransitLieuVentesDao transitLieuVentesDao;
   private List mesClientsItems = new ArrayList();
   private List mesResponsablesItemsExp = new ArrayList();
   private List mesResponsablesItemsDest = new ArrayList();
   private List mesChauffeursItemsExp = new ArrayList();
   private List mesChauffeursItemsDest = new ArrayList();
   private List mesDevisItems = new ArrayList();
   private List mesContenerItems = new ArrayList();
   private List mesContener1Items = new ArrayList();
   private TiersDao tiersDao;
   private Tiers tiers;
   private Salaries salaries;
   private SalariesDao salariesDao;
   private boolean exoTva;
   private boolean exoTc;
   private List mesTaxesVentesItems;
   private List mesTaxesVentesProduits = new ArrayList();
   private Produits produits;
   private ProduitsVtesDao produitsVtesDao;
   private TaxesVentesDao taxesVentesDao;
   private ProduitsTarifDao produitsTarifDao;
   private TransitPortVentesDao transitPortVentesDao;
   private double prixUnitaires;
   private BaremesDao baremesDao;
   private boolean verifBareme;
   private boolean visibiliteBtonDetaillig = false;
   private boolean showModalPanelProduit = false;
   private ManifestProduit manifestProduit;
   private transient DataModel datamodelProduit = new ListDataModel();
   private List lesLignesProduit = new ArrayList();
   private ManifestProduitDao manifestProduitDao;
   private List mesProduitsItems = new ArrayList();
   private FamillesProduitsVentesDao famillesProduitsVentesDao;
   private String inpSerie = "100";
   private String inpCat = "100";
   private String inpCaisse = "";
   private int inpEtat = 0;
   private String periode;
   private String inpNum = "";
   private String inpDestinataire = "";
   private String inpResponsable = "";
   private String inpCommercial = "";
   private String inpActivite = "100";
   private String inpParc = "100";
   private String inpDossier = "100";
   private String inpRegion = "";
   private String inpSecteur = "";
   private String inpContener = "";
   private String inpPdv = "";
   private List mesSecteursItems = new ArrayList();
   private List mesPdvItems = new ArrayList();
   private String inpSite = "";
   private String inpDepartement = "";
   private String inpService = "";
   private List mesDepartementsItems = new ArrayList();
   private List mesServicesItems = new ArrayList();
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean selectDestinataire = false;
   private boolean var_more_search = false;
   private UtilNombre utilNombre = new UtilNombre();
   private boolean var_acc_document = false;
   private boolean var_acc_imputation = false;
   private boolean var_acc_complement = false;
   private boolean var_acc_reglement = false;
   private boolean var_acc_dre = false;
   private boolean var_acc_habilitation = false;
   private boolean var_acc_etat = false;
   private boolean var_acc_tracabilite = false;
   private boolean var_acc_exoneration = false;
   private boolean var_ajt = false;
   private boolean var_mod = false;
   private boolean var_sup = false;
   private boolean var_imp = false;
   private boolean var_verrou_comm = false;
   private Habilitation habilitation;
   private UtilParapheur utilParapheur;
   private ParapheurDao parapheurDao;
   private Parapheur parapheur;
   private UtilTdt utilTdt = new UtilTdt();
   private boolean showModalPanelPrint = false;
   private String infoOrigineDoc;
   private boolean var_anal_activite = false;
   private boolean var_anal_dossier = false;
   private boolean var_anal_parc = false;
   private boolean showModalPanelTrf = false;
   private transient DataModel datamodelTransfert = new ListDataModel();
   private List documentDetailTrf = new ArrayList();
   private Date var_date_trf = null;
   private int var_type_trf;
   private String var_mode_trf;
   private String var_serie_trf;
   private String var_modele_trf;
   private boolean var_aff_trf = false;
   private List mesSeriesTrfItems = new ArrayList();
   private List modeleTrfItems = new ArrayList();
   private double var_montant_trf;
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
   private int var_timbre;
   private int var_tc_type;
   private String var_tc_libelle;
   private float var_tc_taux;
   private boolean var_tc_calcul;
   private String libelleNatureTransport;
   private String libellePortTransport;
   private List listeFacturesEntete = new ArrayList();
   private transient DataModel dataModelFactures = new ListDataModel();
   private FactureEnteteVentesDao factureEnteteVentesDao;
   private double prixMinimal;
   private List listeFacturesInterneEntete = new ArrayList();
   private transient DataModel dataModelFacturesGroupe = new ListDataModel();
   private FactureInterneEnteteVentesDao factureInterneEnteteVentesDao;
   private transient DataModel dataModelEcriture = new ListDataModel();
   private boolean showModalPanelImportation = false;
   private List lesImportations;
   private transient DataModel dataModelImportation;
   private boolean showModalPanelImportationErreur = false;
   private List lesImportationsErreur;
   private transient DataModel dataModelImportationErreur;

   public FormManifestePrc() throws IOException, SAXException, JDOMException {
   }

   public void InstancesDaoUtilses() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.manifestEnteteDao = new ManifestEnteteDao(this.baseLog, this.utilInitHibernate);
      this.manifestLigneDao = new ManifestLigneDao(this.baseLog, this.utilInitHibernate);
      this.manifestProduitDao = new ManifestProduitDao(this.baseLog, this.utilInitHibernate);
      this.usersDao = new UserDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.equipesDao = new EquipesDao(this.baseLog, this.utilInitHibernate);
      this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
      this.parcDao = new ParcDao(this.baseLog, this.utilInitHibernate);
      this.transitLieuVentesDao = new TransitLieuVentesDao(this.baseLog, this.utilInitHibernate);
      this.transitPortVentesDao = new TransitPortVentesDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.salariesDao = new SalariesDao(this.baseLog, this.utilInitHibernate);
      this.produitsVtesDao = new ProduitsVtesDao(this.baseLog, this.utilInitHibernate);
      this.taxesVentesDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      this.produitsTarifDao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
      this.baremesDao = new BaremesDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      this.factureEnteteVentesDao = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.factureInterneEnteteVentesDao = new FactureInterneEnteteVentesDao(this.baseLog, this.utilInitHibernate);
   }

   public void configVentes(Session var1) throws HibernateException, NamingException {
      if (this.structureLog.getStrtypeentreprise() == null || this.structureLog.getStrtypeentreprise().isEmpty()) {
         this.structureLog.setStrtypeentreprise("0");
      }

      if (this.optionsVentes.getDecrmtPrsChrStock() == null || this.optionsVentes.getDecrmtPrsChrStock().isEmpty()) {
         this.optionsVentes.setDecrmtPrsChrStock("0");
      }

      if (!this.optionsVentes.getLib1ENTETE().isEmpty() && !this.optionsVentes.getLib2ENTETE().isEmpty() && !this.optionsVentes.getLib3ENTETE().isEmpty() && !this.optionsVentes.getLib4ENTETE().isEmpty() && !this.optionsVentes.getLib5ENTETE().isEmpty() && !this.optionsVentes.getLib6ENTETE().isEmpty() && !this.optionsVentes.getLib7ENTETE().isEmpty() && !this.optionsVentes.getLib8ENTETE().isEmpty() && !this.optionsVentes.getLib9ENTETE().isEmpty() && !this.optionsVentes.getLib10ENTETE().isEmpty()) {
         this.visibleOngleEntete = false;
      } else {
         this.visibleOngleEntete = true;
      }

      if (this.optionsVentes.getNbLigneMax() != null && !this.optionsVentes.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionsVentes.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      if (this.optionsVentes.getAxeActivite().equals("true")) {
         this.var_anal_activite = true;
      } else {
         this.var_anal_activite = false;
      }

      if (this.optionsVentes.getAxeDossier().equals("1")) {
         this.var_anal_dossier = true;
         this.var_contener_parc = true;
      } else if (this.optionsVentes.getAxeDossier().equals("2")) {
         this.var_anal_dossier = false;
         this.var_contener_parc = false;
      } else {
         this.var_anal_dossier = false;
         this.var_contener_parc = false;
      }

      this.var_anal_parc = false;
      this.periode = this.optionParcs.getAffichInGlobViewMANIFESTE();
      if (this.habilitation != null) {
         this.existParapheur = true;
      } else {
         this.existParapheur = false;
      }

      LectureManifest var2 = new LectureManifest(this.baseLog);
      this.mesNaturesManifestItems = var2.getMesNatureManifestItems();
      this.mesVehiculesItems = this.parcDao.chargerLesParcsCamions(var1);
      this.mesRemorquesItems = this.parcDao.chargerLesParcsRemorques(var1);
      this.mesChauffeursItemsExp = this.salariesDao.chargerlesSalariesByProfessionItem("CONDUCTEUR", var1);
      if (this.mesChauffeursItemsExp == null || this.mesChauffeursItemsExp.size() == 0) {
         this.mesChauffeursItemsExp.add(new SelectItem("", ""));
      }

      this.mesChauffeursItemsDest = this.mesChauffeursItemsExp;
      this.mesResponsablesItemsExp = this.salariesDao.chargerlesSalariesByProfessionItem("RESPONSABLE", var1);
      if (this.mesResponsablesItemsExp == null || this.mesResponsablesItemsExp.size() == 0) {
         this.mesResponsablesItemsExp.add(new SelectItem("", ""));
      }

      this.mesResponsablesItemsDest = this.mesResponsablesItemsExp;
      this.mesClientsItems = this.tiersDao.chargerLesClientsItems(var1);
      if (this.optionParcs.getProduitMANIFEST().equals("0")) {
         new ArrayList();
         List var3 = this.produitsVtesDao.selectAllProduits(var1);
         if (var3.size() != 0) {
            for(int var4 = 0; var4 < var3.size(); ++var4) {
               this.mesProduitsItems.add(new SelectItem(((Produits)var3.get(var4)).getProCode(), ((Produits)var3.get(var4)).getProLibClient()));
            }
         }
      } else {
         this.mesProduitsItems.clear();
      }

      if (this.optionParcs.getContenerMANIFEST().equals("1")) {
         this.mesContenerItems = this.parcDao.chargerLesParcsConteneurs(var1);
         this.mesContener1Items = this.mesContenerItems;
      } else {
         this.mesContenerItems.clear();
         this.mesContener1Items.clear();
      }

      this.prixMinimal = Double.parseDouble(this.optionParcs.getMinimumMANIFEST());
      this.initPage();
      this.utilParapheur = new UtilParapheur(this.utilInitHibernate, this.structureLog, this.baseLog, this.usersLog);
   }

   public void accesResteintUser() {
      this.visibiliteBton = false;
      if (this.usersLog.getUsrCommVentes() == 2) {
         this.var_verrou_comm = false;
      } else {
         this.var_verrou_comm = true;
      }

   }

   public void accesResteintGroupe() {
      this.var_acc_document = false;
      this.var_acc_imputation = false;
      this.var_acc_complement = false;
      this.var_acc_reglement = false;
      this.var_acc_dre = false;
      this.var_acc_habilitation = false;
      this.var_acc_etat = false;
      this.var_acc_tracabilite = false;
      this.var_acc_exoneration = false;
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
            } else if (var1.getCode().equals("54")) {
               this.var_acc_reglement = true;
            } else if (var1.getCode().equals("55")) {
               this.var_acc_dre = true;
            } else if (var1.getCode().equals("56")) {
               this.var_acc_habilitation = true;
            } else if (var1.getCode().equals("57")) {
               this.var_acc_etat = true;
            } else if (var1.getCode().equals("58")) {
               this.var_acc_tracabilite = true;
            } else if (var1.getCode().equals("59")) {
               this.var_acc_exoneration = true;
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
               break;
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
               break;
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
               break;
            }
         }
      }

   }

   public void autorisationReglement() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("54")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationDre() {
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
               break;
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
               break;
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
               break;
            }
         }
      }

   }

   public void autorisationTracabilite() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("58")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void autorisationExoneration() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("59")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
               break;
            }
         }
      }

   }

   public void initPage() {
      this.selectDestinataire = false;
      this.var_action = 0;
      this.montantHt = 0.0D;
      this.montantTTva = 0.0D;
      this.montantTtc = 0.0D;
      this.montantSolde = 0.0D;
      this.montantReglement = 0.0D;
      this.montantTtcElmt = 0.0D;
      this.montantSoldeElmt = 0.0D;
      this.montantReglementElmt = 0.0D;
      this.inpSerie = "100";
      this.inpCat = "100";
      this.inpRegion = "";
      this.inpSecteur = "";
      this.inpPdv = "";
      this.inpSite = "";
      this.inpDepartement = "";
      this.inpService = "";
      this.inpEtat = 0;
      this.lesEntetesList.clear();
      this.lesLignesList.clear();
      this.lesDecoupagesActivites.clear();
      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
   }

   public void chargerCommerciauxResponsable(Session var1) throws HibernateException, NamingException, JDOMException, IOException {
      this.lesEquipes.clear();
      this.lesEquipes = this.equipesDao.selectEquipes(var1);
      this.mesEquipeItem.clear();
      if (this.lesEquipes.size() != 0) {
         this.mesEquipeItem.add(new SelectItem(0, ""));

         for(int var2 = 0; var2 < this.lesEquipes.size(); ++var2) {
            this.mesEquipeItem.add(new SelectItem(((Equipes)this.lesEquipes.get(var2)).getEquCode() + ":" + ((Equipes)this.lesEquipes.get(var2)).getEquNomFr()));
         }
      }

      new ArrayList();
      List var6 = this.usersDao.chargerLesSignataires("Ventes", var1);
      this.mesUsersItem.clear();
      if (var6.size() != 0) {
         for(int var3 = 0; var3 < var6.size(); ++var3) {
            Users var4 = (Users)var6.get(var3);
            if (var4.getUsrVendeur() == 1 && var4.getUsrPatronyme() != null && !var4.getUsrPatronyme().isEmpty()) {
               this.mesUsersItem.add(new SelectItem(var4.getUsrid(), var4.getUsrPatronyme()));
            }
         }
      }

      new ArrayList();
      List var7 = this.usersDao.chargerLesCommerciaux(var1);
      this.mesCommercialItem.clear();
      if (var7.size() != 0) {
         for(int var8 = 0; var8 < var7.size(); ++var8) {
            Users var5 = (Users)var7.get(var8);
            if (var5.getUsrVendeur() == 1 && var5.getUsrPatronyme() != null && !var5.getUsrPatronyme().isEmpty()) {
               this.mesCommercialItem.add(new SelectItem(var5.getUsrid(), var5.getUsrPatronyme()));
            }
         }
      }

   }

   public void chargerLesDepartements() throws HibernateException, NamingException {
      this.mesDepartementsItems.clear();
      this.mesServicesItems.clear();
      if (this.inpSite != null && !this.inpSite.isEmpty()) {
         new Site();
         SiteDao var2 = new SiteDao(this.baseLog, this.utilInitHibernate);
         String[] var3 = this.inpSite.split(":");
         Site var1 = var2.rechercheSite(var3[0], (Session)null);
         if (var1 != null) {
            DepartementDao var4 = new DepartementDao(this.baseLog, this.utilInitHibernate);
            this.mesDepartementsItems = var4.listDepartementBySite(var1, (Session)null);
         }
      }

   }

   public void chargerLesServices() throws HibernateException, NamingException {
      this.mesServicesItems.clear();
      if (this.inpDepartement != null && !this.inpDepartement.isEmpty()) {
         new Departement();
         DepartementDao var2 = new DepartementDao(this.baseLog, this.utilInitHibernate);
         String[] var3 = this.inpDepartement.split(":");
         Departement var1 = var2.rechercheDepartement(var3[0], (Session)null);
         if (var2 != null) {
            this.serviceDao = new ServiceDao(this.baseLog, this.utilInitHibernate);
            this.mesServicesItems = this.serviceDao.listServiceByDepartement(var1, (Session)null);
         }
      }

   }

   public void rechercheDOCUMENT(long var1) throws HibernateException, NamingException {
      this.lesLignesList.clear();
      this.lesLignesProduit.clear();
      this.manifestEntete = this.manifestEnteteDao.pourParapheur(var1, (Session)null);
      if (this.manifestEntete != null) {
         this.lesLignesList = this.manifestLigneDao.chargerLesLignesGroupe(this.manifestEntete, (Session)null);
      }

   }

   public void moreSearch() throws ParseException {
      this.selectDestinataire = false;
      this.inpRegion = "";
      this.inpSecteur = "";
      this.inpPdv = "";
      this.inpSite = "";
      this.inpDepartement = "";
      this.inpService = "";
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
         this.inpDestinataire = "";
         this.inpResponsable = "";
         this.inpCommercial = "";
         this.inpActivite = "100";
      }

   }

   public void executerRequete() throws IOException, HibernateException, NamingException, ParseException {
      if (this.usersLog.getUsrProdService() == 1 && this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty()) {
         this.inpSite = this.usersLog.getUsrSite();
         this.inpDepartement = this.usersLog.getUsrDepartement();
         this.inpService = this.usersLog.getUsrService();
      } else {
         this.inpSite = "";
         this.inpDepartement = "";
         this.inpService = "";
      }

      this.chargeListeDetail((Session)null);
   }

   public void executerRequete(Session var1) throws IOException, HibernateException, NamingException, ParseException {
      if (this.usersLog.getUsrProdService() == 1 && this.usersLog.getUsrService() != null && !this.usersLog.getUsrService().isEmpty()) {
         this.inpSite = this.usersLog.getUsrSite();
         this.inpDepartement = this.usersLog.getUsrDepartement();
         this.inpService = this.usersLog.getUsrService();
      } else {
         this.inpSite = "";
         this.inpDepartement = "";
         this.inpService = "";
      }

      this.chargeListeDetail(var1);
   }

   public void chargeListeDetail(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesEntetesList.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      double var2 = 0.0D;
      double var4 = 0.0D;
      double var6 = 0.0D;
      double var8 = 0.0D;
      this.var_nb_ligne = 0;
      String var10 = "";
      String var11 = "";
      if (this.var_more_search) {
         if (this.inpDu != null) {
            var10 = this.utilDate.dateToStringSQLLight(this.inpDu);
         }

         if (this.inpAu != null) {
            var11 = this.utilDate.dateToStringSQLLight(this.inpAu);
         }
      } else {
         var10 = null;
         var11 = null;
      }

      if (this.inpNum != null && !this.inpNum.isEmpty()) {
         this.inpEtat = 100;
      }

      int var13;
      if (this.inpEtat != 50) {
         if (this.inpService != null && !this.inpService.isEmpty() && this.inpService.equals("100")) {
            this.inpService = "";
         }

         new ArrayList();
         List var12 = this.manifestEnteteDao.recherche(var1, this.exercicesParc.getExeprcId(), this.inpNum, this.inpEtat, this.inpSerie, this.periode, this.inpResponsable, this.inpCommercial, this.inpActivite, var10, var11, this.inpSite, this.inpDepartement, this.inpService);
         if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":") || this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":") || this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
            boolean var19 = false;
            boolean var14 = false;
            boolean var15 = false;
            new ManifestEntete();

            for(int var17 = 0; var17 < var12.size(); ++var17) {
               ManifestEntete var16 = (ManifestEntete)var12.get(var17);
               if (var16.getVtemanActivite() != null && !var16.getVtemanActivite().isEmpty()) {
                  if (this.var_colonne1 != null && !this.var_colonne1.isEmpty() && this.var_colonne1.contains(":")) {
                     if (var16.getVtemanActivite().contains(this.var_colonne1)) {
                        var19 = true;
                     } else {
                        var19 = false;
                     }
                  } else {
                     var19 = true;
                  }

                  if (this.var_colonne2 != null && !this.var_colonne2.isEmpty() && this.var_colonne2.contains(":")) {
                     if (var16.getVtemanActivite().contains(this.var_colonne2)) {
                        var14 = true;
                     } else {
                        var14 = false;
                     }
                  } else {
                     var14 = true;
                  }

                  if (this.var_colonne3 != null && !this.var_colonne3.isEmpty() && this.var_colonne3.contains(":")) {
                     if (var16.getVtemanActivite().contains(this.var_colonne3)) {
                        var15 = true;
                     } else {
                        var15 = false;
                     }
                  } else {
                     var15 = true;
                  }

                  if (var19 && var14 && var15) {
                     this.lesEntetesList.add(var16);
                  }
               }
            }
         } else {
            for(var13 = 0; var13 < var12.size(); ++var13) {
               this.lesEntetesList.add(var12.get(var13));
            }
         }
      }

      if (this.lesEntetesList.size() > 0) {
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         new ManifestEntete();

         for(var13 = 0; var13 < this.lesEntetesList.size(); ++var13) {
            ManifestEntete var18 = (ManifestEntete)this.lesEntetesList.get(var13);
            var6 += var18.getVtemanTotalHt();
            var8 += var18.getVtemanTotalTva();
            var2 = var2 + var18.getVtemanTotalTtc() + var18.getVtemanTc();
            var4 += var18.getVtemanTotalReglement();
         }

         this.var_nb_ligne = this.lesEntetesList.size();
      }

      this.montantTtc = var2;
      this.montantHt = var6;
      this.montantTTva = var8;
      this.montantTtc = var2;
      this.montantReglement = var4;
      this.montantSolde = var2 - var4;
      this.visibiliteBton = false;
      this.inpDestinataire = "";
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
            this.manifestEntete = (ManifestEntete)var1.get(0);
            this.var_date = this.manifestEntete.getVtemanDateDep();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEntete");
            this.var_nom_responsable = this.manifestEntete.getVtemanIdResponsable();
            this.var_nom_commercial = this.manifestEntete.getVtemanIdCommercial();
            this.var_nom_equipe = this.manifestEntete.getVtemanIdEquipe();
            this.calculeLibelle(var4);
            this.chargerDocumentLigne(var4);
            this.chargerDocumentFacture(var4);
            this.chargerUserChrono(var4);
            this.chargerParapheur(var4);
            if (this.decoupageActivite) {
               this.chargerDetailanalytique();
               this.controleEcartAnalytique();
            }

            if (this.mesUsersItem == null || this.mesUsersItem.size() == 0) {
               this.chargerCommerciauxResponsable(var4);
               this.var_nom_responsable = 0L;
            }

            if (this.mesCommercialItem == null || this.mesCommercialItem.size() == 0) {
               this.chargerCommerciauxResponsable(var4);
               this.var_nom_commercial = 0L;
            }

            this.mesLieuxItemsDep.clear();
            if (this.manifestEntete.getVtemanRefPortDep() != null && !this.manifestEntete.getVtemanRefPortDep().isEmpty()) {
               this.mesLieuxItemsDep = this.transitLieuVentesDao.chargerLesLieux(this.manifestEntete.getVtemanRefPortDep(), var4);
            }

            this.mesLieuxItemsArr.clear();
            if (this.manifestEntete.getVtemanRefPortArr() != null && !this.manifestEntete.getVtemanRefPortArr().isEmpty()) {
               this.mesLieuxItemsArr = this.transitLieuVentesDao.chargerLesLieux(this.manifestEntete.getVtemanRefPortArr(), var4);
            }

            this.numLigne = 0;
            this.verrouNum = true;
            this.visibiliteBton = true;
            this.visibiliteBtonlig = false;
            this.var_aff_action_lv = false;
            this.utilInitHibernate.closeSession();
            if (this.manifestEntete.getVtemanEtat() != 4 && (this.listeFacturesEntete.size() != 0 || this.listeFacturesInterneEntete.size() != 0)) {
               this.manifestEntete.setVtemanEtat(4);
               this.manifestEntete = this.manifestEnteteDao.modif(this.manifestEntete);
            }

            this.setMontantTtcElmt(this.manifestEntete.getVtemanTotalTtc() + this.manifestEntete.getVtemanTc());
            this.setMontantReglementElmt(this.manifestEntete.getVtemanTotalReglement());
            this.setMontantSoldeElmt(this.manifestEntete.getVtemanTotalTtc() + this.manifestEntete.getVtemanTc() - this.manifestEntete.getVtemanTotalReglement());
            this.cumulPrixFinal();
         } else {
            this.visibiliteBton = false;
         }
      } else {
         this.visibiliteBton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.manifestEntete != null) {
         if (this.manifestEntete.getVtemanEtat() == 0) {
            this.modifDocument();
         } else {
            this.consultDocument();
         }
      }

   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.var_valide_lv = false;
      this.var_valide_prd = false;
      this.lesLignesList.clear();
      this.lesLignesProduit.clear();
      if (this.manifestEntete.getVtemanId() > 0L) {
         this.lesLignesList = this.manifestLigneDao.chargerLesLignes(this.manifestEntete, var1);
      }

      this.datamodelLigne.setWrappedData(this.lesLignesList);
      this.datamodelProduit.setWrappedData(this.lesLignesProduit);
   }

   public void chargerDocumentFacture(Session var1) throws HibernateException, NamingException {
      this.listeFacturesEntete.clear();
      String var2;
      if (this.manifestEntete != null) {
         var2 = "facAnal4='" + this.manifestEntete.getVtemanNum() + "'";
         this.listeFacturesEntete = this.factureEnteteVentesDao.rechercheFactureRequete(var2, var1);
      }

      this.dataModelFactures.setWrappedData(this.listeFacturesEntete);
      this.listeFacturesInterneEntete.clear();
      if (this.manifestEntete != null) {
         var2 = "fitAnal4='" + this.manifestEntete.getVtemanNum() + "'";
         this.listeFacturesInterneEntete = this.factureInterneEnteteVentesDao.rechercheFactureInterneRequete(var2, var1);
      }

      this.dataModelFacturesGroupe.setWrappedData(this.listeFacturesInterneEntete);
   }

   public void chargerUserChrono(Session var1) throws HibernateException, NamingException {
      if (this.manifestEntete != null && this.manifestEntete.getVtemanSerie() != null && !this.manifestEntete.getVtemanSerie().isEmpty()) {
         this.usersChrono = this.usersChronoDao.selectUnique(this.manifestEntete.getVtemanSerie(), this.nature, this.usersLog, var1);
      }

   }

   public void chargerParapheur(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         if (this.parapheurDao == null) {
            this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
         }

         this.parapheur = this.parapheurDao.existenceParapheur(this.manifestEntete.getVtemanId(), this.nature, var1);
         if (this.parapheur == null) {
            this.parapheur = new Parapheur();
         }
      } else {
         this.parapheur = new Parapheur();
      }

   }

   public void chargerEcritures() throws HibernateException, NamingException {
      if (this.manifestEntete != null) {
         String var1 = "";
         String var2 = "";
         int var3;
         if (this.listeFacturesEntete.size() != 0) {
            for(var3 = 0; var3 < this.listeFacturesEntete.size(); ++var3) {
               if (var1 != null && !var1.isEmpty()) {
                  var1 = var1 + "," + ((FactureEnteteVentes)this.listeFacturesEntete.get(var3)).getFacId();
               } else {
                  var1 = "" + ((FactureEnteteVentes)this.listeFacturesEntete.get(var3)).getFacId();
               }
            }
         }

         if (this.listeFacturesInterneEntete.size() != 0) {
            for(var3 = 0; var3 < this.listeFacturesInterneEntete.size(); ++var3) {
               if (var2 != null && !var2.isEmpty()) {
                  var2 = var2 + "," + ((FactureInterneEnteteVentes)this.listeFacturesInterneEntete.get(var3)).getFitId();
               } else {
                  var2 = "" + ((FactureInterneEnteteVentes)this.listeFacturesInterneEntete.get(var3)).getFitId();
               }
            }
         }

         new ArrayList();
         EcrituresDao var4 = new EcrituresDao(this.baseLog, this.utilInitHibernate);
         String var5 = " (ecrDossier='" + this.manifestEntete.getVtemanNum() + "' and ecrIdOrigine = 0)";
         if (var1 != null && !var1.isEmpty()) {
            var5 = var5 + " or (ecrTypeOrigine = '25' and ecrIdOrigine in (" + var1 + "))";
         }

         if (var2 != null && !var2.isEmpty()) {
            var5 = var5 + " or (ecrTypeOrigine = '142' and ecrIdOrigine in (" + var2 + "))";
         }

         List var6 = var4.ChargerLesEcrituresRecherche(var5, (Session)null);
         this.dataModelEcriture.setWrappedData(var6);
      }

   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.manifestEntete.getVtemanActivite() != null && !this.manifestEntete.getVtemanActivite().isEmpty() && this.manifestEntete.getVtemanActivite().contains(":")) {
         String[] var1 = null;
         if (!this.manifestEntete.getVtemanActivite().contains("#")) {
            var1 = this.manifestEntete.getVtemanActivite().split(":");
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
            String[] var2 = this.manifestEntete.getVtemanActivite().split("#");

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
   }

   public void ajoutDocument() throws IOException, JDOMException, HibernateException, NamingException {
      this.manifestEntete = new ManifestEntete();
      this.manifestLigne = new ManifestLigne();
      this.manifestEntete.setVtemanUserCreat(this.usersLog.getUsrid());
      this.manifestEntete.setVtemanDateDep(new Date());
      this.var_date = new Date();
      boolean var1 = false;
      if (this.optionsVentes.getNbrJrRelanceFAC() != null && !this.optionsVentes.getNbrJrRelanceFAC().isEmpty()) {
         int var3 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceFAC());
      } else {
         var1 = false;
      }

      boolean var2 = false;
      if (this.optionsVentes.getNbrJrValidFAC() != null && !this.optionsVentes.getNbrJrValidFAC().isEmpty()) {
         int var4 = Integer.parseInt(this.optionsVentes.getNbrJrValidFAC());
      } else {
         var2 = false;
      }

      this.var_nom_responsable = 0L;
      this.lesLignesList.clear();
      this.var_action = 1;
      this.var_memo_action = this.var_action;
      this.var_aff_action = false;
      this.var_valide_doc = false;
      this.var_valide_lv = false;
      this.var_valide_prd = false;
      this.verrouNum = false;
      this.visibleOnglet = false;
      this.visibiliteBtonlig = false;
      this.selectDestinataire = true;
      this.var_nom_commercial = 0L;
      this.var_nom_equipe = 0L;
      this.var_nom_responsable = 0L;
      this.mesLieuxItemsDep.clear();
      this.mesLieuxItemsArr.clear();
      this.listeFacturesEntete.clear();
      this.dataModelFactures.setWrappedData(this.listeFacturesEntete);
      this.numLigne = 0;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
      }

      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      this.calculeLibelle();
      this.autorisationDocument();
      this.addLigne();
   }

   public void modifDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.manifestEntete != null) {
         this.var_action = 1;
         this.var_memo_action = this.var_action;
         this.var_aff_action = false;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.selectDestinataire = true;
         this.autorisationDocument();
         this.addLigne();
         this.cumulPrixFinal();
      }

   }

   public void consultDocument() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.manifestEntete != null) {
         this.var_action = 2;
         this.var_memo_action = this.var_action;
         this.var_aff_action = true;
         this.visibleOnglet = true;
         this.var_valide_doc = true;
         this.selectDestinataire = true;
         this.autorisationDocument();
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.manifestEntete != null) {
         PlansAnalytiquesDao var1 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEntete");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            if (this.manifestEntete.getVtemanEtat() == 0 && this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               this.manifestEntete.setVtemanEtat(1);
               this.manifestEntete.setVtemanDateValide(new Date());
               this.manifestEntete = this.manifestEnteteDao.modif(this.manifestEntete, var2);
               this.plansAnalytiques = var1.rechercheAnal("6", this.manifestEntete.getVtemanNum(), var2);
               if (this.plansAnalytiques == null) {
                  this.plansAnalytiques = new PlansAnalytiques();
                  this.plansAnalytiques.setAnaDateCreat(new Date());
                  this.plansAnalytiques.setAnaUserCreat(this.usersLog.getUsrid());
                  this.plansAnalytiques.setAnaNature("6");
                  this.plansAnalytiques.setAnaCode(this.manifestEntete.getVtemanNum());
                  this.plansAnalytiques.setAnaNomFr("Transport de " + this.manifestEntete.getVtemanLibPortDep() + " à " + this.manifestEntete.getVtemanLibPortArr());
                  this.plansAnalytiques.setAnaNomSp("");
                  this.plansAnalytiques.setAnaNomUk("");
                  if (this.manifestEntete.getVtemanDateDep() != null) {
                     this.plansAnalytiques.setAnaAnnee("" + (this.manifestEntete.getVtemanDateDep().getYear() + 1900));
                  } else {
                     this.plansAnalytiques.setAnaAnnee((String)null);
                  }

                  this.plansAnalytiques = var1.insert(this.plansAnalytiques, var2);
               }

               Espion var4 = new Espion();
               var4.setUsers(this.usersLog);
               var4.setEsptype(0);
               var4.setEspdtecreat(new Date());
               var4.setEspaction("Validation manuelle manifest (C.) N° " + this.manifestEntete.getVtemanNum() + " du " + this.utilDate.dateToStringSQLLight(this.manifestEntete.getVtemanDateDep()));
               this.espionDao.mAJEspion(var4, var2);
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
      }

   }

   public void deValideDocument() throws HibernateException, NamingException {
      if (this.manifestEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.manifestEntete.getVtemanEtat() == 1) {
               this.manifestEntete.setVtemanEtat(0);
               this.manifestEntete.setVtemanDateValide((Date)null);
               this.manifestEntete = this.manifestEnteteDao.modif(this.manifestEntete, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dévalidation manuelle manifest (C.) N° " + this.manifestEntete.getVtemanNum() + " du " + this.utilDate.dateToStringSQLLight(this.manifestEntete.getVtemanDateDep()));
               this.espionDao.mAJEspion(var3, var1);
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

   }

   public void valideTout() throws HibernateException, NamingException {
      if (this.lesEntetesList.size() != 0) {
         PlansAnalytiquesDao var1 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
         Session var2 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEntete");
         Transaction var3 = null;

         try {
            var3 = var2.beginTransaction();
            if (this.habilitation == null && this.usersChrono.getUsrchrValidation() == 2) {
               for(int var4 = 0; var4 < this.lesEntetesList.size(); ++var4) {
                  this.manifestEntete = (ManifestEntete)this.lesEntetesList.get(var4);
                  if (this.manifestEntete.getVtemanEtat() == 0) {
                     this.manifestEntete.setVtemanEtat(1);
                     this.manifestEntete = this.manifestEnteteDao.modif(this.manifestEntete, var2);
                     this.plansAnalytiques = var1.rechercheAnal("6", this.manifestEntete.getVtemanNum(), var2);
                     if (this.plansAnalytiques == null) {
                        this.plansAnalytiques = new PlansAnalytiques();
                        this.plansAnalytiques.setAnaDateCreat(new Date());
                        this.plansAnalytiques.setAnaUserCreat(this.usersLog.getUsrid());
                        this.plansAnalytiques.setAnaNature("6");
                        this.plansAnalytiques.setAnaCode(this.manifestEntete.getVtemanNum());
                        this.plansAnalytiques.setAnaNomFr("Transport de " + this.manifestEntete.getVtemanLibPortDep() + " à " + this.manifestEntete.getVtemanLibPortArr());
                        this.plansAnalytiques.setAnaNomSp("");
                        this.plansAnalytiques.setAnaNomUk("");
                        if (this.manifestEntete.getVtemanDateDep() != null) {
                           this.plansAnalytiques.setAnaAnnee("" + (this.manifestEntete.getVtemanDateDep().getYear() + 1900));
                        } else {
                           this.plansAnalytiques.setAnaAnnee((String)null);
                        }

                        this.plansAnalytiques = var1.insert(this.plansAnalytiques, var2);
                     }

                     Espion var5 = new Espion();
                     var5.setUsers(this.usersLog);
                     var5.setEsptype(0);
                     var5.setEspdtecreat(new Date());
                     var5.setEspaction("Validation manuelle manifest (C.) N° " + this.manifestEntete.getVtemanNum() + " du " + this.utilDate.dateToStringSQLLight(this.manifestEntete.getVtemanDateDep()));
                     this.espionDao.mAJEspion(var5, var2);
                  }
               }

               this.datamodelEntete.setWrappedData(this.lesEntetesList);
            }

            var3.commit();
         } catch (HibernateException var9) {
            if (var3 != null) {
               var3.rollback();
            }

            throw var9;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.visibiliteBton = false;
   }

   public void reactiverDocument() throws HibernateException, NamingException {
      if (this.manifestEntete != null) {
         this.manifestEntete.setVtemanEtat(0);
         this.manifestEntete.setVtemanDateAnnule((Date)null);
         this.manifestEntete.setVtemanMotifAnnule("");
         this.manifestEntete = this.manifestEnteteDao.modif(this.manifestEntete);
      }

   }

   public void supprimerDocument() throws HibernateException, NamingException {
      if (this.manifestEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.manifestEntete.getVtemanNum();
            Date var4 = this.manifestEntete.getVtemanDateDep();
            this.lesEntetesList.remove(this.manifestEntete);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.supprimerDocument(this.manifestEntete, var1);
            Espion var5 = new Espion();
            var5.setUsers(this.usersLog);
            var5.setEsptype(0);
            var5.setEspdtecreat(new Date());
            var5.setEspaction("Suppression MAnifeste N° " + var3 + " du " + var4);
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
      }

      this.visibiliteBton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void supprimerDocument(ManifestEntete var1, Session var2) throws HibernateException, NamingException {
      long var3 = var1.getVtemanId();
      this.manifestProduitDao.deleteAllLigne(var1.getVtemanNum(), var2);
      this.manifestLigneDao.deleteAllLigne(var1, var2);
      this.utilParapheur.supprimerParapheur(var1.getVtemanId(), this.nature, var2);
      this.manifestEnteteDao.delete(var1, var2);
   }

   public void transformerDocument() throws HibernateException, NamingException, ParseException {
      this.documentDetailTrf.clear();
      this.lesLignesList.clear();
      this.var_date_trf = this.utilDate.dateDernierJourMois(new Date());
      this.var_type_trf = 25;
      this.var_mode_trf = "";
      this.var_aff_trf = false;
      if (this.lesEntetesList.size() != 0) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEntete");
         new ManifestEntete();

         for(int var3 = 0; var3 < this.lesEntetesList.size(); ++var3) {
            ManifestEntete var2 = (ManifestEntete)this.lesEntetesList.get(var3);
            if (var2.getVtemanId() > 0L && var2.isVar_select_ligne()) {
               this.showModalPanelTrf = true;
               this.documentDetailTrf = this.manifestLigneDao.chargerLesLignes(var2, var1);
            }
         }

         this.lesLignesList.clear();
         this.datamodelTransfert.setWrappedData(this.documentDetailTrf);
         this.serieSelectTrf(var1);
         this.modeleSelectTrf();
         this.utilInitHibernate.closeSession();
      }

   }

   public void annule() throws IOException, JDOMException {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.visibleOnglet = false;
      this.visibiliteBton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void preSave() throws IOException, HibernateException, NamingException, Exception {
      boolean var1 = false;
      if (this.optionsVentes.getResponsable().equals("0")) {
         if (this.var_nom_responsable != 0L) {
            var1 = true;
         }
      } else if (this.optionsVentes.getResponsable().equals("1")) {
         if (this.var_nom_responsable != 0L && this.var_nom_commercial != 0L) {
            var1 = true;
         }
      } else if (this.optionsVentes.getResponsable().equals("2") && this.var_nom_responsable != 0L && this.var_nom_commercial != 0L) {
         var1 = true;
      }

      if (var1) {
         this.save();
      }

   }

   public void save() throws IOException, HibernateException, NamingException, Exception {
      this.verifieExistenceHabilitation((Session)null);
      Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEntete");
      this.cumulPrixFinal();
      Transaction var2 = null;

      try {
         var2 = var1.beginTransaction();
         this.majAnalytique(var1);
         this.manifestEntete.setVtemanDateDep(this.utilDate.dateToSQL(this.var_date, "00", "00", "00"));
         this.manifestEntete.setVtemanIdResponsable(0L);
         this.manifestEntete.setVtemanNomResponsable("");
         new Users();
         if (this.var_nom_responsable == 0L && this.mesUsersItem.size() == 1) {
            this.var_nom_responsable = Long.parseLong(((SelectItem)this.mesUsersItem.get(0)).getValue().toString());
         }

         Users var3 = this.usersDao.selectUserD(this.var_nom_responsable, var1);
         if (var3 != null) {
            this.manifestEntete.setVtemanIdResponsable(var3.getUsrid());
            this.manifestEntete.setVtemanNomResponsable(var3.getUsrPatronyme());
         }

         this.manifestEntete.setVtemanIdCommercial(0L);
         this.manifestEntete.setVtemanNomCommercial("");
         new Users();
         if (this.var_nom_commercial == 0L && this.mesCommercialItem.size() == 1) {
            this.var_nom_commercial = Long.parseLong(((SelectItem)this.mesCommercialItem.get(0)).getValue().toString());
         }

         Users var4 = this.usersDao.selectUserD(this.var_nom_commercial, var1);
         if (var4 != null) {
            this.manifestEntete.setVtemanIdCommercial(var4.getUsrid());
            this.manifestEntete.setVtemanNomCommercial(var4.getUsrPatronyme());
         }

         this.manifestEntete.setVtemanIdEquipe(0L);
         this.manifestEntete.setVtemanNomEquipe("");
         this.manifestEntete.setVtemanKmsDep(0.0D);
         this.manifestEntete.setVtemanLibPortDep("");
         TransitPortVentes var5;
         if (this.manifestEntete.getVtemanRefPortDep() != null && !this.manifestEntete.getVtemanRefPortDep().isEmpty()) {
            new TransitPortVentes();
            var5 = this.transitPortVentesDao.rechercherTransitPortVentes(this.manifestEntete.getVtemanRefPortDep(), var1);
            if (var5 != null) {
               this.manifestEntete.setVtemanLibPortDep(var5.getTraprtLibelleFr());
               this.manifestEntete.setVtemanKmsDep(var5.getTraprtKms());
            }
         }

         this.manifestEntete.setVtemanKmsArr(0.0D);
         this.manifestEntete.setVtemanLibPortArr("");
         if (this.manifestEntete.getVtemanRefPortArr() != null && !this.manifestEntete.getVtemanRefPortArr().isEmpty()) {
            new TransitPortVentes();
            var5 = this.transitPortVentesDao.rechercherTransitPortVentes(this.manifestEntete.getVtemanRefPortArr(), var1);
            if (var5 != null) {
               this.manifestEntete.setVtemanLibPortArr(var5.getTraprtLibelleFr());
               this.manifestEntete.setVtemanKmsArr(var5.getTraprtKms());
            }
         }

         if (this.manifestEntete.getVtemanKmsDep() >= this.manifestEntete.getVtemanKmsArr()) {
            this.manifestEntete.setVtemanDistance(this.manifestEntete.getVtemanKmsDep() - this.manifestEntete.getVtemanKmsArr());
         } else {
            this.manifestEntete.setVtemanDistance(this.manifestEntete.getVtemanKmsArr() - this.manifestEntete.getVtemanKmsDep());
         }

         if (this.manifestEntete.getVtemanId() == 0L) {
            this.manifestEntete.setExercicesParc(this.exercicesParc);
            this.manifestEntete.setVtemanDateCreat(new Date());
            this.manifestEntete.setVtemanUserCreat(this.usersLog.getUsrid());
            if (this.manifestEntete.getVtemanSerie() != null && !this.manifestEntete.getVtemanSerie().equalsIgnoreCase("X") && !this.manifestEntete.getVtemanSerie().isEmpty()) {
               this.manifestEntete.setVtemanNum(this.calculChrono.numCompose(this.manifestEntete.getVtemanDateDep(), this.nature, this.manifestEntete.getVtemanSerie(), var1));
               boolean var17 = false;

               label222:
               while(true) {
                  while(true) {
                     if (var17) {
                        break label222;
                     }

                     new ManifestEntete();
                     ManifestEntete var6 = this.manifestEnteteDao.pourParapheur(this.manifestEntete.getVtemanNum(), this.manifestEntete.getVtemanSerie(), var1);
                     if (var6 != null) {
                        long var7 = 100000000L * this.usersLog.getUsrid();

                        for(long var9 = 0L; var9 < var7; ++var9) {
                        }

                        this.manifestEntete.setVtemanNum(this.calculChrono.numCompose(this.manifestEntete.getVtemanDateDep(), this.nature, this.manifestEntete.getVtemanSerie(), var1));
                        var17 = false;
                     } else {
                        var17 = true;
                     }
                  }
               }
            } else {
               long var16 = this.manifestEnteteDao.selectLastNum(var1);
               this.manifestEntete.setVtemanNum("" + var16);
            }

            this.manifestEntete.setVtemanEtat(0);
            this.manifestEntete.setVtemanEtatVal(0);
            this.manifestEntete.setVtemanDateValide((Date)null);
            this.manifestEntete = this.manifestEnteteDao.insert(this.manifestEntete, var1);
            this.visibleOnglet = true;
            this.var_action = 1;
            this.var_memo_action = this.var_action;
            this.lesEntetesList.add(this.manifestEntete);
            this.datamodelEntete.setWrappedData(this.lesEntetesList);
            this.simpleSelectionEntete.clear();
            this.extDTable = new HtmlExtendedDataTable();
         } else {
            if (this.manifestEntete.getVtemanEtat() == 6) {
               if (this.manifestEntete.getVtemanEtatVal() == 1) {
                  this.manifestEntete.setVtemanEtat(0);
               } else {
                  this.manifestEntete.setVtemanEtat(0);
               }
            }

            this.manifestEntete.setVtemanDateModif(new Date());
            this.manifestEntete.setVtemanUserModif(this.usersLog.getUsrid());
            this.manifestEntete = this.manifestEnteteDao.modif(this.manifestEntete, var1);
            this.var_action = 0;
            this.var_memo_action = this.var_action;
            this.visibleOnglet = false;
         }

         if (this.habilitation != null && this.var_action == 0) {
            this.utilParapheur.majParapheur(this.nature, this.habilitation, this.manifestEntete.getVtemanId(), this.manifestEntete.getVtemanNum(), this.manifestEntete.getVtemanNum(), this.manifestEntete.getVtemanDateDep(), "", 0.0D, this.manifestEntete.getVtemanModeleImp(), (Tiers)null, this.calculeCheminRapport(this.baseLog, this.nature), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionCommun(), this.calculeParc(var1), 0, 0, var1);
         }

         var2.commit();
      } catch (HibernateException var14) {
         if (var2 != null) {
            var2.rollback();
         }

         throw var14;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void majAnalytique(Session var1) throws HibernateException, NamingException {
      this.manifestEntete.setVtemanSite(this.usersLog.getUsrSite());
      this.manifestEntete.setVtemanDepartement(this.usersLog.getUsrDepartement());
      this.manifestEntete.setVtemanService(this.usersLog.getUsrService());
      if (!this.var_anal_activite) {
         this.manifestEntete.setVtemanActivite("");
      } else if (this.optionsVentes.getActiviteEnteteLigne().equals("0") && this.decoupageActivite) {
         String var2 = "";
         boolean var3 = true;
         if (this.lesDecoupagesActivites.size() != 0) {
            for(int var4 = 0; var4 < this.lesDecoupagesActivites.size(); ++var4) {
               this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var4);
               if (this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie() != 0.0D) {
                  if (var3) {
                     var2 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                     var3 = false;
                  } else {
                     var2 = var2 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                  }
               }
            }
         }

         this.manifestEntete.setVtemanActivite(var2);
      }

   }

   public boolean verifieExistenceHabilitation(Session var1) throws HibernateException, NamingException {
      if (this.habilitation != null) {
         this.manifestEntete.setVtemanEtatVal(1);
         this.manifestEntete.setVtemanEtat(0);
         this.manifestEntete.setVtemanDateValide((Date)null);
         return true;
      } else {
         this.manifestEntete.setVtemanEtatVal(0);
         this.chargerUserChrono(var1);
         if (this.usersChrono != null) {
            if (this.usersChrono.getUsrchrValidation() == 0) {
               this.manifestEntete.setVtemanEtat(1);
               this.manifestEntete.setVtemanDateValide(new Date());
            } else if (this.usersChrono.getUsrchrValidation() != 1 && this.usersChrono.getUsrchrValidation() != 2 && this.usersChrono.getUsrchrValidation() == 3) {
               this.manifestEntete.setVtemanEtat(0);
               this.manifestEntete.setVtemanDateValide((Date)null);
            }
         }

         return false;
      }
   }

   public void annulerDocument() {
      if (this.manifestEntete != null) {
         this.manifestEntete.setVtemanDateAnnule(new Date());
         this.showModalPanelAnnuler = true;
      }

   }

   public void annuleAnnulation() {
      this.showModalPanelAnnuler = false;
   }

   public void miseajourAnnuler() throws HibernateException, NamingException {
      if (this.manifestEntete != null) {
         if (this.manifestEntete.getVtemanDateAnnule() == null) {
            this.manifestEntete.setVtemanDateAnnule(new Date());
         }

         this.manifestEntete.setVtemanEtat(3);
         this.manifestEntete = this.manifestEnteteDao.modif(this.manifestEntete);
         Espion var1 = new Espion();
         var1.setUsers(this.usersLog);
         var1.setEsptype(0);
         var1.setEspdtecreat(new Date());
         var1.setEspaction("Annulation facture vente N° " + this.manifestEntete.getVtemanNum() + " le " + this.manifestEntete.getVtemanDateAnnule());
         this.espionDao.mAJEspion(var1);
         this.lesEntetesList.remove(this.manifestEntete);
         this.datamodelEntete.setWrappedData(this.lesEntetesList);
      }

      this.showModalPanelAnnuler = false;
      this.visibiliteBton = false;
   }

   public void calculeLieuDep() throws HibernateException, NamingException {
      if (this.manifestEntete != null) {
         if (this.manifestEntete.getVtemanRefPortDep() != null && !this.manifestEntete.getVtemanRefPortDep().isEmpty()) {
            this.mesLieuxItemsDep = this.transitLieuVentesDao.chargerLesLieux(this.manifestEntete.getVtemanRefPortDep(), (Session)null);
         } else {
            this.mesLieuxItemsDep.clear();
            this.manifestEntete.setVtemanRefLieuDep("");
            this.manifestEntete.setVtemanLibLieuDep("");
         }
      }

   }

   public void calculeLieuArr() throws HibernateException, NamingException {
      if (this.manifestEntete != null) {
         if (this.manifestEntete.getVtemanRefPortArr() != null && !this.manifestEntete.getVtemanRefPortArr().isEmpty()) {
            this.mesLieuxItemsArr = this.transitLieuVentesDao.chargerLesLieux(this.manifestEntete.getVtemanRefPortArr(), (Session)null);
         } else {
            this.mesLieuxItemsArr.clear();
            this.manifestEntete.setVtemanRefLieuArr("");
            this.manifestEntete.setVtemanLibLieuArr("");
         }
      }

   }

   public void calculeLibelle() throws HibernateException, NamingException {
      this.calculeLibelle((Session)null);
   }

   public void calculeLibelle(Session var1) throws HibernateException, NamingException {
      if (this.manifestEntete.getVtemanTypeTransport() != 0) {
         this.mesLieuxItemsDep.clear();
         this.mesLieuxItemsArr.clear();
         if (this.manifestEntete.getVtemanTypeTransport() == 1) {
            this.libelleNatureTransport = "Navire";
            this.libellePortTransport = "Port";
            this.mesNaviresItems = this.parcDao.chargerLesParcsBateaux(var1);
            this.mesPortsItemsDep = this.transitPortVentesDao.chargerLesPortsByNature(this.manifestEntete.getVtemanTypeTransport(), 0L, var1);
            this.mesPortsItemsArr = this.mesPortsItemsDep;
         } else if (this.manifestEntete.getVtemanTypeTransport() == 2) {
            this.libelleNatureTransport = "Navire";
            this.libellePortTransport = "Port";
            this.mesNaviresItems = this.parcDao.chargerLesParcsBateaux(var1);
            this.mesPortsItemsDep = this.transitPortVentesDao.chargerLesPortsByNature(this.manifestEntete.getVtemanTypeTransport(), 0L, var1);
            this.mesPortsItemsArr = this.mesPortsItemsDep;
         } else if (this.manifestEntete.getVtemanTypeTransport() == 3) {
            this.libelleNatureTransport = "Avion";
            this.libellePortTransport = "Aéroport";
            this.mesNaviresItems = this.parcDao.chargerLesParcsAvions(var1);
            this.mesPortsItemsDep = this.transitPortVentesDao.chargerLesPortsByNature(this.manifestEntete.getVtemanTypeTransport(), 0L, var1);
            this.mesPortsItemsArr = this.mesPortsItemsDep;
         } else if (this.manifestEntete.getVtemanTypeTransport() == 4) {
            this.libelleNatureTransport = "Camion";
            this.libellePortTransport = "Gare";
            this.mesNaviresItems = this.parcDao.chargerLesParcsCamions(var1);
            this.mesPortsItemsDep = this.transitPortVentesDao.chargerLesPortsByNature(this.manifestEntete.getVtemanTypeTransport(), 0L, var1);
            this.mesPortsItemsArr = this.mesPortsItemsDep;
         } else if (this.manifestEntete.getVtemanTypeTransport() == 5) {
            this.libelleNatureTransport = "Train";
            this.libellePortTransport = "Gare";
            this.mesNaviresItems = this.parcDao.chargerLesParcsTrains(var1);
            this.mesPortsItemsDep = this.transitPortVentesDao.chargerLesPortsByNature(this.manifestEntete.getVtemanTypeTransport(), 0L, var1);
            this.mesPortsItemsArr = this.mesPortsItemsDep;
         } else {
            this.libelleNatureTransport = "(Non référencé)";
            this.libellePortTransport = "(Non référencé)";
            this.mesNaviresItems.clear();
            this.mesPortsItemsDep.clear();
            this.mesLieuxItemsDep.clear();
            this.mesPortsItemsArr.clear();
            this.mesLieuxItemsArr.clear();
         }
      } else {
         this.libelleNatureTransport = "Non référencé";
         this.libellePortTransport = "Non référencé";
         this.mesNaviresItems.clear();
         this.mesPortsItemsDep.clear();
         this.mesLieuxItemsDep.clear();
         this.mesPortsItemsArr.clear();
         this.mesLieuxItemsArr.clear();
      }

      this.controleSaisie();
   }

   public void controleSaisie() {
      if (this.manifestEntete.getVtemanTypeTransport() != 0 && this.var_nom_responsable != 0L) {
         this.var_valide_doc = true;
      } else {
         this.var_valide_doc = false;
      }

   }

   public void chargerImportation() throws HibernateException, NamingException {
      ManifestEnteteImportDao var1 = new ManifestEnteteImportDao(this.baseLog, this.utilInitHibernate);
      this.lesImportations = new ArrayList();
      this.dataModelImportation = new ListDataModel();
      this.lesImportationsErreur = new ArrayList();
      this.dataModelImportationErreur = new ListDataModel();
      String var2 = "vtemanId > 0";
      this.lesImportations = var1.rechercheManifestRequete(var2, (Session)null);
      if (this.lesImportations.size() != 0) {
         this.dataModelImportation.setWrappedData(this.lesImportations);
         this.showModalPanelImportation = true;
      }

   }

   public void annuleImportation() {
      this.showModalPanelImportation = false;
   }

   public void majImportation() throws HibernateException, NamingException {
      new ArrayList();
      new ArrayList();
      ManifestEnteteImportDao var3 = new ManifestEnteteImportDao(this.baseLog, this.utilInitHibernate);
      ManifestLigneImporteDao var4 = new ManifestLigneImporteDao(this.baseLog, this.utilInitHibernate);
      ManifestEnteteImport var5 = new ManifestEnteteImport();
      new ManifestLigneImport();
      String var7 = "vtemanId > 0";
      List var1 = var3.rechercheManifestRequete(var7, (Session)null);
      if (var1.size() != 0) {
         new TransitPortVentes();
         new TransitLieuVentes();
         this.tiers = new Tiers();
         Session var10 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEnteteImport");
         Transaction var11 = null;

         try {
            var11 = var10.beginTransaction();
            List var2 = var4.chargerToutesLesLignes(var10);
            ManifestLigneImport var6;
            int var12;
            if (var2.size() != 0) {
               var12 = 0;

               while(true) {
                  if (var12 >= var2.size()) {
                     this.dataModelImportationErreur.setWrappedData(this.lesImportationsErreur);
                     break;
                  }

                  var6 = (ManifestLigneImport)var2.get(var12);
                  if (var6.getVtelvCompteClient() != null && !var6.getVtelvCompteClient().isEmpty()) {
                     this.tiers = this.tiersDao.chargerTiersByCompte(var6.getVtelvCompteClient(), var10);
                     if (this.tiers == null) {
                        var6.setVtelvAdresseDest("Le compte client n`existe pas.");
                        this.lesImportationsErreur.add(var6);
                     }
                  } else {
                     var6.setVtelvAdresseDest("Le compte client n`est pas renseigné.");
                     this.lesImportationsErreur.add(var6);
                  }

                  ++var12;
               }
            }

            boolean var13;
            int var14;
            for(var12 = 0; var12 < var1.size(); ++var12) {
               var5 = (ManifestEnteteImport)var1.get(var12);
               var13 = true;
               if (this.lesImportationsErreur.size() != 0) {
                  for(var14 = 0; var14 < this.lesImportationsErreur.size(); ++var14) {
                     if (var5.getVtemanNum() != null && !var5.getVtemanNum().isEmpty() && ((ManifestLigneImport)this.lesImportationsErreur.get(var14)).getVtelvNumManifest() != null && !((ManifestLigneImport)this.lesImportationsErreur.get(var14)).getVtelvNumManifest().isEmpty() && var5.getVtemanNum().equals(((ManifestLigneImport)this.lesImportationsErreur.get(var14)).getVtelvNumManifest())) {
                        var13 = false;
                     }
                  }
               }

               if (var13) {
                  this.manifestEntete = this.manifestEnteteDao.pourParapheur(var5.getVtemanNum(), "A", var10);
                  if (this.manifestEntete == null) {
                     this.manifestEntete = new ManifestEntete();
                  }

                  this.manifestEntete.setExercicesParc(this.exercicesParc);
                  this.manifestEntete.setVtemanEtat(0);
                  this.manifestEntete.setVtemanDateArr(var5.getVtemanDateArr());
                  this.manifestEntete.setVtemanDateDep(var5.getVtemanDateDep());
                  this.manifestEntete.setVtemanDateCreat(var5.getVtemanDateSaisie());
                  this.manifestEntete.setVtemanLibLieuArr(var5.getVtemanLibLieuArr());
                  this.manifestEntete.setVtemanLibLieuDep(var5.getVtemanLibLieuDep());
                  this.manifestEntete.setVtemanLibNavire(var5.getVtemanLibNavire());
                  this.manifestEntete.setVtemanLibPortArr(var5.getVtemanLibPortArr());
                  this.manifestEntete.setVtemanLibPortDep(var5.getVtemanLibPortDep());
                  this.manifestEntete.setVtemanNum(var5.getVtemanNum());
                  this.manifestEntete.setVtemanNumBl(var5.getVtemanNumBl());
                  this.manifestEntete.setVtemanObjet(var5.getVtemanObjet());
                  this.manifestEntete.setVtemanRefLieuArr(var5.getVtemanRefLieuArr());
                  this.manifestEntete.setVtemanRefLieuDep(var5.getVtemanRefLieuDep());
                  this.manifestEntete.setVtemanRefNavire(var5.getVtemanRefNavire());
                  this.manifestEntete.setVtemanRefPortArr(var5.getVtemanRefPortArr());
                  this.manifestEntete.setVtemanRefPortDep(var5.getVtemanRefPortDep());
                  if (var5.getVtemanTypeTransport() != null && !var5.getVtemanTypeTransport().isEmpty()) {
                     if (var5.getVtemanTypeTransport().equals("MMA")) {
                        this.manifestEntete.setVtemanTypeTransport(1);
                     } else if (var5.getVtemanTypeTransport().equals("MFL")) {
                        this.manifestEntete.setVtemanTypeTransport(2);
                     } else if (var5.getVtemanTypeTransport().equals("MAE")) {
                        this.manifestEntete.setVtemanTypeTransport(3);
                     } else if (var5.getVtemanTypeTransport().equals("MRO")) {
                        this.manifestEntete.setVtemanTypeTransport(4);
                     } else if (var5.getVtemanTypeTransport().equals("MFE")) {
                        this.manifestEntete.setVtemanTypeTransport(5);
                     } else {
                        this.manifestEntete.setVtemanTypeTransport(1);
                     }
                  } else {
                     this.manifestEntete.setVtemanTypeTransport(1);
                  }

                  this.manifestEntete.setVtemanSerie("A");
                  if (this.manifestEntete.getVtemanLoginUser() != null && !var5.getVtemanLoginUser().isEmpty()) {
                     this.salaries = this.salariesDao.chargerlesSalaries(var5.getVtemanLoginUser(), var10);
                     if (this.salaries != null) {
                        new Users();
                        Users var21 = this.usersDao.selectLeUserIdByAgent(this.salaries.getSalId(), var10);
                        if (var21 != null) {
                           this.manifestEntete.setVtemanIdResponsable(var21.getUsrid());
                           this.manifestEntete.setVtemanNomResponsable(var21.getUsrPatronyme());
                        } else {
                           this.manifestEntete.setVtemanIdResponsable(0L);
                           this.manifestEntete.setVtemanNomResponsable("");
                        }
                     } else {
                        this.manifestEntete.setVtemanIdResponsable(0L);
                        this.manifestEntete.setVtemanNomResponsable("");
                     }
                  } else {
                     this.manifestEntete.setVtemanIdResponsable(0L);
                     this.manifestEntete.setVtemanNomResponsable("");
                  }

                  if (this.manifestEntete.getVtemanId() == 0L) {
                     this.manifestEntete = this.manifestEnteteDao.insert(this.manifestEntete, var10);
                  } else {
                     this.manifestEntete = this.manifestEnteteDao.modif(this.manifestEntete, var10);
                  }

                  if (this.manifestEntete.getVtemanRefNavire() != null && !this.manifestEntete.getVtemanRefNavire().isEmpty()) {
                     this.parc = this.parcDao.rechercheParc(this.manifestEntete.getVtemanRefNavire(), var10);
                     if (this.parc == null) {
                        this.parc = new Parc();
                        this.parc.setPrcDateCreat(new Date());
                        this.parc.setPrcImmatriculation(this.manifestEntete.getVtemanRefNavire());
                        this.parc.setPrcUserCreat(this.usersLog.getUsrid());
                        this.parc.setPrcNomFr(this.manifestEntete.getVtemanLibNavire());
                        if (this.manifestEntete.getVtemanTypeTransport() != 0) {
                           if (this.manifestEntete.getVtemanTypeTransport() == 1) {
                              this.parc.setPrcNature(1743);
                              this.parc.setPrcLibNature("Bateau à moteur");
                           } else if (this.manifestEntete.getVtemanTypeTransport() == 2) {
                              this.parc.setPrcNature(1743);
                              this.parc.setPrcLibNature("Bateau à moteur");
                           } else if (this.manifestEntete.getVtemanTypeTransport() == 3) {
                              this.parc.setPrcNature(1756);
                              this.parc.setPrcLibNature("Cargo");
                           } else if (this.manifestEntete.getVtemanTypeTransport() == 4) {
                              this.parc.setPrcNature(1721);
                              this.parc.setPrcLibNature("Poids lourd");
                           } else if (this.manifestEntete.getVtemanTypeTransport() == 5) {
                              this.parc.setPrcNature(1732);
                              this.parc.setPrcLibNature("Wagon");
                           }
                        } else {
                           this.parc.setPrcNature(1743);
                           this.parc.setPrcLibNature("Bateau à moteur");
                        }

                        this.parc = this.parcDao.insert(this.parc, var10);
                     }
                  }

                  TransitPortVentes var8;
                  if (this.manifestEntete.getVtemanRefPortDep() != null && !this.manifestEntete.getVtemanRefPortDep().isEmpty()) {
                     var8 = this.transitPortVentesDao.rechercherTransitPortVentes(this.manifestEntete.getVtemanRefPortDep(), var10);
                     if (var8 == null) {
                        var8 = new TransitPortVentes();
                        var8.setTraprtCode(this.manifestEntete.getVtemanRefPortDep());
                        var8.setTraprtDateCreation(new Date());
                        var8.setTraprtInactif(0);
                        var8.setTraprtLibelleFr(this.manifestEntete.getVtemanLibPortDep());
                        var8.setTraprtUserCreation(this.usersLog.getUsrid());
                        this.transitPortVentesDao.insert(var8, var10);
                     }
                  }

                  if (this.manifestEntete.getVtemanRefPortArr() != null && !this.manifestEntete.getVtemanRefPortArr().isEmpty()) {
                     var8 = this.transitPortVentesDao.rechercherTransitPortVentes(this.manifestEntete.getVtemanRefPortArr(), var10);
                     if (var8 == null) {
                        var8 = new TransitPortVentes();
                        var8.setTraprtCode(this.manifestEntete.getVtemanRefPortArr());
                        var8.setTraprtDateCreation(new Date());
                        var8.setTraprtInactif(0);
                        var8.setTraprtLibelleFr(this.manifestEntete.getVtemanLibPortArr());
                        var8.setTraprtUserCreation(this.usersLog.getUsrid());
                        this.transitPortVentesDao.insert(var8, var10);
                     }
                  }

                  TransitLieuVentes var9;
                  if (this.manifestEntete.getVtemanRefLieuDep() != null && !this.manifestEntete.getVtemanRefLieuDep().isEmpty()) {
                     var9 = this.transitLieuVentesDao.rechercherTransitLieuVentes(this.manifestEntete.getVtemanRefLieuDep(), var10);
                     if (var9 == null) {
                        var9 = new TransitLieuVentes();
                        var9.setTralieCode(this.manifestEntete.getVtemanRefLieuDep());
                        var9.setTralieDateCreation(new Date());
                        var9.setTralieInactif(0);
                        var9.setTralieLibelleFr(this.manifestEntete.getVtemanLibLieuDep());
                        var9.setTralieUserCreation(this.usersLog.getUsrid());
                        this.transitLieuVentesDao.insert(var9, var10);
                     }
                  }

                  if (this.manifestEntete.getVtemanRefLieuArr() != null && !this.manifestEntete.getVtemanRefLieuArr().isEmpty()) {
                     var9 = this.transitLieuVentesDao.rechercherTransitLieuVentes(this.manifestEntete.getVtemanRefLieuArr(), var10);
                     if (var9 == null) {
                        var9 = new TransitLieuVentes();
                        var9.setTralieCode(this.manifestEntete.getVtemanRefLieuArr());
                        var9.setTralieDateCreation(new Date());
                        var9.setTralieInactif(0);
                        var9.setTralieLibelleFr(this.manifestEntete.getVtemanLibLieuArr());
                        var9.setTralieUserCreation(this.usersLog.getUsrid());
                        this.transitLieuVentesDao.insert(var9, var10);
                     }
                  }

                  var2 = var4.chargerLesLignesGroupe(this.manifestEntete.getVtemanNum(), var10);
                  if (var2.size() != 0) {
                     for(var14 = 0; var14 < var2.size(); ++var14) {
                        var6 = (ManifestLigneImport)var2.get(var14);
                        this.manifestLigne = this.manifestLigneDao.chargerLaLigne(this.manifestEntete.getVtemanNum(), var6.getVtelvNum(), var10);
                        if (this.manifestLigne == null) {
                           if (var6.getVtelvCompteClient() != null && !var6.getVtelvCompteClient().isEmpty()) {
                              this.tiers = this.tiersDao.chargerTiersByCompte(var6.getVtelvCompteClient(), var10);
                              if (this.tiers == null) {
                                 new ArrayList();
                                 List var15 = this.tiersDao.chargerLesTiersByCat("3", var6.getVtelvIntituleClient(), var10);
                                 if (var15.size() != 0) {
                                    this.tiers = (Tiers)var15.get(0);
                                 } else {
                                    this.tiers = null;
                                 }
                              }
                           } else {
                              this.tiers = null;
                           }

                           if (this.tiers != null) {
                              this.manifestLigne = this.manifestLigneDao.chargerLaLigne(var6.getVtelvNumManifest(), var6.getVtelvNum(), var10);
                              if (this.manifestLigne == null) {
                                 this.manifestLigne = new ManifestLigne();
                              }

                              this.manifestLigne.setManifestEntete(this.manifestEntete);
                              this.manifestLigne.setVtelvAdresseDest(var6.getVtelvAdresseDest());
                              this.manifestLigne.setVtelvAdresseExp(var6.getVtelvAdresseExp());
                              this.manifestLigne.setVtelvImmaCamion(var6.getVtelvCamion());
                              this.manifestLigne.setVtelvCompteClient(var6.getVtelvCompteClient());
                              this.manifestLigne.setVtelvContactDest(var6.getVtelvContactDest());
                              this.manifestLigne.setVtelvContactExp(var6.getVtelvContactExp());
                              this.manifestLigne.setVtelvDossier(var6.getVtelvDossier());
                              this.manifestLigne.setVtelvImmaCamion(var6.getVtelvImmaCamion());
                              this.manifestLigne.setVtelvImmaRemorque1(var6.getVtelvImmaParc());
                              this.manifestLigne.setVtelvIntituleClient(var6.getVtelvIntituleClient());
                              this.manifestLigne.setVtelvIntituleClientDest(var6.getVtelvIntituleClientDest());
                              this.manifestLigne.setVtelvIntituleClientExp(var6.getVtelvIntituleClientExp());
                              this.manifestLigne.setVtelvMatChauffeurDest(var6.getVtelvMatChauffeurDest());
                              this.manifestLigne.setVtelvMatChauffeurExp(var6.getVtelvMatChauffeurExp());
                              this.manifestLigne.setVtelvMatRespDest(var6.getVtelvMatRespDest());
                              this.manifestLigne.setVtelvMatRespExp(var6.getVtelvMatRespExp());
                              this.manifestLigne.setVtelvModelCamion(var6.getVtelvModelCamion());
                              this.manifestLigne.setVtelvNomPrenomChauffeurDest(var6.getVtelvNomPrenomChauffeurDest());
                              this.manifestLigne.setVtelvNomPrenomChauffeurExp(var6.getVtelvNomPrenomChauffeurExp());
                              this.manifestLigne.setVtelvNomPrenomRespDest(var6.getVtelvNomPrenomRespDest());
                              this.manifestLigne.setVtelvNomPrenomRespExp(var6.getVtelvNomPrenomRespExp());
                              this.manifestLigne.setVtelvNum(var6.getVtelvNum());
                              this.manifestLigne.setVtelvNumManifest(var6.getVtelvNumManifest());
                              this.manifestLigne.setVtelvObservation(var6.getVtelvObservation());
                              this.manifestLigne.setVtelvOrdre(var6.getVtelvOrdre());
                              if (var6.getVtelvPerteVol() != null && !var6.getVtelvPerteVol().isEmpty()) {
                                 this.manifestLigne.setVtelvModeAssuree(1);
                              } else if (var6.getVtelvTousRisques() != null && !var6.getVtelvTousRisques().isEmpty()) {
                                 this.manifestLigne.setVtelvModeAssuree(2);
                              } else {
                                 this.manifestLigne.setVtelvModeAssuree(0);
                              }

                              if (var6.getVtelvPortPaye() != null && !var6.getVtelvPortPaye().isEmpty()) {
                                 this.manifestLigne.setVtelvModeClient(1);
                              } else if (var6.getVtelvPortDu() != null && !var6.getVtelvPortDu().isEmpty()) {
                                 this.manifestLigne.setVtelvModeClient(2);
                              } else {
                                 this.manifestLigne.setVtelvModeClient(0);
                              }

                              this.manifestLigne.setVtelvModeGroupe(this.tiers.getTiefacpr());
                              this.manifestLigne.setVtelvPoidsExp(var6.getVtelvPoids());
                              if (var6.getVtelvValeurAssuree() != null && !var6.getVtelvValeurAssuree().isEmpty()) {
                                 this.manifestLigne.setVtelvValeurAssuree(Integer.parseInt(var6.getVtelvValeurAssuree()));
                              } else {
                                 this.manifestLigne.setVtelvValeurAssuree(0);
                              }

                              this.manifestLigne.setVtelvVolumeExp(var6.getVtelvVolume());
                              this.manifestLigne.setVtelvDateExp(this.manifestEntete.getVtemanDateDep());
                              this.manifestLigne.setVtelvDateDest(this.manifestEntete.getVtemanDateArr());
                              if (this.manifestLigne.getVtelvId() == 0L) {
                                 this.manifestLigne = this.manifestLigneDao.insertLigne(this.manifestLigne, var10);
                              } else {
                                 this.manifestLigne = this.manifestLigneDao.modifLigne(this.manifestLigne, var10);
                              }

                              if (this.manifestLigne.getVtelvImmaCamion() != null && !this.manifestLigne.getVtelvImmaCamion().isEmpty()) {
                                 this.parc = this.parcDao.rechercheParc(this.manifestLigne.getVtelvImmaCamion(), var10);
                                 if (this.parc == null) {
                                    this.parc = new Parc();
                                    this.parc.setPrcDateCreat(new Date());
                                    this.parc.setPrcImmatriculation(this.manifestLigne.getVtelvImmaCamion());
                                    this.parc.setPrcUserCreat(this.usersLog.getUsrid());
                                    this.parc.setPrcNomFr(this.manifestLigne.getVtelvModelCamion());
                                    this.parc.setPrcMarque("");
                                    this.parc.setPrcNature(1724);
                                    this.parc.setPrcLibNature("Tracteur");
                                    this.parc = this.parcDao.insert(this.parc, var10);
                                 }
                              }

                              if (this.manifestLigne.getVtelvImmaRemorque1() != null && !this.manifestLigne.getVtelvImmaRemorque1().isEmpty()) {
                                 this.parc = this.parcDao.rechercheParc(this.manifestLigne.getVtelvImmaRemorque1(), var10);
                                 if (this.parc == null) {
                                    this.parc = new Parc();
                                    this.parc.setPrcDateCreat(new Date());
                                    this.parc.setPrcImmatriculation(this.manifestLigne.getVtelvImmaRemorque1());
                                    this.parc.setPrcUserCreat(this.usersLog.getUsrid());
                                    this.parc.setPrcNature(1725);
                                    this.parc.setPrcLibNature("Remorque");
                                    this.parc = this.parcDao.insert(this.parc, var10);
                                 }
                              }

                              if (this.manifestLigne.getVtelvImmaRemorque2() != null && !this.manifestLigne.getVtelvImmaRemorque2().isEmpty()) {
                                 this.parc = this.parcDao.rechercheParc(this.manifestLigne.getVtelvImmaRemorque2(), var10);
                                 if (this.parc == null) {
                                    this.parc = new Parc();
                                    this.parc.setPrcDateCreat(new Date());
                                    this.parc.setPrcImmatriculation(this.manifestLigne.getVtelvImmaRemorque2());
                                    this.parc.setPrcUserCreat(this.usersLog.getUsrid());
                                    this.parc.setPrcNature(1725);
                                    this.parc.setPrcLibNature("Remorque");
                                    this.parc = this.parcDao.insert(this.parc, var10);
                                 }
                              }

                              if (this.manifestLigne.getVtelvMatChauffeurExp() != null && !this.manifestLigne.getVtelvMatChauffeurExp().isEmpty()) {
                              }

                              if (this.manifestLigne.getVtelvMatChauffeurDest() != null && !this.manifestLigne.getVtelvMatChauffeurDest().isEmpty()) {
                              }
                           }
                        }

                        if (this.manifestLigne != null && this.tiers != null) {
                           this.manifestProduit = this.manifestProduitDao.chargerLesProduitsManifeste(var6.getVtelvNumManifest(), var6.getVtelvNum(), var6.getVtelvRefTypeColis(), var10);
                           if (this.manifestProduit == null) {
                              this.manifestProduit = new ManifestProduit();
                           }

                           this.manifestProduit.setVteprdCodeTva("");
                           this.manifestProduit.setVteprdDescription(var6.getVtelvDescription());
                           this.manifestProduit.setVteprdImmaTc1(var6.getVtelvImmaTc());
                           this.manifestProduit.setVteprdLibTypeColis(var6.getVtelvLibTypeColis());
                           this.manifestProduit.setVteprdModeFactureDetail(0);
                           this.manifestProduit.setVteprdModelTc1(0);
                           this.manifestProduit.setVteprdNatureColis(var6.getVtelvNatureColis());
                           this.manifestProduit.setVteprdNbreColis(var6.getVtelvNbreColis());
                           this.manifestProduit.setVteprdNum(this.manifestLigne.getVtelvNum());
                           this.manifestProduit.setVteprdNumManifest(this.manifestEntete.getVtemanNum());
                           this.manifestProduit.setVteprdOrdre(1);
                           this.manifestProduit.setVteprdPoids(var6.getVtelvPoids());
                           this.manifestProduit.setVteprdPlombTc1(var6.getVtelvTca());
                           this.manifestProduit.setVteprdRefTypeColis(var6.getVtelvRefTypeColis());
                           this.manifestProduit.setVteprdVolume(var6.getVtelvVolume());
                           if (this.manifestProduit.getVteprdId() == 0L) {
                              this.manifestProduit = this.manifestProduitDao.insertLigne(this.manifestProduit, var10);
                           } else {
                              this.manifestProduit = this.manifestProduitDao.modifLigne(this.manifestProduit, var10);
                           }

                           if (this.manifestProduit.getVteprdImmaTc1() != null && !this.manifestProduit.getVteprdImmaTc1().isEmpty()) {
                              this.parc = this.parcDao.rechercheParc(this.manifestProduit.getVteprdImmaTc1(), var10);
                              if (this.parc == null) {
                                 this.parc = new Parc();
                                 this.parc.setPrcDateCreat(new Date());
                                 this.parc.setPrcImmatriculation(this.manifestProduit.getVteprdImmaTc1());
                                 this.parc.setPrcUserCreat(this.usersLog.getUsrid());
                                 if (this.manifestProduit.getVteprdModelTc1() == 1) {
                                    this.parc.setPrcNomFr("Conteneur 20");
                                 } else if (this.manifestProduit.getVteprdModelTc1() == 2) {
                                    this.parc.setPrcNomFr("Conteneur 40");
                                 } else {
                                    this.parc.setPrcNomFr("Conteneur ND");
                                 }

                                 this.parc.setPrcMarque("");
                                 this.parc.setPrcNature(1726);
                                 this.parc.setPrcLibNature("Conteneur");
                                 this.parc = this.parcDao.insert(this.parc, var10);
                              }
                           }

                           if (this.manifestProduit.getVteprdImmaTc2() != null && !this.manifestProduit.getVteprdImmaTc2().isEmpty()) {
                              this.parc = this.parcDao.rechercheParc(this.manifestProduit.getVteprdImmaTc2(), var10);
                              if (this.parc == null) {
                                 this.parc = new Parc();
                                 this.parc.setPrcDateCreat(new Date());
                                 this.parc.setPrcImmatriculation(this.manifestProduit.getVteprdImmaTc2());
                                 this.parc.setPrcUserCreat(this.usersLog.getUsrid());
                                 if (this.manifestProduit.getVteprdModelTc2() == 1) {
                                    this.parc.setPrcNomFr("Conteneur 20");
                                 } else if (this.manifestProduit.getVteprdModelTc2() == 2) {
                                    this.parc.setPrcNomFr("Conteneur 40");
                                 } else {
                                    this.parc.setPrcNomFr("Conteneur ND");
                                 }

                                 this.parc.setPrcMarque("");
                                 this.parc.setPrcNature(1726);
                                 this.parc.setPrcLibNature("Conteneur");
                                 this.parc = this.parcDao.insert(this.parc, var10);
                              }
                           }

                           if (this.manifestProduit.getVteprdRefTypeColis() != null && !this.manifestProduit.getVteprdRefTypeColis().isEmpty()) {
                              this.produits = this.produitsVtesDao.chargeProduit(this.manifestProduit.getVteprdRefTypeColis(), var10);
                              if (this.produits == null) {
                                 this.produits = new Produits();
                                 this.produits.setProCode(this.manifestProduit.getVteprdRefTypeColis());
                                 this.produits.setProLibClient(this.manifestProduit.getVteprdLibTypeColis());
                                 this.produits.setProVteCode("01");
                                 this.produits.setProVteLib("Prestations");
                                 this.produits.setProVteNat("1610");
                                 this.produits = this.produitsVtesDao.insert(this.produits, var10);
                              }
                           }
                        }
                     }
                  }
               }
            }

            for(var12 = 0; var12 < var1.size(); ++var12) {
               var5 = (ManifestEnteteImport)var1.get(var12);
               var13 = true;
               if (this.lesImportationsErreur.size() != 0) {
                  for(var14 = 0; var14 < this.lesImportationsErreur.size(); ++var14) {
                     if (var5.getVtemanNum() != null && !var5.getVtemanNum().isEmpty() && ((ManifestLigneImport)this.lesImportationsErreur.get(var14)).getVtelvNumManifest() != null && !((ManifestLigneImport)this.lesImportationsErreur.get(var14)).getVtelvNumManifest().isEmpty() && var5.getVtemanNum().equals(((ManifestLigneImport)this.lesImportationsErreur.get(var14)).getVtelvNumManifest())) {
                        var13 = false;
                     }
                  }
               }

               if (var13) {
                  var3.delete(var5, var10);
               }
            }

            var2 = var4.chargerLesLignes("", var10);

            for(var12 = 0; var12 < var2.size(); ++var12) {
               var6 = (ManifestLigneImport)var2.get(var12);
               var13 = true;
               if (this.lesImportationsErreur.size() != 0) {
                  for(var14 = 0; var14 < this.lesImportationsErreur.size(); ++var14) {
                     if (var5.getVtemanNum() != null && !var5.getVtemanNum().isEmpty() && ((ManifestLigneImport)this.lesImportationsErreur.get(var14)).getVtelvNumManifest() != null && !((ManifestLigneImport)this.lesImportationsErreur.get(var14)).getVtelvNumManifest().isEmpty() && var5.getVtemanNum().equals(((ManifestLigneImport)this.lesImportationsErreur.get(var14)).getVtelvNumManifest())) {
                        var13 = false;
                     }
                  }
               }

               if (var13) {
                  var4.deleteOneLigne(var6, var10);
               }
            }

            this.configVentes(var10);
            var11.commit();
         } catch (HibernateException var19) {
            if (var11 != null) {
               var11.rollback();
            }

            throw var19;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      this.showModalPanelImportation = false;
      if (this.lesImportationsErreur.size() != 0) {
         this.ouvrirImportationErreur();
      }

   }

   public void ouvrirImportationErreur() {
      this.showModalPanelImportationErreur = true;
   }

   public void annuleImportationErreur() {
      this.showModalPanelImportationErreur = false;
   }

   public void suppressionImportationErreur() throws HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      new ArrayList();
      ManifestEnteteImportDao var3 = new ManifestEnteteImportDao(this.baseLog, this.utilInitHibernate);
      ManifestLigneImporteDao var4 = new ManifestLigneImporteDao(this.baseLog, this.utilInitHibernate);
      new ManifestEnteteImport();
      new ManifestLigneImport();
      Session var7 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEnteteImport");
      Transaction var8 = null;

      try {
         var8 = var7.beginTransaction();
         var4.chargerToutesLesLignes(var7);

         int var9;
         for(var9 = 0; var9 < var1.size(); ++var9) {
            ManifestEnteteImport var5 = (ManifestEnteteImport)var1.get(var9);
            var3.delete(var5, var7);
         }

         List var2 = var4.chargerLesLignes("", var7);
         var9 = 0;

         while(true) {
            if (var9 >= var2.size()) {
               var8.commit();
               break;
            }

            ManifestLigneImport var6 = (ManifestLigneImport)var2.get(var9);
            var4.deleteOneLigne(var6, var7);
            ++var9;
         }
      } catch (HibernateException var13) {
         if (var8 != null) {
            var8.rollback();
         }

         throw var13;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.showModalPanelImportationErreur = false;
   }

   public void selectionLigneDetail() throws HibernateException, NamingException {
      if (this.datamodelLigne.isRowAvailable()) {
         this.manifestLigne = (ManifestLigne)this.datamodelLigne.getRowData();
         if (this.manifestLigne.getVtelvImmaCamion() == null || this.manifestLigne.getVtelvImmaCamion().isEmpty()) {
            this.manifestLigne.setVtelvImmaCamion("...");
         }

         this.visibiliteBtonlig = true;
         this.lesLignesProduit.clear();
         this.lesLignesProduit = this.manifestProduitDao.chargerLesLignes(this.manifestLigne, (Session)null);
         this.datamodelProduit.setWrappedData(this.lesLignesProduit);
         this.visibiliteBtonDetaillig = false;
      }

   }

   public void ajoutLettreVoiture() {
      if (this.manifestLigne != null) {
         this.manifestLigne = new ManifestLigne();
         this.lesLignesProduit.clear();
         this.datamodelProduit.setWrappedData(this.lesLignesProduit);
         this.manifestLigne.setVtelvImmaCamion("...");
         String var1 = "";
         this.numLigne = this.lesLignesList.size() + 1;
         if (this.numLigne <= 9) {
            var1 = "00" + this.numLigne;
         } else if (this.numLigne >= 10 && this.numLigne <= 99) {
            var1 = "0" + this.numLigne;
         } else if (this.numLigne >= 100) {
            var1 = "" + this.numLigne;
         }

         this.manifestLigne.setManifestEntete(this.manifestEntete);
         this.manifestLigne.setVtelvNum(this.manifestEntete.getVtemanNum() + ":" + var1);
         this.manifestLigne.setVtelvNumManifest(this.manifestEntete.getVtemanNum());
         this.visibiliteBtonDetaillig = false;
         this.var_aff_action_lv = false;
         this.var_valide_lv = false;
         this.showModalPanelLettre = true;
      }

   }

   public void modifLettreVoiture() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.manifestLigne != null) {
         this.var_aff_action_lv = false;
         this.var_valide_lv = true;
         this.visibiliteBtonDetaillig = false;
         this.calculTiers();
         this.showModalPanelLettre = true;
      }

   }

   public void consultLettreVoiture() {
      if (this.manifestLigne != null) {
         this.var_aff_action_lv = true;
         this.var_valide_lv = false;
         this.visibiliteBtonDetaillig = false;
         this.showModalPanelLettre = true;
      }

   }

   public void supprimerLettreVoiture() throws HibernateException, NamingException {
      if (this.manifestLigne != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.manifestProduitDao.deleteAllLigne(this.manifestLigne, var1);
            this.manifestLigneDao.deleteOneLigne(this.manifestLigne, var1);
            this.lesLignesList.remove(this.manifestLigne);
            this.datamodelLigne.setWrappedData(this.lesEquipes);
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

   public void fermerLettreVoiture() {
      this.visibiliteBtonlig = false;
      this.showModalPanelLettre = false;
   }

   public void calculTiers() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.manifestLigne != null) {
         if (this.manifestLigne.getVtelvCompteClient() != null && !this.manifestLigne.getVtelvCompteClient().isEmpty()) {
            this.tiers = this.tiersDao.chargerTiersByCompte(this.manifestLigne.getVtelvCompteClient());
         } else if (this.manifestLigne.getVtelvIntituleClient() != null && !this.manifestLigne.getVtelvIntituleClient().isEmpty()) {
            this.tiers = this.tiersDao.chargerLesTiers("3", this.manifestLigne.getVtelvIntituleClient(), (Session)null);
         } else {
            this.tiers = null;
         }

         if (this.tiers != null) {
            this.manifestLigne.setVtelvCat(this.calculeFamilleTiers());
            this.manifestLigne.setVtelvExoTva(this.tiers.getTieexotva());
            this.manifestLigne.setVtelvExoTc(1);
         } else {
            this.manifestLigne.setVtelvCat("");
            this.manifestLigne.setVtelvExoTva(0);
            this.manifestLigne.setVtelvExoTc(0);
         }

         this.calculListeProduit();
      }

   }

   public String calculeFamilleTiers() throws JDOMException, IOException {
      if (this.tiers.getTienomfamille() == null || this.tiers.getTienomfamille().isEmpty()) {
         LectureFamillesClients var1 = new LectureFamillesClients();
         var1.setStrId(this.structureLog.getStrid());
         var1.setStructureLog(this.structureLog);
         var1.chargerMesFamillesClientItems();
         new ArrayList();
         List var2 = var1.getMesFamillesClients();
         if (var2.size() != 0) {
            this.tiers.setTienomfamille(((ObjetFamilleTiers)var2.get(0)).getLibelle());
         } else {
            this.tiers.setTienomfamille("");
         }
      }

      return this.tiers.getTienomfamille();
   }

   public void calculProduit() throws HibernateException, NamingException {
      if (this.manifestLigne != null && this.manifestProduit != null) {
         this.var_valide_prd = false;
         if (this.manifestProduit.getVteprdRefTypeColis() != null && !this.manifestProduit.getVteprdRefTypeColis().isEmpty()) {
            Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEntete");
            this.produits = this.produitsVtesDao.chargeProduit(this.manifestProduit.getVteprdRefTypeColis(), var1);
            if (this.produits != null) {
               this.var_valide_prd = true;
               this.manifestProduit.setVteprdLibTypeColis(this.produits.getProLibClient());
               this.calculTva(var1);
               this.prixUnitaireCorrespond(var1);
               this.calculPrix(this.manifestProduit.getVteprdCodeTva(), this.manifestProduit.getVteprdTauxTva(), var1);
            }

            this.utilInitHibernate.closeSession();
         }
      }

   }

   public void calculListeProduit() throws HibernateException, NamingException {
      if (this.manifestLigne != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEntete");
         this.var_valide_prd = false;
         this.mesDevisItems.clear();
         if (this.manifestLigne.getVtelvModeFacture() == 1) {
            new ArrayList();
            DevisEnteteVentesDao var3 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
            List var6 = var3.rechercheByTiers(this.tiers, var1);
            if (var6.size() != 0) {
               new DevisEnteteVentes();

               for(int var5 = 0; var5 < var6.size(); ++var5) {
                  DevisEnteteVentes var4 = (DevisEnteteVentes)var6.get(var5);
                  if (var4.getDvsEtat() == 1) {
                     this.mesDevisItems.add(new SelectItem(var4.getDvsNum()));
                  }
               }
            }
         } else if (this.lesLignesProduit.size() != 0) {
            for(int var2 = 0; var2 < this.lesLignesProduit.size(); ++var2) {
               this.manifestProduit = (ManifestProduit)this.lesLignesProduit.get(var2);
               if (this.manifestProduit.getVteprdRefTypeColis() != null && !this.manifestProduit.getVteprdRefTypeColis().isEmpty()) {
                  this.produits = this.produitsVtesDao.chargeProduit(this.manifestProduit.getVteprdRefTypeColis(), var1);
                  if (this.produits != null) {
                     this.var_valide_prd = true;
                     if (this.manifestProduit.getVteprdCodeTva() == null || this.manifestProduit.getVteprdCodeTva().isEmpty()) {
                        this.calculTva(var1);
                     }

                     this.prixUnitaireCorrespond(var1);
                     this.calculPrix(this.manifestProduit.getVteprdCodeTva(), this.manifestProduit.getVteprdTauxTva(), var1);
                  }
               }
            }
         }

         this.utilInitHibernate.closeSession();
      }

   }

   public void valideDevis() {
      if (this.manifestLigne.getVtelvNumDevis() != null && !this.manifestLigne.getVtelvNumDevis().isEmpty()) {
         this.var_valide_lv = true;
      } else {
         this.var_valide_lv = false;
      }

   }

   public void calculTva(Session var1) throws HibernateException, NamingException {
      if (this.produits != null) {
         this.mesTaxesVentesProduits.clear();
         new FamillesProduitsVentes();
         FamillesProduitsVentes var2 = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.lastExoVentes.getExevteId(), this.produits, var1);
         if (!this.produits.isProExoTva() && (this.tiers == null || this.tiers.getTiepProdExoTva() == null || this.tiers.getTiepProdExoTva().isEmpty() || !this.tiers.getTiepProdExoTva().contains(this.produits.getProCode()))) {
            TaxesVentes var3;
            if (this.produits.getProVteTva() != null && !this.produits.getProVteTva().isEmpty() && !this.produits.getProVteTva().equals("0")) {
               new TaxesVentes();
               var3 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.produits.getProVteTva(), var1);
               if (var3 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(this.produits.getProVteTva(), this.produits.getProVteTva() + ":" + var3.getTaxvteTaux()));
                  this.manifestProduit.setVteprdCodeTva(this.produits.getProVteTva());
                  this.manifestProduit.setVteprdTauxTva(var3.getTaxvteTaux());
               } else {
                  this.manifestProduit.setVteprdCodeTva("");
                  this.manifestProduit.setVteprdTauxTva(0.0F);
                  this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
               }
            } else if (var2 != null && var2.getFamvteTaxe() != null && !var2.getFamvteTaxe().isEmpty() && !var2.getFamvteTaxe().equals("0")) {
               new TaxesVentes();
               var3 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), var2.getFamvteTaxe(), var1);
               if (var3 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var2.getFamvteTaxe(), var2.getFamvteTaxe() + ":" + var3.getTaxvteTaux()));
                  this.manifestProduit.setVteprdCodeTva(var2.getFamvteTaxe());
                  this.manifestProduit.setVteprdTauxTva(var3.getTaxvteTaux());
               }
            } else {
               this.manifestProduit.setVteprdCodeTva("");
               this.manifestProduit.setVteprdTauxTva(0.0F);
               this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
            }

            if (this.manifestLigne.getVtelvExoTva() == 0) {
               if ((this.manifestProduit.getVteprdCodeTva() == null || this.manifestProduit.getVteprdCodeTva().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                  new TaxesVentes();
                  var3 = this.taxesVentesDao.selectTva(this.lastExoVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var1);
                  if (var3 != null) {
                     this.mesTaxesVentesProduits.add(new SelectItem(var3.getTaxvteCode(), var3.getTaxvteCode() + ":" + var3.getTaxvteTaux()));
                     this.manifestProduit.setVteprdCodeTva(var3.getTaxvteCode());
                     this.manifestProduit.setVteprdTauxTva(var3.getTaxvteTaux());
                  }
               }
            } else {
               this.manifestProduit.setVteprdCodeTva("");
               this.manifestProduit.setVteprdTauxTva(0.0F);
               this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
            }
         } else {
            this.manifestProduit.setVteprdCodeTva("");
            this.manifestProduit.setVteprdTauxTva(0.0F);
            this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
         }
      }

   }

   public void prixUnitaireCorrespond(Session var1) throws HibernateException, NamingException {
      if (this.produits != null) {
         double var2 = 0.0D;
         if (this.produits.getProMode() != 4) {
            new ProduitsTarif();
            ProduitsTarif var4 = this.produitsTarifDao.prixUnitaireCorrespond(this.produits.getProId(), this.manifestLigne.getVtelvCat(), (String)null, var1);
            if (var4 != null) {
               this.prixUnitaires = var4.getProtarPv();
               var2 = this.prixUnitaires;
            } else {
               this.prixUnitaires = 0.0D;
            }
         }

         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            this.manifestProduit.setVteprdPu(this.prixUnitaires);
            this.manifestProduit.setVteprdPuRem(this.prixUnitaires);
         } else {
            this.manifestProduit.setVteprdPu(this.prixUnitaires);
            this.manifestProduit.setVteprdPuRem(this.prixUnitaires);
         }

         double var11 = 0.0D;
         if (this.verifBareme) {
            Baremes var6 = new Baremes();
            Baremes var7 = new Baremes();
            new ArrayList();
            if (this.tiers != null) {
               List var8 = this.baremesDao.rechercheToutBaremeProduit(this.tiers.getTieid(), this.produits.getProCode(), this.produits.getProVteCode(), this.tiers.getTienomfamille(), var1);
               if (var8.size() != 0) {
                  int var9;
                  for(var9 = 0; var9 < var8.size(); ++var9) {
                     var6 = (Baremes)var8.get(var9);
                     if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && var6.getBarIdTiers() == this.tiers.getTieid() && var6.getBarCodeProduit() != null && !var6.getBarCodeProduit().isEmpty() && var6.getBarCodeProduit().equals(this.produits.getProCode())) {
                        var11 = var6.getBarPrix();
                        var7 = var6;
                        break;
                     }
                  }

                  if (var11 == 0.0D) {
                     for(var9 = 0; var9 < var8.size(); ++var9) {
                        var6 = (Baremes)var8.get(var9);
                        if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && var6.getBarCategorieTiers() != null && !var6.getBarCategorieTiers().isEmpty() && var6.getBarCategorieTiers().equals(this.tiers.getTiecategorie()) && var6.getBarCodeProduit() != null && !var6.getBarCodeProduit().isEmpty() && var6.getBarCodeProduit().equals(this.produits.getProCode())) {
                           var11 = var6.getBarPrix();
                           var7 = var6;
                           break;
                        }
                     }
                  }

                  if (var11 == 0.0D) {
                     for(var9 = 0; var9 < var8.size(); ++var9) {
                        var6 = (Baremes)var8.get(var9);
                        if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && var6.getBarIdTiers() == this.tiers.getTieid() && var6.getBarCodeVte() != null && !var6.getBarCodeVte().isEmpty() && var6.getBarCodeVte().equals(this.produits.getProVteCode())) {
                           var11 = var6.getBarPrix();
                           var7 = var6;
                           break;
                        }
                     }
                  }

                  if (var11 == 0.0D) {
                     for(var9 = 0; var9 < var8.size(); ++var9) {
                        var6 = (Baremes)var8.get(var9);
                        if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && var6.getBarCategorieTiers() != null && !var6.getBarCategorieTiers().isEmpty() && var6.getBarCategorieTiers().equals(this.tiers.getTiecategorie()) && var6.getBarCodeVte() != null && !var6.getBarCodeVte().isEmpty() && var6.getBarCodeVte().equals(this.produits.getProVteCode())) {
                           var11 = var6.getBarPrix();
                           var7 = var6;
                           break;
                        }
                     }
                  }

                  if (var11 == 0.0D) {
                     for(var9 = 0; var9 < var8.size(); ++var9) {
                        var6 = (Baremes)var8.get(var9);
                        if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && (var6.getBarCategorieTiers() == null || var6.getBarCategorieTiers().isEmpty()) && var6.getBarIdTiers() == 0L && var6.getBarCodeProduit() != null && !var6.getBarCodeProduit().isEmpty() && var6.getBarCodeProduit().equals(this.produits.getProCode())) {
                           var11 = var6.getBarPrix();
                           var7 = var6;
                           break;
                        }
                     }
                  }

                  if (var11 != 0.0D) {
                     this.prixUnitaires = var11;
                  }

                  if (this.prixUnitaires == 0.0D) {
                     for(var9 = 0; var9 < var8.size(); ++var9) {
                        var6 = (Baremes)var8.get(var9);
                        if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && (var6.getBarCategorieTiers() == null || var6.getBarCategorieTiers().isEmpty()) && var6.getBarIdTiers() == 0L && var6.getBarCodeVte() != null && !var6.getBarCodeVte().isEmpty() && var6.getBarCodeVte().equals(this.produits.getProVteCode())) {
                           this.prixUnitaires = var6.getBarPrix();
                           var7 = var6;
                           break;
                        }
                     }
                  }

                  if (var7 != null && var7.getBarId() != 0L) {
                     if (var6.getBarRemise() != 0.0F) {
                        this.manifestProduit.setVteprdRemise(var6.getBarRemise());
                        double var12 = 0.0D;
                        var12 = this.prixUnitaires - this.utilNombre.myRoundDevise(this.prixUnitaires * (double)var6.getBarRemise() / 100.0D, this.structureLog.getStrdevise());
                        if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                           this.manifestProduit.setVteprdPu(this.prixUnitaires);
                           this.manifestProduit.setVteprdPuRem(var12);
                        } else {
                           this.manifestProduit.setVteprdPu(this.prixUnitaires);
                           this.manifestProduit.setVteprdPuRem(var12);
                        }
                     } else if (var6.getBarPrix() != 0.0D) {
                        this.manifestProduit.setVteprdRemise(var6.getBarRemise());
                        this.prixUnitaires = var6.getBarPrix();
                        if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                           this.manifestProduit.setVteprdPu(this.prixUnitaires);
                           this.manifestProduit.setVteprdPuRem(this.prixUnitaires);
                        } else {
                           this.manifestProduit.setVteprdPu(this.prixUnitaires);
                           this.manifestProduit.setVteprdPuRem(this.prixUnitaires);
                        }
                     }
                  }

                  if (this.prixUnitaires == 0.0D) {
                     this.prixUnitaires = var2;
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.manifestProduit.setVteprdPu(this.prixUnitaires);
                        this.manifestProduit.setVteprdPuRem(this.prixUnitaires);
                     } else {
                        this.manifestProduit.setVteprdPu(this.prixUnitaires);
                        this.manifestProduit.setVteprdPuRem(this.prixUnitaires);
                     }
                  }
               }
            }
         }
      }

   }

   public void calculPrix() throws HibernateException, NamingException {
      this.calculPrix(this.manifestProduit.getVteprdCodeTva(), this.manifestProduit.getVteprdTauxTva(), (Session)null);
   }

   public void calculPrix(String var1, float var2, Session var3) throws HibernateException, NamingException {
      this.calculHt(var1, var2, var3);
   }

   public void calculHt(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEntete");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      int var7 = 0;
      if (this.manifestLigne.getVtelvExoTva() == 0) {
         TaxesVentes var8;
         if (var1 != null && !var1.isEmpty()) {
            new TaxesVentes();
            var8 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), var1, var3);
            if (var8 != null) {
               var5 = var8.getTaxvteTaux();
               var6 = var8.getTaxvteCode();
               var7 = var8.getTaxvteType();
            } else if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               TaxesVentes var9 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var3);
               if (var9 != null) {
                  var5 = var9.getTaxvteTaux();
                  var6 = var9.getTaxvteCode();
                  var7 = var9.getTaxvteType();
               } else {
                  var5 = var2;
                  var6 = var1;
                  var7 = 0;
               }
            } else {
               var5 = var2;
               var6 = var1;
               var7 = 0;
            }
         } else if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
            new TaxesVentes();
            var8 = this.taxesVentesDao.selectTva(this.exercicesVentes.getExevteId(), this.optionsVentes.getTvaDefaut(), var3);
            if (var8 != null) {
               var5 = var8.getTaxvteTaux();
               var6 = var8.getTaxvteCode();
               var7 = var8.getTaxvteType();
            } else {
               var5 = var2;
               var6 = var1;
               var7 = 0;
            }
         } else {
            var5 = var2;
            var6 = var1;
            var7 = 0;
         }

         if (this.produits != null && this.produits.isProExoTva() || this.tiers != null && this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
            var5 = 0.0F;
            var6 = "";
            var7 = 0;
         }
      }

      this.manifestProduit.setVteprdCodeTva(var6);
      this.manifestProduit.setVteprdTauxTva(var5);
      double var25 = this.manifestProduit.getVteprdPu();
      double var10 = 0.0D;
      if (this.manifestProduit.getVteprdRemise() != 0.0F) {
         var10 = var25 - var25 * (double)this.manifestProduit.getVteprdRemise() / 100.0D;
      } else {
         var10 = var25;
      }

      float var12 = 0.0F;
      if (this.manifestProduit.getVteprdModeFactureDetail() != 2 && this.manifestProduit.getVteprdModeFactureDetail() != 3 && this.manifestProduit.getVteprdModeFactureDetail() != 4) {
         if (this.manifestProduit.getVteprdModeFactureDetail() == 1) {
            if (this.manifestProduit.getVteprdPoids() / 1000.0F >= this.manifestProduit.getVteprdVolume()) {
               var12 = this.manifestProduit.getVteprdPoids() / 1000.0F;
            } else {
               var12 = this.manifestProduit.getVteprdVolume();
            }
         }
      } else {
         var12 = (float)this.manifestProduit.getVteprdNbreColis();
      }

      double var13 = this.utilNombre.myRoundFormat(var10 * (double)var12, this.structureLog.getStrformatdevise());
      if (var12 != 0.0F && this.prixMinimal != 0.0D && var13 < this.prixMinimal) {
         if (this.tiers != null && this.tiers.getTieMontantMini() != 0.0D) {
            var10 = this.tiers.getTieMontantMini();
         } else {
            var10 = this.prixMinimal;
         }

         this.manifestProduit.setVteprdPu(var10);
         var13 = var10;
      }

      double var15 = var13 * (double)this.manifestProduit.getVteprdTauxTva() / 100.0D;
      if (var7 == 2) {
         var15 *= -1.0D;
      }

      double var17 = this.utilNombre.myRoundFormat(var15, this.structureLog.getStrformatdevise());
      double var19 = var13 + var17;
      this.manifestProduit.setVteprdPuRem(var10);
      this.manifestProduit.setVteprdTotalHt(var13);
      this.manifestProduit.setVteprdTotalTva(var17);
      this.manifestProduit.setVteprdTc(0.0D);
      this.manifestProduit.setVteprdTotalTtc(var19);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.manifestLigne.getVtelvExoTc() == 1) {
         this.manifestLigne.setVtelvExoTc((int)this.var_tc_taux);
         this.manifestProduit.setVteprdTauxTc(this.var_tc_taux);
         this.manifestProduit.setVteprdTauxTc(this.var_tc_taux);
         double var21 = 0.0D;
         double var23 = 0.0D;
         if (this.var_tc_type == 6) {
            var21 = var19 * (double)this.manifestProduit.getVteprdTauxTc() / 100.0D;
            var23 = this.utilNombre.myRoundFormat(var21, this.structureLog.getStrformatdevise());
            this.manifestProduit.setVteprdTc(var23);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var21 = var13 * (double)this.manifestProduit.getVteprdTauxTc() / 100.0D;
               if (this.manifestProduit.getVteprdTauxTva() != 0.0F) {
                  var21 = var13 * (double)this.manifestProduit.getVteprdTauxTc() / 100.0D;
                  var23 = this.utilNombre.myRoundFormat(var21, this.structureLog.getStrformatdevise());
                  double var10000 = var21 + var21 * (double)this.manifestProduit.getVteprdTauxTva() / 100.0D;
                  this.manifestProduit.setVteprdTc(var23);
               }
            }
         } else {
            var21 = var13 * (double)this.manifestProduit.getVteprdTauxTc() / 100.0D;
            var23 = this.utilNombre.myRoundFormat(var21, this.structureLog.getStrformatdevise());
            this.manifestProduit.setVteprdTc(var23);
         }
      } else {
         this.manifestProduit.setVteprdTc(0.0D);
         this.manifestProduit.setVteprdTauxTc(0.0F);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculTtc(String var1, float var2, Session var3) throws HibernateException, NamingException {
   }

   public void cumulPrixFinal() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = 0.0D;
      int var11 = 0;
      float var12 = 0.0F;
      float var13 = 0.0F;

      for(int var14 = 0; var14 < this.lesLignesList.size(); ++var14) {
         var1 += ((ManifestLigne)this.lesLignesList.get(var14)).getVtelvTotalHt();
         var3 += ((ManifestLigne)this.lesLignesList.get(var14)).getVtelvTotalTva();
         var5 += ((ManifestLigne)this.lesLignesList.get(var14)).getVtelvTotalTtc();
         var7 += ((ManifestLigne)this.lesLignesList.get(var14)).getVtelvTc();
         var9 += ((ManifestLigne)this.lesLignesList.get(var14)).getVtelvTotalReglement();
         var11 += ((ManifestLigne)this.lesLignesList.get(var14)).getVtelvNbreColisExp();
         var12 += ((ManifestLigne)this.lesLignesList.get(var14)).getVtelvPoidsExp();
         var13 += ((ManifestLigne)this.lesLignesList.get(var14)).getVtelvVolumeExp();
      }

      this.manifestEntete.setVtemanTotalHt(var1);
      this.manifestEntete.setVtemanTotalTva(var3);
      this.manifestEntete.setVtemanTotalTtc(var5);
      this.manifestEntete.setVtemanTc(var7);
      this.manifestEntete.setVtemanNbColisExp(var11);
      this.manifestEntete.setVtemanPoidsExp(var12);
      this.manifestEntete.setVtemanVolumeExp(var13);
      this.manifestEntete.setVtemanTotalReglement(var9);
   }

   public void selectionLigneDetailLight() throws HibernateException, NamingException {
      if (this.datamodelLigne.isRowAvailable()) {
         this.manifestLigne = (ManifestLigne)this.datamodelLigne.getRowData();
         this.numLigne = this.calculeNumlLigne() + 1;
      } else {
         this.griserchamps = false;
         this.griserValider = false;
      }

   }

   public void addLigne() {
      this.visibiliteBtonlig = false;
   }

   public int calculeNumlLigne() {
      byte var1 = 0;
      if (this.lesLignesList.size() != 0) {
      }

      return var1;
   }

   public void selectionLigneSousDetail() throws HibernateException, NamingException {
      if (this.manifestLigne != null) {
         if (this.datamodelProduit.isRowAvailable()) {
            this.manifestProduit = (ManifestProduit)this.datamodelProduit.getRowData();
            if (this.optionParcs.getProduitMANIFEST().equals("1")) {
               this.mesProduitsItems.clear();
               List var1;
               int var2;
               if (this.manifestEntete.getVtemanLibPortArr() != null && !this.manifestEntete.getVtemanLibPortArr().isEmpty()) {
                  new ArrayList();
                  var1 = this.produitsVtesDao.selectProduitsByLibelle(this.manifestEntete.getVtemanLibPortArr(), (Session)null);
                  if (var1.size() != 0) {
                     for(var2 = 0; var2 < var1.size(); ++var2) {
                        this.mesProduitsItems.add(new SelectItem(((Produits)var1.get(var2)).getProCode(), ((Produits)var1.get(var2)).getProLibClient()));
                     }
                  }
               } else {
                  this.mesProduitsItems.clear();
                  new ArrayList();
                  var1 = this.produitsVtesDao.selectAllProduits((Session)null);
                  if (var1.size() != 0) {
                     for(var2 = 0; var2 < var1.size(); ++var2) {
                        this.mesProduitsItems.add(new SelectItem(((Produits)var1.get(var2)).getProCode(), ((Produits)var1.get(var2)).getProLibClient()));
                     }
                  }
               }
            }

            this.visibiliteBtonDetaillig = true;
         }
      } else {
         this.visibiliteBtonDetaillig = false;
      }

   }

   public void ajouterProduit() throws HibernateException, NamingException, JDOMException, IOException {
      this.manifestProduit = new ManifestProduit();
      this.var_valide_prd = false;
      if (this.optionParcs.getProduitMANIFEST().equals("1")) {
         this.mesProduitsItems.clear();
         List var1;
         int var2;
         if (this.manifestEntete.getVtemanLibPortArr() != null && !this.manifestEntete.getVtemanLibPortArr().isEmpty()) {
            new ArrayList();
            var1 = this.produitsVtesDao.selectProduitsByLibelle(this.manifestEntete.getVtemanLibPortArr(), (Session)null);
            if (var1.size() != 0) {
               for(var2 = 0; var2 < var1.size(); ++var2) {
                  this.mesProduitsItems.add(new SelectItem(((Produits)var1.get(var2)).getProCode(), ((Produits)var1.get(var2)).getProLibClient()));
               }
            }
         } else {
            new ArrayList();
            var1 = this.produitsVtesDao.selectAllProduits((Session)null);
            if (var1.size() != 0) {
               for(var2 = 0; var2 < var1.size(); ++var2) {
                  this.mesProduitsItems.add(new SelectItem(((Produits)var1.get(var2)).getProCode(), ((Produits)var1.get(var2)).getProLibClient()));
               }
            }
         }
      }

      this.showModalPanelProduit = true;
   }

   public void modifierProduit() {
      if (this.manifestProduit != null) {
         this.var_valide_prd = true;
         this.showModalPanelProduit = true;
      }

   }

   public void consulterProduit() {
      if (this.manifestProduit != null) {
         this.var_valide_prd = false;
         this.showModalPanelProduit = true;
      }

   }

   public void supprimerProduit() throws HibernateException, NamingException {
      if (this.manifestProduit != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.manifestProduitDao.deleteOneLigne(this.manifestProduit, var1);
            this.lesLignesProduit.remove(this.manifestProduit);
            this.datamodelProduit.setWrappedData(this.lesLignesProduit);
            this.majTotalLv();
            var2.commit();
         } catch (HibernateException var7) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var7;
         } finally {
            this.utilInitHibernate.closeSession();
         }

         this.visibiliteBtonDetaillig = false;
      }

   }

   public void fermerProduit() {
      this.showModalPanelProduit = false;
   }

   public void validerListeProduit() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.manifestEntete != null) {
         if (this.manifestLigne.getVtelvId() == 0L) {
            this.manifestLigne.setManifestEntete(this.manifestEntete);
            this.manifestLigne.setTiers(this.tiers);
            this.manifestLigne.setVtelvDateCreat(new Date());
            this.manifestLigne.setVtelvIdUserCreat(this.usersLog.getUsrid());
            this.manifestLigne.setVtelvNumManifest(this.manifestEntete.getVtemanNum());
            this.manifestLigne = this.manifestLigneDao.insertLigne(this.manifestLigne);
            this.lesLignesList.add(this.manifestLigne);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesProduit.size(); ++var3) {
               this.manifestProduit = (ManifestProduit)this.lesLignesProduit.get(var3);
               this.manifestProduit.setVteprdNum(this.manifestLigne.getVtelvNum());
               this.manifestProduit.setVteprdNumManifest(this.manifestLigne.getVtelvNumManifest());
               if (this.manifestProduit.getVteprdId() == 0L) {
                  this.manifestProduit = this.manifestProduitDao.insertLigne(this.manifestProduit, var1);
                  this.lesLignesProduit.add(this.manifestProduit);
                  this.datamodelProduit.setWrappedData(this.lesLignesProduit);
               } else {
                  this.manifestProduit = this.manifestProduitDao.modifLigne(this.manifestProduit, var1);
               }
            }

            this.majTotalLv();
            this.manifestLigne = this.manifestLigneDao.modifLigne(this.manifestLigne, var1);
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

      this.showModalPanelLettre = false;
   }

   public void validerProduit() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.manifestEntete != null) {
         if (this.manifestLigne.getVtelvId() == 0L) {
            this.manifestLigne.setManifestEntete(this.manifestEntete);
            this.manifestLigne.setTiers(this.tiers);
            this.manifestLigne.setVtelvDateCreat(new Date());
            this.manifestLigne.setVtelvIdUserCreat(this.usersLog.getUsrid());
            this.manifestLigne.setVtelvNumManifest(this.manifestEntete.getVtemanNum());
            this.manifestLigne = this.manifestLigneDao.insertLigne(this.manifestLigne);
            this.lesLignesList.add(this.manifestLigne);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEntete");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.manifestProduit.setVteprdNum(this.manifestLigne.getVtelvNum());
            this.manifestProduit.setVteprdNumManifest(this.manifestLigne.getVtelvNumManifest());
            if (this.manifestProduit.getVteprdId() == 0L) {
               this.manifestProduit = this.manifestProduitDao.insertLigne(this.manifestProduit, var1);
               this.lesLignesProduit.add(this.manifestProduit);
               this.datamodelProduit.setWrappedData(this.lesLignesProduit);
            } else {
               this.manifestProduit = this.manifestProduitDao.modifLigne(this.manifestProduit, var1);
            }

            this.var_valide_lv = true;
            this.majTotalLv();
            this.manifestLigne = this.manifestLigneDao.modifLigne(this.manifestLigne, var1);
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

      this.showModalPanelProduit = false;
   }

   public void majTotalLv() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = 0.0D;
      int var11 = 0;
      float var12 = 0.0F;
      float var13 = 0.0F;

      for(int var14 = 0; var14 < this.lesLignesProduit.size(); ++var14) {
         var1 += ((ManifestProduit)this.lesLignesProduit.get(var14)).getVteprdTotalHt();
         var3 += ((ManifestProduit)this.lesLignesProduit.get(var14)).getVteprdTotalTva();
         var5 += ((ManifestProduit)this.lesLignesProduit.get(var14)).getVteprdTotalTtc();
         var7 += ((ManifestProduit)this.lesLignesProduit.get(var14)).getVteprdTc();
         var11 += ((ManifestProduit)this.lesLignesProduit.get(var14)).getVteprdNbreColis();
         var12 += ((ManifestProduit)this.lesLignesProduit.get(var14)).getVteprdPoids();
         var13 += ((ManifestProduit)this.lesLignesProduit.get(var14)).getVteprdVolume();
      }

      this.manifestLigne.setVtelvTotalHt(var1);
      this.manifestLigne.setVtelvTotalTva(var3);
      this.manifestLigne.setVtelvTotalTtc(var5);
      this.manifestLigne.setVtelvTc(var7);
      this.manifestLigne.setVtelvNbreColisExp(var11);
      this.manifestLigne.setVtelvPoidsExp(var12);
      this.manifestLigne.setVtelvVolumeExp(var13);
      this.manifestLigne.setVtelvTotalReglement(var9);
   }

   public void calculeCamion() throws HibernateException, NamingException {
      if (this.manifestLigne.getVtelvImmaCamion() != null && !this.manifestLigne.getVtelvImmaCamion().isEmpty() && !this.manifestLigne.getVtelvImmaCamion().equals("...")) {
         this.parc = this.parcDao.rechercheParc(this.manifestLigne.getVtelvImmaCamion(), (Session)null);
         if (this.parc != null) {
            this.calculeChauffeur();
         }
      } else {
         this.manifestLigne.setVtelvMatChauffeurExp("");
         this.manifestLigne.setVtelvMatChauffeurDest("");
      }

   }

   public void calculeChauffeur() throws HibernateException, NamingException {
      if (this.parc != null) {
         this.manifestLigne.setVtelvMatChauffeurExp("");
         this.manifestLigne.setVtelvMatChauffeurDest("");
         new ArrayList();
         ParcAffectationDao var2 = new ParcAffectationDao(this.baseLog, this.utilInitHibernate);
         List var1 = var2.rechercheAffectation(this.parc, 0, (Session)null);
         if (var1.size() != 0) {
            for(int var3 = 0; var3 < var1.size(); ++var3) {
               if (var3 == 0) {
                  this.manifestLigne.setVtelvMatChauffeurExp(((ParcAffectation)var1.get(var3)).getPrcaffMatSalarie());
               } else if (var3 == 1) {
                  this.manifestLigne.setVtelvMatChauffeurDest(((ParcAffectation)var1.get(var3)).getPrcaffMatSalarie());
               }
            }
         }
      }

   }

   public void rechercheResponsable() throws JDOMException, IOException, HibernateException, NamingException {
      this.responsable = this.formRecherche.rechercheCommercial(this.inpResponsable, this.nature);
      if (this.responsable != null) {
         if (this.responsable.getUsrid() != 0L) {
            this.calculeResponsable();
         } else {
            this.var_action = 11;
         }
      } else if (this.responsable == null) {
         this.calculeResponsable();
      }

   }

   public void recuperationResponsable() throws JDOMException, IOException, HibernateException, NamingException {
      this.responsable = this.formRecherche.calculeResponsable();
      this.calculeResponsable();
   }

   public void calculeResponsable() throws JDOMException, IOException {
      if (this.responsable != null) {
         this.inpResponsable = this.responsable.getUsrPatronyme();
      } else {
         this.inpResponsable = "";
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleResponsable() {
      this.inpResponsable = "";
      this.var_action = this.var_memo_action;
   }

   public void rechercheCommercial() throws JDOMException, IOException, HibernateException, NamingException {
      this.responsable = this.formRecherche.rechercheCommercial(this.inpCommercial, this.nature);
      if (this.responsable != null) {
         if (this.responsable.getUsrid() != 0L) {
            this.calculeCommercial();
         } else {
            this.var_action = 17;
         }
      } else if (this.responsable == null) {
         this.calculeCommercial();
      }

   }

   public void recuperationCommercial() throws JDOMException, IOException, HibernateException, NamingException {
      this.responsable = this.formRecherche.calculeCommercial();
      this.calculeCommercial();
   }

   public void calculeCommercial() throws JDOMException, IOException {
      if (this.responsable != null) {
         this.inpCommercial = this.responsable.getUsrPatronyme();
      } else {
         this.inpCommercial = "";
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleCommercial() {
      this.inpCommercial = "";
      this.var_action = this.var_memo_action;
   }

   public void serieSelectTrf(Session var1) throws HibernateException, NamingException, ParseException {
      this.mesSeriesTrfItems.clear();
      new ArrayList();
      List var2 = this.usersChronoDao.selectListByUserNat(this.usersLog, this.var_type_trf, var1);
      if (var2.size() != 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            if (this.usersLog.getUsrJrxReserve() == 1) {
               if (((UsersChrono)var2.get(var3)).getUsrchrPrive() == 0) {
                  this.mesSeriesTrfItems.add(new SelectItem(((UsersChrono)var2.get(var3)).getUsrchrSerie()));
               }
            } else {
               this.mesSeriesTrfItems.add(new SelectItem(((UsersChrono)var2.get(var3)).getUsrchrSerie()));
            }
         }

         this.var_aff_trf = true;
      } else {
         this.var_aff_trf = false;
      }

      if (this.optionsVentes.getDateTransformation().equals("0")) {
         this.var_date_trf = null;
      } else {
         this.var_date_trf = new Date();
      }

      this.var_serie_trf = this.manifestEntete.getVtemanSerie();
   }

   public void modeleSelectTrf() throws ParseException {
      this.modeleTrfItems.clear();
      String var1 = "";
      var1 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + this.baseLog + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "facture" + File.separator;
      File var2 = new File(var1);
      if (!var2.exists()) {
         var2.mkdir();
      }

      String[] var3 = var2.list();
      if (var3 != null) {
         var3 = this.triAlphabetique(var3, var3.length);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4].endsWith("jasper")) {
               String var5 = var3[var4].substring(0, var3[var4].indexOf("."));
               this.modeleTrfItems.add(new SelectItem(var5));
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

   public void accesImputSerie() {
      this.var_imput_choix = 0;
      this.var_imput_num = "";
      this.var_imput_serie = this.manifestEntete.getVtemanSerie();
      this.showModalPanelImput = true;
   }

   public void controleNumero() throws HibernateException, NamingException {
      if (this.var_imput_num != null && !this.var_imput_num.isEmpty()) {
         new ManifestEntete();
         ManifestEntete var1 = this.manifestEnteteDao.pourParapheur(this.var_imput_num, this.manifestEntete.getVtemanSerie(), (Session)null);
         if (var1 != null) {
            this.var_imput_num = "";
         }
      }

   }

   public void miseajourImput() throws IOException, JDOMException, HibernateException, NamingException, ParseException {
      Session var1;
      Transaction var2;
      String var3;
      ArrayList var4;
      int var5;
      Espion var21;
      Parapheur var6;
      if (this.var_imput_choix == 0) {
         if (this.var_imput_num != null && !this.var_imput_num.isEmpty()) {
            var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEntete");
            var2 = null;

            try {
               var2 = var1.beginTransaction();
               var3 = this.manifestEntete.getVtemanNum();
               this.manifestEntete.setVtemanNum(this.var_imput_num);
               this.manifestEnteteDao.modif(this.manifestEntete, var1);
               new ArrayList();
               if (this.parapheurDao == null) {
                  this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
               }

               var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.manifestEntete.getVtemanId(), this.nature, var1);
               if (var4 != null) {
                  for(var5 = 0; var5 < var4.size(); ++var5) {
                     new Parapheur();
                     var6 = (Parapheur)var4.get(var5);
                     var6.setPhrNum(this.manifestEntete.getVtemanNum());
                     this.parapheurDao.modif(var6, var1);
                  }
               }

               var21 = new Espion();
               var21.setUsers(this.usersLog);
               var21.setEsptype(0);
               var21.setEspdtecreat(new Date());
               var21.setEspaction("Imputation Manifeste N° " + var3 + " en Manifeste N° " + this.manifestEntete.getVtemanNum());
               this.espionDao.mAJEspion(var21, var1);
               var2.commit();
            } catch (HibernateException var19) {
               if (var2 != null) {
                  var2.rollback();
               }

               throw var19;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      } else if (!this.var_imput_serie.equalsIgnoreCase("X")) {
         var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "ManifestEntete");
         var2 = null;

         try {
            var2 = var1.beginTransaction();
            var3 = this.manifestEntete.getVtemanNum();
            this.manifestEntete.setVtemanSerie(this.var_imput_serie);
            this.manifestEntete.setVtemanNum(this.calculChrono.numCompose(this.manifestEntete.getVtemanDateDep(), this.nature, this.manifestEntete.getVtemanSerie(), var1));
            this.manifestEnteteDao.modif(this.manifestEntete, var1);
            new ArrayList();
            if (this.parapheurDao == null) {
               this.parapheurDao = new ParapheurDao(this.baseLog, this.utilInitHibernate);
            }

            var4 = (ArrayList)this.parapheurDao.parapheurDocument(this.manifestEntete.getVtemanId(), this.nature, var1);
            if (var4 != null) {
               for(var5 = 0; var5 < var4.size(); ++var5) {
                  new Parapheur();
                  var6 = (Parapheur)var4.get(var5);
                  var6.setPhrNum(this.manifestEntete.getVtemanNum());
                  this.parapheurDao.modif(var6, var1);
               }
            }

            var21 = new Espion();
            var21.setUsers(this.usersLog);
            var21.setEsptype(0);
            var21.setEspdtecreat(new Date());
            var21.setEspaction("Imputation Facture X N° " + var3 + " en Facture " + this.manifestEntete.getVtemanSerie() + " N° " + this.manifestEntete.getVtemanNum());
            this.espionDao.mAJEspion(var21, var1);
            var2.commit();
         } catch (HibernateException var17) {
            if (var2 != null) {
               var2.rollback();
            }

            throw var17;
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

   public void annuleTrf() {
      this.setShowModalPanelTrf(false);
   }

   public void transformerMaj() throws HibernateException, NamingException, Exception {
      if (this.documentDetailTrf.size() != 0 && this.lesEntetesList.size() != 0) {
         this.trfFac(this.documentDetailTrf);
         this.documentDetailTrf.clear();
         if (this.lesEntetesList.size() != 0) {
            for(int var1 = 0; var1 < this.lesEntetesList.size(); ++var1) {
               this.manifestEntete = (ManifestEntete)this.lesEntetesList.get(var1);
               if (this.manifestEntete.isVar_select_ligne()) {
                  this.lesEntetesList.remove(this.manifestEntete);
                  --var1;
               }
            }
         }

         this.datamodelEntete.setWrappedData(this.lesEntetesList);
         this.extDTable = new HtmlExtendedDataTable();
         this.simpleSelectionEntete.clear();
      }

      this.showModalPanelTrf = false;
      this.visibiliteBton = false;
   }

   public void trfFac(List var1) throws HibernateException, NamingException, Exception {
      new DevisEnteteVentes();
      DevisEnteteVentesDao var3 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      DevisLigneVentes var4 = new DevisLigneVentes();
      DevisLigneVentesDao var5 = new DevisLigneVentesDao(this.baseLog, this.utilInitHibernate);
      ArrayList var6 = new ArrayList();
      FactureLigneVentesDao var7 = new FactureLigneVentesDao(this.baseLog, this.utilInitHibernate);
      ArrayList var8 = new ArrayList();
      FactureEnteteVentes var9 = new FactureEnteteVentes();
      FactureInterneLigneVentesDao var10 = new FactureInterneLigneVentesDao(this.baseLog, this.utilInitHibernate);
      ArrayList var11 = new ArrayList();
      FactureInterneEnteteVentes var12 = new FactureInterneEnteteVentes();
      ArrayList var13 = new ArrayList();
      Session var14 = this.utilInitHibernate.getOpenSession(this.baseLog, "DocumentTransfertVte");
      Transaction var15 = null;

      try {
         var15 = var14.beginTransaction();

         for(int var16 = 0; var16 < var1.size(); ++var16) {
            this.manifestLigne = (ManifestLigne)var1.get(var16);
            if (this.manifestLigne.getVtelvModeFacture() == 1 && this.manifestLigne.getVtelvNumDevis() != null && !this.manifestLigne.getVtelvNumDevis().isEmpty()) {
               DevisEnteteVentes var2 = var3.selectByNum(var14, this.manifestLigne.getVtelvNumDevis());
               if (var2 != null) {
                  if (this.manifestLigne.getVtelvModeGroupe() == 1) {
                     this.generationFactureGroupeDevis(this.factureInterneEnteteVentesDao, var10, var11, var12, var2, var3, var5, var4, var6, var14);
                  } else {
                     this.generationFactureDevis(this.factureEnteteVentesDao, var7, var8, var9, var2, var3, var5, var4, var6, var14);
                  }
               }
            } else if (this.manifestLigne.getVtelvTotalHt() != 0.0D) {
               if (this.manifestLigne.getVtelvModeGroupe() == 1) {
                  this.generationFactureGroupeManifeste(this.factureInterneEnteteVentesDao, var10, var11, var12, var13, var14);
               } else {
                  this.generationFactureManifeste(this.factureEnteteVentesDao, var7, var8, var9, var13, var14);
               }
            }
         }

         var15.commit();
      } catch (HibernateException var20) {
         if (var15 != null) {
            var15.rollback();
         }

         throw var20;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void generationFactureManifeste(FactureEnteteVentesDao var1, FactureLigneVentesDao var2, List var3, FactureEnteteVentes var4, List var5, Session var6) throws HibernateException, NamingException, ParseException, Exception {
      boolean var7 = false;
      this.tiers = null;
      if (this.manifestLigne.getVtelvNumFacture() != null && !this.manifestLigne.getVtelvNumFacture().isEmpty()) {
         var4 = var1.pourParapheur(this.manifestLigne.getVtelvNumFacture(), var6);
         if (var4 != null) {
            if (var4.getFacDateTransfert() == null) {
               this.nettoyageLigneFacture(var2, var4, var6);
               this.tiers = var4.getTiers();
               var7 = true;
            }
         } else {
            var4 = new FactureEnteteVentes();
            var7 = true;
         }
      } else {
         var4 = new FactureEnteteVentes();
         var7 = true;
      }

      if (var7) {
         if (this.var_serie_trf != null && !this.var_serie_trf.isEmpty()) {
            var4.setFacSerie(this.var_serie_trf);
         } else {
            var4.setFacSerie(this.manifestLigne.getManifestEntete().getVtemanSerie());
         }

         var4.setUsers(this.usersLog);
         var4.setFacIdCreateur(this.usersLog.getUsrid());
         var4.setFacNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var4.setFacDate(this.manifestLigne.getManifestEntete().getVtemanDateArr());
         } else {
            var4.setFacDate(this.var_date_trf);
         }

         var4.setFacDateCreat(new Date());
         var4.setFacDateModif((Date)null);
         var4.setFacIdModif(0L);
         var4.setFacNomModif("");
         var4.setFacNum("");
         var4.setFacNumBl(this.manifestLigne.getManifestEntete().getVtemanNumBl());
         boolean var8 = false;
         int var31;
         if (this.optionsVentes.getNbrJrRelanceFAC() != null && !this.optionsVentes.getNbrJrRelanceFAC().isEmpty()) {
            var31 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceFAC());
         } else {
            var31 = 0;
         }

         boolean var9 = false;
         int var32;
         if (this.optionsVentes.getNbrJrValidFAC() != null && !this.optionsVentes.getNbrJrValidFAC().isEmpty()) {
            var32 = Integer.parseInt(this.optionsVentes.getNbrJrValidFAC());
         } else {
            var32 = 0;
         }

         var4.setFacDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var31));
         var4.setFacDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var32));
         boolean var10 = false;
         if (this.manifestLigne.getVtelvNumFacture() != null && !this.manifestLigne.getVtelvNumFacture().isEmpty()) {
            new FactureEnteteVentes();
            FactureEnteteVentes var33 = var1.pourParapheur(this.manifestLigne.getVtelvNumFacture(), var6);
            if (var33 != null) {
               if (var33.getFacDateTransfert() == null && var33.getFacTotReglement() == 0.0D) {
                  var2.deleteAllLigne(var33, var6);
                  var1.delete(var33, var6);
                  var4.setFacNum(this.manifestLigne.getVtelvNumFacture());
                  var10 = true;
               } else {
                  var10 = false;
               }
            } else {
               var10 = true;
               var4.setFacNum(this.manifestLigne.getVtelvNumFacture());
            }
         } else {
            var10 = true;
            if (!var4.getFacSerie().equalsIgnoreCase("X") && !var4.getFacSerie().isEmpty()) {
               var4.setFacNum(this.calculChrono.numCompose(var4.getFacDate(), 25, var4.getFacSerie(), var6));
            } else {
               long var11 = var1.selectLastNum(var6);
               var4.setFacNum("" + var11);
            }
         }

         if (var10) {
            this.verifieExistenceHabilitationFac(var4, var6);
            var4.setFacSource((String)null);
            var4.setFacNomResponsable(this.manifestLigne.getManifestEntete().getVtemanNomResponsable());
            var4.setFacIdResponsable(this.manifestLigne.getManifestEntete().getVtemanIdResponsable());
            var4.setFacNomCommercial(this.manifestLigne.getManifestEntete().getVtemanNomCommercial());
            var4.setFacIdCommercial(this.manifestLigne.getManifestEntete().getVtemanIdCommercial());
            var4.setFacNomEquipe(this.manifestLigne.getManifestEntete().getVtemanNomEquipe());
            var4.setFacIdEquipe(this.manifestLigne.getManifestEntete().getVtemanIdEquipe());
            if (this.manifestLigne.getVtelvModeClient() == 1) {
               var4.setFacNomContact(this.manifestLigne.getVtelvContactExp());
            } else {
               var4.setFacNomContact(this.manifestLigne.getVtelvContactDest());
            }

            if (this.manifestLigne.getVtelvCompteClient() != null && !this.manifestLigne.getVtelvCompteClient().isEmpty()) {
               this.tiers = this.tiersDao.chargerTiersByCompte(this.manifestLigne.getVtelvCompteClient(), var6);
            } else {
               this.tiers = this.tiersDao.chargerLesTiers("3", this.manifestLigne.getVtelvIntituleClient(), var6);
            }

            if (this.tiers != null) {
               var4.setFacNomTiers(this.tiers.getTieraisonsocialenom());
               if (this.tiers.getTiegenre() == null || this.tiers.getTiegenre().isEmpty() || !this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
                  var4.setFacNomTiers(this.tiers.getTieraisonsocialenom());
                  var4.setFacCivilTiers("");
               } else {
                  if (this.tiers.getTieprenom() != null && !this.tiers.getTieprenom().isEmpty()) {
                     var4.setFacNomTiers(this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom());
                  } else {
                     var4.setFacNomTiers(this.tiers.getTieraisonsocialenom());
                  }

                  var4.setFacCivilTiers(var4.getTiers().getTiecivilite());
               }

               var4.setFacTiersRegroupe(this.tiers.getTiesigle());
               var4.setFacExoTva(this.manifestLigne.getVtelvExoTva());
               var4.setFacExoDouane(this.tiers.getTieexodouane());
               var4.setFacJournalReg(this.tiers.getTiejournalreg());
               var4.setFacCat(this.manifestLigne.getVtelvCat());
               var4.setFacDevise(this.tiers.getTiedevise());
               var4.setFacIdContact(0L);
               var4.setFacContener("");
               var4.setFacCivilContact("");
               var4.setFacDiversAdresse("");
               var4.setFacDiversMail("");
               var4.setFacDiversNom("");
               var4.setFacDiversTel("");
               var4.setFacDiversTiers(0);
               var4.setFacDiversVille("");
               var4.setFacObject("Transport de " + this.manifestLigne.getManifestEntete().getVtemanLibPortDep() + " à " + this.manifestLigne.getManifestEntete().getVtemanLibPortArr());
               var4.setFacObservation(this.manifestLigne.getVtelvObservation());
               var4.setFacTauxRemise(0.0F);
               var4.setFacTotHt(0.0D);
               var4.setFacTotRemise(0.0D);
               var4.setFacTotRabais(0.0D);
               var4.setFacTotTva(0.0D);
               var4.setFacTotTc(0.0D);
               var4.setFacTotTtc(0.0D);
               var4.setFacTotReglement(0.0D);
               var4.setFacSolde(0);
               var4.setFacBanque(this.tiers.getTienombanque());
               var4.setFacTypeReg(this.tiers.getTietypereg());
               var4.setFacModeReg(this.tiers.getTiemodereg());
               var4.setFacNbJourReg(this.tiers.getTienbecheance());
               var4.setFacArrondiReg(this.tiers.getTienbarrondi());
               var4.setFacConditionReg(this.tiers.getTieconditionreg());
               Date var34 = this.utilDate.CalculDateEcheance(var4.getFacDate(), var4.getFacTypeReg(), var4.getFacNbJourReg(), var4.getFacArrondiReg());
               var4.setFacDateEcheReg(var34);
               var4.setFacContener("");
               var4.setFacActivite(this.manifestLigne.getManifestEntete().getVtemanActivite());
               var4.setFacSite(this.manifestLigne.getManifestEntete().getVtemanSite());
               var4.setFacDepartement(this.manifestLigne.getManifestEntete().getVtemanDepartement());
               var4.setFacService(this.manifestLigne.getManifestEntete().getVtemanService());
               var4.setFacRegion("");
               var4.setFacSecteur("");
               var4.setFacPdv("");
               var4.setFacNumBl(this.manifestLigne.getManifestEntete().getVtemanNumBl());
               var4.setFacAnal2(this.manifestLigne.getManifestEntete().getVtemanRefNavire());
               var4.setFacAnal4(this.manifestLigne.getManifestEntete().getVtemanNum());
               var4.setFacInfo1("");
               var4.setFacInfo2("");
               var4.setFacInfo3("");
               var4.setFacInfo4("");
               var4.setFacInfo5("");
               var4.setFacInfo6("");
               var4.setFacInfo7("");
               var4.setFacInfo8("");
               var4.setFacInfo9("");
               var4.setFacInfo10("");
               var4.setFacFormule1("");
               var4.setFacFormule2("");
               var4.setFacAnnexe1("");
               var4.setFacAnnexe2("");
               var4.setFacContrat("");
               var4.setFacIncoterm("");
               var4.setFacLieuLivraison("");
               var4.setFacDateLivraison((Date)null);
               var4.setFacInfoLivraison("");
               var4.setFacDateImp((Date)null);
               var4.setFacModeleImp(this.var_modele_trf);
               var4.setFacGarde("");
               var4.setFacRistourneBloquee(false);
               var4.setFacGele(0);
               var4.setFacEtat(1);
               var4.setFacDateTransforme((Date)null);
               var4.setFacTypeTransforme(0);
               var4.setFacDateAnnule((Date)null);
               var4.setFacMotifAnnule("");
               var4.setFacFactorNom("");
               var4.setFacFactorId(0L);
               var4.setFacFactorEtat(0);
               var4.setExerciceventes(this.exercicesVentes);
               var4.setTiers(this.tiers);
               var4.setUsers(this.usersLog);
               var4.setFacStock(0);
               var4.setFacNumClient("");
               var4.setFacDateClient((Date)null);
               var4 = var1.insert(var4, var6);
               double var12 = 0.0D;
               double var14 = 0.0D;
               double var16 = 0.0D;
               double var18 = 0.0D;
               double var20 = 0.0D;
               double var22 = 0.0D;
               int var24 = 0;
               String var25 = "";
               var5.clear();
               var5 = this.manifestLigneDao.chargerLesLignesByLv(this.manifestEntete, this.manifestLigne.getVtelvNum(), var6);
               if (var5.size() != 0) {
                  int var26 = 0;

                  while(true) {
                     if (var26 >= var5.size()) {
                        var4.setFacContener(var25);
                        var4.setFacTotHt(var12);
                        var4.setFacTotRemise(var14);
                        var4.setFacTotRabais(var16);
                        var4.setFacTotTva(var18);
                        var4.setFacTotTc(var22);
                        var4.setFacTotTtc(var20);
                        var4 = var1.modif(var4, var6);
                        break;
                     }

                     this.manifestLigne = (ManifestLigne)var5.get(var26);
                     new ArrayList();
                     List var27 = this.manifestProduitDao.chargerLesLignes(this.manifestLigne, var6);

                     for(int var28 = 0; var28 < var27.size(); ++var28) {
                        this.manifestProduit = (ManifestProduit)var27.get(var28);
                        if (this.manifestProduit.getVteprdImmaTc1() != null && !this.manifestProduit.getVteprdImmaTc1().isEmpty()) {
                           if (var25 != null && !var25.isEmpty()) {
                              var25 = var25 + "," + this.manifestProduit.getVteprdImmaTc1();
                           } else {
                              var25 = this.manifestProduit.getVteprdImmaTc1();
                           }
                        }

                        if (this.manifestProduit.getVteprdImmaTc2() != null && !this.manifestProduit.getVteprdImmaTc2().isEmpty()) {
                           if (var25 != null && !var25.isEmpty()) {
                              var25 = var25 + "," + this.manifestProduit.getVteprdImmaTc2();
                           } else {
                              var25 = this.manifestProduit.getVteprdImmaTc2();
                           }
                        }

                        FactureLigneVentes var29 = new FactureLigneVentes();
                        ++var24;
                        var29.setFacligOrdre(var24);
                        var29.setFacligCode(this.manifestProduit.getVteprdRefTypeColis());
                        if (this.manifestProduit.getVteprdRefTypeColis() != null && !this.manifestProduit.getVteprdRefTypeColis().isEmpty()) {
                           this.produits = this.produitsVtesDao.chargeProduit(this.manifestProduit.getVteprdRefTypeColis(), var6);
                           if (this.produits != null) {
                              var29.setFacligFamille(this.produits.getProVteCode());
                           } else {
                              var29.setFacligFamille("");
                           }
                        } else {
                           var29.setFacligFamille("");
                        }

                        var29.setFacligLibelle("Transport " + this.manifestProduit.getVteprdLibTypeColis());
                        var29.setFacligGroupe("");
                        var29.setFacligModeGroupe(0);
                        var29.setFacligDevise(var4.getFacDevise());
                        var29.setFacligIdBlv(this.manifestProduit.getVteprdId());
                        var29.setFacligComplement(this.manifestProduit.getVteprdNatureColis());
                        var29.setFacligDepot("");
                        var29.setFacligEchelle(0);
                        var29.setFacligUnite("");
                        var29.setFacligCondition("");
                        var29.setFacligStock(0);
                        var29.setFacligReference(this.manifestProduit.getVteprdNum());
                        var29.setFacligPump(0.0D);
                        var29.setFacligPu(this.manifestProduit.getVteprdPu());
                        var29.setFacligPuTtc(0.0D);
                        var29.setFacligTauxRemise(this.manifestProduit.getVteprdRemise());
                        var29.setFacligPuRem(this.manifestProduit.getVteprdPuRem());
                        var29.setFacligPuRemTtc(0.0D);
                        var29.setFacligLong(0.0F);
                        var29.setFacligLarg(0.0F);
                        var29.setFacligHaut(0.0F);
                        var29.setFacligDiam(0.0F);
                        var29.setFacligPoidsBrut(this.manifestProduit.getVteprdPoids());
                        var29.setFacligPoidsNet(0.0F);
                        var29.setFacligVolume(this.manifestProduit.getVteprdVolume());
                        var29.setFacligNb((float)this.manifestProduit.getVteprdNbreColis());
                        float var30 = 0.0F;
                        if (this.manifestProduit.getVteprdModeFactureDetail() != 2 && this.manifestProduit.getVteprdModeFactureDetail() != 3 && this.manifestProduit.getVteprdModeFactureDetail() != 4) {
                           if (this.manifestProduit.getVteprdModeFactureDetail() == 1) {
                              if (this.manifestProduit.getVteprdPoids() / 1000.0F >= this.manifestProduit.getVteprdVolume()) {
                                 var30 = this.manifestProduit.getVteprdPoids() / 1000.0F;
                              } else {
                                 var30 = this.manifestProduit.getVteprdVolume();
                              }
                           }
                        } else {
                           var30 = (float)this.manifestProduit.getVteprdNbreColis();
                        }

                        var29.setFacligQte(var30);
                        var29.setFacligQteUtil(var30);
                        var29.setFacligQteStock(0.0F);
                        var29.setFacligRabais(0.0D);
                        var29.setFacligTauxTaxe(this.manifestProduit.getVteprdTauxTva());
                        var29.setFacligTaxe(this.manifestProduit.getVteprdCodeTva());
                        var29.setFacligPt(this.manifestProduit.getVteprdTotalHt());
                        var29.setFacligTva(this.manifestProduit.getVteprdTotalTva());
                        var29.setFacligTtc(this.manifestProduit.getVteprdTotalTtc());
                        var29.setFacligTc(this.manifestProduit.getVteprdTc());
                        var29.setFacligEntStock(0);
                        var29.setFactureEnteteVentes(var4);
                        var29 = var2.insertLigne(var29, var6);
                        var3.add(var29);
                        var12 += var29.getFacligPt();
                        var14 += (var29.getFacligPu() - var29.getFacligPuRem()) * (double)var29.getFacligQte();
                        var18 += var29.getFacligTva();
                        var20 += var29.getFacligTtc();
                        var22 += var29.getFacligTc();
                        this.manifestLigne.setVtelvNumFacture(var4.getFacNum());
                        this.manifestLigne = this.manifestLigneDao.modifLigne(this.manifestLigne, var6);
                     }

                     ++var26;
                  }
               }

               this.manifestEntete = this.manifestEnteteDao.pourParapheur(this.manifestEntete.getVtemanId(), var6);
               if (this.manifestEntete != null) {
                  this.manifestEntete.setVtemanEtat(4);
                  this.manifestEntete = this.manifestEnteteDao.modif(this.manifestEntete, var6);
               }

               double var35 = this.utilNombre.myRound(var4.getFacTotTtc() + var4.getFacTotTc(), 0);
               this.utilNombre.begin(var35, this.structureLog.getStrdevise());
               this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationFac(var4, var6), var4.getFacId(), var4.getFacNum(), var4.getFacNomTiers(), var4.getFacDate(), var4.getFacDevise(), var4.getFacTotTtc() + var4.getFacTotTc(), var4.getFacModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 25), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFFAC(var3, var4), this.calculeParc(var6), var4.getVar_format_devise(), 0, var6);
               if (this.optionsVentes.getAxeDossier().equals("2") && var4.getFacAnal4() != null && !var4.getFacAnal4().isEmpty()) {
                  PlansAnalytiquesDao var36 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
                  this.plansAnalytiques = var36.rechercheAffaire(var4.getFacAnal4(), var6);
                  if (this.plansAnalytiques != null) {
                     this.plansAnalytiques.setAnaCode(var4.getFacAnal4());
                     this.plansAnalytiques.setAnaNomFr(var4.getFacObject());
                     this.plansAnalytiques.setAnaAffaireDateFacture(var4.getFacDate());
                     this.plansAnalytiques = var36.modif(this.plansAnalytiques, var6);
                  }
               }
            }
         }
      }

   }

   public void generationFactureDevis(FactureEnteteVentesDao var1, FactureLigneVentesDao var2, List var3, FactureEnteteVentes var4, DevisEnteteVentes var5, DevisEnteteVentesDao var6, DevisLigneVentesDao var7, DevisLigneVentes var8, List var9, Session var10) throws HibernateException, NamingException, ParseException, Exception {
      boolean var11 = false;
      this.tiers = null;
      if (this.manifestLigne.getVtelvNumFacture() != null && !this.manifestLigne.getVtelvNumFacture().isEmpty()) {
         var4 = var1.pourParapheur(this.manifestLigne.getVtelvNumFacture(), var10);
         if (var4 != null) {
            if (var4.getFacDateTransfert() == null) {
               this.nettoyageLigneFacture(var2, var4, var10);
               this.tiers = var4.getTiers();
               var11 = true;
            }
         } else {
            var4 = new FactureEnteteVentes();
            var11 = true;
         }
      } else {
         var4 = new FactureEnteteVentes();
         var11 = true;
      }

      if (var11) {
         if (this.var_serie_trf != null && !this.var_serie_trf.isEmpty()) {
            var4.setFacSerie(this.var_serie_trf);
         } else {
            var4.setFacSerie(var5.getDvsSerie());
         }

         var4.setUsers(this.usersLog);
         var4.setFacIdCreateur(this.usersLog.getUsrid());
         var4.setFacNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var4.setFacDate(var5.getDvsDate());
         } else {
            var4.setFacDate(this.var_date_trf);
         }

         var4.setFacDateCreat(new Date());
         var4.setFacDateModif((Date)null);
         var4.setFacIdModif(0L);
         var4.setFacNomModif("");
         var4.setFacNum("");
         var4.setFacNumBl("");
         boolean var12 = false;
         int var34;
         if (this.optionsVentes.getNbrJrRelanceFAC() != null && !this.optionsVentes.getNbrJrRelanceFAC().isEmpty()) {
            var34 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceFAC());
         } else {
            var34 = 0;
         }

         boolean var13 = false;
         int var35;
         if (this.optionsVentes.getNbrJrValidFAC() != null && !this.optionsVentes.getNbrJrValidFAC().isEmpty()) {
            var35 = Integer.parseInt(this.optionsVentes.getNbrJrValidFAC());
         } else {
            var35 = 0;
         }

         var4.setFacDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var34));
         var4.setFacDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var35));
         boolean var14 = true;
         if (!var4.getFacSerie().equalsIgnoreCase("X") && !var4.getFacSerie().isEmpty()) {
            var4.setFacNum(this.calculChrono.numCompose(var4.getFacDate(), 25, var4.getFacSerie(), var10));
         } else {
            long var15 = var1.selectLastNum(var10);
            var4.setFacNum("" + var15);
         }

         if (var14) {
            this.verifieExistenceHabilitationFac(var4, var10);
            var4.setFacSource((String)null);
            var4.setFacNomResponsable(var5.getDvsNomResponsable());
            var4.setFacIdResponsable(var5.getDvsIdResponsable());
            var4.setFacNomCommercial(var5.getDvsNomCommercial());
            var4.setFacIdCommercial(var5.getDvsIdCommercial());
            var4.setFacNomEquipe(var5.getDvsNomEquipe());
            var4.setFacIdEquipe(var5.getDvsIdEquipe());
            var4.setFacNomContact(var5.getDvsNomContact());
            this.tiers = var5.getTiers();
            if (this.tiers != null) {
               var4.setFacNomTiers(this.tiers.getTieraisonsocialenom());
               if (this.tiers.getTiegenre() != null && !this.tiers.getTiegenre().isEmpty() && (this.tiers.getTiegenre().equalsIgnoreCase("010") || this.tiers.getTiegenre().equalsIgnoreCase("020") || this.tiers.getTiegenre().equalsIgnoreCase("030") || this.tiers.getTiegenre().equalsIgnoreCase("037"))) {
                  if (this.tiers.getTieprenom() != null && !this.tiers.getTieprenom().isEmpty()) {
                     var4.setFacNomTiers(this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom());
                  } else {
                     var4.setFacNomTiers(this.tiers.getTieraisonsocialenom());
                  }

                  var4.setFacCivilTiers(var4.getTiers().getTiecivilite());
               } else {
                  var4.setFacNomTiers(this.tiers.getTieraisonsocialenom());
                  var4.setFacCivilTiers("");
               }

               var4.setFacTiersRegroupe(this.tiers.getTiesigle());
               var4.setFacExoTva(var5.getDvsExoTva());
               var4.setFacExoDouane(this.tiers.getTieexodouane());
               var4.setFacJournalReg(this.tiers.getTiejournalreg());
               var4.setFacCat(var5.getDvsCat());
               var4.setFacDevise(this.tiers.getTiedevise());
               var4.setFacIdContact(0L);
               var4.setFacContener("");
               var4.setFacCivilContact("");
               var4.setFacDiversAdresse("");
               var4.setFacDiversMail("");
               var4.setFacDiversNom("");
               var4.setFacDiversTel("");
               var4.setFacDiversTiers(0);
               var4.setFacDiversVille("");
               var4.setFacObject("Transport de " + this.manifestLigne.getManifestEntete().getVtemanLibPortDep() + " à " + this.manifestLigne.getManifestEntete().getVtemanLibPortArr());
               var4.setFacObservation(var5.getDvsObservation());
               var4.setFacTauxRemise(0.0F);
               var4.setFacTotHt(0.0D);
               var4.setFacTotRemise(0.0D);
               var4.setFacTotRabais(0.0D);
               var4.setFacTotTva(0.0D);
               var4.setFacTotTc(0.0D);
               var4.setFacTotTtc(0.0D);
               var4.setFacTotReglement(0.0D);
               var4.setFacSolde(0);
               var4.setFacBanque(this.tiers.getTienombanque());
               var4.setFacTypeReg(this.tiers.getTietypereg());
               var4.setFacModeReg(this.tiers.getTiemodereg());
               var4.setFacNbJourReg(this.tiers.getTienbecheance());
               var4.setFacArrondiReg(this.tiers.getTienbarrondi());
               var4.setFacConditionReg(this.tiers.getTieconditionreg());
               Date var36 = this.utilDate.CalculDateEcheance(var4.getFacDate(), var4.getFacTypeReg(), var4.getFacNbJourReg(), var4.getFacArrondiReg());
               var4.setFacDateEcheReg(var36);
               var4.setFacContener("");
               var4.setFacActivite(var5.getDvsActivite());
               var4.setFacSite(var5.getDvsSite());
               var4.setFacDepartement(var5.getDvsDepartement());
               var4.setFacService(var5.getDvsService());
               var4.setFacRegion("");
               var4.setFacSecteur("");
               var4.setFacPdv("");
               var4.setFacNumBl(this.manifestLigne.getManifestEntete().getVtemanNumBl());
               var4.setFacAnal2(this.manifestLigne.getManifestEntete().getVtemanRefNavire());
               var4.setFacAnal4(this.manifestLigne.getManifestEntete().getVtemanNum());
               var4.setFacInfo1("");
               var4.setFacInfo2("");
               var4.setFacInfo3("");
               var4.setFacInfo4("");
               var4.setFacInfo5("");
               var4.setFacInfo6("");
               var4.setFacInfo7("");
               var4.setFacInfo8("");
               var4.setFacInfo9("");
               var4.setFacInfo10("");
               var4.setFacFormule1("");
               var4.setFacFormule2("");
               var4.setFacAnnexe1("");
               var4.setFacAnnexe2("");
               var4.setFacContrat("");
               var4.setFacIncoterm("");
               var4.setFacLieuLivraison("");
               var4.setFacDateLivraison((Date)null);
               var4.setFacInfoLivraison("");
               var4.setFacDateImp((Date)null);
               var4.setFacModeleImp(this.var_modele_trf);
               var4.setFacGarde("");
               var4.setFacRistourneBloquee(false);
               var4.setFacGele(0);
               var4.setFacEtat(1);
               var4.setFacDateTransforme((Date)null);
               var4.setFacTypeTransforme(0);
               var4.setFacDateAnnule((Date)null);
               var4.setFacMotifAnnule("");
               var4.setFacFactorNom("");
               var4.setFacFactorId(0L);
               var4.setFacFactorEtat(0);
               var4.setExerciceventes(this.exercicesVentes);
               var4.setTiers(this.tiers);
               var4.setUsers(this.usersLog);
               var4.setFacStock(0);
               var4.setFacNumClient("");
               var4.setFacDateClient((Date)null);
               var4 = var1.insert(var4, var10);
               double var16 = 0.0D;
               double var18 = 0.0D;
               double var20 = 0.0D;
               double var22 = 0.0D;
               double var24 = 0.0D;
               double var26 = 0.0D;
               int var28 = 0;
               String var29 = "";
               var9.clear();
               var9 = var7.chargerLesLignes(var5, var10);
               if (var9.size() != 0) {
                  int var30 = 0;

                  while(true) {
                     if (var30 >= var9.size()) {
                        var4.setFacContener(var29);
                        var4.setFacTotHt(var16);
                        var4.setFacTotRemise(var18);
                        var4.setFacTotRabais(var20);
                        var4.setFacTotTva(var22);
                        var4.setFacTotTc(var26);
                        var4.setFacTotTtc(var24);
                        var4 = var1.modif(var4, var10);
                        var5.setDvsEtat(5);
                        var6.modif(var5, var10);
                        break;
                     }

                     var8 = (DevisLigneVentes)var9.get(var30);
                     FactureLigneVentes var31 = new FactureLigneVentes();
                     ++var28;
                     var31.setFacligOrdre(var28);
                     var31.setFacligCode(var8.getDvsligCode());
                     if (var8.getDvsligCode() != null && !var8.getDvsligCode().isEmpty()) {
                        this.produits = this.produitsVtesDao.chargeProduit(var8.getDvsligCode(), var10);
                        var31.setFacligFamille(this.produits.getProVteCode());
                     } else {
                        var31.setFacligFamille("");
                     }

                     var31.setFacligLibelle("Transport " + var8.getDvsligLibelle());
                     var31.setFacligGroupe("");
                     var31.setFacligModeGroupe(0);
                     var31.setFacligDevise(var4.getFacDevise());
                     var31.setFacligIdDvs(var8.getDvsligId());
                     var31.setFacligIdBlv(0L);
                     var31.setFacligComplement(var8.getDvsligComplement());
                     var31.setFacligDepot("");
                     var31.setFacligEchelle(0);
                     var31.setFacligUnite("");
                     var31.setFacligCondition("");
                     var31.setFacligStock(0);
                     var31.setFacligReference(var8.getDvsligReference());
                     var31.setFacligPump(0.0D);
                     var31.setFacligPu(var8.getDvsligPu());
                     var31.setFacligPuTtc(0.0D);
                     var31.setFacligTauxRemise(var8.getDvsligTauxRemise());
                     var31.setFacligPuRem(var8.getDvsligPuRem());
                     var31.setFacligPuRemTtc(0.0D);
                     var31.setFacligLong(0.0F);
                     var31.setFacligLarg(0.0F);
                     var31.setFacligHaut(0.0F);
                     var31.setFacligDiam(0.0F);
                     var31.setFacligPoidsBrut(var8.getDvsligPoidsBrut());
                     var31.setFacligPoidsNet(0.0F);
                     var31.setFacligVolume(var8.getDvsligVolume());
                     var31.setFacligNb(var8.getDvsligNb());
                     var31.setFacligQte(var8.getDvsligQte());
                     var31.setFacligQteUtil(var8.getDvsligQteUtil());
                     var31.setFacligQteStock(0.0F);
                     var31.setFacligRabais(0.0D);
                     var31.setFacligTauxTaxe(var8.getDvsligTauxTaxe());
                     var31.setFacligTaxe(var8.getDvsligTaxe());
                     var31.setFacligPt(var8.getDvsligPt());
                     var31.setFacligTva(var8.getDvsligTva());
                     var31.setFacligTtc(var8.getDvsligTtc());
                     var31.setFacligTc(var8.getDvsligTc());
                     var31.setFacligEntStock(0);
                     var31.setFactureEnteteVentes(var4);
                     var31 = var2.insertLigne(var31, var10);
                     var3.add(var31);
                     var16 += var31.getFacligPt();
                     var18 += (var31.getFacligPu() - var31.getFacligPuRem()) * (double)var31.getFacligQte();
                     var22 += var31.getFacligTva();
                     var24 += var31.getFacligTtc();
                     var26 += var31.getFacligTc();
                     this.manifestLigne.setVtelvNumFacture(var4.getFacNum());
                     this.manifestLigne = this.manifestLigneDao.modifLigne(this.manifestLigne, var10);
                     ++var30;
                  }
               }

               this.manifestEntete = this.manifestEnteteDao.pourParapheur(this.manifestEntete.getVtemanId(), var10);
               if (this.manifestEntete != null) {
                  this.manifestEntete.setVtemanEtat(4);
                  this.manifestEntete = this.manifestEnteteDao.modif(this.manifestEntete, var10);
               }

               double var37 = this.utilNombre.myRound(var4.getFacTotTtc() + var4.getFacTotTc(), 0);
               this.utilNombre.begin(var37, this.structureLog.getStrdevise());
               this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationFac(var4, var10), var4.getFacId(), var4.getFacNum(), var4.getFacNomTiers(), var4.getFacDate(), var4.getFacDevise(), var4.getFacTotTtc() + var4.getFacTotTc(), var4.getFacModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 25), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFFAC(var3, var4), this.calculeParc(var10), var4.getVar_format_devise(), 0, var10);
               if (this.optionsVentes.getAxeDossier().equals("2") && var4.getFacAnal4() != null && !var4.getFacAnal4().isEmpty()) {
                  PlansAnalytiquesDao var33 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
                  this.plansAnalytiques = var33.rechercheAffaire(var4.getFacAnal4(), var10);
                  if (this.plansAnalytiques != null) {
                     this.plansAnalytiques.setAnaCode(var4.getFacAnal4());
                     this.plansAnalytiques.setAnaNomFr(var4.getFacObject());
                     this.plansAnalytiques.setAnaAffaireDateFacture(var4.getFacDate());
                     this.plansAnalytiques = var33.modif(this.plansAnalytiques, var10);
                  }
               }
            }
         }
      }

   }

   public void generationFactureGroupeManifeste(FactureInterneEnteteVentesDao var1, FactureInterneLigneVentesDao var2, List var3, FactureInterneEnteteVentes var4, List var5, Session var6) throws HibernateException, NamingException, ParseException, Exception {
      boolean var7 = false;
      this.tiers = null;
      if (this.manifestLigne.getVtelvNumFacture() != null && !this.manifestLigne.getVtelvNumFacture().isEmpty()) {
         var4 = var1.pourParapheur(this.manifestLigne.getVtelvNumFacture(), var6);
         if (var4 != null) {
            if (var4.getFitDateTransfert() == null) {
               this.nettoyageLigneFactureInterne(var2, var4, var6);
               this.tiers = var4.getTiers();
               var7 = true;
            }
         } else {
            var4 = new FactureInterneEnteteVentes();
            var7 = true;
         }
      } else {
         var4 = new FactureInterneEnteteVentes();
         var7 = true;
      }

      if (var7) {
         if (this.var_serie_trf != null && !this.var_serie_trf.isEmpty()) {
            var4.setFitSerie(this.var_serie_trf);
         } else {
            var4.setFitSerie(this.manifestLigne.getManifestEntete().getVtemanSerie());
         }

         var4.setUsers(this.usersLog);
         var4.setFitIdCreateur(this.usersLog.getUsrid());
         var4.setFitNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var4.setFitDate(this.manifestLigne.getManifestEntete().getVtemanDateArr());
         } else {
            var4.setFitDate(this.var_date_trf);
         }

         var4.setFitDateCreat(new Date());
         var4.setFitDateModif((Date)null);
         var4.setFitIdModif(0L);
         var4.setFitNomModif("");
         var4.setFitNum("");
         var4.setFitNumBl(this.manifestLigne.getManifestEntete().getVtemanNumBl());
         boolean var8 = false;
         int var31;
         if (this.optionsVentes.getNbrJrRelanceFAC() != null && !this.optionsVentes.getNbrJrRelanceFAC().isEmpty()) {
            var31 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceFAC());
         } else {
            var31 = 0;
         }

         boolean var9 = false;
         int var32;
         if (this.optionsVentes.getNbrJrValidFAC() != null && !this.optionsVentes.getNbrJrValidFAC().isEmpty()) {
            var32 = Integer.parseInt(this.optionsVentes.getNbrJrValidFAC());
         } else {
            var32 = 0;
         }

         var4.setFitDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var31));
         var4.setFitDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var32));
         boolean var10 = false;
         if (this.manifestLigne.getVtelvNumFacture() != null && !this.manifestLigne.getVtelvNumFacture().isEmpty()) {
            new FactureInterneEnteteVentes();
            FactureInterneEnteteVentes var33 = var1.pourParapheur(this.manifestLigne.getVtelvNumFacture(), var6);
            if (var33 != null) {
               if (var33.getFitDateTransfert() == null && var33.getFitTotReglement() == 0.0D) {
                  var2.deleteAllLigne(var33, var6);
                  var1.delete(var33.getFitId(), var6);
                  var4.setFitNum(this.manifestLigne.getVtelvNumFacture());
                  var10 = true;
               } else {
                  var10 = false;
               }
            } else {
               var10 = true;
               var4.setFitNum(this.manifestLigne.getVtelvNumFacture());
            }
         } else {
            var10 = true;
            if (!var4.getFitSerie().equalsIgnoreCase("X") && !var4.getFitSerie().isEmpty()) {
               var4.setFitNum(this.calculChrono.numCompose(var4.getFitDate(), 142, var4.getFitSerie(), var6));
            } else {
               long var11 = var1.selectLastNum(var6);
               var4.setFitNum("" + var11);
            }
         }

         if (var10) {
            this.verifieExistenceHabilitationFacInt(var4, var6);
            var4.setFitSource((String)null);
            var4.setFitNomResponsable(this.manifestLigne.getManifestEntete().getVtemanNomResponsable());
            var4.setFitIdResponsable(this.manifestLigne.getManifestEntete().getVtemanIdResponsable());
            var4.setFitNomCommercial(this.manifestLigne.getManifestEntete().getVtemanNomCommercial());
            var4.setFitIdCommercial(this.manifestLigne.getManifestEntete().getVtemanIdCommercial());
            var4.setFitNomEquipe(this.manifestLigne.getManifestEntete().getVtemanNomEquipe());
            var4.setFitIdEquipe(this.manifestLigne.getManifestEntete().getVtemanIdEquipe());
            if (this.manifestLigne.getVtelvModeClient() == 1) {
               var4.setFitNomContact(this.manifestLigne.getVtelvContactExp());
            } else {
               var4.setFitNomContact(this.manifestLigne.getVtelvContactDest());
            }

            if (this.manifestLigne.getVtelvCompteClient() != null && !this.manifestLigne.getVtelvCompteClient().isEmpty()) {
               this.tiers = this.tiersDao.chargerTiersByCompte(this.manifestLigne.getVtelvCompteClient(), var6);
            } else {
               this.tiers = this.tiersDao.chargerLesTiers("3", this.manifestLigne.getVtelvIntituleClient(), var6);
            }

            if (this.tiers != null) {
               var4.setFitNomTiers(this.tiers.getTieraisonsocialenom());
               if (this.tiers.getTiegenre() == null || this.tiers.getTiegenre().isEmpty() || !this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
                  var4.setFitNomTiers(this.tiers.getTieraisonsocialenom());
                  var4.setFitCivilTiers("");
               } else {
                  if (this.tiers.getTieprenom() != null && !this.tiers.getTieprenom().isEmpty()) {
                     var4.setFitNomTiers(this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom());
                  } else {
                     var4.setFitNomTiers(this.tiers.getTieraisonsocialenom());
                  }

                  var4.setFitCivilTiers(var4.getTiers().getTiecivilite());
               }

               var4.setFitTiersRegroupe(this.tiers.getTiesigle());
               var4.setFitExoTva(this.manifestLigne.getVtelvExoTva());
               var4.setFitExoDouane(this.tiers.getTieexodouane());
               var4.setFitJournalReg(this.tiers.getTiejournalreg());
               var4.setFitCat(this.manifestLigne.getVtelvCat());
               var4.setFitDevise(this.tiers.getTiedevise());
               var4.setFitIdContact(0L);
               var4.setFitContener("");
               var4.setFitCivilContact("");
               var4.setFitDiversAdresse("");
               var4.setFitDiversMail("");
               var4.setFitDiversNom("");
               var4.setFitDiversTel("");
               var4.setFitDiversTiers(0);
               var4.setFitDiversVille("");
               var4.setFitObject("Transport de " + this.manifestLigne.getManifestEntete().getVtemanLibPortDep() + " à " + this.manifestLigne.getManifestEntete().getVtemanLibPortArr());
               var4.setFitObservation(this.manifestLigne.getVtelvObservation());
               var4.setFitTauxRemise(0.0F);
               var4.setFitTotHt(0.0D);
               var4.setFitTotRemise(0.0D);
               var4.setFitTotRabais(0.0D);
               var4.setFitTotTva(0.0D);
               var4.setFitTotTc(0.0D);
               var4.setFitTotTtc(0.0D);
               var4.setFitTotReglement(0.0D);
               var4.setFitSolde(0);
               var4.setFitBanque(this.tiers.getTienombanque());
               var4.setFitTypeReg(this.tiers.getTietypereg());
               var4.setFitModeReg(this.tiers.getTiemodereg());
               var4.setFitNbJourReg(this.tiers.getTienbecheance());
               var4.setFitArrondiReg(this.tiers.getTienbarrondi());
               var4.setFitConditionReg(this.tiers.getTieconditionreg());
               Date var34 = this.utilDate.CalculDateEcheance(var4.getFitDate(), var4.getFitTypeReg(), var4.getFitNbJourReg(), var4.getFitArrondiReg());
               var4.setFitDateEcheReg(var34);
               var4.setFitContener("");
               var4.setFitActivite(this.manifestLigne.getManifestEntete().getVtemanActivite());
               var4.setFitSite(this.manifestLigne.getManifestEntete().getVtemanSite());
               var4.setFitDepartement(this.manifestLigne.getManifestEntete().getVtemanDepartement());
               var4.setFitService(this.manifestLigne.getManifestEntete().getVtemanService());
               var4.setFitRegion("");
               var4.setFitSecteur("");
               var4.setFitPdv("");
               var4.setFitNumBl(this.manifestLigne.getManifestEntete().getVtemanNumBl());
               var4.setFitAnal2(this.manifestLigne.getManifestEntete().getVtemanRefNavire());
               var4.setFitAnal4(this.manifestLigne.getManifestEntete().getVtemanNum());
               var4.setFitInfo1("");
               var4.setFitInfo2("");
               var4.setFitInfo3("");
               var4.setFitInfo4("");
               var4.setFitInfo5("");
               var4.setFitInfo6("");
               var4.setFitInfo7("");
               var4.setFitInfo8("");
               var4.setFitInfo9("");
               var4.setFitInfo10("");
               var4.setFitFormule1("");
               var4.setFitFormule2("");
               var4.setFitAnnexe1("");
               var4.setFitAnnexe2("");
               var4.setFitContrat("");
               var4.setFitIncoterm("");
               var4.setFitLieuLivraison("");
               var4.setFitDateLivraison((Date)null);
               var4.setFitInfoLivraison("");
               var4.setFitDateImp((Date)null);
               var4.setFitModeleImp(this.var_modele_trf);
               var4.setFitGarde("");
               var4.setFitGele(0);
               var4.setFitEtat(1);
               var4.setFitDateTransforme((Date)null);
               var4.setFitTypeTransforme(0);
               var4.setFitDateAnnule((Date)null);
               var4.setFitMotifAnnule("");
               var4.setFitFactorNom("");
               var4.setFitFactorId(0L);
               var4.setFitFactorEtat(0);
               var4.setExerciceventes(this.exercicesVentes);
               var4.setTiers(this.tiers);
               var4.setUsers(this.usersLog);
               var4 = var1.insert(var4, var6);
               double var12 = 0.0D;
               double var14 = 0.0D;
               double var16 = 0.0D;
               double var18 = 0.0D;
               double var20 = 0.0D;
               double var22 = 0.0D;
               int var24 = 0;
               String var25 = "";
               var5.clear();
               var5 = this.manifestLigneDao.chargerLesLignesByLv(this.manifestEntete, this.manifestLigne.getVtelvNum(), var6);
               if (var5.size() != 0) {
                  int var26 = 0;

                  while(true) {
                     if (var26 >= var5.size()) {
                        var4.setFitContener(var25);
                        var4.setFitTotHt(var12);
                        var4.setFitTotRemise(var14);
                        var4.setFitTotRabais(var16);
                        var4.setFitTotTva(var18);
                        var4.setFitTotTc(var22);
                        var4.setFitTotTtc(var20);
                        var4 = var1.modif(var4, var6);
                        break;
                     }

                     this.manifestLigne = (ManifestLigne)var5.get(var26);
                     new ArrayList();
                     List var27 = this.manifestProduitDao.chargerLesLignes(this.manifestLigne, var6);

                     for(int var28 = 0; var28 < var27.size(); ++var28) {
                        this.manifestProduit = (ManifestProduit)var27.get(var28);
                        if (this.manifestProduit.getVteprdImmaTc1() != null && !this.manifestProduit.getVteprdImmaTc1().isEmpty()) {
                           if (var25 != null && !var25.isEmpty()) {
                              var25 = var25 + "," + this.manifestProduit.getVteprdImmaTc1();
                           } else {
                              var25 = this.manifestProduit.getVteprdImmaTc1();
                           }
                        }

                        if (this.manifestProduit.getVteprdImmaTc2() != null && !this.manifestProduit.getVteprdImmaTc2().isEmpty()) {
                           if (var25 != null && !var25.isEmpty()) {
                              var25 = var25 + "," + this.manifestProduit.getVteprdImmaTc2();
                           } else {
                              var25 = this.manifestProduit.getVteprdImmaTc2();
                           }
                        }

                        FactureInterneLigneVentes var29 = new FactureInterneLigneVentes();
                        ++var24;
                        var29.setFitligOrdre(var24);
                        var29.setFitligCode(this.manifestProduit.getVteprdRefTypeColis());
                        if (this.manifestProduit.getVteprdRefTypeColis() != null && !this.manifestProduit.getVteprdRefTypeColis().isEmpty()) {
                           this.produits = this.produitsVtesDao.chargeProduit(this.manifestProduit.getVteprdRefTypeColis(), var6);
                           var29.setFitligFamille(this.produits.getProVteCode());
                        } else {
                           var29.setFitligFamille("");
                        }

                        var29.setFitligLibelle("Transport " + this.manifestProduit.getVteprdLibTypeColis());
                        var29.setFitligGroupe("");
                        var29.setFitligModeGroupe(0);
                        var29.setFitligDevise(var4.getFitDevise());
                        var29.setFitligIdBlv(this.manifestProduit.getVteprdId());
                        var29.setFitligComplement(this.manifestProduit.getVteprdNatureColis());
                        var29.setFitligDepot("");
                        var29.setFitligEchelle(0);
                        var29.setFitligUnite("");
                        var29.setFitligCondition("");
                        var29.setFitligStock(0);
                        var29.setFitligReference(this.manifestProduit.getVteprdNum());
                        var29.setFitligPump(0.0D);
                        var29.setFitligPu(this.manifestProduit.getVteprdPu());
                        var29.setFitligPuTtc(0.0D);
                        var29.setFitligTauxRemise(this.manifestProduit.getVteprdRemise());
                        var29.setFitligPuRem(this.manifestProduit.getVteprdPuRem());
                        var29.setFitligPuRemTtc(0.0D);
                        var29.setFitligLong(0.0F);
                        var29.setFitligLarg(0.0F);
                        var29.setFitligHaut(0.0F);
                        var29.setFitligDiam(0.0F);
                        var29.setFitligPoidsBrut(this.manifestProduit.getVteprdPoids());
                        var29.setFitligPoidsNet(0.0F);
                        var29.setFitligVolume(this.manifestProduit.getVteprdVolume());
                        var29.setFitligNb((float)this.manifestProduit.getVteprdNbreColis());
                        float var30 = 0.0F;
                        if (this.manifestProduit.getVteprdModeFactureDetail() != 2 && this.manifestProduit.getVteprdModeFactureDetail() != 3 && this.manifestProduit.getVteprdModeFactureDetail() != 4) {
                           if (this.manifestProduit.getVteprdModeFactureDetail() == 1) {
                              if (this.manifestProduit.getVteprdPoids() / 1000.0F >= this.manifestProduit.getVteprdVolume()) {
                                 var30 = this.manifestProduit.getVteprdPoids() / 1000.0F;
                              } else {
                                 var30 = this.manifestProduit.getVteprdVolume();
                              }
                           }
                        } else {
                           var30 = (float)this.manifestProduit.getVteprdNbreColis();
                        }

                        var29.setFitligQte(var30);
                        var29.setFitligQteUtil(var30);
                        var29.setFitligQteStock(0.0F);
                        var29.setFitligRabais(0.0D);
                        var29.setFitligTauxTaxe(this.manifestProduit.getVteprdTauxTva());
                        var29.setFitligTaxe(this.manifestProduit.getVteprdCodeTva());
                        var29.setFitligPt(this.manifestProduit.getVteprdTotalHt());
                        var29.setFitligTva(this.manifestProduit.getVteprdTotalTva());
                        var29.setFitligTtc(this.manifestProduit.getVteprdTotalTtc());
                        var29.setFitligTc(this.manifestProduit.getVteprdTc());
                        var29.setFactureInterneEnteteVentes(var4);
                        var29 = var2.insertLigne(var29, var6);
                        var3.add(var29);
                        var12 += var29.getFitligPt();
                        var14 += (var29.getFitligPu() - var29.getFitligPuRem()) * (double)var29.getFitligQte();
                        var18 += var29.getFitligTva();
                        var20 += var29.getFitligTtc();
                        var22 += var29.getFitligTc();
                     }

                     this.manifestLigne.setVtelvNumFacture(var4.getFitNum());
                     this.manifestLigne = this.manifestLigneDao.modifLigne(this.manifestLigne, var6);
                     ++var26;
                  }
               }

               this.manifestEntete = this.manifestEnteteDao.pourParapheur(this.manifestEntete.getVtemanId(), var6);
               if (this.manifestEntete != null) {
                  this.manifestEntete.setVtemanEtat(4);
                  this.manifestEntete = this.manifestEnteteDao.modif(this.manifestEntete, var6);
               }

               double var35 = this.utilNombre.myRound(var4.getFitTotTtc() + var4.getFitTotTc(), 0);
               this.utilNombre.begin(var35, this.structureLog.getStrdevise());
               this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationFacInt(var4, var6), var4.getFitId(), var4.getFitNum(), var4.getFitNomTiers(), var4.getFitDate(), var4.getFitDevise(), var4.getFitTotTtc() + var4.getFitTotTc(), var4.getFitModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 142), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFFACINT(var3, var4), this.calculeParc(var6), var4.getVar_format_devise(), 0, var6);
               if (this.optionsVentes.getAxeDossier().equals("2") && var4.getFitAnal4() != null && !var4.getFitAnal4().isEmpty()) {
                  PlansAnalytiquesDao var36 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
                  this.plansAnalytiques = var36.rechercheAffaire(var4.getFitAnal4(), var6);
                  if (this.plansAnalytiques != null) {
                     this.plansAnalytiques.setAnaCode(var4.getFitAnal4());
                     this.plansAnalytiques.setAnaNomFr(var4.getFitObject());
                     this.plansAnalytiques.setAnaAffaireDateFacture(var4.getFitDate());
                     this.plansAnalytiques = var36.modif(this.plansAnalytiques, var6);
                  }
               }
            }
         }
      }

   }

   public void generationFactureGroupeDevis(FactureInterneEnteteVentesDao var1, FactureInterneLigneVentesDao var2, List var3, FactureInterneEnteteVentes var4, DevisEnteteVentes var5, DevisEnteteVentesDao var6, DevisLigneVentesDao var7, DevisLigneVentes var8, List var9, Session var10) throws HibernateException, NamingException, ParseException, Exception {
      boolean var11 = false;
      this.tiers = null;
      if (this.manifestLigne.getVtelvNumFacture() != null && !this.manifestLigne.getVtelvNumFacture().isEmpty()) {
         var4 = var1.pourParapheur(this.manifestLigne.getVtelvNumFacture(), var10);
         if (var4 != null) {
            if (var4.getFitDateTransfert() == null) {
               this.nettoyageLigneFactureInterne(var2, var4, var10);
               this.tiers = var4.getTiers();
               var11 = true;
            }
         } else {
            var4 = new FactureInterneEnteteVentes();
            var11 = true;
         }
      } else {
         var4 = new FactureInterneEnteteVentes();
         var11 = true;
      }

      if (var11) {
         if (this.var_serie_trf != null && !this.var_serie_trf.isEmpty()) {
            var4.setFitSerie(this.var_serie_trf);
         } else {
            var4.setFitSerie(var5.getDvsSerie());
         }

         var4.setUsers(this.usersLog);
         var4.setFitIdCreateur(this.usersLog.getUsrid());
         var4.setFitNomCreateur(this.usersLog.getUsrNom() + " " + this.usersLog.getUsrPrenom());
         if (this.var_date_trf == null) {
            var4.setFitDate(var5.getDvsDate());
         } else {
            var4.setFitDate(this.var_date_trf);
         }

         var4.setFitDateCreat(new Date());
         var4.setFitDateModif((Date)null);
         var4.setFitIdModif(0L);
         var4.setFitNomModif("");
         var4.setFitNum("");
         var4.setFitNumBl("");
         boolean var12 = false;
         int var34;
         if (this.optionsVentes.getNbrJrRelanceFAC() != null && !this.optionsVentes.getNbrJrRelanceFAC().isEmpty()) {
            var34 = Integer.parseInt(this.optionsVentes.getNbrJrRelanceFAC());
         } else {
            var34 = 0;
         }

         boolean var13 = false;
         int var35;
         if (this.optionsVentes.getNbrJrValidFAC() != null && !this.optionsVentes.getNbrJrValidFAC().isEmpty()) {
            var35 = Integer.parseInt(this.optionsVentes.getNbrJrValidFAC());
         } else {
            var35 = 0;
         }

         var4.setFitDateRelance(this.utilDate.datedevaleurTheo(this.var_date, var34));
         var4.setFitDateValidite(this.utilDate.datedevaleurTheo(this.var_date, var35));
         boolean var14 = true;
         if (!var4.getFitSerie().equalsIgnoreCase("X") && !var4.getFitSerie().isEmpty()) {
            var4.setFitNum(this.calculChrono.numCompose(var4.getFitDate(), this.var_type_trf, var4.getFitSerie(), var10));
         } else {
            long var15 = this.factureEnteteVentesDao.selectLastNum(var10);
            var4.setFitNum("" + var15);
         }

         if (var14) {
            this.verifieExistenceHabilitationFacInt(var4, var10);
            var4.setFitSource((String)null);
            var4.setFitNomResponsable(var5.getDvsNomResponsable());
            var4.setFitIdResponsable(var5.getDvsIdResponsable());
            var4.setFitNomCommercial(var5.getDvsNomCommercial());
            var4.setFitIdCommercial(var5.getDvsIdCommercial());
            var4.setFitNomEquipe(var5.getDvsNomEquipe());
            var4.setFitIdEquipe(var5.getDvsIdEquipe());
            var4.setFitNomContact(var5.getDvsNomContact());
            this.tiers = var5.getTiers();
            if (this.tiers != null) {
               var4.setFitNomTiers(this.tiers.getTieraisonsocialenom());
               if (this.tiers.getTiegenre() != null && !this.tiers.getTiegenre().isEmpty() && (this.tiers.getTiegenre().equalsIgnoreCase("010") || this.tiers.getTiegenre().equalsIgnoreCase("020") || this.tiers.getTiegenre().equalsIgnoreCase("030") || this.tiers.getTiegenre().equalsIgnoreCase("037"))) {
                  if (this.tiers.getTieprenom() != null && !this.tiers.getTieprenom().isEmpty()) {
                     var4.setFitNomTiers(this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom());
                  } else {
                     var4.setFitNomTiers(this.tiers.getTieraisonsocialenom());
                  }

                  var4.setFitCivilTiers(var4.getTiers().getTiecivilite());
               } else {
                  var4.setFitNomTiers(this.tiers.getTieraisonsocialenom());
                  var4.setFitCivilTiers("");
               }

               var4.setFitTiersRegroupe(this.tiers.getTiesigle());
               var4.setFitExoTva(var5.getDvsExoTva());
               var4.setFitExoDouane(this.tiers.getTieexodouane());
               var4.setFitJournalReg(this.tiers.getTiejournalreg());
               var4.setFitCat(var5.getDvsCat());
               var4.setFitDevise(this.tiers.getTiedevise());
               var4.setFitIdContact(0L);
               var4.setFitContener("");
               var4.setFitCivilContact("");
               var4.setFitDiversAdresse("");
               var4.setFitDiversMail("");
               var4.setFitDiversNom("");
               var4.setFitDiversTel("");
               var4.setFitDiversTiers(0);
               var4.setFitDiversVille("");
               var4.setFitObject("Transport de " + this.manifestLigne.getManifestEntete().getVtemanLibPortDep() + " à " + this.manifestLigne.getManifestEntete().getVtemanLibPortArr());
               var4.setFitObservation(var5.getDvsObservation());
               var4.setFitTauxRemise(0.0F);
               var4.setFitTotHt(0.0D);
               var4.setFitTotRemise(0.0D);
               var4.setFitTotRabais(0.0D);
               var4.setFitTotTva(0.0D);
               var4.setFitTotTc(0.0D);
               var4.setFitTotTtc(0.0D);
               var4.setFitTotReglement(0.0D);
               var4.setFitSolde(0);
               var4.setFitBanque(this.tiers.getTienombanque());
               var4.setFitTypeReg(this.tiers.getTietypereg());
               var4.setFitModeReg(this.tiers.getTiemodereg());
               var4.setFitNbJourReg(this.tiers.getTienbecheance());
               var4.setFitArrondiReg(this.tiers.getTienbarrondi());
               var4.setFitConditionReg(this.tiers.getTieconditionreg());
               Date var36 = this.utilDate.CalculDateEcheance(var4.getFitDate(), var4.getFitTypeReg(), var4.getFitNbJourReg(), var4.getFitArrondiReg());
               var4.setFitDateEcheReg(var36);
               var4.setFitContener("");
               var4.setFitActivite(var5.getDvsActivite());
               var4.setFitSite(var5.getDvsSite());
               var4.setFitDepartement(var5.getDvsDepartement());
               var4.setFitService(var5.getDvsService());
               var4.setFitRegion("");
               var4.setFitSecteur("");
               var4.setFitPdv("");
               var4.setFitNumBl(this.manifestLigne.getManifestEntete().getVtemanNumBl());
               var4.setFitAnal2("");
               var4.setFitAnal4(this.manifestEntete.getVtemanNum());
               var4.setFitInfo1("");
               var4.setFitInfo2("");
               var4.setFitInfo3("");
               var4.setFitInfo4("");
               var4.setFitInfo5("");
               var4.setFitInfo6("");
               var4.setFitInfo7("");
               var4.setFitInfo8("");
               var4.setFitInfo9("");
               var4.setFitInfo10("");
               var4.setFitFormule1("");
               var4.setFitFormule2("");
               var4.setFitAnnexe1("");
               var4.setFitAnnexe2("");
               var4.setFitContrat("");
               var4.setFitIncoterm("");
               var4.setFitLieuLivraison("");
               var4.setFitDateLivraison((Date)null);
               var4.setFitInfoLivraison("");
               var4.setFitDateImp((Date)null);
               var4.setFitModeleImp(this.var_modele_trf);
               var4.setFitGarde("");
               var4.setFitGele(0);
               var4.setFitEtat(1);
               var4.setFitDateTransforme((Date)null);
               var4.setFitTypeTransforme(0);
               var4.setFitDateAnnule((Date)null);
               var4.setFitMotifAnnule("");
               var4.setFitFactorNom("");
               var4.setFitFactorId(0L);
               var4.setFitFactorEtat(0);
               var4.setExerciceventes(this.exercicesVentes);
               var4.setTiers(this.tiers);
               var4.setUsers(this.usersLog);
               var4 = var1.insert(var4, var10);
               double var16 = 0.0D;
               double var18 = 0.0D;
               double var20 = 0.0D;
               double var22 = 0.0D;
               double var24 = 0.0D;
               double var26 = 0.0D;
               int var28 = 0;
               String var29 = "";
               var9.clear();
               var9 = var7.chargerLesLignes(var5, var10);
               if (var9.size() != 0) {
                  int var30 = 0;

                  while(true) {
                     if (var30 >= var9.size()) {
                        var4.setFitContener(var29);
                        var4.setFitTotHt(var16);
                        var4.setFitTotRemise(var18);
                        var4.setFitTotRabais(var20);
                        var4.setFitTotTva(var22);
                        var4.setFitTotTc(var26);
                        var4.setFitTotTtc(var24);
                        var4 = var1.modif(var4, var10);
                        var5.setDvsEtat(5);
                        var6.modif(var5, var10);
                        break;
                     }

                     var8 = (DevisLigneVentes)var9.get(var30);
                     FactureInterneLigneVentes var31 = new FactureInterneLigneVentes();
                     ++var28;
                     var31.setFitligOrdre(var28);
                     var31.setFitligCode(var8.getDvsligCode());
                     if (var8.getDvsligCode() != null && !var8.getDvsligCode().isEmpty()) {
                        this.produits = this.produitsVtesDao.chargeProduit(var8.getDvsligCode(), var10);
                        var31.setFitligFamille(this.produits.getProVteCode());
                     } else {
                        var31.setFitligFamille("");
                     }

                     var31.setFitligLibelle("Transport " + var8.getDvsligLibelle());
                     var31.setFitligGroupe("");
                     var31.setFitligModeGroupe(0);
                     var31.setFitligDevise(var4.getFitDevise());
                     var31.setFitligIdDvs(var8.getDvsligId());
                     var31.setFitligIdBlv(0L);
                     var31.setFitligComplement(var8.getDvsligComplement());
                     var31.setFitligDepot("");
                     var31.setFitligEchelle(0);
                     var31.setFitligUnite("");
                     var31.setFitligCondition("");
                     var31.setFitligStock(0);
                     var31.setFitligReference(var8.getDvsligReference());
                     var31.setFitligPump(0.0D);
                     var31.setFitligPu(var8.getDvsligPu());
                     var31.setFitligPuTtc(0.0D);
                     var31.setFitligTauxRemise(var8.getDvsligTauxRemise());
                     var31.setFitligPuRem(var8.getDvsligPuRem());
                     var31.setFitligPuRemTtc(0.0D);
                     var31.setFitligLong(0.0F);
                     var31.setFitligLarg(0.0F);
                     var31.setFitligHaut(0.0F);
                     var31.setFitligDiam(0.0F);
                     var31.setFitligPoidsBrut(var8.getDvsligPoidsBrut());
                     var31.setFitligPoidsNet(0.0F);
                     var31.setFitligVolume(var8.getDvsligVolume());
                     var31.setFitligNb(var8.getDvsligNb());
                     var31.setFitligQte(var8.getDvsligQte());
                     var31.setFitligQteUtil(var8.getDvsligQteUtil());
                     var31.setFitligQteStock(0.0F);
                     var31.setFitligRabais(0.0D);
                     var31.setFitligTauxTaxe(var8.getDvsligTauxTaxe());
                     var31.setFitligTaxe(var8.getDvsligTaxe());
                     var31.setFitligPt(var8.getDvsligPt());
                     var31.setFitligTva(var8.getDvsligTva());
                     var31.setFitligTtc(var8.getDvsligTtc());
                     var31.setFitligTc(var8.getDvsligTc());
                     var31.setFactureInterneEnteteVentes(var4);
                     var31 = var2.insertLigne(var31, var10);
                     var3.add(var31);
                     var16 += var31.getFitligPt();
                     var18 += (var31.getFitligPu() - var31.getFitligPuRem()) * (double)var31.getFitligQte();
                     var22 += var31.getFitligTva();
                     var24 += var31.getFitligTtc();
                     var26 += var31.getFitligTc();
                     this.manifestLigne.setVtelvNumFacture(var4.getFitNum());
                     this.manifestLigne = this.manifestLigneDao.modifLigne(this.manifestLigne, var10);
                     ++var30;
                  }
               }

               this.manifestEntete = this.manifestEnteteDao.pourParapheur(this.manifestEntete.getVtemanId(), var10);
               if (this.manifestEntete != null) {
                  this.manifestEntete.setVtemanEtat(4);
                  this.manifestEntete = this.manifestEnteteDao.modif(this.manifestEntete, var10);
               }

               double var37 = this.utilNombre.myRound(var4.getFitTotTtc() + var4.getFitTotTc(), 0);
               this.utilNombre.begin(var37, this.structureLog.getStrdevise());
               this.utilParapheur.majParapheur(this.var_type_trf, this.verifieExistenceHabilitationFacInt(var4, var10), var4.getFitId(), var4.getFitNum(), var4.getFitNomTiers(), var4.getFitDate(), var4.getFitDevise(), var4.getFitTotTtc() + var4.getFitTotTc(), var4.getFitModeleImp(), this.tiers, this.calculeCheminRapport(this.baseLog, 142), this.calculeCheminSousRapport(this.baseLog), this.calculeImpressionTRFFACINT(var3, var4), this.calculeParc(var10), var4.getVar_format_devise(), 0, var10);
               if (this.optionsVentes.getAxeDossier().equals("2") && var4.getFitAnal4() != null && !var4.getFitAnal4().isEmpty()) {
                  PlansAnalytiquesDao var33 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
                  this.plansAnalytiques = var33.rechercheAffaire(var4.getFitAnal4(), var10);
                  if (this.plansAnalytiques != null) {
                     this.plansAnalytiques.setAnaCode(var4.getFitAnal4());
                     this.plansAnalytiques.setAnaNomFr(var4.getFitObject());
                     this.plansAnalytiques.setAnaAffaireDateFacture(var4.getFitDate());
                     this.plansAnalytiques = var33.modif(this.plansAnalytiques, var10);
                  }
               }
            }
         }
      }

   }

   public void nettoyageLigneFactureInterne(FactureInterneLigneVentesDao var1, FactureInterneEnteteVentes var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      List var4 = var1.chargerLesLignes(var2, var3);
      if (var4.size() != 0) {
         var1.deleteAllLigne(var2, var3);
      }

   }

   public void nettoyageLigneFacture(FactureLigneVentesDao var1, FactureEnteteVentes var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      List var4 = var1.chargerLesLignes(var2, var3);
      if (var4.size() != 0) {
         var1.deleteAllLigne(var2, var3);
      }

   }

   public JRBeanCollectionDataSource calculeImpressionTRFFAC(List var1, FactureEnteteVentes var2) throws IOException {
      ArrayList var3 = new ArrayList();
      if (var1.size() != 0) {
         new FactureLigneVentes();
         boolean var5 = false;
         String var6 = "";
         double var7 = 0.0D;
         double var9 = 0.0D;

         for(int var11 = 0; var11 < var1.size(); ++var11) {
            FactureLigneVentes var4 = (FactureLigneVentes)var1.get(var11);
            if (var4.getFacligModeGroupe() != 2 || var4.getFacligGroupe() == null || var4.getFacligGroupe().isEmpty()) {
               if (var4.getFacligCode() != null && !var4.getFacligCode().isEmpty() && var4.getFacligCode().equals("-")) {
                  var5 = true;
                  var6 = var4.getFacligLibelle();
               }

               if (var5) {
                  var7 += var4.getFacligPt();
                  var9 = var4.getFacligTtc();
               }

               if (var4.getFacligCode() != null && !var4.getFacligCode().isEmpty() && var4.getFacligCode().equals("=") && var5) {
                  var4 = new FactureLigneVentes();
                  var4.setFactureEnteteVentes(var2);
                  var4.setFacligCode("=");
                  var4.setFacligLibelle(var6);
                  var4.setFacligPt(var7);
                  var4.setFacligTtc(var9);
                  var3.add(var4);
                  var7 = 0.0D;
                  var9 = 0.0D;
                  var5 = false;
               } else {
                  var3.add(var4);
               }
            }
         }
      }

      String var12 = this.utilNombre.begin(var2.getFacTotTtc() + var2.getFacTotTc(), var2.getFacDevise());
      JRBeanCollectionDataSource var13 = new JRBeanCollectionDataSource(var3);
      return var13;
   }

   public Habilitation verifieExistenceHabilitationFac(FactureEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      HabilitationDao var3 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      Habilitation var4 = var3.existenceHabilitation(this.var_type_trf, var2);
      if (var4 != null) {
         var1.setFacEtatVal(1);
         var1.setFacEtat(0);
         var1.setFacDateValide((Date)null);
      } else {
         var1.setFacEtatVal(0);
         if (var1.getFacDateImp() != null) {
            if (var1.getFacEtat() == 0) {
               var1.setFacEtat(1);
               var1.setFacDateValide(new Date());
            }
         } else {
            var1.setFacEtat(0);
            var1.setFacDateValide((Date)null);
         }
      }

      return var4;
   }

   public JRBeanCollectionDataSource calculeImpressionTRFFACINT(List var1, FactureInterneEnteteVentes var2) throws IOException {
      ArrayList var3 = new ArrayList();
      if (var1.size() != 0) {
         new FactureInterneLigneVentes();
         boolean var5 = false;
         String var6 = "";
         double var7 = 0.0D;
         double var9 = 0.0D;

         for(int var11 = 0; var11 < var1.size(); ++var11) {
            FactureInterneLigneVentes var4 = (FactureInterneLigneVentes)var1.get(var11);
            if (var4.getFitligModeGroupe() != 2 || var4.getFitligGroupe() == null || var4.getFitligGroupe().isEmpty()) {
               if (var4.getFitligCode() != null && !var4.getFitligCode().isEmpty() && var4.getFitligCode().equals("-")) {
                  var5 = true;
                  var6 = var4.getFitligLibelle();
               }

               if (var5) {
                  var7 += var4.getFitligPt();
                  var9 = var4.getFitligTtc();
               }

               if (var4.getFitligCode() != null && !var4.getFitligCode().isEmpty() && var4.getFitligCode().equals("=") && var5) {
                  var4 = new FactureInterneLigneVentes();
                  var4.setFactureInterneEnteteVentes(var2);
                  var4.setFitligCode("=");
                  var4.setFitligLibelle(var6);
                  var4.setFitligPt(var7);
                  var4.setFitligTtc(var9);
                  var3.add(var4);
                  var7 = 0.0D;
                  var9 = 0.0D;
                  var5 = false;
               } else {
                  var3.add(var4);
               }
            }
         }
      }

      String var12 = this.utilNombre.begin(var2.getFitTotTtc() + var2.getFitTotTc(), var2.getFitDevise());
      JRBeanCollectionDataSource var13 = new JRBeanCollectionDataSource(var3);
      return var13;
   }

   public Habilitation verifieExistenceHabilitationFacInt(FactureInterneEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      HabilitationDao var3 = new HabilitationDao(this.baseLog, this.utilInitHibernate);
      Habilitation var4 = var3.existenceHabilitation(this.var_type_trf, var2);
      if (var4 != null) {
         var1.setFitEtatVal(1);
         var1.setFitEtat(0);
         var1.setFitDateValide((Date)null);
      } else {
         var1.setFitEtatVal(0);
         if (var1.getFitDateImp() != null) {
            if (var1.getFitEtat() == 0) {
               var1.setFitEtat(1);
               var1.setFitDateValide(new Date());
            }
         } else {
            var1.setFitEtat(0);
            var1.setFitDateValide((Date)null);
         }
      }

      return var4;
   }

   public String calculeCheminRapport(String var1, int var2) {
      String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document" + File.separator + "manifest" + File.separator;
      return var3;
   }

   public String calculeCheminRapportLV(String var1, int var2) {
      String var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "document" + File.separator + "lettre_voiture" + File.separator;
      return var3;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "sous_rapport" + File.separator;
      return var2;
   }

   public String calculeCheminImageProduit(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "photos" + File.separator + "produits" + File.separator + "photo" + File.separator;
      return var2;
   }

   public String calculeImageFond(String var1, int var2) throws HibernateException, NamingException {
      String var3 = "";
      File var4;
      if (var2 == 0) {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatEncours.jpg");
         if (var4.exists()) {
            var3 = "formatEncours.jpg";
         } else {
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatManifest.jpg");
            if (var4.exists()) {
               var3 = "formatManifest.jpg";
            }
         }
      } else if (var2 == 20) {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatParapheur.jpg");
         if (var4.exists()) {
            var3 = "formatParapheur.jpg";
         }
      } else if (var2 == 30) {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatCaisse.jpg");
         if (var4.exists()) {
            var3 = "formatCaisse.jpg";
         }
      } else {
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatManifest.jpg");
         if (var4.exists()) {
            var3 = "formatManifest.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException, HibernateException, NamingException {
      JRBeanCollectionDataSource var1 = new JRBeanCollectionDataSource(this.calculeImpressionListe());
      return var1;
   }

   public List calculeImpressionListe() throws IOException, HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      if (this.lesLignesList.size() != 0) {
         for(int var2 = 0; var2 < this.lesLignesList.size(); ++var2) {
            this.manifestLigne = (ManifestLigne)this.lesLignesList.get(var2);
            new ArrayList();
            List var3 = this.manifestProduitDao.chargerLesLignes(this.manifestLigne, (Session)null);
            if (var3.size() != 0) {
               for(int var4 = 0; var4 < var3.size(); ++var4) {
                  this.manifestLigne.setNomProduit(((ManifestProduit)var3.get(var4)).getVteprdLibTypeColis());
                  this.manifestLigne.setNumContener(((ManifestProduit)var3.get(var4)).getVteprdImmaTc1());
                  this.manifestLigne.setNumPlomb(((ManifestProduit)var3.get(var4)).getVteprdPlombTc1());
                  this.manifestLigne.setNombre(((ManifestProduit)var3.get(var4)).getVteprdNbreColis());
                  this.manifestLigne.setPoids(((ManifestProduit)var3.get(var4)).getVteprdPoids());
                  this.manifestLigne.setVolume(((ManifestProduit)var3.get(var4)).getVteprdVolume());
                  var1.add(this.manifestLigne);
                  if (((ManifestProduit)var3.get(var4)).getVteprdImmaTc2() != null && !((ManifestProduit)var3.get(var4)).getVteprdImmaTc2().isEmpty()) {
                     this.manifestLigne.setNomProduit(((ManifestProduit)var3.get(var4)).getVteprdLibTypeColis());
                     this.manifestLigne.setNumContener(((ManifestProduit)var3.get(var4)).getVteprdImmaTc2());
                     this.manifestLigne.setNumPlomb(((ManifestProduit)var3.get(var4)).getVteprdPlombTc2());
                     this.manifestLigne.setNombre(0);
                     this.manifestLigne.setPoids(0.0F);
                     this.manifestLigne.setVolume(0.0F);
                     var1.add(this.manifestLigne);
                  }
               }
            }
         }
      }

      this.infoOrigineDoc = this.manifestEntete.getVtemanNum();
      return var1;
   }

   public JRBeanCollectionDataSource calculeImpressionCommunLV() throws IOException, HibernateException, NamingException {
      JRBeanCollectionDataSource var1 = new JRBeanCollectionDataSource(this.calculeImpressionListeLV());
      return var1;
   }

   public List calculeImpressionListeLV() throws IOException, HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      if (this.manifestEntete != null) {
         new ArrayList();
         List var2 = this.manifestLigneDao.chargerLesLignes(this.manifestEntete, (Session)null);
         if (var2.size() != 0) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               this.manifestLigne = (ManifestLigne)var2.get(var3);
               new ArrayList();
               List var4 = this.manifestProduitDao.chargerLesLignes(this.manifestLigne, (Session)null);
               if (var4.size() != 0) {
                  for(int var5 = 0; var5 < var4.size(); ++var5) {
                     this.manifestLigne.setNomProduit(((ManifestProduit)var4.get(var5)).getVteprdLibTypeColis());
                     this.manifestLigne.setNumContener(((ManifestProduit)var4.get(var5)).getVteprdImmaTc1());
                     this.manifestLigne.setNumPlomb(((ManifestProduit)var4.get(var5)).getVteprdPlombTc1());
                     this.manifestLigne.setNombre(((ManifestProduit)var4.get(var5)).getVteprdNbreColis());
                     this.manifestLigne.setPoids(((ManifestProduit)var4.get(var5)).getVteprdPoids());
                     this.manifestLigne.setVolume(((ManifestProduit)var4.get(var5)).getVteprdVolume());
                     var1.add(this.manifestLigne);
                     if (((ManifestProduit)var4.get(var5)).getVteprdImmaTc2() != null && !((ManifestProduit)var4.get(var5)).getVteprdImmaTc2().isEmpty()) {
                        this.manifestLigne.setNomProduit(((ManifestProduit)var4.get(var5)).getVteprdLibTypeColis());
                        this.manifestLigne.setNumContener(((ManifestProduit)var4.get(var5)).getVteprdImmaTc2());
                        this.manifestLigne.setNumPlomb(((ManifestProduit)var4.get(var5)).getVteprdPlombTc2());
                        this.manifestLigne.setNombre(0);
                        this.manifestLigne.setPoids(0.0F);
                        this.manifestLigne.setVolume(0.0F);
                        var1.add(this.manifestLigne);
                     }
                  }
               }
            }
         }

         this.infoOrigineDoc = this.manifestEntete.getVtemanNum();
      }

      return var1;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      return var2;
   }

   public boolean majDateImpression(String var1) throws HibernateException, NamingException, ParseException {
      boolean var2 = false;
      boolean var3 = false;
      Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureLigne");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();
         if (this.manifestEntete.getVtemanDateImp() != null && this.manifestEntete.getVtemanEtat() != 0) {
            var3 = true;
         }

         var5.commit();
      } catch (HibernateException var10) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      if (var2) {
         this.chargerDocumentLigne((Session)null);
      }

      return var3;
   }

   public void impression(UtilPrint var1, int var2, int var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      boolean var12;
      if (var2 == 0) {
         if (var4 != null && !var4.isEmpty()) {
            var12 = this.majDateImpression(var4);
            var1.setjRBeanCollectionDataSource(this.calculeImpressionCommun());
            var1.setRapport(var4);
            var1.setEntete("Impression manifest");
            var1.setCheminRapport(this.calculeCheminRapport("structure" + this.structureLog.getStrid(), this.nature));
            var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
            var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.manifestEntete.getVtemanEtat()));
            var1.setDuplicata("" + var12);
            var1.setInfoOrigineDoc(this.infoOrigineDoc);
            var1.setNbDecQte(this.optionsVentes.getNbDecQte());
            var1.setNbDecPu(this.optionsVentes.getNbDecPu());
            var1.setMontant_lettre("");
            var1.setFormat(var6);
            var1.setEmetteur(var7);
            var1.setDestinataire(var8);
            var1.setDestinataireCC(var9);
            var1.setDestinataireCCI(var10);
            var1.setCorpsMail(var11);
            var1.setIdResponsable(this.manifestEntete.getVtemanIdResponsable());
            var1.setIdCommercial(this.manifestEntete.getVtemanIdCommercial());
            var1.setTiersSelectionne((Tiers)null);
            var1.setContact((Contacts)null);
            var1.setNumDoc(this.manifestEntete.getVtemanNum());
            var1.setNature(this.nature);
            var1.setId_doc(this.manifestEntete.getVtemanId());
            var1.setPoidsImp(var3);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
            this.chargerDocumentLigne((Session)null);
         }
      } else if (var2 == 1) {
         if (var5 != null && !var5.isEmpty()) {
            var1.setRapport(var5);
            var1.setEntete("Impression de la liste des manifests");
            var1.setCheminRapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "liste" + File.separator + "manifest" + File.separator);
            var1.setCheminSousrapport(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "impression" + File.separator + "fr" + File.separator + "parcs" + File.separator + "sous_rapport" + File.separator);
            var1.setFormat(var6);
            var1.setEmetteur(var7);
            var1.setDestinataire(var8);
            var1.setDestinataireCC(var9);
            var1.setDestinataireCCI(var10);
            var1.setCorpsMail(var11);
            var1.setIdResponsable(0L);
            var1.setTiersSelectionne((Tiers)null);
            var1.setNature(this.getNature());
            var1.setId_doc(0L);
            JRBeanCollectionDataSource var13 = new JRBeanCollectionDataSource(this.lesEntetesList);
            var1.setjRBeanCollectionDataSource(var13);
            var1.setBaseLog(this.baseLog);
            var1.setStructureLog(this.structureLog);
            var1.setUsersLog(this.usersLog);
            var1.imprimeRapport();
         }
      } else if (var2 == 2 && var4 != null && !var4.isEmpty()) {
         var12 = this.majDateImpression(var4);
         var1.setjRBeanCollectionDataSource(this.calculeImpressionCommunLV());
         var1.setRapport(var4);
         var1.setEntete("Impression lettres de voiture");
         var1.setCheminRapport(this.calculeCheminRapportLV("structure" + this.structureLog.getStrid(), this.nature));
         var1.setCheminSousrapport(this.calculeCheminSousRapport("structure" + this.structureLog.getStrid()));
         var1.setImageFondPage(this.calculeImageFond("structure" + this.structureLog.getStrid(), this.manifestEntete.getVtemanEtat()));
         var1.setDuplicata("" + var12);
         var1.setInfoOrigineDoc(this.infoOrigineDoc);
         var1.setNbDecQte(this.optionsVentes.getNbDecQte());
         var1.setNbDecPu(this.optionsVentes.getNbDecPu());
         var1.setMontant_lettre("");
         var1.setFormat(var6);
         var1.setEmetteur(var7);
         var1.setDestinataire(var8);
         var1.setDestinataireCC(var9);
         var1.setDestinataireCCI(var10);
         var1.setCorpsMail(var11);
         var1.setIdResponsable(this.manifestEntete.getVtemanIdResponsable());
         var1.setIdCommercial(this.manifestEntete.getVtemanIdCommercial());
         var1.setTiersSelectionne((Tiers)null);
         var1.setContact((Contacts)null);
         var1.setNumDoc(this.manifestEntete.getVtemanNum());
         var1.setNature(this.nature);
         var1.setId_doc(this.manifestEntete.getVtemanId());
         var1.setPoidsImp(var3);
         var1.setBaseLog(this.baseLog);
         var1.setStructureLog(this.structureLog);
         var1.setUsersLog(this.usersLog);
         var1.imprimeRapport();
         this.chargerDocumentLigne((Session)null);
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
      ArrayList var1 = new ArrayList();
      this.showModele = true;
      return var1;
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

   public boolean isVar_valide_doc() {
      return this.var_valide_doc;
   }

   public void setVar_valide_doc(boolean var1) {
      this.var_valide_doc = var1;
   }

   public DataModel getDatamodelTransfert() {
      return this.datamodelTransfert;
   }

   public void setDatamodelTransfert(DataModel var1) {
      this.datamodelTransfert = var1;
   }

   public ManifestEntete getManifestEntete() {
      return this.manifestEntete;
   }

   public void setManifestEntete(ManifestEntete var1) {
      this.manifestEntete = var1;
   }

   public ManifestLigne getManifestLigne() {
      return this.manifestLigne;
   }

   public void setManifestLigne(ManifestLigne var1) {
      this.manifestLigne = var1;
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

   public String getInpCat() {
      return this.inpCat;
   }

   public void setInpCat(String var1) {
      this.inpCat = var1;
   }

   public String getInpDestinataire() {
      return this.inpDestinataire;
   }

   public void setInpDestinataire(String var1) {
      this.inpDestinataire = var1;
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

   public String getInpService() {
      return this.inpService;
   }

   public void setInpService(String var1) {
      this.inpService = var1;
   }

   public List getMesSeriesTrfItems() {
      return this.mesSeriesTrfItems;
   }

   public void setMesSeriesTrfItems(List var1) {
      this.mesSeriesTrfItems = var1;
   }

   public List getMesUsersItem() {
      return this.mesUsersItem;
   }

   public void setMesUsersItem(List var1) {
      this.mesUsersItem = var1;
   }

   public List getModeleTrfItems() {
      return this.modeleTrfItems;
   }

   public void setModeleTrfItems(List var1) {
      this.modeleTrfItems = var1;
   }

   public OptionVentes getOptionsVentes() {
      return this.optionsVentes;
   }

   public void setOptionsVentes(OptionVentes var1) {
      this.optionsVentes = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public boolean isShowModalPanelImput() {
      return this.showModalPanelImput;
   }

   public void setShowModalPanelImput(boolean var1) {
      this.showModalPanelImput = var1;
   }

   public boolean isShowModalPanelTrf() {
      return this.showModalPanelTrf;
   }

   public void setShowModalPanelTrf(boolean var1) {
      this.showModalPanelTrf = var1;
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

   public boolean isVar_acc_dre() {
      return this.var_acc_dre;
   }

   public void setVar_acc_dre(boolean var1) {
      this.var_acc_dre = var1;
   }

   public boolean isVar_acc_etat() {
      return this.var_acc_etat;
   }

   public void setVar_acc_etat(boolean var1) {
      this.var_acc_etat = var1;
   }

   public boolean isVar_acc_exoneration() {
      return this.var_acc_exoneration;
   }

   public void setVar_acc_exoneration(boolean var1) {
      this.var_acc_exoneration = var1;
   }

   public boolean isVar_acc_habilitation() {
      return this.var_acc_habilitation;
   }

   public void setVar_acc_habilitation(boolean var1) {
      this.var_acc_habilitation = var1;
   }

   public boolean isVar_acc_reglement() {
      return this.var_acc_reglement;
   }

   public void setVar_acc_reglement(boolean var1) {
      this.var_acc_reglement = var1;
   }

   public boolean isVar_acc_tracabilite() {
      return this.var_acc_tracabilite;
   }

   public void setVar_acc_tracabilite(boolean var1) {
      this.var_acc_tracabilite = var1;
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

   public boolean isVar_aff_trf() {
      return this.var_aff_trf;
   }

   public void setVar_aff_trf(boolean var1) {
      this.var_aff_trf = var1;
   }

   public boolean isVar_ajt() {
      return this.var_ajt;
   }

   public void setVar_ajt(boolean var1) {
      this.var_ajt = var1;
   }

   public Date getVar_date_trf() {
      return this.var_date_trf;
   }

   public void setVar_date_trf(Date var1) {
      this.var_date_trf = var1;
   }

   public String getVar_depotProd() {
      return this.var_depotProd;
   }

   public void setVar_depotProd(String var1) {
      this.var_depotProd = var1;
   }

   public boolean isVar_imp() {
      return this.var_imp;
   }

   public void setVar_imp(boolean var1) {
      this.var_imp = var1;
   }

   public String getVar_imput_cat() {
      return this.var_imput_cat;
   }

   public void setVar_imput_cat(String var1) {
      this.var_imput_cat = var1;
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

   public String getVar_mode_trf() {
      return this.var_mode_trf;
   }

   public void setVar_mode_trf(String var1) {
      this.var_mode_trf = var1;
   }

   public String getVar_modele_trf() {
      return this.var_modele_trf;
   }

   public void setVar_modele_trf(String var1) {
      this.var_modele_trf = var1;
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

   public String getVar_serie_trf() {
      return this.var_serie_trf;
   }

   public void setVar_serie_trf(String var1) {
      this.var_serie_trf = var1;
   }

   public boolean isVar_sup() {
      return this.var_sup;
   }

   public void setVar_sup(boolean var1) {
      this.var_sup = var1;
   }

   public int getVar_type_trf() {
      return this.var_type_trf;
   }

   public void setVar_type_trf(int var1) {
      this.var_type_trf = var1;
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

   public String getInpDossier() {
      return this.inpDossier;
   }

   public void setInpDossier(String var1) {
      this.inpDossier = var1;
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

   public DataModel getDatamodelLigne() {
      return this.datamodelLigne;
   }

   public void setDatamodelLigne(DataModel var1) {
      this.datamodelLigne = var1;
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

   public ExercicesParc getExercicesParc() {
      return this.exercicesParc;
   }

   public void setExercicesParc(ExercicesParc var1) {
      this.exercicesParc = var1;
   }

   public Habilitation getHabilitation() {
      return this.habilitation;
   }

   public void setHabilitation(Habilitation var1) {
      this.habilitation = var1;
   }

   public ExercicesParc getLastExoParc() {
      return this.lastExoParc;
   }

   public void setLastExoParc(ExercicesParc var1) {
      this.lastExoParc = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
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

   public boolean isVar_anal_dossier() {
      return this.var_anal_dossier;
   }

   public void setVar_anal_dossier(boolean var1) {
      this.var_anal_dossier = var1;
   }

   public Date getVar_date() {
      return this.var_date;
   }

   public void setVar_date(Date var1) {
      this.var_date = var1;
   }

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
   }

   public List getMesParcsItems() {
      return this.mesParcsItems;
   }

   public void setMesParcsItems(List var1) {
      this.mesParcsItems = var1;
   }

   public int getVar_option_parc() {
      return this.var_option_parc;
   }

   public void setVar_option_parc(int var1) {
      this.var_option_parc = var1;
   }

   public long getVar_nom_responsable() {
      return this.var_nom_responsable;
   }

   public void setVar_nom_responsable(long var1) {
      this.var_nom_responsable = var1;
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

   public double getPrixPlancher() {
      return this.prixPlancher;
   }

   public void setPrixPlancher(double var1) {
      this.prixPlancher = var1;
   }

   public boolean isGriserValider() {
      return this.griserValider;
   }

   public void setGriserValider(boolean var1) {
      this.griserValider = var1;
   }

   public UtilParapheur getUtilParapheur() {
      return this.utilParapheur;
   }

   public void setUtilParapheur(UtilParapheur var1) {
      this.utilParapheur = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public List getMesCommercialItem() {
      return this.mesCommercialItem;
   }

   public void setMesCommercialItem(List var1) {
      this.mesCommercialItem = var1;
   }

   public long getVar_nom_commercial() {
      return this.var_nom_commercial;
   }

   public void setVar_nom_commercial(long var1) {
      this.var_nom_commercial = var1;
   }

   public String getInpCommercial() {
      return this.inpCommercial;
   }

   public void setInpCommercial(String var1) {
      this.inpCommercial = var1;
   }

   public boolean isShowModalPanelGraph() {
      return this.showModalPanelGraph;
   }

   public void setShowModalPanelGraph(boolean var1) {
      this.showModalPanelGraph = var1;
   }

   public int getModeGraph() {
      return this.modeGraph;
   }

   public void setModeGraph(int var1) {
      this.modeGraph = var1;
   }

   public int getValQteGraph() {
      return this.valQteGraph;
   }

   public void setValQteGraph(int var1) {
      this.valQteGraph = var1;
   }

   public String getSousTitreGraph() {
      return this.sousTitreGraph;
   }

   public void setSousTitreGraph(String var1) {
      this.sousTitreGraph = var1;
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

   public String getDeviseGraph() {
      return this.deviseGraph;
   }

   public void setDeviseGraph(String var1) {
      this.deviseGraph = var1;
   }

   public int getNbDecGraph() {
      return this.nbDecGraph;
   }

   public void setNbDecGraph(int var1) {
      this.nbDecGraph = var1;
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

   public boolean isShowModele() {
      return this.showModele;
   }

   public void setShowModele(boolean var1) {
      this.showModele = var1;
   }

   public int getTimeDecoupage() {
      return this.timeDecoupage;
   }

   public void setTimeDecoupage(int var1) {
      this.timeDecoupage = var1;
   }

   public List getMesSerieUserItem() {
      return this.mesSerieUserItem;
   }

   public void setMesSerieUserItem(List var1) {
      this.mesSerieUserItem = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public int getTypeVente() {
      return this.typeVente;
   }

   public void setTypeVente(int var1) {
      this.typeVente = var1;
   }

   public boolean isShowModalPanelAnnuler() {
      return this.showModalPanelAnnuler;
   }

   public void setShowModalPanelAnnuler(boolean var1) {
      this.showModalPanelAnnuler = var1;
   }

   public double getVar_montant_trf() {
      return this.var_montant_trf;
   }

   public void setVar_montant_trf(double var1) {
      this.var_montant_trf = var1;
   }

   public OptionParcs getOptionParcs() {
      return this.optionParcs;
   }

   public void setOptionParcs(OptionParcs var1) {
      this.optionParcs = var1;
   }

   public boolean isVar_contener_parc() {
      return this.var_contener_parc;
   }

   public void setVar_contener_parc(boolean var1) {
      this.var_contener_parc = var1;
   }

   public Parapheur getParapheur() {
      return this.parapheur;
   }

   public void setParapheur(Parapheur var1) {
      this.parapheur = var1;
   }

   public UIDataTable getExtDTable() {
      return this.extDTable;
   }

   public void setExtDTable(UIDataTable var1) {
      this.extDTable = var1;
   }

   public SimpleSelection getSimpleSelectionEntete() {
      return this.simpleSelectionEntete;
   }

   public void setSimpleSelectionEntete(SimpleSelection var1) {
      this.simpleSelectionEntete = var1;
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

   public String getInpPdv() {
      return this.inpPdv;
   }

   public void setInpPdv(String var1) {
      this.inpPdv = var1;
   }

   public String getInpRegion() {
      return this.inpRegion;
   }

   public void setInpRegion(String var1) {
      this.inpRegion = var1;
   }

   public String getInpSecteur() {
      return this.inpSecteur;
   }

   public void setInpSecteur(String var1) {
      this.inpSecteur = var1;
   }

   public String getInpDepartement() {
      return this.inpDepartement;
   }

   public void setInpDepartement(String var1) {
      this.inpDepartement = var1;
   }

   public String getInpSite() {
      return this.inpSite;
   }

   public void setInpSite(String var1) {
      this.inpSite = var1;
   }

   public List getMesDepartementsItems() {
      return this.mesDepartementsItems;
   }

   public void setMesDepartementsItems(List var1) {
      this.mesDepartementsItems = var1;
   }

   public List getMesServicesItems() {
      return this.mesServicesItems;
   }

   public void setMesServicesItems(List var1) {
      this.mesServicesItems = var1;
   }

   public String getInpCaisse() {
      return this.inpCaisse;
   }

   public void setInpCaisse(String var1) {
      this.inpCaisse = var1;
   }

   public List getMesNaviresItems() {
      return this.mesNaviresItems;
   }

   public void setMesNaviresItems(List var1) {
      this.mesNaviresItems = var1;
   }

   public boolean isShowModalPanelLettre() {
      return this.showModalPanelLettre;
   }

   public void setShowModalPanelLettre(boolean var1) {
      this.showModalPanelLettre = var1;
   }

   public boolean isVar_aff_action_lv() {
      return this.var_aff_action_lv;
   }

   public void setVar_aff_action_lv(boolean var1) {
      this.var_aff_action_lv = var1;
   }

   public List getMesVehiculesItems() {
      return this.mesVehiculesItems;
   }

   public void setMesVehiculesItems(List var1) {
      this.mesVehiculesItems = var1;
   }

   public List getMesLieuxItemsArr() {
      return this.mesLieuxItemsArr;
   }

   public void setMesLieuxItemsArr(List var1) {
      this.mesLieuxItemsArr = var1;
   }

   public List getMesLieuxItemsDep() {
      return this.mesLieuxItemsDep;
   }

   public void setMesLieuxItemsDep(List var1) {
      this.mesLieuxItemsDep = var1;
   }

   public List getMesPortsItemsArr() {
      return this.mesPortsItemsArr;
   }

   public void setMesPortsItemsArr(List var1) {
      this.mesPortsItemsArr = var1;
   }

   public List getMesPortsItemsDep() {
      return this.mesPortsItemsDep;
   }

   public void setMesPortsItemsDep(List var1) {
      this.mesPortsItemsDep = var1;
   }

   public List getMesChauffeursItemsDest() {
      return this.mesChauffeursItemsDest;
   }

   public void setMesChauffeursItemsDest(List var1) {
      this.mesChauffeursItemsDest = var1;
   }

   public List getMesChauffeursItemsExp() {
      return this.mesChauffeursItemsExp;
   }

   public void setMesChauffeursItemsExp(List var1) {
      this.mesChauffeursItemsExp = var1;
   }

   public List getMesClientsItems() {
      return this.mesClientsItems;
   }

   public void setMesClientsItems(List var1) {
      this.mesClientsItems = var1;
   }

   public List getMesResponsablesItemsDest() {
      return this.mesResponsablesItemsDest;
   }

   public void setMesResponsablesItemsDest(List var1) {
      this.mesResponsablesItemsDest = var1;
   }

   public List getMesResponsablesItemsExp() {
      return this.mesResponsablesItemsExp;
   }

   public void setMesResponsablesItemsExp(List var1) {
      this.mesResponsablesItemsExp = var1;
   }

   public List getMesDevisItems() {
      return this.mesDevisItems;
   }

   public void setMesDevisItems(List var1) {
      this.mesDevisItems = var1;
   }

   public List getMesProduitsItems() {
      return this.mesProduitsItems;
   }

   public void setMesProduitsItems(List var1) {
      this.mesProduitsItems = var1;
   }

   public boolean isExoTc() {
      return this.exoTc;
   }

   public void setExoTc(boolean var1) {
      this.exoTc = var1;
   }

   public boolean isExoTva() {
      return this.exoTva;
   }

   public void setExoTva(boolean var1) {
      this.exoTva = var1;
   }

   public boolean isVar_tc_calcul() {
      return this.var_tc_calcul;
   }

   public void setVar_tc_calcul(boolean var1) {
      this.var_tc_calcul = var1;
   }

   public String getVar_tc_libelle() {
      return this.var_tc_libelle;
   }

   public void setVar_tc_libelle(String var1) {
      this.var_tc_libelle = var1;
   }

   public float getVar_tc_taux() {
      return this.var_tc_taux;
   }

   public void setVar_tc_taux(float var1) {
      this.var_tc_taux = var1;
   }

   public int getVar_tc_type() {
      return this.var_tc_type;
   }

   public void setVar_tc_type(int var1) {
      this.var_tc_type = var1;
   }

   public List getMesTaxesVentesItems() {
      return this.mesTaxesVentesItems;
   }

   public void setMesTaxesVentesItems(List var1) {
      this.mesTaxesVentesItems = var1;
   }

   public int getVar_timbre() {
      return this.var_timbre;
   }

   public void setVar_timbre(int var1) {
      this.var_timbre = var1;
   }

   public boolean isVerifBareme() {
      return this.verifBareme;
   }

   public void setVerifBareme(boolean var1) {
      this.verifBareme = var1;
   }

   public DataModel getDatamodelProduit() {
      return this.datamodelProduit;
   }

   public void setDatamodelProduit(DataModel var1) {
      this.datamodelProduit = var1;
   }

   public ManifestProduit getManifestProduit() {
      return this.manifestProduit;
   }

   public void setManifestProduit(ManifestProduit var1) {
      this.manifestProduit = var1;
   }

   public boolean isVisibiliteBtonDetaillig() {
      return this.visibiliteBtonDetaillig;
   }

   public void setVisibiliteBtonDetaillig(boolean var1) {
      this.visibiliteBtonDetaillig = var1;
   }

   public boolean isShowModalPanelProduit() {
      return this.showModalPanelProduit;
   }

   public void setShowModalPanelProduit(boolean var1) {
      this.showModalPanelProduit = var1;
   }

   public double getMontantReglement() {
      return this.montantReglement;
   }

   public void setMontantReglement(double var1) {
      this.montantReglement = var1;
   }

   public double getMontantReglementElmt() {
      return this.montantReglementElmt;
   }

   public void setMontantReglementElmt(double var1) {
      this.montantReglementElmt = var1;
   }

   public double getMontantSolde() {
      return this.montantSolde;
   }

   public void setMontantSolde(double var1) {
      this.montantSolde = var1;
   }

   public double getMontantSoldeElmt() {
      return this.montantSoldeElmt;
   }

   public void setMontantSoldeElmt(double var1) {
      this.montantSoldeElmt = var1;
   }

   public double getMontantTtc() {
      return this.montantTtc;
   }

   public void setMontantTtc(double var1) {
      this.montantTtc = var1;
   }

   public double getMontantTtcElmt() {
      return this.montantTtcElmt;
   }

   public void setMontantTtcElmt(double var1) {
      this.montantTtcElmt = var1;
   }

   public int getNumLigne() {
      return this.numLigne;
   }

   public void setNumLigne(int var1) {
      this.numLigne = var1;
   }

   public double getMontantHt() {
      return this.montantHt;
   }

   public void setMontantHt(double var1) {
      this.montantHt = var1;
   }

   public double getMontantTTva() {
      return this.montantTTva;
   }

   public void setMontantTTva(double var1) {
      this.montantTTva = var1;
   }

   public String getLibelleNatureTransport() {
      return this.libelleNatureTransport;
   }

   public void setLibelleNatureTransport(String var1) {
      this.libelleNatureTransport = var1;
   }

   public String getLibellePortTransport() {
      return this.libellePortTransport;
   }

   public void setLibellePortTransport(String var1) {
      this.libellePortTransport = var1;
   }

   public boolean isVar_valide_lv() {
      return this.var_valide_lv;
   }

   public void setVar_valide_lv(boolean var1) {
      this.var_valide_lv = var1;
   }

   public boolean isVar_valide_prd() {
      return this.var_valide_prd;
   }

   public void setVar_valide_prd(boolean var1) {
      this.var_valide_prd = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public ExercicesVentes getLastExoVentes() {
      return this.lastExoVentes;
   }

   public void setLastExoVentes(ExercicesVentes var1) {
      this.lastExoVentes = var1;
   }

   public List getMesRemorquesItems() {
      return this.mesRemorquesItems;
   }

   public void setMesRemorquesItems(List var1) {
      this.mesRemorquesItems = var1;
   }

   public List getMesNaturesManifestItems() {
      return this.mesNaturesManifestItems;
   }

   public void setMesNaturesManifestItems(List var1) {
      this.mesNaturesManifestItems = var1;
   }

   public String getInpContener() {
      return this.inpContener;
   }

   public void setInpContener(String var1) {
      this.inpContener = var1;
   }

   public DataModel getDataModelFactures() {
      return this.dataModelFactures;
   }

   public void setDataModelFactures(DataModel var1) {
      this.dataModelFactures = var1;
   }

   public List getMesContener1Items() {
      return this.mesContener1Items;
   }

   public void setMesContener1Items(List var1) {
      this.mesContener1Items = var1;
   }

   public List getMesContenerItems() {
      return this.mesContenerItems;
   }

   public void setMesContenerItems(List var1) {
      this.mesContenerItems = var1;
   }

   public DataModel getDataModelEcriture() {
      return this.dataModelEcriture;
   }

   public void setDataModelEcriture(DataModel var1) {
      this.dataModelEcriture = var1;
   }

   public DataModel getDataModelImportation() {
      return this.dataModelImportation;
   }

   public void setDataModelImportation(DataModel var1) {
      this.dataModelImportation = var1;
   }

   public boolean isShowModalPanelImportation() {
      return this.showModalPanelImportation;
   }

   public void setShowModalPanelImportation(boolean var1) {
      this.showModalPanelImportation = var1;
   }

   public DataModel getDataModelFacturesGroupe() {
      return this.dataModelFacturesGroupe;
   }

   public void setDataModelFacturesGroupe(DataModel var1) {
      this.dataModelFacturesGroupe = var1;
   }

   public DataModel getDataModelImportationErreur() {
      return this.dataModelImportationErreur;
   }

   public void setDataModelImportationErreur(DataModel var1) {
      this.dataModelImportationErreur = var1;
   }

   public boolean isShowModalPanelImportationErreur() {
      return this.showModalPanelImportationErreur;
   }

   public void setShowModalPanelImportationErreur(boolean var1) {
      this.showModalPanelImportationErreur = var1;
   }

   public int getVar_imput_choix() {
      return this.var_imput_choix;
   }

   public void setVar_imput_choix(int var1) {
      this.var_imput_choix = var1;
   }

   public String getVar_imput_num() {
      return this.var_imput_num;
   }

   public void setVar_imput_num(String var1) {
      this.var_imput_num = var1;
   }
}
