package com.epegase.forms.parc;

import com.epegase.forms.commun.FormRecherche;
import com.epegase.systeme.classe.Baremes;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.Espion;
import com.epegase.systeme.classe.ExercicesParc;
import com.epegase.systeme.classe.FamillesProduitsVentes;
import com.epegase.systeme.classe.Habilitation;
import com.epegase.systeme.classe.Parapheur;
import com.epegase.systeme.classe.Parc;
import com.epegase.systeme.classe.ParcLocationEntete;
import com.epegase.systeme.classe.ParcLocationLigne;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsGrp;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Unite;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.UsersChrono;
import com.epegase.systeme.control.EcrituresAnalytiqueCtrl;
import com.epegase.systeme.control.ObjetTarif;
import com.epegase.systeme.dao.BaremesDao;
import com.epegase.systeme.dao.ConditionnementDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.EspionDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.ParapheurDao;
import com.epegase.systeme.dao.ParcDao;
import com.epegase.systeme.dao.ParcLocationEnteteDao;
import com.epegase.systeme.dao.ParcLocationLigneDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsFournisseurDao;
import com.epegase.systeme.dao.ProduitsGrpDao;
import com.epegase.systeme.dao.ProduitsMclesDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.ProduitsVtesDao;
import com.epegase.systeme.dao.ServiceDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.TransitPortVentesDao;
import com.epegase.systeme.dao.UniteDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.dao.UsersChronoDao;
import com.epegase.systeme.util.CalculChrono;
import com.epegase.systeme.util.CalculStock;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilParapheur;
import com.epegase.systeme.util.UtilPrint;
import com.epegase.systeme.util.UtilTdt;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import com.epegase.systeme.xml.ObjetLigneOnglet;
import com.epegase.systeme.xml.OptionParcs;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;
import org.richfaces.model.selection.SimpleSelection;

public class FormParcLocation implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private int var_action;
   private int var_memo_action;
   private String pageIndex;
   private int nature;
   private String urlphotoProd;
   private int var_format_devise;
   private OptionParcs optionParcs;
   private OptionVentes optionsVentes;
   private ExercicesParc selectedExo;
   private ExercicesParc lastExo;
   private UtilNombre utilNombre = new UtilNombre();
   private UtilDate utilDate = new UtilDate();
   private List mesOnglets;
   private int var_nb_max = 100;
   private FormRecherche formRecherche;
   private CalculChrono calculChrono;
   private UsersChrono usersChrono;
   private UsersChronoDao usersChronoDao;
   private EspionDao espionDao;
   private List mesSerieUserItem;
   private String var_onglet;
   private boolean var_acc_descriptif = false;
   private boolean var_acc_affectation = false;
   private boolean verrouRemise = false;
   private boolean verrouRabais = false;
   private boolean verrouPrvente = false;
   private boolean affichagePump = false;
   private boolean affichagePlancher = false;
   private String verrouDepotUser;
   private boolean accesProduits;
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
   private Date var_date;
   private String var_heure;
   private String var_minute;
   private String var_seconde;
   private boolean var_aff_action = false;
   private boolean var_valide_parc = false;
   private boolean var_saisie_pu = false;
   private String inpSerie = "100";
   private String inpCat = "100";
   private String inpCaisse = "";
   private int inpEtat = 0;
   private String periode;
   private String inpNum = "";
   private String inpDestinataire = "";
   private String inpReceptionnaire = "";
   private String inpChauffeur = "";
   private String inpActivite = "";
   private String inpParc = "";
   private String inpDossier = "";
   private String inpRegion = "";
   private String inpSecteur = "";
   private String inpPdv = "";
   private long inpTiers = 0L;
   private String inpClient = "";
   private List mesSecteursItems;
   private List mesPdvItems;
   private String inpSite = "";
   private String inpDepartement = "";
   private String inpService = "";
   private List mesDepartementsItems;
   private List mesServicesItems;
   private Date inpDu = null;
   private Date inpAu = null;
   private boolean selectDestinataire = false;
   private boolean var_more_search = false;
   private ParcLocationEntete parcLocationEntete;
   private ParcLocationEnteteDao parcLocationEnteteDao;
   private List lesOrEntete = new ArrayList();
   private transient DataModel dataModelOrEntete = new ListDataModel();
   private UIDataTable extDTable = new HtmlExtendedDataTable();
   private SimpleSelection simpleSelectionEntete = new SimpleSelection();
   private boolean var_affiche_bouton = false;
   private boolean var_valide_doc = false;
   private Tiers tiers;
   private TiersDao tiersDao;
   private List mesPortsItemsDep;
   private List mesPortsItemsArr;
   private TransitPortVentesDao transitPortVentesDao;
   private double var_total_marge;
   private boolean visibiliteBtonlig = true;
   private ParcLocationLigne parcLocationLigne;
   private ParcLocationLigneDao parcLocationLigneDao;
   private transient DataModel datamodelLigne;
   private List lesLignesList;
   private String var_depotProd;
   private double totauxTtc = 0.0D;
   private double totauxHt = 0.0D;
   private double totauxTaxe = 0.0D;
   private boolean griserchamps = false;
   private double prixPlancher;
   private boolean griserValider = false;
   private int numLigne;
   private ServiceDao serviceDao;
   private Produits produits;
   private Produits memoProduits;
   private ProduitsVtesDao produitsDao;
   private ProduitsDepot produitsDepot;
   private ProduitsFournisseurDao produitsFournisseurDao;
   private ProduitsTarifDao produitsTarifdao;
   private ProduitsDepotDao produitsDepotDao;
   private List mesProduitsDepotsItems;
   private List listeProduitDepot;
   private TaxesVentesDao taxesVentesDao;
   private TaxesVentes taxesVentes;
   private FamillesProduitsVentesDao famillesProduitsVentesDao;
   private FamillesProduitsVentes famillesProduitsVentes;
   private ProduitsServicesDao produitsServicesDao;
   private ProduitsMclesDao produitsMclesDao;
   private double prixUnitaires;
   private List mesTaxesVentesItems;
   private List mesTaxesVentesProduits;
   private CalculStock calculStock;
   private boolean verrou_libelle = false;
   private BaremesDao baremesDao;
   private boolean verifBareme;
   private boolean printTexte;
   private List mesConditionnementsItems;
   private List mesConditionnementsProduits;
   private List mesUnitesItems;
   private List mesUnitesProduits;
   private boolean var_aff_condit = false;
   private boolean var_aff_unite = false;
   private int var_code_unite;
   private Unite unite;
   private UniteDao uniteDao;
   private ContactDao contactDao;
   private Contacts contacts;
   private List mesContactItem;
   private long var_nom_contact;
   private String nomTier;
   private List lesFamilleClientsListe;
   private List lesModeReglementClientsListe;
   private String informationsTiers;
   private Parc parc;
   private ProduitsAchsDao produitsAchsDao;
   private Habilitation habilitation;
   private UtilParapheur utilParapheur;
   private ParapheurDao parapheurDao;
   private Parapheur parapheur;
   private boolean var_sansstock = false;
   private boolean var_pr_pv = false;
   private boolean var_aff_detail_prod = false;
   private boolean var_aff_detail_tiers = false;
   private boolean var_typeTiers = true;
   private List mesReceptionnairesItems = new ArrayList();
   private String immatriculation;
   private String typeCompteur;
   private UtilTdt utilTdt = new UtilTdt();
   private boolean showModalPanelPrint = false;
   private String infoOrigineDoc;
   private String devisePrint;
   private float tauxPrint;
   private String montant_lettre;
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
   private boolean var_anal_activite = false;
   private boolean var_anal_dossier = false;
   private boolean var_anal_parc = false;
   private String libelleRabRis;
   private boolean ristourne;
   private List mesActivitesItems;
   private boolean decoupageActivite = false;
   private List laColonne1Items;
   private List laColonne2Items;
   private List laColonne3Items;
   private EcrituresAnalytiqueCtrl ecrituresAnalytiqueCtrl;
   private List lesDecoupagesActivites;
   private transient DataModel dataModelDecoupageActivtes;
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
   private UtilDownload utilDownload;
   private String fileName;
   private String urlphotoAgent;
   private static final int DEFAULT_BUFFER_SIZE = 10240;
   private UploadedFile uploadedPDFFile;
   private String pdfFileName;
   private String fichierMine;
   private URL fichierUrl;
   private String urlExplorateur;
   private transient DataModel dataModelDocumnts;
   private List lesDocuments;
   private String nomRepertoire;
   private boolean showModalPanelPj = false;
   private boolean showModalPanelAjoutFile = false;
   private String nomDocument;

   public FormParcLocation() {
      this.calculChrono = new CalculChrono(this.baseLog, this.utilInitHibernate);
      this.mesContactItem = new ArrayList();
      this.lesDecoupagesActivites = new ArrayList();
      this.dataModelDecoupageActivtes = new ListDataModel();
      this.mesProduitsDepotsItems = new ArrayList();
      this.listeProduitDepot = new ArrayList();
      this.mesConditionnementsProduits = new ArrayList();
      this.mesUnitesProduits = new ArrayList();
      this.mesTaxesVentesProduits = new ArrayList();
      this.unite = new Unite();
      this.usersChrono = new UsersChrono();
      this.mesPortsItemsDep = new ArrayList();
      this.mesPortsItemsArr = new ArrayList();
      this.lesLignesList = new ArrayList();
      this.datamodelLigne = new ListDataModel();
      this.calculStock = new CalculStock();
      this.dataModelDocumnts = new ListDataModel();
      this.lesDocuments = new ArrayList();
   }

   public void InstancesDaoUtilses() {
      this.parcLocationEnteteDao = new ParcLocationEnteteDao(this.baseLog, this.utilInitHibernate);
      this.parcLocationLigneDao = new ParcLocationLigneDao(this.baseLog, this.utilInitHibernate);
      this.produitsAchsDao = new ProduitsAchsDao(this.baseLog, this.utilInitHibernate);
      this.usersChronoDao = new UsersChronoDao(this.baseLog, this.utilInitHibernate);
      this.espionDao = new EspionDao(this.baseLog, this.utilInitHibernate);
      this.tiersDao = new TiersDao(this.baseLog, this.utilInitHibernate);
      this.transitPortVentesDao = new TransitPortVentesDao(this.baseLog, this.utilInitHibernate);
      this.contactDao = new ContactDao(this.baseLog, this.utilInitHibernate);
      this.produitsFournisseurDao = new ProduitsFournisseurDao(this.baseLog, this.utilInitHibernate);
      this.famillesProduitsVentesDao = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      this.taxesVentesDao = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      this.produitsDepotDao = new ProduitsDepotDao(this.baseLog, this.utilInitHibernate);
      this.baremesDao = new BaremesDao(this.baseLog, this.utilInitHibernate);
   }

   public void initialisation(Session var1) throws HibernateException, NamingException {
      if (this.optionParcs.getNbLigneMax() != null && !this.optionParcs.getNbLigneMax().isEmpty()) {
         this.var_nb_max = Integer.parseInt(this.optionParcs.getNbLigneMax());
      } else {
         this.var_nb_max = 100;
      }

      this.var_action = 0;
      this.usersChrono = this.usersChronoDao.selectUnique("", this.nature, this.usersLog, var1);
      this.mesPortsItemsDep = this.transitPortVentesDao.chargerLesPortsByNature(6, 0L, var1);
      this.mesPortsItemsArr = this.mesPortsItemsDep;
      if (this.optionsVentes.getDecrmtRabais().equals("3")) {
         this.libelleRabRis = "Ristourne";
         this.ristourne = true;
      } else {
         this.libelleRabRis = "Rabais";
         this.ristourne = false;
      }

      this.nomRepertoire = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "photos" + File.separator + "parc_location" + File.separator;
      File var2 = new File(this.nomRepertoire);
      if (!var2.exists()) {
         var2.mkdir();
      }

      this.onglet01();
   }

   public void rechercherLocation() throws HibernateException, NamingException, ParseException {
      this.rechercherLocation((Session)null);
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
         this.inpReceptionnaire = "";
         this.inpChauffeur = "";
         this.inpActivite = "";
      }

   }

   public void rechercherLocation(Session var1) throws HibernateException, NamingException, ParseException {
      this.lesOrEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
      String var2 = "";
      String var3 = "";
      if (this.var_more_search) {
         if (this.inpDu != null) {
            var2 = this.utilDate.dateToStringSQLLight(this.inpDu);
         }

         if (this.inpAu != null) {
            var3 = this.utilDate.dateToStringSQLLight(this.inpAu);
         }
      } else {
         var2 = null;
         var3 = null;
      }

      this.lesOrEntete = this.parcLocationEnteteDao.rechercheParcLocationEntete(this.selectedExo.getExeprcId(), this.inpTiers, this.inpClient, 0, this.usersLog.getUsrid(), this.inpNum, this.inpSerie, this.inpEtat, this.periode, this.inpActivite, this.inpReceptionnaire, this.inpChauffeur, this.inpParc, var2, var3, this.inpService, var1);
      this.dataModelOrEntete.setWrappedData(this.lesOrEntete);
   }

   public void accesResteintGroupe() {
      this.var_acc_descriptif = false;
      this.var_acc_affectation = false;
      this.var_acc_etat = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("1")) {
               this.var_acc_descriptif = true;
            } else if (var1.getCode().equals("2")) {
               this.var_acc_affectation = true;
            } else if (var1.getCode().equals("3")) {
               this.var_acc_etat = true;
            }
         }
      }

   }

   public void autorisationDescription() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("1")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void autorisationAffectation() {
      this.var_ajt = false;
      this.var_mod = false;
      this.var_sup = false;
      this.var_imp = false;
      if (this.mesOnglets.size() != 0) {
         new ObjetLigneOnglet();

         for(int var2 = 0; var2 < this.mesOnglets.size(); ++var2) {
            ObjetLigneOnglet var1 = (ObjetLigneOnglet)this.mesOnglets.get(var2);
            if (var1.getCode().equals("2")) {
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
            if (var1.getCode().equals("3")) {
               this.var_ajt = var1.isAdd();
               this.var_mod = var1.isMaj();
               this.var_sup = var1.isSup();
               this.var_imp = var1.isImp();
            }
         }
      }

   }

   public void onglet01() {
      this.var_onglet = "identification";
   }

   public void onglet02() {
      this.var_onglet = "scan";
   }

   public void onglet03() {
      this.var_onglet = "description";
   }

   public void onglet04() {
      this.var_onglet = "inventaireIn";
   }

   public void onglet05() {
      this.var_onglet = "imputations";
   }

   public void onglet06() {
      this.var_onglet = "prix";
      this.calculeDuree();
      if (this.parcLocationEntete.getPrclocPu() == 0.0D) {
         this.parcLocationEntete.setPrclocPu(this.parc.getPrcPrixVente());
      }

      if (this.parcLocationEntete.getPrclocDuree() != 0.0D) {
         this.parcLocationEntete.setPrclocPv(this.parcLocationEntete.getPrclocPu() * this.parcLocationEntete.getPrclocDuree());
      } else {
         this.parcLocationEntete.setPrclocPv(0.0D);
      }

      this.addLigne();
   }

   public void onglet07() {
      this.var_onglet = "descriptionRetour";
   }

   public void onglet08() {
      this.var_onglet = "inventaireOut";
   }

   public void selectionLocation() throws HibernateException, NamingException, IOException {
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
            this.parcLocationEntete = (ParcLocationEntete)var1.get(0);
            this.var_date = this.parcLocationEntete.getPrclocDate();
            if (this.parcLocationEntete.getPrclocDate().getHours() <= 9) {
               this.var_heure = "0" + this.parcLocationEntete.getPrclocDate().getHours();
            } else {
               this.var_heure = "" + this.parcLocationEntete.getPrclocDate().getHours();
            }

            if (this.parcLocationEntete.getPrclocDate().getMinutes() <= 9) {
               this.var_minute = "0" + this.parcLocationEntete.getPrclocDate().getMinutes();
            } else {
               this.var_minute = "" + this.parcLocationEntete.getPrclocDate().getMinutes();
            }

            if (this.parcLocationEntete.getPrclocDate().getSeconds() <= 9) {
               this.var_seconde = "0" + this.parcLocationEntete.getPrclocDate().getSeconds();
            } else {
               this.var_seconde = "" + this.parcLocationEntete.getPrclocDate().getSeconds();
            }

            this.parc = this.parcLocationEntete.getParc();
            this.immatriculation = this.parc.getPrcImmatriculation();
            this.typeCompteur = this.parc.getLibCompteur();
            this.tiers = this.parcLocationEntete.getTiers();
            Session var4 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_location");
            if (this.parcLocationEntete.getPrclocService() != null && !this.parcLocationEntete.getPrclocService().isEmpty()) {
               this.calculReceptionnaire(var4);
            }

            this.calculeDuree();
            this.chargerDocumentLigne(var4);
            this.chargerDocumentScan();
            if (this.decoupageActivite) {
               this.chargerDetailanalytique();
               this.controleEcartAnalytique();
            }

            this.utilInitHibernate.closeSession();
            this.var_affiche_bouton = true;
         } else {
            this.var_affiche_bouton = false;
         }
      } else {
         this.var_affiche_bouton = false;
      }

   }

   public void visualisationLigne() throws HibernateException, NamingException, JDOMException, IOException {
      if (this.parcLocationEntete != null) {
         if (this.parcLocationEntete.getPrclocEtat() == 0) {
            this.modifierLocation();
         } else {
            this.consulterLocation();
         }
      }

   }

   public void ajouterLocation() throws HibernateException, NamingException {
      this.tiers = new Tiers();
      this.parc = new Parc();
      this.parcLocationEntete = new ParcLocationEntete();
      this.var_date = new Date();
      this.typeCompteur = "";
      this.immatriculation = "";
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

      this.var_saisie_pu = false;
      this.var_action = 1;
      this.var_valide_parc = false;
      this.var_aff_action = false;
      this.var_aff_detail_tiers = false;
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      this.informationsTiers = null;
      this.var_memo_action = this.var_action;
      this.var_aff_action = false;
      this.var_valide_doc = false;
      this.var_aff_detail_tiers = false;
      this.var_typeTiers = true;
      this.selectDestinataire = true;
      this.visibiliteBtonlig = true;
      this.addLigne();
      this.onglet01();
      this.var_memo_action = this.var_action;
   }

   public void modifierLocation() {
      if (this.parcLocationEntete != null) {
         this.var_valide_parc = true;
         this.var_aff_action = false;
         this.var_action = 2;
         this.visibiliteBtonlig = true;
         this.onglet01();
         this.addLigne();
         this.var_memo_action = this.var_action;
      }

   }

   public void valideDocument() throws HibernateException, NamingException {
      if (this.parcLocationEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_location");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.parcLocationEntete.getPrclocEtat() == 0 && this.usersChrono.getUsrchrValidation() == 2) {
               this.parcLocationEntete.setPrclocEtat(1);
               this.parcLocationEntete = this.parcLocationEnteteDao.modif(this.parcLocationEntete, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Validation manuelle LOCATION (P.) N° " + this.parcLocationEntete.getPrclocNum() + " du " + this.utilDate.dateToStringSQLLight(this.parcLocationEntete.getPrclocDate()));
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

   public void deValideDocument() throws HibernateException, NamingException {
      if (this.parcLocationEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_location");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.parcLocationEntete.getPrclocEtat() == 1) {
               this.parcLocationEntete.setPrclocEtat(0);
               this.parcLocationEntete = this.parcLocationEnteteDao.modif(this.parcLocationEntete, var1);
               Espion var3 = new Espion();
               var3.setUsers(this.usersLog);
               var3.setEsptype(0);
               var3.setEspdtecreat(new Date());
               var3.setEspaction("Dévalidation manuelle LOCATION (P.) N° " + this.parcLocationEntete.getPrclocNum() + " du " + this.utilDate.dateToStringSQLLight(this.parcLocationEntete.getPrclocDate()));
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

   public void consulterLocation() {
      if (this.parcLocationEntete != null) {
         this.var_valide_parc = false;
         this.var_aff_action = true;
         this.var_action = 3;
         this.visibiliteBtonlig = false;
         this.onglet01();
         this.addLigne();
         this.var_memo_action = this.var_action;
      }

   }

   public void supprimerLocation() throws HibernateException, NamingException {
      if (this.parcLocationEntete != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_location");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            this.parcLocationEnteteDao.delete(this.parcLocationEntete);
            this.lesOrEntete.remove(this.parcLocationEntete);
            this.dataModelOrEntete.setWrappedData(this.lesOrEntete);
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

      this.var_affiche_bouton = false;
      this.extDTable = new HtmlExtendedDataTable();
      this.simpleSelectionEntete.clear();
   }

   public void annulerLocation() {
      this.var_action = 0;
      this.var_memo_action = this.var_action;
      this.var_affiche_bouton = false;
      this.simpleSelectionEntete.clear();
      this.extDTable = new HtmlExtendedDataTable();
   }

   public void saveLocation() throws HibernateException, NamingException, ParseException {
      this.parcLocationEntete.setPrclocTypeCompteur(this.parc.getPrcCompteur());
      this.parcLocationEntete.setPrclocNumChassis(this.parc.getPrcChassis());
      this.parcLocationEntete.setPrclocNumMoteur(this.parc.getPrcMoteur());
      this.parcLocationEntete.setPrclocIdCommercial(this.usersLog.getUsrid());
      this.parcLocationEntete.setPrclocNomCommercial(this.usersLog.getUsrPatronyme());
      this.parcLocationEntete.setPrclocNomChauffeur("");
      if (this.parcLocationEntete.getPrclocIdChauffeur() != 0L) {
         for(int var1 = 0; var1 < this.mesReceptionnairesItems.size(); ++var1) {
            long var2 = Long.parseLong(((SelectItem)this.mesReceptionnairesItems.get(var1)).getValue().toString());
            if (this.parcLocationEntete.getPrclocIdChauffeur() == var2) {
               this.parcLocationEntete.setPrclocNomChauffeur(((SelectItem)this.mesReceptionnairesItems.get(var1)).getLabel().toString());
               break;
            }
         }
      }

      if (this.decoupageActivite) {
         this.parcLocationEntete.setPrclocActivite("");
         String var15 = "";
         boolean var16 = true;
         if (this.lesDecoupagesActivites.size() != 0) {
            for(int var3 = 0; var3 < this.lesDecoupagesActivites.size(); ++var3) {
               this.ecrituresAnalytiqueCtrl = (EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var3);
               if (this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie() != 0.0D) {
                  if (var16) {
                     var15 = this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                     var16 = false;
                  } else {
                     var15 = var15 + "#" + this.ecrituresAnalytiqueCtrl.getEcranaActivite() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaActiviteLib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal1Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaAnal3Lib() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaPourcentage() + ":" + this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                  }
               }
            }
         }

         this.parcLocationEntete.setPrclocActivite(var15);
      }

      Session var17 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_location");
      Transaction var18 = null;

      try {
         var18 = var17.beginTransaction();
         if (this.parcLocationEntete.getPrclocId() != 0L) {
            this.parcLocationEntete.setPrclocDateModif(new Date());
            this.parcLocationEntete.setPrclocIdModif(this.usersLog.getUsrid());
            this.parcLocationEntete = this.parcLocationEnteteDao.modif(this.parcLocationEntete, var17);
         } else {
            if (this.var_date == null) {
               this.var_date = new Date();
            }

            this.parcLocationEntete.setPrclocDate(this.utilDate.dateToSQL(this.var_date, this.var_heure, this.var_minute, this.var_seconde));
            String var19 = this.calculChrono.numCompose(this.parcLocationEntete.getPrclocDate(), this.nature, this.parcLocationEntete.getPrclocSerie(), var17);
            boolean var4 = false;

            while(true) {
               while(!var4) {
                  new ParcLocationEntete();
                  ParcLocationEntete var5 = this.parcLocationEnteteDao.rechercheConsommation(var19, var17);
                  if (var5 != null) {
                     long var6 = 100000000L * this.usersLog.getUsrid();

                     for(long var8 = 0L; var8 < var6; ++var8) {
                     }

                     var19 = this.calculChrono.numCompose(this.parcLocationEntete.getPrclocDate(), this.nature, this.parcLocationEntete.getPrclocSerie(), var17);
                     var4 = false;
                  } else {
                     var4 = true;
                  }
               }

               this.calculeDuree();
               this.parcLocationEntete.setExercicesParc(this.lastExo);
               this.parcLocationEntete.setParc(this.parc);
               this.parcLocationEntete.setPrclocEtat(1);
               this.parcLocationEntete.setPrclocEtatVal(0);
               this.parcLocationEntete.setPrclocDateValide((Date)null);
               this.parcLocationEntete.setPrclocNum(var19);
               this.parcLocationEntete.setPrclocDateCreat(new Date());
               this.parcLocationEntete.setPrclocIdCreateur(this.usersLog.getUsrid());
               this.parcLocationEntete = this.parcLocationEnteteDao.insert(this.parcLocationEntete, var17);
               this.lesOrEntete.add(this.parcLocationEntete);
               this.dataModelOrEntete.setWrappedData(this.lesOrEntete);
               this.simpleSelectionEntete.clear();
               this.extDTable = new HtmlExtendedDataTable();
               break;
            }
         }

         var18.commit();
      } catch (HibernateException var13) {
         if (var18 != null) {
            var18.rollback();
         }

         throw var13;
      } finally {
         this.utilInitHibernate.closeSession();
      }

      this.var_action = 0;
   }

   public void calculeDuree() {
      if (this.parcLocationEntete.getPrclocDateDepart() != null && this.parcLocationEntete.getPrclocDateRetour() != null) {
         float var1 = (float)((this.parcLocationEntete.getPrclocDateRetour().getTime() - this.parcLocationEntete.getPrclocDateDepart().getTime()) / 86400000L + 1L);
         this.parcLocationEntete.setPrclocDuree((double)var1);
      } else {
         this.parcLocationEntete.setPrclocDuree(0.0D);
      }

      if (this.parcLocationEntete.getPrclocCompteurFin() != 0L && this.parcLocationEntete.getPrclocCompteur() != 0L) {
         long var3 = this.parcLocationEntete.getPrclocCompteurFin() - this.parcLocationEntete.getPrclocCompteur();
         this.parcLocationEntete.setPrclocCompteurDistance(var3);
      } else {
         this.parcLocationEntete.setPrclocCompteurDistance(0L);
      }

   }

   public void calculTotal() {
      this.calculeDuree();
      double var1 = this.utilNombre.myRoundDevise(this.parcLocationEntete.getPrclocPu() * this.parcLocationEntete.getPrclocDuree(), this.structureLog.getStrdevise());
      this.parcLocationEntete.setPrclocPv(var1);
      double var3 = this.parcLocationEntete.getPrclocPv();
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = 0.0D;
      if (this.parcLocationEntete.getPrclocExoTva() == 0) {
         float var11 = 0.0F;
         if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
            var11 = Float.parseFloat(this.optionsVentes.getTvaDefaut());
         }

         var5 = this.utilNombre.myRoundDevise(var3 * (double)var11, this.structureLog.getStrdevise());
         if (this.var_tc_calcul && this.var_tc_type != 0) {
            var9 = this.utilNombre.myRoundDevise(var3 * (double)this.var_tc_taux, this.structureLog.getStrdevise());
         }
      }

      for(int var12 = 0; var12 < this.lesLignesList.size(); ++var12) {
         var3 += ((ParcLocationLigne)this.lesLignesList.get(var12)).getPrcllgPt();
         var5 += ((ParcLocationLigne)this.lesLignesList.get(var12)).getPrcllgTva();
         var7 += ((ParcLocationLigne)this.lesLignesList.get(var12)).getPrcllgTtc();
         var9 += ((ParcLocationLigne)this.lesLignesList.get(var12)).getPrcllgTc();
      }

      this.parcLocationEntete.setPrclocTotHt(var3);
      this.parcLocationEntete.setPrclocTotTva(var5);
      this.parcLocationEntete.setPrclocTotTtc(var7);
      this.parcLocationEntete.setPrclocTotTc(var9);
   }

   public void calculHt(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_location");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      int var7 = 0;
      if (this.parcLocationEntete.getPrclocExoTva() == 0) {
         TaxesVentes var8;
         if (var1 != null && !var1.isEmpty()) {
            new TaxesVentes();
            var8 = this.taxesVentesDao.selectTva(this.selectedExo.getExeprcId(), var1, var3);
            if (var8 != null) {
               var5 = var8.getTaxvteTaux();
               var6 = var8.getTaxvteCode();
               var7 = var8.getTaxvteType();
            } else if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               TaxesVentes var9 = this.taxesVentesDao.selectTva(this.selectedExo.getExeprcId(), this.optionsVentes.getTvaDefaut(), var3);
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
            var8 = this.taxesVentesDao.selectTva(this.selectedExo.getExeprcId(), this.optionsVentes.getTvaDefaut(), var3);
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

         if (this.produits != null && this.produits.isProExoTva() || this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
            var5 = 0.0F;
            var6 = "";
            var7 = 0;
         }
      }

      this.parcLocationLigne.setPrcllgTaxe(var6);
      this.parcLocationLigne.setPrcllgTauxTaxe(var5);
      double var35 = this.parcLocationLigne.getPrcllgPu();
      float var10;
      if (var7 == 3) {
         var10 = 100.0F - var5;
         var35 = this.utilNombre.myRoundDevise(var35 / (double)var10 * 100.0D, this.parcLocationEntete.getPrclocDevise());
      }

      var10 = this.parcLocationLigne.getPrcllgQte();
      if (this.parcLocationLigne.getPrcllgQte() != 0.0F) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            this.parcLocationLigne.setPrcllgQteUtil(this.parcLocationLigne.getPrcllgQte());
            var10 = this.parcLocationLigne.getPrcllgQte() * this.parcLocationLigne.getPrcllgLong();
         } else {
            this.parcLocationLigne.setPrcllgQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.parcLocationLigne.getPrcllgCondition(), this.parcLocationLigne.getPrcllgQte(), this.parcLocationLigne.getPrcllgLong(), this.parcLocationLigne.getPrcllgLarg(), this.parcLocationLigne.getPrcllgHaut(), this.parcLocationLigne.getPrcllgDiam(), this.parcLocationLigne.getPrcllgNb(), this.baseLog, this.utilInitHibernate, var3));
         }
      } else {
         this.parcLocationLigne.setPrcllgQteUtil(0.0F);
      }

      double var11 = 0.0D;
      if (this.parcLocationLigne.getPrcllgCondition() != null && !this.parcLocationLigne.getPrcllgCondition().isEmpty() && this.parcLocationLigne.getPrcllgCondition().contains(":")) {
         var11 = var35 * (double)var10;
      } else {
         var11 = var35 * (double)var10;
      }

      double var13 = 0.0D;
      double var15 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var15 = this.parcLocationLigne.getPrcllgRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var15 = this.parcLocationLigne.getPrcllgRabais() * (double)this.parcLocationLigne.getPrcllgQte();
      }

      if (this.parcLocationLigne.getPrcllgTauxRemise() != 0.0F) {
         var13 = var11 - var11 * (double)this.parcLocationLigne.getPrcllgTauxRemise() / 100.0D - var15;
      } else {
         var13 = var11 - var15;
      }

      double var17 = this.utilNombre.myRoundFormat(var13, this.var_format_devise);
      double var19 = var17 * (double)this.parcLocationLigne.getPrcllgTauxTaxe() / 100.0D;
      if (var7 == 2) {
         var19 *= -1.0D;
      } else if (var7 == 3) {
         var19 = var17 * (double)(this.parcLocationLigne.getPrcllgTauxTaxe() / 100.0F);
         var19 *= -1.0D;
      }

      double var21 = this.utilNombre.myRoundFormat(var19, this.var_format_devise);
      double var23 = var17 + var21;
      double var25 = 0.0D;
      if (this.parcLocationLigne.getPrcllgCondition() != null && !this.parcLocationLigne.getPrcllgCondition().isEmpty() && this.parcLocationLigne.getPrcllgCondition().contains(":")) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            var25 = this.utilNombre.myRound(var17 / (double)this.parcLocationLigne.getPrcllgQteUtil(), 2);
         } else {
            var25 = this.utilNombre.myRound(var17 / (double)this.parcLocationLigne.getPrcllgQte(), 2);
         }
      } else if (this.optionsVentes.getModeCalculDevis().equals("1")) {
         var25 = this.utilNombre.myRound(var17 / (double)this.parcLocationLigne.getPrcllgQteUtil(), 2);
      } else {
         var25 = this.utilNombre.myRound(var17 / (double)this.parcLocationLigne.getPrcllgQte(), 2);
      }

      this.parcLocationLigne.setPrcllgPuRem(var25);
      this.parcLocationLigne.setPrcllgPt(var17);
      this.parcLocationLigne.setPrcllgTva(var21);
      this.parcLocationLigne.setPrcllgTtc(var23);
      this.parcLocationLigne.setPrcllgTc(0.0D);
      double var27 = 0.0D;
      if (this.parcLocationLigne.getPrcllgCondition() != null && !this.parcLocationLigne.getPrcllgCondition().isEmpty() && this.parcLocationLigne.getPrcllgCondition().contains(":")) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            var27 = this.utilNombre.myRound(var23 / (double)this.parcLocationLigne.getPrcllgQteUtil(), 2);
         } else {
            var27 = this.utilNombre.myRound(var23 / (double)this.parcLocationLigne.getPrcllgQte(), 2);
         }
      } else if (this.optionsVentes.getModeCalculDevis().equals("1")) {
         var27 = this.utilNombre.myRound(var23 / (double)this.parcLocationLigne.getPrcllgQteUtil(), 2);
      } else {
         var27 = this.utilNombre.myRound(var23 / (double)this.parcLocationLigne.getPrcllgQte(), 2);
      }

      this.parcLocationLigne.setPrcllgPuRemTtc(var27);
      double var29 = var35 + var35 * (double)this.parcLocationLigne.getPrcllgTauxTaxe() / 100.0D;
      this.parcLocationLigne.setPrcllgPuTtc(var29);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.parcLocationEntete.setPrclocTauxTc(this.var_tc_taux);
         double var31 = 0.0D;
         double var33 = 0.0D;
         if (this.var_tc_type == 6) {
            var31 = var23 * (double)this.parcLocationEntete.getPrclocTauxTc() / 100.0D;
            var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
            this.parcLocationLigne.setPrcllgTc(var33);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var31 = var17 * (double)this.parcLocationEntete.getPrclocTauxTc() / 100.0D;
               if (this.parcLocationLigne.getPrcllgTauxTaxe() != 0.0F) {
                  var31 = var17 * (double)this.parcLocationEntete.getPrclocTauxTc() / 100.0D;
                  var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
                  double var10000 = var31 + var31 * (double)this.parcLocationLigne.getPrcllgTauxTaxe() / 100.0D;
                  this.parcLocationLigne.setPrcllgTc(var33);
               }
            }
         } else {
            if (this.parcLocationLigne.getPrcllgTva() != 0.0D) {
               var31 = var17 * (double)this.parcLocationEntete.getPrclocTauxTc() / 100.0D;
            } else {
               var31 = 0.0D;
            }

            var33 = this.utilNombre.myRoundFormat(var31, this.var_format_devise);
            this.parcLocationLigne.setPrcllgTc(var33);
         }
      } else {
         this.parcLocationLigne.setPrcllgTc(0.0D);
         this.parcLocationEntete.setPrclocTauxTc(0.0F);
      }

      this.parcLocationLigne.setPrcllgPt(this.utilNombre.myRoundDevise(this.parcLocationLigne.getPrcllgPt(), this.parcLocationEntete.getPrclocDevise()));
      this.parcLocationLigne.setPrcllgTva(this.utilNombre.myRoundDevise(this.parcLocationLigne.getPrcllgTva(), this.parcLocationEntete.getPrclocDevise()));
      this.parcLocationLigne.setPrcllgTtc(this.utilNombre.myRoundDevise(this.parcLocationLigne.getPrcllgTtc(), this.parcLocationEntete.getPrclocDevise()));
      this.parcLocationLigne.setPrcllgTc(this.utilNombre.myRoundDevise(this.parcLocationLigne.getPrcllgTc(), this.parcLocationEntete.getPrclocDevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculTtc(String var1, float var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_location");
         var4 = true;
      }

      float var5 = 0.0F;
      String var6 = "";
      boolean var7 = false;
      if (this.parcLocationEntete.getPrclocExoTva() == 0) {
         TaxesVentes var8;
         int var38;
         if (var1 != null && !var1.isEmpty()) {
            new TaxesVentes();
            var8 = this.taxesVentesDao.selectTva(this.selectedExo.getExeprcId(), var1, var3);
            if (var8 != null) {
               var5 = var8.getTaxvteTaux();
               var6 = var8.getTaxvteCode();
               var38 = var8.getTaxvteType();
            } else if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               TaxesVentes var9 = this.taxesVentesDao.selectTva(this.selectedExo.getExeprcId(), this.optionsVentes.getTvaDefaut(), var3);
               if (var9 != null) {
                  var5 = var9.getTaxvteTaux();
                  var6 = var9.getTaxvteCode();
                  var38 = var9.getTaxvteType();
               } else {
                  var5 = var2;
                  var6 = var1;
                  var7 = false;
               }
            } else {
               var5 = var2;
               var6 = var1;
               var7 = false;
            }
         } else if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
            new TaxesVentes();
            var8 = this.taxesVentesDao.selectTva(this.selectedExo.getExeprcId(), this.optionsVentes.getTvaDefaut(), var3);
            if (var8 != null) {
               var5 = var8.getTaxvteTaux();
               var6 = var8.getTaxvteCode();
               var38 = var8.getTaxvteType();
            } else {
               var5 = var2;
               var6 = var1;
               var7 = false;
            }
         } else {
            var5 = var2;
            var6 = var1;
            var7 = false;
         }

         if (this.produits != null && this.produits.isProExoTva() || this.tiers.getTiepProdExoTva() != null && !this.tiers.getTiepProdExoTva().isEmpty() && this.tiers.getTiepProdExoTva().contains(this.produits.getProCode())) {
            var5 = 0.0F;
            var6 = "";
            var7 = false;
         }
      }

      this.parcLocationLigne.setPrcllgTaxe(var6);
      this.parcLocationLigne.setPrcllgTauxTaxe(var5);
      double var39 = 0.0D;
      double var10;
      double var12;
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul && this.parcLocationLigne.getPrcllgTva() != 0.0D) {
         var10 = this.parcLocationLigne.getPrcllgTtc();
         var12 = var10 * (double)this.parcLocationEntete.getPrclocTauxTc() / 100.0D;
         var39 = this.utilNombre.myRound((var10 - var12) / (double)this.parcLocationLigne.getPrcllgQte(), Integer.parseInt(this.optionsVentes.getNbDecPu()));
      } else {
         var39 = this.parcLocationLigne.getPrcllgPuTtc();
      }

      var10 = var39 / (double)(1.0F + var5 / 100.0F);
      this.parcLocationLigne.setPrcllgPu(this.utilNombre.myRound(var10, Integer.parseInt(this.optionsVentes.getNbDecPu())));
      var12 = 0.0D;
      if (this.optionsVentes.getDecrmtRabais().equals("1")) {
         var12 = this.parcLocationLigne.getPrcllgRabais();
      } else if (this.optionsVentes.getDecrmtRabais().equals("2")) {
         var12 = this.parcLocationLigne.getPrcllgRabais() * (double)this.parcLocationLigne.getPrcllgQte();
      }

      double var14 = 0.0D;
      if (this.parcLocationLigne.getPrcllgTauxRemise() != 0.0F) {
         var14 = var10 - var10 * (double)this.parcLocationLigne.getPrcllgTauxRemise() / 100.0D - var12;
      } else {
         var14 = var10 - var12;
      }

      double var16 = 0.0D;
      if (this.parcLocationLigne.getPrcllgTauxRemise() != 0.0F) {
         var16 = var39 - var39 * (double)this.parcLocationLigne.getPrcllgTauxRemise() / 100.0D - var12;
      } else {
         var16 = var39 - var12;
      }

      if (this.parcLocationLigne.getPrcllgQte() != 0.0F) {
         if (this.optionsVentes.getModeCalculDevis().equals("1")) {
            this.parcLocationLigne.setPrcllgQteUtil(this.parcLocationLigne.getPrcllgQte());
         } else {
            this.parcLocationLigne.setPrcllgQteUtil(this.calculStock.calculQteUtil(this.produits, this.produitsDepot, this.parcLocationLigne.getPrcllgCondition(), this.parcLocationLigne.getPrcllgQte(), this.parcLocationLigne.getPrcllgLong(), this.parcLocationLigne.getPrcllgLarg(), this.parcLocationLigne.getPrcllgHaut(), this.parcLocationLigne.getPrcllgDiam(), this.parcLocationLigne.getPrcllgNb(), this.baseLog, this.utilInitHibernate, var3));
         }
      } else {
         this.parcLocationLigne.setPrcllgQteUtil(0.0F);
      }

      double var18 = this.utilNombre.myRound(var14, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var20 = this.utilNombre.myRound(var16, Integer.parseInt(this.optionsVentes.getNbDecPu()));
      double var22 = var18 * (double)this.parcLocationLigne.getPrcllgQte();
      double var24 = this.utilNombre.myRound(var22, this.utilNombre.nbDecimal(this.parcLocationEntete.getPrclocDevise()));
      double var26 = var20 * (double)this.parcLocationLigne.getPrcllgQte();
      double var28 = this.utilNombre.myRound(var26, this.utilNombre.nbDecimal(this.parcLocationEntete.getPrclocDevise()));
      double var30 = var28 - var24;
      double var32 = this.utilNombre.myRound(var30, this.utilNombre.nbDecimal(this.parcLocationEntete.getPrclocDevise()));
      this.parcLocationLigne.setPrcllgPuRem(var18);
      this.parcLocationLigne.setPrcllgPuRemTtc(var20);
      this.parcLocationLigne.setPrcllgPt(var24);
      this.parcLocationLigne.setPrcllgTva(var32);
      this.parcLocationLigne.setPrcllgTtc(var28);
      if (this.var_tc_type != 0 && this.var_tc_taux != 0.0F && this.var_tc_calcul) {
         this.parcLocationEntete.setPrclocTauxTc(this.var_tc_taux);
         double var34 = 0.0D;
         double var36 = 0.0D;
         if (this.var_tc_type == 6) {
            var34 = var28 * (double)this.parcLocationEntete.getPrclocTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
            this.parcLocationLigne.setPrcllgTc(var36);
         } else if (this.var_tc_type != 1 && this.var_tc_type != 2 && this.var_tc_type != 7) {
            if (this.var_tc_type == 10) {
               var34 = var24 * (double)this.parcLocationEntete.getPrclocTauxTc() / 100.0D;
               if (this.parcLocationLigne.getPrcllgTauxTaxe() != 0.0F) {
                  var34 = var24 * (double)this.parcLocationEntete.getPrclocTauxTc() / 100.0D;
                  var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
                  double var10000 = var34 + var34 * (double)this.parcLocationLigne.getPrcllgTauxTaxe() / 100.0D;
                  this.parcLocationLigne.setPrcllgTc(var36);
               }
            }
         } else {
            var34 = var24 * (double)this.parcLocationEntete.getPrclocTauxTc() / 100.0D;
            var36 = this.utilNombre.myRoundFormat(var34, this.var_format_devise);
            this.parcLocationLigne.setPrcllgTc(var36);
         }
      } else {
         this.parcLocationLigne.setPrcllgTc(0.0D);
         this.parcLocationEntete.setPrclocTauxTc(0.0F);
      }

      this.parcLocationLigne.setPrcllgPt(this.utilNombre.myRoundDevise(this.parcLocationLigne.getPrcllgPt(), this.parcLocationEntete.getPrclocDevise()));
      this.parcLocationLigne.setPrcllgTva(this.utilNombre.myRoundDevise(this.parcLocationLigne.getPrcllgTva(), this.parcLocationEntete.getPrclocDevise()));
      this.parcLocationLigne.setPrcllgTtc(this.utilNombre.myRoundDevise(this.parcLocationLigne.getPrcllgTtc(), this.parcLocationEntete.getPrclocDevise()));
      this.parcLocationLigne.setPrcllgTc(this.utilNombre.myRoundDevise(this.parcLocationLigne.getPrcllgTc(), this.parcLocationEntete.getPrclocDevise()));
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void calculPrix() throws HibernateException, NamingException, ParseException {
      if (this.parcLocationLigne != null && this.parcLocationLigne.getPrcllgCode() != null && !this.parcLocationLigne.getPrcllgCode().isEmpty()) {
         this.prixUnitaireCorrespond((Session)null);
      } else {
         this.produits = null;
      }

      this.calculPrix(this.parcLocationLigne.getPrcllgTaxe(), this.parcLocationLigne.getPrcllgTauxTaxe(), (Session)null);
      this.griserValider = false;
      if (this.prixPlancher != 0.0D && this.usersLog.getUsrAffPlancher() <= 1) {
         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            if (this.parcLocationLigne.getPrcllgPuRemTtc() != 0.0D) {
               if (this.parcLocationLigne.getPrcllgPuRemTtc() < this.prixPlancher) {
                  this.griserValider = true;
                  this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
                  this.formRecherche.setShowModalPanelMessage(true);
               }
            } else if (this.parcLocationLigne.getPrcllgPuTtc() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.parcLocationLigne.getPrcllgPuRem() != 0.0D) {
            if (this.parcLocationLigne.getPrcllgPuRem() < this.prixPlancher) {
               this.griserValider = true;
               this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
               this.formRecherche.setShowModalPanelMessage(true);
            }
         } else if (this.parcLocationLigne.getPrcllgPu() < this.prixPlancher) {
            this.griserValider = true;
            this.formRecherche.setMessageTexte("Vous êtes en dessous du prix plancher. Veuillez augmenter le prix unitaire.....");
            this.formRecherche.setShowModalPanelMessage(true);
         }
      }

   }

   public void calculPrix(String var1, float var2, Session var3) throws HibernateException, NamingException {
      if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
         this.calculTtc(var1, var2, var3);
      } else {
         this.calculHt(var1, var2, var3);
      }

   }

   public void cumulPrix() {
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = 0.0D;
      double var7 = 0.0D;
      double var9 = 0.0D;
      double var11 = 0.0D;
      if (this.lesLignesList.size() != 0) {
         new ParcLocationLigne();

         for(int var14 = 0; var14 < this.lesLignesList.size(); ++var14) {
            ParcLocationLigne var13 = (ParcLocationLigne)this.lesLignesList.get(var14);
            if (var13.getPrcllgGroupe() == null || var13.getPrcllgGroupe().isEmpty()) {
               var3 += var13.getPrcllgPt();
               var5 += var13.getPrcllgTva();
               var7 += var13.getPrcllgTtc();
               var9 += var13.getPrcllgTc();
               if (var13.getPrcllgRabais() != 0.0D || var13.getPrcllgTauxRemise() != 0.0F) {
                  var11 += var13.getPrcllgPu() * (double)var13.getPrcllgQte() - var13.getPrcllgPt();
               }

               var1 = var1 + var13.getPrcllgPt() - var13.getPrcllgPump() * (double)var13.getPrcllgQte();
            }
         }
      }

      this.var_total_marge = var1;
      this.parcLocationEntete.setPrclocTotHt(var3);
      this.parcLocationEntete.setPrclocTotTva(var5);
      this.parcLocationEntete.setPrclocTotTtc(var7);
      this.parcLocationEntete.setPrclocTotRemise(var11);
      this.parcLocationEntete.setPrclocTotTc(var9);
   }

   public void selectionLigneDetail() throws HibernateException, NamingException {
      this.mesTaxesVentesProduits.clear();
      this.mesUnitesProduits.clear();
      this.mesConditionnementsProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.memoProduits = null;
      if (this.datamodelLigne.isRowAvailable()) {
         this.parcLocationLigne = (ParcLocationLigne)this.datamodelLigne.getRowData();
         this.numLigne = this.clauleNumlLigne() + 1;
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_location");
         if (this.parcLocationLigne.getPrcllgCode() != null && this.parcLocationLigne.getPrcllgCode().length() >= 2 && !this.parcLocationLigne.getPrcllgCode().equalsIgnoreCase("incoterm")) {
            this.produits = this.produitsDao.chargeProduit(this.parcLocationLigne.getPrcllgCode(), var1);
            if (this.produits != null) {
               this.memoProduits = this.produits;
               this.parcLocationLigne.setPrcllgCode(this.produits.getProCode());
               this.parcLocationLigne.setPrcllgFamille(this.produits.getProAchCode());
               this.parcLocationLigne.setPrcllgStock(this.produits.getProStock());
               this.parcLocationLigne.setPrcllgLong(this.produits.getProLongueur());
               this.parcLocationLigne.setPrcllgLarg(this.produits.getProLargeur());
               this.parcLocationLigne.setPrcllgHaut(this.produits.getProEpaisseur());
               this.parcLocationLigne.setPrcllgDiam(this.produits.getProDiamExt());
               this.parcLocationLigne.setPrcllgPoidsBrut(this.produits.getProPoidsBrut());
               this.parcLocationLigne.setPrcllgPoidsNet(this.produits.getProPoidsNet());
               this.parcLocationLigne.setPrcllgVolume(this.produits.getProVolume());
               this.parcLocationLigne.setPrcllgNb(this.produits.getProNbUnite());
               this.var_aff_detail_prod = true;
               if (this.produits.getProImpDesciption() == 1) {
                  if (this.usersLog.getUsrVteLibelle() == 1) {
                     this.verrou_libelle = true;
                  } else {
                     this.verrou_libelle = false;
                  }
               } else {
                  this.verrou_libelle = false;
               }

               if (this.parcLocationLigne.getPrcllgPrintTexte() == 0) {
                  this.printTexte = true;
               } else {
                  this.printTexte = false;
               }

               this.griserchamps = true;
               if (this.parcLocationLigne.getPrcllgTaxe() != null && !this.parcLocationLigne.getPrcllgTaxe().isEmpty()) {
                  this.mesTaxesVentesProduits.add(new SelectItem(this.parcLocationLigne.getPrcllgTaxe(), this.parcLocationLigne.getPrcllgTaxe() + ":" + this.parcLocationLigne.getPrcllgTauxTaxe()));
               } else {
                  this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
               }

               this.mefConditionnementDepot(var1);
               this.selectionDepot(var1);
               new FamillesProduitsVentes();
               FamillesProduitsVentes var4 = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.lastExo.getExeprcId(), this.produits, var1);
               if (var4 != null && var4.getFamvteCoefPv() != 0.0F && this.produitsDepot != null) {
                  float var3 = (100.0F - var4.getFamvteCoefPv()) / 100.0F;
                  this.prixPlancher = this.utilNombre.myRound(this.produitsDepot.getProdepPr() / (double)var3, 2);
               } else {
                  this.prixPlancher = 0.0D;
               }

               this.mesUnitesProduits = this.chargerUniteProduit(var1);
               this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
            }
         } else {
            this.produits = null;
            this.var_aff_detail_prod = false;
            this.verrou_libelle = false;
            this.griserchamps = false;
            this.griserValider = false;
            this.mesTaxesVentesProduits.clear();
            if (this.mesTaxesVentesItems.size() != 0) {
               for(int var2 = 0; var2 < this.mesTaxesVentesItems.size(); ++var2) {
                  this.mesTaxesVentesProduits.add(this.mesTaxesVentesItems.get(var2));
               }
            }

            this.mesUnitesProduits = this.chargerUniteProduit(var1);
            this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         }

         this.formRecherche.setProduits(this.produits);
         this.utilInitHibernate.closeSession();
      } else {
         this.var_aff_detail_prod = false;
         this.verrou_libelle = false;
         this.var_aff_condit = false;
         this.var_aff_unite = false;
         this.griserchamps = false;
         this.griserValider = false;
      }

   }

   public void selectionLigneDetailLight() throws HibernateException, NamingException {
      this.memoProduits = null;
      if (this.datamodelLigne.isRowAvailable()) {
         this.parcLocationLigne = (ParcLocationLigne)this.datamodelLigne.getRowData();
         this.numLigne = this.clauleNumlLigne() + 1;
      } else {
         this.var_aff_detail_prod = false;
         this.verrou_libelle = false;
         this.var_aff_condit = false;
         this.var_aff_unite = false;
         this.griserchamps = false;
         this.griserValider = false;
      }

   }

   public void addLigne() {
      this.produits = new Produits();
      this.memoProduits = new Produits();
      this.parcLocationLigne = new ParcLocationLigne();
      this.mesTaxesVentesProduits = new ArrayList();
      this.mesProduitsDepotsItems = new ArrayList();
      this.mesConditionnementsProduits = new ArrayList();
      this.mesUnitesProduits = new ArrayList();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.verrou_libelle = false;
      this.var_aff_condit = false;
      this.var_aff_unite = false;
      this.var_code_unite = 0;
      this.var_depotProd = "";
      this.prixPlancher = 0.0D;
      this.griserValider = false;
   }

   public void ordonnnerDescendant() throws HibernateException, NamingException {
      this.selectionLigneDetailLight();
      if (this.parcLocationLigne != null) {
         this.numLigne = this.clauleNumlLigne() + 1;
         if (this.numLigne < this.lesLignesList.size()) {
            this.lesLignesList.remove(this.parcLocationLigne);
            this.lesLignesList.add(this.numLigne, this.parcLocationLigne);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_location");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.parcLocationLigne = (ParcLocationLigne)this.lesLignesList.get(var3);
               this.parcLocationLigne.setPrcllgOrdre(var3);
               this.parcLocationLigne = this.parcLocationLigneDao.modifLigne(this.parcLocationLigne, var1);
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

   public void ordonnnerAscendant() throws HibernateException, NamingException {
      this.selectionLigneDetailLight();
      if (this.parcLocationLigne != null) {
         this.numLigne = this.clauleNumlLigne() - 1;
         if (this.numLigne != 0) {
            this.lesLignesList.remove(this.parcLocationLigne);
            this.lesLignesList.add(this.numLigne, this.parcLocationLigne);
            this.datamodelLigne.setWrappedData(this.lesLignesList);
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_location");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();

            for(int var3 = 0; var3 < this.lesLignesList.size(); ++var3) {
               this.parcLocationLigne = (ParcLocationLigne)this.lesLignesList.get(var3);
               this.parcLocationLigne.setPrcllgOrdre(var3);
               this.parcLocationLigne = this.parcLocationLigneDao.modifLigne(this.parcLocationLigne, var1);
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

   public int clauleNumlLigne() {
      int var1 = 0;
      if (this.lesLignesList.size() != 0) {
         for(int var2 = 0; var2 < this.lesLignesList.size(); ++var2) {
            if (this.parcLocationLigne.getPrcllgId() == ((ParcLocationLigne)this.lesLignesList.get(var2)).getPrcllgId()) {
               var1 = var2;
               break;
            }
         }
      }

      return var1;
   }

   public void saveOneLigne() throws IOException, HibernateException, NamingException, Exception {
      if (this.parcLocationLigne.getPrcllgCode() != null && !this.parcLocationLigne.getPrcllgCode().isEmpty() || this.parcLocationLigne.getPrcllgLibelle() != null && !this.parcLocationLigne.getPrcllgLibelle().isEmpty() || this.parcLocationLigne.getPrcllgComplement() != null && !this.parcLocationLigne.getPrcllgComplement().isEmpty()) {
         if (this.parcLocationEntete.getPrclocId() == 0L) {
            this.saveLocation();
         }

         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_location");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            if (this.parcLocationLigne.getPrcllgQteUtil() == 0.0F) {
               this.parcLocationLigne.setPrcllgQteUtil(this.parcLocationLigne.getPrcllgQte());
            }

            this.calculPrix(this.parcLocationLigne.getPrcllgTaxe(), this.parcLocationLigne.getPrcllgTauxTaxe(), var1);
            if (this.var_depotProd != null && this.var_depotProd.contains("=")) {
               String[] var3;
               if (this.var_depotProd.contains(":")) {
                  var3 = this.var_depotProd.split(":");
                  this.parcLocationLigne.setPrcllgDepot(var3[0]);
               } else {
                  var3 = this.var_depotProd.split("=");
                  this.parcLocationLigne.setPrcllgDepot(var3[0]);
               }
            } else {
               this.parcLocationLigne.setPrcllgDepot("");
            }

            if (this.parcLocationLigne.getPrcllgCondition() != null && !this.parcLocationLigne.getPrcllgCondition().isEmpty() && this.parcLocationLigne.getPrcllgCondition().contains(":")) {
               ConditionnementDao var15 = new ConditionnementDao(this.baseLog, this.utilInitHibernate);
               String[] var4 = this.parcLocationLigne.getPrcllgCondition().split(":");
               String var5 = var15.rechercheConditionnement(var4[0], var1).getCdtDescription();
               if (var5 != null && !var5.isEmpty()) {
                  this.parcLocationLigne.setPrcllgDescription(var5);
               } else {
                  this.parcLocationLigne.setPrcllgDescription("");
               }

               if (this.parcLocationLigne.getPrcllgEchelle() == 0) {
                  this.unite = new Unite();
                  this.unite = this.uniteDao.selectUnite(var4[0], var1);
                  if (this.unite != null) {
                     this.parcLocationLigne.setPrcllgEchelle(this.unite.getUniEchelle());
                  }
               }
            } else {
               this.parcLocationLigne.setPrcllgDescription("");
            }

            if (this.printTexte) {
               this.parcLocationLigne.setPrcllgPrintTexte(0);
            } else {
               this.parcLocationLigne.setPrcllgPrintTexte(1);
            }

            if (this.parcLocationLigne.getPrcllgId() == 0L) {
               this.parcLocationLigne.setParcLocationEntete(this.parcLocationEntete);
               this.parcLocationLigne = this.parcLocationLigneDao.insertLigne(this.parcLocationLigne, var1);
               if (this.numLigne == 0) {
                  if (this.lesLignesList.size() != 0) {
                     this.numLigne = this.lesLignesList.size();
                  } else {
                     this.numLigne = 0;
                  }
               }

               this.lesLignesList.add(this.numLigne, this.parcLocationLigne);
               this.datamodelLigne.setWrappedData(this.lesLignesList);
               this.numLigne = this.clauleNumlLigne() + 1;
            } else {
               this.parcLocationLigne = this.parcLocationLigneDao.modifLigne(this.parcLocationLigne, var1);
            }

            if (this.memoProduits != null && this.memoProduits != this.produits && this.memoProduits.getProVteNat() != null && !this.memoProduits.getProVteNat().isEmpty() && !this.memoProduits.getProVteNat().equals("1604") && !this.memoProduits.getProVteNat().equals("1612") && this.parcLocationLigne.getPrcllgCode() != null && !this.parcLocationLigne.getPrcllgCode().isEmpty() && (this.memoProduits.getProMode() == 1 || this.memoProduits.getProMode() == 2)) {
               new ParcLocationLigne();

               for(int var17 = 0; var17 < this.lesLignesList.size(); ++var17) {
                  ParcLocationLigne var16 = (ParcLocationLigne)this.lesLignesList.get(var17);
                  if (var16.getPrcllgGroupe() != null && !var16.getPrcllgGroupe().isEmpty() && var16.getPrcllgGroupe().equals(this.memoProduits.getProCode())) {
                     this.parcLocationLigneDao.deleteOnLigne(var16, var1);
                     this.lesLignesList.remove(var16);
                     --var17;
                  }
               }

               this.datamodelLigne.setWrappedData(this.lesLignesList);
            }

            if (this.produits != null && this.produits.getProVteNat() != null && !this.produits.getProVteNat().isEmpty() && !this.produits.getProVteNat().equals("1604") && !this.produits.getProVteNat().equals("1612") && this.parcLocationLigne.getPrcllgCode() != null && !this.parcLocationLigne.getPrcllgCode().isEmpty() && (this.produits.getProMode() == 1 || this.produits.getProMode() == 2)) {
               String var18 = this.produits.getProCode();
               float var20 = this.parcLocationLigne.getPrcllgQte();
               new ParcLocationLigne();

               ParcLocationLigne var19;
               for(int var6 = 0; var6 < this.lesLignesList.size(); ++var6) {
                  var19 = (ParcLocationLigne)this.lesLignesList.get(var6);
                  if (var19.getPrcllgGroupe() != null && !var19.getPrcllgGroupe().isEmpty() && var19.getPrcllgGroupe().equals(var18)) {
                     this.parcLocationLigneDao.deleteOnLigne(var19, var1);
                     this.lesLignesList.remove(var19);
                     --var6;
                  }
               }

               this.datamodelLigne.setWrappedData(this.lesLignesList);
               new ArrayList();
               ProduitsGrpDao var7 = new ProduitsGrpDao(this.baseLog, this.utilInitHibernate);
               List var21 = var7.selectProdGrpByprod(this.produits, var1);
               if (var21.size() != 0) {
                  for(int var8 = 0; var8 < var21.size(); ++var8) {
                     var19 = new ParcLocationLigne();
                     var19.setPrcllgCode(((ProduitsGrp)var21.get(var8)).getProgrpCode());
                     var19.setPrcllgCondition("");
                     var19.setPrcllgComplement("");
                     var19.setPrcllgDepot(((ProduitsGrp)var21.get(var8)).getProgrpDepot());
                     var19.setPrcllgDescription("");
                     var19.setPrcllgDiam(((ProduitsGrp)var21.get(var8)).getProduits().getProDiamInt());
                     var19.setPrcllgEchelle(0);
                     var19.setPrcllgFamille(((ProduitsGrp)var21.get(var8)).getProduits().getProVteCode());
                     var19.setPrcllgGroupe(var18);
                     var19.setPrcllgHaut(((ProduitsGrp)var21.get(var8)).getProduits().getProEpaisseur());
                     var19.setPrcllgLarg(((ProduitsGrp)var21.get(var8)).getProduits().getProLargeur());
                     var19.setPrcllgLibelle(((ProduitsGrp)var21.get(var8)).getProgrpLibelle());
                     var19.setPrcllgLong(((ProduitsGrp)var21.get(var8)).getProduits().getProLongueur());
                     var19.setPrcllgModeGroupe(((ProduitsGrp)var21.get(var8)).getProduits().getProMode());
                     var19.setPrcllgNb(((ProduitsGrp)var21.get(var8)).getProduits().getProNbUnite());
                     var19.setPrcllgOrdre(var8);
                     var19.setPrcllgPoidsBrut(((ProduitsGrp)var21.get(var8)).getProduits().getProPoidsBrut());
                     var19.setPrcllgPoidsNet(((ProduitsGrp)var21.get(var8)).getProduits().getProPoidsNet());
                     var19.setPrcllgPt(0.0D);
                     var19.setPrcllgPu(0.0D);
                     var19.setPrcllgPuRem(0.0D);
                     var19.setPrcllgPuRemTtc(0.0D);
                     var19.setPrcllgPuTtc(0.0D);
                     var19.setPrcllgPump(0.0D);
                     float var9 = var20 * ((ProduitsGrp)var21.get(var8)).getProgrpQte();
                     var19.setPrcllgQte(var9);
                     var19.setPrcllgQteUtil(var19.getPrcllgQte());
                     var19.setPrcllgRabais(0.0D);
                     var19.setPrcllgReference(var18);
                     var19.setPrcllgStock(((ProduitsGrp)var21.get(var8)).getProduits().getProStock());
                     var19.setPrcllgTauxRemise(0.0F);
                     var19.setPrcllgTauxTaxe(0.0F);
                     var19.setPrcllgTaxe("");
                     var19.setPrcllgTc(0.0D);
                     var19.setPrcllgTtc(0.0D);
                     var19.setPrcllgTva(0.0D);
                     var19.setPrcllgUnite(((ProduitsGrp)var21.get(var8)).getProgrpUnite());
                     var19.setPrcllgVolume(0.0F);
                     var19.setParcLocationEntete(this.parcLocationEntete);
                     var19 = this.parcLocationLigneDao.insertLigne(var19, var1);
                     if (this.numLigne > this.lesLignesList.size()) {
                        this.numLigne = this.lesLignesList.size();
                     }

                     this.lesLignesList.add(this.numLigne + var8, var19);
                  }
               }

               this.datamodelLigne.setWrappedData(this.lesLignesList);
            }

            this.cumulPrix();
            this.parcLocationEntete = this.parcLocationEnteteDao.modif(this.parcLocationEntete, var1);
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

   public void deleteLigneSelect() throws HibernateException, NamingException {
      if (this.parcLocationLigne.getPrcllgId() != 0L) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_location");
         Transaction var2 = null;

         try {
            var2 = var1.beginTransaction();
            String var3 = this.parcLocationLigne.getPrcllgCode();
            int var4 = this.parcLocationLigne.getPrcllgModeGroupe();
            String var5 = this.parcLocationLigne.getPrcllgGroupe();
            this.parcLocationLigneDao.deleteOnLigne(this.parcLocationLigne, var1);
            if ((var4 == 1 || var4 == 2) && (var5 == null || var5.isEmpty())) {
               new ParcLocationLigne();

               for(int var7 = 0; var7 < this.lesLignesList.size(); ++var7) {
                  ParcLocationLigne var6 = (ParcLocationLigne)this.lesLignesList.get(var7);
                  if (var6.getPrcllgGroupe() != null && !var6.getPrcllgGroupe().isEmpty() && var6.getPrcllgGroupe().equals(var3)) {
                     this.parcLocationLigneDao.deleteOnLigne(var6, var1);
                  }
               }
            }

            this.var_aff_detail_prod = false;
            Espion var13 = new Espion();
            var13.setUsers(this.usersLog);
            var13.setEsptype(0);
            var13.setEspdtecreat(new Date());
            var13.setEspaction("Suppression ligne produit " + var3 + " du Location N° " + this.parcLocationEntete.getPrclocNum() + " du " + this.parcLocationEntete.getPrclocDate());
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

         this.chargerDocumentLigne((Session)null);
         this.addLigne();
         this.cumulPrix();
         if (this.lesLignesList.size() != 0) {
            this.numLigne = this.lesLignesList.size();
         } else {
            this.numLigne = 0;
         }
      }

   }

   public void rechercheProduits() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      if (this.parcLocationLigne.getPrcllgCode() != null && !this.parcLocationLigne.getPrcllgCode().isEmpty()) {
         if (!this.parcLocationLigne.getPrcllgCode().equals("-") && !this.parcLocationLigne.getPrcllgCode().equals("=") && !this.parcLocationLigne.getPrcllgCode().equalsIgnoreCase("incoterm")) {
            if (this.tiers.getTiedepot() != null && !this.tiers.getTiedepot().isEmpty() && this.tiers.getTiedepot().contains(":")) {
               this.produits = this.formRecherche.rechercheProduitVenteHorsGenerique(this.tiers.getTiedepot(), this.parcLocationLigne.getPrcllgCode(), this.nature, this.optionsVentes);
            } else {
               this.produits = this.formRecherche.rechercheProduitVenteHorsGenerique(this.parcLocationLigne.getPrcllgCode(), this.nature, this.optionsVentes);
            }

            if (this.produits != null) {
               if (this.produits.getProId() != 0L) {
                  this.calculeProduits();
               } else {
                  this.var_action = 15;
               }
            } else if (this.produits == null) {
               this.calculeProduits();
            }
         } else {
            this.parcLocationLigne.setPrcllgCode(this.parcLocationLigne.getPrcllgCode().toUpperCase());
         }
      }

   }

   public void recuperationProduit() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.produits = this.formRecherche.calculeProduit();
      this.calculeProduits();
   }

   public void calculeProduits() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      if (this.produits != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Parc_location");
         this.parcLocationLigne.setPrcllgCode(this.produits.getProCode());
         String var2;
         String var3;
         if (this.optionsVentes.getLibProduit().equals("2") && this.produits.getProLibTech() != null && !this.produits.getProLibTech().isEmpty()) {
            if (this.optionsVentes.getLibelleProduit().equals("0")) {
               this.parcLocationLigne.setPrcllgLibelle(this.produits.getProLibTech().toUpperCase());
            } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
               var2 = this.produits.getProLibTech().substring(0, 1).toUpperCase();
               var3 = this.produits.getProLibTech().substring(1, this.produits.getProLibTech().length()).toLowerCase();
               this.parcLocationLigne.setPrcllgLibelle(var2 + var3);
            } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
               this.parcLocationLigne.setPrcllgLibelle(this.produits.getProLibTech().toLowerCase());
            }
         } else if (this.optionsVentes.getLibelleProduit().equals("0")) {
            this.parcLocationLigne.setPrcllgLibelle(this.produits.getProLibClient().toUpperCase());
         } else if (this.optionsVentes.getLibelleProduit().equals("1")) {
            var2 = this.produits.getProLibClient().substring(0, 1).toUpperCase();
            var3 = this.produits.getProLibClient().substring(1, this.produits.getProLibClient().length()).toLowerCase();
            this.parcLocationLigne.setPrcllgLibelle(var2 + var3);
         } else if (this.optionsVentes.getLibelleProduit().equals("2")) {
            this.parcLocationLigne.setPrcllgLibelle(this.produits.getProLibClient().toLowerCase());
         }

         this.parcLocationLigne.setPrcllgFamille(this.produits.getProVteCode());
         this.parcLocationLigne.setPrcllgStock(this.produits.getProStock());
         this.parcLocationLigne.setPrcllgLong(this.produits.getProLongueur());
         this.parcLocationLigne.setPrcllgLarg(this.produits.getProLargeur());
         this.parcLocationLigne.setPrcllgHaut(this.produits.getProEpaisseur());
         this.parcLocationLigne.setPrcllgDiam(this.produits.getProDiamExt());
         this.parcLocationLigne.setPrcllgPoidsBrut(this.produits.getProPoidsBrut());
         this.parcLocationLigne.setPrcllgPoidsNet(this.produits.getProPoidsNet());
         this.parcLocationLigne.setPrcllgVolume(this.produits.getProVolume());
         this.parcLocationLigne.setPrcllgNb(this.produits.getProNbUnite());
         this.parcLocationLigne.setPrcllgReference(this.produitsFournisseurDao.selectProdReference(this.produits, var1));
         this.parcLocationLigne.setPrcllgModeGroupe(this.produits.getProMode());
         if (this.produits.getProImpDesciption() == 1) {
            if (this.usersLog.getUsrVteLibelle() == 1) {
               this.verrou_libelle = true;
            } else {
               this.verrou_libelle = false;
            }
         } else {
            this.verrou_libelle = false;
         }

         this.printTexte = true;
         this.mesTaxesVentesProduits.clear();
         new FamillesProduitsVentes();
         FamillesProduitsVentes var8 = this.famillesProduitsVentesDao.rechercheFamilleByProd(this.lastExo.getExeprcId(), this.produits, var1);
         if (!this.produits.isProExoTva() && (this.tiers.getTiepProdExoTva() == null || this.tiers.getTiepProdExoTva().isEmpty() || !this.tiers.getTiepProdExoTva().contains(this.produits.getProCode()))) {
            TaxesVentes var9;
            if (this.produits.getProVteTva() != null && !this.produits.getProVteTva().isEmpty() && !this.produits.getProVteTva().equals("0")) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExo.getExeprcId(), this.produits.getProVteTva(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(this.produits.getProVteTva(), this.produits.getProVteTva() + ":" + var9.getTaxvteTaux()));
                  this.parcLocationLigne.setPrcllgTaxe(this.produits.getProVteTva());
                  this.parcLocationLigne.setPrcllgTauxTaxe(var9.getTaxvteTaux());
               } else {
                  this.parcLocationLigne.setPrcllgTaxe("");
                  this.parcLocationLigne.setPrcllgTauxTaxe(0.0F);
                  this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
               }
            } else if (var8 != null && var8.getFamvteTaxe() != null && !var8.getFamvteTaxe().isEmpty() && !var8.getFamvteTaxe().equals("0")) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExo.getExeprcId(), var8.getFamvteTaxe(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var8.getFamvteTaxe(), var8.getFamvteTaxe() + ":" + var9.getTaxvteTaux()));
                  this.parcLocationLigne.setPrcllgTaxe(var8.getFamvteTaxe());
                  this.parcLocationLigne.setPrcllgTauxTaxe(var9.getTaxvteTaux());
               }
            } else {
               this.parcLocationLigne.setPrcllgTaxe("");
               this.parcLocationLigne.setPrcllgTauxTaxe(0.0F);
               this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
            }

            if (this.parcLocationEntete.getPrclocExoTva() == 0 && (this.parcLocationLigne.getPrcllgTaxe() == null || this.parcLocationLigne.getPrcllgTaxe().isEmpty()) && this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
               new TaxesVentes();
               var9 = this.taxesVentesDao.selectTva(this.lastExo.getExeprcId(), this.optionsVentes.getTvaDefaut(), var1);
               if (var9 != null) {
                  this.mesTaxesVentesProduits.add(new SelectItem(var9.getTaxvteCode(), var9.getTaxvteCode() + ":" + var9.getTaxvteTaux()));
                  this.parcLocationLigne.setPrcllgTaxe(var9.getTaxvteCode());
                  this.parcLocationLigne.setPrcllgTauxTaxe(var9.getTaxvteTaux());
               }
            }
         } else {
            this.parcLocationLigne.setPrcllgTaxe("");
            this.parcLocationLigne.setPrcllgTauxTaxe(0.0F);
            this.mesTaxesVentesProduits.add(new SelectItem(0, ""));
         }

         this.mefConditionnementDepot(var1);
         this.selectionDepot(var1);
         if (var8 != null && var8.getFamvteCoefPv() != 0.0F && this.produitsDepot != null) {
            float var10 = (100.0F - var8.getFamvteCoefPv()) / 100.0F;
            if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               double var4 = this.produitsDepot.getProdepPr() / (double)var10;
               double var6 = var4 + var4 * (double)this.parcLocationLigne.getPrcllgTauxTaxe() / 100.0D;
               this.prixPlancher = this.utilNombre.myRound(var6, 2);
            } else {
               this.prixPlancher = this.utilNombre.myRound(this.produitsDepot.getProdepPr() / (double)var10, 2);
            }
         } else {
            this.prixPlancher = 0.0D;
         }

         if (this.produitsDepot != null) {
            this.mesUnitesProduits = this.chargerUniteProduit(var1);
            if (this.produitsDepot.getProdepUnite() != null && !this.produitsDepot.getProdepUnite().isEmpty()) {
               this.parcLocationLigne.setPrcllgUnite(this.produitsDepot.getProdepUnite());
            } else {
               this.parcLocationLigne.setPrcllgUnite("");
            }
         } else {
            this.produitsDepot = null;
            this.mesUnitesProduits.clear();
            this.parcLocationLigne.setPrcllgUnite("");
         }

         this.mesConditionnementsProduits = this.chargerConditionnementProduit(var1);
         this.parcLocationLigne.setPrcllgCondition("");
         if (this.mesConditionnementsProduits.size() != 0) {
            this.parcLocationLigne.setPrcllgCondition(((SelectItem)this.mesConditionnementsProduits.get(0)).getLabel().toString());
            this.selectionDepot(var1);
         }

         this.prixUnitaireCorrespond(var1);
         if (this.var_pr_pv && this.parcLocationLigne.getPrcllgPump() != 0.0D) {
            this.parcLocationLigne.setPrcllgPu(this.parcLocationLigne.getPrcllgPump());
         }

         this.griserchamps = true;
         this.var_aff_detail_prod = true;
         this.calculPrix(this.parcLocationLigne.getPrcllgTaxe(), this.parcLocationLigne.getPrcllgTauxTaxe(), var1);
         this.utilInitHibernate.closeSession();
      } else {
         this.annuleProduits();
      }

      this.var_action = this.var_memo_action;
   }

   public void detailProduit() {
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

   public void annuleDetailProduit() {
      this.var_action = this.var_memo_action;
   }

   public void calculTva() {
      if (this.parcLocationLigne.getPrcllgCode() == null || this.parcLocationLigne.getPrcllgCode().isEmpty() || this.parcLocationLigne.getPrcllgCode().length() < 2) {
         if (this.parcLocationEntete.getPrclocExoTva() == 0 && this.tiers.getTiefacpr() <= 1 && this.tiers.getTieexotva() == 0) {
            if (this.mesTaxesVentesProduits.isEmpty()) {
               this.mesTaxesVentesProduits.clear();
               if (this.mesTaxesVentesItems.size() != 0) {
                  for(int var1 = 0; var1 < this.mesTaxesVentesItems.size(); ++var1) {
                     this.mesTaxesVentesProduits.add(this.mesTaxesVentesItems.get(var1));
                  }
               }

               if (this.optionsVentes.getTvaDefaut() != null && !this.optionsVentes.getTvaDefaut().isEmpty()) {
                  this.parcLocationLigne.setPrcllgTaxe(this.optionsVentes.getTvaDefaut());
               }
            }
         } else {
            this.mesTaxesVentesProduits.clear();
         }
      }

   }

   public void annuleProduits() {
      this.produits = null;
      this.produitsDepot = null;
      this.parcLocationLigne.setPrcllgCode("");
      this.parcLocationLigne.setPrcllgLibelle("");
      this.mesTaxesVentesProduits.clear();
      this.mesProduitsDepotsItems.clear();
      this.mesConditionnementsProduits.clear();
      this.mesUnitesProduits.clear();
      this.griserchamps = false;
      this.var_aff_detail_prod = false;
      this.verrou_libelle = false;
      this.var_aff_condit = false;
      this.var_aff_unite = false;
      this.printTexte = false;
      this.var_code_unite = 0;
      this.prixPlancher = 0.0D;
      this.griserValider = false;
      this.var_action = this.var_memo_action;
   }

   public void mefConditionnementDepot(Session var1) throws HibernateException, NamingException {
      this.mesProduitsDepotsItems.clear();
      this.listeProduitDepot.clear();
      if (this.var_sansstock && this.produits.getProStock() != 0) {
         String var2 = this.parcLocationLigne.getPrcllgCondition();
         if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
            if (var2.contains("/")) {
               String[] var3 = var2.split("/");
               String var4 = var3[1];
               String[] var5 = var4.split(":");
               this.unite = this.uniteDao.selectUnite(var5[1], var1);
               if (this.unite != null) {
                  this.parcLocationLigne.setPrcllgEchelle(this.unite.getUniEchelle());
               } else {
                  this.parcLocationLigne.setPrcllgEchelle(this.produitsDepot.getProdepEchelle());
               }
            } else {
               this.parcLocationLigne.setPrcllgEchelle(this.produitsDepot.getProdepEchelle());
            }
         } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
            this.parcLocationLigne.setPrcllgEchelle(Integer.parseInt(var2));
         } else {
            this.parcLocationLigne.setPrcllgEchelle(0);
         }

         this.listeProduitDepot = this.produitsDepotDao.selectProdDepByprod(this.produits, 23, var1);
         if (this.listeProduitDepot.size() != 0) {
            for(int var10 = 0; var10 < this.listeProduitDepot.size(); ++var10) {
               ProduitsDepot var11 = (ProduitsDepot)this.listeProduitDepot.get(var10);
               float var12 = 0.0F;
               if (this.optionsVentes.getChoixStock().equals("1")) {
                  var12 = var11.getProdepQteStk() - var11.getProdepQteAttVte();
               } else {
                  var12 = var11.getProdepQteStk();
               }

               String var6 = "";
               int var7;
               if (var2 != null && !var2.isEmpty() && var2.contains(":")) {
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.parcLocationLigne.getPrcllgLong(), this.parcLocationLigne.getPrcllgLarg(), this.parcLocationLigne.getPrcllgHaut(), this.parcLocationLigne.getPrcllgDiam(), this.parcLocationLigne.getPrcllgNb(), this.baseLog, var1);
                  var7 = (int)var12;
                  var6 = "" + var7;
               } else if (var2 != null && !var2.isEmpty() && !var2.contains(":")) {
                  var12 = this.calculStock.calculQteUtilMultiple(this.produits, this.produitsDepot, var2, var12, this.parcLocationLigne.getPrcllgLong(), this.parcLocationLigne.getPrcllgLarg(), this.parcLocationLigne.getPrcllgHaut(), this.parcLocationLigne.getPrcllgDiam(), this.parcLocationLigne.getPrcllgNb(), this.baseLog, var1);
                  var7 = (int)var12;
                  var6 = "" + var7;
               } else {
                  var6 = "" + var12;
               }

               String[] var13;
               if (this.tiers.getTiedepot() != null && !this.tiers.getTiedepot().isEmpty() && this.tiers.getTiedepot().contains(":")) {
                  var13 = this.tiers.getTiedepot().split(":");
                  if (var11.getDepot().getDpoCode().equals(var13[0])) {
                     if (var11.getProdepCasier() != null && !var11.getProdepCasier().isEmpty()) {
                        this.mesProduitsDepotsItems.add(new SelectItem(var11.getDepot().getDpoCode() + ":" + var11.getDepot().getDpoLibelle() + ":" + var11.getProdepCasier() + "=" + var6));
                     } else {
                        this.mesProduitsDepotsItems.add(new SelectItem(var11.getDepot().getDpoCode() + ":" + var11.getDepot().getDpoLibelle() + "=" + var6));
                     }
                  }
               } else if (this.verrouDepotUser != null && !this.verrouDepotUser.isEmpty()) {
                  if (!this.verrouDepotUser.contains(",")) {
                     if (var11.getDepot().getDpoCode().equals(this.verrouDepotUser)) {
                        if (var11.getProdepCasier() != null && !var11.getProdepCasier().isEmpty()) {
                           this.mesProduitsDepotsItems.add(new SelectItem(var11.getDepot().getDpoCode() + ":" + var11.getDepot().getDpoLibelle() + ":" + var11.getProdepCasier() + "=" + var6));
                        } else {
                           this.mesProduitsDepotsItems.add(new SelectItem(var11.getDepot().getDpoCode() + ":" + var11.getDepot().getDpoLibelle() + "=" + var6));
                        }
                     }
                  } else {
                     var13 = this.verrouDepotUser.split(",");
                     int var8 = var13.length;

                     for(int var9 = 0; var9 < var8; ++var9) {
                        if (var11.getDepot().getDpoCode().equals(var13[var9])) {
                           if (var11.getProdepCasier() != null && !var11.getProdepCasier().isEmpty()) {
                              this.mesProduitsDepotsItems.add(new SelectItem(var11.getDepot().getDpoCode() + ":" + var11.getDepot().getDpoLibelle() + ":" + var11.getProdepCasier() + "=" + var6));
                              break;
                           }

                           this.mesProduitsDepotsItems.add(new SelectItem(var11.getDepot().getDpoCode() + ":" + var11.getDepot().getDpoLibelle() + "=" + var6));
                           break;
                        }
                     }
                  }
               } else if (var11.getProdepCasier() != null && !var11.getProdepCasier().isEmpty()) {
                  this.mesProduitsDepotsItems.add(new SelectItem(var11.getDepot().getDpoCode() + ":" + var11.getDepot().getDpoLibelle() + ":" + var11.getProdepCasier() + "=" + var6));
               } else {
                  this.mesProduitsDepotsItems.add(new SelectItem(var11.getDepot().getDpoCode() + ":" + var11.getDepot().getDpoLibelle() + "=" + var6));
               }
            }
         }
      }

   }

   public List chargerUniteProduit(Session var1) {
      this.mesUnitesProduits.clear();
      if (this.produits != null && this.produitsDepot != null && this.produitsDepot.getProdepUnite() != null && !this.produitsDepot.getProdepUnite().isEmpty()) {
         this.mesUnitesProduits.add(new SelectItem(this.produitsDepot.getProdepUnite()));
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
      this.mesConditionnementsProduits = this.calculStock.calculConditionnementVentes(this.mesConditionnementsItems, this.produits, this.produitsDepot, var1);
      if (this.mesConditionnementsProduits.size() != 0) {
         this.var_aff_condit = true;
      } else {
         this.var_aff_condit = false;
      }

      return this.mesConditionnementsProduits;
   }

   public void selectionDepot() throws HibernateException, NamingException {
      this.selectionDepot((Session)null);
      this.mesUnitesProduits = this.chargerUniteProduit((Session)null);
      this.parcLocationLigne.setPrcllgUnite(this.produitsDepot.getProdepUnite());
   }

   public void selectionDepot(Session var1) throws HibernateException, NamingException {
      if (this.produits != null) {
         if (this.mesProduitsDepotsItems.size() != 0) {
            if (this.var_depotProd == null || this.var_depotProd.isEmpty()) {
               this.var_depotProd = ((SelectItem)this.mesProduitsDepotsItems.get(0)).getLabel();
            }

            String[] var2 = null;
            if (this.var_depotProd.contains(":")) {
               var2 = this.var_depotProd.split(":");
            } else {
               var2 = this.var_depotProd.split("=");
            }

            String var3 = var2[0];
            this.produitsDepot = this.produitsDepotDao.produitDepByprod(this.produits.getProCode(), var3, var1);
            if (this.produitsDepot == null) {
               this.produitsDepot = null;
               this.var_depotProd = "";
               this.var_code_unite = 0;
            } else {
               this.var_code_unite = this.produitsDepot.getProdepEchelle();
            }
         } else {
            this.produitsDepot = null;
            this.var_depotProd = "";
            this.var_code_unite = 0;
         }
      } else {
         this.produitsDepot = null;
         this.var_depotProd = "";
         this.var_code_unite = 0;
      }

      if (this.produitsDepot != null) {
         double var9 = 0.0D;
         float var4;
         if (this.parcLocationLigne.getPrcllgCondition() != null && !this.parcLocationLigne.getPrcllgCondition().isEmpty() && this.parcLocationLigne.getPrcllgCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.parcLocationLigne.getPrcllgEchelle());
            float var5 = 1.0F;
            if (this.parcLocationLigne.getPrcllgCondition().contains("/")) {
               String[] var6 = this.parcLocationLigne.getPrcllgCondition().split("/");
               String var7 = var6[1];
               String[] var8 = var7.split(":");
               var5 = Float.parseFloat(var8[0]);
            }

            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4 * (double)var5, 2);
         } else if (this.parcLocationLigne.getPrcllgCondition() != null && !this.parcLocationLigne.getPrcllgCondition().isEmpty() && !this.parcLocationLigne.getPrcllgCondition().contains(":")) {
            var4 = this.calculStock.calculCoefConversion(this.produitsDepot.getProdepEchelle(), this.parcLocationLigne.getPrcllgEchelle());
            var9 = this.utilNombre.myRound(this.produitsDepot.getProdepPump() / (double)var4, 2);
         } else {
            var9 = this.produitsDepot.getProdepPump();
         }

         this.parcLocationLigne.setPrcllgPump(var9);
      } else {
         this.parcLocationLigne.setPrcllgPump(0.0D);
      }

   }

   public void prixUnitaireCorrespond(Session var1) throws HibernateException, NamingException, ParseException {
      if (this.produits != null) {
         double var2 = 0.0D;
         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            var2 = this.parcLocationLigne.getPrcllgPuTtc();
         } else {
            var2 = this.parcLocationLigne.getPrcllgPu();
         }

         if (this.produits.getProMode() == 4) {
            this.prixUnitaires = this.prixCalculeAuto();
         } else {
            this.prixUnitaireDegressif(true, var1);
         }

         if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
            this.parcLocationLigne.setPrcllgPuTtc(this.prixUnitaires);
            this.parcLocationLigne.setPrcllgPuRemTtc(this.prixUnitaires);
         } else {
            this.parcLocationLigne.setPrcllgPu(this.prixUnitaires);
            this.parcLocationLigne.setPrcllgPuRem(this.prixUnitaires);
         }

         double var4 = 0.0D;
         if (this.verifBareme) {
            Baremes var6 = new Baremes();
            Baremes var7 = new Baremes();
            new ArrayList();
            List var8 = this.baremesDao.rechercheToutBaremeProduit(this.tiers.getTieid(), this.produits.getProCode(), this.produits.getProVteCode(), this.tiers.getTienomfamille(), var1);
            if (var8.size() != 0) {
               int var9;
               for(var9 = 0; var9 < var8.size(); ++var9) {
                  var6 = (Baremes)var8.get(var9);
                  if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && var6.getBarIdTiers() == this.tiers.getTieid() && var6.getBarCodeProduit() != null && !var6.getBarCodeProduit().isEmpty() && var6.getBarCodeProduit().equals(this.produits.getProCode())) {
                     var4 = var6.getBarPrix();
                     var7 = var6;
                     break;
                  }
               }

               if (var4 == 0.0D) {
                  for(var9 = 0; var9 < var8.size(); ++var9) {
                     var6 = (Baremes)var8.get(var9);
                     if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && var6.getBarCategorieTiers() != null && !var6.getBarCategorieTiers().isEmpty() && var6.getBarCategorieTiers().equals(this.tiers.getTiecategorie()) && var6.getBarCodeProduit() != null && !var6.getBarCodeProduit().isEmpty() && var6.getBarCodeProduit().equals(this.produits.getProCode())) {
                        var4 = var6.getBarPrix();
                        var7 = var6;
                        break;
                     }
                  }
               }

               if (var4 == 0.0D) {
                  for(var9 = 0; var9 < var8.size(); ++var9) {
                     var6 = (Baremes)var8.get(var9);
                     if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && var6.getBarIdTiers() == this.tiers.getTieid() && var6.getBarCodeVte() != null && !var6.getBarCodeVte().isEmpty() && var6.getBarCodeVte().equals(this.produits.getProVteCode())) {
                        var4 = var6.getBarPrix();
                        var7 = var6;
                        break;
                     }
                  }
               }

               if (var4 == 0.0D) {
                  for(var9 = 0; var9 < var8.size(); ++var9) {
                     var6 = (Baremes)var8.get(var9);
                     if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && var6.getBarCategorieTiers() != null && !var6.getBarCategorieTiers().isEmpty() && var6.getBarCategorieTiers().equals(this.tiers.getTiecategorie()) && var6.getBarCodeVte() != null && !var6.getBarCodeVte().isEmpty() && var6.getBarCodeVte().equals(this.produits.getProVteCode())) {
                        var4 = var6.getBarPrix();
                        var7 = var6;
                        break;
                     }
                  }
               }

               if (var4 == 0.0D) {
                  for(var9 = 0; var9 < var8.size(); ++var9) {
                     var6 = (Baremes)var8.get(var9);
                     if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && (var6.getBarCategorieTiers() == null || var6.getBarCategorieTiers().isEmpty()) && var6.getBarIdTiers() == 0L && var6.getBarCodeProduit() != null && !var6.getBarCodeProduit().isEmpty() && var6.getBarCodeProduit().equals(this.produits.getProCode())) {
                        var4 = var6.getBarPrix();
                        var7 = var6;
                        break;
                     }
                  }
               }

               if (var4 == 0.0D) {
                  for(var9 = 0; var9 < var8.size(); ++var9) {
                     var6 = (Baremes)var8.get(var9);
                     if ((var6.getBarDateDebut() == null && var6.getBarDateFin() == null || var6.getBarDateDebut() != null && this.var_date.compareTo(var6.getBarDateDebut()) >= 0 && var6.getBarDateFin() != null && this.var_date.compareTo(var6.getBarDateFin()) <= 0) && (var6.getBarCategorieTiers() == null || var6.getBarCategorieTiers().isEmpty()) && var6.getBarIdTiers() == 0L && var6.getBarCodeVte() != null && !var6.getBarCodeVte().isEmpty() && var6.getBarCodeVte().equals(this.produits.getProVteCode())) {
                        var4 = var6.getBarPrix();
                        var7 = var6;
                        break;
                     }
                  }
               }

               if (var4 != 0.0D) {
                  this.prixUnitaires = var4;
               }

               if (var7 != null && var7.getBarId() != 0L) {
                  double var11;
                  if (var6.getBarRemise() != 0.0F) {
                     this.parcLocationLigne.setPrcllgTauxRemise(var6.getBarRemise());
                     this.parcLocationLigne.setPrcllgRabais(var6.getBarRabais());
                     var11 = 0.0D;
                     var11 = this.prixUnitaires - this.utilNombre.myRoundDevise(this.prixUnitaires * (double)var6.getBarRemise() / 100.0D, this.parcLocationEntete.getPrclocDevise());
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.parcLocationLigne.setPrcllgPuTtc(this.prixUnitaires);
                        this.parcLocationLigne.setPrcllgPuRemTtc(var11);
                     } else {
                        this.parcLocationLigne.setPrcllgPu(this.prixUnitaires);
                        this.parcLocationLigne.setPrcllgPuRem(var11);
                     }
                  } else if (var6.getBarRabais() != 0.0D) {
                     this.parcLocationLigne.setPrcllgTauxRemise(var6.getBarRemise());
                     this.parcLocationLigne.setPrcllgRabais(var6.getBarRabais());
                     var11 = 0.0D;
                     if (this.optionsVentes.getDecrmtRabais().equals("2")) {
                        var11 = this.prixUnitaires - var6.getBarRabais() * (double)this.parcLocationLigne.getPrcllgQte();
                     } else {
                        var11 = this.prixUnitaires - var6.getBarRabais();
                     }

                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.parcLocationLigne.setPrcllgPuTtc(this.prixUnitaires);
                        this.parcLocationLigne.setPrcllgPuRemTtc(var11);
                     } else {
                        this.parcLocationLigne.setPrcllgPu(this.prixUnitaires);
                        this.parcLocationLigne.setPrcllgPuRem(var11);
                     }
                  } else if (var6.getBarPrix() != 0.0D) {
                     this.parcLocationLigne.setPrcllgTauxRemise(var6.getBarRemise());
                     this.parcLocationLigne.setPrcllgRabais(var6.getBarRabais());
                     this.prixUnitaires = var6.getBarPrix();
                     if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                        this.parcLocationLigne.setPrcllgPuTtc(this.prixUnitaires);
                        this.parcLocationLigne.setPrcllgPuRemTtc(this.prixUnitaires);
                     } else {
                        this.parcLocationLigne.setPrcllgPu(this.prixUnitaires);
                        this.parcLocationLigne.setPrcllgPuRem(this.prixUnitaires);
                     }
                  }
               }

               if (this.prixUnitaires == 0.0D) {
                  this.prixUnitaires = var2;
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.parcLocationLigne.setPrcllgPuTtc(this.prixUnitaires);
                     this.parcLocationLigne.setPrcllgPuRemTtc(this.prixUnitaires);
                  } else {
                     this.parcLocationLigne.setPrcllgPu(this.prixUnitaires);
                     this.parcLocationLigne.setPrcllgPuRem(this.prixUnitaires);
                  }
               }
            }
         }
      }

   }

   public double prixCalculeAuto() {
      double var1 = 0.0D;
      this.prixUnitaires = 0.0D;
      if (this.produits.getProFormule() != null && !this.produits.getProFormule().isEmpty() && this.produits.getProFormule().contains("=")) {
         String[] var3 = this.produits.getProFormule().split("=");
         String var4 = var3[0];
         double var5 = 0.0D;
         if (var4 != null && !var4.isEmpty() && var4.equals("TAUX")) {
            double var10 = Double.parseDouble(var3[1]);

            for(int var9 = 0; var9 < this.lesLignesList.size() && (((ParcLocationLigne)this.lesLignesList.get(var9)).getPrcllgCode() == null || ((ParcLocationLigne)this.lesLignesList.get(var9)).getPrcllgCode().isEmpty() || !((ParcLocationLigne)this.lesLignesList.get(var9)).getPrcllgCode().equals(this.produits.getProCode())); ++var9) {
               var5 += ((ParcLocationLigne)this.lesLignesList.get(var9)).getPrcllgPt();
            }

            this.prixUnitaires = this.utilNombre.myRoundDevise(var5 * var10 / 100.0D, this.structureLog.getStrdevise());
         } else if (var4 != null && !var4.isEmpty() && var4.equals("CUMUL_DEBOURS")) {
            String var7 = var3[1];

            for(int var8 = 0; var8 < this.lesLignesList.size(); ++var8) {
               if (((ParcLocationLigne)this.lesLignesList.get(var8)).getPrcllgFamille() != null && !((ParcLocationLigne)this.lesLignesList.get(var8)).getPrcllgFamille().isEmpty() && ((ParcLocationLigne)this.lesLignesList.get(var8)).getPrcllgFamille().equals(var7)) {
                  var5 += ((ParcLocationLigne)this.lesLignesList.get(var8)).getPrcllgPt();
               }
            }

            this.prixUnitaires = var5;
         }
      } else {
         this.prixUnitaires = 0.0D;
      }

      var1 = this.prixUnitaires;
      return var1;
   }

   public String prixUnitaireDegressif(boolean var1, Session var2) throws HibernateException, NamingException {
      String var3 = "";
      if (this.produits != null) {
         double var4 = this.parcLocationLigne.getPrcllgPu();
         double var6 = this.parcLocationLigne.getPrcllgPuTtc();
         if (this.parcLocationLigne.getPrcllgPu() >= 0.0D && this.parcLocationLigne.getPrcllgPuTtc() >= 0.0D) {
            var4 = this.parcLocationLigne.getPrcllgPu();
            var6 = this.parcLocationLigne.getPrcllgPuTtc();
            new ProduitsTarif();
            if (this.produitsTarifdao == null) {
               this.produitsTarifdao = new ProduitsTarifDao(this.baseLog, this.utilInitHibernate);
            }

            ProduitsTarif var8 = this.produitsTarifdao.prixUnitaireCorrespond(this.produits.getProId(), this.parcLocationEntete.getPrclocCat(), (String)null, var2);
            if (var8 != null) {
               new ObjetTarif();
               if (var8.getProtarTarifQte() != null && !var8.getProtarTarifQte().isEmpty()) {
                  double var10 = 0.0D;
                  ObjetTarif var9;
                  String[] var12;
                  if (!var8.getProtarTarifQte().contains("#")) {
                     var12 = var8.getProtarTarifQte().split(":");
                     var9 = new ObjetTarif();
                     var9.setQteDebut(Float.parseFloat(var12[0]));
                     var9.setQteFin(Float.parseFloat(var12[1]));
                     var9.setPrix(Double.parseDouble(var12[2]));
                     if (var1) {
                        if (var3 != null && !var3.isEmpty()) {
                           if (var9.getQteFin() != 0.0F) {
                              var3 = var3 + " / de " + this.utilNombre.beginQte(var9.getQteDebut(), this.optionsVentes.getNbDecQte()) + " à " + this.utilNombre.beginQte(var9.getQteFin(), this.optionsVentes.getNbDecQte()) + " pcs : " + this.utilNombre.beginSimple(var9.getPrix(), this.parcLocationEntete.getPrclocDevise());
                           } else {
                              var3 = var3 + " / + de " + this.utilNombre.beginQte(var9.getQteDebut(), this.optionsVentes.getNbDecQte()) + " pcs : " + this.utilNombre.beginSimple(var9.getPrix(), this.parcLocationEntete.getPrclocDevise());
                           }
                        } else if (var9.getQteDebut() == 0.0F) {
                           var3 = "de 1 à " + this.utilNombre.beginQte(var9.getQteFin(), this.optionsVentes.getNbDecQte()) + " pcs : " + this.utilNombre.beginSimple(var9.getPrix(), this.parcLocationEntete.getPrclocDevise());
                        } else {
                           var3 = "de " + this.utilNombre.beginQte(var9.getQteDebut(), this.optionsVentes.getNbDecQte()) + " à " + this.utilNombre.beginQte(var9.getQteFin(), this.optionsVentes.getNbDecQte()) + " pcs : " + this.utilNombre.beginSimple(var9.getPrix(), this.parcLocationEntete.getPrclocDevise());
                        }
                     }

                     if (var9.getQteFin() != 0.0F) {
                        if (this.parcLocationLigne.getPrcllgQte() >= var9.getQteDebut() && this.parcLocationLigne.getPrcllgQte() <= var9.getQteFin()) {
                           var10 = var9.getPrix();
                        }
                     } else if (this.parcLocationLigne.getPrcllgQte() >= var9.getQteDebut()) {
                        var10 = var9.getPrix();
                     }
                  } else {
                     var12 = var8.getProtarTarifQte().split("#");
                     int var13 = var12.length;

                     for(int var14 = 0; var14 < var13; ++var14) {
                        String[] var15 = var12[var14].split(":");
                        var9 = new ObjetTarif();
                        var9.setQteDebut(Float.parseFloat(var15[0]));
                        var9.setQteFin(Float.parseFloat(var15[1]));
                        var9.setPrix(Double.parseDouble(var15[2]));
                        if (var1) {
                           if (var3 != null && !var3.isEmpty()) {
                              if (var9.getQteFin() != 0.0F) {
                                 var3 = var3 + " / de " + this.utilNombre.beginQte(var9.getQteDebut(), this.optionsVentes.getNbDecQte()) + " à " + this.utilNombre.beginQte(var9.getQteFin(), this.optionsVentes.getNbDecQte()) + " pcs : " + this.utilNombre.beginSimple(var9.getPrix(), this.parcLocationEntete.getPrclocDevise());
                              } else {
                                 var3 = var3 + " / + de " + this.utilNombre.beginQte(var9.getQteDebut(), this.optionsVentes.getNbDecQte()) + " pcs : " + this.utilNombre.beginSimple(var9.getPrix(), this.parcLocationEntete.getPrclocDevise());
                              }
                           } else if (var9.getQteDebut() == 0.0F) {
                              var3 = "de 1 à " + this.utilNombre.beginQte(var9.getQteFin(), this.optionsVentes.getNbDecQte()) + " pcs : " + this.utilNombre.beginSimple(var9.getPrix(), this.parcLocationEntete.getPrclocDevise());
                           } else {
                              var3 = "de " + this.utilNombre.beginQte(var9.getQteDebut(), this.optionsVentes.getNbDecQte()) + " à " + this.utilNombre.beginQte(var9.getQteFin(), this.optionsVentes.getNbDecQte()) + " pcs : " + this.utilNombre.beginSimple(var9.getPrix(), this.parcLocationEntete.getPrclocDevise());
                           }
                        }

                        if (var9.getQteFin() != 0.0F) {
                           if (this.parcLocationLigne.getPrcllgQte() >= var9.getQteDebut() && this.parcLocationLigne.getPrcllgQte() <= var9.getQteFin()) {
                              var10 = var9.getPrix();
                           }
                        } else if (this.parcLocationLigne.getPrcllgQte() >= var9.getQteDebut()) {
                           var10 = var9.getPrix();
                        }
                     }
                  }

                  if (var10 != 0.0D) {
                     this.prixUnitaires = var10;
                  } else {
                     this.prixUnitaires = var8.getProtarPv();
                  }
               } else {
                  this.prixUnitaires = var8.getProtarPv();
               }

               if (this.prixUnitaires == 0.0D) {
                  if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
                     this.prixUnitaires = var6;
                  } else {
                     this.prixUnitaires = var4;
                  }
               }
            } else if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               this.prixUnitaires = var6;
            } else {
               this.prixUnitaires = var4;
            }
         } else {
            var4 = Math.abs(this.parcLocationLigne.getPrcllgPu());
            var6 = Math.abs(this.parcLocationLigne.getPrcllgPuTtc());
            if (this.optionsVentes.getDecrmtPriVteStock().equals("2")) {
               this.prixUnitaires = var6;
            } else {
               this.prixUnitaires = var4;
            }
         }
      }

      return var3;
   }

   public void rechercheTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.tiers = this.formRecherche.rechercheTiers(3, this.parcLocationEntete.getPrclocNomClient(), this.nature);
      if (this.tiers != null) {
         if (this.tiers.getTieid() != 0L) {
            this.calculeTiers();
         } else {
            this.var_action = 9;
         }
      } else if (this.tiers == null) {
         this.calculeTiers();
      }

   }

   public void recuperationTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      this.tiers = this.formRecherche.calculeTiers();
      this.calculeTiers();
   }

   public void calculeTiers() throws JDOMException, IOException, HibernateException, NamingException, ParseException {
      if (this.tiers != null) {
         Session var1 = this.utilInitHibernate.getOpenSession(this.baseLog, "Tiers");
         boolean var2 = false;
         if (this.tiers.getTieserie() != null && !this.tiers.getTieserie().isEmpty()) {
            if (this.tiers.getTieserie().equals("X")) {
               var2 = true;
            } else {
               for(int var3 = 0; var3 < this.mesSerieUserItem.size(); ++var3) {
                  if (((SelectItem)this.mesSerieUserItem.get(var3)).getValue().toString().equals(this.tiers.getTieserie())) {
                     var2 = true;
                     this.parcLocationEntete.setPrclocSerie(this.tiers.getTieserie());
                     break;
                  }
               }
            }
         } else {
            var2 = true;
         }

         if (!var2) {
            this.annuleTiers();
         } else {
            this.parcLocationEntete.setTiers(this.tiers);
            if (!this.tiers.getTiegenre().equalsIgnoreCase("010") && !this.tiers.getTiegenre().equalsIgnoreCase("020") && !this.tiers.getTiegenre().equalsIgnoreCase("030") && !this.tiers.getTiegenre().equalsIgnoreCase("037")) {
               this.nomTier = this.tiers.getTieraisonsocialenom();
               this.parcLocationEntete.setPrclocCivilTiers("");
               this.var_typeTiers = true;
            } else {
               if (this.tiers.getTieprenom() != null && !this.tiers.getTieprenom().isEmpty()) {
                  this.nomTier = this.tiers.getTieraisonsocialenom() + " " + this.tiers.getTieprenom();
               } else {
                  this.nomTier = this.tiers.getTieraisonsocialenom();
               }

               this.parcLocationEntete.setPrclocCivilTiers(this.parcLocationEntete.getTiers().getTiecivilite());
               this.var_typeTiers = false;
            }

            this.parcLocationEntete.setPrclocNomClient(this.nomTier);
            this.parcLocationEntete.setPrclocTypeReg(this.tiers.getTietypereg());
            this.parcLocationEntete.setPrclocModeReg(this.tiers.getTiemodereg());
            this.calculMessageLitige();
            String var5 = "";
            if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && this.tiers.getTiemodereg().contains(":")) {
               String[] var4 = this.tiers.getTiemodereg().split(":");
               var5 = var4[0];
            } else if (this.tiers.getTiemodereg() != null && !this.tiers.getTiemodereg().isEmpty() && !this.tiers.getTiemodereg().contains(":")) {
               var5 = this.tiers.getTiemodereg();
            }

            this.parcLocationEntete.setPrclocExoDouane(this.tiers.getTieexodouane());
            if (this.tiers.getTieexodouane() == 1) {
               this.parcLocationEntete.setPrclocExoDouane(1);
            }

            int var6 = this.tiers.getTieexotva();
            if (var6 >= 2) {
               var6 = 0;
            }

            this.parcLocationEntete.setPrclocExoTva(var6);
            if (this.var_tc_calcul) {
               this.parcLocationEntete.setPrclocTauxTc(this.var_tc_taux);
            } else {
               this.parcLocationEntete.setPrclocTauxTc(0.0F);
            }

            if (this.structureLog.getStrcodepays().equals("0077")) {
               this.var_tc_type = 1;
               if (this.tiers.getTiecss() == 0) {
                  this.var_tc_calcul = true;
               } else {
                  this.var_tc_calcul = false;
               }
            } else {
               this.var_tc_calcul = false;
               this.var_tc_type = 0;
            }

            if (this.tiers.getTiefacpr() == 2 || this.tiers.getTieexotva() == 1) {
               this.parcLocationEntete.setPrclocExoTva(1);
            }

            if (this.tiers.getTiecategorie().equalsIgnoreCase("Client Divers")) {
               this.parcLocationEntete.setPrclocDiversTiers(99);
               this.var_pr_pv = false;
            } else {
               this.parcLocationEntete.setPrclocDiversTiers(0);
               this.parcLocationEntete.setPrclocDiversNom("");
               this.parcLocationEntete.setPrclocDiversAdresse("");
               this.parcLocationEntete.setPrclocDiversVille("");
               this.parcLocationEntete.setPrclocDiversTel("");
               this.parcLocationEntete.setPrclocDiversMail("");
               if (this.tiers.getTiefacpr() == 0) {
                  this.var_pr_pv = false;
               } else {
                  this.var_pr_pv = true;
               }
            }

            if (!"".equals(this.tiers.getTiedevise()) && this.tiers.getTiedevise() != null) {
               this.parcLocationEntete.setPrclocDevise(this.tiers.getTiedevise());
            } else {
               this.parcLocationEntete.setPrclocDevise(this.structureLog.getStrdevise());
            }

            this.mesContactItem.clear();
            this.chargerLesContactsItem(var1);
         }

         this.utilInitHibernate.closeSession();
      } else {
         this.annuleTiers();
      }

      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void calculMessageLitige() {
      this.informationsTiers = null;
      if (this.tiers != null) {
         String var1 = "";
         if (this.tiers.getTiecomptebloque() == 1) {
            var1 = "***   COMPTE BLOQUE   ***";
         } else if (this.tiers.getTiechequeinterdit() == 1) {
            var1 = "***   CHEQUE INTERDIT   ***";
         }

         String var2 = this.tiers.getTieobservations();
         if (var1 != null && !var1.isEmpty()) {
            this.informationsTiers = var1;
         }

         if (var2 != null && !var2.isEmpty()) {
            if (this.informationsTiers != null && !this.informationsTiers.isEmpty()) {
               this.informationsTiers = this.informationsTiers + " (" + var2 + ")";
            } else {
               this.informationsTiers = "(" + var2 + ")";
            }
         }
      }

   }

   public void annuleTiers() throws ParseException {
      this.tiers = null;
      this.informationsTiers = null;
      this.parcLocationEntete.setTiers(this.tiers);
      this.parcLocationEntete.setPrclocNomClient("");
      this.parcLocationEntete.setPrclocCivilTiers("");
      this.mesContactItem.clear();
      this.mesContactItem.add(new SelectItem(0, ""));
      this.controleSaisie();
      this.var_action = this.var_memo_action;
   }

   public void chargerLesContactsItem(Session var1) throws HibernateException, NamingException {
      this.mesContactItem = new ArrayList();
      this.mesContactItem = this.contactDao.chargerLesContactsItems(this.tiers.getTieid(), var1);
   }

   public void controleSaisie() throws ParseException {
      if (!this.parcLocationEntete.getPrclocNomClient().equals("") && this.tiers.getTieid() != 0L) {
         this.var_valide_doc = true;
         this.var_aff_detail_tiers = true;
      } else {
         this.var_valide_doc = false;
         this.var_aff_detail_tiers = false;
      }

   }

   public void recupererEltCat() throws HibernateException, NamingException {
      String var1 = "";
      String var2 = "";
      if (this.lesFamilleClientsListe.size() != 0) {
         for(int var3 = 0; var3 < this.lesFamilleClientsListe.size(); ++var3) {
            if (this.parcLocationEntete.getPrclocCat().equalsIgnoreCase(((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getLibelle())) {
               var1 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getExoTva();
               var2 = ((ObjetFamilleTiers)this.lesFamilleClientsListe.get(var3)).getExoDouane();
               break;
            }
         }
      }

      if (!var1.equalsIgnoreCase("true") && this.tiers.getTiefacpr() != 2 && this.tiers.getTieexotva() != 1) {
         this.parcLocationEntete.setPrclocExoTva(0);
      } else {
         this.parcLocationEntete.setPrclocExoTva(1);
      }

      if (!var2.equalsIgnoreCase("true") && this.tiers.getTieexodouane() != 1) {
         this.parcLocationEntete.setPrclocExoDouane(0);
      } else {
         this.parcLocationEntete.setPrclocExoDouane(1);
      }

      if (this.var_tc_calcul) {
         this.parcLocationEntete.setPrclocTauxTc(this.var_tc_taux);
      } else {
         this.parcLocationEntete.setPrclocTauxTc(0.0F);
      }

   }

   public void detailTiers() {
      this.formRecherche.setNature(this.nature);
      this.var_action = 12;
   }

   public void annuleDetailTiers() {
      this.var_action = this.var_memo_action;
   }

   public void modifTiers() {
      this.var_aff_detail_tiers = false;
   }

   public void ajouterContact() throws JDOMException, IOException, HibernateException, NamingException {
      if (this.tiers != null && this.tiers.getTieid() != 0L) {
         this.formRecherche.rechercheContacts(this.tiers, this.nature);
         this.var_action = 16;
      }

   }

   public void annulerContact() {
      this.var_action = this.var_memo_action;
   }

   public void recuperationContact() throws JDOMException, IOException {
      this.mesContactItem = this.formRecherche.calculeContactItems();
      if (this.mesContactItem == null || this.mesContactItem.size() == 0) {
         this.mesContactItem.clear();
         this.mesContactItem.add(new SelectItem(0, ""));
      }

      this.var_action = this.var_memo_action;
   }

   public void calculReceptionnaire(Session var1) throws HibernateException, NamingException {
      this.mesReceptionnairesItems.clear();
      if (this.parcLocationEntete.getPrclocService() != null && !this.parcLocationEntete.getPrclocService().isEmpty()) {
         UserDao var2 = new UserDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var3 = var2.chargerLesUsersByServices(this.parcLocationEntete.getPrclocService(), var1);
         if (var3.size() != 0) {
            for(int var4 = 0; var4 < var3.size(); ++var4) {
               this.mesReceptionnairesItems.add(new SelectItem(((Users)var3.get(var4)).getUsrid(), ((Users)var3.get(var4)).getUsrPatronyme()));
            }
         }
      }

   }

   public void chargerDetailanalytique() {
      this.totalImputation = 0.0D;
      this.soldeImputation = 0.0D;
      this.lesDecoupagesActivites.clear();
      if (this.decoupageActivite && this.parcLocationEntete.getPrclocActivite() != null && !this.parcLocationEntete.getPrclocActivite().isEmpty() && this.parcLocationEntete.getPrclocActivite().contains(":")) {
         String[] var1 = null;
         if (!this.parcLocationEntete.getPrclocActivite().contains("#")) {
            var1 = this.parcLocationEntete.getPrclocActivite().split(":");
            if (var1.length == 7) {
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
               this.totalImputation += this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
               this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
            }
         } else {
            String[] var2 = this.parcLocationEntete.getPrclocActivite().split("#");

            for(int var3 = 0; var3 < var2.length; ++var3) {
               var1 = var2[var3].split(":");
               if (var1.length == 7) {
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
                  this.totalImputation += this.ecrituresAnalytiqueCtrl.getEcranaMontantSaisie();
                  this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
               }
            }
         }
      }

      this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
   }

   public void chargerDocumentLigne(Session var1) throws HibernateException, NamingException {
      this.lesLignesList.clear();
      if (this.parcLocationEntete.getPrclocId() > 0L) {
         this.lesLignesList = this.parcLocationLigneDao.chargerLesLignes(this.parcLocationEntete, var1);
      }

      this.datamodelLigne.setWrappedData(this.lesLignesList);
   }

   public void chargerDocumentScan() throws IOException {
      this.lesDocuments.clear();
      if (this.nomRepertoire != null && !this.nomRepertoire.isEmpty()) {
         File var1 = new File(this.nomRepertoire);
         if (!var1.exists()) {
            var1.mkdir();
         }

         String var2 = this.parcLocationEntete.getPrclocNum().replace("/", "_");
         String[] var3 = var1.list();
         if (var3 != null) {
            var3 = this.triAlphabetique(var3, var3.length);

            for(int var4 = 0; var4 < var3.length; ++var4) {
               if ((var3[var4].endsWith(".pdf") || var3[var4].endsWith(".PDF")) && var3[var4].startsWith(var2)) {
                  this.lesDocuments.add(var3[var4]);
               }
            }
         }
      }

      this.dataModelDocumnts.setWrappedData(this.lesDocuments);
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
      if (this.lesDecoupagesActivites.size() != 0) {
         for(int var1 = 0; var1 < this.lesDecoupagesActivites.size(); ++var1) {
            this.totalImputation += (double)((EcrituresAnalytiqueCtrl)this.lesDecoupagesActivites.get(var1)).getEcranaPourcentage();
         }
      }

      this.soldeImputation = 100.0D - this.totalImputation;
      if (this.soldeImputation > 0.0D) {
         this.ecrituresAnalytiqueCtrl = new EcrituresAnalytiqueCtrl();
         this.lesDecoupagesActivites.add(this.ecrituresAnalytiqueCtrl);
         this.dataModelDecoupageActivtes.setWrappedData(this.lesDecoupagesActivites);
      }

   }

   public void rechercheParc() throws JDOMException, IOException, HibernateException, NamingException {
      this.parc = this.formRecherche.rechercheParc(this.immatriculation, this.nature);
      if (this.parc != null) {
         if (this.parc.getPrcId() != 0L) {
            this.calculeParc();
         } else {
            this.var_memo_action = this.var_action;
            this.var_action = 10;
         }
      } else if (this.parc == null) {
         this.calculeParc();
      }

   }

   public void recuperationParc() throws JDOMException, IOException, HibernateException, NamingException {
      this.parc = this.formRecherche.calculeParc();
      this.calculeParc();
   }

   public void calculeParc() throws JDOMException, IOException, HibernateException, NamingException {
      this.var_saisie_pu = false;
      if (this.parc != null) {
         if (this.parc.getPrcAlimentation() != 0 && this.parc.getPrcAlimentation() != 1 && this.parc.getPrcAlimentation() != 2 && this.parc.getPrcAlimentation() != 3 && this.parc.getPrcAlimentation() != 4 && this.parc.getPrcAlimentation() != 5 && this.parc.getPrcAlimentation() != 6 && this.parc.getPrcAlimentation() != 7 && this.parc.getPrcAlimentation() != 8 && this.parc.getPrcAlimentation() != 9 && this.parc.getPrcAlimentation() != 10 && this.parc.getPrcAlimentation() != 11 && this.parc.getPrcAlimentation() == 12) {
         }

         this.immatriculation = this.parc.getPrcImmatriculation();
         this.typeCompteur = this.parc.getLibCompteur();
         this.tiers = this.parcLocationEntete.getTiers();
         this.var_valide_parc = true;
      } else {
         this.parc = null;
         this.tiers = null;
         this.immatriculation = "";
         this.typeCompteur = "";
         this.var_valide_parc = false;
      }

      this.var_action = this.var_memo_action;
   }

   public void annuleParc() {
      this.parc = null;
      this.tiers = null;
      this.immatriculation = "";
      this.typeCompteur = "";
      this.var_action = 0;
      this.var_valide_parc = false;
      this.var_action = this.var_memo_action;
   }

   public void ajouterDocumentScan() {
      this.uploadedPDFFile = null;
      if (this.utilDownload == null) {
         this.utilDownload = new UtilDownload();
      }

      this.nomDocument = "";
      this.showModalPanelAjoutFile = true;
   }

   public void annulerDocumentScan() {
      this.showModalPanelAjoutFile = false;
   }

   public void validerDocumentScan() {
      if (this.parcLocationEntete != null && this.uploadedPDFFile != null) {
         File var1 = new File(this.nomRepertoire + this.parcLocationEntete.getPrclocNum());
         if (var1.exists()) {
            var1.delete();
         }

         FacesContext var2 = FacesContext.getCurrentInstance();

         try {
            if (this.utilDownload == null) {
               this.utilDownload = new UtilDownload();
            }

            String var3 = this.utilDownload.trimFilePath(this.uploadedPDFFile.getName().trim());
            String var4 = var3.substring(var3.indexOf(".") + 1);
            if (this.nomDocument != null && !this.nomDocument.isEmpty()) {
               var3 = this.parcLocationEntete.getPrclocNum().replace("/", "_") + "_" + this.filtreCaracteres(this.nomDocument) + "." + var4;
            } else {
               var3 = this.parcLocationEntete.getPrclocNum().replace("/", "_") + "." + var4;
            }

            File var5 = this.utilDownload.uniqueFile(new File(this.nomRepertoire), var3);
            this.utilDownload.write(var5, this.uploadedPDFFile.getInputStream());
            this.pdfFileName = var3;
            this.lesDocuments.add(this.pdfFileName);
            this.dataModelDocumnts.setWrappedData(this.lesDocuments);
            var2.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_INFO, "File upload succeed!", (String)null));
         } catch (IOException var6) {
            var2.addMessage("uploadForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "File upload failed with I/O error.", (String)null));
            var6.printStackTrace();
         }
      }

      this.showModalPanelAjoutFile = false;
   }

   public String filtreCaracteres(String var1) {
      String var2 = "";
      String var3 = "";

      for(int var4 = 0; var4 < var1.length(); ++var4) {
         var3 = (String)var1.subSequence(var4, var4 + 1);
         if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz:=,1234567890".contains(var3)) {
            var2 = var2 + var3.toUpperCase();
         } else if (var3.equals(" ")) {
            var2 = var2 + "_";
         }
      }

      return var2;
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

   public void lectureDoc() throws MalformedURLException, IOException {
      if (this.dataModelDocumnts.isRowAvailable()) {
         String var1 = (String)this.dataModelDocumnts.getRowData();
         if (var1.endsWith(".pdf") || var1.endsWith(".PDF")) {
            this.nomDocument = var1;
            String var2 = this.nomRepertoire + var1;
            if (var2 != null && !var2.isEmpty()) {
               this.consulterDocumentScan(var2);
            }
         }
      }

   }

   public void consulterDocumentScan(String var1) throws MalformedURLException, IOException {
      if (var1 != null && !var1.isEmpty()) {
         this.utilDownload = new UtilDownload();
         this.fichierUrl = this.utilDownload.convertirFichierUtl(var1, this.urlExplorateur);
         this.fichierMine = this.utilDownload.calculeTypeMine(var1);
         this.showModalPanelPj = true;
      }

   }

   public void fermerVisuDocumentScan() {
      this.showModalPanelPj = false;
   }

   public void supprimerDocumentScan() {
      if (this.nomDocument != null && !this.nomDocument.isEmpty() && this.nomRepertoire != null && !this.nomRepertoire.isEmpty()) {
         String var1 = this.nomRepertoire + this.nomDocument;
         File var2 = new File(var1);
         var2.delete();
         this.lesDocuments.remove(this.nomDocument);
         this.dataModelDocumnts.setWrappedData(this.lesDocuments);
         this.showModalPanelPj = false;
      }

   }

   public String calculeCheminRapport(String var1, int var2) {
      String var3 = "";
      if (var2 == 6) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "ticket" + File.separator;
      } else if (var2 == 7) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "commission" + File.separator;
      } else if (var2 == 8) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "simulation" + File.separator;
      } else if (var2 == 9) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "contrat" + File.separator;
      } else if (var2 == 20) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "besoin" + File.separator;
      } else if (var2 == 21) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "devis" + File.separator;
      } else if (var2 == 22) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "commande" + File.separator;
      } else if (var2 == 23) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "livraison" + File.separator;
      } else if (var2 == 24) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "retour" + File.separator;
      } else if (var2 == 25) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "facture" + File.separator;
      } else if (var2 == 26) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "avoir" + File.separator;
      } else if (var2 == 27) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "note_de_debit" + File.separator;
      } else if (var2 == 28) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "chargement" + File.separator;
      } else if (var2 == 29) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "bon_encaissement" + File.separator;
      } else if (var2 == 140) {
         var3 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "document" + File.separator + "contratVente" + File.separator;
      }

      return var3;
   }

   public String calculeCheminSousRapport(String var1) {
      String var2 = StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + var1 + File.separator + "impression" + File.separator + "fr" + File.separator + "ventes" + File.separator + "sous_rapport" + File.separator;
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
            var4 = new File(this.calculeCheminSousRapport(var1) + "formatAvoir.jpg");
            if (var4.exists()) {
               var3 = "formatAvoir.jpg";
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
         var4 = new File(this.calculeCheminSousRapport(var1) + "formatAvoir.jpg");
         if (var4.exists()) {
            var3 = "formatAvoir.jpg";
         }
      }

      return var3;
   }

   public JRBeanCollectionDataSource calculeImpressionCommun() throws IOException, HibernateException, NamingException {
      this.montant_lettre = this.utilNombre.begin(this.parcLocationEntete.getPrclocPv(), this.structureLog.getStrdevise());
      JRBeanCollectionDataSource var1 = new JRBeanCollectionDataSource(this.calculeImpressionListe());
      return var1;
   }

   public List calculeImpressionListe() throws IOException, HibernateException, NamingException {
      ArrayList var1 = new ArrayList();
      return var1;
   }

   public String calculeParc(Session var1) throws HibernateException, NamingException {
      String var2 = "";
      new Parc();
      Parc var3;
      if (this.parcLocationEntete.getPrclocAnal2() != null && !this.parcLocationEntete.getPrclocAnal2().isEmpty()) {
         String var4 = "";
         if (this.parcLocationEntete.getPrclocAnal2().contains(":")) {
            String[] var5 = this.parcLocationEntete.getPrclocAnal2().split(":");
            var4 = var5[0];
         } else {
            var4 = this.parcLocationEntete.getPrclocAnal2();
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
      return var2;
   }

   public void choixDeviseImpression(String var1, float var2) {
      this.devisePrint = var1;
      this.tauxPrint = var2;
   }

   public void impression(UtilPrint var1, int var2, int var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11) throws HibernateException, NamingException, SQLException, JRException, IOException, ClassNotFoundException, MalformedURLException, Exception {
      if (var2 == 0) {
         if (var4 != null && !var4.isEmpty()) {
         }
      } else if (var2 == 1 && var5 != null && !var5.isEmpty()) {
      }

   }

   public String getUrlIpProd() {
      return StaticModePegase.getUrlIp();
   }

   public ExercicesParc getLastExo() {
      return this.lastExo;
   }

   public void setLastExo(ExercicesParc var1) {
      this.lastExo = var1;
   }

   public int getNature() {
      return this.nature;
   }

   public void setNature(int var1) {
      this.nature = var1;
   }

   public OptionParcs getOptionParcs() {
      return this.optionParcs;
   }

   public void setOptionParcs(OptionParcs var1) {
      this.optionParcs = var1;
   }

   public ExercicesParc getSelectedExo() {
      return this.selectedExo;
   }

   public void setSelectedExo(ExercicesParc var1) {
      this.selectedExo = var1;
   }

   public int getVar_action() {
      return this.var_action;
   }

   public void setVar_action(int var1) {
      this.var_action = var1;
   }

   public DataModel getDataModelConsommations() {
      return this.dataModelOrEntete;
   }

   public void setDataModelConsommations(DataModel var1) {
      this.dataModelOrEntete = var1;
   }

   public ParcLocationEntete getParcLocationEntete() {
      return this.parcLocationEntete;
   }

   public void setParcLocationEntete(ParcLocationEntete var1) {
      this.parcLocationEntete = var1;
   }

   public UtilNombre getUtilNombre() {
      return this.utilNombre;
   }

   public void setUtilNombre(UtilNombre var1) {
      this.utilNombre = var1;
   }

   public boolean isVar_affiche_bouton() {
      return this.var_affiche_bouton;
   }

   public void setVar_affiche_bouton(boolean var1) {
      this.var_affiche_bouton = var1;
   }

   public UtilDate getUtilDate() {
      return this.utilDate;
   }

   public void setUtilDate(UtilDate var1) {
      this.utilDate = var1;
   }

   public List getMesOnglets() {
      return this.mesOnglets;
   }

   public void setMesOnglets(List var1) {
      this.mesOnglets = var1;
   }

   public boolean isVar_acc_affectation() {
      return this.var_acc_affectation;
   }

   public void setVar_acc_affectation(boolean var1) {
      this.var_acc_affectation = var1;
   }

   public boolean isVar_acc_descriptif() {
      return this.var_acc_descriptif;
   }

   public void setVar_acc_descriptif(boolean var1) {
      this.var_acc_descriptif = var1;
   }

   public boolean isVar_acc_etat() {
      return this.var_acc_etat;
   }

   public void setVar_acc_etat(boolean var1) {
      this.var_acc_etat = var1;
   }

   public boolean isVar_ajt() {
      return this.var_ajt;
   }

   public void setVar_ajt(boolean var1) {
      this.var_ajt = var1;
   }

   public boolean isVar_imp() {
      return this.var_imp;
   }

   public void setVar_imp(boolean var1) {
      this.var_imp = var1;
   }

   public boolean isVar_mod() {
      return this.var_mod;
   }

   public void setVar_mod(boolean var1) {
      this.var_mod = var1;
   }

   public boolean isVar_sup() {
      return this.var_sup;
   }

   public void setVar_sup(boolean var1) {
      this.var_sup = var1;
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

   public int getNbDecGraph() {
      return this.nbDecGraph;
   }

   public void setNbDecGraph(int var1) {
      this.nbDecGraph = var1;
   }

   public boolean isVar_aff_action() {
      return this.var_aff_action;
   }

   public void setVar_aff_action(boolean var1) {
      this.var_aff_action = var1;
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

   public Parc getParc() {
      return this.parc;
   }

   public void setParc(Parc var1) {
      this.parc = var1;
   }

   public FormRecherche getFormRecherche() {
      return this.formRecherche;
   }

   public void setFormRecherche(FormRecherche var1) {
      this.formRecherche = var1;
   }

   public boolean isVar_valide_parc() {
      return this.var_valide_parc;
   }

   public void setVar_valide_parc(boolean var1) {
      this.var_valide_parc = var1;
   }

   public boolean isVar_saisie_pu() {
      return this.var_saisie_pu;
   }

   public void setVar_saisie_pu(boolean var1) {
      this.var_saisie_pu = var1;
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

   public double getSoldeImputation() {
      return this.soldeImputation;
   }

   public void setSoldeImputation(double var1) {
      this.soldeImputation = var1;
   }

   public double getTotalImputation() {
      return this.totalImputation;
   }

   public void setTotalImputation(double var1) {
      this.totalImputation = var1;
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

   public List getMesActivitesItems() {
      return this.mesActivitesItems;
   }

   public void setMesActivitesItems(List var1) {
      this.mesActivitesItems = var1;
   }

   public List getMesDemandeursItems() {
      return this.mesReceptionnairesItems;
   }

   public void setMesDemandeursItems(List var1) {
      this.mesReceptionnairesItems = var1;
   }

   public String getPageIndex() {
      return this.pageIndex;
   }

   public void setPageIndex(String var1) {
      this.pageIndex = var1;
   }

   public UsersChrono getUsersChrono() {
      return this.usersChrono;
   }

   public void setUsersChrono(UsersChrono var1) {
      this.usersChrono = var1;
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

   public DataModel getDataModelOrEntete() {
      return this.dataModelOrEntete;
   }

   public void setDataModelOrEntete(DataModel var1) {
      this.dataModelOrEntete = var1;
   }

   public List getMesReceptionnairesItems() {
      return this.mesReceptionnairesItems;
   }

   public void setMesReceptionnairesItems(List var1) {
      this.mesReceptionnairesItems = var1;
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

   public String getInpCaisse() {
      return this.inpCaisse;
   }

   public void setInpCaisse(String var1) {
      this.inpCaisse = var1;
   }

   public String getInpCat() {
      return this.inpCat;
   }

   public void setInpCat(String var1) {
      this.inpCat = var1;
   }

   public String getInpChauffeur() {
      return this.inpChauffeur;
   }

   public void setInpChauffeur(String var1) {
      this.inpChauffeur = var1;
   }

   public String getInpDepartement() {
      return this.inpDepartement;
   }

   public void setInpDepartement(String var1) {
      this.inpDepartement = var1;
   }

   public String getInpDestinataire() {
      return this.inpDestinataire;
   }

   public void setInpDestinataire(String var1) {
      this.inpDestinataire = var1;
   }

   public String getInpDossier() {
      return this.inpDossier;
   }

   public void setInpDossier(String var1) {
      this.inpDossier = var1;
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

   public String getInpParc() {
      return this.inpParc;
   }

   public void setInpParc(String var1) {
      this.inpParc = var1;
   }

   public String getInpPdv() {
      return this.inpPdv;
   }

   public void setInpPdv(String var1) {
      this.inpPdv = var1;
   }

   public String getInpReceptionnaire() {
      return this.inpReceptionnaire;
   }

   public void setInpReceptionnaire(String var1) {
      this.inpReceptionnaire = var1;
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

   public boolean isVar_more_search() {
      return this.var_more_search;
   }

   public void setVar_more_search(boolean var1) {
      this.var_more_search = var1;
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

   public int getVar_timbre() {
      return this.var_timbre;
   }

   public void setVar_timbre(int var1) {
      this.var_timbre = var1;
   }

   public List getMesSerieUserItem() {
      return this.mesSerieUserItem;
   }

   public void setMesSerieUserItem(List var1) {
      this.mesSerieUserItem = var1;
   }

   public Habilitation getHabilitation() {
      return this.habilitation;
   }

   public void setHabilitation(Habilitation var1) {
      this.habilitation = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public boolean isVar_anal_activite() {
      return this.var_anal_activite;
   }

   public void setVar_anal_activite(boolean var1) {
      this.var_anal_activite = var1;
   }

   public boolean isVar_anal_dossier() {
      return this.var_anal_dossier;
   }

   public void setVar_anal_dossier(boolean var1) {
      this.var_anal_dossier = var1;
   }

   public boolean isVar_anal_parc() {
      return this.var_anal_parc;
   }

   public void setVar_anal_parc(boolean var1) {
      this.var_anal_parc = var1;
   }

   public String getImmatriculation() {
      return this.immatriculation;
   }

   public void setImmatriculation(String var1) {
      this.immatriculation = var1;
   }

   public String getTypeCompteur() {
      return this.typeCompteur;
   }

   public void setTypeCompteur(String var1) {
      this.typeCompteur = var1;
   }

   public boolean isAffichagePump() {
      return this.affichagePump;
   }

   public void setAffichagePump(boolean var1) {
      this.affichagePump = var1;
   }

   public boolean isVar_aff_detail_prod() {
      return this.var_aff_detail_prod;
   }

   public void setVar_aff_detail_prod(boolean var1) {
      this.var_aff_detail_prod = var1;
   }

   public String getUrlphotoProd() {
      return this.urlphotoProd;
   }

   public void setUrlphotoProd(String var1) {
      this.urlphotoProd = var1;
   }

   public boolean isVar_aff_detail_tiers() {
      return this.var_aff_detail_tiers;
   }

   public void setVar_aff_detail_tiers(boolean var1) {
      this.var_aff_detail_tiers = var1;
   }

   public boolean isVar_pr_pv() {
      return this.var_pr_pv;
   }

   public void setVar_pr_pv(boolean var1) {
      this.var_pr_pv = var1;
   }

   public boolean isVar_sansstock() {
      return this.var_sansstock;
   }

   public void setVar_sansstock(boolean var1) {
      this.var_sansstock = var1;
   }

   public String getVerrouDepotUser() {
      return this.verrouDepotUser;
   }

   public void setVerrouDepotUser(String var1) {
      this.verrouDepotUser = var1;
   }

   public long getInpTiers() {
      return this.inpTiers;
   }

   public void setInpTiers(long var1) {
      this.inpTiers = var1;
   }

   public String getInpClient() {
      return this.inpClient;
   }

   public void setInpClient(String var1) {
      this.inpClient = var1;
   }

   public String getVar_onglet() {
      return this.var_onglet;
   }

   public void setVar_onglet(String var1) {
      this.var_onglet = var1;
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

   public long getVar_nom_contact() {
      return this.var_nom_contact;
   }

   public void setVar_nom_contact(long var1) {
      this.var_nom_contact = var1;
   }

   public List getMesContactItem() {
      return this.mesContactItem;
   }

   public void setMesContactItem(List var1) {
      this.mesContactItem = var1;
   }

   public boolean isVar_valide_doc() {
      return this.var_valide_doc;
   }

   public void setVar_valide_doc(boolean var1) {
      this.var_valide_doc = var1;
   }

   public String getInformationsTiers() {
      return this.informationsTiers;
   }

   public void setInformationsTiers(String var1) {
      this.informationsTiers = var1;
   }

   public String getNomTier() {
      return this.nomTier;
   }

   public void setNomTier(String var1) {
      this.nomTier = var1;
   }

   public DataModel getDatamodelLigne() {
      return this.datamodelLigne;
   }

   public void setDatamodelLigne(DataModel var1) {
      this.datamodelLigne = var1;
   }

   public ParcLocationLigne getParcLocationLigne() {
      return this.parcLocationLigne;
   }

   public void setParcLocationLigne(ParcLocationLigne var1) {
      this.parcLocationLigne = var1;
   }

   public OptionVentes getOptionsVentes() {
      return this.optionsVentes;
   }

   public void setOptionsVentes(OptionVentes var1) {
      this.optionsVentes = var1;
   }

   public String getLibelleRabRis() {
      return this.libelleRabRis;
   }

   public void setLibelleRabRis(String var1) {
      this.libelleRabRis = var1;
   }

   public boolean isRistourne() {
      return this.ristourne;
   }

   public void setRistourne(boolean var1) {
      this.ristourne = var1;
   }

   public boolean isVar_acc_complement() {
      return this.var_acc_complement;
   }

   public void setVar_acc_complement(boolean var1) {
      this.var_acc_complement = var1;
   }

   public boolean isVar_acc_document() {
      return this.var_acc_document;
   }

   public void setVar_acc_document(boolean var1) {
      this.var_acc_document = var1;
   }

   public boolean isVar_acc_dre() {
      return this.var_acc_dre;
   }

   public void setVar_acc_dre(boolean var1) {
      this.var_acc_dre = var1;
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

   public boolean isVar_acc_imputation() {
      return this.var_acc_imputation;
   }

   public void setVar_acc_imputation(boolean var1) {
      this.var_acc_imputation = var1;
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

   public boolean isVar_aff_condit() {
      return this.var_aff_condit;
   }

   public void setVar_aff_condit(boolean var1) {
      this.var_aff_condit = var1;
   }

   public boolean isVar_aff_unite() {
      return this.var_aff_unite;
   }

   public void setVar_aff_unite(boolean var1) {
      this.var_aff_unite = var1;
   }

   public boolean isVar_verrou_comm() {
      return this.var_verrou_comm;
   }

   public void setVar_verrou_comm(boolean var1) {
      this.var_verrou_comm = var1;
   }

   public boolean isVerrouPrvente() {
      return this.verrouPrvente;
   }

   public void setVerrouPrvente(boolean var1) {
      this.verrouPrvente = var1;
   }

   public boolean isVerrouRabais() {
      return this.verrouRabais;
   }

   public void setVerrouRabais(boolean var1) {
      this.verrouRabais = var1;
   }

   public boolean isVerrouRemise() {
      return this.verrouRemise;
   }

   public void setVerrouRemise(boolean var1) {
      this.verrouRemise = var1;
   }

   public boolean isVerrou_libelle() {
      return this.verrou_libelle;
   }

   public void setVerrou_libelle(boolean var1) {
      this.verrou_libelle = var1;
   }

   public double getVar_total_marge() {
      return this.var_total_marge;
   }

   public void setVar_total_marge(double var1) {
      this.var_total_marge = var1;
   }

   public boolean isVisibiliteBtonlig() {
      return this.visibiliteBtonlig;
   }

   public void setVisibiliteBtonlig(boolean var1) {
      this.visibiliteBtonlig = var1;
   }

   public boolean isGriserchamps() {
      return this.griserchamps;
   }

   public void setGriserchamps(boolean var1) {
      this.griserchamps = var1;
   }

   public List getMesTaxesVentesProduits() {
      return this.mesTaxesVentesProduits;
   }

   public void setMesTaxesVentesProduits(List var1) {
      this.mesTaxesVentesProduits = var1;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public boolean isAffichagePlancher() {
      return this.affichagePlancher;
   }

   public void setAffichagePlancher(boolean var1) {
      this.affichagePlancher = var1;
   }

   public boolean isGriserValider() {
      return this.griserValider;
   }

   public void setGriserValider(boolean var1) {
      this.griserValider = var1;
   }

   public int getVar_code_unite() {
      return this.var_code_unite;
   }

   public void setVar_code_unite(int var1) {
      this.var_code_unite = var1;
   }

   public DataModel getDataModelDocumnts() {
      return this.dataModelDocumnts;
   }

   public void setDataModelDocumnts(DataModel var1) {
      this.dataModelDocumnts = var1;
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

   public String getFileName() {
      return this.fileName;
   }

   public void setFileName(String var1) {
      this.fileName = var1;
   }

   public boolean isShowModalPanelAjoutFile() {
      return this.showModalPanelAjoutFile;
   }

   public void setShowModalPanelAjoutFile(boolean var1) {
      this.showModalPanelAjoutFile = var1;
   }

   public boolean isShowModalPanelPj() {
      return this.showModalPanelPj;
   }

   public void setShowModalPanelPj(boolean var1) {
      this.showModalPanelPj = var1;
   }

   public String getNomDocument() {
      return this.nomDocument;
   }

   public void setNomDocument(String var1) {
      this.nomDocument = var1;
   }

   public UploadedFile getUploadedPDFFile() {
      return this.uploadedPDFFile;
   }

   public void setUploadedPDFFile(UploadedFile var1) {
      this.uploadedPDFFile = var1;
   }
}
